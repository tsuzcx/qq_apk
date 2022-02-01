package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
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
  private RecyclerView fPw;
  private int hsU;
  private String path;
  private VideoTransPara tCr;
  private int tGq;
  private c.a tGr;
  private c.b tGs;
  private c tGt;
  private SliderSeekBar tGu;
  private int tGv;
  private d.a tGw;
  private Runnable tGx;
  private RecyclerView.m tGy;
  private n.a tGz;
  private int thumbHeight;
  private int thumbWidth;
  
  public RecyclerThumbSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94427);
    this.hsU = -1;
    this.tGw = new d.a(4, new Callable() {});
    this.tGx = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).cQv();
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
    this.tGy = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205844);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(205844);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).M(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.tGz = new n.a()
    {
      public final void cQD()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).N(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void nj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).P(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).H(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).H(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
      
      public final void yW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205845);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).O(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        AppMethodBeat.o(205845);
      }
    };
    init();
    AppMethodBeat.o(94427);
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94428);
    this.hsU = -1;
    this.tGw = new d.a(4, new Callable() {});
    this.tGx = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).cQv();
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
    this.tGy = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205844);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(205844);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).M(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.tGz = new n.a()
    {
      public final void cQD()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).N(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void nj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).P(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).H(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).H(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
      
      public final void yW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205845);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).O(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        AppMethodBeat.o(205845);
      }
    };
    init();
    AppMethodBeat.o(94428);
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94429);
    this.hsU = -1;
    this.tGw = new d.a(4, new Callable() {});
    this.tGx = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).cQv();
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
    this.tGy = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205844);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(205844);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).M(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
    };
    this.tGz = new n.a()
    {
      public final void cQD()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).N(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void nj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).P(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).H(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).H(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
      
      public final void yW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205845);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).O(RecyclerThumbSeekBar.this.cQt(), RecyclerThumbSeekBar.this.cQu());
        }
        AppMethodBeat.o(205845);
      }
    };
    init();
    AppMethodBeat.o(94429);
  }
  
  private float ai(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94439);
    if ((this.tGt == null) || (this.fPw == null))
    {
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    View localView = this.fPw.o(paramInt, 0.0F);
    if (localView == null)
    {
      ad.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    int i = RecyclerView.bw(localView);
    int j = this.tGt.getItemCount();
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
  
  private void cQC()
  {
    AppMethodBeat.i(94434);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94411);
        if (RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this) != null) {
          RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this).ni(true);
        }
        AppMethodBeat.o(94411);
      }
    });
    AppMethodBeat.o(94434);
  }
  
  private void init()
  {
    AppMethodBeat.i(94430);
    this.fPw = new RecyclerView(getContext());
    getContext();
    Object localObject = new LinearLayoutManager(0);
    this.fPw.setLayoutManager((RecyclerView.i)localObject);
    this.fPw.setHasFixedSize(true);
    com.tencent.mm.cd.a.ao(getContext(), 2131166956);
    this.tGv = com.tencent.mm.cd.a.ao(getContext(), 2131166955);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.fPw, (ViewGroup.LayoutParams)localObject);
    this.tGu = new SliderSeekBar(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.tGu, (ViewGroup.LayoutParams)localObject);
    this.tGu.setOnSliderTouchListener(this.tGz);
    this.fPw.a(this.tGy);
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
  
  public final void ahg(String paramString)
  {
    AppMethodBeat.i(94432);
    if ((bt.isNullOrNil(paramString)) || (!i.eK(paramString)))
    {
      cQC();
      AppMethodBeat.o(94432);
      return;
    }
    this.path = paramString;
    post(this.tGx);
    AppMethodBeat.o(94432);
  }
  
  public final float cQt()
  {
    AppMethodBeat.i(94437);
    if (this.tGu == null)
    {
      AppMethodBeat.o(94437);
      return 0.0F;
    }
    float f = ai(this.tGu.getLeftSliderBound(), false);
    ad.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", new Object[] { Integer.valueOf(this.tGu.getLeftSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.hsU * f)), Integer.valueOf(this.hsU) });
    AppMethodBeat.o(94437);
    return f;
  }
  
  public final float cQu()
  {
    AppMethodBeat.i(94438);
    if (this.tGu == null)
    {
      AppMethodBeat.o(94438);
      return 0.0F;
    }
    float f = ai(this.tGu.getRightSliderBound(), true);
    ad.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", new Object[] { Integer.valueOf(this.tGu.getRightSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.hsU * f)) });
    AppMethodBeat.o(94438);
    return f;
  }
  
  public int getDurationMs()
  {
    return this.hsU;
  }
  
  public final void nh(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.tGu.tGP = true;
      return;
    }
    this.tGu.tGP = false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94435);
    this.hsU = -1;
    this.path = null;
    if (this.tGw != null) {
      this.tGw.destroy();
    }
    if ((this.tGt != null) && (c.a(this.tGt) != null))
    {
      d locald = c.a(this.tGt);
      if ((locald.tGK != null) && (locald.tGK.length != 0))
      {
        int i = 0;
        while (i < locald.tGK.length)
        {
          if (locald.tGK[i] != null)
          {
            locald.tGK[i].getSerial().IzX.quit();
            locald.tGK[i] = null;
          }
          i += 1;
        }
      }
      c.b(this.tGt);
      this.tGt = null;
    }
    if (this.tGu != null) {
      this.tGu.reset();
    }
    AppMethodBeat.o(94435);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94436);
    if (this.tGu != null) {
      this.tGu.reset();
    }
    AppMethodBeat.o(94436);
  }
  
  public void setCurrentCursorPosition(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(94431);
    SliderSeekBar localSliderSeekBar = this.tGu;
    float f1 = f2;
    if (this.tGt != null)
    {
      if (this.fPw != null) {
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
      paramFloat = (this.tGt.getItemCount() - 2) * paramFloat;
      int i = (int)Math.floor(paramFloat);
      float f3 = i;
      Object localObject = this.fPw.cj(i + 1);
      f1 = f2;
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).arI;
        f1 = ((View)localObject).getLeft();
        f1 = (((View)localObject).getWidth() * (paramFloat - f3) + f1) / getWidth();
      }
    }
  }
  
  public void setOnPreparedListener(c.a parama)
  {
    this.tGr = parama;
  }
  
  public void setThumbBarSeekListener(c.b paramb)
  {
    this.tGs = paramb;
  }
  
  public void setVideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.tCr = paramVideoTransPara;
  }
  
  final class a
    implements Runnable
  {
    private Bitmap bitmap;
    private ImageView djK;
    private RecyclerThumbSeekBar.b tGC;
    
    a(Bitmap paramBitmap, ImageView paramImageView, RecyclerThumbSeekBar.b paramb)
    {
      this.bitmap = paramBitmap;
      this.djK = paramImageView;
      this.tGC = paramb;
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
      if ((this.tGC == null) || (this.tGC.hls) || (this.djK == null))
      {
        ad.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
        AppMethodBeat.o(94416);
        return;
      }
      ImageView localImageView = this.djK;
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
    boolean hls;
    private WeakReference<ImageView> lo;
    private int tGD;
    private Bitmap tGE;
    
    b(int paramInt, ImageView paramImageView, Bitmap paramBitmap, ap paramap)
    {
      AppMethodBeat.i(94417);
      this.hls = false;
      this.tGD = paramInt;
      this.lo = new WeakReference(paramImageView);
      this.handler = paramap;
      this.tGE = paramBitmap;
      AppMethodBeat.o(94417);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94418);
      if (this.hls)
      {
        o.gEi.f(this.tGE);
        AppMethodBeat.o(94418);
        return;
      }
      if ((ImageView)this.lo.get() == null)
      {
        o.gEi.f(this.tGE);
        AppMethodBeat.o(94418);
        return;
      }
      try
      {
        d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).cQv();
        if (this.tGE == null) {
          this.tGE = o.gEi.a(new o.b(locald.getScaledWidth(), locald.getScaledHeight()));
        }
        locald.reuseBitmap(this.tGE);
        if (!this.hls) {
          this.tGE = locald.getFrameAtTime(this.tGD);
        }
        RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
        if ((this.tGE != null) && (!this.hls) && (this.lo.get() != null))
        {
          this.handler.post(new RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, this.tGE, (ImageView)this.lo.get(), this));
          AppMethodBeat.o(94418);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.e("RecyclerThumbSeekBar", "get bitmap error " + localException.getMessage());
        o.gEi.f(this.tGE);
        AppMethodBeat.o(94418);
        return;
      }
      o.gEi.f(this.tGE);
      AppMethodBeat.o(94418);
    }
  }
  
  final class c
    extends RecyclerView.a<RecyclerThumbSeekBar.e>
  {
    private RecyclerThumbSeekBar.d tGF;
    private int tGG;
    private int tGH;
    private View tGI;
    private View tGJ;
    
    private c()
    {
      AppMethodBeat.i(94419);
      this.tGF = new RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this);
      this.tGG = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      this.tGH = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      AppMethodBeat.o(94419);
    }
    
    public final void H(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(94421);
      if (paramBoolean)
      {
        if (this.tGI != null) {
          this.tGI.setMinimumWidth(paramInt);
        }
        if (((LinearLayoutManager)RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).getLayoutManager()).jO() == 0) {
          RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).scrollBy(paramInt - this.tGG, 0);
        }
        this.tGG = paramInt;
        AppMethodBeat.o(94421);
        return;
      }
      this.tGH = paramInt;
      if (this.tGJ != null) {
        this.tGJ.setMinimumWidth(this.tGH);
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
    int tDt;
    ap[] tGK;
    int tGL;
    private BlockingDeque<RecyclerThumbSeekBar.b> tGM;
    
    public d()
    {
      AppMethodBeat.i(94425);
      this.handler = new ap();
      this.tDt = 4;
      this.tGK = new ap[this.tDt];
      this.tGL = 0;
      this.tGM = new LinkedBlockingDeque();
      int i = 0;
      while (i < this.tGK.length)
      {
        this.tGK[i] = new ap("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i)));
        i += 1;
      }
      this.tGL = 0;
      AppMethodBeat.o(94425);
    }
  }
  
  final class e
    extends RecyclerView.v
  {
    ImageView djK;
    
    e(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(94426);
      if (paramInt == 0) {
        this.djK = ((ImageView)((LinearLayout)paramView).getChildAt(0));
      }
      AppMethodBeat.o(94426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar
 * JD-Core Version:    0.7.0.1
 */