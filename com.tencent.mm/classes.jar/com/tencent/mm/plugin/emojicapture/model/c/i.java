package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/xml/StringList;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "subTag", "", "(Ljava/lang/String;)V", "list", "Ljava/util/LinkedList;", "getList", "()Ljava/util/LinkedList;", "getSubTag", "()Ljava/lang/String;", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
public final class i
  extends a
{
  private final LinkedList<String> elu;
  private final String lvG;
  
  public i(String paramString)
  {
    AppMethodBeat.i(2735);
    this.lvG = paramString;
    this.elu = new LinkedList();
    AppMethodBeat.o(2735);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2734);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    if (j.e(paramString, this.lvG)) {
      this.elu.add(d(paramXmlPullParser));
    }
    AppMethodBeat.o(2734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.i
 * JD-Core Version:    0.7.0.1
 */