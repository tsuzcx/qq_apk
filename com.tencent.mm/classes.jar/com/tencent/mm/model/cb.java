package com.tencent.mm.model;

import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.k;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class cb
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    parama = parama.dBs;
    if ((parama == null) || (parama.svH == null))
    {
      y.f("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension failed, invalid cmdAM");
      return null;
    }
    y.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension start");
    parama = aa.a(parama.svH);
    Object localObject = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      try
      {
        parama = ((DocumentBuilderFactory)localObject).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(parama.getBytes("utf-8"))));
        parama.normalize();
        parama = parama.getDocumentElement().getElementsByTagName("updatepackage");
        if ((parama != null) && (parama.getLength() == 1))
        {
          parama = parama.item(0).getChildNodes();
          int j = parama.getLength();
          i = 0;
          if (i < j)
          {
            localObject = parama.item(i);
            if ((localObject == null) || (((Node)localObject).getNodeName() == null) || (!((Node)localObject).getNodeName().equals("pack"))) {
              break label270;
            }
            localObject = ((Node)localObject).getAttributes();
            if (localObject == null) {
              break label270;
            }
            localObject = ((NamedNodeMap)localObject).getNamedItem("type");
            if (localObject == null) {
              break label270;
            }
            localObject = new k(bk.getInt(((Node)localObject).getNodeValue(), 0));
            g.DO().dJT.a((m)localObject, 0);
            break label270;
          }
        }
        y.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension end");
        return null;
      }
      catch (Exception parama)
      {
        y.e("MicroMsg.UpdatePackageMsgExtension", "exception:%s", new Object[] { bk.j(parama) });
        return null;
      }
      label270:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.cb
 * JD-Core Version:    0.7.0.1
 */