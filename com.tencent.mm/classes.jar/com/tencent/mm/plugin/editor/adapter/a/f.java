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
  private WXRTEditText psO;
  
  public f(View paramView, com.tencent.mm.plugin.editor.model.nativenote.manager.j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181659);
    this.psO = ((WXRTEditText)paramView.findViewById(2131304265));
    if (!this.prJ.pvV)
    {
      this.psO.setKeyListener(null);
      this.psO.setFocusable(false);
      this.psO.setClickable(true);
    }
    this.psO.pvl = this;
    this.psO.setEditTextType(0);
    this.prJ.q(this.psO);
    this.psO.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(181656);
        com.tencent.mm.kernel.g.ajF().ay(new Runnable()
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
    this.psO.setPosInDataList(paramInt1);
    parama = (com.tencent.mm.plugin.editor.model.a.j)parama;
    parama.ptK = this.psO;
    parama.ptI = null;
    parama.ptJ = null;
    Object localObject = c.cej().BA(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.psO.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.psO.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = c.cej().BA(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.psO.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.psO.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.prJ.pvV)
    {
      this.psO.setRichTextEditing(parama.content);
      k.v(this.psO);
    }
    for (;;)
    {
      ad.i("MicroMsg.Note.EditorTextItemHolder", "TextItemHolder position is " + lM());
      AppMethodBeat.o(181660);
      return;
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181658);
          f.a(f.this).setRichTextEditing(parama.content);
          f.a(f.this).ceC();
          f.a(f.this).ceE();
          k.v(f.a(f.this));
          f.a(f.this).ceF();
          f.a(f.this).ceD();
          if (parama.ptF) {
            if ((parama.ptH != -1) && (parama.ptH < f.a(f.this).getText().toString().length()))
            {
              f.a(f.this).setSelection(parama.ptH);
              f.a(f.this).requestFocus();
              aq.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181657);
                  if (f.2.this.psR.ptO != 0)
                  {
                    int i = f.a(f.this).getSelection().avj;
                    if (i == f.2.this.psR.content.length())
                    {
                      f.a(f.this).ceC();
                      f.a(f.this).getText().append("\n");
                      f.a(f.this).ceD();
                      f.a(f.this).setSelection(i);
                    }
                    f.2.this.psR.ptO = 0;
                    if (f.2.this.psR.ptP == 1)
                    {
                      f.a(f.this).a(u.pxO, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.psR.ptP == 3)
                    {
                      f.a(f.this).a(u.pxN, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.psR.ptP == 2) {
                      f.a(f.this).a(u.pxP, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(181657);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (parama.ptN)
            {
              parama.ptN = false;
              f.a(f.this).ptN = true;
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
  
  public final int cdT()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.f
 * JD-Core Version:    0.7.0.1
 */