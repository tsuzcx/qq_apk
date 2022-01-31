package com.tencent.mm.emoji.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.d;
import com.tencent.mm.ba.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "plugin-emojisdk_release"})
public final class c
  extends a
{
  private final String TAG;
  public final f ewp;
  
  public c()
  {
    AppMethodBeat.i(151774);
    this.TAG = "MicroMsg.EggListParser";
    this.ewp = new f();
    AppMethodBeat.o(151774);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    boolean bool2 = true;
    AppMethodBeat.i(151773);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    label56:
    label71:
    boolean bool1;
    switch (paramString.hashCode())
    {
    default: 
    case 2289459: 
      do
      {
        a(paramXmlPullParser);
        AppMethodBeat.o(151773);
        return;
      } while (!paramString.equals("Item"));
      paramString = new b(j.e(paramString, "ItemNew"));
      paramString.f(paramXmlPullParser);
      paramXmlPullParser = paramString.ewn;
      switch (paramXmlPullParser.fMw)
      {
      default: 
        bool1 = false;
      }
      break;
    }
    for (;;)
    {
      ab.i(this.TAG, "validEggInfo: " + paramXmlPullParser.name + ", " + paramXmlPullParser.fMw + ", " + paramXmlPullParser.fMt + ", " + bool1);
      if (!bool1) {
        break label56;
      }
      this.ewp.fMy.add(paramString.ewn);
      AppMethodBeat.o(151773);
      return;
      if (!paramString.equals("ItemNew")) {
        break;
      }
      break label71;
      bool1 = bool2;
      if (paramXmlPullParser.fMt > 3)
      {
        paramXmlPullParser.fMt = 0;
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (paramXmlPullParser.fMt > 4)
        {
          paramXmlPullParser.fMt = 0;
          bool1 = bool2;
        }
      }
    }
  }
  
  public final void f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(151772);
    j.q(paramXmlPullParser, "parser");
    this.ewp.fMz = e(paramXmlPullParser, "version");
    super.f(paramXmlPullParser);
    AppMethodBeat.o(151772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */