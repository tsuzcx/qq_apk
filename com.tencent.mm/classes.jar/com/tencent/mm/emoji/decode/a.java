package com.tencent.mm.emoji.decode;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.y;

public class a
{
  public static a mfj;
  private boolean Uz = false;
  private String key;
  
  private static boolean a(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104439);
    String str1;
    if (ImgUtil.isWXGF(paramArrayOfByte))
    {
      String str2 = paramEmojiInfo.field_externMd5;
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        AppMethodBeat.o(104439);
        return true;
      }
    }
    else
    {
      str1 = paramEmojiInfo.field_md5;
    }
    paramArrayOfByte = MD5Util.getMD5String(paramArrayOfByte);
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(paramArrayOfByte)) && (Util.isEqual(str1, paramArrayOfByte))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        paramEmojiInfo.kMa();
        Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "checkFileMd5: %s", new Object[] { paramEmojiInfo.field_md5 });
      }
      AppMethodBeat.o(104439);
      return bool;
    }
  }
  
  public static a aUc()
  {
    AppMethodBeat.i(104434);
    if (mfj == null) {}
    try
    {
      mfj = new a();
      a locala = mfj;
      AppMethodBeat.o(104434);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(104434);
    }
  }
  
  /* Error */
  public final boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 86
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +17 -> 23
    //   9: ldc 70
    //   11: ldc 88
    //   13: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 86
    //   18: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_0
    //   24: invokevirtual 95	com/tencent/mm/emoji/decode/a:aUd	()Ljava/lang/String;
    //   27: invokestatic 61	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   30: ifeq +23 -> 53
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +22 -> 58
    //   39: ldc 70
    //   41: ldc 97
    //   43: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: ldc 86
    //   48: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: iconst_1
    //   54: istore_3
    //   55: goto -20 -> 35
    //   58: aload_1
    //   59: invokevirtual 102	com/tencent/mm/storage/emotion/EmojiInfo:kMn	()Ljava/lang/String;
    //   62: astore 11
    //   64: aload 11
    //   66: invokestatic 107	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   69: ifeq +357 -> 426
    //   72: iconst_0
    //   73: istore 6
    //   75: aload 11
    //   77: iconst_0
    //   78: bipush 10
    //   80: invokestatic 111	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
    //   83: astore 9
    //   85: iload 6
    //   87: istore 5
    //   89: aload 9
    //   91: ifnull +22 -> 113
    //   94: iload 6
    //   96: istore 5
    //   98: aload 9
    //   100: arraylength
    //   101: bipush 10
    //   103: if_icmplt +10 -> 113
    //   106: aload 9
    //   108: invokestatic 114	com/tencent/mm/sdk/platformtools/ImgUtil:isImageFile	([B)Z
    //   111: istore 5
    //   113: iload_2
    //   114: ifne +8 -> 122
    //   117: iload 5
    //   119: ifeq +293 -> 412
    //   122: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   125: lstore 7
    //   127: aload 11
    //   129: invokestatic 124	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   132: l2i
    //   133: istore 4
    //   135: iload 4
    //   137: sipush 1024
    //   140: if_icmple +220 -> 360
    //   143: sipush 1024
    //   146: istore_3
    //   147: aload 11
    //   149: iconst_0
    //   150: iload 4
    //   152: invokestatic 111	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
    //   155: astore 12
    //   157: aload 11
    //   159: iconst_0
    //   160: iload_3
    //   161: invokestatic 111	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
    //   164: astore 10
    //   166: iconst_0
    //   167: newarray byte
    //   169: astore 9
    //   171: aload 10
    //   173: aload_0
    //   174: invokevirtual 95	com/tencent/mm/emoji/decode/a:aUd	()Ljava/lang/String;
    //   177: invokevirtual 130	java/lang/String:getBytes	()[B
    //   180: iconst_1
    //   181: iconst_0
    //   182: invokestatic 136	com/tencent/mm/jniinterface/AesEcb:aesCryptEcb	([B[BZZ)[B
    //   185: astore 10
    //   187: aload 10
    //   189: astore 9
    //   191: aload 9
    //   193: ifnull +272 -> 465
    //   196: aload 9
    //   198: arraylength
    //   199: iload_3
    //   200: if_icmplt +265 -> 465
    //   203: aload 12
    //   205: ifnull +260 -> 465
    //   208: aload 12
    //   210: arraylength
    //   211: iload_3
    //   212: if_icmplt +253 -> 465
    //   215: aload 9
    //   217: iconst_0
    //   218: aload 12
    //   220: iconst_0
    //   221: iload_3
    //   222: invokestatic 140	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   225: aload 11
    //   227: aload 12
    //   229: aload 12
    //   231: arraylength
    //   232: invokestatic 144	com/tencent/mm/vfs/y:f	(Ljava/lang/String;[BI)I
    //   235: istore_3
    //   236: iload_3
    //   237: ifne +147 -> 384
    //   240: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   243: lload 7
    //   245: lsub
    //   246: lstore 7
    //   248: getstatic 150	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   251: ldc2_w 151
    //   254: lconst_1
    //   255: lload 7
    //   257: iconst_0
    //   258: invokevirtual 156	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   261: getstatic 150	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   264: ldc2_w 151
    //   267: ldc2_w 157
    //   270: lconst_1
    //   271: iconst_0
    //   272: invokevirtual 156	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   275: aload_1
    //   276: aload_1
    //   277: getfield 162	com/tencent/mm/storage/emotion/EmojiInfo:field_reserved4	I
    //   280: getstatic 165	com/tencent/mm/storage/emotion/EmojiInfo:akmb	I
    //   283: ior
    //   284: putfield 162	com/tencent/mm/storage/emotion/EmojiInfo:field_reserved4	I
    //   287: aload_1
    //   288: iload 4
    //   290: putfield 168	com/tencent/mm/storage/emotion/EmojiInfo:field_size	I
    //   293: invokestatic 174	com/tencent/mm/storage/bl:jba	()Lcom/tencent/mm/storage/bl;
    //   296: getfield 178	com/tencent/mm/storage/bl:adju	Lcom/tencent/mm/storage/emotion/f;
    //   299: aload_1
    //   300: invokevirtual 184	com/tencent/mm/storage/emotion/f:N	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)Z
    //   303: pop
    //   304: ldc 70
    //   306: ldc 186
    //   308: iconst_2
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: aload 12
    //   316: arraylength
    //   317: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   320: aastore
    //   321: dup
    //   322: iconst_1
    //   323: lload 7
    //   325: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   328: aastore
    //   329: invokestatic 199	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: ldc 86
    //   334: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: iconst_1
    //   338: ireturn
    //   339: astore 9
    //   341: ldc 70
    //   343: aload 9
    //   345: ldc 201
    //   347: iconst_0
    //   348: anewarray 4	java/lang/Object
    //   351: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: iconst_0
    //   355: istore 5
    //   357: goto -244 -> 113
    //   360: iload 4
    //   362: istore_3
    //   363: goto -216 -> 147
    //   366: astore 10
    //   368: ldc 70
    //   370: aload 10
    //   372: ldc 201
    //   374: iconst_0
    //   375: anewarray 4	java/lang/Object
    //   378: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: goto -190 -> 191
    //   384: ldc 70
    //   386: ldc 207
    //   388: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: getstatic 150	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   394: ldc2_w 151
    //   397: ldc2_w 208
    //   400: lconst_1
    //   401: iconst_0
    //   402: invokevirtual 156	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   405: ldc 86
    //   407: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: iconst_0
    //   411: ireturn
    //   412: ldc 70
    //   414: ldc 211
    //   416: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: ldc 86
    //   421: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: iconst_1
    //   425: ireturn
    //   426: ldc 70
    //   428: ldc 213
    //   430: iconst_1
    //   431: anewarray 4	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload 11
    //   438: aastore
    //   439: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: aload_1
    //   443: iconst_0
    //   444: putfield 162	com/tencent/mm/storage/emotion/EmojiInfo:field_reserved4	I
    //   447: invokestatic 174	com/tencent/mm/storage/bl:jba	()Lcom/tencent/mm/storage/bl;
    //   450: getfield 178	com/tencent/mm/storage/bl:adju	Lcom/tencent/mm/storage/emotion/f;
    //   453: aload_1
    //   454: invokevirtual 184	com/tencent/mm/storage/emotion/f:N	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)Z
    //   457: pop
    //   458: ldc 86
    //   460: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   463: iconst_0
    //   464: ireturn
    //   465: iconst_m1
    //   466: istore_3
    //   467: goto -231 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	a
    //   0	470	1	paramEmojiInfo	EmojiInfo
    //   0	470	2	paramBoolean	boolean
    //   34	433	3	i	int
    //   133	228	4	j	int
    //   87	269	5	bool1	boolean
    //   73	22	6	bool2	boolean
    //   125	199	7	l	long
    //   83	133	9	localObject	Object
    //   339	5	9	localThrowable1	Throwable
    //   164	24	10	arrayOfByte1	byte[]
    //   366	5	10	localThrowable2	Throwable
    //   62	375	11	str	String
    //   155	160	12	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   98	113	339	finally
    //   171	187	366	finally
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104438);
    if (paramEmojiInfo == null)
    {
      Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
      AppMethodBeat.o(104438);
      return null;
    }
    String str = paramEmojiInfo.kMn();
    byte[] arrayOfByte1 = y.bi(str, 0, -1);
    if ((y.bEl(str) > 0L) && (arrayOfByte1 != null) && (arrayOfByte1.length >= 10))
    {
      Object localObject1 = new byte[10];
      System.arraycopy(arrayOfByte1, 0, localObject1, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.akmb) == EmojiInfo.akmb) || (!ImgUtil.isImageFile((byte[])localObject1)))
      {
        long l = System.currentTimeMillis();
        int j = (int)y.bEl(str);
        int i = j;
        if (j > 1024) {
          i = 1024;
        }
        byte[] arrayOfByte2 = y.bi(str, 0, i);
        Object localObject3 = null;
        localObject1 = localObject3;
        if (!Util.isNullOrNil(aUd())) {}
        try
        {
          localObject1 = AesEcb.aesCryptEcb(arrayOfByte2, aUd().getBytes(), false, false);
          if ((!Util.isNullOrNil((byte[])localObject1)) && (!Util.isNullOrNil(arrayOfByte1)))
          {
            System.arraycopy(localObject1, 0, arrayOfByte1, 0, i);
            l = System.currentTimeMillis() - l;
            h.OAn.idkeyStat(252L, 0L, l, false);
            h.OAn.idkeyStat(252L, 5L, 1L, false);
            Log.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte1.length), Long.valueOf(l) });
            if (!a(paramEmojiInfo, arrayOfByte1)) {
              break label382;
            }
            AppMethodBeat.o(104438);
            return arrayOfByte1;
          }
        }
        finally
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", localThrowable, "", new Object[0]);
            Object localObject2 = localObject3;
          }
          h.OAn.idkeyStat(252L, 2L, 1L, false);
          Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", new Object[] { str });
          if (!a(paramEmojiInfo, arrayOfByte1)) {
            break label382;
          }
        }
        AppMethodBeat.o(104438);
        return arrayOfByte1;
      }
      else if (a(paramEmojiInfo, arrayOfByte1))
      {
        AppMethodBeat.o(104438);
        return arrayOfByte1;
      }
    }
    else
    {
      Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
      AppMethodBeat.o(104438);
      return null;
    }
    label382:
    AppMethodBeat.o(104438);
    return null;
  }
  
  public final String aUd()
  {
    AppMethodBeat.i(104435);
    if (Util.isNullOrNil(this.key)) {
      this.key = l.aUF().mhR;
    }
    String str = this.key;
    AppMethodBeat.o(104435);
    return str;
  }
  
  /* Error */
  public final boolean b(EmojiInfo paramEmojiInfo)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: istore_2
    //   4: ldc 248
    //   6: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ifnonnull +17 -> 27
    //   13: ldc 70
    //   15: ldc 217
    //   17: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 248
    //   22: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   30: lstore 4
    //   32: aload_1
    //   33: invokevirtual 102	com/tencent/mm/storage/emotion/EmojiInfo:kMn	()Ljava/lang/String;
    //   36: astore 7
    //   38: aload 7
    //   40: invokestatic 124	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   43: l2i
    //   44: istore_3
    //   45: iload_3
    //   46: sipush 1024
    //   49: if_icmple +102 -> 151
    //   52: aload 7
    //   54: iconst_0
    //   55: iload_2
    //   56: invokestatic 111	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
    //   59: astore 8
    //   61: aload 7
    //   63: invokestatic 124	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   66: lconst_0
    //   67: lcmp
    //   68: ifle +172 -> 240
    //   71: aload 8
    //   73: ifnull +167 -> 240
    //   76: aload 8
    //   78: arraylength
    //   79: bipush 10
    //   81: if_icmplt +159 -> 240
    //   84: bipush 10
    //   86: newarray byte
    //   88: astore 7
    //   90: aload 8
    //   92: iconst_0
    //   93: aload 7
    //   95: iconst_0
    //   96: bipush 10
    //   98: invokestatic 140	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   101: aload 7
    //   103: invokestatic 114	com/tencent/mm/sdk/platformtools/ImgUtil:isImageFile	([B)Z
    //   106: ifeq +50 -> 156
    //   109: iconst_1
    //   110: istore 6
    //   112: ldc 70
    //   114: ldc 250
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   125: lload 4
    //   127: lsub
    //   128: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: iload 6
    //   136: invokestatic 255	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   139: aastore
    //   140: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: ldc 248
    //   145: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iload 6
    //   150: ireturn
    //   151: iload_3
    //   152: istore_2
    //   153: goto -101 -> 52
    //   156: aload_1
    //   157: getfield 162	com/tencent/mm/storage/emotion/EmojiInfo:field_reserved4	I
    //   160: getstatic 165	com/tencent/mm/storage/emotion/EmojiInfo:akmb	I
    //   163: iand
    //   164: getstatic 165	com/tencent/mm/storage/emotion/EmojiInfo:akmb	I
    //   167: if_icmpne +73 -> 240
    //   170: aconst_null
    //   171: astore 7
    //   173: aload 7
    //   175: astore_1
    //   176: aload_0
    //   177: invokevirtual 95	com/tencent/mm/emoji/decode/a:aUd	()Ljava/lang/String;
    //   180: invokestatic 61	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   183: ifne +18 -> 201
    //   186: aload 8
    //   188: aload_0
    //   189: invokevirtual 95	com/tencent/mm/emoji/decode/a:aUd	()Ljava/lang/String;
    //   192: invokevirtual 130	java/lang/String:getBytes	()[B
    //   195: iconst_0
    //   196: iconst_0
    //   197: invokestatic 136	com/tencent/mm/jniinterface/AesEcb:aesCryptEcb	([B[BZZ)[B
    //   200: astore_1
    //   201: aload_1
    //   202: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   205: ifne +35 -> 240
    //   208: aload_1
    //   209: invokestatic 114	com/tencent/mm/sdk/platformtools/ImgUtil:isImageFile	([B)Z
    //   212: ifeq +28 -> 240
    //   215: iconst_1
    //   216: istore 6
    //   218: goto -106 -> 112
    //   221: astore_1
    //   222: ldc 70
    //   224: aload_1
    //   225: ldc 201
    //   227: iconst_0
    //   228: anewarray 4	java/lang/Object
    //   231: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload 7
    //   236: astore_1
    //   237: goto -36 -> 201
    //   240: iconst_0
    //   241: istore 6
    //   243: goto -131 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	a
    //   0	246	1	paramEmojiInfo	EmojiInfo
    //   3	150	2	i	int
    //   44	108	3	j	int
    //   30	96	4	l	long
    //   110	132	6	bool	boolean
    //   36	199	7	localObject	Object
    //   59	128	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   186	201	221	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.a
 * JD-Core Version:    0.7.0.1
 */