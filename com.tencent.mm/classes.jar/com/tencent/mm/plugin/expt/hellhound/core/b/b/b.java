package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.j.c;

final class b
{
  private final com.tencent.mm.plugin.expt.hellhound.core.d qZF;
  final i qZG;
  private final boolean qZr;
  
  public b(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(121989);
    this.qZG = new i()
    {
      public final void onEnter()
      {
        AppMethodBeat.i(196000);
        b.a(b.this, 1, System.currentTimeMillis());
        AppMethodBeat.o(196000);
      }
      
      public final void onExit()
      {
        AppMethodBeat.i(196001);
        b.a(b.this, 4, System.currentTimeMillis());
        AppMethodBeat.o(196001);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(196003);
        b.a(b.this, 3, System.currentTimeMillis());
        AppMethodBeat.o(196003);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(196002);
        b.a(b.this, 2, System.currentTimeMillis());
        AppMethodBeat.o(196002);
      }
    };
    this.qZF = paramd;
    this.qZr = com.tencent.mm.plugin.expt.hellhound.a.cpa();
    AppMethodBeat.o(121989);
  }
  
  private static c<FragmentActivity, Fragment> cpO()
  {
    AppMethodBeat.i(196004);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
    Object localObject = e.cpy();
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((bj)localObject).FLG.activityName);
      ae.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, topActivityName: %s", new Object[] { localObject });
      if ("ChattingUI".equals(localObject))
      {
        ae.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, ChattingUI");
        AppMethodBeat.o(196004);
        return null;
      }
    }
    FragmentActivity localFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.b.cph();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(196004);
      return null;
    }
    Fragment localFragment1 = h.ac(localFragmentActivity);
    if (localFragment1 == null)
    {
      ae.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, curFragment NULL");
      AppMethodBeat.o(196004);
      return null;
    }
    String str = localFragment1.getClass().getCanonicalName();
    Fragment localFragment2 = h.c(localFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.qYJ);
    if (localFragment2 == null) {}
    boolean bool1;
    for (localObject = null;; localObject = localFragment2.getClass().getCanonicalName())
    {
      ae.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, fragment: %s, %s", new Object[] { str, localObject });
      bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.qYJ.equals(str);
      boolean bool2 = com.tencent.mm.plugin.expt.hellhound.core.b.qYJ.equals(localObject);
      if ((bool1) || (bool2)) {
        break;
      }
      ae.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, NOT ChattingUIFragment");
      AppMethodBeat.o(196004);
      return null;
    }
    if (bool1) {}
    for (localObject = localFragment1;; localObject = localFragment2)
    {
      localObject = com.tencent.mm.vending.j.a.N(localFragmentActivity, localObject);
      AppMethodBeat.o(196004);
      return localObject;
    }
  }
  
  public final void S(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184316);
    switch (paramInt)
    {
    }
    label159:
    do
    {
      do
      {
        AppMethodBeat.o(184316);
        return;
        Object localObject3;
        com.tencent.mm.plugin.expt.hellhound.core.d locald;
        String str;
        if (this.qZF != null)
        {
          ae.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter");
          localObject2 = cpO();
          if (localObject2 != null)
          {
            localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
            localObject3 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.qYF);
            locald = this.qZF;
            str = com.tencent.mm.plugin.expt.hellhound.core.b.qYF;
            if (localObject3 != null) {
              break label159;
            }
          }
        }
        for (paramInt = 0;; paramInt = ((Fragment)localObject3).hashCode())
        {
          locald.a((FragmentActivity)localObject1, str, paramInt, paramLong, false);
          localObject2 = (Fragment)((c)localObject2).get(1);
          this.qZF.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.qYJ, ((Fragment)localObject2).hashCode(), paramLong, false);
          AppMethodBeat.o(184316);
          return;
        }
        ae.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentResume");
        localObject2 = cpO();
        if (localObject2 != null)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          localObject2 = (Fragment)((c)localObject2).get(1);
          if (localObject2 != null)
          {
            localObject3 = localObject2.getClass().getCanonicalName();
            paramInt = ((Fragment)localObject2).hashCode();
            this.qZF.a((FragmentActivity)localObject1, (Fragment)localObject2, (String)localObject3, paramInt, paramLong, false);
          }
        }
        AppMethodBeat.o(184316);
        return;
        ae.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentPause");
        localObject2 = cpO();
        if (localObject2 != null)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          localObject2 = (Fragment)((c)localObject2).get(1);
          if (localObject2 != null) {
            this.qZF.a((FragmentActivity)localObject1, localObject2.getClass().getCanonicalName(), ((Fragment)localObject2).hashCode(), paramLong, false);
          }
        }
        AppMethodBeat.o(184316);
        return;
      } while (this.qZF == null);
      ae.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentExit");
      localObject1 = cpO();
    } while (localObject1 == null);
    Object localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject1).get(0);
    this.qZF.a((FragmentActivity)localObject1, paramLong);
    Object localObject2 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.qYF);
    if (localObject2 == null) {}
    for (paramInt = 0;; paramInt = ((Fragment)localObject2).hashCode())
    {
      this.qZF.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.qYF, paramInt, paramLong, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.b
 * JD-Core Version:    0.7.0.1
 */