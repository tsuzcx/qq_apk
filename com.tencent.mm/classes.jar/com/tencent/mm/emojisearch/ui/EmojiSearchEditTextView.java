package com.tencent.mm.emojisearch.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class EmojiSearchEditTextView
  extends LinearLayout
{
  private String heA;
  private a heB;
  EmojiSearchEditTextView.b heC;
  protected View.OnFocusChangeListener heD;
  private WeImageView hex;
  ImageButton hey;
  private View hez;
  String hint;
  EditText vy;
  
  public EmojiSearchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199765);
    this.heA = "";
    this.heC = EmojiSearchEditTextView.b.heF;
    this.heD = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(199761);
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).eh(paramAnonymousBoolean);
        }
        AppMethodBeat.o(199761);
      }
    };
    init();
    AppMethodBeat.o(199765);
  }
  
  public EmojiSearchEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199766);
    this.heA = "";
    this.heC = EmojiSearchEditTextView.b.heF;
    this.heD = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(199761);
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).eh(paramAnonymousBoolean);
        }
        AppMethodBeat.o(199761);
      }
    };
    init();
    AppMethodBeat.o(199766);
  }
  
  private void awB()
  {
    AppMethodBeat.i(199767);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    AppMethodBeat.o(199767);
  }
  
  private void init()
  {
    AppMethodBeat.i(199768);
    awB();
    this.hez = findViewById(2131308873);
    this.hex = ((WeImageView)findViewById(2131302468));
    this.vy = ((EditText)findViewById(2131299910));
    this.hey = ((ImageButton)findViewById(2131298744));
    this.vy.setOnKeyListener(new EmojiSearchEditTextView.1(this));
    this.vy.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(199757);
        paramAnonymousCharSequence = EmojiSearchEditTextView.this.getTotalQuery();
        if ((paramAnonymousCharSequence != EmojiSearchEditTextView.a(EmojiSearchEditTextView.this)) && (!paramAnonymousCharSequence.equals(EmojiSearchEditTextView.a(EmojiSearchEditTextView.this))))
        {
          EmojiSearchEditTextView.a(EmojiSearchEditTextView.this, paramAnonymousCharSequence);
          if (paramAnonymousCharSequence.length() <= 0) {
            break label78;
          }
          EmojiSearchEditTextView.b(EmojiSearchEditTextView.this).setVisibility(0);
        }
        for (;;)
        {
          EmojiSearchEditTextView.c(EmojiSearchEditTextView.this);
          AppMethodBeat.o(199757);
          return;
          label78:
          EmojiSearchEditTextView.b(EmojiSearchEditTextView.this).setVisibility(8);
        }
      }
    });
    this.vy.setOnFocusChangeListener(this.heD);
    this.vy.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(199758);
        if ((3 == paramAnonymousInt) && (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null))
        {
          boolean bool = EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).awE();
          AppMethodBeat.o(199758);
          return bool;
        }
        AppMethodBeat.o(199758);
        return false;
      }
    });
    this.hey.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199759);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = EmojiSearchEditTextView.this;
        ((EmojiSearchEditTextView)localObject).heC = EmojiSearchEditTextView.b.heG;
        ((EmojiSearchEditTextView)localObject).vy.setText("");
        ((EmojiSearchEditTextView)localObject).vy.setHint(((EmojiSearchEditTextView)localObject).hint);
        ((EmojiSearchEditTextView)localObject).hey.setVisibility(8);
        ((EmojiSearchEditTextView)localObject).heC = EmojiSearchEditTextView.b.heF;
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).onClickClearTextBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(199759);
      }
    });
    c.f(this.vy).aoq(100).a(null);
    if (ao.isDarkMode()) {
      this.hey.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(199768);
  }
  
  public final void awC()
  {
    AppMethodBeat.i(199770);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199760);
        ((InputMethodManager)EmojiSearchEditTextView.this.getContext().getSystemService("input_method")).showSoftInput(EmojiSearchEditTextView.e(EmojiSearchEditTextView.this), 1);
        AppMethodBeat.o(199760);
      }
    }, 128L);
    AppMethodBeat.o(199770);
  }
  
  public final void awD()
  {
    AppMethodBeat.i(199774);
    this.vy.requestFocus();
    AppMethodBeat.o(199774);
  }
  
  public ImageButton getClearBtn()
  {
    return this.hey;
  }
  
  public EditText getEditText()
  {
    return this.vy;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(199771);
    int i = this.vy.getHighlightColor();
    AppMethodBeat.o(199771);
    return i;
  }
  
  public WeImageView getIconView()
  {
    return this.hex;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(199776);
    String str = this.vy.getText().toString().trim();
    AppMethodBeat.o(199776);
    return str;
  }
  
  protected int getLayoutById()
  {
    return 2131493943;
  }
  
  public View getTagPanel()
  {
    return this.hez;
  }
  
  public EmojiSearchEditTextView.b getTextChangeStatus()
  {
    return this.heC;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(199777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.vy.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(199777);
    return localObject;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(199769);
    if (paramInt == -1)
    {
      this.vy.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(199769);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 15), com.tencent.mm.cb.a.fromDPToPix(getContext(), 15));
    this.vy.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(199769);
  }
  
  public void setEmojiSearchEditTextListener(a parama)
  {
    this.heB = parama;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(199775);
    this.vy.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(199775);
  }
  
  public void setText(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(199772);
    EmojiSearchEditTextView.b localb = EmojiSearchEditTextView.b.heF;
    Log.i("MicroMsg.EmojiSearch", "setText: %s", new Object[] { paramSpannableString });
    this.heC = EmojiSearchEditTextView.b.heH;
    this.vy.setText(paramSpannableString);
    Selection.setSelection(this.vy.getText(), this.vy.getText().length());
    this.heC = localb;
    AppMethodBeat.o(199772);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(199773);
    EmojiSearchEditTextView.b localb = EmojiSearchEditTextView.b.heF;
    Log.i("MicroMsg.EmojiSearch", "setText: %s", new Object[] { paramString });
    this.heC = EmojiSearchEditTextView.b.heH;
    this.vy.setText(paramString);
    Selection.setSelection(this.vy.getText(), this.vy.getText().length());
    this.heC = localb;
    AppMethodBeat.o(199773);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, EmojiSearchEditTextView.b paramb);
    
    public abstract boolean awE();
    
    public abstract void eh(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView
 * JD-Core Version:    0.7.0.1
 */