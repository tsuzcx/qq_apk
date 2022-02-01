package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public a gHW;
  
  public static b akZ()
  {
    AppMethodBeat.i(141136);
    b localb = new b();
    localb.gHW = new a();
    AppMethodBeat.o(141136);
    return localb;
  }
  
  public final b a(TextUtils.TruncateAt paramTruncateAt)
  {
    this.gHW.gHJ = paramTruncateAt;
    return this;
  }
  
  public final b aj(float paramFloat)
  {
    this.gHW.textSize = paramFloat;
    return this;
  }
  
  public final b ala()
  {
    this.gHW.maxLines = 6;
    return this;
  }
  
  public final b alb()
  {
    this.gHW.breakStrategy = 1;
    return this;
  }
  
  public final b mW(int paramInt)
  {
    this.gHW.gravity = paramInt;
    return this;
  }
  
  public final b mX(int paramInt)
  {
    this.gHW.textColor = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */