package com.tencent.mm.plugin.choosemsgfile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public final class b
  extends c
{
  private String mFilePath;
  private apf qhY;
  private String qia;
  private int tOb;
  
  public b(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(243541);
    this.mFilePath = "";
    this.qia = "";
    this.tOb = 0;
    this.qhY = new apf();
    AppMethodBeat.o(243541);
  }
  
  public final void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(243544);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageMultiTaskHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.qia = paramString2;
    this.tOb = paramInt;
    super.I(4, g.aQW(paramString1));
    this.qhY.filePath = paramString1;
    this.qhY.Rwe = u.bBQ(paramString1);
    this.qhY.jmx = paramString2;
    this.qhY.tNG = paramInt;
    this.qhY.SCl = false;
    try
    {
      this.FHd.field_data = this.qhY.toByteArray();
      faR();
      AppMethodBeat.o(243544);
      return;
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.FilesFloatBall.ChooseMsgFilesPageMultiTaskHelper", "handleMultiTaskInfoClicked", new Object[] { paramString1 });
      }
    }
  }
  
  public final boolean cbG()
  {
    return true;
  }
  
  public final boolean cbH()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.b
 * JD-Core Version:    0.7.0.1
 */