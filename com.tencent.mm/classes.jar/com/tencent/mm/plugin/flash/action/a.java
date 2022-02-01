package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.flash.b.a
{
  private String Hir;
  private String His;
  private int Hit;
  private long Hiu;
  private String hYA;
  private String hYz;
  private String packageName;
  private String personId;
  private String videoPath;
  private String zTa;
  private float zZM;
  private String zZN;
  private boolean zZS;
  private byte[] zZX;
  
  public a()
  {
    AppMethodBeat.i(264758);
    this.hYA = "";
    this.zZS = false;
    this.videoPath = (com.tencent.mm.plugin.flash.b.Hig + Util.currentTicks() + ".mp4");
    this.Hir = (com.tencent.mm.plugin.flash.b.Hig + Util.currentTicks() + "_encrypt");
    this.His = "";
    this.Hit = 0;
    this.Hiu = 0L;
    AppMethodBeat.o(264758);
  }
  
  private void I(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(264769);
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errorcode", paramInt);
      localJSONObject.put("errormsg", paramString1);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("err_feedback", this.Hjb);
      localJSONObject.put("otherVerifyTitle", this.hYA);
      label74:
      localHashMap.put("response", localJSONObject.toString());
      this.HiY.onNetworkResponseEvent(localHashMap, null);
      Log.e("MicroMsg.FaceFlashManagerError", paramString2);
      AppMethodBeat.o(264769);
      return;
    }
    catch (JSONException paramString1)
    {
      break label74;
    }
  }
  
  /* Error */
  private static void ae(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 143
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 145	com/tencent/mm/vfs/u
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 148	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: new 145	com/tencent/mm/vfs/u
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 148	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 152	com/tencent/mm/vfs/u:jKS	()Z
    //   27: ifeq +275 -> 302
    //   30: aload_1
    //   31: invokevirtual 155	com/tencent/mm/vfs/u:jKV	()Z
    //   34: ifeq +268 -> 302
    //   37: aload_2
    //   38: invokevirtual 159	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   41: invokevirtual 152	com/tencent/mm/vfs/u:jKS	()Z
    //   44: ifne +11 -> 55
    //   47: aload_2
    //   48: invokevirtual 159	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   51: invokevirtual 162	com/tencent/mm/vfs/u:jKY	()Z
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 165	com/tencent/mm/vfs/u:jKZ	()Z
    //   59: pop
    //   60: aload_1
    //   61: invokestatic 171	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   64: astore_1
    //   65: aload_2
    //   66: invokestatic 175	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   69: astore_2
    //   70: new 177	javax/crypto/spec/SecretKeySpec
    //   73: dup
    //   74: new 177	javax/crypto/spec/SecretKeySpec
    //   77: dup
    //   78: aload_0
    //   79: ldc 179
    //   81: invokevirtual 185	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   84: ldc 187
    //   86: invokespecial 190	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   89: invokeinterface 196 1 0
    //   94: ldc 187
    //   96: invokespecial 190	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   99: astore 4
    //   101: ldc 198
    //   103: invokestatic 204	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   106: astore 5
    //   108: aload 5
    //   110: iconst_1
    //   111: aload 4
    //   113: new 206	javax/crypto/spec/IvParameterSpec
    //   116: dup
    //   117: aload_0
    //   118: invokevirtual 208	java/lang/String:getBytes	()[B
    //   121: invokespecial 211	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   124: invokevirtual 215	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   127: new 217	javax/crypto/CipherInputStream
    //   130: dup
    //   131: aload_1
    //   132: aload 5
    //   134: invokespecial 220	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
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
    //   166: invokevirtual 224	javax/crypto/CipherInputStream:read	([B)I
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
    //   189: invokevirtual 230	java/io/OutputStream:write	([BII)V
    //   192: aload_2
    //   193: astore 5
    //   195: aload_1
    //   196: astore 6
    //   198: aload_0
    //   199: astore 7
    //   201: aload_2
    //   202: invokevirtual 233	java/io/OutputStream:flush	()V
    //   205: goto -51 -> 154
    //   208: astore 4
    //   210: aload_2
    //   211: astore 5
    //   213: aload_1
    //   214: astore 6
    //   216: aload_0
    //   217: astore 7
    //   219: ldc 143
    //   221: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   248: invokevirtual 236	java/io/OutputStream:close	()V
    //   251: aload_1
    //   252: ifnull +7 -> 259
    //   255: aload_1
    //   256: invokevirtual 237	javax/crypto/CipherInputStream:close	()V
    //   259: aload 6
    //   261: ifnull +8 -> 269
    //   264: aload 6
    //   266: invokevirtual 240	java/io/InputStream:close	()V
    //   269: ldc 143
    //   271: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_0
    //   275: athrow
    //   276: aload_2
    //   277: ifnull +7 -> 284
    //   280: aload_2
    //   281: invokevirtual 236	java/io/OutputStream:close	()V
    //   284: aload_0
    //   285: invokevirtual 237	javax/crypto/CipherInputStream:close	()V
    //   288: aload_1
    //   289: ifnull +13 -> 302
    //   292: aload_1
    //   293: invokevirtual 240	java/io/InputStream:close	()V
    //   296: ldc 143
    //   298: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: return
    //   302: ldc 143
    //   304: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(264859);
    Log.i("MicroMsg.FaceFlashActionManager", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    int i;
    if (paramd == null)
    {
      i = -1;
      com.tencent.mm.plugin.flash.c.b.F("rspCdn", Integer.valueOf(i));
      com.tencent.mm.plugin.flash.c.b.fuP().ivr = i;
      com.tencent.mm.plugin.flash.c.b.fuP().ivt = (System.currentTimeMillis() - this.zZZ);
      if ((paramd == null) || (paramd.field_retCode != 0)) {
        break label224;
      }
      Log.i("MicroMsg.FaceFlashActionManager", "hy: upload video done. now upload");
      y.deleteFile(this.Hir);
      com.tencent.mm.plugin.flash.c.b.aDA("reqVerify");
      paramString = new com.tencent.mm.plugin.facedetectaction.a.c(this.personId, this.zTa, this.zZM, paramd.field_fileId, paramd.field_aesKey, this.scene, this.zZN, this.packageName, this.zZX, this.zZS, 1, 0L, this.longitude, this.latitude);
      h.aZW().a(2726, this);
      h.aZW().a(paramString, 0);
      com.tencent.mm.plugin.flash.c.b.fuP().ivu = (System.currentTimeMillis() - this.Hiu);
    }
    label224:
    do
    {
      AppMethodBeat.o(264859);
      return 0;
      i = paramd.field_retCode;
      break;
      if (paramd != null)
      {
        Log.w("MicroMsg.FaceFlashActionManager", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        y.deleteFile(this.Hir);
        AppMethodBeat.o(264859);
        return 0;
      }
    } while (paramInt == 0);
    Log.w("MicroMsg.FaceFlashActionManager", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    com.tencent.mm.plugin.flash.c.b.fuP().ivK = 5;
    AppMethodBeat.o(264859);
    return 0;
  }
  
  public final void c(TextView paramTextView, String paramString)
  {
    int i = 1;
    AppMethodBeat.i(264872);
    try
    {
      if (System.currentTimeMillis() - this.Hjd >= 1000L) {
        this.Hjd = System.currentTimeMillis();
      }
      while (i == 0)
      {
        AppMethodBeat.o(264872);
        return;
        i = 0;
      }
      String str = com.tencent.mm.plugin.flash.d.a.aP(paramTextView.getContext(), paramString);
      Log.i("MicroMsg.FaceFlashActionManager", "updateTipText res:%s tip:%s", new Object[] { paramString, str });
      if (!TextUtils.isEmpty(str)) {
        paramTextView.setText(str);
      }
      AppMethodBeat.o(264872);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramTextView, "", new Object[0]);
      AppMethodBeat.o(264872);
    }
  }
  
  public final int fux()
  {
    return 16;
  }
  
  public final void h(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(264788);
    super.h(paramIntent, paramActivity);
    this.scene = paramIntent.getIntExtra("scene", 0);
    this.packageName = paramIntent.getStringExtra("package");
    this.hYz = paramIntent.getStringExtra("packageSign");
    this.zZS = paramIntent.getBooleanExtra("needContract", false);
    this.hYA = paramIntent.getStringExtra("otherVerifyTitle");
    Log.i("MicroMsg.FaceFlashActionManager", "[%s]intent data, packageName:%s packageSign:%s needSignContract:%s otherVerifyTitle:%s", new Object[] { getClass().getSimpleName(), this.packageName, this.hYz, Boolean.valueOf(this.zZS), this.hYA });
    aR(paramActivity);
    AppMethodBeat.o(264788);
  }
  
  public final void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(264824);
    Log.i("MicroMsg.FaceFlashActionManager", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", new Object[] { paramString1, paramString2, paramHashMap });
    this.HiY = paramIYtSDKKitNetResponseParser;
    if (paramString1.contains("wechat_face_config"))
    {
      com.tencent.mm.plugin.flash.c.b.aDA("reqCfg");
      fuE();
      com.tencent.mm.plugin.flash.c.a.VH(16);
      paramString1 = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.hYz);
      h.aZW().a(2696, this);
      h.aZW().a(paramString1, 0);
      AppMethodBeat.o(264824);
      return;
    }
    if (paramString1.contains("wechat_face_verify")) {
      try
      {
        fuF();
        com.tencent.mm.plugin.flash.c.a.VI(16);
        paramString2 = new JSONObject(paramString2).optString("action_video");
        y.deleteFile(this.videoPath);
        y.deleteFile(this.Hir);
        paramString1 = this.videoPath;
        paramString2 = Base64.decode(paramString2, 0);
        y.f(paramString1, paramString2, paramString2.length);
        paramString1 = y.bub(this.videoPath);
        Log.i("MicroMsg.FaceFlashActionManager", "MD5ForSignatureString：%s", new Object[] { paramString1 });
        paramString1 = paramString1.getBytes();
        paramString2 = new PByteArray();
        if (com.tencent.mm.plugin.normsg.a.d.MtP.a(1, paramString1, 0, paramString1.length, paramString2)) {}
        for (this.zZX = paramString2.value;; this.zZX = paramString1)
        {
          ae(this.personId, this.videoPath, this.Hir);
          y.deleteFile(this.videoPath);
          aDx(this.Hir);
          AppMethodBeat.o(264824);
          return;
          Log.i("MicroMsg.FaceFlashActionManager", "digitalSignature failed");
        }
        AppMethodBeat.o(264824);
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString1, "action parse verify body error!!!", new Object[0]);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 1;
    AppMethodBeat.i(264849);
    Log.i("MicroMsg.FaceFlashActionManager", "onSceneEnd：errType %s ， errCode %s ，errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      Log.i("MicroMsg.FaceFlashActionManager", "scene is getFaceCheckActionerrType");
      com.tencent.mm.plugin.flash.c.b.F("rspCfg", Integer.valueOf(paramInt2));
      this.Hit += 1;
      h.aZW().b(2696, this);
      paramp = (com.tencent.mm.plugin.facedetectaction.a.a)paramp;
      com.tencent.mm.plugin.flash.c.b.fuP().ivq = paramInt2;
      this.Hiu = System.currentTimeMillis();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramp.zZp;
        Log.i("MicroMsg.FaceFlashActionManager", "[cgi-ret]NetSceneGetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.wuz), paramString.wuA, paramString.action_data, Float.valueOf(paramString.aasn), paramString.Zji });
        if (paramString.wuz == 0)
        {
          this.personId = paramString.person_id;
          this.zTa = paramString.action_data;
          this.zZM = paramString.aasn;
          this.zZN = paramString.Zji;
          Log.i("MicroMsg.FaceFlashActionManager", "[cgi-ret]NetSceneGetFaceCheckAction personId:%s actionData:%s reductionRatio:%s", new Object[] { this.personId, this.zTa, Float.valueOf(this.zZM) });
          switch (Util.getInt(this.zTa, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            I(-1, "", "get action data error 1");
            AppMethodBeat.o(264849);
            return;
            Log.i("MicroMsg.FaceFlashActionManager", "user check blink eye");
            this.His = com.tencent.mm.cd.a.bt(this.activity, a.i.face_action_blink);
            paramInt1 = i;
            continue;
            Log.i("MicroMsg.FaceFlashActionManager", "user check open month");
            this.His = com.tencent.mm.cd.a.bt(this.activity, a.i.face_action_open);
            paramInt1 = 2;
          }
          Log.i("MicroMsg.FaceFlashActionManager", "packageSuccessResult1");
          paramString = new HashMap();
          paramp = new JSONObject();
        }
      }
    }
    try
    {
      paramp.put("errorcode", 0);
      paramp.put("errormsg", "OK");
      paramp.put("type", 1);
      paramp.put("action_data", String.valueOf(paramInt1));
      paramString.put("response", paramp.toString());
      label451:
      this.HiY.onNetworkResponseEvent(paramString, null);
      AppMethodBeat.o(264849);
      return;
      I(paramString.wuz, paramString.wuA, "get action data error 2");
      AppMethodBeat.o(264849);
      return;
      com.tencent.mm.plugin.flash.c.b.fuP().ivK = 3;
      I(paramInt2, paramString, "get action data error 3");
      AppMethodBeat.o(264849);
      return;
      cjv localcjv;
      if ((paramp instanceof com.tencent.mm.plugin.facedetectaction.a.c))
      {
        paramString = (com.tencent.mm.plugin.facedetectaction.a.c)paramp;
        h.aZW().b(2726, this);
        localcjv = paramString.zZt;
        Log.i("MicroMsg.FaceFlashActionManager", "scene is getFaceCheckResult get face check result, ret_code: %s, ret_msg: %s serialId:%s retry:%s", new Object[] { Integer.valueOf(localcjv.wuz), localcjv.wuA, localcjv.aasu, Integer.valueOf(localcjv.aast) });
        com.tencent.mm.plugin.flash.c.b.F("rspVerify", Integer.valueOf(localcjv.wuz));
        com.tencent.mm.plugin.flash.c.b.fuP().ivs = localcjv.wuz;
        paramString = new HashMap();
        paramp = new JSONObject();
      }
      for (;;)
      {
        try
        {
          paramp.put("countFace", this.Hit);
          paramp.put("err_code", localcjv.wuz);
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            continue;
          }
          com.tencent.mm.plugin.flash.c.a.VJ(16);
          paramp.put("errorcode", localcjv.wuz);
          paramp.put("error_code", localcjv.wuz);
          paramp.put("errormsg", localcjv.wuA);
          paramp.put("err_msg", "ok");
          paramp.put("token", localcjv.ZpZ);
          paramp.put("serial_id", localcjv.aasu);
          paramp.put("scene", this.scene);
          if (localcjv.wuz != 0)
          {
            paramp.put("err_retry", localcjv.aast);
            paramp.put("err_tip", localcjv.wuA);
            paramp.put("err_msg", "fail");
            paramp.put("otherVerifyTitle", this.hYA);
          }
        }
        catch (JSONException localJSONException)
        {
          continue;
        }
        paramString.put("response", paramp.toString());
        this.HiY.onNetworkResponseEvent(paramString, null);
        AppMethodBeat.o(264849);
        return;
        com.tencent.mm.plugin.flash.c.b.fuP().ivK = 4;
        com.tencent.mm.plugin.flash.c.a.VK(16);
        paramp.put("errorcode", paramInt2);
        paramp.put("error_code", paramInt2);
        paramp.put("errormsg", localcjv.wuA);
        paramp.put("otherVerifyTitle", this.hYA);
        paramp.put("err_code", paramInt2);
        paramp.put("err_retry", localcjv.aast);
        paramp.put("err_msg", "fail");
      }
    }
    catch (JSONException paramp)
    {
      break label451;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(264803);
    super.release();
    h.aZW().b(2696, this);
    h.aZW().b(2726, this);
    y.deleteFile(this.videoPath);
    y.deleteFile(this.Hir);
    AppMethodBeat.o(264803);
  }
  
  public final void y(TextView paramTextView)
  {
    AppMethodBeat.i(264866);
    paramTextView.setText(this.His);
    AppMethodBeat.o(264866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.a
 * JD-Core Version:    0.7.0.1
 */