package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class RecyclerThumbSeekBar
  extends RelativeLayout
  implements c
{
  private RecyclerView fTr;
  private int hTw;
  private String path;
  private int thumbHeight;
  private int thumbWidth;
  private VideoTransPara uKO;
  private int uOL;
  private c.a uOM;
  private c.b uON;
  private c uOO;
  private SliderSeekBar uOP;
  private int uOQ;
  private d.a uOR;
  private Runnable uOS;
  private RecyclerView.m uOT;
  private SliderSeekBar.a uOU;
  
  public RecyclerThumbSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94427);
    this.hTw = -1;
    this.uOR = new d.a(4, new Callable() {});
    this.uOS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94409);
        if ((RecyclerThumbSeekBar.this.getHeight() == 0) || (RecyclerThumbSeekBar.this.getWidth() == 0))
        {
          RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this));
          AppMethodBeat.o(94409);
          return;
        }
        RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.this.getHeight());
        RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this) * 2) / 12);
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94408);
            try
            {
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).ded();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                ac.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              ac.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
              RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
              AppMethodBeat.o(94408);
            }
            if (i == 0)
            {
              RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
              AppMethodBeat.o(94408);
              return;
            }
          }
        }, "check duration of ");
        AppMethodBeat.o(94409);
      }
    };
    this.uOT = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209928);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(209928);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Q(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.uOU = new SliderSeekBar.a()
    {
      public final void del()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).R(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void dem()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).S(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void ob(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).T(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).J(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).J(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
    };
    init();
    AppMethodBeat.o(94427);
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94428);
    this.hTw = -1;
    this.uOR = new d.a(4, new Callable() {});
    this.uOS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94409);
        if ((RecyclerThumbSeekBar.this.getHeight() == 0) || (RecyclerThumbSeekBar.this.getWidth() == 0))
        {
          RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this));
          AppMethodBeat.o(94409);
          return;
        }
        RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.this.getHeight());
        RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this) * 2) / 12);
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94408);
            try
            {
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).ded();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                ac.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              ac.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
              RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
              AppMethodBeat.o(94408);
            }
            if (i == 0)
            {
              RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
              AppMethodBeat.o(94408);
              return;
            }
          }
        }, "check duration of ");
        AppMethodBeat.o(94409);
      }
    };
    this.uOT = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209928);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(209928);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Q(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.uOU = new SliderSeekBar.a()
    {
      public final void del()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).R(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void dem()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).S(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void ob(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).T(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).J(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).J(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
    };
    init();
    AppMethodBeat.o(94428);
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94429);
    this.hTw = -1;
    this.uOR = new d.a(4, new Callable() {});
    this.uOS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94409);
        if ((RecyclerThumbSeekBar.this.getHeight() == 0) || (RecyclerThumbSeekBar.this.getWidth() == 0))
        {
          RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this));
          AppMethodBeat.o(94409);
          return;
        }
        RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.this.getHeight());
        RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this) * 2) / 12);
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94408);
            try
            {
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).ded();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                ac.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              ac.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
              RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
              AppMethodBeat.o(94408);
            }
            if (i == 0)
            {
              RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
              AppMethodBeat.o(94408);
              return;
            }
          }
        }, "check duration of ");
        AppMethodBeat.o(94409);
      }
    };
    this.uOT = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209928);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(209928);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Q(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.uOU = new SliderSeekBar.a()
    {
      public final void del()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).R(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void dem()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).S(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void ob(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).T(RecyclerThumbSeekBar.this.deb(), RecyclerThumbSeekBar.this.dec());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).J(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).J(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
    };
    init();
    AppMethodBeat.o(94429);
  }
  
  private float al(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94439);
    if ((this.uOO == null) || (this.fTr == null))
    {
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    View localView = this.fTr.o(paramInt, 0.0F);
    if (localView == null)
    {
      ac.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    int i = RecyclerView.bw(localView);
    int j = this.uOO.getItemCount();
    if (i <= 1)
    {
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    if (i >= j - 1)
    {
      AppMethodBeat.o(94439);
      return 1.0F;
    }
    float f = (i - 1 + (paramInt - localView.getLeft()) / localView.getWidth()) / (j - 2);
    AppMethodBeat.o(94439);
    return f;
  }
  
  private void dek()
  {
    AppMethodBeat.i(94434);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94411);
        if (RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this) != null) {
          RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this).oa(true);
        }
        AppMethodBeat.o(94411);
      }
    });
    AppMethodBeat.o(94434);
  }
  
  private void init()
  {
    AppMethodBeat.i(94430);
    this.fTr = new RecyclerView(getContext());
    getContext();
    Object localObject = new LinearLayoutManager(0);
    this.fTr.setLayoutManager((RecyclerView.i)localObject);
    this.fTr.setHasFixedSize(true);
    com.tencent.mm.cc.a.au(getContext(), 2131166956);
    this.uOQ = com.tencent.mm.cc.a.au(getContext(), 2131166955);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.fTr, (ViewGroup.LayoutParams)localObject);
    this.uOP = new SliderSeekBar(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.uOP, (ViewGroup.LayoutParams)localObject);
    this.uOP.setOnSliderTouchListener(this.uOU);
    this.fTr.a(this.uOT);
    AppMethodBeat.o(94430);
  }
  
  private void setViewWidth(int paramInt)
  {
    AppMethodBeat.i(94433);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = paramInt;
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(94433);
  }
  
  public final void amb(String paramString)
  {
    AppMethodBeat.i(94432);
    if ((bs.isNullOrNil(paramString)) || (!i.eA(paramString)))
    {
      dek();
      AppMethodBeat.o(94432);
      return;
    }
    this.path = paramString;
    post(this.uOS);
    AppMethodBeat.o(94432);
  }
  
  public final float deb()
  {
    AppMethodBeat.i(94437);
    if (this.uOP == null)
    {
      AppMethodBeat.o(94437);
      return 0.0F;
    }
    float f = al(this.uOP.getLeftSliderBound(), false);
    ac.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", new Object[] { Integer.valueOf(this.uOP.getLeftSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.hTw * f)), Integer.valueOf(this.hTw) });
    AppMethodBeat.o(94437);
    return f;
  }
  
  public final float dec()
  {
    AppMethodBeat.i(94438);
    if (this.uOP == null)
    {
      AppMethodBeat.o(94438);
      return 0.0F;
    }
    float f = al(this.uOP.getRightSliderBound(), true);
    ac.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", new Object[] { Integer.valueOf(this.uOP.getRightSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.hTw * f)) });
    AppMethodBeat.o(94438);
    return f;
  }
  
  public int getDurationMs()
  {
    return this.hTw;
  }
  
  public final void nZ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.uOP.uPj = true;
      return;
    }
    this.uOP.uPj = false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94435);
    this.hTw = -1;
    this.path = null;
    if (this.uOR != null) {
      this.uOR.destroy();
    }
    if ((this.uOO != null) && (c.a(this.uOO) != null))
    {
      d locald = c.a(this.uOO);
      if ((locald.uPe != null) && (locald.uPe.length != 0))
      {
        int i = 0;
        while (i < locald.uPe.length)
        {
          if (locald.uPe[i] != null)
          {
            locald.uPe[i].getSerial().KbG.quit();
            locald.uPe[i] = null;
          }
          i += 1;
        }
      }
      c.b(this.uOO);
      this.uOO = null;
    }
    if (this.uOP != null) {
      this.uOP.reset();
    }
    AppMethodBeat.o(94435);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94436);
    if (this.uOP != null) {
      this.uOP.reset();
    }
    AppMethodBeat.o(94436);
  }
  
  public void setCurrentCursorPosition(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(94431);
    SliderSeekBar localSliderSeekBar = this.uOP;
    float f1 = f2;
    if (this.uOO != null)
    {
      if (this.fTr != null) {
        break label45;
      }
      f1 = f2;
    }
    for (;;)
    {
      localSliderSeekBar.setCursorPos(f1);
      AppMethodBeat.o(94431);
      return;
      label45:
      paramFloat = (this.uOO.getItemCount() - 2) * paramFloat;
      int i = (int)Math.floor(paramFloat);
      float f3 = i;
      Object localObject = this.fTr.ci(i + 1);
      f1 = f2;
      if (localObject != null)
      {
        localObject = ((RecyclerView.w)localObject).asD;
        f1 = ((View)localObject).getLeft();
        f1 = (((View)localObject).getWidth() * (paramFloat - f3) + f1) / getWidth();
      }
    }
  }
  
  public void setOnPreparedListener(c.a parama)
  {
    this.uOM = parama;
  }
  
  public void setThumbBarSeekListener(c.b paramb)
  {
    this.uON = paramb;
  }
  
  public void setVideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.uKO = paramVideoTransPara;
  }
  
  final class a
    implements Runnable
  {
    private Bitmap bitmap;
    private ImageView dhf;
    private RecyclerThumbSeekBar.b uOX;
    
    a(Bitmap paramBitmap, ImageView paramImageView, RecyclerThumbSeekBar.b paramb)
    {
      this.bitmap = paramBitmap;
      this.dhf = paramImageView;
      this.uOX = paramb;
    }
    
    public final void run()
    {
      boolean bool = true;
      AppMethodBeat.i(94416);
      if ((this.bitmap == null) || (this.bitmap.isRecycled()))
      {
        if (this.bitmap == null) {}
        for (;;)
        {
          ac.i("RecyclerThumbSeekBar", "bitmap is null %b in DrawBitmapOnViewTask", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(94416);
          return;
          bool = false;
        }
      }
      if ((this.uOX == null) || (this.uOX.hLV) || (this.dhf == null))
      {
        ac.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
        AppMethodBeat.o(94416);
        return;
      }
      ImageView localImageView = this.dhf;
      localImageView.setTag(null);
      ObjectAnimator.ofInt(localImageView, "imageAlpha", new int[] { 50, 255 }).setDuration(200L).start();
      localImageView.setImageBitmap(this.bitmap);
      AppMethodBeat.o(94416);
    }
  }
  
  final class b
    implements Runnable
  {
    private int gIh;
    boolean hLV;
    private ao handler;
    private WeakReference<ImageView> mn;
    private Bitmap uOY;
    
    b(int paramInt, ImageView paramImageView, Bitmap paramBitmap, ao paramao)
    {
      AppMethodBeat.i(94417);
      this.hLV = false;
      this.gIh = paramInt;
      this.mn = new WeakReference(paramImageView);
      this.handler = paramao;
      this.uOY = paramBitmap;
      AppMethodBeat.o(94417);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94418);
      if (this.hLV)
      {
        o.heJ.f(this.uOY);
        AppMethodBeat.o(94418);
        return;
      }
      if ((ImageView)this.mn.get() == null)
      {
        o.heJ.f(this.uOY);
        AppMethodBeat.o(94418);
        return;
      }
      try
      {
        d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).ded();
        if (this.uOY == null) {
          this.uOY = o.heJ.a(new o.b(locald.getScaledWidth(), locald.getScaledHeight()));
        }
        locald.reuseBitmap(this.uOY);
        if (!this.hLV) {
          this.uOY = locald.getFrameAtTime(this.gIh);
        }
        RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
        if ((this.uOY != null) && (!this.hLV) && (this.mn.get() != null))
        {
          this.handler.post(new RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, this.uOY, (ImageView)this.mn.get(), this));
          AppMethodBeat.o(94418);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.e("RecyclerThumbSeekBar", "get bitmap error " + localException.getMessage());
        o.heJ.f(this.uOY);
        AppMethodBeat.o(94418);
        return;
      }
      o.heJ.f(this.uOY);
      AppMethodBeat.o(94418);
    }
  }
  
  final class c
    extends RecyclerView.a<RecyclerThumbSeekBar.e>
  {
    private RecyclerThumbSeekBar.d uOZ;
    private int uPa;
    private int uPb;
    private View uPc;
    private View uPd;
    
    private c()
    {
      AppMethodBeat.i(94419);
      this.uOZ = new RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this);
      this.uPa = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      this.uPb = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      AppMethodBeat.o(94419);
    }
    
    public final void J(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(94421);
      if (paramBoolean)
      {
        if (this.uPc != null) {
          this.uPc.setMinimumWidth(paramInt);
        }
        if (((LinearLayoutManager)RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).getLayoutManager()).jW() == 0) {
          RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).scrollBy(paramInt - this.uPa, 0);
        }
        this.uPa = paramInt;
        AppMethodBeat.o(94421);
        return;
      }
      this.uPb = paramInt;
      if (this.uPd != null) {
        this.uPd.setMinimumWidth(this.uPb);
      }
      AppMethodBeat.o(94421);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(94422);
      if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0)
      {
        AppMethodBeat.o(94422);
        return 0;
      }
      int i = Math.max(0, (int)Math.floor(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)));
      AppMethodBeat.o(94422);
      return i + 2;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(94420);
      if (paramInt == 0)
      {
        AppMethodBeat.o(94420);
        return 1;
      }
      if (paramInt == getItemCount() - 1)
      {
        AppMethodBeat.o(94420);
        return 2;
      }
      AppMethodBeat.o(94420);
      return 0;
    }
  }
  
  final class d
  {
    ao handler;
    int uLP;
    ao[] uPe;
    int uPf;
    private BlockingDeque<RecyclerThumbSeekBar.b> uPg;
    
    public d()
    {
      AppMethodBeat.i(94425);
      this.handler = new ao();
      this.uLP = 4;
      this.uPe = new ao[this.uLP];
      this.uPf = 0;
      this.uPg = new LinkedBlockingDeque();
      int i = 0;
      while (i < this.uPe.length)
      {
        this.uPe[i] = new ao("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i)));
        i += 1;
      }
      this.uPf = 0;
      AppMethodBeat.o(94425);
    }
  }
  
  final class e
    extends RecyclerView.w
  {
    ImageView dhf;
    
    e(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(94426);
      if (paramInt == 0) {
        this.dhf = ((ImageView)((LinearLayout)paramView).getChildAt(0));
      }
      AppMethodBeat.o(94426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar
 * JD-Core Version:    0.7.0.1
 */