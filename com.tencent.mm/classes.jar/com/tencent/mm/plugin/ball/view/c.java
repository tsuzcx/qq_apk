package com.tencent.mm.plugin.ball.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.ball.f.d.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.svg.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.ball.c.d
{
  private static final int oZA;
  private static final int oZB;
  private static final int oZC;
  private static final int oZD;
  private static final int oZE;
  private static final int oZF;
  private static final int oZG;
  private static final int oZH;
  private static final int oZI;
  private static final int oZJ;
  private final Context mContext;
  public final b oZK;
  private final c oZL;
  private String oZM;
  private final Map<String, Integer> oZN;
  private final b oZO;
  
  static
  {
    AppMethodBeat.i(106429);
    oZA = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166411);
    oZB = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166397);
    oZC = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166424);
    oZD = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166401);
    oZE = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166399);
    oZF = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166410);
    oZG = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166396);
    oZH = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166423);
    oZI = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166400);
    oZJ = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166398);
    AppMethodBeat.o(106429);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(106422);
    this.oZO = new b()
    {
      public final void a(Bitmap paramAnonymousBitmap, c.a paramAnonymousa)
      {
        AppMethodBeat.i(106406);
        if (!paramAnonymousa.oZR.equals(c.a(c.this)))
        {
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, listKey not same");
          AppMethodBeat.o(106406);
          return;
        }
        int i = paramAnonymousa.index;
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, index:%d, bitmap:%s", new Object[] { Integer.valueOf(i), paramAnonymousBitmap });
        paramAnonymousa = c.b(c.this);
        if ((!paramAnonymousa.mInited) && (i >= 0) && (i < paramAnonymousa.oZk.size()))
        {
          Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, before init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.d)paramAnonymousa.oZk.get(i)).bitmap, paramAnonymousBitmap });
          ((b.d)paramAnonymousa.oZk.get(i)).bitmap = paramAnonymousBitmap;
        }
        for (;;)
        {
          c.a(c.this, paramAnonymousBitmap, i, c.a(c.this));
          AppMethodBeat.o(106406);
          return;
          if ((i < 0) || (i >= paramAnonymousa.oZd.size()))
          {
            Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, invalid range, index:%s, size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousa.oZd.size()) });
          }
          else
          {
            Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, after init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.c)paramAnonymousa.oZd.get(i)).cjn().bitmap, paramAnonymousBitmap });
            ((b.c)paramAnonymousa.oZd.get(i)).cjn().bitmap = paramAnonymousBitmap;
            if (!paramAnonymousa.nmN)
            {
              Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, not animating");
              paramAnonymousa.postInvalidate();
            }
            else
            {
              Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, is animating");
            }
          }
        }
      }
    };
    this.oZK = new b(paramContext);
    this.mContext = paramContext;
    this.oZL = new c(this.mContext);
    this.oZN = new HashMap();
    AppMethodBeat.o(106422);
  }
  
  private static int BO(int paramInt)
  {
    if (paramInt == 1) {
      return oZA;
    }
    if (paramInt == 2) {
      return oZB;
    }
    if (paramInt == 3) {
      return oZC;
    }
    if (paramInt == 4) {
      return oZD;
    }
    return oZE;
  }
  
  private static int BP(int paramInt)
  {
    if (paramInt == 1) {
      return oZF;
    }
    if (paramInt == 2) {
      return oZG;
    }
    if (paramInt == 3) {
      return oZH;
    }
    if (paramInt == 4) {
      return oZI;
    }
    return oZJ;
  }
  
  private void a(Bitmap paramBitmap, final int paramInt, final String paramString)
  {
    AppMethodBeat.i(106426);
    com.tencent.mm.plugin.ball.f.d.a(paramBitmap, new d.a()
    {
      public final void BN(int paramAnonymousInt)
      {
        AppMethodBeat.i(106407);
        if (!paramString.equals(c.a(c.this)))
        {
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "pickColor listKey not same");
          AppMethodBeat.o(106407);
          return;
        }
        b localb = c.b(c.this);
        int i = paramInt;
        if ((i < 0) || (i >= localb.oZd.size()))
        {
          AppMethodBeat.o(106407);
          return;
        }
        ((b.c)localb.oZd.get(i)).cjn().oZx = paramAnonymousInt;
        if (!localb.nmN) {
          localb.postInvalidate();
        }
        AppMethodBeat.o(106407);
      }
    });
    AppMethodBeat.o(106426);
  }
  
  private int cp(List<BallInfo> paramList)
  {
    int j = 0;
    AppMethodBeat.i(106424);
    int k = -2147483648;
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      localHashMap.put(((BallInfo)paramList.get(i)).key + "_" + ((BallInfo)paramList.get(i)).type, Integer.valueOf(i));
      i += 1;
    }
    int m = paramList.size() - this.oZN.size();
    i = k;
    Object localObject;
    if (this.oZN.size() != 0)
    {
      if (m != -1) {
        break label230;
      }
      paramList = this.oZN.entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        if (!localHashMap.containsKey(((Map.Entry)localObject).getKey())) {
          i = ((Integer)((Map.Entry)localObject).getValue()).intValue();
        }
      }
    }
    for (;;)
    {
      this.oZN.clear();
      this.oZN.putAll(localHashMap);
      AppMethodBeat.o(106424);
      return i;
      label230:
      i = k;
      if (m == 1)
      {
        for (;;)
        {
          i = k;
          if (j >= paramList.size()) {
            break;
          }
          localObject = ((BallInfo)paramList.get(j)).key + "_" + ((BallInfo)paramList.get(j)).type;
          if (!this.oZN.containsKey(localObject)) {
            k = j;
          }
          j += 1;
        }
        i = -2147483648;
      }
    }
  }
  
  private static String cq(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106425);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.noe).append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106425);
    return paramList;
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106423);
    paramList = com.tencent.mm.plugin.ball.f.d.cm(paramList);
    paramBallInfo = cq(paramList);
    if (paramBallInfo.equals(this.oZM))
    {
      Log.i("MicroMsg.FloatBallCrescentViewHelper", "onFloatBallInfoChanged, list key not change");
      AppMethodBeat.o(106423);
      return;
    }
    this.oZM = paramBallInfo;
    int j = paramList.size();
    paramBallInfo = new ArrayList();
    int i = 0;
    while (i < j)
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      b.d locald = new b.d();
      this.oZL.a(localBallInfo, locald, i, this.oZM, this.oZO);
      if (locald.isValid())
      {
        paramBallInfo.add(locald);
        if (locald.bitmap != null) {
          a(locald.bitmap, i, this.oZM);
        }
      }
      i += 1;
    }
    i = cp(paramList);
    this.oZK.a(paramBallInfo, BO(j), BP(j), i);
    AppMethodBeat.o(106423);
  }
  
  static final class a
  {
    int index;
    String oZR;
    String url;
  }
  
  static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap, c.a parama);
  }
  
  static final class c
  {
    final Context mContext;
    final h<String, Bitmap> oZS;
    final Map<Integer, Integer> oZT;
    final a oZU;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(106414);
      this.mContext = paramContext;
      this.oZU = new a();
      this.oZS = new h(24);
      this.oZT = new HashMap();
      AppMethodBeat.o(106414);
    }
    
    private Bitmap BQ(int paramInt)
    {
      AppMethodBeat.i(106420);
      String str = MD5Util.getMD5String(String.valueOf(paramInt));
      Bitmap localBitmap2 = (Bitmap)this.oZS.get(str);
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap, from cache");
        AppMethodBeat.o(106420);
        return localBitmap2;
      }
      Bitmap localBitmap1;
      if (this.oZU.j(this.mContext.getResources(), paramInt))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap svg, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        Bitmap localBitmap3 = a.i(this.mContext.getResources(), paramInt);
        localBitmap1 = localBitmap2;
        if (localBitmap3 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap3.isRecycled())
          {
            int i = localBitmap3.getWidth();
            float f = (float)(c.oZA * 1.0D / i);
            localBitmap1 = a.b(this.mContext.getResources(), paramInt, f);
            localBitmap3.recycle();
          }
        }
      }
      for (;;)
      {
        this.oZS.put(str, localBitmap1);
        AppMethodBeat.o(106420);
        return localBitmap1;
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap normal, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
      }
    }
    
    private static int J(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(176976);
      if (paramBallInfo.oWr) {}
      for (int i = com.tencent.mm.plugin.ball.f.d.BM(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1) {
          j = paramBallInfo.noe;
        }
        AppMethodBeat.o(176976);
        return j;
      }
    }
    
    private void a(final c.a parama, final c.b paramb)
    {
      AppMethodBeat.i(106421);
      final String str = parama.url;
      final int i = parama.index;
      com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
      {
        public final void I(final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106409);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106408);
              Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, onBitmapLoaded, url:%s", new Object[] { c.c.1.this.val$url });
              c.c.this.oZS.put(MD5Util.getMD5String(c.c.1.this.val$url), paramAnonymousBitmap);
              c.c.1.this.oZV.a(paramAnonymousBitmap, c.c.1.this.oZW);
              AppMethodBeat.o(106408);
            }
          });
          AppMethodBeat.o(106409);
        }
        
        public final String Lb()
        {
          AppMethodBeat.i(106411);
          String str = MD5Util.getMD5String(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106411);
          return str;
        }
        
        public final void aYg() {}
        
        public final void oD()
        {
          AppMethodBeat.i(106410);
          AppMethodBeat.o(106410);
        }
      }, str, new b.h()
      {
        public final Bitmap J(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106412);
          int i = c.cjo();
          float f1 = i / paramAnonymousBitmap.getWidth();
          float f2 = i / paramAnonymousBitmap.getHeight();
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, transform targetSize:%d scaled:%f", new Object[] { Integer.valueOf(i), Float.valueOf(f2) });
          Object localObject = new Matrix();
          ((Matrix)localObject).postScale(f1, f2);
          localObject = Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight(), (Matrix)localObject, true);
          paramAnonymousBitmap.recycle();
          AppMethodBeat.o(106412);
          return localObject;
        }
        
        public final String Lb()
        {
          AppMethodBeat.i(106413);
          String str = MD5Util.getMD5String(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106413);
          return str;
        }
      });
      AppMethodBeat.o(106421);
    }
    
    private boolean a(int paramInt, b.d paramd)
    {
      AppMethodBeat.i(106417);
      if (paramInt == -1)
      {
        AppMethodBeat.o(106417);
        return false;
      }
      try
      {
        paramd.bitmap = BQ(paramInt);
        AppMethodBeat.o(106417);
        return true;
      }
      catch (Exception paramd)
      {
        Log.w("MicroMsg.FloatBallCrescentViewHelper", "loadResource exp:%s", new Object[] { paramd.getCause() });
        AppMethodBeat.o(106417);
      }
      return false;
    }
    
    private boolean a(BallInfo paramBallInfo, b.d paramd)
    {
      AppMethodBeat.i(106419);
      if (paramBallInfo.oWr) {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, passive icon res");
      }
      for (int i = com.tencent.mm.plugin.ball.f.d.BM(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1)
        {
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, default icon res");
          j = com.tencent.mm.plugin.ball.f.d.BL(paramBallInfo.type);
        }
        paramd.bitmap = BQ(j);
        AppMethodBeat.o(106419);
        return true;
      }
    }
    
    private boolean b(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106418);
      paramBallInfo = paramBallInfo.icon;
      if (Util.isNullOrNil(paramBallInfo))
      {
        AppMethodBeat.o(106418);
        return false;
      }
      Object localObject = MD5Util.getMD5String(paramBallInfo);
      localObject = (Bitmap)this.oZS.get(localObject);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        paramd.bitmap = ((Bitmap)localObject);
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadIconUrl, from cache");
        AppMethodBeat.o(106418);
        return true;
      }
      paramd = new c.a((byte)0);
      paramd.url = paramBallInfo;
      paramd.index = paramInt;
      paramd.oZR = paramString;
      a(paramd, paramb);
      AppMethodBeat.o(106418);
      return false;
    }
    
    public final void a(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106415);
      if (a(J(paramBallInfo), paramd))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadResource");
        AppMethodBeat.o(106415);
        return;
      }
      if (b(paramBallInfo, paramd, paramInt, paramString, paramb))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadIconUrl");
        AppMethodBeat.o(106415);
        return;
      }
      Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadDefault");
      a(paramBallInfo, paramd);
      AppMethodBeat.o(106415);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.c
 * JD-Core Version:    0.7.0.1
 */