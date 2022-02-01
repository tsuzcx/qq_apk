package com.tencent.mm.plugin.fav.ui.b;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

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
  
  public final boolean aVX()
  {
    AppMethodBeat.i(107289);
    if ((!bt.isNullOrNil(this.mFilePath)) && (!i.eK(this.mFilePath)))
    {
      AppMethodBeat.o(107289);
      return false;
    }
    AppMethodBeat.o(107289);
    return true;
  }
  
  public final boolean aVY()
  {
    return true;
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(107290);
    ad.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWb();
    if ((this.mEA != null) && (this.mEA.getActivity() != null)) {
      this.mEA.getActivity().finish();
    }
    AppMethodBeat.o(107290);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(107291);
    ad.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWc();
    AppMethodBeat.o(107291);
  }
  
  public final boolean aWg()
  {
    return true;
  }
  
  public final void fO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107292);
    ad.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.joX = paramString2;
    this.nNu = 2;
    super.Z(4, b.OJ(paramString1));
    if (this.mDH.hsl != null)
    {
      this.mDH.hsl.putString("filePath", paramString1);
      this.mDH.hsl.putBoolean("ifAppAttachDownloadUI", false);
      this.mDH.hsl.putString("fileExt", paramString2);
      this.mDH.hsl.putInt("sence", 2);
      bzv();
    }
    AppMethodBeat.o(107292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */