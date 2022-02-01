package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String eyh;
  private String eyi;
  private ProgressDialog huQ;
  private boolean iFX = false;
  private String iFY;
  private boolean iFZ = false;
  private boolean iGa = false;
  private boolean iGb = false;
  private Bundle iGc;
  private boolean iGd = false;
  private boolean iGe = false;
  private TextView iGf;
  private TextView iGg;
  private View iGh;
  private MMSwitchBtn iGi;
  private TextView iGj;
  private TextView iGk;
  private TextView iGl;
  private String iGm;
  private String iGn;
  private String iGo;
  private String iGp;
  private String name;
  private int status;
  
  private void FX(String paramString)
  {
    AppMethodBeat.i(109837);
    int i = getString(2131757701).indexOf("%s");
    Object localObject = getString(2131757701, new Object[] { paramString });
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    ((Spannable)localObject).setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView) {}
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        AppMethodBeat.i(109827);
        paramAnonymousTextPaint.setColor(BindLinkedInUI.this.getResources().getColor(2131100547));
        paramAnonymousTextPaint.setUnderlineText(false);
        AppMethodBeat.o(109827);
      }
    }, i, paramString.length() + i, 33);
    this.iGf.setText((CharSequence)localObject);
    AppMethodBeat.o(109837);
  }
  
  private void WJ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109833);
    this.iFY = ((String)com.tencent.mm.kernel.g.agR().agA().get(286721, null));
    if (!bs.isNullOrNil(this.iFY))
    {
      bool1 = true;
      this.iFX = bool1;
      this.name = ((String)com.tencent.mm.kernel.g.agR().agA().get(286722, null));
      this.status = u.axA();
      if ((this.status & 0x400000) == 0) {
        break label97;
      }
    }
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.iFZ = bool1;
      AppMethodBeat.o(109833);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(109839);
    this.iGl.setVisibility(8);
    if (paramBoolean1)
    {
      this.iGg.setVisibility(8);
      this.iGf.setVisibility(0);
      FX(paramString);
      this.iGh.setVisibility(0);
      this.iGj.setVisibility(8);
      if (paramBoolean2) {
        this.iGk.setVisibility(0);
      }
      this.iGi.setCheck(paramBoolean3);
      this.iGi.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(109817);
          BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, true);
          AppMethodBeat.o(109817);
        }
      });
      AppMethodBeat.o(109839);
      return;
    }
    this.iGf.setVisibility(8);
    this.iGf.setText(getString(2131757702));
    this.iGg.setVisibility(0);
    this.iGh.setVisibility(8);
    this.iGj.setVisibility(0);
    this.iGk.setVisibility(8);
    AppMethodBeat.o(109839);
  }
  
  private void cL()
  {
    boolean bool = true;
    AppMethodBeat.i(109840);
    if ((this.iGa) && (this.iGc == null))
    {
      ac.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      AppMethodBeat.o(109840);
      return;
    }
    if (this.iGb)
    {
      a(this.iFX, false, this.name, this.iFZ);
      AppMethodBeat.o(109840);
      return;
    }
    if (this.iGa)
    {
      if ((this.iFX) && (this.iFY.equals(this.eyh))) {}
      for (;;)
      {
        d(bool, this.eyi, this.iFZ);
        AppMethodBeat.o(109840);
        return;
        bool = false;
      }
    }
    a(this.iFX, true, this.name, this.iFZ);
    AppMethodBeat.o(109840);
  }
  
  private void d(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(109838);
    this.iGf.setVisibility(0);
    FX(paramString);
    this.iGh.setVisibility(0);
    this.iGk.setVisibility(8);
    if (paramBoolean1)
    {
      this.iGg.setVisibility(8);
      this.iGj.setVisibility(8);
      this.iGl.setVisibility(8);
      this.iGi.setCheck(paramBoolean2);
      this.iGi.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(109828);
          BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, true);
          AppMethodBeat.o(109828);
        }
      });
      AppMethodBeat.o(109838);
      return;
    }
    this.iGg.setVisibility(0);
    this.iGj.setVisibility(0);
    this.iGl.setVisibility(0);
    this.iGi.setCheck(paramBoolean2);
    this.iGi.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109816);
        BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, false);
        AppMethodBeat.o(109816);
      }
    });
    AppMethodBeat.o(109838);
  }
  
  private void fj(boolean paramBoolean)
  {
    AppMethodBeat.i(109836);
    if (this.iGc == null)
    {
      ac.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      AppMethodBeat.o(109836);
      return;
    }
    if (this.iGi.JaE) {}
    for (int i = 1;; i = 2)
    {
      final com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.eyh, this.eyi, "", this.iGm, this.iGn, this.iGo, this.iGp);
      if (!paramBoolean) {
        this.huQ = h.b(this, getString(2131760709), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109826);
            com.tencent.mm.kernel.g.agi().a(locala);
            AppMethodBeat.o(109826);
          }
        });
      }
      com.tencent.mm.kernel.g.agi().a(locala, 0);
      AppMethodBeat.o(109836);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(109835);
    if (this.iGa)
    {
      if (this.iGe)
      {
        Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
        ((Intent)localObject).addFlags(603979776);
        ((Intent)localObject).putExtra("preferred_tab", 2);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109835);
        return;
      }
      setResult(-1);
      finish();
      AppMethodBeat.o(109835);
      return;
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(109835);
  }
  
  private void o(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109841);
    if (paramBoolean1)
    {
      this.status |= 0x400000;
      if (!paramBoolean1) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.kernel.g.agR().agA().set(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        aqc localaqc = new aqc();
        localaqc.EIY = 33;
        localaqc.vVH = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(23, localaqc));
        com.tencent.mm.plugin.account.a.a.iyy.Lj();
      }
      AppMethodBeat.o(109841);
      return;
      this.status &= 0xFFBFFFFF;
      break;
    }
  }
  
  private boolean x(Intent paramIntent)
  {
    AppMethodBeat.i(109842);
    Object localObject = paramIntent.getBundleExtra("result_data");
    paramIntent = ((Bundle)localObject).getString("ret");
    String str1 = ((Bundle)localObject).getString("limid");
    String str2 = ((Bundle)localObject).getString("liname");
    String str3 = ((Bundle)localObject).getString("liurl");
    localObject = ((Bundle)localObject).getString("liswitch");
    if (bs.isNullOrNil(paramIntent))
    {
      ac.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
      AppMethodBeat.o(109842);
      return false;
    }
    int i = bs.aLy(paramIntent);
    if (i != 0)
    {
      ac.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[] { Integer.valueOf(i) });
      if (i == 1) {}
      for (i = 2131757712;; i = 2131757711)
      {
        h.c(this, getString(i), null, true);
        AppMethodBeat.o(109842);
        return false;
      }
    }
    if (bs.isNullOrNil(str1))
    {
      ac.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
      AppMethodBeat.o(109842);
      return false;
    }
    ac.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[] { str1, str2, str3, localObject });
    com.tencent.mm.kernel.g.agR().agA().set(286722, str2);
    com.tencent.mm.kernel.g.agR().agA().set(286721, str1);
    com.tencent.mm.kernel.g.agR().agA().set(286723, str3);
    if (!bs.isNullOrNil((String)localObject)) {
      if (bs.aLy((String)localObject) != 1) {
        break label315;
      }
    }
    label315:
    for (boolean bool = true;; bool = false)
    {
      o(bool, false);
      WJ();
      cL();
      paramIntent = getString(2131757708);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      h.cg(this, paramIntent);
      AppMethodBeat.o(109842);
      return true;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493178;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109834);
    if (this.iGa) {
      setMMTitle(2131757714);
    }
    for (;;)
    {
      this.iGf = ((TextView)findViewById(2131304619));
      this.iGg = ((TextView)findViewById(2131304620));
      this.iGh = findViewById(2131304788);
      this.iGi = ((MMSwitchBtn)findViewById(2131304787));
      this.iGj = ((TextView)findViewById(2131297231));
      this.iGk = ((TextView)findViewById(2131306181));
      this.iGl = ((TextView)findViewById(2131297689));
      this.iGf.setOnClickListener(new BindLinkedInUI.6(this));
      this.iGj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109820);
          if (!BindLinkedInUI.b(BindLinkedInUI.this))
          {
            BindLinkedInUI.c(BindLinkedInUI.this);
            AppMethodBeat.o(109820);
            return;
          }
          if (!BindLinkedInUI.d(BindLinkedInUI.this))
          {
            BindLinkedInUI.e(BindLinkedInUI.this);
            AppMethodBeat.o(109820);
            return;
          }
          h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(2131757703), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(109819);
              BindLinkedInUI.e(BindLinkedInUI.this);
              AppMethodBeat.o(109819);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(109820);
        }
      });
      this.iGk.setOnClickListener(new BindLinkedInUI.8(this));
      this.iGl.setOnClickListener(new BindLinkedInUI.9(this));
      setBackBtn(new BindLinkedInUI.10(this));
      cL();
      AppMethodBeat.o(109834);
      return;
      if (this.iGb) {
        setMMTitle(2131757717);
      } else {
        setMMTitle(2131757707);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109843);
    ac.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if (paramIntent == null)
    {
      AppMethodBeat.o(109843);
      return;
    }
    switch (paramInt1)
    {
    default: 
      ac.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
      AppMethodBeat.o(109843);
      return;
    }
    x(paramIntent);
    AppMethodBeat.o(109843);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109829);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(549, this);
    com.tencent.mm.kernel.g.agi().a(550, this);
    this.iGc = getIntent().getBundleExtra("qrcode_bundle");
    if (this.iGc != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.iGa = bool;
      if (this.iGc != null)
      {
        this.eyh = this.iGc.getString("i");
        this.eyi = this.iGc.getString("n");
        this.iGm = this.iGc.getString("t");
        this.iGn = this.iGc.getString("o");
        this.iGo = this.iGc.getString("s");
        this.iGp = this.iGc.getString("r");
        if ((this.eyh == null) || (this.eyi == null) || (this.iGm == null) || (this.iGo == null) || (this.iGp == null)) {
          h.a(this, getString(2131757704), null, false, new BindLinkedInUI.1(this));
        }
      }
      this.iGb = getIntent().getBooleanExtra("oversea_entry", false);
      WJ();
      if (this.iGa) {
        this.iFZ = true;
      }
      initView();
      if ((this.iGc != null) && (this.iFX) && (this.iFY.equals(this.eyh)))
      {
        this.iGd = true;
        fj(true);
      }
      AppMethodBeat.o(109829);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109830);
    com.tencent.mm.kernel.g.agi().b(550, this);
    com.tencent.mm.kernel.g.agi().b(549, this);
    super.onDestroy();
    AppMethodBeat.o(109830);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109845);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(109845);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109845);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109832);
    super.onPause();
    AppMethodBeat.o(109832);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109831);
    super.onResume();
    AppMethodBeat.o(109831);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109844);
    if (this.huQ != null)
    {
      this.huQ.dismiss();
      this.huQ = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramn.getType() == 549) {
        if (paramInt2 == 1) {
          paramInt1 = 2131757712;
        }
      }
      for (;;)
      {
        h.c(this, getString(paramInt1), null, true);
        AppMethodBeat.o(109844);
        return;
        paramInt1 = 2131757711;
        continue;
        if (paramn.getType() != 550) {
          break;
        }
        paramInt1 = 2131757713;
      }
      AppMethodBeat.o(109844);
      return;
    }
    if (paramn.getType() == 549)
    {
      this.iGe = true;
      if (!this.iGd) {
        paramInt1 = 2131757708;
      }
    }
    for (;;)
    {
      paramString = getString(paramInt1);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      h.cg(this, paramString);
      WJ();
      this.iFZ = this.iGi.JaE;
      cL();
      AppMethodBeat.o(109844);
      return;
      paramInt1 = 2131757709;
      continue;
      if (paramn.getType() != 550) {
        break;
      }
      paramInt1 = 2131757719;
    }
    AppMethodBeat.o(109844);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI
 * JD-Core Version:    0.7.0.1
 */