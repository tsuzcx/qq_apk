package com.tencent.mm.plugin.expt.hellhound.ext.session.f.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.l;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.m;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  public final Map<String, List<Pair<String, String>>> zKW;
  public final d zKX;
  boolean zKY;
  public String zKZ;
  public int zLa;
  
  public c()
  {
    AppMethodBeat.i(122288);
    this.zKW = new HashMap();
    this.zKX = new a((byte)0);
    this.zKY = false;
    this.zKZ = null;
    this.zLa = 0;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("finish", "()V"));
    localArrayList.add(Pair.create("dealContentView", "(Landroid/view/View;)V"));
    localArrayList.add(Pair.create("onKeyDown", "(ILandroid/view/KeyEvent;)Z"));
    this.zKW.put("com/tencent/mm/plugin/voip/ui/VideoActivity", localArrayList);
    AppMethodBeat.o(122288);
  }
  
  private static void c(eah parameah, long paramLong)
  {
    AppMethodBeat.i(122291);
    String str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122291);
      return;
    }
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.a(parameah, str + "_" + paramLong, paramLong);
    parameah = com.tencent.mm.plugin.expt.hellhound.core.b.aqI(parameah.sessionId);
    if (parameah != null)
    {
      Log.i("HABBYGE-MALI.VoipFloatSession", "restoreLastSesssion, curPage: %s, %s", new Object[] { parameah.hJW, parameah.hQR });
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, parameah.hJW, parameah.cHb, paramLong);
    }
    str = m.dLA();
    parameah = str;
    if (str == null) {
      parameah = "";
    }
    localeah.qkQ = parameah;
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(localeah);
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c(localeah);
    AppMethodBeat.o(122291);
  }
  
  public static void mk(long paramLong)
  {
    AppMethodBeat.i(184392);
    Log.i("HABBYGE-MALI.VoipFloatSession", "onVoipSessionExit");
    ml(paramLong);
    ezg localezg = l.dMl();
    if (localezg == null)
    {
      AppMethodBeat.o(184392);
      return;
    }
    if (localezg.abAq) {
      c(localezg.abAm, paramLong);
    }
    AppMethodBeat.o(184392);
  }
  
  private static void ml(long paramLong)
  {
    AppMethodBeat.i(122290);
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      Log.e("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, 不是合法session !!!");
      AppMethodBeat.o(122290);
      return;
    }
    Log.i("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, curSession: %s", new Object[] { localeah.sessionId });
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(localeah, paramLong);
    AppMethodBeat.o(122290);
  }
  
  final class a
    implements d
  {
    private a() {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184391);
      if (paramObject != null)
      {
        c.this.zKZ = paramObject.getClass().getCanonicalName();
        c.this.zLa = paramObject.hashCode();
      }
      if (("finish".equals(paramString2)) && ("()V".equals(paramString3)))
      {
        if (!c.this.zKY)
        {
          c.this.zKY = true;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(217, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184391);
        }
      }
      else
      {
        if (("dealContentView".equals(paramString2)) && ("(Landroid/view/View;)V".equals(paramString3)))
        {
          c.this.zKY = false;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(219, Long.valueOf(System.currentTimeMillis()));
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
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(218, Long.valueOf(System.currentTimeMillis()));
        }
      }
      AppMethodBeat.o(184391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c
 * JD-Core Version:    0.7.0.1
 */