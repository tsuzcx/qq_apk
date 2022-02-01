package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.xweb.f.a;
import java.util.HashMap;

final class OpenFileRequest$a
  extends AppBrandProxyUIProcessTask
{
  private static final int kQy;
  private String appId;
  private String fXl;
  private String fileName;
  private String filePath;
  private MiniReaderLogic.a<Integer> kQA;
  private boolean kQz;
  private ValueCallback<String> ksY;
  private boolean showMenu;
  private String token;
  
  static
  {
    AppMethodBeat.i(174829);
    kQy = a.class.hashCode() & 0xFFFF;
    AppMethodBeat.o(174829);
  }
  
  OpenFileRequest$a()
  {
    AppMethodBeat.i(174804);
    this.appId = "";
    this.filePath = "";
    this.fileName = "";
    this.fXl = "";
    this.token = "";
    this.kQA = null;
    this.ksY = new ValueCallback() {};
    AppMethodBeat.o(174804);
  }
  
  private void bkR()
  {
    AppMethodBeat.i(222492);
    if (biy() != null)
    {
      biy().appId = this.appId;
      biy().a(this.filePath, this.fXl, this.token, this.fileName, this.showMenu);
      biy().ksY = this.ksY;
      biy().biE();
      MiniReaderLogic.a(biy().ksU.bLw(), bis(), this.filePath, this.fileName, this.fXl, this.token, this.ksY, bkS(), true, this.appId, this.showMenu);
      AppMethodBeat.o(222492);
      return;
    }
    com.tencent.mm.cp.a.a(bis(), this.filePath, this.fileName, this.fXl, this.token, f.a.MMe, this.ksY, bkS(), this.showMenu);
    AppMethodBeat.o(222492);
  }
  
  private MiniReaderLogic.a<Integer> bkS()
  {
    AppMethodBeat.i(174807);
    if (this.kQA != null) {
      this.kQA.hGZ = true;
    }
    this.kQA = new MiniReaderLogic.a() {};
    if (biy() != null) {
      biy().ksX = this.kQA;
    }
    MiniReaderLogic.a locala = this.kQA;
    AppMethodBeat.o(174807);
    return locala;
  }
  
  private void di(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174805);
    paramString2 = com.tencent.mm.sdk.f.d.aTa(paramString2);
    OpenFileRequest.OpenResult localOpenResult = new OpenFileRequest.OpenResult();
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setPackage(null);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      o.a(bis(), (Intent)localObject, new com.tencent.mm.vfs.k(paramString1), paramString2);
      ((Intent)localObject).addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      ((Intent)localObject).addFlags(524288);
      paramString1 = bis();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localOpenResult.ret = 0;
      b(localOpenResult);
      AppMethodBeat.o(174805);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.OpenFileRequest", "start outer view with mime(%s), e = %s", new Object[] { paramString2, paramString1 });
        localOpenResult.ret = 2147483646;
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174796);
            Toast.makeText(ak.getContext(), 2131755483, 0).show();
            AppMethodBeat.o(174796);
          }
        });
      }
    }
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(174806);
    this.appId = ((OpenFileRequest)paramProcessRequest).appId;
    this.filePath = ((OpenFileRequest)paramProcessRequest).filePath;
    this.fXl = ((OpenFileRequest)paramProcessRequest).fXl;
    this.showMenu = ((OpenFileRequest)paramProcessRequest).showMenu;
    this.token = Integer.toString(bis().hashCode());
    if (com.tencent.mm.sdk.platformtools.k.fnT())
    {
      di(this.filePath, this.fXl);
      AppMethodBeat.o(174806);
      return;
    }
    try
    {
      int j = this.filePath.lastIndexOf('/') + 1;
      if (j < 0) {
        break label225;
      }
      i = j;
      if (j != this.filePath.length()) {}
    }
    catch (Exception paramProcessRequest)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.OpenFileRequest", "get file name error " + paramProcessRequest.getMessage());
        paramProcessRequest = "";
        continue;
        int i = 0;
      }
    }
    paramProcessRequest = this.filePath;
    paramProcessRequest = paramProcessRequest.substring(i, paramProcessRequest.length());
    this.fileName = paramProcessRequest;
    this.kQz = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEu, false);
    com.tencent.mm.cp.a.LYJ = new a.a()
    {
      public final boolean bkZ()
      {
        AppMethodBeat.i(222479);
        boolean bool = OpenFileRequest.a.a(OpenFileRequest.a.this);
        AppMethodBeat.o(222479);
        return bool;
      }
      
      public final boolean bla()
      {
        AppMethodBeat.i(222480);
        if (!this.kQC.isComponentInstalled("file")) {}
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.AppBrand.OpenFileRequest", "needDownloadMiniQB: %b", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(222480);
          return bool;
        }
      }
      
      public final void blb()
      {
        AppMethodBeat.i(222481);
        MMActivity localMMActivity = OpenFileRequest.a.b(OpenFileRequest.a.this);
        if (localMMActivity == null)
        {
          ae.w("MicroMsg.AppBrand.OpenFileRequest", "get context return null");
          AppMethodBeat.o(222481);
          return;
        }
        OpenFileRequest.a.a(OpenFileRequest.a.this, localMMActivity, this.kQC);
        AppMethodBeat.o(222481);
      }
      
      public final void d(int paramAnonymousInt, Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean, HashMap<String, String> paramAnonymousHashMap, ValueCallback<String> paramAnonymousValueCallback, ValueCallback<Integer> paramAnonymousValueCallback1)
      {
        AppMethodBeat.i(222482);
        au.a(paramAnonymousInt, paramAnonymousContext, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean, paramAnonymousHashMap, paramAnonymousValueCallback, paramAnonymousValueCallback1);
        AppMethodBeat.o(222482);
      }
      
      public final void s(Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(222483);
        au.p(paramAnonymousContext, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(222483);
      }
    };
    bkR();
    AppMethodBeat.o(174806);
  }
  
  public final void biz()
  {
    AppMethodBeat.i(174808);
    super.biz();
    bis().getWindow().setBackgroundDrawableResource(2131101053);
    if (this.kQz) {
      au.p(bis(), this.token, this.filePath);
    }
    AppMethodBeat.o(174808);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174809);
    if (kQy == paramInt1)
    {
      paramIntent = new OpenFileRequest.OpenResult();
      if (-1 == paramInt2) {}
      for (paramIntent.ret = 0;; paramIntent.ret = 2147483647)
      {
        b(paramIntent);
        AppMethodBeat.o(174809);
        return;
      }
    }
    b(null);
    AppMethodBeat.o(174809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a
 * JD-Core Version:    0.7.0.1
 */