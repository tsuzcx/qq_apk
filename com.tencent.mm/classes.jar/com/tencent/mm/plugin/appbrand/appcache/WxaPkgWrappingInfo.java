package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo
  extends ModulePkgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaPkgWrappingInfo> CREATOR;
  public int gXe;
  public int gXf;
  public long gXg;
  public boolean gXh;
  public final LinkedList<ModulePkgInfo> gXi;
  private final Map<String, String> gXj;
  
  static
  {
    AppMethodBeat.i(105336);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(105336);
  }
  
  public WxaPkgWrappingInfo()
  {
    AppMethodBeat.i(105330);
    this.gXi = new LinkedList();
    this.gXj = new HashMap();
    this.name = "__APP__";
    this.cnm = true;
    AppMethodBeat.o(105330);
  }
  
  public WxaPkgWrappingInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(105331);
    readFromParcel(paramParcel);
    AppMethodBeat.o(105331);
  }
  
  public static WxaPkgWrappingInfo yL(String paramString)
  {
    AppMethodBeat.i(105328);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105328);
      return null;
    }
    Object localObject = new ao(new File(paramString));
    if (!((ao)localObject).gVO)
    {
      ab.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", new Object[] { paramString });
      ((ao)localObject).close();
      AppMethodBeat.o(105328);
      return null;
    }
    if (!((ao)localObject).avO())
    {
      ab.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", new Object[] { paramString });
      ((ao)localObject).close();
      AppMethodBeat.o(105328);
      return null;
    }
    ((ao)localObject).close();
    localObject = new WxaPkgWrappingInfo();
    ((WxaPkgWrappingInfo)localObject).gUy = paramString;
    ((WxaPkgWrappingInfo)localObject).gXh = false;
    ((WxaPkgWrappingInfo)localObject).cqq = g.getMD5(paramString);
    AppMethodBeat.o(105328);
    return localObject;
  }
  
  public static WxaPkgWrappingInfo yM(String paramString)
  {
    AppMethodBeat.i(105329);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WxaPkgWrappingInfo#obtainCodeLib", "pkgPath null!");
      AppMethodBeat.o(105329);
      return null;
    }
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.gUy = paramString;
    localWxaPkgWrappingInfo.gXh = false;
    localWxaPkgWrappingInfo.cqq = g.getMD5(paramString);
    AppMethodBeat.o(105329);
    return localWxaPkgWrappingInfo;
  }
  
  final void awj()
  {
    AppMethodBeat.i(105326);
    synchronized (this.gXj)
    {
      Iterator localIterator = this.gXi.iterator();
      if (localIterator.hasNext())
      {
        ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
        String str = k.zl(localModulePkgInfo.name);
        this.gXj.put(str, localModulePkgInfo.name);
        localModulePkgInfo.name = str;
      }
    }
    AppMethodBeat.o(105326);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(105335);
    super.readFromParcel(paramParcel);
    this.gXe = paramParcel.readInt();
    this.gXf = paramParcel.readInt();
    this.gXg = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.gXh = bool;
      paramParcel.readTypedList(this.gXi, ModulePkgInfo.CREATOR);
      AppMethodBeat.o(105335);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(105333);
    String str = "WxaPkgWrappingInfo{pkgDebugType=" + this.gXe + ", pkgVersion=" + this.gXf + ", pkgCreateTime=" + this.gXg + ", localPkg=" + this.gXh + ", md5='" + this.cqq + '\'' + ", pkgPath='" + this.gUy + '\'' + '}';
    AppMethodBeat.o(105333);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105334);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.gXe);
    paramParcel.writeInt(this.gXf);
    paramParcel.writeLong(this.gXg);
    if (this.gXh) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeTypedList(this.gXi);
      AppMethodBeat.o(105334);
      return;
    }
  }
  
  public final String yK(String paramString)
  {
    AppMethodBeat.i(105327);
    if ("__APP__".equals(paramString))
    {
      AppMethodBeat.o(105327);
      return paramString;
    }
    synchronized (this.gXj)
    {
      paramString = (String)this.gXj.get(paramString);
      if (bo.isNullOrNil(paramString))
      {
        paramString = new IllegalAccessError("Invalid moduleName for runtime logic, call @smoothieli to fix this");
        AppMethodBeat.o(105327);
        throw paramString;
      }
    }
    AppMethodBeat.o(105327);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo
 * JD-Core Version:    0.7.0.1
 */