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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class f
  extends a
{
  private WXRTEditText olG;
  
  public f(View paramView, com.tencent.mm.plugin.editor.model.nativenote.manager.j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181659);
    this.olG = ((WXRTEditText)paramView.findViewById(2131304265));
    if (!this.okB.ooL)
    {
      this.olG.setKeyListener(null);
      this.olG.setFocusable(false);
      this.olG.setClickable(true);
    }
    this.olG.oob = this;
    this.olG.setEditTextType(0);
    this.okB.q(this.olG);
    this.olG.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(181656);
        com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
    this.olG.setPosInDataList(paramInt1);
    parama = (com.tencent.mm.plugin.editor.model.a.j)parama;
    parama.omA = this.olG;
    parama.omy = null;
    parama.omz = null;
    Object localObject = c.bSq().Aa(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.olG.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.olG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = c.bSq().Aa(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.olG.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.olG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.okB.ooL)
    {
      this.olG.setRichTextEditing(parama.content);
      k.v(this.olG);
    }
    for (;;)
    {
      ad.i("MicroMsg.Note.EditorTextItemHolder", "TextItemHolder position is " + lm());
      AppMethodBeat.o(181660);
      return;
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181658);
          f.a(f.this).setRichTextEditing(parama.content);
          f.a(f.this).bSJ();
          f.a(f.this).bSL();
          k.v(f.a(f.this));
          f.a(f.this).bSM();
          f.a(f.this).bSK();
          if (parama.omv) {
            if ((parama.omx != -1) && (parama.omx < f.a(f.this).getText().toString().length()))
            {
              f.a(f.this).setSelection(parama.omx);
              f.a(f.this).requestFocus();
              aq.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181657);
                  if (f.2.this.olJ.omE != 0)
                  {
                    int i = f.a(f.this).getSelection().asw;
                    if (i == f.2.this.olJ.content.length())
                    {
                      f.a(f.this).bSJ();
                      f.a(f.this).getText().append("\n");
                      f.a(f.this).bSK();
                      f.a(f.this).setSelection(i);
                    }
                    f.2.this.olJ.omE = 0;
                    if (f.2.this.olJ.omF == 1)
                    {
                      f.a(f.this).a(u.oqE, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.olJ.omF == 3)
                    {
                      f.a(f.this).a(u.oqD, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.olJ.omF == 2) {
                      f.a(f.this).a(u.oqF, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(181657);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (parama.omD)
            {
              parama.omD = false;
              f.a(f.this).omD = true;
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
  
  public final int bSa()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.f
 * JD-Core Version:    0.7.0.1
 */