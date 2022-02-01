package com.tencent.mm.mj_template.maas.a;

import com.tencent.maas.camerafun.MJAuditCaptureSettings;
import com.tencent.maas.camerafun.MJCaptureOptions;
import com.tencent.maas.instamovie.MJRecordingSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.maas.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$s
  extends k
  implements m<aq, kotlin.d.d<? super Boolean>, Object>
{
  int label;
  
  c$s(c paramc, MJAuditCaptureSettings paramMJAuditCaptureSettings, kotlin.d.d<? super s> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(369581);
    paramObject = (kotlin.d.d)new s(this.obg, this.nZP, paramd);
    AppMethodBeat.o(369581);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    boolean bool3 = true;
    AppMethodBeat.i(369580);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    Object localObject1;
    Object localObject2;
    label133:
    boolean bool2;
    label140:
    int i;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(369580);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = com.tencent.mm.plugin.recordvideo.util.e.Obp;
      localObject1 = com.tencent.mm.plugin.recordvideo.util.e.gLf();
      localObject2 = new StringBuilder("startToRecord save path:").append((String)localObject1).append(", needAudio:");
      paramObject = c.g(this.obg);
      if (paramObject == null)
      {
        paramObject = null;
        Log.i("MicroMsg.FinderTemplateCorePlugin", paramObject);
        paramObject = c.c(this.obg);
        if (paramObject != null) {
          break label226;
        }
        bool1 = false;
        if (!bool1) {
          break label371;
        }
        bool2 = true;
        Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("startToRecord result:", Boolean.valueOf(bool2)));
        paramObject = c.g(this.obg);
        if ((paramObject == null) || (paramObject.isAudioEnabled() != true)) {
          break label377;
        }
        i = 1;
        label177:
        if (i != 0) {
          c.h(this.obg);
        }
        if ((c.g(this.obg) == null) || (!bool1)) {
          break label382;
        }
      }
      break;
    }
    label226:
    label371:
    label377:
    label382:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      AppMethodBeat.o(369580);
      return Boolean.valueOf(bool1);
      paramObject = Boolean.valueOf(paramObject.isAudioEnabled());
      break;
      localObject2 = new MJRecordingSettings(com.tencent.maas.instamovie.mediafoundation.d.eGm, com.tencent.maas.instamovie.mediafoundation.a.eFy, com.tencent.maas.instamovie.mediafoundation.c.eGg, this.obg.oaZ.obm, this.obg.oaZ.videoBitsPerFrame, this.obg.oaZ.averageAudioBitRate, this.obg.oaZ.maxKeyframeInterval);
      MJAuditCaptureSettings localMJAuditCaptureSettings = this.nZP;
      kotlin.d.d locald = (kotlin.d.d)this;
      this.label = 1;
      localObject1 = com.tencent.mm.mj_template.maas.c.a("1006", (b)new d.e(paramObject, (String)localObject1, (MJRecordingSettings)localObject2, localMJAuditCaptureSettings), locald);
      paramObject = localObject1;
      if (localObject1 == locala)
      {
        AppMethodBeat.o(369580);
        return locala;
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (Boolean)paramObject;
      if (paramObject == null)
      {
        bool1 = false;
        break label133;
      }
      bool1 = paramObject.booleanValue();
      break label133;
      bool2 = false;
      break label140;
      i = 0;
      break label177;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.a.c.s
 * JD-Core Version:    0.7.0.1
 */