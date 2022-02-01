package com.tencent.mm.al;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.e;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o
{
  public static Bitmap Nw(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(124113);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) || (!com.tencent.mm.kernel.g.aAf().azp()))
    {
      AppMethodBeat.o(124113);
      return null;
    }
    Bitmap localBitmap = ag.bas().Nx(paramString);
    if (localBitmap == null) {
      bool = true;
    }
    Log.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", new Object[] { paramString, String.valueOf(bool) });
    AppMethodBeat.o(124113);
    return localBitmap;
  }
  
  private static Bitmap aZW()
  {
    localObject1 = null;
    AppMethodBeat.i(124115);
    Object localObject4 = new BitmapFactory.Options();
    BitmapUtil.bindlowMemeryOption((BitmapFactory.Options)localObject4);
    try
    {
      Object localObject2 = MMApplicationContext.getContext().getResources().openRawResource(2131234281);
      localObject1 = localObject2;
      localObject4 = BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject4);
      localObject1 = localObject4;
      if (localObject2 != null) {}
      try
      {
        ((InputStream)localObject2).close();
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = BitmapUtil.getRoundedCornerBitmap(localObject1, false, localObject1.getWidth() >> 1);
        }
        AppMethodBeat.o(124115);
        return localObject2;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.BrandLogic", localIOException2, "", new Object[0]);
        }
      }
      try
      {
        localObject1.close();
        AppMethodBeat.o(124115);
        throw localObject3;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.BrandLogic", localIOException1, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static Bitmap bg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124114);
    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
    {
      paramString1 = aZW();
      AppMethodBeat.o(124114);
      return paramString1;
    }
    if ((paramString1 == null) || (!com.tencent.mm.kernel.g.aAf().azp()))
    {
      AppMethodBeat.o(124114);
      return null;
    }
    final String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = bh(paramString1, null);
      str = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(124114);
        return null;
      }
    }
    paramString2 = ag.bas();
    Object localObject;
    if (paramString2.iOK.containsKey(paramString1))
    {
      localObject = (Bitmap)((WeakReference)paramString2.iOK.get(paramString1)).get();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        localObject = bh(paramString1, str);
        localObject = BitmapUtil.getBitmapNative(a.Ny(paramString1 + (String)localObject));
        if (localObject == null)
        {
          Log.i("MicroMsg.BrandLogic", "not found brand icon local");
          paramString2 = null;
          label162:
          if (paramString2 == null) {
            break label262;
          }
          AppMethodBeat.o(124114);
          return paramString2;
        }
        paramString2.f(paramString1, (Bitmap)localObject);
      }
    }
    for (;;)
    {
      paramString2 = (WeakReference)paramString2.iOK.get(paramString1);
      if (paramString2 == null) {
        break;
      }
      paramString2 = (Bitmap)paramString2.get();
      break label162;
      localObject = bh(paramString1, str);
      localObject = BitmapUtil.getBitmapNative(a.Ny(paramString1 + (String)localObject));
      if (localObject == null)
      {
        Log.i("MicroMsg.BrandLogic", "not found brand icon local");
        break;
      }
      paramString2.f(paramString1, (Bitmap)localObject);
    }
    label262:
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124105);
        o.a locala = ag.bas();
        String str1 = this.iOG;
        String str2 = str;
        if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
        {
          Log.e("MicroMsg.BrandLogic", "pushing for brand " + str1 + ", url " + str2);
          AppMethodBeat.o(124105);
          return;
        }
        if (Util.secondsToNow(Util.nullAsNil((Integer)locala.iOJ.get(str1))) < 300L)
        {
          Log.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for ".concat(String.valueOf(str1)));
          AppMethodBeat.o(124105);
          return;
        }
        locala.iOJ.put(str1, Integer.valueOf((int)Util.nowSecond()));
        if ((locala.iOL == null) || (locala.iOL.isDead())) {
          locala.iOL = new QueueWorkerThread(1, "brand-logic");
        }
        str2 = o.bh(str1, str2);
        locala.iOL.add(new o.b(str1, str2));
        AppMethodBeat.o(124105);
      }
    });
    AppMethodBeat.o(124114);
    return null;
  }
  
  static String bh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124116);
    if ((paramString1 == null) || (!com.tencent.mm.kernel.g.aAf().azp()))
    {
      AppMethodBeat.o(124116);
      return null;
    }
    paramString1 = ag.bah().MT(paramString1);
    if (paramString1.field_brandIconURL != null)
    {
      paramString1 = paramString1.field_brandIconURL;
      AppMethodBeat.o(124116);
      return paramString1;
    }
    AppMethodBeat.o(124116);
    return paramString2;
  }
  
  public static final class a
  {
    List<Object> iOI;
    Map<String, Integer> iOJ;
    Map<String, WeakReference<Bitmap>> iOK;
    QueueWorkerThread iOL;
    
    public a()
    {
      AppMethodBeat.i(124106);
      this.iOI = new ArrayList();
      this.iOJ = new HashMap();
      this.iOK = new HashMap();
      this.iOL = null;
      AppMethodBeat.o(124106);
    }
    
    public static String Ny(String paramString)
    {
      AppMethodBeat.i(124109);
      if (com.tencent.mm.kernel.g.aAf().azp())
      {
        paramString = ((q)com.tencent.mm.kernel.g.af(q.class)).aTh() + "/brand_" + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
        AppMethodBeat.o(124109);
        return paramString;
      }
      AppMethodBeat.o(124109);
      return "";
    }
    
    final Bitmap Nx(String paramString)
    {
      AppMethodBeat.i(124108);
      String str = String.format("%s%f", new Object[] { paramString, Float.valueOf(1.5F) });
      Bitmap localBitmap1;
      if (this.iOK.containsKey(str))
      {
        Bitmap localBitmap2 = (Bitmap)((WeakReference)this.iOK.get(str)).get();
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap2.isRecycled()) {}
        }
        else
        {
          localBitmap1 = BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.5F);
          this.iOK.remove(str);
          this.iOK.put(str, new WeakReference(localBitmap1));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(124108);
        return localBitmap1;
        localBitmap1 = BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.5F);
        this.iOK.put(str, new WeakReference(localBitmap1));
      }
    }
    
    public final void aZX()
    {
      AppMethodBeat.i(124107);
      this.iOI.clear();
      AppMethodBeat.o(124107);
    }
    
    final void f(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(124110);
      Bitmap localBitmap1;
      if (this.iOK.containsKey(paramString)) {
        localBitmap1 = (Bitmap)((WeakReference)this.iOK.get(paramString)).get();
      }
      for (;;)
      {
        Bitmap localBitmap3;
        if (localBitmap1 != null)
        {
          localBitmap3 = localBitmap1;
          if (!localBitmap1.isRecycled()) {
            break label110;
          }
        }
        try
        {
          localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, 128, 128, true);
          localBitmap1 = BitmapUtil.getRoundedCornerBitmap(localBitmap1, true, localBitmap1.getWidth() >> 1);
          this.iOK.remove(paramString);
          this.iOK.put(paramString, new WeakReference(localBitmap1));
          localBitmap3 = localBitmap1;
          label110:
          if (localBitmap3 == paramBitmap)
          {
            AppMethodBeat.o(124110);
            return;
            localBitmap1 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Bitmap localBitmap2 = paramBitmap;
          }
          Log.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          AppMethodBeat.o(124110);
        }
      }
    }
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    private final String brand;
    public byte[] iKr = null;
    private final String url;
    
    public b(String paramString1, String paramString2)
    {
      this.brand = paramString1;
      this.url = paramString2;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(124111);
      if ((Util.isNullOrNil(this.brand)) || (Util.isNullOrNil(this.url)))
      {
        AppMethodBeat.o(124111);
        return false;
      }
      Object localObject1;
      Object localObject2;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject1 = d.w(this.url, 3000, 5000);
        if (localObject1 == null)
        {
          AppMethodBeat.o(124111);
          return false;
        }
        localObject2 = new byte[1024];
        for (;;)
        {
          int i = ((InputStream)localObject1).read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write((byte[])localObject2, 0, i);
        }
        ((InputStream)localObject1).close();
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { Util.stackTraceToString(localException1) });
        Log.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
        this.iKr = null;
        AppMethodBeat.o(124111);
        return false;
      }
      this.iKr = localException1.toByteArray();
      localException1.close();
      if (Util.isNullOrNil(this.iKr))
      {
        Log.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.brand);
        AppMethodBeat.o(124111);
        return false;
      }
      o.a locala;
      String str;
      if (com.tencent.mm.kernel.g.aAf().azp())
      {
        ay.a.iDr.dl(this.iKr.length, 0);
        locala = ag.bas();
        localObject1 = this.brand;
        str = this.url;
        localObject2 = this.iKr;
      }
      try
      {
        str = (String)localObject1 + str;
        localObject2 = BitmapUtil.decodeByteArray((byte[])localObject2);
        BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 100, Bitmap.CompressFormat.PNG, o.a.Ny(str), false);
        locala.f((String)localObject1, (Bitmap)localObject2);
        Log.i("MicroMsg.BrandLogic", "update brand icon for  " + (String)localObject1 + ", done");
        locala.iOJ.remove(localObject1);
        AppMethodBeat.o(124111);
        return true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { Util.stackTraceToString(localException2) });
        }
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(124112);
      o.a locala = ag.bas();
      int i = 0;
      try
      {
        while (i < locala.iOI.size())
        {
          locala.iOI.get(i);
          i += 1;
        }
        return false;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(124112);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.o
 * JD-Core Version:    0.7.0.1
 */