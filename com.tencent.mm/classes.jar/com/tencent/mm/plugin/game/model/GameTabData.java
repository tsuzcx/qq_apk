package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.sdk.platformtools.bt;
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
  public LinkedHashMap<String, TabItem> rYp;
  public StatusBar rYq;
  
  static
  {
    AppMethodBeat.i(41570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(41570);
  }
  
  public GameTabData()
  {
    AppMethodBeat.i(41565);
    this.rYp = new LinkedHashMap();
    this.rYq = new StatusBar();
    AppMethodBeat.o(41565);
  }
  
  private GameTabData(Parcel paramParcel)
  {
    AppMethodBeat.i(41566);
    e(paramParcel);
    AppMethodBeat.o(41566);
  }
  
  public static GameTabData dQ(List<an> paramList)
  {
    AppMethodBeat.i(41569);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(41569);
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.cBm();
    if (localObject != null)
    {
      localGameTabData.rYq.rYr = ((de)localObject).rYr;
      localGameTabData.rYq.color = c.parseColor(((de)localObject).gHT);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      an localan = (an)((Iterator)localObject).next();
      if ((localan != null) && (!bt.isNullOrNil(localan.sbi)))
      {
        TabItem localTabItem = new TabItem();
        localTabItem.rYs = localan.sbi;
        localTabItem.title = localan.Title;
        localTabItem.rYt = localan.sbj;
        localTabItem.rYu = localan.sbk;
        localTabItem.jumpUrl = localan.rZo;
        localTabItem.rYx = localan.sbl;
        localTabItem.rYy = localan.sbm;
        if (localTabItem.rYu)
        {
          localTabItem.rYz = GameTabHomeUI.class.getName();
          localTabItem.rYA = false;
          localTabItem.dvS = localan.sbn;
          localTabItem.rYB = localan.rZY;
          localTabItem.rVj = localan.rZW;
          localGameTabData.rYp.put(localTabItem.rYs, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.rYz = paramList;
            i += 1;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(41569);
    return localGameTabData;
  }
  
  private void e(Parcel paramParcel)
  {
    AppMethodBeat.i(41567);
    int j = paramParcel.readInt();
    if (this.rYp == null) {
      this.rYp = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.rYp.put(localTabItem.rYs, localTabItem);
      }
      i += 1;
    }
    this.rYq = ((StatusBar)paramParcel.readParcelable(StatusBar.class.getClassLoader()));
    AppMethodBeat.o(41567);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final List<TabItem> getItemList()
  {
    AppMethodBeat.i(41564);
    ArrayList localArrayList = new ArrayList();
    if (this.rYp != null) {
      localArrayList.addAll(this.rYp.values());
    }
    AppMethodBeat.o(41564);
    return localArrayList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(41568);
    paramParcel.writeInt(this.rYp.size());
    Iterator localIterator = this.rYp.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.rYq, paramInt);
    AppMethodBeat.o(41568);
  }
  
  public static class StatusBar
    implements Parcelable
  {
    public static final Parcelable.Creator<StatusBar> CREATOR;
    public int color;
    public String rYr;
    
    static
    {
      AppMethodBeat.i(41559);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(41559);
    }
    
    public StatusBar()
    {
      this.rYr = null;
      this.color = 0;
    }
    
    public StatusBar(Parcel paramParcel)
    {
      AppMethodBeat.i(41557);
      this.rYr = null;
      this.color = 0;
      this.rYr = paramParcel.readString();
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
      paramParcel.writeString(this.rYr);
      paramParcel.writeInt(this.color);
      AppMethodBeat.o(41558);
    }
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public int dvS;
    public String jumpUrl;
    public String rVj;
    public boolean rYA;
    public int rYB;
    public String rYs;
    public boolean rYt;
    public boolean rYu;
    public int rYv;
    public int rYw;
    public String rYx;
    public String rYy;
    public String rYz;
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
      this.rYs = paramParcel.readString();
      this.title = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.rYt = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label58:
        this.rYu = bool1;
        this.rYv = paramParcel.readInt();
        this.rYw = paramParcel.readInt();
        this.rYx = paramParcel.readString();
        this.rYy = paramParcel.readString();
        this.rYz = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.rYA = bool1;
        this.dvS = paramParcel.readInt();
        this.rYB = paramParcel.readInt();
        this.rVj = paramParcel.readString();
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
      paramParcel.writeString(this.rYs);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jumpUrl);
      if (this.rYt)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.rYu) {
          break label151;
        }
        paramInt = 1;
        label55:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.rYv);
        paramParcel.writeInt(this.rYw);
        paramParcel.writeString(this.rYx);
        paramParcel.writeString(this.rYy);
        paramParcel.writeString(this.rYz);
        if (!this.rYA) {
          break label156;
        }
      }
      label151:
      label156:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.dvS);
        paramParcel.writeInt(this.rYB);
        paramParcel.writeString(this.rVj);
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