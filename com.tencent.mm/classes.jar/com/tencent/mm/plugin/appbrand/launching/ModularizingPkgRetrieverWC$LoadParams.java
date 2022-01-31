package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ModularizingPkgRetrieverWC$LoadParams
  implements Parcelable
{
  public static final Parcelable.Creator<LoadParams> CREATOR;
  public final String appId;
  public final int cvs;
  public final String gVh;
  public final int gXf;
  
  static
  {
    AppMethodBeat.i(131935);
    CREATOR = new ModularizingPkgRetrieverWC.LoadParams.1();
    AppMethodBeat.o(131935);
  }
  
  ModularizingPkgRetrieverWC$LoadParams(Parcel paramParcel)
  {
    AppMethodBeat.i(131933);
    this.appId = paramParcel.readString();
    this.cvs = paramParcel.readInt();
    this.gXf = paramParcel.readInt();
    this.gVh = paramParcel.readString();
    AppMethodBeat.o(131933);
  }
  
  private ModularizingPkgRetrieverWC$LoadParams(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.appId = paramString1;
    this.cvs = paramInt1;
    this.gXf = paramInt2;
    this.gVh = paramString2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(131934);
    String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.cvs + ", pkgVersion=" + this.gXf + ", moduleName='" + this.gVh + '\'' + '}';
    AppMethodBeat.o(131934);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131932);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cvs);
    paramParcel.writeInt(this.gXf);
    paramParcel.writeString(this.gVh);
    AppMethodBeat.o(131932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.LoadParams
 * JD-Core Version:    0.7.0.1
 */