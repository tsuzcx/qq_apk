package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.protobuf.ax;
import com.tencent.mm.plugin.game.protobuf.dw;
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
  public LinkedHashMap<String, TabItem> CLB;
  public StatusBar CLC;
  
  static
  {
    AppMethodBeat.i(41570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(41570);
  }
  
  public GameTabData()
  {
    AppMethodBeat.i(41565);
    this.CLB = new LinkedHashMap();
    this.CLC = new StatusBar();
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
    if (this.CLB == null) {
      this.CLB = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.CLB.put(localTabItem.CLE, localTabItem);
      }
      i += 1;
    }
    this.CLC = ((StatusBar)paramParcel.readParcelable(StatusBar.class.getClassLoader()));
    AppMethodBeat.o(41567);
  }
  
  public static GameTabData fw(List<ax> paramList)
  {
    AppMethodBeat.i(41569);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(41569);
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.ewc();
    if (localObject != null)
    {
      localGameTabData.CLC.CLD = ((dw)localObject).CLD;
      localGameTabData.CLC.color = c.aIQ(((dw)localObject).lmL);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ax localax = (ax)((Iterator)localObject).next();
      if ((localax != null) && (!Util.isNullOrNil(localax.COT)))
      {
        TabItem localTabItem = new TabItem();
        localTabItem.CLE = localax.COT;
        localTabItem.title = localax.fwr;
        localTabItem.CLF = localax.COU;
        localTabItem.CLG = localax.COV;
        localTabItem.jumpUrl = localax.CMD;
        localTabItem.CLJ = localax.COW;
        localTabItem.CLK = localax.COX;
        if (localTabItem.CLG)
        {
          localTabItem.CLL = GameTabHomeUI.class.getName();
          localTabItem.CLM = false;
          localTabItem.fSl = localax.COY;
          localTabItem.CLN = localax.CNC;
          localTabItem.CIm = localax.CNA;
          localGameTabData.CLB.put(localTabItem.CLE, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.CLL = paramList;
            i += 1;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(41569);
    return localGameTabData;
  }
  
  public final List<TabItem> aCj()
  {
    AppMethodBeat.i(41564);
    ArrayList localArrayList = new ArrayList();
    if (this.CLB != null) {
      localArrayList.addAll(this.CLB.values());
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
    paramParcel.writeInt(this.CLB.size());
    Iterator localIterator = this.CLB.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.CLC, paramInt);
    AppMethodBeat.o(41568);
  }
  
  public static class StatusBar
    implements Parcelable
  {
    public static final Parcelable.Creator<StatusBar> CREATOR;
    public String CLD;
    public int color;
    
    static
    {
      AppMethodBeat.i(41559);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(41559);
    }
    
    public StatusBar()
    {
      this.CLD = null;
      this.color = 0;
    }
    
    public StatusBar(Parcel paramParcel)
    {
      AppMethodBeat.i(41557);
      this.CLD = null;
      this.color = 0;
      this.CLD = paramParcel.readString();
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
      paramParcel.writeString(this.CLD);
      paramParcel.writeInt(this.color);
      AppMethodBeat.o(41558);
    }
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public String CIm;
    public String CLE;
    public boolean CLF;
    public boolean CLG;
    public int CLH;
    public int CLI;
    public String CLJ;
    public String CLK;
    public String CLL;
    public boolean CLM;
    public int CLN;
    public int fSl;
    public String jumpUrl;
    public String title;
    
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
      this.CLE = paramParcel.readString();
      this.title = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.CLF = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label58:
        this.CLG = bool1;
        this.CLH = paramParcel.readInt();
        this.CLI = paramParcel.readInt();
        this.CLJ = paramParcel.readString();
        this.CLK = paramParcel.readString();
        this.CLL = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.CLM = bool1;
        this.fSl = paramParcel.readInt();
        this.CLN = paramParcel.readInt();
        this.CIm = paramParcel.readString();
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
      paramParcel.writeString(this.CLE);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jumpUrl);
      if (this.CLF)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.CLG) {
          break label151;
        }
        paramInt = 1;
        label55:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.CLH);
        paramParcel.writeInt(this.CLI);
        paramParcel.writeString(this.CLJ);
        paramParcel.writeString(this.CLK);
        paramParcel.writeString(this.CLL);
        if (!this.CLM) {
          break label156;
        }
      }
      label151:
      label156:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.fSl);
        paramParcel.writeInt(this.CLN);
        paramParcel.writeString(this.CIm);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData
 * JD-Core Version:    0.7.0.1
 */