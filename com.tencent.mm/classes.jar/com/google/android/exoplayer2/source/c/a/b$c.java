package com.google.android.exoplayer2.source.c.a;

import android.util.Base64;
import com.google.android.exoplayer2.c.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

final class b$c
  extends b.a
{
  private boolean bry;
  private byte[] brz;
  private UUID uuid;
  
  public b$c(b.a parama, String paramString)
  {
    super(parama, paramString, "Protection");
  }
  
  public final boolean au(String paramString)
  {
    AppMethodBeat.i(89986);
    boolean bool = "ProtectionHeader".equals(paramString);
    AppMethodBeat.o(89986);
    return bool;
  }
  
  public final Object build()
  {
    AppMethodBeat.i(89990);
    a.a locala = new a.a(this.uuid, h.a(this.uuid, this.brz));
    AppMethodBeat.o(89990);
    return locala;
  }
  
  public final void i(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(89987);
    if ("ProtectionHeader".equals(paramXmlPullParser.getName()))
    {
      this.bry = true;
      String str = paramXmlPullParser.getAttributeValue(null, "SystemID");
      paramXmlPullParser = str;
      if (str.charAt(0) == '{')
      {
        paramXmlPullParser = str;
        if (str.charAt(str.length() - 1) == '}') {
          paramXmlPullParser = str.substring(1, str.length() - 1);
        }
      }
      this.uuid = UUID.fromString(paramXmlPullParser);
    }
    AppMethodBeat.o(89987);
  }
  
  public final void j(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(89988);
    if (this.bry) {
      this.brz = Base64.decode(paramXmlPullParser.getText(), 0);
    }
    AppMethodBeat.o(89988);
  }
  
  public final void k(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(89989);
    if ("ProtectionHeader".equals(paramXmlPullParser.getName())) {
      this.bry = false;
    }
    AppMethodBeat.o(89989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.b.c
 * JD-Core Version:    0.7.0.1
 */