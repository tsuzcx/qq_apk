package com.pay.ui.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class APRotateTextView
  extends TextView
{
  public int a;
  public int b;
  public int c = 10;
  public int d = 7;
  
  public APRotateTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramAttributeSet.getAttributeIntValue("http://www.tencent.com/apk/res/midas", "rotate", 0);
    this.b = paramAttributeSet.getAttributeIntValue("http://www.tencent.com/apk/res/midas", "bgColor", -16776961);
  }
  
  public final String a(CharSequence paramCharSequence)
  {
    String str = paramCharSequence.toString().trim();
    byte[] arrayOfByte = str.getBytes();
    if (arrayOfByte.length != str.length())
    {
      paramCharSequence = str;
      if (str.length() > 3)
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append(str.substring(0, 3));
        paramCharSequence.append("...");
        return paramCharSequence.toString();
      }
    }
    else
    {
      paramCharSequence = str;
      if (arrayOfByte.length > 6)
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append(new String(arrayOfByte, 0, 6));
        paramCharSequence.append("...");
        paramCharSequence = paramCharSequence.toString();
      }
    }
    return paramCharSequence;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    Object localObject = new Path();
    ((Path)localObject).moveTo(getMeasuredWidth() / 2, 0.0F);
    ((Path)localObject).lineTo(getMeasuredWidth(), getMeasuredHeight() * 3 / 4);
    ((Path)localObject).lineTo(getMeasuredWidth(), 0.0F);
    localObject = new ShapeDrawable(new PathShape((Path)localObject, getMeasuredWidth(), getMeasuredHeight()));
    ((ShapeDrawable)localObject).getPaint().setColor(this.b);
    ((ShapeDrawable)localObject).setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    ((ShapeDrawable)localObject).draw(paramCanvas);
    int i = APUICommonMethod.a(getContext(), this.c);
    int j = APUICommonMethod.a(getContext(), this.d);
    paramCanvas.rotate(this.a, getMeasuredWidth() - i, getMeasuredHeight() - j);
    super.onDraw(paramCanvas);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(a(paramCharSequence), paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APRotateTextView
 * JD-Core Version:    0.7.0.1
 */