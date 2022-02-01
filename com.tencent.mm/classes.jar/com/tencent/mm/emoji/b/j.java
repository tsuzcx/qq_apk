package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.h;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/EggRedEnvelopeParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "redEnvelopeInfo", "Lcom/tencent/mm/modelpackage/EggRedEnvelope;", "getRedEnvelopeInfo", "()Lcom/tencent/mm/modelpackage/EggRedEnvelope;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class j
  extends a
{
  final h jIc;
  
  public j()
  {
    AppMethodBeat.i(230448);
    this.jIc = new h();
    AppMethodBeat.o(230448);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(230446);
    kotlin.g.b.p.k(paramString, "tag");
    kotlin.g.b.p.k(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        skip(paramXmlPullParser);
        AppMethodBeat.o(230446);
        return;
      } while (!paramString.equals("AppId"));
      this.jIc.appId = d(paramXmlPullParser);
      AppMethodBeat.o(230446);
      return;
    } while (!paramString.equals("EntryAnimType"));
    paramString = new com.tencent.mm.be.p();
    paramString.lXT = 1;
    int i = e(paramXmlPullParser, "size");
    paramString.lXU = i;
    paramString.maxSize = i;
    paramString.fileName = d(paramXmlPullParser, "fileName");
    paramString.lXQ = e(paramXmlPullParser);
    this.jIc.lXm = paramString;
    AppMethodBeat.o(230446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.j
 * JD-Core Version:    0.7.0.1
 */