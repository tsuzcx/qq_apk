package com.tencent.mm.emoji.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.d;
import com.tencent.mm.ba.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"})
public final class b
  extends a
{
  final d ewn;
  private final boolean ewo;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(151771);
    this.ewo = paramBoolean;
    this.ewn = new d();
    AppMethodBeat.o(151771);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(151770);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    default: 
    case -730941173: 
    case 947396446: 
    case 849291753: 
      label68:
      do
      {
        do
        {
          do
          {
            a(paramXmlPullParser);
            AppMethodBeat.o(151770);
            return;
          } while (!paramString.equals("AnimType"));
          this.ewn.fMu = e(paramXmlPullParser, "viewcount");
          this.ewn.fMv = e(paramXmlPullParser, "minSize");
          this.ewn.maxSize = e(paramXmlPullParser, "maxSize");
          this.ewn.fMt = e(paramXmlPullParser);
          AppMethodBeat.o(151770);
          return;
        } while (!paramString.equals("ClientEggVersion"));
        if (!this.ewo) {
          break;
        }
        this.ewn.fMw = e(paramXmlPullParser);
        AppMethodBeat.o(151770);
        return;
      } while (!paramString.equals("KeyWord"));
      paramString = new e();
      paramString.lang = d(paramXmlPullParser, "lang");
      paramString.fMx = d(paramXmlPullParser);
      paramXmlPullParser = paramString.fMx;
      j.p(paramXmlPullParser, "eggKeyWord.keyWord");
      if (((CharSequence)paramXmlPullParser).length() <= 0) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label68;
      }
      this.ewn.fMn.add(paramString);
      AppMethodBeat.o(151770);
      return;
      if (!paramString.equals("FileName")) {
        break;
      }
      this.ewn.fMs = d(paramXmlPullParser);
      AppMethodBeat.o(151770);
      return;
      a(paramXmlPullParser);
      AppMethodBeat.o(151770);
      return;
    }
  }
  
  public final void f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(151769);
    j.q(paramXmlPullParser, "parser");
    this.ewn.name = d(paramXmlPullParser, "name");
    this.ewn.cFd = e(paramXmlPullParser, "reportType");
    this.ewn.fMr = d(paramXmlPullParser, "langs");
    this.ewn.fMp = bo.apM(d(paramXmlPullParser, "BeginDate"));
    this.ewn.fMq = bo.apM(d(paramXmlPullParser, "EndDate"));
    super.f(paramXmlPullParser);
    AppMethodBeat.o(151769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */