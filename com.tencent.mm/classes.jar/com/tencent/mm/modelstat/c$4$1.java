package com.tencent.mm.modelstat;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.q;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$4$1
  implements Runnable
{
  c$4$1(c.4 param4, afm paramafm) {}
  
  public final void run()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    this.eCr.eCo.ar("LAST_UPDATE_CONFIG", bk.UX());
    if ((this.eCq.tdr == null) || (this.eCq.tdr.oY.length <= 0) || (this.eCq.tdp == null) || (this.eCq.tdp.oY.length <= 0)) {
      if (this.eCq.tdr == null)
      {
        localObject1 = null;
        if (this.eCq.tdp != null) {
          break label134;
        }
        label93:
        y.e("MicroMsg.ClickFlowStatReceiver", "OnSceneEnd NetSceneUpdateEventConfig failed, eventsampleconf:%s, versionbuffer:%s", new Object[] { localObject1, localObject2 });
      }
    }
    label134:
    label312:
    do
    {
      return;
      localObject1 = Integer.valueOf(this.eCq.tdr.oY.length);
      break;
      localObject2 = Integer.valueOf(this.eCq.tdp.oY.length);
      break label93;
      f.nEG.a(346L, 3L, 1L, false);
      String str1 = bk.bG(this.eCq.tdp.oY);
      String str2 = this.eCr.eCo.getValue("versionBuffer");
      this.eCr.eCo.gi("versionBuffer", str1);
      b localb = this.eCq.tdr;
      try
      {
        localObject2 = new String(q.r(localb.oY), "UTF-8");
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        if (localb != null) {
          break label312;
        }
        for (i = 0;; i = localb.oY.length)
        {
          y.e("MicroMsg.ClickFlowStatReceiver", "decompress failed, configString length %d, msg:%s  [%s]", new Object[] { Integer.valueOf(i), localException2.getMessage(), bk.j(localException2) });
          break;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        f.nEG.a(346L, 2L, 1L, false);
        return;
      }
      try
      {
        int i;
        c.a locala = c.a.nr((String)localObject1);
        e.b(this.eCr.eCp, ((String)localObject1).getBytes(), ((String)localObject1).getBytes().length);
        c.a(this.eCr.eCm, locala);
        bool = true;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.e("MicroMsg.ClickFlowStatReceiver", "readReportConfig failed :%s  [%s]", new Object[] { localException1.getMessage(), bk.j(localException1) });
          boolean bool = false;
          continue;
          long l = 1L;
        }
      }
    } while (str1.equals(str2));
    y.i("MicroMsg.ClickFlowStatReceiver", "idKeyStat, configOK:%b", new Object[] { Boolean.valueOf(bool) });
    localObject1 = f.nEG;
    if (bool)
    {
      l = 0L;
      ((f)localObject1).a(346L, l, 1L, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.4.1
 * JD-Core Version:    0.7.0.1
 */