package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.h.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vfs.o;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.xweb.f.a;
import com.tencent.xweb.util.h;

final class OpenFileRequest$a
  extends AppBrandProxyUIProcessTask
{
  private static final int lVC;
  private String appId;
  private String fileName;
  private String filePath;
  private String gCr;
  private boolean lVD;
  private MiniReaderLogic.a<Integer> lVE;
  private boolean lwF;
  private ValueCallback<String> lwJ;
  private String token;
  
  static
  {
    AppMethodBeat.i(174829);
    lVC = a.class.hashCode() & 0xFFFF;
    AppMethodBeat.o(174829);
  }
  
  OpenFileRequest$a()
  {
    AppMethodBeat.i(174804);
    this.appId = "";
    this.filePath = "";
    this.fileName = "";
    this.gCr = "";
    this.token = "";
    this.lVE = null;
    this.lwJ = new ValueCallback() {};
    AppMethodBeat.o(174804);
  }
  
  private void bGp()
  {
    AppMethodBeat.i(226798);
    if (bDL() != null)
    {
      bDL().appId = this.appId;
      bDL().a(this.filePath, this.gCr, this.token, this.fileName, this.lwF);
      bDL().lwJ = this.lwJ;
      bDL().bDR();
      MiniReaderLogic.a(bDL().lwE.eqW(), bDF(), this.filePath, this.fileName, this.gCr, this.token, this.lwJ, bGq(), this.appId, this.lwF);
      AppMethodBeat.o(226798);
      return;
    }
    com.tencent.mm.cr.a.a(bDF(), this.filePath, this.fileName, this.gCr, this.token, f.a.SyT, this.lwJ, bGq(), this.lwF);
    AppMethodBeat.o(226798);
  }
  
  private MiniReaderLogic.a<Integer> bGq()
  {
    AppMethodBeat.i(174807);
    if (this.lVE != null) {
      this.lVE.iBj = true;
    }
    this.lVE = new MiniReaderLogic.a() {};
    if (bDL() != null) {
      bDL().lwI = this.lVE;
    }
    MiniReaderLogic.a locala = this.lVE;
    AppMethodBeat.o(174807);
    return locala;
  }
  
  private void dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174805);
    paramString2 = MimeTypeUtil.getMimeTypeByFileExt(paramString2);
    OpenFileRequest.OpenResult localOpenResult = new OpenFileRequest.OpenResult();
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setPackage(null);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      FileProviderHelper.setIntentDataAndType(bDF(), (Intent)localObject, new o(paramString1), paramString2, false);
      ((Intent)localObject).addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      ((Intent)localObject).addFlags(524288);
      paramString1 = bDF();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
        Log.e("MicroMsg.AppBrand.OpenFileRequest", "start outer view with mime(%s), e = %s", new Object[] { paramString2, paramString1 });
        localOpenResult.ret = 2147483646;
        MMHandlerThread.postToMainThread(new OpenFileRequest.a.1(this));
      }
    }
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(174806);
    this.appId = ((OpenFileRequest)paramProcessRequest).appId;
    this.filePath = ((OpenFileRequest)paramProcessRequest).filePath;
    this.gCr = ((OpenFileRequest)paramProcessRequest).gCr;
    this.lwF = ((OpenFileRequest)paramProcessRequest).lwF;
    this.token = Integer.toString(bDF().hashCode());
    if (ChannelUtil.isGPVersion())
    {
      dx(this.filePath, this.gCr);
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
    this.lVD = ((b)g.af(b.class)).a(b.a.rXB, false);
    com.tencent.mm.cr.a.Rzb = new OpenFileRequest.a.2(this, TBSOneManager.getDefaultInstance(bDF()));
    bGp();
    AppMethodBeat.o(174806);
  }
  
  public final void bDM()
  {
    AppMethodBeat.i(174808);
    super.bDM();
    bDF().getWindow().setBackgroundDrawableResource(2131101287);
    if (this.lVD) {
      au.o(bDF(), this.token, this.filePath);
    }
    AppMethodBeat.o(174808);
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174809);
    if (lVC == paramInt1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a
 * JD-Core Version:    0.7.0.1
 */