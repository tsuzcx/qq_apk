package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.spans.r;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  implements com.tencent.mm.plugin.editor.model.nativenote.b.c
{
  private static DisplayMetrics euS;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static j xAp = null;
  public static int xAq = -1;
  private static int xAs = -1;
  public int mActionBarHeight;
  public int mStatusBarHeight;
  private transient ArrayList<WXRTEditText> xAn;
  public com.tencent.mm.plugin.editor.model.nativenote.a xAo;
  private int xAr;
  public com.tencent.mm.plugin.editor.model.nativenote.b.b xAt;
  public boolean xAu;
  private View.OnKeyListener xAv;
  
  public j(com.tencent.mm.plugin.editor.model.nativenote.a parama)
  {
    AppMethodBeat.i(181831);
    this.xAt = null;
    this.xAu = false;
    this.xAv = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(181830);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.dwm().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          localObject = j.this.dwL();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          Log.i("MicroMsg.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.dwm().JL(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            Log.w("MicroMsg.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousKeyEvent = c.dwm().JL(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            Log.i("MicroMsg.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((((WXRTEditText)localObject).getEditTextType() == 0) && (!j.a(j.this, (WXRTEditText)localObject, paramAnonymousInt)))
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(181830);
              return false;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          switch (((WXRTEditText)localObject).getEditTextType())
          {
          default: 
          case 0: 
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(181830);
              return true;
              Log.i("MicroMsg.WXRTManager", "Handle Editor Type EDITTEXT");
              if (!j.a(j.this, (WXRTEditText)localObject, paramAnonymousInt))
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(181830);
                return false;
              }
              paramAnonymousView = ((WXRTEditText)localObject).a(h.xAj);
              c.dwm().dwp();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.dwm().av(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
              int i = paramAnonymousKeyEvent.xyg.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.xyd = i;
              paramAnonymousKeyEvent.xyb = true;
              paramAnonymousKeyEvent.xyh = false;
              label482:
              if (!bool) {
                break label548;
              }
              j.a(j.this).dvI().JG(paramAnonymousInt - 1);
            }
            if (!Util.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.dwm().av(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.xyf.setSelection(0);
          paramAnonymousKeyEvent.xyb = true;
          paramAnonymousKeyEvent.xyh = false;
          break label482;
          label548:
          j.a(j.this).dvI().gI(paramAnonymousInt - 1, 2);
          break;
          Log.i("MicroMsg.WXRTManager", "Handle Editor Type PREBUTTON");
          c.dwm().dwp();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
            if (Util.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.xye.setSelection(0);
              paramAnonymousView.xyb = true;
              paramAnonymousView.xyh = true;
              c.dwm().av(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(181830);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.xyd = -1;
            paramAnonymousKeyEvent.xyb = true;
            paramAnonymousKeyEvent.xyh = false;
          }
          for (;;)
          {
            j.a(j.this).dvI().gI(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.xyf.setSelection(0);
            paramAnonymousKeyEvent.xyb = true;
            paramAnonymousKeyEvent.xyh = false;
          }
          Log.i("MicroMsg.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((m)paramAnonymousView).xyz.booleanValue()))
          {
            Log.i("MicroMsg.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          if ((!paramAnonymousView.xyi) && (paramAnonymousView.getType() != -1))
          {
            c.dwm().aw(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return true;
          }
          c.dwm().dwp();
          c.dwm().av(paramAnonymousInt, false);
          j.a(j.this).dvI().JI(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.editor.model.a.j();
          paramAnonymousView.xyb = true;
          paramAnonymousView.xyh = false;
          paramAnonymousView.content = "";
          paramAnonymousView.xyd = 0;
          c.dwm().a(paramAnonymousInt, paramAnonymousView);
          c.dwm().gL(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = j.a(j.this).dvG();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousKeyEvent.aYi(), "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.scrollToPosition(((Integer)paramAnonymousKeyEvent.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(181830);
          return false;
        }
      }
    };
    this.xAn = new ArrayList();
    this.xAo = parama;
    xAp = this;
    this.mActionBarHeight = com.tencent.mm.pluginsdk.h.fs(parama.dvH());
    this.mStatusBarHeight = aw.mL(parama.dvH());
    int[] arrayOfInt = com.tencent.mm.compatible.util.j.getScreenWH(parama.dvH());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    euS = parama.dvH().getResources().getDisplayMetrics();
    this.xAr = (mScreenHeight - this.mActionBarHeight - this.mStatusBarHeight - (int)cg(8.0F));
    com.tencent.mm.plugin.editor.model.nativenote.spans.k.xBM = 0.0F;
    AppMethodBeat.o(181831);
  }
  
  public static float cg(float paramFloat)
  {
    AppMethodBeat.i(181841);
    paramFloat = TypedValue.applyDimension(1, paramFloat, euS);
    AppMethodBeat.o(181841);
    return paramFloat;
  }
  
  public static j dwM()
  {
    return xAp;
  }
  
  public final void JK(int paramInt)
  {
    AppMethodBeat.i(181835);
    this.xAo.dvI().U(paramInt, 0L);
    AppMethodBeat.o(181835);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181837);
    if (!this.xAu)
    {
      AppMethodBeat.o(181837);
      return;
    }
    this.xAo.dvI().gJ(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.xCr.iterator();
      boolean bool1 = false;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2 = false;
      t localt;
      for (;;)
      {
        bool8 = bool1;
        bool7 = bool4;
        bool6 = bool3;
        bool5 = bool2;
        if (!localIterator.hasNext()) {
          break label176;
        }
        localt = (t)localIterator.next();
        if (!localt.s(paramWXRTEditText)) {
          break label226;
        }
        if ((localt instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.b))
        {
          bool2 = true;
        }
        else if ((localt instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.c))
        {
          bool3 = true;
        }
        else
        {
          if (!(localt instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.j)) {
            break;
          }
          bool4 = true;
        }
      }
      if (!(localt instanceof r)) {
        break label226;
      }
      bool1 = true;
    }
    label176:
    label226:
    for (;;)
    {
      break;
      bool8 = false;
      bool7 = false;
      bool6 = false;
      bool5 = false;
      this.xAt.nP(bool5);
      this.xAt.nQ(bool6);
      this.xAt.nR(bool7);
      this.xAt.nS(bool8);
      AppMethodBeat.o(181837);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(181838);
    String str = paramWXRTEditText.a(h.xAj);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.editor.model.a.a locala = c.dwm().JL(paramWXRTEditText.getRecyclerItemPosition());
      int i;
      int j;
      if ((locala != null) && (locala.getType() == 1))
      {
        if (paramSpannable1 != null) {
          break label130;
        }
        i = 0;
        if (paramSpannable2 != null) {
          break label142;
        }
        j = 0;
        label62:
        if (!c.dwm().gK(j - i, 0)) {
          break label154;
        }
        this.xAo.dvI().dvv();
        this.xAo.dvI().JG(paramWXRTEditText.getRecyclerItemPosition());
      }
      for (;;)
      {
        this.xAo.dvI().dvS();
        AppMethodBeat.o(181838);
        return;
        label130:
        i = com.tencent.mm.plugin.editor.b.ans(paramSpannable1.toString());
        break;
        label142:
        j = com.tencent.mm.plugin.editor.b.ans(paramSpannable2.toString());
        break label62;
        label154:
        c.dwm().dwp();
        ((com.tencent.mm.plugin.editor.model.a.j)locala).xyd = paramInt;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).content = str;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).xyb = true;
        locala.xyh = false;
        paramWXRTEditText = c.dwm();
        paramWXRTEditText.xyU = (j - i + paramWXRTEditText.xyU);
      }
    }
    paramWXRTEditText.setText("");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(181838);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.editor.model.a.j();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.dwm().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.dwm().gL(paramInt - 1, paramInt + 1);
      break;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181836);
    try
    {
      this.xAo.dvI().a(paramWXRTEditText, paramBoolean, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(181836);
    }
  }
  
  public final void b(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181840);
    this.xAo.dvI().a(paramWXRTEditText);
    AppMethodBeat.o(181840);
  }
  
  public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(181843);
    WXRTEditText localWXRTEditText = dwL();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().uG;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.dwE();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.dwF();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(181843);
        return;
      }
      localWXRTEditText.xzU = true;
      localWXRTEditText.xyl = paramt.dxp();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(181843);
  }
  
  public final WXRTEditText dwL()
  {
    AppMethodBeat.i(181833);
    c.dwm().X(this.xAn);
    if (this.xAn == null)
    {
      AppMethodBeat.o(181833);
      return null;
    }
    Iterator localIterator = this.xAn.iterator();
    while (localIterator.hasNext())
    {
      WXRTEditText localWXRTEditText = (WXRTEditText)localIterator.next();
      if (localWXRTEditText.hasFocus())
      {
        AppMethodBeat.o(181833);
        return localWXRTEditText;
      }
    }
    AppMethodBeat.o(181833);
    return null;
  }
  
  public final WXRTEditText dwN()
  {
    AppMethodBeat.i(181842);
    WXRTEditText localWXRTEditText = dwL();
    if ((localWXRTEditText == null) && (this.xAn.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.xAn.get(this.xAn.size() - 1);
      AppMethodBeat.o(181842);
      return localWXRTEditText;
    }
    AppMethodBeat.o(181842);
    return localWXRTEditText;
  }
  
  public final void dwh()
  {
    AppMethodBeat.i(181839);
    this.xAo.dvI().dvt();
    AppMethodBeat.o(181839);
  }
  
  public final void g(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181834);
    this.xAo.dvI().g(paramBoolean, paramLong);
    AppMethodBeat.o(181834);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181832);
    paramWXRTEditText.a(this);
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.xAv);
    AppMethodBeat.o(181832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */