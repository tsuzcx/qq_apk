package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  private AppBrandTaskProxyUI jPi = null;
  private String jPj = "";
  private String mFilePath = "";
  
  public b(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void a(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(174722);
    ac.i("MicroMsg.AppBrandFilesFloatBallHelper", "onCreate with exist ballInfo");
    this.nfN = paramBallInfo;
    bGr();
    AppMethodBeat.o(174722);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppBrandTaskProxyUI paramAppBrandTaskProxyUI)
  {
    AppMethodBeat.i(174721);
    ac.i("MicroMsg.AppBrandFilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.jPj = paramString2;
    this.jPi = paramAppBrandTaskProxyUI;
    super.aa(4, com.tencent.mm.plugin.ball.f.b.ST(paramString1));
    bGv().nfG = 4;
    bGv().nfF = 10;
    bGr();
    if (this.nfN.hSN != null)
    {
      this.nfN.hSN.putBoolean("ifAppAttachDownloadUI", false);
      this.nfN.hSN.putString("filePath", paramString1);
      this.nfN.hSN.putString("fileExt", paramString2);
      this.nfN.hSN.putString("appId", paramString3);
      this.nfN.hSN.putString("processName", paramString4);
      this.nfN.hSN.putBoolean("showMenu", paramBoolean);
      this.nfN.hSN.putInt("sence", 0);
      bGr();
    }
    AppMethodBeat.o(174721);
  }
  
  public final boolean bcV()
  {
    return true;
  }
  
  public final boolean bcW()
  {
    return true;
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(44959);
    ac.i("MicroMsg.AppBrandFilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bcZ();
    if ((this.ngF != null) && (this.ngF.getActivity() != null)) {
      this.ngF.getActivity().finish();
    }
    AppMethodBeat.o(44959);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(44960);
    ac.i("MicroMsg.AppBrandFilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bda();
    AppMethodBeat.o(44960);
  }
  
  public final boolean bde()
  {
    return true;
  }
  
  public final void ga(boolean paramBoolean)
  {
    AppMethodBeat.i(44961);
    if (paramBoolean)
    {
      ac.i("MicroMsg.AppBrandFilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      iN(false);
      bGq();
      this.jPi.b(null);
      AppMethodBeat.o(44961);
      return;
    }
    ac.i("MicroMsg.AppBrandFilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    bGp();
    if (this.ngF.getActivity() != null)
    {
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174720);
          com.tencent.mm.ui.widget.snackbar.b.n(b.this.ngF.getActivity(), b.this.ngF.getActivity().getString(2131755252));
          AppMethodBeat.o(174720);
        }
      };
      if (ap.isMainThread())
      {
        local1.run();
        AppMethodBeat.o(44961);
        return;
      }
      ap.f(local1);
    }
    AppMethodBeat.o(44961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.b
 * JD-Core Version:    0.7.0.1
 */