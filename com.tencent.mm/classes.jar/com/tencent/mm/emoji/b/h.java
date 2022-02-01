package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.f;
import com.tencent.mm.bb.k;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "defaultAnim", "Lcom/tencent/mm/modelpackage/NewAnim;", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "luckyBagValid", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"})
public final class h
  extends a
{
  final e gWZ;
  private final com.tencent.mm.bb.o gXa;
  private final boolean gXb;
  
  public h(boolean paramBoolean)
  {
    AppMethodBeat.i(105504);
    this.gXb = paramBoolean;
    this.gWZ = new e();
    this.gXa = new com.tencent.mm.bb.o();
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
    label551:
    label556:
    label559:
    for (;;)
    {
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("Type")) {
        break;
      }
      this.gWZ.type = e(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("Game")) {
        break;
      }
      paramString = new g();
      paramString.c(paramXmlPullParser);
      this.gWZ.gWY = paramString.gWY;
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("AnimType")) {
        break;
      }
      this.gXa.jhq = e(paramXmlPullParser, "viewcount");
      this.gXa.jhr = e(paramXmlPullParser, "minSize");
      this.gXa.maxSize = e(paramXmlPullParser, "maxSize");
      this.gXa.jhn = e(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("ClientEggVersion")) {
        break;
      }
      if (this.gXb)
      {
        this.gWZ.jgP = e(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("KeyWord")) {
          break;
        }
        paramString = new f();
        paramString.lang = d(paramXmlPullParser, "lang");
        paramString.jgR = d(paramXmlPullParser);
        paramXmlPullParser = paramString.jgR;
        p.g(paramXmlPullParser, "eggKeyWord.keyWord");
        if (((CharSequence)paramXmlPullParser).length() <= 0) {
          break label551;
        }
        if (i == 0) {
          continue;
        }
        this.gWZ.jgK.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("FileName")) {
          break;
        }
        this.gWZ.jgQ.add(this.gXa);
        this.gXa.fileName = d(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("NewAnimType")) {
          break;
        }
        paramString = new com.tencent.mm.bb.o();
        paramString.jhq = e(paramXmlPullParser, "viewcount");
        paramString.jhr = e(paramXmlPullParser, "minSize");
        paramString.maxSize = e(paramXmlPullParser, "maxSize");
        paramString.fileName = d(paramXmlPullParser, "fileName");
        paramString.jhn = e(paramXmlPullParser);
        this.gWZ.jgQ.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("LuckyBag")) {
          break;
        }
        paramString = new o();
        paramString.c(paramXmlPullParser);
        if (!Util.isNullOrNil(paramString.gXT.appId)) {
          break label556;
        }
        com.tencent.mm.plugin.report.service.h.CyF.dN(1263, 0);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label559;
        }
        this.gWZ.gXT = paramString.gXT;
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
    p.h(paramXmlPullParser, "parser");
    this.gWZ.name = d(paramXmlPullParser, "name");
    this.gWZ.dYn = e(paramXmlPullParser, "reportType");
    this.gWZ.jgO = d(paramXmlPullParser, "langs");
    String str1 = d(paramXmlPullParser, "BeginDate");
    String str2 = d(paramXmlPullParser, "EndDate");
    String str3 = d(paramXmlPullParser, "BeginTimeInterval");
    String str4 = d(paramXmlPullParser, "EndTimeInterval");
    super.c(paramXmlPullParser);
    this.gWZ.jgM = Util.getSeconds(str1, 0);
    this.gWZ.jgN = Util.getSeconds(str2, 0);
    if ((this.gWZ.jgM == 0) && (this.gWZ.jgN == 0))
    {
      AppMethodBeat.o(105502);
      return;
    }
    if (this.gWZ.jgP >= 3) {
      if (Util.isNullOrNil(str3)) {
        break label247;
      }
    }
    label247:
    for (i = Util.safeParseInt(str3);; i = 0)
    {
      if (!Util.isNullOrNil(str4)) {}
      for (j = Util.safeParseInt(str4);; j = 86400)
      {
        i = Math.max(0, Math.min(i, 86400));
        j = Math.max(0, Math.min(j, 86400));
        paramXmlPullParser = this.gWZ;
        paramXmlPullParser.jgM = (i + paramXmlPullParser.jgM);
        paramXmlPullParser = this.gWZ;
        paramXmlPullParser.jgN += j;
        AppMethodBeat.o(105502);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.b.h
 * JD-Core Version:    0.7.0.1
 */