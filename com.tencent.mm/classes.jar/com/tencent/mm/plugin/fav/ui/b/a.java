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
import com.tencent.mm.vfs.y;

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
  
  public final boolean bhU()
  {
    AppMethodBeat.i(107289);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!y.ZC(this.mFilePath)))
    {
      AppMethodBeat.o(107289);
      return false;
    }
    AppMethodBeat.o(107289);
    return true;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(107290);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhV();
    if ((this.vkT != null) && (this.vkT.getActivity() != null)) {
      this.vkT.getActivity().finish();
    }
    AppMethodBeat.o(107290);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(107291);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.coj();
    AppMethodBeat.o(107291);
  }
  
  public final boolean cop()
  {
    return true;
  }
  
  public final void hE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107292);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.tmM = paramString2;
    this.wRr = 2;
    super.J(4, b.ahY(paramString1));
    if (this.vjV.oSS != null)
    {
      this.vjV.oSS.putString("filePath", paramString1);
      this.vjV.oSS.putBoolean("ifAppAttachDownloadUI", false);
      this.vjV.oSS.putString("fileExt", paramString2);
      this.vjV.oSS.putInt("sence", 2);
      cYr();
    }
    AppMethodBeat.o(107292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */