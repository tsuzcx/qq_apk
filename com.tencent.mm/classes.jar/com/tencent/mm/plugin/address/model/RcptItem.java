package com.tencent.mm.plugin.address.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RcptItem
  implements Parcelable
{
  public static final Parcelable.Creator<RcptItem> CREATOR;
  private static int nkD;
  public static int nkE;
  public static int nkF;
  static int nkG;
  private static int nkH;
  public String code;
  public String name;
  public String nkC;
  public int nkI;
  public int type;
  
  static
  {
    AppMethodBeat.i(20800);
    nkD = -1;
    nkE = 0;
    nkF = 1;
    nkG = 2;
    nkH = 3;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(20800);
  }
  
  public RcptItem(Parcel paramParcel)
  {
    AppMethodBeat.i(20798);
    this.name = "";
    this.code = "";
    this.nkC = "";
    this.type = nkD;
    this.nkI = 0;
    this.name = paramParcel.readString();
    this.code = paramParcel.readString();
    this.nkC = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.nkI = paramParcel.readInt();
    AppMethodBeat.o(20798);
  }
  
  public RcptItem(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(280220);
    this.name = "";
    this.code = "";
    this.nkC = "";
    this.type = nkD;
    this.nkI = 0;
    this.name = paramString1;
    this.code = paramString2;
    this.nkC = paramString3;
    if ((paramString2 != null) && (paramString2.endsWith("0000000")))
    {
      this.type = nkE;
      AppMethodBeat.o(280220);
      return;
    }
    if ((paramString2 != null) && (paramString2.endsWith("00000")))
    {
      this.type = nkF;
      this.nkI = (paramString2.substring(0, 2) + "0000000").hashCode();
      AppMethodBeat.o(280220);
      return;
    }
    if ((paramString2 != null) && (paramString2.endsWith("000")))
    {
      this.type = nkG;
      this.nkI = (paramString2.substring(0, 4) + "00000").hashCode();
      AppMethodBeat.o(280220);
      return;
    }
    this.type = nkH;
    this.nkI = (paramString2.substring(0, 6) + "000").hashCode();
    AppMethodBeat.o(280220);
  }
  
  public final boolean bAq()
  {
    return this.type == nkH;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(20799);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.code);
    paramParcel.writeString(this.nkC);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.nkI);
    AppMethodBeat.o(20799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.RcptItem
 * JD-Core Version:    0.7.0.1
 */