package com.tencent.mm.plugin.appbrand.widget.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

public class EditVerifyCodeView
  extends RelativeLayout
{
  private StringBuilder mBuilder;
  private Context mContext;
  private ImageView[] nur;
  private TextView[] nus;
  private VerifyCodeEditText nut;
  View.OnKeyListener nuu;
  public a nuv;
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131588);
    this.mBuilder = new StringBuilder();
    this.nur = new ImageView[6];
    this.nus = new TextView[6];
    this.nuu = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(131587);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
        if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 1))
        {
          EditVerifyCodeView.c(EditVerifyCodeView.this);
          a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(131587);
          return true;
        }
        a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(131587);
        return false;
      }
    };
    ej(paramContext);
    AppMethodBeat.o(131588);
  }
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(131589);
    this.mBuilder = new StringBuilder();
    this.nur = new ImageView[6];
    this.nus = new TextView[6];
    this.nuu = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(131587);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
        if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 1))
        {
          EditVerifyCodeView.c(EditVerifyCodeView.this);
          a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(131587);
          return true;
        }
        a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(131587);
        return false;
      }
    };
    ej(paramContext);
    AppMethodBeat.o(131589);
  }
  
  @SuppressLint({"InflateParams"})
  private void ej(Context paramContext)
  {
    AppMethodBeat.i(131592);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131493742, null);
    Object localObject1 = (TextView)paramContext.findViewById(2131298409);
    Object localObject2 = (TextView)paramContext.findViewById(2131298410);
    Object localObject3 = (TextView)paramContext.findViewById(2131298411);
    Object localObject4 = (TextView)paramContext.findViewById(2131298412);
    Object localObject5 = (TextView)paramContext.findViewById(2131298413);
    Object localObject6 = (TextView)paramContext.findViewById(2131298414);
    this.nus[0] = localObject1;
    this.nus[1] = localObject2;
    this.nus[2] = localObject3;
    this.nus[3] = localObject4;
    this.nus[4] = localObject5;
    this.nus[5] = localObject6;
    localObject1 = (ImageView)paramContext.findViewById(2131298389);
    localObject2 = (ImageView)paramContext.findViewById(2131298390);
    localObject3 = (ImageView)paramContext.findViewById(2131298391);
    localObject4 = (ImageView)paramContext.findViewById(2131298392);
    localObject5 = (ImageView)paramContext.findViewById(2131298393);
    localObject6 = (ImageView)paramContext.findViewById(2131298394);
    this.nur[0] = localObject1;
    this.nur[1] = localObject2;
    this.nur[2] = localObject3;
    this.nur[3] = localObject4;
    this.nur[4] = localObject5;
    this.nur[5] = localObject6;
    this.nut = ((VerifyCodeEditText)paramContext.findViewById(2131306284));
    this.nut.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(131586);
        if ((paramAnonymousEditable == null) || (paramAnonymousEditable.length() == 0))
        {
          AppMethodBeat.o(131586);
          return;
        }
        ae.i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", new Object[] { paramAnonymousEditable.toString() });
        if (EditVerifyCodeView.a(EditVerifyCodeView.this).length() < 6)
        {
          EditVerifyCodeView.a(EditVerifyCodeView.this).append(paramAnonymousEditable.toString());
          EditVerifyCodeView.b(EditVerifyCodeView.this);
        }
        paramAnonymousEditable.delete(0, paramAnonymousEditable.length());
        AppMethodBeat.o(131586);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.nut.setKeyListener(new NumberKeyListener()
    {
      protected final char[] getAcceptedChars()
      {
        return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
      }
      
      public final int getInputType()
      {
        return 3;
      }
    });
    this.nut.setOnKeyListener(this.nuu);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(131592);
  }
  
  public VerifyCodeEditText getEditText()
  {
    return this.nut;
  }
  
  public String getText()
  {
    AppMethodBeat.i(131590);
    String str = this.mBuilder.toString();
    AppMethodBeat.o(131590);
    return str;
  }
  
  public void setCodeEditCompleListener(a parama)
  {
    this.nuv = parama;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(131591);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.mBuilder.append(paramString);
    paramString = this.mBuilder.toString();
    int j = paramString.length();
    ae.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        this.nus[i].setVisibility(0);
        char c = paramString.charAt(i);
        this.nus[i].setText(String.valueOf(c));
        this.nur[i].setVisibility(4);
        i += 1;
      }
      AppMethodBeat.o(131591);
      return;
    }
    int i = 0;
    while (i < 6)
    {
      this.nus[i].setVisibility(4);
      this.nus[i].setText("");
      this.nur[i].setVisibility(0);
      i += 1;
    }
    AppMethodBeat.o(131591);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView
 * JD-Core Version:    0.7.0.1
 */