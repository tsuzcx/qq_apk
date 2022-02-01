package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends e
{
  private String mFilePath = "";
  private String qia = "";
  private int tOb = 0;
  
  public a(f paramf)
  {
    super(paramf);
  }
  
  public final void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(123455);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.qia = paramString2;
    this.tOb = paramInt;
    super.I(4, b.aoC(paramString1));
    cvL().kqZ = 4;
    cvL().rYx = this.tOb;
    cvG();
    if (this.rYE.mab != null)
    {
      this.rYE.mab.putBoolean("ifAppAttachDownloadUI", false);
      this.rYE.mab.putString("filePath", paramString1);
      this.rYE.mab.putString("fileExt", paramString2);
      this.rYE.mab.putInt("sence", paramInt);
      cvG();
    }
    AppMethodBeat.o(123455);
  }
  
  public final boolean aOg()
  {
    return true;
  }
  
  public final boolean aOh()
  {
    return true;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(123453);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aOi();
    if ((this.rZC != null) && (this.rZC.getActivity() != null)) {
      this.rZC.getActivity().finish();
    }
    AppMethodBeat.o(123453);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(123454);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bNW();
    AppMethodBeat.o(123454);
  }
  
  public final boolean bOb()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.a
 * JD-Core Version:    0.7.0.1
 */