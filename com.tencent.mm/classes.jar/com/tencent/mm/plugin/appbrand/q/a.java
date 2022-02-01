package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a
  extends c
{
  private String mFilePath;
  private apf qhY;
  private AppBrandTaskProxyUI qhZ;
  private String qia;
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(273009);
    this.qhY = new apf();
    this.qhZ = null;
    this.mFilePath = "";
    this.qia = "";
    AppMethodBeat.o(273009);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppBrandTaskProxyUI paramAppBrandTaskProxyUI)
  {
    AppMethodBeat.i(273011);
    Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.qia = paramString2;
    this.qhZ = paramAppBrandTaskProxyUI;
    super.I(4, b.aoC(paramString1));
    this.qhY.SCl = false;
    this.qhY.filePath = paramString1;
    this.qhY.jmx = paramString2;
    this.qhY.appId = paramString3;
    this.qhY.processName = paramString4;
    this.qhY.orn = paramBoolean;
    this.qhY.tNG = 0;
    try
    {
      this.FHd.field_data = this.qhY.toByteArray();
      faR();
      AppMethodBeat.o(273011);
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
  
  public final void akK(String paramString)
  {
    AppMethodBeat.i(273012);
    Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "update processName: %s", new Object[] { paramString });
    if (this.qhY != null) {
      this.qhY.processName = paramString;
    }
    try
    {
      this.FHd.field_data = this.qhY.toByteArray();
      faR();
      AppMethodBeat.o(273012);
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
  
  public final boolean cbG()
  {
    return true;
  }
  
  public final boolean cbH()
  {
    return true;
  }
  
  public final boolean cbI()
  {
    return false;
  }
  
  public final void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(273010);
    if (paramBoolean)
    {
      Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "onMenuFloatBallSelected, enter float ball");
      b(null, true);
      this.qhZ.b(null);
    }
    AppMethodBeat.o(273010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a
 * JD-Core Version:    0.7.0.1
 */