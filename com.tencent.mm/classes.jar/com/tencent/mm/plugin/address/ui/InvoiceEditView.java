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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class InvoiceEditView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background;
  private int gravity;
  private TextView iFP;
  private int imeOptions;
  private int inputType;
  private String jvA;
  private int jvB;
  private int jvC;
  public boolean jvD;
  private int jvE;
  public boolean jvF;
  private int jvG;
  private int jvH;
  private View.OnClickListener jvI;
  private String jvJ;
  public boolean jvL;
  private a jvM;
  private c jvN;
  private b jvO;
  private int jvP;
  public boolean jvQ;
  private View.OnFocusChangeListener jvw;
  EditText jvx;
  private ImageView jvy;
  private String jvz;
  private boolean kI;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20876);
    this.jvL = false;
    this.jvz = "";
    this.jvA = "";
    this.inputType = 1;
    this.jvP = 0;
    this.gravity = 19;
    this.jvB = -1;
    this.background = -1;
    this.jvC = -1;
    this.jvD = true;
    this.jvQ = true;
    this.jvF = false;
    this.jvG = 0;
    this.jvH = 100;
    this.kI = true;
    this.jvI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20875);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0)
        {
          if ((!InvoiceEditView.this.jvD) || (InvoiceEditView.a(InvoiceEditView.this) == 2) || (bu.isNullOrNil(InvoiceEditView.this.getText()))) {
            break label130;
          }
          InvoiceEditView.this.jvx.setText("");
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
    this.jvJ = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.InvoiceEditView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.jvz = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.jvA = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(3, 1);
    this.jvB = paramAttributeSet.getInteger(5, 0);
    this.jvD = paramAttributeSet.getBoolean(6, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.imeOptions = paramAttributeSet.getInteger(4, 5);
    this.background = paramAttributeSet.getResourceId(1, 2131234429);
    this.jvE = paramAttributeSet.getResourceId(10, -1);
    this.jvC = paramAttributeSet.getResourceId(8, 2131234429);
    this.kI = paramAttributeSet.getBoolean(12, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494493, this, true);
    this.jvx = ((EditText)paramAttributeSet.findViewById(2131300744));
    this.jvx.setTextSize(0, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
    this.iFP = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.jvy = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.jvy.setOnClickListener(this.jvI);
    this.jvx.setImeOptions(this.imeOptions);
    this.jvx.setInputType(this.inputType);
    if (this.inputType == 2)
    {
      this.jvx.setKeyListener(new NumberKeyListener()
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
      fy(this.jvx.isFocused());
      this.jvx.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20874);
          if ((InvoiceEditView.a(InvoiceEditView.this) == 5) && (InvoiceEditView.b(InvoiceEditView.this) != paramAnonymousEditable.toString().length()))
          {
            InvoiceEditView.a(InvoiceEditView.this, paramAnonymousEditable.toString().length());
            InvoiceEditView.this.setBankNumberValStr(paramAnonymousEditable.toString());
          }
          boolean bool = InvoiceEditView.this.aVz();
          if ((bool != InvoiceEditView.this.jvF) && (InvoiceEditView.c(InvoiceEditView.this) != null))
          {
            ae.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(InvoiceEditView.this) + ", editType:" + InvoiceEditView.a(InvoiceEditView.this) + " inputValid change to " + bool);
            InvoiceEditView.this.jvF = bool;
            InvoiceEditView.c(InvoiceEditView.this).aVw();
          }
          if (((!InvoiceEditView.this.jvL) || (InvoiceEditView.this.jvF)) && (InvoiceEditView.this.jvL) && (InvoiceEditView.this.jvF)) {
            InvoiceEditView.e(InvoiceEditView.this).setTextColor(InvoiceEditView.this.getResources().getColor(2131100711));
          }
          InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
          AppMethodBeat.o(20874);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.jvx.setOnFocusChangeListener(this);
      if (!bu.isNullOrNil(this.jvz)) {
        this.jvx.setHint(this.jvz);
      }
      if (!bu.isNullOrNil(this.jvA)) {
        this.iFP.setText(this.jvA);
      }
      paramContext = new Rect();
      h(this.jvx, paramContext);
      if (this.jvD) {
        break label661;
      }
      this.jvx.setEnabled(false);
      this.jvx.setTextColor(getResources().getColor(2131099895));
      this.jvx.setFocusable(false);
      this.jvx.setClickable(false);
      this.jvx.setBackgroundResource(2131234429);
      if (this.jvQ) {
        setBackgroundResource(2131231818);
      }
      setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      i(this.jvx, paramContext);
      if (this.jvE != -1) {
        this.jvy.setImageResource(this.jvE);
      }
      if (!this.kI) {
        this.jvx.setSingleLine(false);
      }
      AppMethodBeat.o(20876);
      return;
      if (this.inputType == 3)
      {
        this.jvx.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            if (InvoiceEditView.this.jvL) {
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
      this.jvx.setInputType(this.inputType);
      break;
      label661:
      this.jvF = false;
      this.jvx.setBackgroundResource(this.jvC);
      setBackgroundResource(this.background);
    }
  }
  
  private void fy(boolean paramBoolean)
  {
    AppMethodBeat.i(20883);
    if ((this.jvD) && (!bu.isNullOrNil(getText())))
    {
      this.jvy.setImageResource(2131232862);
      this.jvy.setContentDescription(getContext().getString(2131757419));
      switch (this.jvB)
      {
      default: 
        this.jvy.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.jvy.setVisibility(0);
          AppMethodBeat.o(20883);
          return;
        }
        this.jvy.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 3: 
        this.jvy.setVisibility(0);
        this.jvy.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20883);
        return;
      }
      this.jvy.setVisibility(0);
      this.jvy.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20883);
      return;
    }
    switch (this.jvB)
    {
    default: 
      this.jvy.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.jvy.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 3: 
      this.jvy.setVisibility(0);
      this.jvy.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20883);
      return;
    }
    this.jvy.setVisibility(0);
    this.jvy.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20883);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20895);
    Rect localRect = new Rect();
    this.jvy.getHitRect(localRect);
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
  
  public final boolean aVA()
  {
    AppMethodBeat.i(20890);
    if (getText().equals(bu.nullAsNil(this.jvJ)))
    {
      AppMethodBeat.o(20890);
      return false;
    }
    AppMethodBeat.o(20890);
    return true;
  }
  
  public final boolean aVz()
  {
    AppMethodBeat.i(20882);
    String str = this.jvx.getText().toString();
    switch (this.jvB)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() >= this.jvG) && (str.length() <= this.jvH))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      break;
    case 0: 
      if ((str.length() >= this.jvG) && (str.length() <= this.jvH))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 1: 
      if ((str.length() == 0) || ((str.length() >= this.jvG) && (str.length() <= this.jvH)))
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
  
  public String getText()
  {
    AppMethodBeat.i(20877);
    String str = this.jvx.getText().toString();
    AppMethodBeat.o(20877);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20885);
    if (this.jvw != null) {
      this.jvw.onFocusChange(this, paramBoolean);
    }
    ae.d("MicroMsg.InvoiceEditView", "View:" + this.jvA + ", editType:" + this.jvB + " onFocusChange to " + paramBoolean);
    if (this.jvN != null) {
      this.jvN.aVw();
    }
    if (!this.jvF)
    {
      this.iFP.setEnabled(false);
      if (paramView == this.jvx)
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
      fy(paramBoolean);
      AppMethodBeat.o(20885);
      return;
      this.iFP.setEnabled(true);
      break;
      label164:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20880);
    int i;
    if (!this.jvD)
    {
      if (this.jvy.getVisibility() != 0) {
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
    if (this.jvB == 5)
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
    this.jvx.setText(str1);
    this.jvx.setSelection(this.jvx.getText().length());
    AppMethodBeat.o(20889);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20891);
    if (this.jvx != null)
    {
      Rect localRect = new Rect();
      h(this.jvx, localRect);
      this.jvx.setBackgroundResource(paramInt);
      i(this.jvx, localRect);
    }
    AppMethodBeat.o(20891);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20878);
    this.jvx.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20878);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20879);
    super.setEnabled(paramBoolean);
    this.jvD = paramBoolean;
    this.jvy.setEnabled(true);
    AppMethodBeat.o(20879);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20886);
    this.jvx.setHint(paramString);
    AppMethodBeat.o(20886);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20893);
    this.jvx.setImeOptions(paramInt);
    AppMethodBeat.o(20893);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.jvM = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20894);
    this.jvy.setVisibility(paramInt);
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
    this.jvw = paramOnFocusChangeListener;
    AppMethodBeat.o(20884);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.jvO = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.jvN = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20887);
    this.iFP.setText(paramString);
    AppMethodBeat.o(20887);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20892);
    if (this.iFP != null) {
      this.iFP.setTextColor(paramInt);
    }
    AppMethodBeat.o(20892);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20888);
    this.jvx.setText(paramString);
    this.jvx.setSelection(this.jvx.getText().length());
    this.jvJ = paramString;
    AppMethodBeat.o(20888);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void aVw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */