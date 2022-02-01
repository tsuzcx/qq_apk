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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.e.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g.a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i
  implements ae<ac>
{
  private v AQH;
  long BVc;
  private final Runnable BVe = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136371);
      i.c(i.this);
      AppMethodBeat.o(136371);
    }
  };
  int BVf;
  int BVg;
  private final aa.f CEl = new aa.f()
  {
    public final void iJ(int paramAnonymousInt)
    {
      AppMethodBeat.i(136366);
      Log.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (paramAnonymousInt != 2)
      {
        if ((paramAnonymousInt == 0) && (i.this.xvc != null)) {
          i.this.xvc.requestFocus();
        }
        i.g(i.this);
        if ((i.this.xuZ != null) && (i.this.xuZ.get() != null))
        {
          o.a((ad)i.this.xuZ.get(), i.this.xvc);
          AppMethodBeat.o(136366);
        }
      }
      else
      {
        i.this.rKk = i.d.ruQ;
        i.f(i.this);
        i.this.rKk = null;
      }
      AppMethodBeat.o(136366);
    }
  };
  public final com.tencent.mm.plugin.appbrand.widget.input.c.a Cwo = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
  boolean Cws = false;
  final Runnable Cwt = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136372);
      i.this.Cws = false;
      AppMethodBeat.o(136372);
    }
  };
  private final aa.e Cwu = new aa.e()
  {
    public final boolean dO(String paramAnonymousString)
    {
      AppMethodBeat.i(136364);
      if (i.this.xvc != null)
      {
        if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramAnonymousString)) {
          break label41;
        }
        i.this.xvc.coS();
      }
      for (;;)
      {
        AppMethodBeat.o(136364);
        return true;
        label41:
        i.this.xvc.N(paramAnonymousString);
      }
    }
  };
  private final aa.c CyB = new aa.c()
  {
    public final void cz(boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136365);
      if (paramAnonymousBoolean) {
        i.this.rKk = i.d.ruS;
      }
      i.f(i.this);
      i.this.rKk = null;
      AppMethodBeat.o(136365);
    }
  };
  final aa.d Dpn = new aa.d()
  {
    public final EditText getEditText()
    {
      return i.this.xvc;
    }
    
    public final void jj(int paramAnonymousInt)
    {
      AppMethodBeat.i(214058);
      if (Util.ticksToNow(i.this.BVc) > 50L) {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(214445);
            if (i.this.xuZ == null)
            {
              Log.e("MicroMsg.AppBrandInputInvokeHandler", "postDelayed scroll up found page is null");
              AppMethodBeat.o(214445);
              return;
            }
            k.a(i.this.xuZ).e(i.this.ruw, false, false);
            i.this.BVc = Util.currentTicks();
            AppMethodBeat.o(214445);
          }
        }, 50L);
      }
      AppMethodBeat.o(214058);
    }
  };
  final MMHandler pRi = new MMHandler(Looper.getMainLooper());
  public volatile c rHc;
  private volatile a rHd;
  public volatile b rHe;
  final View.OnFocusChangeListener rHf = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136369);
      if (paramAnonymousBoolean) {
        o.b((ad)i.this.xuZ.get(), i.this);
      }
      i.a(i.this, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && ((!i.this.tTZ.rAe) || (x.dc(i.this.xvc)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (i.this.xvc != null) && (i.this.yCH != null))
        {
          i.this.xvc.requestFocus();
          i.this.yCH.a(i.this.Dpn);
          i.this.yCH.show();
        }
        AppMethodBeat.o(136369);
        return;
      }
    }
  };
  private int rHg = -1;
  private int rKj = -1;
  i.d rKk = null;
  private final c.a ruH = new p.a()
  {
    public final void dN(String paramAnonymousString)
    {
      AppMethodBeat.i(168763);
      if (i.this.xvc != null) {
        try
        {
          i.this.Cwo.b(i.this.xvc.getEditableText(), false);
          AppMethodBeat.o(168763);
          return;
        }
        catch (Exception paramAnonymousString) {}
      }
      AppMethodBeat.o(168763);
    }
  };
  public int ruw;
  public e tTZ;
  protected WeakReference<ad> xuZ;
  public ac xvc;
  aa yCH;
  
  private void ck(boolean paramBoolean)
  {
    if ((this.tTZ.rAz.booleanValue()) && (this.yCH != null) && (this.yCH.isShown()) && (this.xvc != null) && (this.xvc == this.yCH.getAttachedEditText()))
    {
      if (!paramBoolean) {
        break label204;
      }
      if ((this.xuZ == null) || (this.xuZ.get() == null) || (((ad)this.xuZ.get()).cdU() == null)) {
        break label219;
      }
      i = ((ad)this.xuZ.get()).cdU().getMeasuredHeight();
    }
    label204:
    label219:
    for (int i = ((ad)this.xuZ.get()).cdU().getScrollY() + i;; i = 0)
    {
      if (((this.BVg > this.BVf) && (this.BVg - this.xvc.getLineHeight() <= i)) || ((this.BVg <= this.BVf) && (this.BVg + this.xvc.getLineHeight() <= i)) || (this.xvc.cpa() >= i)) {
        k.a(this.xuZ).DM(this.ruw);
      }
      return;
      k.a(this.xuZ).DM(this.ruw);
      return;
    }
  }
  
  private v com()
  {
    if (this.AQH != null) {
      return this.AQH;
    }
    if (this.xuZ != null)
    {
      localObject = (ad)this.xuZ.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    if ((((ad)localObject).getContentView() == null) || (!w.al(((ad)localObject).getContentView()))) {
      return null;
    }
    Object localObject = v.dt(((ad)localObject).getContentView());
    this.AQH = ((v)localObject);
    return localObject;
  }
  
  private void cos()
  {
    if (this.xvc == null) {
      break label7;
    }
    label7:
    while ((this.xvc.getLineCount() == this.rHg) && (this.xvc.cpa() == this.rKj)) {
      return;
    }
    if (this.rHg == -1) {}
    for (int i = 1;; i = 0)
    {
      this.rHg = this.xvc.getLineCount();
      this.rKj = this.xvc.cpa();
      if (this.rHc != null) {
        this.rHc.eB(this.rHg, this.rKj);
      }
      if ((!this.tTZ.rAz.booleanValue()) || (i != 0)) {
        break;
      }
      this.BVf = (an.m(this.tTZ.rAl) + an.m(this.tTZ.rAk));
      coq();
      this.BVg = (an.m(this.tTZ.rAl) + an.m(this.tTZ.rAk));
      ck(true);
      return;
    }
  }
  
  private void cot()
  {
    if (this.tTZ.rAz.booleanValue()) {
      cox();
    }
    if ((this.yCH != null) && (this.xvc != null))
    {
      this.yCH.rwP = this.xvc;
      this.yCH.setComponentView(this.tTZ.rAQ.booleanValue());
      this.yCH.coX();
      this.yCH.setShowDoneButton(an.m(this.tTZ.rAA));
      cow();
      if ((x.dc(this.xvc)) && (this.xvc.hasFocus()))
      {
        this.yCH.a(this.Dpn);
        this.yCH.show();
      }
    }
  }
  
  private void cou()
  {
    this.yCH.b(this.xvc);
    a(this.xvc);
    this.xvc.destroy();
    onDestroy();
  }
  
  private void cov()
  {
    boolean bool3 = true;
    ad localad;
    boolean bool1;
    label33:
    boolean bool2;
    if (this.xuZ == null)
    {
      localad = null;
      if (this.yCH == null) {
        cox();
      }
      if (this.xvc != null) {
        break label116;
      }
      bool1 = true;
      if (localad != null) {
        break label121;
      }
      bool2 = true;
      label40:
      if (this.yCH != null) {
        break label126;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((localad != null) && (this.xvc != null) && (this.yCH != null)) {
        break label131;
      }
      return;
      localad = (ad)this.xuZ.get();
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
    o.a(localad, this.xvc);
    final PBool localPBool = new PBool();
    localPBool.value = false;
    final Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136361);
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
        localPBool.value = true;
        if (i.this.xuZ == null) {}
        for (ad localad = null; (localad == null) || (i.this.xvc == null); localad = (ad)i.this.xuZ.get())
        {
          AppMethodBeat.o(136361);
          return;
        }
        if (o.F(localad) != i.this)
        {
          AppMethodBeat.o(136361);
          return;
        }
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
        h.cop().d(localad.qoF);
        an.dC(i.this.xvc);
        if ((i.this.yCH != null) && (i.this.yCH.b(null)))
        {
          i.this.yCH.b(i.this.Dpn);
          i.this.yCH.hide();
        }
        i.this.xvc.a(i.this.rHf);
        i.this.xvc.setFocusable(true);
        i.this.xvc.setFocusableInTouchMode(true);
        i.this.yCH.rwP = i.this.xvc;
        i.this.xvc.requestFocus();
        an.dC(i.this.xvc);
        if (i.this.yCH != null)
        {
          i.this.yCH.a(i.this.Dpn);
          i.this.yCH.show();
        }
        AppMethodBeat.o(136361);
      }
    };
    Object localObject = AndroidContextUtil.castActivityOrNull(localad.getContext());
    if ((localObject != null) && (((Activity)localObject).getCurrentFocus() != null))
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      bool1 = an.dB((View)localObject).isActive((View)localObject);
      bool2 = an.i(localad.qoF.getWrapperView(), (View)localObject);
      if ((bool1) && (bool2))
      {
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
        this.yCH.setOnVisibilityChangedListener(new aa.f()
        {
          public final void iJ(int paramAnonymousInt)
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
        com.tencent.e.h.ZvG.n(new Runnable()
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
  
  private void cow()
  {
    if (this.yCH == null) {
      return;
    }
    this.yCH.setOnSmileyChosenListener(this.Cwu);
    this.yCH.setOnDoneListener(this.CyB);
    this.yCH.setOnVisibilityChangedListener(this.CEl);
  }
  
  private aa cox()
  {
    if (this.yCH != null) {
      return this.yCH;
    }
    if (this.xuZ != null)
    {
      localObject = (ad)this.xuZ.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = aa.dw(((ad)localObject).getContentView());
    this.yCH = ((aa)localObject);
    return localObject;
  }
  
  private void coy()
  {
    if (com() != null) {
      this.AQH.setVisibility(8);
    }
  }
  
  private void fh(int paramInt1, int paramInt2)
  {
    b.a(this.xvc, paramInt1, paramInt2);
    ck(false);
  }
  
  private void ko(boolean paramBoolean)
  {
    Object localObject = (ad)this.xuZ.get();
    if (!w.al(((ad)localObject).getContentView())) {}
    label404:
    for (;;)
    {
      return;
      this.yCH = aa.b(((ad)localObject).getContentView(), ((ad)localObject).cef());
      this.yCH.setComponentView(this.tTZ.rAQ.booleanValue());
      this.yCH.coX();
      if (this.tTZ.rAe)
      {
        cow();
        coy();
      }
      this.xvc.a(this.rHf);
      this.xvc.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(213972);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.bn(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
          paramAnonymousView = i.this;
          boolean bool;
          if (67 == paramAnonymousInt)
          {
            bool = true;
            paramAnonymousView.Cws = bool;
            if (!i.this.Cws) {
              break label143;
            }
            i.this.pRi.removeCallbacks(i.this.Cwt);
            i.this.pRi.postDelayed(i.this.Cwt, 1000L);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(213972);
            return false;
            bool = false;
            break;
            label143:
            i.this.Cwt.run();
          }
        }
      });
      if (this.tTZ.rAe) {
        o.a((ad)this.xuZ.get(), this.xvc);
      }
      localObject = this.yCH;
      final int i;
      if ((!this.tTZ.cKX) && (paramBoolean))
      {
        paramBoolean = true;
        ((aa)localObject).setCanSmileyInput(paramBoolean);
        if (this.tTZ.rAE != null) {
          break label318;
        }
        i = com.tencent.mm.plugin.appbrand.widget.input.e.b.kv(this.tTZ.rAz.booleanValue()).rzY;
        label185:
        Log.d("MicroMsg.AppBrandInputInvokeHandler", "initSmileyPanelAndShow, myImeOption: ".concat(String.valueOf(i)));
        localObject = null;
        if ((!this.tTZ.rAz.booleanValue()) || (i != 0)) {
          localObject = new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(214012);
              if (paramAnonymousInt == i)
              {
                i.this.rKk = i.d.ruR;
                i.f(i.this);
                i.this.rKk = null;
                AppMethodBeat.o(214012);
                return true;
              }
              AppMethodBeat.o(214012);
              return false;
            }
          };
        }
        this.xvc.setImeOptions(i);
        this.xvc.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
        this.yCH.setShowDoneButton(this.tTZ.rAA.booleanValue());
        this.yCH.rwP = this.xvc;
        if (!this.tTZ.rAe) {
          break label369;
        }
        cov();
      }
      for (;;)
      {
        if (!this.tTZ.rAe) {
          break label404;
        }
        k.a(this.xuZ).DM(this.ruw);
        return;
        paramBoolean = false;
        break;
        label318:
        if ((!this.tTZ.rAz.booleanValue()) && (com.tencent.mm.plugin.appbrand.widget.input.e.b.rzX == this.tTZ.rAE)) {
          this.tTZ.rAE = com.tencent.mm.plugin.appbrand.widget.input.e.b.kv(false);
        }
        i = this.tTZ.rAE.rzY;
        break label185;
        label369:
        this.xvc.setFocusable(false);
        this.xvc.setFocusableInTouchMode(false);
        this.yCH.b(this.Dpn);
        this.yCH.hide();
      }
    }
  }
  
  private void kq(boolean paramBoolean)
  {
    if (this.xvc == null) {
      return;
    }
    String str = this.xvc.getText().toString();
    int i = this.xvc.getSelectionEnd();
    if ((i.d.ruR == this.rKk) || (i.d.ruS == this.rKk)) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, i, bool, paramBoolean);
      return;
    }
  }
  
  private void onDestroy()
  {
    this.xvc = null;
    com.tencent.mm.plugin.appbrand.utils.h.bs(this);
  }
  
  public final boolean A(ad paramad)
  {
    return (paramad != null) && (this.xuZ != null) && (paramad == this.xuZ.get());
  }
  
  public final void DJ(int paramInt)
  {
    b localb = this.rHe;
    if (localb != null) {
      localb.a(this, paramInt);
    }
  }
  
  void a(ac paramac)
  {
    if (paramac == null) {}
    label58:
    for (;;)
    {
      return;
      paramac.b(this.rHf);
      if (this.xuZ == null) {}
      for (Object localObject = null;; localObject = (ad)this.xuZ.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((ad)localObject).cdU();
        if (localObject == null) {
          break;
        }
        ((g)localObject).jdMethod_do(paramac);
        return;
      }
    }
  }
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final void a(String paramString, Integer paramInteger)
  {
    if (this.xvc == null) {
      return;
    }
    this.xvc.P(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      fh(paramString.intValue(), paramString.intValue());
      cos();
      return;
    }
  }
  
  boolean a(ac paramac, e parame)
  {
    if ((paramac == null) || (this.xuZ == null) || (this.xuZ.get() == null)) {
      return false;
    }
    g localg = (g)((ad)this.xuZ.get()).cdU();
    return (localg != null) && (localg.a(((ad)this.xuZ.get()).qoF, paramac, parame.rAj.intValue(), parame.rAk.intValue(), parame.rAm.intValue(), parame.rAl.intValue()));
  }
  
  public abstract void ahD(String paramString);
  
  public boolean b(ac paramac, e parame)
  {
    if ((paramac == null) || (this.xuZ == null) || (this.xuZ.get() == null)) {
      return false;
    }
    g localg = (g)((ad)this.xuZ.get()).cdU();
    return (localg != null) && (localg.c(((ad)this.xuZ.get()).qoF, paramac, parame.rAj.intValue(), parame.rAk.intValue(), parame.rAm.intValue(), parame.rAl.intValue()));
  }
  
  public abstract void bSj();
  
  public abstract void bSk();
  
  public final boolean cob()
  {
    int i;
    if ((this.xvc == null) || (this.xuZ == null) || (this.xuZ.get() == null)) {
      i = 0;
    }
    while (i != 0)
    {
      onDestroy();
      return true;
      this.xvc.destroy();
      g localg = (g)((ad)this.xuZ.get()).cdU();
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        if (this.xvc.hasFocus())
        {
          if (this.AQH != null) {
            this.AQH.setVisibility(8);
          }
          cox();
          if (this.yCH != null) {
            this.yCH.setVisibility(8);
          }
        }
        localg.jdMethod_do(this.xvc);
        i = 1;
      }
    }
    return false;
  }
  
  public final boolean coj()
  {
    return (this.tTZ != null) && (an.m(this.tTZ.rAG));
  }
  
  public final int cok()
  {
    if ((this.tTZ != null) && (this.tTZ.rAD != null)) {
      return this.tTZ.rAD.intValue();
    }
    if ((this.xvc != null) && (this.xvc.coH())) {
      return 5;
    }
    return 0;
  }
  
  public final boolean col()
  {
    int i;
    if ((this.xvc != null) && ((this.xvc.isFocused()) || ((cox() != null) && (cox().getAttachedEditText() == this.xvc))))
    {
      i = 1;
      if (i != 0) {
        break label129;
      }
      if ((this.xuZ != null) && (this.xuZ.get() != null)) {
        break label83;
      }
      i = 0;
      label63:
      if (i == 0) {
        break label129;
      }
      Log.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
    }
    label83:
    Object localObject;
    label129:
    do
    {
      return true;
      i = 0;
      break;
      localObject = ((ad)this.xuZ.get()).getContext();
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
      localObject = cox();
    } while (localObject == null);
    ((aa)localObject).setVisibility(8);
    return true;
  }
  
  final void coq()
  {
    int k;
    int i;
    if ((this.xvc != null) && (an.m(this.tTZ.rAB)) && (an.m(this.tTZ.rAz)))
    {
      ((q)this.xvc).setAutoHeight(true);
      j = this.xvc.getLineHeight();
      k = this.xvc.cpa();
      if ((this.tTZ.rAn != null) && (this.tTZ.rAn.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.tTZ.rAo != null) && (this.tTZ.rAo.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.tTZ.rAo.intValue(), j))
    {
      this.xvc.setMinHeight(i);
      this.xvc.setMaxHeight(j);
      this.tTZ.rAk = Integer.valueOf(Math.max(i, Math.min(k, j)));
      b(this.xvc, this.tTZ);
      return;
      i = this.tTZ.rAn.intValue();
      break;
    }
  }
  
  public final void cor()
  {
    b.a(this.xvc, this.tTZ);
    if (this.tTZ.rAs == null)
    {
      this.tTZ.rAs = Integer.valueOf(140);
      p.a(this.xvc).axx(this.tTZ.rAs.intValue()).Hh(false).b(g.a.XSt).a(this.ruH);
      this.xvc.setPasswordMode(this.tTZ.cKX);
      if (!an.m(this.tTZ.rAx)) {
        break label232;
      }
      this.xvc.setEnabled(false);
      this.xvc.setFocusable(false);
      this.xvc.setFocusableInTouchMode(false);
      this.xvc.setClickable(false);
    }
    for (;;)
    {
      if ((this.xvc instanceof q))
      {
        if (this.tTZ.rAI != null) {
          ((q)this.xvc).setLineSpace(this.tTZ.rAI.intValue());
        }
        if (this.tTZ.rAJ != null) {
          ((q)this.xvc).setLineHeight(this.tTZ.rAJ.intValue());
        }
      }
      return;
      if (this.tTZ.rAs.intValue() > 0) {
        break;
      }
      this.tTZ.rAs = Integer.valueOf(2147483647);
      break;
      label232:
      this.xvc.setEnabled(true);
      this.xvc.setClickable(true);
    }
  }
  
  public final int getInputId()
  {
    return this.ruw;
  }
  
  public final <P extends View,  extends ag> P getInputPanel()
  {
    return this.yCH;
  }
  
  public final void me(int paramInt1, int paramInt2)
  {
    this.xuZ = this.tTZ.rtP;
    if (this.xuZ == null) {}
    for (ad localad = null; (localad == null) || (localad.qoF == null); localad = (ad)this.xuZ.get())
    {
      Log.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      bSk();
      return;
    }
    if (an.m(this.tTZ.rAz)) {}
    for (Object localObject = new q(localad.getContext());; localObject = new t(localad.getContext()))
    {
      this.xvc = ((ac)localObject);
      this.ruw = this.tTZ.rtN;
      this.xvc.setInputId(this.ruw);
      o.b(localad, this);
      cor();
      this.xvc.setText(Util.nullAsNil(this.tTZ.rAi));
      if (an.m(this.tTZ.rAB)) {
        cos();
      }
      this.xvc.addTextChangedListener(new com.tencent.mm.ui.widget.i()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(136373);
          if ((i.this.xuZ == null) || (i.this.xuZ.get() == null) || (i.this.xvc == null))
          {
            AppMethodBeat.o(136373);
            return;
          }
          i.b(i.this);
          if (an.R(paramAnonymousEditable))
          {
            Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramAnonymousEditable });
            AppMethodBeat.o(136373);
            return;
          }
          Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramAnonymousEditable });
          paramAnonymousEditable = i.this.xvc.getEditableText();
          i.this.Cwo.b(paramAnonymousEditable, i.this.Cws);
          AppMethodBeat.o(136373);
        }
      });
      this.xvc.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b()
      {
        public final void PD()
        {
          AppMethodBeat.i(136374);
          if (i.this.xvc == null)
          {
            AppMethodBeat.o(136374);
            return;
          }
          Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.this.xvc.getEditableText() });
          i.this.Cwo.b(i.this.xvc.getEditableText(), false);
          AppMethodBeat.o(136374);
        }
      });
      this.xvc.setOnKeyUpPostImeListener(new af.b()
      {
        public final boolean DK(int paramAnonymousInt)
        {
          AppMethodBeat.i(136375);
          if (paramAnonymousInt == 67)
          {
            if (an.R(i.this.xvc.getText()))
            {
              AppMethodBeat.o(136375);
              return false;
            }
            i.this.ahD(i.this.xvc.getText().toString());
            AppMethodBeat.o(136375);
            return true;
          }
          AppMethodBeat.o(136375);
          return false;
        }
      });
      if (a(this.xvc, this.tTZ)) {
        break;
      }
      Log.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      bSk();
      return;
    }
    if ((this.tTZ.rAg != null) && (!Util.isNullOrNil(this.tTZ.rAg.rzR))) {
      d.a(localad, this.xvc, this.tTZ.rAg);
    }
    if (!an.m(this.tTZ.rAz)) {
      b.a(this.xvc, paramInt1, paramInt2);
    }
    if (an.m(this.tTZ.rAz)) {
      this.xvc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136376);
          i.b(i.this);
          AppMethodBeat.o(136376);
        }
      });
    }
    if (an.m(this.tTZ.rAz)) {
      ((q)this.xvc).setAdjustKeyboardTo(this.tTZ.rAH);
    }
    if (("text".equalsIgnoreCase(this.tTZ.cKU)) || ("textarea".equalsIgnoreCase(this.tTZ.cKU))) {
      ko(false);
    }
    for (;;)
    {
      this.xvc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(136360);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (i.this.xvc == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.xvc.hasFocus())
          {
            i.d(i.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.xvc == paramAnonymousView) {
            i.e(i.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136360);
        }
      });
      bSj();
      return;
      if ("emoji".equalsIgnoreCase(this.tTZ.cKU)) {
        ko(true);
      } else {
        Assert.fail(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.tTZ.cKU }));
      }
    }
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.xvc == null) || (this.xuZ == null) || (this.xuZ.get() == null)) {}
    for (;;)
    {
      fh(paramInt1, paramInt2);
      return true;
      this.xvc.performClick();
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void a(ae paramae, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void eB(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i
 * JD-Core Version:    0.7.0.1
 */