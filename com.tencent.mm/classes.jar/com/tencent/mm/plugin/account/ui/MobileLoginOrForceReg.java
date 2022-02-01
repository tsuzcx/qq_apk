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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.o;

public class MobileLoginOrForceReg
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private String dAs;
  private String dLz;
  private String dqk;
  protected ProgressDialog fOC;
  private ImageView fQl;
  private TextView fQm;
  private aq handler;
  private int ipi;
  private TextView jdb;
  private SecurityImage jfm;
  private c jmB;
  private gm jmP;
  private com.tencent.mm.platformtools.b jnW;
  private f jnl;
  private g jnr;
  private Button jpO;
  private Button jpP;
  private LinearLayout jpQ;
  private LinearLayout jpR;
  private int jpS;
  private String jpT;
  private String jpU;
  private int jpV;
  private String jpW;
  private boolean jpX;
  private boolean jpY;
  private String jpZ;
  private String jpk;
  private String jqa;
  private int jqb;
  private String jqc;
  private int jqd;
  private String nickname;
  private String username;
  
  public MobileLoginOrForceReg()
  {
    AppMethodBeat.i(128395);
    this.fOC = null;
    this.jnr = null;
    this.jpX = true;
    this.handler = new aq()
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
    this.jfm = null;
    this.jmP = new gm();
    this.jmB = new MobileLoginOrForceReg.12(this);
    this.jnl = null;
    AppMethodBeat.o(128395);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128401);
    com.tencent.mm.plugin.b.a.KB("R200_100");
    if (this.jqb == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.b.a.KA(this.jpW);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R200_600") + ",2");
      finish();
      AppMethodBeat.o(128401);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494924;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128397);
    this.jpO = ((Button)findViewById(2131298783));
    this.jpP = ((Button)findViewById(2131300217));
    this.jpQ = ((LinearLayout)findViewById(2131300679));
    this.jpR = ((LinearLayout)findViewById(2131302869));
    this.fQl = ((ImageView)findViewById(2131297008));
    this.fQm = ((TextView)findViewById(2131302867));
    this.jdb = ((TextView)findViewById(2131297250));
    new com.tencent.mm.sdk.platformtools.bb();
    Object localObject;
    if (this.dAs.startsWith("+"))
    {
      localObject = com.tencent.mm.sdk.platformtools.bb.apd(this.dAs);
      if (!bu.isNullOrNil((String)localObject))
      {
        String str = this.dAs.substring(((String)localObject).length() + 1);
        localObject = "+" + (String)localObject + " " + com.tencent.mm.sdk.platformtools.bb.formatNumber((String)localObject, str);
      }
    }
    for (;;)
    {
      this.jdb.setText((CharSequence)localObject);
      if ((!bu.isNullOrNil(this.nickname)) || (!bu.isNullOrNil(this.jpU))) {
        break;
      }
      this.jpR.setVisibility(0);
      this.jpQ.setVisibility(8);
      this.jpO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128388);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymous2ProgressDialog)
            {
              MobileLoginOrForceReg.this.fOC = paramAnonymous2ProgressDialog;
            }
          }, MobileLoginOrForceReg.c(MobileLoginOrForceReg.this), MobileLoginOrForceReg.d(MobileLoginOrForceReg.this), MobileLoginOrForceReg.e(MobileLoginOrForceReg.this)));
          MobileLoginOrForceReg.f(MobileLoginOrForceReg.this).b(MobileLoginOrForceReg.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128388);
        }
      });
      this.jpP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128389);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (bu.isNullOrNil(MobileLoginOrForceReg.g(MobileLoginOrForceReg.this)))
          {
            localObject = new Intent();
            com.tencent.mm.plugin.b.a.KB("R200_900_phone");
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
      setMMTitle(2131761256);
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
      localObject = this.dAs;
      continue;
      localObject = "+86 " + com.tencent.mm.sdk.platformtools.bb.formatNumber("86", this.dAs);
    }
    this.jpR.setVisibility(8);
    this.jpQ.setVisibility(0);
    if (bu.isNullOrNil(this.nickname)) {
      this.fQm.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.ffl().LT();
      if (localObject != null) {
        this.fQl.setImageBitmap((Bitmap)localObject);
      }
      if (bu.isNullOrNil(this.jpU)) {
        break;
      }
      localObject = this.jpU;
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128386);
          Object localObject = null;
          try
          {
            Bitmap localBitmap = com.tencent.mm.sdk.platformtools.h.decodeStream(com.tencent.mm.network.b.w(this.val$url, 10000, 20000));
            localObject = localBitmap;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
              com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", localException, "", new Object[0]);
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
      this.fQm.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128396);
    super.onCreate(paramBundle);
    this.jpW = com.tencent.mm.plugin.b.a.aVo();
    com.tencent.mm.kernel.g.ajj().a(701, this);
    com.tencent.mm.kernel.g.ajj().a(252, this);
    com.tencent.mm.kernel.g.ajj().a(126, this);
    com.tencent.mm.kernel.g.ajj().a(255, this);
    this.jqb = getIntent().getIntExtra("key_reg_style", 1);
    this.dqk = getIntent().getStringExtra("ticket");
    this.dAs = getIntent().getStringExtra("moble");
    this.jpS = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.jpT = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.jpU = getIntent().getStringExtra("avatar_url");
    this.jpk = getIntent().getStringExtra("regsession_id");
    this.jqc = getIntent().getStringExtra("reg_3d_app_ticket");
    this.jqd = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.jpV = getIntent().getIntExtra("mobile_check_type", 0);
    this.jpY = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.jpZ = getIntent().getStringExtra("kintent_nickname");
    this.jqa = getIntent().getStringExtra("kintent_password");
    if ((this.jqa != null) && (this.jqa.length() >= 8)) {}
    for (this.ipi = 1;; this.ipi = 4)
    {
      initView();
      this.jnW = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128396);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128400);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    com.tencent.mm.kernel.g.ajj().b(126, this);
    com.tencent.mm.kernel.g.ajj().b(255, this);
    if (this.jnW != null) {
      this.jnW.close();
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
    com.tencent.mm.sdk.b.a.IvT.d(this.jmB);
    AppMethodBeat.o(128399);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128398);
    com.tencent.mm.sdk.b.a.IvT.c(this.jmB);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.KA("R200_600");
    AppMethodBeat.o(128398);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128403);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (this.jnl == null) {
      this.jnl = new f();
    }
    boolean bool;
    if (paramn.getType() == 255)
    {
      if ((paramInt2 == -3) && (paramInt1 == 4))
      {
        bool = this.jpX;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(2131763302));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      AppMethodBeat.o(128403);
      return;
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.jnr != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.jnl.account = this.username;
        this.jnl.joy = this.jqa;
        this.jnl.jfp = ((t)paramn).aLi();
        this.jnl.jfo = ((t)paramn).aLj();
        this.jnl.jfq = ((t)paramn).aLk();
        this.jnl.joz = ((t)paramn).getSecCodeType();
        if (this.jfm == null)
        {
          this.jfm = SecurityImage.a.a(this, this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128392);
              com.tencent.mm.sdk.platformtools.ae.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).jfp + " img len" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
              paramAnonymousDialogInterface = new t(MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).account, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).joy, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).joz, MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgSid(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              MobileLoginOrForceReg.this.getString(2131755906);
              com.tencent.mm.ui.base.h.b(localMobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128391);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
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
          }, this.jnl);
          AppMethodBeat.o(128403);
          return;
        }
        this.jfm.b(this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq);
        AppMethodBeat.o(128403);
        return;
      }
      this.dLz = ((t)paramn).aLh();
      this.jnr.a(this, paramInt1, paramInt2, paramString, paramn);
      if ((paramn instanceof t)) {
        this.jpX = ((t)paramn).aLr();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new u(1);
        com.tencent.mm.kernel.g.ajj().a(paramString, 0);
        getString(2131755906);
        this.fOC = com.tencent.mm.ui.base.h.b(this, getString(2131755804), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128394);
            com.tencent.mm.kernel.g.ajj().a(paramString);
            AppMethodBeat.o(128394);
          }
        });
        if (!bu.isNullOrNil(this.jqc)) {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jaq, Integer.valueOf(this.jqd));
        }
      }
      AppMethodBeat.o(128403);
      return;
    }
    Object localObject2;
    if (paramn.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = Boolean.valueOf(this.jpY);
        localObject1 = this.jqa;
        localObject2 = this.jpZ;
        if (this.jfm == null)
        {
          this.jfm = SecurityImage.a.a(this, 0, ((v)paramn).aLj(), ((v)paramn).aLi(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128379);
              paramAnonymousDialogInterface = new v("", this.jqf, this.jqg, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((v)paramn).aLi(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.GP(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.GQ(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.pW(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              AppCompatActivity localAppCompatActivity = MobileLoginOrForceReg.this.getContext();
              MobileLoginOrForceReg.this.getString(2131755906);
              localMobileLoginOrForceReg.fOC = com.tencent.mm.ui.base.h.b(localAppCompatActivity, MobileLoginOrForceReg.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128378);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
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
            public final void aSU()
            {
              AppMethodBeat.i(128381);
              MobileLoginOrForceReg.this.hideVKB();
              v localv = new v("", this.jqf, this.jqg, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((v)paramn).aLi(), "", true, paramString.booleanValue());
              localv.GP(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              localv.GQ(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              localv.pW(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.ajj().a(localv, 0);
              AppMethodBeat.o(128381);
            }
          });
          AppMethodBeat.o(128403);
          return;
        }
        this.jfm.b(0, ((v)paramn).aLj(), ((v)paramn).aLi(), "");
        AppMethodBeat.o(128403);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.dAs;
        bool = this.jpY;
        this.jmP.epA = this.jqd;
        this.jmP.dQB = 6L;
        this.jmP.aLH();
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.dC(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label908;
        }
        localObject2 = com.tencent.mm.loader.j.b.asr() + "temp.avatar";
        String str = com.tencent.mm.loader.j.b.asr() + "temp.avatar.hd";
        o.mG((String)localObject2, str);
        o.deleteFile((String)localObject2);
        com.tencent.mm.sdk.platformtools.h.c(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
        new com.tencent.mm.aj.n(this, com.tencent.mm.loader.j.b.asr() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128382);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((v)paramn).aLs());
            com.tencent.mm.model.bb.hIK.aM("login_user_name", this.jqk);
            o.deleteFile(com.tencent.mm.loader.j.b.asr() + "temp.avatar");
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.ajP();
            com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128382);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128383);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((v)paramn).aLs());
            com.tencent.mm.model.bb.hIK.aM("login_user_name", this.jqk);
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.ajP();
            com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128383);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.uU(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128403);
        return;
        label908:
        this.dqk = ((v)paramn).aLs();
        com.tencent.mm.model.bb.hIK.aM("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.KB("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R200_600") + ",4");
      }
    }
    Object localObject1 = new com.tencent.mm.platformtools.ae(paramInt1, paramInt2, paramString);
    int i;
    if (this.jnW.a(this, (com.tencent.mm.platformtools.ae)localObject1)) {
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
      case -140: 
        if (!bu.isNullOrNil(this.dLz)) {
          y.n(getContext(), paramString, this.dLz);
        }
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131756462, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131756459, 0).show();
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131756461, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131756464, 0).show();
        i = 1;
        break;
      case -32: 
        com.tencent.mm.ui.base.h.d(this, getString(2131756510), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        i = 1;
        break;
      case -33: 
        com.tencent.mm.ui.base.h.a(this, 2131756508, 2131756514, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        i = 1;
        break;
      case -75: 
        com.tencent.mm.ui.base.h.l(this, 2131755266, 2131762275);
        i = 1;
        break;
      case -100: 
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.kernel.a.hold();
        localObject2 = getContext();
        com.tencent.mm.kernel.g.ajP();
        if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
        for (localObject1 = com.tencent.mm.cb.a.az(getContext(), 2131761063);; localObject1 = com.tencent.mm.kernel.a.aiH())
        {
          com.tencent.mm.ui.base.h.a((Context)localObject2, (String)localObject1, getContext().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
          com.tencent.mm.kernel.g.ajP();
        }
      }
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.uU(paramString);
      if ((paramString != null) && (paramString.a(getContext(), null, null)))
      {
        AppMethodBeat.o(128403);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(getContext(), getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg
 * JD-Core Version:    0.7.0.1
 */