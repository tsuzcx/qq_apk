package com.tencent.mm.plugin.finder.conv;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.b;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class i$j
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  i$j(kotlinx.coroutines.a.h<Bitmap> paramh, i parami, String paramString1, String paramString2, long paramLong1, ah.d paramd, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4, String paramString8, int paramInt5, int paramInt6, boolean paramBoolean3, String paramString9, String paramString10, FinderJumpInfo paramFinderJumpInfo, int paramInt7, d<? super j> paramd1)
  {
    super(2, paramd1);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(335974);
    paramObject = (d)new j(this.aaM, this.AGi, this.AsO, this.AGw, this.AsN, this.AGx, this.AGy, this.AGz, this.AGA, this.pXx, this.$title, this.AGB, this.AGC, this.AGD, this.AGE, this.AGF, this.AGG, this.AGH, this.AGI, this.AGJ, this.AGK, this.AGL, this.AGM, this.AGN, this.AGO, this.AGP, this.AGQ, paramd);
    AppMethodBeat.o(335974);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(335969);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(335969);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.aaM;
      Object localObject = (d)this;
      this.label = 1;
      localObject = paramObject.aA((d)localObject);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(335969);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = (Bitmap)paramObject;
    if (paramObject != null) {
      i.a(this.AGi, this.AsO, this.AGw, this.AsN, this.AGx.aixb, this.AGy, this.AGz, this.AGA, this.pXx, this.$title, this.AGB, paramObject, this.AGC, this.AGD, this.AGE, this.AGF, this.AGG, this.AGH, this.AGI, this.AGJ, this.AGK, this.AGL, this.AGM, this.AGN, this.AGO, this.AGP);
    }
    for (;;)
    {
      Log.i("Finder.GlobalPushNewXmlConsumer", s.X("loadLinkIcon resource :", paramObject));
      paramObject = ah.aiuX;
      AppMethodBeat.o(335969);
      return paramObject;
      com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { this.AGA, "return", b.BF(System.currentTimeMillis()), "13", Integer.valueOf(this.AGQ), Integer.valueOf(this.AGx.aixb) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i.j
 * JD-Core Version:    0.7.0.1
 */