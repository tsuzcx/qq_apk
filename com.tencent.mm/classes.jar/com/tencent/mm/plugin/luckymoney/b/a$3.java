package com.tencent.mm.plugin.luckymoney.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.net.URLDecoder;
import java.util.Map;

final class a$3
  implements bz.a
{
  a$3(a parama) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(41968);
    Object localObject1 = br.F(aa.a(parama.eyJ.woR), "sysmsg");
    ab.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
    if (localObject1 == null)
    {
      ab.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
      AppMethodBeat.o(41968);
      return;
    }
    if ("14".equals((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType")))
    {
      parama = URLDecoder.decode((String)((Map)localObject1).get(".sysmsg.paymsg.appmsgcontent"));
      if (TextUtils.isEmpty(parama))
      {
        ab.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
        AppMethodBeat.o(41968);
        return;
      }
      Object localObject2 = br.F(parama, "msg");
      if (localObject2 == null)
      {
        ab.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
        AppMethodBeat.o(41968);
        return;
      }
      localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (bo.isNullOrNil((String)localObject2))
      {
        ab.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
        AppMethodBeat.o(41968);
        return;
      }
      localObject1 = (String)((Map)localObject1).get(".sysmsg.paymsg.tousername");
      if ((bo.isNullOrNil(parama)) || (bo.isNullOrNil((String)localObject1)))
      {
        ab.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
        AppMethodBeat.o(41968);
        return;
      }
      if (this.oil.bMJ().Sr((String)localObject2))
      {
        ab.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
        if (!x.J(parama, (String)localObject1, 1)) {
          this.oil.bMJ().Ss((String)localObject2);
        }
      }
    }
    AppMethodBeat.o(41968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a.3
 * JD-Core Version:    0.7.0.1
 */