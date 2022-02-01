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
  public boolean nlH;
  private int nlI;
  private int nlJ;
  private View.OnClickListener nlK;
  private String nlL;
  public boolean nlN;
  private a nlO;
  private c nlP;
  private b nlQ;
  private int nlR;
  public boolean nlS;
  private View.OnFocusChangeListener nly;
  EditText nlz;
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20876);
    this.nlN = false;
    this.nlB = "";
    this.nlC = "";
    this.inputType = 1;
    this.nlR = 0;
    this.ek = 19;
    this.editType = -1;
    this.background = -1;
    this.nlE = -1;
    this.nlF = true;
    this.nlS = true;
    this.nlH = false;
    this.nlI = 0;
    this.nlJ = 100;
    this.bCn = true;
    this.nlK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20875);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/InvoiceEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (InvoiceEditView.f(InvoiceEditView.this).getVisibility() == 0)
        {
          if ((!InvoiceEditView.this.nlF) || (InvoiceEditView.a(InvoiceEditView.this) == 2) || (Util.isNullOrNil(InvoiceEditView.this.getText()))) {
            break label130;
          }
          InvoiceEditView.this.nlz.setText("");
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
    this.nlL = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.eWJ, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(R.n.eWQ, 0);
    if (paramInt != 0) {
      this.nlB = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(R.n.eWU, 0);
    if (paramInt != 0) {
      this.nlC = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(R.n.eWM, 1);
    this.editType = paramAttributeSet.getInteger(R.n.eWO, 0);
    this.nlF = paramAttributeSet.getBoolean(R.n.eWP, true);
    this.ek = paramAttributeSet.getInt(R.n.eWK, 19);
    this.nlD = paramAttributeSet.getInteger(R.n.eWN, 5);
    this.background = paramAttributeSet.getResourceId(R.n.eWL, R.g.transparent_background);
    this.nlG = paramAttributeSet.getResourceId(R.n.eWS, -1);
    this.nlE = paramAttributeSet.getResourceId(R.n.eWR, R.g.transparent_background);
    this.bCn = paramAttributeSet.getBoolean(R.n.eWT, true);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.ehF, this, true);
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
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 45, 43, 95, 8212, 32, 32, 40, 41, -248, -247, 64, 126, 42, 38, 94, 37, 36, 35, 64, 33, 59, 58, -230, -229, 123, 125, 91, 93, -165, -163, 12304, 12305, 60, 62, 126, 96, 183, 61, 61, 43 };
        }
        
        public final int getInputType()
        {
          return 2;
        }
      });
      hd(this.nlz.isFocused());
      this.nlz.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(20874);
          if ((InvoiceEditView.a(InvoiceEditView.this) == 5) && (InvoiceEditView.b(InvoiceEditView.this) != paramAnonymousEditable.toString().length()))
          {
            InvoiceEditView.a(InvoiceEditView.this, paramAnonymousEditable.toString().length());
            InvoiceEditView.this.setBankNumberValStr(paramAnonymousEditable.toString());
          }
          boolean bool = InvoiceEditView.this.bAz();
          if ((bool != InvoiceEditView.this.nlH) && (InvoiceEditView.c(InvoiceEditView.this) != null))
          {
            Log.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(InvoiceEditView.this) + ", editType:" + InvoiceEditView.a(InvoiceEditView.this) + " inputValid change to " + bool);
            InvoiceEditView.this.nlH = bool;
            InvoiceEditView.c(InvoiceEditView.this).bAv();
          }
          if (((!InvoiceEditView.this.nlN) || (InvoiceEditView.this.nlH)) && (InvoiceEditView.this.nlN) && (InvoiceEditView.this.nlH)) {
            InvoiceEditView.e(InvoiceEditView.this).setTextColor(InvoiceEditView.this.getResources().getColor(R.e.normal_text_color));
          }
          InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.e(InvoiceEditView.this).isFocused());
          AppMethodBeat.o(20874);
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
      paramContext = new Rect();
      d(this.nlz, paramContext);
      if (this.nlF) {
        break label685;
      }
      this.nlz.setEnabled(false);
      this.nlz.setTextColor(getResources().getColor(R.e.djW));
      this.nlz.setFocusable(false);
      this.nlz.setClickable(false);
      this.nlz.setBackgroundResource(R.g.transparent_background);
      if (this.nlS) {
        setBackgroundResource(R.g.comm_list_item_selector);
      }
      setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    for (;;)
    {
      e(this.nlz, paramContext);
      if (this.nlG != -1) {
        this.nlA.setImageResource(this.nlG);
      }
      if (!this.bCn) {
        this.nlz.setSingleLine(false);
      }
      AppMethodBeat.o(20876);
      return;
      if (this.inputType == 3)
      {
        this.nlz.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            if (InvoiceEditView.this.nlN) {
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
      this.nlz.setInputType(this.inputType);
      break;
      label685:
      this.nlH = false;
      this.nlz.setBackgroundResource(this.nlE);
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
    this.nlA.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20895);
    return localRect;
  }
  
  private void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(20883);
    if ((this.nlF) && (!Util.isNullOrNil(getText())))
    {
      this.nlA.setImageResource(R.g.list_clear);
      this.nlA.setContentDescription(getContext().getString(R.l.clear_btn));
      switch (this.editType)
      {
      default: 
        this.nlA.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.nlA.setVisibility(0);
          AppMethodBeat.o(20883);
          return;
        }
        this.nlA.setVisibility(8);
        AppMethodBeat.o(20883);
        return;
      case 3: 
        this.nlA.setVisibility(0);
        this.nlA.setContentDescription(getContext().getString(R.l.address_location));
        AppMethodBeat.o(20883);
        return;
      }
      this.nlA.setVisibility(0);
      this.nlA.setContentDescription(getContext().getString(R.l.address_contact));
      AppMethodBeat.o(20883);
      return;
    }
    switch (this.editType)
    {
    default: 
      this.nlA.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.nlA.setVisibility(8);
      AppMethodBeat.o(20883);
      return;
    case 3: 
      this.nlA.setVisibility(0);
      this.nlA.setContentDescription(getContext().getString(R.l.address_location));
      AppMethodBeat.o(20883);
      return;
    }
    this.nlA.setVisibility(0);
    this.nlA.setContentDescription(getContext().getString(R.l.address_contact));
    AppMethodBeat.o(20883);
  }
  
  public final boolean bAA()
  {
    AppMethodBeat.i(20890);
    if (getText().equals(Util.nullAsNil(this.nlL)))
    {
      AppMethodBeat.o(20890);
      return false;
    }
    AppMethodBeat.o(20890);
    return true;
  }
  
  public final boolean bAz()
  {
    AppMethodBeat.i(20882);
    String str = this.nlz.getText().toString();
    switch (this.editType)
    {
    case 2: 
    case 3: 
    default: 
      if ((str.length() >= this.nlI) && (str.length() <= this.nlJ))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      break;
    case 0: 
      if ((str.length() >= this.nlI) && (str.length() <= this.nlJ))
      {
        AppMethodBeat.o(20882);
        return true;
      }
      AppMethodBeat.o(20882);
      return false;
    case 1: 
      if ((str.length() == 0) || ((str.length() >= this.nlI) && (str.length() <= this.nlJ)))
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
    String str = this.nlz.getText().toString();
    AppMethodBeat.o(20877);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20885);
    if (this.nly != null) {
      this.nly.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.InvoiceEditView", "View:" + this.nlC + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
    if (this.nlP != null) {
      this.nlP.bAv();
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
      AppMethodBeat.o(20885);
      return;
      this.mrN.setEnabled(true);
      break;
      label164:
      setBackgroundResource(R.g.input_bar_bg_normal);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20880);
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
    this.nlz.setText(str1);
    this.nlz.setSelection(this.nlz.getText().length());
    AppMethodBeat.o(20889);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20891);
    if (this.nlz != null)
    {
      Rect localRect = new Rect();
      d(this.nlz, localRect);
      this.nlz.setBackgroundResource(paramInt);
      e(this.nlz, localRect);
    }
    AppMethodBeat.o(20891);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20878);
    this.nlz.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20878);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20879);
    super.setEnabled(paramBoolean);
    this.nlF = paramBoolean;
    this.nlA.setEnabled(true);
    AppMethodBeat.o(20879);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20886);
    this.nlz.setHint(paramString);
    AppMethodBeat.o(20886);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20893);
    this.nlz.setImeOptions(paramInt);
    AppMethodBeat.o(20893);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.nlO = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20894);
    this.nlA.setVisibility(paramInt);
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
    this.nly = paramOnFocusChangeListener;
    AppMethodBeat.o(20884);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.nlQ = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.nlP = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20887);
    this.mrN.setText(paramString);
    AppMethodBeat.o(20887);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20892);
    if (this.mrN != null) {
      this.mrN.setTextColor(paramInt);
    }
    AppMethodBeat.o(20892);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20888);
    this.nlz.setText(paramString);
    this.nlz.setSelection(this.nlz.getText().length());
    this.nlL = paramString;
    AppMethodBeat.o(20888);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void bAv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView
 * JD-Core Version:    0.7.0.1
 */