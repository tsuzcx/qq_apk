package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.f;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  static String a(bjw parambjw, String paramString)
  {
    AppMethodBeat.i(195294);
    Object localObject = parambjw.EZo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ccs localccs = (ccs)((Iterator)localObject).next();
      if ((localccs != null) && (localccs.sessionId.equals(paramString)))
      {
        parambjw = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abf(localccs.FqZ);
        AppMethodBeat.o(195294);
        return parambjw;
      }
    }
    parambjw = parambjw.EZq.iterator();
    while (parambjw.hasNext())
    {
      localObject = (cco)parambjw.next();
      if ((localObject != null) && ((((cco)localObject).dnh.equals(paramString)) || ((((cco)localObject).qoi + "_" + ((cco)localObject).startTime).equals(paramString))))
      {
        parambjw = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abf(((cco)localObject).FqZ);
        AppMethodBeat.o(195294);
        return parambjw;
      }
    }
    AppMethodBeat.o(195294);
    return null;
  }
  
  private static List<c<String, String>> a(bjw parambjw, bjt parambjt, ccs paramccs)
  {
    AppMethodBeat.i(177400);
    parambjt = j.d(parambjt);
    paramccs = i.a(parambjt, paramccs);
    i.V(paramccs);
    ac.w("HellSessionPageDetailReport", "HABBYGE-MALI, SessionPageDetail, toJson, flow: %d, %d", new Object[] { Integer.valueOf(parambjt.size()), Integer.valueOf(paramccs.size()) });
    if ((parambjt.isEmpty()) || (paramccs.isEmpty()))
    {
      ac.i("HellSessionPageDetailReport", "HABBYGE-MALI, SessionPageDetail, toJson, PageFlowMap Empty: %d", new Object[] { Integer.valueOf(paramccs.size()) });
      AppMethodBeat.o(177400);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramccs.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      parambjt = (List)((Map.Entry)localIterator1.next()).getValue();
      if (!parambjt.isEmpty())
      {
        cvy localcvy1 = (cvy)parambjt.get(0);
        if (localcvy1.rAJ)
        {
          JSONObject localJSONObject1 = i.j(parambjw);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            Iterator localIterator2 = parambjt.iterator();
            while (localIterator2.hasNext())
            {
              cvy localcvy2 = (cvy)localIterator2.next();
              ac.d("HellSessionPageDetailReport", "HABBYGE-MALI, HellSessionPageDetaiReport, toJson, flow: %s, %s, %b, %d", new Object[] { Long.valueOf(localcvy2.EJj), localcvy2.dnh, Boolean.valueOf(localcvy2.FGA), Integer.valueOf(localcvy2.FGB.size()) });
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localcvy2.EJj);
                localJSONObject2.put("sessionId", localcvy2.dnh);
                paramccs = a(parambjw, localcvy2.dnh);
                parambjt = paramccs;
                if (paramccs == null) {
                  parambjt = "";
                }
                localJSONObject2.put("lastSessionId", parambjt);
                localJSONObject2.put("pagePath", a(localcvy2.FGB, localJSONObject2));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception parambjt)
              {
                ac.printErrStackTrace("HellSessionPageDetailReport", parambjt, "HABBYGE-MALI, toJson, crash-1: %s", new Object[] { parambjt.getMessage() });
              }
            }
            if (localJSONArray.length() > 0) {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                if (!TextUtils.isEmpty(localcvy1.EJi))
                {
                  ac.i("HellSessionPageDetailReport", "HABBYGE-MALI, SessionPageDetail, sidJSONObject: %s", new Object[] { localJSONObject1.toString() });
                  localArrayList.add(com.tencent.mm.vending.j.a.L(localcvy1.EJi, localJSONObject1.toString()));
                }
              }
              catch (Exception parambjt)
              {
                ac.printErrStackTrace("HellSessionPageDetailReport", parambjt, "HABBYGE-MALI, createJSONObjectHead, crash-2: %s", new Object[] { parambjt.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(177400);
    return localArrayList;
  }
  
  private static JSONArray a(List<bju> paramList, JSONObject paramJSONObject)
  {
    long l1 = 0L;
    AppMethodBeat.i(169360);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        bju localbju = (bju)paramList.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("pageName", localbju.qoi);
        localJSONObject.put("tbe", localbju.startTime);
        long l2 = Math.max(localbju.duration, 0L);
        localJSONObject.put("in", l2);
        l1 += l2;
        if (i == 0) {
          paramJSONObject.put("tbe", localbju.startTime);
        }
        j.a(localJSONObject, localbju, false);
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      paramJSONObject.put("in", Math.max(l1, 0L));
    }
    catch (JSONException paramList)
    {
      for (;;)
      {
        ac.printErrStackTrace("HellSessionPageDetailReport", paramList, "HABBYGE-MALI, createPagePathJsonArray json crash", new Object[0]);
      }
    }
    AppMethodBeat.o(169360);
    return localJSONArray;
  }
  
  static void a(bjw parambjw, bjt parambjt, aqd paramaqd, ccs paramccs)
  {
    AppMethodBeat.i(177399);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      ac.e("HellSessionPageDetailReport", "HABBYGE-MALI, SessionPageDetail, report: fetchHellhoundConfig FALSE !!");
      AppMethodBeat.o(177399);
      return;
    }
    parambjt = a(parambjw, parambjt, paramccs);
    if (parambjt == null) {
      ac.e("HellSessionPageDetailReport", "HABBYGE-MALI, SessionPageDetail, _reportSessionPage: logIdJsonList == null !!");
    }
    for (;;)
    {
      cZ(b.a(parambjw, paramaqd));
      AppMethodBeat.o(177399);
      return;
      ac.i("HellSessionPageDetailReport", "HABBYGE-MALI, SessionPageDetail: %d", new Object[] { Integer.valueOf(parambjt.size()) });
      cZ(parambjt);
    }
  }
  
  private static void cZ(List<c<String, String>> paramList)
  {
    AppMethodBeat.i(122238);
    if (da(h(paramList, f.ckW()))) {
      f.te(System.currentTimeMillis());
    }
    AppMethodBeat.o(122238);
  }
  
  /* Error */
  private static boolean da(List<c<String, String>> paramList)
  {
    // Byte code:
    //   0: ldc_w 357
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +12 -> 19
    //   10: aload_0
    //   11: invokeinterface 161 1 0
    //   16: ifeq +11 -> 27
    //   19: ldc_w 357
    //   22: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: ldc 116
    //   29: ldc_w 359
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: invokeinterface 273 1 0
    //   44: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: invokestatic 143	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: invokeinterface 179 1 0
    //   57: astore_0
    //   58: iconst_0
    //   59: istore_2
    //   60: aload_0
    //   61: invokeinterface 31 1 0
    //   66: ifeq +199 -> 265
    //   69: aload_0
    //   70: invokeinterface 35 1 0
    //   75: checkcast 361	com/tencent/mm/vending/j/c
    //   78: astore_3
    //   79: aload_3
    //   80: iconst_1
    //   81: invokevirtual 362	com/tencent/mm/vending/j/c:get	(I)Ljava/lang/Object;
    //   84: checkcast 43	java/lang/String
    //   87: astore 4
    //   89: aload 4
    //   91: ifnull +126 -> 217
    //   94: new 206	org/json/JSONObject
    //   97: dup
    //   98: aload 4
    //   100: invokespecial 365	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   103: ldc 245
    //   105: invokevirtual 369	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   108: astore 5
    //   110: aload 5
    //   112: invokevirtual 243	org/json/JSONArray:length	()I
    //   115: ifle +102 -> 217
    //   118: iconst_0
    //   119: istore_1
    //   120: iload_1
    //   121: aload 5
    //   123: invokevirtual 243	org/json/JSONArray:length	()I
    //   126: if_icmpge +91 -> 217
    //   129: aload 5
    //   131: iload_1
    //   132: invokevirtual 373	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   135: astore 6
    //   137: aload 6
    //   139: ifnull +47 -> 186
    //   142: aload 6
    //   144: ldc 209
    //   146: lconst_0
    //   147: invokevirtual 377	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   150: ldc2_w 378
    //   153: lcmp
    //   154: ifne +32 -> 186
    //   157: ldc 116
    //   159: ldc_w 381
    //   162: invokestatic 383	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: getstatic 389	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   168: sipush 19354
    //   171: iconst_1
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: bipush 9
    //   179: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokevirtual 393	com/tencent/mm/plugin/report/e:f	(I[Ljava/lang/Object;)V
    //   186: iload_1
    //   187: iconst_1
    //   188: iadd
    //   189: istore_1
    //   190: goto -70 -> 120
    //   193: astore 5
    //   195: ldc 116
    //   197: aload 5
    //   199: ldc_w 395
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload 5
    //   210: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   213: aastore
    //   214: invokestatic 240	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: ldc 116
    //   219: ldc_w 397
    //   222: iconst_2
    //   223: anewarray 4	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: aload_3
    //   229: iconst_0
    //   230: invokevirtual 400	com/tencent/mm/vending/j/b:get	(I)Ljava/lang/Object;
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload 4
    //   238: aastore
    //   239: invokestatic 143	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload_3
    //   243: iconst_0
    //   244: invokevirtual 400	com/tencent/mm/vending/j/b:get	(I)Ljava/lang/Object;
    //   247: checkcast 43	java/lang/String
    //   250: iconst_m1
    //   251: invokestatic 406	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   254: aload 4
    //   256: invokestatic 412	com/tencent/mm/plugin/expt/hellhound/a/f/f/d:aO	(ILjava/lang/String;)Z
    //   259: pop
    //   260: iconst_1
    //   261: istore_2
    //   262: goto -202 -> 60
    //   265: ldc_w 357
    //   268: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: iload_2
    //   272: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramList	List<c<String, String>>
    //   119	71	1	i	int
    //   59	213	2	bool	boolean
    //   78	165	3	localc	c
    //   87	168	4	str	String
    //   108	22	5	localJSONArray	JSONArray
    //   193	16	5	localException	Exception
    //   135	8	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   94	118	193	java/lang/Exception
    //   120	137	193	java/lang/Exception
    //   142	186	193	java/lang/Exception
  }
  
  private static List<c<String, String>> h(List<c<String, String>> paramList, String paramString)
  {
    AppMethodBeat.i(184380);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184380);
      return paramList;
    }
    Object localObject1 = paramList;
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        String[] arrayOfString = paramString.split("\\|");
        localObject1 = paramList;
        i = arrayOfString.length;
        if (i <= 0)
        {
          AppMethodBeat.o(184380);
          return paramList;
        }
        localObject1 = paramList;
        if (arrayOfString.length == 1)
        {
          localObject1 = paramList;
          arrayOfString = arrayOfString[0].split("-");
          localObject1 = paramList;
          i = arrayOfString.length;
          if (i != 2)
          {
            AppMethodBeat.o(184380);
            return paramList;
          }
          paramString = paramList;
          if (paramList == null)
          {
            localObject1 = paramList;
            paramString = new ArrayList();
          }
          localObject1 = paramString;
          paramString.add(com.tencent.mm.vending.j.a.L(arrayOfString[0], arrayOfString[1]));
          AppMethodBeat.o(184380);
          return paramString;
        }
        localObject1 = paramList;
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          localObject2 = arrayOfString[i];
          paramString = paramList;
          if (localObject2 != null) {
            localObject1 = paramList;
          }
        }
      }
      catch (Exception paramList) {}
      try
      {
        localObject2 = ((String)localObject2).split("-");
        paramString = paramList;
        localObject1 = paramList;
        if (localObject2.length == 2)
        {
          paramString = paramList;
          if (paramList == null)
          {
            localObject1 = paramList;
            paramString = new ArrayList();
          }
          localObject1 = paramString;
          paramString.add(com.tencent.mm.vending.j.a.L(localObject2[0], localObject2[1]));
        }
        i += 1;
        paramList = paramString;
      }
      catch (Exception paramList)
      {
        break label255;
      }
    }
    AppMethodBeat.o(184380);
    return paramList;
    label255:
    ac.printErrStackTrace("HellSessionPageDetailReport", paramList, "HABBYGE-MALI, restoreSessionMap crash: %s", new Object[] { paramList.getMessage() });
    AppMethodBeat.o(184380);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.g
 * JD-Core Version:    0.7.0.1
 */