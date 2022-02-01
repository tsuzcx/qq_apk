package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.e;
import com.tencent.mm.modelpackage.f;
import com.tencent.mm.modelpackage.m;
import com.tencent.mm.modelpackage.q;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "defaultAnim", "Lcom/tencent/mm/modelpackage/NewAnim;", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "luckyBagValid", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
{
  private final boolean mhE;
  final e mhF;
  private final q mhG;
  
  public h(boolean paramBoolean)
  {
    AppMethodBeat.i(105504);
    this.mhE = paramBoolean;
    this.mhF = new e();
    this.mhG = new q();
    AppMethodBeat.o(105504);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    AppMethodBeat.i(105503);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    default: 
      skip(paramXmlPullParser);
    }
    label713:
    label718:
    label721:
    for (;;)
    {
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("MiniApp")) {
        break;
      }
      paramString = new j();
      paramString.e(paramXmlPullParser);
      this.mhF.mhJ = paramString.mhJ;
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("Type")) {
        break;
      }
      this.mhF.type = g(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("Game")) {
        break;
      }
      paramString = new g();
      paramString.e(paramXmlPullParser);
      this.mhF.mhD = paramString.mhD;
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("AnimType")) {
        break;
      }
      this.mhG.oQX = f(paramXmlPullParser, "viewcount");
      this.mhG.oQY = f(paramXmlPullParser, "minSize");
      this.mhG.maxSize = f(paramXmlPullParser, "maxSize");
      this.mhG.oQU = g(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("ClientEggVersion")) {
        break;
      }
      if (this.mhE)
      {
        this.mhF.oQu = g(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("KeyWord")) {
          break;
        }
        paramString = new f();
        paramString.lang = e(paramXmlPullParser, "lang");
        paramString.oQy = f(paramXmlPullParser);
        paramXmlPullParser = paramString.oQy;
        s.s(paramXmlPullParser, "eggKeyWord.keyWord");
        if (((CharSequence)paramXmlPullParser).length() <= 0) {
          break label713;
        }
        if (i == 0) {
          continue;
        }
        this.mhF.oQp.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("MagicEmojiEffectId")) {
          break;
        }
        this.mhF.oQx = f(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("FileName")) {
          break;
        }
        this.mhF.oQv.add(this.mhG);
        this.mhG.fileName = f(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("RedEnvelopeCover")) {
          break;
        }
        paramString = new k();
        paramString.e(paramXmlPullParser);
        this.mhF.mhK = paramString.mhK;
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("EffectType")) {
          break;
        }
        this.mhF.oQw = g(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("NewAnimType")) {
          break;
        }
        paramString = new q();
        paramString.oQX = f(paramXmlPullParser, "viewcount");
        paramString.oQY = f(paramXmlPullParser, "minSize");
        paramString.maxSize = f(paramXmlPullParser, "maxSize");
        paramString.fileName = e(paramXmlPullParser, "fileName");
        paramString.oQU = g(paramXmlPullParser);
        this.mhF.oQv.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("LuckyBag")) {
          break;
        }
        paramString = new p();
        paramString.e(paramXmlPullParser);
        if (!Util.isNullOrNil(paramString.mij.appId)) {
          break label718;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1263, 0);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label721;
        }
        this.mhF.mij = paramString.mij;
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
    int j = 86400;
    int i = 0;
    AppMethodBeat.i(105502);
    s.u(paramXmlPullParser, "parser");
    this.mhF.name = e(paramXmlPullParser, "name");
    this.mhF.hYb = f(paramXmlPullParser, "reportType");
    this.mhF.oQt = e(paramXmlPullParser, "langs");
    String str1 = e(paramXmlPullParser, "BeginDate");
    String str2 = e(paramXmlPullParser, "EndDate");
    String str3 = e(paramXmlPullParser, "BeginTimeInterval");
    String str4 = e(paramXmlPullParser, "EndTimeInterval");
    super.e(paramXmlPullParser);
    this.mhF.oQr = Util.getSeconds(str1, 0);
    this.mhF.oQs = Util.getSeconds(str2, 0);
    if ((this.mhF.oQr == 0) && (this.mhF.oQs == 0))
    {
      AppMethodBeat.o(105502);
      return;
    }
    if (this.mhF.oQu >= 3) {
      if (Util.isNullOrNil(str3)) {
        break label261;
      }
    }
    label261:
    for (i = Util.safeParseInt(str3);; i = 0)
    {
      if (!Util.isNullOrNil(str4)) {}
      for (j = Util.safeParseInt(str4);; j = 86400)
      {
        i = Math.max(0, Math.min(i, 86400));
        j = Math.max(0, Math.min(j, 86400));
        paramXmlPullParser = this.mhF;
        paramXmlPullParser.oQr = (i + paramXmlPullParser.oQr);
        paramXmlPullParser = this.mhF;
        paramXmlPullParser.oQs += j;
        AppMethodBeat.o(105502);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.c.h
 * JD-Core Version:    0.7.0.1
 */