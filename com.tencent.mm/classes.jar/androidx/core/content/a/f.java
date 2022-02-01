package androidx.core.content.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class f
{
  private static final ThreadLocal<TypedValue> bqc;
  private static final WeakHashMap<b, SparseArray<a>> js;
  private static final Object jt;
  
  static
  {
    AppMethodBeat.i(195721);
    bqc = new ThreadLocal();
    js = new WeakHashMap(0);
    jt = new Object();
    AppMethodBeat.o(195721);
  }
  
  private static ColorStateList a(b paramb, int paramInt)
  {
    AppMethodBeat.i(195646);
    synchronized (jt)
    {
      SparseArray localSparseArray = (SparseArray)js.get(paramb);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.bqq.equals(paramb.mResources.getConfiguration()))
          {
            paramb = locala.bqp;
            AppMethodBeat.o(195646);
            return paramb;
          }
          localSparseArray.remove(paramInt);
        }
      }
      AppMethodBeat.o(195646);
      return null;
    }
  }
  
  public static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, c paramc)
  {
    AppMethodBeat.i(195677);
    if (paramContext.isRestricted())
    {
      AppMethodBeat.o(195677);
      return null;
    }
    paramContext = a(paramContext, paramInt1, paramTypedValue, paramInt2, paramc, true);
    AppMethodBeat.o(195677);
    return paramContext;
  }
  
  private static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(195691);
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    paramContext = a(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, paramc, null, paramBoolean);
    if ((paramContext == null) && (paramc == null))
    {
      paramContext = new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(paramInt1) + " could not be retrieved.");
      AppMethodBeat.o(195691);
      throw paramContext;
    }
    AppMethodBeat.o(195691);
    return paramContext;
  }
  
  /* Error */
  private static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, c paramc, Handler paramHandler, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 150
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: getfield 156	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   9: ifnonnull +59 -> 68
    //   12: new 121	android/content/res/Resources$NotFoundException
    //   15: dup
    //   16: new 123	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 158
    //   22: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_1
    //   26: iload_3
    //   27: invokevirtual 161	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   30: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 163
    //   35: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_3
    //   39: invokestatic 134	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 165
    //   47: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 145	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: ldc 150
    //   63: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: athrow
    //   68: aload_2
    //   69: getfield 156	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   72: invokeinterface 171 1 0
    //   77: astore_2
    //   78: aload_2
    //   79: ldc 173
    //   81: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   84: ifne +23 -> 107
    //   87: aload 5
    //   89: ifnull +11 -> 100
    //   92: aload 5
    //   94: bipush 253
    //   96: aconst_null
    //   97: invokevirtual 182	androidx/core/content/a/f$c:a	(ILandroid/os/Handler;)V
    //   100: ldc 150
    //   102: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aconst_null
    //   106: areturn
    //   107: aload_1
    //   108: iload_3
    //   109: iload 4
    //   111: invokestatic 187	androidx/core/graphics/e:a	(Landroid/content/res/Resources;II)Landroid/graphics/Typeface;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +24 -> 142
    //   121: aload 5
    //   123: ifnull +11 -> 134
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: invokevirtual 190	androidx/core/content/a/f$c:a	(Landroid/graphics/Typeface;Landroid/os/Handler;)V
    //   134: ldc 150
    //   136: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload 6
    //   141: areturn
    //   142: aload_2
    //   143: invokevirtual 193	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   146: ldc 195
    //   148: invokevirtual 198	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   151: ifeq +59 -> 210
    //   154: aload_1
    //   155: iload_3
    //   156: invokevirtual 202	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   159: aload_1
    //   160: invokestatic 207	androidx/core/content/a/c:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/a/c$a;
    //   163: astore_2
    //   164: aload_2
    //   165: ifnonnull +23 -> 188
    //   168: aload 5
    //   170: ifnull +11 -> 181
    //   173: aload 5
    //   175: bipush 253
    //   177: aconst_null
    //   178: invokevirtual 182	androidx/core/content/a/f$c:a	(ILandroid/os/Handler;)V
    //   181: ldc 150
    //   183: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   199: invokestatic 210	androidx/core/graphics/e:a	(Landroid/content/Context;Landroidx/core/content/a/c$a;Landroid/content/res/Resources;IILandroidx/core/content/a/f$c;Landroid/os/Handler;Z)Landroid/graphics/Typeface;
    //   202: astore_0
    //   203: ldc 150
    //   205: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_0
    //   209: areturn
    //   210: aload_0
    //   211: aload_1
    //   212: iload_3
    //   213: aload_2
    //   214: iload 4
    //   216: invokestatic 213	androidx/core/graphics/e:a	(Landroid/content/Context;Landroid/content/res/Resources;ILjava/lang/String;I)Landroid/graphics/Typeface;
    //   219: astore_0
    //   220: aload 5
    //   222: ifnull +14 -> 236
    //   225: aload_0
    //   226: ifnull +17 -> 243
    //   229: aload 5
    //   231: aload_0
    //   232: aconst_null
    //   233: invokevirtual 190	androidx/core/content/a/f$c:a	(Landroid/graphics/Typeface;Landroid/os/Handler;)V
    //   236: ldc 150
    //   238: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_0
    //   242: areturn
    //   243: aload 5
    //   245: bipush 253
    //   247: aconst_null
    //   248: invokevirtual 182	androidx/core/content/a/f$c:a	(ILandroid/os/Handler;)V
    //   251: goto -15 -> 236
    //   254: astore_0
    //   255: aload 5
    //   257: ifnull +11 -> 268
    //   260: aload 5
    //   262: bipush 253
    //   264: aconst_null
    //   265: invokevirtual 182	androidx/core/content/a/f$c:a	(ILandroid/os/Handler;)V
    //   268: ldc 150
    //   270: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	279	5	paramc	c
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
  
  public static void a(Context paramContext, int paramInt, c paramc)
  {
    AppMethodBeat.i(195667);
    androidx.core.f.f.checkNotNull(paramc);
    if (paramContext.isRestricted())
    {
      paramc.a(-4, null);
      AppMethodBeat.o(195667);
      return;
    }
    a(paramContext, paramInt, new TypedValue(), 0, paramc, false);
    AppMethodBeat.o(195667);
  }
  
  public static Drawable b(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(195594);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramResources = paramResources.getDrawable(paramInt, paramTheme);
      AppMethodBeat.o(195594);
      return paramResources;
    }
    paramResources = paramResources.getDrawable(paramInt);
    AppMethodBeat.o(195594);
    return paramResources;
  }
  
  public static ColorStateList c(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(195613);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramResources = paramResources.getColorStateList(paramInt, paramTheme);
      AppMethodBeat.o(195613);
      return paramResources;
    }
    b localb = new b(paramResources, paramTheme);
    ColorStateList localColorStateList = a(localb, paramInt);
    if (localColorStateList != null)
    {
      AppMethodBeat.o(195613);
      return localColorStateList;
    }
    localColorStateList = d(paramResources, paramInt, paramTheme);
    if (localColorStateList != null) {
      synchronized (jt)
      {
        paramTheme = (SparseArray)js.get(localb);
        paramResources = paramTheme;
        if (paramTheme == null)
        {
          paramResources = new SparseArray();
          js.put(localb, paramResources);
        }
        paramResources.append(paramInt, new a(localColorStateList, localb.mResources.getConfiguration()));
        AppMethodBeat.o(195613);
        return localColorStateList;
      }
    }
    paramResources = paramResources.getColorStateList(paramInt);
    AppMethodBeat.o(195613);
    return paramResources;
  }
  
  private static ColorStateList d(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(195628);
    TypedValue localTypedValue = (TypedValue)bqc.get();
    Object localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      bqc.set(localObject);
    }
    paramResources.getValue(paramInt, (TypedValue)localObject, true);
    if ((((TypedValue)localObject).type >= 28) && (((TypedValue)localObject).type <= 31)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(195628);
      return null;
    }
    localObject = paramResources.getXml(paramInt);
    try
    {
      paramResources = a.a(paramResources, (XmlPullParser)localObject, paramTheme);
      AppMethodBeat.o(195628);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      AppMethodBeat.o(195628);
    }
    return null;
  }
  
  public static Typeface x(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(195655);
    if (paramContext.isRestricted())
    {
      AppMethodBeat.o(195655);
      return null;
    }
    paramContext = a(paramContext, paramInt, new TypedValue(), 0, null, false);
    AppMethodBeat.o(195655);
    return paramContext;
  }
  
  static final class a
  {
    final ColorStateList bqp;
    final Configuration bqq;
    
    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.bqp = paramColorStateList;
      this.bqq = paramConfiguration;
    }
  }
  
  static final class b
  {
    final Resources mResources;
    final Resources.Theme mTheme;
    
    b(Resources paramResources, Resources.Theme paramTheme)
    {
      this.mResources = paramResources;
      this.mTheme = paramTheme;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195603);
      if (this == paramObject)
      {
        AppMethodBeat.o(195603);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(195603);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.mResources.equals(paramObject.mResources)) && (c.equals(this.mTheme, paramObject.mTheme)))
      {
        AppMethodBeat.o(195603);
        return true;
      }
      AppMethodBeat.o(195603);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(195611);
      int i = c.hash(new Object[] { this.mResources, this.mTheme });
      AppMethodBeat.o(195611);
      return i;
    }
  }
  
  public static abstract class c
  {
    public static Handler c(Handler paramHandler)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler(Looper.getMainLooper());
      }
      return localHandler;
    }
    
    public final void a(final int paramInt, Handler paramHandler)
    {
      c(paramHandler).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195571);
          f.c.this.as(paramInt);
          AppMethodBeat.o(195571);
        }
      });
    }
    
    public final void a(final Typeface paramTypeface, Handler paramHandler)
    {
      c(paramHandler).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195574);
          f.c.this.b(paramTypeface);
          AppMethodBeat.o(195574);
        }
      });
    }
    
    public abstract void as(int paramInt);
    
    public abstract void b(Typeface paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.content.a.f
 * JD-Core Version:    0.7.0.1
 */