package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k
{
  private static Map<String, k> jZc;
  private static Boolean qNj;
  private final String mAppId;
  private final String mAppVersion;
  private final int nvW;
  private final String opi;
  private final String pRV;
  private final List<a> qNh;
  private final Map<Integer, Integer> qNi;
  
  static
  {
    AppMethodBeat.i(265594);
    jZc = new HashMap();
    AppMethodBeat.o(265594);
  }
  
  private k(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(265587);
    this.opi = paramString1;
    this.mAppId = paramString2;
    this.pRV = paramString3;
    this.mAppVersion = paramString4;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.nvW = i;
      this.qNi = new HashMap();
      this.qNh = new ArrayList();
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(282504);
          k.a(k.this);
          AppMethodBeat.o(282504);
        }
      }, "QualityKVReporter_19941");
      AppMethodBeat.o(265587);
      return;
    }
  }
  
  public static void CK(int paramInt)
  {
    AppMethodBeat.i(265586);
    Log.i("MicroMsg.QualitySampleHelper", "updateSampleInterval :%d", new Object[] { Integer.valueOf(paramInt) });
    l.cip().qNo = paramInt;
    AppMethodBeat.o(265586);
  }
  
  private void CL(int paramInt)
  {
    AppMethodBeat.i(265589);
    a locala = new a((byte)0);
    locala.qNl = paramInt;
    locala.qNm = l.cip().CN(paramInt);
    this.qNh.add(locala);
    AppMethodBeat.o(265589);
  }
  
  private int CM(int paramInt)
  {
    AppMethodBeat.i(265590);
    Integer localInteger = (Integer)this.qNi.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(265590);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(265590);
    return paramInt;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(265583);
    if (!cin())
    {
      AppMethodBeat.o(265583);
      return;
    }
    if (!l.cip().mStarted)
    {
      l locall = l.cip();
      if (!locall.mStarted)
      {
        locall.mStarted = true;
        locall.qNo = 60000;
        locall.qNp = new l.b(locall, (byte)0);
        com.tencent.e.h.ZvG.d(locall.qNp, l.qNn);
        Log.i("MicroMsg.QualitySampleHelper", "startSample interval:%d", new Object[] { Integer.valueOf(60000) });
      }
    }
    if (!jZc.containsKey(paramString2))
    {
      jZc.put(paramString2, new k(paramString1, paramString2, paramString3, paramString4, paramBoolean));
      com.tencent.mm.plugin.appbrand.k.a(paramString2, new k.c()
      {
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(281450);
          k.cI(this.val$appId, 2);
          AppMethodBeat.o(281450);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(281453);
          k.cI(this.val$appId, 5);
          k.jZc.remove(this.val$appId);
          com.tencent.mm.plugin.appbrand.k.b(this.val$appId, this);
          AppMethodBeat.o(281453);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(281452);
          k.cI(this.val$appId, 3);
          AppMethodBeat.o(281452);
        }
      });
    }
    AppMethodBeat.o(265583);
  }
  
  public static void cI(String paramString, final int paramInt)
  {
    AppMethodBeat.i(265585);
    if (!cin())
    {
      AppMethodBeat.o(265585);
      return;
    }
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276981);
        k localk = (k)k.jZc.get(this.val$appId);
        if (localk != null)
        {
          k.a(localk, paramInt);
          k.b(localk, paramInt);
        }
        AppMethodBeat.o(276981);
      }
    }, "QualityKVReporter_19941");
    AppMethodBeat.o(265585);
  }
  
  private static boolean cin()
  {
    AppMethodBeat.i(265588);
    if (qNj != null)
    {
      bool = qNj.booleanValue();
      AppMethodBeat.o(265588);
      return bool;
    }
    int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vWQ, 0);
    Log.i("MicroMsg.QualitySampleHelper", "shouldReport:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      qNj = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(265588);
      return bool;
    }
  }
  
  static final class a
  {
    int qNl;
    int qNm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.k
 * JD-Core Version:    0.7.0.1
 */