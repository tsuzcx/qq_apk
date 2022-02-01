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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.jc.b;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.jd.a;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.g
{
  private String dnz;
  private int fromScene;
  private EditText iGY;
  private TextView iHB;
  private TextView iHC;
  private Integer iHD;
  private Button iHa;
  private BindWordingContent iHk;
  private int iHl;
  private boolean iHm;
  private boolean iHn;
  private Timer mTimer;
  private p tipDialog;
  
  public BindMobileVerifyUI()
  {
    AppMethodBeat.i(109961);
    this.tipDialog = null;
    this.iHD = Integer.valueOf(15);
    AppMethodBeat.o(109961);
  }
  
  private void aOR()
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
    this.dnz = ((String)com.tencent.mm.kernel.g.agR().agA().get(4097, null));
    this.iGY = ((EditText)findViewById(2131297252));
    this.iHB = ((TextView)findViewById(2131297251));
    this.iHC = ((TextView)findViewById(2131297246));
    Object localObject = (Button)findViewById(2131297249);
    if ((this.dnz == null) || (this.dnz.equals(""))) {
      this.dnz = ((String)com.tencent.mm.kernel.g.agR().agA().get(6, null));
    }
    if ((this.dnz != null) && (this.dnz.length() > 0))
    {
      this.iHB.setVisibility(0);
      this.iHB.setText(this.dnz);
    }
    InputFilter local1 = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(109954);
        paramAnonymousCharSequence = bs.ak(paramAnonymousCharSequence);
        AppMethodBeat.o(109954);
        return paramAnonymousCharSequence;
      }
    };
    this.iGY.setFilters(new InputFilter[] { local1 });
    this.iHa = ((Button)findViewById(2131297254));
    ((Button)localObject).setVisibility(8);
    this.iHC.setText(getResources().getQuantityString(2131623957, this.iHD.intValue(), new Object[] { this.iHD }));
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
          h.l(BindMobileVerifyUI.this, 2131756515, 2131755906);
          AppMethodBeat.o(109956);
          return true;
        }
        BindMobileVerifyUI.this.hideVKB();
        Object localObject1 = new jc();
        ((jc)localObject1).dkw.context = BindMobileVerifyUI.this;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((jc)localObject1).dkx.dky;
        Object localObject2 = new jd();
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject2 = ((jd)localObject2).dkz.dkA;
        paramAnonymousMenuItem = new z(BindMobileVerifyUI.b(BindMobileVerifyUI.this), 2, paramAnonymousMenuItem, "", (String)localObject1, (String)localObject2);
        com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem, 0);
        localObject1 = BindMobileVerifyUI.this;
        localObject2 = BindMobileVerifyUI.this;
        BindMobileVerifyUI.this.getString(2131755906);
        BindMobileVerifyUI.a((BindMobileVerifyUI)localObject1, h.b((Context)localObject2, BindMobileVerifyUI.this.getString(2131756503), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(109955);
            com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem);
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
    localObject = this.iHa;
    if (com.tencent.mm.aw.b.CO(this.dnz)) {}
    for (int i = 0;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      this.iHa.setOnClickListener(new View.OnClickListener()
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
          com.tencent.mm.plugin.account.a.a.iyx.f(BindMobileVerifyUI.this, paramAnonymousView);
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
    com.tencent.mm.kernel.g.agi().a(132, this);
    setMMTitle(2131756490);
    this.iHk = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.iHl = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.iHm = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.iHn = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    initView();
    AppMethodBeat.o(109962);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109963);
    com.tencent.mm.kernel.g.agi().b(132, this);
    super.onDestroy();
    AppMethodBeat.o(109963);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109967);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ZA(1);
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
    ac.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((z)paramn).Js() != 2)
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
      if (((z)paramn).Js() == 2) {}
      switch (this.fromScene)
      {
      default: 
        if ((this.fromScene == 0) || (this.fromScene == 3)) {
          ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        }
        paramString = new Intent(this, BindMobileStatusUI.class);
        paramString.putExtra("kstyle_bind_wording", this.iHk);
        paramString.putExtra("kstyle_bind_recommend_show", this.iHl);
        paramString.putExtra("Kfind_friend_by_mobile_flag", this.iHm);
        paramString.putExtra("Krecom_friends_by_mobile_flag", this.iHn);
        paramString.putExtra("bind_scene", this.fromScene);
        aj(this, paramString);
        AppMethodBeat.o(109968);
        return;
      case 1: 
        if (!u.axF())
        {
          paramString = new wq();
          paramString.dzu.dzv = true;
          paramString.dzu.dzw = true;
          com.tencent.mm.sdk.b.a.GpY.l(paramString);
        }
        ZA(1);
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.account.a.a.iyx.e(this, paramString);
        AppMethodBeat.o(109968);
        return;
      }
      boolean bool1;
      if (!this.iHm)
      {
        bool1 = true;
        if (this.iHn) {
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
    if (com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString)) {
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
        paramString = com.tencent.mm.h.a.rM(paramString);
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
    aOR();
    super.onStop();
    AppMethodBeat.o(109964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */