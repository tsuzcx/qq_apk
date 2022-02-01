package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
{
  private static Map<String, j> fZD;
  private static Boolean ltl;
  private final int iFI;
  private final String jsD;
  private final String kGt;
  private final List<a> ltj;
  private final Map<Integer, Integer> ltk;
  private final String mAppId;
  private final String mAppVersion;
  
  static
  {
    AppMethodBeat.i(196095);
    fZD = new HashMap();
    AppMethodBeat.o(196095);
  }
  
  private j(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(196088);
    this.jsD = paramString1;
    this.mAppId = paramString2;
    this.kGt = paramString3;
    this.mAppVersion = paramString4;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.iFI = i;
      this.ltk = new HashMap();
      this.ltj = new ArrayList();
      h.Iye.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196084);
          j.a(j.this);
          AppMethodBeat.o(196084);
        }
      }, "QualityKVReporter_19941");
      AppMethodBeat.o(196088);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(196085);
    if (!bmP())
    {
      AppMethodBeat.o(196085);
      return;
    }
    if (!k.bmR().mStarted)
    {
      k localk = k.bmR();
      if (!localk.mStarted)
      {
        localk.mStarted = true;
        localk.ltq = 60000;
        localk.ltr = new k.b(localk, (byte)0);
        h.Iye.f(localk.ltr, k.ltp);
        ad.i("MicroMsg.QualitySampleHelper", "startSample interval:%d", new Object[] { Integer.valueOf(60000) });
      }
    }
    if (!fZD.containsKey(paramString2))
    {
      fZD.put(paramString2, new j(paramString1, paramString2, paramString3, paramString4, paramBoolean));
      com.tencent.mm.plugin.appbrand.g.a(paramString2, new j.1(paramString2));
    }
    AppMethodBeat.o(196085);
  }
  
  public static void bO(String paramString, final int paramInt)
  {
    AppMethodBeat.i(196086);
    if (!bmP())
    {
      AppMethodBeat.o(196086);
      return;
    }
    h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196083);
        j localj = (j)j.fZD.get(this.val$appId);
        if (localj != null)
        {
          j.a(localj, paramInt);
          j.b(localj, paramInt);
        }
        AppMethodBeat.o(196083);
      }
    }, "QualityKVReporter_19941");
    AppMethodBeat.o(196086);
  }
  
  private static boolean bmP()
  {
    AppMethodBeat.i(196089);
    if (ltl != null)
    {
      bool = ltl.booleanValue();
      AppMethodBeat.o(196089);
      return bool;
    }
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pxs, 0);
    ad.i("MicroMsg.QualitySampleHelper", "shouldReport:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      ltl = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(196089);
      return bool;
    }
  }
  
  public static void tN(int paramInt)
  {
    AppMethodBeat.i(196087);
    ad.i("MicroMsg.QualitySampleHelper", "updateSampleInterval :%d", new Object[] { Integer.valueOf(paramInt) });
    k.bmR().ltq = paramInt;
    AppMethodBeat.o(196087);
  }
  
  private void tO(int paramInt)
  {
    AppMethodBeat.i(196090);
    a locala = new a((byte)0);
    locala.ltn = paramInt;
    locala.lto = k.bmR().tQ(paramInt);
    this.ltj.add(locala);
    AppMethodBeat.o(196090);
  }
  
  private int tP(int paramInt)
  {
    AppMethodBeat.i(196091);
    Integer localInteger = (Integer)this.ltk.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(196091);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(196091);
    return paramInt;
  }
  
  static final class a
  {
    int ltn;
    int lto;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.j
 * JD-Core Version:    0.7.0.1
 */