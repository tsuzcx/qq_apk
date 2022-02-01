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
  private String joX = "";
  private String mFilePath = "";
  private int nNu = 0;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void H(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(123455);
    ad.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.joX = paramString2;
    this.nNu = paramInt;
    super.Z(4, b.OJ(paramString1));
    bzz().mDz = 4;
    bzz().mDy = this.nNu;
    bzv();
    if (this.mDH.hsl != null)
    {
      this.mDH.hsl.putBoolean("ifAppAttachDownloadUI", false);
      this.mDH.hsl.putString("filePath", paramString1);
      this.mDH.hsl.putString("fileExt", paramString2);
      this.mDH.hsl.putInt("sence", paramInt);
      bzv();
    }
    AppMethodBeat.o(123455);
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
    AppMethodBeat.i(123453);
    ad.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWb();
    if ((this.mEA != null) && (this.mEA.getActivity() != null)) {
      this.mEA.getActivity().finish();
    }
    AppMethodBeat.o(123453);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(123454);
    ad.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWc();
    AppMethodBeat.o(123454);
  }
  
  public final boolean aWg()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.a
 * JD-Core Version:    0.7.0.1
 */