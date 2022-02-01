package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.c;

final class b
{
  private final com.tencent.mm.plugin.expt.hellhound.core.d qRH;
  final i qRI;
  private final boolean qRt;
  
  public b(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(121989);
    this.qRI = new i()
    {
      public final void onEnter()
      {
        AppMethodBeat.i(210340);
        b.a(b.this, 1, System.currentTimeMillis());
        AppMethodBeat.o(210340);
      }
      
      public final void onExit()
      {
        AppMethodBeat.i(210341);
        b.a(b.this, 4, System.currentTimeMillis());
        AppMethodBeat.o(210341);
      }
      
      public final void onPause()
      {
        AppMethodBeat.i(210343);
        b.a(b.this, 3, System.currentTimeMillis());
        AppMethodBeat.o(210343);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(210342);
        b.a(b.this, 2, System.currentTimeMillis());
        AppMethodBeat.o(210342);
      }
    };
    this.qRH = paramd;
    this.qRt = com.tencent.mm.plugin.expt.hellhound.a.cny();
    AppMethodBeat.o(121989);
  }
  
  private static c<FragmentActivity, Fragment> com()
  {
    AppMethodBeat.i(210344);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    Object localObject = e.cnW();
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((bj)localObject).Fti.activityName);
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, topActivityName: %s", new Object[] { localObject });
      if ("ChattingUI".equals(localObject))
      {
        ad.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, ChattingUI");
        AppMethodBeat.o(210344);
        return null;
      }
    }
    FragmentActivity localFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.b.cnF();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(210344);
      return null;
    }
    Fragment localFragment1 = h.ab(localFragmentActivity);
    if (localFragment1 == null)
    {
      ad.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, curFragment NULL");
      AppMethodBeat.o(210344);
      return null;
    }
    String str = localFragment1.getClass().getCanonicalName();
    Fragment localFragment2 = h.c(localFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.qQL);
    if (localFragment2 == null) {}
    boolean bool1;
    for (localObject = null;; localObject = localFragment2.getClass().getCanonicalName())
    {
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, fragment: %s, %s", new Object[] { str, localObject });
      bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.qQL.equals(str);
      boolean bool2 = com.tencent.mm.plugin.expt.hellhound.core.b.qQL.equals(localObject);
      if ((bool1) || (bool2)) {
        break;
      }
      ad.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, NOT ChattingUIFragment");
      AppMethodBeat.o(210344);
      return null;
    }
    if (bool1) {}
    for (localObject = localFragment1;; localObject = localFragment2)
    {
      localObject = com.tencent.mm.vending.j.a.N(localFragmentActivity, localObject);
      AppMethodBeat.o(210344);
      return localObject;
    }
  }
  
  public final void T(int paramInt, long paramLong)
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
        if (this.qRH != null)
        {
          ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter");
          localObject2 = com();
          if (localObject2 != null)
          {
            localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
            localObject3 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.qQH);
            locald = this.qRH;
            str = com.tencent.mm.plugin.expt.hellhound.core.b.qQH;
            if (localObject3 != null) {
              break label159;
            }
          }
        }
        for (paramInt = 0;; paramInt = ((Fragment)localObject3).hashCode())
        {
          locald.a((FragmentActivity)localObject1, str, paramInt, paramLong, false);
          localObject2 = (Fragment)((c)localObject2).get(1);
          this.qRH.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.qQL, ((Fragment)localObject2).hashCode(), paramLong, false);
          AppMethodBeat.o(184316);
          return;
        }
        ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentResume");
        localObject2 = com();
        if (localObject2 != null)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          localObject2 = (Fragment)((c)localObject2).get(1);
          if (localObject2 != null)
          {
            localObject3 = localObject2.getClass().getCanonicalName();
            paramInt = ((Fragment)localObject2).hashCode();
            this.qRH.a((FragmentActivity)localObject1, (Fragment)localObject2, (String)localObject3, paramInt, paramLong, false);
          }
        }
        AppMethodBeat.o(184316);
        return;
        ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentPause");
        localObject2 = com();
        if (localObject2 != null)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          localObject2 = (Fragment)((c)localObject2).get(1);
          if (localObject2 != null) {
            this.qRH.a((FragmentActivity)localObject1, localObject2.getClass().getCanonicalName(), ((Fragment)localObject2).hashCode(), paramLong, false);
          }
        }
        AppMethodBeat.o(184316);
        return;
      } while (this.qRH == null);
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentExit");
      localObject1 = com();
    } while (localObject1 == null);
    Object localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject1).get(0);
    this.qRH.a((FragmentActivity)localObject1, paramLong);
    Object localObject2 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.qQH);
    if (localObject2 == null) {}
    for (paramInt = 0;; paramInt = ((Fragment)localObject2).hashCode())
    {
      this.qRH.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.qQH, paramInt, paramLong, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.b
 * JD-Core Version:    0.7.0.1
 */