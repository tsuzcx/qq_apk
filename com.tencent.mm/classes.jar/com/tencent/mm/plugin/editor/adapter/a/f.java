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
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class f
  extends a
{
  private WXRTEditText xxm;
  
  public f(View paramView, com.tencent.mm.plugin.editor.model.nativenote.manager.j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181659);
    this.xxm = ((WXRTEditText)paramView.findViewById(d.e.fVi));
    if (!this.xvq.xAu)
    {
      this.xxm.setKeyListener(null);
      this.xxm.setFocusable(false);
      this.xxm.setClickable(true);
    }
    this.xxm.xzK = this;
    this.xxm.setEditTextType(0);
    this.xvq.q(this.xxm);
    this.xxm.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(181656);
        h.baH().postToWorker(new Runnable()
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
    this.xxm.setPosInDataList(paramInt1);
    parama = (com.tencent.mm.plugin.editor.model.a.j)parama;
    parama.xyg = this.xxm;
    parama.xye = null;
    parama.xyf = null;
    Object localObject = c.dwm().JL(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.xxm.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.xxm.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = c.dwm().JL(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.xxm.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.xxm.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.xvq.xAu)
    {
      this.xxm.setRichTextEditing(parama.content);
      p.L(this.xxm);
    }
    for (;;)
    {
      Log.i("MicroMsg.Note.EditorTextItemHolder", "TextItemHolder position is " + KI());
      AppMethodBeat.o(181660);
      return;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181658);
          f.a(f.this).setRichTextEditing(parama.content);
          f.a(f.this).dwE();
          f.a(f.this).dwG();
          p.L(f.a(f.this));
          f.a(f.this).dwH();
          f.a(f.this).dwF();
          if (parama.xyb) {
            if ((parama.xyd != -1) && (parama.xyd < f.a(f.this).getText().toString().length()))
            {
              f.a(f.this).setSelection(parama.xyd);
              f.a(f.this).requestFocus();
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181657);
                  if (f.2.this.xxp.xyk != 0)
                  {
                    int i = f.a(f.this).getSelection().uG;
                    if (i == f.2.this.xxp.content.length())
                    {
                      f.a(f.this).dwE();
                      f.a(f.this).getText().append("\n");
                      f.a(f.this).dwF();
                      f.a(f.this).setSelection(i);
                    }
                    f.2.this.xxp.xyk = 0;
                    if (f.2.this.xxp.xyl == 1)
                    {
                      f.a(f.this).a(u.xCo, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.xxp.xyl == 3)
                    {
                      f.a(f.this).a(u.xCn, Boolean.TRUE);
                      AppMethodBeat.o(181657);
                      return;
                    }
                    if (f.2.this.xxp.xyl == 2) {
                      f.a(f.this).a(u.xCp, Boolean.TRUE);
                    }
                  }
                  AppMethodBeat.o(181657);
                }
              }, 500L);
            }
          }
          for (;;)
          {
            if (parama.xyj)
            {
              parama.xyj = false;
              f.a(f.this).xyj = true;
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
  
  public final int dvW()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.f
 * JD-Core Version:    0.7.0.1
 */