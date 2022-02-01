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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class f
  extends a
{
  private WXRTEditText qOL;
  
  public f(View paramView, com.tencent.mm.plugin.editor.model.nativenote.manager.j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181659);
    this.qOL = ((WXRTEditText)paramView.findViewById(2131307188));
    if (!this.qNG.qRR)
    {
      this.qOL.setKeyListener(null);
      this.qOL.setFocusable(false);
      this.qOL.setClickable(true);
    }
    this.qOL.qRh = this;
    this.qOL.setEditTextType(0);
    this.qNG.q(this.qOL);
    this.qOL.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(181656);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
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
    this.qOL.setPosInDataList(paramInt1);
    parama = (com.tencent.mm.plugin.editor.model.a.j)parama;
    parama.qPF = this.qOL;
    parama.qPD = null;
    parama.qPE = null;
    Object localObject = c.cDo().Fw(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.qOL.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.qOL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = c.cDo().Fw(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.qOL.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.qOL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.qNG.qRR)
    {
      this.qOL.setRichTextEditing(parama.content);
      l.B(this.qOL);
    }
    for (;;)
    {
      Log.i("MicroMsg.Note.EditorTextItemHolder", "TextItemHolder position is " + lQ());
      AppMethodBeat.o(181660);
      return;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181658);
          f.a(f.this).setRichTextEditing(parama.content);
          f.a(f.this).cDH();
          f.a(f.this).cDJ();
          l.B(f.a(f.this));
          f.a(f.this).cDK();
          f.a(f.this).cDI();
          if (parama.qPA) {
            if ((parama.qPC != -1) && (parama.qPC < f.a(f.this).getText().toString().length()))
            {
              f.a(f.this).setSelection(parama.qPC);
              f.a(f.this).requestFocus();
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181657);
                  if (f.2.this.qOO.qPJ != 0)
                  {
                    int i = f.a(f.this).getSelection().avh;
                    if (i == f.2.this.qOO.content.length())
                    {
                      f.a(f.this).cDH();
                      f.a(f.this).getText().append("\n");
                      f.a(f.this).cDI();
                      f.a(f.this).setSelection(i);
                    }
                    f.2.this.qOO.qPJ = 0;
                    if (f.2.this.qOO.qPK == 1)
                    {
                      f.a(f.this).a(u.qTJ, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.qOO.qPK == 3)
                    {
                      f.a(f.this).a(u.qTI, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.qOO.qPK == 2) {
                      f.a(f.this).a(u.qTK, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(181657);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (parama.qPI)
            {
              parama.qPI = false;
              f.a(f.this).qPI = true;
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
  
  public final int cCY()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.f
 * JD-Core Version:    0.7.0.1
 */