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
  private b.e csj = null;
  private b.t csk = null;
  private boolean csl = false;
  
  b()
  {
    this(b.e.csF, b.t.ctA);
  }
  
  b(b.e parame, b.t paramt)
  {
    this.csj = parame;
    this.csk = paramt;
  }
  
  private static int a(List<h.aj> paramList, int paramInt, h.al paramal)
  {
    AppMethodBeat.i(207869);
    if (paramInt < 0)
    {
      AppMethodBeat.o(207869);
      return 0;
    }
    if (paramList.get(paramInt) != paramal.cwZ)
    {
      AppMethodBeat.o(207869);
      return -1;
    }
    paramList = paramal.cwZ.NZ().iterator();
    paramInt = 0;
    while (paramList.hasNext())
    {
      if ((h.an)paramList.next() == paramal)
      {
        AppMethodBeat.o(207869);
        return paramInt;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(207869);
    return -1;
  }
  
  private static List<b.e> a(c paramc)
  {
    AppMethodBeat.i(207796);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str;
      if (!paramc.empty())
      {
        str = paramc.OI();
        if (str == null) {}
      }
      try
      {
        localArrayList.add(b.e.valueOf(str));
        label38:
        if (paramc.OA()) {
          continue;
        }
        AppMethodBeat.o(207796);
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
    AppMethodBeat.i(207859);
    int i = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    h.al localal;
    for (;;)
    {
      s locals = paramr.gZ(paramInt2);
      localal = (h.al)paramList.get(paramInt1);
      if (!a(paramp, locals, localal))
      {
        AppMethodBeat.o(207859);
        return false;
      }
      if (locals.ctw == d.csu)
      {
        if (paramInt2 == 0)
        {
          AppMethodBeat.o(207859);
          return true;
        }
        while (paramInt1 > 0)
        {
          i = paramInt1 - 1;
          paramInt1 = i;
          if (a(paramp, paramr, paramInt2 - 1, paramList, i))
          {
            AppMethodBeat.o(207859);
            return true;
          }
        }
        AppMethodBeat.o(207859);
        return false;
      }
      if (locals.ctw != d.csv) {
        break;
      }
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    i = a(paramList, paramInt1, localal);
    if (i <= 0)
    {
      AppMethodBeat.o(207859);
      return false;
    }
    boolean bool = a(paramp, paramr, paramInt2 - 1, paramList, paramInt1, (h.al)localal.cwZ.NZ().get(i - 1));
    AppMethodBeat.o(207859);
    return bool;
  }
  
  private static boolean a(p paramp, r paramr, int paramInt1, List<h.aj> paramList, int paramInt2, h.al paramal)
  {
    AppMethodBeat.i(207851);
    for (;;)
    {
      s locals = paramr.gZ(paramInt1);
      if (!a(paramp, locals, paramal))
      {
        AppMethodBeat.o(207851);
        return false;
      }
      if (locals.ctw == d.csu)
      {
        if (paramInt1 == 0)
        {
          AppMethodBeat.o(207851);
          return true;
        }
        do
        {
          paramInt2 -= 1;
          if (paramInt2 < 0) {
            break;
          }
        } while (!a(paramp, paramr, paramInt1 - 1, paramList, paramInt2));
        AppMethodBeat.o(207851);
        return true;
        AppMethodBeat.o(207851);
        return false;
      }
      if (locals.ctw == d.csv)
      {
        boolean bool = a(paramp, paramr, paramInt1 - 1, paramList, paramInt2);
        AppMethodBeat.o(207851);
        return bool;
      }
      int i = a(paramList, paramInt2, paramal);
      if (i <= 0)
      {
        AppMethodBeat.o(207851);
        return false;
      }
      paramal = (h.al)paramal.cwZ.NZ().get(i - 1);
      paramInt1 -= 1;
    }
  }
  
  static boolean a(p paramp, r paramr, h.al paramal)
  {
    AppMethodBeat.i(207842);
    ArrayList localArrayList = new ArrayList();
    for (h.aj localaj = paramal.cwZ; localaj != null; localaj = ((h.an)localaj).cwZ) {
      localArrayList.add(0, localaj);
    }
    int i = localArrayList.size();
    if (paramr.size() == 1)
    {
      bool = a(paramp, paramr.gZ(0), paramal);
      AppMethodBeat.o(207842);
      return bool;
    }
    boolean bool = a(paramp, paramr, paramr.size() - 1, localArrayList, i - 1, paramal);
    AppMethodBeat.o(207842);
    return bool;
  }
  
  private static boolean a(p paramp, s params, h.al paramal)
  {
    AppMethodBeat.i(207881);
    if ((params.tag != null) && (!params.tag.equals(paramal.NV().toLowerCase(Locale.US))))
    {
      AppMethodBeat.o(207881);
      return false;
    }
    if (params.cty != null)
    {
      Iterator localIterator = params.cty.iterator();
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
            AppMethodBeat.o(207881);
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
          AppMethodBeat.o(207881);
          return false;
          if (paramal.cwX == null)
          {
            AppMethodBeat.o(207881);
            return false;
          }
          if (!paramal.cwX.contains(locala.value))
          {
            AppMethodBeat.o(207881);
            return false;
          }
        }
      }
    }
    if (params.ctz != null)
    {
      params = params.ctz.iterator();
      while (params.hasNext()) {
        if (!((f)params.next()).a(paramp, paramal))
        {
          AppMethodBeat.o(207881);
          return false;
        }
      }
    }
    AppMethodBeat.o(207881);
    return true;
  }
  
  private boolean a(q paramq, c paramc)
  {
    AppMethodBeat.i(207824);
    List localList = paramc.NG();
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (!paramc.c('{'))
      {
        paramq = new a("Malformed rule block: expected '{'");
        AppMethodBeat.o(207824);
        throw paramq;
      }
      paramc.Oz();
      h.ae localae = new h.ae();
      do
      {
        String str1 = paramc.NE();
        paramc.Oz();
        if (!paramc.c(':'))
        {
          paramq = new a("Expected ':'");
          AppMethodBeat.o(207824);
          throw paramq;
        }
        paramc.Oz();
        String str2 = paramc.NH();
        if (str2 == null)
        {
          paramq = new a("Expected property value");
          AppMethodBeat.o(207824);
          throw paramq;
        }
        paramc.Oz();
        if (paramc.c('!'))
        {
          paramc.Oz();
          if (!paramc.cc("important"))
          {
            paramq = new a("Malformed rule set: found unexpected '!'");
            AppMethodBeat.o(207824);
            throw paramq;
          }
          paramc.Oz();
        }
        paramc.c(';');
        l.a(localae, str1, str2);
        paramc.Oz();
      } while ((!paramc.empty()) && (!paramc.c('}')));
      paramc.Oz();
      paramc = localList.iterator();
      while (paramc.hasNext()) {
        paramq.a(new o((r)paramc.next(), localae, this.csk));
      }
      AppMethodBeat.o(207824);
      return true;
    }
    AppMethodBeat.o(207824);
    return false;
  }
  
  static boolean a(String paramString, b.e parame)
  {
    AppMethodBeat.i(207787);
    paramString = new c(paramString);
    paramString.Oz();
    boolean bool = a(a(paramString), parame);
    AppMethodBeat.o(207787);
    return bool;
  }
  
  private static boolean a(List<b.e> paramList, b.e parame)
  {
    AppMethodBeat.i(207793);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.e locale = (b.e)paramList.next();
      if ((locale == b.e.csy) || (locale == parame))
      {
        AppMethodBeat.o(207793);
        return true;
      }
    }
    AppMethodBeat.o(207793);
    return false;
  }
  
  private static void b(c paramc)
  {
    AppMethodBeat.i(207805);
    int i = 0;
    while (!paramc.empty())
    {
      int j = paramc.OD().intValue();
      if ((j == 59) && (i == 0))
      {
        AppMethodBeat.o(207805);
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
          AppMethodBeat.o(207805);
          return;
        }
      }
    }
    AppMethodBeat.o(207805);
  }
  
  public static List<String> bk(String paramString)
  {
    AppMethodBeat.i(207832);
    c localc = new c(paramString);
    paramString = null;
    while (!localc.empty())
    {
      String str = localc.b(' ', false);
      if (str != null)
      {
        Object localObject = paramString;
        if (paramString == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(str);
        localc.Oz();
        paramString = (String)localObject;
      }
    }
    AppMethodBeat.o(207832);
    return paramString;
  }
  
  private q c(c paramc)
  {
    AppMethodBeat.i(207814);
    q localq = new q();
    Object localObject1;
    try
    {
      while (!paramc.empty()) {
        if ((!paramc.cc("<!--")) && (!paramc.cc("-->")))
        {
          if (!paramc.c('@')) {
            break label744;
          }
          localObject1 = paramc.NE();
          paramc.Oz();
          if (localObject1 != null) {
            break label113;
          }
          paramc = new a("Invalid '@' rule");
          AppMethodBeat.o(207814);
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
      AppMethodBeat.o(207814);
      return localq;
      label113:
      if ((!this.csl) && (((String)localObject1).equals("media")))
      {
        localObject1 = a(paramc);
        if (!paramc.c('{'))
        {
          paramc = new a("Invalid @media rule: missing rule set");
          AppMethodBeat.o(207814);
          throw paramc;
        }
        paramc.Oz();
        if (a((List)localObject1, this.csj))
        {
          this.csl = true;
          localq.a(c(paramc));
          this.csl = false;
        }
      }
      for (;;)
      {
        if ((!paramc.empty()) && (!paramc.c('}')))
        {
          paramc = new a("Invalid @media rule: expected '}' at end of rule set");
          AppMethodBeat.o(207814);
          throw paramc;
          c(paramc);
          continue;
          if ((!this.csl) && (((String)localObject1).equals("import")))
          {
            if (paramc.empty()) {}
            int k;
            for (localObject1 = null;; localObject1 = null)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = paramc.NI();
              }
              if (localObject2 != null) {
                break label647;
              }
              paramc = new a("Invalid @import rule: expected string or url()");
              AppMethodBeat.o(207814);
              throw paramc;
              k = paramc.position;
              if (paramc.cc("url(")) {
                break;
              }
            }
            paramc.Oz();
            localObject1 = paramc.NI();
            Object localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject1 = new StringBuilder();
              while (!paramc.empty())
              {
                int j = paramc.input.charAt(paramc.position);
                if ((j == 39) || (j == 34) || (j == 40) || (j == 41) || (c.hb(j)) || (Character.isISOControl(j))) {
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
                  j = c.gY(i);
                  if (j != -1)
                  {
                    i = 1;
                    while ((i <= 5) && (!paramc.empty()))
                    {
                      int m = c.gY(paramc.input.charAt(paramc.position));
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
                paramc.Oz();
                localObject1 = localObject2;
                if (paramc.empty()) {
                  break;
                }
                localObject1 = localObject2;
                if (paramc.cc(")")) {
                  break;
                }
              }
              paramc.position = k;
              localObject1 = null;
              break;
            }
            label647:
            paramc.Oz();
            localObject1 = a(paramc);
            if ((!paramc.empty()) && (!paramc.c(';')))
            {
              paramc = new a("Invalid @media rule: expected '}' at end of rule set");
              AppMethodBeat.o(207814);
              throw paramc;
            }
            if ((h.NU() == null) || (!a((List)localObject1, this.csj))) {
              break label737;
            }
            h.NU();
            break;
          }
          String.format("Ignoring @%s rule", new Object[] { localObject1 });
          b(paramc);
        }
      }
      label737:
      paramc.Oz();
      break;
      label744:
      boolean bool = a(localq, paramc);
      if (bool) {
        break;
      }
    }
  }
  
  final q bj(String paramString)
  {
    AppMethodBeat.i(207903);
    paramString = new c(paramString);
    paramString.Oz();
    paramString = c(paramString);
    AppMethodBeat.o(207903);
    return paramString;
  }
  
  static final class a
  {
    final b.b cso;
    public final String name;
    public final String value;
    
    a(String paramString1, b.b paramb, String paramString2)
    {
      this.name = paramString1;
      this.cso = paramb;
      this.value = paramString2;
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(207791);
      csp = new b("EXISTS", 0);
      csq = new b("EQUALS", 1);
      csr = new b("INCLUDES", 2);
      css = new b("DASHMATCH", 3);
      cst = new b[] { csp, csq, csr, css };
      AppMethodBeat.o(207791);
    }
    
    private b() {}
  }
  
  static final class c
    extends l.h
  {
    c(String paramString)
    {
      super();
      AppMethodBeat.i(207795);
      AppMethodBeat.o(207795);
    }
    
    private int NF()
    {
      AppMethodBeat.i(207799);
      if (empty())
      {
        i = this.position;
        AppMethodBeat.o(207799);
        return i;
      }
      int m = this.position;
      int j = this.position;
      int k = this.input.charAt(this.position);
      int i = k;
      if (k == 45) {
        i = OG();
      }
      if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || (i == 95))
      {
        for (i = OG(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || ((i >= 48) && (i <= 57)) || (i == 45) || (i == 95); i = OG()) {}
        j = this.position;
      }
      this.position = m;
      AppMethodBeat.o(207799);
      return j;
    }
    
    private boolean a(b.r paramr)
    {
      AppMethodBeat.i(207823);
      if (empty())
      {
        AppMethodBeat.o(207823);
        return false;
      }
      int m = this.position;
      b.d locald;
      if (!paramr.isEmpty()) {
        if (c('>'))
        {
          locald = b.d.csv;
          Oz();
        }
      }
      for (;;)
      {
        Object localObject1;
        if (c('*')) {
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
            if (c('.'))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new b.s(locald, null);
              }
              localObject1 = NE();
              if (localObject1 == null)
              {
                paramr = new a("Invalid \".class\" simpleSelectors");
                AppMethodBeat.o(207823);
                throw paramr;
                if (!c('+')) {
                  break label2012;
                }
                locald = b.d.csw;
                Oz();
                break;
                localObject1 = NE();
                if (localObject1 == null) {
                  break label2006;
                }
                localObject1 = new b.s(locald, (String)localObject1);
                paramr.ctv += 1;
                continue;
              }
              ((b.s)localObject2).a("class", b.b.csq, (String)localObject1);
              paramr.NJ();
              localObject1 = localObject2;
              continue;
            }
            if (c('#'))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new b.s(locald, null);
              }
              localObject1 = NE();
              if (localObject1 == null)
              {
                paramr = new a("Invalid \"#id\" simpleSelectors");
                AppMethodBeat.o(207823);
                throw paramr;
              }
              ((b.s)localObject2).a("id", b.b.csq, (String)localObject1);
              paramr.ctv += 1000000;
              localObject1 = localObject2;
              continue;
            }
            if (c('['))
            {
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = new b.s(locald, null);
              }
              Oz();
              str = NE();
              localObject2 = null;
              if (str == null)
              {
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(207823);
                throw paramr;
              }
              Oz();
              localObject1 = null;
              if (c('='))
              {
                localObject1 = b.b.csq;
                if (localObject1 == null) {
                  break label494;
                }
                Oz();
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
                AppMethodBeat.o(207823);
                throw paramr;
                if (cc("~="))
                {
                  localObject1 = b.b.csr;
                  break;
                }
                if (!cc("|=")) {
                  break;
                }
                localObject1 = b.b.css;
                break;
                localObject4 = ON();
                localObject2 = localObject4;
                if (localObject4 == null) {
                  localObject2 = NE();
                }
              }
              label490:
              Oz();
              label494:
              if (!c(']'))
              {
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(207823);
                throw paramr;
              }
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = b.b.csp;
              }
              ((b.s)localObject3).a(str, (b.b)localObject4, (String)localObject2);
              paramr.NJ();
              localObject1 = localObject3;
              continue;
            }
            if (c(':')) {
              if (localObject1 != null) {
                break label1999;
              }
            }
          }
          label1099:
          label1999:
          for (Object localObject2 = new b.s(locald, null);; localObject2 = localObject1)
          {
            str = NE();
            if (str == null)
            {
              paramr = new a("Invalid pseudo class");
              AppMethodBeat.o(207823);
              throw paramr;
            }
            localObject1 = b.i.bl(str);
            boolean bool1;
            boolean bool2;
            label1002:
            label1012:
            int n;
            label1138:
            int k;
            int j;
            int i;
            switch (b.1.csn[localObject1.ordinal()])
            {
            default: 
              paramr = new a("Unsupported pseudo class: ".concat(String.valueOf(str)));
              AppMethodBeat.o(207823);
              throw paramr;
            case 1: 
              localObject1 = new b.g(0, 1, true, false, null);
              paramr.NJ();
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
              for (;;)
              {
                if (((b.s)localObject2).ctz == null) {
                  ((b.s)localObject2).ctz = new ArrayList();
                }
                ((b.s)localObject2).ctz.add(localObject1);
                localObject1 = localObject2;
                break;
                localObject1 = new b.g(0, 1, false, false, null);
                paramr.NJ();
                continue;
                localObject1 = new b.l(false, null);
                paramr.NJ();
                continue;
                localObject1 = new b.g(0, 1, true, true, ((b.s)localObject2).tag);
                paramr.NJ();
                continue;
                localObject1 = new b.g(0, 1, false, true, ((b.s)localObject2).tag);
                paramr.NJ();
                continue;
                localObject1 = new b.l(true, ((b.s)localObject2).tag);
                paramr.NJ();
                continue;
                localObject1 = new b.m((byte)0);
                paramr.NJ();
                continue;
                localObject1 = new b.h((byte)0);
                paramr.NJ();
              }
            case 9: 
            case 10: 
            case 11: 
            case 12: 
              if ((localObject1 == b.i.csP) || (localObject1 == b.i.csR))
              {
                bool1 = true;
                if ((localObject1 != b.i.csR) && (localObject1 != b.i.csS)) {
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
                  AppMethodBeat.o(207823);
                  throw paramr;
                  bool1 = false;
                  break;
                  bool2 = false;
                  break label1002;
                  n = this.position;
                  if (!c('('))
                  {
                    localObject1 = null;
                  }
                  else
                  {
                    Oz();
                    if (cc("odd")) {}
                    for (localObject1 = new a(2, 1);; localObject1 = new a(2, 0))
                    {
                      Oz();
                      if (!c(')')) {
                        break label1409;
                      }
                      break;
                      if (!cc("even")) {
                        break label1138;
                      }
                    }
                    k = 1;
                    j = 1;
                    i = j;
                    if (!c('+'))
                    {
                      i = j;
                      if (c('-')) {
                        i = -1;
                      }
                    }
                    localObject3 = null;
                    localObject1 = d.i(this.input, this.position, this.cAH);
                    if (localObject1 != null) {
                      this.position = ((d)localObject1).pos;
                    }
                    if ((!c('n')) && (!c('N'))) {
                      break label1991;
                    }
                    if (localObject1 != null)
                    {
                      localObject4 = null;
                      k = 1;
                      Oz();
                      boolean bool4 = c('+');
                      boolean bool3 = bool4;
                      j = k;
                      if (!bool4)
                      {
                        bool4 = c('-');
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
                      Oz();
                      localObject4 = d.i(this.input, this.position, this.cAH);
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
              paramr.NJ();
              break;
              if (empty()) {
                localObject1 = null;
              }
              while (localObject1 == null)
              {
                paramr = new a("Invalid or missing parameter section for pseudo class: ".concat(String.valueOf(str)));
                AppMethodBeat.o(207823);
                throw paramr;
                i = this.position;
                if (!c('('))
                {
                  localObject1 = null;
                }
                else
                {
                  Oz();
                  localObject1 = NG();
                  if (localObject1 == null)
                  {
                    this.position = i;
                    localObject1 = null;
                  }
                  else if (!c(')'))
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
                            if (((b.r)localObject4).ctu == null) {
                              break label1687;
                            }
                            localObject4 = ((b.r)localObject4).ctu.iterator();
                            break;
                          } while (!((Iterator)localObject4).hasNext());
                          localObject5 = (b.s)((Iterator)localObject4).next();
                        } while (((b.s)localObject5).ctz == null);
                        localObject5 = ((b.s)localObject5).ctz.iterator();
                      } while (!((Iterator)localObject5).hasNext());
                    } while (!((b.f)((Iterator)localObject5).next() instanceof b.j));
                    localObject1 = null;
                  }
                }
              }
              localObject1 = new b.j((List)localObject1);
              localObject3 = (b.j)localObject1;
              i = -2147483648;
              localObject3 = ((b.j)localObject3).cto.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (b.r)((Iterator)localObject3).next();
                if (((b.r)localObject4).ctv <= i) {
                  break label1977;
                }
                i = ((b.r)localObject4).ctv;
              }
              for (;;)
              {
                break label1724;
                paramr.ctv = i;
                break;
                localObject1 = new b.n((byte)0);
                paramr.NJ();
                break;
                if (empty()) {}
                for (;;)
                {
                  localObject1 = new b.k(str);
                  paramr.NJ();
                  break;
                  i = this.position;
                  localObject1 = null;
                  if (c('('))
                  {
                    Oz();
                    do
                    {
                      localObject4 = NE();
                      if (localObject4 == null) {
                        break;
                      }
                      localObject3 = localObject1;
                      if (localObject1 == null) {
                        localObject3 = new ArrayList();
                      }
                      ((ArrayList)localObject3).add(localObject4);
                      Oz();
                      localObject1 = localObject3;
                    } while (OA());
                    if (!c(')')) {
                      this.position = i;
                    }
                  }
                }
                localObject1 = new b.k(str);
                paramr.NJ();
                break;
                if (localObject1 != null)
                {
                  if (paramr.ctu == null) {
                    paramr.ctu = new ArrayList();
                  }
                  paramr.ctu.add(localObject1);
                  AppMethodBeat.o(207823);
                  return true;
                }
                this.position = m;
                AppMethodBeat.o(207823);
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
    
    static int gY(int paramInt)
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
    
    final String NE()
    {
      AppMethodBeat.i(207839);
      int i = NF();
      if (i == this.position)
      {
        AppMethodBeat.o(207839);
        return null;
      }
      String str = this.input.substring(this.position, i);
      this.position = i;
      AppMethodBeat.o(207839);
      return str;
    }
    
    final List<b.r> NG()
    {
      AppMethodBeat.i(207850);
      if (empty())
      {
        AppMethodBeat.o(207850);
        return null;
      }
      ArrayList localArrayList = new ArrayList(1);
      b.r localr = new b.r((byte)0);
      while ((!empty()) && (a(localr))) {
        if (OA())
        {
          localArrayList.add(localr);
          localr = new b.r((byte)0);
        }
      }
      if (!localr.isEmpty()) {
        localArrayList.add(localr);
      }
      AppMethodBeat.o(207850);
      return localArrayList;
    }
    
    final String NH()
    {
      AppMethodBeat.i(207858);
      if (empty())
      {
        AppMethodBeat.o(207858);
        return null;
      }
      int k = this.position;
      int j = this.position;
      for (int i = this.input.charAt(this.position); (i != -1) && (i != 59) && (i != 125) && (i != 33) && (!hc(i)); i = OG()) {
        if (!hb(i)) {
          j = this.position + 1;
        }
      }
      if (this.position > k)
      {
        String str = this.input.substring(k, j);
        AppMethodBeat.o(207858);
        return str;
      }
      this.position = k;
      AppMethodBeat.o(207858);
      return null;
    }
    
    final String NI()
    {
      AppMethodBeat.i(207868);
      if (empty())
      {
        AppMethodBeat.o(207868);
        return null;
      }
      int n = this.input.charAt(this.position);
      if ((n != 39) && (n != 34))
      {
        AppMethodBeat.o(207868);
        return null;
      }
      Object localObject = new StringBuilder();
      this.position += 1;
      int i = OD().intValue();
      while ((i != -1) && (i != n))
      {
        int k = i;
        if (i == 92)
        {
          int j = OD().intValue();
          i = j;
          if (j == -1) {
            continue;
          }
          if ((j == 10) || (j == 13) || (j == 12))
          {
            i = OD().intValue();
            continue;
          }
          int m = gY(j);
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
              j = OD().intValue();
              int i1 = gY(j);
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
        i = OD().intValue();
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(207868);
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
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(207792);
      csu = new d("DESCENDANT", 0);
      csv = new d("CHILD", 1);
      csw = new d("FOLLOWS", 2);
      csx = new d[] { csu, csv, csw };
      AppMethodBeat.o(207792);
    }
    
    private d() {}
  }
  
  static abstract interface f
  {
    public abstract boolean a(b.p paramp, h.al paramal);
  }
  
  static final class g
    implements b.f
  {
    private int a;
    private int b;
    private boolean csK;
    private boolean csL;
    private String csM;
    
    g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.csK = paramBoolean1;
      this.csL = paramBoolean2;
      this.csM = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(207835);
      int i;
      label52:
      int m;
      int k;
      if ((this.csL) && (this.csM == null))
      {
        paramp = paramal.NV();
        if (paramal.cwZ == null) {
          break label124;
        }
        Iterator localIterator = paramal.cwZ.NZ().iterator();
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
        if ((paramp != null) && (!localal.NV().equals(paramp))) {
          break label239;
        }
        i += 1;
      }
      label130:
      label239:
      for (;;)
      {
        break label52;
        paramp = this.csM;
        break;
        label124:
        m = 1;
        k = 0;
        if (this.csK) {
          i = k + 1;
        }
        while (this.a == 0) {
          if (i == this.b)
          {
            AppMethodBeat.o(207835);
            return true;
            i = m - k;
          }
          else
          {
            AppMethodBeat.o(207835);
            return false;
          }
        }
        if (((i - this.b) % this.a == 0) && ((Integer.signum(i - this.b) == 0) || (Integer.signum(i - this.b) == Integer.signum(this.a))))
        {
          AppMethodBeat.o(207835);
          return true;
        }
        AppMethodBeat.o(207835);
        return false;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207847);
      if (this.csK) {}
      for (String str = ""; this.csL; str = "last-")
      {
        str = String.format("nth-%schild(%dn%+d of type <%s>)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.csM });
        AppMethodBeat.o(207847);
        return str;
      }
      str = String.format("nth-%schild(%dn%+d)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b) });
      AppMethodBeat.o(207847);
      return str;
    }
  }
  
  static final class h
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(207834);
      if ((paramal instanceof h.aj))
      {
        if (((h.aj)paramal).NZ().size() == 0)
        {
          AppMethodBeat.o(207834);
          return true;
        }
        AppMethodBeat.o(207834);
        return false;
      }
      AppMethodBeat.o(207834);
      return true;
    }
    
    public final String toString()
    {
      return "empty";
    }
  }
  
  static enum i
  {
    private static final Map<String, i> ctm;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(207875);
      csN = new i("target", 0);
      csO = new i("root", 1);
      csP = new i("nth_child", 2);
      csQ = new i("nth_last_child", 3);
      csR = new i("nth_of_type", 4);
      csS = new i("nth_last_of_type", 5);
      csT = new i("first_child", 6);
      csU = new i("last_child", 7);
      csV = new i("first_of_type", 8);
      csW = new i("last_of_type", 9);
      csX = new i("only_child", 10);
      csY = new i("only_of_type", 11);
      csZ = new i("empty", 12);
      cta = new i("not", 13);
      ctb = new i("lang", 14);
      ctc = new i("link", 15);
      ctd = new i("visited", 16);
      cte = new i("hover", 17);
      ctf = new i("active", 18);
      ctg = new i("focus", 19);
      cth = new i("enabled", 20);
      cti = new i("disabled", 21);
      ctj = new i("checked", 22);
      ctk = new i("indeterminate", 23);
      ctl = new i("UNSUPPORTED", 24);
      ctn = new i[] { csN, csO, csP, csQ, csR, csS, csT, csU, csV, csW, csX, csY, csZ, cta, ctb, ctc, ctd, cte, ctf, ctg, cth, cti, ctj, ctk, ctl };
      ctm = new HashMap();
      i[] arrayOfi = values();
      int j = arrayOfi.length;
      while (i < j)
      {
        i locali = arrayOfi[i];
        if (locali != ctl)
        {
          String str = locali.name().replace('_', '-');
          ctm.put(str, locali);
        }
        i += 1;
      }
      AppMethodBeat.o(207875);
    }
    
    private i() {}
    
    public static i bl(String paramString)
    {
      AppMethodBeat.i(207863);
      paramString = (i)ctm.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(207863);
        return paramString;
      }
      paramString = ctl;
      AppMethodBeat.o(207863);
      return paramString;
    }
  }
  
  static final class j
    implements b.f
  {
    List<b.r> cto;
    
    j(List<b.r> paramList)
    {
      this.cto = paramList;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(207837);
      Iterator localIterator = this.cto.iterator();
      while (localIterator.hasNext()) {
        if (b.a(paramp, (b.r)localIterator.next(), paramal))
        {
          AppMethodBeat.o(207837);
          return false;
        }
      }
      AppMethodBeat.o(207837);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207848);
      String str = "not(" + this.cto + ")";
      AppMethodBeat.o(207848);
      return str;
    }
  }
  
  static final class k
    implements b.f
  {
    private String ctp;
    
    k(String paramString)
    {
      this.ctp = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      return false;
    }
    
    public final String toString()
    {
      return this.ctp;
    }
  }
  
  static final class l
    implements b.f
  {
    private boolean csL;
    private String csM;
    
    public l(boolean paramBoolean, String paramString)
    {
      this.csL = paramBoolean;
      this.csM = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(207864);
      label48:
      int j;
      if ((this.csL) && (this.csM == null))
      {
        paramp = paramal.NV();
        if (paramal.cwZ == null) {
          break label105;
        }
        paramal = paramal.cwZ.NZ().iterator();
        int i = 0;
        j = i;
        if (!paramal.hasNext()) {
          break label108;
        }
        h.al localal = (h.al)paramal.next();
        if ((paramp != null) && (!localal.NV().equals(paramp))) {
          break label128;
        }
        i += 1;
      }
      label128:
      for (;;)
      {
        break label48;
        paramp = this.csM;
        break;
        label105:
        j = 1;
        label108:
        if (j == 1)
        {
          AppMethodBeat.o(207864);
          return true;
        }
        AppMethodBeat.o(207864);
        return false;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207876);
      if (this.csL)
      {
        str = String.format("only-of-type <%s>", new Object[] { this.csM });
        AppMethodBeat.o(207876);
        return str;
      }
      String str = String.format("only-child", new Object[0]);
      AppMethodBeat.o(207876);
      return str;
    }
  }
  
  static final class m
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      return paramal.cwZ == null;
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
        if (paramal == paramp.cts) {
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
    b.t csk;
    b.r ctq = null;
    h.ae ctr = null;
    
    o(b.r paramr, h.ae paramae, b.t paramt)
    {
      this.ctq = paramr;
      this.ctr = paramae;
      this.csk = paramt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207809);
      String str = String.valueOf(this.ctq) + " {...} (src=" + this.csk + ")";
      AppMethodBeat.o(207809);
      return str;
    }
  }
  
  static final class p
  {
    h.al cts;
    
    public final String toString()
    {
      AppMethodBeat.i(207806);
      if (this.cts != null)
      {
        String str = String.format("<%s id=\"%s\">", new Object[] { this.cts.NV(), this.cts.id });
        AppMethodBeat.o(207806);
        return str;
      }
      AppMethodBeat.o(207806);
      return "";
    }
  }
  
  static final class q
  {
    List<b.o> ctt = null;
    
    final void a(b.o paramo)
    {
      AppMethodBeat.i(207815);
      if (this.ctt == null) {
        this.ctt = new ArrayList();
      }
      int i = 0;
      while (i < this.ctt.size())
      {
        if (((b.o)this.ctt.get(i)).ctq.ctv > paramo.ctq.ctv)
        {
          this.ctt.add(i, paramo);
          AppMethodBeat.o(207815);
          return;
        }
        i += 1;
      }
      this.ctt.add(paramo);
      AppMethodBeat.o(207815);
    }
    
    final void a(q paramq)
    {
      AppMethodBeat.i(207827);
      if (paramq.ctt == null)
      {
        AppMethodBeat.o(207827);
        return;
      }
      if (this.ctt == null) {
        this.ctt = new ArrayList(paramq.ctt.size());
      }
      paramq = paramq.ctt.iterator();
      while (paramq.hasNext()) {
        a((b.o)paramq.next());
      }
      AppMethodBeat.o(207827);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207838);
      if (this.ctt == null)
      {
        AppMethodBeat.o(207838);
        return "";
      }
      Object localObject = new StringBuilder();
      Iterator localIterator = this.ctt.iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((b.o)localIterator.next()).toString()).append('\n');
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(207838);
      return localObject;
    }
  }
  
  static final class r
  {
    List<b.s> ctu = null;
    int ctv = 0;
    
    final void NJ()
    {
      this.ctv += 1000;
    }
    
    final b.s gZ(int paramInt)
    {
      AppMethodBeat.i(207852);
      b.s locals = (b.s)this.ctu.get(paramInt);
      AppMethodBeat.o(207852);
      return locals;
    }
    
    final boolean isEmpty()
    {
      AppMethodBeat.i(207862);
      if ((this.ctu == null) || (this.ctu.isEmpty()))
      {
        AppMethodBeat.o(207862);
        return true;
      }
      AppMethodBeat.o(207862);
      return false;
    }
    
    final int size()
    {
      AppMethodBeat.i(207840);
      if (this.ctu == null)
      {
        AppMethodBeat.o(207840);
        return 0;
      }
      int i = this.ctu.size();
      AppMethodBeat.o(207840);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207886);
      Object localObject = new StringBuilder();
      Iterator localIterator = this.ctu.iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append((b.s)localIterator.next()).append(' ');
      }
      localObject = '[' + this.ctv + ']';
      AppMethodBeat.o(207886);
      return localObject;
    }
  }
  
  static final class s
  {
    b.d ctw;
    List<b.a> cty;
    List<b.f> ctz;
    String tag;
    
    s(b.d paramd, String paramString)
    {
      AppMethodBeat.i(207812);
      this.ctw = null;
      this.tag = null;
      this.cty = null;
      this.ctz = null;
      if (paramd != null) {}
      for (;;)
      {
        this.ctw = paramd;
        this.tag = paramString;
        AppMethodBeat.o(207812);
        return;
        paramd = b.d.csu;
      }
    }
    
    final void a(String paramString1, b.b paramb, String paramString2)
    {
      AppMethodBeat.i(207818);
      if (this.cty == null) {
        this.cty = new ArrayList();
      }
      this.cty.add(new b.a(paramString1, paramb, paramString2));
      AppMethodBeat.o(207818);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207828);
      StringBuilder localStringBuilder = new StringBuilder();
      label40:
      label63:
      Object localObject2;
      if (this.ctw == b.d.csv)
      {
        localStringBuilder.append("> ");
        if (this.tag != null) {
          break label162;
        }
        localObject1 = "*";
        localStringBuilder.append((String)localObject1);
        if (this.cty == null) {
          break label221;
        }
        localObject1 = this.cty.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label221;
        }
        localObject2 = (b.a)((Iterator)localObject1).next();
        localStringBuilder.append('[').append(((b.a)localObject2).name);
        switch (b.1.csm[localObject2.cso.ordinal()])
        {
        }
      }
      for (;;)
      {
        localStringBuilder.append(']');
        break label63;
        if (this.ctw != b.d.csw) {
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
      if (this.ctz != null)
      {
        localObject1 = this.ctz.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (b.f)((Iterator)localObject1).next();
          localStringBuilder.append(':').append(localObject2);
        }
      }
      Object localObject1 = localStringBuilder.toString();
      AppMethodBeat.o(207828);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.a.a.b
 * JD-Core Version:    0.7.0.1
 */