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

public class gb
  extends BaseAdapter
{
  private Context a;
  private List<gc> b = new ArrayList();
  
  public gb(Context paramContext, List<gc> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131099843);
    localTextView.setVisibility(0);
    Object localObject;
    if ((fs.a().i()) && (fp.a().x()))
    {
      paramView = fs.a().j();
      localObject = "uin";
    }
    else
    {
      paramView = ed.b().n().d.k;
      localObject = ed.b().n().d.l;
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
  
  private void a(View paramView, int paramInt, a parama)
  {
    int i = ((gc)this.b.get(paramInt)).c;
    Object localObject2 = ((gc)this.b.get(paramInt)).b;
    Object localObject3 = ((gc)this.b.get(paramInt)).f;
    boolean bool = ((gc)this.b.get(paramInt)).k;
    Object localObject1 = ((gc)this.b.get(paramInt)).e;
    Object localObject4 = ((gc)this.b.get(paramInt)).d;
    parama.a.setBackgroundResource(i);
    parama.b.setText((CharSequence)localObject2);
    if (!TextUtils.isEmpty(((gc)this.b.get(paramInt)).g))
    {
      parama.c.setVisibility(0);
      parama.c.setText(((gc)this.b.get(paramInt)).g);
    }
    else
    {
      parama.c.setVisibility(8);
    }
    localObject2 = ed.b().n();
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
        if (((((ec)localObject2).a.saveType == 3) || (((ec)localObject2).a.saveType == 2)) && ("qqwallet".equals(((gc)this.b.get(paramInt)).a)))
        {
          i = APTools.g(((ec)localObject2).b.a());
          try
          {
            int j = Integer.valueOf((String)localObject3).intValue();
            if ((j <= 0) || (j >= 100)) {
              break label516;
            }
            localObject3 = new BigDecimal(j).divide(new BigDecimal(100));
            localObject3 = new BigDecimal(1).subtract((BigDecimal)localObject3);
            localObject3 = APTools.a(new BigDecimal(i).multiply((BigDecimal)localObject3).intValue());
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
    label516:
    if (parama.c.getVisibility() == 0)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        parama.d.setTextAppearance(2131296397);
      } else {
        parama.d.setTextAppearance(this.a, 2131296397);
      }
      parama.d.setBackgroundColor(0);
    }
    if ("hfpay".equals(((gc)this.b.get(paramInt)).a))
    {
      if ((((ec)localObject2).a.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.n)))
      {
        localObject1 = ((el)((ec)localObject2).b).b(((ec)localObject2).e.g, APHFChannel.n);
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
      if (((ec)localObject2).a.saveType == 4)
      {
        parama.f.setText("(每次买一个月)");
        parama.f.setVisibility(0);
      }
      else
      {
        parama.f.setVisibility(8);
      }
    }
    else if ((((ec)localObject2).a.saveType != 4) && (((ec)localObject2).a.saveType != 5))
    {
      parama.f.setVisibility(8);
    }
    else if (((en)((ec)localObject2).b).n.equals("1"))
    {
      if (!APTools.o(((gc)this.b.get(paramInt)).a))
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
    else
    {
      parama.f.setVisibility(8);
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
    if ((!((gc)this.b.get(paramInt)).a.equals("qdqb")) && (!((gc)this.b.get(paramInt)).a.equals("qbqd")))
    {
      parama.setVisibility(8);
      return;
    }
    if (a.a().j())
    {
      if (ed.b().n().d.e)
      {
        a(paramView);
        return;
      }
      if ((!ed.b().n().e.k.equals("qdqb")) && (!ed.b().n().e.k.equals("qbqd")))
      {
        parama.setVisibility(8);
        return;
      }
      paramView = ed.b().n().e.a;
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
    if (((gc)this.b.get(paramInt)).j == -1) {
      return -1;
    }
    if (((gc)this.b.get(paramInt)).j == -2) {
      return -2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      if (i != 1)
      {
        switch (i)
        {
        default: 
          return paramView;
        case -1: 
          return LayoutInflater.from(this.a).inflate(2131165201, null);
        }
        return LayoutInflater.from(this.a).inflate(2131165202, null);
      }
      paramView = LayoutInflater.from(this.a).inflate(2131165200, null);
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
    if (i != 1) {}
    switch (i)
    {
    default: 
      return paramView;
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
    if (((gc)this.b.get(paramInt)).j == -1) {
      return false;
    }
    return ((gc)this.b.get(paramInt)).j != -2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.gb
 * JD-Core Version:    0.7.0.1
 */