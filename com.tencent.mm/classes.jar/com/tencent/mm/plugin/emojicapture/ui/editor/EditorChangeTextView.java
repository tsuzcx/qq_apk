package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.a.c;
import a.d.b.g;
import a.k;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.emojicapture.a.b;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.f.a;
import com.tencent.mm.plugin.emojicapture.f.a.a;

public final class EditorChangeTextView
  extends RelativeLayout
{
  private final String TAG = "EditorChangeTextView";
  EditText hvM;
  private View jpH;
  private View jpI;
  private ImageView jpJ;
  TextColorSelector jpK;
  int jpL;
  int jpM;
  private final Rect jpN = new Rect();
  private EditorChangeTextView.a jpO;
  boolean jpP;
  private final Runnable jpQ;
  
  public EditorChangeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditorChangeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, a.e.emoji_capture_editor_change_text, (ViewGroup)this);
    paramContext = findViewById(a.d.change_text_input);
    g.j(paramContext, "findViewById(R.id.change_text_input)");
    this.hvM = ((EditText)paramContext);
    paramContext = findViewById(a.d.change_text_cancel);
    g.j(paramContext, "findViewById(R.id.change_text_cancel)");
    this.jpH = paramContext;
    paramContext = findViewById(a.d.change_text_confirm);
    g.j(paramContext, "findViewById(R.id.change_text_confirm)");
    this.jpI = paramContext;
    paramContext = findViewById(a.d.text_color_selector);
    g.j(paramContext, "findViewById(R.id.text_color_selector)");
    this.jpK = ((TextColorSelector)paramContext);
    paramContext = findViewById(a.d.delete_text);
    g.j(paramContext, "findViewById(R.id.delete_text)");
    this.jpJ = ((ImageView)paramContext);
    this.hvM.setOnFocusChangeListener((View.OnFocusChangeListener)new EditorChangeTextView.1(this));
    this.hvM.addTextChangedListener((TextWatcher)new EditorChangeTextView.2(this));
    this.jpH.setOnClickListener((View.OnClickListener)new EditorChangeTextView.3(this));
    this.jpI.setOnClickListener((View.OnClickListener)new EditorChangeTextView.4(this));
    this.jpJ.setOnClickListener((View.OnClickListener)new EditorChangeTextView.5(this));
    this.jpK.setColorSelectCallback((c)new EditorChangeTextView.6(this));
    setOnClickListener((View.OnClickListener)new EditorChangeTextView.7(this));
    this.jpQ = ((Runnable)new EditorChangeTextView.b(this));
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      post(this.jpQ);
    }
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      removeCallbacks(this.jpQ);
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    } while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public final void cancel()
  {
    Object localObject = this.jpO;
    if (localObject != null) {
      ((EditorChangeTextView.a)localObject).onCancel();
    }
    this.hvM.clearFocus();
    if (this.jpP)
    {
      localObject = a.jnW;
      a.a.a(16, 0L, 0L, 0L);
    }
    localObject = a.jnW;
    a.a.a(14, 0L, 0L, 0L);
  }
  
  public final EditorChangeTextView.a getCallback()
  {
    return this.jpO;
  }
  
  public final boolean getTextChanged()
  {
    return this.jpP;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getWindowVisibleDisplayFrame(this.jpN);
    Object localObject = this.jpK.getLayoutParams();
    if (localObject == null) {
      throw new k("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    paramInt1 = this.jpN.bottom;
    Context localContext = getContext();
    g.j(localContext, "context");
    paramInt1 = paramInt4 - paramInt1 + localContext.getResources().getDimensionPixelSize(a.b.editor_color_selector_bottom_margin);
    if (((RelativeLayout.LayoutParams)localObject).bottomMargin != paramInt1)
    {
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt1;
      this.jpK.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.hvM.getLayoutParams();
      if (localObject == null) {
        throw new k("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = (paramInt1 + this.jpK.getHeight());
      this.hvM.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public final void setCallback(EditorChangeTextView.a parama)
  {
    this.jpO = parama;
  }
  
  public final void setTextChanged(boolean paramBoolean)
  {
    this.jpP = paramBoolean;
  }
  
  public final void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      this.hvM.requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView
 * JD-Core Version:    0.7.0.1
 */