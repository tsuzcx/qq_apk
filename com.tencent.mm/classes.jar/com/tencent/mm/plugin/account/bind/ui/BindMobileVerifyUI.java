package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abs;
import com.tencent.mm.autogen.a.lu;
import com.tencent.mm.autogen.a.lu.b;
import com.tencent.mm.autogen.a.lv;
import com.tencent.mm.autogen.a.lv.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;

public class BindMobileVerifyUI
  extends MMWizardActivity
  implements com.tencent.mm.am.h
{
  private MTimerHandler eln;
  private int fromScene;
  private String hRk;
  private TextView pPL;
  private TextView pPM;
  private Integer pPN;
  private EditText pPd;
  private Button pPf;
  private BindWordingContent pPu;
  private int pPv;
  private boolean pPw;
  private boolean pPx;
  private com.tencent.mm.ui.base.w tipDialog;
  
  public BindMobileVerifyUI()
  {
    AppMethodBeat.i(109961);
    this.tipDialog = null;
    this.pPN = Integer.valueOf(15);
    AppMethodBeat.o(109961);
  }
  
  private void bWn()
  {
    AppMethodBeat.i(109966);
    if ((this.eln != null) && (!this.eln.stopped())) {
      this.eln.stopTimer();
    }
    this.eln = null;
    AppMethodBeat.o(109966);
  }
  
  public int getLayoutId()
  {
    return a.f.bindmcontact_verify;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109965);
    this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(4097, null));
    this.pPd = ((EditText)findViewById(a.e.bind_mcontact_verify_num));
    this.pPL = ((TextView)findViewById(a.e.bind_mcontact_verify_mobile_num));
    this.pPM = ((TextView)findViewById(a.e.bind_mcontact_sms_time_hint));
    Button localButton = (Button)findViewById(a.e.bind_mcontact_verify_btn);
    if ((this.hRk == null) || (this.hRk.equals(""))) {
      this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(6, null));
    }
    if ((this.hRk != null) && (this.hRk.length() > 0))
    {
      this.pPL.setVisibility(0);
      this.pPL.setText(this.hRk);
    }
    InputFilter local1 = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(109954);
        paramAnonymousCharSequence = Util.filterNumber(paramAnonymousCharSequence);
        AppMethodBeat.o(109954);
        return paramAnonymousCharSequence;
      }
    };
    this.pPd.setFilters(new InputFilter[] { local1 });
    this.pPf = ((Button)findViewById(a.e.bind_mcontact_voice_code));
    localButton.setVisibility(8);
    this.pPM.setText(getResources().getQuantityString(a.g.mobileverify_send_code_tip, this.pPN.intValue(), new Object[] { this.pPN }));
    if (this.eln == null)
    {
      this.eln = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(304872);
          if (BindMobileVerifyUI.c(BindMobileVerifyUI.this) != null) {
            BindMobileVerifyUI.d(BindMobileVerifyUI.this);
          }
          AppMethodBeat.o(304872);
          return true;
        }
      }, true);
      this.eln.startTimer(1000L, 1000L);
    }
    addTextOptionMenu(0, getString(a.i.app_nextstep), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109956);
        paramAnonymousMenuItem = BindMobileVerifyUI.a(BindMobileVerifyUI.this).getText().toString().trim();
        if (paramAnonymousMenuItem.equals(""))
        {
          k.s(BindMobileVerifyUI.this, a.i.bind_mcontact_verifynull, a.i.app_tip);
          AppMethodBeat.o(109956);
          return true;
        }
        BindMobileVerifyUI.this.hideVKB();
        Object localObject1 = new lu();
        ((lu)localObject1).hNG.context = BindMobileVerifyUI.this;
        ((lu)localObject1).publish();
        localObject1 = ((lu)localObject1).hNH.hNI;
        Object localObject2 = new lv();
        ((lv)localObject2).publish();
        localObject2 = ((lv)localObject2).hNJ.hNK;
        paramAnonymousMenuItem = new com.tencent.mm.plugin.account.friend.model.w(BindMobileVerifyUI.b(BindMobileVerifyUI.this), 2, paramAnonymousMenuItem, "", (String)localObject1, (String)localObject2);
        com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem, 0);
        localObject1 = BindMobileVerifyUI.this;
        localObject2 = BindMobileVerifyUI.this;
        BindMobileVerifyUI.this.getString(a.i.app_tip);
        BindMobileVerifyUI.a((BindMobileVerifyUI)localObject1, k.a((Context)localObject2, BindMobileVerifyUI.this.getString(a.i.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(109955);
            com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem);
            AppMethodBeat.o(109955);
          }
        }));
        AppMethodBeat.o(109956);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109957);
        BindMobileVerifyUI.this.finish();
        AppMethodBeat.o(109957);
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
          AppMethodBeat.i(109958);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          BindMobileVerifyUI.this.hideVKB();
          paramAnonymousView = new Intent();
          localObject = new Bundle();
          ((Bundle)localObject).putString("bindmcontact_mobile", BindMobileVerifyUI.b(BindMobileVerifyUI.this));
          ((Bundle)localObject).putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras((Bundle)localObject);
          com.tencent.mm.plugin.account.sdk.a.pFn.f(BindMobileVerifyUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109958);
        }
      });
      AppMethodBeat.o(109965);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109962);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(132, this);
    setMMTitle(a.i.bind_mcontact_title_verify);
    this.pPu = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.pPv = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.pPw = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.pPx = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    initView();
    AppMethodBeat.o(109962);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109963);
    com.tencent.mm.kernel.h.aZW().b(132, this);
    super.onDestroy();
    AppMethodBeat.o(109963);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109967);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      aAp(1);
      AppMethodBeat.o(109967);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109967);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool2 = true;
    AppMethodBeat.i(109968);
    Log.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() != 2)
    {
      AppMethodBeat.o(109968);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() == 2) {}
      switch (this.fromScene)
      {
      default: 
        if ((this.fromScene == 0) || (this.fromScene == 3)) {
          ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBookAndUpload();
        }
        paramString = new Intent(this, BindMobileStatusUI.class);
        paramString.putExtra("kstyle_bind_wording", this.pPu);
        paramString.putExtra("kstyle_bind_recommend_show", this.pPv);
        paramString.putExtra("Kfind_friend_by_mobile_flag", this.pPw);
        paramString.putExtra("Krecom_friends_by_mobile_flag", this.pPx);
        paramString.putExtra("bind_scene", this.fromScene);
        aQ(this, paramString);
        AppMethodBeat.o(109968);
        return;
      case 1: 
        if (!z.bBc())
        {
          paramString = new abs();
          paramString.ifi.hAJ = true;
          paramString.ifi.ifj = true;
          paramString.publish();
        }
        aAp(1);
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.account.sdk.a.pFn.e(this, paramString);
        AppMethodBeat.o(109968);
        return;
      }
      boolean bool1;
      if (!this.pPw)
      {
        bool1 = true;
        if (this.pPx) {
          break label369;
        }
      }
      for (;;)
      {
        BindMobileStatusUI.c(this, bool1, bool2);
        exit(-1);
        AppMethodBeat.o(109968);
        return;
        bool1 = false;
        break;
        label369:
        bool2 = false;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(109968);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -34: 
        Toast.makeText(this, a.i.bind_mcontact_err_freq_limit, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, a.i.bind_mcontact_err_binded, 0).show();
        i = 1;
        break;
      case -214: 
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, a.i.bind_mcontact_err_format, 0).show();
        i = 1;
        break;
      case -35: 
        Toast.makeText(this, a.i.bind_mcontact_err_binded_by_other, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, a.i.bind_mcontact_err_unbinded_notbinded, 0).show();
        i = 1;
        break;
      case -32: 
        k.a(this, a.i.bind_mcontact_verify_err_unmatch_content, a.i.bind_mcontact_verify_tip, null);
        i = 1;
        break;
      case -33: 
        k.a(this, a.i.bind_mcontact_verify_err_time_out_content, a.i.bind_mcontact_verify_tip, null);
        i = 1;
      }
    }
    Toast.makeText(this, getString(a.i.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(109968);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109964);
    bWn();
    super.onStop();
    AppMethodBeat.o(109964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */