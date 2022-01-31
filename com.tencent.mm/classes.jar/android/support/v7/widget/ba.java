package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.q;
import android.support.v7.a.a.d;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;

final class ba
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  private static ba ane;
  private static ba anf;
  private final CharSequence Ue;
  private final Runnable acP = new Runnable()
  {
    public final void run()
    {
      ba.c(ba.this);
    }
  };
  private final View amX;
  private final Runnable amY = new Runnable()
  {
    public final void run()
    {
      ba.b(ba.this);
    }
  };
  private int amZ;
  private int ana;
  private bb anb;
  private boolean anc;
  
  private ba(View paramView, CharSequence paramCharSequence)
  {
    this.amX = paramView;
    this.Ue = paramCharSequence;
    this.amX.setOnLongClickListener(this);
    this.amX.setOnHoverListener(this);
  }
  
  private static void a(ba paramba)
  {
    if (ane != null)
    {
      ba localba = ane;
      localba.amX.removeCallbacks(localba.amY);
    }
    ane = paramba;
    if (paramba != null)
    {
      paramba = ane;
      paramba.amX.postDelayed(paramba.amY, ViewConfiguration.getLongPressTimeout());
    }
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if ((ane != null) && (ane.amX == paramView)) {
      a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((anf != null) && (anf.amX == paramView)) {
        anf.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new ba(paramView, paramCharSequence);
  }
  
  private void an(boolean paramBoolean)
  {
    if (!q.ao(this.amX)) {
      return;
    }
    a(null);
    if (anf != null) {
      anf.hide();
    }
    anf = this;
    this.anc = paramBoolean;
    this.anb = new bb(this.amX.getContext());
    bb localbb = this.anb;
    View localView2 = this.amX;
    int i = this.amZ;
    int j = this.ana;
    paramBoolean = this.anc;
    Object localObject1 = this.Ue;
    if (localbb.isShowing()) {
      localbb.hide();
    }
    localbb.ee.setText((CharSequence)localObject1);
    WindowManager.LayoutParams localLayoutParams = localbb.anh;
    localLayoutParams.token = localView2.getApplicationWindowToken();
    int k = localbb.mContext.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_threshold);
    if (localView2.getWidth() < k) {
      i = localView2.getWidth() / 2;
    }
    for (;;)
    {
      int m;
      label224:
      Object localObject2;
      label278:
      label571:
      long l;
      if (localView2.getHeight() >= k)
      {
        m = localbb.mContext.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_extra_offset);
        k = j - m;
        j += m;
        localLayoutParams.gravity = 49;
        localObject1 = localbb.mContext.getResources();
        if (!paramBoolean) {
          break label659;
        }
        m = a.d.tooltip_y_offset_touch;
        int n = ((Resources)localObject1).getDimensionPixelOffset(m);
        View localView1 = localView2.getRootView();
        localObject2 = localView1.getLayoutParams();
        if ((localObject2 instanceof WindowManager.LayoutParams))
        {
          localObject1 = localView1;
          if (((WindowManager.LayoutParams)localObject2).type == 2) {}
        }
        else
        {
          localObject2 = localView2.getContext();
          localObject1 = localView1;
          if ((localObject2 instanceof ContextWrapper))
          {
            if (!(localObject2 instanceof Activity)) {
              break label667;
            }
            localObject1 = ((Activity)localObject2).getWindow().getDecorView();
          }
        }
        if (localObject1 != null)
        {
          ((View)localObject1).getWindowVisibleDisplayFrame(localbb.ani);
          if ((localbb.ani.left < 0) && (localbb.ani.top < 0))
          {
            localObject2 = localbb.mContext.getResources();
            m = ((Resources)localObject2).getIdentifier("status_bar_height", "dimen", "android");
            if (m == 0) {
              break label680;
            }
            m = ((Resources)localObject2).getDimensionPixelSize(m);
            label385:
            localObject2 = ((Resources)localObject2).getDisplayMetrics();
            localbb.ani.set(0, m, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
          }
          ((View)localObject1).getLocationOnScreen(localbb.ank);
          localView2.getLocationOnScreen(localbb.anj);
          localObject2 = localbb.anj;
          localObject2[0] -= localbb.ank[0];
          localObject2 = localbb.anj;
          localObject2[1] -= localbb.ank[1];
          localLayoutParams.x = (localbb.anj[0] + i - ((View)localObject1).getWidth() / 2);
          i = View.MeasureSpec.makeMeasureSpec(0, 0);
          localbb.QR.measure(i, i);
          i = localbb.QR.getMeasuredHeight();
          k = localbb.anj[1] + k - n - i;
          j = j + localbb.anj[1] + n;
          if (!paramBoolean) {
            break label686;
          }
          if (k >= 0) {
            break label709;
          }
          localLayoutParams.y = j;
        }
        ((WindowManager)localbb.mContext.getSystemService("window")).addView(localbb.QR, localbb.anh);
        this.amX.addOnAttachStateChangeListener(this);
        if (!this.anc) {
          break label719;
        }
        l = 2500L;
      }
      for (;;)
      {
        this.amX.removeCallbacks(this.acP);
        this.amX.postDelayed(this.acP, l);
        return;
        j = localView2.getHeight();
        k = 0;
        break;
        label659:
        m = a.d.tooltip_y_offset_non_touch;
        break label224;
        label667:
        localObject2 = ((ContextWrapper)localObject2).getBaseContext();
        break label278;
        label680:
        m = 0;
        break label385;
        label686:
        if (i + j <= localbb.ani.height())
        {
          localLayoutParams.y = j;
          break label571;
        }
        label709:
        localLayoutParams.y = k;
        break label571;
        label719:
        if ((q.ac(this.amX) & 0x1) == 1) {
          l = 3000L - ViewConfiguration.getLongPressTimeout();
        } else {
          l = 15000L - ViewConfiguration.getLongPressTimeout();
        }
      }
    }
  }
  
  private void hide()
  {
    if (anf == this)
    {
      anf = null;
      if (this.anb != null)
      {
        this.anb.hide();
        this.anb = null;
        this.amX.removeOnAttachStateChangeListener(this);
      }
    }
    if (ane == this) {
      a(null);
    }
    this.amX.removeCallbacks(this.acP);
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.anb != null) && (this.anc)) {}
    do
    {
      do
      {
        return false;
        paramView = (AccessibilityManager)this.amX.getContext().getSystemService("accessibility");
      } while ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()));
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      case 9: 
      default: 
        return false;
      }
    } while ((!this.amX.isEnabled()) || (this.anb != null));
    this.amZ = ((int)paramMotionEvent.getX());
    this.ana = ((int)paramMotionEvent.getY());
    a(this);
    return false;
    hide();
    return false;
  }
  
  public final boolean onLongClick(View paramView)
  {
    this.amZ = (paramView.getWidth() / 2);
    this.ana = (paramView.getHeight() / 2);
    an(true);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ba
 * JD-Core Version:    0.7.0.1
 */