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

public class bh
  extends Dialog
{
  private Handler a;
  
  public bh(Context paramContext, int paramInt, Handler paramHandler)
  {
    super(paramContext, paramInt);
    this.a = paramHandler;
  }
  
  public void a(String paramString)
  {
    if (this.a != null)
    {
      Message localMessage = this.a.obtainMessage();
      localMessage.obj = paramString;
      this.a.sendMessage(localMessage);
    }
  }
  
  public static class a
  {
    private Context a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private View g;
    private TextView h;
    private DialogInterface.OnClickListener i;
    private DialogInterface.OnClickListener j;
    private Handler k = new Handler(new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        paramAnonymousMessage = (String)paramAnonymousMessage.obj;
        if ((!TextUtils.isEmpty(paramAnonymousMessage)) && (bh.a.a(bh.a.this) != null)) {
          bh.a.a(bh.a.this).setText(paramAnonymousMessage);
        }
        return false;
      }
    });
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    private void a(View paramView, final bh parambh)
    {
      if (this.e != null)
      {
        ((Button)paramView.findViewById(2131099809)).setText(this.e);
        if (this.i != null) {
          ((Button)paramView.findViewById(2131099809)).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              bh.a.b(bh.a.this).onClick(parambh, -1);
            }
          });
        }
      }
      else
      {
        paramView.findViewById(2131099809).setVisibility(8);
      }
    }
    
    private void b(View paramView, final bh parambh)
    {
      if (this.f != null)
      {
        ((Button)paramView.findViewById(2131099808)).setText(this.f);
        if (this.j != null) {
          ((Button)paramView.findViewById(2131099808)).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              bh.a.c(bh.a.this).onClick(parambh, -2);
            }
          });
        }
      }
      else
      {
        paramView.findViewById(2131099808).setVisibility(8);
      }
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
      this.e = paramString;
      this.i = paramOnClickListener;
      return this;
    }
    
    public bh a()
    {
      Object localObject = (LayoutInflater)this.a.getSystemService("layout_inflater");
      bh localbh = new bh(this.a, 2131296533, this.k);
      localObject = ((LayoutInflater)localObject).inflate(2131165262, null);
      localbh.addContentView((View)localObject, new ViewGroup.LayoutParams(-2, -2));
      ((TextView)((View)localObject).findViewById(2131100011)).setText(this.c);
      ((ImageView)((View)localObject).findViewById(2131099891)).setBackgroundResource(this.b);
      a((View)localObject, localbh);
      b((View)localObject, localbh);
      if (this.d != null)
      {
        this.h = ((TextView)((View)localObject).findViewById(2131100010));
        this.h.setText(this.d);
      }
      else
      {
        View localView = this.g;
      }
      localbh.setContentView((View)localObject);
      return localbh;
    }
    
    public a b(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.f = paramString;
      this.j = paramOnClickListener;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bh
 * JD-Core Version:    0.7.0.1
 */