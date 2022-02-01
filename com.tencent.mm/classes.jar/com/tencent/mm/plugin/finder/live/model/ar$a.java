package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class ar$a
  extends u
  implements a<String>
{
  ar$a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, int paramInt3, Integer paramInteger, String paramString, boolean paramBoolean4, boolean paramBoolean5)
  {
    super(0);
  }
  
  private String emu()
  {
    AppMethodBeat.i(359737);
    try
    {
      Object localObject1 = new i();
      long l = this.CIi;
      boolean bool1 = this.CIj;
      boolean bool2 = this.CIk;
      int i = this.CIl;
      int j = this.CIm;
      boolean bool3 = this.CIn;
      int k = this.CIo;
      localObject3 = this.CIp;
      String str = this.CIq;
      boolean bool4 = this.CIr;
      boolean bool5 = this.CIs;
      ((i)localObject1).n("liveId", Long.valueOf(l));
      ((i)localObject1).n("isFloat", Boolean.valueOf(bool1));
      ((i)localObject1).n("isForeground", Boolean.valueOf(bool2));
      ((i)localObject1).n("threadCntInProcess", Integer.valueOf(i));
      ((i)localObject1).n("threadCntInJava", Integer.valueOf(j));
      ((i)localObject1).n("screenOff", Boolean.valueOf(bool3));
      ((i)localObject1).n("battery", Integer.valueOf(k));
      ((i)localObject1).n("curBattery", localObject3);
      ((i)localObject1).n("memInfo", str);
      ((i)localObject1).n("hasStack", Boolean.valueOf(bool4));
      ((i)localObject1).n("deleteSuc", Boolean.valueOf(bool5));
      localObject1 = ((i)localObject1).toString();
      s.s(localObject1, "try {\n                  …e ?: \"\"\n                }");
      AppMethodBeat.o(359737);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3 = localException.getMessage();
        Object localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ar.a
 * JD-Core Version:    0.7.0.1
 */