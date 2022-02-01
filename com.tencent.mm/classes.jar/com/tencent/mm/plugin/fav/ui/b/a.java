package com.tencent.mm.plugin.fav.ui.b;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

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
  
  public final boolean aOg()
  {
    AppMethodBeat.i(107289);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!u.agG(this.mFilePath)))
    {
      AppMethodBeat.o(107289);
      return false;
    }
    AppMethodBeat.o(107289);
    return true;
  }
  
  public final boolean aOh()
  {
    return true;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(107290);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aOi();
    if ((this.rZC != null) && (this.rZC.getActivity() != null)) {
      this.rZC.getActivity().finish();
    }
    AppMethodBeat.o(107290);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(107291);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bNW();
    AppMethodBeat.o(107291);
  }
  
  public final boolean bOb()
  {
    return true;
  }
  
  public final void gV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107292);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.qia = paramString2;
    this.tOb = 2;
    super.I(4, b.aoC(paramString1));
    if (this.rYE.mab != null)
    {
      this.rYE.mab.putString("filePath", paramString1);
      this.rYE.mab.putBoolean("ifAppAttachDownloadUI", false);
      this.rYE.mab.putString("fileExt", paramString2);
      this.rYE.mab.putInt("sence", 2);
      cvG();
    }
    AppMethodBeat.o(107292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */