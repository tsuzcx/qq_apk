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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  implements com.tencent.mm.plugin.editor.model.nativenote.b.c
{
  private static DisplayMetrics aJt;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static j pvQ = null;
  public static int pvR = -1;
  private static int pvT = -1;
  public int ahF;
  public int mFF;
  private transient ArrayList<WXRTEditText> pvO;
  public com.tencent.mm.plugin.editor.model.nativenote.a pvP;
  private int pvS;
  public com.tencent.mm.plugin.editor.model.nativenote.b.b pvU;
  public boolean pvV;
  private View.OnKeyListener pvW;
  
  public j(com.tencent.mm.plugin.editor.model.nativenote.a parama)
  {
    AppMethodBeat.i(181831);
    this.pvU = null;
    this.pvV = false;
    this.pvW = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(181830);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.cej().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          localObject = j.this.ceJ();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          ad.i("MicroMsg.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.cej().BA(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ad.w("MicroMsg.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousKeyEvent = c.cej().BA(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            ad.i("MicroMsg.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              ad.i("MicroMsg.WXRTManager", "Handle Editor Type EDITTEXT");
              if (!j.a(j.this, (WXRTEditText)localObject, paramAnonymousInt))
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(181830);
                return false;
              }
              paramAnonymousView = ((WXRTEditText)localObject).a(h.pvK);
              c.cej().cem();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.cej().W(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
              int i = paramAnonymousKeyEvent.ptK.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.ptH = i;
              paramAnonymousKeyEvent.ptF = true;
              paramAnonymousKeyEvent.ptL = false;
              label482:
              if (!bool) {
                break label548;
              }
              j.a(j.this).cdF().Bv(paramAnonymousInt - 1);
            }
            if (!bt.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.cej().W(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.ptJ.setSelection(0);
          paramAnonymousKeyEvent.ptF = true;
          paramAnonymousKeyEvent.ptL = false;
          break label482;
          label548:
          j.a(j.this).cdF().fd(paramAnonymousInt - 1, 2);
          break;
          ad.i("MicroMsg.WXRTManager", "Handle Editor Type PREBUTTON");
          c.cej().cem();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
            if (bt.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.ptI.setSelection(0);
              paramAnonymousView.ptF = true;
              paramAnonymousView.ptL = true;
              c.cej().W(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(181830);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.ptH = -1;
            paramAnonymousKeyEvent.ptF = true;
            paramAnonymousKeyEvent.ptL = false;
          }
          for (;;)
          {
            j.a(j.this).cdF().fd(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.ptJ.setSelection(0);
            paramAnonymousKeyEvent.ptF = true;
            paramAnonymousKeyEvent.ptL = false;
          }
          ad.i("MicroMsg.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((m)paramAnonymousView).puc.booleanValue()))
          {
            ad.i("MicroMsg.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          if ((!paramAnonymousView.ptM) && (paramAnonymousView.getType() != -1))
          {
            c.cej().X(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return true;
          }
          c.cej().cem();
          c.cej().W(paramAnonymousInt, false);
          j.a(j.this).cdF().Bx(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.editor.model.a.j();
          paramAnonymousView.ptF = true;
          paramAnonymousView.ptL = false;
          paramAnonymousView.content = "";
          paramAnonymousView.ptH = 0;
          c.cej().a(paramAnonymousInt, paramAnonymousView);
          c.cej().fg(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = j.a(j.this).cdD();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.ahp(), "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.ca(((Integer)paramAnonymousKeyEvent.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(181830);
          return false;
        }
      }
    };
    this.pvO = new ArrayList();
    this.pvP = parama;
    pvQ = this;
    this.ahF = com.tencent.mm.pluginsdk.h.dT(parama.cdE());
    this.mFF = al.jH(parama.cdE());
    int[] arrayOfInt = i.eB(parama.cdE());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aJt = parama.cdE().getResources().getDisplayMetrics();
    this.pvS = (mScreenHeight - this.ahF - this.mFF - (int)aX(8.0F));
    com.tencent.mm.plugin.editor.model.nativenote.spans.k.pxn = 0.0F;
    AppMethodBeat.o(181831);
  }
  
  public static float aX(float paramFloat)
  {
    AppMethodBeat.i(181841);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aJt);
    AppMethodBeat.o(181841);
    return paramFloat;
  }
  
  public static j ceK()
  {
    return pvQ;
  }
  
  public final void Bz(int paramInt)
  {
    AppMethodBeat.i(181835);
    this.pvP.cdF().O(paramInt, 0L);
    AppMethodBeat.o(181835);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181837);
    if (!this.pvV)
    {
      AppMethodBeat.o(181837);
      return;
    }
    this.pvP.cdF().fe(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.pxR.iterator();
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
      this.pvU.kf(bool5);
      this.pvU.kg(bool6);
      this.pvU.kh(bool7);
      this.pvU.ki(bool8);
      AppMethodBeat.o(181837);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(181838);
    String str = paramWXRTEditText.a(h.pvK);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.editor.model.a.a locala = c.cej().BA(paramWXRTEditText.getRecyclerItemPosition());
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
        if (!c.cej().ff(j - i, 0)) {
          break label154;
        }
        this.pvP.cdF().cds();
        this.pvP.cdF().Bv(paramWXRTEditText.getRecyclerItemPosition());
      }
      for (;;)
      {
        this.pvP.cdF().cdP();
        AppMethodBeat.o(181838);
        return;
        label130:
        i = com.tencent.mm.plugin.editor.b.aaN(paramSpannable1.toString());
        break;
        label142:
        j = com.tencent.mm.plugin.editor.b.aaN(paramSpannable2.toString());
        break label62;
        label154:
        c.cej().cem();
        ((com.tencent.mm.plugin.editor.model.a.j)locala).ptH = paramInt;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).content = str;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).ptF = true;
        locala.ptL = false;
        paramWXRTEditText = c.cej();
        paramWXRTEditText.pux = (j - i + paramWXRTEditText.pux);
      }
    }
    paramWXRTEditText.setText("");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(181838);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.editor.model.a.j();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.cej().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.cej().fg(paramInt - 1, paramInt + 1);
      break;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181836);
    try
    {
      this.pvP.cdF().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.pvP.cdF().a(paramWXRTEditText);
    AppMethodBeat.o(181840);
  }
  
  public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(181843);
    WXRTEditText localWXRTEditText = ceJ();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().avj;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.ceC();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.ceD();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(181843);
        return;
      }
      localWXRTEditText.pvv = true;
      localWXRTEditText.ptP = paramt.cfm();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(181843);
  }
  
  public final WXRTEditText ceJ()
  {
    AppMethodBeat.i(181833);
    c.cej().M(this.pvO);
    if (this.pvO == null)
    {
      AppMethodBeat.o(181833);
      return null;
    }
    Iterator localIterator = this.pvO.iterator();
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
  
  public final WXRTEditText ceL()
  {
    AppMethodBeat.i(181842);
    WXRTEditText localWXRTEditText = ceJ();
    if ((localWXRTEditText == null) && (this.pvO.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.pvO.get(this.pvO.size() - 1);
      AppMethodBeat.o(181842);
      return localWXRTEditText;
    }
    AppMethodBeat.o(181842);
    return localWXRTEditText;
  }
  
  public final void cee()
  {
    AppMethodBeat.i(181839);
    this.pvP.cdF().cdq();
    AppMethodBeat.o(181839);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181834);
    this.pvP.cdF().e(paramBoolean, paramLong);
    AppMethodBeat.o(181834);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181832);
    paramWXRTEditText.a(this);
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.pvW);
    AppMethodBeat.o(181832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */