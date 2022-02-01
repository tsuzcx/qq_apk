package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.e;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class j
  extends e
{
  public static int a(int paramInt1, d paramd, bv parambv, String paramString1, long paramLong1, String paramString2, String paramString3, int paramInt2, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(150640);
    if (paramInt1 != 0)
    {
      ae.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambv.setStatus(5);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().b(parambv.field_msgSvrId, parambv);
      paramd = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" });
      new com.tencent.mm.g.b.a.j(paramd).aLH();
      new com.tencent.mm.g.b.a.h(paramd).aLH();
      q.aIX().doNotify();
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
      ae.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambv.setStatus(5);
      if (!bu.isNullOrNil(parambv.field_talker)) {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().b(parambv.field_msgSvrId, parambv);
      }
      if (paramd != null) {
        break label939;
      }
      i = paramInt1;
      paramLong1 = bu.fpO();
      j = com.tencent.mm.an.c.cC(ak.getContext());
      int k = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label948;
      }
      parambv = "";
      label321:
      if (paramd != null) {
        break label956;
      }
      paramString1 = "";
      label328:
      new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), parambv, "", "", "", "", "", "", "", paramString1 })).aLH();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label964;
        }
        label470:
        paramLong1 = bu.fpO();
        i = com.tencent.mm.an.c.cC(ak.getContext());
        j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label972;
        }
        parambv = "";
        label495:
        if (paramd != null) {
          break label980;
        }
      }
    }
    label711:
    label972:
    label980:
    for (paramd = "";; paramd = paramd.fKX)
    {
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), parambv, "", "", "", "", "", "", "", paramd })).aLH();
      q.aIX().doNotify();
      AppMethodBeat.o(150640);
      return 0;
      if (u.aRH(paramString4))
      {
        Object localObject = paramString2 + "_hevc";
        o.mG(paramString4, (String)localObject);
        if (!o.fB(paramString2)) {
          o.aZV(paramString2);
        }
        ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic((String)localObject, paramString2);
        parambv.setStatus(6);
        paramString4 = new PInt();
        localObject = new PInt();
        com.tencent.mm.sdk.platformtools.h.c(paramString2, paramString4, (PInt)localObject);
        parambv.kD(paramString4.value);
        parambv.kE(((PInt)localObject).value);
        ae.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramString4.value), Integer.valueOf(((PInt)localObject).value), paramString3, paramString2 });
        if (!bu.isNullOrNil(parambv.field_talker)) {
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().b(parambv.field_msgSvrId, parambv);
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 1L, paramInt2, false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 2L, 1L, false);
        parambv = com.tencent.mm.plugin.report.service.g.yxI;
        if (!x.wb(paramString1)) {
          break label931;
        }
      }
      for (paramLong1 = 4L;; paramLong1 = 3L)
      {
        parambv.idkeyStat(198L, paramLong1, 1L, false);
        break;
        o.mG(paramString4, paramString2);
        break label711;
      }
      i = paramd.field_retCode;
      break label296;
      parambv = paramd.field_transInfo;
      break label321;
      paramString1 = paramd.fKX;
      break label328;
      paramInt1 = paramd.field_retCode;
      break label470;
      parambv = paramd.field_transInfo;
      break label495;
    }
  }
  
  public final bv a(e.a parama, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(218719);
    Object localObject2 = parama.gte;
    Object localObject1 = q.aIX();
    paramString2 = super.a(parama, paramString1, paramString2, paramString3);
    if (paramString2.field_msgId != 0L)
    {
      AppMethodBeat.o(218719);
      return paramString2;
    }
    parama = paramString2.field_talker;
    final long l1 = ((cv)localObject2).xrk;
    paramString3 = ((i)localObject1).F(parama, l1);
    if (paramString3.dCd == l1)
    {
      o.deleteFile(((i)localObject1).o(paramString3.ico, "", ""));
      o.deleteFile(((i)localObject1).o(paramString3.ict, "", ""));
      o.deleteFile(((i)localObject1).o(paramString3.icq, "", ""));
      o.deleteFile(((i)localObject1).o(paramString3.icq, "", "") + "hd");
      ((i)localObject1).hKK.delete(i.d.FW(parama), "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString3.aIB())
      {
        paramString3 = ((i)localObject1).pw(paramString3.icz);
        if (paramString3 != null)
        {
          o.deleteFile(((i)localObject1).o(paramString3.ico, "", ""));
          o.deleteFile(((i)localObject1).o(paramString3.ict, "", ""));
          o.deleteFile(((i)localObject1).o(paramString3.icq, "", ""));
          o.deleteFile(((i)localObject1).o(paramString3.icq, "", "") + "hd");
          ((i)localObject1).hKK.delete(i.d.FW(parama), "id=?", new String[] { paramString3.doE });
        }
      }
    }
    if (((cv)localObject2).FNJ != 2)
    {
      ae.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      AppMethodBeat.o(218719);
      return paramString2;
    }
    parama = z.a(((cv)localObject2).FNK);
    if (ac.iRN)
    {
      ae.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      parama = null;
    }
    for (;;)
    {
      Object localObject3 = bx.M(paramString2.field_content, "msg");
      int i;
      final int j;
      if (!bu.isNullOrNil(paramString2.field_content))
      {
        ae.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[] { paramString2.field_content });
        if (localObject3 == null) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 190L, 1L, false);
        }
        if (localObject3 != null)
        {
          i = bu.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), 0);
          j = bu.getInt((String)((Map)localObject3).get(".msg.img.$tphdlength"), 0);
          if (i > 0)
          {
            l1 = ((i)localObject1).a(paramString2.field_talker, parama, ((cv)localObject2).xrk, true, paramString2.field_content, new PString(), new PInt(), new PInt());
            paramString3 = bx.M(paramString2.field_content, "msgoperation");
            if (paramString3 != null)
            {
              paramString2.us((String)paramString3.get(".msgoperation.expinfo.expidstr"));
              paramString2.kI(bu.getInt((String)paramString3.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
              ae.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString2.fmw, Integer.valueOf(paramString2.fmx) });
            }
          }
        }
      }
      for (;;)
      {
        paramString3 = (String)((Map)localObject3).get(".msg.img.$tpthumburl");
        Object localObject4 = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        final long l2 = ((i)localObject1).a(paramString2.field_talker, parama, ((cv)localObject2).xrk, false, paramString2.field_content, (PString)localObject4, localPInt1, localPInt2);
        if ((bu.cF(parama)) && (localObject3 != null) && (!bu.isNullOrNil(paramString3)))
        {
          localPInt1.value = bu.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbwidth"), 0);
          localPInt2.value = bu.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbheight"), 0);
        }
        if (l2 > 0L)
        {
          paramString2.uj(((PString)localObject4).value);
          paramString2.kD(localPInt1.value);
          paramString2.kE(localPInt2.value);
          if (l1 > 0L)
          {
            localObject2 = q.aIX().c(Long.valueOf(l2));
            ((g)localObject2).pv(1);
            ((g)localObject2).pr((int)l1);
            q.aIX().a(Long.valueOf(l2), (g)localObject2);
          }
        }
        if ((bu.cF(parama)) && (localObject3 != null) && (!bu.isNullOrNil(paramString3)))
        {
          parama = (String)((Map)localObject3).get(".msg.img.$tpthumbaeskey");
          j = bu.getInt((String)((Map)localObject3).get(".msg.img.tpthumblength"), 0);
          localObject2 = (String)((Map)localObject3).get(".msg.img.$tpauthkey");
          localObject1 = ((i)localObject1).o(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString2.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString2.field_msgSvrId;
          ae.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString3, localObject1 });
          l2 = bu.fpO();
          localObject3 = (String)localObject1 + ".tmp";
          localObject4 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject4).fLl = "task_ImgMsgExtension_1";
          ((com.tencent.mm.i.g)localObject4).field_mediaId = com.tencent.mm.an.c.a("downimgthumb", paramString2.field_createTime, paramString1, String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject4).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.i.g)localObject4).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject4).field_aesKey = parama;
          ((com.tencent.mm.i.g)localObject4).field_authKey = ((String)localObject2);
          ((com.tencent.mm.i.g)localObject4).fLp = paramString3;
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).chd())
          {
            i = 2;
            ((com.tencent.mm.i.g)localObject4).expectImageFormat = i;
            ((com.tencent.mm.i.g)localObject4).fLm = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(150637);
                j.a(paramAnonymousInt, paramAnonymousd, paramString2, paramString1, l1, paramString3, j, l2, this.idC, this.idD);
                AppMethodBeat.o(150637);
                return 0;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            paramString2.setStatus(4);
            f.aGZ().b((com.tencent.mm.i.g)localObject4, -1);
          }
        }
        while ((!bu.cF(parama)) || (localObject3 == null)) {
          for (;;)
          {
            AppMethodBeat.o(218719);
            return paramString2;
            if (j <= 0) {
              break label1603;
            }
            l1 = ((i)localObject1).a(paramString2.field_talker, parama, ((cv)localObject2).xrk, true, paramString2.field_content, new PString(), new PInt(), new PInt());
            break;
            i = 1;
          }
        }
        parama = (String)((Map)localObject3).get(".msg.img.$cdnthumbaeskey");
        paramString3 = (String)((Map)localObject3).get(".msg.img.$cdnthumburl");
        j = bu.getInt((String)((Map)localObject3).get(".msg.img.$cdnthumblength"), 0);
        localObject1 = ((i)localObject1).o(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString2.field_msgSvrId).getBytes()), "th_", "");
        l1 = paramString2.field_msgSvrId;
        ae.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString3, localObject1 });
        l2 = bu.fpO();
        localObject2 = (String)localObject1 + ".tmp";
        localObject3 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject3).fLl = "task_ImgMsgExtension_2";
        ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.an.c.a("downimgthumb", paramString2.field_createTime, paramString1, String.valueOf(l1));
        ((com.tencent.mm.i.g)localObject3).field_fullpath = ((String)localObject2);
        ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.i.g)localObject3).field_totalLen = j;
        ((com.tencent.mm.i.g)localObject3).field_aesKey = parama;
        ((com.tencent.mm.i.g)localObject3).field_fileId = paramString3;
        ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fKB;
        if (x.wb(paramString1))
        {
          i = 1;
          label1486:
          ((com.tencent.mm.i.g)localObject3).field_chattype = i;
          if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).chd()) {
            break label1597;
          }
        }
        label1597:
        for (i = 2;; i = 1)
        {
          ((com.tencent.mm.i.g)localObject3).expectImageFormat = i;
          ae.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.i.g)localObject3).fLm = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(150638);
              j.a(paramAnonymousInt, paramAnonymousd, paramString2, paramString1, l1, paramString3, j, l2, this.idC, this.idD);
              AppMethodBeat.o(150638);
              return 0;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return null;
            }
          };
          paramString2.setStatus(4);
          f.aGZ().b((com.tencent.mm.i.g)localObject3, -1);
          break;
          i = 0;
          break label1486;
        }
        label1603:
        l1 = -1L;
        break;
        l1 = -1L;
      }
    }
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(150641);
    q.aIX().M(paramc.dCi);
    AppMethodBeat.o(150641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.j
 * JD-Core Version:    0.7.0.1
 */