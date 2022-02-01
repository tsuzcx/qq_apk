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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements f
{
  private String eRq;
  private String eRr;
  private ProgressDialog hQb;
  private boolean jbZ = false;
  private String jca;
  private boolean jcb = false;
  private boolean jcc = false;
  private boolean jcd = false;
  private Bundle jce;
  private boolean jcf = false;
  private boolean jcg = false;
  private TextView jch;
  private TextView jci;
  private View jcj;
  private MMSwitchBtn jck;
  private TextView jcl;
  private TextView jcm;
  private TextView jcn;
  private String jco;
  private String jcp;
  private String jcq;
  private String jcr;
  private String name;
  private int status;
  
  private void JL(String paramString)
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
    this.jch.setText((CharSequence)localObject);
    AppMethodBeat.o(109837);
  }
  
  private void Zm()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109833);
    this.jca = ((String)g.ajR().ajA().get(286721, null));
    if (!bu.isNullOrNil(this.jca))
    {
      bool1 = true;
      this.jbZ = bool1;
      this.name = ((String)g.ajR().ajA().get(286722, null));
      this.status = v.aAG();
      if ((this.status & 0x400000) == 0) {
        break label97;
      }
    }
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jcb = bool1;
      AppMethodBeat.o(109833);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(109839);
    this.jcn.setVisibility(8);
    if (paramBoolean1)
    {
      this.jci.setVisibility(8);
      this.jch.setVisibility(0);
      JL(paramString);
      this.jcj.setVisibility(0);
      this.jcl.setVisibility(8);
      if (paramBoolean2) {
        this.jcm.setVisibility(0);
      }
      this.jck.setCheck(paramBoolean3);
      this.jck.setSwitchListener(new MMSwitchBtn.a()
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
    this.jch.setVisibility(8);
    this.jch.setText(getString(2131757702));
    this.jci.setVisibility(0);
    this.jcj.setVisibility(8);
    this.jcl.setVisibility(0);
    this.jcm.setVisibility(8);
    AppMethodBeat.o(109839);
  }
  
  private void d(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(109838);
    this.jch.setVisibility(0);
    JL(paramString);
    this.jcj.setVisibility(0);
    this.jcm.setVisibility(8);
    if (paramBoolean1)
    {
      this.jci.setVisibility(8);
      this.jcl.setVisibility(8);
      this.jcn.setVisibility(8);
      this.jck.setCheck(paramBoolean2);
      this.jck.setSwitchListener(new MMSwitchBtn.a()
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
    this.jci.setVisibility(0);
    this.jcl.setVisibility(0);
    this.jcn.setVisibility(0);
    this.jck.setCheck(paramBoolean2);
    this.jck.setSwitchListener(new MMSwitchBtn.a()
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
  
  private void fo(boolean paramBoolean)
  {
    AppMethodBeat.i(109836);
    if (this.jce == null)
    {
      ae.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      AppMethodBeat.o(109836);
      return;
    }
    if (this.jck.Lon) {}
    for (int i = 1;; i = 2)
    {
      final com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.eRq, this.eRr, "", this.jco, this.jcp, this.jcq, this.jcr);
      if (!paramBoolean) {
        this.hQb = h.b(this, getString(2131760709), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109826);
            g.ajj().a(locala);
            AppMethodBeat.o(109826);
          }
        });
      }
      g.ajj().a(locala, 0);
      AppMethodBeat.o(109836);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(109835);
    if (this.jcc)
    {
      if (this.jcg)
      {
        Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
        ((Intent)localObject).addFlags(603979776);
        ((Intent)localObject).putExtra("preferred_tab", 2);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
      g.ajR().ajA().set(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        auo localauo = new auo();
        localauo.GLx = 33;
        localauo.xsz = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(23, localauo));
        com.tencent.mm.plugin.account.a.a.iUA.MM();
      }
      AppMethodBeat.o(109841);
      return;
      this.status &= 0xFFBFFFFF;
      break;
    }
  }
  
  private void updateView()
  {
    boolean bool = true;
    AppMethodBeat.i(109840);
    if ((this.jcc) && (this.jce == null))
    {
      ae.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      AppMethodBeat.o(109840);
      return;
    }
    if (this.jcd)
    {
      a(this.jbZ, false, this.name, this.jcb);
      AppMethodBeat.o(109840);
      return;
    }
    if (this.jcc)
    {
      if ((this.jbZ) && (this.jca.equals(this.eRq))) {}
      for (;;)
      {
        d(bool, this.eRr, this.jcb);
        AppMethodBeat.o(109840);
        return;
        bool = false;
      }
    }
    a(this.jbZ, true, this.name, this.jcb);
    AppMethodBeat.o(109840);
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
    if (bu.isNullOrNil(paramIntent))
    {
      ae.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
      AppMethodBeat.o(109842);
      return false;
    }
    int i = bu.aSB(paramIntent);
    if (i != 0)
    {
      ae.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[] { Integer.valueOf(i) });
      if (i == 1) {}
      for (i = 2131757712;; i = 2131757711)
      {
        h.c(this, getString(i), null, true);
        AppMethodBeat.o(109842);
        return false;
      }
    }
    if (bu.isNullOrNil(str1))
    {
      ae.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
      AppMethodBeat.o(109842);
      return false;
    }
    ae.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[] { str1, str2, str3, localObject });
    g.ajR().ajA().set(286722, str2);
    g.ajR().ajA().set(286721, str1);
    g.ajR().ajA().set(286723, str3);
    if (!bu.isNullOrNil((String)localObject)) {
      if (bu.aSB((String)localObject) != 1) {
        break label315;
      }
    }
    label315:
    for (boolean bool = true;; bool = false)
    {
      o(bool, false);
      Zm();
      updateView();
      paramIntent = getString(2131757708);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      h.cm(this, paramIntent);
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
    if (this.jcc) {
      setMMTitle(2131757714);
    }
    for (;;)
    {
      this.jch = ((TextView)findViewById(2131304619));
      this.jci = ((TextView)findViewById(2131304620));
      this.jcj = findViewById(2131304788);
      this.jck = ((MMSwitchBtn)findViewById(2131304787));
      this.jcl = ((TextView)findViewById(2131297231));
      this.jcm = ((TextView)findViewById(2131306181));
      this.jcn = ((TextView)findViewById(2131297689));
      this.jch.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109818);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = (String)g.ajR().ajA().get(286723, null);
          if (!bu.isNullOrNil(paramAnonymousView))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("geta8key_username", v.aAC());
            d.b(BindLinkedInUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109818);
        }
      });
      this.jcl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109820);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!BindLinkedInUI.b(BindLinkedInUI.this)) {
            BindLinkedInUI.c(BindLinkedInUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109820);
            return;
            if (!BindLinkedInUI.d(BindLinkedInUI.this)) {
              BindLinkedInUI.e(BindLinkedInUI.this);
            } else {
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
            }
          }
        }
      });
      this.jcm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109823);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(2131757705), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(109822);
              paramAnonymous2DialogInterface = new c();
              BindLinkedInUI.a(BindLinkedInUI.this, h.b(BindLinkedInUI.this, BindLinkedInUI.this.getString(2131760709), false, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(109821);
                  g.ajj().a(paramAnonymous2DialogInterface);
                  AppMethodBeat.o(109821);
                }
              }));
              g.ajj().a(paramAnonymous2DialogInterface, 0);
              AppMethodBeat.o(109822);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109823);
        }
      });
      this.jcn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109824);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          BindLinkedInUI.a(BindLinkedInUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109824);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109825);
          BindLinkedInUI.a(BindLinkedInUI.this);
          AppMethodBeat.o(109825);
          return true;
        }
      });
      updateView();
      AppMethodBeat.o(109834);
      return;
      if (this.jcd) {
        setMMTitle(2131757717);
      } else {
        setMMTitle(2131757707);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109843);
    ae.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if (paramIntent == null)
    {
      AppMethodBeat.o(109843);
      return;
    }
    switch (paramInt1)
    {
    default: 
      ae.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
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
    g.ajj().a(549, this);
    g.ajj().a(550, this);
    this.jce = getIntent().getBundleExtra("qrcode_bundle");
    if (this.jce != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.jcc = bool;
      if (this.jce != null)
      {
        this.eRq = this.jce.getString("i");
        this.eRr = this.jce.getString("n");
        this.jco = this.jce.getString("t");
        this.jcp = this.jce.getString("o");
        this.jcq = this.jce.getString("s");
        this.jcr = this.jce.getString("r");
        if ((this.eRq == null) || (this.eRr == null) || (this.jco == null) || (this.jcq == null) || (this.jcr == null)) {
          h.a(this, getString(2131757704), null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(109815);
              BindLinkedInUI.a(BindLinkedInUI.this);
              AppMethodBeat.o(109815);
            }
          });
        }
      }
      this.jcd = getIntent().getBooleanExtra("oversea_entry", false);
      Zm();
      if (this.jcc) {
        this.jcb = true;
      }
      initView();
      if ((this.jce != null) && (this.jbZ) && (this.jca.equals(this.eRq)))
      {
        this.jcf = true;
        fo(true);
      }
      AppMethodBeat.o(109829);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109830);
    g.ajj().b(550, this);
    g.ajj().b(549, this);
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
    if (this.hQb != null)
    {
      this.hQb.dismiss();
      this.hQb = null;
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
      this.jcg = true;
      if (!this.jcf) {
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
      h.cm(this, paramString);
      Zm();
      this.jcb = this.jck.Lon;
      updateView();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI
 * JD-Core Version:    0.7.0.1
 */