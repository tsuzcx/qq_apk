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
import com.tencent.mm.aj.n;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.u.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.protocal.protobuf.dqi;
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
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements i
{
  private ProgressDialog gtM;
  private String gwF;
  private SecurityImage kdp;
  private ka kkY;
  private com.tencent.mm.platformtools.b kmf;
  private String knu;
  private int koh;
  private int kon;
  private int kop;
  private boolean kpI;
  private String kph;
  private EditText kqA;
  private boolean krA;
  private ImageView krB;
  private int krC;
  private LinkedList<String> krD;
  private ImageView krE;
  private ProgressBar krF;
  private String krG;
  private ImageView krH;
  private View krI;
  private TextView krJ;
  private String krK;
  private boolean krL;
  private com.tencent.mm.ui.base.p krM;
  private View krN;
  private boolean krO;
  private String krP;
  private MTimerHandler krQ;
  private EditText krr;
  private Button krs;
  private String krt;
  private String kru;
  private int krv;
  private String krw;
  private String krx;
  private TextView kry;
  private View krz;
  private String nickName;
  private int sceneType;
  
  public RegSetInfoUI()
  {
    AppMethodBeat.i(128701);
    this.gtM = null;
    this.sceneType = 0;
    this.kdp = null;
    this.krA = false;
    this.kpI = false;
    this.krC = 3;
    this.krD = new LinkedList();
    this.krG = "";
    this.krK = null;
    this.krL = false;
    this.krO = false;
    this.kkY = new ka();
    this.krQ = new MTimerHandler(Looper.myLooper(), new MTimerHandler.CallBack()
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
              g.azz().a(429, RegSetInfoUI.this);
              localObject1 = new ag(str, RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject2, (String)localObject1, "", "");
              g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
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
  
  private void bnm()
  {
    AppMethodBeat.i(128716);
    hideVKB();
    if (bpO())
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131764463), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.a(localRegSetInfoUI, paramAnonymousDialogInterface.axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localRegSetInfoUI.startActivity((Intent)paramAnonymousDialogInterface.pG(0));
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
    if (!bpP())
    {
      if (bpQ())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131764462), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128692);
            com.tencent.mm.plugin.b.a.bwV("R400_100_signup");
            Object localObject = new Intent(RegSetInfoUI.this, LoginUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      if (bpS())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131764462), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128693);
            com.tencent.mm.plugin.b.a.bwV("R500_100");
            Object localObject = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      com.tencent.mm.plugin.b.a.bwV("R200_100");
      Object localObject = new Intent(this, MobileInputUI.class);
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
    }
    AppMethodBeat.o(128716);
  }
  
  private void bpJ()
  {
    AppMethodBeat.i(128706);
    int j = bpT();
    g.azz().a(126, this);
    int i;
    final v localv;
    if (bpN()) {
      if ((this.krD == null) || (this.krD.size() == 0))
      {
        i = 0;
        localv = new v("", this.krw, this.nickName, this.krv, this.kru, this.krt, "", "", this.gwF, j, this.krP, "", "", this.krA, this.kpI);
        ((x.a)localv.iMO.getReqObj()).KAi.MyA = i;
      }
    }
    for (;;)
    {
      localv.PB(this.knu);
      localv.PC(this.kph);
      localv.tL(this.koh);
      g.azz().a(localv, 0);
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131764451), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128673);
          g.azz().a(localv);
          g.azz().b(126, RegSetInfoUI.this);
          AppMethodBeat.o(128673);
        }
      });
      AppMethodBeat.o(128706);
      return;
      if (this.krD.contains(this.krP))
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      localv = new v("", this.krw, this.nickName, this.krv, this.kru, this.krt, "", "", this.gwF, j, "", "", "", this.krA, this.kpI);
    }
  }
  
  private boolean bpK()
  {
    AppMethodBeat.i(128708);
    if ((this.krE.getVisibility() == 8) || (this.krL))
    {
      AppMethodBeat.o(128708);
      return true;
    }
    AppMethodBeat.o(128708);
    return false;
  }
  
  private void bpL()
  {
    AppMethodBeat.i(128709);
    String str = this.kqA.getText().toString().trim();
    Button localButton = this.krs;
    if (!Util.isNullOrNil(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      AppMethodBeat.o(128709);
      return;
    }
  }
  
  private boolean bpM()
  {
    return (this.krC & 0x1) > 0;
  }
  
  private boolean bpN()
  {
    return (this.krC & 0x2) > 0;
  }
  
  private boolean bpO()
  {
    return this.sceneType == 1;
  }
  
  private boolean bpP()
  {
    return this.sceneType == 2;
  }
  
  private boolean bpQ()
  {
    return this.sceneType == 0;
  }
  
  private boolean bpR()
  {
    return this.sceneType == 4;
  }
  
  private boolean bpS()
  {
    return this.sceneType == 3;
  }
  
  private int bpT()
  {
    AppMethodBeat.i(128711);
    if (bpO())
    {
      AppMethodBeat.o(128711);
      return 4;
    }
    if (bpP())
    {
      AppMethodBeat.o(128711);
      return 2;
    }
    if (bpS())
    {
      AppMethodBeat.o(128711);
      return 6;
    }
    if (bpR())
    {
      AppMethodBeat.o(128711);
      return 1;
    }
    AppMethodBeat.o(128711);
    return 2;
  }
  
  private String bpU()
  {
    AppMethodBeat.i(128712);
    if ((bpO()) || (bpR()))
    {
      str = this.krt;
      AppMethodBeat.o(128712);
      return str;
    }
    if (bpS())
    {
      str = this.kru;
      AppMethodBeat.o(128712);
      return str;
    }
    String str = this.krx;
    AppMethodBeat.o(128712);
    return str;
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128714);
    Object localObject = new ae(paramInt1, paramInt2, paramString);
    if (this.kmf.a(this, (ae)localObject))
    {
      AppMethodBeat.o(128714);
      return true;
    }
    if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString))
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
      com.tencent.mm.ui.base.h.n(this, 2131764340, 2131764341);
      AppMethodBeat.o(128714);
      return true;
    case -75: 
      com.tencent.mm.ui.base.h.n(this, 2131755301, 2131764341);
      AppMethodBeat.o(128714);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.a.hold();
      localObject = getContext();
      g.aAf();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
      for (paramString = com.tencent.mm.cb.a.aI(getContext(), 2131762849);; paramString = com.tencent.mm.kernel.a.ayX())
      {
        com.tencent.mm.ui.base.h.a((Context)localObject, paramString, getContext().getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128714);
        return true;
        g.aAf();
      }
    }
    paramString = com.tencent.mm.h.a.Dk(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
    for (;;)
    {
      AppMethodBeat.o(128714);
      return true;
      com.tencent.mm.ui.base.h.c(this, getString(2131764469), "", true);
    }
  }
  
  private void q(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(128707);
    if (Util.isNullOrNil(this.krr.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.krE;
    if (paramBoolean2)
    {
      i = 2131234906;
      localImageView.setImageResource(i);
      localImageView = this.krE;
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
      this.krL = bool1;
      AppMethodBeat.o(128707);
      return;
      i = 2131234903;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496090;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(128705);
    this.krN = findViewById(2131306032);
    this.krI = findViewById(2131307660);
    this.krB = ((ImageView)findViewById(2131307659));
    this.kqA = ((EditText)findViewById(2131306793));
    this.krJ = ((TextView)findViewById(2131307662));
    this.krr = ((EditText)findViewById(2131306800));
    this.kry = ((TextView)findViewById(2131296715));
    this.krz = findViewById(2131306819);
    this.krE = ((ImageView)findViewById(2131310418));
    this.krF = ((ProgressBar)findViewById(2131306282));
    this.krH = ((ImageView)findViewById(2131307661));
    this.krs = ((Button)findViewById(2131305423));
    this.krE.setVisibility(8);
    this.krF.setVisibility(8);
    this.krH.setVisibility(8);
    this.kpI = false;
    this.krL = false;
    Object localObject = this.krI;
    int i;
    if (bpM())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.krz;
      if (!bpN()) {
        break label491;
      }
      i = 0;
      label237:
      ((View)localObject).setVisibility(i);
      localObject = this.kry;
      if (!bpN()) {
        break label497;
      }
      i = j;
      label256:
      ((TextView)localObject).setVisibility(i);
      if ((!bpM()) || (!bpN())) {
        break label503;
      }
      this.krJ.setText(getString(2131764468));
    }
    for (;;)
    {
      g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
      {
        String krY;
        Bitmap mBitmap;
        
        public final boolean doInBackground()
        {
          AppMethodBeat.i(128690);
          AppMethodBeat.o(128690);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          AppMethodBeat.i(128689);
          if ((!Util.isNullOrNil(this.krY)) && (Util.isNullOrNil(RegSetInfoUI.b(RegSetInfoUI.this).getText().trim()))) {
            RegSetInfoUI.b(RegSetInfoUI.this).setText(this.krY);
          }
          if (!e.apn())
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
      this.kqA.addTextChangedListener(new TextWatcher()
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
      this.krs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128695);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RegSetInfoUI.p(RegSetInfoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128695);
        }
      });
      this.krr.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
      this.krr.addTextChangedListener(new TextWatcher()
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
            RegSetInfoUI.r(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(2131764470));
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
      this.kqA.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.kqA.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128669);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.bm(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
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
      this.krr.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.krr.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128671);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.bm(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$12", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
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
      this.krB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128672);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RegSetInfoUI.x(RegSetInfoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128672);
        }
      });
      localObject = new o(com.tencent.mm.loader.j.b.aKR());
      if (!((o)localObject).exists()) {
        ((o)localObject).mkdirs();
      }
      bpL();
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
      if ((bpM()) && (!bpN())) {
        this.krJ.setText(getString(2131764466));
      } else if ((!bpM()) && (bpN())) {
        this.krJ.setText(getString(2131764467));
      } else {
        this.krJ.setText(getString(2131764465));
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
        bpJ();
      }
      AppMethodBeat.o(128710);
      return;
    }
    paramIntent = com.tencent.mm.plugin.account.a.a.jRu.b(this, paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.krB.setImageBitmap(paramIntent);
      this.kpI = true;
      this.krH.setVisibility(0);
    }
    AppMethodBeat.o(128710);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128702);
    super.onCreate(paramBundle);
    paramBundle = getString(2131764471);
    if ((d.KyR) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755908) + com.tencent.mm.cc.h.jr(this);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.krt = getIntent().getStringExtra("regsetinfo_user");
    this.kru = getIntent().getStringExtra("regsetinfo_bind_email");
    this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
    this.krw = getIntent().getStringExtra("regsetinfo_pwd");
    this.krx = getIntent().getStringExtra("regsetinfo_binduin");
    this.koh = getIntent().getIntExtra("mobile_check_type", 0);
    if (!Util.isNullOrNil(this.krx)) {
      this.krv = com.tencent.mm.b.p.fd(this.krx);
    }
    this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.krA = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.krC = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    this.knu = getIntent().getStringExtra("regsession_id");
    this.kph = getIntent().getStringExtra("reg_3d_app_ticket");
    this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.kon = getIntent().getIntExtra("key_reg_style", 1);
    initView();
    if (this.sceneType == 1)
    {
      paramBundle = new StringBuilder();
      g.aAf();
      paramBundle = paramBundle.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R200_900_phone") + ",1");
      com.tencent.mm.plugin.b.a.bwU("R200_900_phone");
    }
    for (;;)
    {
      this.krO = false;
      this.kmf = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128702);
      return;
      if (this.sceneType == 2)
      {
        paramBundle = new StringBuilder();
        g.aAf();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R4_QQ,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R4_QQ") + ",1");
        com.tencent.mm.plugin.b.a.bwU("R4_QQ");
      }
      else if (this.sceneType == 3)
      {
        paramBundle = new StringBuilder();
        g.aAf();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_email,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R200_900_email") + ",1");
        com.tencent.mm.plugin.b.a.bwU("R200_900_email");
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
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.kmf != null) {
        this.kmf.close();
      }
      AppMethodBeat.o(128704);
      return;
      if (this.sceneType == 2)
      {
        localStringBuilder = new StringBuilder();
        g.aAf();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R4_QQ,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R4_QQ") + ",2");
      }
      else if (this.sceneType == 3)
      {
        localStringBuilder = new StringBuilder();
        g.aAf();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_email,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128715);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bnm();
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
    this.kqA.postDelayed(new Runnable()
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
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
    if (paramq.getType() == 126)
    {
      g.azz().b(126, this);
      if (this.gtM != null)
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.kkY.eTd = this.kop;
        this.kkY.ejA = 6L;
        this.kkY.bfK();
        this.krK = null;
        str2 = bpU();
        str1 = ((v)paramq).bfx();
        i = ((v)paramq).bfy();
        str3 = ((v)paramq).bfz();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = XmlParser.parseXml(str3, "wording", null);
        if (localMap == null) {
          break label1724;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!Util.isNullOrNil((String)localObject3)) {
          break label568;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1724;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!Util.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (Util.isNullOrNil((String)localObject3)) {
          break label1721;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      Log.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.es(true);
      if (this.kpI)
      {
        localObject3 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar";
        str3 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar.hd";
        com.tencent.mm.vfs.s.nx((String)localObject3, str3);
        com.tencent.mm.vfs.s.deleteFile((String)localObject3);
        BitmapUtil.createThumbNail(str3, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3, true);
        new n(this, com.tencent.mm.loader.j.b.aKR() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128674);
            RegSetInfoUI.b(RegSetInfoUI.this, ((v)paramq).bfv());
            bf.iDu.aO("login_user_name", str2);
            com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bwV("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128674);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.koM);
                ((Intent)localObject1).putExtra("alert_message", this.koN);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            g.aAf();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128674);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128675);
            RegSetInfoUI.b(RegSetInfoUI.this, ((v)paramq).bfv());
            bf.iDu.aO("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bwV("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128675);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.koM);
                ((Intent)localObject1).putExtra("alert_message", this.koN);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            g.aAf();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128675);
          }
        });
      }
      for (;;)
      {
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.kdp == null)
          {
            this.kdp = SecurityImage.a.a(getContext(), 0, ((v)paramq).bfm(), ((v)paramq).bfl(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128677);
                paramAnonymousDialogInterface = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                Object localObject = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                if ((localObject == null) || (((String)localObject).length() <= 0))
                {
                  com.tencent.mm.ui.base.h.n(RegSetInfoUI.this, 2131767019, 2131764412);
                  AppMethodBeat.o(128677);
                  return;
                }
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                g.azz().a(126, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new v("", RegSetInfoUI.y(RegSetInfoUI.this), (String)localObject, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, ((v)paramq).bfl(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode(), RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                paramAnonymousDialogInterface.PB(RegSetInfoUI.E(RegSetInfoUI.this));
                paramAnonymousDialogInterface.PC(RegSetInfoUI.F(RegSetInfoUI.this));
                paramAnonymousDialogInterface.tL(RegSetInfoUI.G(RegSetInfoUI.this));
                g.azz().a(paramAnonymousDialogInterface, 0);
                localObject = RegSetInfoUI.this;
                RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(2131755998);
                RegSetInfoUI.a((RegSetInfoUI)localObject, com.tencent.mm.ui.base.h.a(localRegSetInfoUI, RegSetInfoUI.this.getString(2131764451), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128676);
                    g.azz().a(paramAnonymousDialogInterface);
                    g.azz().b(126, RegSetInfoUI.this);
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
              public final void bnH()
              {
                AppMethodBeat.i(128680);
                RegSetInfoUI.this.hideVKB();
                Object localObject = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                String str = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                g.azz().a(126, RegSetInfoUI.this);
                localObject = new v("", RegSetInfoUI.y(RegSetInfoUI.this), str, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject, ((v)paramq).bfl(), "", RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                ((v)localObject).PB(RegSetInfoUI.E(RegSetInfoUI.this));
                ((v)localObject).PC(RegSetInfoUI.F(RegSetInfoUI.this));
                ((v)localObject).tL(RegSetInfoUI.G(RegSetInfoUI.this));
                g.azz().a((com.tencent.mm.ak.q)localObject, 0);
                AppMethodBeat.o(128680);
              }
            });
            AppMethodBeat.o(128713);
            return;
            label568:
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
            this.gwF = ((v)paramq).bfv();
            bf.iDu.aO("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bwV("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.gwF);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
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
            localObject1 = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            g.aAf();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_900_phone") + ",4");
            finish();
            continue;
          }
          this.kdp.b(0, ((v)paramq).bfm(), ((v)paramq).bfl(), "");
          AppMethodBeat.o(128713);
          return;
        }
      }
      localObject1 = com.tencent.mm.h.a.Dk(paramString);
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
      if (paramq.getType() == 429)
      {
        g.azz().b(429, this);
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        this.krF.setVisibility(8);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.krK = null;
          paramInt1 = ((u.b)((ag)paramq).iMO.getRespObj()).keV.MbM;
          Log.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
          {
            paramq = ((u.b)((ag)paramq).iMO.getRespObj()).keV.oTA;
            paramString = com.tencent.mm.h.a.Dk(paramString);
            if (paramString != null) {
              this.kry.setText(paramString.desc);
            }
            this.krD.clear();
            if ((paramq != null) && (paramq.size() > 0))
            {
              if (paramq.size() > 3) {}
              for (paramInt1 = 3;; paramInt1 = paramq.size())
              {
                paramString = new String[paramInt1];
                paramInt2 = 0;
                while (paramInt2 < paramInt1)
                {
                  paramString[paramInt2] = ((dqi)paramq.get(paramInt2)).MTo;
                  this.krD.add(paramString[paramInt2]);
                  paramInt2 += 1;
                }
              }
              if (this.krO)
              {
                if (this.krM != null)
                {
                  this.krM.dismiss();
                  this.krM = null;
                }
                this.krM = q.a(this, this.krN, paramString, new AdapterView.OnItemClickListener()
                {
                  public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(128687);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymousAdapterView);
                    localb.bm(paramAnonymousView);
                    localb.pH(paramAnonymousInt);
                    localb.zo(paramAnonymousLong);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$25", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
                    RegSetInfoUI.r(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(2131764470));
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
          if (Util.isNullOrNil(this.krr.getText().toString().trim()))
          {
            q(false, false);
            AppMethodBeat.o(128713);
            return;
          }
          q(true, false);
          this.kry.setText(getString(2131764470));
          if (this.krM != null)
          {
            this.krM.dismiss();
            this.krM = null;
          }
          this.krr.postDelayed(new Runnable()
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
          if (this.kdp == null)
          {
            this.kdp = SecurityImage.a.a(getContext(), 0, ((ag)paramq).bfm(), ((ag)paramq).bfl(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128683);
                paramAnonymousDialogInterface = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                Object localObject1 = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.length() <= 0))
                {
                  com.tencent.mm.ui.base.h.n(RegSetInfoUI.this, 2131767019, 2131764412);
                  AppMethodBeat.o(128683);
                  return;
                }
                RegSetInfoUI.this.hideVKB();
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject2 = RegSetInfoUI.f(RegSetInfoUI.this);
                g.azz().a(429, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new ag((String)localObject2, RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, (String)localObject1, ((ag)paramq).bfl(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode());
                g.azz().a(paramAnonymousDialogInterface, 0);
                localObject1 = RegSetInfoUI.this;
                localObject2 = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(2131755998);
                RegSetInfoUI.a((RegSetInfoUI)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, RegSetInfoUI.this.getString(2131764451), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128682);
                    g.azz().a(paramAnonymousDialogInterface);
                    g.azz().b(429, RegSetInfoUI.this);
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
              public final void bnH()
              {
                AppMethodBeat.i(128685);
                RegSetInfoUI.this.hideVKB();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject = RegSetInfoUI.f(RegSetInfoUI.this);
                g.azz().a(429, RegSetInfoUI.this);
                localObject = new ag((String)localObject, RegSetInfoUI.g(RegSetInfoUI.this), i, "", "", ((ag)paramq).bfl(), "");
                g.azz().a((com.tencent.mm.ak.q)localObject, 0);
                AppMethodBeat.o(128685);
              }
            });
            AppMethodBeat.o(128713);
            return;
          }
          this.kdp.b(0, ((ag)paramq).bfm(), ((ag)paramq).bfl(), "");
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
        this.krK = getString(2131760825, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, this.krK, 0).show();
        AppMethodBeat.o(128713);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(2131760872, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128713);
      return;
      label1721:
      continue;
      label1724:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI
 * JD-Core Version:    0.7.0.1
 */