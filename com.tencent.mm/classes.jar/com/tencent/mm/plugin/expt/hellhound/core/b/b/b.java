package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;

final class b
{
  private final boolean wfC;
  private final com.tencent.mm.plugin.expt.hellhound.core.d wfQ;
  final i wfR;
  
  public b(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(121989);
    this.wfR = new i()
    {
      public final void onEnter()
      {
        AppMethodBeat.i(255511);
        b.a(b.this, 1, System.currentTimeMillis());
        AppMethodBeat.o(255511);
      }
      
      public final void onExit()
      {
        AppMethodBeat.i(255513);
        b.a(b.this, 4, System.currentTimeMillis());
        AppMethodBeat.o(255513);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(255517);
        b.a(b.this, 3, System.currentTimeMillis());
        AppMethodBeat.o(255517);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(255516);
        b.a(b.this, 2, System.currentTimeMillis());
        AppMethodBeat.o(255516);
      }
    };
    this.wfQ = paramd;
    this.wfC = com.tencent.mm.plugin.expt.hellhound.a.dcl();
    AppMethodBeat.o(121989);
  }
  
  private static c<FragmentActivity, Fragment> dcZ()
  {
    AppMethodBeat.i(252358);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    Object localObject = e.dcJ();
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((bl)localObject).RGy.activityName);
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, topActivityName: %s", new Object[] { localObject });
      if ("ChattingUI".equals(localObject))
      {
        Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, ChattingUI");
        AppMethodBeat.o(252358);
        return null;
      }
    }
    FragmentActivity localFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.b.dcs();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(252358);
      return null;
    }
    Fragment localFragment1 = h.ab(localFragmentActivity);
    if (localFragment1 == null)
    {
      Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, curFragment NULL");
      AppMethodBeat.o(252358);
      return null;
    }
    String str = localFragment1.getClass().getCanonicalName();
    Fragment localFragment2 = h.c(localFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.weW);
    if (localFragment2 == null) {}
    boolean bool1;
    for (localObject = null;; localObject = localFragment2.getClass().getCanonicalName())
    {
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, fragment: %s, %s", new Object[] { str, localObject });
      bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.weW.equals(str);
      boolean bool2 = com.tencent.mm.plugin.expt.hellhound.core.b.weW.equals(localObject);
      if ((bool1) || (bool2)) {
        break;
      }
      Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, NOT ChattingUIFragment");
      AppMethodBeat.o(252358);
      return null;
    }
    if (bool1) {}
    for (localObject = localFragment1;; localObject = localFragment2)
    {
      localObject = com.tencent.mm.vending.j.a.J(localFragmentActivity, localObject);
      AppMethodBeat.o(252358);
      return localObject;
    }
  }
  
  public final void W(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184316);
    switch (paramInt)
    {
    }
    label163:
    do
    {
      do
      {
        AppMethodBeat.o(184316);
        return;
        Object localObject3;
        com.tencent.mm.plugin.expt.hellhound.core.d locald;
        String str;
        if (this.wfQ != null)
        {
          Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter");
          com.tencent.mm.plugin.expt.hellhound.a.ni(true);
          localObject2 = dcZ();
          if (localObject2 != null)
          {
            localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
            localObject3 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.weS);
            locald = this.wfQ;
            str = com.tencent.mm.plugin.expt.hellhound.core.b.weS;
            if (localObject3 != null) {
              break label163;
            }
          }
        }
        for (paramInt = 0;; paramInt = ((Fragment)localObject3).hashCode())
        {
          locald.a((FragmentActivity)localObject1, str, paramInt, paramLong, false);
          localObject2 = (Fragment)((c)localObject2).get(1);
          this.wfQ.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.weW, ((Fragment)localObject2).hashCode(), paramLong, false);
          AppMethodBeat.o(184316);
          return;
        }
        Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentResume");
        localObject2 = dcZ();
        if (localObject2 != null) {
          if (com.tencent.mm.plugin.expt.hellhound.a.dcb())
          {
            if (!com.tencent.mm.plugin.expt.hellhound.a.dcd()) {
              break label275;
            }
            com.tencent.mm.plugin.expt.hellhound.a.nj(false);
            com.tencent.mm.plugin.expt.hellhound.a.dce();
          }
        }
        for (;;)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          localObject2 = (Fragment)((c)localObject2).get(1);
          if (localObject2 != null)
          {
            localObject3 = localObject2.getClass().getCanonicalName();
            paramInt = ((Fragment)localObject2).hashCode();
            this.wfQ.a((FragmentActivity)localObject1, (Fragment)localObject2, (String)localObject3, paramInt, paramLong, false);
          }
          AppMethodBeat.o(184316);
          return;
          com.tencent.mm.plugin.expt.hellhound.a.dcc();
        }
        Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentPause");
        localObject2 = dcZ();
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.expt.hellhound.a.ni(com.tencent.mm.plugin.expt.hellhound.a.dcb());
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          localObject2 = (Fragment)((c)localObject2).get(1);
          if (localObject2 != null) {
            this.wfQ.a((FragmentActivity)localObject1, localObject2.getClass().getCanonicalName(), ((Fragment)localObject2).hashCode(), paramLong, false);
          }
        }
        AppMethodBeat.o(184316);
        return;
      } while (this.wfQ == null);
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentExit");
      com.tencent.mm.plugin.expt.hellhound.a.ni(false);
      com.tencent.mm.plugin.expt.hellhound.a.nj(false);
      com.tencent.mm.plugin.expt.hellhound.a.dce();
      localObject1 = dcZ();
    } while (localObject1 == null);
    label275:
    Object localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject1).get(0);
    this.wfQ.a((FragmentActivity)localObject1, paramLong);
    Object localObject2 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.weS);
    if (localObject2 == null) {}
    for (paramInt = 0;; paramInt = ((Fragment)localObject2).hashCode())
    {
      this.wfQ.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.weS, paramInt, paramLong, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.b
 * JD-Core Version:    0.7.0.1
 */