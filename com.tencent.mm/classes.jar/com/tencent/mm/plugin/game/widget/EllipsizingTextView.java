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
  private int maxLines;
  private final List<Object> nEQ;
  private boolean nER;
  private boolean nES;
  private boolean nET;
  private String nEU;
  private float nEV;
  private float nEW;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112403);
    this.nEQ = new ArrayList();
    this.maxLines = -1;
    this.nEV = 1.0F;
    this.nEW = 0.0F;
    AppMethodBeat.o(112403);
  }
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112404);
    this.nEQ = new ArrayList();
    this.maxLines = -1;
    this.nEV = 1.0F;
    this.nEW = 0.0F;
    AppMethodBeat.o(112404);
  }
  
  private Layout QF(String paramString)
  {
    AppMethodBeat.i(112409);
    paramString = new StaticLayout(paramString, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.nEV, this.nEW, false);
    AppMethodBeat.o(112409);
    return paramString;
  }
  
  public int getMaxLines()
  {
    return this.maxLines;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112408);
    Object localObject1;
    if (this.nES)
    {
      super.setEllipsize(null);
      int j = getMaxLines();
      localObject1 = this.nEU;
      if (j == -1) {
        break label319;
      }
      Object localObject2 = QF((String)localObject1);
      if (((Layout)localObject2).getLineCount() <= j) {
        break label319;
      }
      localObject2 = this.nEU.substring(0, ((Layout)localObject2).getLineEnd(j - 1)).trim();
      if (((String)localObject2).getBytes().length != ((String)localObject2).length()) {}
      for (int i = 1; i == 0; i = 0) {
        for (;;)
        {
          localObject1 = localObject2;
          if (QF((String)localObject2 + "...").getLineCount() <= j) {
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
        this.nET = true;
      }
      try
      {
        setText((CharSequence)localObject1);
        this.nET = false;
        this.nES = false;
        if (bool != this.nER)
        {
          this.nER = bool;
          localObject1 = this.nEQ.iterator();
          if (!((Iterator)localObject1).hasNext()) {}
        }
        return;
      }
      finally
      {
        this.nET = false;
        AppMethodBeat.o(112408);
      }
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112407);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.nET)
    {
      this.nEU = paramCharSequence.toString();
      this.nES = true;
    }
    AppMethodBeat.o(112407);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt) {}
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112406);
    this.nEW = paramFloat1;
    this.nEV = paramFloat2;
    super.setLineSpacing(paramFloat1, paramFloat2);
    AppMethodBeat.o(112406);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(112405);
    super.setMaxLines(paramInt);
    this.maxLines = paramInt;
    this.nES = true;
    AppMethodBeat.o(112405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */