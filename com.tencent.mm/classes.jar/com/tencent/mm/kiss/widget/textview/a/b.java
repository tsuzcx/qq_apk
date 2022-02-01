package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public a huK;
  
  public static b aBq()
  {
    AppMethodBeat.i(141136);
    b localb = new b();
    localb.huK = new a();
    AppMethodBeat.o(141136);
    return localb;
  }
  
  public final b aBr()
  {
    this.huK.maxLines = 6;
    return this;
  }
  
  public final b aBs()
  {
    this.huK.breakStrategy = 1;
    return this;
  }
  
  public final b as(float paramFloat)
  {
    this.huK.textSize = paramFloat;
    return this;
  }
  
  public final b b(TextUtils.TruncateAt paramTruncateAt)
  {
    this.huK.hux = paramTruncateAt;
    return this;
  }
  
  public final b qk(int paramInt)
  {
    this.huK.gravity = paramInt;
    return this;
  }
  
  public final b ql(int paramInt)
  {
    this.huK.textColor = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */