package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Map<String, List<Pair<String, String>>> rhy;
  public final com.tencent.mm.hellhoundlib.a.c rhz;
  
  public a()
  {
    AppMethodBeat.i(122268);
    this.rhy = new HashMap();
    this.rhz = new a((byte)0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("show", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.rhy.put("com/tencent/mm/plugin/ball/view/FloatMenuView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onAttachedToWindow", "()V"));
    localArrayList.add(Pair.create("onDetachedFromWindow", "()V"));
    localArrayList.add(Pair.create("show", "(ZLandroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.rhy.put("com/tencent/mm/plugin/ball/view/FloatBallView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onFloatMenuBackgroundClicked", "()V"));
    localArrayList.add(Pair.create("onFloatMenuBackPressed", "()V"));
    localArrayList.add(Pair.create("onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V"));
    localArrayList.add(Pair.create("onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V"));
    this.rhy.put("com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", localArrayList);
    AppMethodBeat.o(122268);
  }
  
  public static void DC(int paramInt)
  {
    AppMethodBeat.i(196165);
    ae.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSession, %d", new Object[] { Integer.valueOf(paramInt) });
    b.fx(-1, paramInt);
    b.DD(paramInt);
    AppMethodBeat.o(196165);
  }
  
  private static void a(cie paramcie, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122271);
    if (paramcie == null)
    {
      ae.e("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, 不是合法session !!!");
      AppMethodBeat.o(122271);
      return;
    }
    ae.i("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, curSession: %s, %d, %d", new Object[] { paramcie.sessionId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(paramcie, paramLong);
    AppMethodBeat.o(122271);
  }
  
  public static void a(cie paramcie, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184389);
    a(paramcie, paramLong, paramInt1, paramInt2);
    paramcie = l.crV();
    if (paramcie == null)
    {
      AppMethodBeat.o(184389);
      return;
    }
    if (paramcie.HKN)
    {
      b(paramcie.HKJ, paramLong);
      AppMethodBeat.o(184389);
      return;
    }
    ae.i("HABBYGE-MALI.FloatBallSessionHandler", "_onFloatSessionExit, lastValidateSession[FALSE], finish=%b, floatClickEvent=%s, floatEventType=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 1))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().x(paramcie.HKK.duQ, paramcie.HKK.aHQ, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, paramcie.HKK.duQ, paramcie.HKK.aHQ, paramLong);
    }
    AppMethodBeat.o(184389);
  }
  
  private static void b(cie paramcie, long paramLong)
  {
    AppMethodBeat.i(122270);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122270);
      return;
    }
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramcie, str + "_" + paramLong, paramLong);
    paramcie = com.tencent.mm.plugin.expt.hellhound.core.b.aes(paramcie.sessionId);
    if (paramcie != null)
    {
      ae.i("HABBYGE-MALI.FloatBallSessionHandler", "restoreLastSesssion, curPage: %s", new Object[] { paramcie.dAa });
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
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(208, Long.valueOf(l));
          AppMethodBeat.o(184388);
          return;
        }
        if (("hide".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(211, Long.valueOf(l));
          AppMethodBeat.o(184388);
        }
      }
      else if ("com/tencent/mm/plugin/ball/view/FloatBallView".equals(paramString1))
      {
        if (("onAttachedToWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          paramString1 = new atn();
          paramString1.type = 5;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(210, paramString1);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onDetachedFromWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(212, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184388);
          return;
        }
        if (("show".equals(paramString2)) && ("(ZLandroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          paramString1 = new atn();
          paramString1.type = 3;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(210, paramString1);
          AppMethodBeat.o(184388);
        }
      }
      else
      {
        if (("onFloatMenuBackgroundClicked".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().De(213);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuBackPressed".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().De(214);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemClicked".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().De(215);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemRemoved".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().De(216);
        }
      }
      AppMethodBeat.o(184388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a
 * JD-Core Version:    0.7.0.1
 */