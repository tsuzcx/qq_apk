package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class c
{
  public static void a(String paramString, akn paramakn)
  {
    AppMethodBeat.i(103499);
    paramakn.oeJ.clear();
    Object localObject1 = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes())));
        paramString.normalize();
        paramString = paramString.getDocumentElement().getElementsByTagName("datalist");
        if (paramString == null) {
          break label4268;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label4268;
        }
        int j = localNodeList.getLength();
        i = 0;
        if (i >= j) {
          break label4268;
        }
        localObject1 = localNodeList.item(i);
        paramString = bx.b((Node)localObject1);
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label4279;
        }
        localObject1 = bx.b(((NodeList)localObject1).item(0).getFirstChild());
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4274;
        }
        paramString = bx.M(paramString, "dataitem");
        if (paramString == null) {
          break label4285;
        }
        ajx localajx = new ajx();
        localajx.aao(bu.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localajx.aPU((String)paramString.get(".dataitem" + ".$datasourceid"));
        localajx.aap(bu.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localajx.aPM((String)paramString.get(".dataitem" + ".datafmt"));
        localajx.aPC((String)paramString.get(".dataitem" + ".datatitle"));
        localajx.aPD((String)paramString.get(".dataitem" + ".datadesc"));
        localajx.aPE((String)paramString.get(".dataitem" + ".cdn_thumburl"));
        localajx.aPF((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
        localajx.aal(bu.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
        localajx.aam(bu.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
        localajx.aPG((String)paramString.get(".dataitem" + ".cdn_dataurl"));
        localajx.aPH((String)paramString.get(".dataitem" + ".cdn_datakey"));
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localajx.aan(bu.getInt((String)localObject2, 0));
        }
        localajx.aPJ((String)paramString.get(".dataitem" + ".stream_dataurl"));
        localajx.aPK((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
        localajx.aPI((String)paramString.get(".dataitem" + ".stream_weburl"));
        localajx.aQi((String)paramString.get(".dataitem" + ".songalbumurl"));
        localajx.aQj((String)paramString.get(".dataitem" + ".songlyric"));
        localajx.aQb((String)paramString.get(".dataitem" + ".canvasPageXml"));
        localajx.aPN((String)paramString.get(".dataitem" + ".fullmd5"));
        localajx.aPO((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
        if (!bu.isNullOrNil((String)localObject2)) {
          localajx.De(bu.getInt((String)localObject2, 0));
        }
        localajx.aPL((String)paramString.get(".dataitem" + ".dataext"));
        localajx.aPS((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localajx.aPT((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
        if (!bu.isNullOrNil((String)localObject2)) {
          localajx.Df(bu.getInt((String)localObject2, 0));
        }
        localajx.aPV((String)paramString.get(".dataitem" + ".stream_videoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        if (!bu.isNullOrNil((String)localObject3))
        {
          localObject2 = localObject3;
          if (((String)localObject3).length() >= 32) {}
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.fav.a.b.dm(localajx.toString(), localajx.dataType);
        }
        localajx.aPP((String)localObject2);
        localajx.aPW((String)paramString.get(".dataitem" + ".datasrctitle"));
        localajx.aPX((String)paramString.get(".dataitem" + ".datasrcname"));
        localajx.aPY((String)paramString.get(".dataitem" + ".datasrctime"));
        localajx.aQa((String)paramString.get(".dataitem" + ".statextstr"));
        localajx.aPZ((String)paramString.get(".dataitem" + ".$htmlid"));
        localajx.aaq(bu.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localajx.aQk((String)paramString.get(".dataitem" + ".messageuuid"));
        if (localObject1 != null) {
          localajx.aQc((String)localObject1);
        }
        localObject1 = new aka();
        ((aka)localObject1).hET = bu.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
        ((aka)localObject1).GBN = bu.aSB((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
        ((aka)localObject1).hEV = bu.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
        ((aka)localObject1).hEW = bu.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
        ((aka)localObject1).hEX = bu.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
        ((aka)localObject1).hEZ = bu.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
        ((aka)localObject1).hFa = bu.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
        localajx.a((aka)localObject1);
        localObject1 = new ajy();
        localObject2 = ".dataitem" + ".dataitemsource";
        if (!paramString.containsKey(localObject2))
        {
          ae.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject3 = ".dataitem" + ".locitem";
          if (!paramString.containsKey(localObject3))
          {
            ae.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject3 });
            localObject2 = ".dataitem" + ".weburlitem";
            if (paramString.containsKey(localObject2)) {
              break label3121;
            }
            ae.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            ((ajy)localObject1).c(e.w(".dataitem", paramString));
            localObject2 = ".dataitem" + ".productitem";
            if (paramString.containsKey(localObject2)) {
              break label3436;
            }
            ae.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".tvitem";
            if (paramString.containsKey(localObject2)) {
              break label3640;
            }
            ae.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".appbranditem";
            if (paramString.containsKey(localObject2)) {
              break label3804;
            }
            ae.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = b.u(".dataitem" + ".weburlitem.appmsgshareitem", paramString);
            if (localObject2 != null) {
              ((ajy)localObject1).d((akf)localObject2);
            }
            paramString = b.v(".dataitem" + ".favbrandmpvideo", paramString);
            if (paramString != null) {
              ((ajy)localObject1).e(paramString);
            }
            localajx.a((ajy)localObject1);
            paramakn.oeJ.add(localajx);
            break label4285;
          }
        }
        else
        {
          localObject3 = new ajz();
          ((ajz)localObject3).aas(bu.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
          ((ajz)localObject3).aQn((String)paramString.get((String)localObject2 + ".$sourceid"));
          ((ajz)localObject3).aQl((String)paramString.get((String)localObject2 + ".fromusr"));
          ((ajz)localObject3).aQm((String)paramString.get((String)localObject2 + ".tousr"));
          ((ajz)localObject3).aQo((String)paramString.get((String)localObject2 + ".realchatname"));
          ((ajz)localObject3).Dh(bu.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
          ((ajz)localObject3).aQp((String)paramString.get((String)localObject2 + ".msgid"));
          ((ajz)localObject3).dLO = ((String)paramString.get((String)localObject2 + ".eventid"));
          ((ajz)localObject3).GBH = true;
          ((ajz)localObject3).aQq((String)paramString.get((String)localObject2 + ".appid"));
          ((ajz)localObject3).aQr((String)paramString.get((String)localObject2 + ".link"));
          ((ajz)localObject3).aQs((String)paramString.get((String)localObject2 + ".brandid"));
          ((ajy)localObject1).c((ajz)localObject3);
          continue;
        }
        localObject2 = new ake();
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103499);
        return;
      }
      if (!bu.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
        ((ake)localObject2).aQt((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!bu.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((ake)localObject2).aQu((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!bu.isNullOrNil(str)) {
        ((ake)localObject2).A(bu.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!bu.isNullOrNil(str)) {
        ((ake)localObject2).B(bu.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!bu.isNullOrNil((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label3106;
        }
        ((ake)localObject2).aat(bu.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((ajy)localObject1).c((ake)localObject2);
        break;
        label3106:
        ((ake)localObject2).aat(bu.getInt((String)localObject3, -1));
      }
      label3121:
      localObject3 = new alc();
      ((alc)localObject3).aQR((String)paramString.get((String)localObject2 + ".clean_url"));
      ((alc)localObject3).aQQ((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((alc)localObject3).aQS((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((alc)localObject3).aQP((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((alc)localObject3).aay(bu.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((alc)localObject3).aaz(bu.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((alc)localObject3).aQT((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((alc)localObject3).aQU((String)paramString.get((String)localObject2 + ".wsVideoFlowXml"));
      ((ajy)localObject1).a((alc)localObject3);
      continue;
      label3436:
      localObject3 = new akm();
      ((akm)localObject3).aQv((String)paramString.get((String)localObject2 + ".producttitle"));
      ((akm)localObject3).aQw((String)paramString.get((String)localObject2 + ".productdesc"));
      ((akm)localObject3).aQx((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((akm)localObject3).aQy((String)paramString.get((String)localObject2 + ".productinfo"));
      ((akm)localObject3).aau(bu.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((ajy)localObject1).a((akm)localObject3);
      continue;
      label3640:
      localObject3 = new akw();
      ((akw)localObject3).aQL((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((akw)localObject3).aQM((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((akw)localObject3).aQN((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((akw)localObject3).aQO((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((ajy)localObject1).a((akw)localObject3);
      continue;
      label3804:
      localObject3 = new ajv();
      ((ajv)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((ajv)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((ajv)localObject3).duK = bu.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((ajv)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((ajv)localObject3).type = bu.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((ajv)localObject3).dlk = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((ajv)localObject3).Gzq = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((ajv)localObject3).version = bu.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((ajv)localObject3).kuE = bu.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((ajv)localObject3).kaX = bu.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((ajv)localObject3).dLl = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((ajv)localObject3).subType = bu.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((ajy)localObject1).b((ajv)localObject3);
      continue;
      label4268:
      AppMethodBeat.o(103499);
      return;
      label4274:
      paramString = null;
      continue;
      label4279:
      localObject1 = null;
      continue;
      label4285:
      i += 1;
    }
  }
  
  public static akn c(akn paramakn)
  {
    AppMethodBeat.i(103500);
    if (paramakn == null)
    {
      AppMethodBeat.o(103500);
      return null;
    }
    akn localakn = new akn();
    if (paramakn.GCf) {
      localakn.a(paramakn.GCe);
    }
    if (paramakn.GCg) {
      localakn.bm(paramakn.oeJ);
    }
    if (paramakn.GBe) {
      localakn.d(paramakn.GBd);
    }
    if (paramakn.GBg) {
      localakn.b(paramakn.GBf);
    }
    if (paramakn.GBl) {
      localakn.aQz(paramakn.iWF);
    }
    if (paramakn.Gzt) {
      localakn.aQA(paramakn.title);
    }
    if (paramakn.Gzu) {
      localakn.aQB(paramakn.desc);
    }
    if (paramakn.GBn) {
      localakn.Di(paramakn.GBm);
    }
    if (paramakn.GBp) {
      localakn.aav(paramakn.GBo);
    }
    if (paramakn.GBi) {
      localakn.b(paramakn.GBh);
    }
    if (paramakn.GBq) {
      localakn.Dj(paramakn.pWN);
    }
    if (paramakn.GBk) {
      localakn.b(paramakn.GBj);
    }
    if (paramakn.GCh) {
      localakn.aaw(paramakn.version);
    }
    if (paramakn.GBr) {
      localakn.a(paramakn.FId);
    }
    if (paramakn.GBt) {
      localakn.c(paramakn.GBs);
    }
    if (paramakn.GBu) {
      localakn.f(paramakn.Ekw);
    }
    if (paramakn.GBy) {
      localakn.d(paramakn.GBx);
    }
    AppMethodBeat.o(103500);
    return localakn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */