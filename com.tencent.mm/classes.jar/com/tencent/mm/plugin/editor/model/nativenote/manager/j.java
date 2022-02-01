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
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.spans.r;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  implements com.tencent.mm.plugin.editor.model.nativenote.b.c
{
  private static DisplayMetrics cCm;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static j utS = null;
  public static int utT = -1;
  private static int utV = -1;
  public int mActionBarHeight;
  public int mStatusBarHeight;
  private transient ArrayList<WXRTEditText> utQ;
  public com.tencent.mm.plugin.editor.model.nativenote.a utR;
  private int utU;
  public com.tencent.mm.plugin.editor.model.nativenote.b.b utW;
  public boolean utX;
  private View.OnKeyListener utY;
  
  public j(com.tencent.mm.plugin.editor.model.nativenote.a parama)
  {
    AppMethodBeat.i(181831);
    this.utW = null;
    this.utX = false;
    this.utY = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(181830);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.cRT().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          localObject = j.this.cSt();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          Log.i("MicroMsg.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.cRT().Jd(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            Log.w("MicroMsg.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          paramAnonymousKeyEvent = c.cRT().Jd(paramAnonymousInt - 1);
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
              paramAnonymousView = ((WXRTEditText)localObject).a(h.utM);
              c.cRT().cRW();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.cRT().ae(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
              int i = paramAnonymousKeyEvent.urL.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.urI = i;
              paramAnonymousKeyEvent.urG = true;
              paramAnonymousKeyEvent.urM = false;
              label482:
              if (!bool) {
                break label548;
              }
              j.a(j.this).cRp().IY(paramAnonymousInt - 1);
            }
            if (!Util.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.cRT().ae(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.urK.setSelection(0);
          paramAnonymousKeyEvent.urG = true;
          paramAnonymousKeyEvent.urM = false;
          break label482;
          label548:
          j.a(j.this).cRp().fR(paramAnonymousInt - 1, 2);
          break;
          Log.i("MicroMsg.WXRTManager", "Handle Editor Type PREBUTTON");
          c.cRT().cRW();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.editor.model.a.j)paramAnonymousKeyEvent;
            if (Util.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.urJ.setSelection(0);
              paramAnonymousView.urG = true;
              paramAnonymousView.urM = true;
              c.cRT().ae(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(181830);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.urI = -1;
            paramAnonymousKeyEvent.urG = true;
            paramAnonymousKeyEvent.urM = false;
          }
          for (;;)
          {
            j.a(j.this).cRp().fR(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.urK.setSelection(0);
            paramAnonymousKeyEvent.urG = true;
            paramAnonymousKeyEvent.urM = false;
          }
          Log.i("MicroMsg.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((m)paramAnonymousView).usd.booleanValue()))
          {
            Log.i("MicroMsg.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return false;
          }
          if ((!paramAnonymousView.urN) && (paramAnonymousView.getType() != -1))
          {
            c.cRT().af(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(181830);
            return true;
          }
          c.cRT().cRW();
          c.cRT().ae(paramAnonymousInt, false);
          j.a(j.this).cRp().Ja(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.editor.model.a.j();
          paramAnonymousView.urG = true;
          paramAnonymousView.urM = false;
          paramAnonymousView.content = "";
          paramAnonymousView.urI = 0;
          c.cRT().a(paramAnonymousInt, paramAnonymousView);
          c.cRT().fU(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = j.a(j.this).cRn();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousKeyEvent.aFh(), "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.scrollToPosition(((Integer)paramAnonymousKeyEvent.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(181830);
          return false;
        }
      }
    };
    this.utQ = new ArrayList();
    this.utR = parama;
    utS = this;
    this.mActionBarHeight = com.tencent.mm.pluginsdk.h.ew(parama.cRo());
    this.mStatusBarHeight = ar.kI(parama.cRo());
    int[] arrayOfInt = i.getScreenWH(parama.cRo());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    cCm = parama.cRo().getResources().getDisplayMetrics();
    this.utU = (mScreenHeight - this.mActionBarHeight - this.mStatusBarHeight - (int)bd(8.0F));
    com.tencent.mm.plugin.editor.model.nativenote.spans.k.uvo = 0.0F;
    AppMethodBeat.o(181831);
  }
  
  public static float bd(float paramFloat)
  {
    AppMethodBeat.i(181841);
    paramFloat = TypedValue.applyDimension(1, paramFloat, cCm);
    AppMethodBeat.o(181841);
    return paramFloat;
  }
  
  public static j cSu()
  {
    return utS;
  }
  
  public final void Jc(int paramInt)
  {
    AppMethodBeat.i(181835);
    this.utR.cRp().Q(paramInt, 0L);
    AppMethodBeat.o(181835);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181837);
    if (!this.utX)
    {
      AppMethodBeat.o(181837);
      return;
    }
    this.utR.cRp().fS(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.uvS.iterator();
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
      this.utW.mt(bool5);
      this.utW.mu(bool6);
      this.utW.mv(bool7);
      this.utW.mw(bool8);
      AppMethodBeat.o(181837);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(181838);
    String str = paramWXRTEditText.a(h.utM);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.editor.model.a.a locala = c.cRT().Jd(paramWXRTEditText.getRecyclerItemPosition());
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
        if (!c.cRT().fT(j - i, 0)) {
          break label154;
        }
        this.utR.cRp().cRc();
        this.utR.cRp().IY(paramWXRTEditText.getRecyclerItemPosition());
      }
      for (;;)
      {
        this.utR.cRp().cRz();
        AppMethodBeat.o(181838);
        return;
        label130:
        i = com.tencent.mm.plugin.editor.b.atD(paramSpannable1.toString());
        break;
        label142:
        j = com.tencent.mm.plugin.editor.b.atD(paramSpannable2.toString());
        break label62;
        label154:
        c.cRT().cRW();
        ((com.tencent.mm.plugin.editor.model.a.j)locala).urI = paramInt;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).content = str;
        ((com.tencent.mm.plugin.editor.model.a.j)locala).urG = true;
        locala.urM = false;
        paramWXRTEditText = c.cRT();
        paramWXRTEditText.usy = (j - i + paramWXRTEditText.usy);
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
      paramInt = c.cRT().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.cRT().fU(paramInt - 1, paramInt + 1);
      break;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181836);
    try
    {
      this.utR.cRp().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.utR.cRp().a(paramWXRTEditText);
    AppMethodBeat.o(181840);
  }
  
  public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(181843);
    WXRTEditText localWXRTEditText = cSt();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().tH;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.cSm();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.cSn();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(181843);
        return;
      }
      localWXRTEditText.utx = true;
      localWXRTEditText.urQ = paramt.cSW();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(181843);
  }
  
  public final void cRO()
  {
    AppMethodBeat.i(181839);
    this.utR.cRp().cRa();
    AppMethodBeat.o(181839);
  }
  
  public final WXRTEditText cSt()
  {
    AppMethodBeat.i(181833);
    c.cRT().T(this.utQ);
    if (this.utQ == null)
    {
      AppMethodBeat.o(181833);
      return null;
    }
    Iterator localIterator = this.utQ.iterator();
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
  
  public final WXRTEditText cSv()
  {
    AppMethodBeat.i(181842);
    WXRTEditText localWXRTEditText = cSt();
    if ((localWXRTEditText == null) && (this.utQ.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.utQ.get(this.utQ.size() - 1);
      AppMethodBeat.o(181842);
      return localWXRTEditText;
    }
    AppMethodBeat.o(181842);
    return localWXRTEditText;
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181834);
    this.utR.cRp().e(paramBoolean, paramLong);
    AppMethodBeat.o(181834);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181832);
    paramWXRTEditText.a(this);
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.utY);
    AppMethodBeat.o(181832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.j
 * JD-Core Version:    0.7.0.1
 */