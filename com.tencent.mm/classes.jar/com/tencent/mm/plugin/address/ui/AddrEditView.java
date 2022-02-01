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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;

public class AddrEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private TextView hJf;
  private boolean hO;
  private int imeOptions;
  private int inputType;
  private boolean izA;
  private int izB;
  private int izC;
  private View.OnClickListener izD;
  private String izE;
  private a izp;
  private b izq;
  private View.OnFocusChangeListener izr;
  EditText izs;
  private ImageView izt;
  private String izu;
  private String izv;
  private int izw;
  private int izx;
  public boolean izy;
  private int izz;
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20850);
    this.izu = "";
    this.izv = "";
    this.inputType = 1;
    this.gravity = 19;
    this.izw = -1;
    this.background = -1;
    this.izx = -1;
    this.izy = true;
    this.izA = false;
    this.izB = 1;
    this.izC = 30;
    this.hO = true;
    this.izD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20849);
        if (AddrEditView.f(AddrEditView.this).getVisibility() == 0)
        {
          if ((AddrEditView.this.izy) && (AddrEditView.d(AddrEditView.this) != 2) && (!bt.isNullOrNil(AddrEditView.this.getText())))
          {
            AddrEditView.this.izs.setText("");
            AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
            AppMethodBeat.o(20849);
            return;
          }
          if (AddrEditView.g(AddrEditView.this) != null) {
            AddrEditView.g(AddrEditView.this).onClick();
          }
        }
        AppMethodBeat.o(20849);
      }
    };
    this.izE = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AddrEditView, paramInt, 0);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131492946, this, true);
    this.izs = ((EditText)paramAttributeSet.findViewById(2131300744));
    this.izs.setTextSize(0, a.ao(paramContext, 2131165517));
    this.hJf = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.izt = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.izt.setOnClickListener(this.izD);
    this.izs.setImeOptions(this.imeOptions);
    this.izs.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.izs.setKeyListener(new NumberKeyListener()
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
      eZ(this.izs.isFocused());
      this.izs.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20848);
          boolean bool = AddrEditView.this.aKX();
          if ((bool != AddrEditView.a(AddrEditView.this)) && (AddrEditView.b(AddrEditView.this) != null))
          {
            ad.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(AddrEditView.this) + ", editType:" + AddrEditView.d(AddrEditView.this) + " inputValid change to " + bool);
            AddrEditView.a(AddrEditView.this, bool);
            paramAnonymousEditable = AddrEditView.b(AddrEditView.this);
            AddrEditView.a(AddrEditView.this);
            paramAnonymousEditable.aKU();
          }
          AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
          AppMethodBeat.o(20848);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.izs.setOnFocusChangeListener(this);
      if (!bt.isNullOrNil(this.izu)) {
        this.izs.setHint(this.izu);
      }
      if (!bt.isNullOrNil(this.izv)) {
        this.hJf.setText(this.izv);
      }
      paramAttributeSet = new Rect();
      h(this.izs, paramAttributeSet);
      if (this.izy) {
        break label663;
      }
      this.izs.setEnabled(false);
      this.izs.setTextColor(getResources().getColor(2131099895));
      this.izs.setFocusable(false);
      this.izs.setClickable(false);
      this.izs.setBackgroundResource(2131234429);
      setBackgroundResource(2131233277);
      setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.izs, paramAttributeSet);
      this.izs.setGravity(this.gravity);
      if (this.izz != -1) {
        this.izt.setImageDrawable(am.i(paramContext, this.izz, paramContext.getResources().getColor(2131099732)));
      }
      if (!this.hO) {
        this.izs.setSingleLine(false);
      }
      AppMethodBeat.o(20850);
      return;
      if (this.inputType == 3)
      {
        this.izs.setKeyListener(new NumberKeyListener()
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
      this.izs.setInputType(this.inputType);
      break;
      label663:
      this.izA = false;
      this.izs.setBackgroundResource(this.izx);
      setBackgroundResource(this.background);
    }
  }
  
  private static int CO(String paramString)
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
  
  private void eZ(boolean paramBoolean)
  {
    AppMethodBeat.i(20857);
    if ((this.izy) && (!bt.isNullOrNil(getText())))
    {
      this.izt.setImageDrawable(ao.aC(getContext(), 2130968981));
      this.izt.setContentDescription(getContext().getString(2131757419));
      switch (this.izw)
      {
      default: 
        this.izt.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 0: 
      case 1: 
        if (paramBoolean)
        {
          this.izt.setVisibility(0);
          AppMethodBeat.o(20857);
          return;
        }
        this.izt.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 3: 
        this.izt.setVisibility(0);
        this.izt.setImageResource(2131690589);
        this.izt.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20857);
        return;
      }
      this.izt.setVisibility(0);
      this.izt.setImageResource(2131690659);
      this.izt.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20857);
      return;
    }
    switch (this.izw)
    {
    default: 
      this.izt.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 0: 
    case 1: 
      this.izt.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 3: 
      this.izt.setVisibility(0);
      this.izt.setImageResource(2131690589);
      this.izt.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20857);
      return;
    }
    this.izt.setVisibility(0);
    this.izt.setImageResource(2131690659);
    this.izt.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20857);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20868);
    Rect localRect = new Rect();
    this.izt.getHitRect(localRect);
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
  
  public final boolean aKX()
  {
    AppMethodBeat.i(20856);
    Object localObject = this.izs.getText().toString();
    switch (this.izw)
    {
    case 0: 
    default: 
      if (((String)localObject).length() >= this.izB)
      {
        AppMethodBeat.o(20856);
        return true;
      }
      break;
    case 1: 
      if ((((String)localObject).length() >= this.izB) && (((String)localObject).length() <= this.izC))
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
      if ((((String)localObject).length() >= this.izB) && (CO((String)localObject) <= 32))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 3: 
    case 5: 
      if ((((String)localObject).length() >= this.izB) && (CO((String)localObject) <= 128))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 4: 
      if (((String)localObject).length() <= this.izC)
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
  
  public final boolean aKY()
  {
    AppMethodBeat.i(20863);
    if (getText().equals(bt.nullAsNil(this.izE)))
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
    String str = this.izs.getText().toString();
    AppMethodBeat.o(20851);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20859);
    if (this.izr != null) {
      this.izr.onFocusChange(this, paramBoolean);
    }
    ad.d("MicroMsg.AddrEditView", "View:" + this.izv + ", editType:" + this.izw + " onFocusChange to " + paramBoolean);
    if (this.izq != null) {
      this.izq.aKU();
    }
    if (!this.izA)
    {
      this.hJf.setEnabled(false);
      if (paramView == this.izs)
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
      eZ(paramBoolean);
      AppMethodBeat.o(20859);
      return;
      this.hJf.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20854);
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
    if (this.izs != null)
    {
      Rect localRect = new Rect();
      h(this.izs, localRect);
      this.izs.setBackgroundResource(paramInt);
      i(this.izs, localRect);
    }
    AppMethodBeat.o(20864);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20852);
    this.izs.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20852);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20853);
    super.setEnabled(paramBoolean);
    this.izy = paramBoolean;
    this.izt.setEnabled(true);
    AppMethodBeat.o(20853);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20860);
    this.izs.setHint(paramString);
    AppMethodBeat.o(20860);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20866);
    this.izs.setImeOptions(paramInt);
    AppMethodBeat.o(20866);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.izp = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20867);
    this.izt.setVisibility(paramInt);
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
    this.izr = paramOnFocusChangeListener;
    AppMethodBeat.o(20858);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.izq = paramb;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20861);
    this.hJf.setText(paramString);
    AppMethodBeat.o(20861);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20865);
    if (this.hJf != null) {
      this.hJf.setTextColor(paramInt);
    }
    AppMethodBeat.o(20865);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20862);
    this.izs.setText(paramString);
    this.izs.setSelection(this.izs.getText().length());
    this.izE = paramString;
    AppMethodBeat.o(20862);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
  
  public static abstract interface b
  {
    public abstract void aKU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView
 * JD-Core Version:    0.7.0.1
 */