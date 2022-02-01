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
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.u.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String bLs;
  private ProgressDialog fts;
  private String fwd;
  private SecurityImage iJk;
  private fl iQO;
  private com.tencent.mm.platformtools.b iRU;
  private int iTT;
  private int iTZ;
  private String iTi;
  private String iUT;
  private int iUb;
  private boolean iVt;
  private EditText iWj;
  private EditText iXa;
  private Button iXb;
  private String iXc;
  private String iXd;
  private int iXe;
  private String iXf;
  private String iXg;
  private TextView iXh;
  private View iXi;
  private boolean iXj;
  private ImageView iXk;
  private int iXl;
  private LinkedList<String> iXm;
  private ImageView iXn;
  private ProgressBar iXo;
  private String iXp;
  private ImageView iXq;
  private View iXr;
  private TextView iXs;
  private String iXt;
  private boolean iXu;
  private o iXv;
  private View iXw;
  private boolean iXx;
  private String iXy;
  private au iXz;
  private int sceneType;
  
  public RegSetInfoUI()
  {
    AppMethodBeat.i(128701);
    this.fts = null;
    this.sceneType = 0;
    this.iJk = null;
    this.iXj = false;
    this.iVt = false;
    this.iXl = 3;
    this.iXm = new LinkedList();
    this.iXp = "";
    this.iXt = null;
    this.iXu = false;
    this.iXx = false;
    this.iQO = new fl();
    this.iXz = new au(Looper.myLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(128668);
        String str = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
        Object localObject2 = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
        Object localObject1 = str;
        if (bs.isNullOrNil(str))
        {
          localObject1 = str;
          if (!bs.isNullOrNil((String)localObject2)) {
            if (((String)localObject2).length() <= 5) {
              break label203;
            }
          }
        }
        label203:
        for (localObject1 = ((String)localObject2).substring(0, 5);; localObject1 = localObject2)
        {
          if ((!bs.isNullOrNil((String)localObject1)) && (bs.isNullOrNil((String)localObject2))) {
            localObject2 = localObject1;
          }
          for (;;)
          {
            if ((!bs.isNullOrNil((String)localObject1)) && (RegSetInfoUI.c(RegSetInfoUI.this)) && (RegSetInfoUI.d(RegSetInfoUI.this)))
            {
              int i = RegSetInfoUI.e(RegSetInfoUI.this);
              str = RegSetInfoUI.f(RegSetInfoUI.this);
              com.tencent.mm.kernel.g.agi().a(429, RegSetInfoUI.this);
              localObject1 = new ag(str, RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject2, (String)localObject1, "", "");
              com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
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
  
  private void aOO()
  {
    AppMethodBeat.i(128716);
    hideVKB();
    if (aRr())
    {
      h.a(this, getString(2131762397), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.a(localRegSetInfoUI, paramAnonymousDialogInterface.aeD(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localRegSetInfoUI.startActivity((Intent)paramAnonymousDialogInterface.lR(0));
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
    if (!aRs())
    {
      if (aRt())
      {
        h.a(this, getString(2131762396), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128692);
            com.tencent.mm.plugin.b.a.IL("R400_100_signup");
            Object localObject = new Intent(RegSetInfoUI.this, LoginUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
      if (aRv())
      {
        h.a(this, getString(2131762396), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128693);
            com.tencent.mm.plugin.b.a.IL("R500_100");
            Object localObject = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
      com.tencent.mm.plugin.b.a.IL("R200_100");
      Object localObject = new Intent(this, MobileInputUI.class);
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
    }
    AppMethodBeat.o(128716);
  }
  
  private void aRm()
  {
    AppMethodBeat.i(128706);
    int j = aRw();
    com.tencent.mm.kernel.g.agi().a(126, this);
    int i;
    final u localu;
    if (aRq()) {
      if ((this.iXm == null) || (this.iXm.size() == 0))
      {
        i = 0;
        localu = new u("", this.iXf, this.bLs, this.iXe, this.iXd, this.iXc, "", "", this.fwd, j, this.iXy, "", "", this.iXj, this.iVt);
        ((x.a)localu.hwy.getReqObj()).DJs.FmL = i;
      }
    }
    for (;;)
    {
      localu.Di(this.iTi);
      localu.Dj(this.iUT);
      localu.pq(this.iTT);
      com.tencent.mm.kernel.g.agi().a(localu, 0);
      getString(2131755906);
      this.fts = h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128673);
          com.tencent.mm.kernel.g.agi().a(localu);
          com.tencent.mm.kernel.g.agi().b(126, RegSetInfoUI.this);
          AppMethodBeat.o(128673);
        }
      });
      AppMethodBeat.o(128706);
      return;
      if (this.iXm.contains(this.iXy))
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      localu = new u("", this.iXf, this.bLs, this.iXe, this.iXd, this.iXc, "", "", this.fwd, j, "", "", "", this.iXj, this.iVt);
    }
  }
  
  private boolean aRn()
  {
    AppMethodBeat.i(128708);
    if ((this.iXn.getVisibility() == 8) || (this.iXu))
    {
      AppMethodBeat.o(128708);
      return true;
    }
    AppMethodBeat.o(128708);
    return false;
  }
  
  private void aRo()
  {
    AppMethodBeat.i(128709);
    String str = this.iWj.getText().toString().trim();
    Button localButton = this.iXb;
    if (!bs.isNullOrNil(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      AppMethodBeat.o(128709);
      return;
    }
  }
  
  private boolean aRp()
  {
    return (this.iXl & 0x1) > 0;
  }
  
  private boolean aRq()
  {
    return (this.iXl & 0x2) > 0;
  }
  
  private boolean aRr()
  {
    return this.sceneType == 1;
  }
  
  private boolean aRs()
  {
    return this.sceneType == 2;
  }
  
  private boolean aRt()
  {
    return this.sceneType == 0;
  }
  
  private boolean aRu()
  {
    return this.sceneType == 4;
  }
  
  private boolean aRv()
  {
    return this.sceneType == 3;
  }
  
  private int aRw()
  {
    AppMethodBeat.i(128711);
    if (aRr())
    {
      AppMethodBeat.o(128711);
      return 4;
    }
    if (aRs())
    {
      AppMethodBeat.o(128711);
      return 2;
    }
    if (aRv())
    {
      AppMethodBeat.o(128711);
      return 6;
    }
    if (aRu())
    {
      AppMethodBeat.o(128711);
      return 1;
    }
    AppMethodBeat.o(128711);
    return 2;
  }
  
  private String aRx()
  {
    AppMethodBeat.i(128712);
    if ((aRr()) || (aRu()))
    {
      str = this.iXc;
      AppMethodBeat.o(128712);
      return str;
    }
    if (aRv())
    {
      str = this.iXd;
      AppMethodBeat.o(128712);
      return str;
    }
    String str = this.iXg;
    AppMethodBeat.o(128712);
    return str;
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128714);
    Object localObject = new ad(paramInt1, paramInt2, paramString);
    if (this.iRU.a(this, (ad)localObject))
    {
      AppMethodBeat.o(128714);
      return true;
    }
    if (com.tencent.mm.plugin.account.a.a.iyy.a(getContext(), paramInt1, paramInt2, paramString))
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
      com.tencent.mm.kernel.g.agP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
      for (paramString = com.tencent.mm.cc.a.aw(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.afG())
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
        com.tencent.mm.kernel.g.agP();
      }
    }
    paramString = com.tencent.mm.h.a.rM(paramString);
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
    if (bs.isNullOrNil(this.iXa.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.iXn;
    if (paramBoolean2)
    {
      i = 2131234064;
      localImageView.setImageResource(i);
      localImageView = this.iXn;
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
      this.iXu = bool1;
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
    this.iXw = findViewById(2131303345);
    this.iXr = findViewById(2131304608);
    this.iXk = ((ImageView)findViewById(2131304607));
    this.iWj = ((EditText)findViewById(2131303939));
    this.iXs = ((TextView)findViewById(2131304610));
    this.iXa = ((EditText)findViewById(2131303946));
    this.iXh = ((TextView)findViewById(2131296638));
    this.iXi = findViewById(2131303965);
    this.iXn = ((ImageView)findViewById(2131306943));
    this.iXo = ((ProgressBar)findViewById(2131303516));
    this.iXq = ((ImageView)findViewById(2131304609));
    this.iXb = ((Button)findViewById(2131302852));
    this.iXn.setVisibility(8);
    this.iXo.setVisibility(8);
    this.iXq.setVisibility(8);
    this.iVt = false;
    this.iXu = false;
    Object localObject = this.iXr;
    int i;
    if (aRp())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.iXi;
      if (!aRq()) {
        break label491;
      }
      i = 0;
      label237:
      ((View)localObject).setVisibility(i);
      localObject = this.iXh;
      if (!aRq()) {
        break label497;
      }
      i = j;
      label256:
      ((TextView)localObject).setVisibility(i);
      if ((!aRp()) || (!aRq())) {
        break label503;
      }
      this.iXs.setText(getString(2131762402));
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agU().a(new ap.a()
      {
        String iXH;
        Bitmap mBitmap;
        
        public final boolean aBj()
        {
          AppMethodBeat.i(128690);
          AppMethodBeat.o(128690);
          return true;
        }
        
        public final boolean aBk()
        {
          AppMethodBeat.i(128689);
          if ((!bs.isNullOrNil(this.iXH)) && (bs.isNullOrNil(RegSetInfoUI.b(RegSetInfoUI.this).getText().trim()))) {
            RegSetInfoUI.b(RegSetInfoUI.this).setText(this.iXH);
          }
          if (!com.tencent.mm.compatible.util.e.YD())
          {
            ac.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
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
      this.iWj.addTextChangedListener(new TextWatcher()
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
          if (!RegSetInfoUI.m(RegSetInfoUI.this).eVs()) {
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
      this.iXb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128695);
          RegSetInfoUI.p(RegSetInfoUI.this);
          AppMethodBeat.o(128695);
        }
      });
      this.iXa.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128696);
          if (paramAnonymousBoolean)
          {
            RegSetInfoUI.q(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).au(200L, 200L);
          }
          AppMethodBeat.o(128696);
        }
      });
      this.iXa.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128698);
          if (!RegSetInfoUI.m(RegSetInfoUI.this).eVs()) {
            RegSetInfoUI.m(RegSetInfoUI.this).stopTimer();
          }
          paramAnonymousEditable = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
          if (bs.isNullOrNil(paramAnonymousEditable))
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
          if ((!bs.isNullOrNil(paramAnonymousEditable)) && ((RegSetInfoUI.c(RegSetInfoUI.this)) || (!paramAnonymousEditable.equals(RegSetInfoUI.v(RegSetInfoUI.this)))))
          {
            RegSetInfoUI.s(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).au(500L, 500L);
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
      this.iWj.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.iWj.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128669);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            RegSetInfoUI.p(RegSetInfoUI.this);
            AppMethodBeat.o(128669);
            return true;
          }
          AppMethodBeat.o(128669);
          return false;
        }
      });
      this.iXa.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.iXa.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128671);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            RegSetInfoUI.p(RegSetInfoUI.this);
            AppMethodBeat.o(128671);
            return true;
          }
          AppMethodBeat.o(128671);
          return false;
        }
      });
      this.iXk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128672);
          RegSetInfoUI.x(RegSetInfoUI.this);
          AppMethodBeat.o(128672);
        }
      });
      localObject = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apo());
      if (!((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).mkdirs();
      }
      aRo();
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
      if ((aRp()) && (!aRq())) {
        this.iXs.setText(getString(2131762400));
      } else if ((!aRp()) && (aRq())) {
        this.iXs.setText(getString(2131762401));
      } else {
        this.iXs.setText(getString(2131762399));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128710);
    ac.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramIntent != null) && (paramInt1 == 300))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
        aRm();
      }
      AppMethodBeat.o(128710);
      return;
    }
    paramIntent = com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.iXk.setImageBitmap(paramIntent);
      this.iVt = true;
      this.iXq.setVisibility(0);
    }
    AppMethodBeat.o(128710);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128702);
    super.onCreate(paramBundle);
    paramBundle = getString(2131762405);
    if (d.DIf) {
      paramBundle = getString(2131755822) + getString(2131755263);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.iyy.Lm();
    this.iXc = getIntent().getStringExtra("regsetinfo_user");
    this.iXd = getIntent().getStringExtra("regsetinfo_bind_email");
    this.fwd = getIntent().getStringExtra("regsetinfo_ticket");
    this.iXf = getIntent().getStringExtra("regsetinfo_pwd");
    this.iXg = getIntent().getStringExtra("regsetinfo_binduin");
    this.iTT = getIntent().getIntExtra("mobile_check_type", 0);
    if (!bs.isNullOrNil(this.iXg)) {
      this.iXe = com.tencent.mm.b.p.dv(this.iXg);
    }
    this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.iXj = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.iXl = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    this.iTi = getIntent().getStringExtra("regsession_id");
    this.iUT = getIntent().getStringExtra("reg_3d_app_ticket");
    this.iUb = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.iTZ = getIntent().getIntExtra("key_reg_style", 1);
    initView();
    if (this.sceneType == 1)
    {
      paramBundle = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      paramBundle = paramBundle.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R200_900_phone") + ",1");
      com.tencent.mm.plugin.b.a.IK("R200_900_phone");
    }
    for (;;)
    {
      this.iXx = false;
      this.iRU = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128702);
      return;
      if (this.sceneType == 2)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R4_QQ") + ",1");
        com.tencent.mm.plugin.b.a.IK("R4_QQ");
      }
      else if (this.sceneType == 3)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R200_900_email") + ",1");
        com.tencent.mm.plugin.b.a.IK("R200_900_email");
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
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.iRU != null) {
        this.iRU.close();
      }
      AppMethodBeat.o(128704);
      return;
      if (this.sceneType == 2)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R4_QQ") + ",2");
      }
      else if (this.sceneType == 3)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128715);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aOO();
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
    this.iWj.postDelayed(new Runnable()
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
    ac.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
      com.tencent.mm.kernel.g.agi().b(126, this);
      if (this.fts != null)
      {
        this.fts.dismiss();
        this.fts = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.iQO.dXB = this.iUb;
        this.iQO.dCQ = 6L;
        this.iQO.aHZ();
        this.iXt = null;
        str2 = aRx();
        str1 = ((u)paramn).aHM();
        i = ((u)paramn).aHN();
        str3 = ((u)paramn).aHO();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bv.L(str3, "wording");
        if (localMap == null) {
          break label1722;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bs.isNullOrNil((String)localObject3)) {
          break label566;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1722;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bs.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bs.isNullOrNil((String)localObject3)) {
          break label1719;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      ac.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.dz(true);
      if (this.iVt)
      {
        localObject3 = com.tencent.mm.loader.j.b.apo() + "temp.avatar";
        str3 = com.tencent.mm.loader.j.b.apo() + "temp.avatar.hd";
        i.ma((String)localObject3, str3);
        i.deleteFile((String)localObject3);
        f.c(str3, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.aj.n(this, com.tencent.mm.loader.j.b.apo() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128674);
            RegSetInfoUI.b(RegSetInfoUI.this, ((u)paramn).aHK());
            ay.hnA.aL("login_user_name", str2);
            i.deleteFile(com.tencent.mm.loader.j.b.apo() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.IL("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128674);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.iUy);
                ((Intent)localObject1).putExtra("alert_message", this.iUz);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.agP();
            com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128674);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128675);
            RegSetInfoUI.b(RegSetInfoUI.this, ((u)paramn).aHK());
            ay.hnA.aL("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.IL("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128675);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.iUy);
                ((Intent)localObject1).putExtra("alert_message", this.iUz);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.agP();
            com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128675);
          }
        });
      }
      for (;;)
      {
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.iJk == null)
          {
            this.iJk = SecurityImage.a.a(getContext(), 0, ((u)paramn).aHB(), ((u)paramn).aHA(), "", new DialogInterface.OnClickListener()
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
                com.tencent.mm.kernel.g.agi().a(126, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new u("", RegSetInfoUI.y(RegSetInfoUI.this), (String)localObject, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, ((u)paramn).aHA(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode(), RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                paramAnonymousDialogInterface.Di(RegSetInfoUI.E(RegSetInfoUI.this));
                paramAnonymousDialogInterface.Dj(RegSetInfoUI.F(RegSetInfoUI.this));
                paramAnonymousDialogInterface.pq(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
                localObject = RegSetInfoUI.this;
                RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(2131755906);
                RegSetInfoUI.a((RegSetInfoUI)localObject, h.b(localRegSetInfoUI, RegSetInfoUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128676);
                    com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.agi().b(126, RegSetInfoUI.this);
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
              public final void aPj()
              {
                AppMethodBeat.i(128680);
                RegSetInfoUI.this.hideVKB();
                Object localObject = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                String str = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.agi().a(126, RegSetInfoUI.this);
                localObject = new u("", RegSetInfoUI.y(RegSetInfoUI.this), str, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject, ((u)paramn).aHA(), "", RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                ((u)localObject).Di(RegSetInfoUI.E(RegSetInfoUI.this));
                ((u)localObject).Dj(RegSetInfoUI.F(RegSetInfoUI.this));
                ((u)localObject).pq(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
                AppMethodBeat.o(128680);
              }
            });
            AppMethodBeat.o(128713);
            return;
            label566:
            int j = bs.aLy((String)localObject3);
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
            this.fwd = ((u)paramn).aHK();
            ay.hnA.aL("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.IL("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.fwd);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
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
            localObject1 = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.agP();
            com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_900_phone") + ",4");
            finish();
            continue;
          }
          this.iJk.b(0, ((u)paramn).aHB(), ((u)paramn).aHA(), "");
          AppMethodBeat.o(128713);
          return;
        }
      }
      localObject1 = com.tencent.mm.h.a.rM(paramString);
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
        com.tencent.mm.kernel.g.agi().b(429, this);
        if (this.fts != null)
        {
          this.fts.dismiss();
          this.fts = null;
        }
        this.iXo.setVisibility(8);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.iXt = null;
          paramInt1 = ((u.b)((ag)paramn).hwy.getRespObj()).iKP.EUd;
          ac.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
          {
            paramn = ((u.b)((ag)paramn).hwy.getRespObj()).iKP.ncM;
            paramString = com.tencent.mm.h.a.rM(paramString);
            if (paramString != null) {
              this.iXh.setText(paramString.desc);
            }
            this.iXm.clear();
            if ((paramn != null) && (paramn.size() > 0))
            {
              if (paramn.size() > 3) {}
              for (paramInt1 = 3;; paramInt1 = paramn.size())
              {
                paramString = new String[paramInt1];
                paramInt2 = 0;
                while (paramInt2 < paramInt1)
                {
                  paramString[paramInt2] = ((crm)paramn.get(paramInt2)).FEm;
                  this.iXm.add(paramString[paramInt2]);
                  paramInt2 += 1;
                }
              }
              if (this.iXx)
              {
                if (this.iXv != null)
                {
                  this.iXv.dismiss();
                  this.iXv = null;
                }
                this.iXv = p.a(this, this.iXw, paramString, new AdapterView.OnItemClickListener()
                {
                  public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(128687);
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
                    AppMethodBeat.o(128687);
                  }
                });
              }
            }
            q(true, true);
            AppMethodBeat.o(128713);
            return;
          }
          if (bs.isNullOrNil(this.iXa.getText().toString().trim()))
          {
            q(false, false);
            AppMethodBeat.o(128713);
            return;
          }
          q(true, false);
          this.iXh.setText(getString(2131762404));
          if (this.iXv != null)
          {
            this.iXv.dismiss();
            this.iXv = null;
          }
          this.iXa.postDelayed(new Runnable()
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
          if (this.iJk == null)
          {
            this.iJk = SecurityImage.a.a(getContext(), 0, ((ag)paramn).aHB(), ((ag)paramn).aHA(), "", new DialogInterface.OnClickListener()
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
                com.tencent.mm.kernel.g.agi().a(429, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new ag((String)localObject2, RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, (String)localObject1, ((ag)paramn).aHA(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode());
                com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
                localObject1 = RegSetInfoUI.this;
                localObject2 = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(2131755906);
                RegSetInfoUI.a((RegSetInfoUI)localObject1, h.b((Context)localObject2, RegSetInfoUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128682);
                    com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.g.agi().b(429, RegSetInfoUI.this);
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
              public final void aPj()
              {
                AppMethodBeat.i(128685);
                RegSetInfoUI.this.hideVKB();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.g.agi().a(429, RegSetInfoUI.this);
                localObject = new ag((String)localObject, RegSetInfoUI.g(RegSetInfoUI.this), i, "", "", ((ag)paramn).aHA(), "");
                com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
                AppMethodBeat.o(128685);
              }
            });
            AppMethodBeat.o(128713);
            return;
          }
          this.iJk.b(0, ((ag)paramn).aHB(), ((ag)paramn).aHA(), "");
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
        this.iXt = getString(2131759510, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, this.iXt, 0).show();
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