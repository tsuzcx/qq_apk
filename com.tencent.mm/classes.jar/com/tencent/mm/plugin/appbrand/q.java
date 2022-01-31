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
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
{
  private static Intent a(Context paramContext, q.a parama, int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((parama == null) || (paramContext == null) || (parama.userName == null))
    {
      y.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
      return null;
    }
    if ((paramBitmap == null) && (paramBoolean))
    {
      y.e("MicroMsg.AppBrandShortcutManager", "no bmp");
      return null;
    }
    Object localObject2 = parama.userName;
    if (TextUtils.isEmpty(parama.nickname)) {}
    String str1;
    String str2;
    for (Object localObject1 = localObject2;; localObject1 = parama.nickname)
    {
      str1 = parama.appId;
      str2 = c.xJ((String)localObject2);
      if (!bk.bl(str2)) {
        break;
      }
      return null;
    }
    if (paramBoolean) {}
    for (localObject2 = "com.android.launcher.action.INSTALL_SHORTCUT";; localObject2 = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      localObject3 = new StringBuilder();
      String[] arrayOfString = parama.bHW;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject3).append(arrayOfString[i]);
        i += 1;
      }
    }
    Object localObject3 = g.o(((String)localObject1 + ((StringBuilder)localObject3).toString()).getBytes());
    localObject2 = new Intent((String)localObject2);
    ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
    ((Intent)localObject2).putExtra("duplicate", false);
    localObject1 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
    ((Intent)localObject1).putExtra("type", 1);
    ((Intent)localObject1).putExtra("id", str2);
    ((Intent)localObject1).putExtra("ext_info", c.xJ(str1));
    ((Intent)localObject1).putExtra("token", c.cm(str1, parama.uin));
    ((Intent)localObject1).putExtra("digest", (String)localObject3);
    ((Intent)localObject1).putExtra("ext_info_1", paramInt);
    ((Intent)localObject1).setPackage(paramContext.getPackageName());
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject1);
    ((Intent)localObject2).putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
    ((Intent)localObject2).putExtra("shortcut_is_adaptive_icon", true);
    return localObject2;
  }
  
  private static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramContext != null)
    {
      localObject1 = localObject3;
      if (paramBitmap != null)
      {
        if (!paramBitmap.isRecycled()) {
          break label36;
        }
        localObject1 = localObject3;
      }
    }
    label36:
    do
    {
      return localObject1;
      int i = (int)(a.getDensity(paramContext) * 48.0F);
      localObject1 = Bitmap.createScaledBitmap(paramBitmap, i, i, false);
      paramBitmap = localObject2;
      if (localObject1 != null)
      {
        paramBitmap = ((Bitmap)localObject1).copy(Bitmap.Config.ARGB_8888, true);
        ((Bitmap)localObject1).recycle();
      }
      if (paramInt == 2)
      {
        a(paramContext, paramBitmap, a.ac(paramContext, y.j.app_brand_shortcut_tag_beta));
        return paramBitmap;
      }
      localObject1 = paramBitmap;
    } while (paramInt != 1);
    a(paramContext, paramBitmap, a.ac(paramContext, y.j.app_brand_shortcut_tag_dev));
    return paramBitmap;
  }
  
  private static void a(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    if ((paramContext == null) || (paramBitmap == null) || (paramBitmap.isRecycled())) {}
    while (bk.bl(paramString)) {
      return;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f3 = a.getDensity(paramContext);
    float f1 = f3 * 4.0F;
    float f2 = f3 * 2.0F;
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
    for (paramContext = new RectF(i - f3 - f1 * 2.0F, j - f4 - f2 * 2.0F, i, j);; paramContext = new RectF(0.0F, j - f4 - f2 * 2.0F, f3 + f1 * 2.0F, j))
    {
      paramBitmap.drawRoundRect(paramContext, 4.0F, 4.0F, localPaint);
      localPaint.setColor(-1);
      paramBitmap.drawText(paramString, paramContext.left + f1, paramContext.top + f2 - localFontMetrics.ascent, localPaint);
      return;
    }
  }
  
  public static boolean a(Context paramContext, q.a parama, int paramInt)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or config is null.");
      return false;
    }
    if (parama.bHW == null)
    {
      y.e("MicroMsg.AppBrandShortcutManager", "no such user");
      return false;
    }
    Intent localIntent = a(paramContext, parama, paramInt, a(paramContext, i(parama.bHW), paramInt), false);
    if (localIntent == null)
    {
      y.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
      return false;
    }
    com.tencent.mm.plugin.base.model.b.o(paramContext, localIntent);
    y.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[] { parama.userName });
    return true;
  }
  
  public static boolean a(Context paramContext, q.a parama, int paramInt, boolean paramBoolean)
  {
    if ((paramContext == null) || (parama == null))
    {
      y.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
      return false;
    }
    if (parama.bHW == null)
    {
      y.e("MicroMsg.AppBrandShortcutManager", "no such user");
      return false;
    }
    Object localObject = i(parama.bHW);
    if (localObject == null)
    {
      y.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
      return true;
    }
    Intent localIntent = a(paramContext, parama, paramInt, a(paramContext, (Bitmap)localObject, paramInt), true);
    if (localIntent == null)
    {
      y.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
      return false;
    }
    if ((Intent)localIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT") != null)
    {
      String str = parama.appId;
      localObject = com.tencent.mm.plugin.base.model.b.cl(str + String.valueOf(paramInt), com.tencent.mm.compatible.e.q.zf());
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.base.model.b.W(((String)localObject).getBytes());
        y.i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", new Object[] { str, localObject });
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.base.model.b.a(paramContext, localIntent, (String)localObject, paramBoolean);
        y.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", new Object[] { parama.userName });
        return true;
      }
      catch (IllegalStateException paramContext)
      {
        y.w("MicroMsg.AppBrandShortcutManager", paramContext.toString());
        return false;
      }
      localObject = null;
      break;
      localObject = null;
    }
  }
  
  private static Bitmap i(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramArrayOfString[i];
      if (!bk.bl((String)localObject))
      {
        Bitmap localBitmap = com.tencent.mm.modelappbrand.a.b.JD().a((String)localObject, null);
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (!localBitmap.isRecycled()) {
            return localObject;
          }
        }
      }
      i += 1;
    }
    Object localObject = null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q
 * JD-Core Version:    0.7.0.1
 */