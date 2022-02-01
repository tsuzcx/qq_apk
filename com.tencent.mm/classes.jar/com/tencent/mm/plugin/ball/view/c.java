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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static final int nOH;
  private static final int nOI;
  private static final int nOJ;
  private static final int nOK;
  private static final int nOL;
  private static final int nOM;
  private static final int nON;
  private static final int nOO;
  private static final int nOP;
  private static final int nOQ;
  private final Context mContext;
  public final b nOR;
  private final c nOS;
  private String nOT;
  private final Map<String, Integer> nOU;
  private final b nOV;
  
  static
  {
    AppMethodBeat.i(106429);
    nOH = ak.getContext().getResources().getDimensionPixelSize(2131166323);
    nOI = ak.getContext().getResources().getDimensionPixelSize(2131166313);
    nOJ = ak.getContext().getResources().getDimensionPixelSize(2131166335);
    nOK = ak.getContext().getResources().getDimensionPixelSize(2131166317);
    nOL = ak.getContext().getResources().getDimensionPixelSize(2131166315);
    nOM = ak.getContext().getResources().getDimensionPixelSize(2131166322);
    nON = ak.getContext().getResources().getDimensionPixelSize(2131166312);
    nOO = ak.getContext().getResources().getDimensionPixelSize(2131166334);
    nOP = ak.getContext().getResources().getDimensionPixelSize(2131166316);
    nOQ = ak.getContext().getResources().getDimensionPixelSize(2131166314);
    AppMethodBeat.o(106429);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(106422);
    this.nOV = new b()
    {
      public final void a(Bitmap paramAnonymousBitmap, c.a paramAnonymousa)
      {
        AppMethodBeat.i(106406);
        if (!paramAnonymousa.nOY.equals(c.a(c.this)))
        {
          ae.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, listKey not same");
          AppMethodBeat.o(106406);
          return;
        }
        int i = paramAnonymousa.index;
        ae.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, index:%d, bitmap:%s", new Object[] { Integer.valueOf(i), paramAnonymousBitmap });
        paramAnonymousa = c.b(c.this);
        if ((!paramAnonymousa.mInited) && (i >= 0) && (i < paramAnonymousa.nOr.size()))
        {
          ae.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, before init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.d)paramAnonymousa.nOr.get(i)).bitmap, paramAnonymousBitmap });
          ((b.d)paramAnonymousa.nOr.get(i)).bitmap = paramAnonymousBitmap;
        }
        for (;;)
        {
          c.a(c.this, paramAnonymousBitmap, i, c.a(c.this));
          AppMethodBeat.o(106406);
          return;
          if ((i < 0) || (i >= paramAnonymousa.nOj.size()))
          {
            ae.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, invalid range, index:%s, size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousa.nOj.size()) });
          }
          else
          {
            ae.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, after init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.c)paramAnonymousa.nOj.get(i)).bMw().bitmap, paramAnonymousBitmap });
            ((b.c)paramAnonymousa.nOj.get(i)).bMw().bitmap = paramAnonymousBitmap;
            if (!paramAnonymousa.nOo)
            {
              ae.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, not animating");
              paramAnonymousa.postInvalidate();
            }
            else
            {
              ae.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, is animating");
            }
          }
        }
      }
    };
    this.nOR = new b(paramContext);
    this.mContext = paramContext;
    this.nOS = new c(this.mContext);
    this.nOU = new HashMap();
    AppMethodBeat.o(106422);
  }
  
  private void a(Bitmap paramBitmap, final int paramInt, final String paramString)
  {
    AppMethodBeat.i(106426);
    d.a(paramBitmap, new d.a()
    {
      public final void yh(int paramAnonymousInt)
      {
        AppMethodBeat.i(106407);
        if (!paramString.equals(c.a(c.this)))
        {
          ae.i("MicroMsg.FloatBallCrescentViewHelper", "pickColor listKey not same");
          AppMethodBeat.o(106407);
          return;
        }
        b localb = c.b(c.this);
        int i = paramInt;
        if ((i < 0) || (i >= localb.nOj.size()))
        {
          AppMethodBeat.o(106407);
          return;
        }
        ((b.c)localb.nOj.get(i)).bMw().nOE = paramAnonymousInt;
        if (!localb.nOo) {
          localb.postInvalidate();
        }
        AppMethodBeat.o(106407);
      }
    });
    AppMethodBeat.o(106426);
  }
  
  private int ca(List<BallInfo> paramList)
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
    int m = paramList.size() - this.nOU.size();
    i = k;
    Object localObject;
    if (this.nOU.size() != 0)
    {
      if (m != -1) {
        break label230;
      }
      paramList = this.nOU.entrySet().iterator();
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
      this.nOU.clear();
      this.nOU.putAll(localHashMap);
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
          if (!this.nOU.containsKey(localObject)) {
            k = j;
          }
          j += 1;
        }
        i = -2147483648;
      }
    }
  }
  
  private static String cb(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106425);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.dEM).append(localBallInfo.mdM).append("|");
      i += 1;
    }
    paramList = aj.ej(localStringBuilder.toString());
    AppMethodBeat.o(106425);
    return paramList;
  }
  
  private static int yi(int paramInt)
  {
    if (paramInt == 1) {
      return nOH;
    }
    if (paramInt == 2) {
      return nOI;
    }
    if (paramInt == 3) {
      return nOJ;
    }
    if (paramInt == 4) {
      return nOK;
    }
    return nOL;
  }
  
  private static int yj(int paramInt)
  {
    if (paramInt == 1) {
      return nOM;
    }
    if (paramInt == 2) {
      return nON;
    }
    if (paramInt == 3) {
      return nOO;
    }
    if (paramInt == 4) {
      return nOP;
    }
    return nOQ;
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106423);
    paramList = d.bY(paramList);
    paramBallInfo = cb(paramList);
    if (paramBallInfo.equals(this.nOT))
    {
      ae.i("MicroMsg.FloatBallCrescentViewHelper", "onFloatBallInfoChanged, list key not change");
      AppMethodBeat.o(106423);
      return;
    }
    this.nOT = paramBallInfo;
    int j = paramList.size();
    paramBallInfo = new ArrayList();
    int i = 0;
    while (i < j)
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      b.d locald = new b.d();
      this.nOS.a(localBallInfo, locald, i, this.nOT, this.nOV);
      if (locald.isValid())
      {
        paramBallInfo.add(locald);
        if (locald.bitmap != null) {
          a(locald.bitmap, i, this.nOT);
        }
      }
      i += 1;
    }
    i = ca(paramList);
    this.nOR.a(paramBallInfo, yi(j), yj(j), i);
    AppMethodBeat.o(106423);
  }
  
  static final class a
  {
    int index;
    String nOY;
    String url;
  }
  
  static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap, c.a parama);
  }
  
  static final class c
  {
    final Context mContext;
    final h<String, Bitmap> nOZ;
    final Map<Integer, Integer> nPa;
    final a nPb;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(106414);
      this.mContext = paramContext;
      this.nPb = new a();
      this.nOZ = new h(24);
      this.nPa = new HashMap();
      AppMethodBeat.o(106414);
    }
    
    private static int I(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(176976);
      if (paramBallInfo.nLu) {}
      for (int i = d.yg(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1) {
          j = paramBallInfo.mdM;
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
      com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
      {
        public final String BN()
        {
          AppMethodBeat.i(106411);
          String str = aj.ej(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106411);
          return str;
        }
        
        public final void F(final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106409);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106408);
              ae.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, onBitmapLoaded, url:%s", new Object[] { c.c.1.this.val$url });
              c.c.this.nOZ.put(aj.ej(c.c.1.this.val$url), paramAnonymousBitmap);
              c.c.1.this.nPc.a(paramAnonymousBitmap, c.c.1.this.nPd);
              AppMethodBeat.o(106408);
            }
          });
          AppMethodBeat.o(106409);
        }
        
        public final void aEt() {}
        
        public final void ox()
        {
          AppMethodBeat.i(106410);
          AppMethodBeat.o(106410);
        }
      }, str, new b.h()
      {
        public final String BN()
        {
          AppMethodBeat.i(106413);
          String str = aj.ej(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106413);
          return str;
        }
        
        public final Bitmap G(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106412);
          int i = c.bMx();
          float f1 = i / paramAnonymousBitmap.getWidth();
          float f2 = i / paramAnonymousBitmap.getHeight();
          ae.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, transform targetSize:%d scaled:%f", new Object[] { Integer.valueOf(i), Float.valueOf(f2) });
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
        paramd.bitmap = yk(paramInt);
        AppMethodBeat.o(106417);
        return true;
      }
      catch (Exception paramd)
      {
        ae.w("MicroMsg.FloatBallCrescentViewHelper", "loadResource exp:%s", new Object[] { paramd.getCause() });
        AppMethodBeat.o(106417);
      }
      return false;
    }
    
    private boolean a(BallInfo paramBallInfo, b.d paramd)
    {
      AppMethodBeat.i(106419);
      if (paramBallInfo.nLu) {
        ae.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, passive icon res");
      }
      for (int i = d.yg(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1)
        {
          ae.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, default icon res");
          j = d.yf(paramBallInfo.type);
        }
        paramd.bitmap = yk(j);
        AppMethodBeat.o(106419);
        return true;
      }
    }
    
    private boolean b(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106418);
      paramBallInfo = paramBallInfo.dEM;
      if (bu.isNullOrNil(paramBallInfo))
      {
        AppMethodBeat.o(106418);
        return false;
      }
      Object localObject = aj.ej(paramBallInfo);
      localObject = (Bitmap)this.nOZ.get(localObject);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        paramd.bitmap = ((Bitmap)localObject);
        ae.i("MicroMsg.FloatBallCrescentViewHelper", "loadIconUrl, from cache");
        AppMethodBeat.o(106418);
        return true;
      }
      paramd = new c.a((byte)0);
      paramd.url = paramBallInfo;
      paramd.index = paramInt;
      paramd.nOY = paramString;
      a(paramd, paramb);
      AppMethodBeat.o(106418);
      return false;
    }
    
    private Bitmap yk(int paramInt)
    {
      AppMethodBeat.i(106420);
      String str = aj.ej(String.valueOf(paramInt));
      Bitmap localBitmap2 = (Bitmap)this.nOZ.get(str);
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
      {
        ae.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap, from cache");
        AppMethodBeat.o(106420);
        return localBitmap2;
      }
      Bitmap localBitmap1;
      if (this.nPb.i(this.mContext.getResources(), paramInt))
      {
        ae.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap svg, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        Bitmap localBitmap3 = a.h(this.mContext.getResources(), paramInt);
        localBitmap1 = localBitmap2;
        if (localBitmap3 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap3.isRecycled())
          {
            int i = localBitmap3.getWidth();
            float f = (float)(c.nOH * 1.0D / i);
            localBitmap1 = a.b(this.mContext.getResources(), paramInt, f);
            localBitmap3.recycle();
          }
        }
      }
      for (;;)
      {
        this.nOZ.put(str, localBitmap1);
        AppMethodBeat.o(106420);
        return localBitmap1;
        ae.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap normal, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
      }
    }
    
    public final void a(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106415);
      if (a(I(paramBallInfo), paramd))
      {
        ae.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadResource");
        AppMethodBeat.o(106415);
        return;
      }
      if (b(paramBallInfo, paramd, paramInt, paramString, paramb))
      {
        ae.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadIconUrl");
        AppMethodBeat.o(106415);
        return;
      }
      ae.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadDefault");
      a(paramBallInfo, paramd);
      AppMethodBeat.o(106415);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.c
 * JD-Core Version:    0.7.0.1
 */