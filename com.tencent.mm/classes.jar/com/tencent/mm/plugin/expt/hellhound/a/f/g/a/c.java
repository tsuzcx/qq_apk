package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  public final Map<String, List<Pair<String, String>>> woR;
  public final d woS;
  boolean woT;
  public String woU;
  public int woV;
  
  public c()
  {
    AppMethodBeat.i(122288);
    this.woR = new HashMap();
    this.woS = new a((byte)0);
    this.woT = false;
    this.woU = null;
    this.woV = 0;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("finish", "()V"));
    localArrayList.add(Pair.create("dealContentView", "(Landroid/view/View;)V"));
    localArrayList.add(Pair.create("onKeyDown", "(ILandroid/view/KeyEvent;)Z"));
    this.woR.put("com/tencent/mm/plugin/voip/ui/VideoActivity", localArrayList);
    AppMethodBeat.o(122288);
  }
  
  public static void JM(long paramLong)
  {
    AppMethodBeat.i(184392);
    Log.i("HABBYGE-MALI.VoipFloatSession", "onVoipSessionExit");
    JN(paramLong);
    efn localefn = l.dfx();
    if (localefn == null)
    {
      AppMethodBeat.o(184392);
      return;
    }
    if (localefn.UiR) {
      b(localefn.UiN, paramLong);
    }
    AppMethodBeat.o(184392);
  }
  
  private static void JN(long paramLong)
  {
    AppMethodBeat.i(122290);
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      Log.e("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, 不是合法session !!!");
      AppMethodBeat.o(122290);
      return;
    }
    Log.i("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, curSession: %s", new Object[] { localdhx.sessionId });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(localdhx, paramLong);
    AppMethodBeat.o(122290);
  }
  
  private static void b(dhx paramdhx, long paramLong)
  {
    AppMethodBeat.i(122291);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122291);
      return;
    }
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramdhx, str + "_" + paramLong, paramLong);
    paramdhx = com.tencent.mm.plugin.expt.hellhound.core.b.awE(paramdhx.sessionId);
    if (paramdhx != null)
    {
      Log.i("HABBYGE-MALI.VoipFloatSession", "restoreLastSesssion, curPage: %s, %s", new Object[] { paramdhx.fFe, paramdhx.fLj });
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, paramdhx.fFe, paramdhx.aNf, paramLong);
    }
    str = m.deL();
    paramdhx = str;
    if (str == null) {
      paramdhx = "";
    }
    localdhx.nnJ = paramdhx;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localdhx);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(localdhx);
    AppMethodBeat.o(122291);
  }
  
  final class a
    implements d
  {
    private a() {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184391);
      if (paramObject != null)
      {
        c.this.woU = paramObject.getClass().getCanonicalName();
        c.this.woV = paramObject.hashCode();
      }
      if (("finish".equals(paramString2)) && ("()V".equals(paramString3)))
      {
        if (!c.this.woT)
        {
          c.this.woT = true;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(217, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
        }
      }
      else
      {
        if (("dealContentView".equals(paramString2)) && ("(Landroid/view/View;)V".equals(paramString3)))
        {
          c.this.woT = false;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(219, Long.valueOf(System.currentTimeMillis()));
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
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(218, Long.valueOf(System.currentTimeMillis()));
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