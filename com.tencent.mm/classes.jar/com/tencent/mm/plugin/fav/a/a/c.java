package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.ask;
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
  public static void a(String paramString, arv paramarv)
  {
    AppMethodBeat.i(103499);
    paramarv.vEn.clear();
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
          break label4396;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label4396;
        }
        int j = localNodeList.getLength();
        i = 0;
        if (i >= j) {
          break label4396;
        }
        localObject1 = localNodeList.item(i);
        paramString = XmlParser.nodeToString((Node)localObject1);
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label4407;
        }
        localObject1 = XmlParser.nodeToString(((NodeList)localObject1).item(0).getFirstChild());
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4402;
        }
        paramString = XmlParser.parseXml(paramString, "dataitem", null);
        if (paramString == null) {
          break label4413;
        }
        arf localarf = new arf();
        localarf.axy(Util.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localarf.bsG((String)paramString.get(".dataitem" + ".$datasourceid"));
        localarf.axz(Util.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localarf.bsy((String)paramString.get(".dataitem" + ".datafmt"));
        localarf.bso((String)paramString.get(".dataitem" + ".datatitle"));
        localarf.bsp((String)paramString.get(".dataitem" + ".datadesc"));
        localarf.bsq((String)paramString.get(".dataitem" + ".cdn_thumburl"));
        localarf.bsr((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
        localarf.axv(Util.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
        localarf.axw(Util.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
        localarf.bss((String)paramString.get(".dataitem" + ".cdn_dataurl"));
        localarf.bst((String)paramString.get(".dataitem" + ".cdn_datakey"));
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localarf.axx(Util.getInt((String)localObject2, 0));
        }
        localarf.bsv((String)paramString.get(".dataitem" + ".stream_dataurl"));
        localarf.bsw((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
        localarf.bsu((String)paramString.get(".dataitem" + ".stream_weburl"));
        localarf.bsU((String)paramString.get(".dataitem" + ".songalbumurl"));
        localarf.bsV((String)paramString.get(".dataitem" + ".songlyric"));
        localarf.bsN((String)paramString.get(".dataitem" + ".canvasPageXml"));
        localarf.bsz((String)paramString.get(".dataitem" + ".fullmd5"));
        localarf.bsA((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localarf.yo(Util.getInt((String)localObject2, 0));
        }
        localarf.bsx((String)paramString.get(".dataitem" + ".dataext"));
        localarf.bsE((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localarf.bsF((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localarf.yp(Util.getInt((String)localObject2, 0));
        }
        localarf.bsH((String)paramString.get(".dataitem" + ".stream_videoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        if (!Util.isNullOrNil((String)localObject3))
        {
          localObject2 = localObject3;
          if (((String)localObject3).length() >= 32) {}
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.fav.a.b.er(localarf.toString(), localarf.dataType);
        }
        localarf.bsB((String)localObject2);
        localarf.bsI((String)paramString.get(".dataitem" + ".datasrctitle"));
        localarf.bsJ((String)paramString.get(".dataitem" + ".datasrcname"));
        localarf.bsK((String)paramString.get(".dataitem" + ".datasrctime"));
        localarf.bsM((String)paramString.get(".dataitem" + ".statextstr"));
        localarf.bsL((String)paramString.get(".dataitem" + ".$htmlid"));
        localarf.axA(Util.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localarf.bsW((String)paramString.get(".dataitem" + ".messageuuid"));
        if (localObject1 != null) {
          localarf.bsO((String)localObject1);
        }
        localObject1 = new ari();
        ((ari)localObject1).nTu = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
        ((ari)localObject1).ZBc = Util.safeParseInt((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
        ((ari)localObject1).nTw = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
        ((ari)localObject1).nTx = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
        ((ari)localObject1).nTy = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
        ((ari)localObject1).nTA = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
        ((ari)localObject1).nTB = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
        localarf.a((ari)localObject1);
        localObject1 = new arg();
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
              break label3170;
            }
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            ((arg)localObject1).g(q.C(".dataitem", paramString));
            ((arg)localObject1).e(cq.J(".dataitem", paramString));
            ((arg)localObject1).g(q.z(".dataitem", paramString));
            ((arg)localObject1).d(q.F(".dataitem", paramString));
            ((arg)localObject1).c(q.F(".dataitem", paramString));
            localObject2 = ".dataitem" + ".productitem";
            if (paramString.containsKey(localObject2)) {
              break label3525;
            }
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".tvitem";
            if (paramString.containsKey(localObject2)) {
              break label3729;
            }
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".appbranditem";
            if (paramString.containsKey(localObject2)) {
              break label3893;
            }
            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = b.u(".dataitem" + ".weburlitem.appmsgshareitem", paramString);
            if (localObject2 != null) {
              ((arg)localObject1).d((arn)localObject2);
            }
            paramString = b.v(".dataitem" + ".favbrandmpvideo", paramString);
            if (paramString != null) {
              ((arg)localObject1).e(paramString);
            }
            localarf.a((arg)localObject1);
            paramarv.vEn.add(localarf);
            break label4413;
          }
        }
        else
        {
          localObject3 = new arh();
          ((arh)localObject3).axC(Util.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
          ((arh)localObject3).bsZ((String)paramString.get((String)localObject2 + ".$sourceid"));
          ((arh)localObject3).bsX((String)paramString.get((String)localObject2 + ".fromusr"));
          ((arh)localObject3).bsY((String)paramString.get((String)localObject2 + ".tousr"));
          ((arh)localObject3).bta((String)paramString.get((String)localObject2 + ".realchatname"));
          ((arh)localObject3).yr(Util.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
          ((arh)localObject3).btb((String)paramString.get((String)localObject2 + ".msgid"));
          ((arh)localObject3).eventId = ((String)paramString.get((String)localObject2 + ".eventid"));
          ((arh)localObject3).ZAW = true;
          ((arh)localObject3).btc((String)paramString.get((String)localObject2 + ".appid"));
          ((arh)localObject3).btd((String)paramString.get((String)localObject2 + ".link"));
          ((arh)localObject3).bte((String)paramString.get((String)localObject2 + ".brandid"));
          ((arg)localObject1).c((arh)localObject3);
          continue;
        }
        localObject2 = new arm();
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103499);
        return;
      }
      if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
        ((arm)localObject2).btf((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((arm)localObject2).btg((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!Util.isNullOrNil(str)) {
        ((arm)localObject2).V(Util.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!Util.isNullOrNil(str)) {
        ((arm)localObject2).W(Util.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!Util.isNullOrNil((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label3155;
        }
        ((arm)localObject2).axD(Util.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((arg)localObject1).c((arm)localObject2);
        break;
        label3155:
        ((arm)localObject2).axD(Util.getInt((String)localObject3, -1));
      }
      label3170:
      localObject3 = new ask();
      ((ask)localObject3).btD((String)paramString.get((String)localObject2 + ".clean_url"));
      ((ask)localObject3).btC((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((ask)localObject3).btE((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((ask)localObject3).btB((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((ask)localObject3).axI(Util.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((ask)localObject3).axJ(Util.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((ask)localObject3).btF((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((ask)localObject3).btG((String)paramString.get((String)localObject2 + ".wsVideoFlowXml"));
      ((ask)localObject3).axK(Util.getInt((String)paramString.get((String)localObject2 + ".forwardflag"), 0));
      ((arg)localObject1).b((ask)localObject3);
      continue;
      label3525:
      localObject3 = new aru();
      ((aru)localObject3).bth((String)paramString.get((String)localObject2 + ".producttitle"));
      ((aru)localObject3).bti((String)paramString.get((String)localObject2 + ".productdesc"));
      ((aru)localObject3).btj((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((aru)localObject3).btk((String)paramString.get((String)localObject2 + ".productinfo"));
      ((aru)localObject3).axE(Util.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((arg)localObject1).a((aru)localObject3);
      continue;
      label3729:
      localObject3 = new ase();
      ((ase)localObject3).btx((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((ase)localObject3).bty((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((ase)localObject3).btz((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((ase)localObject3).btA((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((arg)localObject1).a((ase)localObject3);
      continue;
      label3893:
      localObject3 = new ard();
      ((ard)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((ard)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((ard)localObject3).hJK = Util.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((ard)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((ard)localObject3).type = Util.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((ard)localObject3).hzy = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((ard)localObject3).Zyw = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((ard)localObject3).version = Util.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((ard)localObject3).rxs = Util.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((ard)localObject3).rbZ = Util.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((ard)localObject3).nOX = Util.getInt((String)paramString.get((String)localObject2 + ".showRelievedBuyFlag"), 0);
      ((ard)localObject3).idf = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((ard)localObject3).subType = Util.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((arg)localObject1).b((ard)localObject3);
      continue;
      label4396:
      AppMethodBeat.o(103499);
      return;
      label4402:
      paramString = null;
      continue;
      label4407:
      localObject1 = null;
      continue;
      label4413:
      i += 1;
    }
  }
  
  public static arv c(arv paramarv)
  {
    AppMethodBeat.i(103500);
    if (paramarv == null)
    {
      AppMethodBeat.o(103500);
      return null;
    }
    arv localarv = new arv();
    if (paramarv.ZBu) {
      localarv.a(paramarv.ZBt);
    }
    if (paramarv.ZBv) {
      localarv.cs(paramarv.vEn);
    }
    if (paramarv.ZAi) {
      localarv.d(paramarv.ZAh);
    }
    if (paramarv.ZAk) {
      localarv.c(paramarv.ZAj);
    }
    if (paramarv.ZAp) {
      localarv.btl(paramarv.remark);
    }
    if (paramarv.Zyz) {
      localarv.btm(paramarv.title);
    }
    if (paramarv.ZyA) {
      localarv.btn(paramarv.desc);
    }
    if (paramarv.ZAr) {
      localarv.ys(paramarv.ZAq);
    }
    if (paramarv.ZAt) {
      localarv.axF(paramarv.ZAs);
    }
    if (paramarv.ZAm) {
      localarv.b(paramarv.ZAl);
    }
    if (paramarv.ZAu) {
      localarv.yt(paramarv.ygh);
    }
    if (paramarv.ZAo) {
      localarv.b(paramarv.ZAn);
    }
    if (paramarv.ZBw) {
      localarv.axG(paramarv.version);
    }
    if (paramarv.ZAv) {
      localarv.a(paramarv.YzK);
    }
    if (paramarv.ZAx) {
      localarv.c(paramarv.ZAw);
    }
    if (paramarv.ZAy) {
      localarv.f(paramarv.WKx);
    }
    if (paramarv.ZAC) {
      localarv.h(paramarv.ZAB);
    }
    AppMethodBeat.o(103500);
    return localarv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */