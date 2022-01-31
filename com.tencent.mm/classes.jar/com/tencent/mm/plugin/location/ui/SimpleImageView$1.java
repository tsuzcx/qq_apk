package com.tencent.mm.plugin.location.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;

final class SimpleImageView$1
  extends ak
{
  SimpleImageView$1(SimpleImageView paramSimpleImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(113527);
    byte[] arrayOfByte = (byte[])paramMessage.obj;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ab.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
      AppMethodBeat.o(113527);
      return;
    }
    paramMessage = d.bT(arrayOfByte);
    String str = SimpleImageView.a(this.odN) + g.w(SimpleImageView.b(this.odN).getBytes());
    ab.d("MicroMsg.SimpleImageView", "filePath  %s", new Object[] { str });
    e.b(str, arrayOfByte, arrayOfByte.length);
    if ((paramMessage != null) && (SimpleImageView.c(this.odN) > 0) && (SimpleImageView.d(this.odN) > 0)) {
      paramMessage = d.a(paramMessage, SimpleImageView.d(this.odN), SimpleImageView.c(this.odN), true, false);
    }
    for (;;)
    {
      this.odN.setImageBitmap(paramMessage);
      AppMethodBeat.o(113527);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.SimpleImageView.1
 * JD-Core Version:    0.7.0.1
 */