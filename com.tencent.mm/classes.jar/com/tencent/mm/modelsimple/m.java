package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ap.b;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.model.az;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class m
  extends n
  implements k
{
  private static Map<String, Long> hSa;
  private static Map<String, String> hSb;
  private com.tencent.mm.ak.g callback;
  private boolean djQ;
  private c<com.tencent.mm.g.a.a> hSc;
  private final com.tencent.mm.ak.b hpf;
  
  static
  {
    AppMethodBeat.i(20632);
    hSa = new HashMap();
    AppMethodBeat.o(20632);
  }
  
  public m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20626);
    this.djQ = false;
    b.a locala = new b.a();
    locala.hvt = new awg();
    locala.hvu = new awh();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.funcId = 775;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hpf = locala.aAz();
    this.hpf.option = 1;
    ((awg)this.hpf.hvr.hvw).djP = paramInt;
    this.djQ = paramBoolean;
    aHr();
    ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.djQ), bs.eWi() });
    AppMethodBeat.o(20626);
  }
  
  private void U(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20628);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20625);
        int i;
        Object localObject1;
        String str;
        int j;
        Object localObject2;
        if (paramString == null)
        {
          i = -1;
          ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          localObject1 = new com.tencent.mm.g.a.ap();
          ((com.tencent.mm.g.a.ap)localObject1).cZT.type = 5;
          ((com.tencent.mm.g.a.ap)localObject1).cZT.cZV = paramString;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
          str = ((com.tencent.mm.g.a.ap)localObject1).cZU.daa;
          i = ((com.tencent.mm.g.a.ap)localObject1).cZU.position;
          j = ((com.tencent.mm.g.a.ap)localObject1).cZU.cZY;
          ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(m.a(m.this)), m.Yr() });
          if ((i != 1) || (j != 6)) {
            break label364;
          }
          if (paramBoolean) {
            m.bt(str, paramString);
          }
          if (!m.a(m.this)) {
            break label311;
          }
          localObject2 = ((com.tencent.mm.g.a.ap)localObject1).cZU.desc;
          localObject1 = ((com.tencent.mm.g.a.ap)localObject1).cZU.url;
          ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(ai.eUU()) });
          if (m.b(m.this) == null) {
            m.a(m.this, new c() {});
          }
          com.tencent.mm.sdk.b.a.GpY.c(m.b(m.this));
        }
        for (;;)
        {
          m.Yr().put(str, Long.valueOf(bs.Gn()));
          AppMethodBeat.o(20625);
          return;
          i = paramString.length();
          break;
          label311:
          localObject2 = new kz();
          ((kz)localObject2).dmT.content = ((com.tencent.mm.g.a.ap)localObject1).cZU.desc;
          ((kz)localObject2).dmT.url = ((com.tencent.mm.g.a.ap)localObject1).cZU.url;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        }
        label364:
        if (j == 2)
        {
          if (paramBoolean) {
            m.bt(str, paramString);
          }
          m.Yr().put(str, Long.valueOf(bs.Gn()));
        }
        AppMethodBeat.o(20625);
      }
    });
    AppMethodBeat.o(20628);
  }
  
  private void aHr()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        AppMethodBeat.i(20629);
        if (hSb != null) {
          break label373;
        }
        ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        hSb = new HashMap();
        SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.YK());
        Object localObject1 = localSharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (bs.isNullOrNil((String)localObject1)) {
          break label355;
        }
        String[] arrayOfString1 = ((String)localObject1).split(";");
        if ((arrayOfString1 == null) || (arrayOfString1.length <= 0)) {
          break label355;
        }
        String str1 = "";
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split(",");
          localObject1 = str1;
          localObject4 = str1;
          try
          {
            if (bs.getLong(arrayOfString2[0], 0L) <= 0L) {
              break label382;
            }
            localObject1 = str1;
            if (bs.pN(bs.getLong(arrayOfString2[1], 0L)) < 86400L)
            {
              localObject1 = str1;
              String str2 = localSharedPreferences.getString(arrayOfString2[0], "");
              localObject1 = str1;
              localObject4 = str1;
              if (!bs.isNullOrNil(str2))
              {
                localObject1 = str1;
                localObject4 = str1 + arrayOfString2[0] + "," + arrayOfString2[1] + ";";
                localObject1 = localObject4;
                hSb.put(arrayOfString2[0], str2);
              }
            }
            else
            {
              localObject1 = str1;
              localEditor.remove(arrayOfString2[0]).commit();
              localObject4 = str1;
            }
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[] { localException.getMessage() });
            localObject4 = localObject1;
          }
        }
        localEditor.putString("disaster_new_noticeid_list_key", localException).commit();
      }
      finally {}
      ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, hSa });
      label355:
      ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { hSb });
      label373:
      AppMethodBeat.o(20629);
      return;
      label382:
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(20627);
    awg localawg = (awg)this.hpf.hvr.hvw;
    long l = bs.a((Long)hSa.get(localawg.djP), 0L);
    ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localawg.djP), Long.valueOf(l), hSa });
    if ((l != 0L) && (bs.aO(l) < 1800000L))
    {
      ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localawg.djP) });
      AppMethodBeat.o(20627);
      return -1;
    }
    String str = bs.bG((String)hSb.get(localawg.djP), "");
    if (!bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localawg.djP), str });
      U(str, false);
      AppMethodBeat.o(20627);
      return -1;
    }
    this.callback = paramg;
    int i = dispatch(parame, this.hpf, this);
    AppMethodBeat.o(20627);
    return i;
  }
  
  public final int getType()
  {
    return 775;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20630);
    ac.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      U(((awh)this.hpf.hvs.hvw).content, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.m
 * JD-Core Version:    0.7.0.1
 */