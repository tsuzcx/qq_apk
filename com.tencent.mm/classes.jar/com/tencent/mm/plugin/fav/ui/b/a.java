package com.tencent.mm.plugin.fav.ui.b;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

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
  
  public final boolean bcV()
  {
    AppMethodBeat.i(107289);
    if ((!bs.isNullOrNil(this.mFilePath)) && (!i.eA(this.mFilePath)))
    {
      AppMethodBeat.o(107289);
      return false;
    }
    AppMethodBeat.o(107289);
    return true;
  }
  
  public final boolean bcW()
  {
    return true;
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(107290);
    ac.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bcZ();
    if ((this.ngF != null) && (this.ngF.getActivity() != null)) {
      this.ngF.getActivity().finish();
    }
    AppMethodBeat.o(107290);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(107291);
    ac.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bda();
    AppMethodBeat.o(107291);
  }
  
  public final boolean bde()
  {
    return true;
  }
  
  public final void gb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107292);
    ac.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.jPj = paramString2;
    this.oqw = 2;
    super.aa(4, b.ST(paramString1));
    if (this.nfN.hSN != null)
    {
      this.nfN.hSN.putString("filePath", paramString1);
      this.nfN.hSN.putBoolean("ifAppAttachDownloadUI", false);
      this.nfN.hSN.putString("fileExt", paramString2);
      this.nfN.hSN.putInt("sence", 2);
      bGr();
    }
    AppMethodBeat.o(107292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */