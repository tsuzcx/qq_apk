package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.mn.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.xweb.util.h;

@com.tencent.mm.ui.base.a(3)
public class ChooseMsgFileShowUI
  extends MMSecDataActivity
{
  private d Qls;
  private a Qlu;
  private String fileName;
  private String filePath;
  private String gCr;
  private MiniReaderLogic.a<Integer> lVE;
  private boolean lwG;
  private boolean lwH;
  private ValueCallback<String> lwJ;
  private ValueCallback<Integer> lwK;
  private int qoX;
  private IListener<mn> qoZ;
  private String token;
  
  public ChooseMsgFileShowUI()
  {
    AppMethodBeat.i(123410);
    this.filePath = "";
    this.gCr = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.lwG = true;
    this.lwH = false;
    this.qoZ = new IListener()
    {
      private boolean a(mn paramAnonymousmn)
      {
        AppMethodBeat.i(123403);
        if ((paramAnonymousmn != null) && (paramAnonymousmn.dSa != null) && (ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this) != null)) {
          if (!Util.isEqual(paramAnonymousmn.dSa.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this))) {
            Log.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.filePath:%s filePath:%s", new Object[] { paramAnonymousmn.dSa.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(123403);
          return false;
          Log.i("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousmn.dSa.action) });
          switch (paramAnonymousmn.dSa.action)
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            break;
          case 1: 
          case 8: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).ic(true);
            break;
          case 2: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).ic(false);
            if (ChooseMsgFileShowUI.c(ChooseMsgFileShowUI.this))
            {
              MiniReaderLogic.a(false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.h(ChooseMsgFileShowUI.this), true, "", false);
            }
            else
            {
              ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this, false);
              com.tencent.mm.cr.a.Z(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this));
              MiniReaderLogic.a(false, false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, false));
            }
            break;
          case 4: 
            p.c(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), new p.a()
            {
              public final void bP(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(237145);
                Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(2131766791, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(237145);
              }
              
              public final void bQ(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(237146);
                Toast.makeText(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.this.getString(2131766790), 1).show();
                AppMethodBeat.o(237146);
              }
            });
            continue;
            Log.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.lwK = new ValueCallback() {};
    this.lVE = null;
    this.lwJ = new ValueCallback() {};
    AppMethodBeat.o(123410);
  }
  
  private MiniReaderLogic.a<Integer> kG(boolean paramBoolean)
  {
    AppMethodBeat.i(123411);
    if ((!paramBoolean) && (this.lVE != null))
    {
      locala = this.lVE;
      AppMethodBeat.o(123411);
      return locala;
    }
    if (this.lVE != null) {
      this.lVE.iBj = true;
    }
    this.lVE = new MiniReaderLogic.a() {};
    MiniReaderLogic.a locala = this.lVE;
    AppMethodBeat.o(123411);
    return locala;
  }
  
  public static void t(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123416);
    Intent localIntent = new Intent(paramContext, ChooseMsgFileShowUI.class);
    localIntent.putExtra("key_filepath", paramString1);
    localIntent.putExtra("key_fileext", paramString2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.pG(0));
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
    this.gCr = getIntent().getStringExtra("key_fileext");
    this.qoX = getIntent().getIntExtra("sence", 0);
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
    this.Qls = new d(new e(getContext()));
    this.Qls.I(this.filePath, this.gCr, this.qoX);
    localObject2 = this.Qls;
    paramBundle = this.gCr;
    localObject3 = this.fileName;
    localObject1 = com.tencent.mm.plugin.ball.f.d.agX(paramBundle);
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = com.tencent.mm.plugin.ball.f.d.agX("unknown");
    }
    ((d)localObject2).oWE.noe = paramBundle.intValue();
    ((d)localObject2).oWE.name = ((String)localObject3);
    ((d)localObject2).cit();
    this.Qlu = new a(new b(getContext()));
    this.Qlu.I(this.filePath, this.gCr, this.qoX);
    paramBundle = this.Qlu;
    localObject1 = this.gCr;
    localObject2 = this.fileName;
    localObject3 = paramBundle.Abp;
    ((MultiTaskInfo)localObject3).erh().title = ((String)localObject2);
    ((MultiTaskInfo)localObject3).erh().gCr = ((String)localObject1);
    paramBundle.eqX();
    if (this.qoZ != null) {
      this.qoZ.alive();
    }
    MiniReaderLogic.a(this.Qlu.eqW(), this.Qlu.eqZ(), this, this.filePath, this.fileName, this.gCr, this.token, this.lwJ, kG(true), true, "", true, false);
    AppMethodBeat.o(123412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123415);
    com.tencent.mm.cr.a.Z(this, this.token, this.filePath);
    super.onDestroy();
    if (this.qoZ != null) {
      this.qoZ.dead();
    }
    if (this.Qls != null) {
      this.Qls.onDestroy();
    }
    AppMethodBeat.o(123415);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123414);
    super.onPause();
    if (this.Qls != null) {
      this.Qls.aGj();
    }
    if (this.Qlu != null) {
      this.Qlu.aGj();
    }
    AppMethodBeat.o(123414);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123413);
    super.onResume();
    if (this.Qls != null) {
      this.Qls.bCA();
    }
    if (this.Qlu != null) {
      this.Qlu.bCA();
    }
    AppMethodBeat.o(123413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI
 * JD-Core Version:    0.7.0.1
 */