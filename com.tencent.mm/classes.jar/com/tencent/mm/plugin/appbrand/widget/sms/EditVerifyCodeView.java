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
import com.tencent.mm.sdk.platformtools.ad;

public class EditVerifyCodeView
  extends RelativeLayout
{
  private StringBuilder mBuilder;
  private Context mContext;
  private ImageView[] nph;
  private TextView[] npi;
  private VerifyCodeEditText npj;
  View.OnKeyListener npk;
  public a npl;
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131588);
    this.mBuilder = new StringBuilder();
    this.nph = new ImageView[6];
    this.npi = new TextView[6];
    this.npk = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(131587);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
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
    ef(paramContext);
    AppMethodBeat.o(131588);
  }
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(131589);
    this.mBuilder = new StringBuilder();
    this.nph = new ImageView[6];
    this.npi = new TextView[6];
    this.npk = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(131587);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
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
    ef(paramContext);
    AppMethodBeat.o(131589);
  }
  
  @SuppressLint({"InflateParams"})
  private void ef(Context paramContext)
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
    this.npi[0] = localObject1;
    this.npi[1] = localObject2;
    this.npi[2] = localObject3;
    this.npi[3] = localObject4;
    this.npi[4] = localObject5;
    this.npi[5] = localObject6;
    localObject1 = (ImageView)paramContext.findViewById(2131298389);
    localObject2 = (ImageView)paramContext.findViewById(2131298390);
    localObject3 = (ImageView)paramContext.findViewById(2131298391);
    localObject4 = (ImageView)paramContext.findViewById(2131298392);
    localObject5 = (ImageView)paramContext.findViewById(2131298393);
    localObject6 = (ImageView)paramContext.findViewById(2131298394);
    this.nph[0] = localObject1;
    this.nph[1] = localObject2;
    this.nph[2] = localObject3;
    this.nph[3] = localObject4;
    this.nph[4] = localObject5;
    this.nph[5] = localObject6;
    this.npj = ((VerifyCodeEditText)paramContext.findViewById(2131306284));
    this.npj.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(131586);
        if ((paramAnonymousEditable == null) || (paramAnonymousEditable.length() == 0))
        {
          AppMethodBeat.o(131586);
          return;
        }
        ad.i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", new Object[] { paramAnonymousEditable.toString() });
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
    this.npj.setKeyListener(new NumberKeyListener()
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
    this.npj.setOnKeyListener(this.npk);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(131592);
  }
  
  public VerifyCodeEditText getEditText()
  {
    return this.npj;
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
    this.npl = parama;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(131591);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.mBuilder.append(paramString);
    paramString = this.mBuilder.toString();
    int j = paramString.length();
    ad.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        this.npi[i].setVisibility(0);
        char c = paramString.charAt(i);
        this.npi[i].setText(String.valueOf(c));
        this.nph[i].setVisibility(4);
        i += 1;
      }
      AppMethodBeat.o(131591);
      return;
    }
    int i = 0;
    while (i < 6)
    {
      this.npi[i].setVisibility(4);
      this.npi[i].setText("");
      this.nph[i].setVisibility(0);
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