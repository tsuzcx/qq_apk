package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private String jPj = "";
  private String mFilePath = "";
  private int oqw = 0;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void I(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(123455);
    ac.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.jPj = paramString2;
    this.oqw = paramInt;
    super.aa(4, b.ST(paramString1));
    bGv().nfG = 4;
    bGv().nfF = this.oqw;
    bGr();
    if (this.nfN.hSN != null)
    {
      this.nfN.hSN.putBoolean("ifAppAttachDownloadUI", false);
      this.nfN.hSN.putString("filePath", paramString1);
      this.nfN.hSN.putString("fileExt", paramString2);
      this.nfN.hSN.putInt("sence", paramInt);
      bGr();
    }
    AppMethodBeat.o(123455);
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
    AppMethodBeat.i(123453);
    ac.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bcZ();
    if ((this.ngF != null) && (this.ngF.getActivity() != null)) {
      this.ngF.getActivity().finish();
    }
    AppMethodBeat.o(123453);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(123454);
    ac.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bda();
    AppMethodBeat.o(123454);
  }
  
  public final boolean bde()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.a
 * JD-Core Version:    0.7.0.1
 */