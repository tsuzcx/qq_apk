package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
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
  private String gCr;
  public com.tencent.mm.plugin.appbrand.q.a lwE;
  private boolean lwF;
  public boolean lwG;
  public boolean lwH;
  public ValueCallback<Integer> lwI;
  public ValueCallback<String> lwJ;
  private ValueCallback<Integer> lwK;
  private MMToClientEvent.c lwL;
  private String token;
  
  public AppBrandTaskProxyUI()
  {
    AppMethodBeat.i(45416);
    this.appId = "";
    this.filePath = "";
    this.gCr = "";
    this.token = "";
    this.fileName = "";
    this.lwG = true;
    this.lwH = false;
    this.lwI = null;
    this.lwJ = null;
    this.lwK = new ValueCallback() {};
    this.lwL = new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
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
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).ic(true);
              AppMethodBeat.o(45415);
              return;
            case 2: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).ic(false);
              if (AppBrandTaskProxyUI.c(AppBrandTaskProxyUI.this))
              {
                MiniReaderLogic.a(false, AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.h(AppBrandTaskProxyUI.this), true, AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this), false);
                AppMethodBeat.o(45415);
                return;
              }
              AppBrandTaskProxyUI.j(AppBrandTaskProxyUI.this);
              com.tencent.mm.cr.a.Z(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this));
              MiniReaderLogic.a(false, false, AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.k(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.l(AppBrandTaskProxyUI.this));
              AppMethodBeat.o(45415);
              return;
            }
            p.c(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), new p.a()
            {
              public final void bP(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(226646);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(2131766791, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(226646);
              }
              
              public final void bQ(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(226647);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(2131766790), 1).show();
                AppMethodBeat.o(226647);
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
    this.gCr = paramString2;
    this.token = paramString3;
    this.fileName = paramString4;
    this.lwF = paramBoolean;
  }
  
  public final void bDR()
  {
    AppMethodBeat.i(226648);
    Log.i("MicroMsg.AppBrandTaskProxyUI", "creatFilesFloatball() processName:%s", new Object[] { MMApplicationContext.getProcessName() });
    this.lwE = new com.tencent.mm.plugin.appbrand.q.a(new b(getContext()));
    this.lwE.a(this.filePath, this.gCr, this.appId, MMApplicationContext.getProcessName(), this.lwF, this);
    com.tencent.mm.plugin.appbrand.q.a locala = this.lwE;
    String str1 = this.gCr;
    String str2 = this.fileName;
    MultiTaskInfo localMultiTaskInfo = locala.Abp;
    localMultiTaskInfo.erh().title = str2;
    localMultiTaskInfo.erh().gCr = str1;
    locala.eqX();
    MMToClientEvent.a(this.appId, this.lwL);
    AppMethodBeat.o(226648);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45419);
    super.onDestroy();
    if (this.lwE != null) {
      com.tencent.mm.cr.a.Z(this, this.token, this.filePath);
    }
    MMToClientEvent.b(this.appId, this.lwL);
    AppMethodBeat.o(45419);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45418);
    super.onPause();
    if (this.lwE != null) {
      this.lwE.aGj();
    }
    AppMethodBeat.o(45418);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45417);
    super.onResume();
    if (this.lwE != null) {
      this.lwE.bCA();
    }
    AppMethodBeat.o(45417);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI
 * JD-Core Version:    0.7.0.1
 */