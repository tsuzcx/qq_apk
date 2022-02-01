package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ap.b;
import com.tencent.mm.g.a.li;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class m
  extends n
  implements k
{
  private static Map<String, Long> ilr;
  private static Map<String, String> ils;
  private f callback;
  private boolean dvD;
  private final com.tencent.mm.al.b hHx;
  private c<com.tencent.mm.g.a.a> ilt;
  
  static
  {
    AppMethodBeat.i(20632);
    ilr = new HashMap();
    AppMethodBeat.o(20632);
  }
  
  public m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20626);
    this.dvD = false;
    b.a locala = new b.a();
    locala.hNM = new bae();
    locala.hNN = new baf();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.funcId = 775;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.hHx = locala.aDC();
    this.hHx.option = 1;
    ((bae)this.hHx.hNK.hNQ).dvC = paramInt;
    this.dvD = paramBoolean;
    aKC();
    ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.dvD), bt.flS() });
    AppMethodBeat.o(20626);
  }
  
  private void U(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20628);
    ba.ajF().ay(new Runnable()
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
          ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          localObject1 = new ap();
          ((ap)localObject1).dll.type = 5;
          ((ap)localObject1).dll.dln = paramString;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
          str = ((ap)localObject1).dlm.dls;
          i = ((ap)localObject1).dlm.position;
          j = ((ap)localObject1).dlm.dlq;
          ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(m.a(m.this)), m.aaT() });
          if ((i != 1) || (j != 6)) {
            break label364;
          }
          if (paramBoolean) {
            m.bu(str, paramString);
          }
          if (!m.a(m.this)) {
            break label311;
          }
          localObject2 = ((ap)localObject1).dlm.desc;
          localObject1 = ((ap)localObject1).dlm.url;
          ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(aj.fkz()) });
          if (m.b(m.this) == null) {
            m.a(m.this, new c() {});
          }
          com.tencent.mm.sdk.b.a.IbL.c(m.b(m.this));
        }
        for (;;)
        {
          m.aaT().put(str, Long.valueOf(bt.HI()));
          AppMethodBeat.o(20625);
          return;
          i = paramString.length();
          break;
          label311:
          localObject2 = new li();
          ((li)localObject2).dyH.content = ((ap)localObject1).dlm.desc;
          ((li)localObject2).dyH.url = ((ap)localObject1).dlm.url;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
        }
        label364:
        if (j == 2)
        {
          if (paramBoolean) {
            m.bu(str, paramString);
          }
          m.aaT().put(str, Long.valueOf(bt.HI()));
        }
        AppMethodBeat.o(20625);
      }
    });
    AppMethodBeat.o(20628);
  }
  
  private void aKC()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        AppMethodBeat.i(20629);
        if (ils != null) {
          break label373;
        }
        ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        ils = new HashMap();
        SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("disaster_pref", g.abm());
        Object localObject1 = localSharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (bt.isNullOrNil((String)localObject1)) {
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
            if (bt.getLong(arrayOfString2[0], 0L) <= 0L) {
              break label382;
            }
            localObject1 = str1;
            if (bt.rM(bt.getLong(arrayOfString2[1], 0L)) < 86400L)
            {
              localObject1 = str1;
              String str2 = localSharedPreferences.getString(arrayOfString2[0], "");
              localObject1 = str1;
              localObject4 = str1;
              if (!bt.isNullOrNil(str2))
              {
                localObject1 = str1;
                localObject4 = str1 + arrayOfString2[0] + "," + arrayOfString2[1] + ";";
                localObject1 = localObject4;
                ils.put(arrayOfString2[0], str2);
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
            ad.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[] { localException.getMessage() });
            localObject4 = localObject1;
          }
        }
        localEditor.putString("disaster_new_noticeid_list_key", localException).commit();
      }
      finally {}
      ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, ilr });
      label355:
      ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { ils });
      label373:
      AppMethodBeat.o(20629);
      return;
      label382:
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20627);
    bae localbae = (bae)this.hHx.hNK.hNQ;
    long l = bt.a((Long)ilr.get(localbae.dvC), 0L);
    ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localbae.dvC), Long.valueOf(l), ilr });
    if ((l != 0L) && (bt.aO(l) < 1800000L))
    {
      ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localbae.dvC) });
      AppMethodBeat.o(20627);
      return -1;
    }
    String str = bt.bI((String)ils.get(localbae.dvC), "");
    if (!bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localbae.dvC), str });
      U(str, false);
      AppMethodBeat.o(20627);
      return -1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.hHx, this);
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
    ad.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      U(((baf)this.hHx.hNL.hNQ).content, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.m
 * JD-Core Version:    0.7.0.1
 */