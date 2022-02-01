package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public a mGZ;
  
  public static b bbQ()
  {
    AppMethodBeat.i(141136);
    b localb = new b();
    localb.mGZ = new a();
    AppMethodBeat.o(141136);
    return localb;
  }
  
  public final b b(TextUtils.TruncateAt paramTruncateAt)
  {
    this.mGZ.bbe = paramTruncateAt;
    return this;
  }
  
  public final b bbR()
  {
    this.mGZ.maxLines = 6;
    return this;
  }
  
  public final b bbS()
  {
    this.mGZ.bbl = 1;
    return this;
  }
  
  public final b bn(float paramFloat)
  {
    this.mGZ.textSize = paramFloat;
    return this;
  }
  
  public final b sH(int paramInt)
  {
    this.mGZ.fl = paramInt;
    return this;
  }
  
  public final b sI(int paramInt)
  {
    this.mGZ.textColor = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */