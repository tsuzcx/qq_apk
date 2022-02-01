package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.lx.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.xweb.util.g;

@com.tencent.mm.ui.base.a(3)
public class ChooseMsgFileShowUI
  extends MMActivity
{
  private String fXl;
  private String fileName;
  private String filePath;
  private MiniReaderLogic.a<Integer> kQA;
  private boolean ksV;
  private boolean ksW;
  private ValueCallback<String> ksY;
  private ValueCallback<Integer> ksZ;
  private int oZZ;
  private a paa;
  private c<lx> pab;
  private String token;
  
  public ChooseMsgFileShowUI()
  {
    AppMethodBeat.i(123410);
    this.filePath = "";
    this.fXl = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.ksV = true;
    this.ksW = false;
    this.pab = new c()
    {
      private boolean a(lx paramAnonymouslx)
      {
        AppMethodBeat.i(123403);
        if ((paramAnonymouslx != null) && (paramAnonymouslx.dAo != null) && (ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this) != null)) {
          if (!bu.lX(paramAnonymouslx.dAo.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this))) {
            ae.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.filePath:%s filePath:%s", new Object[] { paramAnonymouslx.dAo.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(123403);
          return false;
          ae.i("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymouslx.dAo.action) });
          switch (paramAnonymouslx.dAo.action)
          {
          case 3: 
          default: 
            break;
          case 1: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).o(true, 2);
            break;
          case 2: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).o(false, 2);
            if (ChooseMsgFileShowUI.c(ChooseMsgFileShowUI.this))
            {
              MiniReaderLogic.a(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.h(ChooseMsgFileShowUI.this), true, "");
            }
            else
            {
              ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this, false);
              com.tencent.mm.cp.a.V(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this));
              MiniReaderLogic.a(false, false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, false));
            }
            break;
          case 4: 
            p.c(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), new p.a()
            {
              public final void bF(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(209734);
                Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(2131764447, new Object[] { com.tencent.mm.sdk.f.b.aSY(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(209734);
              }
              
              public final void bG(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(209735);
                Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(2131764446), 1).show();
                AppMethodBeat.o(209735);
              }
            });
            continue;
            ae.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.ksZ = new ValueCallback() {};
    this.kQA = null;
    this.ksY = new ValueCallback() {};
    AppMethodBeat.o(123410);
  }
  
  private MiniReaderLogic.a<Integer> jD(boolean paramBoolean)
  {
    AppMethodBeat.i(123411);
    if ((!paramBoolean) && (this.kQA != null))
    {
      locala = this.kQA;
      AppMethodBeat.o(123411);
      return locala;
    }
    if (this.kQA != null) {
      this.kQA.hGZ = true;
    }
    this.kQA = new MiniReaderLogic.a() {};
    MiniReaderLogic.a locala = this.kQA;
    AppMethodBeat.o(123411);
    return locala;
  }
  
  public static void u(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123416);
    Intent localIntent = new Intent(paramContext, ChooseMsgFileShowUI.class);
    localIntent.putExtra("key_filepath", paramString1);
    localIntent.putExtra("key_fileext", paramString2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahE(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.mt(0));
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
    this.fXl = getIntent().getStringExtra("key_fileext");
    this.oZZ = getIntent().getIntExtra("sence", 0);
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
        ae.e("MicroMsg.ChooseMsgFileShowUI", "get file name error " + paramBundle.getMessage());
        this.fileName = "";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    this.paa = new a(new b(getContext()));
    this.paa.J(this.filePath, this.fXl, this.oZZ);
    locala = this.paa;
    paramBundle = this.fXl;
    str = this.fileName;
    localInteger = d.Xd(paramBundle);
    paramBundle = localInteger;
    if (localInteger == null) {
      paramBundle = d.Xd("unknown");
    }
    locala.nLK.mdM = paramBundle.intValue();
    locala.nLK.name = str;
    locala.bLz();
    if (this.pab != null) {
      this.pab.alive();
    }
    MiniReaderLogic.a(this.paa.bLw(), this, this.filePath, this.fileName, this.fXl, this.token, this.ksY, jD(true), true, "");
    AppMethodBeat.o(123412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123415);
    com.tencent.mm.cp.a.V(this, this.token, this.filePath);
    super.onDestroy();
    if (this.pab != null) {
      this.pab.dead();
    }
    if (this.paa != null) {
      this.paa.onDestroy();
    }
    AppMethodBeat.o(123415);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123414);
    super.onPause();
    if (this.paa != null) {
      this.paa.bhk();
    }
    AppMethodBeat.o(123414);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123413);
    super.onResume();
    if (this.paa != null) {
      this.paa.bhj();
    }
    AppMethodBeat.o(123413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI
 * JD-Core Version:    0.7.0.1
 */