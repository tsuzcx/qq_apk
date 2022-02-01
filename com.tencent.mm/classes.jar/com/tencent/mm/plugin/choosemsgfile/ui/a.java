package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private String kju = "";
  private String mFilePath = "";
  private int oTR = 0;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(123455);
    ad.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.kju = paramString2;
    this.oTR = paramInt;
    super.ac(4, b.Wq(paramString1));
    bKG().nGc = 4;
    bKG().nGb = this.oTR;
    bKC();
    if (this.nGj.ime != null)
    {
      this.nGj.ime.putBoolean("ifAppAttachDownloadUI", false);
      this.nGj.ime.putString("filePath", paramString1);
      this.nGj.ime.putString("fileExt", paramString2);
      this.nGj.ime.putInt("sence", paramInt);
      bKC();
    }
    AppMethodBeat.o(123455);
  }
  
  public final boolean bgA()
  {
    return true;
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(123453);
    ad.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgD();
    if ((this.nHb != null) && (this.nHb.getActivity() != null)) {
      this.nHb.getActivity().finish();
    }
    AppMethodBeat.o(123453);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(123454);
    ad.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgE();
    AppMethodBeat.o(123454);
  }
  
  public final boolean bgI()
  {
    return true;
  }
  
  public final boolean bgz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.a
 * JD-Core Version:    0.7.0.1
 */