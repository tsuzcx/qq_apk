package com.tencent.mm.plugin.address.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RcptItem
  implements Parcelable
{
  public static final Parcelable.Creator<RcptItem> CREATOR;
  private static int qhM;
  public static int qhN;
  public static int qhO;
  static int qhP;
  private static int qhQ;
  public String code;
  public String name;
  public String qhL;
  public int qhR;
  public int type;
  
  static
  {
    AppMethodBeat.i(20800);
    qhM = -1;
    qhN = 0;
    qhO = 1;
    qhP = 2;
    qhQ = 3;
    CREATOR = new RcptItem.1();
    AppMethodBeat.o(20800);
  }
  
  public RcptItem(Parcel paramParcel)
  {
    AppMethodBeat.i(20798);
    this.name = "";
    this.code = "";
    this.qhL = "";
    this.type = qhM;
    this.qhR = 0;
    this.name = paramParcel.readString();
    this.code = paramParcel.readString();
    this.qhL = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.qhR = paramParcel.readInt();
    AppMethodBeat.o(20798);
  }
  
  public RcptItem(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(267135);
    this.name = "";
    this.code = "";
    this.qhL = "";
    this.type = qhM;
    this.qhR = 0;
    this.name = paramString1;
    this.code = paramString2;
    this.qhL = paramString3;
    if ((paramString2 != null) && (paramString2.endsWith("0000000")))
    {
      this.type = qhN;
      AppMethodBeat.o(267135);
      return;
    }
    if ((paramString2 != null) && (paramString2.endsWith("00000")))
    {
      this.type = qhO;
      this.qhR = (paramString2.substring(0, 2) + "0000000").hashCode();
      AppMethodBeat.o(267135);
      return;
    }
    if ((paramString2 != null) && (paramString2.endsWith("000")))
    {
      this.type = qhP;
      this.qhR = (paramString2.substring(0, 4) + "00000").hashCode();
      AppMethodBeat.o(267135);
      return;
    }
    this.type = qhQ;
    this.qhR = (paramString2.substring(0, 6) + "000").hashCode();
    AppMethodBeat.o(267135);
  }
  
  public final boolean bZh()
  {
    return this.type == qhQ;
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
    paramParcel.writeString(this.qhL);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.qhR);
    AppMethodBeat.o(20799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.RcptItem
 * JD-Core Version:    0.7.0.1
 */