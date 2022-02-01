package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class RecyclerThumbSeekBar
  extends RelativeLayout
  implements c
{
  private RecyclerView hak;
  private int jkS;
  private String path;
  private int thumbHeight;
  private int thumbWidth;
  private VideoTransPara zua;
  private int zyE;
  private c.a zyF;
  private c.b zyG;
  private c zyH;
  private SliderSeekBar zyI;
  private int zyJ;
  private d.a zyK;
  private Runnable zyL;
  private RecyclerView.l zyM;
  private SliderSeekBar.a zyN;
  
  public RecyclerThumbSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94427);
    this.jkS = -1;
    this.zyK = new d.a(4, new Callable() {});
    this.zyL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94409);
        Log.i("RecyclerThumbSeekBar", "exec initAsyncTask");
        if ((RecyclerThumbSeekBar.this.getHeight() == 0) || (RecyclerThumbSeekBar.this.getWidth() == 0))
        {
          RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this));
          AppMethodBeat.o(94409);
          return;
        }
        RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.this.getHeight());
        RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this) * 2) / 12);
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94408);
            try
            {
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).ekq();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                Log.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              Log.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
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
    this.zyM = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).W(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(187063);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(187063);
      }
    };
    this.zyN = new SliderSeekBar.a()
    {
      public final void eky()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).X(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void ekz()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Y(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void rj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Z(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).O(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).O(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
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
    this.jkS = -1;
    this.zyK = new d.a(4, new Callable() {});
    this.zyL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94409);
        Log.i("RecyclerThumbSeekBar", "exec initAsyncTask");
        if ((RecyclerThumbSeekBar.this.getHeight() == 0) || (RecyclerThumbSeekBar.this.getWidth() == 0))
        {
          RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this));
          AppMethodBeat.o(94409);
          return;
        }
        RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.this.getHeight());
        RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this) * 2) / 12);
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94408);
            try
            {
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).ekq();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                Log.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              Log.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
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
    this.zyM = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).W(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(187063);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(187063);
      }
    };
    this.zyN = new SliderSeekBar.a()
    {
      public final void eky()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).X(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void ekz()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Y(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void rj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Z(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).O(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).O(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
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
    this.jkS = -1;
    this.zyK = new d.a(4, new Callable() {});
    this.zyL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94409);
        Log.i("RecyclerThumbSeekBar", "exec initAsyncTask");
        if ((RecyclerThumbSeekBar.this.getHeight() == 0) || (RecyclerThumbSeekBar.this.getWidth() == 0))
        {
          RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this));
          AppMethodBeat.o(94409);
          return;
        }
        RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.this.getHeight());
        RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this) * 2) / 12);
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94408);
            try
            {
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).ekq();
              RecyclerThumbSeekBar.c(RecyclerThumbSeekBar.this, locald.getDurationMs());
              RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
                int i = 0;
              }
              if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) < 10000) {
                break label203;
              }
              RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.j(RecyclerThumbSeekBar.this).duration * 1000 / 10);
              for (;;)
              {
                Log.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar.this)) });
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                AppMethodBeat.o(94408);
                return;
                label203:
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) <= 0) {
                  break;
                }
                RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this) / 10);
              }
              Log.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar.this)) });
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
    this.zyM = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(94412);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).W(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(94412);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(187063);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(187063);
      }
    };
    this.zyN = new SliderSeekBar.a()
    {
      public final void eky()
      {
        AppMethodBeat.i(94413);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).X(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        AppMethodBeat.o(94413);
      }
      
      public final void ekz()
      {
        AppMethodBeat.i(94414);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Y(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        AppMethodBeat.o(94414);
      }
      
      public final void rj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).Z(RecyclerThumbSeekBar.this.eko(), RecyclerThumbSeekBar.this.ekp());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).O(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).O(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
    };
    init();
    AppMethodBeat.o(94429);
  }
  
  private float aD(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94439);
    if ((this.zyH == null) || (this.hak == null))
    {
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    View localView = this.hak.o(paramInt, 0.0F);
    if (localView == null)
    {
      Log.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    int i = RecyclerView.bw(localView);
    int j = this.zyH.getItemCount();
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
  
  private void ekx()
  {
    AppMethodBeat.i(94434);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94411);
        if (RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this) != null) {
          RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this).ri(true);
        }
        AppMethodBeat.o(94411);
      }
    });
    AppMethodBeat.o(94434);
  }
  
  private void init()
  {
    AppMethodBeat.i(94430);
    this.hak = new RecyclerView(getContext());
    getContext();
    Object localObject = new LinearLayoutManager(0, false);
    this.hak.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.hak.setHasFixedSize(true);
    com.tencent.mm.cb.a.aG(getContext(), 2131167091);
    this.zyJ = com.tencent.mm.cb.a.aG(getContext(), 2131167090);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.hak, (ViewGroup.LayoutParams)localObject);
    this.zyI = new SliderSeekBar(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.zyI, (ViewGroup.LayoutParams)localObject);
    this.zyI.setOnSliderTouchListener(this.zyN);
    this.hak.a(this.zyM);
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
  
  public final void aFp(String paramString)
  {
    AppMethodBeat.i(94432);
    Log.i("RecyclerThumbSeekBar", "initAsync %s", new Object[] { paramString });
    if ((Util.isNullOrNil(paramString)) || (!s.YS(paramString)))
    {
      ekx();
      AppMethodBeat.o(94432);
      return;
    }
    this.path = paramString;
    post(this.zyL);
    AppMethodBeat.o(94432);
  }
  
  public final float eko()
  {
    AppMethodBeat.i(94437);
    if (this.zyI == null)
    {
      AppMethodBeat.o(94437);
      return 0.0F;
    }
    float f = aD(this.zyI.getLeftSliderBound(), false);
    Log.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", new Object[] { Integer.valueOf(this.zyI.getLeftSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.jkS * f)), Integer.valueOf(this.jkS) });
    AppMethodBeat.o(94437);
    return f;
  }
  
  public final float ekp()
  {
    AppMethodBeat.i(94438);
    if (this.zyI == null)
    {
      AppMethodBeat.o(94438);
      return 0.0F;
    }
    float f = aD(this.zyI.getRightSliderBound(), true);
    Log.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", new Object[] { Integer.valueOf(this.zyI.getRightSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.jkS * f)) });
    AppMethodBeat.o(94438);
    return f;
  }
  
  public int getDurationMs()
  {
    return this.jkS;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94435);
    this.jkS = -1;
    this.path = null;
    if (this.zyK != null) {
      this.zyK.destroy();
    }
    if ((this.zyH != null) && (c.a(this.zyH) != null))
    {
      d locald = c.a(this.zyH);
      if ((locald.zyX != null) && (locald.zyX.length != 0))
      {
        int i = 0;
        while (i < locald.zyX.length)
        {
          if (locald.zyX[i] != null)
          {
            locald.zyX[i].getSerial().RUS.quit();
            locald.zyX[i] = null;
          }
          i += 1;
        }
      }
      c.b(this.zyH);
      this.zyH = null;
    }
    if (this.zyI != null) {
      this.zyI.reset();
    }
    AppMethodBeat.o(94435);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94436);
    if (this.zyI != null) {
      this.zyI.reset();
    }
    AppMethodBeat.o(94436);
  }
  
  public final void rh(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.zyI.zxs = true;
      return;
    }
    this.zyI.zxs = false;
  }
  
  public void setCurrentCursorPosition(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(94431);
    SliderSeekBar localSliderSeekBar = this.zyI;
    float f1 = f2;
    if (this.zyH != null)
    {
      if (this.hak != null) {
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
      paramFloat = (this.zyH.getItemCount() - 2) * paramFloat;
      int i = (int)Math.floor(paramFloat);
      float f3 = i;
      Object localObject = this.hak.ch(i + 1);
      f1 = f2;
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).aus;
        f1 = ((View)localObject).getLeft();
        f1 = (((View)localObject).getWidth() * (paramFloat - f3) + f1) / getWidth();
      }
    }
  }
  
  public void setOnPreparedListener(c.a parama)
  {
    this.zyF = parama;
  }
  
  public void setThumbBarSeekListener(c.b paramb)
  {
    this.zyG = paramb;
  }
  
  public void setVideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.zua = paramVideoTransPara;
  }
  
  final class b
    implements Runnable
  {
    private int hXs;
    private MMHandler handler;
    boolean jcC;
    private WeakReference<ImageView> oi;
    private Bitmap zyR;
    
    b(int paramInt, ImageView paramImageView, Bitmap paramBitmap, MMHandler paramMMHandler)
    {
      AppMethodBeat.i(94417);
      this.jcC = false;
      this.hXs = paramInt;
      this.oi = new WeakReference(paramImageView);
      this.handler = paramMMHandler;
      this.zyR = paramBitmap;
      AppMethodBeat.o(94417);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94418);
      if (this.jcC)
      {
        o.itM.f(this.zyR);
        AppMethodBeat.o(94418);
        return;
      }
      if ((ImageView)this.oi.get() == null)
      {
        o.itM.f(this.zyR);
        AppMethodBeat.o(94418);
        return;
      }
      try
      {
        d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).ekq();
        if (this.zyR == null) {
          this.zyR = o.itM.a(new o.b(locald.getScaledWidth(), locald.getScaledHeight()));
        }
        locald.reuseBitmap(this.zyR);
        if (!this.jcC) {
          this.zyR = locald.getFrameAtTime(this.hXs);
        }
        RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
        if ((this.zyR != null) && (!this.jcC) && (this.oi.get() != null))
        {
          this.handler.post(new RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, this.zyR, (ImageView)this.oi.get(), this));
          AppMethodBeat.o(94418);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("RecyclerThumbSeekBar", "get bitmap error " + localException.getMessage());
        o.itM.f(this.zyR);
        AppMethodBeat.o(94418);
        return;
      }
      o.itM.f(this.zyR);
      AppMethodBeat.o(94418);
    }
  }
  
  final class c
    extends RecyclerView.a<RecyclerThumbSeekBar.e>
  {
    private RecyclerThumbSeekBar.d zyS;
    private int zyT;
    private int zyU;
    private View zyV;
    private View zyW;
    
    private c()
    {
      AppMethodBeat.i(94419);
      this.zyS = new RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this);
      this.zyT = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      this.zyU = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      AppMethodBeat.o(94419);
    }
    
    public final void O(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(94421);
      if (paramBoolean)
      {
        if (this.zyV != null) {
          this.zyV.setMinimumWidth(paramInt);
        }
        if (((LinearLayoutManager)RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).getLayoutManager()).ks() == 0) {
          RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).scrollBy(paramInt - this.zyT, 0);
        }
        this.zyT = paramInt;
        AppMethodBeat.o(94421);
        return;
      }
      this.zyU = paramInt;
      if (this.zyW != null) {
        this.zyW.setMinimumWidth(this.zyU);
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
    MMHandler handler;
    int zvb;
    MMHandler[] zyX;
    int zyY;
    private BlockingDeque<RecyclerThumbSeekBar.b> zyZ;
    
    public d()
    {
      AppMethodBeat.i(94425);
      this.handler = new MMHandler();
      this.zvb = 4;
      this.zyX = new MMHandler[this.zvb];
      this.zyY = 0;
      this.zyZ = new LinkedBlockingDeque();
      int i = 0;
      while (i < this.zyX.length)
      {
        this.zyX[i] = new MMHandler("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i)));
        i += 1;
      }
      this.zyY = 0;
      AppMethodBeat.o(94425);
    }
  }
  
  final class e
    extends RecyclerView.v
  {
    ImageView dKU;
    
    e(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(94426);
      if (paramInt == 0) {
        this.dKU = ((ImageView)((LinearLayout)paramView).getChildAt(0));
      }
      AppMethodBeat.o(94426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar
 * JD-Core Version:    0.7.0.1
 */