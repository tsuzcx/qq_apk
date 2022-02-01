package com.tencent.mm.flutter.plugin.data_sources.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.fvk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.flutter.plugin.a.d;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/finder/FinderDataSource;", "", "()V", "fetchLatestFinders", "Lcom/tencent/mm/protocal/protobuf/UserPreviewInfo;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageFile", "url", "urlToken", "decodeKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestFinders", "Lcom/tencent/mm/flutter/plugin/proto/GetFindersResponse;", "timeLimit", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "FinderItemType", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a mrl;
  
  static
  {
    AppMethodBeat.i(233336);
    mrl = new a.a((byte)0);
    AppMethodBeat.o(233336);
  }
  
  public static Object a(String paramString1, final String paramString2, final String paramString3, final String paramString4, kotlin.d.d<? super String> paramd)
  {
    AppMethodBeat.i(233327);
    paramString1 = l.a((f)bg.kCi(), (m)new f(paramString1, paramString2, paramString3, paramString4, null), paramd);
    AppMethodBeat.o(233327);
    return paramString1;
  }
  
  public final Object a(String paramString, long paramLong, kotlin.d.d<? super com.tencent.mm.flutter.plugin.a.d> paramd)
  {
    AppMethodBeat.i(233368);
    if ((paramd instanceof g))
    {
      localObject1 = (g)paramd;
      if ((((g)localObject1).label & 0x80000000) != 0) {
        ((g)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super com.tencent.mm.flutter.plugin.a.d>)localObject1;; paramd = new g(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233368);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = new com.tencent.mm.flutter.plugin.a.d();
    if (com.tencent.mm.flutter.plugin.data_sources.a.a.ED(paramString))
    {
      Log.i("MicroMsg.FinderDataSource", "do not show finder cause in black list!");
      AppMethodBeat.o(233368);
      return localObject1;
    }
    paramd.L$0 = localObject1;
    paramd.Yx = paramLong;
    paramd.label = 1;
    Object localObject2 = new q(kotlin.d.a.b.au(paramd), 1);
    ((q)localObject2).kBA();
    kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localObject2;
    com.tencent.mm.vending.e.c localc = new com.tencent.mm.vending.e.c();
    localp.bg((kotlin.g.a.b)new a.c(localc));
    com.tencent.mm.kernel.c.a locala1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    s.s(locala1, "service(IFinderCommonService::class.java)");
    ((com.tencent.mm.plugin.h)locala1).a(paramString, (com.tencent.mm.vending.e.b)localc, (kotlin.g.a.b)new a.d(localp), (kotlin.g.a.b)new a.e(localp));
    localObject2 = ((q)localObject2).getResult();
    if (localObject2 == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    if (localObject2 == locala)
    {
      AppMethodBeat.o(233368);
      return locala;
      paramLong = paramd.Yx;
      paramString = (com.tencent.mm.flutter.plugin.a.d)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    for (paramd = (kotlin.d.d<? super com.tencent.mm.flutter.plugin.a.d>)localObject1;; paramd = (kotlin.d.d<? super com.tencent.mm.flutter.plugin.a.d>)localObject2)
    {
      paramd = (fvk)paramd;
      paramString.aqS = false;
      localObject2 = paramd.contact;
      if (localObject2 != null)
      {
        localObject1 = new com.tencent.mm.flutter.plugin.a.a();
        ((com.tencent.mm.flutter.plugin.a.a)localObject1).nickname = ((FinderContact)localObject2).nickname;
        ((com.tencent.mm.flutter.plugin.a.a)localObject1).username = ((FinderContact)localObject2).username;
        ((com.tencent.mm.flutter.plugin.a.a)localObject1).headUrl = ((FinderContact)localObject2).headUrl;
        ((com.tencent.mm.flutter.plugin.a.a)localObject1).signature = ((FinderContact)localObject2).signature;
        localObject2 = ah.aiuX;
        paramString.msi = ((com.tencent.mm.flutter.plugin.a.a)localObject1);
      }
      paramLong = (System.currentTimeMillis() - paramLong) / 1000L;
      paramd = paramd.ZIQ;
      s.s(paramd, "profile.objects");
      localObject1 = (Iterable)paramd;
      paramd = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label540:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((FinderObject)localObject2).createtime > paramLong) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label540;
          }
          paramd.add(localObject2);
          break;
        }
      }
      paramd = ((Iterable)paramd).iterator();
      while (paramd.hasNext())
      {
        localObject1 = (FinderObject)paramd.next();
        s.s(localObject1, "finderObject");
        localObject1 = b.a((FinderObject)localObject1);
        paramString.msj.add(localObject1);
      }
      AppMethodBeat.o(233368);
      return paramString;
      paramString = (String)localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super String>, Object>
  {
    Object L$0;
    int label;
    
    f(String paramString1, String paramString2, String paramString3, String paramString4, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(233337);
      paramObject = (kotlin.d.d)new f(this.mrr, paramString2, paramString3, paramString4, paramd);
      AppMethodBeat.o(233337);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233326);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233326);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.FinderDataSource", "getImageFile(" + this.mrr + ", " + paramString2 + ", " + paramString3 + ", " + paramString4);
        paramObject = new dji();
        paramObject.mediaId = MD5Util.getMD5String(paramString2);
        paramObject.url = paramString2;
        paramObject.url_token = paramString3;
        paramObject.decodeKey = paramString4;
        paramObject.thumbUrl = paramString2;
        paramObject.thumb_url_token = paramString3;
        Object localObject2 = new com.tencent.mm.plugin.finder.loader.k(paramObject, v.FKY, this.mrr);
        this.L$0 = localObject2;
        this.label = 1;
        paramObject = new q(kotlin.d.a.b.au((kotlin.d.d)this), 1);
        paramObject.kBA();
        Object localObject1 = (kotlinx.coroutines.p)paramObject;
        Object localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl().dk(localObject2);
        localObject3 = (com.tencent.mm.loader.e.c)new a((kotlinx.coroutines.p)localObject1);
        s.u(localObject3, "imageLoadListener");
        ((com.tencent.mm.loader.a.b)localObject2).noy = ((com.tencent.mm.loader.e.c)localObject3);
        ((com.tencent.mm.loader.b)localObject2).a((com.tencent.mm.loader.e.a)new a.f.b((kotlinx.coroutines.p)localObject1)).blf();
        localObject1 = paramObject.getResult();
        if (localObject1 == kotlin.d.a.a.aiwj) {
          s.u((kotlin.d.d)this, "frame");
        }
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(233326);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      AppMethodBeat.o(233326);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/flutter/plugin/data_sources/finder/FinderDataSource$getImageFile$2$1$1", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "onImageLoadFinish", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "imageData", "Lcom/tencent/mm/loader/model/LoadResult;", "onImageLoadStart", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.loader.e.c<r>
    {
      a(kotlinx.coroutines.p<? super String> paramp) {}
      
      public final void a(com.tencent.mm.loader.g.a.a<r> parama)
      {
        AppMethodBeat.i(233304);
        Log.w("MicroMsg.FinderDataSource", s.X("onImageLoadStart: ", parama));
        AppMethodBeat.o(233304);
      }
      
      public final void b(com.tencent.mm.loader.g.a.a<r> parama)
      {
        AppMethodBeat.i(233309);
        s.u(parama, "url");
        String str = y.n(((r)parama.bmg()).getPath(), false);
        Log.i("MicroMsg.FinderDataSource", "onImageLoadFinish: url=" + parama + ", path=" + str);
        parama = (kotlin.d.d)this.bPy;
        Result.Companion localCompanion = Result.Companion;
        parama.resumeWith(Result.constructor-impl(str));
        AppMethodBeat.o(233309);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.d
  {
    Object L$0;
    long Yx;
    int label;
    
    g(a parama, kotlin.d.d<? super g> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233312);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.mrv.a(null, 0L, (kotlin.d.d)this);
      AppMethodBeat.o(233312);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.b.a
 * JD-Core Version:    0.7.0.1
 */