package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  public final Map<String, List<Pair<String, String>>> sIU;
  public final com.tencent.mm.hellhoundlib.a.c sIV;
  boolean sIW;
  public String sIX;
  public int sIY;
  
  public c()
  {
    AppMethodBeat.i(122288);
    this.sIU = new HashMap();
    this.sIV = new a((byte)0);
    this.sIW = false;
    this.sIX = null;
    this.sIY = 0;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("finish", "()V"));
    localArrayList.add(Pair.create("dealContentView", "(Landroid/view/View;)V"));
    localArrayList.add(Pair.create("onKeyDown", "(ILandroid/view/KeyEvent;)Z"));
    this.sIU.put("com/tencent/mm/plugin/voip/ui/VideoActivity", localArrayList);
    AppMethodBeat.o(122288);
  }
  
  public static void Dy(long paramLong)
  {
    AppMethodBeat.i(184392);
    Log.i("HABBYGE-MALI.VoipFloatSession", "onVoipSessionExit");
    Dz(paramLong);
    dvl localdvl = l.cQD();
    if (localdvl == null)
    {
      AppMethodBeat.o(184392);
      return;
    }
    if (localdvl.MWw) {
      b(localdvl.MWs, paramLong);
    }
    AppMethodBeat.o(184392);
  }
  
  private static void Dz(long paramLong)
  {
    AppMethodBeat.i(122290);
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      Log.e("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, 不是合法session !!!");
      AppMethodBeat.o(122290);
      return;
    }
    Log.i("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, curSession: %s", new Object[] { localcyl.sessionId });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(localcyl, paramLong);
    AppMethodBeat.o(122290);
  }
  
  private static void b(cyl paramcyl, long paramLong)
  {
    AppMethodBeat.i(122291);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122291);
      return;
    }
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramcyl, str + "_" + paramLong, paramLong);
    paramcyl = com.tencent.mm.plugin.expt.hellhound.core.b.aoF(paramcyl.sessionId);
    if (paramcyl != null)
    {
      Log.i("HABBYGE-MALI.VoipFloatSession", "restoreLastSesssion, curPage: %s, %s", new Object[] { paramcyl.dMl, paramcyl.dRM });
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, paramcyl.dMl, paramcyl.aHK, paramLong);
    }
    str = m.cPR();
    paramcyl = str;
    if (str == null) {
      paramcyl = "";
    }
    localcyl.kvy = paramcyl;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localcyl);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(localcyl);
    AppMethodBeat.o(122291);
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
        c.this.sIX = paramObject.getClass().getCanonicalName();
        c.this.sIY = paramObject.hashCode();
      }
      if (("finish".equals(paramString2)) && ("()V".equals(paramString3)))
      {
        if (!c.this.sIW)
        {
          c.this.sIW = true;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(217, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
        }
      }
      else
      {
        if (("dealContentView".equals(paramString2)) && ("(Landroid/view/View;)V".equals(paramString3)))
        {
          c.this.sIW = false;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(219, Long.valueOf(System.currentTimeMillis()));
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
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(218, Long.valueOf(System.currentTimeMillis()));
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