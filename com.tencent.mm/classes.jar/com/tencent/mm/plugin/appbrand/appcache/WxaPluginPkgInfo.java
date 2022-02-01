package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.List;

public class WxaPluginPkgInfo
  implements Parcelable, IPkgInfo
{
  public static final Parcelable.Creator<WxaPluginPkgInfo> CREATOR;
  public static final String PREFIX_EXTENDED = "__extended__/";
  public static final String PREFIX_NORMAL = "__plugin__/";
  public List<Integer> contexts;
  public String md5;
  public volatile String pkgPath;
  public String prefixPath;
  public String provider;
  public String stringVersion;
  public int version;
  
  static
  {
    AppMethodBeat.i(178570);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(178570);
  }
  
  public WxaPluginPkgInfo() {}
  
  private WxaPluginPkgInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(178568);
    readFromParcel(paramParcel);
    AppMethodBeat.o(178568);
  }
  
  public void assignFrom(WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    AppMethodBeat.i(178565);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramWxaPluginPkgInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    readFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(178565);
  }
  
  public String checksumMd5()
  {
    return this.md5;
  }
  
  public WxaPluginPkgInfo clone()
  {
    AppMethodBeat.i(178564);
    WxaPluginPkgInfo localWxaPluginPkgInfo = new WxaPluginPkgInfo();
    localWxaPluginPkgInfo.assignFrom(this);
    AppMethodBeat.o(178564);
    return localWxaPluginPkgInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isAssignable(WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    AppMethodBeat.i(178563);
    boolean bool = this.provider.equals(paramWxaPluginPkgInfo.provider);
    AppMethodBeat.o(178563);
    return bool;
  }
  
  public long lastModified()
  {
    AppMethodBeat.i(178562);
    if (o.fB(this.pkgPath))
    {
      long l = o.aZS(this.pkgPath);
      AppMethodBeat.o(178562);
      return l;
    }
    AppMethodBeat.o(178562);
    return 0L;
  }
  
  public String pkgPath()
  {
    return this.pkgPath;
  }
  
  public int pkgVersion()
  {
    return this.version;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(178567);
    this.pkgPath = paramParcel.readString();
    this.provider = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.md5 = paramParcel.readString();
    this.prefixPath = paramParcel.readString();
    this.stringVersion = paramParcel.readString();
    if (this.contexts == null) {
      this.contexts = new LinkedList();
    }
    paramParcel.readList(this.contexts, Integer.class.getClassLoader());
    AppMethodBeat.o(178567);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(178566);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.provider);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.prefixPath);
    paramParcel.writeString(this.stringVersion);
    paramParcel.writeList(this.contexts);
    AppMethodBeat.o(178566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo
 * JD-Core Version:    0.7.0.1
 */