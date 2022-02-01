package androidx.l.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.a.g;
import androidx.core.graphics.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public final class e
{
  /* Error */
  public static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: ldc 13
    //   11: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: iload_3
    //   16: invokevirtual 25	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   19: astore 7
    //   21: aload 7
    //   23: astore 5
    //   25: aload 7
    //   27: astore 4
    //   29: aload 7
    //   31: astore 6
    //   33: aload_0
    //   34: aload_1
    //   35: aload_2
    //   36: aload 7
    //   38: aload 7
    //   40: invokestatic 31	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   43: aconst_null
    //   44: iconst_0
    //   45: fconst_1
    //   46: invokestatic 34	androidx/l/a/a/e:a	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;
    //   49: astore_0
    //   50: aload 7
    //   52: ifnull +10 -> 62
    //   55: aload 7
    //   57: invokeinterface 40 1 0
    //   62: ldc 13
    //   64: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: areturn
    //   69: astore_0
    //   70: aload 5
    //   72: astore 4
    //   74: new 45	android/content/res/Resources$NotFoundException
    //   77: dup
    //   78: new 47	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 49
    //   84: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: iload_3
    //   88: invokestatic 59	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   91: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 68	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   100: astore_1
    //   101: aload 5
    //   103: astore 4
    //   105: aload_1
    //   106: aload_0
    //   107: invokevirtual 72	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   110: pop
    //   111: aload 5
    //   113: astore 4
    //   115: ldc 13
    //   117: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload 5
    //   122: astore 4
    //   124: aload_1
    //   125: athrow
    //   126: astore_0
    //   127: aload 4
    //   129: ifnull +10 -> 139
    //   132: aload 4
    //   134: invokeinterface 40 1 0
    //   139: ldc 13
    //   141: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: aload 6
    //   149: astore 4
    //   151: new 45	android/content/res/Resources$NotFoundException
    //   154: dup
    //   155: new 47	java/lang/StringBuilder
    //   158: dup
    //   159: ldc 49
    //   161: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: iload_3
    //   165: invokestatic 59	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   168: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 68	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   177: astore_1
    //   178: aload 6
    //   180: astore 4
    //   182: aload_1
    //   183: aload_0
    //   184: invokevirtual 72	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   187: pop
    //   188: aload 6
    //   190: astore 4
    //   192: ldc 13
    //   194: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload 6
    //   199: astore 4
    //   201: aload_1
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramContext	Context
    //   0	203	1	paramResources	Resources
    //   0	203	2	paramTheme	Resources.Theme
    //   0	203	3	paramInt	int
    //   1	199	4	localObject1	Object
    //   7	114	5	localObject2	Object
    //   4	194	6	localObject3	Object
    //   19	37	7	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   14	21	69	org/xmlpull/v1/XmlPullParserException
    //   33	50	69	org/xmlpull/v1/XmlPullParserException
    //   14	21	126	finally
    //   33	50	126	finally
    //   74	101	126	finally
    //   105	111	126	finally
    //   115	120	126	finally
    //   124	126	126	finally
    //   151	178	126	finally
    //   182	188	126	finally
    //   192	197	126	finally
    //   201	203	126	finally
    //   14	21	146	java/io/IOException
    //   33	50	146	java/io/IOException
  }
  
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(192697);
    Object localObject2 = null;
    ArrayList localArrayList = null;
    int j = paramXmlPullParser.getDepth();
    int i;
    Object localObject1;
    label90:
    do
    {
      do
      {
        do
        {
          i = paramXmlPullParser.next();
          if (((i == 3) && (paramXmlPullParser.getDepth() <= j)) || (i == 1)) {
            break;
          }
        } while (i != 2);
        localObject1 = paramXmlPullParser.getName();
        if (!((String)localObject1).equals("objectAnimator")) {
          break;
        }
        localObject1 = a(paramContext, paramResources, paramTheme, paramAttributeSet, paramFloat, paramXmlPullParser);
        i = 0;
        localObject2 = localObject1;
      } while (paramAnimatorSet == null);
      localObject2 = localObject1;
    } while (i != 0);
    if (localArrayList == null) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      localArrayList.add(localObject1);
      localObject2 = localObject1;
      break;
      if (((String)localObject1).equals("animator"))
      {
        localObject1 = a(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
        i = 0;
        break label90;
      }
      if (((String)localObject1).equals("set"))
      {
        localObject1 = new AnimatorSet();
        localObject2 = g.a(paramResources, paramTheme, paramAttributeSet, a.aEH);
        i = g.a((TypedArray)localObject2, paramXmlPullParser, "ordering", 0, 0);
        a(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, i, paramFloat);
        ((TypedArray)localObject2).recycle();
        i = 0;
        break label90;
      }
      if (((String)localObject1).equals("propertyValuesHolder"))
      {
        localObject1 = a(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof ValueAnimator))) {
          ((ValueAnimator)localObject2).setValues((PropertyValuesHolder[])localObject1);
        }
        i = 1;
        localObject1 = localObject2;
        break label90;
      }
      paramContext = new RuntimeException("Unknown animator name: " + paramXmlPullParser.getName());
      AppMethodBeat.o(192697);
      throw paramContext;
      if ((paramAnimatorSet != null) && (localArrayList != null))
      {
        paramContext = new Animator[localArrayList.size()];
        paramResources = localArrayList.iterator();
        i = 0;
        while (paramResources.hasNext())
        {
          paramContext[i] = ((Animator)paramResources.next());
          i += 1;
        }
        if (paramInt != 0) {
          break label415;
        }
        paramAnimatorSet.playTogether(paramContext);
      }
      for (;;)
      {
        AppMethodBeat.o(192697);
        return localObject2;
        label415:
        paramAnimatorSet.playSequentially(paramContext);
      }
    }
  }
  
  private static Keyframe a(Keyframe paramKeyframe, float paramFloat)
  {
    AppMethodBeat.i(192727);
    if (paramKeyframe.getType() == Float.TYPE)
    {
      paramKeyframe = Keyframe.ofFloat(paramFloat);
      AppMethodBeat.o(192727);
      return paramKeyframe;
    }
    if (paramKeyframe.getType() == Integer.TYPE)
    {
      paramKeyframe = Keyframe.ofInt(paramFloat);
      AppMethodBeat.o(192727);
      return paramKeyframe;
    }
    paramKeyframe = Keyframe.ofObject(paramFloat);
    AppMethodBeat.o(192727);
    return paramKeyframe;
  }
  
  private static ObjectAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192752);
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    a(paramContext, paramResources, paramTheme, paramAttributeSet, localObjectAnimator, paramFloat, paramXmlPullParser);
    AppMethodBeat.o(192752);
    return localObjectAnimator;
  }
  
  private static PropertyValuesHolder a(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(192659);
    Object localObject = paramTypedArray.peekValue(paramInt2);
    int j;
    int m;
    label32:
    int k;
    label47:
    int n;
    label59:
    int i;
    if (localObject != null)
    {
      j = 1;
      if (j == 0) {
        break label221;
      }
      m = ((TypedValue)localObject).type;
      localObject = paramTypedArray.peekValue(paramInt3);
      if (localObject == null) {
        break label227;
      }
      k = 1;
      if (k == 0) {
        break label233;
      }
      n = ((TypedValue)localObject).type;
      i = paramInt1;
      if (paramInt1 == 4)
      {
        if (((j == 0) || (!gL(m))) && ((k == 0) || (!gL(n)))) {
          break label239;
        }
        i = 3;
      }
      label96:
      if (i != 0) {
        break label245;
      }
      paramInt1 = 1;
    }
    d.b[] arrayOfb1;
    d.b[] arrayOfb2;
    e.a locala;
    for (;;)
    {
      if (i == 2)
      {
        localObject = paramTypedArray.getString(paramInt2);
        paramTypedArray = paramTypedArray.getString(paramInt3);
        arrayOfb1 = androidx.core.graphics.d.av((String)localObject);
        arrayOfb2 = androidx.core.graphics.d.av(paramTypedArray);
        if ((arrayOfb1 == null) && (arrayOfb2 == null)) {
          break label714;
        }
        if (arrayOfb1 != null)
        {
          locala = new e.a();
          if (arrayOfb2 != null)
          {
            if (!androidx.core.graphics.d.a(arrayOfb1, arrayOfb2))
            {
              paramTypedArray = new InflateException(" Can't morph from " + (String)localObject + " to " + paramTypedArray);
              AppMethodBeat.o(192659);
              throw paramTypedArray;
              j = 0;
              break;
              label221:
              m = 0;
              break label32;
              label227:
              k = 0;
              break label47;
              label233:
              n = 0;
              break label59;
              label239:
              i = 0;
              break label96;
              label245:
              paramInt1 = 0;
              continue;
            }
            paramString = PropertyValuesHolder.ofObject(paramString, locala, new Object[] { arrayOfb1, arrayOfb2 });
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(192659);
      return paramString;
      paramString = PropertyValuesHolder.ofObject(paramString, locala, new Object[] { arrayOfb1 });
      continue;
      if (arrayOfb2 != null)
      {
        paramString = PropertyValuesHolder.ofObject(paramString, new e.a(), new Object[] { arrayOfb2 });
        continue;
        localObject = null;
        if (i == 3) {
          localObject = f.Mf();
        }
        float f1;
        label370:
        float f2;
        if (paramInt1 != 0) {
          if (j != 0) {
            if (m == 5)
            {
              f1 = paramTypedArray.getDimension(paramInt2, 0.0F);
              if (k == 0) {
                break label457;
              }
              if (n != 5) {
                break label446;
              }
              f2 = paramTypedArray.getDimension(paramInt3, 0.0F);
              label389:
              paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1, f2 });
            }
          }
        }
        for (;;)
        {
          paramString = paramTypedArray;
          if (paramTypedArray == null) {
            break;
          }
          paramString = paramTypedArray;
          if (localObject == null) {
            break;
          }
          paramTypedArray.setEvaluator((TypeEvaluator)localObject);
          paramString = paramTypedArray;
          break;
          f1 = paramTypedArray.getFloat(paramInt2, 0.0F);
          break label370;
          label446:
          f2 = paramTypedArray.getFloat(paramInt3, 0.0F);
          break label389;
          label457:
          paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
          continue;
          if (n == 5) {}
          for (f1 = paramTypedArray.getDimension(paramInt3, 0.0F);; f1 = paramTypedArray.getFloat(paramInt3, 0.0F))
          {
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
            break;
          }
          if (j != 0)
          {
            if (m == 5)
            {
              paramInt1 = (int)paramTypedArray.getDimension(paramInt2, 0.0F);
              label535:
              if (k == 0) {
                break label630;
              }
              if (n != 5) {
                break label602;
              }
              paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
            }
            for (;;)
            {
              paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
              break;
              if (gL(m))
              {
                paramInt1 = paramTypedArray.getColor(paramInt2, 0);
                break label535;
              }
              paramInt1 = paramTypedArray.getInt(paramInt2, 0);
              break label535;
              label602:
              if (gL(n)) {
                paramInt2 = paramTypedArray.getColor(paramInt3, 0);
              } else {
                paramInt2 = paramTypedArray.getInt(paramInt3, 0);
              }
            }
            label630:
            paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
          }
          else
          {
            if (k != 0)
            {
              if (n == 5) {
                paramInt1 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
              }
              for (;;)
              {
                paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
                break;
                if (gL(n)) {
                  paramInt1 = paramTypedArray.getColor(paramInt3, 0);
                } else {
                  paramInt1 = paramTypedArray.getInt(paramInt3, 0);
                }
              }
            }
            paramTypedArray = null;
          }
        }
      }
      else
      {
        label714:
        paramString = null;
      }
    }
  }
  
  private static ValueAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192765);
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.aEz);
    paramTheme = g.a(paramResources, paramTheme, paramAttributeSet, a.aEQ);
    paramResources = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramResources = new ValueAnimator();
    }
    a(paramResources, localTypedArray, paramTheme, paramFloat, paramXmlPullParser);
    int i = g.b(localTypedArray, paramXmlPullParser, "interpolator", 0);
    if (i > 0) {
      paramResources.setInterpolator(d.y(paramContext, i));
    }
    localTypedArray.recycle();
    if (paramTheme != null) {
      paramTheme.recycle();
    }
    AppMethodBeat.o(192765);
    return paramResources;
  }
  
  private static void a(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192671);
    long l1 = g.a(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = g.a(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int j = g.a(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    Object localObject;
    label109:
    int k;
    label125:
    int m;
    if ((g.a(paramXmlPullParser, "valueFrom")) && (g.a(paramXmlPullParser, "valueTo")))
    {
      i = j;
      if (j == 4)
      {
        localObject = paramTypedArray1.peekValue(5);
        if (localObject == null) {
          break label338;
        }
        i = 1;
        if (i == 0) {
          break label344;
        }
        j = ((TypedValue)localObject).type;
        localObject = paramTypedArray1.peekValue(6);
        if (localObject == null) {
          break label350;
        }
        k = 1;
        if (k == 0) {
          break label356;
        }
        m = ((TypedValue)localObject).type;
        label137:
        if (((i == 0) || (!gL(j))) && ((k == 0) || (!gL(m)))) {
          break label362;
        }
      }
    }
    label338:
    label344:
    label350:
    label356:
    label362:
    for (int i = 3;; i = 0)
    {
      localObject = a(paramTypedArray1, i, 5, 6, "");
      if (localObject != null) {
        paramValueAnimator.setValues(new PropertyValuesHolder[] { localObject });
      }
      paramValueAnimator.setDuration(l1);
      paramValueAnimator.setStartDelay(l2);
      paramValueAnimator.setRepeatCount(g.a(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
      paramValueAnimator.setRepeatMode(g.a(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
      if (paramTypedArray2 == null) {
        break label406;
      }
      paramValueAnimator = (ObjectAnimator)paramValueAnimator;
      paramTypedArray1 = g.c(paramTypedArray2, paramXmlPullParser, "pathData", 1);
      if (paramTypedArray1 == null) {
        break label392;
      }
      localObject = g.c(paramTypedArray2, paramXmlPullParser, "propertyXName", 2);
      paramXmlPullParser = g.c(paramTypedArray2, paramXmlPullParser, "propertyYName", 3);
      if ((localObject != null) || (paramXmlPullParser != null)) {
        break label368;
      }
      paramValueAnimator = new InflateException(paramTypedArray2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
      AppMethodBeat.o(192671);
      throw paramValueAnimator;
      i = 0;
      break;
      j = 0;
      break label109;
      k = 0;
      break label125;
      m = 0;
      break label137;
    }
    label368:
    a(androidx.core.graphics.d.au(paramTypedArray1), paramValueAnimator, 0.5F * paramFloat, (String)localObject, paramXmlPullParser);
    AppMethodBeat.o(192671);
    return;
    label392:
    paramValueAnimator.setPropertyName(g.c(paramTypedArray2, paramXmlPullParser, "propertyName", 0));
    label406:
    AppMethodBeat.o(192671);
  }
  
  private static void a(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192683);
    Object localObject = new PathMeasure(paramPath, false);
    float f1 = 0.0F;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Float.valueOf(0.0F));
    float f2;
    do
    {
      f2 = f1 + ((PathMeasure)localObject).getLength();
      localArrayList.add(Float.valueOf(f2));
      f1 = f2;
    } while (((PathMeasure)localObject).nextContour());
    paramPath = new PathMeasure(paramPath, false);
    int k = Math.min(100, (int)(f2 / paramFloat) + 1);
    float[] arrayOfFloat1 = new float[k];
    localObject = new float[k];
    float[] arrayOfFloat2 = new float[2];
    int i = 0;
    f1 = f2 / (k - 1);
    paramFloat = 0.0F;
    int j = 0;
    if (j < k)
    {
      paramPath.getPosTan(paramFloat - ((Float)localArrayList.get(i)).floatValue(), arrayOfFloat2, null);
      arrayOfFloat1[j] = arrayOfFloat2[0];
      localObject[j] = arrayOfFloat2[1];
      paramFloat += f1;
      if ((i + 1 >= localArrayList.size()) || (paramFloat <= ((Float)localArrayList.get(i + 1)).floatValue())) {
        break label337;
      }
      i += 1;
      paramPath.nextContour();
    }
    label337:
    for (;;)
    {
      j += 1;
      break;
      paramPath = null;
      localArrayList = null;
      if (paramString1 != null) {
        paramPath = PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat1);
      }
      paramString1 = localArrayList;
      if (paramString2 != null) {
        paramString1 = PropertyValuesHolder.ofFloat(paramString2, (float[])localObject);
      }
      if (paramPath == null)
      {
        paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramString1 });
        AppMethodBeat.o(192683);
        return;
      }
      if (paramString1 == null)
      {
        paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath });
        AppMethodBeat.o(192683);
        return;
      }
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath, paramString1 });
      AppMethodBeat.o(192683);
      return;
    }
  }
  
  private static void a(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192739);
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2)
    {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[(paramInt1 - 1)].getFraction() + paramFloat);
      paramInt1 += 1;
    }
    AppMethodBeat.o(192739);
  }
  
  private static PropertyValuesHolder[] a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(192714);
    ArrayList localArrayList = null;
    int i;
    for (;;)
    {
      i = paramXmlPullParser.getEventType();
      if ((i == 3) || (i == 1)) {
        break label916;
      }
      if (i == 2) {
        break;
      }
      paramXmlPullParser.next();
    }
    Object localObject1;
    int j;
    if (paramXmlPullParser.getName().equals("propertyValuesHolder"))
    {
      TypedArray localTypedArray1 = g.a(paramResources, paramTheme, paramAttributeSet, a.aEI);
      String str = g.c(localTypedArray1, paramXmlPullParser, "propertyName", 3);
      int i1 = g.a(localTypedArray1, paramXmlPullParser, "valueType", 2, 4);
      localObject1 = null;
      i = i1;
      j = paramXmlPullParser.next();
      Object localObject3;
      Object localObject2;
      label189:
      label208:
      float f;
      int k;
      if ((j != 3) && (j != 1))
      {
        localObject3 = localObject1;
        j = i;
        TypedArray localTypedArray2;
        if (paramXmlPullParser.getName().equals("keyframe"))
        {
          j = i;
          if (i == 4)
          {
            localObject2 = g.a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), a.aEM);
            localObject3 = g.a((TypedArray)localObject2, paramXmlPullParser, "value");
            if (localObject3 == null) {
              break label426;
            }
            i = 1;
            if ((i == 0) || (!gL(((TypedValue)localObject3).type))) {
              break label432;
            }
            i = 3;
            ((TypedArray)localObject2).recycle();
            j = i;
          }
          localTypedArray2 = g.a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), a.aEM);
          localObject3 = null;
          f = g.a(localTypedArray2, paramXmlPullParser, "fraction", 3, -1.0F);
          localObject2 = g.a(localTypedArray2, paramXmlPullParser, "value");
          if (localObject2 == null) {
            break label438;
          }
          k = 1;
          label268:
          if (j != 4) {
            break label995;
          }
          if ((k == 0) || (!gL(((TypedValue)localObject2).type))) {
            break label444;
          }
          i = 3;
          label293:
          if (k == 0) {
            break label492;
          }
          localObject2 = localObject3;
          switch (i)
          {
          default: 
            localObject2 = localObject3;
          }
        }
        for (;;)
        {
          i = g.b(localTypedArray2, paramXmlPullParser, "interpolator", 1);
          if (i > 0) {
            ((Keyframe)localObject2).setInterpolator(d.y(paramContext, i));
          }
          localTypedArray2.recycle();
          localObject3 = localObject1;
          if (localObject2 != null)
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new ArrayList();
            }
            ((ArrayList)localObject3).add(localObject2);
          }
          paramXmlPullParser.next();
          localObject1 = localObject3;
          i = j;
          break;
          label426:
          i = 0;
          break label189;
          label432:
          i = 0;
          break label208;
          label438:
          k = 0;
          break label268;
          label444:
          i = 0;
          break label293;
          localObject2 = Keyframe.ofFloat(f, g.a(localTypedArray2, paramXmlPullParser, "value", 0, 0.0F));
          continue;
          localObject2 = Keyframe.ofInt(f, g.a(localTypedArray2, paramXmlPullParser, "value", 0, 0));
          continue;
          label492:
          if (i == 0) {
            localObject2 = Keyframe.ofFloat(f);
          } else {
            localObject2 = Keyframe.ofInt(f);
          }
        }
      }
      else if (localObject1 != null)
      {
        j = ((ArrayList)localObject1).size();
        if (j > 0)
        {
          localObject2 = (Keyframe)((ArrayList)localObject1).get(0);
          localObject3 = (Keyframe)((ArrayList)localObject1).get(j - 1);
          f = ((Keyframe)localObject3).getFraction();
          label901:
          if (f < 1.0F)
          {
            label586:
            int m;
            if (f < 0.0F)
            {
              ((Keyframe)localObject3).setFraction(1.0F);
              f = ((Keyframe)localObject2).getFraction();
              m = j;
              if (f != 0.0F)
              {
                if (f >= 0.0F) {
                  break label708;
                }
                ((Keyframe)localObject2).setFraction(0.0F);
                m = j;
              }
              label621:
              localObject2 = new Keyframe[m];
              ((ArrayList)localObject1).toArray((Object[])localObject2);
              j = 0;
              label639:
              if (j >= m) {
                break label825;
              }
              localObject1 = localObject2[j];
              if (((Keyframe)localObject1).getFraction() < 0.0F)
              {
                if (j != 0) {
                  break label729;
                }
                ((Keyframe)localObject1).setFraction(0.0F);
              }
            }
            for (;;)
            {
              j += 1;
              break label639;
              ((ArrayList)localObject1).add(((ArrayList)localObject1).size(), a((Keyframe)localObject3, 1.0F));
              j += 1;
              break;
              label708:
              ((ArrayList)localObject1).add(0, a((Keyframe)localObject2, 0.0F));
              m = j + 1;
              break label621;
              label729:
              if (j == m - 1)
              {
                ((Keyframe)localObject1).setFraction(1.0F);
              }
              else
              {
                k = j + 1;
                int n = j;
                while ((k < m - 1) && (localObject2[k].getFraction() < 0.0F))
                {
                  n = k;
                  k += 1;
                }
                a((Keyframe[])localObject2, localObject2[(n + 1)].getFraction() - localObject2[(j - 1)].getFraction(), j, n);
              }
            }
            label825:
            localObject2 = PropertyValuesHolder.ofKeyframe(str, (Keyframe[])localObject2);
            localObject1 = localObject2;
            if (i == 3)
            {
              ((PropertyValuesHolder)localObject2).setEvaluator(f.Mf());
              localObject1 = localObject2;
            }
            label856:
            if (localObject1 == null)
            {
              localObject1 = a(localTypedArray1, i1, 0, 1, str);
              label874:
              if (localObject1 != null) {
                if (localArrayList == null)
                {
                  localArrayList = new ArrayList();
                  label893:
                  localArrayList.add(localObject1);
                  localTypedArray1.recycle();
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramXmlPullParser.next();
      break;
      label916:
      paramContext = null;
      if (localArrayList != null)
      {
        j = localArrayList.size();
        paramContext = new PropertyValuesHolder[j];
        i = 0;
        while (i < j)
        {
          paramContext[i] = ((PropertyValuesHolder)localArrayList.get(i));
          i += 1;
        }
      }
      AppMethodBeat.o(192714);
      return paramContext;
      break label893;
      break label901;
      break label874;
      break label586;
      localObject1 = null;
      break label856;
      label995:
      i = j;
      break label293;
    }
  }
  
  private static boolean gL(int paramInt)
  {
    return (paramInt >= 28) && (paramInt <= 31);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.l.a.a.e
 * JD-Core Version:    0.7.0.1
 */