package android.support.v4.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.a.a.a;
import android.util.AttributeSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b
{
  public final Shader GB;
  private final ColorStateList GC;
  public int mColor;
  
  private b(Shader paramShader, ColorStateList paramColorStateList, int paramInt)
  {
    this.GB = paramShader;
    this.GC = paramColorStateList;
    this.mColor = paramInt;
  }
  
  static b at(int paramInt)
  {
    return new b(null, null, paramInt);
  }
  
  public static b b(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      localXmlResourceParser = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
      do
      {
        paramInt = localXmlResourceParser.next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
      localObject = localXmlResourceParser.getName();
      paramInt = -1;
      switch (((String)localObject).hashCode())
      {
      case 1191572447: 
        throw new XmlPullParserException(localXmlResourceParser.getPositionDescription() + ": unsupported complex color tag " + (String)localObject);
      }
    }
    catch (Exception paramResources)
    {
      XmlResourceParser localXmlResourceParser;
      AttributeSet localAttributeSet;
      Object localObject;
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      int i;
      boolean bool;
      int j;
      int k;
      int m;
      float f7;
      return null;
    }
    if (((String)localObject).equals("selector"))
    {
      paramInt = 0;
      break label586;
      if (((String)localObject).equals("gradient"))
      {
        paramInt = 1;
        break label586;
        paramResources = a.c(paramResources, localXmlResourceParser, localAttributeSet, paramTheme);
        return new b(null, paramResources, paramResources.getDefaultColor());
        localObject = localXmlResourceParser.getName();
        if (!((String)localObject).equals("gradient")) {
          throw new XmlPullParserException(localXmlResourceParser.getPositionDescription() + ": invalid gradient color tag " + (String)localObject);
        }
        localObject = g.a(paramResources, paramTheme, localAttributeSet, a.a.GradientColor);
        f1 = g.a((TypedArray)localObject, localXmlResourceParser, "startX", 8, 0.0F);
        f2 = g.a((TypedArray)localObject, localXmlResourceParser, "startY", 9, 0.0F);
        f3 = g.a((TypedArray)localObject, localXmlResourceParser, "endX", 10, 0.0F);
        f4 = g.a((TypedArray)localObject, localXmlResourceParser, "endY", 11, 0.0F);
        f5 = g.a((TypedArray)localObject, localXmlResourceParser, "centerX", 3, 0.0F);
        f6 = g.a((TypedArray)localObject, localXmlResourceParser, "centerY", 4, 0.0F);
        paramInt = g.a((TypedArray)localObject, localXmlResourceParser, "type", 2, 0);
        i = g.a((TypedArray)localObject, localXmlResourceParser, "startColor", 0);
        bool = g.a(localXmlResourceParser, "centerColor");
        j = g.a((TypedArray)localObject, localXmlResourceParser, "centerColor", 7);
        k = g.a((TypedArray)localObject, localXmlResourceParser, "endColor", 1);
        m = g.a((TypedArray)localObject, localXmlResourceParser, "tileMode", 6, 0);
        f7 = g.a((TypedArray)localObject, localXmlResourceParser, "gradientRadius", 5, 0.0F);
        ((TypedArray)localObject).recycle();
        paramResources = d.e(paramResources, localXmlResourceParser, localAttributeSet, paramTheme);
        if (paramResources != null) {
          break label611;
        }
      }
    }
    for (;;)
    {
      paramResources = new LinearGradient(f1, f2, f3, f4, paramResources.mColors, paramResources.GM, d.au(m));
      for (;;)
      {
        return new b(paramResources, null, 0);
        if (bool)
        {
          paramResources = new d.a(i, j, k);
          break;
        }
        paramResources = new d.a(i, k);
        break;
        if (f7 <= 0.0F) {
          throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        paramResources = new RadialGradient(f5, f6, f7, paramResources.mColors, paramResources.GM, d.au(m));
        continue;
        paramResources = new SweepGradient(f5, f6, paramResources.mColors, paramResources.GM);
      }
      label586:
      switch (paramInt)
      {
      }
      break;
      label611:
      switch (paramInt)
      {
      }
    }
  }
  
  public final boolean dR()
  {
    return this.GB != null;
  }
  
  public final boolean dS()
  {
    return (dR()) || (this.mColor != 0);
  }
  
  public final boolean e(int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isStateful())
    {
      int i = this.GC.getColorForState(paramArrayOfInt, this.GC.getDefaultColor());
      bool1 = bool2;
      if (i != this.mColor)
      {
        bool1 = true;
        this.mColor = i;
      }
    }
    return bool1;
  }
  
  public final boolean isStateful()
  {
    return (this.GB == null) && (this.GC != null) && (this.GC.isStateful());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.a.b
 * JD-Core Version:    0.7.0.1
 */