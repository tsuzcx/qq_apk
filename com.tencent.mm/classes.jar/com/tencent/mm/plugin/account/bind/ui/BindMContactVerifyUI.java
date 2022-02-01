package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.autogen.a.abs;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.w;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.util.Map;

public class BindMContactVerifyUI
  extends MMWizardActivity
{
  private int fromScene = 0;
  private String hRk;
  private boolean pNU = false;
  private EditText pPd;
  private TextView pPe;
  private Button pPf;
  private String pPg;
  private i pPh;
  private String pPi;
  private SharedPreferences sp;
  private int status;
  
  public int getLayoutId()
  {
    return a.f.bindmcontact_verify;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109915);
    this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(4097, null));
    this.pPd = ((EditText)findViewById(a.e.bind_mcontact_verify_num));
    this.pNU = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    this.pPg = getIntent().getStringExtra("policy_ticket");
    Button localButton = (Button)findViewById(a.e.bind_mcontact_verify_btn);
    if ((this.hRk == null) || (this.hRk.equals(""))) {
      this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(6, null));
    }
    InputFilter local1 = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(109906);
        paramAnonymousCharSequence = Util.filterNumber(paramAnonymousCharSequence);
        AppMethodBeat.o(109906);
        return paramAnonymousCharSequence;
      }
    };
    this.pPd.setFilters(new InputFilter[] { local1 });
    this.pPf = ((Button)findViewById(a.e.bind_mcontact_voice_code));
    this.pPe = ((TextView)findViewById(a.e.bind_mcontact_verify_hint));
    this.pPe.setText(getString(a.i.bind_mcontact_input_verify_hint, new Object[] { this.hRk }));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109907);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = BindMContactVerifyUI.a(BindMContactVerifyUI.this).getText().toString().trim();
        if (Util.isNullOrNil(paramAnonymousView))
        {
          k.s(BindMContactVerifyUI.this, a.i.bind_mcontact_verifynull, a.i.app_tip);
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
    localButton = this.pPf;
    if (com.tencent.mm.au.b.OC(this.hRk)) {}
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      this.pPf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109909);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          BindMContactVerifyUI.this.hideVKB();
          paramAnonymousView = new Intent();
          localObject = new Bundle();
          ((Bundle)localObject).putString("bindmcontact_mobile", BindMContactVerifyUI.c(BindMContactVerifyUI.this));
          ((Bundle)localObject).putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras((Bundle)localObject);
          com.tencent.mm.plugin.account.sdk.a.pFn.f(BindMContactVerifyUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109909);
        }
      });
      AppMethodBeat.o(109915);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(304885);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramIntent != null))
    {
      paramIntent = (Map)paramIntent.getBundleExtra("result_data").getSerializable("next_params");
      if (paramIntent != null)
      {
        paramIntent = (String)paramIntent.get("next_step");
        if ("end_bind_mobile".equalsIgnoreCase(paramIntent))
        {
          paramIntent = new Intent();
          paramIntent.addFlags(67108864);
          com.tencent.mm.plugin.account.sdk.a.pFn.n(paramIntent, this);
          AppMethodBeat.o(304885);
          return;
        }
        if ("bind_mobile_take_over".equalsIgnoreCase(paramIntent))
        {
          Log.i("MicroMsg.BindMContactVerifyUI", "bind_mobile_take_over");
          this.pPh.o(this.pPd.getText().toString().trim(), 25, this.pPi);
        }
      }
    }
    AppMethodBeat.o(304885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109913);
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_mcontact_title_verify);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = z.bAQ();
    initView();
    AppMethodBeat.o(109913);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109914);
    if (this.pPh != null) {
      this.pPh.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(109914);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109916);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      aAp(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI
 * JD-Core Version:    0.7.0.1
 */