package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan
  extends LeadingMarginSpan.Standard
  implements g<Integer>, h<Integer>
{
  private final boolean opY;
  private final int oqa;
  
  private IndentationSpan(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.oqa = paramInt;
    this.opY = paramBoolean;
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.opY) {
      return 0;
    }
    return this.oqa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.IndentationSpan
 * JD-Core Version:    0.7.0.1
 */