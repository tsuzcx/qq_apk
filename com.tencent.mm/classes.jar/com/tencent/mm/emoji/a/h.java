package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.d;
import com.tencent.mm.bc.f;
import com.tencent.mm.bc.m;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "Companion", "plugin-emojisdk_release"})
public final class h
  extends a
{
  public static final h.a gjT;
  private final String TAG;
  public final f gjS;
  
  static
  {
    AppMethodBeat.i(160330);
    gjT = new h.a((byte)0);
    AppMethodBeat.o(160330);
  }
  
  public h()
  {
    AppMethodBeat.i(105507);
    this.TAG = "MicroMsg.EggListParser";
    this.gjS = new f();
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
      paramXmlPullParser = paramString.gjP;
      switch (paramXmlPullParser.iiU)
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
        ad.i(this.TAG, "validEggInfo: " + paramXmlPullParser.name + ", " + paramXmlPullParser.iiU + ", " + paramXmlPullParser.type + ", " + bool1);
        if (!bool1) {
          break label56;
        }
        this.gjS.iiX.add(paramString.gjP);
        AppMethodBeat.o(105506);
        return;
        if (!paramString.equals("ItemNew")) {
          break;
        }
        break label71;
        localIterator = paramXmlPullParser.iiV.iterator();
        while (localIterator.hasNext())
        {
          localm = (m)localIterator.next();
          if (localm.ijo > 3) {
            localm.ijo = 0;
          }
        }
        bool1 = bool2;
        if (paramXmlPullParser.type != 0)
        {
          paramXmlPullParser.type = 0;
          bool1 = bool2;
          continue;
          localIterator = paramXmlPullParser.iiV.iterator();
          while (localIterator.hasNext())
          {
            localm = (m)localIterator.next();
            if (localm.ijo > 4) {
              localm.ijo = 0;
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
      Iterator localIterator = paramXmlPullParser.iiV.iterator();
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if (localm.ijo > 4) {
          localm.ijo = 0;
        }
      }
      bool1 = bool2;
    } while (1 != paramXmlPullParser.type);
    if (paramXmlPullParser.gkH != null) {}
    for (boolean bool1 = true;; bool1 = false) {
      break;
    }
  }
  
  public final void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105505);
    p.h(paramXmlPullParser, "parser");
    this.gjS.bNT = e(paramXmlPullParser, "version");
    super.e(paramXmlPullParser);
    AppMethodBeat.o(105505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */