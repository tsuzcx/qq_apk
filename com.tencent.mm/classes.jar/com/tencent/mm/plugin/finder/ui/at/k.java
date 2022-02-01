package com.tencent.mm.plugin.finder.ui.at;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/RecentAtLogic;", "", "()V", "DAY_MILLI_SECONDS", "", "TAG", "", "addToRecentAt", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "username", "containsName", "", "list", "", "Lcom/tencent/mm/plugin/finder/ui/at/RecentAtBean;", "getIndex", "", "getListFromJSONStr", "", "json", "getRecentAtJSON", "getRecentAtList", "getValidDays", "isValidTime", "time", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k FWG;
  
  static
  {
    AppMethodBeat.i(347928);
    FWG = new k();
    AppMethodBeat.o(347928);
  }
  
  static List<j> aBf(String paramString)
  {
    AppMethodBeat.i(347921);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = (List)new ArrayList();
      AppMethodBeat.o(347921);
      return paramString;
    }
    for (;;)
    {
      int k;
      int j;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        if (localJSONArray.length() > 0)
        {
          ArrayList localArrayList = new ArrayList();
          i = 0;
          k = localJSONArray.length();
          if (k > 0)
          {
            j = i + 1;
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject == null) {
              break label265;
            }
            String str = localJSONObject.optString("name");
            paramString = str;
            if (str == null) {
              paramString = "";
            }
            paramString = new j(paramString, localJSONObject.optLong("time"));
            long l = paramString.time;
            l = (cn.bDu() - l) / 86400000L;
            if (l == 0L) {
              break label260;
            }
            if ((l >= ((c)h.ax(c.class)).a(c.a.zxb, 365)) || (l <= 0L)) {
              break label250;
            }
            break label260;
            label186:
            if (i == 0) {
              break label265;
            }
            localArrayList.add(paramString);
            break label265;
          }
          paramString = (List)localArrayList;
          AppMethodBeat.o(347921);
          return paramString;
        }
      }
      finally
      {
        Log.e("Finder.RecentAtLogic", "optListFromJSONStr err! %s", new Object[] { Util.stackTraceToString(paramString) });
        paramString = (List)new ArrayList();
        AppMethodBeat.o(347921);
        return paramString;
      }
      label250:
      int i = 0;
      continue;
      label260:
      label265:
      do
      {
        i = j;
        break;
        i = 1;
        break label186;
      } while (j < k);
    }
  }
  
  static String h(at.a parama)
  {
    AppMethodBeat.i(347907);
    parama = h.baE().ban().get(parama, "");
    if (parama == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(347907);
      throw parama;
    }
    parama = Util.nullAsNil((String)parama);
    s.s(parama, "nullAsNil((MMKernel.stor….get(key, \"\") as String))");
    AppMethodBeat.o(347907);
    return parama;
  }
  
  /* Error */
  public final void a(at.a parama, String paramString)
  {
    // Byte code:
    //   0: ldc 193
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 194
    //   8: invokestatic 197	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 198
    //   14: invokestatic 197	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_1
    //   18: invokestatic 200	com/tencent/mm/plugin/finder/ui/at/k:h	(Lcom/tencent/mm/storage/at$a;)Ljava/lang/String;
    //   21: invokestatic 202	com/tencent/mm/plugin/finder/ui/at/k:aBf	(Ljava/lang/String;)Ljava/util/List;
    //   24: astore 4
    //   26: aload 4
    //   28: invokeinterface 206 1 0
    //   33: astore 5
    //   35: aload 5
    //   37: invokeinterface 212 1 0
    //   42: ifeq +146 -> 188
    //   45: aload 5
    //   47: invokeinterface 216 1 0
    //   52: checkcast 95	com/tencent/mm/plugin/finder/ui/at/j
    //   55: getfield 219	com/tencent/mm/plugin/finder/ui/at/j:name	Ljava/lang/String;
    //   58: aload_2
    //   59: invokestatic 223	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   62: ifeq -27 -> 35
    //   65: iconst_1
    //   66: istore_3
    //   67: iload_3
    //   68: ifeq +53 -> 121
    //   71: aload 4
    //   73: invokeinterface 206 1 0
    //   78: astore 5
    //   80: iconst_0
    //   81: istore_3
    //   82: aload 5
    //   84: invokeinterface 212 1 0
    //   89: ifeq +111 -> 200
    //   92: aload 5
    //   94: invokeinterface 216 1 0
    //   99: checkcast 95	com/tencent/mm/plugin/finder/ui/at/j
    //   102: getfield 219	com/tencent/mm/plugin/finder/ui/at/j:name	Ljava/lang/String;
    //   105: aload_2
    //   106: invokestatic 223	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   109: ifeq +84 -> 193
    //   112: aload 4
    //   114: iload_3
    //   115: invokeinterface 227 2 0
    //   120: pop
    //   121: aload 4
    //   123: iconst_0
    //   124: new 95	com/tencent/mm/plugin/finder/ui/at/j
    //   127: dup
    //   128: aload_2
    //   129: invokestatic 112	com/tencent/mm/model/cn:bDu	()J
    //   132: invokespecial 103	com/tencent/mm/plugin/finder/ui/at/j:<init>	(Ljava/lang/String;J)V
    //   135: invokeinterface 230 3 0
    //   140: aload 4
    //   142: invokeinterface 233 1 0
    //   147: iconst_5
    //   148: if_icmple +70 -> 218
    //   151: aload 4
    //   153: ldc 235
    //   155: invokestatic 197	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokeinterface 237 1 0
    //   165: ifeq +40 -> 205
    //   168: new 239	java/util/NoSuchElementException
    //   171: dup
    //   172: ldc 241
    //   174: invokespecial 242	java/util/NoSuchElementException:<init>	(Ljava/lang/String;)V
    //   177: checkcast 244	java/lang/Throwable
    //   180: astore_1
    //   181: ldc 193
    //   183: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_1
    //   187: athrow
    //   188: iconst_0
    //   189: istore_3
    //   190: goto -123 -> 67
    //   193: iload_3
    //   194: iconst_1
    //   195: iadd
    //   196: istore_3
    //   197: goto -115 -> 82
    //   200: iconst_m1
    //   201: istore_3
    //   202: goto -90 -> 112
    //   205: aload 4
    //   207: aload 4
    //   209: invokestatic 250	kotlin/a/p:oE	(Ljava/util/List;)I
    //   212: invokeinterface 227 2 0
    //   217: pop
    //   218: new 73	org/json/JSONArray
    //   221: dup
    //   222: invokespecial 251	org/json/JSONArray:<init>	()V
    //   225: astore_2
    //   226: aload 4
    //   228: invokeinterface 206 1 0
    //   233: astore 4
    //   235: aload 4
    //   237: invokeinterface 212 1 0
    //   242: ifeq +85 -> 327
    //   245: aload 4
    //   247: invokeinterface 216 1 0
    //   252: checkcast 95	com/tencent/mm/plugin/finder/ui/at/j
    //   255: astore 6
    //   257: new 88	org/json/JSONObject
    //   260: dup
    //   261: invokespecial 252	org/json/JSONObject:<init>	()V
    //   264: astore 5
    //   266: aload 5
    //   268: ldc 86
    //   270: aload 6
    //   272: getfield 219	com/tencent/mm/plugin/finder/ui/at/j:name	Ljava/lang/String;
    //   275: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload 5
    //   281: ldc 96
    //   283: aload 6
    //   285: getfield 106	com/tencent/mm/plugin/finder/ui/at/j:time	J
    //   288: invokevirtual 259	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   291: pop
    //   292: aload_2
    //   293: aload 5
    //   295: invokevirtual 262	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   298: pop
    //   299: goto -64 -> 235
    //   302: astore 6
    //   304: ldc 138
    //   306: ldc_w 264
    //   309: iconst_1
    //   310: anewarray 4	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: aload 6
    //   317: invokevirtual 268	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   320: aastore
    //   321: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -32 -> 292
    //   327: aload_2
    //   328: invokevirtual 271	org/json/JSONArray:toString	()Ljava/lang/String;
    //   331: astore_2
    //   332: aload_2
    //   333: ldc_w 273
    //   336: invokestatic 191	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   339: ldc 138
    //   341: ldc_w 275
    //   344: aload_2
    //   345: invokestatic 279	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   348: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: invokestatic 161	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   354: invokevirtual 167	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   357: aload_1
    //   358: aload_2
    //   359: invokevirtual 286	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   362: ldc 193
    //   364: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	k
    //   0	368	1	parama	at.a
    //   0	368	2	paramString	String
    //   66	136	3	i	int
    //   24	222	4	localObject1	Object
    //   33	261	5	localObject2	Object
    //   255	29	6	localj	j
    //   302	14	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   266	292	302	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.k
 * JD-Core Version:    0.7.0.1
 */