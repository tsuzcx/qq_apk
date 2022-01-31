package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

public final class e
{
  String mqA;
  float mqB;
  int mqG;
  int mqH;
  e.a mqL;
  int orientation;
  
  public e(String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(705);
    this.mqA = paramString;
    this.mqB = paramFloat;
    this.orientation = paramInt1;
    this.mqG = paramInt2;
    this.mqH = paramInt3;
    ab.i("MicroMsg.FaceCheckVideoRecordMgr", "create FaceCheckVideoRecordMgr, reductionRatio: %s, orientation: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(705);
  }
  
  /* Error */
  static void S(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: sipush 706
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 70	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: new 70	java/io/File
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_1
    //   25: invokevirtual 77	java/io/File:exists	()Z
    //   28: ifeq +284 -> 312
    //   31: aload_1
    //   32: invokevirtual 80	java/io/File:isFile	()Z
    //   35: ifeq +277 -> 312
    //   38: aload_2
    //   39: invokevirtual 84	java/io/File:getParentFile	()Ljava/io/File;
    //   42: invokevirtual 77	java/io/File:exists	()Z
    //   45: ifne +11 -> 56
    //   48: aload_2
    //   49: invokevirtual 84	java/io/File:getParentFile	()Ljava/io/File;
    //   52: invokevirtual 87	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: aload_2
    //   57: invokevirtual 90	java/io/File:createNewFile	()Z
    //   60: pop
    //   61: new 92	java/io/FileInputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore 4
    //   71: new 97	java/io/FileOutputStream
    //   74: dup
    //   75: aload_2
    //   76: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: astore_2
    //   80: new 100	javax/crypto/spec/SecretKeySpec
    //   83: dup
    //   84: new 100	javax/crypto/spec/SecretKeySpec
    //   87: dup
    //   88: aload_0
    //   89: ldc 102
    //   91: invokevirtual 108	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   94: ldc 110
    //   96: invokespecial 113	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   99: invokeinterface 119 1 0
    //   104: ldc 110
    //   106: invokespecial 113	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   109: astore_1
    //   110: ldc 121
    //   112: invokestatic 127	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   115: astore 5
    //   117: aload 5
    //   119: iconst_1
    //   120: aload_1
    //   121: new 129	javax/crypto/spec/IvParameterSpec
    //   124: dup
    //   125: aload_0
    //   126: invokevirtual 131	java/lang/String:getBytes	()[B
    //   129: invokespecial 134	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   132: invokevirtual 138	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   135: new 140	javax/crypto/CipherInputStream
    //   138: dup
    //   139: aload 4
    //   141: aload 5
    //   143: invokespecial 143	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   146: astore_0
    //   147: aload_2
    //   148: astore 5
    //   150: aload 4
    //   152: astore 6
    //   154: aload_0
    //   155: astore 7
    //   157: sipush 1024
    //   160: newarray byte
    //   162: astore_1
    //   163: aload_2
    //   164: astore 5
    //   166: aload 4
    //   168: astore 6
    //   170: aload_0
    //   171: astore 7
    //   173: aload_0
    //   174: aload_1
    //   175: invokevirtual 147	javax/crypto/CipherInputStream:read	([B)I
    //   178: istore_3
    //   179: iload_3
    //   180: iconst_m1
    //   181: if_icmpeq +111 -> 292
    //   184: aload_2
    //   185: astore 5
    //   187: aload 4
    //   189: astore 6
    //   191: aload_0
    //   192: astore 7
    //   194: aload_2
    //   195: aload_1
    //   196: iconst_0
    //   197: iload_3
    //   198: invokevirtual 153	java/io/OutputStream:write	([BII)V
    //   201: aload_2
    //   202: astore 5
    //   204: aload 4
    //   206: astore 6
    //   208: aload_0
    //   209: astore 7
    //   211: aload_2
    //   212: invokevirtual 156	java/io/OutputStream:flush	()V
    //   215: goto -52 -> 163
    //   218: astore_1
    //   219: aload_2
    //   220: astore 5
    //   222: aload 4
    //   224: astore 6
    //   226: aload_0
    //   227: astore 7
    //   229: sipush 706
    //   232: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_2
    //   236: astore 5
    //   238: aload 4
    //   240: astore 6
    //   242: aload_0
    //   243: astore 7
    //   245: aload_1
    //   246: athrow
    //   247: astore_0
    //   248: aload 7
    //   250: astore_2
    //   251: aload 6
    //   253: astore 4
    //   255: aload 5
    //   257: astore_1
    //   258: aload_1
    //   259: ifnull +7 -> 266
    //   262: aload_1
    //   263: invokevirtual 159	java/io/OutputStream:close	()V
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 160	javax/crypto/CipherInputStream:close	()V
    //   274: aload 4
    //   276: ifnull +8 -> 284
    //   279: aload 4
    //   281: invokevirtual 163	java/io/InputStream:close	()V
    //   284: sipush 706
    //   287: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload_0
    //   291: athrow
    //   292: aload_2
    //   293: invokevirtual 159	java/io/OutputStream:close	()V
    //   296: aload_0
    //   297: invokevirtual 160	javax/crypto/CipherInputStream:close	()V
    //   300: aload 4
    //   302: invokevirtual 163	java/io/InputStream:close	()V
    //   305: sipush 706
    //   308: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: return
    //   312: sipush 706
    //   315: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: return
    //   319: astore_0
    //   320: aconst_null
    //   321: astore_1
    //   322: aconst_null
    //   323: astore 4
    //   325: aconst_null
    //   326: astore_2
    //   327: goto -69 -> 258
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_1
    //   333: aconst_null
    //   334: astore_2
    //   335: goto -77 -> 258
    //   338: astore_0
    //   339: aconst_null
    //   340: astore 5
    //   342: aload_2
    //   343: astore_1
    //   344: aload 5
    //   346: astore_2
    //   347: goto -89 -> 258
    //   350: astore_1
    //   351: aconst_null
    //   352: astore_2
    //   353: aconst_null
    //   354: astore 4
    //   356: aconst_null
    //   357: astore_0
    //   358: goto -139 -> 219
    //   361: astore_1
    //   362: aconst_null
    //   363: astore_2
    //   364: aconst_null
    //   365: astore_0
    //   366: goto -147 -> 219
    //   369: astore_1
    //   370: aconst_null
    //   371: astore_0
    //   372: goto -153 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramString1	String
    //   0	375	1	paramString2	String
    //   0	375	2	paramString3	String
    //   178	20	3	i	int
    //   69	286	4	localObject1	Object
    //   115	230	5	localObject2	Object
    //   152	100	6	localObject3	Object
    //   155	94	7	str	String
    // Exception table:
    //   from	to	target	type
    //   157	163	218	java/lang/Exception
    //   173	179	218	java/lang/Exception
    //   194	201	218	java/lang/Exception
    //   211	215	218	java/lang/Exception
    //   157	163	247	finally
    //   173	179	247	finally
    //   194	201	247	finally
    //   211	215	247	finally
    //   229	235	247	finally
    //   245	247	247	finally
    //   61	71	319	finally
    //   71	80	330	finally
    //   80	147	338	finally
    //   61	71	350	java/lang/Exception
    //   71	80	361	java/lang/Exception
    //   80	147	369	java/lang/Exception
  }
  
  final class b
    implements g.a
  {
    private String fileName;
    private String mqA;
    
    private b(String paramString1, String paramString2)
    {
      this.mqA = paramString2;
      this.fileName = paramString1;
    }
    
    public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(704);
      ab.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ab.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
        paramString = e.this;
        paramc = this.fileName;
        String str = paramd.field_fileId;
        paramd = paramd.field_aesKey;
        if (paramString.mqL != null) {
          paramString.mqL.R(paramc, str, paramd);
        }
      }
      do
      {
        AppMethodBeat.o(704);
        return 0;
        if (paramd != null)
        {
          ab.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
          com.tencent.mm.a.e.deleteFile(this.fileName);
          h.qsU.idkeyStat(917L, 51L, 1L, false);
          if (e.this.mqL != null) {
            e.this.mqL.onError();
          }
          AppMethodBeat.o(704);
          return 0;
        }
      } while (paramInt == 0);
      ab.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      h.qsU.idkeyStat(917L, 51L, 1L, false);
      com.tencent.mm.a.e.deleteFile(this.fileName);
      if (e.this.mqL != null) {
        e.this.mqL.onError();
      }
      AppMethodBeat.o(704);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] l(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e
 * JD-Core Version:    0.7.0.1
 */