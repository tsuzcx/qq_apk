package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public a eLU;
  
  public static b SP()
  {
    AppMethodBeat.i(105816);
    b localb = new b();
    localb.eLU = new a();
    AppMethodBeat.o(105816);
    return localb;
  }
  
  public final b SQ()
  {
    this.eLU.maxLines = 6;
    return this;
  }
  
  public final b a(TextUtils.TruncateAt paramTruncateAt)
  {
    this.eLU.eLG = paramTruncateAt;
    return this;
  }
  
  public final b ae(float paramFloat)
  {
    this.eLU.textSize = paramFloat;
    return this;
  }
  
  public final b jR(int paramInt)
  {
    this.eLU.gravity = paramInt;
    return this;
  }
  
  public final b jS(int paramInt)
  {
    this.eLU.textColor = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */