package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
{
  private static Map<String, j> gAA;
  private static Boolean mzS;
  private final int jBQ;
  private final String kqB;
  private final String lJm;
  private final String mAppId;
  private final String mAppVersion;
  private final List<a> mzQ;
  private final Map<Integer, Integer> mzR;
  
  static
  {
    AppMethodBeat.i(222953);
    gAA = new HashMap();
    AppMethodBeat.o(222953);
  }
  
  private j(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(222946);
    this.kqB = paramString1;
    this.mAppId = paramString2;
    this.lJm = paramString3;
    this.mAppVersion = paramString4;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jBQ = i;
      this.mzR = new HashMap();
      this.mzQ = new ArrayList();
      com.tencent.e.h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222942);
          j.a(j.this);
          AppMethodBeat.o(222942);
        }
      }, "QualityKVReporter_19941");
      AppMethodBeat.o(222946);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(222943);
    if (!byJ())
    {
      AppMethodBeat.o(222943);
      return;
    }
    if (!k.byL().mStarted)
    {
      k localk = k.byL();
      if (!localk.mStarted)
      {
        localk.mStarted = true;
        localk.mzX = 60000;
        localk.mzY = new k.b(localk, (byte)0);
        com.tencent.e.h.MqF.f(localk.mzY, k.mzW);
        ae.i("MicroMsg.QualitySampleHelper", "startSample interval:%d", new Object[] { Integer.valueOf(60000) });
      }
    }
    if (!gAA.containsKey(paramString2))
    {
      gAA.put(paramString2, new j(paramString1, paramString2, paramString3, paramString4, paramBoolean));
      com.tencent.mm.plugin.appbrand.h.a(paramString2, new h.c()
      {
        public final void a(h.d paramAnonymousd)
        {
          AppMethodBeat.i(222938);
          j.bZ(this.val$appId, 2);
          AppMethodBeat.o(222938);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(222940);
          j.bZ(this.val$appId, 5);
          j.gAA.remove(this.val$appId);
          com.tencent.mm.plugin.appbrand.h.b(this.val$appId, this);
          AppMethodBeat.o(222940);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(222939);
          j.bZ(this.val$appId, 3);
          AppMethodBeat.o(222939);
        }
      });
    }
    AppMethodBeat.o(222943);
  }
  
  public static void bZ(String paramString, final int paramInt)
  {
    AppMethodBeat.i(222944);
    if (!byJ())
    {
      AppMethodBeat.o(222944);
      return;
    }
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222941);
        j localj = (j)j.gAA.get(this.val$appId);
        if (localj != null)
        {
          j.a(localj, paramInt);
          j.b(localj, paramInt);
        }
        AppMethodBeat.o(222941);
      }
    }, "QualityKVReporter_19941");
    AppMethodBeat.o(222944);
  }
  
  private static boolean byJ()
  {
    AppMethodBeat.i(222947);
    if (mzS != null)
    {
      bool = mzS.booleanValue();
      AppMethodBeat.o(222947);
      return bool;
    }
    int i = ((b)g.ab(b.class)).a(b.a.qOU, 0);
    ae.i("MicroMsg.QualitySampleHelper", "shouldReport:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      mzS = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(222947);
      return bool;
    }
  }
  
  public static void vo(int paramInt)
  {
    AppMethodBeat.i(222945);
    ae.i("MicroMsg.QualitySampleHelper", "updateSampleInterval :%d", new Object[] { Integer.valueOf(paramInt) });
    k.byL().mzX = paramInt;
    AppMethodBeat.o(222945);
  }
  
  private void vp(int paramInt)
  {
    AppMethodBeat.i(222948);
    a locala = new a((byte)0);
    locala.mzU = paramInt;
    locala.mzV = k.byL().vr(paramInt);
    this.mzQ.add(locala);
    AppMethodBeat.o(222948);
  }
  
  private int vq(int paramInt)
  {
    AppMethodBeat.i(222949);
    Integer localInteger = (Integer)this.mzR.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(222949);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(222949);
    return paramInt;
  }
  
  static final class a
  {
    int mzU;
    int mzV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.j
 * JD-Core Version:    0.7.0.1
 */