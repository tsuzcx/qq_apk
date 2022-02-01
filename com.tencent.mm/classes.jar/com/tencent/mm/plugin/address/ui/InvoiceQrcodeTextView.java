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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class InvoiceQrcodeTextView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private boolean bcF;
  private int editType;
  private int fl;
  private int inputType;
  private TextView pls;
  private View.OnFocusChangeListener qiH;
  private ImageView qiJ;
  private String qiK;
  private String qiL;
  private int qiM;
  private int qiN;
  public boolean qiO;
  private int qiP;
  public boolean qiQ;
  private int qiR;
  private int qiS;
  private View.OnClickListener qiT;
  private String qiU;
  public boolean qiW;
  private int qja;
  public boolean qjb;
  private a qjo;
  private c qjp;
  private b qjq;
  TextView qjr;
  private int qjs;
  private int qjt;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20929);
    this.qiW = false;
    this.qiK = "";
    this.qiL = "";
    this.inputType = 1;
    this.qja = 0;
    this.fl = 19;
    this.editType = -1;
    this.background = -1;
    this.qiN = -1;
    this.qiO = true;
    this.qjb = true;
    this.qiQ = false;
    this.qiR = 0;
    this.qiS = 100;
    this.bcF = true;
    this.qiT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(267172);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (InvoiceQrcodeTextView.c(InvoiceQrcodeTextView.this).getVisibility() == 0)
        {
          if ((!InvoiceQrcodeTextView.this.qiO) || (InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this) == 2) || (Util.isNullOrNil(InvoiceQrcodeTextView.this.getText()))) {
            break label128;
          }
          InvoiceQrcodeTextView.this.qjr.setText("");
          InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.e(InvoiceQrcodeTextView.this).isFocused());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(267172);
          return;
          label128:
          if (InvoiceQrcodeTextView.f(InvoiceQrcodeTextView.this) != null) {
            InvoiceQrcodeTextView.f(InvoiceQrcodeTextView.this);
          }
        }
      }
    };
    this.qiU = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.ham, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(R.n.hat, 0);
    if (paramInt != 0) {
      this.qiK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(R.n.hax, 0);
    if (paramInt != 0) {
      this.qiL = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(R.n.hap, 1);
    this.editType = paramAttributeSet.getInteger(R.n.har, 0);
    this.qiO = paramAttributeSet.getBoolean(R.n.has, true);
    this.fl = paramAttributeSet.getInt(R.n.han, 19);
    this.qiM = paramAttributeSet.getInteger(R.n.haq, 5);
    this.background = paramAttributeSet.getResourceId(R.n.hao, R.g.transparent_background);
    this.qiP = paramAttributeSet.getResourceId(R.n.hav, -1);
    this.qiN = paramAttributeSet.getResourceId(R.n.hau, R.g.transparent_background);
    this.bcF = paramAttributeSet.getBoolean(R.n.haw, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.gkD, this, true);
    this.qjr = ((TextView)paramAttributeSet.findViewById(R.h.hint_et));
    this.qjr.setTextSize(0, com.tencent.mm.cd.a.br(paramContext, R.f.NormalTextSize));
    this.pls = ((TextView)paramAttributeSet.findViewById(R.h.tip_tv));
    this.qiJ = ((ImageView)paramAttributeSet.findViewById(R.h.info_iv));
    this.qiJ.setOnClickListener(this.qiT);
    this.qjr.setImeOptions(this.qiM);
    if (!Util.isNullOrNil(this.qiK)) {
      this.qjr.setHint(this.qiK);
    }
    if (!Util.isNullOrNil(this.qiL)) {
      this.pls.setText(this.qiL);
    }
    paramContext = new Rect();
    d(this.qjr, paramContext);
    e(this.qjr, paramContext);
    setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.qiP != -1) {
      this.qiJ.setImageResource(this.qiP);
    }
    if (!this.bcF) {
      this.qjr.setSingleLine(false);
    }
    this.qjr.setOnTouchListener(new InvoiceQrcodeTextView.1(this));
    this.qjr.setOnLongClickListener(new InvoiceQrcodeTextView.2(this));
    AppMethodBeat.o(20929);
  }
  
  private static void d(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20948);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(20948);
  }
  
  private static void e(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20949);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(20949);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20947);
    Rect localRect = new Rect();
    this.qiJ.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20947);
    return localRect;
  }
  
  private void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(20936);
    if ((this.qiO) && (!Util.isNullOrNil(getText())))
    {
      this.qiJ.setImageResource(R.g.list_clear);
      this.qiJ.setContentDescription(getContext().getString(R.l.clear_btn));
      switch (this.editType)
      {
      default: 
        this.qiJ.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.qiJ.setVisibility(0);
          AppMethodBeat.o(20936);
          return;
        }
        this.qiJ.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 3: 
        this.qiJ.setVisibility(0);
        this.qiJ.setContentDescription(getContext().getString(R.l.address_location));
        AppMethodBeat.o(20936);
        return;
      }
      this.qiJ.setVisibility(0);
      this.qiJ.setContentDescription(getContext().getString(R.l.address_contact));
      AppMethodBeat.o(20936);
      return;
    }
    switch (this.editType)
    {
    default: 
      this.qiJ.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.qiJ.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 3: 
      this.qiJ.setVisibility(0);
      this.qiJ.setContentDescription(getContext().getString(R.l.address_location));
      AppMethodBeat.o(20936);
      return;
    }
    this.qiJ.setVisibility(0);
    this.qiJ.setContentDescription(getContext().getString(R.l.address_contact));
    AppMethodBeat.o(20936);
  }
  
  public final void bZs()
  {
    AppMethodBeat.i(20930);
    setBackgroundResource(0);
    this.pls.setTextColor(getResources().getColor(R.e.hint_text_color));
    this.qjr.setTextColor(getResources().getColor(R.e.normal_text_color));
    this.qjr.setInputType(0);
    this.qjr.clearFocus();
    this.qjr.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.qjr.getWindowToken(), 0);
    AppMethodBeat.o(20930);
  }
  
  public String getText()
  {
    AppMethodBeat.i(20931);
    String str = this.qjr.getText().toString();
    AppMethodBeat.o(20931);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20938);
    if (this.qiH != null) {
      this.qiH.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.InvoiceEditView", "View:" + this.qiL + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
    if (!this.qiQ)
    {
      this.pls.setEnabled(false);
      if (paramView == this.qjr)
      {
        paramView = new Rect();
        d(this, paramView);
        if (!paramBoolean) {
          break label148;
        }
        setBackgroundResource(R.g.input_bar_bg_active);
      }
    }
    for (;;)
    {
      e(this, paramView);
      hS(paramBoolean);
      AppMethodBeat.o(20938);
      return;
      this.pls.setEnabled(true);
      break;
      label148:
      setBackgroundResource(R.g.input_bar_bg_normal);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20934);
    int i;
    if (!this.qiO)
    {
      if (this.qiJ.getVisibility() != 0) {
        break label63;
      }
      i = 1;
      if (i == 0) {
        break label73;
      }
      if (!getValidRectOfInfoIv().contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        break label68;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label78;
      }
      AppMethodBeat.o(20934);
      return false;
      label63:
      i = 0;
      break;
      label68:
      i = 0;
      continue;
      label73:
      i = 0;
    }
    label78:
    AppMethodBeat.o(20934);
    return true;
  }
  
  public void setBankNumberValStr(String paramString)
  {
    AppMethodBeat.i(20942);
    String str1 = paramString;
    if (this.editType == 5)
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
    this.qjr.setText(str1);
    AppMethodBeat.o(20942);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20943);
    if (this.qjr != null)
    {
      Rect localRect = new Rect();
      d(this.qjr, localRect);
      this.qjr.setBackgroundResource(paramInt);
      e(this.qjr, localRect);
    }
    AppMethodBeat.o(20943);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20932);
    this.qjr.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20932);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20933);
    super.setEnabled(paramBoolean);
    this.qiO = paramBoolean;
    this.qiJ.setEnabled(true);
    AppMethodBeat.o(20933);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20939);
    this.qjr.setHint(paramString);
    AppMethodBeat.o(20939);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20945);
    this.qjr.setImeOptions(paramInt);
    AppMethodBeat.o(20945);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.qjo = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20946);
    this.qiJ.setVisibility(paramInt);
    AppMethodBeat.o(20946);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(20935);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(20935);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(20937);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.qiH = paramOnFocusChangeListener;
    AppMethodBeat.o(20937);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.qjq = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.qjp = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20940);
    this.pls.setText(paramString);
    AppMethodBeat.o(20940);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20944);
    if (this.pls != null) {
      this.pls.setTextColor(paramInt);
    }
    AppMethodBeat.o(20944);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20941);
    this.qjr.setText(paramString);
    this.qiU = paramString;
    AppMethodBeat.o(20941);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView
 * JD-Core Version:    0.7.0.1
 */