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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.plugin.appbrand.widget.input.z;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText
  extends EditText
{
  private final z cmb;
  private final InputFilter cmc;
  private int cmd;
  private final Spannable.Factory cme;
  
  public WAGamePanelInputEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968945);
  }
  
  public WAGamePanelInputEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(130724);
    this.cmc = new InputFilter()
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
          paramAnonymousSpanned = WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, paramAnonymousCharSequence);
          if (paramAnonymousSpanned != paramAnonymousCharSequence) {
            break;
          }
          AppMethodBeat.o(130722);
          return null;
        }
        AppMethodBeat.o(130722);
        return paramAnonymousSpanned;
      }
    };
    this.cmd = 2147483647;
    this.cme = new Spannable.Factory()
    {
      public final Spannable newSpannable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(130723);
        paramAnonymousCharSequence = new SpannableStringBuilder(paramAnonymousCharSequence);
        AppMethodBeat.o(130723);
        return paramAnonymousCharSequence;
      }
    };
    this.cmb = new z(this);
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
    AppMethodBeat.o(130724);
  }
  
  public int getMaxLength()
  {
    return this.cmd;
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
    this.cmb.nlm = paramb;
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    AppMethodBeat.i(130725);
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (this.cmc != null)
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
      paramArrayOfInputFilter[i] = this.cmc;
      arrayOfInputFilter = paramArrayOfInputFilter;
    }
    super.setFilters(arrayOfInputFilter);
    AppMethodBeat.o(130725);
  }
  
  public void setMaxLength(int paramInt)
  {
    this.cmd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.WAGamePanelInputEditText
 * JD-Core Version:    0.7.0.1
 */