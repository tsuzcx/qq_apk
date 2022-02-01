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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.c.a;

public class BindFacebookUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.i
{
  private static final String[] kkg = { "public_profile" };
  private c kiu;
  private ProgressDialog kkd;
  private DialogInterface.OnCancelListener kke;
  private w kkf;
  
  public int getLayoutId()
  {
    return 2131493221;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127888);
    this.kiu = new c(getString(2131759094));
    this.kke = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127877);
        if (BindFacebookUI.a(BindFacebookUI.this) != null) {
          g.azz().a(BindFacebookUI.a(BindFacebookUI.this));
        }
        AppMethodBeat.o(127877);
      }
    };
    addTextOptionMenu(0, getString(2131755877), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127878);
        BindFacebookUI.b(BindFacebookUI.this);
        AppMethodBeat.o(127878);
        return true;
      }
    });
    setMMTitle(2131756574);
    Object localObject = (TextView)findViewById(2131307666);
    ((TextView)localObject).setVisibility(4);
    ((TextView)localObject).setText(2131756573);
    localObject = (Button)findViewById(2131297383);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(127879);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/BindFacebookUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        BindFacebookUI.c(BindFacebookUI.this).a(BindFacebookUI.this, BindFacebookUI.kkg, new BindFacebookUI.a(BindFacebookUI.this, (byte)0));
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
    g.azz().b(183, this);
    AppMethodBeat.o(127887);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127886);
    super.onResume();
    g.azz().a(183, this);
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
    if (this.kkd != null) {
      this.kkd.dismiss();
    }
    if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(127889);
      return;
    }
    int i = ((w)paramq).opType;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (i == 1)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjW("facebookapp");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEE("facebookapp");
      }
      ala(1);
      AppMethodBeat.o(127889);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -67))
    {
      Toast.makeText(this, 2131759101, 1).show();
      AppMethodBeat.o(127889);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -5))
    {
      if (i == 1) {}
      for (paramInt1 = 2131759095;; paramInt1 = 2131759104)
      {
        Toast.makeText(this, paramInt1, 1).show();
        AppMethodBeat.o(127889);
        return;
      }
    }
    if (i == 0) {}
    for (paramInt1 = 2131757890;; paramInt1 = 2131757885)
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
    
    public final void E(Bundle paramBundle)
    {
      AppMethodBeat.i(127880);
      Log.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.c(BindFacebookUI.this).jZX);
      g.aAh().azQ().set(65830, BindFacebookUI.c(BindFacebookUI.this).jZX);
      if (BindFacebookUI.c(BindFacebookUI.this).QjF != 0L) {
        g.aAh().azQ().set(65832, Long.valueOf(BindFacebookUI.c(BindFacebookUI.this).QjF));
      }
      paramBundle = BindFacebookUI.this.getString(2131755998);
      String str = BindFacebookUI.this.getString(2131759098);
      BindFacebookUI.a(BindFacebookUI.this, ProgressDialog.show(BindFacebookUI.this, paramBundle, str, true));
      BindFacebookUI.e(BindFacebookUI.this).setOnCancelListener(BindFacebookUI.d(BindFacebookUI.this));
      BindFacebookUI.a(BindFacebookUI.this, new w(1, BindFacebookUI.c(BindFacebookUI.this).jZX));
      g.azz().a(BindFacebookUI.a(BindFacebookUI.this), 0);
      BindFacebookUI.go(true);
      AppMethodBeat.o(127880);
    }
    
    public final void a(com.tencent.mm.ui.h.a.b paramb)
    {
      AppMethodBeat.i(127882);
      Log.d("MicroMsg.BindFacebookUI", "onError:" + paramb.getMessage());
      h.c(BindFacebookUI.this, paramb.getMessage(), BindFacebookUI.this.getString(2131757885), true);
      BindFacebookUI.go(false);
      AppMethodBeat.o(127882);
    }
    
    public final void a(com.tencent.mm.ui.h.a.e parame)
    {
      AppMethodBeat.i(127881);
      Log.d("MicroMsg.BindFacebookUI", "onFacebookError:" + parame.QjS);
      h.c(BindFacebookUI.this, parame.getMessage(), BindFacebookUI.this.getString(2131757885), true);
      BindFacebookUI.go(false);
      AppMethodBeat.o(127881);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127883);
      Log.d("MicroMsg.BindFacebookUI", "onCancel");
      BindFacebookUI.go(false);
      AppMethodBeat.o(127883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BindFacebookUI
 * JD-Core Version:    0.7.0.1
 */