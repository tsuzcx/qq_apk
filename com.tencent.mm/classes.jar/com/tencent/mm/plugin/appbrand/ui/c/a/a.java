package com.tencent.mm.plugin.appbrand.ui.c.a;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.m;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandFakeNativeSplashScreenshot;", "()V", "convertTo", "Landroid/content/ContentValues;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends m
{
  public static final c.a hEe;
  public static final com.tencent.mm.ipcinvoker.extension.a mNT;
  public static final a mNU;
  
  static
  {
    AppMethodBeat.i(189646);
    mNU = new a((byte)0);
    hEe = m.Vv();
    mNT = (com.tencent.mm.ipcinvoker.extension.a)new b();
    AppMethodBeat.o(189646);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(189645);
    ContentValues localContentValues = super.convertTo();
    if (localContentValues.containsKey("isDarkMode")) {
      if (!this.field_isDarkMode) {
        break label51;
      }
    }
    label51:
    for (int i = 1;; i = 0)
    {
      localContentValues.put("isDarkMode", Integer.valueOf(i));
      p.g(localContentValues, "super.convertTo().also {…)\n            }\n        }");
      AppMethodBeat.o(189645);
      return localContentValues;
    }
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo$Companion;", "", "()V", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "PARCELIZER", "Lcom/tencent/mm/ipcinvoker/extension/BaseTypeTransfer;", "PARCELIZER$annotations", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo$Companion$PARCELIZER$1", "Lcom/tencent/mm/ipcinvoker/extension/BaseTypeTransfer;", "canTransfer", "", "o", "", "readFromParcel", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "p", "Landroid/os/Parcel;", "writeToParcel", "", "dest", "plugin-appbrand-integration_release"})
  public static final class b
    implements com.tencent.mm.ipcinvoker.extension.a
  {
    public final void a(Object paramObject, Parcel paramParcel)
    {
      AppMethodBeat.i(189643);
      p.h(paramObject, "o");
      paramObject = (a)paramObject;
      if (paramParcel == null)
      {
        AppMethodBeat.o(189643);
        return;
      }
      paramParcel.writeString(paramObject.field_appId);
      paramParcel.writeInt(paramObject.field_versionType);
      paramParcel.writeInt(paramObject.field_appVersion);
      if (paramObject.field_isDarkMode) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(paramObject.field_screenshotFilePath);
        AppMethodBeat.o(189643);
        return;
      }
    }
    
    public final boolean bg(Object paramObject)
    {
      return paramObject instanceof a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */