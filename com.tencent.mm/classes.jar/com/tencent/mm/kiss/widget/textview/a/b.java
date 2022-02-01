package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public a glF;
  
  public static b ahZ()
  {
    AppMethodBeat.i(141136);
    b localb = new b();
    localb.glF = new a();
    AppMethodBeat.o(141136);
    return localb;
  }
  
  public final b a(TextUtils.TruncateAt paramTruncateAt)
  {
    this.glF.gls = paramTruncateAt;
    return this;
  }
  
  public final b ag(float paramFloat)
  {
    this.glF.textSize = paramFloat;
    return this;
  }
  
  public final b aia()
  {
    this.glF.maxLines = 6;
    return this;
  }
  
  public final b mu(int paramInt)
  {
    this.glF.gravity = paramInt;
    return this;
  }
  
  public final b mv(int paramInt)
  {
    this.glF.textColor = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */