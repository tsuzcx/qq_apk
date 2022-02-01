package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public static ArrayList<amn> aoK(String paramString)
  {
    AppMethodBeat.i(108731);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
      AppMethodBeat.o(108731);
      return null;
    }
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
          amn localamn = new amn();
          String str = ((Node)localObject2).getTextContent().toLowerCase();
          localObject2 = ((Node)localObject2).getAttributes();
          Node localNode = ((NamedNodeMap)localObject2).getNamedItem("thumburl");
          if (localNode != null) {
            localamn.ThumbUrl = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("cdnurl");
          if (localNode != null) {
            localamn.Url = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("productid");
          if (localNode != null) {
            localamn.ProductID = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("designerid");
          if (localNode != null) {
            localamn.DesignerID = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("aeskey");
          if (localNode != null) {
            localamn.AesKey = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("encrypturl");
          if (localNode != null) {
            localamn.EncryptUrl = localNode.getNodeValue();
          }
          localObject2 = ((NamedNodeMap)localObject2).getNamedItem("activityid");
          if (localObject2 != null) {
            localamn.ActivityID = ((Node)localObject2).getNodeValue();
          }
          localamn.Md5 = str;
          ((ArrayList)localObject1).add(localamn);
          i += 1;
        }
        AppMethodBeat.o(108731);
        return localObject1;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      AppMethodBeat.o(108731);
    }
    return null;
  }
  
  public static ArrayList<String> aoL(String paramString)
  {
    AppMethodBeat.i(108732);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
      AppMethodBeat.o(108732);
      return null;
    }
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
        AppMethodBeat.o(108732);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      AppMethodBeat.o(108732);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */