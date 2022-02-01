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
    AppMethodBeat.i(195591);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(195591);
      return paramFloat;
    }
    paramFloat = paramTypedArray.getFloat(paramInt, paramFloat);
    AppMethodBeat.o(195591);
    return paramFloat;
  }
  
  public static int a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    AppMethodBeat.i(195616);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(195616);
      return 0;
    }
    paramInt = paramTypedArray.getColor(paramInt, 0);
    AppMethodBeat.o(195616);
    return paramInt;
  }
  
  public static int a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195606);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(195606);
      return paramInt2;
    }
    paramInt1 = paramTypedArray.getInt(paramInt1, paramInt2);
    AppMethodBeat.o(195606);
    return paramInt1;
  }
  
  public static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195670);
    if (paramTheme == null)
    {
      paramResources = paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
      AppMethodBeat.o(195670);
      return paramResources;
    }
    paramResources = paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
    AppMethodBeat.o(195670);
    return paramResources;
  }
  
  public static TypedValue a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(195663);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(195663);
      return null;
    }
    paramTypedArray = paramTypedArray.peekValue(0);
    AppMethodBeat.o(195663);
    return paramTypedArray;
  }
  
  public static b a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt)
  {
    AppMethodBeat.i(195624);
    if (a(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt, paramXmlPullParser);
      if ((paramXmlPullParser.type >= 28) && (paramXmlPullParser.type <= 31))
      {
        paramTypedArray = b.ed(paramXmlPullParser.data);
        AppMethodBeat.o(195624);
        return paramTypedArray;
      }
      paramTypedArray = b.a(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt, 0), paramTheme);
      if (paramTypedArray != null)
      {
        AppMethodBeat.o(195624);
        return paramTypedArray;
      }
    }
    paramTypedArray = b.ed(0);
    AppMethodBeat.o(195624);
    return paramTypedArray;
  }
  
  public static boolean a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(195600);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(195600);
      return paramBoolean;
    }
    paramBoolean = paramTypedArray.getBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(195600);
    return paramBoolean;
  }
  
  public static boolean a(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(195585);
    if (paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null)
    {
      AppMethodBeat.o(195585);
      return true;
    }
    AppMethodBeat.o(195585);
    return false;
  }
  
  public static int b(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    AppMethodBeat.i(195634);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(195634);
      return 0;
    }
    paramInt = paramTypedArray.getResourceId(paramInt, 0);
    AppMethodBeat.o(195634);
    return paramInt;
  }
  
  public static String c(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    AppMethodBeat.i(195653);
    if (!a(paramXmlPullParser, paramString))
    {
      AppMethodBeat.o(195653);
      return null;
    }
    paramTypedArray = paramTypedArray.getString(paramInt);
    AppMethodBeat.o(195653);
    return paramTypedArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.content.a.g
 * JD-Core Version:    0.7.0.1
 */