package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.telephony.PhoneNumberUtils;
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

public class AddrEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private AddrEditView.a gLF;
  private AddrEditView.b gLG;
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
  private boolean gLR;
  private int gLS;
  private int gLT;
  private boolean gLU;
  private View.OnClickListener gLV;
  private String gLW;
  private int gravity;
  private int imeOptions;
  private int inputType;
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddrEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(16809);
    this.gLL = "";
    this.gLM = "";
    this.inputType = 1;
    this.gravity = 19;
    this.gLN = -1;
    this.background = -1;
    this.gLO = -1;
    this.gLP = true;
    this.gLR = false;
    this.gLS = 1;
    this.gLT = 30;
    this.gLU = true;
    this.gLV = new AddrEditView.4(this);
    this.gLW = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AddrEditView, paramInt, 0);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2130968638, this, true);
    this.gLJ = ((EditText)paramAttributeSet.findViewById(2131821072));
    this.gLJ.setTextSize(0, a.ao(paramContext, 2131427809));
    this.gLI = ((TextView)paramAttributeSet.findViewById(2131821071));
    this.gLK = ((ImageView)paramAttributeSet.findViewById(2131821073));
    this.gLK.setOnClickListener(this.gLV);
    this.gLJ.setImeOptions(this.imeOptions);
    this.gLJ.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.gLJ.setKeyListener(new AddrEditView.1(this));
      dD(this.gLJ.isFocused());
      this.gLJ.addTextChangedListener(new AddrEditView.3(this));
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
        break label649;
      }
      this.gLJ.setEnabled(false);
      this.gLJ.setTextColor(getResources().getColor(2131689661));
      this.gLJ.setFocusable(false);
      this.gLJ.setClickable(false);
      this.gLJ.setBackgroundResource(2130840999);
      setBackgroundResource(2130838445);
      setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      j(this.gLJ, paramContext);
      this.gLJ.setGravity(this.gravity);
      if (this.gLQ != -1) {
        this.gLK.setImageResource(this.gLQ);
      }
      if (!this.gLU) {
        this.gLJ.setSingleLine(false);
      }
      AppMethodBeat.o(16809);
      return;
      if (this.inputType == 3)
      {
        this.gLJ.setKeyListener(new AddrEditView.2(this));
        break;
      }
      this.gLJ.setInputType(this.inputType);
      break;
      label649:
      this.gLR = false;
      this.gLJ.setBackgroundResource(this.gLO);
      setBackgroundResource(this.background);
    }
  }
  
  private void dD(boolean paramBoolean)
  {
    AppMethodBeat.i(16816);
    if ((this.gLP) && (!bo.isNullOrNil(getText())))
    {
      this.gLK.setImageResource(2130839272);
      this.gLK.setContentDescription(getContext().getString(2131298408));
      switch (this.gLN)
      {
      default: 
        this.gLK.setVisibility(8);
        AppMethodBeat.o(16816);
        return;
      case 0: 
      case 1: 
        if (paramBoolean)
        {
          this.gLK.setVisibility(0);
          AppMethodBeat.o(16816);
          return;
        }
        this.gLK.setVisibility(8);
        AppMethodBeat.o(16816);
        return;
      case 3: 
        this.gLK.setVisibility(0);
        this.gLK.setImageResource(2131232188);
        this.gLK.setContentDescription(getContext().getString(2131296479));
        AppMethodBeat.o(16816);
        return;
      }
      this.gLK.setVisibility(0);
      this.gLK.setImageResource(2131232187);
      this.gLK.setContentDescription(getContext().getString(2131296451));
      AppMethodBeat.o(16816);
      return;
    }
    switch (this.gLN)
    {
    default: 
      this.gLK.setVisibility(8);
      AppMethodBeat.o(16816);
      return;
    case 0: 
    case 1: 
      this.gLK.setVisibility(8);
      AppMethodBeat.o(16816);
      return;
    case 3: 
      this.gLK.setVisibility(0);
      this.gLK.setImageResource(2131232188);
      this.gLK.setContentDescription(getContext().getString(2131296479));
      AppMethodBeat.o(16816);
      return;
    }
    this.gLK.setVisibility(0);
    this.gLK.setImageResource(2131232187);
    this.gLK.setContentDescription(getContext().getString(2131296451));
    AppMethodBeat.o(16816);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(16827);
    Rect localRect = new Rect();
    this.gLK.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(16827);
    return localRect;
  }
  
  private static void i(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(16828);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(16828);
  }
  
  private static void j(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(16829);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(16829);
  }
  
  private static int xI(String paramString)
  {
    AppMethodBeat.i(16830);
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
    AppMethodBeat.o(16830);
    return i;
  }
  
  public final boolean asv()
  {
    AppMethodBeat.i(16815);
    Object localObject = this.gLJ.getText().toString();
    switch (this.gLN)
    {
    case 0: 
    default: 
      if (((String)localObject).length() >= this.gLS)
      {
        AppMethodBeat.o(16815);
        return true;
      }
      break;
    case 1: 
      if ((((String)localObject).length() >= this.gLS) && (((String)localObject).length() <= this.gLT))
      {
        if (localObject == null) {
          localObject = null;
        }
        while (PhoneNumberUtils.isGlobalPhoneNumber((String)localObject))
        {
          AppMethodBeat.o(16815);
          return true;
          String str = ((String)localObject).replaceAll("\\D", "");
          localObject = str;
          if (str.startsWith("86")) {
            localObject = str.substring(2);
          }
        }
      }
      AppMethodBeat.o(16815);
      return false;
    case 2: 
      if ((((String)localObject).length() >= this.gLS) && (xI((String)localObject) <= 32))
      {
        AppMethodBeat.o(16815);
        return true;
      }
      AppMethodBeat.o(16815);
      return false;
    case 3: 
    case 5: 
      if ((((String)localObject).length() >= this.gLS) && (xI((String)localObject) <= 128))
      {
        AppMethodBeat.o(16815);
        return true;
      }
      AppMethodBeat.o(16815);
      return false;
    case 4: 
      if (((String)localObject).length() <= this.gLT)
      {
        AppMethodBeat.o(16815);
        return true;
      }
      AppMethodBeat.o(16815);
      return false;
    }
    AppMethodBeat.o(16815);
    return false;
  }
  
  public final boolean asw()
  {
    AppMethodBeat.i(16822);
    if (getText().equals(bo.nullAsNil(this.gLW)))
    {
      AppMethodBeat.o(16822);
      return false;
    }
    AppMethodBeat.o(16822);
    return true;
  }
  
  public String getText()
  {
    AppMethodBeat.i(16810);
    String str = this.gLJ.getText().toString();
    AppMethodBeat.o(16810);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(16818);
    if (this.gLH != null) {
      this.gLH.onFocusChange(this, paramBoolean);
    }
    ab.d("MicroMsg.AddrEditView", "View:" + this.gLM + ", editType:" + this.gLN + " onFocusChange to " + paramBoolean);
    if (this.gLG != null) {
      this.gLG.ass();
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
      AppMethodBeat.o(16818);
      return;
      this.gLI.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2130839163);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(16813);
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
      AppMethodBeat.o(16813);
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
    AppMethodBeat.o(16813);
    return true;
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(16823);
    if (this.gLJ != null)
    {
      Rect localRect = new Rect();
      i(this.gLJ, localRect);
      this.gLJ.setBackgroundResource(paramInt);
      j(this.gLJ, localRect);
    }
    AppMethodBeat.o(16823);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(16811);
    this.gLJ.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(16811);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(16812);
    super.setEnabled(paramBoolean);
    this.gLP = paramBoolean;
    this.gLK.setEnabled(true);
    AppMethodBeat.o(16812);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(16819);
    this.gLJ.setHint(paramString);
    AppMethodBeat.o(16819);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(16825);
    this.gLJ.setImeOptions(paramInt);
    AppMethodBeat.o(16825);
  }
  
  public void setInfoIvOnClickListener(AddrEditView.a parama)
  {
    this.gLF = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(16826);
    this.gLK.setVisibility(paramInt);
    AppMethodBeat.o(16826);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(16814);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(16814);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(16817);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.gLH = paramOnFocusChangeListener;
    AppMethodBeat.o(16817);
  }
  
  public void setOnInputValidChangeListener(AddrEditView.b paramb)
  {
    this.gLG = paramb;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(16820);
    this.gLI.setText(paramString);
    AppMethodBeat.o(16820);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(16824);
    if (this.gLI != null) {
      this.gLI.setTextColor(paramInt);
    }
    AppMethodBeat.o(16824);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(16821);
    this.gLJ.setText(paramString);
    this.gLJ.setSelection(this.gLJ.getText().length());
    this.gLW = paramString;
    AppMethodBeat.o(16821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView
 * JD-Core Version:    0.7.0.1
 */