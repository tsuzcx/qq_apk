package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;

final class l$i
  implements Attributes
{
  private XmlPullParser aWB;
  
  public l$i(l paraml, XmlPullParser paramXmlPullParser)
  {
    this.aWB = paramXmlPullParser;
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
    AppMethodBeat.i(206696);
    int i = this.aWB.getAttributeCount();
    AppMethodBeat.o(206696);
    return i;
  }
  
  public final String getLocalName(int paramInt)
  {
    AppMethodBeat.i(206698);
    String str = this.aWB.getAttributeName(paramInt);
    AppMethodBeat.o(206698);
    return str;
  }
  
  public final String getQName(int paramInt)
  {
    AppMethodBeat.i(206699);
    String str2 = this.aWB.getAttributeName(paramInt);
    String str1 = str2;
    if (this.aWB.getAttributePrefix(paramInt) != null) {
      str1 = this.aWB.getAttributePrefix(paramInt) + ':' + str2;
    }
    AppMethodBeat.o(206699);
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
    AppMethodBeat.i(206697);
    String str = this.aWB.getAttributeNamespace(paramInt);
    AppMethodBeat.o(206697);
    return str;
  }
  
  public final String getValue(int paramInt)
  {
    AppMethodBeat.i(206700);
    String str = this.aWB.getAttributeValue(paramInt);
    AppMethodBeat.o(206700);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.l.i
 * JD-Core Version:    0.7.0.1
 */