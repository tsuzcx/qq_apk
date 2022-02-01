package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.dv;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.sdk.platformtools.bu;
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
  public LinkedHashMap<String, TabItem> upf;
  public StatusBar upg;
  
  static
  {
    AppMethodBeat.i(41570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(41570);
  }
  
  public GameTabData()
  {
    AppMethodBeat.i(41565);
    this.upf = new LinkedHashMap();
    this.upg = new StatusBar();
    AppMethodBeat.o(41565);
  }
  
  private GameTabData(Parcel paramParcel)
  {
    AppMethodBeat.i(41566);
    e(paramParcel);
    AppMethodBeat.o(41566);
  }
  
  private void e(Parcel paramParcel)
  {
    AppMethodBeat.i(41567);
    int j = paramParcel.readInt();
    if (this.upf == null) {
      this.upf = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.upf.put(localTabItem.upi, localTabItem);
      }
      i += 1;
    }
    this.upg = ((StatusBar)paramParcel.readParcelable(StatusBar.class.getClassLoader()));
    AppMethodBeat.o(41567);
  }
  
  public static GameTabData ei(List<av> paramList)
  {
    AppMethodBeat.i(41569);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(41569);
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.cZu();
    if (localObject != null)
    {
      localGameTabData.upg.uph = ((dv)localObject).uph;
      localGameTabData.upg.color = c.parseColor(((dv)localObject).hDr);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      av localav = (av)((Iterator)localObject).next();
      if ((localav != null) && (!bu.isNullOrNil(localav.usu)))
      {
        TabItem localTabItem = new TabItem();
        localTabItem.upi = localav.usu;
        localTabItem.title = localav.Title;
        localTabItem.upj = localav.usv;
        localTabItem.upk = localav.usw;
        localTabItem.jumpUrl = localav.uqf;
        localTabItem.upn = localav.usx;
        localTabItem.upo = localav.usy;
        if (localTabItem.upk)
        {
          localTabItem.upp = GameTabHomeUI.class.getName();
          localTabItem.upq = false;
          localTabItem.dGL = localav.usz;
          localTabItem.upr = localav.urc;
          localTabItem.ulT = localav.ura;
          localGameTabData.upf.put(localTabItem.upi, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.upp = paramList;
            i += 1;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(41569);
    return localGameTabData;
  }
  
  public final List<TabItem> afz()
  {
    AppMethodBeat.i(41564);
    ArrayList localArrayList = new ArrayList();
    if (this.upf != null) {
      localArrayList.addAll(this.upf.values());
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
    paramParcel.writeInt(this.upf.size());
    Iterator localIterator = this.upf.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.upg, paramInt);
    AppMethodBeat.o(41568);
  }
  
  public static class StatusBar
    implements Parcelable
  {
    public static final Parcelable.Creator<StatusBar> CREATOR;
    public int color;
    public String uph;
    
    static
    {
      AppMethodBeat.i(41559);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(41559);
    }
    
    public StatusBar()
    {
      this.uph = null;
      this.color = 0;
    }
    
    public StatusBar(Parcel paramParcel)
    {
      AppMethodBeat.i(41557);
      this.uph = null;
      this.color = 0;
      this.uph = paramParcel.readString();
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
      paramParcel.writeString(this.uph);
      paramParcel.writeInt(this.color);
      AppMethodBeat.o(41558);
    }
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public int dGL;
    public String jumpUrl;
    public String title;
    public String ulT;
    public String upi;
    public boolean upj;
    public boolean upk;
    public int upl;
    public int upm;
    public String upn;
    public String upo;
    public String upp;
    public boolean upq;
    public int upr;
    
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
      this.upi = paramParcel.readString();
      this.title = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.upj = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label58:
        this.upk = bool1;
        this.upl = paramParcel.readInt();
        this.upm = paramParcel.readInt();
        this.upn = paramParcel.readString();
        this.upo = paramParcel.readString();
        this.upp = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.upq = bool1;
        this.dGL = paramParcel.readInt();
        this.upr = paramParcel.readInt();
        this.ulT = paramParcel.readString();
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
      paramParcel.writeString(this.upi);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jumpUrl);
      if (this.upj)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.upk) {
          break label151;
        }
        paramInt = 1;
        label55:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.upl);
        paramParcel.writeInt(this.upm);
        paramParcel.writeString(this.upn);
        paramParcel.writeString(this.upo);
        paramParcel.writeString(this.upp);
        if (!this.upq) {
          break label156;
        }
      }
      label151:
      label156:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.dGL);
        paramParcel.writeInt(this.upr);
        paramParcel.writeString(this.ulT);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData
 * JD-Core Version:    0.7.0.1
 */