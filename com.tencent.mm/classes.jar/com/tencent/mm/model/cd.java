package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class cd
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(77826);
    parama = parama.eyJ;
    if ((parama == null) || (parama.woR == null))
    {
      ab.f("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(77826);
      return null;
    }
    ab.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension start");
    parama = aa.a(parama.woR);
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
              break label290;
            }
            localObject = ((Node)localObject).getAttributes();
            if (localObject == null) {
              break label290;
            }
            localObject = ((NamedNodeMap)localObject).getNamedItem("type");
            if (localObject == null) {
              break label290;
            }
            localObject = new k(bo.getInt(((Node)localObject).getNodeValue(), 0));
            g.RK().eHt.a((m)localObject, 0);
            break label290;
          }
        }
        ab.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension end");
        AppMethodBeat.o(77826);
        return null;
      }
      catch (Exception parama)
      {
        ab.e("MicroMsg.UpdatePackageMsgExtension", "exception:%s", new Object[] { bo.l(parama) });
        AppMethodBeat.o(77826);
        return null;
      }
      label290:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.cd
 * JD-Core Version:    0.7.0.1
 */