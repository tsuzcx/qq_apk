package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

 enum x$b
{
  private static DisplayMetrics eRM = null;
  private Map<String, x.b.c> eRI = new HashMap();
  private Map<String, WeakReference<Bitmap>> eRJ = new HashMap();
  private av eRK = null;
  private av eRL = null;
  
  private x$b() {}
  
  private void b(v paramv, Bitmap paramBitmap)
  {
    Assert.assertTrue("picture strategy here must be validity", x.c(paramv));
    String str = paramv.getCacheKey();
    if (this.eRJ.containsKey(str)) {}
    for (paramv = (Bitmap)((WeakReference)this.eRJ.get(str)).get();; paramv = null)
    {
      if ((paramv == null) || (paramv.isRecycled()))
      {
        this.eRJ.remove(str);
        this.eRJ.put(str, new WeakReference(paramBitmap));
      }
      return;
    }
  }
  
  private Bitmap d(v paramv)
  {
    Assert.assertTrue("picture strategy here must be validity", x.c(paramv));
    String str = paramv.UP();
    x.b.c localc = (x.b.c)this.eRI.get(str);
    Object localObject = localc;
    if (localc == null) {
      localObject = new x.b.c();
    }
    if (((x.b.c)localObject).eRQ) {
      if (((x.b.c)localObject).eRR >= 3)
      {
        if (bk.cn(((x.b.c)localObject).eRS) < 120L)
        {
          y.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
          return null;
        }
        ((x.b.c)localObject).eRR = 0;
        ((x.b.c)localObject).eRQ = false;
        ((x.b.c)localObject).eRS = ((int)bk.UX());
        this.eRI.put(str, localObject);
        label133:
        if (!paramv.UR()) {
          break label342;
        }
        localObject = paramv.UN();
        if (localObject == null) {
          break label279;
        }
      }
    }
    label279:
    for (localObject = ((v.b)localObject).pe(paramv.UO());; localObject = pg(paramv.UO()))
    {
      if (localObject == null) {
        break label292;
      }
      paramv = a(paramv, (Bitmap)localObject);
      this.eRI.remove(str);
      return paramv;
      ((x.b.c)localObject).eRR += 1;
      break;
      if (bk.cn(((x.b.c)localObject).eRS) < 120L)
      {
        y.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
        return null;
      }
      ((x.b.c)localObject).eRR += 1;
      ((x.b.c)localObject).eRS = ((int)bk.UX());
      this.eRI.put(str, localObject);
      break label133;
    }
    label292:
    if ((this.eRK == null) || (this.eRK.crx())) {
      this.eRK = new av(1, "readerapp-pic-logic-download", 3);
    }
    this.eRK.c(new x.b.a(paramv));
    return null;
    label342:
    if ((this.eRL == null) || (this.eRL.crx())) {
      this.eRL = new av(1, "readerapp-pic-logic-reader", 1);
    }
    this.eRL.c(new x.b.b(paramv));
    return null;
  }
  
  public static Bitmap o(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    if (bk.bl(paramString)) {
      y.w("MicroMsg.MMPictureLogic", "error input, path is null");
    }
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger;
    Bitmap localBitmap;
    do
    {
      do
      {
        return localObject;
        if ((paramInt1 <= 0) || (paramInt2 <= 0))
        {
          y.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          return null;
        }
        localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
        localBitmap = c.a(paramString, paramInt1, paramInt2, localDecodeResultLogger, 0, new int[0]);
        localObject = localBitmap;
      } while (localBitmap != null);
      localObject = localBitmap;
    } while (localDecodeResultLogger.getDecodeResult() < 2000);
    paramString = MMBitmapFactory.KVStatHelper.getKVStatString(paramString, 8, localDecodeResultLogger);
    h.nFQ.aC(12712, paramString);
    return localBitmap;
  }
  
  public static Bitmap pg(String paramString)
  {
    if (eRM == null) {
      eRM = ae.getContext().getResources().getDisplayMetrics();
    }
    DisplayMetrics localDisplayMetrics = eRM;
    return o(paramString, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public static Bitmap ph(String paramString)
  {
    Object localObject;
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.MMPictureLogic", "error input, path is null");
      localObject = null;
    }
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger;
    Bitmap localBitmap;
    do
    {
      do
      {
        return localObject;
        localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
        localBitmap = c.a(paramString, 0, 0, localDecodeResultLogger, 0, new int[0]);
        localObject = localBitmap;
      } while (localBitmap != null);
      localObject = localBitmap;
    } while (localDecodeResultLogger.getDecodeResult() < 2000);
    paramString = MMBitmapFactory.KVStatHelper.getKVStatString(paramString, 8, localDecodeResultLogger);
    h.nFQ.aC(12712, paramString);
    return localBitmap;
  }
  
  protected final Bitmap a(v paramv, Bitmap paramBitmap)
  {
    Assert.assertTrue("picture strategy here must be validity", x.c(paramv));
    if (paramBitmap != null)
    {
      Bitmap localBitmap = paramv.a(paramBitmap, v.a.eRE, paramv.UO());
      if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
      {
        y.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
      }
      b(paramv, localBitmap);
      return localBitmap;
    }
    paramv.a(v.a.eRE, null);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.x.b
 * JD-Core Version:    0.7.0.1
 */