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
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i
  implements aa<y>
{
  final ao lhe = new ao(Looper.getMainLooper());
  public volatile c mCP;
  private volatile a mCQ;
  public volatile b mCR;
  final View.OnFocusChangeListener mCS = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136369);
      if (paramAnonymousBoolean) {
        o.b((com.tencent.mm.plugin.appbrand.page.aa)i.this.mCY.get(), i.this);
      }
      i.a(i.this, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && ((!i.this.mCX.mIv) || (r.cM(i.this.mCZ)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (i.this.mCZ != null) && (i.this.mDa != null))
        {
          i.this.mCZ.requestFocus();
          i.this.mDa.show();
        }
        AppMethodBeat.o(136369);
        return;
      }
    }
  };
  private int mCT = -1;
  private int mCU = -1;
  d mCV = null;
  public int mCW;
  public com.tencent.mm.plugin.appbrand.widget.input.d.e mCX;
  protected WeakReference<com.tencent.mm.plugin.appbrand.page.aa> mCY;
  public y mCZ;
  private final c.a mCu = new p.a()
  {
    public final void ca(String paramAnonymousString)
    {
      AppMethodBeat.i(168763);
      if (i.this.mCZ != null) {
        try
        {
          i.this.mDg.a(i.this.mCZ.getEditableText(), false);
          AppMethodBeat.o(168763);
          return;
        }
        catch (Exception paramAnonymousString) {}
      }
      AppMethodBeat.o(168763);
    }
  };
  w mDa;
  private v mDc;
  private final Runnable mDd = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136371);
      i.c(i.this);
      AppMethodBeat.o(136371);
    }
  };
  int mDe;
  int mDf;
  public final com.tencent.mm.plugin.appbrand.widget.input.c.a mDg = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
  boolean mDh = false;
  final Runnable mDi = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(136372);
      i.this.mDh = false;
      AppMethodBeat.o(136372);
    }
  };
  private final w.d mDj = new w.d()
  {
    public final boolean RU(String paramAnonymousString)
    {
      AppMethodBeat.i(136364);
      if (i.this.mCZ != null)
      {
        if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramAnonymousString)) {
          break label119;
        }
        paramAnonymousString = i.this.mCZ;
        if (paramAnonymousString.mEJ == null) {
          break label86;
        }
        if (!bs.aj(paramAnonymousString.getEditableText())) {
          paramAnonymousString.mEJ.deleteSurroundingText(paramAnonymousString.getEditableText().length(), paramAnonymousString.getEditableText().length() - 1);
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
      y localy = i.this.mCZ;
      f.bzU();
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
  private final w.c mRD = new w.c()
  {
    public final void bM(boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136365);
      if (paramAnonymousBoolean) {
        i.this.mCV = i.d.mDp;
      }
      i.f(i.this);
      i.this.mCV = null;
      AppMethodBeat.o(136365);
    }
  };
  private final w.e mRE = new w.e()
  {
    public final void gs(int paramAnonymousInt)
    {
      AppMethodBeat.i(136366);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (paramAnonymousInt != 2)
      {
        if ((paramAnonymousInt == 0) && (i.this.mCZ != null)) {
          i.this.mCZ.requestFocus();
        }
        i.g(i.this);
        if ((i.this.mCY != null) && (i.this.mCY.get() != null))
        {
          o.a((com.tencent.mm.plugin.appbrand.page.aa)i.this.mCY.get(), i.this.mCZ);
          AppMethodBeat.o(136366);
        }
      }
      else
      {
        i.this.mCV = i.d.mDo;
        i.f(i.this);
        i.this.mCV = null;
      }
      AppMethodBeat.o(136366);
    }
  };
  
  private void bAa()
  {
    if (this.mDa == null) {
      return;
    }
    this.mDa.setOnSmileyChosenListener(this.mDj);
    this.mDa.setOnDoneListener(this.mRD);
    this.mDa.setOnVisibilityChangedListener(this.mRE);
  }
  
  private void bAb()
  {
    Object localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get();
    if (!android.support.v4.view.t.aC(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jHO)) {}
    label169:
    label302:
    label353:
    label377:
    for (;;)
    {
      return;
      this.mDa = w.dj(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jHO);
      if (this.mCX.mIv)
      {
        bAa();
        bAd();
      }
      this.mCZ.a(this.mCS);
      this.mCZ.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(136367);
          paramAnonymousView = i.this;
          boolean bool;
          if (67 == paramAnonymousInt)
          {
            bool = true;
            paramAnonymousView.mDh = bool;
            if (!i.this.mDh) {
              break label86;
            }
            i.this.lhe.removeCallbacks(i.this.mDi);
            i.this.lhe.postDelayed(i.this.mDi, 1000L);
          }
          for (;;)
          {
            AppMethodBeat.o(136367);
            return false;
            bool = false;
            break;
            label86:
            i.this.mDi.run();
          }
        }
      });
      if (this.mCX.mIv) {
        o.a((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get(), this.mCZ);
      }
      localObject = this.mDa;
      boolean bool;
      final int i;
      if ((!this.mCX.cli) && ("emoji".equals(this.mCX.clf)))
      {
        bool = true;
        ((w)localObject).setCanSmileyInput(bool);
        if (this.mCX.mIV != null) {
          break label302;
        }
        i = com.tencent.mm.plugin.appbrand.widget.input.d.b.ic(this.mCX.mIQ.booleanValue()).mIp;
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandInputInvokeHandler", "initSmileyPanelAndShow, myImeOption: ".concat(String.valueOf(i)));
        localObject = null;
        if ((!this.mCX.mIQ.booleanValue()) || (i != 0)) {
          localObject = new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(136368);
              if (paramAnonymousInt == i)
              {
                i.this.mCV = i.d.mDp;
                i.f(i.this);
                i.this.mCV = null;
                AppMethodBeat.o(136368);
                return true;
              }
              AppMethodBeat.o(136368);
              return false;
            }
          };
        }
        this.mCZ.setImeOptions(i);
        this.mCZ.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
        this.mDa.setShowDoneButton(this.mCX.mIR.booleanValue());
        this.mDa.mFa = this.mCZ;
        if (!this.mCX.mIv) {
          break label353;
        }
        bzZ();
      }
      for (;;)
      {
        if (!this.mCX.mIv) {
          break label377;
        }
        k.a(this.mCY).vK(this.mCW);
        return;
        bool = false;
        break;
        if ((!this.mCX.mIQ.booleanValue()) && (com.tencent.mm.plugin.appbrand.widget.input.d.b.mIo == this.mCX.mIV)) {
          this.mCX.mIV = com.tencent.mm.plugin.appbrand.widget.input.d.b.ic(false);
        }
        i = this.mCX.mIV.mIp;
        break label169;
        this.mCZ.setFocusable(false);
        this.mCZ.setFocusableInTouchMode(false);
        this.mDa.hide();
      }
    }
  }
  
  private w bAc()
  {
    if (this.mDa != null) {
      return this.mDa;
    }
    if (this.mCY != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = w.di(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jHO);
    this.mDa = ((w)localObject);
    return localObject;
  }
  
  private void bAd()
  {
    if (bzT() != null) {
      this.mDc.setVisibility(8);
    }
  }
  
  private void bzO()
  {
    if (this.mCZ == null) {
      break label7;
    }
    label7:
    while ((this.mCZ.getLineCount() == this.mCT) && (this.mCZ.bAF() == this.mCU)) {
      return;
    }
    if (this.mCT == -1) {}
    for (int i = 1;; i = 0)
    {
      this.mCT = this.mCZ.getLineCount();
      this.mCU = this.mCZ.bAF();
      if (this.mCP != null) {
        this.mCP.dP(this.mCT, this.mCU);
      }
      if ((!this.mCX.mIQ.booleanValue()) || (i != 0)) {
        break;
      }
      this.mDe = (aj.j(this.mCX.mIB) + aj.j(this.mCX.mIA));
      bzA();
      this.mDf = (aj.j(this.mCX.mIB) + aj.j(this.mCX.mIA));
      hZ(true);
      return;
    }
  }
  
  private v bzT()
  {
    if (this.mDc != null) {
      return this.mDc;
    }
    if (this.mCY != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    if ((((com.tencent.mm.plugin.appbrand.page.aa)localObject).jHO == null) || (!android.support.v4.view.t.aC(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jHO))) {
      return null;
    }
    Object localObject = v.dg(((com.tencent.mm.plugin.appbrand.page.aa)localObject).jHO);
    this.mDc = ((v)localObject);
    return localObject;
  }
  
  private void bzX()
  {
    if (this.mCX.mIQ.booleanValue()) {
      bAc();
    }
    if ((this.mDa != null) && (this.mCZ != null))
    {
      this.mDa.mFa = this.mCZ;
      this.mDa.setShowDoneButton(aj.g(this.mCX.mIR));
      bAa();
      if ((r.cM(this.mCZ)) && (this.mCZ.hasFocus())) {
        this.mDa.show();
      }
    }
  }
  
  private void bzY()
  {
    this.mDa.b(this.mCZ);
    a(this.mCZ);
    this.mCZ.destroy();
    onDestroy();
  }
  
  private void bzZ()
  {
    boolean bool3 = true;
    com.tencent.mm.plugin.appbrand.page.aa localaa;
    boolean bool1;
    label33:
    boolean bool2;
    if (this.mCY == null)
    {
      localaa = null;
      if (this.mDa == null) {
        bAc();
      }
      if (this.mCZ != null) {
        break label116;
      }
      bool1 = true;
      if (localaa != null) {
        break label121;
      }
      bool2 = true;
      label40:
      if (this.mDa != null) {
        break label126;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((localaa != null) && (this.mCZ != null) && (this.mDa != null)) {
        break label131;
      }
      return;
      localaa = (com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get();
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
    o.a(localaa, this.mCZ);
    final PBool localPBool = new PBool();
    localPBool.value = false;
    final Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136361);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
        localPBool.value = true;
        if (i.this.mCY == null) {}
        for (com.tencent.mm.plugin.appbrand.page.aa localaa = null; (localaa == null) || (i.this.mCZ == null); localaa = (com.tencent.mm.plugin.appbrand.page.aa)i.this.mCY.get())
        {
          AppMethodBeat.o(136361);
          return;
        }
        if (o.z(localaa) != i.this)
        {
          AppMethodBeat.o(136361);
          return;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
        h.bzW().d(localaa.lyE);
        aj.jdMethod_do(i.this.mCZ);
        if ((i.this.mDa != null) && (i.this.mDa.b(null))) {
          i.this.mDa.hide();
        }
        i.this.mCZ.a(i.this.mCS);
        i.this.mCZ.setFocusable(true);
        i.this.mCZ.setFocusableInTouchMode(true);
        i.this.mDa.mFa = i.this.mCZ;
        i.this.mCZ.requestFocus();
        aj.jdMethod_do(i.this.mCZ);
        if (i.this.mDa != null) {
          i.this.mDa.show();
        }
        AppMethodBeat.o(136361);
      }
    };
    Object localObject = com.tencent.mm.sdk.f.a.jg(localaa.getContext());
    if ((localObject != null) && (((Activity)localObject).getCurrentFocus() != null))
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      bool1 = aj.dn((View)localObject).isActive((View)localObject);
      bool2 = aj.h(localaa.lyE.getWrapperView(), (View)localObject);
      if ((bool1) && (bool2))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
        this.mDa.setOnVisibilityChangedListener(new w.e()
        {
          public final void gs(int paramAnonymousInt)
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
        com.tencent.e.h.JZN.p(new Runnable()
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
  
  private void et(int paramInt1, int paramInt2)
  {
    b.a(this.mCZ, paramInt1, paramInt2);
    hZ(false);
  }
  
  private void hZ(boolean paramBoolean)
  {
    if ((this.mCX.mIQ.booleanValue()) && (this.mDa != null) && (this.mDa.isShown()) && (this.mCZ != null) && (this.mCZ == this.mDa.getAttachedEditText()))
    {
      if (!paramBoolean) {
        break label204;
      }
      if ((this.mCY == null) || (this.mCY.get() == null) || (((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).bqu() == null)) {
        break label219;
      }
      i = ((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).bqu().getMeasuredHeight();
    }
    label204:
    label219:
    for (int i = ((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).bqu().getScrollY() + i;; i = 0)
    {
      if (((this.mDf > this.mDe) && (this.mDf - this.mCZ.getLineHeight() <= i)) || ((this.mDf <= this.mDe) && (this.mDf + this.mCZ.getLineHeight() <= i)) || (this.mCZ.bAF() >= i)) {
        k.a(this.mCY).vK(this.mCW);
      }
      return;
      k.a(this.mCY).vK(this.mCW);
      return;
    }
  }
  
  private void ia(boolean paramBoolean)
  {
    if (this.mCZ == null) {
      return;
    }
    String str = this.mCZ.getText().toString();
    int i = this.mCZ.getSelectionEnd();
    if (this.mCV == d.mDp) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, i, bool, paramBoolean);
      return;
    }
  }
  
  private void onDestroy()
  {
    this.mCZ = null;
    com.tencent.mm.plugin.appbrand.utils.e.bh(this);
  }
  
  public abstract void Mi(String paramString);
  
  void a(y paramy)
  {
    if (paramy == null) {}
    label58:
    for (;;)
    {
      return;
      paramy.b(this.mCS);
      if (this.mCY == null) {}
      for (Object localObject = null;; localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((com.tencent.mm.plugin.appbrand.page.aa)localObject).bqu();
        if (localObject == null) {
          break;
        }
        ((g)localObject).da(paramy);
        return;
      }
    }
  }
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final void a(String paramString, Integer paramInteger)
  {
    if (this.mCZ == null) {
      return;
    }
    this.mCZ.D(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      et(paramString.intValue(), paramString.intValue());
      bzO();
      return;
    }
  }
  
  boolean a(y paramy, com.tencent.mm.plugin.appbrand.widget.input.d.e parame)
  {
    if ((paramy == null) || (this.mCY == null) || (this.mCY.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).bqu();
    return (localg != null) && (localg.a(((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).lyE, paramy, parame.mIz.intValue(), parame.mIA.intValue(), parame.mIC.intValue(), parame.mIB.intValue()));
  }
  
  public boolean b(y paramy, com.tencent.mm.plugin.appbrand.widget.input.d.e parame)
  {
    if ((paramy == null) || (this.mCY == null) || (this.mCY.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).bqu();
    return (localg != null) && (localg.c(((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).lyE, paramy, parame.mIz.intValue(), parame.mIA.intValue(), parame.mIC.intValue(), parame.mIB.intValue()));
  }
  
  public abstract void bgR();
  
  public abstract void bgS();
  
  final void bzA()
  {
    int k;
    int i;
    if ((this.mCZ != null) && (aj.g(this.mCX.mIS)) && (aj.g(this.mCX.mIQ)))
    {
      ((q)this.mCZ).setAutoHeight(true);
      j = this.mCZ.getLineHeight();
      k = this.mCZ.bAF();
      if ((this.mCX.mIE != null) && (this.mCX.mIE.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.mCX.mIF != null) && (this.mCX.mIF.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.mCX.mIF.intValue(), j))
    {
      this.mCZ.setMinHeight(i);
      this.mCZ.setMaxHeight(j);
      this.mCX.mIA = Integer.valueOf(Math.max(i, Math.min(k, j)));
      b(this.mCZ, this.mCX);
      return;
      i = this.mCX.mIE.intValue();
      break;
    }
  }
  
  public final void bzB()
  {
    b.a(this.mCZ, this.mCX);
    if (this.mCX.mIJ == null)
    {
      this.mCX.mIJ = Integer.valueOf(140);
      c localc = p.a(this.mCZ).acw(this.mCX.mIJ.intValue());
      localc.IVj = false;
      localc.mEd = f.a.IRI;
      localc.a(this.mCu);
      this.mCZ.setPasswordMode(this.mCX.cli);
      if (!aj.g(this.mCX.mIO)) {
        break label236;
      }
      this.mCZ.setEnabled(false);
      this.mCZ.setFocusable(false);
      this.mCZ.setFocusableInTouchMode(false);
      this.mCZ.setClickable(false);
    }
    for (;;)
    {
      if ((this.mCZ instanceof q))
      {
        if (this.mCX.mIY != null) {
          ((q)this.mCZ).setLineSpace(this.mCX.mIY.intValue());
        }
        if (this.mCX.mIZ != null) {
          ((q)this.mCZ).setLineHeight(this.mCX.mIZ.intValue());
        }
      }
      return;
      if (this.mCX.mIJ.intValue() > 0) {
        break;
      }
      this.mCX.mIJ = Integer.valueOf(2147483647);
      break;
      label236:
      this.mCZ.setEnabled(true);
      this.mCZ.setClickable(true);
    }
  }
  
  public final boolean bzL()
  {
    int i;
    if ((this.mCZ == null) || (this.mCY == null) || (this.mCY.get() == null)) {
      i = 0;
    }
    while (i != 0)
    {
      onDestroy();
      return true;
      this.mCZ.destroy();
      g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).bqu();
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        if (this.mCZ.hasFocus())
        {
          if (this.mDc != null) {
            this.mDc.setVisibility(8);
          }
          bAc();
          if (this.mDa != null) {
            this.mDa.setVisibility(8);
          }
        }
        localg.da(this.mCZ);
        i = 1;
      }
    }
    return false;
  }
  
  public final boolean bzQ()
  {
    return (this.mCX != null) && (aj.g(this.mCX.mIX));
  }
  
  public final int bzR()
  {
    if ((this.mCX != null) && (this.mCX.mIU != null)) {
      return this.mCX.mIU.intValue();
    }
    if ((this.mCZ != null) && (this.mCZ.bAo())) {
      return 5;
    }
    return 0;
  }
  
  public final boolean bzS()
  {
    int i;
    if ((this.mCZ != null) && ((this.mCZ.isFocused()) || ((bAc() != null) && (bAc().getAttachedEditText() == this.mCZ))))
    {
      i = 1;
      if (i != 0) {
        break label129;
      }
      if ((this.mCY != null) && (this.mCY.get() != null)) {
        break label83;
      }
      i = 0;
      label63:
      if (i == 0) {
        break label129;
      }
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
    }
    label83:
    Object localObject;
    label129:
    do
    {
      return true;
      i = 0;
      break;
      localObject = ((com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get()).getContext();
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
      localObject = bAc();
    } while (localObject == null);
    ((w)localObject).setVisibility(8);
    return true;
  }
  
  public final boolean eu(int paramInt1, int paramInt2)
  {
    if ((this.mCZ == null) || (this.mCY == null) || (this.mCY.get() == null)) {}
    for (;;)
    {
      et(paramInt1, paramInt2);
      return true;
      this.mCZ.performClick();
    }
  }
  
  public final void ev(int paramInt1, int paramInt2)
  {
    this.mCY = this.mCX.mCq;
    if (this.mCY == null) {}
    for (com.tencent.mm.plugin.appbrand.page.aa localaa = null; (localaa == null) || (localaa.lyE == null); localaa = (com.tencent.mm.plugin.appbrand.page.aa)this.mCY.get())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      bgS();
      return;
    }
    if (aj.g(this.mCX.mIQ)) {}
    for (Object localObject = new q(localaa.getContext());; localObject = new t(localaa.getContext()))
    {
      this.mCZ = ((y)localObject);
      this.mCW = this.mCX.mCo;
      this.mCZ.setInputId(this.mCW);
      o.b(localaa, this);
      bzB();
      this.mCZ.setText(bs.nullAsNil(this.mCX.mIy));
      if (aj.g(this.mCX.mIS)) {
        bzO();
      }
      this.mCZ.addTextChangedListener(new com.tencent.mm.ui.widget.g()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(136373);
          if ((i.this.mCY == null) || (i.this.mCY.get() == null) || (i.this.mCZ == null))
          {
            AppMethodBeat.o(136373);
            return;
          }
          i.b(i.this);
          if (aj.F(paramAnonymousEditable))
          {
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramAnonymousEditable });
            AppMethodBeat.o(136373);
            return;
          }
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramAnonymousEditable });
          paramAnonymousEditable = i.this.mCZ.getEditableText();
          i.this.mDg.a(paramAnonymousEditable, i.this.mDh);
          AppMethodBeat.o(136373);
        }
      });
      this.mCZ.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b()
      {
        public final void BN()
        {
          AppMethodBeat.i(136374);
          if (i.this.mCZ == null)
          {
            AppMethodBeat.o(136374);
            return;
          }
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.this.mCZ.getEditableText() });
          i.this.mDg.a(i.this.mCZ.getEditableText(), false);
          AppMethodBeat.o(136374);
        }
      });
      this.mCZ.setOnKeyUpPostImeListener(new ab.b()
      {
        public final boolean vI(int paramAnonymousInt)
        {
          AppMethodBeat.i(136375);
          if (paramAnonymousInt == 67)
          {
            if (aj.F(i.this.mCZ.getText()))
            {
              AppMethodBeat.o(136375);
              return false;
            }
            i.this.Mi(i.this.mCZ.getText().toString());
            AppMethodBeat.o(136375);
            return true;
          }
          AppMethodBeat.o(136375);
          return false;
        }
      });
      if (a(this.mCZ, this.mCX)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      bgS();
      return;
    }
    if ((this.mCX.mIx != null) && (!bs.gY(this.mCX.mIx.mIi))) {
      d.a(localaa, this.mCZ, this.mCX.mIx);
    }
    if (!aj.g(this.mCX.mIQ)) {
      b.a(this.mCZ, paramInt1, paramInt2);
    }
    if (aj.g(this.mCX.mIQ)) {
      this.mCZ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136376);
          i.b(i.this);
          AppMethodBeat.o(136376);
        }
      });
    }
    if (("text".equalsIgnoreCase(this.mCX.clf)) || ("emoji".equalsIgnoreCase(this.mCX.clf))) {
      bAb();
    }
    for (;;)
    {
      this.mCZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(136360);
          if (i.this.mCZ == null)
          {
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.mCZ.hasFocus())
          {
            i.d(i.this);
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.mCZ == paramAnonymousView) {
            i.e(i.this);
          }
          AppMethodBeat.o(136360);
        }
      });
      bgR();
      return;
      Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.mCX.clf }), true);
      bAb();
    }
  }
  
  public final int getInputId()
  {
    return this.mCW;
  }
  
  public final <P extends View,  extends ac> P getInputPanel()
  {
    return this.mDa;
  }
  
  public final boolean u(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    return (paramaa != null) && (this.mCY != null) && (paramaa == this.mCY.get());
  }
  
  public final void vH(int paramInt)
  {
    b localb = this.mCR;
    if (localb != null) {
      localb.a(this, paramInt);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void a(aa paramaa, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void dP(int paramInt1, int paramInt2);
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(136379);
      mDo = new d("PANEL_HIDDEN", 0);
      mDp = new d("CONFIRM_CLICKED", 1);
      mDq = new d[] { mDo, mDp };
      AppMethodBeat.o(136379);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i
 * JD-Core Version:    0.7.0.1
 */