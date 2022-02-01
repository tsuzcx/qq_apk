package com.tencent.mm.plugin.appbrand.ipc;

import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.multitask.a.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

public class AppBrandTaskProxyUI
  extends AppBrandProcessProxyUI
{
  public String appId;
  private String fileName;
  private String filePath;
  private String lPJ;
  public com.tencent.mm.plugin.appbrand.r.a rvg;
  private boolean rvh;
  public boolean rvi;
  public boolean rvj;
  public ValueCallback<Integer> rvk;
  public ValueCallback<String> rvl;
  private ValueCallback<Integer> rvm;
  private MMToClientEvent.c rvn;
  private String token;
  
  public AppBrandTaskProxyUI()
  {
    AppMethodBeat.i(45416);
    this.appId = "";
    this.filePath = "";
    this.lPJ = "";
    this.token = "";
    this.fileName = "";
    this.rvi = true;
    this.rvj = false;
    this.rvk = null;
    this.rvl = null;
    this.rvm = new ValueCallback() {};
    this.rvn = new MMToClientEvent.c()
    {
      public final void dL(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45415);
        if ((paramAnonymousObject instanceof MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent))
        {
          paramAnonymousObject = (MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this) != null))
          {
            if (!Util.isEqual(paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this)))
            {
              Log.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.filePath:%s filePath:%s", new Object[] { paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this) });
              AppMethodBeat.o(45415);
              return;
            }
            Log.i("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.action:%s", new Object[] { Integer.valueOf(paramAnonymousObject.action) });
            switch (paramAnonymousObject.action)
            {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            default: 
              AppMethodBeat.o(45415);
              return;
            case 1: 
            case 8: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).ke(true);
              AppMethodBeat.o(45415);
              return;
            case 2: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).ke(false);
              if (AppBrandTaskProxyUI.c(AppBrandTaskProxyUI.this))
              {
                MiniReaderLogic.a(false, AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.h(AppBrandTaskProxyUI.this), true, AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this), false);
                AppMethodBeat.o(45415);
                return;
              }
              AppBrandTaskProxyUI.j(AppBrandTaskProxyUI.this);
              com.tencent.mm.xwebutil.a.am(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this));
              MiniReaderLogic.a(false, false, AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.k(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.l(AppBrandTaskProxyUI.this));
              AppMethodBeat.o(45415);
              return;
            }
            ExportFileUtil.c(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), new ExportFileUtil.a()
            {
              public final void cg(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(319394);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(ba.i.toast_file_saved_fmt, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(319394);
              }
              
              public final void ch(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(319397);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(ba.i.toast_file_saved_fail), 1).show();
                AppMethodBeat.o(319397);
              }
            });
            AppMethodBeat.o(45415);
            return;
          }
          Log.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent fail");
        }
        AppMethodBeat.o(45415);
      }
    };
    AppMethodBeat.o(45416);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.filePath = paramString1;
    this.lPJ = paramString2;
    this.token = paramString3;
    this.fileName = paramString4;
    this.rvh = paramBoolean;
  }
  
  public final void cpy()
  {
    AppMethodBeat.i(319488);
    Log.i("MicroMsg.AppBrandTaskProxyUI", "creatFilesFloatball() processName:%s", new Object[] { MMApplicationContext.getProcessName() });
    this.rvg = new com.tencent.mm.plugin.appbrand.r.a(new b(getContext()));
    this.rvg.a(this.filePath, this.lPJ, this.appId, MMApplicationContext.getProcessName(), this.rvh, this);
    com.tencent.mm.plugin.appbrand.r.a locala = this.rvg;
    String str1 = this.lPJ;
    String str2 = this.fileName;
    MultiTaskInfo localMultiTaskInfo = locala.LCE;
    localMultiTaskInfo.gkh().title = str2;
    localMultiTaskInfo.gkh().lPJ = str1;
    locala.gjW();
    MMToClientEvent.a(this.appId, this.rvn);
    AppMethodBeat.o(319488);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45419);
    super.onDestroy();
    if (this.rvg != null) {
      com.tencent.mm.xwebutil.a.am(this, this.token, this.filePath);
    }
    MMToClientEvent.b(this.appId, this.rvn);
    AppMethodBeat.o(45419);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45418);
    super.onPause();
    if (this.rvg != null) {
      this.rvg.bhW();
    }
    AppMethodBeat.o(45418);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45417);
    super.onResume();
    if (this.rvg != null) {
      this.rvg.coi();
    }
    AppMethodBeat.o(45417);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI
 * JD-Core Version:    0.7.0.1
 */