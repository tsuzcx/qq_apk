package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;

public final class e
{
  int orientation;
  String qFJ;
  float qFK;
  int qFO;
  int qFP;
  a qFT;
  byte[] qFU;
  
  public e(String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104227);
    this.qFJ = paramString;
    this.qFK = paramFloat;
    this.orientation = paramInt1;
    this.qFO = paramInt2;
    this.qFP = paramInt3;
    ac.i("MicroMsg.FaceCheckVideoRecordMgr", "create FaceCheckVideoRecordMgr, reductionRatio: %s, orientation: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(104227);
  }
  
  /* Error */
  static void W(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 77
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 79	com/tencent/mm/vfs/e
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 82	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: new 79	com/tencent/mm/vfs/e
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 82	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 86	com/tencent/mm/vfs/e:exists	()Z
    //   27: ifeq +275 -> 302
    //   30: aload_1
    //   31: invokevirtual 89	com/tencent/mm/vfs/e:isFile	()Z
    //   34: ifeq +268 -> 302
    //   37: aload_2
    //   38: invokevirtual 93	com/tencent/mm/vfs/e:fxU	()Lcom/tencent/mm/vfs/e;
    //   41: invokevirtual 86	com/tencent/mm/vfs/e:exists	()Z
    //   44: ifne +11 -> 55
    //   47: aload_2
    //   48: invokevirtual 93	com/tencent/mm/vfs/e:fxU	()Lcom/tencent/mm/vfs/e;
    //   51: invokevirtual 96	com/tencent/mm/vfs/e:mkdirs	()Z
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 99	com/tencent/mm/vfs/e:createNewFile	()Z
    //   59: pop
    //   60: aload_1
    //   61: invokestatic 105	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   64: astore_1
    //   65: aload_2
    //   66: invokestatic 109	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   69: astore_2
    //   70: new 111	javax/crypto/spec/SecretKeySpec
    //   73: dup
    //   74: new 111	javax/crypto/spec/SecretKeySpec
    //   77: dup
    //   78: aload_0
    //   79: ldc 113
    //   81: invokevirtual 119	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   84: ldc 121
    //   86: invokespecial 124	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   89: invokeinterface 130 1 0
    //   94: ldc 121
    //   96: invokespecial 124	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   99: astore 4
    //   101: ldc 132
    //   103: invokestatic 138	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   106: astore 5
    //   108: aload 5
    //   110: iconst_1
    //   111: aload 4
    //   113: new 140	javax/crypto/spec/IvParameterSpec
    //   116: dup
    //   117: aload_0
    //   118: invokevirtual 142	java/lang/String:getBytes	()[B
    //   121: invokespecial 145	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   124: invokevirtual 149	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   127: new 151	javax/crypto/CipherInputStream
    //   130: dup
    //   131: aload_1
    //   132: aload 5
    //   134: invokespecial 154	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   137: astore_0
    //   138: aload_2
    //   139: astore 5
    //   141: aload_1
    //   142: astore 6
    //   144: aload_0
    //   145: astore 7
    //   147: sipush 1024
    //   150: newarray byte
    //   152: astore 4
    //   154: aload_2
    //   155: astore 5
    //   157: aload_1
    //   158: astore 6
    //   160: aload_0
    //   161: astore 7
    //   163: aload_0
    //   164: aload 4
    //   166: invokevirtual 158	javax/crypto/CipherInputStream:read	([B)I
    //   169: istore_3
    //   170: iload_3
    //   171: iconst_m1
    //   172: if_icmpeq +104 -> 276
    //   175: aload_2
    //   176: astore 5
    //   178: aload_1
    //   179: astore 6
    //   181: aload_0
    //   182: astore 7
    //   184: aload_2
    //   185: aload 4
    //   187: iconst_0
    //   188: iload_3
    //   189: invokevirtual 164	java/io/OutputStream:write	([BII)V
    //   192: aload_2
    //   193: astore 5
    //   195: aload_1
    //   196: astore 6
    //   198: aload_0
    //   199: astore 7
    //   201: aload_2
    //   202: invokevirtual 167	java/io/OutputStream:flush	()V
    //   205: goto -51 -> 154
    //   208: astore 4
    //   210: aload_2
    //   211: astore 5
    //   213: aload_1
    //   214: astore 6
    //   216: aload_0
    //   217: astore 7
    //   219: ldc 77
    //   221: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload_2
    //   225: astore 5
    //   227: aload_1
    //   228: astore 6
    //   230: aload_0
    //   231: astore 7
    //   233: aload 4
    //   235: athrow
    //   236: astore_0
    //   237: aload 7
    //   239: astore_1
    //   240: aload 5
    //   242: astore_2
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 170	java/io/OutputStream:close	()V
    //   251: aload_1
    //   252: ifnull +7 -> 259
    //   255: aload_1
    //   256: invokevirtual 171	javax/crypto/CipherInputStream:close	()V
    //   259: aload 6
    //   261: ifnull +8 -> 269
    //   264: aload 6
    //   266: invokevirtual 174	java/io/InputStream:close	()V
    //   269: ldc 77
    //   271: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_0
    //   275: athrow
    //   276: aload_2
    //   277: ifnull +7 -> 284
    //   280: aload_2
    //   281: invokevirtual 170	java/io/OutputStream:close	()V
    //   284: aload_0
    //   285: invokevirtual 171	javax/crypto/CipherInputStream:close	()V
    //   288: aload_1
    //   289: ifnull +13 -> 302
    //   292: aload_1
    //   293: invokevirtual 174	java/io/InputStream:close	()V
    //   296: ldc 77
    //   298: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: return
    //   302: ldc 77
    //   304: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: return
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_2
    //   311: aconst_null
    //   312: astore 6
    //   314: aconst_null
    //   315: astore_1
    //   316: goto -73 -> 243
    //   319: astore_0
    //   320: aconst_null
    //   321: astore_2
    //   322: aconst_null
    //   323: astore 4
    //   325: aload_1
    //   326: astore 6
    //   328: aload 4
    //   330: astore_1
    //   331: goto -88 -> 243
    //   334: astore_0
    //   335: aconst_null
    //   336: astore 4
    //   338: aload_1
    //   339: astore 6
    //   341: aload 4
    //   343: astore_1
    //   344: goto -101 -> 243
    //   347: astore 4
    //   349: aconst_null
    //   350: astore_2
    //   351: aconst_null
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_0
    //   355: goto -145 -> 210
    //   358: astore 4
    //   360: aconst_null
    //   361: astore_2
    //   362: aconst_null
    //   363: astore_0
    //   364: goto -154 -> 210
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_0
    //   371: goto -161 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramString1	String
    //   0	374	1	paramString2	String
    //   0	374	2	paramString3	String
    //   169	20	3	i	int
    //   99	87	4	localObject1	Object
    //   208	26	4	localException1	Exception
    //   323	19	4	localObject2	Object
    //   347	1	4	localException2	Exception
    //   358	1	4	localException3	Exception
    //   367	1	4	localException4	Exception
    //   106	135	5	localObject3	Object
    //   142	198	6	str1	String
    //   145	93	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   147	154	208	java/lang/Exception
    //   163	170	208	java/lang/Exception
    //   184	192	208	java/lang/Exception
    //   201	205	208	java/lang/Exception
    //   147	154	236	finally
    //   163	170	236	finally
    //   184	192	236	finally
    //   201	205	236	finally
    //   219	224	236	finally
    //   233	236	236	finally
    //   60	65	308	finally
    //   65	70	319	finally
    //   70	138	334	finally
    //   60	65	347	java/lang/Exception
    //   65	70	358	java/lang/Exception
    //   70	138	367	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte);
    
    public abstract void onError();
  }
  
  final class b
    implements g.a
  {
    private String fileName;
    private String qFJ;
    
    private b(String paramString1, String paramString2)
    {
      this.qFJ = paramString2;
      this.fileName = paramString1;
    }
    
    public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(104226);
      ac.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ac.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
        paramString = e.this;
        paramc = this.fileName;
        String str = paramd.field_fileId;
        paramd = paramd.field_aesKey;
        if (paramString.qFT != null) {
          paramString.qFT.a(paramc, str, paramd, paramString.qFU);
        }
      }
      do
      {
        AppMethodBeat.o(104226);
        return 0;
        if (paramd != null)
        {
          ac.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
          i.deleteFile(this.fileName);
          h.wUl.idkeyStat(917L, 51L, 1L, false);
          if (e.this.qFT != null) {
            e.this.qFT.onError();
          }
          AppMethodBeat.o(104226);
          return 0;
        }
      } while (paramInt == 0);
      ac.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      h.wUl.idkeyStat(917L, 51L, 1L, false);
      i.deleteFile(this.fileName);
      if (e.this.qFT != null) {
        e.this.qFT.onError();
      }
      AppMethodBeat.o(104226);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e
 * JD-Core Version:    0.7.0.1
 */