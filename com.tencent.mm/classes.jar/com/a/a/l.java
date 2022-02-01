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
  private h aTM = null;
  private h.aj aTN = null;
  private boolean aTO = false;
  private int aTP;
  private boolean aTQ = false;
  private g aTR = null;
  private StringBuilder aTS = null;
  private boolean aTT = false;
  private StringBuilder aTU = null;
  
  private void A(Attributes paramAttributes)
  {
    AppMethodBeat.i(206758);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206758);
      throw paramAttributes;
    }
    h.bf localbf = new h.bf();
    localbf.aSO = this.aTM;
    localbf.aSP = this.aTN;
    a(localbf, paramAttributes);
    a(localbf, paramAttributes);
    a(localbf, paramAttributes);
    this.aTN.a(localbf);
    this.aTN = localbf;
    AppMethodBeat.o(206758);
  }
  
  private void B(Attributes paramAttributes)
  {
    AppMethodBeat.i(206759);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206759);
      throw paramAttributes;
    }
    h.s locals = new h.s();
    locals.aSO = this.aTM;
    locals.aSP = this.aTN;
    a(locals, paramAttributes);
    b(locals, paramAttributes);
    a(locals, paramAttributes);
    a(locals, paramAttributes);
    this.aTN.a(locals);
    this.aTN = locals;
    AppMethodBeat.o(206759);
  }
  
  private void C(Attributes paramAttributes)
  {
    AppMethodBeat.i(206803);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206803);
      throw paramAttributes;
    }
    Object localObject = "all";
    int i = 0;
    boolean bool = true;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
    if ((bool) && (b.a((String)localObject, b.e.aOz)))
    {
      this.aTT = true;
      AppMethodBeat.o(206803);
      return;
    }
    this.aTO = true;
    this.aTP = 1;
    AppMethodBeat.o(206803);
  }
  
  private static int T(float paramFloat)
  {
    AppMethodBeat.i(206779);
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(206779);
      return 0;
    }
    if (paramFloat > 255.0F)
    {
      AppMethodBeat.o(206779);
      return 255;
    }
    int i = Math.round(paramFloat);
    AppMethodBeat.o(206779);
    return i;
  }
  
  static Map<String, String> a(h paramh)
  {
    AppMethodBeat.i(206709);
    HashMap localHashMap = new HashMap();
    paramh.rs();
    for (String str = paramh.c('='); str != null; str = paramh.c('='))
    {
      paramh.b('=');
      localHashMap.put(str, paramh.rE());
      paramh.rs();
    }
    AppMethodBeat.o(206709);
    return localHashMap;
  }
  
  private static void a(h.a parama, Attributes paramAttributes)
  {
    AppMethodBeat.i(206715);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
          parama.aQk = str;
        }
      }
    }
    AppMethodBeat.o(206715);
  }
  
  private static void a(h.ab paramab, Attributes paramAttributes)
  {
    AppMethodBeat.i(206723);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
                paramab.aQH = ag(str);
                continue;
                paramab.aQI = ag(str);
              }
              paramab.aQJ = ag(str);
            } while (!paramab.aQJ.isNegative());
            paramab = new k("Invalid <rect> element. width cannot be negative");
            AppMethodBeat.o(206723);
            throw paramab;
            paramab.aQK = ag(str);
          } while (!paramab.aQK.isNegative());
          paramab = new k("Invalid <rect> element. height cannot be negative");
          AppMethodBeat.o(206723);
          throw paramab;
          paramab.aQx = ag(str);
        } while (!paramab.aQx.isNegative());
        paramab = new k("Invalid <rect> element. rx cannot be negative");
        AppMethodBeat.o(206723);
        throw paramab;
        paramab.aQy = ag(str);
      } while (!paramab.aQy.isNegative());
      paramab = new k("Invalid <rect> element. ry cannot be negative");
      AppMethodBeat.o(206723);
      throw paramab;
    }
    AppMethodBeat.o(206723);
  }
  
  private static void a(h.ad paramad, Attributes paramAttributes)
  {
    AppMethodBeat.i(206749);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramad.aRi = ae(str);
      }
    }
    AppMethodBeat.o(206749);
  }
  
  private static void a(h.ae paramae, String paramString)
  {
    AppMethodBeat.i(206782);
    if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains("|" + paramString + '|'))
    {
      AppMethodBeat.o(206782);
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
      localh.rs();
      if (str == null)
      {
        AppMethodBeat.o(206782);
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
      localh.rs();
      localObject1 = localh.nextToken();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        ag((String)localObject1);
        localh.rs();
        paramae.aRx = ap(localh.rF());
        paramae.aRy = paramString;
        if (localObject5 == null)
        {
          i = 400;
          paramae.aRz = Integer.valueOf(i);
          paramString = (String)localObject2;
          if (localObject2 == null) {
            paramString = h.ae.b.aRZ;
          }
          paramae.aRA = paramString;
          paramae.aRj |= 0x1E000;
          AppMethodBeat.o(206782);
          return;
        }
      }
      catch (k paramae)
      {
        AppMethodBeat.o(206782);
        return;
      }
      int i = localObject5.intValue();
    }
  }
  
  static void a(h.ae paramae, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206764);
    if (paramString2.length() == 0)
    {
      AppMethodBeat.o(206764);
      return;
    }
    if (paramString2.equals("inherit"))
    {
      AppMethodBeat.o(206764);
      return;
    }
    switch (1.aTW[f.aM(paramString1).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(206764);
      return;
      paramae.aRk = al(paramString2);
      if (paramae.aRk != null)
      {
        paramae.aRj |= 1L;
        AppMethodBeat.o(206764);
        return;
        paramae.aRl = au(paramString2);
        if (paramae.aRl != null)
        {
          paramae.aRj |= 0x2;
          AppMethodBeat.o(206764);
          return;
          paramae.aRm = ai(paramString2);
          if (paramae.aRm != null)
          {
            paramae.aRj |= 0x4;
            AppMethodBeat.o(206764);
            return;
            paramae.aRn = al(paramString2);
            if (paramae.aRn != null)
            {
              paramae.aRj |= 0x8;
              AppMethodBeat.o(206764);
              return;
              paramae.aRo = ai(paramString2);
              if (paramae.aRo != null)
              {
                paramae.aRj |= 0x10;
                AppMethodBeat.o(206764);
                return;
                try
                {
                  paramae.aRp = ag(paramString2);
                  paramae.aRj |= 0x20;
                  AppMethodBeat.o(206764);
                  return;
                }
                catch (k paramae)
                {
                  AppMethodBeat.o(206764);
                  return;
                }
                paramae.aRq = av(paramString2);
                if (paramae.aRq != null)
                {
                  paramae.aRj |= 0x40;
                  AppMethodBeat.o(206764);
                  return;
                  paramae.aRr = aw(paramString2);
                  if (paramae.aRr != null)
                  {
                    paramae.aRj |= 0x80;
                    AppMethodBeat.o(206764);
                    return;
                    try
                    {
                      paramae.aRs = Float.valueOf(parseFloat(paramString2));
                      paramae.aRj |= 0x100;
                      AppMethodBeat.o(206764);
                      return;
                    }
                    catch (k paramae)
                    {
                      AppMethodBeat.o(206764);
                      return;
                    }
                    if ("none".equals(paramString2))
                    {
                      paramae.aRt = null;
                      paramae.aRj |= 0x200;
                      AppMethodBeat.o(206764);
                      return;
                    }
                    paramae.aRt = ax(paramString2);
                    if (paramae.aRt != null)
                    {
                      paramae.aRj |= 0x200;
                      AppMethodBeat.o(206764);
                      return;
                      try
                      {
                        paramae.aRu = ag(paramString2);
                        paramae.aRj |= 0x400;
                        AppMethodBeat.o(206764);
                        return;
                      }
                      catch (k paramae)
                      {
                        AppMethodBeat.o(206764);
                        return;
                      }
                      paramae.aRv = ai(paramString2);
                      paramae.aRj |= 0x800;
                      AppMethodBeat.o(206764);
                      return;
                      try
                      {
                        paramae.aRw = an(paramString2);
                        paramae.aRj |= 0x1000;
                        AppMethodBeat.o(206764);
                        return;
                      }
                      catch (k paramae)
                      {
                        AppMethodBeat.o(206764);
                        return;
                      }
                      a(paramae, paramString2);
                      AppMethodBeat.o(206764);
                      return;
                      paramae.aRx = ap(paramString2);
                      if (paramae.aRx != null)
                      {
                        paramae.aRj |= 0x2000;
                        AppMethodBeat.o(206764);
                        return;
                        paramae.aRy = aq(paramString2);
                        if (paramae.aRy != null)
                        {
                          paramae.aRj |= 0x4000;
                          AppMethodBeat.o(206764);
                          return;
                          paramae.aRz = l.d.aK(paramString2);
                          if (paramae.aRz != null)
                          {
                            paramae.aRj |= 0x8000;
                            AppMethodBeat.o(206764);
                            return;
                            paramae.aRA = ar(paramString2);
                            if (paramae.aRA != null)
                            {
                              paramae.aRj |= 0x10000;
                              AppMethodBeat.o(206764);
                              return;
                              paramae.aRB = as(paramString2);
                              if (paramae.aRB != null)
                              {
                                paramae.aRj |= 0x20000;
                                AppMethodBeat.o(206764);
                                return;
                                paramae.aRC = at(paramString2);
                                if (paramae.aRC != null)
                                {
                                  paramae.aRj |= 0x0;
                                  AppMethodBeat.o(206764);
                                  return;
                                  paramae.aRD = ay(paramString2);
                                  if (paramae.aRD != null)
                                  {
                                    paramae.aRj |= 0x40000;
                                    AppMethodBeat.o(206764);
                                    return;
                                    paramae.aRE = az(paramString2);
                                    if (paramae.aRE != null)
                                    {
                                      paramae.aRj |= 0x80000;
                                      AppMethodBeat.o(206764);
                                      return;
                                      paramae.aRG = aH(paramString2);
                                      paramae.aRH = paramae.aRG;
                                      paramae.aRI = paramae.aRG;
                                      paramae.aRj |= 0xE00000;
                                      AppMethodBeat.o(206764);
                                      return;
                                      paramae.aRG = aH(paramString2);
                                      paramae.aRj |= 0x200000;
                                      AppMethodBeat.o(206764);
                                      return;
                                      paramae.aRH = aH(paramString2);
                                      paramae.aRj |= 0x400000;
                                      AppMethodBeat.o(206764);
                                      return;
                                      paramae.aRI = aH(paramString2);
                                      paramae.aRj |= 0x800000;
                                      AppMethodBeat.o(206764);
                                      return;
                                      if ((paramString2.indexOf('|') < 0) && ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains("|" + paramString2 + '|')))
                                      {
                                        if (!paramString2.equals("none")) {}
                                        for (boolean bool = true;; bool = false)
                                        {
                                          paramae.aRJ = Boolean.valueOf(bool);
                                          paramae.aRj |= 0x1000000;
                                          AppMethodBeat.o(206764);
                                          return;
                                        }
                                        if ((paramString2.indexOf('|') < 0) && ("|visible|hidden|collapse|".contains("|" + paramString2 + '|')))
                                        {
                                          paramae.aRK = Boolean.valueOf(paramString2.equals("visible"));
                                          paramae.aRj |= 0x2000000;
                                          AppMethodBeat.o(206764);
                                          return;
                                          if (paramString2.equals("currentColor")) {
                                            paramae.aRL = h.g.qT();
                                          }
                                          for (;;)
                                          {
                                            paramae.aRj |= 0x4000000;
                                            AppMethodBeat.o(206764);
                                            return;
                                            try
                                            {
                                              paramae.aRL = an(paramString2);
                                            }
                                            catch (k paramae)
                                            {
                                              paramae.getMessage();
                                              AppMethodBeat.o(206764);
                                              return;
                                            }
                                          }
                                          paramae.aRM = ai(paramString2);
                                          paramae.aRj |= 0x8000000;
                                          AppMethodBeat.o(206764);
                                          return;
                                          paramae.aRF = aA(paramString2);
                                          if (paramae.aRF != null)
                                          {
                                            paramae.aRj |= 0x100000;
                                            AppMethodBeat.o(206764);
                                            return;
                                            paramae.aRN = aH(paramString2);
                                            paramae.aRj |= 0x10000000;
                                            AppMethodBeat.o(206764);
                                            return;
                                            paramae.aRO = au(paramString2);
                                            paramae.aRj |= 0x20000000;
                                            AppMethodBeat.o(206764);
                                            return;
                                            paramae.aRP = aH(paramString2);
                                            paramae.aRj |= 0x40000000;
                                            AppMethodBeat.o(206764);
                                            return;
                                            if (paramString2.equals("currentColor")) {
                                              paramae.aRQ = h.g.qT();
                                            }
                                            for (;;)
                                            {
                                              paramae.aRj |= 0x80000000;
                                              AppMethodBeat.o(206764);
                                              return;
                                              try
                                              {
                                                paramae.aRQ = an(paramString2);
                                              }
                                              catch (k paramae)
                                              {
                                                paramae.getMessage();
                                                AppMethodBeat.o(206764);
                                                return;
                                              }
                                            }
                                            paramae.aRR = ai(paramString2);
                                            paramae.aRj |= 0x0;
                                            AppMethodBeat.o(206764);
                                            return;
                                            if (paramString2.equals("currentColor")) {
                                              paramae.aRS = h.g.qT();
                                            }
                                            for (;;)
                                            {
                                              paramae.aRj |= 0x0;
                                              AppMethodBeat.o(206764);
                                              return;
                                              try
                                              {
                                                paramae.aRS = an(paramString2);
                                              }
                                              catch (k paramae)
                                              {
                                                paramae.getMessage();
                                                AppMethodBeat.o(206764);
                                                return;
                                              }
                                            }
                                            paramae.aRT = ai(paramString2);
                                            paramae.aRj |= 0x0;
                                            AppMethodBeat.o(206764);
                                            return;
                                            paramae.aRU = aB(paramString2);
                                            if (paramae.aRU != null)
                                            {
                                              paramae.aRj |= 0x0;
                                              AppMethodBeat.o(206764);
                                              return;
                                              paramae.aRV = aC(paramString2);
                                              if (paramae.aRV != null) {
                                                paramae.aRj |= 0x0;
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
    AppMethodBeat.i(206711);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramaf.aQH = ag(str);
        continue;
        paramaf.aQI = ag(str);
        continue;
        paramaf.aQJ = ag(str);
        if (paramaf.aQJ.isNegative())
        {
          paramaf = new k("Invalid <svg> element. width cannot be negative");
          AppMethodBeat.o(206711);
          throw paramaf;
          paramaf.aQK = ag(str);
          if (paramaf.aQK.isNegative())
          {
            paramaf = new k("Invalid <svg> element. height cannot be negative");
            AppMethodBeat.o(206711);
            throw paramaf;
            paramaf.version = str;
          }
        }
      }
    }
    AppMethodBeat.o(206711);
  }
  
  private static void a(h.ag paramag, Attributes paramAttributes)
  {
    AppMethodBeat.i(206739);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      Object localObject = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
          paramag.ab((String)localObject);
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
    AppMethodBeat.o(206739);
  }
  
  private static void a(h.al paramal, String paramString)
  {
    AppMethodBeat.i(206763);
    paramString = new b.c(paramString.replaceAll("/\\*.*?\\*/", ""));
    while (!paramString.empty())
    {
      paramString.rs();
      String str1 = paramString.qA();
      paramString.rs();
      if (!paramString.b(';'))
      {
        if (!paramString.b(':')) {
          break;
        }
        paramString.rs();
        String str2 = paramString.qD();
        if (str2 != null)
        {
          paramString.rs();
          if ((paramString.empty()) || (paramString.b(';')))
          {
            if (paramal.aPk == null) {
              paramal.aPk = new h.ae();
            }
            a(paramal.aPk, str1, str2);
            paramString.rs();
          }
        }
      }
    }
    AppMethodBeat.o(206763);
  }
  
  private static void a(h.al paramal, Attributes paramAttributes)
  {
    AppMethodBeat.i(206761);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getQName(i);
      if ((str.equals("id")) || (str.equals("xml:id")))
      {
        paramal.id = paramAttributes.getValue(i).trim();
        AppMethodBeat.o(206761);
        return;
      }
      if (str.equals("xml:space"))
      {
        paramAttributes = paramAttributes.getValue(i).trim();
        if ("default".equals(paramAttributes))
        {
          paramal.aSL = Boolean.FALSE;
          AppMethodBeat.o(206761);
          return;
        }
        if ("preserve".equals(paramAttributes))
        {
          paramal.aSL = Boolean.TRUE;
          AppMethodBeat.o(206761);
          return;
        }
        paramal = new k("Invalid value for \"xml:space\" attribute: ".concat(String.valueOf(paramAttributes)));
        AppMethodBeat.o(206761);
        throw paramal;
      }
      i += 1;
    }
    AppMethodBeat.o(206761);
  }
  
  private static void a(h.am paramam, Attributes paramAttributes)
  {
    AppMethodBeat.i(206745);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramam.aQM = ag(str);
        continue;
        paramam.aQN = ag(str);
        continue;
        paramam.aQO = ag(str);
        continue;
        paramam.aQP = ag(str);
      }
    }
    AppMethodBeat.o(206745);
  }
  
  private static void a(h.ap paramap, String paramString)
  {
    AppMethodBeat.i(206774);
    paramap.aPZ = ak(paramString);
    AppMethodBeat.o(206774);
  }
  
  private static void a(h.aq paramaq, Attributes paramAttributes)
  {
    AppMethodBeat.i(206747);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramaq.aQp = ag(str);
        continue;
        paramaq.aQq = ag(str);
        continue;
        paramaq.aQr = ag(str);
        if (paramaq.aQr.isNegative())
        {
          paramaq = new k("Invalid <radialGradient> element. r cannot be negative");
          AppMethodBeat.o(206747);
          throw paramaq;
          paramaq.aSQ = ag(str);
          continue;
          paramaq.aSR = ag(str);
        }
      }
    }
    AppMethodBeat.o(206747);
  }
  
  private static void a(h.ar paramar, Attributes paramAttributes)
  {
    AppMethodBeat.i(206765);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramar.aQb = aj(str);
        continue;
        a(paramar, str);
      }
    }
    AppMethodBeat.o(206765);
  }
  
  private static void a(h.au paramau, Attributes paramAttributes)
  {
    AppMethodBeat.i(206737);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
          paramau.aQk = str;
        }
      }
    }
    AppMethodBeat.o(206737);
  }
  
  private static void a(h.az paramaz, Attributes paramAttributes)
  {
    AppMethodBeat.i(206755);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i))))
        {
          paramaz.aQk = str;
          continue;
          paramaz.aST = ag(str);
        }
      }
    }
    AppMethodBeat.o(206755);
  }
  
  private static void a(h.ba paramba, Attributes paramAttributes)
  {
    AppMethodBeat.i(206734);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramba.aSU = ah(str);
        continue;
        paramba.aSV = ah(str);
        continue;
        paramba.aSW = ah(str);
        continue;
        paramba.aSX = ah(str);
      }
    }
    AppMethodBeat.o(206734);
  }
  
  private static void a(h.be parambe, Attributes paramAttributes)
  {
    AppMethodBeat.i(206717);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        parambe.aQH = ag(str);
        continue;
        parambe.aQI = ag(str);
        continue;
        parambe.aQJ = ag(str);
        if (parambe.aQJ.isNegative())
        {
          parambe = new k("Invalid <use> element. width cannot be negative");
          AppMethodBeat.o(206717);
          throw parambe;
          parambe.aQK = ag(str);
          if (parambe.aQK.isNegative())
          {
            parambe = new k("Invalid <use> element. height cannot be negative");
            AppMethodBeat.o(206717);
            throw parambe;
            if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
              parambe.aQk = str;
            }
          }
        }
      }
    }
    AppMethodBeat.o(206717);
  }
  
  private static void a(h.d paramd, Attributes paramAttributes)
  {
    AppMethodBeat.i(206725);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramd.aQp = ag(str);
          continue;
          paramd.aQq = ag(str);
        }
        paramd.aQr = ag(str);
      } while (!paramd.aQr.isNegative());
      paramd = new k("Invalid <circle> element. r cannot be negative");
      AppMethodBeat.o(206725);
      throw paramd;
    }
    AppMethodBeat.o(206725);
  }
  
  private static void a(h.e parame, Attributes paramAttributes)
  {
    AppMethodBeat.i(206753);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          parame.aQs = Boolean.FALSE;
        }
        else
        {
          if (!"userSpaceOnUse".equals(str)) {
            break label111;
          }
          parame.aQs = Boolean.TRUE;
        }
      }
      label111:
      parame = new k("Invalid value for attribute clipPathUnits");
      AppMethodBeat.o(206753);
      throw parame;
    }
    AppMethodBeat.o(206753);
  }
  
  private static void a(h.i parami, Attributes paramAttributes)
  {
    AppMethodBeat.i(206727);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
            parami.aQp = ag(str);
            continue;
            parami.aQq = ag(str);
          }
          parami.aQx = ag(str);
        } while (!parami.aQx.isNegative());
        parami = new k("Invalid <ellipse> element. rx cannot be negative");
        AppMethodBeat.o(206727);
        throw parami;
        parami.aQy = ag(str);
      } while (!parami.aQy.isNegative());
      parami = new k("Invalid <ellipse> element. ry cannot be negative");
      AppMethodBeat.o(206727);
      throw parami;
    }
    AppMethodBeat.o(206727);
  }
  
  private static void a(h.j paramj, Attributes paramAttributes)
  {
    AppMethodBeat.i(206744);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          paramj.aQA = Boolean.FALSE;
        }
        else if ("userSpaceOnUse".equals(str))
        {
          paramj.aQA = Boolean.TRUE;
        }
        else
        {
          paramj = new k("Invalid value for attribute gradientUnits");
          AppMethodBeat.o(206744);
          throw paramj;
          paramj.aQB = af(str);
          continue;
          try
          {
            paramj.aQC = h.k.valueOf(str);
          }
          catch (IllegalArgumentException paramj)
          {
            paramj = new k("Invalid spreadMethod attribute. \"" + str + "\" is not a valid value.");
            AppMethodBeat.o(206744);
            throw paramj;
          }
          if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
            paramj.aQk = str;
          }
        }
      }
    }
    AppMethodBeat.o(206744);
  }
  
  private static void a(h.n paramn, Attributes paramAttributes)
  {
    AppMethodBeat.i(206766);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      if (f.aM(paramAttributes.getLocalName(i)) == f.aVA) {
        paramn.setTransform(af(paramAttributes.getValue(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(206766);
  }
  
  private static void a(h.o paramo, Attributes paramAttributes)
  {
    AppMethodBeat.i(206719);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramo.aQH = ag(str);
        continue;
        paramo.aQI = ag(str);
        continue;
        paramo.aQJ = ag(str);
        if (paramo.aQJ.isNegative())
        {
          paramo = new k("Invalid <use> element. width cannot be negative");
          AppMethodBeat.o(206719);
          throw paramo;
          paramo.aQK = ag(str);
          if (paramo.aQK.isNegative())
          {
            paramo = new k("Invalid <use> element. height cannot be negative");
            AppMethodBeat.o(206719);
            throw paramo;
            if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i))))
            {
              paramo.aQk = str;
              continue;
              a(paramo, str);
            }
          }
        }
      }
    }
    AppMethodBeat.o(206719);
  }
  
  private static void a(h.q paramq, Attributes paramAttributes)
  {
    AppMethodBeat.i(206729);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramq.aQM = ag(str);
        continue;
        paramq.aQN = ag(str);
        continue;
        paramq.aQO = ag(str);
        continue;
        paramq.aQP = ag(str);
      }
    }
    AppMethodBeat.o(206729);
  }
  
  private static void a(h.r paramr, Attributes paramAttributes)
  {
    AppMethodBeat.i(206742);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramr.aQR = ag(str);
        continue;
        paramr.aQS = ag(str);
        continue;
        paramr.aQT = ag(str);
        if (paramr.aQT.isNegative())
        {
          paramr = new k("Invalid <marker> element. markerWidth cannot be negative");
          AppMethodBeat.o(206742);
          throw paramr;
          paramr.aQU = ag(str);
          if (paramr.aQU.isNegative())
          {
            paramr = new k("Invalid <marker> element. markerHeight cannot be negative");
            AppMethodBeat.o(206742);
            throw paramr;
            if ("strokeWidth".equals(str))
            {
              paramr.aQQ = false;
            }
            else if ("userSpaceOnUse".equals(str))
            {
              paramr.aQQ = true;
            }
            else
            {
              paramr = new k("Invalid value for attribute markerUnits");
              AppMethodBeat.o(206742);
              throw paramr;
              if ("auto".equals(str)) {
                paramr.aQV = Float.valueOf((0.0F / 0.0F));
              } else {
                paramr.aQV = Float.valueOf(parseFloat(str));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(206742);
  }
  
  private static void a(h.s params, Attributes paramAttributes)
  {
    AppMethodBeat.i(206760);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
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
              params.aQW = Boolean.FALSE;
            }
            else if ("userSpaceOnUse".equals(str))
            {
              params.aQW = Boolean.TRUE;
            }
            else
            {
              params = new k("Invalid value for attribute maskUnits");
              AppMethodBeat.o(206760);
              throw params;
              if ("objectBoundingBox".equals(str))
              {
                params.aQX = Boolean.FALSE;
              }
              else if ("userSpaceOnUse".equals(str))
              {
                params.aQX = Boolean.TRUE;
              }
              else
              {
                params = new k("Invalid value for attribute maskContentUnits");
                AppMethodBeat.o(206760);
                throw params;
                params.aQH = ag(str);
                continue;
                params.aQI = ag(str);
              }
            }
          }
          params.aQJ = ag(str);
        } while (!params.aQJ.isNegative());
        params = new k("Invalid <mask> element. width cannot be negative");
        AppMethodBeat.o(206760);
        throw params;
        params.aQK = ag(str);
      } while (!params.aQK.isNegative());
      params = new k("Invalid <mask> element. height cannot be negative");
      AppMethodBeat.o(206760);
      throw params;
    }
    AppMethodBeat.o(206760);
  }
  
  private static void a(h.v paramv, Attributes paramAttributes)
  {
    AppMethodBeat.i(206721);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramv.aQZ = aD(str);
        }
        paramv.aRa = Float.valueOf(parseFloat(str));
      } while (paramv.aRa.floatValue() >= 0.0F);
      paramv = new k("Invalid <path> element. pathLength cannot be negative");
      AppMethodBeat.o(206721);
      throw paramv;
    }
    AppMethodBeat.o(206721);
  }
  
  private static void a(h.y paramy, Attributes paramAttributes)
  {
    AppMethodBeat.i(206757);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          paramy.aRf = Boolean.FALSE;
        }
        else if ("userSpaceOnUse".equals(str))
        {
          paramy.aRf = Boolean.TRUE;
        }
        else
        {
          paramy = new k("Invalid value for attribute patternUnits");
          AppMethodBeat.o(206757);
          throw paramy;
          if ("objectBoundingBox".equals(str))
          {
            paramy.aRg = Boolean.FALSE;
          }
          else if ("userSpaceOnUse".equals(str))
          {
            paramy.aRg = Boolean.TRUE;
          }
          else
          {
            paramy = new k("Invalid value for attribute patternContentUnits");
            AppMethodBeat.o(206757);
            throw paramy;
            paramy.aRh = af(str);
            continue;
            paramy.aQH = ag(str);
            continue;
            paramy.aQI = ag(str);
            continue;
            paramy.aQJ = ag(str);
            if (paramy.aQJ.isNegative())
            {
              paramy = new k("Invalid <pattern> element. width cannot be negative");
              AppMethodBeat.o(206757);
              throw paramy;
              paramy.aQK = ag(str);
              if (paramy.aQK.isNegative())
              {
                paramy = new k("Invalid <pattern> element. height cannot be negative");
                AppMethodBeat.o(206757);
                throw paramy;
                if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
                  paramy.aQk = str;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(206757);
  }
  
  private static void a(h.z paramz, Attributes paramAttributes, String paramString)
  {
    AppMethodBeat.i(206731);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      if (f.aM(paramAttributes.getLocalName(i)) == f.aUX)
      {
        Object localObject = new h(paramAttributes.getValue(i));
        ArrayList localArrayList = new ArrayList();
        ((h)localObject).rs();
        float f1;
        while (!((h)localObject).empty())
        {
          f1 = ((h)localObject).nextFloat();
          if (Float.isNaN(f1))
          {
            paramz = new k("Invalid <" + paramString + "> points attribute. Non-coordinate content found in list.");
            AppMethodBeat.o(206731);
            throw paramz;
          }
          ((h)localObject).rt();
          float f2 = ((h)localObject).nextFloat();
          if (Float.isNaN(f2))
          {
            paramz = new k("Invalid <" + paramString + "> points attribute. There should be an even number of coordinates.");
            AppMethodBeat.o(206731);
            throw paramz;
          }
          ((h)localObject).rt();
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
    AppMethodBeat.o(206731);
  }
  
  private void a(Attributes paramAttributes)
  {
    AppMethodBeat.i(206710);
    h.af localaf = new h.af();
    localaf.aSO = this.aTM;
    localaf.aSP = this.aTN;
    a(localaf, paramAttributes);
    b(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    if (this.aTN == null) {
      this.aTM.aQf = localaf;
    }
    for (;;)
    {
      this.aTN = localaf;
      AppMethodBeat.o(206710);
      return;
      this.aTN.a(localaf);
    }
  }
  
  private static h.c aA(String paramString)
  {
    AppMethodBeat.i(206794);
    if ("auto".equals(paramString))
    {
      AppMethodBeat.o(206794);
      return null;
    }
    if (!paramString.startsWith("rect("))
    {
      AppMethodBeat.o(206794);
      return null;
    }
    paramString = new h(paramString.substring(5));
    paramString.rs();
    h.p localp1 = b(paramString);
    paramString.rt();
    h.p localp2 = b(paramString);
    paramString.rt();
    h.p localp3 = b(paramString);
    paramString.rt();
    h.p localp4 = b(paramString);
    paramString.rs();
    if ((!paramString.b(')')) && (!paramString.empty()))
    {
      AppMethodBeat.o(206794);
      return null;
    }
    paramString = new h.c(localp1, localp2, localp3, localp4);
    AppMethodBeat.o(206794);
    return paramString;
  }
  
  private static h.ae.i aB(String paramString)
  {
    AppMethodBeat.i(206796);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(206796);
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
    paramString = h.ae.i.aSC;
    AppMethodBeat.o(206796);
    return paramString;
    paramString = h.ae.i.aSD;
    AppMethodBeat.o(206796);
    return paramString;
  }
  
  private static h.ae.e aC(String paramString)
  {
    AppMethodBeat.i(206797);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(206797);
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
    paramString = h.ae.e.aSl;
    AppMethodBeat.o(206797);
    return paramString;
    paramString = h.ae.e.aSm;
    AppMethodBeat.o(206797);
    return paramString;
    paramString = h.ae.e.aSn;
    AppMethodBeat.o(206797);
    return paramString;
  }
  
  private static h.w aD(String paramString)
  {
    AppMethodBeat.i(206798);
    paramString = new h(paramString);
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f10 = 0.0F;
    float f9 = 0.0F;
    h.w localw = new h.w();
    if (paramString.empty())
    {
      AppMethodBeat.o(206798);
      return localw;
    }
    int i = paramString.rv().intValue();
    float f2;
    float f1;
    label107:
    float f5;
    float f6;
    float f7;
    if ((i != 77) && (i != 109))
    {
      AppMethodBeat.o(206798);
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
          paramString.rt();
          if (paramString.empty()) {
            break label1460;
          }
          if (!paramString.rD()) {
            break label1469;
          }
          i = paramString.rv().intValue();
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
      paramString.rs();
      switch (i)
      {
      default: 
        AppMethodBeat.o(206798);
        return localw;
      case 77: 
      case 109: 
        f1 = paramString.nextFloat();
        f2 = paramString.U(f1);
        if (!Float.isNaN(f2)) {
          break;
        }
        new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
        AppMethodBeat.o(206798);
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
          AppMethodBeat.o(206798);
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
            AppMethodBeat.o(206798);
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
              AppMethodBeat.o(206798);
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
                AppMethodBeat.o(206798);
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
                  AppMethodBeat.o(206798);
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
                    AppMethodBeat.o(206798);
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
                      AppMethodBeat.o(206798);
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
                        AppMethodBeat.o(206798);
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
                        AppMethodBeat.o(206798);
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
    AppMethodBeat.i(206799);
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
        paramString.rs();
        break;
        localHashSet.add("UNSUPPORTED");
      }
    }
    AppMethodBeat.o(206799);
    return localHashSet;
  }
  
  private static Set<String> aF(String paramString)
  {
    AppMethodBeat.i(206800);
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
      localh.rs();
    }
    AppMethodBeat.o(206800);
    return localHashSet;
  }
  
  private static Set<String> aG(String paramString)
  {
    AppMethodBeat.i(206801);
    paramString = new h(paramString);
    HashSet localHashSet = new HashSet();
    while (!paramString.empty())
    {
      localHashSet.add(paramString.nextToken());
      paramString.rs();
    }
    AppMethodBeat.o(206801);
    return localHashSet;
  }
  
  private static String aH(String paramString)
  {
    AppMethodBeat.i(206802);
    if (paramString.equals("none"))
    {
      AppMethodBeat.o(206802);
      return null;
    }
    if (!paramString.startsWith("url("))
    {
      AppMethodBeat.o(206802);
      return null;
    }
    if (paramString.endsWith(")"))
    {
      paramString = paramString.substring(4, paramString.length() - 1).trim();
      AppMethodBeat.o(206802);
      return paramString;
    }
    paramString = paramString.substring(4).trim();
    AppMethodBeat.o(206802);
    return paramString;
  }
  
  private void aI(String paramString)
  {
    AppMethodBeat.i(206804);
    b localb = new b(b.e.aOz, b.t.aPs);
    this.aTM.b(localb.W(paramString));
    AppMethodBeat.o(206804);
  }
  
  private void ad(String paramString)
  {
    AppMethodBeat.i(206706);
    Object localObject = (h.ah)this.aTN;
    int i = ((h.ah)localObject).aQz.size();
    if (i == 0) {}
    for (localObject = null; (localObject instanceof h.bc); localObject = (h.an)((h.ah)localObject).aQz.get(i - 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = (h.bc)localObject;
      ((h.bc)localObject).text += paramString;
      AppMethodBeat.o(206706);
      return;
    }
    this.aTN.a(new h.bc(paramString));
    AppMethodBeat.o(206706);
  }
  
  private static Float ae(String paramString)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(206750);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid offset value in <stop> (empty string)");
      AppMethodBeat.o(206750);
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
        AppMethodBeat.o(206750);
        throw paramString;
      }
      AppMethodBeat.o(206750);
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
    AppMethodBeat.i(206767);
    Matrix localMatrix = new Matrix();
    h localh = new h(paramString);
    localh.rs();
    if (!localh.empty())
    {
      Object localObject = localh.rA();
      if (localObject == null)
      {
        paramString = new k("Bad transform function encountered in transform list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(206767);
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
          AppMethodBeat.o(206767);
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
      localh.rs();
      float f1 = localh.nextFloat();
      localh.rt();
      float f2 = localh.nextFloat();
      localh.rt();
      float f3 = localh.nextFloat();
      localh.rt();
      float f4 = localh.nextFloat();
      localh.rt();
      float f5 = localh.nextFloat();
      localh.rt();
      float f6 = localh.nextFloat();
      localh.rs();
      if ((Float.isNaN(f6)) || (!localh.b(')')))
      {
        paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(206767);
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
        localh.rt();
        break;
        localh.rs();
        f1 = localh.nextFloat();
        f2 = localh.ru();
        localh.rs();
        if ((Float.isNaN(f1)) || (!localh.b(')')))
        {
          paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(206767);
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
          localh.rs();
          f1 = localh.nextFloat();
          f2 = localh.ru();
          localh.rs();
          if ((Float.isNaN(f1)) || (!localh.b(')')))
          {
            paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(206767);
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
            localh.rs();
            f1 = localh.nextFloat();
            f2 = localh.ru();
            f3 = localh.ru();
            localh.rs();
            if ((Float.isNaN(f1)) || (!localh.b(')')))
            {
              paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
              AppMethodBeat.o(206767);
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
              AppMethodBeat.o(206767);
              throw paramString;
              localh.rs();
              f1 = localh.nextFloat();
              localh.rs();
              if ((Float.isNaN(f1)) || (!localh.b(')')))
              {
                paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
                AppMethodBeat.o(206767);
                throw paramString;
              }
              localMatrix.preSkew((float)Math.tan(Math.toRadians(f1)), 0.0F);
              continue;
              localh.rs();
              f1 = localh.nextFloat();
              localh.rs();
              if ((Float.isNaN(f1)) || (!localh.b(')')))
              {
                paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
                AppMethodBeat.o(206767);
                throw paramString;
              }
              localMatrix.preSkew(0.0F, (float)Math.tan(Math.toRadians(f1)));
            }
          }
        }
      }
    }
    label1011:
    AppMethodBeat.o(206767);
    return localMatrix;
  }
  
  private static h.p ag(String paramString)
  {
    AppMethodBeat.i(206768);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid length value (empty string)");
      AppMethodBeat.o(206768);
      throw paramString;
    }
    int j = paramString.length();
    h.bd localbd = h.bd.aSY;
    char c = paramString.charAt(j - 1);
    int i;
    Object localObject;
    if (c == '%')
    {
      i = j - 1;
      localObject = h.bd.aTg;
    }
    for (;;)
    {
      try
      {
        localObject = new h.p(g(paramString, i), (h.bd)localObject);
        AppMethodBeat.o(206768);
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = new k("Invalid length value: ".concat(String.valueOf(paramString)), localNumberFormatException);
        AppMethodBeat.o(206768);
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
        AppMethodBeat.o(206768);
        throw paramString;
      }
    }
  }
  
  private static List<h.p> ah(String paramString)
  {
    AppMethodBeat.i(206769);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid length list (empty string)");
      AppMethodBeat.o(206769);
      throw paramString;
    }
    ArrayList localArrayList = new ArrayList(1);
    h localh = new h(paramString);
    localh.rs();
    while (!localh.empty())
    {
      float f = localh.nextFloat();
      if (Float.isNaN(f))
      {
        paramString = new k("Invalid length list value: " + localh.rB());
        AppMethodBeat.o(206769);
        throw paramString;
      }
      h.bd localbd = localh.rC();
      paramString = localbd;
      if (localbd == null) {
        paramString = h.bd.aSY;
      }
      localArrayList.add(new h.p(f, paramString));
      localh.rt();
    }
    AppMethodBeat.o(206769);
    return localArrayList;
  }
  
  private static Float ai(String paramString)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(206772);
    try
    {
      float f2 = parseFloat(paramString);
      if (f2 < 0.0F) {}
      for (;;)
      {
        AppMethodBeat.o(206772);
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
      AppMethodBeat.o(206772);
    }
  }
  
  private static h.b aj(String paramString)
  {
    AppMethodBeat.i(206773);
    paramString = new h(paramString);
    paramString.rs();
    float f1 = paramString.nextFloat();
    paramString.rt();
    float f2 = paramString.nextFloat();
    paramString.rt();
    float f3 = paramString.nextFloat();
    paramString.rt();
    float f4 = paramString.nextFloat();
    if ((Float.isNaN(f1)) || (Float.isNaN(f2)) || (Float.isNaN(f3)) || (Float.isNaN(f4)))
    {
      paramString = new k("Invalid viewBox definition - should have four numbers");
      AppMethodBeat.o(206773);
      throw paramString;
    }
    if (f3 < 0.0F)
    {
      paramString = new k("Invalid viewBox. width cannot be negative");
      AppMethodBeat.o(206773);
      throw paramString;
    }
    if (f4 < 0.0F)
    {
      paramString = new k("Invalid viewBox. height cannot be negative");
      AppMethodBeat.o(206773);
      throw paramString;
    }
    paramString = new h.b(f1, f2, f3, f4);
    AppMethodBeat.o(206773);
    return paramString;
  }
  
  private static f ak(String paramString)
  {
    AppMethodBeat.i(206775);
    h localh = new h(paramString);
    localh.rs();
    Object localObject2 = localh.a(' ', false);
    Object localObject1 = localObject2;
    if ("defer".equals(localObject2))
    {
      localh.rs();
      localObject1 = localh.a(' ', false);
    }
    localObject2 = a.aJ((String)localObject1);
    localObject1 = null;
    localh.rs();
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
          AppMethodBeat.o(206775);
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
    for (localObject1 = f.b.aPV;; localObject1 = f.b.aPW)
    {
      paramString = new f((f.a)localObject2, (f.b)localObject1);
      AppMethodBeat.o(206775);
      return paramString;
    }
  }
  
  private static h.ao al(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(206776);
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
        AppMethodBeat.o(206776);
        return paramString;
      }
      paramString = new h.u(paramString.substring(4).trim(), null);
      AppMethodBeat.o(206776);
      return paramString;
    }
    paramString = am(paramString);
    AppMethodBeat.o(206776);
    return paramString;
  }
  
  private static h.ao am(String paramString)
  {
    AppMethodBeat.i(206777);
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
        AppMethodBeat.o(206777);
        return paramString;
      }
      catch (k paramString)
      {
        AppMethodBeat.o(206777);
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
    paramString = h.f.aQv;
    AppMethodBeat.o(206777);
    return paramString;
    paramString = h.g.qT();
    AppMethodBeat.o(206777);
    return paramString;
    return null;
  }
  
  private static h.f an(String paramString)
  {
    AppMethodBeat.i(206778);
    int i;
    if (paramString.charAt(0) == '#')
    {
      localObject = d.f(paramString, paramString.length());
      if (localObject == null)
      {
        paramString = new k("Bad hex colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(206778);
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
        AppMethodBeat.o(206778);
        throw paramString;
      case 4: 
        k = (int)((d)localObject).value;
        i = k & 0xF00;
        j = k & 0xF0;
        k &= 0xF;
        paramString = new h.f(i << 8 | i << 12 | 0xFF000000 | j << 8 | j << 4 | k << 4 | k);
        AppMethodBeat.o(206778);
        return paramString;
      case 5: 
        int m = (int)((d)localObject).value;
        i = 0xF000 & m;
        j = m & 0xF00;
        k = m & 0xF0;
        m &= 0xF;
        paramString = new h.f(i << 4 | m << 24 | m << 28 | i << 8 | j << 4 | j | k | k >> 4);
        AppMethodBeat.o(206778);
        return paramString;
      case 7: 
        paramString = new h.f((int)((d)localObject).value | 0xFF000000);
        AppMethodBeat.o(206778);
        return paramString;
      }
      i = (int)((d)localObject).value;
      paramString = new h.f((int)((d)localObject).value >>> 8 | i << 24);
      AppMethodBeat.o(206778);
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
        ((h)localObject).rs();
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
        ((h)localObject).rs();
        if ((Float.isNaN(f4)) || (!((h)localObject).b(')')))
        {
          paramString = new k("Bad rgba() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(206778);
          throw paramString;
          i = 4;
          break;
        }
        i = T(f4 * 256.0F);
        paramString = new h.f(T(f1) << 16 | i << 24 | T(f2) << 8 | T(f3));
        AppMethodBeat.o(206778);
        return paramString;
      }
      ((h)localObject).rs();
      if ((Float.isNaN(f3)) || (!((h)localObject).b(')')))
      {
        paramString = new k("Bad rgb() colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(206778);
        throw paramString;
      }
      paramString = new h.f(T(f1) << 16 | 0xFF000000 | T(f2) << 8 | T(f3));
      AppMethodBeat.o(206778);
      return paramString;
      bool = ((String)localObject).startsWith("hsla(");
      if ((bool) || (((String)localObject).startsWith("hsl(")))
      {
        if (bool) {}
        for (i = 5;; i = 4)
        {
          localObject = new h(paramString.substring(i));
          ((h)localObject).rs();
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
          ((h)localObject).rs();
          if ((!Float.isNaN(f4)) && (((h)localObject).b(')'))) {
            break;
          }
          paramString = new k("Bad hsla() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(206778);
          throw paramString;
        }
        paramString = new h.f(T(f4 * 256.0F) << 24 | h(f1, f2, f3));
        AppMethodBeat.o(206778);
        return paramString;
        label953:
        ((h)localObject).rs();
        if ((Float.isNaN(f3)) || (!((h)localObject).b(')')))
        {
          paramString = new k("Bad hsl() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(206778);
          throw paramString;
        }
        paramString = new h.f(h(f1, f2, f3) | 0xFF000000);
        AppMethodBeat.o(206778);
        return paramString;
      }
      paramString = ao((String)localObject);
      AppMethodBeat.o(206778);
      return paramString;
    }
  }
  
  private static h.f ao(String paramString)
  {
    AppMethodBeat.i(206781);
    Integer localInteger = l.b.aK(paramString);
    if (localInteger == null)
    {
      paramString = new k("Invalid colour keyword: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(206781);
      throw paramString;
    }
    paramString = new h.f(localInteger.intValue());
    AppMethodBeat.o(206781);
    return paramString;
  }
  
  private static List<String> ap(String paramString)
  {
    AppMethodBeat.i(206783);
    Object localObject1 = null;
    h localh = new h(paramString);
    paramString = (String)localObject1;
    do
    {
      localObject1 = localh.rE();
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
      localh.rt();
      paramString = (String)localObject1;
    } while (!localh.empty());
    AppMethodBeat.o(206783);
    return localObject1;
  }
  
  private static h.p aq(String paramString)
  {
    AppMethodBeat.i(206784);
    try
    {
      h.p localp2 = c.aL(paramString);
      h.p localp1 = localp2;
      if (localp2 == null) {
        localp1 = ag(paramString);
      }
      AppMethodBeat.o(206784);
      return localp1;
    }
    catch (k paramString)
    {
      AppMethodBeat.o(206784);
    }
    return null;
  }
  
  private static h.ae.b ar(String paramString)
  {
    AppMethodBeat.i(206785);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(206785);
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
    paramString = h.ae.b.aSa;
    AppMethodBeat.o(206785);
    return paramString;
    paramString = h.ae.b.aRZ;
    AppMethodBeat.o(206785);
    return paramString;
    paramString = h.ae.b.aSb;
    AppMethodBeat.o(206785);
    return paramString;
  }
  
  private static h.ae.g as(String paramString)
  {
    AppMethodBeat.i(206786);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(206786);
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
    paramString = h.ae.g.aSt;
    AppMethodBeat.o(206786);
    return paramString;
    paramString = h.ae.g.aSu;
    AppMethodBeat.o(206786);
    return paramString;
    paramString = h.ae.g.aSv;
    AppMethodBeat.o(206786);
    return paramString;
    paramString = h.ae.g.aSw;
    AppMethodBeat.o(206786);
    return paramString;
    paramString = h.ae.g.aSx;
    AppMethodBeat.o(206786);
    return paramString;
  }
  
  private static h.ae.h at(String paramString)
  {
    AppMethodBeat.i(206787);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(206787);
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
    paramString = h.ae.h.aSz;
    AppMethodBeat.o(206787);
    return paramString;
    paramString = h.ae.h.aSA;
    AppMethodBeat.o(206787);
    return paramString;
  }
  
  private static h.ae.a au(String paramString)
  {
    AppMethodBeat.i(206788);
    if ("nonzero".equals(paramString))
    {
      paramString = h.ae.a.aRW;
      AppMethodBeat.o(206788);
      return paramString;
    }
    if ("evenodd".equals(paramString))
    {
      paramString = h.ae.a.aRX;
      AppMethodBeat.o(206788);
      return paramString;
    }
    AppMethodBeat.o(206788);
    return null;
  }
  
  private static h.ae.c av(String paramString)
  {
    AppMethodBeat.i(206789);
    if ("butt".equals(paramString))
    {
      paramString = h.ae.c.aSd;
      AppMethodBeat.o(206789);
      return paramString;
    }
    if ("round".equals(paramString))
    {
      paramString = h.ae.c.aSe;
      AppMethodBeat.o(206789);
      return paramString;
    }
    if ("square".equals(paramString))
    {
      paramString = h.ae.c.aSf;
      AppMethodBeat.o(206789);
      return paramString;
    }
    AppMethodBeat.o(206789);
    return null;
  }
  
  private static h.ae.d aw(String paramString)
  {
    AppMethodBeat.i(206790);
    if ("miter".equals(paramString))
    {
      paramString = h.ae.d.aSh;
      AppMethodBeat.o(206790);
      return paramString;
    }
    if ("round".equals(paramString))
    {
      paramString = h.ae.d.aSi;
      AppMethodBeat.o(206790);
      return paramString;
    }
    if ("bevel".equals(paramString))
    {
      paramString = h.ae.d.aSj;
      AppMethodBeat.o(206790);
      return paramString;
    }
    AppMethodBeat.o(206790);
    return null;
  }
  
  private static h.p[] ax(String paramString)
  {
    AppMethodBeat.i(206791);
    paramString = new h(paramString);
    paramString.rs();
    if (paramString.empty())
    {
      AppMethodBeat.o(206791);
      return null;
    }
    h.p localp = paramString.rw();
    if (localp == null)
    {
      AppMethodBeat.o(206791);
      return null;
    }
    if (localp.isNegative())
    {
      AppMethodBeat.o(206791);
      return null;
    }
    float f = localp.value;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localp);
    while (!paramString.empty())
    {
      paramString.rt();
      localp = paramString.rw();
      if (localp == null)
      {
        AppMethodBeat.o(206791);
        return null;
      }
      if (localp.isNegative())
      {
        AppMethodBeat.o(206791);
        return null;
      }
      localArrayList.add(localp);
      f += localp.value;
    }
    if (f == 0.0F)
    {
      AppMethodBeat.o(206791);
      return null;
    }
    paramString = (h.p[])localArrayList.toArray(new h.p[localArrayList.size()]);
    AppMethodBeat.o(206791);
    return paramString;
  }
  
  private static h.ae.f ay(String paramString)
  {
    AppMethodBeat.i(206792);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(206792);
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
    paramString = h.ae.f.aSp;
    AppMethodBeat.o(206792);
    return paramString;
    paramString = h.ae.f.aSq;
    AppMethodBeat.o(206792);
    return paramString;
    paramString = h.ae.f.aSr;
    AppMethodBeat.o(206792);
    return paramString;
  }
  
  private static Boolean az(String paramString)
  {
    AppMethodBeat.i(206793);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(206793);
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
    AppMethodBeat.o(206793);
    return paramString;
    paramString = Boolean.FALSE;
    AppMethodBeat.o(206793);
    return paramString;
  }
  
  private static h.p b(h paramh)
  {
    AppMethodBeat.i(206795);
    if (paramh.aO("auto"))
    {
      paramh = new h.p(0.0F);
      AppMethodBeat.o(206795);
      return paramh;
    }
    paramh = paramh.rw();
    AppMethodBeat.o(206795);
    return paramh;
  }
  
  private static void b(h.al paramal, Attributes paramAttributes)
  {
    AppMethodBeat.i(206762);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      if (str.length() != 0) {
        switch (1.aTW[f.aM(paramAttributes.getLocalName(i)).ordinal()])
        {
        default: 
          if (paramal.aSM == null) {
            paramal.aSM = new h.ae();
          }
          a(paramal.aSM, paramAttributes.getLocalName(i), paramAttributes.getValue(i).trim());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramal, str);
        continue;
        paramal.aSN = b.X(str);
      }
    }
    AppMethodBeat.o(206762);
  }
  
  static void b(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(206708);
    if ((paramString.equals("xml-stylesheet")) && (h.qQ() != null))
    {
      if (((String)paramMap.get("type") != null) && (!"text/css".equals(paramMap.get("type"))))
      {
        AppMethodBeat.o(206708);
        return;
      }
      if (((String)paramMap.get("alternate") != null) && (!"no".equals(paramMap.get("alternate"))))
      {
        AppMethodBeat.o(206708);
        return;
      }
      if ((String)paramMap.get("href") != null)
      {
        h.qQ();
        AppMethodBeat.o(206708);
        return;
      }
    }
    AppMethodBeat.o(206708);
  }
  
  private void b(Attributes paramAttributes)
  {
    AppMethodBeat.i(206712);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206712);
      throw paramAttributes;
    }
    h.m localm = new h.m();
    localm.aSO = this.aTM;
    localm.aSP = this.aTN;
    a(localm, paramAttributes);
    b(localm, paramAttributes);
    a(localm, paramAttributes);
    a(localm, paramAttributes);
    this.aTN.a(localm);
    this.aTN = localm;
    AppMethodBeat.o(206712);
  }
  
  private void c(Attributes paramAttributes)
  {
    AppMethodBeat.i(206713);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206713);
      throw paramAttributes;
    }
    h.h localh = new h.h();
    localh.aSO = this.aTM;
    localh.aSP = this.aTN;
    a(localh, paramAttributes);
    b(localh, paramAttributes);
    a(localh, paramAttributes);
    this.aTN.a(localh);
    this.aTN = localh;
    AppMethodBeat.o(206713);
  }
  
  private void d(Attributes paramAttributes)
  {
    AppMethodBeat.i(206714);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206714);
      throw paramAttributes;
    }
    h.a locala = new h.a();
    locala.aSO = this.aTM;
    locala.aSP = this.aTN;
    a(locala, paramAttributes);
    b(locala, paramAttributes);
    a(locala, paramAttributes);
    a(locala, paramAttributes);
    a(locala, paramAttributes);
    this.aTN.a(locala);
    this.aTN = locala;
    AppMethodBeat.o(206714);
  }
  
  private void e(Attributes paramAttributes)
  {
    AppMethodBeat.i(206716);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206716);
      throw paramAttributes;
    }
    h.be localbe = new h.be();
    localbe.aSO = this.aTM;
    localbe.aSP = this.aTN;
    a(localbe, paramAttributes);
    b(localbe, paramAttributes);
    a(localbe, paramAttributes);
    a(localbe, paramAttributes);
    a(localbe, paramAttributes);
    this.aTN.a(localbe);
    this.aTN = localbe;
    AppMethodBeat.o(206716);
  }
  
  private void f(Attributes paramAttributes)
  {
    AppMethodBeat.i(206718);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206718);
      throw paramAttributes;
    }
    h.o localo = new h.o();
    localo.aSO = this.aTM;
    localo.aSP = this.aTN;
    a(localo, paramAttributes);
    b(localo, paramAttributes);
    a(localo, paramAttributes);
    a(localo, paramAttributes);
    a(localo, paramAttributes);
    this.aTN.a(localo);
    this.aTN = localo;
    AppMethodBeat.o(206718);
  }
  
  private static float g(String paramString, int paramInt)
  {
    AppMethodBeat.i(206771);
    float f = new e().f(paramString, 0, paramInt);
    if (!Float.isNaN(f))
    {
      AppMethodBeat.o(206771);
      return f;
    }
    paramString = new k("Invalid float value: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(206771);
    throw paramString;
  }
  
  private void g(InputStream paramInputStream)
  {
    AppMethodBeat.i(206702);
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
        AppMethodBeat.o(206702);
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
        AppMethodBeat.o(206702);
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
      if (!this.aTO) {
        if (this.aTQ)
        {
          if (this.aTS == null) {
            this.aTS = new StringBuilder(j);
          }
          this.aTS.append((char[])localObject, i, j);
        }
        else if (this.aTT)
        {
          if (this.aTU == null) {
            this.aTU = new StringBuilder(j);
          }
          this.aTU.append((char[])localObject, i, j);
        }
        else if ((this.aTN instanceof h.ay))
        {
          ad(new String((char[])localObject, i, j));
          continue;
          text(localXmlPullParser.getText());
          continue;
          paramInputStream = new h(localXmlPullParser.getText());
          b(paramInputStream.nextToken(), a(paramInputStream));
          label466:
          while (i == 1)
          {
            Object localObject;
            int j;
            AppMethodBeat.o(206702);
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
    AppMethodBeat.i(206720);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206720);
      throw paramAttributes;
    }
    h.v localv = new h.v();
    localv.aSO = this.aTM;
    localv.aSP = this.aTN;
    a(localv, paramAttributes);
    b(localv, paramAttributes);
    a(localv, paramAttributes);
    a(localv, paramAttributes);
    a(localv, paramAttributes);
    this.aTN.a(localv);
    AppMethodBeat.o(206720);
  }
  
  private static int h(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(206780);
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
      AppMethodBeat.o(206780);
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
    AppMethodBeat.i(206722);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206722);
      throw paramAttributes;
    }
    h.ab localab = new h.ab();
    localab.aSO = this.aTM;
    localab.aSP = this.aTN;
    a(localab, paramAttributes);
    b(localab, paramAttributes);
    a(localab, paramAttributes);
    a(localab, paramAttributes);
    a(localab, paramAttributes);
    this.aTN.a(localab);
    AppMethodBeat.o(206722);
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
    AppMethodBeat.i(206724);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206724);
      throw paramAttributes;
    }
    h.d locald = new h.d();
    locald.aSO = this.aTM;
    locald.aSP = this.aTN;
    a(locald, paramAttributes);
    b(locald, paramAttributes);
    a(locald, paramAttributes);
    a(locald, paramAttributes);
    a(locald, paramAttributes);
    this.aTN.a(locald);
    AppMethodBeat.o(206724);
  }
  
  private void j(Attributes paramAttributes)
  {
    AppMethodBeat.i(206726);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206726);
      throw paramAttributes;
    }
    h.i locali = new h.i();
    locali.aSO = this.aTM;
    locali.aSP = this.aTN;
    a(locali, paramAttributes);
    b(locali, paramAttributes);
    a(locali, paramAttributes);
    a(locali, paramAttributes);
    a(locali, paramAttributes);
    this.aTN.a(locali);
    AppMethodBeat.o(206726);
  }
  
  private void k(Attributes paramAttributes)
  {
    AppMethodBeat.i(206728);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206728);
      throw paramAttributes;
    }
    h.q localq = new h.q();
    localq.aSO = this.aTM;
    localq.aSP = this.aTN;
    a(localq, paramAttributes);
    b(localq, paramAttributes);
    a(localq, paramAttributes);
    a(localq, paramAttributes);
    a(localq, paramAttributes);
    this.aTN.a(localq);
    AppMethodBeat.o(206728);
  }
  
  private void l(Attributes paramAttributes)
  {
    AppMethodBeat.i(206730);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206730);
      throw paramAttributes;
    }
    h.z localz = new h.z();
    localz.aSO = this.aTM;
    localz.aSP = this.aTN;
    a(localz, paramAttributes);
    b(localz, paramAttributes);
    a(localz, paramAttributes);
    a(localz, paramAttributes);
    a(localz, paramAttributes, "polyline");
    this.aTN.a(localz);
    AppMethodBeat.o(206730);
  }
  
  private void m(Attributes paramAttributes)
  {
    AppMethodBeat.i(206732);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206732);
      throw paramAttributes;
    }
    h.aa localaa = new h.aa();
    localaa.aSO = this.aTM;
    localaa.aSP = this.aTN;
    a(localaa, paramAttributes);
    b(localaa, paramAttributes);
    a(localaa, paramAttributes);
    a(localaa, paramAttributes);
    a(localaa, paramAttributes, "polygon");
    this.aTN.a(localaa);
    AppMethodBeat.o(206732);
  }
  
  private void n(Attributes paramAttributes)
  {
    AppMethodBeat.i(206733);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206733);
      throw paramAttributes;
    }
    h.aw localaw = new h.aw();
    localaw.aSO = this.aTM;
    localaw.aSP = this.aTN;
    a(localaw, paramAttributes);
    b(localaw, paramAttributes);
    a(localaw, paramAttributes);
    a(localaw, paramAttributes);
    a(localaw, paramAttributes);
    this.aTN.a(localaw);
    this.aTN = localaw;
    AppMethodBeat.o(206733);
  }
  
  private void o(Attributes paramAttributes)
  {
    AppMethodBeat.i(206735);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206735);
      throw paramAttributes;
    }
    if (!(this.aTN instanceof h.ay))
    {
      paramAttributes = new k("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
      AppMethodBeat.o(206735);
      throw paramAttributes;
    }
    h.av localav = new h.av();
    localav.aSO = this.aTM;
    localav.aSP = this.aTN;
    a(localav, paramAttributes);
    b(localav, paramAttributes);
    a(localav, paramAttributes);
    a(localav, paramAttributes);
    this.aTN.a(localav);
    this.aTN = localav;
    if ((localav.aSP instanceof h.bb))
    {
      localav.aSS = ((h.bb)localav.aSP);
      AppMethodBeat.o(206735);
      return;
    }
    localav.aSS = ((h.ax)localav.aSP).ra();
    AppMethodBeat.o(206735);
  }
  
  private void p(Attributes paramAttributes)
  {
    AppMethodBeat.i(206736);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206736);
      throw paramAttributes;
    }
    if (!(this.aTN instanceof h.ay))
    {
      paramAttributes = new k("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
      AppMethodBeat.o(206736);
      throw paramAttributes;
    }
    h.au localau = new h.au();
    localau.aSO = this.aTM;
    localau.aSP = this.aTN;
    a(localau, paramAttributes);
    b(localau, paramAttributes);
    a(localau, paramAttributes);
    a(localau, paramAttributes);
    this.aTN.a(localau);
    if ((localau.aSP instanceof h.bb))
    {
      localau.aSS = ((h.bb)localau.aSP);
      AppMethodBeat.o(206736);
      return;
    }
    localau.aSS = ((h.ax)localau.aSP).ra();
    AppMethodBeat.o(206736);
  }
  
  private static float parseFloat(String paramString)
  {
    AppMethodBeat.i(206770);
    int i = paramString.length();
    if (i == 0)
    {
      paramString = new k("Invalid float value (empty string)");
      AppMethodBeat.o(206770);
      throw paramString;
    }
    float f = g(paramString, i);
    AppMethodBeat.o(206770);
    return f;
  }
  
  private void q(Attributes paramAttributes)
  {
    AppMethodBeat.i(206738);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206738);
      throw paramAttributes;
    }
    h.as localas = new h.as();
    localas.aSO = this.aTM;
    localas.aSP = this.aTN;
    a(localas, paramAttributes);
    b(localas, paramAttributes);
    a(localas, paramAttributes);
    a(localas, paramAttributes);
    this.aTN.a(localas);
    this.aTN = localas;
    AppMethodBeat.o(206738);
  }
  
  private void r(Attributes paramAttributes)
  {
    AppMethodBeat.i(206740);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206740);
      throw paramAttributes;
    }
    h.at localat = new h.at();
    localat.aSO = this.aTM;
    localat.aSP = this.aTN;
    a(localat, paramAttributes);
    b(localat, paramAttributes);
    a(localat, paramAttributes);
    a(localat, paramAttributes);
    this.aTN.a(localat);
    this.aTN = localat;
    AppMethodBeat.o(206740);
  }
  
  private void s(Attributes paramAttributes)
  {
    AppMethodBeat.i(206741);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206741);
      throw paramAttributes;
    }
    h.r localr = new h.r();
    localr.aSO = this.aTM;
    localr.aSP = this.aTN;
    a(localr, paramAttributes);
    b(localr, paramAttributes);
    a(localr, paramAttributes);
    a(localr, paramAttributes);
    a(localr, paramAttributes);
    this.aTN.a(localr);
    this.aTN = localr;
    AppMethodBeat.o(206741);
  }
  
  private void t(Attributes paramAttributes)
  {
    AppMethodBeat.i(206743);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206743);
      throw paramAttributes;
    }
    h.am localam = new h.am();
    localam.aSO = this.aTM;
    localam.aSP = this.aTN;
    a(localam, paramAttributes);
    b(localam, paramAttributes);
    a(localam, paramAttributes);
    a(localam, paramAttributes);
    this.aTN.a(localam);
    this.aTN = localam;
    AppMethodBeat.o(206743);
  }
  
  private void u(Attributes paramAttributes)
  {
    AppMethodBeat.i(206746);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206746);
      throw paramAttributes;
    }
    h.aq localaq = new h.aq();
    localaq.aSO = this.aTM;
    localaq.aSP = this.aTN;
    a(localaq, paramAttributes);
    b(localaq, paramAttributes);
    a(localaq, paramAttributes);
    a(localaq, paramAttributes);
    this.aTN.a(localaq);
    this.aTN = localaq;
    AppMethodBeat.o(206746);
  }
  
  private void v(Attributes paramAttributes)
  {
    AppMethodBeat.i(206748);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206748);
      throw paramAttributes;
    }
    if (!(this.aTN instanceof h.j))
    {
      paramAttributes = new k("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
      AppMethodBeat.o(206748);
      throw paramAttributes;
    }
    h.ad localad = new h.ad();
    localad.aSO = this.aTM;
    localad.aSP = this.aTN;
    a(localad, paramAttributes);
    b(localad, paramAttributes);
    a(localad, paramAttributes);
    this.aTN.a(localad);
    this.aTN = localad;
    AppMethodBeat.o(206748);
  }
  
  private void w(Attributes paramAttributes)
  {
    AppMethodBeat.i(206751);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206751);
      throw paramAttributes;
    }
    h.ac localac = new h.ac();
    localac.aSO = this.aTM;
    localac.aSP = this.aTN;
    a(localac, paramAttributes);
    b(localac, paramAttributes);
    this.aTN.a(localac);
    this.aTN = localac;
    AppMethodBeat.o(206751);
  }
  
  private void x(Attributes paramAttributes)
  {
    AppMethodBeat.i(206752);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206752);
      throw paramAttributes;
    }
    h.e locale = new h.e();
    locale.aSO = this.aTM;
    locale.aSP = this.aTN;
    a(locale, paramAttributes);
    b(locale, paramAttributes);
    a(locale, paramAttributes);
    a(locale, paramAttributes);
    a(locale, paramAttributes);
    this.aTN.a(locale);
    this.aTN = locale;
    AppMethodBeat.o(206752);
  }
  
  private void y(Attributes paramAttributes)
  {
    AppMethodBeat.i(206754);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206754);
      throw paramAttributes;
    }
    h.az localaz = new h.az();
    localaz.aSO = this.aTM;
    localaz.aSP = this.aTN;
    a(localaz, paramAttributes);
    b(localaz, paramAttributes);
    a(localaz, paramAttributes);
    a(localaz, paramAttributes);
    this.aTN.a(localaz);
    this.aTN = localaz;
    if ((localaz.aSP instanceof h.bb))
    {
      localaz.aSS = ((h.bb)localaz.aSP);
      AppMethodBeat.o(206754);
      return;
    }
    localaz.aSS = ((h.ax)localaz.aSP).ra();
    AppMethodBeat.o(206754);
  }
  
  private void z(Attributes paramAttributes)
  {
    AppMethodBeat.i(206756);
    if (this.aTN == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(206756);
      throw paramAttributes;
    }
    h.y localy = new h.y();
    localy.aSO = this.aTM;
    localy.aSP = this.aTN;
    a(localy, paramAttributes);
    b(localy, paramAttributes);
    a(localy, paramAttributes);
    a(localy, paramAttributes);
    a(localy, paramAttributes);
    this.aTN.a(localy);
    this.aTN = localy;
    AppMethodBeat.o(206756);
  }
  
  /* Error */
  final h a(InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 2017
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 2022	java/io/InputStream:markSupported	()Z
    //   10: ifne +381 -> 391
    //   13: new 2024	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 2026	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: iconst_3
    //   24: invokevirtual 2029	java/io/InputStream:mark	(I)V
    //   27: aload_1
    //   28: invokevirtual 2032	java/io/InputStream:read	()I
    //   31: istore_3
    //   32: aload_1
    //   33: invokevirtual 2032	java/io/InputStream:read	()I
    //   36: istore 4
    //   38: aload_1
    //   39: invokevirtual 2035	java/io/InputStream:reset	()V
    //   42: iload_3
    //   43: iload 4
    //   45: bipush 8
    //   47: ishl
    //   48: iadd
    //   49: ldc_w 2036
    //   52: if_icmpne +336 -> 388
    //   55: new 2024	java/io/BufferedInputStream
    //   58: dup
    //   59: new 2038	java/util/zip/GZIPInputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 2039	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: invokespecial 2026	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore 5
    //   72: aload 5
    //   74: astore_1
    //   75: iload_2
    //   76: ifeq +267 -> 343
    //   79: aload_1
    //   80: sipush 4096
    //   83: invokevirtual 2029	java/io/InputStream:mark	(I)V
    //   86: sipush 4096
    //   89: newarray byte
    //   91: astore 5
    //   93: new 137	java/lang/String
    //   96: dup
    //   97: aload 5
    //   99: iconst_0
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 2042	java/io/InputStream:read	([B)I
    //   106: invokespecial 2045	java/lang/String:<init>	([BII)V
    //   109: astore 5
    //   111: aload_1
    //   112: invokevirtual 2035	java/io/InputStream:reset	()V
    //   115: aload 5
    //   117: ldc_w 2047
    //   120: invokevirtual 1473	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   123: istore_3
    //   124: iload_3
    //   125: iflt +218 -> 343
    //   128: invokestatic 2053	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   131: astore 5
    //   133: aload 5
    //   135: ldc_w 2055
    //   138: iconst_0
    //   139: invokevirtual 2056	javax/xml/parsers/SAXParserFactory:setFeature	(Ljava/lang/String;Z)V
    //   142: aload 5
    //   144: ldc_w 2058
    //   147: iconst_0
    //   148: invokevirtual 2056	javax/xml/parsers/SAXParserFactory:setFeature	(Ljava/lang/String;Z)V
    //   151: aload 5
    //   153: invokevirtual 2062	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   156: invokevirtual 2068	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   159: astore 5
    //   161: new 18	com/a/a/l$e
    //   164: dup
    //   165: aload_0
    //   166: iconst_0
    //   167: invokespecial 2071	com/a/a/l$e:<init>	(Lcom/a/a/l;B)V
    //   170: astore 6
    //   172: aload 5
    //   174: aload 6
    //   176: invokeinterface 2077 2 0
    //   181: aload 5
    //   183: ldc_w 2079
    //   186: aload 6
    //   188: invokeinterface 2083 3 0
    //   193: aload 5
    //   195: new 2085	org/xml/sax/InputSource
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 2086	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   203: invokeinterface 2090 2 0
    //   208: aload_0
    //   209: getfield 51	com/a/a/l:aTM	Lcom/a/a/h;
    //   212: astore 5
    //   214: aload_1
    //   215: invokevirtual 2093	java/io/InputStream:close	()V
    //   218: ldc_w 2017
    //   221: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload 5
    //   226: areturn
    //   227: astore 5
    //   229: new 77	com/a/a/k
    //   232: dup
    //   233: ldc_w 1792
    //   236: aload 5
    //   238: invokespecial 1319	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   241: astore 5
    //   243: ldc_w 2017
    //   246: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload 5
    //   251: athrow
    //   252: astore 5
    //   254: aload_0
    //   255: aload_1
    //   256: invokespecial 2095	com/a/a/l:g	(Ljava/io/InputStream;)V
    //   259: aload_0
    //   260: getfield 51	com/a/a/l:aTM	Lcom/a/a/h;
    //   263: astore 5
    //   265: aload_1
    //   266: invokevirtual 2093	java/io/InputStream:close	()V
    //   269: ldc_w 2017
    //   272: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload 5
    //   277: areturn
    //   278: astore 5
    //   280: new 77	com/a/a/k
    //   283: dup
    //   284: ldc_w 2097
    //   287: aload 5
    //   289: invokespecial 1319	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   292: astore 5
    //   294: ldc_w 2017
    //   297: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: aload 5
    //   302: athrow
    //   303: astore 5
    //   305: aload_1
    //   306: invokevirtual 2093	java/io/InputStream:close	()V
    //   309: ldc_w 2017
    //   312: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload 5
    //   317: athrow
    //   318: astore 5
    //   320: new 77	com/a/a/k
    //   323: dup
    //   324: ldc_w 1807
    //   327: aload 5
    //   329: invokespecial 1319	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   332: astore 5
    //   334: ldc_w 2017
    //   337: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload 5
    //   342: athrow
    //   343: aload_0
    //   344: aload_1
    //   345: invokespecial 2095	com/a/a/l:g	(Ljava/io/InputStream;)V
    //   348: aload_0
    //   349: getfield 51	com/a/a/l:aTM	Lcom/a/a/h;
    //   352: astore 5
    //   354: aload_1
    //   355: invokevirtual 2093	java/io/InputStream:close	()V
    //   358: ldc_w 2017
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
    AppMethodBeat.i(206707);
    if (this.aTO)
    {
      int i = this.aTP - 1;
      this.aTP = i;
      if (i == 0) {
        this.aTO = false;
      }
      AppMethodBeat.o(206707);
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1)))
    {
      AppMethodBeat.o(206707);
      return;
    }
    if (paramString2.length() > 0) {
      switch (1.aTV[g.aN(paramString2).ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(206707);
      return;
      paramString2 = paramString3;
      break;
      this.aTQ = false;
      if (this.aTS != null)
      {
        if (this.aTR != g.aWr) {
          break label291;
        }
        this.aTM.title = this.aTS.toString();
      }
      for (;;)
      {
        this.aTS.setLength(0);
        AppMethodBeat.o(206707);
        return;
        label291:
        if (this.aTR == g.aVW) {
          this.aTM.desc = this.aTS.toString();
        }
      }
      if (this.aTU != null)
      {
        this.aTT = false;
        aI(this.aTU.toString());
        this.aTU.setLength(0);
        AppMethodBeat.o(206707);
        return;
        if (this.aTN == null)
        {
          paramString1 = new k(String.format("Unbalanced end element </%s> found", new Object[] { paramString2 }));
          AppMethodBeat.o(206707);
          throw paramString1;
        }
        this.aTN = ((h.an)this.aTN).aSP;
      }
    }
  }
  
  final void startDocument()
  {
    AppMethodBeat.i(206703);
    this.aTM = new h();
    AppMethodBeat.o(206703);
  }
  
  final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    AppMethodBeat.i(206704);
    if (this.aTO)
    {
      this.aTP += 1;
      AppMethodBeat.o(206704);
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1)))
    {
      AppMethodBeat.o(206704);
      return;
    }
    if (paramString2.length() > 0) {}
    for (;;)
    {
      paramString1 = g.aN(paramString2);
      switch (1.aTV[paramString1.ordinal()])
      {
      default: 
        this.aTO = true;
        this.aTP = 1;
        AppMethodBeat.o(206704);
        return;
        paramString2 = paramString3;
      }
    }
    a(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    b(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    c(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    d(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    e(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    g(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    h(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    i(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    j(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    k(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    l(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    m(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    n(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    o(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    p(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    q(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    r(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    s(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    t(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    u(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    v(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    this.aTQ = true;
    this.aTR = paramString1;
    AppMethodBeat.o(206704);
    return;
    x(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    y(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    z(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    f(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    A(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    B(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    C(paramAttributes);
    AppMethodBeat.o(206704);
    return;
    w(paramAttributes);
    AppMethodBeat.o(206704);
  }
  
  final void text(String paramString)
  {
    AppMethodBeat.i(206705);
    if (this.aTO)
    {
      AppMethodBeat.o(206705);
      return;
    }
    if (this.aTQ)
    {
      if (this.aTS == null) {
        this.aTS = new StringBuilder(paramString.length());
      }
      this.aTS.append(paramString);
      AppMethodBeat.o(206705);
      return;
    }
    if (this.aTT)
    {
      if (this.aTU == null) {
        this.aTU = new StringBuilder(paramString.length());
      }
      this.aTU.append(paramString);
      AppMethodBeat.o(206705);
      return;
    }
    if ((this.aTN instanceof h.ay)) {
      ad(paramString);
    }
    AppMethodBeat.o(206705);
  }
  
  static final class a
  {
    private static final Map<String, f.a> aTX;
    
    static
    {
      AppMethodBeat.i(206652);
      HashMap localHashMap = new HashMap(10);
      aTX = localHashMap;
      localHashMap.put("none", f.a.aPK);
      aTX.put("xMinYMin", f.a.aPL);
      aTX.put("xMidYMin", f.a.aPM);
      aTX.put("xMaxYMin", f.a.aPN);
      aTX.put("xMinYMid", f.a.aPO);
      aTX.put("xMidYMid", f.a.aPP);
      aTX.put("xMaxYMid", f.a.aPQ);
      aTX.put("xMinYMax", f.a.aPR);
      aTX.put("xMidYMax", f.a.aPS);
      aTX.put("xMaxYMax", f.a.aPT);
      AppMethodBeat.o(206652);
    }
    
    static f.a aJ(String paramString)
    {
      AppMethodBeat.i(206651);
      paramString = (f.a)aTX.get(paramString);
      AppMethodBeat.o(206651);
      return paramString;
    }
  }
  
  static final class c
  {
    private static final Map<String, h.p> aTZ;
    
    static
    {
      AppMethodBeat.i(206656);
      HashMap localHashMap = new HashMap(9);
      aTZ = localHashMap;
      localHashMap.put("xx-small", new h.p(0.694F, h.bd.aTe));
      aTZ.put("x-small", new h.p(0.833F, h.bd.aTe));
      aTZ.put("small", new h.p(10.0F, h.bd.aTe));
      aTZ.put("medium", new h.p(12.0F, h.bd.aTe));
      aTZ.put("large", new h.p(14.4F, h.bd.aTe));
      aTZ.put("x-large", new h.p(17.299999F, h.bd.aTe));
      aTZ.put("xx-large", new h.p(20.700001F, h.bd.aTe));
      aTZ.put("smaller", new h.p(83.330002F, h.bd.aTg));
      aTZ.put("larger", new h.p(120.0F, h.bd.aTg));
      AppMethodBeat.o(206656);
    }
    
    static h.p aL(String paramString)
    {
      AppMethodBeat.i(206655);
      paramString = (h.p)aTZ.get(paramString);
      AppMethodBeat.o(206655);
      return paramString;
    }
  }
  
  final class e
    extends DefaultHandler2
  {
    private e() {}
    
    public final void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(206661);
      l.this.text(new String(paramArrayOfChar, paramInt1, paramInt2));
      AppMethodBeat.o(206661);
    }
    
    public final void endDocument() {}
    
    public final void endElement(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(206662);
      l.this.endElement(paramString1, paramString2, paramString3);
      AppMethodBeat.o(206662);
    }
    
    public final void processingInstruction(String paramString1, String paramString2)
    {
      AppMethodBeat.i(206663);
      l.b(paramString1, l.a(new l.h(paramString2)));
      AppMethodBeat.o(206663);
    }
    
    public final void startDocument()
    {
      AppMethodBeat.i(206659);
      l.this.startDocument();
      AppMethodBeat.o(206659);
    }
    
    public final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    {
      AppMethodBeat.i(206660);
      l.this.startElement(paramString1, paramString2, paramString3, paramAttributes);
      AppMethodBeat.o(206660);
    }
  }
  
  static enum f
  {
    private static final Map<String, f> aNT;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(206667);
      aUc = new f("CLASS", 0);
      aUd = new f("clip", 1);
      aUe = new f("clip_path", 2);
      aUf = new f("clipPathUnits", 3);
      aUg = new f("clip_rule", 4);
      aUh = new f("color", 5);
      aUi = new f("cx", 6);
      aUj = new f("cy", 7);
      aUk = new f("direction", 8);
      aUl = new f("dx", 9);
      aUm = new f("dy", 10);
      aUn = new f("fx", 11);
      aUo = new f("fy", 12);
      aUp = new f("d", 13);
      aUq = new f("display", 14);
      aUr = new f("fill", 15);
      aUs = new f("fill_rule", 16);
      aUt = new f("fill_opacity", 17);
      aUu = new f("font", 18);
      aUv = new f("font_family", 19);
      aUw = new f("font_size", 20);
      aUx = new f("font_weight", 21);
      aUy = new f("font_style", 22);
      aUz = new f("gradientTransform", 23);
      aUA = new f("gradientUnits", 24);
      aUB = new f("height", 25);
      aUC = new f("href", 26);
      aUD = new f("image_rendering", 27);
      aUE = new f("marker", 28);
      aUF = new f("marker_start", 29);
      aUG = new f("marker_mid", 30);
      aUH = new f("marker_end", 31);
      aUI = new f("markerHeight", 32);
      aUJ = new f("markerUnits", 33);
      aUK = new f("markerWidth", 34);
      aUL = new f("mask", 35);
      aUM = new f("maskContentUnits", 36);
      aUN = new f("maskUnits", 37);
      aUO = new f("media", 38);
      aUP = new f("offset", 39);
      aUQ = new f("opacity", 40);
      aUR = new f("orient", 41);
      aUS = new f("overflow", 42);
      aUT = new f("pathLength", 43);
      aUU = new f("patternContentUnits", 44);
      aUV = new f("patternTransform", 45);
      aUW = new f("patternUnits", 46);
      aUX = new f("points", 47);
      aUY = new f("preserveAspectRatio", 48);
      aUZ = new f("r", 49);
      aVa = new f("refX", 50);
      aVb = new f("refY", 51);
      aVc = new f("requiredFeatures", 52);
      aVd = new f("requiredExtensions", 53);
      aVe = new f("requiredFormats", 54);
      aVf = new f("requiredFonts", 55);
      aVg = new f("rx", 56);
      aVh = new f("ry", 57);
      aVi = new f("solid_color", 58);
      aVj = new f("solid_opacity", 59);
      aVk = new f("spreadMethod", 60);
      aVl = new f("startOffset", 61);
      aVm = new f("stop_color", 62);
      aVn = new f("stop_opacity", 63);
      aVo = new f("stroke", 64);
      aVp = new f("stroke_dasharray", 65);
      aVq = new f("stroke_dashoffset", 66);
      aVr = new f("stroke_linecap", 67);
      aVs = new f("stroke_linejoin", 68);
      aVt = new f("stroke_miterlimit", 69);
      aVu = new f("stroke_opacity", 70);
      aVv = new f("stroke_width", 71);
      aVw = new f("style", 72);
      aVx = new f("systemLanguage", 73);
      aVy = new f("text_anchor", 74);
      aVz = new f("text_decoration", 75);
      aVA = new f("transform", 76);
      aVB = new f("type", 77);
      aVC = new f("vector_effect", 78);
      aVD = new f("version", 79);
      aVE = new f("viewBox", 80);
      aVF = new f("width", 81);
      aVG = new f("x", 82);
      aVH = new f("y", 83);
      aVI = new f("x1", 84);
      aVJ = new f("y1", 85);
      aVK = new f("x2", 86);
      aVL = new f("y2", 87);
      aVM = new f("viewport_fill", 88);
      aVN = new f("viewport_fill_opacity", 89);
      aVO = new f("visibility", 90);
      aVP = new f("UNSUPPORTED", 91);
      aVQ = new f[] { aUc, aUd, aUe, aUf, aUg, aUh, aUi, aUj, aUk, aUl, aUm, aUn, aUo, aUp, aUq, aUr, aUs, aUt, aUu, aUv, aUw, aUx, aUy, aUz, aUA, aUB, aUC, aUD, aUE, aUF, aUG, aUH, aUI, aUJ, aUK, aUL, aUM, aUN, aUO, aUP, aUQ, aUR, aUS, aUT, aUU, aUV, aUW, aUX, aUY, aUZ, aVa, aVb, aVc, aVd, aVe, aVf, aVg, aVh, aVi, aVj, aVk, aVl, aVm, aVn, aVo, aVp, aVq, aVr, aVs, aVt, aVu, aVv, aVw, aVx, aVy, aVz, aVA, aVB, aVC, aVD, aVE, aVF, aVG, aVH, aVI, aVJ, aVK, aVL, aVM, aVN, aVO, aVP };
      aNT = new HashMap();
      f[] arrayOff = values();
      int j = arrayOff.length;
      if (i < j)
      {
        f localf = arrayOff[i];
        if (localf == aUc) {
          aNT.put("class", localf);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localf != aVP)
          {
            String str = localf.name().replace('_', '-');
            aNT.put(str, localf);
          }
        }
      }
      AppMethodBeat.o(206667);
    }
    
    private f() {}
    
    public static f aM(String paramString)
    {
      AppMethodBeat.i(206666);
      paramString = (f)aNT.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(206666);
        return paramString;
      }
      paramString = aVP;
      AppMethodBeat.o(206666);
      return paramString;
    }
  }
  
  static enum g
  {
    private static final Map<String, g> aNT;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(206671);
      aVR = new g("svg", 0);
      aVS = new g("a", 1);
      aVT = new g("circle", 2);
      aVU = new g("clipPath", 3);
      aVV = new g("defs", 4);
      aVW = new g("desc", 5);
      aVX = new g("ellipse", 6);
      aVY = new g("g", 7);
      aVZ = new g("image", 8);
      aWa = new g("line", 9);
      aWb = new g("linearGradient", 10);
      aWc = new g("marker", 11);
      aWd = new g("mask", 12);
      aWe = new g("path", 13);
      aWf = new g("pattern", 14);
      aWg = new g("polygon", 15);
      aWh = new g("polyline", 16);
      aWi = new g("radialGradient", 17);
      aWj = new g("rect", 18);
      aWk = new g("solidColor", 19);
      aWl = new g("stop", 20);
      aWm = new g("style", 21);
      aWn = new g("SWITCH", 22);
      aWo = new g("symbol", 23);
      aWp = new g("text", 24);
      aWq = new g("textPath", 25);
      aWr = new g("title", 26);
      aWs = new g("tref", 27);
      aWt = new g("tspan", 28);
      aWu = new g("use", 29);
      aWv = new g("view", 30);
      aWw = new g("UNSUPPORTED", 31);
      aWx = new g[] { aVR, aVS, aVT, aVU, aVV, aVW, aVX, aVY, aVZ, aWa, aWb, aWc, aWd, aWe, aWf, aWg, aWh, aWi, aWj, aWk, aWl, aWm, aWn, aWo, aWp, aWq, aWr, aWs, aWt, aWu, aWv, aWw };
      aNT = new HashMap();
      g[] arrayOfg = values();
      int j = arrayOfg.length;
      if (i < j)
      {
        g localg = arrayOfg[i];
        if (localg == aWn) {
          aNT.put("switch", localg);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localg != aWw)
          {
            String str = localg.name();
            aNT.put(str, localg);
          }
        }
      }
      AppMethodBeat.o(206671);
    }
    
    private g() {}
    
    public static g aN(String paramString)
    {
      AppMethodBeat.i(206670);
      paramString = (g)aNT.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(206670);
        return paramString;
      }
      paramString = aWw;
      AppMethodBeat.o(206670);
      return paramString;
    }
  }
  
  static class h
  {
    private e aWA;
    String aWy;
    int aWz;
    int position;
    
    h(String paramString)
    {
      AppMethodBeat.i(206672);
      this.position = 0;
      this.aWz = 0;
      this.aWA = new e();
      this.aWy = paramString.trim();
      this.aWz = this.aWy.length();
      AppMethodBeat.o(206672);
    }
    
    static boolean dw(int paramInt)
    {
      return (paramInt == 10) || (paramInt == 13);
    }
    
    static boolean isWhitespace(int paramInt)
    {
      return (paramInt == 32) || (paramInt == 10) || (paramInt == 13) || (paramInt == 9);
    }
    
    private Boolean rx()
    {
      AppMethodBeat.i(206681);
      if (this.position == this.aWz)
      {
        AppMethodBeat.o(206681);
        return null;
      }
      int i = this.aWy.charAt(this.position);
      if ((i == 48) || (i == 49))
      {
        this.position += 1;
        if (i == 49) {}
        for (boolean bool = true;; bool = false)
        {
          AppMethodBeat.o(206681);
          return Boolean.valueOf(bool);
        }
      }
      AppMethodBeat.o(206681);
      return null;
    }
    
    final float U(float paramFloat)
    {
      AppMethodBeat.i(206677);
      if (Float.isNaN(paramFloat))
      {
        AppMethodBeat.o(206677);
        return (0.0F / 0.0F);
      }
      rt();
      paramFloat = nextFloat();
      AppMethodBeat.o(206677);
      return paramFloat;
    }
    
    final float a(Boolean paramBoolean)
    {
      AppMethodBeat.i(206678);
      if (paramBoolean == null)
      {
        AppMethodBeat.o(206678);
        return (0.0F / 0.0F);
      }
      rt();
      float f = nextFloat();
      AppMethodBeat.o(206678);
      return f;
    }
    
    final String a(char paramChar, boolean paramBoolean)
    {
      AppMethodBeat.i(206688);
      if (empty())
      {
        AppMethodBeat.o(206688);
        return null;
      }
      char c = this.aWy.charAt(this.position);
      if (((!paramBoolean) && (isWhitespace(c))) || (c == paramChar))
      {
        AppMethodBeat.o(206688);
        return null;
      }
      int i = this.position;
      for (c = ry(); (c != 'ð¿¿') && (c != paramChar) && ((paramBoolean) || (!isWhitespace(c))); c = ry()) {}
      String str = this.aWy.substring(i, this.position);
      AppMethodBeat.o(206688);
      return str;
    }
    
    final boolean aO(String paramString)
    {
      AppMethodBeat.i(206684);
      int i = paramString.length();
      if ((this.position <= this.aWz - i) && (this.aWy.substring(this.position, this.position + i).equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.position = (i + this.position);
        }
        AppMethodBeat.o(206684);
        return bool;
      }
    }
    
    final Boolean ab(Object paramObject)
    {
      AppMethodBeat.i(206682);
      if (paramObject == null)
      {
        AppMethodBeat.o(206682);
        return null;
      }
      rt();
      paramObject = rx();
      AppMethodBeat.o(206682);
      return paramObject;
    }
    
    final boolean b(char paramChar)
    {
      AppMethodBeat.i(206683);
      if ((this.position < this.aWz) && (this.aWy.charAt(this.position) == paramChar)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.position += 1;
        }
        AppMethodBeat.o(206683);
        return bool;
      }
    }
    
    final String c(char paramChar)
    {
      AppMethodBeat.i(206687);
      String str = a(paramChar, false);
      AppMethodBeat.o(206687);
      return str;
    }
    
    final boolean empty()
    {
      return this.position == this.aWz;
    }
    
    final float nextFloat()
    {
      AppMethodBeat.i(206675);
      float f = this.aWA.f(this.aWy, this.position, this.aWz);
      if (!Float.isNaN(f)) {
        this.position = this.aWA.pos;
      }
      AppMethodBeat.o(206675);
      return f;
    }
    
    final String nextToken()
    {
      AppMethodBeat.i(258580);
      String str = a(' ', false);
      AppMethodBeat.o(258580);
      return str;
    }
    
    final String rA()
    {
      AppMethodBeat.i(206690);
      if (empty())
      {
        AppMethodBeat.o(206690);
        return null;
      }
      int j = this.position;
      for (int i = this.aWy.charAt(this.position); ((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)); i = ry()) {}
      int k = this.position;
      while (isWhitespace(i)) {
        i = ry();
      }
      if (i == 40)
      {
        this.position += 1;
        String str = this.aWy.substring(j, k);
        AppMethodBeat.o(206690);
        return str;
      }
      this.position = j;
      AppMethodBeat.o(206690);
      return null;
    }
    
    final String rB()
    {
      AppMethodBeat.i(206691);
      int i = this.position;
      while ((!empty()) && (!isWhitespace(this.aWy.charAt(this.position)))) {
        this.position += 1;
      }
      String str = this.aWy.substring(i, this.position);
      this.position = i;
      AppMethodBeat.o(206691);
      return str;
    }
    
    final h.bd rC()
    {
      AppMethodBeat.i(206692);
      if (empty())
      {
        AppMethodBeat.o(206692);
        return null;
      }
      h.bd localbd;
      if (this.aWy.charAt(this.position) == '%')
      {
        this.position += 1;
        localbd = h.bd.aTg;
        AppMethodBeat.o(206692);
        return localbd;
      }
      if (this.position > this.aWz - 2)
      {
        AppMethodBeat.o(206692);
        return null;
      }
      try
      {
        localbd = h.bd.valueOf(this.aWy.substring(this.position, this.position + 2).toLowerCase(Locale.US));
        this.position += 2;
        AppMethodBeat.o(206692);
        return localbd;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        AppMethodBeat.o(206692);
      }
      return null;
    }
    
    final boolean rD()
    {
      AppMethodBeat.i(206693);
      if (this.position == this.aWz)
      {
        AppMethodBeat.o(206693);
        return false;
      }
      int i = this.aWy.charAt(this.position);
      if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
      {
        AppMethodBeat.o(206693);
        return true;
      }
      AppMethodBeat.o(206693);
      return false;
    }
    
    final String rE()
    {
      AppMethodBeat.i(206694);
      if (empty())
      {
        AppMethodBeat.o(206694);
        return null;
      }
      int i = this.position;
      int j = this.aWy.charAt(this.position);
      if ((j != 39) && (j != 34))
      {
        AppMethodBeat.o(206694);
        return null;
      }
      int k;
      do
      {
        k = ry();
      } while ((k != -1) && (k != j));
      if (k == -1)
      {
        this.position = i;
        AppMethodBeat.o(206694);
        return null;
      }
      this.position += 1;
      String str = this.aWy.substring(i + 1, this.position - 1);
      AppMethodBeat.o(206694);
      return str;
    }
    
    final String rF()
    {
      AppMethodBeat.i(206695);
      if (empty())
      {
        AppMethodBeat.o(206695);
        return null;
      }
      int i = this.position;
      this.position = this.aWz;
      String str = this.aWy.substring(i);
      AppMethodBeat.o(206695);
      return str;
    }
    
    final void rs()
    {
      AppMethodBeat.i(206673);
      while ((this.position < this.aWz) && (isWhitespace(this.aWy.charAt(this.position)))) {
        this.position += 1;
      }
      AppMethodBeat.o(206673);
    }
    
    final boolean rt()
    {
      AppMethodBeat.i(206674);
      rs();
      if (this.position == this.aWz)
      {
        AppMethodBeat.o(206674);
        return false;
      }
      if (this.aWy.charAt(this.position) != ',')
      {
        AppMethodBeat.o(206674);
        return false;
      }
      this.position += 1;
      rs();
      AppMethodBeat.o(206674);
      return true;
    }
    
    final float ru()
    {
      AppMethodBeat.i(206676);
      rt();
      float f = this.aWA.f(this.aWy, this.position, this.aWz);
      if (!Float.isNaN(f)) {
        this.position = this.aWA.pos;
      }
      AppMethodBeat.o(206676);
      return f;
    }
    
    final Integer rv()
    {
      AppMethodBeat.i(206679);
      if (this.position == this.aWz)
      {
        AppMethodBeat.o(206679);
        return null;
      }
      String str = this.aWy;
      int i = this.position;
      this.position = (i + 1);
      i = str.charAt(i);
      AppMethodBeat.o(206679);
      return Integer.valueOf(i);
    }
    
    final h.p rw()
    {
      AppMethodBeat.i(206680);
      float f = nextFloat();
      if (Float.isNaN(f))
      {
        AppMethodBeat.o(206680);
        return null;
      }
      Object localObject = rC();
      if (localObject == null)
      {
        localObject = new h.p(f, h.bd.aSY);
        AppMethodBeat.o(206680);
        return localObject;
      }
      localObject = new h.p(f, (h.bd)localObject);
      AppMethodBeat.o(206680);
      return localObject;
    }
    
    final int ry()
    {
      AppMethodBeat.i(206685);
      if (this.position == this.aWz)
      {
        AppMethodBeat.o(206685);
        return -1;
      }
      this.position += 1;
      if (this.position < this.aWz)
      {
        int i = this.aWy.charAt(this.position);
        AppMethodBeat.o(206685);
        return i;
      }
      AppMethodBeat.o(206685);
      return -1;
    }
    
    final String rz()
    {
      AppMethodBeat.i(206689);
      if (empty())
      {
        AppMethodBeat.o(206689);
        return null;
      }
      int j = this.position;
      int i = this.aWy.charAt(this.position);
      if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)))
      {
        for (i = ry(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)); i = ry()) {}
        String str = this.aWy.substring(j, this.position);
        AppMethodBeat.o(206689);
        return str;
      }
      this.position = j;
      AppMethodBeat.o(206689);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.a.a.l
 * JD-Core Version:    0.7.0.1
 */