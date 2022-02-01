package com.a.a;

import android.graphics.Matrix;
import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class l
{
  private h aCj = null;
  private h.aj aCk = null;
  private boolean aCl = false;
  private int aCm;
  private boolean aCn = false;
  private g aCo = null;
  private StringBuilder aCp = null;
  private boolean aCq = false;
  private StringBuilder aCr = null;
  
  private void A(Attributes paramAttributes)
  {
    AppMethodBeat.i(203301);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203301);
      throw paramAttributes;
    }
    h.bf localbf = new h.bf();
    localbf.aBi = this.aCj;
    localbf.aBj = this.aCk;
    a(localbf, paramAttributes);
    a(localbf, paramAttributes);
    a(localbf, paramAttributes);
    this.aCk.a(localbf);
    this.aCk = localbf;
    AppMethodBeat.o(203301);
  }
  
  private void B(Attributes paramAttributes)
  {
    AppMethodBeat.i(203308);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203308);
      throw paramAttributes;
    }
    h.s locals = new h.s();
    locals.aBi = this.aCj;
    locals.aBj = this.aCk;
    a(locals, paramAttributes);
    b(locals, paramAttributes);
    a(locals, paramAttributes);
    a(locals, paramAttributes);
    this.aCk.a(locals);
    this.aCk = locals;
    AppMethodBeat.o(203308);
  }
  
  private void C(Attributes paramAttributes)
  {
    AppMethodBeat.i(203516);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203516);
      throw paramAttributes;
    }
    Object localObject = "all";
    int i = 0;
    boolean bool = true;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        bool = str.equals("text/css");
        continue;
        localObject = str;
      }
    }
    if ((bool) && (b.a((String)localObject, b.e.awR)))
    {
      this.aCq = true;
      AppMethodBeat.o(203516);
      return;
    }
    this.aCl = true;
    this.aCm = 1;
    AppMethodBeat.o(203516);
  }
  
  private static int F(float paramFloat)
  {
    AppMethodBeat.i(203430);
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(203430);
      return 0;
    }
    if (paramFloat > 255.0F)
    {
      AppMethodBeat.o(203430);
      return 255;
    }
    int i = Math.round(paramFloat);
    AppMethodBeat.o(203430);
    return i;
  }
  
  static Map<String, String> a(h paramh)
  {
    AppMethodBeat.i(203157);
    HashMap localHashMap = new HashMap();
    paramh.oR();
    for (String str = paramh.c('='); str != null; str = paramh.c('='))
    {
      paramh.b('=');
      localHashMap.put(str, paramh.pf());
      paramh.oR();
    }
    AppMethodBeat.o(203157);
    return localHashMap;
  }
  
  private static void a(h.a parama, Attributes paramAttributes)
  {
    AppMethodBeat.i(203167);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
          parama.ayD = str;
        }
      }
    }
    AppMethodBeat.o(203167);
  }
  
  private static void a(h.ab paramab, Attributes paramAttributes)
  {
    AppMethodBeat.i(203183);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                i += 1;
                break;
                paramab.aza = ag(str);
                continue;
                paramab.azb = ag(str);
              }
              paramab.azc = ag(str);
            } while (!paramab.azc.os());
            paramab = new k("Invalid <rect> element. width cannot be negative");
            AppMethodBeat.o(203183);
            throw paramab;
            paramab.azd = ag(str);
          } while (!paramab.azd.os());
          paramab = new k("Invalid <rect> element. height cannot be negative");
          AppMethodBeat.o(203183);
          throw paramab;
          paramab.ayQ = ag(str);
        } while (!paramab.ayQ.os());
        paramab = new k("Invalid <rect> element. rx cannot be negative");
        AppMethodBeat.o(203183);
        throw paramab;
        paramab.ayR = ag(str);
      } while (!paramab.ayR.os());
      paramab = new k("Invalid <rect> element. ry cannot be negative");
      AppMethodBeat.o(203183);
      throw paramab;
    }
    AppMethodBeat.o(203183);
  }
  
  private static void a(h.ad paramad, Attributes paramAttributes)
  {
    AppMethodBeat.i(203255);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramad.azC = ae(str);
      }
    }
    AppMethodBeat.o(203255);
  }
  
  private static void a(h.ae paramae, String paramString)
  {
    AppMethodBeat.i(203446);
    if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains("|" + paramString + '|'))
    {
      AppMethodBeat.o(203446);
      return;
    }
    h localh = new h(paramString);
    Object localObject4 = null;
    paramString = null;
    Object localObject1 = null;
    String str;
    Object localObject2;
    Object localObject5;
    for (;;)
    {
      str = localh.c('/');
      localh.oR();
      if (str == null)
      {
        AppMethodBeat.o(203446);
        return;
      }
      if (localObject1 != null)
      {
        localObject2 = paramString;
        localObject5 = localObject1;
        if (paramString != null) {
          break;
        }
      }
      if (!str.equals("normal"))
      {
        Object localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = l.d.aL(str);
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = paramString;
          if (paramString == null)
          {
            localObject2 = as(str);
            paramString = (String)localObject2;
            localObject1 = localObject3;
            if (localObject2 == null) {
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject2 = localObject1;
            localObject5 = localObject3;
            if (localObject4 != null) {
              break;
            }
            localObject2 = localObject1;
            localObject5 = localObject3;
            if (!str.equals("small-caps")) {
              break;
            }
            localObject4 = str;
            paramString = (String)localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    paramString = ar(str);
    if (localh.b('/'))
    {
      localh.oR();
      localObject1 = localh.oZ();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        ag((String)localObject1);
        localh.oR();
        paramae.azR = aq(localh.pg());
        paramae.azS = paramString;
        if (localObject5 == null)
        {
          i = 400;
          paramae.azT = Integer.valueOf(i);
          paramString = (String)localObject2;
          if (localObject2 == null) {
            paramString = h.ae.b.aAt;
          }
          paramae.azU = paramString;
          paramae.azD |= 0x1E000;
          AppMethodBeat.o(203446);
          return;
        }
      }
      catch (k paramae)
      {
        AppMethodBeat.o(203446);
        return;
      }
      int i = localObject5.intValue();
    }
  }
  
  static void a(h.ae paramae, String paramString1, String paramString2)
  {
    AppMethodBeat.i(203373);
    if (paramString2.length() == 0)
    {
      AppMethodBeat.o(203373);
      return;
    }
    if (paramString2.equals("inherit"))
    {
      AppMethodBeat.o(203373);
      return;
    }
    switch (1.aCt[f.aN(paramString1).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203373);
      return;
      paramae.azE = am(paramString2);
      if (paramae.azE != null)
      {
        paramae.azD |= 1L;
        AppMethodBeat.o(203373);
        return;
        paramae.azF = av(paramString2);
        if (paramae.azF != null)
        {
          paramae.azD |= 0x2;
          AppMethodBeat.o(203373);
          return;
          paramae.azG = aj(paramString2);
          if (paramae.azG != null)
          {
            paramae.azD |= 0x4;
            AppMethodBeat.o(203373);
            return;
            paramae.azH = am(paramString2);
            if (paramae.azH != null)
            {
              paramae.azD |= 0x8;
              AppMethodBeat.o(203373);
              return;
              paramae.azI = aj(paramString2);
              if (paramae.azI != null)
              {
                paramae.azD |= 0x10;
                AppMethodBeat.o(203373);
                return;
                try
                {
                  paramae.azJ = ag(paramString2);
                  paramae.azD |= 0x20;
                  AppMethodBeat.o(203373);
                  return;
                }
                catch (k paramae)
                {
                  AppMethodBeat.o(203373);
                  return;
                }
                paramae.azK = aw(paramString2);
                if (paramae.azK != null)
                {
                  paramae.azD |= 0x40;
                  AppMethodBeat.o(203373);
                  return;
                  paramae.azL = ax(paramString2);
                  if (paramae.azL != null)
                  {
                    paramae.azD |= 0x80;
                    AppMethodBeat.o(203373);
                    return;
                    try
                    {
                      paramae.azM = Float.valueOf(ai(paramString2));
                      paramae.azD |= 0x100;
                      AppMethodBeat.o(203373);
                      return;
                    }
                    catch (k paramae)
                    {
                      AppMethodBeat.o(203373);
                      return;
                    }
                    if ("none".equals(paramString2))
                    {
                      paramae.azN = null;
                      paramae.azD |= 0x200;
                      AppMethodBeat.o(203373);
                      return;
                    }
                    paramae.azN = ay(paramString2);
                    if (paramae.azN != null)
                    {
                      paramae.azD |= 0x200;
                      AppMethodBeat.o(203373);
                      return;
                      try
                      {
                        paramae.azO = ag(paramString2);
                        paramae.azD |= 0x400;
                        AppMethodBeat.o(203373);
                        return;
                      }
                      catch (k paramae)
                      {
                        AppMethodBeat.o(203373);
                        return;
                      }
                      paramae.azP = aj(paramString2);
                      paramae.azD |= 0x800;
                      AppMethodBeat.o(203373);
                      return;
                      try
                      {
                        paramae.azQ = ao(paramString2);
                        paramae.azD |= 0x1000;
                        AppMethodBeat.o(203373);
                        return;
                      }
                      catch (k paramae)
                      {
                        AppMethodBeat.o(203373);
                        return;
                      }
                      a(paramae, paramString2);
                      AppMethodBeat.o(203373);
                      return;
                      paramae.azR = aq(paramString2);
                      if (paramae.azR != null)
                      {
                        paramae.azD |= 0x2000;
                        AppMethodBeat.o(203373);
                        return;
                        paramae.azS = ar(paramString2);
                        if (paramae.azS != null)
                        {
                          paramae.azD |= 0x4000;
                          AppMethodBeat.o(203373);
                          return;
                          paramae.azT = l.d.aL(paramString2);
                          if (paramae.azT != null)
                          {
                            paramae.azD |= 0x8000;
                            AppMethodBeat.o(203373);
                            return;
                            paramae.azU = as(paramString2);
                            if (paramae.azU != null)
                            {
                              paramae.azD |= 0x10000;
                              AppMethodBeat.o(203373);
                              return;
                              paramae.azV = at(paramString2);
                              if (paramae.azV != null)
                              {
                                paramae.azD |= 0x20000;
                                AppMethodBeat.o(203373);
                                return;
                                paramae.azW = au(paramString2);
                                if (paramae.azW != null)
                                {
                                  paramae.azD |= 0x0;
                                  AppMethodBeat.o(203373);
                                  return;
                                  paramae.azX = az(paramString2);
                                  if (paramae.azX != null)
                                  {
                                    paramae.azD |= 0x40000;
                                    AppMethodBeat.o(203373);
                                    return;
                                    paramae.azY = aA(paramString2);
                                    if (paramae.azY != null)
                                    {
                                      paramae.azD |= 0x80000;
                                      AppMethodBeat.o(203373);
                                      return;
                                      paramae.aAa = aI(paramString2);
                                      paramae.aAb = paramae.aAa;
                                      paramae.aAc = paramae.aAa;
                                      paramae.azD |= 0xE00000;
                                      AppMethodBeat.o(203373);
                                      return;
                                      paramae.aAa = aI(paramString2);
                                      paramae.azD |= 0x200000;
                                      AppMethodBeat.o(203373);
                                      return;
                                      paramae.aAb = aI(paramString2);
                                      paramae.azD |= 0x400000;
                                      AppMethodBeat.o(203373);
                                      return;
                                      paramae.aAc = aI(paramString2);
                                      paramae.azD |= 0x800000;
                                      AppMethodBeat.o(203373);
                                      return;
                                      if ((paramString2.indexOf('|') < 0) && ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains("|" + paramString2 + '|')))
                                      {
                                        if (!paramString2.equals("none")) {}
                                        for (boolean bool = true;; bool = false)
                                        {
                                          paramae.aAd = Boolean.valueOf(bool);
                                          paramae.azD |= 0x1000000;
                                          AppMethodBeat.o(203373);
                                          return;
                                        }
                                        if ((paramString2.indexOf('|') < 0) && ("|visible|hidden|collapse|".contains("|" + paramString2 + '|')))
                                        {
                                          paramae.aAe = Boolean.valueOf(paramString2.equals("visible"));
                                          paramae.azD |= 0x2000000;
                                          AppMethodBeat.o(203373);
                                          return;
                                          if (paramString2.equals("currentColor")) {
                                            paramae.aAf = h.g.op();
                                          }
                                          for (;;)
                                          {
                                            paramae.azD |= 0x4000000;
                                            AppMethodBeat.o(203373);
                                            return;
                                            try
                                            {
                                              paramae.aAf = ao(paramString2);
                                            }
                                            catch (k paramae)
                                            {
                                              paramae.getMessage();
                                              AppMethodBeat.o(203373);
                                              return;
                                            }
                                          }
                                          paramae.aAg = aj(paramString2);
                                          paramae.azD |= 0x8000000;
                                          AppMethodBeat.o(203373);
                                          return;
                                          paramae.azZ = aB(paramString2);
                                          if (paramae.azZ != null)
                                          {
                                            paramae.azD |= 0x100000;
                                            AppMethodBeat.o(203373);
                                            return;
                                            paramae.aAh = aI(paramString2);
                                            paramae.azD |= 0x10000000;
                                            AppMethodBeat.o(203373);
                                            return;
                                            paramae.aAi = av(paramString2);
                                            paramae.azD |= 0x20000000;
                                            AppMethodBeat.o(203373);
                                            return;
                                            paramae.aAj = aI(paramString2);
                                            paramae.azD |= 0x40000000;
                                            AppMethodBeat.o(203373);
                                            return;
                                            if (paramString2.equals("currentColor")) {
                                              paramae.aAk = h.g.op();
                                            }
                                            for (;;)
                                            {
                                              paramae.azD |= 0x80000000;
                                              AppMethodBeat.o(203373);
                                              return;
                                              try
                                              {
                                                paramae.aAk = ao(paramString2);
                                              }
                                              catch (k paramae)
                                              {
                                                paramae.getMessage();
                                                AppMethodBeat.o(203373);
                                                return;
                                              }
                                            }
                                            paramae.aAl = aj(paramString2);
                                            paramae.azD |= 0x0;
                                            AppMethodBeat.o(203373);
                                            return;
                                            if (paramString2.equals("currentColor")) {
                                              paramae.aAm = h.g.op();
                                            }
                                            for (;;)
                                            {
                                              paramae.azD |= 0x0;
                                              AppMethodBeat.o(203373);
                                              return;
                                              try
                                              {
                                                paramae.aAm = ao(paramString2);
                                              }
                                              catch (k paramae)
                                              {
                                                paramae.getMessage();
                                                AppMethodBeat.o(203373);
                                                return;
                                              }
                                            }
                                            paramae.aAn = aj(paramString2);
                                            paramae.azD |= 0x0;
                                            AppMethodBeat.o(203373);
                                            return;
                                            paramae.aAo = aC(paramString2);
                                            if (paramae.aAo != null)
                                            {
                                              paramae.azD |= 0x0;
                                              AppMethodBeat.o(203373);
                                              return;
                                              paramae.aAp = aD(paramString2);
                                              if (paramae.aAp != null) {
                                                paramae.azD |= 0x0;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void a(h.af paramaf, Attributes paramAttributes)
  {
    AppMethodBeat.i(203160);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramaf.aza = ag(str);
        continue;
        paramaf.azb = ag(str);
        continue;
        paramaf.azc = ag(str);
        if (paramaf.azc.os())
        {
          paramaf = new k("Invalid <svg> element. width cannot be negative");
          AppMethodBeat.o(203160);
          throw paramaf;
          paramaf.azd = ag(str);
          if (paramaf.azd.os())
          {
            paramaf = new k("Invalid <svg> element. height cannot be negative");
            AppMethodBeat.o(203160);
            throw paramaf;
            paramaf.version = str;
          }
        }
      }
    }
    AppMethodBeat.o(203160);
  }
  
  private static void a(h.ag paramag, Attributes paramAttributes)
  {
    AppMethodBeat.i(203230);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      Object localObject = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      default: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
        for (;;)
        {
          i += 1;
          break;
          paramag.b(aF((String)localObject));
          continue;
          paramag.ab((String)localObject);
          continue;
          paramag.c(aG((String)localObject));
          continue;
          paramag.d(aH((String)localObject));
        }
      }
      localObject = aq((String)localObject);
      if (localObject != null) {}
      for (localObject = new HashSet((Collection)localObject);; localObject = new HashSet(0))
      {
        paramag.e((Set)localObject);
        break;
      }
    }
    AppMethodBeat.o(203230);
  }
  
  private static void a(h.al paramal, String paramString)
  {
    AppMethodBeat.i(203347);
    paramString = new b.c(paramString.replaceAll("/\\*.*?\\*/", ""));
    while (!paramString.empty())
    {
      paramString.oR();
      String str1 = paramString.nV();
      paramString.oR();
      if (!paramString.b(';'))
      {
        if (!paramString.b(':')) {
          break;
        }
        paramString.oR();
        String str2 = paramString.nY();
        if (str2 != null)
        {
          paramString.oR();
          if ((paramString.empty()) || (paramString.b(';')))
          {
            if (paramal.axD == null) {
              paramal.axD = new h.ae();
            }
            a(paramal.axD, str1, str2);
            paramString.oR();
          }
        }
      }
    }
    AppMethodBeat.o(203347);
  }
  
  private static void a(h.al paramal, Attributes paramAttributes)
  {
    AppMethodBeat.i(203326);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getQName(i);
      if ((str.equals("id")) || (str.equals("xml:id")))
      {
        paramal.id = paramAttributes.getValue(i).trim();
        AppMethodBeat.o(203326);
        return;
      }
      if (str.equals("xml:space"))
      {
        paramAttributes = paramAttributes.getValue(i).trim();
        if ("default".equals(paramAttributes))
        {
          paramal.aBf = Boolean.FALSE;
          AppMethodBeat.o(203326);
          return;
        }
        if ("preserve".equals(paramAttributes))
        {
          paramal.aBf = Boolean.TRUE;
          AppMethodBeat.o(203326);
          return;
        }
        paramal = new k("Invalid value for \"xml:space\" attribute: ".concat(String.valueOf(paramAttributes)));
        AppMethodBeat.o(203326);
        throw paramal;
      }
      i += 1;
    }
    AppMethodBeat.o(203326);
  }
  
  private static void a(h.am paramam, Attributes paramAttributes)
  {
    AppMethodBeat.i(203240);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramam.azf = ag(str);
        continue;
        paramam.azg = ag(str);
        continue;
        paramam.azh = ag(str);
        continue;
        paramam.azi = ag(str);
      }
    }
    AppMethodBeat.o(203240);
  }
  
  private static void a(h.ap paramap, String paramString)
  {
    AppMethodBeat.i(203414);
    paramap.ays = al(paramString);
    AppMethodBeat.o(203414);
  }
  
  private static void a(h.aq paramaq, Attributes paramAttributes)
  {
    AppMethodBeat.i(203249);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramaq.ayI = ag(str);
        continue;
        paramaq.ayJ = ag(str);
        continue;
        paramaq.ayK = ag(str);
        if (paramaq.ayK.os())
        {
          paramaq = new k("Invalid <radialGradient> element. r cannot be negative");
          AppMethodBeat.o(203249);
          throw paramaq;
          paramaq.aBk = ag(str);
          continue;
          paramaq.aBl = ag(str);
        }
      }
    }
    AppMethodBeat.o(203249);
  }
  
  private static void a(h.ar paramar, Attributes paramAttributes)
  {
    AppMethodBeat.i(203374);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramar.ayu = ak(str);
        continue;
        a(paramar, str);
      }
    }
    AppMethodBeat.o(203374);
  }
  
  private static void a(h.au paramau, Attributes paramAttributes)
  {
    AppMethodBeat.i(203225);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
          paramau.ayD = str;
        }
      }
    }
    AppMethodBeat.o(203225);
  }
  
  private static void a(h.az paramaz, Attributes paramAttributes)
  {
    AppMethodBeat.i(203282);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i))))
        {
          paramaz.ayD = str;
          continue;
          paramaz.aBn = ag(str);
        }
      }
    }
    AppMethodBeat.o(203282);
  }
  
  private static void a(h.ba paramba, Attributes paramAttributes)
  {
    AppMethodBeat.i(203217);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramba.aBo = ah(str);
        continue;
        paramba.aBp = ah(str);
        continue;
        paramba.aBq = ah(str);
        continue;
        paramba.aBr = ah(str);
      }
    }
    AppMethodBeat.o(203217);
  }
  
  private static void a(h.be parambe, Attributes paramAttributes)
  {
    AppMethodBeat.i(203172);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        parambe.aza = ag(str);
        continue;
        parambe.azb = ag(str);
        continue;
        parambe.azc = ag(str);
        if (parambe.azc.os())
        {
          parambe = new k("Invalid <use> element. width cannot be negative");
          AppMethodBeat.o(203172);
          throw parambe;
          parambe.azd = ag(str);
          if (parambe.azd.os())
          {
            parambe = new k("Invalid <use> element. height cannot be negative");
            AppMethodBeat.o(203172);
            throw parambe;
            if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
              parambe.ayD = str;
            }
          }
        }
      }
    }
    AppMethodBeat.o(203172);
  }
  
  private static void a(h.d paramd, Attributes paramAttributes)
  {
    AppMethodBeat.i(203188);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramd.ayI = ag(str);
          continue;
          paramd.ayJ = ag(str);
        }
        paramd.ayK = ag(str);
      } while (!paramd.ayK.os());
      paramd = new k("Invalid <circle> element. r cannot be negative");
      AppMethodBeat.o(203188);
      throw paramd;
    }
    AppMethodBeat.o(203188);
  }
  
  private static void a(h.e parame, Attributes paramAttributes)
  {
    AppMethodBeat.i(203273);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          parame.ayL = Boolean.FALSE;
        }
        else
        {
          if (!"userSpaceOnUse".equals(str)) {
            break label111;
          }
          parame.ayL = Boolean.TRUE;
        }
      }
      label111:
      parame = new k("Invalid value for attribute clipPathUnits");
      AppMethodBeat.o(203273);
      throw parame;
    }
    AppMethodBeat.o(203273);
  }
  
  private static void a(h.i parami, Attributes paramAttributes)
  {
    AppMethodBeat.i(203191);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        do
        {
          for (;;)
          {
            i += 1;
            break;
            parami.ayI = ag(str);
            continue;
            parami.ayJ = ag(str);
          }
          parami.ayQ = ag(str);
        } while (!parami.ayQ.os());
        parami = new k("Invalid <ellipse> element. rx cannot be negative");
        AppMethodBeat.o(203191);
        throw parami;
        parami.ayR = ag(str);
      } while (!parami.ayR.os());
      parami = new k("Invalid <ellipse> element. ry cannot be negative");
      AppMethodBeat.o(203191);
      throw parami;
    }
    AppMethodBeat.o(203191);
  }
  
  private static void a(h.j paramj, Attributes paramAttributes)
  {
    AppMethodBeat.i(203238);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          paramj.ayT = Boolean.FALSE;
        }
        else if ("userSpaceOnUse".equals(str))
        {
          paramj.ayT = Boolean.TRUE;
        }
        else
        {
          paramj = new k("Invalid value for attribute gradientUnits");
          AppMethodBeat.o(203238);
          throw paramj;
          paramj.ayU = af(str);
          continue;
          try
          {
            paramj.ayV = h.k.valueOf(str);
          }
          catch (IllegalArgumentException paramj)
          {
            paramj = new k("Invalid spreadMethod attribute. \"" + str + "\" is not a valid value.");
            AppMethodBeat.o(203238);
            throw paramj;
          }
          if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
            paramj.ayD = str;
          }
        }
      }
    }
    AppMethodBeat.o(203238);
  }
  
  private static void a(h.n paramn, Attributes paramAttributes)
  {
    AppMethodBeat.i(203375);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      if (f.aN(paramAttributes.getLocalName(i)) == f.aDX) {
        paramn.setTransform(af(paramAttributes.getValue(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(203375);
  }
  
  private static void a(h.o paramo, Attributes paramAttributes)
  {
    AppMethodBeat.i(203177);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramo.aza = ag(str);
        continue;
        paramo.azb = ag(str);
        continue;
        paramo.azc = ag(str);
        if (paramo.azc.os())
        {
          paramo = new k("Invalid <use> element. width cannot be negative");
          AppMethodBeat.o(203177);
          throw paramo;
          paramo.azd = ag(str);
          if (paramo.azd.os())
          {
            paramo = new k("Invalid <use> element. height cannot be negative");
            AppMethodBeat.o(203177);
            throw paramo;
            if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i))))
            {
              paramo.ayD = str;
              continue;
              a(paramo, str);
            }
          }
        }
      }
    }
    AppMethodBeat.o(203177);
  }
  
  private static void a(h.q paramq, Attributes paramAttributes)
  {
    AppMethodBeat.i(203197);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramq.azf = ag(str);
        continue;
        paramq.azg = ag(str);
        continue;
        paramq.azh = ag(str);
        continue;
        paramq.azi = ag(str);
      }
    }
    AppMethodBeat.o(203197);
  }
  
  private static void a(h.r paramr, Attributes paramAttributes)
  {
    AppMethodBeat.i(203236);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramr.azk = ag(str);
        continue;
        paramr.azl = ag(str);
        continue;
        paramr.azm = ag(str);
        if (paramr.azm.os())
        {
          paramr = new k("Invalid <marker> element. markerWidth cannot be negative");
          AppMethodBeat.o(203236);
          throw paramr;
          paramr.azn = ag(str);
          if (paramr.azn.os())
          {
            paramr = new k("Invalid <marker> element. markerHeight cannot be negative");
            AppMethodBeat.o(203236);
            throw paramr;
            if ("strokeWidth".equals(str))
            {
              paramr.azj = false;
            }
            else if ("userSpaceOnUse".equals(str))
            {
              paramr.azj = true;
            }
            else
            {
              paramr = new k("Invalid value for attribute markerUnits");
              AppMethodBeat.o(203236);
              throw paramr;
              if ("auto".equals(str)) {
                paramr.azo = Float.valueOf((0.0F / 0.0F));
              } else {
                paramr.azo = Float.valueOf(ai(str));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(203236);
  }
  
  private static void a(h.s params, Attributes paramAttributes)
  {
    AppMethodBeat.i(203319);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        do
        {
          for (;;)
          {
            i += 1;
            break;
            if ("objectBoundingBox".equals(str))
            {
              params.azp = Boolean.FALSE;
            }
            else if ("userSpaceOnUse".equals(str))
            {
              params.azp = Boolean.TRUE;
            }
            else
            {
              params = new k("Invalid value for attribute maskUnits");
              AppMethodBeat.o(203319);
              throw params;
              if ("objectBoundingBox".equals(str))
              {
                params.azq = Boolean.FALSE;
              }
              else if ("userSpaceOnUse".equals(str))
              {
                params.azq = Boolean.TRUE;
              }
              else
              {
                params = new k("Invalid value for attribute maskContentUnits");
                AppMethodBeat.o(203319);
                throw params;
                params.aza = ag(str);
                continue;
                params.azb = ag(str);
              }
            }
          }
          params.azc = ag(str);
        } while (!params.azc.os());
        params = new k("Invalid <mask> element. width cannot be negative");
        AppMethodBeat.o(203319);
        throw params;
        params.azd = ag(str);
      } while (!params.azd.os());
      params = new k("Invalid <mask> element. height cannot be negative");
      AppMethodBeat.o(203319);
      throw params;
    }
    AppMethodBeat.o(203319);
  }
  
  private static void a(h.v paramv, Attributes paramAttributes)
  {
    AppMethodBeat.i(203180);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramv.azs = aE(str);
        }
        paramv.azt = Float.valueOf(ai(str));
      } while (paramv.azt.floatValue() >= 0.0F);
      paramv = new k("Invalid <path> element. pathLength cannot be negative");
      AppMethodBeat.o(203180);
      throw paramv;
    }
    AppMethodBeat.o(203180);
  }
  
  private static void a(h.y paramy, Attributes paramAttributes)
  {
    AppMethodBeat.i(203295);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          paramy.azy = Boolean.FALSE;
        }
        else if ("userSpaceOnUse".equals(str))
        {
          paramy.azy = Boolean.TRUE;
        }
        else
        {
          paramy = new k("Invalid value for attribute patternUnits");
          AppMethodBeat.o(203295);
          throw paramy;
          if ("objectBoundingBox".equals(str))
          {
            paramy.azz = Boolean.FALSE;
          }
          else if ("userSpaceOnUse".equals(str))
          {
            paramy.azz = Boolean.TRUE;
          }
          else
          {
            paramy = new k("Invalid value for attribute patternContentUnits");
            AppMethodBeat.o(203295);
            throw paramy;
            paramy.azA = af(str);
            continue;
            paramy.aza = ag(str);
            continue;
            paramy.azb = ag(str);
            continue;
            paramy.azc = ag(str);
            if (paramy.azc.os())
            {
              paramy = new k("Invalid <pattern> element. width cannot be negative");
              AppMethodBeat.o(203295);
              throw paramy;
              paramy.azd = ag(str);
              if (paramy.azd.os())
              {
                paramy = new k("Invalid <pattern> element. height cannot be negative");
                AppMethodBeat.o(203295);
                throw paramy;
                if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
                  paramy.ayD = str;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(203295);
  }
  
  private static void a(h.z paramz, Attributes paramAttributes, String paramString)
  {
    AppMethodBeat.i(203209);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      if (f.aN(paramAttributes.getLocalName(i)) == f.aDu)
      {
        Object localObject = new h(paramAttributes.getValue(i));
        ArrayList localArrayList = new ArrayList();
        ((h)localObject).oR();
        float f1;
        while (!((h)localObject).empty())
        {
          f1 = ((h)localObject).oT();
          if (Float.isNaN(f1))
          {
            paramz = new k("Invalid <" + paramString + "> points attribute. Non-coordinate content found in list.");
            AppMethodBeat.o(203209);
            throw paramz;
          }
          ((h)localObject).oS();
          float f2 = ((h)localObject).oT();
          if (Float.isNaN(f2))
          {
            paramz = new k("Invalid <" + paramString + "> points attribute. There should be an even number of coordinates.");
            AppMethodBeat.o(203209);
            throw paramz;
          }
          ((h)localObject).oS();
          localArrayList.add(Float.valueOf(f1));
          localArrayList.add(Float.valueOf(f2));
        }
        paramz.azB = new float[localArrayList.size()];
        localObject = localArrayList.iterator();
        int j = 0;
        while (((Iterator)localObject).hasNext())
        {
          f1 = ((Float)((Iterator)localObject).next()).floatValue();
          paramz.azB[j] = f1;
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(203209);
  }
  
  private void a(Attributes paramAttributes)
  {
    AppMethodBeat.i(203158);
    h.af localaf = new h.af();
    localaf.aBi = this.aCj;
    localaf.aBj = this.aCk;
    a(localaf, paramAttributes);
    b(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    if (this.aCk == null) {
      this.aCj.ayy = localaf;
    }
    for (;;)
    {
      this.aCk = localaf;
      AppMethodBeat.o(203158);
      return;
      this.aCk.a(localaf);
    }
  }
  
  private static Boolean aA(String paramString)
  {
    AppMethodBeat.i(203487);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(203487);
        return null;
        if (paramString.equals("visible"))
        {
          i = 0;
          continue;
          if (paramString.equals("auto"))
          {
            i = 1;
            continue;
            if (paramString.equals("hidden"))
            {
              i = 2;
              continue;
              if (paramString.equals("scroll")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    paramString = Boolean.TRUE;
    AppMethodBeat.o(203487);
    return paramString;
    paramString = Boolean.FALSE;
    AppMethodBeat.o(203487);
    return paramString;
  }
  
  private static h.c aB(String paramString)
  {
    AppMethodBeat.i(203490);
    if ("auto".equals(paramString))
    {
      AppMethodBeat.o(203490);
      return null;
    }
    if (!paramString.startsWith("rect("))
    {
      AppMethodBeat.o(203490);
      return null;
    }
    paramString = new h(paramString.substring(5));
    paramString.oR();
    h.p localp1 = b(paramString);
    paramString.oS();
    h.p localp2 = b(paramString);
    paramString.oS();
    h.p localp3 = b(paramString);
    paramString.oS();
    h.p localp4 = b(paramString);
    paramString.oR();
    if ((!paramString.b(')')) && (!paramString.empty()))
    {
      AppMethodBeat.o(203490);
      return null;
    }
    paramString = new h.c(localp1, localp2, localp3, localp4);
    AppMethodBeat.o(203490);
    return paramString;
  }
  
  private static h.ae.i aC(String paramString)
  {
    AppMethodBeat.i(203493);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(203493);
        return null;
        if (paramString.equals("none"))
        {
          i = 0;
          continue;
          if (paramString.equals("non-scaling-stroke")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramString = h.ae.i.aAW;
    AppMethodBeat.o(203493);
    return paramString;
    paramString = h.ae.i.aAX;
    AppMethodBeat.o(203493);
    return paramString;
  }
  
  private static h.ae.e aD(String paramString)
  {
    AppMethodBeat.i(203495);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(203495);
        return null;
        if (paramString.equals("auto"))
        {
          i = 0;
          continue;
          if (paramString.equals("optimizeQuality"))
          {
            i = 1;
            continue;
            if (paramString.equals("optimizeSpeed")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramString = h.ae.e.aAF;
    AppMethodBeat.o(203495);
    return paramString;
    paramString = h.ae.e.aAG;
    AppMethodBeat.o(203495);
    return paramString;
    paramString = h.ae.e.aAH;
    AppMethodBeat.o(203495);
    return paramString;
  }
  
  private static h.w aE(String paramString)
  {
    AppMethodBeat.i(203508);
    paramString = new h(paramString);
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f10 = 0.0F;
    float f9 = 0.0F;
    h.w localw = new h.w();
    if (paramString.empty())
    {
      AppMethodBeat.o(203508);
      return localw;
    }
    int i = paramString.oV().intValue();
    float f2;
    float f1;
    label107:
    float f5;
    float f6;
    float f7;
    if ((i != 77) && (i != 109))
    {
      AppMethodBeat.o(203508);
      return localw;
      if ((i == 109) && (!localw.isEmpty()))
      {
        Object localObject2;
        localObject2 += f4;
        Object localObject1;
        localObject1 += f3;
        localw.l(f1, f2);
        if (i == 109)
        {
          i = 108;
          f5 = f2;
          f6 = f1;
          f7 = f2;
          f3 = f1;
          f4 = f2;
          f2 = f7;
          paramString.oS();
          if (paramString.empty()) {
            break label1460;
          }
          if (!paramString.pe()) {
            break label1469;
          }
          i = paramString.oV().intValue();
          f7 = f1;
          f1 = f3;
          f3 = f7;
          f10 = f6;
          f9 = f5;
        }
      }
    }
    for (;;)
    {
      label186:
      paramString.oR();
      switch (i)
      {
      default: 
        AppMethodBeat.o(203508);
        return localw;
      case 77: 
      case 109: 
        f1 = paramString.oT();
        f2 = paramString.G(f1);
        if (!Float.isNaN(f2)) {
          break;
        }
        new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
        AppMethodBeat.o(203508);
        return localw;
        i = 76;
        break;
      case 76: 
      case 108: 
        f5 = paramString.oT();
        f6 = paramString.G(f5);
        if (Float.isNaN(f6))
        {
          new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
          AppMethodBeat.o(203508);
          return localw;
        }
        if (i == 108) {
          f4 = f6 + f4;
        }
      case 67: 
      case 99: 
      case 83: 
      case 115: 
      case 90: 
      case 122: 
      case 72: 
      case 104: 
      case 86: 
      case 118: 
      case 81: 
      case 113: 
      case 84: 
      case 116: 
      case 65: 
      case 97: 
        for (f3 = f5 + f3;; f3 = f5)
        {
          localw.m(f3, f4);
          f5 = f4;
          f6 = f3;
          f7 = f1;
          f1 = f3;
          f3 = f7;
          break;
          f7 = paramString.oT();
          float f8 = paramString.G(f7);
          f6 = paramString.G(f8);
          f5 = paramString.G(f6);
          f9 = paramString.G(f5);
          f10 = paramString.G(f9);
          if (Float.isNaN(f10))
          {
            new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
            AppMethodBeat.o(203508);
            return localw;
          }
          if (i == 99)
          {
            f9 += f3;
            f7 += f3;
            f8 += f4;
            f6 += f3;
            f5 += f4;
            f4 = f10 + f4;
          }
          for (f3 = f9;; f3 = f9)
          {
            localw.a(f7, f8, f6, f5, f3, f4);
            f7 = f1;
            f1 = f3;
            f3 = f7;
            break;
            f6 = paramString.oT();
            f8 = paramString.G(f6);
            f7 = paramString.G(f8);
            f5 = paramString.G(f7);
            if (Float.isNaN(f5))
            {
              new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
              AppMethodBeat.o(203508);
              return localw;
            }
            if (i == 115)
            {
              f7 += f3;
              f6 += f3;
              f8 += f4;
              f5 += f4;
            }
            for (;;)
            {
              localw.a(2.0F * f3 - f10, 2.0F * f4 - f9, f6, f8, f7, f5);
              f3 = f1;
              f4 = f5;
              f5 = f8;
              f1 = f7;
              break;
              localw.a((byte)8);
              f5 = f2;
              f6 = f1;
              f7 = f2;
              f3 = f1;
              f4 = f2;
              f2 = f7;
              break;
              f5 = paramString.oT();
              if (Float.isNaN(f5))
              {
                new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                AppMethodBeat.o(203508);
                return localw;
              }
              if (i == 104) {}
              for (f3 = f5 + f3;; f3 = f5)
              {
                localw.m(f3, f4);
                f6 = f3;
                f7 = f1;
                f1 = f3;
                f5 = f9;
                f3 = f7;
                break;
                f5 = paramString.oT();
                if (Float.isNaN(f5))
                {
                  new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                  AppMethodBeat.o(203508);
                  return localw;
                }
                if (i == 118) {}
                for (f4 = f5 + f4;; f4 = f5)
                {
                  localw.m(f3, f4);
                  f5 = f4;
                  f7 = f1;
                  f1 = f3;
                  f6 = f10;
                  f3 = f7;
                  break;
                  f5 = paramString.oT();
                  f6 = paramString.G(f5);
                  f8 = paramString.G(f6);
                  f7 = paramString.G(f8);
                  if (Float.isNaN(f7))
                  {
                    new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                    AppMethodBeat.o(203508);
                    return localw;
                  }
                  if (i == 113)
                  {
                    f5 = f3 + f5;
                    f7 += f4;
                    f3 = f8 + f3;
                    f6 += f4;
                    f4 = f7;
                  }
                  for (;;)
                  {
                    localw.f(f5, f6, f3, f4);
                    f8 = f5;
                    f7 = f1;
                    f5 = f6;
                    f6 = f8;
                    f1 = f3;
                    f3 = f7;
                    break;
                    f6 = 2.0F * f3 - f10;
                    f5 = 2.0F * f4 - f9;
                    f7 = paramString.oT();
                    f8 = paramString.G(f7);
                    if (Float.isNaN(f8))
                    {
                      new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                      AppMethodBeat.o(203508);
                      return localw;
                    }
                    if (i == 116) {
                      f4 = f8 + f4;
                    }
                    for (f3 = f7 + f3;; f3 = f7)
                    {
                      localw.f(f6, f5, f3, f4);
                      f7 = f1;
                      f1 = f3;
                      f3 = f7;
                      break;
                      f7 = paramString.oT();
                      f8 = paramString.G(f7);
                      f9 = paramString.G(f8);
                      Boolean localBoolean1 = paramString.R(Float.valueOf(f9));
                      Boolean localBoolean2 = paramString.R(localBoolean1);
                      f5 = paramString.a(localBoolean2);
                      f6 = paramString.G(f5);
                      if ((Float.isNaN(f6)) || (f7 < 0.0F) || (f8 < 0.0F))
                      {
                        new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                        AppMethodBeat.o(203508);
                        return localw;
                      }
                      if (i == 97) {
                        f4 = f6 + f4;
                      }
                      for (f3 = f5 + f3;; f3 = f5)
                      {
                        localw.a(f7, f8, f9, localBoolean1.booleanValue(), localBoolean2.booleanValue(), f3, f4);
                        f5 = f4;
                        f6 = f3;
                        f7 = f1;
                        f1 = f3;
                        f3 = f7;
                        break;
                        label1460:
                        AppMethodBeat.o(203508);
                        return localw;
                        label1469:
                        f7 = f3;
                        f9 = f5;
                        f10 = f6;
                        f3 = f1;
                        f1 = f7;
                        break label186;
                        f4 = f6;
                      }
                      f4 = f8;
                    }
                    f4 = f7;
                    f3 = f8;
                  }
                }
              }
            }
            f4 = f10;
          }
          f4 = f6;
        }
        break label107;
        f2 = 0.0F;
        f1 = 0.0F;
      }
    }
  }
  
  private static Set<String> aF(String paramString)
  {
    AppMethodBeat.i(203511);
    paramString = new h(paramString);
    HashSet localHashSet = new HashSet();
    if (!paramString.empty())
    {
      String str = paramString.oZ();
      if (str.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
        localHashSet.add(str.substring(35));
      }
      for (;;)
      {
        paramString.oR();
        break;
        localHashSet.add("UNSUPPORTED");
      }
    }
    AppMethodBeat.o(203511);
    return localHashSet;
  }
  
  private static Set<String> aG(String paramString)
  {
    AppMethodBeat.i(203512);
    h localh = new h(paramString);
    HashSet localHashSet = new HashSet();
    while (!localh.empty())
    {
      String str = localh.oZ();
      int i = str.indexOf('-');
      paramString = str;
      if (i != -1) {
        paramString = str.substring(0, i);
      }
      localHashSet.add(new Locale(paramString, "", "").getLanguage());
      localh.oR();
    }
    AppMethodBeat.o(203512);
    return localHashSet;
  }
  
  private static Set<String> aH(String paramString)
  {
    AppMethodBeat.i(203513);
    paramString = new h(paramString);
    HashSet localHashSet = new HashSet();
    while (!paramString.empty())
    {
      localHashSet.add(paramString.oZ());
      paramString.oR();
    }
    AppMethodBeat.o(203513);
    return localHashSet;
  }
  
  private static String aI(String paramString)
  {
    AppMethodBeat.i(203514);
    if (paramString.equals("none"))
    {
      AppMethodBeat.o(203514);
      return null;
    }
    if (!paramString.startsWith("url("))
    {
      AppMethodBeat.o(203514);
      return null;
    }
    if (paramString.endsWith(")"))
    {
      paramString = paramString.substring(4, paramString.length() - 1).trim();
      AppMethodBeat.o(203514);
      return paramString;
    }
    paramString = paramString.substring(4).trim();
    AppMethodBeat.o(203514);
    return paramString;
  }
  
  private void aJ(String paramString)
  {
    AppMethodBeat.i(203518);
    b localb = new b(b.e.awR, b.t.axL);
    this.aCj.b(localb.W(paramString));
    AppMethodBeat.o(203518);
  }
  
  private void ad(String paramString)
  {
    AppMethodBeat.i(203149);
    Object localObject = (h.ah)this.aCk;
    int i = ((h.ah)localObject).ayS.size();
    if (i == 0) {}
    for (localObject = null; (localObject instanceof h.bc); localObject = (h.an)((h.ah)localObject).ayS.get(i - 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = (h.bc)localObject;
      ((h.bc)localObject).text += paramString;
      AppMethodBeat.o(203149);
      return;
    }
    this.aCk.a(new h.bc(paramString));
    AppMethodBeat.o(203149);
  }
  
  private static Float ae(String paramString)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(203261);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid offset value in <stop> (empty string)");
      AppMethodBeat.o(203261);
      throw paramString;
    }
    int j = paramString.length();
    int i;
    if (paramString.charAt(paramString.length() - 1) == '%')
    {
      j -= 1;
      i = 1;
    }
    for (;;)
    {
      float f1;
      try
      {
        float f3 = k(paramString, j);
        f1 = f3;
        if (i == 0) {
          break label152;
        }
        f1 = f3 / 100.0F;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = new k("Invalid offset value in <stop>: ".concat(String.valueOf(paramString)), localNumberFormatException);
        AppMethodBeat.o(203261);
        throw paramString;
      }
      AppMethodBeat.o(203261);
      return Float.valueOf(f1);
      if (f1 > 100.0F)
      {
        f1 = 100.0F;
      }
      else
      {
        continue;
        i = 0;
        continue;
        label152:
        if (f1 < 0.0F) {
          f1 = f2;
        }
      }
    }
  }
  
  private static Matrix af(String paramString)
  {
    AppMethodBeat.i(203397);
    Matrix localMatrix = new Matrix();
    h localh = new h(paramString);
    localh.oR();
    if (!localh.empty())
    {
      Object localObject = localh.pb();
      if (localObject == null)
      {
        paramString = new k("Bad transform function encountered in transform list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(203397);
        throw paramString;
      }
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramString = new k("Invalid transform list fn: " + (String)localObject + ")");
          AppMethodBeat.o(203397);
          throw paramString;
          if (((String)localObject).equals("matrix"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("translate"))
            {
              i = 1;
              continue;
              if (((String)localObject).equals("scale"))
              {
                i = 2;
                continue;
                if (((String)localObject).equals("rotate"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject).equals("skewX"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject).equals("skewY")) {
                      i = 5;
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      localh.oR();
      float f1 = localh.oT();
      localh.oS();
      float f2 = localh.oT();
      localh.oS();
      float f3 = localh.oT();
      localh.oS();
      float f4 = localh.oT();
      localh.oS();
      float f5 = localh.oT();
      localh.oS();
      float f6 = localh.oT();
      localh.oR();
      if ((Float.isNaN(f6)) || (!localh.b(')')))
      {
        paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(203397);
        throw paramString;
      }
      localObject = new Matrix();
      ((Matrix)localObject).setValues(new float[] { f1, f3, f5, f2, f4, f6, 0.0F, 0.0F, 1.0F });
      localMatrix.preConcat((Matrix)localObject);
      for (;;)
      {
        if (localh.empty()) {
          break label1011;
        }
        localh.oS();
        break;
        localh.oR();
        f1 = localh.oT();
        f2 = localh.oU();
        localh.oR();
        if ((Float.isNaN(f1)) || (!localh.b(')')))
        {
          paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(203397);
          throw paramString;
        }
        if (Float.isNaN(f2))
        {
          localMatrix.preTranslate(f1, 0.0F);
        }
        else
        {
          localMatrix.preTranslate(f1, f2);
          continue;
          localh.oR();
          f1 = localh.oT();
          f2 = localh.oU();
          localh.oR();
          if ((Float.isNaN(f1)) || (!localh.b(')')))
          {
            paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(203397);
            throw paramString;
          }
          if (Float.isNaN(f2))
          {
            localMatrix.preScale(f1, f1);
          }
          else
          {
            localMatrix.preScale(f1, f2);
            continue;
            localh.oR();
            f1 = localh.oT();
            f2 = localh.oU();
            f3 = localh.oU();
            localh.oR();
            if ((Float.isNaN(f1)) || (!localh.b(')')))
            {
              paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
              AppMethodBeat.o(203397);
              throw paramString;
            }
            if (Float.isNaN(f2))
            {
              localMatrix.preRotate(f1);
            }
            else if (!Float.isNaN(f3))
            {
              localMatrix.preRotate(f1, f2, f3);
            }
            else
            {
              paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
              AppMethodBeat.o(203397);
              throw paramString;
              localh.oR();
              f1 = localh.oT();
              localh.oR();
              if ((Float.isNaN(f1)) || (!localh.b(')')))
              {
                paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
                AppMethodBeat.o(203397);
                throw paramString;
              }
              localMatrix.preSkew((float)Math.tan(Math.toRadians(f1)), 0.0F);
              continue;
              localh.oR();
              f1 = localh.oT();
              localh.oR();
              if ((Float.isNaN(f1)) || (!localh.b(')')))
              {
                paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
                AppMethodBeat.o(203397);
                throw paramString;
              }
              localMatrix.preSkew(0.0F, (float)Math.tan(Math.toRadians(f1)));
            }
          }
        }
      }
    }
    label1011:
    AppMethodBeat.o(203397);
    return localMatrix;
  }
  
  private static h.p ag(String paramString)
  {
    AppMethodBeat.i(203399);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid length value (empty string)");
      AppMethodBeat.o(203399);
      throw paramString;
    }
    int j = paramString.length();
    h.bd localbd = h.bd.aBs;
    char c = paramString.charAt(j - 1);
    int i;
    Object localObject;
    if (c == '%')
    {
      i = j - 1;
      localObject = h.bd.aBA;
    }
    for (;;)
    {
      try
      {
        localObject = new h.p(k(paramString, i), (h.bd)localObject);
        AppMethodBeat.o(203399);
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = new k("Invalid length value: ".concat(String.valueOf(paramString)), localNumberFormatException);
        AppMethodBeat.o(203399);
        throw paramString;
      }
      localObject = localbd;
      i = j;
      if (j <= 2) {
        continue;
      }
      localObject = localbd;
      i = j;
      if (!Character.isLetter(c)) {
        continue;
      }
      localObject = localbd;
      i = j;
      if (!Character.isLetter(paramString.charAt(j - 2))) {
        continue;
      }
      i = j - 2;
      localObject = paramString.substring(i);
      try
      {
        localObject = h.bd.valueOf(((String)localObject).toLowerCase(Locale.US));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        paramString = new k("Invalid length unit specifier: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(203399);
        throw paramString;
      }
    }
  }
  
  private static List<h.p> ah(String paramString)
  {
    AppMethodBeat.i(203401);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid length list (empty string)");
      AppMethodBeat.o(203401);
      throw paramString;
    }
    ArrayList localArrayList = new ArrayList(1);
    h localh = new h(paramString);
    localh.oR();
    while (!localh.empty())
    {
      float f = localh.oT();
      if (Float.isNaN(f))
      {
        paramString = new k("Invalid length list value: " + localh.pc());
        AppMethodBeat.o(203401);
        throw paramString;
      }
      h.bd localbd = localh.pd();
      paramString = localbd;
      if (localbd == null) {
        paramString = h.bd.aBs;
      }
      localArrayList.add(new h.p(f, paramString));
      localh.oS();
    }
    AppMethodBeat.o(203401);
    return localArrayList;
  }
  
  private static float ai(String paramString)
  {
    AppMethodBeat.i(203402);
    int i = paramString.length();
    if (i == 0)
    {
      paramString = new k("Invalid float value (empty string)");
      AppMethodBeat.o(203402);
      throw paramString;
    }
    float f = k(paramString, i);
    AppMethodBeat.o(203402);
    return f;
  }
  
  private static Float aj(String paramString)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(203408);
    try
    {
      float f2 = ai(paramString);
      if (f2 < 0.0F) {}
      for (;;)
      {
        AppMethodBeat.o(203408);
        return Float.valueOf(f1);
        if (f2 > 1.0F) {
          f1 = 1.0F;
        } else {
          f1 = f2;
        }
      }
      return null;
    }
    catch (k paramString)
    {
      AppMethodBeat.o(203408);
    }
  }
  
  private static h.b ak(String paramString)
  {
    AppMethodBeat.i(203412);
    paramString = new h(paramString);
    paramString.oR();
    float f1 = paramString.oT();
    paramString.oS();
    float f2 = paramString.oT();
    paramString.oS();
    float f3 = paramString.oT();
    paramString.oS();
    float f4 = paramString.oT();
    if ((Float.isNaN(f1)) || (Float.isNaN(f2)) || (Float.isNaN(f3)) || (Float.isNaN(f4)))
    {
      paramString = new k("Invalid viewBox definition - should have four numbers");
      AppMethodBeat.o(203412);
      throw paramString;
    }
    if (f3 < 0.0F)
    {
      paramString = new k("Invalid viewBox. width cannot be negative");
      AppMethodBeat.o(203412);
      throw paramString;
    }
    if (f4 < 0.0F)
    {
      paramString = new k("Invalid viewBox. height cannot be negative");
      AppMethodBeat.o(203412);
      throw paramString;
    }
    paramString = new h.b(f1, f2, f3, f4);
    AppMethodBeat.o(203412);
    return paramString;
  }
  
  private static f al(String paramString)
  {
    AppMethodBeat.i(203418);
    h localh = new h(paramString);
    localh.oR();
    Object localObject2 = localh.a(' ', false);
    Object localObject1 = localObject2;
    if ("defer".equals(localObject2))
    {
      localh.oR();
      localObject1 = localh.a(' ', false);
    }
    localObject2 = a.aK((String)localObject1);
    localObject1 = null;
    localh.oR();
    if (!localh.empty())
    {
      localObject1 = localh.a(' ', false);
      int i = -1;
      switch (((String)localObject1).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramString = new k("Invalid preserveAspectRatio definition: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(203418);
          throw paramString;
          if (((String)localObject1).equals("meet"))
          {
            i = 0;
            continue;
            if (((String)localObject1).equals("slice")) {
              i = 1;
            }
          }
          break;
        }
      }
    }
    for (localObject1 = f.b.ayo;; localObject1 = f.b.ayp)
    {
      paramString = new f((f.a)localObject2, (f.b)localObject1);
      AppMethodBeat.o(203418);
      return paramString;
    }
  }
  
  private static h.ao am(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(203419);
    if (paramString.startsWith("url("))
    {
      int i = paramString.indexOf(")");
      if (i != -1)
      {
        String str1 = paramString.substring(4, i).trim();
        String str2 = paramString.substring(i + 1).trim();
        paramString = localObject;
        if (str2.length() > 0) {
          paramString = an(str2);
        }
        paramString = new h.u(str1, paramString);
        AppMethodBeat.o(203419);
        return paramString;
      }
      paramString = new h.u(paramString.substring(4).trim(), null);
      AppMethodBeat.o(203419);
      return paramString;
    }
    paramString = an(paramString);
    AppMethodBeat.o(203419);
    return paramString;
  }
  
  private static h.ao an(String paramString)
  {
    AppMethodBeat.i(203422);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      }
      try
      {
        paramString = ao(paramString);
        AppMethodBeat.o(203422);
        return paramString;
      }
      catch (k paramString)
      {
        AppMethodBeat.o(203422);
      }
      if (paramString.equals("none"))
      {
        i = 0;
        continue;
        if (paramString.equals("currentColor")) {
          i = 1;
        }
      }
    }
    paramString = h.f.ayO;
    AppMethodBeat.o(203422);
    return paramString;
    paramString = h.g.op();
    AppMethodBeat.o(203422);
    return paramString;
    return null;
  }
  
  private static h.f ao(String paramString)
  {
    AppMethodBeat.i(203429);
    int i;
    if (paramString.charAt(0) == '#')
    {
      localObject = d.j(paramString, paramString.length());
      if (localObject == null)
      {
        paramString = new k("Bad hex colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(203429);
        throw paramString;
      }
      int k;
      int j;
      switch (((d)localObject).pos)
      {
      case 6: 
      case 8: 
      default: 
        paramString = new k("Bad hex colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(203429);
        throw paramString;
      case 4: 
        k = (int)((d)localObject).value;
        i = k & 0xF00;
        j = k & 0xF0;
        k &= 0xF;
        paramString = new h.f(i << 8 | i << 12 | 0xFF000000 | j << 8 | j << 4 | k << 4 | k);
        AppMethodBeat.o(203429);
        return paramString;
      case 5: 
        int m = (int)((d)localObject).value;
        i = 0xF000 & m;
        j = m & 0xF00;
        k = m & 0xF0;
        m &= 0xF;
        paramString = new h.f(i << 4 | m << 24 | m << 28 | i << 8 | j << 4 | j | k | k >> 4);
        AppMethodBeat.o(203429);
        return paramString;
      case 7: 
        paramString = new h.f((int)((d)localObject).value | 0xFF000000);
        AppMethodBeat.o(203429);
        return paramString;
      }
      i = (int)((d)localObject).value;
      paramString = new h.f((int)((d)localObject).value >>> 8 | i << 24);
      AppMethodBeat.o(203429);
      return paramString;
    }
    Object localObject = paramString.toLowerCase(Locale.US);
    boolean bool = ((String)localObject).startsWith("rgba(");
    float f2;
    float f1;
    float f3;
    if ((bool) || (((String)localObject).startsWith("rgb("))) {
      if (bool)
      {
        i = 5;
        localObject = new h(paramString.substring(i));
        ((h)localObject).oR();
        f2 = ((h)localObject).oT();
        f1 = f2;
        if (!Float.isNaN(f2))
        {
          f1 = f2;
          if (((h)localObject).b('%')) {
            f1 = f2 * 256.0F / 100.0F;
          }
        }
        f3 = ((h)localObject).G(f1);
        f2 = f3;
        if (!Float.isNaN(f3))
        {
          f2 = f3;
          if (((h)localObject).b('%')) {
            f2 = f3 * 256.0F / 100.0F;
          }
        }
        f3 = ((h)localObject).G(f2);
        if ((Float.isNaN(f3)) || (!((h)localObject).b('%'))) {
          break label1041;
        }
        f3 = f3 * 256.0F / 100.0F;
      }
    }
    label1041:
    for (;;)
    {
      float f4;
      if (bool)
      {
        f4 = ((h)localObject).G(f3);
        ((h)localObject).oR();
        if ((Float.isNaN(f4)) || (!((h)localObject).b(')')))
        {
          paramString = new k("Bad rgba() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(203429);
          throw paramString;
          i = 4;
          break;
        }
        i = F(f4 * 256.0F);
        paramString = new h.f(F(f1) << 16 | i << 24 | F(f2) << 8 | F(f3));
        AppMethodBeat.o(203429);
        return paramString;
      }
      ((h)localObject).oR();
      if ((Float.isNaN(f3)) || (!((h)localObject).b(')')))
      {
        paramString = new k("Bad rgb() colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(203429);
        throw paramString;
      }
      paramString = new h.f(F(f1) << 16 | 0xFF000000 | F(f2) << 8 | F(f3));
      AppMethodBeat.o(203429);
      return paramString;
      bool = ((String)localObject).startsWith("hsla(");
      if ((bool) || (((String)localObject).startsWith("hsl(")))
      {
        if (bool) {}
        for (i = 5;; i = 4)
        {
          localObject = new h(paramString.substring(i));
          ((h)localObject).oR();
          f1 = ((h)localObject).oT();
          f2 = ((h)localObject).G(f1);
          if (!Float.isNaN(f2)) {
            ((h)localObject).b('%');
          }
          f3 = ((h)localObject).G(f2);
          if (!Float.isNaN(f3)) {
            ((h)localObject).b('%');
          }
          if (!bool) {
            break label953;
          }
          f4 = ((h)localObject).G(f3);
          ((h)localObject).oR();
          if ((!Float.isNaN(f4)) && (((h)localObject).b(')'))) {
            break;
          }
          paramString = new k("Bad hsla() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(203429);
          throw paramString;
        }
        paramString = new h.f(F(f4 * 256.0F) << 24 | f(f1, f2, f3));
        AppMethodBeat.o(203429);
        return paramString;
        label953:
        ((h)localObject).oR();
        if ((Float.isNaN(f3)) || (!((h)localObject).b(')')))
        {
          paramString = new k("Bad hsl() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(203429);
          throw paramString;
        }
        paramString = new h.f(f(f1, f2, f3) | 0xFF000000);
        AppMethodBeat.o(203429);
        return paramString;
      }
      paramString = ap((String)localObject);
      AppMethodBeat.o(203429);
      return paramString;
    }
  }
  
  private static h.f ap(String paramString)
  {
    AppMethodBeat.i(203442);
    Integer localInteger = l.b.aL(paramString);
    if (localInteger == null)
    {
      paramString = new k("Invalid colour keyword: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(203442);
      throw paramString;
    }
    paramString = new h.f(localInteger.intValue());
    AppMethodBeat.o(203442);
    return paramString;
  }
  
  private static List<String> aq(String paramString)
  {
    AppMethodBeat.i(203447);
    Object localObject1 = null;
    h localh = new h(paramString);
    paramString = (String)localObject1;
    do
    {
      localObject1 = localh.pf();
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localh.a(',', true);
      }
      localObject1 = paramString;
      if (localObject2 == null) {
        break;
      }
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = new ArrayList();
      }
      ((List)localObject1).add(localObject2);
      localh.oS();
      paramString = (String)localObject1;
    } while (!localh.empty());
    AppMethodBeat.o(203447);
    return localObject1;
  }
  
  private static h.p ar(String paramString)
  {
    AppMethodBeat.i(203449);
    try
    {
      h.p localp2 = c.aM(paramString);
      h.p localp1 = localp2;
      if (localp2 == null) {
        localp1 = ag(paramString);
      }
      AppMethodBeat.o(203449);
      return localp1;
    }
    catch (k paramString)
    {
      AppMethodBeat.o(203449);
    }
    return null;
  }
  
  private static h.ae.b as(String paramString)
  {
    AppMethodBeat.i(203450);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(203450);
        return null;
        if (paramString.equals("italic"))
        {
          i = 0;
          continue;
          if (paramString.equals("normal"))
          {
            i = 1;
            continue;
            if (paramString.equals("oblique")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramString = h.ae.b.aAu;
    AppMethodBeat.o(203450);
    return paramString;
    paramString = h.ae.b.aAt;
    AppMethodBeat.o(203450);
    return paramString;
    paramString = h.ae.b.aAv;
    AppMethodBeat.o(203450);
    return paramString;
  }
  
  private static h.ae.g at(String paramString)
  {
    AppMethodBeat.i(203458);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(203458);
        return null;
        if (paramString.equals("none"))
        {
          i = 0;
          continue;
          if (paramString.equals("underline"))
          {
            i = 1;
            continue;
            if (paramString.equals("overline"))
            {
              i = 2;
              continue;
              if (paramString.equals("line-through"))
              {
                i = 3;
                continue;
                if (paramString.equals("blink")) {
                  i = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    paramString = h.ae.g.aAN;
    AppMethodBeat.o(203458);
    return paramString;
    paramString = h.ae.g.aAO;
    AppMethodBeat.o(203458);
    return paramString;
    paramString = h.ae.g.aAP;
    AppMethodBeat.o(203458);
    return paramString;
    paramString = h.ae.g.aAQ;
    AppMethodBeat.o(203458);
    return paramString;
    paramString = h.ae.g.aAR;
    AppMethodBeat.o(203458);
    return paramString;
  }
  
  private static h.ae.h au(String paramString)
  {
    AppMethodBeat.i(203464);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(203464);
        return null;
        if (paramString.equals("ltr"))
        {
          i = 0;
          continue;
          if (paramString.equals("rtl")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramString = h.ae.h.aAT;
    AppMethodBeat.o(203464);
    return paramString;
    paramString = h.ae.h.aAU;
    AppMethodBeat.o(203464);
    return paramString;
  }
  
  private static h.ae.a av(String paramString)
  {
    AppMethodBeat.i(203469);
    if ("nonzero".equals(paramString))
    {
      paramString = h.ae.a.aAq;
      AppMethodBeat.o(203469);
      return paramString;
    }
    if ("evenodd".equals(paramString))
    {
      paramString = h.ae.a.aAr;
      AppMethodBeat.o(203469);
      return paramString;
    }
    AppMethodBeat.o(203469);
    return null;
  }
  
  private static h.ae.c aw(String paramString)
  {
    AppMethodBeat.i(203472);
    if ("butt".equals(paramString))
    {
      paramString = h.ae.c.aAx;
      AppMethodBeat.o(203472);
      return paramString;
    }
    if ("round".equals(paramString))
    {
      paramString = h.ae.c.aAy;
      AppMethodBeat.o(203472);
      return paramString;
    }
    if ("square".equals(paramString))
    {
      paramString = h.ae.c.aAz;
      AppMethodBeat.o(203472);
      return paramString;
    }
    AppMethodBeat.o(203472);
    return null;
  }
  
  private static h.ae.d ax(String paramString)
  {
    AppMethodBeat.i(203476);
    if ("miter".equals(paramString))
    {
      paramString = h.ae.d.aAB;
      AppMethodBeat.o(203476);
      return paramString;
    }
    if ("round".equals(paramString))
    {
      paramString = h.ae.d.aAC;
      AppMethodBeat.o(203476);
      return paramString;
    }
    if ("bevel".equals(paramString))
    {
      paramString = h.ae.d.aAD;
      AppMethodBeat.o(203476);
      return paramString;
    }
    AppMethodBeat.o(203476);
    return null;
  }
  
  private static h.p[] ay(String paramString)
  {
    AppMethodBeat.i(203480);
    paramString = new h(paramString);
    paramString.oR();
    if (paramString.empty())
    {
      AppMethodBeat.o(203480);
      return null;
    }
    h.p localp = paramString.oW();
    if (localp == null)
    {
      AppMethodBeat.o(203480);
      return null;
    }
    if (localp.os())
    {
      AppMethodBeat.o(203480);
      return null;
    }
    float f = localp.value;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localp);
    while (!paramString.empty())
    {
      paramString.oS();
      localp = paramString.oW();
      if (localp == null)
      {
        AppMethodBeat.o(203480);
        return null;
      }
      if (localp.os())
      {
        AppMethodBeat.o(203480);
        return null;
      }
      localArrayList.add(localp);
      f += localp.value;
    }
    if (f == 0.0F)
    {
      AppMethodBeat.o(203480);
      return null;
    }
    paramString = (h.p[])localArrayList.toArray(new h.p[localArrayList.size()]);
    AppMethodBeat.o(203480);
    return paramString;
  }
  
  private static h.ae.f az(String paramString)
  {
    AppMethodBeat.i(203484);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(203484);
        return null;
        if (paramString.equals("start"))
        {
          i = 0;
          continue;
          if (paramString.equals("middle"))
          {
            i = 1;
            continue;
            if (paramString.equals("end")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramString = h.ae.f.aAJ;
    AppMethodBeat.o(203484);
    return paramString;
    paramString = h.ae.f.aAK;
    AppMethodBeat.o(203484);
    return paramString;
    paramString = h.ae.f.aAL;
    AppMethodBeat.o(203484);
    return paramString;
  }
  
  private static h.p b(h paramh)
  {
    AppMethodBeat.i(203491);
    if (paramh.aP("auto"))
    {
      paramh = new h.p(0.0F);
      AppMethodBeat.o(203491);
      return paramh;
    }
    paramh = paramh.oW();
    AppMethodBeat.o(203491);
    return paramh;
  }
  
  private static void b(h.al paramal, Attributes paramAttributes)
  {
    AppMethodBeat.i(203336);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      if (str.length() != 0) {
        switch (1.aCt[f.aN(paramAttributes.getLocalName(i)).ordinal()])
        {
        default: 
          if (paramal.aBg == null) {
            paramal.aBg = new h.ae();
          }
          a(paramal.aBg, paramAttributes.getLocalName(i), paramAttributes.getValue(i).trim());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramal, str);
        continue;
        paramal.aBh = b.X(str);
      }
    }
    AppMethodBeat.o(203336);
  }
  
  static void b(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(203156);
    if ((paramString.equals("xml-stylesheet")) && (h.ol() != null))
    {
      if (((String)paramMap.get("type") != null) && (!"text/css".equals(paramMap.get("type"))))
      {
        AppMethodBeat.o(203156);
        return;
      }
      if (((String)paramMap.get("alternate") != null) && (!"no".equals(paramMap.get("alternate"))))
      {
        AppMethodBeat.o(203156);
        return;
      }
      if ((String)paramMap.get("href") != null)
      {
        h.ol();
        AppMethodBeat.o(203156);
        return;
      }
    }
    AppMethodBeat.o(203156);
  }
  
  private void b(Attributes paramAttributes)
  {
    AppMethodBeat.i(203162);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203162);
      throw paramAttributes;
    }
    h.m localm = new h.m();
    localm.aBi = this.aCj;
    localm.aBj = this.aCk;
    a(localm, paramAttributes);
    b(localm, paramAttributes);
    a(localm, paramAttributes);
    a(localm, paramAttributes);
    this.aCk.a(localm);
    this.aCk = localm;
    AppMethodBeat.o(203162);
  }
  
  private void c(Attributes paramAttributes)
  {
    AppMethodBeat.i(203163);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203163);
      throw paramAttributes;
    }
    h.h localh = new h.h();
    localh.aBi = this.aCj;
    localh.aBj = this.aCk;
    a(localh, paramAttributes);
    b(localh, paramAttributes);
    a(localh, paramAttributes);
    this.aCk.a(localh);
    this.aCk = localh;
    AppMethodBeat.o(203163);
  }
  
  private void d(InputStream paramInputStream)
  {
    AppMethodBeat.i(203134);
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      try
      {
        localXmlPullParser = Xml.newPullParser();
        locali = new l.i(this, localXmlPullParser);
        localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
        localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        localXmlPullParser.setInput(paramInputStream, null);
        i = localXmlPullParser.getEventType();
      }
      catch (XmlPullParserException paramInputStream)
      {
        l.i locali;
        paramInputStream = new k("XML parser problem", paramInputStream);
        AppMethodBeat.o(203134);
        throw paramInputStream;
        localObject = localXmlPullParser.getName();
        paramInputStream = (InputStream)localObject;
        if (localXmlPullParser.getPrefix() == null) {
          continue;
        }
        paramInputStream = localXmlPullParser.getPrefix() + ':' + (String)localObject;
        startElement(localXmlPullParser.getNamespace(), localXmlPullParser.getName(), paramInputStream, locali);
        continue;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream = new k("Stream error", paramInputStream);
        AppMethodBeat.o(203134);
        throw paramInputStream;
      }
      int i = localXmlPullParser.nextToken();
      break label466;
      startDocument();
      continue;
      localObject = localXmlPullParser.getName();
      paramInputStream = (InputStream)localObject;
      if (localXmlPullParser.getPrefix() != null) {
        paramInputStream = localXmlPullParser.getPrefix() + ':' + (String)localObject;
      }
      endElement(localXmlPullParser.getNamespace(), localXmlPullParser.getName(), paramInputStream);
      continue;
      paramInputStream = new int[2];
      localObject = localXmlPullParser.getTextCharacters(paramInputStream);
      i = paramInputStream[0];
      j = paramInputStream[1];
      if (!this.aCl) {
        if (this.aCn)
        {
          if (this.aCp == null) {
            this.aCp = new StringBuilder(j);
          }
          this.aCp.append((char[])localObject, i, j);
        }
        else if (this.aCq)
        {
          if (this.aCr == null) {
            this.aCr = new StringBuilder(j);
          }
          this.aCr.append((char[])localObject, i, j);
        }
        else if ((this.aCk instanceof h.ay))
        {
          ad(new String((char[])localObject, i, j));
          continue;
          text(localXmlPullParser.getText());
          continue;
          paramInputStream = new h(localXmlPullParser.getText());
          b(paramInputStream.oZ(), a(paramInputStream));
          label466:
          while (i == 1)
          {
            Object localObject;
            int j;
            AppMethodBeat.o(203134);
            return;
          }
          switch (i)
          {
          }
        }
      }
    }
  }
  
  private void d(Attributes paramAttributes)
  {
    AppMethodBeat.i(203165);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203165);
      throw paramAttributes;
    }
    h.a locala = new h.a();
    locala.aBi = this.aCj;
    locala.aBj = this.aCk;
    a(locala, paramAttributes);
    b(locala, paramAttributes);
    a(locala, paramAttributes);
    a(locala, paramAttributes);
    a(locala, paramAttributes);
    this.aCk.a(locala);
    this.aCk = locala;
    AppMethodBeat.o(203165);
  }
  
  private void e(Attributes paramAttributes)
  {
    AppMethodBeat.i(203169);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203169);
      throw paramAttributes;
    }
    h.be localbe = new h.be();
    localbe.aBi = this.aCj;
    localbe.aBj = this.aCk;
    a(localbe, paramAttributes);
    b(localbe, paramAttributes);
    a(localbe, paramAttributes);
    a(localbe, paramAttributes);
    a(localbe, paramAttributes);
    this.aCk.a(localbe);
    this.aCk = localbe;
    AppMethodBeat.o(203169);
  }
  
  private static int f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(203435);
    float f1;
    if (paramFloat1 >= 0.0F)
    {
      paramFloat1 %= 360.0F;
      f1 = paramFloat1 / 60.0F;
      paramFloat2 /= 100.0F;
      paramFloat3 /= 100.0F;
      if (paramFloat2 >= 0.0F) {
        break label165;
      }
      paramFloat1 = 0.0F;
      label44:
      if (paramFloat3 >= 0.0F) {
        break label178;
      }
      paramFloat2 = 0.0F;
      label52:
      if (paramFloat2 > 0.5F) {
        break label191;
      }
    }
    label165:
    label178:
    label191:
    for (paramFloat1 = (paramFloat1 + 1.0F) * paramFloat2;; paramFloat1 = paramFloat2 + paramFloat1 - paramFloat2 * paramFloat1)
    {
      float f2 = paramFloat2 * 2.0F - paramFloat1;
      paramFloat2 = g(f2, paramFloat1, f1 + 2.0F);
      paramFloat3 = g(f2, paramFloat1, f1);
      paramFloat1 = g(f2, paramFloat1, f1 - 2.0F);
      int i = F(paramFloat2 * 256.0F);
      int j = F(paramFloat3 * 256.0F);
      int k = F(paramFloat1 * 256.0F);
      AppMethodBeat.o(203435);
      return k | i << 16 | j << 8;
      paramFloat1 = paramFloat1 % 360.0F + 360.0F;
      break;
      paramFloat1 = paramFloat2;
      if (paramFloat2 <= 1.0F) {
        break label44;
      }
      paramFloat1 = 1.0F;
      break label44;
      paramFloat2 = paramFloat3;
      if (paramFloat3 <= 1.0F) {
        break label52;
      }
      paramFloat2 = 1.0F;
      break label52;
    }
  }
  
  private void f(Attributes paramAttributes)
  {
    AppMethodBeat.i(203173);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203173);
      throw paramAttributes;
    }
    h.o localo = new h.o();
    localo.aBi = this.aCj;
    localo.aBj = this.aCk;
    a(localo, paramAttributes);
    b(localo, paramAttributes);
    a(localo, paramAttributes);
    a(localo, paramAttributes);
    a(localo, paramAttributes);
    this.aCk.a(localo);
    this.aCk = localo;
    AppMethodBeat.o(203173);
  }
  
  private static float g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 < 0.0F) {
      paramFloat3 += 6.0F;
    }
    for (;;)
    {
      float f = paramFloat3;
      if (paramFloat3 >= 6.0F) {
        f = paramFloat3 - 6.0F;
      }
      if (f < 1.0F) {
        paramFloat3 = f * (paramFloat2 - paramFloat1) + paramFloat1;
      }
      do
      {
        return paramFloat3;
        paramFloat3 = paramFloat2;
      } while (f < 3.0F);
      if (f < 4.0F) {
        return (4.0F - f) * (paramFloat2 - paramFloat1) + paramFloat1;
      }
      return paramFloat1;
    }
  }
  
  private void g(Attributes paramAttributes)
  {
    AppMethodBeat.i(203179);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203179);
      throw paramAttributes;
    }
    h.v localv = new h.v();
    localv.aBi = this.aCj;
    localv.aBj = this.aCk;
    a(localv, paramAttributes);
    b(localv, paramAttributes);
    a(localv, paramAttributes);
    a(localv, paramAttributes);
    a(localv, paramAttributes);
    this.aCk.a(localv);
    AppMethodBeat.o(203179);
  }
  
  private void h(Attributes paramAttributes)
  {
    AppMethodBeat.i(203182);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203182);
      throw paramAttributes;
    }
    h.ab localab = new h.ab();
    localab.aBi = this.aCj;
    localab.aBj = this.aCk;
    a(localab, paramAttributes);
    b(localab, paramAttributes);
    a(localab, paramAttributes);
    a(localab, paramAttributes);
    a(localab, paramAttributes);
    this.aCk.a(localab);
    AppMethodBeat.o(203182);
  }
  
  private void i(Attributes paramAttributes)
  {
    AppMethodBeat.i(203185);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203185);
      throw paramAttributes;
    }
    h.d locald = new h.d();
    locald.aBi = this.aCj;
    locald.aBj = this.aCk;
    a(locald, paramAttributes);
    b(locald, paramAttributes);
    a(locald, paramAttributes);
    a(locald, paramAttributes);
    a(locald, paramAttributes);
    this.aCk.a(locald);
    AppMethodBeat.o(203185);
  }
  
  private void j(Attributes paramAttributes)
  {
    AppMethodBeat.i(203190);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203190);
      throw paramAttributes;
    }
    h.i locali = new h.i();
    locali.aBi = this.aCj;
    locali.aBj = this.aCk;
    a(locali, paramAttributes);
    b(locali, paramAttributes);
    a(locali, paramAttributes);
    a(locali, paramAttributes);
    a(locali, paramAttributes);
    this.aCk.a(locali);
    AppMethodBeat.o(203190);
  }
  
  private static float k(String paramString, int paramInt)
  {
    AppMethodBeat.i(203403);
    float f = new e().f(paramString, 0, paramInt);
    if (!Float.isNaN(f))
    {
      AppMethodBeat.o(203403);
      return f;
    }
    paramString = new k("Invalid float value: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(203403);
    throw paramString;
  }
  
  private void k(Attributes paramAttributes)
  {
    AppMethodBeat.i(203192);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203192);
      throw paramAttributes;
    }
    h.q localq = new h.q();
    localq.aBi = this.aCj;
    localq.aBj = this.aCk;
    a(localq, paramAttributes);
    b(localq, paramAttributes);
    a(localq, paramAttributes);
    a(localq, paramAttributes);
    a(localq, paramAttributes);
    this.aCk.a(localq);
    AppMethodBeat.o(203192);
  }
  
  private void l(Attributes paramAttributes)
  {
    AppMethodBeat.i(203199);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203199);
      throw paramAttributes;
    }
    h.z localz = new h.z();
    localz.aBi = this.aCj;
    localz.aBj = this.aCk;
    a(localz, paramAttributes);
    b(localz, paramAttributes);
    a(localz, paramAttributes);
    a(localz, paramAttributes);
    a(localz, paramAttributes, "polyline");
    this.aCk.a(localz);
    AppMethodBeat.o(203199);
  }
  
  private void m(Attributes paramAttributes)
  {
    AppMethodBeat.i(203211);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203211);
      throw paramAttributes;
    }
    h.aa localaa = new h.aa();
    localaa.aBi = this.aCj;
    localaa.aBj = this.aCk;
    a(localaa, paramAttributes);
    b(localaa, paramAttributes);
    a(localaa, paramAttributes);
    a(localaa, paramAttributes);
    a(localaa, paramAttributes, "polygon");
    this.aCk.a(localaa);
    AppMethodBeat.o(203211);
  }
  
  private void n(Attributes paramAttributes)
  {
    AppMethodBeat.i(203212);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203212);
      throw paramAttributes;
    }
    h.aw localaw = new h.aw();
    localaw.aBi = this.aCj;
    localaw.aBj = this.aCk;
    a(localaw, paramAttributes);
    b(localaw, paramAttributes);
    a(localaw, paramAttributes);
    a(localaw, paramAttributes);
    a(localaw, paramAttributes);
    this.aCk.a(localaw);
    this.aCk = localaw;
    AppMethodBeat.o(203212);
  }
  
  private void o(Attributes paramAttributes)
  {
    AppMethodBeat.i(203222);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203222);
      throw paramAttributes;
    }
    if (!(this.aCk instanceof h.ay))
    {
      paramAttributes = new k("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
      AppMethodBeat.o(203222);
      throw paramAttributes;
    }
    h.av localav = new h.av();
    localav.aBi = this.aCj;
    localav.aBj = this.aCk;
    a(localav, paramAttributes);
    b(localav, paramAttributes);
    a(localav, paramAttributes);
    a(localav, paramAttributes);
    this.aCk.a(localav);
    this.aCk = localav;
    if ((localav.aBj instanceof h.bb))
    {
      localav.aBm = ((h.bb)localav.aBj);
      AppMethodBeat.o(203222);
      return;
    }
    localav.aBm = ((h.ax)localav.aBj).oz();
    AppMethodBeat.o(203222);
  }
  
  private void p(Attributes paramAttributes)
  {
    AppMethodBeat.i(203224);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203224);
      throw paramAttributes;
    }
    if (!(this.aCk instanceof h.ay))
    {
      paramAttributes = new k("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
      AppMethodBeat.o(203224);
      throw paramAttributes;
    }
    h.au localau = new h.au();
    localau.aBi = this.aCj;
    localau.aBj = this.aCk;
    a(localau, paramAttributes);
    b(localau, paramAttributes);
    a(localau, paramAttributes);
    a(localau, paramAttributes);
    this.aCk.a(localau);
    if ((localau.aBj instanceof h.bb))
    {
      localau.aBm = ((h.bb)localau.aBj);
      AppMethodBeat.o(203224);
      return;
    }
    localau.aBm = ((h.ax)localau.aBj).oz();
    AppMethodBeat.o(203224);
  }
  
  private void q(Attributes paramAttributes)
  {
    AppMethodBeat.i(203227);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203227);
      throw paramAttributes;
    }
    h.as localas = new h.as();
    localas.aBi = this.aCj;
    localas.aBj = this.aCk;
    a(localas, paramAttributes);
    b(localas, paramAttributes);
    a(localas, paramAttributes);
    a(localas, paramAttributes);
    this.aCk.a(localas);
    this.aCk = localas;
    AppMethodBeat.o(203227);
  }
  
  private void r(Attributes paramAttributes)
  {
    AppMethodBeat.i(203232);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203232);
      throw paramAttributes;
    }
    h.at localat = new h.at();
    localat.aBi = this.aCj;
    localat.aBj = this.aCk;
    a(localat, paramAttributes);
    b(localat, paramAttributes);
    a(localat, paramAttributes);
    a(localat, paramAttributes);
    this.aCk.a(localat);
    this.aCk = localat;
    AppMethodBeat.o(203232);
  }
  
  private void s(Attributes paramAttributes)
  {
    AppMethodBeat.i(203235);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203235);
      throw paramAttributes;
    }
    h.r localr = new h.r();
    localr.aBi = this.aCj;
    localr.aBj = this.aCk;
    a(localr, paramAttributes);
    b(localr, paramAttributes);
    a(localr, paramAttributes);
    a(localr, paramAttributes);
    a(localr, paramAttributes);
    this.aCk.a(localr);
    this.aCk = localr;
    AppMethodBeat.o(203235);
  }
  
  private void t(Attributes paramAttributes)
  {
    AppMethodBeat.i(203237);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203237);
      throw paramAttributes;
    }
    h.am localam = new h.am();
    localam.aBi = this.aCj;
    localam.aBj = this.aCk;
    a(localam, paramAttributes);
    b(localam, paramAttributes);
    a(localam, paramAttributes);
    a(localam, paramAttributes);
    this.aCk.a(localam);
    this.aCk = localam;
    AppMethodBeat.o(203237);
  }
  
  private void u(Attributes paramAttributes)
  {
    AppMethodBeat.i(203244);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203244);
      throw paramAttributes;
    }
    h.aq localaq = new h.aq();
    localaq.aBi = this.aCj;
    localaq.aBj = this.aCk;
    a(localaq, paramAttributes);
    b(localaq, paramAttributes);
    a(localaq, paramAttributes);
    a(localaq, paramAttributes);
    this.aCk.a(localaq);
    this.aCk = localaq;
    AppMethodBeat.o(203244);
  }
  
  private void v(Attributes paramAttributes)
  {
    AppMethodBeat.i(203251);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203251);
      throw paramAttributes;
    }
    if (!(this.aCk instanceof h.j))
    {
      paramAttributes = new k("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
      AppMethodBeat.o(203251);
      throw paramAttributes;
    }
    h.ad localad = new h.ad();
    localad.aBi = this.aCj;
    localad.aBj = this.aCk;
    a(localad, paramAttributes);
    b(localad, paramAttributes);
    a(localad, paramAttributes);
    this.aCk.a(localad);
    this.aCk = localad;
    AppMethodBeat.o(203251);
  }
  
  private void w(Attributes paramAttributes)
  {
    AppMethodBeat.i(203264);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203264);
      throw paramAttributes;
    }
    h.ac localac = new h.ac();
    localac.aBi = this.aCj;
    localac.aBj = this.aCk;
    a(localac, paramAttributes);
    b(localac, paramAttributes);
    this.aCk.a(localac);
    this.aCk = localac;
    AppMethodBeat.o(203264);
  }
  
  private void x(Attributes paramAttributes)
  {
    AppMethodBeat.i(203267);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203267);
      throw paramAttributes;
    }
    h.e locale = new h.e();
    locale.aBi = this.aCj;
    locale.aBj = this.aCk;
    a(locale, paramAttributes);
    b(locale, paramAttributes);
    a(locale, paramAttributes);
    a(locale, paramAttributes);
    a(locale, paramAttributes);
    this.aCk.a(locale);
    this.aCk = locale;
    AppMethodBeat.o(203267);
  }
  
  private void y(Attributes paramAttributes)
  {
    AppMethodBeat.i(203278);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203278);
      throw paramAttributes;
    }
    h.az localaz = new h.az();
    localaz.aBi = this.aCj;
    localaz.aBj = this.aCk;
    a(localaz, paramAttributes);
    b(localaz, paramAttributes);
    a(localaz, paramAttributes);
    a(localaz, paramAttributes);
    this.aCk.a(localaz);
    this.aCk = localaz;
    if ((localaz.aBj instanceof h.bb))
    {
      localaz.aBm = ((h.bb)localaz.aBj);
      AppMethodBeat.o(203278);
      return;
    }
    localaz.aBm = ((h.ax)localaz.aBj).oz();
    AppMethodBeat.o(203278);
  }
  
  private void z(Attributes paramAttributes)
  {
    AppMethodBeat.i(203286);
    if (this.aCk == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(203286);
      throw paramAttributes;
    }
    h.y localy = new h.y();
    localy.aBi = this.aCj;
    localy.aBj = this.aCk;
    a(localy, paramAttributes);
    b(localy, paramAttributes);
    a(localy, paramAttributes);
    a(localy, paramAttributes);
    a(localy, paramAttributes);
    this.aCk.a(localy);
    this.aCk = localy;
    AppMethodBeat.o(203286);
  }
  
  /* Error */
  final h a(InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 2014
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 2019	java/io/InputStream:markSupported	()Z
    //   10: ifne +381 -> 391
    //   13: new 2021	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 2023	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: iconst_3
    //   24: invokevirtual 2026	java/io/InputStream:mark	(I)V
    //   27: aload_1
    //   28: invokevirtual 2029	java/io/InputStream:read	()I
    //   31: istore_3
    //   32: aload_1
    //   33: invokevirtual 2029	java/io/InputStream:read	()I
    //   36: istore 4
    //   38: aload_1
    //   39: invokevirtual 2032	java/io/InputStream:reset	()V
    //   42: iload_3
    //   43: iload 4
    //   45: bipush 8
    //   47: ishl
    //   48: iadd
    //   49: ldc_w 2033
    //   52: if_icmpne +336 -> 388
    //   55: new 2021	java/io/BufferedInputStream
    //   58: dup
    //   59: new 2035	java/util/zip/GZIPInputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 2036	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: invokespecial 2023	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore 5
    //   72: aload 5
    //   74: astore_1
    //   75: iload_2
    //   76: ifeq +267 -> 343
    //   79: aload_1
    //   80: sipush 4096
    //   83: invokevirtual 2026	java/io/InputStream:mark	(I)V
    //   86: sipush 4096
    //   89: newarray byte
    //   91: astore 5
    //   93: new 137	java/lang/String
    //   96: dup
    //   97: aload 5
    //   99: iconst_0
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 2039	java/io/InputStream:read	([B)I
    //   106: invokespecial 2042	java/lang/String:<init>	([BII)V
    //   109: astore 5
    //   111: aload_1
    //   112: invokevirtual 2032	java/io/InputStream:reset	()V
    //   115: aload 5
    //   117: ldc_w 2044
    //   120: invokevirtual 1481	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   123: istore_3
    //   124: iload_3
    //   125: iflt +218 -> 343
    //   128: invokestatic 2050	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   131: astore 5
    //   133: aload 5
    //   135: ldc_w 2052
    //   138: iconst_0
    //   139: invokevirtual 2053	javax/xml/parsers/SAXParserFactory:setFeature	(Ljava/lang/String;Z)V
    //   142: aload 5
    //   144: ldc_w 2055
    //   147: iconst_0
    //   148: invokevirtual 2053	javax/xml/parsers/SAXParserFactory:setFeature	(Ljava/lang/String;Z)V
    //   151: aload 5
    //   153: invokevirtual 2059	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   156: invokevirtual 2065	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   159: astore 5
    //   161: new 18	com/a/a/l$e
    //   164: dup
    //   165: aload_0
    //   166: iconst_0
    //   167: invokespecial 2068	com/a/a/l$e:<init>	(Lcom/a/a/l;B)V
    //   170: astore 6
    //   172: aload 5
    //   174: aload 6
    //   176: invokeinterface 2074 2 0
    //   181: aload 5
    //   183: ldc_w 2076
    //   186: aload 6
    //   188: invokeinterface 2080 3 0
    //   193: aload 5
    //   195: new 2082	org/xml/sax/InputSource
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 2083	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   203: invokeinterface 2087 2 0
    //   208: aload_0
    //   209: getfield 51	com/a/a/l:aCj	Lcom/a/a/h;
    //   212: astore 5
    //   214: aload_1
    //   215: invokevirtual 2090	java/io/InputStream:close	()V
    //   218: ldc_w 2014
    //   221: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload 5
    //   226: areturn
    //   227: astore 5
    //   229: new 77	com/a/a/k
    //   232: dup
    //   233: ldc_w 1769
    //   236: aload 5
    //   238: invokespecial 1324	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   241: astore 5
    //   243: ldc_w 2014
    //   246: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload 5
    //   251: athrow
    //   252: astore 5
    //   254: aload_0
    //   255: aload_1
    //   256: invokespecial 2092	com/a/a/l:d	(Ljava/io/InputStream;)V
    //   259: aload_0
    //   260: getfield 51	com/a/a/l:aCj	Lcom/a/a/h;
    //   263: astore 5
    //   265: aload_1
    //   266: invokevirtual 2090	java/io/InputStream:close	()V
    //   269: ldc_w 2014
    //   272: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload 5
    //   277: areturn
    //   278: astore 5
    //   280: new 77	com/a/a/k
    //   283: dup
    //   284: ldc_w 2094
    //   287: aload 5
    //   289: invokespecial 1324	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   292: astore 5
    //   294: ldc_w 2014
    //   297: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: aload 5
    //   302: athrow
    //   303: astore 5
    //   305: aload_1
    //   306: invokevirtual 2090	java/io/InputStream:close	()V
    //   309: ldc_w 2014
    //   312: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload 5
    //   317: athrow
    //   318: astore 5
    //   320: new 77	com/a/a/k
    //   323: dup
    //   324: ldc_w 1784
    //   327: aload 5
    //   329: invokespecial 1324	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   332: astore 5
    //   334: ldc_w 2014
    //   337: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload 5
    //   342: athrow
    //   343: aload_0
    //   344: aload_1
    //   345: invokespecial 2092	com/a/a/l:d	(Ljava/io/InputStream;)V
    //   348: aload_0
    //   349: getfield 51	com/a/a/l:aCj	Lcom/a/a/h;
    //   352: astore 5
    //   354: aload_1
    //   355: invokevirtual 2090	java/io/InputStream:close	()V
    //   358: ldc_w 2014
    //   361: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aload 5
    //   366: areturn
    //   367: astore_1
    //   368: goto -150 -> 218
    //   371: astore_1
    //   372: goto -14 -> 358
    //   375: astore_1
    //   376: goto -107 -> 269
    //   379: astore_1
    //   380: goto -71 -> 309
    //   383: astore 5
    //   385: goto -310 -> 75
    //   388: goto -313 -> 75
    //   391: goto -369 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	l
    //   0	394	1	paramInputStream	InputStream
    //   0	394	2	paramBoolean	boolean
    //   31	94	3	i	int
    //   36	12	4	j	int
    //   70	155	5	localObject1	Object
    //   227	10	5	localParserConfigurationException	javax.xml.parsers.ParserConfigurationException
    //   241	9	5	localk1	k
    //   252	1	5	localIOException1	IOException
    //   263	13	5	localh	h
    //   278	10	5	localSAXException	org.xml.sax.SAXException
    //   292	9	5	localk2	k
    //   303	13	5	localObject2	Object
    //   318	10	5	localIOException2	IOException
    //   332	33	5	localObject3	Object
    //   383	1	5	localIOException3	IOException
    //   170	17	6	locale	e
    // Exception table:
    //   from	to	target	type
    //   128	208	227	javax/xml/parsers/ParserConfigurationException
    //   79	124	252	java/io/IOException
    //   208	214	252	java/io/IOException
    //   229	252	252	java/io/IOException
    //   280	303	252	java/io/IOException
    //   320	343	252	java/io/IOException
    //   343	354	252	java/io/IOException
    //   128	208	278	org/xml/sax/SAXException
    //   79	124	303	finally
    //   128	208	303	finally
    //   208	214	303	finally
    //   229	252	303	finally
    //   254	265	303	finally
    //   280	303	303	finally
    //   320	343	303	finally
    //   343	354	303	finally
    //   128	208	318	java/io/IOException
    //   214	218	367	java/io/IOException
    //   354	358	371	java/io/IOException
    //   265	269	375	java/io/IOException
    //   305	309	379	java/io/IOException
    //   22	42	383	java/io/IOException
    //   55	72	383	java/io/IOException
  }
  
  final void endElement(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(203153);
    if (this.aCl)
    {
      int i = this.aCm - 1;
      this.aCm = i;
      if (i == 0) {
        this.aCl = false;
      }
      AppMethodBeat.o(203153);
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1)))
    {
      AppMethodBeat.o(203153);
      return;
    }
    if (paramString2.length() > 0) {
      switch (1.aCs[g.aO(paramString2).ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(203153);
      return;
      paramString2 = paramString3;
      break;
      this.aCn = false;
      if (this.aCp != null)
      {
        if (this.aCo != g.aEO) {
          break label291;
        }
        this.aCj.title = this.aCp.toString();
      }
      for (;;)
      {
        this.aCp.setLength(0);
        AppMethodBeat.o(203153);
        return;
        label291:
        if (this.aCo == g.aEt) {
          this.aCj.desc = this.aCp.toString();
        }
      }
      if (this.aCr != null)
      {
        this.aCq = false;
        aJ(this.aCr.toString());
        this.aCr.setLength(0);
        AppMethodBeat.o(203153);
        return;
        if (this.aCk == null)
        {
          paramString1 = new k(String.format("Unbalanced end element </%s> found", new Object[] { paramString2 }));
          AppMethodBeat.o(203153);
          throw paramString1;
        }
        this.aCk = ((h.an)this.aCk).aBj;
      }
    }
  }
  
  final void startDocument()
  {
    AppMethodBeat.i(203135);
    this.aCj = new h();
    AppMethodBeat.o(203135);
  }
  
  final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    AppMethodBeat.i(203144);
    if (this.aCl)
    {
      this.aCm += 1;
      AppMethodBeat.o(203144);
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1)))
    {
      AppMethodBeat.o(203144);
      return;
    }
    if (paramString2.length() > 0) {}
    for (;;)
    {
      paramString1 = g.aO(paramString2);
      switch (1.aCs[paramString1.ordinal()])
      {
      default: 
        this.aCl = true;
        this.aCm = 1;
        AppMethodBeat.o(203144);
        return;
        paramString2 = paramString3;
      }
    }
    a(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    b(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    c(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    d(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    e(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    g(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    h(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    i(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    j(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    k(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    l(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    m(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    n(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    o(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    p(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    q(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    r(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    s(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    t(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    u(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    v(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    this.aCn = true;
    this.aCo = paramString1;
    AppMethodBeat.o(203144);
    return;
    x(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    y(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    z(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    f(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    A(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    B(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    C(paramAttributes);
    AppMethodBeat.o(203144);
    return;
    w(paramAttributes);
    AppMethodBeat.o(203144);
  }
  
  final void text(String paramString)
  {
    AppMethodBeat.i(203146);
    if (this.aCl)
    {
      AppMethodBeat.o(203146);
      return;
    }
    if (this.aCn)
    {
      if (this.aCp == null) {
        this.aCp = new StringBuilder(paramString.length());
      }
      this.aCp.append(paramString);
      AppMethodBeat.o(203146);
      return;
    }
    if (this.aCq)
    {
      if (this.aCr == null) {
        this.aCr = new StringBuilder(paramString.length());
      }
      this.aCr.append(paramString);
      AppMethodBeat.o(203146);
      return;
    }
    if ((this.aCk instanceof h.ay)) {
      ad(paramString);
    }
    AppMethodBeat.o(203146);
  }
  
  static final class a
  {
    private static final Map<String, f.a> aCu;
    
    static
    {
      AppMethodBeat.i(202829);
      HashMap localHashMap = new HashMap(10);
      aCu = localHashMap;
      localHashMap.put("none", f.a.ayd);
      aCu.put("xMinYMin", f.a.aye);
      aCu.put("xMidYMin", f.a.ayf);
      aCu.put("xMaxYMin", f.a.ayg);
      aCu.put("xMinYMid", f.a.ayh);
      aCu.put("xMidYMid", f.a.ayi);
      aCu.put("xMaxYMid", f.a.ayj);
      aCu.put("xMinYMax", f.a.ayk);
      aCu.put("xMidYMax", f.a.ayl);
      aCu.put("xMaxYMax", f.a.aym);
      AppMethodBeat.o(202829);
    }
    
    static f.a aK(String paramString)
    {
      AppMethodBeat.i(202828);
      paramString = (f.a)aCu.get(paramString);
      AppMethodBeat.o(202828);
      return paramString;
    }
  }
  
  static final class c
  {
    private static final Map<String, h.p> aCw;
    
    static
    {
      AppMethodBeat.i(202864);
      HashMap localHashMap = new HashMap(9);
      aCw = localHashMap;
      localHashMap.put("xx-small", new h.p(0.694F, h.bd.aBy));
      aCw.put("x-small", new h.p(0.833F, h.bd.aBy));
      aCw.put("small", new h.p(10.0F, h.bd.aBy));
      aCw.put("medium", new h.p(12.0F, h.bd.aBy));
      aCw.put("large", new h.p(14.4F, h.bd.aBy));
      aCw.put("x-large", new h.p(17.299999F, h.bd.aBy));
      aCw.put("xx-large", new h.p(20.700001F, h.bd.aBy));
      aCw.put("smaller", new h.p(83.330002F, h.bd.aBA));
      aCw.put("larger", new h.p(120.0F, h.bd.aBA));
      AppMethodBeat.o(202864);
    }
    
    static h.p aM(String paramString)
    {
      AppMethodBeat.i(202857);
      paramString = (h.p)aCw.get(paramString);
      AppMethodBeat.o(202857);
      return paramString;
    }
  }
  
  final class e
    extends DefaultHandler2
  {
    private e() {}
    
    public final void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202883);
      l.this.text(new String(paramArrayOfChar, paramInt1, paramInt2));
      AppMethodBeat.o(202883);
    }
    
    public final void endDocument() {}
    
    public final void endElement(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(202884);
      l.this.endElement(paramString1, paramString2, paramString3);
      AppMethodBeat.o(202884);
    }
    
    public final void processingInstruction(String paramString1, String paramString2)
    {
      AppMethodBeat.i(202888);
      l.b(paramString1, l.a(new l.h(paramString2)));
      AppMethodBeat.o(202888);
    }
    
    public final void startDocument()
    {
      AppMethodBeat.i(202878);
      l.this.startDocument();
      AppMethodBeat.o(202878);
    }
    
    public final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    {
      AppMethodBeat.i(202880);
      l.this.startElement(paramString1, paramString2, paramString3, paramAttributes);
      AppMethodBeat.o(202880);
    }
  }
  
  static enum f
  {
    private static final Map<String, f> axy;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(202948);
      aCz = new f("CLASS", 0);
      aCA = new f("clip", 1);
      aCB = new f("clip_path", 2);
      aCC = new f("clipPathUnits", 3);
      aCD = new f("clip_rule", 4);
      aCE = new f("color", 5);
      aCF = new f("cx", 6);
      aCG = new f("cy", 7);
      aCH = new f("direction", 8);
      aCI = new f("dx", 9);
      aCJ = new f("dy", 10);
      aCK = new f("fx", 11);
      aCL = new f("fy", 12);
      aCM = new f("d", 13);
      aCN = new f("display", 14);
      aCO = new f("fill", 15);
      aCP = new f("fill_rule", 16);
      aCQ = new f("fill_opacity", 17);
      aCR = new f("font", 18);
      aCS = new f("font_family", 19);
      aCT = new f("font_size", 20);
      aCU = new f("font_weight", 21);
      aCV = new f("font_style", 22);
      aCW = new f("gradientTransform", 23);
      aCX = new f("gradientUnits", 24);
      aCY = new f("height", 25);
      aCZ = new f("href", 26);
      aDa = new f("image_rendering", 27);
      aDb = new f("marker", 28);
      aDc = new f("marker_start", 29);
      aDd = new f("marker_mid", 30);
      aDe = new f("marker_end", 31);
      aDf = new f("markerHeight", 32);
      aDg = new f("markerUnits", 33);
      aDh = new f("markerWidth", 34);
      aDi = new f("mask", 35);
      aDj = new f("maskContentUnits", 36);
      aDk = new f("maskUnits", 37);
      aDl = new f("media", 38);
      aDm = new f("offset", 39);
      aDn = new f("opacity", 40);
      aDo = new f("orient", 41);
      aDp = new f("overflow", 42);
      aDq = new f("pathLength", 43);
      aDr = new f("patternContentUnits", 44);
      aDs = new f("patternTransform", 45);
      aDt = new f("patternUnits", 46);
      aDu = new f("points", 47);
      aDv = new f("preserveAspectRatio", 48);
      aDw = new f("r", 49);
      aDx = new f("refX", 50);
      aDy = new f("refY", 51);
      aDz = new f("requiredFeatures", 52);
      aDA = new f("requiredExtensions", 53);
      aDB = new f("requiredFormats", 54);
      aDC = new f("requiredFonts", 55);
      aDD = new f("rx", 56);
      aDE = new f("ry", 57);
      aDF = new f("solid_color", 58);
      aDG = new f("solid_opacity", 59);
      aDH = new f("spreadMethod", 60);
      aDI = new f("startOffset", 61);
      aDJ = new f("stop_color", 62);
      aDK = new f("stop_opacity", 63);
      aDL = new f("stroke", 64);
      aDM = new f("stroke_dasharray", 65);
      aDN = new f("stroke_dashoffset", 66);
      aDO = new f("stroke_linecap", 67);
      aDP = new f("stroke_linejoin", 68);
      aDQ = new f("stroke_miterlimit", 69);
      aDR = new f("stroke_opacity", 70);
      aDS = new f("stroke_width", 71);
      aDT = new f("style", 72);
      aDU = new f("systemLanguage", 73);
      aDV = new f("text_anchor", 74);
      aDW = new f("text_decoration", 75);
      aDX = new f("transform", 76);
      aDY = new f("type", 77);
      aDZ = new f("vector_effect", 78);
      aEa = new f("version", 79);
      aEb = new f("viewBox", 80);
      aEc = new f("width", 81);
      aEd = new f("x", 82);
      aEe = new f("y", 83);
      aEf = new f("x1", 84);
      aEg = new f("y1", 85);
      aEh = new f("x2", 86);
      aEi = new f("y2", 87);
      aEj = new f("viewport_fill", 88);
      aEk = new f("viewport_fill_opacity", 89);
      aEl = new f("visibility", 90);
      aEm = new f("UNSUPPORTED", 91);
      aEn = new f[] { aCz, aCA, aCB, aCC, aCD, aCE, aCF, aCG, aCH, aCI, aCJ, aCK, aCL, aCM, aCN, aCO, aCP, aCQ, aCR, aCS, aCT, aCU, aCV, aCW, aCX, aCY, aCZ, aDa, aDb, aDc, aDd, aDe, aDf, aDg, aDh, aDi, aDj, aDk, aDl, aDm, aDn, aDo, aDp, aDq, aDr, aDs, aDt, aDu, aDv, aDw, aDx, aDy, aDz, aDA, aDB, aDC, aDD, aDE, aDF, aDG, aDH, aDI, aDJ, aDK, aDL, aDM, aDN, aDO, aDP, aDQ, aDR, aDS, aDT, aDU, aDV, aDW, aDX, aDY, aDZ, aEa, aEb, aEc, aEd, aEe, aEf, aEg, aEh, aEi, aEj, aEk, aEl, aEm };
      axy = new HashMap();
      f[] arrayOff = values();
      int j = arrayOff.length;
      if (i < j)
      {
        f localf = arrayOff[i];
        if (localf == aCz) {
          axy.put("class", localf);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localf != aEm)
          {
            String str = localf.name().replace('_', '-');
            axy.put(str, localf);
          }
        }
      }
      AppMethodBeat.o(202948);
    }
    
    private f() {}
    
    public static f aN(String paramString)
    {
      AppMethodBeat.i(202899);
      paramString = (f)axy.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(202899);
        return paramString;
      }
      paramString = aEm;
      AppMethodBeat.o(202899);
      return paramString;
    }
  }
  
  static enum g
  {
    private static final Map<String, g> axy;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(202964);
      aEo = new g("svg", 0);
      aEp = new g("a", 1);
      aEq = new g("circle", 2);
      aEr = new g("clipPath", 3);
      aEs = new g("defs", 4);
      aEt = new g("desc", 5);
      aEu = new g("ellipse", 6);
      aEv = new g("g", 7);
      aEw = new g("image", 8);
      aEx = new g("line", 9);
      aEy = new g("linearGradient", 10);
      aEz = new g("marker", 11);
      aEA = new g("mask", 12);
      aEB = new g("path", 13);
      aEC = new g("pattern", 14);
      aED = new g("polygon", 15);
      aEE = new g("polyline", 16);
      aEF = new g("radialGradient", 17);
      aEG = new g("rect", 18);
      aEH = new g("solidColor", 19);
      aEI = new g("stop", 20);
      aEJ = new g("style", 21);
      aEK = new g("SWITCH", 22);
      aEL = new g("symbol", 23);
      aEM = new g("text", 24);
      aEN = new g("textPath", 25);
      aEO = new g("title", 26);
      aEP = new g("tref", 27);
      aEQ = new g("tspan", 28);
      aER = new g("use", 29);
      aES = new g("view", 30);
      aET = new g("UNSUPPORTED", 31);
      aEU = new g[] { aEo, aEp, aEq, aEr, aEs, aEt, aEu, aEv, aEw, aEx, aEy, aEz, aEA, aEB, aEC, aED, aEE, aEF, aEG, aEH, aEI, aEJ, aEK, aEL, aEM, aEN, aEO, aEP, aEQ, aER, aES, aET };
      axy = new HashMap();
      g[] arrayOfg = values();
      int j = arrayOfg.length;
      if (i < j)
      {
        g localg = arrayOfg[i];
        if (localg == aEK) {
          axy.put("switch", localg);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localg != aET)
          {
            String str = localg.name();
            axy.put(str, localg);
          }
        }
      }
      AppMethodBeat.o(202964);
    }
    
    private g() {}
    
    public static g aO(String paramString)
    {
      AppMethodBeat.i(202956);
      paramString = (g)axy.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(202956);
        return paramString;
      }
      paramString = aET;
      AppMethodBeat.o(202956);
      return paramString;
    }
  }
  
  static class h
  {
    int aEV;
    private e aEW;
    String input;
    int position;
    
    h(String paramString)
    {
      AppMethodBeat.i(202974);
      this.position = 0;
      this.aEV = 0;
      this.aEW = new e();
      this.input = paramString.trim();
      this.aEV = this.input.length();
      AppMethodBeat.o(202974);
    }
    
    static boolean dH(int paramInt)
    {
      return (paramInt == 32) || (paramInt == 10) || (paramInt == 13) || (paramInt == 9);
    }
    
    static boolean dI(int paramInt)
    {
      return (paramInt == 10) || (paramInt == 13);
    }
    
    private Boolean oX()
    {
      AppMethodBeat.i(203017);
      if (this.position == this.aEV)
      {
        AppMethodBeat.o(203017);
        return null;
      }
      int i = this.input.charAt(this.position);
      if ((i == 48) || (i == 49))
      {
        this.position += 1;
        if (i == 49) {}
        for (boolean bool = true;; bool = false)
        {
          AppMethodBeat.o(203017);
          return Boolean.valueOf(bool);
        }
      }
      AppMethodBeat.o(203017);
      return null;
    }
    
    final float G(float paramFloat)
    {
      AppMethodBeat.i(203004);
      if (Float.isNaN(paramFloat))
      {
        AppMethodBeat.o(203004);
        return (0.0F / 0.0F);
      }
      oS();
      paramFloat = oT();
      AppMethodBeat.o(203004);
      return paramFloat;
    }
    
    final Boolean R(Object paramObject)
    {
      AppMethodBeat.i(203019);
      if (paramObject == null)
      {
        AppMethodBeat.o(203019);
        return null;
      }
      oS();
      paramObject = oX();
      AppMethodBeat.o(203019);
      return paramObject;
    }
    
    final float a(Boolean paramBoolean)
    {
      AppMethodBeat.i(203005);
      if (paramBoolean == null)
      {
        AppMethodBeat.o(203005);
        return (0.0F / 0.0F);
      }
      oS();
      float f = oT();
      AppMethodBeat.o(203005);
      return f;
    }
    
    final String a(char paramChar, boolean paramBoolean)
    {
      AppMethodBeat.i(203042);
      if (empty())
      {
        AppMethodBeat.o(203042);
        return null;
      }
      char c = this.input.charAt(this.position);
      if (((!paramBoolean) && (dH(c))) || (c == paramChar))
      {
        AppMethodBeat.o(203042);
        return null;
      }
      int i = this.position;
      for (c = oY(); (c != 'ð¿¿') && (c != paramChar) && ((paramBoolean) || (!dH(c))); c = oY()) {}
      String str = this.input.substring(i, this.position);
      AppMethodBeat.o(203042);
      return str;
    }
    
    final boolean aP(String paramString)
    {
      AppMethodBeat.i(203028);
      int i = paramString.length();
      if ((this.position <= this.aEV - i) && (this.input.substring(this.position, this.position + i).equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.position = (i + this.position);
        }
        AppMethodBeat.o(203028);
        return bool;
      }
    }
    
    final boolean b(char paramChar)
    {
      AppMethodBeat.i(203024);
      if ((this.position < this.aEV) && (this.input.charAt(this.position) == paramChar)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.position += 1;
        }
        AppMethodBeat.o(203024);
        return bool;
      }
    }
    
    final String c(char paramChar)
    {
      AppMethodBeat.i(203037);
      String str = a(paramChar, false);
      AppMethodBeat.o(203037);
      return str;
    }
    
    final boolean empty()
    {
      return this.position == this.aEV;
    }
    
    final void oR()
    {
      AppMethodBeat.i(202987);
      while ((this.position < this.aEV) && (dH(this.input.charAt(this.position)))) {
        this.position += 1;
      }
      AppMethodBeat.o(202987);
    }
    
    final boolean oS()
    {
      AppMethodBeat.i(202996);
      oR();
      if (this.position == this.aEV)
      {
        AppMethodBeat.o(202996);
        return false;
      }
      if (this.input.charAt(this.position) != ',')
      {
        AppMethodBeat.o(202996);
        return false;
      }
      this.position += 1;
      oR();
      AppMethodBeat.o(202996);
      return true;
    }
    
    final float oT()
    {
      AppMethodBeat.i(202998);
      float f = this.aEW.f(this.input, this.position, this.aEV);
      if (!Float.isNaN(f)) {
        this.position = this.aEW.pos;
      }
      AppMethodBeat.o(202998);
      return f;
    }
    
    final float oU()
    {
      AppMethodBeat.i(203001);
      oS();
      float f = this.aEW.f(this.input, this.position, this.aEV);
      if (!Float.isNaN(f)) {
        this.position = this.aEW.pos;
      }
      AppMethodBeat.o(203001);
      return f;
    }
    
    final Integer oV()
    {
      AppMethodBeat.i(203008);
      if (this.position == this.aEV)
      {
        AppMethodBeat.o(203008);
        return null;
      }
      String str = this.input;
      int i = this.position;
      this.position = (i + 1);
      i = str.charAt(i);
      AppMethodBeat.o(203008);
      return Integer.valueOf(i);
    }
    
    final h.p oW()
    {
      AppMethodBeat.i(203012);
      float f = oT();
      if (Float.isNaN(f))
      {
        AppMethodBeat.o(203012);
        return null;
      }
      Object localObject = pd();
      if (localObject == null)
      {
        localObject = new h.p(f, h.bd.aBs);
        AppMethodBeat.o(203012);
        return localObject;
      }
      localObject = new h.p(f, (h.bd)localObject);
      AppMethodBeat.o(203012);
      return localObject;
    }
    
    final int oY()
    {
      AppMethodBeat.i(203032);
      if (this.position == this.aEV)
      {
        AppMethodBeat.o(203032);
        return -1;
      }
      this.position += 1;
      if (this.position < this.aEV)
      {
        int i = this.input.charAt(this.position);
        AppMethodBeat.o(203032);
        return i;
      }
      AppMethodBeat.o(203032);
      return -1;
    }
    
    final String oZ()
    {
      AppMethodBeat.i(292876);
      String str = a(' ', false);
      AppMethodBeat.o(292876);
      return str;
    }
    
    final String pa()
    {
      AppMethodBeat.i(203046);
      if (empty())
      {
        AppMethodBeat.o(203046);
        return null;
      }
      int j = this.position;
      int i = this.input.charAt(this.position);
      if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)))
      {
        for (i = oY(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)); i = oY()) {}
        String str = this.input.substring(j, this.position);
        AppMethodBeat.o(203046);
        return str;
      }
      this.position = j;
      AppMethodBeat.o(203046);
      return null;
    }
    
    final String pb()
    {
      AppMethodBeat.i(203048);
      if (empty())
      {
        AppMethodBeat.o(203048);
        return null;
      }
      int j = this.position;
      for (int i = this.input.charAt(this.position); ((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)); i = oY()) {}
      int k = this.position;
      while (dH(i)) {
        i = oY();
      }
      if (i == 40)
      {
        this.position += 1;
        String str = this.input.substring(j, k);
        AppMethodBeat.o(203048);
        return str;
      }
      this.position = j;
      AppMethodBeat.o(203048);
      return null;
    }
    
    final String pc()
    {
      AppMethodBeat.i(203052);
      int i = this.position;
      while ((!empty()) && (!dH(this.input.charAt(this.position)))) {
        this.position += 1;
      }
      String str = this.input.substring(i, this.position);
      this.position = i;
      AppMethodBeat.o(203052);
      return str;
    }
    
    final h.bd pd()
    {
      AppMethodBeat.i(203057);
      if (empty())
      {
        AppMethodBeat.o(203057);
        return null;
      }
      h.bd localbd;
      if (this.input.charAt(this.position) == '%')
      {
        this.position += 1;
        localbd = h.bd.aBA;
        AppMethodBeat.o(203057);
        return localbd;
      }
      if (this.position > this.aEV - 2)
      {
        AppMethodBeat.o(203057);
        return null;
      }
      try
      {
        localbd = h.bd.valueOf(this.input.substring(this.position, this.position + 2).toLowerCase(Locale.US));
        this.position += 2;
        AppMethodBeat.o(203057);
        return localbd;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        AppMethodBeat.o(203057);
      }
      return null;
    }
    
    final boolean pe()
    {
      AppMethodBeat.i(203059);
      if (this.position == this.aEV)
      {
        AppMethodBeat.o(203059);
        return false;
      }
      int i = this.input.charAt(this.position);
      if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
      {
        AppMethodBeat.o(203059);
        return true;
      }
      AppMethodBeat.o(203059);
      return false;
    }
    
    final String pf()
    {
      AppMethodBeat.i(203062);
      if (empty())
      {
        AppMethodBeat.o(203062);
        return null;
      }
      int i = this.position;
      int j = this.input.charAt(this.position);
      if ((j != 39) && (j != 34))
      {
        AppMethodBeat.o(203062);
        return null;
      }
      int k;
      do
      {
        k = oY();
      } while ((k != -1) && (k != j));
      if (k == -1)
      {
        this.position = i;
        AppMethodBeat.o(203062);
        return null;
      }
      this.position += 1;
      String str = this.input.substring(i + 1, this.position - 1);
      AppMethodBeat.o(203062);
      return str;
    }
    
    final String pg()
    {
      AppMethodBeat.i(203064);
      if (empty())
      {
        AppMethodBeat.o(203064);
        return null;
      }
      int i = this.position;
      this.position = this.aEV;
      String str = this.input.substring(i);
      AppMethodBeat.o(203064);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.a.a.l
 * JD-Core Version:    0.7.0.1
 */