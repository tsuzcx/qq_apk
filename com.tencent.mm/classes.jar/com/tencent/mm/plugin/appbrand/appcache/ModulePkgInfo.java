package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.FileNotFoundException;

public class ModulePkgInfo
  implements Parcelable, IPkgInfo, Cloneable
{
  public static final Parcelable.Creator<ModulePkgInfo> CREATOR;
  public static final String GAME_PLUGIN_SCRIPT = "/plugin.js";
  public static final String MAIN_MODULE_NAME = "__APP__";
  public static final String MODULE_WITHOUT_MULTI_PLUGIN_CODE = "__WITHOUT_MULTI_PLUGINCODE__";
  public static final String MODULE_WITHOUT_PLUGIN_CODE = "__WITHOUT_PLUGINCODE__";
  public static final String PLUGINCODE_ORIGIN_PREFIX = "__plugin__/";
  public static final String PLUGINCODE_PREFIX = "/__plugin__/";
  public static final String PLUGIN_CODE = "__PLUGINCODE__";
  public String[] aliases;
  public boolean independent;
  public String md5;
  public String name;
  public volatile String pkgPath;
  public int pkgVersion;
  
  static
  {
    AppMethodBeat.i(134274);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134274);
  }
  
  public ModulePkgInfo() {}
  
  private ModulePkgInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(134272);
    readFromParcel(paramParcel);
    AppMethodBeat.o(134272);
  }
  
  public void assignFrom(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(182976);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramModulePkgInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    readFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(182976);
  }
  
  public String checksumMd5()
  {
    return this.md5;
  }
  
  public ModulePkgInfo clone()
  {
    AppMethodBeat.i(182975);
    ModulePkgInfo localModulePkgInfo = new ModulePkgInfo();
    localModulePkgInfo.assignFrom(this);
    AppMethodBeat.o(182975);
    return localModulePkgInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getPkgSize()
  {
    AppMethodBeat.i(182977);
    if (!i.eA(this.pkgPath))
    {
      localObject = new FileNotFoundException();
      AppMethodBeat.o(182977);
      throw ((Throwable)localObject);
    }
    Object localObject = new e(this.pkgPath);
    if ((((e)localObject).isFile()) && (((e)localObject).canRead()))
    {
      long l = ((e)localObject).length();
      AppMethodBeat.o(182977);
      return l;
    }
    AppMethodBeat.o(182977);
    return 0L;
  }
  
  public boolean isAssignable(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(182974);
    boolean bool = this.name.equals(paramModulePkgInfo.name);
    AppMethodBeat.o(182974);
    return bool;
  }
  
  public long lastModified()
  {
    AppMethodBeat.i(182973);
    if (i.eA(this.pkgPath))
    {
      long l = i.aSq(this.pkgPath);
      AppMethodBeat.o(182973);
      return l;
    }
    AppMethodBeat.o(182973);
    return 0L;
  }
  
  public String pkgPath()
  {
    return this.pkgPath;
  }
  
  public int pkgVersion()
  {
    return this.pkgVersion;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(134271);
    this.pkgPath = paramParcel.readString();
    this.name = paramParcel.readString();
    this.md5 = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.independent = bool;
      this.aliases = paramParcel.createStringArray();
      AppMethodBeat.o(134271);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134270);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.md5);
    if (this.independent) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeStringArray(this.aliases);
      AppMethodBeat.o(134270);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
 * JD-Core Version:    0.7.0.1
 */