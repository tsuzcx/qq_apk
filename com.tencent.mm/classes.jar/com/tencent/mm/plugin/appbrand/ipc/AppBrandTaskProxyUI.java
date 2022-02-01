package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public class AppBrandTaskProxyUI
  extends AppBrandProcessProxyUI
{
  public String appId;
  private String fBR;
  private String fileName;
  private String filePath;
  public com.tencent.mm.plugin.appbrand.floatball.b jVq;
  private boolean jVr;
  public boolean jVs;
  public boolean jVt;
  public ValueCallback<Integer> jVu;
  public ValueCallback<String> jVv;
  private ValueCallback<Integer> jVw;
  private MMToClientEvent.c jVx;
  private String token;
  
  public AppBrandTaskProxyUI()
  {
    AppMethodBeat.i(45416);
    this.appId = "";
    this.filePath = "";
    this.fBR = "";
    this.token = "";
    this.fileName = "";
    this.jVs = true;
    this.jVt = false;
    this.jVu = null;
    this.jVv = null;
    this.jVw = new ValueCallback() {};
    this.jVx = new MMToClientEvent.c()
    {
      public final void cf(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45415);
        if ((paramAnonymousObject instanceof MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent))
        {
          paramAnonymousObject = (MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this) != null))
          {
            if (!bs.lr(paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this)))
            {
              ac.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.filePath:%s filePath:%s", new Object[] { paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this) });
              AppMethodBeat.o(45415);
              return;
            }
            ac.i("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.action:%s", new Object[] { Integer.valueOf(paramAnonymousObject.action) });
            switch (paramAnonymousObject.action)
            {
            case 3: 
            default: 
              AppMethodBeat.o(45415);
              return;
            case 1: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).ga(true);
              AppMethodBeat.o(45415);
              return;
            case 2: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).ga(false);
              if (AppBrandTaskProxyUI.c(AppBrandTaskProxyUI.this))
              {
                MiniReaderLogic.a(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.h(AppBrandTaskProxyUI.this), true, AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this));
                AppMethodBeat.o(45415);
                return;
              }
              AppBrandTaskProxyUI.j(AppBrandTaskProxyUI.this);
              a.S(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this));
              MiniReaderLogic.a(false, false, AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.k(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.l(AppBrandTaskProxyUI.this));
              AppMethodBeat.o(45415);
              return;
            }
            p.c(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), new p.a()
            {
              public final void bD(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(186542);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(2131764447, new Object[] { com.tencent.mm.sdk.f.b.aLU(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(186542);
              }
              
              public final void bE(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(186543);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(2131764446), 1).show();
                AppMethodBeat.o(186543);
              }
            });
            AppMethodBeat.o(45415);
            return;
          }
          ac.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent fail");
        }
        AppMethodBeat.o(45415);
      }
    };
    AppMethodBeat.o(45416);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.filePath = paramString1;
    this.fBR = paramString2;
    this.token = paramString3;
    this.fileName = paramString4;
    this.jVr = paramBoolean;
  }
  
  public final void ber()
  {
    AppMethodBeat.i(186544);
    ac.i("MicroMsg.AppBrandTaskProxyUI", "creatFilesFloatball() processName:%s", new Object[] { ai.getProcessName() });
    this.jVq = new com.tencent.mm.plugin.appbrand.floatball.b(new e(getContext()));
    this.jVq.a(this.filePath, this.fBR, this.appId, ai.getProcessName(), this.jVr, this);
    com.tencent.mm.plugin.appbrand.floatball.b localb = this.jVq;
    Object localObject = this.fBR;
    String str = this.fileName;
    Integer localInteger = d.SU((String)localObject);
    localObject = localInteger;
    if (localInteger == null) {
      localObject = d.SU("unknown");
    }
    localb.nfN.lzV = ((Integer)localObject).intValue();
    localb.nfN.name = str;
    localb.bGr();
    MMToClientEvent.a(this.appId, this.jVx);
    AppMethodBeat.o(186544);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45419);
    super.onDestroy();
    if (this.jVq != null)
    {
      this.jVq.onDestroy();
      a.S(this, this.token, this.filePath);
    }
    MMToClientEvent.b(this.appId, this.jVx);
    AppMethodBeat.o(45419);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45418);
    super.onPause();
    if (this.jVq != null) {
      this.jVq.bcY();
    }
    AppMethodBeat.o(45418);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45417);
    super.onResume();
    if (this.jVq != null) {
      this.jVq.bcX();
    }
    AppMethodBeat.o(45417);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI
 * JD-Core Version:    0.7.0.1
 */