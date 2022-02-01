package com.tencent.mm.plugin.fav.ui.g;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private String mFilePath = "";
  private String nhr = "";
  private int qpr = 0;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final boolean aGg()
  {
    AppMethodBeat.i(107289);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!s.YS(this.mFilePath)))
    {
      AppMethodBeat.o(107289);
      return false;
    }
    AppMethodBeat.o(107289);
    return true;
  }
  
  public final boolean aGh()
  {
    return true;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(107290);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aGi();
    if ((this.oXA != null) && (this.oXA.getActivity() != null)) {
      this.oXA.getActivity().finish();
    }
    AppMethodBeat.o(107290);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(107291);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bCB();
    AppMethodBeat.o(107291);
  }
  
  public final boolean bCG()
  {
    return true;
  }
  
  public final void gH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107292);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.nhr = paramString2;
    this.qpr = 2;
    super.G(4, b.agW(paramString1));
    if (this.oWE.jkf != null)
    {
      this.oWE.jkf.putString("filePath", paramString1);
      this.oWE.jkf.putBoolean("ifAppAttachDownloadUI", false);
      this.oWE.jkf.putString("fileExt", paramString2);
      this.oWE.jkf.putInt("sence", 2);
      cit();
    }
    AppMethodBeat.o(107292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.g.a
 * JD-Core Version:    0.7.0.1
 */