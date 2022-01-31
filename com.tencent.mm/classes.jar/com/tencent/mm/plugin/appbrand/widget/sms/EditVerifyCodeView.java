package com.tencent.mm.plugin.appbrand.widget.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class EditVerifyCodeView
  extends RelativeLayout
{
  public EditVerifyCodeView.a jwA;
  private ImageView[] jwx;
  private TextView[] jwy;
  View.OnKeyListener jwz;
  private StringBuilder mBuilder;
  private Context mContext;
  private EditText mEditText;
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134404);
    this.mBuilder = new StringBuilder();
    this.jwx = new ImageView[6];
    this.jwy = new TextView[6];
    this.jwz = new EditVerifyCodeView.3(this);
    dv(paramContext);
    AppMethodBeat.o(134404);
  }
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134405);
    this.mBuilder = new StringBuilder();
    this.jwx = new ImageView[6];
    this.jwy = new TextView[6];
    this.jwz = new EditVerifyCodeView.3(this);
    dv(paramContext);
    AppMethodBeat.o(134405);
  }
  
  @SuppressLint({"InflateParams"})
  private void dv(Context paramContext)
  {
    AppMethodBeat.i(134408);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2130969353, null);
    Object localObject1 = (TextView)paramContext.findViewById(2131823501);
    Object localObject2 = (TextView)paramContext.findViewById(2131823503);
    Object localObject3 = (TextView)paramContext.findViewById(2131823505);
    Object localObject4 = (TextView)paramContext.findViewById(2131823507);
    Object localObject5 = (TextView)paramContext.findViewById(2131823509);
    Object localObject6 = (TextView)paramContext.findViewById(2131823511);
    this.jwy[0] = localObject1;
    this.jwy[1] = localObject2;
    this.jwy[2] = localObject3;
    this.jwy[3] = localObject4;
    this.jwy[4] = localObject5;
    this.jwy[5] = localObject6;
    localObject1 = (ImageView)paramContext.findViewById(2131823502);
    localObject2 = (ImageView)paramContext.findViewById(2131823504);
    localObject3 = (ImageView)paramContext.findViewById(2131823506);
    localObject4 = (ImageView)paramContext.findViewById(2131823508);
    localObject5 = (ImageView)paramContext.findViewById(2131823510);
    localObject6 = (ImageView)paramContext.findViewById(2131823512);
    this.jwx[0] = localObject1;
    this.jwx[1] = localObject2;
    this.jwx[2] = localObject3;
    this.jwx[3] = localObject4;
    this.jwx[4] = localObject5;
    this.jwx[5] = localObject6;
    this.mEditText = ((EditText)paramContext.findViewById(2131823513));
    this.mEditText.addTextChangedListener(new EditVerifyCodeView.1(this));
    this.mEditText.setKeyListener(new EditVerifyCodeView.2(this));
    this.mEditText.setOnKeyListener(this.jwz);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(134408);
  }
  
  public String getText()
  {
    AppMethodBeat.i(134406);
    String str = this.mBuilder.toString();
    AppMethodBeat.o(134406);
    return str;
  }
  
  public void setCodeEditCompleListener(EditVerifyCodeView.a parama)
  {
    this.jwA = parama;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(134407);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.mBuilder.append(paramString);
    paramString = this.mBuilder.toString();
    int j = paramString.length();
    ab.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        this.jwy[i].setVisibility(0);
        char c = paramString.charAt(i);
        this.jwy[i].setText(String.valueOf(c));
        this.jwx[i].setVisibility(4);
        i += 1;
      }
      AppMethodBeat.o(134407);
      return;
    }
    int i = 0;
    while (i < 6)
    {
      this.jwy[i].setVisibility(4);
      this.jwy[i].setText("");
      this.jwx[i].setVisibility(0);
      i += 1;
    }
    AppMethodBeat.o(134407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView
 * JD-Core Version:    0.7.0.1
 */