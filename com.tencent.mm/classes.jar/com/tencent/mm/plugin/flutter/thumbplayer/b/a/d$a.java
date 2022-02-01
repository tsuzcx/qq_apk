package com.tencent.mm.plugin.flutter.thumbplayer.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.plugin.a.g;
import com.tencent.mm.g.h;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class d$a
  extends k
  implements m<aq, kotlin.d.d<? super h>, Object>
{
  int label;
  
  d$a(d paramd, byte[] paramArrayOfByte, kotlin.d.d<? super a> paramd1)
  {
    super(2, paramd1);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(263264);
    paramObject = (kotlin.d.d)new a(this.Hle, this.Hlc, paramd);
    AppMethodBeat.o(263264);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(263257);
    Object localObject1 = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(263257);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    for (;;)
    {
      try
      {
        paramObject = new g();
        paramObject.parseFrom(this.Hlc);
        paramObject = paramObject.hHB;
        localObject1 = al.hgB().aZL(paramObject);
        localdmz = (dmz)((SnsInfo)localObject1).getTimeLine().ContentObj.Zpr.getFirst();
        bool = y.bDX(az.aYG(localdmz.Id));
        str = az.E(localdmz);
        localObject2 = az.aYH(paramObject);
        if (localObject2 != null) {
          continue;
        }
        az.ha(paramObject, 30);
        localObject2 = this.Hle.TAG;
        if (!bool) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramObject)
      {
        dmz localdmz;
        String str;
        Object localObject2;
        paramObject = null;
        continue;
        boolean bool = false;
        continue;
      }
      Log.i((String)localObject2, "prepare stream download sns video %s mkDir %b", new Object[] { str, Boolean.valueOf(bool) });
      localObject2 = br.jbm();
      ((br)localObject2).time = ((SnsInfo)localObject1).getCreateTime();
      v.bOi();
      paramObject = j.a((br)localObject2, localdmz.Url, str, az.PW(paramObject), 1, false);
      AppMethodBeat.o(263257);
      return paramObject;
      az.c((z)localObject2, 30);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */