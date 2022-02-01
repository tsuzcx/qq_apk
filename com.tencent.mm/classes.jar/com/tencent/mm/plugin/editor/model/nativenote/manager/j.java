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
import com.tencent.mm.ui.ai;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  implements com.tencent.mm.plugin.editor.model.nativenote.b.c
{
  private static DisplayMetrics aGM;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static j ooG = null;
  public static int ooH = -1;
  private static int ooJ = -1;
  public int aeU;
  public int lDk;
  private transient ArrayList<WXRTEditText> ooE;
  public com.tencent.mm.plugin.editor.model.nativenote.a ooF;
  private int ooI;
  public com.tencent.mm.plugin.editor.model.nativenote.b.b ooK;
  public boolean ooL;
  private View.OnKeyListener ooM;
  
  public j(com.tencent.mm.plugin.editor.model.nativenote.a parama)
  {
    AppMethodBeat.i(181831);
    this.ooK = null;
    this.ooL = false;
    this.ooM = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(181830);
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.bSq().size() == 0)
          {
            AppMethodBeat.o(181830);
            return false;
          }
          WXRTEditText localWXRTEditText = j.this.bSQ();
          if (localWXRTEditText == null)
          {
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousInt = localWXRTEditText.getRecyclerItemPosition();
          ad.i("MicroMsg.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.bSq().Aa(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ad.w("MicroMsg.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousKeyEvent = c.bSq().Aa(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            ad.i("MicroMsg.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((localWXRTEditText.getEditTextType() == 0) && (!j.a(j.this, localWXRTEditText, paramAnonymousInt)))
            {
              AppMethodBeat.o(181830);
              return false;
            }
            AppMethodBeat.o(181830);
            return false;
          }
          switch (localWXRTEditText.getEditTextType())
          {
          default: 
          case 0: 
            for (;;)
            {
              AppMethodBeat.o(181830);
              return true;
              ad.i("MicroMsg.WXRTManager", "Handle Editor Type EDITTEXT");
              if (!j.a(j.this, localWXRTEditText, paramAnonymousInt))
              {
                AppMethodBeat.o(181830);
                return false;
              }
              paramAnonymousView = localWXRTEditText.a(h.ooA);
              c.bSq().bSt();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.bSq().W(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
              int i = paramAnonymousKeyEvent.omA.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.omx = i;
              paramAnonymousKeyEvent.omv = true;
              paramAnonymousKeyEvent.omB = false;
              label344:
              if (!bool) {
                break label410;
              }
              j.a(j.this).bRM().zV(paramAnonymousInt - 1);
            }
            if (!bt.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.bSq().W(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.omz.setSelection(0);
          paramAnonymousKeyEvent.omv = true;
          paramAnonymousKeyEvent.omB = false;
          break label344;
          label410:
          j.a(j.this).bRM().eW(paramAnonymousInt - 1, 2);
          break;
          ad.i("MicroMsg.WXRTManager", "Handle Editor Type PREBUTTON");
          c.bSq().bSt();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
            if (bt.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.omy.setSelection(0);
              paramAnonymousView.omv = true;
              paramAnonymousView.omB = true;
              c.bSq().W(paramAnonymousInt - 1, true);
              AppMethodBeat.o(181830);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.omx = -1;
            paramAnonymousKeyEvent.omv = true;
            paramAnonymousKeyEvent.omB = false;
          }
          for (;;)
          {
            j.a(j.this).bRM().eW(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.omz.setSelection(0);
            paramAnonymousKeyEvent.omv = true;
            paramAnonymousKeyEvent.omB = false;
          }
          ad.i("MicroMsg.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((m)paramAnonymousView).omS.booleanValue()))
          {
            ad.i("MicroMsg.WXRTManager", "Current Item is Voice and Recording");
            AppMethodBeat.o(181830);
            return false;
          }
          if ((!paramAnonymousView.omC) && (paramAnonymousView.getType() != -1))
          {
            c.bSq().X(paramAnonymousInt, true);
            AppMethodBeat.o(181830);
            return true;
          }
          c.bSq().bSt();
          c.bSq().W(paramAnonymousInt, false);
          j.a(j.this).bRM().zX(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.editor.model.a.j();
          paramAnonymousView.omv = true;
          paramAnonymousView.omB = false;
          paramAnonymousView.content = "";
          paramAnonymousView.omx = 0;
          c.bSq().a(paramAnonymousInt, paramAnonymousView);
          c.bSq().eZ(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = j.a(j.this).bRK();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.adn(), "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.ca(((Integer)paramAnonymousKeyEvent.lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          AppMethodBeat.o(181830);
          return false;
        }
      }
    };
    this.ooE = new ArrayList();
    this.ooF = parama;
    ooG = this;
    this.aeU = com.tencent.mm.pluginsdk.g.dL(parama.bRL());
    this.lDk = ai.jl(parama.bRL());
    int[] arrayOfInt = i.et(parama.bRL());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aGM = parama.bRL().getResources().getDisplayMetrics();
    this.ooI = (mScreenHeight - this.aeU - this.lDk - (int)aQ(8.0F));
    com.tencent.mm.plugin.editor.model.nativenote.spans.k.oqd = 0.0F;
    AppMethodBeat.o(181831);
  }
  
  public static float aQ(float paramFloat)
  {
    AppMethodBeat.i(181841);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aGM);
    AppMethodBeat.o(181841);
    return paramFloat;
  }
  
  public static j bSR()
  {
    return ooG;
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181837);
    if (!this.ooL)
    {
      AppMethodBeat.o(181837);
      return;
    }
    this.ooF.bRM().eX(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.oqH.iterator();
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
      this.ooK.jr(bool5);
      this.ooK.js(bool6);
      this.ooK.jt(bool7);
      this.ooK.ju(bool8);
      AppMethodBeat.o(181837);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(181838);
    String str = paramWXRTEditText.a(h.ooA);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.editor.model.a.a locala = c.bSq().Aa(paramWXRTEditText.getRecyclerItemPosition());
      int i;
      int j;
      if ((locala != null) && (locala.getType() == 1))
      {
        if (paramSpannable1 != null) {
          break label128;
        }
        i = 0;
        if (paramSpannable2 != null) {
          break label140;
        }
        j = 0;
        label61:
        if (!c.bSq().eY(j - i, 0)) {
          break label152;
        }
        this.ooF.bRM().bRz();
        this.ooF.bRM().zV(paramWXRTEditText.getRecyclerItemPosition());
      }
      for (;;)
      {
        this.ooF.bRM().bRW();
        AppMethodBeat.o(181838);
        return;
        label128:
        i = com.tencent.mm.plugin.editor.b.SU(paramSpannable1.toString());
        break;
        label140:
        j = com.tencent.mm.plugin.editor.b.SU(paramSpannable2.toString());
        break label61;
        label152:
        c.bSq().bSt();
        ((com.tencent.mm.plugin.editor.model.a.j)locala).omx = paramInt;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).content = str;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).omv = true;
        locala.omB = false;
        paramWXRTEditText = c.bSq();
        paramWXRTEditText.onn = (j - i + paramWXRTEditText.onn);
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
      paramInt = c.bSq().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.bSq().eZ(paramInt - 1, paramInt + 1);
      break;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181836);
    try
    {
      this.ooF.bRM().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.ooF.bRM().a(paramWXRTEditText);
    AppMethodBeat.o(181840);
  }
  
  public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(181843);
    WXRTEditText localWXRTEditText = bSQ();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().asw;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.bSJ();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.bSK();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(181843);
        return;
      }
      localWXRTEditText.ool = true;
      localWXRTEditText.omF = paramt.bTu();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(181843);
  }
  
  public final WXRTEditText bSQ()
  {
    AppMethodBeat.i(181833);
    c.bSq().H(this.ooE);
    if (this.ooE == null)
    {
      AppMethodBeat.o(181833);
      return null;
    }
    Iterator localIterator = this.ooE.iterator();
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
  
  public final WXRTEditText bSS()
  {
    AppMethodBeat.i(181842);
    WXRTEditText localWXRTEditText = bSQ();
    if ((localWXRTEditText == null) && (this.ooE.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.ooE.get(this.ooE.size() - 1);
      AppMethodBeat.o(181842);
      return localWXRTEditText;
    }
    AppMethodBeat.o(181842);
    return localWXRTEditText;
  }
  
  public final void bSl()
  {
    AppMethodBeat.i(181839);
    this.ooF.bRM().bRx();
    AppMethodBeat.o(181839);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181834);
    this.ooF.bRM().e(paramBoolean, paramLong);
    AppMethodBeat.o(181834);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181832);
    paramWXRTEditText.a(this);
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.ooM);
    AppMethodBeat.o(181832);
  }
  
  public final void zZ(int paramInt)
  {
    AppMethodBeat.i(181835);
    this.ooF.bRM().N(paramInt, 0L);
    AppMethodBeat.o(181835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */