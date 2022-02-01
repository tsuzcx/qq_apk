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
  private boolean bCn;
  private int background;
  private int editType;
  private int ek;
  private int inputType;
  private TextView mrN;
  private ImageView nlA;
  private String nlB;
  private String nlC;
  private int nlD;
  private int nlE;
  public boolean nlF;
  private int nlG;
  public boolean nlH;
  private int nlI;
  private int nlJ;
  private View.OnClickListener nlK;
  private String nlL;
  public boolean nlN;
  private int nlR;
  public boolean nlS;
  private View.OnFocusChangeListener nly;
  private a nmf;
  private c nmg;
  private b nmh;
  TextView nmi;
  private int nmj;
  private int nmk;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20929);
    this.nlN = false;
    this.nlB = "";
    this.nlC = "";
    this.inputType = 1;
    this.nlR = 0;
    this.ek = 19;
    this.editType = -1;
    this.background = -1;
    this.nlE = -1;
    this.nlF = true;
    this.nlS = true;
    this.nlH = false;
    this.nlI = 0;
    this.nlJ = 100;
    this.bCn = true;
    this.nlK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(291401);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (InvoiceQrcodeTextView.c(InvoiceQrcodeTextView.this).getVisibility() == 0)
        {
          if ((!InvoiceQrcodeTextView.this.nlF) || (InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this) == 2) || (Util.isNullOrNil(InvoiceQrcodeTextView.this.getText()))) {
            break label128;
          }
          InvoiceQrcodeTextView.this.nmi.setText("");
          InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.e(InvoiceQrcodeTextView.this).isFocused());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(291401);
          return;
          label128:
          if (InvoiceQrcodeTextView.f(InvoiceQrcodeTextView.this) != null) {
            InvoiceQrcodeTextView.f(InvoiceQrcodeTextView.this);
          }
        }
      }
    };
    this.nlL = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.eWJ, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(R.n.eWQ, 0);
    if (paramInt != 0) {
      this.nlB = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(R.n.eWU, 0);
    if (paramInt != 0) {
      this.nlC = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(R.n.eWM, 1);
    this.editType = paramAttributeSet.getInteger(R.n.eWO, 0);
    this.nlF = paramAttributeSet.getBoolean(R.n.eWP, true);
    this.ek = paramAttributeSet.getInt(R.n.eWK, 19);
    this.nlD = paramAttributeSet.getInteger(R.n.eWN, 5);
    this.background = paramAttributeSet.getResourceId(R.n.eWL, R.g.transparent_background);
    this.nlG = paramAttributeSet.getResourceId(R.n.eWS, -1);
    this.nlE = paramAttributeSet.getResourceId(R.n.eWR, R.g.transparent_background);
    this.bCn = paramAttributeSet.getBoolean(R.n.eWT, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.ehI, this, true);
    this.nmi = ((TextView)paramAttributeSet.findViewById(R.h.hint_et));
    this.nmi.setTextSize(0, com.tencent.mm.ci.a.aY(paramContext, R.f.NormalTextSize));
    this.mrN = ((TextView)paramAttributeSet.findViewById(R.h.tip_tv));
    this.nlA = ((ImageView)paramAttributeSet.findViewById(R.h.info_iv));
    this.nlA.setOnClickListener(this.nlK);
    this.nmi.setImeOptions(this.nlD);
    if (!Util.isNullOrNil(this.nlB)) {
      this.nmi.setHint(this.nlB);
    }
    if (!Util.isNullOrNil(this.nlC)) {
      this.mrN.setText(this.nlC);
    }
    paramContext = new Rect();
    d(this.nmi, paramContext);
    e(this.nmi, paramContext);
    setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.nlG != -1) {
      this.nlA.setImageResource(this.nlG);
    }
    if (!this.bCn) {
      this.nmi.setSingleLine(false);
    }
    this.nmi.setOnTouchListener(new InvoiceQrcodeTextView.1(this));
    this.nmi.setOnLongClickListener(new InvoiceQrcodeTextView.2(this));
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
    this.nlA.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20947);
    return localRect;
  }
  
  private void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(20936);
    if ((this.nlF) && (!Util.isNullOrNil(getText())))
    {
      this.nlA.setImageResource(R.g.list_clear);
      this.nlA.setContentDescription(getContext().getString(R.l.clear_btn));
      switch (this.editType)
      {
      default: 
        this.nlA.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.nlA.setVisibility(0);
          AppMethodBeat.o(20936);
          return;
        }
        this.nlA.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 3: 
        this.nlA.setVisibility(0);
        this.nlA.setContentDescription(getContext().getString(R.l.address_location));
        AppMethodBeat.o(20936);
        return;
      }
      this.nlA.setVisibility(0);
      this.nlA.setContentDescription(getContext().getString(R.l.address_contact));
      AppMethodBeat.o(20936);
      return;
    }
    switch (this.editType)
    {
    default: 
      this.nlA.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.nlA.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 3: 
      this.nlA.setVisibility(0);
      this.nlA.setContentDescription(getContext().getString(R.l.address_location));
      AppMethodBeat.o(20936);
      return;
    }
    this.nlA.setVisibility(0);
    this.nlA.setContentDescription(getContext().getString(R.l.address_contact));
    AppMethodBeat.o(20936);
  }
  
  public final void bAC()
  {
    AppMethodBeat.i(20930);
    setBackgroundResource(0);
    this.mrN.setTextColor(getResources().getColor(R.e.hint_text_color));
    this.nmi.setTextColor(getResources().getColor(R.e.normal_text_color));
    this.nmi.setInputType(0);
    this.nmi.clearFocus();
    this.nmi.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.nmi.getWindowToken(), 0);
    AppMethodBeat.o(20930);
  }
  
  public String getText()
  {
    AppMethodBeat.i(20931);
    String str = this.nmi.getText().toString();
    AppMethodBeat.o(20931);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20938);
    if (this.nly != null) {
      this.nly.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.InvoiceEditView", "View:" + this.nlC + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
    if (!this.nlH)
    {
      this.mrN.setEnabled(false);
      if (paramView == this.nmi)
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
      hd(paramBoolean);
      AppMethodBeat.o(20938);
      return;
      this.mrN.setEnabled(true);
      break;
      label148:
      setBackgroundResource(R.g.input_bar_bg_normal);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20934);
    int i;
    if (!this.nlF)
    {
      if (this.nlA.getVisibility() != 0) {
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
    this.nmi.setText(str1);
    AppMethodBeat.o(20942);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20943);
    if (this.nmi != null)
    {
      Rect localRect = new Rect();
      d(this.nmi, localRect);
      this.nmi.setBackgroundResource(paramInt);
      e(this.nmi, localRect);
    }
    AppMethodBeat.o(20943);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20932);
    this.nmi.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20932);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20933);
    super.setEnabled(paramBoolean);
    this.nlF = paramBoolean;
    this.nlA.setEnabled(true);
    AppMethodBeat.o(20933);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20939);
    this.nmi.setHint(paramString);
    AppMethodBeat.o(20939);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20945);
    this.nmi.setImeOptions(paramInt);
    AppMethodBeat.o(20945);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.nmf = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20946);
    this.nlA.setVisibility(paramInt);
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
    this.nly = paramOnFocusChangeListener;
    AppMethodBeat.o(20937);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.nmh = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.nmg = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20940);
    this.mrN.setText(paramString);
    AppMethodBeat.o(20940);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20944);
    if (this.mrN != null) {
      this.mrN.setTextColor(paramInt);
    }
    AppMethodBeat.o(20944);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20941);
    this.nmi.setText(paramString);
    this.nlL = paramString;
    AppMethodBeat.o(20941);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView
 * JD-Core Version:    0.7.0.1
 */