package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i
  implements aa<y>
{
  private final c.a KDC = new p.a()
  {
    public final void ck(String paramAnonymousString)
    {
      AppMethodBeat.i(168763);
      if (i.this.KDP != null) {
        try
        {
          i.this.KDV.a(i.this.KDP.getEditableText(), false);
          AppMethodBeat.o(168763);
          return;
        }
        catch (Exception paramAnonymousString) {}
      }
      AppMethodBeat.o(168763);
    }
  };
  public volatile i.c KDG;
  private volatile a KDH;
  public volatile b KDI;
  final View.OnFocusChangeListener KDJ = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136369);
      if (paramAnonymousBoolean) {
        o.b((com.tencent.mm.plugin.appbrand.page.aa)i.this.KDO.get(), i.this);
      }
      i.a(i.this, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && ((!i.this.KDN.mgv) || (r.cK(i.this.KDP)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (i.this.KDP != null) && (i.this.KDQ != null))
        {
          i.this.KDP.requestFocus();
          i.this.KDQ.show();
        }
        AppMethodBeat.o(136369);
        return;
      }
    }
  };
  private int KDK = -1;
  private int KDL = -1;
  i.d KDM = null;
  public com.tencent.mm.plugin.appbrand.widget.input.d.e KDN;
  protected WeakReference<com.tencent.mm.plugin.appbrand.page.aa> KDO;
  public y KDP;
  w KDQ;
  private v KDR;
  private final Runnable KDS = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136371);
      i.c(i.this);
      AppMethodBeat.o(136371);
    }
  };
  int KDT;
  int KDU;
  public final com.tencent.mm.plugin.appbrand.widget.input.c.a KDV = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
  boolean KDW = false;
  final Runnable KDX = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136372);
      i.this.KDW = false;
      AppMethodBeat.o(136372);
    }
  };
  private final w.d KDY = new w.d()
  {
    public final boolean NL(String paramAnonymousString)
    {
      AppMethodBeat.i(136364);
      if (i.this.KDP != null)
      {
        if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramAnonymousString)) {
          break label119;
        }
        paramAnonymousString = i.this.KDP;
        if (paramAnonymousString.mcL == null) {
          break label86;
        }
        if (!bt.ai(paramAnonymousString.getEditableText())) {
          paramAnonymousString.mcL.deleteSurroundingText(paramAnonymousString.getEditableText().length(), paramAnonymousString.getEditableText().length() - 1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(136364);
        return true;
        label86:
        paramAnonymousString.dispatchKeyEvent(new KeyEvent(0, 67));
        paramAnonymousString.dispatchKeyEvent(new KeyEvent(1, 67));
      }
      label119:
      y localy = i.this.KDP;
      f.bsU();
      if (localy.getEditableText() == null) {
        localy.setText(paramAnonymousString, TextView.BufferType.EDITABLE);
      }
      for (;;)
      {
        localy.setSelection(localy.getEditableText().length());
        break;
        localy.getEditableText().append(paramAnonymousString);
      }
    }
  };
  private final w.c KDZ = new w.c()
  {
    public final void bM(boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136365);
      if (paramAnonymousBoolean) {
        i.this.KDM = i.d.mbs;
      }
      i.f(i.this);
      i.this.KDM = null;
      AppMethodBeat.o(136365);
    }
  };
  private final w.e KEa = new w.e()
  {
    public final void gI(int paramAnonymousInt)
    {
      AppMethodBeat.i(136366);
      ad.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (paramAnonymousInt != 2)
      {
        if ((paramAnonymousInt == 0) && (i.this.KDP != null)) {
          i.this.KDP.requestFocus();
        }
        i.g(i.this);
        if ((i.this.KDO != null) && (i.this.KDO.get() != null))
        {
          o.a((com.tencent.mm.plugin.appbrand.page.aa)i.this.KDO.get(), i.this.KDP);
          AppMethodBeat.o(136366);
        }
      }
      else
      {
        i.this.KDM = i.d.mbr;
        i.f(i.this);
        i.this.KDM = null;
      }
      AppMethodBeat.o(136366);
    }
  };
  final ap kFL = new ap(Looper.getMainLooper());
  public int mba;
  
  private v bsT()
  {
    if (this.KDR != null) {
      return this.KDR;
    }
    if (this.KDO != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    if ((((com.tencent.mm.plugin.appbrand.page.aa)localObject).jhz == null) || (!android.support.v4.view.t.aC(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jhz))) {
      return null;
    }
    Object localObject = v.de(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jhz);
    this.KDR = ((v)localObject);
    return localObject;
  }
  
  private void fRc()
  {
    if (this.KDP == null) {
      break label7;
    }
    label7:
    while ((this.KDP.getLineCount() == this.KDK) && (this.KDP.btG() == this.KDL)) {
      return;
    }
    if (this.KDK == -1) {}
    for (int i = 1;; i = 0)
    {
      this.KDK = this.KDP.getLineCount();
      this.KDL = this.KDP.btG();
      if (this.KDG != null) {
        this.KDG.dO(this.KDK, this.KDL);
      }
      if ((!this.KDN.mgP.booleanValue()) || (i != 0)) {
        break;
      }
      this.KDT = (aj.j(this.KDN.mgB) + aj.j(this.KDN.mgA));
      fRa();
      this.KDU = (aj.j(this.KDN.mgB) + aj.j(this.KDN.mgA));
      yu(true);
      return;
    }
  }
  
  private void fRd()
  {
    if (this.KDN.mgP.booleanValue()) {
      fRi();
    }
    if ((this.KDQ != null) && (this.KDP != null))
    {
      this.KDQ.mdc = this.KDP;
      this.KDQ.setShowDoneButton(aj.g(this.KDN.mgQ));
      fRg();
      if ((r.cK(this.KDP)) && (this.KDP.hasFocus())) {
        this.KDQ.show();
      }
    }
  }
  
  private void fRe()
  {
    this.KDQ.b(this.KDP);
    a(this.KDP);
    this.KDP.destroy();
    onDestroy();
  }
  
  private void fRf()
  {
    boolean bool3 = true;
    com.tencent.mm.plugin.appbrand.page.aa localaa;
    boolean bool1;
    label33:
    boolean bool2;
    if (this.KDO == null)
    {
      localaa = null;
      if (this.KDQ == null) {
        fRi();
      }
      if (this.KDP != null) {
        break label116;
      }
      bool1 = true;
      if (localaa != null) {
        break label121;
      }
      bool2 = true;
      label40:
      if (this.KDQ != null) {
        break label126;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((localaa != null) && (this.KDP != null) && (this.KDQ != null)) {
        break label131;
      }
      return;
      localaa = (com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get();
      break;
      label116:
      bool1 = false;
      break label33;
      label121:
      bool2 = false;
      break label40;
      label126:
      bool3 = false;
    }
    label131:
    o.a(localaa, this.KDP);
    final PBool localPBool = new PBool();
    localPBool.value = false;
    final Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136361);
        ad.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
        localPBool.value = true;
        if (i.this.KDO == null) {}
        for (com.tencent.mm.plugin.appbrand.page.aa localaa = null; (localaa == null) || (i.this.KDP == null); localaa = (com.tencent.mm.plugin.appbrand.page.aa)i.this.KDO.get())
        {
          AppMethodBeat.o(136361);
          return;
        }
        if (o.z(localaa) != i.this)
        {
          AppMethodBeat.o(136361);
          return;
        }
        ad.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
        h.bsW().d(localaa.kWU);
        aj.dm(i.this.KDP);
        if ((i.this.KDQ != null) && (i.this.KDQ.b(null))) {
          i.this.KDQ.hide();
        }
        i.this.KDP.a(i.this.KDJ);
        i.this.KDP.setFocusable(true);
        i.this.KDP.setFocusableInTouchMode(true);
        i.this.KDQ.mdc = i.this.KDP;
        i.this.KDP.requestFocus();
        aj.dm(i.this.KDP);
        if (i.this.KDQ != null) {
          i.this.KDQ.show();
        }
        AppMethodBeat.o(136361);
      }
    };
    Object localObject = com.tencent.mm.sdk.f.a.iV(localaa.getContext());
    if ((localObject != null) && (((Activity)localObject).getCurrentFocus() != null))
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      bool1 = aj.dl((View)localObject).isActive((View)localObject);
      bool2 = aj.h(localaa.kWU.getWrapperView(), (View)localObject);
      if ((bool1) && (bool2))
      {
        ad.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
        this.KDQ.setOnVisibilityChangedListener(new w.e()
        {
          public final void gI(int paramAnonymousInt)
          {
            AppMethodBeat.i(136362);
            if ((localPBool.value) || (paramAnonymousInt != 2))
            {
              AppMethodBeat.o(136362);
              return;
            }
            local3.run();
            AppMethodBeat.o(136362);
          }
        });
        com.tencent.e.h.Iye.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136363);
            if (localPBool.value)
            {
              AppMethodBeat.o(136363);
              return;
            }
            local3.run();
            AppMethodBeat.o(136363);
          }
        }, 100L);
        return;
      }
    }
    local3.run();
  }
  
  private void fRg()
  {
    if (this.KDQ == null) {
      return;
    }
    this.KDQ.setOnSmileyChosenListener(this.KDY);
    this.KDQ.setOnDoneListener(this.KDZ);
    this.KDQ.setOnVisibilityChangedListener(this.KEa);
  }
  
  private void fRh()
  {
    Object localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get();
    if (!android.support.v4.view.t.aC(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jhz)) {}
    label169:
    label300:
    label324:
    for (;;)
    {
      return;
      this.KDQ = w.dh(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jhz);
      if (this.KDN.mgv)
      {
        fRg();
        fRj();
      }
      this.KDP.a(this.KDJ);
      this.KDP.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(136367);
          paramAnonymousView = i.this;
          boolean bool;
          if (67 == paramAnonymousInt)
          {
            bool = true;
            paramAnonymousView.KDW = bool;
            if (!i.this.KDW) {
              break label86;
            }
            i.this.kFL.removeCallbacks(i.this.KDX);
            i.this.kFL.postDelayed(i.this.KDX, 1000L);
          }
          for (;;)
          {
            AppMethodBeat.o(136367);
            return false;
            bool = false;
            break;
            label86:
            i.this.KDX.run();
          }
        }
      });
      if (this.KDN.mgv) {
        o.a((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get(), this.KDP);
      }
      localObject = this.KDQ;
      boolean bool;
      if ((!this.KDN.cog) && ("emoji".equals(this.KDN.cod)))
      {
        bool = true;
        ((w)localObject).setCanSmileyInput(bool);
        if (this.KDN.mgP.booleanValue()) {
          break label281;
        }
        if (this.KDN.mgU != null) {
          break label270;
        }
        localObject = com.tencent.mm.plugin.appbrand.widget.input.d.b.buh();
        final int i = ((com.tencent.mm.plugin.appbrand.widget.input.d.b)localObject).mgo;
        this.KDP.setImeOptions(i);
        this.KDP.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(136368);
            if (paramAnonymousInt == i)
            {
              i.this.KDM = i.d.mbs;
              i.f(i.this);
              i.this.KDM = null;
              AppMethodBeat.o(136368);
              return true;
            }
            AppMethodBeat.o(136368);
            return false;
          }
        });
        label198:
        this.KDQ.setShowDoneButton(this.KDN.mgQ.booleanValue());
        this.KDQ.mdc = this.KDP;
        if (!this.KDN.mgv) {
          break label300;
        }
        fRf();
      }
      for (;;)
      {
        if (!this.KDN.mgv) {
          break label324;
        }
        k.a(this.KDO).uT(this.mba);
        return;
        bool = false;
        break;
        localObject = this.KDN.mgU;
        break label169;
        this.KDP.setOnEditorActionListener(null);
        this.KDP.setImeOptions(0);
        break label198;
        this.KDP.setFocusable(false);
        this.KDP.setFocusableInTouchMode(false);
        this.KDQ.hide();
      }
    }
  }
  
  private w fRi()
  {
    if (this.KDQ != null) {
      return this.KDQ;
    }
    if (this.KDO != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = w.dg(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jhz);
    this.KDQ = ((w)localObject);
    return localObject;
  }
  
  private void fRj()
  {
    if (bsT() != null) {
      this.KDR.setVisibility(8);
    }
  }
  
  private void ja(int paramInt1, int paramInt2)
  {
    b.a(this.KDP, paramInt1, paramInt2);
    yu(false);
  }
  
  private void onDestroy()
  {
    this.KDP = null;
    com.tencent.mm.plugin.appbrand.utils.e.bk(this);
  }
  
  private void yu(boolean paramBoolean)
  {
    if ((this.KDN.mgP.booleanValue()) && (this.KDQ != null) && (this.KDQ.isShown()) && (this.KDP != null) && (this.KDP == this.KDQ.getAttachedEditText()))
    {
      if (!paramBoolean) {
        break label204;
      }
      if ((this.KDO == null) || (this.KDO.get() == null) || (((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).bjD() == null)) {
        break label219;
      }
      i = ((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).bjD().getMeasuredHeight();
    }
    label204:
    label219:
    for (int i = ((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).bjD().getScrollY() + i;; i = 0)
    {
      if (((this.KDU > this.KDT) && (this.KDU - this.KDP.getLineHeight() <= i)) || ((this.KDU <= this.KDT) && (this.KDU + this.KDP.getLineHeight() <= i)) || (this.KDP.btG() >= i)) {
        k.a(this.KDO).uT(this.mba);
      }
      return;
      k.a(this.KDO).uT(this.mba);
      return;
    }
  }
  
  private void yv(boolean paramBoolean)
  {
    if (this.KDP == null) {
      return;
    }
    String str = this.KDP.getText().toString();
    int i = this.KDP.getSelectionEnd();
    if (this.KDM == i.d.mbs) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, i, bool, paramBoolean);
      return;
    }
  }
  
  public abstract void Id(String paramString);
  
  void a(y paramy)
  {
    if (paramy == null) {}
    label58:
    for (;;)
    {
      return;
      paramy.b(this.KDJ);
      if (this.KDO == null) {}
      for (Object localObject = null;; localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((com.tencent.mm.plugin.appbrand.page.aa)localObject).bjD();
        if (localObject == null) {
          break;
        }
        ((g)localObject).cY(paramy);
        return;
      }
    }
  }
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final void a(String paramString, Integer paramInteger)
  {
    if (this.KDP == null) {
      return;
    }
    this.KDP.D(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      ja(paramString.intValue(), paramString.intValue());
      fRc();
      return;
    }
  }
  
  boolean a(y paramy, com.tencent.mm.plugin.appbrand.widget.input.d.e parame)
  {
    if ((paramy == null) || (this.KDO == null) || (this.KDO.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).bjD();
    return (localg != null) && (localg.a(((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).kWU, paramy, parame.mgz.intValue(), parame.mgA.intValue(), parame.mgC.intValue(), parame.mgB.intValue()));
  }
  
  public abstract void aZY();
  
  public abstract void aZZ();
  
  public boolean b(y paramy, com.tencent.mm.plugin.appbrand.widget.input.d.e parame)
  {
    if ((paramy == null) || (this.KDO == null) || (this.KDO.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).bjD();
    return (localg != null) && (localg.c(((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).kWU, paramy, parame.mgz.intValue(), parame.mgA.intValue(), parame.mgC.intValue(), parame.mgB.intValue()));
  }
  
  public final boolean bsL()
  {
    int i;
    if ((this.KDP == null) || (this.KDO == null) || (this.KDO.get() == null)) {
      i = 0;
    }
    while (i != 0)
    {
      onDestroy();
      return true;
      this.KDP.destroy();
      g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).bjD();
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        if (this.KDP.hasFocus())
        {
          if (this.KDR != null) {
            this.KDR.setVisibility(8);
          }
          fRi();
          if (this.KDQ != null) {
            this.KDQ.setVisibility(8);
          }
        }
        localg.cY(this.KDP);
        i = 1;
      }
    }
    return false;
  }
  
  public final boolean bsQ()
  {
    return (this.KDN != null) && (aj.g(this.KDN.mgW));
  }
  
  public final int bsR()
  {
    if ((this.KDN != null) && (this.KDN.mgT != null)) {
      return this.KDN.mgT.intValue();
    }
    if ((this.KDP != null) && (this.KDP.bto())) {
      return 5;
    }
    return 0;
  }
  
  public final boolean bsS()
  {
    int i;
    if ((this.KDP != null) && ((this.KDP.isFocused()) || ((fRi() != null) && (fRi().getAttachedEditText() == this.KDP))))
    {
      i = 1;
      if (i != 0) {
        break label129;
      }
      if ((this.KDO != null) && (this.KDO.get() != null)) {
        break label83;
      }
      i = 0;
      label63:
      if (i == 0) {
        break label129;
      }
      ad.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
    }
    label83:
    Object localObject;
    label129:
    do
    {
      return true;
      i = 0;
      break;
      localObject = ((com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get()).getContext();
      if ((localObject instanceof Activity))
      {
        if (((Activity)localObject).getCurrentFocus() != null)
        {
          i = 1;
          break label63;
        }
        i = 0;
        break label63;
      }
      i = 0;
      break label63;
      localObject = fRi();
    } while (localObject == null);
    ((w)localObject).setVisibility(8);
    return true;
  }
  
  public final boolean er(int paramInt1, int paramInt2)
  {
    if ((this.KDP == null) || (this.KDO == null) || (this.KDO.get() == null)) {}
    for (;;)
    {
      ja(paramInt1, paramInt2);
      return true;
      this.KDP.performClick();
    }
  }
  
  final void fRa()
  {
    int k;
    int i;
    if ((this.KDP != null) && (aj.g(this.KDN.mgR)) && (aj.g(this.KDN.mgP)))
    {
      ((q)this.KDP).setAutoHeight(true);
      j = this.KDP.getLineHeight();
      k = this.KDP.btG();
      if ((this.KDN.mgD != null) && (this.KDN.mgD.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.KDN.mgE != null) && (this.KDN.mgE.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.KDN.mgE.intValue(), j))
    {
      this.KDP.setMinHeight(i);
      this.KDP.setMaxHeight(j);
      this.KDN.mgA = Integer.valueOf(Math.max(i, Math.min(k, j)));
      b(this.KDP, this.KDN);
      return;
      i = this.KDN.mgD.intValue();
      break;
    }
  }
  
  public final void fRb()
  {
    b.a(this.KDP, this.KDN);
    if (this.KDN.mgI == null)
    {
      this.KDN.mgI = Integer.valueOf(140);
      c localc = p.a(this.KDP).aaj(this.KDN.mgI.intValue());
      localc.HuM = false;
      localc.mcf = f.a.Hrl;
      localc.a(this.KDC);
      this.KDP.setPasswordMode(this.KDN.cog);
      if (!aj.g(this.KDN.mgN)) {
        break label236;
      }
      this.KDP.setEnabled(false);
      this.KDP.setFocusable(false);
      this.KDP.setFocusableInTouchMode(false);
      this.KDP.setClickable(false);
    }
    for (;;)
    {
      if ((this.KDP instanceof q))
      {
        if (this.KDN.mgX != null) {
          ((q)this.KDP).setLineSpace(this.KDN.mgX.intValue());
        }
        if (this.KDN.mgY != null) {
          ((q)this.KDP).setLineHeight(this.KDN.mgY.intValue());
        }
      }
      return;
      if (this.KDN.mgI.intValue() > 0) {
        break;
      }
      this.KDN.mgI = Integer.valueOf(2147483647);
      break;
      label236:
      this.KDP.setEnabled(true);
      this.KDP.setClickable(true);
    }
  }
  
  public final int getInputId()
  {
    return this.mba;
  }
  
  public final <P extends View,  extends ac> P getInputPanel()
  {
    return this.KDQ;
  }
  
  public final void kA(int paramInt1, int paramInt2)
  {
    this.KDO = this.KDN.mar;
    if (this.KDO == null) {}
    for (com.tencent.mm.plugin.appbrand.page.aa localaa = null; (localaa == null) || (localaa.kWU == null); localaa = (com.tencent.mm.plugin.appbrand.page.aa)this.KDO.get())
    {
      ad.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      aZZ();
      return;
    }
    if (aj.g(this.KDN.mgP)) {}
    for (Object localObject = new q(localaa.getContext());; localObject = new t(localaa.getContext()))
    {
      this.KDP = ((y)localObject);
      this.mba = this.KDN.mao;
      this.KDP.setInputId(this.mba);
      o.b(localaa, this);
      fRb();
      this.KDP.setText(bt.nullAsNil(this.KDN.mgy));
      if (aj.g(this.KDN.mgR)) {
        fRc();
      }
      this.KDP.addTextChangedListener(new com.tencent.mm.ui.widget.g()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(136373);
          if ((i.this.KDO == null) || (i.this.KDO.get() == null) || (i.this.KDP == null))
          {
            AppMethodBeat.o(136373);
            return;
          }
          i.b(i.this);
          if (aj.F(paramAnonymousEditable))
          {
            ad.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramAnonymousEditable });
            AppMethodBeat.o(136373);
            return;
          }
          ad.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramAnonymousEditable });
          paramAnonymousEditable = i.this.KDP.getEditableText();
          i.this.KDV.a(paramAnonymousEditable, i.this.KDW);
          AppMethodBeat.o(136373);
        }
      });
      this.KDP.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b()
      {
        public final void Cj()
        {
          AppMethodBeat.i(136374);
          if (i.this.KDP == null)
          {
            AppMethodBeat.o(136374);
            return;
          }
          ad.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.this.KDP.getEditableText() });
          i.this.KDV.a(i.this.KDP.getEditableText(), false);
          AppMethodBeat.o(136374);
        }
      });
      this.KDP.setOnKeyUpPostImeListener(new ab.b()
      {
        public final boolean uR(int paramAnonymousInt)
        {
          AppMethodBeat.i(136375);
          if (paramAnonymousInt == 67)
          {
            if (aj.F(i.this.KDP.getText()))
            {
              AppMethodBeat.o(136375);
              return false;
            }
            i.this.Id(i.this.KDP.getText().toString());
            AppMethodBeat.o(136375);
            return true;
          }
          AppMethodBeat.o(136375);
          return false;
        }
      });
      if (a(this.KDP, this.KDN)) {
        break;
      }
      ad.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      aZZ();
      return;
    }
    if ((this.KDN.mgx != null) && (!bt.gL(this.KDN.mgx.mgi))) {
      d.a(localaa, this.KDP, this.KDN.mgx);
    }
    if (!aj.g(this.KDN.mgP)) {
      b.a(this.KDP, paramInt1, paramInt2);
    }
    if (aj.g(this.KDN.mgP)) {
      this.KDP.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136376);
          i.b(i.this);
          AppMethodBeat.o(136376);
        }
      });
    }
    if (("text".equalsIgnoreCase(this.KDN.cod)) || ("emoji".equalsIgnoreCase(this.KDN.cod))) {
      fRh();
    }
    for (;;)
    {
      this.KDP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(136360);
          if (i.this.KDP == null)
          {
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.KDP.hasFocus())
          {
            i.d(i.this);
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.KDP == paramAnonymousView) {
            i.e(i.this);
          }
          AppMethodBeat.o(136360);
        }
      });
      aZY();
      return;
      Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.KDN.cod }), true);
      fRh();
    }
  }
  
  public final boolean u(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    return (paramaa != null) && (this.KDO != null) && (paramaa == this.KDO.get());
  }
  
  public final void uQ(int paramInt)
  {
    b localb = this.KDI;
    if (localb != null) {
      localb.a(this, paramInt);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void a(aa paramaa, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i
 * JD-Core Version:    0.7.0.1
 */