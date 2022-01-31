package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.al.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class h
  extends com.tencent.mm.model.e
{
  public static int a(int paramInt1, com.tencent.mm.i.d paramd, bi parambi, String paramString1, long paramLong1, String paramString2, String paramString3, int paramInt2, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(78280);
    if (paramInt1 != 0)
    {
      ab.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambi.setStatus(5);
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().b(parambi.field_msgSvrId, parambi);
      paramd = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" });
      new com.tencent.mm.g.b.a.f(paramd).ake();
      new com.tencent.mm.g.b.a.d(paramd).ake();
      o.ahC().doNotify();
      AppMethodBeat.o(78280);
      return 0;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(78280);
      return 0;
    }
    int i;
    label296:
    int j;
    if (paramd.field_retCode != 0)
    {
      ab.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambi.setStatus(5);
      if (!bo.isNullOrNil(parambi.field_talker)) {
        ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().b(parambi.field_msgSvrId, parambi);
      }
      if (paramd != null) {
        break label939;
      }
      i = paramInt1;
      paramLong1 = bo.aoy();
      j = com.tencent.mm.al.c.cb(ah.getContext());
      int k = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label948;
      }
      parambi = "";
      label321:
      if (paramd != null) {
        break label956;
      }
      paramString1 = "";
      label328:
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), parambi, "", "", "", "", "", "", "", paramString1 })).ake();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label964;
        }
        label470:
        paramLong1 = bo.aoy();
        i = com.tencent.mm.al.c.cb(ah.getContext());
        j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label972;
        }
        parambi = "";
        label495:
        if (paramd != null) {
          break label980;
        }
      }
    }
    label711:
    label972:
    label980:
    for (paramd = "";; paramd = paramd.edb)
    {
      new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), parambi, "", "", "", "", "", "", "", paramd })).ake();
      o.ahC().doNotify();
      AppMethodBeat.o(78280);
      return 0;
      if (r.aoZ(paramString4))
      {
        Object localObject = paramString2 + "_hevc";
        com.tencent.mm.vfs.e.aT(paramString4, (String)localObject);
        if (!com.tencent.mm.vfs.e.cN(paramString2)) {
          com.tencent.mm.vfs.e.avL(paramString2);
        }
        ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic((String)localObject, paramString2);
        parambi.setStatus(6);
        paramString4 = new PInt();
        localObject = new PInt();
        com.tencent.mm.sdk.platformtools.d.c(paramString2, paramString4, (PInt)localObject);
        parambi.hW(paramString4.value);
        parambi.hX(((PInt)localObject).value);
        ab.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramString4.value), Integer.valueOf(((PInt)localObject).value), paramString3, paramString2 });
        if (!bo.isNullOrNil(parambi.field_talker)) {
          ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().b(parambi.field_msgSvrId, parambi);
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 1L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 2L, 1L, false);
        parambi = com.tencent.mm.plugin.report.service.h.qsU;
        if (!t.lA(paramString1)) {
          break label931;
        }
      }
      for (paramLong1 = 4L;; paramLong1 = 3L)
      {
        parambi.idkeyStat(198L, paramLong1, 1L, false);
        break;
        com.tencent.mm.vfs.e.aT(paramString4, paramString2);
        break label711;
      }
      i = paramd.field_retCode;
      break label296;
      parambi = paramd.field_transInfo;
      break label321;
      paramString1 = paramd.edb;
      break label328;
      paramInt1 = paramd.field_retCode;
      break label470;
      parambi = paramd.field_transInfo;
      break label495;
    }
  }
  
  public final bi a(cm paramcm, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78279);
    Object localObject1 = o.ahC();
    paramString3 = super.a(paramcm, paramString1, paramString2, paramString3);
    if (paramString3.field_msgId != 0L)
    {
      AppMethodBeat.o(78279);
      return paramString3;
    }
    long l1 = paramcm.pIG;
    paramString2 = ((g)localObject1).gS(l1);
    if (paramString2.cFn == l1)
    {
      com.tencent.mm.vfs.e.deleteFile(((g)localObject1).q(paramString2.fDM, "", ""));
      com.tencent.mm.vfs.e.deleteFile(((g)localObject1).q(paramString2.fDR, "", ""));
      com.tencent.mm.vfs.e.deleteFile(((g)localObject1).q(paramString2.fDO, "", ""));
      com.tencent.mm.vfs.e.deleteFile(((g)localObject1).q(paramString2.fDO, "", "") + "hd");
      ((g)localObject1).fnw.delete("ImgInfo2", "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString2.ahh())
      {
        paramString2 = ((g)localObject1).lv(paramString2.fDW);
        if (paramString2 != null)
        {
          com.tencent.mm.vfs.e.deleteFile(((g)localObject1).q(paramString2.fDM, "", ""));
          com.tencent.mm.vfs.e.deleteFile(((g)localObject1).q(paramString2.fDR, "", ""));
          com.tencent.mm.vfs.e.deleteFile(((g)localObject1).q(paramString2.fDO, "", ""));
          com.tencent.mm.vfs.e.deleteFile(((g)localObject1).q(paramString2.fDO, "", "") + "hd");
          ((g)localObject1).fnw.delete("ImgInfo2", "id=?", new String[] { paramString2.fDL });
        }
      }
    }
    if (paramcm.woS != 2)
    {
      ab.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      AppMethodBeat.o(78279);
      return paramString3;
    }
    paramString2 = aa.a(paramcm.woT);
    if (ae.gkQ)
    {
      ab.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      paramString2 = null;
    }
    for (;;)
    {
      Object localObject3 = br.F(paramString3.field_content, "msg");
      l1 = -1L;
      int i;
      int j;
      if (!bo.isNullOrNil(paramString3.field_content))
      {
        ab.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[] { paramString3.field_content });
        if (localObject3 == null) {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 190L, 1L, false);
        }
        if (localObject3 == null) {
          break label1564;
        }
        i = bo.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), 0);
        j = bo.getInt((String)((Map)localObject3).get(".msg.img.$tphdlength"), 0);
        if (i <= 0) {
          break label1144;
        }
        l1 = ((g)localObject1).a(paramString2, paramcm.pIG, true, paramString3.field_content, new PString(), new PInt(), new PInt());
      }
      for (;;)
      {
        Object localObject2 = br.F(paramString3.field_content, "msgoperation");
        if (localObject2 != null)
        {
          paramString3.kq((String)((Map)localObject2).get(".msgoperation.expinfo.expidstr"));
          paramString3.ib(bo.getInt((String)((Map)localObject2).get(".msgoperation.imagemsg.downloadcontroltype"), 0));
          ab.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString3.dHa, Integer.valueOf(paramString3.dHb) });
        }
        localObject2 = (String)((Map)localObject3).get(".msg.img.$tpthumburl");
        Object localObject4 = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        long l2 = ((g)localObject1).a(paramString2, paramcm.pIG, false, paramString3.field_content, (PString)localObject4, localPInt1, localPInt2);
        if ((bo.ce(paramString2)) && (localObject3 != null) && (!bo.isNullOrNil((String)localObject2)))
        {
          localPInt1.value = bo.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbwidth"), 0);
          localPInt2.value = bo.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbheight"), 0);
        }
        if (l2 > 0L)
        {
          paramString3.kk(((PString)localObject4).value);
          paramString3.hW(localPInt1.value);
          paramString3.hX(localPInt2.value);
          if (l1 > 0L)
          {
            paramcm = o.ahC().b(Long.valueOf(l2));
            paramcm.lu(1);
            paramcm.lr((int)l1);
            o.ahC().a(Long.valueOf(l2), paramcm);
          }
        }
        if ((bo.ce(paramString2)) && (localObject3 != null) && (!bo.isNullOrNil((String)localObject2)))
        {
          paramcm = (String)((Map)localObject3).get(".msg.img.$tpthumbaeskey");
          j = bo.getInt((String)((Map)localObject3).get(".msg.img.tpthumblength"), 0);
          paramString2 = (String)((Map)localObject3).get(".msg.img.$tpauthkey");
          localObject1 = ((g)localObject1).q(com.tencent.mm.a.g.w(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString3.field_msgSvrId;
          ab.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, localObject2, localObject1 });
          l2 = bo.aoy();
          localObject3 = (String)localObject1 + ".tmp";
          localObject4 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject4).field_mediaId = com.tencent.mm.al.c.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject4).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.i.g)localObject4).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject4).field_aesKey = paramcm;
          ((com.tencent.mm.i.g)localObject4).field_authKey = paramString2;
          ((com.tencent.mm.i.g)localObject4).eds = ((String)localObject2);
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).bkg())
          {
            i = 2;
            ((com.tencent.mm.i.g)localObject4).expectImageFormat = i;
            ((com.tencent.mm.i.g)localObject4).edp = new h.1(this, paramString3, paramString1, l1, (String)localObject1, (String)localObject2, j, l2, (String)localObject3);
            paramString3.setStatus(4);
            com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject4, -1);
          }
        }
        label1144:
        while ((!bo.ce(paramString2)) || (localObject3 == null)) {
          for (;;)
          {
            AppMethodBeat.o(78279);
            return paramString3;
            if (j <= 0) {
              break label1564;
            }
            l1 = ((g)localObject1).a(paramString2, paramcm.pIG, true, paramString3.field_content, new PString(), new PInt(), new PInt());
            break;
            i = 1;
          }
        }
        paramcm = (String)((Map)localObject3).get(".msg.img.$cdnthumbaeskey");
        paramString2 = (String)((Map)localObject3).get(".msg.img.$cdnthumburl");
        j = bo.getInt((String)((Map)localObject3).get(".msg.img.$cdnthumblength"), 0);
        localObject1 = ((g)localObject1).q(com.tencent.mm.a.g.w(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
        l1 = paramString3.field_msgSvrId;
        ab.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString2, localObject1 });
        l2 = bo.aoy();
        localObject2 = (String)localObject1 + ".tmp";
        localObject3 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.al.c.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
        ((com.tencent.mm.i.g)localObject3).field_fullpath = ((String)localObject2);
        ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.i.g)localObject3).field_totalLen = j;
        ((com.tencent.mm.i.g)localObject3).field_aesKey = paramcm;
        ((com.tencent.mm.i.g)localObject3).field_fileId = paramString2;
        ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.ecG;
        if (t.lA(paramString1))
        {
          i = 1;
          label1446:
          ((com.tencent.mm.i.g)localObject3).field_chattype = i;
          if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).bkg()) {
            break label1558;
          }
        }
        label1558:
        for (i = 2;; i = 1)
        {
          ((com.tencent.mm.i.g)localObject3).expectImageFormat = i;
          ab.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.i.g)localObject3).edp = new h.2(this, paramString3, paramString1, l1, (String)localObject1, paramString2, j, l2, (String)localObject2);
          paramString3.setStatus(4);
          com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject3, -1);
          break;
          i = 0;
          break label1446;
        }
        label1564:
        l1 = -1L;
      }
    }
  }
  
  public final void a(e.c paramc)
  {
    AppMethodBeat.i(78281);
    o.ahC().x(paramc.cEE);
    AppMethodBeat.o(78281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.at.h
 * JD-Core Version:    0.7.0.1
 */