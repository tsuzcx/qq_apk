package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference
  extends Preference
{
  public String imz;
  private String mText;
  public String tVj;
  public String tVk;
  public int tVl;
  private int tVm;
  public boolean tVn;
  public MMEditText tVo;
  private ImageView tVp;
  public TextView tVq;
  private int tVr;
  public a tVs;
  
  public InputClearablePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputClearablePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void ajI(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(26333);
    if (!bs.isNullOrNil(paramString))
    {
      int i = f.aRl(paramString);
      if (i <= this.tVl) {
        break label90;
      }
      bool1 = true;
      e(bool1, f.cM(this.tVl, ""), f.cN(this.tVl, paramString));
      if (this.tVs != null)
      {
        paramString = this.tVs;
        if (i > this.tVl) {
          break label95;
        }
      }
    }
    label90:
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.nw(bool1);
      AppMethodBeat.o(26333);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26334);
    if (this.tVq != null)
    {
      if (paramBoolean)
      {
        this.tVq.setText(String.format(this.imz, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        this.tVq.setVisibility(0);
        AppMethodBeat.o(26334);
        return;
      }
      this.tVq.setVisibility(8);
    }
    AppMethodBeat.o(26334);
  }
  
  public final void ny(boolean paramBoolean)
  {
    AppMethodBeat.i(26335);
    if (this.tVq != null)
    {
      if (paramBoolean)
      {
        this.tVq.setText(this.tVk);
        this.tVq.setVisibility(0);
        AppMethodBeat.o(26335);
        return;
      }
      this.tVq.setVisibility(8);
    }
    AppMethodBeat.o(26335);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26332);
    super.onBindView(paramView);
    this.tVr = a.au(this.mContext, 2131165466);
    this.tVo = ((MMEditText)paramView.findViewById(2131299306));
    this.tVp = ((ImageView)paramView.findViewById(2131298982));
    this.tVq = ((TextView)paramView.findViewById(2131299513));
    if (this.tVo != null)
    {
      if (this.tVm <= 0) {
        break label273;
      }
      this.tVo.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.tVm), new b() });
    }
    for (;;)
    {
      this.tVo.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          boolean bool = false;
          AppMethodBeat.i(26325);
          if (paramAnonymousEditable != null)
          {
            paramAnonymousEditable = paramAnonymousEditable.toString();
            InputClearablePreference.a(InputClearablePreference.this, paramAnonymousEditable);
            InputClearablePreference localInputClearablePreference = InputClearablePreference.this;
            if (bs.isNullOrNil(paramAnonymousEditable)) {}
            for (;;)
            {
              InputClearablePreference.a(localInputClearablePreference, bool);
              InputClearablePreference.b(InputClearablePreference.this, paramAnonymousEditable);
              AppMethodBeat.o(26325);
              return;
              bool = true;
            }
          }
          InputClearablePreference.a(InputClearablePreference.this, false);
          AppMethodBeat.o(26325);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(26324);
          if (paramAnonymousCharSequence != null)
          {
            ac.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", new Object[] { paramAnonymousCharSequence.toString() });
            if (InputClearablePreference.a(InputClearablePreference.this) != null) {
              InputClearablePreference.a(InputClearablePreference.this).adW(paramAnonymousCharSequence.toString());
            }
          }
          AppMethodBeat.o(26324);
        }
      });
      ac.d("MicroMsg.Label.InputClearablePreference", "mText %s", new Object[] { this.mText });
      setText(this.mText);
      if (!bs.isNullOrNil(this.mText)) {
        this.tVo.setSelection(this.mText.length());
      }
      if (this.tVn) {
        new ao().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26328);
            if (InputClearablePreference.b(InputClearablePreference.this) != null)
            {
              InputMethodManager localInputMethodManager = (InputMethodManager)InputClearablePreference.b(InputClearablePreference.this).getContext().getSystemService("input_method");
              InputClearablePreference.b(InputClearablePreference.this).requestFocus();
              localInputMethodManager.showSoftInput(InputClearablePreference.b(InputClearablePreference.this), 0);
              InputClearablePreference.b(InputClearablePreference.this).setCursorVisible(false);
              InputClearablePreference.b(InputClearablePreference.this).setCursorVisible(true);
            }
            AppMethodBeat.o(26328);
          }
        }, 0L);
      }
      this.tVo.setHint(this.tVj);
      this.tVp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26326);
          if (InputClearablePreference.b(InputClearablePreference.this) != null)
          {
            InputClearablePreference.b(InputClearablePreference.this).setText("");
            InputClearablePreference.b(InputClearablePreference.this, "");
          }
          AppMethodBeat.o(26326);
        }
      });
      if (this.tVq != null) {
        this.tVq.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(26327);
            if (InputClearablePreference.b(InputClearablePreference.this) != null) {
              InputClearablePreference.b(InputClearablePreference.this).clearFocus();
            }
            AppMethodBeat.o(26327);
            return false;
          }
        });
      }
      AppMethodBeat.o(26332);
      return;
      label273:
      this.tVo.setFilters(new InputFilter[] { new b() });
    }
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(26331);
    this.mText = paramString;
    if ((this.tVo != null) && (!bs.isNullOrNil(paramString)))
    {
      paramString = k.b(this.mContext, this.mText, this.tVr);
      this.tVo.setText(paramString);
      ajI(this.mText);
    }
    AppMethodBeat.o(26331);
  }
  
  public static abstract interface a
  {
    public abstract void adW(String paramString);
    
    public abstract void nw(boolean paramBoolean);
  }
  
  final class b
    implements InputFilter
  {
    public final char[] tVu;
    
    b()
    {
      AppMethodBeat.i(26329);
      this.tVu = new char[] { 10, 44, 59, 12289, -244, -229 };
      AppMethodBeat.o(26329);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(26330);
      ac.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      paramInt4 = paramInt1;
      while (paramInt4 < paramInt2)
      {
        paramSpanned = new char[paramInt2 - paramInt1];
        TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, paramSpanned, 0);
        int j = this.tVu.length;
        int i = 0;
        while (i < j)
        {
          if ((paramSpanned[paramInt4] == ' ') && (paramInt3 == 0) && (paramInt4 == 0))
          {
            AppMethodBeat.o(26330);
            return "";
          }
          if (paramSpanned[paramInt4] == this.tVu[i])
          {
            InputClearablePreference.this.ny(true);
            AppMethodBeat.o(26330);
            return "";
          }
          i += 1;
        }
        paramInt4 += 1;
      }
      AppMethodBeat.o(26330);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference
 * JD-Core Version:    0.7.0.1
 */