package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.z;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class FinderFriendBlackListUI$k
  implements n.e
{
  FinderFriendBlackListUI$k(FinderFriendBlackListUI paramFinderFriendBlackListUI, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(203151);
    p.g(paramMenuItem, "menuItem");
    if (paramMenuItem.getItemId() == this.snd.smU)
    {
      Object localObject1 = this.snd;
      paramMenuItem = this.snh;
      p.h(paramMenuItem, "deleteName");
      if (!bu.isNullOrNil(paramMenuItem))
      {
        Object localObject2 = g.ajO().ajq();
        p.g(localObject2, "MMKernel.process().current()");
        if (((com.tencent.mm.kernel.b.h)localObject2).akL())
        {
          localObject2 = g.ajj();
          p.g(localObject2, "MMKernel.getNetSceneQueue()");
          paramInt = ((q)localObject2).aFd();
          if ((paramInt == 4) || (paramInt == 6)) {
            paramInt = 1;
          }
        }
        while (paramInt == 0)
        {
          t.makeText((Context)localObject1, 2131765430, 0).show();
          AppMethodBeat.o(203151);
          return;
          paramInt = 0;
          continue;
          if (az.isConnected(ak.getContext())) {}
          for (paramInt = 6;; paramInt = 0)
          {
            if (paramInt != 6) {
              break label163;
            }
            paramInt = 1;
            break;
          }
          label163:
          paramInt = 0;
        }
        localObject2 = (Context)localObject1;
        ((FinderFriendBlackListUI)localObject1).getString(2131755906);
        ((FinderFriendBlackListUI)localObject1).tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, ((FinderFriendBlackListUI)localObject1).getString(2131765434), true, (DialogInterface.OnCancelListener)FinderFriendBlackListUI.d.sne);
        localObject1 = new LinkedList();
        ae.d(FinderFriendBlackListUI.TAG, "deleted user:".concat(String.valueOf(paramMenuItem)));
        localObject2 = new cak();
        ((cak)localObject2).nIJ = paramMenuItem;
        ((cak)localObject2).Hoh = com.tencent.mm.plugin.i.a.d.tqE;
        ((cak)localObject2).Hoi = 2;
        ((LinkedList)localObject1).add(localObject2);
        p.h(localObject1, "opList");
        paramMenuItem = new z((LinkedList)localObject1);
        g.ajj().b((n)paramMenuItem);
      }
    }
    AppMethodBeat.o(203151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI.k
 * JD-Core Version:    0.7.0.1
 */