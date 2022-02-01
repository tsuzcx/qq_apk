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
import com.tencent.mm.sdk.platformtools.ac;

public class EditVerifyCodeView
  extends RelativeLayout
{
  private StringBuilder mBuilder;
  private Context mContext;
  private ImageView[] mOK;
  private TextView[] mOL;
  private VerifyCodeEditText mOM;
  View.OnKeyListener mON;
  public a mOO;
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131588);
    this.mBuilder = new StringBuilder();
    this.mOK = new ImageView[6];
    this.mOL = new TextView[6];
    this.mON = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(131587);
        if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 1))
        {
          EditVerifyCodeView.c(EditVerifyCodeView.this);
          AppMethodBeat.o(131587);
          return true;
        }
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
    this.mOK = new ImageView[6];
    this.mOL = new TextView[6];
    this.mON = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(131587);
        if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 1))
        {
          EditVerifyCodeView.c(EditVerifyCodeView.this);
          AppMethodBeat.o(131587);
          return true;
        }
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
    this.mOL[0] = localObject1;
    this.mOL[1] = localObject2;
    this.mOL[2] = localObject3;
    this.mOL[3] = localObject4;
    this.mOL[4] = localObject5;
    this.mOL[5] = localObject6;
    localObject1 = (ImageView)paramContext.findViewById(2131298389);
    localObject2 = (ImageView)paramContext.findViewById(2131298390);
    localObject3 = (ImageView)paramContext.findViewById(2131298391);
    localObject4 = (ImageView)paramContext.findViewById(2131298392);
    localObject5 = (ImageView)paramContext.findViewById(2131298393);
    localObject6 = (ImageView)paramContext.findViewById(2131298394);
    this.mOK[0] = localObject1;
    this.mOK[1] = localObject2;
    this.mOK[2] = localObject3;
    this.mOK[3] = localObject4;
    this.mOK[4] = localObject5;
    this.mOK[5] = localObject6;
    this.mOM = ((VerifyCodeEditText)paramContext.findViewById(2131306284));
    this.mOM.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(131586);
        if ((paramAnonymousEditable == null) || (paramAnonymousEditable.length() == 0))
        {
          AppMethodBeat.o(131586);
          return;
        }
        ac.i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", new Object[] { paramAnonymousEditable.toString() });
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
    this.mOM.setKeyListener(new NumberKeyListener()
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
    this.mOM.setOnKeyListener(this.mON);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(131592);
  }
  
  public VerifyCodeEditText getEditText()
  {
    return this.mOM;
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
    this.mOO = parama;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(131591);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.mBuilder.append(paramString);
    paramString = this.mBuilder.toString();
    int j = paramString.length();
    ac.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        this.mOL[i].setVisibility(0);
        char c = paramString.charAt(i);
        this.mOL[i].setText(String.valueOf(c));
        this.mOK[i].setVisibility(4);
        i += 1;
      }
      AppMethodBeat.o(131591);
      return;
    }
    int i = 0;
    while (i < 6)
    {
      this.mOL[i].setVisibility(4);
      this.mOL[i].setText("");
      this.mOK[i].setVisibility(0);
      i += 1;
    }
    AppMethodBeat.o(131591);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView
 * JD-Core Version:    0.7.0.1
 */