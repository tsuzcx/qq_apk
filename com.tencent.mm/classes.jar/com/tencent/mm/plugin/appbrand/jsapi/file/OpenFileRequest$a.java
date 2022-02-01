package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.a;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.xweb.f.a;
import java.util.HashMap;

final class OpenFileRequest$a
  extends AppBrandProxyUIProcessTask
{
  private static final int jQU;
  private String appId;
  private String fileName;
  private String filePath;
  private String fyk;
  private boolean jQV;
  private MiniReaderLogic.a<Integer> jQW;
  private boolean juW;
  private ValueCallback<String> jva;
  private String token;
  
  static
  {
    AppMethodBeat.i(174829);
    jQU = a.class.hashCode() & 0xFFFF;
    AppMethodBeat.o(174829);
  }
  
  OpenFileRequest$a()
  {
    AppMethodBeat.i(174804);
    this.appId = "";
    this.filePath = "";
    this.fileName = "";
    this.fyk = "";
    this.token = "";
    this.jQW = null;
    this.jva = new ValueCallback() {};
    AppMethodBeat.o(174804);
  }
  
  private void aZL()
  {
    AppMethodBeat.i(195864);
    if (aXo() != null)
    {
      aXo().appId = this.appId;
      aXo().a(this.filePath, this.fyk, this.token, this.fileName, this.juW);
      aXo().jva = this.jva;
      aXo().aXu();
      MiniReaderLogic.a(aXo().juV.bzs(), aXi(), this.filePath, this.fileName, this.fyk, this.token, this.jva, aZM(), true, this.appId, this.juW);
      AppMethodBeat.o(195864);
      return;
    }
    com.tencent.mm.cr.a.a(aXi(), this.filePath, this.fileName, this.fyk, this.token, f.a.IMt, this.jva, aZM(), this.juW);
    AppMethodBeat.o(195864);
  }
  
  private MiniReaderLogic.a<Integer> aZM()
  {
    AppMethodBeat.i(174807);
    if (this.jQW != null) {
      this.jQW.gLu = true;
    }
    this.jQW = new MiniReaderLogic.a() {};
    if (aXo() != null) {
      aXo().juZ = this.jQW;
    }
    MiniReaderLogic.a locala = this.jQW;
    AppMethodBeat.o(174807);
    return locala;
  }
  
  private void cS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174805);
    paramString2 = com.tencent.mm.sdk.f.d.aGE(paramString2);
    OpenFileRequest.OpenResult localOpenResult = new OpenFileRequest.OpenResult();
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setPackage(null);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      m.a(aXi(), (Intent)localObject, new e(paramString1), paramString2);
      ((Intent)localObject).addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      ((Intent)localObject).addFlags(524288);
      paramString1 = aXi();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
        ad.e("MicroMsg.AppBrand.OpenFileRequest", "start outer view with mime(%s), e = %s", new Object[] { paramString2, paramString1 });
        localOpenResult.ret = 2147483646;
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174796);
            Toast.makeText(aj.getContext(), 2131755483, 0).show();
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
    this.fyk = ((OpenFileRequest)paramProcessRequest).fyk;
    this.juW = ((OpenFileRequest)paramProcessRequest).juW;
    this.token = Integer.toString(aXi().hashCode());
    if (i.eFb())
    {
      cS(this.filePath, this.fyk);
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
        ad.e("MicroMsg.AppBrand.OpenFileRequest", "get file name error " + paramProcessRequest.getMessage());
        paramProcessRequest = "";
        continue;
        int i = 0;
      }
    }
    paramProcessRequest = this.filePath;
    paramProcessRequest = paramProcessRequest.substring(i, paramProcessRequest.length());
    this.fileName = paramProcessRequest;
    this.jQV = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poZ, false);
    com.tencent.mm.cr.a.Igy = new a.a()
    {
      public final boolean aZS()
      {
        AppMethodBeat.i(195853);
        boolean bool = OpenFileRequest.a.a(OpenFileRequest.a.this);
        AppMethodBeat.o(195853);
        return bool;
      }
      
      public final boolean aZT()
      {
        AppMethodBeat.i(195854);
        if (!this.jQY.isComponentInstalled("file")) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.AppBrand.OpenFileRequest", "needDownloadMiniQB: %b", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(195854);
          return bool;
        }
      }
      
      public final void aZU()
      {
        AppMethodBeat.i(195855);
        MMActivity localMMActivity = OpenFileRequest.a.b(OpenFileRequest.a.this);
        if (localMMActivity == null)
        {
          ad.w("MicroMsg.AppBrand.OpenFileRequest", "get context return null");
          AppMethodBeat.o(195855);
          return;
        }
        OpenFileRequest.a.a(OpenFileRequest.a.this, localMMActivity, this.jQY);
        AppMethodBeat.o(195855);
      }
      
      public final void d(int paramAnonymousInt, Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean, HashMap<String, String> paramAnonymousHashMap, ValueCallback<String> paramAnonymousValueCallback, ValueCallback<Integer> paramAnonymousValueCallback1)
      {
        AppMethodBeat.i(195856);
        as.a(paramAnonymousInt, paramAnonymousContext, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean, paramAnonymousHashMap, paramAnonymousValueCallback, paramAnonymousValueCallback1);
        AppMethodBeat.o(195856);
      }
      
      public final void r(Context paramAnonymousContext, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(195857);
        as.o(paramAnonymousContext, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(195857);
      }
    };
    aZL();
    AppMethodBeat.o(174806);
  }
  
  public final void aXp()
  {
    AppMethodBeat.i(174808);
    super.aXp();
    aXi().getWindow().setBackgroundDrawableResource(2131101053);
    as.o(aXi(), this.token, this.filePath);
    AppMethodBeat.o(174808);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174809);
    if (jQU == paramInt1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a
 * JD-Core Version:    0.7.0.1
 */