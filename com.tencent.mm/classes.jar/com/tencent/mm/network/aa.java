package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class aa
{
  final aa.a[] get;
  
  public aa()
  {
    AppMethodBeat.i(58645);
    this.get = new aa.a[100];
    AppMethodBeat.o(58645);
  }
  
  static boolean my(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 268369922);
  }
  
  /* Error */
  final int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 21	com/tencent/mm/network/aa:get	[Lcom/tencent/mm/network/aa$a;
    //   9: astore 10
    //   11: aload 10
    //   13: monitorenter
    //   14: aload_0
    //   15: iload_1
    //   16: invokevirtual 39	com/tencent/mm/network/aa:mA	(I)I
    //   19: istore 7
    //   21: iconst_m1
    //   22: iload 7
    //   24: if_icmpne +13 -> 37
    //   27: aload 10
    //   29: monitorexit
    //   30: ldc 35
    //   32: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_m1
    //   36: ireturn
    //   37: getstatic 45	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_DEFAULT	I
    //   40: istore 6
    //   42: iload 6
    //   44: istore_1
    //   45: iload 6
    //   47: istore 5
    //   49: aload_0
    //   50: getfield 21	com/tencent/mm/network/aa:get	[Lcom/tencent/mm/network/aa$a;
    //   53: iload 7
    //   55: aaload
    //   56: getfield 49	com/tencent/mm/network/aa$a:gex	Lcom/tencent/mm/network/r;
    //   59: invokeinterface 55 1 0
    //   64: invokeinterface 61 1 0
    //   69: astore 11
    //   71: iload 6
    //   73: istore_1
    //   74: iload 6
    //   76: istore 5
    //   78: aload_0
    //   79: getfield 21	com/tencent/mm/network/aa:get	[Lcom/tencent/mm/network/aa$a;
    //   82: iload 7
    //   84: aaload
    //   85: getfield 49	com/tencent/mm/network/aa$a:gex	Lcom/tencent/mm/network/r;
    //   88: invokeinterface 55 1 0
    //   93: invokeinterface 65 1 0
    //   98: lstore 8
    //   100: iload 6
    //   102: istore_1
    //   103: iload 6
    //   105: istore 5
    //   107: aload_0
    //   108: getfield 21	com/tencent/mm/network/aa:get	[Lcom/tencent/mm/network/aa$a;
    //   111: iload 7
    //   113: aaload
    //   114: getfield 49	com/tencent/mm/network/aa$a:gex	Lcom/tencent/mm/network/r;
    //   117: invokeinterface 69 1 0
    //   122: astore 12
    //   124: iload 6
    //   126: istore_1
    //   127: iload 6
    //   129: istore 5
    //   131: aload 12
    //   133: aload_0
    //   134: getfield 21	com/tencent/mm/network/aa:get	[Lcom/tencent/mm/network/aa$a;
    //   137: iload 7
    //   139: aaload
    //   140: getfield 49	com/tencent/mm/network/aa$a:gex	Lcom/tencent/mm/network/r;
    //   143: invokeinterface 73 1 0
    //   148: aload_2
    //   149: aload 11
    //   151: lload 8
    //   153: invokeinterface 78 6 0
    //   158: ifeq +404 -> 562
    //   161: iload 6
    //   163: istore_1
    //   164: iload 6
    //   166: istore 5
    //   168: aload 12
    //   170: invokeinterface 81 1 0
    //   175: istore 7
    //   177: aload 4
    //   179: iconst_0
    //   180: iconst_0
    //   181: iastore
    //   182: iload 6
    //   184: istore_1
    //   185: iload 6
    //   187: istore 5
    //   189: aload 12
    //   191: invokeinterface 84 1 0
    //   196: istore 6
    //   198: iload 7
    //   200: iconst_2
    //   201: iand
    //   202: ifne +32 -> 234
    //   205: aload 4
    //   207: iconst_0
    //   208: aload 4
    //   210: iconst_0
    //   211: iaload
    //   212: iconst_2
    //   213: ior
    //   214: iastore
    //   215: iload 6
    //   217: istore_1
    //   218: iload 6
    //   220: istore 5
    //   222: getstatic 90	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   225: ldc2_w 91
    //   228: lconst_0
    //   229: lconst_1
    //   230: iconst_0
    //   231: invokevirtual 96	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   234: iload 7
    //   236: iconst_4
    //   237: iand
    //   238: ifne +32 -> 270
    //   241: aload 4
    //   243: iconst_0
    //   244: aload 4
    //   246: iconst_0
    //   247: iaload
    //   248: iconst_4
    //   249: ior
    //   250: iastore
    //   251: iload 6
    //   253: istore_1
    //   254: iload 6
    //   256: istore 5
    //   258: getstatic 90	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   261: ldc2_w 91
    //   264: lconst_1
    //   265: lconst_1
    //   266: iconst_0
    //   267: invokevirtual 96	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   270: iload 6
    //   272: istore_1
    //   273: iload 6
    //   275: istore 5
    //   277: aload 12
    //   279: invokeinterface 99 1 0
    //   284: ifnull +49 -> 333
    //   287: iload 6
    //   289: istore_1
    //   290: iload 6
    //   292: istore 5
    //   294: bipush 243
    //   296: aload 12
    //   298: invokeinterface 84 1 0
    //   303: if_icmpne +30 -> 333
    //   306: iload 6
    //   308: istore_1
    //   309: iload 6
    //   311: istore 5
    //   313: invokestatic 105	com/tencent/mm/network/ab:anF	()Lcom/tencent/mm/network/t;
    //   316: ifnull +17 -> 333
    //   319: iload 6
    //   321: istore_1
    //   322: iload 6
    //   324: istore 5
    //   326: invokestatic 105	com/tencent/mm/network/ab:anF	()Lcom/tencent/mm/network/t;
    //   329: invokevirtual 111	com/tencent/mm/network/t:anm	()Z
    //   332: pop
    //   333: iload 6
    //   335: istore_1
    //   336: iload 6
    //   338: istore 5
    //   340: bipush 243
    //   342: aload 12
    //   344: invokeinterface 84 1 0
    //   349: if_icmpne +45 -> 394
    //   352: iload 6
    //   354: istore_1
    //   355: iload 6
    //   357: istore 5
    //   359: getstatic 114	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   362: istore 6
    //   364: iload 6
    //   366: istore_1
    //   367: iload 6
    //   369: istore 5
    //   371: aload_3
    //   372: iconst_0
    //   373: aload 12
    //   375: invokeinterface 84 1 0
    //   380: iastore
    //   381: iload 6
    //   383: istore_1
    //   384: aload 10
    //   386: monitorexit
    //   387: ldc 35
    //   389: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: iload_1
    //   393: ireturn
    //   394: iload 6
    //   396: istore_1
    //   397: iload 6
    //   399: istore 5
    //   401: sipush -3002
    //   404: aload 12
    //   406: invokeinterface 84 1 0
    //   411: if_icmpeq +43 -> 454
    //   414: iload 6
    //   416: istore_1
    //   417: iload 6
    //   419: istore 5
    //   421: sipush -3003
    //   424: aload 12
    //   426: invokeinterface 84 1 0
    //   431: if_icmpeq +23 -> 454
    //   434: iload 6
    //   436: istore_1
    //   437: iload 6
    //   439: istore 5
    //   441: sipush -3006
    //   444: aload 12
    //   446: invokeinterface 84 1 0
    //   451: if_icmpne +38 -> 489
    //   454: iload 6
    //   456: istore_1
    //   457: iload 6
    //   459: istore 5
    //   461: getstatic 117	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_TASK_END	I
    //   464: istore 6
    //   466: iload 6
    //   468: istore_1
    //   469: iload 6
    //   471: istore 5
    //   473: aload_3
    //   474: iconst_0
    //   475: aload 12
    //   477: invokeinterface 84 1 0
    //   482: iastore
    //   483: iload 6
    //   485: istore_1
    //   486: goto -102 -> 384
    //   489: iload 6
    //   491: istore_1
    //   492: iload 6
    //   494: istore 5
    //   496: sipush -3001
    //   499: aload 12
    //   501: invokeinterface 84 1 0
    //   506: if_icmpne +38 -> 544
    //   509: iload 6
    //   511: istore_1
    //   512: iload 6
    //   514: istore 5
    //   516: getstatic 114	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   519: istore 6
    //   521: iload 6
    //   523: istore_1
    //   524: iload 6
    //   526: istore 5
    //   528: aload_3
    //   529: iconst_0
    //   530: aload 12
    //   532: invokeinterface 84 1 0
    //   537: iastore
    //   538: iload 6
    //   540: istore_1
    //   541: goto -157 -> 384
    //   544: iload 6
    //   546: istore_1
    //   547: iload 6
    //   549: istore 5
    //   551: getstatic 120	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_NORMAL	I
    //   554: istore 6
    //   556: iload 6
    //   558: istore_1
    //   559: goto -175 -> 384
    //   562: iload 6
    //   564: istore_1
    //   565: iload 6
    //   567: istore 5
    //   569: getstatic 90	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   572: ldc2_w 121
    //   575: ldc2_w 123
    //   578: lconst_1
    //   579: iconst_0
    //   580: invokevirtual 96	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   583: iload 6
    //   585: istore_1
    //   586: iload 6
    //   588: istore 5
    //   590: ldc 126
    //   592: ldc 128
    //   594: invokestatic 134	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: iload 6
    //   599: istore_1
    //   600: goto -216 -> 384
    //   603: astore_2
    //   604: getstatic 90	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   607: ldc2_w 121
    //   610: ldc2_w 135
    //   613: lconst_1
    //   614: iconst_0
    //   615: invokevirtual 96	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   618: ldc 126
    //   620: ldc 138
    //   622: iconst_1
    //   623: anewarray 4	java/lang/Object
    //   626: dup
    //   627: iconst_0
    //   628: aload_2
    //   629: invokestatic 144	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   632: aastore
    //   633: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   636: goto -252 -> 384
    //   639: getstatic 90	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   642: ldc2_w 121
    //   645: ldc2_w 148
    //   648: lconst_1
    //   649: iconst_0
    //   650: invokevirtual 96	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   653: ldc 126
    //   655: ldc 138
    //   657: iconst_1
    //   658: anewarray 4	java/lang/Object
    //   661: dup
    //   662: iconst_0
    //   663: aload_2
    //   664: invokestatic 144	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   667: aastore
    //   668: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   671: iload 5
    //   673: istore_1
    //   674: goto -290 -> 384
    //   677: astore_2
    //   678: aload 10
    //   680: monitorexit
    //   681: ldc 35
    //   683: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   686: aload_2
    //   687: athrow
    //   688: astore_2
    //   689: iload_1
    //   690: istore 5
    //   692: goto -53 -> 639
    //   695: astore_2
    //   696: iload 5
    //   698: istore_1
    //   699: goto -95 -> 604
    //   702: astore_2
    //   703: goto -64 -> 639
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	aa
    //   0	706	1	paramInt	int
    //   0	706	2	paramArrayOfByte	byte[]
    //   0	706	3	paramArrayOfInt1	int[]
    //   0	706	4	paramArrayOfInt2	int[]
    //   47	650	5	i	int
    //   40	558	6	j	int
    //   19	219	7	k	int
    //   98	54	8	l	long
    //   9	670	10	arrayOfa	aa.a[]
    //   69	81	11	arrayOfByte	byte[]
    //   122	409	12	locali	i
    // Exception table:
    //   from	to	target	type
    //   49	71	603	android/os/RemoteException
    //   78	100	603	android/os/RemoteException
    //   107	124	603	android/os/RemoteException
    //   131	161	603	android/os/RemoteException
    //   168	177	603	android/os/RemoteException
    //   189	198	603	android/os/RemoteException
    //   222	234	603	android/os/RemoteException
    //   258	270	603	android/os/RemoteException
    //   277	287	603	android/os/RemoteException
    //   294	306	603	android/os/RemoteException
    //   313	319	603	android/os/RemoteException
    //   326	333	603	android/os/RemoteException
    //   340	352	603	android/os/RemoteException
    //   359	364	603	android/os/RemoteException
    //   401	414	603	android/os/RemoteException
    //   421	434	603	android/os/RemoteException
    //   441	454	603	android/os/RemoteException
    //   461	466	603	android/os/RemoteException
    //   496	509	603	android/os/RemoteException
    //   516	521	603	android/os/RemoteException
    //   551	556	603	android/os/RemoteException
    //   569	583	603	android/os/RemoteException
    //   590	597	603	android/os/RemoteException
    //   14	21	677	finally
    //   27	30	677	finally
    //   37	42	677	finally
    //   49	71	677	finally
    //   78	100	677	finally
    //   107	124	677	finally
    //   131	161	677	finally
    //   168	177	677	finally
    //   189	198	677	finally
    //   222	234	677	finally
    //   258	270	677	finally
    //   277	287	677	finally
    //   294	306	677	finally
    //   313	319	677	finally
    //   326	333	677	finally
    //   340	352	677	finally
    //   359	364	677	finally
    //   371	381	677	finally
    //   384	387	677	finally
    //   401	414	677	finally
    //   421	434	677	finally
    //   441	454	677	finally
    //   461	466	677	finally
    //   473	483	677	finally
    //   496	509	677	finally
    //   516	521	677	finally
    //   528	538	677	finally
    //   551	556	677	finally
    //   569	583	677	finally
    //   590	597	677	finally
    //   604	636	677	finally
    //   639	671	677	finally
    //   678	681	677	finally
    //   371	381	688	java/lang/Exception
    //   473	483	688	java/lang/Exception
    //   528	538	688	java/lang/Exception
    //   371	381	695	android/os/RemoteException
    //   473	483	695	android/os/RemoteException
    //   528	538	695	android/os/RemoteException
    //   49	71	702	java/lang/Exception
    //   78	100	702	java/lang/Exception
    //   107	124	702	java/lang/Exception
    //   131	161	702	java/lang/Exception
    //   168	177	702	java/lang/Exception
    //   189	198	702	java/lang/Exception
    //   222	234	702	java/lang/Exception
    //   258	270	702	java/lang/Exception
    //   277	287	702	java/lang/Exception
    //   294	306	702	java/lang/Exception
    //   313	319	702	java/lang/Exception
    //   326	333	702	java/lang/Exception
    //   340	352	702	java/lang/Exception
    //   359	364	702	java/lang/Exception
    //   401	414	702	java/lang/Exception
    //   421	434	702	java/lang/Exception
    //   441	454	702	java/lang/Exception
    //   461	466	702	java/lang/Exception
    //   496	509	702	java/lang/Exception
    //   516	521	702	java/lang/Exception
    //   551	556	702	java/lang/Exception
    //   569	583	702	java/lang/Exception
    //   590	597	702	java/lang/Exception
  }
  
  public final int a(r paramr, l paraml, c paramc, int paramInt)
  {
    AppMethodBeat.i(58651);
    if (paramr == null)
    {
      ab.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
      AppMethodBeat.o(58651);
      return -1;
    }
    paramr.hashCode();
    StnLogic.Task localTask = new StnLogic.Task();
    aa.a[] arrayOfa = this.get;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      for (;;)
      {
        try
        {
          if (this.get[i] != null) {
            break;
          }
          this.get[i] = new aa.a(0);
          this.get[i].gex = paramr;
          this.get[i].gey = paraml;
          this.get[i].gez = paramc;
          this.get[i].startTime = bo.aoy();
          this.get[i].taskId = localTask.taskID;
          localTask.cmdID = paramr.adO().getCmdId();
          localTask.cgi = paramr.getUri();
          int j = paramr.getType();
          boolean bool;
          if ((paramr.getOptions() & 0x1) != 1)
          {
            bool = true;
            localTask.needAuthed = bool;
            if ((j == 126) || (j == 252) || (j == 701) || (j == 702) || (j == 763) || (j == 3941))
            {
              localTask.needAuthed = false;
              if ((j == 701) || (j == 252)) {
                localTask.retryCount = 1;
              }
            }
            localTask.limitFlow = true;
            if ((j == 149) || (j == 193) || (j == 110) || (j == 220) || (j == 323) || (j == 324) || (j == 326) || (j == 327) || (j == 703)) {
              localTask.limitFlow = false;
            }
            if (j == 703) {
              localTask.limitFrequency = false;
            }
            localTask.channelStrategy = 0;
            if ((j == 233) || (j == 835) || (j == 238)) {
              localTask.channelStrategy = 1;
            }
            localTask.sendOnly = false;
            if (my(j)) {
              localTask.sendOnly = true;
            }
            if ((paramr.adO().getShortSupport()) && (paramr.getUri() != null) && (paramr.getUri().length() > 0)) {
              localTask.channelSelect |= 0x1;
            }
            if (localTask.cmdID != 0) {
              localTask.channelSelect |= 0x2;
            }
            localTask.reportArg = String.valueOf(j);
            if (j == 522)
            {
              localTask.totalTimeout = 300000;
              localTask.priority = 0;
            }
            if (j == 710)
            {
              localTask.totalTimeout = 15000;
              localTask.serverProcessCost = 0;
            }
            if (j == 2632)
            {
              j = paramr.getTimeOut();
              if (j != 0) {
                localTask.totalTimeout = j;
              }
            }
            ab.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(localTask.taskID), Integer.valueOf(paramr.getMMReqRespHash()), Integer.valueOf(localTask.channelSelect), localTask.cgi, Boolean.valueOf(localTask.needAuthed) });
            if (-1 != i)
            {
              if (paramInt == 1) {
                localTask.retryCount = 0;
              }
              StnLogic.startTask(localTask);
              ab.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=".concat(String.valueOf(i)));
              AppMethodBeat.o(58651);
              return i;
            }
          }
          else
          {
            bool = false;
            continue;
          }
          ab.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        catch (RemoteException localRemoteException)
        {
          ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bo.l(localRemoteException) });
        }
        finally
        {
          AppMethodBeat.o(58651);
        }
        continue;
        i = -1;
      }
      i += 1;
    }
  }
  
  final boolean a(int paramInt1, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString)
  {
    AppMethodBeat.i(154761);
    for (;;)
    {
      synchronized (this.get)
      {
        int i = mA(paramInt1);
        if (-1 == i)
        {
          AppMethodBeat.o(154761);
          return false;
        }
        try
        {
          bool = this.get[i].gez.rq(paramString);
          ab.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s, type: %d host[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(this.get[i].gez.isForeground()), bo.cg(this.get[i].gez.adB()), Integer.valueOf(this.get[i].gex.getType()), paramString });
          paramInt1 = 1;
          if (!this.get[i].gex.isSingleSession())
          {
            paramInt1 = 2;
            this.get[i].gex.adO().setPassKey(this.get[i].gez.jN(3));
            ab.i("MicroMsg.MMNativeNetTaskAdapter", "summerauths isSingleSession false type:[%s]", new Object[] { Integer.valueOf(this.get[i].gex.getType()) });
          }
          if (!bool) {
            continue;
          }
          ab.i("MicroMsg.MMNativeNetTaskAdapter", "set axauth sessionkey ".concat(String.valueOf(paramString)));
          this.get[i].gex.adO().setPassKey(this.get[i].gez.rp(paramString));
          localObject1 = this.get[i].gez.ro(paramString);
          Object localObject2 = this.get[i].gez.rn(paramString);
          e.qrI.idkeyStat(148L, 123L, 1L, false);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          paramInt1 = 2;
          this.get[i].gex.adO().setSessionKey(paramString);
          this.get[i].gex.adO().setUin(this.get[i].gez.getUin());
          localObject2 = this.get[i].gex.adO();
          paramInt2 = this.get[i].gex.getType();
          if (paramInt1 != 2) {
            break label779;
          }
          paramInt1 = 13;
          bool = ((h)localObject2).a(paramInt2, paramString, paramInt1, (byte[])localObject1, this.get[i].gez.adD(), 0, this.get[i].gez.isForeground());
          if (!bool) {
            continue;
          }
          paramByteArrayOutputStream.write(this.get[i].gex.adO().adM());
        }
        catch (RemoteException paramByteArrayOutputStream)
        {
          Object localObject1;
          paramArrayOfInt[0] = 1;
          e.qrI.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          ab.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", new Object[] { bo.l(paramByteArrayOutputStream) });
          bool = false;
          continue;
        }
        catch (IOException paramByteArrayOutputStream)
        {
          paramArrayOfInt[0] = 2;
          e.qrI.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          ab.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", new Object[] { bo.l(paramByteArrayOutputStream) });
          bool = false;
          continue;
        }
        catch (Exception paramByteArrayOutputStream)
        {
          paramArrayOfInt[0] = 3;
          e.qrI.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          ab.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", new Object[] { bo.l(paramByteArrayOutputStream) });
          boolean bool = false;
          continue;
        }
        ab.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(154761);
        return bool;
        paramString = this.get[i].gez.jN(paramInt1);
        localObject1 = this.get[i].gez.adB();
        continue;
        paramArrayOfInt[0] = 0;
        e.qrI.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
        ab.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
      }
      label779:
      paramInt1 = 0;
    }
  }
  
  final boolean ant()
  {
    AppMethodBeat.i(58647);
    aa.a[] arrayOfa = this.get;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.get[i] != null) && ((252 == this.get[i].gex.getType()) || (701 == this.get[i].gex.getType()) || (702 == this.get[i].gex.getType()) || (763 == this.get[i].gex.getType()) || (3941 == this.get[i].gex.getType())))
        {
          ab.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.get[i].gex.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.get[i] = null;
        ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bo.l(localRemoteException), Integer.valueOf(i) });
        break label243;
        return false;
      }
      finally
      {
        AppMethodBeat.o(58647);
      }
      label243:
      i += 1;
    }
  }
  
  final boolean anu()
  {
    AppMethodBeat.i(58648);
    aa.a[] arrayOfa = this.get;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.get[i] != null) && (1000 == this.get[i].gex.getType()))
        {
          ab.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.get[i].gex.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.get[i] = null;
        ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bo.l(localRemoteException), Integer.valueOf(i) });
        break label163;
        return false;
      }
      finally
      {
        AppMethodBeat.o(58648);
      }
      label163:
      i += 1;
    }
  }
  
  public final int anv()
  {
    AppMethodBeat.i(58650);
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i >= 100) {
        break label96;
      }
      k = j;
      try
      {
        if (this.get[i] != null)
        {
          this.get[i].gex.getType();
          k = j;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bo.l(localRemoteException), Integer.valueOf(i) });
          k = j + 1;
          this.get[i] = null;
        }
      }
      i += 1;
    }
    label96:
    AppMethodBeat.o(58650);
    return j;
  }
  
  final r dq(boolean paramBoolean)
  {
    AppMethodBeat.i(58649);
    aa.a[] arrayOfa = this.get;
    int i = 0;
    Object localObject4;
    label315:
    Object localObject2;
    for (Object localObject1 = null;; localObject2 = localObject4)
    {
      if (i < 100)
      {
        try
        {
          aa.a locala = this.get[i];
          Object localObject3 = localObject1;
          if (locala == null) {
            break label315;
          }
          if (paramBoolean) {
            localObject3 = localObject1;
          }
          try
          {
            if ((this.get[i].gex instanceof r.a)) {
              break label315;
            }
            if ((!paramBoolean) && (!(this.get[i].gex instanceof r.a)))
            {
              localObject3 = localObject1;
              break label315;
            }
            if ((252 == this.get[i].gex.getType()) || (701 == this.get[i].gex.getType()) || (763 == this.get[i].gex.getType()) || (702 == this.get[i].gex.getType()) || (3941 == this.get[i].gex.getType()))
            {
              ab.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.get[i].gex.getType());
              return null;
            }
          }
          catch (RemoteException localRemoteException)
          {
            ab.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bo.l(localRemoteException) });
            localObject4 = localObject1;
          }
          localObject4 = localr;
        }
        finally
        {
          AppMethodBeat.o(58649);
        }
        if (localr == null) {
          localObject4 = this.get[i].gex;
        }
      }
      else
      {
        AppMethodBeat.o(58649);
        return localr;
      }
      i += 1;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(58646);
    reset();
    super.finalize();
    AppMethodBeat.o(58646);
  }
  
  /* Error */
  public final void k(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc_w 424
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 126
    //   8: new 377	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 426
    //   15: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 428
    //   25: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 430
    //   35: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 324	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: invokestatic 433	com/tencent/mars/stn/StnLogic:clearTask	()V
    //   51: invokestatic 434	com/tencent/mars/stn/StnLogic:reset	()V
    //   54: bipush 100
    //   56: anewarray 6	com/tencent/mm/network/aa$a
    //   59: astore 5
    //   61: aload_0
    //   62: getfield 21	com/tencent/mm/network/aa:get	[Lcom/tencent/mm/network/aa$a;
    //   65: astore 6
    //   67: aload 6
    //   69: monitorenter
    //   70: iconst_0
    //   71: istore 4
    //   73: iload 4
    //   75: bipush 100
    //   77: if_icmpge +32 -> 109
    //   80: aload 5
    //   82: iload 4
    //   84: aload_0
    //   85: getfield 21	com/tencent/mm/network/aa:get	[Lcom/tencent/mm/network/aa$a;
    //   88: iload 4
    //   90: aaload
    //   91: aastore
    //   92: aload_0
    //   93: getfield 21	com/tencent/mm/network/aa:get	[Lcom/tencent/mm/network/aa$a;
    //   96: iload 4
    //   98: aconst_null
    //   99: aastore
    //   100: iload 4
    //   102: iconst_1
    //   103: iadd
    //   104: istore 4
    //   106: goto -33 -> 73
    //   109: aload 6
    //   111: monitorexit
    //   112: iconst_0
    //   113: istore 4
    //   115: iload 4
    //   117: bipush 100
    //   119: if_icmpge +141 -> 260
    //   122: aload 5
    //   124: iload 4
    //   126: aaload
    //   127: ifnull +88 -> 215
    //   130: ldc 126
    //   132: ldc_w 436
    //   135: iconst_3
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: iload 4
    //   143: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload 5
    //   151: iload 4
    //   153: aaload
    //   154: getfield 49	com/tencent/mm/network/aa$a:gex	Lcom/tencent/mm/network/r;
    //   157: invokeinterface 73 1 0
    //   162: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: dup
    //   167: iconst_2
    //   168: aload 5
    //   170: iload 4
    //   172: aaload
    //   173: getfield 49	com/tencent/mm/network/aa$a:gex	Lcom/tencent/mm/network/r;
    //   176: invokeinterface 262 1 0
    //   181: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 5
    //   190: iload 4
    //   192: aaload
    //   193: getfield 166	com/tencent/mm/network/aa$a:gey	Lcom/tencent/mm/network/l;
    //   196: iload 4
    //   198: iload_1
    //   199: iload_2
    //   200: aload_3
    //   201: aload 5
    //   203: iload 4
    //   205: aaload
    //   206: getfield 49	com/tencent/mm/network/aa$a:gex	Lcom/tencent/mm/network/r;
    //   209: aconst_null
    //   210: invokeinterface 441 7 0
    //   215: iload 4
    //   217: iconst_1
    //   218: iadd
    //   219: istore 4
    //   221: goto -106 -> 115
    //   224: astore_3
    //   225: aload 6
    //   227: monitorexit
    //   228: ldc_w 424
    //   231: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_3
    //   235: athrow
    //   236: astore 6
    //   238: ldc 126
    //   240: ldc 138
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 6
    //   250: invokestatic 144	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   253: aastore
    //   254: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: goto -42 -> 215
    //   260: ldc_w 424
    //   263: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	aa
    //   0	267	1	paramInt1	int
    //   0	267	2	paramInt2	int
    //   0	267	3	paramString	String
    //   71	149	4	i	int
    //   59	143	5	arrayOfa1	aa.a[]
    //   65	161	6	arrayOfa2	aa.a[]
    //   236	13	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   80	100	224	finally
    //   109	112	224	finally
    //   225	228	224	finally
    //   130	215	236	java/lang/Exception
  }
  
  final int mA(int paramInt)
  {
    int i = 0;
    while ((i < 100) && ((this.get[i] == null) || (paramInt != this.get[i].taskId))) {
      i += 1;
    }
    paramInt = i;
    if (100 <= i) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  final int mz(int paramInt)
  {
    AppMethodBeat.i(58654);
    synchronized (this.get)
    {
      paramInt = mA(paramInt);
      if (-1 == paramInt)
      {
        ab.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
        AppMethodBeat.o(58654);
        return 0;
      }
      try
      {
        paramInt = this.get[paramInt].gex.adP().getRetCode();
        AppMethodBeat.o(58654);
        return paramInt;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bo.l(localException) });
        AppMethodBeat.o(58654);
        return 0;
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(58652);
    ab.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
    StnLogic.reset();
    aa.a[] arrayOfa = this.get;
    int i = 0;
    while (i < 100) {
      try
      {
        aa.a locala = this.get[i];
        if (locala != null) {}
        try
        {
          ab.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.get[i].gex.getType()), Integer.valueOf(this.get[i].gex.getMMReqRespHash()) });
          this.get[i] = null;
          i += 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bo.l(localRemoteException) });
          }
        }
      }
      finally
      {
        AppMethodBeat.o(58652);
      }
    }
    AppMethodBeat.o(58652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.aa
 * JD-Core Version:    0.7.0.1
 */