package com.tencent.mm.plugin.appbrand.luggage.export.wmpf;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFAccessibleProvider;", "Landroid/content/ContentProvider;", "()V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Constants", "plugin-appbrand-integration_release"})
public final class WMPFAccessibleProvider
  extends ContentProvider
{
  private static final boolean ENABLE;
  private static final UriMatcher qcP;
  public static final a qcQ;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(273810);
    qcQ = new a((byte)0);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    qcP = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.export.wmpf.provider", "detect_qrcode", 1);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger())) {
      bool = true;
    }
    ENABLE = bool;
    AppMethodBeat.o(273810);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(273808);
    p.k(paramUri, "uri");
    AppMethodBeat.o(273808);
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(273809);
    p.k(paramUri, "uri");
    AppMethodBeat.o(273809);
    return null;
  }
  
  public final Uri insert(final Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(273802);
    p.k(paramUri, "uri");
    if (!ENABLE)
    {
      AppMethodBeat.o(273802);
      return null;
    }
    if (paramContentValues == null)
    {
      AppMethodBeat.o(273802);
      return null;
    }
    if (qcP.match(paramUri) == 1)
    {
      paramUri = paramContentValues.getAsByteArray("CV_KEY_DETECT_QRCODE_BYTES");
      h.ZvG.be((Runnable)new b(this, paramUri));
    }
    AppMethodBeat.o(273802);
    return null;
  }
  
  public final boolean onCreate()
  {
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(273803);
    p.k(paramUri, "uri");
    AppMethodBeat.o(273803);
    return null;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(273806);
    p.k(paramUri, "uri");
    AppMethodBeat.o(273806);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFAccessibleProvider$Constants;", "", "()V", "AUTHORITY", "", "CODE_DETECT_QRCODE", "", "CV_KEY_DETECT_QRCODE_BYTES", "ENABLE", "", "getENABLE", "()Z", "PATH_DETECT_QRCODE", "TAG", "sUriMatcher", "Landroid/content/UriMatcher;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(WMPFAccessibleProvider paramWMPFAccessibleProvider, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(273858);
      Object localObject1 = MMBitmapFactory.decodeByteArray(paramUri, 0, paramUri.length);
      Object localObject3 = b.aSZ() + "wmpf_qrcode.png";
      u.bBD(b.aSZ());
      BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, Bitmap.CompressFormat.PNG, (String)localObject3, true);
      for (;;)
      {
        try
        {
          localObject1 = WMPFQRCodeDetectProxyUI.qcV;
          localObject1 = this.qcR.getContext();
          p.k(localObject3, "qrcodePath");
          if (localObject1 == null)
          {
            localObject2 = MMApplicationContext.getContext();
            localObject3 = new Intent((Context)localObject2, WMPFQRCodeDetectProxyUI.class).addFlags(268435456).putExtra("KEY_QRCODE_PATH", (String)localObject3);
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = MMApplicationContext.getContext();
            }
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject3);
            com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion", "waitFor", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion", "waitFor", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(273858);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.WMPFAccessibleProvider", localThrowable, "WMPFQRCodeDetectProxyUI.waitFor", new Object[0]);
          AppMethodBeat.o(273858);
          return;
        }
        Object localObject2 = localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.wmpf.WMPFAccessibleProvider
 * JD-Core Version:    0.7.0.1
 */