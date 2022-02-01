package androidx.core.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.core.a.a;
import androidx.core.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(250575);
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2)
    {
      paramResources = new XmlPullParserException("No start tag found");
      AppMethodBeat.o(250575);
      throw paramResources;
    }
    paramResources = a(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
    AppMethodBeat.o(250575);
    return paramResources;
  }
  
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(250578);
    String str = paramXmlPullParser.getName();
    if (!str.equals("selector"))
    {
      paramResources = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid color state list tag " + str);
      AppMethodBeat.o(250578);
      throw paramResources;
    }
    paramResources = b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    AppMethodBeat.o(250578);
    return paramResources;
  }
  
  private static ColorStateList b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(250579);
    int n = paramXmlPullParser.getDepth() + 1;
    Object localObject1 = new int[20][];
    Object localObject2 = new int[20];
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
    Object localObject3 = a.d.ColorStateListItem;
    label111:
    int i1;
    float f;
    label148:
    label173:
    int m;
    if (paramTheme == null)
    {
      localObject3 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject3);
      i1 = ((TypedArray)localObject3).getColor(a.d.ColorStateListItem_android_color, -65281);
      f = 1.0F;
      if (!((TypedArray)localObject3).hasValue(a.d.ColorStateListItem_android_alpha)) {
        break label260;
      }
      f = ((TypedArray)localObject3).getFloat(a.d.ColorStateListItem_android_alpha, 1.0F);
      ((TypedArray)localObject3).recycle();
      i = 0;
      int i2 = paramAttributeSet.getAttributeCount();
      localObject3 = new int[i2];
      k = 0;
      if (k >= i2) {
        break label293;
      }
      m = paramAttributeSet.getAttributeNameResource(k);
      if ((m == 16843173) || (m == 16843551) || (m == a.a.alpha)) {
        break label490;
      }
      if (!paramAttributeSet.getAttributeBooleanValue(k, false)) {
        break label285;
      }
      label224:
      localObject3[i] = m;
      i += 1;
    }
    label260:
    label285:
    label293:
    label490:
    for (;;)
    {
      k += 1;
      break label173;
      localObject3 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject3, 0, 0);
      break label111;
      if (!((TypedArray)localObject3).hasValue(a.d.ColorStateListItem_alpha)) {
        break label148;
      }
      f = ((TypedArray)localObject3).getFloat(a.d.ColorStateListItem_alpha, 1.0F);
      break label148;
      m = -m;
      break label224;
      int[] arrayOfInt = StateSet.trimStateSet((int[])localObject3, i);
      i = Math.round(Color.alpha(i1) * f);
      localObject3 = localObject2;
      if (j + 1 > localObject2.length)
      {
        localObject3 = new int[e.bq(j)];
        System.arraycopy(localObject2, 0, localObject3, 0, j);
      }
      localObject3[j] = (0xFFFFFF & i1 | i << 24);
      if (j + 1 > localObject1.length)
      {
        localObject2 = (Object[])Array.newInstance(localObject1.getClass().getComponentType(), e.bq(j));
        System.arraycopy(localObject1, 0, localObject2, 0, j);
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1[j] = arrayOfInt;
        localObject1 = (int[][])localObject1;
        j += 1;
        localObject2 = localObject3;
        break;
        paramResources = new int[j];
        paramXmlPullParser = new int[j][];
        System.arraycopy(localObject2, 0, paramResources, 0, j);
        System.arraycopy(localObject1, 0, paramXmlPullParser, 0, j);
        paramResources = new ColorStateList(paramXmlPullParser, paramResources);
        AppMethodBeat.o(250579);
        return paramResources;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.content.a.a
 * JD-Core Version:    0.7.0.1
 */