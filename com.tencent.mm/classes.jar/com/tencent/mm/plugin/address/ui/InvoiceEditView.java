package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class InvoiceEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private TextView iCW;
  private int imeOptions;
  private int inputType;
  private View.OnFocusChangeListener jsD;
  EditText jsE;
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
  private a jsT;
  private c jsU;
  private b jsV;
  private int jsW;
  public boolean jsX;
  private boolean kI;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20876);
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
        AppMethodBeat.i(20875);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0)
        {
          if ((!InvoiceEditView.this.jsK) || (InvoiceEditView.a(InvoiceEditView.this) == 2) || (bt.isNullOrNil(InvoiceEditView.this.getText()))) {
            break label130;
          }
          InvoiceEditView.this.jsE.setText("");
          InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(20875);
          return;
          label130:
          if (InvoiceEditView.g(InvoiceEditView.this) != null) {
            InvoiceEditView.g(InvoiceEditView.this);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494493, this, true);
    this.jsE = ((EditText)paramAttributeSet.findViewById(2131300744));
    this.jsE.setTextSize(0, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
    this.iCW = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.jsF = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.jsF.setOnClickListener(this.jsP);
    this.jsE.setImeOptions(this.imeOptions);
    this.jsE.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.jsE.setKeyListener(new NumberKeyListener()
      {
        protected final char[] getAcceptedChars()
        {
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 45, 43, 95, 8212, 32, 32, 40, 41, -248, -247, 64, 126, 42, 38, 94, 37, 36, 35, 64, 33, 59, 58, -230, -229, 123, 125, 91, 93, -165, -163, 12304, 12305, 60, 62, 126, 96, 183, 61, 61, 43 };
        }
        
        public final int getInputType()
        {
          return 2;
        }
      });
      fx(this.jsE.isFocused());
      this.jsE.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20874);
          if ((InvoiceEditView.a(InvoiceEditView.this) == 5) && (InvoiceEditView.b(InvoiceEditView.this) != paramAnonymousEditable.toString().length()))
          {
            InvoiceEditView.a(InvoiceEditView.this, paramAnonymousEditable.toString().length());
            InvoiceEditView.this.setBankNumberValStr(paramAnonymousEditable.toString());
          }
          boolean bool = InvoiceEditView.this.aVa();
          if ((bool != InvoiceEditView.this.jsM) && (InvoiceEditView.c(InvoiceEditView.this) != null))
          {
            ad.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(InvoiceEditView.this) + ", editType:" + InvoiceEditView.a(InvoiceEditView.this) + " inputValid change to " + bool);
            InvoiceEditView.this.jsM = bool;
            InvoiceEditView.c(InvoiceEditView.this).aUX();
          }
          if (((!InvoiceEditView.this.jsS) || (InvoiceEditView.this.jsM)) && (InvoiceEditView.this.jsS) && (InvoiceEditView.this.jsM)) {
            InvoiceEditView.e(InvoiceEditView.this).setTextColor(InvoiceEditView.this.getResources().getColor(2131100711));
          }
          InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
          AppMethodBeat.o(20874);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.jsE.setOnFocusChangeListener(this);
      if (!bt.isNullOrNil(this.jsG)) {
        this.jsE.setHint(this.jsG);
      }
      if (!bt.isNullOrNil(this.jsH)) {
        this.iCW.setText(this.jsH);
      }
      paramContext = new Rect();
      h(this.jsE, paramContext);
      if (this.jsK) {
        break label661;
      }
      this.jsE.setEnabled(false);
      this.jsE.setTextColor(getResources().getColor(2131099895));
      this.jsE.setFocusable(false);
      this.jsE.setClickable(false);
      this.jsE.setBackgroundResource(2131234429);
      if (this.jsX) {
        setBackgroundResource(2131231818);
      }
      setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.jsE, paramContext);
      if (this.jsL != -1) {
        this.jsF.setImageResource(this.jsL);
      }
      if (!this.kI) {
        this.jsE.setSingleLine(false);
      }
      AppMethodBeat.o(20876);
      return;
      if (this.inputType == 3)
      {
        this.jsE.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            if (InvoiceEditView.this.jsS) {
              return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 32, 32 };
            }
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 45, 43, 95, 8212, 32, 32, 40, 41, -248, -247, 64, 126, 42, 38, 94, 37, 36, 35, 64, 33, 59, 58, -230, -229, 123, 125, 91, 93, -165, -163, 12304, 12305, 60, 62, -28820, 126, 96, 183, 61, 61, 43 };
          }
          
          public final int getInputType()
          {
            return 3;
          }
        });
        break;
      }
      this.jsE.setInputType(this.inputType);
      break;
      label661:
      this.jsM = false;
      this.jsE.setBackgroundResource(this.jsJ);
      setBackgroundResource(this.background);
    }
  }
  
  private void fx(boolean paramBoolean)
  {
    AppMethodBeat.i(20883);
    if ((this.jsK) && (!bt.isNullOrNil(getText())))
    {
      this.jsF.setImageResource(2131232862);
      this.jsF.setContentDescription(getContext().getString(2131757419));
      switch (this.jsI)
      {
      default: 
        this.jsF.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.jsF.setVisibility(0);
          AppMethodBeat.o(20883);
          return;
        }
        this.jsF.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 3: 
        this.jsF.setVisibility(0);
        this.jsF.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20883);
        return;
      }
      this.jsF.setVisibility(0);
      this.jsF.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20883);
      return;
    }
    switch (this.jsI)
    {
    default: 
      this.jsF.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.jsF.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 3: 
      this.jsF.setVisibility(0);
      this.jsF.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20883);
      return;
    }
    this.jsF.setVisibility(0);
    this.jsF.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20883);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20895);
    Rect localRect = new Rect();
    this.jsF.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20895);
    return localRect;
  }
  
  private static void h(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20896);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(20896);
  }
  
  private static void i(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20897);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(20897);
  }
  
  public final boolean aVa()
  {
    AppMethodBeat.i(20882);
    String str = this.jsE.getText().toString();
    switch (this.jsI)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() >= this.jsN) && (str.length() <= this.jsO))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      break;
    case 0: 
      if ((str.length() >= this.jsN) && (str.length() <= this.jsO))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 1: 
      if ((str.length() == 0) || ((str.length() >= this.jsN) && (str.length() <= this.jsO)))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 4: 
      if (str.length() <= 100)
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 5: 
      if (str.length() <= 48)
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    }
    AppMethodBeat.o(20882);
    return false;
  }
  
  public final boolean aVb()
  {
    AppMethodBeat.i(20890);
    if (getText().equals(bt.nullAsNil(this.jsQ)))
    {
      AppMethodBeat.o(20890);
      return false;
    }
    AppMethodBeat.o(20890);
    return true;
  }
  
  public String getText()
  {
    AppMethodBeat.i(20877);
    String str = this.jsE.getText().toString();
    AppMethodBeat.o(20877);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20885);
    if (this.jsD != null) {
      this.jsD.onFocusChange(this, paramBoolean);
    }
    ad.d("MicroMsg.InvoiceEditView", "View:" + this.jsH + ", editType:" + this.jsI + " onFocusChange to " + paramBoolean);
    if (this.jsU != null) {
      this.jsU.aUX();
    }
    if (!this.jsM)
    {
      this.iCW.setEnabled(false);
      if (paramView == this.jsE)
      {
        paramView = new Rect();
        h(this, paramView);
        if (!paramBoolean) {
          break label164;
        }
        setBackgroundResource(2131232723);
      }
    }
    for (;;)
    {
      i(this, paramView);
      fx(paramBoolean);
      AppMethodBeat.o(20885);
      return;
      this.iCW.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20880);
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
      AppMethodBeat.o(20880);
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
    AppMethodBeat.o(20880);
    return true;
  }
  
  public void setBankNumberValStr(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(20889);
    String str1 = paramString;
    if (this.jsI == 5)
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
    this.jsE.setText(str1);
    this.jsE.setSelection(this.jsE.getText().length());
    AppMethodBeat.o(20889);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20891);
    if (this.jsE != null)
    {
      Rect localRect = new Rect();
      h(this.jsE, localRect);
      this.jsE.setBackgroundResource(paramInt);
      i(this.jsE, localRect);
    }
    AppMethodBeat.o(20891);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20878);
    this.jsE.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20878);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20879);
    super.setEnabled(paramBoolean);
    this.jsK = paramBoolean;
    this.jsF.setEnabled(true);
    AppMethodBeat.o(20879);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20886);
    this.jsE.setHint(paramString);
    AppMethodBeat.o(20886);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20893);
    this.jsE.setImeOptions(paramInt);
    AppMethodBeat.o(20893);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.jsT = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20894);
    this.jsF.setVisibility(paramInt);
    AppMethodBeat.o(20894);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(20881);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(20881);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(20884);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.jsD = paramOnFocusChangeListener;
    AppMethodBeat.o(20884);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.jsV = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.jsU = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20887);
    this.iCW.setText(paramString);
    AppMethodBeat.o(20887);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20892);
    if (this.iCW != null) {
      this.iCW.setTextColor(paramInt);
    }
    AppMethodBeat.o(20892);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20888);
    this.jsE.setText(paramString);
    this.jsE.setSelection(this.jsE.getText().length());
    this.jsQ = paramString;
    AppMethodBeat.o(20888);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void aUX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */