package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
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
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jc
  extends jd
  implements View.OnClickListener
{
  protected List<gm> a = new ArrayList();
  LinearLayout b;
  private TextView e;
  private TextView f;
  private TextView g;
  private el h;
  private int i;
  private View j;
  private Context k;
  
  private void a(View paramView)
  {
    APLog.i("APChannelView", "initUI");
    this.e = ((TextView)paramView.findViewById(2131100002));
    this.f = ((TextView)paramView.findViewById(2131100005));
    this.g = ((TextView)paramView.findViewById(2131100000));
    ((Button)paramView.findViewById(2131099928)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (APTools.j()) {
          return;
        }
        jc.a(jc.this, "goldcouponsdeduct");
      }
    });
    Object localObject = (LinearLayout)paramView.findViewById(2131099847);
    if ((!TextUtils.isEmpty(this.h.e.j)) && (fy.a().J()))
    {
      ((LinearLayout)localObject).setVisibility(8);
    }
    else
    {
      ((LinearLayout)localObject).setVisibility(0);
      ((TextView)paramView.findViewById(2131099848)).setText("确认支付方式");
      localObject = "";
      switch (this.i)
      {
      default: 
        break;
      case 5: 
        if (gc.a().f() == gc.a.a)
        {
          this.e.setVisibility(8);
          localObject = this.h.b.b;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" × ");
          ((StringBuilder)localObject).append(this.h.e.g);
          localObject = ((StringBuilder)localObject).toString();
        }
        break;
      case 4: 
        if (gc.a().f() == gc.a.a)
        {
          this.e.setVisibility(8);
          localObject = this.h.b.b;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.k.getString(2131230829));
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.h.e.g);
          ((StringBuilder)localObject).append(((ew)this.h.b).h());
          localObject = ((StringBuilder)localObject).toString();
        }
        break;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.k.getString(2131230829));
        ((StringBuilder)localObject).append(this.h.e.g);
        localObject = ((StringBuilder)localObject).toString();
      }
      this.e.setText(this.h.b.b);
      if ((this.i != 3) && (this.i != 2))
      {
        if (APUICommonMethod.h())
        {
          localObject = (eu)this.h.b;
          this.f.setText(((eu)localObject).h());
        }
        else
        {
          TextView localTextView = this.f;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(this.h.a.extendInfo.unit);
          localTextView.setText(localStringBuilder.toString());
        }
      }
      else {
        this.f.setText((CharSequence)localObject);
      }
      b(paramView);
    }
    localObject = (ImageButton)paramView.findViewById(2131099832);
    if (TextUtils.isEmpty(this.h.e.j)) {
      ((ImageButton)localObject).setImageResource(2131034192);
    }
    ((ImageButton)localObject).setVisibility(0);
    ((ImageButton)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (TextUtils.isEmpty(jc.b(jc.this).e.j)) {}
        for (paramAnonymousView = "all";; paramAnonymousView = "change") {
          break;
        }
        APDataReportManager.getInstance().insertData("sdk.channellist.back", jc.c(jc.this), null, null, paramAnonymousView);
        if (APRecoChannelActivity.a()) {
          return;
        }
        jc.d(jc.this);
      }
    });
    localObject = this.k.getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 1)
    {
      d(paramView);
      return;
    }
    if (((Configuration)localObject).orientation == 2) {
      e(paramView);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject = this.k.getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 1)
    {
      localObject = (ListView)paramView.findViewById(2131099844);
      paramView = (Button)paramView.findViewById(2131099928);
      if ((paramInt == 0) && (o.a().b()))
      {
        ((ListView)localObject).setVisibility(8);
        paramView.setVisibility(0);
        return;
      }
      ((ListView)localObject).setVisibility(0);
      paramView.setVisibility(8);
      return;
    }
    if (((Configuration)localObject).orientation == 2)
    {
      localObject = (HorizontalScrollView)paramView.findViewById(2131099965);
      paramView = (Button)paramView.findViewById(2131099928);
      if ((paramInt == 0) && (o.a().b()))
      {
        ((HorizontalScrollView)localObject).setVisibility(8);
        paramView.setVisibility(0);
        return;
      }
      ((HorizontalScrollView)localObject).setVisibility(0);
      paramView.setVisibility(8);
    }
  }
  
  private void a(View paramView, LinearLayout paramLinearLayout)
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
      paramLinearLayout.setPadding(n, APUICommonMethod.a(this.k, 2.0F), i1, i2);
      localObject1 = new LinearLayout.LayoutParams(APUICommonMethod.a(this.k, 108.0F), m);
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
      paramLinearLayout.append(n.a().h());
      paramLinearLayout.append(", isHasGoldCoupons=");
      paramLinearLayout.append(o.a().b());
      APLog.d("APChannelView", paramLinearLayout.toString());
      if ((n.a().h()) || (o.a().b()))
      {
        paramLinearLayout = (LinearLayout)paramView.findViewById(2131099935);
        paramLinearLayout.setPadding(paramLinearLayout.getPaddingLeft(), paramLinearLayout.getPaddingTop(), paramLinearLayout.getPaddingRight(), 2);
        paramLinearLayout = (TextView)paramView.findViewById(2131100002);
        localObject1 = (LinearLayout.LayoutParams)paramLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, APUICommonMethod.a(this.k, 2.0F), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramLinearLayout = (TextView)paramView.findViewById(2131100005);
        localObject1 = (LinearLayout.LayoutParams)paramLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, APUICommonMethod.a(this.k, 2.0F), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramLinearLayout = (TextView)paramView.findViewById(2131100000);
        localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin, ((RelativeLayout.LayoutParams)localObject1).rightMargin, 0);
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramLinearLayout = (TextView)paramView.findViewById(2131100007);
        localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, APUICommonMethod.a(this.k, 3.0F), ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView = (TextView)paramView.findViewById(2131100003);
        paramLinearLayout = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        paramLinearLayout.setMargins(paramLinearLayout.leftMargin, paramLinearLayout.topMargin, paramLinearLayout.rightMargin, APUICommonMethod.a(this.k, 3.0F));
        paramView.setLayoutParams(paramLinearLayout);
      }
    }
  }
  
  private void a(View paramView, gl paramgl, ListView paramListView)
  {
    int n = this.d.getWindow().findViewById(16908290).getMeasuredHeight();
    int m = n;
    if (n <= 0)
    {
      APLog.e("APChannelView", "limitMaxHeight androidContentHeight <= 0");
      localObject1 = new DisplayMetrics();
      this.d.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
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
    m = paramgl.getCount();
    int i1 = 0;
    if (m > 0)
    {
      paramView = paramgl.getView(0, null, paramListView);
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
    if (paramgl.getCount() > 1)
    {
      paramView = paramgl.getView(1, null, paramListView);
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
    if (paramgl.getCount() > 4)
    {
      paramView = paramgl.getView(4, null, paramListView);
      paramView.measure(0, 0);
      i1 = paramView.getMeasuredHeight();
      paramView = new StringBuilder();
      paramView.append("limitMaxHeight dividerItemHeight=");
      paramView.append(i1);
      APLog.d("APChannelView", paramView.toString());
    }
    float f1 = (i2 - m - i1) / n;
    n = paramgl.getCount();
    m = n;
    if (paramgl.getCount() > 0) {
      m = n - 1;
    }
    n = m;
    if (paramgl.getCount() > 4) {
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
  
  private void b(View paramView)
  {
    if (n.a().h()) {
      c();
    } else if (o.a().b()) {
      c(paramView);
    }
    String str = this.h.b.a();
    TextView localTextView = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k.getString(2131230879));
    localStringBuilder.append(str);
    localTextView.setText(localStringBuilder.toString());
    if (!APAppDataInterface.singleton().h()) {
      this.f.setVisibility(4);
    }
    a(paramView, APTools.g(str));
  }
  
  private void c()
  {
    if (!n.a().h()) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)this.j.findViewById(2131099855);
    localLinearLayout.setVisibility(0);
    ((TextView)this.j.findViewById(2131099856)).setVisibility(8);
    ((ImageView)this.j.findViewById(2131099854)).setVisibility(8);
    if (n.a().c("channellist"))
    {
      localObject1 = (TextView)this.j.findViewById(2131099857);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("券已减");
      ((StringBuilder)localObject2).append(n.a().g("channellist"));
      ((StringBuilder)localObject2).append("元");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      localObject1 = em.b().n().b.b(em.b().n().e.g);
      localObject2 = (TextView)this.j.findViewById(2131100003);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k.getString(2131230879));
      localStringBuilder.append((String)localObject1);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      ((TextView)localObject2).getPaint().setFlags(16);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)this.j.findViewById(2131100007)).setVisibility(4);
      localLinearLayout.setOnClickListener(new gs()
      {
        public void a(View paramAnonymousView)
        {
          APDataReportManager.getInstance().insertData("sdk.coupons.btn.click", em.b().n().a.saveType, null, jc.b(jc.this).e.f, null);
          paramAnonymousView = new Intent();
          if (id.b(jc.e(jc.this))) {
            paramAnonymousView.setClass(jc.e(jc.this), APX5WebJSBridgeActivity.class);
          } else {
            paramAnonymousView.setClass(jc.e(jc.this), APWebJSBridgeActivity.class);
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("pageName", hu.B);
          paramAnonymousView.putExtras(localBundle);
          ((Activity)jc.e(jc.this)).startActivityForResult(paramAnonymousView, 1);
        }
      });
      return;
    }
    Object localObject1 = (TextView)this.j.findViewById(2131099857);
    ((TextView)localObject1).setText("选择抵扣券");
    ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
    ((TextView)this.j.findViewById(2131100003)).setVisibility(8);
    ((TextView)this.j.findViewById(2131100007)).setVisibility(8);
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.coupons.btn.click", em.b().n().a.saveType, null, jc.b(jc.this).e.f, null);
        paramAnonymousView = new Intent();
        if (id.b(jc.e(jc.this))) {
          paramAnonymousView.setClass(jc.e(jc.this), APX5WebJSBridgeActivity.class);
        } else {
          paramAnonymousView.setClass(jc.e(jc.this), APWebJSBridgeActivity.class);
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("pageName", hu.B);
        paramAnonymousView.putExtras(localBundle);
        ((Activity)jc.e(jc.this)).startActivityForResult(paramAnonymousView, 1);
      }
    });
  }
  
  private void c(View paramView)
  {
    if (!o.a().b()) {
      return;
    }
    if (!o.a().c()) {
      return;
    }
    o.a().a(false);
    Object localObject = this.h.b.a(this.h.e.g);
    o.a().a(true);
    int m = APTools.g((String)localObject);
    m = o.a().c(m);
    this.b = ((LinearLayout)paramView.findViewById(2131099855));
    this.b.setVisibility(0);
    ((ImageView)paramView.findViewById(2131099854)).setVisibility(0);
    if (m <= 0)
    {
      ((TextView)paramView.findViewById(2131099856)).setVisibility(8);
      ((TextView)paramView.findViewById(2131099857)).setText("选择抵扣券");
    }
    else
    {
      ((TextView)paramView.findViewById(2131099856)).setVisibility(0);
      paramView = (TextView)paramView.findViewById(2131099857);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(o.a().k());
      ((StringBuilder)localObject).append(" 已减");
      ((StringBuilder)localObject).append(APTools.a(m, 2));
      ((StringBuilder)localObject).append("元");
      paramView.setText(((StringBuilder)localObject).toString());
    }
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (jc.this.d != null)
        {
          paramAnonymousView = new Intent(jc.this.d, APGoldCouponsDeductSelectValueActivity.class);
          jc.this.d.startActivityForResult(paramAnonymousView, 1001);
          jc.this.d.overridePendingTransition(fv.a(jc.this.d, "unipay_anim_in_from_right"), fv.a(jc.this.d, "unipay_anim_out_to_left"));
          return;
        }
        if (jc.e(jc.this) != null)
        {
          paramAnonymousView = new Intent(jc.e(jc.this), APGoldCouponsDeductSelectValueActivity.class);
          if ((jc.e(jc.this) instanceof Activity))
          {
            ((Activity)jc.e(jc.this)).startActivityForResult(paramAnonymousView, 1001);
            ((Activity)jc.e(jc.this)).overridePendingTransition(fv.a(jc.e(jc.this), "unipay_anim_in_from_right"), fv.a(jc.e(jc.this), "unipay_anim_out_to_left"));
            return;
          }
          APLog.e("APChannelView", "initDeductCoupons(): onClick context is not activity!");
          return;
        }
        APLog.e("APChannelView", "initDeductCoupons(): onClick context is null!");
      }
    });
  }
  
  private void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPay() channelId = ");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelView", ((StringBuilder)localObject).toString());
    if ("hfpay".equals(paramString))
    {
      localObject = (APHFChannel)fb.a("hfpay");
      if (!((APHFChannel)localObject).g())
      {
        APDataReportManager.getInstance().insertData("sdk.hf.nosupport.dialog.show", this.i, null, null, null);
        paramString = ((APHFChannel)localObject).h();
        ((APHFChannel)localObject).a(this.k, paramString, false);
        return;
      }
    }
    em.b().n().e.f = paramString;
    if (TextUtils.isEmpty(this.h.e.j)) {}
    for (localObject = "all";; localObject = "change") {
      break;
    }
    APDataReportManager.getInstance().insertData("sdk.channellist.click", this.i, em.b().n().e.l, em.b().n().e.f, (String)localObject);
    if (!TextUtils.isEmpty(em.b().n().e.j))
    {
      if ((fy.a().J()) && (!"cft".equals(paramString)) && (!"bank".equals(paramString))) {
        this.d.a(1, 2, null);
      }
    }
    else if (("wechat".equals(paramString)) && ((this.h.b.e() == 0) || (1 == this.h.b.e()) || (2 == this.h.b.e())))
    {
      this.d.a(1, 2, null);
      return;
    }
    if ((n.a().c(paramString)) && (!n.a().c("channellist")))
    {
      paramString = new Bundle();
      this.d.a(1, 2, paramString);
      return;
    }
    if (("wechat".equals(paramString)) || ("qqwallet".equals(paramString)) || ("hfpay".equals(paramString)) || ("cft".equals(paramString)) || ("bank".equals(paramString)) || ("qdqb".equals(paramString)) || ("qbqd".equals(paramString)) || (a(paramString))) {
      APRecoChannelActivity.b = true;
    }
    d(paramString);
  }
  
  private void d()
  {
    try
    {
      this.b = ((LinearLayout)this.j.findViewById(2131099855));
      this.b.setEnabled(true);
      AP3PointsLoading localAP3PointsLoading = (AP3PointsLoading)this.j.findViewById(2131099699);
      localAP3PointsLoading.a();
      localAP3PointsLoading.setVisibility(8);
      if (this.k.getResources().getConfiguration().orientation == 1) {
        ((LinearLayout)this.j.findViewById(2131099806)).setVisibility(0);
      } else {
        ((LinearLayout)this.j.findViewById(2131099806)).setVisibility(0);
      }
      a(false);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void d(final View paramView)
  {
    final ArrayList localArrayList = new ArrayList();
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((gm)((Iterator)localObject).next());
    }
    if (localArrayList.size() > 0)
    {
      localObject = new gm();
      ((gm)localObject).j = -2;
      localArrayList.add(0, localObject);
    }
    localObject = (ListView)paramView.findViewById(2131099844);
    if (localArrayList.size() > 0)
    {
      final gl localgl = new gl(this.k, localArrayList);
      localgl.notifyDataSetChanged();
      ((ListView)localObject).setAdapter(localgl);
      ((ListView)localObject).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (APTools.j()) {
            return;
          }
          paramAnonymousAdapterView = ((gm)localArrayList.get(paramAnonymousInt)).a;
          if (n.a().c("channellist"))
          {
            paramAnonymousView = n.a().h("channellist");
            if ((!n.a().a(paramAnonymousAdapterView, paramAnonymousView)) || (!n.a().j(paramAnonymousAdapterView)))
            {
              jc.this.a(jc.e(jc.this), "该渠道不支持使用抵扣券，继续支付将无法享受优惠", paramAnonymousAdapterView);
              return;
            }
          }
          jc.b(jc.this, paramAnonymousAdapterView);
        }
      });
      try
      {
        this.d.getWindow().findViewById(16908290).post(new Runnable()
        {
          public void run()
          {
            jc.a(jc.this, paramView, localgl, this.c);
          }
        });
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  private void d(final String paramString)
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
      APRecoChannelActivity.b = true;
    }
    fb.a().a(this.k, paramString, localBundle, new fe()
    {
      public void a()
      {
        APLog.i("IAPStateCallBack onstop", "onstop");
        APRecoChannelActivity.b = false;
        gc.a().a(false);
        jc.a(jc.this);
      }
      
      public void a(int paramAnonymousInt)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resultCode:");
        localStringBuilder.append(paramAnonymousInt);
        APLog.i("IAPStateCallBack onfinish", localStringBuilder.toString());
        if (paramAnonymousInt == -999)
        {
          jc.c(jc.this, paramString);
          return;
        }
        APRecoChannelActivity.b = false;
        if (paramAnonymousInt != 0) {
          jc.a(jc.this);
        } else if (((!"wechat".equals(em.b().n().e.f)) && (!"qqwallet".equals(em.b().n().e.f))) || (paramAnonymousInt != 0)) {
          jc.a(jc.this);
        }
        if (n.a().h()) {
          jc.a(jc.this, jc.f(jc.this));
        }
      }
      
      public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousString1 = new StringBuilder();
        paramAnonymousString1.append("resultCode:");
        paramAnonymousString1.append(paramAnonymousInt);
        APLog.i("IAPStateCallBack onError", paramAnonymousString1.toString());
        APRecoChannelActivity.b = false;
        gc.a().a(false);
        jc.a(jc.this);
      }
    }, null);
  }
  
  private void e()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("fromBack", true);
    if (TextUtils.isEmpty(this.h.e.j))
    {
      if (fy.a().g().equals("AndroidPay"))
      {
        APUICommonMethod.b();
        fv.a(2, "");
        return;
      }
      this.d.finish();
      APUICommonMethod.b(this.d);
      return;
    }
    String str = this.d.c;
    if (("hfpay".equals(str)) && (o.a().b()) && (o.a().c()) && (o.a().c(str)) && (o.a().d()))
    {
      APHFChannel.j = null;
      APRecoChannelActivity.b = true;
      this.d.a(1, 2, localBundle);
      return;
    }
    if ((!"bank".equals(em.b().n().e.j)) && (!"cft".equals(em.b().n().e.j)))
    {
      this.d.a(1, 2, localBundle);
      return;
    }
    if (fy.a().g().equals("AndroidPay"))
    {
      APUICommonMethod.b();
      fv.a(2, "");
      return;
    }
    this.d.finish();
    APUICommonMethod.b(this.d);
  }
  
  private void e(final View paramView)
  {
    final LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131099845);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.k);
    if (!TextUtils.isEmpty(this.h.e.j)) {}
    for (Object localObject1 = new LinearLayout.LayoutParams(APUICommonMethod.a(this.k, 108.0F), APUICommonMethod.a(this.k, 176.0F));; localObject1 = new LinearLayout.LayoutParams(APUICommonMethod.a(this.k, 108.0F), APUICommonMethod.a(this.k, 156.0F))) {
      break;
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((LinearLayout.LayoutParams)localObject1).setMargins(APUICommonMethod.a(this.k, 4.0F), 0, APUICommonMethod.a(this.k, 4.0F), 0);
    }
    int m = 0;
    Object localObject2 = localObject1;
    while (m < this.a.size())
    {
      Object localObject3 = (gm)this.a.get(m);
      if (((gm)localObject3).j >= 0)
      {
        Object localObject4;
        for (;;)
        {
          localObject4 = (LinearLayout)localLayoutInflater.inflate(2131165201, null);
          localObject1 = (LinearLayout)((LinearLayout)localObject4).findViewById(2131099839);
          ((LinearLayout)localObject1).setLayoutParams(localObject2);
          ((LinearLayout)localObject1).setTag(Integer.valueOf(m));
          ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              if (APTools.j()) {
                return;
              }
              paramAnonymousView = ((gm)jc.this.a.get(((Integer)paramAnonymousView.getTag()).intValue())).a;
              if (n.a().c("channellist"))
              {
                List localList = n.a().h("channellist");
                if ((!n.a().a(paramAnonymousView, localList)) || (!n.a().j(paramAnonymousView)))
                {
                  jc.this.a(jc.e(jc.this), "该渠道不支持使用抵扣券，继续支付将无法享受优惠", paramAnonymousView);
                  return;
                }
              }
              jc.b(jc.this, paramAnonymousView);
            }
          });
          Object localObject6 = (ImageView)((LinearLayout)localObject4).findViewById(2131099838);
          TextView localTextView4 = (TextView)((LinearLayout)localObject4).findViewById(2131099841);
          TextView localTextView1 = (TextView)((LinearLayout)localObject4).findViewById(2131099842);
          TextView localTextView3 = (TextView)((LinearLayout)localObject4).findViewById(2131099836);
          TextView localTextView2 = (TextView)((LinearLayout)localObject4).findViewById(2131099835);
          int n = ((gm)localObject3).c;
          String str = ((gm)localObject3).b;
          Object localObject5 = ((gm)localObject3).f;
          localObject1 = ((gm)localObject3).e;
          TextView localTextView5 = (TextView)((LinearLayout)localObject4).findViewById(2131099837);
          if ("hfpay".equals(((gm)localObject3).a))
          {
            if ((this.i == 0) && (!TextUtils.isEmpty(APHFChannel.o)))
            {
              localObject1 = ((eu)this.h.b).b(this.h.e.g, APHFChannel.o);
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
            if (this.i == 4)
            {
              localTextView5.setVisibility(0);
              localTextView5.setText("每次买一个月");
            }
            else
            {
              localTextView5.setVisibility(8);
            }
          }
          else if ((this.h.a.saveType != 4) && (this.h.a.saveType != 5))
          {
            localTextView5.setVisibility(8);
          }
          else if (((ew)this.h.b).n.equals("1"))
          {
            if (!APTools.o(((gm)localObject3).a))
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
          else
          {
            localTextView5.setVisibility(8);
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
              localObject6 = em.b().n();
              if (((((el)localObject6).a.saveType == 3) || (((el)localObject6).a.saveType == 2)) && ("qqwallet".equals(((gm)localObject3).a)))
              {
                n = APTools.g(((el)localObject6).b.a());
                try
                {
                  int i1 = Integer.valueOf((String)localObject5).intValue();
                  if ((i1 > 0) && (i1 < 100))
                  {
                    localObject5 = new BigDecimal(i1).divide(new BigDecimal(100));
                    localObject5 = new BigDecimal(1).subtract((BigDecimal)localObject5);
                    localObject5 = APTools.a(new BigDecimal(n).multiply((BigDecimal)localObject5).intValue());
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
          if (!TextUtils.isEmpty(((gm)localObject3).g))
          {
            localTextView1.setVisibility(0);
            localTextView1.setText(((gm)localObject3).g);
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
          if ((!((gm)localObject3).a.equals("qdqb")) && (!((gm)localObject3).a.equals("qbqd"))) {
            ((TextView)localObject1).setVisibility(8);
          } else if (a.a().j()) {
            if (em.b().n().d.e)
            {
              f((View)localObject4);
            }
            else
            {
              if ((em.b().n().e.k.equals("qdqb")) || (em.b().n().e.k.equals("qbqd"))) {
                break;
              }
              ((TextView)localObject1).setVisibility(8);
            }
          }
        }
        localObject3 = em.b().n().e.a;
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
      localLinearLayout.post(new Runnable()
      {
        public void run()
        {
          jc.a(jc.this, paramView, localLinearLayout);
        }
      });
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private void e(String paramString)
  {
    this.b = ((LinearLayout)this.j.findViewById(2131099855));
    this.b.setEnabled(false);
    Object localObject1 = this.k.getResources().getConfiguration();
    AP3PointsLoading localAP3PointsLoading = (AP3PointsLoading)this.j.findViewById(2131099699);
    Object localObject2;
    if (((Configuration)localObject1).orientation == 1)
    {
      localObject1 = (LinearLayout)this.j.findViewById(2131099806);
      localObject2 = (RelativeLayout.LayoutParams)localAP3PointsLoading.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = ((LinearLayout)localObject1).getMeasuredHeight();
      localAP3PointsLoading.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setVisibility(8);
    }
    else
    {
      localObject1 = (LinearLayout)this.j.findViewById(2131099806);
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
    localAP3PointsLoading.b();
    a(true);
  }
  
  private void f()
  {
    AP3PointsLoading localAP3PointsLoading = (AP3PointsLoading)this.d.findViewById(2131099699);
    APRecoChannelActivity.b = true;
    e(em.b().n().e.f);
    fb.a().a(this.k, em.b().n().e.f, null, new fe()
    {
      public void a()
      {
        APRecoChannelActivity.b = false;
        gc.a().a(false);
        jc.a(jc.this);
      }
      
      public void a(int paramAnonymousInt)
      {
        APRecoChannelActivity.b = false;
        jc.a(jc.this);
      }
      
      public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        APRecoChannelActivity.b = false;
        gc.a().a(false);
        jc.a(jc.this);
      }
    }, null);
  }
  
  private void f(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131099843);
    localTextView.setVisibility(0);
    Object localObject;
    if ((gc.a().i()) && (fy.a().x()))
    {
      paramView = gc.a().j();
      localObject = "uin";
    }
    else
    {
      paramView = em.b().n().d.k;
      localObject = em.b().n().d.l;
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
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.d = paramAPRecoChannelActivity;
    this.k = paramContext;
    this.h = em.b().n();
    this.i = this.h.a.saveType;
    if ((this.i != 3) && (this.i != 2)) {
      this.a = gn.a().d();
    } else {
      this.a = gn.a().e();
    }
    this.j = LayoutInflater.from(paramContext).inflate(2131165204, null);
    this.h.e.f = "channellist";
    try
    {
      a(this.j);
    }
    catch (Throwable paramAPRecoChannelActivity)
    {
      paramAPRecoChannelActivity.printStackTrace();
      paramContext = APDataReportManager.getInstance();
      paramBundle = em.b().n().e.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APChannelView_getContentView_");
      localStringBuilder.append(APTools.d(paramAPRecoChannelActivity));
      paramContext.a("sdk.err.view", paramBundle, localStringBuilder.toString());
    }
    return this.j;
  }
  
  public void a()
  {
    APLog.i("APChannelView", "onresume");
    final String str = em.b().n().e.f;
    if ((("wechat".equals(str)) || ("qqwallet".equals(str))) && (((!fy.a().W()) && ("wechat".equals(str))) || ((!fy.a().X()) && ("qqwallet".equals(str)))))
    {
      if (n.a().c("channellist")) {
        if ((em.b().n().e != null) && (!TextUtils.isEmpty(fy.a().D())) && (!TextUtils.isEmpty(em.b().n().b())))
        {
          e("");
          fy.a().p(true);
          fy.a().q(true);
          n.a().j();
          d();
          b(this.j);
        }
        else
        {
          d();
          return;
        }
      }
      if ((em.b().n().e != null) && (!TextUtils.isEmpty(em.b().n().e.p)))
      {
        e("");
        by.a().h(new lw()
        {
          public void a(lh paramAnonymouslh)
          {
            jc.a(jc.this);
            paramAnonymouslh = (dn)paramAnonymouslh;
            if ((paramAnonymouslh.T() == 0) && (paramAnonymouslh.a() == 1))
            {
              fb.a();
              fb.a(str).a(null);
            }
          }
          
          public void b(lh paramAnonymouslh)
          {
            jc.a(jc.this);
          }
          
          public void c(lh paramAnonymouslh)
          {
            jc.a(jc.this);
          }
        });
      }
      else
      {
        d();
        return;
      }
    }
    if (gc.a().i())
    {
      e(em.b().n().e.f);
      gc.a().a(false);
      APRecoChannelActivity.b = false;
    }
    if (n.a().h())
    {
      this.h.e.f = "channellist";
      b(this.j);
    }
    super.a();
  }
  
  public void a(Context paramContext, String paramString1, final String paramString2)
  {
    paramContext = new APAlertDialog.a(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString1);
    paramContext.a("确认支付", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        n.a().j();
        paramAnonymousAPAlertDialog.a();
        jc.b(jc.this, paramString2);
      }
    });
    paramContext.b("取消", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
      }
    });
    try
    {
      paramContext.c();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
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
        localObject = (ge.a)paramIntent.getSerializableExtra("channel");
        paramIntent = paramIntent.getStringExtra("sig");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult sig.size=");
        localStringBuilder.append(paramIntent.length());
        localStringBuilder.append(" channel=");
        localStringBuilder.append(localObject);
        APLog.i("APViewQDQB", localStringBuilder.toString());
        if (paramIntent.length() > 15) {
          APQDQBChannel.k = paramIntent;
        } else {
          APQDQBChannel.k = "";
        }
        if (localObject == ge.a.a) {
          APQDQBChannel.l = "2";
        } else {
          APQDQBChannel.l = "";
        }
        if (!APQDQBChannel.k.equals(""))
        {
          f();
          return true;
        }
      }
    }
    else
    {
      if (paramInt1 == 1001)
      {
        b(this.j);
        return true;
      }
      if (paramInt1 == 1)
      {
        if (paramInt2 == 101)
        {
          b(this.j);
          return true;
        }
        if ((paramInt2 == 102) || (paramInt2 == 103)) {
          this.d.a(1, 2, null);
        }
      }
    }
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (TextUtils.isEmpty(this.h.e.j)) {}
      for (paramContext = "all";; paramContext = "change") {
        break;
      }
      APDataReportManager.getInstance().insertData("sdk.channellist.keyback", this.i, null, null, paramContext);
      e();
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ("mcard".equals(paramString)) {
      return ((APMcardChannel)fb.a(paramString)).f();
    }
    return false;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jc
 * JD-Core Version:    0.7.0.1
 */