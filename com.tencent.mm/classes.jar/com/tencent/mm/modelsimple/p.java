package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ay;
import com.tencent.mm.autogen.a.ay.b;
import com.tencent.mm.autogen.a.b;
import com.tencent.mm.autogen.a.nx;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private static Map<String, Long> oSx;
  private static Map<String, String> oSy;
  private h callback;
  private boolean hNa;
  private IListener<b> oSz;
  private final c omC;
  
  static
  {
    AppMethodBeat.i(20632);
    oSx = new HashMap();
    AppMethodBeat.o(20632);
  }
  
  public p(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20626);
    this.hNa = false;
    c.a locala = new c.a();
    locala.otE = new cil();
    locala.otF = new cim();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.funcId = 775;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.omC = locala.bEF();
    this.omC.option = 1;
    ((cil)c.b.b(this.omC.otB)).hMZ = paramInt;
    this.hNa = paramBoolean;
    bMf();
    Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.hNa), Util.getStack() });
    AppMethodBeat.o(20626);
  }
  
  private void aa(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20628);
    bh.baH().postToWorker(new Runnable()
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
          Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          localObject1 = new ay();
          ((ay)localObject1).hAK.type = 5;
          ((ay)localObject1).hAK.event = paramString;
          ((ay)localObject1).publish();
          str = ((ay)localObject1).hAL.hAR;
          i = ((ay)localObject1).hAL.position;
          j = ((ay)localObject1).hAL.hAO;
          Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(p.a(p.this)), p.aCw() });
          if ((i != 1) || (j != 6)) {
            break label357;
          }
          if (paramBoolean) {
            p.bM(str, paramString);
          }
          if (!p.a(p.this)) {
            break label307;
          }
          localObject2 = ((ay)localObject1).hAL.desc;
          localObject1 = ((ay)localObject1).hAL.url;
          Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(MMApplicationContext.isAppHasInit()) });
          if (p.b(p.this) == null) {
            p.a(p.this, new NetSceneGetDisasterInfo.1.1(this, f.hfK, (String)localObject2, (String)localObject1));
          }
          p.b(p.this).alive();
        }
        for (;;)
        {
          p.aCw().put(str, Long.valueOf(Util.currentTicks()));
          AppMethodBeat.o(20625);
          return;
          i = paramString.length();
          break;
          label307:
          localObject2 = new nx();
          ((nx)localObject2).hQw.content = ((ay)localObject1).hAL.desc;
          ((nx)localObject2).hQw.url = ((ay)localObject1).hAL.url;
          ((nx)localObject2).publish();
        }
        label357:
        if (j == 2)
        {
          if (paramBoolean) {
            p.bM(str, paramString);
          }
          p.aCw().put(str, Long.valueOf(Util.currentTicks()));
        }
        AppMethodBeat.o(20625);
      }
    });
    AppMethodBeat.o(20628);
  }
  
  private void bMf()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        AppMethodBeat.i(20629);
        if (oSy != null) {
          break label374;
        }
        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        oSy = new HashMap();
        SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.aQe());
        Object localObject1 = localSharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (Util.isNullOrNil((String)localObject1)) {
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
            if (Util.getLong(arrayOfString2[0], 0L) <= 0L) {
              break label383;
            }
            localObject1 = str1;
            if (Util.secondsToNow(Util.getLong(arrayOfString2[1], 0L)) < 86400L)
            {
              localObject1 = str1;
              String str2 = localSharedPreferences.getString(arrayOfString2[0], "");
              localObject1 = str1;
              localObject4 = str1;
              if (!Util.isNullOrNil(str2))
              {
                localObject1 = str1;
                localObject4 = str1 + arrayOfString2[0] + "," + arrayOfString2[1] + ";";
                localObject1 = localObject4;
                oSy.put(arrayOfString2[0], str2);
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
            Log.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[] { localException.getMessage() });
            localObject4 = localObject1;
          }
        }
        localEditor.putString("disaster_new_noticeid_list_key", localException).commit();
      }
      finally {}
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, oSx });
      label356:
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { oSy });
      label374:
      AppMethodBeat.o(20629);
      return;
      label383:
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(20627);
    cil localcil = (cil)c.b.b(this.omC.otB);
    long l = Util.nullAs((Long)oSx.get(localcil.hMZ), 0L);
    Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localcil.hMZ), Long.valueOf(l), oSx });
    if ((l != 0L) && (Util.ticksToNow(l) < 1800000L))
    {
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localcil.hMZ) });
      AppMethodBeat.o(20627);
      return -1;
    }
    String str = Util.nullAs((String)oSy.get(localcil.hMZ), "");
    if (!Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localcil.hMZ), str });
      aa(str, false);
      AppMethodBeat.o(20627);
      return -1;
    }
    this.callback = paramh;
    int i = dispatch(paramg, this.omC, this);
    AppMethodBeat.o(20627);
    return i;
  }
  
  public final int getType()
  {
    return 775;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20630);
    Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      aa(((cim)c.c.b(this.omC.otC)).content, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.p
 * JD-Core Version:    0.7.0.1
 */