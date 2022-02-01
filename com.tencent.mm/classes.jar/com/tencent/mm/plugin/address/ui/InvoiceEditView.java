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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class InvoiceEditView
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
  EditText ktL;
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
  private a kua;
  private c kub;
  private b kuc;
  private int kud;
  public boolean kue;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20876);
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
        AppMethodBeat.i(20875);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0)
        {
          if ((!InvoiceEditView.this.ktR) || (InvoiceEditView.a(InvoiceEditView.this) == 2) || (Util.isNullOrNil(InvoiceEditView.this.getText()))) {
            break label130;
          }
          InvoiceEditView.this.ktL.setText("");
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495085, this, true);
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
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 45, 43, 95, 8212, 32, 32, 40, 41, -248, -247, 64, 126, 42, 38, 94, 37, 36, 35, 64, 33, 59, 58, -230, -229, 123, 125, 91, 93, -165, -163, 12304, 12305, 60, 62, 126, 96, 183, 61, 61, 43 };
        }
        
        public final int getInputType()
        {
          return 2;
        }
      });
      gr(this.ktL.isFocused());
      this.ktL.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20874);
          if ((InvoiceEditView.a(InvoiceEditView.this) == 5) && (InvoiceEditView.b(InvoiceEditView.this) != paramAnonymousEditable.toString().length()))
          {
            InvoiceEditView.a(InvoiceEditView.this, paramAnonymousEditable.toString().length());
            InvoiceEditView.this.setBankNumberValStr(paramAnonymousEditable.toString());
          }
          boolean bool = InvoiceEditView.this.bql();
          if ((bool != InvoiceEditView.this.ktT) && (InvoiceEditView.c(InvoiceEditView.this) != null))
          {
            Log.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(InvoiceEditView.this) + ", editType:" + InvoiceEditView.a(InvoiceEditView.this) + " inputValid change to " + bool);
            InvoiceEditView.this.ktT = bool;
            InvoiceEditView.c(InvoiceEditView.this).bqh();
          }
          if (((!InvoiceEditView.this.ktZ) || (InvoiceEditView.this.ktT)) && (InvoiceEditView.this.ktZ) && (InvoiceEditView.this.ktT)) {
            InvoiceEditView.e(InvoiceEditView.this).setTextColor(InvoiceEditView.this.getResources().getColor(2131100904));
          }
          InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
          AppMethodBeat.o(20874);
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
      paramContext = new Rect();
      d(this.ktL, paramContext);
      if (this.ktR) {
        break label661;
      }
      this.ktL.setEnabled(false);
      this.ktL.setTextColor(getResources().getColor(2131099913));
      this.ktL.setFocusable(false);
      this.ktL.setClickable(false);
      this.ktL.setBackgroundResource(2131235359);
      if (this.kue) {
        setBackgroundResource(2131231898);
      }
      setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      e(this.ktL, paramContext);
      if (this.ktS != -1) {
        this.ktM.setImageResource(this.ktS);
      }
      if (!this.kK) {
        this.ktL.setSingleLine(false);
      }
      AppMethodBeat.o(20876);
      return;
      if (this.inputType == 3)
      {
        this.ktL.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            if (InvoiceEditView.this.ktZ) {
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
      this.ktL.setInputType(this.inputType);
      break;
      label661:
      this.ktT = false;
      this.ktL.setBackgroundResource(this.ktQ);
      setBackgroundResource(this.background);
    }
  }
  
  private static void d(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20896);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(20896);
  }
  
  private static void e(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20897);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(20897);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20895);
    Rect localRect = new Rect();
    this.ktM.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20895);
    return localRect;
  }
  
  private void gr(boolean paramBoolean)
  {
    AppMethodBeat.i(20883);
    if ((this.ktR) && (!Util.isNullOrNil(getText())))
    {
      this.ktM.setImageResource(2131233321);
      this.ktM.setContentDescription(getContext().getString(2131757636));
      switch (this.ktP)
      {
      default: 
        this.ktM.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.ktM.setVisibility(0);
          AppMethodBeat.o(20883);
          return;
        }
        this.ktM.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 3: 
        this.ktM.setVisibility(0);
        this.ktM.setContentDescription(getContext().getString(2131755244));
        AppMethodBeat.o(20883);
        return;
      }
      this.ktM.setVisibility(0);
      this.ktM.setContentDescription(getContext().getString(2131755197));
      AppMethodBeat.o(20883);
      return;
    }
    switch (this.ktP)
    {
    default: 
      this.ktM.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.ktM.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 3: 
      this.ktM.setVisibility(0);
      this.ktM.setContentDescription(getContext().getString(2131755244));
      AppMethodBeat.o(20883);
      return;
    }
    this.ktM.setVisibility(0);
    this.ktM.setContentDescription(getContext().getString(2131755197));
    AppMethodBeat.o(20883);
  }
  
  public final boolean bql()
  {
    AppMethodBeat.i(20882);
    String str = this.ktL.getText().toString();
    switch (this.ktP)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() >= this.ktU) && (str.length() <= this.ktV))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      break;
    case 0: 
      if ((str.length() >= this.ktU) && (str.length() <= this.ktV))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 1: 
      if ((str.length() == 0) || ((str.length() >= this.ktU) && (str.length() <= this.ktV)))
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
  
  public final boolean bqm()
  {
    AppMethodBeat.i(20890);
    if (getText().equals(Util.nullAsNil(this.ktX)))
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
    String str = this.ktL.getText().toString();
    AppMethodBeat.o(20877);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20885);
    if (this.ktK != null) {
      this.ktK.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.InvoiceEditView", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + paramBoolean);
    if (this.kub != null) {
      this.kub.bqh();
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
      AppMethodBeat.o(20885);
      return;
      this.jBS.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131233163);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20880);
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
    if (this.ktP == 5)
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
    this.ktL.setText(str1);
    this.ktL.setSelection(this.ktL.getText().length());
    AppMethodBeat.o(20889);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20891);
    if (this.ktL != null)
    {
      Rect localRect = new Rect();
      d(this.ktL, localRect);
      this.ktL.setBackgroundResource(paramInt);
      e(this.ktL, localRect);
    }
    AppMethodBeat.o(20891);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20878);
    this.ktL.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20878);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20879);
    super.setEnabled(paramBoolean);
    this.ktR = paramBoolean;
    this.ktM.setEnabled(true);
    AppMethodBeat.o(20879);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20886);
    this.ktL.setHint(paramString);
    AppMethodBeat.o(20886);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20893);
    this.ktL.setImeOptions(paramInt);
    AppMethodBeat.o(20893);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.kua = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20894);
    this.ktM.setVisibility(paramInt);
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
    this.ktK = paramOnFocusChangeListener;
    AppMethodBeat.o(20884);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.kuc = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.kub = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20887);
    this.jBS.setText(paramString);
    AppMethodBeat.o(20887);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20892);
    if (this.jBS != null) {
      this.jBS.setTextColor(paramInt);
    }
    AppMethodBeat.o(20892);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20888);
    this.ktL.setText(paramString);
    this.ktL.setSelection(this.ktL.getText().length());
    this.ktX = paramString;
    AppMethodBeat.o(20888);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void bqh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */