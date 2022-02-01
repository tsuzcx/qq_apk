package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.ar.b;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class n
  extends q
  implements m
{
  private static Map<String, Long> jjs;
  private static Map<String, String> jjt;
  private i callback;
  private boolean dOp;
  private final d iFd;
  private IListener<com.tencent.mm.g.a.a> jju;
  
  static
  {
    AppMethodBeat.i(20632);
    jjs = new HashMap();
    AppMethodBeat.o(20632);
  }
  
  public n(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20626);
    this.dOp = false;
    d.a locala = new d.a();
    locala.iLN = new bmj();
    locala.iLO = new bmk();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.funcId = 775;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iFd = locala.aXF();
    this.iFd.option = 1;
    ((bmj)this.iFd.iLK.iLR).dOo = paramInt;
    this.dOp = paramBoolean;
    bfb();
    Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.dOp), Util.getStack() });
    AppMethodBeat.o(20626);
  }
  
  private void U(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20628);
    bg.aAk().postToWorker(new Runnable()
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
          localObject1 = new ar();
          ((ar)localObject1).dDD.type = 5;
          ((ar)localObject1).dDD.event = paramString;
          EventCenter.instance.publish((IEvent)localObject1);
          str = ((ar)localObject1).dDE.dDJ;
          i = ((ar)localObject1).dDE.position;
          j = ((ar)localObject1).dDE.dDH;
          Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(n.a(n.this)), n.apb() });
          if ((i != 1) || (j != 6)) {
            break label364;
          }
          if (paramBoolean) {
            n.by(str, paramString);
          }
          if (!n.a(n.this)) {
            break label311;
          }
          localObject2 = ((ar)localObject1).dDE.desc;
          localObject1 = ((ar)localObject1).dDE.url;
          Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(MMApplicationContext.isAppHasInit()) });
          if (n.b(n.this) == null) {
            n.a(n.this, new IListener() {});
          }
          EventCenter.instance.addListener(n.b(n.this));
        }
        for (;;)
        {
          n.apb().put(str, Long.valueOf(Util.currentTicks()));
          AppMethodBeat.o(20625);
          return;
          i = paramString.length();
          break;
          label311:
          localObject2 = new lz();
          ((lz)localObject2).dRz.content = ((ar)localObject1).dDE.desc;
          ((lz)localObject2).dRz.url = ((ar)localObject1).dDE.url;
          EventCenter.instance.publish((IEvent)localObject2);
        }
        label364:
        if (j == 2)
        {
          if (paramBoolean) {
            n.by(str, paramString);
          }
          n.apb().put(str, Long.valueOf(Util.currentTicks()));
        }
        AppMethodBeat.o(20625);
      }
    });
    AppMethodBeat.o(20628);
  }
  
  private void bfb()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        AppMethodBeat.i(20629);
        if (jjt != null) {
          break label374;
        }
        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        jjt = new HashMap();
        SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.aps());
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
                jjt.put(arrayOfString2[0], str2);
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
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, jjs });
      label356:
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { jjt });
      label374:
      AppMethodBeat.o(20629);
      return;
      label383:
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(20627);
    bmj localbmj = (bmj)this.iFd.iLK.iLR;
    long l = Util.nullAs((Long)jjs.get(localbmj.dOo), 0L);
    Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localbmj.dOo), Long.valueOf(l), jjs });
    if ((l != 0L) && (Util.ticksToNow(l) < 1800000L))
    {
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localbmj.dOo) });
      AppMethodBeat.o(20627);
      return -1;
    }
    String str = Util.nullAs((String)jjt.get(localbmj.dOo), "");
    if (!Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localbmj.dOo), str });
      U(str, false);
      AppMethodBeat.o(20627);
      return -1;
    }
    this.callback = parami;
    int i = dispatch(paramg, this.iFd, this);
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
      U(((bmk)this.iFd.iLL.iLR).content, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */