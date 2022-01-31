package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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

public final class b
{
  public static void a(String paramString, yj paramyj)
  {
    paramyj.sXc.clear();
    Object localObject1 = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      try
      {
        paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes())));
        paramString.normalize();
        paramString = paramString.getDocumentElement().getElementsByTagName("datalist");
        if (paramString != null)
        {
          NodeList localNodeList = paramString.item(0).getChildNodes();
          if ((localNodeList != null) && (localNodeList.getLength() > 0))
          {
            int j = localNodeList.getLength();
            i = 0;
            if (i < j)
            {
              localObject1 = localNodeList.item(i);
              paramString = bn.b((Node)localObject1);
              localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
              if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
                break label3838;
              }
              localObject1 = bn.b(((NodeList)localObject1).item(0).getFirstChild());
              if (!paramString.trim().startsWith("<dataitem")) {
                break label3833;
              }
              paramString = bn.s(paramString, "dataitem");
              if (paramString == null) {
                break label3844;
              }
              xv localxv = new xv();
              localxv.EH(bk.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
              localxv.XM((String)paramString.get(".dataitem" + ".$datasourceid"));
              localxv.EI(bk.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
              localxv.XE((String)paramString.get(".dataitem" + ".datafmt"));
              localxv.Xu((String)paramString.get(".dataitem" + ".datatitle"));
              localxv.Xv((String)paramString.get(".dataitem" + ".datadesc"));
              localxv.Xw((String)paramString.get(".dataitem" + ".cdn_thumburl"));
              localxv.Xx((String)paramString.get(".dataitem" + ".cdn_thumbkey"));
              localxv.EE(bk.getInt((String)paramString.get(".dataitem" + ".thumb_width"), 0));
              localxv.EF(bk.getInt((String)paramString.get(".dataitem" + ".thumb_height"), 0));
              localxv.Xy((String)paramString.get(".dataitem" + ".cdn_dataurl"));
              localxv.Xz((String)paramString.get(".dataitem" + ".cdn_datakey"));
              localObject2 = (String)paramString.get(".dataitem" + ".duration");
              if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
                localxv.EG(bk.getInt((String)localObject2, 0));
              }
              localxv.XB((String)paramString.get(".dataitem" + ".stream_dataurl"));
              localxv.XC((String)paramString.get(".dataitem" + ".stream_lowbandurl"));
              localxv.XA((String)paramString.get(".dataitem" + ".stream_weburl"));
              localxv.XT((String)paramString.get(".dataitem" + ".canvasPageXml"));
              localxv.XF((String)paramString.get(".dataitem" + ".fullmd5"));
              localxv.XG((String)paramString.get(".dataitem" + ".head256md5"));
              localObject2 = (String)paramString.get(".dataitem" + ".fullsize");
              if (!bk.bl((String)localObject2)) {
                localxv.hf(bk.getInt((String)localObject2, 0));
              }
              localxv.XD((String)paramString.get(".dataitem" + ".dataext"));
              localxv.XK((String)paramString.get(".dataitem" + ".thumbfullmd5"));
              localxv.XL((String)paramString.get(".dataitem" + ".thumbhead256md5"));
              localObject2 = (String)paramString.get(".dataitem" + ".thumbfullsize");
              if (!bk.bl((String)localObject2)) {
                localxv.hg(bk.getInt((String)localObject2, 0));
              }
              localxv.XN((String)paramString.get(".dataitem" + ".stream_videoid"));
              localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
              if (!bk.bl((String)localObject3))
              {
                localObject2 = localObject3;
                if (((String)localObject3).length() >= 32) {}
              }
              else
              {
                localObject2 = com.tencent.mm.plugin.fav.a.b.bB(localxv.toString(), localxv.aYU);
              }
              localxv.XH((String)localObject2);
              localxv.XO((String)paramString.get(".dataitem" + ".datasrctitle"));
              localxv.XP((String)paramString.get(".dataitem" + ".datasrcname"));
              localxv.XQ((String)paramString.get(".dataitem" + ".datasrctime"));
              localxv.XS((String)paramString.get(".dataitem" + ".statextstr"));
              localxv.XR((String)paramString.get(".dataitem" + ".$htmlid"));
              localxv.EJ(bk.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
              if (localObject1 != null) {
                localxv.XU((String)localObject1);
              }
              localObject1 = new xy();
              ((xy)localObject1).dSP = bk.aM((String)paramString.get(".dataitem" + ".streamvideo.streamvideourl"), "");
              ((xy)localObject1).sWK = bk.ZR((String)paramString.get(".dataitem" + ".streamvideo.streamvideototaltime"));
              ((xy)localObject1).dSR = bk.aM((String)paramString.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
              ((xy)localObject1).dSS = bk.aM((String)paramString.get(".dataitem" + ".streamvideo.streamvideowording"), "");
              ((xy)localObject1).dST = bk.aM((String)paramString.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
              ((xy)localObject1).dSV = bk.aM((String)paramString.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
              ((xy)localObject1).dSW = bk.aM((String)paramString.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
              localxv.a((xy)localObject1);
              localObject1 = new xw();
              localObject2 = ".dataitem" + ".dataitemsource";
              if (!paramString.containsKey(localObject2))
              {
                y.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
                localObject3 = ".dataitem" + ".locitem";
                if (paramString.containsKey(localObject3)) {
                  break label2556;
                }
                y.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject3 });
                localObject2 = ".dataitem" + ".weburlitem";
                if (paramString.containsKey(localObject2)) {
                  break label2913;
                }
                y.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
                localObject2 = ".dataitem" + ".productitem";
                if (paramString.containsKey(localObject2)) {
                  break label3192;
                }
                y.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
                localObject2 = ".dataitem" + ".tvitem";
                if (paramString.containsKey(localObject2)) {
                  break label3396;
                }
                y.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
                localObject2 = ".dataitem" + ".appbranditem";
                if (paramString.containsKey(localObject2)) {
                  break label3560;
                }
                y.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[] { localObject2 });
                localxv.a((xw)localObject1);
                paramyj.sXc.add(localxv);
                break label3844;
              }
              localObject3 = new xx();
              ((xx)localObject3).EL(bk.getInt((String)paramString.get((String)localObject2 + ".$sourcetype"), 0));
              ((xx)localObject3).Yb((String)paramString.get((String)localObject2 + ".$sourceid"));
              ((xx)localObject3).XZ((String)paramString.get((String)localObject2 + ".fromusr"));
              ((xx)localObject3).Ya((String)paramString.get((String)localObject2 + ".tousr"));
              ((xx)localObject3).Yc((String)paramString.get((String)localObject2 + ".realchatname"));
              ((xx)localObject3).hi(bk.getLong((String)paramString.get((String)localObject2 + ".createtime"), 0L));
              ((xx)localObject3).Yd((String)paramString.get((String)localObject2 + ".msgid"));
              ((xx)localObject3).cbd = ((String)paramString.get((String)localObject2 + ".eventid"));
              ((xx)localObject3).sWE = true;
              ((xx)localObject3).Ye((String)paramString.get((String)localObject2 + ".appid"));
              ((xx)localObject3).Yf((String)paramString.get((String)localObject2 + ".link"));
              ((xx)localObject3).Yg((String)paramString.get((String)localObject2 + ".brandid"));
              ((xw)localObject1).c((xx)localObject3);
              continue;
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      }
      label2556:
      Object localObject2 = new yc();
      if (!bk.bl((String)paramString.get((String)localObject3 + ".label"))) {
        ((yc)localObject2).Yh((String)paramString.get((String)localObject3 + ".label"));
      }
      if (!bk.bl((String)paramString.get((String)localObject3 + ".poiname"))) {
        ((yc)localObject2).Yi((String)paramString.get((String)localObject3 + ".poiname"));
      }
      String str = (String)paramString.get((String)localObject3 + ".lng");
      if (!bk.bl(str)) {
        ((yc)localObject2).y(bk.getDouble(str, 0.0D));
      }
      str = (String)paramString.get((String)localObject3 + ".lat");
      if (!bk.bl(str)) {
        ((yc)localObject2).z(bk.getDouble(str, 0.0D));
      }
      Object localObject3 = (String)paramString.get((String)localObject3 + ".scale");
      if (!bk.bl((String)localObject3))
      {
        if (((String)localObject3).indexOf('.') == -1) {
          break label2898;
        }
        ((yc)localObject2).EM(bk.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
      }
      for (;;)
      {
        ((xw)localObject1).a((yc)localObject2);
        break;
        label2898:
        ((yc)localObject2).EM(bk.getInt((String)localObject3, -1));
      }
      label2913:
      localObject3 = new yy();
      ((yy)localObject3).YF((String)paramString.get((String)localObject2 + ".clean_url"));
      ((yy)localObject3).YE((String)paramString.get((String)localObject2 + ".pagedesc"));
      ((yy)localObject3).YG((String)paramString.get((String)localObject2 + ".pagethumb_url"));
      ((yy)localObject3).YD((String)paramString.get((String)localObject2 + ".pagetitle"));
      ((yy)localObject3).ER(bk.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((yy)localObject3).ES(bk.getInt((String)paramString.get((String)localObject2 + ".contentattr"), 0));
      ((yy)localObject3).YH((String)paramString.get((String)localObject2 + ".canvasPageXml"));
      ((xw)localObject1).a((yy)localObject3);
      continue;
      label3192:
      localObject3 = new yi();
      ((yi)localObject3).Yj((String)paramString.get((String)localObject2 + ".producttitle"));
      ((yi)localObject3).Yk((String)paramString.get((String)localObject2 + ".productdesc"));
      ((yi)localObject3).Yl((String)paramString.get((String)localObject2 + ".productthumb_url"));
      ((yi)localObject3).Ym((String)paramString.get((String)localObject2 + ".productinfo"));
      ((yi)localObject3).EN(bk.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((xw)localObject1).a((yi)localObject3);
      continue;
      label3396:
      localObject3 = new ys();
      ((ys)localObject3).Yz((String)paramString.get((String)localObject2 + ".tvtitle"));
      ((ys)localObject3).YA((String)paramString.get((String)localObject2 + ".tvdesc"));
      ((ys)localObject3).YB((String)paramString.get((String)localObject2 + ".tvthumb_url"));
      ((ys)localObject3).YC((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((xw)localObject1).a((ys)localObject3);
      continue;
      label3560:
      localObject3 = new xt();
      ((xt)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((xt)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((xt)localObject3).bOa = bk.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((xt)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((xt)localObject3).type = bk.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((xt)localObject3).bFw = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((xt)localObject3).sUv = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((xw)localObject1).a((xt)localObject3);
      continue;
      label3833:
      paramString = null;
      continue;
      label3838:
      localObject1 = null;
      continue;
      label3844:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */