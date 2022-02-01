package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.f;
import com.tencent.mm.bb.m;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "Companion", "plugin-emojisdk_release"})
public final class h
  extends a
{
  public static final h.a fQt;
  private final String TAG;
  public final f fQs;
  
  static
  {
    AppMethodBeat.i(160330);
    fQt = new h.a((byte)0);
    AppMethodBeat.o(160330);
  }
  
  public h()
  {
    AppMethodBeat.i(105507);
    this.TAG = "MicroMsg.EggListParser";
    this.fQs = new f();
    AppMethodBeat.o(105507);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    boolean bool2 = true;
    AppMethodBeat.i(105506);
    k.h(paramString, "tag");
    k.h(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    default: 
    case 2289459: 
      label56:
      do
      {
        a(paramXmlPullParser);
        AppMethodBeat.o(105506);
        return;
      } while (!paramString.equals("Item"));
      label71:
      paramString = new g(k.g(paramString, "ItemNew"));
      paramString.f(paramXmlPullParser);
      paramXmlPullParser = paramString.fQp;
      switch (paramXmlPullParser.hPG)
      {
      default: 
        bool1 = false;
      }
      break;
    }
    do
    {
      m localm;
      for (;;)
      {
        ac.i(this.TAG, "validEggInfo: " + paramXmlPullParser.name + ", " + paramXmlPullParser.hPG + ", " + paramXmlPullParser.type + ", " + bool1);
        if (!bool1) {
          break label56;
        }
        this.fQs.hPJ.add(paramString.fQp);
        AppMethodBeat.o(105506);
        return;
        if (!paramString.equals("ItemNew")) {
          break;
        }
        break label71;
        localIterator = paramXmlPullParser.hPH.iterator();
        while (localIterator.hasNext())
        {
          localm = (m)localIterator.next();
          if (localm.hQa > 3) {
            localm.hQa = 0;
          }
        }
        bool1 = bool2;
        if (paramXmlPullParser.type != 0)
        {
          paramXmlPullParser.type = 0;
          bool1 = bool2;
          continue;
          localIterator = paramXmlPullParser.hPH.iterator();
          while (localIterator.hasNext())
          {
            localm = (m)localIterator.next();
            if (localm.hQa > 4) {
              localm.hQa = 0;
            }
          }
          bool1 = bool2;
          if (paramXmlPullParser.type != 0)
          {
            paramXmlPullParser.type = 0;
            bool1 = bool2;
          }
        }
      }
      Iterator localIterator = paramXmlPullParser.hPH.iterator();
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if (localm.hQa > 4) {
          localm.hQa = 0;
        }
      }
      bool1 = bool2;
    } while (1 != paramXmlPullParser.type);
    if (paramXmlPullParser.fRh != null) {}
    for (boolean bool1 = true;; bool1 = false) {
      break;
    }
  }
  
  public final void f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105505);
    k.h(paramXmlPullParser, "parser");
    this.fQs.bDF = e(paramXmlPullParser, "version");
    super.f(paramXmlPullParser);
    AppMethodBeat.o(105505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */