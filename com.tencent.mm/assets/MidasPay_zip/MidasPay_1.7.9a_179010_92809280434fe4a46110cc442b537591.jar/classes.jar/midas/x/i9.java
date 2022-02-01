package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.paychannel.mcard.APMcardChannel;
import com.pay.paychannel.qdqb.APQDQBChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i9
  extends j9
  implements View.OnClickListener
{
  public List<q6> c = new ArrayList();
  public TextView d;
  public TextView e;
  public TextView f;
  public o4 g;
  public int h;
  public View i;
  public Context j;
  public LinearLayout k;
  
  /* Error */
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 108	midas/x/j9:a	Lcom/pay/ui/recoChannel/APRecoChannelActivity;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 104	midas/x/i9:j	Landroid/content/Context;
    //   10: aload_0
    //   11: invokestatic 114	midas/x/p4:p	()Lmidas/x/p4;
    //   14: invokevirtual 117	midas/x/p4:e	()Lmidas/x/o4;
    //   17: putfield 96	midas/x/i9:g	Lmidas/x/o4;
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 96	midas/x/i9:g	Lmidas/x/o4;
    //   25: getfield 122	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
    //   28: getfield 127	com/pay/api/request/APBaseRequest:saveType	I
    //   31: putfield 99	midas/x/i9:h	I
    //   34: aload_0
    //   35: getfield 99	midas/x/i9:h	I
    //   38: istore 4
    //   40: iload 4
    //   42: iconst_3
    //   43: if_icmpeq +25 -> 68
    //   46: iload 4
    //   48: iconst_2
    //   49: if_icmpne +6 -> 55
    //   52: goto +16 -> 68
    //   55: aload_0
    //   56: invokestatic 132	midas/x/r6:j	()Lmidas/x/r6;
    //   59: invokevirtual 135	midas/x/r6:b	()Ljava/util/List;
    //   62: putfield 62	midas/x/i9:c	Ljava/util/List;
    //   65: goto +13 -> 78
    //   68: aload_0
    //   69: invokestatic 132	midas/x/r6:j	()Lmidas/x/r6;
    //   72: invokevirtual 137	midas/x/r6:a	()Ljava/util/List;
    //   75: putfield 62	midas/x/i9:c	Ljava/util/List;
    //   78: aload_0
    //   79: aload_2
    //   80: invokestatic 143	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   83: ldc 144
    //   85: aconst_null
    //   86: invokevirtual 148	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   89: putfield 91	midas/x/i9:i	Landroid/view/View;
    //   92: aload_0
    //   93: getfield 96	midas/x/i9:g	Lmidas/x/o4;
    //   96: getfield 151	midas/x/o4:f	Lmidas/x/d5;
    //   99: ldc 153
    //   101: putfield 158	midas/x/d5:e	Ljava/lang/String;
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 91	midas/x/i9:i	Landroid/view/View;
    //   109: invokevirtual 160	midas/x/i9:e	(Landroid/view/View;)V
    //   112: goto +64 -> 176
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 165	java/lang/Throwable:printStackTrace	()V
    //   120: invokestatic 171	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   123: astore_2
    //   124: invokestatic 114	midas/x/p4:p	()Lmidas/x/p4;
    //   127: invokevirtual 117	midas/x/p4:e	()Lmidas/x/o4;
    //   130: getfield 151	midas/x/o4:f	Lmidas/x/d5;
    //   133: getfield 158	midas/x/d5:e	Ljava/lang/String;
    //   136: astore_3
    //   137: new 173	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   144: astore 5
    //   146: aload 5
    //   148: ldc 176
    //   150: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 5
    //   156: aload_1
    //   157: invokestatic 185	com/pay/tool/APTools:d	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   160: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: ldc 187
    //   167: aload_3
    //   168: aload 5
    //   170: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 194	com/pay/data/report/APDataReportManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_0
    //   177: getfield 91	midas/x/i9:i	Landroid/view/View;
    //   180: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	i9
    //   0	181	1	paramAPRecoChannelActivity	APRecoChannelActivity
    //   0	181	2	paramContext	Context
    //   0	181	3	paramBundle	Bundle
    //   38	12	4	m	int
    //   144	25	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   104	112	115	finally
  }
  
  public void a()
  {
    APLog.i("APChannelView", "onresume");
    final String str = p4.p().e().f.e;
    if ((("wechat".equals(str)) || ("qqwallet".equals(str))) && (((!c6.s0().x()) && ("wechat".equals(str))) || ((!c6.s0().w()) && ("qqwallet".equals(str)))))
    {
      if (o.m().g("channellist")) {
        if ((p4.p().e().f != null) && (!TextUtils.isEmpty(c6.s0().g())) && (!TextUtils.isEmpty(p4.p().e().b())))
        {
          e("");
          c6.s0().g(true);
          c6.s0().f(true);
          o.m().b();
          f();
          d(this.i);
        }
        else
        {
          f();
          return;
        }
      }
      if ((p4.p().e().f != null) && (!TextUtils.isEmpty(p4.p().e().f.n)))
      {
        e("");
        z1.d().j(new g(str));
      }
      else
      {
        f();
        return;
      }
    }
    if (g6.k().c())
    {
      e(p4.p().e().f.e);
      g6.k().a(false);
      APRecoChannelActivity.h = false;
    }
    if (o.m().i())
    {
      this.g.f.e = "channellist";
      d(this.i);
    }
    super.a();
  }
  
  public void a(Context paramContext, String paramString1, final String paramString2)
  {
    paramContext = new APAlertDialog.f(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString1);
    paramContext.b("确认支付", new b(paramString2));
    paramContext.a("取消", new c());
    try
    {
      paramContext.b();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final void a(final View paramView)
  {
    final ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.c.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (q6)((Iterator)localObject1).next();
      localArrayList.add(localObject2);
      if ("wechat_quickpass".equals(((q6)localObject2).a)) {
        APDataReportManager.getInstance().insertData("sdk.unionpayshow", this.h);
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject1 = new q6();
      ((q6)localObject1).i = -2;
      localArrayList.add(0, localObject1);
    }
    localObject1 = (ListView)paramView.findViewById(2131099844);
    if (localArrayList.size() > 0)
    {
      localObject2 = new p6(this.j, localArrayList);
      ((BaseAdapter)localObject2).notifyDataSetChanged();
      ((ListView)localObject1).setAdapter((ListAdapter)localObject2);
      ((ListView)localObject1).setOnItemClickListener(new m(localArrayList));
      try
      {
        this.a.getWindow().findViewById(16908290).post(new n(paramView, (p6)localObject2, (ListView)localObject1));
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    int m = this.j.getResources().getConfiguration().orientation;
    Object localObject;
    if (m == 1)
    {
      localObject = (ListView)paramView.findViewById(2131099844);
      paramView = (Button)paramView.findViewById(2131099928);
      if ((paramInt == 0) && (p.o().h()))
      {
        ((ListView)localObject).setVisibility(8);
        paramView.setVisibility(0);
        return;
      }
      ((ListView)localObject).setVisibility(0);
      paramView.setVisibility(8);
      return;
    }
    if (m == 2)
    {
      localObject = (HorizontalScrollView)paramView.findViewById(2131099965);
      paramView = (Button)paramView.findViewById(2131099928);
      if ((paramInt == 0) && (p.o().h()))
      {
        ((HorizontalScrollView)localObject).setVisibility(8);
        paramView.setVisibility(0);
        return;
      }
      ((HorizontalScrollView)localObject).setVisibility(0);
      paramView.setVisibility(8);
    }
  }
  
  public final void a(View paramView, LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout.getChildCount() <= 0)
    {
      APLog.d("APChannelView", "limitMaxHeightWithLand getChildCount() = 0");
      return;
    }
    int m = paramLinearLayout.getMeasuredHeight();
    int n = paramLinearLayout.getChildAt(0).getMeasuredHeight();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("limitMaxHeightWithLand listViewMeasuredHeight=");
    ((StringBuilder)localObject1).append(m);
    APLog.d("APChannelView", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("limitMaxHeightWithLand childMeasuredHeight=");
    ((StringBuilder)localObject1).append(n);
    APLog.d("APChannelView", ((StringBuilder)localObject1).toString());
    if (m < n)
    {
      n = paramLinearLayout.getPaddingLeft();
      int i1 = paramLinearLayout.getPaddingRight();
      int i2 = paramLinearLayout.getPaddingBottom();
      paramLinearLayout.setPadding(n, APUICommonMethod.a(this.j, 2.0F), i1, i2);
      localObject1 = new LinearLayout.LayoutParams(APUICommonMethod.a(this.j, 108.0F), m);
      m = 0;
      while (m < paramLinearLayout.getChildCount())
      {
        Object localObject2 = paramLinearLayout.getChildAt(m);
        ((LinearLayout)((View)localObject2).findViewById(2131099839)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject2 = (LinearLayout)((View)localObject2).findViewById(2131099840);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((LinearLayout)localObject2).getLayoutParams();
        localMarginLayoutParams.topMargin = 2;
        ((LinearLayout)localObject2).setLayoutParams(localMarginLayoutParams);
        m += 1;
      }
      paramLinearLayout = new StringBuilder();
      paramLinearLayout.append("limitMaxHeightWithLand isHasCoupon=");
      paramLinearLayout.append(o.m().i());
      paramLinearLayout.append(", isHasGoldCoupons=");
      paramLinearLayout.append(p.o().h());
      APLog.d("APChannelView", paramLinearLayout.toString());
      if ((o.m().i()) || (p.o().h()))
      {
        paramLinearLayout = (LinearLayout)paramView.findViewById(2131099935);
        paramLinearLayout.setPadding(paramLinearLayout.getPaddingLeft(), paramLinearLayout.getPaddingTop(), paramLinearLayout.getPaddingRight(), 2);
        paramLinearLayout = (TextView)paramView.findViewById(2131100002);
        localObject1 = (LinearLayout.LayoutParams)paramLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, APUICommonMethod.a(this.j, 2.0F), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramLinearLayout = (TextView)paramView.findViewById(2131100005);
        localObject1 = (LinearLayout.LayoutParams)paramLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, APUICommonMethod.a(this.j, 2.0F), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramLinearLayout = (TextView)paramView.findViewById(2131100000);
        localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin, ((RelativeLayout.LayoutParams)localObject1).rightMargin, 0);
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramLinearLayout = (TextView)paramView.findViewById(2131100007);
        localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, APUICommonMethod.a(this.j, 3.0F), ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView = (TextView)paramView.findViewById(2131100003);
        paramLinearLayout = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        paramLinearLayout.setMargins(paramLinearLayout.leftMargin, paramLinearLayout.topMargin, paramLinearLayout.rightMargin, APUICommonMethod.a(this.j, 3.0F));
        paramView.setLayoutParams(paramLinearLayout);
      }
    }
  }
  
  public final void a(View paramView, p6 paramp6, ListView paramListView)
  {
    int n = this.a.getWindow().findViewById(16908290).getMeasuredHeight();
    int m = n;
    if (n <= 0)
    {
      APLog.e("APChannelView", "limitMaxHeight androidContentHeight <= 0");
      localObject1 = new DisplayMetrics();
      this.a.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      m = ((DisplayMetrics)localObject1).heightPixels;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("limitMaxHeight androidContent=");
    ((StringBuilder)localObject1).append(m);
    APLog.d("APChannelView", ((StringBuilder)localObject1).toString());
    localObject1 = (LinearLayout)paramView.findViewById(2131099846);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("limitMaxHeight outLayoutHeight=");
    ((StringBuilder)localObject2).append(((LinearLayout)localObject1).getMeasuredHeight());
    APLog.d("APChannelView", ((StringBuilder)localObject2).toString());
    localObject2 = (ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).getLayoutParams();
    m = m - ((ViewGroup.MarginLayoutParams)localObject2).topMargin - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("limitMaxHeight contentContainerHeight=");
    ((StringBuilder)localObject2).append(m);
    APLog.d("APChannelView", ((StringBuilder)localObject2).toString());
    paramView = (RelativeLayout)paramView.findViewById(2131099696);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("limitMaxHeight relativeLayout.getMeasuredHeight()=");
    ((StringBuilder)localObject2).append(paramView.getMeasuredHeight());
    APLog.d("APChannelView", ((StringBuilder)localObject2).toString());
    n = ((LinearLayout)localObject1).getMeasuredHeight() - paramView.getMeasuredHeight();
    paramView = new StringBuilder();
    paramView.append("limitMaxHeight otherContentHeight=");
    paramView.append(n);
    APLog.d("APChannelView", paramView.toString());
    int i2 = m - n;
    m = paramp6.getCount();
    int i1 = 0;
    if (m > 0)
    {
      paramView = paramp6.getView(0, null, paramListView);
      paramView.measure(0, 0);
      m = paramView.getMeasuredHeight();
      paramView = new StringBuilder();
      paramView.append("limitMaxHeight emptyItemHeight=");
      paramView.append(m);
      APLog.d("APChannelView", paramView.toString());
    }
    else
    {
      m = 0;
    }
    if (paramp6.getCount() > 1)
    {
      paramView = paramp6.getView(1, null, paramListView);
      paramView.measure(0, 0);
      n = paramView.getMeasuredHeight();
      paramView = new StringBuilder();
      paramView.append("limitMaxHeight normalItemHeight=");
      paramView.append(n);
      APLog.d("APChannelView", paramView.toString());
    }
    else
    {
      n = 0;
    }
    if (paramp6.getCount() > 4)
    {
      paramView = paramp6.getView(4, null, paramListView);
      paramView.measure(0, 0);
      i1 = paramView.getMeasuredHeight();
      paramView = new StringBuilder();
      paramView.append("limitMaxHeight dividerItemHeight=");
      paramView.append(i1);
      APLog.d("APChannelView", paramView.toString());
    }
    float f1 = (i2 - m - i1) / n;
    n = paramp6.getCount();
    m = n;
    if (paramp6.getCount() > 0) {
      m = n - 1;
    }
    n = m;
    if (paramp6.getCount() > 4) {
      n = m - 1;
    }
    if ((n > 0) && (f1 > 4.0F) && (n > f1))
    {
      paramView = paramListView.getLayoutParams();
      paramView.height = i2;
      paramListView.setLayoutParams(paramView);
      APLog.d("APChannelView", "limitMaxHeight done");
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onActivityResult resultCode=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" requestCode=");
    ((StringBuilder)localObject).append(paramInt1);
    APLog.i("APChannelView", ((StringBuilder)localObject).toString());
    if ((paramInt1 == 100002) && (paramInt2 == 10))
    {
      if (paramIntent != null)
      {
        localObject = (i6.a)paramIntent.getSerializableExtra("channel");
        paramIntent = paramIntent.getStringExtra("sig");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult sig.size=");
        localStringBuilder.append(paramIntent.length());
        localStringBuilder.append(" channel=");
        localStringBuilder.append(localObject);
        APLog.i("APViewQDQB", localStringBuilder.toString());
        if (paramIntent.length() > 15) {
          APQDQBChannel.p = paramIntent;
        } else {
          APQDQBChannel.p = "";
        }
        if (localObject == i6.a.a) {
          APQDQBChannel.q = "2";
        } else {
          APQDQBChannel.q = "";
        }
        if (!APQDQBChannel.p.equals(""))
        {
          c();
          return true;
        }
      }
    }
    else
    {
      if (paramInt1 == 1001)
      {
        d(this.i);
        return true;
      }
      if (paramInt1 == 1)
      {
        if (paramInt2 == 101)
        {
          d(this.i);
          return true;
        }
        if ((paramInt2 == 102) || (paramInt2 == 103)) {
          this.a.a(1, 2, null);
        }
      }
    }
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (TextUtils.isEmpty(this.g.f.i)) {
        paramContext = "all";
      } else {
        paramContext = "change";
      }
      APDataReportManager.getInstance().insertData("sdk.channellist.keyback", this.h, null, null, paramContext);
      d();
    }
    return true;
  }
  
  public final void b(final View paramView)
  {
    final LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131099845);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.j);
    Object localObject1;
    if (!TextUtils.isEmpty(this.g.f.i)) {
      localObject1 = new LinearLayout.LayoutParams(APUICommonMethod.a(this.j, 108.0F), APUICommonMethod.a(this.j, 176.0F));
    } else {
      localObject1 = new LinearLayout.LayoutParams(APUICommonMethod.a(this.j, 108.0F), APUICommonMethod.a(this.j, 156.0F));
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((LinearLayout.LayoutParams)localObject1).setMargins(APUICommonMethod.a(this.j, 4.0F), 0, APUICommonMethod.a(this.j, 4.0F), 0);
    }
    int m = 0;
    Object localObject2 = localObject1;
    while (m < this.c.size())
    {
      Object localObject3 = (q6)this.c.get(m);
      if (((q6)localObject3).i >= 0)
      {
        Object localObject4;
        for (;;)
        {
          if ("wechat_quickpass".equals(((q6)localObject3).a)) {
            APDataReportManager.getInstance().insertData("sdk.unionpayshow", this.h);
          }
          localObject4 = (LinearLayout)localLayoutInflater.inflate(2131165201, null);
          localObject1 = (LinearLayout)((LinearLayout)localObject4).findViewById(2131099839);
          ((LinearLayout)localObject1).setLayoutParams(localObject2);
          ((LinearLayout)localObject1).setTag(Integer.valueOf(m));
          ((LinearLayout)localObject1).setOnClickListener(new o());
          Object localObject6 = (ImageView)((LinearLayout)localObject4).findViewById(2131099838);
          TextView localTextView4 = (TextView)((LinearLayout)localObject4).findViewById(2131099841);
          TextView localTextView1 = (TextView)((LinearLayout)localObject4).findViewById(2131099842);
          TextView localTextView3 = (TextView)((LinearLayout)localObject4).findViewById(2131099836);
          TextView localTextView2 = (TextView)((LinearLayout)localObject4).findViewById(2131099835);
          int n = ((q6)localObject3).c;
          String str = ((q6)localObject3).b;
          Object localObject5 = ((q6)localObject3).f;
          localObject1 = ((q6)localObject3).e;
          TextView localTextView5 = (TextView)((LinearLayout)localObject4).findViewById(2131099837);
          int i1;
          if ("hfpay".equals(((q6)localObject3).a))
          {
            if ((this.h == 0) && (!TextUtils.isEmpty(APHFChannel.v)))
            {
              localObject1 = this.g;
              localObject1 = ((x4)((o4)localObject1).c).b(((o4)localObject1).f.f, APHFChannel.v);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("(需支付");
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append("元)");
              localObject1 = localStringBuilder.toString();
            }
            else
            {
              localObject1 = "";
            }
            if (this.h == 4)
            {
              localTextView5.setVisibility(0);
              localTextView5.setText("每次买一个月");
            }
            else
            {
              localTextView5.setVisibility(8);
            }
          }
          else
          {
            i1 = this.g.b.saveType;
            if ((i1 != 4) && (i1 != 5)) {
              localTextView5.setVisibility(8);
            } else if (((z4)this.g.c).n.equals("1"))
            {
              if (!APTools.e(((q6)localObject3).a))
              {
                localTextView5.setText("不支持自动续费");
                localTextView5.setVisibility(0);
                localTextView5.setTextColor(((LinearLayout)localObject4).getResources().getColor(2130903085));
              }
              else
              {
                localTextView5.setVisibility(8);
              }
            }
            else {
              localTextView5.setVisibility(8);
            }
          }
          ((ImageView)localObject6).setBackgroundResource(n);
          localTextView4.setText(str);
          if (!TextUtils.isEmpty((CharSequence)localObject5))
          {
            if ((!((String)localObject5).trim().equals("100")) && (!((String)localObject5).trim().equals("10")))
            {
              localTextView3.setVisibility(0);
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append((String)localObject5);
              ((StringBuilder)localObject6).append("折");
              localTextView3.setText(((StringBuilder)localObject6).toString());
              localObject6 = p4.p().e();
              n = ((o4)localObject6).b.saveType;
              if (((n == 3) || (n == 2)) && ("qqwallet".equals(((q6)localObject3).a)))
              {
                n = APTools.p(((o4)localObject6).c.a());
                try
                {
                  i1 = Integer.valueOf((String)localObject5).intValue();
                  if ((i1 > 0) && (i1 < 100))
                  {
                    localObject5 = new BigDecimal(i1).divide(new BigDecimal(100));
                    localObject5 = new BigDecimal(1).subtract((BigDecimal)localObject5);
                    localObject5 = APTools.b(new BigDecimal(n).multiply((BigDecimal)localObject5).intValue());
                    localTextView3.setVisibility(0);
                    localObject6 = new StringBuilder();
                    ((StringBuilder)localObject6).append("可省");
                    ((StringBuilder)localObject6).append((String)localObject5);
                    ((StringBuilder)localObject6).append("元");
                    localTextView3.setText(((StringBuilder)localObject6).toString());
                  }
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
              }
            }
            else
            {
              localException.setVisibility(8);
            }
          }
          else {
            localException.setVisibility(8);
          }
          if (!TextUtils.isEmpty(((q6)localObject3).g))
          {
            localTextView1.setVisibility(0);
            localTextView1.setText(((q6)localObject3).g);
          }
          else
          {
            localTextView1.setVisibility(8);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"未绑卡".equals(((String)localObject1).trim())))
          {
            localTextView2.setVisibility(0);
            localTextView2.setText((CharSequence)localObject1);
          }
          else
          {
            localTextView2.setVisibility(8);
          }
          localLinearLayout.addView((View)localObject4);
          localObject1 = (TextView)((LinearLayout)localObject4).findViewById(2131099843);
          if ((!((q6)localObject3).a.equals("qdqb")) && (!((q6)localObject3).a.equals("qbqd"))) {
            ((TextView)localObject1).setVisibility(8);
          } else if (a.r().e()) {
            if (p4.p().e().e.e)
            {
              f((View)localObject4);
            }
            else
            {
              if ((p4.p().e().f.j.equals("qdqb")) || (p4.p().e().f.j.equals("qbqd"))) {
                break;
              }
              ((TextView)localObject1).setVisibility(8);
            }
          }
        }
        localObject3 = p4.p().e().f.a;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((String)localObject3).charAt(0));
          ((StringBuilder)localObject4).append("***");
          ((StringBuilder)localObject4).append(((String)localObject3).substring(((String)localObject3).length() - 3, ((String)localObject3).length()));
          localObject3 = ((StringBuilder)localObject4).toString();
          ((TextView)localObject1).setVisibility(0);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("  (");
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append(")");
          ((TextView)localObject1).setText(((StringBuilder)localObject4).toString());
        }
        else
        {
          ((TextView)localObject1).setVisibility(8);
        }
      }
      m += 1;
    }
    try
    {
      localLinearLayout.post(new a(paramView, localLinearLayout));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPay() channelId = ");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelView", ((StringBuilder)localObject).toString());
    if ("hfpay".equals(paramString))
    {
      localObject = (APHFChannel)e5.a("hfpay");
      if (!((APHFChannel)localObject).i())
      {
        APDataReportManager.getInstance().insertData("sdk.hf.nosupport.dialog.show", this.h, null, null, null);
        paramString = ((APHFChannel)localObject).h();
        ((i5)localObject).a(this.j, paramString, false);
        return;
      }
    }
    p4.p().e().f.e = paramString;
    if (TextUtils.isEmpty(this.g.f.i)) {
      localObject = "all";
    } else {
      localObject = "change";
    }
    APDataReportManager.getInstance().insertData("sdk.channellist.click", this.h, p4.p().e().f.k, p4.p().e().f.e, (String)localObject);
    if (!TextUtils.isEmpty(p4.p().e().f.i))
    {
      if ((c6.s0().A()) && (!"cft".equals(paramString)) && (!"bank".equals(paramString))) {
        this.a.a(1, 2, null);
      }
    }
    else if (("wechat".equals(paramString)) && ((this.g.c.e() == 0) || (1 == this.g.c.e()) || (2 == this.g.c.e())))
    {
      this.a.a(1, 2, null);
      return;
    }
    if ((o.m().g(paramString)) && (!o.m().g("channellist")))
    {
      paramString = new Bundle();
      this.a.a(1, 2, paramString);
      return;
    }
    if (("wechat".equals(paramString)) || ("qqwallet".equals(paramString)) || ("hfpay".equals(paramString)) || ("cft".equals(paramString)) || ("bank".equals(paramString)) || ("qdqb".equals(paramString)) || ("qbqd".equals(paramString)) || (d(paramString))) {
      APRecoChannelActivity.h = true;
    }
    c(paramString);
  }
  
  public final void c()
  {
    AP3PointsLoading localAP3PointsLoading = (AP3PointsLoading)this.a.findViewById(2131099699);
    APRecoChannelActivity.h = true;
    e(p4.p().e().f.e);
    e5.h().a(this.j, p4.p().e().f.e, null, new f(), null);
  }
  
  public final void c(View paramView)
  {
    if (!p.o().h()) {
      return;
    }
    if (!p.o().f()) {
      return;
    }
    p.o().a(false);
    Object localObject = this.g;
    localObject = ((o4)localObject).c.a(((o4)localObject).f.f);
    p.o().a(true);
    int m = APTools.p((String)localObject);
    m = p.o().a(m);
    this.k = ((LinearLayout)paramView.findViewById(2131099855));
    this.k.setVisibility(0);
    ((ImageView)paramView.findViewById(2131099854)).setVisibility(0);
    if (m <= 0)
    {
      ((TextView)paramView.findViewById(2131099856)).setVisibility(8);
      ((TextView)paramView.findViewById(2131099857)).setText("选择抵扣券 >");
    }
    else
    {
      ((TextView)paramView.findViewById(2131099856)).setVisibility(0);
      paramView = (TextView)paramView.findViewById(2131099857);
      localObject = o.m().a("channellist");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((m)localObject).b);
      localStringBuilder.append("已减");
      localStringBuilder.append(APTools.a(m, 2));
      localStringBuilder.append("元 >");
      paramView.setText(localStringBuilder.toString());
    }
    this.k.setOnClickListener(new l());
  }
  
  public final void c(final String paramString)
  {
    if ((!"qqcard".equals(paramString)) && (!"hfpay".equals(paramString))) {
      e(paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isFromChannelList", true);
    if ("hfpay".equals(paramString)) {
      localBundle.putString("fromView", "channelList");
    }
    if ("goldcouponsdeduct".equals(paramString)) {
      APRecoChannelActivity.h = true;
    }
    e5.h().a(this.j, paramString, localBundle, new d(paramString), null);
  }
  
  public final void d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("fromBack", true);
    if (TextUtils.isEmpty(this.g.f.i))
    {
      if (c6.s0().Q().equals("AndroidPay"))
      {
        APUICommonMethod.f();
        z5.a(2, "");
        return;
      }
      this.a.finish();
      APUICommonMethod.a(this.a);
      return;
    }
    String str = this.a.d;
    if (("hfpay".equals(str)) && (p.o().h()) && (p.o().f()) && (p.o().a(str)) && (p.o().i()))
    {
      APHFChannel.q = null;
      APRecoChannelActivity.h = true;
      this.a.a(1, 2, localBundle);
      return;
    }
    if ((!"bank".equals(p4.p().e().f.i)) && (!"cft".equals(p4.p().e().f.i)))
    {
      this.a.a(1, 2, localBundle);
      return;
    }
    if (c6.s0().Q().equals("AndroidPay"))
    {
      APUICommonMethod.f();
      z5.a(2, "");
      return;
    }
    this.a.finish();
    APUICommonMethod.a(this.a);
  }
  
  public final void d(View paramView)
  {
    if (o.m().i()) {
      g();
    } else if (p.o().h()) {
      c(paramView);
    }
    String str = this.g.c.a();
    TextView localTextView = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j.getString(2131230879));
    localStringBuilder.append(str);
    localTextView.setText(localStringBuilder.toString());
    if (!APAppDataInterface.singleton().n()) {
      this.e.setVisibility(8);
    }
    a(paramView, APTools.p(str));
  }
  
  public boolean d(String paramString)
  {
    if ("mcard".equals(paramString)) {
      return ((APMcardChannel)e5.a(paramString)).j();
    }
    return false;
  }
  
  public final void e()
  {
    new Handler().postDelayed(new e(), 500L);
  }
  
  public final void e(View paramView)
  {
    APLog.i("APChannelView", "initUI");
    this.d = ((TextView)paramView.findViewById(2131100002));
    this.e = ((TextView)paramView.findViewById(2131100005));
    this.f = ((TextView)paramView.findViewById(2131100000));
    ((Button)paramView.findViewById(2131099928)).setOnClickListener(new h());
    Object localObject = (LinearLayout)paramView.findViewById(2131099847);
    if ((!TextUtils.isEmpty(this.g.f.i)) && (c6.s0().A()))
    {
      ((LinearLayout)localObject).setVisibility(8);
    }
    else
    {
      ((LinearLayout)localObject).setVisibility(0);
      ((TextView)paramView.findViewById(2131099848)).setText("确认支付方式");
      m = this.h;
      if ((m != 0) && (m != 1) && (m != 2) && (m != 3))
      {
        if (m != 4)
        {
          if (m != 5)
          {
            localObject = "";
          }
          else if (g6.k().e() == g6.a.a)
          {
            this.d.setVisibility(8);
            localObject = this.g.c.b;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(" × ");
            ((StringBuilder)localObject).append(this.g.f.f);
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else if (g6.k().e() == g6.a.a)
        {
          this.d.setVisibility(8);
          localObject = this.g.c.b;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.j.getString(2131230829));
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.g.f.f);
          ((StringBuilder)localObject).append(((z4)this.g.c).h());
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.j.getString(2131230829));
        ((StringBuilder)localObject).append(this.g.f.f);
        localObject = ((StringBuilder)localObject).toString();
      }
      this.d.setText(this.g.c.b);
      m = this.h;
      if ((m != 3) && (m != 2))
      {
        if (APUICommonMethod.e())
        {
          localObject = (x4)this.g.c;
          this.e.setText(((x4)localObject).h());
        }
        else
        {
          TextView localTextView = this.e;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(this.g.b.extendInfo.unit);
          localTextView.setText(localStringBuilder.toString());
        }
      }
      else {
        this.e.setText((CharSequence)localObject);
      }
      d(paramView);
    }
    localObject = (ImageButton)paramView.findViewById(2131099832);
    if (TextUtils.isEmpty(this.g.f.i)) {
      ((ImageButton)localObject).setImageResource(2131034192);
    }
    ((ImageButton)localObject).setVisibility(0);
    ((ImageButton)localObject).setOnClickListener(new i());
    int m = this.j.getResources().getConfiguration().orientation;
    if (m == 1)
    {
      a(paramView);
      return;
    }
    if (m == 2) {
      b(paramView);
    }
  }
  
  public final void e(String paramString)
  {
    this.k = ((LinearLayout)this.i.findViewById(2131099855));
    this.k.setEnabled(false);
    Object localObject1 = this.j.getResources().getConfiguration();
    AP3PointsLoading localAP3PointsLoading = (AP3PointsLoading)this.i.findViewById(2131099699);
    Object localObject2;
    if (((Configuration)localObject1).orientation == 1)
    {
      localObject1 = (LinearLayout)this.i.findViewById(2131099806);
      localObject2 = (RelativeLayout.LayoutParams)localAP3PointsLoading.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = ((LinearLayout)localObject1).getMeasuredHeight();
      localAP3PointsLoading.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setVisibility(8);
    }
    else
    {
      localObject1 = (LinearLayout)this.i.findViewById(2131099806);
      localObject2 = (LinearLayout.LayoutParams)localAP3PointsLoading.getLayoutParams();
      int m = ((LinearLayout)localObject1).getMeasuredHeight();
      int n = ((LinearLayout)localObject1).getMeasuredWidth();
      ((LinearLayout.LayoutParams)localObject2).height = m;
      ((LinearLayout.LayoutParams)localObject2).width = n;
      localAP3PointsLoading.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setVisibility(8);
    }
    localAP3PointsLoading.setVisibility(0);
    if ("wechat".equals(paramString)) {
      localAP3PointsLoading.setText("正在进入微信支付");
    } else if ("qqwallet".equals(paramString)) {
      localAP3PointsLoading.setText("正在进入QQ钱包支付");
    } else {
      localAP3PointsLoading.setText("");
    }
    localAP3PointsLoading.c();
    a(true);
  }
  
  public final void f()
  {
    try
    {
      this.k = ((LinearLayout)this.i.findViewById(2131099855));
      this.k.setEnabled(true);
      AP3PointsLoading localAP3PointsLoading = (AP3PointsLoading)this.i.findViewById(2131099699);
      localAP3PointsLoading.d();
      localAP3PointsLoading.setVisibility(8);
      if (this.j.getResources().getConfiguration().orientation == 1) {
        ((LinearLayout)this.i.findViewById(2131099806)).setVisibility(0);
      } else {
        ((LinearLayout)this.i.findViewById(2131099806)).setVisibility(0);
      }
      a(false);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void f(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131099843);
    localTextView.setVisibility(0);
    Object localObject;
    if ((g6.k().c()) && (c6.s0().v()))
    {
      paramView = g6.k().b();
      localObject = "uin";
    }
    else
    {
      paramView = p4.p().e().e.i;
      localObject = p4.p().e().e.j;
    }
    if ((!TextUtils.isEmpty(paramView)) && ("uin".equals(localObject)))
    {
      paramView = paramView.substring(paramView.length() - 3, paramView.length());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(尾号");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(")");
      localTextView.setText(((StringBuilder)localObject).toString());
      localTextView.setVisibility(0);
    }
  }
  
  public final void g()
  {
    if (!o.m().i()) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)this.i.findViewById(2131099855);
    localLinearLayout.setVisibility(0);
    ((TextView)this.i.findViewById(2131099856)).setVisibility(8);
    ((ImageView)this.i.findViewById(2131099854)).setVisibility(8);
    if (o.m().g("channellist"))
    {
      localObject1 = (TextView)this.i.findViewById(2131099857);
      Object localObject2 = o.m().a("channellist");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((m)localObject2).b);
      localStringBuilder.append("已减");
      localStringBuilder.append(((m)localObject2).c);
      localStringBuilder.append("元 >");
      ((TextView)localObject1).setText(localStringBuilder.toString());
      ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      localObject1 = p4.p().e().c.b(p4.p().e().f.f);
      localObject2 = (TextView)this.i.findViewById(2131100003);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.j.getString(2131230879));
      localStringBuilder.append((String)localObject1);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      ((TextView)localObject2).getPaint().setFlags(16);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)this.i.findViewById(2131100007)).setVisibility(4);
      localLinearLayout.setOnClickListener(new j());
      return;
    }
    Object localObject1 = (TextView)this.i.findViewById(2131099857);
    ((TextView)localObject1).setText("选择抵扣券 >");
    ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
    ((TextView)this.i.findViewById(2131100003)).setVisibility(8);
    ((TextView)this.i.findViewById(2131100007)).setVisibility(8);
    localLinearLayout.setOnClickListener(new k());
  }
  
  public void onClick(View paramView) {}
  
  public class a
    implements Runnable
  {
    public a(View paramView, LinearLayout paramLinearLayout) {}
    
    public void run()
    {
      i9.a(i9.this, paramView, localLinearLayout);
    }
  }
  
  public class b
    implements c7
  {
    public b(String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      o.m().b();
      paramAPAlertDialog.f();
      i9.b(i9.this, paramString2);
    }
  }
  
  public class c
    implements c7
  {
    public c() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
    }
  }
  
  public class d
    implements h5
  {
    public d(String paramString) {}
    
    public void a()
    {
      APLog.i("IAPStateCallBack onstop", "onstop");
      APRecoChannelActivity.h = false;
      g6.k().a(false);
      i9.b(i9.this);
    }
    
    public void a(int paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultCode:");
      ((StringBuilder)localObject).append(paramInt);
      APLog.i("IAPStateCallBack onfinish", ((StringBuilder)localObject).toString());
      if (paramInt == -999)
      {
        i9.c(i9.this, paramString);
        return;
      }
      APRecoChannelActivity.h = false;
      if (paramInt != 0) {
        i9.b(i9.this);
      } else if (((!"wechat".equals(p4.p().e().f.e)) && (!"qqwallet".equals(p4.p().e().f.e))) || (paramInt != 0)) {
        i9.b(i9.this);
      }
      if (o.m().i())
      {
        localObject = i9.this;
        i9.a((i9)localObject, i9.c((i9)localObject));
      }
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      paramString1 = new StringBuilder();
      paramString1.append("resultCode:");
      paramString1.append(paramInt);
      APLog.i("IAPStateCallBack onError", paramString1.toString());
      APRecoChannelActivity.h = false;
      g6.k().a(false);
      i9.b(i9.this);
    }
  }
  
  public class e
    implements Runnable
  {
    public e() {}
    
    public void run()
    {
      i9.a(i9.this);
    }
  }
  
  public class f
    implements h5
  {
    public f() {}
    
    public void a()
    {
      APRecoChannelActivity.h = false;
      g6.k().a(false);
      i9.a(i9.this);
    }
    
    public void a(int paramInt)
    {
      APRecoChannelActivity.h = false;
      i9.a(i9.this);
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APRecoChannelActivity.h = false;
      g6.k().a(false);
      i9.a(i9.this);
    }
  }
  
  public class g
    implements fc
  {
    public g(String paramString) {}
    
    public void a(ob paramob)
    {
      i9.a(i9.this);
      paramob = (q3)paramob;
      if ((paramob.d() == 0) && (paramob.g() == 1))
      {
        e5.h();
        e5.a(str).a(null);
      }
    }
    
    public void b(ob paramob)
    {
      i9.a(i9.this);
    }
    
    public void c(ob paramob)
    {
      i9.a(i9.this);
    }
  }
  
  public class h
    implements View.OnClickListener
  {
    public h() {}
    
    public void onClick(View paramView)
    {
      if (APTools.m()) {
        return;
      }
      i9.a(i9.this, "goldcouponsdeduct");
    }
  }
  
  public class i
    implements View.OnClickListener
  {
    public i() {}
    
    public void onClick(View paramView)
    {
      if (TextUtils.isEmpty(i9.d(i9.this).f.i)) {
        paramView = "all";
      } else {
        paramView = "change";
      }
      APDataReportManager.getInstance().insertData("sdk.channellist.back", i9.e(i9.this), null, null, paramView);
      if (APRecoChannelActivity.f()) {
        return;
      }
      i9.f(i9.this);
    }
  }
  
  public class j
    extends w6
  {
    public j() {}
    
    public void a(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.coupons.btn.click", p4.p().e().b.saveType, null, i9.d(i9.this).f.e, null);
      paramView = new Intent();
      if (h8.d(i9.g(i9.this))) {
        paramView.setClass(i9.g(i9.this), APX5WebJSBridgeActivity.class);
      } else {
        paramView.setClass(i9.g(i9.this), APWebJSBridgeActivity.class);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("pageName", y7.y);
      paramView.putExtras(localBundle);
      ((Activity)i9.g(i9.this)).startActivityForResult(paramView, 1);
    }
  }
  
  public class k
    implements View.OnClickListener
  {
    public k() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.coupons.btn.click", p4.p().e().b.saveType, null, i9.d(i9.this).f.e, null);
      paramView = new Intent();
      if (h8.d(i9.g(i9.this))) {
        paramView.setClass(i9.g(i9.this), APX5WebJSBridgeActivity.class);
      } else {
        paramView.setClass(i9.g(i9.this), APWebJSBridgeActivity.class);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("pageName", y7.y);
      paramView.putExtras(localBundle);
      ((Activity)i9.g(i9.this)).startActivityForResult(paramView, 1);
    }
  }
  
  public class l
    implements View.OnClickListener
  {
    public l() {}
    
    public void onClick(View paramView)
    {
      paramView = i9.this;
      APRecoChannelActivity localAPRecoChannelActivity = paramView.a;
      if (localAPRecoChannelActivity != null)
      {
        paramView = new Intent(localAPRecoChannelActivity, APGoldCouponsDeductSelectValueActivity.class);
        i9.this.a.startActivityForResult(paramView, 1001);
        paramView = i9.this.a;
        paramView.overridePendingTransition(z5.a(paramView, "unipay_anim_in_from_right"), z5.a(i9.this.a, "unipay_anim_out_to_left"));
        return;
      }
      if (i9.g(paramView) != null)
      {
        paramView = new Intent(i9.g(i9.this), APGoldCouponsDeductSelectValueActivity.class);
        if ((i9.g(i9.this) instanceof Activity))
        {
          ((Activity)i9.g(i9.this)).startActivityForResult(paramView, 1001);
          ((Activity)i9.g(i9.this)).overridePendingTransition(z5.a(i9.g(i9.this), "unipay_anim_in_from_right"), z5.a(i9.g(i9.this), "unipay_anim_out_to_left"));
          return;
        }
        APLog.e("APChannelView", "initDeductCoupons(): onClick context is not activity!");
        return;
      }
      APLog.e("APChannelView", "initDeductCoupons(): onClick context is null!");
    }
  }
  
  public class m
    implements AdapterView.OnItemClickListener
  {
    public m(List paramList) {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (APTools.m()) {
        return;
      }
      paramAdapterView = ((q6)localArrayList.get(paramInt)).a;
      if (o.m().g("channellist"))
      {
        paramView = o.m().b("channellist");
        if ((!o.m().a(paramAdapterView, paramView)) || (!o.m().e(paramAdapterView)))
        {
          paramView = i9.this;
          paramView.a(i9.g(paramView), "该渠道不支持使用抵扣券，继续支付将无法享受优惠", paramAdapterView);
          return;
        }
      }
      i9.b(i9.this, paramAdapterView);
    }
  }
  
  public class n
    implements Runnable
  {
    public n(View paramView, p6 paramp6, ListView paramListView) {}
    
    public void run()
    {
      i9.a(i9.this, paramView, this.b, this.c);
    }
  }
  
  public class o
    implements View.OnClickListener
  {
    public o() {}
    
    public void onClick(View paramView)
    {
      if (APTools.m()) {
        return;
      }
      paramView = ((q6)i9.this.c.get(((Integer)paramView.getTag()).intValue())).a;
      if (o.m().g("channellist"))
      {
        Object localObject = o.m().b("channellist");
        if ((!o.m().a(paramView, (List)localObject)) || (!o.m().e(paramView)))
        {
          localObject = i9.this;
          ((i9)localObject).a(i9.g((i9)localObject), "该渠道不支持使用抵扣券，继续支付将无法享受优惠", paramView);
          return;
        }
      }
      i9.b(i9.this, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.i9
 * JD-Core Version:    0.7.0.1
 */