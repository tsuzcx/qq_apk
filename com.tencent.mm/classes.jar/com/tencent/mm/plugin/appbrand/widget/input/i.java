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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.utils.l;
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
  int AJG;
  int AJI;
  public final com.tencent.mm.plugin.appbrand.widget.input.c.a BaH = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
  boolean BdT = false;
  final Runnable BdU = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136372);
      i.this.BdT = false;
      AppMethodBeat.o(136372);
    }
  };
  private final aa.e BfP = new aa.e()
  {
    public final boolean eZ(String paramAnonymousString)
    {
      AppMethodBeat.i(136364);
      if (i.this.uFN != null)
      {
        if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramAnonymousString)) {
          break label41;
        }
        i.this.uFN.cRu();
      }
      for (;;)
      {
        AppMethodBeat.o(136364);
        return true;
        label41:
        i.this.uFN.R(paramAnonymousString);
      }
    }
  };
  private final aa.c Byo = new aa.c()
  {
    public final void df(boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136365);
      if (paramAnonymousBoolean) {
        i.this.uFK = i.d.uFX;
      }
      i.f(i.this);
      i.this.uFK = null;
      AppMethodBeat.o(136365);
    }
  };
  private final aa.f Cgq = new aa.f()
  {
    public final void onVisibilityChanged(int paramAnonymousInt)
    {
      AppMethodBeat.i(136366);
      Log.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (paramAnonymousInt != 2)
      {
        if ((paramAnonymousInt == 0) && (i.this.uFN != null)) {
          i.this.uFN.requestFocus();
        }
        i.g(i.this);
        if ((i.this.uFM != null) && (i.this.uFM.get() != null))
        {
          o.a((ad)i.this.uFM.get(), i.this.uFN);
          AppMethodBeat.o(136366);
        }
      }
      else
      {
        i.this.uFK = i.d.uFV;
        i.f(i.this);
        i.this.uFK = null;
      }
      AppMethodBeat.o(136366);
    }
  };
  final aa.d Cjt = new aa.d()
  {
    public final EditText getEditText()
    {
      return i.this.uFN;
    }
    
    public final void mL(int paramAnonymousInt)
    {
      AppMethodBeat.i(324408);
      if (Util.ticksToNow(i.this.uVx) > 50L) {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(324401);
            if (i.this.uFM == null)
            {
              Log.e("MicroMsg.AppBrandInputInvokeHandler", "postDelayed scroll up found page is null");
              AppMethodBeat.o(324401);
              return;
            }
            k.a(i.this.uFM).e(i.this.uFB, false, false);
            i.this.uVx = Util.currentTicks();
            AppMethodBeat.o(324401);
          }
        }, 50L);
      }
      AppMethodBeat.o(324408);
    }
  };
  final MMHandler sVR = new MMHandler(Looper.getMainLooper());
  public int uFB;
  public volatile c uFE;
  private volatile a uFF;
  public volatile b uFG;
  final View.OnFocusChangeListener uFH = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136369);
      if (paramAnonymousBoolean) {
        o.b((ad)i.this.uFM.get(), i.this);
      }
      i.a(i.this, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && ((!i.this.uFL.uLv) || (com.tencent.mm.plugin.appbrand.ui.ae.dL(i.this.uFN)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (i.this.uFN != null) && (i.this.uFO != null))
        {
          i.this.uFN.requestFocus();
          i.this.uFO.a(i.this.Cjt);
          i.this.uFO.show();
        }
        AppMethodBeat.o(136369);
        return;
      }
    }
  };
  private int uFI = -1;
  private int uFJ = -1;
  d uFK = null;
  public e uFL;
  protected WeakReference<ad> uFM;
  public ac uFN;
  aa uFO;
  private v uFP;
  private final c.a uFz = new p.a()
  {
    public final void eY(String paramAnonymousString)
    {
      AppMethodBeat.i(168763);
      if (i.this.uFN != null) {
        try
        {
          i.this.BaH.b(i.this.uFN.getEditableText(), false);
          AppMethodBeat.o(168763);
          return;
        }
        catch (Exception paramAnonymousString) {}
      }
      AppMethodBeat.o(168763);
    }
  };
  long uVx;
  private final Runnable uVy = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136371);
      i.c(i.this);
      AppMethodBeat.o(136371);
    }
  };
  
  private v cQO()
  {
    if (this.uFP != null) {
      return this.uFP;
    }
    if (this.uFM != null)
    {
      localObject = (ad)this.uFM.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    if ((((ad)localObject).getContentView() == null) || (!z.ay(((ad)localObject).getContentView()))) {
      return null;
    }
    Object localObject = v.eh(((ad)localObject).getContentView());
    this.uFP = ((v)localObject);
    return localObject;
  }
  
  private void cQX()
  {
    if (this.uFN == null) {
      break label7;
    }
    label7:
    while ((this.uFN.getLineCount() == this.uFI) && (this.uFN.cRD() == this.uFJ)) {
      return;
    }
    if (this.uFI == -1) {}
    for (int i = 1;; i = 0)
    {
      this.uFI = this.uFN.getLineCount();
      this.uFJ = this.uFN.cRD();
      if (this.uFE != null) {
        this.uFE.fv(this.uFI, this.uFJ);
      }
      if ((!this.uFL.uLP.booleanValue()) || (i != 0)) {
        break;
      }
      this.AJG = (an.o(this.uFL.uLB) + an.o(this.uFL.uLA));
      cQV();
      this.AJI = (an.o(this.uFL.uLB) + an.o(this.uFL.uLA));
      lA(true);
      return;
    }
  }
  
  private void cQY()
  {
    if (this.uFL.uLP.booleanValue()) {
      dZi();
    }
    if ((this.uFO != null) && (this.uFN != null))
    {
      this.uFO.uHT = this.uFN;
      this.uFO.setComponentView(this.uFL.uMg.booleanValue());
      this.uFO.cRz();
      this.uFO.setShowDoneButton(an.o(this.uFL.uLQ));
      cSt();
      if ((com.tencent.mm.plugin.appbrand.ui.ae.dL(this.uFN)) && (this.uFN.hasFocus()))
      {
        this.uFO.a(this.Cjt);
        this.uFO.show();
      }
    }
  }
  
  private void cQZ()
  {
    this.uFO.b(this.uFN);
    a(this.uFN);
    this.uFN.destroy();
    onDestroy();
  }
  
  private void cRa()
  {
    boolean bool3 = true;
    ad localad;
    boolean bool1;
    label33:
    boolean bool2;
    if (this.uFM == null)
    {
      localad = null;
      if (this.uFO == null) {
        dZi();
      }
      if (this.uFN != null) {
        break label116;
      }
      bool1 = true;
      if (localad != null) {
        break label121;
      }
      bool2 = true;
      label40:
      if (this.uFO != null) {
        break label126;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((localad != null) && (this.uFN != null) && (this.uFO != null)) {
        break label131;
      }
      return;
      localad = (ad)this.uFM.get();
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
    o.a(localad, this.uFN);
    final PBool localPBool = new PBool();
    localPBool.value = false;
    final Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136361);
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
        localPBool.value = true;
        if (i.this.uFM == null) {}
        for (ad localad = null; (localad == null) || (i.this.uFN == null); localad = (ad)i.this.uFM.get())
        {
          AppMethodBeat.o(136361);
          return;
        }
        if (o.G(localad) != i.this)
        {
          AppMethodBeat.o(136361);
          return;
        }
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
        h.cQR().d(localad.tti);
        an.eq(i.this.uFN);
        if ((i.this.uFO != null) && (i.this.uFO.b(null)))
        {
          i.this.uFO.b(i.this.Cjt);
          i.this.uFO.hide();
        }
        i.this.uFN.a(i.this.uFH);
        i.this.uFN.setFocusable(true);
        i.this.uFN.setFocusableInTouchMode(true);
        i.this.uFO.uHT = i.this.uFN;
        i.this.uFN.requestFocus();
        an.eq(i.this.uFN);
        if (i.this.uFO != null)
        {
          i.this.uFO.a(i.this.Cjt);
          i.this.uFO.show();
        }
        AppMethodBeat.o(136361);
      }
    };
    Object localObject = AndroidContextUtil.castActivityOrNull(localad.getContext());
    if ((localObject != null) && (((Activity)localObject).getCurrentFocus() != null))
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      bool1 = an.ep((View)localObject).isActive((View)localObject);
      bool2 = an.i(localad.tti.getWrapperView(), (View)localObject);
      if ((bool1) && (bool2))
      {
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
        this.uFO.setOnVisibilityChangedListener(new aa.f()
        {
          public final void onVisibilityChanged(int paramAnonymousInt)
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
        com.tencent.threadpool.h.ahAA.o(new Runnable()
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
  
  private void cSt()
  {
    if (this.uFO == null) {
      return;
    }
    this.uFO.setOnSmileyChosenListener(this.BfP);
    this.uFO.setOnDoneListener(this.Byo);
    this.uFO.setOnVisibilityChangedListener(this.Cgq);
  }
  
  private aa dZi()
  {
    if (this.uFO != null) {
      return this.uFO;
    }
    if (this.uFM != null)
    {
      localObject = (ad)this.uFM.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = aa.ek(((ad)localObject).getContentView());
    this.uFO = ((aa)localObject);
    return localObject;
  }
  
  private void edR()
  {
    if (cQO() != null) {
      this.uFP.setVisibility(8);
    }
  }
  
  private void fZ(int paramInt1, int paramInt2)
  {
    b.a(this.uFN, paramInt1, paramInt2);
    lA(false);
  }
  
  private void lA(boolean paramBoolean)
  {
    if ((this.uFL.uLP.booleanValue()) && (this.uFO != null) && (this.uFO.isShown()) && (this.uFN != null) && (this.uFN == this.uFO.getAttachedEditText()))
    {
      if (!paramBoolean) {
        break label204;
      }
      if ((this.uFM == null) || (this.uFM.get() == null) || (((ad)this.uFM.get()).cEy() == null)) {
        break label219;
      }
      i = ((ad)this.uFM.get()).cEy().getMeasuredHeight();
    }
    label204:
    label219:
    for (int i = ((ad)this.uFM.get()).cEy().getScrollY() + i;; i = 0)
    {
      if (((this.AJI > this.AJG) && (this.AJI - this.uFN.getLineHeight() <= i)) || ((this.AJI <= this.AJG) && (this.AJI + this.uFN.getLineHeight() <= i)) || (this.uFN.cRD() >= i)) {
        k.a(this.uFM).Em(this.uFB);
      }
      return;
      k.a(this.uFM).Em(this.uFB);
      return;
    }
  }
  
  private void lB(boolean paramBoolean)
  {
    Object localObject = (ad)this.uFM.get();
    if (!z.ay(((ad)localObject).getContentView())) {}
    label404:
    for (;;)
    {
      return;
      this.uFO = aa.b(((ad)localObject).getContentView(), ((ad)localObject).cEK());
      this.uFO.setComponentView(this.uFL.uMg.booleanValue());
      this.uFO.cRz();
      if (this.uFL.uLv)
      {
        cSt();
        edR();
      }
      this.uFN.a(this.uFH);
      this.uFN.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(324587);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.cH(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
          paramAnonymousView = i.this;
          boolean bool;
          if (67 == paramAnonymousInt)
          {
            bool = true;
            paramAnonymousView.BdT = bool;
            if (!i.this.BdT) {
              break label143;
            }
            i.this.sVR.removeCallbacks(i.this.BdU);
            i.this.sVR.postDelayed(i.this.BdU, 1000L);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(324587);
            return false;
            bool = false;
            break;
            label143:
            i.this.BdU.run();
          }
        }
      });
      if (this.uFL.uLv) {
        o.a((ad)this.uFM.get(), this.uFN);
      }
      localObject = this.uFO;
      final int i;
      if ((!this.uFL.eEI) && (paramBoolean))
      {
        paramBoolean = true;
        ((aa)localObject).setCanSmileyInput(paramBoolean);
        if (this.uFL.uLU != null) {
          break label318;
        }
        i = com.tencent.mm.plugin.appbrand.widget.input.e.b.lH(this.uFL.uLP.booleanValue()).uLp;
        label185:
        Log.d("MicroMsg.AppBrandInputInvokeHandler", "initSmileyPanelAndShow, myImeOption: ".concat(String.valueOf(i)));
        localObject = null;
        if ((!this.uFL.uLP.booleanValue()) || (i != 0)) {
          localObject = new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(324595);
              if (paramAnonymousInt == i)
              {
                i.this.uFK = i.d.uFW;
                i.f(i.this);
                i.this.uFK = null;
                AppMethodBeat.o(324595);
                return true;
              }
              AppMethodBeat.o(324595);
              return false;
            }
          };
        }
        this.uFN.setImeOptions(i);
        this.uFN.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
        this.uFO.setShowDoneButton(this.uFL.uLQ.booleanValue());
        this.uFO.uHT = this.uFN;
        if (!this.uFL.uLv) {
          break label369;
        }
        cRa();
      }
      for (;;)
      {
        if (!this.uFL.uLv) {
          break label404;
        }
        k.a(this.uFM).Em(this.uFB);
        return;
        paramBoolean = false;
        break;
        label318:
        if ((!this.uFL.uLP.booleanValue()) && (com.tencent.mm.plugin.appbrand.widget.input.e.b.uLo == this.uFL.uLU)) {
          this.uFL.uLU = com.tencent.mm.plugin.appbrand.widget.input.e.b.lH(false);
        }
        i = this.uFL.uLU.uLp;
        break label185;
        label369:
        this.uFN.setFocusable(false);
        this.uFN.setFocusableInTouchMode(false);
        this.uFO.b(this.Cjt);
        this.uFO.hide();
      }
    }
  }
  
  private void lC(boolean paramBoolean)
  {
    if (this.uFN == null) {
      return;
    }
    String str = this.uFN.getText().toString();
    int i = this.uFN.getSelectionEnd();
    if ((d.uFW == this.uFK) || (d.uFX == this.uFK)) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, i, bool, paramBoolean);
      return;
    }
  }
  
  private void onDestroy()
  {
    this.uFN = null;
    l.cM(this);
  }
  
  public final boolean B(ad paramad)
  {
    return (paramad != null) && (this.uFM != null) && (paramad == this.uFM.get());
  }
  
  public final void Ej(int paramInt)
  {
    b localb = this.uFG;
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
      paramac.b(this.uFH);
      if (this.uFM == null) {}
      for (Object localObject = null;; localObject = (ad)this.uFM.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((ad)localObject).cEy();
        if (localObject == null) {
          break;
        }
        ((g)localObject).ec(paramac);
        return;
      }
    }
  }
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final void a(String paramString, Integer paramInteger)
  {
    if (this.uFN == null) {
      return;
    }
    this.uFN.T(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      fZ(paramString.intValue(), paramString.intValue());
      cQX();
      return;
    }
  }
  
  boolean a(ac paramac, e parame)
  {
    if ((paramac == null) || (this.uFM == null) || (this.uFM.get() == null)) {
      return false;
    }
    g localg = (g)((ad)this.uFM.get()).cEy();
    return (localg != null) && (localg.a(((ad)this.uFM.get()).tti, paramac, parame.uLz.intValue(), parame.uLA.intValue(), parame.uLC.intValue(), parame.uLB.intValue()));
  }
  
  public abstract void aaA(String paramString);
  
  public boolean b(ac paramac, e parame)
  {
    if ((paramac == null) || (this.uFM == null) || (this.uFM.get() == null)) {
      return false;
    }
    g localg = (g)((ad)this.uFM.get()).cEy();
    return (localg != null) && (localg.c(((ad)this.uFM.get()).tti, paramac, parame.uLz.intValue(), parame.uLA.intValue(), parame.uLC.intValue(), parame.uLB.intValue()));
  }
  
  public final boolean cQD()
  {
    int i;
    if ((this.uFN == null) || (this.uFM == null) || (this.uFM.get() == null)) {
      i = 0;
    }
    while (i != 0)
    {
      onDestroy();
      return true;
      this.uFN.destroy();
      g localg = (g)((ad)this.uFM.get()).cEy();
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        if (this.uFN.hasFocus())
        {
          if (this.uFP != null) {
            this.uFP.setVisibility(8);
          }
          dZi();
          if (this.uFO != null) {
            this.uFO.setVisibility(8);
          }
        }
        localg.ec(this.uFN);
        o.b((ad)this.uFM.get(), this.uFN);
        i = 1;
      }
    }
    return false;
  }
  
  public final boolean cQL()
  {
    return (this.uFL != null) && (an.o(this.uFL.uLW));
  }
  
  public final int cQM()
  {
    if ((this.uFL != null) && (this.uFL.uLT != null)) {
      return this.uFL.uLT.intValue();
    }
    if ((this.uFN != null) && (this.uFN.cRj())) {
      return 5;
    }
    return 0;
  }
  
  public final boolean cQN()
  {
    int i;
    if ((this.uFN != null) && ((this.uFN.isFocused()) || ((dZi() != null) && (dZi().getAttachedEditText() == this.uFN))))
    {
      i = 1;
      if (i != 0) {
        break label129;
      }
      if ((this.uFM != null) && (this.uFM.get() != null)) {
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
      localObject = ((ad)this.uFM.get()).getContext();
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
      localObject = dZi();
    } while (localObject == null);
    ((aa)localObject).setVisibility(8);
    return true;
  }
  
  final void cQV()
  {
    int k;
    int i;
    if ((this.uFN != null) && (an.o(this.uFL.uLR)) && (an.o(this.uFL.uLP)))
    {
      ((q)this.uFN).setAutoHeight(true);
      j = this.uFN.getLineHeight();
      k = this.uFN.cRD();
      if ((this.uFL.uLD != null) && (this.uFL.uLD.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.uFL.uLE != null) && (this.uFL.uLE.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.uFL.uLE.intValue(), j))
    {
      this.uFN.setMinHeight(i);
      this.uFN.setMaxHeight(j);
      this.uFL.uLA = Integer.valueOf(Math.max(i, Math.min(k, j)));
      b(this.uFN, this.uFL);
      return;
      i = this.uFL.uLD.intValue();
      break;
    }
  }
  
  public final void cQW()
  {
    b.a(this.uFN, this.uFL);
    if (this.uFL.uLI == null)
    {
      this.uFL.uLI = Integer.valueOf(140);
      p.a(this.uFN).aEg(this.uFL.uLI.intValue()).Nc(false).b(g.a.afIH).a(this.uFz);
      this.uFN.setPasswordMode(this.uFL.eEI);
      if (!an.o(this.uFL.uLN)) {
        break label232;
      }
      this.uFN.setEnabled(false);
      this.uFN.setFocusable(false);
      this.uFN.setFocusableInTouchMode(false);
      this.uFN.setClickable(false);
    }
    for (;;)
    {
      if ((this.uFN instanceof q))
      {
        if (this.uFL.uLY != null) {
          ((q)this.uFN).setLineSpace(this.uFL.uLY.intValue());
        }
        if (this.uFL.uLZ != null) {
          ((q)this.uFN).setLineHeight(this.uFL.uLZ.intValue());
        }
      }
      return;
      if (this.uFL.uLI.intValue() > 0) {
        break;
      }
      this.uFL.uLI = Integer.valueOf(2147483647);
      break;
      label232:
      this.uFN.setEnabled(true);
      this.uFN.setClickable(true);
    }
  }
  
  public abstract void cso();
  
  public abstract void csp();
  
  public final void ga(int paramInt1, int paramInt2)
  {
    this.uFM = this.uFL.uEU;
    if (this.uFM == null) {}
    for (ad localad = null; (localad == null) || (localad.tti == null); localad = (ad)this.uFM.get())
    {
      Log.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      csp();
      return;
    }
    if (an.o(this.uFL.uLP)) {}
    for (Object localObject = new q(localad.getContext());; localObject = new t(localad.getContext()))
    {
      this.uFN = ((ac)localObject);
      this.uFB = this.uFL.uES;
      this.uFN.setInputId(this.uFB);
      o.b(localad, this);
      cQW();
      this.uFN.setText(Util.nullAsNil(this.uFL.defaultValue));
      if (an.o(this.uFL.uLR)) {
        cQX();
      }
      this.uFN.addTextChangedListener(new com.tencent.mm.ui.widget.i()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(136373);
          if ((i.this.uFM == null) || (i.this.uFM.get() == null) || (i.this.uFN == null))
          {
            AppMethodBeat.o(136373);
            return;
          }
          i.b(i.this);
          if (an.V(paramAnonymousEditable))
          {
            Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramAnonymousEditable });
            AppMethodBeat.o(136373);
            return;
          }
          Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramAnonymousEditable });
          paramAnonymousEditable = i.this.uFN.getEditableText();
          i.this.BaH.b(paramAnonymousEditable, i.this.BdT);
          AppMethodBeat.o(136373);
        }
      });
      this.uFN.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b()
      {
        public final void apL()
        {
          AppMethodBeat.i(136374);
          if (i.this.uFN == null)
          {
            AppMethodBeat.o(136374);
            return;
          }
          Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.this.uFN.getEditableText() });
          i.this.BaH.b(i.this.uFN.getEditableText(), false);
          AppMethodBeat.o(136374);
        }
      });
      this.uFN.setOnKeyUpPostImeListener(new af.b()
      {
        public final boolean Ek(int paramAnonymousInt)
        {
          AppMethodBeat.i(136375);
          if (paramAnonymousInt == 67)
          {
            if (an.V(i.this.uFN.getText()))
            {
              AppMethodBeat.o(136375);
              return false;
            }
            i.this.aaA(i.this.uFN.getText().toString());
            AppMethodBeat.o(136375);
            return true;
          }
          AppMethodBeat.o(136375);
          return false;
        }
      });
      if (a(this.uFN, this.uFL)) {
        break;
      }
      Log.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      csp();
      return;
    }
    if ((this.uFL.uLx != null) && (!Util.isNullOrNil(this.uFL.uLx.uLi))) {
      d.a(localad, this.uFN, this.uFL.uLx);
    }
    if (!an.o(this.uFL.uLP)) {
      b.a(this.uFN, paramInt1, paramInt2);
    }
    if (an.o(this.uFL.uLP)) {
      this.uFN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136376);
          i.b(i.this);
          AppMethodBeat.o(136376);
        }
      });
    }
    if (an.o(this.uFL.uLP)) {
      ((q)this.uFN).setAdjustKeyboardTo(this.uFL.uLX);
    }
    if (("text".equalsIgnoreCase(this.uFL.eEF)) || ("textarea".equalsIgnoreCase(this.uFL.eEF))) {
      lB(false);
    }
    for (;;)
    {
      this.uFN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(136360);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (i.this.uFN == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.uFN.hasFocus())
          {
            i.d(i.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.uFN == paramAnonymousView) {
            i.e(i.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136360);
        }
      });
      cso();
      return;
      if ("emoji".equalsIgnoreCase(this.uFL.eEF)) {
        lB(true);
      } else {
        Assert.fail(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.uFL.eEF }));
      }
    }
  }
  
  public final int getInputId()
  {
    return this.uFB;
  }
  
  public final <P extends View,  extends ag> P getInputPanel()
  {
    return this.uFO;
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.uFN == null) || (this.uFM == null) || (this.uFM.get() == null)) {}
    for (;;)
    {
      fZ(paramInt1, paramInt2);
      return true;
      this.uFN.performClick();
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void a(ae paramae, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void fv(int paramInt1, int paramInt2);
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(136379);
      uFV = new d("PANEL_HIDDEN", 0);
      uFW = new d("CONFIRM_KEYBOARD_CLICKED", 1);
      uFX = new d("CONFIRM_BAR_CLICKED", 2);
      uFY = new d[] { uFV, uFW, uFX };
      AppMethodBeat.o(136379);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i
 * JD-Core Version:    0.7.0.1
 */