package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.collect.model.f.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.ag;

final class CollectMainUI$7
  implements f.a
{
  CollectMainUI$7(CollectMainUI paramCollectMainUI) {}
  
  public final void N(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(257063);
    Log.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    CollectMainUI.w(this.uaM).setVisibility(0);
    this.uaM.tZT = paramString1;
    CollectMainUI.a(this.uaM, paramInt);
    this.uaM.mTrueName = paramString2;
    paramString1 = CollectMainUI.cPd();
    paramString2 = CollectMainUI.cPe();
    CollectMainUI.a(this.uaM, paramString1);
    this.uaM.dd(paramString2);
    if (CollectMainUI.x(this.uaM) == 1)
    {
      paramString1 = this.uaM;
      h.aHH();
      CollectMainUI.b(paramString1, ((Integer)h.aHG().aHp().get(ar.a.VsF, Integer.valueOf(-1))).intValue());
      paramString1 = this.uaM;
      h.aHH();
      CollectMainUI.a(paramString1, (String)h.aHG().aHp().get(ar.a.VsG, ""));
    }
    AppMethodBeat.o(257063);
  }
  
  public final void a(boolean paramBoolean, vx paramvx)
  {
    AppMethodBeat.i(257064);
    Object localObject;
    if (paramvx == null)
    {
      localObject = "null";
      Log.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", new Object[] { Boolean.valueOf(paramBoolean), localObject });
      if (!paramBoolean) {
        break label499;
      }
      if ((paramvx == null) || (paramvx.fwx != 416)) {
        break label189;
      }
      if (paramvx.Sih != null) {
        break label184;
      }
    }
    label184:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.d("MicroMsg.CollectMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      CollectMainUI.w(this.uaM).setVisibility(4);
      CollectMainUI.a(this.uaM, true);
      localObject = new Bundle();
      ((Bundle)localObject).putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
      ((Bundle)localObject).putString("realname_verify_process_jump_plugin", "collect");
      CollectMainUI localCollectMainUI = this.uaM;
      int i = paramvx.fwx;
      paramvx = paramvx.Sih;
      new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(271843);
          Log.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
          AppMethodBeat.o(271843);
        }
      };
      a.a(localCollectMainUI, i, paramvx, (Bundle)localObject, 1010);
      AppMethodBeat.o(257064);
      return;
      localObject = Integer.valueOf(paramvx.fwx);
      break;
    }
    label189:
    this.uaM.cOR();
    CollectMainUI.w(this.uaM).setVisibility(0);
    CollectMainUI.a(this.uaM, false);
    this.uaM.tZT = paramvx.url;
    CollectMainUI.a(this.uaM, ag.azH(paramvx.ShT));
    this.uaM.mTrueName = paramvx.OMa;
    CollectMainUI.b(this.uaM, paramvx.ImU);
    CollectMainUI.b(this.uaM, paramvx.ImV);
    CollectMainUI.a(this.uaM, paramvx.ImW);
    CollectMainUI.c(this.uaM, paramvx.Sie);
    CollectMainUI.d(this.uaM, paramvx.mKL);
    CollectMainUI.e(this.uaM, paramvx.mKM);
    CollectMainUI.a(this.uaM, paramvx.Sib);
    this.uaM.dd(paramvx.Sia);
    CollectMainUI.c(this.uaM, paramvx.Sif);
    CollectMainUI.a(this.uaM, paramvx.Sig);
    Log.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.y(this.uaM)) });
    CollectMainUI.c(this.uaM, paramvx.Sil);
    CollectMainUI.d(this.uaM, paramvx.Sim);
    CollectMainUI.e(this.uaM, paramvx.Sin);
    CollectMainUI.a(this.uaM, paramvx.Sio);
    h.aHH();
    h.aHG().aHp().set(ar.a.VsF, Integer.valueOf(CollectMainUI.z(this.uaM)));
    h.aHH();
    h.aHG().aHp().set(ar.a.VsG, CollectMainUI.a(this.uaM));
    this.uaM.refreshView();
    label499:
    AppMethodBeat.o(257064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.7
 * JD-Core Version:    0.7.0.1
 */