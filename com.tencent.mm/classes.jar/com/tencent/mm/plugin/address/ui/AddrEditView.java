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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;

public class AddrEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private boolean iR;
  private int iZA;
  public boolean iZB;
  private int iZC;
  private boolean iZD;
  private int iZE;
  private int iZF;
  private View.OnClickListener iZG;
  private String iZH;
  private AddrEditView.a iZs;
  private b iZt;
  private View.OnFocusChangeListener iZu;
  EditText iZv;
  private ImageView iZw;
  private String iZx;
  private String iZy;
  private int iZz;
  private TextView ijF;
  private int imeOptions;
  private int inputType;
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20850);
    this.iZx = "";
    this.iZy = "";
    this.inputType = 1;
    this.gravity = 19;
    this.iZz = -1;
    this.background = -1;
    this.iZA = -1;
    this.iZB = true;
    this.iZD = false;
    this.iZE = 1;
    this.iZF = 30;
    this.iR = true;
    this.iZG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20849);
        if (AddrEditView.f(AddrEditView.this).getVisibility() == 0)
        {
          if ((AddrEditView.this.iZB) && (AddrEditView.d(AddrEditView.this) != 2) && (!bs.isNullOrNil(AddrEditView.this.getText())))
          {
            AddrEditView.this.iZv.setText("");
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
    this.iZH = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AddrEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.iZx = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.iZy = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(3, 1);
    this.iZz = paramAttributeSet.getInteger(5, 0);
    this.iZB = paramAttributeSet.getBoolean(6, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.imeOptions = paramAttributeSet.getInteger(4, 5);
    this.background = paramAttributeSet.getResourceId(1, 2131234429);
    this.iZC = paramAttributeSet.getResourceId(10, -1);
    this.iZA = paramAttributeSet.getResourceId(8, 2131234429);
    this.iR = paramAttributeSet.getBoolean(12, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131492946, this, true);
    this.iZv = ((EditText)paramAttributeSet.findViewById(2131300744));
    this.iZv.setTextSize(0, a.au(paramContext, 2131165517));
    this.ijF = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.iZw = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.iZw.setOnClickListener(this.iZG);
    this.iZv.setImeOptions(this.imeOptions);
    this.iZv.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.iZv.setKeyListener(new NumberKeyListener()
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
      ft(this.iZv.isFocused());
      this.iZv.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20848);
          boolean bool = AddrEditView.this.aRO();
          if ((bool != AddrEditView.a(AddrEditView.this)) && (AddrEditView.b(AddrEditView.this) != null))
          {
            ac.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(AddrEditView.this) + ", editType:" + AddrEditView.d(AddrEditView.this) + " inputValid change to " + bool);
            AddrEditView.a(AddrEditView.this, bool);
            paramAnonymousEditable = AddrEditView.b(AddrEditView.this);
            AddrEditView.a(AddrEditView.this);
            paramAnonymousEditable.aRL();
          }
          AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
          AppMethodBeat.o(20848);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.iZv.setOnFocusChangeListener(this);
      if (!bs.isNullOrNil(this.iZx)) {
        this.iZv.setHint(this.iZx);
      }
      if (!bs.isNullOrNil(this.iZy)) {
        this.ijF.setText(this.iZy);
      }
      paramAttributeSet = new Rect();
      h(this.iZv, paramAttributeSet);
      if (this.iZB) {
        break label663;
      }
      this.iZv.setEnabled(false);
      this.iZv.setTextColor(getResources().getColor(2131099895));
      this.iZv.setFocusable(false);
      this.iZv.setClickable(false);
      this.iZv.setBackgroundResource(2131234429);
      setBackgroundResource(2131233277);
      setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.iZv, paramAttributeSet);
      this.iZv.setGravity(this.gravity);
      if (this.iZC != -1) {
        this.iZw.setImageDrawable(am.k(paramContext, this.iZC, paramContext.getResources().getColor(2131099732)));
      }
      if (!this.iR) {
        this.iZv.setSingleLine(false);
      }
      AppMethodBeat.o(20850);
      return;
      if (this.inputType == 3)
      {
        this.iZv.setKeyListener(new NumberKeyListener()
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
      this.iZv.setInputType(this.inputType);
      break;
      label663:
      this.iZD = false;
      this.iZv.setBackgroundResource(this.iZA);
      setBackgroundResource(this.background);
    }
  }
  
  private static int GR(String paramString)
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
  
  private void ft(boolean paramBoolean)
  {
    AppMethodBeat.i(20857);
    if ((this.iZB) && (!bs.isNullOrNil(getText())))
    {
      this.iZw.setImageDrawable(ao.aI(getContext(), 2130968981));
      this.iZw.setContentDescription(getContext().getString(2131757419));
      switch (this.iZz)
      {
      default: 
        this.iZw.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 0: 
      case 1: 
        if (paramBoolean)
        {
          this.iZw.setVisibility(0);
          AppMethodBeat.o(20857);
          return;
        }
        this.iZw.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 3: 
        this.iZw.setVisibility(0);
        this.iZw.setImageResource(2131690589);
        this.iZw.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20857);
        return;
      }
      this.iZw.setVisibility(0);
      this.iZw.setImageResource(2131690659);
      this.iZw.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20857);
      return;
    }
    switch (this.iZz)
    {
    default: 
      this.iZw.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 0: 
    case 1: 
      this.iZw.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 3: 
      this.iZw.setVisibility(0);
      this.iZw.setImageResource(2131690589);
      this.iZw.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20857);
      return;
    }
    this.iZw.setVisibility(0);
    this.iZw.setImageResource(2131690659);
    this.iZw.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20857);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20868);
    Rect localRect = new Rect();
    this.iZw.getHitRect(localRect);
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
  
  public final boolean aRO()
  {
    AppMethodBeat.i(20856);
    Object localObject = this.iZv.getText().toString();
    switch (this.iZz)
    {
    case 0: 
    default: 
      if (((String)localObject).length() >= this.iZE)
      {
        AppMethodBeat.o(20856);
        return true;
      }
      break;
    case 1: 
      if ((((String)localObject).length() >= this.iZE) && (((String)localObject).length() <= this.iZF))
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
      if ((((String)localObject).length() >= this.iZE) && (GR((String)localObject) <= 32))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 3: 
    case 5: 
      if ((((String)localObject).length() >= this.iZE) && (GR((String)localObject) <= 128))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 4: 
      if (((String)localObject).length() <= this.iZF)
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
  
  public final boolean aRP()
  {
    AppMethodBeat.i(20863);
    if (getText().equals(bs.nullAsNil(this.iZH)))
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
    String str = this.iZv.getText().toString();
    AppMethodBeat.o(20851);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20859);
    if (this.iZu != null) {
      this.iZu.onFocusChange(this, paramBoolean);
    }
    ac.d("MicroMsg.AddrEditView", "View:" + this.iZy + ", editType:" + this.iZz + " onFocusChange to " + paramBoolean);
    if (this.iZt != null) {
      this.iZt.aRL();
    }
    if (!this.iZD)
    {
      this.ijF.setEnabled(false);
      if (paramView == this.iZv)
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
      ft(paramBoolean);
      AppMethodBeat.o(20859);
      return;
      this.ijF.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20854);
    int i;
    if (!this.iZB)
    {
      if (this.iZw.getVisibility() != 0) {
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
    if (this.iZv != null)
    {
      Rect localRect = new Rect();
      h(this.iZv, localRect);
      this.iZv.setBackgroundResource(paramInt);
      i(this.iZv, localRect);
    }
    AppMethodBeat.o(20864);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20852);
    this.iZv.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20852);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20853);
    super.setEnabled(paramBoolean);
    this.iZB = paramBoolean;
    this.iZw.setEnabled(true);
    AppMethodBeat.o(20853);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20860);
    this.iZv.setHint(paramString);
    AppMethodBeat.o(20860);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20866);
    this.iZv.setImeOptions(paramInt);
    AppMethodBeat.o(20866);
  }
  
  public void setInfoIvOnClickListener(AddrEditView.a parama)
  {
    this.iZs = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20867);
    this.iZw.setVisibility(paramInt);
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
    this.iZu = paramOnFocusChangeListener;
    AppMethodBeat.o(20858);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.iZt = paramb;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20861);
    this.ijF.setText(paramString);
    AppMethodBeat.o(20861);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20865);
    if (this.ijF != null) {
      this.ijF.setTextColor(paramInt);
    }
    AppMethodBeat.o(20865);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20862);
    this.iZv.setText(paramString);
    this.iZv.setSelection(this.iZv.getText().length());
    this.iZH = paramString;
    AppMethodBeat.o(20862);
  }
  
  public static abstract interface b
  {
    public abstract void aRL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView
 * JD-Core Version:    0.7.0.1
 */