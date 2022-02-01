package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public class AppBrandTaskProxyUI
  extends AppBrandProcessProxyUI
{
  public String appId;
  private String fXl;
  private String fileName;
  private String filePath;
  public com.tencent.mm.plugin.appbrand.floatball.b ksU;
  public boolean ksV;
  public boolean ksW;
  public ValueCallback<Integer> ksX;
  public ValueCallback<String> ksY;
  private ValueCallback<Integer> ksZ;
  private MMToClientEvent.c kta;
  private boolean showMenu;
  private String token;
  
  public AppBrandTaskProxyUI()
  {
    AppMethodBeat.i(45416);
    this.appId = "";
    this.filePath = "";
    this.fXl = "";
    this.token = "";
    this.fileName = "";
    this.ksV = true;
    this.ksW = false;
    this.ksX = null;
    this.ksY = null;
    this.ksZ = new ValueCallback() {};
    this.kta = new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45415);
        if ((paramAnonymousObject instanceof MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent))
        {
          paramAnonymousObject = (MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this) != null))
          {
            if (!bu.lX(paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this)))
            {
              ae.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.filePath:%s filePath:%s", new Object[] { paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this) });
              AppMethodBeat.o(45415);
              return;
            }
            ae.i("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.action:%s", new Object[] { Integer.valueOf(paramAnonymousObject.action) });
            switch (paramAnonymousObject.action)
            {
            case 3: 
            default: 
              AppMethodBeat.o(45415);
              return;
            case 1: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).o(true, 2);
              AppMethodBeat.o(45415);
              return;
            case 2: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).o(false, 2);
              if (AppBrandTaskProxyUI.c(AppBrandTaskProxyUI.this))
              {
                MiniReaderLogic.a(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.h(AppBrandTaskProxyUI.this), true, AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this));
                AppMethodBeat.o(45415);
                return;
              }
              AppBrandTaskProxyUI.j(AppBrandTaskProxyUI.this);
              com.tencent.mm.cp.a.V(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this));
              MiniReaderLogic.a(false, false, AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.k(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.l(AppBrandTaskProxyUI.this));
              AppMethodBeat.o(45415);
              return;
            }
            p.c(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), new p.a()
            {
              public final void bF(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(222369);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(2131764447, new Object[] { com.tencent.mm.sdk.f.b.aSY(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(222369);
              }
              
              public final void bG(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(222370);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(2131764446), 1).show();
                AppMethodBeat.o(222370);
              }
            });
            AppMethodBeat.o(45415);
            return;
          }
          ae.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent fail");
        }
        AppMethodBeat.o(45415);
      }
    };
    AppMethodBeat.o(45416);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.filePath = paramString1;
    this.fXl = paramString2;
    this.token = paramString3;
    this.fileName = paramString4;
    this.showMenu = paramBoolean;
  }
  
  public final void biE()
  {
    AppMethodBeat.i(222371);
    ae.i("MicroMsg.AppBrandTaskProxyUI", "creatFilesFloatball() processName:%s", new Object[] { ak.getProcessName() });
    this.ksU = new com.tencent.mm.plugin.appbrand.floatball.b(new e(getContext()));
    this.ksU.a(this.filePath, this.fXl, this.appId, ak.getProcessName(), this.showMenu, this);
    com.tencent.mm.plugin.appbrand.floatball.b localb = this.ksU;
    Object localObject = this.fXl;
    String str = this.fileName;
    Integer localInteger = d.Xd((String)localObject);
    localObject = localInteger;
    if (localInteger == null) {
      localObject = d.Xd("unknown");
    }
    localb.nLK.mdM = ((Integer)localObject).intValue();
    localb.nLK.name = str;
    localb.bLz();
    MMToClientEvent.a(this.appId, this.kta);
    AppMethodBeat.o(222371);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45419);
    super.onDestroy();
    if (this.ksU != null)
    {
      this.ksU.onDestroy();
      com.tencent.mm.cp.a.V(this, this.token, this.filePath);
    }
    MMToClientEvent.b(this.appId, this.kta);
    AppMethodBeat.o(45419);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45418);
    super.onPause();
    if (this.ksU != null) {
      this.ksU.bhk();
    }
    AppMethodBeat.o(45418);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45417);
    super.onResume();
    if (this.ksU != null) {
      this.ksU.bhj();
    }
    AppMethodBeat.o(45417);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI
 * JD-Core Version:    0.7.0.1
 */