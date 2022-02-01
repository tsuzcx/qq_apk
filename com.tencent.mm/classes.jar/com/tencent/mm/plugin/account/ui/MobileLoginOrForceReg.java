package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.o;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.network.d;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;

public class MobileLoginOrForceReg
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String hFb;
  private String hRk;
  private MMHandler handler;
  private String idu;
  private ImageView lBC;
  private TextView lBD;
  protected ProgressDialog lzP;
  private String nVM;
  private String nickname;
  private int oTc;
  private TextView pPe;
  private SecurityImage pRw;
  private f pZh;
  private com.tencent.mm.platformtools.b pZq;
  private IListener pZz;
  private h qaG;
  private pu qbY;
  private String qcu;
  private Button qdb;
  private Button qdc;
  private LinearLayout qdd;
  private LinearLayout qde;
  private int qdf;
  private String qdg;
  private int qdh;
  private String qdi;
  private boolean qdj;
  private boolean qdk;
  private String qdl;
  private String qdm;
  private int qdn;
  private String qdo;
  private int qdp;
  private String username;
  
  public MobileLoginOrForceReg()
  {
    AppMethodBeat.i(128395);
    this.lzP = null;
    this.qaG = null;
    this.qdj = true;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(128377);
        if (paramAnonymousMessage.obj != null)
        {
          paramAnonymousMessage = (Bitmap)paramAnonymousMessage.obj;
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this).setImageBitmap(paramAnonymousMessage);
        }
        AppMethodBeat.o(128377);
      }
    };
    this.pRw = null;
    this.qbY = new pu();
    this.pZz = new MobileLoginOrForceReg.2(this, com.tencent.mm.app.f.hfK);
    this.pZh = null;
    AppMethodBeat.o(128395);
  }
  
  private static void bYr()
  {
    AppMethodBeat.i(305000);
    if (cj.onp)
    {
      cj.ono.Kc(z.bAM());
      cj.ono.g(z.bAM(), z.bBM());
      cj.onp = false;
    }
    AppMethodBeat.o(305000);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128401);
    com.tencent.mm.plugin.b.a.TA("R200_100");
    if (this.qdn == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.b.a.Tz(this.qdi);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R200_600") + ",2");
      finish();
      AppMethodBeat.o(128401);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return r.g.mobile_login_or_force_reg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128397);
    this.qdb = ((Button)findViewById(r.f.continue_login));
    this.qdc = ((Button)findViewById(r.f.force_reg));
    this.qdd = ((LinearLayout)findViewById(r.f.has_avatar));
    this.qde = ((LinearLayout)findViewById(r.f.no_avatar));
    this.lBC = ((ImageView)findViewById(r.f.avatar_iv));
    this.lBD = ((TextView)findViewById(r.f.nickname_tv));
    this.pPe = ((TextView)findViewById(r.f.bind_mcontact_verify_hint));
    Object localObject = new PhoneFormater();
    if (this.hRk.startsWith("+"))
    {
      String str1 = PhoneFormater.extractCountryCode(this.hRk);
      if (!Util.isNullOrNil(str1))
      {
        String str2 = this.hRk.substring(str1.length() + 1);
        localObject = "+" + str1 + " " + ((PhoneFormater)localObject).formatNumber(str1, str2);
      }
    }
    for (;;)
    {
      this.pPe.setText((CharSequence)localObject);
      if ((!Util.isNullOrNil(this.nickname)) || (!Util.isNullOrNil(this.nVM))) {
        break;
      }
      this.qde.setVisibility(0);
      this.qdd.setVisibility(8);
      this.qdb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128388);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, new h(new h.a()
          {
            public final void b(ProgressDialog paramAnonymous2ProgressDialog)
            {
              MobileLoginOrForceReg.this.lzP = paramAnonymous2ProgressDialog;
            }
          }, MobileLoginOrForceReg.c(MobileLoginOrForceReg.this), MobileLoginOrForceReg.d(MobileLoginOrForceReg.this), MobileLoginOrForceReg.e(MobileLoginOrForceReg.this)));
          MobileLoginOrForceReg.f(MobileLoginOrForceReg.this).d(MobileLoginOrForceReg.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128388);
        }
      });
      this.qdc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128389);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (Util.isNullOrNil(MobileLoginOrForceReg.g(MobileLoginOrForceReg.this)))
          {
            localObject = new Intent();
            com.tencent.mm.plugin.b.a.TA("R200_900_phone");
            ((Intent)localObject).putExtra("regsetinfo_ticket", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("regsetinfo_user", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("regsetinfo_pwd", MobileLoginOrForceReg.d(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("regsetinfo_ismobile", 4);
            ((Intent)localObject).putExtra("regsetinfo_isForce", true);
            ((Intent)localObject).putExtra("regsession_id", MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("reg_3d_app_ticket", MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("reg_3d_app_type", MobileLoginOrForceReg.k(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("regsetinfo_NextControl", MobileLoginOrForceReg.l(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("mobile_check_type", MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("key_reg_style", MobileLoginOrForceReg.n(MobileLoginOrForceReg.this));
            ((Intent)localObject).setClass(MobileLoginOrForceReg.this, RegSetInfoUI.class);
            paramAnonymousView = MobileLoginOrForceReg.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128389);
            return;
            MobileLoginOrForceReg.o(MobileLoginOrForceReg.this);
          }
        }
      });
      setMMTitle(r.j.mobile_input_already_bind_title_welcome_back);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128390);
          MobileLoginOrForceReg.p(MobileLoginOrForceReg.this);
          AppMethodBeat.o(128390);
          return false;
        }
      });
      AppMethodBeat.o(128397);
      return;
      localObject = this.hRk;
      continue;
      localObject = "+86 " + ((PhoneFormater)localObject).formatNumber("86", this.hRk);
    }
    this.qde.setVisibility(8);
    this.qdd.setVisibility(0);
    if (Util.isNullOrNil(this.nickname)) {
      this.lBD.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.iKa().aCj();
      if (localObject != null) {
        this.lBC.setImageBitmap((Bitmap)localObject);
      }
      if (Util.isNullOrNil(this.nVM)) {
        break;
      }
      localObject = this.nVM;
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128386);
          Object localObject = null;
          try
          {
            Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(d.A(this.val$url, 10000, 20000));
            localObject = localBitmap;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
              Log.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", localException, "", new Object[0]);
            }
          }
          MobileLoginOrForceReg.b(MobileLoginOrForceReg.this).sendMessage(MobileLoginOrForceReg.b(MobileLoginOrForceReg.this).obtainMessage(0, localObject));
          AppMethodBeat.o(128386);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(128387);
          String str = super.toString() + "|loadBitmap";
          AppMethodBeat.o(128387);
          return str;
        }
      });
      break;
      this.lBD.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128396);
    super.onCreate(paramBundle);
    this.qdi = com.tencent.mm.plugin.b.a.chY();
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    com.tencent.mm.kernel.h.aZW().a(126, this);
    com.tencent.mm.kernel.h.aZW().a(255, this);
    this.qdn = getIntent().getIntExtra("key_reg_style", 1);
    this.hFb = getIntent().getStringExtra("ticket");
    this.hRk = getIntent().getStringExtra("moble");
    this.qdf = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.qdg = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.nVM = getIntent().getStringExtra("avatar_url");
    this.qcu = getIntent().getStringExtra("regsession_id");
    this.qdo = getIntent().getStringExtra("reg_3d_app_ticket");
    this.qdp = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.qdh = getIntent().getIntExtra("mobile_check_type", 0);
    this.qdk = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.qdl = getIntent().getStringExtra("kintent_nickname");
    this.qdm = getIntent().getStringExtra("kintent_password");
    if ((this.qdm != null) && (this.qdm.length() >= 8)) {}
    for (this.oTc = 1;; this.oTc = 4)
    {
      initView();
      this.pZq = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128396);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128400);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(126, this);
    com.tencent.mm.kernel.h.aZW().b(255, this);
    if (this.pZq != null) {
      this.pZq.close();
    }
    super.onDestroy();
    AppMethodBeat.o(128400);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128402);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(128402);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128402);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128399);
    super.onPause();
    this.pZz.dead();
    AppMethodBeat.o(128399);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128398);
    this.pZz.alive();
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.Tz("R200_600");
    AppMethodBeat.o(128398);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(128403);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if (this.pZh == null) {
      this.pZh = new f();
    }
    boolean bool;
    if (paramp.getType() == 255)
    {
      if ((paramInt2 == -3) && (paramInt1 == 4))
      {
        bool = this.qdj;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(r.j.settings_modify_password_tip));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      AppMethodBeat.o(128403);
      return;
    }
    if (((paramp.getType() == 252) || (paramp.getType() == 701)) && (this.qaG != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.pZh.account = this.username;
        this.pZh.qbn = this.qdm;
        this.pZh.pRz = ((u)paramp).bMi();
        this.pZh.pRy = ((u)paramp).bMj();
        this.pZh.pRA = ((u)paramp).bMk();
        this.pZh.qbo = ((u)paramp).getSecCodeType();
        if (this.pRw == null)
        {
          this.pRw = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128392);
              Log.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).pRz + " img len" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
              paramAnonymousDialogInterface = new u(MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).account, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).qbn, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).qbo, MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgSid(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              MobileLoginOrForceReg.this.getString(r.j.app_tip);
              k.a(localMobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128391);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128391);
                }
              });
              AppMethodBeat.o(128392);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128393);
              MobileLoginOrForceReg.s(MobileLoginOrForceReg.this);
              AppMethodBeat.o(128393);
            }
          }, this.pZh);
          AppMethodBeat.o(128403);
          return;
        }
        this.pRw.b(this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA);
        AppMethodBeat.o(128403);
        return;
      }
      this.idu = ((u)paramp).bMh();
      this.qaG.a(this, paramInt1, paramInt2, paramString, paramp);
      if ((paramp instanceof u)) {
        this.qdj = ((u)paramp).bMr();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new com.tencent.mm.modelsimple.v(1);
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        getString(r.j.app_tip);
        this.lzP = k.a(this, getString(r.j.app_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128394);
            com.tencent.mm.kernel.h.aZW().a(paramString);
            AppMethodBeat.o(128394);
          }
        });
        if (!Util.isNullOrNil(this.qdo)) {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acYY, Integer.valueOf(this.qdp));
        }
      }
      AppMethodBeat.o(128403);
      return;
    }
    Object localObject2;
    if (paramp.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = Boolean.valueOf(this.qdk);
        localObject1 = this.qdm;
        localObject2 = this.qdl;
        if (this.pRw == null)
        {
          this.pRw = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, 0, ((w)paramp).bMj(), ((w)paramp).bMi(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128379);
              paramAnonymousDialogInterface = new w("", this.qdr, this.qds, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((w)paramp).bMi(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.OZ(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.Pa(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.wL(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              AppCompatActivity localAppCompatActivity = MobileLoginOrForceReg.this.getContext();
              MobileLoginOrForceReg.this.getString(r.j.app_tip);
              localMobileLoginOrForceReg.lzP = k.a(localAppCompatActivity, MobileLoginOrForceReg.this.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128378);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128378);
                }
              });
              AppMethodBeat.o(128379);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128380);
              MobileLoginOrForceReg.s(MobileLoginOrForceReg.this);
              AppMethodBeat.o(128380);
            }
          }, new SecurityImage.b()
          {
            public final void bWF()
            {
              AppMethodBeat.i(128381);
              MobileLoginOrForceReg.this.hideVKB();
              w localw = new w("", this.qdr, this.qds, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((w)paramp).bMi(), "", true, paramString.booleanValue());
              localw.OZ(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              localw.Pa(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              localw.wL(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.h.aZW().a(localw, 0);
              AppMethodBeat.o(128381);
            }
          });
          AppMethodBeat.o(128403);
          return;
        }
        this.pRw.b(0, ((w)paramp).bMj(), ((w)paramp).bMi(), "");
        AppMethodBeat.o(128403);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.hRk;
        bool = this.qdk;
        this.qbY.joN = this.qdp;
        this.qbY.ikE = 6L;
        this.qbY.bMH();
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.kernel.b.aZI();
        com.tencent.mm.kernel.b.fA(true);
        l.kK(1, 8);
        l.kK(1, 3);
        l.kK(1, 1);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label932;
        }
        localObject2 = com.tencent.mm.loader.i.b.bmH() + "temp.avatar";
        String str = com.tencent.mm.loader.i.b.bmH() + "temp.avatar.hd";
        y.qn((String)localObject2, str);
        y.deleteFile((String)localObject2);
        BitmapUtil.createThumbNail(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject2, true);
        new o(this, com.tencent.mm.loader.i.b.bmH() + "temp.avatar", true).a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128382);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((w)paramp).bMs());
            bg.okT.bc("login_user_name", this.qdw);
            y.deleteFile(com.tencent.mm.loader.i.b.bmH() + "temp.avatar");
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.baC();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.h.baC();
            com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
            MobileLoginOrForceReg.bYs();
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128382);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128383);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((w)paramp).bMs());
            bg.okT.bc("login_user_name", this.qdw);
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.baC();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.h.baC();
            com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
            MobileLoginOrForceReg.bYs();
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128383);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.broadcast.a.CH(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.broadcast.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128403);
        return;
        label932:
        this.hFb = ((w)paramp).bMs();
        bg.okT.bc("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        bYr();
        finish();
        com.tencent.mm.plugin.b.a.TA("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
      }
    }
    Object localObject1 = new aa(paramInt1, paramInt2, paramString);
    int i;
    if (this.pZq.a(this, (aa)localObject1)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128403);
      return;
      i = 0;
      switch (paramInt2)
      {
      default: 
        break;
      case -2023: 
      case -100: 
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.kernel.b.aZH();
        localObject2 = getContext();
        com.tencent.mm.kernel.h.baC();
        if (!TextUtils.isEmpty(com.tencent.mm.kernel.b.aZu())) {}
      case -34: 
      case -43: 
      case -41: 
      case -36: 
      case -32: 
      case -33: 
      case -75: 
        for (localObject1 = com.tencent.mm.cd.a.bt(getContext(), r.j.main_err_another_place);; localObject1 = com.tencent.mm.kernel.b.aZu())
        {
          k.a((Context)localObject2, (String)localObject1, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
          Toast.makeText(this, r.j.bind_mcontact_err_freq_limit, 0).show();
          i = 1;
          break;
          Toast.makeText(this, r.j.bind_mcontact_err_binded, 0).show();
          i = 1;
          break;
          Toast.makeText(this, r.j.bind_mcontact_err_format, 0).show();
          i = 1;
          break;
          Toast.makeText(this, r.j.bind_mcontact_err_unbinded_notbinded, 0).show();
          i = 1;
          break;
          k.d(this, getString(r.j.bind_mcontact_verify_error), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          break;
          k.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          break;
          k.s(this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
          i = 1;
          break;
          com.tencent.mm.kernel.h.baC();
        }
      case -140: 
        if (!Util.isNullOrNil(this.idu)) {
          com.tencent.mm.platformtools.v.r(getContext(), paramString, this.idu);
        }
        i = 1;
      }
    }
    if ((paramp.getType() == 252) || (paramp.getType() == 701))
    {
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramString != null) && (paramString.a(getContext(), null, null)))
      {
        AppMethodBeat.o(128403);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(getContext(), getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg
 * JD-Core Version:    0.7.0.1
 */