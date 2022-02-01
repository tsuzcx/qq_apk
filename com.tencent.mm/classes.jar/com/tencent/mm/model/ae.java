package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class ae
  implements h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(150155);
    parama = parama.heO;
    if ((parama == null) || (parama.KHn == null))
    {
      Log.f("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(150155);
      return null;
    }
    Log.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension start");
    parama = z.a(parama.KHn);
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
            int k = Util.getInt(((Node)localObject).getNodeValue(), 0);
            localObject = new cw();
            ((cw)localObject).dFY.packageType = k;
            EventCenter.instance.publish((IEvent)localObject);
            break label298;
          }
        }
        Log.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension end");
        AppMethodBeat.o(150155);
        return null;
      }
      catch (Exception parama)
      {
        Log.e("MicroMsg.DeletePackageMsgExtension", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
        AppMethodBeat.o(150155);
        return null;
      }
      label298:
      i += 1;
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.ae
 * JD-Core Version:    0.7.0.1
 */