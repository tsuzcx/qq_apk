package midas.x;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class i1
  extends Dialog
{
  public Handler a;
  
  public i1(Context paramContext, int paramInt, Handler paramHandler)
  {
    super(paramContext, paramInt);
    this.a = paramHandler;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      ((Message)localObject).obj = paramString;
      this.a.sendMessage((Message)localObject);
    }
  }
  
  public static class a
  {
    public Context a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public TextView g;
    public DialogInterface.OnClickListener h;
    public DialogInterface.OnClickListener i;
    public Handler j = new Handler(new a());
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public a a(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
    
    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.f = paramString;
      this.i = paramOnClickListener;
      return this;
    }
    
    public i1 a()
    {
      Object localObject = (LayoutInflater)this.a.getSystemService("layout_inflater");
      i1 locali1 = new i1(this.a, 2131296533, this.j);
      localObject = ((LayoutInflater)localObject).inflate(2131165263, null);
      locali1.addContentView((View)localObject, new ViewGroup.LayoutParams(-2, -2));
      ((TextView)((View)localObject).findViewById(2131100011)).setText(this.c);
      ((ImageView)((View)localObject).findViewById(2131099891)).setBackgroundResource(this.b);
      b((View)localObject, locali1);
      a((View)localObject, locali1);
      if (this.d != null)
      {
        this.g = ((TextView)((View)localObject).findViewById(2131100010));
        this.g.setText(this.d);
      }
      locali1.setContentView((View)localObject);
      return locali1;
    }
    
    public final void a(View paramView, final i1 parami1)
    {
      if (this.f != null)
      {
        ((Button)paramView.findViewById(2131099808)).setText(this.f);
        if (this.i != null) {
          ((Button)paramView.findViewById(2131099808)).setOnClickListener(new c(parami1));
        }
      }
      else
      {
        paramView.findViewById(2131099808).setVisibility(8);
      }
    }
    
    public a b(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.e = paramString;
      this.h = paramOnClickListener;
      return this;
    }
    
    public final void b(View paramView, final i1 parami1)
    {
      if (this.e != null)
      {
        ((Button)paramView.findViewById(2131099809)).setText(this.e);
        if (this.h != null) {
          ((Button)paramView.findViewById(2131099809)).setOnClickListener(new b(parami1));
        }
      }
      else
      {
        paramView.findViewById(2131099809).setVisibility(8);
      }
    }
    
    public class a
      implements Handler.Callback
    {
      public a() {}
      
      public boolean handleMessage(Message paramMessage)
      {
        paramMessage = (String)paramMessage.obj;
        if ((!TextUtils.isEmpty(paramMessage)) && (i1.a.a(i1.a.this) != null)) {
          i1.a.a(i1.a.this).setText(paramMessage);
        }
        return false;
      }
    }
    
    public class b
      implements View.OnClickListener
    {
      public b(i1 parami1) {}
      
      public void onClick(View paramView)
      {
        i1.a.b(i1.a.this).onClick(parami1, -1);
      }
    }
    
    public class c
      implements View.OnClickListener
    {
      public c(i1 parami1) {}
      
      public void onClick(View paramView)
      {
        i1.a.c(i1.a.this).onClick(parami1, -2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.i1
 * JD-Core Version:    0.7.0.1
 */