package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.iv.b;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.iw.a;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI
  extends MMWizardActivity
  implements com.tencent.mm.al.g
{
  private String dpO;
  private int fromScene;
  private EditText igP;
  private Button igR;
  private BindWordingContent ihc;
  private int ihd;
  private boolean ihe;
  private boolean ihf;
  private TextView iht;
  private TextView ihu;
  private Integer ihv;
  private Timer mTimer;
  private p tipDialog;
  
  public BindMobileVerifyUI()
  {
    AppMethodBeat.i(109961);
    this.tipDialog = null;
    this.ihv = Integer.valueOf(15);
    AppMethodBeat.o(109961);
  }
  
  private void aIa()
  {
    AppMethodBeat.i(109966);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    AppMethodBeat.o(109966);
  }
  
  public int getLayoutId()
  {
    return 2131493182;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109965);
    this.dpO = ((String)com.tencent.mm.kernel.g.afB().afk().get(4097, null));
    this.igP = ((EditText)findViewById(2131297252));
    this.iht = ((TextView)findViewById(2131297251));
    this.ihu = ((TextView)findViewById(2131297246));
    Object localObject = (Button)findViewById(2131297249);
    if ((this.dpO == null) || (this.dpO.equals(""))) {
      this.dpO = ((String)com.tencent.mm.kernel.g.afB().afk().get(6, null));
    }
    if ((this.dpO != null) && (this.dpO.length() > 0))
    {
      this.iht.setVisibility(0);
      this.iht.setText(this.dpO);
    }
    InputFilter local1 = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(109954);
        paramAnonymousCharSequence = bt.aj(paramAnonymousCharSequence);
        AppMethodBeat.o(109954);
        return paramAnonymousCharSequence;
      }
    };
    this.igP.setFilters(new InputFilter[] { local1 });
    this.igR = ((Button)findViewById(2131297254));
    ((Button)localObject).setVisibility(8);
    this.ihu.setText(getResources().getQuantityString(2131623957, this.ihv.intValue(), new Object[] { this.ihv }));
    if (this.mTimer == null)
    {
      this.mTimer = new Timer();
      localObject = new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(109959);
          if (BindMobileVerifyUI.c(BindMobileVerifyUI.this) != null) {
            BindMobileVerifyUI.d(BindMobileVerifyUI.this);
          }
          AppMethodBeat.o(109959);
        }
      };
      if (this.mTimer != null) {
        this.mTimer.schedule((TimerTask)localObject, 1000L, 1000L);
      }
    }
    addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109956);
        paramAnonymousMenuItem = BindMobileVerifyUI.a(BindMobileVerifyUI.this).getText().toString().trim();
        if (paramAnonymousMenuItem.equals(""))
        {
          h.j(BindMobileVerifyUI.this, 2131756515, 2131755906);
          AppMethodBeat.o(109956);
          return true;
        }
        BindMobileVerifyUI.this.hideVKB();
        Object localObject1 = new iv();
        ((iv)localObject1).dmO.context = BindMobileVerifyUI.this;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((iv)localObject1).dmP.dmQ;
        Object localObject2 = new iw();
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject2 = ((iw)localObject2).dmR.dmS;
        paramAnonymousMenuItem = new z(BindMobileVerifyUI.b(BindMobileVerifyUI.this), 2, paramAnonymousMenuItem, "", (String)localObject1, (String)localObject2);
        com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem, 0);
        localObject1 = BindMobileVerifyUI.this;
        localObject2 = BindMobileVerifyUI.this;
        BindMobileVerifyUI.this.getString(2131755906);
        BindMobileVerifyUI.a((BindMobileVerifyUI)localObject1, h.b((Context)localObject2, BindMobileVerifyUI.this.getString(2131756503), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(109955);
            com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem);
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
    localObject = this.igR;
    if (com.tencent.mm.ax.b.yJ(this.dpO)) {}
    for (int i = 0;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      this.igR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109958);
          BindMobileVerifyUI.this.hideVKB();
          paramAnonymousView = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("bindmcontact_mobile", BindMobileVerifyUI.b(BindMobileVerifyUI.this));
          localBundle.putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras(localBundle);
          com.tencent.mm.plugin.account.a.a.hYt.f(BindMobileVerifyUI.this, paramAnonymousView);
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
    com.tencent.mm.kernel.g.aeS().a(132, this);
    setMMTitle(2131756490);
    this.ihc = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.ihd = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.ihe = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.ihf = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    initView();
    AppMethodBeat.o(109962);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109963);
    com.tencent.mm.kernel.g.aeS().b(132, this);
    super.onDestroy();
    AppMethodBeat.o(109963);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109967);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Xo(1);
      AppMethodBeat.o(109967);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109967);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = true;
    AppMethodBeat.i(109968);
    ad.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((z)paramn).JJ() != 2)
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
      if (((z)paramn).JJ() == 2) {}
      switch (this.fromScene)
      {
      default: 
        if ((this.fromScene == 0) || (this.fromScene == 3)) {
          ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        }
        paramString = new Intent(this, BindMobileStatusUI.class);
        paramString.putExtra("kstyle_bind_wording", this.ihc);
        paramString.putExtra("kstyle_bind_recommend_show", this.ihd);
        paramString.putExtra("Kfind_friend_by_mobile_flag", this.ihe);
        paramString.putExtra("Krecom_friends_by_mobile_flag", this.ihf);
        paramString.putExtra("bind_scene", this.fromScene);
        V(this, paramString);
        AppMethodBeat.o(109968);
        return;
      case 1: 
        if (!u.aqP())
        {
          paramString = new wf();
          paramString.dBG.dBH = true;
          paramString.dBG.dBI = true;
          com.tencent.mm.sdk.b.a.ESL.l(paramString);
        }
        Xo(1);
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.account.a.a.hYt.e(this, paramString);
        AppMethodBeat.o(109968);
        return;
      }
      boolean bool1;
      if (!this.ihe)
      {
        bool1 = true;
        if (this.ihf) {
          break label371;
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
        label371:
        bool2 = false;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
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
        Toast.makeText(this, 2131756462, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131756459, 0).show();
        i = 1;
        break;
      case -214: 
        paramString = com.tencent.mm.h.a.oG(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131756461, 0).show();
        i = 1;
        break;
      case -35: 
        Toast.makeText(this, 2131756460, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131756464, 0).show();
        i = 1;
        break;
      case -32: 
        h.a(this, 2131756509, 2131756514, null);
        i = 1;
        break;
      case -33: 
        h.a(this, 2131756508, 2131756514, null);
        i = 1;
      }
    }
    Toast.makeText(this, getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(109968);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109964);
    aIa();
    super.onStop();
    AppMethodBeat.o(109964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */