package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class ad
  implements View.OnFocusChangeListener
{
  final MMHandler ntw;
  boolean rxu;
  public b rxv;
  final Runnable rxw;
  
  public ad(EditText paramEditText)
  {
    AppMethodBeat.i(136572);
    this.rxu = false;
    this.rxw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136567);
        if (ad.a(ad.this) != null) {
          ad.a(ad.this).PD();
        }
        AppMethodBeat.o(136567);
      }
    };
    this.rxu = paramEditText.isFocused();
    paramEditText.setOnFocusChangeListener(this);
    this.ntw = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(136572);
  }
  
  public final Editable c(Editable paramEditable)
  {
    AppMethodBeat.i(136573);
    paramEditable.setSpan(new SpanWatcher()
    {
      public final void onSpanAdded(Spannable paramAnonymousSpannable, Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136568);
        if (an.cU(paramAnonymousObject)) {
          Log.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", new Object[] { paramAnonymousSpannable, paramAnonymousObject.getClass().getSimpleName() });
        }
        AppMethodBeat.o(136568);
      }
      
      public final void onSpanChanged(Spannable paramAnonymousSpannable, Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(136570);
        if (an.cU(paramAnonymousObject)) {
          Log.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", new Object[] { paramAnonymousSpannable, paramAnonymousObject.getClass().getSimpleName() });
        }
        AppMethodBeat.o(136570);
      }
      
      public final void onSpanRemoved(Spannable paramAnonymousSpannable, Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136569);
        if (an.cU(paramAnonymousObject))
        {
          Log.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", new Object[] { paramAnonymousSpannable, paramAnonymousObject.getClass().getSimpleName() });
          ad.c(ad.this).removeCallbacks(ad.b(ad.this));
          ad.c(ad.this).postDelayed(ad.b(ad.this), 100L);
        }
        AppMethodBeat.o(136569);
      }
    }, 0, paramEditable.length(), 18);
    paramEditable.setSpan(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(136571);
        ad.c(ad.this).removeCallbacks(ad.b(ad.this));
        AppMethodBeat.o(136571);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    }, 0, paramEditable.length(), 18);
    AppMethodBeat.o(136573);
    return paramEditable;
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(136574);
    this.rxu = paramBoolean;
    if (!paramBoolean) {
      this.ntw.removeCallbacks(this.rxw);
    }
    AppMethodBeat.o(136574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ad
 * JD-Core Version:    0.7.0.1
 */