package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.at;
import com.tencent.mm.f.a.at.b;
import com.tencent.mm.f.a.mq;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btt;
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
  private static Map<String, Long> lZo;
  private static Map<String, String> lZp;
  private i callback;
  private boolean fHA;
  private IListener<com.tencent.mm.f.a.a> lZq;
  private final d lvf;
  
  static
  {
    AppMethodBeat.i(20632);
    lZo = new HashMap();
    AppMethodBeat.o(20632);
  }
  
  public n(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20626);
    this.fHA = false;
    d.a locala = new d.a();
    locala.lBU = new bts();
    locala.lBV = new btt();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.funcId = 775;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.lvf = locala.bgN();
    this.lvf.option = 1;
    ((bts)d.b.b(this.lvf.lBR)).fHz = paramInt;
    this.fHA = paramBoolean;
    boq();
    Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.fHA), Util.getStack() });
    AppMethodBeat.o(20626);
  }
  
  private void W(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20628);
    bh.aHJ().postToWorker(new Runnable()
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
          localObject1 = new at();
          ((at)localObject1).fwm.type = 5;
          ((at)localObject1).fwm.event = paramString;
          EventCenter.instance.publish((IEvent)localObject1);
          str = ((at)localObject1).fwn.fwt;
          i = ((at)localObject1).fwn.position;
          j = ((at)localObject1).fwn.fwq;
          Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(n.a(n.this)), n.avo() });
          if ((i != 1) || (j != 6)) {
            break label364;
          }
          if (paramBoolean) {
            n.bB(str, paramString);
          }
          if (!n.a(n.this)) {
            break label311;
          }
          localObject2 = ((at)localObject1).fwn.desc;
          localObject1 = ((at)localObject1).fwn.url;
          Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(MMApplicationContext.isAppHasInit()) });
          if (n.b(n.this) == null) {
            n.a(n.this, new IListener() {});
          }
          EventCenter.instance.addListener(n.b(n.this));
        }
        for (;;)
        {
          n.avo().put(str, Long.valueOf(Util.currentTicks()));
          AppMethodBeat.o(20625);
          return;
          i = paramString.length();
          break;
          label311:
          localObject2 = new mq();
          ((mq)localObject2).fKP.content = ((at)localObject1).fwn.desc;
          ((mq)localObject2).fKP.url = ((at)localObject1).fwn.url;
          EventCenter.instance.publish((IEvent)localObject2);
        }
        label364:
        if (j == 2)
        {
          if (paramBoolean) {
            n.bB(str, paramString);
          }
          n.avo().put(str, Long.valueOf(Util.currentTicks()));
        }
        AppMethodBeat.o(20625);
      }
    });
    AppMethodBeat.o(20628);
  }
  
  private void boq()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        AppMethodBeat.i(20629);
        if (lZp != null) {
          break label374;
        }
        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        lZp = new HashMap();
        SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.avK());
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
                lZp.put(arrayOfString2[0], str2);
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
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, lZo });
      label356:
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { lZp });
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
    bts localbts = (bts)d.b.b(this.lvf.lBR);
    long l = Util.nullAs((Long)lZo.get(localbts.fHz), 0L);
    Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localbts.fHz), Long.valueOf(l), lZo });
    if ((l != 0L) && (Util.ticksToNow(l) < 1800000L))
    {
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localbts.fHz) });
      AppMethodBeat.o(20627);
      return -1;
    }
    String str = Util.nullAs((String)lZp.get(localbts.fHz), "");
    if (!Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localbts.fHz), str });
      W(str, false);
      AppMethodBeat.o(20627);
      return -1;
    }
    this.callback = parami;
    int i = dispatch(paramg, this.lvf, this);
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
      W(((btt)d.c.b(this.lvf.lBS)).content, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */