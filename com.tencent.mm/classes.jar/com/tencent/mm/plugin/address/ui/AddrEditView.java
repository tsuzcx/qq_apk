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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;

public class AddrEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private TextView iFP;
  private int imeOptions;
  private int inputType;
  private String jvA;
  private int jvB;
  private int jvC;
  public boolean jvD;
  private int jvE;
  private boolean jvF;
  private int jvG;
  private int jvH;
  private View.OnClickListener jvI;
  private String jvJ;
  private AddrEditView.a jvu;
  private b jvv;
  private View.OnFocusChangeListener jvw;
  EditText jvx;
  private ImageView jvy;
  private String jvz;
  private boolean kI;
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20850);
    this.jvz = "";
    this.jvA = "";
    this.inputType = 1;
    this.gravity = 19;
    this.jvB = -1;
    this.background = -1;
    this.jvC = -1;
    this.jvD = true;
    this.jvF = false;
    this.jvG = 1;
    this.jvH = 30;
    this.kI = true;
    this.jvI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20849);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/AddrEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (AddrEditView.f(AddrEditView.this).getVisibility() == 0)
        {
          if ((!AddrEditView.this.jvD) || (AddrEditView.d(AddrEditView.this) == 2) || (bu.isNullOrNil(AddrEditView.this.getText()))) {
            break label130;
          }
          AddrEditView.this.jvx.setText("");
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
    this.jvJ = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AddrEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.jvz = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.jvA = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(3, 1);
    this.jvB = paramAttributeSet.getInteger(5, 0);
    this.jvD = paramAttributeSet.getBoolean(6, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.imeOptions = paramAttributeSet.getInteger(4, 5);
    this.background = paramAttributeSet.getResourceId(1, 2131234429);
    this.jvE = paramAttributeSet.getResourceId(10, -1);
    this.jvC = paramAttributeSet.getResourceId(8, 2131234429);
    this.kI = paramAttributeSet.getBoolean(12, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131492946, this, true);
    this.jvx = ((EditText)paramAttributeSet.findViewById(2131300744));
    this.jvx.setTextSize(0, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
    this.iFP = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.jvy = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.jvy.setOnClickListener(this.jvI);
    this.jvx.setImeOptions(this.imeOptions);
    this.jvx.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.jvx.setKeyListener(new NumberKeyListener()
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
      fy(this.jvx.isFocused());
      this.jvx.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20848);
          boolean bool = AddrEditView.this.aVz();
          if ((bool != AddrEditView.a(AddrEditView.this)) && (AddrEditView.b(AddrEditView.this) != null))
          {
            ae.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(AddrEditView.this) + ", editType:" + AddrEditView.d(AddrEditView.this) + " inputValid change to " + bool);
            AddrEditView.a(AddrEditView.this, bool);
            paramAnonymousEditable = AddrEditView.b(AddrEditView.this);
            AddrEditView.a(AddrEditView.this);
            paramAnonymousEditable.aVw();
          }
          AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
          AppMethodBeat.o(20848);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.jvx.setOnFocusChangeListener(this);
      if (!bu.isNullOrNil(this.jvz)) {
        this.jvx.setHint(this.jvz);
      }
      if (!bu.isNullOrNil(this.jvA)) {
        this.iFP.setText(this.jvA);
      }
      paramAttributeSet = new Rect();
      h(this.jvx, paramAttributeSet);
      if (this.jvD) {
        break label663;
      }
      this.jvx.setEnabled(false);
      this.jvx.setTextColor(getResources().getColor(2131099895));
      this.jvx.setFocusable(false);
      this.jvx.setClickable(false);
      this.jvx.setBackgroundResource(2131234429);
      setBackgroundResource(2131233277);
      setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.jvx, paramAttributeSet);
      this.jvx.setGravity(this.gravity);
      if (this.jvE != -1) {
        this.jvy.setImageDrawable(ao.k(paramContext, this.jvE, paramContext.getResources().getColor(2131099732)));
      }
      if (!this.kI) {
        this.jvx.setSingleLine(false);
      }
      AppMethodBeat.o(20850);
      return;
      if (this.inputType == 3)
      {
        this.jvx.setKeyListener(new NumberKeyListener()
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
      this.jvx.setInputType(this.inputType);
      break;
      label663:
      this.jvF = false;
      this.jvx.setBackgroundResource(this.jvC);
      setBackgroundResource(this.background);
    }
  }
  
  private static int KF(String paramString)
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
  
  private void fy(boolean paramBoolean)
  {
    AppMethodBeat.i(20857);
    if ((this.jvD) && (!bu.isNullOrNil(getText())))
    {
      this.jvy.setImageDrawable(aq.aM(getContext(), 2130968981));
      this.jvy.setContentDescription(getContext().getString(2131757419));
      switch (this.jvB)
      {
      default: 
        this.jvy.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 0: 
      case 1: 
        if (paramBoolean)
        {
          this.jvy.setVisibility(0);
          AppMethodBeat.o(20857);
          return;
        }
        this.jvy.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 3: 
        this.jvy.setVisibility(0);
        this.jvy.setImageResource(2131690589);
        this.jvy.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20857);
        return;
      }
      this.jvy.setVisibility(0);
      this.jvy.setImageResource(2131690659);
      this.jvy.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20857);
      return;
    }
    switch (this.jvB)
    {
    default: 
      this.jvy.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 0: 
    case 1: 
      this.jvy.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 3: 
      this.jvy.setVisibility(0);
      this.jvy.setImageResource(2131690589);
      this.jvy.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20857);
      return;
    }
    this.jvy.setVisibility(0);
    this.jvy.setImageResource(2131690659);
    this.jvy.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20857);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20868);
    Rect localRect = new Rect();
    this.jvy.getHitRect(localRect);
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
  
  public final boolean aVA()
  {
    AppMethodBeat.i(20863);
    if (getText().equals(bu.nullAsNil(this.jvJ)))
    {
      AppMethodBeat.o(20863);
      return false;
    }
    AppMethodBeat.o(20863);
    return true;
  }
  
  public final boolean aVz()
  {
    AppMethodBeat.i(20856);
    Object localObject = this.jvx.getText().toString();
    switch (this.jvB)
    {
    case 0: 
    default: 
      if (((String)localObject).length() >= this.jvG)
      {
        AppMethodBeat.o(20856);
        return true;
      }
      break;
    case 1: 
      if ((((String)localObject).length() >= this.jvG) && (((String)localObject).length() <= this.jvH))
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
      if ((((String)localObject).length() >= this.jvG) && (KF((String)localObject) <= 32))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 3: 
    case 5: 
      if ((((String)localObject).length() >= this.jvG) && (KF((String)localObject) <= 128))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 4: 
      if (((String)localObject).length() <= this.jvH)
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
  
  public String getText()
  {
    AppMethodBeat.i(20851);
    String str = this.jvx.getText().toString();
    AppMethodBeat.o(20851);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20859);
    if (this.jvw != null) {
      this.jvw.onFocusChange(this, paramBoolean);
    }
    ae.d("MicroMsg.AddrEditView", "View:" + this.jvA + ", editType:" + this.jvB + " onFocusChange to " + paramBoolean);
    if (this.jvv != null) {
      this.jvv.aVw();
    }
    if (!this.jvF)
    {
      this.iFP.setEnabled(false);
      if (paramView == this.jvx)
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
      fy(paramBoolean);
      AppMethodBeat.o(20859);
      return;
      this.iFP.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20854);
    int i;
    if (!this.jvD)
    {
      if (this.jvy.getVisibility() != 0) {
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
    if (this.jvx != null)
    {
      Rect localRect = new Rect();
      h(this.jvx, localRect);
      this.jvx.setBackgroundResource(paramInt);
      i(this.jvx, localRect);
    }
    AppMethodBeat.o(20864);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20852);
    this.jvx.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20852);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20853);
    super.setEnabled(paramBoolean);
    this.jvD = paramBoolean;
    this.jvy.setEnabled(true);
    AppMethodBeat.o(20853);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20860);
    this.jvx.setHint(paramString);
    AppMethodBeat.o(20860);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20866);
    this.jvx.setImeOptions(paramInt);
    AppMethodBeat.o(20866);
  }
  
  public void setInfoIvOnClickListener(AddrEditView.a parama)
  {
    this.jvu = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20867);
    this.jvy.setVisibility(paramInt);
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
    this.jvw = paramOnFocusChangeListener;
    AppMethodBeat.o(20858);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.jvv = paramb;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20861);
    this.iFP.setText(paramString);
    AppMethodBeat.o(20861);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20865);
    if (this.iFP != null) {
      this.iFP.setTextColor(paramInt);
    }
    AppMethodBeat.o(20865);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20862);
    this.jvx.setText(paramString);
    this.jvx.setSelection(this.jvx.getText().length());
    this.jvJ = paramString;
    AppMethodBeat.o(20862);
  }
  
  public static abstract interface b
  {
    public abstract void aVw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView
 * JD-Core Version:    0.7.0.1
 */