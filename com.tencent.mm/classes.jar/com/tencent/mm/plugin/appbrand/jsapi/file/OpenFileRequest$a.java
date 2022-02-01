package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vfs.e;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.xweb.f.a;

final class OpenFileRequest$a
  extends AppBrandProxyUIProcessTask
{
  private static final int kNb;
  private String appId;
  private String fVf;
  private String fileName;
  private String filePath;
  private boolean kNc;
  private MiniReaderLogic.a<Integer> kNd;
  private boolean kpF;
  private ValueCallback<String> kpJ;
  private String token;
  
  static
  {
    AppMethodBeat.i(174829);
    kNb = a.class.hashCode() & 0xFFFF;
    AppMethodBeat.o(174829);
  }
  
  OpenFileRequest$a()
  {
    AppMethodBeat.i(174804);
    this.appId = "";
    this.filePath = "";
    this.fileName = "";
    this.fVf = "";
    this.token = "";
    this.kNd = null;
    this.kpJ = new ValueCallback() {};
    AppMethodBeat.o(174804);
  }
  
  private void bki()
  {
    AppMethodBeat.i(188365);
    if (bhP() != null)
    {
      bhP().appId = this.appId;
      bhP().a(this.filePath, this.fVf, this.token, this.fileName, this.kpF);
      bhP().kpJ = this.kpJ;
      bhP().bhV();
      MiniReaderLogic.a(bhP().kpE.bKz(), bhJ(), this.filePath, this.fileName, this.fVf, this.token, this.kpJ, bkj(), true, this.appId, this.kpF);
      AppMethodBeat.o(188365);
      return;
    }
    com.tencent.mm.cq.a.a(bhJ(), this.filePath, this.fileName, this.fVf, this.token, f.a.Mpi, this.kpJ, bkj(), this.kpF);
    AppMethodBeat.o(188365);
  }
  
  private MiniReaderLogic.a<Integer> bkj()
  {
    AppMethodBeat.i(174807);
    if (this.kNd != null) {
      this.kNd.hEh = true;
    }
    this.kNd = new MiniReaderLogic.a() {};
    if (bhP() != null) {
      bhP().kpI = this.kNd;
    }
    MiniReaderLogic.a locala = this.kNd;
    AppMethodBeat.o(174807);
    return locala;
  }
  
  private void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174805);
    paramString2 = d.aRD(paramString2);
    OpenFileRequest.OpenResult localOpenResult = new OpenFileRequest.OpenResult();
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setPackage(null);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      n.a(bhJ(), (Intent)localObject, new e(paramString1), paramString2);
      ((Intent)localObject).addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      ((Intent)localObject).addFlags(524288);
      paramString1 = bhJ();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
        aq.f(new OpenFileRequest.a.1(this));
      }
    }
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(174806);
    this.appId = ((OpenFileRequest)paramProcessRequest).appId;
    this.filePath = ((OpenFileRequest)paramProcessRequest).filePath;
    this.fVf = ((OpenFileRequest)paramProcessRequest).fVf;
    this.kpF = ((OpenFileRequest)paramProcessRequest).kpF;
    this.token = Integer.toString(bhJ().hashCode());
    if (j.fjZ())
    {
      dg(this.filePath, this.fVf);
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
    this.kNc = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxo, false);
    com.tencent.mm.cq.a.LBG = new OpenFileRequest.a.2(this, TBSOneManager.getDefaultInstance(bhJ()));
    bki();
    AppMethodBeat.o(174806);
  }
  
  public final void bhQ()
  {
    AppMethodBeat.i(174808);
    super.bhQ();
    bhJ().getWindow().setBackgroundDrawableResource(2131101053);
    if (this.kNc) {
      as.p(bhJ(), this.token, this.filePath);
    }
    AppMethodBeat.o(174808);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174809);
    if (kNb == paramInt1)
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