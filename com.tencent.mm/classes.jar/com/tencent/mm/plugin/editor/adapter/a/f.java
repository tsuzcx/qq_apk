package com.tencent.mm.plugin.editor.adapter.a;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.c;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class f
  extends a
{
  private WXRTEditText uqP;
  
  public f(View paramView, com.tencent.mm.plugin.editor.model.nativenote.manager.j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181659);
    this.uqP = ((WXRTEditText)paramView.findViewById(d.e.dTc));
    if (!this.uoT.utX)
    {
      this.uqP.setKeyListener(null);
      this.uqP.setFocusable(false);
      this.uqP.setClickable(true);
    }
    this.uqP.utn = this;
    this.uqP.setEditTextType(0);
    this.uoT.q(this.uqP);
    this.uqP.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(181656);
        h.aHJ().postToWorker(new Runnable()
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
    this.uqP.setPosInDataList(paramInt1);
    parama = (com.tencent.mm.plugin.editor.model.a.j)parama;
    parama.urL = this.uqP;
    parama.urJ = null;
    parama.urK = null;
    Object localObject = c.cRT().Jd(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.uqP.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.uqP.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = c.cRT().Jd(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.uqP.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.uqP.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.uoT.utX)
    {
      this.uqP.setRichTextEditing(parama.content);
      l.I(this.uqP);
    }
    for (;;)
    {
      Log.i("MicroMsg.Note.EditorTextItemHolder", "TextItemHolder position is " + mc());
      AppMethodBeat.o(181660);
      return;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181658);
          f.a(f.this).setRichTextEditing(parama.content);
          f.a(f.this).cSm();
          f.a(f.this).cSo();
          l.I(f.a(f.this));
          f.a(f.this).cSp();
          f.a(f.this).cSn();
          if (parama.urG) {
            if ((parama.urI != -1) && (parama.urI < f.a(f.this).getText().toString().length()))
            {
              f.a(f.this).setSelection(parama.urI);
              f.a(f.this).requestFocus();
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181657);
                  if (f.2.this.uqS.urP != 0)
                  {
                    int i = f.a(f.this).getSelection().tH;
                    if (i == f.2.this.uqS.content.length())
                    {
                      f.a(f.this).cSm();
                      f.a(f.this).getText().append("\n");
                      f.a(f.this).cSn();
                      f.a(f.this).setSelection(i);
                    }
                    f.2.this.uqS.urP = 0;
                    if (f.2.this.uqS.urQ == 1)
                    {
                      f.a(f.this).a(u.uvP, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.uqS.urQ == 3)
                    {
                      f.a(f.this).a(u.uvO, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.uqS.urQ == 2) {
                      f.a(f.this).a(u.uvQ, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(181657);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (parama.urO)
            {
              parama.urO = false;
              f.a(f.this).urO = true;
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
  
  public final int cRD()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.f
 * JD-Core Version:    0.7.0.1
 */