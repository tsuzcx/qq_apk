package com.tencent.mm.as;

import com.tencent.mm.ah.e.c;
import com.tencent.mm.ak.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class h
  extends com.tencent.mm.model.e
{
  public static int a(int paramInt1, com.tencent.mm.j.d paramd, bi parambi, String paramString1, long paramLong1, String paramString2, String paramString3, int paramInt2, long paramLong2, String paramString4)
  {
    if (paramInt1 != 0)
    {
      y.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambi.setStatus(5);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(parambi.field_msgSvrId, parambi);
      paramd = com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" });
      new com.tencent.mm.h.b.a.f(paramd).QX();
      new com.tencent.mm.h.b.a.d(paramd).QX();
      o.OJ().doNotify();
      return 0;
    }
    if (paramd == null) {
      return 0;
    }
    int i;
    label281:
    int j;
    if (paramd.field_retCode != 0)
    {
      y.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambi.setStatus(5);
      if (!bk.bl(parambi.field_talker)) {
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(parambi.field_msgSvrId, parambi);
      }
      if (paramd != null) {
        break label919;
      }
      i = paramInt1;
      paramLong1 = bk.UY();
      j = com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext());
      int k = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label928;
      }
      parambi = "";
      label306:
      if (paramd != null) {
        break label936;
      }
      paramString1 = "";
      label313:
      new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), parambi, "", "", "", "", "", "", "", paramString1 })).QX();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label944;
        }
        label455:
        paramLong1 = bk.UY();
        i = com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext());
        j = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label952;
        }
        parambi = "";
        label480:
        if (paramd != null) {
          break label960;
        }
      }
    }
    label691:
    label952:
    label960:
    for (paramd = "";; paramd = paramd.dlG)
    {
      new com.tencent.mm.h.b.a.d(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), parambi, "", "", "", "", "", "", "", paramd })).QX();
      o.OJ().doNotify();
      return 0;
      if (com.tencent.mm.sdk.platformtools.o.Zb(paramString4))
      {
        Object localObject = paramString2 + "_hevc";
        com.tencent.mm.vfs.e.aA(paramString4, (String)localObject);
        if (!com.tencent.mm.vfs.e.bK(paramString2)) {
          com.tencent.mm.vfs.e.aeU(paramString2);
        }
        ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic((String)localObject, paramString2);
        parambi.setStatus(6);
        paramString4 = new PInt();
        localObject = new PInt();
        com.tencent.mm.sdk.platformtools.c.c(paramString2, paramString4, (PInt)localObject);
        parambi.fK(paramString4.value);
        parambi.fL(((PInt)localObject).value);
        y.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramString4.value), Integer.valueOf(((PInt)localObject).value), paramString3, paramString2 });
        if (!bk.bl(parambi.field_talker)) {
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(parambi.field_msgSvrId, parambi);
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(198L, 1L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(198L, 2L, 1L, false);
        parambi = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!s.fn(paramString1)) {
          break label911;
        }
      }
      for (paramLong1 = 4L;; paramLong1 = 3L)
      {
        parambi.a(198L, paramLong1, 1L, false);
        break;
        com.tencent.mm.vfs.e.aA(paramString4, paramString2);
        break label691;
      }
      i = paramd.field_retCode;
      break label281;
      parambi = paramd.field_transInfo;
      break label306;
      paramString1 = paramd.dlG;
      break label313;
      paramInt1 = paramd.field_retCode;
      break label455;
      parambi = paramd.field_transInfo;
      break label480;
    }
  }
  
  protected final bi a(cd paramcd, String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = o.OJ();
    paramString3 = super.a(paramcd, paramString1, paramString2, paramString3);
    if (paramString3.field_msgId != 0L) {
      return paramString3;
    }
    long l1 = paramcd.ndp;
    paramString2 = ((g)localObject1).bX(l1);
    if (paramString2.bXr == l1)
    {
      com.tencent.mm.vfs.e.deleteFile(((g)localObject1).o(paramString2.enq, "", ""));
      com.tencent.mm.vfs.e.deleteFile(((g)localObject1).o(paramString2.ens, "", ""));
      com.tencent.mm.vfs.e.deleteFile(((g)localObject1).o(paramString2.ens, "", "") + "hd");
      ((g)localObject1).dXo.delete("ImgInfo2", "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString2.Or())
      {
        paramString2 = ((g)localObject1).iH(paramString2.enz);
        if (paramString2 != null)
        {
          com.tencent.mm.vfs.e.deleteFile(((g)localObject1).o(paramString2.enq, "", ""));
          com.tencent.mm.vfs.e.deleteFile(((g)localObject1).o(paramString2.ens, "", ""));
          com.tencent.mm.vfs.e.deleteFile(((g)localObject1).o(paramString2.ens, "", "") + "hd");
          ((g)localObject1).dXo.delete("ImgInfo2", "id=?", new String[] { paramString2.enp });
        }
      }
    }
    if (paramcd.svI != 2)
    {
      y.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      return paramString3;
    }
    paramString2 = aa.a(paramcd.svJ);
    if (com.tencent.mm.platformtools.ae.eSV)
    {
      y.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      paramString2 = null;
    }
    for (;;)
    {
      Object localObject3 = bn.s(paramString3.field_content, "msg");
      l1 = -1L;
      int i;
      int j;
      if (!bk.bl(paramString3.field_content))
      {
        y.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[] { paramString3.field_content });
        if (localObject3 == null) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 190L, 1L, false);
        }
        if (localObject3 == null) {
          break label1528;
        }
        i = bk.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), 0);
        j = bk.getInt((String)((Map)localObject3).get(".msg.img.$tphdlength"), 0);
        if (i <= 0) {
          break label1102;
        }
        i = paramcd.svI;
        l1 = ((g)localObject1).a(paramString2, paramcd.ndp, true, paramString3.field_content, new PString(), new PInt(), new PInt());
      }
      for (;;)
      {
        Object localObject2 = bn.s(paramString3.field_content, "msgoperation");
        if (localObject2 != null)
        {
          paramString3.ej((String)((Map)localObject2).get(".msgoperation.expinfo.expidstr"));
          paramString3.fN(bk.getInt((String)((Map)localObject2).get(".msgoperation.imagemsg.downloadcontroltype"), 0));
          y.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString3.cQO, Integer.valueOf(paramString3.cQP) });
        }
        localObject2 = (String)((Map)localObject3).get(".msg.img.$tpthumburl");
        Object localObject4 = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        i = paramcd.svI;
        long l2 = ((g)localObject1).a(paramString2, paramcd.ndp, false, paramString3.field_content, (PString)localObject4, localPInt1, localPInt2);
        if ((bk.bE(paramString2)) && (localObject3 != null) && (!bk.bl((String)localObject2)))
        {
          localPInt1.value = bk.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbwidth"), 0);
          localPInt2.value = bk.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbheight"), 0);
        }
        if (l2 > 0L)
        {
          paramString3.ed(((PString)localObject4).value);
          paramString3.fK(localPInt1.value);
          paramString3.fL(localPInt2.value);
          if (l1 > 0L)
          {
            paramcd = o.OJ().b(Long.valueOf(l2));
            paramcd.iG(1);
            paramcd.iD((int)l1);
            o.OJ().a(Long.valueOf(l2), paramcd);
          }
        }
        if ((bk.bE(paramString2)) && (localObject3 != null) && (!bk.bl((String)localObject2)))
        {
          paramcd = (String)((Map)localObject3).get(".msg.img.$tpthumbaeskey");
          j = bk.getInt((String)((Map)localObject3).get(".msg.img.tpthumblength"), 0);
          paramString2 = (String)((Map)localObject3).get(".msg.img.$tpauthkey");
          localObject1 = ((g)localObject1).o(com.tencent.mm.a.g.o(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString3.field_msgSvrId;
          y.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, localObject2, localObject1 });
          l2 = bk.UY();
          localObject3 = (String)localObject1 + ".tmp";
          localObject4 = new com.tencent.mm.j.f();
          ((com.tencent.mm.j.f)localObject4).field_mediaId = com.tencent.mm.ak.c.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
          ((com.tencent.mm.j.f)localObject4).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.j.f)localObject4).field_fileType = 19;
          ((com.tencent.mm.j.f)localObject4).field_aesKey = paramcd;
          ((com.tencent.mm.j.f)localObject4).field_authKey = paramString2;
          ((com.tencent.mm.j.f)localObject4).dlQ = ((String)localObject2);
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).aGx())
          {
            i = 2;
            ((com.tencent.mm.j.f)localObject4).expectImageFormat = i;
            ((com.tencent.mm.j.f)localObject4).dlP = new h.1(this, paramString3, paramString1, l1, (String)localObject1, (String)localObject2, j, l2, (String)localObject3);
            paramString3.setStatus(4);
            com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject4, -1);
          }
        }
        label1102:
        while ((!bk.bE(paramString2)) || (localObject3 == null)) {
          for (;;)
          {
            return paramString3;
            if (j <= 0) {
              break label1528;
            }
            i = paramcd.svI;
            l1 = ((g)localObject1).a(paramString2, paramcd.ndp, true, paramString3.field_content, new PString(), new PInt(), new PInt());
            break;
            i = 1;
          }
        }
        paramcd = (String)((Map)localObject3).get(".msg.img.$cdnthumbaeskey");
        paramString2 = (String)((Map)localObject3).get(".msg.img.$cdnthumburl");
        j = bk.getInt((String)((Map)localObject3).get(".msg.img.$cdnthumblength"), 0);
        localObject1 = ((g)localObject1).o(com.tencent.mm.a.g.o(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
        l1 = paramString3.field_msgSvrId;
        y.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString2, localObject1 });
        l2 = bk.UY();
        localObject2 = (String)localObject1 + ".tmp";
        localObject3 = new com.tencent.mm.j.f();
        ((com.tencent.mm.j.f)localObject3).field_mediaId = com.tencent.mm.ak.c.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
        ((com.tencent.mm.j.f)localObject3).field_fullpath = ((String)localObject2);
        ((com.tencent.mm.j.f)localObject3).field_fileType = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.j.f)localObject3).field_totalLen = j;
        ((com.tencent.mm.j.f)localObject3).field_aesKey = paramcd;
        ((com.tencent.mm.j.f)localObject3).field_fileId = paramString2;
        ((com.tencent.mm.j.f)localObject3).field_priority = com.tencent.mm.j.a.dll;
        if (s.fn(paramString1))
        {
          i = 1;
          label1410:
          ((com.tencent.mm.j.f)localObject3).field_chattype = i;
          if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).aGx()) {
            break label1522;
          }
        }
        label1522:
        for (i = 2;; i = 1)
        {
          ((com.tencent.mm.j.f)localObject3).expectImageFormat = i;
          y.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.j.f)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.j.f)localObject3).dlP = new h.2(this, paramString3, paramString1, l1, (String)localObject1, paramString2, j, l2, (String)localObject2);
          paramString3.setStatus(4);
          com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject3, -1);
          break;
          i = 0;
          break label1410;
        }
        label1528:
        l1 = -1L;
      }
    }
  }
  
  public final void a(e.c paramc)
  {
    o.OJ().r(paramc.bWO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.as.h
 * JD-Core Version:    0.7.0.1
 */