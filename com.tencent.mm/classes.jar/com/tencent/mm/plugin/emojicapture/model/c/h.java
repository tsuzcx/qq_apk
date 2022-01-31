package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceFileConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "ResouceFileVersion", "", "getResouceFileVersion", "()I", "setResouceFileVersion", "(I)V", "fileList", "Ljava/util/LinkedList;", "", "getFileList", "()Ljava/util/LinkedList;", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
public final class h
  extends a
{
  public int lvE;
  private final LinkedList<String> lvF;
  
  public h()
  {
    AppMethodBeat.i(2733);
    this.lvF = new LinkedList();
    AppMethodBeat.o(2733);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2732);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      a(paramXmlPullParser);
      AppMethodBeat.o(2732);
      return;
    } while (!paramString.equals("ResouceFileVersion"));
    this.lvE = e(paramXmlPullParser);
    AppMethodBeat.o(2732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.h
 * JD-Core Version:    0.7.0.1
 */