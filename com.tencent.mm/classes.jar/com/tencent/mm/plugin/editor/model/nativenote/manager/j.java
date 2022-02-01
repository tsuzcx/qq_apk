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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  implements com.tencent.mm.plugin.editor.model.nativenote.b.c
{
  private static DisplayMetrics aJt;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static j pCu = null;
  public static int pCv = -1;
  private static int pCx = -1;
  public int ahF;
  public int mKJ;
  private View.OnKeyListener pCA;
  private transient ArrayList<WXRTEditText> pCs;
  public com.tencent.mm.plugin.editor.model.nativenote.a pCt;
  private int pCw;
  public com.tencent.mm.plugin.editor.model.nativenote.b.b pCy;
  public boolean pCz;
  
  public j(com.tencent.mm.plugin.editor.model.nativenote.a parama)
  {
    AppMethodBeat.i(181831);
    this.pCy = null;
    this.pCz = false;
    this.pCA = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(181830);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.cfy().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          localObject = j.this.cfY();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          ae.i("MicroMsg.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.cfy().BM(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ae.w("MicroMsg.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousKeyEvent = c.cfy().BM(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            ae.i("MicroMsg.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              ae.i("MicroMsg.WXRTManager", "Handle Editor Type EDITTEXT");
              if (!j.a(j.this, (WXRTEditText)localObject, paramAnonymousInt))
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(181830);
                return false;
              }
              paramAnonymousView = ((WXRTEditText)localObject).a(h.pCo);
              c.cfy().cfB();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.cfy().Y(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
              int i = paramAnonymousKeyEvent.pAo.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.pAl = i;
              paramAnonymousKeyEvent.pAj = true;
              paramAnonymousKeyEvent.pAp = false;
              label482:
              if (!bool) {
                break label548;
              }
              j.a(j.this).ceU().BH(paramAnonymousInt - 1);
            }
            if (!bu.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.cfy().Y(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.pAn.setSelection(0);
          paramAnonymousKeyEvent.pAj = true;
          paramAnonymousKeyEvent.pAp = false;
          break label482;
          label548:
          j.a(j.this).ceU().fe(paramAnonymousInt - 1, 2);
          break;
          ae.i("MicroMsg.WXRTManager", "Handle Editor Type PREBUTTON");
          c.cfy().cfB();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
            if (bu.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.pAm.setSelection(0);
              paramAnonymousView.pAj = true;
              paramAnonymousView.pAp = true;
              c.cfy().Y(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(181830);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.pAl = -1;
            paramAnonymousKeyEvent.pAj = true;
            paramAnonymousKeyEvent.pAp = false;
          }
          for (;;)
          {
            j.a(j.this).ceU().fe(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.pAn.setSelection(0);
            paramAnonymousKeyEvent.pAj = true;
            paramAnonymousKeyEvent.pAp = false;
          }
          ae.i("MicroMsg.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((m)paramAnonymousView).pAG.booleanValue()))
          {
            ae.i("MicroMsg.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          if ((!paramAnonymousView.pAq) && (paramAnonymousView.getType() != -1))
          {
            c.cfy().Z(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return true;
          }
          c.cfy().cfB();
          c.cfy().Y(paramAnonymousInt, false);
          j.a(j.this).ceU().BJ(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.editor.model.a.j();
          paramAnonymousView.pAj = true;
          paramAnonymousView.pAp = false;
          paramAnonymousView.content = "";
          paramAnonymousView.pAl = 0;
          c.cfy().a(paramAnonymousInt, paramAnonymousView);
          c.cfy().fh(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = j.a(j.this).ceS();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.ahE(), "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.ca(((Integer)paramAnonymousKeyEvent.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(181830);
          return false;
        }
      }
    };
    this.pCs = new ArrayList();
    this.pCt = parama;
    pCu = this;
    this.ahF = com.tencent.mm.pluginsdk.h.dX(parama.ceT());
    this.mKJ = al.jO(parama.ceT());
    int[] arrayOfInt = i.eF(parama.ceT());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aJt = parama.ceT().getResources().getDisplayMetrics();
    this.pCw = (mScreenHeight - this.ahF - this.mKJ - (int)aX(8.0F));
    com.tencent.mm.plugin.editor.model.nativenote.spans.k.pDR = 0.0F;
    AppMethodBeat.o(181831);
  }
  
  public static float aX(float paramFloat)
  {
    AppMethodBeat.i(181841);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aJt);
    AppMethodBeat.o(181841);
    return paramFloat;
  }
  
  public static j cfZ()
  {
    return pCu;
  }
  
  public final void BL(int paramInt)
  {
    AppMethodBeat.i(181835);
    this.pCt.ceU().N(paramInt, 0L);
    AppMethodBeat.o(181835);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181837);
    if (!this.pCz)
    {
      AppMethodBeat.o(181837);
      return;
    }
    this.pCt.ceU().ff(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.pEv.iterator();
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
      this.pCy.ke(bool5);
      this.pCy.kf(bool6);
      this.pCy.kg(bool7);
      this.pCy.kh(bool8);
      AppMethodBeat.o(181837);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(181838);
    String str = paramWXRTEditText.a(h.pCo);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.editor.model.a.a locala = c.cfy().BM(paramWXRTEditText.getRecyclerItemPosition());
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
        if (!c.cfy().fg(j - i, 0)) {
          break label154;
        }
        this.pCt.ceU().ceH();
        this.pCt.ceU().BH(paramWXRTEditText.getRecyclerItemPosition());
      }
      for (;;)
      {
        this.pCt.ceU().cfe();
        AppMethodBeat.o(181838);
        return;
        label130:
        i = com.tencent.mm.plugin.editor.b.abE(paramSpannable1.toString());
        break;
        label142:
        j = com.tencent.mm.plugin.editor.b.abE(paramSpannable2.toString());
        break label62;
        label154:
        c.cfy().cfB();
        ((com.tencent.mm.plugin.editor.model.a.j)locala).pAl = paramInt;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).content = str;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).pAj = true;
        locala.pAp = false;
        paramWXRTEditText = c.cfy();
        paramWXRTEditText.pBb = (j - i + paramWXRTEditText.pBb);
      }
    }
    paramWXRTEditText.setText("");
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(181838);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.editor.model.a.j();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.cfy().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.cfy().fh(paramInt - 1, paramInt + 1);
      break;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181836);
    try
    {
      this.pCt.ceU().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.pCt.ceU().a(paramWXRTEditText);
    AppMethodBeat.o(181840);
  }
  
  public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(181843);
    WXRTEditText localWXRTEditText = cfY();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().avj;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.cfR();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.cfS();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(181843);
        return;
      }
      localWXRTEditText.pBZ = true;
      localWXRTEditText.pAt = paramt.cgC();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(181843);
  }
  
  public final WXRTEditText cfY()
  {
    AppMethodBeat.i(181833);
    c.cfy().M(this.pCs);
    if (this.pCs == null)
    {
      AppMethodBeat.o(181833);
      return null;
    }
    Iterator localIterator = this.pCs.iterator();
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
  
  public final void cft()
  {
    AppMethodBeat.i(181839);
    this.pCt.ceU().ceF();
    AppMethodBeat.o(181839);
  }
  
  public final WXRTEditText cga()
  {
    AppMethodBeat.i(181842);
    WXRTEditText localWXRTEditText = cfY();
    if ((localWXRTEditText == null) && (this.pCs.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.pCs.get(this.pCs.size() - 1);
      AppMethodBeat.o(181842);
      return localWXRTEditText;
    }
    AppMethodBeat.o(181842);
    return localWXRTEditText;
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181834);
    this.pCt.ceU().e(paramBoolean, paramLong);
    AppMethodBeat.o(181834);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181832);
    paramWXRTEditText.a(this);
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.pCA);
    AppMethodBeat.o(181832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */