package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a
  extends c
{
  private String mFilePath;
  private asy tmK;
  private AppBrandTaskProxyUI tmL;
  private String tmM;
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(317599);
    this.tmK = new asy();
    this.tmL = null;
    this.mFilePath = "";
    this.tmM = "";
    AppMethodBeat.o(317599);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppBrandTaskProxyUI paramAppBrandTaskProxyUI)
  {
    AppMethodBeat.i(317619);
    Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.tmM = paramString2;
    this.tmL = paramAppBrandTaskProxyUI;
    super.J(4, b.ahY(paramString1));
    this.tmK.ZDd = false;
    this.tmK.filePath = paramString1;
    this.tmK.lPJ = paramString2;
    this.tmK.appId = paramString3;
    this.tmK.processName = paramString4;
    this.tmK.rvh = paramBoolean;
    this.tmK.wQW = 0;
    try
    {
      this.LCE.field_data = this.tmK.toByteArray();
      gjW();
      AppMethodBeat.o(317619);
      return;
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandFilesMultiTaskHelper", "handleMultiTaskInfoClicked", new Object[] { paramString1 });
      }
    }
  }
  
  public final void adR(String paramString)
  {
    AppMethodBeat.i(317622);
    Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "update processName: %s", new Object[] { paramString });
    if (this.tmK != null) {
      this.tmK.processName = paramString;
    }
    try
    {
      this.LCE.field_data = this.tmK.toByteArray();
      gjW();
      AppMethodBeat.o(317622);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandFilesMultiTaskHelper", "updateAppid", new Object[] { paramString });
      }
    }
  }
  
  public final boolean cBZ()
  {
    return true;
  }
  
  public final boolean cCa()
  {
    return true;
  }
  
  public final boolean cCb()
  {
    return false;
  }
  
  public final void kd(boolean paramBoolean)
  {
    AppMethodBeat.i(317615);
    if (paramBoolean)
    {
      Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "onMenuFloatBallSelected, enter float ball");
      c(null, true);
      this.tmL.finishProcess(null);
    }
    AppMethodBeat.o(317615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a
 * JD-Core Version:    0.7.0.1
 */