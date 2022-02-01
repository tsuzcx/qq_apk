package android.support.v4.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.a.a.a;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  public static ColorStateList c(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    String str = paramXmlPullParser.getName();
    if (!str.equals("selector")) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid color state list tag " + str);
    }
    return d(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public static ColorStateList createFromXml(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    return c(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
  }
  
  private static ColorStateList d(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    int n = paramXmlPullParser.getDepth() + 1;
    Object localObject1 = new int[20][];
    int[] arrayOfInt = new int[20];
    int j = 0;
    int i;
    int k;
    do
    {
      i = paramXmlPullParser.next();
      if (i == 1) {
        break;
      }
      k = paramXmlPullParser.getDepth();
      if ((k < n) && (i == 3)) {
        break;
      }
    } while ((i != 2) || (k > n) || (!paramXmlPullParser.getName().equals("item")));
    Object localObject2 = a.a.ColorStateListItem;
    label106:
    int i1;
    float f;
    label137:
    label162:
    int m;
    if (paramTheme == null)
    {
      localObject2 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject2);
      i1 = ((TypedArray)localObject2).getColor(0, -65281);
      f = 1.0F;
      if (!((TypedArray)localObject2).hasValue(1)) {
        break label248;
      }
      f = ((TypedArray)localObject2).getFloat(1, 1.0F);
      ((TypedArray)localObject2).recycle();
      i = 0;
      int i2 = paramAttributeSet.getAttributeCount();
      localObject2 = new int[i2];
      k = 0;
      if (k >= i2) {
        break label277;
      }
      m = paramAttributeSet.getAttributeNameResource(k);
      if ((m == 16843173) || (m == 16843551) || (m == 2130968649)) {
        break label380;
      }
      if (!paramAttributeSet.getAttributeBooleanValue(k, false)) {
        break label269;
      }
      label212:
      localObject2[i] = m;
      i += 1;
    }
    label248:
    label380:
    for (;;)
    {
      k += 1;
      break label162;
      localObject2 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, 0, 0);
      break label106;
      if (!((TypedArray)localObject2).hasValue(2)) {
        break label137;
      }
      f = ((TypedArray)localObject2).getFloat(2, 1.0F);
      break label137;
      m = -m;
      break label212;
      localObject2 = StateSet.trimStateSet((int[])localObject2, i);
      arrayOfInt = e.a(arrayOfInt, j, Math.round(f * Color.alpha(i1)) << 24 | 0xFFFFFF & i1);
      localObject1 = (int[][])e.a((Object[])localObject1, j, localObject2);
      j += 1;
      break;
      paramResources = new int[j];
      paramXmlPullParser = new int[j][];
      System.arraycopy(arrayOfInt, 0, paramResources, 0, j);
      System.arraycopy(localObject1, 0, paramXmlPullParser, 0, j);
      return new ColorStateList(paramXmlPullParser, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.a.a
 * JD-Core Version:    0.7.0.1
 */