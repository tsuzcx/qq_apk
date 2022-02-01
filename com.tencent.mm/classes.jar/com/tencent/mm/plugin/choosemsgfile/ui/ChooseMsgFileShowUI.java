package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ne;
import com.tencent.mm.f.a.ne.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.xweb.util.h;

@com.tencent.mm.ui.base.a(3)
public class ChooseMsgFileShowUI
  extends MMSecDataActivity
{
  private String fileName;
  private String filePath;
  private String jmx;
  private MiniReaderLogic.a<Integer> oSI;
  private boolean oro;
  private boolean orp;
  private ValueCallback<String> orr;
  private ValueCallback<Integer> ors;
  private int tNG;
  private a tNH;
  private b tNI;
  private IListener<ne> tNJ;
  private String token;
  
  public ChooseMsgFileShowUI()
  {
    AppMethodBeat.i(123410);
    this.filePath = "";
    this.jmx = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.oro = true;
    this.orp = false;
    this.tNJ = new IListener()
    {
      private boolean a(ne paramAnonymousne)
      {
        AppMethodBeat.i(123403);
        if ((paramAnonymousne != null) && (paramAnonymousne.fLx != null) && (ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this) != null)) {
          if (!Util.isEqual(paramAnonymousne.fLx.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this))) {
            Log.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.filePath:%s filePath:%s", new Object[] { paramAnonymousne.fLx.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(123403);
          return false;
          Log.i("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousne.fLx.action) });
          switch (paramAnonymousne.fLx.action)
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            break;
          case 1: 
          case 8: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).iW(true);
            break;
          case 2: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).iW(false);
            if (ChooseMsgFileShowUI.c(ChooseMsgFileShowUI.this))
            {
              MiniReaderLogic.a(false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.h(ChooseMsgFileShowUI.this), true, "", false);
            }
            else
            {
              ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this, false);
              com.tencent.mm.xwebutil.a.ah(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this));
              MiniReaderLogic.a(false, false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, false));
            }
            break;
          case 4: 
            p.c(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), new ChooseMsgFileShowUI.1.1(this));
            continue;
            Log.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.ors = new ValueCallback() {};
    this.oSI = null;
    this.orr = new ValueCallback() {};
    AppMethodBeat.o(123410);
  }
  
  private MiniReaderLogic.a<Integer> lS(boolean paramBoolean)
  {
    AppMethodBeat.i(123411);
    if ((!paramBoolean) && (this.oSI != null))
    {
      locala = this.oSI;
      AppMethodBeat.o(123411);
      return locala;
    }
    if (this.oSI != null) {
      this.oSI.lqN = true;
    }
    this.oSI = new MiniReaderLogic.a() {};
    MiniReaderLogic.a locala = this.oSI;
    AppMethodBeat.o(123411);
    return locala;
  }
  
  public static void w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123416);
    Intent localIntent = new Intent(paramContext, ChooseMsgFileShowUI.class);
    localIntent.putExtra("key_filepath", paramString1);
    localIntent.putExtra("key_fileext", paramString2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    this.jmx = getIntent().getStringExtra("key_fileext");
    this.tNG = getIntent().getIntExtra("sence", 0);
    try
    {
      int j = this.filePath.lastIndexOf('/') + 1;
      if (j < 0) {
        break label399;
      }
      i = j;
      if (j != this.filePath.length()) {}
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        Object localObject1;
        Log.e("MicroMsg.ChooseMsgFileShowUI", "get file name error " + paramBundle.getMessage());
        this.fileName = "";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    this.tNH = new a(new c(getContext()));
    this.tNH.M(this.filePath, this.jmx, this.tNG);
    localObject2 = this.tNH;
    paramBundle = this.jmx;
    localObject3 = this.fileName;
    localObject1 = com.tencent.mm.plugin.ball.f.d.aoD(paramBundle);
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = com.tencent.mm.plugin.ball.f.d.aoD("unknown");
    }
    ((a)localObject2).rYE.qpN = paramBundle.intValue();
    ((a)localObject2).rYE.name = ((String)localObject3);
    ((a)localObject2).cvG();
    this.tNI = new b(new d(getContext()));
    this.tNI.M(this.filePath, this.jmx, this.tNG);
    paramBundle = this.tNI;
    localObject1 = this.jmx;
    localObject2 = this.fileName;
    localObject3 = paramBundle.FHd;
    ((MultiTaskInfo)localObject3).fbc().title = ((String)localObject2);
    ((MultiTaskInfo)localObject3).fbc().jmx = ((String)localObject1);
    paramBundle.faR();
    if (this.tNJ != null) {
      this.tNJ.alive();
    }
    MiniReaderLogic.a(this.tNI.faQ(), this.tNI.faT(), this, this.filePath, this.fileName, this.jmx, this.token, this.orr, lS(true), true, "", true, false);
    AppMethodBeat.o(123412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123415);
    com.tencent.mm.xwebutil.a.ah(this, this.token, this.filePath);
    super.onDestroy();
    if (this.tNJ != null) {
      this.tNJ.dead();
    }
    if (this.tNH != null) {
      this.tNH.onDestroy();
    }
    AppMethodBeat.o(123415);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123414);
    super.onPause();
    if (this.tNH != null) {
      this.tNH.aOj();
    }
    if (this.tNI != null) {
      this.tNI.aOj();
    }
    AppMethodBeat.o(123414);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123413);
    super.onResume();
    if (this.tNH != null) {
      this.tNH.bNV();
    }
    if (this.tNI != null) {
      this.tNI.bNV();
    }
    AppMethodBeat.o(123413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI
 * JD-Core Version:    0.7.0.1
 */