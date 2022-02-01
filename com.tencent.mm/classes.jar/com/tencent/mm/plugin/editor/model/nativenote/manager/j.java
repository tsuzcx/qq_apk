package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.spans.r;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  implements com.tencent.mm.plugin.editor.model.nativenote.b.c
{
  private static DisplayMetrics aJm;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static j qRM = null;
  public static int qRN = -1;
  private static int qRP = -1;
  public int mActionBarHeight;
  public int mStatusBarHeight;
  private transient ArrayList<WXRTEditText> qRK;
  public com.tencent.mm.plugin.editor.model.nativenote.a qRL;
  private int qRO;
  public com.tencent.mm.plugin.editor.model.nativenote.b.b qRQ;
  public boolean qRR;
  private View.OnKeyListener qRS;
  
  public j(com.tencent.mm.plugin.editor.model.nativenote.a parama)
  {
    AppMethodBeat.i(181831);
    this.qRQ = null;
    this.qRR = false;
    this.qRS = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(181830);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.cDo().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          localObject = j.this.cDO();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          Log.i("MicroMsg.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.cDo().Fw(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            Log.w("MicroMsg.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousKeyEvent = c.cDo().Fw(paramAnonymousInt - 1);
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
              paramAnonymousView = ((WXRTEditText)localObject).a(h.qRG);
              c.cDo().cDr();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.cDo().ae(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
              int i = paramAnonymousKeyEvent.qPF.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.qPC = i;
              paramAnonymousKeyEvent.qPA = true;
              paramAnonymousKeyEvent.qPG = false;
              label482:
              if (!bool) {
                break label548;
              }
              j.a(j.this).cCK().Fr(paramAnonymousInt - 1);
            }
            if (!Util.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.cDo().ae(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.qPE.setSelection(0);
          paramAnonymousKeyEvent.qPA = true;
          paramAnonymousKeyEvent.qPG = false;
          break label482;
          label548:
          j.a(j.this).cCK().fu(paramAnonymousInt - 1, 2);
          break;
          Log.i("MicroMsg.WXRTManager", "Handle Editor Type PREBUTTON");
          c.cDo().cDr();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
            if (Util.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.qPD.setSelection(0);
              paramAnonymousView.qPA = true;
              paramAnonymousView.qPG = true;
              c.cDo().ae(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(181830);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.qPC = -1;
            paramAnonymousKeyEvent.qPA = true;
            paramAnonymousKeyEvent.qPG = false;
          }
          for (;;)
          {
            j.a(j.this).cCK().fu(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.qPE.setSelection(0);
            paramAnonymousKeyEvent.qPA = true;
            paramAnonymousKeyEvent.qPG = false;
          }
          Log.i("MicroMsg.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((m)paramAnonymousView).qPX.booleanValue()))
          {
            Log.i("MicroMsg.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          if ((!paramAnonymousView.qPH) && (paramAnonymousView.getType() != -1))
          {
            c.cDo().af(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return true;
          }
          c.cDo().cDr();
          c.cDo().ae(paramAnonymousInt, false);
          j.a(j.this).cCK().Ft(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.editor.model.a.j();
          paramAnonymousView.qPA = true;
          paramAnonymousView.qPG = false;
          paramAnonymousView.content = "";
          paramAnonymousView.qPC = 0;
          c.cDo().a(paramAnonymousInt, paramAnonymousView);
          c.cDo().fx(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = j.a(j.this).cCI();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.axQ(), "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.scrollToPosition(((Integer)paramAnonymousKeyEvent.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(181830);
          return false;
        }
      }
    };
    this.qRK = new ArrayList();
    this.qRL = parama;
    qRM = this;
    this.mActionBarHeight = com.tencent.mm.pluginsdk.h.eu(parama.cCJ());
    this.mStatusBarHeight = ao.jJ(parama.cCJ());
    int[] arrayOfInt = i.getScreenWH(parama.cCJ());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aJm = parama.cCJ().getResources().getDisplayMetrics();
    this.qRO = (mScreenHeight - this.mActionBarHeight - this.mStatusBarHeight - (int)be(8.0F));
    com.tencent.mm.plugin.editor.model.nativenote.spans.k.qTi = 0.0F;
    AppMethodBeat.o(181831);
  }
  
  public static float be(float paramFloat)
  {
    AppMethodBeat.i(181841);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aJm);
    AppMethodBeat.o(181841);
    return paramFloat;
  }
  
  public static j cDP()
  {
    return qRM;
  }
  
  public final void Fv(int paramInt)
  {
    AppMethodBeat.i(181835);
    this.qRL.cCK().Q(paramInt, 0L);
    AppMethodBeat.o(181835);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181837);
    if (!this.qRR)
    {
      AppMethodBeat.o(181837);
      return;
    }
    this.qRL.cCK().fv(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.qTM.iterator();
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
      this.qRQ.lh(bool5);
      this.qRQ.li(bool6);
      this.qRQ.lj(bool7);
      this.qRQ.lk(bool8);
      AppMethodBeat.o(181837);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(181838);
    String str = paramWXRTEditText.a(h.qRG);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.editor.model.a.a locala = c.cDo().Fw(paramWXRTEditText.getRecyclerItemPosition());
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
        if (!c.cDo().fw(j - i, 0)) {
          break label154;
        }
        this.qRL.cCK().cCx();
        this.qRL.cCK().Fr(paramWXRTEditText.getRecyclerItemPosition());
      }
      for (;;)
      {
        this.qRL.cCK().cCU();
        AppMethodBeat.o(181838);
        return;
        label130:
        i = com.tencent.mm.plugin.editor.b.alK(paramSpannable1.toString());
        break;
        label142:
        j = com.tencent.mm.plugin.editor.b.alK(paramSpannable2.toString());
        break label62;
        label154:
        c.cDo().cDr();
        ((com.tencent.mm.plugin.editor.model.a.j)locala).qPC = paramInt;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).content = str;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).qPA = true;
        locala.qPG = false;
        paramWXRTEditText = c.cDo();
        paramWXRTEditText.qQs = (j - i + paramWXRTEditText.qQs);
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
      paramInt = c.cDo().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.cDo().fx(paramInt - 1, paramInt + 1);
      break;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181836);
    try
    {
      this.qRL.cCK().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.qRL.cCK().a(paramWXRTEditText);
    AppMethodBeat.o(181840);
  }
  
  public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(181843);
    WXRTEditText localWXRTEditText = cDO();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().avh;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.cDH();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.cDI();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(181843);
        return;
      }
      localWXRTEditText.qRr = true;
      localWXRTEditText.qPK = paramt.cEq();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(181843);
  }
  
  public final WXRTEditText cDO()
  {
    AppMethodBeat.i(181833);
    c.cDo().T(this.qRK);
    if (this.qRK == null)
    {
      AppMethodBeat.o(181833);
      return null;
    }
    Iterator localIterator = this.qRK.iterator();
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
  
  public final WXRTEditText cDQ()
  {
    AppMethodBeat.i(181842);
    WXRTEditText localWXRTEditText = cDO();
    if ((localWXRTEditText == null) && (this.qRK.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.qRK.get(this.qRK.size() - 1);
      AppMethodBeat.o(181842);
      return localWXRTEditText;
    }
    AppMethodBeat.o(181842);
    return localWXRTEditText;
  }
  
  public final void cDj()
  {
    AppMethodBeat.i(181839);
    this.qRL.cCK().cCv();
    AppMethodBeat.o(181839);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181834);
    this.qRL.cCK().e(paramBoolean, paramLong);
    AppMethodBeat.o(181834);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181832);
    paramWXRTEditText.a(this);
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.qRS);
    AppMethodBeat.o(181832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */