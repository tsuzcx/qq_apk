package com.tencent.mm.kiss.widget.textview.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Constructor;

public class a
{
  private static Constructor<StaticLayout> Of;
  private static Object kgW;
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 22
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 32	com/tencent/mm/kiss/widget/textview/b/a:aIW	()Ljava/lang/Object;
    //   11: astore 12
    //   13: invokestatic 36	com/tencent/mm/kiss/widget/textview/b/a:aIX	()Ljava/lang/reflect/Constructor;
    //   16: astore 13
    //   18: aload 13
    //   20: ifnonnull +42 -> 62
    //   23: aload_0
    //   24: iload_1
    //   25: iload_2
    //   26: aload_3
    //   27: iload 4
    //   29: aload 5
    //   31: aload 12
    //   33: checkcast 38	android/text/TextDirectionHeuristic
    //   36: fload 6
    //   38: fload 7
    //   40: iload 8
    //   42: aload 9
    //   44: iload 10
    //   46: iload 11
    //   48: invokestatic 41	com/tencent/mm/kiss/widget/textview/b/a:a	(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FFZLandroid/text/TextUtils$TruncateAt;II)Landroid/text/StaticLayout;
    //   51: astore_0
    //   52: ldc 22
    //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: areturn
    //   62: aload 13
    //   64: bipush 13
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: iload_1
    //   76: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: iload_2
    //   83: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: dup
    //   88: iconst_3
    //   89: aload_3
    //   90: aastore
    //   91: dup
    //   92: iconst_4
    //   93: iload 4
    //   95: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: dup
    //   100: iconst_5
    //   101: aload 5
    //   103: aastore
    //   104: dup
    //   105: bipush 6
    //   107: aload 12
    //   109: aastore
    //   110: dup
    //   111: bipush 7
    //   113: fload 6
    //   115: invokestatic 55	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   118: aastore
    //   119: dup
    //   120: bipush 8
    //   122: fload 7
    //   124: invokestatic 55	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   127: aastore
    //   128: dup
    //   129: bipush 9
    //   131: iload 8
    //   133: invokestatic 60	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   136: aastore
    //   137: dup
    //   138: bipush 10
    //   140: aload 9
    //   142: aastore
    //   143: dup
    //   144: bipush 11
    //   146: iload 10
    //   148: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: dup
    //   153: bipush 12
    //   155: iload 11
    //   157: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: invokevirtual 66	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast 68	android/text/StaticLayout
    //   167: astore_0
    //   168: ldc 22
    //   170: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: goto -116 -> 57
    //   176: astore_0
    //   177: ldc 2
    //   179: monitorexit
    //   180: aload_0
    //   181: athrow
    //   182: astore_0
    //   183: new 70	java/lang/IllegalStateException
    //   186: dup
    //   187: new 72	java/lang/StringBuilder
    //   190: dup
    //   191: ldc 74
    //   193: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: aload_0
    //   197: invokevirtual 81	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   200: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 90	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   209: astore_0
    //   210: ldc 22
    //   212: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_0
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramCharSequence	CharSequence
    //   0	217	1	paramInt1	int
    //   0	217	2	paramInt2	int
    //   0	217	3	paramTextPaint	TextPaint
    //   0	217	4	paramInt3	int
    //   0	217	5	paramAlignment	Layout.Alignment
    //   0	217	6	paramFloat1	float
    //   0	217	7	paramFloat2	float
    //   0	217	8	paramBoolean	boolean
    //   0	217	9	paramTruncateAt	TextUtils.TruncateAt
    //   0	217	10	paramInt4	int
    //   0	217	11	paramInt5	int
    //   11	97	12	localObject	Object
    //   16	47	13	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   3	8	176	finally
    //   8	18	176	finally
    //   23	52	176	finally
    //   52	57	176	finally
    //   62	168	176	finally
    //   168	173	176	finally
    //   183	217	176	finally
    //   8	18	182	java/lang/Exception
    //   23	52	182	java/lang/Exception
    //   62	168	182	java/lang/Exception
  }
  
  private static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, TextDirectionHeuristic paramTextDirectionHeuristic, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(237771);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3).setAlignment(paramAlignment).setTextDirection(paramTextDirectionHeuristic).setLineSpacing(paramFloat2, paramFloat1).setIncludePad(paramBoolean).setEllipsizedWidth(paramInt4).setEllipsize(paramTruncateAt).setMaxLines(paramInt5).build();
    AppMethodBeat.o(237771);
    return paramCharSequence;
  }
  
  /* Error */
  @TargetApi(18)
  private static Object aIW()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 140
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 142	com/tencent/mm/kiss/widget/textview/b/a:kgW	Ljava/lang/Object;
    //   11: ifnull +17 -> 28
    //   14: getstatic 142	com/tencent/mm/kiss/widget/textview/b/a:kgW	Ljava/lang/Object;
    //   17: astore_0
    //   18: ldc 140
    //   20: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 148	android/os/Build$VERSION:SDK_INT	I
    //   31: bipush 18
    //   33: if_icmplt +27 -> 60
    //   36: getstatic 154	android/text/TextDirectionHeuristics:FIRSTSTRONG_LTR	Landroid/text/TextDirectionHeuristic;
    //   39: putstatic 142	com/tencent/mm/kiss/widget/textview/b/a:kgW	Ljava/lang/Object;
    //   42: getstatic 142	com/tencent/mm/kiss/widget/textview/b/a:kgW	Ljava/lang/Object;
    //   45: astore_0
    //   46: ldc 140
    //   48: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: goto -28 -> 23
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    //   60: ldc 2
    //   62: invokevirtual 160	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   65: ldc 162
    //   67: invokevirtual 168	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   70: astore_0
    //   71: aload_0
    //   72: ldc 169
    //   74: invokevirtual 173	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   77: aload_0
    //   78: invokevirtual 179	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: putstatic 142	com/tencent/mm/kiss/widget/textview/b/a:kgW	Ljava/lang/Object;
    //   84: goto -42 -> 42
    //   87: astore_0
    //   88: ldc 181
    //   90: aload_0
    //   91: ldc 183
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: ldc 181
    //   102: new 72	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 191
    //   108: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload_0
    //   112: invokevirtual 194	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: new 203	java/lang/RuntimeException
    //   127: dup
    //   128: aload_0
    //   129: invokespecial 206	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   132: astore_0
    //   133: ldc 140
    //   135: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: athrow
    //   140: astore_0
    //   141: ldc 181
    //   143: aload_0
    //   144: ldc 208
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: goto -53 -> 100
    //   156: astore_0
    //   157: ldc 181
    //   159: aload_0
    //   160: ldc 210
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: goto -69 -> 100
    //   172: astore_0
    //   173: ldc 181
    //   175: aload_0
    //   176: ldc 212
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -85 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	29	0	localObject1	Object
    //   54	5	0	localObject2	Object
    //   70	8	0	localClass	Class
    //   87	42	0	localClassNotFoundException	ClassNotFoundException
    //   132	7	0	localRuntimeException	java.lang.RuntimeException
    //   140	4	0	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   156	4	0	localIllegalAccessException	java.lang.IllegalAccessException
    //   172	4	0	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	23	54	finally
    //   28	42	54	finally
    //   42	46	54	finally
    //   46	51	54	finally
    //   60	84	54	finally
    //   88	100	54	finally
    //   100	140	54	finally
    //   141	153	54	finally
    //   157	169	54	finally
    //   173	185	54	finally
    //   28	42	87	java/lang/ClassNotFoundException
    //   42	46	87	java/lang/ClassNotFoundException
    //   60	84	87	java/lang/ClassNotFoundException
    //   28	42	140	java/lang/NoSuchFieldException
    //   42	46	140	java/lang/NoSuchFieldException
    //   60	84	140	java/lang/NoSuchFieldException
    //   28	42	156	java/lang/IllegalAccessException
    //   42	46	156	java/lang/IllegalAccessException
    //   60	84	156	java/lang/IllegalAccessException
    //   28	42	172	java/lang/Throwable
    //   42	46	172	java/lang/Throwable
    //   60	84	172	java/lang/Throwable
  }
  
  @TargetApi(18)
  private static Constructor<StaticLayout> aIX()
  {
    Object localObject4 = null;
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(237768);
        Object localObject1;
        if (Of != null)
        {
          localObject1 = Of;
          AppMethodBeat.o(237768);
          return localObject1;
        }
        if (Build.VERSION.SDK_INT >= 29)
        {
          if (i == 0) {
            break label65;
          }
          AppMethodBeat.o(237768);
          localObject1 = localObject4;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      for (;;)
      {
        try
        {
          label65:
          if (Build.VERSION.SDK_INT < 18) {
            continue;
          }
          localObject3 = TextDirectionHeuristic.class;
          localObject3 = StaticLayout.class.getDeclaredConstructor(new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, localObject3, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE });
          Of = (Constructor)localObject3;
          ((Constructor)localObject3).setAccessible(true);
          localObject3 = null;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Object localObject3;
          Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", localNoSuchMethodException, "StaticLayout constructor with max lines not found.", new Object[0]);
          continue;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", localClassNotFoundException, "TextDirectionHeuristic class not found.", new Object[0]);
          continue;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("StaticTextView.StaticLayoutWithMaxLines", localThrowable, "Other error.", new Object[0]);
          continue;
          Constructor localConstructor = Of;
          AppMethodBeat.o(237768);
        }
        if (localObject3 == null) {
          continue;
        }
        Log.w("StaticTextView.StaticLayoutWithMaxLines", "create StaticLayout constructor fail: " + ((Throwable)localObject3).getMessage());
        Log.w("StaticTextView.StaticLayoutWithMaxLines", "use builtin StaticLayout.Builder as fallback!");
        AppMethodBeat.o(237768);
        localObject3 = localObject4;
        break;
        localObject3 = a.class.getClassLoader().loadClass("android.text.TextDirectionHeuristic");
      }
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public static StaticLayout b(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, TextDirectionHeuristic paramTextDirectionHeuristic, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 251
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 32	com/tencent/mm/kiss/widget/textview/b/a:aIW	()Ljava/lang/Object;
    //   11: astore 13
    //   13: invokestatic 36	com/tencent/mm/kiss/widget/textview/b/a:aIX	()Ljava/lang/reflect/Constructor;
    //   16: astore 14
    //   18: aload 14
    //   20: ifnonnull +42 -> 62
    //   23: aload_0
    //   24: iload_1
    //   25: iload_2
    //   26: aload_3
    //   27: iload 4
    //   29: aload 5
    //   31: aload 13
    //   33: checkcast 38	android/text/TextDirectionHeuristic
    //   36: fload 7
    //   38: fload 8
    //   40: iload 9
    //   42: aload 10
    //   44: iload 11
    //   46: iload 12
    //   48: invokestatic 41	com/tencent/mm/kiss/widget/textview/b/a:a	(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FFZLandroid/text/TextUtils$TruncateAt;II)Landroid/text/StaticLayout;
    //   51: astore_0
    //   52: ldc 251
    //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: areturn
    //   62: aload 14
    //   64: bipush 13
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: iload_1
    //   76: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: iload_2
    //   83: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: dup
    //   88: iconst_3
    //   89: aload_3
    //   90: aastore
    //   91: dup
    //   92: iconst_4
    //   93: iload 4
    //   95: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: dup
    //   100: iconst_5
    //   101: aload 5
    //   103: aastore
    //   104: dup
    //   105: bipush 6
    //   107: aload 6
    //   109: aastore
    //   110: dup
    //   111: bipush 7
    //   113: fload 7
    //   115: invokestatic 55	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   118: aastore
    //   119: dup
    //   120: bipush 8
    //   122: fload 8
    //   124: invokestatic 55	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   127: aastore
    //   128: dup
    //   129: bipush 9
    //   131: iload 9
    //   133: invokestatic 60	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   136: aastore
    //   137: dup
    //   138: bipush 10
    //   140: aload 10
    //   142: aastore
    //   143: dup
    //   144: bipush 11
    //   146: iload 11
    //   148: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: dup
    //   153: bipush 12
    //   155: iload 12
    //   157: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: invokevirtual 66	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast 68	android/text/StaticLayout
    //   167: astore_0
    //   168: ldc 251
    //   170: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: goto -116 -> 57
    //   176: astore_0
    //   177: ldc 2
    //   179: monitorexit
    //   180: aload_0
    //   181: athrow
    //   182: astore_0
    //   183: new 70	java/lang/IllegalStateException
    //   186: dup
    //   187: new 72	java/lang/StringBuilder
    //   190: dup
    //   191: ldc 74
    //   193: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: aload_0
    //   197: invokevirtual 81	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   200: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 90	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   209: astore_0
    //   210: ldc 251
    //   212: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_0
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramCharSequence	CharSequence
    //   0	217	1	paramInt1	int
    //   0	217	2	paramInt2	int
    //   0	217	3	paramTextPaint	TextPaint
    //   0	217	4	paramInt3	int
    //   0	217	5	paramAlignment	Layout.Alignment
    //   0	217	6	paramTextDirectionHeuristic	TextDirectionHeuristic
    //   0	217	7	paramFloat1	float
    //   0	217	8	paramFloat2	float
    //   0	217	9	paramBoolean	boolean
    //   0	217	10	paramTruncateAt	TextUtils.TruncateAt
    //   0	217	11	paramInt4	int
    //   0	217	12	paramInt5	int
    //   11	21	13	localObject	Object
    //   16	47	14	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   3	8	176	finally
    //   8	18	176	finally
    //   23	52	176	finally
    //   52	57	176	finally
    //   62	168	176	finally
    //   168	173	176	finally
    //   183	217	176	finally
    //   8	18	182	java/lang/Exception
    //   23	52	182	java/lang/Exception
    //   62	168	182	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.b.a
 * JD-Core Version:    0.7.0.1
 */