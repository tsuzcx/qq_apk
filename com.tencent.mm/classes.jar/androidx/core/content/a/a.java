package androidx.core.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.a.a;
import androidx.core.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final ThreadLocal<TypedValue> bqc;
  
  static
  {
    AppMethodBeat.i(195619);
    bqc = new ThreadLocal();
    AppMethodBeat.o(195619);
  }
  
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(195580);
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2)
    {
      paramResources = new XmlPullParserException("No start tag found");
      AppMethodBeat.o(195580);
      throw paramResources;
    }
    paramResources = a(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
    AppMethodBeat.o(195580);
    return paramResources;
  }
  
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(195590);
    String str = paramXmlPullParser.getName();
    if (!str.equals("selector"))
    {
      paramResources = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid color state list tag " + str);
      AppMethodBeat.o(195590);
      throw paramResources;
    }
    paramResources = b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    AppMethodBeat.o(195590);
    return paramResources;
  }
  
  private static ColorStateList b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(195612);
    int i1 = paramXmlPullParser.getDepth() + 1;
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
      if ((k < i1) && (i == 3)) {
        break;
      }
    } while ((i != 2) || (k > i1) || (!paramXmlPullParser.getName().equals("item")));
    Object localObject3 = a.d.ColorStateListItem;
    if (paramTheme == null)
    {
      localObject3 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject3);
      k = ((TypedArray)localObject3).getResourceId(a.d.ColorStateListItem_android_color, -1);
      if (k == -1) {
        break label363;
      }
      TypedValue localTypedValue2 = (TypedValue)bqc.get();
      TypedValue localTypedValue1 = localTypedValue2;
      if (localTypedValue2 == null)
      {
        localTypedValue1 = new TypedValue();
        bqc.set(localTypedValue1);
      }
      paramResources.getValue(k, localTypedValue1, true);
      if ((localTypedValue1.type < 28) || (localTypedValue1.type > 31)) {
        break label355;
      }
      i = 1;
      label197:
      if (i != 0) {
        break label363;
      }
    }
    label403:
    label411:
    label608:
    for (;;)
    {
      float f;
      int n;
      label355:
      try
      {
        k = a(paramResources, paramResources.getXml(k), paramTheme).getDefaultColor();
        f = 1.0F;
        if (!((TypedArray)localObject3).hasValue(a.d.ColorStateListItem_android_alpha)) {
          break label378;
        }
        f = ((TypedArray)localObject3).getFloat(a.d.ColorStateListItem_android_alpha, 1.0F);
        ((TypedArray)localObject3).recycle();
        i = 0;
        int i2 = paramAttributeSet.getAttributeCount();
        localObject3 = new int[i2];
        int m = 0;
        if (m >= i2) {
          break label411;
        }
        n = paramAttributeSet.getAttributeNameResource(m);
        if ((n == 16843173) || (n == 16843551) || (n == a.a.alpha)) {
          break label608;
        }
        if (!paramAttributeSet.getAttributeBooleanValue(m, false)) {
          break label403;
        }
        localObject3[i] = n;
        i += 1;
        m += 1;
        continue;
        localObject3 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject3, 0, 0);
      }
      catch (Exception localException) {}
      i = 0;
      break label197;
      label363:
      k = ((TypedArray)localObject3).getColor(a.d.ColorStateListItem_android_color, -65281);
      continue;
      label378:
      if (((TypedArray)localObject3).hasValue(a.d.ColorStateListItem_alpha))
      {
        f = ((TypedArray)localObject3).getFloat(a.d.ColorStateListItem_alpha, 1.0F);
        continue;
        n = -n;
        continue;
        int[] arrayOfInt = StateSet.trimStateSet((int[])localObject3, i);
        i = Math.round(f * Color.alpha(k));
        localObject3 = localObject2;
        if (j + 1 > localObject2.length)
        {
          localObject3 = new int[e.ef(j)];
          System.arraycopy(localObject2, 0, localObject3, 0, j);
        }
        localObject3[j] = (i << 24 | k & 0xFFFFFF);
        if (j + 1 > localObject1.length)
        {
          localObject2 = (Object[])Array.newInstance(localObject1.getClass().getComponentType(), e.ef(j));
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
          AppMethodBeat.o(195612);
          return paramResources;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.content.a.a
 * JD-Core Version:    0.7.0.1
 */