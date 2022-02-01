package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
{
  public final Map<String, List<Pair<String, String>>> pHI;
  public final com.tencent.mm.hellhoundlib.a.c pHJ;
  boolean pHK;
  
  public d()
  {
    AppMethodBeat.i(122288);
    this.pHI = new HashMap();
    this.pHJ = new a((byte)0);
    this.pHK = false;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("finish", "()V"));
    localArrayList.add(Pair.create("dealContentView", "(Landroid/view/View;)V"));
    localArrayList.add(Pair.create("onKeyDown", "(ILandroid/view/KeyEvent;)Z"));
    this.pHI.put("com/tencent/mm/plugin/voip/ui/VideoActivity", localArrayList);
    AppMethodBeat.o(122288);
  }
  
  private static void b(bxx parambxx, long paramLong)
  {
    AppMethodBeat.i(122291);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(parambxx.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122291);
      return;
    }
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(parambxx, str + "_" + paramLong, paramLong);
    parambxx = com.tencent.mm.plugin.expt.hellhound.core.b.Vz(parambxx.sessionId);
    ad.i("VoipFloatSession", "HABBYGE-MALI, restoreLastSesssion, curPage: %s", new Object[] { parambxx });
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, parambxx, paramLong);
    str = l.ccJ();
    parambxx = str;
    if (str == null) {
      parambxx = "";
    }
    localbxx.DUm = parambxx;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(localbxx);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localbxx);
    AppMethodBeat.o(122291);
  }
  
  public static void ps(long paramLong)
  {
    AppMethodBeat.i(184392);
    ad.i("VoipFloatSession", "HABBYGE-MALI, onVoipSessionExit");
    pt(paramLong);
    Object localObject = b.cdC();
    if (localObject == null)
    {
      ad.i("VoipFloatSession", "HABBYGE-MALI, onVoipSessionExit, lastSession is NULL");
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.cbx();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().ah((String)localObject, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, (String)localObject, paramLong);
      AppMethodBeat.o(184392);
      return;
      if (((ama)localObject).Dne != null)
      {
        b(((ama)localObject).Dne, paramLong);
        AppMethodBeat.o(184392);
        return;
      }
      if (((ama)localObject).Dng != null)
      {
        b(((ama)localObject).Dng, paramLong);
        AppMethodBeat.o(184392);
        return;
      }
      if (((ama)localObject).Dnf == null) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.cbx();
      } else {
        localObject = ((ama)localObject).Dnf;
      }
    }
  }
  
  private static void pt(long paramLong)
  {
    AppMethodBeat.i(122290);
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      ad.e("VoipFloatSession", "HABBYGE-MALI, _exitVoipSession, 不是合法session !!!");
      AppMethodBeat.o(122290);
      return;
    }
    ad.i("VoipFloatSession", "HABBYGE-MALI, _exitVoipSession, curSession: %s", new Object[] { localbxx.sessionId });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(localbxx, paramLong);
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
        if (!d.this.pHK)
        {
          d.this.pHK = true;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(217, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
        }
      }
      else
      {
        if (("dealContentView".equals(paramString2)) && ("(Landroid/view/View;)V".equals(paramString3)))
        {
          d.this.pHK = false;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(219, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
          return;
        }
        if (("onKeyDown".equals(paramString2)) && ("(ILandroid/view/KeyEvent;)Z".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(218, Long.valueOf(System.currentTimeMillis()));
        }
      }
      AppMethodBeat.o(184391);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d
 * JD-Core Version:    0.7.0.1
 */