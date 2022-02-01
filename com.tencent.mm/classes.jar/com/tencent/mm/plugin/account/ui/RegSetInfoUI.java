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
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.u.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements f
{
  private String bVF;
  private ProgressDialog fMu;
  private String fPq;
  private SecurityImage jct;
  private gk jjW;
  private com.tencent.mm.platformtools.b jlc;
  private String jmq;
  private int jnb;
  private int jnh;
  private int jnk;
  private boolean joC;
  private String joc;
  private EditText jps;
  private View jqA;
  private TextView jqB;
  private String jqC;
  private boolean jqD;
  private o jqE;
  private View jqF;
  private boolean jqG;
  private String jqH;
  private av jqI;
  private EditText jqj;
  private Button jqk;
  private String jql;
  private String jqm;
  private int jqn;
  private String jqo;
  private String jqp;
  private TextView jqq;
  private View jqr;
  private boolean jqs;
  private ImageView jqt;
  private int jqu;
  private LinkedList<String> jqv;
  private ImageView jqw;
  private ProgressBar jqx;
  private String jqy;
  private ImageView jqz;
  private int sceneType;
  
  public RegSetInfoUI()
  {
    AppMethodBeat.i(128701);
    this.fMu = null;
    this.sceneType = 0;
    this.jct = null;
    this.jqs = false;
    this.joC = false;
    this.jqu = 3;
    this.jqv = new LinkedList();
    this.jqy = "";
    this.jqC = null;
    this.jqD = false;
    this.jqG = false;
    this.jjW = new gk();
    this.jqI = new av(Looper.myLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(128668);
        String str = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
        Object localObject2 = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
        Object localObject1 = str;
        if (bt.isNullOrNil(str))
        {
          localObject1 = str;
          if (!bt.isNullOrNil((String)localObject2)) {
            if (((String)localObject2).length() <= 5) {
              break label203;
            }
          }
        }
        label203:
        for (localObject1 = ((String)localObject2).substring(0, 5);; localObject1 = localObject2)
        {
          if ((!bt.isNullOrNil((String)localObject1)) && (bt.isNullOrNil((String)localObject2))) {
            localObject2 = localObject1;
          }
          for (;;)
          {
            if ((!bt.isNullOrNil((String)localObject1)) && (RegSetInfoUI.c(RegSetInfoUI.this)) && (RegSetInfoUI.d(RegSetInfoUI.this)))
            {
              int i = RegSetInfoUI.e(RegSetInfoUI.this);
              str = RegSetInfoUI.f(RegSetInfoUI.this);
              com.tencent.mm.kernel.g.aiU().a(429, RegSetInfoUI.this);
              localObject1 = new ag(str, RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject2, (String)localObject1, "", "");
              com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
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
  
  private void aSa()
  {
    AppMethodBeat.i(128716);
    hideVKB();
    if (aUD())
    {
      h.a(this, getString(2131762397), "", new RegSetInfoUI.21(this), new RegSetInfoUI.22(this));
      AppMethodBeat.o(128716);
      return;
    }
    if (!aUE())
    {
      if (aUF())
      {
        h.a(this, getString(2131762396), "", new RegSetInfoUI.24(this), new RegSetInfoUI.25(this));
        AppMethodBeat.o(128716);
        return;
      }
      if (aUH())
      {
        h.a(this, getString(2131762396), "", new RegSetInfoUI.26(this), new RegSetInfoUI.27(this));
        AppMethodBeat.o(128716);
        return;
      }
      com.tencent.mm.plugin.b.a.Ma("R200_100");
      Object localObject = new Intent(this, MobileInputUI.class);
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
    }
    AppMethodBeat.o(128716);
  }
  
  private void aUA()
  {
    AppMethodBeat.i(128709);
    String str = this.jps.getText().toString().trim();
    Button localButton = this.jqk;
    if (!bt.isNullOrNil(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      AppMethodBeat.o(128709);
      return;
    }
  }
  
  private boolean aUB()
  {
    return (this.jqu & 0x1) > 0;
  }
  
  private boolean aUC()
  {
    return (this.jqu & 0x2) > 0;
  }
  
  private boolean aUD()
  {
    return this.sceneType == 1;
  }
  
  private boolean aUE()
  {
    return this.sceneType == 2;
  }
  
  private boolean aUF()
  {
    return this.sceneType == 0;
  }
  
  private boolean aUG()
  {
    return this.sceneType == 4;
  }
  
  private boolean aUH()
  {
    return this.sceneType == 3;
  }
  
  private int aUI()
  {
    AppMethodBeat.i(128711);
    if (aUD())
    {
      AppMethodBeat.o(128711);
      return 4;
    }
    if (aUE())
    {
      AppMethodBeat.o(128711);
      return 2;
    }
    if (aUH())
    {
      AppMethodBeat.o(128711);
      return 6;
    }
    if (aUG())
    {
      AppMethodBeat.o(128711);
      return 1;
    }
    AppMethodBeat.o(128711);
    return 2;
  }
  
  private String aUJ()
  {
    AppMethodBeat.i(128712);
    if ((aUD()) || (aUG()))
    {
      str = this.jql;
      AppMethodBeat.o(128712);
      return str;
    }
    if (aUH())
    {
      str = this.jqm;
      AppMethodBeat.o(128712);
      return str;
    }
    String str = this.jqp;
    AppMethodBeat.o(128712);
    return str;
  }
  
  private void aUy()
  {
    AppMethodBeat.i(128706);
    int j = aUI();
    com.tencent.mm.kernel.g.aiU().a(126, this);
    int i;
    u localu;
    if (aUC()) {
      if ((this.jqv == null) || (this.jqv.size() == 0))
      {
        i = 0;
        localu = new u("", this.jqo, this.bVF, this.jqn, this.jqm, this.jql, "", "", this.fPq, j, this.jqH, "", "", this.jqs, this.joC);
        ((x.a)localu.hON.getReqObj()).Foz.GWu = i;
      }
    }
    for (;;)
    {
      localu.Gn(this.jmq);
      localu.Go(this.joc);
      localu.pT(this.jnb);
      com.tencent.mm.kernel.g.aiU().a(localu, 0);
      getString(2131755906);
      this.fMu = h.b(this, getString(2131762385), true, new RegSetInfoUI.7(this, localu));
      AppMethodBeat.o(128706);
      return;
      if (this.jqv.contains(this.jqH))
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      localu = new u("", this.jqo, this.bVF, this.jqn, this.jqm, this.jql, "", "", this.fPq, j, "", "", "", this.jqs, this.joC);
    }
  }
  
  private boolean aUz()
  {
    AppMethodBeat.i(128708);
    if ((this.jqw.getVisibility() == 8) || (this.jqD))
    {
      AppMethodBeat.o(128708);
      return true;
    }
    AppMethodBeat.o(128708);
    return false;
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128714);
    Object localObject = new ae(paramInt1, paramInt2, paramString);
    if (this.jlc.a(this, (ae)localObject))
    {
      AppMethodBeat.o(128714);
      return true;
    }
    if (com.tencent.mm.plugin.account.a.a.iRH.a(getContext(), paramInt1, paramInt2, paramString))
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
      h.l(this, 2131762274, 2131762275);
      AppMethodBeat.o(128714);
      return true;
    case -75: 
      h.l(this, 2131755266, 2131762275);
      AppMethodBeat.o(128714);
      return true;
    case -100: 
      com.tencent.mm.kernel.a.hold();
      localObject = getContext();
      com.tencent.mm.kernel.g.ajA();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ais())) {}
      for (paramString = com.tencent.mm.cc.a.az(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.ais())
      {
        h.a((Context)localObject, paramString, getContext().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128714);
        return true;
        com.tencent.mm.kernel.g.ajA();
      }
    }
    paramString = com.tencent.mm.h.a.uz(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
    for (;;)
    {
      AppMethodBeat.o(128714);
      return true;
      h.c(this, getString(2131762403), "", true);
    }
  }
  
  private void q(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(128707);
    if (bt.isNullOrNil(this.jqj.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.jqw;
    if (paramBoolean2)
    {
      i = 2131234064;
      localImageView.setImageResource(i);
      localImageView = this.jqw;
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
      this.jqD = bool1;
      AppMethodBeat.o(128707);
      return;
      i = 2131234061;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495244;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(128705);
    this.jqF = findViewById(2131303345);
    this.jqA = findViewById(2131304608);
    this.jqt = ((ImageView)findViewById(2131304607));
    this.jps = ((EditText)findViewById(2131303939));
    this.jqB = ((TextView)findViewById(2131304610));
    this.jqj = ((EditText)findViewById(2131303946));
    this.jqq = ((TextView)findViewById(2131296638));
    this.jqr = findViewById(2131303965);
    this.jqw = ((ImageView)findViewById(2131306943));
    this.jqx = ((ProgressBar)findViewById(2131303516));
    this.jqz = ((ImageView)findViewById(2131304609));
    this.jqk = ((Button)findViewById(2131302852));
    this.jqw.setVisibility(8);
    this.jqx.setVisibility(8);
    this.jqz.setVisibility(8);
    this.joC = false;
    this.jqD = false;
    Object localObject = this.jqA;
    int i;
    if (aUB())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.jqr;
      if (!aUC()) {
        break label491;
      }
      i = 0;
      label237:
      ((View)localObject).setVisibility(i);
      localObject = this.jqq;
      if (!aUC()) {
        break label497;
      }
      i = j;
      label256:
      ((TextView)localObject).setVisibility(i);
      if ((!aUB()) || (!aUC())) {
        break label503;
      }
      this.jqB.setText(getString(2131762402));
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajF().a(new aq.a()
      {
        String jqQ;
        Bitmap mBitmap;
        
        public final boolean aEm()
        {
          AppMethodBeat.i(128690);
          AppMethodBeat.o(128690);
          return true;
        }
        
        public final boolean aEn()
        {
          AppMethodBeat.i(128689);
          if ((!bt.isNullOrNil(this.jqQ)) && (bt.isNullOrNil(RegSetInfoUI.b(RegSetInfoUI.this).getText().trim()))) {
            RegSetInfoUI.b(RegSetInfoUI.this).setText(this.jqQ);
          }
          if (!com.tencent.mm.compatible.util.e.abf())
          {
            ad.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
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
      this.jps.addTextChangedListener(new TextWatcher()
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
          if (!RegSetInfoUI.m(RegSetInfoUI.this).fkZ()) {
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
      this.jqk.setOnClickListener(new RegSetInfoUI.29(this));
      this.jqj.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128696);
          if (paramAnonymousBoolean)
          {
            RegSetInfoUI.q(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).az(200L, 200L);
          }
          AppMethodBeat.o(128696);
        }
      });
      this.jqj.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128698);
          if (!RegSetInfoUI.m(RegSetInfoUI.this).fkZ()) {
            RegSetInfoUI.m(RegSetInfoUI.this).stopTimer();
          }
          paramAnonymousEditable = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
          if (bt.isNullOrNil(paramAnonymousEditable))
          {
            RegSetInfoUI.r(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(2131762404));
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
          if ((!bt.isNullOrNil(paramAnonymousEditable)) && ((RegSetInfoUI.c(RegSetInfoUI.this)) || (!paramAnonymousEditable.equals(RegSetInfoUI.v(RegSetInfoUI.this)))))
          {
            RegSetInfoUI.s(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).az(500L, 500L);
          }
          RegSetInfoUI.a(RegSetInfoUI.this, paramAnonymousEditable);
          AppMethodBeat.o(128698);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      setBackBtn(new RegSetInfoUI.32(this));
      this.jps.setOnEditorActionListener(new RegSetInfoUI.33(this));
      this.jps.setOnKeyListener(new RegSetInfoUI.2(this));
      this.jqj.setOnEditorActionListener(new RegSetInfoUI.3(this));
      this.jqj.setOnKeyListener(new RegSetInfoUI.4(this));
      this.jqt.setOnClickListener(new RegSetInfoUI.5(this));
      localObject = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.asc());
      if (!((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).mkdirs();
      }
      aUA();
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
      if ((aUB()) && (!aUC())) {
        this.jqB.setText(getString(2131762400));
      } else if ((!aUB()) && (aUC())) {
        this.jqB.setText(getString(2131762401));
      } else {
        this.jqB.setText(getString(2131762399));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128710);
    ad.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramIntent != null) && (paramInt1 == 300))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
        aUy();
      }
      AppMethodBeat.o(128710);
      return;
    }
    paramIntent = com.tencent.mm.plugin.account.a.a.iRH.a(this, paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.jqt.setImageBitmap(paramIntent);
      this.joC = true;
      this.jqz.setVisibility(0);
    }
    AppMethodBeat.o(128710);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128702);
    super.onCreate(paramBundle);
    paramBundle = getString(2131762405);
    if ((d.Fnm) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755822) + com.tencent.mm.cd.g.is(this);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.iRH.MU();
    this.jql = getIntent().getStringExtra("regsetinfo_user");
    this.jqm = getIntent().getStringExtra("regsetinfo_bind_email");
    this.fPq = getIntent().getStringExtra("regsetinfo_ticket");
    this.jqo = getIntent().getStringExtra("regsetinfo_pwd");
    this.jqp = getIntent().getStringExtra("regsetinfo_binduin");
    this.jnb = getIntent().getIntExtra("mobile_check_type", 0);
    if (!bt.isNullOrNil(this.jqp)) {
      this.jqn = com.tencent.mm.b.p.er(this.jqp);
    }
    this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.jqs = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.jqu = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    this.jmq = getIntent().getStringExtra("regsession_id");
    this.joc = getIntent().getStringExtra("reg_3d_app_ticket");
    this.jnk = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.jnh = getIntent().getIntExtra("key_reg_style", 1);
    initView();
    if (this.sceneType == 1)
    {
      paramBundle = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      paramBundle = paramBundle.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R200_900_phone") + ",1");
      com.tencent.mm.plugin.b.a.Kc("R200_900_phone");
    }
    for (;;)
    {
      this.jqG = false;
      this.jlc = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128702);
      return;
      if (this.sceneType == 2)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R4_QQ") + ",1");
        com.tencent.mm.plugin.b.a.Kc("R4_QQ");
      }
      else if (this.sceneType == 3)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R200_900_email") + ",1");
        com.tencent.mm.plugin.b.a.Kc("R200_900_email");
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
      com.tencent.mm.kernel.g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.jlc != null) {
        this.jlc.close();
      }
      AppMethodBeat.o(128704);
      return;
      if (this.sceneType == 2)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R4_QQ") + ",2");
      }
      else if (this.sceneType == 3)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128715);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aSa();
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
    this.jps.postDelayed(new Runnable()
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128713);
    ad.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    String str2;
    String str1;
    int i;
    String str3;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    boolean bool1;
    Object localObject3;
    if (paramn.getType() == 126)
    {
      com.tencent.mm.kernel.g.aiU().b(126, this);
      if (this.fMu != null)
      {
        this.fMu.dismiss();
        this.fMu = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.jjW.enS = this.jnk;
        this.jjW.dPl = 6L;
        this.jjW.aLk();
        this.jqC = null;
        str2 = aUJ();
        str1 = ((u)paramn).aKX();
        i = ((u)paramn).aKY();
        str3 = ((u)paramn).aKZ();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bw.M(str3, "wording");
        if (localMap == null) {
          break label1722;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bt.isNullOrNil((String)localObject3)) {
          break label566;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1722;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bt.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bt.isNullOrNil((String)localObject3)) {
          break label1719;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      ad.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.dB(true);
      if (this.joC)
      {
        localObject3 = com.tencent.mm.loader.j.b.asc() + "temp.avatar";
        str3 = com.tencent.mm.loader.j.b.asc() + "temp.avatar.hd";
        com.tencent.mm.vfs.i.mA((String)localObject3, str3);
        com.tencent.mm.vfs.i.deleteFile((String)localObject3);
        com.tencent.mm.sdk.platformtools.g.c(str3, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.ak.n(this, com.tencent.mm.loader.j.b.asc() + "temp.avatar").a(new RegSetInfoUI.8(this, paramn, str2, str1, bool1, (String)localObject1, (String)localObject2, i), new RegSetInfoUI.9(this, paramn, str2, str1, bool1, (String)localObject1, (String)localObject2, i));
      }
      for (;;)
      {
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.jct == null)
          {
            this.jct = SecurityImage.a.a(getContext(), 0, ((u)paramn).aKM(), ((u)paramn).aKL(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128677);
                paramAnonymousDialogInterface = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                Object localObject = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                if ((localObject == null) || (((String)localObject).length() <= 0))
                {
                  h.l(RegSetInfoUI.this, 2131764648, 2131762346);
                  AppMethodBeat.o(128677);
                  return;
                }
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.aiU().a(126, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new u("", RegSetInfoUI.y(RegSetInfoUI.this), (String)localObject, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, ((u)paramn).aKL(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode(), RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                paramAnonymousDialogInterface.Gn(RegSetInfoUI.E(RegSetInfoUI.this));
                paramAnonymousDialogInterface.Go(RegSetInfoUI.F(RegSetInfoUI.this));
                paramAnonymousDialogInterface.pT(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
                localObject = RegSetInfoUI.this;
                RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(2131755906);
                RegSetInfoUI.a((RegSetInfoUI)localObject, h.b(localRegSetInfoUI, RegSetInfoUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128676);
                    com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.aiU().b(126, RegSetInfoUI.this);
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
              public final void aSv()
              {
                AppMethodBeat.i(128680);
                RegSetInfoUI.this.hideVKB();
                Object localObject = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                String str = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.aiU().a(126, RegSetInfoUI.this);
                localObject = new u("", RegSetInfoUI.y(RegSetInfoUI.this), str, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject, ((u)paramn).aKL(), "", RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                ((u)localObject).Gn(RegSetInfoUI.E(RegSetInfoUI.this));
                ((u)localObject).Go(RegSetInfoUI.F(RegSetInfoUI.this));
                ((u)localObject).pT(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject, 0);
                AppMethodBeat.o(128680);
              }
            });
            AppMethodBeat.o(128713);
            return;
            label566:
            int j = bt.aRe((String)localObject3);
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
            this.fPq = ((u)paramn).aKV();
            az.hFS.aM("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.Ma("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.fPq);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
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
            localObject1 = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajA();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.ajA();
            com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_900_phone") + ",4");
            finish();
            continue;
          }
          this.jct.b(0, ((u)paramn).aKM(), ((u)paramn).aKL(), "");
          AppMethodBeat.o(128713);
          return;
        }
      }
      localObject1 = com.tencent.mm.h.a.uz(paramString);
      if (localObject1 != null)
      {
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128713);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128713);
        return;
      }
      if (paramn.getType() == 429)
      {
        com.tencent.mm.kernel.g.aiU().b(429, this);
        if (this.fMu != null)
        {
          this.fMu.dismiss();
          this.fMu = null;
        }
        this.jqx.setVisibility(8);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.jqC = null;
          paramInt1 = ((u.b)((ag)paramn).hON.getRespObj()).jdY.GDA;
          ad.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
          {
            paramn = ((u.b)((ag)paramn).hON.getRespObj()).jdY.nDj;
            paramString = com.tencent.mm.h.a.uz(paramString);
            if (paramString != null) {
              this.jqq.setText(paramString.desc);
            }
            this.jqv.clear();
            if ((paramn != null) && (paramn.size() > 0))
            {
              if (paramn.size() > 3) {}
              for (paramInt1 = 3;; paramInt1 = paramn.size())
              {
                paramString = new String[paramInt1];
                paramInt2 = 0;
                while (paramInt2 < paramInt1)
                {
                  paramString[paramInt2] = ((cwt)paramn.get(paramInt2)).HoB;
                  this.jqv.add(paramString[paramInt2]);
                  paramInt2 += 1;
                }
              }
              if (this.jqG)
              {
                if (this.jqE != null)
                {
                  this.jqE.dismiss();
                  this.jqE = null;
                }
                this.jqE = p.a(this, this.jqF, paramString, new AdapterView.OnItemClickListener()
                {
                  public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(128687);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymousAdapterView);
                    localb.bd(paramAnonymousView);
                    localb.mr(paramAnonymousInt);
                    localb.qY(paramAnonymousLong);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$25", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
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
                    RegSetInfoUI.r(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(2131762404));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$25", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(128687);
                  }
                });
              }
            }
            q(true, true);
            AppMethodBeat.o(128713);
            return;
          }
          if (bt.isNullOrNil(this.jqj.getText().toString().trim()))
          {
            q(false, false);
            AppMethodBeat.o(128713);
            return;
          }
          q(true, false);
          this.jqq.setText(getString(2131762404));
          if (this.jqE != null)
          {
            this.jqE.dismiss();
            this.jqE = null;
          }
          this.jqj.postDelayed(new Runnable()
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
          if (this.jct == null)
          {
            this.jct = SecurityImage.a.a(getContext(), 0, ((ag)paramn).aKM(), ((ag)paramn).aKL(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128683);
                paramAnonymousDialogInterface = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                Object localObject1 = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.length() <= 0))
                {
                  h.l(RegSetInfoUI.this, 2131764648, 2131762346);
                  AppMethodBeat.o(128683);
                  return;
                }
                RegSetInfoUI.this.hideVKB();
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject2 = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.aiU().a(429, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new ag((String)localObject2, RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, (String)localObject1, ((ag)paramn).aKL(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode());
                com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
                localObject1 = RegSetInfoUI.this;
                localObject2 = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(2131755906);
                RegSetInfoUI.a((RegSetInfoUI)localObject1, h.b((Context)localObject2, RegSetInfoUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128682);
                    com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.aiU().b(429, RegSetInfoUI.this);
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
              public final void aSv()
              {
                AppMethodBeat.i(128685);
                RegSetInfoUI.this.hideVKB();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.aiU().a(429, RegSetInfoUI.this);
                localObject = new ag((String)localObject, RegSetInfoUI.g(RegSetInfoUI.this), i, "", "", ((ag)paramn).aKL(), "");
                com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject, 0);
                AppMethodBeat.o(128685);
              }
            });
            AppMethodBeat.o(128713);
            return;
          }
          this.jct.b(0, ((ag)paramn).aKM(), ((ag)paramn).aKL(), "");
          AppMethodBeat.o(128713);
          return;
        }
        q(true, true);
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128713);
        return;
      }
      if (paramInt1 == 8)
      {
        this.jqC = getString(2131759510, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, this.jqC, 0).show();
        AppMethodBeat.o(128713);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(2131759555, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128713);
      return;
      label1719:
      continue;
      label1722:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI
 * JD-Core Version:    0.7.0.1
 */