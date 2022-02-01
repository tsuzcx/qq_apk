package com.tencent.mm.plugin.account.ui;

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
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.o;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String hFb;
  private String hPy;
  private String nickName;
  private String qaC;
  private String qaD;
  private h qaG;
  private ProgressDialog qaH;
  private int qaI;
  private Button qaJ;
  private MTimerHandler qaM;
  private int qaN;
  private String qaf;
  private pu qbY;
  private String qcu;
  private int qdn;
  private int qdp;
  private boolean qeQ;
  private SecurityImage qeT;
  private String qeg;
  private Button qfE;
  
  public RegByMobileSendSmsUI()
  {
    AppMethodBeat.i(128577);
    this.qaC = "";
    this.qaf = "";
    this.qaD = "";
    this.qcu = "";
    this.qaN = 15;
    this.qbY = new pu();
    AppMethodBeat.o(128577);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.q Tt(String paramString)
  {
    AppMethodBeat.i(128580);
    com.tencent.mm.pluginsdk.ui.span.q localq = new com.tencent.mm.pluginsdk.ui.span.q(paramString);
    Log.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    localq.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(r.d.HugersTextSize)), i, paramString.length(), 33);
    localq.setSpan(new ForegroundColorSpan(getResources().getColor(r.c.green_text_color)), i, paramString.length(), 33);
    AppMethodBeat.o(128580);
    return localq;
  }
  
  private static void bYr()
  {
    AppMethodBeat.i(304906);
    if (cj.onp)
    {
      cj.ono.Kc(z.bAM());
      cj.ono.g(z.bAM(), z.bBM());
      cj.onp = false;
    }
    AppMethodBeat.o(304906);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128585);
    k.a(this, getString(r.j.regbymobile_reg_quit_send_sms), "", new DialogInterface.OnClickListener()
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
    if (this.qaM != null) {
      this.qaM.stopTimer();
    }
    this.qfE.setText(r.j.regbymobile_reg_no_sim_send_sms_btn_title);
    this.qfE.setEnabled(true);
    AppMethodBeat.o(128584);
  }
  
  public int getLayoutId()
  {
    return r.g.mobile_send_sms_up;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128579);
    super.initView();
    ((TextView)findViewById(r.f.send_sms_tip)).setText(getString(r.j.regbymobile_reg_send_sms_tip, new Object[] { this.qaC }));
    ((TextView)findViewById(r.f.send_sms_content)).setText(Tt(getString(r.j.regbymobile_reg_send_sms_content, new Object[] { this.qaf })));
    ((TextView)findViewById(r.f.send_sms_to)).setText(Tt(getString(r.j.regbymobile_reg_send_sms_to, new Object[] { this.qaD })));
    this.qaJ = ((Button)findViewById(r.f.send_sms_btn));
    this.qfE = ((Button)findViewById(r.f.next_btn));
    if (Util.isNullOrNil(new String[] { this.qaC, this.qaD, this.qaf }))
    {
      this.qaJ.setEnabled(false);
      this.qfE.setEnabled(false);
      if (!Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.aPc())) {
        break label248;
      }
      this.qaJ.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(r.j.regbymobile_reg_send_sms_title);
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
      this.qfE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128562);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128562);
        }
      });
      break;
      label248:
      this.qaJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128570);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.SENDTO");
          ((Intent)localObject).setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.b(RegByMobileSendSmsUI.this)));
          ((Intent)localObject).putExtra("sms_body", RegByMobileSendSmsUI.c(RegByMobileSendSmsUI.this));
          try
          {
            paramAnonymousView = RegByMobileSendSmsUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegByMobileSendSmsUI.this.overridePendingTransition(r.a.slide_right_in, r.a.slide_left_out);
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
    this.qdn = getIntent().getIntExtra("key_reg_style", 1);
    this.qaC = Util.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.qaD = Util.nullAsNil(getIntent().getStringExtra("to_mobile"));
    this.qaf = Util.nullAsNil(getIntent().getStringExtra("verify_code"));
    this.qcu = Util.nullAsNil(getIntent().getStringExtra("regsession_id"));
    this.qeg = Util.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
    this.nickName = Util.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
    this.hPy = Util.nullAsNil(getIntent().getStringExtra("kintent_password"));
    this.qeQ = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.qdp = getIntent().getIntExtra("reg_3d_app_type", 0);
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
    com.tencent.mm.kernel.h.aZW().a(145, this);
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    AppMethodBeat.o(128581);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(128583);
    Log.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.qaH != null) {
      this.qaH.dismiss();
    }
    if ((paramp.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramp).bIO() == 15))
    {
      paramp = (com.tencent.mm.modelfriend.a)paramp;
      this.hFb = paramp.bIQ();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.qdn == 1)
        {
          com.tencent.mm.kernel.h.aZW().a(126, this);
          paramString = new w("", this.hPy, this.nickName, 0, "", this.qaC, "", "", this.hFb, 1, "", "", "", true, this.qeQ);
          paramString.OZ(this.qcu);
          paramString.Pa(this.qeg);
          paramString.wL(1);
          com.tencent.mm.kernel.h.aZW().a(paramString, 0);
          getString(r.j.app_tip);
          this.qaH = k.a(this, getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128572);
              com.tencent.mm.kernel.h.aZW().a(paramString);
              com.tencent.mm.kernel.h.aZW().b(126, RegByMobileSendSmsUI.this);
              AppMethodBeat.o(128572);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("regsetinfo_ticket", this.hFb);
        paramString.putExtra("regsetinfo_user", this.qaC);
        paramString.putExtra("regsession_id", this.qcu);
        paramString.putExtra("reg_3d_app_ticket", this.qeg);
        paramString.putExtra("reg_3d_app_type", this.qdp);
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("regsetinfo_ismobile", 4);
        paramString.putExtra("regsetinfo_NextControl", paramp.bIX());
        paramString.putExtra("key_reg_style", this.qdn);
        paramString.setClass(this, RegSetInfoUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -35)
      {
        stopTimer();
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        this.qbY.joN = this.qdp;
        this.qbY.ikE = 7L;
        this.qbY.bMH();
        if (paramString != null)
        {
          paramString.a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128573);
              com.tencent.mm.kernel.h.aZW().a(701, RegByMobileSendSmsUI.this);
              com.tencent.mm.kernel.h.aZW().a(252, RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramp.getUsername(), paramp.bIP());
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).joN = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).ikE = 8L;
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).bMH();
              AppMethodBeat.o(128573);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128583);
          return;
        }
        k.a(this, getString(r.j.bind_mcontact_already_bind_relogin), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128574);
            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramp.getUsername(), paramp.bIP());
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).joN = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).ikE = 8L;
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).bMH();
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
        paramString.putExtra("ticket", this.hFb);
        paramString.putExtra("moble", this.qaC);
        paramString.putExtra("regsession_id", this.qcu);
        paramString.putExtra("reg_3d_app_ticket", this.qeg);
        paramString.putExtra("reg_3d_app_type", this.qdp);
        paramString.putExtra("next_controll", paramp.bIX());
        paramString.putExtra("username", paramp.getUsername());
        paramString.putExtra("password", paramp.bIP());
        paramString.putExtra("nickname", paramp.bJd());
        paramString.putExtra("avatar_url", paramp.bJc());
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("kintent_hasavatar", this.qeQ);
        paramString.putExtra("kintent_nickname", this.nickName);
        paramString.putExtra("kintent_password", this.hPy);
        paramString.putExtra("key_reg_style", this.qdn);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if ((!Util.isNullOrNil(paramString)) && (this.qaI >= 4))
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128583);
          return;
        }
      }
      AppMethodBeat.o(128583);
      return;
    }
    if (paramp.getType() == 126)
    {
      final w localw = (w)paramp;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.qeT == null)
        {
          this.qeT = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, 0, localw.bMj(), localw.bMi(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128576);
              paramAnonymousDialogInterface = new w("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localw.bMi(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.OZ(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.Pa(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.wL(1);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              RegByMobileSendSmsUI localRegByMobileSendSmsUI = RegByMobileSendSmsUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileSendSmsUI.this.getContext();
              RegByMobileSendSmsUI.this.getString(r.j.app_tip);
              RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, k.a(localAppCompatActivity, RegByMobileSendSmsUI.this.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128575);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
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
            public final void bWF()
            {
              AppMethodBeat.i(128564);
              RegByMobileSendSmsUI.this.hideVKB();
              w localw = new w("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localw.bMi(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              localw.OZ(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              localw.Pa(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              localw.wL(1);
              com.tencent.mm.kernel.h.aZW().a(localw, 0);
              AppMethodBeat.o(128564);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.qeT.b(0, ((w)paramp).bMj(), ((w)paramp).bMi(), "");
        AppMethodBeat.o(128583);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.qaC;
        this.qbY.joN = this.qdp;
        this.qbY.ikE = 6L;
        this.qbY.bMH();
        com.tencent.mm.kernel.b.aZI();
        com.tencent.mm.kernel.b.fA(true);
        l.kK(1, 8);
        l.kK(1, 3);
        l.kK(1, 1);
        if (this.qeQ)
        {
          paramp = com.tencent.mm.loader.i.b.bmH() + "temp.avatar";
          String str = com.tencent.mm.loader.i.b.bmH() + "temp.avatar.hd";
          y.qn(paramp, str);
          y.deleteFile(paramp);
          BitmapUtil.createThumbNail(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramp, true);
          new o(this, com.tencent.mm.loader.i.b.bmH() + "temp.avatar", true).a(new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(128565);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localw.bMs());
              bg.okT.bc("login_user_name", paramString);
              y.deleteFile(com.tencent.mm.loader.i.b.bmH() + "temp.avatar");
              Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.h.baC();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.h.baC();
              com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              RegByMobileSendSmsUI.bYJ();
              AppMethodBeat.o(128565);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128566);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localw.bMs());
              bg.okT.bc("login_user_name", paramString);
              Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.h.baC();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.h.baC();
              com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              RegByMobileSendSmsUI.bYJ();
              AppMethodBeat.o(128566);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.hFb = localw.bMs();
        bg.okT.bc("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        bYr();
        com.tencent.mm.plugin.b.a.TA("RE900_100");
        paramString = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        paramString = paramString.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
        AppMethodBeat.o(128583);
        return;
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
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
    com.tencent.mm.kernel.h.aZW().b(145, this);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    AppMethodBeat.o(128582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */