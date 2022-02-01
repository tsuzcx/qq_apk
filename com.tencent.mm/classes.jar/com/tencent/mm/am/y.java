package com.tencent.mm.am;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lg;
import com.tencent.mm.bx.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.i.a;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.eli;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.ewn;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends i.a
{
  private static a ovd;
  private static char[] ove = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private byte[] ieJ;
  private l.e ovc;
  private int type;
  
  public y(l.e parame, int paramInt)
  {
    this.ovc = parame;
    this.type = paramInt;
  }
  
  public static void a(a parama)
  {
    ovd = parama;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PInt paramPInt, esc paramesc)
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
          paramArrayOfByte1 = new lg();
          paramArrayOfByte1.hMY.hMZ = localPInt2.value;
          boolean bool2 = paramArrayOfByte1.publish();
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
              if ((!Util.isNullOrNil(y.this)) && (y.bGw() != null)) {
                y.bGw().iD(y.this);
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
      paramesc.parseFrom(localPByteArray1.value);
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
      localStringBuilder.append(ove[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(ove[(paramArrayOfByte[i] & 0xF)]);
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
    //   0: ldc 201
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 63	com/tencent/mm/pointers/PByteArray
    //   8: dup
    //   9: invokespecial 64	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   12: astore 12
    //   14: aload_0
    //   15: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   18: instanceof 203
    //   21: ifne +17 -> 38
    //   24: ldc 79
    //   26: ldc 205
    //   28: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 201
    //   33: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   58: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   61: checkcast 203	com/tencent/mm/protocal/l$c
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
    //   100: invokeinterface 211 1 0
    //   105: ifeq +53 -> 158
    //   108: aload 15
    //   110: aload_2
    //   111: invokeinterface 215 2 0
    //   116: istore_1
    //   117: ldc 79
    //   119: ldc 217
    //   121: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   128: iload_1
    //   129: invokevirtual 225	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   132: getstatic 231	com/tencent/mm/platformtools/z:pCp	Ljava/lang/String;
    //   135: invokestatic 235	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   138: ifne +13 -> 151
    //   141: aload_0
    //   142: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   145: getstatic 231	com/tencent/mm/platformtools/z:pCp	Ljava/lang/String;
    //   148: invokevirtual 238	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   151: ldc 201
    //   153: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: aload_2
    //   159: ifnonnull +663 -> 822
    //   162: iconst_m1
    //   163: istore 6
    //   165: aload_3
    //   166: ifnonnull +663 -> 829
    //   169: iconst_m1
    //   170: istore 7
    //   172: ldc 79
    //   174: ldc 240
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
    //   207: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
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
    //   256: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   259: astore 18
    //   261: aload 13
    //   263: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   266: ifnonnull +570 -> 836
    //   269: iconst_m1
    //   270: istore 6
    //   272: ldc 79
    //   274: ldc 242
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
    //   339: ifeq +1246 -> 1585
    //   342: aload_0
    //   343: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   346: aload 17
    //   348: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   351: invokevirtual 245	com/tencent/mm/protocal/l$e:setHeadExtFlags	(I)V
    //   354: iload_1
    //   355: sipush 701
    //   358: if_icmpeq +73 -> 431
    //   361: iload_1
    //   362: sipush 702
    //   365: if_icmpeq +66 -> 431
    //   368: iload_1
    //   369: sipush 252
    //   372: if_icmpeq +59 -> 431
    //   375: iload_1
    //   376: sipush 763
    //   379: if_icmpeq +52 -> 431
    //   382: sipush 10001
    //   385: getstatic 248	com/tencent/mm/platformtools/z:pCm	I
    //   388: if_icmpne +43 -> 431
    //   391: getstatic 251	com/tencent/mm/platformtools/z:pCn	I
    //   394: ifle +37 -> 431
    //   397: getstatic 251	com/tencent/mm/platformtools/z:pCn	I
    //   400: iconst_2
    //   401: if_icmpne +11 -> 412
    //   404: ldc 253
    //   406: ldc 253
    //   408: iconst_0
    //   409: invokestatic 259	com/tencent/mm/protocal/ac:aM	(Ljava/lang/String;Ljava/lang/String;I)V
    //   412: iconst_0
    //   413: putstatic 251	com/tencent/mm/platformtools/z:pCn	I
    //   416: aload 14
    //   418: bipush 243
    //   420: putfield 69	com/tencent/mm/pointers/PInt:value	I
    //   423: ldc 79
    //   425: ldc_w 261
    //   428: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload 14
    //   433: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   436: sipush -306
    //   439: if_icmpne +408 -> 847
    //   442: ldc 79
    //   444: ldc_w 266
    //   447: iconst_1
    //   448: anewarray 83	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: getstatic 272	com/tencent/mm/protocal/f:Yxs	Z
    //   456: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   459: aastore
    //   460: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: iconst_0
    //   464: putstatic 272	com/tencent/mm/protocal/f:Yxs	Z
    //   467: aload 14
    //   469: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   472: bipush 243
    //   474: if_icmpeq +79 -> 553
    //   477: aload 14
    //   479: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   482: bipush 154
    //   484: if_icmpeq +69 -> 553
    //   487: aload 14
    //   489: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   492: sipush -3001
    //   495: if_icmpeq +58 -> 553
    //   498: aload 14
    //   500: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   503: sipush -3002
    //   506: if_icmpeq +47 -> 553
    //   509: aload 14
    //   511: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   514: sipush -3003
    //   517: if_icmpeq +36 -> 553
    //   520: aload 14
    //   522: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   525: sipush -306
    //   528: if_icmpeq +25 -> 553
    //   531: aload 14
    //   533: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   536: sipush -3006
    //   539: if_icmpeq +14 -> 553
    //   542: aload 14
    //   544: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   547: sipush -3800
    //   550: if_icmpne +848 -> 1398
    //   553: aload_0
    //   554: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   557: aload 14
    //   559: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   562: invokevirtual 225	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   565: aload 14
    //   567: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   570: istore 6
    //   572: iload 6
    //   574: sipush -3002
    //   577: if_icmpne +67 -> 644
    //   580: aload_0
    //   581: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   584: new 127	java/lang/String
    //   587: dup
    //   588: aload 13
    //   590: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   593: invokespecial 132	java/lang/String:<init>	([B)V
    //   596: invokevirtual 238	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   599: ldc 79
    //   601: ldc_w 274
    //   604: iconst_4
    //   605: anewarray 83	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: iload_1
    //   611: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_1
    //   617: aload 14
    //   619: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   622: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: aastore
    //   626: dup
    //   627: iconst_2
    //   628: aload 11
    //   630: aastore
    //   631: dup
    //   632: iconst_3
    //   633: aload_0
    //   634: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   637: invokevirtual 277	com/tencent/mm/protocal/l$e:getErrMsg	()Ljava/lang/String;
    //   640: aastore
    //   641: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   644: aload_0
    //   645: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   648: aload_2
    //   649: arraylength
    //   650: i2l
    //   651: invokevirtual 281	com/tencent/mm/protocal/l$e:setBufferSize	(J)V
    //   654: aload_0
    //   655: aload 12
    //   657: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   660: putfield 283	com/tencent/mm/am/y:ieJ	[B
    //   663: getstatic 231	com/tencent/mm/platformtools/z:pCp	Ljava/lang/String;
    //   666: invokestatic 235	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   669: ifne +13 -> 682
    //   672: aload_0
    //   673: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   676: getstatic 231	com/tencent/mm/platformtools/z:pCp	Ljava/lang/String;
    //   679: invokevirtual 238	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   682: aload 11
    //   684: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   687: ifeq +128 -> 815
    //   690: new 101	com/tencent/mm/autogen/a/lg
    //   693: dup
    //   694: invokespecial 102	com/tencent/mm/autogen/a/lg:<init>	()V
    //   697: astore_2
    //   698: aload_2
    //   699: getfield 106	com/tencent/mm/autogen/a/lg:hMY	Lcom/tencent/mm/autogen/a/lg$a;
    //   702: aload 11
    //   704: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   707: putfield 111	com/tencent/mm/autogen/a/lg$a:hMZ	I
    //   710: iload_1
    //   711: sipush 252
    //   714: if_icmpeq +10 -> 724
    //   717: iload_1
    //   718: sipush 701
    //   721: if_icmpne +51 -> 772
    //   724: aload_0
    //   725: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   728: invokevirtual 287	com/tencent/mm/protocal/l$e:getRetCode	()I
    //   731: ifne +41 -> 772
    //   734: ldc 79
    //   736: ldc_w 289
    //   739: iconst_2
    //   740: anewarray 83	java/lang/Object
    //   743: dup
    //   744: iconst_0
    //   745: aload 11
    //   747: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   750: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   753: aastore
    //   754: dup
    //   755: iconst_1
    //   756: iload_1
    //   757: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   760: aastore
    //   761: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   764: aload_2
    //   765: getfield 106	com/tencent/mm/autogen/a/lg:hMY	Lcom/tencent/mm/autogen/a/lg$a;
    //   768: iconst_1
    //   769: putfield 292	com/tencent/mm/autogen/a/lg$a:hNa	Z
    //   772: aload_2
    //   773: invokevirtual 115	com/tencent/mm/autogen/a/lg:publish	()Z
    //   776: istore 10
    //   778: ldc 79
    //   780: ldc_w 294
    //   783: iconst_2
    //   784: anewarray 83	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload 11
    //   791: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   794: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   797: aastore
    //   798: dup
    //   799: iconst_1
    //   800: iload 10
    //   802: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   805: aastore
    //   806: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   809: aload 11
    //   811: iconst_0
    //   812: putfield 69	com/tencent/mm/pointers/PInt:value	I
    //   815: ldc 201
    //   817: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   820: iconst_1
    //   821: ireturn
    //   822: aload_2
    //   823: arraylength
    //   824: istore 6
    //   826: goto -661 -> 165
    //   829: aload_3
    //   830: arraylength
    //   831: istore 7
    //   833: goto -661 -> 172
    //   836: aload 13
    //   838: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   841: arraylength
    //   842: istore 6
    //   844: goto -572 -> 272
    //   847: aload 16
    //   849: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   852: bipush 13
    //   854: if_icmpne +189 -> 1043
    //   857: aload 13
    //   859: aload_3
    //   860: aload 13
    //   862: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   865: invokestatic 300	com/tencent/mm/jni/utils/UtilsJni:AesGcmDecryptWithUncompress	([B[B)[B
    //   868: putfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   871: aload 13
    //   873: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   876: astore_3
    //   877: aload 13
    //   879: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   882: ifnonnull +150 -> 1032
    //   885: iconst_m1
    //   886: istore 6
    //   888: ldc 79
    //   890: ldc_w 302
    //   893: iconst_3
    //   894: anewarray 83	java/lang/Object
    //   897: dup
    //   898: iconst_0
    //   899: iload_1
    //   900: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   903: aastore
    //   904: dup
    //   905: iconst_1
    //   906: aload_3
    //   907: aastore
    //   908: dup
    //   909: iconst_2
    //   910: iload 6
    //   912: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   915: aastore
    //   916: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   919: goto -452 -> 467
    //   922: astore_2
    //   923: ldc 79
    //   925: aload_2
    //   926: ldc_w 304
    //   929: iconst_0
    //   930: anewarray 83	java/lang/Object
    //   933: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   936: ldc 79
    //   938: ldc 175
    //   940: iconst_1
    //   941: anewarray 83	java/lang/Object
    //   944: dup
    //   945: iconst_0
    //   946: aload_2
    //   947: invokestatic 181	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   950: aastore
    //   951: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   954: aload 11
    //   956: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   959: ifeq +66 -> 1025
    //   962: new 101	com/tencent/mm/autogen/a/lg
    //   965: dup
    //   966: invokespecial 102	com/tencent/mm/autogen/a/lg:<init>	()V
    //   969: astore_2
    //   970: aload_2
    //   971: getfield 106	com/tencent/mm/autogen/a/lg:hMY	Lcom/tencent/mm/autogen/a/lg$a;
    //   974: aload 11
    //   976: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   979: putfield 111	com/tencent/mm/autogen/a/lg$a:hMZ	I
    //   982: aload_2
    //   983: invokevirtual 115	com/tencent/mm/autogen/a/lg:publish	()Z
    //   986: istore 10
    //   988: ldc 79
    //   990: ldc_w 294
    //   993: iconst_2
    //   994: anewarray 83	java/lang/Object
    //   997: dup
    //   998: iconst_0
    //   999: aload 11
    //   1001: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1004: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1007: aastore
    //   1008: dup
    //   1009: iconst_1
    //   1010: iload 10
    //   1012: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1015: aastore
    //   1016: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1019: aload 11
    //   1021: iconst_0
    //   1022: putfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1025: ldc 201
    //   1027: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1030: iconst_0
    //   1031: ireturn
    //   1032: aload 13
    //   1034: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1037: arraylength
    //   1038: istore 6
    //   1040: goto -152 -> 888
    //   1043: aload 16
    //   1045: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1048: bipush 12
    //   1050: if_icmpne +165 -> 1215
    //   1053: aload 13
    //   1055: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1058: ifnonnull +135 -> 1193
    //   1061: iconst_m1
    //   1062: istore 6
    //   1064: lload 4
    //   1066: lconst_0
    //   1067: lcmp
    //   1068: ifne +22 -> 1090
    //   1071: ldc 79
    //   1073: ldc_w 306
    //   1076: iconst_1
    //   1077: anewarray 83	java/lang/Object
    //   1080: dup
    //   1081: iconst_0
    //   1082: iload_1
    //   1083: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1086: aastore
    //   1087: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1090: aload 13
    //   1092: lload 4
    //   1094: aload 13
    //   1096: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1099: invokestatic 310	com/tencent/mm/jni/utils/UtilsJni:HybridEcdhDecrypt	(J[B)[B
    //   1102: putfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1105: lload 4
    //   1107: invokestatic 313	com/tencent/mm/protocal/f:yn	(J)V
    //   1110: aload 14
    //   1112: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1115: istore 8
    //   1117: aload 13
    //   1119: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1122: astore_3
    //   1123: aload 13
    //   1125: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1128: ifnonnull +76 -> 1204
    //   1131: iconst_m1
    //   1132: istore 7
    //   1134: ldc 79
    //   1136: ldc_w 315
    //   1139: bipush 6
    //   1141: anewarray 83	java/lang/Object
    //   1144: dup
    //   1145: iconst_0
    //   1146: iload_1
    //   1147: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1150: aastore
    //   1151: dup
    //   1152: iconst_1
    //   1153: iload 8
    //   1155: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1158: aastore
    //   1159: dup
    //   1160: iconst_2
    //   1161: lload 4
    //   1163: invokestatic 320	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1166: aastore
    //   1167: dup
    //   1168: iconst_3
    //   1169: aload_3
    //   1170: aastore
    //   1171: dup
    //   1172: iconst_4
    //   1173: iload 6
    //   1175: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1178: aastore
    //   1179: dup
    //   1180: iconst_5
    //   1181: iload 7
    //   1183: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1186: aastore
    //   1187: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1190: goto -723 -> 467
    //   1193: aload 13
    //   1195: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1198: arraylength
    //   1199: istore 6
    //   1201: goto -137 -> 1064
    //   1204: aload 13
    //   1206: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1209: arraylength
    //   1210: istore 7
    //   1212: goto -78 -> 1134
    //   1215: aload 16
    //   1217: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1220: bipush 11
    //   1222: if_icmpne -755 -> 467
    //   1225: aload 13
    //   1227: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1230: ifnonnull +135 -> 1365
    //   1233: iconst_m1
    //   1234: istore 6
    //   1236: lload 4
    //   1238: lconst_0
    //   1239: lcmp
    //   1240: ifne +22 -> 1262
    //   1243: ldc 79
    //   1245: ldc_w 322
    //   1248: iconst_1
    //   1249: anewarray 83	java/lang/Object
    //   1252: dup
    //   1253: iconst_0
    //   1254: iload_1
    //   1255: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1258: aastore
    //   1259: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1262: aload 13
    //   1264: lload 4
    //   1266: aload 13
    //   1268: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1271: invokestatic 325	com/tencent/mm/jni/utils/UtilsJni:AxEcdhDecrypt	(J[B)[B
    //   1274: putfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1277: lload 4
    //   1279: invokestatic 328	com/tencent/mm/jni/utils/UtilsJni:ReleaseAxEcdhCryptoEngine	(J)V
    //   1282: aload 14
    //   1284: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1287: istore 8
    //   1289: aload 13
    //   1291: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1294: astore_3
    //   1295: aload 13
    //   1297: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1300: ifnonnull +76 -> 1376
    //   1303: iconst_m1
    //   1304: istore 7
    //   1306: ldc 79
    //   1308: ldc_w 330
    //   1311: bipush 6
    //   1313: anewarray 83	java/lang/Object
    //   1316: dup
    //   1317: iconst_0
    //   1318: iload_1
    //   1319: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1322: aastore
    //   1323: dup
    //   1324: iconst_1
    //   1325: iload 8
    //   1327: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1330: aastore
    //   1331: dup
    //   1332: iconst_2
    //   1333: lload 4
    //   1335: invokestatic 320	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1338: aastore
    //   1339: dup
    //   1340: iconst_3
    //   1341: aload_3
    //   1342: aastore
    //   1343: dup
    //   1344: iconst_4
    //   1345: iload 6
    //   1347: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1350: aastore
    //   1351: dup
    //   1352: iconst_5
    //   1353: iload 7
    //   1355: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1358: aastore
    //   1359: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1362: goto -895 -> 467
    //   1365: aload 13
    //   1367: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1370: arraylength
    //   1371: istore 6
    //   1373: goto -137 -> 1236
    //   1376: aload 13
    //   1378: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1381: arraylength
    //   1382: istore 7
    //   1384: goto -78 -> 1306
    //   1387: astore_3
    //   1388: ldc 79
    //   1390: ldc 154
    //   1392: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1395: goto -796 -> 599
    //   1398: aload 15
    //   1400: aload 13
    //   1402: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1405: invokeinterface 215 2 0
    //   1410: istore 6
    //   1412: ldc 79
    //   1414: ldc_w 332
    //   1417: iconst_5
    //   1418: anewarray 83	java/lang/Object
    //   1421: dup
    //   1422: iconst_0
    //   1423: iload_1
    //   1424: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1427: aastore
    //   1428: dup
    //   1429: iconst_1
    //   1430: aload 16
    //   1432: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   1435: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1438: aastore
    //   1439: dup
    //   1440: iconst_2
    //   1441: iload 6
    //   1443: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1446: aastore
    //   1447: dup
    //   1448: iconst_3
    //   1449: aload 13
    //   1451: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1454: arraylength
    //   1455: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1458: aastore
    //   1459: dup
    //   1460: iconst_4
    //   1461: aload_0
    //   1462: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   1465: invokevirtual 335	com/tencent/mm/protocal/l$e:getHeadExtFlags	()I
    //   1468: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1471: aastore
    //   1472: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1475: aload_0
    //   1476: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   1479: iload 6
    //   1481: invokevirtual 225	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   1484: iload 6
    //   1486: sipush -305
    //   1489: if_icmpne -845 -> 644
    //   1492: ldc 79
    //   1494: ldc_w 337
    //   1497: iconst_2
    //   1498: anewarray 83	java/lang/Object
    //   1501: dup
    //   1502: iconst_0
    //   1503: invokestatic 340	com/tencent/mm/protocal/f:iPL	()I
    //   1506: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1509: aastore
    //   1510: dup
    //   1511: iconst_1
    //   1512: iload_1
    //   1513: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1516: aastore
    //   1517: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1520: invokestatic 343	com/tencent/mm/protocal/f:iPI	()Z
    //   1523: pop
    //   1524: goto -880 -> 644
    //   1527: astore_2
    //   1528: ldc 79
    //   1530: new 188	java/lang/StringBuilder
    //   1533: dup
    //   1534: ldc_w 345
    //   1537: invokespecial 346	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1540: aload_2
    //   1541: invokevirtual 349	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1544: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: ldc_w 354
    //   1550: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: aload 13
    //   1555: getfield 129	com/tencent/mm/pointers/PByteArray:value	[B
    //   1558: invokestatic 356	com/tencent/mm/am/y:toHexString	([B)Ljava/lang/String;
    //   1561: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1567: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1570: aload_0
    //   1571: getfield 46	com/tencent/mm/am/y:ovc	Lcom/tencent/mm/protocal/l$e;
    //   1574: iconst_m1
    //   1575: invokevirtual 225	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   1578: ldc 201
    //   1580: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1583: iconst_1
    //   1584: ireturn
    //   1585: ldc 79
    //   1587: ldc_w 358
    //   1590: iconst_1
    //   1591: anewarray 83	java/lang/Object
    //   1594: dup
    //   1595: iconst_0
    //   1596: iload_1
    //   1597: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1600: aastore
    //   1601: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1604: goto -650 -> 954
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1607	0	this	y
    //   0	1607	1	paramInt	int
    //   0	1607	2	paramArrayOfByte1	byte[]
    //   0	1607	3	paramArrayOfByte2	byte[]
    //   0	1607	4	paramLong	long
    //   163	1327	6	i	int
    //   170	1213	7	j	int
    //   245	1081	8	k	int
    //   252	63	9	m	int
    //   231	780	10	bool	boolean
    //   84	936	11	localPInt1	PInt
    //   12	644	12	localPByteArray1	PByteArray
    //   45	1509	13	localPByteArray2	PByteArray
    //   55	1228	14	localPInt2	PInt
    //   64	1335	15	localc	com.tencent.mm.protocal.l.c
    //   74	1357	16	localPInt3	PInt
    //   96	251	17	localPInt4	PInt
    //   259	64	18	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   98	151	922	java/lang/Exception
    //   172	269	922	java/lang/Exception
    //   272	337	922	java/lang/Exception
    //   342	354	922	java/lang/Exception
    //   382	412	922	java/lang/Exception
    //   412	431	922	java/lang/Exception
    //   431	467	922	java/lang/Exception
    //   467	553	922	java/lang/Exception
    //   553	572	922	java/lang/Exception
    //   599	644	922	java/lang/Exception
    //   644	682	922	java/lang/Exception
    //   682	710	922	java/lang/Exception
    //   724	772	922	java/lang/Exception
    //   772	815	922	java/lang/Exception
    //   822	826	922	java/lang/Exception
    //   829	833	922	java/lang/Exception
    //   836	844	922	java/lang/Exception
    //   847	885	922	java/lang/Exception
    //   888	919	922	java/lang/Exception
    //   1032	1040	922	java/lang/Exception
    //   1043	1061	922	java/lang/Exception
    //   1071	1090	922	java/lang/Exception
    //   1090	1131	922	java/lang/Exception
    //   1134	1190	922	java/lang/Exception
    //   1193	1201	922	java/lang/Exception
    //   1204	1212	922	java/lang/Exception
    //   1215	1233	922	java/lang/Exception
    //   1243	1262	922	java/lang/Exception
    //   1262	1303	922	java/lang/Exception
    //   1306	1362	922	java/lang/Exception
    //   1365	1373	922	java/lang/Exception
    //   1376	1384	922	java/lang/Exception
    //   1388	1395	922	java/lang/Exception
    //   1398	1484	922	java/lang/Exception
    //   1492	1524	922	java/lang/Exception
    //   1528	1578	922	java/lang/Exception
    //   1585	1604	922	java/lang/Exception
    //   580	599	1387	java/lang/Exception
    //   1398	1484	1527	java/lang/OutOfMemoryError
    //   1492	1524	1527	java/lang/OutOfMemoryError
  }
  
  public final void ay(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(236810);
    this.ovc.setProfile(paramArrayOfByte);
    AppMethodBeat.o(236810);
  }
  
  public final byte[] bFZ()
  {
    return this.ieJ;
  }
  
  public final byte[] bGb()
  {
    switch (this.type)
    {
    default: 
      return new byte[0];
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      return ((j.i)this.ovc).YxT;
    }
    return ((x.b)this.ovc).YxT;
  }
  
  public final String bGc()
  {
    switch (this.type)
    {
    default: 
      return "";
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      return ((j.i)this.ovc).hLv;
    }
    return ((x.b)this.ovc).YyC.UserName;
  }
  
  public final byte[] bGs()
  {
    AppMethodBeat.i(132473);
    Object localObject;
    label72:
    int j;
    switch (this.type)
    {
    default: 
      localObject = new byte[0];
      j = this.type;
      if (localObject != null) {
        break;
      }
    }
    for (int i = -1;; i = localObject.length)
    {
      Log.i("MicroMsg.RemoteResp", "summerauths getAutoAuthKey type[%s] key[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(132473);
      return localObject;
      if (((j.i)this.ovc).YxP.abQQ.YJj == null) {
        break;
      }
      localObject = ((j.i)this.ovc).YxP.abQQ.YJj.aaxD.toByteArray();
      break label72;
      localObject = ((x.b)this.ovc).YyC.abai;
      if ((localObject != null) && (((ewn)localObject).YJj != null))
      {
        localObject = ((ewn)localObject).YJj.aaxD.toByteArray();
        break label72;
      }
      Log.d("MicroMsg.RemoteResp", "summerauth reg[%s] SecAuthRegKeySect is null", new Object[] { Integer.valueOf(this.type) });
      break;
    }
  }
  
  public final String bGt()
  {
    AppMethodBeat.i(132474);
    if (this.type == 381)
    {
      Object localObject = ((t.b)this.ovc).Yyw.aapI;
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((eli)localObject).abpS);
        AppMethodBeat.o(132474);
        return localObject;
      }
    }
    AppMethodBeat.o(132474);
    return "";
  }
  
  public final String bGu()
  {
    AppMethodBeat.i(132475);
    if (this.type == 381)
    {
      Object localObject = ((t.b)this.ovc).Yyw.aapI;
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((eli)localObject).abpR);
        AppMethodBeat.o(132475);
        return localObject;
      }
    }
    AppMethodBeat.o(132475);
    return "";
  }
  
  public final int bGv()
  {
    if (this.type == 381) {
      return ((t.b)this.ovc).Yyw.aaoG;
    }
    return 0;
  }
  
  public final byte[] getAuthResponse()
  {
    AppMethodBeat.i(132477);
    byte[] arrayOfByte = this.ovc.getAuthResponse();
    AppMethodBeat.o(132477);
    return arrayOfByte;
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(132476);
    int i = this.ovc.getCmdId();
    AppMethodBeat.o(132476);
    return i;
  }
  
  public final String getErrMsg()
  {
    AppMethodBeat.i(132468);
    String str = this.ovc.getErrMsg();
    AppMethodBeat.o(132468);
    return str;
  }
  
  public final int getHeadExtFlags()
  {
    AppMethodBeat.i(132467);
    int i = this.ovc.getHeadExtFlags();
    AppMethodBeat.o(132467);
    return i;
  }
  
  public final int getRetCode()
  {
    AppMethodBeat.i(132470);
    int i = this.ovc.getRetCode();
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
      return ((j.i)this.ovc).YxP.abQQ.yth;
    }
    return ((x.b)this.ovc).YyC.yth;
  }
  
  public final byte[] sA(int paramInt)
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
      arrayOfByte = ((j.i)this.ovc).axu(paramInt);
      break;
      arrayOfByte = ((x.b)this.ovc).axu(paramInt);
      break;
    }
  }
  
  public final void setErrMsg(String paramString)
  {
    AppMethodBeat.i(132469);
    this.ovc.setErrMsg(paramString);
    AppMethodBeat.o(132469);
  }
  
  public final void setRetCode(int paramInt)
  {
    AppMethodBeat.i(132471);
    this.ovc.setRetCode(paramInt);
    AppMethodBeat.o(132471);
  }
  
  public static abstract interface a
  {
    public abstract void iD(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.y
 * JD-Core Version:    0.7.0.1
 */