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
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class EmojiSearchEditTextView
  extends LinearLayout
{
  EditText bGw;
  String hint;
  private WeImageView jQn;
  ImageButton jQo;
  private View jQp;
  private String jQq;
  private a jQr;
  EmojiSearchEditTextView.b jQs;
  protected View.OnFocusChangeListener jQt;
  
  public EmojiSearchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(225294);
    this.jQq = "";
    this.jQs = EmojiSearchEditTextView.b.jQv;
    this.jQt = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(230755);
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).eF(paramAnonymousBoolean);
        }
        AppMethodBeat.o(230755);
      }
    };
    init();
    AppMethodBeat.o(225294);
  }
  
  public EmojiSearchEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(225296);
    this.jQq = "";
    this.jQs = EmojiSearchEditTextView.b.jQv;
    this.jQt = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(230755);
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).eF(paramAnonymousBoolean);
        }
        AppMethodBeat.o(230755);
      }
    };
    init();
    AppMethodBeat.o(225296);
  }
  
  private void aDS()
  {
    AppMethodBeat.i(225297);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    AppMethodBeat.o(225297);
  }
  
  private void init()
  {
    AppMethodBeat.i(225303);
    aDS();
    this.jQp = findViewById(a.g.tag_panel);
    this.jQn = ((WeImageView)findViewById(a.g.icon));
    this.bGw = ((EditText)findViewById(a.g.edittext));
    this.jQo = ((ImageButton)findViewById(a.g.clear_btn));
    this.bGw.setOnKeyListener(new EmojiSearchEditTextView.1(this));
    this.bGw.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(228339);
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
          AppMethodBeat.o(228339);
          return;
          label78:
          EmojiSearchEditTextView.b(EmojiSearchEditTextView.this).setVisibility(8);
        }
      }
    });
    this.bGw.setOnFocusChangeListener(this.jQt);
    this.bGw.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(235182);
        if ((3 == paramAnonymousInt) && (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null))
        {
          boolean bool = EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).aDV();
          AppMethodBeat.o(235182);
          return bool;
        }
        AppMethodBeat.o(235182);
        return false;
      }
    });
    this.jQo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(240766);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        localObject = EmojiSearchEditTextView.this;
        ((EmojiSearchEditTextView)localObject).jQs = EmojiSearchEditTextView.b.jQw;
        ((EmojiSearchEditTextView)localObject).bGw.setText("");
        ((EmojiSearchEditTextView)localObject).bGw.setHint(((EmojiSearchEditTextView)localObject).hint);
        ((EmojiSearchEditTextView)localObject).jQo.setVisibility(8);
        ((EmojiSearchEditTextView)localObject).jQs = EmojiSearchEditTextView.b.jQv;
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).onClickClearTextBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240766);
      }
    });
    c.i(this.bGw).axx(100).a(null);
    if (ar.isDarkMode()) {
      this.jQo.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(225303);
  }
  
  public final void aDT()
  {
    AppMethodBeat.i(225311);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237235);
        ((InputMethodManager)EmojiSearchEditTextView.this.getContext().getSystemService("input_method")).showSoftInput(EmojiSearchEditTextView.e(EmojiSearchEditTextView.this), 1);
        AppMethodBeat.o(237235);
      }
    }, 128L);
    AppMethodBeat.o(225311);
  }
  
  public final void aDU()
  {
    AppMethodBeat.i(225325);
    this.bGw.requestFocus();
    AppMethodBeat.o(225325);
  }
  
  public ImageButton getClearBtn()
  {
    return this.jQo;
  }
  
  public EditText getEditText()
  {
    return this.bGw;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(225313);
    int i = this.bGw.getHighlightColor();
    AppMethodBeat.o(225313);
    return i;
  }
  
  public WeImageView getIconView()
  {
    return this.jQn;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(225331);
    String str = this.bGw.getText().toString().trim();
    AppMethodBeat.o(225331);
    return str;
  }
  
  protected int getLayoutById()
  {
    return a.h.emoji_search_search_edittext_view;
  }
  
  public View getTagPanel()
  {
    return this.jQp;
  }
  
  public EmojiSearchEditTextView.b getTextChangeStatus()
  {
    return this.jQs;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(225332);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.bGw.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(225332);
    return localObject;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(225310);
    if (paramInt == -1)
    {
      this.bGw.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(225310);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 15), com.tencent.mm.ci.a.fromDPToPix(getContext(), 15));
    this.bGw.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(225310);
  }
  
  public void setEmojiSearchEditTextListener(a parama)
  {
    this.jQr = parama;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(225327);
    this.bGw.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(225327);
  }
  
  public void setText(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(225319);
    EmojiSearchEditTextView.b localb = EmojiSearchEditTextView.b.jQv;
    Log.i("MicroMsg.EmojiSearch", "setText: %s", new Object[] { paramSpannableString });
    this.jQs = EmojiSearchEditTextView.b.jQx;
    this.bGw.setText(paramSpannableString);
    Selection.setSelection(this.bGw.getText(), this.bGw.getText().length());
    this.jQs = localb;
    AppMethodBeat.o(225319);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(225323);
    EmojiSearchEditTextView.b localb = EmojiSearchEditTextView.b.jQv;
    Log.i("MicroMsg.EmojiSearch", "setText: %s", new Object[] { paramString });
    this.jQs = EmojiSearchEditTextView.b.jQx;
    this.bGw.setText(paramString);
    Selection.setSelection(this.bGw.getText(), this.bGw.getText().length());
    this.jQs = localb;
    AppMethodBeat.o(225323);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, EmojiSearchEditTextView.b paramb);
    
    public abstract boolean aDV();
    
    public abstract void eF(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView
 * JD-Core Version:    0.7.0.1
 */