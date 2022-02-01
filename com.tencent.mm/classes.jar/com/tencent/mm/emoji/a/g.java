package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.d;
import com.tencent.mm.bc.e;
import com.tencent.mm.bc.j;
import com.tencent.mm.bc.m;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "defaultAnim", "Lcom/tencent/mm/modelpackage/NewAnim;", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "luckyBagValid", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"})
public final class g
  extends a
{
  final d gjP;
  private final m gjQ;
  private final boolean gjR;
  
  public g(boolean paramBoolean)
  {
    AppMethodBeat.i(105504);
    this.gjR = paramBoolean;
    this.gjP = new d();
    this.gjQ = new m();
    AppMethodBeat.o(105504);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    AppMethodBeat.i(105503);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    default: 
      skip(paramXmlPullParser);
    }
    label586:
    label591:
    label594:
    for (;;)
    {
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("Type")) {
        break;
      }
      this.gjP.type = d(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("AnimType")) {
        break;
      }
      this.gjQ.ijp = e(paramXmlPullParser, "viewcount");
      this.gjQ.ijq = e(paramXmlPullParser, "minSize");
      this.gjQ.maxSize = e(paramXmlPullParser, "maxSize");
      this.gjQ.ijo = d(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("ClientEggVersion")) {
        break;
      }
      if (this.gjR)
      {
        this.gjP.iiU = d(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("KeyWord")) {
          break;
        }
        paramString = new e();
        paramString.lang = d(paramXmlPullParser, "lang");
        paramString.iiW = c(paramXmlPullParser);
        paramXmlPullParser = paramString.iiW;
        p.g(paramXmlPullParser, "eggKeyWord.keyWord");
        if (((CharSequence)paramXmlPullParser).length() <= 0) {
          break label586;
        }
        if (i == 0) {
          continue;
        }
        this.gjP.iiP.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("FileName")) {
          break;
        }
        this.gjP.iiV.add(this.gjQ);
        this.gjQ.fileName = c(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("NewAnimType")) {
          break;
        }
        paramString = new m();
        paramString.ijp = e(paramXmlPullParser, "viewcount");
        paramString.ijq = e(paramXmlPullParser, "minSize");
        paramString.maxSize = e(paramXmlPullParser, "maxSize");
        paramString.fileName = d(paramXmlPullParser, "fileName");
        paramString.ijo = d(paramXmlPullParser);
        this.gjP.iiV.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("LuckyBag")) {
          break;
        }
        paramString = new n();
        paramString.e(paramXmlPullParser);
        paramXmlPullParser = paramString.gkH;
        if ((!bt.isNullOrNil(paramXmlPullParser.appId)) && (!bt.isNullOrNil(paramXmlPullParser.ijf)) && (!bt.isNullOrNil(paramXmlPullParser.doD)) && (!bt.isNullOrNil(paramXmlPullParser.ijb)) && (!bt.isNullOrNil(paramXmlPullParser.ijd)) && (!bt.isNullOrNil(paramXmlPullParser.iji)) && (!bt.isNullOrNil(paramXmlPullParser.ijj)) && (!bt.isNullOrNil(paramXmlPullParser.ijk)) && (!bt.isNullOrNil(paramXmlPullParser.ijl))) {
          break label591;
        }
        com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 0);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label594;
        }
        this.gjP.gkH = paramString.gkH;
        AppMethodBeat.o(105503);
        return;
        skip(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public final void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105502);
    p.h(paramXmlPullParser, "parser");
    this.gjP.name = d(paramXmlPullParser, "name");
    this.gjP.dFx = e(paramXmlPullParser, "reportType");
    this.gjP.iiT = d(paramXmlPullParser, "langs");
    this.gjP.iiR = bt.aQX(d(paramXmlPullParser, "BeginDate"));
    this.gjP.iiS = bt.aQX(d(paramXmlPullParser, "EndDate"));
    super.e(paramXmlPullParser);
    AppMethodBeat.o(105502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */