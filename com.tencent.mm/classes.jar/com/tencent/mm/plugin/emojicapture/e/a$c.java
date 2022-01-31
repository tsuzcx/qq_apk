package com.tencent.mm.plugin.emojicapture.e;

import a.d.b.g;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureTextureView;
import com.tencent.mm.plugin.emojicapture.ui.a.e;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$c
  implements f
{
  a$c(a parama) {}
  
  public final boolean M(byte[] paramArrayOfByte)
  {
    com.tencent.mm.plugin.emojicapture.ui.a.a locala = a.a(this.jme);
    g.j(paramArrayOfByte, "it");
    g.k(paramArrayOfByte, "frame");
    if (locala.jqQ)
    {
      long l = bk.UZ();
      e locale = locala.jog;
      int i = locala.fvY;
      int j = locala.fvZ;
      int k = locala.fwu;
      g.k(paramArrayOfByte, "frame");
      if (!bk.bE(locale.jrN))
      {
        byte[] arrayOfByte = locale.jrN;
        if ((arrayOfByte != null) && (arrayOfByte.length == paramArrayOfByte.length)) {}
      }
      else
      {
        locale.jrN = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, locale.jrN, 0, paramArrayOfByte.length);
      locale.fvY = i;
      locale.fvZ = j;
      locale.fwu = k;
      locala.jqR.requestRender();
      y.i(locala.TAG, "drawFrame used " + bk.cp(l));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a.c
 * JD-Core Version:    0.7.0.1
 */