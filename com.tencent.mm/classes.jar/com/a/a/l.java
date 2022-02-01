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
  private h aTU = null;
  private h.aj aTV = null;
  private boolean aTW = false;
  private int aTX;
  private boolean aTY = false;
  private g aTZ = null;
  private StringBuilder aUa = null;
  private boolean aUb = false;
  private StringBuilder aUc = null;
  
  private void A(Attributes paramAttributes)
  {
    AppMethodBeat.i(213262);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213262);
      throw paramAttributes;
    }
    h.bf localbf = new h.bf();
    localbf.aSW = this.aTU;
    localbf.aSX = this.aTV;
    a(localbf, paramAttributes);
    a(localbf, paramAttributes);
    a(localbf, paramAttributes);
    this.aTV.a(localbf);
    this.aTV = localbf;
    AppMethodBeat.o(213262);
  }
  
  private void B(Attributes paramAttributes)
  {
    AppMethodBeat.i(213263);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213263);
      throw paramAttributes;
    }
    h.s locals = new h.s();
    locals.aSW = this.aTU;
    locals.aSX = this.aTV;
    a(locals, paramAttributes);
    b(locals, paramAttributes);
    a(locals, paramAttributes);
    a(locals, paramAttributes);
    this.aTV.a(locals);
    this.aTV = locals;
    AppMethodBeat.o(213263);
  }
  
  private void C(Attributes paramAttributes)
  {
    AppMethodBeat.i(213307);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213307);
      throw paramAttributes;
    }
    Object localObject = "all";
    int i = 0;
    boolean bool = true;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
    if ((bool) && (b.a((String)localObject, b.e.aOG)))
    {
      this.aUb = true;
      AppMethodBeat.o(213307);
      return;
    }
    this.aTW = true;
    this.aTX = 1;
    AppMethodBeat.o(213307);
  }
  
  private static int T(float paramFloat)
  {
    AppMethodBeat.i(213283);
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(213283);
      return 0;
    }
    if (paramFloat > 255.0F)
    {
      AppMethodBeat.o(213283);
      return 255;
    }
    int i = Math.round(paramFloat);
    AppMethodBeat.o(213283);
    return i;
  }
  
  static Map<String, String> a(h paramh)
  {
    AppMethodBeat.i(213213);
    HashMap localHashMap = new HashMap();
    paramh.rp();
    for (String str = paramh.c('='); str != null; str = paramh.c('='))
    {
      paramh.b('=');
      localHashMap.put(str, paramh.rB());
      paramh.rp();
    }
    AppMethodBeat.o(213213);
    return localHashMap;
  }
  
  private static void a(h.a parama, Attributes paramAttributes)
  {
    AppMethodBeat.i(213219);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
          parama.aQs = str;
        }
      }
    }
    AppMethodBeat.o(213219);
  }
  
  private static void a(h.ab paramab, Attributes paramAttributes)
  {
    AppMethodBeat.i(213227);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
                paramab.aQP = ag(str);
                continue;
                paramab.aQQ = ag(str);
              }
              paramab.aQR = ag(str);
            } while (!paramab.aQR.isNegative());
            paramab = new k("Invalid <rect> element. width cannot be negative");
            AppMethodBeat.o(213227);
            throw paramab;
            paramab.aQS = ag(str);
          } while (!paramab.aQS.isNegative());
          paramab = new k("Invalid <rect> element. height cannot be negative");
          AppMethodBeat.o(213227);
          throw paramab;
          paramab.aQF = ag(str);
        } while (!paramab.aQF.isNegative());
        paramab = new k("Invalid <rect> element. rx cannot be negative");
        AppMethodBeat.o(213227);
        throw paramab;
        paramab.aQG = ag(str);
      } while (!paramab.aQG.isNegative());
      paramab = new k("Invalid <rect> element. ry cannot be negative");
      AppMethodBeat.o(213227);
      throw paramab;
    }
    AppMethodBeat.o(213227);
  }
  
  private static void a(h.ad paramad, Attributes paramAttributes)
  {
    AppMethodBeat.i(213253);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramad.aRq = ae(str);
      }
    }
    AppMethodBeat.o(213253);
  }
  
  private static void a(h.ae paramae, String paramString)
  {
    AppMethodBeat.i(213286);
    if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains("|" + paramString + '|'))
    {
      AppMethodBeat.o(213286);
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
      localh.rp();
      if (str == null)
      {
        AppMethodBeat.o(213286);
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
          localObject3 = l.d.aK(str);
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = paramString;
          if (paramString == null)
          {
            localObject2 = ar(str);
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
    paramString = aq(str);
    if (localh.b('/'))
    {
      localh.rp();
      localObject1 = localh.nextToken();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        ag((String)localObject1);
        localh.rp();
        paramae.aRF = ap(localh.rC());
        paramae.aRG = paramString;
        if (localObject5 == null)
        {
          i = 400;
          paramae.aRH = Integer.valueOf(i);
          paramString = (String)localObject2;
          if (localObject2 == null) {
            paramString = h.ae.b.aSh;
          }
          paramae.aRI = paramString;
          paramae.aRr |= 0x1E000;
          AppMethodBeat.o(213286);
          return;
        }
      }
      catch (k paramae)
      {
        AppMethodBeat.o(213286);
        return;
      }
      int i = localObject5.intValue();
    }
  }
  
  static void a(h.ae paramae, String paramString1, String paramString2)
  {
    AppMethodBeat.i(213268);
    if (paramString2.length() == 0)
    {
      AppMethodBeat.o(213268);
      return;
    }
    if (paramString2.equals("inherit"))
    {
      AppMethodBeat.o(213268);
      return;
    }
    switch (1.aUe[f.aM(paramString1).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(213268);
      return;
      paramae.aRs = al(paramString2);
      if (paramae.aRs != null)
      {
        paramae.aRr |= 1L;
        AppMethodBeat.o(213268);
        return;
        paramae.aRt = au(paramString2);
        if (paramae.aRt != null)
        {
          paramae.aRr |= 0x2;
          AppMethodBeat.o(213268);
          return;
          paramae.aRu = ai(paramString2);
          if (paramae.aRu != null)
          {
            paramae.aRr |= 0x4;
            AppMethodBeat.o(213268);
            return;
            paramae.aRv = al(paramString2);
            if (paramae.aRv != null)
            {
              paramae.aRr |= 0x8;
              AppMethodBeat.o(213268);
              return;
              paramae.aRw = ai(paramString2);
              if (paramae.aRw != null)
              {
                paramae.aRr |= 0x10;
                AppMethodBeat.o(213268);
                return;
                try
                {
                  paramae.aRx = ag(paramString2);
                  paramae.aRr |= 0x20;
                  AppMethodBeat.o(213268);
                  return;
                }
                catch (k paramae)
                {
                  AppMethodBeat.o(213268);
                  return;
                }
                paramae.aRy = av(paramString2);
                if (paramae.aRy != null)
                {
                  paramae.aRr |= 0x40;
                  AppMethodBeat.o(213268);
                  return;
                  paramae.aRz = aw(paramString2);
                  if (paramae.aRz != null)
                  {
                    paramae.aRr |= 0x80;
                    AppMethodBeat.o(213268);
                    return;
                    try
                    {
                      paramae.aRA = Float.valueOf(parseFloat(paramString2));
                      paramae.aRr |= 0x100;
                      AppMethodBeat.o(213268);
                      return;
                    }
                    catch (k paramae)
                    {
                      AppMethodBeat.o(213268);
                      return;
                    }
                    if ("none".equals(paramString2))
                    {
                      paramae.aRB = null;
                      paramae.aRr |= 0x200;
                      AppMethodBeat.o(213268);
                      return;
                    }
                    paramae.aRB = ax(paramString2);
                    if (paramae.aRB != null)
                    {
                      paramae.aRr |= 0x200;
                      AppMethodBeat.o(213268);
                      return;
                      try
                      {
                        paramae.aRC = ag(paramString2);
                        paramae.aRr |= 0x400;
                        AppMethodBeat.o(213268);
                        return;
                      }
                      catch (k paramae)
                      {
                        AppMethodBeat.o(213268);
                        return;
                      }
                      paramae.aRD = ai(paramString2);
                      paramae.aRr |= 0x800;
                      AppMethodBeat.o(213268);
                      return;
                      try
                      {
                        paramae.aRE = an(paramString2);
                        paramae.aRr |= 0x1000;
                        AppMethodBeat.o(213268);
                        return;
                      }
                      catch (k paramae)
                      {
                        AppMethodBeat.o(213268);
                        return;
                      }
                      a(paramae, paramString2);
                      AppMethodBeat.o(213268);
                      return;
                      paramae.aRF = ap(paramString2);
                      if (paramae.aRF != null)
                      {
                        paramae.aRr |= 0x2000;
                        AppMethodBeat.o(213268);
                        return;
                        paramae.aRG = aq(paramString2);
                        if (paramae.aRG != null)
                        {
                          paramae.aRr |= 0x4000;
                          AppMethodBeat.o(213268);
                          return;
                          paramae.aRH = l.d.aK(paramString2);
                          if (paramae.aRH != null)
                          {
                            paramae.aRr |= 0x8000;
                            AppMethodBeat.o(213268);
                            return;
                            paramae.aRI = ar(paramString2);
                            if (paramae.aRI != null)
                            {
                              paramae.aRr |= 0x10000;
                              AppMethodBeat.o(213268);
                              return;
                              paramae.aRJ = as(paramString2);
                              if (paramae.aRJ != null)
                              {
                                paramae.aRr |= 0x20000;
                                AppMethodBeat.o(213268);
                                return;
                                paramae.aRK = at(paramString2);
                                if (paramae.aRK != null)
                                {
                                  paramae.aRr |= 0x0;
                                  AppMethodBeat.o(213268);
                                  return;
                                  paramae.aRL = ay(paramString2);
                                  if (paramae.aRL != null)
                                  {
                                    paramae.aRr |= 0x40000;
                                    AppMethodBeat.o(213268);
                                    return;
                                    paramae.aRM = az(paramString2);
                                    if (paramae.aRM != null)
                                    {
                                      paramae.aRr |= 0x80000;
                                      AppMethodBeat.o(213268);
                                      return;
                                      paramae.aRO = aH(paramString2);
                                      paramae.aRP = paramae.aRO;
                                      paramae.aRQ = paramae.aRO;
                                      paramae.aRr |= 0xE00000;
                                      AppMethodBeat.o(213268);
                                      return;
                                      paramae.aRO = aH(paramString2);
                                      paramae.aRr |= 0x200000;
                                      AppMethodBeat.o(213268);
                                      return;
                                      paramae.aRP = aH(paramString2);
                                      paramae.aRr |= 0x400000;
                                      AppMethodBeat.o(213268);
                                      return;
                                      paramae.aRQ = aH(paramString2);
                                      paramae.aRr |= 0x800000;
                                      AppMethodBeat.o(213268);
                                      return;
                                      if ((paramString2.indexOf('|') < 0) && ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains("|" + paramString2 + '|')))
                                      {
                                        if (!paramString2.equals("none")) {}
                                        for (boolean bool = true;; bool = false)
                                        {
                                          paramae.aRR = Boolean.valueOf(bool);
                                          paramae.aRr |= 0x1000000;
                                          AppMethodBeat.o(213268);
                                          return;
                                        }
                                        if ((paramString2.indexOf('|') < 0) && ("|visible|hidden|collapse|".contains("|" + paramString2 + '|')))
                                        {
                                          paramae.aRS = Boolean.valueOf(paramString2.equals("visible"));
                                          paramae.aRr |= 0x2000000;
                                          AppMethodBeat.o(213268);
                                          return;
                                          if (paramString2.equals("currentColor")) {
                                            paramae.aRT = h.g.qQ();
                                          }
                                          for (;;)
                                          {
                                            paramae.aRr |= 0x4000000;
                                            AppMethodBeat.o(213268);
                                            return;
                                            try
                                            {
                                              paramae.aRT = an(paramString2);
                                            }
                                            catch (k paramae)
                                            {
                                              paramae.getMessage();
                                              AppMethodBeat.o(213268);
                                              return;
                                            }
                                          }
                                          paramae.aRU = ai(paramString2);
                                          paramae.aRr |= 0x8000000;
                                          AppMethodBeat.o(213268);
                                          return;
                                          paramae.aRN = aA(paramString2);
                                          if (paramae.aRN != null)
                                          {
                                            paramae.aRr |= 0x100000;
                                            AppMethodBeat.o(213268);
                                            return;
                                            paramae.aRV = aH(paramString2);
                                            paramae.aRr |= 0x10000000;
                                            AppMethodBeat.o(213268);
                                            return;
                                            paramae.aRW = au(paramString2);
                                            paramae.aRr |= 0x20000000;
                                            AppMethodBeat.o(213268);
                                            return;
                                            paramae.aRX = aH(paramString2);
                                            paramae.aRr |= 0x40000000;
                                            AppMethodBeat.o(213268);
                                            return;
                                            if (paramString2.equals("currentColor")) {
                                              paramae.aRY = h.g.qQ();
                                            }
                                            for (;;)
                                            {
                                              paramae.aRr |= 0x80000000;
                                              AppMethodBeat.o(213268);
                                              return;
                                              try
                                              {
                                                paramae.aRY = an(paramString2);
                                              }
                                              catch (k paramae)
                                              {
                                                paramae.getMessage();
                                                AppMethodBeat.o(213268);
                                                return;
                                              }
                                            }
                                            paramae.aRZ = ai(paramString2);
                                            paramae.aRr |= 0x0;
                                            AppMethodBeat.o(213268);
                                            return;
                                            if (paramString2.equals("currentColor")) {
                                              paramae.aSa = h.g.qQ();
                                            }
                                            for (;;)
                                            {
                                              paramae.aRr |= 0x0;
                                              AppMethodBeat.o(213268);
                                              return;
                                              try
                                              {
                                                paramae.aSa = an(paramString2);
                                              }
                                              catch (k paramae)
                                              {
                                                paramae.getMessage();
                                                AppMethodBeat.o(213268);
                                                return;
                                              }
                                            }
                                            paramae.aSb = ai(paramString2);
                                            paramae.aRr |= 0x0;
                                            AppMethodBeat.o(213268);
                                            return;
                                            paramae.aSc = aB(paramString2);
                                            if (paramae.aSc != null)
                                            {
                                              paramae.aRr |= 0x0;
                                              AppMethodBeat.o(213268);
                                              return;
                                              paramae.aSd = aC(paramString2);
                                              if (paramae.aSd != null) {
                                                paramae.aRr |= 0x0;
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
    AppMethodBeat.i(213215);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramaf.aQP = ag(str);
        continue;
        paramaf.aQQ = ag(str);
        continue;
        paramaf.aQR = ag(str);
        if (paramaf.aQR.isNegative())
        {
          paramaf = new k("Invalid <svg> element. width cannot be negative");
          AppMethodBeat.o(213215);
          throw paramaf;
          paramaf.aQS = ag(str);
          if (paramaf.aQS.isNegative())
          {
            paramaf = new k("Invalid <svg> element. height cannot be negative");
            AppMethodBeat.o(213215);
            throw paramaf;
            paramaf.version = str;
          }
        }
      }
    }
    AppMethodBeat.o(213215);
  }
  
  private static void a(h.ag paramag, Attributes paramAttributes)
  {
    AppMethodBeat.i(213243);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      Object localObject = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
          paramag.b(aE((String)localObject));
          continue;
          paramag.aa((String)localObject);
          continue;
          paramag.c(aF((String)localObject));
          continue;
          paramag.d(aG((String)localObject));
        }
      }
      localObject = ap((String)localObject);
      if (localObject != null) {}
      for (localObject = new HashSet((Collection)localObject);; localObject = new HashSet(0))
      {
        paramag.e((Set)localObject);
        break;
      }
    }
    AppMethodBeat.o(213243);
  }
  
  private static void a(h.al paramal, String paramString)
  {
    AppMethodBeat.i(213267);
    paramString = new b.c(paramString.replaceAll("/\\*.*?\\*/", ""));
    while (!paramString.empty())
    {
      paramString.rp();
      String str1 = paramString.qx();
      paramString.rp();
      if (!paramString.b(';'))
      {
        if (!paramString.b(':')) {
          break;
        }
        paramString.rp();
        String str2 = paramString.qA();
        if (str2 != null)
        {
          paramString.rp();
          if ((paramString.empty()) || (paramString.b(';')))
          {
            if (paramal.aPr == null) {
              paramal.aPr = new h.ae();
            }
            a(paramal.aPr, str1, str2);
            paramString.rp();
          }
        }
      }
    }
    AppMethodBeat.o(213267);
  }
  
  private static void a(h.al paramal, Attributes paramAttributes)
  {
    AppMethodBeat.i(213265);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getQName(i);
      if ((str.equals("id")) || (str.equals("xml:id")))
      {
        paramal.id = paramAttributes.getValue(i).trim();
        AppMethodBeat.o(213265);
        return;
      }
      if (str.equals("xml:space"))
      {
        paramAttributes = paramAttributes.getValue(i).trim();
        if ("default".equals(paramAttributes))
        {
          paramal.aST = Boolean.FALSE;
          AppMethodBeat.o(213265);
          return;
        }
        if ("preserve".equals(paramAttributes))
        {
          paramal.aST = Boolean.TRUE;
          AppMethodBeat.o(213265);
          return;
        }
        paramal = new k("Invalid value for \"xml:space\" attribute: ".concat(String.valueOf(paramAttributes)));
        AppMethodBeat.o(213265);
        throw paramal;
      }
      i += 1;
    }
    AppMethodBeat.o(213265);
  }
  
  private static void a(h.am paramam, Attributes paramAttributes)
  {
    AppMethodBeat.i(213249);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramam.aQU = ag(str);
        continue;
        paramam.aQV = ag(str);
        continue;
        paramam.aQW = ag(str);
        continue;
        paramam.aQX = ag(str);
      }
    }
    AppMethodBeat.o(213249);
  }
  
  private static void a(h.ap paramap, String paramString)
  {
    AppMethodBeat.i(213278);
    paramap.aQg = ak(paramString);
    AppMethodBeat.o(213278);
  }
  
  private static void a(h.aq paramaq, Attributes paramAttributes)
  {
    AppMethodBeat.i(213251);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramaq.aQx = ag(str);
        continue;
        paramaq.aQy = ag(str);
        continue;
        paramaq.aQz = ag(str);
        if (paramaq.aQz.isNegative())
        {
          paramaq = new k("Invalid <radialGradient> element. r cannot be negative");
          AppMethodBeat.o(213251);
          throw paramaq;
          paramaq.aSY = ag(str);
          continue;
          paramaq.aSZ = ag(str);
        }
      }
    }
    AppMethodBeat.o(213251);
  }
  
  private static void a(h.ar paramar, Attributes paramAttributes)
  {
    AppMethodBeat.i(213269);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramar.aQi = aj(str);
        continue;
        a(paramar, str);
      }
    }
    AppMethodBeat.o(213269);
  }
  
  private static void a(h.au paramau, Attributes paramAttributes)
  {
    AppMethodBeat.i(213241);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
          paramau.aQs = str;
        }
      }
    }
    AppMethodBeat.o(213241);
  }
  
  private static void a(h.az paramaz, Attributes paramAttributes)
  {
    AppMethodBeat.i(213259);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i))))
        {
          paramaz.aQs = str;
          continue;
          paramaz.aTb = ag(str);
        }
      }
    }
    AppMethodBeat.o(213259);
  }
  
  private static void a(h.ba paramba, Attributes paramAttributes)
  {
    AppMethodBeat.i(213238);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramba.aTc = ah(str);
        continue;
        paramba.aTd = ah(str);
        continue;
        paramba.aTe = ah(str);
        continue;
        paramba.aTf = ah(str);
      }
    }
    AppMethodBeat.o(213238);
  }
  
  private static void a(h.be parambe, Attributes paramAttributes)
  {
    AppMethodBeat.i(213221);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        parambe.aQP = ag(str);
        continue;
        parambe.aQQ = ag(str);
        continue;
        parambe.aQR = ag(str);
        if (parambe.aQR.isNegative())
        {
          parambe = new k("Invalid <use> element. width cannot be negative");
          AppMethodBeat.o(213221);
          throw parambe;
          parambe.aQS = ag(str);
          if (parambe.aQS.isNegative())
          {
            parambe = new k("Invalid <use> element. height cannot be negative");
            AppMethodBeat.o(213221);
            throw parambe;
            if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
              parambe.aQs = str;
            }
          }
        }
      }
    }
    AppMethodBeat.o(213221);
  }
  
  private static void a(h.d paramd, Attributes paramAttributes)
  {
    AppMethodBeat.i(213229);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramd.aQx = ag(str);
          continue;
          paramd.aQy = ag(str);
        }
        paramd.aQz = ag(str);
      } while (!paramd.aQz.isNegative());
      paramd = new k("Invalid <circle> element. r cannot be negative");
      AppMethodBeat.o(213229);
      throw paramd;
    }
    AppMethodBeat.o(213229);
  }
  
  private static void a(h.e parame, Attributes paramAttributes)
  {
    AppMethodBeat.i(213257);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          parame.aQA = Boolean.FALSE;
        }
        else
        {
          if (!"userSpaceOnUse".equals(str)) {
            break label111;
          }
          parame.aQA = Boolean.TRUE;
        }
      }
      label111:
      parame = new k("Invalid value for attribute clipPathUnits");
      AppMethodBeat.o(213257);
      throw parame;
    }
    AppMethodBeat.o(213257);
  }
  
  private static void a(h.i parami, Attributes paramAttributes)
  {
    AppMethodBeat.i(213231);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
            parami.aQx = ag(str);
            continue;
            parami.aQy = ag(str);
          }
          parami.aQF = ag(str);
        } while (!parami.aQF.isNegative());
        parami = new k("Invalid <ellipse> element. rx cannot be negative");
        AppMethodBeat.o(213231);
        throw parami;
        parami.aQG = ag(str);
      } while (!parami.aQG.isNegative());
      parami = new k("Invalid <ellipse> element. ry cannot be negative");
      AppMethodBeat.o(213231);
      throw parami;
    }
    AppMethodBeat.o(213231);
  }
  
  private static void a(h.j paramj, Attributes paramAttributes)
  {
    AppMethodBeat.i(213248);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          paramj.aQI = Boolean.FALSE;
        }
        else if ("userSpaceOnUse".equals(str))
        {
          paramj.aQI = Boolean.TRUE;
        }
        else
        {
          paramj = new k("Invalid value for attribute gradientUnits");
          AppMethodBeat.o(213248);
          throw paramj;
          paramj.aQJ = af(str);
          continue;
          try
          {
            paramj.aQK = h.k.valueOf(str);
          }
          catch (IllegalArgumentException paramj)
          {
            paramj = new k("Invalid spreadMethod attribute. \"" + str + "\" is not a valid value.");
            AppMethodBeat.o(213248);
            throw paramj;
          }
          if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
            paramj.aQs = str;
          }
        }
      }
    }
    AppMethodBeat.o(213248);
  }
  
  private static void a(h.n paramn, Attributes paramAttributes)
  {
    AppMethodBeat.i(213270);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      if (f.aM(paramAttributes.getLocalName(i)) == f.aVI) {
        paramn.setTransform(af(paramAttributes.getValue(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(213270);
  }
  
  private static void a(h.o paramo, Attributes paramAttributes)
  {
    AppMethodBeat.i(213223);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramo.aQP = ag(str);
        continue;
        paramo.aQQ = ag(str);
        continue;
        paramo.aQR = ag(str);
        if (paramo.aQR.isNegative())
        {
          paramo = new k("Invalid <use> element. width cannot be negative");
          AppMethodBeat.o(213223);
          throw paramo;
          paramo.aQS = ag(str);
          if (paramo.aQS.isNegative())
          {
            paramo = new k("Invalid <use> element. height cannot be negative");
            AppMethodBeat.o(213223);
            throw paramo;
            if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i))))
            {
              paramo.aQs = str;
              continue;
              a(paramo, str);
            }
          }
        }
      }
    }
    AppMethodBeat.o(213223);
  }
  
  private static void a(h.q paramq, Attributes paramAttributes)
  {
    AppMethodBeat.i(213233);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramq.aQU = ag(str);
        continue;
        paramq.aQV = ag(str);
        continue;
        paramq.aQW = ag(str);
        continue;
        paramq.aQX = ag(str);
      }
    }
    AppMethodBeat.o(213233);
  }
  
  private static void a(h.r paramr, Attributes paramAttributes)
  {
    AppMethodBeat.i(213246);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramr.aQZ = ag(str);
        continue;
        paramr.aRa = ag(str);
        continue;
        paramr.aRb = ag(str);
        if (paramr.aRb.isNegative())
        {
          paramr = new k("Invalid <marker> element. markerWidth cannot be negative");
          AppMethodBeat.o(213246);
          throw paramr;
          paramr.aRc = ag(str);
          if (paramr.aRc.isNegative())
          {
            paramr = new k("Invalid <marker> element. markerHeight cannot be negative");
            AppMethodBeat.o(213246);
            throw paramr;
            if ("strokeWidth".equals(str))
            {
              paramr.aQY = false;
            }
            else if ("userSpaceOnUse".equals(str))
            {
              paramr.aQY = true;
            }
            else
            {
              paramr = new k("Invalid value for attribute markerUnits");
              AppMethodBeat.o(213246);
              throw paramr;
              if ("auto".equals(str)) {
                paramr.aRd = Float.valueOf((0.0F / 0.0F));
              } else {
                paramr.aRd = Float.valueOf(parseFloat(str));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(213246);
  }
  
  private static void a(h.s params, Attributes paramAttributes)
  {
    AppMethodBeat.i(213264);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
              params.aRe = Boolean.FALSE;
            }
            else if ("userSpaceOnUse".equals(str))
            {
              params.aRe = Boolean.TRUE;
            }
            else
            {
              params = new k("Invalid value for attribute maskUnits");
              AppMethodBeat.o(213264);
              throw params;
              if ("objectBoundingBox".equals(str))
              {
                params.aRf = Boolean.FALSE;
              }
              else if ("userSpaceOnUse".equals(str))
              {
                params.aRf = Boolean.TRUE;
              }
              else
              {
                params = new k("Invalid value for attribute maskContentUnits");
                AppMethodBeat.o(213264);
                throw params;
                params.aQP = ag(str);
                continue;
                params.aQQ = ag(str);
              }
            }
          }
          params.aQR = ag(str);
        } while (!params.aQR.isNegative());
        params = new k("Invalid <mask> element. width cannot be negative");
        AppMethodBeat.o(213264);
        throw params;
        params.aQS = ag(str);
      } while (!params.aQS.isNegative());
      params = new k("Invalid <mask> element. height cannot be negative");
      AppMethodBeat.o(213264);
      throw params;
    }
    AppMethodBeat.o(213264);
  }
  
  private static void a(h.v paramv, Attributes paramAttributes)
  {
    AppMethodBeat.i(213225);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramv.aRh = aD(str);
        }
        paramv.aRi = Float.valueOf(parseFloat(str));
      } while (paramv.aRi.floatValue() >= 0.0F);
      paramv = new k("Invalid <path> element. pathLength cannot be negative");
      AppMethodBeat.o(213225);
      throw paramv;
    }
    AppMethodBeat.o(213225);
  }
  
  private static void a(h.y paramy, Attributes paramAttributes)
  {
    AppMethodBeat.i(213261);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          paramy.aRn = Boolean.FALSE;
        }
        else if ("userSpaceOnUse".equals(str))
        {
          paramy.aRn = Boolean.TRUE;
        }
        else
        {
          paramy = new k("Invalid value for attribute patternUnits");
          AppMethodBeat.o(213261);
          throw paramy;
          if ("objectBoundingBox".equals(str))
          {
            paramy.aRo = Boolean.FALSE;
          }
          else if ("userSpaceOnUse".equals(str))
          {
            paramy.aRo = Boolean.TRUE;
          }
          else
          {
            paramy = new k("Invalid value for attribute patternContentUnits");
            AppMethodBeat.o(213261);
            throw paramy;
            paramy.aRp = af(str);
            continue;
            paramy.aQP = ag(str);
            continue;
            paramy.aQQ = ag(str);
            continue;
            paramy.aQR = ag(str);
            if (paramy.aQR.isNegative())
            {
              paramy = new k("Invalid <pattern> element. width cannot be negative");
              AppMethodBeat.o(213261);
              throw paramy;
              paramy.aQS = ag(str);
              if (paramy.aQS.isNegative())
              {
                paramy = new k("Invalid <pattern> element. height cannot be negative");
                AppMethodBeat.o(213261);
                throw paramy;
                if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
                  paramy.aQs = str;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(213261);
  }
  
  private static void a(h.z paramz, Attributes paramAttributes, String paramString)
  {
    AppMethodBeat.i(213235);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      if (f.aM(paramAttributes.getLocalName(i)) == f.aVf)
      {
        Object localObject = new h(paramAttributes.getValue(i));
        ArrayList localArrayList = new ArrayList();
        ((h)localObject).rp();
        float f1;
        while (!((h)localObject).empty())
        {
          f1 = ((h)localObject).nextFloat();
          if (Float.isNaN(f1))
          {
            paramz = new k("Invalid <" + paramString + "> points attribute. Non-coordinate content found in list.");
            AppMethodBeat.o(213235);
            throw paramz;
          }
          ((h)localObject).rq();
          float f2 = ((h)localObject).nextFloat();
          if (Float.isNaN(f2))
          {
            paramz = new k("Invalid <" + paramString + "> points attribute. There should be an even number of coordinates.");
            AppMethodBeat.o(213235);
            throw paramz;
          }
          ((h)localObject).rq();
          localArrayList.add(Float.valueOf(f1));
          localArrayList.add(Float.valueOf(f2));
        }
        paramz.points = new float[localArrayList.size()];
        localObject = localArrayList.iterator();
        int j = 0;
        while (((Iterator)localObject).hasNext())
        {
          f1 = ((Float)((Iterator)localObject).next()).floatValue();
          paramz.points[j] = f1;
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(213235);
  }
  
  private void a(Attributes paramAttributes)
  {
    AppMethodBeat.i(213214);
    h.af localaf = new h.af();
    localaf.aSW = this.aTU;
    localaf.aSX = this.aTV;
    a(localaf, paramAttributes);
    b(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    if (this.aTV == null) {
      this.aTU.aQn = localaf;
    }
    for (;;)
    {
      this.aTV = localaf;
      AppMethodBeat.o(213214);
      return;
      this.aTV.a(localaf);
    }
  }
  
  private static h.c aA(String paramString)
  {
    AppMethodBeat.i(213298);
    if ("auto".equals(paramString))
    {
      AppMethodBeat.o(213298);
      return null;
    }
    if (!paramString.startsWith("rect("))
    {
      AppMethodBeat.o(213298);
      return null;
    }
    paramString = new h(paramString.substring(5));
    paramString.rp();
    h.p localp1 = b(paramString);
    paramString.rq();
    h.p localp2 = b(paramString);
    paramString.rq();
    h.p localp3 = b(paramString);
    paramString.rq();
    h.p localp4 = b(paramString);
    paramString.rp();
    if ((!paramString.b(')')) && (!paramString.empty()))
    {
      AppMethodBeat.o(213298);
      return null;
    }
    paramString = new h.c(localp1, localp2, localp3, localp4);
    AppMethodBeat.o(213298);
    return paramString;
  }
  
  private static h.ae.i aB(String paramString)
  {
    AppMethodBeat.i(213300);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(213300);
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
    paramString = h.ae.i.aSK;
    AppMethodBeat.o(213300);
    return paramString;
    paramString = h.ae.i.aSL;
    AppMethodBeat.o(213300);
    return paramString;
  }
  
  private static h.ae.e aC(String paramString)
  {
    AppMethodBeat.i(213301);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(213301);
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
    paramString = h.ae.e.aSt;
    AppMethodBeat.o(213301);
    return paramString;
    paramString = h.ae.e.aSu;
    AppMethodBeat.o(213301);
    return paramString;
    paramString = h.ae.e.aSv;
    AppMethodBeat.o(213301);
    return paramString;
  }
  
  private static h.w aD(String paramString)
  {
    AppMethodBeat.i(213302);
    paramString = new h(paramString);
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f10 = 0.0F;
    float f9 = 0.0F;
    h.w localw = new h.w();
    if (paramString.empty())
    {
      AppMethodBeat.o(213302);
      return localw;
    }
    int i = paramString.rs().intValue();
    float f2;
    float f1;
    label107:
    float f5;
    float f6;
    float f7;
    if ((i != 77) && (i != 109))
    {
      AppMethodBeat.o(213302);
      return localw;
      if ((i == 109) && (!localw.isEmpty()))
      {
        Object localObject2;
        localObject2 += f4;
        Object localObject1;
        localObject1 += f3;
        localw.moveTo(f1, f2);
        if (i == 109)
        {
          i = 108;
          f5 = f2;
          f6 = f1;
          f7 = f2;
          f3 = f1;
          f4 = f2;
          f2 = f7;
          paramString.rq();
          if (paramString.empty()) {
            break label1460;
          }
          if (!paramString.rA()) {
            break label1469;
          }
          i = paramString.rs().intValue();
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
      paramString.rp();
      switch (i)
      {
      default: 
        AppMethodBeat.o(213302);
        return localw;
      case 77: 
      case 109: 
        f1 = paramString.nextFloat();
        f2 = paramString.U(f1);
        if (!Float.isNaN(f2)) {
          break;
        }
        new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
        AppMethodBeat.o(213302);
        return localw;
        i = 76;
        break;
      case 76: 
      case 108: 
        f5 = paramString.nextFloat();
        f6 = paramString.U(f5);
        if (Float.isNaN(f6))
        {
          new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
          AppMethodBeat.o(213302);
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
          localw.lineTo(f3, f4);
          f5 = f4;
          f6 = f3;
          f7 = f1;
          f1 = f3;
          f3 = f7;
          break;
          f7 = paramString.nextFloat();
          float f8 = paramString.U(f7);
          f6 = paramString.U(f8);
          f5 = paramString.U(f6);
          f9 = paramString.U(f5);
          f10 = paramString.U(f9);
          if (Float.isNaN(f10))
          {
            new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
            AppMethodBeat.o(213302);
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
            localw.cubicTo(f7, f8, f6, f5, f3, f4);
            f7 = f1;
            f1 = f3;
            f3 = f7;
            break;
            f6 = paramString.nextFloat();
            f8 = paramString.U(f6);
            f7 = paramString.U(f8);
            f5 = paramString.U(f7);
            if (Float.isNaN(f5))
            {
              new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
              AppMethodBeat.o(213302);
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
              localw.cubicTo(2.0F * f3 - f10, 2.0F * f4 - f9, f6, f8, f7, f5);
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
              f5 = paramString.nextFloat();
              if (Float.isNaN(f5))
              {
                new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                AppMethodBeat.o(213302);
                return localw;
              }
              if (i == 104) {}
              for (f3 = f5 + f3;; f3 = f5)
              {
                localw.lineTo(f3, f4);
                f6 = f3;
                f7 = f1;
                f1 = f3;
                f5 = f9;
                f3 = f7;
                break;
                f5 = paramString.nextFloat();
                if (Float.isNaN(f5))
                {
                  new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                  AppMethodBeat.o(213302);
                  return localw;
                }
                if (i == 118) {}
                for (f4 = f5 + f4;; f4 = f5)
                {
                  localw.lineTo(f3, f4);
                  f5 = f4;
                  f7 = f1;
                  f1 = f3;
                  f6 = f10;
                  f3 = f7;
                  break;
                  f5 = paramString.nextFloat();
                  f6 = paramString.U(f5);
                  f8 = paramString.U(f6);
                  f7 = paramString.U(f8);
                  if (Float.isNaN(f7))
                  {
                    new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                    AppMethodBeat.o(213302);
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
                    localw.quadTo(f5, f6, f3, f4);
                    f8 = f5;
                    f7 = f1;
                    f5 = f6;
                    f6 = f8;
                    f1 = f3;
                    f3 = f7;
                    break;
                    f6 = 2.0F * f3 - f10;
                    f5 = 2.0F * f4 - f9;
                    f7 = paramString.nextFloat();
                    f8 = paramString.U(f7);
                    if (Float.isNaN(f8))
                    {
                      new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                      AppMethodBeat.o(213302);
                      return localw;
                    }
                    if (i == 116) {
                      f4 = f8 + f4;
                    }
                    for (f3 = f7 + f3;; f3 = f7)
                    {
                      localw.quadTo(f6, f5, f3, f4);
                      f7 = f1;
                      f1 = f3;
                      f3 = f7;
                      break;
                      f7 = paramString.nextFloat();
                      f8 = paramString.U(f7);
                      f9 = paramString.U(f8);
                      Boolean localBoolean1 = paramString.ab(Float.valueOf(f9));
                      Boolean localBoolean2 = paramString.ab(localBoolean1);
                      f5 = paramString.a(localBoolean2);
                      f6 = paramString.U(f5);
                      if ((Float.isNaN(f6)) || (f7 < 0.0F) || (f8 < 0.0F))
                      {
                        new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                        AppMethodBeat.o(213302);
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
                        AppMethodBeat.o(213302);
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
  
  private static Set<String> aE(String paramString)
  {
    AppMethodBeat.i(213303);
    paramString = new h(paramString);
    HashSet localHashSet = new HashSet();
    if (!paramString.empty())
    {
      String str = paramString.nextToken();
      if (str.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
        localHashSet.add(str.substring(35));
      }
      for (;;)
      {
        paramString.rp();
        break;
        localHashSet.add("UNSUPPORTED");
      }
    }
    AppMethodBeat.o(213303);
    return localHashSet;
  }
  
  private static Set<String> aF(String paramString)
  {
    AppMethodBeat.i(213304);
    h localh = new h(paramString);
    HashSet localHashSet = new HashSet();
    while (!localh.empty())
    {
      String str = localh.nextToken();
      int i = str.indexOf('-');
      paramString = str;
      if (i != -1) {
        paramString = str.substring(0, i);
      }
      localHashSet.add(new Locale(paramString, "", "").getLanguage());
      localh.rp();
    }
    AppMethodBeat.o(213304);
    return localHashSet;
  }
  
  private static Set<String> aG(String paramString)
  {
    AppMethodBeat.i(213305);
    paramString = new h(paramString);
    HashSet localHashSet = new HashSet();
    while (!paramString.empty())
    {
      localHashSet.add(paramString.nextToken());
      paramString.rp();
    }
    AppMethodBeat.o(213305);
    return localHashSet;
  }
  
  private static String aH(String paramString)
  {
    AppMethodBeat.i(213306);
    if (paramString.equals("none"))
    {
      AppMethodBeat.o(213306);
      return null;
    }
    if (!paramString.startsWith("url("))
    {
      AppMethodBeat.o(213306);
      return null;
    }
    if (paramString.endsWith(")"))
    {
      paramString = paramString.substring(4, paramString.length() - 1).trim();
      AppMethodBeat.o(213306);
      return paramString;
    }
    paramString = paramString.substring(4).trim();
    AppMethodBeat.o(213306);
    return paramString;
  }
  
  private void aI(String paramString)
  {
    AppMethodBeat.i(213308);
    b localb = new b(b.e.aOG, b.t.aPz);
    this.aTU.b(localb.V(paramString));
    AppMethodBeat.o(213308);
  }
  
  private void ad(String paramString)
  {
    AppMethodBeat.i(213210);
    Object localObject = (h.ah)this.aTV;
    int i = ((h.ah)localObject).aQH.size();
    if (i == 0) {}
    for (localObject = null; (localObject instanceof h.bc); localObject = (h.an)((h.ah)localObject).aQH.get(i - 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = (h.bc)localObject;
      ((h.bc)localObject).text += paramString;
      AppMethodBeat.o(213210);
      return;
    }
    this.aTV.a(new h.bc(paramString));
    AppMethodBeat.o(213210);
  }
  
  private static Float ae(String paramString)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(213254);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid offset value in <stop> (empty string)");
      AppMethodBeat.o(213254);
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
        float f3 = g(paramString, j);
        f1 = f3;
        if (i == 0) {
          break label152;
        }
        f1 = f3 / 100.0F;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = new k("Invalid offset value in <stop>: ".concat(String.valueOf(paramString)), localNumberFormatException);
        AppMethodBeat.o(213254);
        throw paramString;
      }
      AppMethodBeat.o(213254);
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
    AppMethodBeat.i(213271);
    Matrix localMatrix = new Matrix();
    h localh = new h(paramString);
    localh.rp();
    if (!localh.empty())
    {
      Object localObject = localh.rx();
      if (localObject == null)
      {
        paramString = new k("Bad transform function encountered in transform list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(213271);
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
          AppMethodBeat.o(213271);
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
      localh.rp();
      float f1 = localh.nextFloat();
      localh.rq();
      float f2 = localh.nextFloat();
      localh.rq();
      float f3 = localh.nextFloat();
      localh.rq();
      float f4 = localh.nextFloat();
      localh.rq();
      float f5 = localh.nextFloat();
      localh.rq();
      float f6 = localh.nextFloat();
      localh.rp();
      if ((Float.isNaN(f6)) || (!localh.b(')')))
      {
        paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(213271);
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
        localh.rq();
        break;
        localh.rp();
        f1 = localh.nextFloat();
        f2 = localh.rr();
        localh.rp();
        if ((Float.isNaN(f1)) || (!localh.b(')')))
        {
          paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(213271);
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
          localh.rp();
          f1 = localh.nextFloat();
          f2 = localh.rr();
          localh.rp();
          if ((Float.isNaN(f1)) || (!localh.b(')')))
          {
            paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(213271);
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
            localh.rp();
            f1 = localh.nextFloat();
            f2 = localh.rr();
            f3 = localh.rr();
            localh.rp();
            if ((Float.isNaN(f1)) || (!localh.b(')')))
            {
              paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
              AppMethodBeat.o(213271);
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
              AppMethodBeat.o(213271);
              throw paramString;
              localh.rp();
              f1 = localh.nextFloat();
              localh.rp();
              if ((Float.isNaN(f1)) || (!localh.b(')')))
              {
                paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
                AppMethodBeat.o(213271);
                throw paramString;
              }
              localMatrix.preSkew((float)Math.tan(Math.toRadians(f1)), 0.0F);
              continue;
              localh.rp();
              f1 = localh.nextFloat();
              localh.rp();
              if ((Float.isNaN(f1)) || (!localh.b(')')))
              {
                paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
                AppMethodBeat.o(213271);
                throw paramString;
              }
              localMatrix.preSkew(0.0F, (float)Math.tan(Math.toRadians(f1)));
            }
          }
        }
      }
    }
    label1011:
    AppMethodBeat.o(213271);
    return localMatrix;
  }
  
  private static h.p ag(String paramString)
  {
    AppMethodBeat.i(213272);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid length value (empty string)");
      AppMethodBeat.o(213272);
      throw paramString;
    }
    int j = paramString.length();
    h.bd localbd = h.bd.aTg;
    char c = paramString.charAt(j - 1);
    int i;
    Object localObject;
    if (c == '%')
    {
      i = j - 1;
      localObject = h.bd.aTo;
    }
    for (;;)
    {
      try
      {
        localObject = new h.p(g(paramString, i), (h.bd)localObject);
        AppMethodBeat.o(213272);
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = new k("Invalid length value: ".concat(String.valueOf(paramString)), localNumberFormatException);
        AppMethodBeat.o(213272);
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
        AppMethodBeat.o(213272);
        throw paramString;
      }
    }
  }
  
  private static List<h.p> ah(String paramString)
  {
    AppMethodBeat.i(213273);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid length list (empty string)");
      AppMethodBeat.o(213273);
      throw paramString;
    }
    ArrayList localArrayList = new ArrayList(1);
    h localh = new h(paramString);
    localh.rp();
    while (!localh.empty())
    {
      float f = localh.nextFloat();
      if (Float.isNaN(f))
      {
        paramString = new k("Invalid length list value: " + localh.ry());
        AppMethodBeat.o(213273);
        throw paramString;
      }
      h.bd localbd = localh.rz();
      paramString = localbd;
      if (localbd == null) {
        paramString = h.bd.aTg;
      }
      localArrayList.add(new h.p(f, paramString));
      localh.rq();
    }
    AppMethodBeat.o(213273);
    return localArrayList;
  }
  
  private static Float ai(String paramString)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(213276);
    try
    {
      float f2 = parseFloat(paramString);
      if (f2 < 0.0F) {}
      for (;;)
      {
        AppMethodBeat.o(213276);
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
      AppMethodBeat.o(213276);
    }
  }
  
  private static h.b aj(String paramString)
  {
    AppMethodBeat.i(213277);
    paramString = new h(paramString);
    paramString.rp();
    float f1 = paramString.nextFloat();
    paramString.rq();
    float f2 = paramString.nextFloat();
    paramString.rq();
    float f3 = paramString.nextFloat();
    paramString.rq();
    float f4 = paramString.nextFloat();
    if ((Float.isNaN(f1)) || (Float.isNaN(f2)) || (Float.isNaN(f3)) || (Float.isNaN(f4)))
    {
      paramString = new k("Invalid viewBox definition - should have four numbers");
      AppMethodBeat.o(213277);
      throw paramString;
    }
    if (f3 < 0.0F)
    {
      paramString = new k("Invalid viewBox. width cannot be negative");
      AppMethodBeat.o(213277);
      throw paramString;
    }
    if (f4 < 0.0F)
    {
      paramString = new k("Invalid viewBox. height cannot be negative");
      AppMethodBeat.o(213277);
      throw paramString;
    }
    paramString = new h.b(f1, f2, f3, f4);
    AppMethodBeat.o(213277);
    return paramString;
  }
  
  private static f ak(String paramString)
  {
    AppMethodBeat.i(213279);
    h localh = new h(paramString);
    localh.rp();
    Object localObject2 = localh.a(' ', false);
    Object localObject1 = localObject2;
    if ("defer".equals(localObject2))
    {
      localh.rp();
      localObject1 = localh.a(' ', false);
    }
    localObject2 = a.aJ((String)localObject1);
    localObject1 = null;
    localh.rp();
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
          AppMethodBeat.o(213279);
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
    for (localObject1 = f.b.aQc;; localObject1 = f.b.aQd)
    {
      paramString = new f((f.a)localObject2, (f.b)localObject1);
      AppMethodBeat.o(213279);
      return paramString;
    }
  }
  
  private static h.ao al(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(213280);
    if (paramString.startsWith("url("))
    {
      int i = paramString.indexOf(")");
      if (i != -1)
      {
        String str1 = paramString.substring(4, i).trim();
        String str2 = paramString.substring(i + 1).trim();
        paramString = localObject;
        if (str2.length() > 0) {
          paramString = am(str2);
        }
        paramString = new h.u(str1, paramString);
        AppMethodBeat.o(213280);
        return paramString;
      }
      paramString = new h.u(paramString.substring(4).trim(), null);
      AppMethodBeat.o(213280);
      return paramString;
    }
    paramString = am(paramString);
    AppMethodBeat.o(213280);
    return paramString;
  }
  
  private static h.ao am(String paramString)
  {
    AppMethodBeat.i(213281);
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
        paramString = an(paramString);
        AppMethodBeat.o(213281);
        return paramString;
      }
      catch (k paramString)
      {
        AppMethodBeat.o(213281);
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
    paramString = h.f.aQD;
    AppMethodBeat.o(213281);
    return paramString;
    paramString = h.g.qQ();
    AppMethodBeat.o(213281);
    return paramString;
    return null;
  }
  
  private static h.f an(String paramString)
  {
    AppMethodBeat.i(213282);
    int i;
    if (paramString.charAt(0) == '#')
    {
      localObject = d.f(paramString, paramString.length());
      if (localObject == null)
      {
        paramString = new k("Bad hex colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(213282);
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
        AppMethodBeat.o(213282);
        throw paramString;
      case 4: 
        k = (int)((d)localObject).value;
        i = k & 0xF00;
        j = k & 0xF0;
        k &= 0xF;
        paramString = new h.f(i << 8 | i << 12 | 0xFF000000 | j << 8 | j << 4 | k << 4 | k);
        AppMethodBeat.o(213282);
        return paramString;
      case 5: 
        int m = (int)((d)localObject).value;
        i = 0xF000 & m;
        j = m & 0xF00;
        k = m & 0xF0;
        m &= 0xF;
        paramString = new h.f(i << 4 | m << 24 | m << 28 | i << 8 | j << 4 | j | k | k >> 4);
        AppMethodBeat.o(213282);
        return paramString;
      case 7: 
        paramString = new h.f((int)((d)localObject).value | 0xFF000000);
        AppMethodBeat.o(213282);
        return paramString;
      }
      i = (int)((d)localObject).value;
      paramString = new h.f((int)((d)localObject).value >>> 8 | i << 24);
      AppMethodBeat.o(213282);
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
        ((h)localObject).rp();
        f2 = ((h)localObject).nextFloat();
        f1 = f2;
        if (!Float.isNaN(f2))
        {
          f1 = f2;
          if (((h)localObject).b('%')) {
            f1 = f2 * 256.0F / 100.0F;
          }
        }
        f3 = ((h)localObject).U(f1);
        f2 = f3;
        if (!Float.isNaN(f3))
        {
          f2 = f3;
          if (((h)localObject).b('%')) {
            f2 = f3 * 256.0F / 100.0F;
          }
        }
        f3 = ((h)localObject).U(f2);
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
        f4 = ((h)localObject).U(f3);
        ((h)localObject).rp();
        if ((Float.isNaN(f4)) || (!((h)localObject).b(')')))
        {
          paramString = new k("Bad rgba() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(213282);
          throw paramString;
          i = 4;
          break;
        }
        i = T(f4 * 256.0F);
        paramString = new h.f(T(f1) << 16 | i << 24 | T(f2) << 8 | T(f3));
        AppMethodBeat.o(213282);
        return paramString;
      }
      ((h)localObject).rp();
      if ((Float.isNaN(f3)) || (!((h)localObject).b(')')))
      {
        paramString = new k("Bad rgb() colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(213282);
        throw paramString;
      }
      paramString = new h.f(T(f1) << 16 | 0xFF000000 | T(f2) << 8 | T(f3));
      AppMethodBeat.o(213282);
      return paramString;
      bool = ((String)localObject).startsWith("hsla(");
      if ((bool) || (((String)localObject).startsWith("hsl(")))
      {
        if (bool) {}
        for (i = 5;; i = 4)
        {
          localObject = new h(paramString.substring(i));
          ((h)localObject).rp();
          f1 = ((h)localObject).nextFloat();
          f2 = ((h)localObject).U(f1);
          if (!Float.isNaN(f2)) {
            ((h)localObject).b('%');
          }
          f3 = ((h)localObject).U(f2);
          if (!Float.isNaN(f3)) {
            ((h)localObject).b('%');
          }
          if (!bool) {
            break label953;
          }
          f4 = ((h)localObject).U(f3);
          ((h)localObject).rp();
          if ((!Float.isNaN(f4)) && (((h)localObject).b(')'))) {
            break;
          }
          paramString = new k("Bad hsla() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(213282);
          throw paramString;
        }
        paramString = new h.f(T(f4 * 256.0F) << 24 | h(f1, f2, f3));
        AppMethodBeat.o(213282);
        return paramString;
        label953:
        ((h)localObject).rp();
        if ((Float.isNaN(f3)) || (!((h)localObject).b(')')))
        {
          paramString = new k("Bad hsl() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(213282);
          throw paramString;
        }
        paramString = new h.f(h(f1, f2, f3) | 0xFF000000);
        AppMethodBeat.o(213282);
        return paramString;
      }
      paramString = ao((String)localObject);
      AppMethodBeat.o(213282);
      return paramString;
    }
  }
  
  private static h.f ao(String paramString)
  {
    AppMethodBeat.i(213285);
    Integer localInteger = b.aK(paramString);
    if (localInteger == null)
    {
      paramString = new k("Invalid colour keyword: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(213285);
      throw paramString;
    }
    paramString = new h.f(localInteger.intValue());
    AppMethodBeat.o(213285);
    return paramString;
  }
  
  private static List<String> ap(String paramString)
  {
    AppMethodBeat.i(213287);
    Object localObject1 = null;
    h localh = new h(paramString);
    paramString = (String)localObject1;
    do
    {
      localObject1 = localh.rB();
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
      localh.rq();
      paramString = (String)localObject1;
    } while (!localh.empty());
    AppMethodBeat.o(213287);
    return localObject1;
  }
  
  private static h.p aq(String paramString)
  {
    AppMethodBeat.i(213288);
    try
    {
      h.p localp2 = c.aL(paramString);
      h.p localp1 = localp2;
      if (localp2 == null) {
        localp1 = ag(paramString);
      }
      AppMethodBeat.o(213288);
      return localp1;
    }
    catch (k paramString)
    {
      AppMethodBeat.o(213288);
    }
    return null;
  }
  
  private static h.ae.b ar(String paramString)
  {
    AppMethodBeat.i(213289);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(213289);
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
    paramString = h.ae.b.aSi;
    AppMethodBeat.o(213289);
    return paramString;
    paramString = h.ae.b.aSh;
    AppMethodBeat.o(213289);
    return paramString;
    paramString = h.ae.b.aSj;
    AppMethodBeat.o(213289);
    return paramString;
  }
  
  private static h.ae.g as(String paramString)
  {
    AppMethodBeat.i(213290);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(213290);
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
    paramString = h.ae.g.aSB;
    AppMethodBeat.o(213290);
    return paramString;
    paramString = h.ae.g.aSC;
    AppMethodBeat.o(213290);
    return paramString;
    paramString = h.ae.g.aSD;
    AppMethodBeat.o(213290);
    return paramString;
    paramString = h.ae.g.aSE;
    AppMethodBeat.o(213290);
    return paramString;
    paramString = h.ae.g.aSF;
    AppMethodBeat.o(213290);
    return paramString;
  }
  
  private static h.ae.h at(String paramString)
  {
    AppMethodBeat.i(213291);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(213291);
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
    paramString = h.ae.h.aSH;
    AppMethodBeat.o(213291);
    return paramString;
    paramString = h.ae.h.aSI;
    AppMethodBeat.o(213291);
    return paramString;
  }
  
  private static h.ae.a au(String paramString)
  {
    AppMethodBeat.i(213292);
    if ("nonzero".equals(paramString))
    {
      paramString = h.ae.a.aSe;
      AppMethodBeat.o(213292);
      return paramString;
    }
    if ("evenodd".equals(paramString))
    {
      paramString = h.ae.a.aSf;
      AppMethodBeat.o(213292);
      return paramString;
    }
    AppMethodBeat.o(213292);
    return null;
  }
  
  private static h.ae.c av(String paramString)
  {
    AppMethodBeat.i(213293);
    if ("butt".equals(paramString))
    {
      paramString = h.ae.c.aSl;
      AppMethodBeat.o(213293);
      return paramString;
    }
    if ("round".equals(paramString))
    {
      paramString = h.ae.c.aSm;
      AppMethodBeat.o(213293);
      return paramString;
    }
    if ("square".equals(paramString))
    {
      paramString = h.ae.c.aSn;
      AppMethodBeat.o(213293);
      return paramString;
    }
    AppMethodBeat.o(213293);
    return null;
  }
  
  private static h.ae.d aw(String paramString)
  {
    AppMethodBeat.i(213294);
    if ("miter".equals(paramString))
    {
      paramString = h.ae.d.aSp;
      AppMethodBeat.o(213294);
      return paramString;
    }
    if ("round".equals(paramString))
    {
      paramString = h.ae.d.aSq;
      AppMethodBeat.o(213294);
      return paramString;
    }
    if ("bevel".equals(paramString))
    {
      paramString = h.ae.d.aSr;
      AppMethodBeat.o(213294);
      return paramString;
    }
    AppMethodBeat.o(213294);
    return null;
  }
  
  private static h.p[] ax(String paramString)
  {
    AppMethodBeat.i(213295);
    paramString = new h(paramString);
    paramString.rp();
    if (paramString.empty())
    {
      AppMethodBeat.o(213295);
      return null;
    }
    h.p localp = paramString.rt();
    if (localp == null)
    {
      AppMethodBeat.o(213295);
      return null;
    }
    if (localp.isNegative())
    {
      AppMethodBeat.o(213295);
      return null;
    }
    float f = localp.value;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localp);
    while (!paramString.empty())
    {
      paramString.rq();
      localp = paramString.rt();
      if (localp == null)
      {
        AppMethodBeat.o(213295);
        return null;
      }
      if (localp.isNegative())
      {
        AppMethodBeat.o(213295);
        return null;
      }
      localArrayList.add(localp);
      f += localp.value;
    }
    if (f == 0.0F)
    {
      AppMethodBeat.o(213295);
      return null;
    }
    paramString = (h.p[])localArrayList.toArray(new h.p[localArrayList.size()]);
    AppMethodBeat.o(213295);
    return paramString;
  }
  
  private static h.ae.f ay(String paramString)
  {
    AppMethodBeat.i(213296);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(213296);
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
    paramString = h.ae.f.aSx;
    AppMethodBeat.o(213296);
    return paramString;
    paramString = h.ae.f.aSy;
    AppMethodBeat.o(213296);
    return paramString;
    paramString = h.ae.f.aSz;
    AppMethodBeat.o(213296);
    return paramString;
  }
  
  private static Boolean az(String paramString)
  {
    AppMethodBeat.i(213297);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(213297);
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
    AppMethodBeat.o(213297);
    return paramString;
    paramString = Boolean.FALSE;
    AppMethodBeat.o(213297);
    return paramString;
  }
  
  private static h.p b(h paramh)
  {
    AppMethodBeat.i(213299);
    if (paramh.aO("auto"))
    {
      paramh = new h.p(0.0F);
      AppMethodBeat.o(213299);
      return paramh;
    }
    paramh = paramh.rt();
    AppMethodBeat.o(213299);
    return paramh;
  }
  
  private static void b(h.al paramal, Attributes paramAttributes)
  {
    AppMethodBeat.i(213266);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      if (str.length() != 0) {
        switch (1.aUe[f.aM(paramAttributes.getLocalName(i)).ordinal()])
        {
        default: 
          if (paramal.aSU == null) {
            paramal.aSU = new h.ae();
          }
          a(paramal.aSU, paramAttributes.getLocalName(i), paramAttributes.getValue(i).trim());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramal, str);
        continue;
        paramal.aSV = b.W(str);
      }
    }
    AppMethodBeat.o(213266);
  }
  
  static void b(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(213212);
    if ((paramString.equals("xml-stylesheet")) && (h.qN() != null))
    {
      if (((String)paramMap.get("type") != null) && (!"text/css".equals(paramMap.get("type"))))
      {
        AppMethodBeat.o(213212);
        return;
      }
      if (((String)paramMap.get("alternate") != null) && (!"no".equals(paramMap.get("alternate"))))
      {
        AppMethodBeat.o(213212);
        return;
      }
      if ((String)paramMap.get("href") != null)
      {
        h.qN();
        AppMethodBeat.o(213212);
        return;
      }
    }
    AppMethodBeat.o(213212);
  }
  
  private void b(Attributes paramAttributes)
  {
    AppMethodBeat.i(213216);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213216);
      throw paramAttributes;
    }
    h.m localm = new h.m();
    localm.aSW = this.aTU;
    localm.aSX = this.aTV;
    a(localm, paramAttributes);
    b(localm, paramAttributes);
    a(localm, paramAttributes);
    a(localm, paramAttributes);
    this.aTV.a(localm);
    this.aTV = localm;
    AppMethodBeat.o(213216);
  }
  
  private void c(Attributes paramAttributes)
  {
    AppMethodBeat.i(213217);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213217);
      throw paramAttributes;
    }
    h.h localh = new h.h();
    localh.aSW = this.aTU;
    localh.aSX = this.aTV;
    a(localh, paramAttributes);
    b(localh, paramAttributes);
    a(localh, paramAttributes);
    this.aTV.a(localh);
    this.aTV = localh;
    AppMethodBeat.o(213217);
  }
  
  private void d(Attributes paramAttributes)
  {
    AppMethodBeat.i(213218);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213218);
      throw paramAttributes;
    }
    h.a locala = new h.a();
    locala.aSW = this.aTU;
    locala.aSX = this.aTV;
    a(locala, paramAttributes);
    b(locala, paramAttributes);
    a(locala, paramAttributes);
    a(locala, paramAttributes);
    a(locala, paramAttributes);
    this.aTV.a(locala);
    this.aTV = locala;
    AppMethodBeat.o(213218);
  }
  
  private void e(Attributes paramAttributes)
  {
    AppMethodBeat.i(213220);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213220);
      throw paramAttributes;
    }
    h.be localbe = new h.be();
    localbe.aSW = this.aTU;
    localbe.aSX = this.aTV;
    a(localbe, paramAttributes);
    b(localbe, paramAttributes);
    a(localbe, paramAttributes);
    a(localbe, paramAttributes);
    a(localbe, paramAttributes);
    this.aTV.a(localbe);
    this.aTV = localbe;
    AppMethodBeat.o(213220);
  }
  
  private void f(Attributes paramAttributes)
  {
    AppMethodBeat.i(213222);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213222);
      throw paramAttributes;
    }
    h.o localo = new h.o();
    localo.aSW = this.aTU;
    localo.aSX = this.aTV;
    a(localo, paramAttributes);
    b(localo, paramAttributes);
    a(localo, paramAttributes);
    a(localo, paramAttributes);
    a(localo, paramAttributes);
    this.aTV.a(localo);
    this.aTV = localo;
    AppMethodBeat.o(213222);
  }
  
  private static float g(String paramString, int paramInt)
  {
    AppMethodBeat.i(213275);
    float f = new e().f(paramString, 0, paramInt);
    if (!Float.isNaN(f))
    {
      AppMethodBeat.o(213275);
      return f;
    }
    paramString = new k("Invalid float value: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(213275);
    throw paramString;
  }
  
  private void g(InputStream paramInputStream)
  {
    AppMethodBeat.i(213206);
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
        AppMethodBeat.o(213206);
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
        AppMethodBeat.o(213206);
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
      if (!this.aTW) {
        if (this.aTY)
        {
          if (this.aUa == null) {
            this.aUa = new StringBuilder(j);
          }
          this.aUa.append((char[])localObject, i, j);
        }
        else if (this.aUb)
        {
          if (this.aUc == null) {
            this.aUc = new StringBuilder(j);
          }
          this.aUc.append((char[])localObject, i, j);
        }
        else if ((this.aTV instanceof h.ay))
        {
          ad(new String((char[])localObject, i, j));
          continue;
          ac(localXmlPullParser.getText());
          continue;
          paramInputStream = new h(localXmlPullParser.getText());
          b(paramInputStream.nextToken(), a(paramInputStream));
          label466:
          while (i == 1)
          {
            Object localObject;
            int j;
            AppMethodBeat.o(213206);
            return;
          }
          switch (i)
          {
          }
        }
      }
    }
  }
  
  private void g(Attributes paramAttributes)
  {
    AppMethodBeat.i(213224);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213224);
      throw paramAttributes;
    }
    h.v localv = new h.v();
    localv.aSW = this.aTU;
    localv.aSX = this.aTV;
    a(localv, paramAttributes);
    b(localv, paramAttributes);
    a(localv, paramAttributes);
    a(localv, paramAttributes);
    a(localv, paramAttributes);
    this.aTV.a(localv);
    AppMethodBeat.o(213224);
  }
  
  private static int h(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(213284);
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
      paramFloat2 = i(f2, paramFloat1, f1 + 2.0F);
      paramFloat3 = i(f2, paramFloat1, f1);
      paramFloat1 = i(f2, paramFloat1, f1 - 2.0F);
      int i = T(paramFloat2 * 256.0F);
      int j = T(paramFloat3 * 256.0F);
      int k = T(paramFloat1 * 256.0F);
      AppMethodBeat.o(213284);
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
  
  private void h(Attributes paramAttributes)
  {
    AppMethodBeat.i(213226);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213226);
      throw paramAttributes;
    }
    h.ab localab = new h.ab();
    localab.aSW = this.aTU;
    localab.aSX = this.aTV;
    a(localab, paramAttributes);
    b(localab, paramAttributes);
    a(localab, paramAttributes);
    a(localab, paramAttributes);
    a(localab, paramAttributes);
    this.aTV.a(localab);
    AppMethodBeat.o(213226);
  }
  
  private static float i(float paramFloat1, float paramFloat2, float paramFloat3)
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
  
  private void i(Attributes paramAttributes)
  {
    AppMethodBeat.i(213228);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213228);
      throw paramAttributes;
    }
    h.d locald = new h.d();
    locald.aSW = this.aTU;
    locald.aSX = this.aTV;
    a(locald, paramAttributes);
    b(locald, paramAttributes);
    a(locald, paramAttributes);
    a(locald, paramAttributes);
    a(locald, paramAttributes);
    this.aTV.a(locald);
    AppMethodBeat.o(213228);
  }
  
  private void j(Attributes paramAttributes)
  {
    AppMethodBeat.i(213230);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213230);
      throw paramAttributes;
    }
    h.i locali = new h.i();
    locali.aSW = this.aTU;
    locali.aSX = this.aTV;
    a(locali, paramAttributes);
    b(locali, paramAttributes);
    a(locali, paramAttributes);
    a(locali, paramAttributes);
    a(locali, paramAttributes);
    this.aTV.a(locali);
    AppMethodBeat.o(213230);
  }
  
  private void k(Attributes paramAttributes)
  {
    AppMethodBeat.i(213232);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213232);
      throw paramAttributes;
    }
    h.q localq = new h.q();
    localq.aSW = this.aTU;
    localq.aSX = this.aTV;
    a(localq, paramAttributes);
    b(localq, paramAttributes);
    a(localq, paramAttributes);
    a(localq, paramAttributes);
    a(localq, paramAttributes);
    this.aTV.a(localq);
    AppMethodBeat.o(213232);
  }
  
  private void l(Attributes paramAttributes)
  {
    AppMethodBeat.i(213234);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213234);
      throw paramAttributes;
    }
    h.z localz = new h.z();
    localz.aSW = this.aTU;
    localz.aSX = this.aTV;
    a(localz, paramAttributes);
    b(localz, paramAttributes);
    a(localz, paramAttributes);
    a(localz, paramAttributes);
    a(localz, paramAttributes, "polyline");
    this.aTV.a(localz);
    AppMethodBeat.o(213234);
  }
  
  private void m(Attributes paramAttributes)
  {
    AppMethodBeat.i(213236);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213236);
      throw paramAttributes;
    }
    h.aa localaa = new h.aa();
    localaa.aSW = this.aTU;
    localaa.aSX = this.aTV;
    a(localaa, paramAttributes);
    b(localaa, paramAttributes);
    a(localaa, paramAttributes);
    a(localaa, paramAttributes);
    a(localaa, paramAttributes, "polygon");
    this.aTV.a(localaa);
    AppMethodBeat.o(213236);
  }
  
  private void n(Attributes paramAttributes)
  {
    AppMethodBeat.i(213237);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213237);
      throw paramAttributes;
    }
    h.aw localaw = new h.aw();
    localaw.aSW = this.aTU;
    localaw.aSX = this.aTV;
    a(localaw, paramAttributes);
    b(localaw, paramAttributes);
    a(localaw, paramAttributes);
    a(localaw, paramAttributes);
    a(localaw, paramAttributes);
    this.aTV.a(localaw);
    this.aTV = localaw;
    AppMethodBeat.o(213237);
  }
  
  private void o(Attributes paramAttributes)
  {
    AppMethodBeat.i(213239);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213239);
      throw paramAttributes;
    }
    if (!(this.aTV instanceof h.ay))
    {
      paramAttributes = new k("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
      AppMethodBeat.o(213239);
      throw paramAttributes;
    }
    h.av localav = new h.av();
    localav.aSW = this.aTU;
    localav.aSX = this.aTV;
    a(localav, paramAttributes);
    b(localav, paramAttributes);
    a(localav, paramAttributes);
    a(localav, paramAttributes);
    this.aTV.a(localav);
    this.aTV = localav;
    if ((localav.aSX instanceof h.bb))
    {
      localav.aTa = ((h.bb)localav.aSX);
      AppMethodBeat.o(213239);
      return;
    }
    localav.aTa = ((h.ax)localav.aSX).qX();
    AppMethodBeat.o(213239);
  }
  
  private void p(Attributes paramAttributes)
  {
    AppMethodBeat.i(213240);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213240);
      throw paramAttributes;
    }
    if (!(this.aTV instanceof h.ay))
    {
      paramAttributes = new k("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
      AppMethodBeat.o(213240);
      throw paramAttributes;
    }
    h.au localau = new h.au();
    localau.aSW = this.aTU;
    localau.aSX = this.aTV;
    a(localau, paramAttributes);
    b(localau, paramAttributes);
    a(localau, paramAttributes);
    a(localau, paramAttributes);
    this.aTV.a(localau);
    if ((localau.aSX instanceof h.bb))
    {
      localau.aTa = ((h.bb)localau.aSX);
      AppMethodBeat.o(213240);
      return;
    }
    localau.aTa = ((h.ax)localau.aSX).qX();
    AppMethodBeat.o(213240);
  }
  
  private static float parseFloat(String paramString)
  {
    AppMethodBeat.i(213274);
    int i = paramString.length();
    if (i == 0)
    {
      paramString = new k("Invalid float value (empty string)");
      AppMethodBeat.o(213274);
      throw paramString;
    }
    float f = g(paramString, i);
    AppMethodBeat.o(213274);
    return f;
  }
  
  private void q(Attributes paramAttributes)
  {
    AppMethodBeat.i(213242);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213242);
      throw paramAttributes;
    }
    h.as localas = new h.as();
    localas.aSW = this.aTU;
    localas.aSX = this.aTV;
    a(localas, paramAttributes);
    b(localas, paramAttributes);
    a(localas, paramAttributes);
    a(localas, paramAttributes);
    this.aTV.a(localas);
    this.aTV = localas;
    AppMethodBeat.o(213242);
  }
  
  private void r(Attributes paramAttributes)
  {
    AppMethodBeat.i(213244);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213244);
      throw paramAttributes;
    }
    h.at localat = new h.at();
    localat.aSW = this.aTU;
    localat.aSX = this.aTV;
    a(localat, paramAttributes);
    b(localat, paramAttributes);
    a(localat, paramAttributes);
    a(localat, paramAttributes);
    this.aTV.a(localat);
    this.aTV = localat;
    AppMethodBeat.o(213244);
  }
  
  private void s(Attributes paramAttributes)
  {
    AppMethodBeat.i(213245);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213245);
      throw paramAttributes;
    }
    h.r localr = new h.r();
    localr.aSW = this.aTU;
    localr.aSX = this.aTV;
    a(localr, paramAttributes);
    b(localr, paramAttributes);
    a(localr, paramAttributes);
    a(localr, paramAttributes);
    a(localr, paramAttributes);
    this.aTV.a(localr);
    this.aTV = localr;
    AppMethodBeat.o(213245);
  }
  
  private void t(Attributes paramAttributes)
  {
    AppMethodBeat.i(213247);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213247);
      throw paramAttributes;
    }
    h.am localam = new h.am();
    localam.aSW = this.aTU;
    localam.aSX = this.aTV;
    a(localam, paramAttributes);
    b(localam, paramAttributes);
    a(localam, paramAttributes);
    a(localam, paramAttributes);
    this.aTV.a(localam);
    this.aTV = localam;
    AppMethodBeat.o(213247);
  }
  
  private void u(Attributes paramAttributes)
  {
    AppMethodBeat.i(213250);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213250);
      throw paramAttributes;
    }
    h.aq localaq = new h.aq();
    localaq.aSW = this.aTU;
    localaq.aSX = this.aTV;
    a(localaq, paramAttributes);
    b(localaq, paramAttributes);
    a(localaq, paramAttributes);
    a(localaq, paramAttributes);
    this.aTV.a(localaq);
    this.aTV = localaq;
    AppMethodBeat.o(213250);
  }
  
  private void v(Attributes paramAttributes)
  {
    AppMethodBeat.i(213252);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213252);
      throw paramAttributes;
    }
    if (!(this.aTV instanceof h.j))
    {
      paramAttributes = new k("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
      AppMethodBeat.o(213252);
      throw paramAttributes;
    }
    h.ad localad = new h.ad();
    localad.aSW = this.aTU;
    localad.aSX = this.aTV;
    a(localad, paramAttributes);
    b(localad, paramAttributes);
    a(localad, paramAttributes);
    this.aTV.a(localad);
    this.aTV = localad;
    AppMethodBeat.o(213252);
  }
  
  private void w(Attributes paramAttributes)
  {
    AppMethodBeat.i(213255);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213255);
      throw paramAttributes;
    }
    h.ac localac = new h.ac();
    localac.aSW = this.aTU;
    localac.aSX = this.aTV;
    a(localac, paramAttributes);
    b(localac, paramAttributes);
    this.aTV.a(localac);
    this.aTV = localac;
    AppMethodBeat.o(213255);
  }
  
  private void x(Attributes paramAttributes)
  {
    AppMethodBeat.i(213256);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213256);
      throw paramAttributes;
    }
    h.e locale = new h.e();
    locale.aSW = this.aTU;
    locale.aSX = this.aTV;
    a(locale, paramAttributes);
    b(locale, paramAttributes);
    a(locale, paramAttributes);
    a(locale, paramAttributes);
    a(locale, paramAttributes);
    this.aTV.a(locale);
    this.aTV = locale;
    AppMethodBeat.o(213256);
  }
  
  private void y(Attributes paramAttributes)
  {
    AppMethodBeat.i(213258);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213258);
      throw paramAttributes;
    }
    h.az localaz = new h.az();
    localaz.aSW = this.aTU;
    localaz.aSX = this.aTV;
    a(localaz, paramAttributes);
    b(localaz, paramAttributes);
    a(localaz, paramAttributes);
    a(localaz, paramAttributes);
    this.aTV.a(localaz);
    this.aTV = localaz;
    if ((localaz.aSX instanceof h.bb))
    {
      localaz.aTa = ((h.bb)localaz.aSX);
      AppMethodBeat.o(213258);
      return;
    }
    localaz.aTa = ((h.ax)localaz.aSX).qX();
    AppMethodBeat.o(213258);
  }
  
  private void z(Attributes paramAttributes)
  {
    AppMethodBeat.i(213260);
    if (this.aTV == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(213260);
      throw paramAttributes;
    }
    h.y localy = new h.y();
    localy.aSW = this.aTU;
    localy.aSX = this.aTV;
    a(localy, paramAttributes);
    b(localy, paramAttributes);
    a(localy, paramAttributes);
    a(localy, paramAttributes);
    a(localy, paramAttributes);
    this.aTV.a(localy);
    this.aTV = localy;
    AppMethodBeat.o(213260);
  }
  
  /* Error */
  final h a(InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 2019
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 2024	java/io/InputStream:markSupported	()Z
    //   10: ifne +381 -> 391
    //   13: new 2026	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 2028	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: iconst_3
    //   24: invokevirtual 2031	java/io/InputStream:mark	(I)V
    //   27: aload_1
    //   28: invokevirtual 2034	java/io/InputStream:read	()I
    //   31: istore_3
    //   32: aload_1
    //   33: invokevirtual 2034	java/io/InputStream:read	()I
    //   36: istore 4
    //   38: aload_1
    //   39: invokevirtual 2037	java/io/InputStream:reset	()V
    //   42: iload_3
    //   43: iload 4
    //   45: bipush 8
    //   47: ishl
    //   48: iadd
    //   49: ldc_w 2038
    //   52: if_icmpne +336 -> 388
    //   55: new 2026	java/io/BufferedInputStream
    //   58: dup
    //   59: new 2040	java/util/zip/GZIPInputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 2041	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: invokespecial 2028	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore 5
    //   72: aload 5
    //   74: astore_1
    //   75: iload_2
    //   76: ifeq +267 -> 343
    //   79: aload_1
    //   80: sipush 4096
    //   83: invokevirtual 2031	java/io/InputStream:mark	(I)V
    //   86: sipush 4096
    //   89: newarray byte
    //   91: astore 5
    //   93: new 137	java/lang/String
    //   96: dup
    //   97: aload 5
    //   99: iconst_0
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 2044	java/io/InputStream:read	([B)I
    //   106: invokespecial 2047	java/lang/String:<init>	([BII)V
    //   109: astore 5
    //   111: aload_1
    //   112: invokevirtual 2037	java/io/InputStream:reset	()V
    //   115: aload 5
    //   117: ldc_w 2049
    //   120: invokevirtual 1474	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   123: istore_3
    //   124: iload_3
    //   125: iflt +218 -> 343
    //   128: invokestatic 2055	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   131: astore 5
    //   133: aload 5
    //   135: ldc_w 2057
    //   138: iconst_0
    //   139: invokevirtual 2058	javax/xml/parsers/SAXParserFactory:setFeature	(Ljava/lang/String;Z)V
    //   142: aload 5
    //   144: ldc_w 2060
    //   147: iconst_0
    //   148: invokevirtual 2058	javax/xml/parsers/SAXParserFactory:setFeature	(Ljava/lang/String;Z)V
    //   151: aload 5
    //   153: invokevirtual 2064	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   156: invokevirtual 2070	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   159: astore 5
    //   161: new 19	com/a/a/l$e
    //   164: dup
    //   165: aload_0
    //   166: iconst_0
    //   167: invokespecial 2073	com/a/a/l$e:<init>	(Lcom/a/a/l;B)V
    //   170: astore 6
    //   172: aload 5
    //   174: aload 6
    //   176: invokeinterface 2079 2 0
    //   181: aload 5
    //   183: ldc_w 2081
    //   186: aload 6
    //   188: invokeinterface 2085 3 0
    //   193: aload 5
    //   195: new 2087	org/xml/sax/InputSource
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 2088	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   203: invokeinterface 2092 2 0
    //   208: aload_0
    //   209: getfield 52	com/a/a/l:aTU	Lcom/a/a/h;
    //   212: astore 5
    //   214: aload_1
    //   215: invokevirtual 2095	java/io/InputStream:close	()V
    //   218: ldc_w 2019
    //   221: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload 5
    //   226: areturn
    //   227: astore 5
    //   229: new 78	com/a/a/k
    //   232: dup
    //   233: ldc_w 1793
    //   236: aload 5
    //   238: invokespecial 1320	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   241: astore 5
    //   243: ldc_w 2019
    //   246: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload 5
    //   251: athrow
    //   252: astore 5
    //   254: aload_0
    //   255: aload_1
    //   256: invokespecial 2097	com/a/a/l:g	(Ljava/io/InputStream;)V
    //   259: aload_0
    //   260: getfield 52	com/a/a/l:aTU	Lcom/a/a/h;
    //   263: astore 5
    //   265: aload_1
    //   266: invokevirtual 2095	java/io/InputStream:close	()V
    //   269: ldc_w 2019
    //   272: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload 5
    //   277: areturn
    //   278: astore 5
    //   280: new 78	com/a/a/k
    //   283: dup
    //   284: ldc_w 2099
    //   287: aload 5
    //   289: invokespecial 1320	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   292: astore 5
    //   294: ldc_w 2019
    //   297: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: aload 5
    //   302: athrow
    //   303: astore 5
    //   305: aload_1
    //   306: invokevirtual 2095	java/io/InputStream:close	()V
    //   309: ldc_w 2019
    //   312: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload 5
    //   317: athrow
    //   318: astore 5
    //   320: new 78	com/a/a/k
    //   323: dup
    //   324: ldc_w 1808
    //   327: aload 5
    //   329: invokespecial 1320	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   332: astore 5
    //   334: ldc_w 2019
    //   337: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload 5
    //   342: athrow
    //   343: aload_0
    //   344: aload_1
    //   345: invokespecial 2097	com/a/a/l:g	(Ljava/io/InputStream;)V
    //   348: aload_0
    //   349: getfield 52	com/a/a/l:aTU	Lcom/a/a/h;
    //   352: astore 5
    //   354: aload_1
    //   355: invokevirtual 2095	java/io/InputStream:close	()V
    //   358: ldc_w 2019
    //   361: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  final void ac(String paramString)
  {
    AppMethodBeat.i(213209);
    if (this.aTW)
    {
      AppMethodBeat.o(213209);
      return;
    }
    if (this.aTY)
    {
      if (this.aUa == null) {
        this.aUa = new StringBuilder(paramString.length());
      }
      this.aUa.append(paramString);
      AppMethodBeat.o(213209);
      return;
    }
    if (this.aUb)
    {
      if (this.aUc == null) {
        this.aUc = new StringBuilder(paramString.length());
      }
      this.aUc.append(paramString);
      AppMethodBeat.o(213209);
      return;
    }
    if ((this.aTV instanceof h.ay)) {
      ad(paramString);
    }
    AppMethodBeat.o(213209);
  }
  
  final void endElement(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213211);
    if (this.aTW)
    {
      int i = this.aTX - 1;
      this.aTX = i;
      if (i == 0) {
        this.aTW = false;
      }
      AppMethodBeat.o(213211);
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1)))
    {
      AppMethodBeat.o(213211);
      return;
    }
    if (paramString2.length() > 0) {
      switch (1.aUd[g.aN(paramString2).ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(213211);
      return;
      paramString2 = paramString3;
      break;
      this.aTY = false;
      if (this.aUa != null)
      {
        if (this.aTZ != g.aWz) {
          break label291;
        }
        this.aTU.title = this.aUa.toString();
      }
      for (;;)
      {
        this.aUa.setLength(0);
        AppMethodBeat.o(213211);
        return;
        label291:
        if (this.aTZ == g.aWe) {
          this.aTU.desc = this.aUa.toString();
        }
      }
      if (this.aUc != null)
      {
        this.aUb = false;
        aI(this.aUc.toString());
        this.aUc.setLength(0);
        AppMethodBeat.o(213211);
        return;
        if (this.aTV == null)
        {
          paramString1 = new k(String.format("Unbalanced end element </%s> found", new Object[] { paramString2 }));
          AppMethodBeat.o(213211);
          throw paramString1;
        }
        this.aTV = ((h.an)this.aTV).aSX;
      }
    }
  }
  
  final void startDocument()
  {
    AppMethodBeat.i(213207);
    this.aTU = new h();
    AppMethodBeat.o(213207);
  }
  
  final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    AppMethodBeat.i(213208);
    if (this.aTW)
    {
      this.aTX += 1;
      AppMethodBeat.o(213208);
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1)))
    {
      AppMethodBeat.o(213208);
      return;
    }
    if (paramString2.length() > 0) {}
    for (;;)
    {
      paramString1 = g.aN(paramString2);
      switch (1.aUd[paramString1.ordinal()])
      {
      default: 
        this.aTW = true;
        this.aTX = 1;
        AppMethodBeat.o(213208);
        return;
        paramString2 = paramString3;
      }
    }
    a(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    b(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    c(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    d(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    e(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    g(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    h(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    i(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    j(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    k(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    l(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    m(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    n(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    o(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    p(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    q(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    r(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    s(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    t(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    u(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    v(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    this.aTY = true;
    this.aTZ = paramString1;
    AppMethodBeat.o(213208);
    return;
    x(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    y(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    z(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    f(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    A(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    B(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    C(paramAttributes);
    AppMethodBeat.o(213208);
    return;
    w(paramAttributes);
    AppMethodBeat.o(213208);
  }
  
  static final class a
  {
    private static final Map<String, f.a> aUf;
    
    static
    {
      AppMethodBeat.i(213156);
      HashMap localHashMap = new HashMap(10);
      aUf = localHashMap;
      localHashMap.put("none", f.a.aPR);
      aUf.put("xMinYMin", f.a.aPS);
      aUf.put("xMidYMin", f.a.aPT);
      aUf.put("xMaxYMin", f.a.aPU);
      aUf.put("xMinYMid", f.a.aPV);
      aUf.put("xMidYMid", f.a.aPW);
      aUf.put("xMaxYMid", f.a.aPX);
      aUf.put("xMinYMax", f.a.aPY);
      aUf.put("xMidYMax", f.a.aPZ);
      aUf.put("xMaxYMax", f.a.aQa);
      AppMethodBeat.o(213156);
    }
    
    static f.a aJ(String paramString)
    {
      AppMethodBeat.i(213155);
      paramString = (f.a)aUf.get(paramString);
      AppMethodBeat.o(213155);
      return paramString;
    }
  }
  
  static final class b
  {
    private static final Map<String, Integer> aUg;
    
    static
    {
      AppMethodBeat.i(213158);
      HashMap localHashMap = new HashMap(47);
      aUg = localHashMap;
      localHashMap.put("aliceblue", Integer.valueOf(-984833));
      aUg.put("antiquewhite", Integer.valueOf(-332841));
      aUg.put("aqua", Integer.valueOf(-16711681));
      aUg.put("aquamarine", Integer.valueOf(-8388652));
      aUg.put("azure", Integer.valueOf(-983041));
      aUg.put("beige", Integer.valueOf(-657956));
      aUg.put("bisque", Integer.valueOf(-6972));
      aUg.put("black", Integer.valueOf(-16777216));
      aUg.put("blanchedalmond", Integer.valueOf(-5171));
      aUg.put("blue", Integer.valueOf(-16776961));
      aUg.put("blueviolet", Integer.valueOf(-7722014));
      aUg.put("brown", Integer.valueOf(-5952982));
      aUg.put("burlywood", Integer.valueOf(-2180985));
      aUg.put("cadetblue", Integer.valueOf(-10510688));
      aUg.put("chartreuse", Integer.valueOf(-8388864));
      aUg.put("chocolate", Integer.valueOf(-2987746));
      aUg.put("coral", Integer.valueOf(-32944));
      aUg.put("cornflowerblue", Integer.valueOf(-10185235));
      aUg.put("cornsilk", Integer.valueOf(-1828));
      aUg.put("crimson", Integer.valueOf(-2354116));
      aUg.put("cyan", Integer.valueOf(-16711681));
      aUg.put("darkblue", Integer.valueOf(-16777077));
      aUg.put("darkcyan", Integer.valueOf(-16741493));
      aUg.put("darkgoldenrod", Integer.valueOf(-4684277));
      aUg.put("darkgray", Integer.valueOf(-5658199));
      aUg.put("darkgreen", Integer.valueOf(-16751616));
      aUg.put("darkgrey", Integer.valueOf(-5658199));
      aUg.put("darkkhaki", Integer.valueOf(-4343957));
      aUg.put("darkmagenta", Integer.valueOf(-7667573));
      aUg.put("darkolivegreen", Integer.valueOf(-11179217));
      aUg.put("darkorange", Integer.valueOf(-29696));
      aUg.put("darkorchid", Integer.valueOf(-6737204));
      aUg.put("darkred", Integer.valueOf(-7667712));
      aUg.put("darksalmon", Integer.valueOf(-1468806));
      aUg.put("darkseagreen", Integer.valueOf(-7357297));
      aUg.put("darkslateblue", Integer.valueOf(-12042869));
      aUg.put("darkslategray", Integer.valueOf(-13676721));
      aUg.put("darkslategrey", Integer.valueOf(-13676721));
      aUg.put("darkturquoise", Integer.valueOf(-16724271));
      aUg.put("darkviolet", Integer.valueOf(-7077677));
      aUg.put("deeppink", Integer.valueOf(-60269));
      aUg.put("deepskyblue", Integer.valueOf(-16728065));
      aUg.put("dimgray", Integer.valueOf(-9868951));
      aUg.put("dimgrey", Integer.valueOf(-9868951));
      aUg.put("dodgerblue", Integer.valueOf(-14774017));
      aUg.put("firebrick", Integer.valueOf(-5103070));
      aUg.put("floralwhite", Integer.valueOf(-1296));
      aUg.put("forestgreen", Integer.valueOf(-14513374));
      aUg.put("fuchsia", Integer.valueOf(-65281));
      aUg.put("gainsboro", Integer.valueOf(-2302756));
      aUg.put("ghostwhite", Integer.valueOf(-460545));
      aUg.put("gold", Integer.valueOf(-10496));
      aUg.put("goldenrod", Integer.valueOf(-2448096));
      aUg.put("gray", Integer.valueOf(-8355712));
      aUg.put("green", Integer.valueOf(-16744448));
      aUg.put("greenyellow", Integer.valueOf(-5374161));
      aUg.put("grey", Integer.valueOf(-8355712));
      aUg.put("honeydew", Integer.valueOf(-983056));
      aUg.put("hotpink", Integer.valueOf(-38476));
      aUg.put("indianred", Integer.valueOf(-3318692));
      aUg.put("indigo", Integer.valueOf(-11861886));
      aUg.put("ivory", Integer.valueOf(-16));
      aUg.put("khaki", Integer.valueOf(-989556));
      aUg.put("lavender", Integer.valueOf(-1644806));
      aUg.put("lavenderblush", Integer.valueOf(-3851));
      aUg.put("lawngreen", Integer.valueOf(-8586240));
      aUg.put("lemonchiffon", Integer.valueOf(-1331));
      aUg.put("lightblue", Integer.valueOf(-5383962));
      aUg.put("lightcoral", Integer.valueOf(-1015680));
      aUg.put("lightcyan", Integer.valueOf(-2031617));
      aUg.put("lightgoldenrodyellow", Integer.valueOf(-329006));
      aUg.put("lightgray", Integer.valueOf(-2894893));
      aUg.put("lightgreen", Integer.valueOf(-7278960));
      aUg.put("lightgrey", Integer.valueOf(-2894893));
      aUg.put("lightpink", Integer.valueOf(-18751));
      aUg.put("lightsalmon", Integer.valueOf(-24454));
      aUg.put("lightseagreen", Integer.valueOf(-14634326));
      aUg.put("lightskyblue", Integer.valueOf(-7876870));
      aUg.put("lightslategray", Integer.valueOf(-8943463));
      aUg.put("lightslategrey", Integer.valueOf(-8943463));
      aUg.put("lightsteelblue", Integer.valueOf(-5192482));
      aUg.put("lightyellow", Integer.valueOf(-32));
      aUg.put("lime", Integer.valueOf(-16711936));
      aUg.put("limegreen", Integer.valueOf(-13447886));
      aUg.put("linen", Integer.valueOf(-331546));
      aUg.put("magenta", Integer.valueOf(-65281));
      aUg.put("maroon", Integer.valueOf(-8388608));
      aUg.put("mediumaquamarine", Integer.valueOf(-10039894));
      aUg.put("mediumblue", Integer.valueOf(-16777011));
      aUg.put("mediumorchid", Integer.valueOf(-4565549));
      aUg.put("mediumpurple", Integer.valueOf(-7114533));
      aUg.put("mediumseagreen", Integer.valueOf(-12799119));
      aUg.put("mediumslateblue", Integer.valueOf(-8689426));
      aUg.put("mediumspringgreen", Integer.valueOf(-16713062));
      aUg.put("mediumturquoise", Integer.valueOf(-12004916));
      aUg.put("mediumvioletred", Integer.valueOf(-3730043));
      aUg.put("midnightblue", Integer.valueOf(-15132304));
      aUg.put("mintcream", Integer.valueOf(-655366));
      aUg.put("mistyrose", Integer.valueOf(-6943));
      aUg.put("moccasin", Integer.valueOf(-6987));
      aUg.put("navajowhite", Integer.valueOf(-8531));
      aUg.put("navy", Integer.valueOf(-16777088));
      aUg.put("oldlace", Integer.valueOf(-133658));
      aUg.put("olive", Integer.valueOf(-8355840));
      aUg.put("olivedrab", Integer.valueOf(-9728477));
      aUg.put("orange", Integer.valueOf(-23296));
      aUg.put("orangered", Integer.valueOf(-47872));
      aUg.put("orchid", Integer.valueOf(-2461482));
      aUg.put("palegoldenrod", Integer.valueOf(-1120086));
      aUg.put("palegreen", Integer.valueOf(-6751336));
      aUg.put("paleturquoise", Integer.valueOf(-5247250));
      aUg.put("palevioletred", Integer.valueOf(-2396013));
      aUg.put("papayawhip", Integer.valueOf(-4139));
      aUg.put("peachpuff", Integer.valueOf(-9543));
      aUg.put("peru", Integer.valueOf(-3308225));
      aUg.put("pink", Integer.valueOf(-16181));
      aUg.put("plum", Integer.valueOf(-2252579));
      aUg.put("powderblue", Integer.valueOf(-5185306));
      aUg.put("purple", Integer.valueOf(-8388480));
      aUg.put("rebeccapurple", Integer.valueOf(-10079335));
      aUg.put("red", Integer.valueOf(-65536));
      aUg.put("rosybrown", Integer.valueOf(-4419697));
      aUg.put("royalblue", Integer.valueOf(-12490271));
      aUg.put("saddlebrown", Integer.valueOf(-7650029));
      aUg.put("salmon", Integer.valueOf(-360334));
      aUg.put("sandybrown", Integer.valueOf(-744352));
      aUg.put("seagreen", Integer.valueOf(-13726889));
      aUg.put("seashell", Integer.valueOf(-2578));
      aUg.put("sienna", Integer.valueOf(-6270419));
      aUg.put("silver", Integer.valueOf(-4144960));
      aUg.put("skyblue", Integer.valueOf(-7876885));
      aUg.put("slateblue", Integer.valueOf(-9807155));
      aUg.put("slategray", Integer.valueOf(-9404272));
      aUg.put("slategrey", Integer.valueOf(-9404272));
      aUg.put("snow", Integer.valueOf(-1286));
      aUg.put("springgreen", Integer.valueOf(-16711809));
      aUg.put("steelblue", Integer.valueOf(-12156236));
      aUg.put("tan", Integer.valueOf(-2968436));
      aUg.put("teal", Integer.valueOf(-16744320));
      aUg.put("thistle", Integer.valueOf(-2572328));
      aUg.put("tomato", Integer.valueOf(-40121));
      aUg.put("turquoise", Integer.valueOf(-12525360));
      aUg.put("violet", Integer.valueOf(-1146130));
      aUg.put("wheat", Integer.valueOf(-663885));
      aUg.put("white", Integer.valueOf(-1));
      aUg.put("whitesmoke", Integer.valueOf(-657931));
      aUg.put("yellow", Integer.valueOf(-256));
      aUg.put("yellowgreen", Integer.valueOf(-6632142));
      aUg.put("transparent", Integer.valueOf(0));
      AppMethodBeat.o(213158);
    }
    
    static Integer aK(String paramString)
    {
      AppMethodBeat.i(213157);
      paramString = (Integer)aUg.get(paramString);
      AppMethodBeat.o(213157);
      return paramString;
    }
  }
  
  static final class c
  {
    private static final Map<String, h.p> aUh;
    
    static
    {
      AppMethodBeat.i(213160);
      HashMap localHashMap = new HashMap(9);
      aUh = localHashMap;
      localHashMap.put("xx-small", new h.p(0.694F, h.bd.aTm));
      aUh.put("x-small", new h.p(0.833F, h.bd.aTm));
      aUh.put("small", new h.p(10.0F, h.bd.aTm));
      aUh.put("medium", new h.p(12.0F, h.bd.aTm));
      aUh.put("large", new h.p(14.4F, h.bd.aTm));
      aUh.put("x-large", new h.p(17.299999F, h.bd.aTm));
      aUh.put("xx-large", new h.p(20.700001F, h.bd.aTm));
      aUh.put("smaller", new h.p(83.330002F, h.bd.aTo));
      aUh.put("larger", new h.p(120.0F, h.bd.aTo));
      AppMethodBeat.o(213160);
    }
    
    static h.p aL(String paramString)
    {
      AppMethodBeat.i(213159);
      paramString = (h.p)aUh.get(paramString);
      AppMethodBeat.o(213159);
      return paramString;
    }
  }
  
  final class e
    extends DefaultHandler2
  {
    private e() {}
    
    public final void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(213165);
      l.this.ac(new String(paramArrayOfChar, paramInt1, paramInt2));
      AppMethodBeat.o(213165);
    }
    
    public final void endDocument() {}
    
    public final void endElement(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(213166);
      l.this.endElement(paramString1, paramString2, paramString3);
      AppMethodBeat.o(213166);
    }
    
    public final void processingInstruction(String paramString1, String paramString2)
    {
      AppMethodBeat.i(213167);
      l.b(paramString1, l.a(new l.h(paramString2)));
      AppMethodBeat.o(213167);
    }
    
    public final void startDocument()
    {
      AppMethodBeat.i(213163);
      l.this.startDocument();
      AppMethodBeat.o(213163);
    }
    
    public final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    {
      AppMethodBeat.i(213164);
      l.this.startElement(paramString1, paramString2, paramString3, paramAttributes);
      AppMethodBeat.o(213164);
    }
  }
  
  static enum f
  {
    private static final Map<String, f> aOa;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(213171);
      aUk = new f("CLASS", 0);
      aUl = new f("clip", 1);
      aUm = new f("clip_path", 2);
      aUn = new f("clipPathUnits", 3);
      aUo = new f("clip_rule", 4);
      aUp = new f("color", 5);
      aUq = new f("cx", 6);
      aUr = new f("cy", 7);
      aUs = new f("direction", 8);
      aUt = new f("dx", 9);
      aUu = new f("dy", 10);
      aUv = new f("fx", 11);
      aUw = new f("fy", 12);
      aUx = new f("d", 13);
      aUy = new f("display", 14);
      aUz = new f("fill", 15);
      aUA = new f("fill_rule", 16);
      aUB = new f("fill_opacity", 17);
      aUC = new f("font", 18);
      aUD = new f("font_family", 19);
      aUE = new f("font_size", 20);
      aUF = new f("font_weight", 21);
      aUG = new f("font_style", 22);
      aUH = new f("gradientTransform", 23);
      aUI = new f("gradientUnits", 24);
      aUJ = new f("height", 25);
      aUK = new f("href", 26);
      aUL = new f("image_rendering", 27);
      aUM = new f("marker", 28);
      aUN = new f("marker_start", 29);
      aUO = new f("marker_mid", 30);
      aUP = new f("marker_end", 31);
      aUQ = new f("markerHeight", 32);
      aUR = new f("markerUnits", 33);
      aUS = new f("markerWidth", 34);
      aUT = new f("mask", 35);
      aUU = new f("maskContentUnits", 36);
      aUV = new f("maskUnits", 37);
      aUW = new f("media", 38);
      aUX = new f("offset", 39);
      aUY = new f("opacity", 40);
      aUZ = new f("orient", 41);
      aVa = new f("overflow", 42);
      aVb = new f("pathLength", 43);
      aVc = new f("patternContentUnits", 44);
      aVd = new f("patternTransform", 45);
      aVe = new f("patternUnits", 46);
      aVf = new f("points", 47);
      aVg = new f("preserveAspectRatio", 48);
      aVh = new f("r", 49);
      aVi = new f("refX", 50);
      aVj = new f("refY", 51);
      aVk = new f("requiredFeatures", 52);
      aVl = new f("requiredExtensions", 53);
      aVm = new f("requiredFormats", 54);
      aVn = new f("requiredFonts", 55);
      aVo = new f("rx", 56);
      aVp = new f("ry", 57);
      aVq = new f("solid_color", 58);
      aVr = new f("solid_opacity", 59);
      aVs = new f("spreadMethod", 60);
      aVt = new f("startOffset", 61);
      aVu = new f("stop_color", 62);
      aVv = new f("stop_opacity", 63);
      aVw = new f("stroke", 64);
      aVx = new f("stroke_dasharray", 65);
      aVy = new f("stroke_dashoffset", 66);
      aVz = new f("stroke_linecap", 67);
      aVA = new f("stroke_linejoin", 68);
      aVB = new f("stroke_miterlimit", 69);
      aVC = new f("stroke_opacity", 70);
      aVD = new f("stroke_width", 71);
      aVE = new f("style", 72);
      aVF = new f("systemLanguage", 73);
      aVG = new f("text_anchor", 74);
      aVH = new f("text_decoration", 75);
      aVI = new f("transform", 76);
      aVJ = new f("type", 77);
      aVK = new f("vector_effect", 78);
      aVL = new f("version", 79);
      aVM = new f("viewBox", 80);
      aVN = new f("width", 81);
      aVO = new f("x", 82);
      aVP = new f("y", 83);
      aVQ = new f("x1", 84);
      aVR = new f("y1", 85);
      aVS = new f("x2", 86);
      aVT = new f("y2", 87);
      aVU = new f("viewport_fill", 88);
      aVV = new f("viewport_fill_opacity", 89);
      aVW = new f("visibility", 90);
      aVX = new f("UNSUPPORTED", 91);
      aVY = new f[] { aUk, aUl, aUm, aUn, aUo, aUp, aUq, aUr, aUs, aUt, aUu, aUv, aUw, aUx, aUy, aUz, aUA, aUB, aUC, aUD, aUE, aUF, aUG, aUH, aUI, aUJ, aUK, aUL, aUM, aUN, aUO, aUP, aUQ, aUR, aUS, aUT, aUU, aUV, aUW, aUX, aUY, aUZ, aVa, aVb, aVc, aVd, aVe, aVf, aVg, aVh, aVi, aVj, aVk, aVl, aVm, aVn, aVo, aVp, aVq, aVr, aVs, aVt, aVu, aVv, aVw, aVx, aVy, aVz, aVA, aVB, aVC, aVD, aVE, aVF, aVG, aVH, aVI, aVJ, aVK, aVL, aVM, aVN, aVO, aVP, aVQ, aVR, aVS, aVT, aVU, aVV, aVW, aVX };
      aOa = new HashMap();
      f[] arrayOff = values();
      int j = arrayOff.length;
      if (i < j)
      {
        f localf = arrayOff[i];
        if (localf == aUk) {
          aOa.put("class", localf);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localf != aVX)
          {
            String str = localf.name().replace('_', '-');
            aOa.put(str, localf);
          }
        }
      }
      AppMethodBeat.o(213171);
    }
    
    private f() {}
    
    public static f aM(String paramString)
    {
      AppMethodBeat.i(213170);
      paramString = (f)aOa.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(213170);
        return paramString;
      }
      paramString = aVX;
      AppMethodBeat.o(213170);
      return paramString;
    }
  }
  
  static enum g
  {
    private static final Map<String, g> aOa;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(213175);
      aVZ = new g("svg", 0);
      aWa = new g("a", 1);
      aWb = new g("circle", 2);
      aWc = new g("clipPath", 3);
      aWd = new g("defs", 4);
      aWe = new g("desc", 5);
      aWf = new g("ellipse", 6);
      aWg = new g("g", 7);
      aWh = new g("image", 8);
      aWi = new g("line", 9);
      aWj = new g("linearGradient", 10);
      aWk = new g("marker", 11);
      aWl = new g("mask", 12);
      aWm = new g("path", 13);
      aWn = new g("pattern", 14);
      aWo = new g("polygon", 15);
      aWp = new g("polyline", 16);
      aWq = new g("radialGradient", 17);
      aWr = new g("rect", 18);
      aWs = new g("solidColor", 19);
      aWt = new g("stop", 20);
      aWu = new g("style", 21);
      aWv = new g("SWITCH", 22);
      aWw = new g("symbol", 23);
      aWx = new g("text", 24);
      aWy = new g("textPath", 25);
      aWz = new g("title", 26);
      aWA = new g("tref", 27);
      aWB = new g("tspan", 28);
      aWC = new g("use", 29);
      aWD = new g("view", 30);
      aWE = new g("UNSUPPORTED", 31);
      aWF = new g[] { aVZ, aWa, aWb, aWc, aWd, aWe, aWf, aWg, aWh, aWi, aWj, aWk, aWl, aWm, aWn, aWo, aWp, aWq, aWr, aWs, aWt, aWu, aWv, aWw, aWx, aWy, aWz, aWA, aWB, aWC, aWD, aWE };
      aOa = new HashMap();
      g[] arrayOfg = values();
      int j = arrayOfg.length;
      if (i < j)
      {
        g localg = arrayOfg[i];
        if (localg == aWv) {
          aOa.put("switch", localg);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localg != aWE)
          {
            String str = localg.name();
            aOa.put(str, localg);
          }
        }
      }
      AppMethodBeat.o(213175);
    }
    
    private g() {}
    
    public static g aN(String paramString)
    {
      AppMethodBeat.i(213174);
      paramString = (g)aOa.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(213174);
        return paramString;
      }
      paramString = aWE;
      AppMethodBeat.o(213174);
      return paramString;
    }
  }
  
  static class h
  {
    String aWG;
    int aWH;
    private e aWI;
    int position;
    
    h(String paramString)
    {
      AppMethodBeat.i(213176);
      this.position = 0;
      this.aWH = 0;
      this.aWI = new e();
      this.aWG = paramString.trim();
      this.aWH = this.aWG.length();
      AppMethodBeat.o(213176);
    }
    
    static boolean dB(int paramInt)
    {
      return (paramInt == 10) || (paramInt == 13);
    }
    
    static boolean isWhitespace(int paramInt)
    {
      return (paramInt == 32) || (paramInt == 10) || (paramInt == 13) || (paramInt == 9);
    }
    
    private Boolean ru()
    {
      AppMethodBeat.i(213185);
      if (this.position == this.aWH)
      {
        AppMethodBeat.o(213185);
        return null;
      }
      int i = this.aWG.charAt(this.position);
      if ((i == 48) || (i == 49))
      {
        this.position += 1;
        if (i == 49) {}
        for (boolean bool = true;; bool = false)
        {
          AppMethodBeat.o(213185);
          return Boolean.valueOf(bool);
        }
      }
      AppMethodBeat.o(213185);
      return null;
    }
    
    final float U(float paramFloat)
    {
      AppMethodBeat.i(213181);
      if (Float.isNaN(paramFloat))
      {
        AppMethodBeat.o(213181);
        return (0.0F / 0.0F);
      }
      rq();
      paramFloat = nextFloat();
      AppMethodBeat.o(213181);
      return paramFloat;
    }
    
    final float a(Boolean paramBoolean)
    {
      AppMethodBeat.i(213182);
      if (paramBoolean == null)
      {
        AppMethodBeat.o(213182);
        return (0.0F / 0.0F);
      }
      rq();
      float f = nextFloat();
      AppMethodBeat.o(213182);
      return f;
    }
    
    final String a(char paramChar, boolean paramBoolean)
    {
      AppMethodBeat.i(213192);
      if (empty())
      {
        AppMethodBeat.o(213192);
        return null;
      }
      char c = this.aWG.charAt(this.position);
      if (((!paramBoolean) && (isWhitespace(c))) || (c == paramChar))
      {
        AppMethodBeat.o(213192);
        return null;
      }
      int i = this.position;
      for (c = rv(); (c != 'ð¿¿') && (c != paramChar) && ((paramBoolean) || (!isWhitespace(c))); c = rv()) {}
      String str = this.aWG.substring(i, this.position);
      AppMethodBeat.o(213192);
      return str;
    }
    
    final boolean aO(String paramString)
    {
      AppMethodBeat.i(213188);
      int i = paramString.length();
      if ((this.position <= this.aWH - i) && (this.aWG.substring(this.position, this.position + i).equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.position = (i + this.position);
        }
        AppMethodBeat.o(213188);
        return bool;
      }
    }
    
    final Boolean ab(Object paramObject)
    {
      AppMethodBeat.i(213186);
      if (paramObject == null)
      {
        AppMethodBeat.o(213186);
        return null;
      }
      rq();
      paramObject = ru();
      AppMethodBeat.o(213186);
      return paramObject;
    }
    
    final boolean b(char paramChar)
    {
      AppMethodBeat.i(213187);
      if ((this.position < this.aWH) && (this.aWG.charAt(this.position) == paramChar)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.position += 1;
        }
        AppMethodBeat.o(213187);
        return bool;
      }
    }
    
    final String c(char paramChar)
    {
      AppMethodBeat.i(213191);
      String str = a(paramChar, false);
      AppMethodBeat.o(213191);
      return str;
    }
    
    final boolean empty()
    {
      return this.position == this.aWH;
    }
    
    final float nextFloat()
    {
      AppMethodBeat.i(213179);
      float f = this.aWI.f(this.aWG, this.position, this.aWH);
      if (!Float.isNaN(f)) {
        this.position = this.aWI.pos;
      }
      AppMethodBeat.o(213179);
      return f;
    }
    
    final String nextToken()
    {
      AppMethodBeat.i(224177);
      String str = a(' ', false);
      AppMethodBeat.o(224177);
      return str;
    }
    
    final boolean rA()
    {
      AppMethodBeat.i(213197);
      if (this.position == this.aWH)
      {
        AppMethodBeat.o(213197);
        return false;
      }
      int i = this.aWG.charAt(this.position);
      if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
      {
        AppMethodBeat.o(213197);
        return true;
      }
      AppMethodBeat.o(213197);
      return false;
    }
    
    final String rB()
    {
      AppMethodBeat.i(213198);
      if (empty())
      {
        AppMethodBeat.o(213198);
        return null;
      }
      int i = this.position;
      int j = this.aWG.charAt(this.position);
      if ((j != 39) && (j != 34))
      {
        AppMethodBeat.o(213198);
        return null;
      }
      int k;
      do
      {
        k = rv();
      } while ((k != -1) && (k != j));
      if (k == -1)
      {
        this.position = i;
        AppMethodBeat.o(213198);
        return null;
      }
      this.position += 1;
      String str = this.aWG.substring(i + 1, this.position - 1);
      AppMethodBeat.o(213198);
      return str;
    }
    
    final String rC()
    {
      AppMethodBeat.i(213199);
      if (empty())
      {
        AppMethodBeat.o(213199);
        return null;
      }
      int i = this.position;
      this.position = this.aWH;
      String str = this.aWG.substring(i);
      AppMethodBeat.o(213199);
      return str;
    }
    
    final void rp()
    {
      AppMethodBeat.i(213177);
      while ((this.position < this.aWH) && (isWhitespace(this.aWG.charAt(this.position)))) {
        this.position += 1;
      }
      AppMethodBeat.o(213177);
    }
    
    final boolean rq()
    {
      AppMethodBeat.i(213178);
      rp();
      if (this.position == this.aWH)
      {
        AppMethodBeat.o(213178);
        return false;
      }
      if (this.aWG.charAt(this.position) != ',')
      {
        AppMethodBeat.o(213178);
        return false;
      }
      this.position += 1;
      rp();
      AppMethodBeat.o(213178);
      return true;
    }
    
    final float rr()
    {
      AppMethodBeat.i(213180);
      rq();
      float f = this.aWI.f(this.aWG, this.position, this.aWH);
      if (!Float.isNaN(f)) {
        this.position = this.aWI.pos;
      }
      AppMethodBeat.o(213180);
      return f;
    }
    
    final Integer rs()
    {
      AppMethodBeat.i(213183);
      if (this.position == this.aWH)
      {
        AppMethodBeat.o(213183);
        return null;
      }
      String str = this.aWG;
      int i = this.position;
      this.position = (i + 1);
      i = str.charAt(i);
      AppMethodBeat.o(213183);
      return Integer.valueOf(i);
    }
    
    final h.p rt()
    {
      AppMethodBeat.i(213184);
      float f = nextFloat();
      if (Float.isNaN(f))
      {
        AppMethodBeat.o(213184);
        return null;
      }
      Object localObject = rz();
      if (localObject == null)
      {
        localObject = new h.p(f, h.bd.aTg);
        AppMethodBeat.o(213184);
        return localObject;
      }
      localObject = new h.p(f, (h.bd)localObject);
      AppMethodBeat.o(213184);
      return localObject;
    }
    
    final int rv()
    {
      AppMethodBeat.i(213189);
      if (this.position == this.aWH)
      {
        AppMethodBeat.o(213189);
        return -1;
      }
      this.position += 1;
      if (this.position < this.aWH)
      {
        int i = this.aWG.charAt(this.position);
        AppMethodBeat.o(213189);
        return i;
      }
      AppMethodBeat.o(213189);
      return -1;
    }
    
    final String rw()
    {
      AppMethodBeat.i(213193);
      if (empty())
      {
        AppMethodBeat.o(213193);
        return null;
      }
      int j = this.position;
      int i = this.aWG.charAt(this.position);
      if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)))
      {
        for (i = rv(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)); i = rv()) {}
        String str = this.aWG.substring(j, this.position);
        AppMethodBeat.o(213193);
        return str;
      }
      this.position = j;
      AppMethodBeat.o(213193);
      return null;
    }
    
    final String rx()
    {
      AppMethodBeat.i(213194);
      if (empty())
      {
        AppMethodBeat.o(213194);
        return null;
      }
      int j = this.position;
      for (int i = this.aWG.charAt(this.position); ((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)); i = rv()) {}
      int k = this.position;
      while (isWhitespace(i)) {
        i = rv();
      }
      if (i == 40)
      {
        this.position += 1;
        String str = this.aWG.substring(j, k);
        AppMethodBeat.o(213194);
        return str;
      }
      this.position = j;
      AppMethodBeat.o(213194);
      return null;
    }
    
    final String ry()
    {
      AppMethodBeat.i(213195);
      int i = this.position;
      while ((!empty()) && (!isWhitespace(this.aWG.charAt(this.position)))) {
        this.position += 1;
      }
      String str = this.aWG.substring(i, this.position);
      this.position = i;
      AppMethodBeat.o(213195);
      return str;
    }
    
    final h.bd rz()
    {
      AppMethodBeat.i(213196);
      if (empty())
      {
        AppMethodBeat.o(213196);
        return null;
      }
      h.bd localbd;
      if (this.aWG.charAt(this.position) == '%')
      {
        this.position += 1;
        localbd = h.bd.aTo;
        AppMethodBeat.o(213196);
        return localbd;
      }
      if (this.position > this.aWH - 2)
      {
        AppMethodBeat.o(213196);
        return null;
      }
      try
      {
        localbd = h.bd.valueOf(this.aWG.substring(this.position, this.position + 2).toLowerCase(Locale.US));
        this.position += 2;
        AppMethodBeat.o(213196);
        return localbd;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        AppMethodBeat.o(213196);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.l
 * JD-Core Version:    0.7.0.1
 */