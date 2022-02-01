package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import java.util.List;

public final class ax
  extends au<aq>
  implements Polyline
{
  @Deprecated
  public static final int a = 4;
  @Deprecated
  public static final int b = 3;
  @Deprecated
  public static final int c = 2;
  @Deprecated
  public static final int d = 1;
  @Deprecated
  public static final int e = 6;
  @Deprecated
  public static final int f = 0;
  @Deprecated
  public static final int g = 33;
  @Deprecated
  public static final int h = 19;
  public final aq i;
  
  public ax(aq paramaq)
  {
    this.i = paramaq;
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(224091);
    this.i.a(paramBoolean);
    AppMethodBeat.o(224091);
  }
  
  private aq b()
  {
    return this.i;
  }
  
  public final void addTurnArrow(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224174);
    this.i.addTurnArrow(paramInt1, paramInt2);
    AppMethodBeat.o(224174);
  }
  
  public final void appendPoint(LatLng... paramVarArgs)
  {
    AppMethodBeat.i(224144);
    this.i.appendPoint(paramVarArgs);
    AppMethodBeat.o(224144);
  }
  
  public final void appendPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(224155);
    this.i.appendPoints(paramList);
    AppMethodBeat.o(224155);
  }
  
  public final void cleanTurnArrow()
  {
    AppMethodBeat.i(224184);
    this.i.cleanTurnArrow();
    AppMethodBeat.o(224184);
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(224331);
    this.i.a(paramInt, paramLatLng);
    AppMethodBeat.o(224331);
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(224280);
    int j = this.i.getColor();
    AppMethodBeat.o(224280);
    return j;
  }
  
  public final int[][] getColors()
  {
    AppMethodBeat.i(224238);
    int[][] arrayOfInt = this.i.getColors();
    AppMethodBeat.o(224238);
    return arrayOfInt;
  }
  
  public final List<Integer> getPattern()
  {
    AppMethodBeat.i(224311);
    List localList = this.i.getPattern();
    AppMethodBeat.o(224311);
    return localList;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(224193);
    List localList = this.i.getPoints();
    AppMethodBeat.o(224193);
    return localList;
  }
  
  public final PolylineOptions getPolylineOptions()
  {
    AppMethodBeat.i(224124);
    PolylineOptions localPolylineOptions = this.i.getPolylineOptions();
    AppMethodBeat.o(224124);
    return localPolylineOptions;
  }
  
  public final Object getTag()
  {
    AppMethodBeat.i(224425);
    Object localObject = this.i.getTag();
    AppMethodBeat.o(224425);
    return localObject;
  }
  
  public final PolylineOptions.Text getText()
  {
    AppMethodBeat.i(224433);
    if (this.i == null)
    {
      AppMethodBeat.o(224433);
      return null;
    }
    PolylineOptions.Text localText = this.i.getText();
    AppMethodBeat.o(224433);
    return localText;
  }
  
  public final Rect getVisibleRect()
  {
    AppMethodBeat.i(224350);
    Rect localRect = this.i.getVisibleRect();
    AppMethodBeat.o(224350);
    return localRect;
  }
  
  public final float getWidth()
  {
    AppMethodBeat.i(224213);
    float f1 = this.i.getWidth();
    AppMethodBeat.o(224213);
    return f1;
  }
  
  public final boolean isAboveMaskLayer()
  {
    AppMethodBeat.i(224303);
    boolean bool = this.i.isAboveMaskLayer();
    AppMethodBeat.o(224303);
    return bool;
  }
  
  public final boolean isClickable()
  {
    AppMethodBeat.i(224408);
    if (this.i != null)
    {
      boolean bool = this.i.isClickable();
      AppMethodBeat.o(224408);
      return bool;
    }
    AppMethodBeat.o(224408);
    return false;
  }
  
  public final boolean isGradientEnable()
  {
    AppMethodBeat.i(224458);
    boolean bool = this.i.isGradientEnable();
    AppMethodBeat.o(224458);
    return bool;
  }
  
  public final void pattern(List<Integer> paramList)
  {
    AppMethodBeat.i(224319);
    this.i.pattern(paramList);
    AppMethodBeat.o(224319);
  }
  
  public final void setAboveMaskLayer(boolean paramBoolean)
  {
    AppMethodBeat.i(224291);
    this.i.setAboveMaskLayer(paramBoolean);
    AppMethodBeat.o(224291);
  }
  
  public final void setAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(224361);
    this.i.setAnimation(paramAnimation);
    AppMethodBeat.o(224361);
  }
  
  public final void setArrow(boolean paramBoolean)
  {
    AppMethodBeat.i(224247);
    this.i.setArrow(paramBoolean);
    AppMethodBeat.o(224247);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(224396);
    this.i.setClickable(paramBoolean);
    AppMethodBeat.o(224396);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(224221);
    this.i.setColor(paramInt);
    AppMethodBeat.o(224221);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(224268);
    this.i.setColorTexture(paramBitmapDescriptor);
    AppMethodBeat.o(224268);
  }
  
  public final void setColorTexture(String paramString)
  {
    AppMethodBeat.i(224259);
    this.i.setColorTexture(BitmapDescriptorFactory.fromAsset(paramString));
    AppMethodBeat.o(224259);
  }
  
  public final void setColors(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(224230);
    this.i.setColors(paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(224230);
  }
  
  public final void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(224341);
    this.i.setEraseable(paramBoolean);
    AppMethodBeat.o(224341);
  }
  
  public final void setGradientEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(224448);
    if (this.i == null)
    {
      AppMethodBeat.o(224448);
      return;
    }
    this.i.setGradientEnable(paramBoolean);
    AppMethodBeat.o(224448);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(224135);
    this.i.setPoints(paramList);
    AppMethodBeat.o(224135);
  }
  
  public final void setPolylineOptions(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(224113);
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(224113);
      return;
    }
    this.i.setPolylineOptions(paramPolylineOptions);
    AppMethodBeat.o(224113);
  }
  
  public final void setTag(Object paramObject)
  {
    AppMethodBeat.i(224417);
    this.i.setTag(paramObject);
    AppMethodBeat.o(224417);
  }
  
  public final void setText(PolylineOptions.Text paramText)
  {
    AppMethodBeat.i(224441);
    if (this.i == null)
    {
      AppMethodBeat.o(224441);
      return;
    }
    this.i.setText(paramText);
    AppMethodBeat.o(224441);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(224199);
    this.i.setWidth(paramFloat);
    AppMethodBeat.o(224199);
  }
  
  public final void startAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(224386);
    this.i.startAnimation(paramAnimation);
    AppMethodBeat.o(224386);
  }
  
  public final boolean startAnimation()
  {
    AppMethodBeat.i(224374);
    if (this.i != null)
    {
      boolean bool = this.i.startAnimation();
      AppMethodBeat.o(224374);
      return bool;
    }
    AppMethodBeat.o(224374);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ax
 * JD-Core Version:    0.7.0.1
 */