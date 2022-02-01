package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
{
  public final Map<String, List<Pair<String, String>>> qqp;
  public final com.tencent.mm.hellhoundlib.a.c qqq;
  boolean qqr;
  
  public d()
  {
    AppMethodBeat.i(122288);
    this.qqp = new HashMap();
    this.qqq = new a((byte)0);
    this.qqr = false;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("finish", "()V"));
    localArrayList.add(Pair.create("dealContentView", "(Landroid/view/View;)V"));
    localArrayList.add(Pair.create("onKeyDown", "(ILandroid/view/KeyEvent;)Z"));
    this.qqp.put("com/tencent/mm/plugin/voip/ui/VideoActivity", localArrayList);
    AppMethodBeat.o(122288);
  }
  
  private static void b(ccs paramccs, long paramLong)
  {
    AppMethodBeat.i(122291);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramccs.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122291);
      return;
    }
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramccs, str + "_" + paramLong, paramLong);
    paramccs = com.tencent.mm.plugin.expt.hellhound.core.b.ZL(paramccs.sessionId);
    ac.i("VoipFloatSession", "HABBYGE-MALI, restoreLastSesssion, curPage: %s", new Object[] { paramccs });
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, paramccs, paramLong);
    str = l.ckr();
    paramccs = str;
    if (str == null) {
      paramccs = "";
    }
    localccs.FqZ = paramccs;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localccs);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localccs);
    AppMethodBeat.o(122291);
  }
  
  public static void th(long paramLong)
  {
    AppMethodBeat.i(184392);
    ac.i("VoipFloatSession", "HABBYGE-MALI, onVoipSessionExit");
    ti(paramLong);
    Object localObject = b.clk();
    if (localObject == null)
    {
      ac.i("VoipFloatSession", "HABBYGE-MALI, onVoipSessionExit, lastSession is NULL");
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ciG();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().aj((String)localObject, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, (String)localObject, paramLong);
      AppMethodBeat.o(184392);
      return;
      if (((apd)localObject).EIe != null)
      {
        b(((apd)localObject).EIe, paramLong);
        AppMethodBeat.o(184392);
        return;
      }
      if (((apd)localObject).EIg != null)
      {
        b(((apd)localObject).EIg, paramLong);
        AppMethodBeat.o(184392);
        return;
      }
      if (((apd)localObject).EIf == null) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ciG();
      } else {
        localObject = ((apd)localObject).EIf;
      }
    }
  }
  
  private static void ti(long paramLong)
  {
    AppMethodBeat.i(122290);
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      ac.e("VoipFloatSession", "HABBYGE-MALI, _exitVoipSession, 不是合法session !!!");
      AppMethodBeat.o(122290);
      return;
    }
    ac.i("VoipFloatSession", "HABBYGE-MALI, _exitVoipSession, curSession: %s", new Object[] { localccs.sessionId });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(localccs, paramLong);
    AppMethodBeat.o(122290);
  }
  
  final class a
    implements com.tencent.mm.hellhoundlib.a.c
  {
    private a() {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184391);
      if (("finish".equals(paramString2)) && ("()V".equals(paramString3)))
      {
        if (!d.this.qqr)
        {
          d.this.qqr = true;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(217, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
        }
      }
      else
      {
        if (("dealContentView".equals(paramString2)) && ("(Landroid/view/View;)V".equals(paramString3)))
        {
          d.this.qqr = false;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(219, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
          return;
        }
        if (("onKeyDown".equals(paramString2)) && ("(ILandroid/view/KeyEvent;)Z".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(218, Long.valueOf(System.currentTimeMillis()));
        }
      }
      AppMethodBeat.o(184391);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d
 * JD-Core Version:    0.7.0.1
 */