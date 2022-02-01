package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.e;
import com.tencent.mm.be.f;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "defaultAnim", "Lcom/tencent/mm/modelpackage/NewAnim;", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "luckyBagValid", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"})
public final class h
  extends a
{
  final e jHX;
  private final com.tencent.mm.be.p jHY;
  private final boolean jHZ;
  
  public h(boolean paramBoolean)
  {
    AppMethodBeat.i(105504);
    this.jHZ = paramBoolean;
    this.jHX = new e();
    this.jHY = new com.tencent.mm.be.p();
    AppMethodBeat.o(105504);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    AppMethodBeat.i(105503);
    kotlin.g.b.p.k(paramString, "tag");
    kotlin.g.b.p.k(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    default: 
      skip(paramXmlPullParser);
    }
    label598:
    label603:
    label606:
    for (;;)
    {
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("Type")) {
        break;
      }
      this.jHX.type = e(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("Game")) {
        break;
      }
      paramString = new g();
      paramString.c(paramXmlPullParser);
      this.jHX.jHW = paramString.jHW;
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("AnimType")) {
        break;
      }
      this.jHY.lXT = e(paramXmlPullParser, "viewcount");
      this.jHY.lXU = e(paramXmlPullParser, "minSize");
      this.jHY.maxSize = e(paramXmlPullParser, "maxSize");
      this.jHY.lXQ = e(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("ClientEggVersion")) {
        break;
      }
      if (this.jHZ)
      {
        this.jHX.lXs = e(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("KeyWord")) {
          break;
        }
        paramString = new f();
        paramString.lang = d(paramXmlPullParser, "lang");
        paramString.lXu = d(paramXmlPullParser);
        paramXmlPullParser = paramString.lXu;
        kotlin.g.b.p.j(paramXmlPullParser, "eggKeyWord.keyWord");
        if (((CharSequence)paramXmlPullParser).length() <= 0) {
          break label598;
        }
        if (i == 0) {
          continue;
        }
        this.jHX.lXn.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("FileName")) {
          break;
        }
        this.jHX.lXt.add(this.jHY);
        this.jHY.fileName = d(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("RedEnvelopeCover")) {
          break;
        }
        paramString = new j();
        paramString.c(paramXmlPullParser);
        this.jHX.jIc = paramString.jIc;
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("NewAnimType")) {
          break;
        }
        paramString = new com.tencent.mm.be.p();
        paramString.lXT = e(paramXmlPullParser, "viewcount");
        paramString.lXU = e(paramXmlPullParser, "minSize");
        paramString.maxSize = e(paramXmlPullParser, "maxSize");
        paramString.fileName = d(paramXmlPullParser, "fileName");
        paramString.lXQ = e(paramXmlPullParser);
        this.jHX.lXt.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("LuckyBag")) {
          break;
        }
        paramString = new p();
        paramString.c(paramXmlPullParser);
        if (!Util.isNullOrNil(paramString.jIS.appId)) {
          break label603;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(1263, 0);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label606;
        }
        this.jHX.jIS = paramString.jIS;
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
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    int j = 86400;
    int i = 0;
    AppMethodBeat.i(105502);
    kotlin.g.b.p.k(paramXmlPullParser, "parser");
    this.jHX.name = d(paramXmlPullParser, "name");
    this.jHX.fSe = e(paramXmlPullParser, "reportType");
    this.jHX.lXr = d(paramXmlPullParser, "langs");
    String str1 = d(paramXmlPullParser, "BeginDate");
    String str2 = d(paramXmlPullParser, "EndDate");
    String str3 = d(paramXmlPullParser, "BeginTimeInterval");
    String str4 = d(paramXmlPullParser, "EndTimeInterval");
    super.c(paramXmlPullParser);
    this.jHX.lXp = Util.getSeconds(str1, 0);
    this.jHX.lXq = Util.getSeconds(str2, 0);
    if ((this.jHX.lXp == 0) && (this.jHX.lXq == 0))
    {
      AppMethodBeat.o(105502);
      return;
    }
    if (this.jHX.lXs >= 3) {
      if (Util.isNullOrNil(str3)) {
        break label248;
      }
    }
    label248:
    for (i = Util.safeParseInt(str3);; i = 0)
    {
      if (!Util.isNullOrNil(str4)) {}
      for (j = Util.safeParseInt(str4);; j = 86400)
      {
        i = Math.max(0, Math.min(i, 86400));
        j = Math.max(0, Math.min(j, 86400));
        paramXmlPullParser = this.jHX;
        paramXmlPullParser.lXp = (i + paramXmlPullParser.lXp);
        paramXmlPullParser = this.jHX;
        paramXmlPullParser.lXq += j;
        AppMethodBeat.o(105502);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.h
 * JD-Core Version:    0.7.0.1
 */