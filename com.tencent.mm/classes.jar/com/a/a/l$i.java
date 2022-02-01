package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;

final class l$i
  implements Attributes
{
  private XmlPullParser aEX;
  
  public l$i(l paraml, XmlPullParser paramXmlPullParser)
  {
    this.aEX = paramXmlPullParser;
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
    AppMethodBeat.i(203067);
    int i = this.aEX.getAttributeCount();
    AppMethodBeat.o(203067);
    return i;
  }
  
  public final String getLocalName(int paramInt)
  {
    AppMethodBeat.i(203070);
    String str = this.aEX.getAttributeName(paramInt);
    AppMethodBeat.o(203070);
    return str;
  }
  
  public final String getQName(int paramInt)
  {
    AppMethodBeat.i(203073);
    String str2 = this.aEX.getAttributeName(paramInt);
    String str1 = str2;
    if (this.aEX.getAttributePrefix(paramInt) != null) {
      str1 = this.aEX.getAttributePrefix(paramInt) + ':' + str2;
    }
    AppMethodBeat.o(203073);
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
    AppMethodBeat.i(203068);
    String str = this.aEX.getAttributeNamespace(paramInt);
    AppMethodBeat.o(203068);
    return str;
  }
  
  public final String getValue(int paramInt)
  {
    AppMethodBeat.i(203075);
    String str = this.aEX.getAttributeValue(paramInt);
    AppMethodBeat.o(203075);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.a.a.l.i
 * JD-Core Version:    0.7.0.1
 */