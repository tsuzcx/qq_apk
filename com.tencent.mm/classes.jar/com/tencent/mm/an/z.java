package com.tencent.mm.an;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.kc;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.i.a;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ecy;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class z
  extends i.a
{
  private static a lDs;
  private static char[] lDt = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private byte[] fYH;
  private l.e lDr;
  private int type;
  
  public z(l.e parame, int paramInt)
  {
    this.lDr = parame;
    this.type = paramInt;
  }
  
  public static void a(a parama)
  {
    lDs = parama;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PInt paramPInt, dyy paramdyy)
  {
    AppMethodBeat.i(132466);
    PByteArray localPByteArray2 = new PByteArray();
    paramPInt.value = -1;
    PByteArray localPByteArray1 = new PByteArray();
    PInt localPInt1 = new PInt(0);
    PInt localPInt2 = new PInt(0);
    PInt localPInt3 = new PInt(255);
    for (;;)
    {
      try
      {
        boolean bool1 = MMProtocalJni.unpack(localPByteArray1, paramArrayOfByte1, paramArrayOfByte2, localPByteArray2, paramPInt, localPInt1, localPInt2, localPInt3);
        Log.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(localPInt2.value), Integer.valueOf(localPInt3.value) });
        if (localPInt2.value != 0)
        {
          paramArrayOfByte1 = new kc();
          paramArrayOfByte1.fHy.fHz = localPInt2.value;
          boolean bool2 = EventCenter.instance.publish(paramArrayOfByte1);
          Log.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt2.value), Boolean.valueOf(bool2) });
        }
        if (!bool1) {
          continue;
        }
        if ((paramPInt.value == -13) || (paramPInt.value == -102) || (paramPInt.value == -3001))
        {
          Log.e("MicroMsg.RemoteResp", "unpack failed. error:%d", new Object[] { Integer.valueOf(paramPInt.value) });
          AppMethodBeat.o(132466);
          return null;
        }
        int i = paramPInt.value;
        if (i != -3002) {
          continue;
        }
        try
        {
          paramArrayOfByte1 = new String(localPByteArray1.value);
          Log.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", new Object[] { paramArrayOfByte1 });
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132464);
              if ((!Util.isNullOrNil(this.lDu)) && (z.biM() != null)) {
                z.biM().hc(this.lDu);
              }
              AppMethodBeat.o(132464);
            }
          });
          AppMethodBeat.o(132466);
          return null;
        }
        catch (Exception paramArrayOfByte1)
        {
          Log.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        Log.printErrStackTrace("MicroMsg.RemoteResp", paramArrayOfByte1, "parseFrom unbuild exception, check now!", new Object[0]);
        Log.e("MicroMsg.RemoteResp", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte1) });
        continue;
      }
      AppMethodBeat.o(132466);
      return null;
      Log.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", new Object[] { Integer.valueOf(110), Integer.valueOf(localPInt1.value) });
      paramdyy.parseFrom(localPByteArray1.value);
      paramArrayOfByte1 = localPByteArray1.value;
      AppMethodBeat.o(132466);
      return paramArrayOfByte1;
      Log.e("MicroMsg.RemoteResp", "unpack failed.");
    }
  }
  
  private static String toHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132478);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(132478);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(lDt[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(lDt[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(132478);
    return paramArrayOfByte;
  }
  
  /* Error */
  public final boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    // Byte code:
    //   0: ldc 207
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 63	com/tencent/mm/pointers/PByteArray
    //   8: dup
    //   9: invokespecial 64	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   12: astore 12
    //   14: aload_0
    //   15: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   18: instanceof 209
    //   21: ifne +17 -> 38
    //   24: ldc 79
    //   26: ldc 211
    //   28: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 207
    //   33: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: iconst_0
    //   37: ireturn
    //   38: new 63	com/tencent/mm/pointers/PByteArray
    //   41: dup
    //   42: invokespecial 64	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   45: astore 13
    //   47: new 66	com/tencent/mm/pointers/PInt
    //   50: dup
    //   51: iconst_0
    //   52: invokespecial 71	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   55: astore 14
    //   57: aload_0
    //   58: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   61: checkcast 209	com/tencent/mm/protocal/l$c
    //   64: astore 15
    //   66: new 66	com/tencent/mm/pointers/PInt
    //   69: dup
    //   70: iconst_0
    //   71: invokespecial 71	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   74: astore 16
    //   76: new 66	com/tencent/mm/pointers/PInt
    //   79: dup
    //   80: iconst_0
    //   81: invokespecial 71	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   84: astore 11
    //   86: new 66	com/tencent/mm/pointers/PInt
    //   89: dup
    //   90: sipush 255
    //   93: invokespecial 71	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   96: astore 17
    //   98: aload 15
    //   100: invokeinterface 218 1 0
    //   105: ifeq +53 -> 158
    //   108: aload 15
    //   110: aload_2
    //   111: invokeinterface 222 2 0
    //   116: istore_1
    //   117: ldc 79
    //   119: ldc 224
    //   121: invokestatic 227	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   128: iload_1
    //   129: invokevirtual 232	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   132: getstatic 238	com/tencent/mm/platformtools/ac:mFP	Ljava/lang/String;
    //   135: invokestatic 242	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   138: ifne +13 -> 151
    //   141: aload_0
    //   142: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   145: getstatic 238	com/tencent/mm/platformtools/ac:mFP	Ljava/lang/String;
    //   148: invokevirtual 245	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   151: ldc 207
    //   153: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: aload_2
    //   159: ifnonnull +668 -> 827
    //   162: iconst_m1
    //   163: istore 6
    //   165: aload_3
    //   166: ifnonnull +668 -> 834
    //   169: iconst_m1
    //   170: istore 7
    //   172: ldc 79
    //   174: ldc 247
    //   176: iconst_4
    //   177: anewarray 83	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: iload_1
    //   183: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: iload 6
    //   191: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: iload 7
    //   199: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: aastore
    //   203: dup
    //   204: iconst_3
    //   205: aload 12
    //   207: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   210: aastore
    //   211: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload 13
    //   216: aload_2
    //   217: aload_3
    //   218: aload 12
    //   220: aload 14
    //   222: aload 16
    //   224: aload 11
    //   226: aload 17
    //   228: invokestatic 77	com/tencent/mm/protocal/MMProtocalJni:unpack	(Lcom/tencent/mm/pointers/PByteArray;[B[BLcom/tencent/mm/pointers/PByteArray;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   231: istore 10
    //   233: aload 16
    //   235: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   238: istore 7
    //   240: aload 11
    //   242: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   245: istore 8
    //   247: aload 17
    //   249: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   252: istore 9
    //   254: aload 13
    //   256: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   259: astore 18
    //   261: aload 13
    //   263: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   266: ifnonnull +575 -> 841
    //   269: iconst_m1
    //   270: istore 6
    //   272: ldc 79
    //   274: ldc 249
    //   276: bipush 7
    //   278: anewarray 83	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: iload 10
    //   285: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: iload_1
    //   292: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: aastore
    //   296: dup
    //   297: iconst_2
    //   298: iload 7
    //   300: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: iconst_3
    //   306: iload 8
    //   308: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   311: aastore
    //   312: dup
    //   313: iconst_4
    //   314: iload 9
    //   316: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: aastore
    //   320: dup
    //   321: iconst_5
    //   322: aload 18
    //   324: aastore
    //   325: dup
    //   326: bipush 6
    //   328: iload 6
    //   330: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: iload 10
    //   339: ifeq +1254 -> 1593
    //   342: aload_0
    //   343: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   346: aload 17
    //   348: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   351: invokevirtual 252	com/tencent/mm/protocal/l$e:setHeadExtFlags	(I)V
    //   354: iload_1
    //   355: sipush 701
    //   358: if_icmpeq +75 -> 433
    //   361: iload_1
    //   362: sipush 702
    //   365: if_icmpeq +68 -> 433
    //   368: iload_1
    //   369: sipush 252
    //   372: if_icmpeq +61 -> 433
    //   375: iload_1
    //   376: sipush 763
    //   379: if_icmpeq +54 -> 433
    //   382: sipush 10001
    //   385: getstatic 255	com/tencent/mm/platformtools/ac:mFM	I
    //   388: if_icmpne +45 -> 433
    //   391: getstatic 258	com/tencent/mm/platformtools/ac:mFN	I
    //   394: ifle +39 -> 433
    //   397: getstatic 258	com/tencent/mm/platformtools/ac:mFN	I
    //   400: iconst_2
    //   401: if_icmpne +13 -> 414
    //   404: ldc_w 260
    //   407: ldc_w 260
    //   410: iconst_0
    //   411: invokestatic 266	com/tencent/mm/protocal/ac:aA	(Ljava/lang/String;Ljava/lang/String;I)V
    //   414: iconst_0
    //   415: putstatic 258	com/tencent/mm/platformtools/ac:mFN	I
    //   418: aload 14
    //   420: bipush 243
    //   422: putfield 69	com/tencent/mm/pointers/PInt:value	I
    //   425: ldc 79
    //   427: ldc_w 268
    //   430: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: aload 14
    //   435: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   438: sipush -306
    //   441: if_icmpne +411 -> 852
    //   444: ldc 79
    //   446: ldc_w 273
    //   449: iconst_1
    //   450: anewarray 83	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: getstatic 279	com/tencent/mm/protocal/f:RAO	Z
    //   458: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   461: aastore
    //   462: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: iconst_0
    //   466: putstatic 279	com/tencent/mm/protocal/f:RAO	Z
    //   469: aload 14
    //   471: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   474: bipush 243
    //   476: if_icmpeq +79 -> 555
    //   479: aload 14
    //   481: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   484: bipush 154
    //   486: if_icmpeq +69 -> 555
    //   489: aload 14
    //   491: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   494: sipush -3001
    //   497: if_icmpeq +58 -> 555
    //   500: aload 14
    //   502: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   505: sipush -3002
    //   508: if_icmpeq +47 -> 555
    //   511: aload 14
    //   513: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   516: sipush -3003
    //   519: if_icmpeq +36 -> 555
    //   522: aload 14
    //   524: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   527: sipush -306
    //   530: if_icmpeq +25 -> 555
    //   533: aload 14
    //   535: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   538: sipush -3006
    //   541: if_icmpeq +14 -> 555
    //   544: aload 14
    //   546: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   549: sipush -3800
    //   552: if_icmpne +854 -> 1406
    //   555: aload_0
    //   556: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   559: aload 14
    //   561: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   564: invokevirtual 232	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   567: aload 14
    //   569: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   572: istore 6
    //   574: iload 6
    //   576: sipush -3002
    //   579: if_icmpne +67 -> 646
    //   582: aload_0
    //   583: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   586: new 133	java/lang/String
    //   589: dup
    //   590: aload 13
    //   592: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   595: invokespecial 138	java/lang/String:<init>	([B)V
    //   598: invokevirtual 245	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   601: ldc 79
    //   603: ldc_w 281
    //   606: iconst_4
    //   607: anewarray 83	java/lang/Object
    //   610: dup
    //   611: iconst_0
    //   612: iload_1
    //   613: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   616: aastore
    //   617: dup
    //   618: iconst_1
    //   619: aload 14
    //   621: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   624: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   627: aastore
    //   628: dup
    //   629: iconst_2
    //   630: aload 11
    //   632: aastore
    //   633: dup
    //   634: iconst_3
    //   635: aload_0
    //   636: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   639: invokevirtual 284	com/tencent/mm/protocal/l$e:getErrMsg	()Ljava/lang/String;
    //   642: aastore
    //   643: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   646: aload_0
    //   647: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   650: aload_2
    //   651: arraylength
    //   652: i2l
    //   653: invokevirtual 288	com/tencent/mm/protocal/l$e:setBufferSize	(J)V
    //   656: aload_0
    //   657: aload 12
    //   659: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   662: putfield 290	com/tencent/mm/an/z:fYH	[B
    //   665: getstatic 238	com/tencent/mm/platformtools/ac:mFP	Ljava/lang/String;
    //   668: invokestatic 242	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   671: ifne +13 -> 684
    //   674: aload_0
    //   675: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   678: getstatic 238	com/tencent/mm/platformtools/ac:mFP	Ljava/lang/String;
    //   681: invokevirtual 245	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   684: aload 11
    //   686: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   689: ifeq +131 -> 820
    //   692: new 101	com/tencent/mm/f/a/kc
    //   695: dup
    //   696: invokespecial 102	com/tencent/mm/f/a/kc:<init>	()V
    //   699: astore_2
    //   700: aload_2
    //   701: getfield 106	com/tencent/mm/f/a/kc:fHy	Lcom/tencent/mm/f/a/kc$a;
    //   704: aload 11
    //   706: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   709: putfield 111	com/tencent/mm/f/a/kc$a:fHz	I
    //   712: iload_1
    //   713: sipush 252
    //   716: if_icmpeq +10 -> 726
    //   719: iload_1
    //   720: sipush 701
    //   723: if_icmpne +51 -> 774
    //   726: aload_0
    //   727: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   730: invokevirtual 294	com/tencent/mm/protocal/l$e:getRetCode	()I
    //   733: ifne +41 -> 774
    //   736: ldc 79
    //   738: ldc_w 296
    //   741: iconst_2
    //   742: anewarray 83	java/lang/Object
    //   745: dup
    //   746: iconst_0
    //   747: aload 11
    //   749: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   752: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   755: aastore
    //   756: dup
    //   757: iconst_1
    //   758: iload_1
    //   759: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   762: aastore
    //   763: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   766: aload_2
    //   767: getfield 106	com/tencent/mm/f/a/kc:fHy	Lcom/tencent/mm/f/a/kc$a;
    //   770: iconst_1
    //   771: putfield 299	com/tencent/mm/f/a/kc$a:fHA	Z
    //   774: getstatic 117	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   777: aload_2
    //   778: invokevirtual 121	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   781: istore 10
    //   783: ldc 79
    //   785: ldc_w 301
    //   788: iconst_2
    //   789: anewarray 83	java/lang/Object
    //   792: dup
    //   793: iconst_0
    //   794: aload 11
    //   796: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   799: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   802: aastore
    //   803: dup
    //   804: iconst_1
    //   805: iload 10
    //   807: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   810: aastore
    //   811: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   814: aload 11
    //   816: iconst_0
    //   817: putfield 69	com/tencent/mm/pointers/PInt:value	I
    //   820: ldc 207
    //   822: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   825: iconst_1
    //   826: ireturn
    //   827: aload_2
    //   828: arraylength
    //   829: istore 6
    //   831: goto -666 -> 165
    //   834: aload_3
    //   835: arraylength
    //   836: istore 7
    //   838: goto -666 -> 172
    //   841: aload 13
    //   843: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   846: arraylength
    //   847: istore 6
    //   849: goto -577 -> 272
    //   852: aload 16
    //   854: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   857: bipush 13
    //   859: if_icmpne +192 -> 1051
    //   862: aload 13
    //   864: aload_3
    //   865: aload 13
    //   867: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   870: invokestatic 307	com/tencent/mm/jni/utils/UtilsJni:AesGcmDecryptWithUncompress	([B[B)[B
    //   873: putfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   876: aload 13
    //   878: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   881: astore_3
    //   882: aload 13
    //   884: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   887: ifnonnull +153 -> 1040
    //   890: iconst_m1
    //   891: istore 6
    //   893: ldc 79
    //   895: ldc_w 309
    //   898: iconst_3
    //   899: anewarray 83	java/lang/Object
    //   902: dup
    //   903: iconst_0
    //   904: iload_1
    //   905: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   908: aastore
    //   909: dup
    //   910: iconst_1
    //   911: aload_3
    //   912: aastore
    //   913: dup
    //   914: iconst_2
    //   915: iload 6
    //   917: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   920: aastore
    //   921: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   924: goto -455 -> 469
    //   927: astore_2
    //   928: ldc 79
    //   930: aload_2
    //   931: ldc_w 311
    //   934: iconst_0
    //   935: anewarray 83	java/lang/Object
    //   938: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   941: ldc 79
    //   943: ldc 181
    //   945: iconst_1
    //   946: anewarray 83	java/lang/Object
    //   949: dup
    //   950: iconst_0
    //   951: aload_2
    //   952: invokestatic 187	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   955: aastore
    //   956: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   959: aload 11
    //   961: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   964: ifeq +69 -> 1033
    //   967: new 101	com/tencent/mm/f/a/kc
    //   970: dup
    //   971: invokespecial 102	com/tencent/mm/f/a/kc:<init>	()V
    //   974: astore_2
    //   975: aload_2
    //   976: getfield 106	com/tencent/mm/f/a/kc:fHy	Lcom/tencent/mm/f/a/kc$a;
    //   979: aload 11
    //   981: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   984: putfield 111	com/tencent/mm/f/a/kc$a:fHz	I
    //   987: getstatic 117	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   990: aload_2
    //   991: invokevirtual 121	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   994: istore 10
    //   996: ldc 79
    //   998: ldc_w 301
    //   1001: iconst_2
    //   1002: anewarray 83	java/lang/Object
    //   1005: dup
    //   1006: iconst_0
    //   1007: aload 11
    //   1009: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1012: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1015: aastore
    //   1016: dup
    //   1017: iconst_1
    //   1018: iload 10
    //   1020: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1023: aastore
    //   1024: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1027: aload 11
    //   1029: iconst_0
    //   1030: putfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1033: ldc 207
    //   1035: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1038: iconst_0
    //   1039: ireturn
    //   1040: aload 13
    //   1042: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1045: arraylength
    //   1046: istore 6
    //   1048: goto -155 -> 893
    //   1051: aload 16
    //   1053: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1056: bipush 12
    //   1058: if_icmpne +165 -> 1223
    //   1061: aload 13
    //   1063: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1066: ifnonnull +135 -> 1201
    //   1069: iconst_m1
    //   1070: istore 6
    //   1072: lload 4
    //   1074: lconst_0
    //   1075: lcmp
    //   1076: ifne +22 -> 1098
    //   1079: ldc 79
    //   1081: ldc_w 313
    //   1084: iconst_1
    //   1085: anewarray 83	java/lang/Object
    //   1088: dup
    //   1089: iconst_0
    //   1090: iload_1
    //   1091: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1094: aastore
    //   1095: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1098: aload 13
    //   1100: lload 4
    //   1102: aload 13
    //   1104: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1107: invokestatic 317	com/tencent/mm/jni/utils/UtilsJni:HybridEcdhDecrypt	(J[B)[B
    //   1110: putfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1113: lload 4
    //   1115: invokestatic 320	com/tencent/mm/protocal/f:TX	(J)V
    //   1118: aload 14
    //   1120: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1123: istore 8
    //   1125: aload 13
    //   1127: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1130: astore_3
    //   1131: aload 13
    //   1133: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1136: ifnonnull +76 -> 1212
    //   1139: iconst_m1
    //   1140: istore 7
    //   1142: ldc 79
    //   1144: ldc_w 322
    //   1147: bipush 6
    //   1149: anewarray 83	java/lang/Object
    //   1152: dup
    //   1153: iconst_0
    //   1154: iload_1
    //   1155: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1158: aastore
    //   1159: dup
    //   1160: iconst_1
    //   1161: iload 8
    //   1163: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1166: aastore
    //   1167: dup
    //   1168: iconst_2
    //   1169: lload 4
    //   1171: invokestatic 327	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1174: aastore
    //   1175: dup
    //   1176: iconst_3
    //   1177: aload_3
    //   1178: aastore
    //   1179: dup
    //   1180: iconst_4
    //   1181: iload 6
    //   1183: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1186: aastore
    //   1187: dup
    //   1188: iconst_5
    //   1189: iload 7
    //   1191: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1194: aastore
    //   1195: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1198: goto -729 -> 469
    //   1201: aload 13
    //   1203: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1206: arraylength
    //   1207: istore 6
    //   1209: goto -137 -> 1072
    //   1212: aload 13
    //   1214: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1217: arraylength
    //   1218: istore 7
    //   1220: goto -78 -> 1142
    //   1223: aload 16
    //   1225: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1228: bipush 11
    //   1230: if_icmpne -761 -> 469
    //   1233: aload 13
    //   1235: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1238: ifnonnull +135 -> 1373
    //   1241: iconst_m1
    //   1242: istore 6
    //   1244: lload 4
    //   1246: lconst_0
    //   1247: lcmp
    //   1248: ifne +22 -> 1270
    //   1251: ldc 79
    //   1253: ldc_w 329
    //   1256: iconst_1
    //   1257: anewarray 83	java/lang/Object
    //   1260: dup
    //   1261: iconst_0
    //   1262: iload_1
    //   1263: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1266: aastore
    //   1267: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1270: aload 13
    //   1272: lload 4
    //   1274: aload 13
    //   1276: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1279: invokestatic 332	com/tencent/mm/jni/utils/UtilsJni:AxEcdhDecrypt	(J[B)[B
    //   1282: putfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1285: lload 4
    //   1287: invokestatic 335	com/tencent/mm/jni/utils/UtilsJni:ReleaseAxEcdhCryptoEngine	(J)V
    //   1290: aload 14
    //   1292: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1295: istore 8
    //   1297: aload 13
    //   1299: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1302: astore_3
    //   1303: aload 13
    //   1305: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1308: ifnonnull +76 -> 1384
    //   1311: iconst_m1
    //   1312: istore 7
    //   1314: ldc 79
    //   1316: ldc_w 337
    //   1319: bipush 6
    //   1321: anewarray 83	java/lang/Object
    //   1324: dup
    //   1325: iconst_0
    //   1326: iload_1
    //   1327: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1330: aastore
    //   1331: dup
    //   1332: iconst_1
    //   1333: iload 8
    //   1335: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1338: aastore
    //   1339: dup
    //   1340: iconst_2
    //   1341: lload 4
    //   1343: invokestatic 327	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1346: aastore
    //   1347: dup
    //   1348: iconst_3
    //   1349: aload_3
    //   1350: aastore
    //   1351: dup
    //   1352: iconst_4
    //   1353: iload 6
    //   1355: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1358: aastore
    //   1359: dup
    //   1360: iconst_5
    //   1361: iload 7
    //   1363: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1366: aastore
    //   1367: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1370: goto -901 -> 469
    //   1373: aload 13
    //   1375: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1378: arraylength
    //   1379: istore 6
    //   1381: goto -137 -> 1244
    //   1384: aload 13
    //   1386: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1389: arraylength
    //   1390: istore 7
    //   1392: goto -78 -> 1314
    //   1395: astore_3
    //   1396: ldc 79
    //   1398: ldc 160
    //   1400: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1403: goto -802 -> 601
    //   1406: aload 15
    //   1408: aload 13
    //   1410: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1413: invokeinterface 222 2 0
    //   1418: istore 6
    //   1420: ldc 79
    //   1422: ldc_w 339
    //   1425: iconst_5
    //   1426: anewarray 83	java/lang/Object
    //   1429: dup
    //   1430: iconst_0
    //   1431: iload_1
    //   1432: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1435: aastore
    //   1436: dup
    //   1437: iconst_1
    //   1438: aload 16
    //   1440: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1443: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1446: aastore
    //   1447: dup
    //   1448: iconst_2
    //   1449: iload 6
    //   1451: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1454: aastore
    //   1455: dup
    //   1456: iconst_3
    //   1457: aload 13
    //   1459: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1462: arraylength
    //   1463: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1466: aastore
    //   1467: dup
    //   1468: iconst_4
    //   1469: aload_0
    //   1470: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   1473: invokevirtual 342	com/tencent/mm/protocal/l$e:getHeadExtFlags	()I
    //   1476: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1479: aastore
    //   1480: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1483: aload_0
    //   1484: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   1487: iload 6
    //   1489: invokevirtual 232	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   1492: iload 6
    //   1494: sipush -305
    //   1497: if_icmpne -851 -> 646
    //   1500: ldc 79
    //   1502: ldc_w 344
    //   1505: iconst_2
    //   1506: anewarray 83	java/lang/Object
    //   1509: dup
    //   1510: iconst_0
    //   1511: invokestatic 347	com/tencent/mm/protocal/f:hoP	()I
    //   1514: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1517: aastore
    //   1518: dup
    //   1519: iconst_1
    //   1520: iload_1
    //   1521: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1524: aastore
    //   1525: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1528: invokestatic 350	com/tencent/mm/protocal/f:hoM	()Z
    //   1531: pop
    //   1532: goto -886 -> 646
    //   1535: astore_2
    //   1536: ldc 79
    //   1538: new 194	java/lang/StringBuilder
    //   1541: dup
    //   1542: ldc_w 352
    //   1545: invokespecial 353	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1548: aload_2
    //   1549: invokevirtual 356	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1552: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: ldc_w 361
    //   1558: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: aload 13
    //   1563: getfield 135	com/tencent/mm/pointers/PByteArray:value	[B
    //   1566: invokestatic 363	com/tencent/mm/an/z:toHexString	([B)Ljava/lang/String;
    //   1569: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1578: aload_0
    //   1579: getfield 46	com/tencent/mm/an/z:lDr	Lcom/tencent/mm/protocal/l$e;
    //   1582: iconst_m1
    //   1583: invokevirtual 232	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   1586: ldc 207
    //   1588: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1591: iconst_1
    //   1592: ireturn
    //   1593: ldc 79
    //   1595: ldc_w 365
    //   1598: iconst_1
    //   1599: anewarray 83	java/lang/Object
    //   1602: dup
    //   1603: iconst_0
    //   1604: iload_1
    //   1605: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1608: aastore
    //   1609: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1612: goto -653 -> 959
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1615	0	this	z
    //   0	1615	1	paramInt	int
    //   0	1615	2	paramArrayOfByte1	byte[]
    //   0	1615	3	paramArrayOfByte2	byte[]
    //   0	1615	4	paramLong	long
    //   163	1335	6	i	int
    //   170	1221	7	j	int
    //   245	1089	8	k	int
    //   252	63	9	m	int
    //   231	788	10	bool	boolean
    //   84	944	11	localPInt1	PInt
    //   12	646	12	localPByteArray1	PByteArray
    //   45	1517	13	localPByteArray2	PByteArray
    //   55	1236	14	localPInt2	PInt
    //   64	1343	15	localc	com.tencent.mm.protocal.l.c
    //   74	1365	16	localPInt3	PInt
    //   96	251	17	localPInt4	PInt
    //   259	64	18	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   98	151	927	java/lang/Exception
    //   172	269	927	java/lang/Exception
    //   272	337	927	java/lang/Exception
    //   342	354	927	java/lang/Exception
    //   382	414	927	java/lang/Exception
    //   414	433	927	java/lang/Exception
    //   433	469	927	java/lang/Exception
    //   469	555	927	java/lang/Exception
    //   555	574	927	java/lang/Exception
    //   601	646	927	java/lang/Exception
    //   646	684	927	java/lang/Exception
    //   684	712	927	java/lang/Exception
    //   726	774	927	java/lang/Exception
    //   774	820	927	java/lang/Exception
    //   827	831	927	java/lang/Exception
    //   834	838	927	java/lang/Exception
    //   841	849	927	java/lang/Exception
    //   852	890	927	java/lang/Exception
    //   893	924	927	java/lang/Exception
    //   1040	1048	927	java/lang/Exception
    //   1051	1069	927	java/lang/Exception
    //   1079	1098	927	java/lang/Exception
    //   1098	1139	927	java/lang/Exception
    //   1142	1198	927	java/lang/Exception
    //   1201	1209	927	java/lang/Exception
    //   1212	1220	927	java/lang/Exception
    //   1223	1241	927	java/lang/Exception
    //   1251	1270	927	java/lang/Exception
    //   1270	1311	927	java/lang/Exception
    //   1314	1370	927	java/lang/Exception
    //   1373	1381	927	java/lang/Exception
    //   1384	1392	927	java/lang/Exception
    //   1396	1403	927	java/lang/Exception
    //   1406	1492	927	java/lang/Exception
    //   1500	1532	927	java/lang/Exception
    //   1536	1586	927	java/lang/Exception
    //   1593	1612	927	java/lang/Exception
    //   582	601	1395	java/lang/Exception
    //   1406	1492	1535	java/lang/OutOfMemoryError
    //   1500	1532	1535	java/lang/OutOfMemoryError
  }
  
  public final void ay(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202951);
    this.lDr.setProfile(paramArrayOfByte);
    AppMethodBeat.o(202951);
  }
  
  public final byte[] biI()
  {
    AppMethodBeat.i(132473);
    switch (this.type)
    {
    }
    for (;;)
    {
      Object localObject = new byte[0];
      for (;;)
      {
        Log.i("MicroMsg.RemoteResp", "summerauths getAutoAuthKey type[%s] key[%s]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(localObject.length) });
        AppMethodBeat.o(132473);
        return localObject;
        if (((j.i)this.lDr).RBm.Uxi.RLV == null) {
          break;
        }
        localObject = ((j.i)this.lDr).RBm.Uxi.RLV.Tkb.toByteArray();
        continue;
        localObject = ((x.b)this.lDr).RBZ.TKt;
        if ((localObject == null) || (((ecy)localObject).RLV == null)) {
          break label194;
        }
        localObject = ((ecy)localObject).RLV.Tkb.toByteArray();
      }
      label194:
      Log.d("MicroMsg.RemoteResp", "summerauth reg[%s] SecAuthRegKeySect is null", new Object[] { Integer.valueOf(this.type) });
    }
  }
  
  public final String biJ()
  {
    AppMethodBeat.i(132474);
    if (this.type == 381)
    {
      Object localObject = ((t.b)this.lDr).RBT.Tct;
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((dsn)localObject).TYV);
        AppMethodBeat.o(132474);
        return localObject;
      }
    }
    AppMethodBeat.o(132474);
    return "";
  }
  
  public final String biK()
  {
    AppMethodBeat.i(132475);
    if (this.type == 381)
    {
      Object localObject = ((t.b)this.lDr).RBT.Tct;
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((dsn)localObject).TYU);
        AppMethodBeat.o(132475);
        return localObject;
      }
    }
    AppMethodBeat.o(132475);
    return "";
  }
  
  public final int biL()
  {
    if (this.type == 381) {
      return ((t.b)this.lDr).RBT.Tbu;
    }
    return 0;
  }
  
  public final byte[] bip()
  {
    return this.fYH;
  }
  
  public final byte[] bir()
  {
    switch (this.type)
    {
    default: 
      return new byte[0];
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      return ((j.i)this.lDr).RBq;
    }
    return ((x.b)this.lDr).RBq;
  }
  
  public final String bis()
  {
    switch (this.type)
    {
    default: 
      return "";
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      return ((j.i)this.lDr).fGe;
    }
    return ((x.b)this.lDr).RBZ.UserName;
  }
  
  public final byte[] getAuthResponse()
  {
    AppMethodBeat.i(132477);
    byte[] arrayOfByte = this.lDr.getAuthResponse();
    AppMethodBeat.o(132477);
    return arrayOfByte;
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(132476);
    int i = this.lDr.getCmdId();
    AppMethodBeat.o(132476);
    return i;
  }
  
  public final String getErrMsg()
  {
    AppMethodBeat.i(132468);
    String str = this.lDr.getErrMsg();
    AppMethodBeat.o(132468);
    return str;
  }
  
  public final int getHeadExtFlags()
  {
    AppMethodBeat.i(132467);
    int i = this.lDr.getHeadExtFlags();
    AppMethodBeat.o(132467);
    return i;
  }
  
  public final int getRetCode()
  {
    AppMethodBeat.i(132470);
    int i = this.lDr.getRetCode();
    AppMethodBeat.o(132470);
    return i;
  }
  
  public final int getUin()
  {
    switch (this.type)
    {
    default: 
      return 0;
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      return ((j.i)this.lDr).RBm.Uxi.vhf;
    }
    return ((x.b)this.lDr).RBZ.vhf;
  }
  
  public final byte[] sE(int paramInt)
  {
    AppMethodBeat.i(132472);
    byte[] arrayOfByte = new byte[0];
    switch (this.type)
    {
    default: 
      if (arrayOfByte != null) {
        break;
      }
    }
    for (int i = -1;; i = arrayOfByte.length)
    {
      Log.i("MicroMsg.RemoteResp", "summerauths getSessionKey seesionKeyType[%s] [%s] [%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Util.getStack() });
      AppMethodBeat.o(132472);
      return arrayOfByte;
      arrayOfByte = ((j.i)this.lDr).arm(paramInt);
      break;
      arrayOfByte = ((x.b)this.lDr).arm(paramInt);
      break;
    }
  }
  
  public final void setErrMsg(String paramString)
  {
    AppMethodBeat.i(132469);
    this.lDr.setErrMsg(paramString);
    AppMethodBeat.o(132469);
  }
  
  public final void setRetCode(int paramInt)
  {
    AppMethodBeat.i(132471);
    this.lDr.setRetCode(paramInt);
    AppMethodBeat.o(132471);
  }
  
  public static abstract interface a
  {
    public abstract void hc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.z
 * JD-Core Version:    0.7.0.1
 */