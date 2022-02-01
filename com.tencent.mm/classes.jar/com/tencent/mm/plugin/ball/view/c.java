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
import com.tencent.mm.plugin.ball.a.c;
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
  private static final int vmT;
  private static final int vmU;
  private static final int vmV;
  private static final int vmW;
  private static final int vmX;
  private static final int vmY;
  private static final int vmZ;
  private static final int vna;
  private static final int vnb;
  private static final int vnc;
  private final Context mContext;
  public final b vnd;
  private final c vne;
  private String vnf;
  private final Map<String, Integer> vng;
  private final b vnh;
  
  static
  {
    AppMethodBeat.i(106429);
    vmT = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_one_icon_size);
    vmU = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_dual_icon_size);
    vmV = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_triple_icon_size);
    vmW = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_four_icon_size);
    vmX = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_five_icon_size);
    vmY = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_one_icon_container_size);
    vmZ = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_dual_icon_container_size);
    vna = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_triple_icon_container_size);
    vnb = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_four_icon_container_size);
    vnc = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_five_icon_container_size);
    AppMethodBeat.o(106429);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(106422);
    this.vnh = new b()
    {
      public final void a(Bitmap paramAnonymousBitmap, c.a paramAnonymousa)
      {
        AppMethodBeat.i(106406);
        if (!paramAnonymousa.vnk.equals(c.a(c.this)))
        {
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, listKey not same");
          AppMethodBeat.o(106406);
          return;
        }
        int i = paramAnonymousa.index;
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, index:%d, bitmap:%s", new Object[] { Integer.valueOf(i), paramAnonymousBitmap });
        paramAnonymousa = c.b(c.this);
        if ((!paramAnonymousa.mInited) && (i >= 0) && (i < paramAnonymousa.vmD.size()))
        {
          Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, before init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.d)paramAnonymousa.vmD.get(i)).bitmap, paramAnonymousBitmap });
          ((b.d)paramAnonymousa.vmD.get(i)).bitmap = paramAnonymousBitmap;
        }
        for (;;)
        {
          c.a(c.this, paramAnonymousBitmap, i, c.a(c.this));
          AppMethodBeat.o(106406);
          return;
          if ((i < 0) || (i >= paramAnonymousa.vmw.size()))
          {
            Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, invalid range, index:%s, size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousa.vmw.size()) });
          }
          else
          {
            Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, after init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.c)paramAnonymousa.vmw.get(i)).cZm().bitmap, paramAnonymousBitmap });
            ((b.c)paramAnonymousa.vmw.get(i)).cZm().bitmap = paramAnonymousBitmap;
            if (!paramAnonymousa.ttc)
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
      
      public final void bFh() {}
    };
    this.vnd = new b(paramContext);
    this.mContext = paramContext;
    this.vne = new c(this.mContext);
    this.vng = new HashMap();
    AppMethodBeat.o(106422);
  }
  
  private static int FN(int paramInt)
  {
    if (paramInt == 1) {
      return vmT;
    }
    if (paramInt == 2) {
      return vmU;
    }
    if (paramInt == 3) {
      return vmV;
    }
    if (paramInt == 4) {
      return vmW;
    }
    return vmX;
  }
  
  private static int FO(int paramInt)
  {
    if (paramInt == 1) {
      return vmY;
    }
    if (paramInt == 2) {
      return vmZ;
    }
    if (paramInt == 3) {
      return vna;
    }
    if (paramInt == 4) {
      return vnb;
    }
    return vnc;
  }
  
  private void a(Bitmap paramBitmap, final int paramInt, final String paramString)
  {
    AppMethodBeat.i(106426);
    com.tencent.mm.plugin.ball.f.d.a(paramBitmap, new d.a()
    {
      public final void onGetColor(int paramAnonymousInt)
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
        if ((i < 0) || (i >= localb.vmw.size()))
        {
          AppMethodBeat.o(106407);
          return;
        }
        ((b.c)localb.vmw.get(i)).cZm().vmQ = paramAnonymousInt;
        if (!localb.ttc) {
          localb.postInvalidate();
        }
        AppMethodBeat.o(106407);
      }
    });
    AppMethodBeat.o(106426);
  }
  
  private int ed(List<BallInfo> paramList)
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
    int m = paramList.size() - this.vng.size();
    i = k;
    Object localObject;
    if (this.vng.size() != 0)
    {
      if (m != -1) {
        break label230;
      }
      paramList = this.vng.entrySet().iterator();
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
      this.vng.clear();
      this.vng.putAll(localHashMap);
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
          if (!this.vng.containsKey(localObject)) {
            k = j;
          }
          j += 1;
        }
        i = -2147483648;
      }
    }
  }
  
  private static String ee(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106425);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.tus).append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106425);
    return paramList;
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106423);
    paramList = com.tencent.mm.plugin.ball.f.d.ea(paramList);
    paramBallInfo = ee(paramList);
    if (paramBallInfo.equals(this.vnf))
    {
      Log.i("MicroMsg.FloatBallCrescentViewHelper", "onFloatBallInfoChanged, list key not change");
      AppMethodBeat.o(106423);
      return;
    }
    this.vnf = paramBallInfo;
    int j = paramList.size();
    int k = FN(j);
    paramBallInfo = new ArrayList();
    int i = 0;
    while (i < j)
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      b.d locald = new b.d();
      this.vne.a(localBallInfo, locald, k, i, this.vnf, this.vnh);
      if (locald.isValid())
      {
        paramBallInfo.add(locald);
        if (locald.bitmap != null) {
          a(locald.bitmap, i, this.vnf);
        }
      }
      i += 1;
    }
    i = ed(paramList);
    this.vnd.a(paramBallInfo, FN(j), FO(j), i);
    AppMethodBeat.o(106423);
  }
  
  static final class a
  {
    int index;
    String url;
    String vnk;
  }
  
  static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap, c.a parama);
    
    public abstract void bFh();
  }
  
  static final class c
  {
    final Context mContext;
    final h<String, Bitmap> vnl;
    final Map<Integer, Integer> vnm;
    final a vnn;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(106414);
      this.mContext = paramContext;
      this.vnn = new a();
      this.vnl = new h(24);
      this.vnm = new HashMap();
      AppMethodBeat.o(106414);
    }
    
    private Bitmap FP(int paramInt)
    {
      AppMethodBeat.i(106420);
      String str = MD5Util.getMD5String(String.valueOf(paramInt));
      Bitmap localBitmap2 = (Bitmap)this.vnl.get(str);
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap, from cache");
        AppMethodBeat.o(106420);
        return localBitmap2;
      }
      Bitmap localBitmap1;
      if (this.vnn.k(this.mContext.getResources(), paramInt))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap svg, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        Bitmap localBitmap3 = a.j(this.mContext.getResources(), paramInt);
        localBitmap1 = localBitmap2;
        if (localBitmap3 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap3.isRecycled())
          {
            int i = localBitmap3.getWidth();
            float f = (float)(c.vmT * 1.0D / i);
            localBitmap1 = a.b(this.mContext.getResources(), paramInt, f);
            localBitmap3.recycle();
          }
        }
      }
      for (;;)
      {
        this.vnl.put(str, localBitmap1);
        AppMethodBeat.o(106420);
        return localBitmap1;
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap normal, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
      }
    }
    
    private static int L(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(176976);
      if (paramBallInfo.vjH) {}
      for (int i = com.tencent.mm.plugin.ball.f.d.K(paramBallInfo);; i = -1)
      {
        int j = i;
        if (i == -1) {
          j = paramBallInfo.tus;
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
      com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
      {
        public final void bFg() {}
        
        public final void bFh()
        {
          AppMethodBeat.i(288454);
          Log.e("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl onLoadFailed url: %s", new Object[] { str });
          paramb.bFh();
          AppMethodBeat.o(288454);
        }
        
        public final String key()
        {
          AppMethodBeat.i(106413);
          String str = MD5Util.getMD5String(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106413);
          return str;
        }
        
        public final void onBitmapLoaded(final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(288448);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(288510);
              Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, onBitmapLoaded, url:%s", new Object[] { c.c.2.this.val$url });
              c.c.this.vnl.put(MD5Util.getMD5String(c.c.2.this.val$url), paramAnonymousBitmap);
              c.c.2.this.vno.a(paramAnonymousBitmap, c.c.2.this.vns);
              AppMethodBeat.o(288510);
            }
          });
          AppMethodBeat.o(288448);
        }
      }, str, new b.h()
      {
        public final Bitmap P(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(288447);
          int i = c.cZn();
          float f1 = i / paramAnonymousBitmap.getWidth();
          float f2 = i / paramAnonymousBitmap.getHeight();
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, transform targetSize:%d scaled:%f", new Object[] { Integer.valueOf(i), Float.valueOf(f2) });
          Object localObject = new Matrix();
          ((Matrix)localObject).postScale(f1, f2);
          localObject = Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight(), (Matrix)localObject, true);
          paramAnonymousBitmap.recycle();
          AppMethodBeat.o(288447);
          return localObject;
        }
        
        public final String key()
        {
          AppMethodBeat.i(288455);
          String str = MD5Util.getMD5String(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(288455);
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
        paramd.bitmap = FP(paramInt);
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
    
    private boolean a(BallInfo paramBallInfo, b.d paramd, int paramInt, String paramString, c.b paramb)
    {
      AppMethodBeat.i(106418);
      paramBallInfo = paramBallInfo.icon;
      if (Util.isNullOrNil(paramBallInfo))
      {
        AppMethodBeat.o(106418);
        return false;
      }
      Object localObject = MD5Util.getMD5String(paramBallInfo);
      localObject = (Bitmap)this.vnl.get(localObject);
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
      paramd.vnk = paramString;
      a(paramd, paramb);
      AppMethodBeat.o(106418);
      return false;
    }
    
    public final void a(final BallInfo paramBallInfo, final b.d paramd, final int paramInt1, int paramInt2, String paramString, final c.b paramb)
    {
      AppMethodBeat.i(288512);
      if (a(L(paramBallInfo), paramd))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadResource");
        AppMethodBeat.o(288512);
        return;
      }
      if (a(paramBallInfo, paramd, paramInt2, paramString, new c.b()
      {
        public final void a(Bitmap paramAnonymousBitmap, c.a paramAnonymousa)
        {
          AppMethodBeat.i(288451);
          paramb.a(paramAnonymousBitmap, paramAnonymousa);
          AppMethodBeat.o(288451);
        }
        
        public final void bFh()
        {
          AppMethodBeat.i(106410);
          c.c.this.a(paramBallInfo, paramd);
          AppMethodBeat.o(106410);
        }
      }))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadIconUrl");
        AppMethodBeat.o(288512);
        return;
      }
      Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadDefault");
      a(paramBallInfo, paramd);
      AppMethodBeat.o(288512);
    }
    
    final boolean a(BallInfo paramBallInfo, b.d paramd)
    {
      AppMethodBeat.i(106419);
      if (paramBallInfo.vjH) {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, passive icon res");
      }
      for (int i = com.tencent.mm.plugin.ball.f.d.K(paramBallInfo);; i = -1)
      {
        int j = i;
        if (i == -1)
        {
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, default icon res");
          j = com.tencent.mm.plugin.ball.f.d.J(paramBallInfo);
        }
        paramd.bitmap = FP(j);
        AppMethodBeat.o(106419);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.c
 * JD-Core Version:    0.7.0.1
 */