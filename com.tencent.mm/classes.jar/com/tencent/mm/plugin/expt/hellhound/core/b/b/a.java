package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  private com.tencent.mm.plugin.expt.hellhound.core.d qjC;
  final com.tencent.mm.sdk.b.c qjD;
  boolean qjt;
  
  public a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(121989);
    this.qjD = new com.tencent.mm.sdk.b.c() {};
    this.qjC = paramd;
    this.qjt = com.tencent.mm.plugin.expt.hellhound.a.ciB();
    AppMethodBeat.o(121989);
  }
  
  private static com.tencent.mm.vending.j.c<FragmentActivity, Fragment> cjf()
  {
    AppMethodBeat.i(121991);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    Object localObject = e.ciW();
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(((bj)localObject).DOc.activityName);
      ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter, topActivityName: %s", new Object[] { localObject });
      if ("ChattingUI".equals(localObject))
      {
        ac.e("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter, ChattingUI");
        AppMethodBeat.o(121991);
        return null;
      }
    }
    FragmentActivity localFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.b.ciH();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(121991);
      return null;
    }
    Fragment localFragment1 = g.ab(localFragmentActivity);
    if (localFragment1 == null)
    {
      ac.e("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter, curFragment NULL");
      AppMethodBeat.o(121991);
      return null;
    }
    String str = localFragment1.getClass().getCanonicalName();
    Fragment localFragment2 = g.c(localFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.qiL);
    if (localFragment2 != null) {}
    for (localObject = localFragment2.getClass().getCanonicalName();; localObject = null)
    {
      ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter, fragment: %s, %s", new Object[] { str, localObject });
      boolean bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.qiL.equals(str);
      boolean bool2 = com.tencent.mm.plugin.expt.hellhound.core.b.qiL.equals(localObject);
      if ((!bool1) && (!bool2))
      {
        ac.e("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter, NOT ChattingUIFragment");
        AppMethodBeat.o(121991);
        return null;
      }
      if (bool1) {}
      for (localObject = localFragment1;; localObject = localFragment2)
      {
        localObject = com.tencent.mm.vending.j.a.L(localFragmentActivity, localObject);
        AppMethodBeat.o(121991);
        return localObject;
      }
    }
  }
  
  public final void R(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184316);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(184316);
      return;
      Object localObject1;
      if (this.qjC != null)
      {
        ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter");
        Object localObject2 = cjf();
        if (localObject2 != null)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          this.qjC.a((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.qiH, paramLong, false);
          localObject2 = (Fragment)((com.tencent.mm.vending.j.c)localObject2).get(1);
          this.qjC.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.qiL, paramLong, false);
          ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter, SUCCESS");
        }
      }
      AppMethodBeat.o(184316);
      return;
      ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentResume");
      this.qjC.a(null, null, null, paramLong, false);
      AppMethodBeat.o(184316);
      return;
      ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentPause");
      this.qjC.a(null, null, paramLong, false);
      AppMethodBeat.o(184316);
      return;
      if (this.qjC != null)
      {
        ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentExit");
        localObject1 = cjf();
        if (localObject1 != null)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject1).get(0);
          this.qjC.sT(paramLong);
          this.qjC.a((FragmentActivity)localObject1, null, com.tencent.mm.plugin.expt.hellhound.core.b.qiH, paramLong, false);
          ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentExit, SUCCESS");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a
 * JD-Core Version:    0.7.0.1
 */