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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;

public class AddrEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private int imeOptions;
  private int inputType;
  private TextView jBS;
  private boolean kK;
  private AddrEditView.a ktI;
  private b ktJ;
  private View.OnFocusChangeListener ktK;
  EditText ktL;
  private ImageView ktM;
  private String ktN;
  private String ktO;
  private int ktP;
  private int ktQ;
  public boolean ktR;
  private int ktS;
  private boolean ktT;
  private int ktU;
  private int ktV;
  private View.OnClickListener ktW;
  private String ktX;
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20850);
    this.ktN = "";
    this.ktO = "";
    this.inputType = 1;
    this.gravity = 19;
    this.ktP = -1;
    this.background = -1;
    this.ktQ = -1;
    this.ktR = true;
    this.ktT = false;
    this.ktU = 1;
    this.ktV = 30;
    this.kK = true;
    this.ktW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20849);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/AddrEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (AddrEditView.f(AddrEditView.this).getVisibility() == 0)
        {
          if ((!AddrEditView.this.ktR) || (AddrEditView.d(AddrEditView.this) == 2) || (Util.isNullOrNil(AddrEditView.this.getText()))) {
            break label130;
          }
          AddrEditView.this.ktL.setText("");
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
    this.ktX = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AddrEditView, paramInt, 0);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131492979, this, true);
    this.ktL = ((EditText)paramAttributeSet.findViewById(2131302331));
    this.ktL.setTextSize(0, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
    this.jBS = ((TextView)paramAttributeSet.findViewById(2131309163));
    this.ktM = ((ImageView)paramAttributeSet.findViewById(2131302653));
    this.ktM.setOnClickListener(this.ktW);
    this.ktL.setImeOptions(this.imeOptions);
    this.ktL.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.ktL.setKeyListener(new NumberKeyListener()
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
      gr(this.ktL.isFocused());
      this.ktL.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20848);
          boolean bool = AddrEditView.this.bql();
          if ((bool != AddrEditView.a(AddrEditView.this)) && (AddrEditView.b(AddrEditView.this) != null))
          {
            Log.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(AddrEditView.this) + ", editType:" + AddrEditView.d(AddrEditView.this) + " inputValid change to " + bool);
            AddrEditView.a(AddrEditView.this, bool);
            paramAnonymousEditable = AddrEditView.b(AddrEditView.this);
            AddrEditView.a(AddrEditView.this);
            paramAnonymousEditable.bqh();
          }
          AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
          AppMethodBeat.o(20848);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.ktL.setOnFocusChangeListener(this);
      if (!Util.isNullOrNil(this.ktN)) {
        this.ktL.setHint(this.ktN);
      }
      if (!Util.isNullOrNil(this.ktO)) {
        this.jBS.setText(this.ktO);
      }
      paramAttributeSet = new Rect();
      d(this.ktL, paramAttributeSet);
      if (this.ktR) {
        break label663;
      }
      this.ktL.setEnabled(false);
      this.ktL.setTextColor(getResources().getColor(2131099913));
      this.ktL.setFocusable(false);
      this.ktL.setClickable(false);
      this.ktL.setBackgroundResource(2131235359);
      setBackgroundResource(2131233952);
      setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      e(this.ktL, paramAttributeSet);
      this.ktL.setGravity(this.gravity);
      if (this.ktS != -1) {
        this.ktM.setImageDrawable(ar.m(paramContext, this.ktS, paramContext.getResources().getColor(2131099746)));
      }
      if (!this.kK) {
        this.ktL.setSingleLine(false);
      }
      AppMethodBeat.o(20850);
      return;
      if (this.inputType == 3)
      {
        this.ktL.setKeyListener(new NumberKeyListener()
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
      this.ktL.setInputType(this.inputType);
      break;
      label663:
      this.ktT = false;
      this.ktL.setBackgroundResource(this.ktQ);
      setBackgroundResource(this.background);
    }
  }
  
  private static int TE(String paramString)
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
  
  private static void d(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20869);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(20869);
  }
  
  private static void e(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20870);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(20870);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20868);
    Rect localRect = new Rect();
    this.ktM.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20868);
    return localRect;
  }
  
  private void gr(boolean paramBoolean)
  {
    AppMethodBeat.i(20857);
    if ((this.ktR) && (!Util.isNullOrNil(getText())))
    {
      this.ktM.setImageDrawable(at.aN(getContext(), 2130969010));
      this.ktM.setContentDescription(getContext().getString(2131757636));
      switch (this.ktP)
      {
      default: 
        this.ktM.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 0: 
      case 1: 
        if (paramBoolean)
        {
          this.ktM.setVisibility(0);
          AppMethodBeat.o(20857);
          return;
        }
        this.ktM.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 3: 
        this.ktM.setVisibility(0);
        this.ktM.setImageResource(2131690826);
        this.ktM.setContentDescription(getContext().getString(2131755244));
        AppMethodBeat.o(20857);
        return;
      }
      this.ktM.setVisibility(0);
      this.ktM.setImageResource(2131690913);
      this.ktM.setContentDescription(getContext().getString(2131755197));
      AppMethodBeat.o(20857);
      return;
    }
    switch (this.ktP)
    {
    default: 
      this.ktM.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 0: 
    case 1: 
      this.ktM.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 3: 
      this.ktM.setVisibility(0);
      this.ktM.setImageResource(2131690826);
      this.ktM.setContentDescription(getContext().getString(2131755244));
      AppMethodBeat.o(20857);
      return;
    }
    this.ktM.setVisibility(0);
    this.ktM.setImageResource(2131690913);
    this.ktM.setContentDescription(getContext().getString(2131755197));
    AppMethodBeat.o(20857);
  }
  
  public final void bqk()
  {
    AppMethodBeat.i(231574);
    this.ktL.setHintTextColor(getContext().getResources().getColor(2131099834));
    this.ktL.setTextColor(getContext().getResources().getColor(2131099836));
    this.jBS.setTextColor(getContext().getResources().getColor(2131099836));
    if (this.ktS != -1) {
      this.ktM.setImageDrawable(ar.m(getContext(), this.ktS, getContext().getResources().getColor(2131099836)));
    }
    AppMethodBeat.o(231574);
  }
  
  public final boolean bql()
  {
    AppMethodBeat.i(20856);
    Object localObject = this.ktL.getText().toString();
    switch (this.ktP)
    {
    case 0: 
    default: 
      if (((String)localObject).length() >= this.ktU)
      {
        AppMethodBeat.o(20856);
        return true;
      }
      break;
    case 1: 
      if ((((String)localObject).length() >= this.ktU) && (((String)localObject).length() <= this.ktV))
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
      if ((((String)localObject).length() >= this.ktU) && (TE((String)localObject) <= 32))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 3: 
    case 5: 
      if ((((String)localObject).length() >= this.ktU) && (TE((String)localObject) <= 128))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 4: 
      if (((String)localObject).length() <= this.ktV)
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
  
  public final boolean bqm()
  {
    AppMethodBeat.i(20863);
    if (getText().equals(Util.nullAsNil(this.ktX)))
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
    String str = this.ktL.getText().toString();
    AppMethodBeat.o(20851);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20859);
    if (this.ktK != null) {
      this.ktK.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.AddrEditView", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + paramBoolean);
    if (this.ktJ != null) {
      this.ktJ.bqh();
    }
    if (!this.ktT)
    {
      this.jBS.setEnabled(false);
      if (paramView == this.ktL)
      {
        paramView = new Rect();
        d(this, paramView);
        if (!paramBoolean) {
          break label164;
        }
        setBackgroundResource(2131233162);
      }
    }
    for (;;)
    {
      e(this, paramView);
      gr(paramBoolean);
      AppMethodBeat.o(20859);
      return;
      this.jBS.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131233163);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20854);
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
    if (this.ktL != null)
    {
      Rect localRect = new Rect();
      d(this.ktL, localRect);
      this.ktL.setBackgroundResource(paramInt);
      e(this.ktL, localRect);
    }
    AppMethodBeat.o(20864);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20852);
    this.ktL.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20852);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20853);
    super.setEnabled(paramBoolean);
    this.ktR = paramBoolean;
    this.ktM.setEnabled(true);
    AppMethodBeat.o(20853);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20860);
    this.ktL.setHint(paramString);
    AppMethodBeat.o(20860);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20866);
    this.ktL.setImeOptions(paramInt);
    AppMethodBeat.o(20866);
  }
  
  public void setInfoIvOnClickListener(AddrEditView.a parama)
  {
    this.ktI = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20867);
    this.ktM.setVisibility(paramInt);
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
    this.ktK = paramOnFocusChangeListener;
    AppMethodBeat.o(20858);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.ktJ = paramb;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20861);
    this.jBS.setText(paramString);
    AppMethodBeat.o(20861);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20865);
    if (this.jBS != null) {
      this.jBS.setTextColor(paramInt);
    }
    AppMethodBeat.o(20865);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20862);
    this.ktL.setText(paramString);
    this.ktL.setSelection(this.ktL.getText().length());
    this.ktX = paramString;
    AppMethodBeat.o(20862);
  }
  
  public static abstract interface b
  {
    public abstract void bqh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView
 * JD-Core Version:    0.7.0.1
 */