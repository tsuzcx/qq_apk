package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent;
import com.tencent.mm.plugin.appbrand.floatball.b;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class AppBrandTaskProxyUI
  extends AppBrandProcessProxyUI
{
  public String appId;
  private String fileName;
  private String filePath;
  private String fyk;
  public b juV;
  private boolean juW;
  public boolean juX;
  public boolean juY;
  public ValueCallback<Integer> juZ;
  public ValueCallback<String> jva;
  private ValueCallback<Integer> jvb;
  private MMToClientEvent.c jvc;
  private String token;
  
  public AppBrandTaskProxyUI()
  {
    AppMethodBeat.i(45416);
    this.appId = "";
    this.filePath = "";
    this.fyk = "";
    this.token = "";
    this.fileName = "";
    this.juX = true;
    this.juY = false;
    this.juZ = null;
    this.jva = null;
    this.jvb = new AppBrandTaskProxyUI.1(this);
    this.jvc = new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45415);
        if ((paramAnonymousObject instanceof MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent))
        {
          paramAnonymousObject = (MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this) != null))
          {
            if (!bt.kU(paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this)))
            {
              ad.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.filePath:%s filePath:%s", new Object[] { paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this) });
              AppMethodBeat.o(45415);
              return;
            }
            ad.i("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.action:%s", new Object[] { Integer.valueOf(paramAnonymousObject.action) });
            switch (paramAnonymousObject.action)
            {
            default: 
              AppMethodBeat.o(45415);
              return;
            case 1: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).fE(true);
              AppMethodBeat.o(45415);
              return;
            }
            AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).fE(false);
            if (AppBrandTaskProxyUI.c(AppBrandTaskProxyUI.this))
            {
              MiniReaderLogic.a(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.h(AppBrandTaskProxyUI.this), true, AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this));
              AppMethodBeat.o(45415);
              return;
            }
            AppBrandTaskProxyUI.j(AppBrandTaskProxyUI.this);
            a.T(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this));
            MiniReaderLogic.a(false, false, AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.k(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.l(AppBrandTaskProxyUI.this));
            AppMethodBeat.o(45415);
            return;
          }
          ad.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent fail");
        }
        AppMethodBeat.o(45415);
      }
    };
    AppMethodBeat.o(45416);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.filePath = paramString1;
    this.fyk = paramString2;
    this.token = paramString3;
    this.fileName = paramString4;
    this.juW = paramBoolean;
  }
  
  public final void aXu()
  {
    AppMethodBeat.i(195781);
    ad.i("MicroMsg.AppBrandTaskProxyUI", "creatFilesFloatball() processName:%s", new Object[] { aj.getProcessName() });
    this.juV = new b(new e(getContext()));
    this.juV.a(this.filePath, this.fyk, this.appId, aj.getProcessName(), this.juW, this);
    b localb = this.juV;
    Object localObject = this.fyk;
    String str = this.fileName;
    Integer localInteger = d.OK((String)localObject);
    localObject = localInteger;
    if (localInteger == null) {
      localObject = d.OK("unknown");
    }
    localb.mDH.kYl = ((Integer)localObject).intValue();
    localb.mDH.name = str;
    localb.bzv();
    MMToClientEvent.a(this.appId, this.jvc);
    AppMethodBeat.o(195781);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45419);
    super.onDestroy();
    if (this.juV != null)
    {
      this.juV.onDestroy();
      a.T(this, this.token, this.filePath);
    }
    MMToClientEvent.b(this.appId, this.jvc);
    AppMethodBeat.o(45419);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45418);
    super.onPause();
    if (this.juV != null) {
      this.juV.aWa();
    }
    AppMethodBeat.o(45418);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45417);
    super.onResume();
    if (this.juV != null) {
      this.juV.aVZ();
    }
    AppMethodBeat.o(45417);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI
 * JD-Core Version:    0.7.0.1
 */