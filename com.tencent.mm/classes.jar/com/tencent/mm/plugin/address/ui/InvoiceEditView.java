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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class InvoiceEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private boolean bcF;
  private int editType;
  private int fl;
  private int inputType;
  private TextView pls;
  private View.OnFocusChangeListener qiH;
  EditText qiI;
  private ImageView qiJ;
  private String qiK;
  private String qiL;
  private int qiM;
  private int qiN;
  public boolean qiO;
  private int qiP;
  public boolean qiQ;
  private int qiR;
  private int qiS;
  private View.OnClickListener qiT;
  private String qiU;
  public boolean qiW;
  private a qiX;
  private c qiY;
  private b qiZ;
  private int qja;
  public boolean qjb;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20876);
    this.qiW = false;
    this.qiK = "";
    this.qiL = "";
    this.inputType = 1;
    this.qja = 0;
    this.fl = 19;
    this.editType = -1;
    this.background = -1;
    this.qiN = -1;
    this.qiO = true;
    this.qjb = true;
    this.qiQ = false;
    this.qiR = 0;
    this.qiS = 100;
    this.bcF = true;
    this.qiT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20875);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/InvoiceEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0)
        {
          if ((!InvoiceEditView.this.qiO) || (InvoiceEditView.a(InvoiceEditView.this) == 2) || (Util.isNullOrNil(InvoiceEditView.this.getText()))) {
            break label130;
          }
          InvoiceEditView.this.qiI.setText("");
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
    this.qiU = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.ham, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(R.n.hat, 0);
    if (paramInt != 0) {
      this.qiK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(R.n.hax, 0);
    if (paramInt != 0) {
      this.qiL = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(R.n.hap, 1);
    this.editType = paramAttributeSet.getInteger(R.n.har, 0);
    this.qiO = paramAttributeSet.getBoolean(R.n.has, true);
    this.fl = paramAttributeSet.getInt(R.n.han, 19);
    this.qiM = paramAttributeSet.getInteger(R.n.haq, 5);
    this.background = paramAttributeSet.getResourceId(R.n.hao, R.g.transparent_background);
    this.qiP = paramAttributeSet.getResourceId(R.n.hav, -1);
    this.qiN = paramAttributeSet.getResourceId(R.n.hau, R.g.transparent_background);
    this.bcF = paramAttributeSet.getBoolean(R.n.haw, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.gkA, this, true);
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
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 45, 43, 95, 8212, 32, 32, 40, 41, -248, -247, 64, 126, 42, 38, 94, 37, 36, 35, 64, 33, 59, 58, -230, -229, 123, 125, 91, 93, -165, -163, 12304, 12305, 60, 62, 126, 96, 183, 61, 61, 43 };
        }
        
        public final int getInputType()
        {
          return 2;
        }
      });
      hS(this.qiI.isFocused());
      this.qiI.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20874);
          if ((InvoiceEditView.a(InvoiceEditView.this) == 5) && (InvoiceEditView.b(InvoiceEditView.this) != paramAnonymousEditable.toString().length()))
          {
            InvoiceEditView.a(InvoiceEditView.this, paramAnonymousEditable.toString().length());
            InvoiceEditView.this.setBankNumberValStr(paramAnonymousEditable.toString());
          }
          boolean bool = InvoiceEditView.this.bZp();
          if ((bool != InvoiceEditView.this.qiQ) && (InvoiceEditView.c(InvoiceEditView.this) != null))
          {
            Log.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(InvoiceEditView.this) + ", editType:" + InvoiceEditView.a(InvoiceEditView.this) + " inputValid change to " + bool);
            InvoiceEditView.this.qiQ = bool;
            InvoiceEditView.c(InvoiceEditView.this).bZl();
          }
          if (((!InvoiceEditView.this.qiW) || (InvoiceEditView.this.qiQ)) && (InvoiceEditView.this.qiW) && (InvoiceEditView.this.qiQ)) {
            InvoiceEditView.e(InvoiceEditView.this).setTextColor(InvoiceEditView.this.getResources().getColor(R.e.normal_text_color));
          }
          InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
          AppMethodBeat.o(20874);
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
      paramContext = new Rect();
      d(this.qiI, paramContext);
      if (this.qiO) {
        break label685;
      }
      this.qiI.setEnabled(false);
      this.qiI.setTextColor(getResources().getColor(R.e.fjX));
      this.qiI.setFocusable(false);
      this.qiI.setClickable(false);
      this.qiI.setBackgroundResource(R.g.transparent_background);
      if (this.qjb) {
        setBackgroundResource(R.g.comm_list_item_selector);
      }
      setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      e(this.qiI, paramContext);
      if (this.qiP != -1) {
        this.qiJ.setImageResource(this.qiP);
      }
      if (!this.bcF) {
        this.qiI.setSingleLine(false);
      }
      AppMethodBeat.o(20876);
      return;
      if (this.inputType == 3)
      {
        this.qiI.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            if (InvoiceEditView.this.qiW) {
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
      this.qiI.setInputType(this.inputType);
      break;
      label685:
      this.qiQ = false;
      this.qiI.setBackgroundResource(this.qiN);
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
    this.qiJ.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20895);
    return localRect;
  }
  
  private void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(20883);
    if ((this.qiO) && (!Util.isNullOrNil(getText())))
    {
      this.qiJ.setImageResource(R.g.list_clear);
      this.qiJ.setContentDescription(getContext().getString(R.l.clear_btn));
      switch (this.editType)
      {
      default: 
        this.qiJ.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.qiJ.setVisibility(0);
          AppMethodBeat.o(20883);
          return;
        }
        this.qiJ.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 3: 
        this.qiJ.setVisibility(0);
        this.qiJ.setContentDescription(getContext().getString(R.l.address_location));
        AppMethodBeat.o(20883);
        return;
      }
      this.qiJ.setVisibility(0);
      this.qiJ.setContentDescription(getContext().getString(R.l.address_contact));
      AppMethodBeat.o(20883);
      return;
    }
    switch (this.editType)
    {
    default: 
      this.qiJ.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.qiJ.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 3: 
      this.qiJ.setVisibility(0);
      this.qiJ.setContentDescription(getContext().getString(R.l.address_location));
      AppMethodBeat.o(20883);
      return;
    }
    this.qiJ.setVisibility(0);
    this.qiJ.setContentDescription(getContext().getString(R.l.address_contact));
    AppMethodBeat.o(20883);
  }
  
  public final boolean bZp()
  {
    AppMethodBeat.i(20882);
    String str = this.qiI.getText().toString();
    switch (this.editType)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() >= this.qiR) && (str.length() <= this.qiS))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      break;
    case 0: 
      if ((str.length() >= this.qiR) && (str.length() <= this.qiS))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 1: 
      if ((str.length() == 0) || ((str.length() >= this.qiR) && (str.length() <= this.qiS)))
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
  
  public final boolean bZq()
  {
    AppMethodBeat.i(20890);
    if (getText().equals(Util.nullAsNil(this.qiU)))
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
    String str = this.qiI.getText().toString();
    AppMethodBeat.o(20877);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20885);
    if (this.qiH != null) {
      this.qiH.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.InvoiceEditView", "View:" + this.qiL + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
    if (this.qiY != null) {
      this.qiY.bZl();
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
      AppMethodBeat.o(20885);
      return;
      this.pls.setEnabled(true);
      break;
      label164:
      setBackgroundResource(R.g.input_bar_bg_normal);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20880);
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
    if (this.editType == 5)
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
    this.qiI.setText(str1);
    this.qiI.setSelection(this.qiI.getText().length());
    AppMethodBeat.o(20889);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20891);
    if (this.qiI != null)
    {
      Rect localRect = new Rect();
      d(this.qiI, localRect);
      this.qiI.setBackgroundResource(paramInt);
      e(this.qiI, localRect);
    }
    AppMethodBeat.o(20891);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20878);
    this.qiI.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20878);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20879);
    super.setEnabled(paramBoolean);
    this.qiO = paramBoolean;
    this.qiJ.setEnabled(true);
    AppMethodBeat.o(20879);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20886);
    this.qiI.setHint(paramString);
    AppMethodBeat.o(20886);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20893);
    this.qiI.setImeOptions(paramInt);
    AppMethodBeat.o(20893);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.qiX = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20894);
    this.qiJ.setVisibility(paramInt);
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
    this.qiH = paramOnFocusChangeListener;
    AppMethodBeat.o(20884);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.qiZ = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.qiY = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20887);
    this.pls.setText(paramString);
    AppMethodBeat.o(20887);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20892);
    if (this.pls != null) {
      this.pls.setTextColor(paramInt);
    }
    AppMethodBeat.o(20892);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20888);
    this.qiI.setText(paramString);
    this.qiI.setSelection(this.qiI.getText().length());
    this.qiU = paramString;
    AppMethodBeat.o(20888);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void bZl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */