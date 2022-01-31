package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class d
{
  public static ArrayList<EmojiGroupInfo> KW(String paramString)
  {
    AppMethodBeat.i(53162);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] parse xml faild. xml is null.");
      AppMethodBeat.o(53162);
      return null;
    }
    Object localObject1 = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      EmojiGroupInfo localEmojiGroupInfo;
      int j;
      Object localObject2;
      try
      {
        paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes())));
        paramString.normalize();
        paramString = paramString.getDocumentElement().getElementsByTagName("Emotion");
        if ((paramString != null) && (paramString.getLength() > 0))
        {
          localObject1 = new ArrayList();
          i = 0;
          if (i >= paramString.getLength()) {
            break label738;
          }
          localEmojiGroupInfo = new EmojiGroupInfo();
          NodeList localNodeList = paramString.item(i).getChildNodes();
          int k = localNodeList.getLength();
          j = 0;
          if (j >= k) {
            break label653;
          }
          localObject2 = localNodeList.item(j);
          if ((localObject2 != null) && (((Node)localObject2).getNodeName() != null) && (((Node)localObject2).getNodeName().equals("ProductID")))
          {
            localObject2 = ((Node)localObject2).getTextContent();
            ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] productId:%s", new Object[] { localObject2 });
            localEmojiGroupInfo.field_productID = ((String)localObject2);
          }
          else if ((localObject2 != null) && (((Node)localObject2).getNodeName() != null) && (((Node)localObject2).getNodeName().equals("RecType")))
          {
            localObject2 = ((Node)localObject2).getTextContent();
            ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] RecType:%s", new Object[] { localObject2 });
            localEmojiGroupInfo.field_recommandType = Integer.valueOf((String)localObject2).intValue();
          }
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.emoji.EmojiRecommendXMLParser", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(53162);
        return null;
      }
      if ((localObject2 != null) && (((Node)localObject2).getNodeName() != null) && (((Node)localObject2).getNodeName().equals("RecWord")))
      {
        localObject2 = ((Node)localObject2).getTextContent();
        ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] recWord:%s", new Object[] { localObject2 });
        localEmojiGroupInfo.field_recommandWord = ((String)localObject2);
      }
      else if ((localObject2 != null) && (((Node)localObject2).getNodeName() != null) && (((Node)localObject2).getNodeName().equals("Name")))
      {
        localObject2 = ((Node)localObject2).getTextContent();
        ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] Name:%s", new Object[] { localObject2 });
        localEmojiGroupInfo.field_packName = ((String)localObject2);
      }
      else if ((localObject2 != null) && (((Node)localObject2).getNodeName() != null) && (((Node)localObject2).getNodeName().equals("Panel")))
      {
        localObject2 = ((Node)localObject2).getTextContent();
        ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] iconUrl:%s", new Object[] { localObject2 });
        localEmojiGroupInfo.field_packGrayIconUrl = ((String)localObject2);
      }
      else if ((localObject2 != null) && (((Node)localObject2).getNodeName() != null) && (((Node)localObject2).getNodeName().equals("Icon")))
      {
        localObject2 = ((Node)localObject2).getTextContent();
        ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] BigIconUrl:%s", new Object[] { localObject2 });
        localEmojiGroupInfo.field_BigIconUrl = ((String)localObject2);
      }
      else if ((localObject2 != null) && (((Node)localObject2).getNodeName() != null) && (((Node)localObject2).getNodeName().equals("ButtonType")))
      {
        localObject2 = ((Node)localObject2).getTextContent();
        ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] buttonType:%s", new Object[] { localObject2 });
        localEmojiGroupInfo.field_buttonType = Integer.valueOf((String)localObject2).intValue();
        break label746;
        label653:
        if (!bo.isNullOrNil(localEmojiGroupInfo.field_productID))
        {
          localEmojiGroupInfo.field_recommand = 1;
          localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
          localEmojiGroupInfo.field_sort = 0;
          h.qsU.e(12068, new Object[] { Integer.valueOf(1), localEmojiGroupInfo.field_productID, Integer.valueOf(localEmojiGroupInfo.field_recommandType) });
          ((ArrayList)localObject1).add(localEmojiGroupInfo);
        }
        i += 1;
        continue;
        label738:
        AppMethodBeat.o(53162);
        return localObject1;
      }
      label746:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.d
 * JD-Core Version:    0.7.0.1
 */