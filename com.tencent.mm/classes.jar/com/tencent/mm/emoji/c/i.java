package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.e;
import com.tencent.mm.modelpackage.g;
import com.tencent.mm.modelpackage.m;
import com.tencent.mm.modelpackage.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a
{
  public static final i.a mhH;
  private final String TAG;
  public final g mhI;
  
  static
  {
    AppMethodBeat.i(160330);
    mhH = new i.a((byte)0);
    AppMethodBeat.o(160330);
  }
  
  public i()
  {
    AppMethodBeat.i(105507);
    this.TAG = "MicroMsg.EggListParser";
    this.mhI = new g();
    AppMethodBeat.o(105507);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    int k = 4;
    boolean bool2 = true;
    AppMethodBeat.i(105506);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    boolean bool1;
    h localh;
    int i;
    if (s.p(paramString, "Item"))
    {
      bool1 = true;
      if (!bool1) {
        break label710;
      }
      localh = new h(s.p(paramString, "ItemNew"));
      localh.e(paramXmlPullParser);
      paramXmlPullParser = localh.mhF;
      if ((paramXmlPullParser.oQu < 10) || (paramXmlPullParser.type != 5)) {
        break label243;
      }
      paramString = paramXmlPullParser.mhJ;
      if (paramString == null) {
        break label227;
      }
      paramString = paramString.appId;
      if (paramString == null) {
        break label227;
      }
      if (((CharSequence)paramString).length() <= 0) {
        break label222;
      }
      i = 1;
      label116:
      if (i != 1) {
        break label227;
      }
      i = 1;
      label123:
      if (i == 0) {
        break label237;
      }
      paramString = paramXmlPullParser.mhJ.userName;
      s.s(paramString, "info.miniAppInfo.userName");
      if (((CharSequence)paramString).length() <= 0) {
        break label232;
      }
      i = 1;
      label155:
      if (i == 0) {
        break label237;
      }
      bool1 = true;
      label162:
      i = k;
    }
    for (;;)
    {
      label165:
      paramString = paramXmlPullParser.oQv.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          q localq = (q)paramString.next();
          if (localq.oQU > i)
          {
            localq.oQU = 0;
            continue;
            bool1 = s.p(paramString, "ItemNew");
            break;
            label222:
            i = 0;
            break label116;
            label227:
            i = 0;
            break label123;
            label232:
            i = 0;
            break label155;
            label237:
            bool1 = false;
            break label162;
            label243:
            if (paramXmlPullParser.oQu >= 8)
            {
              paramString = (CharSequence)paramXmlPullParser.oQx;
              if ((paramString != null) && (paramString.length() != 0)) {
                break label345;
              }
            }
            label345:
            for (int j = 1;; j = 0)
            {
              bool1 = bool2;
              i = k;
              if (j == 0) {
                break;
              }
              switch (paramXmlPullParser.oQu)
              {
              default: 
                bool1 = false;
                i = k;
                break label165;
              }
            }
            if (paramXmlPullParser.type == 0) {
              break label720;
            }
            paramXmlPullParser.type = 0;
            i = 3;
            bool1 = bool2;
            break label165;
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.type == 0) {
              break label165;
            }
            paramXmlPullParser.type = 0;
            bool1 = bool2;
            i = k;
            break label165;
            bool1 = bool2;
            i = k;
            if (1 != paramXmlPullParser.type) {
              break label165;
            }
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.mij != null) {
              break label165;
            }
            bool1 = false;
            i = k;
            break label165;
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.type != 2) {
              break label165;
            }
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.mhD != null) {
              break label165;
            }
            bool1 = false;
            i = k;
            break label165;
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.type != 3) {
              break label165;
            }
            paramString = paramXmlPullParser.mij;
            if (paramString == null)
            {
              paramString = null;
              label503:
              if (paramString != null)
              {
                paramString = (CharSequence)paramXmlPullParser.mij.oQR;
                if ((paramString != null) && (paramString.length() != 0)) {
                  break label563;
                }
              }
            }
            label563:
            for (j = 1;; j = 0)
            {
              bool1 = bool2;
              i = k;
              if (j == 0) {
                break;
              }
              bool1 = false;
              i = k;
              break;
              paramString = paramString.oQS;
              break label503;
            }
            bool1 = bool2;
            i = k;
            if (paramXmlPullParser.type != 4) {
              break label165;
            }
            paramString = paramXmlPullParser.mhK;
            if (paramString == null) {}
            for (paramString = null;; paramString = paramString.oQo)
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
      Log.i(this.TAG, "validEggInfo: " + paramXmlPullParser.name + ", " + paramXmlPullParser.oQu + ", " + paramXmlPullParser.type + ", " + bool1);
      if (bool1)
      {
        this.mhI.oQz.add(localh.mhF);
        AppMethodBeat.o(105506);
        return;
        label710:
        skip(paramXmlPullParser);
      }
      AppMethodBeat.o(105506);
      return;
      label720:
      i = 3;
      bool1 = bool2;
    }
  }
  
  public final void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105505);
    s.u(paramXmlPullParser, "parser");
    this.mhI.dFr = f(paramXmlPullParser, "version");
    super.e(paramXmlPullParser);
    AppMethodBeat.o(105505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.c.i
 * JD-Core Version:    0.7.0.1
 */