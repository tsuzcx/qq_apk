package com.etrump.mixlayout;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import ei;
import ej;
import java.util.ArrayList;
import java.util.Arrays;

public class ETLayout
{
  private static final int f = 2048;
  private static final int g = 2048;
  public int a;
  public long a;
  public Bitmap a;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
  public ETFont a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private ETTextLine[] jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
  public int b;
  public ETFont b;
  private boolean b;
  private int c = 0;
  private int d;
  private int e;
  
  ETLayout()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, "", 24.0F);
  }
  
  private static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramCharSequence == null) {
      return new String("");
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramCharSequence.length()) {
      paramInt1 = paramCharSequence.length();
    }
    paramInt2 = paramInt1 - i;
    if (paramInt2 <= 0) {
      return new String("");
    }
    char[] arrayOfChar = new char[paramInt2];
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      arrayOfChar[paramInt1] = paramCharSequence.charAt(paramInt1 + i);
      paramInt1 += 1;
    }
    return String.valueOf(arrayOfChar);
  }
  
  private final void a(Bitmap paramBitmap)
  {
    int k;
    int i;
    int j;
    if ((paramBitmap != null) && (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null))
    {
      k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a(paramBitmap, 0, j);
        j += this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a();
        if (j < paramBitmap.getHeight()) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(QQText.EmotcationSpan paramEmotcationSpan, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramEmotcationSpan = new ETParagraph(paramEmotcationSpan, paramInt1, paramInt2, paramBoolean);
    paramEmotcationSpan.a(this.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramEmotcationSpan);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean);
    paramString.a(this.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null) {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = null;
    }
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    int j = 0;
    int k = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      k = ((ETParagraph)localObject).a(paramInt, j, k);
      j = ((ETParagraph)localObject).a();
      i += 1;
    }
    j = k + 1;
    this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = new ETTextLine[j];
    paramInt = 0;
    while (paramInt < j)
    {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt] = new ETTextLine();
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < m)
    {
      localObject = ((ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
      i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        ETFragment localETFragment = (ETFragment)((ArrayList)localObject).get(i);
        k = localETFragment.c();
        if ((k >= 0) && (k < j)) {
          this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[k].a(localETFragment);
        }
        i += 1;
      }
      paramInt += 1;
    }
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      localObject = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt];
      ((ETTextLine)localObject).a(0, i);
      i += ((ETTextLine)localObject).a();
      paramInt += 1;
    }
  }
  
  private final void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < k)
    {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a(paramCanvas, paramInt1, i);
      i += this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a();
      paramInt2 += 1;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      if ((this.jdField_a_of_type_JavaLangCharSequence instanceof Spanned)) {
        f();
      }
    }
    else {
      return;
    }
    a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
  }
  
  private void f()
  {
    Spanned localSpanned = (Spanned)this.jdField_a_of_type_JavaLangCharSequence;
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])localSpanned.getSpans(0, localSpanned.length(), CharacterStyle.class);
    ej[] arrayOfej = new ej[arrayOfCharacterStyle.length];
    if ((arrayOfej == null) || (arrayOfej.length == 0))
    {
      a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      return;
    }
    int i = 0;
    while (i < arrayOfCharacterStyle.length)
    {
      arrayOfej[i] = new ej();
      arrayOfej[i].jdField_a_of_type_Int = localSpanned.getSpanStart(arrayOfCharacterStyle[i]);
      arrayOfej[i].jdField_b_of_type_Int = localSpanned.getSpanEnd(arrayOfCharacterStyle[i]);
      arrayOfej[i].jdField_a_of_type_AndroidTextStyleCharacterStyle = arrayOfCharacterStyle[i];
      i += 1;
    }
    Arrays.sort(arrayOfej, new ei());
    i = 0;
    int j = 0;
    label169:
    int m;
    int k;
    if (i < arrayOfCharacterStyle.length)
    {
      m = arrayOfej[i].jdField_a_of_type_Int;
      k = arrayOfej[i].jdField_b_of_type_Int;
      if (m - j > 0) {
        a(a(this.jdField_a_of_type_JavaLangCharSequence, j, m).toString(), j, m, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      }
      if (k - m > 0)
      {
        if (!(arrayOfej[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof ClickableSpan)) {
          break label372;
        }
        if ((m <= 0) || (this.jdField_a_of_type_JavaLangCharSequence.charAt(m - 1) != '\024')) {
          break label406;
        }
      }
    }
    label406:
    for (j = m + 1;; j = m)
    {
      a(a(this.jdField_a_of_type_JavaLangCharSequence, j, k).toString(), j, k, this.jdField_b_of_type_ComEtrumpMixlayoutETFont, true);
      for (;;)
      {
        if ((i == arrayOfCharacterStyle.length - 1) && (k < this.jdField_a_of_type_JavaLangCharSequence.length())) {
          a(a(this.jdField_a_of_type_JavaLangCharSequence, k, this.jdField_a_of_type_JavaLangCharSequence.length()).toString(), k, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
        }
        i += 1;
        j = k;
        break label169;
        break;
        label372:
        if ((arrayOfej[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof QQText.EmotcationSpan)) {
          a((QQText.EmotcationSpan)arrayOfej[i].jdField_a_of_type_AndroidTextStyleCharacterStyle, m, k, false);
        }
      }
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    if (i < j)
    {
      localRect.left = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].c();
      localRect.top = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].d();
      localRect.right = (localRect.left + this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].b());
      localRect.bottom = (localRect.top + this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a());
      if (!localRect.contains(paramInt1, paramInt2)) {}
      ETFragment localETFragment;
      do
      {
        i += 1;
        break;
        localETFragment = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a(paramInt1);
      } while (localETFragment == null);
      return localETFragment.a().b();
    }
    return -1;
  }
  
  public Rect a()
  {
    return new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  protected void a()
  {
    this.c += 1;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      ETParagraph localETParagraph = (ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
      if ((paramInt1 >= localETParagraph.b()) && (paramInt1 < localETParagraph.c())) {
        localETParagraph.a(paramBoolean);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localETParagraph.a(false);
      }
    }
  }
  
  public void a(int paramInt1, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2)
  {
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_b_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.setId(paramETFont.getId());
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.setPath(paramETFont.getPath());
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.setSize(paramETFont.getSize());
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.setColor(paramInt2);
    }
    e();
    if (this.jdField_a_of_type_Boolean) {
      throw new Exception("no text use system draw");
    }
    b(paramInt1);
    if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine == null) {
      throw new Exception("measure textLines fail");
    }
    int k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    paramInt2 = 0;
    int i = 0;
    paramInt1 = 0;
    int m;
    if (paramInt2 < k)
    {
      int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].b();
      m = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a();
      if (j <= paramInt1) {
        break label267;
      }
      paramInt1 = j;
    }
    label267:
    for (;;)
    {
      i += m;
      paramInt2 += 1;
      break;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = i;
      if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0)) {
        throw new Exception("mesure fail mWidth=" + this.jdField_a_of_type_Int + ",mHeight" + this.jdField_b_of_type_Int);
      }
      c();
      return;
    }
  }
  
  @TargetApi(14)
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int j = 2048;
    if (paramCanvas == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    int i2;
    int k;
    int i;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      i2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      if (Build.VERSION.SDK_INT < 14) {
        break label259;
      }
      i = paramCanvas.getMaximumBitmapHeight();
      j = paramCanvas.getMaximumBitmapWidth();
    }
    for (;;)
    {
      if ((i2 <= j) && (k <= i)) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
      }
      for (;;)
      {
        paramCanvas.restore();
        b(paramCanvas, paramInt1, paramInt2);
        return;
        Rect localRect = new Rect(0, 0, 0, 0);
        while (k > 0)
        {
          int n;
          int m;
          if (k >= i)
          {
            n = i;
            localRect.left = 0;
            localRect.bottom += n;
            m = i2;
            label157:
            if (m <= 0) {
              break label236;
            }
            if (m < j) {
              break label229;
            }
          }
          label229:
          for (int i1 = j;; i1 = m)
          {
            m -= i1;
            localRect.right += i1;
            paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect, localRect, null);
            localRect.left = (i1 + localRect.left);
            break label157;
            n = k;
            break;
          }
          label236:
          localRect.top = (n + localRect.top);
          k -= n;
        }
      }
      label259:
      i = 2048;
    }
  }
  
  public boolean a(long paramLong, ETFont paramETFont)
  {
    return (this.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(paramETFont));
  }
  
  protected void b()
  {
    if (this.c > 0) {
      this.c -= 1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
    a(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = null;
    this.jdField_b_of_type_ComEtrumpMixlayoutETFont = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETLayout
 * JD-Core Version:    0.7.0.1
 */