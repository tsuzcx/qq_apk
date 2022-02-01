package com.tencent.mm.plugin.appbrand.ui.c.a;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.m;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandFakeNativeSplashScreenshot;", "()V", "convertTo", "Landroid/content/ContentValues;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends m
{
  public static final c.a gLr;
  public static final com.tencent.mm.ipcinvoker.extension.a lLu;
  public static final a lLv;
  
  static
  {
    AppMethodBeat.i(196471);
    lLv = new a((byte)0);
    gLr = m.So();
    lLu = (com.tencent.mm.ipcinvoker.extension.a)new b();
    AppMethodBeat.o(196471);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(196470);
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
      k.g(localContentValues, "super.convertTo().also {…)\n            }\n        }");
      AppMethodBeat.o(196470);
      return localContentValues;
    }
  }
  
  public final c.a getDBInfo()
  {
    return gLr;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo$Companion;", "", "()V", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "PARCELIZER", "Lcom/tencent/mm/ipcinvoker/extension/BaseTypeTransfer;", "PARCELIZER$annotations", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo$Companion$PARCELIZER$1", "Lcom/tencent/mm/ipcinvoker/extension/BaseTypeTransfer;", "canTransfer", "", "o", "", "readFromParcel", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "p", "Landroid/os/Parcel;", "writeToParcel", "", "dest", "plugin-appbrand-integration_release"})
  public static final class b
    implements com.tencent.mm.ipcinvoker.extension.a
  {
    public final void a(Object paramObject, Parcel paramParcel)
    {
      AppMethodBeat.i(196468);
      k.h(paramObject, "o");
      paramObject = (a)paramObject;
      if (paramParcel == null)
      {
        AppMethodBeat.o(196468);
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
        AppMethodBeat.o(196468);
        return;
      }
    }
    
    public final boolean bh(Object paramObject)
    {
      return paramObject instanceof a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */