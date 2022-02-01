package android.support.v4.content.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Shader.TileMode;
import android.support.a.a.a;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class d
{
  static Shader.TileMode au(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Shader.TileMode.CLAMP;
    case 1: 
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.MIRROR;
  }
  
  static a e(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    int i = paramXmlPullParser.getDepth() + 1;
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList(20);
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.a.GradientColorItem);
        boolean bool1 = localTypedArray.hasValue(0);
        boolean bool2 = localTypedArray.hasValue(1);
        if ((!bool1) || (!bool2)) {
          throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
        }
        j = localTypedArray.getColor(0, 0);
        float f = localTypedArray.getFloat(1, 0.0F);
        localTypedArray.recycle();
        localArrayList2.add(Integer.valueOf(j));
        localArrayList1.add(Float.valueOf(f));
      }
    }
    if (localArrayList2.size() > 0) {
      return new a(localArrayList2, localArrayList1);
    }
    return null;
  }
  
  static final class a
  {
    final float[] GM;
    final int[] mColors;
    
    a(int paramInt1, int paramInt2)
    {
      this.mColors = new int[] { paramInt1, paramInt2 };
      this.GM = new float[] { 0.0F, 1.0F };
    }
    
    a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mColors = new int[] { paramInt1, paramInt2, paramInt3 };
      this.GM = new float[] { 0.0F, 0.5F, 1.0F };
    }
    
    a(List<Integer> paramList, List<Float> paramList1)
    {
      int j = paramList.size();
      this.mColors = new int[j];
      this.GM = new float[j];
      int i = 0;
      while (i < j)
      {
        this.mColors[i] = ((Integer)paramList.get(i)).intValue();
        this.GM[i] = ((Float)paramList1.get(i)).floatValue();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.a.d
 * JD-Core Version:    0.7.0.1
 */