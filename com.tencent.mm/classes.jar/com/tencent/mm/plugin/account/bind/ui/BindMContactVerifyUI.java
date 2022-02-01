package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMContactVerifyUI
  extends MMWizardActivity
{
  private String dzn;
  private int fromScene = 0;
  private boolean iYY = false;
  private EditText jah;
  private TextView jai;
  private Button jaj;
  private i jak;
  private SharedPreferences sp;
  private int status;
  
  private void goBack()
  {
    AppMethodBeat.i(109917);
    if (this.jak != null) {
      this.jak.recycle();
    }
    abK(1);
    AppMethodBeat.o(109917);
  }
  
  public int getLayoutId()
  {
    return 2131493182;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109915);
    this.dzn = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(4097, null));
    this.jah = ((EditText)findViewById(2131297252));
    this.iYY = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    Button localButton = (Button)findViewById(2131297249);
    if ((this.dzn == null) || (this.dzn.equals(""))) {
      this.dzn = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(6, null));
    }
    InputFilter local1 = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(109906);
        paramAnonymousCharSequence = bt.aj(paramAnonymousCharSequence);
        AppMethodBeat.o(109906);
        return paramAnonymousCharSequence;
      }
    };
    this.jah.setFilters(new InputFilter[] { local1 });
    this.jaj = ((Button)findViewById(2131297254));
    this.jai = ((TextView)findViewById(2131297250));
    this.jai.setText(getString(2131756476, new Object[] { this.dzn }));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109907);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = BindMContactVerifyUI.a(BindMContactVerifyUI.this).getText().toString().trim();
        if (bt.isNullOrNil(paramAnonymousView))
        {
          h.l(BindMContactVerifyUI.this, 2131756515, 2131755906);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109907);
          return;
        }
        BindMContactVerifyUI.this.hideVKB();
        BindMContactVerifyUI.a(BindMContactVerifyUI.this, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109907);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109908);
        BindMContactVerifyUI.b(BindMContactVerifyUI.this);
        AppMethodBeat.o(109908);
        return true;
      }
    });
    localButton = this.jaj;
    if (com.tencent.mm.ax.b.FS(this.dzn)) {}
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      this.jaj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109909);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          BindMContactVerifyUI.this.hideVKB();
          paramAnonymousView = new Intent();
          localObject = new Bundle();
          ((Bundle)localObject).putString("bindmcontact_mobile", BindMContactVerifyUI.c(BindMContactVerifyUI.this));
          ((Bundle)localObject).putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras((Bundle)localObject);
          com.tencent.mm.plugin.account.a.a.iRG.f(BindMContactVerifyUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109909);
        }
      });
      AppMethodBeat.o(109915);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109913);
    super.onCreate(paramBundle);
    setMMTitle(2131756490);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = u.aAq();
    initView();
    AppMethodBeat.o(109913);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109914);
    super.onDestroy();
    AppMethodBeat.o(109914);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109916);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      goBack();
      AppMethodBeat.o(109916);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109916);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI
 * JD-Core Version:    0.7.0.1
 */