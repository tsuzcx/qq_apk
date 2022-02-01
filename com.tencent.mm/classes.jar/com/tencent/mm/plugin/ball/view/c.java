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
  private static final int sbB;
  private static final int sbC;
  private static final int sbD;
  private static final int sbE;
  private static final int sbF;
  private static final int sbG;
  private static final int sbH;
  private static final int sbI;
  private static final int sbJ;
  private static final int sbK;
  private final Context mContext;
  public final b sbL;
  private final c sbM;
  private String sbN;
  private final Map<String, Integer> sbO;
  private final b sbP;
  
  static
  {
    AppMethodBeat.i(106429);
    sbB = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_one_icon_size);
    sbC = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_dual_icon_size);
    sbD = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_triple_icon_size);
    sbE = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_four_icon_size);
    sbF = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_five_icon_size);
    sbG = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_one_icon_container_size);
    sbH = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_dual_icon_container_size);
    sbI = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_triple_icon_container_size);
    sbJ = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_four_icon_container_size);
    sbK = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_five_icon_container_size);
    AppMethodBeat.o(106429);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(106422);
    this.sbP = new b()
    {
      public final void a(Bitmap paramAnonymousBitmap, c.a paramAnonymousa)
      {
        AppMethodBeat.i(106406);
        if (!paramAnonymousa.sbS.equals(c.a(c.this)))
        {
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, listKey not same");
          AppMethodBeat.o(106406);
          return;
        }
        int i = paramAnonymousa.index;
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, index:%d, bitmap:%s", new Object[] { Integer.valueOf(i), paramAnonymousBitmap });
        paramAnonymousa = c.b(c.this);
        if ((!paramAnonymousa.mInited) && (i >= 0) && (i < paramAnonymousa.sbl.size()))
        {
          Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, before init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.d)paramAnonymousa.sbl.get(i)).bitmap, paramAnonymousBitmap });
          ((b.d)paramAnonymousa.sbl.get(i)).bitmap = paramAnonymousBitmap;
        }
        for (;;)
        {
          c.a(c.this, paramAnonymousBitmap, i, c.a(c.this));
          AppMethodBeat.o(106406);
          return;
          if ((i < 0) || (i >= paramAnonymousa.sbe.size()))
          {
            Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, invalid range, index:%s, size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousa.sbe.size()) });
          }
          else
          {
            Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, after init, oldBitmap:%s, newBitmap:%s", new Object[] { ((b.c)paramAnonymousa.sbe.get(i)).cwE().bitmap, paramAnonymousBitmap });
            ((b.c)paramAnonymousa.sbe.get(i)).cwE().bitmap = paramAnonymousBitmap;
            if (!paramAnonymousa.qov)
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
    this.sbL = new b(paramContext);
    this.mContext = paramContext;
    this.sbM = new c(this.mContext);
    this.sbO = new HashMap();
    AppMethodBeat.o(106422);
  }
  
  private static int Fp(int paramInt)
  {
    if (paramInt == 1) {
      return sbB;
    }
    if (paramInt == 2) {
      return sbC;
    }
    if (paramInt == 3) {
      return sbD;
    }
    if (paramInt == 4) {
      return sbE;
    }
    return sbF;
  }
  
  private static int Fq(int paramInt)
  {
    if (paramInt == 1) {
      return sbG;
    }
    if (paramInt == 2) {
      return sbH;
    }
    if (paramInt == 3) {
      return sbI;
    }
    if (paramInt == 4) {
      return sbJ;
    }
    return sbK;
  }
  
  private void a(Bitmap paramBitmap, final int paramInt, final String paramString)
  {
    AppMethodBeat.i(106426);
    com.tencent.mm.plugin.ball.f.d.a(paramBitmap, new d.a()
    {
      public final void Fo(int paramAnonymousInt)
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
        if ((i < 0) || (i >= localb.sbe.size()))
        {
          AppMethodBeat.o(106407);
          return;
        }
        ((b.c)localb.sbe.get(i)).cwE().sby = paramAnonymousInt;
        if (!localb.qov) {
          localb.postInvalidate();
        }
        AppMethodBeat.o(106407);
      }
    });
    AppMethodBeat.o(106426);
  }
  
  private int cl(List<BallInfo> paramList)
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
    int m = paramList.size() - this.sbO.size();
    i = k;
    Object localObject;
    if (this.sbO.size() != 0)
    {
      if (m != -1) {
        break label230;
      }
      paramList = this.sbO.entrySet().iterator();
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
      this.sbO.clear();
      this.sbO.putAll(localHashMap);
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
          if (!this.sbO.containsKey(localObject)) {
            k = j;
          }
          j += 1;
        }
        i = -2147483648;
      }
    }
  }
  
  private static String cm(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106425);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      localStringBuilder.append(localBallInfo.key).append(localBallInfo.type).append(localBallInfo.icon).append(localBallInfo.qpN).append("|");
      i += 1;
    }
    paramList = MD5Util.getMD5String(localStringBuilder.toString());
    AppMethodBeat.o(106425);
    return paramList;
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106423);
    paramList = com.tencent.mm.plugin.ball.f.d.ci(paramList);
    paramBallInfo = cm(paramList);
    if (paramBallInfo.equals(this.sbN))
    {
      Log.i("MicroMsg.FloatBallCrescentViewHelper", "onFloatBallInfoChanged, list key not change");
      AppMethodBeat.o(106423);
      return;
    }
    this.sbN = paramBallInfo;
    int j = paramList.size();
    paramBallInfo = new ArrayList();
    int i = 0;
    while (i < j)
    {
      BallInfo localBallInfo = (BallInfo)paramList.get(i);
      b.d locald = new b.d();
      this.sbM.a(localBallInfo, locald, i, this.sbN, this.sbP);
      if (locald.isValid())
      {
        paramBallInfo.add(locald);
        if (locald.bitmap != null) {
          a(locald.bitmap, i, this.sbN);
        }
      }
      i += 1;
    }
    i = cl(paramList);
    this.sbL.a(paramBallInfo, Fp(j), Fq(j), i);
    AppMethodBeat.o(106423);
  }
  
  static final class a
  {
    int index;
    String sbS;
    String url;
  }
  
  static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap, c.a parama);
  }
  
  static final class c
  {
    final Context mContext;
    final h<String, Bitmap> sbT;
    final Map<Integer, Integer> sbU;
    final a sbV;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(106414);
      this.mContext = paramContext;
      this.sbV = new a();
      this.sbT = new h(24);
      this.sbU = new HashMap();
      AppMethodBeat.o(106414);
    }
    
    private Bitmap Fr(int paramInt)
    {
      AppMethodBeat.i(106420);
      String str = MD5Util.getMD5String(String.valueOf(paramInt));
      Bitmap localBitmap2 = (Bitmap)this.sbT.get(str);
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
      {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap, from cache");
        AppMethodBeat.o(106420);
        return localBitmap2;
      }
      Bitmap localBitmap1;
      if (this.sbV.j(this.mContext.getResources(), paramInt))
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
            float f = (float)(c.sbB * 1.0D / i);
            localBitmap1 = a.b(this.mContext.getResources(), paramInt, f);
            localBitmap3.recycle();
          }
        }
      }
      for (;;)
      {
        this.sbT.put(str, localBitmap1);
        AppMethodBeat.o(106420);
        return localBitmap1;
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap normal, resId:%s", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
      }
    }
    
    private static int J(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(176976);
      if (paramBallInfo.rYr) {}
      for (int i = com.tencent.mm.plugin.ball.f.d.Fn(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1) {
          j = paramBallInfo.qpN;
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
      com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
      {
        public final void G(final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106409);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106408);
              Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, onBitmapLoaded, url:%s", new Object[] { c.c.1.this.val$url });
              c.c.this.sbT.put(MD5Util.getMD5String(c.c.1.this.val$url), paramAnonymousBitmap);
              c.c.1.this.sbW.a(paramAnonymousBitmap, c.c.1.this.sbX);
              AppMethodBeat.o(106408);
            }
          });
          AppMethodBeat.o(106409);
        }
        
        public final void bhq() {}
        
        public final void bhr()
        {
          AppMethodBeat.i(106410);
          AppMethodBeat.o(106410);
        }
        
        public final String key()
        {
          AppMethodBeat.i(106411);
          String str = MD5Util.getMD5String(String.format("%s#%d", new Object[] { str, Integer.valueOf(i) }));
          AppMethodBeat.o(106411);
          return str;
        }
      }, str, new b.h()
      {
        public final Bitmap H(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(106412);
          int i = c.cwF();
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
        
        public final String key()
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
        paramd.bitmap = Fr(paramInt);
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
      if (paramBallInfo.rYr) {
        Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, passive icon res");
      }
      for (int i = com.tencent.mm.plugin.ball.f.d.Fn(paramBallInfo.state);; i = -1)
      {
        int j = i;
        if (i == -1)
        {
          Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, default icon res");
          j = com.tencent.mm.plugin.ball.f.d.Fm(paramBallInfo.type);
        }
        paramd.bitmap = Fr(j);
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
      localObject = (Bitmap)this.sbT.get(localObject);
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
      paramd.sbS = paramString;
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