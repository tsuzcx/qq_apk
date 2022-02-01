package com.tencent.mm.plugin.flutter.thumbplayer.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/FinderCdnTaskFactory;", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/ICdnTaskFactory;", "()V", "TAG", "", "getSupportCdnMediaType", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/CdnMediaType;", "parse", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "proto", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  final String TAG = "MicroMsg.FinderCdnTaskFactory";
  
  public final Object a(byte[] paramArrayOfByte, d<? super com.tencent.mm.g.h> paramd)
  {
    AppMethodBeat.i(263223);
    paramArrayOfByte = l.a((f)bg.kCi(), (m)new a(paramArrayOfByte, this, null), paramd);
    AppMethodBeat.o(263223);
    return paramArrayOfByte;
  }
  
  public final a fve()
  {
    return a.HkY;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super com.tencent.mm.g.h>, Object>
  {
    int label;
    
    a(byte[] paramArrayOfByte, b paramb, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(263244);
      paramObject = (d)new a(this.Hlc, jdField_this, paramd);
      AppMethodBeat.o(263244);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263239);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263239);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      try
      {
        paramObject = new com.tencent.mm.flutter.plugin.a.b();
        paramObject.parseFrom(this.Hlc);
        paramObject = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().J(paramObject.feedId, paramObject.nonceId).bsD;
        if ((paramObject instanceof FinderObject)) {}
        for (paramObject = (FinderObject)paramObject; paramObject != null; paramObject = null)
        {
          b localb = jdField_this;
          localObject1 = paramObject.objectDesc;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((FinderObjectDesc)localObject1).media;
          if (localObject1 == null) {
            break;
          }
          localObject1 = (FinderMedia)p.oL((List)localObject1);
          if (localObject1 == null) {
            break;
          }
          Object localObject7 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).createMediaInfo((FinderMedia)localObject1, kotlin.d.b.a.b.BF(paramObject.id), true);
          if (localObject7 == null) {
            break;
          }
          paramObject = com.tencent.mm.plugin.thumbplayer.b.TBI;
          localObject1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).mediaId;
          paramObject = localObject1;
          if (localObject1 == null) {
            paramObject = "";
          }
          Object localObject2 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).url;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          Object localObject3 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).path;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          int i = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).TBJ;
          Object localObject4 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).hVy;
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "xV2";
          }
          Object localObject5 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).msf;
          localObject4 = localObject5;
          if (localObject5 == null) {
            localObject4 = "";
          }
          Object localObject6 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).decodeKey;
          localObject5 = localObject6;
          if (localObject6 == null) {
            localObject5 = "";
          }
          localObject7 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject7).videoFlag;
          localObject6 = localObject7;
          if (localObject7 == null) {
            localObject6 = "";
          }
          paramObject = com.tencent.mm.plugin.thumbplayer.b.a(paramObject, (String)localObject1, (String)localObject2, i, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, null, localb.TAG);
          AppMethodBeat.o(263239);
          return paramObject;
        }
        return null;
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(263239);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.b.a.b
 * JD-Core Version:    0.7.0.1
 */