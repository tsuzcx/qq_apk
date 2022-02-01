package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static ArrayList<act> Ub(String paramString)
  {
    AppMethodBeat.i(108731);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
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
          act localact = new act();
          String str = ((Node)localObject2).getTextContent().toLowerCase();
          localObject2 = ((Node)localObject2).getAttributes();
          Node localNode = ((NamedNodeMap)localObject2).getNamedItem("thumburl");
          if (localNode != null) {
            localact.ThumbUrl = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("cdnurl");
          if (localNode != null) {
            localact.Url = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("productid");
          if (localNode != null) {
            localact.ProductID = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("designerid");
          if (localNode != null) {
            localact.Ddp = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("aeskey");
          if (localNode != null) {
            localact.AesKey = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("encrypturl");
          if (localNode != null) {
            localact.EncryptUrl = localNode.getNodeValue();
          }
          localObject2 = ((NamedNodeMap)localObject2).getNamedItem("activityid");
          if (localObject2 != null) {
            localact.ActivityID = ((Node)localObject2).getNodeValue();
          }
          localact.Md5 = str;
          ((ArrayList)localObject1).add(localact);
          i += 1;
        }
        AppMethodBeat.o(108731);
        return localObject1;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      AppMethodBeat.o(108731);
    }
    return null;
  }
  
  public static ArrayList<String> Uc(String paramString)
  {
    AppMethodBeat.i(108732);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
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
      ad.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      AppMethodBeat.o(108732);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.b
 * JD-Core Version:    0.7.0.1
 */