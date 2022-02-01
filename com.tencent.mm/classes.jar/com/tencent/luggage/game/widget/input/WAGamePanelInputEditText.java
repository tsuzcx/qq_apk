package com.tencent.luggage.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.luggage.wxa.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText
  extends EditText
{
  private final InputFilter cwA;
  private int cwB;
  private final Spannable.Factory cwC;
  private final ad cwz;
  
  public WAGamePanelInputEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.editTextStyle);
  }
  
  public WAGamePanelInputEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(130724);
    this.cwA = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(130722);
        if (TextUtils.isEmpty(paramAnonymousCharSequence))
        {
          AppMethodBeat.o(130722);
          return null;
        }
        paramAnonymousCharSequence = paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt2);
        if ((paramAnonymousCharSequence instanceof Spannable)) {}
        for (paramAnonymousCharSequence = (Spannable)paramAnonymousCharSequence;; paramAnonymousCharSequence = new SpannableStringBuilder(paramAnonymousCharSequence))
        {
          paramAnonymousCharSequence = WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, paramAnonymousCharSequence);
          AppMethodBeat.o(130722);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.cwB = 2147483647;
    this.cwC = new Spannable.Factory()
    {
      public final Spannable newSpannable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(130723);
        paramAnonymousCharSequence = new SpannableStringBuilder(paramAnonymousCharSequence);
        AppMethodBeat.o(130723);
        return paramAnonymousCharSequence;
      }
    };
    this.cwz = new ad(this);
    super.setEditableFactory(new Editable.Factory()
    {
      public final Editable newEditable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(130721);
        paramAnonymousCharSequence = WAGamePanelInputEditText.a(WAGamePanelInputEditText.this).c((Editable)WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, super.newEditable(paramAnonymousCharSequence)));
        AppMethodBeat.o(130721);
        return paramAnonymousCharSequence;
      }
    });
    super.setFilters(new InputFilter[] { this.cwA });
    AppMethodBeat.o(130724);
  }
  
  public int getMaxLength()
  {
    return this.cwB;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(130726);
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    paramEditorInfo.imeOptions |= 0x10000000;
    AppMethodBeat.o(130726);
    return localInputConnection;
  }
  
  public void setComposingDismissedListener(b paramb)
  {
    this.cwz.rxv = paramb;
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    AppMethodBeat.i(130725);
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (this.cwA != null)
    {
      arrayOfInputFilter = paramArrayOfInputFilter;
      if (paramArrayOfInputFilter == null) {
        arrayOfInputFilter = new InputFilter[0];
      }
      paramArrayOfInputFilter = new InputFilter[arrayOfInputFilter.length + 1];
      while (i < arrayOfInputFilter.length)
      {
        paramArrayOfInputFilter[i] = arrayOfInputFilter[i];
        i += 1;
      }
      paramArrayOfInputFilter[i] = this.cwA;
      arrayOfInputFilter = paramArrayOfInputFilter;
    }
    super.setFilters(arrayOfInputFilter);
    AppMethodBeat.o(130725);
  }
  
  public void setMaxLength(int paramInt)
  {
    this.cwB = paramInt;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(246886);
    int i = getMaxHeight();
    super.setSingleLine(paramBoolean);
    if (i > 0) {
      setMaxHeight(i);
    }
    AppMethodBeat.o(246886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.WAGamePanelInputEditText
 * JD-Core Version:    0.7.0.1
 */