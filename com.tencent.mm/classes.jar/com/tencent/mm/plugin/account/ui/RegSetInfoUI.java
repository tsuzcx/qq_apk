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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.model.bb;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.u.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.k;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements f
{
  private String bVF;
  private ProgressDialog fOC;
  private String fRw;
  private SecurityImage jfm;
  private gm jmP;
  private com.tencent.mm.platformtools.b jnW;
  private int jpV;
  private String jpk;
  private String jqV;
  private int jqb;
  private int jqd;
  private boolean jrv;
  private EditText jsl;
  private String jtA;
  private aw jtB;
  private EditText jtc;
  private Button jtd;
  private String jte;
  private String jtf;
  private int jtg;
  private String jth;
  private String jti;
  private TextView jtj;
  private View jtk;
  private boolean jtl;
  private ImageView jtm;
  private int jtn;
  private LinkedList<String> jto;
  private ImageView jtp;
  private ProgressBar jtq;
  private String jtr;
  private ImageView jts;
  private View jtt;
  private TextView jtu;
  private String jtv;
  private boolean jtw;
  private com.tencent.mm.ui.base.o jtx;
  private View jty;
  private boolean jtz;
  private int sceneType;
  
  public RegSetInfoUI()
  {
    AppMethodBeat.i(128701);
    this.fOC = null;
    this.sceneType = 0;
    this.jfm = null;
    this.jtl = false;
    this.jrv = false;
    this.jtn = 3;
    this.jto = new LinkedList();
    this.jtr = "";
    this.jtv = null;
    this.jtw = false;
    this.jtz = false;
    this.jmP = new gm();
    this.jtB = new aw(Looper.myLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(128668);
        String str = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
        Object localObject2 = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
        Object localObject1 = str;
        if (bu.isNullOrNil(str))
        {
          localObject1 = str;
          if (!bu.isNullOrNil((String)localObject2)) {
            if (((String)localObject2).length() <= 5) {
              break label203;
            }
          }
        }
        label203:
        for (localObject1 = ((String)localObject2).substring(0, 5);; localObject1 = localObject2)
        {
          if ((!bu.isNullOrNil((String)localObject1)) && (bu.isNullOrNil((String)localObject2))) {
            localObject2 = localObject1;
          }
          for (;;)
          {
            if ((!bu.isNullOrNil((String)localObject1)) && (RegSetInfoUI.c(RegSetInfoUI.this)) && (RegSetInfoUI.d(RegSetInfoUI.this)))
            {
              int i = RegSetInfoUI.e(RegSetInfoUI.this);
              str = RegSetInfoUI.f(RegSetInfoUI.this);
              com.tencent.mm.kernel.g.ajj().a(429, RegSetInfoUI.this);
              localObject1 = new ag(str, RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject2, (String)localObject1, "", "");
              com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
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
  
  private void aSz()
  {
    AppMethodBeat.i(128716);
    hideVKB();
    if (aVc())
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131762397), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.a(localRegSetInfoUI, paramAnonymousDialogInterface.ahE(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localRegSetInfoUI.startActivity((Intent)paramAnonymousDialogInterface.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localRegSetInfoUI, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    if (!aVd())
    {
      if (aVe())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131762396), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128692);
            com.tencent.mm.plugin.b.a.KB("R400_100_signup");
            Object localObject = new Intent(RegSetInfoUI.this, LoginUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      if (aVg())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131762396), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128693);
            com.tencent.mm.plugin.b.a.KB("R500_100");
            Object localObject = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      com.tencent.mm.plugin.b.a.KB("R200_100");
      Object localObject = new Intent(this, MobileInputUI.class);
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
    }
    AppMethodBeat.o(128716);
  }
  
  private void aUX()
  {
    AppMethodBeat.i(128706);
    int j = aVh();
    com.tencent.mm.kernel.g.ajj().a(126, this);
    int i;
    final v localv;
    if (aVb()) {
      if ((this.jto == null) || (this.jto.size() == 0))
      {
        i = 0;
        localv = new v("", this.jth, this.bVF, this.jtg, this.jtf, this.jte, "", "", this.fRw, j, this.jtA, "", "", this.jtl, this.jrv);
        ((x.a)localv.hRG.getReqObj()).FGX.HpU = i;
      }
    }
    for (;;)
    {
      localv.GP(this.jpk);
      localv.GQ(this.jqV);
      localv.pW(this.jpV);
      com.tencent.mm.kernel.g.ajj().a(localv, 0);
      getString(2131755906);
      this.fOC = com.tencent.mm.ui.base.h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128673);
          com.tencent.mm.kernel.g.ajj().a(localv);
          com.tencent.mm.kernel.g.ajj().b(126, RegSetInfoUI.this);
          AppMethodBeat.o(128673);
        }
      });
      AppMethodBeat.o(128706);
      return;
      if (this.jto.contains(this.jtA))
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      localv = new v("", this.jth, this.bVF, this.jtg, this.jtf, this.jte, "", "", this.fRw, j, "", "", "", this.jtl, this.jrv);
    }
  }
  
  private boolean aUY()
  {
    AppMethodBeat.i(128708);
    if ((this.jtp.getVisibility() == 8) || (this.jtw))
    {
      AppMethodBeat.o(128708);
      return true;
    }
    AppMethodBeat.o(128708);
    return false;
  }
  
  private void aUZ()
  {
    AppMethodBeat.i(128709);
    String str = this.jsl.getText().toString().trim();
    Button localButton = this.jtd;
    if (!bu.isNullOrNil(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      AppMethodBeat.o(128709);
      return;
    }
  }
  
  private boolean aVa()
  {
    return (this.jtn & 0x1) > 0;
  }
  
  private boolean aVb()
  {
    return (this.jtn & 0x2) > 0;
  }
  
  private boolean aVc()
  {
    return this.sceneType == 1;
  }
  
  private boolean aVd()
  {
    return this.sceneType == 2;
  }
  
  private boolean aVe()
  {
    return this.sceneType == 0;
  }
  
  private boolean aVf()
  {
    return this.sceneType == 4;
  }
  
  private boolean aVg()
  {
    return this.sceneType == 3;
  }
  
  private int aVh()
  {
    AppMethodBeat.i(128711);
    if (aVc())
    {
      AppMethodBeat.o(128711);
      return 4;
    }
    if (aVd())
    {
      AppMethodBeat.o(128711);
      return 2;
    }
    if (aVg())
    {
      AppMethodBeat.o(128711);
      return 6;
    }
    if (aVf())
    {
      AppMethodBeat.o(128711);
      return 1;
    }
    AppMethodBeat.o(128711);
    return 2;
  }
  
  private String aVi()
  {
    AppMethodBeat.i(128712);
    if ((aVc()) || (aVf()))
    {
      str = this.jte;
      AppMethodBeat.o(128712);
      return str;
    }
    if (aVg())
    {
      str = this.jtf;
      AppMethodBeat.o(128712);
      return str;
    }
    String str = this.jti;
    AppMethodBeat.o(128712);
    return str;
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128714);
    Object localObject = new com.tencent.mm.platformtools.ae(paramInt1, paramInt2, paramString);
    if (this.jnW.a(this, (com.tencent.mm.platformtools.ae)localObject))
    {
      AppMethodBeat.o(128714);
      return true;
    }
    if (com.tencent.mm.plugin.account.a.a.iUA.a(getContext(), paramInt1, paramInt2, paramString))
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
      com.tencent.mm.ui.base.h.l(this, 2131762274, 2131762275);
      AppMethodBeat.o(128714);
      return true;
    case -75: 
      com.tencent.mm.ui.base.h.l(this, 2131755266, 2131762275);
      AppMethodBeat.o(128714);
      return true;
    case -100: 
      com.tencent.mm.kernel.a.hold();
      localObject = getContext();
      com.tencent.mm.kernel.g.ajP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
      for (paramString = com.tencent.mm.cb.a.az(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.aiH())
      {
        com.tencent.mm.ui.base.h.a((Context)localObject, paramString, getContext().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128714);
        return true;
        com.tencent.mm.kernel.g.ajP();
      }
    }
    paramString = com.tencent.mm.h.a.uU(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
    for (;;)
    {
      AppMethodBeat.o(128714);
      return true;
      com.tencent.mm.ui.base.h.c(this, getString(2131762403), "", true);
    }
  }
  
  private void q(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(128707);
    if (bu.isNullOrNil(this.jtc.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.jtp;
    if (paramBoolean2)
    {
      i = 2131234064;
      localImageView.setImageResource(i);
      localImageView = this.jtp;
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
      this.jtw = bool1;
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
    this.jty = findViewById(2131303345);
    this.jtt = findViewById(2131304608);
    this.jtm = ((ImageView)findViewById(2131304607));
    this.jsl = ((EditText)findViewById(2131303939));
    this.jtu = ((TextView)findViewById(2131304610));
    this.jtc = ((EditText)findViewById(2131303946));
    this.jtj = ((TextView)findViewById(2131296638));
    this.jtk = findViewById(2131303965);
    this.jtp = ((ImageView)findViewById(2131306943));
    this.jtq = ((ProgressBar)findViewById(2131303516));
    this.jts = ((ImageView)findViewById(2131304609));
    this.jtd = ((Button)findViewById(2131302852));
    this.jtp.setVisibility(8);
    this.jtq.setVisibility(8);
    this.jts.setVisibility(8);
    this.jrv = false;
    this.jtw = false;
    Object localObject = this.jtt;
    int i;
    if (aVa())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.jtk;
      if (!aVb()) {
        break label491;
      }
      i = 0;
      label237:
      ((View)localObject).setVisibility(i);
      localObject = this.jtj;
      if (!aVb()) {
        break label497;
      }
      i = j;
      label256:
      ((TextView)localObject).setVisibility(i);
      if ((!aVa()) || (!aVb())) {
        break label503;
      }
      this.jtu.setText(getString(2131762402));
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajU().a(new ar.a()
      {
        String jtJ;
        Bitmap mBitmap;
        
        public final boolean aEC()
        {
          AppMethodBeat.i(128690);
          AppMethodBeat.o(128690);
          return true;
        }
        
        public final boolean aED()
        {
          AppMethodBeat.i(128689);
          if ((!bu.isNullOrNil(this.jtJ)) && (bu.isNullOrNil(RegSetInfoUI.b(RegSetInfoUI.this).getText().trim()))) {
            RegSetInfoUI.b(RegSetInfoUI.this).setText(this.jtJ);
          }
          if (!e.abo())
          {
            com.tencent.mm.sdk.platformtools.ae.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
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
      this.jsl.addTextChangedListener(new TextWatcher()
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
          if (!RegSetInfoUI.m(RegSetInfoUI.this).foU()) {
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
      this.jtd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128695);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RegSetInfoUI.p(RegSetInfoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128695);
        }
      });
      this.jtc.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128696);
          if (paramAnonymousBoolean)
          {
            RegSetInfoUI.q(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).ay(200L, 200L);
          }
          AppMethodBeat.o(128696);
        }
      });
      this.jtc.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128698);
          if (!RegSetInfoUI.m(RegSetInfoUI.this).foU()) {
            RegSetInfoUI.m(RegSetInfoUI.this).stopTimer();
          }
          paramAnonymousEditable = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
          if (bu.isNullOrNil(paramAnonymousEditable))
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
          if ((!bu.isNullOrNil(paramAnonymousEditable)) && ((RegSetInfoUI.c(RegSetInfoUI.this)) || (!paramAnonymousEditable.equals(RegSetInfoUI.v(RegSetInfoUI.this)))))
          {
            RegSetInfoUI.s(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).ay(500L, 500L);
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
      this.jsl.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.jsl.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128669);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.bd(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
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
      this.jtc.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.jtc.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128671);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.bd(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$12", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
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
      this.jtm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128672);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RegSetInfoUI.x(RegSetInfoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128672);
        }
      });
      localObject = new k(com.tencent.mm.loader.j.b.asr());
      if (!((k)localObject).exists()) {
        ((k)localObject).mkdirs();
      }
      aUZ();
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
      if ((aVa()) && (!aVb())) {
        this.jtu.setText(getString(2131762400));
      } else if ((!aVa()) && (aVb())) {
        this.jtu.setText(getString(2131762401));
      } else {
        this.jtu.setText(getString(2131762399));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128710);
    com.tencent.mm.sdk.platformtools.ae.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramIntent != null) && (paramInt1 == 300))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
        aUX();
      }
      AppMethodBeat.o(128710);
      return;
    }
    paramIntent = com.tencent.mm.plugin.account.a.a.iUA.b(this, paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.jtm.setImageBitmap(paramIntent);
      this.jrv = true;
      this.jts.setVisibility(0);
    }
    AppMethodBeat.o(128710);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128702);
    super.onCreate(paramBundle);
    paramBundle = getString(2131762405);
    if ((d.FFK) || (j.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755822) + com.tencent.mm.cc.g.ix(this);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.iUA.MP();
    this.jte = getIntent().getStringExtra("regsetinfo_user");
    this.jtf = getIntent().getStringExtra("regsetinfo_bind_email");
    this.fRw = getIntent().getStringExtra("regsetinfo_ticket");
    this.jth = getIntent().getStringExtra("regsetinfo_pwd");
    this.jti = getIntent().getStringExtra("regsetinfo_binduin");
    this.jpV = getIntent().getIntExtra("mobile_check_type", 0);
    if (!bu.isNullOrNil(this.jti)) {
      this.jtg = com.tencent.mm.b.p.ew(this.jti);
    }
    this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.jtl = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.jtn = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    this.jpk = getIntent().getStringExtra("regsession_id");
    this.jqV = getIntent().getStringExtra("reg_3d_app_ticket");
    this.jqd = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.jqb = getIntent().getIntExtra("key_reg_style", 1);
    initView();
    if (this.sceneType == 1)
    {
      paramBundle = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      paramBundle = paramBundle.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R200_900_phone") + ",1");
      com.tencent.mm.plugin.b.a.KA("R200_900_phone");
    }
    for (;;)
    {
      this.jtz = false;
      this.jnW = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128702);
      return;
      if (this.sceneType == 2)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R4_QQ") + ",1");
        com.tencent.mm.plugin.b.a.KA("R4_QQ");
      }
      else if (this.sceneType == 3)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R200_900_email") + ",1");
        com.tencent.mm.plugin.b.a.KA("R200_900_email");
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
      com.tencent.mm.kernel.g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.jnW != null) {
        this.jnW.close();
      }
      AppMethodBeat.o(128704);
      return;
      if (this.sceneType == 2)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R4_QQ") + ",2");
      }
      else if (this.sceneType == 3)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128715);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aSz();
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
    this.jsl.postDelayed(new Runnable()
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128713);
    com.tencent.mm.sdk.platformtools.ae.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    final String str2;
    final String str1;
    final int i;
    String str3;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    final boolean bool1;
    Object localObject3;
    if (paramn.getType() == 126)
    {
      com.tencent.mm.kernel.g.ajj().b(126, this);
      if (this.fOC != null)
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.jmP.epA = this.jqd;
        this.jmP.dQB = 6L;
        this.jmP.aLH();
        this.jtv = null;
        str2 = aVi();
        str1 = ((v)paramn).aLu();
        i = ((v)paramn).aLv();
        str3 = ((v)paramn).aLw();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bx.M(str3, "wording");
        if (localMap == null) {
          break label1722;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bu.isNullOrNil((String)localObject3)) {
          break label566;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1722;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bu.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bu.isNullOrNil((String)localObject3)) {
          break label1719;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.dC(true);
      if (this.jrv)
      {
        localObject3 = com.tencent.mm.loader.j.b.asr() + "temp.avatar";
        str3 = com.tencent.mm.loader.j.b.asr() + "temp.avatar.hd";
        com.tencent.mm.vfs.o.mG((String)localObject3, str3);
        com.tencent.mm.vfs.o.deleteFile((String)localObject3);
        com.tencent.mm.sdk.platformtools.h.c(str3, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.aj.n(this, com.tencent.mm.loader.j.b.asr() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128674);
            RegSetInfoUI.b(RegSetInfoUI.this, ((v)paramn).aLs());
            bb.hIK.aM("login_user_name", str2);
            com.tencent.mm.vfs.o.deleteFile(com.tencent.mm.loader.j.b.asr() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.KB("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128674);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.jqA);
                ((Intent)localObject1).putExtra("alert_message", this.jqB);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.ajP();
            com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128674);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128675);
            RegSetInfoUI.b(RegSetInfoUI.this, ((v)paramn).aLs());
            bb.hIK.aM("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.KB("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128675);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.jqA);
                ((Intent)localObject1).putExtra("alert_message", this.jqB);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.ajP();
            com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128675);
          }
        });
      }
      for (;;)
      {
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.jfm == null)
          {
            this.jfm = SecurityImage.a.a(getContext(), 0, ((v)paramn).aLj(), ((v)paramn).aLi(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128677);
                paramAnonymousDialogInterface = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                Object localObject = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                if ((localObject == null) || (((String)localObject).length() <= 0))
                {
                  com.tencent.mm.ui.base.h.l(RegSetInfoUI.this, 2131764648, 2131762346);
                  AppMethodBeat.o(128677);
                  return;
                }
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.ajj().a(126, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new v("", RegSetInfoUI.y(RegSetInfoUI.this), (String)localObject, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, ((v)paramn).aLi(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode(), RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                paramAnonymousDialogInterface.GP(RegSetInfoUI.E(RegSetInfoUI.this));
                paramAnonymousDialogInterface.GQ(RegSetInfoUI.F(RegSetInfoUI.this));
                paramAnonymousDialogInterface.pW(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
                localObject = RegSetInfoUI.this;
                RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(2131755906);
                RegSetInfoUI.a((RegSetInfoUI)localObject, com.tencent.mm.ui.base.h.b(localRegSetInfoUI, RegSetInfoUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128676);
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.ajj().b(126, RegSetInfoUI.this);
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
              public final void aSU()
              {
                AppMethodBeat.i(128680);
                RegSetInfoUI.this.hideVKB();
                Object localObject = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                String str = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.ajj().a(126, RegSetInfoUI.this);
                localObject = new v("", RegSetInfoUI.y(RegSetInfoUI.this), str, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject, ((v)paramn).aLi(), "", RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                ((v)localObject).GP(RegSetInfoUI.E(RegSetInfoUI.this));
                ((v)localObject).GQ(RegSetInfoUI.F(RegSetInfoUI.this));
                ((v)localObject).pW(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
                AppMethodBeat.o(128680);
              }
            });
            AppMethodBeat.o(128713);
            return;
            label566:
            int j = bu.aSB((String)localObject3);
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
            this.fRw = ((v)paramn).aLs();
            bb.hIK.aM("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.KB("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.fRw);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
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
            localObject1 = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.ajP();
            com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_900_phone") + ",4");
            finish();
            continue;
          }
          this.jfm.b(0, ((v)paramn).aLj(), ((v)paramn).aLi(), "");
          AppMethodBeat.o(128713);
          return;
        }
      }
      localObject1 = com.tencent.mm.h.a.uU(paramString);
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
        com.tencent.mm.kernel.g.ajj().b(429, this);
        if (this.fOC != null)
        {
          this.fOC.dismiss();
          this.fOC = null;
        }
        this.jtq.setVisibility(8);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.jtv = null;
          paramInt1 = ((u.b)((ag)paramn).hRG.getRespObj()).jgR.GXd;
          com.tencent.mm.sdk.platformtools.ae.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
          {
            paramn = ((u.b)((ag)paramn).hRG.getRespObj()).jgR.nIE;
            paramString = com.tencent.mm.h.a.uU(paramString);
            if (paramString != null) {
              this.jtj.setText(paramString.desc);
            }
            this.jto.clear();
            if ((paramn != null) && (paramn.size() > 0))
            {
              if (paramn.size() > 3) {}
              for (paramInt1 = 3;; paramInt1 = paramn.size())
              {
                paramString = new String[paramInt1];
                paramInt2 = 0;
                while (paramInt2 < paramInt1)
                {
                  paramString[paramInt2] = ((cxn)paramn.get(paramInt2)).HId;
                  this.jto.add(paramString[paramInt2]);
                  paramInt2 += 1;
                }
              }
              if (this.jtz)
              {
                if (this.jtx != null)
                {
                  this.jtx.dismiss();
                  this.jtx = null;
                }
                this.jtx = p.a(this, this.jty, paramString, new AdapterView.OnItemClickListener()
                {
                  public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(128687);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymousAdapterView);
                    localb.bd(paramAnonymousView);
                    localb.mu(paramAnonymousInt);
                    localb.rl(paramAnonymousLong);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$25", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
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
          if (bu.isNullOrNil(this.jtc.getText().toString().trim()))
          {
            q(false, false);
            AppMethodBeat.o(128713);
            return;
          }
          q(true, false);
          this.jtj.setText(getString(2131762404));
          if (this.jtx != null)
          {
            this.jtx.dismiss();
            this.jtx = null;
          }
          this.jtc.postDelayed(new Runnable()
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
          if (this.jfm == null)
          {
            this.jfm = SecurityImage.a.a(getContext(), 0, ((ag)paramn).aLj(), ((ag)paramn).aLi(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128683);
                paramAnonymousDialogInterface = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                Object localObject1 = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.length() <= 0))
                {
                  com.tencent.mm.ui.base.h.l(RegSetInfoUI.this, 2131764648, 2131762346);
                  AppMethodBeat.o(128683);
                  return;
                }
                RegSetInfoUI.this.hideVKB();
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject2 = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.ajj().a(429, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new ag((String)localObject2, RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, (String)localObject1, ((ag)paramn).aLi(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode());
                com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
                localObject1 = RegSetInfoUI.this;
                localObject2 = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(2131755906);
                RegSetInfoUI.a((RegSetInfoUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, RegSetInfoUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128682);
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.ajj().b(429, RegSetInfoUI.this);
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
              public final void aSU()
              {
                AppMethodBeat.i(128685);
                RegSetInfoUI.this.hideVKB();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.ajj().a(429, RegSetInfoUI.this);
                localObject = new ag((String)localObject, RegSetInfoUI.g(RegSetInfoUI.this), i, "", "", ((ag)paramn).aLi(), "");
                com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
                AppMethodBeat.o(128685);
              }
            });
            AppMethodBeat.o(128713);
            return;
          }
          this.jfm.b(0, ((ag)paramn).aLj(), ((ag)paramn).aLi(), "");
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
        this.jtv = getString(2131759510, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, this.jtv, 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI
 * JD-Core Version:    0.7.0.1
 */