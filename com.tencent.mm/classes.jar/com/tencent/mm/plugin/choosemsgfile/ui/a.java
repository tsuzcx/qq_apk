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
  private String tmM = "";
  private int wRr = 0;
  
  public a(f paramf)
  {
    super(paramf);
  }
  
  public final void T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(123455);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.tmM = paramString2;
    this.wRr = paramInt;
    super.J(4, b.ahY(paramString1));
    cYv().mUU = 4;
    cYv().vjN = this.wRr;
    cYr();
    if (this.vjV.oSS != null)
    {
      this.vjV.oSS.putBoolean("ifAppAttachDownloadUI", false);
      this.vjV.oSS.putString("filePath", paramString1);
      this.vjV.oSS.putString("fileExt", paramString2);
      this.vjV.oSS.putInt("sence", paramInt);
      cYr();
    }
    AppMethodBeat.o(123455);
  }
  
  public final boolean bhU()
  {
    return true;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(123453);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhV();
    if ((this.vkT != null) && (this.vkT.getActivity() != null)) {
      this.vkT.getActivity().finish();
    }
    AppMethodBeat.o(123453);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(123454);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.coj();
    AppMethodBeat.o(123454);
  }
  
  public final boolean cop()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.a
 * JD-Core Version:    0.7.0.1
 */