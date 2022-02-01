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
  private float hSE;
  private int maxLines;
  private final List<Object> spa;
  private boolean spb;
  private boolean spc;
  private boolean spd;
  private String spe;
  private float spf;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42611);
    this.spa = new ArrayList();
    this.maxLines = -1;
    this.hSE = 1.0F;
    this.spf = 0.0F;
    AppMethodBeat.o(42611);
  }
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42612);
    this.spa = new ArrayList();
    this.maxLines = -1;
    this.hSE = 1.0F;
    this.spf = 0.0F;
    AppMethodBeat.o(42612);
  }
  
  private Layout add(String paramString)
  {
    AppMethodBeat.i(42617);
    paramString = new StaticLayout(paramString, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.hSE, this.spf, false);
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
    if (this.spc)
    {
      super.setEllipsize(null);
      int j = getMaxLines();
      localObject1 = this.spe;
      if (j == -1) {
        break label319;
      }
      Object localObject2 = add((String)localObject1);
      if (((Layout)localObject2).getLineCount() <= j) {
        break label319;
      }
      localObject2 = this.spe.substring(0, ((Layout)localObject2).getLineEnd(j - 1)).trim();
      if (((String)localObject2).getBytes().length != ((String)localObject2).length()) {}
      for (int i = 1; i == 0; i = 0) {
        for (;;)
        {
          localObject1 = localObject2;
          if (add((String)localObject2 + "...").getLineCount() <= j) {
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
        this.spd = true;
      }
      try
      {
        setText((CharSequence)localObject1);
        this.spd = false;
        this.spc = false;
        if (bool != this.spb)
        {
          this.spb = bool;
          localObject1 = this.spa.iterator();
          if (!((Iterator)localObject1).hasNext()) {}
        }
        return;
      }
      finally
      {
        this.spd = false;
        AppMethodBeat.o(42616);
      }
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(42615);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.spd)
    {
      this.spe = paramCharSequence.toString();
      this.spc = true;
    }
    AppMethodBeat.o(42615);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt) {}
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(42614);
    this.spf = paramFloat1;
    this.hSE = paramFloat2;
    super.setLineSpacing(paramFloat1, paramFloat2);
    AppMethodBeat.o(42614);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(42613);
    super.setMaxLines(paramInt);
    this.maxLines = paramInt;
    this.spc = true;
    AppMethodBeat.o(42613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */