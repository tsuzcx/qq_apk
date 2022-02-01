package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.dm;
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
  public LinkedHashMap<String, TabItem> udX;
  public StatusBar udY;
  
  static
  {
    AppMethodBeat.i(41570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(41570);
  }
  
  public GameTabData()
  {
    AppMethodBeat.i(41565);
    this.udX = new LinkedHashMap();
    this.udY = new StatusBar();
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
    if (this.udX == null) {
      this.udX = new LinkedHashMap();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.udX.put(localTabItem.uea, localTabItem);
      }
      i += 1;
    }
    this.udY = ((StatusBar)paramParcel.readParcelable(StatusBar.class.getClassLoader()));
    AppMethodBeat.o(41567);
  }
  
  public static GameTabData ee(List<ap> paramList)
  {
    AppMethodBeat.i(41569);
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(41569);
      return null;
    }
    GameTabData localGameTabData = new GameTabData();
    Object localObject = a.cWQ();
    if (localObject != null)
    {
      localGameTabData.udY.udZ = ((dm)localObject).udZ;
      localGameTabData.udY.color = c.parseColor(((dm)localObject).hAD);
    }
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ap localap = (ap)((Iterator)localObject).next();
      if ((localap != null) && (!bt.isNullOrNil(localap.ugX)))
      {
        TabItem localTabItem = new TabItem();
        localTabItem.uea = localap.ugX;
        localTabItem.title = localap.Title;
        localTabItem.ueb = localap.ugY;
        localTabItem.uec = localap.ugZ;
        localTabItem.jumpUrl = localap.ueY;
        localTabItem.uef = localap.uha;
        localTabItem.ueg = localap.uhb;
        if (localTabItem.uec)
        {
          localTabItem.uei = GameTabHomeUI.class.getName();
          localTabItem.uej = false;
          localTabItem.dFG = localap.uhc;
          localTabItem.uek = localap.ufI;
          localTabItem.uaR = localap.ufG;
          localGameTabData.udX.put(localTabItem.uea, localTabItem);
        }
        else
        {
          int j = i % 3;
          StringBuilder localStringBuilder = new StringBuilder("com.tencent.mm.plugin.game.ui.tab.GameTabWebUI");
          if (j != 0) {}
          for (paramList = String.valueOf(j);; paramList = "")
          {
            localTabItem.uei = paramList;
            i += 1;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(41569);
    return localGameTabData;
  }
  
  public final List<TabItem> afl()
  {
    AppMethodBeat.i(41564);
    ArrayList localArrayList = new ArrayList();
    if (this.udX != null) {
      localArrayList.addAll(this.udX.values());
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
    paramParcel.writeInt(this.udX.size());
    Iterator localIterator = this.udX.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeParcelable(this.udY, paramInt);
    AppMethodBeat.o(41568);
  }
  
  public static class StatusBar
    implements Parcelable
  {
    public static final Parcelable.Creator<StatusBar> CREATOR;
    public int color;
    public String udZ;
    
    static
    {
      AppMethodBeat.i(41559);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(41559);
    }
    
    public StatusBar()
    {
      this.udZ = null;
      this.color = 0;
    }
    
    public StatusBar(Parcel paramParcel)
    {
      AppMethodBeat.i(41557);
      this.udZ = null;
      this.color = 0;
      this.udZ = paramParcel.readString();
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
      paramParcel.writeString(this.udZ);
      paramParcel.writeInt(this.color);
      AppMethodBeat.o(41558);
    }
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public int dFG;
    public String jumpUrl;
    public String title;
    public String uaR;
    public String uea;
    public boolean ueb;
    public boolean uec;
    public int ued;
    public int uee;
    public String uef;
    public String ueg;
    public String uei;
    public boolean uej;
    public int uek;
    
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
      this.uea = paramParcel.readString();
      this.title = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.ueb = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label58:
        this.uec = bool1;
        this.ued = paramParcel.readInt();
        this.uee = paramParcel.readInt();
        this.uef = paramParcel.readString();
        this.ueg = paramParcel.readString();
        this.uei = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.uej = bool1;
        this.dFG = paramParcel.readInt();
        this.uek = paramParcel.readInt();
        this.uaR = paramParcel.readString();
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
      paramParcel.writeString(this.uea);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jumpUrl);
      if (this.ueb)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.uec) {
          break label151;
        }
        paramInt = 1;
        label55:
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.ued);
        paramParcel.writeInt(this.uee);
        paramParcel.writeString(this.uef);
        paramParcel.writeString(this.ueg);
        paramParcel.writeString(this.uei);
        if (!this.uej) {
          break label156;
        }
      }
      label151:
      label156:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.dFG);
        paramParcel.writeInt(this.uek);
        paramParcel.writeString(this.uaR);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData
 * JD-Core Version:    0.7.0.1
 */