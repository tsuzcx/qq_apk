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
  private b.e aOk = null;
  private b.t aOl = null;
  private boolean aOm = false;
  
  b()
  {
    this(b.e.aOG, b.t.aPz);
  }
  
  b(b.e parame, b.t paramt)
  {
    this.aOk = parame;
    this.aOl = paramt;
  }
  
  public static List<String> W(String paramString)
  {
    AppMethodBeat.i(212957);
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
        localc.rp();
        paramString = (String)localObject;
      }
    }
    AppMethodBeat.o(212957);
    return paramString;
  }
  
  private static int a(List<h.aj> paramList, int paramInt, h.al paramal)
  {
    AppMethodBeat.i(212961);
    if (paramInt < 0)
    {
      AppMethodBeat.o(212961);
      return 0;
    }
    if (paramList.get(paramInt) != paramal.aSX)
    {
      AppMethodBeat.o(212961);
      return -1;
    }
    paramList = paramal.aSX.getChildren().iterator();
    paramInt = 0;
    while (paramList.hasNext())
    {
      if ((h.an)paramList.next() == paramal)
      {
        AppMethodBeat.o(212961);
        return paramInt;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(212961);
    return -1;
  }
  
  private static List<b.e> a(c paramc)
  {
    AppMethodBeat.i(212953);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str;
      if (!paramc.empty())
      {
        str = paramc.rw();
        if (str == null) {}
      }
      try
      {
        localArrayList.add(b.e.valueOf(str));
        label38:
        if (paramc.rq()) {
          continue;
        }
        AppMethodBeat.o(212953);
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
    AppMethodBeat.i(212960);
    int i = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    h.al localal;
    for (;;)
    {
      s locals = paramr.dz(paramInt2);
      localal = (h.al)paramList.get(paramInt1);
      if (!a(paramp, locals, localal))
      {
        AppMethodBeat.o(212960);
        return false;
      }
      if (locals.aPw == d.aOv)
      {
        if (paramInt2 == 0)
        {
          AppMethodBeat.o(212960);
          return true;
        }
        while (paramInt1 > 0)
        {
          i = paramInt1 - 1;
          paramInt1 = i;
          if (a(paramp, paramr, paramInt2 - 1, paramList, i))
          {
            AppMethodBeat.o(212960);
            return true;
          }
        }
        AppMethodBeat.o(212960);
        return false;
      }
      if (locals.aPw != d.aOw) {
        break;
      }
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    i = a(paramList, paramInt1, localal);
    if (i <= 0)
    {
      AppMethodBeat.o(212960);
      return false;
    }
    boolean bool = a(paramp, paramr, paramInt2 - 1, paramList, paramInt1, (h.al)localal.aSX.getChildren().get(i - 1));
    AppMethodBeat.o(212960);
    return bool;
  }
  
  private static boolean a(p paramp, b.r paramr, int paramInt1, List<h.aj> paramList, int paramInt2, h.al paramal)
  {
    AppMethodBeat.i(212959);
    for (;;)
    {
      s locals = paramr.dz(paramInt1);
      if (!a(paramp, locals, paramal))
      {
        AppMethodBeat.o(212959);
        return false;
      }
      if (locals.aPw == d.aOv)
      {
        if (paramInt1 == 0)
        {
          AppMethodBeat.o(212959);
          return true;
        }
        do
        {
          paramInt2 -= 1;
          if (paramInt2 < 0) {
            break;
          }
        } while (!a(paramp, paramr, paramInt1 - 1, paramList, paramInt2));
        AppMethodBeat.o(212959);
        return true;
        AppMethodBeat.o(212959);
        return false;
      }
      if (locals.aPw == d.aOw)
      {
        boolean bool = a(paramp, paramr, paramInt1 - 1, paramList, paramInt2);
        AppMethodBeat.o(212959);
        return bool;
      }
      int i = a(paramList, paramInt2, paramal);
      if (i <= 0)
      {
        AppMethodBeat.o(212959);
        return false;
      }
      paramal = (h.al)paramal.aSX.getChildren().get(i - 1);
      paramInt1 -= 1;
    }
  }
  
  static boolean a(p paramp, b.r paramr, h.al paramal)
  {
    AppMethodBeat.i(212958);
    ArrayList localArrayList = new ArrayList();
    for (h.aj localaj = paramal.aSX; localaj != null; localaj = ((h.an)localaj).aSX) {
      localArrayList.add(0, localaj);
    }
    int i = localArrayList.size();
    if (paramr.size() == 1)
    {
      bool = a(paramp, paramr.dz(0), paramal);
      AppMethodBeat.o(212958);
      return bool;
    }
    boolean bool = a(paramp, paramr, paramr.size() - 1, localArrayList, i - 1, paramal);
    AppMethodBeat.o(212958);
    return bool;
  }
  
  private static boolean a(p paramp, s params, h.al paramal)
  {
    AppMethodBeat.i(212962);
    if ((params.tag != null) && (!params.tag.equals(paramal.getNodeName().toLowerCase(Locale.US))))
    {
      AppMethodBeat.o(212962);
      return false;
    }
    if (params.aPx != null)
    {
      Iterator localIterator = params.aPx.iterator();
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
            AppMethodBeat.o(212962);
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
          AppMethodBeat.o(212962);
          return false;
          if (paramal.aSV == null)
          {
            AppMethodBeat.o(212962);
            return false;
          }
          if (!paramal.aSV.contains(locala.value))
          {
            AppMethodBeat.o(212962);
            return false;
          }
        }
      }
    }
    if (params.aPy != null)
    {
      params = params.aPy.iterator();
      while (params.hasNext()) {
        if (!((f)params.next()).a(paramp, paramal))
        {
          AppMethodBeat.o(212962);
          return false;
        }
      }
    }
    AppMethodBeat.o(212962);
    return true;
  }
  
  private boolean a(b.q paramq, c paramc)
  {
    AppMethodBeat.i(212956);
    List localList = paramc.qz();
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (!paramc.b('{'))
      {
        paramq = new a("Malformed rule block: expected '{'");
        AppMethodBeat.o(212956);
        throw paramq;
      }
      paramc.rp();
      h.ae localae = new h.ae();
      do
      {
        String str1 = paramc.qx();
        paramc.rp();
        if (!paramc.b(':'))
        {
          paramq = new a("Expected ':'");
          AppMethodBeat.o(212956);
          throw paramq;
        }
        paramc.rp();
        String str2 = paramc.qA();
        if (str2 == null)
        {
          paramq = new a("Expected property value");
          AppMethodBeat.o(212956);
          throw paramq;
        }
        paramc.rp();
        if (paramc.b('!'))
        {
          paramc.rp();
          if (!paramc.aO("important"))
          {
            paramq = new a("Malformed rule set: found unexpected '!'");
            AppMethodBeat.o(212956);
            throw paramq;
          }
          paramc.rp();
        }
        paramc.b(';');
        l.a(localae, str1, str2);
        paramc.rp();
      } while ((!paramc.empty()) && (!paramc.b('}')));
      paramc.rp();
      paramc = localList.iterator();
      while (paramc.hasNext()) {
        paramq.a(new b.o((b.r)paramc.next(), localae, this.aOl));
      }
      AppMethodBeat.o(212956);
      return true;
    }
    AppMethodBeat.o(212956);
    return false;
  }
  
  static boolean a(String paramString, b.e parame)
  {
    AppMethodBeat.i(212951);
    paramString = new c(paramString);
    paramString.rp();
    boolean bool = a(a(paramString), parame);
    AppMethodBeat.o(212951);
    return bool;
  }
  
  private static boolean a(List<b.e> paramList, b.e parame)
  {
    AppMethodBeat.i(212952);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.e locale = (b.e)paramList.next();
      if ((locale == b.e.aOz) || (locale == parame))
      {
        AppMethodBeat.o(212952);
        return true;
      }
    }
    AppMethodBeat.o(212952);
    return false;
  }
  
  private static void b(c paramc)
  {
    AppMethodBeat.i(212954);
    int i = 0;
    while (!paramc.empty())
    {
      int j = paramc.rs().intValue();
      if ((j == 59) && (i == 0))
      {
        AppMethodBeat.o(212954);
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
          AppMethodBeat.o(212954);
          return;
        }
      }
    }
    AppMethodBeat.o(212954);
  }
  
  private b.q c(c paramc)
  {
    AppMethodBeat.i(212955);
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
          localObject1 = paramc.qx();
          paramc.rp();
          if (localObject1 != null) {
            break label113;
          }
          paramc = new a("Invalid '@' rule");
          AppMethodBeat.o(212955);
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
      AppMethodBeat.o(212955);
      return localq;
      label113:
      if ((!this.aOm) && (((String)localObject1).equals("media")))
      {
        localObject1 = a(paramc);
        if (!paramc.b('{'))
        {
          paramc = new a("Invalid @media rule: missing rule set");
          AppMethodBeat.o(212955);
          throw paramc;
        }
        paramc.rp();
        if (a((List)localObject1, this.aOk))
        {
          this.aOm = true;
          localq.a(c(paramc));
          this.aOm = false;
        }
      }
      for (;;)
      {
        if ((!paramc.empty()) && (!paramc.b('}')))
        {
          paramc = new a("Invalid @media rule: expected '}' at end of rule set");
          AppMethodBeat.o(212955);
          throw paramc;
          c(paramc);
          continue;
          if ((!this.aOm) && (((String)localObject1).equals("import")))
          {
            if (paramc.empty()) {}
            int k;
            for (localObject1 = null;; localObject1 = null)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = paramc.qB();
              }
              if (localObject2 != null) {
                break label647;
              }
              paramc = new a("Invalid @import rule: expected string or url()");
              AppMethodBeat.o(212955);
              throw paramc;
              k = paramc.position;
              if (paramc.aO("url(")) {
                break;
              }
            }
            paramc.rp();
            localObject1 = paramc.qB();
            Object localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject1 = new StringBuilder();
              while (!paramc.empty())
              {
                int j = paramc.aWG.charAt(paramc.position);
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
                  localObject2 = paramc.aWG;
                  i = paramc.position;
                  paramc.position = (i + 1);
                  i = ((String)localObject2).charAt(i);
                  if ((i == 10) || (i == 13) || (i == 12)) {
                    continue;
                  }
                  j = c.dy(i);
                  if (j != -1)
                  {
                    i = 1;
                    while ((i <= 5) && (!paramc.empty()))
                    {
                      int m = c.dy(paramc.aWG.charAt(paramc.position));
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
                paramc.rp();
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
            paramc.rp();
            localObject1 = a(paramc);
            if ((!paramc.empty()) && (!paramc.b(';')))
            {
              paramc = new a("Invalid @media rule: expected '}' at end of rule set");
              AppMethodBeat.o(212955);
              throw paramc;
            }
            if ((h.qN() == null) || (!a((List)localObject1, this.aOk))) {
              break label737;
            }
            h.qN();
            break;
          }
          String.format("Ignoring @%s rule", new Object[] { localObject1 });
          b(paramc);
        }
      }
      label737:
      paramc.rp();
      break;
      label744:
      boolean bool = a(localq, paramc);
      if (bool) {
        break;
      }
    }
  }
  
  final b.q V(String paramString)
  {
    AppMethodBeat.i(212950);
    paramString = new c(paramString);
    paramString.rp();
    paramString = c(paramString);
    AppMethodBeat.o(212950);
    return paramString;
  }
  
  static final class a
  {
    final b.b aOp;
    public final String name;
    public final String value;
    
    a(String paramString1, b.b paramb, String paramString2)
    {
      this.name = paramString1;
      this.aOp = paramb;
      this.value = paramString2;
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(212910);
      aOq = new b("EXISTS", 0);
      aOr = new b("EQUALS", 1);
      aOs = new b("INCLUDES", 2);
      aOt = new b("DASHMATCH", 3);
      aOu = new b[] { aOq, aOr, aOs, aOt };
      AppMethodBeat.o(212910);
    }
    
    private b() {}
  }
  
  static final class c
    extends l.h
  {
    c(String paramString)
    {
      super();
      AppMethodBeat.i(212911);
      AppMethodBeat.o(212911);
    }
    
    private boolean a(b.r paramr)
    {
      AppMethodBeat.i(212915);
      if (empty())
      {
        AppMethodBeat.o(212915);
        return false;
      }
      int m = this.position;
      b.d locald;
      if (!paramr.isEmpty()) {
        if (b('>'))
        {
          locald = b.d.aOw;
          rp();
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
        label1988:
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
              localObject1 = qx();
              if (localObject1 == null)
              {
                paramr = new a("Invalid \".class\" simpleSelectors");
                AppMethodBeat.o(212915);
                throw paramr;
                if (!b('+')) {
                  break label2009;
                }
                locald = b.d.aOx;
                rp();
                break;
                localObject1 = qx();
                if (localObject1 == null) {
                  break label2003;
                }
                localObject1 = new b.s(locald, (String)localObject1);
                paramr.aPv += 1;
                continue;
              }
              ((b.s)localObject2).a("class", b.b.aOr, (String)localObject1);
              paramr.qC();
              localObject1 = localObject2;
              continue;
            }
            if (b('#'))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new b.s(locald, null);
              }
              localObject1 = qx();
              if (localObject1 == null)
              {
                paramr = new a("Invalid \"#id\" simpleSelectors");
                AppMethodBeat.o(212915);
                throw paramr;
              }
              ((b.s)localObject2).a("id", b.b.aOr, (String)localObject1);
              paramr.aPv += 1000000;
              localObject1 = localObject2;
              continue;
            }
            if (b('['))
            {
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = new b.s(locald, null);
              }
              rp();
              str = qx();
              localObject2 = null;
              if (str == null)
              {
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(212915);
                throw paramr;
              }
              rp();
              localObject1 = null;
              if (b('='))
              {
                localObject1 = b.b.aOr;
                if (localObject1 == null) {
                  break label494;
                }
                rp();
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
                AppMethodBeat.o(212915);
                throw paramr;
                if (aO("~="))
                {
                  localObject1 = b.b.aOs;
                  break;
                }
                if (!aO("|=")) {
                  break;
                }
                localObject1 = b.b.aOt;
                break;
                localObject4 = rB();
                localObject2 = localObject4;
                if (localObject4 == null) {
                  localObject2 = qx();
                }
              }
              label490:
              rp();
              label494:
              if (!b(']'))
              {
                paramr = new a("Invalid attribute simpleSelectors");
                AppMethodBeat.o(212915);
                throw paramr;
              }
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = b.b.aOq;
              }
              ((b.s)localObject3).a(str, (b.b)localObject4, (String)localObject2);
              paramr.qC();
              localObject1 = localObject3;
              continue;
            }
            if (b(':')) {
              if (localObject1 != null) {
                break label1996;
              }
            }
          }
          label1099:
          label1996:
          for (Object localObject2 = new b.s(locald, null);; localObject2 = localObject1)
          {
            str = qx();
            if (str == null)
            {
              paramr = new a("Invalid pseudo class");
              AppMethodBeat.o(212915);
              throw paramr;
            }
            localObject1 = b.i.X(str);
            boolean bool1;
            boolean bool2;
            label1002:
            label1012:
            int n;
            label1138:
            int k;
            int j;
            int i;
            switch (b.1.aOo[localObject1.ordinal()])
            {
            default: 
              paramr = new a("Unsupported pseudo class: ".concat(String.valueOf(str)));
              AppMethodBeat.o(212915);
              throw paramr;
            case 1: 
              localObject1 = new b.g(0, 1, true, false, null);
              paramr.qC();
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
              for (;;)
              {
                if (((b.s)localObject2).aPy == null) {
                  ((b.s)localObject2).aPy = new ArrayList();
                }
                ((b.s)localObject2).aPy.add(localObject1);
                localObject1 = localObject2;
                break;
                localObject1 = new b.g(0, 1, false, false, null);
                paramr.qC();
                continue;
                localObject1 = new b.l(false, null);
                paramr.qC();
                continue;
                localObject1 = new b.g(0, 1, true, true, ((b.s)localObject2).tag);
                paramr.qC();
                continue;
                localObject1 = new b.g(0, 1, false, true, ((b.s)localObject2).tag);
                paramr.qC();
                continue;
                localObject1 = new b.l(true, ((b.s)localObject2).tag);
                paramr.qC();
                continue;
                localObject1 = new b.m((byte)0);
                paramr.qC();
                continue;
                localObject1 = new b.h((byte)0);
                paramr.qC();
              }
            case 9: 
            case 10: 
            case 11: 
            case 12: 
              if ((localObject1 == b.i.aOQ) || (localObject1 == b.i.aOS))
              {
                bool1 = true;
                if ((localObject1 != b.i.aOS) && (localObject1 != b.i.aOT)) {
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
                  AppMethodBeat.o(212915);
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
                    rp();
                    if (aO("odd")) {}
                    for (localObject1 = new a(2, 1);; localObject1 = new a(2, 0))
                    {
                      rp();
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
                    localObject1 = d.e(this.aWG, this.position, this.aWH);
                    if (localObject1 != null) {
                      this.position = ((d)localObject1).pos;
                    }
                    if ((!b('n')) && (!b('N'))) {
                      break label1988;
                    }
                    if (localObject1 != null)
                    {
                      localObject4 = null;
                      k = 1;
                      rp();
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
                        break label1977;
                      }
                      rp();
                      localObject4 = d.e(this.aWG, this.position, this.aWH);
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
              paramr.qC();
              break;
              if (empty()) {
                localObject1 = null;
              }
              while (localObject1 == null)
              {
                paramr = new a("Invalid or missing parameter section for pseudo class: ".concat(String.valueOf(str)));
                AppMethodBeat.o(212915);
                throw paramr;
                i = this.position;
                if (!b('('))
                {
                  localObject1 = null;
                }
                else
                {
                  rp();
                  localObject1 = qz();
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
                            if (((b.r)localObject4).aPu == null) {
                              break label1687;
                            }
                            localObject4 = ((b.r)localObject4).aPu.iterator();
                            break;
                          } while (!((Iterator)localObject4).hasNext());
                          localObject5 = (b.s)((Iterator)localObject4).next();
                        } while (((b.s)localObject5).aPy == null);
                        localObject5 = ((b.s)localObject5).aPy.iterator();
                      } while (!((Iterator)localObject5).hasNext());
                    } while (!((b.f)((Iterator)localObject5).next() instanceof b.j));
                    localObject1 = null;
                  }
                }
              }
              localObject1 = new b.j((List)localObject1);
              localObject3 = (b.j)localObject1;
              i = -2147483648;
              localObject3 = ((b.j)localObject3).aPo.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (b.r)((Iterator)localObject3).next();
                if (((b.r)localObject4).aPv <= i) {
                  break label1974;
                }
                i = ((b.r)localObject4).aPv;
              }
              for (;;)
              {
                break label1724;
                paramr.aPv = i;
                break;
                localObject1 = new b.n((byte)0);
                paramr.qC();
                break;
                if (!empty())
                {
                  i = this.position;
                  localObject1 = null;
                  if (b('('))
                  {
                    rp();
                    do
                    {
                      localObject4 = qx();
                      if (localObject4 == null) {
                        break;
                      }
                      localObject3 = localObject1;
                      if (localObject1 == null) {
                        localObject3 = new ArrayList();
                      }
                      ((ArrayList)localObject3).add(localObject4);
                      rp();
                      localObject1 = localObject3;
                    } while (rq());
                    if (!b(')')) {
                      this.position = i;
                    }
                  }
                }
                localObject1 = new b.k(str);
                paramr.qC();
                break;
                localObject1 = new b.k(str);
                paramr.qC();
                break;
                if (localObject1 != null)
                {
                  if (paramr.aPu == null) {
                    paramr.aPu = new ArrayList();
                  }
                  paramr.aPu.add(localObject1);
                  AppMethodBeat.o(212915);
                  return true;
                }
                this.position = m;
                AppMethodBeat.o(212915);
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
          label2003:
          localObject1 = null;
        }
        label1409:
        label1687:
        label1974:
        label1977:
        label2009:
        locald = null;
      }
    }
    
    static int dy(int paramInt)
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
    
    private int qy()
    {
      AppMethodBeat.i(212913);
      if (empty())
      {
        i = this.position;
        AppMethodBeat.o(212913);
        return i;
      }
      int m = this.position;
      int j = this.position;
      int k = this.aWG.charAt(this.position);
      int i = k;
      if (k == 45) {
        i = rv();
      }
      if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || (i == 95))
      {
        for (i = rv(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || ((i >= 48) && (i <= 57)) || (i == 45) || (i == 95); i = rv()) {}
        j = this.position;
      }
      this.position = m;
      AppMethodBeat.o(212913);
      return j;
    }
    
    final String qA()
    {
      AppMethodBeat.i(212916);
      if (empty())
      {
        AppMethodBeat.o(212916);
        return null;
      }
      int k = this.position;
      int j = this.position;
      for (int i = this.aWG.charAt(this.position); (i != -1) && (i != 59) && (i != 125) && (i != 33) && (!dB(i)); i = rv()) {
        if (!isWhitespace(i)) {
          j = this.position + 1;
        }
      }
      if (this.position > k)
      {
        String str = this.aWG.substring(k, j);
        AppMethodBeat.o(212916);
        return str;
      }
      this.position = k;
      AppMethodBeat.o(212916);
      return null;
    }
    
    final String qB()
    {
      AppMethodBeat.i(212917);
      if (empty())
      {
        AppMethodBeat.o(212917);
        return null;
      }
      int n = this.aWG.charAt(this.position);
      if ((n != 39) && (n != 34))
      {
        AppMethodBeat.o(212917);
        return null;
      }
      Object localObject = new StringBuilder();
      this.position += 1;
      int i = rs().intValue();
      while ((i != -1) && (i != n))
      {
        int k = i;
        if (i == 92)
        {
          int j = rs().intValue();
          i = j;
          if (j == -1) {
            continue;
          }
          if ((j == 10) || (j == 13) || (j == 12))
          {
            i = rs().intValue();
            continue;
          }
          int m = dy(j);
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
              j = rs().intValue();
              int i1 = dy(j);
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
        i = rs().intValue();
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(212917);
      return localObject;
    }
    
    final String qx()
    {
      AppMethodBeat.i(212912);
      int i = qy();
      if (i == this.position)
      {
        AppMethodBeat.o(212912);
        return null;
      }
      String str = this.aWG.substring(this.position, i);
      this.position = i;
      AppMethodBeat.o(212912);
      return str;
    }
    
    final List<b.r> qz()
    {
      AppMethodBeat.i(212914);
      if (empty())
      {
        AppMethodBeat.o(212914);
        return null;
      }
      ArrayList localArrayList = new ArrayList(1);
      b.r localr = new b.r((byte)0);
      while ((!empty()) && (a(localr))) {
        if (rq())
        {
          localArrayList.add(localr);
          localr = new b.r((byte)0);
        }
      }
      if (!localr.isEmpty()) {
        localArrayList.add(localr);
      }
      AppMethodBeat.o(212914);
      return localArrayList;
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
      AppMethodBeat.i(212920);
      aOv = new d("DESCENDANT", 0);
      aOw = new d("CHILD", 1);
      aOx = new d("FOLLOWS", 2);
      aOy = new d[] { aOv, aOw, aOx };
      AppMethodBeat.o(212920);
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
    private boolean aOL;
    private boolean aOM;
    private String aON;
    private int b;
    
    g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.aOL = paramBoolean1;
      this.aOM = paramBoolean2;
      this.aON = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(212924);
      int i;
      label52:
      int m;
      int k;
      if ((this.aOM) && (this.aON == null))
      {
        paramp = paramal.getNodeName();
        if (paramal.aSX == null) {
          break label124;
        }
        Iterator localIterator = paramal.aSX.getChildren().iterator();
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
        paramp = this.aON;
        break;
        label124:
        m = 1;
        k = 0;
        if (this.aOL) {
          i = k + 1;
        }
        while (this.a == 0) {
          if (i == this.b)
          {
            AppMethodBeat.o(212924);
            return true;
            i = m - k;
          }
          else
          {
            AppMethodBeat.o(212924);
            return false;
          }
        }
        if (((i - this.b) % this.a == 0) && ((Integer.signum(i - this.b) == 0) || (Integer.signum(i - this.b) == Integer.signum(this.a))))
        {
          AppMethodBeat.o(212924);
          return true;
        }
        AppMethodBeat.o(212924);
        return false;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(212925);
      if (this.aOL) {}
      for (String str = ""; this.aOM; str = "last-")
      {
        str = String.format("nth-%schild(%dn%+d of type <%s>)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.aON });
        AppMethodBeat.o(212925);
        return str;
      }
      str = String.format("nth-%schild(%dn%+d)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b) });
      AppMethodBeat.o(212925);
      return str;
    }
  }
  
  static final class h
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(212926);
      if ((paramal instanceof h.aj))
      {
        if (((h.aj)paramal).getChildren().size() == 0)
        {
          AppMethodBeat.o(212926);
          return true;
        }
        AppMethodBeat.o(212926);
        return false;
      }
      AppMethodBeat.o(212926);
      return true;
    }
    
    public final String toString()
    {
      return "empty";
    }
  }
  
  static enum i
  {
    private static final Map<String, i> aOa;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(212930);
      aOO = new i("target", 0);
      aOP = new i("root", 1);
      aOQ = new i("nth_child", 2);
      aOR = new i("nth_last_child", 3);
      aOS = new i("nth_of_type", 4);
      aOT = new i("nth_last_of_type", 5);
      aOU = new i("first_child", 6);
      aOV = new i("last_child", 7);
      aOW = new i("first_of_type", 8);
      aOX = new i("last_of_type", 9);
      aOY = new i("only_child", 10);
      aOZ = new i("only_of_type", 11);
      aPa = new i("empty", 12);
      aPb = new i("not", 13);
      aPc = new i("lang", 14);
      aPd = new i("link", 15);
      aPe = new i("visited", 16);
      aPf = new i("hover", 17);
      aPg = new i("active", 18);
      aPh = new i("focus", 19);
      aPi = new i("enabled", 20);
      aPj = new i("disabled", 21);
      aPk = new i("checked", 22);
      aPl = new i("indeterminate", 23);
      aPm = new i("UNSUPPORTED", 24);
      aPn = new i[] { aOO, aOP, aOQ, aOR, aOS, aOT, aOU, aOV, aOW, aOX, aOY, aOZ, aPa, aPb, aPc, aPd, aPe, aPf, aPg, aPh, aPi, aPj, aPk, aPl, aPm };
      aOa = new HashMap();
      i[] arrayOfi = values();
      int j = arrayOfi.length;
      while (i < j)
      {
        i locali = arrayOfi[i];
        if (locali != aPm)
        {
          String str = locali.name().replace('_', '-');
          aOa.put(str, locali);
        }
        i += 1;
      }
      AppMethodBeat.o(212930);
    }
    
    private i() {}
    
    public static i X(String paramString)
    {
      AppMethodBeat.i(212929);
      paramString = (i)aOa.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(212929);
        return paramString;
      }
      paramString = aPm;
      AppMethodBeat.o(212929);
      return paramString;
    }
  }
  
  static final class j
    implements b.f
  {
    List<b.r> aPo;
    
    j(List<b.r> paramList)
    {
      this.aPo = paramList;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(212931);
      Iterator localIterator = this.aPo.iterator();
      while (localIterator.hasNext()) {
        if (b.a(paramp, (b.r)localIterator.next(), paramal))
        {
          AppMethodBeat.o(212931);
          return false;
        }
      }
      AppMethodBeat.o(212931);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(212932);
      String str = "not(" + this.aPo + ")";
      AppMethodBeat.o(212932);
      return str;
    }
  }
  
  static final class k
    implements b.f
  {
    private String aPp;
    
    k(String paramString)
    {
      this.aPp = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      return false;
    }
    
    public final String toString()
    {
      return this.aPp;
    }
  }
  
  static final class l
    implements b.f
  {
    private boolean aOM;
    private String aON;
    
    public l(boolean paramBoolean, String paramString)
    {
      this.aOM = paramBoolean;
      this.aON = paramString;
    }
    
    public final boolean a(b.p paramp, h.al paramal)
    {
      AppMethodBeat.i(212933);
      label48:
      int j;
      if ((this.aOM) && (this.aON == null))
      {
        paramp = paramal.getNodeName();
        if (paramal.aSX == null) {
          break label105;
        }
        paramal = paramal.aSX.getChildren().iterator();
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
        paramp = this.aON;
        break;
        label105:
        j = 1;
        label108:
        if (j == 1)
        {
          AppMethodBeat.o(212933);
          return true;
        }
        AppMethodBeat.o(212933);
        return false;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(212934);
      if (this.aOM)
      {
        str = String.format("only-of-type <%s>", new Object[] { this.aON });
        AppMethodBeat.o(212934);
        return str;
      }
      String str = String.format("only-child", new Object[0]);
      AppMethodBeat.o(212934);
      return str;
    }
  }
  
  static final class m
    implements b.f
  {
    public final boolean a(b.p paramp, h.al paramal)
    {
      return paramal.aSX == null;
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
        if (paramal == paramp.aPs) {
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
    h.al aPs;
    
    public final String toString()
    {
      AppMethodBeat.i(212936);
      if (this.aPs != null)
      {
        String str = String.format("<%s id=\"%s\">", new Object[] { this.aPs.getNodeName(), this.aPs.id });
        AppMethodBeat.o(212936);
        return str;
      }
      AppMethodBeat.o(212936);
      return "";
    }
  }
  
  static final class s
  {
    b.d aPw;
    List<b.a> aPx;
    List<b.f> aPy;
    String tag;
    
    s(b.d paramd, String paramString)
    {
      AppMethodBeat.i(212944);
      this.aPw = null;
      this.tag = null;
      this.aPx = null;
      this.aPy = null;
      if (paramd != null) {}
      for (;;)
      {
        this.aPw = paramd;
        this.tag = paramString;
        AppMethodBeat.o(212944);
        return;
        paramd = b.d.aOv;
      }
    }
    
    final void a(String paramString1, b.b paramb, String paramString2)
    {
      AppMethodBeat.i(212945);
      if (this.aPx == null) {
        this.aPx = new ArrayList();
      }
      this.aPx.add(new b.a(paramString1, paramb, paramString2));
      AppMethodBeat.o(212945);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(212946);
      StringBuilder localStringBuilder = new StringBuilder();
      label40:
      label63:
      Object localObject2;
      if (this.aPw == b.d.aOw)
      {
        localStringBuilder.append("> ");
        if (this.tag != null) {
          break label162;
        }
        localObject1 = "*";
        localStringBuilder.append((String)localObject1);
        if (this.aPx == null) {
          break label221;
        }
        localObject1 = this.aPx.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label221;
        }
        localObject2 = (b.a)((Iterator)localObject1).next();
        localStringBuilder.append('[').append(((b.a)localObject2).name);
        switch (b.1.aOn[localObject2.aOp.ordinal()])
        {
        }
      }
      for (;;)
      {
        localStringBuilder.append(']');
        break label63;
        if (this.aPw != b.d.aOx) {
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
      if (this.aPy != null)
      {
        localObject1 = this.aPy.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (b.f)((Iterator)localObject1).next();
          localStringBuilder.append(':').append(localObject2);
        }
      }
      Object localObject1 = localStringBuilder.toString();
      AppMethodBeat.o(212946);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.b
 * JD-Core Version:    0.7.0.1
 */