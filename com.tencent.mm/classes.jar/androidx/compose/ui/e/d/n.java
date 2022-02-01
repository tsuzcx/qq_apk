package androidx.compose.ui.e.d;

import androidx.compose.ui.e.aq;
import androidx.compose.ui.e.bb;
import androidx.compose.ui.e.bc;
import androidx.compose.ui.e.p;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"DefaultFillType", "Landroidx/compose/ui/graphics/PathFillType;", "getDefaultFillType", "()I", "I", "DefaultGroupName", "", "DefaultPathName", "DefaultPivotX", "", "DefaultPivotY", "DefaultRotation", "DefaultScaleX", "DefaultScaleY", "DefaultStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultStrokeLineCap", "DefaultStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultStrokeLineJoin", "DefaultStrokeLineMiter", "DefaultStrokeLineWidth", "DefaultTintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultTintBlendMode", "DefaultTintColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultTintColor", "()J", "J", "DefaultTranslationX", "DefaultTranslationY", "DefaultTrimPathEnd", "DefaultTrimPathOffset", "DefaultTrimPathStart", "EmptyPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "getEmptyPath", "()Ljava/util/List;", "PathData", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "Lkotlin/ExtensionFunctionType;", "addPathNodes", "pathStr", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class n
{
  private static final List<f> aDk;
  private static final int aDl;
  private static final int aDm;
  private static final int aDn;
  private static final long aDo;
  private static final int aDp;
  
  static
  {
    AppMethodBeat.i(206422);
    aDk = (List)ab.aivy;
    Object localObject = bb.ayr;
    aDl = bb.tO();
    localObject = bc.ayv;
    aDm = bc.tR();
    localObject = p.avT;
    aDn = p.sW();
    localObject = z.awK;
    aDo = z.tz();
    localObject = aq.axV;
    aDp = aq.tI();
    AppMethodBeat.o(206422);
  }
  
  public static final List<f> ak(String paramString)
  {
    AppMethodBeat.i(206416);
    if (paramString == null)
    {
      paramString = aDk;
      AppMethodBeat.o(206416);
      return paramString;
    }
    g localg = new g();
    s.u(paramString, "pathData");
    localg.nodes.clear();
    int j = 0;
    int i = 1;
    Object localObject;
    int k;
    int m;
    label170:
    label210:
    String str1;
    label326:
    float[] arrayOfFloat;
    label356:
    int i2;
    int i3;
    int i1;
    label380:
    int i5;
    if (i < paramString.length())
    {
      int n = i;
      while (n < paramString.length())
      {
        i = paramString.charAt(n);
        if ((((i - 65) * (i - 90) <= 0) || ((i - 97) * (i - 122) <= 0)) && (i != 101) && (i != 69)) {
          break;
        }
        n += 1;
      }
      localObject = paramString.substring(j, n);
      s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject = (CharSequence)localObject;
      j = 0;
      i = ((CharSequence)localObject).length() - 1;
      k = 0;
      while (j <= i)
      {
        if (k == 0)
        {
          m = j;
          if (s.compare(((CharSequence)localObject).charAt(m), 32) > 0) {
            break label210;
          }
          m = 1;
        }
        for (;;)
        {
          if (k == 0)
          {
            if (m == 0)
            {
              k = 1;
              break;
              m = i;
              break label170;
              m = 0;
              continue;
            }
            j += 1;
            break;
          }
        }
        if (m == 0) {
          break;
        }
        i -= 1;
      }
      str1 = ((CharSequence)localObject).subSequence(j, i + 1).toString();
      if (((CharSequence)str1).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          if ((str1.charAt(0) != 'z') && (str1.charAt(0) != 'Z')) {
            break label326;
          }
          localObject = new float[0];
          localg.a(str1.charAt(0), (float[])localObject);
        }
        i = n + 1;
        j = n;
        break;
      }
      arrayOfFloat = new float[str1.length()];
      j = 1;
      localObject = new g.a((byte)0);
      int i4 = str1.length();
      k = 0;
      if (j < i4)
      {
        m = 0;
        ((g.a)localObject).aCd = false;
        i2 = 0;
        i3 = 0;
        i1 = j;
        if (i1 < str1.length())
        {
          i5 = str1.charAt(i1);
          if (i5 == 32)
          {
            i = 1;
            label408:
            if (i == 0) {
              break label451;
            }
            m = 1;
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (m == 0)
      {
        i1 += 1;
        i3 = i;
        break label380;
        if (i5 == 44)
        {
          i = 1;
          break label408;
        }
        i = 0;
        break label408;
        label451:
        if (i5 == 45)
        {
          if ((i1 == j) || (i3 != 0)) {
            break label769;
          }
          m = 1;
          ((g.a)localObject).aCd = true;
          i = 0;
          continue;
        }
        if (i5 == 46)
        {
          if (i2 == 0)
          {
            i2 = 1;
            i = 0;
            continue;
          }
          m = 1;
          ((g.a)localObject).aCd = true;
          i = 0;
          continue;
        }
        if (i5 == 101) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label769;
          }
          i = 1;
          break;
          if (i5 == 69) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      ((g.a)localObject).aCc = i1;
      m = ((g.a)localObject).aCc;
      if (j < m)
      {
        i = k + 1;
        if (str1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(206416);
          throw paramString;
        }
        String str2 = str1.substring(j, m);
        s.s(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        arrayOfFloat[k] = Float.parseFloat(str2);
      }
      for (;;)
      {
        if (((g.a)localObject).aCd)
        {
          j = m;
          k = i;
          break label356;
        }
        j = m + 1;
        k = i;
        break label356;
        if (k < 0)
        {
          paramString = new IllegalArgumentException();
          AppMethodBeat.o(206416);
          throw paramString;
        }
        i = arrayOfFloat.length;
        if (i < 0)
        {
          paramString = new IndexOutOfBoundsException();
          AppMethodBeat.o(206416);
          throw paramString;
        }
        j = k + 0;
        i = Math.min(j, i + 0);
        localObject = new float[j];
        k.a(arrayOfFloat, (float[])localObject, i + 0);
        break;
        if ((i - j == 1) && (j < paramString.length())) {
          localg.a(paramString.charAt(j), new float[0]);
        }
        paramString = localg.nodes;
        AppMethodBeat.o(206416);
        return paramString;
        i = k;
      }
      label769:
      i = 0;
    }
  }
  
  public static final List<f> uX()
  {
    return aDk;
  }
  
  public static final int uY()
  {
    return aDl;
  }
  
  public static final int uZ()
  {
    return aDm;
  }
  
  public static final int va()
  {
    return aDp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.n
 * JD-Core Version:    0.7.0.1
 */