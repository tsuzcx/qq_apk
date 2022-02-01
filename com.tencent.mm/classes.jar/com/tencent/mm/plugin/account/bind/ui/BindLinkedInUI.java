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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements i
{
  private String fuT;
  private String fuU;
  private ProgressDialog iLh;
  private boolean kac = false;
  private String kad;
  private boolean kae = false;
  private boolean kaf = false;
  private boolean kag = false;
  private Bundle kah;
  private boolean kai = false;
  private boolean kaj = false;
  private TextView kak;
  private TextView kal;
  private View kam;
  private MMSwitchBtn kan;
  private TextView kao;
  private TextView kap;
  private TextView kaq;
  private String kar;
  private String kas;
  private String kat;
  private String kau;
  private String name;
  private int status;
  
  private void SK(String paramString)
  {
    AppMethodBeat.i(109837);
    int i = getString(2131757932).indexOf("%s");
    Object localObject = getString(2131757932, new Object[] { paramString });
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    ((Spannable)localObject).setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView) {}
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        AppMethodBeat.i(109827);
        paramAnonymousTextPaint.setColor(BindLinkedInUI.this.getResources().getColor(2131100685));
        paramAnonymousTextPaint.setUnderlineText(false);
        AppMethodBeat.o(109827);
      }
    }, i, paramString.length() + i, 33);
    this.kak.setText((CharSequence)localObject);
    AppMethodBeat.o(109837);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(109839);
    this.kaq.setVisibility(8);
    if (paramBoolean1)
    {
      this.kal.setVisibility(8);
      this.kak.setVisibility(0);
      SK(paramString);
      this.kam.setVisibility(0);
      this.kao.setVisibility(8);
      if (paramBoolean2) {
        this.kap.setVisibility(0);
      }
      this.kan.setCheck(paramBoolean3);
      this.kan.setSwitchListener(new MMSwitchBtn.a()
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
    this.kak.setVisibility(8);
    this.kak.setText(getString(2131757933));
    this.kal.setVisibility(0);
    this.kam.setVisibility(8);
    this.kao.setVisibility(0);
    this.kap.setVisibility(8);
    AppMethodBeat.o(109839);
  }
  
  private void amZ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109833);
    this.kad = ((String)g.aAh().azQ().get(286721, null));
    if (!Util.isNullOrNil(this.kad))
    {
      bool1 = true;
      this.kac = bool1;
      this.name = ((String)g.aAh().azQ().get(286722, null));
      this.status = z.aUc();
      if ((this.status & 0x400000) == 0) {
        break label97;
      }
    }
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.kae = bool1;
      AppMethodBeat.o(109833);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void d(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(109838);
    this.kak.setVisibility(0);
    SK(paramString);
    this.kam.setVisibility(0);
    this.kap.setVisibility(8);
    if (paramBoolean1)
    {
      this.kal.setVisibility(8);
      this.kao.setVisibility(8);
      this.kaq.setVisibility(8);
      this.kan.setCheck(paramBoolean2);
      this.kan.setSwitchListener(new MMSwitchBtn.a()
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
    this.kal.setVisibility(0);
    this.kao.setVisibility(0);
    this.kaq.setVisibility(0);
    this.kan.setCheck(paramBoolean2);
    this.kan.setSwitchListener(new MMSwitchBtn.a()
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
  
  private void gh(boolean paramBoolean)
  {
    AppMethodBeat.i(109836);
    if (this.kah == null)
    {
      Log.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      AppMethodBeat.o(109836);
      return;
    }
    if (this.kan.QDw) {}
    for (int i = 1;; i = 2)
    {
      final com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.fuT, this.fuU, "", this.kar, this.kas, this.kat, this.kau);
      if (!paramBoolean) {
        this.iLh = h.a(this, getString(2131762446), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109826);
            g.azz().a(locala);
            AppMethodBeat.o(109826);
          }
        });
      }
      g.azz().a(locala, 0);
      AppMethodBeat.o(109836);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(109835);
    if (this.kaf)
    {
      if (this.kaj)
      {
        Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        ((Intent)localObject).addFlags(603979776);
        ((Intent)localObject).putExtra("preferred_tab", 2);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      g.aAh().azQ().set(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        bfx localbfx = new bfx();
        localbfx.LPB = 33;
        localbfx.BsD = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, localbfx));
        com.tencent.mm.plugin.account.a.a.jRu.WZ();
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
    if ((this.kaf) && (this.kah == null))
    {
      Log.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      AppMethodBeat.o(109840);
      return;
    }
    if (this.kag)
    {
      a(this.kac, false, this.name, this.kae);
      AppMethodBeat.o(109840);
      return;
    }
    if (this.kaf)
    {
      if ((this.kac) && (this.kad.equals(this.fuT))) {}
      for (;;)
      {
        d(bool, this.fuU, this.kae);
        AppMethodBeat.o(109840);
        return;
        bool = false;
      }
    }
    a(this.kac, true, this.name, this.kae);
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
    if (Util.isNullOrNil(paramIntent))
    {
      Log.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
      AppMethodBeat.o(109842);
      return false;
    }
    int i = Util.safeParseInt(paramIntent);
    if (i != 0)
    {
      Log.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[] { Integer.valueOf(i) });
      if (i == 1) {}
      for (i = 2131757943;; i = 2131757942)
      {
        h.c(this, getString(i), null, true);
        AppMethodBeat.o(109842);
        return false;
      }
    }
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
      AppMethodBeat.o(109842);
      return false;
    }
    Log.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[] { str1, str2, str3, localObject });
    g.aAh().azQ().set(286722, str2);
    g.aAh().azQ().set(286721, str1);
    g.aAh().azQ().set(286723, str3);
    if (!Util.isNullOrNil((String)localObject)) {
      if (Util.safeParseInt((String)localObject) != 1) {
        break label315;
      }
    }
    label315:
    for (boolean bool = true;; bool = false)
    {
      o(bool, false);
      amZ();
      updateView();
      paramIntent = getString(2131757939);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      h.cD(this, paramIntent);
      AppMethodBeat.o(109842);
      return true;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493224;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109834);
    if (this.kaf) {
      setMMTitle(2131757945);
    }
    for (;;)
    {
      this.kak = ((TextView)findViewById(2131307671));
      this.kal = ((TextView)findViewById(2131307672));
      this.kam = findViewById(2131307870);
      this.kan = ((MMSwitchBtn)findViewById(2131307869));
      this.kao = ((TextView)findViewById(2131297386));
      this.kap = ((TextView)findViewById(2131309569));
      this.kaq = ((TextView)findViewById(2131297962));
      this.kak.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109818);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          paramAnonymousView = (String)g.aAh().azQ().get(286723, null);
          if (!Util.isNullOrNil(paramAnonymousView))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("geta8key_username", z.aTY());
            com.tencent.mm.br.c.b(BindLinkedInUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109818);
        }
      });
      this.kao.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109820);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
              h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(2131757934), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      this.kap.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109823);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(2131757936), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(109822);
              paramAnonymous2DialogInterface = new com.tencent.mm.plugin.account.bind.a.c();
              BindLinkedInUI.a(BindLinkedInUI.this, h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(2131762446), false, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(109821);
                  g.azz().a(paramAnonymous2DialogInterface);
                  AppMethodBeat.o(109821);
                }
              }));
              g.azz().a(paramAnonymous2DialogInterface, 0);
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
      this.kaq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109824);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      if (this.kag) {
        setMMTitle(2131757948);
      } else {
        setMMTitle(2131757938);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109843);
    Log.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if (paramIntent == null)
    {
      AppMethodBeat.o(109843);
      return;
    }
    switch (paramInt1)
    {
    default: 
      Log.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
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
    g.azz().a(549, this);
    g.azz().a(550, this);
    this.kah = getIntent().getBundleExtra("qrcode_bundle");
    if (this.kah != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.kaf = bool;
      if (this.kah != null)
      {
        this.fuT = this.kah.getString("i");
        this.fuU = this.kah.getString("n");
        this.kar = this.kah.getString("t");
        this.kas = this.kah.getString("o");
        this.kat = this.kah.getString("s");
        this.kau = this.kah.getString("r");
        if ((this.fuT == null) || (this.fuU == null) || (this.kar == null) || (this.kat == null) || (this.kau == null)) {
          h.a(this, getString(2131757935), null, false, new DialogInterface.OnClickListener()
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
      this.kag = getIntent().getBooleanExtra("oversea_entry", false);
      amZ();
      if (this.kaf) {
        this.kae = true;
      }
      initView();
      if ((this.kah != null) && (this.kac) && (this.kad.equals(this.fuT)))
      {
        this.kai = true;
        gh(true);
      }
      AppMethodBeat.o(109829);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109830);
    g.azz().b(550, this);
    g.azz().b(549, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(109844);
    if (this.iLh != null)
    {
      this.iLh.dismiss();
      this.iLh = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramq.getType() == 549) {
        if (paramInt2 == 1) {
          paramInt1 = 2131757943;
        }
      }
      for (;;)
      {
        h.c(this, getString(paramInt1), null, true);
        AppMethodBeat.o(109844);
        return;
        paramInt1 = 2131757942;
        continue;
        if (paramq.getType() != 550) {
          break;
        }
        paramInt1 = 2131757944;
      }
      AppMethodBeat.o(109844);
      return;
    }
    if (paramq.getType() == 549)
    {
      this.kaj = true;
      if (!this.kai) {
        paramInt1 = 2131757939;
      }
    }
    for (;;)
    {
      paramString = getString(paramInt1);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      h.cD(this, paramString);
      amZ();
      this.kae = this.kan.QDw;
      updateView();
      AppMethodBeat.o(109844);
      return;
      paramInt1 = 2131757940;
      continue;
      if (paramq.getType() != 550) {
        break;
      }
      paramInt1 = 2131757950;
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