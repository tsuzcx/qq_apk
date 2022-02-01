package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan
  extends LeadingMarginSpan.Standard
  implements g<Integer>, h<Integer>
{
  private final int oTA;
  private final boolean oTy;
  
  private IndentationSpan(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.oTA = paramInt;
    this.oTy = paramBoolean;
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.oTy) {
      return 0;
    }
    return this.oTA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.IndentationSpan
 * JD-Core Version:    0.7.0.1
 */