package com.tencent.mm.model.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class c
{
  b dYf = null;
  b dYg = null;
  
  public final boolean Iw()
  {
    return this.dYf != null;
  }
  
  public final e iX(String paramString)
  {
    e locale1 = null;
    if (this.dYf != null) {
      locale1 = this.dYf.iX(paramString);
    }
    e locale2 = locale1;
    if (locale1 == null)
    {
      locale2 = locale1;
      if (this.dYg != null) {
        locale2 = this.dYg.iX(paramString);
      }
    }
    return locale2;
  }
  
  final void iY(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
      return;
    }
    y.i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", new Object[] { paramString });
    Object localObject1 = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      int j;
      Object localObject3;
      Object localObject2;
      try
      {
        paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes())));
        paramString.normalize();
        paramString = paramString.getDocumentElement().getElementsByTagName("testcase");
        if (paramString == null) {
          break;
        }
        i = 0;
        if (i >= paramString.getLength()) {
          break;
        }
        localObject1 = new b();
        NodeList localNodeList = paramString.item(i).getChildNodes();
        int k = localNodeList.getLength();
        j = 0;
        if (j >= k) {
          break label632;
        }
        localObject3 = localNodeList.item(j);
        if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("testpoint")))
        {
          Object localObject4 = ((Node)localObject3).getAttributes();
          localObject2 = new e();
          if (localObject4 != null)
          {
            Object localObject5 = ((NamedNodeMap)localObject4).getNamedItem("id");
            if (localObject5 != null)
            {
              localObject5 = ((Node)localObject5).getNodeValue();
              y.d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", new Object[] { localObject5 });
              ((e)localObject2).id = ((String)localObject5);
            }
            localObject4 = ((NamedNodeMap)localObject4).getNamedItem("reportid");
            if (localObject4 != null)
            {
              localObject4 = ((Node)localObject4).getNodeValue();
              y.d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", new Object[] { localObject4 });
              ((e)localObject2).dYh = ((String)localObject4);
            }
          }
          localObject3 = ((Node)localObject3).getTextContent();
          y.d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", new Object[] { localObject3 });
          ((e)localObject2).value = ((String)localObject3);
          localObject3 = ((e)localObject2).id;
          ((b)localObject1).dYe.put(localObject3, localObject2);
        }
        else if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("verifymd5")))
        {
          localObject2 = ((Node)localObject3).getTextContent();
          y.d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", new Object[] { localObject2 });
          ((b)localObject1).dYa = ((String)localObject2);
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", new Object[] { paramString.toString() });
        return;
      }
      if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("testcaseid")))
      {
        localObject2 = ((Node)localObject3).getTextContent();
        y.d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", new Object[] { localObject2 });
        ((b)localObject1).dYb = ((String)localObject2);
      }
      else if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("starttime")))
      {
        localObject2 = ((Node)localObject3).getTextContent();
        y.d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", new Object[] { localObject2 });
        ((b)localObject1).dYc = ((String)localObject2);
      }
      else if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("endtime")))
      {
        localObject2 = ((Node)localObject3).getTextContent();
        y.d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", new Object[] { localObject2 });
        ((b)localObject1).dYd = ((String)localObject2);
        break label674;
        label632:
        if ((!bk.bl(((b)localObject1).dYb)) && ("0".equals(((b)localObject1).dYb)))
        {
          this.dYg = ((b)localObject1);
          break label681;
        }
        this.dYf = ((b)localObject1);
        break label681;
      }
      label674:
      j += 1;
      continue;
      label681:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.a.c
 * JD-Core Version:    0.7.0.1
 */