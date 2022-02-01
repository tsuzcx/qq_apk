package com.tencent.mm.plugin.freewifi.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  static Pattern wQA;
  private static volatile boolean wQy;
  static Pattern wQz;
  
  static
  {
    AppMethodBeat.i(24942);
    wQy = true;
    wQz = Pattern.compile("\"result\":(-?[0-9]+)");
    wQA = Pattern.compile("\"stageName\":\"(.+?)\"");
    AppMethodBeat.o(24942);
  }
  
  static String aJ(LinkedList<bfl> paramLinkedList)
  {
    AppMethodBeat.i(24941);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      AppMethodBeat.o(24941);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      paramLinkedList = (bfl)localIterator.next();
      localStringBuilder.append("|id=").append(m.axL(paramLinkedList.id)).append("|");
      String[] arrayOfString = m.axL(paramLinkedList.LPd).split("\\},");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Matcher localMatcher = wQA.matcher(str);
        paramLinkedList = "";
        if (localMatcher.find()) {
          paramLinkedList = localMatcher.group(1);
        }
        localMatcher = wQz.matcher(str);
        str = "0";
        if (localMatcher.find()) {
          str = localMatcher.group(1);
        }
        localStringBuilder.append(k.axK(paramLinkedList) + "=" + str).append("|");
        i += 1;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(24941);
    return paramLinkedList;
  }
  
  public static void pl(int paramInt)
  {
    AppMethodBeat.i(24940);
    j.dNr().dMZ().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24939);
        if (!b.wQy)
        {
          AppMethodBeat.o(24939);
          return;
        }
        if (this.wQB == 0)
        {
          long l = System.currentTimeMillis() - i.a.dME().Fk("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
          Log.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : ".concat(String.valueOf(l)));
          if ((l >= 0L) && (l <= 86400000L))
          {
            Log.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
            AppMethodBeat.o(24939);
            return;
          }
          i.a.dME().at("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
        }
        b.access$002(false);
        Object localObject1 = j.dNp();
        m.a("FreeWifiLog", f.wQE, (MAutoStorage)localObject1, "MicroMsg.FreeWifi.FreeWifiLogStorage");
        Object localObject2 = ((f)localObject1).rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
        localObject1 = new LinkedList();
        while ((localObject2 != null) && (((Cursor)localObject2).moveToNext()))
        {
          bfl localbfl = new bfl();
          localbfl.id = ((Cursor)localObject2).getString(0);
          localbfl.wPz = ((Cursor)localObject2).getInt(1);
          localbfl.LPd = ((Cursor)localObject2).getString(2);
          localbfl.LPe = ((Cursor)localObject2).getLong(3);
          ((LinkedList)localObject1).add(localbfl);
        }
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
        localObject2 = "ServerReportSimpleLog:" + b.aJ((LinkedList)localObject1);
        m.axP((String)localObject2);
        Log.i("MicroMsg.FreeWifi.FreeWifiServerReporter", (String)localObject2);
        if (((LinkedList)localObject1).size() > 0)
        {
          new e((LinkedList)localObject1).c(new com.tencent.mm.ak.i()
          {
            /* Error */
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.q paramAnonymous2q)
            {
              // Byte code:
              //   0: sipush 24938
              //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   6: ldc 32
              //   8: ldc 34
              //   10: iconst_3
              //   11: anewarray 4	java/lang/Object
              //   14: dup
              //   15: iconst_0
              //   16: iload_1
              //   17: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   20: aastore
              //   21: dup
              //   22: iconst_1
              //   23: iload_2
              //   24: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   27: aastore
              //   28: dup
              //   29: iconst_2
              //   30: aload_3
              //   31: aastore
              //   32: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   35: iload_1
              //   36: iload_2
              //   37: invokestatic 51	com/tencent/mm/plugin/freewifi/m:gB	(II)Z
              //   40: ifeq +187 -> 227
              //   43: aload 4
              //   45: checkcast 53	com/tencent/mm/plugin/freewifi/d/e
              //   48: invokevirtual 57	com/tencent/mm/plugin/freewifi/d/e:dNB	()Ljava/util/LinkedList;
              //   51: astore 4
              //   53: aload 4
              //   55: ifnull +172 -> 227
              //   58: aload 4
              //   60: invokevirtual 63	java/util/LinkedList:size	()I
              //   63: ifle +164 -> 227
              //   66: invokestatic 69	com/tencent/mm/plugin/freewifi/model/j:dNp	()Lcom/tencent/mm/plugin/freewifi/g/f;
              //   69: astore_3
              //   70: aload 4
              //   72: invokevirtual 73	java/util/LinkedList:iterator	()Ljava/util/Iterator;
              //   75: astore 4
              //   77: aload 4
              //   79: invokeinterface 79 1 0
              //   84: ifeq +143 -> 227
              //   87: aload 4
              //   89: invokeinterface 83 1 0
              //   94: checkcast 85	com/tencent/mm/protocal/protobuf/bfl
              //   97: astore 6
              //   99: aload 6
              //   101: getfield 89	com/tencent/mm/protocal/protobuf/bfl:id	Ljava/lang/String;
              //   104: astore 5
              //   106: aload 6
              //   108: getfield 93	com/tencent/mm/protocal/protobuf/bfl:dIZ	I
              //   111: istore_1
              //   112: ldc 32
              //   114: ldc 95
              //   116: iconst_2
              //   117: anewarray 4	java/lang/Object
              //   120: dup
              //   121: iconst_0
              //   122: aload 5
              //   124: aastore
              //   125: dup
              //   126: iconst_1
              //   127: iload_1
              //   128: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   131: aastore
              //   132: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   135: aload 5
              //   137: invokestatic 99	com/tencent/mm/plugin/freewifi/m:eP	(Ljava/lang/String;)Z
              //   140: ifne -63 -> 77
              //   143: iload_1
              //   144: ifne -67 -> 77
              //   147: ldc 101
              //   149: ldc 103
              //   151: iconst_1
              //   152: anewarray 4	java/lang/Object
              //   155: dup
              //   156: iconst_0
              //   157: aload 5
              //   159: aastore
              //   160: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   163: new 105	com/tencent/mm/plugin/freewifi/g/e
              //   166: dup
              //   167: invokespecial 106	com/tencent/mm/plugin/freewifi/g/e:<init>	()V
              //   170: astore 6
              //   172: aload 6
              //   174: aload 5
              //   176: putfield 109	com/tencent/mm/plugin/freewifi/g/e:field_id	Ljava/lang/String;
              //   179: ldc 101
              //   181: ldc 111
              //   183: aload_3
              //   184: aload 6
              //   186: iconst_0
              //   187: anewarray 113	java/lang/String
              //   190: invokevirtual 119	com/tencent/mm/plugin/freewifi/g/f:delete	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
              //   193: invokestatic 122	java/lang/String:valueOf	(Z)Ljava/lang/String;
              //   196: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   199: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   202: goto -125 -> 77
              //   205: astore_3
              //   206: ldc 32
              //   208: aload_3
              //   209: invokestatic 133	com/tencent/mm/plugin/freewifi/m:m	(Ljava/lang/Exception;)Ljava/lang/String;
              //   212: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   215: iconst_1
              //   216: invokestatic 142	com/tencent/mm/plugin/freewifi/f/b:access$002	(Z)Z
              //   219: pop
              //   220: sipush 24938
              //   223: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   226: return
              //   227: iconst_1
              //   228: invokestatic 142	com/tencent/mm/plugin/freewifi/f/b:access$002	(Z)Z
              //   231: pop
              //   232: sipush 24938
              //   235: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   238: return
              //   239: astore_3
              //   240: iconst_1
              //   241: invokestatic 142	com/tencent/mm/plugin/freewifi/f/b:access$002	(Z)Z
              //   244: pop
              //   245: sipush 24938
              //   248: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   251: aload_3
              //   252: athrow
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	253	0	this	1
              //   0	253	1	paramAnonymous2Int1	int
              //   0	253	2	paramAnonymous2Int2	int
              //   0	253	3	paramAnonymous2String	String
              //   0	253	4	paramAnonymous2q	com.tencent.mm.ak.q
              //   104	71	5	str	String
              //   97	88	6	localObject	Object
              // Exception table:
              //   from	to	target	type
              //   6	53	205	java/lang/Exception
              //   58	77	205	java/lang/Exception
              //   77	143	205	java/lang/Exception
              //   147	202	205	java/lang/Exception
              //   6	53	239	finally
              //   58	77	239	finally
              //   77	143	239	finally
              //   147	202	239	finally
              //   206	215	239	finally
            }
          });
          AppMethodBeat.o(24939);
          return;
        }
        b.access$002(true);
        AppMethodBeat.o(24939);
      }
    });
    AppMethodBeat.o(24940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.f.b
 * JD-Core Version:    0.7.0.1
 */