package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Map<String, List<Pair<String, String>>> pHI;
  public final com.tencent.mm.hellhoundlib.a.c pHJ;
  
  public a()
  {
    AppMethodBeat.i(122268);
    this.pHI = new HashMap();
    this.pHJ = new a((byte)0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("show", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.pHI.put("com/tencent/mm/plugin/ball/view/FloatMenuView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onAttachedToWindow", "()V"));
    localArrayList.add(Pair.create("onDetachedFromWindow", "()V"));
    localArrayList.add(Pair.create("show", "(ZLandroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.pHI.put("com/tencent/mm/plugin/ball/view/FloatBallView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onFloatMenuBackgroundClicked", "()V"));
    localArrayList.add(Pair.create("onFloatMenuBackPressed", "()V"));
    localArrayList.add(Pair.create("onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V"));
    localArrayList.add(Pair.create("onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V"));
    this.pHI.put("com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", localArrayList);
    AppMethodBeat.o(122268);
  }
  
  private static void a(bxx parambxx, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122271);
    if (parambxx == null)
    {
      ad.e("FloatBallSessionHandler", "HABBYGE-MALI, _exitFloatSession, 不是合法session !!!");
      AppMethodBeat.o(122271);
      return;
    }
    ad.i("FloatBallSessionHandler", "HABBYGE-MALI, _exitFloatSession, curSession: %s, %d, %d", new Object[] { parambxx.sessionId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(parambxx, paramLong);
    AppMethodBeat.o(122271);
  }
  
  public static void a(bxx parambxx, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184389);
    a(parambxx, paramLong, paramInt1, paramInt2);
    parambxx = b.cdC();
    boolean bool;
    if (paramBoolean)
    {
      bool = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdl();
      ad.i("FloatBallSessionHandler", "HABBYGE-MALI, isSession: %b", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (parambxx == null)) {
        break label190;
      }
      parambxx = parambxx.Dne;
    }
    for (;;)
    {
      if (parambxx == null)
      {
        ad.d("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, lstSession is NULL: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        parambxx = com.tencent.mm.plugin.expt.hellhound.core.b.cbx();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().ah(parambxx, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, parambxx, paramLong);
        AppMethodBeat.o(184389);
        return;
        bool = c.cdE();
        ad.i("FloatBallSessionHandler", "HABBYGE-MALI, hasClickMenuItemYet: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          if (parambxx != null) {
            parambxx = parambxx.Dng;
          }
        }
        else if (parambxx != null) {
          parambxx = parambxx.Dne;
        }
      }
      else
      {
        ad.w("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, lastSession is: %s", new Object[] { parambxx.sessionId });
        b(parambxx, paramLong);
        AppMethodBeat.o(184389);
        return;
      }
      label190:
      parambxx = null;
    }
  }
  
  public static void aha(int paramInt)
  {
    AppMethodBeat.i(205457);
    ad.i("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSession, %d", new Object[] { Integer.valueOf(paramInt) });
    c.fp(-1, paramInt);
    c.ahb(paramInt);
    AppMethodBeat.o(205457);
  }
  
  private static void b(bxx parambxx, long paramLong)
  {
    AppMethodBeat.i(122270);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(parambxx.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122270);
      return;
    }
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(parambxx, str + "_" + paramLong, paramLong);
    parambxx = com.tencent.mm.plugin.expt.hellhound.core.b.Vz(parambxx.sessionId);
    ad.d("FloatBallSessionHandler", "HABBYGE-MALI, restoreLastSesssion, curPage: %s", new Object[] { parambxx });
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
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(208, Long.valueOf(l));
          AppMethodBeat.o(184388);
          return;
        }
        if (("hide".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(211, Long.valueOf(l));
          AppMethodBeat.o(184388);
        }
      }
      else if ("com/tencent/mm/plugin/ball/view/FloatBallView".equals(paramString1))
      {
        if (("onAttachedToWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          paramString1 = new alz();
          paramString1.type = 5;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(210, paramString1);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onDetachedFromWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(212, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184388);
          return;
        }
        if (("show".equals(paramString2)) && ("(ZLandroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          paramString1 = new alz();
          paramString1.type = 3;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(210, paramString1);
          AppMethodBeat.o(184388);
        }
      }
      else
      {
        if (("onFloatMenuBackgroundClicked".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().Bo(213);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuBackPressed".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().Bo(214);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemClicked".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().Bo(215);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemRemoved".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().Bo(216);
        }
      }
      AppMethodBeat.o(184388);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a
 * JD-Core Version:    0.7.0.1
 */