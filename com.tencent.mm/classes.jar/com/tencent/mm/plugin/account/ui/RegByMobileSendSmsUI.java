package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.n;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.s;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements i
{
  private int countDown;
  private String dHx;
  private String dQC;
  private ka kkY;
  private String kkz;
  private ProgressDialog klA;
  private int klB;
  private Button klC;
  private MTimerHandler klF;
  private String klr;
  private String kls;
  private h klz;
  private String knu;
  private int kon;
  private int kop;
  private boolean kpI;
  private SecurityImage kpL;
  private String kph;
  private Button kqx;
  private String nickName;
  
  public RegByMobileSendSmsUI()
  {
    AppMethodBeat.i(128577);
    this.klr = "";
    this.kkz = "";
    this.kls = "";
    this.knu = "";
    this.countDown = 15;
    this.kkY = new ka();
    AppMethodBeat.o(128577);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.m Tr(String paramString)
  {
    AppMethodBeat.i(128580);
    com.tencent.mm.pluginsdk.ui.span.m localm = new com.tencent.mm.pluginsdk.ui.span.m(paramString);
    Log.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    localm.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(2131165485)), i, paramString.length(), 33);
    localm.setSpan(new ForegroundColorSpan(getResources().getColor(2131100566)), i, paramString.length(), 33);
    AppMethodBeat.o(128580);
    return localm;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128585);
    com.tencent.mm.ui.base.h.a(this, getString(2131764398), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128569);
        RegByMobileSendSmsUI.t(RegByMobileSendSmsUI.this);
        RegByMobileSendSmsUI.this.finish();
        AppMethodBeat.o(128569);
      }
    }, null);
    AppMethodBeat.o(128585);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(128584);
    if (this.klF != null) {
      this.klF.stopTimer();
    }
    this.kqx.setText(2131764396);
    this.kqx.setEnabled(true);
    AppMethodBeat.o(128584);
  }
  
  public int getLayoutId()
  {
    return 2131495677;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128579);
    super.initView();
    ((TextView)findViewById(2131307629)).setText(getString(2131764402, new Object[] { this.klr }));
    ((TextView)findViewById(2131307626)).setText(Tr(getString(2131764401, new Object[] { this.kkz })));
    ((TextView)findViewById(2131307630)).setText(Tr(getString(2131764404, new Object[] { this.kls })));
    this.klC = ((Button)findViewById(2131307625));
    this.kqx = ((Button)findViewById(2131305423));
    if (Util.isNullOrNil(new String[] { this.klr, this.kls, this.kkz }))
    {
      this.klC.setEnabled(false);
      this.kqx.setEnabled(false);
      if (!Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso())) {
        break label248;
      }
      this.klC.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(2131764403);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128571);
          RegByMobileSendSmsUI.d(RegByMobileSendSmsUI.this);
          AppMethodBeat.o(128571);
          return true;
        }
      });
      AppMethodBeat.o(128579);
      return;
      this.kqx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128562);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128562);
        }
      });
      break;
      label248:
      this.klC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128570);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.SENDTO");
          ((Intent)localObject).setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.b(RegByMobileSendSmsUI.this)));
          ((Intent)localObject).putExtra("sms_body", RegByMobileSendSmsUI.c(RegByMobileSendSmsUI.this));
          try
          {
            paramAnonymousView = RegByMobileSendSmsUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegByMobileSendSmsUI.this.overridePendingTransition(2130772169, 2130772166);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128570);
            return;
          }
          catch (Exception paramAnonymousView)
          {
            for (;;)
            {
              Log.e("MicroMsg.RegByMobileSendSmsUI", paramAnonymousView.getMessage());
            }
          }
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128578);
    super.onCreate(paramBundle);
    this.kon = getIntent().getIntExtra("key_reg_style", 1);
    this.klr = Util.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.kls = Util.nullAsNil(getIntent().getStringExtra("to_mobile"));
    this.kkz = Util.nullAsNil(getIntent().getStringExtra("verify_code"));
    this.knu = Util.nullAsNil(getIntent().getStringExtra("regsession_id"));
    this.kph = Util.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
    this.nickName = Util.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
    this.dQC = Util.nullAsNil(getIntent().getStringExtra("kintent_password"));
    this.kpI = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(128578);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128586);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(128586);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128586);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128581);
    super.onResume();
    g.azz().a(145, this);
    g.azz().a(701, this);
    g.azz().a(252, this);
    AppMethodBeat.o(128581);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128583);
    Log.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.klA != null) {
      this.klA.dismiss();
    }
    if ((paramq.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramq).Vj() == 15))
    {
      paramq = (com.tencent.mm.modelfriend.a)paramq;
      this.dHx = paramq.bbG();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.kon == 1)
        {
          g.azz().a(126, this);
          paramString = new v("", this.dQC, this.nickName, 0, "", this.klr, "", "", this.dHx, 1, "", "", "", true, this.kpI);
          paramString.PB(this.knu);
          paramString.PC(this.kph);
          paramString.tL(1);
          g.azz().a(paramString, 0);
          getString(2131755998);
          this.klA = com.tencent.mm.ui.base.h.a(this, getString(2131764451), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128572);
              g.azz().a(paramString);
              g.azz().b(126, RegByMobileSendSmsUI.this);
              AppMethodBeat.o(128572);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("regsetinfo_ticket", this.dHx);
        paramString.putExtra("regsetinfo_user", this.klr);
        paramString.putExtra("regsession_id", this.knu);
        paramString.putExtra("reg_3d_app_ticket", this.kph);
        paramString.putExtra("reg_3d_app_type", this.kop);
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("regsetinfo_ismobile", 4);
        paramString.putExtra("regsetinfo_NextControl", paramq.bbN());
        paramString.putExtra("key_reg_style", this.kon);
        paramString.setClass(this, RegSetInfoUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -35)
      {
        stopTimer();
        paramString = com.tencent.mm.h.a.Dk(paramString);
        this.kkY.eTd = this.kop;
        this.kkY.ejA = 7L;
        this.kkY.bfK();
        if (paramString != null)
        {
          paramString.a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128573);
              g.azz().a(701, RegByMobileSendSmsUI.this);
              g.azz().a(252, RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramq.getUsername(), paramq.bbF());
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).eTd = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).ejA = 8L;
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).bfK();
              AppMethodBeat.o(128573);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128583);
          return;
        }
        com.tencent.mm.ui.base.h.a(this, getString(2131756580), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128574);
            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramq.getUsername(), paramq.bbF());
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).eTd = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).ejA = 8L;
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).bfK();
            AppMethodBeat.o(128574);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -212)
      {
        stopTimer();
        paramString = new Intent(this, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", this.dHx);
        paramString.putExtra("moble", this.klr);
        paramString.putExtra("regsession_id", this.knu);
        paramString.putExtra("reg_3d_app_ticket", this.kph);
        paramString.putExtra("reg_3d_app_type", this.kop);
        paramString.putExtra("next_controll", paramq.bbN());
        paramString.putExtra("username", paramq.getUsername());
        paramString.putExtra("password", paramq.bbF());
        paramString.putExtra("nickname", paramq.bbT());
        paramString.putExtra("avatar_url", paramq.bbS());
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("kintent_hasavatar", this.kpI);
        paramString.putExtra("kintent_nickname", this.nickName);
        paramString.putExtra("kintent_password", this.dQC);
        paramString.putExtra("key_reg_style", this.kon);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if ((!Util.isNullOrNil(paramString)) && (this.klB >= 4))
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128583);
          return;
        }
      }
      AppMethodBeat.o(128583);
      return;
    }
    if (paramq.getType() == 126)
    {
      final v localv = (v)paramq;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.kpL == null)
        {
          this.kpL = SecurityImage.a.a(this, 0, localv.bfm(), localv.bfl(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128576);
              paramAnonymousDialogInterface = new v("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localv.bfl(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.PB(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.PC(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.tL(1);
              g.azz().a(paramAnonymousDialogInterface, 0);
              RegByMobileSendSmsUI localRegByMobileSendSmsUI = RegByMobileSendSmsUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileSendSmsUI.this.getContext();
              RegByMobileSendSmsUI.this.getString(2131755998);
              RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, RegByMobileSendSmsUI.this.getString(2131764451), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128575);
                  g.azz().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128575);
                }
              }));
              AppMethodBeat.o(128576);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128563);
              RegByMobileSendSmsUI.o(RegByMobileSendSmsUI.this);
              AppMethodBeat.o(128563);
            }
          }, new SecurityImage.b()
          {
            public final void bnH()
            {
              AppMethodBeat.i(128564);
              RegByMobileSendSmsUI.this.hideVKB();
              v localv = new v("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localv.bfl(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              localv.PB(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              localv.PC(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              localv.tL(1);
              g.azz().a(localv, 0);
              AppMethodBeat.o(128564);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.kpL.b(0, ((v)paramq).bfm(), ((v)paramq).bfl(), "");
        AppMethodBeat.o(128583);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.klr;
        this.kkY.eTd = this.kop;
        this.kkY.ejA = 6L;
        this.kkY.bfK();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.es(true);
        if (this.kpI)
        {
          paramq = com.tencent.mm.loader.j.b.aKR() + "temp.avatar";
          String str = com.tencent.mm.loader.j.b.aKR() + "temp.avatar.hd";
          s.nx(paramq, str);
          s.deleteFile(paramq);
          BitmapUtil.createThumbNail(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramq, true);
          new n(this, com.tencent.mm.loader.j.b.aKR() + "temp.avatar").a(new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(128565);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localv.bfv());
              bf.iDu.aO("login_user_name", paramString);
              s.deleteFile(com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
              Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              g.aAf();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
              g.aAf();
              com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128565);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128566);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localv.bfv());
              bf.iDu.aO("login_user_name", paramString);
              Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              g.aAf();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
              g.aAf();
              com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128566);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.dHx = localv.bfv();
        bf.iDu.aO("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.bwV("RE900_100");
        paramString = new StringBuilder();
        g.aAf();
        paramString = paramString.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R200_600") + ",4");
        AppMethodBeat.o(128583);
        return;
      }
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(128583);
        return;
      }
    }
    AppMethodBeat.o(128583);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128582);
    super.onStop();
    stopTimer();
    g.azz().b(145, this);
    g.azz().b(701, this);
    g.azz().b(252, this);
    AppMethodBeat.o(128582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */