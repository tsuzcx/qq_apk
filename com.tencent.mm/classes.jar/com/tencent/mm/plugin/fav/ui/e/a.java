package com.tencent.mm.plugin.fav.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public final class a
  extends c
{
  private String mFilePath;
  private asy tmK;
  private String tmM;
  private int wRr;
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(274393);
    this.mFilePath = "";
    this.tmM = "";
    this.wRr = 0;
    this.tmK = new asy();
    AppMethodBeat.o(274393);
  }
  
  public final boolean cBZ()
  {
    AppMethodBeat.i(274394);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!y.ZC(this.mFilePath)))
    {
      AppMethodBeat.o(274394);
      return false;
    }
    AppMethodBeat.o(274394);
    return true;
  }
  
  public final boolean cCa()
  {
    return true;
  }
  
  public final void hE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(274396);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePMultiTaskHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.tmM = paramString2;
    this.wRr = 2;
    super.J(4, b.ahY(paramString1));
    this.tmK.filePath = paramString1;
    this.tmK.Ysz = y.bEl(paramString1);
    this.tmK.lPJ = paramString2;
    this.tmK.wQW = 2;
    this.tmK.ZDd = false;
    try
    {
      this.LCE.field_data = this.tmK.toByteArray();
      gjW();
      AppMethodBeat.o(274396);
      return;
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.FilesFloatBall.FavoriteFilePMultiTaskHelper", "handleMultiTaskInfoClicked", new Object[] { paramString1 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.a
 * JD-Core Version:    0.7.0.1
 */