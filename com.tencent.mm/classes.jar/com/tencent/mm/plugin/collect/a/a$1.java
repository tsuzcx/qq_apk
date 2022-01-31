package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.a.by;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.collect.model.d;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.t;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class a$1
  implements bz.a
{
  a$1(a parama) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(40906);
    a.bhw();
    if (a.bhx() != null)
    {
      String str = aa.a(parama.eyJ.woR);
      a.bhw();
      Object localObject1 = a.bhx();
      long l = parama.eyJ.CreateTime;
      ab.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(str)));
      if (bo.isNullOrNil(str))
      {
        ab.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
        AppMethodBeat.o(40906);
        return;
      }
      Object localObject2 = br.F(str, "sysmsg");
      int i = bo.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.PayMsgType"), 0);
      if ((i != 9) && (i != 26))
      {
        ab.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i)));
        AppMethodBeat.o(40906);
        return;
      }
      parama = new t();
      parama.username = bo.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
      parama.kNS = (bo.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
      parama.cpp = bo.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
      parama.timestamp = bo.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)bo.aox());
      parama.cnJ = bo.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
      parama.elx = bo.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
      parama.scene = bo.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
      parama.status = bo.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
      parama.msgType = i;
      parama.kNU = bo.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
      parama.type = bo.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
      str = bo.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.voice_content"));
      localObject2 = bo.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.expire_voice_timestamp"));
      localObject1 = ((d)localObject1).kkV.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        d.a locala = (d.a)((Iterator)localObject1).next();
        if (locala != null) {
          locala.a(parama);
        }
      }
      if (parama.status == 1)
      {
        localObject1 = new by();
        ((by)localObject1).cpn.cpo = ((int)Math.round(parama.kNS * 100.0D));
        ((by)localObject1).cpn.cpp = parama.cpp;
        ((by)localObject1).cpn.cpr = parama.type;
        ((by)localObject1).cpn.cpq = parama.kNU;
        ((by)localObject1).cpn.cps = (cb.abq() - l * 1000L);
        ((by)localObject1).cpn.cpt = 1;
        ((by)localObject1).cpn.cpu = str;
        ((by)localObject1).cpn.cpv = ((String)localObject2);
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
      }
      AppMethodBeat.o(40906);
      return;
    }
    ab.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
    AppMethodBeat.o(40906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a.1
 * JD-Core Version:    0.7.0.1
 */