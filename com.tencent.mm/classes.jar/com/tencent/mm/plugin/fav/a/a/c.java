package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
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
  public static void a(String paramString, acq paramacq)
  {
    AppMethodBeat.i(102755);
    paramacq.wVc.clear();
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
          break label3881;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label3881;
        }
        int j = localNodeList.getLength();
        i = 0;
        if (i >= j) {
          break label3881;
        }
        localObject1 = localNodeList.item(i);
        paramString = br.b((Node)localObject1);
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label3892;
        }
        localObject1 = br.b(((NodeList)localObject1).item(0).getFirstChild());
        if (!paramString.trim().startsWith("<dataitem")) {
          break label3887;
        }
        paramString = br.F(paramString, "dataitem");
        if (paramString == null) {
          break label3898;
        }
        aca localaca = new aca();
        localaca.MI(bo.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localaca.anI((String)paramString.get(".dataitem" + ".$datasourceid"));
        localaca.MJ(bo.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localaca.anA((String)paramString.get(".dataitem" + ".datafmt"));
        localaca.anq((String)paramString.get(".dataitem" + ".datatitle"));
        localaca.anr((String)paramString.get(".dataitem" + ".datadesc"));
        localaca.ans((String)paramString.get(".dataitem" + ".cdn_thumburl"));
        localaca.ant((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
        localaca.MF(bo.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
        localaca.MG(bo.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
        localaca.anu((String)paramString.get(".dataitem" + ".cdn_dataurl"));
        localaca.anv((String)paramString.get(".dataitem" + ".cdn_datakey"));
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localaca.MH(bo.getInt((String)localObject2, 0));
        }
        localaca.anx((String)paramString.get(".dataitem" + ".stream_dataurl"));
        localaca.any((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
        localaca.anw((String)paramString.get(".dataitem" + ".stream_weburl"));
        localaca.anP((String)paramString.get(".dataitem" + ".canvasPageXml"));
        localaca.anB((String)paramString.get(".dataitem" + ".fullmd5"));
        localaca.anC((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
        if (!bo.isNullOrNil((String)localObject2)) {
          localaca.nC(bo.getInt((String)localObject2, 0));
        }
        localaca.anz((String)paramString.get(".dataitem" + ".dataext"));
        localaca.anG((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localaca.anH((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
        if (!bo.isNullOrNil((String)localObject2)) {
          localaca.nD(bo.getInt((String)localObject2, 0));
        }
        localaca.anJ((String)paramString.get(".dataitem" + ".stream_videoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        if (!bo.isNullOrNil((String)localObject3))
        {
          localObject2 = localObject3;
          if (((String)localObject3).length() >= 32) {}
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.fav.a.b.cj(localaca.toString(), localaca.dataType);
        }
        localaca.anD((String)localObject2);
        localaca.anK((String)paramString.get(".dataitem" + ".datasrctitle"));
        localaca.anL((String)paramString.get(".dataitem" + ".datasrcname"));
        localaca.anM((String)paramString.get(".dataitem" + ".datasrctime"));
        localaca.anO((String)paramString.get(".dataitem" + ".statextstr"));
        localaca.anN((String)paramString.get(".dataitem" + ".$htmlid"));
        localaca.MK(bo.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        if (localObject1 != null) {
          localaca.anQ((String)localObject1);
        }
        localObject1 = new acd();
        ((acd)localObject1).fiO = bo.bf((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
        ((acd)localObject1).wUJ = bo.apV((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
        ((acd)localObject1).fiQ = bo.bf((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
        ((acd)localObject1).fiR = bo.bf((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
        ((acd)localObject1).fiS = bo.bf((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
        ((acd)localObject1).fiU = bo.bf((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
        ((acd)localObject1).fiV = bo.bf((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
        localaca.a((acd)localObject1);
        localObject1 = new acb();
        localObject2 = ".dataitem" + ".dataitemsource";
        if (!paramString.containsKey(localObject2))
        {
          ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject3 = ".dataitem" + ".locitem";
          if (!paramString.containsKey(localObject3))
          {
            ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject3 });
            localObject2 = ".dataitem" + ".weburlitem";
            if (paramString.containsKey(localObject2)) {
              break label2961;
            }
            ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".productitem";
            if (paramString.containsKey(localObject2)) {
              break label3240;
            }
            ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".tvitem";
            if (paramString.containsKey(localObject2)) {
              break label3444;
            }
            ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            localObject2 = ".dataitem" + ".appbranditem";
            if (paramString.containsKey(localObject2)) {
              break label3608;
            }
            ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
            paramString = b.o(".dataitem" + ".weburlitem.appmsgshareitem", paramString);
            if (paramString != null) {
              ((acb)localObject1).b(paramString);
            }
            localaca.a((acb)localObject1);
            paramacq.wVc.add(localaca);
            break label3898;
          }
        }
        else
        {
          localObject3 = new acc();
          ((acc)localObject3).MM(bo.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
          ((acc)localObject3).anY((String)paramString.get((String)localObject2 + ".$sourceid"));
          ((acc)localObject3).anW((String)paramString.get((String)localObject2 + ".fromusr"));
          ((acc)localObject3).anX((String)paramString.get((String)localObject2 + ".tousr"));
          ((acc)localObject3).anZ((String)paramString.get((String)localObject2 + ".realchatname"));
          ((acc)localObject3).nF(bo.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
          ((acc)localObject3).aoa((String)paramString.get((String)localObject2 + ".msgid"));
          ((acc)localObject3).cJG = ((String)paramString.get((String)localObject2 + ".eventid"));
          ((acc)localObject3).wUD = true;
          ((acc)localObject3).aob((String)paramString.get((String)localObject2 + ".appid"));
          ((acc)localObject3).aoc((String)paramString.get((String)localObject2 + ".link"));
          ((acc)localObject3).aod((String)paramString.get((String)localObject2 + ".brandid"));
          ((acb)localObject1).c((acc)localObject3);
          continue;
        }
        localObject2 = new ach();
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(102755);
        return;
      }
      if (!bo.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
        ((ach)localObject2).aoe((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!bo.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((ach)localObject2).aof((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!bo.isNullOrNil(str)) {
        ((ach)localObject2).C(bo.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!bo.isNullOrNil(str)) {
        ((ach)localObject2).D(bo.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!bo.isNullOrNil((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label2946;
        }
        ((ach)localObject2).MN(bo.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((acb)localObject1).a((ach)localObject2);
        break;
        label2946:
        ((ach)localObject2).MN(bo.getInt((String)localObject3, -1));
      }
      label2961:
      localObject3 = new adf();
      ((adf)localObject3).aoC((String)paramString.get((String)localObject2 + ".clean_url"));
      ((adf)localObject3).aoB((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((adf)localObject3).aoD((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((adf)localObject3).aoA((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((adf)localObject3).MS(bo.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((adf)localObject3).MT(bo.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((adf)localObject3).aoE((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((acb)localObject1).a((adf)localObject3);
      continue;
      label3240:
      localObject3 = new acp();
      ((acp)localObject3).aog((String)paramString.get((String)localObject2 + ".producttitle"));
      ((acp)localObject3).aoh((String)paramString.get((String)localObject2 + ".productdesc"));
      ((acp)localObject3).aoi((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((acp)localObject3).aoj((String)paramString.get((String)localObject2 + ".productinfo"));
      ((acp)localObject3).MO(bo.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((acb)localObject1).a((acp)localObject3);
      continue;
      label3444:
      localObject3 = new acz();
      ((acz)localObject3).aow((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((acz)localObject3).aox((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((acz)localObject3).aoy((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((acz)localObject3).aoz((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((acb)localObject1).a((acz)localObject3);
      continue;
      label3608:
      localObject3 = new aby();
      ((aby)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((aby)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((aby)localObject3).cvs = bo.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((aby)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((aby)localObject3).type = bo.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((aby)localObject3).cmG = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((aby)localObject3).wSs = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((acb)localObject1).a((aby)localObject3);
      continue;
      label3881:
      AppMethodBeat.o(102755);
      return;
      label3887:
      paramString = null;
      continue;
      label3892:
      localObject1 = null;
      continue;
      label3898:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */