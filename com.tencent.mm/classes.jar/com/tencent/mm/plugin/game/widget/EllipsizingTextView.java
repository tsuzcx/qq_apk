package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EllipsizingTextView
  extends TextView
{
  private final List<Object> IYO;
  private boolean IYP;
  private boolean IYQ;
  private boolean IYR;
  private String IYS;
  private float IYT;
  private float bbg;
  private int maxLines;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42611);
    this.IYO = new ArrayList();
    this.maxLines = -1;
    this.bbg = 1.0F;
    this.IYT = 0.0F;
    AppMethodBeat.o(42611);
  }
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42612);
    this.IYO = new ArrayList();
    this.maxLines = -1;
    this.bbg = 1.0F;
    this.IYT = 0.0F;
    AppMethodBeat.o(42612);
  }
  
  private Layout aHs(String paramString)
  {
    AppMethodBeat.i(42617);
    paramString = new StaticLayout(paramString, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.bbg, this.IYT, false);
    AppMethodBeat.o(42617);
    return paramString;
  }
  
  public int getMaxLines()
  {
    return this.maxLines;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42616);
    Object localObject1;
    if (this.IYQ)
    {
      super.setEllipsize(null);
      int j = getMaxLines();
      localObject1 = this.IYS;
      if (j == -1) {
        break label319;
      }
      Object localObject2 = aHs((String)localObject1);
      if (((Layout)localObject2).getLineCount() <= j) {
        break label319;
      }
      localObject2 = this.IYS.substring(0, ((Layout)localObject2).getLineEnd(j - 1)).trim();
      if (((String)localObject2).getBytes().length != ((String)localObject2).length()) {}
      for (int i = 1; i == 0; i = 0) {
        for (;;)
        {
          localObject1 = localObject2;
          if (aHs((String)localObject2 + "...").getLineCount() <= j) {
            break;
          }
          i = ((String)localObject2).lastIndexOf(' ');
          localObject1 = localObject2;
          if (i == -1) {
            break;
          }
          localObject2 = ((String)localObject2).substring(0, i);
        }
      }
      localObject1 = localObject2;
      if (((String)localObject2).length() >= 2) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1 - 1);
      }
      localObject1 = (String)localObject1 + "...";
    }
    label319:
    for (boolean bool = true;; bool = false)
    {
      if (!((String)localObject1).equals(getText())) {
        this.IYR = true;
      }
      try
      {
        setText((CharSequence)localObject1);
        this.IYR = false;
        this.IYQ = false;
        if (bool != this.IYP)
        {
          this.IYP = bool;
          localObject1 = this.IYO.iterator();
          if (!((Iterator)localObject1).hasNext()) {}
        }
        return;
      }
      finally
      {
        this.IYR = false;
        AppMethodBeat.o(42616);
      }
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(42615);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.IYR)
    {
      this.IYS = paramCharSequence.toString();
      this.IYQ = true;
    }
    AppMethodBeat.o(42615);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt) {}
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(42614);
    this.IYT = paramFloat1;
    this.bbg = paramFloat2;
    super.setLineSpacing(paramFloat1, paramFloat2);
    AppMethodBeat.o(42614);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(42613);
    super.setMaxLines(paramInt);
    this.maxLines = paramInt;
    this.IYQ = true;
    AppMethodBeat.o(42613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */