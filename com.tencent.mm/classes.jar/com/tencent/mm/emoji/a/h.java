package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.f;
import com.tencent.mm.bb.m;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "Companion", "plugin-emojisdk_release"})
public final class h
  extends a
{
  public static final h.a gmm;
  private final String TAG;
  public final f gml;
  
  static
  {
    AppMethodBeat.i(160330);
    gmm = new h.a((byte)0);
    AppMethodBeat.o(160330);
  }
  
  public h()
  {
    AppMethodBeat.i(105507);
    this.TAG = "MicroMsg.EggListParser";
    this.gml = new f();
    AppMethodBeat.o(105507);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    boolean bool2 = true;
    AppMethodBeat.i(105506);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    default: 
    case 2289459: 
      label56:
      do
      {
        skip(paramXmlPullParser);
        AppMethodBeat.o(105506);
        return;
      } while (!paramString.equals("Item"));
      label71:
      paramString = new g(p.i(paramString, "ItemNew"));
      paramString.e(paramXmlPullParser);
      paramXmlPullParser = paramString.gmi;
      switch (paramXmlPullParser.ilN)
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
        ae.i(this.TAG, "validEggInfo: " + paramXmlPullParser.name + ", " + paramXmlPullParser.ilN + ", " + paramXmlPullParser.type + ", " + bool1);
        if (!bool1) {
          break label56;
        }
        this.gml.ilQ.add(paramString.gmi);
        AppMethodBeat.o(105506);
        return;
        if (!paramString.equals("ItemNew")) {
          break;
        }
        break label71;
        localIterator = paramXmlPullParser.ilO.iterator();
        while (localIterator.hasNext())
        {
          localm = (m)localIterator.next();
          if (localm.imh > 3) {
            localm.imh = 0;
          }
        }
        bool1 = bool2;
        if (paramXmlPullParser.type != 0)
        {
          paramXmlPullParser.type = 0;
          bool1 = bool2;
          continue;
          localIterator = paramXmlPullParser.ilO.iterator();
          while (localIterator.hasNext())
          {
            localm = (m)localIterator.next();
            if (localm.imh > 4) {
              localm.imh = 0;
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
      Iterator localIterator = paramXmlPullParser.ilO.iterator();
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if (localm.imh > 4) {
          localm.imh = 0;
        }
      }
      bool1 = bool2;
    } while (1 != paramXmlPullParser.type);
    if (paramXmlPullParser.gnb != null) {}
    for (boolean bool1 = true;; bool1 = false) {
      break;
    }
  }
  
  public final void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105505);
    p.h(paramXmlPullParser, "parser");
    this.gml.bNT = e(paramXmlPullParser, "version");
    super.e(paramXmlPullParser);
    AppMethodBeat.o(105505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */