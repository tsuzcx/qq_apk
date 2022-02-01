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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class InvoiceQrcodeTextView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private TextView hJf;
  private boolean hO;
  private a iAa;
  private c iAb;
  private b iAc;
  TextView iAd;
  private int imeOptions;
  private int inputType;
  public boolean izA;
  private int izB;
  private int izC;
  private View.OnClickListener izD;
  private String izE;
  public boolean izG;
  private int izK;
  public boolean izL;
  private View.OnFocusChangeListener izr;
  private ImageView izt;
  private String izu;
  private String izv;
  private int izw;
  private int izx;
  public boolean izy;
  private int izz;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20929);
    this.izG = false;
    this.izu = "";
    this.izv = "";
    this.inputType = 1;
    this.izK = 0;
    this.gravity = 19;
    this.izw = -1;
    this.background = -1;
    this.izx = -1;
    this.izy = true;
    this.izL = true;
    this.izA = false;
    this.izB = 0;
    this.izC = 100;
    this.hO = true;
    this.izD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20928);
        if (InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this).getVisibility() == 0)
        {
          if ((InvoiceQrcodeTextView.this.izy) && (InvoiceQrcodeTextView.b(InvoiceQrcodeTextView.this) != 2) && (!bt.isNullOrNil(InvoiceQrcodeTextView.this.getText())))
          {
            InvoiceQrcodeTextView.this.iAd.setText("");
            InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.c(InvoiceQrcodeTextView.this).isFocused());
            AppMethodBeat.o(20928);
            return;
          }
          if (InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this) != null) {
            InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this);
          }
        }
        AppMethodBeat.o(20928);
      }
    };
    this.izE = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.InvoiceEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.izu = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.izv = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(3, 1);
    this.izw = paramAttributeSet.getInteger(5, 0);
    this.izy = paramAttributeSet.getBoolean(6, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.imeOptions = paramAttributeSet.getInteger(4, 5);
    this.background = paramAttributeSet.getResourceId(1, 2131234429);
    this.izz = paramAttributeSet.getResourceId(10, -1);
    this.izx = paramAttributeSet.getResourceId(8, 2131234429);
    this.hO = paramAttributeSet.getBoolean(12, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494496, this, true);
    this.iAd = ((TextView)paramAttributeSet.findViewById(2131300744));
    this.iAd.setTextSize(0, a.ao(paramContext, 2131165517));
    this.hJf = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.izt = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.izt.setOnClickListener(this.izD);
    this.iAd.setImeOptions(this.imeOptions);
    if (!bt.isNullOrNil(this.izu)) {
      this.iAd.setHint(this.izu);
    }
    if (!bt.isNullOrNil(this.izv)) {
      this.hJf.setText(this.izv);
    }
    paramContext = new Rect();
    h(this.iAd, paramContext);
    i(this.iAd, paramContext);
    setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.izz != -1) {
      this.izt.setImageResource(this.izz);
    }
    if (!this.hO) {
      this.iAd.setSingleLine(false);
    }
    this.iAd.setOnLongClickListener(new InvoiceQrcodeTextView.1(this));
    AppMethodBeat.o(20929);
  }
  
  private void eZ(boolean paramBoolean)
  {
    AppMethodBeat.i(20936);
    if ((this.izy) && (!bt.isNullOrNil(getText())))
    {
      this.izt.setImageResource(2131232862);
      this.izt.setContentDescription(getContext().getString(2131757419));
      switch (this.izw)
      {
      default: 
        this.izt.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.izt.setVisibility(0);
          AppMethodBeat.o(20936);
          return;
        }
        this.izt.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 3: 
        this.izt.setVisibility(0);
        this.izt.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20936);
        return;
      }
      this.izt.setVisibility(0);
      this.izt.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20936);
      return;
    }
    switch (this.izw)
    {
    default: 
      this.izt.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.izt.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 3: 
      this.izt.setVisibility(0);
      this.izt.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20936);
      return;
    }
    this.izt.setVisibility(0);
    this.izt.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20936);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20947);
    Rect localRect = new Rect();
    this.izt.getHitRect(localRect);
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
  
  public final void aLa()
  {
    AppMethodBeat.i(20930);
    setBackgroundResource(0);
    this.hJf.setTextColor(getResources().getColor(2131100490));
    this.iAd.setTextColor(getResources().getColor(2131100711));
    this.iAd.setInputType(0);
    this.iAd.clearFocus();
    this.iAd.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.iAd.getWindowToken(), 0);
    AppMethodBeat.o(20930);
  }
  
  public String getText()
  {
    AppMethodBeat.i(20931);
    String str = this.iAd.getText().toString();
    AppMethodBeat.o(20931);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20938);
    if (this.izr != null) {
      this.izr.onFocusChange(this, paramBoolean);
    }
    ad.d("MicroMsg.InvoiceEditView", "View:" + this.izv + ", editType:" + this.izw + " onFocusChange to " + paramBoolean);
    if (!this.izA)
    {
      this.hJf.setEnabled(false);
      if (paramView == this.iAd)
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
      eZ(paramBoolean);
      AppMethodBeat.o(20938);
      return;
      this.hJf.setEnabled(true);
      break;
      label148:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20934);
    int i;
    if (!this.izy)
    {
      if (this.izt.getVisibility() != 0) {
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
    if (this.izw == 5)
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
    this.iAd.setText(str1);
    AppMethodBeat.o(20942);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20943);
    if (this.iAd != null)
    {
      Rect localRect = new Rect();
      h(this.iAd, localRect);
      this.iAd.setBackgroundResource(paramInt);
      i(this.iAd, localRect);
    }
    AppMethodBeat.o(20943);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20932);
    this.iAd.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20932);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20933);
    super.setEnabled(paramBoolean);
    this.izy = paramBoolean;
    this.izt.setEnabled(true);
    AppMethodBeat.o(20933);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20939);
    this.iAd.setHint(paramString);
    AppMethodBeat.o(20939);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20945);
    this.iAd.setImeOptions(paramInt);
    AppMethodBeat.o(20945);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.iAa = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20946);
    this.izt.setVisibility(paramInt);
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
    this.izr = paramOnFocusChangeListener;
    AppMethodBeat.o(20937);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.iAc = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.iAb = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20940);
    this.hJf.setText(paramString);
    AppMethodBeat.o(20940);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20944);
    if (this.hJf != null) {
      this.hJf.setTextColor(paramInt);
    }
    AppMethodBeat.o(20944);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20941);
    this.iAd.setText(paramString);
    this.izE = paramString;
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