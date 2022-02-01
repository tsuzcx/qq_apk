package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.j;
import com.tencent.mm.bb.m;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "defaultAnim", "Lcom/tencent/mm/modelpackage/NewAnim;", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "luckyBagValid", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"})
public final class g
  extends a
{
  final d gmi;
  private final m gmj;
  private final boolean gmk;
  
  public g(boolean paramBoolean)
  {
    AppMethodBeat.i(105504);
    this.gmk = paramBoolean;
    this.gmi = new d();
    this.gmj = new m();
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
      this.gmi.type = d(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("AnimType")) {
        break;
      }
      this.gmj.imi = e(paramXmlPullParser, "viewcount");
      this.gmj.imj = e(paramXmlPullParser, "minSize");
      this.gmj.maxSize = e(paramXmlPullParser, "maxSize");
      this.gmj.imh = d(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("ClientEggVersion")) {
        break;
      }
      if (this.gmk)
      {
        this.gmi.ilN = d(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("KeyWord")) {
          break;
        }
        paramString = new e();
        paramString.lang = d(paramXmlPullParser, "lang");
        paramString.ilP = c(paramXmlPullParser);
        paramXmlPullParser = paramString.ilP;
        p.g(paramXmlPullParser, "eggKeyWord.keyWord");
        if (((CharSequence)paramXmlPullParser).length() <= 0) {
          break label586;
        }
        if (i == 0) {
          continue;
        }
        this.gmi.ilI.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("FileName")) {
          break;
        }
        this.gmi.ilO.add(this.gmj);
        this.gmj.fileName = c(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("NewAnimType")) {
          break;
        }
        paramString = new m();
        paramString.imi = e(paramXmlPullParser, "viewcount");
        paramString.imj = e(paramXmlPullParser, "minSize");
        paramString.maxSize = e(paramXmlPullParser, "maxSize");
        paramString.fileName = d(paramXmlPullParser, "fileName");
        paramString.imh = d(paramXmlPullParser);
        this.gmi.ilO.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("LuckyBag")) {
          break;
        }
        paramString = new n();
        paramString.e(paramXmlPullParser);
        paramXmlPullParser = paramString.gnb;
        if ((!bu.isNullOrNil(paramXmlPullParser.appId)) && (!bu.isNullOrNil(paramXmlPullParser.ilY)) && (!bu.isNullOrNil(paramXmlPullParser.dpI)) && (!bu.isNullOrNil(paramXmlPullParser.ilU)) && (!bu.isNullOrNil(paramXmlPullParser.ilW)) && (!bu.isNullOrNil(paramXmlPullParser.imb)) && (!bu.isNullOrNil(paramXmlPullParser.imc)) && (!bu.isNullOrNil(paramXmlPullParser.imd)) && (!bu.isNullOrNil(paramXmlPullParser.ime))) {
          break label591;
        }
        com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 0);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label594;
        }
        this.gmi.gnb = paramString.gnb;
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
    this.gmi.name = d(paramXmlPullParser, "name");
    this.gmi.dGC = e(paramXmlPullParser, "reportType");
    this.gmi.ilM = d(paramXmlPullParser, "langs");
    this.gmi.ilK = bu.aSu(d(paramXmlPullParser, "BeginDate"));
    this.gmi.ilL = bu.aSu(d(paramXmlPullParser, "EndDate"));
    super.e(paramXmlPullParser);
    AppMethodBeat.o(105502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */