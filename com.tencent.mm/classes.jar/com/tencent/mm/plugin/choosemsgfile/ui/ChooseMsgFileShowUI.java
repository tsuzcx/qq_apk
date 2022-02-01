package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.le.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.xweb.util.g;

@com.tencent.mm.ui.base.a(3)
public class ChooseMsgFileShowUI
  extends MMActivity
{
  private String fileName;
  private String filePath;
  private String fyk;
  private MiniReaderLogic.a<Integer> jQW;
  private boolean juX;
  private boolean juY;
  private ValueCallback<String> jva;
  private ValueCallback<Integer> jvb;
  private int nNc;
  private a nNd;
  private c<le> nNe;
  private String token;
  
  public ChooseMsgFileShowUI()
  {
    AppMethodBeat.i(123410);
    this.filePath = "";
    this.fyk = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.juX = true;
    this.juY = false;
    this.nNe = new c()
    {
      private boolean a(le paramAnonymousle)
      {
        AppMethodBeat.i(123403);
        if ((paramAnonymousle != null) && (paramAnonymousle.dpK != null) && (ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this) != null)) {
          if (!bt.kU(paramAnonymousle.dpK.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this))) {
            ad.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.filePath:%s filePath:%s", new Object[] { paramAnonymousle.dpK.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(123403);
          return false;
          ad.i("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousle.dpK.action) });
          switch (paramAnonymousle.dpK.action)
          {
          default: 
            break;
          case 1: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).fE(true);
            break;
          case 2: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).fE(false);
            if (ChooseMsgFileShowUI.c(ChooseMsgFileShowUI.this))
            {
              MiniReaderLogic.a(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.h(ChooseMsgFileShowUI.this), true, "");
            }
            else
            {
              ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this, false);
              com.tencent.mm.cr.a.T(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this));
              MiniReaderLogic.a(false, false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, false));
              continue;
              ad.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent fail");
            }
            break;
          }
        }
      }
    };
    this.jvb = new ChooseMsgFileShowUI.2(this);
    this.jQW = null;
    this.jva = new ValueCallback() {};
    AppMethodBeat.o(123410);
  }
  
  private MiniReaderLogic.a<Integer> iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(123411);
    if ((!paramBoolean) && (this.jQW != null))
    {
      locala = this.jQW;
      AppMethodBeat.o(123411);
      return locala;
    }
    if (this.jQW != null) {
      this.jQW.gLu = true;
    }
    this.jQW = new MiniReaderLogic.a() {};
    MiniReaderLogic.a locala = this.jQW;
    AppMethodBeat.o(123411);
    return locala;
  }
  
  public static void u(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123416);
    Intent localIntent = new Intent(paramContext, ChooseMsgFileShowUI.class);
    localIntent.putExtra("key_filepath", paramString1);
    localIntent.putExtra("key_fileext", paramString2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.lS(0));
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
    this.fyk = getIntent().getStringExtra("key_fileext");
    this.nNc = getIntent().getIntExtra("sence", 0);
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
        ad.e("MicroMsg.ChooseMsgFileShowUI", "get file name error " + paramBundle.getMessage());
        this.fileName = "";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    this.nNd = new a(new b(getContext()));
    this.nNd.H(this.filePath, this.fyk, this.nNc);
    locala = this.nNd;
    paramBundle = this.fyk;
    str = this.fileName;
    localInteger = d.OK(paramBundle);
    paramBundle = localInteger;
    if (localInteger == null) {
      paramBundle = d.OK("unknown");
    }
    locala.mDH.kYl = paramBundle.intValue();
    locala.mDH.name = str;
    locala.bzv();
    if (this.nNe != null) {
      this.nNe.alive();
    }
    MiniReaderLogic.a(this.nNd.bzs(), this, this.filePath, this.fileName, this.fyk, this.token, this.jva, iQ(true), true, "");
    AppMethodBeat.o(123412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123415);
    com.tencent.mm.cr.a.T(this, this.token, this.filePath);
    super.onDestroy();
    if (this.nNe != null) {
      this.nNe.dead();
    }
    if (this.nNd != null) {
      this.nNd.onDestroy();
    }
    AppMethodBeat.o(123415);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123414);
    super.onPause();
    if (this.nNd != null) {
      this.nNd.aWa();
    }
    AppMethodBeat.o(123414);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123413);
    super.onResume();
    if (this.nNd != null) {
      this.nNd.aVZ();
    }
    AppMethodBeat.o(123413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI
 * JD-Core Version:    0.7.0.1
 */