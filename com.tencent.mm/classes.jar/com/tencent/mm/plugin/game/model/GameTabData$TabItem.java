package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameTabData$TabItem
  implements Parcelable
{
  public static final Parcelable.Creator<TabItem> CREATOR;
  public int cFj;
  public String jumpUrl;
  public String nml;
  public String noX;
  public boolean noY;
  public boolean noZ;
  public int npa;
  public int npb;
  public String npc;
  public String npd;
  public String npe;
  public boolean npf;
  public int npg;
  public String title;
  
  static
  {
    AppMethodBeat.i(111398);
    CREATOR = new GameTabData.TabItem.1();
    AppMethodBeat.o(111398);
  }
  
  public GameTabData$TabItem() {}
  
  public GameTabData$TabItem(Parcel paramParcel)
  {
    AppMethodBeat.i(111396);
    this.noX = paramParcel.readString();
    this.title = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.noY = bool1;
      if (paramParcel.readByte() == 0) {
        break label152;
      }
      bool1 = true;
      label58:
      this.noZ = bool1;
      this.npa = paramParcel.readInt();
      this.npb = paramParcel.readInt();
      this.npc = paramParcel.readString();
      this.npd = paramParcel.readString();
      this.npe = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.npf = bool1;
      this.cFj = paramParcel.readInt();
      this.npg = paramParcel.readInt();
      this.nml = paramParcel.readString();
      AppMethodBeat.o(111396);
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
    AppMethodBeat.i(111397);
    paramParcel.writeString(this.noX);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.jumpUrl);
    if (this.noY)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.noZ) {
        break label151;
      }
      paramInt = 1;
      label55:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.npa);
      paramParcel.writeInt(this.npb);
      paramParcel.writeString(this.npc);
      paramParcel.writeString(this.npd);
      paramParcel.writeString(this.npe);
      if (!this.npf) {
        break label156;
      }
    }
    label151:
    label156:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.cFj);
      paramParcel.writeInt(this.npg);
      paramParcel.writeString(this.nml);
      AppMethodBeat.o(111397);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData.TabItem
 * JD-Core Version:    0.7.0.1
 */