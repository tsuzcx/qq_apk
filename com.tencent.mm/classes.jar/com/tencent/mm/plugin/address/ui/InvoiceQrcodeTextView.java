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
import com.tencent.mm.R.a;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class InvoiceQrcodeTextView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private View.OnFocusChangeListener gLH;
  private TextView gLI;
  private ImageView gLK;
  private String gLL;
  private String gLM;
  private int gLN;
  private int gLO;
  public boolean gLP;
  private int gLQ;
  public boolean gLR;
  private int gLS;
  private int gLT;
  private boolean gLU;
  private View.OnClickListener gLV;
  private String gLW;
  public boolean gLY;
  private int gMc;
  public boolean gMd;
  private a gMs;
  private InvoiceQrcodeTextView.c gMt;
  private InvoiceQrcodeTextView.b gMu;
  TextView gMv;
  private int gravity;
  private int imeOptions;
  private int inputType;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(16886);
    this.gLY = false;
    this.gLL = "";
    this.gLM = "";
    this.inputType = 1;
    this.gMc = 0;
    this.gravity = 19;
    this.gLN = -1;
    this.background = -1;
    this.gLO = -1;
    this.gLP = true;
    this.gMd = true;
    this.gLR = false;
    this.gLS = 0;
    this.gLT = 100;
    this.gLU = true;
    this.gLV = new InvoiceQrcodeTextView.2(this);
    this.gLW = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.InvoiceEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(5, 0);
    if (paramInt != 0) {
      this.gLL = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(6, 0);
    if (paramInt != 0) {
      this.gLM = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(3, 1);
    this.gLN = paramAttributeSet.getInteger(7, 0);
    this.gLP = paramAttributeSet.getBoolean(10, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.imeOptions = paramAttributeSet.getInteger(4, 5);
    this.background = paramAttributeSet.getResourceId(1, 2130840999);
    this.gLQ = paramAttributeSet.getResourceId(12, -1);
    this.gLO = paramAttributeSet.getResourceId(9, 2130840999);
    this.gLU = paramAttributeSet.getBoolean(13, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2130969918, this, true);
    this.gMv = ((TextView)paramAttributeSet.findViewById(2131821072));
    this.gMv.setTextSize(0, a.ao(paramContext, 2131427809));
    this.gLI = ((TextView)paramAttributeSet.findViewById(2131821071));
    this.gLK = ((ImageView)paramAttributeSet.findViewById(2131821073));
    this.gLK.setOnClickListener(this.gLV);
    this.gMv.setImeOptions(this.imeOptions);
    if (!bo.isNullOrNil(this.gLL)) {
      this.gMv.setHint(this.gLL);
    }
    if (!bo.isNullOrNil(this.gLM)) {
      this.gLI.setText(this.gLM);
    }
    paramContext = new Rect();
    i(this.gMv, paramContext);
    j(this.gMv, paramContext);
    setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.gLQ != -1) {
      this.gLK.setImageResource(this.gLQ);
    }
    if (!this.gLU) {
      this.gMv.setSingleLine(false);
    }
    this.gMv.setOnLongClickListener(new InvoiceQrcodeTextView.1(this));
    AppMethodBeat.o(16886);
  }
  
  private void dD(boolean paramBoolean)
  {
    AppMethodBeat.i(16893);
    if ((this.gLP) && (!bo.isNullOrNil(getText())))
    {
      this.gLK.setImageResource(2130839272);
      this.gLK.setContentDescription(getContext().getString(2131298408));
      switch (this.gLN)
      {
      default: 
        this.gLK.setVisibility(8);
        AppMethodBeat.o(16893);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.gLK.setVisibility(0);
          AppMethodBeat.o(16893);
          return;
        }
        this.gLK.setVisibility(8);
        AppMethodBeat.o(16893);
        return;
      case 3: 
        this.gLK.setVisibility(0);
        this.gLK.setContentDescription(getContext().getString(2131296479));
        AppMethodBeat.o(16893);
        return;
      }
      this.gLK.setVisibility(0);
      this.gLK.setContentDescription(getContext().getString(2131296451));
      AppMethodBeat.o(16893);
      return;
    }
    switch (this.gLN)
    {
    default: 
      this.gLK.setVisibility(8);
      AppMethodBeat.o(16893);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.gLK.setVisibility(8);
      AppMethodBeat.o(16893);
      return;
    case 3: 
      this.gLK.setVisibility(0);
      this.gLK.setContentDescription(getContext().getString(2131296479));
      AppMethodBeat.o(16893);
      return;
    }
    this.gLK.setVisibility(0);
    this.gLK.setContentDescription(getContext().getString(2131296451));
    AppMethodBeat.o(16893);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(16904);
    Rect localRect = new Rect();
    this.gLK.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(16904);
    return localRect;
  }
  
  private static void i(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(16905);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(16905);
  }
  
  private static void j(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(16906);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(16906);
  }
  
  public final void asy()
  {
    AppMethodBeat.i(16887);
    setBackgroundResource(0);
    this.gLI.setTextColor(getResources().getColor(2131690436));
    this.gMv.setTextColor(getResources().getColor(2131689763));
    this.gMv.setInputType(0);
    this.gMv.clearFocus();
    this.gMv.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.gMv.getWindowToken(), 0);
    AppMethodBeat.o(16887);
  }
  
  public String getText()
  {
    AppMethodBeat.i(16888);
    String str = this.gMv.getText().toString();
    AppMethodBeat.o(16888);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(16895);
    if (this.gLH != null) {
      this.gLH.onFocusChange(this, paramBoolean);
    }
    ab.d("MicroMsg.InvoiceEditView", "View:" + this.gLM + ", editType:" + this.gLN + " onFocusChange to " + paramBoolean);
    if (!this.gLR)
    {
      this.gLI.setEnabled(false);
      if (paramView == this.gMv)
      {
        paramView = new Rect();
        i(this, paramView);
        if (!paramBoolean) {
          break label148;
        }
        setBackgroundResource(2130839162);
      }
    }
    for (;;)
    {
      j(this, paramView);
      dD(paramBoolean);
      AppMethodBeat.o(16895);
      return;
      this.gLI.setEnabled(true);
      break;
      label148:
      setBackgroundResource(2130839163);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(16891);
    int i;
    if (!this.gLP)
    {
      if (this.gLK.getVisibility() != 0) {
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
      AppMethodBeat.o(16891);
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
    AppMethodBeat.o(16891);
    return true;
  }
  
  public void setBankNumberValStr(String paramString)
  {
    AppMethodBeat.i(16899);
    String str1 = paramString;
    if (this.gLN == 5)
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
    this.gMv.setText(str1);
    AppMethodBeat.o(16899);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(16900);
    if (this.gMv != null)
    {
      Rect localRect = new Rect();
      i(this.gMv, localRect);
      this.gMv.setBackgroundResource(paramInt);
      j(this.gMv, localRect);
    }
    AppMethodBeat.o(16900);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(16889);
    this.gMv.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(16889);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(16890);
    super.setEnabled(paramBoolean);
    this.gLP = paramBoolean;
    this.gLK.setEnabled(true);
    AppMethodBeat.o(16890);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(16896);
    this.gMv.setHint(paramString);
    AppMethodBeat.o(16896);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(16902);
    this.gMv.setImeOptions(paramInt);
    AppMethodBeat.o(16902);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.gMs = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(16903);
    this.gLK.setVisibility(paramInt);
    AppMethodBeat.o(16903);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(16892);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(16892);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(16894);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.gLH = paramOnFocusChangeListener;
    AppMethodBeat.o(16894);
  }
  
  public void setOnInputInvoiceTypeChangeListener(InvoiceQrcodeTextView.b paramb)
  {
    this.gMu = paramb;
  }
  
  public void setOnInputValidChangeListener(InvoiceQrcodeTextView.c paramc)
  {
    this.gMt = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(16897);
    this.gLI.setText(paramString);
    AppMethodBeat.o(16897);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(16901);
    if (this.gLI != null) {
      this.gLI.setTextColor(paramInt);
    }
    AppMethodBeat.o(16901);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(16898);
    this.gMv.setText(paramString);
    this.gLW = paramString;
    AppMethodBeat.o(16898);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView
 * JD-Core Version:    0.7.0.1
 */