package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.a.rl;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements com.tencent.mm.ah.f
{
  com.tencent.mm.as.a.c.c iXU = new d.3(this);
  public HashMap<Long, String> iXW = new HashMap();
  private boolean iXX = false;
  List<d.b> iXY = new LinkedList();
  private rl iXZ;
  public d.a iYa;
  List iYb = Collections.synchronizedList(new ArrayList());
  
  public d()
  {
    com.tencent.mm.kernel.g.DO().dJT.a(175, this);
  }
  
  static void a(as paramas)
  {
    if (paramas == null) {
      return;
    }
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(new g.c(paramas.talker, "update", null));
  }
  
  public final void AQ(String paramString)
  {
    com.tencent.mm.kernel.g.DS().O(new d.1(this, paramString));
  }
  
  public final void a(as paramas, e.a parama, boolean paramBoolean)
  {
    if (paramas == null) {
      y.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
    }
    for (;;)
    {
      return;
      if ((parama != null) && (parama.dBs != null) && (parama.dBs.ndp == paramas.bXr))
      {
        paramas.czq = com.tencent.mm.model.bd.c(parama);
        paramas.eKX = parama.dBs.svM;
        paramas.createTime = parama.dBs.mPL;
      }
      EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().uBb.acC(paramas.bIW);
      int i;
      if (localEmojiInfo != null)
      {
        int j = 0;
        i = j;
        if (!bk.bl(paramas.bJd))
        {
          i = j;
          if (!paramas.bJd.equals(localEmojiInfo.field_groupId))
          {
            localEmojiInfo.field_groupId = paramas.bJd;
            i = 1;
          }
        }
        j = i;
        if (!bk.bl(paramas.uAW))
        {
          j = i;
          if (!paramas.uAW.equals(localEmojiInfo.field_designerID))
          {
            localEmojiInfo.field_designerID = paramas.uAW;
            j = 1;
          }
        }
        i = j;
        if (!bk.bl(paramas.thumbUrl))
        {
          i = j;
          if (!paramas.thumbUrl.equals(localEmojiInfo.field_thumbUrl))
          {
            localEmojiInfo.field_thumbUrl = paramas.thumbUrl;
            i = 1;
          }
        }
        j = i;
        if (!bk.bl(paramas.bNn))
        {
          j = i;
          if (!paramas.bNn.equals(localEmojiInfo.field_encrypturl))
          {
            localEmojiInfo.field_encrypturl = paramas.bNn;
            j = 1;
          }
        }
        i = j;
        if (!bk.bl(paramas.aeskey))
        {
          i = j;
          if (!paramas.aeskey.equals(localEmojiInfo.field_aeskey))
          {
            localEmojiInfo.field_aeskey = paramas.aeskey;
            i = 1;
          }
        }
        j = i;
        if (!bk.bl(paramas.lnw))
        {
          j = i;
          if (!paramas.lnw.equals(localEmojiInfo.field_cdnUrl))
          {
            localEmojiInfo.field_cdnUrl = paramas.lnw;
            j = 1;
          }
        }
        i = j;
        if (!bk.bl(paramas.dQB))
        {
          i = j;
          if (!paramas.dQB.equals(localEmojiInfo.field_tpurl))
          {
            localEmojiInfo.field_tpurl = paramas.dQB;
            i = 1;
          }
        }
        j = i;
        if (!bk.bl(paramas.dQH))
        {
          j = i;
          if (!paramas.dQH.equals(localEmojiInfo.field_tpauthkey))
          {
            localEmojiInfo.field_tpauthkey = paramas.dQH;
            j = 1;
          }
        }
        i = j;
        if (paramas.width > 0)
        {
          i = j;
          if (paramas.width != localEmojiInfo.field_width)
          {
            localEmojiInfo.field_width = paramas.width;
            i = 1;
          }
        }
        j = i;
        if (paramas.height > 0)
        {
          j = i;
          if (paramas.height != localEmojiInfo.field_height)
          {
            localEmojiInfo.field_height = paramas.height;
            j = 1;
          }
        }
        i = j;
        if (!bk.bl(paramas.uAX))
        {
          i = j;
          if (!paramas.uAX.equals(localEmojiInfo.field_externUrl))
          {
            localEmojiInfo.field_externUrl = paramas.uAX;
            i = 1;
          }
        }
        j = i;
        if (!bk.bl(paramas.uAY))
        {
          j = i;
          if (!paramas.uAY.equals(localEmojiInfo.field_externMd5))
          {
            localEmojiInfo.field_externMd5 = paramas.uAY;
            j = 1;
          }
        }
        i = j;
        if (!bk.bl(paramas.uBa))
        {
          i = j;
          if (!paramas.uBa.equalsIgnoreCase(localEmojiInfo.field_activityid))
          {
            localEmojiInfo.field_activityid = paramas.uBa;
            i = 1;
          }
        }
        j = i;
        if (localEmojiInfo.field_state == EmojiInfo.uDh)
        {
          j = i;
          if (com.tencent.mm.vfs.e.aeQ(localEmojiInfo.cwL()) <= 0L)
          {
            y.i("MicroMsg.emoji.EmojiService", "emoji %s complete but file not exist", new Object[] { localEmojiInfo.Wv() });
            localEmojiInfo.field_state = EmojiInfo.uDj;
            j = 1;
          }
        }
        if (!bk.bl(paramas.iYZ))
        {
          localEmojiInfo.field_attachedText = paramas.iYZ;
          j = 1;
        }
        if (j != 0)
        {
          i.getEmojiStorageMgr().uBb.q(localEmojiInfo);
          y.i("MicroMsg.emoji.EmojiService", "update designer info. designer:%s thumbUrl:%s", new Object[] { localEmojiInfo.field_designerID, localEmojiInfo.field_thumbUrl });
        }
      }
      long l;
      for (;;)
      {
        l = 0L;
        if (paramas.uAZ)
        {
          localEmojiInfo.cwz();
          if (paramas.bXr == 0L) {
            break label1177;
          }
          localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O(paramas.talker, paramas.bXr);
          if (((cs)localObject).field_msgSvrId != paramas.bXr) {
            break label1177;
          }
          l = ((cs)localObject).field_msgId;
        }
        y.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.Wv(), Boolean.valueOf(localEmojiInfo.cwz()), Boolean.valueOf(paramBoolean) });
        if (localEmojiInfo.cwz()) {
          break;
        }
        if (!paramBoolean) {
          break label2276;
        }
        if ((this.iYb == null) || (!this.iYb.contains(paramas.bIW))) {
          break label1677;
        }
        y.i("MicroMsg.emoji.EmojiService", "emoji md5:%s is downloading.", new Object[] { paramas.bIW });
        return;
        y.d("MicroMsg.emoji.EmojiService", "jacks prepare Emoji check groupId&md5 handle remote server old emoji version");
        localEmojiInfo = new EmojiInfo();
        localEmojiInfo.field_md5 = paramas.bIW;
        localEmojiInfo.field_svrid = paramas.id;
        localEmojiInfo.field_catalog = EmojiInfo.uCT;
        localEmojiInfo.field_type = paramas.uAR;
        localEmojiInfo.field_size = paramas.uAS;
        localEmojiInfo.field_groupId = paramas.bJd;
        localEmojiInfo.field_designerID = paramas.uAW;
        localEmojiInfo.field_thumbUrl = paramas.thumbUrl;
        localEmojiInfo.field_cdnUrl = paramas.lnw;
        localEmojiInfo.field_temp = 1;
        localEmojiInfo.field_encrypturl = paramas.bNn;
        localEmojiInfo.field_aeskey = paramas.aeskey;
        localEmojiInfo.field_designerID = paramas.uAW;
        localEmojiInfo.field_thumbUrl = paramas.thumbUrl;
        localEmojiInfo.field_state = EmojiInfo.uDj;
        localEmojiInfo.field_width = paramas.width;
        localEmojiInfo.field_height = paramas.height;
        localEmojiInfo.field_externUrl = paramas.uAX;
        localEmojiInfo.field_externMd5 = paramas.uAY;
        localEmojiInfo.field_activityid = paramas.uBa;
        localEmojiInfo.field_attachedText = paramas.iYZ;
        i.getEmojiStorageMgr().uBb.o(localEmojiInfo);
      }
      label1177:
      Object localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(paramas.talker);
      if ((localObject == null) || ((int)((com.tencent.mm.n.a)localObject).dBe == 0))
      {
        localObject = new ad(paramas.talker);
        ((ad)localObject).setType(2);
        ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().V((ad)localObject);
      }
      localObject = new bi();
      ((bi)localObject).setType(47);
      ((bi)localObject).ec(paramas.talker);
      label1293:
      boolean bool;
      if (q.gS(paramas.eHA))
      {
        i = 1;
        ((bi)localObject).fA(i);
        ((bi)localObject).ed(localEmojiInfo.Wv());
        ((bi)localObject).bf(paramas.bXr);
        String str = paramas.eHA;
        if ((localEmojiInfo.ZH()) || (localEmojiInfo.isGif())) {
          break label1662;
        }
        bool = true;
        label1344:
        ((bi)localObject).setContent(ap.a(str, 0L, bool, localEmojiInfo.Wv(), false, paramas.uAV));
        ((bi)localObject).bg(com.tencent.mm.model.bd.o(((cs)localObject).field_talker, paramas.createTime));
        ((bi)localObject).setStatus(3);
        if (!bk.bl(paramas.czr)) {
          ((bi)localObject).cY(paramas.czr);
        }
        if (parama != null) {
          break label1668;
        }
        i = paramas.czq;
        if (i != 0)
        {
          ((bi)localObject).fJ(i);
          if ((((cs)localObject).field_msgId == 0L) && (((cs)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
            ((bi)localObject).bg(paramas.createTime);
          }
        }
        if (paramas.eKX != 0) {
          ((bi)localObject).bi(paramas.eKX);
        }
        y.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramas.eKX) });
      }
      for (;;)
      {
        if ((this.iXW != null) && (this.iXW.containsKey(Long.valueOf(((cs)localObject).field_msgSvrId))))
        {
          y.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
          ((bi)localObject).setContent((String)this.iXW.get(Long.valueOf(((cs)localObject).field_msgSvrId)));
          ((bi)localObject).setType(10000);
          this.iXW.remove(Long.valueOf(((cs)localObject).field_msgSvrId));
        }
        l = com.tencent.mm.model.bd.h((bi)localObject);
        if (!q.gS(paramas.eHA))
        {
          parama = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(l);
          ((ao)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(parama);
        }
        break;
        i = 0;
        break label1293;
        label1662:
        bool = false;
        break label1344;
        label1668:
        com.tencent.mm.model.bd.a((bi)localObject, parama);
      }
      label1677:
      this.iYb.add(paramas.bIW);
      parama = localEmojiInfo.cwL();
      if (!bk.bl(paramas.dQB))
      {
        localObject = new com.tencent.mm.j.f();
        ((com.tencent.mm.j.f)localObject).field_mediaId = ("downemoj_" + com.tencent.mm.a.g.o(paramas.dQB.getBytes()).substring(0, 16) + "_" + paramas.bXr);
        ((com.tencent.mm.j.f)localObject).field_fullpath = (parama + "_openim");
        ((com.tencent.mm.j.f)localObject).field_fileType = 19;
        ((com.tencent.mm.j.f)localObject).field_authKey = localEmojiInfo.field_tpauthkey;
        ((com.tencent.mm.j.f)localObject).dlQ = localEmojiInfo.field_tpurl;
        ((com.tencent.mm.j.f)localObject).field_priority = com.tencent.mm.j.a.dlk;
        ((com.tencent.mm.j.f)localObject).dlP = new d.2(this, paramas, localEmojiInfo, l);
        if (!com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject, -1)) {
          y.e("MicroMsg.emoji.EmojiService", "recv openim emoj, add task failed");
        }
      }
      while (!bk.bl(localEmojiInfo.field_thumbUrl))
      {
        paramas = i.aHr();
        parama = localEmojiInfo.field_thumbUrl;
        localObject = localEmojiInfo.field_thumbUrl;
        paramas.a(parama, com.tencent.mm.plugin.emoji.e.e.o(localEmojiInfo.cwL() + "_cover", new Object[0]), null);
        return;
        if ((l.aHF()) && (l.aHG()) && (!bk.bl(localEmojiInfo.field_externUrl)) && (!bk.bl(localEmojiInfo.field_externMd5)))
        {
          i.aHr().a(paramas.uAX, com.tencent.mm.plugin.emoji.e.e.p(parama + "_extern", new Object[] { paramas, localEmojiInfo, Integer.valueOf(101), Long.valueOf(l) }), this.iXU);
          com.tencent.mm.plugin.emoji.c.dt(10L);
        }
        else if ((!bk.bl(paramas.bNn)) && (!bk.bl(paramas.aeskey)))
        {
          i.aHr().a(paramas.bNn, com.tencent.mm.plugin.emoji.e.e.p(parama + "_encrypt", new Object[] { paramas, localEmojiInfo, Integer.valueOf(102), Long.valueOf(l) }), this.iXU);
          com.tencent.mm.plugin.emoji.c.dt(6L);
        }
        else if (!bk.bl(paramas.lnw))
        {
          i.aHr().a(paramas.lnw, com.tencent.mm.plugin.emoji.e.e.o(parama, new Object[] { paramas, localEmojiInfo, Integer.valueOf(100), Long.valueOf(l) }), this.iXU);
          com.tencent.mm.plugin.emoji.c.dt(1L);
        }
        else
        {
          this.iYb.remove(paramas.bIW);
          parama = new LinkedList();
          parama.add(paramas.bIW);
          com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.emoji.f.f(parama), 0);
          y.i("MicroMsg.emoji.EmojiService", "emoji encrypt url and cdn url is null. md5:%s try to batch emoji download for get url.", new Object[] { paramas.bIW });
          com.tencent.mm.plugin.emoji.c.dt(9L);
        }
      }
    }
    label2276:
    y.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.iYb.remove(paramas.bIW);
    a(paramas);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bi parambi)
  {
    if ((bk.bl(paramString)) || (paramEmojiInfo == null)) {
      return;
    }
    if (com.tencent.mm.vfs.e.aeQ(paramEmojiInfo.cwL()) <= 0L)
    {
      paramEmojiInfo.field_state = EmojiInfo.uDf;
      i.getEmojiStorageMgr().uBb.q(paramEmojiInfo);
    }
    long l1 = System.currentTimeMillis();
    boolean bool1 = false;
    com.tencent.mm.plugin.emoji.e.i locali;
    label115:
    Object localObject1;
    label154:
    boolean bool2;
    label186:
    long l2;
    label248:
    com.tencent.mm.storage.emotion.m localm;
    label510:
    int i;
    label845:
    Object localObject2;
    if ((paramEmojiInfo != null) && (!bk.bl(paramEmojiInfo.field_groupId)))
    {
      locali = i.aHT();
      localObject3 = paramEmojiInfo.field_groupId;
      if (bk.bl((String)localObject3)) {
        y.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      }
      for (bool1 = false;; bool1 = false)
      {
        y.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
        if (parambi != null) {
          break label1275;
        }
        parambi = new bi();
        if ((paramEmojiInfo.field_type != EmojiInfo.uDd) && (paramEmojiInfo.field_type != EmojiInfo.uDe)) {
          break label1260;
        }
        parambi.setType(1048625);
        parambi.ec(paramString);
        parambi.fA(1);
        localObject1 = q.Gj();
        if ((paramEmojiInfo.ZH()) || (paramEmojiInfo.isGif())) {
          break label1269;
        }
        bool2 = true;
        parambi.setContent(ap.a((String)localObject1, l1, bool2, paramEmojiInfo.Wv(), bool1, ""));
        parambi.ed(paramEmojiInfo.Wv());
        parambi.bg(com.tencent.mm.model.bd.iK(parambi.field_talker));
        l2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(parambi);
        y.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = " + l2);
        this.iXY.add(new d.b(this, l2, paramString, paramEmojiInfo, String.valueOf(l1)));
        if ((!this.iXX) || (this.iXY.size() == 1))
        {
          this.iXX = true;
          com.tencent.mm.kernel.g.DO().dJT.a(new s(String.valueOf(l1), paramString, paramEmojiInfo, l2), 0);
        }
        paramString = paramEmojiInfo.field_md5;
        AQ(paramEmojiInfo.field_groupId);
        return;
        if ((locali.iXo) || (q.Gs())) {
          break;
        }
        y.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(locali.iXo), Boolean.valueOf(q.Gs()) });
      }
      if ((locali.iXs != null) && (locali.iXs.containsKey(localObject3))) {
        localm = (com.tencent.mm.storage.emotion.m)locali.iXs.get(localObject3);
      }
      for (;;)
      {
        if (System.currentTimeMillis() - localm.field_showTipsTime >= locali.iXp) {
          break label510;
        }
        y.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
        locali.aHy();
        bool1 = false;
        break;
        localm = new com.tencent.mm.storage.emotion.m();
        localm.field_prodcutID = ((String)localObject3);
      }
      if ((localm != null) && (System.currentTimeMillis() - localm.field_setFlagTime > 86400000L)) {
        if ((locali.iXr != null) && (((String)localObject3).equalsIgnoreCase(locali.iXr.field_prodcutID)) && (locali.iXr.field_continuCount >= locali.iXq - 1) && (locali.iXr.field_continuCount <= locali.iXq + 5 - 1)) {
          com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.emoji.f.p((String)localObject3, com.tencent.mm.plugin.emoji.f.p.jac), 0);
        }
      }
      for (;;)
      {
        if ((locali.iXr != null) && (((String)localObject3).equalsIgnoreCase(locali.iXr.field_prodcutID)) && (locali.iXr.field_continuCount >= locali.iXq))
        {
          if (((locali.iXr.field_flag & com.tencent.mm.plugin.emoji.f.p.jad) == com.tencent.mm.plugin.emoji.f.p.jad) && ((locali.iXr.field_flag & com.tencent.mm.plugin.emoji.f.p.jae) != com.tencent.mm.plugin.emoji.f.p.jae))
          {
            y.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.valueOf(true), localObject3, Integer.valueOf(locali.iXr.field_continuCount) });
            locali.a(localm, true);
            h.nFQ.f(12953, new Object[] { Integer.valueOf(0), locali.iXr.field_prodcutID });
            bool1 = true;
            break;
            if ((localm.field_totalCount < locali.dsr - 1) || (localm.field_totalCount > locali.dsr + 5 - 1)) {
              continue;
            }
            com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.emoji.f.p((String)localObject3, com.tencent.mm.plugin.emoji.f.p.jac), 0);
            continue;
            if (locali.iXr == null)
            {
              i = 0;
              if (locali.iXr != null) {
                break label901;
              }
            }
            label901:
            for (int j = 0;; j = locali.iXr.field_totalCount)
            {
              y.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              break;
              i = locali.iXr.field_continuCount;
              break label845;
            }
          }
          localObject2 = "isNeedShowTip:%b productid:%s  continue count:%d flag:%d";
          localObject1 = new Object[4];
          localObject1[0] = Boolean.valueOf(false);
          localObject1[1] = localObject3;
          localObject1[2] = Integer.valueOf(locali.iXr.field_continuCount);
        }
      }
    }
    label1162:
    label1307:
    for (Object localObject3 = localObject1;; localObject3 = localObject1)
    {
      i = locali.iXr.field_flag;
      localObject3[3] = Integer.valueOf(i);
      y.i("MicroMsg.emoji.EmojiRewardTipMgr", (String)localObject2, (Object[])localObject1);
      do
      {
        locali.a(localm, false);
        bool1 = false;
        break;
      } while ((localm == null) || (localm.field_totalCount < locali.dsr));
      if (((localm.field_flag & com.tencent.mm.plugin.emoji.f.p.jad) == com.tencent.mm.plugin.emoji.f.p.jad) && ((localm.field_flag & com.tencent.mm.plugin.emoji.f.p.jae) != com.tencent.mm.plugin.emoji.f.p.jae))
      {
        if (locali.iXr == null)
        {
          i = 0;
          label1060:
          y.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { Boolean.valueOf(true), localObject3, Integer.valueOf(i) });
          locali.a(localm, true);
          localObject2 = h.nFQ;
          if (locali.iXr != null) {
            break label1162;
          }
        }
        for (localObject1 = "";; localObject1 = locali.iXr.field_prodcutID)
        {
          ((h)localObject2).f(12953, new Object[] { Integer.valueOf(0), localObject1 });
          bool1 = true;
          break;
          i = locali.iXr.field_totalCount;
          break label1060;
        }
      }
      localObject2 = "isNeedShowTip:%b productid:%s  total count :%d flag:%d";
      localObject1 = new Object[4];
      localObject1[0] = Boolean.valueOf(false);
      localObject1[1] = localObject3;
      if (locali.iXr == null) {}
      for (i = 0;; i = locali.iXr.field_totalCount)
      {
        localObject1[2] = Integer.valueOf(i);
        if (locali.iXr != null) {
          break label1307;
        }
        i = 0;
        localObject3 = localObject1;
        break;
      }
      i.aHT().aHy();
      break label115;
      label1260:
      parambi.setType(47);
      break label154;
      label1269:
      bool2 = false;
      break label186;
      label1275:
      l2 = parambi.field_msgId;
      parambi = ap.abP(parambi.field_content);
      if (parambi.time == 0L) {
        break;
      }
      l1 = parambi.time;
      break label248;
    }
  }
  
  public final boolean i(EmojiInfo paramEmojiInfo)
  {
    as localas;
    if (paramEmojiInfo == null)
    {
      y.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
      localas = null;
    }
    while (localas == null)
    {
      y.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      return true;
      localas = new as();
      localas.bIW = paramEmojiInfo.field_md5;
      localas.uAR = paramEmojiInfo.field_type;
      localas.uAS = paramEmojiInfo.field_size;
      localas.bJd = paramEmojiInfo.field_groupId;
      localas.uAW = paramEmojiInfo.field_designerID;
      localas.thumbUrl = paramEmojiInfo.field_thumbUrl;
      localas.bNn = paramEmojiInfo.field_encrypturl;
      localas.aeskey = paramEmojiInfo.field_aeskey;
      localas.width = paramEmojiInfo.field_width;
      localas.height = paramEmojiInfo.field_height;
      localas.lnw = paramEmojiInfo.field_cdnUrl;
      localas.uAX = paramEmojiInfo.field_externUrl;
      localas.uAY = paramEmojiInfo.field_externMd5;
      localas.uBa = paramEmojiInfo.field_activityid;
      localas.dQB = paramEmojiInfo.field_tpurl;
      localas.dQH = paramEmojiInfo.field_tpauthkey;
      localas.iYZ = paramEmojiInfo.field_attachedText;
    }
    String str;
    if (paramEmojiInfo == null)
    {
      str = "";
      localas.talker = str;
      localas.uAZ = false;
      a(localas, null, true);
      if (paramEmojiInfo != null) {
        break label222;
      }
    }
    label222:
    for (paramEmojiInfo = null;; paramEmojiInfo = paramEmojiInfo.field_groupId)
    {
      AQ(paramEmojiInfo);
      return true;
      str = paramEmojiInfo.talker;
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof s))
    {
      if (this.iXY.size() <= 0) {
        this.iXX = false;
      }
    }
    else {
      return;
    }
    paramString = (d.b)this.iXY.remove(0);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.f.nEG.a(111L, 35L, 1L, true);
    }
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      paramm = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramString.bIt);
      paramm.setStatus(paramInt1);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramString.bIt, paramm);
      if (this.iXY.size() > 0)
      {
        paramString = (d.b)this.iXY.get(0);
        com.tencent.mm.kernel.g.DO().dJT.a(new s(paramString.bMB, paramString.toUserName, paramString.bHd, paramString.bIt), 0);
      }
      for (;;)
      {
        if (this.iXZ == null) {
          this.iXZ = new rl();
        }
        this.iXZ.caZ.bJd = paramString.bHd.field_groupId;
        com.tencent.mm.sdk.b.a.udP.m(this.iXZ);
        return;
        this.iXX = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */