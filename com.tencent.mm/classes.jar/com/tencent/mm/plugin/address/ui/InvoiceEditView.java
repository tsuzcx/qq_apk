package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class InvoiceEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private View.OnFocusChangeListener gLH;
  private TextView gLI;
  EditText gLJ;
  private ImageView gLK;
  private String gLL;
  private String gLM;
  private int gLN;
  private int gLO;
  public boolean gLP;
  private int gLQ;
  public boolean gLR;
  private int gLS;
  private int gLT;
  private boolean gLU;
  private View.OnClickListener gLV;
  private String gLW;
  public boolean gLY;
  private InvoiceEditView.a gLZ;
  private InvoiceEditView.c gMa;
  private InvoiceEditView.b gMb;
  private int gMc;
  public boolean gMd;
  private int gravity;
  private int imeOptions;
  private int inputType;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(16834);
    this.gLY = false;
    this.gLL = "";
    this.gLM = "";
    this.inputType = 1;
    this.gMc = 0;
    this.gravity = 19;
    this.gLN = -1;
    this.background = -1;
    this.gLO = -1;
    this.gLP = true;
    this.gMd = true;
    this.gLR = false;
    this.gLS = 0;
    this.gLT = 100;
    this.gLU = true;
    this.gLV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(16833);
        if (InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0)
        {
          if ((InvoiceEditView.this.gLP) && (InvoiceEditView.a(InvoiceEditView.this) != 2) && (!bo.isNullOrNil(InvoiceEditView.this.getText())))
          {
            InvoiceEditView.this.gLJ.setText("");
            InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
            AppMethodBeat.o(16833);
            return;
          }
          if (InvoiceEditView.g(InvoiceEditView.this) != null) {
            InvoiceEditView.g(InvoiceEditView.this);
          }
        }
        AppMethodBeat.o(16833);
      }
    };
    this.gLW = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.InvoiceEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(5, 0);
    if (paramInt != 0) {
      this.gLL = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(6, 0);
    if (paramInt != 0) {
      this.gLM = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(3, 1);
    this.gLN = paramAttributeSet.getInteger(7, 0);
    this.gLP = paramAttributeSet.getBoolean(10, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.imeOptions = paramAttributeSet.getInteger(4, 5);
    this.background = paramAttributeSet.getResourceId(1, 2130840999);
    this.gLQ = paramAttributeSet.getResourceId(12, -1);
    this.gLO = paramAttributeSet.getResourceId(9, 2130840999);
    this.gLU = paramAttributeSet.getBoolean(13, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2130969915, this, true);
    this.gLJ = ((EditText)paramAttributeSet.findViewById(2131821072));
    this.gLJ.setTextSize(0, a.ao(paramContext, 2131427809));
    this.gLI = ((TextView)paramAttributeSet.findViewById(2131821071));
    this.gLK = ((ImageView)paramAttributeSet.findViewById(2131821073));
    this.gLK.setOnClickListener(this.gLV);
    this.gLJ.setImeOptions(this.imeOptions);
    this.gLJ.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.gLJ.setKeyListener(new InvoiceEditView.1(this));
      dD(this.gLJ.isFocused());
      this.gLJ.addTextChangedListener(new InvoiceEditView.3(this));
      this.gLJ.setOnFocusChangeListener(this);
      if (!bo.isNullOrNil(this.gLL)) {
        this.gLJ.setHint(this.gLL);
      }
      if (!bo.isNullOrNil(this.gLM)) {
        this.gLI.setText(this.gLM);
      }
      paramContext = new Rect();
      i(this.gLJ, paramContext);
      if (this.gLP) {
        break label660;
      }
      this.gLJ.setEnabled(false);
      this.gLJ.setTextColor(getResources().getColor(2131689661));
      this.gLJ.setFocusable(false);
      this.gLJ.setClickable(false);
      this.gLJ.setBackgroundResource(2130840999);
      if (this.gMd) {
        setBackgroundResource(2130838445);
      }
      setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      j(this.gLJ, paramContext);
      if (this.gLQ != -1) {
        this.gLK.setImageResource(this.gLQ);
      }
      if (!this.gLU) {
        this.gLJ.setSingleLine(false);
      }
      AppMethodBeat.o(16834);
      return;
      if (this.inputType == 3)
      {
        this.gLJ.setKeyListener(new InvoiceEditView.2(this));
        break;
      }
      this.gLJ.setInputType(this.inputType);
      break;
      label660:
      this.gLR = false;
      this.gLJ.setBackgroundResource(this.gLO);
      setBackgroundResource(this.background);
    }
  }
  
  private void dD(boolean paramBoolean)
  {
    AppMethodBeat.i(16841);
    if ((this.gLP) && (!bo.isNullOrNil(getText())))
    {
      this.gLK.setImageResource(2130839272);
      this.gLK.setContentDescription(getContext().getString(2131298408));
      switch (this.gLN)
      {
      default: 
        this.gLK.setVisibility(8);
        AppMethodBeat.o(16841);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.gLK.setVisibility(0);
          AppMethodBeat.o(16841);
          return;
        }
        this.gLK.setVisibility(8);
        AppMethodBeat.o(16841);
        return;
      case 3: 
        this.gLK.setVisibility(0);
        this.gLK.setContentDescription(getContext().getString(2131296479));
        AppMethodBeat.o(16841);
        return;
      }
      this.gLK.setVisibility(0);
      this.gLK.setContentDescription(getContext().getString(2131296451));
      AppMethodBeat.o(16841);
      return;
    }
    switch (this.gLN)
    {
    default: 
      this.gLK.setVisibility(8);
      AppMethodBeat.o(16841);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.gLK.setVisibility(8);
      AppMethodBeat.o(16841);
      return;
    case 3: 
      this.gLK.setVisibility(0);
      this.gLK.setContentDescription(getContext().getString(2131296479));
      AppMethodBeat.o(16841);
      return;
    }
    this.gLK.setVisibility(0);
    this.gLK.setContentDescription(getContext().getString(2131296451));
    AppMethodBeat.o(16841);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(16853);
    Rect localRect = new Rect();
    this.gLK.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(16853);
    return localRect;
  }
  
  private static void i(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(16854);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(16854);
  }
  
  private static void j(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(16855);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(16855);
  }
  
  public final boolean asv()
  {
    AppMethodBeat.i(16840);
    String str = this.gLJ.getText().toString();
    switch (this.gLN)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() >= this.gLS) && (str.length() <= this.gLT))
      {
        AppMethodBeat.o(16840);
        return true;
      }
      break;
    case 0: 
      if ((str.length() >= this.gLS) && (str.length() <= this.gLT))
      {
        AppMethodBeat.o(16840);
        return true;
      }
      AppMethodBeat.o(16840);
      return false;
    case 1: 
      if ((str.length() == 0) || ((str.length() >= this.gLS) && (str.length() <= this.gLT)))
      {
        AppMethodBeat.o(16840);
        return true;
      }
      AppMethodBeat.o(16840);
      return false;
    case 4: 
      if (str.length() <= 100)
      {
        AppMethodBeat.o(16840);
        return true;
      }
      AppMethodBeat.o(16840);
      return false;
    case 5: 
      if (str.length() <= 48)
      {
        AppMethodBeat.o(16840);
        return true;
      }
      AppMethodBeat.o(16840);
      return false;
    }
    AppMethodBeat.o(16840);
    return false;
  }
  
  public final boolean asw()
  {
    AppMethodBeat.i(16848);
    if (getText().equals(bo.nullAsNil(this.gLW)))
    {
      AppMethodBeat.o(16848);
      return false;
    }
    AppMethodBeat.o(16848);
    return true;
  }
  
  public String getText()
  {
    AppMethodBeat.i(16835);
    String str = this.gLJ.getText().toString();
    AppMethodBeat.o(16835);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(16843);
    if (this.gLH != null) {
      this.gLH.onFocusChange(this, paramBoolean);
    }
    ab.d("MicroMsg.InvoiceEditView", "View:" + this.gLM + ", editType:" + this.gLN + " onFocusChange to " + paramBoolean);
    if (this.gMa != null) {
      this.gMa.ass();
    }
    if (!this.gLR)
    {
      this.gLI.setEnabled(false);
      if (paramView == this.gLJ)
      {
        paramView = new Rect();
        i(this, paramView);
        if (!paramBoolean) {
          break label164;
        }
        setBackgroundResource(2130839162);
      }
    }
    for (;;)
    {
      j(this, paramView);
      dD(paramBoolean);
      AppMethodBeat.o(16843);
      return;
      this.gLI.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2130839163);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(16838);
    int i;
    if (!this.gLP)
    {
      if (this.gLK.getVisibility() != 0) {
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
      AppMethodBeat.o(16838);
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
    AppMethodBeat.o(16838);
    return true;
  }
  
  public void setBankNumberValStr(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(16847);
    String str1 = paramString;
    if (this.gLN == 5)
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
    this.gLJ.setText(str1);
    this.gLJ.setSelection(this.gLJ.getText().length());
    AppMethodBeat.o(16847);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(16849);
    if (this.gLJ != null)
    {
      Rect localRect = new Rect();
      i(this.gLJ, localRect);
      this.gLJ.setBackgroundResource(paramInt);
      j(this.gLJ, localRect);
    }
    AppMethodBeat.o(16849);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(16836);
    this.gLJ.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(16836);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(16837);
    super.setEnabled(paramBoolean);
    this.gLP = paramBoolean;
    this.gLK.setEnabled(true);
    AppMethodBeat.o(16837);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(16844);
    this.gLJ.setHint(paramString);
    AppMethodBeat.o(16844);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(16851);
    this.gLJ.setImeOptions(paramInt);
    AppMethodBeat.o(16851);
  }
  
  public void setInfoIvOnClickListener(InvoiceEditView.a parama)
  {
    this.gLZ = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(16852);
    this.gLK.setVisibility(paramInt);
    AppMethodBeat.o(16852);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(16839);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(16839);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(16842);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.gLH = paramOnFocusChangeListener;
    AppMethodBeat.o(16842);
  }
  
  public void setOnInputInvoiceTypeChangeListener(InvoiceEditView.b paramb)
  {
    this.gMb = paramb;
  }
  
  public void setOnInputValidChangeListener(InvoiceEditView.c paramc)
  {
    this.gMa = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(16845);
    this.gLI.setText(paramString);
    AppMethodBeat.o(16845);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(16850);
    if (this.gLI != null) {
      this.gLI.setTextColor(paramInt);
    }
    AppMethodBeat.o(16850);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(16846);
    this.gLJ.setText(paramString);
    this.gLJ.setSelection(this.gLJ.getText().length());
    this.gLW = paramString;
    AppMethodBeat.o(16846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */