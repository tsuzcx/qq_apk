package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  private AppBrandTaskProxyUI joW = null;
  private String joX = "";
  private String mFilePath = "";
  
  public b(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void a(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(174722);
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onCreate with exist ballInfo");
    this.mDH = paramBallInfo;
    bzv();
    AppMethodBeat.o(174722);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppBrandTaskProxyUI paramAppBrandTaskProxyUI)
  {
    AppMethodBeat.i(174721);
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.joX = paramString2;
    this.joW = paramAppBrandTaskProxyUI;
    super.Z(4, com.tencent.mm.plugin.ball.f.b.OJ(paramString1));
    bzz().mDz = 4;
    bzz().mDy = 10;
    bzv();
    if (this.mDH.hsl != null)
    {
      this.mDH.hsl.putBoolean("ifAppAttachDownloadUI", false);
      this.mDH.hsl.putString("filePath", paramString1);
      this.mDH.hsl.putString("fileExt", paramString2);
      this.mDH.hsl.putString("appId", paramString3);
      this.mDH.hsl.putString("processName", paramString4);
      this.mDH.hsl.putBoolean("showMenu", paramBoolean);
      this.mDH.hsl.putInt("sence", 0);
      bzv();
    }
    AppMethodBeat.o(174721);
  }
  
  public final boolean aVX()
  {
    return true;
  }
  
  public final boolean aVY()
  {
    return true;
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(44959);
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWb();
    if ((this.mEA != null) && (this.mEA.getActivity() != null)) {
      this.mEA.getActivity().finish();
    }
    AppMethodBeat.o(44959);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(44960);
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWc();
    AppMethodBeat.o(44960);
  }
  
  public final boolean aWg()
  {
    return true;
  }
  
  public final void fE(boolean paramBoolean)
  {
    AppMethodBeat.i(44961);
    if (paramBoolean)
    {
      ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      in(false);
      bzu();
      this.joW.b(null);
      AppMethodBeat.o(44961);
      return;
    }
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    bzt();
    if (this.mEA.getActivity() != null)
    {
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174720);
          com.tencent.mm.ui.widget.snackbar.b.n(b.this.mEA.getActivity(), b.this.mEA.getActivity().getString(2131755252));
          AppMethodBeat.o(174720);
        }
      };
      if (aq.isMainThread())
      {
        local1.run();
        AppMethodBeat.o(44961);
        return;
      }
      aq.f(local1);
    }
    AppMethodBeat.o(44961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.b
 * JD-Core Version:    0.7.0.1
 */