package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.findersdk.a.k;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aor;
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
  public static void a(String paramString, aoc paramaoc)
  {
    AppMethodBeat.i(103499);
    paramaoc.syG.clear();
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
          break label4357;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label4357;
        }
        int j = localNodeList.getLength();
        i = 0;
        if (i >= j) {
          break label4357;
        }
        localObject1 = localNodeList.item(i);
        paramString = XmlParser.nodeToString((Node)localObject1);
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label4368;
        }
        localObject1 = XmlParser.nodeToString(((NodeList)localObject1).item(0).getFirstChild());
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4363;
        }
        paramString = XmlParser.parseXml(paramString, "dataitem", null);
        if (paramString == null) {
          break label4374;
        }
        anm localanm = new anm();
        localanm.arq(Util.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localanm.bsP((String)paramString.get(".dataitem" + ".$datasourceid"));
        localanm.arr(Util.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localanm.bsH((String)paramString.get(".dataitem" + ".datafmt"));
        localanm.bsx((String)paramString.get(".dataitem" + ".datatitle"));
        localanm.bsy((String)paramString.get(".dataitem" + ".datadesc"));
        localanm.bsz((String)paramString.get(".dataitem" + ".cdn_thumburl"));
        localanm.bsA((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
        localanm.arn(Util.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
        localanm.aro(Util.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
        localanm.bsB((String)paramString.get(".dataitem" + ".cdn_dataurl"));
        localanm.bsC((String)paramString.get(".dataitem" + ".cdn_datakey"));
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localanm.arp(Util.getInt((String)localObject2, 0));
        }
        localanm.bsE((String)paramString.get(".dataitem" + ".stream_dataurl"));
        localanm.bsF((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
        localanm.bsD((String)paramString.get(".dataitem" + ".stream_weburl"));
        localanm.btd((String)paramString.get(".dataitem" + ".songalbumurl"));
        localanm.bte((String)paramString.get(".dataitem" + ".songlyric"));
        localanm.bsW((String)paramString.get(".dataitem" + ".canvasPageXml"));
        localanm.bsI((String)paramString.get(".dataitem" + ".fullmd5"));
        localanm.bsJ((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localanm.TY(Util.getInt((String)localObject2, 0));
        }
        localanm.bsG((String)paramString.get(".dataitem" + ".dataext"));
        localanm.bsN((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localanm.bsO((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localanm.TZ(Util.getInt((String)localObject2, 0));
        }
        localanm.bsQ((String)paramString.get(".dataitem" + ".stream_videoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        if (!Util.isNullOrNil((String)localObject3))
        {
          localObject2 = localObject3;
          if (((String)localObject3).length() >= 32) {}
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.fav.a.b.dN(localanm.toString(), localanm.dataType);
        }
        localanm.bsK((String)localObject2);
        localanm.bsR((String)paramString.get(".dataitem" + ".datasrctitle"));
        localanm.bsS((String)paramString.get(".dataitem" + ".datasrcname"));
        localanm.bsT((String)paramString.get(".dataitem" + ".datasrctime"));
        localanm.bsV((String)paramString.get(".dataitem" + ".statextstr"));
        localanm.bsU((String)paramString.get(".dataitem" + ".$htmlid"));
        localanm.ars(Util.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localanm.btf((String)paramString.get(".dataitem" + ".messageuuid"));
        if (localObject1 != null) {
          localanm.bsX((String)localObject1);
        }
        localObject1 = new anp();
        ((anp)localObject1).lor = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
        ((anp)localObject1).SAk = Util.safeParseInt((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
        ((anp)localObject1).lot = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
        ((anp)localObject1).lou = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
        ((anp)localObject1).lov = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
        ((anp)localObject1).lox = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
        ((anp)localObject1).loy = Util.nullAs((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
        localanm.a((anp)localObject1);
        localObject1 = new ann();
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
            ((ann)localObject1).c(k.w(".dataitem", paramString));
            ((ann)localObject1).e(am.C(".dataitem", paramString));
            ((ann)localObject1).f(k.u(".dataitem", paramString));
            ((ann)localObject1).e(k.y(".dataitem", paramString));
            ((ann)localObject1).d(k.y(".dataitem", paramString));
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
            localObject2 = b.s(".dataitem" + ".weburlitem.appmsgshareitem", paramString);
            if (localObject2 != null) {
              ((ann)localObject1).d((anu)localObject2);
            }
            paramString = b.t(".dataitem" + ".favbrandmpvideo", paramString);
            if (paramString != null) {
              ((ann)localObject1).e(paramString);
            }
            localanm.a((ann)localObject1);
            paramaoc.syG.add(localanm);
            break label4374;
          }
        }
        else
        {
          localObject3 = new ano();
          ((ano)localObject3).aru(Util.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
          ((ano)localObject3).bti((String)paramString.get((String)localObject2 + ".$sourceid"));
          ((ano)localObject3).btg((String)paramString.get((String)localObject2 + ".fromusr"));
          ((ano)localObject3).bth((String)paramString.get((String)localObject2 + ".tousr"));
          ((ano)localObject3).btj((String)paramString.get((String)localObject2 + ".realchatname"));
          ((ano)localObject3).Ub(Util.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
          ((ano)localObject3).btk((String)paramString.get((String)localObject2 + ".msgid"));
          ((ano)localObject3).fXM = ((String)paramString.get((String)localObject2 + ".eventid"));
          ((ano)localObject3).SAe = true;
          ((ano)localObject3).btl((String)paramString.get((String)localObject2 + ".appid"));
          ((ano)localObject3).btm((String)paramString.get((String)localObject2 + ".link"));
          ((ano)localObject3).btn((String)paramString.get((String)localObject2 + ".brandid"));
          ((ann)localObject1).c((ano)localObject3);
          continue;
        }
        localObject2 = new ant();
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103499);
        return;
      }
      if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
        ((ant)localObject2).bto((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((ant)localObject2).btp((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!Util.isNullOrNil(str)) {
        ((ant)localObject2).D(Util.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!Util.isNullOrNil(str)) {
        ((ant)localObject2).E(Util.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!Util.isNullOrNil((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label3155;
        }
        ((ant)localObject2).arv(Util.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((ann)localObject1).c((ant)localObject2);
        break;
        label3155:
        ((ant)localObject2).arv(Util.getInt((String)localObject3, -1));
      }
      label3170:
      localObject3 = new aor();
      ((aor)localObject3).btM((String)paramString.get((String)localObject2 + ".clean_url"));
      ((aor)localObject3).btL((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((aor)localObject3).btN((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((aor)localObject3).btK((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((aor)localObject3).arA(Util.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((aor)localObject3).arB(Util.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((aor)localObject3).btO((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((aor)localObject3).btP((String)paramString.get((String)localObject2 + ".wsVideoFlowXml"));
      ((aor)localObject3).arC(Util.getInt((String)paramString.get((String)localObject2 + ".forwardflag"), 0));
      ((ann)localObject1).b((aor)localObject3);
      continue;
      label3525:
      localObject3 = new aob();
      ((aob)localObject3).btq((String)paramString.get((String)localObject2 + ".producttitle"));
      ((aob)localObject3).btr((String)paramString.get((String)localObject2 + ".productdesc"));
      ((aob)localObject3).bts((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((aob)localObject3).btt((String)paramString.get((String)localObject2 + ".productinfo"));
      ((aob)localObject3).arw(Util.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((ann)localObject1).a((aob)localObject3);
      continue;
      label3729:
      localObject3 = new aol();
      ((aol)localObject3).btG((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((aol)localObject3).btH((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((aol)localObject3).btI((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((aol)localObject3).btJ((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((ann)localObject1).a((aol)localObject3);
      continue;
      label3893:
      localObject3 = new ank();
      ((ank)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((ank)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((ank)localObject3).fES = Util.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((ank)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((ank)localObject3).type = Util.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((ank)localObject3).fve = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((ank)localObject3).SxE = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((ank)localObject3).version = Util.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((ank)localObject3).otE = Util.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((ank)localObject3).nYp = Util.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((ank)localObject3).fXg = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((ank)localObject3).subType = Util.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((ann)localObject1).b((ank)localObject3);
      continue;
      label4357:
      AppMethodBeat.o(103499);
      return;
      label4363:
      paramString = null;
      continue;
      label4368:
      localObject1 = null;
      continue;
      label4374:
      i += 1;
    }
  }
  
  public static aoc c(aoc paramaoc)
  {
    AppMethodBeat.i(103500);
    if (paramaoc == null)
    {
      AppMethodBeat.o(103500);
      return null;
    }
    aoc localaoc = new aoc();
    if (paramaoc.SAC) {
      localaoc.a(paramaoc.SAB);
    }
    if (paramaoc.SAD) {
      localaoc.cg(paramaoc.syG);
    }
    if (paramaoc.Szq) {
      localaoc.d(paramaoc.Szp);
    }
    if (paramaoc.Szs) {
      localaoc.c(paramaoc.Szr);
    }
    if (paramaoc.Szx) {
      localaoc.btu(paramaoc.remark);
    }
    if (paramaoc.SxH) {
      localaoc.btv(paramaoc.title);
    }
    if (paramaoc.SxI) {
      localaoc.btw(paramaoc.desc);
    }
    if (paramaoc.Szz) {
      localaoc.Uc(paramaoc.Szy);
    }
    if (paramaoc.SzB) {
      localaoc.arx(paramaoc.SzA);
    }
    if (paramaoc.Szu) {
      localaoc.b(paramaoc.Szt);
    }
    if (paramaoc.SzC) {
      localaoc.Ud(paramaoc.uTt);
    }
    if (paramaoc.Szw) {
      localaoc.b(paramaoc.Szv);
    }
    if (paramaoc.SAE) {
      localaoc.ary(paramaoc.version);
    }
    if (paramaoc.SzD) {
      localaoc.a(paramaoc.RDh);
    }
    if (paramaoc.SzF) {
      localaoc.c(paramaoc.SzE);
    }
    if (paramaoc.SzG) {
      localaoc.f(paramaoc.PTL);
    }
    if (paramaoc.SzK) {
      localaoc.d(paramaoc.SzJ);
    }
    AppMethodBeat.o(103500);
    return localaoc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */