package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private String kmK = "";
  private String mFilePath = "";
  private int pat = 0;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(123455);
    ae.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.kmK = paramString2;
    this.pat = paramInt;
    super.ac(4, b.Xc(paramString1));
    bLD().nLC = 4;
    bLD().nLB = this.pat;
    bLz();
    if (this.nLK.ioY != null)
    {
      this.nLK.ioY.putBoolean("ifAppAttachDownloadUI", false);
      this.nLK.ioY.putString("filePath", paramString1);
      this.nLK.ioY.putString("fileExt", paramString2);
      this.nLK.ioY.putInt("sence", paramInt);
      bLz();
    }
    AppMethodBeat.o(123455);
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
    AppMethodBeat.i(123453);
    ae.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhl();
    if ((this.nME != null) && (this.nME.getActivity() != null)) {
      this.nME.getActivity().finish();
    }
    AppMethodBeat.o(123453);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(123454);
    ae.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhm();
    AppMethodBeat.o(123454);
  }
  
  public final boolean bhq()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.a
 * JD-Core Version:    0.7.0.1
 */