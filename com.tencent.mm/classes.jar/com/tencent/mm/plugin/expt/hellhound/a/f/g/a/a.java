package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Map<String, List<Pair<String, String>>> sIU;
  public final com.tencent.mm.hellhoundlib.a.c sIV;
  
  public a()
  {
    AppMethodBeat.i(122268);
    this.sIU = new HashMap();
    this.sIV = new a((byte)0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("show", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.sIU.put("com/tencent/mm/plugin/ball/view/FloatMenuView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onAttachedToWindow", "()V"));
    localArrayList.add(Pair.create("onDetachedFromWindow", "()V"));
    localArrayList.add(Pair.create("show", "(ZLandroid/animation/AnimatorListenerAdapter;)V"));
    localArrayList.add(Pair.create("hide", "(Landroid/animation/AnimatorListenerAdapter;)V"));
    this.sIU.put("com/tencent/mm/plugin/ball/view/FloatBallView", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onFloatMenuBackgroundClicked", "()V"));
    localArrayList.add(Pair.create("onFloatMenuBackPressed", "()V"));
    localArrayList.add(Pair.create("onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V"));
    localArrayList.add(Pair.create("onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V"));
    this.sIU.put("com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", localArrayList);
    AppMethodBeat.o(122268);
  }
  
  public static void Hp(int paramInt)
  {
    AppMethodBeat.i(220597);
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSession, %d", new Object[] { Integer.valueOf(paramInt) });
    b.fN(-1, paramInt);
    b.Hq(paramInt);
    AppMethodBeat.o(220597);
  }
  
  private static void a(cyl paramcyl, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122271);
    if (paramcyl == null)
    {
      Log.e("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, 不是合法session !!!");
      AppMethodBeat.o(122271);
      return;
    }
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, curSession: %s, %d, %d", new Object[] { paramcyl.sessionId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(paramcyl, paramLong);
    AppMethodBeat.o(122271);
  }
  
  private static void a(cyl paramcyl, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184389);
    a(paramcyl, paramLong, paramInt1, paramInt2);
    paramcyl = l.cQD();
    if (paramcyl == null)
    {
      AppMethodBeat.o(184389);
      return;
    }
    if (paramcyl.MWw)
    {
      b(paramcyl.MWs, paramLong);
      AppMethodBeat.o(184389);
      return;
    }
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "_onFloatSessionExit, lastValidateSession[FALSE], finish=%b, floatClickEvent=%s, floatEventType=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 1))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().w(paramcyl.MWt.dMl, paramcyl.MWt.aHK, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, paramcyl.MWt.dMl, paramcyl.MWt.aHK, paramLong);
    }
    AppMethodBeat.o(184389);
  }
  
  private static void b(cyl paramcyl, long paramLong)
  {
    AppMethodBeat.i(122270);
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId);
    if (str == null)
    {
      AppMethodBeat.o(122270);
      return;
    }
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(paramcyl, str + "_" + paramLong, paramLong);
    paramcyl = com.tencent.mm.plugin.expt.hellhound.core.b.aoF(paramcyl.sessionId);
    if (paramcyl != null)
    {
      Log.i("HABBYGE-MALI.FloatBallSessionHandler", "restoreLastSesssion, curPage: %s", new Object[] { paramcyl.dRM });
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
    AppMethodBeat.o(122270);
  }
  
  public static void g(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(220596);
    b.mk(false);
    Object localObject = b.cQN();
    if (localObject == null)
    {
      AppMethodBeat.o(220596);
      return;
    }
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, finish: %b, %d, %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 2) && (j != 3) && (j != 4))
    {
      Log.w("HABBYGE-MALI.FloatBallSessionHandler", "FoatBall, onFloatSessionExit: onFloatMenuItemClicked");
      AppMethodBeat.o(220596);
      return;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localObject == null)
    {
      Log.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, curSession == null");
      AppMethodBeat.o(220596);
      return;
    }
    if (paramBoolean)
    {
      String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(((cyl)localObject).sessionId);
      if ((str == null) || (!str.equals("145")))
      {
        Log.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, sid: %s, %s", new Object[] { str, ((cyl)localObject).sessionId });
        AppMethodBeat.o(220596);
        return;
      }
      int k = b.getMethod();
      if ((k == 3) || (k == 4))
      {
        Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, state, read %d", new Object[] { Integer.valueOf(b.cQM()) });
        if (b.cQM() == 8) {
          a((cyl)localObject, true, i, j, paramLong);
        }
      }
      AppMethodBeat.o(220596);
      return;
    }
    a((cyl)localObject, false, i, j, paramLong);
    AppMethodBeat.o(220596);
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
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(208, Long.valueOf(l));
          AppMethodBeat.o(184388);
          return;
        }
        if (("hide".equals(paramString2)) && ("(Landroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(211, Long.valueOf(l));
          AppMethodBeat.o(184388);
        }
      }
      else if ("com/tencent/mm/plugin/ball/view/FloatBallView".equals(paramString1))
      {
        if (("onAttachedToWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          paramString1 = new ben();
          paramString1.type = 5;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(210, paramString1);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onDetachedFromWindow".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(212, Long.valueOf(System.currentTimeMillis()));
          AppMethodBeat.o(184388);
          return;
        }
        if (("show".equals(paramString2)) && ("(ZLandroid/animation/AnimatorListenerAdapter;)V".equals(paramString3)))
        {
          paramString1 = new ben();
          paramString1.type = 3;
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(210, paramString1);
          AppMethodBeat.o(184388);
        }
      }
      else
      {
        if (("onFloatMenuBackgroundClicked".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(213);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuBackPressed".equals(paramString2)) && ("()V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(214);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemClicked".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V".equals(paramString3)))
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(215);
          AppMethodBeat.o(184388);
          return;
        }
        if (("onFloatMenuItemRemoved".equals(paramString2)) && ("(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V".equals(paramString3))) {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(216);
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