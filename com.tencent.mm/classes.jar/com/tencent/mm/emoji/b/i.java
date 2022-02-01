package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.e;
import com.tencent.mm.be.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "Companion", "plugin-emojisdk_release"})
public final class i
  extends a
{
  public static final i.a jIb;
  private final String TAG;
  public final g jIa;
  
  static
  {
    AppMethodBeat.i(160330);
    jIb = new i.a((byte)0);
    AppMethodBeat.o(160330);
  }
  
  public i()
  {
    AppMethodBeat.i(105507);
    this.TAG = "MicroMsg.EggListParser";
    this.jIa = new g();
    AppMethodBeat.o(105507);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    int k = 4;
    boolean bool2 = true;
    AppMethodBeat.i(105506);
    kotlin.g.b.p.k(paramString, "tag");
    kotlin.g.b.p.k(paramXmlPullParser, "parser");
    label56:
    label71:
    h localh;
    boolean bool1;
    int i;
    switch (paramString.hashCode())
    {
    default: 
    case 2289459: 
      do
      {
        skip(paramXmlPullParser);
        AppMethodBeat.o(105506);
        return;
      } while (!paramString.equals("Item"));
      localh = new h(kotlin.g.b.p.h(paramString, "ItemNew"));
      localh.c(paramXmlPullParser);
      paramXmlPullParser = localh.jHX;
      switch (paramXmlPullParser.lXs)
      {
      default: 
        bool1 = false;
        i = k;
      }
      break;
    }
    for (;;)
    {
      label150:
      paramString = paramXmlPullParser.lXt.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          com.tencent.mm.be.p localp = (com.tencent.mm.be.p)paramString.next();
          if (localp.lXQ > i)
          {
            localp.lXQ = 0;
            continue;
            if (!paramString.equals("ItemNew")) {
              break;
            }
            break label71;
            if (paramXmlPullParser.type == 0) {
              break label566;
            }
            paramXmlPullParser.type = 0;
            i = 3;
            bool1 = bool2;
            break label150;
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.type == 0) {
              break label150;
            }
            paramXmlPullParser.type = 0;
            bool1 = bool2;
            i = k;
            break label150;
            bool1 = bool2;
            i = k;
            if (1 != paramXmlPullParser.type) {
              break label150;
            }
            if (paramXmlPullParser.jIS != null) {}
            for (bool1 = true;; bool1 = false)
            {
              i = k;
              break;
            }
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.type != 2) {
              break label150;
            }
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.jHW != null) {
              break label150;
            }
            bool1 = false;
            i = k;
            break label150;
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.type != 3) {
              break label150;
            }
            paramString = paramXmlPullParser.jIS;
            if (paramString != null)
            {
              paramString = paramString.lXO;
              label362:
              if (paramString != null)
              {
                paramString = (CharSequence)paramXmlPullParser.jIS.lXN;
                if ((paramString != null) && (paramString.length() != 0)) {
                  break label419;
                }
              }
            }
            label419:
            for (int j = 1;; j = 0)
            {
              bool1 = bool2;
              i = k;
              if (j == 0) {
                break;
              }
              bool1 = false;
              i = k;
              break;
              paramString = null;
              break label362;
            }
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.type != 4) {
              break label150;
            }
            paramString = paramXmlPullParser.jIc;
            if (paramString != null) {}
            for (paramString = paramString.lXm;; paramString = null)
            {
              bool1 = bool2;
              i = k;
              if (paramString != null) {
                break;
              }
              bool1 = false;
              i = k;
              break;
            }
          }
        }
      }
      Log.i(this.TAG, "validEggInfo: " + paramXmlPullParser.name + ", " + paramXmlPullParser.lXs + ", " + paramXmlPullParser.type + ", " + bool1);
      if (!bool1) {
        break label56;
      }
      this.jIa.lXv.add(localh.jHX);
      AppMethodBeat.o(105506);
      return;
      label566:
      i = 3;
      bool1 = bool2;
    }
  }
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105505);
    kotlin.g.b.p.k(paramXmlPullParser, "parser");
    this.jIa.bLJ = e(paramXmlPullParser, "version");
    super.c(paramXmlPullParser);
    AppMethodBeat.o(105505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.i
 * JD-Core Version:    0.7.0.1
 */