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
import com.tencent.mm.ax.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactVerifyUI
  extends MMWizardActivity
{
  private String dpO;
  private int fromScene = 0;
  private boolean ifG = false;
  private EditText igP;
  private TextView igQ;
  private Button igR;
  private i igS;
  private SharedPreferences sp;
  private int status;
  
  private void goBack()
  {
    AppMethodBeat.i(109917);
    if (this.igS != null) {
      this.igS.recycle();
    }
    Xo(1);
    AppMethodBeat.o(109917);
  }
  
  public int getLayoutId()
  {
    return 2131493182;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109915);
    this.dpO = ((String)g.afB().afk().get(4097, null));
    this.igP = ((EditText)findViewById(2131297252));
    this.ifG = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    Button localButton = (Button)findViewById(2131297249);
    if ((this.dpO == null) || (this.dpO.equals(""))) {
      this.dpO = ((String)g.afB().afk().get(6, null));
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
    this.igP.setFilters(new InputFilter[] { local1 });
    this.igR = ((Button)findViewById(2131297254));
    this.igQ = ((TextView)findViewById(2131297250));
    this.igQ.setText(getString(2131756476, new Object[] { this.dpO }));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109907);
        paramAnonymousView = BindMContactVerifyUI.a(BindMContactVerifyUI.this).getText().toString().trim();
        if (bt.isNullOrNil(paramAnonymousView))
        {
          com.tencent.mm.ui.base.h.j(BindMContactVerifyUI.this, 2131756515, 2131755906);
          AppMethodBeat.o(109907);
          return;
        }
        BindMContactVerifyUI.this.hideVKB();
        BindMContactVerifyUI.a(BindMContactVerifyUI.this, paramAnonymousView);
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
    localButton = this.igR;
    if (b.yJ(this.dpO)) {}
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      this.igR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109909);
          BindMContactVerifyUI.this.hideVKB();
          paramAnonymousView = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("bindmcontact_mobile", BindMContactVerifyUI.c(BindMContactVerifyUI.this));
          localBundle.putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras(localBundle);
          com.tencent.mm.plugin.account.a.a.hYt.f(BindMContactVerifyUI.this, paramAnonymousView);
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
    this.status = u.aqK();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI
 * JD-Core Version:    0.7.0.1
 */