package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.protobuf.ay;
import com.tencent.mm.plugin.game.protobuf.ea;
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
  public LinkedHashMap<String, TabItem> IFI;
  public StatusBar IFJ;
  
  static
  {
    AppMethodBeat.i(41570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(41570);
  }
  
  public GameTabData()
  {
    AppMethodBeat.i(41565);
    this.IFI = new LinkedHashMap();
    this.IFJ = new StatusBar();
    AppMethodBeat.o(41565);
  }
  
  private GameTabData(Parcel paramParcel)
  {
    AppMethodBeat.i(41566);
    h(paramParcel);
    AppMethodBeat.o(41566);
  }
  
  private void h(Parcel paramParcel)
  {
    AppMethodBeat.i(41567);
    int j = paramParcel.readInt();
    if (this.IFI == null) {
      this.IFI = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.IFI.put(localTabItem.IFL, localTabItem);
      }
      i += 1;
    }
    this.IFJ = ((StatusBar)paramParcel.readParcelable(StatusBar.class.getClassLoader()));
    AppMethodBeat.o(41567);
  }
  
  public static GameTabData is(List<ay> paramList)
  {
    AppMethodBeat.i(41569);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(41569);
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.fDS();
    if (localObject != null)
    {
      localGameTabData.IFJ.IFK = ((ea)localObject).IFK;
      localGameTabData.IFJ.color = c.aHm(((ea)localObject).nRQ);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ay localay = (ay)((Iterator)localObject).next();
      if ((localay != null) && (!Util.isNullOrNil(localay.IJd)))
      {
        TabItem localTabItem = new TabItem();
        localTabItem.IFL = localay.IJd;
        localTabItem.title = localay.hAP;
        localTabItem.IFM = localay.IJe;
        localTabItem.IFN = localay.IJf;
        localTabItem.jumpUrl = localay.IGI;
        localTabItem.IFQ = localay.IJg;
        localTabItem.IFR = localay.IJh;
        if (localTabItem.IFN)
        {
          localTabItem.IFS = GameTabHomeUI.class.getName();
          localTabItem.IFT = false;
          localTabItem.hYi = localay.IJi;
          localTabItem.IFU = localay.IHK;
          localTabItem.ICw = localay.IHI;
          localGameTabData.IFI.put(localTabItem.IFL, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.IFS = paramList;
            i += 1;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(41569);
    return localGameTabData;
  }
  
  public final List<TabItem> aVf()
  {
    AppMethodBeat.i(41564);
    ArrayList localArrayList = new ArrayList();
    if (this.IFI != null) {
      localArrayList.addAll(this.IFI.values());
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
    paramParcel.writeInt(this.IFI.size());
    Iterator localIterator = this.IFI.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.IFJ, paramInt);
    AppMethodBeat.o(41568);
  }
  
  public static class StatusBar
    implements Parcelable
  {
    public static final Parcelable.Creator<StatusBar> CREATOR;
    public String IFK;
    public int color;
    
    static
    {
      AppMethodBeat.i(41559);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(41559);
    }
    
    public StatusBar()
    {
      this.IFK = null;
      this.color = 0;
    }
    
    public StatusBar(Parcel paramParcel)
    {
      AppMethodBeat.i(41557);
      this.IFK = null;
      this.color = 0;
      this.IFK = paramParcel.readString();
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
      paramParcel.writeString(this.IFK);
      paramParcel.writeInt(this.color);
      AppMethodBeat.o(41558);
    }
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public String ICw;
    public String IFL;
    public boolean IFM;
    public boolean IFN;
    public int IFO;
    public int IFP;
    public String IFQ;
    public String IFR;
    public String IFS;
    public boolean IFT;
    public int IFU;
    public int hYi;
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
      this.IFL = paramParcel.readString();
      this.title = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.IFM = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label58:
        this.IFN = bool1;
        this.IFO = paramParcel.readInt();
        this.IFP = paramParcel.readInt();
        this.IFQ = paramParcel.readString();
        this.IFR = paramParcel.readString();
        this.IFS = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.IFT = bool1;
        this.hYi = paramParcel.readInt();
        this.IFU = paramParcel.readInt();
        this.ICw = paramParcel.readString();
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
      paramParcel.writeString(this.IFL);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jumpUrl);
      if (this.IFM)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.IFN) {
          break label151;
        }
        paramInt = 1;
        label55:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.IFO);
        paramParcel.writeInt(this.IFP);
        paramParcel.writeString(this.IFQ);
        paramParcel.writeString(this.IFR);
        paramParcel.writeString(this.IFS);
        if (!this.IFT) {
          break label156;
        }
      }
      label151:
      label156:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.hYi);
        paramParcel.writeInt(this.IFU);
        paramParcel.writeString(this.ICw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData
 * JD-Core Version:    0.7.0.1
 */