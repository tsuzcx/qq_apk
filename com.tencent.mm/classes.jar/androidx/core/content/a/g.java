package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

public final class g
{
  public static float a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(250625);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(250625);
      return paramFloat;
    }
    paramFloat = paramTypedArray.getFloat(paramInt, paramFloat);
    AppMethodBeat.o(250625);
    return paramFloat;
  }
  
  public static int a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    AppMethodBeat.i(250629);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(250629);
      return 0;
    }
    paramInt = paramTypedArray.getColor(paramInt, 0);
    AppMethodBeat.o(250629);
    return paramInt;
  }
  
  public static int a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250627);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(250627);
      return paramInt2;
    }
    paramInt1 = paramTypedArray.getInt(paramInt1, paramInt2);
    AppMethodBeat.o(250627);
    return paramInt1;
  }
  
  public static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(250638);
    if (paramTheme == null)
    {
      paramResources = paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
      AppMethodBeat.o(250638);
      return paramResources;
    }
    paramResources = paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
    AppMethodBeat.o(250638);
    return paramResources;
  }
  
  public static TypedValue a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(250636);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(250636);
      return null;
    }
    paramTypedArray = paramTypedArray.peekValue(0);
    AppMethodBeat.o(250636);
    return paramTypedArray;
  }
  
  public static b a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt)
  {
    AppMethodBeat.i(250631);
    if (a(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt, paramXmlPullParser);
      if ((paramXmlPullParser.type >= 28) && (paramXmlPullParser.type <= 31))
      {
        paramTypedArray = b.bo(paramXmlPullParser.data);
        AppMethodBeat.o(250631);
        return paramTypedArray;
      }
      paramTypedArray = b.a(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt, 0), paramTheme);
      if (paramTypedArray != null)
      {
        AppMethodBeat.o(250631);
        return paramTypedArray;
      }
    }
    paramTypedArray = b.bo(0);
    AppMethodBeat.o(250631);
    return paramTypedArray;
  }
  
  public static boolean a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(250626);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(250626);
      return paramBoolean;
    }
    paramBoolean = paramTypedArray.getBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(250626);
    return paramBoolean;
  }
  
  public static boolean a(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(250624);
    if (paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null)
    {
      AppMethodBeat.o(250624);
      return true;
    }
    AppMethodBeat.o(250624);
    return false;
  }
  
  public static int b(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    AppMethodBeat.i(250633);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(250633);
      return 0;
    }
    paramInt = paramTypedArray.getResourceId(paramInt, 0);
    AppMethodBeat.o(250633);
    return paramInt;
  }
  
  public static String c(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    AppMethodBeat.i(250635);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(250635);
      return null;
    }
    paramTypedArray = paramTypedArray.getString(paramInt);
    AppMethodBeat.o(250635);
    return paramTypedArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.content.a.g
 * JD-Core Version:    0.7.0.1
 */