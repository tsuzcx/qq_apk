package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ab
{
  public static Intent a(Context paramContext, ab.a parama, int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(43962);
    if ((parama == null) || (paramContext == null) || (parama.userName == null))
    {
      Log.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
      AppMethodBeat.o(43962);
      return null;
    }
    if ((paramBitmap == null) && (paramBoolean))
    {
      Log.e("MicroMsg.AppBrandShortcutManager", "no bmp");
      AppMethodBeat.o(43962);
      return null;
    }
    String str;
    if (TextUtils.isEmpty(parama.nickname))
    {
      str = parama.userName;
      parama = aa.cdp().a(paramContext.getPackageName(), paramInt, parama.userName, parama.nickname, parama.eqg, parama.appId, parama.uin, 1);
      if (!paramBoolean) {
        break label180;
      }
    }
    label180:
    for (paramContext = "com.android.launcher.action.INSTALL_SHORTCUT";; paramContext = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      paramContext = new Intent(paramContext);
      paramContext.putExtra("android.intent.extra.shortcut.NAME", str);
      paramContext.putExtra("duplicate", false);
      paramContext.putExtra("android.intent.extra.shortcut.INTENT", parama);
      paramContext.putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
      paramContext.putExtra("shortcut_is_adaptive_icon", true);
      AppMethodBeat.o(43962);
      return paramContext;
      str = parama.nickname;
      break;
    }
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(43964);
    if ((paramContext == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(43964);
      return null;
    }
    int i = (int)(a.getDensity(paramContext) * 48.0F);
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, i, true);
    paramBitmap = localObject;
    if (localBitmap != null)
    {
      paramBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
      Log.i("MicroMsg.AppBrandShortcutManager", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    if (paramInt == 2) {
      a(paramContext, paramBitmap, a.bt(paramContext, ba.i.app_brand_shortcut_tag_beta));
    }
    for (;;)
    {
      AppMethodBeat.o(43964);
      return paramBitmap;
      if (paramInt == 1) {
        a(paramContext, paramBitmap, a.bt(paramContext, ba.i.app_brand_shortcut_tag_dev));
      }
    }
  }
  
  private static void a(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(43965);
    if ((paramContext == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(43965);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43965);
      return;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f3 = a.getDensity(paramContext);
    float f1 = 4.0F * f3;
    float f2 = 2.0F * f3;
    Paint localPaint = new Paint();
    localPaint.setTextSize(f3 * 6.0F);
    localPaint.setFakeBoldText(true);
    localPaint.setAntiAlias(true);
    f3 = localPaint.measureText(paramString);
    Paint.FontMetrics localFontMetrics = localPaint.getFontMetrics();
    float f4 = localFontMetrics.bottom - localFontMetrics.top;
    localPaint.setColor(Color.parseColor("#459AE9"));
    paramBitmap = new Canvas(paramBitmap);
    if (Build.VERSION.SDK_INT < 26) {}
    for (paramContext = new RectF(i - f3 - 2.0F * f1, j - f4 - 2.0F * f2, i, j);; paramContext = new RectF(0.0F, j - f4 - 2.0F * f2, f3 + 2.0F * f1, j))
    {
      paramBitmap.drawRoundRect(paramContext, 4.0F, 4.0F, localPaint);
      localPaint.setColor(-1);
      paramBitmap.drawText(paramString, paramContext.left + f1, paramContext.top + f2 - localFontMetrics.ascent, localPaint);
      AppMethodBeat.o(43965);
      return;
    }
  }
  
  public static boolean a(Context paramContext, ab.a parama, int paramInt, boolean paramBoolean)
  {
    String str1 = null;
    AppMethodBeat.i(43961);
    if ((paramContext == null) || (parama == null))
    {
      Log.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
      AppMethodBeat.o(43961);
      return false;
    }
    if (parama.eqg == null)
    {
      Log.e("MicroMsg.AppBrandShortcutManager", "no such user");
      AppMethodBeat.o(43961);
      return false;
    }
    Object localObject = l(parama.eqg);
    if (localObject == null)
    {
      Log.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
      AppMethodBeat.o(43961);
      return true;
    }
    Intent localIntent = a(paramContext, parama, paramInt, a(paramContext, (Bitmap)localObject, paramInt), true);
    if (localIntent == null)
    {
      Log.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
      AppMethodBeat.o(43961);
      return false;
    }
    if ((Intent)localIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT") != null)
    {
      String str2 = parama.appId;
      String str3 = com.tencent.mm.plugin.base.model.b.fB(str2 + String.valueOf(paramInt), q.eD(true));
      if (str3 != null)
      {
        localObject = com.tencent.mm.plugin.base.model.b.toHexString(str3.getBytes());
        String str4 = com.tencent.mm.plugin.base.model.b.fB(str2 + String.valueOf(paramInt), q.getAndroidId());
        if (str3 != null) {
          str1 = com.tencent.mm.plugin.base.model.b.toHexString(str4.getBytes());
        }
        Log.i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", new Object[] { str2, localObject });
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.base.model.b.a(paramContext, localIntent, str1, (String)localObject, paramBoolean);
        Log.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", new Object[] { parama.userName });
        AppMethodBeat.o(43961);
        return true;
      }
      catch (IllegalStateException paramContext)
      {
        Log.w("MicroMsg.AppBrandShortcutManager", paramContext.toString());
        AppMethodBeat.o(43961);
        return false;
      }
      localObject = null;
      break;
      str1 = null;
      localObject = null;
    }
  }
  
  public static Bitmap l(String[] paramArrayOfString)
  {
    AppMethodBeat.i(43963);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramArrayOfString[i];
      if (!Util.isNullOrNil((String)localObject))
      {
        Bitmap localBitmap = com.tencent.mm.modelappbrand.a.b.bEY().a((String)localObject, null);
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (!localBitmap.isRecycled()) {
            break label62;
          }
        }
      }
      i += 1;
    }
    Object localObject = null;
    label62:
    AppMethodBeat.o(43963);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab
 * JD-Core Version:    0.7.0.1
 */