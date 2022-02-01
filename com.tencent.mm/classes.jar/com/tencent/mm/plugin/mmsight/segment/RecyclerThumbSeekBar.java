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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class RecyclerThumbSeekBar
  extends RelativeLayout
  implements c
{
  private RecyclerView gmV;
  private int imR;
  private String path;
  private int thumbHeight;
  private int thumbWidth;
  private VideoTransPara vNU;
  private int vRU;
  private c.a vRV;
  private c.b vRW;
  private c vRX;
  private SliderSeekBar vRY;
  private int vRZ;
  private d.a vSa;
  private Runnable vSb;
  private RecyclerView.m vSc;
  private SliderSeekBar.a vSd;
  
  public RecyclerThumbSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94427);
    this.imR = -1;
    this.vSa = new d.a(4, new Callable() {});
    this.vSb = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).dnB();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                ad.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              ad.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
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
    this.vSc = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(214485);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(214485);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).S(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.vSd = new SliderSeekBar.a()
    {
      public final void dnJ()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).T(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void dnK()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).U(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void ov(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).V(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
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
    this.imR = -1;
    this.vSa = new d.a(4, new Callable() {});
    this.vSb = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).dnB();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                ad.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              ad.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
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
    this.vSc = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(214485);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(214485);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).S(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.vSd = new SliderSeekBar.a()
    {
      public final void dnJ()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).T(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void dnK()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).U(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void ov(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).V(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
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
    this.imR = -1;
    this.vSa = new d.a(4, new Callable() {});
    this.vSb = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).dnB();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                ad.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              ad.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
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
    this.vSc = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(214485);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(214485);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).S(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.vSd = new SliderSeekBar.a()
    {
      public final void dnJ()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).T(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void dnK()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).U(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void ov(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).V(RecyclerThumbSeekBar.this.dnz(), RecyclerThumbSeekBar.this.dnA());
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
  
  private float ap(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94439);
    if ((this.vRX == null) || (this.gmV == null))
    {
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    View localView = this.gmV.o(paramInt, 0.0F);
    if (localView == null)
    {
      ad.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    int i = RecyclerView.bw(localView);
    int j = this.vRX.getItemCount();
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
  
  private void dnI()
  {
    AppMethodBeat.i(94434);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94411);
        if (RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this) != null) {
          RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this).ou(true);
        }
        AppMethodBeat.o(94411);
      }
    });
    AppMethodBeat.o(94434);
  }
  
  private void init()
  {
    AppMethodBeat.i(94430);
    this.gmV = new RecyclerView(getContext());
    getContext();
    Object localObject = new LinearLayoutManager(0);
    this.gmV.setLayoutManager((RecyclerView.i)localObject);
    this.gmV.setHasFixedSize(true);
    com.tencent.mm.cc.a.ax(getContext(), 2131166956);
    this.vRZ = com.tencent.mm.cc.a.ax(getContext(), 2131166955);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.gmV, (ViewGroup.LayoutParams)localObject);
    this.vRY = new SliderSeekBar(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.vRY, (ViewGroup.LayoutParams)localObject);
    this.vRY.setOnSliderTouchListener(this.vSd);
    this.gmV.a(this.vSc);
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
  
  public final void aqQ(String paramString)
  {
    AppMethodBeat.i(94432);
    if ((bt.isNullOrNil(paramString)) || (!i.fv(paramString)))
    {
      dnI();
      AppMethodBeat.o(94432);
      return;
    }
    this.path = paramString;
    post(this.vSb);
    AppMethodBeat.o(94432);
  }
  
  public final float dnA()
  {
    AppMethodBeat.i(94438);
    if (this.vRY == null)
    {
      AppMethodBeat.o(94438);
      return 0.0F;
    }
    float f = ap(this.vRY.getRightSliderBound(), true);
    ad.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", new Object[] { Integer.valueOf(this.vRY.getRightSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.imR * f)) });
    AppMethodBeat.o(94438);
    return f;
  }
  
  public final float dnz()
  {
    AppMethodBeat.i(94437);
    if (this.vRY == null)
    {
      AppMethodBeat.o(94437);
      return 0.0F;
    }
    float f = ap(this.vRY.getLeftSliderBound(), false);
    ad.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", new Object[] { Integer.valueOf(this.vRY.getLeftSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.imR * f)), Integer.valueOf(this.imR) });
    AppMethodBeat.o(94437);
    return f;
  }
  
  public int getDurationMs()
  {
    return this.imR;
  }
  
  public final void ot(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.vRY.vSs = true;
      return;
    }
    this.vRY.vSs = false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94435);
    this.imR = -1;
    this.path = null;
    if (this.vSa != null) {
      this.vSa.destroy();
    }
    if ((this.vRX != null) && (c.a(this.vRX) != null))
    {
      d locald = c.a(this.vRX);
      if ((locald.vSn != null) && (locald.vSn.length != 0))
      {
        int i = 0;
        while (i < locald.vSn.length)
        {
          if (locald.vSn[i] != null)
          {
            locald.vSn[i].getSerial().LVC.quit();
            locald.vSn[i] = null;
          }
          i += 1;
        }
      }
      c.b(this.vRX);
      this.vRX = null;
    }
    if (this.vRY != null) {
      this.vRY.reset();
    }
    AppMethodBeat.o(94435);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94436);
    if (this.vRY != null) {
      this.vRY.reset();
    }
    AppMethodBeat.o(94436);
  }
  
  public void setCurrentCursorPosition(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(94431);
    SliderSeekBar localSliderSeekBar = this.vRY;
    float f1 = f2;
    if (this.vRX != null)
    {
      if (this.gmV != null) {
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
      paramFloat = (this.vRX.getItemCount() - 2) * paramFloat;
      int i = (int)Math.floor(paramFloat);
      float f3 = i;
      Object localObject = this.gmV.ci(i + 1);
      f1 = f2;
      if (localObject != null)
      {
        localObject = ((RecyclerView.w)localObject).auu;
        f1 = ((View)localObject).getLeft();
        f1 = (((View)localObject).getWidth() * (paramFloat - f3) + f1) / getWidth();
      }
    }
  }
  
  public void setOnPreparedListener(c.a parama)
  {
    this.vRV = parama;
  }
  
  public void setThumbBarSeekListener(c.b paramb)
  {
    this.vRW = paramb;
  }
  
  public void setVideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.vNU = paramVideoTransPara;
  }
  
  final class a
    implements Runnable
  {
    private Bitmap bitmap;
    private ImageView dsD;
    private RecyclerThumbSeekBar.b vSg;
    
    a(Bitmap paramBitmap, ImageView paramImageView, RecyclerThumbSeekBar.b paramb)
    {
      this.bitmap = paramBitmap;
      this.dsD = paramImageView;
      this.vSg = paramb;
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
          ad.i("RecyclerThumbSeekBar", "bitmap is null %b in DrawBitmapOnViewTask", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(94416);
          return;
          bool = false;
        }
      }
      if ((this.vSg == null) || (this.vSg.ieP) || (this.dsD == null))
      {
        ad.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
        AppMethodBeat.o(94416);
        return;
      }
      ImageView localImageView = this.dsD;
      localImageView.setTag(null);
      ObjectAnimator.ofInt(localImageView, "imageAlpha", new int[] { 50, 255 }).setDuration(200L).start();
      localImageView.setImageBitmap(this.bitmap);
      AppMethodBeat.o(94416);
    }
  }
  
  final class b
    implements Runnable
  {
    private ap handler;
    private int hbR;
    boolean ieP;
    private WeakReference<ImageView> og;
    private Bitmap vSh;
    
    b(int paramInt, ImageView paramImageView, Bitmap paramBitmap, ap paramap)
    {
      AppMethodBeat.i(94417);
      this.ieP = false;
      this.hbR = paramInt;
      this.og = new WeakReference(paramImageView);
      this.handler = paramap;
      this.vSh = paramBitmap;
      AppMethodBeat.o(94417);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94418);
      if (this.ieP)
      {
        o.hwR.f(this.vSh);
        AppMethodBeat.o(94418);
        return;
      }
      if ((ImageView)this.og.get() == null)
      {
        o.hwR.f(this.vSh);
        AppMethodBeat.o(94418);
        return;
      }
      try
      {
        d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).dnB();
        if (this.vSh == null) {
          this.vSh = o.hwR.a(new o.b(locald.getScaledWidth(), locald.getScaledHeight()));
        }
        locald.reuseBitmap(this.vSh);
        if (!this.ieP) {
          this.vSh = locald.getFrameAtTime(this.hbR);
        }
        RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
        if ((this.vSh != null) && (!this.ieP) && (this.og.get() != null))
        {
          this.handler.post(new RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, this.vSh, (ImageView)this.og.get(), this));
          AppMethodBeat.o(94418);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.e("RecyclerThumbSeekBar", "get bitmap error " + localException.getMessage());
        o.hwR.f(this.vSh);
        AppMethodBeat.o(94418);
        return;
      }
      o.hwR.f(this.vSh);
      AppMethodBeat.o(94418);
    }
  }
  
  final class c
    extends RecyclerView.a<RecyclerThumbSeekBar.e>
  {
    private RecyclerThumbSeekBar.d vSi;
    private int vSj;
    private int vSk;
    private View vSl;
    private View vSm;
    
    private c()
    {
      AppMethodBeat.i(94419);
      this.vSi = new RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this);
      this.vSj = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      this.vSk = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      AppMethodBeat.o(94419);
    }
    
    public final void J(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(94421);
      if (paramBoolean)
      {
        if (this.vSl != null) {
          this.vSl.setMinimumWidth(paramInt);
        }
        if (((LinearLayoutManager)RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).getLayoutManager()).km() == 0) {
          RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).scrollBy(paramInt - this.vSj, 0);
        }
        this.vSj = paramInt;
        AppMethodBeat.o(94421);
        return;
      }
      this.vSk = paramInt;
      if (this.vSm != null) {
        this.vSm.setMinimumWidth(this.vSk);
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
    ap handler;
    int vOV;
    ap[] vSn;
    int vSo;
    private BlockingDeque<RecyclerThumbSeekBar.b> vSp;
    
    public d()
    {
      AppMethodBeat.i(94425);
      this.handler = new ap();
      this.vOV = 4;
      this.vSn = new ap[this.vOV];
      this.vSo = 0;
      this.vSp = new LinkedBlockingDeque();
      int i = 0;
      while (i < this.vSn.length)
      {
        this.vSn[i] = new ap("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i)));
        i += 1;
      }
      this.vSo = 0;
      AppMethodBeat.o(94425);
    }
  }
  
  final class e
    extends RecyclerView.w
  {
    ImageView dsD;
    
    e(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(94426);
      if (paramInt == 0) {
        this.dsD = ((ImageView)((LinearLayout)paramView).getChildAt(0));
      }
      AppMethodBeat.o(94426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar
 * JD-Core Version:    0.7.0.1
 */