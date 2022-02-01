package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.n;
import com.tencent.mm.ck.a.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;

public class AddrEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private boolean bcF;
  private int editType;
  private int fl;
  private int inputType;
  private TextView pls;
  private AddrEditView.a qiF;
  private b qiG;
  private View.OnFocusChangeListener qiH;
  EditText qiI;
  private ImageView qiJ;
  private String qiK;
  private String qiL;
  private int qiM;
  private int qiN;
  public boolean qiO;
  private int qiP;
  private boolean qiQ;
  private int qiR;
  private int qiS;
  private View.OnClickListener qiT;
  private String qiU;
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20850);
    this.qiK = "";
    this.qiL = "";
    this.inputType = 1;
    this.fl = 19;
    this.editType = -1;
    this.background = -1;
    this.qiN = -1;
    this.qiO = true;
    this.qiQ = false;
    this.qiR = 1;
    this.qiS = 20;
    this.bcF = true;
    this.qiT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20849);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/AddrEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (AddrEditView.f(AddrEditView.this).getVisibility() == 0)
        {
          if ((!AddrEditView.this.qiO) || (AddrEditView.d(AddrEditView.this) == 2) || (Util.isNullOrNil(AddrEditView.this.getText()))) {
            break label130;
          }
          AddrEditView.this.qiI.setText("");
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
    this.qiU = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.gZy, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(R.n.gZF, 0);
    if (paramInt != 0) {
      this.qiK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(R.n.gZJ, 0);
    if (paramInt != 0) {
      this.qiL = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(R.n.gZB, 1);
    this.editType = paramAttributeSet.getInteger(R.n.gZD, 0);
    this.qiO = paramAttributeSet.getBoolean(R.n.gZE, true);
    this.fl = paramAttributeSet.getInt(R.n.gZz, 19);
    this.qiM = paramAttributeSet.getInteger(R.n.gZC, 5);
    this.background = paramAttributeSet.getResourceId(R.n.gZA, R.g.transparent_background);
    this.qiP = paramAttributeSet.getResourceId(R.n.gZH, -1);
    this.qiN = paramAttributeSet.getResourceId(R.n.gZG, R.g.transparent_background);
    this.bcF = paramAttributeSet.getBoolean(R.n.gZI, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.gdV, this, true);
    this.qiI = ((EditText)paramAttributeSet.findViewById(R.h.hint_et));
    this.qiI.setTextSize(0, com.tencent.mm.cd.a.br(paramContext, R.f.NormalTextSize));
    this.pls = ((TextView)paramAttributeSet.findViewById(R.h.tip_tv));
    this.qiJ = ((ImageView)paramAttributeSet.findViewById(R.h.info_iv));
    this.qiJ.setOnClickListener(this.qiT);
    this.qiI.setImeOptions(this.qiM);
    this.qiI.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.qiI.setKeyListener(new NumberKeyListener()
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
      hS(this.qiI.isFocused());
      this.qiI.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20848);
          boolean bool = AddrEditView.this.bZp();
          if ((bool != AddrEditView.a(AddrEditView.this)) && (AddrEditView.b(AddrEditView.this) != null))
          {
            Log.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(AddrEditView.this) + ", editType:" + AddrEditView.d(AddrEditView.this) + " inputValid change to " + bool);
            AddrEditView.a(AddrEditView.this, bool);
            paramAnonymousEditable = AddrEditView.b(AddrEditView.this);
            AddrEditView.a(AddrEditView.this);
            paramAnonymousEditable.bZl();
          }
          AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
          AppMethodBeat.o(20848);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.qiI.setOnFocusChangeListener(this);
      if (!Util.isNullOrNil(this.qiK)) {
        this.qiI.setHint(this.qiK);
      }
      if (!Util.isNullOrNil(this.qiL)) {
        this.pls.setText(this.qiL);
      }
      paramAttributeSet = new Rect();
      d(this.qiI, paramAttributeSet);
      if (this.qiO) {
        break label701;
      }
      this.qiI.setEnabled(false);
      this.qiI.setFocusable(false);
      this.qiI.setClickable(false);
      this.qiI.setBackgroundResource(R.g.transparent_background);
      setBackgroundResource(R.g.mm_listitem);
      setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 8), getPaddingTop(), com.tencent.mm.cd.a.fromDPToPix(getContext(), 8), getPaddingBottom());
    }
    for (;;)
    {
      e(this.qiI, paramAttributeSet);
      this.qiI.setGravity(this.fl);
      if (this.qiP != -1) {
        this.qiJ.setImageDrawable(bb.m(paramContext, this.qiP, paramContext.getResources().getColor(R.e.FG_0)));
      }
      if (!this.bcF) {
        this.qiI.setSingleLine(false);
      }
      AppMethodBeat.o(20850);
      return;
      if (this.inputType == 3)
      {
        this.qiI.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 43 };
          }
          
          public final int getInputType()
          {
            return 3;
          }
        });
        this.qiI.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.qiS) });
        break;
      }
      this.qiI.setInputType(this.inputType);
      break;
      label701:
      this.qiQ = false;
      this.qiI.setBackgroundResource(this.qiN);
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
    this.qiJ.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20868);
    return localRect;
  }
  
  private void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(20857);
    if ((this.qiO) && (!Util.isNullOrNil(getText())))
    {
      this.qiJ.setImageDrawable(bd.by(getContext(), a.b.et_clear_selector));
      this.qiJ.setContentDescription(getContext().getString(R.l.clear_btn));
      switch (this.editType)
      {
      default: 
        this.qiJ.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 0: 
      case 1: 
        if (paramBoolean)
        {
          this.qiJ.setVisibility(0);
          AppMethodBeat.o(20857);
          return;
        }
        this.qiJ.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 3: 
        this.qiJ.setVisibility(0);
        this.qiJ.setImageResource(R.k.icons_outlined_location);
        this.qiJ.setContentDescription(getContext().getString(R.l.address_location));
        AppMethodBeat.o(20857);
        return;
      }
      this.qiJ.setVisibility(0);
      this.qiJ.setImageResource(R.k.icons_outlined_subscriptions);
      this.qiJ.setContentDescription(getContext().getString(R.l.address_contact));
      AppMethodBeat.o(20857);
      return;
    }
    switch (this.editType)
    {
    default: 
      this.qiJ.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 0: 
    case 1: 
      this.qiJ.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 3: 
      this.qiJ.setVisibility(0);
      this.qiJ.setImageResource(R.k.icons_outlined_location);
      this.qiJ.setContentDescription(getContext().getString(R.l.address_location));
      AppMethodBeat.o(20857);
      return;
    }
    this.qiJ.setVisibility(0);
    this.qiJ.setImageResource(R.k.icons_outlined_subscriptions);
    this.qiJ.setContentDescription(getContext().getString(R.l.address_contact));
    AppMethodBeat.o(20857);
  }
  
  public final void bZo()
  {
    AppMethodBeat.i(267208);
    this.qiI.setHintTextColor(getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_3));
    this.qiI.setTextColor(getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_9));
    this.pls.setTextColor(getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_9));
    if (this.qiP != -1) {
      this.qiJ.setImageDrawable(bb.m(getContext(), this.qiP, getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_9)));
    }
    AppMethodBeat.o(267208);
  }
  
  public final boolean bZp()
  {
    AppMethodBeat.i(20856);
    Object localObject = this.qiI.getText().toString();
    switch (this.editType)
    {
    case 0: 
    default: 
      if (((String)localObject).length() >= this.qiR)
      {
        AppMethodBeat.o(20856);
        return true;
      }
      break;
    case 1: 
      if ((((String)localObject).length() >= this.qiR) && (((String)localObject).length() <= this.qiS))
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
      if ((((String)localObject).length() >= this.qiR) && (TE((String)localObject) <= 32))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 3: 
    case 5: 
      if ((((String)localObject).length() >= this.qiR) && (TE((String)localObject) <= 128))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 4: 
      if (((String)localObject).length() <= this.qiS)
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
  
  public final boolean bZq()
  {
    AppMethodBeat.i(20863);
    if (getText().equals(Util.nullAsNil(this.qiU)))
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
    String str = this.qiI.getText().toString();
    AppMethodBeat.o(20851);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20859);
    if (this.qiH != null) {
      this.qiH.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.AddrEditView", "View:" + this.qiL + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
    if (this.qiG != null) {
      this.qiG.bZl();
    }
    if (!this.qiQ)
    {
      this.pls.setEnabled(false);
      if (paramView == this.qiI)
      {
        paramView = new Rect();
        d(this, paramView);
        if (!paramBoolean) {
          break label164;
        }
        setBackgroundResource(R.g.input_bar_bg_active);
      }
    }
    for (;;)
    {
      e(this, paramView);
      hS(paramBoolean);
      AppMethodBeat.o(20859);
      return;
      this.pls.setEnabled(true);
      break;
      label164:
      setBackgroundResource(R.g.input_bar_bg_normal);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20854);
    int i;
    if (!this.qiO)
    {
      if (this.qiJ.getVisibility() != 0) {
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
    if (this.qiI != null)
    {
      Rect localRect = new Rect();
      d(this.qiI, localRect);
      this.qiI.setBackgroundResource(paramInt);
      e(this.qiI, localRect);
    }
    AppMethodBeat.o(20864);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20852);
    this.qiI.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20852);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20853);
    super.setEnabled(paramBoolean);
    this.qiO = paramBoolean;
    this.qiJ.setEnabled(true);
    AppMethodBeat.o(20853);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20860);
    this.qiI.setHint(paramString);
    AppMethodBeat.o(20860);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20866);
    this.qiI.setImeOptions(paramInt);
    AppMethodBeat.o(20866);
  }
  
  public void setInfoIvOnClickListener(AddrEditView.a parama)
  {
    this.qiF = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20867);
    this.qiJ.setVisibility(paramInt);
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
    this.qiH = paramOnFocusChangeListener;
    AppMethodBeat.o(20858);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.qiG = paramb;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20861);
    this.pls.setText(paramString);
    AppMethodBeat.o(20861);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20865);
    if (this.pls != null) {
      this.pls.setTextColor(paramInt);
    }
    AppMethodBeat.o(20865);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20862);
    this.qiI.setText(paramString);
    this.qiI.setSelection(this.qiI.getText().length());
    this.qiU = paramString;
    AppMethodBeat.o(20862);
  }
  
  public static abstract interface b
  {
    public abstract void bZl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView
 * JD-Core Version:    0.7.0.1
 */