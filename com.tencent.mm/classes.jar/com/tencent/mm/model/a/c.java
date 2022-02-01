package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  b ooa = null;
  b oob = null;
  
  public final e Km(String paramString)
  {
    AppMethodBeat.i(153092);
    e locale1 = null;
    if (this.ooa != null) {
      locale1 = this.ooa.Km(paramString);
    }
    e locale2 = locale1;
    if (locale1 == null)
    {
      locale2 = locale1;
      if (this.oob != null) {
        locale2 = this.oob.Km(paramString);
      }
    }
    AppMethodBeat.o(153092);
    return locale2;
  }
  
  final void Kn(String paramString)
  {
    AppMethodBeat.i(153091);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
      AppMethodBeat.o(153091);
      return;
    }
    Log.i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", new Object[] { paramString });
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
          break label689;
        }
        i = 0;
        if (i >= paramString.getLength()) {
          break label689;
        }
        localObject1 = new b();
        NodeList localNodeList = paramString.item(i).getChildNodes();
        int k = localNodeList.getLength();
        j = 0;
        if (j >= k) {
          break label647;
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
              Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", new Object[] { localObject5 });
              ((e)localObject2).id = ((String)localObject5);
            }
            localObject4 = ((NamedNodeMap)localObject4).getNamedItem("reportid");
            if (localObject4 != null)
            {
              localObject4 = ((Node)localObject4).getNodeValue();
              Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", new Object[] { localObject4 });
              ((e)localObject2).ooc = ((String)localObject4);
            }
          }
          localObject3 = ((Node)localObject3).getTextContent();
          Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", new Object[] { localObject3 });
          ((e)localObject2).value = ((String)localObject3);
          localObject3 = ((e)localObject2).id;
          ((b)localObject1).onZ.put(localObject3, localObject2);
        }
        else if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("verifymd5")))
        {
          localObject2 = ((Node)localObject3).getTextContent();
          Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", new Object[] { localObject2 });
          ((b)localObject1).mhv = ((String)localObject2);
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(153091);
        return;
      }
      if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("testcaseid")))
      {
        localObject2 = ((Node)localObject3).getTextContent();
        Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", new Object[] { localObject2 });
        ((b)localObject1).onX = ((String)localObject2);
      }
      else if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("starttime")))
      {
        localObject2 = ((Node)localObject3).getTextContent();
        Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", new Object[] { localObject2 });
        ((b)localObject1).onY = ((String)localObject2);
      }
      else if ((localObject3 != null) && (((Node)localObject3).getNodeName() != null) && (((Node)localObject3).getNodeName().equals("endtime")))
      {
        localObject2 = ((Node)localObject3).getTextContent();
        Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", new Object[] { localObject2 });
        ((b)localObject1).endTime = ((String)localObject2);
        break label695;
        label647:
        if ((!Util.isNullOrNil(((b)localObject1).onX)) && ("0".equals(((b)localObject1).onX)))
        {
          this.oob = ((b)localObject1);
          break label702;
        }
        this.ooa = ((b)localObject1);
        break label702;
        label689:
        AppMethodBeat.o(153091);
        return;
      }
      label695:
      j += 1;
      continue;
      label702:
      i += 1;
    }
  }
  
  public final boolean bDP()
  {
    return this.ooa != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.a.c
 * JD-Core Version:    0.7.0.1
 */