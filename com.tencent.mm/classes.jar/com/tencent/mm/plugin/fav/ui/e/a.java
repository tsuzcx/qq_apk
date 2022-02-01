package com.tencent.mm.plugin.fav.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public final class a
  extends c
{
  private String mFilePath;
  private aoe nhp;
  private String nhr;
  private int qpr;
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(235385);
    this.mFilePath = "";
    this.nhr = "";
    this.qpr = 0;
    this.nhp = new aoe();
    AppMethodBeat.o(235385);
  }
  
  public final boolean bPp()
  {
    AppMethodBeat.i(235386);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!s.YS(this.mFilePath)))
    {
      AppMethodBeat.o(235386);
      return false;
    }
    AppMethodBeat.o(235386);
    return true;
  }
  
  public final boolean bPq()
  {
    return true;
  }
  
  public final void gH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235387);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePMultiTaskHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.nhr = paramString2;
    this.qpr = 2;
    super.G(4, b.agW(paramString1));
    this.nhp.filePath = paramString1;
    this.nhp.LzM = s.boW(paramString1);
    this.nhp.gCr = paramString2;
    this.nhp.qoX = 2;
    this.nhp.LzL = false;
    try
    {
      this.Abp.field_data = this.nhp.toByteArray();
      eqX();
      AppMethodBeat.o(235387);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.a
 * JD-Core Version:    0.7.0.1
 */