package androidx.core.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b
{
  public final Shader JY;
  private final ColorStateList JZ;
  public int mColor;
  
  private b(Shader paramShader, ColorStateList paramColorStateList, int paramInt)
  {
    this.JY = paramShader;
    this.JZ = paramColorStateList;
    this.mColor = paramInt;
  }
  
  public static b a(Resources paramResources, @androidx.annotation.a int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(250591);
    XmlResourceParser localXmlResourceParser;
    AttributeSet localAttributeSet;
    try
    {
      localXmlResourceParser = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
      do
      {
        paramInt = localXmlResourceParser.next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2)
      {
        paramResources = new XmlPullParserException("No start tag found");
        AppMethodBeat.o(250591);
        throw paramResources;
      }
    }
    catch (Exception paramResources)
    {
      AppMethodBeat.o(250591);
      return null;
    }
    Object localObject = localXmlResourceParser.getName();
    paramInt = -1;
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
    switch (((String)localObject).hashCode())
    {
    case 1191572447: 
      paramResources = new XmlPullParserException(localXmlResourceParser.getPositionDescription() + ": unsupported complex color tag " + (String)localObject);
      AppMethodBeat.o(250591);
      throw paramResources;
      if (((String)localObject).equals("selector")) {
        paramInt = 0;
      }
      break;
    case 89650992: 
      if (((String)localObject).equals("gradient"))
      {
        paramInt = 1;
        break label656;
        paramResources = a.a(paramResources, localXmlResourceParser, localAttributeSet, paramTheme);
        paramResources = new b(null, paramResources, paramResources.getDefaultColor());
        AppMethodBeat.o(250591);
        return paramResources;
        localObject = localXmlResourceParser.getName();
        if (!((String)localObject).equals("gradient"))
        {
          paramResources = new XmlPullParserException(localXmlResourceParser.getPositionDescription() + ": invalid gradient color tag " + (String)localObject);
          AppMethodBeat.o(250591);
          throw paramResources;
        }
        localObject = g.a(paramResources, paramTheme, localAttributeSet, a.d.GradientColor);
        f1 = g.a((TypedArray)localObject, localXmlResourceParser, "startX", a.d.GradientColor_android_startX, 0.0F);
        f2 = g.a((TypedArray)localObject, localXmlResourceParser, "startY", a.d.GradientColor_android_startY, 0.0F);
        f3 = g.a((TypedArray)localObject, localXmlResourceParser, "endX", a.d.GradientColor_android_endX, 0.0F);
        f4 = g.a((TypedArray)localObject, localXmlResourceParser, "endY", a.d.GradientColor_android_endY, 0.0F);
        f5 = g.a((TypedArray)localObject, localXmlResourceParser, "centerX", a.d.GradientColor_android_centerX, 0.0F);
        f6 = g.a((TypedArray)localObject, localXmlResourceParser, "centerY", a.d.GradientColor_android_centerY, 0.0F);
        paramInt = g.a((TypedArray)localObject, localXmlResourceParser, "type", a.d.GradientColor_android_type, 0);
        i = g.a((TypedArray)localObject, localXmlResourceParser, "startColor", a.d.GradientColor_android_startColor);
        bool = g.a(localXmlResourceParser, "centerColor");
        j = g.a((TypedArray)localObject, localXmlResourceParser, "centerColor", a.d.GradientColor_android_centerColor);
        k = g.a((TypedArray)localObject, localXmlResourceParser, "endColor", a.d.GradientColor_android_endColor);
        m = g.a((TypedArray)localObject, localXmlResourceParser, "tileMode", a.d.GradientColor_android_tileMode, 0);
        f7 = g.a((TypedArray)localObject, localXmlResourceParser, "gradientRadius", a.d.GradientColor_android_gradientRadius, 0.0F);
        ((TypedArray)localObject).recycle();
        paramResources = d.c(paramResources, localXmlResourceParser, localAttributeSet, paramTheme);
        if (paramResources == null) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      paramResources = new LinearGradient(f1, f2, f3, f4, paramResources.mColors, paramResources.Kj, d.bp(m));
      for (;;)
      {
        paramResources = new b(paramResources, null, 0);
        AppMethodBeat.o(250591);
        return paramResources;
        if (bool)
        {
          paramResources = new d.a(i, j, k);
          break;
        }
        paramResources = new d.a(i, k);
        break;
        if (f7 <= 0.0F)
        {
          paramResources = new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
          AppMethodBeat.o(250591);
          throw paramResources;
        }
        paramResources = new RadialGradient(f5, f6, f7, paramResources.mColors, paramResources.Kj, d.bp(m));
        continue;
        paramResources = new SweepGradient(f5, f6, paramResources.mColors, paramResources.Kj);
      }
      label656:
      switch (paramInt)
      {
      }
      break;
      switch (paramInt)
      {
      }
    }
  }
  
  static b bo(int paramInt)
  {
    AppMethodBeat.i(250581);
    b localb = new b(null, null, paramInt);
    AppMethodBeat.o(250581);
    return localb;
  }
  
  public final boolean e(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(250583);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isStateful())
    {
      int i = this.JZ.getColorForState(paramArrayOfInt, this.JZ.getDefaultColor());
      bool1 = bool2;
      if (i != this.mColor)
      {
        bool1 = true;
        this.mColor = i;
      }
    }
    AppMethodBeat.o(250583);
    return bool1;
  }
  
  public final boolean gu()
  {
    return this.JY != null;
  }
  
  public final boolean gv()
  {
    AppMethodBeat.i(250584);
    if ((gu()) || (this.mColor != 0))
    {
      AppMethodBeat.o(250584);
      return true;
    }
    AppMethodBeat.o(250584);
    return false;
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(250582);
    if ((this.JY == null) && (this.JZ != null) && (this.JZ.isStateful()))
    {
      AppMethodBeat.o(250582);
      return true;
    }
    AppMethodBeat.o(250582);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.content.a.b
 * JD-Core Version:    0.7.0.1
 */