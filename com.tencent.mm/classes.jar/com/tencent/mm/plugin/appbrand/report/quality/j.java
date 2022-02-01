package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
{
  private static Map<String, j> gej;
  private static Boolean lVf;
  private final String jSX;
  private final int jfK;
  private final List<a> lVd;
  private final Map<Integer, Integer> lVe;
  private final String lhM;
  private final String mAppId;
  private final String mAppVersion;
  
  static
  {
    AppMethodBeat.i(186937);
    gej = new HashMap();
    AppMethodBeat.o(186937);
  }
  
  private j(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(186930);
    this.jSX = paramString1;
    this.mAppId = paramString2;
    this.lhM = paramString3;
    this.mAppVersion = paramString4;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jfK = i;
      this.lVe = new HashMap();
      this.lVd = new ArrayList();
      h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186926);
          j.a(j.this);
          AppMethodBeat.o(186926);
        }
      }, "QualityKVReporter_19941");
      AppMethodBeat.o(186930);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(186927);
    if (!btL())
    {
      AppMethodBeat.o(186927);
      return;
    }
    if (!k.btN().mStarted)
    {
      k localk = k.btN();
      if (!localk.mStarted)
      {
        localk.mStarted = true;
        localk.lVk = 60000;
        localk.lVl = new k.b(localk, (byte)0);
        h.JZN.f(localk.lVl, k.lVj);
        ac.i("MicroMsg.QualitySampleHelper", "startSample interval:%d", new Object[] { Integer.valueOf(60000) });
      }
    }
    if (!gej.containsKey(paramString2))
    {
      gej.put(paramString2, new j(paramString1, paramString2, paramString3, paramString4, paramBoolean));
      com.tencent.mm.plugin.appbrand.g.a(paramString2, new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(186922);
          j.bS(this.val$appId, 2);
          AppMethodBeat.o(186922);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(186924);
          j.bS(this.val$appId, 5);
          j.gej.remove(this.val$appId);
          com.tencent.mm.plugin.appbrand.g.b(this.val$appId, this);
          AppMethodBeat.o(186924);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(186923);
          j.bS(this.val$appId, 3);
          AppMethodBeat.o(186923);
        }
      });
    }
    AppMethodBeat.o(186927);
  }
  
  public static void bS(String paramString, final int paramInt)
  {
    AppMethodBeat.i(186928);
    if (!btL())
    {
      AppMethodBeat.o(186928);
      return;
    }
    h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186925);
        j localj = (j)j.gej.get(this.val$appId);
        if (localj != null)
        {
          j.a(localj, paramInt);
          j.b(localj, paramInt);
        }
        AppMethodBeat.o(186925);
      }
    }, "QualityKVReporter_19941");
    AppMethodBeat.o(186928);
  }
  
  private static boolean btL()
  {
    AppMethodBeat.i(186931);
    if (lVf != null)
    {
      bool = lVf.booleanValue();
      AppMethodBeat.o(186931);
      return bool;
    }
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qbL, 0);
    ac.i("MicroMsg.QualitySampleHelper", "shouldReport:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      lVf = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(186931);
      return bool;
    }
  }
  
  public static void uF(int paramInt)
  {
    AppMethodBeat.i(186929);
    ac.i("MicroMsg.QualitySampleHelper", "updateSampleInterval :%d", new Object[] { Integer.valueOf(paramInt) });
    k.btN().lVk = paramInt;
    AppMethodBeat.o(186929);
  }
  
  private void uG(int paramInt)
  {
    AppMethodBeat.i(186932);
    a locala = new a((byte)0);
    locala.lVh = paramInt;
    locala.lVi = k.btN().uI(paramInt);
    this.lVd.add(locala);
    AppMethodBeat.o(186932);
  }
  
  private int uH(int paramInt)
  {
    AppMethodBeat.i(186933);
    Integer localInteger = (Integer)this.lVe.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(186933);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(186933);
    return paramInt;
  }
  
  static final class a
  {
    int lVh;
    int lVi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.j
 * JD-Core Version:    0.7.0.1
 */