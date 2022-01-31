package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.pc;
import java.util.LinkedList;

public final class AppRuntimeApiPermissionBundle
  implements Parcelable
{
  public static final Parcelable.Creator<AppRuntimeApiPermissionBundle> CREATOR = new AppRuntimeApiPermissionBundle.1();
  final byte[] gWT;
  final byte[] gWU;
  final byte[] gWV;
  
  private AppRuntimeApiPermissionBundle(Parcel paramParcel)
  {
    this.gWT = paramParcel.createByteArray();
    this.gWU = paramParcel.createByteArray();
    this.gWV = paramParcel.createByteArray();
  }
  
  public AppRuntimeApiPermissionBundle(pc parampc)
  {
    this.gWT = parampc.sMN.toByteArray();
    this.gWU = ((b)parampc.sMO.get(0)).toByteArray();
    this.gWV = ((b)parampc.sMO.get(1)).toByteArray();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.gWT);
    paramParcel.writeByteArray(this.gWU);
    paramParcel.writeByteArray(this.gWV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle
 * JD-Core Version:    0.7.0.1
 */