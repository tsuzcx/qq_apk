package com.tencent.mm.plugin.comm.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.k;
import kotlin.n.n;
import kotlinx.coroutines.cb;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/comm/kvstat/StaticKvStat;", "", "()V", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a xfd;
  private static final ConcurrentHashMap<String, d> xfe;
  private static final ConcurrentHashMap<String, d> xff;
  private static ConcurrentHashMap<String, ConcurrentHashMap<String, d>> xfg;
  
  static
  {
    AppMethodBeat.i(260560);
    xfd = new a((byte)0);
    xfe = new ConcurrentHashMap();
    xff = new ConcurrentHashMap();
    xfg = new ConcurrentHashMap();
    AppMethodBeat.o(260560);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/comm/kvstat/StaticKvStat$Companion;", "", "()V", "INTERVAL_TIME", "", "MAX_COUNT", "", "SEPARATOR", "", "TAG", "cacheSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/comm/kvstat/Session;", "sessionMap", "getSessionMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setSessionMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "sessions", "clearCache", "", "sessionId", "commit", "force", "", "commitKey", "sessionKey", "clazz", "commitSession", "session", "commitWithStruct", "getReportValue", "key", "getReportValueLong", "getSession", "getSessionWithCache", "getSessionWithKeyCache", "sessionIdKey", "getStruct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "isEnumType", "methodType", "isNumber", "value", "isNumberType", "isStringType", "register", "report", "opeartionState", "Lcom/tencent/mm/plugin/comm/kvstat/OpeartionState;", "separator", "reportImpl", "reportJson", "valueKey", "reportJsonArray", "newItem", "tdName", "reportKey", "reportTask", "callback", "Lkotlin/Function0;", "toLong", "writeValue", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static int a(String paramString1, String paramString2, String paramString3, Object paramObject, c paramc, boolean paramBoolean, String paramString4)
    {
      AppMethodBeat.i(260577);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "key");
      s.u(paramString3, "valueKey");
      s.u(paramObject, "value");
      s.u(paramc, "opeartionState");
      s.u(paramString4, "tdName");
      paramString1 = amr(paramString1);
      Locale localLocale = Locale.getDefault();
      s.s(localLocale, "getDefault()");
      paramString2 = paramString2.toLowerCase(localLocale);
      s.s(paramString2, "(this as java.lang.String).toLowerCase(locale)");
      if (paramString1.xfa.get(paramString2) == null) {
        ((Map)paramString1.xfa).put(paramString2, new JSONArray());
      }
      paramString1 = paramString1.xfa.get(paramString2);
      if (paramString1 == null)
      {
        AppMethodBeat.o(260577);
        return 0;
      }
      if ((paramString1 instanceof JSONArray)) {}
      for (paramString1 = (JSONArray)paramString1; paramString1 == null; paramString1 = null)
      {
        AppMethodBeat.o(260577);
        return 0;
      }
      if (paramBoolean)
      {
        paramString2 = new JSONObject();
        paramString1.put(paramString2);
        paramString2.put(paramString4, paramString1.length());
        if (paramString2 != null)
        {
          if (paramc != c.xeT) {
            break label322;
          }
          paramc = e.xfd;
          paramString4 = paramString2.opt(paramString3);
          paramc = paramString4;
          if (paramString4 == null) {
            paramc = Integer.valueOf(0);
          }
          if (ew(paramc))
          {
            paramc = e.xfd;
            if (ew(paramObject))
            {
              paramc = e.xfd;
              paramString4 = paramString2.opt(paramString3);
              paramc = paramString4;
              if (paramString4 == null) {
                paramc = Integer.valueOf(0);
              }
              long l = ex(paramc);
              paramc = e.xfd;
              paramString2.put(paramString3, l + ex(paramObject));
            }
          }
        }
      }
      for (;;)
      {
        int i = paramString1.length();
        AppMethodBeat.o(260577);
        return i;
        paramString2 = paramString1.optJSONObject(paramString1.length() - 1);
        break;
        label322:
        paramString2.put(paramString3, paramObject);
      }
    }
    
    private static void a(d paramd)
    {
      AppMethodBeat.i(260612);
      Object localObject2;
      if (paramd.xeZ != null)
      {
        localObject1 = paramd.xeZ;
        s.checkNotNull(localObject1);
        localObject1 = localObject1.getClass().getDeclaredMethods();
        localObject2 = new k("^set");
        s.s(localObject1, "declaredMethods");
        int k = localObject1.length;
        int i = 0;
        if (i < k)
        {
          NullPointerException localNullPointerException = localObject1[i];
          Log.d("StaticKvStat", localNullPointerException.getName());
          Object localObject3 = localNullPointerException.getName();
          s.s(localObject3, "method.name");
          Object localObject4;
          if (((k)localObject2).bn((CharSequence)localObject3)) {
            try
            {
              localObject3 = localNullPointerException.getName();
              s.s(localObject3, "method.name");
              localObject3 = (String)n.a((CharSequence)localObject3, new String[] { "set" }).get(1);
              localObject4 = Locale.getDefault();
              s.s(localObject4, "getDefault()");
              if (localObject3 == null)
              {
                localNullPointerException = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(260612);
                throw localNullPointerException;
              }
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("StaticKvStat", (Throwable)localException, " writeValue  error", new Object[0]);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localObject3 = ((String)localObject3).toLowerCase((Locale)localObject4);
            s.s(localObject3, "(this as java.lang.String).toLowerCase(locale)");
            Object localObject5;
            Object localObject6;
            if (paramd.xfa.containsKey(localObject3))
            {
              localObject4 = paramd.xfa.get(localObject3);
              if (localObject4 != null)
              {
                localObject5 = localException.getParameterTypes()[0].getName();
                localObject6 = e.xfd;
                s.s(localObject5, "methodType");
                if (n.a((CharSequence)localObject5, (CharSequence)"Enum", true))
                {
                  localException.invoke(paramd.xeZ, new Object[] { localObject4 });
                }
                else
                {
                  localObject6 = e.xfd;
                  if (ams((String)localObject5))
                  {
                    localObject6 = e.xfd;
                    if (ew(localObject4))
                    {
                      if (n.a((CharSequence)localObject5, (CharSequence)"Int", true))
                      {
                        localObject5 = paramd.xeZ;
                        localObject6 = n.bJF(localObject4.toString());
                        if (localObject6 == null)
                        {
                          j = 0;
                          localException.invoke(localObject5, new Object[] { Integer.valueOf(j) });
                        }
                      }
                      while (!n.a((CharSequence)localObject5, (CharSequence)"Long", true)) {
                        for (;;)
                        {
                          Log.d("StaticKvStat", "writeValue success method name:" + localException.getName() + " fieldName:" + (String)localObject3 + ' ' + localObject4);
                          break;
                          int j = ((Integer)localObject6).intValue();
                        }
                      }
                      localObject5 = paramd.xeZ;
                      localObject6 = n.bJH(localObject4.toString());
                      if (localObject6 == null) {}
                      for (long l = 0L;; l = ((Long)localObject6).longValue())
                      {
                        localException.invoke(localObject5, new Object[] { Long.valueOf(l) });
                        break;
                      }
                    }
                  }
                  if ((n.a((CharSequence)localObject5, (CharSequence)"String", true)) && ((localObject4 instanceof String)))
                  {
                    localException.invoke(paramd.xeZ, new Object[] { localObject4 });
                    Log.d("StaticKvStat", "writeValue success method name:" + localException.getName() + " fieldName:" + (String)localObject3 + ' ' + localObject4);
                  }
                  else
                  {
                    if ((localObject4 instanceof a))
                    {
                      localObject6 = e.xfd;
                      if (amt((String)localObject5))
                      {
                        localException.invoke(paramd.xeZ, new Object[] { n.bV(localObject4.toString(), ",", "#") });
                        continue;
                      }
                    }
                    localObject6 = e.xfd;
                    if ((ams((String)localObject5)) && ((localObject4 instanceof HashMap)))
                    {
                      localException.invoke(paramd.xeZ, new Object[] { Integer.valueOf(((HashMap)localObject4).size()) });
                      Log.d("StaticKvStat", "writeValue success method name:" + localException.getName() + " fieldName:" + (String)localObject3 + ' ' + ((HashMap)localObject4).size());
                    }
                    else
                    {
                      if ((localObject4 instanceof JSONArray))
                      {
                        localObject3 = e.xfd;
                        if (amt((String)localObject5))
                        {
                          localException.invoke(paramd.xeZ, new Object[] { n.bV(localObject4.toString(), ",", ";") });
                          continue;
                        }
                      }
                      localObject3 = e.xfd;
                      if (amt((String)localObject5)) {
                        localException.invoke(paramd.xeZ, new Object[] { n.bV(localObject4.toString(), ",", "#") });
                      }
                    }
                  }
                }
              }
            }
            else if (paramd.xfc.containsKey(localObject3))
            {
              localObject4 = (JSONArray)paramd.xfc.get(localObject3);
              if (localObject4 != null)
              {
                localObject5 = paramd.xeZ;
                localObject6 = ((JSONArray)localObject4).toString();
                s.s(localObject6, "value.toString()");
                localException.invoke(localObject5, new Object[] { n.bV((String)localObject6, ",", ";") });
                Log.d("StaticKvStat", "writeValue success  method name:" + localException.getName() + " fieldName:" + (String)localObject3 + ' ' + localObject4 + " json array");
              }
            }
          }
        }
        localObject1 = paramd.xeZ;
        s.checkNotNull(localObject1);
        ((com.tencent.mm.plugin.report.a)localObject1).bMH();
      }
      if (paramd.xfb.size() > 0)
      {
        localObject1 = ((Map)paramd.xfb).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (((com.tencent.threadpool.i.d)((Map.Entry)localObject2).getValue()).isDone()) {
            ((com.tencent.threadpool.i.d)((Map.Entry)localObject2).getValue()).cancel(true);
          }
        }
      }
      Object localObject1 = ((Map)e.dsX()).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (s.p(((Map.Entry)localObject2).getValue(), paramd)) {
          e.dsX().remove(((Map.Entry)localObject2).getKey());
        }
      }
      AppMethodBeat.o(260612);
    }
    
    private static void a(d paramd, String paramString1, Object paramObject, c paramc, String paramString2)
    {
      AppMethodBeat.i(260594);
      s.u(paramd, "session");
      s.u(paramString1, "key");
      s.u(paramObject, "value");
      s.u(paramc, "opeartionState");
      s.u(paramString2, "separator");
      Object localObject = Locale.getDefault();
      s.s(localObject, "getDefault()");
      localObject = paramString1.toLowerCase((Locale)localObject);
      s.s(localObject, "(this as java.lang.String).toLowerCase(locale)");
      switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(260594);
        return;
        ((Map)paramd.xfa).put(localObject, paramObject);
        AppMethodBeat.o(260594);
        return;
        paramString1 = paramd.xfa.get(localObject);
        if (paramString1 == null)
        {
          ((Map)paramd.xfa).put(localObject, paramObject);
          AppMethodBeat.o(260594);
          return;
        }
        if ((ew(paramString1)) && (ew(paramObject)))
        {
          ((Map)paramd.xfa).put(localObject, Long.valueOf(ex(paramString1) + ex(paramObject)));
          AppMethodBeat.o(260594);
          return;
        }
        if (((paramString1 instanceof String)) && ((paramObject instanceof String))) {
          ((Map)paramd.xfa).put(localObject, paramString1 + paramString2 + paramObject);
        }
        Log.e("StaticKvStat", "report sessionid:" + paramd.id + " key:" + (String)localObject + " value:" + paramObject + " is not long value,append failed");
        ((Map)paramd.xfa).put(localObject, paramObject);
        AppMethodBeat.o(260594);
        return;
        paramc = (JSONArray)paramd.xfc.get(localObject);
        paramString1 = paramc;
        if (paramc == null)
        {
          paramString1 = new JSONArray();
          ((Map)paramd.xfc).put(localObject, paramString1);
        }
        paramd = new JSONObject();
        paramd.put("aid", paramObject);
        paramd.put("td", paramString1.length() + 1);
        paramString1.put(paramd);
        AppMethodBeat.o(260594);
        return;
        paramString1 = paramd.xfa.get(localObject);
        if (paramString1 == null)
        {
          ((Map)paramd.xfa).put(localObject, paramObject);
          AppMethodBeat.o(260594);
          return;
        }
        if ((ew(paramString1)) && (ew(paramObject)))
        {
          ((Map)paramd.xfa).put(localObject, Long.valueOf(ex(paramObject) - ex(paramString1)));
          AppMethodBeat.o(260594);
          return;
        }
        Log.e("StaticKvStat", "report sessionid:" + paramd.id + " key:" + (String)localObject + " value:" + paramObject + " is not long value,elapse failed");
        ((Map)paramd.xfa).put(localObject, paramObject);
        AppMethodBeat.o(260594);
        return;
        if (paramd.xfa.get(localObject) == null) {
          ((Map)paramd.xfa).put(localObject, new HashMap());
        }
        paramd = paramd.xfa.get(localObject);
        if ((paramd instanceof HashMap))
        {
          paramd = (HashMap)paramd;
          paramString1 = (Integer)paramd.get(paramObject);
          if (paramString1 != null)
          {
            ((Map)paramd).put(paramObject, Integer.valueOf(paramString1.intValue() + 1));
            AppMethodBeat.o(260594);
            return;
          }
          ((Map)paramd).put(paramObject, Integer.valueOf(1));
        }
      }
    }
    
    private static void a(d paramd, String paramString1, Object paramObject1, Object paramObject2, c paramc, String paramString2)
    {
      AppMethodBeat.i(260591);
      s.u(paramd, "session");
      s.u(paramString1, "key");
      s.u(paramObject1, "valueKey");
      s.u(paramObject2, "value");
      s.u(paramc, "opeartionState");
      s.u(paramString2, "separator");
      Locale localLocale = Locale.getDefault();
      s.s(localLocale, "getDefault()");
      paramString1 = paramString1.toLowerCase(localLocale);
      s.s(paramString1, "(this as java.lang.String).toLowerCase(locale)");
      if (paramd.xfa.get(paramString1) == null) {
        ((Map)paramd.xfa).put(paramString1, new a(paramString2));
      }
      paramd = paramd.xfa.get(paramString1);
      if ((paramd instanceof a))
      {
        paramd = (a)paramd;
        if (paramd.containsKey(paramObject1))
        {
          if (c.xeX == paramc)
          {
            ((Map)paramd).put(paramObject1, paramObject2);
            AppMethodBeat.o(260591);
            return;
          }
          if (c.xeT == paramc)
          {
            paramString1 = (Map)paramd;
            paramc = new StringBuilder();
            paramd = paramd.get(paramObject1);
            if ((paramd instanceof String)) {}
            for (paramd = (String)paramd;; paramd = null)
            {
              paramString1.put(paramObject1, paramd + paramString2 + paramObject2);
              AppMethodBeat.o(260591);
              return;
            }
          }
        }
        else
        {
          ((Map)paramd).put(paramObject1, paramObject2);
        }
      }
      AppMethodBeat.o(260591);
    }
    
    private static void a(d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(260620);
      for (;;)
      {
        if (paramd == null)
        {
          Log.e("StaticKvStat", "commit  session is null ");
          AppMethodBeat.o(260620);
          return;
        }
        if ((paramBoolean) || (paramd.xfb.size() == 0))
        {
          a(paramd);
          AppMethodBeat.o(260620);
          return;
        }
        paramd.nrQ += 1;
        if (paramd.nrQ <= 20) {
          break;
        }
        paramBoolean = true;
      }
      h.ahAA.p(new e.a..ExternalSyntheticLambda0(paramd), 100L);
      AppMethodBeat.o(260620);
    }
    
    private static void a(String paramString1, String paramString2, Object paramObject, c paramc, String paramString3)
    {
      AppMethodBeat.i(260570);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "key");
      s.u(paramObject, "value");
      s.u(paramc, "opeartionState");
      s.u(paramString3, "separator");
      a(amr(paramString1), paramString2, paramObject, paramc, paramString3);
      AppMethodBeat.o(260570);
    }
    
    public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, c paramc)
    {
      AppMethodBeat.i(260583);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "key");
      s.u(paramObject1, "valueKey");
      s.u(paramObject2, "value");
      s.u(paramc, "opeartionState");
      a(paramString1, paramString2, paramObject1, paramObject2, paramc, ";");
      AppMethodBeat.o(260583);
    }
    
    public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, c paramc, String paramString3)
    {
      AppMethodBeat.i(260587);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "key");
      s.u(paramObject1, "valueKey");
      s.u(paramObject2, "value");
      s.u(paramc, "opeartionState");
      s.u(paramString3, "separator");
      a(amr(paramString1), paramString2, paramObject1, paramObject2, paramc, paramString3);
      AppMethodBeat.o(260587);
    }
    
    private static void a(String paramString1, String paramString2, String paramString3, Object paramObject, c paramc, String paramString4)
    {
      AppMethodBeat.i(260566);
      s.u(paramString1, "sessionKey");
      s.u(paramString2, "sessionId");
      s.u(paramString3, "key");
      s.u(paramObject, "value");
      s.u(paramc, "opeartionState");
      s.u(paramString4, "separator");
      a(gu(paramString1, paramString2), paramString3, paramObject, paramc, paramString4);
      AppMethodBeat.o(260566);
    }
    
    public static void a(String paramString1, String paramString2, kotlin.g.a.a<? extends Object> parama)
    {
      AppMethodBeat.i(260597);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "key");
      s.u(parama, "callback");
      Object localObject = Locale.getDefault();
      s.s(localObject, "getDefault()");
      paramString2 = paramString2.toLowerCase((Locale)localObject);
      s.s(paramString2, "(this as java.lang.String).toLowerCase(locale)");
      localObject = amq(paramString1);
      if (localObject != null)
      {
        ConcurrentHashMap localConcurrentHashMap = ((d)localObject).xfb;
        localObject = (Map)localConcurrentHashMap;
        paramString1 = h.ahAA.bm(new e.a..ExternalSyntheticLambda1(paramString1, paramString2, parama, localConcurrentHashMap));
        s.s(paramString1, "INSTANCE.execute {\n     …ve(key)\n                }");
        ((Map)localObject).put(paramString2, paramString1);
      }
      AppMethodBeat.o(260597);
    }
    
    private static final void a(String paramString1, String paramString2, kotlin.g.a.a parama, ConcurrentHashMap paramConcurrentHashMap)
    {
      AppMethodBeat.i(260622);
      s.u(paramString1, "$sessionId");
      s.u(paramString2, "$key");
      s.u(parama, "$callback");
      s.u(paramConcurrentHashMap, "$asyncTasks");
      try
      {
        e.xfd.f(paramString1, paramString2, parama.invoke());
        paramConcurrentHashMap.remove(paramString2);
        AppMethodBeat.o(260622);
        return;
      }
      catch (Exception parama)
      {
        for (;;)
        {
          Log.printErrStackTrace("StaticKvStat", (Throwable)parama, " report job sessionId:" + paramString1 + ", key:" + paramString2 + ", job:" + cb.ajws, new Object[0]);
        }
      }
    }
    
    public static void aft(String paramString)
    {
      AppMethodBeat.i(260563);
      s.u(paramString, "sessionId");
      if (e.dsW().containsKey(paramString)) {
        e.dsW().remove(paramString);
      }
      AppMethodBeat.o(260563);
    }
    
    public static d amq(String paramString)
    {
      AppMethodBeat.i(260551);
      s.u(paramString, "sessionId");
      paramString = (d)e.dsX().get(paramString);
      AppMethodBeat.o(260551);
      return paramString;
    }
    
    public static d amr(String paramString)
    {
      AppMethodBeat.i(260555);
      s.u(paramString, "sessionId");
      Object localObject2 = (d)e.dsX().get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (d)e.dsW().get(paramString);
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new d();
        ((Map)e.dsW()).put(paramString, localObject2);
      }
      AppMethodBeat.o(260555);
      return localObject2;
    }
    
    private static boolean ams(String paramString)
    {
      AppMethodBeat.i(260601);
      if ((n.a((CharSequence)paramString, (CharSequence)"Int", true)) || (n.a((CharSequence)paramString, (CharSequence)"Long", true)))
      {
        AppMethodBeat.o(260601);
        return true;
      }
      AppMethodBeat.o(260601);
      return false;
    }
    
    private static boolean amt(String paramString)
    {
      AppMethodBeat.i(260604);
      boolean bool = n.a((CharSequence)paramString, (CharSequence)"String", true);
      AppMethodBeat.o(260604);
      return bool;
    }
    
    private static final void b(d paramd)
    {
      AppMethodBeat.i(260626);
      a locala = e.xfd;
      a(paramd, false);
      AppMethodBeat.o(260626);
    }
    
    private static boolean ew(Object paramObject)
    {
      return ((paramObject instanceof Long)) || ((paramObject instanceof Integer));
    }
    
    private static long ex(Object paramObject)
    {
      AppMethodBeat.i(260599);
      if ((paramObject instanceof Integer))
      {
        l = ((Number)paramObject).intValue();
        AppMethodBeat.o(260599);
        return l;
      }
      long l = ((Long)paramObject).longValue();
      AppMethodBeat.o(260599);
      return l;
    }
    
    public static void gt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(260541);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "clazz");
      if (e.dsW().containsKey(paramString1)) {}
      for (d locald = (d)e.dsW().get(paramString1);; locald = new d())
      {
        if (e.dsW().containsKey(paramString1)) {
          e.dsW().remove(paramString1);
        }
        Object localObject = Class.forName(paramString2).newInstance();
        if (!(localObject instanceof com.tencent.mm.plugin.report.a)) {
          break;
        }
        s.checkNotNull(locald);
        locald.xeZ = ((com.tencent.mm.plugin.report.a)localObject);
        if (e.dsX().containsKey(paramString1))
        {
          Log.e("StaticKvStat", "sessionid " + paramString1 + " is duplicate, should remove it");
          e.dsX().remove(paramString1);
        }
        ((Map)e.dsX()).put(paramString1, locald);
        AppMethodBeat.o(260541);
        return;
      }
      if (BuildInfo.DEBUG) {
        new IllegalAccessException("class name " + paramString2 + " is not AbsReportStruct");
      }
      AppMethodBeat.o(260541);
    }
    
    private static d gu(String paramString1, String paramString2)
    {
      AppMethodBeat.i(260558);
      s.u(paramString1, "sessionIdKey");
      s.u(paramString2, "sessionId");
      Object localObject = (ConcurrentHashMap)e.dsV().get(paramString1);
      if (localObject == null)
      {
        localObject = new ConcurrentHashMap();
        ((Map)e.dsV()).put(paramString1, localObject);
      }
      for (paramString1 = (String)localObject;; paramString1 = (String)localObject)
      {
        d locald = (d)paramString1.get(paramString2);
        localObject = locald;
        if (locald == null)
        {
          localObject = new d();
          ((Map)paramString1).put(paramString2, localObject);
        }
        AppMethodBeat.o(260558);
        return localObject;
      }
    }
    
    public static long gv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(260596);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "key");
      Locale localLocale = Locale.getDefault();
      s.s(localLocale, "getDefault()");
      paramString2 = paramString2.toLowerCase(localLocale);
      s.s(paramString2, "(this as java.lang.String).toLowerCase(locale)");
      paramString1 = amr(paramString1).xfa.get(paramString2);
      if (paramString1 != null) {
        try
        {
          long l = ((Long)paramString1).longValue();
          AppMethodBeat.o(260596);
          return l;
        }
        catch (Exception paramString1) {}
      }
      AppMethodBeat.o(260596);
      return 0L;
    }
    
    public static void gw(String paramString1, String paramString2)
    {
      AppMethodBeat.i(260616);
      s.u(paramString1, "sessionKey");
      s.u(paramString2, "clazz");
      Object localObject1 = (ConcurrentHashMap)e.dsV().get(paramString1);
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
          try
          {
            Object localObject2 = Class.forName(paramString2).newInstance();
            if ((localObject2 instanceof com.tencent.mm.plugin.report.a))
            {
              ((d)localEntry.getValue()).xeZ = ((com.tencent.mm.plugin.report.a)localObject2);
              localObject2 = e.xfd;
              a((d)localEntry.getValue(), true);
            }
          }
          catch (Exception localException)
          {
            Log.e("StaticKvStat", "commitKey, clazz:" + paramString2 + " is error", new Object[] { localException });
          }
        }
      }
      e.dsV().remove(paramString1);
      AppMethodBeat.o(260616);
    }
    
    public final void a(String paramString1, String paramString2, Object paramObject, c paramc)
    {
      AppMethodBeat.i(260638);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "key");
      s.u(paramObject, "value");
      s.u(paramc, "opeartionState");
      a(paramString1, paramString2, paramObject, paramc, "#");
      AppMethodBeat.o(260638);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, c paramc)
    {
      AppMethodBeat.i(260636);
      s.u(paramString1, "sessionKey");
      s.u(paramString2, "sessionId");
      s.u(paramString3, "key");
      s.u(paramObject, "value");
      s.u(paramc, "opeartionState");
      a(paramString1, paramString2, paramString3, paramObject, paramc, "#");
      AppMethodBeat.o(260636);
    }
    
    public final void amu(String paramString)
    {
      AppMethodBeat.i(260640);
      s.u(paramString, "sessionId");
      a(amq(paramString), false);
      AppMethodBeat.o(260640);
    }
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject)
    {
      AppMethodBeat.i(260635);
      s.u(paramString1, "sessionKey");
      s.u(paramString2, "sessionId");
      s.u(paramString3, "key");
      s.u(paramObject, "value");
      a(paramString1, paramString2, paramString3, paramObject, c.xeS, "#");
      AppMethodBeat.o(260635);
    }
    
    public final void f(String paramString1, String paramString2, Object paramObject)
    {
      AppMethodBeat.i(260637);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "key");
      s.u(paramObject, "value");
      a(paramString1, paramString2, paramObject, c.xeS, "#");
      AppMethodBeat.o(260637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.b.e
 * JD-Core Version:    0.7.0.1
 */