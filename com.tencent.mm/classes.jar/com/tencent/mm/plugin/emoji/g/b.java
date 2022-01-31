package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b
{
  public static ArrayList<ut> AS(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
    }
    for (;;)
    {
      return null;
      Object localObject1 = DocumentBuilderFactory.newInstance();
      try
      {
        paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes())));
        paramString.normalize();
        paramString = paramString.getDocumentElement().getElementsByTagName("EmojiMd5");
        if ((paramString != null) && (paramString.getLength() > 0))
        {
          localObject1 = new ArrayList();
          int j = paramString.getLength();
          int i = 0;
          while (i < j)
          {
            Object localObject2 = paramString.item(i);
            ut localut = new ut();
            String str = ((Node)localObject2).getTextContent().toLowerCase();
            localObject2 = ((Node)localObject2).getAttributes();
            Node localNode = ((NamedNodeMap)localObject2).getNamedItem("thumburl");
            if (localNode != null) {
              localut.mQp = localNode.getNodeValue();
            }
            localNode = ((NamedNodeMap)localObject2).getNamedItem("cdnurl");
            if (localNode != null) {
              localut.kSC = localNode.getNodeValue();
            }
            localNode = ((NamedNodeMap)localObject2).getNamedItem("productid");
            if (localNode != null) {
              localut.syc = localNode.getNodeValue();
            }
            localNode = ((NamedNodeMap)localObject2).getNamedItem("designerid");
            if (localNode != null) {
              localut.sRs = localNode.getNodeValue();
            }
            localNode = ((NamedNodeMap)localObject2).getNamedItem("aeskey");
            if (localNode != null) {
              localut.sRu = localNode.getNodeValue();
            }
            localNode = ((NamedNodeMap)localObject2).getNamedItem("encrypturl");
            if (localNode != null) {
              localut.sRt = localNode.getNodeValue();
            }
            localObject2 = ((NamedNodeMap)localObject2).getNamedItem("activityid");
            if (localObject2 != null) {
              localut.sRx = ((Node)localObject2).getNodeValue();
            }
            localut.jnU = str;
            ((ArrayList)localObject1).add(localut);
            i += 1;
          }
          return localObject1;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      }
    }
    return null;
  }
  
  public static ArrayList<String> AT(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
    }
    for (;;)
    {
      return null;
      Object localObject = DocumentBuilderFactory.newInstance();
      try
      {
        paramString = ((DocumentBuilderFactory)localObject).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes())));
        paramString.normalize();
        paramString = paramString.getDocumentElement().getElementsByTagName("ProductID");
        if ((paramString != null) && (paramString.getLength() > 0))
        {
          localObject = new ArrayList();
          int j = paramString.getLength();
          int i = 0;
          while (i < j)
          {
            ((ArrayList)localObject).add(paramString.item(i).getTextContent());
            i += 1;
          }
          return localObject;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.b
 * JD-Core Version:    0.7.0.1
 */