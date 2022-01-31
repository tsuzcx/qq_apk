package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ModulePkgInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<ModulePkgInfo> CREATOR;
  public boolean cnm;
  public String cqq;
  public PartialFile[] gUA;
  public volatile String gUy;
  public String[] gUz;
  public String name;
  
  static
  {
    AppMethodBeat.i(105311);
    CREATOR = new ModulePkgInfo.1();
    AppMethodBeat.o(105311);
  }
  
  public ModulePkgInfo() {}
  
  private ModulePkgInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(105309);
    readFromParcel(paramParcel);
    AppMethodBeat.o(105309);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(105308);
    this.gUy = paramParcel.readString();
    this.name = paramParcel.readString();
    this.cqq = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.cnm = bool;
      this.gUz = paramParcel.createStringArray();
      this.gUA = ((PartialFile[])paramParcel.createTypedArray(PartialFile.CREATOR));
      AppMethodBeat.o(105308);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105307);
    paramParcel.writeString(this.gUy);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.cqq);
    if (this.cnm) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeStringArray(this.gUz);
      paramParcel.writeTypedArray(this.gUA, 0);
      AppMethodBeat.o(105307);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
 * JD-Core Version:    0.7.0.1
 */