package com.tencent.mm.plugin.address.ui;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;

public class InvoiceQrcodeTextView
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
  private int jvP;
  public boolean jvQ;
  private View.OnFocusChangeListener jvw;
  private ImageView jvy;
  private String jvz;
  private a jwd;
  private c jwe;
  private b jwf;
  TextView jwg;
  private int jwh;
  private int jwi;
  private boolean kI;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20929);
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
        AppMethodBeat.i(186394);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (InvoiceQrcodeTextView.c(InvoiceQrcodeTextView.this).getVisibility() == 0)
        {
          if ((!InvoiceQrcodeTextView.this.jvD) || (InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this) == 2) || (bu.isNullOrNil(InvoiceQrcodeTextView.this.getText()))) {
            break label128;
          }
          InvoiceQrcodeTextView.this.jwg.setText("");
          InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.e(InvoiceQrcodeTextView.this).isFocused());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186394);
          return;
          label128:
          if (InvoiceQrcodeTextView.f(InvoiceQrcodeTextView.this) != null) {
            InvoiceQrcodeTextView.f(InvoiceQrcodeTextView.this);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494496, this, true);
    this.jwg = ((TextView)paramAttributeSet.findViewById(2131300744));
    this.jwg.setTextSize(0, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
    this.iFP = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.jvy = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.jvy.setOnClickListener(this.jvI);
    this.jwg.setImeOptions(this.imeOptions);
    if (!bu.isNullOrNil(this.jvz)) {
      this.jwg.setHint(this.jvz);
    }
    if (!bu.isNullOrNil(this.jvA)) {
      this.iFP.setText(this.jvA);
    }
    paramContext = new Rect();
    h(this.jwg, paramContext);
    i(this.jwg, paramContext);
    setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.jvE != -1) {
      this.jvy.setImageResource(this.jvE);
    }
    if (!this.kI) {
      this.jwg.setSingleLine(false);
    }
    this.jwg.setOnTouchListener(new InvoiceQrcodeTextView.1(this));
    this.jwg.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(186393);
        Object localObject1 = new b();
        ((b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).ahF());
        localObject1 = (ClipboardManager)ak.getContext().getSystemService("clipboard");
        paramAnonymousView = (TextView)paramAnonymousView;
        if ((paramAnonymousView.getText() != null) && (localObject1 != null))
        {
          final CharSequence localCharSequence = paramAnonymousView.getText();
          Object localObject2 = new SpannableString(localCharSequence);
          ((SpannableString)localObject2).setSpan(new BackgroundColorSpan(paramAnonymousView.getContext().getResources().getColor(2131100539)), 0, localCharSequence.length(), 33);
          paramAnonymousView.setText((CharSequence)localObject2);
          localObject2 = new com.tencent.mm.ui.widget.b.a(paramAnonymousView.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.b.a)localObject2).LwG = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(186390);
              paramAnonymous2ContextMenu.add(paramAnonymousView.getContext().getString(2131755701));
              AppMethodBeat.o(186390);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject2).LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(186391);
              if (paramAnonymous2Int == 0)
              {
                this.jwl.setText(paramAnonymousView.getText().toString());
                h.cl(paramAnonymousView.getContext(), paramAnonymousView.getContext().getString(2131755702));
              }
              AppMethodBeat.o(186391);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject2).LhV = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(186392);
              paramAnonymousView.setText(localCharSequence);
              AppMethodBeat.o(186392);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject2).el(InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this), InvoiceQrcodeTextView.b(InvoiceQrcodeTextView.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(186393);
        return false;
      }
    });
    AppMethodBeat.o(20929);
  }
  
  private void fy(boolean paramBoolean)
  {
    AppMethodBeat.i(20936);
    if ((this.jvD) && (!bu.isNullOrNil(getText())))
    {
      this.jvy.setImageResource(2131232862);
      this.jvy.setContentDescription(getContext().getString(2131757419));
      switch (this.jvB)
      {
      default: 
        this.jvy.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.jvy.setVisibility(0);
          AppMethodBeat.o(20936);
          return;
        }
        this.jvy.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 3: 
        this.jvy.setVisibility(0);
        this.jvy.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20936);
        return;
      }
      this.jvy.setVisibility(0);
      this.jvy.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20936);
      return;
    }
    switch (this.jvB)
    {
    default: 
      this.jvy.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.jvy.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 3: 
      this.jvy.setVisibility(0);
      this.jvy.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20936);
      return;
    }
    this.jvy.setVisibility(0);
    this.jvy.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20936);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20947);
    Rect localRect = new Rect();
    this.jvy.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(20947);
    return localRect;
  }
  
  private static void h(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20948);
    paramRect.left = paramView.getPaddingLeft();
    paramRect.right = paramView.getPaddingRight();
    paramRect.top = paramView.getPaddingTop();
    paramRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(20948);
  }
  
  private static void i(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(20949);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(20949);
  }
  
  public final void aVC()
  {
    AppMethodBeat.i(20930);
    setBackgroundResource(0);
    this.iFP.setTextColor(getResources().getColor(2131100490));
    this.jwg.setTextColor(getResources().getColor(2131100711));
    this.jwg.setInputType(0);
    this.jwg.clearFocus();
    this.jwg.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jwg.getWindowToken(), 0);
    AppMethodBeat.o(20930);
  }
  
  public String getText()
  {
    AppMethodBeat.i(20931);
    String str = this.jwg.getText().toString();
    AppMethodBeat.o(20931);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20938);
    if (this.jvw != null) {
      this.jvw.onFocusChange(this, paramBoolean);
    }
    ae.d("MicroMsg.InvoiceEditView", "View:" + this.jvA + ", editType:" + this.jvB + " onFocusChange to " + paramBoolean);
    if (!this.jvF)
    {
      this.iFP.setEnabled(false);
      if (paramView == this.jwg)
      {
        paramView = new Rect();
        h(this, paramView);
        if (!paramBoolean) {
          break label148;
        }
        setBackgroundResource(2131232723);
      }
    }
    for (;;)
    {
      i(this, paramView);
      fy(paramBoolean);
      AppMethodBeat.o(20938);
      return;
      this.iFP.setEnabled(true);
      break;
      label148:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20934);
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
      AppMethodBeat.o(20934);
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
    AppMethodBeat.o(20934);
    return true;
  }
  
  public void setBankNumberValStr(String paramString)
  {
    AppMethodBeat.i(20942);
    String str1 = paramString;
    if (this.jvB == 5)
    {
      String str2 = paramString.replace(" ", "");
      str1 = paramString;
      if (str2.length() >= 4)
      {
        paramString = new StringBuilder();
        int i = 0;
        while (i < str2.length() / 4)
        {
          paramString.append(str2.substring(i * 4, (i + 1) * 4)).append(" ");
          i += 1;
        }
        str1 = str2.substring(str2.length() / 4 * 4, str2.length());
      }
    }
    this.jwg.setText(str1);
    AppMethodBeat.o(20942);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20943);
    if (this.jwg != null)
    {
      Rect localRect = new Rect();
      h(this.jwg, localRect);
      this.jwg.setBackgroundResource(paramInt);
      i(this.jwg, localRect);
    }
    AppMethodBeat.o(20943);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20932);
    this.jwg.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20932);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20933);
    super.setEnabled(paramBoolean);
    this.jvD = paramBoolean;
    this.jvy.setEnabled(true);
    AppMethodBeat.o(20933);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20939);
    this.jwg.setHint(paramString);
    AppMethodBeat.o(20939);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20945);
    this.jwg.setImeOptions(paramInt);
    AppMethodBeat.o(20945);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.jwd = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20946);
    this.jvy.setVisibility(paramInt);
    AppMethodBeat.o(20946);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(20935);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(20935);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(20937);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.jvw = paramOnFocusChangeListener;
    AppMethodBeat.o(20937);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.jwf = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.jwe = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20940);
    this.iFP.setText(paramString);
    AppMethodBeat.o(20940);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20944);
    if (this.iFP != null) {
      this.iFP.setTextColor(paramInt);
    }
    AppMethodBeat.o(20944);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20941);
    this.jwg.setText(paramString);
    this.jvJ = paramString;
    AppMethodBeat.o(20941);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView
 * JD-Core Version:    0.7.0.1
 */