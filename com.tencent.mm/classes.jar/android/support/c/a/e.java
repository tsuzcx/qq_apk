package android.support.c.a;

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
import android.support.v4.a.c.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public final class e
{
  private static boolean U(int paramInt)
  {
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
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
    //   9: aload_1
    //   10: iload_3
    //   11: invokevirtual 21	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 7
    //   16: aload 7
    //   18: astore 5
    //   20: aload 7
    //   22: astore 4
    //   24: aload 7
    //   26: astore 6
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: aload 7
    //   33: aload 7
    //   35: invokestatic 27	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   38: aconst_null
    //   39: iconst_0
    //   40: fconst_1
    //   41: invokestatic 30	android/support/c/a/e:a	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;
    //   44: astore_0
    //   45: aload 7
    //   47: ifnull +10 -> 57
    //   50: aload 7
    //   52: invokeinterface 36 1 0
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aload 5
    //   62: astore 4
    //   64: new 38	android/content/res/Resources$NotFoundException
    //   67: dup
    //   68: new 40	java/lang/StringBuilder
    //   71: dup
    //   72: ldc 42
    //   74: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: iload_3
    //   78: invokestatic 52	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   81: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 61	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   90: astore_1
    //   91: aload 5
    //   93: astore 4
    //   95: aload_1
    //   96: aload_0
    //   97: invokevirtual 65	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   100: pop
    //   101: aload 5
    //   103: astore 4
    //   105: aload_1
    //   106: athrow
    //   107: astore_0
    //   108: aload 4
    //   110: ifnull +10 -> 120
    //   113: aload 4
    //   115: invokeinterface 36 1 0
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aload 6
    //   125: astore 4
    //   127: new 38	android/content/res/Resources$NotFoundException
    //   130: dup
    //   131: new 40	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 42
    //   137: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: iload_3
    //   141: invokestatic 52	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   144: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokespecial 61	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   153: astore_1
    //   154: aload 6
    //   156: astore 4
    //   158: aload_1
    //   159: aload_0
    //   160: invokevirtual 65	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   163: pop
    //   164: aload 6
    //   166: astore 4
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramContext	Context
    //   0	170	1	paramResources	Resources
    //   0	170	2	paramTheme	Resources.Theme
    //   0	170	3	paramInt	int
    //   1	166	4	localObject1	Object
    //   7	95	5	localObject2	Object
    //   4	161	6	localObject3	Object
    //   14	37	7	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   9	16	59	org/xmlpull/v1/XmlPullParserException
    //   28	45	59	org/xmlpull/v1/XmlPullParserException
    //   9	16	107	finally
    //   28	45	107	finally
    //   64	91	107	finally
    //   95	101	107	finally
    //   105	107	107	finally
    //   127	154	107	finally
    //   158	164	107	finally
    //   168	170	107	finally
    //   9	16	122	java/io/IOException
    //   28	45	122	java/io/IOException
  }
  
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
  {
    Object localObject2 = null;
    ArrayList localArrayList = null;
    int j = paramXmlPullParser.getDepth();
    int i;
    Object localObject1;
    label95:
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
        localObject1 = new ObjectAnimator();
        a(paramContext, paramResources, paramTheme, paramAttributeSet, (ValueAnimator)localObject1, paramFloat, paramXmlPullParser);
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
        break label95;
      }
      if (((String)localObject1).equals("set"))
      {
        localObject1 = new AnimatorSet();
        localObject2 = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.mt);
        i = android.support.v4.content.a.c.a((TypedArray)localObject2, paramXmlPullParser, "ordering", 0, 0);
        a(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, i, paramFloat);
        ((TypedArray)localObject2).recycle();
        i = 0;
        break label95;
      }
      if (((String)localObject1).equals("propertyValuesHolder"))
      {
        localObject1 = a(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof ValueAnimator))) {
          ((ValueAnimator)localObject2).setValues((PropertyValuesHolder[])localObject1);
        }
        i = 1;
        localObject1 = localObject2;
        break label95;
      }
      throw new RuntimeException("Unknown animator name: " + paramXmlPullParser.getName());
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
        if (paramInt == 0) {
          paramAnimatorSet.playTogether(paramContext);
        }
      }
      else
      {
        return localObject2;
      }
      paramAnimatorSet.playSequentially(paramContext);
      return localObject2;
    }
  }
  
  private static Keyframe a(Keyframe paramKeyframe, float paramFloat)
  {
    if (paramKeyframe.getType() == Float.TYPE) {
      return Keyframe.ofFloat(paramFloat);
    }
    if (paramKeyframe.getType() == Integer.TYPE) {
      return Keyframe.ofInt(paramFloat);
    }
    return Keyframe.ofObject(paramFloat);
  }
  
  private static PropertyValuesHolder a(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = paramTypedArray.peekValue(paramInt2);
    int j;
    int m;
    label27:
    int k;
    label42:
    int n;
    label54:
    int i;
    if (localObject != null)
    {
      j = 1;
      if (j == 0) {
        break label210;
      }
      m = ((TypedValue)localObject).type;
      localObject = paramTypedArray.peekValue(paramInt3);
      if (localObject == null) {
        break label216;
      }
      k = 1;
      if (k == 0) {
        break label222;
      }
      n = ((TypedValue)localObject).type;
      i = paramInt1;
      if (paramInt1 == 4)
      {
        if (((j == 0) || (!U(m))) && ((k == 0) || (!U(n)))) {
          break label228;
        }
        i = 3;
      }
      label91:
      if (i != 0) {
        break label234;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (i == 2)
      {
        localObject = paramTypedArray.getString(paramInt2);
        paramTypedArray = paramTypedArray.getString(paramInt3);
        c.b[] arrayOfb1 = android.support.v4.a.c.J((String)localObject);
        c.b[] arrayOfb2 = android.support.v4.a.c.J(paramTypedArray);
        if ((arrayOfb1 == null) && (arrayOfb2 == null)) {
          break label687;
        }
        if (arrayOfb1 != null)
        {
          a locala = new a((byte)0);
          if (arrayOfb2 != null)
          {
            if (!android.support.v4.a.c.a(arrayOfb1, arrayOfb2))
            {
              throw new InflateException(" Can't morph from " + (String)localObject + " to " + paramTypedArray);
              j = 0;
              break;
              label210:
              m = 0;
              break label27;
              label216:
              k = 0;
              break label42;
              label222:
              n = 0;
              break label54;
              label228:
              i = 0;
              break label91;
              label234:
              paramInt1 = 0;
              continue;
            }
            paramString = PropertyValuesHolder.ofObject(paramString, locala, new Object[] { arrayOfb1, arrayOfb2 });
            return paramString;
          }
          return PropertyValuesHolder.ofObject(paramString, locala, new Object[] { arrayOfb1 });
        }
        if (arrayOfb2 == null) {
          break label687;
        }
        return PropertyValuesHolder.ofObject(paramString, new a((byte)0), new Object[] { arrayOfb2 });
      }
    }
    localObject = null;
    if (i == 3) {
      localObject = f.bj();
    }
    float f1;
    label347:
    float f2;
    if (paramInt1 != 0) {
      if (j != 0) {
        if (m == 5)
        {
          f1 = paramTypedArray.getDimension(paramInt2, 0.0F);
          if (k == 0) {
            break label430;
          }
          if (n != 5) {
            break label419;
          }
          f2 = paramTypedArray.getDimension(paramInt3, 0.0F);
          label366:
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
      return paramTypedArray;
      f1 = paramTypedArray.getFloat(paramInt2, 0.0F);
      break label347;
      label419:
      f2 = paramTypedArray.getFloat(paramInt3, 0.0F);
      break label366;
      label430:
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
          label508:
          if (k == 0) {
            break label603;
          }
          if (n != 5) {
            break label575;
          }
          paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
        }
        for (;;)
        {
          paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
          break;
          if (U(m))
          {
            paramInt1 = paramTypedArray.getColor(paramInt2, 0);
            break label508;
          }
          paramInt1 = paramTypedArray.getInt(paramInt2, 0);
          break label508;
          label575:
          if (U(n)) {
            paramInt2 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt2 = paramTypedArray.getInt(paramInt3, 0);
          }
        }
        label603:
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
            if (U(n)) {
              paramInt1 = paramTypedArray.getColor(paramInt3, 0);
            } else {
              paramInt1 = paramTypedArray.getInt(paramInt3, 0);
            }
          }
        }
        paramTypedArray = null;
      }
    }
    label687:
    return null;
  }
  
  private static ValueAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    TypedArray localTypedArray = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.ms);
    paramTheme = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.mw);
    paramResources = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramResources = new ValueAnimator();
    }
    a(paramResources, localTypedArray, paramTheme, paramFloat, paramXmlPullParser);
    int i = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "interpolator", 0);
    if (i > 0) {
      paramResources.setInterpolator(d.loadInterpolator(paramContext, i));
    }
    localTypedArray.recycle();
    if (paramTheme != null) {
      paramTheme.recycle();
    }
    return paramResources;
  }
  
  private static void a(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    long l1 = android.support.v4.content.a.c.a(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = android.support.v4.content.a.c.a(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int j = android.support.v4.content.a.c.a(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    Object localObject;
    label103:
    int k;
    label119:
    int m;
    if ((android.support.v4.content.a.c.a(paramXmlPullParser, "valueFrom")) && (android.support.v4.content.a.c.a(paramXmlPullParser, "valueTo")))
    {
      i = j;
      if (j == 4)
      {
        localObject = paramTypedArray1.peekValue(5);
        if (localObject == null) {
          break label324;
        }
        i = 1;
        if (i == 0) {
          break label330;
        }
        j = ((TypedValue)localObject).type;
        localObject = paramTypedArray1.peekValue(6);
        if (localObject == null) {
          break label336;
        }
        k = 1;
        if (k == 0) {
          break label342;
        }
        m = ((TypedValue)localObject).type;
        label131:
        if (((i == 0) || (!U(j))) && ((k == 0) || (!U(m)))) {
          break label348;
        }
      }
    }
    label324:
    label330:
    label336:
    label342:
    label348:
    for (int i = 3;; i = 0)
    {
      localObject = a(paramTypedArray1, i, 5, 6, "");
      if (localObject != null) {
        paramValueAnimator.setValues(new PropertyValuesHolder[] { localObject });
      }
      paramValueAnimator.setDuration(l1);
      paramValueAnimator.setStartDelay(l2);
      paramValueAnimator.setRepeatCount(android.support.v4.content.a.c.a(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
      paramValueAnimator.setRepeatMode(android.support.v4.content.a.c.a(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
      if (paramTypedArray2 == null) {
        break label371;
      }
      paramValueAnimator = (ObjectAnimator)paramValueAnimator;
      paramTypedArray1 = android.support.v4.content.a.c.b(paramTypedArray2, paramXmlPullParser, "pathData", 1);
      if (paramTypedArray1 == null) {
        break label372;
      }
      localObject = android.support.v4.content.a.c.b(paramTypedArray2, paramXmlPullParser, "propertyXName", 2);
      paramXmlPullParser = android.support.v4.content.a.c.b(paramTypedArray2, paramXmlPullParser, "propertyYName", 3);
      if ((localObject != null) || (paramXmlPullParser != null)) {
        break label354;
      }
      throw new InflateException(paramTypedArray2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
      i = 0;
      break;
      j = 0;
      break label103;
      k = 0;
      break label119;
      m = 0;
      break label131;
    }
    label354:
    a(android.support.v4.a.c.I(paramTypedArray1), paramValueAnimator, 0.5F * paramFloat, (String)localObject, paramXmlPullParser);
    label371:
    return;
    label372:
    paramValueAnimator.setPropertyName(android.support.v4.content.a.c.b(paramTypedArray2, paramXmlPullParser, "propertyName", 0));
  }
  
  private static void a(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2)
  {
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
    int j = 0;
    f1 = f2 / (k - 1);
    int i = 0;
    paramFloat = 0.0F;
    if (i < k)
    {
      paramPath.getPosTan(paramFloat, arrayOfFloat2, null);
      arrayOfFloat1[i] = arrayOfFloat2[0];
      localObject[i] = arrayOfFloat2[1];
      paramFloat += f1;
      if ((j + 1 >= localArrayList.size()) || (paramFloat <= ((Float)localArrayList.get(j + 1)).floatValue())) {
        break label317;
      }
      paramFloat -= ((Float)localArrayList.get(j + 1)).floatValue();
      paramPath.nextContour();
      j += 1;
    }
    label317:
    for (;;)
    {
      i += 1;
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
        return;
      }
      if (paramString1 == null)
      {
        paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath });
        return;
      }
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath, paramString1 });
      return;
    }
  }
  
  private static void a(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2)
  {
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2)
    {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[(paramInt1 - 1)].getFraction() + paramFloat);
      paramInt1 += 1;
    }
  }
  
  private static PropertyValuesHolder[] a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    ArrayList localArrayList = null;
    int i;
    for (;;)
    {
      i = paramXmlPullParser.getEventType();
      if ((i == 3) || (i == 1)) {
        break label908;
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
      TypedArray localTypedArray1 = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.mu);
      String str = android.support.v4.content.a.c.b(localTypedArray1, paramXmlPullParser, "propertyName", 3);
      int i1 = android.support.v4.content.a.c.a(localTypedArray1, paramXmlPullParser, "valueType", 2, 4);
      localObject1 = null;
      i = i1;
      j = paramXmlPullParser.next();
      Object localObject3;
      Object localObject2;
      label183:
      label202:
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
            localObject2 = android.support.v4.content.a.c.a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), a.mv);
            localObject3 = android.support.v4.content.a.c.a((TypedArray)localObject2, paramXmlPullParser, "value");
            if (localObject3 == null) {
              break label418;
            }
            i = 1;
            if ((i == 0) || (!U(((TypedValue)localObject3).type))) {
              break label424;
            }
            i = 3;
            ((TypedArray)localObject2).recycle();
            j = i;
          }
          localTypedArray2 = android.support.v4.content.a.c.a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), a.mv);
          localObject3 = null;
          f = android.support.v4.content.a.c.a(localTypedArray2, paramXmlPullParser, "fraction", 3, -1.0F);
          localObject2 = android.support.v4.content.a.c.a(localTypedArray2, paramXmlPullParser, "value");
          if (localObject2 == null) {
            break label430;
          }
          k = 1;
          label262:
          if (j != 4) {
            break label981;
          }
          if ((k == 0) || (!U(((TypedValue)localObject2).type))) {
            break label436;
          }
          i = 3;
          label287:
          if (k == 0) {
            break label484;
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
          i = android.support.v4.content.a.c.a(localTypedArray2, paramXmlPullParser, "interpolator", 1);
          if (i > 0) {
            ((Keyframe)localObject2).setInterpolator(d.loadInterpolator(paramContext, i));
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
          label418:
          i = 0;
          break label183;
          label424:
          i = 0;
          break label202;
          label430:
          k = 0;
          break label262;
          label436:
          i = 0;
          break label287;
          localObject2 = Keyframe.ofFloat(f, android.support.v4.content.a.c.a(localTypedArray2, paramXmlPullParser, "value", 0, 0.0F));
          continue;
          localObject2 = Keyframe.ofInt(f, android.support.v4.content.a.c.a(localTypedArray2, paramXmlPullParser, "value", 0, 0));
          continue;
          label484:
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
          if (f < 1.0F)
          {
            label578:
            int m;
            if (f < 0.0F)
            {
              ((Keyframe)localObject3).setFraction(1.0F);
              f = ((Keyframe)localObject2).getFraction();
              m = j;
              if (f != 0.0F)
              {
                if (f >= 0.0F) {
                  break label700;
                }
                ((Keyframe)localObject2).setFraction(0.0F);
                m = j;
              }
              label613:
              localObject2 = new Keyframe[m];
              ((ArrayList)localObject1).toArray((Object[])localObject2);
              j = 0;
              label631:
              if (j >= m) {
                break label817;
              }
              localObject1 = localObject2[j];
              if (((Keyframe)localObject1).getFraction() < 0.0F)
              {
                if (j != 0) {
                  break label721;
                }
                ((Keyframe)localObject1).setFraction(0.0F);
              }
            }
            for (;;)
            {
              j += 1;
              break label631;
              ((ArrayList)localObject1).add(((ArrayList)localObject1).size(), a((Keyframe)localObject3, 1.0F));
              j += 1;
              break;
              label700:
              ((ArrayList)localObject1).add(0, a((Keyframe)localObject2, 0.0F));
              m = j + 1;
              break label613;
              label721:
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
            label817:
            localObject2 = PropertyValuesHolder.ofKeyframe(str, (Keyframe[])localObject2);
            localObject1 = localObject2;
            if (i == 3)
            {
              ((PropertyValuesHolder)localObject2).setEvaluator(f.bj());
              localObject1 = localObject2;
            }
            label848:
            if (localObject1 == null)
            {
              localObject1 = a(localTypedArray1, i1, 0, 1, str);
              label866:
              if (localObject1 != null) {
                if (localArrayList == null)
                {
                  localArrayList = new ArrayList();
                  label885:
                  localArrayList.add(localObject1);
                  label893:
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
      label908:
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
      return paramContext;
      break label885;
      break label893;
      break label866;
      break label578;
      localObject1 = null;
      break label848;
      label981:
      i = j;
      break label287;
    }
  }
  
  private static final class a
    implements TypeEvaluator<c.b[]>
  {
    private c.b[] mJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.e
 * JD-Core Version:    0.7.0.1
 */