package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class GameTabData
  implements Parcelable
{
  public static final Parcelable.Creator<GameTabData> CREATOR = new GameTabData.1();
  public LinkedHashMap<String, GameTabData.TabItem> kQQ;
  public GameTabData.StatusBar kQR;
  
  public GameTabData()
  {
    this.kQQ = new LinkedHashMap();
    this.kQR = new GameTabData.StatusBar();
  }
  
  private GameTabData(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public static GameTabData bD(List<ak> paramList)
  {
    if (bk.dk(paramList)) {
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.aYn();
    if (localObject != null)
    {
      localGameTabData.kQR.kQS = ((dc)localObject).kQS;
      localGameTabData.kQR.color = c.parseColor(((dc)localObject).color);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ak localak = (ak)((Iterator)localObject).next();
      if ((localak != null) && (!bk.bl(localak.kTD)))
      {
        GameTabData.TabItem localTabItem = new GameTabData.TabItem();
        localTabItem.kQT = localak.kTD;
        localTabItem.title = localak.bGw;
        localTabItem.kQU = localak.kTE;
        localTabItem.kQV = localak.kTF;
        localTabItem.jumpUrl = localak.kRP;
        localTabItem.kQY = localak.kTG;
        localTabItem.kQZ = localak.kTH;
        if (localTabItem.kQV)
        {
          localTabItem.kRa = GameTabHomeUI.class.getName();
          localTabItem.kRb = false;
          localTabItem.bXn = localak.kTI;
          localTabItem.kRc = localak.kSu;
          localTabItem.kOo = localak.kSs;
          localGameTabData.kQQ.put(localTabItem.kQT, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.kRa = paramList;
            i += 1;
            break;
          }
        }
      }
    }
    return localGameTabData;
  }
  
  private void e(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    if (this.kQQ == null) {
      this.kQQ = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      GameTabData.TabItem localTabItem = (GameTabData.TabItem)paramParcel.readParcelable(GameTabData.TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.kQQ.put(localTabItem.kQT, localTabItem);
      }
      i += 1;
    }
    this.kQR = ((GameTabData.StatusBar)paramParcel.readParcelable(GameTabData.StatusBar.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final List<GameTabData.TabItem> getItemList()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.kQQ != null) {
      localArrayList.addAll(this.kQQ.values());
    }
    return localArrayList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.kQQ.size());
    Iterator localIterator = this.kQQ.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.kQR, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData
 * JD-Core Version:    0.7.0.1
 */