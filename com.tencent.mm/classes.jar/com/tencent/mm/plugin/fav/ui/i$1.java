package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.mz.b;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.tj.b;
import com.tencent.mm.model.ad.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class i$1
  implements Runnable
{
  i$1(String paramString1, List paramList, Context paramContext, String paramString2, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(74117);
    Iterator localIterator1 = bo.P(this.mxQ.split(",")).iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = this.mxR.iterator();
      while (localIterator2.hasNext())
      {
        Object localObject3 = (com.tencent.mm.plugin.fav.a.g)localIterator2.next();
        if (localObject3 == null)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[] { Integer.valueOf(this.mxR.size()) });
        }
        else
        {
          h.qsU.e(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
          Object localObject1;
          Object localObject2;
          Object localObject6;
          Object localObject7;
          Object localObject5;
          label1204:
          int i;
          Object localObject4;
          switch (((com.tencent.mm.plugin.fav.a.g)localObject3).field_type)
          {
          case 3: 
          case 9: 
          case 12: 
          case 13: 
          default: 
            break;
          case 1: 
            com.tencent.mm.plugin.messenger.a.g.bPJ().K(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, t.oF(str));
            break;
          case 2: 
            localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wVc.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (aca)((Iterator)localObject1).next();
              com.tencent.mm.plugin.messenger.a.g.bPJ().a(this.val$context, str, com.tencent.mm.plugin.fav.a.b.b((aca)localObject2), 0, "", "");
            }
          case 16: 
            i.a(this.val$context, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
            break;
          case 4: 
            i.b(this.val$context, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
            break;
          case 6: 
            localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wUd;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("<msg>");
            ((StringBuilder)localObject2).append("<location ");
            ((StringBuilder)localObject2).append("x=\"").append(((ach)localObject1).lat).append("\" ");
            ((StringBuilder)localObject2).append("y=\"").append(((ach)localObject1).lng).append("\" ");
            ((StringBuilder)localObject2).append("scale=\"").append(((ach)localObject1).cyX).append("\" ");
            ((StringBuilder)localObject2).append("label=\"").append(bo.bf(((ach)localObject1).label, "")).append("\" ");
            ((StringBuilder)localObject2).append("maptype=\"0\" ");
            ((StringBuilder)localObject2).append("poiname=\"").append(bo.bf(((ach)localObject1).cDl, "")).append("\" ");
            ((StringBuilder)localObject2).append("/>");
            ((StringBuilder)localObject2).append("</msg>");
            com.tencent.mm.plugin.messenger.a.g.bPJ().K(str, ((StringBuilder)localObject2).toString(), 48);
            break;
          case 8: 
            i.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
            break;
          case 7: 
            localObject6 = this.val$context;
            localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
            localObject1 = new WXMusicObject();
            ((WXMusicObject)localObject1).musicUrl = ((aca)localObject7).wSJ;
            ((WXMusicObject)localObject1).musicDataUrl = ((aca)localObject7).wSL;
            ((WXMusicObject)localObject1).musicLowBandUrl = ((aca)localObject7).wSN;
            ((WXMusicObject)localObject1).musicLowBandDataUrl = ((aca)localObject7).wSN;
            localObject5 = new WXMediaMessage();
            ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
            ((WXMediaMessage)localObject5).title = ((aca)localObject7).title;
            ((WXMediaMessage)localObject5).description = ((aca)localObject7).desc;
            localObject2 = bo.readFromFile(com.tencent.mm.plugin.fav.a.b.c((aca)localObject7));
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = bo.bf(((aca)localObject7).cpH, "");
              localObject1 = bo.readFromFile(com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(((String)localObject1).getBytes()));
            }
            ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
            localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wVa.appId;
            localObject2 = ad.a.flG.t((Context)localObject6, (String)localObject1);
            ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.fav.a.ab.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
            break;
          case 5: 
            if (localObject3 == null)
            {
              com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
            }
            else
            {
              localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
              localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wUf;
              Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wVa;
              localObject6 = new j.b();
              if (localObject7 != null)
              {
                ((j.b)localObject6).title = ((adf)localObject7).title;
                localObject2 = ((adf)localObject7).thumbUrl;
                localObject1 = localObject2;
                if (bo.isNullOrNil((String)localObject2)) {
                  localObject1 = bo.bf(((aca)localObject5).cpH, "");
                }
                ((j.b)localObject6).thumburl = ((String)localObject1);
              }
              if (bo.isNullOrNil(((j.b)localObject6).title)) {
                ((j.b)localObject6).title = ((aca)localObject5).title;
              }
              if (localObject7 != null) {
                ((j.b)localObject6).description = ((adf)localObject7).desc;
              }
              if (bo.isNullOrNil(((j.b)localObject6).description)) {
                ((j.b)localObject6).description = ((aca)localObject5).desc;
              }
              if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wUf != null) {
                ((j.b)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wUf.wVF;
              }
              if ((localObject8 != null) && (bo.isNullOrNil(((j.b)localObject6).url))) {
                ((j.b)localObject6).url = ((acw)localObject8).link;
              }
              if (!bo.isNullOrNil(((aca)localObject5).canvasPageXml)) {
                ((j.b)localObject6).canvasPageXml = ((aca)localObject5).canvasPageXml;
              }
              ((j.b)localObject6).action = "view";
              ((j.b)localObject6).type = 5;
              ((j.b)localObject6).cGU = ((aca)localObject5).cGU;
              localObject2 = bo.readFromFile(com.tencent.mm.plugin.fav.a.b.c((aca)localObject5));
              localObject1 = localObject2;
              if (localObject2 == null) {
                if (localObject7 != null) {
                  break label1204;
                }
              }
              for (localObject1 = null;; localObject1 = ((adf)localObject7).thumbUrl)
              {
                localObject2 = localObject1;
                if (bo.isNullOrNil((String)localObject1)) {
                  localObject2 = bo.bf(((aca)localObject5).cpH, "");
                }
                localObject1 = bo.readFromFile(com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(((String)localObject2).getBytes()));
                localObject2 = "fav_" + r.Zn() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                localObject7 = v.oQ((String)localObject2);
                localObject8 = v.aae().z((String)localObject7, true);
                ((v.b)localObject8).i("prePublishId", localObject2);
                ((v.b)localObject8).i("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                ((v.b)localObject8).i("sendAppMsgScene", Integer.valueOf(1));
                ((v.b)localObject8).i("adExtStr", ((aca)localObject5).cGU);
                com.tencent.mm.plugin.messenger.a.g.bPJ().a(str, (byte[])localObject1, j.b.a((j.b)localObject6, null, null), (String)localObject7);
                break;
              }
            }
            break;
          case 10: 
            localObject1 = this.val$context;
            localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wUh;
            localObject3 = new mz();
            ((mz)localObject3).cDc.opType = 0;
            ((mz)localObject3).cDc.cDe = ((acp)localObject2).info;
            ((mz)localObject3).cDc.context = ((Context)localObject1);
            a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
            if (((mz)localObject3).cDd.cpz)
            {
              localObject2 = bo.readFromFile(com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(bo.bf(((acp)localObject2).thumbUrl, "").getBytes()));
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = bo.readFromFile(((mz)localObject3).cDd.thumbPath);
              }
              com.tencent.mm.plugin.messenger.a.g.bPJ().a(str, (byte[])localObject1, ((mz)localObject3).cDd.cDf, null);
            }
            break;
          case 15: 
            localObject1 = this.val$context;
            localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wUj;
            localObject3 = new tj();
            ((tj)localObject3).cJO.opType = 0;
            ((tj)localObject3).cJO.cJQ = ((acz)localObject2).info;
            ((tj)localObject3).cJO.context = ((Context)localObject1);
            a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((tj)localObject3).cJP.cpz), ((acz)localObject2).thumbUrl });
            if (((tj)localObject3).cJP.cpz)
            {
              localObject2 = bo.readFromFile(com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(bo.bf(((acz)localObject2).thumbUrl, "").getBytes()));
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = bo.readFromFile(((tj)localObject3).cJP.thumbPath);
              }
              com.tencent.mm.plugin.messenger.a.g.bPJ().a(str, (byte[])localObject1, ((tj)localObject3).cJP.cDf, null);
            }
            break;
          case 11: 
            localObject1 = this.val$context;
            localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.wUh;
            localObject3 = new mz();
            ((mz)localObject3).cDc.opType = 1;
            ((mz)localObject3).cDc.cDe = ((acp)localObject2).info;
            ((mz)localObject3).cDc.context = ((Context)localObject1);
            a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
            if (((mz)localObject3).cDd.cpz)
            {
              localObject2 = bo.readFromFile(com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(bo.bf(((acp)localObject2).thumbUrl, "").getBytes()));
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = bo.readFromFile(((mz)localObject3).cDd.thumbPath);
              }
              com.tencent.mm.plugin.messenger.a.g.bPJ().a(str, (byte[])localObject1, ((mz)localObject3).cDd.cDf, null);
            }
            break;
          case 14: 
          case 18: 
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
            localObject1 = i.a.a(this.val$context, (com.tencent.mm.plugin.fav.a.g)localObject3);
            localObject2 = new acq();
            try
            {
              com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavSendLogic", "do clone fav proto item");
              ((acq)localObject2).parseFrom(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
              localObject3 = ((acq)localObject2).wVc;
              localObject5 = ((LinkedList)localObject3).iterator();
              i = 0;
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (aca)((Iterator)localObject5).next();
                if ((((aca)localObject6).wTw != null) && (((aca)localObject6).wTw.wUs != null) && (((aca)localObject6).wTw.wUs.type == 3))
                {
                  ((aca)localObject6).MI(1);
                  ((aca)localObject6).anr(this.val$context.getString(2131297016));
                  ((LinkedList)localObject3).set(i, localObject6);
                  ((acq)localObject2).aJ((LinkedList)localObject3);
                }
                i += 1;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.FavSendLogic", localException, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[] { localException.getMessage() });
              }
              localObject4 = new oa();
              ((oa)localObject4).cEz.type = 2;
              ((oa)localObject4).cEz.toUser = str;
              ((oa)localObject4).cEz.cEC = ((acq)localObject2);
              ((oa)localObject4).cEz.title = ((i.a)localObject1).title;
              ((oa)localObject4).cEz.desc = ((i.a)localObject1).desc;
              ((oa)localObject4).cEz.thumbPath = ((i.a)localObject1).thumbPath;
              ((oa)localObject4).cEz.cEH = ((i.a)localObject1).mxW;
              a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
            }
            break;
          case 17: 
            localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
            localObject2 = bi.a.asj((String)localObject1);
            localObject4 = com.tencent.mm.plugin.messenger.a.g.bPJ();
            if (ad.arf(((bi.a)localObject2).tac)) {}
            for (i = 66;; i = 42)
            {
              ((d)localObject4).K(str, (String)localObject1, i);
              break;
            }
          }
        }
      }
      if (!bo.isNullOrNil(this.mxS)) {
        com.tencent.mm.plugin.messenger.a.g.bPJ().K(str, this.mxS, t.oF(str));
      }
    }
    al.d(this.bZt);
    AppMethodBeat.o(74117);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(74118);
    String str = super.toString() + "|sendFavMsg";
    AppMethodBeat.o(74118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.1
 * JD-Core Version:    0.7.0.1
 */