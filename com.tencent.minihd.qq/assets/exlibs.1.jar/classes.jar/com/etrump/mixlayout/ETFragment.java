package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;

public class ETFragment
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
  private ETParagraph jdField_a_of_type_ComEtrumpMixlayoutETParagraph;
  private QQText.EmotcationSpan jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan;
  private String jdField_a_of_type_JavaLangString;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ETFragment(QQText.EmotcationSpan paramEmotcationSpan)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan = paramEmotcationSpan;
    if (paramEmotcationSpan != null)
    {
      paramEmotcationSpan = paramEmotcationSpan.a().getBounds();
      this.d = paramEmotcationSpan.width();
      this.e = paramEmotcationSpan.height();
    }
    this.g = 2;
  }
  
  public ETFragment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = -1;
    this.g = 0;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramInt2 += this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan.a().getBounds().height();
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan.draw(paramCanvas, null, 0, 0, paramInt1, 0, paramInt2, paramInt2, paramPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2)
  {
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint();
    }
    localPaint.reset();
    localPaint.setColor(paramETFont.getColor());
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setTextSize(paramETFont.getSize());
    int i = (int)localPaint.getFontMetrics().ascent;
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2 - i, localPaint);
  }
  
  private void b(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2)
  {
    if (paramPaint == null) {
      paramPaint = new Paint();
    }
    for (;;)
    {
      paramPaint.reset();
      paramPaint.setColor(paramETFont.getColor());
      paramPaint.setStrokeWidth(paramETFont.getSize() / 24);
      paramInt2 = this.e + paramInt2 - 2;
      int i = this.d;
      paramCanvas.drawLine(paramInt1, paramInt2, paramInt1 + i, paramInt2, paramPaint);
      return;
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public ETParagraph a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) || (paramBitmap == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph == null)) {}
    while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0) || (this.g != 0)) {
      return;
    }
    ETFont localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_drawText(this.jdField_a_of_type_JavaLangString, paramBitmap, paramInt1, paramInt2, localETFont);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint;
    if ((paramCanvas != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph != null))
    {
      localPaint = new Paint();
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a() == true)
      {
        localPaint.setColor(this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.d());
        localPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRect(new Rect(paramInt1, paramInt2, this.d + paramInt1, paramInt2 + paramInt3), localPaint);
      }
      paramInt2 += paramInt3 - this.e;
      if (this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan == null) {
        break label103;
      }
      a(paramCanvas, paramInt1, paramInt2, localPaint);
    }
    label103:
    ETFont localETFont;
    do
    {
      do
      {
        return;
        localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
      } while (localETFont == null);
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.b() == true) {
        b(paramCanvas, localPaint, localETFont, paramInt1, paramInt2);
      }
    } while ((this.jdField_a_of_type_JavaLangString == null) || (this.g != 1));
    a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2);
  }
  
  public void a(ETParagraph paramETParagraph)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph = paramETParagraph;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public void d(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETFragment
 * JD-Core Version:    0.7.0.1
 */