package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.telephony.PhoneNumberUtils;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;

public class AddrEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private TextView iCW;
  private int imeOptions;
  private int inputType;
  private AddrEditView.a jsB;
  private b jsC;
  private View.OnFocusChangeListener jsD;
  EditText jsE;
  private ImageView jsF;
  private String jsG;
  private String jsH;
  private int jsI;
  private int jsJ;
  public boolean jsK;
  private int jsL;
  private boolean jsM;
  private int jsN;
  private int jsO;
  private View.OnClickListener jsP;
  private String jsQ;
  private boolean kI;
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20850);
    this.jsG = "";
    this.jsH = "";
    this.inputType = 1;
    this.gravity = 19;
    this.jsI = -1;
    this.background = -1;
    this.jsJ = -1;
    this.jsK = true;
    this.jsM = false;
    this.jsN = 1;
    this.jsO = 30;
    this.kI = true;
    this.jsP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20849);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/AddrEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (AddrEditView.f(AddrEditView.this).getVisibility() == 0)
        {
          if ((!AddrEditView.this.jsK) || (AddrEditView.d(AddrEditView.this) == 2) || (bt.isNullOrNil(AddrEditView.this.getText()))) {
            break label130;
          }
          AddrEditView.this.jsE.setText("");
          AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/AddrEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(20849);
          return;
          label130:
          if (AddrEditView.g(AddrEditView.this) != null) {
            AddrEditView.g(AddrEditView.this).onClick();
          }
        }
      }
    };
    this.jsQ = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AddrEditView, paramInt, 0);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131492946, this, true);
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
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
        }
        
        public final int getInputType()
        {
          return 3;
        }
      });
      fx(this.jsE.isFocused());
      this.jsE.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20848);
          boolean bool = AddrEditView.this.aVa();
          if ((bool != AddrEditView.a(AddrEditView.this)) && (AddrEditView.b(AddrEditView.this) != null))
          {
            ad.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(AddrEditView.this) + ", editType:" + AddrEditView.d(AddrEditView.this) + " inputValid change to " + bool);
            AddrEditView.a(AddrEditView.this, bool);
            paramAnonymousEditable = AddrEditView.b(AddrEditView.this);
            AddrEditView.a(AddrEditView.this);
            paramAnonymousEditable.aUX();
          }
          AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
          AppMethodBeat.o(20848);
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
      paramAttributeSet = new Rect();
      h(this.jsE, paramAttributeSet);
      if (this.jsK) {
        break label663;
      }
      this.jsE.setEnabled(false);
      this.jsE.setTextColor(getResources().getColor(2131099895));
      this.jsE.setFocusable(false);
      this.jsE.setClickable(false);
      this.jsE.setBackgroundResource(2131234429);
      setBackgroundResource(2131233277);
      setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.jsE, paramAttributeSet);
      this.jsE.setGravity(this.gravity);
      if (this.jsL != -1) {
        this.jsF.setImageDrawable(ao.k(paramContext, this.jsL, paramContext.getResources().getColor(2131099732)));
      }
      if (!this.kI) {
        this.jsE.setSingleLine(false);
      }
      AppMethodBeat.o(20850);
      return;
      if (this.inputType == 3)
      {
        this.jsE.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
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
      label663:
      this.jsM = false;
      this.jsE.setBackgroundResource(this.jsJ);
      setBackgroundResource(this.background);
    }
  }
  
  private static int Kg(String paramString)
  {
    AppMethodBeat.i(20871);
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[Α-￥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    AppMethodBeat.o(20871);
    return i;
  }
  
  private void fx(boolean paramBoolean)
  {
    AppMethodBeat.i(20857);
    if ((this.jsK) && (!bt.isNullOrNil(getText())))
    {
      this.jsF.setImageDrawable(aq.aM(getContext(), 2130968981));
      this.jsF.setContentDescription(getContext().getString(2131757419));
      switch (this.jsI)
      {
      default: 
        this.jsF.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 0: 
      case 1: 
        if (paramBoolean)
        {
          this.jsF.setVisibility(0);
          AppMethodBeat.o(20857);
          return;
        }
        this.jsF.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 3: 
        this.jsF.setVisibility(0);
        this.jsF.setImageResource(2131690589);
        this.jsF.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20857);
        return;
      }
      this.jsF.setVisibility(0);
      this.jsF.setImageResource(2131690659);
      this.jsF.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20857);
      return;
    }
    switch (this.jsI)
    {
    default: 
      this.jsF.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 0: 
    case 1: 
      this.jsF.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 3: 
      this.jsF.setVisibility(0);
      this.jsF.setImageResource(2131690589);
      this.jsF.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20857);
      return;
    }
    this.jsF.setVisibility(0);
    this.jsF.setImageResource(2131690659);
    this.jsF.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20857);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20868);
    Rect localRect = new Rect();
    this.jsF.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20868);
    return localRect;
  }
  
  private static void h(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20869);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(20869);
  }
  
  private static void i(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20870);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(20870);
  }
  
  public final boolean aVa()
  {
    AppMethodBeat.i(20856);
    Object localObject = this.jsE.getText().toString();
    switch (this.jsI)
    {
    case 0: 
    default: 
      if (((String)localObject).length() >= this.jsN)
      {
        AppMethodBeat.o(20856);
        return true;
      }
      break;
    case 1: 
      if ((((String)localObject).length() >= this.jsN) && (((String)localObject).length() <= this.jsO))
      {
        if (localObject == null) {
          localObject = null;
        }
        while (PhoneNumberUtils.isGlobalPhoneNumber((String)localObject))
        {
          AppMethodBeat.o(20856);
          return true;
          String str = ((String)localObject).replaceAll("\\D", "");
          localObject = str;
          if (str.startsWith("86")) {
            localObject = str.substring(2);
          }
        }
      }
      AppMethodBeat.o(20856);
      return false;
    case 2: 
      if ((((String)localObject).length() >= this.jsN) && (Kg((String)localObject) <= 32))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 3: 
    case 5: 
      if ((((String)localObject).length() >= this.jsN) && (Kg((String)localObject) <= 128))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 4: 
      if (((String)localObject).length() <= this.jsO)
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    }
    AppMethodBeat.o(20856);
    return false;
  }
  
  public final boolean aVb()
  {
    AppMethodBeat.i(20863);
    if (getText().equals(bt.nullAsNil(this.jsQ)))
    {
      AppMethodBeat.o(20863);
      return false;
    }
    AppMethodBeat.o(20863);
    return true;
  }
  
  public String getText()
  {
    AppMethodBeat.i(20851);
    String str = this.jsE.getText().toString();
    AppMethodBeat.o(20851);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20859);
    if (this.jsD != null) {
      this.jsD.onFocusChange(this, paramBoolean);
    }
    ad.d("MicroMsg.AddrEditView", "View:" + this.jsH + ", editType:" + this.jsI + " onFocusChange to " + paramBoolean);
    if (this.jsC != null) {
      this.jsC.aUX();
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
      AppMethodBeat.o(20859);
      return;
      this.iCW.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20854);
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
      AppMethodBeat.o(20854);
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
    AppMethodBeat.o(20854);
    return true;
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20864);
    if (this.jsE != null)
    {
      Rect localRect = new Rect();
      h(this.jsE, localRect);
      this.jsE.setBackgroundResource(paramInt);
      i(this.jsE, localRect);
    }
    AppMethodBeat.o(20864);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20852);
    this.jsE.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20852);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20853);
    super.setEnabled(paramBoolean);
    this.jsK = paramBoolean;
    this.jsF.setEnabled(true);
    AppMethodBeat.o(20853);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20860);
    this.jsE.setHint(paramString);
    AppMethodBeat.o(20860);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20866);
    this.jsE.setImeOptions(paramInt);
    AppMethodBeat.o(20866);
  }
  
  public void setInfoIvOnClickListener(AddrEditView.a parama)
  {
    this.jsB = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20867);
    this.jsF.setVisibility(paramInt);
    AppMethodBeat.o(20867);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(20855);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(20855);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(20858);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.jsD = paramOnFocusChangeListener;
    AppMethodBeat.o(20858);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.jsC = paramb;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20861);
    this.iCW.setText(paramString);
    AppMethodBeat.o(20861);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20865);
    if (this.iCW != null) {
      this.iCW.setTextColor(paramInt);
    }
    AppMethodBeat.o(20865);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20862);
    this.jsE.setText(paramString);
    this.jsE.setSelection(this.jsE.getText().length());
    this.jsQ = paramString;
    AppMethodBeat.o(20862);
  }
  
  public static abstract interface b
  {
    public abstract void aUX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView
 * JD-Core Version:    0.7.0.1
 */