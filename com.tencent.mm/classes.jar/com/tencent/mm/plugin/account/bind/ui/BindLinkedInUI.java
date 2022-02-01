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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String evK;
  private String evL;
  private ProgressDialog gUr;
  private boolean ifO = false;
  private String ifP;
  private boolean ifQ = false;
  private boolean ifR = false;
  private boolean ifS = false;
  private Bundle ifT;
  private boolean ifU = false;
  private boolean ifV = false;
  private TextView ifW;
  private TextView ifX;
  private View ifY;
  private MMSwitchBtn ifZ;
  private TextView iga;
  private TextView igb;
  private TextView igc;
  private String igd;
  private String ige;
  private String igf;
  private String igg;
  private String name;
  private int status;
  
  private void BU(String paramString)
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
    this.ifW.setText((CharSequence)localObject);
    AppMethodBeat.o(109837);
  }
  
  private void VL()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109833);
    this.ifP = ((String)com.tencent.mm.kernel.g.afB().afk().get(286721, null));
    if (!bt.isNullOrNil(this.ifP))
    {
      bool1 = true;
      this.ifO = bool1;
      this.name = ((String)com.tencent.mm.kernel.g.afB().afk().get(286722, null));
      this.status = u.aqK();
      if ((this.status & 0x400000) == 0) {
        break label97;
      }
    }
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ifQ = bool1;
      AppMethodBeat.o(109833);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(109839);
    this.igc.setVisibility(8);
    if (paramBoolean1)
    {
      this.ifX.setVisibility(8);
      this.ifW.setVisibility(0);
      BU(paramString);
      this.ifY.setVisibility(0);
      this.iga.setVisibility(8);
      if (paramBoolean2) {
        this.igb.setVisibility(0);
      }
      this.ifZ.setCheck(paramBoolean3);
      this.ifZ.setSwitchListener(new MMSwitchBtn.a()
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
    this.ifW.setVisibility(8);
    this.ifW.setText(getString(2131757702));
    this.ifX.setVisibility(0);
    this.ifY.setVisibility(8);
    this.iga.setVisibility(0);
    this.igb.setVisibility(8);
    AppMethodBeat.o(109839);
  }
  
  private void cE()
  {
    boolean bool = true;
    AppMethodBeat.i(109840);
    if ((this.ifR) && (this.ifT == null))
    {
      ad.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      AppMethodBeat.o(109840);
      return;
    }
    if (this.ifS)
    {
      a(this.ifO, false, this.name, this.ifQ);
      AppMethodBeat.o(109840);
      return;
    }
    if (this.ifR)
    {
      if ((this.ifO) && (this.ifP.equals(this.evK))) {}
      for (;;)
      {
        d(bool, this.evL, this.ifQ);
        AppMethodBeat.o(109840);
        return;
        bool = false;
      }
    }
    a(this.ifO, true, this.name, this.ifQ);
    AppMethodBeat.o(109840);
  }
  
  private void d(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(109838);
    this.ifW.setVisibility(0);
    BU(paramString);
    this.ifY.setVisibility(0);
    this.igb.setVisibility(8);
    if (paramBoolean1)
    {
      this.ifX.setVisibility(8);
      this.iga.setVisibility(8);
      this.igc.setVisibility(8);
      this.ifZ.setCheck(paramBoolean2);
      this.ifZ.setSwitchListener(new MMSwitchBtn.a()
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
    this.ifX.setVisibility(0);
    this.iga.setVisibility(0);
    this.igc.setVisibility(0);
    this.ifZ.setCheck(paramBoolean2);
    this.ifZ.setSwitchListener(new MMSwitchBtn.a()
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
  
  private void eP(boolean paramBoolean)
  {
    AppMethodBeat.i(109836);
    if (this.ifT == null)
    {
      ad.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      AppMethodBeat.o(109836);
      return;
    }
    if (this.ifZ.HAh) {}
    for (int i = 1;; i = 2)
    {
      final com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.evK, this.evL, "", this.igd, this.ige, this.igf, this.igg);
      if (!paramBoolean) {
        this.gUr = h.b(this, getString(2131760709), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109826);
            com.tencent.mm.kernel.g.aeS().a(locala);
            AppMethodBeat.o(109826);
          }
        });
      }
      com.tencent.mm.kernel.g.aeS().a(locala, 0);
      AppMethodBeat.o(109836);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(109835);
    if (this.ifR)
    {
      if (this.ifV)
      {
        Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
        ((Intent)localObject).addFlags(603979776);
        ((Intent)localObject).putExtra("preferred_tab", 2);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
  
  private void n(boolean paramBoolean1, boolean paramBoolean2)
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
      com.tencent.mm.kernel.g.afB().afk().set(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        amy localamy = new amy();
        localamy.DnY = 33;
        localamy.uMR = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(23, localamy));
        com.tencent.mm.plugin.account.a.a.hYu.Ll();
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
    if (bt.isNullOrNil(paramIntent))
    {
      ad.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
      AppMethodBeat.o(109842);
      return false;
    }
    int i = bt.aGh(paramIntent);
    if (i != 0)
    {
      ad.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[] { Integer.valueOf(i) });
      if (i == 1) {}
      for (i = 2131757712;; i = 2131757711)
      {
        h.c(this, getString(i), null, true);
        AppMethodBeat.o(109842);
        return false;
      }
    }
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
      AppMethodBeat.o(109842);
      return false;
    }
    ad.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[] { str1, str2, str3, localObject });
    com.tencent.mm.kernel.g.afB().afk().set(286722, str2);
    com.tencent.mm.kernel.g.afB().afk().set(286721, str1);
    com.tencent.mm.kernel.g.afB().afk().set(286723, str3);
    if (!bt.isNullOrNil((String)localObject)) {
      if (bt.aGh((String)localObject) != 1) {
        break label315;
      }
    }
    label315:
    for (boolean bool = true;; bool = false)
    {
      n(bool, false);
      VL();
      cE();
      paramIntent = getString(2131757708);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      h.cf(this, paramIntent);
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
    if (this.ifR) {
      setMMTitle(2131757714);
    }
    for (;;)
    {
      this.ifW = ((TextView)findViewById(2131304619));
      this.ifX = ((TextView)findViewById(2131304620));
      this.ifY = findViewById(2131304788);
      this.ifZ = ((MMSwitchBtn)findViewById(2131304787));
      this.iga = ((TextView)findViewById(2131297231));
      this.igb = ((TextView)findViewById(2131306181));
      this.igc = ((TextView)findViewById(2131297689));
      this.ifW.setOnClickListener(new BindLinkedInUI.6(this));
      this.iga.setOnClickListener(new View.OnClickListener()
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
      this.igb.setOnClickListener(new BindLinkedInUI.8(this));
      this.igc.setOnClickListener(new BindLinkedInUI.9(this));
      setBackBtn(new BindLinkedInUI.10(this));
      cE();
      AppMethodBeat.o(109834);
      return;
      if (this.ifS) {
        setMMTitle(2131757717);
      } else {
        setMMTitle(2131757707);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109843);
    ad.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if (paramIntent == null)
    {
      AppMethodBeat.o(109843);
      return;
    }
    switch (paramInt1)
    {
    default: 
      ad.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
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
    com.tencent.mm.kernel.g.aeS().a(549, this);
    com.tencent.mm.kernel.g.aeS().a(550, this);
    this.ifT = getIntent().getBundleExtra("qrcode_bundle");
    if (this.ifT != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.ifR = bool;
      if (this.ifT != null)
      {
        this.evK = this.ifT.getString("i");
        this.evL = this.ifT.getString("n");
        this.igd = this.ifT.getString("t");
        this.ige = this.ifT.getString("o");
        this.igf = this.ifT.getString("s");
        this.igg = this.ifT.getString("r");
        if ((this.evK == null) || (this.evL == null) || (this.igd == null) || (this.igf == null) || (this.igg == null)) {
          h.a(this, getString(2131757704), null, false, new BindLinkedInUI.1(this));
        }
      }
      this.ifS = getIntent().getBooleanExtra("oversea_entry", false);
      VL();
      if (this.ifR) {
        this.ifQ = true;
      }
      initView();
      if ((this.ifT != null) && (this.ifO) && (this.ifP.equals(this.evK)))
      {
        this.ifU = true;
        eP(true);
      }
      AppMethodBeat.o(109829);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109830);
    com.tencent.mm.kernel.g.aeS().b(550, this);
    com.tencent.mm.kernel.g.aeS().b(549, this);
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
    if (this.gUr != null)
    {
      this.gUr.dismiss();
      this.gUr = null;
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
      this.ifV = true;
      if (!this.ifU) {
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
      h.cf(this, paramString);
      VL();
      this.ifQ = this.ifZ.HAh;
      cE();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI
 * JD-Core Version:    0.7.0.1
 */