package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebView;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;

public class m8
  extends k8
{
  public static final long serialVersionUID = 1L;
  public Activity e = null;
  public e8 f = null;
  public ProgressDialog g = null;
  public String h = "";
  public int i = 0;
  
  public m8()
  {
    c();
  }
  
  public void a(int paramInt, String paramString)
  {
    APUICommonMethod.a(this.e, "Error: webReceivedError");
    paramString = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(y7.b0);
    localStringBuilder.append(this.h);
    paramString.insertData(localStringBuilder.toString(), p4.p().e().b.saveType, "", "", "error=webReceivedError");
    a(this.e);
  }
  
  public void a(Activity paramActivity, e8 parame8, Bundle paramBundle)
  {
    super.a(paramActivity, parame8, paramBundle);
    if (paramBundle != null)
    {
      paramBundle.getString("pageName");
      paramBundle.getString("url");
      this.h = paramBundle.getString("subChannelId");
      this.i = paramBundle.getInt("webSolutionType");
    }
    this.e = paramActivity;
    this.f = parame8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    Object localObject = (ViewGroup.MarginLayoutParams)this.f.e().getLayoutParams();
    int j = p4.p().e().b.saveType;
    if ((j != 4) && (j != 5)) {
      ((ViewGroup.MarginLayoutParams)localObject).height = APUICommonMethod.a(this.e, 400.0F);
    } else {
      ((ViewGroup.MarginLayoutParams)localObject).height = APUICommonMethod.a(this.e, 470.0F);
    }
    this.f.e().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.g = paramProgressDialog;
    paramProgressDialog = this.g;
    if (paramProgressDialog != null) {
      paramProgressDialog.show();
    }
    if (this.f != null)
    {
      paramProgressDialog = f();
      if (TextUtils.isEmpty(paramProgressDialog))
      {
        paramProgressDialog = this.e;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("暂不支持话费支付");
        ((StringBuilder)localObject).append(x1.a(24001));
        APUICommonMethod.a(paramProgressDialog, ((StringBuilder)localObject).toString());
        paramProgressDialog = APDataReportManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(y7.b0);
        ((StringBuilder)localObject).append(this.h);
        paramProgressDialog.insertData(((StringBuilder)localObject).toString(), p4.p().e().b.saveType, "", "", "error=url is empty");
        a(this.e);
        return;
      }
      localObject = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(y7.W);
      localStringBuilder.append(this.h);
      ((APDataReportManager)localObject).insertData(localStringBuilder.toString(), p4.p().e().b.saveType);
      this.f.b(paramProgressDialog);
    }
  }
  
  public void a(Context paramContext)
  {
    APLog.d("APWebHFPage", "toCancel()");
    Activity localActivity = (Activity)paramContext;
    localActivity.finish();
    APUICommonMethod.a(localActivity);
    localActivity.overridePendingTransition(z5.a(paramContext, "unipay_anim_in_from_left"), z5.a(paramContext, "unipay_anim_out_to_right"));
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: new 55	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 211
    //   13: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 5
    //   19: aload_1
    //   20: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 180
    //   26: aload 5
    //   28: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 188	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_1
    //   35: ldc 213
    //   37: invokestatic 219	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 5
    //   42: aload 5
    //   44: astore_1
    //   45: goto +10 -> 55
    //   48: astore 5
    //   50: aload 5
    //   52: invokevirtual 224	java/lang/Throwable:printStackTrace	()V
    //   55: new 55	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   62: astore 5
    //   64: aload 5
    //   66: ldc 226
    //   68: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 5
    //   74: aload_1
    //   75: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: ldc 180
    //   81: aload 5
    //   83: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 188	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_1
    //   90: invokestatic 231	com/pay/tool/APTools:o	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_1
    //   94: aload_1
    //   95: ldc 233
    //   97: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   100: ifne +11 -> 111
    //   103: ldc 180
    //   105: ldc 241
    //   107: invokestatic 188	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: return
    //   111: aload_1
    //   112: invokestatic 245	com/pay/tool/APTools:n	(Ljava/lang/String;)Ljava/util/HashMap;
    //   115: astore_1
    //   116: aload_1
    //   117: ldc 247
    //   119: invokevirtual 253	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 235	java/lang/String
    //   125: astore 5
    //   127: aload 5
    //   129: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   132: istore 4
    //   134: iconst_m1
    //   135: istore_3
    //   136: iload 4
    //   138: ifne +12 -> 150
    //   141: aload 5
    //   143: invokestatic 257	midas/x/i:b	(Ljava/lang/String;)I
    //   146: istore_2
    //   147: goto +5 -> 152
    //   150: iconst_m1
    //   151: istore_2
    //   152: aload_1
    //   153: ldc_w 259
    //   156: invokevirtual 253	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   159: checkcast 235	java/lang/String
    //   162: astore_1
    //   163: aload_1
    //   164: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   167: ifne +8 -> 175
    //   170: aload_1
    //   171: invokestatic 257	midas/x/i:b	(Ljava/lang/String;)I
    //   174: istore_3
    //   175: iload_2
    //   176: ifle +6 -> 182
    //   179: goto +5 -> 184
    //   182: iload_3
    //   183: istore_2
    //   184: new 55	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   191: astore_1
    //   192: aload_1
    //   193: ldc_w 261
    //   196: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_1
    //   201: iload_2
    //   202: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: ldc 180
    //   208: aload_1
    //   209: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 188	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: iload_2
    //   216: ifeq +132 -> 348
    //   219: iload_2
    //   220: iconst_2
    //   221: if_icmpeq +65 -> 286
    //   224: invokestatic 53	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   227: astore_1
    //   228: new 55	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   235: astore 5
    //   237: aload 5
    //   239: getstatic 267	midas/x/y7:a0	Ljava/lang/String;
    //   242: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 5
    //   248: aload_0
    //   249: getfield 32	midas/x/m8:h	Ljava/lang/String;
    //   252: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_1
    //   257: aload 5
    //   259: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 75	midas/x/p4:p	()Lmidas/x/p4;
    //   265: invokevirtual 78	midas/x/p4:e	()Lmidas/x/o4;
    //   268: getfield 84	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
    //   271: getfield 89	com/pay/api/request/APBaseRequest:saveType	I
    //   274: invokevirtual 175	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;I)V
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 24	midas/x/m8:e	Landroid/app/Activity;
    //   282: invokevirtual 269	midas/x/m8:b	(Landroid/content/Context;)V
    //   285: return
    //   286: invokestatic 53	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   289: astore_1
    //   290: new 55	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   297: astore 5
    //   299: aload 5
    //   301: getstatic 272	midas/x/y7:X	Ljava/lang/String;
    //   304: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 5
    //   310: aload_0
    //   311: getfield 32	midas/x/m8:h	Ljava/lang/String;
    //   314: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_1
    //   319: aload 5
    //   321: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 75	midas/x/p4:p	()Lmidas/x/p4;
    //   327: invokevirtual 78	midas/x/p4:e	()Lmidas/x/o4;
    //   330: getfield 84	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
    //   333: getfield 89	com/pay/api/request/APBaseRequest:saveType	I
    //   336: invokevirtual 175	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;I)V
    //   339: aload_0
    //   340: aload_0
    //   341: getfield 24	midas/x/m8:e	Landroid/app/Activity;
    //   344: invokevirtual 98	midas/x/m8:a	(Landroid/content/Context;)V
    //   347: return
    //   348: invokestatic 53	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   351: astore_1
    //   352: new 55	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   359: astore 5
    //   361: aload 5
    //   363: getstatic 275	midas/x/y7:Z	Ljava/lang/String;
    //   366: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 5
    //   372: aload_0
    //   373: getfield 32	midas/x/m8:h	Ljava/lang/String;
    //   376: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: aload 5
    //   383: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 75	midas/x/p4:p	()Lmidas/x/p4;
    //   389: invokevirtual 78	midas/x/p4:e	()Lmidas/x/o4;
    //   392: getfield 84	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
    //   395: getfield 89	com/pay/api/request/APBaseRequest:saveType	I
    //   398: invokevirtual 175	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;I)V
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 24	midas/x/m8:e	Landroid/app/Activity;
    //   406: invokevirtual 277	midas/x/m8:c	(Landroid/content/Context;)V
    //   409: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	m8
    //   0	410	1	paramString	String
    //   146	76	2	j	int
    //   135	48	3	k	int
    //   132	5	4	bool	boolean
    //   7	36	5	localObject1	Object
    //   48	3	5	localObject2	Object
    //   62	320	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	48	finally
  }
  
  public void b(Context paramContext)
  {
    APLog.d("APWebHFPage", "toFailure()");
    Activity localActivity = (Activity)paramContext;
    localActivity.finish();
    APUICommonMethod.a(localActivity);
    localActivity.overridePendingTransition(z5.a(paramContext, "unipay_anim_in_from_left"), z5.a(paramContext, "unipay_anim_out_to_right"));
  }
  
  public void c(Context paramContext)
  {
    APLog.d("APWebHFPage", "toSuccess()");
    Activity localActivity = (Activity)paramContext;
    localActivity.finish();
    APUICommonMethod.a(localActivity);
    Intent localIntent = new Intent(paramContext, APPayProgressActivity.class);
    localIntent.putExtra("channel", 9);
    paramContext.startActivity(localIntent);
    localActivity.finish();
  }
  
  public boolean e()
  {
    if ((this.f.e() != null) && (this.f.e().canGoBack()))
    {
      this.f.e().goBack();
    }
    else
    {
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(y7.Y);
      localStringBuilder.append(this.h);
      localAPDataReportManager.insertData(localStringBuilder.toString(), p4.p().e().b.saveType);
      a(this.e);
    }
    return true;
  }
  
  public String f()
  {
    String str = c6.s0().u();
    Object localObject = str;
    if (this.i == 2)
    {
      localObject = new StringBuilder(str);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("redirectURL");
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append("unipay.sdk.android?midasret=0");
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("failRedirectURL");
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append("unipay.sdk.android?midasret=1");
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("cancelRedirectURL");
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append("unipay.sdk.android?midasret=2");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.m8
 * JD-Core Version:    0.7.0.1
 */