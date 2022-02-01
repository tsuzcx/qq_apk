package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  boolean rhA;
  public String rhB;
  public int rhC;
  public final Map<String, List<Pair<String, String>>> rhy;
  public final com.tencent.mm.hellhoundlib.a.c rhz;
  
  public c()
  {
    AppMethodBeat.i(122288);
    this.rhy = new HashMap();
    this.rhz = new a((byte)0);
    this.rhA = false;
    this.rhB = null;
    this.rhC = 0;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("finish", "()V"));
    localArrayList.add(Pair.create("dealContentView", "(Landroid/view/View;)V"));
    localArrayList.add(Pair.create("onKeyDown", "(ILandroid/view/KeyEvent;)Z"));
    this.rhy.put("com/tencent/mm/plugin/voip/ui/VideoActivity", localArrayList);
    AppMethodBeat.o(122288);
  }
  
  private static void b(cie paramcie, long paramLong)
  {
    AppMethodBeat.i(122291);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122291);
      return;
    }
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramcie, str + "_" + paramLong, paramLong);
    paramcie = com.tencent.mm.plugin.expt.hellhound.core.b.aes(paramcie.sessionId);
    if (paramcie != null)
    {
      ae.i("HABBYGE-MALI.VoipFloatSession", "restoreLastSesssion, curPage: %s, %s", new Object[] { paramcie.duQ, paramcie.dAa });
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, paramcie.duQ, paramcie.aHQ, paramLong);
    }
    str = m.crj();
    paramcie = str;
    if (str == null) {
      paramcie = "";
    }
    localcie.sCx = paramcie;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localcie);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(localcie);
    AppMethodBeat.o(122291);
  }
  
  public static void vu(long paramLong)
  {
    AppMethodBeat.i(184392);
    ae.i("HABBYGE-MALI.VoipFloatSession", "onVoipSessionExit");
    vv(paramLong);
    dch localdch = l.crV();
    if (localdch == null)
    {
      AppMethodBeat.o(184392);
      return;
    }
    if (localdch.HKN) {
      b(localdch.HKJ, paramLong);
    }
    AppMethodBeat.o(184392);
  }
  
  private static void vv(long paramLong)
  {
    AppMethodBeat.i(122290);
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      ae.e("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, 不是合法session !!!");
      AppMethodBeat.o(122290);
      return;
    }
    ae.i("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, curSession: %s", new Object[] { localcie.sessionId });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(localcie, paramLong);
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
        c.this.rhB = paramObject.getClass().getCanonicalName();
        c.this.rhC = paramObject.hashCode();
      }
      if (("finish".equals(paramString2)) && ("()V".equals(paramString3)))
      {
        if (!c.this.rhA)
        {
          c.this.rhA = true;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(217, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
        }
      }
      else
      {
        if (("dealContentView".equals(paramString2)) && ("(Landroid/view/View;)V".equals(paramString3)))
        {
          c.this.rhA = false;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(219, Long.valueOf(System.currentTimeMillis()));
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
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(218, Long.valueOf(System.currentTimeMillis()));
        }
      }
      AppMethodBeat.o(184391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c
 * JD-Core Version:    0.7.0.1
 */