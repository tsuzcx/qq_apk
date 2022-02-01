package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.k.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.vfs.q;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.xweb.f.a;

final class OpenFileRequest$a
  extends AppBrandProxyUIProcessTask
{
  private static final int oSG;
  private String appId;
  private String fileName;
  private String filePath;
  private String jmx;
  private boolean oSH;
  private MiniReaderLogic.a<Integer> oSI;
  private boolean orn;
  private ValueCallback<String> orr;
  private String token;
  
  static
  {
    AppMethodBeat.i(174829);
    oSG = a.class.hashCode() & 0xFFFF;
    AppMethodBeat.o(174829);
  }
  
  OpenFileRequest$a()
  {
    AppMethodBeat.i(174804);
    this.appId = "";
    this.filePath = "";
    this.fileName = "";
    this.jmx = "";
    this.token = "";
    this.oSI = null;
    this.orr = new ValueCallback() {};
    AppMethodBeat.o(174804);
  }
  
  private void bSb()
  {
    AppMethodBeat.i(276185);
    if (bPl() != null)
    {
      bPl().appId = this.appId;
      bPl().a(this.filePath, this.jmx, this.token, this.fileName, this.orn);
      bPl().orr = this.orr;
      bPl().bPr();
      MiniReaderLogic.a(bPl().orm.faQ(), bPf(), this.filePath, this.fileName, this.jmx, this.token, this.orr, bSc(), this.appId, this.orn);
      AppMethodBeat.o(276185);
      return;
    }
    com.tencent.mm.xwebutil.a.a(bPf(), this.filePath, this.fileName, this.jmx, this.token, f.a.ZZK, this.orr, bSc(), this.orn);
    AppMethodBeat.o(276185);
  }
  
  private MiniReaderLogic.a<Integer> bSc()
  {
    AppMethodBeat.i(174807);
    if (this.oSI != null) {
      this.oSI.lqN = true;
    }
    this.oSI = new MiniReaderLogic.a() {};
    if (bPl() != null) {
      bPl().orq = this.oSI;
    }
    MiniReaderLogic.a locala = this.oSI;
    AppMethodBeat.o(174807);
    return locala;
  }
  
  private void dF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174805);
    paramString2 = MimeTypeUtil.getMimeTypeByFileExt(paramString2);
    OpenFileRequest.OpenResult localOpenResult = new OpenFileRequest.OpenResult();
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setPackage(null);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      FileProviderHelper.setIntentDataAndType(bPf(), (Intent)localObject, new q(paramString1), paramString2, false);
      ((Intent)localObject).addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      ((Intent)localObject).addFlags(524288);
      paramString1 = bPf();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString1, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localOpenResult.ret = 0;
      b(localOpenResult);
      AppMethodBeat.o(174805);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.OpenFileRequest", "start outer view with mime(%s), e = %s", new Object[] { paramString2, paramString1 });
        localOpenResult.ret = 2147483646;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174796);
            Toast.makeText(MMApplicationContext.getContext(), au.i.app_brand_jsapi_open_document_no_available_3rd_apps, 0).show();
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
    this.jmx = ((OpenFileRequest)paramProcessRequest).jmx;
    this.orn = ((OpenFileRequest)paramProcessRequest).orn;
    this.token = Integer.toString(bPf().hashCode());
    if (ChannelUtil.isGPVersion())
    {
      dF(this.filePath, this.jmx);
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
        Log.e("MicroMsg.AppBrand.OpenFileRequest", "get file name error " + paramProcessRequest.getMessage());
        paramProcessRequest = "";
        continue;
        int i = 0;
      }
    }
    paramProcessRequest = this.filePath;
    paramProcessRequest = paramProcessRequest.substring(i, paramProcessRequest.length());
    this.fileName = paramProcessRequest;
    this.oSH = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vEt, false);
    com.tencent.mm.xwebutil.a.ZaJ = new OpenFileRequest.a.2(this, TBSOneManager.getDefaultInstance(bPf()));
    bSb();
    AppMethodBeat.o(174806);
  }
  
  public final void bPm()
  {
    AppMethodBeat.i(174808);
    super.bPm();
    bPf().getWindow().setBackgroundDrawableResource(au.c.transparent);
    if (this.oSH) {
      aw.r(bPf(), this.token, this.filePath);
    }
    AppMethodBeat.o(174808);
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174809);
    if (oSG == paramInt1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a
 * JD-Core Version:    0.7.0.1
 */