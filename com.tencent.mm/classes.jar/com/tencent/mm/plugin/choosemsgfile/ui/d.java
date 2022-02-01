package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends com.tencent.mm.plugin.ball.service.f
{
  private String mFilePath = "";
  private String nhr = "";
  private int qpr = 0;
  
  public d(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void I(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(123455);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.nhr = paramString2;
    this.qpr = paramInt;
    super.G(4, b.agW(paramString1));
    ciw().hDa = 4;
    ciw().oWx = this.qpr;
    cit();
    if (this.oWE.jkf != null)
    {
      this.oWE.jkf.putBoolean("ifAppAttachDownloadUI", false);
      this.oWE.jkf.putString("filePath", paramString1);
      this.oWE.jkf.putString("fileExt", paramString2);
      this.oWE.jkf.putInt("sence", paramInt);
      cit();
    }
    AppMethodBeat.o(123455);
  }
  
  public final boolean aGg()
  {
    return true;
  }
  
  public final boolean aGh()
  {
    return true;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(123453);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aGi();
    if ((this.oXA != null) && (this.oXA.getActivity() != null)) {
      this.oXA.getActivity().finish();
    }
    AppMethodBeat.o(123453);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(123454);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bCB();
    AppMethodBeat.o(123454);
  }
  
  public final boolean bCG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.d
 * JD-Core Version:    0.7.0.1
 */