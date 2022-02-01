package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
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
  public static void a(String paramString, ago paramago)
  {
    AppMethodBeat.i(103499);
    paramago.mVb.clear();
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
        paramString = bw.b((Node)localObject1);
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label4279;
        }
        localObject1 = bw.b(((NodeList)localObject1).item(0).getFirstChild());
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4274;
        }
        paramString = bw.K(paramString, "dataitem");
        if (paramString == null) {
          break label4285;
        }
        afy localafy = new afy();
        localafy.VD(bt.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localafy.aDD((String)paramString.get(".dataitem" + ".$datasourceid"));
        localafy.VE(bt.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localafy.aDv((String)paramString.get(".dataitem" + ".datafmt"));
        localafy.aDl((String)paramString.get(".dataitem" + ".datatitle"));
        localafy.aDm((String)paramString.get(".dataitem" + ".datadesc"));
        localafy.aDn((String)paramString.get(".dataitem" + ".cdn_thumburl"));
        localafy.aDo((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
        localafy.VA(bt.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
        localafy.VB(bt.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
        localafy.aDp((String)paramString.get(".dataitem" + ".cdn_dataurl"));
        localafy.aDq((String)paramString.get(".dataitem" + ".cdn_datakey"));
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localafy.VC(bt.getInt((String)localObject2, 0));
        }
        localafy.aDs((String)paramString.get(".dataitem" + ".stream_dataurl"));
        localafy.aDt((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
        localafy.aDr((String)paramString.get(".dataitem" + ".stream_weburl"));
        localafy.aDR((String)paramString.get(".dataitem" + ".songalbumurl"));
        localafy.aDS((String)paramString.get(".dataitem" + ".songlyric"));
        localafy.aDK((String)paramString.get(".dataitem" + ".canvasPageXml"));
        localafy.aDw((String)paramString.get(".dataitem" + ".fullmd5"));
        localafy.aDx((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
        if (!bt.isNullOrNil((String)localObject2)) {
          localafy.vp(bt.getInt((String)localObject2, 0));
        }
        localafy.aDu((String)paramString.get(".dataitem" + ".dataext"));
        localafy.aDB((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localafy.aDC((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
        if (!bt.isNullOrNil((String)localObject2)) {
          localafy.vq(bt.getInt((String)localObject2, 0));
        }
        localafy.aDE((String)paramString.get(".dataitem" + ".stream_videoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        if (!bt.isNullOrNil((String)localObject3))
        {
          localObject2 = localObject3;
          if (((String)localObject3).length() >= 32) {}
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.fav.a.b.cT(localafy.toString(), localafy.dataType);
        }
        localafy.aDy((String)localObject2);
        localafy.aDF((String)paramString.get(".dataitem" + ".datasrctitle"));
        localafy.aDG((String)paramString.get(".dataitem" + ".datasrcname"));
        localafy.aDH((String)paramString.get(".dataitem" + ".datasrctime"));
        localafy.aDJ((String)paramString.get(".dataitem" + ".statextstr"));
        localafy.aDI((String)paramString.get(".dataitem" + ".$htmlid"));
        localafy.VF(bt.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localafy.aDT((String)paramString.get(".dataitem" + ".messageuuid"));
        if (localObject1 != null) {
          localafy.aDL((String)localObject1);
        }
        localObject1 = new agb();
        ((agb)localObject1).gJv = bt.by((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
        ((agb)localObject1).Dim = bt.aGh((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
        ((agb)localObject1).gJx = bt.by((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
        ((agb)localObject1).gJy = bt.by((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
        ((agb)localObject1).gJz = bt.by((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
        ((agb)localObject1).gJB = bt.by((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
        ((agb)localObject1).gJC = bt.by((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
        localafy.a((agb)localObject1);
        localObject1 = new afz();
        localObject2 = ".dataitem" + ".dataitemsource";
        if (!paramString.containsKey(localObject2))
        {
          ad.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject3 = ".dataitem" + ".locitem";
          if (!paramString.containsKey(localObject3))
          {
            ad.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject3 });
            localObject2 = ".dataitem" + ".weburlitem";
            if (paramString.containsKey(localObject2)) {
              break label3121;
            }
            ad.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            ((afz)localObject1).b(d.s(".dataitem", paramString));
            localObject2 = ".dataitem" + ".productitem";
            if (paramString.containsKey(localObject2)) {
              break label3436;
            }
            ad.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".tvitem";
            if (paramString.containsKey(localObject2)) {
              break label3640;
            }
            ad.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".appbranditem";
            if (paramString.containsKey(localObject2)) {
              break label3804;
            }
            ad.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = b.q(".dataitem" + ".weburlitem.appmsgshareitem", paramString);
            if (localObject2 != null) {
              ((afz)localObject1).d((agg)localObject2);
            }
            paramString = b.r(".dataitem" + ".favbrandmpvideo", paramString);
            if (paramString != null) {
              ((afz)localObject1).e(paramString);
            }
            localafy.a((afz)localObject1);
            paramago.mVb.add(localafy);
            break label4285;
          }
        }
        else
        {
          localObject3 = new aga();
          ((aga)localObject3).VH(bt.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
          ((aga)localObject3).aDW((String)paramString.get((String)localObject2 + ".$sourceid"));
          ((aga)localObject3).aDU((String)paramString.get((String)localObject2 + ".fromusr"));
          ((aga)localObject3).aDV((String)paramString.get((String)localObject2 + ".tousr"));
          ((aga)localObject3).aDX((String)paramString.get((String)localObject2 + ".realchatname"));
          ((aga)localObject3).vs(bt.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
          ((aga)localObject3).aDY((String)paramString.get((String)localObject2 + ".msgid"));
          ((aga)localObject3).dAA = ((String)paramString.get((String)localObject2 + ".eventid"));
          ((aga)localObject3).Dig = true;
          ((aga)localObject3).aDZ((String)paramString.get((String)localObject2 + ".appid"));
          ((aga)localObject3).aEa((String)paramString.get((String)localObject2 + ".link"));
          ((aga)localObject3).aEb((String)paramString.get((String)localObject2 + ".brandid"));
          ((afz)localObject1).c((aga)localObject3);
          continue;
        }
        localObject2 = new agf();
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103499);
        return;
      }
      if (!bt.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
        ((agf)localObject2).aEc((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!bt.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((agf)localObject2).aEd((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!bt.isNullOrNil(str)) {
        ((agf)localObject2).B(bt.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!bt.isNullOrNil(str)) {
        ((agf)localObject2).C(bt.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!bt.isNullOrNil((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label3106;
        }
        ((agf)localObject2).VI(bt.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((afz)localObject1).c((agf)localObject2);
        break;
        label3106:
        ((agf)localObject2).VI(bt.getInt((String)localObject3, -1));
      }
      label3121:
      localObject3 = new ahd();
      ((ahd)localObject3).aEA((String)paramString.get((String)localObject2 + ".clean_url"));
      ((ahd)localObject3).aEz((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((ahd)localObject3).aEB((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((ahd)localObject3).aEy((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((ahd)localObject3).VN(bt.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((ahd)localObject3).VO(bt.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((ahd)localObject3).aEC((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((ahd)localObject3).aED((String)paramString.get((String)localObject2 + ".wsVideoFlowXml"));
      ((afz)localObject1).a((ahd)localObject3);
      continue;
      label3436:
      localObject3 = new agn();
      ((agn)localObject3).aEe((String)paramString.get((String)localObject2 + ".producttitle"));
      ((agn)localObject3).aEf((String)paramString.get((String)localObject2 + ".productdesc"));
      ((agn)localObject3).aEg((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((agn)localObject3).aEh((String)paramString.get((String)localObject2 + ".productinfo"));
      ((agn)localObject3).VJ(bt.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((afz)localObject1).a((agn)localObject3);
      continue;
      label3640:
      localObject3 = new agx();
      ((agx)localObject3).aEu((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((agx)localObject3).aEv((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((agx)localObject3).aEw((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((agx)localObject3).aEx((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((afz)localObject1).a((agx)localObject3);
      continue;
      label3804:
      localObject3 = new afw();
      ((afw)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((afw)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((afw)localObject3).dkC = bt.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((afw)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((afw)localObject3).type = bt.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((afw)localObject3).dbu = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((afw)localObject3).DfP = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((afw)localObject3).version = bt.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((afw)localObject3).jwB = bt.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((afw)localObject3).cfU = bt.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((afw)localObject3).dzY = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((afw)localObject3).subType = bt.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((afz)localObject1).b((afw)localObject3);
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
  
  public static ago c(ago paramago)
  {
    AppMethodBeat.i(103500);
    if (paramago == null)
    {
      AppMethodBeat.o(103500);
      return null;
    }
    ago localago = new ago();
    if (paramago.DiE) {
      localago.a(paramago.DiD);
    }
    if (paramago.DiF) {
      localago.bd(paramago.mVb);
    }
    if (paramago.DhD) {
      localago.d(paramago.DhC);
    }
    if (paramago.DhF) {
      localago.b(paramago.DhE);
    }
    if (paramago.DhK) {
      localago.aEi(paramago.iaz);
    }
    if (paramago.DfS) {
      localago.aEj(paramago.title);
    }
    if (paramago.DfT) {
      localago.aEk(paramago.desc);
    }
    if (paramago.DhM) {
      localago.vt(paramago.DhL);
    }
    if (paramago.DhO) {
      localago.VK(paramago.DhN);
    }
    if (paramago.DhH) {
      localago.b(paramago.DhG);
    }
    if (paramago.DhP) {
      localago.vu(paramago.oJi);
    }
    if (paramago.DhJ) {
      localago.b(paramago.DhI);
    }
    if (paramago.DiG) {
      localago.VL(paramago.version);
    }
    if (paramago.DhQ) {
      localago.a(paramago.Csh);
    }
    if (paramago.DhS) {
      localago.c(paramago.DhR);
    }
    if (paramago.DhT) {
      localago.f(paramago.AWL);
    }
    if (paramago.DhX) {
      localago.c(paramago.DhW);
    }
    AppMethodBeat.o(103500);
    return localago;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */