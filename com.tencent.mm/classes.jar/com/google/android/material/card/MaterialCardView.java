package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.a.b;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaterialCardView
  extends CardView
{
  private final a bys;
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.materialCardViewStyle);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235619);
    paramContext = k.a(paramContext, paramAttributeSet, a.k.MaterialCardView, paramInt, a.j.Widget_MaterialComponents_CardView, new int[0]);
    this.bys = new a(this);
    paramAttributeSet = this.bys;
    paramAttributeSet.strokeColor = paramContext.getColor(a.k.MaterialCardView_strokeColor, -1);
    paramAttributeSet.strokeWidth = paramContext.getDimensionPixelSize(a.k.MaterialCardView_strokeWidth, 0);
    paramAttributeSet.wu();
    paramAttributeSet.ww();
    paramContext.recycle();
    AppMethodBeat.o(235619);
  }
  
  public int getStrokeColor()
  {
    return this.bys.strokeColor;
  }
  
  public int getStrokeWidth()
  {
    return this.bys.strokeWidth;
  }
  
  public void setRadius(float paramFloat)
  {
    AppMethodBeat.i(235624);
    super.setRadius(paramFloat);
    this.bys.wu();
    AppMethodBeat.o(235624);
  }
  
  public void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(235620);
    a locala = this.bys;
    locala.strokeColor = paramInt;
    locala.wu();
    AppMethodBeat.o(235620);
  }
  
  public void setStrokeWidth(int paramInt)
  {
    AppMethodBeat.i(235622);
    a locala = this.bys;
    locala.strokeWidth = paramInt;
    locala.wu();
    locala.ww();
    AppMethodBeat.o(235622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.card.MaterialCardView
 * JD-Core Version:    0.7.0.1
 */