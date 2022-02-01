package com.tencent.mm.plugin.fingerprint.b;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;

public final class q
  implements h
{
  public final void a(MMActivity paramMMActivity, com.tencent.mm.plugin.fingerprint.faceid.auth.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(64398);
    parama = new WalletFaceIdDialog(paramMMActivity, parama, paramBundle);
    parama.setCancelable(false);
    paramMMActivity.getLifecycle().addObserver(parama);
    parama.show();
    AppMethodBeat.o(64398);
  }
  
  public final boolean i(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(64399);
    if (((Boolean)g.ajR().ajA().get(am.a.IMy, Boolean.FALSE)).booleanValue())
    {
      ae.i("MicroMsg.WalletSoterService", "has show the finger print auth guide!");
      AppMethodBeat.o(64399);
      return false;
    }
    Object localObject3 = com.tencent.mm.wallet_core.a.bs(paramMMActivity);
    Object localObject1 = new Bundle();
    if (localObject3 != null) {
      localObject1 = ((com.tencent.mm.wallet_core.d)localObject3).dyY;
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
          ae.i("MicroMsg.WalletSoterService", "pwd is empty, not show the finger print auth guide!");
          AppMethodBeat.o(64399);
          return false;
        }
        Object localObject4 = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        ae.i("MicroMsg.WalletSoterService", "fingerprint: %s has fingerprint: %s, faceid: %s has faceid: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.eIj()), Boolean.valueOf(((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cRZ()), Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.eIk()), Boolean.valueOf(((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cSh()) });
        int i;
        if ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cRT()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cRW()))
        {
          if ((!com.tencent.mm.plugin.wallet.b.a.eIj()) || (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cRZ()) || (!com.tencent.mm.plugin.wallet.b.a.eIk()) || (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cSh())) {
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
            ae.i("MicroMsg.WalletSoterService", "click fingerprint btn");
            ((Bundle)localObject2).putBoolean("key_show_guide", false);
            ((Bundle)localObject2).putBoolean("isFromKinda", true);
            ((Bundle)localObject2).putString("kindaPayPwd", (String)localObject1);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            com.tencent.mm.br.d.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", (Intent)localObject1);
          }
          else if (i == 2)
          {
            ae.i("MicroMsg.WalletSoterService", "click faceid btn");
            localObject2 = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
            ((Intent)localObject2).putExtra("pwd", (String)localObject1);
            ((Intent)localObject2).putExtra("key_scene", 1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "kindaHandleOpenBiometricPay", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramMMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "kindaHandleOpenBiometricPay", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            continue;
            label598:
            localObject2 = new i(paramMMActivity, 2131821723);
            ((i)localObject2).setContentView(2131493189);
            localObject4 = (CheckBox)((i)localObject2).findViewById(2131297491);
            TextView localTextView1 = (TextView)((i)localObject2).findViewById(2131297492);
            TextView localTextView2 = (TextView)((i)localObject2).findViewById(2131297493);
            TextView localTextView3 = (TextView)((i)localObject2).findViewById(2131297490);
            localObject1 = new Bundle();
            if (localObject3 != null) {
              localObject1 = ((com.tencent.mm.wallet_core.d)localObject3).dyY;
            }
            localTextView1.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64395);
                Object localObject = new b();
                ((b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
                ae.i("MicroMsg.WalletSoterService", "click faceid btn");
                localObject = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
                ((Intent)localObject).putExtra("pwd", this.tsk.getString("key_pwd1"));
                ((Intent)localObject).putExtra("key_scene", 1);
                paramAnonymousView = paramMMActivity;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.mHe.dismiss();
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
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                ae.i("MicroMsg.WalletSoterService", "click fingerprint btn");
                if (this.tsn != null)
                {
                  this.tsk.putBoolean("key_show_guide", false);
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtras(this.tsk);
                  com.tencent.mm.br.d.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", paramAnonymousView);
                }
                this.mHe.dismiss();
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
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                ae.i("MicroMsg.WalletSoterService", "click cancel btn");
                if (this.tso.isChecked()) {
                  g.ajR().ajA().set(am.a.IMy, Boolean.TRUE);
                }
                this.mHe.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64397);
              }
            });
            ((i)localObject2).show();
            ((MMActivity)paramMMActivity).addDialog((Dialog)localObject2);
            continue;
            label764:
            if ((com.tencent.mm.plugin.wallet.b.a.eIj()) && (((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cRZ()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cRT()))
            {
              localObject3 = new Intent();
              ((Intent)localObject3).putExtras((Bundle)localObject1);
              if (bool1)
              {
                ((Intent)localObject3).putExtra("isFromKinda", bool1);
                ((Intent)localObject3).putExtra("kindaPayPwd", (String)localObject2);
                ((Intent)localObject3).putExtra("key_show_guide", false);
              }
              com.tencent.mm.br.d.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", (Intent)localObject3);
            }
            else if ((com.tencent.mm.plugin.wallet.b.a.eIk()) && (((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cSh()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject4).cRW()))
            {
              if (bool1)
              {
                localObject2 = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
                ((Intent)localObject2).putExtra("pwd", ((Bundle)localObject1).getString("key_pwd1"));
                ((Intent)localObject2).putExtra("key_scene", 1);
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "showOpenGuideAfterPaySucc", "(Lcom/tencent/mm/ui/MMActivity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramMMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "showOpenGuideAfterPaySucc", "(Lcom/tencent/mm/ui/MMActivity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(64399);
                return true;
              }
              localObject2 = LayoutInflater.from(paramMMActivity).inflate(2131494137, null);
              localObject3 = (TextView)((View)localObject2).findViewById(2131299905);
              localObject4 = (CheckBox)((View)localObject2).findViewById(2131300097);
              ((TextView)localObject3).setText(paramMMActivity.getString(2131758807));
              com.tencent.mm.ui.base.h.a(paramMMActivity, false, null, (View)localObject2, paramMMActivity.getString(2131756747), paramMMActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(64393);
                  Object localObject = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
                  ((Intent)localObject).putExtra("pwd", this.tsk.getString("key_pwd1"));
                  ((Intent)localObject).putExtra("key_scene", 1);
                  paramAnonymousDialogInterface = paramMMActivity;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(64393);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(64394);
                  if (this.tsm.isChecked()) {
                    g.ajR().ajA().set(am.a.IMy, Boolean.TRUE);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q
 * JD-Core Version:    0.7.0.1
 */