package com.tencent.mm.plugin.forcenotify.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class a$a
  implements Runnable
{
  a$a(a parama, cm paramcm) {}
  
  public final void run()
  {
    String str1 = null;
    AppMethodBeat.i(51025);
    if (a.a(this.mHj))
    {
      localObject = com.tencent.mm.plugin.forcenotify.d.a.mHw;
      com.tencent.mm.plugin.forcenotify.d.a.bzO();
    }
    Object localObject = this.mHk;
    if (localObject != null)
    {
      localObject = ((cm)localObject).woU;
      localObject = br.F((String)localObject, "ForcePushId");
      if (localObject == null) {
        break label212;
      }
    }
    label212:
    for (localObject = (String)((Map)localObject).get(".ForcePushId");; localObject = null)
    {
      if (localObject != null)
      {
        String str2 = this.mHj.TAG;
        cm localcm = this.mHk;
        if (localcm != null) {
          str1 = localcm.woU;
        }
        ab.i(str2, "received msg! MsgSource:%s FromUserName:%s source:%s", new Object[] { str1, this.mHk.woP, localObject });
        localObject = aa.a(this.mHk.woP);
        if (((j.e(r.Zn(), localObject) ^ true)) && (!a.b(this.mHj).contains(localObject)) && (this.mHj.On((String)localObject)))
        {
          a.b(this.mHj).add(localObject);
          a.c(this.mHj).post((Runnable)new a.a.1(this, (String)localObject));
        }
      }
      AppMethodBeat.o(51025);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a.a
 * JD-Core Version:    0.7.0.1
 */