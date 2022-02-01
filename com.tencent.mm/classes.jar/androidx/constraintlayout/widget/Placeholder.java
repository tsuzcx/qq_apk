package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Placeholder
  extends View
{
  private int GQ;
  View GR;
  private int GS;
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194979);
    this.GQ = -1;
    this.GR = null;
    this.GS = 4;
    f(paramAttributeSet);
    AppMethodBeat.o(194979);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194984);
    this.GQ = -1;
    this.GR = null;
    this.GS = 4;
    f(paramAttributeSet);
    AppMethodBeat.o(194984);
  }
  
  private void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(194989);
    super.setVisibility(this.GS);
    this.GQ = -1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_placeholder);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      if (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_placeholder_content) {
          this.GQ = paramAttributeSet.getResourceId(k, this.GQ);
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == R.styleable.ConstraintLayout_placeholder_emptyVisibility) {
            this.GS = paramAttributeSet.getInt(k, this.GS);
          }
        }
      }
    }
    AppMethodBeat.o(194989);
  }
  
  public final void a(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(195001);
    if ((this.GQ == -1) && (!isInEditMode())) {
      setVisibility(this.GS);
    }
    this.GR = paramConstraintLayout.findViewById(this.GQ);
    if (this.GR != null)
    {
      ((ConstraintLayout.LayoutParams)this.GR.getLayoutParams()).FW = true;
      this.GR.setVisibility(0);
      setVisibility(0);
    }
    AppMethodBeat.o(195001);
  }
  
  public View getContent()
  {
    return this.GR;
  }
  
  public int getEmptyVisibility()
  {
    return this.GS;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(194997);
    if (isInEditMode())
    {
      paramCanvas.drawRGB(223, 223, 223);
      Paint localPaint = new Paint();
      localPaint.setARGB(255, 210, 210, 210);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Rect localRect = new Rect();
      paramCanvas.getClipBounds(localRect);
      localPaint.setTextSize(localRect.height());
      int i = localRect.height();
      int j = localRect.width();
      localPaint.setTextAlign(Paint.Align.LEFT);
      localPaint.getTextBounds("?", 0, "?".length(), localRect);
      paramCanvas.drawText("?", j / 2.0F - localRect.width() / 2.0F - localRect.left, i / 2.0F + localRect.height() / 2.0F - localRect.bottom, localPaint);
    }
    AppMethodBeat.o(194997);
  }
  
  public void setContentId(int paramInt)
  {
    AppMethodBeat.i(195008);
    if (this.GQ == paramInt)
    {
      AppMethodBeat.o(195008);
      return;
    }
    if (this.GR != null)
    {
      this.GR.setVisibility(0);
      ((ConstraintLayout.LayoutParams)this.GR.getLayoutParams()).FW = false;
      this.GR = null;
    }
    this.GQ = paramInt;
    if (paramInt != -1)
    {
      View localView = ((View)getParent()).findViewById(paramInt);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(195008);
  }
  
  public void setEmptyVisibility(int paramInt)
  {
    this.GS = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.constraintlayout.widget.Placeholder
 * JD-Core Version:    0.7.0.1
 */