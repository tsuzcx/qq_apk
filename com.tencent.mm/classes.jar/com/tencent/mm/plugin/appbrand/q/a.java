package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a
  extends c
{
  private String mFilePath;
  private aoe nhp;
  private AppBrandTaskProxyUI nhq;
  private String nhr;
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(227199);
    this.nhp = new aoe();
    this.nhq = null;
    this.mFilePath = "";
    this.nhr = "";
    AppMethodBeat.o(227199);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppBrandTaskProxyUI paramAppBrandTaskProxyUI)
  {
    AppMethodBeat.i(227201);
    Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.nhr = paramString2;
    this.nhq = paramAppBrandTaskProxyUI;
    super.G(4, b.agW(paramString1));
    this.nhp.LzL = false;
    this.nhp.filePath = paramString1;
    this.nhp.gCr = paramString2;
    this.nhp.appId = paramString3;
    this.nhp.processName = paramString4;
    this.nhp.lwF = paramBoolean;
    this.nhp.qoX = 0;
    try
    {
      this.Abp.field_data = this.nhp.toByteArray();
      eqX();
      AppMethodBeat.o(227201);
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
  
  public final void acQ(String paramString)
  {
    AppMethodBeat.i(227202);
    Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "update processName: %s", new Object[] { paramString });
    if (this.nhp != null) {
      this.nhp.processName = paramString;
    }
    try
    {
      this.Abp.field_data = this.nhp.toByteArray();
      eqX();
      AppMethodBeat.o(227202);
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
  
  public final boolean bPp()
  {
    return true;
  }
  
  public final boolean bPq()
  {
    return true;
  }
  
  public final boolean bPr()
  {
    return false;
  }
  
  public final void ib(boolean paramBoolean)
  {
    AppMethodBeat.i(227200);
    if (paramBoolean)
    {
      Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "onMenuFloatBallSelected, enter float ball");
      b(null, true);
      this.nhq.b(null);
    }
    AppMethodBeat.o(227200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a
 * JD-Core Version:    0.7.0.1
 */