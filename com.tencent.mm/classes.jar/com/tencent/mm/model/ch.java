package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.l;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class ch
  implements e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(150190);
    parama = parama.gqE;
    if ((parama == null) || (parama.Fvk == null))
    {
      ad.f("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(150190);
      return null;
    }
    ad.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension start");
    parama = z.a(parama.Fvk);
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
            localObject = new l(bt.getInt(((Node)localObject).getNodeValue(), 0));
            g.ajB().gAO.a((n)localObject, 0);
            break label290;
          }
        }
        ad.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension end");
        AppMethodBeat.o(150190);
        return null;
      }
      catch (Exception parama)
      {
        ad.e("MicroMsg.UpdatePackageMsgExtension", "exception:%s", new Object[] { bt.n(parama) });
        AppMethodBeat.o(150190);
        return null;
      }
      label290:
      i += 1;
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.ch
 * JD-Core Version:    0.7.0.1
 */