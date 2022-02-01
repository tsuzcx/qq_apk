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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class InvoiceQrcodeTextView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private TextView iCW;
  private int imeOptions;
  private int inputType;
  private View.OnFocusChangeListener jsD;
  private ImageView jsF;
  private String jsG;
  private String jsH;
  private int jsI;
  private int jsJ;
  public boolean jsK;
  private int jsL;
  public boolean jsM;
  private int jsN;
  private int jsO;
  private View.OnClickListener jsP;
  private String jsQ;
  public boolean jsS;
  private int jsW;
  public boolean jsX;
  private a jtk;
  private c jtl;
  private b jtm;
  TextView jtn;
  private boolean kI;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20929);
    this.jsS = false;
    this.jsG = "";
    this.jsH = "";
    this.inputType = 1;
    this.jsW = 0;
    this.gravity = 19;
    this.jsI = -1;
    this.background = -1;
    this.jsJ = -1;
    this.jsK = true;
    this.jsX = true;
    this.jsM = false;
    this.jsN = 0;
    this.jsO = 100;
    this.kI = true;
    this.jsP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20928);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this).getVisibility() == 0)
        {
          if ((!InvoiceQrcodeTextView.this.jsK) || (InvoiceQrcodeTextView.b(InvoiceQrcodeTextView.this) == 2) || (bt.isNullOrNil(InvoiceQrcodeTextView.this.getText()))) {
            break label130;
          }
          InvoiceQrcodeTextView.this.jtn.setText("");
          InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.c(InvoiceQrcodeTextView.this).isFocused());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(20928);
          return;
          label130:
          if (InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this) != null) {
            InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this);
          }
        }
      }
    };
    this.jsQ = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.InvoiceEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.jsG = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.jsH = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(3, 1);
    this.jsI = paramAttributeSet.getInteger(5, 0);
    this.jsK = paramAttributeSet.getBoolean(6, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.imeOptions = paramAttributeSet.getInteger(4, 5);
    this.background = paramAttributeSet.getResourceId(1, 2131234429);
    this.jsL = paramAttributeSet.getResourceId(10, -1);
    this.jsJ = paramAttributeSet.getResourceId(8, 2131234429);
    this.kI = paramAttributeSet.getBoolean(12, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494496, this, true);
    this.jtn = ((TextView)paramAttributeSet.findViewById(2131300744));
    this.jtn.setTextSize(0, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
    this.iCW = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.jsF = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.jsF.setOnClickListener(this.jsP);
    this.jtn.setImeOptions(this.imeOptions);
    if (!bt.isNullOrNil(this.jsG)) {
      this.jtn.setHint(this.jsG);
    }
    if (!bt.isNullOrNil(this.jsH)) {
      this.iCW.setText(this.jsH);
    }
    paramContext = new Rect();
    h(this.jtn, paramContext);
    i(this.jtn, paramContext);
    setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.jsL != -1) {
      this.jsF.setImageResource(this.jsL);
    }
    if (!this.kI) {
      this.jtn.setSingleLine(false);
    }
    this.jtn.setOnLongClickListener(new InvoiceQrcodeTextView.1(this));
    AppMethodBeat.o(20929);
  }
  
  private void fx(boolean paramBoolean)
  {
    AppMethodBeat.i(20936);
    if ((this.jsK) && (!bt.isNullOrNil(getText())))
    {
      this.jsF.setImageResource(2131232862);
      this.jsF.setContentDescription(getContext().getString(2131757419));
      switch (this.jsI)
      {
      default: 
        this.jsF.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.jsF.setVisibility(0);
          AppMethodBeat.o(20936);
          return;
        }
        this.jsF.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 3: 
        this.jsF.setVisibility(0);
        this.jsF.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20936);
        return;
      }
      this.jsF.setVisibility(0);
      this.jsF.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20936);
      return;
    }
    switch (this.jsI)
    {
    default: 
      this.jsF.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.jsF.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 3: 
      this.jsF.setVisibility(0);
      this.jsF.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20936);
      return;
    }
    this.jsF.setVisibility(0);
    this.jsF.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20936);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20947);
    Rect localRect = new Rect();
    this.jsF.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20947);
    return localRect;
  }
  
  private static void h(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20948);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(20948);
  }
  
  private static void i(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20949);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(20949);
  }
  
  public final void aVd()
  {
    AppMethodBeat.i(20930);
    setBackgroundResource(0);
    this.iCW.setTextColor(getResources().getColor(2131100490));
    this.jtn.setTextColor(getResources().getColor(2131100711));
    this.jtn.setInputType(0);
    this.jtn.clearFocus();
    this.jtn.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jtn.getWindowToken(), 0);
    AppMethodBeat.o(20930);
  }
  
  public String getText()
  {
    AppMethodBeat.i(20931);
    String str = this.jtn.getText().toString();
    AppMethodBeat.o(20931);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20938);
    if (this.jsD != null) {
      this.jsD.onFocusChange(this, paramBoolean);
    }
    ad.d("MicroMsg.InvoiceEditView", "View:" + this.jsH + ", editType:" + this.jsI + " onFocusChange to " + paramBoolean);
    if (!this.jsM)
    {
      this.iCW.setEnabled(false);
      if (paramView == this.jtn)
      {
        paramView = new Rect();
        h(this, paramView);
        if (!paramBoolean) {
          break label148;
        }
        setBackgroundResource(2131232723);
      }
    }
    for (;;)
    {
      i(this, paramView);
      fx(paramBoolean);
      AppMethodBeat.o(20938);
      return;
      this.iCW.setEnabled(true);
      break;
      label148:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20934);
    int i;
    if (!this.jsK)
    {
      if (this.jsF.getVisibility() != 0) {
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
    if (this.jsI == 5)
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
    this.jtn.setText(str1);
    AppMethodBeat.o(20942);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20943);
    if (this.jtn != null)
    {
      Rect localRect = new Rect();
      h(this.jtn, localRect);
      this.jtn.setBackgroundResource(paramInt);
      i(this.jtn, localRect);
    }
    AppMethodBeat.o(20943);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20932);
    this.jtn.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20932);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20933);
    super.setEnabled(paramBoolean);
    this.jsK = paramBoolean;
    this.jsF.setEnabled(true);
    AppMethodBeat.o(20933);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20939);
    this.jtn.setHint(paramString);
    AppMethodBeat.o(20939);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20945);
    this.jtn.setImeOptions(paramInt);
    AppMethodBeat.o(20945);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.jtk = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20946);
    this.jsF.setVisibility(paramInt);
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
    this.jsD = paramOnFocusChangeListener;
    AppMethodBeat.o(20937);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.jtm = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.jtl = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20940);
    this.iCW.setText(paramString);
    AppMethodBeat.o(20940);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20944);
    if (this.iCW != null) {
      this.iCW.setTextColor(paramInt);
    }
    AppMethodBeat.o(20944);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20941);
    this.jtn.setText(paramString);
    this.jsQ = paramString;
    AppMethodBeat.o(20941);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView
 * JD-Core Version:    0.7.0.1
 */