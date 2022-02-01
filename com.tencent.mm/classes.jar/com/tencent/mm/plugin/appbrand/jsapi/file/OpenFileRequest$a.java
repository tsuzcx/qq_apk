package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.l.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.vfs.u;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.xweb.h.a;
import com.tencent.xweb.util.l;

final class OpenFileRequest$a
  extends AppBrandProxyUIProcessTask
{
  private static final int rXX;
  private String appId;
  private String fileName;
  private String filePath;
  private String lPJ;
  private boolean rXY;
  private MiniReaderLogic.a<Integer> rXZ;
  private boolean rvh;
  private ValueCallback<String> rvl;
  private String token;
  
  static
  {
    AppMethodBeat.i(174829);
    rXX = a.class.hashCode() & 0xFFFF;
    AppMethodBeat.o(174829);
  }
  
  OpenFileRequest$a()
  {
    AppMethodBeat.i(174804);
    this.appId = "";
    this.filePath = "";
    this.fileName = "";
    this.lPJ = "";
    this.token = "";
    this.rXZ = null;
    this.rvl = new ValueCallback() {};
    AppMethodBeat.o(174804);
  }
  
  private void csf()
  {
    AppMethodBeat.i(329081);
    if (getAppBrandTaskProxyUI() != null)
    {
      getAppBrandTaskProxyUI().appId = this.appId;
      getAppBrandTaskProxyUI().a(this.filePath, this.lPJ, this.token, this.fileName, this.rvh);
      getAppBrandTaskProxyUI().rvl = this.rvl;
      getAppBrandTaskProxyUI().cpy();
      MiniReaderLogic.a(getAppBrandTaskProxyUI().rvg.gjV(), getActivityContext(), this.filePath, this.fileName, this.lPJ, this.token, this.rvl, csg(), this.appId, this.rvh);
      AppMethodBeat.o(329081);
      return;
    }
    com.tencent.mm.xwebutil.a.a(getActivityContext(), this.filePath, this.fileName, this.lPJ, this.token, h.a.aiet, this.rvl, csg(), this.rvh);
    AppMethodBeat.o(329081);
  }
  
  private MiniReaderLogic.a<Integer> csg()
  {
    AppMethodBeat.i(174807);
    if (this.rXZ != null) {
      this.rXZ.nVY = true;
    }
    this.rXZ = new MiniReaderLogic.a() {};
    if (getAppBrandTaskProxyUI() != null) {
      getAppBrandTaskProxyUI().rvk = this.rXZ;
    }
    MiniReaderLogic.a locala = this.rXZ;
    AppMethodBeat.o(174807);
    return locala;
  }
  
  private void dY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174805);
    paramString2 = MimeTypeUtil.getMimeTypeByFileExt(paramString2);
    OpenFileRequest.OpenResult localOpenResult = new OpenFileRequest.OpenResult();
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setPackage(null);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      FileProviderHelper.setIntentDataAndType(getActivityContext(), (Intent)localObject, new u(paramString1), paramString2, false);
      ((Intent)localObject).addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      ((Intent)localObject).addFlags(524288);
      paramString1 = getActivityContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString1, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localOpenResult.ret = 0;
      finishProcess(localOpenResult);
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
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(174806);
    this.appId = ((OpenFileRequest)paramProcessRequest).appId;
    this.filePath = ((OpenFileRequest)paramProcessRequest).filePath;
    this.lPJ = ((OpenFileRequest)paramProcessRequest).lPJ;
    this.rvh = ((OpenFileRequest)paramProcessRequest).rvh;
    this.token = Integer.toString(getActivityContext().hashCode());
    if (ChannelUtil.isGPVersion())
    {
      dY(this.filePath, this.lPJ);
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
    this.rXY = ((c)h.ax(c.class)).a(c.a.yTI, false);
    com.tencent.mm.xwebutil.a.agZv = new OpenFileRequest.a.2(this, TBSOneManager.getDefaultInstance(getActivityContext()));
    csf();
    AppMethodBeat.o(174806);
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174809);
    if (rXX == paramInt1)
    {
      paramIntent = new OpenFileRequest.OpenResult();
      if (-1 == paramInt2) {}
      for (paramIntent.ret = 0;; paramIntent.ret = 2147483647)
      {
        finishProcess(paramIntent);
        AppMethodBeat.o(174809);
        return;
      }
    }
    finishProcess(null);
    AppMethodBeat.o(174809);
  }
  
  public final void onProcessInterrupted()
  {
    AppMethodBeat.i(174808);
    super.onProcessInterrupted();
    getActivityContext().getWindow().setBackgroundDrawableResource(ba.c.transparent);
    if (this.rXY) {
      ay.t(getActivityContext(), this.token, this.filePath);
    }
    AppMethodBeat.o(174808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a
 * JD-Core Version:    0.7.0.1
 */