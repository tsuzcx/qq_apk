package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import androidx.b.a;
import androidx.core.content.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

public final class r
{
  private static final Class<?>[] ase;
  private static final a<String, Constructor> asf;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(192801);
    ase = new Class[] { Context.class, AttributeSet.class };
    asf = new a();
    AppMethodBeat.o(192801);
  }
  
  private r(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Transition a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
  {
    AppMethodBeat.i(192765);
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
      label29:
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label646;
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
              break label29;
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
                if (paramTransition == null)
                {
                  paramXmlPullParser = new RuntimeException("Invalid use of arcMotion element");
                  AppMethodBeat.o(192765);
                  throw paramXmlPullParser;
                }
                paramTransition.a(new ArcMotion(this.mContext, paramAttributeSet));
                continue;
              }
              if ("pathMotion".equals(str))
              {
                if (paramTransition == null)
                {
                  paramXmlPullParser = new RuntimeException("Invalid use of pathMotion element");
                  AppMethodBeat.o(192765);
                  throw paramXmlPullParser;
                }
                paramTransition.a((PathMotion)a(paramAttributeSet, PathMotion.class, "pathMotion"));
                continue;
              }
              if ("patternPathMotion".equals(str))
              {
                if (paramTransition == null)
                {
                  paramXmlPullParser = new RuntimeException("Invalid use of patternPathMotion element");
                  AppMethodBeat.o(192765);
                  throw paramXmlPullParser;
                }
                paramTransition.a(new PatternPathMotion(this.mContext, paramAttributeSet));
                continue;
              }
              paramXmlPullParser = new RuntimeException("Unknown scene name: " + paramXmlPullParser.getName());
              AppMethodBeat.o(192765);
              throw paramXmlPullParser;
            }
            if (paramTransition != null)
            {
              paramXmlPullParser = new InflateException("Could not add transition to another transition.");
              AppMethodBeat.o(192765);
              throw paramXmlPullParser;
            }
          }
        }
      }
    }
    label646:
    AppMethodBeat.o(192765);
    return localObject;
  }
  
  /* Error */
  private Object a(AttributeSet paramAttributeSet, Class paramClass, String paramString)
  {
    // Byte code:
    //   0: ldc 189
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: aconst_null
    //   7: ldc 191
    //   9: invokeinterface 195 3 0
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull +37 -> 55
    //   21: new 183	android/view/InflateException
    //   24: dup
    //   25: new 171	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   32: aload_3
    //   33: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 198
    //   38: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 186	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   47: astore_1
    //   48: ldc 189
    //   50: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_1
    //   54: athrow
    //   55: getstatic 36	androidx/transition/r:asf	Landroidx/b/a;
    //   58: astore 6
    //   60: aload 6
    //   62: monitorenter
    //   63: getstatic 36	androidx/transition/r:asf	Landroidx/b/a;
    //   66: aload 5
    //   68: invokevirtual 202	androidx/b/a:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 204	java/lang/reflect/Constructor
    //   74: astore 4
    //   76: aload 4
    //   78: astore_3
    //   79: aload 4
    //   81: ifnonnull +53 -> 134
    //   84: aload_0
    //   85: getfield 44	androidx/transition/r:mContext	Landroid/content/Context;
    //   88: invokevirtual 208	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   91: aload 5
    //   93: invokevirtual 214	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   96: aload_2
    //   97: invokevirtual 218	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   100: astore 7
    //   102: aload 4
    //   104: astore_3
    //   105: aload 7
    //   107: ifnull +27 -> 134
    //   110: aload 7
    //   112: getstatic 29	androidx/transition/r:ase	[Ljava/lang/Class;
    //   115: invokevirtual 222	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   118: astore_3
    //   119: aload_3
    //   120: iconst_1
    //   121: invokevirtual 226	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   124: getstatic 36	androidx/transition/r:asf	Landroidx/b/a;
    //   127: aload 5
    //   129: aload_3
    //   130: invokevirtual 230	androidx/b/a:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: pop
    //   134: aload_3
    //   135: iconst_2
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_0
    //   142: getfield 44	androidx/transition/r:mContext	Landroid/content/Context;
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload_1
    //   149: aastore
    //   150: invokevirtual 234	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore_1
    //   154: aload 6
    //   156: monitorexit
    //   157: ldc 189
    //   159: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: areturn
    //   164: astore_1
    //   165: aload 6
    //   167: monitorexit
    //   168: ldc 189
    //   170: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: new 183	android/view/InflateException
    //   179: dup
    //   180: new 171	java/lang/StringBuilder
    //   183: dup
    //   184: ldc 236
    //   186: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_2
    //   190: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: ldc 241
    //   195: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 5
    //   200: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aload_1
    //   207: invokespecial 244	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: astore_1
    //   211: ldc 189
    //   213: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload_1
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	r
    //   0	218	1	paramAttributeSet	AttributeSet
    //   0	218	2	paramClass	Class
    //   0	218	3	paramString	String
    //   74	29	4	localConstructor	Constructor
    //   14	185	5	str	String
    //   100	11	7	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   63	76	164	finally
    //   84	102	164	finally
    //   110	134	164	finally
    //   134	157	164	finally
    //   55	63	175	java/lang/Exception
    //   165	175	175	java/lang/Exception
  }
  
  public static r aa(Context paramContext)
  {
    AppMethodBeat.i(192742);
    paramContext = new r(paramContext);
    AppMethodBeat.o(192742);
    return paramContext;
  }
  
  private void b(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
  {
    AppMethodBeat.i(192798);
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
      TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, q.ari);
      j = g.b(localTypedArray, paramXmlPullParser, "targetId", 1);
      if (j != 0) {
        paramTransition.dx(j);
      }
      for (;;)
      {
        localTypedArray.recycle();
        break;
        j = g.b(localTypedArray, paramXmlPullParser, "excludeId", 2);
        if (j != 0)
        {
          paramTransition.l(j, true);
        }
        else
        {
          Object localObject = g.c(localTypedArray, paramXmlPullParser, "targetName", 4);
          if (localObject != null)
          {
            paramTransition.S((String)localObject);
          }
          else
          {
            localObject = g.c(localTypedArray, paramXmlPullParser, "excludeName", 5);
            if (localObject != null)
            {
              paramTransition.c((String)localObject, true);
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
                  paramXmlPullParser = new RuntimeException("Could not create ".concat(String.valueOf(localObject)), paramXmlPullParser);
                  AppMethodBeat.o(192798);
                  throw paramXmlPullParser;
                }
              }
              else
              {
                localObject = str;
                str = g.c(localTypedArray, paramXmlPullParser, "targetClass", 0);
                if (str != null)
                {
                  localObject = str;
                  paramTransition.j(Class.forName(str));
                }
              }
            }
          }
        }
      }
    }
    paramXmlPullParser = new RuntimeException("Unknown scene name: " + paramXmlPullParser.getName());
    AppMethodBeat.o(192798);
    throw paramXmlPullParser;
    AppMethodBeat.o(192798);
  }
  
  /* Error */
  public final Transition dy(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 331
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 44	androidx/transition/r:mContext	Landroid/content/Context;
    //   10: invokevirtual 335	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   13: iload_1
    //   14: invokevirtual 341	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   17: astore_2
    //   18: aload_0
    //   19: aload_2
    //   20: aload_2
    //   21: invokestatic 347	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   24: aconst_null
    //   25: invokespecial 81	androidx/transition/r:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroidx/transition/Transition;)Landroidx/transition/Transition;
    //   28: astore_3
    //   29: aload_2
    //   30: invokeinterface 352 1 0
    //   35: ldc_w 331
    //   38: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_3
    //   42: areturn
    //   43: astore_3
    //   44: new 183	android/view/InflateException
    //   47: dup
    //   48: aload_3
    //   49: invokevirtual 355	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   52: aload_3
    //   53: invokespecial 244	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: astore_3
    //   57: ldc_w 331
    //   60: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_3
    //   64: athrow
    //   65: astore_3
    //   66: aload_2
    //   67: invokeinterface 352 1 0
    //   72: ldc_w 331
    //   75: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: athrow
    //   80: astore_3
    //   81: new 183	android/view/InflateException
    //   84: dup
    //   85: new 171	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   92: aload_2
    //   93: invokeinterface 358 1 0
    //   98: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 360
    //   104: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_3
    //   108: invokevirtual 361	java/io/IOException:getMessage	()Ljava/lang/String;
    //   111: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aload_3
    //   118: invokespecial 244	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: astore_3
    //   122: ldc_w 331
    //   125: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_3
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	r
    //   0	130	1	paramInt	int
    //   17	76	2	localXmlResourceParser	android.content.res.XmlResourceParser
    //   28	14	3	localTransition	Transition
    //   43	10	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   56	8	3	localInflateException1	InflateException
    //   65	14	3	localObject	Object
    //   80	38	3	localIOException	java.io.IOException
    //   121	8	3	localInflateException2	InflateException
    // Exception table:
    //   from	to	target	type
    //   18	29	43	org/xmlpull/v1/XmlPullParserException
    //   18	29	65	finally
    //   44	65	65	finally
    //   81	130	65	finally
    //   18	29	80	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.r
 * JD-Core Version:    0.7.0.1
 */