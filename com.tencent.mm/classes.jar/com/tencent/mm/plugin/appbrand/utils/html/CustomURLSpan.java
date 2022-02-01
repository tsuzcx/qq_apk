package com.tencent.mm.plugin.appbrand.utils.html;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomURLSpan
  extends URLSpan
{
  private String mUrl;
  private c.a mpi;
  private boolean mpj;
  
  public CustomURLSpan(String paramString, c.a parama, boolean paramBoolean)
  {
    super(paramString);
    this.mUrl = paramString;
    this.mpi = parama;
    this.mpj = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(147727);
    if (this.mpi == null)
    {
      AppMethodBeat.o(147727);
      return;
    }
    this.mpi.Ls(this.mUrl);
    AppMethodBeat.o(147727);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(147728);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(this.mpj);
    AppMethodBeat.o(147728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.html.CustomURLSpan
 * JD-Core Version:    0.7.0.1
 */