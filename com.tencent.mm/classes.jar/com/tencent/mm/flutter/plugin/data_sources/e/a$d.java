package com.tencent.mm.flutter.plugin.data_sources.e;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.plugin.a.i;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.third.j;
import com.tencent.mm.plugin.textstatus.util.g;
import com.tencent.mm.plugin.textstatus.util.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/flutter/plugin/proto/GetTextStatusResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$d
  extends k
  implements m<kotlinx.coroutines.aq, d<? super com.tencent.mm.flutter.plugin.a.f>, Object>
{
  int label;
  
  a$d(String paramString, d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(233340);
    paramObject = (d)new d(this.mrr, paramd);
    AppMethodBeat.o(233340);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(233333);
    Object localObject2 = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(233333);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    localObject2 = new com.tencent.mm.flutter.plugin.a.f();
    if (com.tencent.mm.flutter.plugin.data_sources.a.a.ED(this.mrr))
    {
      Log.i("MicroMsg.TextStatusDataSource", "do not show text status cause in black list!");
      AppMethodBeat.o(233333);
      return localObject2;
    }
    paramObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.h.f.b localb = com.tencent.mm.plugin.textstatus.b.f.bdN(this.mrr);
    if (localb == null)
    {
      AppMethodBeat.o(233333);
      return localObject2;
    }
    i locali = new i();
    locali.id = localb.field_StatusID;
    locali.mse = localb.field_PoiName;
    paramObject = a.b.mrW;
    Object localObject3;
    label259:
    label278:
    int i;
    switch (localb.field_MediaType)
    {
    default: 
      paramObject = a.b.mrX;
      locali.mediaType = paramObject.ordinal();
      locali.mediaUrl = localb.field_MediaUrl;
      locali.mediaThumbUrl = localb.field_MediaThumbUrl;
      locali.msd = (localb.field_CreateTime * 1000L);
      locali.text = localb.field_Description;
      paramObject = localb.field_IconID;
      localObject3 = g.TBm;
      paramObject = h.a(g.hKu(), paramObject);
      if (paramObject == null)
      {
        paramObject = null;
        if (paramObject != null) {
          break label597;
        }
        paramObject = com.tencent.mm.plugin.textstatus.h.f.b.b(localb).iconActions;
        if (paramObject != null) {
          break label586;
        }
        paramObject = null;
        localObject3 = com.tencent.mm.plugin.textstatus.h.f.b.b(localb);
        locali.jumpType = "0";
        Object localObject4 = (CharSequence)((TextStatusTopicInfo)localObject3).sourceId;
        if ((localObject4 != null) && (!n.bp((CharSequence)localObject4))) {
          break label600;
        }
        i = 1;
        label317:
        if (i == 0)
        {
          localObject4 = ((TextStatusTopicInfo)localObject3).jumpInfos;
          if (localObject4 != null)
          {
            localObject4 = j.lu((List)localObject4);
            if ((localObject4 != null) && (s.p(((TextStatusJumpInfo)localObject4).jumpType, "5")))
            {
              localObject4 = Base64.decode(((TextStatusJumpInfo)localObject4).busiBuf, 0);
              FinderObject localFinderObject = new FinderObject();
              localFinderObject.parseFrom((byte[])localObject4);
              locali.msq = com.tencent.mm.flutter.plugin.data_sources.b.b.a(localFinderObject);
            }
          }
          localObject4 = ((TextStatusTopicInfo)localObject3).jumpInfos;
          s.s(localObject4, "topicInfo.jumpInfos");
          localObject4 = (TextStatusJumpInfo)p.oL((List)localObject4);
          if (localObject4 != null) {
            locali.jumpType = ((TextStatusJumpInfo)localObject4).jumpType;
          }
        }
        locali.mss = ((TextStatusTopicInfo)localObject3).sourceIcon;
        locali.sourceName = ((TextStatusTopicInfo)localObject3).sourceName;
        locali.msp = g.TBm.f((TextStatusTopicInfo)localObject3);
        if (paramObject != null) {
          break label605;
        }
      }
      break;
    }
    label586:
    label597:
    label600:
    label605:
    for (paramObject = localObject1;; paramObject = paramObject.url)
    {
      locali.iconUrl = paramObject;
      locali.iconId = ((TextStatusTopicInfo)localObject3).iconId;
      locali.msr = localb.hHI();
      locali.backgroundId = localb.field_backgroundId;
      if (!s.p(locali.jumpType, "0"))
      {
        locali.mediaType = a.b.mrX.ordinal();
        locali.backgroundId = "text_state_default_image_2";
      }
      ((com.tencent.mm.flutter.plugin.a.f)localObject2).msm = locali;
      AppMethodBeat.o(233333);
      return localObject2;
      paramObject = a.b.mrY;
      break;
      paramObject = a.b.mrZ;
      break;
      paramObject = h.a(paramObject);
      break label259;
      paramObject = h.ly((List)paramObject);
      break label278;
      break label278;
      i = 0;
      break label317;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.e.a.d
 * JD-Core Version:    0.7.0.1
 */