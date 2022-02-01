package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.an.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class h
  extends com.tencent.mm.model.e
{
  public static int a(int paramInt1, d paramd, bo parambo, String paramString1, long paramLong1, String paramString2, String paramString3, int paramInt2, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(150640);
    if (paramInt1 != 0)
    {
      ac.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambo.setStatus(5);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().b(parambo.field_msgSvrId, parambo);
      paramd = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" });
      new com.tencent.mm.g.b.a.h(paramd).aHZ();
      new com.tencent.mm.g.b.a.f(paramd).aHZ();
      o.aFx().doNotify();
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
      ac.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambo.setStatus(5);
      if (!bs.isNullOrNil(parambo.field_talker)) {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().b(parambo.field_msgSvrId, parambo);
      }
      if (paramd != null) {
        break label939;
      }
      i = paramInt1;
      paramLong1 = bs.eWj();
      j = com.tencent.mm.an.c.cD(ai.getContext());
      int k = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label948;
      }
      parambo = "";
      label321:
      if (paramd != null) {
        break label956;
      }
      paramString1 = "";
      label328:
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), parambo, "", "", "", "", "", "", "", paramString1 })).aHZ();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label964;
        }
        label470:
        paramLong1 = bs.eWj();
        i = com.tencent.mm.an.c.cD(ai.getContext());
        j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label972;
        }
        parambo = "";
        label495:
        if (paramd != null) {
          break label980;
        }
      }
    }
    label711:
    label972:
    label980:
    for (paramd = "";; paramd = paramd.fqM)
    {
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), parambo, "", "", "", "", "", "", "", paramd })).aHZ();
      o.aFx().doNotify();
      AppMethodBeat.o(150640);
      return 0;
      if (s.aKE(paramString4))
      {
        Object localObject = paramString2 + "_hevc";
        i.ma(paramString4, (String)localObject);
        if (!i.eA(paramString2)) {
          i.aSt(paramString2);
        }
        ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic((String)localObject, paramString2);
        parambo.setStatus(6);
        paramString4 = new PInt();
        localObject = new PInt();
        com.tencent.mm.sdk.platformtools.f.c(paramString2, paramString4, (PInt)localObject);
        parambo.ke(paramString4.value);
        parambo.kf(((PInt)localObject).value);
        ac.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramString4.value), Integer.valueOf(((PInt)localObject).value), paramString3, paramString2 });
        if (!bs.isNullOrNil(parambo.field_talker)) {
          ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().b(parambo.field_msgSvrId, parambo);
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 1L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 2L, 1L, false);
        parambo = com.tencent.mm.plugin.report.service.h.wUl;
        if (!w.sQ(paramString1)) {
          break label931;
        }
      }
      for (paramLong1 = 4L;; paramLong1 = 3L)
      {
        parambo.idkeyStat(198L, paramLong1, 1L, false);
        break;
        i.ma(paramString4, paramString2);
        break label711;
      }
      i = paramd.field_retCode;
      break label296;
      parambo = paramd.field_transInfo;
      break label321;
      paramString1 = paramd.fqM;
      break label328;
      paramInt1 = paramd.field_retCode;
      break label470;
      parambo = paramd.field_transInfo;
      break label495;
    }
  }
  
  public final bo a(cu paramcu, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(150639);
    Object localObject1 = o.aFx();
    paramString3 = super.a(paramcu, paramString1, paramString2, paramString3);
    if (paramString3.field_msgId != 0L)
    {
      AppMethodBeat.o(150639);
      return paramString3;
    }
    final long l1 = paramcu.vTQ;
    paramString2 = ((g)localObject1).qf(l1);
    if (paramString2.dpl == l1)
    {
      i.deleteFile(((g)localObject1).p(paramString2.hGM, "", ""));
      i.deleteFile(((g)localObject1).p(paramString2.hGR, "", ""));
      i.deleteFile(((g)localObject1).p(paramString2.hGO, "", ""));
      i.deleteFile(((g)localObject1).p(paramString2.hGO, "", "") + "hd");
      ((g)localObject1).hpA.delete("ImgInfo2", "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString2.aFa())
      {
        paramString2 = ((g)localObject1).oR(paramString2.hGX);
        if (paramString2 != null)
        {
          i.deleteFile(((g)localObject1).p(paramString2.hGM, "", ""));
          i.deleteFile(((g)localObject1).p(paramString2.hGR, "", ""));
          i.deleteFile(((g)localObject1).p(paramString2.hGO, "", ""));
          i.deleteFile(((g)localObject1).p(paramString2.hGO, "", "") + "hd");
          ((g)localObject1).hpA.delete("ImgInfo2", "id=?", new String[] { paramString2.dcd });
        }
      }
    }
    if (paramcu.DPW != 2)
    {
      ac.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      AppMethodBeat.o(150639);
      return paramString3;
    }
    paramString2 = z.a(paramcu.DPX);
    if (ab.ivM)
    {
      ac.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      paramString2 = null;
    }
    for (;;)
    {
      Object localObject3 = bv.L(paramString3.field_content, "msg");
      l1 = -1L;
      int i;
      final int j;
      if (!bs.isNullOrNil(paramString3.field_content))
      {
        ac.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[] { paramString3.field_content });
        if (localObject3 == null) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 190L, 1L, false);
        }
        if (localObject3 == null) {
          break label1564;
        }
        i = bs.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), 0);
        j = bs.getInt((String)((Map)localObject3).get(".msg.img.$tphdlength"), 0);
        if (i <= 0) {
          break label1144;
        }
        l1 = ((g)localObject1).a(paramString2, paramcu.vTQ, true, paramString3.field_content, new PString(), new PInt(), new PInt());
      }
      for (;;)
      {
        Object localObject2 = bv.L(paramString3.field_content, "msgoperation");
        if (localObject2 != null)
        {
          paramString3.rl((String)((Map)localObject2).get(".msgoperation.expinfo.expidstr"));
          paramString3.kj(bs.getInt((String)((Map)localObject2).get(".msgoperation.imagemsg.downloadcontroltype"), 0));
          ac.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString3.eSk, Integer.valueOf(paramString3.eSl) });
        }
        localObject2 = (String)((Map)localObject3).get(".msg.img.$tpthumburl");
        Object localObject4 = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        final long l2 = ((g)localObject1).a(paramString2, paramcu.vTQ, false, paramString3.field_content, (PString)localObject4, localPInt1, localPInt2);
        if ((bs.cv(paramString2)) && (localObject3 != null) && (!bs.isNullOrNil((String)localObject2)))
        {
          localPInt1.value = bs.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbwidth"), 0);
          localPInt2.value = bs.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbheight"), 0);
        }
        if (l2 > 0L)
        {
          paramString3.rf(((PString)localObject4).value);
          paramString3.ke(localPInt1.value);
          paramString3.kf(localPInt2.value);
          if (l1 > 0L)
          {
            paramcu = o.aFx().c(Long.valueOf(l2));
            paramcu.oQ(1);
            paramcu.oM((int)l1);
            o.aFx().a(Long.valueOf(l2), paramcu);
          }
        }
        if ((bs.cv(paramString2)) && (localObject3 != null) && (!bs.isNullOrNil((String)localObject2)))
        {
          paramcu = (String)((Map)localObject3).get(".msg.img.$tpthumbaeskey");
          j = bs.getInt((String)((Map)localObject3).get(".msg.img.tpthumblength"), 0);
          paramString2 = (String)((Map)localObject3).get(".msg.img.$tpauthkey");
          localObject1 = ((g)localObject1).p(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString3.field_msgSvrId;
          ac.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, localObject2, localObject1 });
          l2 = bs.eWj();
          localObject3 = (String)localObject1 + ".tmp";
          localObject4 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject4).field_mediaId = com.tencent.mm.an.c.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject4).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.i.g)localObject4).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject4).field_aesKey = paramcu;
          ((com.tencent.mm.i.g)localObject4).field_authKey = paramString2;
          ((com.tencent.mm.i.g)localObject4).fre = ((String)localObject2);
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cbj())
          {
            i = 2;
            ((com.tencent.mm.i.g)localObject4).expectImageFormat = i;
            ((com.tencent.mm.i.g)localObject4).frb = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(150637);
                h.a(paramAnonymousInt, paramAnonymousd, paramString3, paramString1, l1, this.hHS, j, l2, this.hHV, this.hHW);
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
            com.tencent.mm.an.f.aDD().b((com.tencent.mm.i.g)localObject4, -1);
          }
        }
        label1144:
        while ((!bs.cv(paramString2)) || (localObject3 == null)) {
          for (;;)
          {
            AppMethodBeat.o(150639);
            return paramString3;
            if (j <= 0) {
              break label1564;
            }
            l1 = ((g)localObject1).a(paramString2, paramcu.vTQ, true, paramString3.field_content, new PString(), new PInt(), new PInt());
            break;
            i = 1;
          }
        }
        paramcu = (String)((Map)localObject3).get(".msg.img.$cdnthumbaeskey");
        paramString2 = (String)((Map)localObject3).get(".msg.img.$cdnthumburl");
        j = bs.getInt((String)((Map)localObject3).get(".msg.img.$cdnthumblength"), 0);
        localObject1 = ((g)localObject1).p(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
        l1 = paramString3.field_msgSvrId;
        ac.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString2, localObject1 });
        l2 = bs.eWj();
        localObject2 = (String)localObject1 + ".tmp";
        localObject3 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.an.c.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
        ((com.tencent.mm.i.g)localObject3).field_fullpath = ((String)localObject2);
        ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.i.g)localObject3).field_totalLen = j;
        ((com.tencent.mm.i.g)localObject3).field_aesKey = paramcu;
        ((com.tencent.mm.i.g)localObject3).field_fileId = paramString2;
        ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fqq;
        if (w.sQ(paramString1))
        {
          i = 1;
          label1446:
          ((com.tencent.mm.i.g)localObject3).field_chattype = i;
          if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cbj()) {
            break label1558;
          }
        }
        label1558:
        for (i = 2;; i = 1)
        {
          ((com.tencent.mm.i.g)localObject3).expectImageFormat = i;
          ac.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.i.g)localObject3).frb = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(150638);
              h.a(paramAnonymousInt, paramAnonymousd, paramString3, paramString1, l1, paramString2, j, l2, this.hHV, this.hHW);
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
          com.tencent.mm.an.f.aDD().b((com.tencent.mm.i.g)localObject3, -1);
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
    o.aFx().J(paramc.dpq);
    AppMethodBeat.o(150641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.h
 * JD-Core Version:    0.7.0.1
 */