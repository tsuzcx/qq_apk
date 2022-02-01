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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class EmojiSearchEditTextView
  extends LinearLayout
{
  EditText dzv;
  String hint;
  private WeImageView mpe;
  ImageButton mpf;
  private View mpg;
  private String mph;
  private a mpi;
  EmojiSearchEditTextView.b mpj;
  protected View.OnFocusChangeListener mpk;
  
  public EmojiSearchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(231475);
    this.mph = "";
    this.mpj = EmojiSearchEditTextView.b.mpm;
    this.mpk = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(231449);
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).fq(paramAnonymousBoolean);
        }
        AppMethodBeat.o(231449);
      }
    };
    init();
    AppMethodBeat.o(231475);
  }
  
  public EmojiSearchEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(231482);
    this.mph = "";
    this.mpj = EmojiSearchEditTextView.b.mpm;
    this.mpk = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(231449);
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).fq(paramAnonymousBoolean);
        }
        AppMethodBeat.o(231449);
      }
    };
    init();
    AppMethodBeat.o(231482);
  }
  
  private void aWR()
  {
    AppMethodBeat.i(231486);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    AppMethodBeat.o(231486);
  }
  
  private void init()
  {
    AppMethodBeat.i(231493);
    aWR();
    this.mpg = findViewById(a.g.tag_panel);
    this.mpe = ((WeImageView)findViewById(a.g.icon));
    this.dzv = ((EditText)findViewById(a.g.edittext));
    this.mpf = ((ImageButton)findViewById(a.g.clear_btn));
    this.dzv.setOnKeyListener(new EmojiSearchEditTextView.1(this));
    this.dzv.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(231451);
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
          AppMethodBeat.o(231451);
          return;
          label78:
          EmojiSearchEditTextView.b(EmojiSearchEditTextView.this).setVisibility(8);
        }
      }
    });
    this.dzv.setOnFocusChangeListener(this.mpk);
    this.dzv.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(231456);
        if ((3 == paramAnonymousInt) && (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null))
        {
          boolean bool = EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).aWU();
          AppMethodBeat.o(231456);
          return bool;
        }
        AppMethodBeat.o(231456);
        return false;
      }
    });
    this.mpf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231454);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = EmojiSearchEditTextView.this;
        ((EmojiSearchEditTextView)localObject).mpj = EmojiSearchEditTextView.b.mpn;
        ((EmojiSearchEditTextView)localObject).dzv.setText("");
        ((EmojiSearchEditTextView)localObject).dzv.setHint(((EmojiSearchEditTextView)localObject).hint);
        ((EmojiSearchEditTextView)localObject).mpf.setVisibility(8);
        ((EmojiSearchEditTextView)localObject).mpj = EmojiSearchEditTextView.b.mpm;
        if (EmojiSearchEditTextView.d(EmojiSearchEditTextView.this) != null) {
          EmojiSearchEditTextView.d(EmojiSearchEditTextView.this).onClickClearTextBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231454);
      }
    });
    c.i(this.dzv).aEg(100).a(null);
    if (aw.isDarkMode()) {
      this.mpf.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(231493);
  }
  
  public final void aWS()
  {
    AppMethodBeat.i(231518);
    postDelayed(new EmojiSearchEditTextView.5(this), 128L);
    AppMethodBeat.o(231518);
  }
  
  public final void aWT()
  {
    AppMethodBeat.i(231532);
    this.dzv.requestFocus();
    AppMethodBeat.o(231532);
  }
  
  public ImageButton getClearBtn()
  {
    return this.mpf;
  }
  
  public EditText getEditText()
  {
    return this.dzv;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(231521);
    int i = this.dzv.getHighlightColor();
    AppMethodBeat.o(231521);
    return i;
  }
  
  public WeImageView getIconView()
  {
    return this.mpe;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(231564);
    String str = this.dzv.getText().toString().trim();
    AppMethodBeat.o(231564);
    return str;
  }
  
  protected int getLayoutById()
  {
    return a.h.emoji_search_search_edittext_view;
  }
  
  public View getTagPanel()
  {
    return this.mpg;
  }
  
  public EmojiSearchEditTextView.b getTextChangeStatus()
  {
    return this.mpj;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(231567);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dzv.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(231567);
    return localObject;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(231514);
    if (paramInt == -1)
    {
      this.dzv.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(231514);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 15), com.tencent.mm.cd.a.fromDPToPix(getContext(), 15));
    this.dzv.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(231514);
  }
  
  public void setEmojiSearchEditTextListener(a parama)
  {
    this.mpi = parama;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(231534);
    this.dzv.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(231534);
  }
  
  public void setText(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(231525);
    EmojiSearchEditTextView.b localb = EmojiSearchEditTextView.b.mpm;
    Log.i("MicroMsg.EmojiSearch", "setText: %s", new Object[] { paramSpannableString });
    this.mpj = EmojiSearchEditTextView.b.mpo;
    this.dzv.setText(paramSpannableString);
    Selection.setSelection(this.dzv.getText(), this.dzv.getText().length());
    this.mpj = localb;
    AppMethodBeat.o(231525);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(231527);
    EmojiSearchEditTextView.b localb = EmojiSearchEditTextView.b.mpm;
    Log.i("MicroMsg.EmojiSearch", "setText: %s", new Object[] { paramString });
    this.mpj = EmojiSearchEditTextView.b.mpo;
    this.dzv.setText(paramString);
    Selection.setSelection(this.dzv.getText(), this.dzv.getText().length());
    this.mpj = localb;
    AppMethodBeat.o(231527);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, EmojiSearchEditTextView.b paramb);
    
    public abstract boolean aWU();
    
    public abstract void fq(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView
 * JD-Core Version:    0.7.0.1
 */