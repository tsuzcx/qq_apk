package com.tencent.mm.plugin.fingerprint.b;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.faceid.auth.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class r
  implements i
{
  public final void a(MMActivity paramMMActivity, com.tencent.mm.plugin.fingerprint.faceid.auth.a parama, Bundle paramBundle)
  {
    parama = new b(paramMMActivity, parama, paramBundle);
    parama.setCancelable(false);
    paramMMActivity.getLifecycle().addObserver(parama);
    parama.show();
  }
  
  public final boolean f(MMActivity paramMMActivity)
  {
    if (((Boolean)g.DP().Dz().get(ac.a.upE, Boolean.FALSE)).booleanValue())
    {
      y.i("MicroMsg.WalletSoterService", "has show the finger print auth guide!");
      return false;
    }
    Object localObject1 = com.tencent.mm.wallet_core.a.aj(paramMMActivity);
    Bundle localBundle = new Bundle();
    if (localObject1 != null) {
      localBundle = ((com.tencent.mm.wallet_core.c)localObject1).kke;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(localBundle.getString("key_pwd1")))
      {
        y.i("MicroMsg.WalletSoterService", "pwd is empty, not show the finger print auth guide!");
        return false;
      }
      Object localObject2 = (k)g.r(k.class);
      if (com.tencent.mm.plugin.wallet.b.a.bUE()) {
        if (localObject1 != null) {
          ((com.tencent.mm.wallet_core.c)localObject1).a(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", localBundle);
        }
      }
      while ((!com.tencent.mm.plugin.wallet.b.a.bUF()) || (!((k)localObject2).aST()) || (((k)localObject2).aSz())) {
        return true;
      }
      localObject1 = com.tencent.mm.model.c.c.IX().fJ("100428");
      boolean bool;
      if (!((com.tencent.mm.storage.c)localObject1).isValid())
      {
        y.i("MicroMsg.WalletSoterService", "invalid abtest item");
        bool = false;
      }
      for (;;)
      {
        y.i("MicroMsg.WalletSoterService", "abtest open faceid: %s", new Object[] { Boolean.valueOf(bool) });
        localObject1 = LayoutInflater.from(paramMMActivity).inflate(a.g.fingerprint_guide_dialog, null);
        localObject2 = (TextView)((View)localObject1).findViewById(a.f.fgd_desc_tv);
        CheckBox localCheckBox = (CheckBox)((View)localObject1).findViewById(a.f.fingerprint_not_show_any_more_cb);
        ((TextView)localObject2).setText(paramMMActivity.getString(a.i.faceid_guide_open_text));
        h.a(paramMMActivity, false, null, (View)localObject1, paramMMActivity.getString(a.i.btn_guide_open_faceid), paramMMActivity.getString(a.i.app_cancel), new r.1(this, paramMMActivity, localBundle), new r.2(this, localCheckBox));
        break;
        if (bk.getInt((String)((com.tencent.mm.storage.c)localObject1).ctr().get("openFaceIdPay"), 0) == 1) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.r
 * JD-Core Version:    0.7.0.1
 */