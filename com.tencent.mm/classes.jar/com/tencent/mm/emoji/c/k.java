package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.i;
import com.tencent.mm.modelpackage.q;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/EggRedEnvelopeParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "redEnvelopeInfo", "Lcom/tencent/mm/modelpackage/EggRedEnvelope;", "getRedEnvelopeInfo", "()Lcom/tencent/mm/modelpackage/EggRedEnvelope;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
{
  final i mhK;
  
  public k()
  {
    AppMethodBeat.i(242632);
    this.mhK = new i();
    AppMethodBeat.o(242632);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(242636);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    if (s.p(paramString, "AppId"))
    {
      this.mhK.appId = f(paramXmlPullParser);
      AppMethodBeat.o(242636);
      return;
    }
    if (s.p(paramString, "EntryAnimType"))
    {
      paramString = new q();
      paramString.oQX = 1;
      int i = f(paramXmlPullParser, "size");
      paramString.oQY = i;
      paramString.maxSize = i;
      paramString.fileName = e(paramXmlPullParser, "fileName");
      paramString.oQU = g(paramXmlPullParser);
      this.mhK.oQo = paramString;
      AppMethodBeat.o(242636);
      return;
    }
    skip(paramXmlPullParser);
    AppMethodBeat.o(242636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.c.k
 * JD-Core Version:    0.7.0.1
 */