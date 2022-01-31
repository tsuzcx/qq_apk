package com.tencent.mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.au.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.List;

public final class c
  implements com.tencent.mm.plugin.messenger.foundation.a.r
{
  private static boolean SP(String paramString)
  {
    AppMethodBeat.i(1027);
    if ((t.nY(paramString)) && (!b.aih()))
    {
      AppMethodBeat.o(1027);
      return true;
    }
    AppMethodBeat.o(1027);
    return false;
  }
  
  public static e.b a(e.a parama, u paramu)
  {
    AppMethodBeat.i(1026);
    cm localcm = parama.eyJ;
    if ((10008 == ae.gkK) && (ae.gkL != 0))
    {
      ab.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localcm.pIG), Integer.valueOf(ae.gkL) });
      localcm.pIG = ae.gkL;
      ae.gkL = 0;
    }
    if (((j)g.E(j.class)).bPQ().kD(localcm.pIG))
    {
      ab.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      AppMethodBeat.o(1026);
      return null;
    }
    String str = aa.a(localcm.woP);
    Object localObject = aa.a(localcm.woQ);
    if ((str.equals(com.tencent.mm.model.r.Zn())) && (((String)localObject).equals("newsapp")) && (localcm.nqW != 51))
    {
      ab.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localcm.pIG), Integer.valueOf(localcm.nqW) });
      AppMethodBeat.o(1026);
      return null;
    }
    ab.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str, localObject, Long.valueOf(localcm.pIG), Integer.valueOf(localcm.pIE), Integer.valueOf(localcm.woW), Integer.valueOf(localcm.jJS), Integer.valueOf(localcm.nqW), Integer.valueOf(localcm.CreateTime), bo.nU(localcm.CreateTime), Long.valueOf(bo.aox() - localcm.CreateTime), Integer.valueOf(localcm.woS), Integer.valueOf(aa.a(localcm.woT, new byte[0]).length), Integer.valueOf(bo.nullAsNil(localcm.woU).length()), Integer.valueOf(bo.nullAsNil(localcm.woV).length()), bo.aqg(aa.a(localcm.woR, "")) });
    ab.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localcm.woU, "" });
    v.h(localcm);
    if (str.equals("readerapp"))
    {
      localcm.woP = aa.wA("newsapp");
      localcm.nqW = 12399999;
    }
    if (((str.equals("blogapp")) || (str.equals("newsapp"))) && (localcm.nqW != 10002)) {
      localcm.nqW = 12399999;
    }
    if (localcm.nqW == 52) {
      localcm.nqW = 1000052;
    }
    if (localcm.nqW == 53) {
      localcm.nqW = 1000053;
    }
    bf.c(parama);
    int i = 0;
    e.b localb = null;
    e locale = e.d.aV(Integer.valueOf(localcm.nqW));
    localObject = locale;
    if (locale == null) {
      localObject = e.d.aV(str);
    }
    if (localObject != null)
    {
      localb = ((e)localObject).b(parama);
      if (localb != null) {
        break label696;
      }
      localObject = null;
      if (localObject != null) {
        break label705;
      }
      ab.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localcm.nqW), Long.valueOf(localcm.pIG), Integer.valueOf(localcm.woW), Integer.valueOf(localcm.CreateTime), parama });
    }
    for (;;)
    {
      i = 1;
      v.b(5, localcm);
      if (i == 0) {
        ab.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localcm.nqW) });
      }
      AppMethodBeat.o(1026);
      return localb;
      label696:
      localObject = localb.cmQ;
      break;
      label705:
      if (!SP(str))
      {
        ab.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((dd)localObject).field_msgId + "  " + paramu);
        if ((((dd)localObject).field_msgId > 0L) && (paramu != null) && (localb.ftj)) {
          paramu.a((bi)localObject, localcm);
        }
      }
    }
  }
  
  public final void a(ud paramud, byte[] paramArrayOfByte, boolean paramBoolean, u paramu)
  {
    AppMethodBeat.i(1025);
    switch (paramud.wMC)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(1025);
      return;
      paramud = (cm)new cm().parseFrom(paramArrayOfByte);
      if (paramud != null)
      {
        paramArrayOfByte = new e.a(paramud, false, false, false);
        a(paramArrayOfByte, paramu);
        if (!paramArrayOfByte.fte) {
          bg.a(aa.a(paramud.woP), paramud.pIG, paramud.CreateTime * 1000L, paramud.nqW);
        }
      }
      AppMethodBeat.o(1025);
      return;
      paramArrayOfByte = (wu)new wu().parseFrom(paramArrayOfByte);
      paramud = aa.a(paramArrayOfByte.wOT);
      int i = paramArrayOfByte.wOW;
      paramArrayOfByte = ((j)g.E(j.class)).bPQ().cI(paramud, i);
      if (paramArrayOfByte.moveToFirst()) {
        while (!paramArrayOfByte.isAfterLast())
        {
          paramu = new bi();
          paramu.convertFrom(paramArrayOfByte);
          bf.m(paramu);
          paramArrayOfByte.moveToNext();
        }
      }
      paramArrayOfByte.close();
      ((j)g.E(j.class)).bPQ().cH(paramud, i);
      AppMethodBeat.o(1025);
      return;
      paramud = (xb)new xb().parseFrom(paramArrayOfByte);
      paramArrayOfByte = paramud.wOZ;
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        bf.y(aa.a(paramud.wOT), ((Integer)paramArrayOfByte.get(i)).intValue());
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.c
 * JD-Core Version:    0.7.0.1
 */