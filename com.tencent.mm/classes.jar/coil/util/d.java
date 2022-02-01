package coil.util;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.l.a.a.i;
import coil.e.b;
import coil.j.i.a;
import coil.j.l;
import coil.target.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import okhttp3.e.a;
import okhttp3.q;
import okhttp3.q.a;
import okhttp3.x;

@Metadata(d1={""}, d2={"EMPTY_HEADERS", "Lokhttp3/Headers;", "kotlin.jvm.PlatformType", "getEMPTY_HEADERS", "()Lokhttp3/Headers;", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "blockCountCompat", "", "Landroid/os/StatFs;", "getBlockCountCompat$annotations", "(Landroid/os/StatFs;)V", "getBlockCountCompat", "(Landroid/os/StatFs;)J", "blockSizeCompat", "getBlockSizeCompat$annotations", "getBlockSizeCompat", "emoji", "", "Lcoil/decode/DataSource;", "getEmoji", "(Lcoil/decode/DataSource;)Ljava/lang/String;", "firstPathSegment", "Landroid/net/Uri;", "getFirstPathSegment", "(Landroid/net/Uri;)Ljava/lang/String;", "height", "", "Landroid/graphics/drawable/Drawable;", "getHeight", "(Landroid/graphics/drawable/Drawable;)I", "identityHashCode", "", "getIdentityHashCode", "(Ljava/lang/Object;)I", "isAttachedToWindowCompat", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "isLowRamDeviceCompat", "Landroid/app/ActivityManager;", "(Landroid/app/ActivityManager;)Z", "isVector", "(Landroid/graphics/drawable/Drawable;)Z", "job", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "value", "Lcoil/request/ImageResult$Metadata;", "metadata", "Lcoil/memory/TargetDelegate;", "getMetadata", "(Lcoil/memory/TargetDelegate;)Lcoil/request/ImageResult$Metadata;", "setMetadata", "(Lcoil/memory/TargetDelegate;Lcoil/request/ImageResult$Metadata;)V", "nightMode", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "requestManager", "Lcoil/memory/ViewTargetRequestManager;", "getRequestManager", "(Landroid/view/View;)Lcoil/memory/ViewTargetRequestManager;", "scale", "Lcoil/size/Scale;", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", "width", "getWidth", "isMainThread", "lazyCallFactory", "Lokhttp3/Call$Factory;", "initializer", "Lkotlin/Function0;", "closeQuietly", "", "Ljava/io/Closeable;", "decrement", "Lcoil/bitmap/BitmapReferenceCounter;", "bitmap", "Landroid/graphics/Bitmap;", "drawable", "getMimeTypeFromUrl", "Landroid/webkit/MimeTypeMap;", "url", "invoke", "Lcoil/memory/MemoryCache$Key;", "Lcoil/memory/MemoryCache$Key$Companion;", "base", "parameters", "Lcoil/request/Parameters;", "transformations", "", "Lcoil/transform/Transformation;", "size", "Lcoil/size/Size;", "loop", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "Lkotlin/Function1;", "orEmpty", "setValid", "isValid", "coil-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final q cqq;
  
  static
  {
    AppMethodBeat.i(188259);
    cqq = new q.a().kGM();
    AppMethodBeat.o(188259);
  }
  
  public static final int D(Drawable paramDrawable)
  {
    AppMethodBeat.i(188133);
    kotlin.g.b.s.u(paramDrawable, "<this>");
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (localObject != null) {
        break label50;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label75;
      }
      i = paramDrawable.getIntrinsicWidth();
      AppMethodBeat.o(188133);
      return i;
      localObject = null;
      break;
      label50:
      localObject = ((BitmapDrawable)localObject).getBitmap();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((Bitmap)localObject).getWidth());
      }
    }
    label75:
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(188133);
    return i;
  }
  
  public static final int E(Drawable paramDrawable)
  {
    AppMethodBeat.i(188142);
    kotlin.g.b.s.u(paramDrawable, "<this>");
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (localObject != null) {
        break label50;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label75;
      }
      i = paramDrawable.getIntrinsicHeight();
      AppMethodBeat.o(188142);
      return i;
      localObject = null;
      break;
      label50:
      localObject = ((BitmapDrawable)localObject).getBitmap();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((Bitmap)localObject).getHeight());
      }
    }
    label75:
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(188142);
    return i;
  }
  
  public static final boolean F(Drawable paramDrawable)
  {
    AppMethodBeat.i(188150);
    kotlin.g.b.s.u(paramDrawable, "<this>");
    if (((paramDrawable instanceof i)) || ((Build.VERSION.SDK_INT >= 21) && ((paramDrawable instanceof VectorDrawable))))
    {
      AppMethodBeat.o(188150);
      return true;
    }
    AppMethodBeat.o(188150);
    return false;
  }
  
  public static final String a(MimeTypeMap paramMimeTypeMap, String paramString)
  {
    AppMethodBeat.i(188189);
    kotlin.g.b.s.u(paramMimeTypeMap, "<this>");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(188189);
      return null;
    }
    paramMimeTypeMap = paramMimeTypeMap.getMimeTypeFromExtension(n.c(n.c(n.b(n.b(paramString, '#'), '?'), '/'), '.', ""));
    AppMethodBeat.o(188189);
    return paramMimeTypeMap;
  }
  
  public static final String a(b paramb)
  {
    AppMethodBeat.i(188122);
    kotlin.g.b.s.u(paramb, "<this>");
    switch (d.a.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      paramb = new kotlin.p();
      AppMethodBeat.o(188122);
      throw paramb;
    case 1: 
    case 2: 
      AppMethodBeat.o(188122);
      return "🧠";
    case 3: 
      AppMethodBeat.o(188122);
      return "💾";
    }
    AppMethodBeat.o(188122);
    return "☁️ ";
  }
  
  private static final okhttp3.e a(j paramj, x paramx)
  {
    AppMethodBeat.i(188253);
    kotlin.g.b.s.u(paramj, "$lazy");
    paramj = ((e.a)paramj.getValue()).newCall(paramx);
    AppMethodBeat.o(188253);
    return paramj;
  }
  
  public static final q a(q paramq)
  {
    q localq = paramq;
    if (paramq == null) {
      localq = cqq;
    }
    return localq;
  }
  
  public static final void a(coil.memory.s params, i.a parama)
  {
    AppMethodBeat.i(188244);
    kotlin.g.b.s.u(params, "<this>");
    params = params.MT();
    if ((params instanceof c))
    {
      params = (c)params;
      if (params != null) {
        break label59;
      }
    }
    label59:
    for (params = null;; params = params.getView())
    {
      if (params != null) {
        cm(params).coM = parama;
      }
      AppMethodBeat.o(188244);
      return;
      params = null;
      break;
    }
  }
  
  public static final int b(Configuration paramConfiguration)
  {
    AppMethodBeat.i(188206);
    kotlin.g.b.s.u(paramConfiguration, "<this>");
    int i = paramConfiguration.uiMode;
    AppMethodBeat.o(188206);
    return i & 0x30;
  }
  
  public static final l b(l paraml)
  {
    l locall = paraml;
    if (paraml == null) {
      locall = l.cpP;
    }
    return locall;
  }
  
  public static final coil.size.e c(ImageView paramImageView)
  {
    AppMethodBeat.i(188168);
    kotlin.g.b.s.u(paramImageView, "<this>");
    paramImageView = paramImageView.getScaleType();
    if (paramImageView == null) {}
    for (int i = -1;; i = d.a.avl[paramImageView.ordinal()]) {
      switch (i)
      {
      default: 
        paramImageView = coil.size.e.cpY;
        AppMethodBeat.o(188168);
        return paramImageView;
      }
    }
    paramImageView = coil.size.e.cpZ;
    AppMethodBeat.o(188168);
    return paramImageView;
  }
  
  public static final void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(188157);
    kotlin.g.b.s.u(paramCloseable, "<this>");
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(188157);
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      AppMethodBeat.o(188157);
      throw paramCloseable;
    }
    catch (Exception paramCloseable)
    {
      AppMethodBeat.o(188157);
    }
  }
  
  /* Error */
  public static final coil.memory.t cm(android.view.View paramView)
  {
    // Byte code:
    //   0: ldc_w 341
    //   3: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 156
    //   9: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getstatic 346	coil/a/a$a:clC	I
    //   16: invokevirtual 352	android/view/View:getTag	(I)Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: instanceof 285
    //   24: ifeq +52 -> 76
    //   27: aload_1
    //   28: checkcast 285	coil/memory/t
    //   31: astore_1
    //   32: aload_1
    //   33: astore_2
    //   34: aload_1
    //   35: ifnonnull +33 -> 68
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: getstatic 346	coil/a/a$a:clC	I
    //   44: invokevirtual 352	android/view/View:getTag	(I)Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_1
    //   49: instanceof 285
    //   52: ifeq +29 -> 81
    //   55: aload_1
    //   56: checkcast 285	coil/memory/t
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +25 -> 86
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: astore_2
    //   68: ldc_w 341
    //   71: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_2
    //   75: areturn
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -46 -> 32
    //   81: aconst_null
    //   82: astore_1
    //   83: goto -23 -> 60
    //   86: new 285	coil/memory/t
    //   89: dup
    //   90: invokespecial 353	coil/memory/t:<init>	()V
    //   93: astore_1
    //   94: aload_0
    //   95: aload_1
    //   96: checkcast 355	android/view/View$OnAttachStateChangeListener
    //   99: invokevirtual 359	android/view/View:addOnAttachStateChangeListener	(Landroid/view/View$OnAttachStateChangeListener;)V
    //   102: aload_0
    //   103: getstatic 346	coil/a/a$a:clC	I
    //   106: aload_1
    //   107: invokevirtual 363	android/view/View:setTag	(ILjava/lang/Object;)V
    //   110: goto -46 -> 64
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: ldc_w 341
    //   119: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramView	android.view.View
    //   19	88	1	localObject1	Object
    //   113	10	1	localObject2	Object
    //   33	42	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	60	113	finally
    //   86	110	113	finally
  }
  
  public static final String g(Uri paramUri)
  {
    AppMethodBeat.i(188197);
    kotlin.g.b.s.u(paramUri, "<this>");
    paramUri = paramUri.getPathSegments();
    kotlin.g.b.s.s(paramUri, "pathSegments");
    paramUri = (String)kotlin.a.p.oL(paramUri);
    AppMethodBeat.o(188197);
    return paramUri;
  }
  
  public static final boolean isMainThread()
  {
    AppMethodBeat.i(188235);
    boolean bool = kotlin.g.b.s.p(Looper.myLooper(), Looper.getMainLooper());
    AppMethodBeat.o(188235);
    return bool;
  }
  
  public static final e.a n(a<? extends e.a> parama)
  {
    AppMethodBeat.i(188178);
    kotlin.g.b.s.u(parama, "initializer");
    parama = new d..ExternalSyntheticLambda0(k.cm(parama));
    AppMethodBeat.o(188178);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.util.d
 * JD-Core Version:    0.7.0.1
 */