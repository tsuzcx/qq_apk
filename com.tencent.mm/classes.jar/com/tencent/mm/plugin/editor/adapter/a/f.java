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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class f
  extends a
{
  private WXRTEditText pzu;
  
  public f(View paramView, com.tencent.mm.plugin.editor.model.nativenote.manager.j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181659);
    this.pzu = ((WXRTEditText)paramView.findViewById(2131304265));
    if (!this.pyp.pCz)
    {
      this.pzu.setKeyListener(null);
      this.pzu.setFocusable(false);
      this.pzu.setClickable(true);
    }
    this.pzu.pBP = this;
    this.pzu.setEditTextType(0);
    this.pyp.q(this.pzu);
    this.pzu.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(181656);
        com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
    this.pzu.setPosInDataList(paramInt1);
    parama = (com.tencent.mm.plugin.editor.model.a.j)parama;
    parama.pAo = this.pzu;
    parama.pAm = null;
    parama.pAn = null;
    Object localObject = c.cfy().BM(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.pzu.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.pzu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = c.cfy().BM(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.pzu.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.pzu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.pyp.pCz)
    {
      this.pzu.setRichTextEditing(parama.content);
      k.t(this.pzu);
    }
    for (;;)
    {
      ae.i("MicroMsg.Note.EditorTextItemHolder", "TextItemHolder position is " + lM());
      AppMethodBeat.o(181660);
      return;
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181658);
          f.a(f.this).setRichTextEditing(parama.content);
          f.a(f.this).cfR();
          f.a(f.this).cfT();
          k.t(f.a(f.this));
          f.a(f.this).cfU();
          f.a(f.this).cfS();
          if (parama.pAj) {
            if ((parama.pAl != -1) && (parama.pAl < f.a(f.this).getText().toString().length()))
            {
              f.a(f.this).setSelection(parama.pAl);
              f.a(f.this).requestFocus();
              ar.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181657);
                  if (f.2.this.pzx.pAs != 0)
                  {
                    int i = f.a(f.this).getSelection().avj;
                    if (i == f.2.this.pzx.content.length())
                    {
                      f.a(f.this).cfR();
                      f.a(f.this).getText().append("\n");
                      f.a(f.this).cfS();
                      f.a(f.this).setSelection(i);
                    }
                    f.2.this.pzx.pAs = 0;
                    if (f.2.this.pzx.pAt == 1)
                    {
                      f.a(f.this).a(u.pEs, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.pzx.pAt == 3)
                    {
                      f.a(f.this).a(u.pEr, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.pzx.pAt == 2) {
                      f.a(f.this).a(u.pEt, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(181657);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (parama.pAr)
            {
              parama.pAr = false;
              f.a(f.this).pAr = true;
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
  
  public final int cfi()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.f
 * JD-Core Version:    0.7.0.1
 */