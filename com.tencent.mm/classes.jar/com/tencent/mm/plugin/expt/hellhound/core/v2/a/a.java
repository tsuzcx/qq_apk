package com.tencent.mm.plugin.expt.hellhound.core.v2.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  com.tencent.mm.plugin.expt.hellhound.core.d mai;
  final com.tencent.mm.sdk.b.c maj;
  
  public a(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(152290);
    this.maj = new a.1(this);
    this.mai = paramd;
    AppMethodBeat.o(152290);
  }
  
  static com.tencent.mm.vending.j.c<FragmentActivity, Fragment> brQ()
  {
    AppMethodBeat.i(152292);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    Object localObject = e.brH();
    if (localObject != null)
    {
      localObject = b.Mb(((be)localObject).wnr.activityName);
      ab.i("ChatUIFragmentProxy", "habbyge-mali, onChatUIFragmentEnter, topActivityName: ".concat(String.valueOf(localObject)));
      if ("ChattingUI".equals(localObject))
      {
        ab.e("ChatUIFragmentProxy", "habbyge-mali, ChatUIFragmentProxy, onChatUIFragmentEnter, ChattingUI");
        AppMethodBeat.o(152292);
        return null;
      }
    }
    FragmentActivity localFragmentActivity = b.bru();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(152292);
      return null;
    }
    Fragment localFragment1 = f.b(localFragmentActivity);
    if (localFragment1 == null)
    {
      ab.e("ChatUIFragmentProxy", "habbyge-mali, ChatUIFragmentProxy, onChatUIFragmentEnter, curFragment NULL");
      AppMethodBeat.o(152292);
      return null;
    }
    String str = localFragment1.getClass().getName();
    Fragment localFragment2 = f.e(localFragmentActivity, "com.tencent.mm.ui.chatting.ChattingUIFragment");
    if (localFragment2 != null) {}
    for (localObject = localFragment2.getClass().getName();; localObject = null)
    {
      ab.i("ChatUIFragmentProxy", "habbyge-mali, onChatUIFragmentEnter, fragment = " + str + " | " + (String)localObject);
      boolean bool1 = "com.tencent.mm.ui.chatting.ChattingUIFragment".equals(str);
      boolean bool2 = "com.tencent.mm.ui.chatting.ChattingUIFragment".equals(localObject);
      if ((!bool1) && (!bool2))
      {
        ab.e("ChatUIFragmentProxy", "habbyge-mali, ChatUIFragmentProxy, onChatUIFragmentEnter, NOT ChattingUIFragment");
        AppMethodBeat.o(152292);
        return null;
      }
      if (bool1) {}
      for (localObject = localFragment1;; localObject = localFragment2)
      {
        localObject = com.tencent.mm.vending.j.a.C(localFragmentActivity, localObject);
        AppMethodBeat.o(152292);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.a.a
 * JD-Core Version:    0.7.0.1
 */