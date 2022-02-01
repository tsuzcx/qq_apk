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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

public class InvoiceQrcodeTextView
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
  private int iZN;
  public boolean iZO;
  private View.OnFocusChangeListener iZu;
  private ImageView iZw;
  private String iZx;
  private String iZy;
  private int iZz;
  private TextView ijF;
  private int imeOptions;
  private int inputType;
  private a jab;
  private c jac;
  private b jad;
  TextView jae;
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceQrcodeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20929);
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
        AppMethodBeat.i(20928);
        if (InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this).getVisibility() == 0)
        {
          if ((InvoiceQrcodeTextView.this.iZB) && (InvoiceQrcodeTextView.b(InvoiceQrcodeTextView.this) != 2) && (!bs.isNullOrNil(InvoiceQrcodeTextView.this.getText())))
          {
            InvoiceQrcodeTextView.this.jae.setText("");
            InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.c(InvoiceQrcodeTextView.this).isFocused());
            AppMethodBeat.o(20928);
            return;
          }
          if (InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this) != null) {
            InvoiceQrcodeTextView.d(InvoiceQrcodeTextView.this);
          }
        }
        AppMethodBeat.o(20928);
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
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494496, this, true);
    this.jae = ((TextView)paramAttributeSet.findViewById(2131300744));
    this.jae.setTextSize(0, com.tencent.mm.cc.a.au(paramContext, 2131165517));
    this.ijF = ((TextView)paramAttributeSet.findViewById(2131305880));
    this.iZw = ((ImageView)paramAttributeSet.findViewById(2131301009));
    this.iZw.setOnClickListener(this.iZG);
    this.jae.setImeOptions(this.imeOptions);
    if (!bs.isNullOrNil(this.iZx)) {
      this.jae.setHint(this.iZx);
    }
    if (!bs.isNullOrNil(this.iZy)) {
      this.ijF.setText(this.iZy);
    }
    paramContext = new Rect();
    h(this.jae, paramContext);
    i(this.jae, paramContext);
    setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    if (this.iZC != -1) {
      this.iZw.setImageResource(this.iZC);
    }
    if (!this.iR) {
      this.jae.setSingleLine(false);
    }
    this.jae.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(20927);
        final ClipboardManager localClipboardManager = (ClipboardManager)ai.getContext().getSystemService("clipboard");
        paramAnonymousView = (TextView)paramAnonymousView;
        if ((paramAnonymousView.getText() != null) && (localClipboardManager != null))
        {
          final CharSequence localCharSequence = paramAnonymousView.getText();
          Object localObject = new SpannableString(localCharSequence);
          ((SpannableString)localObject).setSpan(new BackgroundColorSpan(paramAnonymousView.getContext().getResources().getColor(2131100539)), 0, localCharSequence.length(), 33);
          paramAnonymousView.setText((CharSequence)localObject);
          localObject = new com.tencent.mm.ui.widget.b.a(paramAnonymousView.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.b.a)localObject).JiR = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(20924);
              paramAnonymous2ContextMenu.add(paramAnonymousView.getContext().getString(2131755701));
              AppMethodBeat.o(20924);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(20925);
              if (paramAnonymous2Int == 0)
              {
                localClipboardManager.setText(paramAnonymousView.getText().toString());
                h.cf(paramAnonymousView.getContext(), paramAnonymousView.getContext().getString(2131755702));
              }
              AppMethodBeat.o(20925);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).IUx = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(20926);
              paramAnonymousView.setText(localCharSequence);
              AppMethodBeat.o(20926);
            }
          };
          ((com.tencent.mm.ui.widget.b.a)localObject).ej(0, 0);
        }
        AppMethodBeat.o(20927);
        return false;
      }
    });
    AppMethodBeat.o(20929);
  }
  
  private void ft(boolean paramBoolean)
  {
    AppMethodBeat.i(20936);
    if ((this.iZB) && (!bs.isNullOrNil(getText())))
    {
      this.iZw.setImageResource(2131232862);
      this.iZw.setContentDescription(getContext().getString(2131757419));
      switch (this.iZz)
      {
      default: 
        this.iZw.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 0: 
      case 1: 
      case 4: 
      case 5: 
        if (paramBoolean)
        {
          this.iZw.setVisibility(0);
          AppMethodBeat.o(20936);
          return;
        }
        this.iZw.setVisibility(8);
        AppMethodBeat.o(20936);
        return;
      case 3: 
        this.iZw.setVisibility(0);
        this.iZw.setContentDescription(getContext().getString(2131755211));
        AppMethodBeat.o(20936);
        return;
      }
      this.iZw.setVisibility(0);
      this.iZw.setContentDescription(getContext().getString(2131755179));
      AppMethodBeat.o(20936);
      return;
    }
    switch (this.iZz)
    {
    default: 
      this.iZw.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 0: 
    case 1: 
    case 4: 
      this.iZw.setVisibility(8);
      AppMethodBeat.o(20936);
      return;
    case 3: 
      this.iZw.setVisibility(0);
      this.iZw.setContentDescription(getContext().getString(2131755211));
      AppMethodBeat.o(20936);
      return;
    }
    this.iZw.setVisibility(0);
    this.iZw.setContentDescription(getContext().getString(2131755179));
    AppMethodBeat.o(20936);
  }
  
  private Rect getValidRectOfInfoIv()
  {
    AppMethodBeat.i(20947);
    Rect localRect = new Rect();
    this.iZw.getHitRect(localRect);
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
  
  public final void aRR()
  {
    AppMethodBeat.i(20930);
    setBackgroundResource(0);
    this.ijF.setTextColor(getResources().getColor(2131100490));
    this.jae.setTextColor(getResources().getColor(2131100711));
    this.jae.setInputType(0);
    this.jae.clearFocus();
    this.jae.setSingleLine(false);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jae.getWindowToken(), 0);
    AppMethodBeat.o(20930);
  }
  
  public String getText()
  {
    AppMethodBeat.i(20931);
    String str = this.jae.getText().toString();
    AppMethodBeat.o(20931);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(20938);
    if (this.iZu != null) {
      this.iZu.onFocusChange(this, paramBoolean);
    }
    ac.d("MicroMsg.InvoiceEditView", "View:" + this.iZy + ", editType:" + this.iZz + " onFocusChange to " + paramBoolean);
    if (!this.iZD)
    {
      this.ijF.setEnabled(false);
      if (paramView == this.jae)
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
      ft(paramBoolean);
      AppMethodBeat.o(20938);
      return;
      this.ijF.setEnabled(true);
      break;
      label148:
      setBackgroundResource(2131232724);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(20934);
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
    if (this.iZz == 5)
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
    this.jae.setText(str1);
    AppMethodBeat.o(20942);
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(20943);
    if (this.jae != null)
    {
      Rect localRect = new Rect();
      h(this.jae, localRect);
      this.jae.setBackgroundResource(paramInt);
      i(this.jae, localRect);
    }
    AppMethodBeat.o(20943);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(20932);
    this.jae.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(20932);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(20933);
    super.setEnabled(paramBoolean);
    this.iZB = paramBoolean;
    this.iZw.setEnabled(true);
    AppMethodBeat.o(20933);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(20939);
    this.jae.setHint(paramString);
    AppMethodBeat.o(20939);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(20945);
    this.jae.setImeOptions(paramInt);
    AppMethodBeat.o(20945);
  }
  
  public void setInfoIvOnClickListener(a parama)
  {
    this.jab = parama;
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(20946);
    this.iZw.setVisibility(paramInt);
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
    this.iZu = paramOnFocusChangeListener;
    AppMethodBeat.o(20937);
  }
  
  public void setOnInputInvoiceTypeChangeListener(b paramb)
  {
    this.jad = paramb;
  }
  
  public void setOnInputValidChangeListener(c paramc)
  {
    this.jac = paramc;
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(20940);
    this.ijF.setText(paramString);
    AppMethodBeat.o(20940);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(20944);
    if (this.ijF != null) {
      this.ijF.setTextColor(paramInt);
    }
    AppMethodBeat.o(20944);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(20941);
    this.jae.setText(paramString);
    this.iZH = paramString;
    AppMethodBeat.o(20941);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView
 * JD-Core Version:    0.7.0.1
 */