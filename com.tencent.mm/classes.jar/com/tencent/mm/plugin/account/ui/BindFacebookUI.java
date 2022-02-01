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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.c.a;

public class BindFacebookUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.g
{
  private static final String[] iPW = { "public_profile" };
  private c iOp;
  private ProgressDialog iPT;
  private DialogInterface.OnCancelListener iPU;
  private w iPV;
  
  public int getLayoutId()
  {
    return 2131493175;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127888);
    this.iOp = new c(getString(2131758773));
    this.iPU = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127877);
        if (BindFacebookUI.a(BindFacebookUI.this) != null) {
          com.tencent.mm.kernel.g.agi().a(BindFacebookUI.a(BindFacebookUI.this));
        }
        AppMethodBeat.o(127877);
      }
    };
    addTextOptionMenu(0, getString(2131755796), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127878);
        BindFacebookUI.b(BindFacebookUI.this);
        AppMethodBeat.o(127878);
        return true;
      }
    });
    setMMTitle(2131756438);
    Object localObject = (TextView)findViewById(2131304614);
    ((TextView)localObject).setVisibility(4);
    ((TextView)localObject).setText(2131756437);
    localObject = (Button)findViewById(2131297228);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(127879);
        BindFacebookUI.c(BindFacebookUI.this).a(BindFacebookUI.this, BindFacebookUI.aQx(), new BindFacebookUI.a(BindFacebookUI.this, (byte)0));
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
    com.tencent.mm.kernel.g.agi().b(183, this);
    AppMethodBeat.o(127887);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127886);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(183, this);
    initView();
    AppMethodBeat.o(127886);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127889);
    if (paramn.getType() != 183)
    {
      AppMethodBeat.o(127889);
      return;
    }
    if (this.iPT != null) {
      this.iPT.dismiss();
    }
    if (a.iyy.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(127889);
      return;
    }
    int i = ((w)paramn).opType;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (i == 1)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNG("facebookapp");
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alq("facebookapp");
      }
      ZA(1);
      AppMethodBeat.o(127889);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -67))
    {
      Toast.makeText(this, 2131758780, 1).show();
      AppMethodBeat.o(127889);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -5))
    {
      if (i == 1) {}
      for (paramInt1 = 2131758774;; paramInt1 = 2131758783)
      {
        Toast.makeText(this, paramInt1, 1).show();
        AppMethodBeat.o(127889);
        return;
      }
    }
    if (i == 0) {}
    for (paramInt1 = 2131757662;; paramInt1 = 2131757657)
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
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(127882);
      ac.d("MicroMsg.BindFacebookUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.c(BindFacebookUI.this, paramb.getMessage(), BindFacebookUI.this.getString(2131757657), true);
      BindFacebookUI.fq(false);
      AppMethodBeat.o(127882);
    }
    
    public final void a(com.tencent.mm.ui.g.a.e parame)
    {
      AppMethodBeat.i(127881);
      ac.d("MicroMsg.BindFacebookUI", "onFacebookError:" + parame.IJb);
      com.tencent.mm.ui.base.h.c(BindFacebookUI.this, parame.getMessage(), BindFacebookUI.this.getString(2131757657), true);
      BindFacebookUI.fq(false);
      AppMethodBeat.o(127881);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127883);
      ac.d("MicroMsg.BindFacebookUI", "onCancel");
      BindFacebookUI.fq(false);
      AppMethodBeat.o(127883);
    }
    
    public final void w(Bundle paramBundle)
    {
      AppMethodBeat.i(127880);
      ac.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.c(BindFacebookUI.this).iFS);
      com.tencent.mm.kernel.g.agR().agA().set(65830, BindFacebookUI.c(BindFacebookUI.this).iFS);
      if (BindFacebookUI.c(BindFacebookUI.this).IIO != 0L) {
        com.tencent.mm.kernel.g.agR().agA().set(65832, Long.valueOf(BindFacebookUI.c(BindFacebookUI.this).IIO));
      }
      paramBundle = BindFacebookUI.this.getString(2131755906);
      String str = BindFacebookUI.this.getString(2131758777);
      BindFacebookUI.a(BindFacebookUI.this, ProgressDialog.show(BindFacebookUI.this, paramBundle, str, true));
      BindFacebookUI.e(BindFacebookUI.this).setOnCancelListener(BindFacebookUI.d(BindFacebookUI.this));
      BindFacebookUI.a(BindFacebookUI.this, new w(1, BindFacebookUI.c(BindFacebookUI.this).iFS));
      com.tencent.mm.kernel.g.agi().a(BindFacebookUI.a(BindFacebookUI.this), 0);
      BindFacebookUI.fq(true);
      AppMethodBeat.o(127880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BindFacebookUI
 * JD-Core Version:    0.7.0.1
 */