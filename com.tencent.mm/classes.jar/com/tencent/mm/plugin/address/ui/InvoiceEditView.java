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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class InvoiceEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private TextView hJf;
  private boolean hO;
  private int imeOptions;
  private int inputType;
  public boolean izA;
  private int izB;
  private int izC;
  private View.OnClickListener izD;
  private String izE;
  public boolean izG;
  private a izH;
  private c izI;
  private b izJ;
  private int izK;
  public boolean izL;
  private View.OnFocusChangeListener izr;
  EditText izs;
  private ImageView izt;
  private String izu;
  private String izv;
  private int izw;
  private int izx;
  public boolean izy;
  private int izz;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20876);
    this.izG = false;
    this.izu = "";
    this.izv = "";
    this.inputType = 1;
    this.izK = 0;
    this.gravity = 19;
    this.izw = -1;
    this.background = -1;
    this.izx = -1;
    this.izy = true;
    this.izL = true;
    this.izA = false;
    this.izB = 0;
    this.izC = 100;
    this.hO = true;
    this.izD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20875);
        if (InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0)
        {
          if ((InvoiceEditView.this.izy) && (InvoiceEditView.a(InvoiceEditView.this) != 2) && (!bt.isNullOrNil(InvoiceEditView.this.getText())))
          {
            InvoiceEditView.this.izs.setText("");
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
    this.izE = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.InvoiceEditView, paramInt, 0);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494493, this, true);
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
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 45, 43, 95, 8212, 32, 32, 40, 41, -248, -247, 64, 126, 42, 38, 94, 37, 36, 35, 64, 33, 59, 58, -230, -229, 123, 125, 91, 93, -165, -163, 12304, 12305, 60, 62, 126, 96, 183, 61, 61, 43 };
        }
        
        public final int getInputType()
        {
          return 2;
        }
      });
      eZ(this.izs.isFocused());
      this.izs.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20874);
          if ((InvoiceEditView.a(InvoiceEditView.this) == 5) && (InvoiceEditView.b(InvoiceEditView.this) != paramAnonymousEditable.toString().length()))
          {
            InvoiceEditView.a(InvoiceEditView.this, paramAnonymousEditable.toString().length());
            InvoiceEditView.this.setBankNumberValStr(paramAnonymousEditable.toString());
          }
          boolean bool = InvoiceEditView.this.aKX();
          if ((bool != InvoiceEditView.this.izA) && (InvoiceEditView.c(InvoiceEditView.this) != null))
          {
            ad.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(InvoiceEditView.this) + ", editType:" + InvoiceEditView.a(InvoiceEditView.this) + " inputValid change to " + bool);
            InvoiceEditView.this.izA = bool;
            InvoiceEditView.c(InvoiceEditView.this).aKU();
          }
          if (((!InvoiceEditView.this.izG) || (InvoiceEditView.this.izA)) && (InvoiceEditView.this.izG) && (InvoiceEditView.this.izA)) {
            InvoiceEditView.e(InvoiceEditView.this).setTextColor(InvoiceEditView.this.getResources().getColor(2131100711));
          }
          InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
          AppMethodBeat.o(20874);
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
      paramContext = new Rect();
      h(this.izs, paramContext);
      if (this.izy) {
        break label661;
      }
      this.izs.setEnabled(false);
      this.izs.setTextColor(getResources().getColor(2131099895));
      this.izs.setFocusable(false);
      this.izs.setClickable(false);
      this.izs.setBackgroundResource(2131234429);
      if (this.izL) {
        setBackgroundResource(2131231818);
      }
      setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.izs, paramContext);
      if (this.izz != -1) {
        this.izt.setImageResource(this.izz);
      }
      if (!this.hO) {
        this.izs.setSingleLine(false);
      }
      AppMethodBeat.o(20876);
      return;
      if (this.inputType == 3)
      {
        this.izs.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            if (InvoiceEditView.this.izG) {
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
      this.izs.setInputType(this.inputType);
      break;
      label661:
      this.izA = false;
      this.izs.setBackgroundResource(this.izx);
      setBackgroundResource(this.background);
    }
  }
  
  private void eZ(boolean paramBoolean)
  {
    AppMethodBeat.i(20883);
    if ((this.izy) && (!bt.isNullOrNil(getText())))
    {
      this.izt.setImageResource(2131232862);
      this.izt.setContentDescription(getContext().getString(2131757419));
      switch (this.izw)
      {
      default: 
        this.izt.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.izt.setVisibility(0);
          AppMethodBeat.o(20883);
          return;
        }
        this.izt.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 3: 
        this.izt.setVisibility(0);
        this.izt.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20883);
        return;
      }
      this.izt.setVisibility(0);
      this.izt.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20883);
      return;
    }
    switch (this.izw)
    {
    default: 
      this.izt.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.izt.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 3: 
      this.izt.setVisibility(0);
      this.izt.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20883);
      return;
    }
    this.izt.setVisibility(0);
    this.izt.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20883);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20895);
    Rect localRect = new Rect();
    this.izt.getHitRect(localRect);
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
  
  public final boolean aKX()
  {
    AppMethodBeat.i(20882);
    String str = this.izs.getText().toString();
    switch (this.izw)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() >= this.izB) && (str.length() <= this.izC))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      break;
    case 0: 
      if ((str.length() >= this.izB) && (str.length() <= this.izC))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 1: 
      if ((str.length() == 0) || ((str.length() >= this.izB) && (str.length() <= this.izC)))
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
  
  public final boolean aKY()
  {
    AppMethodBeat.i(20890);
    if (getText().equals(bt.nullAsNil(this.izE)))
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
    String str = this.izs.getText().toString();
    AppMethodBeat.o(20877);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20885);
    if (this.izr != null) {
      this.izr.onFocusChange(this, paramBoolean);
    }
    ad.d("MicroMsg.InvoiceEditView", "View:" + this.izv + ", editType:" + this.izw + " onFocusChange to " + paramBoolean);
    if (this.izI != null) {
      this.izI.aKU();
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
      AppMethodBeat.o(20885);
      return;
      this.hJf.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20880);
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
    if (this.izw == 5)
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
    this.izs.setText(str1);
    this.izs.setSelection(this.izs.getText().length());
    AppMethodBeat.o(20889);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20891);
    if (this.izs != null)
    {
      Rect localRect = new Rect();
      h(this.izs, localRect);
      this.izs.setBackgroundResource(paramInt);
      i(this.izs, localRect);
    }
    AppMethodBeat.o(20891);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20878);
    this.izs.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20878);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20879);
    super.setEnabled(paramBoolean);
    this.izy = paramBoolean;
    this.izt.setEnabled(true);
    AppMethodBeat.o(20879);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20886);
    this.izs.setHint(paramString);
    AppMethodBeat.o(20886);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20893);
    this.izs.setImeOptions(paramInt);
    AppMethodBeat.o(20893);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.izH = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20894);
    this.izt.setVisibility(paramInt);
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
    this.izr = paramOnFocusChangeListener;
    AppMethodBeat.o(20884);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.izJ = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.izI = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20887);
    this.hJf.setText(paramString);
    AppMethodBeat.o(20887);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20892);
    if (this.hJf != null) {
      this.hJf.setTextColor(paramInt);
    }
    AppMethodBeat.o(20892);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20888);
    this.izs.setText(paramString);
    this.izs.setSelection(this.izs.getText().length());
    this.izE = paramString;
    AppMethodBeat.o(20888);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void aKU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */