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
  private final a drt;
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.materialCardViewStyle);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208924);
    paramContext = k.a(paramContext, paramAttributeSet, a.k.MaterialCardView, paramInt, a.j.Widget_MaterialComponents_CardView, new int[0]);
    this.drt = new a(this);
    paramAttributeSet = this.drt;
    paramAttributeSet.strokeColor = paramContext.getColor(a.k.MaterialCardView_strokeColor, -1);
    paramAttributeSet.strokeWidth = paramContext.getDimensionPixelSize(a.k.MaterialCardView_strokeWidth, 0);
    paramAttributeSet.VT();
    paramAttributeSet.VV();
    paramContext.recycle();
    AppMethodBeat.o(208924);
  }
  
  public int getStrokeColor()
  {
    return this.drt.strokeColor;
  }
  
  public int getStrokeWidth()
  {
    return this.drt.strokeWidth;
  }
  
  public void setRadius(float paramFloat)
  {
    AppMethodBeat.i(208946);
    super.setRadius(paramFloat);
    this.drt.VT();
    AppMethodBeat.o(208946);
  }
  
  public void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(208929);
    a locala = this.drt;
    locala.strokeColor = paramInt;
    locala.VT();
    AppMethodBeat.o(208929);
  }
  
  public void setStrokeWidth(int paramInt)
  {
    AppMethodBeat.i(208935);
    a locala = this.drt;
    locala.strokeWidth = paramInt;
    locala.VT();
    locala.VV();
    AppMethodBeat.o(208935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.card.MaterialCardView
 * JD-Core Version:    0.7.0.1
 */