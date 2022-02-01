package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public a ggZ;
  
  public static b agI()
  {
    AppMethodBeat.i(141136);
    b localb = new b();
    localb.ggZ = new a();
    AppMethodBeat.o(141136);
    return localb;
  }
  
  public final b a(TextUtils.TruncateAt paramTruncateAt)
  {
    this.ggZ.ggM = paramTruncateAt;
    return this;
  }
  
  public final b ac(float paramFloat)
  {
    this.ggZ.textSize = paramFloat;
    return this;
  }
  
  public final b agJ()
  {
    this.ggZ.maxLines = 6;
    return this;
  }
  
  public final b mv(int paramInt)
  {
    this.ggZ.gravity = paramInt;
    return this;
  }
  
  public final b mw(int paramInt)
  {
    this.ggZ.textColor = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */