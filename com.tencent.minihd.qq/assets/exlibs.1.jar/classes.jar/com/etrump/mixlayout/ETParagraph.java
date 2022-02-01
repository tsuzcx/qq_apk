package com.etrump.mixlayout;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import java.util.ArrayList;

public class ETParagraph
{
  private int jdField_a_of_type_Int;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private QQText.EmotcationSpan jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  
  public ETParagraph(QQText.EmotcationSpan paramEmotcationSpan, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan = paramEmotcationSpan;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public ETParagraph(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return 0;
    }
    int j = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLock(paramString, this.e, 1073741823, this.f, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
    int k = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineTotal(j);
    if (k < 1)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutUnlock(j);
      return 0;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutHasPreLine(j) == true)
    {
      localObject = new ETFragment("");
      ((ETFragment)localObject).c(this.d);
      ((ETFragment)localObject).d(0);
      ((ETFragment)localObject).a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      this.f = 0;
      this.d += 1;
    }
    Object localObject = new ETFragment[k];
    int i = 0;
    while (i < k)
    {
      localObject[i] = new ETFragment("");
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      int m = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineRangeFrom(j, i);
      int n = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineRangeTo(j, i);
      int i1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineWidth(j, i);
      int i2 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineHeight(j, i);
      localObject[i].a(paramString.substring(m, n));
      localObject[i].a(i1);
      localObject[i].b(i2);
      localObject[i].c(this.d + i);
      localObject[i].d(0);
      localObject[i].a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject[i]);
      i += 1;
    }
    if (k == 1) {}
    for (this.f += localObject[0].a();; this.f = localObject[(k - 1)].a())
    {
      this.d += k - 1;
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutUnlock(j);
      return k;
    }
  }
  
  private void a(QQText.EmotcationSpan paramEmotcationSpan)
  {
    if (paramEmotcationSpan == null) {
      return;
    }
    Rect localRect = paramEmotcationSpan.a().getBounds();
    if (this.jdField_a_of_type_Boolean == true) {
      if (this.f != 0)
      {
        this.f = localRect.width();
        this.d += 1;
      }
    }
    for (;;)
    {
      paramEmotcationSpan = new ETFragment(paramEmotcationSpan);
      paramEmotcationSpan.c(this.d);
      paramEmotcationSpan.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramEmotcationSpan);
      if ((this.jdField_a_of_type_Boolean != true) || (this.f == 0)) {
        break;
      }
      this.f = 0;
      this.d += 1;
      return;
      if (this.f == 0)
      {
        this.f = localRect.width();
      }
      else if (this.e < localRect.width() + this.f)
      {
        this.f = localRect.width();
        this.d += 1;
      }
      else
      {
        int i = this.f;
        this.f = (localRect.width() + i);
      }
    }
  }
  
  private void a(String paramString)
  {
    int k = -1;
    int n = this.jdField_a_of_type_JavaLangString.length();
    int j = 0;
    if (j < n)
    {
      int m;
      int i;
      if ((Character.isHighSurrogate(this.jdField_a_of_type_JavaLangString.charAt(j))) && (j + 1 < n) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(j + 1))))
      {
        a(this.jdField_a_of_type_JavaLangString.substring(k + 1, j));
        c(this.jdField_a_of_type_JavaLangString.substring(j, j + 2));
        m = j + 1;
        i = m;
      }
      for (;;)
      {
        j = m + 1;
        k = i;
        break;
        m = j;
        i = k;
        if (j + 1 == n)
        {
          a(this.jdField_a_of_type_JavaLangString.substring(k + 1, n));
          i = n;
          m = j;
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    int m = -1;
    int n = this.jdField_a_of_type_JavaLangString.length();
    int i = 0;
    if (i < n)
    {
      char c1 = this.jdField_a_of_type_JavaLangString.charAt(i);
      int k;
      int j;
      if ((Character.isHighSurrogate(c1)) && (i + 1 < n) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(i + 1))))
      {
        a(this.jdField_a_of_type_JavaLangString.substring(m + 1, i));
        c(this.jdField_a_of_type_JavaLangString.substring(i, i + 2));
        k = i + 1;
        j = k;
      }
      for (;;)
      {
        i = k + 1;
        m = j;
        break;
        if (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isPaintableChar(c1, this.jdField_a_of_type_ComEtrumpMixlayoutETFont))
        {
          a(this.jdField_a_of_type_JavaLangString.substring(m + 1, i));
          c(String.valueOf(c1));
          j = i;
          k = i;
        }
        else
        {
          k = i;
          j = m;
          if (i + 1 == n)
          {
            a(this.jdField_a_of_type_JavaLangString.substring(m + 1, n));
            j = n;
            k = i;
          }
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = ETEngine.sysMeasureText(paramString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), 0);
    int j = ETEngine.sysFontHeight(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), 0);
    if (this.e < this.f + i)
    {
      this.f = i;
      this.d += 1;
    }
    for (;;)
    {
      paramString = new ETFragment(paramString);
      paramString.a(i);
      paramString.b(j);
      paramString.c(this.d);
      paramString.d(1);
      paramString.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      return;
      this.f += i;
    }
  }
  
  protected int a()
  {
    return this.f;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.d = paramInt3;
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan);
      return this.d;
    }
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return this.d;
    }
    if (ETEngine.getInstance().isEnableCallbackDrawing()) {
      a(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return this.d;
      b(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public ETFont a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(ETFont paramETFont)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETParagraph
 * JD-Core Version:    0.7.0.1
 */