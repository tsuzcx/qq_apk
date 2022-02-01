package com.tencent.mm.plugin.flutter.thumbplayer.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.plugin.a.i;
import com.tencent.mm.g.h;
import com.tencent.mm.plugin.thumbplayer.b;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/TextStatusCdnTaskFactory;", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/ICdnTaskFactory;", "()V", "TAG", "", "getSupportCdnMediaType", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/CdnMediaType;", "parse", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "proto", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements c
{
  final String TAG = "MicroMsg.TextStatusCdnTaskFactory";
  
  public final Object a(final byte[] paramArrayOfByte, d<? super h> paramd)
  {
    AppMethodBeat.i(263229);
    paramArrayOfByte = l.a((f)bg.kCi(), (m)new a(this, paramArrayOfByte, null), paramd);
    AppMethodBeat.o(263229);
    return paramArrayOfByte;
  }
  
  public final a fve()
  {
    return a.Hla;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super h>, Object>
  {
    int label;
    
    a(e parame, byte[] paramArrayOfByte, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(263252);
      paramObject = (d)new a(this.Hlf, paramArrayOfByte, paramd);
      AppMethodBeat.o(263252);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263246);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263246);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      try
      {
        localObject1 = new i();
        ((i)localObject1).parseFrom(paramArrayOfByte);
        paramObject = MD5Util.getMD5String(((i)localObject1).mediaUrl);
        Object localObject2 = com.tencent.mm.plugin.textstatus.util.e.TAU;
        s.s(paramObject, "mediaId");
        localObject2 = com.tencent.mm.plugin.textstatus.util.e.bek(paramObject);
        b localb = b.TBI;
        localObject1 = ((i)localObject1).mediaUrl;
        s.s(localObject1, "textStatus.mediaUrl");
        paramObject = b.a(paramObject, (String)localObject1, (String)localObject2, 0, "xV2", "", "", "", null, this.Hlf.TAG);
        AppMethodBeat.o(263246);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.b.a.e
 * JD-Core Version:    0.7.0.1
 */