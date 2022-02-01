package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.a;

public class FixAspectRatioImageView
  extends AppCompatImageView
{
  private float rcc;
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40891);
    this.rcc = 0.0F;
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(40891);
  }
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40892);
    this.rcc = 0.0F;
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(40892);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(40893);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, f.a.FixAspectRatioImageView, paramInt, 0);
    this.rcc = paramContext.getFloat(0, 0.0F);
    paramContext.recycle();
    AppMethodBeat.o(40893);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40894);
    if (this.rcc != 0.0F)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      paramInt2 = (int)(this.rcc * paramInt1);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(40894);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(40894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.FixAspectRatioImageView
 * JD-Core Version:    0.7.0.1
 */