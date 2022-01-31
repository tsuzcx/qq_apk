package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactVerifyUI
  extends MMWizardActivity
{
  private String czF;
  private int fromScene = 0;
  private boolean gsE = false;
  private EditText gtO;
  private TextView gtP;
  private Button gtQ;
  private i gtR;
  private SharedPreferences sp;
  private int status;
  
  private void goBack()
  {
    AppMethodBeat.i(13490);
    if (this.gtR != null) {
      this.gtR.recycle();
    }
    Oi(1);
    AppMethodBeat.o(13490);
  }
  
  public int getLayoutId()
  {
    return 2130968850;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13488);
    this.czF = ((String)g.RL().Ru().get(4097, null));
    this.gtO = ((EditText)findViewById(2131821810));
    this.gsE = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    Button localButton = (Button)findViewById(2131821811);
    if ((this.czF == null) || (this.czF.equals(""))) {
      this.czF = ((String)g.RL().Ru().get(6, null));
    }
    BindMContactVerifyUI.1 local1 = new BindMContactVerifyUI.1(this);
    this.gtO.setFilters(new InputFilter[] { local1 });
    this.gtQ = ((Button)findViewById(2131821774));
    this.gtP = ((TextView)findViewById(2131821808));
    this.gtP.setText(getString(2131297584, new Object[] { this.czF }));
    localButton.setOnClickListener(new BindMContactVerifyUI.2(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(13481);
        BindMContactVerifyUI.b(BindMContactVerifyUI.this);
        AppMethodBeat.o(13481);
        return true;
      }
    });
    localButton = this.gtQ;
    if (b.tK(this.czF)) {}
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      this.gtQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(13482);
          BindMContactVerifyUI.this.hideVKB();
          paramAnonymousView = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("bindmcontact_mobile", BindMContactVerifyUI.c(BindMContactVerifyUI.this));
          localBundle.putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras(localBundle);
          com.tencent.mm.plugin.account.a.a.gmO.f(BindMContactVerifyUI.this, paramAnonymousView);
          AppMethodBeat.o(13482);
        }
      });
      AppMethodBeat.o(13488);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13486);
    super.onCreate(paramBundle);
    setMMTitle(2131297598);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = r.Zr();
    initView();
    AppMethodBeat.o(13486);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13487);
    super.onDestroy();
    AppMethodBeat.o(13487);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13489);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      goBack();
      AppMethodBeat.o(13489);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13489);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI
 * JD-Core Version:    0.7.0.1
 */