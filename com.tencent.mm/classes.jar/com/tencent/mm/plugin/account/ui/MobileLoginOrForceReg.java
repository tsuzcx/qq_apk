package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.n;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.network.d;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.s;

public class MobileLoginOrForceReg
  extends MMActivity
  implements i
{
  private String dHx;
  private String dSf;
  private String edo;
  protected ProgressDialog gtM;
  private ImageView gvv;
  private TextView gvw;
  private MMHandler handler;
  private int jkp;
  private TextView kbe;
  private SecurityImage kdp;
  private IListener kkK;
  private ka kkY;
  private g klt;
  private h klz;
  private com.tencent.mm.platformtools.b kmf;
  private String knu;
  private Button koa;
  private Button kob;
  private LinearLayout koc;
  private LinearLayout kod;
  private int koe;
  private String kof;
  private String kog;
  private int koh;
  private String koi;
  private boolean koj;
  private boolean kok;
  private String kol;
  private String kom;
  private int kon;
  private String koo;
  private int kop;
  private String nickname;
  private String username;
  
  public MobileLoginOrForceReg()
  {
    AppMethodBeat.i(128395);
    this.gtM = null;
    this.klz = null;
    this.koj = true;
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
    this.kdp = null;
    this.kkY = new ka();
    this.kkK = new MobileLoginOrForceReg.12(this);
    this.klt = null;
    AppMethodBeat.o(128395);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128401);
    com.tencent.mm.plugin.b.a.bwV("R200_100");
    if (this.kon == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.b.a.bwU(this.koi);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R200_600") + ",2");
      finish();
      AppMethodBeat.o(128401);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495664;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128397);
    this.koa = ((Button)findViewById(2131299230));
    this.kob = ((Button)findViewById(2131301691));
    this.koc = ((LinearLayout)findViewById(2131302247));
    this.kod = ((LinearLayout)findViewById(2131305442));
    this.gvv = ((ImageView)findViewById(2131297134));
    this.gvw = ((TextView)findViewById(2131305440));
    this.kbe = ((TextView)findViewById(2131297405));
    Object localObject = new PhoneFormater();
    if (this.dSf.startsWith("+"))
    {
      String str1 = PhoneFormater.extractCountryCode(this.dSf);
      if (!Util.isNullOrNil(str1))
      {
        String str2 = this.dSf.substring(str1.length() + 1);
        localObject = "+" + str1 + " " + ((PhoneFormater)localObject).formatNumber(str1, str2);
      }
    }
    for (;;)
    {
      this.kbe.setText((CharSequence)localObject);
      if ((!Util.isNullOrNil(this.nickname)) || (!Util.isNullOrNil(this.kog))) {
        break;
      }
      this.kod.setVisibility(0);
      this.koc.setVisibility(8);
      this.koa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128388);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, new h(new h.a()
          {
            public final void a(ProgressDialog paramAnonymous2ProgressDialog)
            {
              MobileLoginOrForceReg.this.gtM = paramAnonymous2ProgressDialog;
            }
          }, MobileLoginOrForceReg.c(MobileLoginOrForceReg.this), MobileLoginOrForceReg.d(MobileLoginOrForceReg.this), MobileLoginOrForceReg.e(MobileLoginOrForceReg.this)));
          MobileLoginOrForceReg.f(MobileLoginOrForceReg.this).b(MobileLoginOrForceReg.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128388);
        }
      });
      this.kob.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128389);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (Util.isNullOrNil(MobileLoginOrForceReg.g(MobileLoginOrForceReg.this)))
          {
            localObject = new Intent();
            com.tencent.mm.plugin.b.a.bwV("R200_900_phone");
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      setMMTitle(2131763082);
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
      localObject = this.dSf;
      continue;
      localObject = "+86 " + ((PhoneFormater)localObject).formatNumber("86", this.dSf);
    }
    this.kod.setVisibility(8);
    this.koc.setVisibility(0);
    if (Util.isNullOrNil(this.nickname)) {
      this.gvw.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.gov().Wg();
      if (localObject != null) {
        this.gvv.setImageBitmap((Bitmap)localObject);
      }
      if (Util.isNullOrNil(this.kog)) {
        break;
      }
      localObject = this.kog;
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128386);
          Object localObject = null;
          try
          {
            Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(d.w(this.val$url, 10000, 20000));
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
      this.gvw.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128396);
    super.onCreate(paramBundle);
    this.koi = com.tencent.mm.plugin.b.a.bpZ();
    com.tencent.mm.kernel.g.azz().a(701, this);
    com.tencent.mm.kernel.g.azz().a(252, this);
    com.tencent.mm.kernel.g.azz().a(126, this);
    com.tencent.mm.kernel.g.azz().a(255, this);
    this.kon = getIntent().getIntExtra("key_reg_style", 1);
    this.dHx = getIntent().getStringExtra("ticket");
    this.dSf = getIntent().getStringExtra("moble");
    this.koe = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.kof = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.kog = getIntent().getStringExtra("avatar_url");
    this.knu = getIntent().getStringExtra("regsession_id");
    this.koo = getIntent().getStringExtra("reg_3d_app_ticket");
    this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.koh = getIntent().getIntExtra("mobile_check_type", 0);
    this.kok = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.kol = getIntent().getStringExtra("kintent_nickname");
    this.kom = getIntent().getStringExtra("kintent_password");
    if ((this.kom != null) && (this.kom.length() >= 8)) {}
    for (this.jkp = 1;; this.jkp = 4)
    {
      initView();
      this.kmf = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128396);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128400);
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    com.tencent.mm.kernel.g.azz().b(126, this);
    com.tencent.mm.kernel.g.azz().b(255, this);
    if (this.kmf != null) {
      this.kmf.close();
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
    EventCenter.instance.removeListener(this.kkK);
    AppMethodBeat.o(128399);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128398);
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.bwU("R200_600");
    AppMethodBeat.o(128398);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(128403);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (this.klt == null) {
      this.klt = new g();
    }
    boolean bool;
    if (paramq.getType() == 255)
    {
      if ((paramInt2 == -3) && (paramInt1 == 4))
      {
        bool = this.koj;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(2131765477));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      AppMethodBeat.o(128403);
      return;
    }
    if (((paramq.getType() == 252) || (paramq.getType() == 701)) && (this.klz != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.klt.account = this.username;
        this.klt.kmI = this.kom;
        this.klt.kds = ((com.tencent.mm.modelsimple.t)paramq).bfl();
        this.klt.kdr = ((com.tencent.mm.modelsimple.t)paramq).bfm();
        this.klt.kdt = ((com.tencent.mm.modelsimple.t)paramq).bfn();
        this.klt.kmJ = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
        if (this.kdp == null)
        {
          this.kdp = SecurityImage.a.a(this, this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128392);
              Log.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).kds + " img len" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).kdr.length + " " + f.apq());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).account, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).kmI, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).kmJ, MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgSid(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              MobileLoginOrForceReg.this.getString(2131755998);
              com.tencent.mm.ui.base.h.a(localMobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(2131762532), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128391);
                  com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
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
          }, this.klt);
          AppMethodBeat.o(128403);
          return;
        }
        this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
        AppMethodBeat.o(128403);
        return;
      }
      this.edo = ((com.tencent.mm.modelsimple.t)paramq).bfk();
      this.klz.a(this, paramInt1, paramInt2, paramString, paramq);
      if ((paramq instanceof com.tencent.mm.modelsimple.t)) {
        this.koj = ((com.tencent.mm.modelsimple.t)paramq).bfu();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new u(1);
        com.tencent.mm.kernel.g.azz().a(paramString, 0);
        getString(2131755998);
        this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131755886), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128394);
            com.tencent.mm.kernel.g.azz().a(paramString);
            AppMethodBeat.o(128394);
          }
        });
        if (!Util.isNullOrNil(this.koo)) {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OiW, Integer.valueOf(this.kop));
        }
      }
      AppMethodBeat.o(128403);
      return;
    }
    Object localObject2;
    if (paramq.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = Boolean.valueOf(this.kok);
        localObject1 = this.kom;
        localObject2 = this.kol;
        if (this.kdp == null)
        {
          this.kdp = SecurityImage.a.a(this, 0, ((v)paramq).bfm(), ((v)paramq).bfl(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128379);
              paramAnonymousDialogInterface = new v("", this.kor, this.kos, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((v)paramq).bfl(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.PB(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.PC(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.tL(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              AppCompatActivity localAppCompatActivity = MobileLoginOrForceReg.this.getContext();
              MobileLoginOrForceReg.this.getString(2131755998);
              localMobileLoginOrForceReg.gtM = com.tencent.mm.ui.base.h.a(localAppCompatActivity, MobileLoginOrForceReg.this.getString(2131764451), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128378);
                  com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
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
            public final void bnH()
            {
              AppMethodBeat.i(128381);
              MobileLoginOrForceReg.this.hideVKB();
              v localv = new v("", this.kor, this.kos, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((v)paramq).bfl(), "", true, paramString.booleanValue());
              localv.PB(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              localv.PC(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              localv.tL(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.azz().a(localv, 0);
              AppMethodBeat.o(128381);
            }
          });
          AppMethodBeat.o(128403);
          return;
        }
        this.kdp.b(0, ((v)paramq).bfm(), ((v)paramq).bfl(), "");
        AppMethodBeat.o(128403);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.dSf;
        bool = this.kok;
        this.kkY.eTd = this.kop;
        this.kkY.ejA = 6L;
        this.kkY.bfK();
        com.tencent.mm.kernel.g.aAf();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.es(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label909;
        }
        localObject2 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar";
        String str = com.tencent.mm.loader.j.b.aKR() + "temp.avatar.hd";
        s.nx((String)localObject2, str);
        s.deleteFile((String)localObject2);
        BitmapUtil.createThumbNail(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject2, true);
        new n(this, com.tencent.mm.loader.j.b.aKR() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128382);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((v)paramq).bfv());
            bf.iDu.aO("login_user_name", this.kow);
            s.deleteFile(com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
            Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.aAf();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.aAf();
            com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128382);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128383);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((v)paramq).bfv());
            bf.iDu.aO("login_user_name", this.kow);
            Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.aAf();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.aAf();
            com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128383);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.Dk(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128403);
        return;
        label909:
        this.dHx = ((v)paramq).bfv();
        bf.iDu.aO("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.bwV("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.aAf();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.aAf();
        com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R200_600") + ",4");
      }
    }
    Object localObject1 = new ae(paramInt1, paramInt2, paramString);
    int i;
    if (this.kmf.a(this, (ae)localObject1)) {
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
        com.tencent.mm.kernel.g.aAf();
        com.tencent.mm.kernel.a.hold();
        localObject2 = getContext();
        com.tencent.mm.kernel.g.aAf();
        if (!TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
      case -34: 
      case -43: 
      case -41: 
      case -36: 
      case -32: 
      case -33: 
      case -75: 
        for (localObject1 = com.tencent.mm.cb.a.aI(getContext(), 2131762849);; localObject1 = com.tencent.mm.kernel.a.ayX())
        {
          com.tencent.mm.ui.base.h.a((Context)localObject2, (String)localObject1, getContext().getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
          Toast.makeText(this, 2131756598, 0).show();
          i = 1;
          break;
          Toast.makeText(this, 2131756595, 0).show();
          i = 1;
          break;
          Toast.makeText(this, 2131756597, 0).show();
          i = 1;
          break;
          Toast.makeText(this, 2131756600, 0).show();
          i = 1;
          break;
          com.tencent.mm.ui.base.h.d(this, getString(2131756646), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          break;
          com.tencent.mm.ui.base.h.a(this, 2131756644, 2131756650, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          break;
          com.tencent.mm.ui.base.h.n(this, 2131755301, 2131764341);
          i = 1;
          break;
          com.tencent.mm.kernel.g.aAf();
        }
      case -140: 
        if (!Util.isNullOrNil(this.edo)) {
          y.m(getContext(), paramString, this.edo);
        }
        i = 1;
      }
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if ((paramString != null) && (paramString.a(getContext(), null, null)))
      {
        AppMethodBeat.o(128403);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(getContext(), getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg
 * JD-Core Version:    0.7.0.1
 */