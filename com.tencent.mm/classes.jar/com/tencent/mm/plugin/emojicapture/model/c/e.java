package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangStringWithScene;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "sceneList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangString;", "getSceneList", "()Ljava/util/LinkedList;", "get", "", "scene", "", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
public final class e
  extends a
{
  private final LinkedList<d> fEZ;
  
  public e()
  {
    AppMethodBeat.i(2727);
    this.fEZ = new LinkedList();
    AppMethodBeat.o(2727);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2726);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2726);
      return;
      if (paramString.equals("EmoticonLensTranslationInScenes"))
      {
        paramString = new d();
        paramString.f(paramXmlPullParser);
        this.fEZ.add(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.e
 * JD-Core Version:    0.7.0.1
 */