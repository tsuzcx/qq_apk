package androidx.core.content.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, a parama)
  {
    AppMethodBeat.i(250620);
    if (paramContext.isRestricted())
    {
      AppMethodBeat.o(250620);
      return null;
    }
    paramContext = a(paramContext, paramInt1, paramTypedValue, paramInt2, parama, true);
    AppMethodBeat.o(250620);
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(250621);
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    paramContext = a(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, parama, null, paramBoolean);
    if ((paramContext == null) && (parama == null))
    {
      paramContext = new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(paramInt1) + " could not be retrieved.");
      AppMethodBeat.o(250621);
      throw paramContext;
    }
    AppMethodBeat.o(250621);
    return paramContext;
  }
  
  /* Error */
  private static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, a parama, Handler paramHandler, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: getfield 84	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   9: ifnonnull +59 -> 68
    //   12: new 48	android/content/res/Resources$NotFoundException
    //   15: dup
    //   16: new 50	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 86
    //   22: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_1
    //   26: iload_3
    //   27: invokevirtual 89	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   30: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 91
    //   35: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_3
    //   39: invokestatic 62	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   42: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 93
    //   47: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 73	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: ldc 78
    //   63: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: athrow
    //   68: aload_2
    //   69: getfield 84	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   72: invokeinterface 99 1 0
    //   77: astore_2
    //   78: aload_2
    //   79: ldc 101
    //   81: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   84: ifne +23 -> 107
    //   87: aload 5
    //   89: ifnull +11 -> 100
    //   92: aload 5
    //   94: bipush 253
    //   96: aconst_null
    //   97: invokevirtual 110	androidx/core/content/a/f$a:a	(ILandroid/os/Handler;)V
    //   100: ldc 78
    //   102: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aconst_null
    //   106: areturn
    //   107: aload_1
    //   108: iload_3
    //   109: iload 4
    //   111: invokestatic 115	androidx/core/graphics/e:a	(Landroid/content/res/Resources;II)Landroid/graphics/Typeface;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +24 -> 142
    //   121: aload 5
    //   123: ifnull +11 -> 134
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: invokevirtual 118	androidx/core/content/a/f$a:a	(Landroid/graphics/Typeface;Landroid/os/Handler;)V
    //   134: ldc 78
    //   136: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload 6
    //   141: areturn
    //   142: aload_2
    //   143: invokevirtual 121	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   146: ldc 123
    //   148: invokevirtual 126	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   151: ifeq +59 -> 210
    //   154: aload_1
    //   155: iload_3
    //   156: invokevirtual 130	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   159: aload_1
    //   160: invokestatic 135	androidx/core/content/a/c:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/a/c$a;
    //   163: astore_2
    //   164: aload_2
    //   165: ifnonnull +23 -> 188
    //   168: aload 5
    //   170: ifnull +11 -> 181
    //   173: aload 5
    //   175: bipush 253
    //   177: aconst_null
    //   178: invokevirtual 110	androidx/core/content/a/f$a:a	(ILandroid/os/Handler;)V
    //   181: ldc 78
    //   183: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aconst_null
    //   187: areturn
    //   188: aload_0
    //   189: aload_2
    //   190: aload_1
    //   191: iload_3
    //   192: iload 4
    //   194: aload 5
    //   196: aconst_null
    //   197: iload 7
    //   199: invokestatic 138	androidx/core/graphics/e:a	(Landroid/content/Context;Landroidx/core/content/a/c$a;Landroid/content/res/Resources;IILandroidx/core/content/a/f$a;Landroid/os/Handler;Z)Landroid/graphics/Typeface;
    //   202: astore_0
    //   203: ldc 78
    //   205: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_0
    //   209: areturn
    //   210: aload_0
    //   211: aload_1
    //   212: iload_3
    //   213: aload_2
    //   214: iload 4
    //   216: invokestatic 141	androidx/core/graphics/e:a	(Landroid/content/Context;Landroid/content/res/Resources;ILjava/lang/String;I)Landroid/graphics/Typeface;
    //   219: astore_0
    //   220: aload 5
    //   222: ifnull +14 -> 236
    //   225: aload_0
    //   226: ifnull +17 -> 243
    //   229: aload 5
    //   231: aload_0
    //   232: aconst_null
    //   233: invokevirtual 118	androidx/core/content/a/f$a:a	(Landroid/graphics/Typeface;Landroid/os/Handler;)V
    //   236: ldc 78
    //   238: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_0
    //   242: areturn
    //   243: aload 5
    //   245: bipush 253
    //   247: aconst_null
    //   248: invokevirtual 110	androidx/core/content/a/f$a:a	(ILandroid/os/Handler;)V
    //   251: goto -15 -> 236
    //   254: astore_0
    //   255: aload 5
    //   257: ifnull +11 -> 268
    //   260: aload 5
    //   262: bipush 253
    //   264: aconst_null
    //   265: invokevirtual 110	androidx/core/content/a/f$a:a	(ILandroid/os/Handler;)V
    //   268: ldc 78
    //   270: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aconst_null
    //   274: areturn
    //   275: astore_0
    //   276: goto -21 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   0	279	1	paramResources	Resources
    //   0	279	2	paramTypedValue	TypedValue
    //   0	279	3	paramInt1	int
    //   0	279	4	paramInt2	int
    //   0	279	5	parama	a
    //   0	279	6	paramHandler	Handler
    //   0	279	7	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   142	164	254	org/xmlpull/v1/XmlPullParserException
    //   173	181	254	org/xmlpull/v1/XmlPullParserException
    //   188	203	254	org/xmlpull/v1/XmlPullParserException
    //   210	220	254	org/xmlpull/v1/XmlPullParserException
    //   229	236	254	org/xmlpull/v1/XmlPullParserException
    //   243	251	254	org/xmlpull/v1/XmlPullParserException
    //   142	164	275	java/io/IOException
    //   173	181	275	java/io/IOException
    //   188	203	275	java/io/IOException
    //   210	220	275	java/io/IOException
    //   229	236	275	java/io/IOException
    //   243	251	275	java/io/IOException
  }
  
  public static Drawable b(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(250619);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramResources = paramResources.getDrawable(paramInt, paramTheme);
      AppMethodBeat.o(250619);
      return paramResources;
    }
    paramResources = paramResources.getDrawable(paramInt);
    AppMethodBeat.o(250619);
    return paramResources;
  }
  
  public static abstract class a
  {
    public final void a(final int paramInt, Handler paramHandler)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler(Looper.getMainLooper());
      }
      localHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250618);
          f.a.this.au(paramInt);
          AppMethodBeat.o(250618);
        }
      });
    }
    
    public abstract void a(Typeface paramTypeface);
    
    public final void a(final Typeface paramTypeface, Handler paramHandler)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler(Looper.getMainLooper());
      }
      localHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250617);
          f.a.this.a(paramTypeface);
          AppMethodBeat.o(250617);
        }
      });
    }
    
    public abstract void au(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.content.a.f
 * JD-Core Version:    0.7.0.1
 */