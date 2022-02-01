package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public a kgG;
  
  public static b aIT()
  {
    AppMethodBeat.i(141136);
    b localb = new b();
    localb.kgG = new a();
    AppMethodBeat.o(141136);
    return localb;
  }
  
  public final b aIU()
  {
    this.kgG.maxLines = 6;
    return this;
  }
  
  public final b aIV()
  {
    this.kgG.kgy = 1;
    return this;
  }
  
  public final b as(float paramFloat)
  {
    this.kgG.textSize = paramFloat;
    return this;
  }
  
  public final b b(TextUtils.TruncateAt paramTruncateAt)
  {
    this.kgG.kgs = paramTruncateAt;
    return this;
  }
  
  public final b sK(int paramInt)
  {
    this.kgG.ek = paramInt;
    return this;
  }
  
  public final b sL(int paramInt)
  {
    this.kgG.textColor = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */