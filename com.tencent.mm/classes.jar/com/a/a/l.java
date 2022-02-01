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
  private h cxV = null;
  private h.aj cxW = null;
  private boolean cxX = false;
  private int cxY;
  private boolean cxZ = false;
  private g cya = null;
  private StringBuilder cyb = null;
  private boolean cyc = false;
  private StringBuilder cyd = null;
  
  private void A(Attributes paramAttributes)
  {
    AppMethodBeat.i(207989);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207989);
      throw paramAttributes;
    }
    h.bf localbf = new h.bf();
    localbf.cwY = this.cxV;
    localbf.cwZ = this.cxW;
    a(localbf, paramAttributes);
    a(localbf, paramAttributes);
    a(localbf, paramAttributes);
    this.cxW.a(localbf);
    this.cxW = localbf;
    AppMethodBeat.o(207989);
  }
  
  private void B(Attributes paramAttributes)
  {
    AppMethodBeat.i(207991);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207991);
      throw paramAttributes;
    }
    h.s locals = new h.s();
    locals.cwY = this.cxV;
    locals.cwZ = this.cxW;
    a(locals, paramAttributes);
    b(locals, paramAttributes);
    a(locals, paramAttributes);
    a(locals, paramAttributes);
    this.cxW.a(locals);
    this.cxW = locals;
    AppMethodBeat.o(207991);
  }
  
  private void C(Attributes paramAttributes)
  {
    AppMethodBeat.i(208199);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(208199);
      throw paramAttributes;
    }
    Object localObject = "all";
    int i = 0;
    boolean bool = true;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
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
    if ((bool) && (b.a((String)localObject, b.e.csF)))
    {
      this.cyc = true;
      AppMethodBeat.o(208199);
      return;
    }
    this.cxX = true;
    this.cxY = 1;
    AppMethodBeat.o(208199);
  }
  
  static Map<String, String> a(h paramh)
  {
    AppMethodBeat.i(207817);
    HashMap localHashMap = new HashMap();
    paramh.Oz();
    for (String str = paramh.d('='); str != null; str = paramh.d('='))
    {
      paramh.c('=');
      localHashMap.put(str, paramh.ON());
      paramh.Oz();
    }
    AppMethodBeat.o(207817);
    return localHashMap;
  }
  
  private static void a(h.a parama, Attributes paramAttributes)
  {
    AppMethodBeat.i(207871);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
          parama.cut = str;
        }
      }
    }
    AppMethodBeat.o(207871);
  }
  
  private static void a(h.ab paramab, Attributes paramAttributes)
  {
    AppMethodBeat.i(207922);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
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
                paramab.cuP = bt(str);
                continue;
                paramab.cuQ = bt(str);
              }
              paramab.cuR = bt(str);
            } while (!paramab.cuR.isNegative());
            paramab = new k("Invalid <rect> element. width cannot be negative");
            AppMethodBeat.o(207922);
            throw paramab;
            paramab.cuS = bt(str);
          } while (!paramab.cuS.isNegative());
          paramab = new k("Invalid <rect> element. height cannot be negative");
          AppMethodBeat.o(207922);
          throw paramab;
          paramab.cuG = bt(str);
        } while (!paramab.cuG.isNegative());
        paramab = new k("Invalid <rect> element. rx cannot be negative");
        AppMethodBeat.o(207922);
        throw paramab;
        paramab.cuH = bt(str);
      } while (!paramab.cuH.isNegative());
      paramab = new k("Invalid <rect> element. ry cannot be negative");
      AppMethodBeat.o(207922);
      throw paramab;
    }
    AppMethodBeat.o(207922);
  }
  
  private static void a(h.ad paramad, Attributes paramAttributes)
  {
    AppMethodBeat.i(207974);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramad.cvr = br(str);
      }
    }
    AppMethodBeat.o(207974);
  }
  
  private static void a(h.ae paramae, String paramString)
  {
    AppMethodBeat.i(208046);
    if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains("|" + paramString + '|'))
    {
      AppMethodBeat.o(208046);
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
      str = localh.d('/');
      localh.Oz();
      if (str == null)
      {
        AppMethodBeat.o(208046);
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
          localObject3 = l.d.bY(str);
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = paramString;
          if (paramString == null)
          {
            localObject2 = bF(str);
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
    paramString = bE(str);
    if (localh.c('/'))
    {
      localh.Oz();
      localObject1 = localh.OH();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        bt((String)localObject1);
        localh.Oz();
        paramae.cvH = bD(localh.OO());
        paramae.cvI = paramString;
        if (localObject5 == null)
        {
          i = 400;
          paramae.cvJ = Integer.valueOf(i);
          paramString = (String)localObject2;
          if (localObject2 == null) {
            paramString = h.ae.b.cwj;
          }
          paramae.cvK = paramString;
          paramae.cvs |= 0x1E000;
          AppMethodBeat.o(208046);
          return;
        }
      }
      catch (k paramae)
      {
        AppMethodBeat.o(208046);
        return;
      }
      int i = localObject5.intValue();
    }
  }
  
  static void a(h.ae paramae, String paramString1, String paramString2)
  {
    AppMethodBeat.i(208002);
    if (paramString2.length() == 0)
    {
      AppMethodBeat.o(208002);
      return;
    }
    if (paramString2.equals("inherit"))
    {
      AppMethodBeat.o(208002);
      return;
    }
    switch (1.cyf[f.ca(paramString1).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208002);
      return;
      paramae.cvt = bz(paramString2);
      if (paramae.cvt != null)
      {
        paramae.cvs |= 1L;
        AppMethodBeat.o(208002);
        return;
        paramae.cvu = bI(paramString2);
        if (paramae.cvu != null)
        {
          paramae.cvs |= 0x2;
          AppMethodBeat.o(208002);
          return;
          paramae.cvw = bw(paramString2);
          if (paramae.cvw != null)
          {
            paramae.cvs |= 0x4;
            AppMethodBeat.o(208002);
            return;
            paramae.cvx = bz(paramString2);
            if (paramae.cvx != null)
            {
              paramae.cvs |= 0x8;
              AppMethodBeat.o(208002);
              return;
              paramae.cvy = bw(paramString2);
              if (paramae.cvy != null)
              {
                paramae.cvs |= 0x10;
                AppMethodBeat.o(208002);
                return;
                try
                {
                  paramae.cvz = bt(paramString2);
                  paramae.cvs |= 0x20;
                  AppMethodBeat.o(208002);
                  return;
                }
                catch (k paramae)
                {
                  AppMethodBeat.o(208002);
                  return;
                }
                paramae.cvA = bJ(paramString2);
                if (paramae.cvA != null)
                {
                  paramae.cvs |= 0x40;
                  AppMethodBeat.o(208002);
                  return;
                  paramae.cvB = bK(paramString2);
                  if (paramae.cvB != null)
                  {
                    paramae.cvs |= 0x80;
                    AppMethodBeat.o(208002);
                    return;
                    try
                    {
                      paramae.cvC = Float.valueOf(bv(paramString2));
                      paramae.cvs |= 0x100;
                      AppMethodBeat.o(208002);
                      return;
                    }
                    catch (k paramae)
                    {
                      AppMethodBeat.o(208002);
                      return;
                    }
                    if ("none".equals(paramString2))
                    {
                      paramae.cvD = null;
                      paramae.cvs |= 0x200;
                      AppMethodBeat.o(208002);
                      return;
                    }
                    paramae.cvD = bL(paramString2);
                    if (paramae.cvD != null)
                    {
                      paramae.cvs |= 0x200;
                      AppMethodBeat.o(208002);
                      return;
                      try
                      {
                        paramae.cvE = bt(paramString2);
                        paramae.cvs |= 0x400;
                        AppMethodBeat.o(208002);
                        return;
                      }
                      catch (k paramae)
                      {
                        AppMethodBeat.o(208002);
                        return;
                      }
                      paramae.cvF = bw(paramString2);
                      paramae.cvs |= 0x800;
                      AppMethodBeat.o(208002);
                      return;
                      try
                      {
                        paramae.cvG = bB(paramString2);
                        paramae.cvs |= 0x1000;
                        AppMethodBeat.o(208002);
                        return;
                      }
                      catch (k paramae)
                      {
                        AppMethodBeat.o(208002);
                        return;
                      }
                      a(paramae, paramString2);
                      AppMethodBeat.o(208002);
                      return;
                      paramae.cvH = bD(paramString2);
                      if (paramae.cvH != null)
                      {
                        paramae.cvs |= 0x2000;
                        AppMethodBeat.o(208002);
                        return;
                        paramae.cvI = bE(paramString2);
                        if (paramae.cvI != null)
                        {
                          paramae.cvs |= 0x4000;
                          AppMethodBeat.o(208002);
                          return;
                          paramae.cvJ = l.d.bY(paramString2);
                          if (paramae.cvJ != null)
                          {
                            paramae.cvs |= 0x8000;
                            AppMethodBeat.o(208002);
                            return;
                            paramae.cvK = bF(paramString2);
                            if (paramae.cvK != null)
                            {
                              paramae.cvs |= 0x10000;
                              AppMethodBeat.o(208002);
                              return;
                              paramae.cvL = bG(paramString2);
                              if (paramae.cvL != null)
                              {
                                paramae.cvs |= 0x20000;
                                AppMethodBeat.o(208002);
                                return;
                                paramae.cvM = bH(paramString2);
                                if (paramae.cvM != null)
                                {
                                  paramae.cvs |= 0x0;
                                  AppMethodBeat.o(208002);
                                  return;
                                  paramae.cvN = bM(paramString2);
                                  if (paramae.cvN != null)
                                  {
                                    paramae.cvs |= 0x40000;
                                    AppMethodBeat.o(208002);
                                    return;
                                    paramae.cvO = bN(paramString2);
                                    if (paramae.cvO != null)
                                    {
                                      paramae.cvs |= 0x80000;
                                      AppMethodBeat.o(208002);
                                      return;
                                      paramae.cvQ = bV(paramString2);
                                      paramae.cvR = paramae.cvQ;
                                      paramae.cvS = paramae.cvQ;
                                      paramae.cvs |= 0xE00000;
                                      AppMethodBeat.o(208002);
                                      return;
                                      paramae.cvQ = bV(paramString2);
                                      paramae.cvs |= 0x200000;
                                      AppMethodBeat.o(208002);
                                      return;
                                      paramae.cvR = bV(paramString2);
                                      paramae.cvs |= 0x400000;
                                      AppMethodBeat.o(208002);
                                      return;
                                      paramae.cvS = bV(paramString2);
                                      paramae.cvs |= 0x800000;
                                      AppMethodBeat.o(208002);
                                      return;
                                      if ((paramString2.indexOf('|') < 0) && ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains("|" + paramString2 + '|')))
                                      {
                                        if (!paramString2.equals("none")) {}
                                        for (boolean bool = true;; bool = false)
                                        {
                                          paramae.cvT = Boolean.valueOf(bool);
                                          paramae.cvs |= 0x1000000;
                                          AppMethodBeat.o(208002);
                                          return;
                                        }
                                        if ((paramString2.indexOf('|') < 0) && ("|visible|hidden|collapse|".contains("|" + paramString2 + '|')))
                                        {
                                          paramae.cvU = Boolean.valueOf(paramString2.equals("visible"));
                                          paramae.cvs |= 0x2000000;
                                          AppMethodBeat.o(208002);
                                          return;
                                          if (paramString2.equals("currentColor")) {
                                            paramae.cvV = h.g.NY();
                                          }
                                          for (;;)
                                          {
                                            paramae.cvs |= 0x4000000;
                                            AppMethodBeat.o(208002);
                                            return;
                                            try
                                            {
                                              paramae.cvV = bB(paramString2);
                                            }
                                            catch (k paramae)
                                            {
                                              paramae.getMessage();
                                              AppMethodBeat.o(208002);
                                              return;
                                            }
                                          }
                                          paramae.cvW = bw(paramString2);
                                          paramae.cvs |= 0x8000000;
                                          AppMethodBeat.o(208002);
                                          return;
                                          paramae.cvP = bO(paramString2);
                                          if (paramae.cvP != null)
                                          {
                                            paramae.cvs |= 0x100000;
                                            AppMethodBeat.o(208002);
                                            return;
                                            paramae.cvX = bV(paramString2);
                                            paramae.cvs |= 0x10000000;
                                            AppMethodBeat.o(208002);
                                            return;
                                            paramae.cvY = bI(paramString2);
                                            paramae.cvs |= 0x20000000;
                                            AppMethodBeat.o(208002);
                                            return;
                                            paramae.cvZ = bV(paramString2);
                                            paramae.cvs |= 0x40000000;
                                            AppMethodBeat.o(208002);
                                            return;
                                            if (paramString2.equals("currentColor")) {
                                              paramae.cwa = h.g.NY();
                                            }
                                            for (;;)
                                            {
                                              paramae.cvs |= 0x80000000;
                                              AppMethodBeat.o(208002);
                                              return;
                                              try
                                              {
                                                paramae.cwa = bB(paramString2);
                                              }
                                              catch (k paramae)
                                              {
                                                paramae.getMessage();
                                                AppMethodBeat.o(208002);
                                                return;
                                              }
                                            }
                                            paramae.cwb = bw(paramString2);
                                            paramae.cvs |= 0x0;
                                            AppMethodBeat.o(208002);
                                            return;
                                            if (paramString2.equals("currentColor")) {
                                              paramae.cwc = h.g.NY();
                                            }
                                            for (;;)
                                            {
                                              paramae.cvs |= 0x0;
                                              AppMethodBeat.o(208002);
                                              return;
                                              try
                                              {
                                                paramae.cwc = bB(paramString2);
                                              }
                                              catch (k paramae)
                                              {
                                                paramae.getMessage();
                                                AppMethodBeat.o(208002);
                                                return;
                                              }
                                            }
                                            paramae.cwd = bw(paramString2);
                                            paramae.cvs |= 0x0;
                                            AppMethodBeat.o(208002);
                                            return;
                                            paramae.cwe = bP(paramString2);
                                            if (paramae.cwe != null)
                                            {
                                              paramae.cvs |= 0x0;
                                              AppMethodBeat.o(208002);
                                              return;
                                              paramae.cwf = bQ(paramString2);
                                              if (paramae.cwf != null) {
                                                paramae.cvs |= 0x0;
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
    AppMethodBeat.i(207833);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramaf.cuP = bt(str);
        continue;
        paramaf.cuQ = bt(str);
        continue;
        paramaf.cuR = bt(str);
        if (paramaf.cuR.isNegative())
        {
          paramaf = new k("Invalid <svg> element. width cannot be negative");
          AppMethodBeat.o(207833);
          throw paramaf;
          paramaf.cuS = bt(str);
          if (paramaf.cuS.isNegative())
          {
            paramaf = new k("Invalid <svg> element. height cannot be negative");
            AppMethodBeat.o(207833);
            throw paramaf;
            paramaf.version = str;
          }
        }
      }
    }
    AppMethodBeat.o(207833);
  }
  
  private static void a(h.ag paramag, Attributes paramAttributes)
  {
    AppMethodBeat.i(207958);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      Object localObject = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
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
          paramag.i(bS((String)localObject));
          continue;
          paramag.bo((String)localObject);
          continue;
          paramag.j(bT((String)localObject));
          continue;
          paramag.k(bU((String)localObject));
        }
      }
      localObject = bD((String)localObject);
      if (localObject != null) {}
      for (localObject = new HashSet((Collection)localObject);; localObject = new HashSet(0))
      {
        paramag.l((Set)localObject);
        break;
      }
    }
    AppMethodBeat.o(207958);
  }
  
  private static void a(h.al paramal, String paramString)
  {
    AppMethodBeat.i(207998);
    paramString = new b.c(paramString.replaceAll("/\\*.*?\\*/", ""));
    while (!paramString.empty())
    {
      paramString.Oz();
      String str1 = paramString.NE();
      paramString.Oz();
      if (!paramString.c(';'))
      {
        if (!paramString.c(':')) {
          break;
        }
        paramString.Oz();
        String str2 = paramString.NH();
        if (str2 != null)
        {
          paramString.Oz();
          if ((paramString.empty()) || (paramString.c(';')))
          {
            if (paramal.ctr == null) {
              paramal.ctr = new h.ae();
            }
            a(paramal.ctr, str1, str2);
            paramString.Oz();
          }
        }
      }
    }
    AppMethodBeat.o(207998);
  }
  
  private static void a(h.al paramal, Attributes paramAttributes)
  {
    AppMethodBeat.i(207995);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getQName(i);
      if ((str.equals("id")) || (str.equals("xml:id")))
      {
        paramal.id = paramAttributes.getValue(i).trim();
        AppMethodBeat.o(207995);
        return;
      }
      if (str.equals("xml:space"))
      {
        paramAttributes = paramAttributes.getValue(i).trim();
        if ("default".equals(paramAttributes))
        {
          paramal.cwV = Boolean.FALSE;
          AppMethodBeat.o(207995);
          return;
        }
        if ("preserve".equals(paramAttributes))
        {
          paramal.cwV = Boolean.TRUE;
          AppMethodBeat.o(207995);
          return;
        }
        paramal = new k("Invalid value for \"xml:space\" attribute: ".concat(String.valueOf(paramAttributes)));
        AppMethodBeat.o(207995);
        throw paramal;
      }
      i += 1;
    }
    AppMethodBeat.o(207995);
  }
  
  private static void a(h.am paramam, Attributes paramAttributes)
  {
    AppMethodBeat.i(207968);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramam.cuU = bt(str);
        continue;
        paramam.cuV = bt(str);
        continue;
        paramam.cuW = bt(str);
        continue;
        paramam.cuX = bt(str);
      }
    }
    AppMethodBeat.o(207968);
  }
  
  private static void a(h.ap paramap, String paramString)
  {
    AppMethodBeat.i(208020);
    paramap.cuh = by(paramString);
    AppMethodBeat.o(208020);
  }
  
  private static void a(h.aq paramaq, Attributes paramAttributes)
  {
    AppMethodBeat.i(207970);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramaq.cuy = bt(str);
        continue;
        paramaq.cuz = bt(str);
        continue;
        paramaq.cuA = bt(str);
        if (paramaq.cuA.isNegative())
        {
          paramaq = new k("Invalid <radialGradient> element. r cannot be negative");
          AppMethodBeat.o(207970);
          throw paramaq;
          paramaq.cxa = bt(str);
          continue;
          paramaq.cxb = bt(str);
        }
      }
    }
    AppMethodBeat.o(207970);
  }
  
  private static void a(h.ar paramar, Attributes paramAttributes)
  {
    AppMethodBeat.i(208003);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramar.cuj = bx(str);
        continue;
        a(paramar, str);
      }
    }
    AppMethodBeat.o(208003);
  }
  
  private static void a(h.au paramau, Attributes paramAttributes)
  {
    AppMethodBeat.i(207954);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
          paramau.cut = str;
        }
      }
    }
    AppMethodBeat.o(207954);
  }
  
  private static void a(h.az paramaz, Attributes paramAttributes)
  {
    AppMethodBeat.i(207984);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i))))
        {
          paramaz.cut = str;
          continue;
          paramaz.cxd = bt(str);
        }
      }
    }
    AppMethodBeat.o(207984);
  }
  
  private static void a(h.ba paramba, Attributes paramAttributes)
  {
    AppMethodBeat.i(207949);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramba.x = bu(str);
        continue;
        paramba.cxe = bu(str);
        continue;
        paramba.cxf = bu(str);
        continue;
        paramba.cxg = bu(str);
      }
    }
    AppMethodBeat.o(207949);
  }
  
  private static void a(h.be parambe, Attributes paramAttributes)
  {
    AppMethodBeat.i(207887);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        parambe.cuP = bt(str);
        continue;
        parambe.cuQ = bt(str);
        continue;
        parambe.cuR = bt(str);
        if (parambe.cuR.isNegative())
        {
          parambe = new k("Invalid <use> element. width cannot be negative");
          AppMethodBeat.o(207887);
          throw parambe;
          parambe.cuS = bt(str);
          if (parambe.cuS.isNegative())
          {
            parambe = new k("Invalid <use> element. height cannot be negative");
            AppMethodBeat.o(207887);
            throw parambe;
            if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
              parambe.cut = str;
            }
          }
        }
      }
    }
    AppMethodBeat.o(207887);
  }
  
  private static void a(h.d paramd, Attributes paramAttributes)
  {
    AppMethodBeat.i(207928);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramd.cuy = bt(str);
          continue;
          paramd.cuz = bt(str);
        }
        paramd.cuA = bt(str);
      } while (!paramd.cuA.isNegative());
      paramd = new k("Invalid <circle> element. r cannot be negative");
      AppMethodBeat.o(207928);
      throw paramd;
    }
    AppMethodBeat.o(207928);
  }
  
  private static void a(h.e parame, Attributes paramAttributes)
  {
    AppMethodBeat.i(207980);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          parame.cuB = Boolean.FALSE;
        }
        else
        {
          if (!"userSpaceOnUse".equals(str)) {
            break label111;
          }
          parame.cuB = Boolean.TRUE;
        }
      }
      label111:
      parame = new k("Invalid value for attribute clipPathUnits");
      AppMethodBeat.o(207980);
      throw parame;
    }
    AppMethodBeat.o(207980);
  }
  
  private static void a(h.i parami, Attributes paramAttributes)
  {
    AppMethodBeat.i(207933);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
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
            parami.cuy = bt(str);
            continue;
            parami.cuz = bt(str);
          }
          parami.cuG = bt(str);
        } while (!parami.cuG.isNegative());
        parami = new k("Invalid <ellipse> element. rx cannot be negative");
        AppMethodBeat.o(207933);
        throw parami;
        parami.cuH = bt(str);
      } while (!parami.cuH.isNegative());
      parami = new k("Invalid <ellipse> element. ry cannot be negative");
      AppMethodBeat.o(207933);
      throw parami;
    }
    AppMethodBeat.o(207933);
  }
  
  private static void a(h.j paramj, Attributes paramAttributes)
  {
    AppMethodBeat.i(207967);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          paramj.cuI = Boolean.FALSE;
        }
        else if ("userSpaceOnUse".equals(str))
        {
          paramj.cuI = Boolean.TRUE;
        }
        else
        {
          paramj = new k("Invalid value for attribute gradientUnits");
          AppMethodBeat.o(207967);
          throw paramj;
          paramj.cuJ = bs(str);
          continue;
          try
          {
            paramj.cuK = h.k.valueOf(str);
          }
          catch (IllegalArgumentException paramj)
          {
            paramj = new k("Invalid spreadMethod attribute. \"" + str + "\" is not a valid value.");
            AppMethodBeat.o(207967);
            throw paramj;
          }
          if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
            paramj.cut = str;
          }
        }
      }
    }
    AppMethodBeat.o(207967);
  }
  
  private static void a(h.n paramn, Attributes paramAttributes)
  {
    AppMethodBeat.i(208005);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      if (f.ca(paramAttributes.getLocalName(i)) == f.czJ) {
        paramn.setTransform(bs(paramAttributes.getValue(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(208005);
  }
  
  private static void a(h.o paramo, Attributes paramAttributes)
  {
    AppMethodBeat.i(207901);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramo.cuP = bt(str);
        continue;
        paramo.cuQ = bt(str);
        continue;
        paramo.cuR = bt(str);
        if (paramo.cuR.isNegative())
        {
          paramo = new k("Invalid <use> element. width cannot be negative");
          AppMethodBeat.o(207901);
          throw paramo;
          paramo.cuS = bt(str);
          if (paramo.cuS.isNegative())
          {
            paramo = new k("Invalid <use> element. height cannot be negative");
            AppMethodBeat.o(207901);
            throw paramo;
            if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i))))
            {
              paramo.cut = str;
              continue;
              a(paramo, str);
            }
          }
        }
      }
    }
    AppMethodBeat.o(207901);
  }
  
  private static void a(h.q paramq, Attributes paramAttributes)
  {
    AppMethodBeat.i(207938);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramq.cuU = bt(str);
        continue;
        paramq.cuV = bt(str);
        continue;
        paramq.cuW = bt(str);
        continue;
        paramq.cuX = bt(str);
      }
    }
    AppMethodBeat.o(207938);
  }
  
  private static void a(h.r paramr, Attributes paramAttributes)
  {
    AppMethodBeat.i(207964);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramr.cuZ = bt(str);
        continue;
        paramr.cva = bt(str);
        continue;
        paramr.cvb = bt(str);
        if (paramr.cvb.isNegative())
        {
          paramr = new k("Invalid <marker> element. markerWidth cannot be negative");
          AppMethodBeat.o(207964);
          throw paramr;
          paramr.cvc = bt(str);
          if (paramr.cvc.isNegative())
          {
            paramr = new k("Invalid <marker> element. markerHeight cannot be negative");
            AppMethodBeat.o(207964);
            throw paramr;
            if ("strokeWidth".equals(str))
            {
              paramr.cuY = false;
            }
            else if ("userSpaceOnUse".equals(str))
            {
              paramr.cuY = true;
            }
            else
            {
              paramr = new k("Invalid value for attribute markerUnits");
              AppMethodBeat.o(207964);
              throw paramr;
              if ("auto".equals(str)) {
                paramr.cvd = Float.valueOf((0.0F / 0.0F));
              } else {
                paramr.cvd = Float.valueOf(bv(str));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(207964);
  }
  
  private static void a(h.s params, Attributes paramAttributes)
  {
    AppMethodBeat.i(207993);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
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
              params.cve = Boolean.FALSE;
            }
            else if ("userSpaceOnUse".equals(str))
            {
              params.cve = Boolean.TRUE;
            }
            else
            {
              params = new k("Invalid value for attribute maskUnits");
              AppMethodBeat.o(207993);
              throw params;
              if ("objectBoundingBox".equals(str))
              {
                params.cvf = Boolean.FALSE;
              }
              else if ("userSpaceOnUse".equals(str))
              {
                params.cvf = Boolean.TRUE;
              }
              else
              {
                params = new k("Invalid value for attribute maskContentUnits");
                AppMethodBeat.o(207993);
                throw params;
                params.cuP = bt(str);
                continue;
                params.cuQ = bt(str);
              }
            }
          }
          params.cuR = bt(str);
        } while (!params.cuR.isNegative());
        params = new k("Invalid <mask> element. width cannot be negative");
        AppMethodBeat.o(207993);
        throw params;
        params.cuS = bt(str);
      } while (!params.cuS.isNegative());
      params = new k("Invalid <mask> element. height cannot be negative");
      AppMethodBeat.o(207993);
      throw params;
    }
    AppMethodBeat.o(207993);
  }
  
  private static void a(h.v paramv, Attributes paramAttributes)
  {
    AppMethodBeat.i(207912);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramv.cvh = bR(str);
        }
        paramv.cvi = Float.valueOf(bv(str));
      } while (paramv.cvi.floatValue() >= 0.0F);
      paramv = new k("Invalid <path> element. pathLength cannot be negative");
      AppMethodBeat.o(207912);
      throw paramv;
    }
    AppMethodBeat.o(207912);
  }
  
  private static void a(h.y paramy, Attributes paramAttributes)
  {
    AppMethodBeat.i(207987);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if ("objectBoundingBox".equals(str))
        {
          paramy.cvn = Boolean.FALSE;
        }
        else if ("userSpaceOnUse".equals(str))
        {
          paramy.cvn = Boolean.TRUE;
        }
        else
        {
          paramy = new k("Invalid value for attribute patternUnits");
          AppMethodBeat.o(207987);
          throw paramy;
          if ("objectBoundingBox".equals(str))
          {
            paramy.cvo = Boolean.FALSE;
          }
          else if ("userSpaceOnUse".equals(str))
          {
            paramy.cvo = Boolean.TRUE;
          }
          else
          {
            paramy = new k("Invalid value for attribute patternContentUnits");
            AppMethodBeat.o(207987);
            throw paramy;
            paramy.cvp = bs(str);
            continue;
            paramy.cuP = bt(str);
            continue;
            paramy.cuQ = bt(str);
            continue;
            paramy.cuR = bt(str);
            if (paramy.cuR.isNegative())
            {
              paramy = new k("Invalid <pattern> element. width cannot be negative");
              AppMethodBeat.o(207987);
              throw paramy;
              paramy.cuS = bt(str);
              if (paramy.cuS.isNegative())
              {
                paramy = new k("Invalid <pattern> element. height cannot be negative");
                AppMethodBeat.o(207987);
                throw paramy;
                if (("".equals(paramAttributes.getURI(i))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(i)))) {
                  paramy.cut = str;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(207987);
  }
  
  private static void a(h.z paramz, Attributes paramAttributes, String paramString)
  {
    AppMethodBeat.i(207944);
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      if (f.ca(paramAttributes.getLocalName(i)) == f.czg)
      {
        Object localObject = new h(paramAttributes.getValue(i));
        ArrayList localArrayList = new ArrayList();
        ((h)localObject).Oz();
        float f1;
        while (!((h)localObject).empty())
        {
          f1 = ((h)localObject).OB();
          if (Float.isNaN(f1))
          {
            paramz = new k("Invalid <" + paramString + "> points attribute. Non-coordinate content found in list.");
            AppMethodBeat.o(207944);
            throw paramz;
          }
          ((h)localObject).OA();
          float f2 = ((h)localObject).OB();
          if (Float.isNaN(f2))
          {
            paramz = new k("Invalid <" + paramString + "> points attribute. There should be an even number of coordinates.");
            AppMethodBeat.o(207944);
            throw paramz;
          }
          ((h)localObject).OA();
          localArrayList.add(Float.valueOf(f1));
          localArrayList.add(Float.valueOf(f2));
        }
        paramz.cvq = new float[localArrayList.size()];
        localObject = localArrayList.iterator();
        int j = 0;
        while (((Iterator)localObject).hasNext())
        {
          f1 = ((Float)((Iterator)localObject).next()).floatValue();
          paramz.cvq[j] = f1;
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(207944);
  }
  
  private void a(Attributes paramAttributes)
  {
    AppMethodBeat.i(207825);
    h.af localaf = new h.af();
    localaf.cwY = this.cxV;
    localaf.cwZ = this.cxW;
    a(localaf, paramAttributes);
    b(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    if (this.cxW == null) {
      this.cxV.cun = localaf;
    }
    for (;;)
    {
      this.cxW = localaf;
      AppMethodBeat.o(207825);
      return;
      this.cxW.a(localaf);
    }
  }
  
  private static int aM(float paramFloat)
  {
    AppMethodBeat.i(208030);
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(208030);
      return 0;
    }
    if (paramFloat > 255.0F)
    {
      AppMethodBeat.o(208030);
      return 255;
    }
    int i = Math.round(paramFloat);
    AppMethodBeat.o(208030);
    return i;
  }
  
  private static h.p b(h paramh)
  {
    AppMethodBeat.i(208144);
    if (paramh.cc("auto"))
    {
      paramh = new h.p(0.0F);
      AppMethodBeat.o(208144);
      return paramh;
    }
    paramh = paramh.OE();
    AppMethodBeat.o(208144);
    return paramh;
  }
  
  private static void b(h.al paramal, Attributes paramAttributes)
  {
    AppMethodBeat.i(207997);
    int i = 0;
    if (i < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(i).trim();
      if (str.length() != 0) {
        switch (1.cyf[f.ca(paramAttributes.getLocalName(i)).ordinal()])
        {
        default: 
          if (paramal.cwW == null) {
            paramal.cwW = new h.ae();
          }
          a(paramal.cwW, paramAttributes.getLocalName(i), paramAttributes.getValue(i).trim());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramal, str);
        continue;
        paramal.cwX = b.bk(str);
      }
    }
    AppMethodBeat.o(207997);
  }
  
  static void b(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(207811);
    if ((paramString.equals("xml-stylesheet")) && (h.NU() != null))
    {
      if (((String)paramMap.get("type") != null) && (!"text/css".equals(paramMap.get("type"))))
      {
        AppMethodBeat.o(207811);
        return;
      }
      if (((String)paramMap.get("alternate") != null) && (!"no".equals(paramMap.get("alternate"))))
      {
        AppMethodBeat.o(207811);
        return;
      }
      if ((String)paramMap.get("href") != null)
      {
        h.NU();
        AppMethodBeat.o(207811);
        return;
      }
    }
    AppMethodBeat.o(207811);
  }
  
  private void b(Attributes paramAttributes)
  {
    AppMethodBeat.i(207845);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207845);
      throw paramAttributes;
    }
    h.m localm = new h.m();
    localm.cwY = this.cxV;
    localm.cwZ = this.cxW;
    a(localm, paramAttributes);
    b(localm, paramAttributes);
    a(localm, paramAttributes);
    a(localm, paramAttributes);
    this.cxW.a(localm);
    this.cxW = localm;
    AppMethodBeat.o(207845);
  }
  
  private static h.ao bA(String paramString)
  {
    AppMethodBeat.i(208025);
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
        paramString = bB(paramString);
        AppMethodBeat.o(208025);
        return paramString;
      }
      catch (k paramString)
      {
        AppMethodBeat.o(208025);
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
    paramString = h.f.cuE;
    AppMethodBeat.o(208025);
    return paramString;
    paramString = h.g.NY();
    AppMethodBeat.o(208025);
    return paramString;
    return null;
  }
  
  private static h.f bB(String paramString)
  {
    AppMethodBeat.i(208028);
    int i;
    if (paramString.charAt(0) == '#')
    {
      localObject = d.q(paramString, paramString.length());
      if (localObject == null)
      {
        paramString = new k("Bad hex colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(208028);
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
        AppMethodBeat.o(208028);
        throw paramString;
      case 4: 
        k = (int)((d)localObject).value;
        i = k & 0xF00;
        j = k & 0xF0;
        k &= 0xF;
        paramString = new h.f(i << 8 | i << 12 | 0xFF000000 | j << 8 | j << 4 | k << 4 | k);
        AppMethodBeat.o(208028);
        return paramString;
      case 5: 
        int m = (int)((d)localObject).value;
        i = 0xF000 & m;
        j = m & 0xF00;
        k = m & 0xF0;
        m &= 0xF;
        paramString = new h.f(i << 4 | m << 24 | m << 28 | i << 8 | j << 4 | j | k | k >> 4);
        AppMethodBeat.o(208028);
        return paramString;
      case 7: 
        paramString = new h.f((int)((d)localObject).value | 0xFF000000);
        AppMethodBeat.o(208028);
        return paramString;
      }
      i = (int)((d)localObject).value;
      paramString = new h.f((int)((d)localObject).value >>> 8 | i << 24);
      AppMethodBeat.o(208028);
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
        ((h)localObject).Oz();
        f2 = ((h)localObject).OB();
        f1 = f2;
        if (!Float.isNaN(f2))
        {
          f1 = f2;
          if (((h)localObject).c('%')) {
            f1 = f2 * 256.0F / 100.0F;
          }
        }
        f3 = ((h)localObject).aN(f1);
        f2 = f3;
        if (!Float.isNaN(f3))
        {
          f2 = f3;
          if (((h)localObject).c('%')) {
            f2 = f3 * 256.0F / 100.0F;
          }
        }
        f3 = ((h)localObject).aN(f2);
        if ((Float.isNaN(f3)) || (!((h)localObject).c('%'))) {
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
        f4 = ((h)localObject).aN(f3);
        ((h)localObject).Oz();
        if ((Float.isNaN(f4)) || (!((h)localObject).c(')')))
        {
          paramString = new k("Bad rgba() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(208028);
          throw paramString;
          i = 4;
          break;
        }
        i = aM(f4 * 256.0F);
        paramString = new h.f(aM(f1) << 16 | i << 24 | aM(f2) << 8 | aM(f3));
        AppMethodBeat.o(208028);
        return paramString;
      }
      ((h)localObject).Oz();
      if ((Float.isNaN(f3)) || (!((h)localObject).c(')')))
      {
        paramString = new k("Bad rgb() colour value: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(208028);
        throw paramString;
      }
      paramString = new h.f(aM(f1) << 16 | 0xFF000000 | aM(f2) << 8 | aM(f3));
      AppMethodBeat.o(208028);
      return paramString;
      bool = ((String)localObject).startsWith("hsla(");
      if ((bool) || (((String)localObject).startsWith("hsl(")))
      {
        if (bool) {}
        for (i = 5;; i = 4)
        {
          localObject = new h(paramString.substring(i));
          ((h)localObject).Oz();
          f1 = ((h)localObject).OB();
          f2 = ((h)localObject).aN(f1);
          if (!Float.isNaN(f2)) {
            ((h)localObject).c('%');
          }
          f3 = ((h)localObject).aN(f2);
          if (!Float.isNaN(f3)) {
            ((h)localObject).c('%');
          }
          if (!bool) {
            break label953;
          }
          f4 = ((h)localObject).aN(f3);
          ((h)localObject).Oz();
          if ((!Float.isNaN(f4)) && (((h)localObject).c(')'))) {
            break;
          }
          paramString = new k("Bad hsla() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(208028);
          throw paramString;
        }
        paramString = new h.f(aM(f4 * 256.0F) << 24 | j(f1, f2, f3));
        AppMethodBeat.o(208028);
        return paramString;
        label953:
        ((h)localObject).Oz();
        if ((Float.isNaN(f3)) || (!((h)localObject).c(')')))
        {
          paramString = new k("Bad hsl() colour value: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(208028);
          throw paramString;
        }
        paramString = new h.f(j(f1, f2, f3) | 0xFF000000);
        AppMethodBeat.o(208028);
        return paramString;
      }
      paramString = bC((String)localObject);
      AppMethodBeat.o(208028);
      return paramString;
    }
  }
  
  private static h.f bC(String paramString)
  {
    AppMethodBeat.i(208040);
    Integer localInteger = b.bY(paramString);
    if (localInteger == null)
    {
      paramString = new k("Invalid colour keyword: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(208040);
      throw paramString;
    }
    paramString = new h.f(localInteger.intValue());
    AppMethodBeat.o(208040);
    return paramString;
  }
  
  private static List<String> bD(String paramString)
  {
    AppMethodBeat.i(208050);
    Object localObject1 = null;
    h localh = new h(paramString);
    paramString = (String)localObject1;
    do
    {
      localObject1 = localh.ON();
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localh.b(',', true);
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
      localh.OA();
      paramString = (String)localObject1;
    } while (!localh.empty());
    AppMethodBeat.o(208050);
    return localObject1;
  }
  
  private static h.p bE(String paramString)
  {
    AppMethodBeat.i(208055);
    try
    {
      h.p localp2 = c.bZ(paramString);
      h.p localp1 = localp2;
      if (localp2 == null) {
        localp1 = bt(paramString);
      }
      AppMethodBeat.o(208055);
      return localp1;
    }
    catch (k paramString)
    {
      AppMethodBeat.o(208055);
    }
    return null;
  }
  
  private static h.ae.b bF(String paramString)
  {
    AppMethodBeat.i(208061);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(208061);
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
    paramString = h.ae.b.cwk;
    AppMethodBeat.o(208061);
    return paramString;
    paramString = h.ae.b.cwj;
    AppMethodBeat.o(208061);
    return paramString;
    paramString = h.ae.b.cwl;
    AppMethodBeat.o(208061);
    return paramString;
  }
  
  private static h.ae.g bG(String paramString)
  {
    AppMethodBeat.i(208065);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(208065);
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
    paramString = h.ae.g.cwD;
    AppMethodBeat.o(208065);
    return paramString;
    paramString = h.ae.g.cwE;
    AppMethodBeat.o(208065);
    return paramString;
    paramString = h.ae.g.cwF;
    AppMethodBeat.o(208065);
    return paramString;
    paramString = h.ae.g.cwG;
    AppMethodBeat.o(208065);
    return paramString;
    paramString = h.ae.g.cwH;
    AppMethodBeat.o(208065);
    return paramString;
  }
  
  private static h.ae.h bH(String paramString)
  {
    AppMethodBeat.i(208069);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(208069);
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
    paramString = h.ae.h.cwJ;
    AppMethodBeat.o(208069);
    return paramString;
    paramString = h.ae.h.cwK;
    AppMethodBeat.o(208069);
    return paramString;
  }
  
  private static h.ae.a bI(String paramString)
  {
    AppMethodBeat.i(208081);
    if ("nonzero".equals(paramString))
    {
      paramString = h.ae.a.cwg;
      AppMethodBeat.o(208081);
      return paramString;
    }
    if ("evenodd".equals(paramString))
    {
      paramString = h.ae.a.cwh;
      AppMethodBeat.o(208081);
      return paramString;
    }
    AppMethodBeat.o(208081);
    return null;
  }
  
  private static h.ae.c bJ(String paramString)
  {
    AppMethodBeat.i(208089);
    if ("butt".equals(paramString))
    {
      paramString = h.ae.c.cwn;
      AppMethodBeat.o(208089);
      return paramString;
    }
    if ("round".equals(paramString))
    {
      paramString = h.ae.c.cwo;
      AppMethodBeat.o(208089);
      return paramString;
    }
    if ("square".equals(paramString))
    {
      paramString = h.ae.c.cwp;
      AppMethodBeat.o(208089);
      return paramString;
    }
    AppMethodBeat.o(208089);
    return null;
  }
  
  private static h.ae.d bK(String paramString)
  {
    AppMethodBeat.i(208096);
    if ("miter".equals(paramString))
    {
      paramString = h.ae.d.cwr;
      AppMethodBeat.o(208096);
      return paramString;
    }
    if ("round".equals(paramString))
    {
      paramString = h.ae.d.cws;
      AppMethodBeat.o(208096);
      return paramString;
    }
    if ("bevel".equals(paramString))
    {
      paramString = h.ae.d.cwt;
      AppMethodBeat.o(208096);
      return paramString;
    }
    AppMethodBeat.o(208096);
    return null;
  }
  
  private static h.p[] bL(String paramString)
  {
    AppMethodBeat.i(208105);
    paramString = new h(paramString);
    paramString.Oz();
    if (paramString.empty())
    {
      AppMethodBeat.o(208105);
      return null;
    }
    h.p localp = paramString.OE();
    if (localp == null)
    {
      AppMethodBeat.o(208105);
      return null;
    }
    if (localp.isNegative())
    {
      AppMethodBeat.o(208105);
      return null;
    }
    float f = localp.value;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localp);
    while (!paramString.empty())
    {
      paramString.OA();
      localp = paramString.OE();
      if (localp == null)
      {
        AppMethodBeat.o(208105);
        return null;
      }
      if (localp.isNegative())
      {
        AppMethodBeat.o(208105);
        return null;
      }
      localArrayList.add(localp);
      f += localp.value;
    }
    if (f == 0.0F)
    {
      AppMethodBeat.o(208105);
      return null;
    }
    paramString = (h.p[])localArrayList.toArray(new h.p[localArrayList.size()]);
    AppMethodBeat.o(208105);
    return paramString;
  }
  
  private static h.ae.f bM(String paramString)
  {
    AppMethodBeat.i(208118);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(208118);
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
    paramString = h.ae.f.cwz;
    AppMethodBeat.o(208118);
    return paramString;
    paramString = h.ae.f.cwA;
    AppMethodBeat.o(208118);
    return paramString;
    paramString = h.ae.f.cwB;
    AppMethodBeat.o(208118);
    return paramString;
  }
  
  private static Boolean bN(String paramString)
  {
    AppMethodBeat.i(208127);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(208127);
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
    AppMethodBeat.o(208127);
    return paramString;
    paramString = Boolean.FALSE;
    AppMethodBeat.o(208127);
    return paramString;
  }
  
  private static h.c bO(String paramString)
  {
    AppMethodBeat.i(208136);
    if ("auto".equals(paramString))
    {
      AppMethodBeat.o(208136);
      return null;
    }
    if (!paramString.startsWith("rect("))
    {
      AppMethodBeat.o(208136);
      return null;
    }
    paramString = new h(paramString.substring(5));
    paramString.Oz();
    h.p localp1 = b(paramString);
    paramString.OA();
    h.p localp2 = b(paramString);
    paramString.OA();
    h.p localp3 = b(paramString);
    paramString.OA();
    h.p localp4 = b(paramString);
    paramString.Oz();
    if ((!paramString.c(')')) && (!paramString.empty()))
    {
      AppMethodBeat.o(208136);
      return null;
    }
    paramString = new h.c(localp1, localp2, localp3, localp4);
    AppMethodBeat.o(208136);
    return paramString;
  }
  
  private static h.ae.i bP(String paramString)
  {
    AppMethodBeat.i(208153);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(208153);
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
    paramString = h.ae.i.cwM;
    AppMethodBeat.o(208153);
    return paramString;
    paramString = h.ae.i.cwN;
    AppMethodBeat.o(208153);
    return paramString;
  }
  
  private static h.ae.e bQ(String paramString)
  {
    AppMethodBeat.i(208164);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(208164);
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
    paramString = h.ae.e.cwv;
    AppMethodBeat.o(208164);
    return paramString;
    paramString = h.ae.e.cww;
    AppMethodBeat.o(208164);
    return paramString;
    paramString = h.ae.e.cwx;
    AppMethodBeat.o(208164);
    return paramString;
  }
  
  private static h.w bR(String paramString)
  {
    AppMethodBeat.i(208177);
    paramString = new h(paramString);
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f10 = 0.0F;
    float f9 = 0.0F;
    h.w localw = new h.w();
    if (paramString.empty())
    {
      AppMethodBeat.o(208177);
      return localw;
    }
    int i = paramString.OD().intValue();
    float f2;
    float f1;
    label107:
    float f5;
    float f6;
    float f7;
    if ((i != 77) && (i != 109))
    {
      AppMethodBeat.o(208177);
      return localw;
      if ((i == 109) && (!localw.isEmpty()))
      {
        Object localObject2;
        localObject2 += f4;
        Object localObject1;
        localObject1 += f3;
        localw.B(f1, f2);
        if (i == 109)
        {
          i = 108;
          f5 = f2;
          f6 = f1;
          f7 = f2;
          f3 = f1;
          f4 = f2;
          f2 = f7;
          paramString.OA();
          if (paramString.empty()) {
            break label1460;
          }
          if (!paramString.OM()) {
            break label1469;
          }
          i = paramString.OD().intValue();
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
      paramString.Oz();
      switch (i)
      {
      default: 
        AppMethodBeat.o(208177);
        return localw;
      case 77: 
      case 109: 
        f1 = paramString.OB();
        f2 = paramString.aN(f1);
        if (!Float.isNaN(f2)) {
          break;
        }
        new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
        AppMethodBeat.o(208177);
        return localw;
        i = 76;
        break;
      case 76: 
      case 108: 
        f5 = paramString.OB();
        f6 = paramString.aN(f5);
        if (Float.isNaN(f6))
        {
          new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
          AppMethodBeat.o(208177);
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
          localw.D(f3, f4);
          f5 = f4;
          f6 = f3;
          f7 = f1;
          f1 = f3;
          f3 = f7;
          break;
          f7 = paramString.OB();
          float f8 = paramString.aN(f7);
          f6 = paramString.aN(f8);
          f5 = paramString.aN(f6);
          f9 = paramString.aN(f5);
          f10 = paramString.aN(f9);
          if (Float.isNaN(f10))
          {
            new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
            AppMethodBeat.o(208177);
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
            localw.b(f7, f8, f6, f5, f3, f4);
            f7 = f1;
            f1 = f3;
            f3 = f7;
            break;
            f6 = paramString.OB();
            f8 = paramString.aN(f6);
            f7 = paramString.aN(f8);
            f5 = paramString.aN(f7);
            if (Float.isNaN(f5))
            {
              new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
              AppMethodBeat.o(208177);
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
              localw.b(2.0F * f3 - f10, 2.0F * f4 - f9, f6, f8, f7, f5);
              f3 = f1;
              f4 = f5;
              f5 = f8;
              f1 = f7;
              break;
              localw.b((byte)8);
              f5 = f2;
              f6 = f1;
              f7 = f2;
              f3 = f1;
              f4 = f2;
              f2 = f7;
              break;
              f5 = paramString.OB();
              if (Float.isNaN(f5))
              {
                new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                AppMethodBeat.o(208177);
                return localw;
              }
              if (i == 104) {}
              for (f3 = f5 + f3;; f3 = f5)
              {
                localw.D(f3, f4);
                f6 = f3;
                f7 = f1;
                f1 = f3;
                f5 = f9;
                f3 = f7;
                break;
                f5 = paramString.OB();
                if (Float.isNaN(f5))
                {
                  new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                  AppMethodBeat.o(208177);
                  return localw;
                }
                if (i == 118) {}
                for (f4 = f5 + f4;; f4 = f5)
                {
                  localw.D(f3, f4);
                  f5 = f4;
                  f7 = f1;
                  f1 = f3;
                  f6 = f10;
                  f3 = f7;
                  break;
                  f5 = paramString.OB();
                  f6 = paramString.aN(f5);
                  f8 = paramString.aN(f6);
                  f7 = paramString.aN(f8);
                  if (Float.isNaN(f7))
                  {
                    new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                    AppMethodBeat.o(208177);
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
                    localw.i(f5, f6, f3, f4);
                    f8 = f5;
                    f7 = f1;
                    f5 = f6;
                    f6 = f8;
                    f1 = f3;
                    f3 = f7;
                    break;
                    f6 = 2.0F * f3 - f10;
                    f5 = 2.0F * f4 - f9;
                    f7 = paramString.OB();
                    f8 = paramString.aN(f7);
                    if (Float.isNaN(f8))
                    {
                      new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                      AppMethodBeat.o(208177);
                      return localw;
                    }
                    if (i == 116) {
                      f4 = f8 + f4;
                    }
                    for (f3 = f7 + f3;; f3 = f7)
                    {
                      localw.i(f6, f5, f3, f4);
                      f7 = f1;
                      f1 = f3;
                      f3 = f7;
                      break;
                      f7 = paramString.OB();
                      f8 = paramString.aN(f7);
                      f9 = paramString.aN(f8);
                      Boolean localBoolean1 = paramString.ba(Float.valueOf(f9));
                      Boolean localBoolean2 = paramString.ba(localBoolean1);
                      f5 = paramString.d(localBoolean2);
                      f6 = paramString.aN(f5);
                      if ((Float.isNaN(f6)) || (f7 < 0.0F) || (f8 < 0.0F))
                      {
                        new StringBuilder("Bad path coords for ").append((char)i).append(" path segment");
                        AppMethodBeat.o(208177);
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
                        AppMethodBeat.o(208177);
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
  
  private static Set<String> bS(String paramString)
  {
    AppMethodBeat.i(208181);
    paramString = new h(paramString);
    HashSet localHashSet = new HashSet();
    if (!paramString.empty())
    {
      String str = paramString.OH();
      if (str.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
        localHashSet.add(str.substring(35));
      }
      for (;;)
      {
        paramString.Oz();
        break;
        localHashSet.add("UNSUPPORTED");
      }
    }
    AppMethodBeat.o(208181);
    return localHashSet;
  }
  
  private static Set<String> bT(String paramString)
  {
    AppMethodBeat.i(208184);
    h localh = new h(paramString);
    HashSet localHashSet = new HashSet();
    while (!localh.empty())
    {
      String str = localh.OH();
      int i = str.indexOf('-');
      paramString = str;
      if (i != -1) {
        paramString = str.substring(0, i);
      }
      localHashSet.add(new Locale(paramString, "", "").getLanguage());
      localh.Oz();
    }
    AppMethodBeat.o(208184);
    return localHashSet;
  }
  
  private static Set<String> bU(String paramString)
  {
    AppMethodBeat.i(208187);
    paramString = new h(paramString);
    HashSet localHashSet = new HashSet();
    while (!paramString.empty())
    {
      localHashSet.add(paramString.OH());
      paramString.Oz();
    }
    AppMethodBeat.o(208187);
    return localHashSet;
  }
  
  private static String bV(String paramString)
  {
    AppMethodBeat.i(208191);
    if (paramString.equals("none"))
    {
      AppMethodBeat.o(208191);
      return null;
    }
    if (!paramString.startsWith("url("))
    {
      AppMethodBeat.o(208191);
      return null;
    }
    if (paramString.endsWith(")"))
    {
      paramString = paramString.substring(4, paramString.length() - 1).trim();
      AppMethodBeat.o(208191);
      return paramString;
    }
    paramString = paramString.substring(4).trim();
    AppMethodBeat.o(208191);
    return paramString;
  }
  
  private void bW(String paramString)
  {
    AppMethodBeat.i(208203);
    b localb = new b(b.e.csF, b.t.ctA);
    this.cxV.b(localb.bj(paramString));
    AppMethodBeat.o(208203);
  }
  
  private void bq(String paramString)
  {
    AppMethodBeat.i(207807);
    Object localObject = (h.ah)this.cxW;
    int i = ((h.ah)localObject).aAO.size();
    if (i == 0) {}
    for (localObject = null; (localObject instanceof h.bc); localObject = (h.an)((h.ah)localObject).aAO.get(i - 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = (h.bc)localObject;
      ((h.bc)localObject).text += paramString;
      AppMethodBeat.o(207807);
      return;
    }
    this.cxW.a(new h.bc(paramString));
    AppMethodBeat.o(207807);
  }
  
  private static Float br(String paramString)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(207976);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid offset value in <stop> (empty string)");
      AppMethodBeat.o(207976);
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
        float f3 = r(paramString, j);
        f1 = f3;
        if (i == 0) {
          break label152;
        }
        f1 = f3 / 100.0F;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = new k("Invalid offset value in <stop>: ".concat(String.valueOf(paramString)), localNumberFormatException);
        AppMethodBeat.o(207976);
        throw paramString;
      }
      AppMethodBeat.o(207976);
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
  
  private static Matrix bs(String paramString)
  {
    AppMethodBeat.i(208008);
    Matrix localMatrix = new Matrix();
    h localh = new h(paramString);
    localh.Oz();
    if (!localh.empty())
    {
      Object localObject = localh.OJ();
      if (localObject == null)
      {
        paramString = new k("Bad transform function encountered in transform list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(208008);
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
          AppMethodBeat.o(208008);
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
      localh.Oz();
      float f1 = localh.OB();
      localh.OA();
      float f2 = localh.OB();
      localh.OA();
      float f3 = localh.OB();
      localh.OA();
      float f4 = localh.OB();
      localh.OA();
      float f5 = localh.OB();
      localh.OA();
      float f6 = localh.OB();
      localh.Oz();
      if ((Float.isNaN(f6)) || (!localh.c(')')))
      {
        paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(208008);
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
        localh.OA();
        break;
        localh.Oz();
        f1 = localh.OB();
        f2 = localh.OC();
        localh.Oz();
        if ((Float.isNaN(f1)) || (!localh.c(')')))
        {
          paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(208008);
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
          localh.Oz();
          f1 = localh.OB();
          f2 = localh.OC();
          localh.Oz();
          if ((Float.isNaN(f1)) || (!localh.c(')')))
          {
            paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(208008);
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
            localh.Oz();
            f1 = localh.OB();
            f2 = localh.OC();
            f3 = localh.OC();
            localh.Oz();
            if ((Float.isNaN(f1)) || (!localh.c(')')))
            {
              paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
              AppMethodBeat.o(208008);
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
              AppMethodBeat.o(208008);
              throw paramString;
              localh.Oz();
              f1 = localh.OB();
              localh.Oz();
              if ((Float.isNaN(f1)) || (!localh.c(')')))
              {
                paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
                AppMethodBeat.o(208008);
                throw paramString;
              }
              localMatrix.preSkew((float)Math.tan(Math.toRadians(f1)), 0.0F);
              continue;
              localh.Oz();
              f1 = localh.OB();
              localh.Oz();
              if ((Float.isNaN(f1)) || (!localh.c(')')))
              {
                paramString = new k("Invalid transform list: ".concat(String.valueOf(paramString)));
                AppMethodBeat.o(208008);
                throw paramString;
              }
              localMatrix.preSkew(0.0F, (float)Math.tan(Math.toRadians(f1)));
            }
          }
        }
      }
    }
    label1011:
    AppMethodBeat.o(208008);
    return localMatrix;
  }
  
  private static h.p bt(String paramString)
  {
    AppMethodBeat.i(208010);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid length value (empty string)");
      AppMethodBeat.o(208010);
      throw paramString;
    }
    int j = paramString.length();
    h.bd localbd = h.bd.cxh;
    char c = paramString.charAt(j - 1);
    int i;
    Object localObject;
    if (c == '%')
    {
      i = j - 1;
      localObject = h.bd.cxp;
    }
    for (;;)
    {
      try
      {
        localObject = new h.p(r(paramString, i), (h.bd)localObject);
        AppMethodBeat.o(208010);
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = new k("Invalid length value: ".concat(String.valueOf(paramString)), localNumberFormatException);
        AppMethodBeat.o(208010);
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
        AppMethodBeat.o(208010);
        throw paramString;
      }
    }
  }
  
  private static List<h.p> bu(String paramString)
  {
    AppMethodBeat.i(208011);
    if (paramString.length() == 0)
    {
      paramString = new k("Invalid length list (empty string)");
      AppMethodBeat.o(208011);
      throw paramString;
    }
    ArrayList localArrayList = new ArrayList(1);
    h localh = new h(paramString);
    localh.Oz();
    while (!localh.empty())
    {
      float f = localh.OB();
      if (Float.isNaN(f))
      {
        paramString = new k("Invalid length list value: " + localh.OK());
        AppMethodBeat.o(208011);
        throw paramString;
      }
      h.bd localbd = localh.OL();
      paramString = localbd;
      if (localbd == null) {
        paramString = h.bd.cxh;
      }
      localArrayList.add(new h.p(f, paramString));
      localh.OA();
    }
    AppMethodBeat.o(208011);
    return localArrayList;
  }
  
  private static float bv(String paramString)
  {
    AppMethodBeat.i(208013);
    int i = paramString.length();
    if (i == 0)
    {
      paramString = new k("Invalid float value (empty string)");
      AppMethodBeat.o(208013);
      throw paramString;
    }
    float f = r(paramString, i);
    AppMethodBeat.o(208013);
    return f;
  }
  
  private static Float bw(String paramString)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(208016);
    try
    {
      float f2 = bv(paramString);
      if (f2 < 0.0F) {}
      for (;;)
      {
        AppMethodBeat.o(208016);
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
      AppMethodBeat.o(208016);
    }
  }
  
  private static h.b bx(String paramString)
  {
    AppMethodBeat.i(208019);
    paramString = new h(paramString);
    paramString.Oz();
    float f1 = paramString.OB();
    paramString.OA();
    float f2 = paramString.OB();
    paramString.OA();
    float f3 = paramString.OB();
    paramString.OA();
    float f4 = paramString.OB();
    if ((Float.isNaN(f1)) || (Float.isNaN(f2)) || (Float.isNaN(f3)) || (Float.isNaN(f4)))
    {
      paramString = new k("Invalid viewBox definition - should have four numbers");
      AppMethodBeat.o(208019);
      throw paramString;
    }
    if (f3 < 0.0F)
    {
      paramString = new k("Invalid viewBox. width cannot be negative");
      AppMethodBeat.o(208019);
      throw paramString;
    }
    if (f4 < 0.0F)
    {
      paramString = new k("Invalid viewBox. height cannot be negative");
      AppMethodBeat.o(208019);
      throw paramString;
    }
    paramString = new h.b(f1, f2, f3, f4);
    AppMethodBeat.o(208019);
    return paramString;
  }
  
  private static f by(String paramString)
  {
    AppMethodBeat.i(208022);
    h localh = new h(paramString);
    localh.Oz();
    Object localObject2 = localh.b(' ', false);
    Object localObject1 = localObject2;
    if ("defer".equals(localObject2))
    {
      localh.Oz();
      localObject1 = localh.b(' ', false);
    }
    localObject2 = a.bX((String)localObject1);
    localObject1 = null;
    localh.Oz();
    if (!localh.empty())
    {
      localObject1 = localh.b(' ', false);
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
          AppMethodBeat.o(208022);
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
    for (localObject1 = f.b.cud;; localObject1 = f.b.cue)
    {
      paramString = new f((f.a)localObject2, (f.b)localObject1);
      AppMethodBeat.o(208022);
      return paramString;
    }
  }
  
  private static h.ao bz(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(208023);
    if (paramString.startsWith("url("))
    {
      int i = paramString.indexOf(")");
      if (i != -1)
      {
        String str1 = paramString.substring(4, i).trim();
        String str2 = paramString.substring(i + 1).trim();
        paramString = localObject;
        if (str2.length() > 0) {
          paramString = bA(str2);
        }
        paramString = new h.u(str1, paramString);
        AppMethodBeat.o(208023);
        return paramString;
      }
      paramString = new h.u(paramString.substring(4).trim(), null);
      AppMethodBeat.o(208023);
      return paramString;
    }
    paramString = bA(paramString);
    AppMethodBeat.o(208023);
    return paramString;
  }
  
  private void c(Attributes paramAttributes)
  {
    AppMethodBeat.i(207853);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207853);
      throw paramAttributes;
    }
    h.h localh = new h.h();
    localh.cwY = this.cxV;
    localh.cwZ = this.cxW;
    a(localh, paramAttributes);
    b(localh, paramAttributes);
    a(localh, paramAttributes);
    this.cxW.a(localh);
    this.cxW = localh;
    AppMethodBeat.o(207853);
  }
  
  private void d(Attributes paramAttributes)
  {
    AppMethodBeat.i(207860);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207860);
      throw paramAttributes;
    }
    h.a locala = new h.a();
    locala.cwY = this.cxV;
    locala.cwZ = this.cxW;
    a(locala, paramAttributes);
    b(locala, paramAttributes);
    a(locala, paramAttributes);
    a(locala, paramAttributes);
    a(locala, paramAttributes);
    this.cxW.a(locala);
    this.cxW = locala;
    AppMethodBeat.o(207860);
  }
  
  private void e(Attributes paramAttributes)
  {
    AppMethodBeat.i(207878);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207878);
      throw paramAttributes;
    }
    h.be localbe = new h.be();
    localbe.cwY = this.cxV;
    localbe.cwZ = this.cxW;
    a(localbe, paramAttributes);
    b(localbe, paramAttributes);
    a(localbe, paramAttributes);
    a(localbe, paramAttributes);
    a(localbe, paramAttributes);
    this.cxW.a(localbe);
    this.cxW = localbe;
    AppMethodBeat.o(207878);
  }
  
  private void f(Attributes paramAttributes)
  {
    AppMethodBeat.i(207895);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207895);
      throw paramAttributes;
    }
    h.o localo = new h.o();
    localo.cwY = this.cxV;
    localo.cwZ = this.cxW;
    a(localo, paramAttributes);
    b(localo, paramAttributes);
    a(localo, paramAttributes);
    a(localo, paramAttributes);
    a(localo, paramAttributes);
    this.cxW.a(localo);
    this.cxW = localo;
    AppMethodBeat.o(207895);
  }
  
  private void g(Attributes paramAttributes)
  {
    AppMethodBeat.i(207907);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207907);
      throw paramAttributes;
    }
    h.v localv = new h.v();
    localv.cwY = this.cxV;
    localv.cwZ = this.cxW;
    a(localv, paramAttributes);
    b(localv, paramAttributes);
    a(localv, paramAttributes);
    a(localv, paramAttributes);
    a(localv, paramAttributes);
    this.cxW.a(localv);
    AppMethodBeat.o(207907);
  }
  
  private void h(Attributes paramAttributes)
  {
    AppMethodBeat.i(207917);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207917);
      throw paramAttributes;
    }
    h.ab localab = new h.ab();
    localab.cwY = this.cxV;
    localab.cwZ = this.cxW;
    a(localab, paramAttributes);
    b(localab, paramAttributes);
    a(localab, paramAttributes);
    a(localab, paramAttributes);
    a(localab, paramAttributes);
    this.cxW.a(localab);
    AppMethodBeat.o(207917);
  }
  
  private void i(Attributes paramAttributes)
  {
    AppMethodBeat.i(207926);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207926);
      throw paramAttributes;
    }
    h.d locald = new h.d();
    locald.cwY = this.cxV;
    locald.cwZ = this.cxW;
    a(locald, paramAttributes);
    b(locald, paramAttributes);
    a(locald, paramAttributes);
    a(locald, paramAttributes);
    a(locald, paramAttributes);
    this.cxW.a(locald);
    AppMethodBeat.o(207926);
  }
  
  private static int j(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(208032);
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
      paramFloat2 = k(f2, paramFloat1, f1 + 2.0F);
      paramFloat3 = k(f2, paramFloat1, f1);
      paramFloat1 = k(f2, paramFloat1, f1 - 2.0F);
      int i = aM(paramFloat2 * 256.0F);
      int j = aM(paramFloat3 * 256.0F);
      int k = aM(paramFloat1 * 256.0F);
      AppMethodBeat.o(208032);
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
  
  private void j(Attributes paramAttributes)
  {
    AppMethodBeat.i(207931);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207931);
      throw paramAttributes;
    }
    h.i locali = new h.i();
    locali.cwY = this.cxV;
    locali.cwZ = this.cxW;
    a(locali, paramAttributes);
    b(locali, paramAttributes);
    a(locali, paramAttributes);
    a(locali, paramAttributes);
    a(locali, paramAttributes);
    this.cxW.a(locali);
    AppMethodBeat.o(207931);
  }
  
  private static float k(float paramFloat1, float paramFloat2, float paramFloat3)
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
  
  private void k(Attributes paramAttributes)
  {
    AppMethodBeat.i(207935);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207935);
      throw paramAttributes;
    }
    h.q localq = new h.q();
    localq.cwY = this.cxV;
    localq.cwZ = this.cxW;
    a(localq, paramAttributes);
    b(localq, paramAttributes);
    a(localq, paramAttributes);
    a(localq, paramAttributes);
    a(localq, paramAttributes);
    this.cxW.a(localq);
    AppMethodBeat.o(207935);
  }
  
  private void l(Attributes paramAttributes)
  {
    AppMethodBeat.i(207940);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207940);
      throw paramAttributes;
    }
    h.z localz = new h.z();
    localz.cwY = this.cxV;
    localz.cwZ = this.cxW;
    a(localz, paramAttributes);
    b(localz, paramAttributes);
    a(localz, paramAttributes);
    a(localz, paramAttributes);
    a(localz, paramAttributes, "polyline");
    this.cxW.a(localz);
    AppMethodBeat.o(207940);
  }
  
  private void m(Attributes paramAttributes)
  {
    AppMethodBeat.i(207946);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207946);
      throw paramAttributes;
    }
    h.aa localaa = new h.aa();
    localaa.cwY = this.cxV;
    localaa.cwZ = this.cxW;
    a(localaa, paramAttributes);
    b(localaa, paramAttributes);
    a(localaa, paramAttributes);
    a(localaa, paramAttributes);
    a(localaa, paramAttributes, "polygon");
    this.cxW.a(localaa);
    AppMethodBeat.o(207946);
  }
  
  private void n(InputStream paramInputStream)
  {
    AppMethodBeat.i(207800);
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
        AppMethodBeat.o(207800);
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
        AppMethodBeat.o(207800);
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
      if (!this.cxX) {
        if (this.cxZ)
        {
          if (this.cyb == null) {
            this.cyb = new StringBuilder(j);
          }
          this.cyb.append((char[])localObject, i, j);
        }
        else if (this.cyc)
        {
          if (this.cyd == null) {
            this.cyd = new StringBuilder(j);
          }
          this.cyd.append((char[])localObject, i, j);
        }
        else if ((this.cxW instanceof h.ay))
        {
          bq(new String((char[])localObject, i, j));
          continue;
          text(localXmlPullParser.getText());
          continue;
          paramInputStream = new h(localXmlPullParser.getText());
          b(paramInputStream.OH(), a(paramInputStream));
          label466:
          while (i == 1)
          {
            Object localObject;
            int j;
            AppMethodBeat.o(207800);
            return;
          }
          switch (i)
          {
          }
        }
      }
    }
  }
  
  private void n(Attributes paramAttributes)
  {
    AppMethodBeat.i(207948);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207948);
      throw paramAttributes;
    }
    h.aw localaw = new h.aw();
    localaw.cwY = this.cxV;
    localaw.cwZ = this.cxW;
    a(localaw, paramAttributes);
    b(localaw, paramAttributes);
    a(localaw, paramAttributes);
    a(localaw, paramAttributes);
    a(localaw, paramAttributes);
    this.cxW.a(localaw);
    this.cxW = localaw;
    AppMethodBeat.o(207948);
  }
  
  private void o(Attributes paramAttributes)
  {
    AppMethodBeat.i(207950);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207950);
      throw paramAttributes;
    }
    if (!(this.cxW instanceof h.ay))
    {
      paramAttributes = new k("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
      AppMethodBeat.o(207950);
      throw paramAttributes;
    }
    h.av localav = new h.av();
    localav.cwY = this.cxV;
    localav.cwZ = this.cxW;
    a(localav, paramAttributes);
    b(localav, paramAttributes);
    a(localav, paramAttributes);
    a(localav, paramAttributes);
    this.cxW.a(localav);
    this.cxW = localav;
    if ((localav.cwZ instanceof h.bb))
    {
      localav.cxc = ((h.bb)localav.cwZ);
      AppMethodBeat.o(207950);
      return;
    }
    localav.cxc = ((h.ax)localav.cwZ).Oh();
    AppMethodBeat.o(207950);
  }
  
  private void p(Attributes paramAttributes)
  {
    AppMethodBeat.i(207952);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207952);
      throw paramAttributes;
    }
    if (!(this.cxW instanceof h.ay))
    {
      paramAttributes = new k("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
      AppMethodBeat.o(207952);
      throw paramAttributes;
    }
    h.au localau = new h.au();
    localau.cwY = this.cxV;
    localau.cwZ = this.cxW;
    a(localau, paramAttributes);
    b(localau, paramAttributes);
    a(localau, paramAttributes);
    a(localau, paramAttributes);
    this.cxW.a(localau);
    if ((localau.cwZ instanceof h.bb))
    {
      localau.cxc = ((h.bb)localau.cwZ);
      AppMethodBeat.o(207952);
      return;
    }
    localau.cxc = ((h.ax)localau.cwZ).Oh();
    AppMethodBeat.o(207952);
  }
  
  private void q(Attributes paramAttributes)
  {
    AppMethodBeat.i(207956);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207956);
      throw paramAttributes;
    }
    h.as localas = new h.as();
    localas.cwY = this.cxV;
    localas.cwZ = this.cxW;
    a(localas, paramAttributes);
    b(localas, paramAttributes);
    a(localas, paramAttributes);
    a(localas, paramAttributes);
    this.cxW.a(localas);
    this.cxW = localas;
    AppMethodBeat.o(207956);
  }
  
  private static float r(String paramString, int paramInt)
  {
    AppMethodBeat.i(208015);
    float f = new e().j(paramString, 0, paramInt);
    if (!Float.isNaN(f))
    {
      AppMethodBeat.o(208015);
      return f;
    }
    paramString = new k("Invalid float value: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(208015);
    throw paramString;
  }
  
  private void r(Attributes paramAttributes)
  {
    AppMethodBeat.i(207959);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207959);
      throw paramAttributes;
    }
    h.at localat = new h.at();
    localat.cwY = this.cxV;
    localat.cwZ = this.cxW;
    a(localat, paramAttributes);
    b(localat, paramAttributes);
    a(localat, paramAttributes);
    a(localat, paramAttributes);
    this.cxW.a(localat);
    this.cxW = localat;
    AppMethodBeat.o(207959);
  }
  
  private void s(Attributes paramAttributes)
  {
    AppMethodBeat.i(207962);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207962);
      throw paramAttributes;
    }
    h.r localr = new h.r();
    localr.cwY = this.cxV;
    localr.cwZ = this.cxW;
    a(localr, paramAttributes);
    b(localr, paramAttributes);
    a(localr, paramAttributes);
    a(localr, paramAttributes);
    a(localr, paramAttributes);
    this.cxW.a(localr);
    this.cxW = localr;
    AppMethodBeat.o(207962);
  }
  
  private void t(Attributes paramAttributes)
  {
    AppMethodBeat.i(207965);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207965);
      throw paramAttributes;
    }
    h.am localam = new h.am();
    localam.cwY = this.cxV;
    localam.cwZ = this.cxW;
    a(localam, paramAttributes);
    b(localam, paramAttributes);
    a(localam, paramAttributes);
    a(localam, paramAttributes);
    this.cxW.a(localam);
    this.cxW = localam;
    AppMethodBeat.o(207965);
  }
  
  private void u(Attributes paramAttributes)
  {
    AppMethodBeat.i(207969);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207969);
      throw paramAttributes;
    }
    h.aq localaq = new h.aq();
    localaq.cwY = this.cxV;
    localaq.cwZ = this.cxW;
    a(localaq, paramAttributes);
    b(localaq, paramAttributes);
    a(localaq, paramAttributes);
    a(localaq, paramAttributes);
    this.cxW.a(localaq);
    this.cxW = localaq;
    AppMethodBeat.o(207969);
  }
  
  private void v(Attributes paramAttributes)
  {
    AppMethodBeat.i(207972);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207972);
      throw paramAttributes;
    }
    if (!(this.cxW instanceof h.j))
    {
      paramAttributes = new k("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
      AppMethodBeat.o(207972);
      throw paramAttributes;
    }
    h.ad localad = new h.ad();
    localad.cwY = this.cxV;
    localad.cwZ = this.cxW;
    a(localad, paramAttributes);
    b(localad, paramAttributes);
    a(localad, paramAttributes);
    this.cxW.a(localad);
    this.cxW = localad;
    AppMethodBeat.o(207972);
  }
  
  private void w(Attributes paramAttributes)
  {
    AppMethodBeat.i(207977);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207977);
      throw paramAttributes;
    }
    h.ac localac = new h.ac();
    localac.cwY = this.cxV;
    localac.cwZ = this.cxW;
    a(localac, paramAttributes);
    b(localac, paramAttributes);
    this.cxW.a(localac);
    this.cxW = localac;
    AppMethodBeat.o(207977);
  }
  
  private void x(Attributes paramAttributes)
  {
    AppMethodBeat.i(207979);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207979);
      throw paramAttributes;
    }
    h.e locale = new h.e();
    locale.cwY = this.cxV;
    locale.cwZ = this.cxW;
    a(locale, paramAttributes);
    b(locale, paramAttributes);
    a(locale, paramAttributes);
    a(locale, paramAttributes);
    a(locale, paramAttributes);
    this.cxW.a(locale);
    this.cxW = locale;
    AppMethodBeat.o(207979);
  }
  
  private void y(Attributes paramAttributes)
  {
    AppMethodBeat.i(207982);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207982);
      throw paramAttributes;
    }
    h.az localaz = new h.az();
    localaz.cwY = this.cxV;
    localaz.cwZ = this.cxW;
    a(localaz, paramAttributes);
    b(localaz, paramAttributes);
    a(localaz, paramAttributes);
    a(localaz, paramAttributes);
    this.cxW.a(localaz);
    this.cxW = localaz;
    if ((localaz.cwZ instanceof h.bb))
    {
      localaz.cxc = ((h.bb)localaz.cwZ);
      AppMethodBeat.o(207982);
      return;
    }
    localaz.cxc = ((h.ax)localaz.cwZ).Oh();
    AppMethodBeat.o(207982);
  }
  
  private void z(Attributes paramAttributes)
  {
    AppMethodBeat.i(207986);
    if (this.cxW == null)
    {
      paramAttributes = new k("Invalid document. Root element must be <svg>");
      AppMethodBeat.o(207986);
      throw paramAttributes;
    }
    h.y localy = new h.y();
    localy.cwY = this.cxV;
    localy.cwZ = this.cxW;
    a(localy, paramAttributes);
    b(localy, paramAttributes);
    a(localy, paramAttributes);
    a(localy, paramAttributes);
    a(localy, paramAttributes);
    this.cxW.a(localy);
    this.cxW = localy;
    AppMethodBeat.o(207986);
  }
  
  /* Error */
  final h a(InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 2015
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 2020	java/io/InputStream:markSupported	()Z
    //   10: ifne +381 -> 391
    //   13: new 2022	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 2024	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: iconst_3
    //   24: invokevirtual 2027	java/io/InputStream:mark	(I)V
    //   27: aload_1
    //   28: invokevirtual 2030	java/io/InputStream:read	()I
    //   31: istore_3
    //   32: aload_1
    //   33: invokevirtual 2030	java/io/InputStream:read	()I
    //   36: istore 4
    //   38: aload_1
    //   39: invokevirtual 2033	java/io/InputStream:reset	()V
    //   42: iload_3
    //   43: iload 4
    //   45: bipush 8
    //   47: ishl
    //   48: iadd
    //   49: ldc_w 2034
    //   52: if_icmpne +336 -> 388
    //   55: new 2022	java/io/BufferedInputStream
    //   58: dup
    //   59: new 2036	java/util/zip/GZIPInputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 2037	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: invokespecial 2024	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore 5
    //   72: aload 5
    //   74: astore_1
    //   75: iload_2
    //   76: ifeq +267 -> 343
    //   79: aload_1
    //   80: sipush 4096
    //   83: invokevirtual 2027	java/io/InputStream:mark	(I)V
    //   86: sipush 4096
    //   89: newarray byte
    //   91: astore 5
    //   93: new 137	java/lang/String
    //   96: dup
    //   97: aload 5
    //   99: iconst_0
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 2040	java/io/InputStream:read	([B)I
    //   106: invokespecial 2043	java/lang/String:<init>	([BII)V
    //   109: astore 5
    //   111: aload_1
    //   112: invokevirtual 2033	java/io/InputStream:reset	()V
    //   115: aload 5
    //   117: ldc_w 2045
    //   120: invokevirtual 1719	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   123: istore_3
    //   124: iload_3
    //   125: iflt +218 -> 343
    //   128: invokestatic 2051	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   131: astore 5
    //   133: aload 5
    //   135: ldc_w 2053
    //   138: iconst_0
    //   139: invokevirtual 2054	javax/xml/parsers/SAXParserFactory:setFeature	(Ljava/lang/String;Z)V
    //   142: aload 5
    //   144: ldc_w 2056
    //   147: iconst_0
    //   148: invokevirtual 2054	javax/xml/parsers/SAXParserFactory:setFeature	(Ljava/lang/String;Z)V
    //   151: aload 5
    //   153: invokevirtual 2060	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   156: invokevirtual 2066	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   159: astore 5
    //   161: new 19	com/a/a/l$e
    //   164: dup
    //   165: aload_0
    //   166: iconst_0
    //   167: invokespecial 2069	com/a/a/l$e:<init>	(Lcom/a/a/l;B)V
    //   170: astore 6
    //   172: aload 5
    //   174: aload 6
    //   176: invokeinterface 2075 2 0
    //   181: aload 5
    //   183: ldc_w 2077
    //   186: aload 6
    //   188: invokeinterface 2081 3 0
    //   193: aload 5
    //   195: new 2083	org/xml/sax/InputSource
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 2084	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   203: invokeinterface 2088 2 0
    //   208: aload_0
    //   209: getfield 52	com/a/a/l:cxV	Lcom/a/a/h;
    //   212: astore 5
    //   214: aload_1
    //   215: invokevirtual 2091	java/io/InputStream:close	()V
    //   218: ldc_w 2015
    //   221: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload 5
    //   226: areturn
    //   227: astore 5
    //   229: new 78	com/a/a/k
    //   232: dup
    //   233: ldc_w 1848
    //   236: aload 5
    //   238: invokespecial 1573	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   241: astore 5
    //   243: ldc_w 2015
    //   246: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload 5
    //   251: athrow
    //   252: astore 5
    //   254: aload_0
    //   255: aload_1
    //   256: invokespecial 2093	com/a/a/l:n	(Ljava/io/InputStream;)V
    //   259: aload_0
    //   260: getfield 52	com/a/a/l:cxV	Lcom/a/a/h;
    //   263: astore 5
    //   265: aload_1
    //   266: invokevirtual 2091	java/io/InputStream:close	()V
    //   269: ldc_w 2015
    //   272: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload 5
    //   277: areturn
    //   278: astore 5
    //   280: new 78	com/a/a/k
    //   283: dup
    //   284: ldc_w 2095
    //   287: aload 5
    //   289: invokespecial 1573	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   292: astore 5
    //   294: ldc_w 2015
    //   297: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: aload 5
    //   302: athrow
    //   303: astore 5
    //   305: aload_1
    //   306: invokevirtual 2091	java/io/InputStream:close	()V
    //   309: ldc_w 2015
    //   312: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload 5
    //   317: athrow
    //   318: astore 5
    //   320: new 78	com/a/a/k
    //   323: dup
    //   324: ldc_w 1863
    //   327: aload 5
    //   329: invokespecial 1573	com/a/a/k:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   332: astore 5
    //   334: ldc_w 2015
    //   337: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload 5
    //   342: athrow
    //   343: aload_0
    //   344: aload_1
    //   345: invokespecial 2093	com/a/a/l:n	(Ljava/io/InputStream;)V
    //   348: aload_0
    //   349: getfield 52	com/a/a/l:cxV	Lcom/a/a/h;
    //   352: astore 5
    //   354: aload_1
    //   355: invokevirtual 2091	java/io/InputStream:close	()V
    //   358: ldc_w 2015
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
  
  final void endElement(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(208211);
    if (this.cxX)
    {
      int i = this.cxY - 1;
      this.cxY = i;
      if (i == 0) {
        this.cxX = false;
      }
      AppMethodBeat.o(208211);
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1)))
    {
      AppMethodBeat.o(208211);
      return;
    }
    if (paramString2.length() > 0) {
      switch (1.cye[g.cb(paramString2).ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(208211);
      return;
      paramString2 = paramString3;
      break;
      this.cxZ = false;
      if (this.cyb != null)
      {
        if (this.cya != g.cAA) {
          break label291;
        }
        this.cxV.title = this.cyb.toString();
      }
      for (;;)
      {
        this.cyb.setLength(0);
        AppMethodBeat.o(208211);
        return;
        label291:
        if (this.cya == g.cAf) {
          this.cxV.desc = this.cyb.toString();
        }
      }
      if (this.cyd != null)
      {
        this.cyc = false;
        bW(this.cyd.toString());
        this.cyd.setLength(0);
        AppMethodBeat.o(208211);
        return;
        if (this.cxW == null)
        {
          paramString1 = new k(String.format("Unbalanced end element </%s> found", new Object[] { paramString2 }));
          AppMethodBeat.o(208211);
          throw paramString1;
        }
        this.cxW = ((h.an)this.cxW).cwZ;
      }
    }
  }
  
  final void startDocument()
  {
    AppMethodBeat.i(208207);
    this.cxV = new h();
    AppMethodBeat.o(208207);
  }
  
  final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    AppMethodBeat.i(208209);
    if (this.cxX)
    {
      this.cxY += 1;
      AppMethodBeat.o(208209);
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1)))
    {
      AppMethodBeat.o(208209);
      return;
    }
    if (paramString2.length() > 0) {}
    for (;;)
    {
      paramString1 = g.cb(paramString2);
      switch (1.cye[paramString1.ordinal()])
      {
      default: 
        this.cxX = true;
        this.cxY = 1;
        AppMethodBeat.o(208209);
        return;
        paramString2 = paramString3;
      }
    }
    a(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    b(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    c(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    d(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    e(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    g(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    h(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    i(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    j(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    k(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    l(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    m(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    n(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    o(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    p(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    q(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    r(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    s(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    t(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    u(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    v(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    this.cxZ = true;
    this.cya = paramString1;
    AppMethodBeat.o(208209);
    return;
    x(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    y(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    z(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    f(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    A(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    B(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    C(paramAttributes);
    AppMethodBeat.o(208209);
    return;
    w(paramAttributes);
    AppMethodBeat.o(208209);
  }
  
  final void text(String paramString)
  {
    AppMethodBeat.i(208210);
    if (this.cxX)
    {
      AppMethodBeat.o(208210);
      return;
    }
    if (this.cxZ)
    {
      if (this.cyb == null) {
        this.cyb = new StringBuilder(paramString.length());
      }
      this.cyb.append(paramString);
      AppMethodBeat.o(208210);
      return;
    }
    if (this.cyc)
    {
      if (this.cyd == null) {
        this.cyd = new StringBuilder(paramString.length());
      }
      this.cyd.append(paramString);
      AppMethodBeat.o(208210);
      return;
    }
    if ((this.cxW instanceof h.ay)) {
      bq(paramString);
    }
    AppMethodBeat.o(208210);
  }
  
  static final class a
  {
    private static final Map<String, f.a> cyg;
    
    static
    {
      AppMethodBeat.i(207733);
      HashMap localHashMap = new HashMap(10);
      cyg = localHashMap;
      localHashMap.put("none", f.a.ctS);
      cyg.put("xMinYMin", f.a.ctT);
      cyg.put("xMidYMin", f.a.ctU);
      cyg.put("xMaxYMin", f.a.ctV);
      cyg.put("xMinYMid", f.a.ctW);
      cyg.put("xMidYMid", f.a.ctX);
      cyg.put("xMaxYMid", f.a.ctY);
      cyg.put("xMinYMax", f.a.ctZ);
      cyg.put("xMidYMax", f.a.cua);
      cyg.put("xMaxYMax", f.a.cub);
      AppMethodBeat.o(207733);
    }
    
    static f.a bX(String paramString)
    {
      AppMethodBeat.i(207726);
      paramString = (f.a)cyg.get(paramString);
      AppMethodBeat.o(207726);
      return paramString;
    }
  }
  
  static final class b
  {
    private static final Map<String, Integer> cyh;
    
    static
    {
      AppMethodBeat.i(207729);
      HashMap localHashMap = new HashMap(47);
      cyh = localHashMap;
      localHashMap.put("aliceblue", Integer.valueOf(-984833));
      cyh.put("antiquewhite", Integer.valueOf(-332841));
      cyh.put("aqua", Integer.valueOf(-16711681));
      cyh.put("aquamarine", Integer.valueOf(-8388652));
      cyh.put("azure", Integer.valueOf(-983041));
      cyh.put("beige", Integer.valueOf(-657956));
      cyh.put("bisque", Integer.valueOf(-6972));
      cyh.put("black", Integer.valueOf(-16777216));
      cyh.put("blanchedalmond", Integer.valueOf(-5171));
      cyh.put("blue", Integer.valueOf(-16776961));
      cyh.put("blueviolet", Integer.valueOf(-7722014));
      cyh.put("brown", Integer.valueOf(-5952982));
      cyh.put("burlywood", Integer.valueOf(-2180985));
      cyh.put("cadetblue", Integer.valueOf(-10510688));
      cyh.put("chartreuse", Integer.valueOf(-8388864));
      cyh.put("chocolate", Integer.valueOf(-2987746));
      cyh.put("coral", Integer.valueOf(-32944));
      cyh.put("cornflowerblue", Integer.valueOf(-10185235));
      cyh.put("cornsilk", Integer.valueOf(-1828));
      cyh.put("crimson", Integer.valueOf(-2354116));
      cyh.put("cyan", Integer.valueOf(-16711681));
      cyh.put("darkblue", Integer.valueOf(-16777077));
      cyh.put("darkcyan", Integer.valueOf(-16741493));
      cyh.put("darkgoldenrod", Integer.valueOf(-4684277));
      cyh.put("darkgray", Integer.valueOf(-5658199));
      cyh.put("darkgreen", Integer.valueOf(-16751616));
      cyh.put("darkgrey", Integer.valueOf(-5658199));
      cyh.put("darkkhaki", Integer.valueOf(-4343957));
      cyh.put("darkmagenta", Integer.valueOf(-7667573));
      cyh.put("darkolivegreen", Integer.valueOf(-11179217));
      cyh.put("darkorange", Integer.valueOf(-29696));
      cyh.put("darkorchid", Integer.valueOf(-6737204));
      cyh.put("darkred", Integer.valueOf(-7667712));
      cyh.put("darksalmon", Integer.valueOf(-1468806));
      cyh.put("darkseagreen", Integer.valueOf(-7357297));
      cyh.put("darkslateblue", Integer.valueOf(-12042869));
      cyh.put("darkslategray", Integer.valueOf(-13676721));
      cyh.put("darkslategrey", Integer.valueOf(-13676721));
      cyh.put("darkturquoise", Integer.valueOf(-16724271));
      cyh.put("darkviolet", Integer.valueOf(-7077677));
      cyh.put("deeppink", Integer.valueOf(-60269));
      cyh.put("deepskyblue", Integer.valueOf(-16728065));
      cyh.put("dimgray", Integer.valueOf(-9868951));
      cyh.put("dimgrey", Integer.valueOf(-9868951));
      cyh.put("dodgerblue", Integer.valueOf(-14774017));
      cyh.put("firebrick", Integer.valueOf(-5103070));
      cyh.put("floralwhite", Integer.valueOf(-1296));
      cyh.put("forestgreen", Integer.valueOf(-14513374));
      cyh.put("fuchsia", Integer.valueOf(-65281));
      cyh.put("gainsboro", Integer.valueOf(-2302756));
      cyh.put("ghostwhite", Integer.valueOf(-460545));
      cyh.put("gold", Integer.valueOf(-10496));
      cyh.put("goldenrod", Integer.valueOf(-2448096));
      cyh.put("gray", Integer.valueOf(-8355712));
      cyh.put("green", Integer.valueOf(-16744448));
      cyh.put("greenyellow", Integer.valueOf(-5374161));
      cyh.put("grey", Integer.valueOf(-8355712));
      cyh.put("honeydew", Integer.valueOf(-983056));
      cyh.put("hotpink", Integer.valueOf(-38476));
      cyh.put("indianred", Integer.valueOf(-3318692));
      cyh.put("indigo", Integer.valueOf(-11861886));
      cyh.put("ivory", Integer.valueOf(-16));
      cyh.put("khaki", Integer.valueOf(-989556));
      cyh.put("lavender", Integer.valueOf(-1644806));
      cyh.put("lavenderblush", Integer.valueOf(-3851));
      cyh.put("lawngreen", Integer.valueOf(-8586240));
      cyh.put("lemonchiffon", Integer.valueOf(-1331));
      cyh.put("lightblue", Integer.valueOf(-5383962));
      cyh.put("lightcoral", Integer.valueOf(-1015680));
      cyh.put("lightcyan", Integer.valueOf(-2031617));
      cyh.put("lightgoldenrodyellow", Integer.valueOf(-329006));
      cyh.put("lightgray", Integer.valueOf(-2894893));
      cyh.put("lightgreen", Integer.valueOf(-7278960));
      cyh.put("lightgrey", Integer.valueOf(-2894893));
      cyh.put("lightpink", Integer.valueOf(-18751));
      cyh.put("lightsalmon", Integer.valueOf(-24454));
      cyh.put("lightseagreen", Integer.valueOf(-14634326));
      cyh.put("lightskyblue", Integer.valueOf(-7876870));
      cyh.put("lightslategray", Integer.valueOf(-8943463));
      cyh.put("lightslategrey", Integer.valueOf(-8943463));
      cyh.put("lightsteelblue", Integer.valueOf(-5192482));
      cyh.put("lightyellow", Integer.valueOf(-32));
      cyh.put("lime", Integer.valueOf(-16711936));
      cyh.put("limegreen", Integer.valueOf(-13447886));
      cyh.put("linen", Integer.valueOf(-331546));
      cyh.put("magenta", Integer.valueOf(-65281));
      cyh.put("maroon", Integer.valueOf(-8388608));
      cyh.put("mediumaquamarine", Integer.valueOf(-10039894));
      cyh.put("mediumblue", Integer.valueOf(-16777011));
      cyh.put("mediumorchid", Integer.valueOf(-4565549));
      cyh.put("mediumpurple", Integer.valueOf(-7114533));
      cyh.put("mediumseagreen", Integer.valueOf(-12799119));
      cyh.put("mediumslateblue", Integer.valueOf(-8689426));
      cyh.put("mediumspringgreen", Integer.valueOf(-16713062));
      cyh.put("mediumturquoise", Integer.valueOf(-12004916));
      cyh.put("mediumvioletred", Integer.valueOf(-3730043));
      cyh.put("midnightblue", Integer.valueOf(-15132304));
      cyh.put("mintcream", Integer.valueOf(-655366));
      cyh.put("mistyrose", Integer.valueOf(-6943));
      cyh.put("moccasin", Integer.valueOf(-6987));
      cyh.put("navajowhite", Integer.valueOf(-8531));
      cyh.put("navy", Integer.valueOf(-16777088));
      cyh.put("oldlace", Integer.valueOf(-133658));
      cyh.put("olive", Integer.valueOf(-8355840));
      cyh.put("olivedrab", Integer.valueOf(-9728477));
      cyh.put("orange", Integer.valueOf(-23296));
      cyh.put("orangered", Integer.valueOf(-47872));
      cyh.put("orchid", Integer.valueOf(-2461482));
      cyh.put("palegoldenrod", Integer.valueOf(-1120086));
      cyh.put("palegreen", Integer.valueOf(-6751336));
      cyh.put("paleturquoise", Integer.valueOf(-5247250));
      cyh.put("palevioletred", Integer.valueOf(-2396013));
      cyh.put("papayawhip", Integer.valueOf(-4139));
      cyh.put("peachpuff", Integer.valueOf(-9543));
      cyh.put("peru", Integer.valueOf(-3308225));
      cyh.put("pink", Integer.valueOf(-16181));
      cyh.put("plum", Integer.valueOf(-2252579));
      cyh.put("powderblue", Integer.valueOf(-5185306));
      cyh.put("purple", Integer.valueOf(-8388480));
      cyh.put("rebeccapurple", Integer.valueOf(-10079335));
      cyh.put("red", Integer.valueOf(-65536));
      cyh.put("rosybrown", Integer.valueOf(-4419697));
      cyh.put("royalblue", Integer.valueOf(-12490271));
      cyh.put("saddlebrown", Integer.valueOf(-7650029));
      cyh.put("salmon", Integer.valueOf(-360334));
      cyh.put("sandybrown", Integer.valueOf(-744352));
      cyh.put("seagreen", Integer.valueOf(-13726889));
      cyh.put("seashell", Integer.valueOf(-2578));
      cyh.put("sienna", Integer.valueOf(-6270419));
      cyh.put("silver", Integer.valueOf(-4144960));
      cyh.put("skyblue", Integer.valueOf(-7876885));
      cyh.put("slateblue", Integer.valueOf(-9807155));
      cyh.put("slategray", Integer.valueOf(-9404272));
      cyh.put("slategrey", Integer.valueOf(-9404272));
      cyh.put("snow", Integer.valueOf(-1286));
      cyh.put("springgreen", Integer.valueOf(-16711809));
      cyh.put("steelblue", Integer.valueOf(-12156236));
      cyh.put("tan", Integer.valueOf(-2968436));
      cyh.put("teal", Integer.valueOf(-16744320));
      cyh.put("thistle", Integer.valueOf(-2572328));
      cyh.put("tomato", Integer.valueOf(-40121));
      cyh.put("turquoise", Integer.valueOf(-12525360));
      cyh.put("violet", Integer.valueOf(-1146130));
      cyh.put("wheat", Integer.valueOf(-663885));
      cyh.put("white", Integer.valueOf(-1));
      cyh.put("whitesmoke", Integer.valueOf(-657931));
      cyh.put("yellow", Integer.valueOf(-256));
      cyh.put("yellowgreen", Integer.valueOf(-6632142));
      cyh.put("transparent", Integer.valueOf(0));
      AppMethodBeat.o(207729);
    }
    
    static Integer bY(String paramString)
    {
      AppMethodBeat.i(207703);
      paramString = (Integer)cyh.get(paramString);
      AppMethodBeat.o(207703);
      return paramString;
    }
  }
  
  static final class c
  {
    private static final Map<String, h.p> cyi;
    
    static
    {
      AppMethodBeat.i(207716);
      HashMap localHashMap = new HashMap(9);
      cyi = localHashMap;
      localHashMap.put("xx-small", new h.p(0.694F, h.bd.cxn));
      cyi.put("x-small", new h.p(0.833F, h.bd.cxn));
      cyi.put("small", new h.p(10.0F, h.bd.cxn));
      cyi.put("medium", new h.p(12.0F, h.bd.cxn));
      cyi.put("large", new h.p(14.4F, h.bd.cxn));
      cyi.put("x-large", new h.p(17.299999F, h.bd.cxn));
      cyi.put("xx-large", new h.p(20.700001F, h.bd.cxn));
      cyi.put("smaller", new h.p(83.330002F, h.bd.cxp));
      cyi.put("larger", new h.p(120.0F, h.bd.cxp));
      AppMethodBeat.o(207716);
    }
    
    static h.p bZ(String paramString)
    {
      AppMethodBeat.i(207705);
      paramString = (h.p)cyi.get(paramString);
      AppMethodBeat.o(207705);
      return paramString;
    }
  }
  
  final class e
    extends DefaultHandler2
  {
    private e() {}
    
    public final void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207723);
      l.this.text(new String(paramArrayOfChar, paramInt1, paramInt2));
      AppMethodBeat.o(207723);
    }
    
    public final void endDocument() {}
    
    public final void endElement(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(207730);
      l.this.endElement(paramString1, paramString2, paramString3);
      AppMethodBeat.o(207730);
    }
    
    public final void processingInstruction(String paramString1, String paramString2)
    {
      AppMethodBeat.i(207739);
      l.b(paramString1, l.a(new l.h(paramString2)));
      AppMethodBeat.o(207739);
    }
    
    public final void startDocument()
    {
      AppMethodBeat.i(207714);
      l.this.startDocument();
      AppMethodBeat.o(207714);
    }
    
    public final void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    {
      AppMethodBeat.i(207717);
      l.this.startElement(paramString1, paramString2, paramString3, paramAttributes);
      AppMethodBeat.o(207717);
    }
  }
  
  static enum f
  {
    private static final Map<String, f> ctm;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(207782);
      cyl = new f("CLASS", 0);
      cym = new f("clip", 1);
      cyn = new f("clip_path", 2);
      cyo = new f("clipPathUnits", 3);
      cyp = new f("clip_rule", 4);
      cyq = new f("color", 5);
      cyr = new f("cx", 6);
      cys = new f("cy", 7);
      cyt = new f("direction", 8);
      cyu = new f("dx", 9);
      cyv = new f("dy", 10);
      cyw = new f("fx", 11);
      cyx = new f("fy", 12);
      cyy = new f("d", 13);
      cyz = new f("display", 14);
      cyA = new f("fill", 15);
      cyB = new f("fill_rule", 16);
      cyC = new f("fill_opacity", 17);
      cyD = new f("font", 18);
      cyE = new f("font_family", 19);
      cyF = new f("font_size", 20);
      cyG = new f("font_weight", 21);
      cyH = new f("font_style", 22);
      cyI = new f("gradientTransform", 23);
      cyJ = new f("gradientUnits", 24);
      cyK = new f("height", 25);
      cyL = new f("href", 26);
      cyM = new f("image_rendering", 27);
      cyN = new f("marker", 28);
      cyO = new f("marker_start", 29);
      cyP = new f("marker_mid", 30);
      cyQ = new f("marker_end", 31);
      cyR = new f("markerHeight", 32);
      cyS = new f("markerUnits", 33);
      cyT = new f("markerWidth", 34);
      cyU = new f("mask", 35);
      cyV = new f("maskContentUnits", 36);
      cyW = new f("maskUnits", 37);
      cyX = new f("media", 38);
      cyY = new f("offset", 39);
      cyZ = new f("opacity", 40);
      cza = new f("orient", 41);
      czb = new f("overflow", 42);
      czc = new f("pathLength", 43);
      czd = new f("patternContentUnits", 44);
      cze = new f("patternTransform", 45);
      czf = new f("patternUnits", 46);
      czg = new f("points", 47);
      czh = new f("preserveAspectRatio", 48);
      czi = new f("r", 49);
      czj = new f("refX", 50);
      czk = new f("refY", 51);
      czl = new f("requiredFeatures", 52);
      czm = new f("requiredExtensions", 53);
      czn = new f("requiredFormats", 54);
      czo = new f("requiredFonts", 55);
      czp = new f("rx", 56);
      czq = new f("ry", 57);
      czr = new f("solid_color", 58);
      czs = new f("solid_opacity", 59);
      czt = new f("spreadMethod", 60);
      czu = new f("startOffset", 61);
      czv = new f("stop_color", 62);
      czw = new f("stop_opacity", 63);
      czx = new f("stroke", 64);
      czy = new f("stroke_dasharray", 65);
      czz = new f("stroke_dashoffset", 66);
      czA = new f("stroke_linecap", 67);
      czB = new f("stroke_linejoin", 68);
      czC = new f("stroke_miterlimit", 69);
      czD = new f("stroke_opacity", 70);
      czE = new f("stroke_width", 71);
      czF = new f("style", 72);
      czG = new f("systemLanguage", 73);
      czH = new f("text_anchor", 74);
      czI = new f("text_decoration", 75);
      czJ = new f("transform", 76);
      czK = new f("type", 77);
      czL = new f("vector_effect", 78);
      czM = new f("version", 79);
      czN = new f("viewBox", 80);
      czO = new f("width", 81);
      czP = new f("x", 82);
      czQ = new f("y", 83);
      czR = new f("x1", 84);
      czS = new f("y1", 85);
      czT = new f("x2", 86);
      czU = new f("y2", 87);
      czV = new f("viewport_fill", 88);
      czW = new f("viewport_fill_opacity", 89);
      czX = new f("visibility", 90);
      czY = new f("UNSUPPORTED", 91);
      czZ = new f[] { cyl, cym, cyn, cyo, cyp, cyq, cyr, cys, cyt, cyu, cyv, cyw, cyx, cyy, cyz, cyA, cyB, cyC, cyD, cyE, cyF, cyG, cyH, cyI, cyJ, cyK, cyL, cyM, cyN, cyO, cyP, cyQ, cyR, cyS, cyT, cyU, cyV, cyW, cyX, cyY, cyZ, cza, czb, czc, czd, cze, czf, czg, czh, czi, czj, czk, czl, czm, czn, czo, czp, czq, czr, czs, czt, czu, czv, czw, czx, czy, czz, czA, czB, czC, czD, czE, czF, czG, czH, czI, czJ, czK, czL, czM, czN, czO, czP, czQ, czR, czS, czT, czU, czV, czW, czX, czY };
      ctm = new HashMap();
      f[] arrayOff = values();
      int j = arrayOff.length;
      if (i < j)
      {
        f localf = arrayOff[i];
        if (localf == cyl) {
          ctm.put("class", localf);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localf != czY)
          {
            String str = localf.name().replace('_', '-');
            ctm.put(str, localf);
          }
        }
      }
      AppMethodBeat.o(207782);
    }
    
    private f() {}
    
    public static f ca(String paramString)
    {
      AppMethodBeat.i(207748);
      paramString = (f)ctm.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(207748);
        return paramString;
      }
      paramString = czY;
      AppMethodBeat.o(207748);
      return paramString;
    }
  }
  
  static enum g
  {
    private static final Map<String, g> ctm;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(207735);
      cAa = new g("svg", 0);
      cAb = new g("a", 1);
      cAc = new g("circle", 2);
      cAd = new g("clipPath", 3);
      cAe = new g("defs", 4);
      cAf = new g("desc", 5);
      cAg = new g("ellipse", 6);
      cAh = new g("g", 7);
      cAi = new g("image", 8);
      cAj = new g("line", 9);
      cAk = new g("linearGradient", 10);
      cAl = new g("marker", 11);
      cAm = new g("mask", 12);
      cAn = new g("path", 13);
      cAo = new g("pattern", 14);
      cAp = new g("polygon", 15);
      cAq = new g("polyline", 16);
      cAr = new g("radialGradient", 17);
      cAs = new g("rect", 18);
      cAt = new g("solidColor", 19);
      cAu = new g("stop", 20);
      cAv = new g("style", 21);
      cAw = new g("SWITCH", 22);
      cAx = new g("symbol", 23);
      cAy = new g("text", 24);
      cAz = new g("textPath", 25);
      cAA = new g("title", 26);
      cAB = new g("tref", 27);
      cAC = new g("tspan", 28);
      cAD = new g("use", 29);
      cAE = new g("view", 30);
      cAF = new g("UNSUPPORTED", 31);
      cAG = new g[] { cAa, cAb, cAc, cAd, cAe, cAf, cAg, cAh, cAi, cAj, cAk, cAl, cAm, cAn, cAo, cAp, cAq, cAr, cAs, cAt, cAu, cAv, cAw, cAx, cAy, cAz, cAA, cAB, cAC, cAD, cAE, cAF };
      ctm = new HashMap();
      g[] arrayOfg = values();
      int j = arrayOfg.length;
      if (i < j)
      {
        g localg = arrayOfg[i];
        if (localg == cAw) {
          ctm.put("switch", localg);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localg != cAF)
          {
            String str = localg.name();
            ctm.put(str, localg);
          }
        }
      }
      AppMethodBeat.o(207735);
    }
    
    private g() {}
    
    public static g cb(String paramString)
    {
      AppMethodBeat.i(207722);
      paramString = (g)ctm.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(207722);
        return paramString;
      }
      paramString = cAF;
      AppMethodBeat.o(207722);
      return paramString;
    }
  }
  
  static class h
  {
    int cAH;
    private e cAI;
    String input;
    int position;
    
    h(String paramString)
    {
      AppMethodBeat.i(207718);
      this.position = 0;
      this.cAH = 0;
      this.cAI = new e();
      this.input = paramString.trim();
      this.cAH = this.input.length();
      AppMethodBeat.o(207718);
    }
    
    private Boolean OF()
    {
      AppMethodBeat.i(207743);
      if (this.position == this.cAH)
      {
        AppMethodBeat.o(207743);
        return null;
      }
      int i = this.input.charAt(this.position);
      if ((i == 48) || (i == 49))
      {
        this.position += 1;
        if (i == 49) {}
        for (boolean bool = true;; bool = false)
        {
          AppMethodBeat.o(207743);
          return Boolean.valueOf(bool);
        }
      }
      AppMethodBeat.o(207743);
      return null;
    }
    
    static boolean hb(int paramInt)
    {
      return (paramInt == 32) || (paramInt == 10) || (paramInt == 13) || (paramInt == 9);
    }
    
    static boolean hc(int paramInt)
    {
      return (paramInt == 10) || (paramInt == 13);
    }
    
    final boolean OA()
    {
      AppMethodBeat.i(207766);
      Oz();
      if (this.position == this.cAH)
      {
        AppMethodBeat.o(207766);
        return false;
      }
      if (this.input.charAt(this.position) != ',')
      {
        AppMethodBeat.o(207766);
        return false;
      }
      this.position += 1;
      Oz();
      AppMethodBeat.o(207766);
      return true;
    }
    
    final float OB()
    {
      AppMethodBeat.i(207775);
      float f = this.cAI.j(this.input, this.position, this.cAH);
      if (!Float.isNaN(f)) {
        this.position = this.cAI.pos;
      }
      AppMethodBeat.o(207775);
      return f;
    }
    
    final float OC()
    {
      AppMethodBeat.i(207786);
      OA();
      float f = this.cAI.j(this.input, this.position, this.cAH);
      if (!Float.isNaN(f)) {
        this.position = this.cAI.pos;
      }
      AppMethodBeat.o(207786);
      return f;
    }
    
    final Integer OD()
    {
      AppMethodBeat.i(207808);
      if (this.position == this.cAH)
      {
        AppMethodBeat.o(207808);
        return null;
      }
      String str = this.input;
      int i = this.position;
      this.position = (i + 1);
      i = str.charAt(i);
      AppMethodBeat.o(207808);
      return Integer.valueOf(i);
    }
    
    final h.p OE()
    {
      AppMethodBeat.i(207816);
      float f = OB();
      if (Float.isNaN(f))
      {
        AppMethodBeat.o(207816);
        return null;
      }
      Object localObject = OL();
      if (localObject == null)
      {
        localObject = new h.p(f, h.bd.cxh);
        AppMethodBeat.o(207816);
        return localObject;
      }
      localObject = new h.p(f, (h.bd)localObject);
      AppMethodBeat.o(207816);
      return localObject;
    }
    
    final int OG()
    {
      AppMethodBeat.i(207866);
      if (this.position == this.cAH)
      {
        AppMethodBeat.o(207866);
        return -1;
      }
      this.position += 1;
      if (this.position < this.cAH)
      {
        int i = this.input.charAt(this.position);
        AppMethodBeat.o(207866);
        return i;
      }
      AppMethodBeat.o(207866);
      return -1;
    }
    
    final String OH()
    {
      AppMethodBeat.i(369520);
      String str = b(' ', false);
      AppMethodBeat.o(369520);
      return str;
    }
    
    final String OI()
    {
      AppMethodBeat.i(207909);
      if (empty())
      {
        AppMethodBeat.o(207909);
        return null;
      }
      int j = this.position;
      int i = this.input.charAt(this.position);
      if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)))
      {
        for (i = OG(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)); i = OG()) {}
        String str = this.input.substring(j, this.position);
        AppMethodBeat.o(207909);
        return str;
      }
      this.position = j;
      AppMethodBeat.o(207909);
      return null;
    }
    
    final String OJ()
    {
      AppMethodBeat.i(207918);
      if (empty())
      {
        AppMethodBeat.o(207918);
        return null;
      }
      int j = this.position;
      for (int i = this.input.charAt(this.position); ((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)); i = OG()) {}
      int k = this.position;
      while (hb(i)) {
        i = OG();
      }
      if (i == 40)
      {
        this.position += 1;
        String str = this.input.substring(j, k);
        AppMethodBeat.o(207918);
        return str;
      }
      this.position = j;
      AppMethodBeat.o(207918);
      return null;
    }
    
    final String OK()
    {
      AppMethodBeat.i(207923);
      int i = this.position;
      while ((!empty()) && (!hb(this.input.charAt(this.position)))) {
        this.position += 1;
      }
      String str = this.input.substring(i, this.position);
      this.position = i;
      AppMethodBeat.o(207923);
      return str;
    }
    
    final h.bd OL()
    {
      AppMethodBeat.i(207929);
      if (empty())
      {
        AppMethodBeat.o(207929);
        return null;
      }
      h.bd localbd;
      if (this.input.charAt(this.position) == '%')
      {
        this.position += 1;
        localbd = h.bd.cxp;
        AppMethodBeat.o(207929);
        return localbd;
      }
      if (this.position > this.cAH - 2)
      {
        AppMethodBeat.o(207929);
        return null;
      }
      try
      {
        localbd = h.bd.valueOf(this.input.substring(this.position, this.position + 2).toLowerCase(Locale.US));
        this.position += 2;
        AppMethodBeat.o(207929);
        return localbd;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        AppMethodBeat.o(207929);
      }
      return null;
    }
    
    final boolean OM()
    {
      AppMethodBeat.i(207932);
      if (this.position == this.cAH)
      {
        AppMethodBeat.o(207932);
        return false;
      }
      int i = this.input.charAt(this.position);
      if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
      {
        AppMethodBeat.o(207932);
        return true;
      }
      AppMethodBeat.o(207932);
      return false;
    }
    
    final String ON()
    {
      AppMethodBeat.i(207937);
      if (empty())
      {
        AppMethodBeat.o(207937);
        return null;
      }
      int i = this.position;
      int j = this.input.charAt(this.position);
      if ((j != 39) && (j != 34))
      {
        AppMethodBeat.o(207937);
        return null;
      }
      int k;
      do
      {
        k = OG();
      } while ((k != -1) && (k != j));
      if (k == -1)
      {
        this.position = i;
        AppMethodBeat.o(207937);
        return null;
      }
      this.position += 1;
      String str = this.input.substring(i + 1, this.position - 1);
      AppMethodBeat.o(207937);
      return str;
    }
    
    final String OO()
    {
      AppMethodBeat.i(207942);
      if (empty())
      {
        AppMethodBeat.o(207942);
        return null;
      }
      int i = this.position;
      this.position = this.cAH;
      String str = this.input.substring(i);
      AppMethodBeat.o(207942);
      return str;
    }
    
    final void Oz()
    {
      AppMethodBeat.i(207758);
      while ((this.position < this.cAH) && (hb(this.input.charAt(this.position)))) {
        this.position += 1;
      }
      AppMethodBeat.o(207758);
    }
    
    final float aN(float paramFloat)
    {
      AppMethodBeat.i(207794);
      if (Float.isNaN(paramFloat))
      {
        AppMethodBeat.o(207794);
        return (0.0F / 0.0F);
      }
      OA();
      paramFloat = OB();
      AppMethodBeat.o(207794);
      return paramFloat;
    }
    
    final String b(char paramChar, boolean paramBoolean)
    {
      AppMethodBeat.i(207900);
      if (empty())
      {
        AppMethodBeat.o(207900);
        return null;
      }
      char c = this.input.charAt(this.position);
      if (((!paramBoolean) && (hb(c))) || (c == paramChar))
      {
        AppMethodBeat.o(207900);
        return null;
      }
      int i = this.position;
      for (c = OG(); (c != 'ð¿¿') && (c != paramChar) && ((paramBoolean) || (!hb(c))); c = OG()) {}
      String str = this.input.substring(i, this.position);
      AppMethodBeat.o(207900);
      return str;
    }
    
    final Boolean ba(Object paramObject)
    {
      AppMethodBeat.i(207829);
      if (paramObject == null)
      {
        AppMethodBeat.o(207829);
        return null;
      }
      OA();
      paramObject = OF();
      AppMethodBeat.o(207829);
      return paramObject;
    }
    
    final boolean c(char paramChar)
    {
      AppMethodBeat.i(207844);
      if ((this.position < this.cAH) && (this.input.charAt(this.position) == paramChar)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.position += 1;
        }
        AppMethodBeat.o(207844);
        return bool;
      }
    }
    
    final boolean cc(String paramString)
    {
      AppMethodBeat.i(207856);
      int i = paramString.length();
      if ((this.position <= this.cAH - i) && (this.input.substring(this.position, this.position + i).equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.position = (i + this.position);
        }
        AppMethodBeat.o(207856);
        return bool;
      }
    }
    
    final float d(Boolean paramBoolean)
    {
      AppMethodBeat.i(207801);
      if (paramBoolean == null)
      {
        AppMethodBeat.o(207801);
        return (0.0F / 0.0F);
      }
      OA();
      float f = OB();
      AppMethodBeat.o(207801);
      return f;
    }
    
    final String d(char paramChar)
    {
      AppMethodBeat.i(207888);
      String str = b(paramChar, false);
      AppMethodBeat.o(207888);
      return str;
    }
    
    final boolean empty()
    {
      return this.position == this.cAH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.a.a.l
 * JD-Core Version:    0.7.0.1
 */