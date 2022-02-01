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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class InvoiceQrcodeTextView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private int imeOptions;
  private int inputType;
  private TextView jBS;
  private boolean kK;
  private View.OnFocusChangeListener ktK;
  private ImageView ktM;
  private String ktN;
  private String ktO;
  private int ktP;
  private int ktQ;
  public boolean ktR;
  private int ktS;
  public boolean ktT;
  private int ktU;
  private int ktV;
  private View.OnClickListener ktW;
  private String ktX;
  public boolean ktZ;
  private int kud;
  public boolean kue;
  private a kur;
  private c kus;
  private b kut;
  TextView kuu;
  private int kuv;
  private int kuw;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20929);
    this.ktZ = false;
    this.ktN = "";
    this.ktO = "";
    this.inputType = 1;
    this.kud = 0;
    this.gravity = 19;
    this.ktP = -1;
    this.background = -1;
    this.ktQ = -1;
    this.ktR = true;
    this.kue = true;
    this.ktT = false;
    this.ktU = 0;
    this.ktV = 100;
    this.kK = true;
    this.ktW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231580);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (InvoiceQrcodeTextView.c(InvoiceQrcodeTextView.this).getVisibility() == 0)
        {
          if ((!InvoiceQrcodeTextView.this.ktR) || (InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this) == 2) || (Util.isNullOrNil(InvoiceQrcodeTextView.this.getText()))) {
            break label128;
          }
          InvoiceQrcodeTextView.this.kuu.setText("");
          InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.e(InvoiceQrcodeTextView.this).isFocused());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(231580);
          return;
          label128:
          if (InvoiceQrcodeTextView.f(InvoiceQrcodeTextView.this) != null) {
            InvoiceQrcodeTextView.f(InvoiceQrcodeTextView.this);
          }
        }
      }
    };
    this.ktX = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.InvoiceEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.ktN = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.ktO = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(3, 1);
    this.ktP = paramAttributeSet.getInteger(5, 0);
    this.ktR = paramAttributeSet.getBoolean(6, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.imeOptions = paramAttributeSet.getInteger(4, 5);
    this.background = paramAttributeSet.getResourceId(1, 2131235359);
    this.ktS = paramAttributeSet.getResourceId(10, -1);
    this.ktQ = paramAttributeSet.getResourceId(8, 2131235359);
    this.kK = paramAttributeSet.getBoolean(12, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495088, this, true);
    this.kuu = ((TextView)paramAttributeSet.findViewById(2131302331));
    this.kuu.setTextSize(0, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
    this.jBS = ((TextView)paramAttributeSet.findViewById(2131309163));
    this.ktM = ((ImageView)paramAttributeSet.findViewById(2131302653));
    this.ktM.setOnClickListener(this.ktW);
    this.kuu.setImeOptions(this.imeOptions);
    if (!Util.isNullOrNil(this.ktN)) {
      this.kuu.setHint(this.ktN);
    }
    if (!Util.isNullOrNil(this.ktO)) {
      this.jBS.setText(this.ktO);
    }
    paramContext = new Rect();
    d(this.kuu, paramContext);
    e(this.kuu, paramContext);
    setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.ktS != -1) {
      this.ktM.setImageResource(this.ktS);
    }
    if (!this.kK) {
      this.kuu.setSingleLine(false);
    }
    this.kuu.setOnTouchListener(new InvoiceQrcodeTextView.1(this));
    this.kuu.setOnLongClickListener(new InvoiceQrcodeTextView.2(this));
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
    this.ktM.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20947);
    return localRect;
  }
  
  private void gr(boolean paramBoolean)
  {
    AppMethodBeat.i(20936);
    if ((this.ktR) && (!Util.isNullOrNil(getText())))
    {
      this.ktM.setImageResource(2131233321);
      this.ktM.setContentDescription(getContext().getString(2131757636));
      switch (this.ktP)
      {
      default: 
        this.ktM.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.ktM.setVisibility(0);
          AppMethodBeat.o(20936);
          return;
        }
        this.ktM.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 3: 
        this.ktM.setVisibility(0);
        this.ktM.setContentDescription(getContext().getString(2131755244));
        AppMethodBeat.o(20936);
        return;
      }
      this.ktM.setVisibility(0);
      this.ktM.setContentDescription(getContext().getString(2131755197));
      AppMethodBeat.o(20936);
      return;
    }
    switch (this.ktP)
    {
    default: 
      this.ktM.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.ktM.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 3: 
      this.ktM.setVisibility(0);
      this.ktM.setContentDescription(getContext().getString(2131755244));
      AppMethodBeat.o(20936);
      return;
    }
    this.ktM.setVisibility(0);
    this.ktM.setContentDescription(getContext().getString(2131755197));
    AppMethodBeat.o(20936);
  }
  
  public final void bqo()
  {
    AppMethodBeat.i(20930);
    setBackgroundResource(0);
    this.jBS.setTextColor(getResources().getColor(2131100594));
    this.kuu.setTextColor(getResources().getColor(2131100904));
    this.kuu.setInputType(0);
    this.kuu.clearFocus();
    this.kuu.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.kuu.getWindowToken(), 0);
    AppMethodBeat.o(20930);
  }
  
  public String getText()
  {
    AppMethodBeat.i(20931);
    String str = this.kuu.getText().toString();
    AppMethodBeat.o(20931);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20938);
    if (this.ktK != null) {
      this.ktK.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.InvoiceEditView", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + paramBoolean);
    if (!this.ktT)
    {
      this.jBS.setEnabled(false);
      if (paramView == this.kuu)
      {
        paramView = new Rect();
        d(this, paramView);
        if (!paramBoolean) {
          break label148;
        }
        setBackgroundResource(2131233162);
      }
    }
    for (;;)
    {
      e(this, paramView);
      gr(paramBoolean);
      AppMethodBeat.o(20938);
      return;
      this.jBS.setEnabled(true);
      break;
      label148:
      setBackgroundResource(2131233163);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20934);
    int i;
    if (!this.ktR)
    {
      if (this.ktM.getVisibility() != 0) {
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
    if (this.ktP == 5)
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
    this.kuu.setText(str1);
    AppMethodBeat.o(20942);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20943);
    if (this.kuu != null)
    {
      Rect localRect = new Rect();
      d(this.kuu, localRect);
      this.kuu.setBackgroundResource(paramInt);
      e(this.kuu, localRect);
    }
    AppMethodBeat.o(20943);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20932);
    this.kuu.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20932);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20933);
    super.setEnabled(paramBoolean);
    this.ktR = paramBoolean;
    this.ktM.setEnabled(true);
    AppMethodBeat.o(20933);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20939);
    this.kuu.setHint(paramString);
    AppMethodBeat.o(20939);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20945);
    this.kuu.setImeOptions(paramInt);
    AppMethodBeat.o(20945);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.kur = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20946);
    this.ktM.setVisibility(paramInt);
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
    this.ktK = paramOnFocusChangeListener;
    AppMethodBeat.o(20937);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.kut = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.kus = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20940);
    this.jBS.setText(paramString);
    AppMethodBeat.o(20940);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20944);
    if (this.jBS != null) {
      this.jBS.setTextColor(paramInt);
    }
    AppMethodBeat.o(20944);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20941);
    this.kuu.setText(paramString);
    this.ktX = paramString;
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