package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APGridView;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class l7
  extends k7
{
  public static NumberFormat n = ;
  public View l = null;
  public TextWatcher m = new d();
  
  public l7(ScrollView paramScrollView, APGridView paramAPGridView, Activity paramActivity, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    this.d = paramScrollView;
    this.c = paramAPGridView;
    this.e = paramActivity;
    this.f = paramArrayOfString1;
    this.g = paramArrayOfString2;
    this.h = paramArrayOfString3;
    this.b = p4.p().e();
    this.k = this.b.b.extendInfo.isShowListOtherNum;
    if (c6.s0().n() > 0)
    {
      this.a = c6.s0().n();
      return;
    }
    this.a = 9999999;
  }
  
  public int a()
  {
    if (d0.i().c())
    {
      if (!this.k) {
        return d0.i().f();
      }
      if (this.c.getNumColumns() != 1) {
        return d0.i().f() + 3;
      }
      return d0.i().f() + 2;
    }
    if (!this.k) {
      return this.f.length;
    }
    if (this.c.getNumColumns() != 1) {
      return this.f.length + 3;
    }
    return this.f.length + 2;
  }
  
  public int a(int paramInt)
  {
    if (!this.k) {
      return 0;
    }
    if (this.c.getNumColumns() != 1)
    {
      if (paramInt == a() - 1) {
        return 2;
      }
      if (paramInt == a() - 2) {
        return 4;
      }
      if (paramInt == a() - 3) {
        return 1;
      }
      return 0;
    }
    if (paramInt == a() - 1) {
      return 2;
    }
    if (paramInt == a() - 2) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = paramView;
    for (;;)
    {
      try
      {
        LayoutInflater localLayoutInflater = LayoutInflater.from(this.e);
        localObject1 = paramView;
        int i = a(paramInt);
        localView = paramView;
        if (paramView != null)
        {
          localObject1 = paramView;
          Object localObject2 = paramView.getTag();
          localView = paramView;
          if (localObject2 != null)
          {
            localView = paramView;
            localObject1 = paramView;
            if ((localObject2 instanceof Integer))
            {
              localObject1 = paramView;
              int j = ((Integer)localObject2).intValue();
              if (j == -1) {
                break label468;
              }
              localView = paramView;
              if (j != i) {
                break label468;
              }
            }
          }
        }
        if (localView == null)
        {
          if (i == 0)
          {
            localObject1 = localView;
            paramView = localLayoutInflater.inflate(2131165252, paramViewGroup, false);
            localObject1 = paramView;
            a(paramView, paramInt);
          }
          else if (i == 1)
          {
            localObject1 = localView;
            paramView = localLayoutInflater.inflate(2131165256, paramViewGroup, false);
            localObject1 = paramView;
            b(paramView, paramInt);
          }
          else if (i == 4)
          {
            localObject1 = localView;
            paramView = localLayoutInflater.inflate(2131165255, paramViewGroup, false);
            localObject1 = paramView;
            paramView.setVisibility(8);
          }
          else
          {
            paramView = localView;
            if (i == 2)
            {
              localObject1 = localView;
              paramViewGroup = localLayoutInflater.inflate(2131165257, paramViewGroup, false);
              localObject1 = paramViewGroup;
              this.l = paramViewGroup;
              paramView = paramViewGroup;
              try
              {
                if (!TextUtils.isEmpty(this.j.getText().toString().trim())) {
                  continue;
                }
                this.l.setVisibility(8);
                paramView = paramViewGroup;
              }
              catch (Exception paramView)
              {
                localObject1 = paramViewGroup;
                paramView.printStackTrace();
                localObject1 = paramViewGroup;
                this.l.setVisibility(8);
                paramView = paramViewGroup;
              }
            }
          }
        }
        else if (i == 0)
        {
          localObject1 = localView;
          a(localView, paramInt);
          paramView = localView;
        }
        else if (i == 1)
        {
          localObject1 = localView;
          b(localView, paramInt);
          paramView = localView;
        }
        else if (i == 4)
        {
          localObject1 = localView;
          localView.setVisibility(8);
          paramView = localView;
        }
        else
        {
          paramView = localView;
          if (i == 2)
          {
            localObject1 = localView;
            this.l = localView;
            paramView = localView;
            try
            {
              if (TextUtils.isEmpty(this.j.getText().toString().trim()))
              {
                this.l.setVisibility(8);
                paramView = localView;
              }
            }
            catch (Exception paramView)
            {
              localObject1 = localView;
              paramView.printStackTrace();
              localObject1 = localView;
              this.l.setVisibility(8);
              paramView = localView;
            }
          }
        }
        localObject1 = paramView;
        paramView.setTag(Integer.valueOf(i));
        return paramView;
      }
      catch (Exception paramView)
      {
        APLog.e("getView", paramView.toString());
        ((View)localObject1).setTag(Integer.valueOf(-1));
        return localObject1;
      }
      label468:
      View localView = null;
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131099776);
    TextView localTextView2 = (TextView)paramView.findViewById(2131099779);
    TextView localTextView1 = (TextView)paramView.findViewById(2131099781);
    Object localObject3 = (TextView)paramView.findViewById(2131099977);
    Object localObject4 = (TextView)paramView.findViewById(2131099978);
    Object localObject6 = (TextView)paramView.findViewById(2131099980);
    TextView localTextView3 = (TextView)paramView.findViewById(2131099784);
    Object localObject2 = (TextView)paramView.findViewById(2131099778);
    boolean bool1 = d0.i().c();
    boolean bool2 = d0.i().b();
    if (bool1)
    {
      paramView = d0.i().g(paramInt);
      if (paramView != null)
      {
        int i = paramView.a;
        if (i > 0)
        {
          paramView = String.valueOf(i);
          if (d0.i().b())
          {
            ArrayList localArrayList = d0.i().f(i);
            if ((localArrayList != null) && (localArrayList.size() > 0))
            {
              ((TextView)localObject3).setText("首充");
              ((TextView)localObject3).setVisibility(0);
            }
            else
            {
              ((TextView)localObject3).setVisibility(8);
            }
          }
          else
          {
            ((TextView)localObject3).setVisibility(8);
          }
          localObject3 = d0.i().g(paramInt);
          if ((localObject3 != null) && (!TextUtils.isEmpty(((z)localObject3).b)))
          {
            ((TextView)localObject6).setText(((z)localObject3).b);
            ((TextView)localObject6).setVisibility(0);
            paramInt = 1;
          }
          else
          {
            ((TextView)localObject6).setVisibility(8);
            paramInt = 0;
          }
          if (d0.i().c())
          {
            localObject3 = d0.i().k(i);
            if (paramInt == 0)
            {
              if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
              {
                ((TextView)localObject4).setText("满赠");
                ((TextView)localObject4).setVisibility(0);
              }
              else
              {
                ((TextView)localObject4).setVisibility(8);
              }
            }
            else {
              ((TextView)localObject4).setVisibility(8);
            }
          }
          else
          {
            ((TextView)localObject4).setVisibility(8);
          }
          localObject4 = d0.i().b(i);
          if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
          {
            localObject3 = new StringBuffer();
            localObject4 = ((ArrayList)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject6 = (w)((Iterator)localObject4).next();
              ((StringBuffer)localObject3).append(((w)localObject6).a);
              ((StringBuffer)localObject3).append("×");
              ((StringBuffer)localObject3).append(((w)localObject6).b);
              ((StringBuffer)localObject3).append(",");
            }
            if (((StringBuffer)localObject3).length() > 0)
            {
              ((TextView)localObject2).setText(((StringBuffer)localObject3).substring(0, ((StringBuffer)localObject3).length() - 1).toString());
              ((TextView)localObject2).setVisibility(0);
            }
            else
            {
              ((TextView)localObject2).setText("");
              ((TextView)localObject2).setVisibility(8);
            }
          }
          else
          {
            ((TextView)localObject2).setText("");
            ((TextView)localObject2).setVisibility(8);
          }
          paramInt = d0.i().a(i);
          if (paramInt > 0)
          {
            localTextView3.setVisibility(0);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("+");
            ((StringBuilder)localObject2).append(paramInt);
            localTextView3.setText(((StringBuilder)localObject2).toString());
            break label1000;
          }
          localTextView3.setVisibility(8);
          break label1000;
        }
      }
      ((TextView)localObject3).setVisibility(8);
      ((TextView)localObject4).setVisibility(8);
      ((TextView)localObject6).setVisibility(8);
      localTextView3.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      paramView = "0";
    }
    else
    {
      Object localObject5;
      if ((!bool1) && (bool2))
      {
        paramView = this.f[paramInt];
        try
        {
          float f = Float.parseFloat(n.parse(paramView).toString());
          paramInt = (int)f;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          paramInt = 0;
        }
        localObject5 = d0.i().f(paramInt);
        if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
        {
          ((TextView)localObject3).setText("首充");
          ((TextView)localObject3).setVisibility(0);
        }
        else
        {
          ((TextView)localObject3).setVisibility(8);
        }
        localObject5 = d0.i().e(paramInt);
        if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
        {
          localObject3 = new StringBuffer();
          localObject5 = ((ArrayList)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (w)((Iterator)localObject5).next();
            ((StringBuffer)localObject3).append(((w)localObject6).a);
            ((StringBuffer)localObject3).append("×");
            ((StringBuffer)localObject3).append(((w)localObject6).b);
            ((StringBuffer)localObject3).append(",");
          }
          if (((StringBuffer)localObject3).length() > 0)
          {
            ((TextView)localObject2).setText(((StringBuffer)localObject3).substring(0, ((StringBuffer)localObject3).length() - 1).toString());
            ((TextView)localObject2).setVisibility(0);
          }
          else
          {
            ((TextView)localObject2).setText("");
            ((TextView)localObject2).setVisibility(8);
          }
        }
        else
        {
          ((TextView)localObject2).setText("");
          ((TextView)localObject2).setVisibility(8);
        }
        paramInt = d0.i().d(paramInt);
        if (paramInt > 0)
        {
          localTextView3.setVisibility(0);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("+");
          ((StringBuilder)localObject2).append(paramInt);
          localTextView3.setText(((StringBuilder)localObject2).toString());
        }
        else
        {
          localTextView3.setVisibility(8);
        }
      }
      else
      {
        ((TextView)localObject3).setVisibility(8);
        ((TextView)localObject5).setVisibility(8);
        ((TextView)localObject6).setVisibility(8);
        localTextView3.setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        paramView = this.f[paramInt];
      }
    }
    label1000:
    if ((p4.p().e().b.resId == 0) && (p4.p().e().b.resData == null))
    {
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = paramView;
    }
    else
    {
      APUICommonMethod.a((ImageView)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("× ");
      ((StringBuilder)localObject1).append(paramView);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localTextView2.setText((CharSequence)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.e.getString(2131230879));
    ((StringBuilder)localObject1).append(p4.p().e().c.b(paramView));
    localTextView1.setText(((StringBuilder)localObject1).toString());
  }
  
  public final void a(String paramString)
  {
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131099771);
    LinearLayout localLinearLayout = (LinearLayout)this.l.findViewById(2131099983);
    if (TextUtils.isEmpty(paramString))
    {
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout.setVisibility(8);
      return;
    }
    int i1 = i.b(paramString);
    int k = 0;
    ((LinearLayout)localObject2).setVisibility(0);
    localLinearLayout.setVisibility(0);
    Object localObject3 = (TextView)this.l.findViewById(2131099987);
    ((TextView)localObject3).setText("优惠活动:");
    Object localObject4 = (TextView)this.l.findViewById(2131099977);
    TextView localTextView2 = (TextView)this.l.findViewById(2131099978);
    TextView localTextView3 = (TextView)this.l.findViewById(2131099980);
    TextView localTextView1 = (TextView)this.l.findViewById(2131099982);
    boolean bool = d0.i().b();
    localObject1 = null;
    if (bool)
    {
      paramString = d0.i().f(i1);
      if ((paramString != null) && (paramString.size() > 0))
      {
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject4).setText("首充");
        ((TextView)localObject4).setVisibility(0);
        i = 1;
        break label245;
      }
      ((TextView)localObject4).setVisibility(8);
    }
    else
    {
      ((TextView)localObject4).setVisibility(8);
      paramString = null;
    }
    int i = 0;
    label245:
    localObject4 = d0.i().h(i1);
    int j;
    if ((localObject4 != null) && (!TextUtils.isEmpty(((z)localObject4).b)))
    {
      ((TextView)localObject3).setVisibility(0);
      localTextView3.setText(((z)localObject4).b);
      localTextView3.setVisibility(0);
      j = 1;
      i = 1;
    }
    else
    {
      localTextView3.setVisibility(8);
      j = 0;
    }
    if (d0.i().c())
    {
      localObject1 = d0.i().k(i1);
      if (j == 0)
      {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          ((TextView)localObject3).setVisibility(0);
          localTextView2.setText("满赠");
          localTextView2.setVisibility(0);
          i = 1;
        }
        else
        {
          localTextView2.setVisibility(8);
        }
      }
      else {
        localTextView2.setVisibility(8);
      }
    }
    else
    {
      localTextView2.setVisibility(8);
    }
    if (i == 0) {
      ((LinearLayout)localObject2).setVisibility(8);
    }
    localObject2 = (TextView)this.l.findViewById(2131100035);
    ((TextView)localObject2).setText("赠送物品:");
    localObject1 = d0.i().a(paramString, (ArrayList)localObject1);
    i = k;
    if (localObject1 != null)
    {
      i = k;
      if (((ArrayList)localObject1).size() > 0)
      {
        paramString = new StringBuffer();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (w)((Iterator)localObject1).next();
          paramString.append(((w)localObject3).a);
          paramString.append("×");
          paramString.append(((w)localObject3).b);
          paramString.append(",");
        }
        i = k;
        if (paramString.length() > 0)
        {
          localTextView1.setText(paramString.substring(0, paramString.length() - 1).toString());
          ((TextView)localObject2).setVisibility(0);
          i = 1;
        }
      }
    }
    if (i == 0) {
      localLinearLayout.setVisibility(8);
    }
  }
  
  public final void b()
  {
    if (APTools.m()) {
      return;
    }
    Object localObject1 = this.j.getText().toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = this.b.f;
      ((d5)localObject2).f = ((String)localObject1);
      localObject2 = ((d5)localObject2).f;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("a");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      APDataReportManager.getInstance().insertData("sdk.gamelist.click", this.b.b.saveType, null, (String)localObject1, null);
      e5.h().a(this.e, "", null);
      return;
    }
    Toast.makeText(this.e, "充值数量不能为空", 1).show();
  }
  
  public final void b(View paramView, int paramInt)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131099776);
    if ((p4.p().e().b.resId == 0) && (p4.p().e().b.resData == null)) {
      localImageView.setVisibility(8);
    } else {
      APUICommonMethod.a(localImageView);
    }
    this.j = ((EditText)paramView.findViewById(2131099780));
    this.i = ((Button)paramView.findViewById(2131099782));
    if (TextUtils.isEmpty(this.j.getText().toString().trim())) {
      this.i.setVisibility(4);
    }
    this.i.setText("确定");
    this.j.setFilters(new InputFilter[] { new InputFilter.LengthFilter(7) });
    this.j.addTextChangedListener(this.m);
    if (this.e.getResources().getConfiguration().orientation == 1) {
      this.j.setOnTouchListener(new a());
    }
    this.j.setOnEditorActionListener(new b());
    this.i.setOnClickListener(new c());
  }
  
  public boolean b(int paramInt)
  {
    if (d0.i().c()) {
      return paramInt < d0.i().f();
    }
    return paramInt < this.f.length;
  }
  
  public class a
    implements View.OnTouchListener
  {
    public a() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      l7.this.d.postDelayed(new a(), 500L);
      return false;
    }
    
    public class a
      implements Runnable
    {
      public a() {}
      
      public void run()
      {
        l7.this.d.fullScroll(130);
        l7.this.j.requestFocus();
      }
    }
  }
  
  public class b
    implements TextView.OnEditorActionListener
  {
    public b() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 6)
      {
        ((InputMethodManager)paramTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
        l7.a(l7.this);
        return true;
      }
      return false;
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      paramView = l7.this.j.getText().toString();
      if (!TextUtils.isEmpty(paramView))
      {
        Object localObject = l7.this.b.f;
        ((d5)localObject).f = paramView;
        localObject = ((d5)localObject).f;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("a");
        ((StringBuilder)localObject).append(paramView);
        paramView = ((StringBuilder)localObject).toString();
        APDataReportManager.getInstance().insertData("sdk.gamelist.else", l7.this.b.b.saveType, null, paramView, null);
      }
      l7.a(l7.this);
    }
  }
  
  public class d
    implements TextWatcher
  {
    public d() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      Object localObject2 = (LinearLayout)l7.b(l7.this).findViewById(2131099860);
      Object localObject1 = (TextView)l7.b(l7.this).findViewById(2131099985);
      int i;
      if (paramEditable.toString().length() > 0)
      {
        l7.this.i.setVisibility(0);
        if (paramEditable.toString().equals("0"))
        {
          l7.this.j.setText("");
          ((LinearLayout)localObject2).setVisibility(8);
          break label270;
        }
        l7.b(l7.this).setVisibility(0);
        ((LinearLayout)localObject2).setVisibility(0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(l7.this.e.getString(2131230879));
        ((StringBuilder)localObject2).append(p4.p().e().c.b(paramEditable.toString().trim()));
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        i = i.b(paramEditable.toString());
        int j = l7.this.a;
        if ((j <= 0) || (i <= j)) {}
      }
      try
      {
        paramEditable.delete(paramEditable.length() - 1, paramEditable.length());
        label214:
        APUICommonMethod.a(l7.this.e, "购买数量不能超过最大限制");
        i = paramEditable.toString().length();
        if (i > 0)
        {
          l7.this.j.setSelection(i);
          break label270;
          l7.this.i.setVisibility(4);
          ((LinearLayout)localObject2).setVisibility(8);
        }
        label270:
        localObject1 = l7.this;
        if (((k7)localObject1).b.b.saveType == 0) {
          l7.a((l7)localObject1, paramEditable.toString());
        }
        return;
      }
      catch (Exception localException)
      {
        break label214;
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.l7
 * JD-Core Version:    0.7.0.1
 */