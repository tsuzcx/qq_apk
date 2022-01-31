package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.mg;
import com.tencent.mm.h.a.mg.b;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.rs;
import com.tencent.mm.h.a.rs.b;
import com.tencent.mm.model.ac.a;
import com.tencent.mm.model.ac.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    Iterator localIterator1 = bk.G(this.kdg.split(",")).iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = this.kdh.iterator();
      while (localIterator2.hasNext())
      {
        Object localObject3 = (com.tencent.mm.plugin.fav.a.g)localIterator2.next();
        if (localObject3 == null)
        {
          y.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[] { Integer.valueOf(this.kdh.size()) });
        }
        else
        {
          h.nFQ.f(10925, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
          Object localObject1;
          Object localObject2;
          Object localObject6;
          Object localObject7;
          Object localObject5;
          label1200:
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
            com.tencent.mm.plugin.messenger.a.g.bhI().D(str, ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.desc, s.hW(str));
            break;
          case 2: 
            localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sXc.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (xv)((Iterator)localObject1).next();
              com.tencent.mm.plugin.messenger.a.g.bhI().a(this.val$context, str, com.tencent.mm.plugin.fav.a.b.b((xv)localObject2), 0, "", "");
            }
          case 16: 
            i.a(this.val$context, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
            break;
          case 4: 
            i.b(this.val$context, str, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
            break;
          case 6: 
            localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sWf;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("<msg>");
            ((StringBuilder)localObject2).append("<location ");
            ((StringBuilder)localObject2).append("x=\"").append(((yc)localObject1).lat).append("\" ");
            ((StringBuilder)localObject2).append("y=\"").append(((yc)localObject1).lng).append("\" ");
            ((StringBuilder)localObject2).append("scale=\"").append(((yc)localObject1).bRv).append("\" ");
            ((StringBuilder)localObject2).append("label=\"").append(bk.aM(((yc)localObject1).label, "")).append("\" ");
            ((StringBuilder)localObject2).append("maptype=\"0\" ");
            ((StringBuilder)localObject2).append("poiname=\"").append(bk.aM(((yc)localObject1).bVA, "")).append("\" ");
            ((StringBuilder)localObject2).append("/>");
            ((StringBuilder)localObject2).append("</msg>");
            com.tencent.mm.plugin.messenger.a.g.bhI().D(str, ((StringBuilder)localObject2).toString(), 48);
            break;
          case 8: 
            i.a(str, (com.tencent.mm.plugin.fav.a.g)localObject3, com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3));
            break;
          case 7: 
            localObject6 = this.val$context;
            localObject7 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
            localObject1 = new WXMusicObject();
            ((WXMusicObject)localObject1).musicUrl = ((xv)localObject7).sUN;
            ((WXMusicObject)localObject1).musicDataUrl = ((xv)localObject7).sUP;
            ((WXMusicObject)localObject1).musicLowBandUrl = ((xv)localObject7).sUR;
            ((WXMusicObject)localObject1).musicLowBandDataUrl = ((xv)localObject7).sUR;
            localObject5 = new WXMediaMessage();
            ((WXMediaMessage)localObject5).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
            ((WXMediaMessage)localObject5).title = ((xv)localObject7).title;
            ((WXMediaMessage)localObject5).description = ((xv)localObject7).desc;
            localObject2 = bk.readFromFile(com.tencent.mm.plugin.fav.a.b.c((xv)localObject7));
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = bk.aM(((xv)localObject7).bIm, "");
              localObject1 = bk.readFromFile(com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(((String)localObject1).getBytes()));
            }
            ((WXMediaMessage)localObject5).thumbData = ((byte[])localObject1);
            localObject1 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sXa.appId;
            localObject2 = ac.a.dVw.n((Context)localObject6, (String)localObject1);
            ((ab)com.tencent.mm.kernel.g.r(ab.class)).a((WXMediaMessage)localObject5, (String)localObject1, (String)localObject2, str);
            break;
          case 5: 
            if (localObject3 == null)
            {
              y.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
            }
            else
            {
              localObject5 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject3);
              localObject7 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sWh;
              Object localObject8 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sXa;
              localObject6 = new g.a();
              if (localObject7 != null)
              {
                ((g.a)localObject6).title = ((yy)localObject7).title;
                localObject2 = ((yy)localObject7).thumbUrl;
                localObject1 = localObject2;
                if (bk.bl((String)localObject2)) {
                  localObject1 = bk.aM(((xv)localObject5).bIm, "");
                }
                ((g.a)localObject6).thumburl = ((String)localObject1);
              }
              if (bk.bl(((g.a)localObject6).title)) {
                ((g.a)localObject6).title = ((xv)localObject5).title;
              }
              if (localObject7 != null) {
                ((g.a)localObject6).description = ((yy)localObject7).desc;
              }
              if (bk.bl(((g.a)localObject6).description)) {
                ((g.a)localObject6).description = ((xv)localObject5).desc;
              }
              if (((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sWh != null) {
                ((g.a)localObject6).url = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sWh.sXG;
              }
              if ((localObject8 != null) && (bk.bl(((g.a)localObject6).url))) {
                ((g.a)localObject6).url = ((yp)localObject8).eAl;
              }
              if (!bk.bl(((xv)localObject5).canvasPageXml)) {
                ((g.a)localObject6).canvasPageXml = ((xv)localObject5).canvasPageXml;
              }
              ((g.a)localObject6).action = "view";
              ((g.a)localObject6).type = 5;
              ((g.a)localObject6).bYN = ((xv)localObject5).bYN;
              localObject2 = bk.readFromFile(com.tencent.mm.plugin.fav.a.b.c((xv)localObject5));
              localObject1 = localObject2;
              if (localObject2 == null) {
                if (localObject7 != null) {
                  break label1200;
                }
              }
              for (localObject1 = null;; localObject1 = ((yy)localObject7).thumbUrl)
              {
                localObject2 = localObject1;
                if (bk.bl((String)localObject1)) {
                  localObject2 = bk.aM(((xv)localObject5).bIm, "");
                }
                localObject1 = bk.readFromFile(com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(((String)localObject2).getBytes()));
                localObject2 = "fav_" + q.Gj() + "_" + ((com.tencent.mm.plugin.fav.a.g)localObject3).field_id;
                localObject7 = u.ij((String)localObject2);
                localObject8 = u.Hc().v((String)localObject7, true);
                ((u.b)localObject8).h("prePublishId", localObject2);
                ((u.b)localObject8).h("preUsername", ((com.tencent.mm.plugin.fav.a.g)localObject3).field_fromUser);
                ((u.b)localObject8).h("sendAppMsgScene", Integer.valueOf(1));
                ((u.b)localObject8).h("adExtStr", ((xv)localObject5).bYN);
                com.tencent.mm.plugin.messenger.a.g.bhI().a(str, (byte[])localObject1, g.a.a((g.a)localObject6, null, null), (String)localObject7);
                break;
              }
            }
            break;
          case 10: 
            localObject1 = this.val$context;
            localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sWj;
            localObject3 = new mg();
            ((mg)localObject3).bVu.opType = 0;
            ((mg)localObject3).bVu.bVw = ((yi)localObject2).info;
            ((mg)localObject3).bVu.context = ((Context)localObject1);
            a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
            if (((mg)localObject3).bVv.bIe)
            {
              localObject2 = bk.readFromFile(com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(bk.aM(((yi)localObject2).thumbUrl, "").getBytes()));
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = bk.readFromFile(((mg)localObject3).bVv.thumbPath);
              }
              com.tencent.mm.plugin.messenger.a.g.bhI().a(str, (byte[])localObject1, ((mg)localObject3).bVv.bVx, null);
            }
            break;
          case 15: 
            localObject1 = this.val$context;
            localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sWl;
            localObject3 = new rs();
            ((rs)localObject3).cbl.opType = 0;
            ((rs)localObject3).cbl.cbn = ((ys)localObject2).info;
            ((rs)localObject3).cbl.context = ((Context)localObject1);
            a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
            y.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[] { Boolean.valueOf(((rs)localObject3).cbm.bIe), ((ys)localObject2).thumbUrl });
            if (((rs)localObject3).cbm.bIe)
            {
              localObject2 = bk.readFromFile(com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(bk.aM(((ys)localObject2).thumbUrl, "").getBytes()));
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = bk.readFromFile(((rs)localObject3).cbm.thumbPath);
              }
              com.tencent.mm.plugin.messenger.a.g.bhI().a(str, (byte[])localObject1, ((rs)localObject3).cbm.bVx, null);
            }
            break;
          case 11: 
            localObject1 = this.val$context;
            localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.sWj;
            localObject3 = new mg();
            ((mg)localObject3).bVu.opType = 1;
            ((mg)localObject3).bVu.bVw = ((yi)localObject2).info;
            ((mg)localObject3).bVu.context = ((Context)localObject1);
            a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
            if (((mg)localObject3).bVv.bIe)
            {
              localObject2 = bk.readFromFile(com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(bk.aM(((yi)localObject2).thumbUrl, "").getBytes()));
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = bk.readFromFile(((mg)localObject3).bVv.thumbPath);
              }
              com.tencent.mm.plugin.messenger.a.g.bhI().a(str, (byte[])localObject1, ((mg)localObject3).bVv.bVx, null);
            }
            break;
          case 14: 
          case 18: 
            y.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject3).field_id) });
            localObject1 = i.a.a(this.val$context, (com.tencent.mm.plugin.fav.a.g)localObject3);
            localObject2 = new yj();
            try
            {
              y.d("MicroMsg.FavSendLogic", "do clone fav proto item");
              ((yj)localObject2).aH(((com.tencent.mm.plugin.fav.a.g)localObject3).field_favProto.toByteArray());
              localObject3 = ((yj)localObject2).sXc;
              localObject5 = ((LinkedList)localObject3).iterator();
              i = 0;
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (xv)((Iterator)localObject5).next();
                if ((((xv)localObject6).sVA != null) && (((xv)localObject6).sVA.sWu != null) && (((xv)localObject6).sVA.sWu.type == 3))
                {
                  ((xv)localObject6).EH(1);
                  ((xv)localObject6).Xv(this.val$context.getString(n.i.app_not_show));
                  ((LinkedList)localObject3).set(i, localObject6);
                  ((yj)localObject2).az((LinkedList)localObject3);
                }
                i += 1;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                y.printErrStackTrace("MicroMsg.FavSendLogic", localException, "", new Object[0]);
                y.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[] { localException.getMessage() });
              }
              localObject4 = new nd();
              ((nd)localObject4).bWJ.type = 2;
              ((nd)localObject4).bWJ.toUser = str;
              ((nd)localObject4).bWJ.bWM = ((yj)localObject2);
              ((nd)localObject4).bWJ.title = ((i.a)localObject1).title;
              ((nd)localObject4).bWJ.desc = ((i.a)localObject1).desc;
              ((nd)localObject4).bWJ.thumbPath = ((i.a)localObject1).thumbPath;
              ((nd)localObject4).bWJ.bWR = ((i.a)localObject1).kdm;
              a.udP.m((com.tencent.mm.sdk.b.b)localObject4);
            }
            break;
          case 17: 
            localObject1 = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject4).desc;
            localObject2 = bi.a.abZ((String)localObject1);
            localObject4 = com.tencent.mm.plugin.messenger.a.g.bhI();
            if (ad.aaU(((bi.a)localObject2).pyp)) {}
            for (i = 66;; i = 42)
            {
              ((d)localObject4).D(str, (String)localObject1, i);
              break;
            }
          }
        }
      }
      if (!bk.bl(this.kdi)) {
        com.tencent.mm.plugin.messenger.a.g.bhI().D(str, this.kdi, s.hW(str));
      }
    }
    ai.d(this.bxs);
  }
  
  public final String toString()
  {
    return super.toString() + "|sendFavMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.1
 * JD-Core Version:    0.7.0.1
 */