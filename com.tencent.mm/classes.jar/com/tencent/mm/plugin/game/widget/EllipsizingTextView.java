package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EllipsizingTextView
  extends TextView
{
  private final List<Object> lgY = new ArrayList();
  private boolean lgZ;
  private boolean lha;
  private boolean lhb;
  private String lhc;
  private float lhd = 1.0F;
  private float lhe = 0.0F;
  private int maxLines = -1;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Layout Fh(String paramString)
  {
    return new StaticLayout(paramString, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.lhd, this.lhe, false);
  }
  
  public int getMaxLines()
  {
    return this.maxLines;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject1;
    if (this.lha)
    {
      super.setEllipsize(null);
      int j = getMaxLines();
      localObject1 = this.lhc;
      if (j == -1) {
        break label304;
      }
      Object localObject2 = Fh((String)localObject1);
      if (((Layout)localObject2).getLineCount() <= j) {
        break label304;
      }
      localObject2 = this.lhc.substring(0, ((Layout)localObject2).getLineEnd(j - 1)).trim();
      if (((String)localObject2).getBytes().length != ((String)localObject2).length()) {}
      for (int i = 1; i == 0; i = 0) {
        for (;;)
        {
          localObject1 = localObject2;
          if (Fh((String)localObject2 + "...").getLineCount() <= j) {
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
    label304:
    for (boolean bool = true;; bool = false)
    {
      if (!((String)localObject1).equals(getText())) {
        this.lhb = true;
      }
      try
      {
        setText((CharSequence)localObject1);
        this.lhb = false;
        this.lha = false;
        if (bool != this.lgZ)
        {
          this.lgZ = bool;
          localObject1 = this.lgY.iterator();
          if (((Iterator)localObject1).hasNext()) {
            ((Iterator)localObject1).next();
          }
        }
        return;
      }
      finally
      {
        this.lhb = false;
      }
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.lhb)
    {
      this.lhc = paramCharSequence.toString();
      this.lha = true;
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt) {}
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.lhe = paramFloat1;
    this.lhd = paramFloat2;
    super.setLineSpacing(paramFloat1, paramFloat2);
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.maxLines = paramInt;
    this.lha = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */