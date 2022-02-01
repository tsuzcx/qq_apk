package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.fzd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t
  implements g
{
  private static Set<c> peR;
  
  static
  {
    AppMethodBeat.i(148498);
    peR = new HashSet();
    AppMethodBeat.o(148498);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148495);
    peR.remove(paramc);
    AppMethodBeat.o(148495);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(148494);
    if (!peR.contains(paramc)) {
      peR.add(paramc);
    }
    AppMethodBeat.o(148494);
  }
  
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(148496);
    dl localdl = parama.mpN;
    if (localdl == null)
    {
      Log.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(148496);
      return null;
    }
    Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localdl.Njv);
    Object localObject2 = com.tencent.mm.platformtools.w.a(localdl.YFE);
    if (((String)localObject2).equals(z.bAM())) {}
    for (Object localObject1 = com.tencent.mm.platformtools.w.a(localdl.YFF);; localObject1 = localObject2)
    {
      Object localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU((String)localObject1, localdl.Njv);
      if ((localObject3 != null) && (((fi)localObject3).field_msgId != 0L) && (((cc)localObject3).getCreateTime() + 604800000L < br.D((String)localObject1, localdl.CreateTime)))
      {
        Log.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localdl.Njv) });
        br.E((String)localObject1, localdl.Njv);
        localObject3 = o.bPf().ji(localdl.Njv);
        if ((localObject3 != null) && (!Util.isNullOrNil(((r)localObject3).fileName))) {
          s.QN(((r)localObject3).fileName);
        }
      }
      final r localr = new r();
      localr.hVQ = ((String)localObject1);
      localr.createTime = localdl.CreateTime;
      localr.hTh = localdl.Njv;
      localr.jUr = localdl.YFJ;
      Log.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localdl.YFJ });
      localObject3 = com.tencent.mm.platformtools.w.a(localdl.YFG);
      if (au.bwE((String)localObject2))
      {
        localObject2 = br.JK((String)localObject3);
        Log.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = XmlParser.parseXml((String)localObject2, "msg", null);
        if (localObject3 != null) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 227L, 1L, false);
        AppMethodBeat.o(148496);
        return null;
        Log.i("MicroMsg.VoiceMsgExtension", "normal contact voicemsg, content=".concat(String.valueOf(localObject3)));
        localObject2 = localObject3;
      }
      try
      {
        localr.oZm = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
        localr.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
        i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
        int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
        localr.peH = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
        localr.paV = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
        localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
        localr.pdq = Integer.valueOf(Util.nullAs((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
        localr.pdj = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
        localr.peJ = Util.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
        fzd localfzd = new fzd();
        localfzd.mOI = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceurl"));
        localfzd.aesKey = ((String)((Map)localObject3).get(".msg.voicemsg.$aeskey"));
        localr.peM = localfzd;
        if (j == 1)
        {
          Log.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localdl.Njv);
          parama = o.bPf().ji(localr.hTh);
          if (parama != null) {
            s.QL(parama.fileName);
          }
          AppMethodBeat.o(148496);
          return null;
        }
      }
      catch (Exception parama)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 227L, 1L, false);
        Log.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
        Log.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
        AppMethodBeat.o(148496);
        return null;
      }
      if (i == 1)
      {
        Log.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localdl.Njv);
        localr.osy = localr.oZm;
      }
      localr.eQp = 2381486;
      localObject3 = com.tencent.mm.platformtools.w.a(localdl.YFI);
      if (localObject3 != null) {
        Log.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localdl.Njv);
      }
      int i = s.a(localr, (byte[])localObject3, localdl.vhk, (String)localObject2, localdl.YFJ, parama);
      if (i > 0)
      {
        Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localdl.Njv), Integer.valueOf(localdl.YFL) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 228L, 1L, false);
        localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(localr.hVQ, localr.hTh);
        ((cc)localObject2).ayZ(0);
        localObject3 = peR.iterator();
        for (;;)
        {
          parama = (g.a)localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(148493);
              this.pdo.av(((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(localr.hVQ, localr.hTh));
              AppMethodBeat.o(148493);
            }
          });
        }
      }
      Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localdl.Njv), Integer.valueOf(localdl.YFL), Util.getStack() });
      parama = null;
      if (parama != null)
      {
        localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM((String)localObject1);
        if (localObject2 != null)
        {
          ((bb)localObject2).rw(16777216);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c((bb)localObject2, (String)localObject1);
        }
      }
      if ((parama != null) && (parama.field_msgId > 0L)) {}
      for (boolean bool = true;; bool = false)
      {
        parama = new g.b(parama, bool);
        AppMethodBeat.o(148496);
        return parama;
      }
    }
  }
  
  public final void b(g.c paramc)
  {
    AppMethodBeat.i(148497);
    paramc = paramc.hTm;
    Log.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!au.bwm(paramc.field_talker)) {
      s.QN(paramc.field_imgPath);
    }
    AppMethodBeat.o(148497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */