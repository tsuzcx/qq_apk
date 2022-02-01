package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.b.b.i.a;
import com.bumptech.glide.load.c.a.b;
import com.bumptech.glide.load.c.a.c;
import com.bumptech.glide.load.c.a.c.a;
import com.bumptech.glide.load.c.a.d.a;
import com.bumptech.glide.load.c.a.e.a;
import com.bumptech.glide.load.c.b.d;
import com.bumptech.glide.load.c.d.b;
import com.bumptech.glide.load.c.e.c;
import com.bumptech.glide.load.c.f.b;
import com.bumptech.glide.load.c.f.e;
import com.bumptech.glide.load.c.s.a;
import com.bumptech.glide.load.c.s.b;
import com.bumptech.glide.load.c.s.c;
import com.bumptech.glide.load.c.s.d;
import com.bumptech.glide.load.c.t;
import com.bumptech.glide.load.c.u.a;
import com.bumptech.glide.load.c.u.b;
import com.bumptech.glide.load.c.u.c;
import com.bumptech.glide.load.c.v.a;
import com.bumptech.glide.load.c.w.a;
import com.bumptech.glide.load.c.w.b;
import com.bumptech.glide.load.c.w.d;
import com.bumptech.glide.load.c.x.a;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.d.a.p;
import com.bumptech.glide.load.d.a.r;
import com.bumptech.glide.load.d.a.s;
import com.bumptech.glide.manager.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
  implements ComponentCallbacks2
{
  private static volatile c aCg;
  private static volatile boolean aCh;
  private final com.bumptech.glide.load.b.k aCi;
  public final com.bumptech.glide.load.b.a.e aCj;
  private final com.bumptech.glide.load.b.b.h aCk;
  private final com.bumptech.glide.load.b.d.a aCl;
  public final e aCm;
  public final h aCn;
  public final com.bumptech.glide.load.b.a.b aCo;
  public final l aCp;
  final com.bumptech.glide.manager.d aCq;
  final List<j> aCr;
  private f aCs;
  
  private c(Context paramContext, com.bumptech.glide.load.b.k paramk, com.bumptech.glide.load.b.b.h paramh, com.bumptech.glide.load.b.a.e parame, com.bumptech.glide.load.b.a.b paramb, l paraml, com.bumptech.glide.manager.d paramd, int paramInt, com.bumptech.glide.e.f paramf, Map<Class<?>, k<?, ?>> paramMap, List<com.bumptech.glide.e.e<Object>> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(204440);
    this.aCr = new ArrayList();
    this.aCs = f.aCI;
    this.aCi = paramk;
    this.aCj = parame;
    this.aCo = paramb;
    this.aCk = paramh;
    this.aCp = paraml;
    this.aCq = paramd;
    this.aCl = new com.bumptech.glide.load.b.d.a(paramh, parame, (com.bumptech.glide.load.b)paramf.aFV.a(com.bumptech.glide.load.d.a.h.aLc));
    paramh = paramContext.getResources();
    this.aCn = new h();
    this.aCn.a(new com.bumptech.glide.load.d.a.f());
    if (Build.VERSION.SDK_INT >= 27) {
      this.aCn.a(new com.bumptech.glide.load.d.a.k());
    }
    paraml = this.aCn.nO();
    Object localObject = new com.bumptech.glide.load.d.a.h(paraml, paramh.getDisplayMetrics(), parame, paramb);
    paramd = new com.bumptech.glide.load.d.e.a(paramContext, paraml, parame, paramb);
    com.bumptech.glide.load.j localj = s.b(parame);
    com.bumptech.glide.load.d.a.e locale = new com.bumptech.glide.load.d.a.e((com.bumptech.glide.load.d.a.h)localObject);
    localObject = new p((com.bumptech.glide.load.d.a.h)localObject, paramb);
    com.bumptech.glide.load.d.c.d locald = new com.bumptech.glide.load.d.c.d(paramContext);
    s.c localc = new s.c(paramh);
    s.d locald1 = new s.d(paramh);
    s.b localb = new s.b(paramh);
    s.a locala = new s.a(paramh);
    com.bumptech.glide.load.d.a.c localc1 = new com.bumptech.glide.load.d.a.c(paramb);
    com.bumptech.glide.load.d.f.a locala1 = new com.bumptech.glide.load.d.f.a();
    com.bumptech.glide.load.d.f.d locald2 = new com.bumptech.glide.load.d.f.d();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    this.aCn.a(ByteBuffer.class, new com.bumptech.glide.load.c.c()).a(InputStream.class, new t(paramb)).a("Bitmap", ByteBuffer.class, Bitmap.class, locale).a("Bitmap", InputStream.class, Bitmap.class, (com.bumptech.glide.load.j)localObject).a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, localj).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, s.a(parame)).a(Bitmap.class, Bitmap.class, v.a.pw()).a("Bitmap", Bitmap.class, Bitmap.class, new r()).a(Bitmap.class, localc1).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(paramh, locale)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(paramh, (com.bumptech.glide.load.j)localObject)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(paramh, localj)).a(BitmapDrawable.class, new com.bumptech.glide.load.d.a.b(parame, localc1)).a("Gif", InputStream.class, com.bumptech.glide.load.d.e.c.class, new com.bumptech.glide.load.d.e.j(paraml, paramd, paramb)).a("Gif", ByteBuffer.class, com.bumptech.glide.load.d.e.c.class, paramd).a(com.bumptech.glide.load.d.e.c.class, new com.bumptech.glide.load.d.e.d()).a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, v.a.pw()).a("Bitmap", com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.load.d.e.h(parame)).a(Uri.class, Drawable.class, locald).a(Uri.class, Bitmap.class, new o(locald, parame)).a(new com.bumptech.glide.load.d.b.a.a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.bumptech.glide.load.d.d.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.pw()).a(new com.bumptech.glide.load.a.k.a(paramb)).a(Integer.TYPE, InputStream.class, localc).a(Integer.TYPE, ParcelFileDescriptor.class, localb).a(Integer.class, InputStream.class, localc).a(Integer.class, ParcelFileDescriptor.class, localb).a(Integer.class, Uri.class, locald1).a(Integer.TYPE, AssetFileDescriptor.class, locala).a(Integer.class, AssetFileDescriptor.class, locala).a(Integer.TYPE, Uri.class, locald1).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new com.bumptech.glide.load.c.a.b.a()).a(Uri.class, InputStream.class, new a.c(paramContext.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(paramContext.getAssets())).a(Uri.class, InputStream.class, new c.a(paramContext)).a(Uri.class, InputStream.class, new d.a(paramContext)).a(Uri.class, InputStream.class, new w.d(localContentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(localContentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(localContentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new com.bumptech.glide.load.c.k.a(paramContext)).a(com.bumptech.glide.load.c.g.class, InputStream.class, new com.bumptech.glide.load.c.a.a.a()).a([B.class, ByteBuffer.class, new com.bumptech.glide.load.c.b.a()).a([B.class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.pw()).a(Drawable.class, Drawable.class, v.a.pw()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.d.c.e()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.d.f.b(paramh)).a(Bitmap.class, [B.class, locala1).a(Drawable.class, [B.class, new com.bumptech.glide.load.d.f.c(parame, locala1, locald2)).a(com.bumptech.glide.load.d.e.c.class, [B.class, locald2);
    paramh = new com.bumptech.glide.e.a.b();
    this.aCm = new e(paramContext, paramb, this.aCn, paramh, paramf, paramMap, paramList, paramk, paramBoolean, paramInt);
    AppMethodBeat.o(204440);
  }
  
  private static void a(Context paramContext, d paramd)
  {
    AppMethodBeat.i(76773);
    paramContext = paramContext.getApplicationContext();
    Object localObject2 = nN();
    Collections.emptyList();
    Object localObject1 = new com.bumptech.glide.c.d(paramContext).pU();
    Object localObject3;
    Object localObject4;
    if ((localObject2 != null) && (!((a)localObject2).nM().isEmpty()))
    {
      localObject2 = ((a)localObject2).nM();
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.bumptech.glide.c.b)((Iterator)localObject3).next();
        if (((Set)localObject2).contains(localObject4.getClass()))
        {
          if (Log.isLoggable("Glide", 3)) {
            new StringBuilder("AppGlideModule excludes manifest GlideModule: ").append(localObject4);
          }
          ((Iterator)localObject3).remove();
        }
      }
    }
    if (Log.isLoggable("Glide", 3))
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.bumptech.glide.c.b)((Iterator)localObject2).next();
        new StringBuilder("Discovered GlideModule from manifest: ").append(localObject3.getClass());
      }
    }
    paramd.aCA = null;
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Iterator)localObject2).next();
    }
    if (paramd.aCu == null) {
      paramd.aCu = com.bumptech.glide.load.b.c.a.pn();
    }
    if (paramd.aCv == null) {
      paramd.aCv = com.bumptech.glide.load.b.c.a.pm();
    }
    if (paramd.aCB == null) {
      paramd.aCB = com.bumptech.glide.load.b.c.a.pp();
    }
    if (paramd.aCx == null) {
      paramd.aCx = new com.bumptech.glide.load.b.b.i(new i.a(paramContext));
    }
    if (paramd.aCq == null) {
      paramd.aCq = new com.bumptech.glide.manager.f();
    }
    int i;
    if (paramd.aCj == null)
    {
      i = paramd.aCx.aJb;
      if (i > 0) {
        paramd.aCj = new com.bumptech.glide.load.b.a.k(i);
      }
    }
    else
    {
      if (paramd.aCo == null) {
        paramd.aCo = new com.bumptech.glide.load.b.a.j(paramd.aCx.aJd);
      }
      if (paramd.aCk == null) {
        paramd.aCk = new com.bumptech.glide.load.b.b.g(paramd.aCx.aJc);
      }
      if (paramd.aCw == null) {
        paramd.aCw = new com.bumptech.glide.load.b.b.f(paramContext);
      }
      if (paramd.aCi == null) {
        paramd.aCi = new com.bumptech.glide.load.b.k(paramd.aCk, paramd.aCw, paramd.aCv, paramd.aCu, com.bumptech.glide.load.b.c.a.po(), com.bumptech.glide.load.b.c.a.pp(), paramd.aCC);
      }
      if (paramd.aCD != null) {
        break label619;
      }
    }
    label619:
    for (paramd.aCD = Collections.emptyList();; paramd.aCD = Collections.unmodifiableList(paramd.aCD))
    {
      localObject2 = new l(paramd.aCA);
      localObject3 = paramd.aCi;
      localObject4 = paramd.aCk;
      com.bumptech.glide.load.b.a.e locale = paramd.aCj;
      com.bumptech.glide.load.b.a.b localb = paramd.aCo;
      com.bumptech.glide.manager.d locald = paramd.aCq;
      i = paramd.aCy;
      com.bumptech.glide.e.f localf = paramd.aCz;
      localf.aHY = true;
      paramd = new c(paramContext, (com.bumptech.glide.load.b.k)localObject3, (com.bumptech.glide.load.b.b.h)localObject4, locale, localb, (l)localObject2, locald, i, (com.bumptech.glide.e.f)localf, paramd.aCt, paramd.aCD, paramd.aCE);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Iterator)localObject1).next();
      }
      paramd.aCj = new com.bumptech.glide.load.b.a.f();
      break;
    }
    paramContext.registerComponentCallbacks(paramd);
    aCg = paramd;
    AppMethodBeat.o(76773);
  }
  
  public static c af(Context paramContext)
  {
    AppMethodBeat.i(76772);
    if (aCg == null)
    {
      try
      {
        if (aCg != null) {
          break label77;
        }
        if (aCh)
        {
          paramContext = new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
          AppMethodBeat.o(76772);
          throw paramContext;
        }
      }
      finally
      {
        AppMethodBeat.o(76772);
      }
      aCh = true;
      a(paramContext, new d());
      aCh = false;
    }
    label77:
    paramContext = aCg;
    AppMethodBeat.o(76772);
    return paramContext;
  }
  
  public static j ag(Context paramContext)
  {
    AppMethodBeat.i(76777);
    com.bumptech.glide.g.j.checkNotNull(paramContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    paramContext = af(paramContext).aCp.ai(paramContext);
    AppMethodBeat.o(76777);
    return paramContext;
  }
  
  private static void d(Exception paramException)
  {
    AppMethodBeat.i(76775);
    paramException = new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", paramException);
    AppMethodBeat.o(76775);
    throw paramException;
  }
  
  private static a nN()
  {
    AppMethodBeat.i(76774);
    try
    {
      a locala = (a)Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(76774);
      return locala;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Log.isLoggable("Glide", 5);
        Object localObject1 = null;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        d(localInstantiationException);
        Object localObject2 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        d(localIllegalAccessException);
        Object localObject3 = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        d(localNoSuchMethodException);
        Object localObject4 = null;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        d(localInvocationTargetException);
        Object localObject5 = null;
      }
    }
  }
  
  final boolean a(com.bumptech.glide.e.a.e<?> parame)
  {
    AppMethodBeat.i(76778);
    synchronized (this.aCr)
    {
      Iterator localIterator = this.aCr.iterator();
      while (localIterator.hasNext()) {
        if (((j)localIterator.next()).d(parame))
        {
          AppMethodBeat.o(76778);
          return true;
        }
      }
      AppMethodBeat.o(76778);
      return false;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(76780);
    com.bumptech.glide.g.k.qv();
    this.aCk.oZ();
    this.aCj.oZ();
    this.aCo.oZ();
    AppMethodBeat.o(76780);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(76779);
    com.bumptech.glide.g.k.qv();
    this.aCk.trimMemory(paramInt);
    this.aCj.trimMemory(paramInt);
    this.aCo.trimMemory(paramInt);
    AppMethodBeat.o(76779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c
 * JD-Core Version:    0.7.0.1
 */