package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.Intent;
import android.util.Base64;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.i.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.flash.b.a
{
  private String dYK;
  private String dYL;
  private String packageName;
  private String personId;
  private String sQY;
  private float sXC;
  private String sXD;
  private boolean sXI;
  private byte[] sXN;
  private String videoPath;
  private String wHU;
  private String wHV;
  private int wHW;
  private long wHX;
  
  public a()
  {
    AppMethodBeat.i(186527);
    this.dYL = "";
    this.sXI = false;
    this.videoPath = (com.tencent.mm.plugin.flash.a.wHI + Util.currentTicks() + ".mp4");
    this.wHU = (com.tencent.mm.plugin.flash.a.wHI + Util.currentTicks() + "_encrypt");
    this.wHV = "";
    this.wHW = 0;
    this.wHX = 0L;
    AppMethodBeat.o(186527);
  }
  
  private void A(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186533);
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errorcode", paramInt);
      localJSONObject.put("errormsg", paramString1);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("otherVerifyTitle", this.dYL);
      label62:
      localHashMap.put("response", localJSONObject.toString());
      this.wIj.onNetworkResponseEvent(localHashMap, null);
      Log.e("MicroMsg.FaceFlashManagerError", paramString2);
      AppMethodBeat.o(186533);
      return;
    }
    catch (JSONException paramString1)
    {
      break label62;
    }
  }
  
  /* Error */
  private static void ae(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 141	com/tencent/mm/vfs/o
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 144	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: new 141	com/tencent/mm/vfs/o
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 144	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 148	com/tencent/mm/vfs/o:exists	()Z
    //   27: ifeq +275 -> 302
    //   30: aload_1
    //   31: invokevirtual 151	com/tencent/mm/vfs/o:isFile	()Z
    //   34: ifeq +268 -> 302
    //   37: aload_2
    //   38: invokevirtual 155	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   41: invokevirtual 148	com/tencent/mm/vfs/o:exists	()Z
    //   44: ifne +11 -> 55
    //   47: aload_2
    //   48: invokevirtual 155	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   51: invokevirtual 158	com/tencent/mm/vfs/o:mkdirs	()Z
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 161	com/tencent/mm/vfs/o:createNewFile	()Z
    //   59: pop
    //   60: aload_1
    //   61: invokestatic 167	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   64: astore_1
    //   65: aload_2
    //   66: invokestatic 171	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   69: astore_2
    //   70: new 173	javax/crypto/spec/SecretKeySpec
    //   73: dup
    //   74: new 173	javax/crypto/spec/SecretKeySpec
    //   77: dup
    //   78: aload_0
    //   79: ldc 175
    //   81: invokevirtual 181	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   84: ldc 183
    //   86: invokespecial 186	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   89: invokeinterface 192 1 0
    //   94: ldc 183
    //   96: invokespecial 186	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   99: astore 4
    //   101: ldc 194
    //   103: invokestatic 200	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   106: astore 5
    //   108: aload 5
    //   110: iconst_1
    //   111: aload 4
    //   113: new 202	javax/crypto/spec/IvParameterSpec
    //   116: dup
    //   117: aload_0
    //   118: invokevirtual 204	java/lang/String:getBytes	()[B
    //   121: invokespecial 207	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   124: invokevirtual 211	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   127: new 213	javax/crypto/CipherInputStream
    //   130: dup
    //   131: aload_1
    //   132: aload 5
    //   134: invokespecial 216	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
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
    //   166: invokevirtual 220	javax/crypto/CipherInputStream:read	([B)I
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
    //   189: invokevirtual 226	java/io/OutputStream:write	([BII)V
    //   192: aload_2
    //   193: astore 5
    //   195: aload_1
    //   196: astore 6
    //   198: aload_0
    //   199: astore 7
    //   201: aload_2
    //   202: invokevirtual 229	java/io/OutputStream:flush	()V
    //   205: goto -51 -> 154
    //   208: astore 4
    //   210: aload_2
    //   211: astore 5
    //   213: aload_1
    //   214: astore 6
    //   216: aload_0
    //   217: astore 7
    //   219: ldc 139
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
    //   248: invokevirtual 232	java/io/OutputStream:close	()V
    //   251: aload_1
    //   252: ifnull +7 -> 259
    //   255: aload_1
    //   256: invokevirtual 233	javax/crypto/CipherInputStream:close	()V
    //   259: aload 6
    //   261: ifnull +8 -> 269
    //   264: aload 6
    //   266: invokevirtual 236	java/io/InputStream:close	()V
    //   269: ldc 139
    //   271: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_0
    //   275: athrow
    //   276: aload_2
    //   277: ifnull +7 -> 284
    //   280: aload_2
    //   281: invokevirtual 232	java/io/OutputStream:close	()V
    //   284: aload_0
    //   285: invokevirtual 233	javax/crypto/CipherInputStream:close	()V
    //   288: aload_1
    //   289: ifnull +13 -> 302
    //   292: aload_1
    //   293: invokevirtual 236	java/io/InputStream:close	()V
    //   296: ldc 139
    //   298: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: return
    //   302: ldc 139
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
  
  public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(186532);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    int i;
    if (paramd == null)
    {
      i = -1;
      com.tencent.mm.plugin.flash.c.b.s("rspCdn", Integer.valueOf(i));
      com.tencent.mm.plugin.flash.c.b.dLj().eqU = i;
      com.tencent.mm.plugin.flash.c.b.dLj().eqW = (System.currentTimeMillis() - this.sXP);
      if ((paramd == null) || (paramd.field_retCode != 0)) {
        break label212;
      }
      Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "hy: upload video done. now upload");
      s.deleteFile(this.wHU);
      com.tencent.mm.plugin.flash.c.b.axn("reqVerify");
      paramString = new com.tencent.mm.plugin.facedetectaction.a.b(this.personId, this.sQY, this.sXC, paramd.field_fileId, paramd.field_aesKey, this.scene, this.sXD, this.packageName, this.sXN, this.sXI);
      g.azz().a(2726, this);
      g.azz().a(paramString, 0);
      com.tencent.mm.plugin.flash.c.b.dLj().eqX = (System.currentTimeMillis() - this.wHX);
    }
    label212:
    do
    {
      AppMethodBeat.o(186532);
      return 0;
      i = paramd.field_retCode;
      break;
      if (paramd != null)
      {
        Log.w("MicroMsg.FaceFlashManager.FaceFlashActionManager", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        s.deleteFile(this.wHU);
        AppMethodBeat.o(186532);
        return 0;
      }
    } while (paramInt == 0);
    Log.w("MicroMsg.FaceFlashManager.FaceFlashActionManager", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    AppMethodBeat.o(186532);
    return 0;
  }
  
  public final int dKV()
  {
    return 16;
  }
  
  public final void h(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(186528);
    super.h(paramIntent, paramActivity);
    this.packageName = paramIntent.getStringExtra("package");
    this.dYK = paramIntent.getStringExtra("packageSign");
    this.sXI = paramIntent.getBooleanExtra("needContract", false);
    this.dYL = paramIntent.getStringExtra("otherVerifyTitle");
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "[%s]intent data, packageName:%s packageSign:%s needSignContract:%s otherVerifyTitle:%s", new Object[] { getClass().getSimpleName(), this.packageName, this.dYK, Boolean.valueOf(this.sXI), this.dYL });
    AppMethodBeat.o(186528);
  }
  
  public final void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(186530);
    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", new Object[] { paramString1, paramString2, paramHashMap });
    this.wIj = paramIYtSDKKitNetResponseParser;
    if (paramString1.contains("wechat_face_config"))
    {
      com.tencent.mm.plugin.flash.c.b.axn("reqCfg");
      dKZ();
      com.tencent.mm.plugin.flash.c.a.MS(16);
      paramString1 = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.dYK);
      g.azz().a(2696, this);
      g.azz().a(paramString1, 0);
      AppMethodBeat.o(186530);
      return;
    }
    if (paramString1.contains("wechat_face_verify")) {
      try
      {
        dLa();
        com.tencent.mm.plugin.flash.c.a.MT(16);
        paramString2 = new JSONObject(paramString2).optString("action_video");
        s.deleteFile(this.videoPath);
        s.deleteFile(this.wHU);
        paramString1 = this.videoPath;
        paramString2 = Base64.decode(paramString2, 0);
        s.f(paramString1, paramString2, paramString2.length);
        paramString1 = s.bhK(this.videoPath);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "MD5ForSignatureString：%s", new Object[] { paramString1 });
        paramString1 = paramString1.getBytes();
        paramString2 = new PByteArray();
        if (com.tencent.mm.plugin.normsg.a.d.AEF.a(1, paramString1, 0, paramString1.length, paramString2)) {}
        for (this.sXN = paramString2.value;; this.sXN = paramString1)
        {
          ae(this.personId, this.videoPath, this.wHU);
          s.deleteFile(this.videoPath);
          axj(this.wHU);
          AppMethodBeat.o(186530);
          return;
          Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "digitalSignature failed");
        }
        AppMethodBeat.o(186530);
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString1, "action parse verify body error!!!", new Object[0]);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(186531);
    if ((paramq instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(paramInt2));
      this.wHW += 1;
      g.azz().b(2696, this);
      paramq = (com.tencent.mm.plugin.facedetectaction.a.a)paramq;
      Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "[cgi-ret]NetSceneGetFaceCheckAction1 errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.plugin.flash.c.b.dLj().eqT = paramInt2;
      this.wHX = System.currentTimeMillis();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramq.sXg;
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "[cgi-ret]NetSceneGetFaceCheckAction2, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.pTZ), paramString.pUa, paramString.action_data, Float.valueOf(paramString.LVN), paramString.LjH });
        if (paramString.pTZ == 0)
        {
          this.personId = paramString.person_id;
          this.sQY = paramString.action_data;
          this.sXC = paramString.LVN;
          this.sXD = paramString.LjH;
          Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "[cgi-ret]NetSceneGetFaceCheckAction2 personId:%s actionData:%s reductionRatio:%s", new Object[] { this.personId, this.sQY, Float.valueOf(this.sXC) });
          switch (Util.getInt(this.sQY, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            A(-1, "", "get action data error 1");
            AppMethodBeat.o(186531);
            return;
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "user check blink eye");
            this.wHV = com.tencent.mm.cb.a.aI(this.activity, 2131758983);
            paramInt1 = i;
            continue;
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "user check open month");
            this.wHV = com.tencent.mm.cb.a.aI(this.activity, 2131758984);
            paramInt1 = 2;
          }
          paramString = new HashMap();
          paramq = new JSONObject();
        }
      }
    }
    try
    {
      paramq.put("errorcode", 0);
      paramq.put("errormsg", "OK");
      paramq.put("type", 1);
      paramq.put("action_data", String.valueOf(paramInt1));
      paramString.put("response", paramq.toString());
      label435:
      this.wIj.onNetworkResponseEvent(paramString, null);
      AppMethodBeat.o(186531);
      return;
      A(paramString.pTZ, paramString.pUa, "get action data error 2");
      AppMethodBeat.o(186531);
      return;
      A(paramInt2, paramString, "get action data error 3");
      AppMethodBeat.o(186531);
      return;
      bnh localbnh;
      if ((paramq instanceof com.tencent.mm.plugin.facedetectaction.a.b))
      {
        paramString = (com.tencent.mm.plugin.facedetectaction.a.b)paramq;
        g.azz().b(2726, this);
        localbnh = paramString.sXi;
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "get face check result, ret_code: %s, ret_msg: %s serialId:%s retry:%s", new Object[] { Integer.valueOf(localbnh.pTZ), localbnh.pUa, localbnh.LVU, Integer.valueOf(localbnh.LVT) });
        com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(localbnh.pTZ));
        com.tencent.mm.plugin.flash.c.b.dLj().eqV = localbnh.pTZ;
        paramString = new HashMap();
        paramq = new JSONObject();
      }
      for (;;)
      {
        try
        {
          paramq.put("countFace", this.wHW);
          paramq.put("err_code", localbnh.pTZ);
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            continue;
          }
          com.tencent.mm.plugin.flash.c.a.MU(16);
          paramq.put("errorcode", localbnh.pTZ);
          paramq.put("error_code", localbnh.pTZ);
          paramq.put("errormsg", localbnh.pUa);
          paramq.put("err_msg", "ok");
          paramq.put("token", localbnh.LpC);
          paramq.put("serial_id", localbnh.LVU);
          paramq.put("scene", this.scene);
          if (localbnh.pTZ != 0)
          {
            paramq.put("err_retry", localbnh.LVT);
            paramq.put("err_tip", localbnh.pUa);
            paramq.put("err_msg", "fail");
          }
        }
        catch (JSONException localJSONException)
        {
          continue;
        }
        paramString.put("response", paramq.toString());
        this.wIj.onNetworkResponseEvent(paramString, null);
        AppMethodBeat.o(186531);
        return;
        com.tencent.mm.plugin.flash.c.a.MV(16);
        paramq.put("errorcode", paramInt2);
        paramq.put("error_code", paramInt2);
        paramq.put("errormsg", localbnh.pUa);
        paramq.put("otherVerifyTitle", this.dYL);
        paramq.put("err_code", paramInt2);
        paramq.put("err_retry", localbnh.LVT);
        paramq.put("err_msg", "fail");
      }
    }
    catch (JSONException paramq)
    {
      break label435;
    }
  }
  
  public final void r(TextView paramTextView)
  {
    AppMethodBeat.i(186535);
    paramTextView.setText(this.wHV);
    AppMethodBeat.o(186535);
  }
  
  public final void release()
  {
    AppMethodBeat.i(186529);
    super.release();
    g.azz().b(2696, this);
    g.azz().b(2726, this);
    s.deleteFile(this.videoPath);
    s.deleteFile(this.wHU);
    AppMethodBeat.o(186529);
  }
  
  public final void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.a
 * JD-Core Version:    0.7.0.1
 */