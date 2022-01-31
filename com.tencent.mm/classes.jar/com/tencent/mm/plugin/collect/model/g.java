package com.tencent.mm.plugin.collect.model;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.by.a;
import com.tencent.mm.plugin.collect.model.voice.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
  extends c<by>
  implements f, a.c
{
  private static final String kMT;
  private static final com.tencent.mm.bv.b kMU;
  private boolean isPlaying;
  private MediaPlayer kMV;
  private MediaPlayer kMW;
  public ConcurrentLinkedQueue<g.b> kMX;
  private int kMY;
  private int kMZ;
  private long kNa;
  private WeakReference<ArrayList<String>> kNb;
  private com.tencent.mm.g.b.a.bo kNc;
  private Map<String, by> kNd;
  
  static
  {
    AppMethodBeat.i(40966);
    kMT = com.tencent.mm.compatible.util.e.eQz + "wallet/voice/";
    kMU = com.tencent.mm.bv.b.ank("元");
    AppMethodBeat.o(40966);
  }
  
  public g()
  {
    AppMethodBeat.i(40947);
    this.isPlaying = false;
    this.kNd = new HashMap();
    this.__eventId = by.class.getName().hashCode();
    AppMethodBeat.o(40947);
  }
  
  private boolean Jp(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(40949);
        boolean bool;
        if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramString))
        {
          ab.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", new Object[] { paramString });
          AppMethodBeat.o(40949);
          bool = true;
          return bool;
        }
        List localList = bhB();
        Iterator localIterator = bhB().iterator();
        if (localIterator.hasNext())
        {
          if (((String)localIterator.next()).equals(paramString))
          {
            ab.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", new Object[] { paramString });
            AppMethodBeat.o(40949);
            bool = true;
          }
        }
        else
        {
          localList.add(paramString);
          if (localList.size() > 10)
          {
            ab.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
            int i = localList.size();
            paramString = localList.subList(i - 10, i);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJL, com.tencent.mm.sdk.platformtools.bo.d(paramString, ","));
            AppMethodBeat.o(40949);
            bool = false;
          }
          else
          {
            paramString = localList;
          }
        }
      }
      finally {}
    }
  }
  
  private static int Jq(String paramString)
  {
    AppMethodBeat.i(40958);
    int i = 0;
    if (paramString.equals("wx_f2f")) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(40958);
      return i;
      if (paramString.equals("wx_md")) {
        i = 2;
      }
    }
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4)
  {
    AppMethodBeat.i(40959);
    this.kNc = new com.tencent.mm.g.b.a.bo();
    this.kNc.cRG = paramInt1;
    this.kNc.gI(paramString1);
    if (!com.tencent.mm.sdk.platformtools.bo.hl(paramInt4, 0)) {
      this.kNc.cYA = paramInt4;
    }
    this.kNc.cYC = paramInt2;
    this.kNc.gJ(paramString2);
    this.kNc.cYF = paramInt3;
    if (com.tencent.mm.sdk.platformtools.bo.hl(paramInt1, 6)) {
      this.kNc.gK(paramString3);
    }
    this.kNc.ake();
    AppMethodBeat.o(40959);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(40956);
    Object localObject = new com.tencent.mm.vfs.b(kMT);
    if ((!((com.tencent.mm.vfs.b)localObject).exists()) && (!((com.tencent.mm.vfs.b)localObject).mkdirs()))
    {
      ab.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
      AppMethodBeat.o(40956);
      return;
    }
    localObject = kMT + UUID.randomUUID().toString() + ".tmp";
    ab.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { localObject });
    if (t((String)localObject, paramArrayOfByte))
    {
      paramArrayOfByte = new g.b(this, (byte)0);
      paramArrayOfByte.fileName = ((String)localObject);
      paramArrayOfByte.cve = paramInt2;
      paramArrayOfByte.kNj = paramInt1;
      paramArrayOfByte.cpq = paramString;
      paramArrayOfByte.kNk = paramInt3;
      paramArrayOfByte.kNl = paramBoolean;
      this.kMX.add(paramArrayOfByte);
      bhD();
      AppMethodBeat.o(40956);
      return;
    }
    ab.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
    AppMethodBeat.o(40956);
  }
  
  private void a(by paramby, boolean paramBoolean)
  {
    AppMethodBeat.i(141984);
    ab.i("MicroMsg.F2fRcvVoiceListener", "callbackImp() tradeNo:%s useOffline:%s", new Object[] { paramby.cpn.cpq, Boolean.valueOf(paramBoolean) });
    long l = paramby.cpn.cps;
    if (paramby.cpn.cpr.equals("wx_f2f"))
    {
      com.tencent.mm.plugin.collect.a.a.bhw();
      boolean bool = com.tencent.mm.plugin.collect.a.a.bhy();
      ab.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[] { Integer.valueOf(paramby.cpn.cpo), Boolean.valueOf(bool) });
      if (!Jp(paramby.cpn.cpq))
      {
        if (paramby.cpn.cpt == 0) {
          h.qsU.idkeyStat(699L, 8L, 1L, false);
        }
        while ((paramBoolean) && (com.tencent.mm.plugin.collect.model.voice.a.kOb) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramby.cpn.cpu)))
        {
          this.kNd.put(paramby.cpn.cpq, paramby);
          com.tencent.mm.plugin.collect.model.voice.a.bhJ().a(paramby);
          AppMethodBeat.o(141984);
          return;
          h.qsU.idkeyStat(699L, 9L, 1L, false);
        }
        paramby = new i(paramby.cpn.cpo, kMU, paramby.cpn.cpq, paramby.cpn.cpt, l);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(paramby, 0);
      }
      AppMethodBeat.o(141984);
      return;
    }
    if (paramby.cpn.cpr.equals("wx_md"))
    {
      if ((paramBoolean) && (com.tencent.mm.plugin.collect.model.voice.a.kOb) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramby.cpn.cpu)))
      {
        this.kNd.put(paramby.cpn.cpq, paramby);
        com.tencent.mm.plugin.collect.model.voice.a.bhJ().a(paramby);
        AppMethodBeat.o(141984);
        return;
      }
      paramby = new n(paramby.cpn.cpo, kMU, paramby.cpn.cpq);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(paramby, 0);
      AppMethodBeat.o(141984);
      return;
    }
    ab.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[] { paramby.cpn.cpr });
    AppMethodBeat.o(141984);
  }
  
  private void a(g.b paramb)
  {
    AppMethodBeat.i(40953);
    this.kMW = g.a.a(paramb.fileName, new g.6(this, paramb), new g.7(this, paramb));
    AppMethodBeat.o(40953);
  }
  
  private void ar(int paramInt, String paramString)
  {
    AppMethodBeat.i(40957);
    ab.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
    g.b localb = new g.b(this, (byte)0);
    localb.kNj = paramInt;
    localb.cpq = paramString;
    this.kMX.add(localb);
    bhD();
    AppMethodBeat.o(40957);
  }
  
  private List<String> bhB()
  {
    AppMethodBeat.i(40948);
    if ((this.kNb == null) || (this.kNb.get() == null))
    {
      ab.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
      this.kNb = new WeakReference(new ArrayList(com.tencent.mm.sdk.platformtools.bo.ih((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJL, ""), ",")));
    }
    List localList = (List)this.kNb.get();
    AppMethodBeat.o(40948);
    return localList;
  }
  
  public static boolean bhC()
  {
    AppMethodBeat.i(40951);
    ab.i("MicroMsg.F2fRcvVoiceListener", "delete files");
    boolean bool = com.tencent.mm.vfs.e.O(kMT, true);
    AppMethodBeat.o(40951);
    return bool;
  }
  
  private void bhD()
  {
    for (;;)
    {
      final g.b localb;
      try
      {
        AppMethodBeat.i(40952);
        if (System.currentTimeMillis() - this.kNa > 10000L)
        {
          ab.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[] { Long.valueOf(this.kNa) });
          this.isPlaying = false;
        }
        if (this.isPlaying)
        {
          ab.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
          AppMethodBeat.o(40952);
          return;
        }
        this.isPlaying = true;
        this.kNa = System.currentTimeMillis();
        localb = (g.b)this.kMX.poll();
        com.tencent.mm.compatible.b.g localg = com.tencent.mm.compatible.b.g.KC();
        i = localg.getStreamMaxVolume(3);
        this.kMY = localg.getStreamVolume(3);
        this.kMZ = Math.round(i * 0.5F);
        ab.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[] { Integer.valueOf(this.kMY), Integer.valueOf(i), Integer.valueOf(this.kMZ) });
        if (Build.VERSION.SDK_INT < 23) {
          break label622;
        }
        bool = localg.elW.isStreamMute(3);
        ab.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[] { Boolean.valueOf(bool) });
        if ((this.kMY == 0) || (bool))
        {
          ab.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
          if (localb != null)
          {
            i = localb.kNj;
            h localh = h.qsU;
            if (localb == null) {
              break label405;
            }
            String str1 = localb.cpq;
            localh.e(14404, new Object[] { Integer.valueOf(3), str1, Integer.valueOf(5), "", Integer.valueOf(i) });
          }
        }
        else
        {
          if ((this.kMY > 0) && (this.kMY < this.kMZ) && (!bool)) {
            localg.bW(3, this.kMZ);
          }
          if (localb == null) {
            break label608;
          }
          ab.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", new Object[] { Boolean.valueOf(localb.kNl) });
          if (!localb.kNl) {
            break label429;
          }
          if ((!this.isPlaying) || (this.kMW != null)) {
            break label412;
          }
          a(localb);
          AppMethodBeat.o(40952);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label405:
      String str2 = "";
      continue;
      label412:
      ab.i("MicroMsg.F2fRcvVoiceListener", "has played");
      AppMethodBeat.o(40952);
      continue;
      label429:
      int i = localb.kNj;
      if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(localb.fileName))
      {
        ab.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[] { Integer.valueOf(i) });
        this.kMV = g.a.a(ah.getContext(), new MediaPlayer.OnCompletionListener()new g.2
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(40934);
            ab.i("MicroMsg.F2fRcvVoiceListener", "start play money");
            if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null)) {
              g.a(g.this, localb);
            }
            for (;;)
            {
              g.d(g.this);
              AppMethodBeat.o(40934);
              return;
              ab.i("MicroMsg.F2fRcvVoiceListener", "has played");
            }
          }
        }, new g.2(this, localb));
        if (this.kMV != null)
        {
          i = this.kMV.getDuration();
          ab.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[] { Integer.valueOf(i) });
          al.p(new g.3(this), i + 1000);
          AppMethodBeat.o(40952);
        }
      }
      else
      {
        this.kMV = g.a.a(ah.getContext(), new g.4(this, localb), new g.5(this, localb));
        h.qsU.idkeyStat(699L, 2L, 1L, false);
      }
      AppMethodBeat.o(40952);
      continue;
      label608:
      this.isPlaying = false;
      AppMethodBeat.o(40952);
      continue;
      label622:
      boolean bool = false;
    }
  }
  
  private static int bhE()
  {
    AppMethodBeat.i(40960);
    if (com.tencent.mm.compatible.b.g.KC().KH())
    {
      AppMethodBeat.o(40960);
      return 1;
    }
    AppMethodBeat.o(40960);
    return 0;
  }
  
  private static boolean t(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40950);
    com.tencent.mm.kernel.g.RM();
    if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
    {
      ab.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
      AppMethodBeat.o(40950);
      return false;
    }
    if (com.tencent.mm.vfs.e.b(paramString, paramArrayOfByte, paramArrayOfByte.length) == 0)
    {
      AppMethodBeat.o(40950);
      return true;
    }
    AppMethodBeat.o(40950);
    return false;
  }
  
  private static int tO(int paramInt)
  {
    int i = 2;
    if (paramInt == 1) {
      i = 3;
    }
    return i;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40955);
    ab.i("MicroMsg.F2fRcvVoiceListener", "errorCode:%s outTradeNo:%s type:%s content:%s packId:%s overtimeFlag:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0) });
    int i = Jq(paramString2);
    paramString2 = (by)this.kNd.remove(paramString1);
    if (paramInt1 < 0)
    {
      if (paramString2 != null) {
        a(paramString2, false);
      }
      for (;;)
      {
        a(6, paramString1, i, paramString3, paramInt2, paramString4, 9);
        AppMethodBeat.o(40955);
        return;
        ar(i, paramString1);
      }
    }
    a(i, paramArrayOfByte, 1, paramString1, 0, true);
    a(5, paramString1, i, paramString3, paramInt2, paramString4, 0);
    AppMethodBeat.o(40955);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40954);
    ab.i("MicroMsg.F2fRcvVoiceListener", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramm.getType());
    if ((paramm instanceof i))
    {
      paramm = (i)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ab.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", new Object[] { Integer.valueOf(paramm.kNp.wIp), Integer.valueOf(paramm.kNp.cnK) });
        if (paramm.kNp.wIp == 1)
        {
          ab.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", new Object[] { Long.valueOf(paramm.cps) });
          h.qsU.e(14404, new Object[] { Integer.valueOf(3), paramm.cpq, Integer.valueOf(1), "", Integer.valueOf(1) });
          AppMethodBeat.o(40954);
          return;
        }
        if ((paramm.kNp.cnK == 0) && (paramm.kNp.wIo != null))
        {
          a(1, paramm.kNp.wIo.pW, paramm.kNp.wIn, paramm.cpq, paramm.kNp.wIp, false);
          h.qsU.e(15763, new Object[] { paramm.cpq, Integer.valueOf(1), Integer.valueOf(tO(paramm.cpt)), Long.valueOf(paramm.kNq), Integer.valueOf(bhE()) });
          AppMethodBeat.o(40954);
          return;
        }
        if (paramm.kNp.cnK <= 100)
        {
          paramInt1 = paramm.kNp.cnK;
          if (paramm.kNp.wIo == null) {}
          for (paramString = "null";; paramString = "not null")
          {
            ab.i("MicroMsg.F2fRcvVoiceListener", "play default sound only %s %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            ar(1, paramm.cpq);
            h.qsU.e(15763, new Object[] { paramm.cpq, Integer.valueOf(2), Integer.valueOf(tO(paramm.cpt)), Long.valueOf(paramm.kNq), Integer.valueOf(bhE()) });
            AppMethodBeat.o(40954);
            return;
          }
        }
        ab.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
        h.qsU.e(14404, new Object[] { Integer.valueOf(3), paramm.cpq, Integer.valueOf(2), "", Integer.valueOf(1) });
        h.qsU.e(15763, new Object[] { paramm.cpq, Integer.valueOf(2), Integer.valueOf(tO(paramm.cpt)), Long.valueOf(paramm.kNq), Integer.valueOf(bhE()) });
        AppMethodBeat.o(40954);
        return;
      }
      ab.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramm });
      ar(1, paramm.cpq);
      h.qsU.e(15763, new Object[] { paramm.cpq, Integer.valueOf(2), Integer.valueOf(tO(paramm.cpt)), Long.valueOf(paramm.kNq), Integer.valueOf(bhE()) });
      h.qsU.e(14404, new Object[] { Integer.valueOf(3), paramm.cpq, Integer.valueOf(3), "", Integer.valueOf(1) });
      AppMethodBeat.o(40954);
      return;
    }
    if ((paramm instanceof n))
    {
      paramString = (n)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.kNK.cnK == 0)
        {
          paramm = new com.tencent.mm.vfs.b(kMT);
          if ((!paramm.exists()) && (!paramm.mkdirs()))
          {
            ab.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            AppMethodBeat.o(40954);
            return;
          }
          paramm = kMT + UUID.randomUUID().toString() + ".tmp";
          ab.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramm });
          if (t(paramm, paramString.kNK.wIo.pW))
          {
            g.b localb = new g.b(this, (byte)0);
            localb.fileName = paramm;
            localb.cve = paramString.kNK.wIn;
            localb.kNj = 2;
            this.kMX.add(localb);
            bhD();
            AppMethodBeat.o(40954);
            return;
          }
          ab.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
          AppMethodBeat.o(40954);
          return;
        }
        h.qsU.e(14404, new Object[] { Integer.valueOf(3), paramString.cpq, Integer.valueOf(2), "", Integer.valueOf(2) });
        AppMethodBeat.o(40954);
        return;
      }
      ab.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
      h.qsU.e(14404, new Object[] { Integer.valueOf(3), paramString.cpq, Integer.valueOf(3), "", Integer.valueOf(2) });
    }
    AppMethodBeat.o(40954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g
 * JD-Core Version:    0.7.0.1
 */