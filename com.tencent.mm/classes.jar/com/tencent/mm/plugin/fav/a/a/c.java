package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
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
  public static void a(String paramString, anb paramanb)
  {
    AppMethodBeat.i(103499);
    paramanb.ppH.clear();
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
          break label4305;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label4305;
        }
        int j = localNodeList.getLength();
        i = 0;
        if (i >= j) {
          break label4305;
        }
        localObject1 = localNodeList.item(i);
        paramString = XmlParser.nodeToString((Node)localObject1);
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label4316;
        }
        localObject1 = XmlParser.nodeToString(((NodeList)localObject1).item(0).getFirstChild());
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4311;
        }
        paramString = XmlParser.parseXml(paramString, "dataitem", null);
        if (paramString == null) {
          break label4322;
        }
        aml localaml = new aml();
        localaml.ajd(Util.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localaml.bgx((String)paramString.get(".dataitem" + ".$datasourceid"));
        localaml.aje(Util.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localaml.bgp((String)paramString.get(".dataitem" + ".datafmt"));
        localaml.bgf((String)paramString.get(".dataitem" + ".datatitle"));
        localaml.bgg((String)paramString.get(".dataitem" + ".datadesc"));
        localaml.bgh((String)paramString.get(".dataitem" + ".cdn_thumburl"));
        localaml.bgi((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
        localaml.aja(Util.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
        localaml.ajb(Util.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
        localaml.bgj((String)paramString.get(".dataitem" + ".cdn_dataurl"));
        localaml.bgk((String)paramString.get(".dataitem" + ".cdn_datakey"));
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localaml.ajc(Util.getInt((String)localObject2, 0));
        }
        localaml.bgm((String)paramString.get(".dataitem" + ".stream_dataurl"));
        localaml.bgn((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
        localaml.bgl((String)paramString.get(".dataitem" + ".stream_weburl"));
        localaml.bgL((String)paramString.get(".dataitem" + ".songalbumurl"));
        localaml.bgM((String)paramString.get(".dataitem" + ".songlyric"));
        localaml.bgE((String)paramString.get(".dataitem" + ".canvasPageXml"));
        localaml.bgq((String)paramString.get(".dataitem" + ".fullmd5"));
        localaml.bgr((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localaml.Mu(Util.getInt((String)localObject2, 0));
        }
        localaml.bgo((String)paramString.get(".dataitem" + ".dataext"));
        localaml.bgv((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localaml.bgw((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localaml.Mv(Util.getInt((String)localObject2, 0));
        }
        localaml.bgy((String)paramString.get(".dataitem" + ".stream_videoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        if (!Util.isNullOrNil((String)localObject3))
        {
          localObject2 = localObject3;
          if (((String)localObject3).length() >= 32) {}
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.fav.a.b.ds(localaml.toString(), localaml.dataType);
        }
        localaml.bgs((String)localObject2);
        localaml.bgz((String)paramString.get(".dataitem" + ".datasrctitle"));
        localaml.bgA((String)paramString.get(".dataitem" + ".datasrcname"));
        localaml.bgB((String)paramString.get(".dataitem" + ".datasrctime"));
        localaml.bgD((String)paramString.get(".dataitem" + ".statextstr"));
        localaml.bgC((String)paramString.get(".dataitem" + ".$htmlid"));
        localaml.ajf(Util.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localaml.bgN((String)paramString.get(".dataitem" + ".messageuuid"));
        if (localObject1 != null) {
          localaml.bgF((String)localObject1);
        }
        localObject1 = new amo();
        ((amo)localObject1).iyZ = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
        ((amo)localObject1).LxJ = Util.safeParseInt((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
        ((amo)localObject1).izb = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
        ((amo)localObject1).izc = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
        ((amo)localObject1).izd = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
        ((amo)localObject1).izf = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
        ((amo)localObject1).izg = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
        localaml.a((amo)localObject1);
        localObject1 = new amm();
        localObject2 = ".dataitem" + ".dataitemsource";
        if (!paramString.containsKey(localObject2))
        {
          Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject3 = ".dataitem" + ".locitem";
          if (!paramString.containsKey(localObject3))
          {
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject3 });
            localObject2 = ".dataitem" + ".weburlitem";
            if (paramString.containsKey(localObject2)) {
              break label3158;
            }
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            ((amm)localObject1).c(l.x(".dataitem", paramString));
            ((amm)localObject1).e(ak.C(".dataitem", paramString));
            ((amm)localObject1).e(l.v(".dataitem", paramString));
            ((amm)localObject1).c(l.z(".dataitem", paramString));
            localObject2 = ".dataitem" + ".productitem";
            if (paramString.containsKey(localObject2)) {
              break label3473;
            }
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".tvitem";
            if (paramString.containsKey(localObject2)) {
              break label3677;
            }
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".appbranditem";
            if (paramString.containsKey(localObject2)) {
              break label3841;
            }
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = b.t(".dataitem" + ".weburlitem.appmsgshareitem", paramString);
            if (localObject2 != null) {
              ((amm)localObject1).d((amt)localObject2);
            }
            paramString = b.u(".dataitem" + ".favbrandmpvideo", paramString);
            if (paramString != null) {
              ((amm)localObject1).e(paramString);
            }
            localaml.a((amm)localObject1);
            paramanb.ppH.add(localaml);
            break label4322;
          }
        }
        else
        {
          localObject3 = new amn();
          ((amn)localObject3).ajh(Util.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
          ((amn)localObject3).bgQ((String)paramString.get((String)localObject2 + ".$sourceid"));
          ((amn)localObject3).bgO((String)paramString.get((String)localObject2 + ".fromusr"));
          ((amn)localObject3).bgP((String)paramString.get((String)localObject2 + ".tousr"));
          ((amn)localObject3).bgR((String)paramString.get((String)localObject2 + ".realchatname"));
          ((amn)localObject3).Mx(Util.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
          ((amn)localObject3).bgS((String)paramString.get((String)localObject2 + ".msgid"));
          ((amn)localObject3).edD = ((String)paramString.get((String)localObject2 + ".eventid"));
          ((amn)localObject3).LxD = true;
          ((amn)localObject3).bgT((String)paramString.get((String)localObject2 + ".appid"));
          ((amn)localObject3).bgU((String)paramString.get((String)localObject2 + ".link"));
          ((amn)localObject3).bgV((String)paramString.get((String)localObject2 + ".brandid"));
          ((amm)localObject1).c((amn)localObject3);
          continue;
        }
        localObject2 = new ams();
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103499);
        return;
      }
      if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
        ((ams)localObject2).bgW((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((ams)localObject2).bgX((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!Util.isNullOrNil(str)) {
        ((ams)localObject2).B(Util.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!Util.isNullOrNil(str)) {
        ((ams)localObject2).C(Util.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!Util.isNullOrNil((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label3143;
        }
        ((ams)localObject2).aji(Util.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((amm)localObject1).c((ams)localObject2);
        break;
        label3143:
        ((ams)localObject2).aji(Util.getInt((String)localObject3, -1));
      }
      label3158:
      localObject3 = new anq();
      ((anq)localObject3).bhu((String)paramString.get((String)localObject2 + ".clean_url"));
      ((anq)localObject3).bht((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((anq)localObject3).bhv((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((anq)localObject3).bhs((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((anq)localObject3).ajn(Util.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((anq)localObject3).ajo(Util.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((anq)localObject3).bhw((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((anq)localObject3).bhx((String)paramString.get((String)localObject2 + ".wsVideoFlowXml"));
      ((amm)localObject1).a((anq)localObject3);
      continue;
      label3473:
      localObject3 = new ana();
      ((ana)localObject3).bgY((String)paramString.get((String)localObject2 + ".producttitle"));
      ((ana)localObject3).bgZ((String)paramString.get((String)localObject2 + ".productdesc"));
      ((ana)localObject3).bha((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((ana)localObject3).bhb((String)paramString.get((String)localObject2 + ".productinfo"));
      ((ana)localObject3).ajj(Util.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((amm)localObject1).a((ana)localObject3);
      continue;
      label3677:
      localObject3 = new ank();
      ((ank)localObject3).bho((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((ank)localObject3).bhp((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((ank)localObject3).bhq((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((ank)localObject3).bhr((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((amm)localObject1).a((ank)localObject3);
      continue;
      label3841:
      localObject3 = new amj();
      ((amj)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((amj)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((amj)localObject3).dMe = Util.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((amj)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((amj)localObject3).type = Util.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((amj)localObject3).dCx = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((amj)localObject3).Lve = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((amj)localObject3).version = Util.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((amj)localObject3).lyE = Util.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((amj)localObject3).leb = Util.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((amj)localObject3).eda = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((amj)localObject3).subType = Util.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((amm)localObject1).b((amj)localObject3);
      continue;
      label4305:
      AppMethodBeat.o(103499);
      return;
      label4311:
      paramString = null;
      continue;
      label4316:
      localObject1 = null;
      continue;
      label4322:
      i += 1;
    }
  }
  
  public static anb c(anb paramanb)
  {
    AppMethodBeat.i(103500);
    if (paramanb == null)
    {
      AppMethodBeat.o(103500);
      return null;
    }
    anb localanb = new anb();
    if (paramanb.Lyb) {
      localanb.a(paramanb.Lya);
    }
    if (paramanb.Lyc) {
      localanb.bH(paramanb.ppH);
    }
    if (paramanb.LwR) {
      localanb.d(paramanb.LwQ);
    }
    if (paramanb.LwT) {
      localanb.b(paramanb.LwS);
    }
    if (paramanb.LwY) {
      localanb.bhc(paramanb.remark);
    }
    if (paramanb.Lvh) {
      localanb.bhd(paramanb.title);
    }
    if (paramanb.Lvi) {
      localanb.bhe(paramanb.desc);
    }
    if (paramanb.Lxa) {
      localanb.My(paramanb.LwZ);
    }
    if (paramanb.Lxc) {
      localanb.ajk(paramanb.Lxb);
    }
    if (paramanb.LwV) {
      localanb.b(paramanb.LwU);
    }
    if (paramanb.Lxd) {
      localanb.Mz(paramanb.rnM);
    }
    if (paramanb.LwX) {
      localanb.b(paramanb.LwW);
    }
    if (paramanb.Lyd) {
      localanb.ajl(paramanb.version);
    }
    if (paramanb.Lxe) {
      localanb.a(paramanb.KBr);
    }
    if (paramanb.Lxg) {
      localanb.c(paramanb.Lxf);
    }
    if (paramanb.Lxh) {
      localanb.f(paramanb.IXu);
    }
    if (paramanb.Lxl) {
      localanb.d(paramanb.Lxk);
    }
    AppMethodBeat.o(103500);
    return localanb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */