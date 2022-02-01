package com.tencent.mm.plugin.choosemsgfile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public final class b
  extends c
{
  private String mFilePath;
  private asy tmK;
  private String tmM;
  private int wRr;
  
  public b(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(262556);
    this.mFilePath = "";
    this.tmM = "";
    this.wRr = 0;
    this.tmK = new asy();
    AppMethodBeat.o(262556);
  }
  
  public final void T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(262563);
    Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageMultiTaskHelper", "onCreate, filePath:%s fileExt:%s ", new Object[] { paramString1, paramString2 });
    this.mFilePath = paramString1;
    this.tmM = paramString2;
    this.wRr = paramInt;
    super.J(4, g.aNO(paramString1));
    this.tmK.filePath = paramString1;
    this.tmK.Ysz = y.bEl(paramString1);
    this.tmK.lPJ = paramString2;
    this.tmK.wQW = paramInt;
    this.tmK.ZDd = false;
    try
    {
      this.LCE.field_data = this.tmK.toByteArray();
      gjW();
      AppMethodBeat.o(262563);
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
  
  public final boolean cBZ()
  {
    return true;
  }
  
  public final boolean cCa()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.b
 * JD-Core Version:    0.7.0.1
 */