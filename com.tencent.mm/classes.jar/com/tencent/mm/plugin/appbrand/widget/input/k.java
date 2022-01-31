package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.t;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.Reference;
import java.util.Map;

public class k
  implements f.c
{
  private static final k jlJ;
  private static final android.support.v4.e.a<com.tencent.mm.plugin.appbrand.page.v, k> jlQ;
  private final com.tencent.mm.plugin.appbrand.page.v bCk;
  final Map<k.a, k> jlI;
  private final int jlK;
  private final int jlL;
  private int jlM;
  private boolean jlN;
  private int jlO;
  private int jlP;
  private final Runnable jlR;
  private final Runnable jlS;
  
  static
  {
    AppMethodBeat.i(123673);
    jlJ = new k.1();
    jlQ = new android.support.v4.e.a();
    AppMethodBeat.o(123673);
  }
  
  private k()
  {
    AppMethodBeat.i(123660);
    this.jlI = new android.support.v4.e.a();
    this.jlL = 5;
    this.jlM = 0;
    this.jlN = false;
    this.jlO = -1;
    this.jlP = 0;
    this.jlR = new k.2(this);
    this.jlS = new Runnable()
    {
      private int aQS()
      {
        AppMethodBeat.i(123657);
        View localView = k.b(k.this);
        if (localView != null)
        {
          int i = localView.getScrollY();
          AppMethodBeat.o(123657);
          return i;
        }
        AppMethodBeat.o(123657);
        return 0;
      }
      
      private void b(aa paramAnonymousaa, int paramAnonymousInt)
      {
        AppMethodBeat.i(123656);
        al.d(new k.3.1(this, paramAnonymousaa, paramAnonymousInt));
        AppMethodBeat.o(123656);
      }
      
      private void qt(int paramAnonymousInt)
      {
        AppMethodBeat.i(123658);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        View localView = k.b(k.this);
        if (localView != null)
        {
          localView.scrollTo(0, paramAnonymousInt);
          k.k(k.this);
        }
        AppMethodBeat.o(123658);
      }
      
      public final void run()
      {
        AppMethodBeat.i(123655);
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
        Object localObject = o.s(k.a(k.this));
        if (localObject == null)
        {
          AppMethodBeat.o(123655);
          return;
        }
        if (!k.a(k.this).isRunning())
        {
          AppMethodBeat.o(123655);
          return;
        }
        k.a(k.this, 0);
        if ((((aa)localObject).getInputPanel() == null) || (((aa)localObject).aQw() == null))
        {
          AppMethodBeat.o(123655);
          return;
        }
        EditText localEditText = ((aa)localObject).aQw();
        View localView = ((aa)localObject).getInputPanel();
        if (com.tencent.mm.plugin.appbrand.t.v.cy(localEditText))
        {
          b((aa)localObject, 0);
          AppMethodBeat.o(123655);
          return;
        }
        if (!((ac)localView).aRd())
        {
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[] { Integer.valueOf(localView.getHeight()), Integer.valueOf(k.e(k.this)) });
          if (k.f(k.this) < 5)
          {
            k.g(k.this);
            AppMethodBeat.o(123655);
          }
        }
        else
        {
          k.h(k.this);
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        }
        b((aa)localObject, localView.getHeight());
        if (!((aa)localObject).aQz())
        {
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", new Object[] { Integer.valueOf(localView.getHeight()) });
          AppMethodBeat.o(123655);
          return;
        }
        int[] arrayOfInt = new int[2];
        localEditText.getLocationOnScreen(arrayOfInt);
        int k = arrayOfInt[1];
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[] { Integer.valueOf(localEditText.getHeight()), Integer.valueOf(k), Boolean.valueOf(t.aw(localEditText)) });
        k.i(k.this);
        int i = localEditText.getHeight() + k;
        localView.getLocationOnScreen(arrayOfInt);
        int n = arrayOfInt[1];
        int j;
        int m;
        if ((((ab)localEditText).aQX()) && (localEditText.getLayout() != null))
        {
          j = k + ((ab)localEditText).qz(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()));
          m = k + ((ab)localEditText).qz(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()) + 1);
          if (j - k >= localEditText.getHeight())
          {
            j = i - localEditText.getLineHeight();
            if (m - k < localEditText.getHeight()) {}
          }
        }
        for (;;)
        {
          k = i;
          if (!k.a(k.this).aJx()) {
            k = i + ((aa)localObject).aQA();
          }
          if (n != k)
          {
            if (j < k.j(k.this))
            {
              localObject = k.a(k.this).iuy;
              if (localObject != null)
              {
                localView = ((ap)localObject).getContentView();
                if ((localView != null) && (localEditText != null)) {}
              }
              else
              {
                AppMethodBeat.o(123655);
                return;
              }
              i = -(((ap)localObject).getWebScrollY() - localEditText.getTop());
              localView.scrollBy(localView.getScrollX(), i);
              AppMethodBeat.o(123655);
              return;
            }
            i = Math.max(-aQS(), Math.min(k - n, j - k.j(k.this)));
            localObject = k.a(k.this).iuy;
            if (localObject != null)
            {
              localView = ((ap)localObject).getContentView();
              if ((localView != null) && (localEditText != null)) {}
            }
            else
            {
              AppMethodBeat.o(123655);
              return;
            }
            if (((ab)localEditText).aRb())
            {
              qt(aQS() + i);
              AppMethodBeat.o(123655);
              return;
            }
            j = ((ap)localObject).getHeight();
            k = ((ap)localObject).getWebScrollY();
            m = g.pO(((ap)localObject).getContentHeight());
            n = localEditText.getHeight();
            localEditText.getTop();
            if ((!((ab)localEditText).aQX()) && (localEditText.getTop() + n - k <= j))
            {
              qt(aQS() + i);
              AppMethodBeat.o(123655);
              return;
            }
            j = Math.max(0, Math.min(m - k - j, i));
            localView.scrollBy(localView.getScrollX(), j);
            k.a(k.this, j);
            qt(i - j + aQS());
          }
          AppMethodBeat.o(123655);
          return;
          i = m;
          continue;
          break;
          j = k;
        }
      }
    };
    this.bCk = null;
    this.jlK = 0;
    AppMethodBeat.o(123660);
  }
  
  private k(com.tencent.mm.plugin.appbrand.page.v paramv)
  {
    AppMethodBeat.i(123661);
    this.jlI = new android.support.v4.e.a();
    this.jlL = 5;
    this.jlM = 0;
    this.jlN = false;
    this.jlO = -1;
    this.jlP = 0;
    this.jlR = new k.2(this);
    this.jlS = new Runnable()
    {
      private int aQS()
      {
        AppMethodBeat.i(123657);
        View localView = k.b(k.this);
        if (localView != null)
        {
          int i = localView.getScrollY();
          AppMethodBeat.o(123657);
          return i;
        }
        AppMethodBeat.o(123657);
        return 0;
      }
      
      private void b(aa paramAnonymousaa, int paramAnonymousInt)
      {
        AppMethodBeat.i(123656);
        al.d(new k.3.1(this, paramAnonymousaa, paramAnonymousInt));
        AppMethodBeat.o(123656);
      }
      
      private void qt(int paramAnonymousInt)
      {
        AppMethodBeat.i(123658);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        View localView = k.b(k.this);
        if (localView != null)
        {
          localView.scrollTo(0, paramAnonymousInt);
          k.k(k.this);
        }
        AppMethodBeat.o(123658);
      }
      
      public final void run()
      {
        AppMethodBeat.i(123655);
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
        Object localObject = o.s(k.a(k.this));
        if (localObject == null)
        {
          AppMethodBeat.o(123655);
          return;
        }
        if (!k.a(k.this).isRunning())
        {
          AppMethodBeat.o(123655);
          return;
        }
        k.a(k.this, 0);
        if ((((aa)localObject).getInputPanel() == null) || (((aa)localObject).aQw() == null))
        {
          AppMethodBeat.o(123655);
          return;
        }
        EditText localEditText = ((aa)localObject).aQw();
        View localView = ((aa)localObject).getInputPanel();
        if (com.tencent.mm.plugin.appbrand.t.v.cy(localEditText))
        {
          b((aa)localObject, 0);
          AppMethodBeat.o(123655);
          return;
        }
        if (!((ac)localView).aRd())
        {
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[] { Integer.valueOf(localView.getHeight()), Integer.valueOf(k.e(k.this)) });
          if (k.f(k.this) < 5)
          {
            k.g(k.this);
            AppMethodBeat.o(123655);
          }
        }
        else
        {
          k.h(k.this);
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        }
        b((aa)localObject, localView.getHeight());
        if (!((aa)localObject).aQz())
        {
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", new Object[] { Integer.valueOf(localView.getHeight()) });
          AppMethodBeat.o(123655);
          return;
        }
        int[] arrayOfInt = new int[2];
        localEditText.getLocationOnScreen(arrayOfInt);
        int k = arrayOfInt[1];
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[] { Integer.valueOf(localEditText.getHeight()), Integer.valueOf(k), Boolean.valueOf(t.aw(localEditText)) });
        k.i(k.this);
        int i = localEditText.getHeight() + k;
        localView.getLocationOnScreen(arrayOfInt);
        int n = arrayOfInt[1];
        int j;
        int m;
        if ((((ab)localEditText).aQX()) && (localEditText.getLayout() != null))
        {
          j = k + ((ab)localEditText).qz(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()));
          m = k + ((ab)localEditText).qz(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()) + 1);
          if (j - k >= localEditText.getHeight())
          {
            j = i - localEditText.getLineHeight();
            if (m - k < localEditText.getHeight()) {}
          }
        }
        for (;;)
        {
          k = i;
          if (!k.a(k.this).aJx()) {
            k = i + ((aa)localObject).aQA();
          }
          if (n != k)
          {
            if (j < k.j(k.this))
            {
              localObject = k.a(k.this).iuy;
              if (localObject != null)
              {
                localView = ((ap)localObject).getContentView();
                if ((localView != null) && (localEditText != null)) {}
              }
              else
              {
                AppMethodBeat.o(123655);
                return;
              }
              i = -(((ap)localObject).getWebScrollY() - localEditText.getTop());
              localView.scrollBy(localView.getScrollX(), i);
              AppMethodBeat.o(123655);
              return;
            }
            i = Math.max(-aQS(), Math.min(k - n, j - k.j(k.this)));
            localObject = k.a(k.this).iuy;
            if (localObject != null)
            {
              localView = ((ap)localObject).getContentView();
              if ((localView != null) && (localEditText != null)) {}
            }
            else
            {
              AppMethodBeat.o(123655);
              return;
            }
            if (((ab)localEditText).aRb())
            {
              qt(aQS() + i);
              AppMethodBeat.o(123655);
              return;
            }
            j = ((ap)localObject).getHeight();
            k = ((ap)localObject).getWebScrollY();
            m = g.pO(((ap)localObject).getContentHeight());
            n = localEditText.getHeight();
            localEditText.getTop();
            if ((!((ab)localEditText).aQX()) && (localEditText.getTop() + n - k <= j))
            {
              qt(aQS() + i);
              AppMethodBeat.o(123655);
              return;
            }
            j = Math.max(0, Math.min(m - k - j, i));
            localView.scrollBy(localView.getScrollX(), j);
            k.a(k.this, j);
            qt(i - j + aQS());
          }
          AppMethodBeat.o(123655);
          return;
          i = m;
          continue;
          break;
          j = k;
        }
      }
    };
    this.bCk = paramv;
    this.bCk.a(this);
    this.jlK = com.tencent.mm.ui.statusbar.a.aG(com.tencent.mm.sdk.f.a.hr(paramv.mContext));
    AppMethodBeat.o(123661);
  }
  
  public static k a(Reference<com.tencent.mm.plugin.appbrand.page.v> paramReference)
  {
    AppMethodBeat.i(123662);
    if (paramReference == null) {}
    for (paramReference = null;; paramReference = (com.tencent.mm.plugin.appbrand.page.v)paramReference.get())
    {
      paramReference = p(paramReference);
      AppMethodBeat.o(123662);
      return paramReference;
    }
  }
  
  private void fr(boolean paramBoolean)
  {
    AppMethodBeat.i(123664);
    if (paramBoolean)
    {
      this.jlM = 0;
      this.jlN = false;
    }
    if (!this.bCk.isRunning())
    {
      AppMethodBeat.o(123664);
      return;
    }
    if (this.jlN)
    {
      this.jlM = 0;
      AppMethodBeat.o(123664);
      return;
    }
    if (this.jlM == 0)
    {
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", new Object[] { Boolean.valueOf(t.aw(this.bCk.hmw)) });
      this.bCk.hmw.post(this.jlS);
      AppMethodBeat.o(123664);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", new Object[] { Boolean.valueOf(t.aw(this.bCk.hmw)) });
    this.bCk.hmw.postOnAnimationDelayed(this.jlS, 100L);
    AppMethodBeat.o(123664);
  }
  
  public static k p(com.tencent.mm.plugin.appbrand.page.v paramv)
  {
    AppMethodBeat.i(123663);
    if ((paramv == null) || (!paramv.isRunning()))
    {
      com.tencent.mm.sdk.platformtools.ab.a("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page ".concat(String.valueOf(paramv)), new Object[0]);
      paramv = jlJ;
      AppMethodBeat.o(123663);
      return paramv;
    }
    k localk2 = (k)jlQ.get(paramv);
    k localk1 = localk2;
    if (localk2 == null)
    {
      localk1 = new k(paramv);
      jlQ.put(paramv, localk1);
    }
    AppMethodBeat.o(123663);
    return localk1;
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(123659);
    if (parama == null)
    {
      AppMethodBeat.o(123659);
      return;
    }
    this.jlI.remove(parama);
    AppMethodBeat.o(123659);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123667);
    this.bCk.b(this);
    jlQ.remove(this.bCk);
    AppMethodBeat.o(123667);
  }
  
  public void qr(int paramInt)
  {
    AppMethodBeat.i(123665);
    this.jlO = paramInt;
    fr(true);
    AppMethodBeat.o(123665);
  }
  
  public void qs(int paramInt)
  {
    AppMethodBeat.i(123666);
    if (!this.bCk.isRunning())
    {
      AppMethodBeat.o(123666);
      return;
    }
    if (paramInt != this.jlO)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AppBrandInputPageOffsetHelper", "requestScrollDown, skip last-ticket %d, pass-in-ticket %d", new Object[] { Integer.valueOf(this.jlO), Integer.valueOf(paramInt) });
      AppMethodBeat.o(123666);
      return;
    }
    this.jlN = true;
    this.bCk.hmw.post(this.jlR);
    AppMethodBeat.o(123666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.k
 * JD-Core Version:    0.7.0.1
 */