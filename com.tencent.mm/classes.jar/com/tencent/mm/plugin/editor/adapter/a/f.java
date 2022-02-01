package com.tencent.mm.plugin.editor.adapter.a;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.c;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public final class f
  extends a
{
  private WXRTEditText oPg;
  
  public f(View paramView, com.tencent.mm.plugin.editor.model.nativenote.manager.j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181659);
    this.oPg = ((WXRTEditText)paramView.findViewById(2131304265));
    if (!this.oOb.oSl)
    {
      this.oPg.setKeyListener(null);
      this.oPg.setFocusable(false);
      this.oPg.setClickable(true);
    }
    this.oPg.oRB = this;
    this.oPg.setEditTextType(0);
    this.oOb.q(this.oPg);
    this.oPg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(181656);
        com.tencent.mm.kernel.g.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181655);
            f.a(f.this).hasFocus();
            AppMethodBeat.o(181655);
          }
        });
        AppMethodBeat.o(181656);
      }
    });
    AppMethodBeat.o(181659);
  }
  
  public final void a(final com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181660);
    this.oPg.setPosInDataList(paramInt1);
    parama = (com.tencent.mm.plugin.editor.model.a.j)parama;
    parama.oQa = this.oPg;
    parama.oPY = null;
    parama.oPZ = null;
    Object localObject = c.bZF().AS(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.oPg.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.oPg.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = c.bZF().AS(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.oPg.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.oPg.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.oOb.oSl)
    {
      this.oPg.setRichTextEditing(parama.content);
      k.v(this.oPg);
    }
    for (;;)
    {
      ac.i("MicroMsg.Note.EditorTextItemHolder", "TextItemHolder position is " + lu());
      AppMethodBeat.o(181660);
      return;
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181658);
          f.a(f.this).setRichTextEditing(parama.content);
          f.a(f.this).bZY();
          f.a(f.this).caa();
          k.v(f.a(f.this));
          f.a(f.this).cab();
          f.a(f.this).bZZ();
          if (parama.oPV) {
            if ((parama.oPX != -1) && (parama.oPX < f.a(f.this).getText().toString().length()))
            {
              f.a(f.this).setSelection(parama.oPX);
              f.a(f.this).requestFocus();
              ap.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181657);
                  if (f.2.this.oPj.oQe != 0)
                  {
                    int i = f.a(f.this).getSelection().atr;
                    if (i == f.2.this.oPj.content.length())
                    {
                      f.a(f.this).bZY();
                      f.a(f.this).getText().append("\n");
                      f.a(f.this).bZZ();
                      f.a(f.this).setSelection(i);
                    }
                    f.2.this.oPj.oQe = 0;
                    if (f.2.this.oPj.oQf == 1)
                    {
                      f.a(f.this).a(u.oUe, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.oPj.oQf == 3)
                    {
                      f.a(f.this).a(u.oUd, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.oPj.oQf == 2) {
                      f.a(f.this).a(u.oUf, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(181657);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (parama.oQd)
            {
              parama.oQd = false;
              f.a(f.this).oQd = true;
              f.a(f.this).onTextContextMenuItem(16908322);
            }
            AppMethodBeat.o(181658);
            return;
            f.a(f.this).setSelection(f.a(f.this).getText().toString().length());
            break;
            if (f.a(f.this).hasFocus()) {
              f.a(f.this).clearFocus();
            }
          }
        }
      });
    }
  }
  
  public final int bZp()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.f
 * JD-Core Version:    0.7.0.1
 */