package com.tencent.mm.plugin.expt.hellhound.ext.session.f.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.l;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.m;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Map<String, List<Pair<String, String>>> zKW;
  public final d zKX;
  
  public a()
  {
    AppMethodBeat.i(122268);
    this.zKW = new HashMap();
    this.zKX = new a((byte)0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("show", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.zKW.put("com/tencent/mm/plugin/ball/view/FloatMenuView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onAttachedToWindow", "()V"));
    localArrayList.add(Pair.create("onDetachedFromWindow", "()V"));
    localArrayList.add(Pair.create("show", "(ZLandroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.zKW.put("com/tencent/mm/plugin/ball/view/FloatBallView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onFloatMenuBackgroundClicked", "()V"));
    localArrayList.add(Pair.create("onFloatMenuBackPressed", "()V"));
    localArrayList.add(Pair.create("onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V"));
    localArrayList.add(Pair.create("onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V"));
    this.zKW.put("com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", localArrayList);
    AppMethodBeat.o(122268);
  }
  
  public static void LY(int paramInt)
  {
    AppMethodBeat.i(300271);
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSession, %d", new Object[] { Integer.valueOf(paramInt) });
    b.hd(-1, paramInt);
    b.LZ(paramInt);
    AppMethodBeat.o(300271);
  }
  
  private static void a(eah parameah, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122271);
    if (parameah == null)
    {
      Log.e("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, 不是合法session !!!");
      AppMethodBeat.o(122271);
      return;
    }
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, curSession: %s, %d, %d", new Object[] { parameah.sessionId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(parameah, paramLong);
    AppMethodBeat.o(122271);
  }
  
  private static void a(eah parameah, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184389);
    a(parameah, paramLong, paramInt1, paramInt2);
    parameah = l.dMl();
    if (parameah == null)
    {
      AppMethodBeat.o(184389);
      return;
    }
    if (parameah.abAq)
    {
      c(parameah.abAm, paramLong);
      AppMethodBeat.o(184389);
      return;
    }
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "_onFloatSessionExit, lastValidateSession[FALSE], finish=%b, floatClickEvent=%s, floatEventType=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 1))
    {
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().x(parameah.abAn.hJW, parameah.abAn.cHb, paramLong);
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(null, parameah.abAn.hJW, parameah.abAn.cHb, paramLong);
    }
    AppMethodBeat.o(184389);
  }
  
  private static void c(eah parameah, long paramLong)
  {
    AppMethodBeat.i(122270);
    String str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122270);
      return;
    }
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.a(parameah, str + "_" + paramLong, paramLong);
    parameah = com.tencent.mm.plugin.expt.hellhound.core.b.aqI(parameah.sessionId);
    if (parameah != null)
    {
      Log.i("HABBYGE-MALI.FloatBallSessionHandler", "restoreLastSesssion, curPage: %s", new Object[] { parameah.hQR });
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
    AppMethodBeat.o(122270);
  }
  
  public static void i(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(300248);
    b.oX(false);
    Object localObject = b.dMw();
    if (localObject == null)
    {
      AppMethodBeat.o(300248);
      return;
    }
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, finish: %b, %d, %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 2) && (j != 3) && (j != 4))
    {
      Log.w("HABBYGE-MALI.FloatBallSessionHandler", "FoatBall, onFloatSessionExit: onFloatMenuItemClicked");
      AppMethodBeat.o(300248);
      return;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localObject == null)
    {
      Log.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, curSession == null");
      AppMethodBeat.o(300248);
      return;
    }
    if (paramBoolean)
    {
      String str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(((eah)localObject).sessionId);
      if ((str == null) || (!str.equals("145")))
      {
        Log.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, sid: %s, %s", new Object[] { str, ((eah)localObject).sessionId });
        AppMethodBeat.o(300248);
        return;
      }
      int k = b.dMt();
      if ((k == 3) || (k == 4))
      {
        Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, state, read %d", new Object[] { Integer.valueOf(b.dMv()) });
        if (b.dMv() == 8) {
          a((eah)localObject, true, i, j, paramLong);
        }
      }
      AppMethodBeat.o(300248);
      return;
    }
    a((eah)localObject, false, i, j, paramLong);
    AppMethodBeat.o(300248);
  }
  
  static final class a
    implements d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184388);
      if ("com/tencent/mm/plugin/ball/view/FloatMenuView".equals(paramString1))
      {
        long l;
        if (("show".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(208, Long.valueOf(l));
          AppMethodBeat.o(184388);
          return;
        }
        if (("hide".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(211, Long.valueOf(l));
          AppMethodBeat.o(184388);
        }
      }
      else if ("com/tencent/mm/plugin/ball/view/FloatBallView".equals(paramString1))
      {
        if (("onAttachedToWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          paramString1 = new bzj();
          paramString1.type = 5;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(210, paramString1);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onDetachedFromWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(212, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184388);
          return;
        }
        if (("show".equals(paramString2)) && ("(ZLandroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          paramString1 = new bzj();
          paramString1.type = 3;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(210, paramString1);
          AppMethodBeat.o(184388);
        }
      }
      else
      {
        if (("onFloatMenuBackgroundClicked".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(213);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuBackPressed".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(214);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemClicked".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(215);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemRemoved".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(216);
        }
      }
      AppMethodBeat.o(184388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.a
 * JD-Core Version:    0.7.0.1
 */