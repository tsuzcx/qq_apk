package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  Bitmap bJJ;
  private c bJK;
  Rect bJL;
  int[] bJM;
  
  d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115911);
    this.bJK = new k();
    this.bJL = new Rect();
    this.bJM = new int[4];
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 512;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 512;
    }
    this.bJJ = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_8888);
    this.bJK.init(i, paramInt1);
    this.bJL.setEmpty();
    AppMethodBeat.o(115911);
  }
  
  final boolean b(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(115912);
    if (paramRect == null)
    {
      AppMethodBeat.o(115912);
      return false;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramRect.setEmpty();
      AppMethodBeat.o(115912);
      return false;
    }
    this.bJK.a(paramInt1, paramInt2, paramRect);
    if ((paramRect.left < 0) || (paramRect.right < 0) || (paramRect.width() <= 0) || (paramRect.height() <= 0))
    {
      AppMethodBeat.o(115912);
      return false;
    }
    this.bJL.union(paramRect);
    AppMethodBeat.o(115912);
    return true;
  }
  
  final void clear()
  {
    AppMethodBeat.i(115913);
    this.bJL.setEmpty();
    this.bJK.reset();
    if (this.bJJ != null) {
      this.bJJ.eraseColor(0);
    }
    AppMethodBeat.o(115913);
  }
  
  final int height()
  {
    AppMethodBeat.i(115915);
    if (this.bJJ != null)
    {
      int i = this.bJJ.getHeight();
      AppMethodBeat.o(115915);
      return i;
    }
    AppMethodBeat.o(115915);
    return 0;
  }
  
  final int width()
  {
    AppMethodBeat.i(115914);
    if (this.bJJ != null)
    {
      int i = this.bJJ.getWidth();
      AppMethodBeat.o(115914);
      return i;
    }
    AppMethodBeat.o(115914);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.d
 * JD-Core Version:    0.7.0.1
 */