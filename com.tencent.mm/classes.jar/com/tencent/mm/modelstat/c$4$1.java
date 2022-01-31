package com.tencent.mm.modelstat;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.r;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$4$1
  implements Runnable
{
  c$4$1(c.4 param4, akd paramakd) {}
  
  public final void run()
  {
    AppMethodBeat.i(78661);
    this.fSi.fSf.aZ("LAST_UPDATE_CONFIG", bo.aox());
    Object localObject1;
    if ((this.fSh.xbp == null) || (this.fSh.xbp.pW.length <= 0) || (this.fSh.xbn == null) || (this.fSh.xbn.pW.length <= 0))
    {
      if (this.fSh.xbp == null)
      {
        localObject1 = null;
        if (this.fSh.xbn != null) {
          break label141;
        }
      }
      label141:
      for (localObject3 = null;; localObject3 = Integer.valueOf(this.fSh.xbn.pW.length))
      {
        ab.e("MicroMsg.ClickFlowStatReceiver", "OnSceneEnd NetSceneUpdateEventConfig failed, eventsampleconf:%s, versionbuffer:%s", new Object[] { localObject1, localObject3 });
        AppMethodBeat.o(78661);
        return;
        localObject1 = Integer.valueOf(this.fSh.xbp.pW.length);
        break;
      }
    }
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(346L, 3L, 1L, false);
    Object localObject3 = bo.cg(this.fSh.xbn.pW);
    String str = this.fSi.fSf.getValue("versionBuffer");
    this.fSi.fSf.ij("versionBuffer", (String)localObject3);
    Object localObject4 = this.fSh.xbp;
    Object localObject2;
    try
    {
      localObject1 = new String(r.A(((b)localObject4).pW), "UTF-8");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(346L, 2L, 1L, false);
        AppMethodBeat.o(78661);
        return;
      }
    }
    catch (Exception localException1)
    {
      if (localObject4 == null) {}
      for (int i = 0;; i = ((b)localObject4).pW.length)
      {
        ab.e("MicroMsg.ClickFlowStatReceiver", "decompress failed, configString length %d, msg:%s  [%s]", new Object[] { Integer.valueOf(i), localException1.getMessage(), bo.l(localException1) });
        localObject2 = null;
        break;
      }
    }
    try
    {
      localObject4 = c.a.uF((String)localObject2);
      com.tencent.mm.a.e.b(this.fSi.fSg, ((String)localObject2).getBytes(), ((String)localObject2).getBytes().length);
      c.a(this.fSi.fSd, (c.a)localObject4);
      bool = true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.e("MicroMsg.ClickFlowStatReceiver", "readReportConfig failed :%s  [%s]", new Object[] { localException2.getMessage(), bo.l(localException2) });
        boolean bool = false;
        continue;
        long l = 1L;
      }
    }
    if (!((String)localObject3).equals(str))
    {
      ab.i("MicroMsg.ClickFlowStatReceiver", "idKeyStat, configOK:%b", new Object[] { Boolean.valueOf(bool) });
      localObject2 = com.tencent.mm.plugin.report.e.qrI;
      if (bool)
      {
        l = 0L;
        ((com.tencent.mm.plugin.report.e)localObject2).idkeyStat(346L, l, 1L, false);
      }
    }
    else
    {
      AppMethodBeat.o(78661);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.4.1
 * JD-Core Version:    0.7.0.1
 */