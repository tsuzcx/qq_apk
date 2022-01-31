package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo
  extends ModulePkgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaPkgWrappingInfo> CREATOR = new Parcelable.Creator() {};
  public int fEM;
  public int fEN;
  public long fEO;
  public boolean fEP;
  public final LinkedList<ModulePkgInfo> fEQ = new LinkedList();
  public final Map<String, String> fER = new HashMap();
  
  public WxaPkgWrappingInfo()
  {
    this.name = "__APP__";
    this.bGd = true;
  }
  
  public WxaPkgWrappingInfo(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  public static WxaPkgWrappingInfo rn(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = new ai(new File(paramString));
    if (!((ai)localObject).fDy)
    {
      y.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", new Object[] { paramString });
      ((ai)localObject).close();
      return null;
    }
    if (!((ai)localObject).abX())
    {
      y.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", new Object[] { paramString });
      ((ai)localObject).close();
      return null;
    }
    ((ai)localObject).close();
    localObject = new WxaPkgWrappingInfo();
    ((WxaPkgWrappingInfo)localObject).fCl = paramString;
    ((WxaPkgWrappingInfo)localObject).fEP = false;
    ((WxaPkgWrappingInfo)localObject).bIW = g.bQ(paramString);
    return localObject;
  }
  
  public final void a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramWxaPkgWrappingInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    readFromParcel(localParcel);
    localParcel.recycle();
  }
  
  final void acs()
  {
    Iterator localIterator = this.fEQ.iterator();
    while (localIterator.hasNext())
    {
      ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
      String str = i.rA(localModulePkgInfo.name);
      this.fER.put(str, localModulePkgInfo.name);
      localModulePkgInfo.name = str;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.fEM = paramParcel.readInt();
    this.fEN = paramParcel.readInt();
    this.fEO = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.fEP = bool;
      paramParcel.readTypedList(this.fEQ, ModulePkgInfo.CREATOR);
      return;
    }
  }
  
  public final String toString()
  {
    return "WxaPkgWrappingInfo{pkgDebugType=" + this.fEM + ", pkgVersion=" + this.fEN + ", pkgCreateTime=" + this.fEO + ", localPkg=" + this.fEP + ", md5='" + this.bIW + '\'' + ", pkgPath='" + this.fCl + '\'' + '}';
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.fEM);
    paramParcel.writeInt(this.fEN);
    paramParcel.writeLong(this.fEO);
    if (this.fEP) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeTypedList(this.fEQ);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo
 * JD-Core Version:    0.7.0.1
 */