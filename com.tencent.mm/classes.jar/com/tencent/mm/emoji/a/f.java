package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.d;
import com.tencent.mm.bc.e;
import com.tencent.mm.bc.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "defaultAnim", "Lcom/tencent/mm/modelpackage/NewAnim;", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "luckyBagValid", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"})
public final class f
  extends a
{
  final d fMD;
  private final com.tencent.mm.bc.m fME;
  private final boolean fMF;
  
  public f(boolean paramBoolean)
  {
    AppMethodBeat.i(105504);
    this.fMF = paramBoolean;
    this.fMD = new d();
    this.fME = new com.tencent.mm.bc.m();
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
      this.fMD.type = p(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("AnimType")) {
        break;
      }
      this.fME.hpz = l(paramXmlPullParser, "viewcount");
      this.fME.hpA = l(paramXmlPullParser, "minSize");
      this.fME.maxSize = l(paramXmlPullParser, "maxSize");
      this.fME.hpy = p(paramXmlPullParser);
      AppMethodBeat.o(105503);
      return;
      if (!paramString.equals("ClientEggVersion")) {
        break;
      }
      if (this.fMF)
      {
        this.fMD.hpe = p(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("KeyWord")) {
          break;
        }
        paramString = new e();
        paramString.lang = k(paramXmlPullParser, "lang");
        paramString.hpg = o(paramXmlPullParser);
        paramXmlPullParser = paramString.hpg;
        k.g(paramXmlPullParser, "eggKeyWord.keyWord");
        if (((CharSequence)paramXmlPullParser).length() <= 0) {
          break label586;
        }
        if (i == 0) {
          continue;
        }
        this.fMD.hoZ.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("FileName")) {
          break;
        }
        this.fMD.hpf.add(this.fME);
        this.fME.fileName = o(paramXmlPullParser);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("NewAnimType")) {
          break;
        }
        paramString = new com.tencent.mm.bc.m();
        paramString.hpz = l(paramXmlPullParser, "viewcount");
        paramString.hpA = l(paramXmlPullParser, "minSize");
        paramString.maxSize = l(paramXmlPullParser, "maxSize");
        paramString.fileName = k(paramXmlPullParser, "fileName");
        paramString.hpy = p(paramXmlPullParser);
        this.fMD.hpf.add(paramString);
        AppMethodBeat.o(105503);
        return;
        if (!paramString.equals("LuckyBag")) {
          break;
        }
        paramString = new m();
        paramString.q(paramXmlPullParser);
        paramXmlPullParser = paramString.fNw;
        if ((!bt.isNullOrNil(paramXmlPullParser.appId)) && (!bt.isNullOrNil(paramXmlPullParser.hpp)) && (!bt.isNullOrNil(paramXmlPullParser.dfM)) && (!bt.isNullOrNil(paramXmlPullParser.hpl)) && (!bt.isNullOrNil(paramXmlPullParser.hpn)) && (!bt.isNullOrNil(paramXmlPullParser.hps)) && (!bt.isNullOrNil(paramXmlPullParser.hpt)) && (!bt.isNullOrNil(paramXmlPullParser.hpu)) && (!bt.isNullOrNil(paramXmlPullParser.hpv))) {
          break label591;
        }
        h.vKh.dB(1263, 0);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label594;
        }
        this.fMD.fNw = paramString.fNw;
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
  
  public final void q(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105502);
    k.h(paramXmlPullParser, "parser");
    this.fMD.name = k(paramXmlPullParser, "name");
    this.fMD.dvJ = l(paramXmlPullParser, "reportType");
    this.fMD.hpd = k(paramXmlPullParser, "langs");
    this.fMD.hpb = bt.aGa(k(paramXmlPullParser, "BeginDate"));
    this.fMD.hpc = bt.aGa(k(paramXmlPullParser, "EndDate"));
    super.q(paramXmlPullParser);
    AppMethodBeat.o(105502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */