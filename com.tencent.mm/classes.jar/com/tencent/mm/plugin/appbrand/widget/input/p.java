package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;

public final class p
  extends c
{
  private p(WeakReference<EditText> paramWeakReference)
  {
    super(paramWeakReference);
  }
  
  public static p a(EditText paramEditText)
  {
    AppMethodBeat.i(136430);
    paramEditText = new p(new WeakReference(paramEditText));
    AppMethodBeat.o(136430);
    return paramEditText;
  }
  
  public final f a(int paramInt, f.a parama)
  {
    AppMethodBeat.i(136431);
    parama = new b(paramInt, parama);
    AppMethodBeat.o(136431);
    return parama;
  }
  
  final class b
    extends f
  {
    private final int otr;
    private final f.a ots;
    
    b(int paramInt, f.a parama)
    {
      super(parama);
      this.otr = paramInt;
      this.ots = parama;
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, final Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      int i = 0;
      AppMethodBeat.i(136429);
      if (a(paramSpanned.subSequence(0, paramInt3).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), this.ots) + a(paramCharSequence.subSequence(paramInt1, paramInt2).toString(), this.ots) > this.otr) {
        i = 1;
      }
      CharSequence localCharSequence = paramCharSequence;
      if (i != 0) {
        localCharSequence = paramCharSequence.subSequence(paramInt1, Math.max(paramInt1, Math.min(this.otr - (paramSpanned.length() - (paramInt4 - paramInt3)), paramInt2)));
      }
      final c.a locala;
      if ((i != 0) && (Util.isNullOrNil(localCharSequence)))
      {
        if (p.this.QxL != null) {
          break label225;
        }
        paramCharSequence = null;
        locala = p.this.QxP;
        if ((paramCharSequence != null) && (locala != null)) {
          if (paramCharSequence.getText() == null) {
            break label242;
          }
        }
      }
      label225:
      label242:
      for (paramSpanned = paramCharSequence.getText().toString();; paramSpanned = "")
      {
        paramCharSequence.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136428);
            locala.dv(paramSpanned);
            AppMethodBeat.o(136428);
          }
        });
        AppMethodBeat.o(136429);
        return localCharSequence;
        paramCharSequence = (EditText)p.this.QxL.get();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.p
 * JD-Core Version:    0.7.0.1
 */