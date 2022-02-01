package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
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

public final class z
  implements f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(150155);
    parama = parama.fTo;
    if ((parama == null) || (parama.Cxz == null))
    {
      ad.f("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(150155);
      return null;
    }
    ad.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension start");
    parama = com.tencent.mm.platformtools.z.a(parama.Cxz);
    Object localObject = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      try
      {
        parama = ((DocumentBuilderFactory)localObject).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(parama.getBytes("utf-8"))));
        parama.normalize();
        parama = parama.getDocumentElement().getElementsByTagName("deletepackage");
        if ((parama != null) && (parama.getLength() == 1))
        {
          parama = parama.item(0).getChildNodes();
          int j = parama.getLength();
          i = 0;
          if (i < j)
          {
            localObject = parama.item(i);
            if ((localObject == null) || (((Node)localObject).getNodeName() == null) || (!((Node)localObject).getNodeName().equals("pack"))) {
              break label298;
            }
            localObject = ((Node)localObject).getAttributes();
            if (localObject == null) {
              break label298;
            }
            localObject = ((NamedNodeMap)localObject).getNamedItem("type");
            if (localObject == null) {
              break label298;
            }
            int k = bt.getInt(((Node)localObject).getNodeValue(), 0);
            localObject = new cp();
            ((cp)localObject).deO.deP = k;
            a.ESL.l((b)localObject);
            break label298;
          }
        }
        ad.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension end");
        AppMethodBeat.o(150155);
        return null;
      }
      catch (Exception parama)
      {
        ad.e("MicroMsg.DeletePackageMsgExtension", "exception:%s", new Object[] { bt.m(parama) });
        AppMethodBeat.o(150155);
        return null;
      }
      label298:
      i += 1;
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.z
 * JD-Core Version:    0.7.0.1
 */