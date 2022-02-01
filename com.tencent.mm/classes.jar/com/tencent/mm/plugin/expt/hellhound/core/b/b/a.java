package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  boolean pEG;
  private com.tencent.mm.plugin.expt.hellhound.core.d pEP;
  final com.tencent.mm.sdk.b.c pEQ;
  
  public a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(121989);
    this.pEQ = new com.tencent.mm.sdk.b.c() {};
    this.pEP = paramd;
    this.pEG = com.tencent.mm.plugin.expt.hellhound.a.cbs();
    AppMethodBeat.o(121989);
  }
  
  private static com.tencent.mm.vending.j.c<FragmentActivity, Fragment> cbU()
  {
    AppMethodBeat.i(121991);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    Object localObject = e.cbL();
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(((bh)localObject).CvH.activityName);
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter, topActivityName: %s", new Object[] { localObject });
      if ("ChattingUI".equals(localObject))
      {
        ad.e("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter, ChattingUI");
        AppMethodBeat.o(121991);
        return null;
      }
    }
    FragmentActivity localFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.b.cby();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(121991);
      return null;
    }
    Fragment localFragment1 = g.aa(localFragmentActivity);
    if (localFragment1 == null)
    {
      ad.e("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter, curFragment NULL");
      AppMethodBeat.o(121991);
      return null;
    }
    String str = localFragment1.getClass().getCanonicalName();
    Fragment localFragment2 = g.c(localFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.pDY);
    if (localFragment2 != null) {}
    for (localObject = localFragment2.getClass().getCanonicalName();; localObject = null)
    {
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter, fragment: %s, %s", new Object[] { str, localObject });
      boolean bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.pDY.equals(str);
      boolean bool2 = com.tencent.mm.plugin.expt.hellhound.core.b.pDY.equals(localObject);
      if ((!bool1) && (!bool2))
      {
        ad.e("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter, NOT ChattingUIFragment");
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
  
  public final void S(int paramInt, long paramLong)
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
      if (this.pEP != null)
      {
        ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter");
        Object localObject2 = cbU();
        if (localObject2 != null)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject2).get(0);
          this.pEP.a((FragmentActivity)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.pDU, paramLong, false);
          localObject2 = (Fragment)((com.tencent.mm.vending.j.c)localObject2).get(1);
          this.pEP.a((FragmentActivity)localObject1, (Fragment)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.pDY, paramLong, false);
          ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentEnter, SUCCESS");
        }
      }
      AppMethodBeat.o(184316);
      return;
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentResume");
      this.pEP.a(null, null, null, paramLong, false);
      AppMethodBeat.o(184316);
      return;
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentPause");
      this.pEP.a(null, null, paramLong, false);
      AppMethodBeat.o(184316);
      return;
      if (this.pEP != null)
      {
        ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentExit");
        localObject1 = cbU();
        if (localObject1 != null)
        {
          localObject1 = (FragmentActivity)((com.tencent.mm.vending.j.b)localObject1).get(0);
          this.pEP.ph(paramLong);
          this.pEP.a((FragmentActivity)localObject1, null, com.tencent.mm.plugin.expt.hellhound.core.b.pDU, paramLong, false);
          ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, onChatUIFragmentExit, SUCCESS");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a
 * JD-Core Version:    0.7.0.1
 */