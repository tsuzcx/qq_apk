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
  private AppBrandTaskProxyUI kjt = null;
  private String kju = "";
  private String mFilePath = "";
  
  public b(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void a(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(174722);
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onCreate with exist ballInfo");
    this.nGj = paramBallInfo;
    bKC();
    AppMethodBeat.o(174722);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppBrandTaskProxyUI paramAppBrandTaskProxyUI)
  {
    AppMethodBeat.i(174721);
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.kju = paramString2;
    this.kjt = paramAppBrandTaskProxyUI;
    super.ac(4, com.tencent.mm.plugin.ball.f.b.Wq(paramString1));
    bKG().nGc = 4;
    bKG().nGb = 10;
    bKC();
    if (this.nGj.ime != null)
    {
      this.nGj.ime.putBoolean("ifAppAttachDownloadUI", false);
      this.nGj.ime.putString("filePath", paramString1);
      this.nGj.ime.putString("fileExt", paramString2);
      this.nGj.ime.putString("appId", paramString3);
      this.nGj.ime.putString("processName", paramString4);
      this.nGj.ime.putBoolean("showMenu", paramBoolean);
      this.nGj.ime.putInt("sence", 0);
      bKC();
    }
    AppMethodBeat.o(174721);
  }
  
  public final boolean bgA()
  {
    return true;
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(44959);
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgD();
    if ((this.nHb != null) && (this.nHb.getActivity() != null)) {
      this.nHb.getActivity().finish();
    }
    AppMethodBeat.o(44959);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(44960);
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgE();
    AppMethodBeat.o(44960);
  }
  
  public final boolean bgI()
  {
    return true;
  }
  
  public final boolean bgz()
  {
    return true;
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(44961);
    if (paramBoolean)
    {
      ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      iW(false);
      bKB();
      this.kjt.b(null);
      AppMethodBeat.o(44961);
      return;
    }
    ad.i("MicroMsg.AppBrandFilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    bKA();
    if (this.nHb.getActivity() != null)
    {
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174720);
          com.tencent.mm.ui.widget.snackbar.b.n(b.this.nHb.getActivity(), b.this.nHb.getActivity().getString(2131755252));
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