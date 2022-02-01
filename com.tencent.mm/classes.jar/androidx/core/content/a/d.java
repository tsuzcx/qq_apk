package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import androidx.core.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class d
{
  static Shader.TileMode bp(int paramInt)
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
  
  static a c(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(250614);
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
        TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.d.GradientColorItem);
        boolean bool1 = localTypedArray.hasValue(a.d.GradientColorItem_android_color);
        boolean bool2 = localTypedArray.hasValue(a.d.GradientColorItem_android_offset);
        if ((!bool1) || (!bool2))
        {
          paramResources = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
          AppMethodBeat.o(250614);
          throw paramResources;
        }
        j = localTypedArray.getColor(a.d.GradientColorItem_android_color, 0);
        float f = localTypedArray.getFloat(a.d.GradientColorItem_android_offset, 0.0F);
        localTypedArray.recycle();
        localArrayList2.add(Integer.valueOf(j));
        localArrayList1.add(Float.valueOf(f));
      }
    }
    if (localArrayList2.size() > 0)
    {
      paramResources = new a(localArrayList2, localArrayList1);
      AppMethodBeat.o(250614);
      return paramResources;
    }
    AppMethodBeat.o(250614);
    return null;
  }
  
  static final class a
  {
    final float[] Kj;
    final int[] mColors;
    
    a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(250611);
      this.mColors = new int[] { paramInt1, paramInt2 };
      this.Kj = new float[] { 0.0F, 1.0F };
      AppMethodBeat.o(250611);
    }
    
    a(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(250613);
      this.mColors = new int[] { paramInt1, paramInt2, paramInt3 };
      this.Kj = new float[] { 0.0F, 0.5F, 1.0F };
      AppMethodBeat.o(250613);
    }
    
    a(List<Integer> paramList, List<Float> paramList1)
    {
      AppMethodBeat.i(250609);
      int j = paramList.size();
      this.mColors = new int[j];
      this.Kj = new float[j];
      int i = 0;
      while (i < j)
      {
        this.mColors[i] = ((Integer)paramList.get(i)).intValue();
        this.Kj[i] = ((Float)paramList1.get(i)).floatValue();
        i += 1;
      }
      AppMethodBeat.o(250609);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.content.a.d
 * JD-Core Version:    0.7.0.1
 */