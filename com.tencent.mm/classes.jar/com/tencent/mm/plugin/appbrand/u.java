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
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class u
{
  public static Intent a(Context paramContext, u.a parama, int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(129119);
    if ((parama == null) || (paramContext == null) || (parama.userName == null))
    {
      ab.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
      AppMethodBeat.o(129119);
      return null;
    }
    if ((paramBitmap == null) && (paramBoolean))
    {
      ab.e("MicroMsg.AppBrandShortcutManager", "no bmp");
      AppMethodBeat.o(129119);
      return null;
    }
    String str;
    if (TextUtils.isEmpty(parama.nickname))
    {
      str = parama.userName;
      parama = t.auj().a(paramContext.getPackageName(), paramInt, parama.userName, parama.nickname, parama.bDK, parama.appId, parama.uin, 1);
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
      AppMethodBeat.o(129119);
      return paramContext;
      str = parama.nickname;
      break;
    }
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(129121);
    if ((paramContext == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(129121);
      return null;
    }
    int i = (int)(a.getDensity(paramContext) * 48.0F);
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, i, false);
    paramBitmap = localObject;
    if (localBitmap != null)
    {
      paramBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
      ab.i("MicroMsg.AppBrandShortcutManager", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    if (paramInt == 2) {
      a(paramContext, paramBitmap, a.aq(paramContext, 2131296859));
    }
    for (;;)
    {
      AppMethodBeat.o(129121);
      return paramBitmap;
      if (paramInt == 1) {
        a(paramContext, paramBitmap, a.aq(paramContext, 2131296860));
      }
    }
  }
  
  private static void a(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(129122);
    if ((paramContext == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(129122);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129122);
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
      AppMethodBeat.o(129122);
      return;
    }
  }
  
  public static boolean a(Context paramContext, u.a parama, int paramInt, boolean paramBoolean)
  {
    String str1 = null;
    AppMethodBeat.i(129117);
    if ((paramContext == null) || (parama == null))
    {
      ab.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
      AppMethodBeat.o(129117);
      return false;
    }
    if (parama.bDK == null)
    {
      ab.e("MicroMsg.AppBrandShortcutManager", "no such user");
      AppMethodBeat.o(129117);
      return false;
    }
    Object localObject = i(parama.bDK);
    if (localObject == null)
    {
      ab.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
      AppMethodBeat.o(129117);
      return true;
    }
    Intent localIntent = a(paramContext, parama, paramInt, a(paramContext, (Bitmap)localObject, paramInt), true);
    if (localIntent == null)
    {
      ab.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
      AppMethodBeat.o(129117);
      return false;
    }
    if ((Intent)localIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT") != null)
    {
      String str2 = parama.appId;
      String str3 = com.tencent.mm.plugin.base.model.b.dc(str2 + String.valueOf(paramInt), q.bP(true));
      if (str3 != null)
      {
        localObject = com.tencent.mm.plugin.base.model.b.S(str3.getBytes());
        String str4 = com.tencent.mm.plugin.base.model.b.dc(str2 + String.valueOf(paramInt), q.getAndroidId());
        if (str3 != null) {
          str1 = com.tencent.mm.plugin.base.model.b.S(str4.getBytes());
        }
        ab.i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", new Object[] { str2, localObject });
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.base.model.b.a(paramContext, localIntent, str1, (String)localObject, paramBoolean);
        ab.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", new Object[] { parama.userName });
        AppMethodBeat.o(129117);
        return true;
      }
      catch (IllegalStateException paramContext)
      {
        ab.w("MicroMsg.AppBrandShortcutManager", paramContext.toString());
        AppMethodBeat.o(129117);
        return false;
      }
      localObject = null;
      break;
      str1 = null;
      localObject = null;
    }
  }
  
  public static Bitmap i(String[] paramArrayOfString)
  {
    AppMethodBeat.i(129120);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramArrayOfString[i];
      if (!bo.isNullOrNil((String)localObject))
      {
        Bitmap localBitmap = com.tencent.mm.modelappbrand.a.b.acD().a((String)localObject, null);
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
    AppMethodBeat.o(129120);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u
 * JD-Core Version:    0.7.0.1
 */