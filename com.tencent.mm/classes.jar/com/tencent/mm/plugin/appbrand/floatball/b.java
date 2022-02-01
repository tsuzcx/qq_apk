package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  private AppBrandTaskProxyUI kmJ = null;
  private String kmK = "";
  private String mFilePath = "";
  
  public b(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void a(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(174722);
    ae.i("MicroMsg.AppBrandFilesFloatBallHelper", "onCreate with exist ballInfo");
    this.nLK = paramBallInfo;
    bLz();
    AppMethodBeat.o(174722);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppBrandTaskProxyUI paramAppBrandTaskProxyUI)
  {
    AppMethodBeat.i(174721);
    ae.i("MicroMsg.AppBrandFilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.kmK = paramString2;
    this.kmJ = paramAppBrandTaskProxyUI;
    super.ac(4, com.tencent.mm.plugin.ball.f.b.Xc(paramString1));
    bLD().nLC = 4;
    bLD().nLB = 10;
    bLz();
    if (this.nLK.ioY != null)
    {
      this.nLK.ioY.putBoolean("ifAppAttachDownloadUI", false);
      this.nLK.ioY.putString("filePath", paramString1);
      this.nLK.ioY.putString("fileExt", paramString2);
      this.nLK.ioY.putString("appId", paramString3);
      this.nLK.ioY.putString("processName", paramString4);
      this.nLK.ioY.putBoolean("showMenu", paramBoolean);
      this.nLK.ioY.putInt("sence", 0);
      bLz();
    }
    AppMethodBeat.o(174721);
  }
  
  public final boolean bhh()
  {
    return true;
  }
  
  public final boolean bhi()
  {
    return true;
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(44959);
    ae.i("MicroMsg.AppBrandFilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhl();
    if ((this.nME != null) && (this.nME.getActivity() != null)) {
      this.nME.getActivity().finish();
    }
    AppMethodBeat.o(44959);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(44960);
    ae.i("MicroMsg.AppBrandFilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhm();
    AppMethodBeat.o(44960);
  }
  
  public final boolean bhq()
  {
    return true;
  }
  
  public final void o(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(222267);
    if (paramBoolean)
    {
      ae.i("MicroMsg.AppBrandFilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      iV(false);
      bLy();
      this.kmJ.b(null);
      AppMethodBeat.o(222267);
      return;
    }
    ae.i("MicroMsg.AppBrandFilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    bLx();
    if (this.nME.getActivity() != null)
    {
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174720);
          com.tencent.mm.ui.widget.snackbar.b.n(b.this.nME.getActivity(), b.this.nME.getActivity().getString(2131755252));
          AppMethodBeat.o(174720);
        }
      };
      if (ar.isMainThread())
      {
        local1.run();
        AppMethodBeat.o(222267);
        return;
      }
      ar.f(local1);
    }
    AppMethodBeat.o(222267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.b
 * JD-Core Version:    0.7.0.1
 */