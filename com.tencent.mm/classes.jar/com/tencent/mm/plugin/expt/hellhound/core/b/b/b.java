package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.e.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class b
{
  final List<e.d> zBA;
  private final boolean zBD;
  private final com.tencent.mm.plugin.expt.hellhound.core.d zBR;
  final i zBS;
  
  public b(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(121989);
    this.zBS = new i()
    {
      public final void dJD()
      {
        AppMethodBeat.i(299951);
        b.a(b.this, 1, System.currentTimeMillis());
        AppMethodBeat.o(299951);
      }
      
      public final void dJE()
      {
        AppMethodBeat.i(299953);
        b.a(b.this, 4, System.currentTimeMillis());
        AppMethodBeat.o(299953);
      }
      
      public final void dJF()
      {
        AppMethodBeat.i(299959);
        b.a(b.this, 2, System.currentTimeMillis());
        AppMethodBeat.o(299959);
      }
      
      public final void dJG()
      {
        AppMethodBeat.i(299963);
        b.a(b.this, 3, System.currentTimeMillis());
        AppMethodBeat.o(299963);
      }
    };
    this.zBR = paramd;
    this.zBA = new CopyOnWriteArrayList();
    this.zBD = com.tencent.mm.plugin.expt.hellhound.a.dIP();
    AppMethodBeat.o(121989);
  }
  
  private static c<FragmentActivity, Fragment> dJC()
  {
    AppMethodBeat.i(299955);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    Object localObject = e.dJl();
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((bt)localObject).YDs.AtM);
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, topActivityName: %s", new Object[] { localObject });
      if ("ChattingUI".equals(localObject))
      {
        Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, ChattingUI");
        AppMethodBeat.o(299955);
        return null;
      }
    }
    FragmentActivity localFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.b.dIW();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(299955);
      return null;
    }
    Fragment localFragment1 = h.ak(localFragmentActivity);
    if (localFragment1 == null)
    {
      Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, curFragment NULL");
      AppMethodBeat.o(299955);
      return null;
    }
    String str = localFragment1.getClass().getCanonicalName();
    Fragment localFragment2 = h.c(localFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.zAV);
    if (localFragment2 == null) {}
    boolean bool1;
    for (localObject = null;; localObject = localFragment2.getClass().getCanonicalName())
    {
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, fragment: %s, %s", new Object[] { str, localObject });
      bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.zAV.equals(str);
      boolean bool2 = com.tencent.mm.plugin.expt.hellhound.core.b.zAV.equals(localObject);
      if ((bool1) || (bool2)) {
        break;
      }
      Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, NOT ChattingUIFragment");
      AppMethodBeat.o(299955);
      return null;
    }
    if (bool1) {}
    for (localObject = localFragment1;; localObject = localFragment2)
    {
      localObject = com.tencent.mm.vending.j.a.U(localFragmentActivity, localObject);
      AppMethodBeat.o(299955);
      return localObject;
    }
  }
  
  public final void aa(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184316);
    switch (paramInt)
    {
    }
    label314:
    do
    {
      do
      {
        AppMethodBeat.o(184316);
        return;
        Object localObject3;
        if (this.zBR != null)
        {
          Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter");
          com.tencent.mm.plugin.expt.hellhound.a.oI(true);
          localObject2 = dJC();
          if (localObject2 != null)
          {
            localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
            localObject2 = (Fragment)((c)localObject2).get(1);
            localObject3 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.zAQ);
            com.tencent.mm.plugin.expt.hellhound.core.d locald = this.zBR;
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.zAQ;
            if (localObject3 == null) {}
            for (paramInt = 0;; paramInt = ((Fragment)localObject3).hashCode())
            {
              locald.a((FragmentActivity)localObject1, str, paramInt, paramLong, false);
              localObject3 = this.zBA.iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((e.d)((Iterator)localObject3).next()).dtw();
              }
            }
            this.zBR.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.zAV, ((Fragment)localObject2).hashCode(), paramLong, false);
          }
        }
        AppMethodBeat.o(184316);
        return;
        Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentResume");
        localObject2 = dJC();
        if (localObject2 != null) {
          if (com.tencent.mm.plugin.expt.hellhound.a.dIF())
          {
            if (!com.tencent.mm.plugin.expt.hellhound.a.dIH()) {
              break label314;
            }
            com.tencent.mm.plugin.expt.hellhound.a.oJ(false);
            com.tencent.mm.plugin.expt.hellhound.a.dII();
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
            this.zBR.a((FragmentActivity)localObject1, (Fragment)localObject2, (String)localObject3, paramInt, paramLong, false);
          }
          AppMethodBeat.o(184316);
          return;
          com.tencent.mm.plugin.expt.hellhound.a.dIG();
        }
        Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentPause");
        localObject2 = dJC();
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.expt.hellhound.a.oI(com.tencent.mm.plugin.expt.hellhound.a.dIF());
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          localObject2 = (Fragment)((c)localObject2).get(1);
          if (localObject2 != null) {
            this.zBR.a((FragmentActivity)localObject1, localObject2.getClass().getCanonicalName(), ((Fragment)localObject2).hashCode(), paramLong, false);
          }
        }
        AppMethodBeat.o(184316);
        return;
      } while (this.zBR == null);
      Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentExit");
      com.tencent.mm.plugin.expt.hellhound.a.oI(false);
      com.tencent.mm.plugin.expt.hellhound.a.oJ(false);
      com.tencent.mm.plugin.expt.hellhound.a.dII();
      localObject1 = dJC();
    } while (localObject1 == null);
    Object localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject1).get(0);
    this.zBR.a((FragmentActivity)localObject1, paramLong);
    Object localObject2 = h.c((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.zAQ);
    if (localObject2 == null) {}
    for (paramInt = 0;; paramInt = ((Fragment)localObject2).hashCode())
    {
      this.zBR.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.zAQ, paramInt, paramLong, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.b
 * JD-Core Version:    0.7.0.1
 */