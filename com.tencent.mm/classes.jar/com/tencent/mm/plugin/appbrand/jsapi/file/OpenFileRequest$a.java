package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.xweb.f.a;

final class OpenFileRequest$a
  extends AppBrandProxyUIProcessTask
{
  private static final int krF;
  private String appId;
  private String fBR;
  private String fileName;
  private String filePath;
  private boolean jVr;
  private ValueCallback<String> jVv;
  private boolean krG;
  private MiniReaderLogic.a<Integer> krH;
  private String token;
  
  static
  {
    AppMethodBeat.i(174829);
    krF = a.class.hashCode() & 0xFFFF;
    AppMethodBeat.o(174829);
  }
  
  OpenFileRequest$a()
  {
    AppMethodBeat.i(174804);
    this.appId = "";
    this.filePath = "";
    this.fileName = "";
    this.fBR = "";
    this.token = "";
    this.krH = null;
    this.jVv = new ValueCallback() {};
    AppMethodBeat.o(174804);
  }
  
  private void bgD()
  {
    AppMethodBeat.i(186632);
    if (bel() != null)
    {
      bel().appId = this.appId;
      bel().a(this.filePath, this.fBR, this.token, this.fileName, this.jVr);
      bel().jVv = this.jVv;
      bel().ber();
      MiniReaderLogic.a(bel().jVq.bGo(), bef(), this.filePath, this.fileName, this.fBR, this.token, this.jVv, bgE(), true, this.appId, this.jVr);
      AppMethodBeat.o(186632);
      return;
    }
    com.tencent.mm.cq.a.a(bef(), this.filePath, this.fileName, this.fBR, this.token, f.a.KyM, this.jVv, bgE(), this.jVr);
    AppMethodBeat.o(186632);
  }
  
  private MiniReaderLogic.a<Integer> bgE()
  {
    AppMethodBeat.i(174807);
    if (this.krH != null) {
      this.krH.hlU = true;
    }
    this.krH = new MiniReaderLogic.a() {};
    if (bel() != null) {
      bel().jVu = this.krH;
    }
    MiniReaderLogic.a locala = this.krH;
    AppMethodBeat.o(174807);
    return locala;
  }
  
  private void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174805);
    paramString2 = d.aLW(paramString2);
    OpenFileRequest.OpenResult localOpenResult = new OpenFileRequest.OpenResult();
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setPackage(null);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      m.a(bef(), (Intent)localObject, new e(paramString1), paramString2);
      ((Intent)localObject).addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      ((Intent)localObject).addFlags(524288);
      paramString1 = bef();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
        ac.e("MicroMsg.AppBrand.OpenFileRequest", "start outer view with mime(%s), e = %s", new Object[] { paramString2, paramString1 });
        localOpenResult.ret = 2147483646;
        ap.f(new OpenFileRequest.a.1(this));
      }
    }
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(174806);
    this.appId = ((OpenFileRequest)paramProcessRequest).appId;
    this.filePath = ((OpenFileRequest)paramProcessRequest).filePath;
    this.fBR = ((OpenFileRequest)paramProcessRequest).fBR;
    this.jVr = ((OpenFileRequest)paramProcessRequest).jVr;
    this.token = Integer.toString(bef().hashCode());
    if (i.eUv())
    {
      dd(this.filePath, this.fBR);
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
        ac.e("MicroMsg.AppBrand.OpenFileRequest", "get file name error " + paramProcessRequest.getMessage());
        paramProcessRequest = "";
        continue;
        int i = 0;
      }
    }
    paramProcessRequest = this.filePath;
    paramProcessRequest = paramProcessRequest.substring(i, paramProcessRequest.length());
    this.fileName = paramProcessRequest;
    this.krG = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSK, false);
    com.tencent.mm.cq.a.JId = new OpenFileRequest.a.2(this, TBSOneManager.getDefaultInstance(bef()));
    bgD();
    AppMethodBeat.o(174806);
  }
  
  public final void bem()
  {
    AppMethodBeat.i(174808);
    super.bem();
    bef().getWindow().setBackgroundDrawableResource(2131101053);
    if (this.krG) {
      as.o(bef(), this.token, this.filePath);
    }
    AppMethodBeat.o(174808);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174809);
    if (krF == paramInt1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a
 * JD-Core Version:    0.7.0.1
 */