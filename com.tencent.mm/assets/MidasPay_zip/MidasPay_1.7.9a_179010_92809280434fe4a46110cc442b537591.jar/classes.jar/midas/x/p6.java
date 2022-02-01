package midas.x;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APTools;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class p6
  extends BaseAdapter
{
  public Context a;
  public List<q6> b = new ArrayList();
  
  public p6(Context paramContext, List<q6> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public final void a(View paramView)
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramView.charAt(0));
      ((StringBuilder)localObject).append("***");
      ((StringBuilder)localObject).append(paramView.substring(paramView.length() - 3, paramView.length()));
      paramView = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  (QQ:");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(")");
      localTextView.setText(((StringBuilder)localObject).toString());
    }
  }
  
  public final void a(View paramView, int paramInt, a parama)
  {
    int i = ((q6)this.b.get(paramInt)).c;
    Object localObject2 = ((q6)this.b.get(paramInt)).b;
    Object localObject3 = ((q6)this.b.get(paramInt)).f;
    boolean bool = ((q6)this.b.get(paramInt)).j;
    Object localObject1 = ((q6)this.b.get(paramInt)).e;
    Object localObject4 = ((q6)this.b.get(paramInt)).d;
    parama.a.setBackgroundResource(i);
    parama.b.setText((CharSequence)localObject2);
    if (!TextUtils.isEmpty(((q6)this.b.get(paramInt)).g))
    {
      parama.c.setVisibility(0);
      parama.c.setText(((q6)this.b.get(paramInt)).g);
    }
    else
    {
      parama.c.setVisibility(8);
    }
    localObject2 = p4.p().e();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      if ((!((String)localObject3).trim().equals("100")) && (!((String)localObject3).trim().equals("10")))
      {
        parama.d.setVisibility(0);
        localObject4 = parama.d;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append((String)localObject3);
        localStringBuilder2.append("折");
        ((TextView)localObject4).setText(localStringBuilder2.toString());
        i = ((o4)localObject2).b.saveType;
        if (((i == 3) || (i == 2)) && ("qqwallet".equals(((q6)this.b.get(paramInt)).a)))
        {
          i = APTools.p(((o4)localObject2).c.a());
          try
          {
            int j = Integer.valueOf((String)localObject3).intValue();
            if ((j <= 0) || (j >= 100)) {
              break label514;
            }
            localObject3 = new BigDecimal(j).divide(new BigDecimal(100));
            localObject3 = new BigDecimal(1).subtract((BigDecimal)localObject3);
            localObject3 = APTools.b(new BigDecimal(i).multiply((BigDecimal)localObject3).intValue());
            parama.d.setVisibility(0);
            localObject4 = parama.d;
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("可省");
            localStringBuilder2.append((String)localObject3);
            localStringBuilder2.append("元");
            ((TextView)localObject4).setText(localStringBuilder2.toString());
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      else
      {
        parama.d.setVisibility(8);
      }
    }
    else {
      parama.d.setVisibility(8);
    }
    label514:
    if (parama.c.getVisibility() == 0)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        parama.d.setTextAppearance(2131296397);
      } else {
        parama.d.setTextAppearance(this.a, 2131296397);
      }
      parama.d.setBackgroundColor(0);
    }
    if ("hfpay".equals(((q6)this.b.get(paramInt)).a))
    {
      if ((((o4)localObject2).b.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.v)))
      {
        localObject1 = ((x4)((o4)localObject2).c).b(((o4)localObject2).f.f, APHFChannel.v);
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("(需支付");
        localStringBuilder1.append((String)localObject1);
        localStringBuilder1.append("元)");
        localObject1 = localStringBuilder1.toString();
      }
      else
      {
        localObject1 = "";
      }
      if (((o4)localObject2).b.saveType == 4)
      {
        parama.f.setText("(每次买一个月)");
        parama.f.setVisibility(0);
      }
      else
      {
        parama.f.setVisibility(8);
      }
    }
    else
    {
      i = ((o4)localObject2).b.saveType;
      if ((i != 4) && (i != 5)) {
        parama.f.setVisibility(8);
      } else if (((z4)((o4)localObject2).c).n.equals("1"))
      {
        if (!APTools.e(((q6)this.b.get(paramInt)).a))
        {
          parama.f.setText("(不支持自动续费)");
          parama.f.setVisibility(0);
          parama.f.setTextColor(paramView.getResources().getColor(2130903085));
        }
        else
        {
          parama.f.setVisibility(8);
        }
      }
      else {
        parama.f.setVisibility(8);
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"未绑卡".equals(((String)localObject1).trim())))
    {
      parama.e.setVisibility(0);
      parama.e.setText((CharSequence)localObject1);
    }
    else
    {
      parama.e.setVisibility(8);
    }
    parama = (TextView)paramView.findViewById(2131099843);
    if ((!((q6)this.b.get(paramInt)).a.equals("qdqb")) && (!((q6)this.b.get(paramInt)).a.equals("qbqd")))
    {
      parama.setVisibility(8);
      return;
    }
    if (a.r().e())
    {
      if (p4.p().e().e.e)
      {
        a(paramView);
        return;
      }
      if ((!p4.p().e().f.j.equals("qdqb")) && (!p4.p().e().f.j.equals("qbqd")))
      {
        parama.setVisibility(8);
        return;
      }
      paramView = p4.p().e().f.a;
      if (!TextUtils.isEmpty(paramView))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramView.charAt(0));
        ((StringBuilder)localObject1).append("***");
        ((StringBuilder)localObject1).append(paramView.substring(paramView.length() - 3, paramView.length()));
        paramView = ((StringBuilder)localObject1).toString();
        parama.setVisibility(0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("  (");
        ((StringBuilder)localObject1).append(paramView);
        ((StringBuilder)localObject1).append(")");
        parama.setText(((StringBuilder)localObject1).toString());
        return;
      }
      parama.setVisibility(8);
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((q6)this.b.get(paramInt)).i == -1) {
      return -1;
    }
    if (((q6)this.b.get(paramInt)).i == -2) {
      return -2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      if (i != -2)
      {
        if (i != -1)
        {
          if (i != 1) {
            return paramView;
          }
          paramView = LayoutInflater.from(this.a).inflate(2131165201, null);
          paramViewGroup = new a();
          paramViewGroup.a = ((ImageView)paramView.findViewById(2131099838));
          paramViewGroup.b = ((TextView)paramView.findViewById(2131099841));
          paramViewGroup.c = ((TextView)paramView.findViewById(2131099842));
          paramViewGroup.d = ((TextView)paramView.findViewById(2131099836));
          paramViewGroup.e = ((TextView)paramView.findViewById(2131099835));
          paramViewGroup.f = ((TextView)paramView.findViewById(2131099837));
          paramView.setTag(paramViewGroup);
          a(paramView, paramInt, paramViewGroup);
          return paramView;
        }
        return LayoutInflater.from(this.a).inflate(2131165202, null);
      }
      return LayoutInflater.from(this.a).inflate(2131165203, null);
    }
    if ((i != -2) && (i != -1))
    {
      if (i != 1) {
        return paramView;
      }
      a(paramView, paramInt, (a)paramView.getTag());
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (((q6)this.b.get(paramInt)).i == -1) {
      return false;
    }
    return ((q6)this.b.get(paramInt)).i != -2;
  }
  
  public static class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.p6
 * JD-Core Version:    0.7.0.1
 */