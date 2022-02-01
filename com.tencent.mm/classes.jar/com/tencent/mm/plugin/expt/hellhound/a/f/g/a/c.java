package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  public final Map<String, List<Pair<String, String>>> qZs;
  public final com.tencent.mm.hellhoundlib.a.c qZt;
  boolean qZu;
  public String qZv;
  public int qZw;
  
  public c()
  {
    AppMethodBeat.i(122288);
    this.qZs = new HashMap();
    this.qZt = new a((byte)0);
    this.qZu = false;
    this.qZv = null;
    this.qZw = 0;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("finish", "()V"));
    localArrayList.add(Pair.create("dealContentView", "(Landroid/view/View;)V"));
    localArrayList.add(Pair.create("onKeyDown", "(ILandroid/view/KeyEvent;)Z"));
    this.qZs.put("com/tencent/mm/plugin/voip/ui/VideoActivity", localArrayList);
    AppMethodBeat.o(122288);
  }
  
  private static void b(chk paramchk, long paramLong)
  {
    AppMethodBeat.i(122291);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramchk.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122291);
      return;
    }
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramchk, str + "_" + paramLong, paramLong);
    paramchk = com.tencent.mm.plugin.expt.hellhound.core.b.ady(paramchk.sessionId);
    if (paramchk != null)
    {
      ad.i("HABBYGE-MALI.VoipFloatSession", "restoreLastSesssion, curPage: %s, %s", new Object[] { paramchk.dtL, paramchk.dyV });
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, paramchk.dtL, paramchk.aHQ, paramLong);
    }
    str = m.cpH();
    paramchk = str;
    if (str == null) {
      paramchk = "";
    }
    localchk.ssn = paramchk;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(localchk);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localchk);
    AppMethodBeat.o(122291);
  }
  
  public static void ve(long paramLong)
  {
    AppMethodBeat.i(184392);
    ad.i("HABBYGE-MALI.VoipFloatSession", "onVoipSessionExit");
    vf(paramLong);
    dbn localdbn = l.cqt();
    if (localdbn == null)
    {
      AppMethodBeat.o(184392);
      return;
    }
    if (localdbn.Hrl) {
      b(localdbn.Hrh, paramLong);
    }
    AppMethodBeat.o(184392);
  }
  
  private static void vf(long paramLong)
  {
    AppMethodBeat.i(122290);
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      ad.e("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, 不是合法session !!!");
      AppMethodBeat.o(122290);
      return;
    }
    ad.i("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, curSession: %s", new Object[] { localchk.sessionId });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(localchk, paramLong);
    AppMethodBeat.o(122290);
  }
  
  final class a
    implements com.tencent.mm.hellhoundlib.a.c
  {
    private a() {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184391);
      if (paramObject != null)
      {
        c.this.qZv = paramObject.getClass().getCanonicalName();
        c.this.qZw = paramObject.hashCode();
      }
      if (("finish".equals(paramString2)) && ("()V".equals(paramString3)))
      {
        if (!c.this.qZu)
        {
          c.this.qZu = true;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(217, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
        }
      }
      else
      {
        if (("dealContentView".equals(paramString2)) && ("(Landroid/view/View;)V".equals(paramString3)))
        {
          c.this.qZu = false;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(219, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
          return;
        }
        if (("onKeyDown".equals(paramString2)) && ("(ILandroid/view/KeyEvent;)Z".equals(paramString3)))
        {
          if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
          {
            int i = ((Integer)paramArrayOfObject[0]).intValue();
            if (i == 4)
            {
              AppMethodBeat.o(184391);
              return;
            }
            if ((i == 25) || (i == 24))
            {
              AppMethodBeat.o(184391);
              return;
            }
          }
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(218, Long.valueOf(System.currentTimeMillis()));
        }
      }
      AppMethodBeat.o(184391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c
 * JD-Core Version:    0.7.0.1
 */