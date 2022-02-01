package com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datapreloader.a.a.a;
import com.tencent.mm.plugin.datapreloader.a.c;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.am.b.a<Lcom.tencent.mm.protocal.protobuf.bqr;>;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cg;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/NearLiveStreamCache;", "Lcom/tencent/mm/plugin/datapreloader/cache/SimpleDataCache;", "", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;", "key", "(Ljava/lang/String;)V", "doNotCheckTime", "", "checkCacheAvailable", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResp", "hasCacheOrLoading", "requestCache", "saveCache", "result", "timestamp", "", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c<String, com.tencent.mm.am.b.a<bqr>>
{
  public static final a EOI;
  private boolean EOJ;
  
  static
  {
    AppMethodBeat.i(340273);
    EOI = new a((byte)0);
    AppMethodBeat.o(340273);
  }
  
  public b(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(340267);
    AppMethodBeat.o(340267);
  }
  
  public final Object aa(kotlin.d.d<? super com.tencent.mm.am.b.a<bqr>> paramd)
  {
    Object localObject2 = null;
    AppMethodBeat.i(340291);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super com.tencent.mm.am.b.a<bqr>>)localObject1;; paramd = new c(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(340291);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = dtl();
    if ((localObject1 != null) && (((ay)localObject1).isActive() == true)) {}
    for (boolean bool = true;; bool = false)
    {
      this.EOJ = bool;
      paramd.L$0 = this;
      paramd.label = 1;
      localObject3 = super.aa(paramd);
      localObject1 = localObject3;
      paramd = this;
      if (localObject3 != locala) {
        break;
      }
      AppMethodBeat.o(340291);
      return locala;
    }
    paramd = (b)paramd.L$0;
    ResultKt.throwOnFailure(localObject1);
    localObject1 = (com.tencent.mm.am.b.a)localObject1;
    paramd.EOJ = false;
    Object localObject3 = new StringBuilder("requestCache: errType = ");
    if (localObject1 == null)
    {
      paramd = null;
      localObject3 = ((StringBuilder)localObject3).append(paramd).append(", errCode=");
      if (localObject1 != null) {
        break label282;
      }
    }
    label282:
    for (paramd = localObject2;; paramd = Integer.valueOf(((com.tencent.mm.am.b.a)localObject1).errCode))
    {
      Log.i("NearLiveStreamCache", paramd + ", cache=" + localObject1);
      AppMethodBeat.o(340291);
      return localObject1;
      paramd = Integer.valueOf(((com.tencent.mm.am.b.a)localObject1).errType);
      break;
    }
  }
  
  public final Object af(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(340301);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new b(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(340301);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject2 = new StringBuilder("clearCache: preloadJob=").append(dtl()).append(", isActive=");
    Object localObject1 = dtl();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Boolean.valueOf(((ay)localObject1).isActive()))
    {
      Log.i("NearLiveStreamCache", localObject1);
      localObject2 = dtl();
      localObject1 = this;
      if (localObject2 == null) {
        break;
      }
      localObject2 = (cb)localObject2;
      paramd.L$0 = this;
      paramd.label = 1;
      localObject1 = this;
      if (cg.b((cb)localObject2, paramd) != locala) {
        break;
      }
      AppMethodBeat.o(340301);
      return locala;
    }
    localObject1 = (b)paramd.L$0;
    ResultKt.throwOnFailure(localObject2);
    ((b)localObject1).clearCache();
    paramd = ah.aiuX;
    AppMethodBeat.o(340301);
    return paramd;
  }
  
  public final boolean dtm()
  {
    boolean bool = false;
    AppMethodBeat.i(340311);
    if (getData() == null)
    {
      AppMethodBeat.o(340311);
      return false;
    }
    int i;
    if (!this.EOJ)
    {
      localObject1 = (com.tencent.mm.am.b.a)getData();
      if (localObject1 != null) {
        break label164;
      }
      i = 0;
      long l = i * 60 * 1000;
      localObject1 = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.EMv;
      if (l + com.tencent.mm.plugin.finder.nearby.newlivesquare.a.eFG() <= System.currentTimeMillis()) {}
    }
    else
    {
      bool = true;
    }
    Object localObject2 = new StringBuilder("checkCacheAvailable: result=").append(bool).append(", doNotCheckTime=").append(this.EOJ).append("prefech_min_interval=");
    Object localObject1 = (com.tencent.mm.am.b.a)getData();
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", lastRespSetTime=");
      localObject2 = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.EMv;
      Log.i("NearLiveStreamCache", com.tencent.mm.plugin.finder.nearby.newlivesquare.a.eFG());
      AppMethodBeat.o(340311);
      return bool;
      label164:
      localObject1 = (bqr)((com.tencent.mm.am.b.a)localObject1).ott;
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      i = ((bqr)localObject1).ZKX;
      break;
      localObject1 = (bqr)((com.tencent.mm.am.b.a)localObject1).ott;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = Integer.valueOf(((bqr)localObject1).ZKX);
      }
    }
  }
  
  public final bqr eFW()
  {
    AppMethodBeat.i(340279);
    Object localObject = (com.tencent.mm.am.b.a)getData();
    if (localObject == null)
    {
      AppMethodBeat.o(340279);
      return null;
    }
    localObject = (bqr)((com.tencent.mm.am.b.a)localObject).ott;
    AppMethodBeat.o(340279);
    return localObject;
  }
  
  public final boolean eFX()
  {
    AppMethodBeat.i(340294);
    if ((getData() == null) || (!dtm()))
    {
      ay localay = dtl();
      if ((localay == null) || (localay.isActive() != true)) {
        break label51;
      }
    }
    label51:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(340294);
      return true;
    }
    AppMethodBeat.o(340294);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/NearLiveStreamCache$Companion;", "", "()V", "TAG", "", "getCache", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/NearLiveStreamCache;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b eFY()
    {
      AppMethodBeat.i(340287);
      Object localObject = com.tencent.mm.plugin.datapreloader.a.a.xfR;
      localObject = a.a.dti().eA("7312+1");
      if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        AppMethodBeat.o(340287);
        return localObject;
      }
      AppMethodBeat.o(340287);
      return null;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(b paramb, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(340282);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.EOK.af((kotlin.d.d)this);
      AppMethodBeat.o(340282);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    c(b paramb, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(340286);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.EOK.aa((kotlin.d.d)this);
      AppMethodBeat.o(340286);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b
 * JD-Core Version:    0.7.0.1
 */