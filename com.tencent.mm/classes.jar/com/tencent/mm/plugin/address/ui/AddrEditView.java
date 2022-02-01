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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.n;
import com.tencent.mm.cr.a.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;

public class AddrEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private boolean bCn;
  private int background;
  private int editType;
  private int ek;
  private int inputType;
  private TextView mrN;
  private ImageView nlA;
  private String nlB;
  private String nlC;
  private int nlD;
  private int nlE;
  public boolean nlF;
  private int nlG;
  private boolean nlH;
  private int nlI;
  private int nlJ;
  private View.OnClickListener nlK;
  private String nlL;
  private a nlw;
  private b nlx;
  private View.OnFocusChangeListener nly;
  EditText nlz;
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20850);
    this.nlB = "";
    this.nlC = "";
    this.inputType = 1;
    this.ek = 19;
    this.editType = -1;
    this.background = -1;
    this.nlE = -1;
    this.nlF = true;
    this.nlH = false;
    this.nlI = 1;
    this.nlJ = 30;
    this.bCn = true;
    this.nlK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20849);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/AddrEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (AddrEditView.f(AddrEditView.this).getVisibility() == 0)
        {
          if ((!AddrEditView.this.nlF) || (AddrEditView.d(AddrEditView.this) == 2) || (Util.isNullOrNil(AddrEditView.this.getText()))) {
            break label130;
          }
          AddrEditView.this.nlz.setText("");
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
    this.nlL = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.eWk, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(R.n.eWr, 0);
    if (paramInt != 0) {
      this.nlB = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(R.n.eWv, 0);
    if (paramInt != 0) {
      this.nlC = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(R.n.eWn, 1);
    this.editType = paramAttributeSet.getInteger(R.n.eWp, 0);
    this.nlF = paramAttributeSet.getBoolean(R.n.eWq, true);
    this.ek = paramAttributeSet.getInt(R.n.eWl, 19);
    this.nlD = paramAttributeSet.getInteger(R.n.eWo, 5);
    this.background = paramAttributeSet.getResourceId(R.n.eWm, R.g.transparent_background);
    this.nlG = paramAttributeSet.getResourceId(R.n.eWt, -1);
    this.nlE = paramAttributeSet.getResourceId(R.n.eWs, R.g.transparent_background);
    this.bCn = paramAttributeSet.getBoolean(R.n.eWu, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.ebo, this, true);
    this.nlz = ((EditText)paramAttributeSet.findViewById(R.h.hint_et));
    this.nlz.setTextSize(0, com.tencent.mm.ci.a.aY(paramContext, R.f.NormalTextSize));
    this.mrN = ((TextView)paramAttributeSet.findViewById(R.h.tip_tv));
    this.nlA = ((ImageView)paramAttributeSet.findViewById(R.h.info_iv));
    this.nlA.setOnClickListener(this.nlK);
    this.nlz.setImeOptions(this.nlD);
    this.nlz.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.nlz.setKeyListener(new NumberKeyListener()
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
      hd(this.nlz.isFocused());
      this.nlz.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20848);
          boolean bool = AddrEditView.this.bAz();
          if ((bool != AddrEditView.a(AddrEditView.this)) && (AddrEditView.b(AddrEditView.this) != null))
          {
            Log.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(AddrEditView.this) + ", editType:" + AddrEditView.d(AddrEditView.this) + " inputValid change to " + bool);
            AddrEditView.a(AddrEditView.this, bool);
            paramAnonymousEditable = AddrEditView.b(AddrEditView.this);
            AddrEditView.a(AddrEditView.this);
            paramAnonymousEditable.bAv();
          }
          AddrEditView.b(AddrEditView.this, AddrEditView.e(AddrEditView.this).isFocused());
          AppMethodBeat.o(20848);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.nlz.setOnFocusChangeListener(this);
      if (!Util.isNullOrNil(this.nlB)) {
        this.nlz.setHint(this.nlB);
      }
      if (!Util.isNullOrNil(this.nlC)) {
        this.mrN.setText(this.nlC);
      }
      paramAttributeSet = new Rect();
      d(this.nlz, paramAttributeSet);
      if (this.nlF) {
        break label676;
      }
      this.nlz.setEnabled(false);
      this.nlz.setFocusable(false);
      this.nlz.setClickable(false);
      this.nlz.setBackgroundResource(R.g.transparent_background);
      setBackgroundResource(R.g.mm_listitem);
      setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 8), getPaddingTop(), com.tencent.mm.ci.a.fromDPToPix(getContext(), 8), getPaddingBottom());
    }
    for (;;)
    {
      e(this.nlz, paramAttributeSet);
      this.nlz.setGravity(this.ek);
      if (this.nlG != -1) {
        this.nlA.setImageDrawable(au.o(paramContext, this.nlG, paramContext.getResources().getColor(R.e.FG_0)));
      }
      if (!this.bCn) {
        this.nlz.setSingleLine(false);
      }
      AppMethodBeat.o(20850);
      return;
      if (this.inputType == 3)
      {
        this.nlz.setKeyListener(new NumberKeyListener()
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
      this.nlz.setInputType(this.inputType);
      break;
      label676:
      this.nlH = false;
      this.nlz.setBackgroundResource(this.nlE);
      setBackgroundResource(this.background);
    }
  }
  
  private static int abn(String paramString)
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
    this.nlA.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20868);
    return localRect;
  }
  
  private void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(20857);
    if ((this.nlF) && (!Util.isNullOrNil(getText())))
    {
      this.nlA.setImageDrawable(aw.bf(getContext(), a.b.et_clear_selector));
      this.nlA.setContentDescription(getContext().getString(R.l.clear_btn));
      switch (this.editType)
      {
      default: 
        this.nlA.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 0: 
      case 1: 
        if (paramBoolean)
        {
          this.nlA.setVisibility(0);
          AppMethodBeat.o(20857);
          return;
        }
        this.nlA.setVisibility(8);
        AppMethodBeat.o(20857);
        return;
      case 3: 
        this.nlA.setVisibility(0);
        this.nlA.setImageResource(R.k.icons_outlined_location);
        this.nlA.setContentDescription(getContext().getString(R.l.address_location));
        AppMethodBeat.o(20857);
        return;
      }
      this.nlA.setVisibility(0);
      this.nlA.setImageResource(R.k.icons_outlined_subscriptions);
      this.nlA.setContentDescription(getContext().getString(R.l.address_contact));
      AppMethodBeat.o(20857);
      return;
    }
    switch (this.editType)
    {
    default: 
      this.nlA.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 0: 
    case 1: 
      this.nlA.setVisibility(8);
      AppMethodBeat.o(20857);
      return;
    case 3: 
      this.nlA.setVisibility(0);
      this.nlA.setImageResource(R.k.icons_outlined_location);
      this.nlA.setContentDescription(getContext().getString(R.l.address_location));
      AppMethodBeat.o(20857);
      return;
    }
    this.nlA.setVisibility(0);
    this.nlA.setImageResource(R.k.icons_outlined_subscriptions);
    this.nlA.setContentDescription(getContext().getString(R.l.address_contact));
    AppMethodBeat.o(20857);
  }
  
  public final boolean bAA()
  {
    AppMethodBeat.i(20863);
    if (getText().equals(Util.nullAsNil(this.nlL)))
    {
      AppMethodBeat.o(20863);
      return false;
    }
    AppMethodBeat.o(20863);
    return true;
  }
  
  public final void bAy()
  {
    AppMethodBeat.i(267732);
    this.nlz.setHintTextColor(getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_3));
    this.nlz.setTextColor(getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_9));
    this.mrN.setTextColor(getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_9));
    if (this.nlG != -1) {
      this.nlA.setImageDrawable(au.o(getContext(), this.nlG, getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_9)));
    }
    AppMethodBeat.o(267732);
  }
  
  public final boolean bAz()
  {
    AppMethodBeat.i(20856);
    Object localObject = this.nlz.getText().toString();
    switch (this.editType)
    {
    case 0: 
    default: 
      if (((String)localObject).length() >= this.nlI)
      {
        AppMethodBeat.o(20856);
        return true;
      }
      break;
    case 1: 
      if ((((String)localObject).length() >= this.nlI) && (((String)localObject).length() <= this.nlJ))
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
      if ((((String)localObject).length() >= this.nlI) && (abn((String)localObject) <= 32))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 3: 
    case 5: 
      if ((((String)localObject).length() >= this.nlI) && (abn((String)localObject) <= 128))
      {
        AppMethodBeat.o(20856);
        return true;
      }
      AppMethodBeat.o(20856);
      return false;
    case 4: 
      if (((String)localObject).length() <= this.nlJ)
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
    String str = this.nlz.getText().toString();
    AppMethodBeat.o(20851);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20859);
    if (this.nly != null) {
      this.nly.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.AddrEditView", "View:" + this.nlC + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
    if (this.nlx != null) {
      this.nlx.bAv();
    }
    if (!this.nlH)
    {
      this.mrN.setEnabled(false);
      if (paramView == this.nlz)
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
      hd(paramBoolean);
      AppMethodBeat.o(20859);
      return;
      this.mrN.setEnabled(true);
      break;
      label164:
      setBackgroundResource(R.g.input_bar_bg_normal);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20854);
    int i;
    if (!this.nlF)
    {
      if (this.nlA.getVisibility() != 0) {
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
    if (this.nlz != null)
    {
      Rect localRect = new Rect();
      d(this.nlz, localRect);
      this.nlz.setBackgroundResource(paramInt);
      e(this.nlz, localRect);
    }
    AppMethodBeat.o(20864);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20852);
    this.nlz.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20852);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20853);
    super.setEnabled(paramBoolean);
    this.nlF = paramBoolean;
    this.nlA.setEnabled(true);
    AppMethodBeat.o(20853);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20860);
    this.nlz.setHint(paramString);
    AppMethodBeat.o(20860);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20866);
    this.nlz.setImeOptions(paramInt);
    AppMethodBeat.o(20866);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.nlw = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20867);
    this.nlA.setVisibility(paramInt);
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
    this.nly = paramOnFocusChangeListener;
    AppMethodBeat.o(20858);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.nlx = paramb;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20861);
    this.mrN.setText(paramString);
    AppMethodBeat.o(20861);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20865);
    if (this.mrN != null) {
      this.mrN.setTextColor(paramInt);
    }
    AppMethodBeat.o(20865);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20862);
    this.nlz.setText(paramString);
    this.nlz.setSelection(this.nlz.getText().length());
    this.nlL = paramString;
    AppMethodBeat.o(20862);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
  
  public static abstract interface b
  {
    public abstract void bAv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView
 * JD-Core Version:    0.7.0.1
 */