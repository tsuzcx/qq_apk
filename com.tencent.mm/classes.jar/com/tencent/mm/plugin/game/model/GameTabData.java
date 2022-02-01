package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.protobuf.aw;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.sdk.platformtools.Util;
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
  public LinkedHashMap<String, TabItem> xHy;
  public StatusBar xHz;
  
  static
  {
    AppMethodBeat.i(41570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(41570);
  }
  
  public GameTabData()
  {
    AppMethodBeat.i(41565);
    this.xHy = new LinkedHashMap();
    this.xHz = new StatusBar();
    AppMethodBeat.o(41565);
  }
  
  private GameTabData(Parcel paramParcel)
  {
    AppMethodBeat.i(41566);
    f(paramParcel);
    AppMethodBeat.o(41566);
  }
  
  private void f(Parcel paramParcel)
  {
    AppMethodBeat.i(41567);
    int j = paramParcel.readInt();
    if (this.xHy == null) {
      this.xHy = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.xHy.put(localTabItem.xHB, localTabItem);
      }
      i += 1;
    }
    this.xHz = ((StatusBar)paramParcel.readParcelable(StatusBar.class.getClassLoader()));
    AppMethodBeat.o(41567);
  }
  
  public static GameTabData fb(List<aw> paramList)
  {
    AppMethodBeat.i(41569);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(41569);
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.dSU();
    if (localObject != null)
    {
      localGameTabData.xHz.xHA = ((dv)localObject).xHA;
      localGameTabData.xHz.color = c.parseColor(((dv)localObject).ixw);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      aw localaw = (aw)((Iterator)localObject).next();
      if ((localaw != null) && (!Util.isNullOrNil(localaw.xKM)))
      {
        TabItem localTabItem = new TabItem();
        localTabItem.xHB = localaw.xKM;
        localTabItem.title = localaw.Title;
        localTabItem.xHC = localaw.xKN;
        localTabItem.xHD = localaw.xKO;
        localTabItem.jumpUrl = localaw.xIy;
        localTabItem.xHG = localaw.xKP;
        localTabItem.xHH = localaw.xKQ;
        if (localTabItem.xHD)
        {
          localTabItem.xHI = GameTabHomeUI.class.getName();
          localTabItem.xHJ = false;
          localTabItem.dYu = localaw.xKR;
          localTabItem.xHK = localaw.xJv;
          localTabItem.xEl = localaw.xJt;
          localGameTabData.xHy.put(localTabItem.xHB, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.xHI = paramList;
            i += 1;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(41569);
    return localGameTabData;
  }
  
  public final List<TabItem> avn()
  {
    AppMethodBeat.i(41564);
    ArrayList localArrayList = new ArrayList();
    if (this.xHy != null) {
      localArrayList.addAll(this.xHy.values());
    }
    AppMethodBeat.o(41564);
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(41568);
    paramParcel.writeInt(this.xHy.size());
    Iterator localIterator = this.xHy.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.xHz, paramInt);
    AppMethodBeat.o(41568);
  }
  
  public static class StatusBar
    implements Parcelable
  {
    public static final Parcelable.Creator<StatusBar> CREATOR;
    public int color;
    public String xHA;
    
    static
    {
      AppMethodBeat.i(41559);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(41559);
    }
    
    public StatusBar()
    {
      this.xHA = null;
      this.color = 0;
    }
    
    public StatusBar(Parcel paramParcel)
    {
      AppMethodBeat.i(41557);
      this.xHA = null;
      this.color = 0;
      this.xHA = paramParcel.readString();
      this.color = paramParcel.readInt();
      AppMethodBeat.o(41557);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(41558);
      paramParcel.writeString(this.xHA);
      paramParcel.writeInt(this.color);
      AppMethodBeat.o(41558);
    }
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public int dYu;
    public String jumpUrl;
    public String title;
    public String xEl;
    public String xHB;
    public boolean xHC;
    public boolean xHD;
    public int xHE;
    public int xHF;
    public String xHG;
    public String xHH;
    public String xHI;
    public boolean xHJ;
    public int xHK;
    
    static
    {
      AppMethodBeat.i(41563);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(41563);
    }
    
    public TabItem() {}
    
    public TabItem(Parcel paramParcel)
    {
      AppMethodBeat.i(41561);
      this.xHB = paramParcel.readString();
      this.title = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.xHC = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label58:
        this.xHD = bool1;
        this.xHE = paramParcel.readInt();
        this.xHF = paramParcel.readInt();
        this.xHG = paramParcel.readString();
        this.xHH = paramParcel.readString();
        this.xHI = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.xHJ = bool1;
        this.dYu = paramParcel.readInt();
        this.xHK = paramParcel.readInt();
        this.xEl = paramParcel.readString();
        AppMethodBeat.o(41561);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label58;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(41562);
      paramParcel.writeString(this.xHB);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jumpUrl);
      if (this.xHC)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.xHD) {
          break label151;
        }
        paramInt = 1;
        label55:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.xHE);
        paramParcel.writeInt(this.xHF);
        paramParcel.writeString(this.xHG);
        paramParcel.writeString(this.xHH);
        paramParcel.writeString(this.xHI);
        if (!this.xHJ) {
          break label156;
        }
      }
      label151:
      label156:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.dYu);
        paramParcel.writeInt(this.xHK);
        paramParcel.writeString(this.xEl);
        AppMethodBeat.o(41562);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label55;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData
 * JD-Core Version:    0.7.0.1
 */