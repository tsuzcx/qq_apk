package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Map<String, List<Pair<String, String>>> qZs;
  public final com.tencent.mm.hellhoundlib.a.c qZt;
  
  public a()
  {
    AppMethodBeat.i(122268);
    this.qZs = new HashMap();
    this.qZt = new a((byte)0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("show", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.qZs.put("com/tencent/mm/plugin/ball/view/FloatMenuView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onAttachedToWindow", "()V"));
    localArrayList.add(Pair.create("onDetachedFromWindow", "()V"));
    localArrayList.add(Pair.create("show", "(ZLandroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.qZs.put("com/tencent/mm/plugin/ball/view/FloatBallView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onFloatMenuBackgroundClicked", "()V"));
    localArrayList.add(Pair.create("onFloatMenuBackPressed", "()V"));
    localArrayList.add(Pair.create("onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V"));
    localArrayList.add(Pair.create("onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V"));
    this.qZs.put("com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", localArrayList);
    AppMethodBeat.o(122268);
  }
  
  public static void Dp(int paramInt)
  {
    AppMethodBeat.i(210498);
    ad.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSession, %d", new Object[] { Integer.valueOf(paramInt) });
    b.fz(-1, paramInt);
    b.Dq(paramInt);
    AppMethodBeat.o(210498);
  }
  
  private static void a(chk paramchk, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122271);
    if (paramchk == null)
    {
      ad.e("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, 不是合法session !!!");
      AppMethodBeat.o(122271);
      return;
    }
    ad.i("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, curSession: %s, %d, %d", new Object[] { paramchk.sessionId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(paramchk, paramLong);
    AppMethodBeat.o(122271);
  }
  
  public static void a(chk paramchk, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184389);
    a(paramchk, paramLong, paramInt1, paramInt2);
    paramchk = l.cqt();
    if (paramchk == null)
    {
      AppMethodBeat.o(184389);
      return;
    }
    if (paramchk.Hrl)
    {
      b(paramchk.Hrh, paramLong);
      AppMethodBeat.o(184389);
      return;
    }
    ad.i("HABBYGE-MALI.FloatBallSessionHandler", "_onFloatSessionExit, lastValidateSession[FALSE], finish=%b, floatClickEvent=%s, floatEventType=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 1))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().y(paramchk.Hri.dtL, paramchk.Hri.aHQ, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, paramchk.Hri.dtL, paramchk.Hri.aHQ, paramLong);
    }
    AppMethodBeat.o(184389);
  }
  
  private static void b(chk paramchk, long paramLong)
  {
    AppMethodBeat.i(122270);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramchk.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122270);
      return;
    }
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramchk, str + "_" + paramLong, paramLong);
    paramchk = com.tencent.mm.plugin.expt.hellhound.core.b.ady(paramchk.sessionId);
    if (paramchk != null)
    {
      ad.i("HABBYGE-MALI.FloatBallSessionHandler", "restoreLastSesssion, curPage: %s", new Object[] { paramchk.dyV });
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
    AppMethodBeat.o(122270);
  }
  
  static final class a
    implements com.tencent.mm.hellhoundlib.a.c
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
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(208, Long.valueOf(l));
          AppMethodBeat.o(184388);
          return;
        }
        if (("hide".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(211, Long.valueOf(l));
          AppMethodBeat.o(184388);
        }
      }
      else if ("com/tencent/mm/plugin/ball/view/FloatBallView".equals(paramString1))
      {
        if (("onAttachedToWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          paramString1 = new asx();
          paramString1.type = 5;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(210, paramString1);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onDetachedFromWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(212, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184388);
          return;
        }
        if (("show".equals(paramString2)) && ("(ZLandroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          paramString1 = new asx();
          paramString1.type = 3;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(210, paramString1);
          AppMethodBeat.o(184388);
        }
      }
      else
      {
        if (("onFloatMenuBackgroundClicked".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(213);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuBackPressed".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(214);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemClicked".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(215);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemRemoved".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(216);
        }
      }
      AppMethodBeat.o(184388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a
 * JD-Core Version:    0.7.0.1
 */