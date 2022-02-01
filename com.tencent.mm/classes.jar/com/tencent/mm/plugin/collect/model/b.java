package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qbar.f;

public final class b
{
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, r.a parama, boolean paramBoolean1, int paramInt3, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(293557);
    int i = (int)(paramInt2 * 0.26F);
    int j = (int)(paramInt2 * 0.22F);
    paramInt2 = (int)(paramInt2 * 0.076F);
    for (;;)
    {
      try
      {
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        Log.i("MicroMsg.CollectBitmapFactory", "createCollectQrcode size avatarSize %s dpCanvas %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramInt1 == 1)
        {
          localObject1 = localObject2;
          if (!Util.isNullOrNil(paramString3))
          {
            localObject1 = r.a(new c(paramString3));
            r.b(parama);
          }
        }
        Log.i("MicroMsg.CollectBitmapFactory", "avaterRoundSize：%s, useOwnDefault:%s", new Object[] { Float.valueOf(paramFloat), Boolean.valueOf(paramBoolean2) });
        paramString3 = (String)localObject1;
        if (localObject1 == null)
        {
          paramString3 = (String)localObject1;
          if (paramBoolean2)
          {
            Log.i("MicroMsg.CollectBitmapFactory", "avatar == null,use own avatar");
            paramString3 = d.f(paramString2, j, j, (int)(j * 0.06F));
          }
        }
        paramString2 = paramString3;
        if (paramString3 == null)
        {
          Log.i("MicroMsg.CollectBitmapFactory", "avatar == null,use default");
          paramString2 = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null));
          paramString2 = BitmapUtil.getRoundedCornerBitmap(paramString2, false, 0.06F * paramString2.getWidth());
        }
        paramString3 = paramString2;
        if (paramString2 != null)
        {
          paramString3 = paramString2;
          if (paramBoolean1) {
            paramString3 = BitmapUtil.getRoundedCornerBitmap(paramString2, false, paramString2.getWidth() * 0.5F);
          }
        }
        paramString2 = paramString3;
        if (paramString3 != null)
        {
          paramString2 = paramString3;
          if (paramFloat > 0.0F) {
            paramString2 = BitmapUtil.getRoundedCornerBitmap(paramString3, false, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2));
          }
        }
        paramString3 = new Canvas(localBitmap);
        paramInt1 = (i - j) / 2;
        paramString3.drawBitmap(paramString2, null, new Rect(paramInt1, paramInt1, i - paramInt1, i - paramInt1), localPaint);
        paramString3.drawBitmap(MMBitmapFactory.decodeStream(paramContext.getResources().openRawResource(a.e.collect_ftf_avatar_icon)), null, new Rect(i - paramInt2, i - paramInt2, i, i), localPaint);
        if (Util.isEqual(paramInt3, -1)) {
          break label604;
        }
        if (!Util.isEqual(paramInt3, 0)) {
          break label598;
        }
      }
      catch (Exception paramContext)
      {
        Bitmap localBitmap;
        Log.printErrStackTrace("MicroMsg.CollectBitmapFactory", paramContext, "", new Object[0]);
        AppMethodBeat.o(293557);
        return null;
      }
      paramString2 = new byte[40000];
      paramString3 = new int[2];
      paramInt2 = f.a(paramString2, paramString3, paramString1, 12, paramInt1, "UTF-8");
      if (paramInt2 == 0)
      {
        paramContext = com.tencent.mm.bz.a.a.a(paramContext, localBitmap, paramString2, paramString3, 0.1D);
        if (paramContext == null)
        {
          Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[] { Integer.valueOf(paramInt2), Util.getStack().toString() });
          Log.i("MicroMsg.CollectBitmapFactory", "bitmap recycle %s errorLevel:%s", new Object[] { localBitmap, Integer.valueOf(paramInt1) });
          localBitmap.recycle();
          AppMethodBeat.o(293557);
          return paramContext;
        }
        Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[] { paramContext });
        continue;
      }
      Log.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[] { Integer.valueOf(paramInt2), Util.getStack().toString() });
      paramContext = null;
      continue;
      label598:
      paramInt1 = paramInt3;
      continue;
      label604:
      paramInt1 = 3;
    }
  }
  
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, r.a parama, int paramInt2)
  {
    AppMethodBeat.i(63769);
    paramContext = a(paramContext, paramString1, paramString2, paramInt1, paramString3, parama, false, paramInt2);
    AppMethodBeat.o(63769);
    return paramContext;
  }
  
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, r.a parama, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(63770);
    paramContext = a(paramContext, paramString1, paramString2, paramInt1, paramString3, BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 197.0F), parama, paramBoolean, paramInt2, 0.0F, true);
    AppMethodBeat.o(63770);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.b
 * JD-Core Version:    0.7.0.1
 */