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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class AppBrandTaskProxyUI
  extends AppBrandProcessProxyUI
{
  public String appId;
  private String fVf;
  private String fileName;
  private String filePath;
  public com.tencent.mm.plugin.appbrand.floatball.b kpE;
  private boolean kpF;
  public boolean kpG;
  public boolean kpH;
  public ValueCallback<Integer> kpI;
  public ValueCallback<String> kpJ;
  private ValueCallback<Integer> kpK;
  private MMToClientEvent.c kpL;
  private String token;
  
  public AppBrandTaskProxyUI()
  {
    AppMethodBeat.i(45416);
    this.appId = "";
    this.filePath = "";
    this.fVf = "";
    this.token = "";
    this.fileName = "";
    this.kpG = true;
    this.kpH = false;
    this.kpI = null;
    this.kpJ = null;
    this.kpK = new AppBrandTaskProxyUI.1(this);
    this.kpL = new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45415);
        if ((paramAnonymousObject instanceof MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent))
        {
          paramAnonymousObject = (MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this) != null))
          {
            if (!bt.lQ(paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this)))
            {
              ad.e("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.filePath:%s filePath:%s", new Object[] { paramAnonymousObject.filePath, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this) });
              AppMethodBeat.o(45415);
              return;
            }
            ad.i("MicroMsg.AppBrandTaskProxyUI", "MiniQbFloatBallMenuActionEvent event.action:%s", new Object[] { Integer.valueOf(paramAnonymousObject.action) });
            switch (paramAnonymousObject.action)
            {
            case 3: 
            default: 
              AppMethodBeat.o(45415);
              return;
            case 1: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).gf(true);
              AppMethodBeat.o(45415);
              return;
            case 2: 
              AppBrandTaskProxyUI.a(AppBrandTaskProxyUI.this).gf(false);
              if (AppBrandTaskProxyUI.c(AppBrandTaskProxyUI.this))
              {
                MiniReaderLogic.a(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.h(AppBrandTaskProxyUI.this), true, AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this));
                AppMethodBeat.o(45415);
                return;
              }
              AppBrandTaskProxyUI.j(AppBrandTaskProxyUI.this);
              a.V(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this));
              MiniReaderLogic.a(false, false, AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.d(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.e(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.f(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.g(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.k(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.i(AppBrandTaskProxyUI.this), AppBrandTaskProxyUI.l(AppBrandTaskProxyUI.this));
              AppMethodBeat.o(45415);
              return;
            }
            p.c(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.b(AppBrandTaskProxyUI.this), new p.a()
            {
              public final void bF(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(188243);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(2131764447, new Object[] { com.tencent.mm.sdk.f.b.aRB(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(188243);
              }
              
              public final void bG(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(188244);
                Toast.makeText(AppBrandTaskProxyUI.this, AppBrandTaskProxyUI.this.getString(2131764446), 1).show();
                AppMethodBeat.o(188244);
              }
            });
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
    this.fVf = paramString2;
    this.token = paramString3;
    this.fileName = paramString4;
    this.kpF = paramBoolean;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(188245);
    ad.i("MicroMsg.AppBrandTaskProxyUI", "creatFilesFloatball() processName:%s", new Object[] { aj.getProcessName() });
    this.kpE = new com.tencent.mm.plugin.appbrand.floatball.b(new e(getContext()));
    this.kpE.a(this.filePath, this.fVf, this.appId, aj.getProcessName(), this.kpF, this);
    com.tencent.mm.plugin.appbrand.floatball.b localb = this.kpE;
    Object localObject = this.fVf;
    String str = this.fileName;
    Integer localInteger = d.Wr((String)localObject);
    localObject = localInteger;
    if (localInteger == null) {
      localObject = d.Wr("unknown");
    }
    localb.nGj.lZt = ((Integer)localObject).intValue();
    localb.nGj.name = str;
    localb.bKC();
    MMToClientEvent.a(this.appId, this.kpL);
    AppMethodBeat.o(188245);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45419);
    super.onDestroy();
    if (this.kpE != null)
    {
      this.kpE.onDestroy();
      a.V(this, this.token, this.filePath);
    }
    MMToClientEvent.b(this.appId, this.kpL);
    AppMethodBeat.o(45419);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45418);
    super.onPause();
    if (this.kpE != null) {
      this.kpE.bgC();
    }
    AppMethodBeat.o(45418);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45417);
    super.onResume();
    if (this.kpE != null) {
      this.kpE.bgB();
    }
    AppMethodBeat.o(45417);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI
 * JD-Core Version:    0.7.0.1
 */