package com.tencent.mm.plugin.facedetectaction.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.e.a.4;
import com.tencent.mm.plugin.facedetect.e.a.5;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;

public final class d
{
  int orientation;
  String personId;
  float zZM;
  int zZP;
  int zZQ;
  a zZW;
  byte[] zZX;
  public String zZY;
  long zZZ;
  
  public d(String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104227);
    this.zZY = "";
    this.zZZ = System.currentTimeMillis();
    this.personId = paramString;
    this.zZM = paramFloat;
    this.orientation = paramInt1;
    this.zZP = paramInt2;
    this.zZQ = paramInt3;
    Log.i("MicroMsg.FaceCheckVideoRecordMgr", "create FaceCheckVideoRecordMgr, reductionRatio: %s, orientation: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(104227);
  }
  
  /* Error */
  static void ae(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 94
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 96	com/tencent/mm/vfs/u
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 99	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: new 96	com/tencent/mm/vfs/u
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 99	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 103	com/tencent/mm/vfs/u:jKS	()Z
    //   27: ifeq +275 -> 302
    //   30: aload_1
    //   31: invokevirtual 106	com/tencent/mm/vfs/u:jKV	()Z
    //   34: ifeq +268 -> 302
    //   37: aload_2
    //   38: invokevirtual 110	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   41: invokevirtual 103	com/tencent/mm/vfs/u:jKS	()Z
    //   44: ifne +11 -> 55
    //   47: aload_2
    //   48: invokevirtual 110	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   51: invokevirtual 113	com/tencent/mm/vfs/u:jKY	()Z
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 116	com/tencent/mm/vfs/u:jKZ	()Z
    //   59: pop
    //   60: aload_1
    //   61: invokestatic 122	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   64: astore_1
    //   65: aload_2
    //   66: invokestatic 126	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   69: astore_2
    //   70: new 128	javax/crypto/spec/SecretKeySpec
    //   73: dup
    //   74: new 128	javax/crypto/spec/SecretKeySpec
    //   77: dup
    //   78: aload_0
    //   79: ldc 130
    //   81: invokevirtual 136	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   84: ldc 138
    //   86: invokespecial 141	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   89: invokeinterface 147 1 0
    //   94: ldc 138
    //   96: invokespecial 141	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   99: astore 4
    //   101: ldc 149
    //   103: invokestatic 155	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   106: astore 5
    //   108: aload 5
    //   110: iconst_1
    //   111: aload 4
    //   113: new 157	javax/crypto/spec/IvParameterSpec
    //   116: dup
    //   117: aload_0
    //   118: invokevirtual 159	java/lang/String:getBytes	()[B
    //   121: invokespecial 162	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   124: invokevirtual 166	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   127: new 168	javax/crypto/CipherInputStream
    //   130: dup
    //   131: aload_1
    //   132: aload 5
    //   134: invokespecial 171	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
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
    //   166: invokevirtual 175	javax/crypto/CipherInputStream:read	([B)I
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
    //   189: invokevirtual 181	java/io/OutputStream:write	([BII)V
    //   192: aload_2
    //   193: astore 5
    //   195: aload_1
    //   196: astore 6
    //   198: aload_0
    //   199: astore 7
    //   201: aload_2
    //   202: invokevirtual 184	java/io/OutputStream:flush	()V
    //   205: goto -51 -> 154
    //   208: astore 4
    //   210: aload_2
    //   211: astore 5
    //   213: aload_1
    //   214: astore 6
    //   216: aload_0
    //   217: astore 7
    //   219: ldc 94
    //   221: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   248: invokevirtual 187	java/io/OutputStream:close	()V
    //   251: aload_1
    //   252: ifnull +7 -> 259
    //   255: aload_1
    //   256: invokevirtual 188	javax/crypto/CipherInputStream:close	()V
    //   259: aload 6
    //   261: ifnull +8 -> 269
    //   264: aload 6
    //   266: invokevirtual 191	java/io/InputStream:close	()V
    //   269: ldc 94
    //   271: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_0
    //   275: athrow
    //   276: aload_2
    //   277: ifnull +7 -> 284
    //   280: aload_2
    //   281: invokevirtual 187	java/io/OutputStream:close	()V
    //   284: aload_0
    //   285: invokevirtual 188	javax/crypto/CipherInputStream:close	()V
    //   288: aload_1
    //   289: ifnull +13 -> 302
    //   292: aload_1
    //   293: invokevirtual 191	java/io/InputStream:close	()V
    //   296: ldc 94
    //   298: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: return
    //   302: ldc 94
    //   304: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public abstract void atR();
  }
  
  final class b
    implements g.a
  {
    private String fileName;
    private String personId;
    
    private b(String paramString1, String paramString2)
    {
      this.personId = paramString2;
      this.fileName = paramString1;
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(104226);
      Log.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      int i;
      if (paramd == null)
      {
        i = -1;
        com.tencent.mm.plugin.flash.c.b.fuP().ivr = i;
        com.tencent.mm.plugin.flash.c.b.fuP().ivt = (System.currentTimeMillis() - d.this.zZZ);
        com.tencent.mm.plugin.flash.c.b.F("rspCdn", Integer.valueOf(i));
        if ((paramd == null) || (paramd.field_retCode != 0)) {
          break label165;
        }
        Log.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
        paramString = d.this;
        paramc = this.fileName;
        String str = paramd.field_fileId;
        paramd = paramd.field_aesKey;
        if (paramString.zZW != null) {
          paramString.zZW.a(paramc, str, paramd, paramString.zZX);
        }
      }
      label165:
      do
      {
        AppMethodBeat.o(104226);
        return 0;
        i = paramd.field_retCode;
        break;
        if (paramd != null)
        {
          Log.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
          y.deleteFile(this.fileName);
          h.OAn.idkeyStat(917L, 51L, 1L, false);
          if (d.this.zZW != null) {
            d.this.zZW.atR();
          }
          AppMethodBeat.o(104226);
          return 0;
        }
      } while (paramInt == 0);
      Log.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      h.OAn.idkeyStat(917L, 51L, 1L, false);
      y.deleteFile(this.fileName);
      if (d.this.zZW != null) {
        d.this.zZW.atR();
      }
      AppMethodBeat.o(104226);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.model.d
 * JD-Core Version:    0.7.0.1
 */