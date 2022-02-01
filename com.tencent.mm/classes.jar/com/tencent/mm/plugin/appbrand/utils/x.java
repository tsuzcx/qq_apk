package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"TAG", "", "loadIcon", "Landroid/graphics/Bitmap;", "iconUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachIcon", "", "Landroid/widget/ImageView;", "attachTo", "imageView", "(Ljava/lang/String;Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final Object a(String paramString, ImageView paramImageView, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(317328);
    Object localObject;
    if ((paramd instanceof b))
    {
      localObject = (b)paramd;
      if ((((b)localObject).label & 0x80000000) != 0) {
        ((b)localObject).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject;; paramd = new b(paramd))
    {
      localObject = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(317328);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject);
    if (paramImageView == null)
    {
      Log.w("MicroMsg.AppBrand.IconAttacher", "attachTo, imageView is null");
      paramString = ah.aiuX;
      AppMethodBeat.o(317328);
      return paramString;
    }
    paramImageView.setTag(paramString);
    for (;;)
    {
      try
      {
        paramd.L$0 = paramString;
        paramd.Uf = paramImageView;
        paramd.label = 1;
        localObject = new q(kotlin.d.a.b.au(paramd), 1);
        ((q)localObject).kBA();
        final kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localObject;
        d locald = new d(paramString, localp);
        com.tencent.mm.modelappbrand.a.b.bEY().a((b.k)locald, paramString, null);
        localp.bg((kotlin.g.a.b)new c(locald));
        localObject = ((q)localObject).getResult();
        if (localObject == a.aiwj) {
          s.u(paramd, "frame");
        }
        paramd = (kotlin.d.d<? super ah>)localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(317328);
          return locala;
          paramImageView = (ImageView)paramd.Uf;
          paramString = (String)paramd.L$0;
          ResultKt.throwOnFailure(localObject);
          paramd = (kotlin.d.d<? super ah>)localObject;
        }
        paramd = (Bitmap)paramd;
        if (!s.p(paramString, paramImageView.getTag())) {
          continue;
        }
        paramImageView.setImageBitmap(paramd);
      }
      catch (IOException paramString)
      {
        Log.w("MicroMsg.AppBrand.IconAttacher", s.X("attachTo, loadIcon fail since ", paramString));
        continue;
      }
      paramString = ah.aiuX;
      AppMethodBeat.o(317328);
      return paramString;
      Log.i("MicroMsg.AppBrand.IconAttacher", "attachTo, imageView already reused");
    }
  }
  
  public static final void c(final ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(317331);
    s.u(paramImageView, "<this>");
    if (paramString == null)
    {
      AppMethodBeat.o(317331);
      return;
    }
    com.tencent.mm.modelappbrand.a.b.bEY().a((b.k)new a(paramString, paramImageView), paramString, null);
    AppMethodBeat.o(317331);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/utils/IconAttacherKt$attachIcon$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "kotlin.jvm.PlatformType", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.k
  {
    a(String paramString, ImageView paramImageView) {}
    
    public final void bFg()
    {
      AppMethodBeat.i(317458);
      Log.d("MicroMsg.AppBrand.IconAttacher", s.X("beforeLoadBitmap, iconUrl: ", this.ucr));
      AppMethodBeat.o(317458);
    }
    
    public final void bFh()
    {
      AppMethodBeat.i(317471);
      Log.d("MicroMsg.AppBrand.IconAttacher", s.X("onLoadFailed, iconUrl: ", this.ucr));
      AppMethodBeat.o(317471);
    }
    
    public final String key()
    {
      AppMethodBeat.i(317455);
      String str = com.tencent.mm.plugin.appbrand.af.p.el(this);
      AppMethodBeat.o(317455);
      return str;
    }
    
    public final void onBitmapLoaded(Bitmap paramBitmap)
    {
      AppMethodBeat.i(317463);
      Log.d("MicroMsg.AppBrand.IconAttacher", s.X("onBitmapLoaded, iconUrl: ", this.ucr));
      if (paramBitmap == null)
      {
        Log.w("MicroMsg.AppBrand.IconAttacher", "onBitmapLoaded, bitmap is null");
        AppMethodBeat.o(317463);
        return;
      }
      paramImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(317463);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    b(kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(317451);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = x.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(317451);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "tr", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    c(x.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/utils/IconAttacherKt$loadIcon$2$loadTarget$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "kotlin.jvm.PlatformType", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements b.k
  {
    d(String paramString, kotlinx.coroutines.p<? super Bitmap> paramp) {}
    
    public final void bFg()
    {
      AppMethodBeat.i(317454);
      Log.d("MicroMsg.AppBrand.IconAttacher", s.X("beforeLoadBitmap, iconUrl: ", this.ucr));
      AppMethodBeat.o(317454);
    }
    
    public final void bFh()
    {
      AppMethodBeat.i(317464);
      Log.d("MicroMsg.AppBrand.IconAttacher", s.X("onLoadFailed, iconUrl: ", this.ucr));
      kotlin.d.d locald = (kotlin.d.d)localp;
      Throwable localThrowable = (Throwable)new IOException("Load fail");
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(ResultKt.createFailure(localThrowable)));
      AppMethodBeat.o(317464);
    }
    
    public final String key()
    {
      AppMethodBeat.i(317449);
      String str = com.tencent.mm.plugin.appbrand.af.p.el(this);
      AppMethodBeat.o(317449);
      return str;
    }
    
    public final void onBitmapLoaded(Bitmap paramBitmap)
    {
      AppMethodBeat.i(317459);
      Log.d("MicroMsg.AppBrand.IconAttacher", s.X("onBitmapLoaded, iconUrl: ", this.ucr));
      if (paramBitmap == null)
      {
        Log.w("MicroMsg.AppBrand.IconAttacher", "onBitmapLoaded, bitmap is null");
        paramBitmap = (kotlin.d.d)localp;
        localObject = (Throwable)new IOException("Unexpected null bitmap");
        localCompanion = Result.Companion;
        paramBitmap.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject)));
        AppMethodBeat.o(317459);
        return;
      }
      Object localObject = (kotlin.d.d)localp;
      Result.Companion localCompanion = Result.Companion;
      ((kotlin.d.d)localObject).resumeWith(Result.constructor-impl(paramBitmap));
      AppMethodBeat.o(317459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.x
 * JD-Core Version:    0.7.0.1
 */