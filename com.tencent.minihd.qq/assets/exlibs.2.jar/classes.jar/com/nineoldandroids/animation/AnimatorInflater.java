package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater
{
  private static final int[] Animator = { 16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488 };
  private static final int[] AnimatorSet = { 16843490 };
  private static final int AnimatorSet_ordering = 0;
  private static final int Animator_duration = 1;
  private static final int Animator_interpolator = 0;
  private static final int Animator_repeatCount = 3;
  private static final int Animator_repeatMode = 4;
  private static final int Animator_startOffset = 2;
  private static final int Animator_valueFrom = 5;
  private static final int Animator_valueTo = 6;
  private static final int Animator_valueType = 7;
  private static final int[] PropertyAnimator = { 16843489 };
  private static final int PropertyAnimator_propertyName = 0;
  private static final int TOGETHER = 0;
  private static final int VALUE_TYPE_FLOAT = 0;
  
  private static Animator createAnimatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    return createAnimatorFromXml(paramContext, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0);
  }
  
  private static Animator createAnimatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt)
    throws XmlPullParserException, IOException
  {
    Object localObject2 = null;
    Object localObject3 = null;
    int k = paramXmlPullParser.getDepth();
    int i = paramXmlPullParser.next();
    if (((i == 3) && (paramXmlPullParser.getDepth() <= k)) || (i == 1)) {
      if ((paramAnimatorSet != null) && (localObject3 != null))
      {
        paramContext = new Animator[localObject3.size()];
        i = 0;
        paramXmlPullParser = localObject3.iterator();
      }
    }
    for (;;)
    {
      if (!paramXmlPullParser.hasNext())
      {
        if (paramInt != 0) {
          break label441;
        }
        paramAnimatorSet.playTogether(paramContext);
        return localObject2;
        if (i != 2) {
          break;
        }
        Object localObject1 = paramXmlPullParser.getName();
        if (((String)localObject1).equals("objectAnimator")) {}
        Object localObject4;
        for (localObject1 = loadObjectAnimator(paramContext, paramAttributeSet);; localObject1 = loadAnimator(paramContext, paramAttributeSet, null))
        {
          localObject2 = localObject1;
          if (paramAnimatorSet == null) {
            break;
          }
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = new ArrayList();
          }
          ((ArrayList)localObject4).add(localObject1);
          localObject2 = localObject1;
          localObject3 = localObject4;
          break;
          if (!((String)localObject1).equals("animator")) {
            break label191;
          }
        }
        label191:
        if (((String)localObject1).equals("set"))
        {
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localObject2 = null;
          localObject1 = null;
          for (i = 0;; i = 0)
          {
            try
            {
              localObject4 = paramContext.obtainStyledAttributes(paramAttributeSet, AnimatorSet);
              localObject1 = localObject4;
              localObject2 = localObject4;
              TypedValue localTypedValue = new TypedValue();
              localObject1 = localObject4;
              localObject2 = localObject4;
              ((TypedArray)localObject4).getValue(0, localTypedValue);
              localObject1 = localObject4;
              localObject2 = localObject4;
              if (localTypedValue.type != 16) {
                continue;
              }
              localObject1 = localObject4;
              localObject2 = localObject4;
              j = localTypedValue.data;
              i = j;
              j = i;
              if (localObject4 != null)
              {
                ((TypedArray)localObject4).recycle();
                j = i;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localObject2 = localObject1;
                localException.printStackTrace();
                int j = i;
                if (localObject1 != null)
                {
                  ((TypedArray)localObject1).recycle();
                  j = i;
                }
              }
            }
            finally
            {
              if (localObject2 == null) {
                break label388;
              }
              ((TypedArray)localObject2).recycle();
            }
            createAnimatorFromXml(paramContext, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localAnimatorSet, j);
            localObject1 = localAnimatorSet;
            break;
          }
        }
        label388:
        throw new RuntimeException("Unknown animator name: " + paramXmlPullParser.getName());
      }
      paramContext[i] = ((Animator)paramXmlPullParser.next());
      i += 1;
    }
    label441:
    paramAnimatorSet.playSequentially(paramContext);
    return localObject2;
  }
  
  /* Error */
  public static Animator loadAnimator(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_0
    //   8: invokevirtual 187	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: iload_1
    //   12: invokevirtual 193	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   15: astore 5
    //   17: aload 5
    //   19: astore_3
    //   20: aload 5
    //   22: astore_2
    //   23: aload 5
    //   25: astore 4
    //   27: aload_0
    //   28: aload 5
    //   30: invokestatic 195	com/nineoldandroids/animation/AnimatorInflater:createAnimatorFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)Lcom/nineoldandroids/animation/Animator;
    //   33: astore_0
    //   34: aload 5
    //   36: ifnull +10 -> 46
    //   39: aload 5
    //   41: invokeinterface 200 1 0
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_3
    //   50: astore_2
    //   51: new 183	android/content/res/Resources$NotFoundException
    //   54: dup
    //   55: new 161	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 202
    //   61: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: iload_1
    //   65: invokestatic 208	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   68: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 209	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   77: astore 4
    //   79: aload_3
    //   80: astore_2
    //   81: aload 4
    //   83: aload_0
    //   84: invokevirtual 213	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   87: pop
    //   88: aload_3
    //   89: astore_2
    //   90: aload 4
    //   92: athrow
    //   93: astore_0
    //   94: aload_2
    //   95: ifnull +9 -> 104
    //   98: aload_2
    //   99: invokeinterface 200 1 0
    //   104: aload_0
    //   105: athrow
    //   106: astore_0
    //   107: aload 4
    //   109: astore_2
    //   110: new 183	android/content/res/Resources$NotFoundException
    //   113: dup
    //   114: new 161	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 202
    //   120: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: iload_1
    //   124: invokestatic 208	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   127: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 209	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   136: astore_3
    //   137: aload 4
    //   139: astore_2
    //   140: aload_3
    //   141: aload_0
    //   142: invokevirtual 213	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   145: pop
    //   146: aload 4
    //   148: astore_2
    //   149: aload_3
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramContext	Context
    //   0	151	1	paramInt	int
    //   1	148	2	localObject1	Object
    //   6	144	3	localObject2	Object
    //   3	144	4	localObject3	Object
    //   15	25	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   7	17	48	org/xmlpull/v1/XmlPullParserException
    //   27	34	48	org/xmlpull/v1/XmlPullParserException
    //   7	17	93	finally
    //   27	34	93	finally
    //   51	79	93	finally
    //   81	88	93	finally
    //   90	93	93	finally
    //   110	137	93	finally
    //   140	146	93	finally
    //   149	151	93	finally
    //   7	17	106	java/io/IOException
    //   27	34	106	java/io/IOException
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator)
    throws Resources.NotFoundException
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Animator);
    long l1 = localTypedArray.getInt(1, 0);
    long l2 = localTypedArray.getInt(2, 0);
    int i = localTypedArray.getInt(7, 0);
    paramAttributeSet = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramAttributeSet = new ValueAnimator();
    }
    int j;
    label76:
    int m;
    label87:
    int k;
    label102:
    int n;
    label113:
    float f1;
    label201:
    float f2;
    if (i == 0)
    {
      i = 1;
      paramValueAnimator = localTypedArray.peekValue(5);
      if (paramValueAnimator == null) {
        break label328;
      }
      j = 1;
      if (j == 0) {
        break label334;
      }
      m = paramValueAnimator.type;
      paramValueAnimator = localTypedArray.peekValue(6);
      if (paramValueAnimator == null) {
        break label340;
      }
      k = 1;
      if (k == 0) {
        break label346;
      }
      n = paramValueAnimator.type;
      int i1;
      if ((j == 0) || (m < 28) || (m > 31))
      {
        i1 = i;
        if (k != 0)
        {
          i1 = i;
          if (n >= 28)
          {
            i1 = i;
            if (n > 31) {}
          }
        }
      }
      else
      {
        i1 = 0;
        paramAttributeSet.setEvaluator(new ArgbEvaluator());
      }
      if (i1 == 0) {
        break label431;
      }
      if (j == 0) {
        break label390;
      }
      if (m != 5) {
        break label352;
      }
      f1 = localTypedArray.getDimension(5, 0.0F);
      if (k == 0) {
        break label376;
      }
      if (n != 5) {
        break label363;
      }
      f2 = localTypedArray.getDimension(6, 0.0F);
      label222:
      paramAttributeSet.setFloatValues(new float[] { f1, f2 });
    }
    label328:
    label334:
    label340:
    label346:
    label352:
    label363:
    label376:
    do
    {
      for (;;)
      {
        paramAttributeSet.setDuration(l1);
        paramAttributeSet.setStartDelay(l2);
        if (localTypedArray.hasValue(3)) {
          paramAttributeSet.setRepeatCount(localTypedArray.getInt(3, 0));
        }
        if (localTypedArray.hasValue(4)) {
          paramAttributeSet.setRepeatMode(localTypedArray.getInt(4, 1));
        }
        i = localTypedArray.getResourceId(0, 0);
        if (i > 0) {
          paramAttributeSet.setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
        }
        localTypedArray.recycle();
        return paramAttributeSet;
        i = 0;
        break;
        j = 0;
        break label76;
        m = 0;
        break label87;
        k = 0;
        break label102;
        n = 0;
        break label113;
        f1 = localTypedArray.getFloat(5, 0.0F);
        break label201;
        f2 = localTypedArray.getFloat(6, 0.0F);
        break label222;
        paramAttributeSet.setFloatValues(new float[] { f1 });
        continue;
        if (n == 5) {}
        for (f1 = localTypedArray.getDimension(6, 0.0F);; f1 = localTypedArray.getFloat(6, 0.0F))
        {
          paramAttributeSet.setFloatValues(new float[] { f1 });
          break;
        }
        if (j == 0) {
          break label587;
        }
        if (m == 5)
        {
          i = (int)localTypedArray.getDimension(5, 0.0F);
          if (k == 0) {
            break label572;
          }
          if (n != 5) {
            break label532;
          }
          j = (int)localTypedArray.getDimension(6, 0.0F);
        }
        for (;;)
        {
          paramAttributeSet.setIntValues(new int[] { i, j });
          break;
          if ((m >= 28) && (m <= 31))
          {
            i = localTypedArray.getColor(5, 0);
            break label452;
          }
          i = localTypedArray.getInt(5, 0);
          break label452;
          if ((n >= 28) && (n <= 31)) {
            j = localTypedArray.getColor(6, 0);
          } else {
            j = localTypedArray.getInt(6, 0);
          }
        }
        paramAttributeSet.setIntValues(new int[] { i });
      }
    } while (k == 0);
    label390:
    label431:
    label452:
    label587:
    if (n == 5) {
      i = (int)localTypedArray.getDimension(6, 0.0F);
    }
    for (;;)
    {
      label532:
      label572:
      paramAttributeSet.setIntValues(new int[] { i });
      break;
      if ((n >= 28) && (n <= 31)) {
        i = localTypedArray.getColor(6, 0);
      } else {
        i = localTypedArray.getInt(6, 0);
      }
    }
  }
  
  private static ObjectAnimator loadObjectAnimator(Context paramContext, AttributeSet paramAttributeSet)
    throws Resources.NotFoundException
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    loadAnimator(paramContext, paramAttributeSet, localObjectAnimator);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, PropertyAnimator);
    localObjectAnimator.setPropertyName(paramContext.getString(0));
    paramContext.recycle();
    return localObjectAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorInflater
 * JD-Core Version:    0.7.0.1
 */