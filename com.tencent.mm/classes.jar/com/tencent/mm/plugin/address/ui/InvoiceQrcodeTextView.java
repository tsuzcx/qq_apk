package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.n;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class InvoiceQrcodeTextView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background = -1;
  private int fuA = 0;
  public boolean fuB = true;
  private InvoiceQrcodeTextView.a fuQ;
  private InvoiceQrcodeTextView.c fuR;
  private InvoiceQrcodeTextView.b fuS;
  TextView fuT;
  private View.OnFocusChangeListener fuf;
  private TextView fug;
  private ImageView fui;
  private String fuj = "";
  private String fuk = "";
  private int ful = -1;
  private int fum = -1;
  public boolean fun = true;
  private int fuo;
  public boolean fup = false;
  private int fuq = 0;
  private int fur = 100;
  private boolean fus = true;
  private View.OnClickListener fut = new InvoiceQrcodeTextView.1(this);
  private String fuu = null;
  public boolean fuw = false;
  private int gravity = 19;
  private int imeOptions;
  private int inputType = 1;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.InvoiceEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(R.n.InvoiceEditView_invoice_hint, 0);
    if (paramInt != 0) {
      this.fuj = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(R.n.InvoiceEditView_invoice_tipmsg, 0);
    if (paramInt != 0) {
      this.fuk = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(R.n.InvoiceEditView_android_inputType, 1);
    this.ful = paramAttributeSet.getInteger(R.n.InvoiceEditView_invoice_editType, 0);
    this.fun = paramAttributeSet.getBoolean(R.n.InvoiceEditView_invoice_editable, true);
    this.gravity = paramAttributeSet.getInt(R.n.InvoiceEditView_android_gravity, 19);
    this.imeOptions = paramAttributeSet.getInteger(R.n.InvoiceEditView_android_imeOptions, 5);
    this.background = paramAttributeSet.getResourceId(R.n.InvoiceEditView_android_background, R.g.transparent_background);
    this.fuo = paramAttributeSet.getResourceId(R.n.InvoiceEditView_invoice_infoBackground, -1);
    this.fum = paramAttributeSet.getResourceId(R.n.InvoiceEditView_invoice_hintTextBg, R.g.transparent_background);
    this.fus = paramAttributeSet.getBoolean(R.n.InvoiceEditView_invoice_singleLine, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.invoice_qrcode_text_view, this, true);
    this.fuT = ((TextView)paramAttributeSet.findViewById(R.h.hint_et));
    this.fuT.setTextSize(0, a.aa(paramContext, R.f.NormalTextSize));
    this.fug = ((TextView)paramAttributeSet.findViewById(R.h.tip_tv));
    this.fui = ((ImageView)paramAttributeSet.findViewById(R.h.info_iv));
    this.fui.setOnClickListener(this.fut);
    this.fuT.setImeOptions(this.imeOptions);
    if (!bk.bl(this.fuj)) {
      this.fuT.setHint(this.fuj);
    }
    if (!bk.bl(this.fuk)) {
      this.fug.setText(this.fuk);
    }
    paramContext = new Rect();
    h(this.fuT, paramContext);
    i(this.fuT, paramContext);
    setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.fuo != -1) {
      this.fui.setImageResource(this.fuo);
    }
    if (!this.fus) {
      this.fuT.setSingleLine(false);
    }
  }
  
  private void cB(boolean paramBoolean)
  {
    if ((this.fun) && (!bk.bl(getText())))
    {
      this.fui.setImageResource(R.g.list_clear);
      this.fui.setContentDescription(getContext().getString(R.l.clear_btn));
      switch (this.ful)
      {
      default: 
        this.fui.setVisibility(8);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.fui.setVisibility(0);
          return;
        }
        this.fui.setVisibility(8);
        return;
      case 3: 
        this.fui.setVisibility(0);
        this.fui.setContentDescription(getContext().getString(R.l.address_location));
        return;
      }
      this.fui.setVisibility(0);
      this.fui.setContentDescription(getContext().getString(R.l.address_contact));
      return;
    }
    switch (this.ful)
    {
    default: 
      this.fui.setVisibility(8);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.fui.setVisibility(8);
      return;
    case 3: 
      this.fui.setVisibility(0);
      this.fui.setContentDescription(getContext().getString(R.l.address_location));
      return;
    }
    this.fui.setVisibility(0);
    this.fui.setContentDescription(getContext().getString(R.l.address_contact));
  }
  
  private Rect getValidRectOfInfoIv()
  {
    Rect localRect = new Rect();
    this.fui.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    return localRect;
  }
  
  private static void h(View paramView, Rect paramRect)
  {
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
  }
  
  private static void i(View paramView, Rect paramRect)
  {
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public final void YO()
  {
    setBackgroundResource(0);
    this.fug.setTextColor(getResources().getColor(R.e.semitransparent));
    this.fuT.setTextColor(getResources().getColor(R.e.black));
    this.fuT.setInputType(0);
    this.fuT.clearFocus();
    this.fuT.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.fuT.getWindowToken(), 0);
  }
  
  public String getText()
  {
    return this.fuT.getText().toString();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.fuf != null) {
      this.fuf.onFocusChange(this, paramBoolean);
    }
    y.d("MicroMsg.InvoiceEditView", "View:" + this.fuk + ", editType:" + this.ful + " onFocusChange to " + paramBoolean);
    if (!this.fup)
    {
      this.fug.setEnabled(false);
      if (paramView == this.fuT)
      {
        paramView = new Rect();
        h(this, paramView);
        if (!paramBoolean) {
          break label136;
        }
        setBackgroundResource(R.g.input_bar_bg_active);
      }
    }
    for (;;)
    {
      i(this, paramView);
      cB(paramBoolean);
      return;
      this.fug.setEnabled(true);
      break;
      label136:
      setBackgroundResource(R.g.input_bar_bg_normal);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i;
    if (!this.fun)
    {
      if (this.fui.getVisibility() != 0) {
        break label55;
      }
      i = 1;
      if (i == 0) {
        break label65;
      }
      if (!getValidRectOfInfoIv().contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        break label60;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        bool = false;
      }
      return bool;
      label55:
      i = 0;
      break;
      label60:
      i = 0;
      continue;
      label65:
      i = 0;
    }
  }
  
  public void setBankNumberValStr(String paramString)
  {
    String str1 = paramString;
    if (this.ful == 5)
    {
      String str2 = paramString.replace(" ", "");
      str1 = paramString;
      if (str2.length() >= 4)
      {
        paramString = new StringBuilder();
        int i = 0;
        while (i < str2.length() / 4)
        {
          paramString.append(str2.substring(i * 4, (i + 1) * 4)).append(" ");
          i += 1;
        }
        str1 = str2.substring(str2.length() / 4 * 4, str2.length());
      }
    }
    this.fuT.setText(str1);
  }
  
  public void setEditBG(int paramInt)
  {
    if (this.fuT != null)
    {
      Rect localRect = new Rect();
      h(this.fuT, localRect);
      this.fuT.setBackgroundResource(paramInt);
      i(this.fuT, localRect);
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    this.fuT.setEllipsize(paramTruncateAt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.fun = paramBoolean;
    this.fui.setEnabled(true);
  }
  
  public void setHintStr(String paramString)
  {
    this.fuT.setHint(paramString);
  }
  
  public void setImeOptions(int paramInt)
  {
    this.fuT.setImeOptions(paramInt);
  }
  
  public void setInfoIvOnClickListener(InvoiceQrcodeTextView.a parama)
  {
    this.fuQ = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    this.fui.setVisibility(paramInt);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.fuf = paramOnFocusChangeListener;
  }
  
  public void setOnInputInvoiceTypeChangeListener(InvoiceQrcodeTextView.b paramb)
  {
    this.fuS = paramb;
  }
  
  public void setOnInputValidChangeListener(InvoiceQrcodeTextView.c paramc)
  {
    this.fuR = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    this.fug.setText(paramString);
  }
  
  public void setTipTextColor(int paramInt)
  {
    if (this.fug != null) {
      this.fug.setTextColor(paramInt);
    }
  }
  
  public void setValStr(String paramString)
  {
    this.fuT.setText(paramString);
    this.fuu = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView
 * JD-Core Version:    0.7.0.1
 */