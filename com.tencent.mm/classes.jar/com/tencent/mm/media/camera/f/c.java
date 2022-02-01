package com.tencent.mm.media.camera.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/render/GLEnvPreloadBuilder;", "Lcom/tencent/mm/media/camera/GLEnvBuilder;", "()V", "preloadLocker", "Ljava/lang/Object;", "preloadRenderList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Lkotlin/collections/HashMap;", "destroyGLEnv", "", "getPreloadRender", "key", "setPreloadRender", "render", "createSurfaceTexture", "", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
{
  public static final c.a nwu;
  private final Object nwv;
  private final HashMap<String, com.tencent.mm.media.j.a> nww;
  
  static
  {
    AppMethodBeat.i(237171);
    nwu = new c.a((byte)0);
    AppMethodBeat.o(237171);
  }
  
  public c()
  {
    super(nwu.hashCode());
    AppMethodBeat.i(237148);
    this.nwv = new Object();
    this.nww = new HashMap();
    AppMethodBeat.o(237148);
  }
  
  public final void bnO()
  {
    AppMethodBeat.i(237177);
    h((m)new b(this, null));
    super.bnO();
    AppMethodBeat.o(237177);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(c paramc, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(237156);
      paramObject = (d)new b(this.nwx, paramd);
      AppMethodBeat.o(237156);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237151);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237151);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = ((Map)c.c(this.nwx)).entrySet().iterator();
      while (paramObject.hasNext()) {
        ((com.tencent.mm.media.j.a)((Map.Entry)paramObject.next()).getValue()).release(true);
      }
      c.c(this.nwx).clear();
      paramObject = ah.aiuX;
      AppMethodBeat.o(237151);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    c(c paramc, com.tencent.mm.media.j.a parama, boolean paramBoolean, String paramString, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(237175);
      paramObject = (d)new c(this.nwx, this.nwy, this.nwz, this.$key, paramd);
      AppMethodBeat.o(237175);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237168);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237168);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = c.b(this.nwx);
      localObject1 = this.nwy;
      boolean bool = this.nwz;
      c localc = this.nwx;
      String str = this.$key;
      if (bool) {}
      for (bool = true;; bool = false) {
        try
        {
          ((com.tencent.mm.media.j.a)localObject1).gp(bool);
          ((Map)c.c(localc)).put(str, localObject1);
          Log.i("MicroMsg.Camera.GLEnvBuilder", "initRenderProcInGlesThread finish");
          localObject1 = ah.aiuX;
          return paramObject;
        }
        finally
        {
          AppMethodBeat.o(237168);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.f.c
 * JD-Core Version:    0.7.0.1
 */