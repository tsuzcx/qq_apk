package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
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
  public static void a(String paramString, ahn paramahn)
  {
    AppMethodBeat.i(103499);
    paramahn.nxC.clear();
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
        paramString = bv.b((Node)localObject1);
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label4279;
        }
        localObject1 = bv.b(((NodeList)localObject1).item(0).getFirstChild());
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4274;
        }
        paramString = bv.L(paramString, "dataitem");
        if (paramString == null) {
          break label4285;
        }
        agx localagx = new agx();
        localagx.XM(bs.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localagx.aIU((String)paramString.get(".dataitem" + ".$datasourceid"));
        localagx.XN(bs.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localagx.aIM((String)paramString.get(".dataitem" + ".datafmt"));
        localagx.aIC((String)paramString.get(".dataitem" + ".datatitle"));
        localagx.aID((String)paramString.get(".dataitem" + ".datadesc"));
        localagx.aIE((String)paramString.get(".dataitem" + ".cdn_thumburl"));
        localagx.aIF((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
        localagx.XJ(bs.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
        localagx.XK(bs.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
        localagx.aIG((String)paramString.get(".dataitem" + ".cdn_dataurl"));
        localagx.aIH((String)paramString.get(".dataitem" + ".cdn_datakey"));
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localagx.XL(bs.getInt((String)localObject2, 0));
        }
        localagx.aIJ((String)paramString.get(".dataitem" + ".stream_dataurl"));
        localagx.aIK((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
        localagx.aII((String)paramString.get(".dataitem" + ".stream_weburl"));
        localagx.aJi((String)paramString.get(".dataitem" + ".songalbumurl"));
        localagx.aJj((String)paramString.get(".dataitem" + ".songlyric"));
        localagx.aJb((String)paramString.get(".dataitem" + ".canvasPageXml"));
        localagx.aIN((String)paramString.get(".dataitem" + ".fullmd5"));
        localagx.aIO((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
        if (!bs.isNullOrNil((String)localObject2)) {
          localagx.zS(bs.getInt((String)localObject2, 0));
        }
        localagx.aIL((String)paramString.get(".dataitem" + ".dataext"));
        localagx.aIS((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localagx.aIT((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
        if (!bs.isNullOrNil((String)localObject2)) {
          localagx.zT(bs.getInt((String)localObject2, 0));
        }
        localagx.aIV((String)paramString.get(".dataitem" + ".stream_videoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        if (!bs.isNullOrNil((String)localObject3))
        {
          localObject2 = localObject3;
          if (((String)localObject3).length() >= 32) {}
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.fav.a.b.cY(localagx.toString(), localagx.dataType);
        }
        localagx.aIP((String)localObject2);
        localagx.aIW((String)paramString.get(".dataitem" + ".datasrctitle"));
        localagx.aIX((String)paramString.get(".dataitem" + ".datasrcname"));
        localagx.aIY((String)paramString.get(".dataitem" + ".datasrctime"));
        localagx.aJa((String)paramString.get(".dataitem" + ".statextstr"));
        localagx.aIZ((String)paramString.get(".dataitem" + ".$htmlid"));
        localagx.XO(bs.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localagx.aJk((String)paramString.get(".dataitem" + ".messageuuid"));
        if (localObject1 != null) {
          localagx.aJc((String)localObject1);
        }
        localObject1 = new aha();
        ((aha)localObject1).hjV = bs.bG((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
        ((aha)localObject1).EBs = bs.aLy((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
        ((aha)localObject1).hjX = bs.bG((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
        ((aha)localObject1).hjY = bs.bG((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
        ((aha)localObject1).hjZ = bs.bG((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
        ((aha)localObject1).hkb = bs.bG((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
        ((aha)localObject1).hkc = bs.bG((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
        localagx.a((aha)localObject1);
        localObject1 = new agy();
        localObject2 = ".dataitem" + ".dataitemsource";
        if (!paramString.containsKey(localObject2))
        {
          ac.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject3 = ".dataitem" + ".locitem";
          if (!paramString.containsKey(localObject3))
          {
            ac.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject3 });
            localObject2 = ".dataitem" + ".weburlitem";
            if (paramString.containsKey(localObject2)) {
              break label3121;
            }
            ac.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            ((agy)localObject1).c(e.t(".dataitem", paramString));
            localObject2 = ".dataitem" + ".productitem";
            if (paramString.containsKey(localObject2)) {
              break label3436;
            }
            ac.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".tvitem";
            if (paramString.containsKey(localObject2)) {
              break label3640;
            }
            ac.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".appbranditem";
            if (paramString.containsKey(localObject2)) {
              break label3804;
            }
            ac.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = b.r(".dataitem" + ".weburlitem.appmsgshareitem", paramString);
            if (localObject2 != null) {
              ((agy)localObject1).d((ahf)localObject2);
            }
            paramString = b.s(".dataitem" + ".favbrandmpvideo", paramString);
            if (paramString != null) {
              ((agy)localObject1).e(paramString);
            }
            localagx.a((agy)localObject1);
            paramahn.nxC.add(localagx);
            break label4285;
          }
        }
        else
        {
          localObject3 = new agz();
          ((agz)localObject3).XQ(bs.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
          ((agz)localObject3).aJn((String)paramString.get((String)localObject2 + ".$sourceid"));
          ((agz)localObject3).aJl((String)paramString.get((String)localObject2 + ".fromusr"));
          ((agz)localObject3).aJm((String)paramString.get((String)localObject2 + ".tousr"));
          ((agz)localObject3).aJo((String)paramString.get((String)localObject2 + ".realchatname"));
          ((agz)localObject3).zV(bs.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
          ((agz)localObject3).aJp((String)paramString.get((String)localObject2 + ".msgid"));
          ((agz)localObject3).dym = ((String)paramString.get((String)localObject2 + ".eventid"));
          ((agz)localObject3).EBm = true;
          ((agz)localObject3).aJq((String)paramString.get((String)localObject2 + ".appid"));
          ((agz)localObject3).aJr((String)paramString.get((String)localObject2 + ".link"));
          ((agz)localObject3).aJs((String)paramString.get((String)localObject2 + ".brandid"));
          ((agy)localObject1).c((agz)localObject3);
          continue;
        }
        localObject2 = new ahe();
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103499);
        return;
      }
      if (!bs.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
        ((ahe)localObject2).aJt((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!bs.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((ahe)localObject2).aJu((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!bs.isNullOrNil(str)) {
        ((ahe)localObject2).A(bs.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!bs.isNullOrNil(str)) {
        ((ahe)localObject2).B(bs.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!bs.isNullOrNil((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label3106;
        }
        ((ahe)localObject2).XR(bs.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((agy)localObject1).c((ahe)localObject2);
        break;
        label3106:
        ((ahe)localObject2).XR(bs.getInt((String)localObject3, -1));
      }
      label3121:
      localObject3 = new aic();
      ((aic)localObject3).aJR((String)paramString.get((String)localObject2 + ".clean_url"));
      ((aic)localObject3).aJQ((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((aic)localObject3).aJS((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((aic)localObject3).aJP((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((aic)localObject3).XW(bs.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((aic)localObject3).XX(bs.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((aic)localObject3).aJT((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((aic)localObject3).aJU((String)paramString.get((String)localObject2 + ".wsVideoFlowXml"));
      ((agy)localObject1).a((aic)localObject3);
      continue;
      label3436:
      localObject3 = new ahm();
      ((ahm)localObject3).aJv((String)paramString.get((String)localObject2 + ".producttitle"));
      ((ahm)localObject3).aJw((String)paramString.get((String)localObject2 + ".productdesc"));
      ((ahm)localObject3).aJx((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((ahm)localObject3).aJy((String)paramString.get((String)localObject2 + ".productinfo"));
      ((ahm)localObject3).XS(bs.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((agy)localObject1).a((ahm)localObject3);
      continue;
      label3640:
      localObject3 = new ahw();
      ((ahw)localObject3).aJL((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((ahw)localObject3).aJM((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((ahw)localObject3).aJN((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((ahw)localObject3).aJO((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((agy)localObject1).a((ahw)localObject3);
      continue;
      label3804:
      localObject3 = new agv();
      ((agv)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((agv)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((agv)localObject3).dib = bs.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((agv)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((agv)localObject3).type = bs.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((agv)localObject3).cYQ = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((agv)localObject3).EyV = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((agv)localObject3).version = bs.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((agv)localObject3).jWX = bs.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((agv)localObject3).ccR = bs.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((agv)localObject3).dxK = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((agv)localObject3).subType = bs.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((agy)localObject1).b((agv)localObject3);
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
  
  public static ahn c(ahn paramahn)
  {
    AppMethodBeat.i(103500);
    if (paramahn == null)
    {
      AppMethodBeat.o(103500);
      return null;
    }
    ahn localahn = new ahn();
    if (paramahn.EBK) {
      localahn.a(paramahn.EBJ);
    }
    if (paramahn.EBL) {
      localahn.bk(paramahn.nxC);
    }
    if (paramahn.EAJ) {
      localahn.d(paramahn.EAI);
    }
    if (paramahn.EAL) {
      localahn.b(paramahn.EAK);
    }
    if (paramahn.EAQ) {
      localahn.aJz(paramahn.iAC);
    }
    if (paramahn.EyY) {
      localahn.aJA(paramahn.title);
    }
    if (paramahn.EyZ) {
      localahn.aJB(paramahn.desc);
    }
    if (paramahn.EAS) {
      localahn.zW(paramahn.EAR);
    }
    if (paramahn.EAU) {
      localahn.XT(paramahn.EAT);
    }
    if (paramahn.EAN) {
      localahn.b(paramahn.EAM);
    }
    if (paramahn.EAV) {
      localahn.zX(paramahn.pmI);
    }
    if (paramahn.EAP) {
      localahn.b(paramahn.EAO);
    }
    if (paramahn.EBM) {
      localahn.XU(paramahn.version);
    }
    if (paramahn.EAW) {
      localahn.a(paramahn.DKz);
    }
    if (paramahn.EAY) {
      localahn.c(paramahn.EAX);
    }
    if (paramahn.EAZ) {
      localahn.f(paramahn.CoY);
    }
    if (paramahn.EBd) {
      localahn.d(paramahn.EBc);
    }
    AppMethodBeat.o(103500);
    return localahn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */