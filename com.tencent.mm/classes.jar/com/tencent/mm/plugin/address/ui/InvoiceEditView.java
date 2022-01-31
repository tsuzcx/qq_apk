package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
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

public class InvoiceEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background = -1;
  private int fuA = 0;
  public boolean fuB = true;
  private View.OnFocusChangeListener fuf;
  private TextView fug;
  EditText fuh;
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
  private View.OnClickListener fut = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0) && (InvoiceEditView.this.fun) && (InvoiceEditView.a(InvoiceEditView.this) != 2) && (!bk.bl(InvoiceEditView.this.getText())))
      {
        InvoiceEditView.this.fuh.setText("");
        InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
      }
    }
  };
  private String fuu = null;
  public boolean fuw = false;
  private InvoiceEditView.a fux;
  private InvoiceEditView.c fuy;
  private b fuz;
  private int gravity = 19;
  private int imeOptions;
  private int inputType = 1;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.invoice_edit_view, this, true);
    this.fuh = ((EditText)paramAttributeSet.findViewById(R.h.hint_et));
    this.fuh.setTextSize(0, a.aa(paramContext, R.f.NormalTextSize));
    this.fug = ((TextView)paramAttributeSet.findViewById(R.h.tip_tv));
    this.fui = ((ImageView)paramAttributeSet.findViewById(R.h.info_iv));
    this.fui.setOnClickListener(this.fut);
    this.fuh.setImeOptions(this.imeOptions);
    this.fuh.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.fuh.setKeyListener(new InvoiceEditView.1(this));
      cB(this.fuh.isFocused());
      this.fuh.addTextChangedListener(new InvoiceEditView.3(this));
      this.fuh.setOnFocusChangeListener(this);
      if (!bk.bl(this.fuj)) {
        this.fuh.setHint(this.fuj);
      }
      if (!bk.bl(this.fuk)) {
        this.fug.setText(this.fuk);
      }
      paramContext = new Rect();
      h(this.fuh, paramContext);
      if (this.fun) {
        break label673;
      }
      this.fuh.setEnabled(false);
      this.fuh.setTextColor(getResources().getColor(R.e.address_link_color));
      this.fuh.setFocusable(false);
      this.fuh.setClickable(false);
      this.fuh.setBackgroundResource(R.g.transparent_background);
      if (this.fuB) {
        setBackgroundResource(R.g.comm_list_item_selector);
      }
      setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.fuh, paramContext);
      if (this.fuo != -1) {
        this.fui.setImageResource(this.fuo);
      }
      if (!this.fus) {
        this.fuh.setSingleLine(false);
      }
      return;
      if (this.inputType == 3)
      {
        this.fuh.setKeyListener(new InvoiceEditView.2(this));
        break;
      }
      this.fuh.setInputType(this.inputType);
      break;
      label673:
      this.fup = false;
      this.fuh.setBackgroundResource(this.fum);
      setBackgroundResource(this.background);
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
  
  public final boolean YL()
  {
    String str = this.fuh.getText().toString();
    switch (this.ful)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() < this.fuq) || (str.length() > this.fur)) {
        break;
      }
    case 0: 
    case 1: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
            } while ((str.length() >= this.fuq) && (str.length() <= this.fur));
            return false;
          } while ((str.length() == 0) || ((str.length() >= this.fuq) && (str.length() <= this.fur)));
          return false;
        } while (str.length() <= 100);
        return false;
      } while (str.length() <= 48);
      return false;
    }
    return false;
  }
  
  public final boolean YM()
  {
    return !getText().equals(bk.pm(this.fuu));
  }
  
  public String getText()
  {
    return this.fuh.getText().toString();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.fuf != null) {
      this.fuf.onFocusChange(this, paramBoolean);
    }
    y.d("MicroMsg.InvoiceEditView", "View:" + this.fuk + ", editType:" + this.ful + " onFocusChange to " + paramBoolean);
    if (this.fuy != null) {
      this.fuy.YI();
    }
    if (!this.fup)
    {
      this.fug.setEnabled(false);
      if (paramView == this.fuh)
      {
        paramView = new Rect();
        h(this, paramView);
        if (!paramBoolean) {
          break label152;
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
      label152:
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
    int i = 0;
    int j = 0;
    String str1 = paramString;
    if (this.ful == 5)
    {
      String str2 = paramString.replace(" ", "");
      str1 = paramString;
      if (str2.length() >= 4)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (str2.length() % 4 == 0)
        {
          i = j;
          for (;;)
          {
            str1 = paramString;
            if (i >= str2.length() / 4 - 1) {
              break;
            }
            localStringBuilder.append(str2.substring(i * 4, (i + 1) * 4)).append(" ");
            i += 1;
          }
        }
        while (i < str2.length() / 4)
        {
          localStringBuilder.append(str2.substring(i * 4, (i + 1) * 4)).append(" ");
          i += 1;
        }
        str1 = str2.substring(str2.length() / 4 * 4, str2.length());
      }
    }
    this.fuh.setText(str1);
    this.fuh.setSelection(this.fuh.getText().length());
  }
  
  public void setEditBG(int paramInt)
  {
    if (this.fuh != null)
    {
      Rect localRect = new Rect();
      h(this.fuh, localRect);
      this.fuh.setBackgroundResource(paramInt);
      i(this.fuh, localRect);
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    this.fuh.setEllipsize(paramTruncateAt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.fun = paramBoolean;
    this.fui.setEnabled(true);
  }
  
  public void setHintStr(String paramString)
  {
    this.fuh.setHint(paramString);
  }
  
  public void setImeOptions(int paramInt)
  {
    this.fuh.setImeOptions(paramInt);
  }
  
  public void setInfoIvOnClickListener(InvoiceEditView.a parama)
  {
    this.fux = parama;
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
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.fuz = paramb;
  }
  
  public void setOnInputValidChangeListener(InvoiceEditView.c paramc)
  {
    this.fuy = paramc;
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
    this.fuh.setText(paramString);
    this.fuh.setSelection(this.fuh.getText().length());
    this.fuu = paramString;
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */