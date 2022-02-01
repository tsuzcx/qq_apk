package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public a gFp;
  
  public static b akK()
  {
    AppMethodBeat.i(141136);
    b localb = new b();
    localb.gFp = new a();
    AppMethodBeat.o(141136);
    return localb;
  }
  
  public final b a(TextUtils.TruncateAt paramTruncateAt)
  {
    this.gFp.gFc = paramTruncateAt;
    return this;
  }
  
  public final b aj(float paramFloat)
  {
    this.gFp.textSize = paramFloat;
    return this;
  }
  
  public final b akL()
  {
    this.gFp.maxLines = 6;
    return this;
  }
  
  public final b akM()
  {
    this.gFp.breakStrategy = 1;
    return this;
  }
  
  public final b mT(int paramInt)
  {
    this.gFp.gravity = paramInt;
    return this;
  }
  
  public final b mU(int paramInt)
  {
    this.gFp.textColor = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */