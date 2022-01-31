package com.tencent.mm.plugin.fingerprint.b;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;

public final class r
  implements i
{
  public final void a(MMActivity paramMMActivity, com.tencent.mm.plugin.fingerprint.faceid.auth.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(41566);
    parama = new WalletFaceIdDialog(paramMMActivity, parama, paramBundle);
    parama.setCancelable(false);
    paramMMActivity.getLifecycle().addObserver(parama);
    parama.show();
    AppMethodBeat.o(41566);
  }
  
  public final boolean g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(41567);
    if (((Boolean)g.RL().Ru().get(ac.a.yzA, Boolean.FALSE)).booleanValue())
    {
      ab.i("MicroMsg.WalletSoterService", "has show the finger print auth guide!");
      AppMethodBeat.o(41567);
      return false;
    }
    Object localObject3 = com.tencent.mm.wallet_core.a.aM(paramMMActivity);
    Object localObject1 = new Bundle();
    if (localObject3 != null) {
      localObject1 = ((c)localObject3).mEJ;
    }
    for (;;)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      Object localObject2;
      if (paramMMActivity != null)
      {
        bool1 = bool2;
        if (paramMMActivity.getIntent() != null)
        {
          bool2 = paramMMActivity.getIntent().getBooleanExtra("isFromKinda", false);
          bool1 = bool2;
          if (bool2)
          {
            localObject2 = paramMMActivity.getIntent().getStringExtra("kindaPayPwd");
            if (localObject2 != null) {
              ((Bundle)localObject1).putString("key_pwd1", (String)localObject2);
            }
            bool1 = bool2;
          }
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(((Bundle)localObject1).getString("key_pwd1")))
        {
          ab.i("MicroMsg.WalletSoterService", "pwd is empty, not show the finger print auth guide!");
          AppMethodBeat.o(41567);
          return false;
        }
        Object localObject4 = (l)g.E(l.class);
        ab.i("MicroMsg.WalletSoterService", "fingerprint: %s has fingerprint: %s, faceid: %s has faceid: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.cST()), Boolean.valueOf(((l)localObject4).bzb()), Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.cSU()), Boolean.valueOf(((l)localObject4).bzo()) });
        int i;
        if ((!((l)localObject4).byS()) && (!((l)localObject4).byV()))
        {
          if ((!com.tencent.mm.plugin.wallet.b.a.cST()) || (!((l)localObject4).bzb()) || (!com.tencent.mm.plugin.wallet.b.a.cSU()) || (!((l)localObject4).bzo())) {
            break label694;
          }
          if (!bool1) {
            break label534;
          }
          boolean bool4 = false;
          int j = 0;
          localObject2 = null;
          localObject1 = localObject2;
          i = j;
          boolean bool3 = bool4;
          bool2 = bool1;
          if (paramMMActivity != null)
          {
            localObject1 = localObject2;
            i = j;
            bool3 = bool4;
            bool2 = bool1;
            if (paramMMActivity.getIntent() != null)
            {
              bool3 = paramMMActivity.getIntent().getBooleanExtra("isFromKinda", false);
              bool2 = paramMMActivity.getIntent().getBooleanExtra("bSupportFaceAndTouch", false);
              i = paramMMActivity.getIntent().getIntExtra("selectBioType", 0);
              localObject1 = paramMMActivity.getIntent().getStringExtra("kindaPayPwd");
            }
          }
          if ((bool3) && (bool2) && (localObject1 != null)) {
            break label406;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(41567);
          return true;
          label406:
          localObject2 = new Bundle();
          if (i == 1)
          {
            ab.i("MicroMsg.WalletSoterService", "click fingerprint btn");
            ((Bundle)localObject2).putBoolean("key_show_guide", false);
            ((Bundle)localObject2).putBoolean("isFromKinda", true);
            ((Bundle)localObject2).putString("kindaPayPwd", (String)localObject1);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            d.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", (Intent)localObject1);
          }
          else if (i == 2)
          {
            ab.i("MicroMsg.WalletSoterService", "click faceid btn");
            localObject2 = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
            ((Intent)localObject2).putExtra("pwd", (String)localObject1);
            ((Intent)localObject2).putExtra("key_scene", 1);
            paramMMActivity.startActivity((Intent)localObject2);
            continue;
            label534:
            localObject2 = new com.tencent.mm.ui.base.i(paramMMActivity, 2131493881);
            ((com.tencent.mm.ui.base.i)localObject2).setContentView(2130968857);
            localObject4 = (CheckBox)((com.tencent.mm.ui.base.i)localObject2).findViewById(2131821831);
            TextView localTextView1 = (TextView)((com.tencent.mm.ui.base.i)localObject2).findViewById(2131821832);
            TextView localTextView2 = (TextView)((com.tencent.mm.ui.base.i)localObject2).findViewById(2131821833);
            TextView localTextView3 = (TextView)((com.tencent.mm.ui.base.i)localObject2).findViewById(2131821834);
            localObject1 = new Bundle();
            if (localObject3 != null) {
              localObject1 = ((c)localObject3).mEJ;
            }
            localTextView1.setOnClickListener(new r.3(this, paramMMActivity, (Bundle)localObject1, (com.tencent.mm.ui.base.i)localObject2));
            localTextView2.setOnClickListener(new r.4(this, (c)localObject3, (Bundle)localObject1, paramMMActivity, (com.tencent.mm.ui.base.i)localObject2));
            localTextView3.setOnClickListener(new r.5(this, (CheckBox)localObject4, (com.tencent.mm.ui.base.i)localObject2));
            ((com.tencent.mm.ui.base.i)localObject2).show();
            ((MMActivity)paramMMActivity).addDialog((Dialog)localObject2);
            continue;
            label694:
            if ((com.tencent.mm.plugin.wallet.b.a.cST()) && (((l)localObject4).bzb()) && (!((l)localObject4).byS()))
            {
              localObject3 = new Intent();
              ((Intent)localObject3).putExtras((Bundle)localObject1);
              if (bool1)
              {
                ((Intent)localObject3).putExtra("isFromKinda", bool1);
                ((Intent)localObject3).putExtra("kindaPayPwd", (String)localObject2);
                ((Intent)localObject3).putExtra("key_show_guide", false);
              }
              d.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", (Intent)localObject3);
            }
            else if ((com.tencent.mm.plugin.wallet.b.a.cSU()) && (((l)localObject4).bzo()) && (!((l)localObject4).byV()))
            {
              if (bool1)
              {
                localObject2 = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
                ((Intent)localObject2).putExtra("pwd", ((Bundle)localObject1).getString("key_pwd1"));
                ((Intent)localObject2).putExtra("key_scene", 1);
                paramMMActivity.startActivity((Intent)localObject2);
                AppMethodBeat.o(41567);
                return true;
              }
              localObject2 = LayoutInflater.from(paramMMActivity).inflate(2130969596, null);
              localObject3 = (TextView)((View)localObject2).findViewById(2131824164);
              localObject4 = (CheckBox)((View)localObject2).findViewById(2131824165);
              ((TextView)localObject3).setText(paramMMActivity.getString(2131299648));
              h.a(paramMMActivity, false, null, (View)localObject2, paramMMActivity.getString(2131297821), paramMMActivity.getString(2131296888), new r.1(this, paramMMActivity, (Bundle)localObject1), new r.2(this, (CheckBox)localObject4));
            }
          }
        }
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.r
 * JD-Core Version:    0.7.0.1
 */