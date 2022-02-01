package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.a;
import com.tencent.mm.g.d;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class k
  extends e
{
  public static int a(int paramInt1, d paramd, cc paramcc, String paramString1, long paramLong, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(238975);
    if (paramInt1 != 0)
    {
      Log.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString1, paramString3, paramString2 });
      paramcc.setStatus(5);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().b(paramcc.field_msgSvrId, paramcc);
      r.bKa().doNotify();
      AppMethodBeat.o(238975);
      return 0;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(238975);
      return 0;
    }
    if (paramd.field_retCode != 0)
    {
      Log.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong), paramString1, paramString3, paramString2 });
      paramcc.setStatus(5);
      if (!Util.isNullOrNil(paramcc.field_talker)) {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().b(paramcc.field_msgSvrId, paramcc);
      }
      r.bKa().doNotify();
      AppMethodBeat.o(238975);
      return 0;
    }
    if (ImgUtil.isWXGF(paramString4))
    {
      Object localObject = paramString2 + "_hevc";
      y.qn(paramString4, (String)localObject);
      if (!y.ZC(paramString2)) {
        y.bEp(paramString2);
      }
      ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).nativeWxam2Pic((String)localObject, paramString2);
      label272:
      paramcc.setStatus(6);
      paramString4 = new PInt();
      localObject = new PInt();
      BitmapUtil.getRent(paramString2, paramString4, (PInt)localObject);
      paramcc.pW(paramString4.value);
      paramcc.pX(((PInt)localObject).value);
      Log.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramd.field_retCode), Long.valueOf(paramLong), paramString1, Integer.valueOf(paramString4.value), Integer.valueOf(((PInt)localObject).value), paramString3, paramString2 });
      if (!Util.isNullOrNil(paramcc.field_talker)) {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().b(paramcc.field_msgSvrId, paramcc);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 1L, paramInt2, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 2L, 1L, false);
      paramd = com.tencent.mm.plugin.report.service.h.OAn;
      if (!au.bwE(paramString1)) {
        break label492;
      }
    }
    label492:
    for (paramLong = 4L;; paramLong = 3L)
    {
      paramd.idkeyStat(198L, paramLong, 1L, false);
      break;
      y.qn(paramString4, paramString2);
      break label272;
    }
  }
  
  public final cc a(com.tencent.mm.am.g.a parama, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(238981);
    Object localObject2 = parama.mpN;
    Object localObject1 = r.bKa();
    paramString2 = super.a(parama, paramString1, paramString2, paramString3);
    if (paramString2.field_msgId != 0L)
    {
      AppMethodBeat.o(238981);
      return paramString2;
    }
    parama = paramString2.field_talker;
    final long l1 = ((dl)localObject2).Njv;
    paramString3 = ((j)localObject1).G(parama, l1);
    if ((paramString3 == null) || (paramString3.hTh != l1)) {}
    while (((dl)localObject2).YFH != 2)
    {
      Log.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      AppMethodBeat.o(238981);
      return paramString2;
      y.deleteFile(((j)localObject1).v(paramString3.oGr, "", ""));
      y.deleteFile(((j)localObject1).v(paramString3.oGw, "", ""));
      y.deleteFile(((j)localObject1).v(paramString3.oGt, "", ""));
      y.deleteFile(((j)localObject1).v(paramString3.oGt, "", "") + "hd");
      ((j)localObject1).omV.delete(j.d.Og(parama), "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString3.bJE())
      {
        paramString3 = ((j)localObject1).wq(paramString3.oGB);
        if (paramString3 != null)
        {
          y.deleteFile(((j)localObject1).v(paramString3.oGr, "", ""));
          y.deleteFile(((j)localObject1).v(paramString3.oGw, "", ""));
          y.deleteFile(((j)localObject1).v(paramString3.oGt, "", ""));
          y.deleteFile(((j)localObject1).v(paramString3.oGt, "", "") + "hd");
          ((j)localObject1).omV.delete(j.d.Og(parama), "id=?", new String[] { paramString3.localId });
        }
      }
    }
    parama = w.a(((dl)localObject2).YFI);
    if (z.pCs)
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 190L, 1L, false);
        }
        if (localObject3 != null)
        {
          i = Util.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), 0);
          j = Util.getInt((String)((Map)localObject3).get(".msg.img.$tphdlength"), 0);
          if (i > 0)
          {
            l1 = ((j)localObject1).a(paramString2.field_talker, parama, ((dl)localObject2).Njv, true, paramString2.field_content, new PString(), new PInt(), new PInt());
            paramString3 = XmlParser.parseXml(paramString2.field_content, "msgoperation", null);
            if (paramString3 != null)
            {
              paramString2.Cc((String)paramString3.get(".msgoperation.expinfo.expidstr"));
              paramString2.qa(Util.getInt((String)paramString3.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
              Log.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString2.kLp, Integer.valueOf(paramString2.kLq) });
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
        final long l2 = ((j)localObject1).a(paramString2.field_talker, parama, ((dl)localObject2).Njv, false, paramString2.field_content, (PString)localObject4, localPInt1, localPInt2);
        if ((Util.isNullOrNil(parama)) && (localObject3 != null) && (!Util.isNullOrNil(paramString3)))
        {
          localPInt1.value = Util.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbwidth"), 0);
          localPInt2.value = Util.getInt((String)((Map)localObject3).get(".msg.img.$tpthumbheight"), 0);
        }
        if (l2 > 0L)
        {
          paramString2.BT(((PString)localObject4).value);
          paramString2.pW(localPInt1.value);
          paramString2.pX(localPInt2.value);
          if (l1 > 0L)
          {
            localObject2 = r.bKa().b(Long.valueOf(l2));
            ((h)localObject2).wp(1);
            ((h)localObject2).wl((int)l1);
            r.bKa().a(Long.valueOf(l2), (h)localObject2);
          }
        }
        if ((Util.isNullOrNil(parama)) && (localObject3 != null) && (!Util.isNullOrNil(paramString3)))
        {
          parama = (String)((Map)localObject3).get(".msg.img.$tpthumbaeskey");
          j = Util.getInt((String)((Map)localObject3).get(".msg.img.tpthumblength"), 0);
          localObject2 = (String)((Map)localObject3).get(".msg.img.$tpauthkey");
          localObject1 = ((j)localObject1).v(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString2.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString2.field_msgSvrId;
          Log.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString3, localObject1 });
          l2 = Util.nowMilliSecond();
          localObject3 = (String)localObject1 + ".tmp";
          localObject4 = new com.tencent.mm.g.g();
          ((com.tencent.mm.g.g)localObject4).taskName = "task_ImgMsgExtension_1";
          ((com.tencent.mm.g.g)localObject4).field_mediaId = com.tencent.mm.modelcdntran.h.a("downimgthumb", paramString2.getCreateTime(), paramString1, String.valueOf(l1));
          ((com.tencent.mm.g.g)localObject4).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.g.g)localObject4).field_fileType = 19;
          ((com.tencent.mm.g.g)localObject4).field_aesKey = parama;
          ((com.tencent.mm.g.g)localObject4).field_authKey = ((String)localObject2);
          ((com.tencent.mm.g.g)localObject4).lwO = paramString3;
          if (((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).dxP())
          {
            i = 2;
            ((com.tencent.mm.g.g)localObject4).expectImageFormat = i;
            ((com.tencent.mm.g.g)localObject4).lwL = new com.tencent.mm.g.g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(150637);
                k.a(paramAnonymousInt, paramAnonymousd, paramString2, paramString1, l1, paramString3, j, l2, this.oHD);
                AppMethodBeat.o(150637);
                return 0;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            paramString2.setStatus(4);
            com.tencent.mm.modelcdntran.k.bHW().b((com.tencent.mm.g.g)localObject4, -1);
          }
        }
        while ((!Util.isNullOrNil(parama)) || (localObject3 == null)) {
          for (;;)
          {
            AppMethodBeat.o(238981);
            return paramString2;
            if (j <= 0) {
              break label1609;
            }
            l1 = ((j)localObject1).a(paramString2.field_talker, parama, ((dl)localObject2).Njv, true, paramString2.field_content, new PString(), new PInt(), new PInt());
            break;
            i = 1;
          }
        }
        parama = (String)((Map)localObject3).get(".msg.img.$cdnthumbaeskey");
        paramString3 = (String)((Map)localObject3).get(".msg.img.$cdnthumburl");
        j = Util.getInt((String)((Map)localObject3).get(".msg.img.$cdnthumblength"), 0);
        localObject1 = ((j)localObject1).v(com.tencent.mm.b.g.getMessageDigest(("SERVERID://" + paramString2.field_msgSvrId).getBytes()), "th_", "");
        l1 = paramString2.field_msgSvrId;
        Log.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString3, localObject1 });
        l2 = Util.nowMilliSecond();
        localObject2 = (String)localObject1 + ".tmp";
        localObject3 = new com.tencent.mm.g.g();
        ((com.tencent.mm.g.g)localObject3).taskName = "task_ImgMsgExtension_2";
        ((com.tencent.mm.g.g)localObject3).field_mediaId = com.tencent.mm.modelcdntran.h.a("downimgthumb", paramString2.getCreateTime(), paramString1, String.valueOf(l1));
        ((com.tencent.mm.g.g)localObject3).field_fullpath = ((String)localObject2);
        ((com.tencent.mm.g.g)localObject3).field_fileType = a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.g.g)localObject3).field_totalLen = j;
        ((com.tencent.mm.g.g)localObject3).field_aesKey = parama;
        ((com.tencent.mm.g.g)localObject3).field_fileId = paramString3;
        ((com.tencent.mm.g.g)localObject3).field_priority = a.lwa;
        if (au.bwE(paramString1))
        {
          i = 1;
          label1492:
          ((com.tencent.mm.g.g)localObject3).field_chattype = i;
          if (!((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).dxP()) {
            break label1603;
          }
        }
        label1603:
        for (i = 2;; i = 1)
        {
          ((com.tencent.mm.g.g)localObject3).expectImageFormat = i;
          Log.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.g.g)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.g.g)localObject3).lwL = new com.tencent.mm.g.g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(150638);
              k.a(paramAnonymousInt, paramAnonymousd, paramString2, paramString1, l1, paramString3, j, l2, this.oHD);
              AppMethodBeat.o(150638);
              return 0;
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return null;
            }
          };
          paramString2.setStatus(4);
          com.tencent.mm.modelcdntran.k.bHW().b((com.tencent.mm.g.g)localObject3, -1);
          break;
          i = 0;
          break label1492;
        }
        label1609:
        l1 = -1L;
        break;
        l1 = -1L;
      }
    }
  }
  
  public final void b(g.c paramc)
  {
    AppMethodBeat.i(150641);
    r.bKa().ag(paramc.hTm);
    AppMethodBeat.o(150641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.k
 * JD-Core Version:    0.7.0.1
 */