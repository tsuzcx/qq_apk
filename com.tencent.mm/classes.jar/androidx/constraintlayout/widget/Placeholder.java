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
  private int bmQ;
  View bmR;
  private int bmS;
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194154);
    this.bmQ = -1;
    this.bmR = null;
    this.bmS = 4;
    f(paramAttributeSet);
    AppMethodBeat.o(194154);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194161);
    this.bmQ = -1;
    this.bmR = null;
    this.bmS = 4;
    f(paramAttributeSet);
    AppMethodBeat.o(194161);
  }
  
  private void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(194168);
    super.setVisibility(this.bmS);
    this.bmQ = -1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_placeholder);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      if (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_placeholder_content) {
          this.bmQ = paramAttributeSet.getResourceId(k, this.bmQ);
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == R.styleable.ConstraintLayout_placeholder_emptyVisibility) {
            this.bmS = paramAttributeSet.getInt(k, this.bmS);
          }
        }
      }
    }
    AppMethodBeat.o(194168);
  }
  
  public final void a(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(194198);
    if ((this.bmQ == -1) && (!isInEditMode())) {
      setVisibility(this.bmS);
    }
    this.bmR = paramConstraintLayout.findViewById(this.bmQ);
    if (this.bmR != null)
    {
      ((ConstraintLayout.LayoutParams)this.bmR.getLayoutParams()).bma = true;
      this.bmR.setVisibility(0);
      setVisibility(0);
    }
    AppMethodBeat.o(194198);
  }
  
  public View getContent()
  {
    return this.bmR;
  }
  
  public int getEmptyVisibility()
  {
    return this.bmS;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(194194);
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
    AppMethodBeat.o(194194);
  }
  
  public void setContentId(int paramInt)
  {
    AppMethodBeat.i(194202);
    if (this.bmQ == paramInt)
    {
      AppMethodBeat.o(194202);
      return;
    }
    if (this.bmR != null)
    {
      this.bmR.setVisibility(0);
      ((ConstraintLayout.LayoutParams)this.bmR.getLayoutParams()).bma = false;
      this.bmR = null;
    }
    this.bmQ = paramInt;
    if (paramInt != -1)
    {
      View localView = ((View)getParent()).findViewById(paramInt);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(194202);
  }
  
  public void setEmptyVisibility(int paramInt)
  {
    this.bmS = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.constraintlayout.widget.Placeholder
 * JD-Core Version:    0.7.0.1
 */