package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
{
  Bitmap cMT;
  private d cMU;
  Rect cMV;
  int[] cMW;
  
  e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140012);
    this.cMU = new l();
    this.cMV = new Rect();
    this.cMW = new int[4];
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 512;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 512;
    }
    this.cMT = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_8888);
    this.cMU.init(i, paramInt1);
    this.cMV.setEmpty();
    AppMethodBeat.o(140012);
  }
  
  final boolean b(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(140013);
    if (paramRect == null)
    {
      AppMethodBeat.o(140013);
      return false;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramRect.setEmpty();
      AppMethodBeat.o(140013);
      return false;
    }
    this.cMU.a(paramInt1, paramInt2, paramRect);
    if ((paramRect.left < 0) || (paramRect.right < 0) || (paramRect.width() <= 0) || (paramRect.height() <= 0))
    {
      AppMethodBeat.o(140013);
      return false;
    }
    this.cMV.union(paramRect);
    AppMethodBeat.o(140013);
    return true;
  }
  
  final void clear()
  {
    AppMethodBeat.i(140014);
    this.cMV.setEmpty();
    this.cMU.reset();
    if (this.cMT != null) {
      this.cMT.eraseColor(0);
    }
    AppMethodBeat.o(140014);
  }
  
  final int height()
  {
    AppMethodBeat.i(140016);
    if (this.cMT != null)
    {
      int i = this.cMT.getHeight();
      AppMethodBeat.o(140016);
      return i;
    }
    AppMethodBeat.o(140016);
    return 0;
  }
  
  final int width()
  {
    AppMethodBeat.i(140015);
    if (this.cMT != null)
    {
      int i = this.cMT.getWidth();
      AppMethodBeat.o(140015);
      return i;
    }
    AppMethodBeat.o(140015);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.e
 * JD-Core Version:    0.7.0.1
 */