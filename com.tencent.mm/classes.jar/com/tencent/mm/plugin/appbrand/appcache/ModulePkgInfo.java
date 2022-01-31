package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ModulePkgInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<ModulePkgInfo> CREATOR = new ModulePkgInfo.1();
  public boolean bGd;
  public String bIW;
  public volatile String fCl;
  public String name;
  
  public ModulePkgInfo() {}
  
  private ModulePkgInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public final ModulePkgInfo abE()
  {
    ModulePkgInfo localModulePkgInfo = new ModulePkgInfo();
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    localModulePkgInfo.readFromParcel(localParcel);
    localParcel.recycle();
    return localModulePkgInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.fCl = paramParcel.readString();
    this.name = paramParcel.readString();
    this.bIW = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bGd = bool;
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.fCl);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.bIW);
    if (this.bGd) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
 * JD-Core Version:    0.7.0.1
 */