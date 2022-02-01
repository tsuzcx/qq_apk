package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.a.g;
import android.support.v4.e.a;
import android.util.AttributeSet;
import android.view.InflateException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

public final class q
{
  private static final Class<?>[] CL = { Context.class, AttributeSet.class };
  private static final a<String, Constructor> CM = new a();
  private final Context mContext;
  
  private q(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static q O(Context paramContext)
  {
    return new q(paramContext);
  }
  
  private Transition a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
  {
    int i = paramXmlPullParser.getDepth();
    TransitionSet localTransitionSet;
    Object localObject;
    if ((paramTransition instanceof TransitionSet))
    {
      localTransitionSet = (TransitionSet)paramTransition;
      localObject = null;
    }
    for (;;)
    {
      label24:
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label606;
      }
      if (j == 2)
      {
        String str = paramXmlPullParser.getName();
        if ("fade".equals(str)) {
          localObject = new Fade(this.mContext, paramAttributeSet);
        }
        for (;;)
        {
          if (localObject != null)
          {
            if (!paramXmlPullParser.isEmptyElementTag()) {
              a(paramXmlPullParser, paramAttributeSet, (Transition)localObject);
            }
            if (localTransitionSet != null)
            {
              localTransitionSet.c((Transition)localObject);
              localObject = null;
              break label24;
              localTransitionSet = null;
              break;
              if ("changeBounds".equals(str))
              {
                localObject = new ChangeBounds(this.mContext, paramAttributeSet);
                continue;
              }
              if ("slide".equals(str))
              {
                localObject = new Slide(this.mContext, paramAttributeSet);
                continue;
              }
              if ("explode".equals(str))
              {
                localObject = new Explode(this.mContext, paramAttributeSet);
                continue;
              }
              if ("changeImageTransform".equals(str))
              {
                localObject = new ChangeImageTransform(this.mContext, paramAttributeSet);
                continue;
              }
              if ("changeTransform".equals(str))
              {
                localObject = new ChangeTransform(this.mContext, paramAttributeSet);
                continue;
              }
              if ("changeClipBounds".equals(str))
              {
                localObject = new ChangeClipBounds(this.mContext, paramAttributeSet);
                continue;
              }
              if ("autoTransition".equals(str))
              {
                localObject = new AutoTransition(this.mContext, paramAttributeSet);
                continue;
              }
              if ("changeScroll".equals(str))
              {
                localObject = new ChangeScroll(this.mContext, paramAttributeSet);
                continue;
              }
              if ("transitionSet".equals(str))
              {
                localObject = new TransitionSet(this.mContext, paramAttributeSet);
                continue;
              }
              if ("transition".equals(str))
              {
                localObject = (Transition)a(paramAttributeSet, Transition.class, "transition");
                continue;
              }
              if ("targets".equals(str))
              {
                b(paramXmlPullParser, paramAttributeSet, paramTransition);
                continue;
              }
              if ("arcMotion".equals(str))
              {
                if (paramTransition == null) {
                  throw new RuntimeException("Invalid use of arcMotion element");
                }
                paramTransition.a(new ArcMotion(this.mContext, paramAttributeSet));
                continue;
              }
              if ("pathMotion".equals(str))
              {
                if (paramTransition == null) {
                  throw new RuntimeException("Invalid use of pathMotion element");
                }
                paramTransition.a((PathMotion)a(paramAttributeSet, PathMotion.class, "pathMotion"));
                continue;
              }
              if ("patternPathMotion".equals(str))
              {
                if (paramTransition == null) {
                  throw new RuntimeException("Invalid use of patternPathMotion element");
                }
                paramTransition.a(new PatternPathMotion(this.mContext, paramAttributeSet));
                continue;
              }
              throw new RuntimeException("Unknown scene name: " + paramXmlPullParser.getName());
            }
            if (paramTransition != null) {
              throw new InflateException("Could not add transition to another transition.");
            }
          }
        }
      }
    }
    label606:
    return localObject;
  }
  
  /* Error */
  private Object a(AttributeSet paramAttributeSet, Class paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: aconst_null
    //   2: ldc 183
    //   4: invokeinterface 187 3 0
    //   9: astore 5
    //   11: aload 5
    //   13: ifnonnull +30 -> 43
    //   16: new 176	android/view/InflateException
    //   19: dup
    //   20: new 164	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   27: aload_3
    //   28: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 190
    //   33: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 179	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: getstatic 29	android/support/transition/q:CM	Landroid/support/v4/e/a;
    //   46: astore 6
    //   48: aload 6
    //   50: monitorenter
    //   51: getstatic 29	android/support/transition/q:CM	Landroid/support/v4/e/a;
    //   54: aload 5
    //   56: invokevirtual 194	android/support/v4/e/a:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 196	java/lang/reflect/Constructor
    //   62: astore 4
    //   64: aload 4
    //   66: astore_3
    //   67: aload 4
    //   69: ifnonnull +53 -> 122
    //   72: aload_0
    //   73: getfield 34	android/support/transition/q:mContext	Landroid/content/Context;
    //   76: invokevirtual 200	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   79: aload 5
    //   81: invokevirtual 206	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   84: aload_2
    //   85: invokevirtual 210	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   88: astore 7
    //   90: aload 4
    //   92: astore_3
    //   93: aload 7
    //   95: ifnull +27 -> 122
    //   98: aload 7
    //   100: getstatic 22	android/support/transition/q:CL	[Ljava/lang/Class;
    //   103: invokevirtual 214	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   106: astore_3
    //   107: aload_3
    //   108: iconst_1
    //   109: invokevirtual 218	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   112: getstatic 29	android/support/transition/q:CM	Landroid/support/v4/e/a;
    //   115: aload 5
    //   117: aload_3
    //   118: invokevirtual 222	android/support/v4/e/a:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: aload_3
    //   123: iconst_2
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_0
    //   130: getfield 34	android/support/transition/q:mContext	Landroid/content/Context;
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_1
    //   137: aastore
    //   138: invokevirtual 226	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   141: astore_1
    //   142: aload 6
    //   144: monitorexit
    //   145: aload_1
    //   146: areturn
    //   147: astore_1
    //   148: aload 6
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    //   153: astore_1
    //   154: new 176	android/view/InflateException
    //   157: dup
    //   158: new 164	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 228
    //   164: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_2
    //   168: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: ldc 233
    //   173: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 5
    //   178: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aload_1
    //   185: invokespecial 236	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	q
    //   0	189	1	paramAttributeSet	AttributeSet
    //   0	189	2	paramClass	Class
    //   0	189	3	paramString	String
    //   62	29	4	localConstructor	Constructor
    //   9	168	5	str	String
    //   88	11	7	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   51	64	147	finally
    //   72	90	147	finally
    //   98	122	147	finally
    //   122	145	147	finally
    //   148	151	147	finally
    //   43	51	153	java/lang/Exception
    //   151	153	153	java/lang/Exception
  }
  
  private void b(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
  {
    int i = paramXmlPullParser.getDepth();
    int j;
    do
    {
      j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break;
      }
    } while (j != 2);
    if (paramXmlPullParser.getName().equals("target"))
    {
      TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, p.BQ);
      j = g.b(localTypedArray, paramXmlPullParser, "targetId", 1);
      if (j != 0) {
        paramTransition.an(j);
      }
      for (;;)
      {
        localTypedArray.recycle();
        break;
        j = g.b(localTypedArray, paramXmlPullParser, "excludeId", 2);
        if (j != 0)
        {
          paramTransition.f(j, true);
        }
        else
        {
          Object localObject = g.c(localTypedArray, paramXmlPullParser, "targetName", 4);
          if (localObject != null)
          {
            paramTransition.q((String)localObject);
          }
          else
          {
            localObject = g.c(localTypedArray, paramXmlPullParser, "excludeName", 5);
            if (localObject != null)
            {
              paramTransition.b((String)localObject, true);
            }
            else
            {
              String str = g.c(localTypedArray, paramXmlPullParser, "excludeClass", 3);
              if (str != null)
              {
                localObject = str;
                try
                {
                  paramTransition.a(Class.forName(str), true);
                }
                catch (ClassNotFoundException paramXmlPullParser)
                {
                  localTypedArray.recycle();
                  throw new RuntimeException("Could not create ".concat(String.valueOf(localObject)), paramXmlPullParser);
                }
              }
              else
              {
                localObject = str;
                str = g.c(localTypedArray, paramXmlPullParser, "targetClass", 0);
                if (str != null)
                {
                  localObject = str;
                  paramTransition.h(Class.forName(str));
                }
              }
            }
          }
        }
      }
    }
    throw new RuntimeException("Unknown scene name: " + paramXmlPullParser.getName());
  }
  
  /* Error */
  public final Transition dQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	android/support/transition/q:mContext	Landroid/content/Context;
    //   4: invokevirtual 321	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: ldc_w 322
    //   10: invokevirtual 328	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   13: astore_1
    //   14: aload_0
    //   15: aload_1
    //   16: aload_1
    //   17: invokestatic 334	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   20: aconst_null
    //   21: invokespecial 74	android/support/transition/q:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/support/transition/Transition;)Landroid/support/transition/Transition;
    //   24: astore_2
    //   25: aload_1
    //   26: invokeinterface 339 1 0
    //   31: aload_2
    //   32: areturn
    //   33: astore_2
    //   34: new 176	android/view/InflateException
    //   37: dup
    //   38: aload_2
    //   39: invokevirtual 342	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   42: aload_2
    //   43: invokespecial 236	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   46: athrow
    //   47: astore_2
    //   48: aload_1
    //   49: invokeinterface 339 1 0
    //   54: aload_2
    //   55: athrow
    //   56: astore_2
    //   57: new 176	android/view/InflateException
    //   60: dup
    //   61: new 164	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   68: aload_1
    //   69: invokeinterface 345 1 0
    //   74: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 347
    //   80: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_2
    //   84: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   87: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: aload_2
    //   94: invokespecial 236	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	q
    //   13	56	1	localXmlResourceParser	android.content.res.XmlResourceParser
    //   24	8	2	localTransition	Transition
    //   33	10	2	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   47	8	2	localObject	Object
    //   56	38	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   14	25	33	org/xmlpull/v1/XmlPullParserException
    //   14	25	47	finally
    //   34	47	47	finally
    //   57	98	47	finally
    //   14	25	56	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.q
 * JD-Core Version:    0.7.0.1
 */