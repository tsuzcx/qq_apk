package com.tencent.mm.mj_template.album_template;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$c
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  c$c(String paramString1, String paramString2, c paramc, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(240468);
    paramObject = (d)new c(this.nWk, this.nWl, this.nWj, paramd);
    AppMethodBeat.o(240468);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(240465);
    Object localObject2 = a.aiwj;
    Object localObject1;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(240465);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (com.tencent.mm.am.b)new ao(this.nWk, this.nWl);
      localObject1 = (d)this;
      this.label = 1;
      localObject1 = com.tencent.mm.af.b.a(paramObject, (d)localObject1);
      paramObject = localObject1;
      if (localObject1 == localObject2)
      {
        AppMethodBeat.o(240465);
        return localObject2;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    c localc = this.nWj;
    paramObject = ((buq)paramObject).aabt;
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = null)
    {
      if (paramObject == null) {
        Log.w("MaasBaseUILogicUIC", "activity closed or get error");
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(240465);
      return paramObject;
      localObject1 = (awt)p.oL((List)paramObject);
      if (localObject1 != null) {
        break;
      }
    }
    int i;
    if (((awt)localObject1).ZHK != 1)
    {
      i = 1;
      label184:
      if (i == 0) {
        break label202;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label207;
      }
      paramObject = null;
      break;
      i = 0;
      break label184;
      label202:
      localObject1 = null;
    }
    label207:
    FinderContact localFinderContact = ((awt)localObject1).contact;
    localc.getIntent().putExtra("key_topic_id", ((awt)localObject1).ocD);
    localc.getIntent().putExtra("key_activity_type", 102);
    Intent localIntent = localc.getIntent();
    if (localFinderContact == null)
    {
      paramObject = "";
      label256:
      localIntent.putExtra("key_user_name", paramObject);
      localIntent = localc.getIntent();
      if (localFinderContact != null) {
        break label554;
      }
      paramObject = "";
      label280:
      localIntent.putExtra("key_nick_name", paramObject);
      localIntent = localc.getIntent();
      if (localFinderContact != null) {
        break label575;
      }
      paramObject = "";
      label304:
      localIntent.putExtra("key_avatar_url", paramObject);
      localIntent = localc.getIntent();
      localObject2 = ((awt)localObject1).coverImgUrl;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
      localIntent.putExtra("key_cover_url", paramObject);
      localc.getIntent().putExtra("key_activity_display_mask", ((awt)localObject1).FOi);
      localIntent = localc.getIntent();
      localObject2 = ((awt)localObject1).eventName;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
      localIntent.putExtra("key_activity_name", paramObject);
      localIntent = localc.getIntent();
      localObject2 = ((awt)localObject1).description;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
      localIntent.putExtra("key_activity_desc", paramObject);
      localc.getIntent().putExtra("key_activity_end_time", ((awt)localObject1).endTime);
      localc.getIntent().putExtra("saveActivity", true);
      if (localFinderContact != null) {
        break label596;
      }
      paramObject = "";
    }
    for (;;)
    {
      Log.i("MaasBaseUILogicUIC", s.X("eventInfo nickname = ", paramObject));
      localObject2 = ((awt)localObject1).eventName;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
      Log.i("MaasBaseUILogicUIC", s.X("eventInfo eventname = ", paramObject));
      localObject1 = ((awt)localObject1).description;
      paramObject = localObject1;
      if (localObject1 == null) {
        paramObject = "";
      }
      Log.i("MaasBaseUILogicUIC", s.X("eventInfo description = ", paramObject));
      paramObject = ah.aiuX;
      break;
      localObject2 = localFinderContact.username;
      paramObject = localObject2;
      if (localObject2 != null) {
        break label256;
      }
      paramObject = "";
      break label256;
      label554:
      localObject2 = localFinderContact.nickname;
      paramObject = localObject2;
      if (localObject2 != null) {
        break label280;
      }
      paramObject = "";
      break label280;
      label575:
      localObject2 = localFinderContact.headUrl;
      paramObject = localObject2;
      if (localObject2 != null) {
        break label304;
      }
      paramObject = "";
      break label304;
      label596:
      localObject2 = localFinderContact.nickname;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.c.c
 * JD-Core Version:    0.7.0.1
 */