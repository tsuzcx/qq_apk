package com.tencent.mm.plugin.appbrand.report.quality;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
{
  private static Map<String, j> mza;
  private static Boolean tRT;
  private final String mAppId;
  private final String mAppVersion;
  private final int quJ;
  private final String rsQ;
  private final String sWX;
  private final List<a> tRR;
  private final Map<Integer, Integer> tRS;
  
  static
  {
    AppMethodBeat.i(321456);
    mza = new HashMap();
    AppMethodBeat.o(321456);
  }
  
  private j(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(321425);
    this.rsQ = paramString1;
    this.mAppId = paramString2;
    this.sWX = paramString3;
    this.mAppVersion = paramString4;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.quJ = i;
      this.tRS = new HashMap();
      this.tRR = new ArrayList();
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(321441);
          j.a(j.this);
          AppMethodBeat.o(321441);
        }
      }, "QualityKVReporter_19941");
      AppMethodBeat.o(321425);
      return;
    }
  }
  
  public static void Dd(int paramInt)
  {
    AppMethodBeat.i(321418);
    Log.i("MicroMsg.QualitySampleHelper", "updateSampleInterval :%d", new Object[] { Integer.valueOf(paramInt) });
    k.cJg().tRY = paramInt;
    AppMethodBeat.o(321418);
  }
  
  private void De(int paramInt)
  {
    AppMethodBeat.i(321432);
    a locala = new a((byte)0);
    locala.tRV = paramInt;
    locala.tRW = k.cJg().Dg(paramInt);
    this.tRR.add(locala);
    AppMethodBeat.o(321432);
  }
  
  private int Df(int paramInt)
  {
    AppMethodBeat.i(321436);
    Integer localInteger = (Integer)this.tRS.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(321436);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(321436);
    return paramInt;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(321408);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(321408);
      return;
    }
    if (!cJe())
    {
      AppMethodBeat.o(321408);
      return;
    }
    if (!k.cJg().mStarted)
    {
      k localk = k.cJg();
      if (!localk.mStarted)
      {
        localk.mStarted = true;
        localk.tRY = 60000;
        localk.tRZ = new k.b(localk, (byte)0);
        com.tencent.threadpool.h.ahAA.g(localk.tRZ, k.tRX);
        Log.i("MicroMsg.QualitySampleHelper", "startSample interval:%d", new Object[] { Integer.valueOf(60000) });
      }
    }
    if (!mza.containsKey(paramString2))
    {
      mza.put(paramString2, new j(paramString1, paramString2, paramString3, paramString4, paramBoolean));
      com.tencent.mm.plugin.appbrand.k.a(paramString2, new k.c()
      {
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(321439);
          j.dh(j.this, 2);
          AppMethodBeat.o(321439);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(321446);
          j.dh(j.this, 5);
          j.aYC().remove(j.this);
          com.tencent.mm.plugin.appbrand.k.b(j.this, this);
          AppMethodBeat.o(321446);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(321444);
          j.dh(j.this, 3);
          AppMethodBeat.o(321444);
        }
      });
    }
    AppMethodBeat.o(321408);
  }
  
  private static boolean cJe()
  {
    AppMethodBeat.i(321429);
    if (tRT != null)
    {
      bool = tRT.booleanValue();
      AppMethodBeat.o(321429);
      return bool;
    }
    int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zpv, 0);
    Log.i("MicroMsg.QualitySampleHelper", "shouldReport:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      tRT = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(321429);
      return bool;
    }
  }
  
  public static void dh(String paramString, final int paramInt)
  {
    AppMethodBeat.i(321412);
    if (!cJe())
    {
      AppMethodBeat.o(321412);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(321438);
        j localj = (j)j.aYC().get(j.this);
        if (localj != null)
        {
          j.a(localj, paramInt);
          j.b(localj, paramInt);
        }
        AppMethodBeat.o(321438);
      }
    }, "QualityKVReporter_19941");
    AppMethodBeat.o(321412);
  }
  
  static final class a
  {
    int tRV;
    int tRW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.j
 * JD-Core Version:    0.7.0.1
 */