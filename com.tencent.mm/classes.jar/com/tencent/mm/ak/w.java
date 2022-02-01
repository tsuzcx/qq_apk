package com.tencent.mm.ak;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.i.a;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class w
  extends i.a
{
  private static a hSc;
  private static char[] hSd = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private byte[] dMA;
  private l.e hSb;
  private int type;
  
  public w(l.e parame, int paramInt)
  {
    this.hSb = parame;
    this.type = paramInt;
  }
  
  private static String Z(byte[] paramArrayOfByte)
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
      localStringBuilder.append(hSd[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(hSd[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(132478);
    return paramArrayOfByte;
  }
  
  public static void a(a parama)
  {
    hSc = parama;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PInt paramPInt, cwj paramcwj)
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
        ae.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(localPInt2.value), Integer.valueOf(localPInt3.value) });
        if (localPInt2.value != 0)
        {
          paramArrayOfByte1 = new ix();
          paramArrayOfByte1.dwG.dwH = localPInt2.value;
          boolean bool2 = a.IvT.l(paramArrayOfByte1);
          ae.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt2.value), Boolean.valueOf(bool2) });
        }
        if (!bool1) {
          continue;
        }
        if ((paramPInt.value == -13) || (paramPInt.value == -102) || (paramPInt.value == -3001))
        {
          ae.e("MicroMsg.RemoteResp", "unpack failed. error:%d", new Object[] { Integer.valueOf(paramPInt.value) });
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
          ae.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", new Object[] { paramArrayOfByte1 });
          new aq(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132464);
              if ((!bu.isNullOrNil(this.hSe)) && (w.aFF() != null)) {
                w.aFF().fG(this.hSe);
              }
              AppMethodBeat.o(132464);
            }
          });
          AppMethodBeat.o(132466);
          return null;
        }
        catch (Exception paramArrayOfByte1)
        {
          ae.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        ae.printErrStackTrace("MicroMsg.RemoteResp", paramArrayOfByte1, "parseFrom unbuild exception, check now!", new Object[0]);
        ae.e("MicroMsg.RemoteResp", "exception:%s", new Object[] { bu.o(paramArrayOfByte1) });
        continue;
      }
      AppMethodBeat.o(132466);
      return null;
      ae.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", new Object[] { Integer.valueOf(110), Integer.valueOf(localPInt1.value) });
      paramcwj.parseFrom(localPByteArray1.value);
      paramArrayOfByte1 = localPByteArray1.value;
      AppMethodBeat.o(132466);
      return paramArrayOfByte1;
      ae.e("MicroMsg.RemoteResp", "unpack failed.");
    }
  }
  
  /* Error */
  public final boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    // Byte code:
    //   0: ldc 206
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 81	com/tencent/mm/pointers/PByteArray
    //   8: dup
    //   9: invokespecial 82	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   12: astore 12
    //   14: aload_0
    //   15: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   18: instanceof 208
    //   21: ifne +17 -> 38
    //   24: ldc 96
    //   26: ldc 210
    //   28: invokestatic 213	com/tencent/mm/sdk/platformtools/ae:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 206
    //   33: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: iconst_0
    //   37: ireturn
    //   38: new 81	com/tencent/mm/pointers/PByteArray
    //   41: dup
    //   42: invokespecial 82	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   45: astore 13
    //   47: new 84	com/tencent/mm/pointers/PInt
    //   50: dup
    //   51: iconst_0
    //   52: invokespecial 88	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   55: astore 14
    //   57: aload_0
    //   58: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   61: checkcast 208	com/tencent/mm/protocal/l$c
    //   64: astore 15
    //   66: new 84	com/tencent/mm/pointers/PInt
    //   69: dup
    //   70: iconst_0
    //   71: invokespecial 88	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   74: astore 16
    //   76: new 84	com/tencent/mm/pointers/PInt
    //   79: dup
    //   80: iconst_0
    //   81: invokespecial 88	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   84: astore 11
    //   86: new 84	com/tencent/mm/pointers/PInt
    //   89: dup
    //   90: sipush 255
    //   93: invokespecial 88	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   96: astore 17
    //   98: aload 15
    //   100: invokeinterface 217 1 0
    //   105: ifeq +53 -> 158
    //   108: aload 15
    //   110: aload_2
    //   111: invokeinterface 221 2 0
    //   116: istore_1
    //   117: ldc 96
    //   119: ldc 223
    //   121: invokestatic 226	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   128: iload_1
    //   129: invokevirtual 231	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   132: getstatic 237	com/tencent/mm/platformtools/ac:iRK	Ljava/lang/String;
    //   135: invokestatic 241	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   138: ifne +13 -> 151
    //   141: aload_0
    //   142: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   145: getstatic 237	com/tencent/mm/platformtools/ac:iRK	Ljava/lang/String;
    //   148: invokevirtual 244	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   151: ldc 206
    //   153: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: aload_2
    //   159: ifnonnull +657 -> 816
    //   162: iconst_m1
    //   163: istore 6
    //   165: aload_3
    //   166: ifnonnull +657 -> 823
    //   169: iconst_m1
    //   170: istore 7
    //   172: ldc 96
    //   174: ldc 246
    //   176: iconst_4
    //   177: anewarray 100	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: iload_1
    //   183: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: iload 6
    //   191: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: iload 7
    //   199: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: aastore
    //   203: dup
    //   204: iconst_3
    //   205: aload 12
    //   207: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   210: aastore
    //   211: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload 13
    //   216: aload_2
    //   217: aload_3
    //   218: aload 12
    //   220: aload 14
    //   222: aload 16
    //   224: aload 11
    //   226: aload 17
    //   228: invokestatic 94	com/tencent/mm/protocal/MMProtocalJni:unpack	(Lcom/tencent/mm/pointers/PByteArray;[B[BLcom/tencent/mm/pointers/PByteArray;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   231: istore 10
    //   233: aload 16
    //   235: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   238: istore 7
    //   240: aload 11
    //   242: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   245: istore 8
    //   247: aload 17
    //   249: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   252: istore 9
    //   254: aload 13
    //   256: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   259: astore 18
    //   261: aload 13
    //   263: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   266: ifnonnull +564 -> 830
    //   269: iconst_m1
    //   270: istore 6
    //   272: ldc 96
    //   274: ldc 248
    //   276: bipush 7
    //   278: anewarray 100	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: iload 10
    //   285: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: iload_1
    //   292: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: aastore
    //   296: dup
    //   297: iconst_2
    //   298: iload 7
    //   300: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: iconst_3
    //   306: iload 8
    //   308: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   311: aastore
    //   312: dup
    //   313: iconst_4
    //   314: iload 9
    //   316: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: aastore
    //   320: dup
    //   321: iconst_5
    //   322: aload 18
    //   324: aastore
    //   325: dup
    //   326: bipush 6
    //   328: iload 6
    //   330: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: iload 10
    //   339: ifeq +1243 -> 1582
    //   342: aload_0
    //   343: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   346: aload 17
    //   348: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   351: invokevirtual 251	com/tencent/mm/protocal/l$e:setHeadExtFlags	(I)V
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
    //   385: getstatic 254	com/tencent/mm/platformtools/ac:iRH	I
    //   388: if_icmpne +45 -> 433
    //   391: getstatic 257	com/tencent/mm/platformtools/ac:iRI	I
    //   394: ifle +39 -> 433
    //   397: getstatic 257	com/tencent/mm/platformtools/ac:iRI	I
    //   400: iconst_2
    //   401: if_icmpne +13 -> 414
    //   404: ldc_w 259
    //   407: ldc_w 259
    //   410: iconst_0
    //   411: invokestatic 265	com/tencent/mm/protocal/ac:am	(Ljava/lang/String;Ljava/lang/String;I)V
    //   414: iconst_0
    //   415: putstatic 257	com/tencent/mm/platformtools/ac:iRI	I
    //   418: aload 14
    //   420: bipush 243
    //   422: putfield 87	com/tencent/mm/pointers/PInt:value	I
    //   425: ldc 96
    //   427: ldc_w 267
    //   430: invokestatic 270	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: aload 14
    //   435: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   438: sipush -306
    //   441: if_icmpne +400 -> 841
    //   444: ldc 96
    //   446: ldc_w 272
    //   449: iconst_1
    //   450: anewarray 100	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: getstatic 277	com/tencent/mm/protocal/f:FFQ	Z
    //   458: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   461: aastore
    //   462: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: iconst_0
    //   466: putstatic 277	com/tencent/mm/protocal/f:FFQ	Z
    //   469: aload 14
    //   471: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   474: bipush 243
    //   476: if_icmpeq +68 -> 544
    //   479: aload 14
    //   481: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   484: bipush 154
    //   486: if_icmpeq +58 -> 544
    //   489: aload 14
    //   491: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   494: sipush -3001
    //   497: if_icmpeq +47 -> 544
    //   500: aload 14
    //   502: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   505: sipush -3002
    //   508: if_icmpeq +36 -> 544
    //   511: aload 14
    //   513: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   516: sipush -3003
    //   519: if_icmpeq +25 -> 544
    //   522: aload 14
    //   524: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   527: sipush -306
    //   530: if_icmpeq +14 -> 544
    //   533: aload 14
    //   535: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   538: sipush -3006
    //   541: if_icmpne +854 -> 1395
    //   544: aload_0
    //   545: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   548: aload 14
    //   550: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   553: invokevirtual 231	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   556: aload 14
    //   558: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   561: istore 6
    //   563: iload 6
    //   565: sipush -3002
    //   568: if_icmpne +67 -> 635
    //   571: aload_0
    //   572: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   575: new 147	java/lang/String
    //   578: dup
    //   579: aload 13
    //   581: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   584: invokespecial 152	java/lang/String:<init>	([B)V
    //   587: invokevirtual 244	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   590: ldc 96
    //   592: ldc_w 279
    //   595: iconst_4
    //   596: anewarray 100	java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: iload_1
    //   602: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   605: aastore
    //   606: dup
    //   607: iconst_1
    //   608: aload 14
    //   610: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   613: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   616: aastore
    //   617: dup
    //   618: iconst_2
    //   619: aload 11
    //   621: aastore
    //   622: dup
    //   623: iconst_3
    //   624: aload_0
    //   625: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   628: invokevirtual 282	com/tencent/mm/protocal/l$e:getErrMsg	()Ljava/lang/String;
    //   631: aastore
    //   632: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload_0
    //   636: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   639: aload_2
    //   640: arraylength
    //   641: i2l
    //   642: invokevirtual 286	com/tencent/mm/protocal/l$e:setBufferSize	(J)V
    //   645: aload_0
    //   646: aload 12
    //   648: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   651: putfield 288	com/tencent/mm/ak/w:dMA	[B
    //   654: getstatic 237	com/tencent/mm/platformtools/ac:iRK	Ljava/lang/String;
    //   657: invokestatic 241	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   660: ifne +13 -> 673
    //   663: aload_0
    //   664: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   667: getstatic 237	com/tencent/mm/platformtools/ac:iRK	Ljava/lang/String;
    //   670: invokevirtual 244	com/tencent/mm/protocal/l$e:setErrMsg	(Ljava/lang/String;)V
    //   673: aload 11
    //   675: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   678: ifeq +131 -> 809
    //   681: new 118	com/tencent/mm/g/a/ix
    //   684: dup
    //   685: invokespecial 119	com/tencent/mm/g/a/ix:<init>	()V
    //   688: astore_2
    //   689: aload_2
    //   690: getfield 123	com/tencent/mm/g/a/ix:dwG	Lcom/tencent/mm/g/a/ix$a;
    //   693: aload 11
    //   695: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   698: putfield 128	com/tencent/mm/g/a/ix$a:dwH	I
    //   701: iload_1
    //   702: sipush 252
    //   705: if_icmpeq +10 -> 715
    //   708: iload_1
    //   709: sipush 701
    //   712: if_icmpne +51 -> 763
    //   715: aload_0
    //   716: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   719: invokevirtual 292	com/tencent/mm/protocal/l$e:getRetCode	()I
    //   722: ifne +41 -> 763
    //   725: ldc 96
    //   727: ldc_w 294
    //   730: iconst_2
    //   731: anewarray 100	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: aload 11
    //   738: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   741: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: iload_1
    //   748: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   751: aastore
    //   752: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   755: aload_2
    //   756: getfield 123	com/tencent/mm/g/a/ix:dwG	Lcom/tencent/mm/g/a/ix$a;
    //   759: iconst_1
    //   760: putfield 297	com/tencent/mm/g/a/ix$a:dwI	Z
    //   763: getstatic 134	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   766: aload_2
    //   767: invokevirtual 138	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   770: istore 10
    //   772: ldc 96
    //   774: ldc_w 299
    //   777: iconst_2
    //   778: anewarray 100	java/lang/Object
    //   781: dup
    //   782: iconst_0
    //   783: aload 11
    //   785: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   788: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   791: aastore
    //   792: dup
    //   793: iconst_1
    //   794: iload 10
    //   796: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   799: aastore
    //   800: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   803: aload 11
    //   805: iconst_0
    //   806: putfield 87	com/tencent/mm/pointers/PInt:value	I
    //   809: ldc 206
    //   811: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   814: iconst_1
    //   815: ireturn
    //   816: aload_2
    //   817: arraylength
    //   818: istore 6
    //   820: goto -655 -> 165
    //   823: aload_3
    //   824: arraylength
    //   825: istore 7
    //   827: goto -655 -> 172
    //   830: aload 13
    //   832: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   835: arraylength
    //   836: istore 6
    //   838: goto -566 -> 272
    //   841: aload 16
    //   843: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   846: bipush 13
    //   848: if_icmpne +192 -> 1040
    //   851: aload 13
    //   853: aload_3
    //   854: aload 13
    //   856: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   859: invokestatic 305	com/tencent/mm/jni/utils/UtilsJni:AesGcmDecryptWithUncompress	([B[B)[B
    //   862: putfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   865: aload 13
    //   867: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   870: astore_3
    //   871: aload 13
    //   873: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   876: ifnonnull +153 -> 1029
    //   879: iconst_m1
    //   880: istore 6
    //   882: ldc 96
    //   884: ldc_w 307
    //   887: iconst_3
    //   888: anewarray 100	java/lang/Object
    //   891: dup
    //   892: iconst_0
    //   893: iload_1
    //   894: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   897: aastore
    //   898: dup
    //   899: iconst_1
    //   900: aload_3
    //   901: aastore
    //   902: dup
    //   903: iconst_2
    //   904: iload 6
    //   906: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   909: aastore
    //   910: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: goto -444 -> 469
    //   916: astore_2
    //   917: ldc 96
    //   919: aload_2
    //   920: ldc_w 309
    //   923: iconst_0
    //   924: anewarray 100	java/lang/Object
    //   927: invokestatic 193	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   930: ldc 96
    //   932: ldc 195
    //   934: iconst_1
    //   935: anewarray 100	java/lang/Object
    //   938: dup
    //   939: iconst_0
    //   940: aload_2
    //   941: invokestatic 200	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   944: aastore
    //   945: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   948: aload 11
    //   950: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   953: ifeq +69 -> 1022
    //   956: new 118	com/tencent/mm/g/a/ix
    //   959: dup
    //   960: invokespecial 119	com/tencent/mm/g/a/ix:<init>	()V
    //   963: astore_2
    //   964: aload_2
    //   965: getfield 123	com/tencent/mm/g/a/ix:dwG	Lcom/tencent/mm/g/a/ix$a;
    //   968: aload 11
    //   970: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   973: putfield 128	com/tencent/mm/g/a/ix$a:dwH	I
    //   976: getstatic 134	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   979: aload_2
    //   980: invokevirtual 138	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   983: istore 10
    //   985: ldc 96
    //   987: ldc_w 299
    //   990: iconst_2
    //   991: anewarray 100	java/lang/Object
    //   994: dup
    //   995: iconst_0
    //   996: aload 11
    //   998: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   1001: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1004: aastore
    //   1005: dup
    //   1006: iconst_1
    //   1007: iload 10
    //   1009: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1012: aastore
    //   1013: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1016: aload 11
    //   1018: iconst_0
    //   1019: putfield 87	com/tencent/mm/pointers/PInt:value	I
    //   1022: ldc 206
    //   1024: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1027: iconst_0
    //   1028: ireturn
    //   1029: aload 13
    //   1031: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1034: arraylength
    //   1035: istore 6
    //   1037: goto -155 -> 882
    //   1040: aload 16
    //   1042: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   1045: bipush 12
    //   1047: if_icmpne +165 -> 1212
    //   1050: aload 13
    //   1052: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1055: ifnonnull +135 -> 1190
    //   1058: iconst_m1
    //   1059: istore 6
    //   1061: lload 4
    //   1063: lconst_0
    //   1064: lcmp
    //   1065: ifne +22 -> 1087
    //   1068: ldc 96
    //   1070: ldc_w 311
    //   1073: iconst_1
    //   1074: anewarray 100	java/lang/Object
    //   1077: dup
    //   1078: iconst_0
    //   1079: iload_1
    //   1080: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1083: aastore
    //   1084: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1087: aload 13
    //   1089: lload 4
    //   1091: aload 13
    //   1093: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1096: invokestatic 315	com/tencent/mm/jni/utils/UtilsJni:HybridEcdhDecrypt	(J[B)[B
    //   1099: putfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1102: lload 4
    //   1104: invokestatic 318	com/tencent/mm/protocal/f:Dd	(J)V
    //   1107: aload 14
    //   1109: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   1112: istore 8
    //   1114: aload 13
    //   1116: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1119: astore_3
    //   1120: aload 13
    //   1122: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1125: ifnonnull +76 -> 1201
    //   1128: iconst_m1
    //   1129: istore 7
    //   1131: ldc 96
    //   1133: ldc_w 320
    //   1136: bipush 6
    //   1138: anewarray 100	java/lang/Object
    //   1141: dup
    //   1142: iconst_0
    //   1143: iload_1
    //   1144: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1147: aastore
    //   1148: dup
    //   1149: iconst_1
    //   1150: iload 8
    //   1152: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1155: aastore
    //   1156: dup
    //   1157: iconst_2
    //   1158: lload 4
    //   1160: invokestatic 325	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1163: aastore
    //   1164: dup
    //   1165: iconst_3
    //   1166: aload_3
    //   1167: aastore
    //   1168: dup
    //   1169: iconst_4
    //   1170: iload 6
    //   1172: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1175: aastore
    //   1176: dup
    //   1177: iconst_5
    //   1178: iload 7
    //   1180: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1183: aastore
    //   1184: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1187: goto -718 -> 469
    //   1190: aload 13
    //   1192: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1195: arraylength
    //   1196: istore 6
    //   1198: goto -137 -> 1061
    //   1201: aload 13
    //   1203: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1206: arraylength
    //   1207: istore 7
    //   1209: goto -78 -> 1131
    //   1212: aload 16
    //   1214: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   1217: bipush 11
    //   1219: if_icmpne -750 -> 469
    //   1222: aload 13
    //   1224: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1227: ifnonnull +135 -> 1362
    //   1230: iconst_m1
    //   1231: istore 6
    //   1233: lload 4
    //   1235: lconst_0
    //   1236: lcmp
    //   1237: ifne +22 -> 1259
    //   1240: ldc 96
    //   1242: ldc_w 327
    //   1245: iconst_1
    //   1246: anewarray 100	java/lang/Object
    //   1249: dup
    //   1250: iconst_0
    //   1251: iload_1
    //   1252: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1255: aastore
    //   1256: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1259: aload 13
    //   1261: lload 4
    //   1263: aload 13
    //   1265: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1268: invokestatic 330	com/tencent/mm/jni/utils/UtilsJni:AxEcdhDecrypt	(J[B)[B
    //   1271: putfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1274: lload 4
    //   1276: invokestatic 333	com/tencent/mm/jni/utils/UtilsJni:ReleaseAxEcdhCryptoEngine	(J)V
    //   1279: aload 14
    //   1281: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   1284: istore 8
    //   1286: aload 13
    //   1288: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1291: astore_3
    //   1292: aload 13
    //   1294: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1297: ifnonnull +76 -> 1373
    //   1300: iconst_m1
    //   1301: istore 7
    //   1303: ldc 96
    //   1305: ldc_w 335
    //   1308: bipush 6
    //   1310: anewarray 100	java/lang/Object
    //   1313: dup
    //   1314: iconst_0
    //   1315: iload_1
    //   1316: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1319: aastore
    //   1320: dup
    //   1321: iconst_1
    //   1322: iload 8
    //   1324: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1327: aastore
    //   1328: dup
    //   1329: iconst_2
    //   1330: lload 4
    //   1332: invokestatic 325	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1335: aastore
    //   1336: dup
    //   1337: iconst_3
    //   1338: aload_3
    //   1339: aastore
    //   1340: dup
    //   1341: iconst_4
    //   1342: iload 6
    //   1344: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1347: aastore
    //   1348: dup
    //   1349: iconst_5
    //   1350: iload 7
    //   1352: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1355: aastore
    //   1356: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1359: goto -890 -> 469
    //   1362: aload 13
    //   1364: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1367: arraylength
    //   1368: istore 6
    //   1370: goto -137 -> 1233
    //   1373: aload 13
    //   1375: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1378: arraylength
    //   1379: istore 7
    //   1381: goto -78 -> 1303
    //   1384: astore_3
    //   1385: ldc 96
    //   1387: ldc 174
    //   1389: invokestatic 177	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1392: goto -802 -> 590
    //   1395: aload 15
    //   1397: aload 13
    //   1399: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1402: invokeinterface 221 2 0
    //   1407: istore 6
    //   1409: ldc 96
    //   1411: ldc_w 337
    //   1414: iconst_5
    //   1415: anewarray 100	java/lang/Object
    //   1418: dup
    //   1419: iconst_0
    //   1420: iload_1
    //   1421: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1424: aastore
    //   1425: dup
    //   1426: iconst_1
    //   1427: aload 16
    //   1429: getfield 87	com/tencent/mm/pointers/PInt:value	I
    //   1432: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1435: aastore
    //   1436: dup
    //   1437: iconst_2
    //   1438: iload 6
    //   1440: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1443: aastore
    //   1444: dup
    //   1445: iconst_3
    //   1446: aload 13
    //   1448: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1451: arraylength
    //   1452: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1455: aastore
    //   1456: dup
    //   1457: iconst_4
    //   1458: aload_0
    //   1459: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   1462: invokevirtual 340	com/tencent/mm/protocal/l$e:getHeadExtFlags	()I
    //   1465: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1468: aastore
    //   1469: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1472: aload_0
    //   1473: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   1476: iload 6
    //   1478: invokevirtual 231	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   1481: iload 6
    //   1483: sipush -305
    //   1486: if_icmpne -851 -> 635
    //   1489: ldc 96
    //   1491: ldc_w 342
    //   1494: iconst_2
    //   1495: anewarray 100	java/lang/Object
    //   1498: dup
    //   1499: iconst_0
    //   1500: getstatic 345	com/tencent/mm/protocal/f:FFV	I
    //   1503: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1506: aastore
    //   1507: dup
    //   1508: iconst_1
    //   1509: iload_1
    //   1510: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1513: aastore
    //   1514: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1517: invokestatic 348	com/tencent/mm/protocal/f:fjY	()Z
    //   1520: pop
    //   1521: goto -886 -> 635
    //   1524: astore_2
    //   1525: ldc 96
    //   1527: new 62	java/lang/StringBuilder
    //   1530: dup
    //   1531: ldc_w 350
    //   1534: invokespecial 351	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1537: aload_2
    //   1538: invokevirtual 354	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1541: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: ldc_w 359
    //   1547: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: aload 13
    //   1552: getfield 149	com/tencent/mm/pointers/PByteArray:value	[B
    //   1555: invokestatic 361	com/tencent/mm/ak/w:Z	([B)Ljava/lang/String;
    //   1558: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: invokestatic 177	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1567: aload_0
    //   1568: getfield 46	com/tencent/mm/ak/w:hSb	Lcom/tencent/mm/protocal/l$e;
    //   1571: iconst_m1
    //   1572: invokevirtual 231	com/tencent/mm/protocal/l$e:setRetCode	(I)V
    //   1575: ldc 206
    //   1577: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1580: iconst_1
    //   1581: ireturn
    //   1582: ldc 96
    //   1584: ldc_w 363
    //   1587: iconst_1
    //   1588: anewarray 100	java/lang/Object
    //   1591: dup
    //   1592: iconst_0
    //   1593: iload_1
    //   1594: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1597: aastore
    //   1598: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1601: goto -653 -> 948
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1604	0	this	w
    //   0	1604	1	paramInt	int
    //   0	1604	2	paramArrayOfByte1	byte[]
    //   0	1604	3	paramArrayOfByte2	byte[]
    //   0	1604	4	paramLong	long
    //   163	1324	6	i	int
    //   170	1210	7	j	int
    //   245	1078	8	k	int
    //   252	63	9	m	int
    //   231	777	10	bool	boolean
    //   84	933	11	localPInt1	PInt
    //   12	635	12	localPByteArray1	PByteArray
    //   45	1506	13	localPByteArray2	PByteArray
    //   55	1225	14	localPInt2	PInt
    //   64	1332	15	localc	com.tencent.mm.protocal.l.c
    //   74	1354	16	localPInt3	PInt
    //   96	251	17	localPInt4	PInt
    //   259	64	18	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   98	151	916	java/lang/Exception
    //   172	269	916	java/lang/Exception
    //   272	337	916	java/lang/Exception
    //   342	354	916	java/lang/Exception
    //   382	414	916	java/lang/Exception
    //   414	433	916	java/lang/Exception
    //   433	469	916	java/lang/Exception
    //   469	544	916	java/lang/Exception
    //   544	563	916	java/lang/Exception
    //   590	635	916	java/lang/Exception
    //   635	673	916	java/lang/Exception
    //   673	701	916	java/lang/Exception
    //   715	763	916	java/lang/Exception
    //   763	809	916	java/lang/Exception
    //   816	820	916	java/lang/Exception
    //   823	827	916	java/lang/Exception
    //   830	838	916	java/lang/Exception
    //   841	879	916	java/lang/Exception
    //   882	913	916	java/lang/Exception
    //   1029	1037	916	java/lang/Exception
    //   1040	1058	916	java/lang/Exception
    //   1068	1087	916	java/lang/Exception
    //   1087	1128	916	java/lang/Exception
    //   1131	1187	916	java/lang/Exception
    //   1190	1198	916	java/lang/Exception
    //   1201	1209	916	java/lang/Exception
    //   1212	1230	916	java/lang/Exception
    //   1240	1259	916	java/lang/Exception
    //   1259	1300	916	java/lang/Exception
    //   1303	1359	916	java/lang/Exception
    //   1362	1370	916	java/lang/Exception
    //   1373	1381	916	java/lang/Exception
    //   1385	1392	916	java/lang/Exception
    //   1395	1481	916	java/lang/Exception
    //   1489	1521	916	java/lang/Exception
    //   1525	1575	916	java/lang/Exception
    //   1582	1601	916	java/lang/Exception
    //   571	590	1384	java/lang/Exception
    //   1395	1481	1524	java/lang/OutOfMemoryError
    //   1489	1521	1524	java/lang/OutOfMemoryError
  }
  
  public final byte[] aFB()
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
        ae.i("MicroMsg.RemoteResp", "summerauths getAutoAuthKey type[%s] key[%s]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(localObject.length) });
        AppMethodBeat.o(132473);
        return localObject;
        if (((j.i)this.hSb).FGl.HYs.FRs == null) {
          break;
        }
        localObject = ((j.i)this.hSb).FGl.HYs.FRs.getBuffer().toByteArray();
        continue;
        localObject = ((x.b)this.hSb).FGY.Hqm;
        if ((localObject == null) || (((czw)localObject).FRs == null)) {
          break label194;
        }
        localObject = ((czw)localObject).FRs.getBuffer().toByteArray();
      }
      label194:
      ae.d("MicroMsg.RemoteResp", "summerauth reg[%s] SecAuthRegKeySect is null", new Object[] { Integer.valueOf(this.type) });
    }
  }
  
  public final String aFC()
  {
    AppMethodBeat.i(132474);
    if (this.type == 381)
    {
      Object localObject = ((t.b)this.hSb).FGS.GPD;
      if (localObject != null)
      {
        localObject = bu.nullAsNil(((cqw)localObject).HCn);
        AppMethodBeat.o(132474);
        return localObject;
      }
    }
    AppMethodBeat.o(132474);
    return "";
  }
  
  public final String aFD()
  {
    AppMethodBeat.i(132475);
    if (this.type == 381)
    {
      Object localObject = ((t.b)this.hSb).FGS.GPD;
      if (localObject != null)
      {
        localObject = bu.nullAsNil(((cqw)localObject).HCm);
        AppMethodBeat.o(132475);
        return localObject;
      }
    }
    AppMethodBeat.o(132475);
    return "";
  }
  
  public final int aFE()
  {
    if (this.type == 381) {
      return ((t.b)this.hSb).FGS.GOF;
    }
    return 0;
  }
  
  public final byte[] aFl()
  {
    return this.dMA;
  }
  
  public final byte[] aFn()
  {
    switch (this.type)
    {
    default: 
      return new byte[0];
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      return ((j.i)this.hSb).FGp;
    }
    return ((x.b)this.hSb).FGp;
  }
  
  public final String aFo()
  {
    switch (this.type)
    {
    default: 
      return "";
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      return ((j.i)this.hSb).dvq;
    }
    return ((x.b)this.hSb).FGY.nIJ;
  }
  
  public final byte[] getAuthResponse()
  {
    AppMethodBeat.i(132477);
    byte[] arrayOfByte = this.hSb.getAuthResponse();
    AppMethodBeat.o(132477);
    return arrayOfByte;
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(132476);
    int i = this.hSb.getCmdId();
    AppMethodBeat.o(132476);
    return i;
  }
  
  public final String getErrMsg()
  {
    AppMethodBeat.i(132468);
    String str = this.hSb.getErrMsg();
    AppMethodBeat.o(132468);
    return str;
  }
  
  public final int getHeadExtFlags()
  {
    AppMethodBeat.i(132467);
    int i = this.hSb.getHeadExtFlags();
    AppMethodBeat.o(132467);
    return i;
  }
  
  public final int getRetCode()
  {
    AppMethodBeat.i(132470);
    int i = this.hSb.getRetCode();
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
      return ((j.i)this.hSb).FGl.HYs.qkC;
    }
    return ((x.b)this.hSb).FGY.qkC;
  }
  
  public final byte[] mR(int paramInt)
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
      ae.i("MicroMsg.RemoteResp", "summerauths getSessionKey seesionKeyType[%s] [%s] [%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), bu.fpN() });
      AppMethodBeat.o(132472);
      return arrayOfByte;
      arrayOfByte = ((j.i)this.hSb).aak(paramInt);
      break;
      arrayOfByte = ((x.b)this.hSb).aak(paramInt);
      break;
    }
  }
  
  public final void setErrMsg(String paramString)
  {
    AppMethodBeat.i(132469);
    this.hSb.setErrMsg(paramString);
    AppMethodBeat.o(132469);
  }
  
  public final void setRetCode(int paramInt)
  {
    AppMethodBeat.i(132471);
    this.hSb.setRetCode(paramInt);
    AppMethodBeat.o(132471);
  }
  
  public static abstract interface a
  {
    public abstract void fG(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.w
 * JD-Core Version:    0.7.0.1
 */