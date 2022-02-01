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
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.f.d.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.svg.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements e
{
  private static final int mGD;
  private static final int mGE;
  private static final int mGF;
  private static final int mGG;
  private static final int mGH;
  private static final int mGI;
  private static final int mGJ;
  private static final int mGK;
  private static final int mGL;
  private static final int mGM;
  private final Context mContext;
  public final b mGN;
  private final c mGO;
  private String mGP;
  private final Map<String, Integer> mGQ;
  private final b mGR;
  
  static
  {
    AppMethodBeat.i(106429);
    mGD = aj.getContext().getResources().getDimensionPixelSize(2131166323);
    mGE = aj.getContext().getResources().getDimensionPixelSize(2131166313);
    mGF = aj.getContext().getResources().getDimensionPixelSize(2131166335);
    mGG = aj.getContext().getResources().getDimensionPixelSize(2131166317);
    mGH = aj.getContext().getResources().getDimensionPixelSize(2131166315);
    mGI = aj.getContext().getResources().getDimensionPixelSize(2131166322);
    mGJ = aj.getContext().getResources().getDimensionPixelSize(2131166312);
    mGK = aj.getContext().getResources().getDimensionPixelSize(2131166334);
    mGL = aj.getContext().getResources().getDimensionPixelSize(2131166316);
    mGM = aj.getContext().getResources().getDimensionPixelSize(2131166314);
    AppMethodBeat.o(106429);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(106422);
    this.mGR = new b()
    {
      public final void a(Bitmap paramAnonymousBitmap, c.a paramAnonymousa)
      {
        AppMethodBeat.i(106406);
        if (!paramAnonymousa.mGU.equals(c.a(c.this)))
        {
          ad.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, listKey not same");
          AppMethodBeat.o(106406);
          return;
        }
        int i = paramAnonymousa.index;
        ad.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, index:%d, bitmap:%s", new Object[] { Integer.valueOf(i), paramAnonymousBitmap });
        paramAnonymousa = c.b(c.this);
        if ((!paramAnonymousa.mInited) && (i >= 0) && (i < paramAnonymousa.mGn.size()))
        {
          ad.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, before init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.d)paramAnonymousa.mGn.get(i)).bitmap, paramAnonymousBitmap });
          ((b.d)paramAnonymousa.mGn.get(i)).bitmap = paramAnonymousBitmap;
        }
        for (;;)
        {
          c.a(c.this, paramAnonymousBitmap, i, c.a(c.this));
          AppMethodBeat.o(106406);
          return;
          if ((i < 0) || (i >= paramAnonymousa.mGf.size()))
          {
            ad.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, invalid range, index:%s, size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousa.mGf.size()) });
          }
          else
          {
            ad.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, after init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.c)paramAnonymousa.mGf.get(i)).bAt().bitmap, paramAnonymousBitmap });
            ((b.c)paramAnonymousa.mGf.get(i)).bAt().bitmap = paramAnonymousBitmap;
            if (!paramAnonymousa.mGk)
            {
              ad.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, not animating");
              paramAnonymousa.postInvalidate();
            }
            else
            {
              ad.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, is animating");
            }
          }
        }
      }
    };
    this.mGN = new b(paramContext);
    this.mContext = paramContext;
    this.mGO = new c(this.mContext);
    this.mGQ = new HashMap();
    AppMethodBeat.o(106422);
  }
  
  private void a(Bitmap paramBitmap, final int paramInt, final String paramString)
  {
    AppMethodBeat.i(106426);
    d.a(paramBitmap, new d.a()
    {
      public final void wH(int paramAnonymousInt)
      {
        AppMethodBeat.i(106407);
        if (!paramString.equals(c.a(c.this)))
        {
          ad.i("MicroMsg.FloatBallCrescentViewHelper", "pickColor listKey not same");
          AppMethodBeat.o(106407);
          return;
        }
        b localb = c.b(c.this);
        int i = paramInt;
        if ((i < 0) || (i >= localb.mGf.size()))
        {
          AppMethodBeat.o(106407);
          return;
        }
        ((b.c)localb.mGf.get(i)).bAt().mGA = paramAnonymousInt;
        if (!localb.mGk) {
          localb.postInvalidate();
        }
        AppMethodBeat.o(106407);
      }
    });
    AppMethodBeat.o(106426);
  }
  
  private int bX(List<BallInfo> paramList)
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
    int m = paramList.size() - this.mGQ.size();
    i = k;
    Object localObject;
    if (this.mGQ.size() != 0)
    {
      if (m != -1) {
        break label230;
      }
      paramList = this.mGQ.entrySet().iterator();
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
      this.mGQ.clear();
      this.mGQ.putAll(localHashMap);
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
          if (!this.mGQ.containsKey(localObject)) {
            k = j;
          }
          j += 1;
        }
        i = -2147483648;
      }
    }
  }
  
  private static String bY(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106425);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.dub).append(localBallInfo.kYl).append("|");
      i += 1;
    }
    paramList = ai.du(localStringBuilder.toString());
    AppMethodBeat.o(106425);
    return paramList;
  }
  
  private static int wI(int paramInt)
  {
    if (paramInt == 1) {
      return mGD;
    }
    if (paramInt == 2) {
      return mGE;
    }
    if (paramInt == 3) {
      return mGF;
    }
    if (paramInt == 4) {
      return mGG;
    }
    return mGH;
  }
  
  private static int wJ(int paramInt)
  {
    if (paramInt == 1) {
      return mGI;
    }
    if (paramInt == 2) {
      return mGJ;
    }
    if (paramInt == 3) {
      return mGK;
    }
    if (paramInt == 4) {
      return mGL;
    }
    return mGM;
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106423);
    paramList = d.bV(paramList);
    paramBallInfo = bY(paramList);
    if (paramBallInfo.equals(this.mGP))
    {
      ad.i("MicroMsg.FloatBallCrescentViewHelper", "onFloatBallInfoChanged, list key not change");
      AppMethodBeat.o(106423);
      return;
    }
    this.mGP = paramBallInfo;
    int j = paramList.size();
    paramBallInfo = new ArrayList();
    int i = 0;
    while (i < j)
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      b.d locald = new b.d();
      this.mGO.a(localBallInfo, locald, i, this.mGP, this.mGR);
      if (locald.isValid())
      {
        paramBallInfo.add(locald);
        if (locald.bitmap != null) {
          a(locald.bitmap, i, this.mGP);
        }
      }
      i += 1;
    }
    i = bX(paramList);
    this.mGN.a(paramBallInfo, wI(j), wJ(j), i);
    AppMethodBeat.o(106423);
  }
  
  static final class a
  {
    int index;
    String mGU;
    String url;
  }
  
  static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap, c.a parama);
  }
  
  static final class c
  {
    final Context mContext;
    final h<String, Bitmap> mGV;
    final Map<Integer, Integer> mGW;
    final a mGX;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(106414);
      this.mContext = paramContext;
      this.mGX = new a();
      this.mGV = new h(24);
      this.mGW = new HashMap();
      AppMethodBeat.o(106414);
    }
    
    private static int F(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(176976);
      if (paramBallInfo.mDu) {}
      for (int i = d.wG(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1) {
          j = paramBallInfo.kYl;
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
      com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
      {
        public final String AL()
        {
          AppMethodBeat.i(106411);
          String str = ai.du(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106411);
          return str;
        }
        
        public final void E(final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106409);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106408);
              ad.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, onBitmapLoaded, url:%s", new Object[] { c.c.1.this.val$url });
              c.c.this.mGV.put(ai.du(c.c.1.this.val$url), paramAnonymousBitmap);
              c.c.1.this.mGY.a(paramAnonymousBitmap, c.c.1.this.mGZ);
              AppMethodBeat.o(106408);
            }
          });
          AppMethodBeat.o(106409);
        }
        
        public final void auj() {}
        
        public final void nV()
        {
          AppMethodBeat.i(106410);
          AppMethodBeat.o(106410);
        }
      }, str, new b.h()
      {
        public final String AL()
        {
          AppMethodBeat.i(106413);
          String str = ai.du(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106413);
          return str;
        }
        
        public final Bitmap F(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106412);
          int i = c.bAu();
          float f1 = i / paramAnonymousBitmap.getWidth();
          float f2 = i / paramAnonymousBitmap.getHeight();
          ad.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, transform targetSize:%d scaled:%f", new Object[] { Integer.valueOf(i), Float.valueOf(f2) });
          Object localObject = new Matrix();
          ((Matrix)localObject).postScale(f1, f2);
          localObject = Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight(), (Matrix)localObject, true);
          paramAnonymousBitmap.recycle();
          AppMethodBeat.o(106412);
          return localObject;
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
        paramd.bitmap = wK(paramInt);
        AppMethodBeat.o(106417);
        return true;
      }
      catch (Exception paramd)
      {
        ad.w("MicroMsg.FloatBallCrescentViewHelper", "loadResource exp:%s", new Object[] { paramd.getCause() });
        AppMethodBeat.o(106417);
      }
      return false;
    }
    
    private boolean a(BallInfo paramBallInfo, b.d paramd)
    {
      AppMethodBeat.i(106419);
      if (paramBallInfo.mDu) {
        ad.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, passive icon res");
      }
      for (int i = d.wG(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1)
        {
          ad.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, default icon res");
          j = d.wF(paramBallInfo.type);
        }
        paramd.bitmap = wK(j);
        AppMethodBeat.o(106419);
        return true;
      }
    }
    
    private boolean b(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106418);
      paramBallInfo = paramBallInfo.dub;
      if (bt.isNullOrNil(paramBallInfo))
      {
        AppMethodBeat.o(106418);
        return false;
      }
      Object localObject = ai.du(paramBallInfo);
      localObject = (Bitmap)this.mGV.get(localObject);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        paramd.bitmap = ((Bitmap)localObject);
        ad.i("MicroMsg.FloatBallCrescentViewHelper", "loadIconUrl, from cache");
        AppMethodBeat.o(106418);
        return true;
      }
      paramd = new c.a((byte)0);
      paramd.url = paramBallInfo;
      paramd.index = paramInt;
      paramd.mGU = paramString;
      a(paramd, paramb);
      AppMethodBeat.o(106418);
      return false;
    }
    
    private Bitmap wK(int paramInt)
    {
      AppMethodBeat.i(106420);
      String str = ai.du(String.valueOf(paramInt));
      Bitmap localBitmap2 = (Bitmap)this.mGV.get(str);
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
      {
        ad.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap, from cache");
        AppMethodBeat.o(106420);
        return localBitmap2;
      }
      Bitmap localBitmap1;
      if (this.mGX.i(this.mContext.getResources(), paramInt))
      {
        ad.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap svg, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        Bitmap localBitmap3 = a.h(this.mContext.getResources(), paramInt);
        localBitmap1 = localBitmap2;
        if (localBitmap3 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap3.isRecycled())
          {
            int i = localBitmap3.getWidth();
            float f = (float)(c.mGD * 1.0D / i);
            localBitmap1 = a.b(this.mContext.getResources(), paramInt, f);
            localBitmap3.recycle();
          }
        }
      }
      for (;;)
      {
        this.mGV.put(str, localBitmap1);
        AppMethodBeat.o(106420);
        return localBitmap1;
        ad.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap normal, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
      }
    }
    
    public final void a(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106415);
      if (a(F(paramBallInfo), paramd))
      {
        ad.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadResource");
        AppMethodBeat.o(106415);
        return;
      }
      if (b(paramBallInfo, paramd, paramInt, paramString, paramb))
      {
        ad.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadIconUrl");
        AppMethodBeat.o(106415);
        return;
      }
      ad.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadDefault");
      a(paramBallInfo, paramd);
      AppMethodBeat.o(106415);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.c
 * JD-Core Version:    0.7.0.1
 */