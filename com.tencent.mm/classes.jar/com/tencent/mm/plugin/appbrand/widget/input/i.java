package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i
  implements aa<y>
{
  final aq lIB = new aq(Looper.getMainLooper());
  public volatile c niC;
  private volatile a niD;
  public volatile b niE;
  public int niF;
  final View.OnFocusChangeListener niG = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136369);
      if (paramAnonymousBoolean) {
        o.b((z)i.this.niL.get(), i.this);
      }
      i.a(i.this, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && ((!i.this.niK.noa) || (com.tencent.mm.plugin.appbrand.ui.t.cP(i.this.niM)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (i.this.niM != null) && (i.this.niN != null))
        {
          i.this.niM.requestFocus();
          i.this.niN.show();
        }
        AppMethodBeat.o(136369);
        return;
      }
    }
  };
  private int niH = -1;
  private int niI = -1;
  i.d niJ = null;
  public e niK;
  protected WeakReference<z> niL;
  public y niM;
  w niN;
  private v niO;
  private final Runnable niP = new i.13(this);
  int niQ;
  int niR;
  private final c.a niy = new p.a()
  {
    public final void cW(String paramAnonymousString)
    {
      AppMethodBeat.i(168763);
      if (i.this.niM != null) {
        try
        {
          i.this.nxv.a(i.this.niM.getEditableText(), false);
          AppMethodBeat.o(168763);
          return;
        }
        catch (Exception paramAnonymousString) {}
      }
      AppMethodBeat.o(168763);
    }
  };
  public final com.tencent.mm.plugin.appbrand.widget.input.c.a nxv = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
  boolean nxw = false;
  final Runnable omQ = new i.14(this);
  private final w.d omR = new w.d()
  {
    public final boolean Wd(String paramAnonymousString)
    {
      AppMethodBeat.i(136364);
      if (i.this.niM != null)
      {
        if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramAnonymousString)) {
          break label119;
        }
        paramAnonymousString = i.this.niM;
        if (paramAnonymousString.nkq == null) {
          break label86;
        }
        if (!bu.ah(paramAnonymousString.getEditableText())) {
          paramAnonymousString.nkq.deleteSurroundingText(paramAnonymousString.getEditableText().length(), paramAnonymousString.getEditableText().length() - 1);
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
      y localy = i.this.niM;
      f.bEO();
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
  private final w.c omS = new w.c()
  {
    public final void bM(boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136365);
      if (paramAnonymousBoolean) {
        i.this.niJ = i.d.niX;
      }
      i.f(i.this);
      i.this.niJ = null;
      AppMethodBeat.o(136365);
    }
  };
  private final w.e omT = new w.e()
  {
    public final void gv(int paramAnonymousInt)
    {
      AppMethodBeat.i(136366);
      ae.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (paramAnonymousInt != 2)
      {
        if ((paramAnonymousInt == 0) && (i.this.niM != null)) {
          i.this.niM.requestFocus();
        }
        i.g(i.this);
        if ((i.this.niL != null) && (i.this.niL.get() != null))
        {
          o.a((z)i.this.niL.get(), i.this.niM);
          AppMethodBeat.o(136366);
        }
      }
      else
      {
        i.this.niJ = i.d.niW;
        i.f(i.this);
        i.this.niJ = null;
      }
      AppMethodBeat.o(136366);
    }
  };
  
  private v bEN()
  {
    if (this.niO != null) {
      return this.niO;
    }
    if (this.niL != null)
    {
      localObject = (z)this.niL.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    if ((((z)localObject).kfr == null) || (!android.support.v4.view.t.aC(((z)localObject).kfr))) {
      return null;
    }
    Object localObject = v.di(((z)localObject).kfr);
    this.niO = ((v)localObject);
    return localObject;
  }
  
  private void bEU()
  {
    if (this.niM == null) {
      break label7;
    }
    label7:
    while ((this.niM.getLineCount() == this.niH) && (this.niM.bFz() == this.niI)) {
      return;
    }
    if (this.niH == -1) {}
    for (int i = 1;; i = 0)
    {
      this.niH = this.niM.getLineCount();
      this.niI = this.niM.bFz();
      if (this.niC != null) {
        this.niC.dR(this.niH, this.niI);
      }
      if ((!this.niK.nou.booleanValue()) || (i != 0)) {
        break;
      }
      this.niQ = (aj.k(this.niK.nog) + aj.k(this.niK.nof));
      bES();
      this.niR = (aj.k(this.niK.nog) + aj.k(this.niK.nof));
      hd(true);
      return;
    }
  }
  
  private void bEV()
  {
    if (this.niK.nou.booleanValue()) {
      bFa();
    }
    if ((this.niN != null) && (this.niM != null))
    {
      this.niN.nkH = this.niM;
      this.niN.setShowDoneButton(aj.i(this.niK.nov));
      bEY();
      if ((com.tencent.mm.plugin.appbrand.ui.t.cP(this.niM)) && (this.niM.hasFocus())) {
        this.niN.show();
      }
    }
  }
  
  private void bEW()
  {
    this.niN.b(this.niM);
    a(this.niM);
    this.niM.destroy();
    onDestroy();
  }
  
  private void bEX()
  {
    boolean bool3 = true;
    z localz;
    boolean bool1;
    label33:
    boolean bool2;
    if (this.niL == null)
    {
      localz = null;
      if (this.niN == null) {
        bFa();
      }
      if (this.niM != null) {
        break label116;
      }
      bool1 = true;
      if (localz != null) {
        break label121;
      }
      bool2 = true;
      label40:
      if (this.niN != null) {
        break label126;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((localz != null) && (this.niM != null) && (this.niN != null)) {
        break label131;
      }
      return;
      localz = (z)this.niL.get();
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
    o.a(localz, this.niM);
    final PBool localPBool = new PBool();
    localPBool.value = false;
    final Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136361);
        ae.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
        localPBool.value = true;
        if (i.this.niL == null) {}
        for (z localz = null; (localz == null) || (i.this.niM == null); localz = (z)i.this.niL.get())
        {
          AppMethodBeat.o(136361);
          return;
        }
        if (o.A(localz) != i.this)
        {
          AppMethodBeat.o(136361);
          return;
        }
        ae.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
        h.bEQ().d(localz.mcJ);
        aj.dq(i.this.niM);
        if ((i.this.niN != null) && (i.this.niN.b(null))) {
          i.this.niN.hide();
        }
        i.this.niM.a(i.this.niG);
        i.this.niM.setFocusable(true);
        i.this.niM.setFocusableInTouchMode(true);
        i.this.niN.nkH = i.this.niM;
        i.this.niM.requestFocus();
        aj.dq(i.this.niM);
        if (i.this.niN != null) {
          i.this.niN.show();
        }
        AppMethodBeat.o(136361);
      }
    };
    Object localObject = com.tencent.mm.sdk.f.a.jw(localz.getContext());
    if ((localObject != null) && (((Activity)localObject).getCurrentFocus() != null))
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      bool1 = aj.dp((View)localObject).isActive((View)localObject);
      bool2 = aj.h(localz.mcJ.getWrapperView(), (View)localObject);
      if ((bool1) && (bool2))
      {
        ae.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
        this.niN.setOnVisibilityChangedListener(new w.e()
        {
          public final void gv(int paramAnonymousInt)
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
        com.tencent.e.h.MqF.q(new Runnable()
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
  
  private void bEY()
  {
    if (this.niN == null) {
      return;
    }
    this.niN.setOnSmileyChosenListener(this.omR);
    this.niN.setOnDoneListener(this.omS);
    this.niN.setOnVisibilityChangedListener(this.omT);
  }
  
  private void bEZ()
  {
    Object localObject = (z)this.niL.get();
    if (!android.support.v4.view.t.aC(((z)localObject).kfr)) {}
    label169:
    label302:
    label353:
    label377:
    for (;;)
    {
      return;
      this.niN = w.dl(((z)localObject).kfr);
      if (this.niK.noa)
      {
        bEY();
        bGg();
      }
      this.niM.a(this.niG);
      this.niM.setOnKeyListener(new i.9(this));
      if (this.niK.noa) {
        o.a((z)this.niL.get(), this.niM);
      }
      localObject = this.niN;
      boolean bool;
      final int i;
      if ((!this.niK.cwo) && ("emoji".equals(this.niK.cwl)))
      {
        bool = true;
        ((w)localObject).setCanSmileyInput(bool);
        if (this.niK.noz != null) {
          break label302;
        }
        i = com.tencent.mm.plugin.appbrand.widget.input.d.b.ij(this.niK.nou.booleanValue()).nnU;
        ae.d("MicroMsg.AppBrandInputInvokeHandler", "initSmileyPanelAndShow, myImeOption: ".concat(String.valueOf(i)));
        localObject = null;
        if ((!this.niK.nou.booleanValue()) || (i != 0)) {
          localObject = new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(136368);
              if (paramAnonymousInt == i)
              {
                i.this.niJ = i.d.niX;
                i.f(i.this);
                i.this.niJ = null;
                AppMethodBeat.o(136368);
                return true;
              }
              AppMethodBeat.o(136368);
              return false;
            }
          };
        }
        this.niM.setImeOptions(i);
        this.niM.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
        this.niN.setShowDoneButton(this.niK.nov.booleanValue());
        this.niN.nkH = this.niM;
        if (!this.niK.noa) {
          break label353;
        }
        bEX();
      }
      for (;;)
      {
        if (!this.niK.noa) {
          break label377;
        }
        k.a(this.niL).wu(this.niF);
        return;
        bool = false;
        break;
        if ((!this.niK.nou.booleanValue()) && (com.tencent.mm.plugin.appbrand.widget.input.d.b.nnT == this.niK.noz)) {
          this.niK.noz = com.tencent.mm.plugin.appbrand.widget.input.d.b.ij(false);
        }
        i = this.niK.noz.nnU;
        break label169;
        this.niM.setFocusable(false);
        this.niM.setFocusableInTouchMode(false);
        this.niN.hide();
      }
    }
  }
  
  private w bFa()
  {
    if (this.niN != null) {
      return this.niN;
    }
    if (this.niL != null)
    {
      localObject = (z)this.niL.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = w.dk(((z)localObject).kfr);
    this.niN = ((w)localObject);
    return localObject;
  }
  
  private void bGg()
  {
    if (bEN() != null) {
      this.niO.setVisibility(8);
    }
  }
  
  private void ev(int paramInt1, int paramInt2)
  {
    b.a(this.niM, paramInt1, paramInt2);
    hd(false);
  }
  
  private void hd(boolean paramBoolean)
  {
    if ((this.niK.nou.booleanValue()) && (this.niN != null) && (this.niN.isShown()) && (this.niM != null) && (this.niM == this.niN.getAttachedEditText()))
    {
      if (!paramBoolean) {
        break label204;
      }
      if ((this.niL == null) || (this.niL.get() == null) || (((z)this.niL.get()).bve() == null)) {
        break label219;
      }
      i = ((z)this.niL.get()).bve().getMeasuredHeight();
    }
    label204:
    label219:
    for (int i = ((z)this.niL.get()).bve().getScrollY() + i;; i = 0)
    {
      if (((this.niR > this.niQ) && (this.niR - this.niM.getLineHeight() <= i)) || ((this.niR <= this.niQ) && (this.niR + this.niM.getLineHeight() <= i)) || (this.niM.bFz() >= i)) {
        k.a(this.niL).wu(this.niF);
      }
      return;
      k.a(this.niL).wu(this.niF);
      return;
    }
  }
  
  private void ig(boolean paramBoolean)
  {
    if (this.niM == null) {
      return;
    }
    String str = this.niM.getText().toString();
    int i = this.niM.getSelectionEnd();
    if (this.niJ == i.d.niX) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, i, bool, paramBoolean);
      return;
    }
  }
  
  private void onDestroy()
  {
    this.niM = null;
    com.tencent.mm.plugin.appbrand.utils.f.bj(this);
  }
  
  public abstract void Qm(String paramString);
  
  void a(y paramy)
  {
    if (paramy == null) {}
    label58:
    for (;;)
    {
      return;
      paramy.b(this.niG);
      if (this.niL == null) {}
      for (Object localObject = null;; localObject = (z)this.niL.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((z)localObject).bve();
        if (localObject == null) {
          break;
        }
        ((g)localObject).dc(paramy);
        return;
      }
    }
  }
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final void a(String paramString, Integer paramInteger)
  {
    if (this.niM == null) {
      return;
    }
    this.niM.C(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      ev(paramString.intValue(), paramString.intValue());
      bEU();
      return;
    }
  }
  
  boolean a(y paramy, e parame)
  {
    if ((paramy == null) || (this.niL == null) || (this.niL.get() == null)) {
      return false;
    }
    g localg = (g)((z)this.niL.get()).bve();
    return (localg != null) && (localg.a(((z)this.niL.get()).mcJ, paramy, parame.noe.intValue(), parame.nof.intValue(), parame.noh.intValue(), parame.nog.intValue()));
  }
  
  public boolean b(y paramy, e parame)
  {
    if ((paramy == null) || (this.niL == null) || (this.niL.get() == null)) {
      return false;
    }
    g localg = (g)((z)this.niL.get()).bve();
    return (localg != null) && (localg.c(((z)this.niL.get()).mcJ, paramy, parame.noe.intValue(), parame.nof.intValue(), parame.noh.intValue(), parame.nog.intValue()));
  }
  
  public final boolean bEG()
  {
    int i;
    if ((this.niM == null) || (this.niL == null) || (this.niL.get() == null)) {
      i = 0;
    }
    while (i != 0)
    {
      onDestroy();
      return true;
      this.niM.destroy();
      g localg = (g)((z)this.niL.get()).bve();
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        if (this.niM.hasFocus())
        {
          if (this.niO != null) {
            this.niO.setVisibility(8);
          }
          bFa();
          if (this.niN != null) {
            this.niN.setVisibility(8);
          }
        }
        localg.dc(this.niM);
        i = 1;
      }
    }
    return false;
  }
  
  public final boolean bEK()
  {
    return (this.niK != null) && (aj.i(this.niK.noB));
  }
  
  public final int bEL()
  {
    if ((this.niK != null) && (this.niK.noy != null)) {
      return this.niK.noy.intValue();
    }
    if ((this.niM != null) && (this.niM.bFi())) {
      return 5;
    }
    return 0;
  }
  
  public final boolean bEM()
  {
    int i;
    if ((this.niM != null) && ((this.niM.isFocused()) || ((bFa() != null) && (bFa().getAttachedEditText() == this.niM))))
    {
      i = 1;
      if (i != 0) {
        break label129;
      }
      if ((this.niL != null) && (this.niL.get() != null)) {
        break label83;
      }
      i = 0;
      label63:
      if (i == 0) {
        break label129;
      }
      ae.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
    }
    label83:
    Object localObject;
    label129:
    do
    {
      return true;
      i = 0;
      break;
      localObject = ((z)this.niL.get()).getContext();
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
      localObject = bFa();
    } while (localObject == null);
    ((w)localObject).setVisibility(8);
    return true;
  }
  
  final void bES()
  {
    int k;
    int i;
    if ((this.niM != null) && (aj.i(this.niK.now)) && (aj.i(this.niK.nou)))
    {
      ((q)this.niM).setAutoHeight(true);
      j = this.niM.getLineHeight();
      k = this.niM.bFz();
      if ((this.niK.noi != null) && (this.niK.noi.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.niK.noj != null) && (this.niK.noj.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.niK.noj.intValue(), j))
    {
      this.niM.setMinHeight(i);
      this.niM.setMaxHeight(j);
      this.niK.nof = Integer.valueOf(Math.max(i, Math.min(k, j)));
      b(this.niM, this.niK);
      return;
      i = this.niK.noi.intValue();
      break;
    }
  }
  
  public final void bET()
  {
    b.a(this.niM, this.niK);
    if (this.niK.non == null)
    {
      this.niK.non = Integer.valueOf(140);
      c localc = p.a(this.niM).afD(this.niK.non.intValue());
      localc.LiL = false;
      localc.njK = f.a.Lfg;
      localc.a(this.niy);
      this.niM.setPasswordMode(this.niK.cwo);
      if (!aj.i(this.niK.nos)) {
        break label236;
      }
      this.niM.setEnabled(false);
      this.niM.setFocusable(false);
      this.niM.setFocusableInTouchMode(false);
      this.niM.setClickable(false);
    }
    for (;;)
    {
      if ((this.niM instanceof q))
      {
        if (this.niK.noC != null) {
          ((q)this.niM).setLineSpace(this.niK.noC.intValue());
        }
        if (this.niK.noD != null) {
          ((q)this.niM).setLineHeight(this.niK.noD.intValue());
        }
      }
      return;
      if (this.niK.non.intValue() > 0) {
        break;
      }
      this.niK.non = Integer.valueOf(2147483647);
      break;
      label236:
      this.niM.setEnabled(true);
      this.niM.setClickable(true);
    }
  }
  
  public abstract void blg();
  
  public abstract void blh();
  
  public final boolean ew(int paramInt1, int paramInt2)
  {
    if ((this.niM == null) || (this.niL == null) || (this.niL.get() == null)) {}
    for (;;)
    {
      ev(paramInt1, paramInt2);
      return true;
      this.niM.performClick();
    }
  }
  
  public final void ex(int paramInt1, int paramInt2)
  {
    this.niL = this.niK.nhZ;
    if (this.niL == null) {}
    for (z localz = null; (localz == null) || (localz.mcJ == null); localz = (z)this.niL.get())
    {
      ae.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      blh();
      return;
    }
    if (aj.i(this.niK.nou)) {}
    for (Object localObject = new q(localz.getContext());; localObject = new t(localz.getContext()))
    {
      this.niM = ((y)localObject);
      this.niF = this.niK.nhX;
      this.niM.setInputId(this.niF);
      o.b(localz, this);
      bET();
      this.niM.setText(bu.nullAsNil(this.niK.nod));
      if (aj.i(this.niK.now)) {
        bEU();
      }
      this.niM.addTextChangedListener(new com.tencent.mm.ui.widget.g()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(136373);
          if ((i.this.niL == null) || (i.this.niL.get() == null) || (i.this.niM == null))
          {
            AppMethodBeat.o(136373);
            return;
          }
          i.b(i.this);
          if (aj.E(paramAnonymousEditable))
          {
            ae.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramAnonymousEditable });
            AppMethodBeat.o(136373);
            return;
          }
          ae.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramAnonymousEditable });
          paramAnonymousEditable = i.this.niM.getEditableText();
          i.this.nxv.a(paramAnonymousEditable, i.this.nxw);
          AppMethodBeat.o(136373);
        }
      });
      this.niM.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b()
      {
        public final void Dp()
        {
          AppMethodBeat.i(136374);
          if (i.this.niM == null)
          {
            AppMethodBeat.o(136374);
            return;
          }
          ae.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.this.niM.getEditableText() });
          i.this.nxv.a(i.this.niM.getEditableText(), false);
          AppMethodBeat.o(136374);
        }
      });
      this.niM.setOnKeyUpPostImeListener(new ab.b()
      {
        public final boolean ws(int paramAnonymousInt)
        {
          AppMethodBeat.i(136375);
          if (paramAnonymousInt == 67)
          {
            if (aj.E(i.this.niM.getText()))
            {
              AppMethodBeat.o(136375);
              return false;
            }
            i.this.Qm(i.this.niM.getText().toString());
            AppMethodBeat.o(136375);
            return true;
          }
          AppMethodBeat.o(136375);
          return false;
        }
      });
      if (a(this.niM, this.niK)) {
        break;
      }
      ae.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      blh();
      return;
    }
    if ((this.niK.noc != null) && (!bu.ht(this.niK.noc.nnN))) {
      d.a(localz, this.niM, this.niK.noc);
    }
    if (!aj.i(this.niK.nou)) {
      b.a(this.niM, paramInt1, paramInt2);
    }
    if (aj.i(this.niK.nou)) {
      this.niM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136376);
          i.b(i.this);
          AppMethodBeat.o(136376);
        }
      });
    }
    if (("text".equalsIgnoreCase(this.niK.cwl)) || ("emoji".equalsIgnoreCase(this.niK.cwl))) {
      bEZ();
    }
    for (;;)
    {
      this.niM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(136360);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (i.this.niM == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.niM.hasFocus())
          {
            i.d(i.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.niM == paramAnonymousView) {
            i.e(i.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136360);
        }
      });
      blg();
      return;
      Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.niK.cwl }), true);
      bEZ();
    }
  }
  
  public final int getInputId()
  {
    return this.niF;
  }
  
  public final <P extends View,  extends ac> P getInputPanel()
  {
    return this.niN;
  }
  
  public final boolean v(z paramz)
  {
    return (paramz != null) && (this.niL != null) && (paramz == this.niL.get());
  }
  
  public final void wr(int paramInt)
  {
    b localb = this.niE;
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
    public abstract void dR(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i
 * JD-Core Version:    0.7.0.1
 */