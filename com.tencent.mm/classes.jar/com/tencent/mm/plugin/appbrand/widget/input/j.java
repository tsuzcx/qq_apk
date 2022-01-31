package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Build.VERSION;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.appbrand.v.r;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import java.lang.ref.Reference;
import java.util.Map;

public class j
  implements e.c
{
  private static final j htC = new j.1();
  private static final android.support.v4.f.a<com.tencent.mm.plugin.appbrand.page.q, j> htJ = new android.support.v4.f.a();
  private final com.tencent.mm.plugin.appbrand.page.q gkh;
  public final Map<a, j> htB = new android.support.v4.f.a();
  private final int htD;
  private final int htE = 5;
  private int htF = 0;
  private boolean htG = false;
  private int htH = -1;
  private int htI = 0;
  private final Runnable htK = new Runnable()
  {
    public final void run()
    {
      if (!j.a(j.this).ahC) {}
      Object localObject;
      do
      {
        return;
        localObject = j.b(j.this);
      } while (localObject == null);
      ((View)localObject).scrollTo(0, 0);
      if (j.c(j.this) != 0)
      {
        localObject = j.a(j.this).gTF;
        if (localObject != null)
        {
          localObject = ((af)localObject).getContentView();
          if (localObject != null) {
            ((View)localObject).scrollBy(((View)localObject).getScrollX(), -j.c(j.this));
          }
        }
      }
      j.d(j.this);
    }
  };
  private final Runnable htL = new Runnable()
  {
    private void a(z paramAnonymousz, int paramAnonymousInt)
    {
      ai.d(new j.3.1(this, paramAnonymousz, paramAnonymousInt));
    }
    
    private int arO()
    {
      View localView = j.b(j.this);
      if (localView != null) {
        return localView.getScrollY();
      }
      return 0;
    }
    
    private void mO(int paramAnonymousInt)
    {
      y.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      View localView = j.b(j.this);
      if (localView != null)
      {
        localView.scrollTo(0, paramAnonymousInt);
        j.k(j.this);
      }
    }
    
    public final void run()
    {
      y.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
      Object localObject = n.y(j.a(j.this));
      if (localObject == null) {}
      label24:
      do
      {
        break label24;
        break label24;
        break label24;
        break label24;
        do
        {
          return;
        } while (!j.a(j.this).ahC);
        j.a(j.this, 0);
      } while ((((z)localObject).getInputPanel() == null) || (((z)localObject).getWidget() == null));
      EditText localEditText = ((z)localObject).getWidget();
      View localView = ((z)localObject).getInputPanel();
      if (r.bW(localEditText))
      {
        a((z)localObject, 0);
        return;
      }
      if (!((ab)localView).arZ())
      {
        y.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[] { Integer.valueOf(localView.getHeight()), Integer.valueOf(j.e(j.this)) });
        if (j.f(j.this) < 5) {
          j.g(j.this);
        }
      }
      else
      {
        j.h(j.this);
        y.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[] { Integer.valueOf(localView.getHeight()) });
      }
      a((z)localObject, localView.getHeight());
      if (!((z)localObject).adjustPositionOnFocused())
      {
        y.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        return;
      }
      int[] arrayOfInt = new int[2];
      localEditText.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[1];
      y.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[] { Integer.valueOf(localEditText.getHeight()), Integer.valueOf(k), Boolean.valueOf(android.support.v4.view.q.ao(localEditText)) });
      j.i(j.this);
      int i = localEditText.getHeight() + k;
      localView.getLocationOnScreen(arrayOfInt);
      int n = arrayOfInt[1];
      int j;
      int m;
      if ((((aa)localEditText).arT()) && (localEditText.getLayout() != null))
      {
        j = k + ((aa)localEditText).mV(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()));
        m = k + ((aa)localEditText).mV(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()) + 1);
        if (j - k >= localEditText.getHeight())
        {
          j = i - localEditText.getLineHeight();
          label423:
          if (m - k < localEditText.getHeight()) {}
        }
      }
      for (;;)
      {
        k = i;
        if (!j.a(j.this).anp()) {
          k = i + ((z)localObject).getInputPanelMarginBottom();
        }
        if (n == k) {
          break;
        }
        if (j < j.j(j.this))
        {
          localObject = j.a(j.this).gTF;
          if (localObject == null) {
            break;
          }
          localView = ((af)localObject).getContentView();
          if ((localView == null) || (localEditText == null)) {
            break;
          }
          i = -(((af)localObject).getWebScrollY() - localEditText.getTop());
          localView.scrollBy(localView.getScrollX(), i);
          return;
        }
        i = Math.max(-arO(), Math.min(k - n, j - j.j(j.this)));
        localObject = j.a(j.this).gTF;
        if (localObject == null) {
          break;
        }
        localView = ((af)localObject).getContentView();
        if ((localView == null) || (localEditText == null)) {
          break;
        }
        if (((aa)localEditText).arX())
        {
          mO(arO() + i);
          return;
        }
        j = ((af)localObject).getHeight();
        k = ((af)localObject).getWebScrollY();
        m = h.my(((af)localObject).getContentHeight());
        n = localEditText.getHeight();
        localEditText.getTop();
        if ((!((aa)localEditText).arT()) && (localEditText.getTop() + n - k <= j))
        {
          mO(arO() + i);
          return;
        }
        j = Math.max(0, Math.min(m - k - j, i));
        localView.scrollBy(localView.getScrollX(), j);
        j.a(j.this, j);
        mO(i - j + arO());
        return;
        i = m;
        continue;
        break label423;
        j = k;
      }
    }
  };
  
  private j()
  {
    this.gkh = null;
    this.htD = 0;
  }
  
  private j(com.tencent.mm.plugin.appbrand.page.q paramq)
  {
    this.gkh = paramq;
    this.gkh.a(this);
    int j = com.tencent.mm.cb.a.fromDPToPix(paramq.mContext, 10);
    if (Build.VERSION.SDK_INT >= 21) {
      i = ak.gy(paramq.mContext);
    }
    this.htD = (i + j);
  }
  
  public static j a(Reference<com.tencent.mm.plugin.appbrand.page.q> paramReference)
  {
    if (paramReference == null) {}
    for (paramReference = null;; paramReference = (com.tencent.mm.plugin.appbrand.page.q)paramReference.get()) {
      return u(paramReference);
    }
  }
  
  private void dV(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.htF = 0;
      this.htG = false;
    }
    if (!this.gkh.ahC) {
      return;
    }
    if (this.htG)
    {
      this.htF = 0;
      return;
    }
    if (this.htF == 0)
    {
      y.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", new Object[] { Boolean.valueOf(android.support.v4.view.q.ao(this.gkh.getContentView())) });
      this.gkh.getContentView().post(this.htL);
      return;
    }
    y.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", new Object[] { Boolean.valueOf(android.support.v4.view.q.ao(this.gkh.getContentView())) });
    this.gkh.getContentView().postOnAnimationDelayed(this.htL, 100L);
  }
  
  public static j u(com.tencent.mm.plugin.appbrand.page.q paramq)
  {
    if ((paramq == null) || (!paramq.ahC))
    {
      y.b("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page " + paramq, new Object[0]);
      localObject = htC;
    }
    j localj;
    do
    {
      return localObject;
      localj = (j)htJ.get(paramq);
      localObject = localj;
    } while (localj != null);
    Object localObject = new j(paramq);
    htJ.put(paramq, localObject);
    return localObject;
  }
  
  public final void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.htB.remove(parama);
  }
  
  public void mM(int paramInt)
  {
    this.htH = paramInt;
    dV(true);
  }
  
  public void mN(int paramInt)
  {
    if (!this.gkh.ahC) {
      return;
    }
    if (paramInt != this.htH)
    {
      y.w("MicroMsg.AppBrandInputPageOffsetHelper", "requestScrollDown, skip last-ticket %d, pass-in-ticket %d", new Object[] { Integer.valueOf(this.htH), Integer.valueOf(paramInt) });
      return;
    }
    this.htG = true;
    this.gkh.getContentView().post(this.htK);
  }
  
  public void onDestroy()
  {
    this.gkh.b(this);
    htJ.remove(this.gkh);
  }
  
  public static abstract interface a
  {
    public abstract void arP();
    
    public abstract void arQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.j
 * JD-Core Version:    0.7.0.1
 */