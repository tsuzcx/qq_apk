package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ca;
import java.util.List;

final class b$5
  implements Runnable
{
  b$5(ah paramah, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(20114);
    i = this.jwK.hxE();
    j = this.jwK.field_chatroomdataflag;
    int k = this.jwK.hxG();
    Object localObject1 = this.jwK;
    if (((ah)localObject1).b(((ah)localObject1).VfA)) {
      ((ah)localObject1).hxD();
    }
    int m = ((ah)localObject1).VfA.status;
    int n = this.jwK.hxH();
    localObject1 = this.jwK;
    if (((ah)localObject1).b(((ah)localObject1).VfA)) {
      ((ah)localObject1).hxD();
    }
    Object localObject3 = ((ah)localObject1).VfA.jmz;
    localObject1 = this.jwK.bjL();
    bh.beI();
    Object localObject2 = c.bbO().iR(this.jwL, " and msgSeq != 0 and flag & 2 != 0");
    boolean bool;
    if ((localObject2 != null) && (((et)localObject2).field_msgId > 0L))
    {
      bool = true;
      bh.beI();
      int i1 = c.bbO().aOW(this.jwL);
      Log.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", new Object[] { this.jwL, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(n), localObject3, Integer.valueOf(((List)localObject1).size()) });
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("---chatroominfo---\nid:").append(this.jwL).append("\nver:").append(i).append("\nflag:").append(j).append("\ntype:").append(k).append("\nstatus:").append(m).append("\nget:").append(bool).append("\nmsgCount:").append(i1).append("\nmaxCount:").append(n).append("\nupgrader:").append((String)localObject3).append("\nmembersize:").append(((List)localObject1).size()).append("\nisSilence:").append(((n)h.ae(n.class)).eRZ().aOp(this.jwL)).append("\nsillenceBlock:").append(((n)h.ae(n.class)).eRZ().aOs(this.jwL).toString());
      localObject3 = this.val$msg.split(" ");
      i = -1;
    }
    try
    {
      j = Util.getInt(localObject3[1], 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        i = j;
      }
    }
    if (i != -1) {}
    for (;;)
    {
      j = i;
      if (i > ((List)localObject1).size()) {
        j = ((List)localObject1).size();
      }
      if (j <= 10) {
        break label635;
      }
      i = 10;
      if (i > 0) {
        ((StringBuilder)localObject2).append("\nmember:");
      }
      j = 0;
      while (j < i)
      {
        ((StringBuilder)localObject2).append("\n").append((String)((List)localObject1).get(j));
        j += 1;
      }
      bool = false;
      break;
      i = ((List)localObject1).size();
    }
    localObject1 = new ca();
    ((ca)localObject1).Jm(this.jwL);
    ((ca)localObject1).pJ(2);
    ((ca)localObject1).setType(1);
    ((ca)localObject1).setCreateTime(System.currentTimeMillis());
    ((ca)localObject1).setContent(((StringBuilder)localObject2).toString());
    bq.z((ca)localObject1);
    AppMethodBeat.o(20114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.5
 * JD-Core Version:    0.7.0.1
 */