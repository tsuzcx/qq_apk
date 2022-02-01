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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements f
{
  private String ePF;
  private String ePG;
  private ProgressDialog hNi;
  private boolean iZg = false;
  private String iZh;
  private boolean iZi = false;
  private boolean iZj = false;
  private boolean iZk = false;
  private Bundle iZl;
  private boolean iZm = false;
  private boolean iZn = false;
  private TextView iZo;
  private TextView iZp;
  private View iZq;
  private MMSwitchBtn iZr;
  private TextView iZs;
  private TextView iZt;
  private TextView iZu;
  private String iZv;
  private String iZw;
  private String iZx;
  private String iZy;
  private String name;
  private int status;
  
  private void Jm(String paramString)
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
    this.iZo.setText((CharSequence)localObject);
    AppMethodBeat.o(109837);
  }
  
  private void Zd()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109833);
    this.iZh = ((String)g.ajC().ajl().get(286721, null));
    if (!bt.isNullOrNil(this.iZh))
    {
      bool1 = true;
      this.iZg = bool1;
      this.name = ((String)g.ajC().ajl().get(286722, null));
      this.status = u.aAq();
      if ((this.status & 0x400000) == 0) {
        break label97;
      }
    }
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.iZi = bool1;
      AppMethodBeat.o(109833);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(109839);
    this.iZu.setVisibility(8);
    if (paramBoolean1)
    {
      this.iZp.setVisibility(8);
      this.iZo.setVisibility(0);
      Jm(paramString);
      this.iZq.setVisibility(0);
      this.iZs.setVisibility(8);
      if (paramBoolean2) {
        this.iZt.setVisibility(0);
      }
      this.iZr.setCheck(paramBoolean3);
      this.iZr.setSwitchListener(new MMSwitchBtn.a()
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
    this.iZo.setVisibility(8);
    this.iZo.setText(getString(2131757702));
    this.iZp.setVisibility(0);
    this.iZq.setVisibility(8);
    this.iZs.setVisibility(0);
    this.iZt.setVisibility(8);
    AppMethodBeat.o(109839);
  }
  
  private void d(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(109838);
    this.iZo.setVisibility(0);
    Jm(paramString);
    this.iZq.setVisibility(0);
    this.iZt.setVisibility(8);
    if (paramBoolean1)
    {
      this.iZp.setVisibility(8);
      this.iZs.setVisibility(8);
      this.iZu.setVisibility(8);
      this.iZr.setCheck(paramBoolean2);
      this.iZr.setSwitchListener(new MMSwitchBtn.a()
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
    this.iZp.setVisibility(0);
    this.iZs.setVisibility(0);
    this.iZu.setVisibility(0);
    this.iZr.setCheck(paramBoolean2);
    this.iZr.setSwitchListener(new MMSwitchBtn.a()
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
  
  private void fn(boolean paramBoolean)
  {
    AppMethodBeat.i(109836);
    if (this.iZl == null)
    {
      ad.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      AppMethodBeat.o(109836);
      return;
    }
    if (this.iZr.KRP) {}
    for (int i = 1;; i = 2)
    {
      final com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.ePF, this.ePG, "", this.iZv, this.iZw, this.iZx, this.iZy);
      if (!paramBoolean) {
        this.hNi = h.b(this, getString(2131760709), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109826);
            g.aiU().a(locala);
            AppMethodBeat.o(109826);
          }
        });
      }
      g.aiU().a(locala, 0);
      AppMethodBeat.o(109836);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(109835);
    if (this.iZj)
    {
      if (this.iZn)
      {
        Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
        ((Intent)localObject).addFlags(603979776);
        ((Intent)localObject).putExtra("preferred_tab", 2);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
      g.ajC().ajl().set(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        aty localaty = new aty();
        localaty.GrZ = 33;
        localaty.xcI = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(23, localaty));
        com.tencent.mm.plugin.account.a.a.iRH.MR();
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
    if ((this.iZj) && (this.iZl == null))
    {
      ad.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      AppMethodBeat.o(109840);
      return;
    }
    if (this.iZk)
    {
      a(this.iZg, false, this.name, this.iZi);
      AppMethodBeat.o(109840);
      return;
    }
    if (this.iZj)
    {
      if ((this.iZg) && (this.iZh.equals(this.ePF))) {}
      for (;;)
      {
        d(bool, this.ePG, this.iZi);
        AppMethodBeat.o(109840);
        return;
        bool = false;
      }
    }
    a(this.iZg, true, this.name, this.iZi);
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
    if (bt.isNullOrNil(paramIntent))
    {
      ad.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
      AppMethodBeat.o(109842);
      return false;
    }
    int i = bt.aRe(paramIntent);
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
    g.ajC().ajl().set(286722, str2);
    g.ajC().ajl().set(286721, str1);
    g.ajC().ajl().set(286723, str3);
    if (!bt.isNullOrNil((String)localObject)) {
      if (bt.aRe((String)localObject) != 1) {
        break label315;
      }
    }
    label315:
    for (boolean bool = true;; bool = false)
    {
      o(bool, false);
      Zd();
      updateView();
      paramIntent = getString(2131757708);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      h.cl(this, paramIntent);
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
    if (this.iZj) {
      setMMTitle(2131757714);
    }
    for (;;)
    {
      this.iZo = ((TextView)findViewById(2131304619));
      this.iZp = ((TextView)findViewById(2131304620));
      this.iZq = findViewById(2131304788);
      this.iZr = ((MMSwitchBtn)findViewById(2131304787));
      this.iZs = ((TextView)findViewById(2131297231));
      this.iZt = ((TextView)findViewById(2131306181));
      this.iZu = ((TextView)findViewById(2131297689));
      this.iZo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109818);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          paramAnonymousView = (String)g.ajC().ajl().get(286723, null);
          if (!bt.isNullOrNil(paramAnonymousView))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("geta8key_username", u.aAm());
            d.b(BindLinkedInUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109818);
        }
      });
      this.iZs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109820);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      this.iZt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109823);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
                  g.aiU().a(paramAnonymous2DialogInterface);
                  AppMethodBeat.o(109821);
                }
              }));
              g.aiU().a(paramAnonymous2DialogInterface, 0);
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
      this.iZu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109824);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      if (this.iZk) {
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
    g.aiU().a(549, this);
    g.aiU().a(550, this);
    this.iZl = getIntent().getBundleExtra("qrcode_bundle");
    if (this.iZl != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.iZj = bool;
      if (this.iZl != null)
      {
        this.ePF = this.iZl.getString("i");
        this.ePG = this.iZl.getString("n");
        this.iZv = this.iZl.getString("t");
        this.iZw = this.iZl.getString("o");
        this.iZx = this.iZl.getString("s");
        this.iZy = this.iZl.getString("r");
        if ((this.ePF == null) || (this.ePG == null) || (this.iZv == null) || (this.iZx == null) || (this.iZy == null)) {
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
      this.iZk = getIntent().getBooleanExtra("oversea_entry", false);
      Zd();
      if (this.iZj) {
        this.iZi = true;
      }
      initView();
      if ((this.iZl != null) && (this.iZg) && (this.iZh.equals(this.ePF)))
      {
        this.iZm = true;
        fn(true);
      }
      AppMethodBeat.o(109829);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109830);
    g.aiU().b(550, this);
    g.aiU().b(549, this);
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
    if (this.hNi != null)
    {
      this.hNi.dismiss();
      this.hNi = null;
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
      this.iZn = true;
      if (!this.iZm) {
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
      h.cl(this, paramString);
      Zd();
      this.iZi = this.iZr.KRP;
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