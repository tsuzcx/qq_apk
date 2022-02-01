package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;

final class b
{
  private final boolean szI;
  private final com.tencent.mm.plugin.expt.hellhound.core.d szW;
  final i szX;
  
  public b(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(121989);
    this.szX = new i()
    {
      public final void onEnter()
      {
        AppMethodBeat.i(220430);
        b.a(b.this, 1, System.currentTimeMillis());
        AppMethodBeat.o(220430);
      }
      
      public final void onExit()
      {
        AppMethodBeat.i(220431);
        b.a(b.this, 4, System.currentTimeMillis());
        AppMethodBeat.o(220431);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(220433);
        b.a(b.this, 3, System.currentTimeMillis());
        AppMethodBeat.o(220433);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(220432);
        b.a(b.this, 2, System.currentTimeMillis());
        AppMethodBeat.o(220432);
      }
    };
    this.szW = paramd;
    this.szI = com.tencent.mm.plugin.expt.hellhound.a.cNt();
    AppMethodBeat.o(121989);
  }
  
  private static c<FragmentActivity, Fragment> cOh()
  {
    AppMethodBeat.i(220434);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    Object localObject = e.cNR();
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((bn)localObject).KFh.activityName);
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, topActivityName: %s", new Object[] { localObject });
      if ("ChattingUI".equals(localObject))
      {
        Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, ChattingUI");
        AppMethodBeat.o(220434);
        return null;
      }
    }
    FragmentActivity localFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.b.cNA();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(220434);
      return null;
    }
    Fragment localFragment1 = h.aa(localFragmentActivity);
    if (localFragment1 == null)
    {
      Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, curFragment NULL");
      AppMethodBeat.o(220434);
      return null;
    }
    String str = localFragment1.getClass().getCanonicalName();
    Fragment localFragment2 = h.c(localFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.sza);
    if (localFragment2 == null) {}
    boolean bool1;
    for (localObject = null;; localObject = localFragment2.getClass().getCanonicalName())
    {
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, fragment: %s, %s", new Object[] { str, localObject });
      bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.sza.equals(str);
      boolean bool2 = com.tencent.mm.plugin.expt.hellhound.core.b.sza.equals(localObject);
      if ((bool1) || (bool2)) {
        break;
      }
      Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, NOT ChattingUIFragment");
      AppMethodBeat.o(220434);
      return null;
    }
    if (bool1) {}
    for (localObject = localFragment1;; localObject = localFragment2)
    {
      localObject = com.tencent.mm.vending.j.a.Q(localFragmentActivity, localObject);
      AppMethodBeat.o(220434);
      return localObject;
    }
  }
  
  public final void V(int paramInt, long paramLong)
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
        if (this.szW != null)
        {
          Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter");
          com.tencent.mm.plugin.expt.hellhound.a.lW(true);
          localObject2 = cOh();
          if (localObject2 != null)
          {
            localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
            localObject3 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.syW);
            locald = this.szW;
            str = com.tencent.mm.plugin.expt.hellhound.core.b.syW;
            if (localObject3 != null) {
              break label163;
            }
          }
        }
        for (paramInt = 0;; paramInt = ((Fragment)localObject3).hashCode())
        {
          locald.a((FragmentActivity)localObject1, str, paramInt, paramLong, false);
          localObject2 = (Fragment)((c)localObject2).get(1);
          this.szW.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.sza, ((Fragment)localObject2).hashCode(), paramLong, false);
          AppMethodBeat.o(184316);
          return;
        }
        Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentResume");
        localObject2 = cOh();
        if (localObject2 != null) {
          if (com.tencent.mm.plugin.expt.hellhound.a.cNj())
          {
            if (!com.tencent.mm.plugin.expt.hellhound.a.cNl()) {
              break label275;
            }
            com.tencent.mm.plugin.expt.hellhound.a.lX(false);
            com.tencent.mm.plugin.expt.hellhound.a.cNm();
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
            this.szW.a((FragmentActivity)localObject1, (Fragment)localObject2, (String)localObject3, paramInt, paramLong, false);
          }
          AppMethodBeat.o(184316);
          return;
          com.tencent.mm.plugin.expt.hellhound.a.cNk();
        }
        Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentPause");
        localObject2 = cOh();
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.expt.hellhound.a.lW(com.tencent.mm.plugin.expt.hellhound.a.cNj());
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          localObject2 = (Fragment)((c)localObject2).get(1);
          if (localObject2 != null) {
            this.szW.a((FragmentActivity)localObject1, localObject2.getClass().getCanonicalName(), ((Fragment)localObject2).hashCode(), paramLong, false);
          }
        }
        AppMethodBeat.o(184316);
        return;
      } while (this.szW == null);
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentExit");
      com.tencent.mm.plugin.expt.hellhound.a.lW(false);
      com.tencent.mm.plugin.expt.hellhound.a.lX(false);
      com.tencent.mm.plugin.expt.hellhound.a.cNm();
      localObject1 = cOh();
    } while (localObject1 == null);
    label275:
    Object localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject1).get(0);
    this.szW.a((FragmentActivity)localObject1, paramLong);
    Object localObject2 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.syW);
    if (localObject2 == null) {}
    for (paramInt = 0;; paramInt = ((Fragment)localObject2).hashCode())
    {
      this.szW.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.syW, paramInt, paramLong, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.b
 * JD-Core Version:    0.7.0.1
 */