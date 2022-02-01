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
  private b.e aOd = null;
  private b.t aOe = null;
  private boolean aOf = false;
  
  b()
  {
    this(b.e.aOz, b.t.aPs);
  }
  
  b(b.e parame, b.t paramt)
  {
    this.aOd = parame;
    this.aOe = paramt;
  }
  
  public static List<String> X(String paramString)
  {
    AppMethodBeat.i(206453);
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
        localc.rs();
        paramString = (String)localObject;
      }
    }
    AppMethodBeat.o(206453);
    return paramString;
  }
  
  private static int a(List<h.aj> paramList, int paramInt, h.al paramal)
  {
    AppMethodBeat.i(206457);
    if (paramInt < 0)
    {
      AppMethodBeat.o(206457);
      return 0;
    }
    if (paramList.get(paramInt) != paramal.aSP)
    {
      AppMethodBeat.o(206457);
      return -1;
    }
    paramList = paramal.aSP.getChildren().iterator();
    paramInt = 0;
    while (paramList.hasNext())
    {
      if ((h.an)paramList.next() == paramal)
      {
        AppMethodBeat.o(206457);
        return paramInt;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(206457);
    return -1;
  }
  
  private static List<b.e> a(c paramc)
  {
    AppMethodBeat.i(206449);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str;
      if (!paramc.empty())
      {
        str = paramc.rz();
        if (str == null) {}
      }
      try
      {
        localArrayList.add(b.e.valueOf(str));
        label38:
        if (paramc.rt()) {
          continue;
        }
        AppMethodBeat.o(206449);
        return localArrayList;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label38;
      }
    }
  }
  
  private static boolean a(p paramp, b.r paramr, int paramInt1, List<h.aj> paramList, int paramInt2)
  {
    AppMethodBeat.i(206456);
    int i = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    h.al localal;
    for (;;)
    {
      s locals = paramr.du(paramInt2);
      localal = (h.al)paramList.get(paramInt1);
      if (!a(paramp, locals, localal))
      {
        AppMethodBeat.o(206456);
        return false;
      }
      if (locals.aPp == b.d.aOo)
      {
        if (paramInt2 == 0)
        {
          AppMethodBeat.o(206456);
          return true;
        }
        while (paramInt1 > 0)
        {
          i = paramInt1 - 1;
          paramInt1 = i;
          if (a(paramp, paramr, paramInt2 - 1, paramList, i))
          {
            AppMethodBeat.o(206456);
            return true;
          }
        }
        AppMethodBeat.o(206456);
        return false;
      }
      if (locals.aPp != b.d.aOp) {
        break;
      }
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    i = a(paramList, paramInt1, localal);
    if (i <= 0)
    {
      AppMethodBeat.o(206456);
      return false;
    }
    boolean bool = a(paramp, paramr, paramInt2 - 1, paramList, paramInt1, (h.al)localal.aSP.getChildren().get(i - 1));
    AppMethodBeat.o(206456);
    return bool;
  }
  
  private static boolean a(p paramp, b.r paramr, int paramInt1, List<h.aj> paramList, int paramInt2, h.al paramal)
  {
    AppMethodBeat.i(206455);
    for (;;)
    {
      s locals = paramr.du(paramInt1);
      if (!a(paramp, locals, paramal))
      {
        AppMethodBeat.o(206455);
        return false;
      }
      if (locals.aPp == b.d.aOo)
      {
        if (paramInt1 == 0)
        {
          AppMethodBeat.o(206455);
          return true;
        }
        do
        {
          paramInt2 -= 1;
          if (paramInt2 < 0) {
            break;
          }
        } while (!a(paramp, paramr, paramInt1 - 1, paramList, paramInt2));
        AppMethodBeat.o(206455);
        return true;
        AppMethodBeat.o(206455);
        return false;
      }
      if (locals.aPp == b.d.aOp)
      {
        boolean bool = a(paramp, paramr, paramInt1 - 1, paramList, paramInt2);
        AppMethodBeat.o(206455);
        return bool;
      }
      int i = a(paramList, paramInt2, paramal);
      if (i <= 0)
      {
        AppMethodBeat.o(206455);
        return false;
      }
      paramal = (h.al)paramal.aSP.getChildren().get(i - 1);
      paramInt1 -= 1;
    }
  }
  
  static boolean a(p paramp, b.r paramr, h.al paramal)
  {
    AppMethodBeat.i(206454);
    ArrayList localArrayList = new ArrayList();
    for (h.aj localaj = paramal.aSP; localaj != null; localaj = ((h.an)localaj).aSP) {
      localArrayList.add(0, localaj);
    }
    int i = localArrayList.size();
    if (paramr.size() == 1)
    {
      bool = a(paramp, paramr.du(0), paramal);
      AppMethodBeat.o(206454);
      return bool;
    }
    boolean bool = a(paramp, paramr, paramr.size() - 1, localArrayList, i - 1, paramal);
    AppMethodBeat.o(206454);
    return bool;
  }
  
  private static boolean a(p paramp, s params, h.al paramal)
  {
    AppMethodBeat.i(206458);
    if ((params.tag != null) && (!params.tag.equals(paramal.getNodeName().toLowerCase(Locale.US))))
    {
      AppMethodBeat.o(206458);
      return false;
    }
    if (params.aPq != null)
    {
      Iterator localIterator = params.aPq.iterator();
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
            AppMethodBeat.o(206458);
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
          AppMethodBeat.o(206458);
          return false;
          if (paramal.aSN == null)
          {
            AppMethodBeat.o(206458);
            return false;
          }
          if (!paramal.aSN.contains(locala.value))
          {
            AppMethodBeat.o(206458);
            return false;
          }
        }
      }
    }
    if (params.aPr != null)
    {
      params = params.aPr.iterator();
      while (params.hasNext()) {
        if (!((f)params.next()).a(paramp, paramal))
        {
          AppMethodBeat.o(206458);
          return false;
        }
      }
    }
    AppMethodBeat.o(206458);
    return true;
  }
  
  private boolean a(b.q paramq, c paramc)
  {
    AppMethodBeat.i(206452);
    List localList = paramc.qC();
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (!paramc.b('{'))
      {
        paramq = new a("Malformed rule block: expected '{'");
        AppMethodBeat.o(206452);
        throw paramq;
      }
      paramc.rs();
      h.ae localae = new h.ae();
      do
      {
        String str1 = paramc.qA();
        paramc.rs();
        if (!paramc.b(':'))
        {
          paramq = new a("Expected ':'");
          AppMethodBeat.o(206452);
          throw paramq;
        }
        paramc.rs();
        String str2 = paramc.qD();
        if (str2 == null)
        {
          paramq = new a("Expected property value");
          AppMethodBeat.o(206452);
          throw paramq;
        }
        paramc.rs();
        if (paramc.b('!'))
        {
          paramc.rs();
          if (!paramc.aO("important"))
          {
            paramq = new a("Malformed rule set: found unexpected '!'");
            AppMethodBeat.o(206452);
            throw paramq;
          }
          paramc.rs();
        }
        paramc.b(';');
        l.a(localae, str1, str2);
        paramc.rs();
      } while ((!paramc.empty()) && (!paramc.b('}')));
      paramc.rs();
      paramc = localList.iterator();
      while (paramc.hasNext()) {
        paramq.a(new b.o((b.r)paramc.next(), localae, this.aOe));
      }
      AppMethodBeat.o(206452);
      return true;
    }
    AppMethodBeat.o(206452);
    return false;
  }
  
  static boolean a(String paramString, b.e parame)
  {
    AppMethodBeat.i(206447);
    paramString = new c(paramString);
    paramString.rs();
    boolean bool = a(a(paramString), parame);
    AppMethodBeat.o(206447);
    return bool;
  }
  
  private static boolean a(List<b.e> paramList, b.e parame)
  {
    AppMethodBeat.i(206448);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.e locale = (b.e)paramList.next();
      if ((locale == b.e.aOs) || (locale == parame))
      {
        AppMethodBeat.o(206448);
        return true;
      }
    }
    AppMethodBeat.o(206448);
    return false;
  }
  
  private static void b(c paramc)
  {
    AppMethodBeat.i(206450);
    int i = 0;
    while (!paramc.empty())
    {
      int j = paramc.rv().intValue();
      if ((j == 59) && (i == 0))
      {
        AppMethodBeat.o(206450);
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
          AppMethodBeat.o(206450);
          return;
        }
      }
    }
    AppMethodBeat.o(206450);
  }
  
  private b.q c(c paramc)
  {
    AppMethodBeat.i(206451);
    b.q localq = new b.q();
    Object localObject1;
    try
    {
      while (!paramc.empty()) {
        if ((!paramc.aO("<!--")) && (!paramc.aO("-->")))
        {
          if (!paramc.b('@')) {
            break label744;
          }
          localObject1 = paramc.qA();
          paramc.rs();
          if (localObject1 != null) {
            break label113;
          }
          paramc = new a("Invalid '@' rule");
          AppMethodBeat.o(206451);
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
      AppMethodBeat.o(206451);
      return localq;
      label113:
      if ((!this.aOf) && (((String)localObject1).equals("media")))
      {
        localObject1 = a(paramc);
        if (!paramc.b('{'))
        {
          paramc = new a("Invalid @media rule: missing rule set");
          AppMethodBeat.o(206451);
          throw paramc;
        }
        paramc.rs();
        if (a((List)localObject1, this.aOd))
        {
          this.aOf = true;
          localq.a(c(paramc));
          this.aOf = false;
        }
      }
      for (;;)
      {
        if ((!paramc.empty()) && (!paramc.b('}')))
        {
          paramc = new a("Invalid @media rule: expected '}' at end of rule set");
          AppMethodBeat.o(206451);
          throw paramc;
          c(paramc);
          continue;
          if ((!this.aOf) && (((String)localObject1).equals("import")))
          {
            if (paramc.empty()) {}
            int k;
            for (localObject1 = null;; localObject1 = null)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = paramc.qE();
              }
              if (localObject2 != null) {
                break label647;
              }
              paramc = new a("Invalid @import rule: expected string or url()");
              AppMethodBeat.o(206451);
              throw paramc;
              k = paramc.position;
              if (paramc.aO("url(")) {
                break;
              }
            }
            paramc.rs();
            localObject1 = paramc.qE();
            Object localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject1 = new StringBuilder();
              while (!paramc.empty())
              {
                int j = paramc.aWy.charAt(paramc.position);
                if ((j == 39) || (j == 34) || (j == 40) || (j == 41) || (c.isWhitespace(j)) || (Character.isISOControl(j))) {
                  break;
                }
                paramc.position += 1;
                int i = j;
                if (j == 92)
                {
                  if (paramc.empty()) {
                    continue;
                  }
                  localObject2 = paramc.aWy;
                  i = paramc.position;
                  paramc.position = (i + 1);
                  i = ((String)localObject2).charAt(i);
                  if ((i == 10) || (i == 13) || (i == 12)) {
                    continue;
                  }
                  j = c.dt(i);
                  if (j != -1)
                  {
                    i = 1;
                    while ((i <= 5) && (!paramc.empty()))
                    {
                      int m = c.dt(paramc.aWy.charAt(paramc.position));
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
                paramc.rs();
                localObject1 = localObject2;
                if (paramc.empty()) {
                  break;
                }
                localObject1 = localObject2;
                if (paramc.aO(")")) {
                  break;
                }
              }
              paramc.position = k;
              localObject1 = null;
              break;
            }
            label647:
            paramc.rs();
            localObject1 = a(paramc);
            if ((!paramc.empty()) && (!paramc.b(';')))
            {
              paramc = new a("Invalid @media rule: expected '}' at end of rule set");
              AppMethodBeat.o(206451);
              throw paramc;
            }
            if ((h.qQ() == null) || (!a((List)localObject1, this.aOd))) {
              break label737;
            }
            h.qQ();
            break;
          }
          String.format("Ignoring @%s rule", new Object[] { localObject1 });
          b(paramc);
        }
      }
      label737:
      paramc.rs();
      break;
      label744:
      boolean bool = a(localq, paramc);
      if (bool) {
        break;
      }
    }
  }
  
  final b.q W(String paramString)
  {
    AppMethodBeat.i(206446);
    paramString = new c(paramString);
    paramString.rs();
    paramString = c(paramString);
    AppMethodBeat.o(206446);
    return paramString;
  }
  
  static final class a
  {
    final b.b aOi;
    public final String name;
    public final String value;
    
    a(String paramString1, b.b paramb, String paramString2)
    {
      this.name = paramString1;
      this.aOi = paramb;
      this.value = paramString2;
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(206406);
      aOj = new b("EXISTS", 0);
      aOk = new b("EQUALS", 1);
      aOl = new b("INCLUDES", 2);
      aOm = new b("DASHMATCH", 3);
      aOn = new b[] { aOj, aOk, aOl, aOm };
      AppMethodBeat.o(206406);
    }
    
    private b() {}
  }
  
  static final class c
    extends l.h
  {
    c(String paramString)
    {
      super();
      AppMethodBeat.i(206407);
      AppMethodBeat.o(206407);
    }
    
    private boolean a(b.r paramr)
    {
      AppMethodBeat.i(206411);
      if (empty())
      {
        AppMethodBeat.o(206411);
        return false;
      }
      int m = this.position;
      b.d locald;
      if (!paramr.isEmpty()) {
        if (b('>'))
        {
          locald = b.d.aOp;
          rs();
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
              localObject1 = qA();
              if (localObject1 == null)
              {
                paramr = new a("Invalid \".class\" simpleSelectors");
                AppMethodBeat.o(206411);
                throw paramr;
                if (!b('+')) {
                  break label2012;
                }
                locald = b.d.aOq;
                rs();
                break;
                localObject1 = qA();
                if (localObject1 == null) {
                  break label2006;
                }
                localObject1 = new b.s(locald, (String)localObject1);
                paramr.aPo += 1;
                continue;
              }
              ((b.s)localObject2).a("class", b.b.aOk, (String)localObject1);
              paramr.qF();
              localObject1 = localObject2;
              continue;
            }
            if (b('#'))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new b.s(locald, null);
              }
              localObject1 = qA();
              if (localObject1 == null)
              {
                paramr = new a("Invalid \"#id\" simpleSelectors");
                AppMethodBeat.o(206411);
                throw paramr;
              }
              ((b.s)localObject2).a("id", b.b.aOk, (String)localObject1);
              paramr.aPo += 1000000;
              localObject1 = localObject2;
              continue;
            }
            if (b('['))
            {
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = new b.s(locald, null);
              }
              rs();
              str = qA();
              localObject2 = null;
              if (str == null)
              {
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(206411);
                throw paramr;
              }
              rs();
              localObject1 = null;
              if (b('='))
              {
                localObject1 = b.b.aOk;
                if (localObject1 == null) {
                  break label494;
                }
                rs();
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
                AppMethodBeat.o(206411);
                throw paramr;
                if (aO("~="))
                {
                  localObject1 = b.b.aOl;
                  break;
                }
                if (!aO("|=")) {
                  break;
                }
                localObject1 = b.b.aOm;
                break;
                localObject4 = rE();
                localObject2 = localObject4;
                if (localObject4 == null) {
                  localObject2 = qA();
                }
              }
              label490:
              rs();
              label494:
              if (!b(']'))
              {
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(206411);
                throw paramr;
              }
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = b.b.aOj;
              }
              ((b.s)localObject3).a(str, (b.b)localObject4, (String)localObject2);
              paramr.qF();
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
            str = qA();
            if (str == null)
            {
              paramr = new a("Invalid pseudo class");
              AppMethodBeat.o(206411);
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
            switch (b.1.aOh[localObject1.ordinal()])
            {
            default: 
              paramr = new a("Unsupported pseudo class: ".concat(String.valueOf(str)));
              AppMethodBeat.o(206411);
              throw paramr;
            case 1: 
              localObject1 = new b.g(0, 1, true, false, null);
              paramr.qF();
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
              for (;;)
              {
                if (((b.s)localObject2).aPr == null) {
                  ((b.s)localObject2).aPr = new ArrayList();
                }
                ((b.s)localObject2).aPr.add(localObject1);
                localObject1 = localObject2;
                break;
                localObject1 = new b.g(0, 1, false, false, null);
                paramr.qF();
                continue;
                localObject1 = new b.l(false, null);
                paramr.qF();
                continue;
                localObject1 = new b.g(0, 1, true, true, ((b.s)localObject2).tag);
                paramr.qF();
                continue;
                localObject1 = new b.g(0, 1, false, true, ((b.s)localObject2).tag);
                paramr.qF();
                continue;
                localObject1 = new b.l(true, ((b.s)localObject2).tag);
                paramr.qF();
                continue;
                localObject1 = new b.m((byte)0);
                paramr.qF();
                continue;
                localObject1 = new b.h((byte)0);
                paramr.qF();
              }
            case 9: 
            case 10: 
            case 11: 
            case 12: 
              if ((localObject1 == b.i.aOJ) || (localObject1 == b.i.aOL))
              {
                bool1 = true;
                if ((localObject1 != b.i.aOL) && (localObject1 != b.i.aOM)) {
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
                  AppMethodBeat.o(206411);
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
                    rs();
                    if (aO("odd")) {}
                    for (localObject1 = new a(2, 1);; localObject1 = new a(2, 0))
                    {
                      rs();
                      if (!b(')')) {
                        break label1409;
                      }
                      break;
                      if (!aO("even")) {
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
                    localObject1 = d.e(this.aWy, this.position, this.aWz);
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
                      rs();
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
                      rs();
                      localObject4 = d.e(this.aWy, this.position, this.aWz);
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
              paramr.qF();
              break;
              if (empty()) {
                localObject1 = null;
              }
              while (localObject1 == null)
              {
                paramr = new a("Invalid or missing parameter section for pseudo class: ".concat(String.valueOf(str)));
                AppMethodBeat.o(206411);
                throw paramr;
                i = this.position;
                if (!b('('))
                {
                  localObject1 = null;
                }
                else
                {
                  rs();
                  localObject1 = qC();
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
                            if (((b.r)localObject4).aPn == null) {
                              break label1687;
                            }
                            localObject4 = ((b.r)localObject4).aPn.iterator();
                            break;
                          } while (!((Iterator)localObject4).hasNext());
                          localObject5 = (b.s)((Iterator)localObject4).next();
                        } while (((b.s)localObject5).aPr == null);
                        localObject5 = ((b.s)localObject5).aPr.iterator();
                      } while (!((Iterator)localObject5).hasNext());
                    } while (!((b.f)((Iterator)localObject5).next() instanceof b.j));
                    localObject1 = null;
                  }
                }
              }
              localObject1 = new b.j((List)localObject1);
              localObject3 = (b.j)localObject1;
              i = -2147483648;
              localObject3 = ((b.j)localObject3).aPh.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (b.r)((Iterator)localObject3).next();
                if (((b.r)localObject4).aPo <= i) {
                  break label1977;
                }
                i = ((b.r)localObject4).aPo;
              }
              for (;;)
              {
                break label1724;
                paramr.aPo = i;
                break;
                localObject1 = new b.n((byte)0);
                paramr.qF();
                break;
                if (empty()) {}
                for (;;)
                {
                  localObject1 = new b.k(str);
                  paramr.qF();
                  break;
                  i = this.position;
                  localObject1 = null;
                  if (b('('))
                  {
                    rs();
                    do
                    {
                      localObject4 = qA();
                      if (localObject4 == null) {
                        break;
                      }
                      localObject3 = localObject1;
                      if (localObject1 == null) {
                        localObject3 = new ArrayList();
                      }
                      ((ArrayList)localObject3).add(localObject4);
                      rs();
                      localObject1 = localObject3;
                    } while (rt());
                    if (!b(')')) {
                      this.position = i;
                    }
                  }
                }
                localObject1 = new b.k(str);
                paramr.qF();
                break;
                if (localObject1 != null)
                {
                  if (paramr.aPn == null) {
                    paramr.aPn = new ArrayList();
                  }
                  paramr.aPn.add(localObject1);
                  AppMethodBeat.o(206411);
                  return true;
                }
                this.position = m;
                AppMethodBeat.o(206411);
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
    
    static int dt(int paramInt)
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
    
    private int qB()
    {
      AppMethodBeat.i(206409);
      if (empty())
      {
        i = this.position;
        AppMethodBeat.o(206409);
        return i;
      }
      int m = this.position;
      int j = this.position;
      int k = this.aWy.charAt(this.position);
      int i = k;
      if (k == 45) {
        i = ry();
      }
      if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || (i == 95))
      {
        for (i = ry(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || ((i >= 48) && (i <= 57)) || (i == 45) || (i == 95); i = ry()) {}
        j = this.position;
      }
      this.position = m;
      AppMethodBeat.o(206409);
      return j;
    }
    
    final String qA()
    {
      AppMethodBeat.i(206408);
      int i = qB();
      if (i == this.position)
      {
        AppMethodBeat.o(206408);
        return null;
      }
      String str = this.aWy.substring(this.position, i);
      this.position = i;
      AppMethodBeat.o(206408);
      return str;
    }
    
    final List<b.r> qC()
    {
      AppMethodBeat.i(206410);
      if (empty())
      {
        AppMethodBeat.o(206410);
        return null;
      }
      ArrayList localArrayList = new ArrayList(1);
      b.r localr = new b.r((byte)0);
      while ((!empty()) && (a(localr))) {
        if (rt())
        {
          localArrayList.add(localr);
          localr = new b.r((byte)0);
        }
      }
      if (!localr.isEmpty()) {
        localArrayList.add(localr);
      }
      AppMethodBeat.o(206410);
      return localArrayList;
    }
    
    final String qD()
    {
      AppMethodBeat.i(206412);
      if (empty())
      {
        AppMethodBeat.o(206412);
        return null;
      }
      int k = this.position;
      int j = this.position;
      for (int i = this.aWy.charAt(this.position); (i != -1) && (i != 59) && (i != 125) && (i != 33) && (!dw(i)); i = ry()) {
        if (!isWhitespace(i)) {
          j = this.position + 1;
        }
      }
      if (this.position > k)
      {
        String str = this.aWy.substring(k, j);
        AppMethodBeat.o(206412);
        return str;
      }
      this.position = k;
      AppMethodBeat.o(206412);
      return null;
    }
    
    final String qE()
    {
      AppMethodBeat.i(206413);
      if (empty())
      {
        AppMethodBeat.o(206413);
        return null;
      }
      int n = this.aWy.charAt(this.position);
      if ((n != 39) && (n != 34))
      {
        AppMethodBeat.o(206413);
        return null;
      }
      Object localObject = new StringBuilder();
      this.position += 1;
      int i = rv().intValue();
      while ((i != -1) && (i != n))
      {
        int k = i;
        if (i == 92)
        {
          int j = rv().intValue();
          i = j;
          if (j == -1) {
            continue;
          }
          if ((j == 10) || (j == 13) || (j == 12))
          {
            i = rv().intValue();
            continue;
          }
          int m = dt(j);
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
              j = rv().intValue();
              int i1 = dt(j);
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
        i = rv().intValue();
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(206413);
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
    private boolean aOE;
    private boolean aOF;
    private String aOG;
    private int b;
    
    g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.aOE = paramBoolean1;
      this.aOF = paramBoolean2;
      this.aOG = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(206420);
      int i;
      label52:
      int m;
      int k;
      if ((this.aOF) && (this.aOG == null))
      {
        paramp = paramal.getNodeName();
        if (paramal.aSP == null) {
          break label124;
        }
        Iterator localIterator = paramal.aSP.getChildren().iterator();
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
        if ((paramp != null) && (!localal.getNodeName().equals(paramp))) {
          break label239;
        }
        i += 1;
      }
      label130:
      label239:
      for (;;)
      {
        break label52;
        paramp = this.aOG;
        break;
        label124:
        m = 1;
        k = 0;
        if (this.aOE) {
          i = k + 1;
        }
        while (this.a == 0) {
          if (i == this.b)
          {
            AppMethodBeat.o(206420);
            return true;
            i = m - k;
          }
          else
          {
            AppMethodBeat.o(206420);
            return false;
          }
        }
        if (((i - this.b) % this.a == 0) && ((Integer.signum(i - this.b) == 0) || (Integer.signum(i - this.b) == Integer.signum(this.a))))
        {
          AppMethodBeat.o(206420);
          return true;
        }
        AppMethodBeat.o(206420);
        return false;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206421);
      if (this.aOE) {}
      for (String str = ""; this.aOF; str = "last-")
      {
        str = String.format("nth-%schild(%dn%+d of type <%s>)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.aOG });
        AppMethodBeat.o(206421);
        return str;
      }
      str = String.format("nth-%schild(%dn%+d)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b) });
      AppMethodBeat.o(206421);
      return str;
    }
  }
  
  static final class h
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(206422);
      if ((paramal instanceof h.aj))
      {
        if (((h.aj)paramal).getChildren().size() == 0)
        {
          AppMethodBeat.o(206422);
          return true;
        }
        AppMethodBeat.o(206422);
        return false;
      }
      AppMethodBeat.o(206422);
      return true;
    }
    
    public final String toString()
    {
      return "empty";
    }
  }
  
  static enum i
  {
    private static final Map<String, i> aNT;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(206426);
      aOH = new i("target", 0);
      aOI = new i("root", 1);
      aOJ = new i("nth_child", 2);
      aOK = new i("nth_last_child", 3);
      aOL = new i("nth_of_type", 4);
      aOM = new i("nth_last_of_type", 5);
      aON = new i("first_child", 6);
      aOO = new i("last_child", 7);
      aOP = new i("first_of_type", 8);
      aOQ = new i("last_of_type", 9);
      aOR = new i("only_child", 10);
      aOS = new i("only_of_type", 11);
      aOT = new i("empty", 12);
      aOU = new i("not", 13);
      aOV = new i("lang", 14);
      aOW = new i("link", 15);
      aOX = new i("visited", 16);
      aOY = new i("hover", 17);
      aOZ = new i("active", 18);
      aPa = new i("focus", 19);
      aPb = new i("enabled", 20);
      aPc = new i("disabled", 21);
      aPd = new i("checked", 22);
      aPe = new i("indeterminate", 23);
      aPf = new i("UNSUPPORTED", 24);
      aPg = new i[] { aOH, aOI, aOJ, aOK, aOL, aOM, aON, aOO, aOP, aOQ, aOR, aOS, aOT, aOU, aOV, aOW, aOX, aOY, aOZ, aPa, aPb, aPc, aPd, aPe, aPf };
      aNT = new HashMap();
      i[] arrayOfi = values();
      int j = arrayOfi.length;
      while (i < j)
      {
        i locali = arrayOfi[i];
        if (locali != aPf)
        {
          String str = locali.name().replace('_', '-');
          aNT.put(str, locali);
        }
        i += 1;
      }
      AppMethodBeat.o(206426);
    }
    
    private i() {}
    
    public static i Y(String paramString)
    {
      AppMethodBeat.i(206425);
      paramString = (i)aNT.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(206425);
        return paramString;
      }
      paramString = aPf;
      AppMethodBeat.o(206425);
      return paramString;
    }
  }
  
  static final class j
    implements b.f
  {
    List<b.r> aPh;
    
    j(List<b.r> paramList)
    {
      this.aPh = paramList;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(206427);
      Iterator localIterator = this.aPh.iterator();
      while (localIterator.hasNext()) {
        if (b.a(paramp, (b.r)localIterator.next(), paramal))
        {
          AppMethodBeat.o(206427);
          return false;
        }
      }
      AppMethodBeat.o(206427);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206428);
      String str = "not(" + this.aPh + ")";
      AppMethodBeat.o(206428);
      return str;
    }
  }
  
  static final class k
    implements b.f
  {
    private String aPi;
    
    k(String paramString)
    {
      this.aPi = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      return false;
    }
    
    public final String toString()
    {
      return this.aPi;
    }
  }
  
  static final class l
    implements b.f
  {
    private boolean aOF;
    private String aOG;
    
    public l(boolean paramBoolean, String paramString)
    {
      this.aOF = paramBoolean;
      this.aOG = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(206429);
      label48:
      int j;
      if ((this.aOF) && (this.aOG == null))
      {
        paramp = paramal.getNodeName();
        if (paramal.aSP == null) {
          break label105;
        }
        paramal = paramal.aSP.getChildren().iterator();
        int i = 0;
        j = i;
        if (!paramal.hasNext()) {
          break label108;
        }
        h.al localal = (h.al)paramal.next();
        if ((paramp != null) && (!localal.getNodeName().equals(paramp))) {
          break label128;
        }
        i += 1;
      }
      label128:
      for (;;)
      {
        break label48;
        paramp = this.aOG;
        break;
        label105:
        j = 1;
        label108:
        if (j == 1)
        {
          AppMethodBeat.o(206429);
          return true;
        }
        AppMethodBeat.o(206429);
        return false;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206430);
      if (this.aOF)
      {
        str = String.format("only-of-type <%s>", new Object[] { this.aOG });
        AppMethodBeat.o(206430);
        return str;
      }
      String str = String.format("only-child", new Object[0]);
      AppMethodBeat.o(206430);
      return str;
    }
  }
  
  static final class m
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      return paramal.aSP == null;
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
        if (paramal == paramp.aPl) {
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
  
  static final class p
  {
    h.al aPl;
    
    public final String toString()
    {
      AppMethodBeat.i(206432);
      if (this.aPl != null)
      {
        String str = String.format("<%s id=\"%s\">", new Object[] { this.aPl.getNodeName(), this.aPl.id });
        AppMethodBeat.o(206432);
        return str;
      }
      AppMethodBeat.o(206432);
      return "";
    }
  }
  
  static final class s
  {
    b.d aPp;
    List<b.a> aPq;
    List<b.f> aPr;
    String tag;
    
    s(b.d paramd, String paramString)
    {
      AppMethodBeat.i(206440);
      this.aPp = null;
      this.tag = null;
      this.aPq = null;
      this.aPr = null;
      if (paramd != null) {}
      for (;;)
      {
        this.aPp = paramd;
        this.tag = paramString;
        AppMethodBeat.o(206440);
        return;
        paramd = b.d.aOo;
      }
    }
    
    final void a(String paramString1, b.b paramb, String paramString2)
    {
      AppMethodBeat.i(206441);
      if (this.aPq == null) {
        this.aPq = new ArrayList();
      }
      this.aPq.add(new b.a(paramString1, paramb, paramString2));
      AppMethodBeat.o(206441);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206442);
      StringBuilder localStringBuilder = new StringBuilder();
      label40:
      label63:
      Object localObject2;
      if (this.aPp == b.d.aOp)
      {
        localStringBuilder.append("> ");
        if (this.tag != null) {
          break label162;
        }
        localObject1 = "*";
        localStringBuilder.append((String)localObject1);
        if (this.aPq == null) {
          break label221;
        }
        localObject1 = this.aPq.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label221;
        }
        localObject2 = (b.a)((Iterator)localObject1).next();
        localStringBuilder.append('[').append(((b.a)localObject2).name);
        switch (b.1.aOg[localObject2.aOi.ordinal()])
        {
        }
      }
      for (;;)
      {
        localStringBuilder.append(']');
        break label63;
        if (this.aPp != b.d.aOq) {
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
      if (this.aPr != null)
      {
        localObject1 = this.aPr.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (b.f)((Iterator)localObject1).next();
          localStringBuilder.append(':').append(localObject2);
        }
      }
      Object localObject1 = localStringBuilder.toString();
      AppMethodBeat.o(206442);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.a.a.b
 * JD-Core Version:    0.7.0.1
 */