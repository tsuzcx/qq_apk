package com.tencent.mm.plugin.expt.hellhound.ext.session.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.wz;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.e;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.l;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.protocal.protobuf.fya;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
{
  private static d zKE;
  public final IListener<wz> zKF;
  
  private d()
  {
    AppMethodBeat.i(122109);
    this.zKF = new HellSessionPageCloudConfig.1(this, f.hfK);
    AppMethodBeat.o(122109);
  }
  
  /* Error */
  private static ezf a(String paramString, long paramLong, List paramList, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: ldc 48
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 48
    //   11: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: astore 9
    //   19: iload 5
    //   21: iconst_2
    //   22: if_icmpne +52 -> 74
    //   25: aload_0
    //   26: invokestatic 54	com/tencent/mm/plugin/expt/hellhound/ext/session/d/e:ata	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 9
    //   31: aload 9
    //   33: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +561 -> 597
    //   39: ldc 62
    //   41: ldc 64
    //   43: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: ldc2_w 71
    //   49: invokestatic 78	com/tencent/mm/plugin/expt/hellhound/ext/session/e/l:jX	(J)V
    //   52: aload_3
    //   53: ifnull +12 -> 65
    //   56: aload_3
    //   57: invokeinterface 83 1 0
    //   62: ifeq +357 -> 419
    //   65: ldc2_w 84
    //   68: invokestatic 78	com/tencent/mm/plugin/expt/hellhound/ext/session/e/l:jX	(J)V
    //   71: aload_0
    //   72: astore 9
    //   74: ldc 62
    //   76: ldc 87
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload 9
    //   86: aastore
    //   87: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: new 92	org/json/JSONObject
    //   93: dup
    //   94: aload 9
    //   96: invokespecial 95	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   99: astore 9
    //   101: new 97	com/tencent/mm/protocal/protobuf/ezf
    //   104: dup
    //   105: invokespecial 98	com/tencent/mm/protocal/protobuf/ezf:<init>	()V
    //   108: astore_0
    //   109: aload_0
    //   110: aload 9
    //   112: ldc 100
    //   114: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 107	com/tencent/mm/protocal/protobuf/ezf:zIC	Ljava/lang/String;
    //   120: aload_0
    //   121: lload_1
    //   122: putfield 111	com/tencent/mm/protocal/protobuf/ezf:aajX	J
    //   125: aload_0
    //   126: aload 9
    //   128: ldc 113
    //   130: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: putfield 116	com/tencent/mm/protocal/protobuf/ezf:aajW	Ljava/lang/String;
    //   136: aload_0
    //   137: iload 4
    //   139: putfield 120	com/tencent/mm/protocal/protobuf/ezf:lAr	Z
    //   142: aload_0
    //   143: aload 9
    //   145: ldc 122
    //   147: iconst_1
    //   148: invokevirtual 126	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   151: putfield 129	com/tencent/mm/protocal/protobuf/ezf:type	I
    //   154: ldc 62
    //   156: ldc 131
    //   158: iconst_5
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: getfield 107	com/tencent/mm/protocal/protobuf/ezf:zIC	Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: aload_0
    //   172: getfield 111	com/tencent/mm/protocal/protobuf/ezf:aajX	J
    //   175: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   178: aastore
    //   179: dup
    //   180: iconst_2
    //   181: aload_0
    //   182: getfield 116	com/tencent/mm/protocal/protobuf/ezf:aajW	Ljava/lang/String;
    //   185: aastore
    //   186: dup
    //   187: iconst_3
    //   188: aload_0
    //   189: getfield 120	com/tencent/mm/protocal/protobuf/ezf:lAr	Z
    //   192: invokestatic 142	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   195: aastore
    //   196: dup
    //   197: iconst_4
    //   198: aload_0
    //   199: getfield 129	com/tencent/mm/protocal/protobuf/ezf:type	I
    //   202: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload 9
    //   211: ldc 149
    //   213: invokevirtual 153	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   216: astore 9
    //   218: aload 9
    //   220: ifnull +343 -> 563
    //   223: aload 9
    //   225: invokevirtual 159	org/json/JSONArray:length	()I
    //   228: istore 7
    //   230: iload 7
    //   232: ifle +331 -> 563
    //   235: new 161	java/util/ArrayList
    //   238: dup
    //   239: invokespecial 162	java/util/ArrayList:<init>	()V
    //   242: astore 10
    //   244: iconst_0
    //   245: istore 5
    //   247: iload 5
    //   249: iload 7
    //   251: if_icmpge +302 -> 553
    //   254: aload 9
    //   256: iload 5
    //   258: invokevirtual 166	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   261: astore 11
    //   263: aload 11
    //   265: ifnull +338 -> 603
    //   268: new 168	com/tencent/mm/protocal/protobuf/ezb
    //   271: dup
    //   272: invokespecial 169	com/tencent/mm/protocal/protobuf/ezb:<init>	()V
    //   275: astore 12
    //   277: aload 12
    //   279: aload 11
    //   281: ldc 171
    //   283: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: putfield 174	com/tencent/mm/protocal/protobuf/ezb:hJW	Ljava/lang/String;
    //   289: aload 11
    //   291: ldc 176
    //   293: invokevirtual 153	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   296: astore 13
    //   298: aload 13
    //   300: ifnull +232 -> 532
    //   303: aload 13
    //   305: invokevirtual 159	org/json/JSONArray:length	()I
    //   308: istore 8
    //   310: iload 8
    //   312: ifle +220 -> 532
    //   315: new 161	java/util/ArrayList
    //   318: dup
    //   319: invokespecial 162	java/util/ArrayList:<init>	()V
    //   322: astore 14
    //   324: iconst_0
    //   325: istore 6
    //   327: iload 6
    //   329: iload 8
    //   331: if_icmpge +190 -> 521
    //   334: aload 13
    //   336: iload 6
    //   338: invokevirtual 166	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   341: astore 15
    //   343: aload 15
    //   345: ifnull +65 -> 410
    //   348: new 178	com/tencent/mm/protocal/protobuf/eag
    //   351: dup
    //   352: invokespecial 179	com/tencent/mm/protocal/protobuf/eag:<init>	()V
    //   355: astore 16
    //   357: aload 16
    //   359: aload 15
    //   361: ldc 181
    //   363: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   366: putfield 183	com/tencent/mm/protocal/protobuf/eag:className	Ljava/lang/String;
    //   369: aload 16
    //   371: aload 15
    //   373: ldc 185
    //   375: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   378: putfield 187	com/tencent/mm/protocal/protobuf/eag:dataPath	Ljava/lang/String;
    //   381: aload 16
    //   383: aload 15
    //   385: ldc 189
    //   387: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield 191	com/tencent/mm/protocal/protobuf/eag:action	Ljava/lang/String;
    //   393: aload 16
    //   395: aload_3
    //   396: iconst_0
    //   397: invokestatic 194	com/tencent/mm/plugin/expt/hellhound/ext/session/config/d:a	(Lcom/tencent/mm/protocal/protobuf/eag;Ljava/util/List;Z)V
    //   400: aload 14
    //   402: aload 16
    //   404: invokeinterface 198 2 0
    //   409: pop
    //   410: iload 6
    //   412: iconst_1
    //   413: iadd
    //   414: istore 6
    //   416: goto -89 -> 327
    //   419: aload_3
    //   420: invokeinterface 202 1 0
    //   425: astore 10
    //   427: aload_0
    //   428: astore 9
    //   430: aload 10
    //   432: invokeinterface 207 1 0
    //   437: ifeq -363 -> 74
    //   440: aload 10
    //   442: invokeinterface 211 1 0
    //   447: astore 9
    //   449: aload 9
    //   451: instanceof 213
    //   454: ifeq -27 -> 427
    //   457: aload 9
    //   459: checkcast 213	com/tencent/mm/protocal/protobuf/dfj
    //   462: astore 9
    //   464: ldc 62
    //   466: ldc 215
    //   468: iconst_2
    //   469: anewarray 4	java/lang/Object
    //   472: dup
    //   473: iconst_0
    //   474: aload 9
    //   476: getfield 218	com/tencent/mm/protocal/protobuf/dfj:key	Ljava/lang/String;
    //   479: aastore
    //   480: dup
    //   481: iconst_1
    //   482: aload 9
    //   484: getfield 221	com/tencent/mm/protocal/protobuf/dfj:onf	Ljava/lang/String;
    //   487: aastore
    //   488: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   491: goto -64 -> 427
    //   494: astore_0
    //   495: ldc 62
    //   497: aload_0
    //   498: ldc 223
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: aload_0
    //   507: invokevirtual 227	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   510: aastore
    //   511: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   514: ldc 48
    //   516: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   519: aconst_null
    //   520: areturn
    //   521: aload 12
    //   523: getfield 235	com/tencent/mm/protocal/protobuf/ezb:abAf	Ljava/util/LinkedList;
    //   526: aload 14
    //   528: invokevirtual 241	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   531: pop
    //   532: aload 11
    //   534: aload_3
    //   535: aload 12
    //   537: invokestatic 244	com/tencent/mm/plugin/expt/hellhound/ext/session/config/d:a	(Lorg/json/JSONObject;Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/ezb;)V
    //   540: aload 10
    //   542: aload 12
    //   544: invokeinterface 198 2 0
    //   549: pop
    //   550: goto +53 -> 603
    //   553: aload_0
    //   554: getfield 247	com/tencent/mm/protocal/protobuf/ezf:abAl	Ljava/util/LinkedList;
    //   557: aload 10
    //   559: invokevirtual 241	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   562: pop
    //   563: ldc 48
    //   565: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   568: aload_0
    //   569: areturn
    //   570: astore_0
    //   571: ldc 62
    //   573: aload_0
    //   574: ldc 249
    //   576: iconst_1
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: aload_0
    //   583: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   586: aastore
    //   587: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   590: ldc 48
    //   592: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   595: aconst_null
    //   596: areturn
    //   597: aload 9
    //   599: astore_0
    //   600: goto -548 -> 52
    //   603: iload 5
    //   605: iconst_1
    //   606: iadd
    //   607: istore 5
    //   609: goto -362 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	paramString	String
    //   0	612	1	paramLong	long
    //   0	612	3	paramList	List
    //   0	612	4	paramBoolean	boolean
    //   0	612	5	paramInt	int
    //   325	90	6	i	int
    //   228	24	7	j	int
    //   308	24	8	k	int
    //   17	581	9	localObject1	Object
    //   242	316	10	localObject2	Object
    //   261	272	11	localJSONObject1	JSONObject
    //   275	268	12	localezb	ezb
    //   296	39	13	localJSONArray	JSONArray
    //   322	205	14	localArrayList	ArrayList
    //   341	43	15	localJSONObject2	JSONObject
    //   355	48	16	localeag	eag
    // Exception table:
    //   from	to	target	type
    //   90	101	494	org/json/JSONException
    //   101	218	570	java/lang/Exception
    //   223	230	570	java/lang/Exception
    //   235	244	570	java/lang/Exception
    //   254	263	570	java/lang/Exception
    //   268	298	570	java/lang/Exception
    //   303	310	570	java/lang/Exception
    //   315	324	570	java/lang/Exception
    //   334	343	570	java/lang/Exception
    //   348	410	570	java/lang/Exception
    //   521	532	570	java/lang/Exception
    //   532	550	570	java/lang/Exception
    //   553	563	570	java/lang/Exception
  }
  
  private static void a(eag parameag, List paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(300240);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if ((localObject instanceof dfj))
        {
          localObject = (dfj)localObject;
          if (parameag.className.equals(((dfj)localObject).key))
          {
            parameag.abfo = ((dfj)localObject).onf;
            if (TextUtils.isEmpty(parameag.abfo)) {
              l.jX(124L);
            }
            for (;;)
            {
              Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "paramPaoguard, classNameProguard: %s, %s, %b", new Object[] { ((dfj)localObject).key, ((dfj)localObject).onf, Boolean.valueOf(paramBoolean) });
              break;
              l.jX(138L);
            }
          }
          if (parameag.dataPath.equals(((dfj)localObject).key))
          {
            parameag.abfp = new dfj();
            dfj localdfj = parameag.abfp;
            int i;
            if (paramBoolean)
            {
              i = 0;
              label182:
              localdfj.type = i;
              parameag.abfp.key = parameag.dataPath;
              parameag.abfp.onf = ((dfj)localObject).onf;
              if ((!TextUtils.isEmpty(parameag.dataPath)) && (!TextUtils.isEmpty(((dfj)localObject).onf))) {
                break label293;
              }
              l.jX(125L);
            }
            for (;;)
            {
              Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "paramPaoguard, dataPathProguard: type=%s, key=%s, val=%s, isView=%b", new Object[] { Integer.valueOf(parameag.abfp.type), parameag.dataPath, ((dfj)localObject).onf, Boolean.valueOf(paramBoolean) });
              break;
              i = 1;
              break label182;
              label293:
              l.jX(139L);
            }
          }
        }
      }
    }
    AppMethodBeat.o(300240);
  }
  
  private static void a(JSONObject paramJSONObject, List paramList, ezb paramezb)
  {
    AppMethodBeat.i(300238);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("viewOp");
    if (localJSONArray != null)
    {
      int k = localJSONArray.length();
      if (k > 0)
      {
        Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, viewOpArrayLength=%d", new Object[] { Integer.valueOf(k) });
        int i = 0;
        while (i < k)
        {
          Object localObject1 = localJSONArray.optJSONObject(i);
          if (localObject1 != null)
          {
            fya localfya = new fya();
            localfya.type = ((JSONObject)localObject1).optInt("type");
            localfya.abVR = ((JSONObject)localObject1).optString("viewId");
            localfya.ctp = ((JSONObject)localObject1).optString("class");
            localfya.action = ((JSONObject)localObject1).optInt("action");
            Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, class=%s, resName=%s, type=%d", new Object[] { localfya.ctp, localfya.abVR, Integer.valueOf(localfya.type) });
            Object localObject2;
            if ((paramList != null) && (!paramList.isEmpty()))
            {
              localObject2 = paramList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                paramJSONObject = ((Iterator)localObject2).next();
                if ((paramJSONObject instanceof dfj))
                {
                  paramJSONObject = (dfj)paramJSONObject;
                  Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, resName=%s, key=%s, val=%s", new Object[] { localfya.abVR, paramJSONObject.key, paramJSONObject.onf });
                  if (localfya.abVR.equals(paramJSONObject.key))
                  {
                    boolean bool = TextUtils.isEmpty(paramJSONObject.onf);
                    if (bool) {}
                    for (paramJSONObject = localfya.abVR;; paramJSONObject = paramJSONObject.onf)
                    {
                      localfya.viewId = paramJSONObject;
                      if (!bool) {
                        break label319;
                      }
                      l.jX(126L);
                      break;
                    }
                    label319:
                    l.jX(136L);
                  }
                  else if (localfya.ctp.equals(paramJSONObject.key))
                  {
                    localfya.abVW = paramJSONObject.onf;
                    if (TextUtils.isEmpty(paramJSONObject.onf)) {
                      l.jX(127L);
                    } else {
                      l.jX(137L);
                    }
                  }
                }
              }
            }
            paramJSONObject = ((JSONObject)localObject1).optJSONArray("businessParams");
            if (paramJSONObject != null)
            {
              int m = paramJSONObject.length();
              if (m > 0)
              {
                Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, viewOpParamJArraySize=%d", new Object[] { Integer.valueOf(m) });
                localObject1 = new ArrayList();
                int j = 0;
                while (j < m)
                {
                  localObject2 = paramJSONObject.optJSONObject(j);
                  if (localObject2 != null)
                  {
                    eag localeag = new eag();
                    localeag.className = ((JSONObject)localObject2).optString("className");
                    localeag.dataPath = ((JSONObject)localObject2).optString("dataPath");
                    a(localeag, paramList, true);
                    Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, pageParam.className=%s, pageParam.dataPath=%s, ", new Object[] { localeag.className, localeag.dataPath });
                    ((List)localObject1).add(localeag);
                  }
                  j += 1;
                }
                localfya.abAf.addAll((Collection)localObject1);
                Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, viewOp.businessParams=%d", new Object[] { Integer.valueOf(localfya.abAf.size()) });
              }
            }
            paramezb.abAg.addLast(localfya);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(300238);
  }
  
  public static d dLN()
  {
    AppMethodBeat.i(122108);
    if (zKE == null) {}
    try
    {
      if (zKE == null) {
        zKE = new d();
      }
      d locald = zKE;
      AppMethodBeat.o(122108);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(122108);
    }
  }
  
  public static ezc dLO()
  {
    AppMethodBeat.i(122110);
    ezc localezc = e.dMb();
    AppMethodBeat.o(122110);
    return localezc;
  }
  
  public static ezf mg(long paramLong)
  {
    AppMethodBeat.i(300228);
    Object localObject = e.dMb();
    if ((localObject == null) || (((ezc)localObject).abAh.isEmpty()))
    {
      AppMethodBeat.o(300228);
      return null;
    }
    localObject = ((ezc)localObject).abAh.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ezf localezf = (ezf)((Iterator)localObject).next();
      if ((localezf != null) && (localezf.aajX == paramLong))
      {
        AppMethodBeat.o(300228);
        return localezf;
      }
    }
    AppMethodBeat.o(300228);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.config.d
 * JD-Core Version:    0.7.0.1
 */