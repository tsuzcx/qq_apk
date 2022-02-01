package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
{
  private static Map<String, j> gxT;
  private static Boolean muV;
  private final int jyQ;
  private final String knl;
  private final String lEN;
  private final String mAppId;
  private final String mAppVersion;
  private final List<a> muT;
  private final Map<Integer, Integer> muU;
  
  static
  {
    AppMethodBeat.i(188735);
    gxT = new HashMap();
    AppMethodBeat.o(188735);
  }
  
  private j(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(188728);
    this.knl = paramString1;
    this.mAppId = paramString2;
    this.lEN = paramString3;
    this.mAppVersion = paramString4;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jyQ = i;
      this.muU = new HashMap();
      this.muT = new ArrayList();
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188724);
          j.a(j.this);
          AppMethodBeat.o(188724);
        }
      }, "QualityKVReporter_19941");
      AppMethodBeat.o(188728);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(188725);
    if (!bxQ())
    {
      AppMethodBeat.o(188725);
      return;
    }
    if (!k.bxS().mStarted)
    {
      k localk = k.bxS();
      if (!localk.mStarted)
      {
        localk.mStarted = true;
        localk.mva = 60000;
        localk.mvb = new k.b(localk, (byte)0);
        h.LTJ.f(localk.mvb, k.muZ);
        ad.i("MicroMsg.QualitySampleHelper", "startSample interval:%d", new Object[] { Integer.valueOf(60000) });
      }
    }
    if (!gxT.containsKey(paramString2))
    {
      gxT.put(paramString2, new j(paramString1, paramString2, paramString3, paramString4, paramBoolean));
      com.tencent.mm.plugin.appbrand.g.a(paramString2, new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(188720);
          j.bV(this.val$appId, 2);
          AppMethodBeat.o(188720);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(188722);
          j.bV(this.val$appId, 5);
          j.gxT.remove(this.val$appId);
          com.tencent.mm.plugin.appbrand.g.b(this.val$appId, this);
          AppMethodBeat.o(188722);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(188721);
          j.bV(this.val$appId, 3);
          AppMethodBeat.o(188721);
        }
      });
    }
    AppMethodBeat.o(188725);
  }
  
  public static void bV(String paramString, final int paramInt)
  {
    AppMethodBeat.i(188726);
    if (!bxQ())
    {
      AppMethodBeat.o(188726);
      return;
    }
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188723);
        j localj = (j)j.gxT.get(this.val$appId);
        if (localj != null)
        {
          j.a(localj, paramInt);
          j.b(localj, paramInt);
        }
        AppMethodBeat.o(188723);
      }
    }, "QualityKVReporter_19941");
    AppMethodBeat.o(188726);
  }
  
  private static boolean bxQ()
  {
    AppMethodBeat.i(188729);
    if (muV != null)
    {
      bool = muV.booleanValue();
      AppMethodBeat.o(188729);
      return bool;
    }
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qHo, 0);
    ad.i("MicroMsg.QualitySampleHelper", "shouldReport:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      muV = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(188729);
      return bool;
    }
  }
  
  public static void vj(int paramInt)
  {
    AppMethodBeat.i(188727);
    ad.i("MicroMsg.QualitySampleHelper", "updateSampleInterval :%d", new Object[] { Integer.valueOf(paramInt) });
    k.bxS().mva = paramInt;
    AppMethodBeat.o(188727);
  }
  
  private void vk(int paramInt)
  {
    AppMethodBeat.i(188730);
    a locala = new a((byte)0);
    locala.muX = paramInt;
    locala.muY = k.bxS().vm(paramInt);
    this.muT.add(locala);
    AppMethodBeat.o(188730);
  }
  
  private int vl(int paramInt)
  {
    AppMethodBeat.i(188731);
    Integer localInteger = (Integer)this.muU.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(188731);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(188731);
    return paramInt;
  }
  
  static final class a
  {
    int muX;
    int muY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.j
 * JD-Core Version:    0.7.0.1
 */