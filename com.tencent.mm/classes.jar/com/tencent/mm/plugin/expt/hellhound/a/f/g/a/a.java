package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Map<String, List<Pair<String, String>>> qqp;
  public final com.tencent.mm.hellhoundlib.a.c qqq;
  
  public a()
  {
    AppMethodBeat.i(122268);
    this.qqp = new HashMap();
    this.qqq = new a((byte)0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("show", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.qqp.put("com/tencent/mm/plugin/ball/view/FloatMenuView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onAttachedToWindow", "()V"));
    localArrayList.add(Pair.create("onDetachedFromWindow", "()V"));
    localArrayList.add(Pair.create("show", "(ZLandroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.qqp.put("com/tencent/mm/plugin/ball/view/FloatBallView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onFloatMenuBackgroundClicked", "()V"));
    localArrayList.add(Pair.create("onFloatMenuBackPressed", "()V"));
    localArrayList.add(Pair.create("onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V"));
    localArrayList.add(Pair.create("onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V"));
    this.qqp.put("com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", localArrayList);
    AppMethodBeat.o(122268);
  }
  
  public static void CC(int paramInt)
  {
    AppMethodBeat.i(195295);
    ac.i("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSession, %d", new Object[] { Integer.valueOf(paramInt) });
    c.fs(-1, paramInt);
    c.CD(paramInt);
    AppMethodBeat.o(195295);
  }
  
  private static void a(ccs paramccs, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122271);
    if (paramccs == null)
    {
      ac.e("FloatBallSessionHandler", "HABBYGE-MALI, _exitFloatSession, 不是合法session !!!");
      AppMethodBeat.o(122271);
      return;
    }
    ac.i("FloatBallSessionHandler", "HABBYGE-MALI, _exitFloatSession, curSession: %s, %d, %d", new Object[] { paramccs.sessionId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(paramccs, paramLong);
    AppMethodBeat.o(122271);
  }
  
  public static void a(ccs paramccs, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184389);
    a(paramccs, paramLong, paramInt1, paramInt2);
    paramccs = b.clk();
    boolean bool;
    if (paramBoolean)
    {
      bool = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckT();
      ac.i("FloatBallSessionHandler", "HABBYGE-MALI, isSession: %b", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (paramccs == null)) {
        break label190;
      }
      paramccs = paramccs.EIe;
    }
    for (;;)
    {
      if (paramccs == null)
      {
        ac.d("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, lstSession is NULL: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        paramccs = com.tencent.mm.plugin.expt.hellhound.core.b.ciG();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().aj(paramccs, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, paramccs, paramLong);
        AppMethodBeat.o(184389);
        return;
        bool = c.clm();
        ac.i("FloatBallSessionHandler", "HABBYGE-MALI, hasClickMenuItemYet: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          if (paramccs != null) {
            paramccs = paramccs.EIg;
          }
        }
        else if (paramccs != null) {
          paramccs = paramccs.EIe;
        }
      }
      else
      {
        ac.w("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, lastSession is: %s", new Object[] { paramccs.sessionId });
        b(paramccs, paramLong);
        AppMethodBeat.o(184389);
        return;
      }
      label190:
      paramccs = null;
    }
  }
  
  private static void b(ccs paramccs, long paramLong)
  {
    AppMethodBeat.i(122270);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramccs.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122270);
      return;
    }
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramccs, str + "_" + paramLong, paramLong);
    paramccs = com.tencent.mm.plugin.expt.hellhound.core.b.ZL(paramccs.sessionId);
    ac.d("FloatBallSessionHandler", "HABBYGE-MALI, restoreLastSesssion, curPage: %s", new Object[] { paramccs });
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
    AppMethodBeat.o(122270);
  }
  
  static final class a
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184388);
      if ("com/tencent/mm/plugin/ball/view/FloatMenuView".equals(paramString1))
      {
        long l;
        if (("show".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(208, Long.valueOf(l));
          AppMethodBeat.o(184388);
          return;
        }
        if (("hide".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(211, Long.valueOf(l));
          AppMethodBeat.o(184388);
        }
      }
      else if ("com/tencent/mm/plugin/ball/view/FloatBallView".equals(paramString1))
      {
        if (("onAttachedToWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          paramString1 = new apc();
          paramString1.type = 5;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(210, paramString1);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onDetachedFromWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(212, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184388);
          return;
        }
        if (("show".equals(paramString2)) && ("(ZLandroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          paramString1 = new apc();
          paramString1.type = 3;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(210, paramString1);
          AppMethodBeat.o(184388);
        }
      }
      else
      {
        if (("onFloatMenuBackgroundClicked".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(213);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuBackPressed".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(214);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemClicked".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(215);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemRemoved".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(216);
        }
      }
      AppMethodBeat.o(184388);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a
 * JD-Core Version:    0.7.0.1
 */