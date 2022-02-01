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
  private String kju = "";
  private String mFilePath = "";
  private int oTR = 0;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final boolean bgA()
  {
    return true;
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(107290);
    ad.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgD();
    if ((this.nHb != null) && (this.nHb.getActivity() != null)) {
      this.nHb.getActivity().finish();
    }
    AppMethodBeat.o(107290);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(107291);
    ad.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgE();
    AppMethodBeat.o(107291);
  }
  
  public final boolean bgI()
  {
    return true;
  }
  
  public final boolean bgz()
  {
    AppMethodBeat.i(107289);
    if ((!bt.isNullOrNil(this.mFilePath)) && (!i.fv(this.mFilePath)))
    {
      AppMethodBeat.o(107289);
      return false;
    }
    AppMethodBeat.o(107289);
    return true;
  }
  
  public final void gk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107292);
    ad.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.kju = paramString2;
    this.oTR = 2;
    super.ac(4, b.Wq(paramString1));
    if (this.nGj.ime != null)
    {
      this.nGj.ime.putString("filePath", paramString1);
      this.nGj.ime.putBoolean("ifAppAttachDownloadUI", false);
      this.nGj.ime.putString("fileExt", paramString2);
      this.nGj.ime.putInt("sence", 2);
      bKC();
    }
    AppMethodBeat.o(107292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */