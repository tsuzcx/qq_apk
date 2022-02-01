package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.i.a.c.a;
import com.tencent.mm.ui.i.a.e;

public class BindFacebookUI
  extends MMWizardActivity
  implements com.tencent.mm.an.i
{
  private static final String[] nbW = { "public_profile" };
  private c mZT;
  private ProgressDialog nbT;
  private DialogInterface.OnCancelListener nbU;
  private w nbV;
  
  public int getLayoutId()
  {
    return r.g.bindfacebook;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127888);
    this.mZT = new c(getString(r.j.facebook_app_id));
    this.nbU = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127877);
        if (BindFacebookUI.a(BindFacebookUI.this) != null) {
          com.tencent.mm.kernel.h.aGY().a(BindFacebookUI.a(BindFacebookUI.this));
        }
        AppMethodBeat.o(127877);
      }
    };
    addTextOptionMenu(0, getString(r.j.app_ignore_it), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127878);
        BindFacebookUI.b(BindFacebookUI.this);
        AppMethodBeat.o(127878);
        return true;
      }
    });
    setMMTitle(r.j.bind_facebook_start_title);
    Object localObject = (TextView)findViewById(r.f.setting_bind_facebook_hint);
    ((TextView)localObject).setVisibility(4);
    ((TextView)localObject).setText(r.j.bind_facebook_start_hint);
    localObject = (Button)findViewById(r.f.bind_facebook_start_btn);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(127879);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/BindFacebookUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        BindFacebookUI.c(BindFacebookUI.this).a(BindFacebookUI.this, BindFacebookUI.bzh(), new BindFacebookUI.a(BindFacebookUI.this, (byte)0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/BindFacebookUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(127879);
      }
    });
    AppMethodBeat.o(127888);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127884);
    super.onCreate(paramBundle);
    AppMethodBeat.o(127884);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127885);
    super.onDestroy();
    AppMethodBeat.o(127885);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127887);
    super.onPause();
    com.tencent.mm.kernel.h.aGY().b(183, this);
    AppMethodBeat.o(127887);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127886);
    super.onResume();
    com.tencent.mm.kernel.h.aGY().a(183, this);
    initView();
    AppMethodBeat.o(127886);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127889);
    if (paramq.getType() != 183)
    {
      AppMethodBeat.o(127889);
      return;
    }
    if (this.nbT != null) {
      this.nbT.dismiss();
    }
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(127889);
      return;
    }
    int i = ((w)paramq).opType;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (i == 1)
      {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv("facebookapp");
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOO("facebookapp");
      }
      atX(1);
      AppMethodBeat.o(127889);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -67))
    {
      Toast.makeText(this, r.j.facebook_auth_have_bind_facebook, 1).show();
      AppMethodBeat.o(127889);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -5))
    {
      if (i == 1) {}
      for (paramInt1 = r.j.facebook_auth_bind_access_denied;; paramInt1 = r.j.facebook_auth_unbind_access_denied)
      {
        Toast.makeText(this, paramInt1, 1).show();
        AppMethodBeat.o(127889);
        return;
      }
    }
    if (i == 0) {}
    for (paramInt1 = r.j.contact_info_facebookapp_unbind_fail;; paramInt1 = r.j.contact_info_facebookapp_bind_fail)
    {
      Toast.makeText(this, paramInt1, 1).show();
      AppMethodBeat.o(127889);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements c.a
  {
    private a() {}
    
    public final void K(Bundle paramBundle)
    {
      AppMethodBeat.i(127880);
      Log.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.c(BindFacebookUI.this).mRq);
      com.tencent.mm.kernel.h.aHG().aHp().i(65830, BindFacebookUI.c(BindFacebookUI.this).mRq);
      if (BindFacebookUI.c(BindFacebookUI.this).XGQ != 0L) {
        com.tencent.mm.kernel.h.aHG().aHp().i(65832, Long.valueOf(BindFacebookUI.c(BindFacebookUI.this).XGQ));
      }
      paramBundle = BindFacebookUI.this.getString(r.j.app_tip);
      String str = BindFacebookUI.this.getString(r.j.facebook_auth_binding);
      BindFacebookUI.a(BindFacebookUI.this, ProgressDialog.show(BindFacebookUI.this, paramBundle, str, true));
      BindFacebookUI.e(BindFacebookUI.this).setOnCancelListener(BindFacebookUI.d(BindFacebookUI.this));
      BindFacebookUI.a(BindFacebookUI.this, new w(1, BindFacebookUI.c(BindFacebookUI.this).mRq));
      com.tencent.mm.kernel.h.aGY().a(BindFacebookUI.a(BindFacebookUI.this), 0);
      BindFacebookUI.ha(true);
      AppMethodBeat.o(127880);
    }
    
    public final void a(com.tencent.mm.ui.i.a.b paramb)
    {
      AppMethodBeat.i(127882);
      Log.d("MicroMsg.BindFacebookUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.c(BindFacebookUI.this, paramb.getMessage(), BindFacebookUI.this.getString(r.j.contact_info_facebookapp_bind_fail), true);
      BindFacebookUI.ha(false);
      AppMethodBeat.o(127882);
    }
    
    public final void a(e parame)
    {
      AppMethodBeat.i(127881);
      Log.d("MicroMsg.BindFacebookUI", "onFacebookError:" + parame.XHd);
      com.tencent.mm.ui.base.h.c(BindFacebookUI.this, parame.getMessage(), BindFacebookUI.this.getString(r.j.contact_info_facebookapp_bind_fail), true);
      BindFacebookUI.ha(false);
      AppMethodBeat.o(127881);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127883);
      Log.d("MicroMsg.BindFacebookUI", "onCancel");
      BindFacebookUI.ha(false);
      AppMethodBeat.o(127883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BindFacebookUI
 * JD-Core Version:    0.7.0.1
 */