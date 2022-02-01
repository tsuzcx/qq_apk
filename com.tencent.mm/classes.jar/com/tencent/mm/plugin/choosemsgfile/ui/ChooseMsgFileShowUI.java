package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.ln.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.xweb.util.g;

@com.tencent.mm.ui.base.a(3)
public class ChooseMsgFileShowUI
  extends MMActivity
{
  private String fBR;
  private String fileName;
  private String filePath;
  private boolean jVs;
  private boolean jVt;
  private ValueCallback<String> jVv;
  private ValueCallback<Integer> jVw;
  private MiniReaderLogic.a<Integer> krH;
  private int oqc;
  private a oqd;
  private c<ln> oqe;
  private String token;
  
  public ChooseMsgFileShowUI()
  {
    AppMethodBeat.i(123410);
    this.filePath = "";
    this.fBR = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.jVs = true;
    this.jVt = false;
    this.oqe = new c()
    {
      private boolean a(ln paramAnonymousln)
      {
        AppMethodBeat.i(123403);
        if ((paramAnonymousln != null) && (paramAnonymousln.dnv != null) && (ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this) != null)) {
          if (!bs.lr(paramAnonymousln.dnv.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this))) {
            ac.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.filePath:%s filePath:%s", new Object[] { paramAnonymousln.dnv.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(123403);
          return false;
          ac.i("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousln.dnv.action) });
          switch (paramAnonymousln.dnv.action)
          {
          case 3: 
          default: 
            break;
          case 1: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).ga(true);
            break;
          case 2: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).ga(false);
            if (ChooseMsgFileShowUI.c(ChooseMsgFileShowUI.this))
            {
              MiniReaderLogic.a(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.h(ChooseMsgFileShowUI.this), true, "");
            }
            else
            {
              ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this, false);
              com.tencent.mm.cq.a.S(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this));
              MiniReaderLogic.a(false, false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, false));
            }
            break;
          case 4: 
            p.c(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), new p.a()
            {
              public final void bD(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(209636);
                Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(2131764447, new Object[] { com.tencent.mm.sdk.f.b.aLU(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(209636);
              }
              
              public final void bE(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(209637);
                Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(2131764446), 1).show();
                AppMethodBeat.o(209637);
              }
            });
            continue;
            ac.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.jVw = new ValueCallback() {};
    this.krH = null;
    this.jVv = new ValueCallback() {};
    AppMethodBeat.o(123410);
  }
  
  private MiniReaderLogic.a<Integer> jt(boolean paramBoolean)
  {
    AppMethodBeat.i(123411);
    if ((!paramBoolean) && (this.krH != null))
    {
      locala = this.krH;
      AppMethodBeat.o(123411);
      return locala;
    }
    if (this.krH != null) {
      this.krH.hlU = true;
    }
    this.krH = new MiniReaderLogic.a() {};
    MiniReaderLogic.a locala = this.krH;
    AppMethodBeat.o(123411);
    return locala;
  }
  
  public static void t(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123416);
    Intent localIntent = new Intent(paramContext, ChooseMsgFileShowUI.class);
    localIntent.putExtra("key_filepath", paramString1);
    localIntent.putExtra("key_fileext", paramString2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.aeD(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123416);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123412);
    super.onCreate(paramBundle);
    this.filePath = getIntent().getStringExtra("key_filepath");
    this.fBR = getIntent().getStringExtra("key_fileext");
    this.oqc = getIntent().getIntExtra("sence", 0);
    try
    {
      int j = this.filePath.lastIndexOf('/') + 1;
      if (j < 0) {
        break label302;
      }
      i = j;
      if (j != this.filePath.length()) {}
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        a locala;
        String str;
        Integer localInteger;
        ac.e("MicroMsg.ChooseMsgFileShowUI", "get file name error " + paramBundle.getMessage());
        this.fileName = "";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    this.oqd = new a(new b(getContext()));
    this.oqd.I(this.filePath, this.fBR, this.oqc);
    locala = this.oqd;
    paramBundle = this.fBR;
    str = this.fileName;
    localInteger = d.SU(paramBundle);
    paramBundle = localInteger;
    if (localInteger == null) {
      paramBundle = d.SU("unknown");
    }
    locala.nfN.lzV = paramBundle.intValue();
    locala.nfN.name = str;
    locala.bGr();
    if (this.oqe != null) {
      this.oqe.alive();
    }
    MiniReaderLogic.a(this.oqd.bGo(), this, this.filePath, this.fileName, this.fBR, this.token, this.jVv, jt(true), true, "");
    AppMethodBeat.o(123412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123415);
    com.tencent.mm.cq.a.S(this, this.token, this.filePath);
    super.onDestroy();
    if (this.oqe != null) {
      this.oqe.dead();
    }
    if (this.oqd != null) {
      this.oqd.onDestroy();
    }
    AppMethodBeat.o(123415);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123414);
    super.onPause();
    if (this.oqd != null) {
      this.oqd.bcY();
    }
    AppMethodBeat.o(123414);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123413);
    super.onResume();
    if (this.oqd != null) {
      this.oqd.bcX();
    }
    AppMethodBeat.o(123413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI
 * JD-Core Version:    0.7.0.1
 */