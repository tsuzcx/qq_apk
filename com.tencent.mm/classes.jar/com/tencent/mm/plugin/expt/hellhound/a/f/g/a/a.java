package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Map<String, List<Pair<String, String>>> woR;
  public final d woS;
  
  public a()
  {
    AppMethodBeat.i(122268);
    this.woR = new HashMap();
    this.woS = new a((byte)0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("show", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.woR.put("com/tencent/mm/plugin/ball/view/FloatMenuView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onAttachedToWindow", "()V"));
    localArrayList.add(Pair.create("onDetachedFromWindow", "()V"));
    localArrayList.add(Pair.create("show", "(ZLandroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.woR.put("com/tencent/mm/plugin/ball/view/FloatBallView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onFloatMenuBackgroundClicked", "()V"));
    localArrayList.add(Pair.create("onFloatMenuBackPressed", "()V"));
    localArrayList.add(Pair.create("onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V"));
    localArrayList.add(Pair.create("onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V"));
    this.woR.put("com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", localArrayList);
    AppMethodBeat.o(122268);
  }
  
  public static void KZ(int paramInt)
  {
    AppMethodBeat.i(251372);
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSession, %d", new Object[] { Integer.valueOf(paramInt) });
    b.gk(-1, paramInt);
    b.La(paramInt);
    AppMethodBeat.o(251372);
  }
  
  private static void a(dhx paramdhx, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122271);
    if (paramdhx == null)
    {
      Log.e("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, 不是合法session !!!");
      AppMethodBeat.o(122271);
      return;
    }
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, curSession: %s, %d, %d", new Object[] { paramdhx.sessionId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(paramdhx, paramLong);
    AppMethodBeat.o(122271);
  }
  
  private static void a(dhx paramdhx, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184389);
    a(paramdhx, paramLong, paramInt1, paramInt2);
    paramdhx = l.dfx();
    if (paramdhx == null)
    {
      AppMethodBeat.o(184389);
      return;
    }
    if (paramdhx.UiR)
    {
      b(paramdhx.UiN, paramLong);
      AppMethodBeat.o(184389);
      return;
    }
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "_onFloatSessionExit, lastValidateSession[FALSE], finish=%b, floatClickEvent=%s, floatEventType=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 1))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().x(paramdhx.UiO.fFe, paramdhx.UiO.aNf, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, paramdhx.UiO.fFe, paramdhx.UiO.aNf, paramLong);
    }
    AppMethodBeat.o(184389);
  }
  
  private static void b(dhx paramdhx, long paramLong)
  {
    AppMethodBeat.i(122270);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122270);
      return;
    }
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramdhx, str + "_" + paramLong, paramLong);
    paramdhx = com.tencent.mm.plugin.expt.hellhound.core.b.awE(paramdhx.sessionId);
    if (paramdhx != null)
    {
      Log.i("HABBYGE-MALI.FloatBallSessionHandler", "restoreLastSesssion, curPage: %s", new Object[] { paramdhx.fLj });
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
    AppMethodBeat.o(122270);
  }
  
  public static void g(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(251371);
    b.nx(false);
    Object localObject = b.dfI();
    if (localObject == null)
    {
      AppMethodBeat.o(251371);
      return;
    }
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, finish: %b, %d, %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 2) && (j != 3) && (j != 4))
    {
      Log.w("HABBYGE-MALI.FloatBallSessionHandler", "FoatBall, onFloatSessionExit: onFloatMenuItemClicked");
      AppMethodBeat.o(251371);
      return;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localObject == null)
    {
      Log.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, curSession == null");
      AppMethodBeat.o(251371);
      return;
    }
    if (paramBoolean)
    {
      String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(((dhx)localObject).sessionId);
      if ((str == null) || (!str.equals("145")))
      {
        Log.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, sid: %s, %s", new Object[] { str, ((dhx)localObject).sessionId });
        AppMethodBeat.o(251371);
        return;
      }
      int k = b.dfF();
      if ((k == 3) || (k == 4))
      {
        Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, state, read %d", new Object[] { Integer.valueOf(b.dfH()) });
        if (b.dfH() == 8) {
          a((dhx)localObject, true, i, j, paramLong);
        }
      }
      AppMethodBeat.o(251371);
      return;
    }
    a((dhx)localObject, false, i, j, paramLong);
    AppMethodBeat.o(251371);
  }
  
  static final class a
    implements d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184388);
      if ("com/tencent/mm/plugin/ball/view/FloatMenuView".equals(paramString1))
      {
        long l;
        if (("show".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(208, Long.valueOf(l));
          AppMethodBeat.o(184388);
          return;
        }
        if (("hide".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(211, Long.valueOf(l));
          AppMethodBeat.o(184388);
        }
      }
      else if ("com/tencent/mm/plugin/ball/view/FloatBallView".equals(paramString1))
      {
        if (("onAttachedToWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          paramString1 = new blr();
          paramString1.type = 5;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(210, paramString1);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onDetachedFromWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(212, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184388);
          return;
        }
        if (("show".equals(paramString2)) && ("(ZLandroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          paramString1 = new blr();
          paramString1.type = 3;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(210, paramString1);
          AppMethodBeat.o(184388);
        }
      }
      else
      {
        if (("onFloatMenuBackgroundClicked".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().Kz(213);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuBackPressed".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().Kz(214);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemClicked".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().Kz(215);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemRemoved".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().Kz(216);
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