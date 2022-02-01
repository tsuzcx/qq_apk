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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.ka.b;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.kb.a;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI
  extends MMWizardActivity
  implements i
{
  private String dSf;
  private int fromScene;
  private TextView kbG;
  private TextView kbH;
  private Integer kbI;
  private EditText kbd;
  private Button kbf;
  private BindWordingContent kbp;
  private int kbq;
  private boolean kbr;
  private boolean kbs;
  private Timer mTimer;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public BindMobileVerifyUI()
  {
    AppMethodBeat.i(109961);
    this.tipDialog = null;
    this.kbI = Integer.valueOf(15);
    AppMethodBeat.o(109961);
  }
  
  private void bnp()
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
    return 2131493228;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109965);
    this.dSf = ((String)g.aAh().azQ().get(4097, null));
    this.kbd = ((EditText)findViewById(2131297407));
    this.kbG = ((TextView)findViewById(2131297406));
    this.kbH = ((TextView)findViewById(2131297401));
    Object localObject = (Button)findViewById(2131297404);
    if ((this.dSf == null) || (this.dSf.equals(""))) {
      this.dSf = ((String)g.aAh().azQ().get(6, null));
    }
    if ((this.dSf != null) && (this.dSf.length() > 0))
    {
      this.kbG.setVisibility(0);
      this.kbG.setText(this.dSf);
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
    this.kbd.setFilters(new InputFilter[] { local1 });
    this.kbf = ((Button)findViewById(2131297409));
    ((Button)localObject).setVisibility(8);
    this.kbH.setText(getResources().getQuantityString(2131623957, this.kbI.intValue(), new Object[] { this.kbI }));
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
    addTextOptionMenu(0, getString(2131755916), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109956);
        paramAnonymousMenuItem = BindMobileVerifyUI.a(BindMobileVerifyUI.this).getText().toString().trim();
        if (paramAnonymousMenuItem.equals(""))
        {
          h.n(BindMobileVerifyUI.this, 2131756651, 2131755998);
          AppMethodBeat.o(109956);
          return true;
        }
        BindMobileVerifyUI.this.hideVKB();
        Object localObject1 = new ka();
        ((ka)localObject1).dOV.context = BindMobileVerifyUI.this;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = ((ka)localObject1).dOW.dOX;
        Object localObject2 = new kb();
        EventCenter.instance.publish((IEvent)localObject2);
        localObject2 = ((kb)localObject2).dOY.dOZ;
        paramAnonymousMenuItem = new com.tencent.mm.plugin.account.friend.a.z(BindMobileVerifyUI.b(BindMobileVerifyUI.this), 2, paramAnonymousMenuItem, "", (String)localObject1, (String)localObject2);
        g.azz().a(paramAnonymousMenuItem, 0);
        localObject1 = BindMobileVerifyUI.this;
        localObject2 = BindMobileVerifyUI.this;
        BindMobileVerifyUI.this.getString(2131755998);
        BindMobileVerifyUI.a((BindMobileVerifyUI)localObject1, h.a((Context)localObject2, BindMobileVerifyUI.this.getString(2131756639), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(109955);
            g.azz().a(paramAnonymousMenuItem);
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
    localObject = this.kbf;
    if (com.tencent.mm.aw.b.Pg(this.dSf)) {}
    for (int i = 0;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      this.kbf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109958);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          BindMobileVerifyUI.this.hideVKB();
          paramAnonymousView = new Intent();
          localObject = new Bundle();
          ((Bundle)localObject).putString("bindmcontact_mobile", BindMobileVerifyUI.b(BindMobileVerifyUI.this));
          ((Bundle)localObject).putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras((Bundle)localObject);
          com.tencent.mm.plugin.account.a.a.jRt.f(BindMobileVerifyUI.this, paramAnonymousView);
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
    g.azz().a(132, this);
    setMMTitle(2131756626);
    this.kbp = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.kbq = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.kbr = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.kbs = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    initView();
    AppMethodBeat.o(109962);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109963);
    g.azz().b(132, this);
    super.onDestroy();
    AppMethodBeat.o(109963);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109967);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ala(1);
      AppMethodBeat.o(109967);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109967);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(109968);
    Log.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((com.tencent.mm.plugin.account.friend.a.z)paramq).Vj() != 2)
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
      if (((com.tencent.mm.plugin.account.friend.a.z)paramq).Vj() == 2) {}
      switch (this.fromScene)
      {
      default: 
        if ((this.fromScene == 0) || (this.fromScene == 3)) {
          ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        }
        paramString = new Intent(this, BindMobileStatusUI.class);
        paramString.putExtra("kstyle_bind_wording", this.kbp);
        paramString.putExtra("kstyle_bind_recommend_show", this.kbq);
        paramString.putExtra("Kfind_friend_by_mobile_flag", this.kbr);
        paramString.putExtra("Krecom_friends_by_mobile_flag", this.kbs);
        paramString.putExtra("bind_scene", this.fromScene);
        ay(this, paramString);
        AppMethodBeat.o(109968);
        return;
      case 1: 
        if (!com.tencent.mm.model.z.aUi())
        {
          paramString = new yo();
          paramString.eeN.eeO = true;
          paramString.eeN.eeP = true;
          EventCenter.instance.publish(paramString);
        }
        ala(1);
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.account.a.a.jRt.e(this, paramString);
        AppMethodBeat.o(109968);
        return;
      }
      boolean bool1;
      if (!this.kbr)
      {
        bool1 = true;
        if (this.kbs) {
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
    if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
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
        Toast.makeText(this, 2131756598, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131756595, 0).show();
        i = 1;
        break;
      case -214: 
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131756597, 0).show();
        i = 1;
        break;
      case -35: 
        Toast.makeText(this, 2131756596, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131756600, 0).show();
        i = 1;
        break;
      case -32: 
        h.a(this, 2131756645, 2131756650, null);
        i = 1;
        break;
      case -33: 
        h.a(this, 2131756644, 2131756650, null);
        i = 1;
      }
    }
    Toast.makeText(this, getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(109968);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109964);
    bnp();
    super.onStop();
    AppMethodBeat.o(109964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */