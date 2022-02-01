package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;

final class l$i
  implements Attributes
{
  private XmlPullParser aWJ;
  
  public l$i(l paraml, XmlPullParser paramXmlPullParser)
  {
    this.aWJ = paramXmlPullParser;
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
    AppMethodBeat.i(214969);
    int i = this.aWJ.getAttributeCount();
    AppMethodBeat.o(214969);
    return i;
  }
  
  public final String getLocalName(int paramInt)
  {
    AppMethodBeat.i(214971);
    String str = this.aWJ.getAttributeName(paramInt);
    AppMethodBeat.o(214971);
    return str;
  }
  
  public final String getQName(int paramInt)
  {
    AppMethodBeat.i(214972);
    String str2 = this.aWJ.getAttributeName(paramInt);
    String str1 = str2;
    if (this.aWJ.getAttributePrefix(paramInt) != null) {
      str1 = this.aWJ.getAttributePrefix(paramInt) + ':' + str2;
    }
    AppMethodBeat.o(214972);
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
    AppMethodBeat.i(214970);
    String str = this.aWJ.getAttributeNamespace(paramInt);
    AppMethodBeat.o(214970);
    return str;
  }
  
  public final String getValue(int paramInt)
  {
    AppMethodBeat.i(214973);
    String str = this.aWJ.getAttributeValue(paramInt);
    AppMethodBeat.o(214973);
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