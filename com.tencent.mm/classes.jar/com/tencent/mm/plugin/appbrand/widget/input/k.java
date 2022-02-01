package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Build.VERSION;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.lang.ref.Reference;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class k
  implements i.c
{
  private static final k uGf;
  private static final androidx.b.a<ad, k> uGo;
  private final ad enX;
  final Map<a, k> uGe;
  private final int uGg;
  private final int uGh;
  private int uGi;
  private boolean uGj;
  private boolean uGk;
  private int uGl;
  private Queue<b> uGm;
  private int uGn;
  private final Runnable uGp;
  private final Runnable uGq;
  
  static
  {
    AppMethodBeat.i(136407);
    uGf = new k.1();
    uGo = new androidx.b.a();
    AppMethodBeat.o(136407);
  }
  
  private k()
  {
    AppMethodBeat.i(136394);
    this.uGe = new androidx.b.a();
    this.uGh = 5;
    this.uGi = 0;
    this.uGj = false;
    this.uGk = true;
    this.uGl = -1;
    this.uGm = new LinkedList();
    this.uGn = 0;
    this.uGp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136387);
        if (!k.a(k.this).isRunning())
        {
          AppMethodBeat.o(136387);
          return;
        }
        Object localObject = k.b(k.this);
        if (localObject != null)
        {
          ((View)localObject).scrollTo(0, 0);
          if (k.c(k.this) != 0)
          {
            localObject = k.a(k.this).tti;
            if (localObject != null)
            {
              localObject = ((bd)localObject).getContentView();
              if (localObject != null) {
                ((View)localObject).scrollBy(((View)localObject).getScrollX(), -k.c(k.this));
              }
            }
          }
          k.d(k.this);
        }
        AppMethodBeat.o(136387);
      }
    };
    this.uGq = new Runnable()
    {
      private void Eo(int paramAnonymousInt)
      {
        AppMethodBeat.i(136392);
        Log.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        View localView = k.b(k.this);
        if (localView != null)
        {
          localView.scrollTo(0, paramAnonymousInt);
          k.m(k.this);
        }
        AppMethodBeat.o(136392);
      }
      
      private void b(final ae paramAnonymousae, final int paramAnonymousInt)
      {
        AppMethodBeat.i(136390);
        Log.e("MicroMsg.AppBrandInputPageOffsetHelper", "sendKeyboardEvent: %b", new Object[] { Boolean.valueOf(k.f(k.this)) });
        if (!k.f(k.this))
        {
          AppMethodBeat.o(136390);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136388);
            paramAnonymousae.Ej(paramAnonymousInt);
            AppMethodBeat.o(136388);
          }
        });
        AppMethodBeat.o(136390);
      }
      
      private int cRd()
      {
        AppMethodBeat.i(136391);
        View localView = k.b(k.this);
        if (localView != null)
        {
          int i = localView.getScrollY();
          AppMethodBeat.o(136391);
          return i;
        }
        AppMethodBeat.o(136391);
        return 0;
      }
      
      public final void run()
      {
        AppMethodBeat.i(136389);
        Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
        Object localObject2 = o.G(k.a(k.this));
        if (localObject2 == null)
        {
          k.e(k.this);
          AppMethodBeat.o(136389);
          return;
        }
        if (!k.a(k.this).isRunning())
        {
          k.e(k.this);
          AppMethodBeat.o(136389);
          return;
        }
        k.a(k.this, 0);
        if ((((ae)localObject2).getInputPanel() == null) || (((ae)localObject2).cQE() == null))
        {
          k.e(k.this);
          AppMethodBeat.o(136389);
          return;
        }
        EditText localEditText = ((ae)localObject2).cQE();
        Object localObject1 = ((ae)localObject2).getInputPanel();
        if ((Build.VERSION.SDK_INT >= 24) && (localEditText != null))
        {
          localObject3 = AndroidContextUtil.castActivityOrNull(localEditText.getContext());
          if ((localObject3 != null) && (((Activity)localObject3).isInMultiWindowMode()))
          {
            i = 1;
            if (i == 0) {
              break label195;
            }
            b((ae)localObject2, 0);
          }
        }
        for (;;)
        {
          k.e(k.this);
          AppMethodBeat.o(136389);
          return;
          i = 0;
          break;
          label195:
          if (!((ag)localObject1).cRp())
          {
            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[] { Integer.valueOf(((View)localObject1).getHeight()), Integer.valueOf(k.g(k.this)) });
            if (k.h(k.this) < 5)
            {
              k.i(k.this);
              AppMethodBeat.o(136389);
            }
          }
          else
          {
            k.j(k.this);
            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[] { Integer.valueOf(((View)localObject1).getHeight()) });
          }
          b((ae)localObject2, ((View)localObject1).getHeight());
          if (!((ae)localObject2).cQL())
          {
            Log.i("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", new Object[] { Integer.valueOf(((View)localObject1).getHeight()) });
          }
          else
          {
            if ((!(k.a(k.this).qwF instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o)) || (!k.a(k.this).cdZ())) {
              break label397;
            }
            Log.i("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, in landscape skip adjust position, notify height %d", new Object[] { Integer.valueOf(((View)localObject1).getHeight()) });
          }
        }
        label397:
        Object localObject3 = new int[2];
        localEditText.getLocationOnScreen((int[])localObject3);
        int k = localObject3[1];
        Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[] { Integer.valueOf(localEditText.getHeight()), Integer.valueOf(k), Boolean.valueOf(z.ay(localEditText)) });
        k.k(k.this);
        int i = localEditText.getHeight() + k;
        ((View)localObject1).getLocationOnScreen((int[])localObject3);
        int n = localObject3[1];
        if ((localEditText instanceof q)) {}
        for (localObject1 = ((q)localEditText).getAdjustKeyboardTo();; localObject1 = null)
        {
          int m;
          int j;
          if ((((af)localEditText).cRj()) && (localEditText.getLayout() != null) && (!"bottom".equals(localObject1)))
          {
            m = localEditText.getScrollY();
            j = ((af)localEditText).Eu(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart())) + k - m;
            m = ((af)localEditText).Eu(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()) + 1) + k - m;
            if (j - k >= localEditText.getHeight())
            {
              j = i - localEditText.getLineHeight();
              label619:
              if (m - k < localEditText.getHeight()) {}
            }
          }
          for (;;)
          {
            k = i;
            if (!k.a(k.this).cdZ()) {
              k = i + ((ae)localObject2).cQM();
            }
            if (n == k) {
              break;
            }
            if (j < k.l(k.this))
            {
              localObject1 = k.a(k.this).tti;
              if (localObject1 != null)
              {
                localObject2 = ((bd)localObject1).getContentView();
                if ((localObject2 != null) && (localEditText != null)) {
                  break label722;
                }
              }
              for (;;)
              {
                k.e(k.this);
                AppMethodBeat.o(136389);
                return;
                label722:
                i = -(((bd)localObject1).getWebScrollY() - localEditText.getTop());
                ((View)localObject2).scrollBy(((View)localObject2).getScrollX(), i);
              }
            }
            i = Math.max(-cRd(), Math.min(k - n, j - k.l(k.this)));
            localObject1 = k.a(k.this).tti;
            if (localObject1 == null) {
              break;
            }
            localObject2 = ((bd)localObject1).getContentView();
            if ((localObject2 == null) || (localEditText == null)) {
              break;
            }
            if (((af)localEditText).cRn())
            {
              Eo(cRd() + i);
              break;
            }
            j = ((bd)localObject1).getHeight();
            k = ((bd)localObject1).getWebScrollY();
            m = i.DC(((bd)localObject1).getContentHeight());
            n = localEditText.getHeight();
            localEditText.getTop();
            if ((!((af)localEditText).cRj()) && (localEditText.getTop() + n - k <= j))
            {
              Eo(cRd() + i);
              break;
            }
            j = Math.max(0, Math.min(m - k - j, i));
            ((View)localObject2).scrollBy(((View)localObject2).getScrollX(), j);
            k.a(k.this, j);
            Eo(i - j + cRd());
            break;
            i = m;
            continue;
            break label619;
            j = k;
          }
        }
      }
    };
    this.enX = null;
    this.uGg = 0;
    AppMethodBeat.o(136394);
  }
  
  private k(ad paramad)
  {
    AppMethodBeat.i(136395);
    this.uGe = new androidx.b.a();
    this.uGh = 5;
    this.uGi = 0;
    this.uGj = false;
    this.uGk = true;
    this.uGl = -1;
    this.uGm = new LinkedList();
    this.uGn = 0;
    this.uGp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136387);
        if (!k.a(k.this).isRunning())
        {
          AppMethodBeat.o(136387);
          return;
        }
        Object localObject = k.b(k.this);
        if (localObject != null)
        {
          ((View)localObject).scrollTo(0, 0);
          if (k.c(k.this) != 0)
          {
            localObject = k.a(k.this).tti;
            if (localObject != null)
            {
              localObject = ((bd)localObject).getContentView();
              if (localObject != null) {
                ((View)localObject).scrollBy(((View)localObject).getScrollX(), -k.c(k.this));
              }
            }
          }
          k.d(k.this);
        }
        AppMethodBeat.o(136387);
      }
    };
    this.uGq = new Runnable()
    {
      private void Eo(int paramAnonymousInt)
      {
        AppMethodBeat.i(136392);
        Log.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        View localView = k.b(k.this);
        if (localView != null)
        {
          localView.scrollTo(0, paramAnonymousInt);
          k.m(k.this);
        }
        AppMethodBeat.o(136392);
      }
      
      private void b(final ae paramAnonymousae, final int paramAnonymousInt)
      {
        AppMethodBeat.i(136390);
        Log.e("MicroMsg.AppBrandInputPageOffsetHelper", "sendKeyboardEvent: %b", new Object[] { Boolean.valueOf(k.f(k.this)) });
        if (!k.f(k.this))
        {
          AppMethodBeat.o(136390);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136388);
            paramAnonymousae.Ej(paramAnonymousInt);
            AppMethodBeat.o(136388);
          }
        });
        AppMethodBeat.o(136390);
      }
      
      private int cRd()
      {
        AppMethodBeat.i(136391);
        View localView = k.b(k.this);
        if (localView != null)
        {
          int i = localView.getScrollY();
          AppMethodBeat.o(136391);
          return i;
        }
        AppMethodBeat.o(136391);
        return 0;
      }
      
      public final void run()
      {
        AppMethodBeat.i(136389);
        Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
        Object localObject2 = o.G(k.a(k.this));
        if (localObject2 == null)
        {
          k.e(k.this);
          AppMethodBeat.o(136389);
          return;
        }
        if (!k.a(k.this).isRunning())
        {
          k.e(k.this);
          AppMethodBeat.o(136389);
          return;
        }
        k.a(k.this, 0);
        if ((((ae)localObject2).getInputPanel() == null) || (((ae)localObject2).cQE() == null))
        {
          k.e(k.this);
          AppMethodBeat.o(136389);
          return;
        }
        EditText localEditText = ((ae)localObject2).cQE();
        Object localObject1 = ((ae)localObject2).getInputPanel();
        if ((Build.VERSION.SDK_INT >= 24) && (localEditText != null))
        {
          localObject3 = AndroidContextUtil.castActivityOrNull(localEditText.getContext());
          if ((localObject3 != null) && (((Activity)localObject3).isInMultiWindowMode()))
          {
            i = 1;
            if (i == 0) {
              break label195;
            }
            b((ae)localObject2, 0);
          }
        }
        for (;;)
        {
          k.e(k.this);
          AppMethodBeat.o(136389);
          return;
          i = 0;
          break;
          label195:
          if (!((ag)localObject1).cRp())
          {
            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[] { Integer.valueOf(((View)localObject1).getHeight()), Integer.valueOf(k.g(k.this)) });
            if (k.h(k.this) < 5)
            {
              k.i(k.this);
              AppMethodBeat.o(136389);
            }
          }
          else
          {
            k.j(k.this);
            Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[] { Integer.valueOf(((View)localObject1).getHeight()) });
          }
          b((ae)localObject2, ((View)localObject1).getHeight());
          if (!((ae)localObject2).cQL())
          {
            Log.i("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", new Object[] { Integer.valueOf(((View)localObject1).getHeight()) });
          }
          else
          {
            if ((!(k.a(k.this).qwF instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o)) || (!k.a(k.this).cdZ())) {
              break label397;
            }
            Log.i("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, in landscape skip adjust position, notify height %d", new Object[] { Integer.valueOf(((View)localObject1).getHeight()) });
          }
        }
        label397:
        Object localObject3 = new int[2];
        localEditText.getLocationOnScreen((int[])localObject3);
        int k = localObject3[1];
        Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[] { Integer.valueOf(localEditText.getHeight()), Integer.valueOf(k), Boolean.valueOf(z.ay(localEditText)) });
        k.k(k.this);
        int i = localEditText.getHeight() + k;
        ((View)localObject1).getLocationOnScreen((int[])localObject3);
        int n = localObject3[1];
        if ((localEditText instanceof q)) {}
        for (localObject1 = ((q)localEditText).getAdjustKeyboardTo();; localObject1 = null)
        {
          int m;
          int j;
          if ((((af)localEditText).cRj()) && (localEditText.getLayout() != null) && (!"bottom".equals(localObject1)))
          {
            m = localEditText.getScrollY();
            j = ((af)localEditText).Eu(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart())) + k - m;
            m = ((af)localEditText).Eu(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()) + 1) + k - m;
            if (j - k >= localEditText.getHeight())
            {
              j = i - localEditText.getLineHeight();
              label619:
              if (m - k < localEditText.getHeight()) {}
            }
          }
          for (;;)
          {
            k = i;
            if (!k.a(k.this).cdZ()) {
              k = i + ((ae)localObject2).cQM();
            }
            if (n == k) {
              break;
            }
            if (j < k.l(k.this))
            {
              localObject1 = k.a(k.this).tti;
              if (localObject1 != null)
              {
                localObject2 = ((bd)localObject1).getContentView();
                if ((localObject2 != null) && (localEditText != null)) {
                  break label722;
                }
              }
              for (;;)
              {
                k.e(k.this);
                AppMethodBeat.o(136389);
                return;
                label722:
                i = -(((bd)localObject1).getWebScrollY() - localEditText.getTop());
                ((View)localObject2).scrollBy(((View)localObject2).getScrollX(), i);
              }
            }
            i = Math.max(-cRd(), Math.min(k - n, j - k.l(k.this)));
            localObject1 = k.a(k.this).tti;
            if (localObject1 == null) {
              break;
            }
            localObject2 = ((bd)localObject1).getContentView();
            if ((localObject2 == null) || (localEditText == null)) {
              break;
            }
            if (((af)localEditText).cRn())
            {
              Eo(cRd() + i);
              break;
            }
            j = ((bd)localObject1).getHeight();
            k = ((bd)localObject1).getWebScrollY();
            m = i.DC(((bd)localObject1).getContentHeight());
            n = localEditText.getHeight();
            localEditText.getTop();
            if ((!((af)localEditText).cRj()) && (localEditText.getTop() + n - k <= j))
            {
              Eo(cRd() + i);
              break;
            }
            j = Math.max(0, Math.min(m - k - j, i));
            ((View)localObject2).scrollBy(((View)localObject2).getScrollX(), j);
            k.a(k.this, j);
            Eo(i - j + cRd());
            break;
            i = m;
            continue;
            break label619;
            j = k;
          }
        }
      }
    };
    this.enX = paramad;
    this.enX.a(this);
    this.uGg = com.tencent.mm.ui.statusbar.a.cg(paramad.getActivity());
    AppMethodBeat.o(136395);
  }
  
  public static k D(ad paramad)
  {
    AppMethodBeat.i(136397);
    if ((paramad == null) || (!paramad.isRunning()))
    {
      Log.printDebugStack("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page ".concat(String.valueOf(paramad)), new Object[0]);
      paramad = uGf;
      AppMethodBeat.o(136397);
      return paramad;
    }
    k localk2 = (k)uGo.get(paramad);
    k localk1 = localk2;
    if (localk2 == null)
    {
      localk1 = new k(paramad);
      uGo.put(paramad, localk1);
    }
    AppMethodBeat.o(136397);
    return localk1;
  }
  
  public static k a(Reference<ad> paramReference)
  {
    AppMethodBeat.i(136396);
    if (paramReference == null) {}
    for (paramReference = null;; paramReference = (ad)paramReference.get())
    {
      paramReference = D(paramReference);
      AppMethodBeat.o(136396);
      return paramReference;
    }
  }
  
  private void cRc()
  {
    AppMethodBeat.i(324512);
    if (!this.uGm.isEmpty())
    {
      this.uGm.poll();
      if (!this.uGm.isEmpty())
      {
        b localb = (b)this.uGm.peek();
        e(localb.uGu, localb.uGv, true);
      }
    }
    AppMethodBeat.o(324512);
  }
  
  private void lD(boolean paramBoolean)
  {
    AppMethodBeat.i(136398);
    if (paramBoolean)
    {
      this.uGi = 0;
      this.uGj = false;
    }
    if ((this.enX == null) || (!this.enX.isRunning()))
    {
      cRc();
      AppMethodBeat.o(136398);
      return;
    }
    if (this.uGj)
    {
      this.uGi = 0;
      cRc();
      AppMethodBeat.o(136398);
      return;
    }
    if (this.uGi == 0)
    {
      Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", new Object[] { Boolean.valueOf(z.ay(this.enX.getContentView())) });
      this.enX.getContentView().post(this.uGq);
      AppMethodBeat.o(136398);
      return;
    }
    Log.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", new Object[] { Boolean.valueOf(z.ay(this.enX.getContentView())) });
    this.enX.getContentView().postOnAnimationDelayed(this.uGq, 100L);
    AppMethodBeat.o(136398);
  }
  
  public void Em(int paramInt)
  {
    AppMethodBeat.i(136399);
    e(paramInt, true, false);
    AppMethodBeat.o(136399);
  }
  
  public void En(int paramInt)
  {
    AppMethodBeat.i(136400);
    if (this.enX.isRunning())
    {
      if (paramInt != this.uGl)
      {
        Log.w("MicroMsg.AppBrandInputPageOffsetHelper", "requestScrollDown, skip last-ticket %d, pass-in-ticket %d", new Object[] { Integer.valueOf(this.uGl), Integer.valueOf(paramInt) });
        AppMethodBeat.o(136400);
        return;
      }
      this.uGj = true;
      this.uGk = true;
      this.enX.getContentView().post(this.uGp);
    }
    AppMethodBeat.o(136400);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(136393);
    if (parama == null)
    {
      AppMethodBeat.o(136393);
      return;
    }
    this.uGe.remove(parama);
    AppMethodBeat.o(136393);
  }
  
  final void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(324572);
    if (!paramBoolean2) {
      this.uGm.offer(new b(paramInt, paramBoolean1));
    }
    if ((this.uGm.size() <= 1) || (paramBoolean2))
    {
      this.uGl = paramInt;
      this.uGk = paramBoolean1;
      lD(true);
    }
    AppMethodBeat.o(324572);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(136401);
    this.enX.b(this);
    uGo.remove(this.enX);
    AppMethodBeat.o(136401);
  }
  
  public static abstract interface a
  {
    public abstract void cRe();
    
    public abstract void cRf();
  }
  
  static final class b
  {
    public int uGu;
    public boolean uGv;
    
    public b(int paramInt, boolean paramBoolean)
    {
      this.uGu = paramInt;
      this.uGv = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.k
 * JD-Core Version:    0.7.0.1
 */