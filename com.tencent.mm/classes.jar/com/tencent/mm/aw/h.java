package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.c;
import com.tencent.mm.ao.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class h
  extends com.tencent.mm.model.e
{
  public static int a(int paramInt1, d paramd, bl parambl, String paramString1, long paramLong1, String paramString2, String paramString3, int paramInt2, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(150640);
    if (paramInt1 != 0)
    {
      ad.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambl.setStatus(5);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().b(parambl.field_msgSvrId, parambl);
      paramd = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" });
      new com.tencent.mm.g.b.a.h(paramd).aBj();
      new com.tencent.mm.g.b.a.f(paramd).aBj();
      o.ayF().doNotify();
      AppMethodBeat.o(150640);
      return 0;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(150640);
      return 0;
    }
    int i;
    label296:
    int j;
    if (paramd.field_retCode != 0)
    {
      ad.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambl.setStatus(5);
      if (!bt.isNullOrNil(parambl.field_talker)) {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().b(parambl.field_msgSvrId, parambl);
      }
      if (paramd != null) {
        break label939;
      }
      i = paramInt1;
      paramLong1 = bt.eGO();
      j = com.tencent.mm.ao.c.cu(aj.getContext());
      int k = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label948;
      }
      parambl = "";
      label321:
      if (paramd != null) {
        break label956;
      }
      paramString1 = "";
      label328:
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), parambl, "", "", "", "", "", "", "", paramString1 })).aBj();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label964;
        }
        label470:
        paramLong1 = bt.eGO();
        i = com.tencent.mm.ao.c.cu(aj.getContext());
        j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label972;
        }
        parambl = "";
        label495:
        if (paramd != null) {
          break label980;
        }
      }
    }
    label711:
    label972:
    label980:
    for (paramd = "";; paramd = paramd.fns)
    {
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), parambl, "", "", "", "", "", "", "", paramd })).aBj();
      o.ayF().doNotify();
      AppMethodBeat.o(150640);
      return 0;
      if (t.aFn(paramString4))
      {
        Object localObject = paramString2 + "_hevc";
        i.lD(paramString4, (String)localObject);
        if (!i.eK(paramString2)) {
          i.aMR(paramString2);
        }
        ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic((String)localObject, paramString2);
        parambl.setStatus(6);
        paramString4 = new PInt();
        localObject = new PInt();
        com.tencent.mm.sdk.platformtools.f.c(paramString2, paramString4, (PInt)localObject);
        parambl.kh(paramString4.value);
        parambl.ki(((PInt)localObject).value);
        ad.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramString4.value), Integer.valueOf(((PInt)localObject).value), paramString3, paramString2 });
        if (!bt.isNullOrNil(parambl.field_talker)) {
          ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().b(parambl.field_msgSvrId, parambl);
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 1L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 2L, 1L, false);
        parambl = com.tencent.mm.plugin.report.service.h.vKh;
        if (!w.pF(paramString1)) {
          break label931;
        }
      }
      for (paramLong1 = 4L;; paramLong1 = 3L)
      {
        parambl.idkeyStat(198L, paramLong1, 1L, false);
        break;
        i.lD(paramString4, paramString2);
        break label711;
      }
      i = paramd.field_retCode;
      break label296;
      parambl = paramd.field_transInfo;
      break label321;
      paramString1 = paramd.fns;
      break label328;
      paramInt1 = paramd.field_retCode;
      break label470;
      parambl = paramd.field_transInfo;
      break label495;
    }
  }
  
  public final bl a(cs paramcs, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(150639);
    Object localObject1 = o.ayF();
    paramString3 = super.a(paramcs, paramString1, paramString2, paramString3);
    if (paramString3.field_msgId != 0L)
    {
      AppMethodBeat.o(150639);
      return paramString3;
    }
    final long l1 = paramcs.uKZ;
    paramString2 = ((g)localObject1).mr(l1);
    if (paramString2.drA == l1)
    {
      i.deleteFile(((g)localObject1).p(paramString2.hgj, "", ""));
      i.deleteFile(((g)localObject1).p(paramString2.hgo, "", ""));
      i.deleteFile(((g)localObject1).p(paramString2.hgl, "", ""));
      i.deleteFile(((g)localObject1).p(paramString2.hgl, "", "") + "hd");
      ((g)localObject1).gPa.delete("ImgInfo2", "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString2.ayi())
      {
        paramString2 = ((g)localObject1).od(paramString2.hgu);
        if (paramString2 != null)
        {
          i.deleteFile(((g)localObject1).p(paramString2.hgj, "", ""));
          i.deleteFile(((g)localObject1).p(paramString2.hgo, "", ""));
          i.deleteFile(((g)localObject1).p(paramString2.hgl, "", ""));
          i.deleteFile(((g)localObject1).p(paramString2.hgl, "", "") + "hd");
          ((g)localObject1).gPa.delete("ImgInfo2", "id=?", new String[] { paramString2.deI });
        }
      }
    }
    if (paramcs.CxA != 2)
    {
      ad.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      AppMethodBeat.o(150639);
      return paramString3;
    }
    paramString2 = z.a(paramcs.CxB);
    if (ab.hVI)
    {
      ad.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      paramString2 = null;
    }
    for (;;)
    {
      Object localObject3 = bw.K(paramString3.field_content, "msg");
      l1 = -1L;
      int i;
      final int j;
      if (!bt.isNullOrNil(paramString3.field_content))
      {
        ad.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[] { paramString3.field_content });
        if (localObject3 == null) {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 190L, 1L, false);
        }
        if (localObject3 == null) {
          break label1564;
        }
        i = bt.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), 0);
        j = bt.getInt((String)((Map)localObject3).get(".msg.img.$tphdlength"), 0);
        if (i <= 0) {
          break label1144;
        }
        l1 = ((g)localObject1).a(paramString2, paramcs.uKZ, true, paramString3.field_content, new PString(), new PInt(), new PInt());
      }
      for (;;)
      {
        Object localObject2 = bw.K(paramString3.field_content, "msgoperation");
        if (localObject2 != null)
        {
          paramString3.of((String)((Map)localObject2).get(".msgoperation.expinfo.expidstr"));
          paramString3.km(bt.getInt((String)((Map)localObject2).get(".msgoperation.imagemsg.downloadcontroltype"), 0));
          ad.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString3.ePc, Integer.valueOf(paramString3.ePd) });
        }
        localObject2 = (String)((Map)localObject3).get(".msg.img.$tpthumburl");
        Object localObject4 = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        final long l2 = ((g)localObject1).a(paramString2, paramcs.uKZ, false, paramString3.field_content, (PString)localObject4, localPInt1, localPInt2);
        if ((bt.cw(paramString2)) && (localObject3 != null) && (!bt.isNullOrNil((String)localObject2)))
        {
          localPInt1.value = bt.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbwidth"), 0);
          localPInt2.value = bt.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbheight"), 0);
        }
        if (l2 > 0L)
        {
          paramString3.nZ(((PString)localObject4).value);
          paramString3.kh(localPInt1.value);
          paramString3.ki(localPInt2.value);
          if (l1 > 0L)
          {
            paramcs = o.ayF().b(Long.valueOf(l2));
            paramcs.oc(1);
            paramcs.nY((int)l1);
            o.ayF().a(Long.valueOf(l2), paramcs);
          }
        }
        if ((bt.cw(paramString2)) && (localObject3 != null) && (!bt.isNullOrNil((String)localObject2)))
        {
          paramcs = (String)((Map)localObject3).get(".msg.img.$tpthumbaeskey");
          j = bt.getInt((String)((Map)localObject3).get(".msg.img.tpthumblength"), 0);
          paramString2 = (String)((Map)localObject3).get(".msg.img.$tpauthkey");
          localObject1 = ((g)localObject1).p(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString3.field_msgSvrId;
          ad.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, localObject2, localObject1 });
          l2 = bt.eGO();
          localObject3 = (String)localObject1 + ".tmp";
          localObject4 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject4).field_mediaId = com.tencent.mm.ao.c.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject4).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.i.g)localObject4).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject4).field_aesKey = paramcs;
          ((com.tencent.mm.i.g)localObject4).field_authKey = paramString2;
          ((com.tencent.mm.i.g)localObject4).fnK = ((String)localObject2);
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).bTV())
          {
            i = 2;
            ((com.tencent.mm.i.g)localObject4).expectImageFormat = i;
            ((com.tencent.mm.i.g)localObject4).fnH = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(150637);
                h.a(paramAnonymousInt, paramAnonymousd, paramString3, paramString1, l1, this.hhp, j, l2, this.hhs, this.hht);
                AppMethodBeat.o(150637);
                return 0;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            paramString3.setStatus(4);
            com.tencent.mm.ao.f.awL().b((com.tencent.mm.i.g)localObject4, -1);
          }
        }
        label1144:
        while ((!bt.cw(paramString2)) || (localObject3 == null)) {
          for (;;)
          {
            AppMethodBeat.o(150639);
            return paramString3;
            if (j <= 0) {
              break label1564;
            }
            l1 = ((g)localObject1).a(paramString2, paramcs.uKZ, true, paramString3.field_content, new PString(), new PInt(), new PInt());
            break;
            i = 1;
          }
        }
        paramcs = (String)((Map)localObject3).get(".msg.img.$cdnthumbaeskey");
        paramString2 = (String)((Map)localObject3).get(".msg.img.$cdnthumburl");
        j = bt.getInt((String)((Map)localObject3).get(".msg.img.$cdnthumblength"), 0);
        localObject1 = ((g)localObject1).p(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
        l1 = paramString3.field_msgSvrId;
        ad.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString2, localObject1 });
        l2 = bt.eGO();
        localObject2 = (String)localObject1 + ".tmp";
        localObject3 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.ao.c.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
        ((com.tencent.mm.i.g)localObject3).field_fullpath = ((String)localObject2);
        ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.i.g)localObject3).field_totalLen = j;
        ((com.tencent.mm.i.g)localObject3).field_aesKey = paramcs;
        ((com.tencent.mm.i.g)localObject3).field_fileId = paramString2;
        ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fmW;
        if (w.pF(paramString1))
        {
          i = 1;
          label1446:
          ((com.tencent.mm.i.g)localObject3).field_chattype = i;
          if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).bTV()) {
            break label1558;
          }
        }
        label1558:
        for (i = 2;; i = 1)
        {
          ((com.tencent.mm.i.g)localObject3).expectImageFormat = i;
          ad.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.i.g)localObject3).fnH = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(150638);
              h.a(paramAnonymousInt, paramAnonymousd, paramString3, paramString1, l1, paramString2, j, l2, this.hhs, this.hht);
              AppMethodBeat.o(150638);
              return 0;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return null;
            }
          };
          paramString3.setStatus(4);
          com.tencent.mm.ao.f.awL().b((com.tencent.mm.i.g)localObject3, -1);
          break;
          i = 0;
          break label1446;
        }
        label1564:
        l1 = -1L;
      }
    }
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(150641);
    o.ayF().J(paramc.drF);
    AppMethodBeat.o(150641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.h
 * JD-Core Version:    0.7.0.1
 */