package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.model.f.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class CollectMainUI$11
  implements f.a
{
  CollectMainUI$11(CollectMainUI paramCollectMainUI) {}
  
  public final void a(boolean paramBoolean, pw parampw)
  {
    AppMethodBeat.i(142003);
    Object localObject;
    if (parampw == null)
    {
      localObject = "null";
      ab.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", new Object[] { Boolean.valueOf(paramBoolean), localObject });
      if (!paramBoolean) {
        break label451;
      }
      if ((parampw == null) || (parampw.cnK != 416)) {
        break label189;
      }
      if (parampw.wIk != null) {
        break label184;
      }
    }
    label184:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ab.d("MicroMsg.CollectMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      CollectMainUI.u(this.kSz).setVisibility(4);
      CollectMainUI.a(this.kSz, true);
      localObject = new Bundle();
      ((Bundle)localObject).putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
      ((Bundle)localObject).putString("realname_verify_process_jump_plugin", "collect");
      CollectMainUI localCollectMainUI = this.kSz;
      int i = parampw.cnK;
      parampw = parampw.wIk;
      new CollectMainUI.11.1(this);
      a.a(localCollectMainUI, i, parampw, (Bundle)localObject, 1010);
      AppMethodBeat.o(142003);
      return;
      localObject = Integer.valueOf(parampw.cnK);
      break;
    }
    label189:
    CollectMainUI.w(this.kSz);
    CollectMainUI.u(this.kSz).setVisibility(0);
    CollectMainUI.a(this.kSz, false);
    this.kSz.kRP = parampw.url;
    CollectMainUI.a(this.kSz, c.IK(parampw.wIa));
    this.kSz.mTrueName = parampw.ueu;
    CollectMainUI.b(this.kSz, parampw.qkj);
    CollectMainUI.b(this.kSz, parampw.qkk);
    CollectMainUI.a(this.kSz, parampw.qkl);
    CollectMainUI.c(this.kSz, parampw.wIh);
    CollectMainUI.d(this.kSz, parampw.kNG);
    CollectMainUI.e(this.kSz, parampw.kNH);
    CollectMainUI.a(this.kSz, parampw.wIe);
    this.kSz.bn(parampw.wId);
    CollectMainUI.c(this.kSz, parampw.wIi);
    CollectMainUI.a(this.kSz, parampw.wIj);
    ab.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.b(this.kSz)) });
    g.RM();
    g.RL().Ru().set(ac.a.yIw, Integer.valueOf(CollectMainUI.x(this.kSz)));
    g.RM();
    g.RL().Ru().set(ac.a.yIx, CollectMainUI.a(this.kSz));
    this.kSz.refreshView();
    label451:
    AppMethodBeat.o(142003);
  }
  
  public final void y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(142002);
    ab.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    CollectMainUI.u(this.kSz).setVisibility(0);
    this.kSz.kRP = paramString1;
    CollectMainUI.a(this.kSz, paramInt);
    this.kSz.mTrueName = paramString2;
    paramString1 = CollectMainUI.biB();
    paramString2 = CollectMainUI.biC();
    CollectMainUI.a(this.kSz, paramString1);
    this.kSz.bn(paramString2);
    if (CollectMainUI.v(this.kSz) == 1)
    {
      paramString1 = this.kSz;
      g.RM();
      CollectMainUI.b(paramString1, ((Integer)g.RL().Ru().get(ac.a.yIw, Integer.valueOf(-1))).intValue());
      paramString1 = this.kSz;
      g.RM();
      CollectMainUI.a(paramString1, (String)g.RL().Ru().get(ac.a.yIx, ""));
    }
    AppMethodBeat.o(142002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.11
 * JD-Core Version:    0.7.0.1
 */