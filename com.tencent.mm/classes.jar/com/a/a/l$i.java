package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;

final class l$i
  implements Attributes
{
  private XmlPullParser cAJ;
  
  public l$i(l paraml, XmlPullParser paramXmlPullParser)
  {
    this.cAJ = paramXmlPullParser;
  }
  
  public final int getIndex(String paramString)
  {
    return -1;
  }
  
  public final int getIndex(String paramString1, String paramString2)
  {
    return -1;
  }
  
  public final int getLength()
  {
    AppMethodBeat.i(207720);
    int i = this.cAJ.getAttributeCount();
    AppMethodBeat.o(207720);
    return i;
  }
  
  public final String getLocalName(int paramInt)
  {
    AppMethodBeat.i(207738);
    String str = this.cAJ.getAttributeName(paramInt);
    AppMethodBeat.o(207738);
    return str;
  }
  
  public final String getQName(int paramInt)
  {
    AppMethodBeat.i(207744);
    String str2 = this.cAJ.getAttributeName(paramInt);
    String str1 = str2;
    if (this.cAJ.getAttributePrefix(paramInt) != null) {
      str1 = this.cAJ.getAttributePrefix(paramInt) + ':' + str2;
    }
    AppMethodBeat.o(207744);
    return str1;
  }
  
  public final String getType(int paramInt)
  {
    return null;
  }
  
  public final String getType(String paramString)
  {
    return null;
  }
  
  public final String getType(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final String getURI(int paramInt)
  {
    AppMethodBeat.i(207731);
    String str = this.cAJ.getAttributeNamespace(paramInt);
    AppMethodBeat.o(207731);
    return str;
  }
  
  public final String getValue(int paramInt)
  {
    AppMethodBeat.i(207750);
    String str = this.cAJ.getAttributeValue(paramInt);
    AppMethodBeat.o(207750);
    return str;
  }
  
  public final String getValue(String paramString)
  {
    return null;
  }
  
  public final String getValue(String paramString1, String paramString2)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.l.i
 * JD-Core Version:    0.7.0.1
 */