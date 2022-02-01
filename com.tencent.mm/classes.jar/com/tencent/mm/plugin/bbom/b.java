package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.c
{
  static void a(db paramdb, bq.b paramb, as paramas)
  {
    AppMethodBeat.i(22334);
    String str1 = z.a(paramdb.RID);
    bh.beI();
    com.tencent.mm.model.c.aHp().i(73729, Integer.valueOf(1));
    String str2 = paramas.field_nickname;
    bx localbx = new bx();
    localbx.field_content = z.a(paramdb.RIF);
    localbx.field_createtime = Util.nowSecond();
    localbx.field_imgpath = "";
    if (paramdb.COi == 3)
    {
      paramas = MMApplicationContext.getContext().getString(R.l.nearby_say_hi_type_image);
      localbx.field_sayhicontent = paramas;
      localbx.field_sayhiuser = str1;
      localbx.field_scene = 18;
      if (paramdb.rVU <= 3) {
        break label229;
      }
    }
    label229:
    for (int i = paramdb.rVU;; i = 3)
    {
      localbx.field_status = i;
      localbx.field_svrid = paramdb.HlH;
      localbx.field_talker = str2;
      localbx.field_type = paramdb.COi;
      localbx.field_isSend = 0;
      localbx.field_sayhiencryptuser = str1;
      localbx.field_ticket = paramb.luy;
      com.tencent.mm.bl.d.bqd().a(localbx);
      paramdb = new mj();
      paramdb.fKt.fKu = str1;
      EventCenter.instance.publish(paramdb);
      AppMethodBeat.o(22334);
      return;
      paramas = z.a(paramdb.RIF);
      break;
    }
  }
  
  public final void a(final h.a parama, ca paramca, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(22333);
    parama = parama.jQG;
    paramString2 = bq.RR(parama.RII);
    if (paramString2 != null)
    {
      paramca.Jv(paramString2.lut);
      paramca.qb(paramString2.luu);
      paramca.Jq(paramString2.lus);
      Log.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.lus });
      if ((paramString2.luy != null) && (paramString2.scene == 1) && (parama.COi != 10000))
      {
        bh.beI();
        paramca = com.tencent.mm.model.c.bbL().RG(paramString1);
        if ((paramca == null) || ((int)paramca.jxt <= 0))
        {
          az.a.ltq.a(paramString1, null, new az.b.a()
          {
            public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22332);
              bh.beI();
              paramAnonymousString = com.tencent.mm.model.c.bbL().RG(paramString1);
              b.a(parama, paramString2, paramAnonymousString);
              AppMethodBeat.o(22332);
            }
          });
          AppMethodBeat.o(22333);
          return;
        }
        a(parama, paramString2, paramca);
      }
    }
    AppMethodBeat.o(22333);
  }
  
  public final void b(h.a parama, ca paramca, String paramString1, String paramString2, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */