package com.tencent.mm.plugin.fav.ui.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public final class a
  extends c
{
  private String mFilePath;
  private apf qhY;
  private String qia;
  private int tOb;
  
  public a(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(233587);
    this.mFilePath = "";
    this.qia = "";
    this.tOb = 0;
    this.qhY = new apf();
    AppMethodBeat.o(233587);
  }
  
  public final boolean cbG()
  {
    AppMethodBeat.i(233589);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!u.agG(this.mFilePath)))
    {
      AppMethodBeat.o(233589);
      return false;
    }
    AppMethodBeat.o(233589);
    return true;
  }
  
  public final boolean cbH()
  {
    return true;
  }
  
  public final void gV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(233593);
    Log.i("MicroMsg.FilesFloatBall.FavoriteFilePMultiTaskHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(2) });
    this.mFilePath = paramString1;
    this.qia = paramString2;
    this.tOb = 2;
    super.I(4, b.aoC(paramString1));
    this.qhY.filePath = paramString1;
    this.qhY.Rwe = u.bBQ(paramString1);
    this.qhY.jmx = paramString2;
    this.qhY.tNG = 2;
    this.qhY.SCl = false;
    try
    {
      this.FHd.field_data = this.qhY.toByteArray();
      faR();
      AppMethodBeat.o(233593);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f.a
 * JD-Core Version:    0.7.0.1
 */