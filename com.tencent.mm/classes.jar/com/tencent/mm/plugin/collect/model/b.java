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
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.qbar.QbarNative;

public final class b
{
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, x.a parama, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(141983);
    int i = (int)(paramInt2 * 0.26F);
    int j = (int)(paramInt2 * 0.22F);
    paramInt2 = (int)(paramInt2 * 0.076F);
    for (;;)
    {
      try
      {
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        ab.i("MicroMsg.CollectBitmapFactory", "createCollectQrcode size avatarSize %s dpCanvas %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramInt1 == 1)
        {
          localObject1 = localObject2;
          if (!bo.isNullOrNil(paramString3))
          {
            localObject1 = x.a(new c(paramString3));
            x.b(parama);
          }
        }
        paramString3 = (String)localObject1;
        if (localObject1 == null) {
          paramString3 = com.tencent.mm.ah.b.d(paramString2, j, j, (int)(j * 0.06F));
        }
        paramString2 = paramString3;
        if (paramString3 == null)
        {
          paramString2 = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
          paramString2 = d.a(paramString2, false, 0.06F * paramString2.getWidth());
        }
        paramString3 = paramString2;
        if (paramString2 != null)
        {
          paramString3 = paramString2;
          if (paramBoolean) {
            paramString3 = d.a(paramString2, false, paramString2.getWidth() * 0.5F);
          }
        }
        paramString2 = new Canvas(localBitmap);
        paramInt1 = (i - j) / 2;
        paramString2.drawBitmap(paramString3, null, new Rect(paramInt1, paramInt1, i - paramInt1, i - paramInt1), localPaint);
        paramString2.drawBitmap(MMBitmapFactory.decodeStream(paramContext.getResources().openRawResource(2130838407)), null, new Rect(i - paramInt2, i - paramInt2, i, i), localPaint);
        if (bo.hl(paramInt3, -1)) {
          break label519;
        }
        if (!bo.hl(paramInt3, 0)) {
          break label513;
        }
      }
      catch (Exception paramContext)
      {
        Bitmap localBitmap;
        ab.printErrStackTrace("MicroMsg.CollectBitmapFactory", paramContext, "", new Object[0]);
        AppMethodBeat.o(141983);
        return null;
      }
      paramString2 = new byte[40000];
      paramString3 = new int[2];
      paramInt2 = QbarNative.a(paramString2, paramString3, paramString1, 12, paramInt1, "UTF-8");
      QbarNative.nativeRelease();
      if (paramInt2 == 0)
      {
        paramContext = com.tencent.mm.by.a.a.a(paramContext, localBitmap, paramString2, paramString3);
        if (paramContext == null)
        {
          ab.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[] { Integer.valueOf(paramInt2), bo.dtY().toString() });
          ab.i("MicroMsg.CollectBitmapFactory", "bitmap recycle %s errorLevel:%s", new Object[] { localBitmap, Integer.valueOf(paramInt1) });
          localBitmap.recycle();
          AppMethodBeat.o(141983);
          return paramContext;
        }
        ab.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[] { paramContext });
        continue;
      }
      ab.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[] { Integer.valueOf(paramInt2), bo.dtY().toString() });
      paramContext = null;
      continue;
      label513:
      paramInt1 = paramInt3;
      continue;
      label519:
      paramInt1 = 3;
    }
  }
  
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, x.a parama, int paramInt2)
  {
    AppMethodBeat.i(141981);
    paramContext = a(paramContext, paramString1, paramString2, paramInt1, paramString3, parama, false, paramInt2);
    AppMethodBeat.o(141981);
    return paramContext;
  }
  
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, x.a parama, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(141982);
    paramContext = a(paramContext, paramString1, paramString2, paramInt1, paramString3, BackwardSupportUtil.b.b(paramContext, 197.0F), parama, paramBoolean, paramInt2);
    AppMethodBeat.o(141982);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.b
 * JD-Core Version:    0.7.0.1
 */