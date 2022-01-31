package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.al;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class GameTabData
  implements Parcelable
{
  public static final Parcelable.Creator<GameTabData> CREATOR;
  public LinkedHashMap<String, GameTabData.TabItem> noU;
  public GameTabData.StatusBar noV;
  
  static
  {
    AppMethodBeat.i(111405);
    CREATOR = new GameTabData.1();
    AppMethodBeat.o(111405);
  }
  
  public GameTabData()
  {
    AppMethodBeat.i(111400);
    this.noU = new LinkedHashMap();
    this.noV = new GameTabData.StatusBar();
    AppMethodBeat.o(111400);
  }
  
  private GameTabData(Parcel paramParcel)
  {
    AppMethodBeat.i(111401);
    f(paramParcel);
    AppMethodBeat.o(111401);
  }
  
  public static GameTabData ca(List<al> paramList)
  {
    AppMethodBeat.i(111404);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(111404);
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.bFc();
    if (localObject != null)
    {
      localGameTabData.noV.noW = ((dd)localObject).noW;
      localGameTabData.noV.color = c.parseColor(((dd)localObject).color);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      al localal = (al)((Iterator)localObject).next();
      if ((localal != null) && (!bo.isNullOrNil(localal.nrD)))
      {
        GameTabData.TabItem localTabItem = new GameTabData.TabItem();
        localTabItem.noX = localal.nrD;
        localTabItem.title = localal.Title;
        localTabItem.noY = localal.nrE;
        localTabItem.noZ = localal.nrF;
        localTabItem.jumpUrl = localal.npR;
        localTabItem.npc = localal.nrG;
        localTabItem.npd = localal.nrH;
        if (localTabItem.noZ)
        {
          localTabItem.npe = GameTabHomeUI.class.getName();
          localTabItem.npf = false;
          localTabItem.cFj = localal.nrI;
          localTabItem.npg = localal.nqv;
          localTabItem.nml = localal.nqt;
          localGameTabData.noU.put(localTabItem.noX, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.npe = paramList;
            i += 1;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(111404);
    return localGameTabData;
  }
  
  private void f(Parcel paramParcel)
  {
    AppMethodBeat.i(111402);
    int j = paramParcel.readInt();
    if (this.noU == null) {
      this.noU = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      GameTabData.TabItem localTabItem = (GameTabData.TabItem)paramParcel.readParcelable(GameTabData.TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.noU.put(localTabItem.noX, localTabItem);
      }
      i += 1;
    }
    this.noV = ((GameTabData.StatusBar)paramParcel.readParcelable(GameTabData.StatusBar.class.getClassLoader()));
    AppMethodBeat.o(111402);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final List<GameTabData.TabItem> getItemList()
  {
    AppMethodBeat.i(111399);
    ArrayList localArrayList = new ArrayList();
    if (this.noU != null) {
      localArrayList.addAll(this.noU.values());
    }
    AppMethodBeat.o(111399);
    return localArrayList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111403);
    paramParcel.writeInt(this.noU.size());
    Iterator localIterator = this.noU.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.noV, paramInt);
    AppMethodBeat.o(111403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData
 * JD-Core Version:    0.7.0.1
 */