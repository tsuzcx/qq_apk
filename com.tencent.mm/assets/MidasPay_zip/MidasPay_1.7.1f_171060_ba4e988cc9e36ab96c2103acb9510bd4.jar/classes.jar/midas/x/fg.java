package midas.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.api.MidasAbilityResponse;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.ability.MidasActivityAbility.WXMiniProgramShare;
import com.pay.api.ability.MidasActivityAbility.WXWebShare;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class fg
{
  public static String a;
  public static String b = "1";
  public static String c = "2";
  public static String d = "3";
  public Handler e = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      APLog.i("APWechatPaySDK", "handleMessage");
      paramAnonymousMessage = paramAnonymousMessage.getData();
      int i = paramAnonymousMessage.getInt("errCode");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ret = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" callBack = ");
      localStringBuilder.append(fg.a(fg.this));
      APLog.i("APWechatChannel", localStringBuilder.toString());
      if (fg.a(fg.this) != null) {
        fg.a(fg.this).send(i, paramAnonymousMessage);
      }
      try
      {
        fg.b(fg.this).b(fg.this.e);
      }
      catch (Exception paramAnonymousMessage)
      {
        paramAnonymousMessage.printStackTrace();
      }
      return true;
    }
  });
  private final String f = "com.pay.buyManager.APWechatPaySDK";
  private Context g;
  private Bundle h;
  private ms i;
  private int j = 0;
  private ResultReceiver k;
  
  public fg(Context paramContext)
  {
    this.g = paramContext;
  }
  
  public fg(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toWeChat context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", wxAppId = ");
    localStringBuilder.append(paramString);
    APLog.i("APWechatPaySDK", localStringBuilder.toString());
    this.g = paramContext;
    try
    {
      this.i = ms.a(paramContext);
      this.i.a(paramString);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramString = new StringBuilder();
      paramString.append(" toWeChat registerApp e:");
      paramString.append(paramContext.toString());
      APLog.w("APWechatPaySDK", paramString.toString());
    }
    APLog.i("APWechatPaySDK", "toWeChat public APWechatPaySDK");
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    fp.a().p(true);
    if (a.a().a == null) {
      return;
    }
    if ((ed.b().n() != null) && (ed.b().n().a != null)) {
      APDataReportManager.getInstance().insertData("sdk.wechatcallback", ed.b().n().a.saveType, ed.b().n().e.m, String.valueOf(paramInt), null);
    } else {
      APDataReportManager.getInstance().insertData("sdk.wechatcallback", -1, "", String.valueOf(paramInt), null);
    }
    if (paramInt == -10)
    {
      APLog.d("wechat", " toWeChat 未安装微信客户端 ");
      APUICommonMethod.b();
      fm.a(2, "未安装微信客户端");
      return;
    }
    if (paramInt == 0)
    {
      APLog.i("APWechatPaySDK", "handleMessage result=0");
      if (this.j == 2) {
        if ("v2".equals(fp.a().M().toLowerCase()))
        {
          if ((!TextUtils.isEmpty(fp.a().N())) && (!TextUtils.isEmpty(fp.a().P()))) {
            a(fp.a().N(), fp.a().M(), fp.a().P(), fp.a().O());
          }
        }
        else if ((!TextUtils.isEmpty(fp.a().N())) && (!TextUtils.isEmpty(fp.a().O()))) {
          a(fp.a().N(), fp.a().M(), fp.a().P(), fp.a().O());
        }
      }
      APUICommonMethod.b();
      fm.a(8, -1, -1);
      return;
    }
    if (paramInt == -1)
    {
      APUICommonMethod.b();
      fm.a(paramInt, "系统繁忙,请稍后再试(100-100--1)");
      return;
    }
    if (paramInt == -2)
    {
      APUICommonMethod.b();
      fm.a(2, "");
      return;
    }
    APUICommonMethod.b();
    fm.a(paramInt, "系统繁忙,请稍后再试");
  }
  
  public static boolean a()
  {
    try
    {
      Class.forName(APTools.n("openapi.IWXAPI"));
      Class.forName(APTools.n("openapi.WXAPIFactory"));
      APLog.w("APWechatPaySDK", " is support WechatSDK");
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" is not support WechatSDK e:");
      localStringBuilder.append(localException.toString());
      APLog.w("APWechatPaySDK", localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return ms.b(paramContext);
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("wxAppid=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("   preEntrustWebId=");
    ((StringBuilder)localObject1).append(paramString2);
    APLog.d("toSignAutoPay", ((StringBuilder)localObject1).toString());
    if (!d())
    {
      fm.a(2, "未安装微信客户端");
      return false;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      try
      {
        localObject1 = Class.forName(APTools.n("openapi.IWXAPI"));
        paramString1 = Class.forName(APTools.n("openapi.WXAPIFactory")).getMethod("createWXAPI", new Class[] { Context.class, String.class, Boolean.TYPE }).invoke(null, new Object[] { this.g, paramString1, Boolean.valueOf(true) });
        Object localObject2 = Class.forName(APTools.n("modelbiz.WXOpenBusinessWebview$Req"));
        Class.forName(APTools.n("modelbiz.WXOpenBusinessWebview"));
        Class localClass = Class.forName(APTools.n("modelbase.BaseReq"));
        localObject2 = localObject2.getConstructors()[0].newInstance(new Object[0]);
        HashMap localHashMap = new HashMap();
        localHashMap.put("pre_entrustweb_id", paramString2);
        localObject2.getClass().getDeclaredField("queryInfo").set(localObject2, localHashMap);
        localObject2.getClass().getDeclaredField("businessType").set(localObject2, Integer.valueOf(12));
        ((Class)localObject1).getDeclaredMethod("sendReq", new Class[] { localClass }).invoke(paramString1, new Object[] { localObject2 });
        return true;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append(" exception = ");
        paramString2.append(paramString1.toString());
        APLog.d("toSignAutoPayV2", paramString2.toString());
        paramString1.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("wxAppid=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("   url=");
    ((StringBuilder)localObject1).append(paramString2);
    APLog.d("toSignAutoPay", ((StringBuilder)localObject1).toString());
    if (!d())
    {
      fm.a(2, "未安装微信客户端");
      return false;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      try
      {
        localObject1 = Class.forName(APTools.n("openapi.IWXAPI"));
        paramString1 = Class.forName(APTools.n("openapi.WXAPIFactory")).getMethod("createWXAPI", new Class[] { Context.class, String.class, Boolean.TYPE }).invoke(null, new Object[] { this.g, paramString1, Boolean.valueOf(true) });
        Object localObject2 = Class.forName(APTools.n("modelbiz.OpenWebview$Req"));
        Class.forName(APTools.n("modelbiz.OpenWebview"));
        Class localClass = Class.forName(APTools.n("modelbase.BaseReq"));
        localObject2 = localObject2.getConstructors()[0].newInstance(new Object[0]);
        localObject2.getClass().getDeclaredField("url").set(localObject2, paramString2);
        ((Class)localObject1).getDeclaredMethod("sendReq", new Class[] { localClass }).invoke(paramString1, new Object[] { localObject2 });
        return true;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append(" exception = ");
        paramString2.append(paramString1.toString());
        APLog.d("toSignAutoPayV1", paramString2.toString());
        paramString1.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  private boolean d()
  {
    Object localObject = "";
    try
    {
      String str = this.g.getPackageManager().getPackageInfo("com.tencent.mm", 64).versionName;
      localObject = str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.mm = ");
    localStringBuilder.append((String)localObject);
    APLog.d("checkWechatVersion", localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Toast.makeText(this.g, "抱歉，您未安装微信客户端", 0).show();
      return false;
    }
    if (((String)localObject).compareTo("6.2") >= 0) {
      return true;
    }
    Toast.makeText(this.g, "当前微信版本不支持签约，请更新版本", 0).show();
    return false;
  }
  
  /* Error */
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 68	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 421
    //   14: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 5
    //   20: iload_1
    //   21: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 5
    //   27: ldc_w 426
    //   30: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 5
    //   36: aload_2
    //   37: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: ldc_w 428
    //   46: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: aload_3
    //   53: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 5
    //   59: ldc_w 430
    //   62: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 5
    //   68: aload 4
    //   70: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc_w 432
    //   77: aload 5
    //   79: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 91	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_2
    //   86: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +585 -> 674
    //   92: aload_3
    //   93: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: ifeq +4 -> 100
    //   99: return
    //   100: ldc_w 434
    //   103: invokestatic 247	com/pay/tool/APTools:n	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 253	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   109: invokevirtual 437	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   112: astore 7
    //   114: aconst_null
    //   115: astore 6
    //   117: aload 7
    //   119: invokevirtual 324	java/lang/Object:getClass	()Ljava/lang/Class;
    //   122: ldc_w 439
    //   125: invokevirtual 330	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   128: astore 5
    //   130: goto +13 -> 143
    //   133: astore 5
    //   135: aload 5
    //   137: invokevirtual 440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   140: aconst_null
    //   141: astore 5
    //   143: aload 5
    //   145: aload 7
    //   147: aload_3
    //   148: invokevirtual 336	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   151: ldc_w 442
    //   154: invokestatic 247	com/pay/tool/APTools:n	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 253	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   160: invokevirtual 437	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   163: astore 5
    //   165: aload 5
    //   167: invokevirtual 324	java/lang/Object:getClass	()Ljava/lang/Class;
    //   170: ldc_w 444
    //   173: invokevirtual 330	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   176: astore_3
    //   177: goto +10 -> 187
    //   180: astore_3
    //   181: aload_3
    //   182: invokevirtual 440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_3
    //   188: aload 5
    //   190: aload 7
    //   192: invokevirtual 336	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   195: aload 5
    //   197: invokevirtual 324	java/lang/Object:getClass	()Ljava/lang/Class;
    //   200: ldc_w 446
    //   203: invokevirtual 330	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   206: astore_3
    //   207: goto +10 -> 217
    //   210: astore_3
    //   211: aload_3
    //   212: invokevirtual 440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   215: aconst_null
    //   216: astore_3
    //   217: aload_3
    //   218: aload 5
    //   220: aload_2
    //   221: invokevirtual 336	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   224: aload 5
    //   226: invokevirtual 324	java/lang/Object:getClass	()Ljava/lang/Class;
    //   229: ldc_w 448
    //   232: invokevirtual 330	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   235: astore_2
    //   236: goto +10 -> 246
    //   239: astore_2
    //   240: aload_2
    //   241: invokevirtual 440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: aload 5
    //   249: aload 4
    //   251: invokevirtual 336	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   254: ldc_w 450
    //   257: invokestatic 247	com/pay/tool/APTools:n	(Ljava/lang/String;)Ljava/lang/String;
    //   260: invokestatic 253	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   263: astore 7
    //   265: aload 7
    //   267: invokevirtual 437	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   270: astore 4
    //   272: aload 4
    //   274: invokevirtual 324	java/lang/Object:getClass	()Ljava/lang/Class;
    //   277: ldc_w 452
    //   280: invokevirtual 455	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   283: astore_2
    //   284: goto +10 -> 294
    //   287: astore_2
    //   288: aload_2
    //   289: invokevirtual 440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   292: aconst_null
    //   293: astore_2
    //   294: aload_2
    //   295: aload 4
    //   297: invokestatic 121	midas/x/fp:a	()Lmidas/x/fp;
    //   300: invokevirtual 457	midas/x/fp:i	()Ljava/lang/String;
    //   303: invokevirtual 336	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   306: aload 4
    //   308: invokevirtual 324	java/lang/Object:getClass	()Ljava/lang/Class;
    //   311: ldc_w 459
    //   314: invokevirtual 330	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   317: astore_2
    //   318: goto +10 -> 328
    //   321: astore_2
    //   322: aload_2
    //   323: invokevirtual 440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   326: aconst_null
    //   327: astore_2
    //   328: aload_2
    //   329: aload 4
    //   331: aload 5
    //   333: invokevirtual 336	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   336: aload 7
    //   338: ldc_w 461
    //   341: invokevirtual 455	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   344: astore_2
    //   345: aload 7
    //   347: ldc_w 463
    //   350: invokevirtual 455	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   353: astore_3
    //   354: goto +26 -> 380
    //   357: astore_3
    //   358: goto +6 -> 364
    //   361: astore_3
    //   362: aconst_null
    //   363: astore_2
    //   364: aload_3
    //   365: invokevirtual 440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   368: ldc_w 465
    //   371: aload_3
    //   372: invokevirtual 466	java/lang/NoSuchFieldException:toString	()Ljava/lang/String;
    //   375: invokestatic 468	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: aconst_null
    //   379: astore_3
    //   380: aload_2
    //   381: aload 7
    //   383: invokevirtual 472	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   386: invokevirtual 473	java/lang/Object:toString	()Ljava/lang/String;
    //   389: astore_2
    //   390: aload_3
    //   391: aload 7
    //   393: invokevirtual 472	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   396: invokevirtual 473	java/lang/Object:toString	()Ljava/lang/String;
    //   399: astore_3
    //   400: iload_1
    //   401: ifne +6 -> 407
    //   404: goto +13 -> 417
    //   407: iload_1
    //   408: iconst_1
    //   409: if_icmpne +8 -> 417
    //   412: aload_3
    //   413: astore_2
    //   414: goto +3 -> 417
    //   417: aload_2
    //   418: invokestatic 476	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   421: istore_1
    //   422: goto +16 -> 438
    //   425: astore_2
    //   426: ldc_w 478
    //   429: aload_2
    //   430: invokevirtual 107	java/lang/Exception:toString	()Ljava/lang/String;
    //   433: invokestatic 110	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: iconst_0
    //   437: istore_1
    //   438: aload 4
    //   440: invokevirtual 324	java/lang/Object:getClass	()Ljava/lang/Class;
    //   443: ldc_w 480
    //   446: invokevirtual 330	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   449: astore_2
    //   450: goto +10 -> 460
    //   453: astore_2
    //   454: aload_2
    //   455: invokevirtual 440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   458: aconst_null
    //   459: astore_2
    //   460: aload_2
    //   461: aload 4
    //   463: iload_1
    //   464: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: invokevirtual 336	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   470: ldc 255
    //   472: invokestatic 247	com/pay/tool/APTools:n	(Ljava/lang/String;)Ljava/lang/String;
    //   475: invokestatic 253	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   478: astore 7
    //   480: ldc 242
    //   482: invokestatic 247	com/pay/tool/APTools:n	(Ljava/lang/String;)Ljava/lang/String;
    //   485: invokestatic 253	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   488: astore 5
    //   490: aload 5
    //   492: invokevirtual 484	java/lang/Class:getInterfaces	()[Ljava/lang/Class;
    //   495: astore_3
    //   496: aload 7
    //   498: ldc_w 274
    //   501: iconst_2
    //   502: anewarray 249	java/lang/Class
    //   505: dup
    //   506: iconst_0
    //   507: ldc_w 276
    //   510: aastore
    //   511: dup
    //   512: iconst_1
    //   513: ldc 170
    //   515: aastore
    //   516: invokevirtual 286	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   519: astore_2
    //   520: goto +11 -> 531
    //   523: astore_2
    //   524: aload_2
    //   525: invokevirtual 485	java/lang/NoSuchMethodException:printStackTrace	()V
    //   528: aload 6
    //   530: astore_2
    //   531: aload_2
    //   532: aload 7
    //   534: iconst_2
    //   535: anewarray 4	java/lang/Object
    //   538: dup
    //   539: iconst_0
    //   540: aload_0
    //   541: getfield 63	midas/x/fg:g	Landroid/content/Context;
    //   544: invokevirtual 489	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: invokestatic 121	midas/x/fp:a	()Lmidas/x/fp;
    //   553: invokevirtual 492	midas/x/fp:z	()Ljava/lang/String;
    //   556: aastore
    //   557: invokevirtual 295	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   560: astore_2
    //   561: goto +10 -> 571
    //   564: astore_2
    //   565: aload_2
    //   566: invokevirtual 493	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   569: aload_3
    //   570: astore_2
    //   571: aload 5
    //   573: ldc_w 345
    //   576: iconst_1
    //   577: anewarray 249	java/lang/Class
    //   580: dup
    //   581: iconst_0
    //   582: ldc_w 301
    //   585: invokestatic 247	com/pay/tool/APTools:n	(Ljava/lang/String;)Ljava/lang/String;
    //   588: invokestatic 253	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   591: aastore
    //   592: invokevirtual 286	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   595: astore_3
    //   596: aload_3
    //   597: aload_2
    //   598: iconst_1
    //   599: anewarray 4	java/lang/Object
    //   602: dup
    //   603: iconst_0
    //   604: aload 4
    //   606: aastore
    //   607: invokevirtual 295	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   610: pop
    //   611: return
    //   612: astore_2
    //   613: ldc_w 495
    //   616: aload_2
    //   617: invokevirtual 496	java/lang/reflect/InvocationTargetException:toString	()Ljava/lang/String;
    //   620: invokestatic 468	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload_2
    //   624: invokevirtual 493	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   627: return
    //   628: astore_2
    //   629: aload_2
    //   630: invokevirtual 485	java/lang/NoSuchMethodException:printStackTrace	()V
    //   633: return
    //   634: astore_2
    //   635: aload_2
    //   636: invokevirtual 497	java/lang/IllegalAccessException:printStackTrace	()V
    //   639: return
    //   640: astore_2
    //   641: aload_2
    //   642: invokevirtual 498	java/lang/InstantiationException:printStackTrace	()V
    //   645: return
    //   646: astore_2
    //   647: aload_2
    //   648: invokevirtual 499	java/lang/IllegalArgumentException:printStackTrace	()V
    //   651: return
    //   652: astore_2
    //   653: aload_2
    //   654: invokevirtual 500	java/lang/SecurityException:printStackTrace	()V
    //   657: return
    //   658: astore_2
    //   659: ldc_w 502
    //   662: aload_2
    //   663: invokevirtual 503	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   666: invokestatic 91	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: aload_2
    //   670: invokevirtual 504	java/lang/ClassNotFoundException:printStackTrace	()V
    //   673: return
    //   674: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	fg
    //   0	675	1	paramInt	int
    //   0	675	2	paramString1	String
    //   0	675	3	paramString2	String
    //   0	675	4	paramString3	String
    //   7	122	5	localObject1	Object
    //   133	3	5	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   141	431	5	localObject2	Object
    //   115	414	6	localObject3	Object
    //   112	421	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   117	130	133	java/lang/NoSuchFieldException
    //   165	177	180	java/lang/NoSuchFieldException
    //   195	207	210	java/lang/NoSuchFieldException
    //   224	236	239	java/lang/NoSuchFieldException
    //   272	284	287	java/lang/NoSuchFieldException
    //   306	318	321	java/lang/NoSuchFieldException
    //   345	354	357	java/lang/NoSuchFieldException
    //   336	345	361	java/lang/NoSuchFieldException
    //   417	422	425	java/lang/Exception
    //   438	450	453	java/lang/NoSuchFieldException
    //   496	520	523	java/lang/NoSuchMethodException
    //   531	561	564	java/lang/reflect/InvocationTargetException
    //   596	611	612	java/lang/reflect/InvocationTargetException
    //   571	596	628	java/lang/NoSuchMethodException
    //   596	611	628	java/lang/NoSuchMethodException
    //   613	627	628	java/lang/NoSuchMethodException
    //   100	114	634	java/lang/IllegalAccessException
    //   117	130	634	java/lang/IllegalAccessException
    //   135	140	634	java/lang/IllegalAccessException
    //   143	165	634	java/lang/IllegalAccessException
    //   165	177	634	java/lang/IllegalAccessException
    //   181	185	634	java/lang/IllegalAccessException
    //   187	195	634	java/lang/IllegalAccessException
    //   195	207	634	java/lang/IllegalAccessException
    //   211	215	634	java/lang/IllegalAccessException
    //   217	224	634	java/lang/IllegalAccessException
    //   224	236	634	java/lang/IllegalAccessException
    //   240	244	634	java/lang/IllegalAccessException
    //   246	272	634	java/lang/IllegalAccessException
    //   272	284	634	java/lang/IllegalAccessException
    //   288	292	634	java/lang/IllegalAccessException
    //   294	306	634	java/lang/IllegalAccessException
    //   306	318	634	java/lang/IllegalAccessException
    //   322	326	634	java/lang/IllegalAccessException
    //   328	336	634	java/lang/IllegalAccessException
    //   336	345	634	java/lang/IllegalAccessException
    //   345	354	634	java/lang/IllegalAccessException
    //   364	378	634	java/lang/IllegalAccessException
    //   380	400	634	java/lang/IllegalAccessException
    //   417	422	634	java/lang/IllegalAccessException
    //   426	436	634	java/lang/IllegalAccessException
    //   438	450	634	java/lang/IllegalAccessException
    //   454	458	634	java/lang/IllegalAccessException
    //   460	496	634	java/lang/IllegalAccessException
    //   496	520	634	java/lang/IllegalAccessException
    //   524	528	634	java/lang/IllegalAccessException
    //   531	561	634	java/lang/IllegalAccessException
    //   565	569	634	java/lang/IllegalAccessException
    //   571	596	634	java/lang/IllegalAccessException
    //   596	611	634	java/lang/IllegalAccessException
    //   613	627	634	java/lang/IllegalAccessException
    //   629	633	634	java/lang/IllegalAccessException
    //   100	114	640	java/lang/InstantiationException
    //   117	130	640	java/lang/InstantiationException
    //   135	140	640	java/lang/InstantiationException
    //   143	165	640	java/lang/InstantiationException
    //   165	177	640	java/lang/InstantiationException
    //   181	185	640	java/lang/InstantiationException
    //   187	195	640	java/lang/InstantiationException
    //   195	207	640	java/lang/InstantiationException
    //   211	215	640	java/lang/InstantiationException
    //   217	224	640	java/lang/InstantiationException
    //   224	236	640	java/lang/InstantiationException
    //   240	244	640	java/lang/InstantiationException
    //   246	272	640	java/lang/InstantiationException
    //   272	284	640	java/lang/InstantiationException
    //   288	292	640	java/lang/InstantiationException
    //   294	306	640	java/lang/InstantiationException
    //   306	318	640	java/lang/InstantiationException
    //   322	326	640	java/lang/InstantiationException
    //   328	336	640	java/lang/InstantiationException
    //   336	345	640	java/lang/InstantiationException
    //   345	354	640	java/lang/InstantiationException
    //   364	378	640	java/lang/InstantiationException
    //   380	400	640	java/lang/InstantiationException
    //   417	422	640	java/lang/InstantiationException
    //   426	436	640	java/lang/InstantiationException
    //   438	450	640	java/lang/InstantiationException
    //   454	458	640	java/lang/InstantiationException
    //   460	496	640	java/lang/InstantiationException
    //   496	520	640	java/lang/InstantiationException
    //   524	528	640	java/lang/InstantiationException
    //   531	561	640	java/lang/InstantiationException
    //   565	569	640	java/lang/InstantiationException
    //   571	596	640	java/lang/InstantiationException
    //   596	611	640	java/lang/InstantiationException
    //   613	627	640	java/lang/InstantiationException
    //   629	633	640	java/lang/InstantiationException
    //   100	114	646	java/lang/IllegalArgumentException
    //   117	130	646	java/lang/IllegalArgumentException
    //   135	140	646	java/lang/IllegalArgumentException
    //   143	165	646	java/lang/IllegalArgumentException
    //   165	177	646	java/lang/IllegalArgumentException
    //   181	185	646	java/lang/IllegalArgumentException
    //   187	195	646	java/lang/IllegalArgumentException
    //   195	207	646	java/lang/IllegalArgumentException
    //   211	215	646	java/lang/IllegalArgumentException
    //   217	224	646	java/lang/IllegalArgumentException
    //   224	236	646	java/lang/IllegalArgumentException
    //   240	244	646	java/lang/IllegalArgumentException
    //   246	272	646	java/lang/IllegalArgumentException
    //   272	284	646	java/lang/IllegalArgumentException
    //   288	292	646	java/lang/IllegalArgumentException
    //   294	306	646	java/lang/IllegalArgumentException
    //   306	318	646	java/lang/IllegalArgumentException
    //   322	326	646	java/lang/IllegalArgumentException
    //   328	336	646	java/lang/IllegalArgumentException
    //   336	345	646	java/lang/IllegalArgumentException
    //   345	354	646	java/lang/IllegalArgumentException
    //   364	378	646	java/lang/IllegalArgumentException
    //   380	400	646	java/lang/IllegalArgumentException
    //   417	422	646	java/lang/IllegalArgumentException
    //   426	436	646	java/lang/IllegalArgumentException
    //   438	450	646	java/lang/IllegalArgumentException
    //   454	458	646	java/lang/IllegalArgumentException
    //   460	496	646	java/lang/IllegalArgumentException
    //   496	520	646	java/lang/IllegalArgumentException
    //   524	528	646	java/lang/IllegalArgumentException
    //   531	561	646	java/lang/IllegalArgumentException
    //   565	569	646	java/lang/IllegalArgumentException
    //   571	596	646	java/lang/IllegalArgumentException
    //   596	611	646	java/lang/IllegalArgumentException
    //   613	627	646	java/lang/IllegalArgumentException
    //   629	633	646	java/lang/IllegalArgumentException
    //   100	114	652	java/lang/SecurityException
    //   117	130	652	java/lang/SecurityException
    //   135	140	652	java/lang/SecurityException
    //   143	165	652	java/lang/SecurityException
    //   165	177	652	java/lang/SecurityException
    //   181	185	652	java/lang/SecurityException
    //   187	195	652	java/lang/SecurityException
    //   195	207	652	java/lang/SecurityException
    //   211	215	652	java/lang/SecurityException
    //   217	224	652	java/lang/SecurityException
    //   224	236	652	java/lang/SecurityException
    //   240	244	652	java/lang/SecurityException
    //   246	272	652	java/lang/SecurityException
    //   272	284	652	java/lang/SecurityException
    //   288	292	652	java/lang/SecurityException
    //   294	306	652	java/lang/SecurityException
    //   306	318	652	java/lang/SecurityException
    //   322	326	652	java/lang/SecurityException
    //   328	336	652	java/lang/SecurityException
    //   336	345	652	java/lang/SecurityException
    //   345	354	652	java/lang/SecurityException
    //   364	378	652	java/lang/SecurityException
    //   380	400	652	java/lang/SecurityException
    //   417	422	652	java/lang/SecurityException
    //   426	436	652	java/lang/SecurityException
    //   438	450	652	java/lang/SecurityException
    //   454	458	652	java/lang/SecurityException
    //   460	496	652	java/lang/SecurityException
    //   496	520	652	java/lang/SecurityException
    //   524	528	652	java/lang/SecurityException
    //   531	561	652	java/lang/SecurityException
    //   565	569	652	java/lang/SecurityException
    //   571	596	652	java/lang/SecurityException
    //   596	611	652	java/lang/SecurityException
    //   613	627	652	java/lang/SecurityException
    //   629	633	652	java/lang/SecurityException
    //   100	114	658	java/lang/ClassNotFoundException
    //   117	130	658	java/lang/ClassNotFoundException
    //   135	140	658	java/lang/ClassNotFoundException
    //   143	165	658	java/lang/ClassNotFoundException
    //   165	177	658	java/lang/ClassNotFoundException
    //   181	185	658	java/lang/ClassNotFoundException
    //   187	195	658	java/lang/ClassNotFoundException
    //   195	207	658	java/lang/ClassNotFoundException
    //   211	215	658	java/lang/ClassNotFoundException
    //   217	224	658	java/lang/ClassNotFoundException
    //   224	236	658	java/lang/ClassNotFoundException
    //   240	244	658	java/lang/ClassNotFoundException
    //   246	272	658	java/lang/ClassNotFoundException
    //   272	284	658	java/lang/ClassNotFoundException
    //   288	292	658	java/lang/ClassNotFoundException
    //   294	306	658	java/lang/ClassNotFoundException
    //   306	318	658	java/lang/ClassNotFoundException
    //   322	326	658	java/lang/ClassNotFoundException
    //   328	336	658	java/lang/ClassNotFoundException
    //   336	345	658	java/lang/ClassNotFoundException
    //   345	354	658	java/lang/ClassNotFoundException
    //   364	378	658	java/lang/ClassNotFoundException
    //   380	400	658	java/lang/ClassNotFoundException
    //   417	422	658	java/lang/ClassNotFoundException
    //   426	436	658	java/lang/ClassNotFoundException
    //   438	450	658	java/lang/ClassNotFoundException
    //   454	458	658	java/lang/ClassNotFoundException
    //   460	496	658	java/lang/ClassNotFoundException
    //   496	520	658	java/lang/ClassNotFoundException
    //   524	528	658	java/lang/ClassNotFoundException
    //   531	561	658	java/lang/ClassNotFoundException
    //   565	569	658	java/lang/ClassNotFoundException
    //   571	596	658	java/lang/ClassNotFoundException
    //   596	611	658	java/lang/ClassNotFoundException
    //   613	627	658	java/lang/ClassNotFoundException
    //   629	633	658	java/lang/ClassNotFoundException
  }
  
  public void a(Context paramContext, final MidasActivityAbility paramMidasActivityAbility, Bundle paramBundle)
  {
    paramContext = paramBundle.getString("orderId");
    String str1 = paramBundle.getString("shareUrl");
    String str2 = paramBundle.getString("wxMiniUrl");
    String str3 = paramBundle.getString("wxMiniPath");
    paramBundle = paramBundle.getString("wxMiniOriId");
    this.k = new ResultReceiver(new Handler())
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt == 0)
        {
          MidasAbilityResponse.onSuccess(paramMidasActivityAbility, paramAnonymousInt, paramAnonymousBundle);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          MidasAbilityResponse.onFailureLIB(paramMidasActivityAbility, paramAnonymousInt, "", paramAnonymousBundle);
          return;
        }
        if (paramAnonymousInt == -2)
        {
          MidasAbilityResponse.onCancel(paramMidasActivityAbility, paramAnonymousInt, paramAnonymousBundle);
          return;
        }
        MidasAbilityResponse.onFailureLIB(paramMidasActivityAbility, paramAnonymousInt, "", paramAnonymousBundle);
      }
    };
    if ((paramMidasActivityAbility.shareInfo instanceof MidasActivityAbility.WXWebShare))
    {
      this.i.a(paramMidasActivityAbility, (MidasActivityAbility.WXWebShare)paramMidasActivityAbility.shareInfo, paramContext, str1);
      this.i.a(this.e);
      return;
    }
    if ((paramMidasActivityAbility.shareInfo instanceof MidasActivityAbility.WXMiniProgramShare))
    {
      this.i.a(paramMidasActivityAbility, (MidasActivityAbility.WXMiniProgramShare)paramMidasActivityAbility.shareInfo, paramContext, paramBundle, str3, str2);
      this.i.a(this.e);
      return;
    }
    APLog.w("com.pay.buyManager.APWechatPaySDK", "toShareDistribute() unknown shareInfo");
  }
  
  public void a(String paramString1, String paramString2)
  {
    APUICommonMethod.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cardId=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(";wxsign=");
    localStringBuilder.append(paramString2);
    APLog.i("微信支付领取话费券", localStringBuilder.toString());
    try
    {
      boolean bool = this.i.a();
      APLog.i("com.pay.buyManager.APWechatPaySDK", "toWeChat public APWechatPaySDK");
      if (!bool)
      {
        APUICommonMethod.a(this.g, "抱歉，你未安装微信客户端");
        if (this.k != null) {
          this.k.send(-10, null);
        }
        return;
      }
      try
      {
        this.i.a(paramString1, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("反射插卡券异常,errorMsg:");
        paramString2.append(paramString1.getMessage());
        APLog.i("com.pay.buyManager.APWechatPaySDK", paramString2.toString());
        APUICommonMethod.b();
        fm.a(ed.b().n().e.a(), 0, 0);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append(" toWeChat isInstall e:");
      paramString2.append(paramString1.toString());
      APLog.w("com.pay.buyManager.APWechatPaySDK", paramString2.toString());
      APUICommonMethod.a(this.g, "抱歉，你未安装微信客户端");
      if (this.k != null) {
        this.k.send(-10, null);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, ResultReceiver paramResultReceiver)
  {
    fp.a().x(paramString1);
    this.k = paramResultReceiver;
    try
    {
      boolean bool = this.i.a();
      APLog.i("APWechatPaySDK", "toWeChat public APWechatPaySDK");
      if (!bool)
      {
        APUICommonMethod.a(this.g, "抱歉，你未安装微信客户端");
        if (paramResultReceiver != null) {
          paramResultReceiver.send(-10, null);
        }
        return;
      }
    }
    catch (Exception paramResultReceiver)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" toWeChat isInstall e:");
      localStringBuilder.append(paramResultReceiver.toString());
      APLog.w("APWechatPaySDK", localStringBuilder.toString());
      paramResultReceiver.printStackTrace();
      this.h = new Bundle();
      this.h.putString("wxAppId", paramString1);
      this.h.putString("partnerId", paramString2);
      this.h.putString("prepayId", paramString3);
      this.h.putString("nonceStr", paramString4);
      this.h.putString("timeStamp", paramString5);
      this.h.putString("package", paramString6);
      this.h.putString("sign", paramString7);
      APLog.i("APWechatPaySDK", " toWeChat");
      try
      {
        this.i.a(this.h);
        this.i.a(this.e);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append(" toWeChat addObserver e:");
        paramString2.append(paramString1.toString());
        APLog.w("APWechatPaySDK", paramString2.toString());
      }
      APUICommonMethod.a("wechat");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    if (c.equals(paramString11))
    {
      this.j = 2;
    }
    else
    {
      if (b.equals(paramString11))
      {
        this.j = 1;
        a(paramString1, paramString8, paramString10, paramString9);
        APUICommonMethod.b();
        return;
      }
      if (d.equals(paramString11))
      {
        this.j = 3;
        a(paramString1, paramString8, paramString10, paramString9);
        return;
      }
      this.j = 0;
    }
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, new ResultReceiver(new Handler())
    {
      public void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        fg.a(fg.this, paramAnonymousInt, paramAnonymousBundle);
        paramAnonymousBundle = new StringBuilder();
        paramAnonymousBundle.append("wxpayCallbackReceiver resultCode = ");
        paramAnonymousBundle.append(paramAnonymousInt);
        APLog.i("APWechatChannel", paramAnonymousBundle.toString());
      }
    });
  }
  
  public boolean a(Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Object localObject1 = paramBundle.getString("wxAppId");
    Object localObject2 = paramBundle.getString("wxMiniProgramId");
    Object localObject3 = paramBundle.getString("wxMiniProgramPath");
    int m = paramBundle.getInt("wxMiniProgramType");
    paramBundle = (Bundle)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramBundle = "";
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = "";
    }
    localObject3 = new Bundle();
    if (!d())
    {
      ((Bundle)localObject3).putString("resultMsg", "未安装微信客户端");
      paramResultReceiver.send(-1, (Bundle)localObject3);
      return false;
    }
    if ((!TextUtils.isEmpty(paramBundle)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (!this.i.b())
      {
        ((Bundle)localObject3).putString("resultMsg", "wechat version is not support wechat_miniprogram");
        paramResultReceiver.send(-1, (Bundle)localObject3);
        APLog.w("com.pay.buyManager.APWechatPaySDK", "wechat sdk not support WXLaunchMiniProgram()");
        return false;
      }
      try
      {
        this.i.a((String)localObject1, (String)localObject2, m);
        this.i.a(this.e);
      }
      catch (Exception paramBundle)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" toWeChat addObserver e:");
        ((StringBuilder)localObject1).append(paramBundle.toString());
        APLog.w("APWechatPaySDK", ((StringBuilder)localObject1).toString());
        paramBundle.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("toWeChat addObserver e:");
        ((StringBuilder)localObject1).append(paramBundle.toString());
        ((Bundle)localObject3).putString("resultMsg", ((StringBuilder)localObject1).toString());
        paramResultReceiver.send(-1, (Bundle)localObject3);
      }
      return true;
    }
    ((Bundle)localObject3).putString("resultMsg", "wxAppId or wxMiniProgramId is empty");
    paramResultReceiver.send(-1, (Bundle)localObject3);
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("｜");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    APLog.i("toSignAutoPay　wxAppId，url", localStringBuilder.toString());
    if ("v2".equals(paramString2.toLowerCase())) {
      return b(paramString1, paramString3);
    }
    return c(paramString1, paramString4);
  }
  
  public void b()
  {
    APLog.d("com.pay.buyManager.APWechatPaySDK", "get bill info to sign");
    bs.a().d(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        paramAnonymousjw = (ca)paramAnonymousjw;
        if (paramAnonymousjw.R() == 0)
        {
          String str1 = paramAnonymousjw.h();
          String str2 = paramAnonymousjw.f();
          String str3 = paramAnonymousjw.g();
          boolean bool = fg.this.a(str1, fp.a().M(), str3, str2);
          APUICommonMethod.b();
          if (bool)
          {
            fm.a(8, -1, -1);
            return;
          }
          fm.a(3, "launch wechat error", paramAnonymousjw.U());
          return;
        }
        APUICommonMethod.b();
        fm.a(3, "sign getcardbillinfo onFinish err", paramAnonymousjw.U());
      }
      
      public void b(jw paramAnonymousjw)
      {
        APUICommonMethod.b();
        fm.a(3, "sign getcardbillinfo onError");
      }
      
      public void c(jw paramAnonymousjw)
      {
        APUICommonMethod.b();
        fm.a(3, "sign getcardbillinfo stop");
      }
    });
  }
  
  public void c()
  {
    bs.a().e(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        
        if (paramAnonymousjw.R() == 0)
        {
          fm.a(8, -1, -1);
          return;
        }
        fm.a(3, "unsign getcardbillinfo onFinish err", paramAnonymousjw.U());
      }
      
      public void b(jw paramAnonymousjw)
      {
        APUICommonMethod.b();
        fm.a(3, "unsign getcardbillinfo onError");
      }
      
      public void c(jw paramAnonymousjw)
      {
        APUICommonMethod.b();
        fm.a(3, "unsign getcardbillinfo stop");
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fg
 * JD-Core Version:    0.7.0.1
 */