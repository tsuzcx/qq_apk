package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.aks;
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
  public static void a(String paramString, akd paramakd)
  {
    AppMethodBeat.i(103499);
    paramakd.nZa.clear();
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
        paramString = bw.M(paramString, "dataitem");
        if (paramString == null) {
          break label4285;
        }
        ajn localajn = new ajn();
        localajn.ZI(bt.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localajn.aOx((String)paramString.get(".dataitem" + ".$datasourceid"));
        localajn.ZJ(bt.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localajn.aOp((String)paramString.get(".dataitem" + ".datafmt"));
        localajn.aOf((String)paramString.get(".dataitem" + ".datatitle"));
        localajn.aOg((String)paramString.get(".dataitem" + ".datadesc"));
        localajn.aOh((String)paramString.get(".dataitem" + ".cdn_thumburl"));
        localajn.aOi((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
        localajn.ZF(bt.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
        localajn.ZG(bt.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
        localajn.aOj((String)paramString.get(".dataitem" + ".cdn_dataurl"));
        localajn.aOk((String)paramString.get(".dataitem" + ".cdn_datakey"));
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localajn.ZH(bt.getInt((String)localObject2, 0));
        }
        localajn.aOm((String)paramString.get(".dataitem" + ".stream_dataurl"));
        localajn.aOn((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
        localajn.aOl((String)paramString.get(".dataitem" + ".stream_weburl"));
        localajn.aOL((String)paramString.get(".dataitem" + ".songalbumurl"));
        localajn.aOM((String)paramString.get(".dataitem" + ".songlyric"));
        localajn.aOE((String)paramString.get(".dataitem" + ".canvasPageXml"));
        localajn.aOq((String)paramString.get(".dataitem" + ".fullmd5"));
        localajn.aOr((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
        if (!bt.isNullOrNil((String)localObject2)) {
          localajn.CG(bt.getInt((String)localObject2, 0));
        }
        localajn.aOo((String)paramString.get(".dataitem" + ".dataext"));
        localajn.aOv((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localajn.aOw((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
        if (!bt.isNullOrNil((String)localObject2)) {
          localajn.CH(bt.getInt((String)localObject2, 0));
        }
        localajn.aOy((String)paramString.get(".dataitem" + ".stream_videoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        if (!bt.isNullOrNil((String)localObject3))
        {
          localObject2 = localObject3;
          if (((String)localObject3).length() >= 32) {}
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.fav.a.b.di(localajn.toString(), localajn.dataType);
        }
        localajn.aOs((String)localObject2);
        localajn.aOz((String)paramString.get(".dataitem" + ".datasrctitle"));
        localajn.aOA((String)paramString.get(".dataitem" + ".datasrcname"));
        localajn.aOB((String)paramString.get(".dataitem" + ".datasrctime"));
        localajn.aOD((String)paramString.get(".dataitem" + ".statextstr"));
        localajn.aOC((String)paramString.get(".dataitem" + ".$htmlid"));
        localajn.ZK(bt.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localajn.aON((String)paramString.get(".dataitem" + ".messageuuid"));
        if (localObject1 != null) {
          localajn.aOF((String)localObject1);
        }
        localObject1 = new ajq();
        ((ajq)localObject1).hCe = bt.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
        ((ajq)localObject1).Gje = bt.aRe((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
        ((ajq)localObject1).hCg = bt.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
        ((ajq)localObject1).hCh = bt.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
        ((ajq)localObject1).hCi = bt.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
        ((ajq)localObject1).hCk = bt.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
        ((ajq)localObject1).hCl = bt.bI((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
        localajn.a((ajq)localObject1);
        localObject1 = new ajo();
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
            ((ajo)localObject1).c(e.v(".dataitem", paramString));
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
            localObject2 = b.t(".dataitem" + ".weburlitem.appmsgshareitem", paramString);
            if (localObject2 != null) {
              ((ajo)localObject1).d((ajv)localObject2);
            }
            paramString = b.u(".dataitem" + ".favbrandmpvideo", paramString);
            if (paramString != null) {
              ((ajo)localObject1).e(paramString);
            }
            localajn.a((ajo)localObject1);
            paramakd.nZa.add(localajn);
            break label4285;
          }
        }
        else
        {
          localObject3 = new ajp();
          ((ajp)localObject3).ZM(bt.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
          ((ajp)localObject3).aOQ((String)paramString.get((String)localObject2 + ".$sourceid"));
          ((ajp)localObject3).aOO((String)paramString.get((String)localObject2 + ".fromusr"));
          ((ajp)localObject3).aOP((String)paramString.get((String)localObject2 + ".tousr"));
          ((ajp)localObject3).aOR((String)paramString.get((String)localObject2 + ".realchatname"));
          ((ajp)localObject3).CJ(bt.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
          ((ajp)localObject3).aOS((String)paramString.get((String)localObject2 + ".msgid"));
          ((ajp)localObject3).dKz = ((String)paramString.get((String)localObject2 + ".eventid"));
          ((ajp)localObject3).GiY = true;
          ((ajp)localObject3).aOT((String)paramString.get((String)localObject2 + ".appid"));
          ((ajp)localObject3).aOU((String)paramString.get((String)localObject2 + ".link"));
          ((ajp)localObject3).aOV((String)paramString.get((String)localObject2 + ".brandid"));
          ((ajo)localObject1).c((ajp)localObject3);
          continue;
        }
        localObject2 = new aju();
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(103499);
        return;
      }
      if (!bt.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
        ((aju)localObject2).aOW((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!bt.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((aju)localObject2).aOX((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!bt.isNullOrNil(str)) {
        ((aju)localObject2).A(bt.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!bt.isNullOrNil(str)) {
        ((aju)localObject2).B(bt.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!bt.isNullOrNil((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label3106;
        }
        ((aju)localObject2).ZN(bt.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((ajo)localObject1).c((aju)localObject2);
        break;
        label3106:
        ((aju)localObject2).ZN(bt.getInt((String)localObject3, -1));
      }
      label3121:
      localObject3 = new aks();
      ((aks)localObject3).aPu((String)paramString.get((String)localObject2 + ".clean_url"));
      ((aks)localObject3).aPt((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((aks)localObject3).aPv((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((aks)localObject3).aPs((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((aks)localObject3).ZS(bt.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((aks)localObject3).ZT(bt.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((aks)localObject3).aPw((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((aks)localObject3).aPx((String)paramString.get((String)localObject2 + ".wsVideoFlowXml"));
      ((ajo)localObject1).a((aks)localObject3);
      continue;
      label3436:
      localObject3 = new akc();
      ((akc)localObject3).aOY((String)paramString.get((String)localObject2 + ".producttitle"));
      ((akc)localObject3).aOZ((String)paramString.get((String)localObject2 + ".productdesc"));
      ((akc)localObject3).aPa((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((akc)localObject3).aPb((String)paramString.get((String)localObject2 + ".productinfo"));
      ((akc)localObject3).ZO(bt.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((ajo)localObject1).a((akc)localObject3);
      continue;
      label3640:
      localObject3 = new akm();
      ((akm)localObject3).aPo((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((akm)localObject3).aPp((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((akm)localObject3).aPq((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((akm)localObject3).aPr((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((ajo)localObject1).a((akm)localObject3);
      continue;
      label3804:
      localObject3 = new ajl();
      ((ajl)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((ajl)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((ajl)localObject3).dtF = bt.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((ajl)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((ajl)localObject3).type = bt.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((ajl)localObject3).dki = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((ajl)localObject3).GgH = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((ajl)localObject3).version = bt.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((ajl)localObject3).kro = bt.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((ajl)localObject3).jXI = bt.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((ajl)localObject3).dJW = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((ajl)localObject3).subType = bt.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((ajo)localObject1).b((ajl)localObject3);
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
  
  public static akd c(akd paramakd)
  {
    AppMethodBeat.i(103500);
    if (paramakd == null)
    {
      AppMethodBeat.o(103500);
      return null;
    }
    akd localakd = new akd();
    if (paramakd.Gjw) {
      localakd.a(paramakd.Gjv);
    }
    if (paramakd.Gjx) {
      localakd.bl(paramakd.nZa);
    }
    if (paramakd.Giv) {
      localakd.d(paramakd.Giu);
    }
    if (paramakd.Gix) {
      localakd.b(paramakd.Giw);
    }
    if (paramakd.GiC) {
      localakd.aPc(paramakd.iTM);
    }
    if (paramakd.GgK) {
      localakd.aPd(paramakd.title);
    }
    if (paramakd.GgL) {
      localakd.aPe(paramakd.desc);
    }
    if (paramakd.GiE) {
      localakd.CK(paramakd.GiD);
    }
    if (paramakd.GiG) {
      localakd.ZP(paramakd.GiF);
    }
    if (paramakd.Giz) {
      localakd.b(paramakd.Giy);
    }
    if (paramakd.GiH) {
      localakd.CL(paramakd.pQi);
    }
    if (paramakd.GiB) {
      localakd.b(paramakd.GiA);
    }
    if (paramakd.Gjy) {
      localakd.ZQ(paramakd.version);
    }
    if (paramakd.GiI) {
      localakd.a(paramakd.FpF);
    }
    if (paramakd.GiK) {
      localakd.c(paramakd.GiJ);
    }
    if (paramakd.GiL) {
      localakd.f(paramakd.DSw);
    }
    if (paramakd.GiP) {
      localakd.d(paramakd.GiO);
    }
    AppMethodBeat.o(103500);
    return localakd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.c
 * JD-Core Version:    0.7.0.1
 */