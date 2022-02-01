package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class b
{
  private b.e awv = null;
  private b.t aww = null;
  private boolean awx = false;
  
  b()
  {
    this(b.e.awR, b.t.axL);
  }
  
  b(b.e parame, b.t paramt)
  {
    this.awv = parame;
    this.aww = paramt;
  }
  
  public static List<String> X(String paramString)
  {
    AppMethodBeat.i(201688);
    c localc = new c(paramString);
    paramString = null;
    while (!localc.empty())
    {
      String str = localc.a(' ', false);
      if (str != null)
      {
        Object localObject = paramString;
        if (paramString == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(str);
        localc.oR();
        paramString = (String)localObject;
      }
    }
    AppMethodBeat.o(201688);
    return paramString;
  }
  
  private static int a(List<h.aj> paramList, int paramInt, h.al paramal)
  {
    AppMethodBeat.i(201712);
    if (paramInt < 0)
    {
      AppMethodBeat.o(201712);
      return 0;
    }
    if (paramList.get(paramInt) != paramal.aBj)
    {
      AppMethodBeat.o(201712);
      return -1;
    }
    paramList = paramal.aBj.oq().iterator();
    paramInt = 0;
    while (paramList.hasNext())
    {
      if ((h.an)paramList.next() == paramal)
      {
        AppMethodBeat.o(201712);
        return paramInt;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(201712);
    return -1;
  }
  
  private static List<b.e> a(c paramc)
  {
    AppMethodBeat.i(201648);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str;
      if (!paramc.empty())
      {
        str = paramc.pa();
        if (str == null) {}
      }
      try
      {
        localArrayList.add(b.e.valueOf(str));
        label38:
        if (paramc.oS()) {
          continue;
        }
        AppMethodBeat.o(201648);
        return localArrayList;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label38;
      }
    }
  }
  
  private static boolean a(p paramp, r paramr, int paramInt1, List<h.aj> paramList, int paramInt2)
  {
    AppMethodBeat.i(201711);
    int i = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    h.al localal;
    for (;;)
    {
      s locals = paramr.dF(paramInt2);
      localal = (h.al)paramList.get(paramInt1);
      if (!a(paramp, locals, localal))
      {
        AppMethodBeat.o(201711);
        return false;
      }
      if (locals.axI == b.d.awG)
      {
        if (paramInt2 == 0)
        {
          AppMethodBeat.o(201711);
          return true;
        }
        while (paramInt1 > 0)
        {
          i = paramInt1 - 1;
          paramInt1 = i;
          if (a(paramp, paramr, paramInt2 - 1, paramList, i))
          {
            AppMethodBeat.o(201711);
            return true;
          }
        }
        AppMethodBeat.o(201711);
        return false;
      }
      if (locals.axI != b.d.awH) {
        break;
      }
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    i = a(paramList, paramInt1, localal);
    if (i <= 0)
    {
      AppMethodBeat.o(201711);
      return false;
    }
    boolean bool = a(paramp, paramr, paramInt2 - 1, paramList, paramInt1, (h.al)localal.aBj.oq().get(i - 1));
    AppMethodBeat.o(201711);
    return bool;
  }
  
  private static boolean a(p paramp, r paramr, int paramInt1, List<h.aj> paramList, int paramInt2, h.al paramal)
  {
    AppMethodBeat.i(201704);
    for (;;)
    {
      s locals = paramr.dF(paramInt1);
      if (!a(paramp, locals, paramal))
      {
        AppMethodBeat.o(201704);
        return false;
      }
      if (locals.axI == b.d.awG)
      {
        if (paramInt1 == 0)
        {
          AppMethodBeat.o(201704);
          return true;
        }
        do
        {
          paramInt2 -= 1;
          if (paramInt2 < 0) {
            break;
          }
        } while (!a(paramp, paramr, paramInt1 - 1, paramList, paramInt2));
        AppMethodBeat.o(201704);
        return true;
        AppMethodBeat.o(201704);
        return false;
      }
      if (locals.axI == b.d.awH)
      {
        boolean bool = a(paramp, paramr, paramInt1 - 1, paramList, paramInt2);
        AppMethodBeat.o(201704);
        return bool;
      }
      int i = a(paramList, paramInt2, paramal);
      if (i <= 0)
      {
        AppMethodBeat.o(201704);
        return false;
      }
      paramal = (h.al)paramal.aBj.oq().get(i - 1);
      paramInt1 -= 1;
    }
  }
  
  static boolean a(p paramp, r paramr, h.al paramal)
  {
    AppMethodBeat.i(201694);
    ArrayList localArrayList = new ArrayList();
    for (h.aj localaj = paramal.aBj; localaj != null; localaj = ((h.an)localaj).aBj) {
      localArrayList.add(0, localaj);
    }
    int i = localArrayList.size();
    if (paramr.size() == 1)
    {
      bool = a(paramp, paramr.dF(0), paramal);
      AppMethodBeat.o(201694);
      return bool;
    }
    boolean bool = a(paramp, paramr, paramr.size() - 1, localArrayList, i - 1, paramal);
    AppMethodBeat.o(201694);
    return bool;
  }
  
  private static boolean a(p paramp, s params, h.al paramal)
  {
    AppMethodBeat.i(201713);
    if ((params.tag != null) && (!params.tag.equals(paramal.om().toLowerCase(Locale.US))))
    {
      AppMethodBeat.o(201713);
      return false;
    }
    if (params.axJ != null)
    {
      Iterator localIterator = params.axJ.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        String str = locala.name;
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            AppMethodBeat.o(201713);
            return false;
            if (str.equals("id"))
            {
              i = 0;
              continue;
              if (str.equals("class")) {
                i = 1;
              }
            }
            break;
          }
        }
        if (!locala.value.equals(paramal.id))
        {
          AppMethodBeat.o(201713);
          return false;
          if (paramal.aBh == null)
          {
            AppMethodBeat.o(201713);
            return false;
          }
          if (!paramal.aBh.contains(locala.value))
          {
            AppMethodBeat.o(201713);
            return false;
          }
        }
      }
    }
    if (params.axK != null)
    {
      params = params.axK.iterator();
      while (params.hasNext()) {
        if (!((f)params.next()).a(paramp, paramal))
        {
          AppMethodBeat.o(201713);
          return false;
        }
      }
    }
    AppMethodBeat.o(201713);
    return true;
  }
  
  private boolean a(q paramq, c paramc)
  {
    AppMethodBeat.i(201686);
    List localList = paramc.nX();
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (!paramc.b('{'))
      {
        paramq = new a("Malformed rule block: expected '{'");
        AppMethodBeat.o(201686);
        throw paramq;
      }
      paramc.oR();
      h.ae localae = new h.ae();
      do
      {
        String str1 = paramc.nV();
        paramc.oR();
        if (!paramc.b(':'))
        {
          paramq = new a("Expected ':'");
          AppMethodBeat.o(201686);
          throw paramq;
        }
        paramc.oR();
        String str2 = paramc.nY();
        if (str2 == null)
        {
          paramq = new a("Expected property value");
          AppMethodBeat.o(201686);
          throw paramq;
        }
        paramc.oR();
        if (paramc.b('!'))
        {
          paramc.oR();
          if (!paramc.aP("important"))
          {
            paramq = new a("Malformed rule set: found unexpected '!'");
            AppMethodBeat.o(201686);
            throw paramq;
          }
          paramc.oR();
        }
        paramc.b(';');
        l.a(localae, str1, str2);
        paramc.oR();
      } while ((!paramc.empty()) && (!paramc.b('}')));
      paramc.oR();
      paramc = localList.iterator();
      while (paramc.hasNext()) {
        paramq.a(new o((r)paramc.next(), localae, this.aww));
      }
      AppMethodBeat.o(201686);
      return true;
    }
    AppMethodBeat.o(201686);
    return false;
  }
  
  static boolean a(String paramString, b.e parame)
  {
    AppMethodBeat.i(201641);
    paramString = new c(paramString);
    paramString.oR();
    boolean bool = a(a(paramString), parame);
    AppMethodBeat.o(201641);
    return bool;
  }
  
  private static boolean a(List<b.e> paramList, b.e parame)
  {
    AppMethodBeat.i(201643);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.e locale = (b.e)paramList.next();
      if ((locale == b.e.awK) || (locale == parame))
      {
        AppMethodBeat.o(201643);
        return true;
      }
    }
    AppMethodBeat.o(201643);
    return false;
  }
  
  private static void b(c paramc)
  {
    AppMethodBeat.i(201652);
    int i = 0;
    while (!paramc.empty())
    {
      int j = paramc.oV().intValue();
      if ((j == 59) && (i == 0))
      {
        AppMethodBeat.o(201652);
        return;
      }
      if (j == 123)
      {
        i += 1;
      }
      else if ((j == 125) && (i > 0))
      {
        j = i - 1;
        i = j;
        if (j == 0)
        {
          AppMethodBeat.o(201652);
          return;
        }
      }
    }
    AppMethodBeat.o(201652);
  }
  
  private q c(c paramc)
  {
    AppMethodBeat.i(201681);
    q localq = new q();
    Object localObject1;
    try
    {
      while (!paramc.empty()) {
        if ((!paramc.aP("<!--")) && (!paramc.aP("-->")))
        {
          if (!paramc.b('@')) {
            break label744;
          }
          localObject1 = paramc.nV();
          paramc.oR();
          if (localObject1 != null) {
            break label113;
          }
          paramc = new a("Invalid '@' rule");
          AppMethodBeat.o(201681);
          throw paramc;
        }
      }
    }
    catch (a paramc)
    {
      new StringBuilder("CSS parser terminated early due to error: ").append(paramc.getMessage());
    }
    for (;;)
    {
      AppMethodBeat.o(201681);
      return localq;
      label113:
      if ((!this.awx) && (((String)localObject1).equals("media")))
      {
        localObject1 = a(paramc);
        if (!paramc.b('{'))
        {
          paramc = new a("Invalid @media rule: missing rule set");
          AppMethodBeat.o(201681);
          throw paramc;
        }
        paramc.oR();
        if (a((List)localObject1, this.awv))
        {
          this.awx = true;
          localq.a(c(paramc));
          this.awx = false;
        }
      }
      for (;;)
      {
        if ((!paramc.empty()) && (!paramc.b('}')))
        {
          paramc = new a("Invalid @media rule: expected '}' at end of rule set");
          AppMethodBeat.o(201681);
          throw paramc;
          c(paramc);
          continue;
          if ((!this.awx) && (((String)localObject1).equals("import")))
          {
            if (paramc.empty()) {}
            int k;
            for (localObject1 = null;; localObject1 = null)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = paramc.nZ();
              }
              if (localObject2 != null) {
                break label647;
              }
              paramc = new a("Invalid @import rule: expected string or url()");
              AppMethodBeat.o(201681);
              throw paramc;
              k = paramc.position;
              if (paramc.aP("url(")) {
                break;
              }
            }
            paramc.oR();
            localObject1 = paramc.nZ();
            Object localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject1 = new StringBuilder();
              while (!paramc.empty())
              {
                int j = paramc.input.charAt(paramc.position);
                if ((j == 39) || (j == 34) || (j == 40) || (j == 41) || (c.dH(j)) || (Character.isISOControl(j))) {
                  break;
                }
                paramc.position += 1;
                int i = j;
                if (j == 92)
                {
                  if (paramc.empty()) {
                    continue;
                  }
                  localObject2 = paramc.input;
                  i = paramc.position;
                  paramc.position = (i + 1);
                  i = ((String)localObject2).charAt(i);
                  if ((i == 10) || (i == 13) || (i == 12)) {
                    continue;
                  }
                  j = c.dE(i);
                  if (j != -1)
                  {
                    i = 1;
                    while ((i <= 5) && (!paramc.empty()))
                    {
                      int m = c.dE(paramc.input.charAt(paramc.position));
                      if (m == -1) {
                        break;
                      }
                      paramc.position += 1;
                      j = j * 16 + m;
                      i += 1;
                    }
                    ((StringBuilder)localObject1).append((char)j);
                    continue;
                  }
                }
                ((StringBuilder)localObject1).append((char)i);
              }
              if (((StringBuilder)localObject1).length() != 0) {
                break label637;
              }
            }
            label637:
            for (localObject2 = null;; localObject2 = ((StringBuilder)localObject1).toString())
            {
              if (localObject2 != null)
              {
                paramc.oR();
                localObject1 = localObject2;
                if (paramc.empty()) {
                  break;
                }
                localObject1 = localObject2;
                if (paramc.aP(")")) {
                  break;
                }
              }
              paramc.position = k;
              localObject1 = null;
              break;
            }
            label647:
            paramc.oR();
            localObject1 = a(paramc);
            if ((!paramc.empty()) && (!paramc.b(';')))
            {
              paramc = new a("Invalid @media rule: expected '}' at end of rule set");
              AppMethodBeat.o(201681);
              throw paramc;
            }
            if ((h.ol() == null) || (!a((List)localObject1, this.awv))) {
              break label737;
            }
            h.ol();
            break;
          }
          String.format("Ignoring @%s rule", new Object[] { localObject1 });
          b(paramc);
        }
      }
      label737:
      paramc.oR();
      break;
      label744:
      boolean bool = a(localq, paramc);
      if (bool) {
        break;
      }
    }
  }
  
  final q W(String paramString)
  {
    AppMethodBeat.i(201639);
    paramString = new c(paramString);
    paramString.oR();
    paramString = c(paramString);
    AppMethodBeat.o(201639);
    return paramString;
  }
  
  static final class a
  {
    final b.b awA;
    public final String name;
    public final String value;
    
    a(String paramString1, b.b paramb, String paramString2)
    {
      this.name = paramString1;
      this.awA = paramb;
      this.value = paramString2;
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(201370);
      awB = new b("EXISTS", 0);
      awC = new b("EQUALS", 1);
      awD = new b("INCLUDES", 2);
      awE = new b("DASHMATCH", 3);
      awF = new b[] { awB, awC, awD, awE };
      AppMethodBeat.o(201370);
    }
    
    private b() {}
  }
  
  static final class c
    extends l.h
  {
    c(String paramString)
    {
      super();
      AppMethodBeat.i(201375);
      AppMethodBeat.o(201375);
    }
    
    private boolean a(b.r paramr)
    {
      AppMethodBeat.i(201452);
      if (empty())
      {
        AppMethodBeat.o(201452);
        return false;
      }
      int m = this.position;
      b.d locald;
      if (!paramr.isEmpty()) {
        if (b('>'))
        {
          locald = b.d.awH;
          oR();
        }
      }
      for (;;)
      {
        Object localObject1;
        if (b('*')) {
          localObject1 = new b.s(locald, null);
        }
        label1048:
        label1054:
        label1335:
        label1724:
        label1991:
        for (;;)
        {
          Object localObject3;
          String str;
          label466:
          Object localObject4;
          if (!empty())
          {
            if (b('.'))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new b.s(locald, null);
              }
              localObject1 = nV();
              if (localObject1 == null)
              {
                paramr = new a("Invalid \".class\" simpleSelectors");
                AppMethodBeat.o(201452);
                throw paramr;
                if (!b('+')) {
                  break label2012;
                }
                locald = b.d.awI;
                oR();
                break;
                localObject1 = nV();
                if (localObject1 == null) {
                  break label2006;
                }
                localObject1 = new b.s(locald, (String)localObject1);
                paramr.axH += 1;
                continue;
              }
              ((b.s)localObject2).a("class", b.b.awC, (String)localObject1);
              paramr.oa();
              localObject1 = localObject2;
              continue;
            }
            if (b('#'))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new b.s(locald, null);
              }
              localObject1 = nV();
              if (localObject1 == null)
              {
                paramr = new a("Invalid \"#id\" simpleSelectors");
                AppMethodBeat.o(201452);
                throw paramr;
              }
              ((b.s)localObject2).a("id", b.b.awC, (String)localObject1);
              paramr.axH += 1000000;
              localObject1 = localObject2;
              continue;
            }
            if (b('['))
            {
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = new b.s(locald, null);
              }
              oR();
              str = nV();
              localObject2 = null;
              if (str == null)
              {
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(201452);
                throw paramr;
              }
              oR();
              localObject1 = null;
              if (b('='))
              {
                localObject1 = b.b.awC;
                if (localObject1 == null) {
                  break label494;
                }
                oR();
                if (!empty()) {
                  break label466;
                }
                localObject2 = null;
              }
              for (;;)
              {
                if (localObject2 != null) {
                  break label490;
                }
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(201452);
                throw paramr;
                if (aP("~="))
                {
                  localObject1 = b.b.awD;
                  break;
                }
                if (!aP("|=")) {
                  break;
                }
                localObject1 = b.b.awE;
                break;
                localObject4 = pf();
                localObject2 = localObject4;
                if (localObject4 == null) {
                  localObject2 = nV();
                }
              }
              label490:
              oR();
              label494:
              if (!b(']'))
              {
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(201452);
                throw paramr;
              }
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = b.b.awB;
              }
              ((b.s)localObject3).a(str, (b.b)localObject4, (String)localObject2);
              paramr.oa();
              localObject1 = localObject3;
              continue;
            }
            if (b(':')) {
              if (localObject1 != null) {
                break label1999;
              }
            }
          }
          label1099:
          label1999:
          for (Object localObject2 = new b.s(locald, null);; localObject2 = localObject1)
          {
            str = nV();
            if (str == null)
            {
              paramr = new a("Invalid pseudo class");
              AppMethodBeat.o(201452);
              throw paramr;
            }
            localObject1 = b.i.Y(str);
            boolean bool1;
            boolean bool2;
            label1002:
            label1012:
            int n;
            label1138:
            int k;
            int j;
            int i;
            switch (b.1.awz[localObject1.ordinal()])
            {
            default: 
              paramr = new a("Unsupported pseudo class: ".concat(String.valueOf(str)));
              AppMethodBeat.o(201452);
              throw paramr;
            case 1: 
              localObject1 = new b.g(0, 1, true, false, null);
              paramr.oa();
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
              for (;;)
              {
                if (((b.s)localObject2).axK == null) {
                  ((b.s)localObject2).axK = new ArrayList();
                }
                ((b.s)localObject2).axK.add(localObject1);
                localObject1 = localObject2;
                break;
                localObject1 = new b.g(0, 1, false, false, null);
                paramr.oa();
                continue;
                localObject1 = new b.l(false, null);
                paramr.oa();
                continue;
                localObject1 = new b.g(0, 1, true, true, ((b.s)localObject2).tag);
                paramr.oa();
                continue;
                localObject1 = new b.g(0, 1, false, true, ((b.s)localObject2).tag);
                paramr.oa();
                continue;
                localObject1 = new b.l(true, ((b.s)localObject2).tag);
                paramr.oa();
                continue;
                localObject1 = new b.m((byte)0);
                paramr.oa();
                continue;
                localObject1 = new b.h((byte)0);
                paramr.oa();
              }
            case 9: 
            case 10: 
            case 11: 
            case 12: 
              if ((localObject1 == b.i.axb) || (localObject1 == b.i.axd))
              {
                bool1 = true;
                if ((localObject1 != b.i.axd) && (localObject1 != b.i.axe)) {
                  break label1048;
                }
                bool2 = true;
                if (!empty()) {
                  break label1054;
                }
                localObject1 = null;
              }
              for (;;)
              {
                if (localObject1 == null)
                {
                  paramr = new a("Invalid or missing parameter section for pseudo class: ".concat(String.valueOf(str)));
                  AppMethodBeat.o(201452);
                  throw paramr;
                  bool1 = false;
                  break;
                  bool2 = false;
                  break label1002;
                  n = this.position;
                  if (!b('('))
                  {
                    localObject1 = null;
                  }
                  else
                  {
                    oR();
                    if (aP("odd")) {}
                    for (localObject1 = new a(2, 1);; localObject1 = new a(2, 0))
                    {
                      oR();
                      if (!b(')')) {
                        break label1409;
                      }
                      break;
                      if (!aP("even")) {
                        break label1138;
                      }
                    }
                    k = 1;
                    j = 1;
                    i = j;
                    if (!b('+'))
                    {
                      i = j;
                      if (b('-')) {
                        i = -1;
                      }
                    }
                    localObject3 = null;
                    localObject1 = d.e(this.input, this.position, this.aEV);
                    if (localObject1 != null) {
                      this.position = ((d)localObject1).pos;
                    }
                    if ((!b('n')) && (!b('N'))) {
                      break label1991;
                    }
                    if (localObject1 != null)
                    {
                      localObject4 = null;
                      k = 1;
                      oR();
                      boolean bool4 = b('+');
                      boolean bool3 = bool4;
                      j = k;
                      if (!bool4)
                      {
                        bool4 = b('-');
                        bool3 = bool4;
                        j = k;
                        if (bool4)
                        {
                          j = -1;
                          bool3 = bool4;
                        }
                      }
                      if (!bool3) {
                        break label1980;
                      }
                      oR();
                      localObject4 = d.e(this.input, this.position, this.aEV);
                      if (localObject4 == null) {
                        break label1373;
                      }
                      this.position = ((d)localObject4).pos;
                      localObject3 = localObject1;
                      localObject1 = localObject4;
                    }
                  }
                }
              }
            }
            for (;;)
            {
              if (localObject3 == null)
              {
                i = 0;
                if (localObject1 != null) {
                  break label1397;
                }
              }
              label1373:
              label1397:
              for (j = 0;; j = (int)((d)localObject1).value * j)
              {
                localObject1 = new a(i, j);
                break label1099;
                localObject1 = new d(1L, this.position);
                break label1224;
                this.position = n;
                localObject1 = null;
                break;
                i = (int)((d)localObject3).value * i;
                break label1335;
              }
              this.position = n;
              localObject1 = null;
              break label1012;
              localObject1 = new b.g(((a)localObject1).a, ((a)localObject1).b, bool1, bool2, ((b.s)localObject2).tag);
              paramr.oa();
              break;
              if (empty()) {
                localObject1 = null;
              }
              while (localObject1 == null)
              {
                paramr = new a("Invalid or missing parameter section for pseudo class: ".concat(String.valueOf(str)));
                AppMethodBeat.o(201452);
                throw paramr;
                i = this.position;
                if (!b('('))
                {
                  localObject1 = null;
                }
                else
                {
                  oR();
                  localObject1 = nX();
                  if (localObject1 == null)
                  {
                    this.position = i;
                    localObject1 = null;
                  }
                  else if (!b(')'))
                  {
                    this.position = i;
                    localObject1 = null;
                  }
                  else
                  {
                    localObject3 = ((List)localObject1).iterator();
                    Object localObject5;
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            if (!((Iterator)localObject3).hasNext()) {
                              break label1687;
                            }
                            localObject4 = (b.r)((Iterator)localObject3).next();
                            if (((b.r)localObject4).axG == null) {
                              break label1687;
                            }
                            localObject4 = ((b.r)localObject4).axG.iterator();
                            break;
                          } while (!((Iterator)localObject4).hasNext());
                          localObject5 = (b.s)((Iterator)localObject4).next();
                        } while (((b.s)localObject5).axK == null);
                        localObject5 = ((b.s)localObject5).axK.iterator();
                      } while (!((Iterator)localObject5).hasNext());
                    } while (!((b.f)((Iterator)localObject5).next() instanceof b.j));
                    localObject1 = null;
                  }
                }
              }
              localObject1 = new b.j((List)localObject1);
              localObject3 = (b.j)localObject1;
              i = -2147483648;
              localObject3 = ((b.j)localObject3).axA.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (b.r)((Iterator)localObject3).next();
                if (((b.r)localObject4).axH <= i) {
                  break label1977;
                }
                i = ((b.r)localObject4).axH;
              }
              for (;;)
              {
                break label1724;
                paramr.axH = i;
                break;
                localObject1 = new b.n((byte)0);
                paramr.oa();
                break;
                if (empty()) {}
                for (;;)
                {
                  localObject1 = new b.k(str);
                  paramr.oa();
                  break;
                  i = this.position;
                  localObject1 = null;
                  if (b('('))
                  {
                    oR();
                    do
                    {
                      localObject4 = nV();
                      if (localObject4 == null) {
                        break;
                      }
                      localObject3 = localObject1;
                      if (localObject1 == null) {
                        localObject3 = new ArrayList();
                      }
                      ((ArrayList)localObject3).add(localObject4);
                      oR();
                      localObject1 = localObject3;
                    } while (oS());
                    if (!b(')')) {
                      this.position = i;
                    }
                  }
                }
                localObject1 = new b.k(str);
                paramr.oa();
                break;
                if (localObject1 != null)
                {
                  if (paramr.axG == null) {
                    paramr.axG = new ArrayList();
                  }
                  paramr.axG.add(localObject1);
                  AppMethodBeat.o(201452);
                  return true;
                }
                this.position = m;
                AppMethodBeat.o(201452);
                return false;
              }
              localObject3 = localObject1;
              localObject1 = localObject4;
              continue;
              j = i;
              i = k;
            }
          }
          label1224:
          label2006:
          localObject1 = null;
        }
        label1409:
        label1687:
        label1977:
        label1980:
        label2012:
        locald = null;
      }
    }
    
    static int dE(int paramInt)
    {
      if ((paramInt >= 48) && (paramInt <= 57)) {
        return paramInt - 48;
      }
      if ((paramInt >= 65) && (paramInt <= 70)) {
        return paramInt - 65 + 10;
      }
      if ((paramInt >= 97) && (paramInt <= 102)) {
        return paramInt - 97 + 10;
      }
      return -1;
    }
    
    private int nW()
    {
      AppMethodBeat.i(201383);
      if (empty())
      {
        i = this.position;
        AppMethodBeat.o(201383);
        return i;
      }
      int m = this.position;
      int j = this.position;
      int k = this.input.charAt(this.position);
      int i = k;
      if (k == 45) {
        i = oY();
      }
      if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || (i == 95))
      {
        for (i = oY(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || ((i >= 48) && (i <= 57)) || (i == 45) || (i == 95); i = oY()) {}
        j = this.position;
      }
      this.position = m;
      AppMethodBeat.o(201383);
      return j;
    }
    
    final String nV()
    {
      AppMethodBeat.i(201378);
      int i = nW();
      if (i == this.position)
      {
        AppMethodBeat.o(201378);
        return null;
      }
      String str = this.input.substring(this.position, i);
      this.position = i;
      AppMethodBeat.o(201378);
      return str;
    }
    
    final List<b.r> nX()
    {
      AppMethodBeat.i(201386);
      if (empty())
      {
        AppMethodBeat.o(201386);
        return null;
      }
      ArrayList localArrayList = new ArrayList(1);
      b.r localr = new b.r((byte)0);
      while ((!empty()) && (a(localr))) {
        if (oS())
        {
          localArrayList.add(localr);
          localr = new b.r((byte)0);
        }
      }
      if (!localr.isEmpty()) {
        localArrayList.add(localr);
      }
      AppMethodBeat.o(201386);
      return localArrayList;
    }
    
    final String nY()
    {
      AppMethodBeat.i(201455);
      if (empty())
      {
        AppMethodBeat.o(201455);
        return null;
      }
      int k = this.position;
      int j = this.position;
      for (int i = this.input.charAt(this.position); (i != -1) && (i != 59) && (i != 125) && (i != 33) && (!dI(i)); i = oY()) {
        if (!dH(i)) {
          j = this.position + 1;
        }
      }
      if (this.position > k)
      {
        String str = this.input.substring(k, j);
        AppMethodBeat.o(201455);
        return str;
      }
      this.position = k;
      AppMethodBeat.o(201455);
      return null;
    }
    
    final String nZ()
    {
      AppMethodBeat.i(201460);
      if (empty())
      {
        AppMethodBeat.o(201460);
        return null;
      }
      int n = this.input.charAt(this.position);
      if ((n != 39) && (n != 34))
      {
        AppMethodBeat.o(201460);
        return null;
      }
      Object localObject = new StringBuilder();
      this.position += 1;
      int i = oV().intValue();
      while ((i != -1) && (i != n))
      {
        int k = i;
        if (i == 92)
        {
          int j = oV().intValue();
          i = j;
          if (j == -1) {
            continue;
          }
          if ((j == 10) || (j == 13) || (j == 12))
          {
            i = oV().intValue();
            continue;
          }
          int m = dE(j);
          k = j;
          if (m != -1)
          {
            k = 1;
            for (;;)
            {
              i = j;
              if (k > 5) {
                break;
              }
              j = oV().intValue();
              int i1 = dE(j);
              i = j;
              if (i1 == -1) {
                break;
              }
              m = m * 16 + i1;
              k += 1;
            }
            ((StringBuilder)localObject).append((char)m);
            continue;
          }
        }
        ((StringBuilder)localObject).append((char)k);
        i = oV().intValue();
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(201460);
      return localObject;
    }
    
    static final class a
    {
      public int a;
      public int b;
      
      a(int paramInt1, int paramInt2)
      {
        this.a = paramInt1;
        this.b = paramInt2;
      }
    }
  }
  
  static abstract interface f
  {
    public abstract boolean a(b.p paramp, h.al paramal);
  }
  
  static final class g
    implements b.f
  {
    private int a;
    private boolean awW;
    private boolean awX;
    private String awY;
    private int b;
    
    g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.awW = paramBoolean1;
      this.awX = paramBoolean2;
      this.awY = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(201491);
      int i;
      label52:
      int m;
      int k;
      if ((this.awX) && (this.awY == null))
      {
        paramp = paramal.om();
        if (paramal.aBj == null) {
          break label124;
        }
        Iterator localIterator = paramal.aBj.oq().iterator();
        i = 0;
        int j = 0;
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break label130;
        }
        h.al localal = (h.al)localIterator.next();
        if (localal == paramal) {
          j = i;
        }
        if ((paramp != null) && (!localal.om().equals(paramp))) {
          break label239;
        }
        i += 1;
      }
      label130:
      label239:
      for (;;)
      {
        break label52;
        paramp = this.awY;
        break;
        label124:
        m = 1;
        k = 0;
        if (this.awW) {
          i = k + 1;
        }
        while (this.a == 0) {
          if (i == this.b)
          {
            AppMethodBeat.o(201491);
            return true;
            i = m - k;
          }
          else
          {
            AppMethodBeat.o(201491);
            return false;
          }
        }
        if (((i - this.b) % this.a == 0) && ((Integer.signum(i - this.b) == 0) || (Integer.signum(i - this.b) == Integer.signum(this.a))))
        {
          AppMethodBeat.o(201491);
          return true;
        }
        AppMethodBeat.o(201491);
        return false;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201493);
      if (this.awW) {}
      for (String str = ""; this.awX; str = "last-")
      {
        str = String.format("nth-%schild(%dn%+d of type <%s>)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.awY });
        AppMethodBeat.o(201493);
        return str;
      }
      str = String.format("nth-%schild(%dn%+d)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b) });
      AppMethodBeat.o(201493);
      return str;
    }
  }
  
  static final class h
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(201499);
      if ((paramal instanceof h.aj))
      {
        if (((h.aj)paramal).oq().size() == 0)
        {
          AppMethodBeat.o(201499);
          return true;
        }
        AppMethodBeat.o(201499);
        return false;
      }
      AppMethodBeat.o(201499);
      return true;
    }
    
    public final String toString()
    {
      return "empty";
    }
  }
  
  static enum i
  {
    private static final Map<String, i> axy;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(201521);
      awZ = new i("target", 0);
      axa = new i("root", 1);
      axb = new i("nth_child", 2);
      axc = new i("nth_last_child", 3);
      axd = new i("nth_of_type", 4);
      axe = new i("nth_last_of_type", 5);
      axf = new i("first_child", 6);
      axg = new i("last_child", 7);
      axh = new i("first_of_type", 8);
      axi = new i("last_of_type", 9);
      axj = new i("only_child", 10);
      axk = new i("only_of_type", 11);
      axl = new i("empty", 12);
      axm = new i("not", 13);
      axn = new i("lang", 14);
      axo = new i("link", 15);
      axp = new i("visited", 16);
      axq = new i("hover", 17);
      axr = new i("active", 18);
      axs = new i("focus", 19);
      axt = new i("enabled", 20);
      axu = new i("disabled", 21);
      axv = new i("checked", 22);
      axw = new i("indeterminate", 23);
      axx = new i("UNSUPPORTED", 24);
      axz = new i[] { awZ, axa, axb, axc, axd, axe, axf, axg, axh, axi, axj, axk, axl, axm, axn, axo, axp, axq, axr, axs, axt, axu, axv, axw, axx };
      axy = new HashMap();
      i[] arrayOfi = values();
      int j = arrayOfi.length;
      while (i < j)
      {
        i locali = arrayOfi[i];
        if (locali != axx)
        {
          String str = locali.name().replace('_', '-');
          axy.put(str, locali);
        }
        i += 1;
      }
      AppMethodBeat.o(201521);
    }
    
    private i() {}
    
    public static i Y(String paramString)
    {
      AppMethodBeat.i(201511);
      paramString = (i)axy.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(201511);
        return paramString;
      }
      paramString = axx;
      AppMethodBeat.o(201511);
      return paramString;
    }
  }
  
  static final class j
    implements b.f
  {
    List<b.r> axA;
    
    j(List<b.r> paramList)
    {
      this.axA = paramList;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(201525);
      Iterator localIterator = this.axA.iterator();
      while (localIterator.hasNext()) {
        if (b.a(paramp, (b.r)localIterator.next(), paramal))
        {
          AppMethodBeat.o(201525);
          return false;
        }
      }
      AppMethodBeat.o(201525);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201530);
      String str = "not(" + this.axA + ")";
      AppMethodBeat.o(201530);
      return str;
    }
  }
  
  static final class k
    implements b.f
  {
    private String axB;
    
    k(String paramString)
    {
      this.axB = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      return false;
    }
    
    public final String toString()
    {
      return this.axB;
    }
  }
  
  static final class l
    implements b.f
  {
    private boolean awX;
    private String awY;
    
    public l(boolean paramBoolean, String paramString)
    {
      this.awX = paramBoolean;
      this.awY = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(201540);
      label48:
      int j;
      if ((this.awX) && (this.awY == null))
      {
        paramp = paramal.om();
        if (paramal.aBj == null) {
          break label105;
        }
        paramal = paramal.aBj.oq().iterator();
        int i = 0;
        j = i;
        if (!paramal.hasNext()) {
          break label108;
        }
        h.al localal = (h.al)paramal.next();
        if ((paramp != null) && (!localal.om().equals(paramp))) {
          break label128;
        }
        i += 1;
      }
      label128:
      for (;;)
      {
        break label48;
        paramp = this.awY;
        break;
        label105:
        j = 1;
        label108:
        if (j == 1)
        {
          AppMethodBeat.o(201540);
          return true;
        }
        AppMethodBeat.o(201540);
        return false;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201545);
      if (this.awX)
      {
        str = String.format("only-of-type <%s>", new Object[] { this.awY });
        AppMethodBeat.o(201545);
        return str;
      }
      String str = String.format("only-child", new Object[0]);
      AppMethodBeat.o(201545);
      return str;
    }
  }
  
  static final class m
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      return paramal.aBj == null;
    }
    
    public final String toString()
    {
      return "root";
    }
  }
  
  static final class n
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramp != null)
      {
        bool1 = bool2;
        if (paramal == paramp.axE) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public final String toString()
    {
      return "target";
    }
  }
  
  static final class o
  {
    b.t aww;
    b.r axC = null;
    h.ae axD = null;
    
    o(b.r paramr, h.ae paramae, b.t paramt)
    {
      this.axC = paramr;
      this.axD = paramae;
      this.aww = paramt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201566);
      String str = String.valueOf(this.axC) + " {...} (src=" + this.aww + ")";
      AppMethodBeat.o(201566);
      return str;
    }
  }
  
  static final class p
  {
    h.al axE;
    
    public final String toString()
    {
      AppMethodBeat.i(201571);
      if (this.axE != null)
      {
        String str = String.format("<%s id=\"%s\">", new Object[] { this.axE.om(), this.axE.id });
        AppMethodBeat.o(201571);
        return str;
      }
      AppMethodBeat.o(201571);
      return "";
    }
  }
  
  static final class q
  {
    List<b.o> axF = null;
    
    final void a(b.o paramo)
    {
      AppMethodBeat.i(201578);
      if (this.axF == null) {
        this.axF = new ArrayList();
      }
      int i = 0;
      while (i < this.axF.size())
      {
        if (((b.o)this.axF.get(i)).axC.axH > paramo.axC.axH)
        {
          this.axF.add(i, paramo);
          AppMethodBeat.o(201578);
          return;
        }
        i += 1;
      }
      this.axF.add(paramo);
      AppMethodBeat.o(201578);
    }
    
    final void a(q paramq)
    {
      AppMethodBeat.i(201584);
      if (paramq.axF == null)
      {
        AppMethodBeat.o(201584);
        return;
      }
      if (this.axF == null) {
        this.axF = new ArrayList(paramq.axF.size());
      }
      paramq = paramq.axF.iterator();
      while (paramq.hasNext()) {
        a((b.o)paramq.next());
      }
      AppMethodBeat.o(201584);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201589);
      if (this.axF == null)
      {
        AppMethodBeat.o(201589);
        return "";
      }
      Object localObject = new StringBuilder();
      Iterator localIterator = this.axF.iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((b.o)localIterator.next()).toString()).append('\n');
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(201589);
      return localObject;
    }
  }
  
  static final class r
  {
    List<b.s> axG = null;
    int axH = 0;
    
    final b.s dF(int paramInt)
    {
      AppMethodBeat.i(201592);
      b.s locals = (b.s)this.axG.get(paramInt);
      AppMethodBeat.o(201592);
      return locals;
    }
    
    final boolean isEmpty()
    {
      AppMethodBeat.i(201595);
      if ((this.axG == null) || (this.axG.isEmpty()))
      {
        AppMethodBeat.o(201595);
        return true;
      }
      AppMethodBeat.o(201595);
      return false;
    }
    
    final void oa()
    {
      this.axH += 1000;
    }
    
    final int size()
    {
      AppMethodBeat.i(201591);
      if (this.axG == null)
      {
        AppMethodBeat.o(201591);
        return 0;
      }
      int i = this.axG.size();
      AppMethodBeat.o(201591);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201601);
      Object localObject = new StringBuilder();
      Iterator localIterator = this.axG.iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append((b.s)localIterator.next()).append(' ');
      }
      localObject = '[' + this.axH + ']';
      AppMethodBeat.o(201601);
      return localObject;
    }
  }
  
  static final class s
  {
    b.d axI;
    List<b.a> axJ;
    List<b.f> axK;
    String tag;
    
    s(b.d paramd, String paramString)
    {
      AppMethodBeat.i(201610);
      this.axI = null;
      this.tag = null;
      this.axJ = null;
      this.axK = null;
      if (paramd != null) {}
      for (;;)
      {
        this.axI = paramd;
        this.tag = paramString;
        AppMethodBeat.o(201610);
        return;
        paramd = b.d.awG;
      }
    }
    
    final void a(String paramString1, b.b paramb, String paramString2)
    {
      AppMethodBeat.i(201613);
      if (this.axJ == null) {
        this.axJ = new ArrayList();
      }
      this.axJ.add(new b.a(paramString1, paramb, paramString2));
      AppMethodBeat.o(201613);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201620);
      StringBuilder localStringBuilder = new StringBuilder();
      label40:
      label63:
      Object localObject2;
      if (this.axI == b.d.awH)
      {
        localStringBuilder.append("> ");
        if (this.tag != null) {
          break label162;
        }
        localObject1 = "*";
        localStringBuilder.append((String)localObject1);
        if (this.axJ == null) {
          break label221;
        }
        localObject1 = this.axJ.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label221;
        }
        localObject2 = (b.a)((Iterator)localObject1).next();
        localStringBuilder.append('[').append(((b.a)localObject2).name);
        switch (b.1.awy[localObject2.awA.ordinal()])
        {
        }
      }
      for (;;)
      {
        localStringBuilder.append(']');
        break label63;
        if (this.axI != b.d.awI) {
          break;
        }
        localStringBuilder.append("+ ");
        break;
        label162:
        localObject1 = this.tag;
        break label40;
        localStringBuilder.append('=').append(((b.a)localObject2).value);
        continue;
        localStringBuilder.append("~=").append(((b.a)localObject2).value);
        continue;
        localStringBuilder.append("|=").append(((b.a)localObject2).value);
      }
      label221:
      if (this.axK != null)
      {
        localObject1 = this.axK.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (b.f)((Iterator)localObject1).next();
          localStringBuilder.append(':').append(localObject2);
        }
      }
      Object localObject1 = localStringBuilder.toString();
      AppMethodBeat.o(201620);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.a.a.b
 * JD-Core Version:    0.7.0.1
 */