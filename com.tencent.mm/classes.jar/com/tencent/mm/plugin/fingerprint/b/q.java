package com.tencent.mm.plugin.fingerprint.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.d;

public final class q
  implements h
{
  public final void a(MMActivity paramMMActivity, com.tencent.mm.plugin.fingerprint.faceid.auth.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(64398);
    parama = new WalletFaceIdDialog(paramMMActivity, parama, paramBundle);
    parama.setCancelable(false);
    paramMMActivity.getLifecycle().a(parama);
    parama.show();
    AppMethodBeat.o(64398);
  }
  
  public final boolean j(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(64399);
    if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViA, Boolean.FALSE)).booleanValue())
    {
      Log.i("MicroMsg.WalletSoterService", "has show the finger print auth guide!");
      AppMethodBeat.o(64399);
      return false;
    }
    Object localObject3 = com.tencent.mm.wallet_core.a.bF(paramMMActivity);
    Object localObject1 = new Bundle();
    if (localObject3 != null) {
      localObject1 = ((d)localObject3).fKb;
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
          Log.i("MicroMsg.WalletSoterService", "pwd is empty, not show the finger print auth guide!");
          AppMethodBeat.o(64399);
          return false;
        }
        Object localObject4 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
        Log.i("MicroMsg.WalletSoterService", "fingerprint: %s has fingerprint: %s, faceid: %s has faceid: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.gIe()), Boolean.valueOf(((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eot()), Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.gIf()), Boolean.valueOf(((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eoB()) });
        int i;
        if ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eon()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eoq()))
        {
          if ((!com.tencent.mm.plugin.wallet.b.a.gIe()) || (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eot()) || (!com.tencent.mm.plugin.wallet.b.a.gIf()) || (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eoB())) {
            break label764;
          }
          if (!bool1) {
            break label598;
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
          AppMethodBeat.o(64399);
          return true;
          label406:
          localObject2 = new Bundle();
          if (i == 1)
          {
            Log.i("MicroMsg.WalletSoterService", "click fingerprint btn");
            ((Bundle)localObject2).putBoolean("key_show_guide", false);
            ((Bundle)localObject2).putBoolean("isFromKinda", true);
            ((Bundle)localObject2).putString("kindaPayPwd", (String)localObject1);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            c.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", (Intent)localObject1);
          }
          else if (i == 2)
          {
            Log.i("MicroMsg.WalletSoterService", "click faceid btn");
            localObject2 = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
            ((Intent)localObject2).putExtra("pwd", (String)localObject1);
            ((Intent)localObject2).putExtra("key_scene", 1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "kindaHandleOpenBiometricPay", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramMMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "kindaHandleOpenBiometricPay", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            continue;
            label598:
            localObject2 = new i(paramMMActivity, a.j.mmalertdialog);
            ((i)localObject2).setContentView(a.g.biometric_pay_guide_dialog);
            localObject4 = (CheckBox)((i)localObject2).findViewById(a.f.bpgd_cb);
            TextView localTextView1 = (TextView)((i)localObject2).findViewById(a.f.bpgd_faceid_btn);
            TextView localTextView2 = (TextView)((i)localObject2).findViewById(a.f.bpgd_fingerprint_btn);
            TextView localTextView3 = (TextView)((i)localObject2).findViewById(a.f.bpgd_cancel_btn);
            localObject1 = new Bundle();
            if (localObject3 != null) {
              localObject1 = ((d)localObject3).fKb;
            }
            localTextView1.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64395);
                Object localObject = new b();
                ((b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
                Log.i("MicroMsg.WalletSoterService", "click faceid btn");
                localObject = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
                ((Intent)localObject).putExtra("pwd", this.ByN.getString("key_pwd1"));
                ((Intent)localObject).putExtra("key_scene", 1);
                paramAnonymousView = paramMMActivity;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.qVA.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64395);
              }
            });
            localTextView2.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64396);
                b localb = new b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                Log.i("MicroMsg.WalletSoterService", "click fingerprint btn");
                if (this.ByQ != null)
                {
                  this.ByN.putBoolean("key_show_guide", false);
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtras(this.ByN);
                  c.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", paramAnonymousView);
                }
                this.qVA.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64396);
              }
            });
            localTextView3.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64397);
                b localb = new b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                Log.i("MicroMsg.WalletSoterService", "click cancel btn");
                if (this.ByR.isChecked()) {
                  com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViA, Boolean.TRUE);
                }
                this.qVA.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64397);
              }
            });
            ((i)localObject2).show();
            ((MMActivity)paramMMActivity).addDialog((Dialog)localObject2);
            continue;
            label764:
            if ((com.tencent.mm.plugin.wallet.b.a.gIe()) && (((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eot()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eon()))
            {
              localObject3 = new Intent();
              ((Intent)localObject3).putExtras((Bundle)localObject1);
              if (bool1)
              {
                ((Intent)localObject3).putExtra("isFromKinda", bool1);
                ((Intent)localObject3).putExtra("kindaPayPwd", (String)localObject2);
                ((Intent)localObject3).putExtra("key_show_guide", false);
              }
              c.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", (Intent)localObject3);
            }
            else if ((com.tencent.mm.plugin.wallet.b.a.gIf()) && (((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eoB()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).eoq()))
            {
              if (bool1)
              {
                localObject2 = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
                ((Intent)localObject2).putExtra("pwd", ((Bundle)localObject1).getString("key_pwd1"));
                ((Intent)localObject2).putExtra("key_scene", 1);
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "showOpenGuideAfterPaySucc", "(Lcom/tencent/mm/ui/MMActivity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramMMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "showOpenGuideAfterPaySucc", "(Lcom/tencent/mm/ui/MMActivity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(64399);
                return true;
              }
              localObject2 = LayoutInflater.from(paramMMActivity).inflate(a.g.fingerprint_guide_dialog, null);
              localObject3 = (TextView)((View)localObject2).findViewById(a.f.fgd_desc_tv);
              localObject4 = (CheckBox)((View)localObject2).findViewById(a.f.fingerprint_not_show_any_more_cb);
              ((TextView)localObject3).setText(paramMMActivity.getString(a.i.faceid_guide_open_text));
              com.tencent.mm.ui.base.h.a(paramMMActivity, false, null, (View)localObject2, paramMMActivity.getString(a.i.btn_guide_open_faceid), paramMMActivity.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(64393);
                  Object localObject = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
                  ((Intent)localObject).putExtra("pwd", this.ByN.getString("key_pwd1"));
                  ((Intent)localObject).putExtra("key_scene", 1);
                  paramAnonymousDialogInterface = paramMMActivity;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(64393);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(64394);
                  if (this.ByP.isChecked()) {
                    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViA, Boolean.TRUE);
                  }
                  AppMethodBeat.o(64394);
                }
              });
            }
          }
        }
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q
 * JD-Core Version:    0.7.0.1
 */