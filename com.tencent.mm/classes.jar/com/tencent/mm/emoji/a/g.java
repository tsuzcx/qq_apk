package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.d;
import com.tencent.mm.bc.m;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "Companion", "plugin-emojisdk_release"})
public final class g
  extends a
{
  public static final a fMH;
  private final String TAG;
  public final com.tencent.mm.bc.f fMG;
  
  static
  {
    AppMethodBeat.i(160330);
    fMH = new a((byte)0);
    AppMethodBeat.o(160330);
  }
  
  public g()
  {
    AppMethodBeat.i(105507);
    this.TAG = "MicroMsg.EggListParser";
    this.fMG = new com.tencent.mm.bc.f();
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
      paramString = new f(k.g(paramString, "ItemNew"));
      paramString.q(paramXmlPullParser);
      paramXmlPullParser = paramString.fMD;
      switch (paramXmlPullParser.hpe)
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
        ad.i(this.TAG, "validEggInfo: " + paramXmlPullParser.name + ", " + paramXmlPullParser.hpe + ", " + paramXmlPullParser.type + ", " + bool1);
        if (!bool1) {
          break label56;
        }
        this.fMG.hph.add(paramString.fMD);
        AppMethodBeat.o(105506);
        return;
        if (!paramString.equals("ItemNew")) {
          break;
        }
        break label71;
        localIterator = paramXmlPullParser.hpf.iterator();
        while (localIterator.hasNext())
        {
          localm = (m)localIterator.next();
          if (localm.hpy > 3) {
            localm.hpy = 0;
          }
        }
        bool1 = bool2;
        if (paramXmlPullParser.type != 0)
        {
          paramXmlPullParser.type = 0;
          bool1 = bool2;
          continue;
          localIterator = paramXmlPullParser.hpf.iterator();
          while (localIterator.hasNext())
          {
            localm = (m)localIterator.next();
            if (localm.hpy > 4) {
              localm.hpy = 0;
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
      Iterator localIterator = paramXmlPullParser.hpf.iterator();
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if (localm.hpy > 4) {
          localm.hpy = 0;
        }
      }
      bool1 = bool2;
    } while (1 != paramXmlPullParser.type);
    if (paramXmlPullParser.fNw != null) {}
    for (boolean bool1 = true;; bool1 = false) {
      break;
    }
  }
  
  public final void q(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105505);
    k.h(paramXmlPullParser, "parser");
    this.fMG.bFX = l(paramXmlPullParser, "version");
    super.q(paramXmlPullParser);
    AppMethodBeat.o(105505);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/EggListParser$Companion;", "", "()V", "TYPE_AD_EGG", "", "TYPE_NORMAL_EGG", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */