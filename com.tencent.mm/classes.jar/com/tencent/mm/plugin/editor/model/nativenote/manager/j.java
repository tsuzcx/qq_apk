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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  implements com.tencent.mm.plugin.editor.model.nativenote.b.c
{
  private static DisplayMetrics aHC;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static j oSg = null;
  public static int oSh = -1;
  private static int oSj = -1;
  public int afO;
  public int mfe;
  private transient ArrayList<WXRTEditText> oSe;
  public com.tencent.mm.plugin.editor.model.nativenote.a oSf;
  private int oSi;
  public com.tencent.mm.plugin.editor.model.nativenote.b.b oSk;
  public boolean oSl;
  private View.OnKeyListener oSm;
  
  public j(com.tencent.mm.plugin.editor.model.nativenote.a parama)
  {
    AppMethodBeat.i(181831);
    this.oSk = null;
    this.oSl = false;
    this.oSm = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(181830);
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.bZF().size() == 0)
          {
            AppMethodBeat.o(181830);
            return false;
          }
          WXRTEditText localWXRTEditText = j.this.caf();
          if (localWXRTEditText == null)
          {
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousInt = localWXRTEditText.getRecyclerItemPosition();
          ac.i("MicroMsg.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.bZF().AS(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ac.w("MicroMsg.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousKeyEvent = c.bZF().AS(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            ac.i("MicroMsg.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              ac.i("MicroMsg.WXRTManager", "Handle Editor Type EDITTEXT");
              if (!j.a(j.this, localWXRTEditText, paramAnonymousInt))
              {
                AppMethodBeat.o(181830);
                return false;
              }
              paramAnonymousView = localWXRTEditText.a(h.oSa);
              c.bZF().bZI();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.bZF().W(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
              int i = paramAnonymousKeyEvent.oQa.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.oPX = i;
              paramAnonymousKeyEvent.oPV = true;
              paramAnonymousKeyEvent.oQb = false;
              label344:
              if (!bool) {
                break label410;
              }
              j.a(j.this).bZb().AN(paramAnonymousInt - 1);
            }
            if (!bs.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.bZF().W(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.oPZ.setSelection(0);
          paramAnonymousKeyEvent.oPV = true;
          paramAnonymousKeyEvent.oQb = false;
          break label344;
          label410:
          j.a(j.this).bZb().eZ(paramAnonymousInt - 1, 2);
          break;
          ac.i("MicroMsg.WXRTManager", "Handle Editor Type PREBUTTON");
          c.bZF().bZI();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
            if (bs.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.oPY.setSelection(0);
              paramAnonymousView.oPV = true;
              paramAnonymousView.oQb = true;
              c.bZF().W(paramAnonymousInt - 1, true);
              AppMethodBeat.o(181830);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.oPX = -1;
            paramAnonymousKeyEvent.oPV = true;
            paramAnonymousKeyEvent.oQb = false;
          }
          for (;;)
          {
            j.a(j.this).bZb().eZ(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.oPZ.setSelection(0);
            paramAnonymousKeyEvent.oPV = true;
            paramAnonymousKeyEvent.oQb = false;
          }
          ac.i("MicroMsg.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((m)paramAnonymousView).oQs.booleanValue()))
          {
            ac.i("MicroMsg.WXRTManager", "Current Item is Voice and Recording");
            AppMethodBeat.o(181830);
            return false;
          }
          if ((!paramAnonymousView.oQc) && (paramAnonymousView.getType() != -1))
          {
            c.bZF().X(paramAnonymousInt, true);
            AppMethodBeat.o(181830);
            return true;
          }
          c.bZF().bZI();
          c.bZF().W(paramAnonymousInt, false);
          j.a(j.this).bZb().AP(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.editor.model.a.j();
          paramAnonymousView.oPV = true;
          paramAnonymousView.oQb = false;
          paramAnonymousView.content = "";
          paramAnonymousView.oPX = 0;
          c.bZF().a(paramAnonymousInt, paramAnonymousView);
          c.bZF().fc(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = j.a(j.this).bYZ();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.aeD(), "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.ca(((Integer)paramAnonymousKeyEvent.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          AppMethodBeat.o(181830);
          return false;
        }
      }
    };
    this.oSe = new ArrayList();
    this.oSf = parama;
    oSg = this;
    this.afO = com.tencent.mm.pluginsdk.g.dT(parama.bZa());
    this.mfe = aj.jw(parama.bZa());
    int[] arrayOfInt = i.eB(parama.bZa());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aHC = parama.bZa().getResources().getDisplayMetrics();
    this.oSi = (mScreenHeight - this.afO - this.mfe - (int)aU(8.0F));
    com.tencent.mm.plugin.editor.model.nativenote.spans.k.oTD = 0.0F;
    AppMethodBeat.o(181831);
  }
  
  public static float aU(float paramFloat)
  {
    AppMethodBeat.i(181841);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aHC);
    AppMethodBeat.o(181841);
    return paramFloat;
  }
  
  public static j cag()
  {
    return oSg;
  }
  
  public final void AR(int paramInt)
  {
    AppMethodBeat.i(181835);
    this.oSf.bZb().M(paramInt, 0L);
    AppMethodBeat.o(181835);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181837);
    if (!this.oSl)
    {
      AppMethodBeat.o(181837);
      return;
    }
    this.oSf.bZb().fa(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.oUh.iterator();
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
      this.oSk.jU(bool5);
      this.oSk.jV(bool6);
      this.oSk.jW(bool7);
      this.oSk.jX(bool8);
      AppMethodBeat.o(181837);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(181838);
    String str = paramWXRTEditText.a(h.oSa);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.editor.model.a.a locala = c.bZF().AS(paramWXRTEditText.getRecyclerItemPosition());
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
        if (!c.bZF().fb(j - i, 0)) {
          break label154;
        }
        this.oSf.bZb().bYO();
        this.oSf.bZb().AN(paramWXRTEditText.getRecyclerItemPosition());
      }
      for (;;)
      {
        this.oSf.bZb().bZl();
        AppMethodBeat.o(181838);
        return;
        label130:
        i = com.tencent.mm.plugin.editor.b.Xg(paramSpannable1.toString());
        break;
        label142:
        j = com.tencent.mm.plugin.editor.b.Xg(paramSpannable2.toString());
        break label62;
        label154:
        c.bZF().bZI();
        ((com.tencent.mm.plugin.editor.model.a.j)locala).oPX = paramInt;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).content = str;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).oPV = true;
        locala.oQb = false;
        paramWXRTEditText = c.bZF();
        paramWXRTEditText.oQN = (j - i + paramWXRTEditText.oQN);
      }
    }
    paramWXRTEditText.setText("");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(181838);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.editor.model.a.j();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.bZF().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.bZF().fc(paramInt - 1, paramInt + 1);
      break;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181836);
    try
    {
      this.oSf.bZb().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.oSf.bZb().a(paramWXRTEditText);
    AppMethodBeat.o(181840);
  }
  
  public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(181843);
    WXRTEditText localWXRTEditText = caf();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().atr;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.bZY();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.bZZ();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(181843);
        return;
      }
      localWXRTEditText.oRL = true;
      localWXRTEditText.oQf = paramt.caI();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(181843);
  }
  
  public final void bZA()
  {
    AppMethodBeat.i(181839);
    this.oSf.bZb().bYM();
    AppMethodBeat.o(181839);
  }
  
  public final WXRTEditText caf()
  {
    AppMethodBeat.i(181833);
    c.bZF().M(this.oSe);
    if (this.oSe == null)
    {
      AppMethodBeat.o(181833);
      return null;
    }
    Iterator localIterator = this.oSe.iterator();
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
  
  public final WXRTEditText cah()
  {
    AppMethodBeat.i(181842);
    WXRTEditText localWXRTEditText = caf();
    if ((localWXRTEditText == null) && (this.oSe.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.oSe.get(this.oSe.size() - 1);
      AppMethodBeat.o(181842);
      return localWXRTEditText;
    }
    AppMethodBeat.o(181842);
    return localWXRTEditText;
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181834);
    this.oSf.bZb().e(paramBoolean, paramLong);
    AppMethodBeat.o(181834);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181832);
    paramWXRTEditText.a(this);
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.oSm);
    AppMethodBeat.o(181832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */