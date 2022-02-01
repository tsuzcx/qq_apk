package com.tencent.mm.plugin.flutter.voip.flutterplugin;

import com.tencent.c.j.c;
import com.tencent.c.j.g;
import com.tencent.c.j.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$e
  extends k
  implements m<aq, d<? super ah>, Object>
{
  Object Uf;
  Object VC;
  Object VD;
  int label;
  
  c$e(j.g paramg, j.m<j.c> paramm, c paramc, d<? super e> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(263432);
    paramd = new e(this.Hnk, this.Hnj, this.Hni, paramd);
    paramd.L$0 = paramObject;
    paramObject = (d)paramd;
    AppMethodBeat.o(263432);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(263425);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(263425);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (aq)this.L$0;
    }
    try
    {
      localObject = this.Hnk;
      if (localObject != null) {
        break label121;
      }
      paramObject = null;
      if (paramObject == null)
      {
        paramObject = this.Hnj;
        Log.i("MicroMsg.FlutterVoipPlugin", "setRingtoneSelf arg null");
        if (paramObject != null) {
          paramObject.success(c.z(Boolean.FALSE));
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label121:
        j.m localm;
        c localc;
        PluginRingtone.a locala1;
        boolean bool;
        Object localObject = new StringBuilder("setRingtoneSelf error: ");
        paramObject = this.Hnk;
        if (paramObject == null) {}
        for (paramObject = null;; paramObject = paramObject.value)
        {
          Log.i("MicroMsg.FlutterVoipPlugin", paramObject + ' ' + localException.getMessage());
          paramObject = this.Hnj;
          if (paramObject == null) {
            break;
          }
          paramObject.success(c.z(Boolean.FALSE));
          break;
        }
      }
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(263425);
    return paramObject;
    localm = this.Hnj;
    localc = this.Hni;
    locala1 = PluginRingtone.OBl;
    this.L$0 = paramObject;
    this.Uf = localm;
    this.VC = localc;
    this.VD = localObject;
    this.label = 1;
    paramObject = PluginRingtone.a.setRingtoneSelf(paramObject, 1, this);
    if (paramObject == locala)
    {
      AppMethodBeat.o(263425);
      return locala;
      localObject = (j.g)this.VD;
      localm = (j.m)this.Uf;
      ResultKt.throwOnFailure(paramObject);
      bool = ((Boolean)paramObject).booleanValue();
      if (localm != null) {
        if (!bool) {
          break label259;
        }
      }
      label259:
      for (bool = true;; bool = false)
      {
        localm.success(c.z(Boolean.valueOf(bool)));
        Log.i("MicroMsg.FlutterVoipPlugin", s.X("setRingtoneSelf rsp: ", ((j.g)localObject).value));
        paramObject = ah.aiuX;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.flutterplugin.c.e
 * JD-Core Version:    0.7.0.1
 */