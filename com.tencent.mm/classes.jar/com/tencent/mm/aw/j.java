package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.ao.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.e;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class j
  extends e
{
  public static int a(int paramInt1, d paramd, bu parambu, String paramString1, long paramLong1, String paramString2, String paramString3, int paramInt2, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(150640);
    if (paramInt1 != 0)
    {
      ad.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      parambu.setStatus(5);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().b(parambu.field_msgSvrId, parambu);
      paramd = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" });
      new com.tencent.mm.g.b.a.j(paramd).aLk();
      new com.tencent.mm.g.b.a.h(paramd).aLk();
      q.aIF().doNotify();
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
      parambu.setStatus(5);
      if (!bt.isNullOrNil(parambu.field_talker)) {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().b(parambu.field_msgSvrId, parambu);
      }
      if (paramd != null) {
        break label939;
      }
      i = paramInt1;
      paramLong1 = bt.flT();
      j = com.tencent.mm.ao.c.cA(aj.getContext());
      int k = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label948;
      }
      parambu = "";
      label321:
      if (paramd != null) {
        break label956;
      }
      paramString1 = "";
      label328:
      new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), parambu, "", "", "", "", "", "", "", paramString1 })).aLk();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label964;
        }
        label470:
        paramLong1 = bt.flT();
        i = com.tencent.mm.ao.c.cA(aj.getContext());
        j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label972;
        }
        parambu = "";
        label495:
        if (paramd != null) {
          break label980;
        }
      }
    }
    label711:
    label972:
    label980:
    for (paramd = "";; paramd = paramd.fIT)
    {
      new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), parambu, "", "", "", "", "", "", "", paramd })).aLk();
      q.aIF().doNotify();
      AppMethodBeat.o(150640);
      return 0;
      if (t.aQk(paramString4))
      {
        Object localObject = paramString2 + "_hevc";
        com.tencent.mm.vfs.i.mA(paramString4, (String)localObject);
        if (!com.tencent.mm.vfs.i.fv(paramString2)) {
          com.tencent.mm.vfs.i.aYs(paramString2);
        }
        ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic((String)localObject, paramString2);
        parambu.setStatus(6);
        paramString4 = new PInt();
        localObject = new PInt();
        com.tencent.mm.sdk.platformtools.g.c(paramString2, paramString4, (PInt)localObject);
        parambu.kB(paramString4.value);
        parambu.kC(((PInt)localObject).value);
        ad.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramString4.value), Integer.valueOf(((PInt)localObject).value), paramString3, paramString2 });
        if (!bt.isNullOrNil(parambu.field_talker)) {
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().b(parambu.field_msgSvrId, parambu);
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 1L, paramInt2, false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 2L, 1L, false);
        parambu = com.tencent.mm.plugin.report.service.g.yhR;
        if (!w.vF(paramString1)) {
          break label931;
        }
      }
      for (paramLong1 = 4L;; paramLong1 = 3L)
      {
        parambu.idkeyStat(198L, paramLong1, 1L, false);
        break;
        com.tencent.mm.vfs.i.mA(paramString4, paramString2);
        break label711;
      }
      i = paramd.field_retCode;
      break label296;
      parambu = paramd.field_transInfo;
      break label321;
      paramString1 = paramd.fIT;
      break label328;
      paramInt1 = paramd.field_retCode;
      break label470;
      parambu = paramd.field_transInfo;
      break label495;
    }
  }
  
  public final bu a(e.a parama, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(195268);
    Object localObject2 = parama.gqE;
    Object localObject1 = q.aIF();
    paramString2 = super.a(parama, paramString1, paramString2, paramString3);
    if (paramString2.field_msgId != 0L)
    {
      AppMethodBeat.o(195268);
      return paramString2;
    }
    parama = paramString2.field_talker;
    final long l1 = ((cv)localObject2).xbt;
    paramString3 = ((i)localObject1).F(parama, l1);
    if (paramString3.dAY == l1)
    {
      com.tencent.mm.vfs.i.deleteFile(((i)localObject1).o(paramString3.hZw, "", ""));
      com.tencent.mm.vfs.i.deleteFile(((i)localObject1).o(paramString3.hZB, "", ""));
      com.tencent.mm.vfs.i.deleteFile(((i)localObject1).o(paramString3.hZy, "", ""));
      com.tencent.mm.vfs.i.deleteFile(((i)localObject1).o(paramString3.hZy, "", "") + "hd");
      ((i)localObject1).hHS.delete(i.d.Fu(parama), "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString3.aIj())
      {
        paramString3 = ((i)localObject1).pt(paramString3.hZH);
        if (paramString3 != null)
        {
          com.tencent.mm.vfs.i.deleteFile(((i)localObject1).o(paramString3.hZw, "", ""));
          com.tencent.mm.vfs.i.deleteFile(((i)localObject1).o(paramString3.hZB, "", ""));
          com.tencent.mm.vfs.i.deleteFile(((i)localObject1).o(paramString3.hZy, "", ""));
          com.tencent.mm.vfs.i.deleteFile(((i)localObject1).o(paramString3.hZy, "", "") + "hd");
          ((i)localObject1).hHS.delete(i.d.Fu(parama), "id=?", new String[] { paramString3.dnz });
        }
      }
    }
    if (((cv)localObject2).Fvl != 2)
    {
      ad.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      AppMethodBeat.o(195268);
      return paramString2;
    }
    parama = z.a(((cv)localObject2).Fvm);
    if (ac.iOT)
    {
      ad.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      parama = null;
    }
    for (;;)
    {
      Object localObject3 = bw.M(paramString2.field_content, "msg");
      int i;
      final int j;
      if (!bt.isNullOrNil(paramString2.field_content))
      {
        ad.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[] { paramString2.field_content });
        if (localObject3 == null) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 190L, 1L, false);
        }
        if (localObject3 != null)
        {
          i = bt.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), 0);
          j = bt.getInt((String)((Map)localObject3).get(".msg.img.$tphdlength"), 0);
          if (i > 0)
          {
            l1 = ((i)localObject1).a(paramString2.field_talker, parama, ((cv)localObject2).xbt, true, paramString2.field_content, new PString(), new PInt(), new PInt());
            paramString3 = bw.M(paramString2.field_content, "msgoperation");
            if (paramString3 != null)
            {
              paramString2.tX((String)paramString3.get(".msgoperation.expinfo.expidstr"));
              paramString2.kG(bt.getInt((String)paramString3.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
              ad.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString2.fkz, Integer.valueOf(paramString2.fkA) });
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
        final long l2 = ((i)localObject1).a(paramString2.field_talker, parama, ((cv)localObject2).xbt, false, paramString2.field_content, (PString)localObject4, localPInt1, localPInt2);
        if ((bt.cC(parama)) && (localObject3 != null) && (!bt.isNullOrNil(paramString3)))
        {
          localPInt1.value = bt.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbwidth"), 0);
          localPInt2.value = bt.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbheight"), 0);
        }
        if (l2 > 0L)
        {
          paramString2.tO(((PString)localObject4).value);
          paramString2.kB(localPInt1.value);
          paramString2.kC(localPInt2.value);
          if (l1 > 0L)
          {
            localObject2 = q.aIF().c(Long.valueOf(l2));
            ((g)localObject2).ps(1);
            ((g)localObject2).po((int)l1);
            q.aIF().a(Long.valueOf(l2), (g)localObject2);
          }
        }
        if ((bt.cC(parama)) && (localObject3 != null) && (!bt.isNullOrNil(paramString3)))
        {
          parama = (String)((Map)localObject3).get(".msg.img.$tpthumbaeskey");
          j = bt.getInt((String)((Map)localObject3).get(".msg.img.tpthumblength"), 0);
          localObject2 = (String)((Map)localObject3).get(".msg.img.$tpauthkey");
          localObject1 = ((i)localObject1).o(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString2.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString2.field_msgSvrId;
          ad.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString3, localObject1 });
          l2 = bt.flT();
          localObject3 = (String)localObject1 + ".tmp";
          localObject4 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject4).fJi = "task_ImgMsgExtension_1";
          ((com.tencent.mm.i.g)localObject4).field_mediaId = com.tencent.mm.ao.c.a("downimgthumb", paramString2.field_createTime, paramString1, String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject4).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.i.g)localObject4).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject4).field_aesKey = parama;
          ((com.tencent.mm.i.g)localObject4).field_authKey = ((String)localObject2);
          ((com.tencent.mm.i.g)localObject4).fJm = paramString3;
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cfN())
          {
            i = 2;
            ((com.tencent.mm.i.g)localObject4).expectImageFormat = i;
            ((com.tencent.mm.i.g)localObject4).fJj = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(150637);
                j.a(paramAnonymousInt, paramAnonymousd, paramString2, paramString1, l1, paramString3, j, l2, this.iaJ, this.iaK);
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
            f.aGI().b((com.tencent.mm.i.g)localObject4, -1);
          }
        }
        while ((!bt.cC(parama)) || (localObject3 == null)) {
          for (;;)
          {
            AppMethodBeat.o(195268);
            return paramString2;
            if (j <= 0) {
              break label1603;
            }
            l1 = ((i)localObject1).a(paramString2.field_talker, parama, ((cv)localObject2).xbt, true, paramString2.field_content, new PString(), new PInt(), new PInt());
            break;
            i = 1;
          }
        }
        parama = (String)((Map)localObject3).get(".msg.img.$cdnthumbaeskey");
        paramString3 = (String)((Map)localObject3).get(".msg.img.$cdnthumburl");
        j = bt.getInt((String)((Map)localObject3).get(".msg.img.$cdnthumblength"), 0);
        localObject1 = ((i)localObject1).o(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString2.field_msgSvrId).getBytes()), "th_", "");
        l1 = paramString2.field_msgSvrId;
        ad.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString3, localObject1 });
        l2 = bt.flT();
        localObject2 = (String)localObject1 + ".tmp";
        localObject3 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject3).fJi = "task_ImgMsgExtension_2";
        ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.ao.c.a("downimgthumb", paramString2.field_createTime, paramString1, String.valueOf(l1));
        ((com.tencent.mm.i.g)localObject3).field_fullpath = ((String)localObject2);
        ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.i.g)localObject3).field_totalLen = j;
        ((com.tencent.mm.i.g)localObject3).field_aesKey = parama;
        ((com.tencent.mm.i.g)localObject3).field_fileId = paramString3;
        ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fIx;
        if (w.vF(paramString1))
        {
          i = 1;
          label1486:
          ((com.tencent.mm.i.g)localObject3).field_chattype = i;
          if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cfN()) {
            break label1597;
          }
        }
        label1597:
        for (i = 2;; i = 1)
        {
          ((com.tencent.mm.i.g)localObject3).expectImageFormat = i;
          ad.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.i.g)localObject3).fJj = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(150638);
              j.a(paramAnonymousInt, paramAnonymousd, paramString2, paramString1, l1, paramString3, j, l2, this.iaJ, this.iaK);
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
          f.aGI().b((com.tencent.mm.i.g)localObject3, -1);
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
    q.aIF().M(paramc.dBd);
    AppMethodBeat.o(150641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.j
 * JD-Core Version:    0.7.0.1
 */