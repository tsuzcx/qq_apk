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
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.b.b.i.a;
import com.bumptech.glide.c.c.a.b;
import com.bumptech.glide.c.c.a.c;
import com.bumptech.glide.c.c.a.c.a;
import com.bumptech.glide.c.c.a.d.a;
import com.bumptech.glide.c.c.a.e.a;
import com.bumptech.glide.c.c.b.d;
import com.bumptech.glide.c.c.d.b;
import com.bumptech.glide.c.c.e.c;
import com.bumptech.glide.c.c.f.b;
import com.bumptech.glide.c.c.f.e;
import com.bumptech.glide.c.c.s.a;
import com.bumptech.glide.c.c.s.b;
import com.bumptech.glide.c.c.s.c;
import com.bumptech.glide.c.c.s.d;
import com.bumptech.glide.c.c.t;
import com.bumptech.glide.c.c.u.a;
import com.bumptech.glide.c.c.u.b;
import com.bumptech.glide.c.c.u.c;
import com.bumptech.glide.c.c.v.a;
import com.bumptech.glide.c.c.w.a;
import com.bumptech.glide.c.c.w.b;
import com.bumptech.glide.c.c.w.d;
import com.bumptech.glide.c.c.x.a;
import com.bumptech.glide.c.d.a.n;
import com.bumptech.glide.c.d.a.o;
import com.bumptech.glide.c.d.a.q;
import com.bumptech.glide.c.d.a.r;
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
  private static volatile c azw;
  private static volatile boolean azx;
  private final com.bumptech.glide.c.b.b.h azA;
  private final com.bumptech.glide.c.b.d.a azB;
  public final e azC;
  public final h azD;
  public final com.bumptech.glide.c.b.a.b azE;
  public final l azF;
  final com.bumptech.glide.manager.d azG;
  final List<j> azH;
  private f azI;
  private final com.bumptech.glide.c.b.j azy;
  public final com.bumptech.glide.c.b.a.e azz;
  
  private c(Context paramContext, com.bumptech.glide.c.b.j paramj, com.bumptech.glide.c.b.b.h paramh, com.bumptech.glide.c.b.a.e parame, com.bumptech.glide.c.b.a.b paramb, l paraml, com.bumptech.glide.manager.d paramd, int paramInt, com.bumptech.glide.f.e parame1, Map<Class<?>, k<?, ?>> paramMap)
  {
    AppMethodBeat.i(76776);
    this.azH = new ArrayList();
    this.azI = f.azX;
    this.azy = paramj;
    this.azz = parame;
    this.azE = paramb;
    this.azA = paramh;
    this.azF = paraml;
    this.azG = paramd;
    this.azB = new com.bumptech.glide.c.b.d.a(paramh, parame, (com.bumptech.glide.c.b)parame1.aDv.a(com.bumptech.glide.c.d.a.h.aID));
    paramh = paramContext.getResources();
    this.azD = new h();
    paraml = this.azD;
    paramd = new com.bumptech.glide.c.d.a.f();
    paraml.aAm.a(paramd);
    Object localObject = new com.bumptech.glide.c.d.a.h(this.azD.nj(), paramh.getDisplayMetrics(), parame, paramb);
    paraml = new com.bumptech.glide.c.d.e.a(paramContext, this.azD.nj(), parame, paramb);
    paramd = r.b(parame);
    com.bumptech.glide.c.d.a.e locale = new com.bumptech.glide.c.d.a.e((com.bumptech.glide.c.d.a.h)localObject);
    localObject = new o((com.bumptech.glide.c.d.a.h)localObject, paramb);
    com.bumptech.glide.c.d.c.d locald = new com.bumptech.glide.c.d.c.d(paramContext);
    s.c localc = new s.c(paramh);
    s.d locald1 = new s.d(paramh);
    s.b localb = new s.b(paramh);
    s.a locala = new s.a(paramh);
    com.bumptech.glide.c.d.a.c localc1 = new com.bumptech.glide.c.d.a.c(paramb);
    com.bumptech.glide.c.d.f.a locala1 = new com.bumptech.glide.c.d.f.a();
    com.bumptech.glide.c.d.f.d locald2 = new com.bumptech.glide.c.d.f.d();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    this.azD.a(ByteBuffer.class, new com.bumptech.glide.c.c.c()).a(InputStream.class, new t(paramb)).a("Bitmap", ByteBuffer.class, Bitmap.class, locale).a("Bitmap", InputStream.class, Bitmap.class, (com.bumptech.glide.c.k)localObject).a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, paramd).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, r.a(parame)).a(Bitmap.class, Bitmap.class, v.a.oP()).a("Bitmap", Bitmap.class, Bitmap.class, new q()).a(Bitmap.class, localc1).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.c.d.a.a(paramh, locale)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.c.d.a.a(paramh, (com.bumptech.glide.c.k)localObject)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.c.d.a.a(paramh, paramd)).a(BitmapDrawable.class, new com.bumptech.glide.c.d.a.b(parame, localc1)).a("Gif", InputStream.class, com.bumptech.glide.c.d.e.c.class, new com.bumptech.glide.c.d.e.j(this.azD.nj(), paraml, paramb)).a("Gif", ByteBuffer.class, com.bumptech.glide.c.d.e.c.class, paraml).a(com.bumptech.glide.c.d.e.c.class, new com.bumptech.glide.c.d.e.d()).a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, v.a.oP()).a("Bitmap", com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.c.d.e.h(parame)).a(Uri.class, Drawable.class, locald).a(Uri.class, Bitmap.class, new n(locald, parame)).a(new com.bumptech.glide.c.d.b.a.a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.bumptech.glide.c.d.d.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.oP()).a(new com.bumptech.glide.c.a.k.a(paramb)).a(Integer.TYPE, InputStream.class, localc).a(Integer.TYPE, ParcelFileDescriptor.class, localb).a(Integer.class, InputStream.class, localc).a(Integer.class, ParcelFileDescriptor.class, localb).a(Integer.class, Uri.class, locald1).a(Integer.TYPE, AssetFileDescriptor.class, locala).a(Integer.class, AssetFileDescriptor.class, locala).a(Integer.TYPE, Uri.class, locald1).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new com.bumptech.glide.c.c.a.b.a()).a(Uri.class, InputStream.class, new a.c(paramContext.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(paramContext.getAssets())).a(Uri.class, InputStream.class, new c.a(paramContext)).a(Uri.class, InputStream.class, new d.a(paramContext)).a(Uri.class, InputStream.class, new w.d(localContentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(localContentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(localContentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new com.bumptech.glide.c.c.k.a(paramContext)).a(com.bumptech.glide.c.c.g.class, InputStream.class, new com.bumptech.glide.c.c.a.a.a()).a([B.class, ByteBuffer.class, new com.bumptech.glide.c.c.b.a()).a([B.class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.oP()).a(Drawable.class, Drawable.class, v.a.oP()).a(Drawable.class, Drawable.class, new com.bumptech.glide.c.d.c.e()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.c.d.f.b(paramh)).a(Bitmap.class, [B.class, locala1).a(Drawable.class, [B.class, new com.bumptech.glide.c.d.f.c(parame, locala1, locald2)).a(com.bumptech.glide.c.d.e.c.class, [B.class, locald2);
    paramh = new com.bumptech.glide.f.a.b();
    this.azC = new e(paramContext, paramb, this.azD, paramh, parame1, paramMap, paramj, paramInt);
    AppMethodBeat.o(76776);
  }
  
  private static void a(Context paramContext, d paramd)
  {
    AppMethodBeat.i(76773);
    paramContext = paramContext.getApplicationContext();
    Object localObject2 = ni();
    Collections.emptyList();
    Object localObject1 = new com.bumptech.glide.d.d(paramContext).pn();
    Object localObject3;
    Object localObject4;
    if ((localObject2 != null) && (!((a)localObject2).nh().isEmpty()))
    {
      localObject2 = ((a)localObject2).nh();
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.bumptech.glide.d.b)((Iterator)localObject3).next();
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
        localObject3 = (com.bumptech.glide.d.b)((Iterator)localObject2).next();
        new StringBuilder("Discovered GlideModule from manifest: ").append(localObject3.getClass());
      }
    }
    paramd.azQ = null;
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Iterator)localObject2).next();
    }
    if (paramd.azK == null) {
      paramd.azK = com.bumptech.glide.c.b.c.a.oG();
    }
    if (paramd.azL == null) {
      paramd.azL = com.bumptech.glide.c.b.c.a.oF();
    }
    if (paramd.azR == null) {
      paramd.azR = com.bumptech.glide.c.b.c.a.oI();
    }
    if (paramd.azN == null) {
      paramd.azN = new com.bumptech.glide.c.b.b.i(new i.a(paramContext));
    }
    if (paramd.azG == null) {
      paramd.azG = new com.bumptech.glide.manager.f();
    }
    int i;
    if (paramd.azz == null)
    {
      i = paramd.azN.aGB;
      if (i <= 0) {
        break label580;
      }
    }
    label580:
    for (paramd.azz = new com.bumptech.glide.c.b.a.k(i);; paramd.azz = new com.bumptech.glide.c.b.a.f())
    {
      if (paramd.azE == null) {
        paramd.azE = new com.bumptech.glide.c.b.a.j(paramd.azN.aGD);
      }
      if (paramd.azA == null) {
        paramd.azA = new com.bumptech.glide.c.b.b.g(paramd.azN.aGC);
      }
      if (paramd.azM == null) {
        paramd.azM = new com.bumptech.glide.c.b.b.f(paramContext);
      }
      if (paramd.azy == null) {
        paramd.azy = new com.bumptech.glide.c.b.j(paramd.azA, paramd.azM, paramd.azL, paramd.azK, com.bumptech.glide.c.b.c.a.oH(), com.bumptech.glide.c.b.c.a.oI(), paramd.azS);
      }
      localObject2 = new l(paramd.azQ);
      localObject3 = paramd.azy;
      localObject4 = paramd.azA;
      com.bumptech.glide.c.b.a.e locale = paramd.azz;
      com.bumptech.glide.c.b.a.b localb = paramd.azE;
      com.bumptech.glide.manager.d locald = paramd.azG;
      i = paramd.azO;
      com.bumptech.glide.f.e locale1 = paramd.azP;
      locale1.aFx = true;
      paramd = new c(paramContext, (com.bumptech.glide.c.b.j)localObject3, (com.bumptech.glide.c.b.b.h)localObject4, locale, localb, (l)localObject2, locald, i, locale1, paramd.azJ);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Iterator)localObject1).next();
      }
    }
    paramContext.registerComponentCallbacks(paramd);
    azw = paramd;
    AppMethodBeat.o(76773);
  }
  
  public static c ac(Context paramContext)
  {
    AppMethodBeat.i(76772);
    if (azw == null)
    {
      try
      {
        if (azw != null) {
          break label77;
        }
        if (azx)
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
      azx = true;
      a(paramContext, new d());
      azx = false;
    }
    label77:
    paramContext = azw;
    AppMethodBeat.o(76772);
    return paramContext;
  }
  
  public static j ad(Context paramContext)
  {
    AppMethodBeat.i(76777);
    com.bumptech.glide.h.i.checkNotNull(paramContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    paramContext = ac(paramContext).azF.af(paramContext);
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
  
  private static a ni()
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
  
  final boolean a(com.bumptech.glide.f.a.e<?> parame)
  {
    AppMethodBeat.i(76778);
    synchronized (this.azH)
    {
      Iterator localIterator = this.azH.iterator();
      while (localIterator.hasNext()) {
        if (((j)localIterator.next()).e(parame))
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
    com.bumptech.glide.h.j.pQ();
    this.azA.os();
    this.azz.os();
    this.azE.os();
    AppMethodBeat.o(76780);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(76779);
    com.bumptech.glide.h.j.pQ();
    this.azA.trimMemory(paramInt);
    this.azz.trimMemory(paramInt);
    this.azE.trimMemory(paramInt);
    AppMethodBeat.o(76779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c
 * JD-Core Version:    0.7.0.1
 */