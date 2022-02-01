package com.tencent.mm.plugin.choosemsgfile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ol;
import com.tencent.mm.autogen.a.ol.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import com.tencent.xweb.util.l;

@com.tencent.mm.ui.base.a(3)
public class ChooseMsgFileShowUI
  extends MMSecDataActivity
{
  private String fileName;
  private String filePath;
  private String lPJ;
  private MiniReaderLogic.a<Integer> rXZ;
  private boolean rvi;
  private boolean rvj;
  private ValueCallback<String> rvl;
  private ValueCallback<Integer> rvm;
  private String token;
  private int wQW;
  private a wQX;
  private b wQY;
  private IListener<ol> wQZ;
  
  public ChooseMsgFileShowUI()
  {
    AppMethodBeat.i(123410);
    this.filePath = "";
    this.lPJ = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.rvi = true;
    this.rvj = false;
    this.wQZ = new IListener(f.hfK)
    {
      private boolean a(ol paramAnonymousol)
      {
        AppMethodBeat.i(123403);
        if ((paramAnonymousol != null) && (paramAnonymousol.hRf != null) && (ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this) != null)) {
          if (!Util.isEqual(paramAnonymousol.hRf.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this))) {
            Log.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.filePath:%s filePath:%s", new Object[] { paramAnonymousol.hRf.filePath, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(123403);
          return false;
          Log.i("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousol.hRf.action) });
          switch (paramAnonymousol.hRf.action)
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            break;
          case 1: 
          case 8: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).ke(true);
            break;
          case 2: 
            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this).ke(false);
            if (ChooseMsgFileShowUI.c(ChooseMsgFileShowUI.this))
            {
              MiniReaderLogic.a(false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.h(ChooseMsgFileShowUI.this), true, "", false);
            }
            else
            {
              ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this, false);
              com.tencent.mm.xwebutil.a.am(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this));
              MiniReaderLogic.a(false, false, ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.d(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.e(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.f(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.g(ChooseMsgFileShowUI.this), ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, false));
            }
            break;
          case 4: 
            ExportFileUtil.c(ChooseMsgFileShowUI.this, ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this), new ChooseMsgFileShowUI.1.1(this));
            continue;
            Log.e("MicroMsg.ChooseMsgFileShowUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.rvm = new ValueCallback() {};
    this.rXZ = null;
    this.rvl = new ValueCallback() {};
    AppMethodBeat.o(123410);
  }
  
  private MiniReaderLogic.a<Integer> nn(boolean paramBoolean)
  {
    AppMethodBeat.i(123411);
    if ((!paramBoolean) && (this.rXZ != null))
    {
      locala = this.rXZ;
      AppMethodBeat.o(123411);
      return locala;
    }
    if (this.rXZ != null) {
      this.rXZ.nVY = true;
    }
    this.rXZ = new MiniReaderLogic.a() {};
    MiniReaderLogic.a locala = this.rXZ;
    AppMethodBeat.o(123411);
    return locala;
  }
  
  public static void x(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123416);
    Intent localIntent = new Intent(paramContext, ChooseMsgFileShowUI.class);
    localIntent.putExtra("key_filepath", paramString1);
    localIntent.putExtra("key_fileext", paramString2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileShowUI", "showFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123416);
  }
  
  public void finish()
  {
    AppMethodBeat.i(262574);
    if (this.wQX != null) {
      this.wQX.finish();
    }
    super.finish();
    AppMethodBeat.o(262574);
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
    this.lPJ = getIntent().getStringExtra("key_fileext");
    this.wQW = getIntent().getIntExtra("sence", 0);
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
    this.wQX = new a(new c(getContext()));
    this.wQX.T(this.filePath, this.lPJ, this.wQW);
    localObject2 = this.wQX;
    paramBundle = this.lPJ;
    localObject3 = this.fileName;
    localObject1 = com.tencent.mm.plugin.ball.f.d.ahZ(paramBundle);
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = com.tencent.mm.plugin.ball.f.d.ahZ("unknown");
    }
    ((a)localObject2).vjV.tus = paramBundle.intValue();
    ((a)localObject2).vjV.name = ((String)localObject3);
    ((a)localObject2).cYr();
    this.wQY = new b(new d(getContext()));
    this.wQY.T(this.filePath, this.lPJ, this.wQW);
    paramBundle = this.wQY;
    localObject1 = this.lPJ;
    localObject2 = this.fileName;
    localObject3 = paramBundle.LCE;
    ((MultiTaskInfo)localObject3).gkh().title = ((String)localObject2);
    ((MultiTaskInfo)localObject3).gkh().lPJ = ((String)localObject1);
    paramBundle.gjW();
    if (this.wQZ != null) {
      this.wQZ.alive();
    }
    MiniReaderLogic.a(this.wQY.gjV(), this.wQY.gjZ(), this, this.filePath, this.fileName, this.lPJ, this.token, this.rvl, nn(true), true, "", true, false);
    AppMethodBeat.o(123412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123415);
    com.tencent.mm.xwebutil.a.am(this, this.token, this.filePath);
    super.onDestroy();
    if (this.wQZ != null) {
      this.wQZ.dead();
    }
    if (this.wQX != null) {
      this.wQX.onDestroy();
    }
    AppMethodBeat.o(123415);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123414);
    super.onPause();
    if (this.wQX != null) {
      this.wQX.bhW();
    }
    if (this.wQY != null) {
      this.wQY.bhW();
    }
    AppMethodBeat.o(123414);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123413);
    super.onResume();
    if (this.wQX != null) {
      this.wQX.coi();
    }
    if (this.wQY != null) {
      this.wQY.coi();
    }
    AppMethodBeat.o(123413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI
 * JD-Core Version:    0.7.0.1
 */