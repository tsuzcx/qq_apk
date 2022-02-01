package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class a
{
  private static DocumentBuilder lxg = null;
  
  public static a.a Sw(String paramString)
  {
    AppMethodBeat.i(153105);
    a.a locala = new a.a();
    Log.d("MicroMsg.ABTestParser", "ABTest msg content: %s", new Object[] { paramString });
    Object localObject1 = Sy(paramString);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.ABTestParser", "Msg parsing failed, msg: %s", new Object[] { paramString });
      AppMethodBeat.o(153105);
      return locala;
    }
    paramString = ((Element)localObject1).getAttributes();
    if (paramString == null)
    {
      AppMethodBeat.o(153105);
      return null;
    }
    paramString = paramString.getNamedItem("type");
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label469:
    boolean bool;
    label859:
    long l2;
    if ((paramString != null) && ("newabtestinfo".equals(paramString.getNodeValue())))
    {
      paramString = ((Element)localObject1).getElementsByTagName("prioritylevel");
      if (paramString.getLength() > 0)
      {
        i = Util.getInt(paramString.item(0).getTextContent(), 1);
        localObject1 = ((Element)localObject1).getChildNodes();
        int j = 0;
        if (j < ((NodeList)localObject1).getLength())
        {
          localObject2 = ((NodeList)localObject1).item(j);
          if ((localObject2 == null) || ((((Node)localObject2).getNodeType() == 1) && (((Node)localObject2).getNodeName().equals("exp")))) {}
          for (;;)
          {
            try
            {
              localObject3 = (Element)localObject2;
              paramString = new c();
              localObject4 = ((Element)localObject3).getAttributes();
              if (localObject4 != null) {
                continue;
              }
              paramString = null;
            }
            catch (Exception paramString)
            {
              Log.printErrStackTrace("MicroMsg.ABTestParser", paramString, "parseExp", new Object[0]);
              continue;
              paramString.field_sequence = Util.getLong(((NodeList)localObject4).item(0).getTextContent(), 0L);
              localObject4 = ((Element)localObject3).getElementsByTagName("prioritylevel");
              if (((NodeList)localObject4).getLength() <= 0) {
                continue;
              }
              paramString.field_prioritylevel = Util.getInt(((NodeList)localObject4).item(0).getTextContent(), 0);
              localObject4 = ((Element)localObject3).getElementsByTagName("starttime");
              if (((NodeList)localObject4).getLength() <= 0) {
                continue;
              }
              paramString.field_startTime = Util.getLong(((NodeList)localObject4).item(0).getTextContent(), 0L);
              if (paramString.field_startTime != 0L) {
                continue;
              }
              paramString.field_startTime = (System.currentTimeMillis() / 1000L);
              localObject4 = ((Element)localObject3).getElementsByTagName("endtime");
              if (((NodeList)localObject4).getLength() <= 0) {
                continue;
              }
              paramString.field_endTime = Util.getLong(((NodeList)localObject4).item(0).getTextContent(), 0L);
              if (paramString.field_endTime != 0L) {
                continue;
              }
              paramString.field_endTime = 9223372036854775807L;
              localObject4 = ((Element)localObject3).getElementsByTagName("noreport");
              if (((NodeList)localObject4).getLength() <= 0) {
                continue;
              }
              if (Util.getInt(((NodeList)localObject4).item(0).getTextContent(), 0) != 0) {
                continue;
              }
              bool = true;
              paramString.field_needReport = bool;
              paramString.field_rawXML = a((Node)localObject3);
              continue;
              paramString.field_prioritylevel = 0;
              continue;
              bool = false;
              continue;
              localObject2 = ((NamedNodeMap)localObject2).getNamedItem("id");
              if (localObject2 != null) {
                continue;
              }
              paramString = null;
              continue;
              localObject2 = ((Node)localObject2).getNodeValue();
              localObject3 = ((Element)localObject4).getElementsByTagName("sequence");
              if (((NodeList)localObject3).getLength() != 0) {
                continue;
              }
              paramString = null;
              continue;
              l3 = Util.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
              localObject3 = ((Element)localObject4).getElementsByTagName("starttime");
              if (((NodeList)localObject3).getLength() <= 0) {
                continue;
              }
              l1 = Util.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
              if (l1 != 0L) {
                break label1285;
              }
              l1 = System.currentTimeMillis() / 1000L;
            }
            locala.lxh.add(paramString);
            if ((((Node)localObject2).getNodeType() == 1) && (((Node)localObject2).getNodeName().equals("expinfo"))) {}
            try
            {
              localObject4 = (Element)localObject2;
              paramString = new LinkedList();
              localObject2 = ((Element)localObject4).getAttributes();
              if (localObject2 != null) {
                continue;
              }
              paramString = null;
            }
            catch (Exception paramString)
            {
              Object localObject5;
              long l3;
              long l1;
              Log.e("MicroMsg.ABTestParser", paramString.getMessage());
              continue;
              continue;
            }
            locala.lxi.addAll(paramString);
            j += 1;
            break;
            localObject5 = ((NamedNodeMap)localObject4).getNamedItem("layerid");
            if (localObject5 == null)
            {
              paramString = null;
            }
            else
            {
              paramString.field_layerId = ((Node)localObject5).getNodeValue();
              localObject5 = ((NamedNodeMap)localObject4).getNamedItem("id");
              if (localObject5 == null)
              {
                paramString = null;
              }
              else
              {
                paramString.field_expId = ((Node)localObject5).getNodeValue();
                localObject4 = ((NamedNodeMap)localObject4).getNamedItem("business");
                if (localObject4 == null) {}
                for (paramString.field_business = "";; paramString.field_business = ((Node)localObject4).getNodeValue())
                {
                  localObject4 = ((Element)localObject3).getElementsByTagName("sequence");
                  if (((NodeList)localObject4).getLength() != 0) {
                    break label469;
                  }
                  paramString = null;
                  break;
                }
                localObject3 = ((Element)localObject4).getElementsByTagName("endtime");
                if (((NodeList)localObject3).getLength() <= 0) {
                  break label1293;
                }
                l2 = Util.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
                if (l2 == 0L) {
                  break label1293;
                }
              }
            }
          }
        }
      }
    }
    int k;
    for (;;)
    {
      localObject3 = ((Element)localObject4).getElementsByTagName("noreport");
      if (((NodeList)localObject3).getLength() > 0)
      {
        if (Util.getInt(((NodeList)localObject3).item(0).getTextContent(), 0) != 1) {
          break label1311;
        }
        bool = true;
        break label1301;
      }
      for (;;)
      {
        localObject3 = new HashMap();
        localObject4 = ((Element)localObject4).getElementsByTagName("args");
        label1004:
        Object localObject6;
        if (((NodeList)localObject4).getLength() > 0)
        {
          localObject4 = ((NodeList)localObject4).item(0).getChildNodes();
          k = 0;
          if (k < ((NodeList)localObject4).getLength())
          {
            localObject6 = ((NodeList)localObject4).item(k);
            if ((((Node)localObject6).getNodeType() != 1) || (!((Node)localObject6).getNodeName().equals("arg"))) {
              break;
            }
            localObject5 = ((Element)localObject6).getElementsByTagName("key");
            localObject6 = ((Element)localObject6).getElementsByTagName("value");
            if ((((NodeList)localObject5).getLength() == 0) || (((NodeList)localObject6).getLength() == 0)) {
              break;
            }
            ((HashMap)localObject3).put(((NodeList)localObject5).item(0).getTextContent(), ((NodeList)localObject6).item(0).getTextContent());
            break;
          }
        }
        localObject4 = ((HashMap)localObject3).keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          localObject6 = new com.tencent.mm.storage.a();
          ((com.tencent.mm.storage.a)localObject6).field_abtestkey = ((String)localObject5);
          ((com.tencent.mm.storage.a)localObject6).field_value = ((String)((HashMap)localObject3).get(localObject5));
          ((com.tencent.mm.storage.a)localObject6).field_expId = ((String)localObject2);
          ((com.tencent.mm.storage.a)localObject6).field_sequence = l3;
          ((com.tencent.mm.storage.a)localObject6).field_prioritylevel = i;
          ((com.tencent.mm.storage.a)localObject6).field_startTime = l1;
          ((com.tencent.mm.storage.a)localObject6).field_endTime = l2;
          ((com.tencent.mm.storage.a)localObject6).field_noReport = bool;
          paramString.add(localObject6);
        }
        AppMethodBeat.o(153105);
        return locala;
        bool = false;
      }
      continue;
      label1285:
      break label859;
      i = 1;
      break;
      label1293:
      l2 = 9223372036854775807L;
    }
    for (;;)
    {
      label1301:
      break;
      k += 1;
      break label1004;
      label1311:
      bool = false;
    }
  }
  
  public static Map<String, String> Sx(String paramString)
  {
    AppMethodBeat.i(153106);
    HashMap localHashMap = new HashMap();
    Object localObject1 = Sy(paramString);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.ABTestParser", "Raw XML string parsing failed, xml: %s", new Object[] { paramString });
      AppMethodBeat.o(153106);
      return localHashMap;
    }
    paramString = ((Element)localObject1).getElementsByTagName("args");
    if (paramString.getLength() > 0)
    {
      paramString = paramString.item(0).getChildNodes();
      int i = 0;
      while (i < paramString.getLength())
      {
        Object localObject2 = paramString.item(i);
        if ((((Node)localObject2).getNodeType() == 1) && (((Node)localObject2).getNodeName().equals("arg")))
        {
          localObject1 = ((Element)localObject2).getElementsByTagName("key");
          localObject2 = ((Element)localObject2).getElementsByTagName("value");
          if ((((NodeList)localObject1).getLength() != 0) && (((NodeList)localObject2).getLength() != 0)) {
            localHashMap.put(((NodeList)localObject1).item(0).getTextContent(), ((NodeList)localObject2).item(0).getTextContent());
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(153106);
    return localHashMap;
  }
  
  private static Element Sy(String paramString)
  {
    AppMethodBeat.i(153107);
    try
    {
      InputSource localInputSource = new InputSource(new ByteArrayInputStream(paramString.getBytes()));
      if (lxg != null) {
        paramString = lxg;
      }
      for (;;)
      {
        paramString = paramString.parse(localInputSource);
        paramString.normalize();
        paramString = paramString.getDocumentElement();
        AppMethodBeat.o(153107);
        return paramString;
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        lxg = paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ABTestParser", paramString.toString());
      AppMethodBeat.o(153107);
    }
  }
  
  private static String a(Node paramNode)
  {
    AppMethodBeat.i(153108);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
      localTransformer.setOutputProperty("omit-xml-declaration", "yes");
      localTransformer.transform(new DOMSource(paramNode), new StreamResult(localStringWriter));
      paramNode = localStringWriter.toString();
      AppMethodBeat.o(153108);
      return paramNode;
    }
    catch (TransformerException paramNode)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ABTestParser", paramNode, "nodeToString", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c.a
 * JD-Core Version:    0.7.0.1
 */