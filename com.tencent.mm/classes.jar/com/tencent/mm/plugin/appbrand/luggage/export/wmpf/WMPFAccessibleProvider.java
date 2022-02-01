package com.tencent.mm.plugin.appbrand.luggage.export.wmpf;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFAccessibleProvider;", "Landroid/content/ContentProvider;", "()V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Constants", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WMPFAccessibleProvider
  extends ContentProvider
{
  private static final boolean ENABLE;
  public static final a thG;
  private static final UriMatcher thH;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(319908);
    thG = new a((byte)0);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    thH = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.export.wmpf.provider", "detect_qrcode", 1);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger())) {
      bool = true;
    }
    ENABLE = bool;
    AppMethodBeat.o(319908);
  }
  
  private static final void a(byte[] paramArrayOfByte, WMPFAccessibleProvider paramWMPFAccessibleProvider)
  {
    AppMethodBeat.i(319903);
    s.u(paramWMPFAccessibleProvider, "this$0");
    paramArrayOfByte = MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    Object localObject = s.X(b.bmN(), "wmpf_qrcode.png");
    y.bDX(b.bmN());
    BitmapUtil.saveBitmapToImage(paramArrayOfByte, 100, Bitmap.CompressFormat.PNG, (String)localObject, true);
    try
    {
      paramArrayOfByte = WMPFQRCodeDetectProxyUI.thI;
      paramArrayOfByte = paramWMPFAccessibleProvider.getContext();
      s.u(localObject, "qrcodePath");
      if (paramArrayOfByte == null) {}
      for (paramWMPFAccessibleProvider = MMApplicationContext.getContext();; paramWMPFAccessibleProvider = paramArrayOfByte)
      {
        localObject = new Intent(paramWMPFAccessibleProvider, WMPFQRCodeDetectProxyUI.class).addFlags(268435456).putExtra("KEY_QRCODE_PATH", (String)localObject);
        paramWMPFAccessibleProvider = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          paramWMPFAccessibleProvider = MMApplicationContext.getContext();
        }
        paramArrayOfByte = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramWMPFAccessibleProvider, paramArrayOfByte.aYi(), "com/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion", "waitFor", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramWMPFAccessibleProvider.startActivity((Intent)paramArrayOfByte.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramWMPFAccessibleProvider, "com/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion", "waitFor", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(319903);
        return;
      }
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.WMPFAccessibleProvider", paramArrayOfByte, "WMPFQRCodeDetectProxyUI.waitFor", new Object[0]);
      AppMethodBeat.o(319903);
    }
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(319936);
    s.u(paramUri, "uri");
    AppMethodBeat.o(319936);
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(319942);
    s.u(paramUri, "uri");
    AppMethodBeat.o(319942);
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(319912);
    s.u(paramUri, "uri");
    if (!ENABLE)
    {
      AppMethodBeat.o(319912);
      return null;
    }
    if (paramContentValues == null)
    {
      AppMethodBeat.o(319912);
      return null;
    }
    if (thH.match(paramUri) == 1)
    {
      paramUri = paramContentValues.getAsByteArray("CV_KEY_DETECT_QRCODE_BYTES");
      h.ahAA.bm(new WMPFAccessibleProvider..ExternalSyntheticLambda0(paramUri, this));
    }
    AppMethodBeat.o(319912);
    return null;
  }
  
  public final boolean onCreate()
  {
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(319916);
    s.u(paramUri, "uri");
    AppMethodBeat.o(319916);
    return null;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(319924);
    s.u(paramUri, "uri");
    AppMethodBeat.o(319924);
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFAccessibleProvider$Constants;", "", "()V", "AUTHORITY", "", "CODE_DETECT_QRCODE", "", "CV_KEY_DETECT_QRCODE_BYTES", "ENABLE", "", "getENABLE", "()Z", "PATH_DETECT_QRCODE", "TAG", "sUriMatcher", "Landroid/content/UriMatcher;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.wmpf.WMPFAccessibleProvider
 * JD-Core Version:    0.7.0.1
 */