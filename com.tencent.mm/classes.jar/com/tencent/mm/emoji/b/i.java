package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.g;
import com.tencent.mm.bb.k;
import com.tencent.mm.bb.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "Companion", "plugin-emojisdk_release"})
public final class i
  extends a
{
  public static final i.a gXd;
  private final String TAG;
  public final g gXc;
  
  static
  {
    AppMethodBeat.i(160330);
    gXd = new i.a((byte)0);
    AppMethodBeat.o(160330);
  }
  
  public i()
  {
    AppMethodBeat.i(105507);
    this.TAG = "MicroMsg.EggListParser";
    this.gXc = new g();
    AppMethodBeat.o(105507);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    boolean bool2 = true;
    AppMethodBeat.i(105506);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    label56:
    label71:
    h localh;
    int k;
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
      localh = new h(p.j(paramString, "ItemNew"));
      localh.c(paramXmlPullParser);
      paramXmlPullParser = localh.gWZ;
      k = 4;
      switch (paramXmlPullParser.jgP)
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
      paramString = paramXmlPullParser.jgQ.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          o localo = (o)paramString.next();
          if (localo.jhn > i)
          {
            localo.jhn = 0;
            continue;
            if (!paramString.equals("ItemNew")) {
              break;
            }
            break label71;
            if (paramXmlPullParser.type == 0) {
              break label512;
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
            if (paramXmlPullParser.gXT != null) {}
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
            if (paramXmlPullParser.gWY != null) {
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
            paramString = paramXmlPullParser.gXT;
            if (paramString != null)
            {
              paramString = paramString.jhm;
              label362:
              if (paramString != null)
              {
                paramString = (CharSequence)paramXmlPullParser.gXT.jhl;
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
          }
        }
      }
      Log.i(this.TAG, "validEggInfo: " + paramXmlPullParser.name + ", " + paramXmlPullParser.jgP + ", " + paramXmlPullParser.type + ", " + bool1);
      if (!bool1) {
        break label56;
      }
      this.gXc.jgS.add(localh.gWZ);
      AppMethodBeat.o(105506);
      return;
      label512:
      i = 3;
      bool1 = bool2;
    }
  }
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105505);
    p.h(paramXmlPullParser, "parser");
    this.gXc.jgT = e(paramXmlPullParser, "version");
    super.c(paramXmlPullParser);
    AppMethodBeat.o(105505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.i
 * JD-Core Version:    0.7.0.1
 */