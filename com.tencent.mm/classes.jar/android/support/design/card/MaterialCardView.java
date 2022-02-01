package android.support.design.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.support.design.internal.f;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class MaterialCardView
  extends CardView
{
  private final a fe;
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969295);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = f.a(paramContext, paramAttributeSet, a.a.MaterialCardView, paramInt, 2131821658, new int[0]);
    this.fe = new a(this);
    paramAttributeSet = this.fe;
    paramAttributeSet.strokeColor = paramContext.getColor(0, -1);
    paramAttributeSet.strokeWidth = paramContext.getDimensionPixelSize(1, 0);
    paramAttributeSet.aD();
    paramAttributeSet.aF();
    paramContext.recycle();
  }
  
  public int getStrokeColor()
  {
    return this.fe.strokeColor;
  }
  
  public int getStrokeWidth()
  {
    return this.fe.strokeWidth;
  }
  
  public void setRadius(float paramFloat)
  {
    super.setRadius(paramFloat);
    this.fe.aD();
  }
  
  public void setStrokeColor(int paramInt)
  {
    a locala = this.fe;
    locala.strokeColor = paramInt;
    locala.aD();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    a locala = this.fe;
    locala.strokeWidth = paramInt;
    locala.aD();
    locala.aF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.card.MaterialCardView
 * JD-Core Version:    0.7.0.1
 */