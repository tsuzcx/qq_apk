package com.tencent.mm.plugin.appbrand.widget.sms;

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
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.platformtools.y;

public class EditVerifyCodeView
  extends RelativeLayout
{
  private ImageView[] hDX = new ImageView[6];
  private TextView[] hDY = new TextView[6];
  View.OnKeyListener hDZ = new EditVerifyCodeView.3(this);
  public EditVerifyCodeView.a hEa;
  private EditText ln;
  private StringBuilder mBuilder = new StringBuilder();
  private Context mContext;
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public EditVerifyCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(y.h.edit_verify_code_layout, null);
    Object localObject1 = (TextView)paramContext.findViewById(y.g.code_text_1);
    Object localObject2 = (TextView)paramContext.findViewById(y.g.code_text_2);
    Object localObject3 = (TextView)paramContext.findViewById(y.g.code_text_3);
    Object localObject4 = (TextView)paramContext.findViewById(y.g.code_text_4);
    Object localObject5 = (TextView)paramContext.findViewById(y.g.code_text_5);
    Object localObject6 = (TextView)paramContext.findViewById(y.g.code_text_6);
    this.hDY[0] = localObject1;
    this.hDY[1] = localObject2;
    this.hDY[2] = localObject3;
    this.hDY[3] = localObject4;
    this.hDY[4] = localObject5;
    this.hDY[5] = localObject6;
    localObject1 = (ImageView)paramContext.findViewById(y.g.code_img_1);
    localObject2 = (ImageView)paramContext.findViewById(y.g.code_img_2);
    localObject3 = (ImageView)paramContext.findViewById(y.g.code_img_3);
    localObject4 = (ImageView)paramContext.findViewById(y.g.code_img_4);
    localObject5 = (ImageView)paramContext.findViewById(y.g.code_img_5);
    localObject6 = (ImageView)paramContext.findViewById(y.g.code_img_6);
    this.hDX[0] = localObject1;
    this.hDX[1] = localObject2;
    this.hDX[2] = localObject3;
    this.hDX[3] = localObject4;
    this.hDX[4] = localObject5;
    this.hDX[5] = localObject6;
    this.ln = ((EditText)paramContext.findViewById(y.g.verify_code_edittext));
    this.ln.addTextChangedListener(new EditVerifyCodeView.1(this));
    this.ln.setKeyListener(new EditVerifyCodeView.2(this));
    this.ln.setOnKeyListener(this.hDZ);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public String getText()
  {
    return this.mBuilder.toString();
  }
  
  public void setCodeEditCompleListener(EditVerifyCodeView.a parama)
  {
    this.hEa = parama;
  }
  
  public void setText(String paramString)
  {
    this.mBuilder.delete(0, this.mBuilder.length());
    this.mBuilder.append(paramString);
    paramString = this.mBuilder.toString();
    int j = paramString.length();
    y.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        this.hDY[i].setVisibility(0);
        char c = paramString.charAt(i);
        this.hDY[i].setText(String.valueOf(c));
        this.hDX[i].setVisibility(4);
        i += 1;
      }
    }
    int i = 0;
    while (i < 6)
    {
      this.hDY[i].setVisibility(4);
      this.hDY[i].setText("");
      this.hDX[i].setVisibility(0);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView
 * JD-Core Version:    0.7.0.1
 */