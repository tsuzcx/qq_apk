package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  public static ArrayList<zg> KU(String paramString)
  {
    AppMethodBeat.i(53158);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
      AppMethodBeat.o(53158);
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
          zg localzg = new zg();
          String str = ((Node)localObject2).getTextContent().toLowerCase();
          localObject2 = ((Node)localObject2).getAttributes();
          Node localNode = ((NamedNodeMap)localObject2).getNamedItem("thumburl");
          if (localNode != null) {
            localzg.ThumbUrl = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("cdnurl");
          if (localNode != null) {
            localzg.Url = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("productid");
          if (localNode != null) {
            localzg.ProductID = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("designerid");
          if (localNode != null) {
            localzg.wQg = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("aeskey");
          if (localNode != null) {
            localzg.AesKey = localNode.getNodeValue();
          }
          localNode = ((NamedNodeMap)localObject2).getNamedItem("encrypturl");
          if (localNode != null) {
            localzg.EncryptUrl = localNode.getNodeValue();
          }
          localObject2 = ((NamedNodeMap)localObject2).getNamedItem("activityid");
          if (localObject2 != null) {
            localzg.ActivityID = ((Node)localObject2).getNodeValue();
          }
          localzg.Md5 = str;
          ((ArrayList)localObject1).add(localzg);
          i += 1;
        }
        AppMethodBeat.o(53158);
        return localObject1;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      AppMethodBeat.o(53158);
    }
    return null;
  }
  
  public static ArrayList<String> KV(String paramString)
  {
    AppMethodBeat.i(53159);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
      AppMethodBeat.o(53159);
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
        AppMethodBeat.o(53159);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      AppMethodBeat.o(53159);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.b
 * JD-Core Version:    0.7.0.1
 */