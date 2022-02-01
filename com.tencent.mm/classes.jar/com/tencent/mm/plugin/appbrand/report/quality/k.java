package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k
{
  private static Map<String, k> hno;
  private static Boolean nKX;
  private final int kCM;
  private final String luj;
  private final String mAppId;
  private final String mAppVersion;
  private final String mRa;
  private final List<a> nKV;
  private final Map<Integer, Integer> nKW;
  
  static
  {
    AppMethodBeat.i(227404);
    hno = new HashMap();
    AppMethodBeat.o(227404);
  }
  
  private k(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(227397);
    this.luj = paramString1;
    this.mAppId = paramString2;
    this.mRa = paramString3;
    this.mAppVersion = paramString4;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.kCM = i;
      this.nKW = new HashMap();
      this.nKV = new ArrayList();
      com.tencent.f.h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227393);
          k.a(k.this);
          AppMethodBeat.o(227393);
        }
      }, "QualityKVReporter_19941");
      AppMethodBeat.o(227397);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(227394);
    if (!bVc())
    {
      AppMethodBeat.o(227394);
      return;
    }
    if (!l.bVe().mStarted)
    {
      l locall = l.bVe();
      if (!locall.mStarted)
      {
        locall.mStarted = true;
        locall.nLc = 60000;
        locall.nLd = new l.b(locall, (byte)0);
        com.tencent.f.h.RTc.b(locall.nLd, l.nLb);
        Log.i("MicroMsg.QualitySampleHelper", "startSample interval:%d", new Object[] { Integer.valueOf(60000) });
      }
    }
    if (!hno.containsKey(paramString2))
    {
      hno.put(paramString2, new k(paramString1, paramString2, paramString3, paramString4, paramBoolean));
      com.tencent.mm.plugin.appbrand.h.a(paramString2, new h.c()
      {
        public final void a(h.d paramAnonymousd)
        {
          AppMethodBeat.i(227389);
          k.cj(this.val$appId, 2);
          AppMethodBeat.o(227389);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(227391);
          k.cj(this.val$appId, 5);
          k.hno.remove(this.val$appId);
          com.tencent.mm.plugin.appbrand.h.b(this.val$appId, this);
          AppMethodBeat.o(227391);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(227390);
          k.cj(this.val$appId, 3);
          AppMethodBeat.o(227390);
        }
      });
    }
    AppMethodBeat.o(227394);
  }
  
  private static boolean bVc()
  {
    AppMethodBeat.i(227398);
    if (nKX != null)
    {
      bool = nKX.booleanValue();
      AppMethodBeat.o(227398);
      return bool;
    }
    int i = ((b)g.af(b.class)).a(b.a.smb, 0);
    Log.i("MicroMsg.QualitySampleHelper", "shouldReport:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      nKX = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(227398);
      return bool;
    }
  }
  
  public static void cj(String paramString, final int paramInt)
  {
    AppMethodBeat.i(227395);
    if (!bVc())
    {
      AppMethodBeat.o(227395);
      return;
    }
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227392);
        k localk = (k)k.hno.get(this.val$appId);
        if (localk != null)
        {
          k.a(localk, paramInt);
          k.b(localk, paramInt);
        }
        AppMethodBeat.o(227392);
      }
    }, "QualityKVReporter_19941");
    AppMethodBeat.o(227395);
  }
  
  public static void zf(int paramInt)
  {
    AppMethodBeat.i(227396);
    Log.i("MicroMsg.QualitySampleHelper", "updateSampleInterval :%d", new Object[] { Integer.valueOf(paramInt) });
    l.bVe().nLc = paramInt;
    AppMethodBeat.o(227396);
  }
  
  private void zg(int paramInt)
  {
    AppMethodBeat.i(227399);
    a locala = new a((byte)0);
    locala.nKZ = paramInt;
    locala.nLa = l.bVe().zi(paramInt);
    this.nKV.add(locala);
    AppMethodBeat.o(227399);
  }
  
  private int zh(int paramInt)
  {
    AppMethodBeat.i(227400);
    Integer localInteger = (Integer)this.nKW.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(227400);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(227400);
    return paramInt;
  }
  
  static final class a
  {
    int nKZ;
    int nLa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.k
 * JD-Core Version:    0.7.0.1
 */