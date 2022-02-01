package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t
  implements com.tencent.mm.ak.h
{
  private static Set<c> jvC;
  
  static
  {
    AppMethodBeat.i(148498);
    jvC = new HashSet();
    AppMethodBeat.o(148498);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148495);
    jvC.remove(paramc);
    AppMethodBeat.o(148495);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(148494);
    if (!jvC.contains(paramc)) {
      jvC.add(paramc);
    }
    AppMethodBeat.o(148494);
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(148496);
    de localde = parama.heO;
    if (localde == null)
    {
      Log.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(148496);
      return null;
    }
    Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localde.Brn);
    Object localObject2 = com.tencent.mm.platformtools.z.a(localde.KHl);
    if (((String)localObject2).equals(com.tencent.mm.model.z.aTY())) {}
    for (Object localObject1 = com.tencent.mm.platformtools.z.a(localde.KHm);; localObject1 = localObject2)
    {
      Object localObject3 = ((l)g.af(l.class)).eiy().aJ((String)localObject1, localde.Brn);
      if ((((eo)localObject3).field_msgId != 0L) && (((eo)localObject3).field_createTime + 604800000L < bp.C((String)localObject1, localde.CreateTime)))
      {
        Log.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localde.Brn) });
        bp.D((String)localObject1, localde.Brn);
        localObject3 = o.bib().AP(localde.Brn);
        if ((localObject3 != null) && (!Util.isNullOrNil(((r)localObject3).fileName))) {
          s.Rl(((r)localObject3).fileName);
        }
      }
      final r localr = new r();
      localr.dWq = ((String)localObject1);
      localr.createTime = localde.CreateTime;
      localr.dTS = localde.Brn;
      localr.fqK = localde.KHq;
      Log.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localde.KHq });
      localObject3 = com.tencent.mm.platformtools.z.a(localde.KHn);
      if (ab.Eq((String)localObject2))
      {
        localObject2 = bp.Kt((String)localObject3);
        Log.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = XmlParser.parseXml((String)localObject2, "msg", null);
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 227L, 1L, false);
          AppMethodBeat.o(148496);
          return null;
        }
        try
        {
          localr.jqP = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
          localr.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
          i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
          int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
          localr.jvt = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
          localr.jsh = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
          localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
          localr.jup = Integer.valueOf(Util.nullAs((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
          localr.jui = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
          localr.jvv = Util.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
          if (j == 1)
          {
            Log.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localde.Brn);
            parama = o.bib().AP(localr.dTS);
            if (parama != null) {
              s.Rj(parama.fileName);
            }
            AppMethodBeat.o(148496);
            return null;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 227L, 1L, false);
          Log.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
          Log.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
          AppMethodBeat.o(148496);
          return null;
        }
        if (i == 1)
        {
          Log.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localde.Brn);
          localr.iKP = localr.jqP;
        }
        localr.cSx = 284334;
        localObject3 = com.tencent.mm.platformtools.z.a(localde.KHp);
        if (localObject3 != null) {
          Log.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localde.Brn);
        }
        int i = s.a(localr, (byte[])localObject3, localde.oTW, (String)localObject2, localde.KHq, parama);
        if (i > 0)
        {
          Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localde.Brn), Integer.valueOf(localde.KHs) });
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 228L, 1L, false);
          localObject2 = ((l)g.af(l.class)).eiy().aJ(localr.dWq, localr.dTS);
          ((ca)localObject2).akm(0);
          localObject3 = jvC.iterator();
          for (;;)
          {
            parama = (h.a)localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148493);
                this.jun.ah(((l)g.af(l.class)).eiy().aJ(localr.dWq, localr.dTS));
                AppMethodBeat.o(148493);
              }
            });
          }
        }
        Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localde.Brn), Integer.valueOf(localde.KHs), Util.getStack() });
        parama = null;
        if (parama != null)
        {
          localObject2 = ((l)g.af(l.class)).aST().bjY((String)localObject1);
          if (localObject2 != null)
          {
            ((az)localObject2).oU(16777216);
            ((l)g.af(l.class)).aST().a((az)localObject2, (String)localObject1);
          }
        }
        if ((parama != null) && (parama.field_msgId > 0L)) {}
        for (boolean bool = true;; bool = false)
        {
          parama = new h.b(parama, bool);
          AppMethodBeat.o(148496);
          return parama;
        }
        localObject2 = localObject3;
      }
    }
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(148497);
    paramc = paramc.dTX;
    Log.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!ab.Jp(paramc.field_talker)) {
      s.Rl(paramc.field_imgPath);
    }
    AppMethodBeat.o(148497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */