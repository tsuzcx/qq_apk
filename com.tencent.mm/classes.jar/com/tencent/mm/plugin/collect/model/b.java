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
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.qbar.f;

public final class b
{
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, u.a parama, boolean paramBoolean, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(198941);
    int i = (int)(paramInt2 * 0.26F);
    int j = (int)(paramInt2 * 0.22F);
    paramInt2 = (int)(paramInt2 * 0.076F);
    for (;;)
    {
      try
      {
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        ad.i("MicroMsg.CollectBitmapFactory", "createCollectQrcode size avatarSize %s dpCanvas %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramInt1 == 1)
        {
          localObject1 = localObject2;
          if (!bt.isNullOrNil(paramString3))
          {
            localObject1 = u.a(new c(paramString3));
            u.b(parama);
          }
        }
        paramString3 = (String)localObject1;
        if (localObject1 == null) {
          paramString3 = com.tencent.mm.ak.c.e(paramString2, j, j, (int)(j * 0.06F));
        }
        paramString2 = paramString3;
        if (paramString3 == null)
        {
          paramString2 = BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
          paramString2 = g.a(paramString2, false, 0.06F * paramString2.getWidth());
        }
        paramString3 = paramString2;
        if (paramString2 != null)
        {
          paramString3 = paramString2;
          if (paramBoolean) {
            paramString3 = g.a(paramString2, false, paramString2.getWidth() * 0.5F);
          }
        }
        paramString2 = paramString3;
        if (paramString3 != null)
        {
          paramString2 = paramString3;
          if (paramFloat > 0.0F) {
            paramString2 = g.a(paramString3, false, com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 2));
          }
        }
        paramString3 = new Canvas(localBitmap);
        paramInt1 = (i - j) / 2;
        paramString3.drawBitmap(paramString2, null, new Rect(paramInt1, paramInt1, i - paramInt1, i - paramInt1), localPaint);
        paramString3.drawBitmap(MMBitmapFactory.decodeStream(paramContext.getResources().openRawResource(2131231780)), null, new Rect(i - paramInt2, i - paramInt2, i, i), localPaint);
        if (bt.jx(paramInt3, -1)) {
          break label553;
        }
        if (!bt.jx(paramInt3, 0)) {
          break label547;
        }
      }
      catch (Exception paramContext)
      {
        Bitmap localBitmap;
        ad.printErrStackTrace("MicroMsg.CollectBitmapFactory", paramContext, "", new Object[0]);
        AppMethodBeat.o(198941);
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
          ad.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[] { Integer.valueOf(paramInt2), bt.flS().toString() });
          ad.i("MicroMsg.CollectBitmapFactory", "bitmap recycle %s errorLevel:%s", new Object[] { localBitmap, Integer.valueOf(paramInt1) });
          localBitmap.recycle();
          AppMethodBeat.o(198941);
          return paramContext;
        }
        ad.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[] { paramContext });
        continue;
      }
      ad.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[] { Integer.valueOf(paramInt2), bt.flS().toString() });
      paramContext = null;
      continue;
      label547:
      paramInt1 = paramInt3;
      continue;
      label553:
      paramInt1 = 3;
    }
  }
  
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, u.a parama, int paramInt2)
  {
    AppMethodBeat.i(63769);
    paramContext = a(paramContext, paramString1, paramString2, paramInt1, paramString3, parama, false, paramInt2);
    AppMethodBeat.o(63769);
    return paramContext;
  }
  
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, u.a parama, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(63770);
    paramContext = a(paramContext, paramString1, paramString2, paramInt1, paramString3, BackwardSupportUtil.b.g(paramContext, 197.0F), parama, paramBoolean, paramInt2, 0.0F);
    AppMethodBeat.o(63770);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.b
 * JD-Core Version:    0.7.0.1
 */