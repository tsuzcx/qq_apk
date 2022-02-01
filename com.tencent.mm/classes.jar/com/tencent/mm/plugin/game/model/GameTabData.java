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
import com.tencent.mm.sdk.platformtools.bs;
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
  public LinkedHashMap<String, TabItem> tgh;
  public StatusBar tgi;
  
  static
  {
    AppMethodBeat.i(41570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(41570);
  }
  
  public GameTabData()
  {
    AppMethodBeat.i(41565);
    this.tgh = new LinkedHashMap();
    this.tgi = new StatusBar();
    AppMethodBeat.o(41565);
  }
  
  private GameTabData(Parcel paramParcel)
  {
    AppMethodBeat.i(41566);
    e(paramParcel);
    AppMethodBeat.o(41566);
  }
  
  public static GameTabData dU(List<an> paramList)
  {
    AppMethodBeat.i(41569);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(41569);
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.cOv();
    if (localObject != null)
    {
      localGameTabData.tgi.tgj = ((de)localObject).tgj;
      localGameTabData.tgi.color = c.parseColor(((de)localObject).hiu);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      an localan = (an)((Iterator)localObject).next();
      if ((localan != null) && (!bs.isNullOrNil(localan.tjc)))
      {
        TabItem localTabItem = new TabItem();
        localTabItem.tgk = localan.tjc;
        localTabItem.title = localan.Title;
        localTabItem.tgl = localan.tjd;
        localTabItem.tgm = localan.tje;
        localTabItem.jumpUrl = localan.thh;
        localTabItem.tgp = localan.tjf;
        localTabItem.tgq = localan.tjg;
        if (localTabItem.tgm)
        {
          localTabItem.tgr = GameTabHomeUI.class.getName();
          localTabItem.tgs = false;
          localTabItem.dtF = localan.tjh;
          localTabItem.tgt = localan.thR;
          localTabItem.tdb = localan.thP;
          localGameTabData.tgh.put(localTabItem.tgk, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.tgr = paramList;
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
    if (this.tgh == null) {
      this.tgh = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.tgh.put(localTabItem.tgk, localTabItem);
      }
      i += 1;
    }
    this.tgi = ((StatusBar)paramParcel.readParcelable(StatusBar.class.getClassLoader()));
    AppMethodBeat.o(41567);
  }
  
  public final List<TabItem> acH()
  {
    AppMethodBeat.i(41564);
    ArrayList localArrayList = new ArrayList();
    if (this.tgh != null) {
      localArrayList.addAll(this.tgh.values());
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
    paramParcel.writeInt(this.tgh.size());
    Iterator localIterator = this.tgh.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.tgi, paramInt);
    AppMethodBeat.o(41568);
  }
  
  public static class StatusBar
    implements Parcelable
  {
    public static final Parcelable.Creator<StatusBar> CREATOR;
    public int color;
    public String tgj;
    
    static
    {
      AppMethodBeat.i(41559);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(41559);
    }
    
    public StatusBar()
    {
      this.tgj = null;
      this.color = 0;
    }
    
    public StatusBar(Parcel paramParcel)
    {
      AppMethodBeat.i(41557);
      this.tgj = null;
      this.color = 0;
      this.tgj = paramParcel.readString();
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
      paramParcel.writeString(this.tgj);
      paramParcel.writeInt(this.color);
      AppMethodBeat.o(41558);
    }
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public int dtF;
    public String jumpUrl;
    public String tdb;
    public String tgk;
    public boolean tgl;
    public boolean tgm;
    public int tgn;
    public int tgo;
    public String tgp;
    public String tgq;
    public String tgr;
    public boolean tgs;
    public int tgt;
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
      this.tgk = paramParcel.readString();
      this.title = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.tgl = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label58:
        this.tgm = bool1;
        this.tgn = paramParcel.readInt();
        this.tgo = paramParcel.readInt();
        this.tgp = paramParcel.readString();
        this.tgq = paramParcel.readString();
        this.tgr = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.tgs = bool1;
        this.dtF = paramParcel.readInt();
        this.tgt = paramParcel.readInt();
        this.tdb = paramParcel.readString();
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
      paramParcel.writeString(this.tgk);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jumpUrl);
      if (this.tgl)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.tgm) {
          break label151;
        }
        paramInt = 1;
        label55:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.tgn);
        paramParcel.writeInt(this.tgo);
        paramParcel.writeString(this.tgp);
        paramParcel.writeString(this.tgq);
        paramParcel.writeString(this.tgr);
        if (!this.tgs) {
          break label156;
        }
      }
      label151:
      label156:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.dtF);
        paramParcel.writeInt(this.tgt);
        paramParcel.writeString(this.tdb);
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