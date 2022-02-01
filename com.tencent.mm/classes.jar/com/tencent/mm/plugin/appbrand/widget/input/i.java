package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.support.v4.view.u;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i
  implements aa<y>
{
  private final c.a OrL = new p.a()
  {
    public final void dv(String paramAnonymousString)
    {
      AppMethodBeat.i(168763);
      if (i.this.OrY != null) {
        try
        {
          i.this.Osf.a(i.this.OrY.getEditableText(), false);
          AppMethodBeat.o(168763);
          return;
        }
        catch (Exception paramAnonymousString) {}
      }
      AppMethodBeat.o(168763);
    }
  };
  public volatile i.c OrP;
  private volatile a OrQ;
  public volatile b OrR;
  final View.OnFocusChangeListener OrS = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136369);
      if (paramAnonymousBoolean) {
        o.b((com.tencent.mm.plugin.appbrand.page.ac)i.this.OrX.get(), i.this);
      }
      i.a(i.this, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && ((!i.this.OrW.oxG) || (com.tencent.mm.plugin.appbrand.ui.y.cI(i.this.OrY)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (i.this.OrY != null) && (i.this.OrZ != null))
        {
          i.this.OrY.requestFocus();
          i.this.OrZ.a(i.this.PLn);
          i.this.OrZ.show();
        }
        AppMethodBeat.o(136369);
        return;
      }
    }
  };
  private int OrT = -1;
  private int OrU = -1;
  i.d OrV = null;
  public e OrW;
  protected WeakReference<com.tencent.mm.plugin.appbrand.page.ac> OrX;
  public y OrY;
  w OrZ;
  private v Osa;
  long Osb;
  private final Runnable Osc = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136371);
      i.c(i.this);
      AppMethodBeat.o(136371);
    }
  };
  int Osd;
  int Ose;
  public final com.tencent.mm.plugin.appbrand.widget.input.c.a Osf = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
  boolean Osg = false;
  final Runnable Osh = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136372);
      i.this.Osg = false;
      AppMethodBeat.o(136372);
    }
  };
  private final w.e Osi = new w.e()
  {
    public final boolean afZ(String paramAnonymousString)
    {
      AppMethodBeat.i(136364);
      if (i.this.OrY != null)
      {
        if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramAnonymousString)) {
          break label119;
        }
        paramAnonymousString = i.this.OrY;
        if (paramAnonymousString.otU == null) {
          break label86;
        }
        if (!Util.isNullOrNil(paramAnonymousString.getEditableText())) {
          paramAnonymousString.otU.deleteSurroundingText(paramAnonymousString.getEditableText().length(), paramAnonymousString.getEditableText().length() - 1);
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
      y localy = i.this.OrY;
      f.cbc();
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
  private final w.c PLl = new w.c()
  {
    public final void cm(boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136365);
      if (paramAnonymousBoolean) {
        i.this.OrV = i.d.osJ;
      }
      i.f(i.this);
      i.this.OrV = null;
      AppMethodBeat.o(136365);
    }
  };
  private final w.f PLm = new w.f()
  {
    public final void hJ(int paramAnonymousInt)
    {
      AppMethodBeat.i(136366);
      Log.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (paramAnonymousInt != 2)
      {
        if ((paramAnonymousInt == 0) && (i.this.OrY != null)) {
          i.this.OrY.requestFocus();
        }
        i.g(i.this);
        if ((i.this.OrX != null) && (i.this.OrX.get() != null))
        {
          o.a((com.tencent.mm.plugin.appbrand.page.ac)i.this.OrX.get(), i.this.OrY);
          AppMethodBeat.o(136366);
        }
      }
      else
      {
        i.this.OrV = i.d.osH;
        i.f(i.this);
        i.this.OrV = null;
      }
      AppMethodBeat.o(136366);
    }
  };
  final w.d PLn = new w.d()
  {
    public final EditText getEditText()
    {
      return i.this.OrY;
    }
    
    public final void ig(int paramAnonymousInt)
    {
      AppMethodBeat.i(230573);
      if (Util.ticksToNow(i.this.Osb) > 50L) {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(230572);
            if (i.this.OrX == null)
            {
              Log.e("MicroMsg.AppBrandInputInvokeHandler", "postDelayed scroll up found page is null");
              AppMethodBeat.o(230572);
              return;
            }
            k.a(i.this.OrX).c(i.this.osn, false, false);
            i.this.Osb = Util.currentTicks();
            AppMethodBeat.o(230572);
          }
        }, 50L);
      }
      AppMethodBeat.o(230573);
    }
  };
  final MMHandler mQp = new MMHandler(Looper.getMainLooper());
  public int osn;
  
  private v cbb()
  {
    if (this.Osa != null) {
      return this.Osa;
    }
    if (this.OrX != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    if ((((com.tencent.mm.plugin.appbrand.page.ac)localObject).getContentView() == null) || (!u.aD(((com.tencent.mm.plugin.appbrand.page.ac)localObject).getContentView()))) {
      return null;
    }
    Object localObject = v.da(((com.tencent.mm.plugin.appbrand.page.ac)localObject).getContentView());
    this.Osa = ((v)localObject);
    return localObject;
  }
  
  private void cbi()
  {
    if (this.OrY == null) {
      break label7;
    }
    label7:
    while ((this.OrY.getLineCount() == this.OrT) && (this.OrY.cbP() == this.OrU)) {
      return;
    }
    if (this.OrT == -1) {}
    for (int i = 1;; i = 0)
    {
      this.OrT = this.OrY.getLineCount();
      this.OrU = this.OrY.cbP();
      if (this.OrP != null) {
        this.OrP.ed(this.OrT, this.OrU);
      }
      if ((!this.OrW.oya.booleanValue()) || (i != 0)) {
        break;
      }
      this.Osd = (aj.j(this.OrW.oxM) + aj.j(this.OrW.oxL));
      cbg();
      this.Ose = (aj.j(this.OrW.oxM) + aj.j(this.OrW.oxL));
      jh(true);
      return;
    }
  }
  
  private void cbj()
  {
    if (this.OrW.oya.booleanValue()) {
      cbo();
    }
    if ((this.OrZ != null) && (this.OrY != null))
    {
      this.OrZ.oum = this.OrY;
      this.OrZ.setComponentView(this.OrW.oyq.booleanValue());
      this.OrZ.cbN();
      this.OrZ.setShowDoneButton(aj.i(this.OrW.oyb));
      cbm();
      if ((com.tencent.mm.plugin.appbrand.ui.y.cI(this.OrY)) && (this.OrY.hasFocus()))
      {
        this.OrZ.a(this.PLn);
        this.OrZ.show();
      }
    }
  }
  
  private void cbk()
  {
    this.OrZ.b(this.OrY);
    a(this.OrY);
    this.OrY.destroy();
    onDestroy();
  }
  
  private void cbl()
  {
    boolean bool3 = true;
    com.tencent.mm.plugin.appbrand.page.ac localac;
    boolean bool1;
    label33:
    boolean bool2;
    if (this.OrX == null)
    {
      localac = null;
      if (this.OrZ == null) {
        cbo();
      }
      if (this.OrY != null) {
        break label116;
      }
      bool1 = true;
      if (localac != null) {
        break label121;
      }
      bool2 = true;
      label40:
      if (this.OrZ != null) {
        break label126;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((localac != null) && (this.OrY != null) && (this.OrZ != null)) {
        break label131;
      }
      return;
      localac = (com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get();
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
    o.a(localac, this.OrY);
    final PBool localPBool = new PBool();
    localPBool.value = false;
    final Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136361);
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
        localPBool.value = true;
        if (i.this.OrX == null) {}
        for (com.tencent.mm.plugin.appbrand.page.ac localac = null; (localac == null) || (i.this.OrY == null); localac = (com.tencent.mm.plugin.appbrand.page.ac)i.this.OrX.get())
        {
          AppMethodBeat.o(136361);
          return;
        }
        if (o.F(localac) != i.this)
        {
          AppMethodBeat.o(136361);
          return;
        }
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
        h.cbe().d(localac.nmX);
        aj.dh(i.this.OrY);
        if ((i.this.OrZ != null) && (i.this.OrZ.b(null)))
        {
          i.this.OrZ.b(i.this.PLn);
          i.this.OrZ.hide();
        }
        i.this.OrY.a(i.this.OrS);
        i.this.OrY.setFocusable(true);
        i.this.OrY.setFocusableInTouchMode(true);
        i.this.OrZ.oum = i.this.OrY;
        i.this.OrY.requestFocus();
        aj.dh(i.this.OrY);
        if (i.this.OrZ != null)
        {
          i.this.OrZ.a(i.this.PLn);
          i.this.OrZ.show();
        }
        AppMethodBeat.o(136361);
      }
    };
    Object localObject = AndroidContextUtil.castActivityOrNull(localac.getContext());
    if ((localObject != null) && (((Activity)localObject).getCurrentFocus() != null))
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      bool1 = aj.dg((View)localObject).isActive((View)localObject);
      bool2 = aj.i(localac.nmX.getWrapperView(), (View)localObject);
      if ((bool1) && (bool2))
      {
        Log.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
        this.OrZ.setOnVisibilityChangedListener(new w.f()
        {
          public final void hJ(int paramAnonymousInt)
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
        com.tencent.f.h.RTc.n(new Runnable()
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
  
  private void cbm()
  {
    if (this.OrZ == null) {
      return;
    }
    this.OrZ.setOnSmileyChosenListener(this.Osi);
    this.OrZ.setOnDoneListener(this.PLl);
    this.OrZ.setOnVisibilityChangedListener(this.PLm);
  }
  
  private void cbn()
  {
    Object localObject = (com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get();
    if (!u.aD(((com.tencent.mm.plugin.appbrand.page.ac)localObject).getContentView())) {}
    label416:
    for (;;)
    {
      return;
      this.OrZ = w.b(((com.tencent.mm.plugin.appbrand.page.ac)localObject).getContentView(), ((com.tencent.mm.plugin.appbrand.page.ac)localObject).bRo());
      this.OrZ.setComponentView(this.OrW.oyq.booleanValue());
      this.OrZ.cbN();
      if (this.OrW.oxG)
      {
        cbm();
        ccw();
      }
      this.OrY.a(this.OrS);
      this.OrY.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(230574);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.bm(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
          paramAnonymousView = i.this;
          boolean bool;
          if (67 == paramAnonymousInt)
          {
            bool = true;
            paramAnonymousView.Osg = bool;
            if (!i.this.Osg) {
              break label143;
            }
            i.this.mQp.removeCallbacks(i.this.Osh);
            i.this.mQp.postDelayed(i.this.Osh, 1000L);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(230574);
            return false;
            bool = false;
            break;
            label143:
            i.this.Osh.run();
          }
        }
      });
      if (this.OrW.oxG) {
        o.a((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get(), this.OrY);
      }
      localObject = this.OrZ;
      boolean bool;
      final int i;
      if ((!this.OrW.cKr) && ("emoji".equals(this.OrW.cKo)))
      {
        bool = true;
        ((w)localObject).setCanSmileyInput(bool);
        if (this.OrW.oyf != null) {
          break label330;
        }
        i = com.tencent.mm.plugin.appbrand.widget.input.d.b.jk(this.OrW.oya.booleanValue()).oxA;
        label197:
        Log.d("MicroMsg.AppBrandInputInvokeHandler", "initSmileyPanelAndShow, myImeOption: ".concat(String.valueOf(i)));
        localObject = null;
        if ((!this.OrW.oya.booleanValue()) || (i != 0)) {
          localObject = new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(230575);
              if (paramAnonymousInt == i)
              {
                i.this.OrV = i.d.osI;
                i.f(i.this);
                i.this.OrV = null;
                AppMethodBeat.o(230575);
                return true;
              }
              AppMethodBeat.o(230575);
              return false;
            }
          };
        }
        this.OrY.setImeOptions(i);
        this.OrY.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
        this.OrZ.setShowDoneButton(this.OrW.oyb.booleanValue());
        this.OrZ.oum = this.OrY;
        if (!this.OrW.oxG) {
          break label381;
        }
        cbl();
      }
      for (;;)
      {
        if (!this.OrW.oxG) {
          break label416;
        }
        k.a(this.OrX).Ac(this.osn);
        return;
        bool = false;
        break;
        label330:
        if ((!this.OrW.oya.booleanValue()) && (com.tencent.mm.plugin.appbrand.widget.input.d.b.oxz == this.OrW.oyf)) {
          this.OrW.oyf = com.tencent.mm.plugin.appbrand.widget.input.d.b.jk(false);
        }
        i = this.OrW.oyf.oxA;
        break label197;
        label381:
        this.OrY.setFocusable(false);
        this.OrY.setFocusableInTouchMode(false);
        this.OrZ.b(this.PLn);
        this.OrZ.hide();
      }
    }
  }
  
  private w cbo()
  {
    if (this.OrZ != null) {
      return this.OrZ;
    }
    if (this.OrX != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = w.dc(((com.tencent.mm.plugin.appbrand.page.ac)localObject).getContentView());
    this.OrZ = ((w)localObject);
    return localObject;
  }
  
  private void ccw()
  {
    if (cbb() != null) {
      this.Osa.setVisibility(8);
    }
  }
  
  private void eJ(int paramInt1, int paramInt2)
  {
    b.a(this.OrY, paramInt1, paramInt2);
    jh(false);
  }
  
  private void jh(boolean paramBoolean)
  {
    if ((this.OrW.oya.booleanValue()) && (this.OrZ != null) && (this.OrZ.isShown()) && (this.OrY != null) && (this.OrY == this.OrZ.getAttachedEditText()))
    {
      if (!paramBoolean) {
        break label204;
      }
      if ((this.OrX == null) || (this.OrX.get() == null) || (((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).bRe() == null)) {
        break label219;
      }
      i = ((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).bRe().getMeasuredHeight();
    }
    label204:
    label219:
    for (int i = ((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).bRe().getScrollY() + i;; i = 0)
    {
      if (((this.Ose > this.Osd) && (this.Ose - this.OrY.getLineHeight() <= i)) || ((this.Ose <= this.Osd) && (this.Ose + this.OrY.getLineHeight() <= i)) || (this.OrY.cbP() >= i)) {
        k.a(this.OrX).Ac(this.osn);
      }
      return;
      k.a(this.OrX).Ac(this.osn);
      return;
    }
  }
  
  private void ji(boolean paramBoolean)
  {
    if (this.OrY == null) {
      return;
    }
    String str = this.OrY.getText().toString();
    int i = this.OrY.getSelectionEnd();
    if ((i.d.osI == this.OrV) || (i.d.osJ == this.OrV)) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, i, bool, paramBoolean);
      return;
    }
  }
  
  private void onDestroy()
  {
    this.OrY = null;
    com.tencent.mm.plugin.appbrand.utils.f.bs(this);
  }
  
  public final boolean A(com.tencent.mm.plugin.appbrand.page.ac paramac)
  {
    return (paramac != null) && (this.OrX != null) && (paramac == this.OrX.get());
  }
  
  public abstract void ZN(String paramString);
  
  void a(y paramy)
  {
    if (paramy == null) {}
    label58:
    for (;;)
    {
      return;
      paramy.b(this.OrS);
      if (this.OrX == null) {}
      for (Object localObject = null;; localObject = (com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((com.tencent.mm.plugin.appbrand.page.ac)localObject).bRe();
        if (localObject == null) {
          break;
        }
        ((g)localObject).cV(paramy);
        return;
      }
    }
  }
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final void a(String paramString, Integer paramInteger)
  {
    if (this.OrY == null) {
      return;
    }
    this.OrY.G(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      eJ(paramString.intValue(), paramString.intValue());
      cbi();
      return;
    }
  }
  
  boolean a(y paramy, e parame)
  {
    if ((paramy == null) || (this.OrX == null) || (this.OrX.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).bRe();
    return (localg != null) && (localg.a(((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).nmX, paramy, parame.oxK.intValue(), parame.oxL.intValue(), parame.oxN.intValue(), parame.oxM.intValue()));
  }
  
  public boolean b(y paramy, e parame)
  {
    if ((paramy == null) || (this.OrX == null) || (this.OrX.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).bRe();
    return (localg != null) && (localg.c(((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).nmX, paramy, parame.oxK.intValue(), parame.oxL.intValue(), parame.oxN.intValue(), parame.oxM.intValue()));
  }
  
  public abstract void bGC();
  
  public abstract void bGD();
  
  public final boolean caU()
  {
    int i;
    if ((this.OrY == null) || (this.OrX == null) || (this.OrX.get() == null)) {
      i = 0;
    }
    while (i != 0)
    {
      onDestroy();
      return true;
      this.OrY.destroy();
      g localg = (g)((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).bRe();
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        if (this.OrY.hasFocus())
        {
          if (this.Osa != null) {
            this.Osa.setVisibility(8);
          }
          cbo();
          if (this.OrZ != null) {
            this.OrZ.setVisibility(8);
          }
        }
        localg.cV(this.OrY);
        i = 1;
      }
    }
    return false;
  }
  
  public final boolean caY()
  {
    return (this.OrW != null) && (aj.i(this.OrW.oyh));
  }
  
  public final int caZ()
  {
    if ((this.OrW != null) && (this.OrW.oye != null)) {
      return this.OrW.oye.intValue();
    }
    if ((this.OrY != null) && (this.OrY.cbx())) {
      return 5;
    }
    return 0;
  }
  
  public final boolean cba()
  {
    int i;
    if ((this.OrY != null) && ((this.OrY.isFocused()) || ((cbo() != null) && (cbo().getAttachedEditText() == this.OrY))))
    {
      i = 1;
      if (i != 0) {
        break label129;
      }
      if ((this.OrX != null) && (this.OrX.get() != null)) {
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
      localObject = ((com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get()).getContext();
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
      localObject = cbo();
    } while (localObject == null);
    ((w)localObject).setVisibility(8);
    return true;
  }
  
  final void cbg()
  {
    int k;
    int i;
    if ((this.OrY != null) && (aj.i(this.OrW.oyc)) && (aj.i(this.OrW.oya)))
    {
      ((q)this.OrY).setAutoHeight(true);
      j = this.OrY.getLineHeight();
      k = this.OrY.cbP();
      if ((this.OrW.oxO != null) && (this.OrW.oxO.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.OrW.oxP != null) && (this.OrW.oxP.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.OrW.oxP.intValue(), j))
    {
      this.OrY.setMinHeight(i);
      this.OrY.setMaxHeight(j);
      this.OrW.oxL = Integer.valueOf(Math.max(i, Math.min(k, j)));
      b(this.OrY, this.OrW);
      return;
      i = this.OrW.oxO.intValue();
      break;
    }
  }
  
  public final void cbh()
  {
    b.a(this.OrY, this.OrW);
    if (this.OrW.oxT == null)
    {
      this.OrW.oxT = Integer.valueOf(140);
      p.a(this.OrY).aoq(this.OrW.oxT.intValue()).CN(false).a(f.a.Quh).a(this.OrL);
      this.OrY.setPasswordMode(this.OrW.cKr);
      if (!aj.i(this.OrW.oxY)) {
        break label232;
      }
      this.OrY.setEnabled(false);
      this.OrY.setFocusable(false);
      this.OrY.setFocusableInTouchMode(false);
      this.OrY.setClickable(false);
    }
    for (;;)
    {
      if ((this.OrY instanceof q))
      {
        if (this.OrW.oyi != null) {
          ((q)this.OrY).setLineSpace(this.OrW.oyi.intValue());
        }
        if (this.OrW.oyj != null) {
          ((q)this.OrY).setLineHeight(this.OrW.oyj.intValue());
        }
      }
      return;
      if (this.OrW.oxT.intValue() > 0) {
        break;
      }
      this.OrW.oxT = Integer.valueOf(2147483647);
      break;
      label232:
      this.OrY.setEnabled(true);
      this.OrY.setClickable(true);
    }
  }
  
  public final void eK(int paramInt1, int paramInt2)
  {
    this.OrX = this.OrW.orG;
    if (this.OrX == null) {}
    for (com.tencent.mm.plugin.appbrand.page.ac localac = null; (localac == null) || (localac.nmX == null); localac = (com.tencent.mm.plugin.appbrand.page.ac)this.OrX.get())
    {
      Log.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      bGD();
      return;
    }
    if (aj.i(this.OrW.oya)) {}
    for (Object localObject = new q(localac.getContext());; localObject = new t(localac.getContext()))
    {
      this.OrY = ((y)localObject);
      this.osn = this.OrW.orE;
      this.OrY.setInputId(this.osn);
      o.b(localac, this);
      cbh();
      this.OrY.setText(Util.nullAsNil(this.OrW.oxJ));
      if (aj.i(this.OrW.oyc)) {
        cbi();
      }
      this.OrY.addTextChangedListener(new com.tencent.mm.ui.widget.g()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(136373);
          if ((i.this.OrX == null) || (i.this.OrX.get() == null) || (i.this.OrY == null))
          {
            AppMethodBeat.o(136373);
            return;
          }
          i.b(i.this);
          if (aj.I(paramAnonymousEditable))
          {
            Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramAnonymousEditable });
            AppMethodBeat.o(136373);
            return;
          }
          Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramAnonymousEditable });
          paramAnonymousEditable = i.this.OrY.getEditableText();
          i.this.Osf.a(paramAnonymousEditable, i.this.Osg);
          AppMethodBeat.o(136373);
        }
      });
      this.OrY.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b()
      {
        public final void ML()
        {
          AppMethodBeat.i(136374);
          if (i.this.OrY == null)
          {
            AppMethodBeat.o(136374);
            return;
          }
          Log.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.this.OrY.getEditableText() });
          i.this.Osf.a(i.this.OrY.getEditableText(), false);
          AppMethodBeat.o(136374);
        }
      });
      this.OrY.setOnKeyUpPostImeListener(new ab.b()
      {
        public final boolean Aa(int paramAnonymousInt)
        {
          AppMethodBeat.i(136375);
          if (paramAnonymousInt == 67)
          {
            if (aj.I(i.this.OrY.getText()))
            {
              AppMethodBeat.o(136375);
              return false;
            }
            i.this.ZN(i.this.OrY.getText().toString());
            AppMethodBeat.o(136375);
            return true;
          }
          AppMethodBeat.o(136375);
          return false;
        }
      });
      if (a(this.OrY, this.OrW)) {
        break;
      }
      Log.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      bGD();
      return;
    }
    if ((this.OrW.oxI != null) && (!Util.isNullOrNil(this.OrW.oxI.oxt))) {
      d.a(localac, this.OrY, this.OrW.oxI);
    }
    if (!aj.i(this.OrW.oya)) {
      b.a(this.OrY, paramInt1, paramInt2);
    }
    if (aj.i(this.OrW.oya)) {
      this.OrY.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136376);
          i.b(i.this);
          AppMethodBeat.o(136376);
        }
      });
    }
    if (("text".equalsIgnoreCase(this.OrW.cKo)) || ("emoji".equalsIgnoreCase(this.OrW.cKo))) {
      cbn();
    }
    for (;;)
    {
      this.OrY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(136360);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (i.this.OrY == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.OrY.hasFocus())
          {
            i.d(i.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.OrY == paramAnonymousView) {
            i.e(i.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136360);
        }
      });
      bGC();
      return;
      Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.OrW.cKo }), true);
      cbn();
    }
  }
  
  public final int getInputId()
  {
    return this.osn;
  }
  
  public final <P extends View,  extends ac> P getInputPanel()
  {
    return this.OrZ;
  }
  
  public final boolean q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.OrY == null) || (this.OrX == null) || (this.OrX.get() == null)) {}
    for (;;)
    {
      eJ(paramInt1, paramInt2);
      return true;
      this.OrY.performClick();
    }
  }
  
  public final void zZ(int paramInt)
  {
    b localb = this.OrR;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i
 * JD-Core Version:    0.7.0.1
 */