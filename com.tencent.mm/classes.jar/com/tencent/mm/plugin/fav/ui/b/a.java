package com.tencent.mm.plugin.fav.ui.b;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

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
  
  public final boolean bhh()
  {
    AppMethodBeat.i(107289);
    if ((!bu.isNullOrNil(this.mFilePath)) && (!o.fB(this.mFilePath)))
    {
      AppMethodBeat.o(107289);
      return false;
    }
    AppMethodBeat.o(107289);
    return true;
  }
  
  public final boolean bhi()
  {
    return true;
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(107290);
    ae.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhl();
    if ((this.nME != null) && (this.nME.getActivity() != null)) {
      this.nME.getActivity().finish();
    }
    AppMethodBeat.o(107290);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(107291);
    ae.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhm();
    AppMethodBeat.o(107291);
  }
  
  public final boolean bhq()
  {
    return true;
  }
  
  public final void gp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107292);
    ae.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.kmK = paramString2;
    this.pat = 2;
    super.ac(4, b.Xc(paramString1));
    if (this.nLK.ioY != null)
    {
      this.nLK.ioY.putString("filePath", paramString1);
      this.nLK.ioY.putBoolean("ifAppAttachDownloadUI", false);
      this.nLK.ioY.putString("fileExt", paramString2);
      this.nLK.ioY.putInt("sence", 2);
      bLz();
    }
    AppMethodBeat.o(107292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */