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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final int niI;
  private static final int niJ;
  private static final int niK;
  private static final int niL;
  private static final int niM;
  private static final int niN;
  private static final int niO;
  private static final int niP;
  private static final int niQ;
  private static final int niR;
  private final Context mContext;
  public final b niS;
  private final c niT;
  private String niU;
  private final Map<String, Integer> niV;
  private final b niW;
  
  static
  {
    AppMethodBeat.i(106429);
    niI = ai.getContext().getResources().getDimensionPixelSize(2131166323);
    niJ = ai.getContext().getResources().getDimensionPixelSize(2131166313);
    niK = ai.getContext().getResources().getDimensionPixelSize(2131166335);
    niL = ai.getContext().getResources().getDimensionPixelSize(2131166317);
    niM = ai.getContext().getResources().getDimensionPixelSize(2131166315);
    niN = ai.getContext().getResources().getDimensionPixelSize(2131166322);
    niO = ai.getContext().getResources().getDimensionPixelSize(2131166312);
    niP = ai.getContext().getResources().getDimensionPixelSize(2131166334);
    niQ = ai.getContext().getResources().getDimensionPixelSize(2131166316);
    niR = ai.getContext().getResources().getDimensionPixelSize(2131166314);
    AppMethodBeat.o(106429);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(106422);
    this.niW = new b()
    {
      public final void a(Bitmap paramAnonymousBitmap, c.a paramAnonymousa)
      {
        AppMethodBeat.i(106406);
        if (!paramAnonymousa.niZ.equals(c.a(c.this)))
        {
          ac.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, listKey not same");
          AppMethodBeat.o(106406);
          return;
        }
        int i = paramAnonymousa.index;
        ac.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, index:%d, bitmap:%s", new Object[] { Integer.valueOf(i), paramAnonymousBitmap });
        paramAnonymousa = c.b(c.this);
        if ((!paramAnonymousa.mInited) && (i >= 0) && (i < paramAnonymousa.nis.size()))
        {
          ac.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, before init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.d)paramAnonymousa.nis.get(i)).bitmap, paramAnonymousBitmap });
          ((b.d)paramAnonymousa.nis.get(i)).bitmap = paramAnonymousBitmap;
        }
        for (;;)
        {
          c.a(c.this, paramAnonymousBitmap, i, c.a(c.this));
          AppMethodBeat.o(106406);
          return;
          if ((i < 0) || (i >= paramAnonymousa.nik.size()))
          {
            ac.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, invalid range, index:%s, size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousa.nik.size()) });
          }
          else
          {
            ac.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, after init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.c)paramAnonymousa.nik.get(i)).bHp().bitmap, paramAnonymousBitmap });
            ((b.c)paramAnonymousa.nik.get(i)).bHp().bitmap = paramAnonymousBitmap;
            if (!paramAnonymousa.nip)
            {
              ac.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, not animating");
              paramAnonymousa.postInvalidate();
            }
            else
            {
              ac.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, is animating");
            }
          }
        }
      }
    };
    this.niS = new b(paramContext);
    this.mContext = paramContext;
    this.niT = new c(this.mContext);
    this.niV = new HashMap();
    AppMethodBeat.o(106422);
  }
  
  private void a(Bitmap paramBitmap, final int paramInt, final String paramString)
  {
    AppMethodBeat.i(106426);
    d.a(paramBitmap, new d.a()
    {
      public final void xy(int paramAnonymousInt)
      {
        AppMethodBeat.i(106407);
        if (!paramString.equals(c.a(c.this)))
        {
          ac.i("MicroMsg.FloatBallCrescentViewHelper", "pickColor listKey not same");
          AppMethodBeat.o(106407);
          return;
        }
        b localb = c.b(c.this);
        int i = paramInt;
        if ((i < 0) || (i >= localb.nik.size()))
        {
          AppMethodBeat.o(106407);
          return;
        }
        ((b.c)localb.nik.get(i)).bHp().niF = paramAnonymousInt;
        if (!localb.nip) {
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
    int m = paramList.size() - this.niV.size();
    i = k;
    Object localObject;
    if (this.niV.size() != 0)
    {
      if (m != -1) {
        break label230;
      }
      paramList = this.niV.entrySet().iterator();
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
      this.niV.clear();
      this.niV.putAll(localHashMap);
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
          if (!this.niV.containsKey(localObject)) {
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
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.drM).append(localBallInfo.lzV).append("|");
      i += 1;
    }
    paramList = ah.dg(localStringBuilder.toString());
    AppMethodBeat.o(106425);
    return paramList;
  }
  
  private static int xA(int paramInt)
  {
    if (paramInt == 1) {
      return niN;
    }
    if (paramInt == 2) {
      return niO;
    }
    if (paramInt == 3) {
      return niP;
    }
    if (paramInt == 4) {
      return niQ;
    }
    return niR;
  }
  
  private static int xz(int paramInt)
  {
    if (paramInt == 1) {
      return niI;
    }
    if (paramInt == 2) {
      return niJ;
    }
    if (paramInt == 3) {
      return niK;
    }
    if (paramInt == 4) {
      return niL;
    }
    return niM;
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106423);
    paramList = d.bV(paramList);
    paramBallInfo = bY(paramList);
    if (paramBallInfo.equals(this.niU))
    {
      ac.i("MicroMsg.FloatBallCrescentViewHelper", "onFloatBallInfoChanged, list key not change");
      AppMethodBeat.o(106423);
      return;
    }
    this.niU = paramBallInfo;
    int j = paramList.size();
    paramBallInfo = new ArrayList();
    int i = 0;
    while (i < j)
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      b.d locald = new b.d();
      this.niT.a(localBallInfo, locald, i, this.niU, this.niW);
      if (locald.isValid())
      {
        paramBallInfo.add(locald);
        if (locald.bitmap != null) {
          a(locald.bitmap, i, this.niU);
        }
      }
      i += 1;
    }
    i = bX(paramList);
    this.niS.a(paramBallInfo, xz(j), xA(j), i);
    AppMethodBeat.o(106423);
  }
  
  static final class a
  {
    int index;
    String niZ;
    String url;
  }
  
  static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap, c.a parama);
  }
  
  static final class c
  {
    final Context mContext;
    final h<String, Bitmap> nja;
    final Map<Integer, Integer> njb;
    final a njc;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(106414);
      this.mContext = paramContext;
      this.njc = new a();
      this.nja = new h(24);
      this.njb = new HashMap();
      AppMethodBeat.o(106414);
    }
    
    private static int F(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(176976);
      if (paramBallInfo.nfB) {}
      for (int i = d.xx(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1) {
          j = paramBallInfo.lzV;
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
      com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
      {
        public final String Ap()
        {
          AppMethodBeat.i(106411);
          String str = ah.dg(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106411);
          return str;
        }
        
        public final void E(final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106409);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106408);
              ac.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, onBitmapLoaded, url:%s", new Object[] { c.c.1.this.val$url });
              c.c.this.nja.put(ah.dg(c.c.1.this.val$url), paramAnonymousBitmap);
              c.c.1.this.njd.a(paramAnonymousBitmap, c.c.1.this.nje);
              AppMethodBeat.o(106408);
            }
          });
          AppMethodBeat.o(106409);
        }
        
        public final void aBa() {}
        
        public final void of()
        {
          AppMethodBeat.i(106410);
          AppMethodBeat.o(106410);
        }
      }, str, new b.h()
      {
        public final String Ap()
        {
          AppMethodBeat.i(106413);
          String str = ah.dg(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106413);
          return str;
        }
        
        public final Bitmap F(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106412);
          int i = c.bHq();
          float f1 = i / paramAnonymousBitmap.getWidth();
          float f2 = i / paramAnonymousBitmap.getHeight();
          ac.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, transform targetSize:%d scaled:%f", new Object[] { Integer.valueOf(i), Float.valueOf(f2) });
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
        paramd.bitmap = xB(paramInt);
        AppMethodBeat.o(106417);
        return true;
      }
      catch (Exception paramd)
      {
        ac.w("MicroMsg.FloatBallCrescentViewHelper", "loadResource exp:%s", new Object[] { paramd.getCause() });
        AppMethodBeat.o(106417);
      }
      return false;
    }
    
    private boolean a(BallInfo paramBallInfo, b.d paramd)
    {
      AppMethodBeat.i(106419);
      if (paramBallInfo.nfB) {
        ac.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, passive icon res");
      }
      for (int i = d.xx(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1)
        {
          ac.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, default icon res");
          j = d.xw(paramBallInfo.type);
        }
        paramd.bitmap = xB(j);
        AppMethodBeat.o(106419);
        return true;
      }
    }
    
    private boolean b(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106418);
      paramBallInfo = paramBallInfo.drM;
      if (bs.isNullOrNil(paramBallInfo))
      {
        AppMethodBeat.o(106418);
        return false;
      }
      Object localObject = ah.dg(paramBallInfo);
      localObject = (Bitmap)this.nja.get(localObject);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        paramd.bitmap = ((Bitmap)localObject);
        ac.i("MicroMsg.FloatBallCrescentViewHelper", "loadIconUrl, from cache");
        AppMethodBeat.o(106418);
        return true;
      }
      paramd = new c.a((byte)0);
      paramd.url = paramBallInfo;
      paramd.index = paramInt;
      paramd.niZ = paramString;
      a(paramd, paramb);
      AppMethodBeat.o(106418);
      return false;
    }
    
    private Bitmap xB(int paramInt)
    {
      AppMethodBeat.i(106420);
      String str = ah.dg(String.valueOf(paramInt));
      Bitmap localBitmap2 = (Bitmap)this.nja.get(str);
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
      {
        ac.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap, from cache");
        AppMethodBeat.o(106420);
        return localBitmap2;
      }
      Bitmap localBitmap1;
      if (this.njc.i(this.mContext.getResources(), paramInt))
      {
        ac.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap svg, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        Bitmap localBitmap3 = a.h(this.mContext.getResources(), paramInt);
        localBitmap1 = localBitmap2;
        if (localBitmap3 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap3.isRecycled())
          {
            int i = localBitmap3.getWidth();
            float f = (float)(c.niI * 1.0D / i);
            localBitmap1 = a.b(this.mContext.getResources(), paramInt, f);
            localBitmap3.recycle();
          }
        }
      }
      for (;;)
      {
        this.nja.put(str, localBitmap1);
        AppMethodBeat.o(106420);
        return localBitmap1;
        ac.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap normal, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
      }
    }
    
    public final void a(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106415);
      if (a(F(paramBallInfo), paramd))
      {
        ac.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadResource");
        AppMethodBeat.o(106415);
        return;
      }
      if (b(paramBallInfo, paramd, paramInt, paramString, paramb))
      {
        ac.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadIconUrl");
        AppMethodBeat.o(106415);
        return;
      }
      ac.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadDefault");
      a(paramBallInfo, paramd);
      AppMethodBeat.o(106415);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.c
 * JD-Core Version:    0.7.0.1
 */