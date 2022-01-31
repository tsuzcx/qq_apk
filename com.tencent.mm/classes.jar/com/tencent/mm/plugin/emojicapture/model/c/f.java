package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceCompressConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "copyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceCompressItem;", "getCopyList", "()Ljava/util/LinkedList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojicapture_release"})
public final class f
  extends a
{
  public final LinkedList<g> lvB;
  
  public f()
  {
    AppMethodBeat.i(2730);
    this.lvB = new LinkedList();
    AppMethodBeat.o(2730);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2729);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      a(paramXmlPullParser);
      AppMethodBeat.o(2729);
      return;
    } while (!paramString.equals("EmoticonLensResouceCompreItem"));
    paramString = new g();
    paramString.f(paramXmlPullParser);
    this.lvB.add(paramString);
    AppMethodBeat.o(2729);
  }
  
  public final void f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2728);
    j.q(paramXmlPullParser, "parser");
    paramXmlPullParser.nextTag();
    super.f(paramXmlPullParser);
    AppMethodBeat.o(2728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.f
 * JD-Core Version:    0.7.0.1
 */