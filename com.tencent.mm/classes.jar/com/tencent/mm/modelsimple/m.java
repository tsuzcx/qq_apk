package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.b;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private static Map<String, Long> fOU;
  private static Map<String, String> fOV;
  private f callback;
  private boolean cwH;
  private c<com.tencent.mm.g.a.a> fOW;
  private final com.tencent.mm.ai.b fnd;
  
  static
  {
    AppMethodBeat.i(16588);
    fOU = new HashMap();
    AppMethodBeat.o(16588);
  }
  
  public m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(16582);
    this.cwH = false;
    b.a locala = new b.a();
    locala.fsX = new ajs();
    locala.fsY = new ajt();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.funcId = 775;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fnd = locala.ado();
    this.fnd.option = 1;
    ((ajs)this.fnd.fsV.fta).cwG = paramInt;
    this.cwH = paramBoolean;
    ajw();
    ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.cwH), bo.dtY() });
    AppMethodBeat.o(16582);
  }
  
  private void Q(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(16584);
    aw.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(16581);
        int i;
        Object localObject1;
        String str;
        int j;
        Object localObject2;
        if (paramString == null)
        {
          i = -1;
          ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          localObject1 = new ak();
          ((ak)localObject1).cnA.type = 5;
          ((ak)localObject1).cnA.cnC = paramString;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
          str = ((ak)localObject1).cnB.cnG;
          i = ((ak)localObject1).cnB.position;
          j = ((ak)localObject1).cnB.cnE;
          ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(m.a(m.this)), m.ajx() });
          if ((i != 1) || (j != 6)) {
            break label364;
          }
          if (paramBoolean) {
            m.aW(str, paramString);
          }
          if (!m.a(m.this)) {
            break label311;
          }
          localObject2 = ((ak)localObject1).cnB.desc;
          localObject1 = ((ak)localObject1).cnB.url;
          ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(ah.dsM()) });
          if (m.b(m.this) == null) {
            m.a(m.this, new m.1.1(this, (String)localObject2, (String)localObject1));
          }
          com.tencent.mm.sdk.b.a.ymk.c(m.b(m.this));
        }
        for (;;)
        {
          m.ajx().put(str, Long.valueOf(bo.yB()));
          AppMethodBeat.o(16581);
          return;
          i = paramString.length();
          break;
          label311:
          localObject2 = new jn();
          ((jn)localObject2).czd.content = ((ak)localObject1).cnB.desc;
          ((jn)localObject2).czd.url = ((ak)localObject1).cnB.url;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        }
        label364:
        if (j == 2)
        {
          if (paramBoolean) {
            m.aW(str, paramString);
          }
          m.ajx().put(str, Long.valueOf(bo.yB()));
        }
        AppMethodBeat.o(16581);
      }
    });
    AppMethodBeat.o(16584);
  }
  
  private void ajw()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        AppMethodBeat.i(16585);
        if (fOV != null) {
          break label374;
        }
        ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        fOV = new HashMap();
        SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("disaster_pref", h.Mp());
        Object localObject1 = localSharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (bo.isNullOrNil((String)localObject1)) {
          break label356;
        }
        String[] arrayOfString1 = ((String)localObject1).split(";");
        if ((arrayOfString1 == null) || (arrayOfString1.length <= 0)) {
          break label356;
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
            if (bo.getLong(arrayOfString2[0], 0L) <= 0L) {
              break label383;
            }
            localObject1 = str1;
            if (bo.gz(bo.getLong(arrayOfString2[1], 0L)) < 86400L)
            {
              localObject1 = str1;
              String str2 = localSharedPreferences.getString(arrayOfString2[0], "");
              localObject1 = str1;
              localObject4 = str1;
              if (!bo.isNullOrNil(str2))
              {
                localObject1 = str1;
                localObject4 = str1 + arrayOfString2[0] + "," + arrayOfString2[1] + ";";
                localObject1 = localObject4;
                fOV.put(arrayOfString2[0], str2);
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
            ab.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[] { localException.getMessage() });
            localObject4 = localObject1;
          }
        }
        localEditor.putString("disaster_new_noticeid_list_key", localException).commit();
      }
      finally {}
      ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, fOU });
      label356:
      ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { fOV });
      label374:
      AppMethodBeat.o(16585);
      return;
      label383:
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16583);
    ajs localajs = (ajs)this.fnd.fsV.fta;
    long l = bo.a((Long)fOU.get(localajs.cwG), 0L);
    ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localajs.cwG), Long.valueOf(l), fOU });
    if ((l != 0L) && (bo.av(l) < 1800000L))
    {
      ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localajs.cwG) });
      AppMethodBeat.o(16583);
      return -1;
    }
    String str = bo.bf((String)fOV.get(localajs.cwG), "");
    if (!bo.isNullOrNil(str))
    {
      ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localajs.cwG), str });
      Q(str, false);
      AppMethodBeat.o(16583);
      return -1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.fnd, this);
    AppMethodBeat.o(16583);
    return i;
  }
  
  public final int getType()
  {
    return 775;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16586);
    ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Q(((ajt)this.fnd.fsW.fta).content, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.m
 * JD-Core Version:    0.7.0.1
 */