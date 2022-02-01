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
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.ce.j;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelavatar.o;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.model.ad;
import com.tencent.mm.plugin.account.friend.model.r.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String lCS;
  private ProgressDialog lzP;
  private String nickName;
  private SecurityImage pRw;
  private com.tencent.mm.platformtools.b pZq;
  private pu qbY;
  private String qcu;
  private int qdh;
  private int qdn;
  private int qdp;
  private boolean qeQ;
  private String qeg;
  private LinkedList<String> qgA;
  private ImageView qgB;
  private ProgressBar qgC;
  private String qgD;
  private ImageView qgE;
  private View qgF;
  private TextView qgG;
  private String qgH;
  private boolean qgI;
  private v qgJ;
  private View qgK;
  private boolean qgL;
  private String qgM;
  private MTimerHandler qgN;
  private EditText qgn;
  private EditText qgo;
  private Button qgp;
  private String qgq;
  private String qgr;
  private int qgs;
  private String qgt;
  private String qgu;
  private TextView qgv;
  private View qgw;
  private boolean qgx;
  private ImageView qgy;
  private int qgz;
  private int sceneType;
  
  public RegSetInfoUI()
  {
    AppMethodBeat.i(128701);
    this.lzP = null;
    this.sceneType = 0;
    this.pRw = null;
    this.qgx = false;
    this.qeQ = false;
    this.qgz = 3;
    this.qgA = new LinkedList();
    this.qgD = "";
    this.qgH = null;
    this.qgI = false;
    this.qgL = false;
    this.qbY = new pu();
    this.qgN = new MTimerHandler(Looper.myLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(128668);
        String str = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
        Object localObject2 = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
        Object localObject1 = str;
        if (Util.isNullOrNil(str))
        {
          localObject1 = str;
          if (!Util.isNullOrNil((String)localObject2)) {
            if (((String)localObject2).length() <= 5) {
              break label203;
            }
          }
        }
        label203:
        for (localObject1 = ((String)localObject2).substring(0, 5);; localObject1 = localObject2)
        {
          if ((!Util.isNullOrNil((String)localObject1)) && (Util.isNullOrNil((String)localObject2))) {
            localObject2 = localObject1;
          }
          for (;;)
          {
            if ((!Util.isNullOrNil((String)localObject1)) && (RegSetInfoUI.c(RegSetInfoUI.this)) && (RegSetInfoUI.d(RegSetInfoUI.this)))
            {
              int i = RegSetInfoUI.e(RegSetInfoUI.this);
              str = RegSetInfoUI.f(RegSetInfoUI.this);
              com.tencent.mm.kernel.h.aZW().a(429, RegSetInfoUI.this);
              localObject1 = new ad(str, RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject2, (String)localObject1, "", "");
              com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
              RegSetInfoUI.h(RegSetInfoUI.this).setVisibility(0);
            }
            AppMethodBeat.o(128668);
            return false;
          }
        }
      }
    }, true);
    AppMethodBeat.o(128701);
  }
  
  private void bWj()
  {
    AppMethodBeat.i(128716);
    hideVKB();
    if (bYS())
    {
      k.a(this, getString(r.j.regsetinfo_reverify), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128688);
          if (RegSetInfoUI.I(RegSetInfoUI.this) == 2)
          {
            paramAnonymousDialogInterface = new Intent(RegSetInfoUI.this, MobileInputUI.class);
            paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 2);
          }
          for (;;)
          {
            paramAnonymousDialogInterface.addFlags(67108864);
            RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.b(localRegSetInfoUI, paramAnonymousDialogInterface.aYi(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localRegSetInfoUI.startActivity((Intent)paramAnonymousDialogInterface.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localRegSetInfoUI, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128688);
            return;
            paramAnonymousDialogInterface = new Intent(RegSetInfoUI.this, RegByMobileRegAIOUI.class);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128716);
      return;
    }
    if (!bYT())
    {
      if (bYU())
      {
        k.a(this, getString(r.j.regsetinfo_regqq_remind), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128692);
            com.tencent.mm.plugin.b.a.TA("R400_100_signup");
            Object localObject = new Intent(RegSetInfoUI.this, LoginUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128692);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(128716);
        return;
      }
      if (bYW())
      {
        k.a(this, getString(r.j.regsetinfo_regqq_remind), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128693);
            com.tencent.mm.plugin.b.a.TA("R500_100");
            Object localObject = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128693);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(128716);
        return;
      }
      com.tencent.mm.plugin.b.a.TA("R200_100");
      Object localObject = new Intent(this, MobileInputUI.class);
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
    }
    AppMethodBeat.o(128716);
  }
  
  private void bYN()
  {
    AppMethodBeat.i(128706);
    int j = bYX();
    com.tencent.mm.kernel.h.aZW().a(126, this);
    int i;
    final w localw;
    if (bYR()) {
      if ((this.qgA == null) || (this.qgA.size() == 0))
      {
        i = 0;
        localw = new w("", this.qgt, this.nickName, this.qgs, this.qgr, this.qgq, "", "", this.lCS, j, this.qgM, "", "", this.qgx, this.qeQ);
        ((x.a)localw.ouH.getReqObj()).YyB.aaZQ = i;
      }
    }
    for (;;)
    {
      localw.OZ(this.qcu);
      localw.Pa(this.qeg);
      localw.wL(this.qdh);
      com.tencent.mm.kernel.h.aZW().a(localw, 0);
      getString(r.j.app_tip);
      this.lzP = k.a(this, getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128673);
          com.tencent.mm.kernel.h.aZW().a(localw);
          com.tencent.mm.kernel.h.aZW().b(126, RegSetInfoUI.this);
          AppMethodBeat.o(128673);
        }
      });
      AppMethodBeat.o(128706);
      return;
      if (this.qgA.contains(this.qgM))
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      localw = new w("", this.qgt, this.nickName, this.qgs, this.qgr, this.qgq, "", "", this.lCS, j, "", "", "", this.qgx, this.qeQ);
    }
  }
  
  private boolean bYO()
  {
    AppMethodBeat.i(128708);
    if ((this.qgB.getVisibility() == 8) || (this.qgI))
    {
      AppMethodBeat.o(128708);
      return true;
    }
    AppMethodBeat.o(128708);
    return false;
  }
  
  private void bYP()
  {
    AppMethodBeat.i(128709);
    String str = this.qgn.getText().toString().trim();
    Button localButton = this.qgp;
    if (!Util.isNullOrNil(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      AppMethodBeat.o(128709);
      return;
    }
  }
  
  private boolean bYQ()
  {
    return (this.qgz & 0x1) > 0;
  }
  
  private boolean bYR()
  {
    return (this.qgz & 0x2) > 0;
  }
  
  private boolean bYS()
  {
    return this.sceneType == 1;
  }
  
  private boolean bYT()
  {
    return this.sceneType == 2;
  }
  
  private boolean bYU()
  {
    return this.sceneType == 0;
  }
  
  private boolean bYV()
  {
    return this.sceneType == 4;
  }
  
  private boolean bYW()
  {
    return this.sceneType == 3;
  }
  
  private int bYX()
  {
    AppMethodBeat.i(128711);
    if (bYS())
    {
      AppMethodBeat.o(128711);
      return 4;
    }
    if (bYT())
    {
      AppMethodBeat.o(128711);
      return 2;
    }
    if (bYW())
    {
      AppMethodBeat.o(128711);
      return 6;
    }
    if (bYV())
    {
      AppMethodBeat.o(128711);
      return 1;
    }
    AppMethodBeat.o(128711);
    return 2;
  }
  
  private String bYY()
  {
    AppMethodBeat.i(128712);
    if ((bYS()) || (bYV()))
    {
      str = this.qgq;
      AppMethodBeat.o(128712);
      return str;
    }
    if (bYW())
    {
      str = this.qgr;
      AppMethodBeat.o(128712);
      return str;
    }
    String str = this.qgu;
    AppMethodBeat.o(128712);
    return str;
  }
  
  private boolean p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128714);
    Object localObject = new aa(paramInt1, paramInt2, paramString);
    if (this.pZq.a(this, (aa)localObject))
    {
      AppMethodBeat.o(128714);
      return true;
    }
    if (com.tencent.mm.plugin.account.sdk.a.pFo.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128714);
      return true;
    }
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(128714);
      return false;
    case -10: 
    case -7: 
      k.s(this, r.j.reg_username_exist_tip, r.j.reg_username_exist_title);
      AppMethodBeat.o(128714);
      return true;
    case -75: 
      k.s(this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(128714);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.b.aZH();
      localObject = getContext();
      com.tencent.mm.kernel.h.baC();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aZu())) {}
      for (paramString = com.tencent.mm.cd.a.bt(getContext(), r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aZu())
      {
        k.a((Context)localObject, paramString, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128714);
        return true;
        com.tencent.mm.kernel.h.baC();
      }
    }
    paramString = com.tencent.mm.broadcast.a.CH(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
    for (;;)
    {
      AppMethodBeat.o(128714);
      return true;
      k.c(this, getString(r.j.regsetinfo_ticket_notfound), "", true);
    }
  }
  
  private void z(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(128707);
    if (Util.isNullOrNil(this.qgo.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.qgB;
    if (paramBoolean2)
    {
      i = r.e.signup_error;
      localImageView.setImageResource(i);
      localImageView = this.qgB;
      if (!paramBoolean1) {
        break label107;
      }
    }
    label107:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      boolean bool1 = bool2;
      if (paramBoolean1)
      {
        bool1 = bool2;
        if (paramBoolean2) {
          bool1 = true;
        }
      }
      this.qgI = bool1;
      AppMethodBeat.o(128707);
      return;
      i = r.e.signup_choose;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return r.g.regbyqq_setinfo;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(128705);
    this.qgK = findViewById(r.f.popup_anchor);
    this.qgF = findViewById(r.f.setinfo_avatar_ly);
    this.qgy = ((ImageView)findViewById(r.f.setinfo_avatar));
    this.qgn = ((EditText)findViewById(r.f.reg_nick));
    this.qgG = ((TextView)findViewById(r.f.setinfo_tip));
    this.qgo = ((EditText)findViewById(r.f.reg_wechatid));
    this.qgv = ((TextView)findViewById(r.f.alias_tip));
    this.qgw = findViewById(r.f.regsetinfo_wid);
    this.qgB = ((ImageView)findViewById(r.f.wechaid_iv));
    this.qgC = ((ProgressBar)findViewById(r.f.progressBar));
    this.qgE = ((ImageView)findViewById(r.f.setinfo_camera));
    this.qgp = ((Button)findViewById(r.f.next_btn));
    this.qgB.setVisibility(8);
    this.qgC.setVisibility(8);
    this.qgE.setVisibility(8);
    this.qeQ = false;
    this.qgI = false;
    Object localObject = this.qgF;
    int i;
    if (bYQ())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.qgw;
      if (!bYR()) {
        break label491;
      }
      i = 0;
      label237:
      ((View)localObject).setVisibility(i);
      localObject = this.qgv;
      if (!bYR()) {
        break label497;
      }
      i = j;
      label256:
      ((TextView)localObject).setVisibility(i);
      if ((!bYQ()) || (!bYR())) {
        break label503;
      }
      this.qgG.setText(getString(r.j.regsetinfo_settip4));
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
      {
        Bitmap mBitmap;
        String qgV;
        
        public final boolean doInBackground()
        {
          AppMethodBeat.i(128690);
          AppMethodBeat.o(128690);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          AppMethodBeat.i(128689);
          if ((!Util.isNullOrNil(this.qgV)) && (Util.isNullOrNil(RegSetInfoUI.b(RegSetInfoUI.this).getText().trim()))) {
            RegSetInfoUI.b(RegSetInfoUI.this).setText(this.qgV);
          }
          if (!e.aPU())
          {
            Log.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
            AppMethodBeat.o(128689);
            return false;
          }
          if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (!RegSetInfoUI.j(RegSetInfoUI.this)))
          {
            RegSetInfoUI.i(RegSetInfoUI.this).setImageBitmap(this.mBitmap);
            RegSetInfoUI.k(RegSetInfoUI.this);
            RegSetInfoUI.l(RegSetInfoUI.this).setVisibility(0);
          }
          AppMethodBeat.o(128689);
          return true;
        }
        
        public final String toString()
        {
          AppMethodBeat.i(128691);
          String str = super.toString() + "|initView";
          AppMethodBeat.o(128691);
          return str;
        }
      });
      this.qgn.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128694);
          paramAnonymousEditable = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
          if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 16))
          {
            RegSetInfoUI.b(RegSetInfoUI.this).setText(paramAnonymousEditable.substring(0, 16));
            AppMethodBeat.o(128694);
            return;
          }
          if (!RegSetInfoUI.m(RegSetInfoUI.this).stopped()) {
            RegSetInfoUI.m(RegSetInfoUI.this).stopTimer();
          }
          RegSetInfoUI.n(RegSetInfoUI.this);
          if (!RegSetInfoUI.o(RegSetInfoUI.this)) {
            RegSetInfoUI.a(RegSetInfoUI.this).setText(paramAnonymousEditable);
          }
          AppMethodBeat.o(128694);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.qgp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128695);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RegSetInfoUI.p(RegSetInfoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128695);
        }
      });
      this.qgo.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128696);
          if (paramAnonymousBoolean)
          {
            RegSetInfoUI.q(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).startTimer(200L);
          }
          AppMethodBeat.o(128696);
        }
      });
      this.qgo.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128698);
          if (!RegSetInfoUI.m(RegSetInfoUI.this).stopped()) {
            RegSetInfoUI.m(RegSetInfoUI.this).stopTimer();
          }
          paramAnonymousEditable = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
          if (Util.isNullOrNil(paramAnonymousEditable))
          {
            RegSetInfoUI.r(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(r.j.regsetinfo_tip));
            RegSetInfoUI.s(RegSetInfoUI.this);
            if (RegSetInfoUI.t(RegSetInfoUI.this) != null)
            {
              RegSetInfoUI.t(RegSetInfoUI.this).dismiss();
              RegSetInfoUI.u(RegSetInfoUI.this);
            }
            RegSetInfoUI.a(RegSetInfoUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(128697);
                RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
                RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
                AppMethodBeat.o(128697);
              }
            }, 50L);
          }
          if ((!Util.isNullOrNil(paramAnonymousEditable)) && ((RegSetInfoUI.c(RegSetInfoUI.this)) || (!paramAnonymousEditable.equals(RegSetInfoUI.v(RegSetInfoUI.this)))))
          {
            RegSetInfoUI.s(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).startTimer(500L);
          }
          RegSetInfoUI.a(RegSetInfoUI.this, paramAnonymousEditable);
          AppMethodBeat.o(128698);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128699);
          RegSetInfoUI.w(RegSetInfoUI.this);
          AppMethodBeat.o(128699);
          return true;
        }
      });
      this.qgn.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128700);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            RegSetInfoUI.p(RegSetInfoUI.this);
            AppMethodBeat.o(128700);
            return true;
          }
          AppMethodBeat.o(128700);
          return false;
        }
      });
      this.qgn.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128669);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.cH(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            RegSetInfoUI.p(RegSetInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(128669);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128669);
          return false;
        }
      });
      this.qgo.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128670);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            RegSetInfoUI.p(RegSetInfoUI.this);
            AppMethodBeat.o(128670);
            return true;
          }
          AppMethodBeat.o(128670);
          return false;
        }
      });
      this.qgo.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128671);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.cH(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegSetInfoUI$12", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            RegSetInfoUI.p(RegSetInfoUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$12", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(128671);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$12", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128671);
          return false;
        }
      });
      this.qgy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128672);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegSetInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RegSetInfoUI.x(RegSetInfoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128672);
        }
      });
      localObject = new u(com.tencent.mm.loader.i.b.bmH());
      if (!((u)localObject).jKS()) {
        ((u)localObject).jKY();
      }
      bYP();
      AppMethodBeat.o(128705);
      return;
      i = 8;
      break;
      label491:
      i = 8;
      break label237;
      label497:
      i = 8;
      break label256;
      label503:
      if ((bYQ()) && (!bYR())) {
        this.qgG.setText(getString(r.j.regsetinfo_settip2));
      } else if ((!bYQ()) && (bYR())) {
        this.qgG.setText(getString(r.j.regsetinfo_settip3));
      } else {
        this.qgG.setText(getString(r.j.regsetinfo_settip1));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128710);
    Log.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramIntent != null) && (paramInt1 == 300))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
        bYN();
      }
      AppMethodBeat.o(128710);
      return;
    }
    paramIntent = com.tencent.mm.plugin.account.sdk.a.pFo.b(this, paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.qgy.setImageBitmap(paramIntent);
      this.qeQ = true;
      this.qgE.setVisibility(0);
    }
    AppMethodBeat.o(128710);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128702);
    super.onCreate(paramBundle);
    paramBundle = getString(r.j.regsetinfo_title);
    if ((d.Yxk) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(r.j.app_name) + j.mx(this);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.qgq = getIntent().getStringExtra("regsetinfo_user");
    this.qgr = getIntent().getStringExtra("regsetinfo_bind_email");
    this.lCS = getIntent().getStringExtra("regsetinfo_ticket");
    this.qgt = getIntent().getStringExtra("regsetinfo_pwd");
    this.qgu = getIntent().getStringExtra("regsetinfo_binduin");
    this.qdh = getIntent().getIntExtra("mobile_check_type", 0);
    if (!Util.isNullOrNil(this.qgu)) {
      this.qgs = com.tencent.mm.b.p.hw(this.qgu);
    }
    this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.qgx = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.qgz = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    this.qcu = getIntent().getStringExtra("regsession_id");
    this.qeg = getIntent().getStringExtra("reg_3d_app_ticket");
    this.qdp = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.qdn = getIntent().getIntExtra("key_reg_style", 1);
    initView();
    if (this.sceneType == 1)
    {
      paramBundle = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      paramBundle = paramBundle.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",1");
      com.tencent.mm.plugin.b.a.Tz("R200_900_phone");
    }
    for (;;)
    {
      this.qgL = false;
      this.pZq = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128702);
      return;
      if (this.sceneType == 2)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R4_QQ") + ",1");
        com.tencent.mm.plugin.b.a.Tz("R4_QQ");
      }
      else if (this.sceneType == 3)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R200_900_email") + ",1");
        com.tencent.mm.plugin.b.a.Tz("R200_900_email");
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128704);
    super.onDestroy();
    StringBuilder localStringBuilder;
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.pZq != null) {
        this.pZq.close();
      }
      AppMethodBeat.o(128704);
      return;
      if (this.sceneType == 2)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R4_QQ") + ",2");
      }
      else if (this.sceneType == 3)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128715);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bWj();
      AppMethodBeat.o(128715);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128715);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128703);
    super.onResume();
    this.qgn.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128679);
        RegSetInfoUI.i(RegSetInfoUI.this).requestFocus();
        RegSetInfoUI.b(RegSetInfoUI.this).clearFocus();
        AppMethodBeat.o(128679);
      }
    }, 500L);
    AppMethodBeat.o(128703);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(128713);
    Log.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    final String str2;
    final String str1;
    final int i;
    String str3;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    final boolean bool1;
    Object localObject3;
    if (paramp.getType() == 126)
    {
      com.tencent.mm.kernel.h.aZW().b(126, this);
      if (this.lzP != null)
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.qbY.joN = this.qdp;
        this.qbY.ikE = 6L;
        this.qbY.bMH();
        this.qgH = null;
        str2 = bYY();
        str1 = ((w)paramp).bMu();
        i = ((w)paramp).bMv();
        str3 = ((w)paramp).bMw();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = XmlParser.parseXml(str3, "wording", null);
        if (localMap == null) {
          break label1741;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!Util.isNullOrNil((String)localObject3)) {
          break label588;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1741;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!Util.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (Util.isNullOrNil((String)localObject3)) {
          break label1738;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      Log.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.b.aZI();
      com.tencent.mm.kernel.b.fA(true);
      com.tencent.mm.plugin.report.service.l.kK(1, 8);
      com.tencent.mm.plugin.report.service.l.kK(1, 3);
      com.tencent.mm.plugin.report.service.l.kK(1, 1);
      if (this.qeQ)
      {
        localObject3 = com.tencent.mm.loader.i.b.bmH() + "temp.avatar";
        str3 = com.tencent.mm.loader.i.b.bmH() + "temp.avatar.hd";
        y.qn((String)localObject3, str3);
        y.deleteFile((String)localObject3);
        BitmapUtil.createThumbNail(str3, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3, true);
        new o(this, com.tencent.mm.loader.i.b.bmH() + "temp.avatar", true).a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128674);
            RegSetInfoUI.b(RegSetInfoUI.this, ((w)paramp).bMs());
            bg.okT.bc("login_user_name", str2);
            y.deleteFile(com.tencent.mm.loader.i.b.bmH() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.TA("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128674);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.qdM);
                ((Intent)localObject1).putExtra("alert_message", this.qdN);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.baC();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.baC();
            com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128674);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128675);
            RegSetInfoUI.b(RegSetInfoUI.this, ((w)paramp).bMs());
            bg.okT.bc("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.TA("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128675);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.qdM);
                ((Intent)localObject1).putExtra("alert_message", this.qdN);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.baC();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.baC();
            com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128675);
          }
        });
      }
      for (;;)
      {
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.pRw == null)
          {
            this.pRw = SecurityImage.a.a(getContext(), r.j.regbyqq_secimg_title, 0, ((w)paramp).bMj(), ((w)paramp).bMi(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128677);
                paramAnonymousDialogInterface = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                Object localObject = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                if ((localObject == null) || (((String)localObject).length() <= 0))
                {
                  k.s(RegSetInfoUI.this, r.j.verify_account_null_tip, r.j.regbymobile_reg_setpwd_alert_title);
                  AppMethodBeat.o(128677);
                  return;
                }
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.h.aZW().a(126, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new w("", RegSetInfoUI.y(RegSetInfoUI.this), (String)localObject, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, ((w)paramp).bMi(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode(), RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                paramAnonymousDialogInterface.OZ(RegSetInfoUI.E(RegSetInfoUI.this));
                paramAnonymousDialogInterface.Pa(RegSetInfoUI.F(RegSetInfoUI.this));
                paramAnonymousDialogInterface.wL(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
                localObject = RegSetInfoUI.this;
                RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(r.j.app_tip);
                RegSetInfoUI.a((RegSetInfoUI)localObject, k.a(localRegSetInfoUI, RegSetInfoUI.this.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128676);
                    com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.h.aZW().b(126, RegSetInfoUI.this);
                    AppMethodBeat.o(128676);
                  }
                }));
                AppMethodBeat.o(128677);
              }
            }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128678);
                RegSetInfoUI.H(RegSetInfoUI.this);
                AppMethodBeat.o(128678);
              }
            }, new SecurityImage.b()
            {
              public final void bWF()
              {
                AppMethodBeat.i(128680);
                RegSetInfoUI.this.hideVKB();
                Object localObject = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                String str = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.h.aZW().a(126, RegSetInfoUI.this);
                localObject = new w("", RegSetInfoUI.y(RegSetInfoUI.this), str, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject, ((w)paramp).bMi(), "", RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                ((w)localObject).OZ(RegSetInfoUI.E(RegSetInfoUI.this));
                ((w)localObject).Pa(RegSetInfoUI.F(RegSetInfoUI.this));
                ((w)localObject).wL(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
                AppMethodBeat.o(128680);
              }
            });
            AppMethodBeat.o(128713);
            return;
            label588:
            int j = Util.safeParseInt((String)localObject3);
            if (j == 0)
            {
              bool1 = false;
              break;
            }
            if (j != 1) {
              break;
            }
            bool1 = true;
            break;
            this.lCS = ((w)paramp).bMs();
            bg.okT.bc("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.TA("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.lCS);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
                ((Intent)localObject2).addFlags(67108864);
                ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
                MMWizardActivity.b(this, (Intent)localObject1, (Intent)localObject2);
                finish();
                break;
                localObject3 = new Intent(this, FindMContactAlertUI.class);
                ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
                ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
              }
            }
            localObject1 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.baC();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.baC();
            com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",4");
            finish();
            continue;
          }
          this.pRw.b(0, ((w)paramp).bMj(), ((w)paramp).bMi(), "");
          AppMethodBeat.o(128713);
          return;
        }
      }
      localObject1 = com.tencent.mm.broadcast.a.CH(paramString);
      if (localObject1 != null)
      {
        ((com.tencent.mm.broadcast.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128713);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128713);
        return;
      }
      if (paramp.getType() == 429)
      {
        com.tencent.mm.kernel.h.aZW().b(429, this);
        if (this.lzP != null)
        {
          this.lzP.dismiss();
          this.lzP = null;
        }
        this.qgC.setVisibility(8);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.qgH = null;
          paramInt1 = ((r.b)((ad)paramp).ouH.getRespObj()).pTa.aayY;
          Log.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
          {
            paramp = ((r.b)((ad)paramp).ouH.getRespObj()).pTa.vgO;
            paramString = com.tencent.mm.broadcast.a.CH(paramString);
            if (paramString != null) {
              this.qgv.setText(paramString.desc);
            }
            this.qgA.clear();
            if ((paramp != null) && (paramp.size() > 0))
            {
              if (paramp.size() > 3) {}
              for (paramInt1 = 3;; paramInt1 = paramp.size())
              {
                paramString = new String[paramInt1];
                paramInt2 = 0;
                while (paramInt2 < paramInt1)
                {
                  paramString[paramInt2] = ((etl)paramp.get(paramInt2)).abwM;
                  this.qgA.add(paramString[paramInt2]);
                  paramInt2 += 1;
                }
              }
              if (this.qgL)
              {
                if (this.qgJ != null)
                {
                  this.qgJ.dismiss();
                  this.qgJ = null;
                }
                this.qgJ = q.a(this, this.qgK, paramString, new AdapterView.OnItemClickListener()
                {
                  public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(128687);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.cH(paramAnonymousAdapterView);
                    localb.cH(paramAnonymousView);
                    localb.sc(paramAnonymousInt);
                    localb.hB(paramAnonymousLong);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegSetInfoUI$25", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
                    if (RegSetInfoUI.t(RegSetInfoUI.this) != null)
                    {
                      RegSetInfoUI.t(RegSetInfoUI.this).dismiss();
                      RegSetInfoUI.u(RegSetInfoUI.this);
                    }
                    RegSetInfoUI.a(RegSetInfoUI.this).setText(paramString[paramAnonymousInt]);
                    RegSetInfoUI.a(RegSetInfoUI.this).postDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(128686);
                        RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
                        RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
                        AppMethodBeat.o(128686);
                      }
                    }, 50L);
                    RegSetInfoUI.r(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(r.j.regsetinfo_tip));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$25", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(128687);
                  }
                });
              }
            }
            z(true, true);
            AppMethodBeat.o(128713);
            return;
          }
          if (Util.isNullOrNil(this.qgo.getText().toString().trim()))
          {
            z(false, false);
            AppMethodBeat.o(128713);
            return;
          }
          z(true, false);
          this.qgv.setText(getString(r.j.regsetinfo_tip));
          if (this.qgJ != null)
          {
            this.qgJ.dismiss();
            this.qgJ = null;
          }
          this.qgo.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128681);
              RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
              RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
              AppMethodBeat.o(128681);
            }
          }, 50L);
          AppMethodBeat.o(128713);
          return;
        }
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.pRw == null)
          {
            this.pRw = SecurityImage.a.a(getContext(), r.j.regbyqq_secimg_title, 0, ((ad)paramp).bMj(), ((ad)paramp).bMi(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128683);
                paramAnonymousDialogInterface = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                Object localObject1 = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.length() <= 0))
                {
                  k.s(RegSetInfoUI.this, r.j.verify_account_null_tip, r.j.regbymobile_reg_setpwd_alert_title);
                  AppMethodBeat.o(128683);
                  return;
                }
                RegSetInfoUI.this.hideVKB();
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject2 = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.h.aZW().a(429, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new ad((String)localObject2, RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, (String)localObject1, ((ad)paramp).bMi(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode());
                com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
                localObject1 = RegSetInfoUI.this;
                localObject2 = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(r.j.app_tip);
                RegSetInfoUI.a((RegSetInfoUI)localObject1, k.a((Context)localObject2, RegSetInfoUI.this.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128682);
                    com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.h.aZW().b(429, RegSetInfoUI.this);
                    AppMethodBeat.o(128682);
                  }
                }));
                AppMethodBeat.o(128683);
              }
            }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128684);
                RegSetInfoUI.H(RegSetInfoUI.this);
                AppMethodBeat.o(128684);
              }
            }, new SecurityImage.b()
            {
              public final void bWF()
              {
                AppMethodBeat.i(128685);
                RegSetInfoUI.this.hideVKB();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.h.aZW().a(429, RegSetInfoUI.this);
                localObject = new ad((String)localObject, RegSetInfoUI.g(RegSetInfoUI.this), i, "", "", ((ad)paramp).bMi(), "");
                com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
                AppMethodBeat.o(128685);
              }
            });
            AppMethodBeat.o(128713);
            return;
          }
          this.pRw.b(0, ((ad)paramp).bMj(), ((ad)paramp).bMi(), "");
          AppMethodBeat.o(128713);
          return;
        }
        z(true, true);
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128713);
        return;
      }
      if (paramInt1 == 8)
      {
        this.qgH = getString(r.j.fmt_http_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, this.qgH, 0).show();
        AppMethodBeat.o(128713);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(r.j.fmt_reg_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128713);
      return;
      label1738:
      continue;
      label1741:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI
 * JD-Core Version:    0.7.0.1
 */