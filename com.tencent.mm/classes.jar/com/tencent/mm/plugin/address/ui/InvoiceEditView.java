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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class InvoiceEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private boolean iR;
  private int iZA;
  public boolean iZB;
  private int iZC;
  public boolean iZD;
  private int iZE;
  private int iZF;
  private View.OnClickListener iZG;
  private String iZH;
  public boolean iZJ;
  private a iZK;
  private c iZL;
  private b iZM;
  private int iZN;
  public boolean iZO;
  private View.OnFocusChangeListener iZu;
  EditText iZv;
  private ImageView iZw;
  private String iZx;
  private String iZy;
  private int iZz;
  private TextView ijF;
  private int imeOptions;
  private int inputType;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20876);
    this.iZJ = false;
    this.iZx = "";
    this.iZy = "";
    this.inputType = 1;
    this.iZN = 0;
    this.gravity = 19;
    this.iZz = -1;
    this.background = -1;
    this.iZA = -1;
    this.iZB = true;
    this.iZO = true;
    this.iZD = false;
    this.iZE = 0;
    this.iZF = 100;
    this.iR = true;
    this.iZG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20875);
        if (InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0)
        {
          if ((InvoiceEditView.this.iZB) && (InvoiceEditView.a(InvoiceEditView.this) != 2) && (!bs.isNullOrNil(InvoiceEditView.this.getText())))
          {
            InvoiceEditView.this.iZv.setText("");
            InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
            AppMethodBeat.o(20875);
            return;
          }
          if (InvoiceEditView.g(InvoiceEditView.this) != null) {
            InvoiceEditView.g(InvoiceEditView.this);
          }
        }
        AppMethodBeat.o(20875);
      }
    };
    this.iZH = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.InvoiceEditView, paramInt, 0);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494493, this, true);
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
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 45, 43, 95, 8212, 32, 32, 40, 41, -248, -247, 64, 126, 42, 38, 94, 37, 36, 35, 64, 33, 59, 58, -230, -229, 123, 125, 91, 93, -165, -163, 12304, 12305, 60, 62, 126, 96, 183, 61, 61, 43 };
        }
        
        public final int getInputType()
        {
          return 2;
        }
      });
      ft(this.iZv.isFocused());
      this.iZv.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20874);
          if ((InvoiceEditView.a(InvoiceEditView.this) == 5) && (InvoiceEditView.b(InvoiceEditView.this) != paramAnonymousEditable.toString().length()))
          {
            InvoiceEditView.a(InvoiceEditView.this, paramAnonymousEditable.toString().length());
            InvoiceEditView.this.setBankNumberValStr(paramAnonymousEditable.toString());
          }
          boolean bool = InvoiceEditView.this.aRO();
          if ((bool != InvoiceEditView.this.iZD) && (InvoiceEditView.c(InvoiceEditView.this) != null))
          {
            ac.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(InvoiceEditView.this) + ", editType:" + InvoiceEditView.a(InvoiceEditView.this) + " inputValid change to " + bool);
            InvoiceEditView.this.iZD = bool;
            InvoiceEditView.c(InvoiceEditView.this).aRL();
          }
          if (((!InvoiceEditView.this.iZJ) || (InvoiceEditView.this.iZD)) && (InvoiceEditView.this.iZJ) && (InvoiceEditView.this.iZD)) {
            InvoiceEditView.e(InvoiceEditView.this).setTextColor(InvoiceEditView.this.getResources().getColor(2131100711));
          }
          InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
          AppMethodBeat.o(20874);
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
      paramContext = new Rect();
      h(this.iZv, paramContext);
      if (this.iZB) {
        break label661;
      }
      this.iZv.setEnabled(false);
      this.iZv.setTextColor(getResources().getColor(2131099895));
      this.iZv.setFocusable(false);
      this.iZv.setClickable(false);
      this.iZv.setBackgroundResource(2131234429);
      if (this.iZO) {
        setBackgroundResource(2131231818);
      }
      setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.iZv, paramContext);
      if (this.iZC != -1) {
        this.iZw.setImageResource(this.iZC);
      }
      if (!this.iR) {
        this.iZv.setSingleLine(false);
      }
      AppMethodBeat.o(20876);
      return;
      if (this.inputType == 3)
      {
        this.iZv.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            if (InvoiceEditView.this.iZJ) {
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
      this.iZv.setInputType(this.inputType);
      break;
      label661:
      this.iZD = false;
      this.iZv.setBackgroundResource(this.iZA);
      setBackgroundResource(this.background);
    }
  }
  
  private void ft(boolean paramBoolean)
  {
    AppMethodBeat.i(20883);
    if ((this.iZB) && (!bs.isNullOrNil(getText())))
    {
      this.iZw.setImageResource(2131232862);
      this.iZw.setContentDescription(getContext().getString(2131757419));
      switch (this.iZz)
      {
      default: 
        this.iZw.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.iZw.setVisibility(0);
          AppMethodBeat.o(20883);
          return;
        }
        this.iZw.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 3: 
        this.iZw.setVisibility(0);
        this.iZw.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20883);
        return;
      }
      this.iZw.setVisibility(0);
      this.iZw.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20883);
      return;
    }
    switch (this.iZz)
    {
    default: 
      this.iZw.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.iZw.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 3: 
      this.iZw.setVisibility(0);
      this.iZw.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20883);
      return;
    }
    this.iZw.setVisibility(0);
    this.iZw.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20883);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20895);
    Rect localRect = new Rect();
    this.iZw.getHitRect(localRect);
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
  
  public final boolean aRO()
  {
    AppMethodBeat.i(20882);
    String str = this.iZv.getText().toString();
    switch (this.iZz)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() >= this.iZE) && (str.length() <= this.iZF))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      break;
    case 0: 
      if ((str.length() >= this.iZE) && (str.length() <= this.iZF))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 1: 
      if ((str.length() == 0) || ((str.length() >= this.iZE) && (str.length() <= this.iZF)))
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
  
  public final boolean aRP()
  {
    AppMethodBeat.i(20890);
    if (getText().equals(bs.nullAsNil(this.iZH)))
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
    String str = this.iZv.getText().toString();
    AppMethodBeat.o(20877);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20885);
    if (this.iZu != null) {
      this.iZu.onFocusChange(this, paramBoolean);
    }
    ac.d("MicroMsg.InvoiceEditView", "View:" + this.iZy + ", editType:" + this.iZz + " onFocusChange to " + paramBoolean);
    if (this.iZL != null) {
      this.iZL.aRL();
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
      AppMethodBeat.o(20885);
      return;
      this.ijF.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20880);
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
    if (this.iZz == 5)
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
    this.iZv.setText(str1);
    this.iZv.setSelection(this.iZv.getText().length());
    AppMethodBeat.o(20889);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20891);
    if (this.iZv != null)
    {
      Rect localRect = new Rect();
      h(this.iZv, localRect);
      this.iZv.setBackgroundResource(paramInt);
      i(this.iZv, localRect);
    }
    AppMethodBeat.o(20891);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20878);
    this.iZv.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20878);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20879);
    super.setEnabled(paramBoolean);
    this.iZB = paramBoolean;
    this.iZw.setEnabled(true);
    AppMethodBeat.o(20879);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20886);
    this.iZv.setHint(paramString);
    AppMethodBeat.o(20886);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20893);
    this.iZv.setImeOptions(paramInt);
    AppMethodBeat.o(20893);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.iZK = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20894);
    this.iZw.setVisibility(paramInt);
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
    this.iZu = paramOnFocusChangeListener;
    AppMethodBeat.o(20884);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.iZM = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.iZL = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20887);
    this.ijF.setText(paramString);
    AppMethodBeat.o(20887);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20892);
    if (this.ijF != null) {
      this.ijF.setTextColor(paramInt);
    }
    AppMethodBeat.o(20892);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20888);
    this.iZv.setText(paramString);
    this.iZv.setSelection(this.iZv.getText().length());
    this.iZH = paramString;
    AppMethodBeat.o(20888);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void aRL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */