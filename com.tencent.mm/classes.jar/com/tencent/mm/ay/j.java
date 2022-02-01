package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.aq.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class j
  extends e
{
  public static int a(int paramInt1, d paramd, ca paramca, String paramString1, long paramLong1, String paramString2, String paramString3, int paramInt2, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(150640);
    if (paramInt1 != 0)
    {
      Log.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      paramca.setStatus(5);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().b(paramca.field_msgSvrId, paramca);
      paramd = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramInt2), "" });
      new ae(paramd).bpa();
      new com.tencent.mm.f.b.a.ac(paramd).bpa();
      q.bmh().doNotify();
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
      Log.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, paramString3, paramString2 });
      paramca.setStatus(5);
      if (!Util.isNullOrNil(paramca.field_talker)) {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().b(paramca.field_msgSvrId, paramca);
      }
      if (paramd != null) {
        break label939;
      }
      i = paramInt1;
      paramLong1 = Util.nowMilliSecond();
      j = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
      int k = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      if (paramd != null) {
        break label948;
      }
      paramca = "";
      label321:
      if (paramd != null) {
        break label956;
      }
      paramString1 = "";
      label328:
      new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), paramca, "", "", "", "", "", "", "", paramString1 })).bpa();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label964;
        }
        label470:
        paramLong1 = Util.nowMilliSecond();
        i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
        j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        if (paramd != null) {
          break label972;
        }
        paramca = "";
        label495:
        if (paramd != null) {
          break label980;
        }
      }
    }
    label711:
    label972:
    label980:
    for (paramd = "";; paramd = paramd.iUs)
    {
      new com.tencent.mm.f.b.a.ac(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramca, "", "", "", "", "", "", "", paramd })).bpa();
      q.bmh().doNotify();
      AppMethodBeat.o(150640);
      return 0;
      if (ImgUtil.isWXGF(paramString4))
      {
        Object localObject = paramString2 + "_hevc";
        u.oo(paramString4, (String)localObject);
        if (!u.agG(paramString2)) {
          u.bBV(paramString2);
        }
        ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic((String)localObject, paramString2);
        paramca.setStatus(6);
        paramString4 = new PInt();
        localObject = new PInt();
        BitmapUtil.getRent(paramString2, paramString4, (PInt)localObject);
        paramca.pW(paramString4.value);
        paramca.pX(((PInt)localObject).value);
        Log.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramString4.value), Integer.valueOf(((PInt)localObject).value), paramString3, paramString2 });
        if (!Util.isNullOrNil(paramca.field_talker)) {
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().b(paramca.field_msgSvrId, paramca);
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 1L, paramInt2, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 2L, 1L, false);
        paramca = com.tencent.mm.plugin.report.service.h.IzE;
        if (!ab.Lj(paramString1)) {
          break label931;
        }
      }
      for (paramLong1 = 4L;; paramLong1 = 3L)
      {
        paramca.idkeyStat(198L, paramLong1, 1L, false);
        break;
        u.oo(paramString4, paramString2);
        break label711;
      }
      i = paramd.field_retCode;
      break label296;
      paramca = paramd.field_transInfo;
      break label321;
      paramString1 = paramd.iUs;
      break label328;
      paramInt1 = paramd.field_retCode;
      break label470;
      paramca = paramd.field_transInfo;
      break label495;
    }
  }
  
  public final ca a(h.a parama, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(204952);
    Object localObject2 = parama.jQG;
    Object localObject1 = q.bmh();
    paramString2 = super.a(parama, paramString1, paramString2, paramString3);
    if (paramString2.field_msgId != 0L)
    {
      AppMethodBeat.o(204952);
      return paramString2;
    }
    parama = paramString2.field_talker;
    final long l1 = ((db)localObject2).HlH;
    paramString3 = ((i)localObject1).C(parama, l1);
    if (paramString3.fNu == l1)
    {
      u.deleteFile(((i)localObject1).r(paramString3.lNH, "", ""));
      u.deleteFile(((i)localObject1).r(paramString3.lNM, "", ""));
      u.deleteFile(((i)localObject1).r(paramString3.lNJ, "", ""));
      u.deleteFile(((i)localObject1).r(paramString3.lNJ, "", "") + "hd");
      ((i)localObject1).lvy.delete(i.d.Wf(parama), "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString3.blK())
      {
        paramString3 = ((i)localObject1).wl(paramString3.lNR);
        if (paramString3 != null)
        {
          u.deleteFile(((i)localObject1).r(paramString3.lNH, "", ""));
          u.deleteFile(((i)localObject1).r(paramString3.lNM, "", ""));
          u.deleteFile(((i)localObject1).r(paramString3.lNJ, "", ""));
          u.deleteFile(((i)localObject1).r(paramString3.lNJ, "", "") + "hd");
          ((i)localObject1).lvy.delete(i.d.Wf(parama), "id=?", new String[] { paramString3.localId });
        }
      }
    }
    if (((db)localObject2).RIG != 2)
    {
      Log.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      AppMethodBeat.o(204952);
      return paramString2;
    }
    parama = z.a(((db)localObject2).RIH);
    if (com.tencent.mm.platformtools.ac.mFS)
    {
      Log.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      parama = null;
    }
    for (;;)
    {
      Object localObject3 = XmlParser.parseXml(paramString2.field_content, "msg", null);
      int i;
      final int j;
      if (!Util.isNullOrNil(paramString2.field_content))
      {
        Log.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[] { paramString2.field_content });
        if (localObject3 == null) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 190L, 1L, false);
        }
        if (localObject3 != null)
        {
          i = Util.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), 0);
          j = Util.getInt((String)((Map)localObject3).get(".msg.img.$tphdlength"), 0);
          if (i > 0)
          {
            l1 = ((i)localObject1).a(paramString2.field_talker, parama, ((db)localObject2).HlH, true, paramString2.field_content, new PString(), new PInt(), new PInt());
            paramString3 = XmlParser.parseXml(paramString2.field_content, "msgoperation", null);
            if (paramString3 != null)
            {
              paramString2.Jw((String)paramString3.get(".msgoperation.expinfo.expidstr"));
              paramString2.qa(Util.getInt((String)paramString3.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
              Log.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString2.ilq, Integer.valueOf(paramString2.ilr) });
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
        final long l2 = ((i)localObject1).a(paramString2.field_talker, parama, ((db)localObject2).HlH, false, paramString2.field_content, (PString)localObject4, localPInt1, localPInt2);
        if ((Util.isNullOrNil(parama)) && (localObject3 != null) && (!Util.isNullOrNil(paramString3)))
        {
          localPInt1.value = Util.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbwidth"), 0);
          localPInt2.value = Util.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbheight"), 0);
        }
        if (l2 > 0L)
        {
          paramString2.Jn(((PString)localObject4).value);
          paramString2.pW(localPInt1.value);
          paramString2.pX(localPInt2.value);
          if (l1 > 0L)
          {
            localObject2 = q.bmh().b(Long.valueOf(l2));
            ((g)localObject2).wk(1);
            ((g)localObject2).wg((int)l1);
            q.bmh().a(Long.valueOf(l2), (g)localObject2);
          }
        }
        if ((Util.isNullOrNil(parama)) && (localObject3 != null) && (!Util.isNullOrNil(paramString3)))
        {
          parama = (String)((Map)localObject3).get(".msg.img.$tpthumbaeskey");
          j = Util.getInt((String)((Map)localObject3).get(".msg.img.tpthumblength"), 0);
          localObject2 = (String)((Map)localObject3).get(".msg.img.$tpauthkey");
          localObject1 = ((i)localObject1).r(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString2.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString2.field_msgSvrId;
          Log.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString3, localObject1 });
          l2 = Util.nowMilliSecond();
          localObject3 = (String)localObject1 + ".tmp";
          localObject4 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject4).taskName = "task_ImgMsgExtension_1";
          ((com.tencent.mm.i.g)localObject4).field_mediaId = com.tencent.mm.aq.c.a("downimgthumb", paramString2.field_createTime, paramString1, String.valueOf(l1));
          ((com.tencent.mm.i.g)localObject4).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.i.g)localObject4).field_fileType = 19;
          ((com.tencent.mm.i.g)localObject4).field_aesKey = parama;
          ((com.tencent.mm.i.g)localObject4).field_authKey = ((String)localObject2);
          ((com.tencent.mm.i.g)localObject4).iUJ = paramString3;
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).cTu())
          {
            i = 2;
            ((com.tencent.mm.i.g)localObject4).expectImageFormat = i;
            ((com.tencent.mm.i.g)localObject4).iUG = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(150637);
                j.a(paramAnonymousInt, paramAnonymousd, paramString2, paramString1, l1, paramString3, j, l2, this.val$startTime, this.lOT);
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
            f.bkg().b((com.tencent.mm.i.g)localObject4, -1);
          }
        }
        while ((!Util.isNullOrNil(parama)) || (localObject3 == null)) {
          for (;;)
          {
            AppMethodBeat.o(204952);
            return paramString2;
            if (j <= 0) {
              break label1605;
            }
            l1 = ((i)localObject1).a(paramString2.field_talker, parama, ((db)localObject2).HlH, true, paramString2.field_content, new PString(), new PInt(), new PInt());
            break;
            i = 1;
          }
        }
        parama = (String)((Map)localObject3).get(".msg.img.$cdnthumbaeskey");
        paramString3 = (String)((Map)localObject3).get(".msg.img.$cdnthumburl");
        j = Util.getInt((String)((Map)localObject3).get(".msg.img.$cdnthumblength"), 0);
        localObject1 = ((i)localObject1).r(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString2.field_msgSvrId).getBytes()), "th_", "");
        l1 = paramString2.field_msgSvrId;
        Log.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString3, localObject1 });
        l2 = Util.nowMilliSecond();
        localObject2 = (String)localObject1 + ".tmp";
        localObject3 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject3).taskName = "task_ImgMsgExtension_2";
        ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.aq.c.a("downimgthumb", paramString2.field_createTime, paramString1, String.valueOf(l1));
        ((com.tencent.mm.i.g)localObject3).field_fullpath = ((String)localObject2);
        ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.i.g)localObject3).field_totalLen = j;
        ((com.tencent.mm.i.g)localObject3).field_aesKey = parama;
        ((com.tencent.mm.i.g)localObject3).field_fileId = paramString3;
        ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.iTV;
        if (ab.Lj(paramString1))
        {
          i = 1;
          label1488:
          ((com.tencent.mm.i.g)localObject3).field_chattype = i;
          if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).cTu()) {
            break label1599;
          }
        }
        label1599:
        for (i = 2;; i = 1)
        {
          ((com.tencent.mm.i.g)localObject3).expectImageFormat = i;
          Log.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.i.g)localObject3).iUG = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(150638);
              j.a(paramAnonymousInt, paramAnonymousd, paramString2, paramString1, l1, paramString3, j, l2, this.val$startTime, this.lOT);
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
          f.bkg().b((com.tencent.mm.i.g)localObject3, -1);
          break;
          i = 0;
          break label1488;
        }
        label1605:
        l1 = -1L;
        break;
        l1 = -1L;
      }
    }
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(150641);
    q.bmh().ab(paramc.fNz);
    AppMethodBeat.o(150641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.j
 * JD-Core Version:    0.7.0.1
 */