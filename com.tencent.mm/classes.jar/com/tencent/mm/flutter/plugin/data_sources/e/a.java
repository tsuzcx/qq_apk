package com.tencent.mm.flutter.plugin.data_sources.e;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.textstatus.h.f.g;
import com.tencent.mm.plugin.textstatus.util.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/text_status/TextStatusDataSource;", "", "()V", "getImageFile", "", "username", "url", "statusId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/tencent/mm/flutter/plugin/proto/GetTextStatusResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "TextStatusType", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a mrV;
  
  static
  {
    AppMethodBeat.i(233334);
    mrV = new a.a((byte)0);
    AppMethodBeat.o(233334);
  }
  
  public static Object a(String paramString1, final String paramString2, final String paramString3, d<? super String> paramd)
  {
    AppMethodBeat.i(233330);
    paramString1 = l.a((kotlin.d.f)bg.kCi(), (m)new c(paramString1, paramString2, paramString3, null), paramd);
    AppMethodBeat.o(233330);
    return paramString1;
  }
  
  public static Object a(String paramString, d<? super com.tencent.mm.flutter.plugin.a.f> paramd)
  {
    AppMethodBeat.i(233325);
    paramString = l.a((kotlin.d.f)bg.kCi(), (m)new a.d(paramString, null), paramd);
    AppMethodBeat.o(233325);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super String>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    c(String paramString1, String paramString2, String paramString3, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(233335);
      paramObject = (d)new c(this.mrr, paramString2, paramString3, paramd);
      AppMethodBeat.o(233335);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233329);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233329);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = e.TAU;
        paramObject = e.nl("image", this.mrr);
        if (y.ZC(paramObject))
        {
          Log.i("MicroMsg.TextStatusDataSource", kotlin.g.b.s.X("getImageFile: file is ready: ", paramObject));
          AppMethodBeat.o(233329);
          return paramObject;
        }
        Log.i("MicroMsg.TextStatusDataSource", "start downloading image: " + paramString2 + ", path=" + paramObject);
        localObject1 = paramString2;
        this.L$0 = paramObject;
        this.Uf = localObject1;
        this.label = 1;
        h localh = new h(kotlin.d.a.b.au((d)this));
        d locald = (d)localh;
        r.bKd().a((String)localObject1, (s.a)new a(locald));
        localObject1 = localh.kli();
        if (localObject1 == kotlin.d.a.a.aiwj) {
          kotlin.g.b.s.u((d)this, "frame");
        }
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(233329);
          return localObject2;
        }
        break;
      case 1: 
        localObject2 = (String)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject1 = (Bitmap)localObject1;
        if (localObject1 == null)
        {
          Log.w("MicroMsg.TextStatusDataSource", "failed to download bitmap, url=" + paramString2 + ", path=" + paramObject);
          AppMethodBeat.o(233329);
          return null;
        }
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.hGH().bdY(this.mrr);
        if (localObject2 == null)
        {
          Log.w("MicroMsg.TextStatusDataSource", kotlin.g.b.s.X("no text status found for ", this.mrr));
          AppMethodBeat.o(233329);
          return null;
        }
        if (!kotlin.g.b.s.p(paramString3, ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_StatusID))
        {
          Log.i("MicroMsg.TextStatusDataSource", "status changed, discard this request, expected status id is " + paramString3 + ", latest one is " + ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_StatusID);
          AppMethodBeat.o(233329);
          return paramObject;
        }
        try
        {
          if (y.ZC(paramObject))
          {
            Log.w("MicroMsg.TextStatusDataSource", "File has been created by another task, so we can reuse it");
            return paramObject;
          }
          com.tencent.mm.plugin.textstatus.g.b.m((Bitmap)localObject1, paramObject);
          localObject1 = ah.aiuX;
          Log.i("MicroMsg.TextStatusDataSource", kotlin.g.b.s.X("bitmap has been exported to ", paramObject));
          AppMethodBeat.o(233329);
          return paramObject;
        }
        finally
        {
          AppMethodBeat.o(233329);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      implements s.a
    {
      a(d<? super Bitmap> paramd) {}
      
      public final void onLoadImageEnd(String paramString1, Bitmap paramBitmap, String paramString2)
      {
        AppMethodBeat.i(233317);
        paramString1 = this.msc;
        paramString2 = Result.Companion;
        paramString1.resumeWith(Result.constructor-impl(paramBitmap));
        AppMethodBeat.o(233317);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.e.a
 * JD-Core Version:    0.7.0.1
 */