package com.tencent.mm.plugin.appbrand.ui.b.a;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.n;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandFakeNativeSplashScreenshot;", "()V", "convertTo", "Landroid/content/ContentValues;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends n
{
  public static final IAutoDBItem.MAutoDBInfo nVV;
  public static final a.a upF;
  public static final com.tencent.mm.ipcinvoker.extension.a upG;
  
  static
  {
    AppMethodBeat.i(322594);
    upF = new a.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = n.aJm();
    s.checkNotNull(localMAutoDBInfo);
    nVV = localMAutoDBInfo;
    upG = (com.tencent.mm.ipcinvoker.extension.a)new b();
    AppMethodBeat.o(322594);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(322603);
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
      s.s(localContentValues, "super.convertTo().also {…)\n            }\n        }");
      AppMethodBeat.o(322603);
      return localContentValues;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo$Companion$PARCELIZER$1", "Lcom/tencent/mm/ipcinvoker/extension/BaseTypeTransfer;", "canTransfer", "", "o", "", "readFromParcel", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "p", "Landroid/os/Parcel;", "writeToParcel", "", "dest", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.ipcinvoker.extension.a
  {
    public final void a(Object paramObject, Parcel paramParcel)
    {
      AppMethodBeat.i(322587);
      s.u(paramObject, "o");
      paramObject = (a)paramObject;
      if (paramParcel == null)
      {
        AppMethodBeat.o(322587);
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
        AppMethodBeat.o(322587);
        return;
      }
    }
    
    public final boolean cJ(Object paramObject)
    {
      return paramObject instanceof a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.a.a
 * JD-Core Version:    0.7.0.1
 */