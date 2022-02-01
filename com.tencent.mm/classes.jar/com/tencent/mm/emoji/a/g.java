package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.j;
import com.tencent.mm.bb.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "defaultAnim", "Lcom/tencent/mm/modelpackage/NewAnim;", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "luckyBagValid", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"})
public final class g
  extends a
{
  final d fQp;
  private final m fQq;
  private final boolean fQr;
  
  public g(boolean paramBoolean)
  {
    AppMethodBeat.i(105504);
    this.fQr = paramBoolean;
    this.fQp = new d();
    this.fQq = new m();
    AppMethodBeat.o(105504);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    AppMethodBeat.i(105503);
    k.h(paramString, "tag");
    k.h(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    default: 
      a(paramXmlPullParser);
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
      this.fQp.type = e(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("AnimType")) {
        break;
      }
      this.fQq.hQb = e(paramXmlPullParser, "viewcount");
      this.fQq.hQc = e(paramXmlPullParser, "minSize");
      this.fQq.maxSize = e(paramXmlPullParser, "maxSize");
      this.fQq.hQa = e(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("ClientEggVersion")) {
        break;
      }
      if (this.fQr)
      {
        this.fQp.hPG = e(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("KeyWord")) {
          break;
        }
        paramString = new e();
        paramString.lang = d(paramXmlPullParser, "lang");
        paramString.hPI = d(paramXmlPullParser);
        paramXmlPullParser = paramString.hPI;
        k.g(paramXmlPullParser, "eggKeyWord.keyWord");
        if (((CharSequence)paramXmlPullParser).length() <= 0) {
          break label586;
        }
        if (i == 0) {
          continue;
        }
        this.fQp.hPB.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("FileName")) {
          break;
        }
        this.fQp.hPH.add(this.fQq);
        this.fQq.fileName = d(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("NewAnimType")) {
          break;
        }
        paramString = new m();
        paramString.hQb = e(paramXmlPullParser, "viewcount");
        paramString.hQc = e(paramXmlPullParser, "minSize");
        paramString.maxSize = e(paramXmlPullParser, "maxSize");
        paramString.fileName = d(paramXmlPullParser, "fileName");
        paramString.hQa = e(paramXmlPullParser);
        this.fQp.hPH.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("LuckyBag")) {
          break;
        }
        paramString = new n();
        paramString.f(paramXmlPullParser);
        paramXmlPullParser = paramString.fRh;
        if ((!bs.isNullOrNil(paramXmlPullParser.appId)) && (!bs.isNullOrNil(paramXmlPullParser.hPR)) && (!bs.isNullOrNil(paramXmlPullParser.ddh)) && (!bs.isNullOrNil(paramXmlPullParser.hPN)) && (!bs.isNullOrNil(paramXmlPullParser.hPP)) && (!bs.isNullOrNil(paramXmlPullParser.hPU)) && (!bs.isNullOrNil(paramXmlPullParser.hPV)) && (!bs.isNullOrNil(paramXmlPullParser.hPW)) && (!bs.isNullOrNil(paramXmlPullParser.hPX))) {
          break label591;
        }
        h.wUl.dB(1263, 0);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label594;
        }
        this.fQp.fRh = paramString.fRh;
        AppMethodBeat.o(105503);
        return;
        a(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public final void f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105502);
    k.h(paramXmlPullParser, "parser");
    this.fQp.name = d(paramXmlPullParser, "name");
    this.fQp.dtw = e(paramXmlPullParser, "reportType");
    this.fQp.hPF = d(paramXmlPullParser, "langs");
    this.fQp.hPD = bs.aLr(d(paramXmlPullParser, "BeginDate"));
    this.fQp.hPE = bs.aLr(d(paramXmlPullParser, "EndDate"));
    super.f(paramXmlPullParser);
    AppMethodBeat.o(105502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */