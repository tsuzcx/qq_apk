package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ap.b;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.model.bc;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private static Map<String, Long> iok;
  private static Map<String, String> iol;
  private f callback;
  private boolean dwI;
  private final com.tencent.mm.ak.b hKp;
  private c<com.tencent.mm.g.a.a> iom;
  
  static
  {
    AppMethodBeat.i(20632);
    iok = new HashMap();
    AppMethodBeat.o(20632);
  }
  
  public n(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20626);
    this.dwI = false;
    b.a locala = new b.a();
    locala.hQF = new bau();
    locala.hQG = new bav();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.funcId = 775;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.hKp = locala.aDS();
    this.hKp.option = 1;
    ((bau)this.hKp.hQD.hQJ).dwH = paramInt;
    this.dwI = paramBoolean;
    aKZ();
    ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.dwI), bu.fpN() });
    AppMethodBeat.o(20626);
  }
  
  private void U(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20628);
    bc.ajU().aw(new Runnable()
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
          ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          localObject1 = new ap();
          ((ap)localObject1).dmn.type = 5;
          ((ap)localObject1).dmn.dmp = paramString;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
          str = ((ap)localObject1).dmo.dmu;
          i = ((ap)localObject1).dmo.position;
          j = ((ap)localObject1).dmo.dms;
          ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(n.a(n.this)), n.abc() });
          if ((i != 1) || (j != 6)) {
            break label364;
          }
          if (paramBoolean) {
            n.bu(str, paramString);
          }
          if (!n.a(n.this)) {
            break label311;
          }
          localObject2 = ((ap)localObject1).dmo.desc;
          localObject1 = ((ap)localObject1).dmo.url;
          ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(ak.fot()) });
          if (n.b(n.this) == null) {
            n.a(n.this, new c() {});
          }
          com.tencent.mm.sdk.b.a.IvT.c(n.b(n.this));
        }
        for (;;)
        {
          n.abc().put(str, Long.valueOf(bu.HQ()));
          AppMethodBeat.o(20625);
          return;
          i = paramString.length();
          break;
          label311:
          localObject2 = new lj();
          ((lj)localObject2).dzM.content = ((ap)localObject1).dmo.desc;
          ((lj)localObject2).dzM.url = ((ap)localObject1).dmo.url;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
        }
        label364:
        if (j == 2)
        {
          if (paramBoolean) {
            n.bu(str, paramString);
          }
          n.abc().put(str, Long.valueOf(bu.HQ()));
        }
        AppMethodBeat.o(20625);
      }
    });
    AppMethodBeat.o(20628);
  }
  
  private void aKZ()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        AppMethodBeat.i(20629);
        if (iol != null) {
          break label373;
        }
        ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        iol = new HashMap();
        SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("disaster_pref", g.abv());
        Object localObject1 = localSharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (bu.isNullOrNil((String)localObject1)) {
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
            if (bu.getLong(arrayOfString2[0], 0L) <= 0L) {
              break label382;
            }
            localObject1 = str1;
            if (bu.rZ(bu.getLong(arrayOfString2[1], 0L)) < 86400L)
            {
              localObject1 = str1;
              String str2 = localSharedPreferences.getString(arrayOfString2[0], "");
              localObject1 = str1;
              localObject4 = str1;
              if (!bu.isNullOrNil(str2))
              {
                localObject1 = str1;
                localObject4 = str1 + arrayOfString2[0] + "," + arrayOfString2[1] + ";";
                localObject1 = localObject4;
                iol.put(arrayOfString2[0], str2);
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
            ae.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[] { localException.getMessage() });
            localObject4 = localObject1;
          }
        }
        localEditor.putString("disaster_new_noticeid_list_key", localException).commit();
      }
      finally {}
      ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, iok });
      label355:
      ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { iol });
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
    bau localbau = (bau)this.hKp.hQD.hQJ;
    long l = bu.a((Long)iok.get(localbau.dwH), 0L);
    ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localbau.dwH), Long.valueOf(l), iok });
    if ((l != 0L) && (bu.aO(l) < 1800000L))
    {
      ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localbau.dwH) });
      AppMethodBeat.o(20627);
      return -1;
    }
    String str = bu.bI((String)iol.get(localbau.dwH), "");
    if (!bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localbau.dwH), str });
      U(str, false);
      AppMethodBeat.o(20627);
      return -1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.hKp, this);
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
    ae.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      U(((bav)this.hKp.hQE.hQJ).content, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */