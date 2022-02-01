package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.memory.n.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class RecyclerThumbSeekBar
  extends RelativeLayout
  implements c
{
  private VideoTransPara KVn;
  private int KZH;
  private c.a KZI;
  private c.b KZJ;
  private c KZK;
  private SliderSeekBar KZL;
  private int KZM;
  private d.a KZN;
  private Runnable KZO;
  private RecyclerView.l KZP;
  private SliderSeekBar.a KZQ;
  private RecyclerView mkw;
  private int oTN;
  private String path;
  private int thumbHeight;
  private int thumbWidth;
  
  public RecyclerThumbSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94427);
    this.oTN = -1;
    this.KZN = new d.a(4, new Callable() {});
    this.KZO = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).gcQ();
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
    this.KZP = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(303575);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).aE(RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(303575);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(303576);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(303576);
      }
    };
    this.KZQ = new SliderSeekBar.a()
    {
      public final void yA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).aF(RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).ab(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).ab(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
      
      public final void yx(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(303577);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).b(paramAnonymousBoolean, RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        AppMethodBeat.o(303577);
      }
      
      public final void yy(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(303580);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).c(paramAnonymousBoolean, RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        AppMethodBeat.o(303580);
      }
    };
    init();
    AppMethodBeat.o(94427);
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94428);
    this.oTN = -1;
    this.KZN = new d.a(4, new Callable() {});
    this.KZO = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).gcQ();
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
    this.KZP = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(303575);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).aE(RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(303575);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(303576);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(303576);
      }
    };
    this.KZQ = new SliderSeekBar.a()
    {
      public final void yA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).aF(RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).ab(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).ab(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
      
      public final void yx(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(303577);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).b(paramAnonymousBoolean, RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        AppMethodBeat.o(303577);
      }
      
      public final void yy(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(303580);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).c(paramAnonymousBoolean, RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        AppMethodBeat.o(303580);
      }
    };
    init();
    AppMethodBeat.o(94428);
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94429);
    this.oTN = -1;
    this.KZN = new d.a(4, new Callable() {});
    this.KZO = new Runnable()
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
              d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).gcQ();
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
    this.KZP = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(303575);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        if ((paramAnonymousInt == 0) && (RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).aE(RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(303575);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(303576);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(303576);
      }
    };
    this.KZQ = new SliderSeekBar.a()
    {
      public final void yA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94415);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).aF(RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        if (paramAnonymousBoolean)
        {
          RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).ab(true, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getLeftSliderBound());
          AppMethodBeat.o(94415);
          return;
        }
        RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this).ab(false, RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getWidth() - RecyclerThumbSeekBar.l(RecyclerThumbSeekBar.this).getRightSliderBound());
        AppMethodBeat.o(94415);
      }
      
      public final void yx(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(303577);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).b(paramAnonymousBoolean, RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        AppMethodBeat.o(303577);
      }
      
      public final void yy(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(303580);
        if ((RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this) != null) && (RecyclerThumbSeekBar.m(RecyclerThumbSeekBar.this) != null)) {
          RecyclerThumbSeekBar.p(RecyclerThumbSeekBar.this).c(paramAnonymousBoolean, RecyclerThumbSeekBar.this.gcO(), RecyclerThumbSeekBar.this.gcP());
        }
        AppMethodBeat.o(303580);
      }
    };
    init();
    AppMethodBeat.o(94429);
  }
  
  private float bj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94439);
    if ((this.KZK == null) || (this.mkw == null))
    {
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    View localView = this.mkw.Q(paramInt, 0.0F);
    if (localView == null)
    {
      Log.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(94439);
      return 0.0F;
    }
    int i = RecyclerView.bA(localView);
    int j = this.KZK.getItemCount();
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
  
  private void gcX()
  {
    AppMethodBeat.i(94434);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94411);
        if (RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this) != null) {
          RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this).onPrepared(true);
        }
        AppMethodBeat.o(94411);
      }
    });
    AppMethodBeat.o(94434);
  }
  
  private void init()
  {
    AppMethodBeat.i(94430);
    this.mkw = new RecyclerView(getContext());
    getContext();
    Object localObject = new LinearLayoutManager(0, false);
    this.mkw.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.mkw.setHasFixedSize(true);
    com.tencent.mm.cd.a.br(getContext(), a.c.video_segment_seekbar_recycler_view_height);
    this.KZM = com.tencent.mm.cd.a.br(getContext(), a.c.video_segment_seekbar_padding);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.mkw, (ViewGroup.LayoutParams)localObject);
    this.KZL = new SliderSeekBar(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.KZL, (ViewGroup.LayoutParams)localObject);
    this.KZL.setOnSliderTouchListener(this.KZQ);
    this.mkw.a(this.KZP);
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
  
  public final void aMx(String paramString)
  {
    AppMethodBeat.i(94432);
    Log.i("RecyclerThumbSeekBar", "initAsync %s", new Object[] { paramString });
    if ((Util.isNullOrNil(paramString)) || (!y.ZC(paramString)))
    {
      gcX();
      AppMethodBeat.o(94432);
      return;
    }
    this.path = paramString;
    post(this.KZO);
    AppMethodBeat.o(94432);
  }
  
  public final float gcO()
  {
    AppMethodBeat.i(94437);
    if (this.KZL == null)
    {
      AppMethodBeat.o(94437);
      return 0.0F;
    }
    float f = bj(this.KZL.getLeftSliderBound(), false);
    Log.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", new Object[] { Integer.valueOf(this.KZL.getLeftSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.oTN * f)), Integer.valueOf(this.oTN) });
    AppMethodBeat.o(94437);
    return f;
  }
  
  public final float gcP()
  {
    AppMethodBeat.i(94438);
    if (this.KZL == null)
    {
      AppMethodBeat.o(94438);
      return 0.0F;
    }
    float f = bj(this.KZL.getRightSliderBound(), true);
    Log.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", new Object[] { Integer.valueOf(this.KZL.getRightSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.oTN * f)) });
    AppMethodBeat.o(94438);
    return f;
  }
  
  public int getDurationMs()
  {
    return this.oTN;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94435);
    this.oTN = -1;
    this.path = null;
    if (this.KZN != null) {
      this.KZN.destroy();
    }
    if ((this.KZK != null) && (c.a(this.KZK) != null))
    {
      d locald = c.a(this.KZK);
      if ((locald.Laa != null) && (locald.Laa.length != 0))
      {
        int i = 0;
        while (i < locald.Laa.length)
        {
          if (locald.Laa[i] != null)
          {
            locald.Laa[i].getSerial().ahCy.quit();
            locald.Laa[i] = null;
          }
          i += 1;
        }
      }
      c.b(this.KZK);
      this.KZK = null;
    }
    if (this.KZL != null) {
      this.KZL.reset();
    }
    AppMethodBeat.o(94435);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94436);
    if (this.KZL != null) {
      this.KZL.reset();
    }
    AppMethodBeat.o(94436);
  }
  
  public void setCurrentCursorPosition(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(94431);
    SliderSeekBar localSliderSeekBar = this.KZL;
    float f1 = f2;
    if (this.KZK != null)
    {
      if (this.mkw != null) {
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
      paramFloat = (this.KZK.getItemCount() - 2) * paramFloat;
      int i = (int)Math.floor(paramFloat);
      float f3 = i;
      Object localObject = this.mkw.fU(i + 1);
      f1 = f2;
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).caK;
        f1 = ((View)localObject).getLeft();
        f1 = (((View)localObject).getWidth() * (paramFloat - f3) + f1) / getWidth();
      }
    }
  }
  
  public void setOnPreparedListener(c.a parama)
  {
    this.KZI = parama;
  }
  
  public void setThumbBarSeekListener(c.b paramb)
  {
    this.KZJ = paramb;
  }
  
  public void setVideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.KVn = paramVideoTransPara;
    if (paramVideoTransPara.duration <= paramVideoTransPara.minDuration) {
      this.KZL.KYv = true;
    }
  }
  
  public final void yz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.KZL.KYv = true;
      return;
    }
    this.KZL.KYv = false;
  }
  
  final class b
    implements Runnable
  {
    private Bitmap KZU;
    private MMHandler handler;
    boolean oLU;
    private int time;
    private WeakReference<ImageView> viewRef;
    
    b(int paramInt, ImageView paramImageView, Bitmap paramBitmap, MMHandler paramMMHandler)
    {
      AppMethodBeat.i(94417);
      this.oLU = false;
      this.time = paramInt;
      this.viewRef = new WeakReference(paramImageView);
      this.handler = paramMMHandler;
      this.KZU = paramBitmap;
      AppMethodBeat.o(94417);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94418);
      if (this.oLU)
      {
        n.nNG.M(this.KZU);
        AppMethodBeat.o(94418);
        return;
      }
      if ((ImageView)this.viewRef.get() == null)
      {
        n.nNG.M(this.KZU);
        AppMethodBeat.o(94418);
        return;
      }
      try
      {
        d locald = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).gcQ();
        if (this.KZU == null) {
          this.KZU = n.nNG.a(new n.b(locald.getScaledWidth(), locald.getScaledHeight()));
        }
        locald.reuseBitmap(this.KZU);
        if (!this.oLU) {
          this.KZU = locald.getFrameAtTime(this.time);
        }
        RecyclerThumbSeekBar.g(RecyclerThumbSeekBar.this).a(locald);
        if ((this.KZU != null) && (!this.oLU) && (this.viewRef.get() != null))
        {
          this.handler.post(new RecyclerThumbSeekBar.a(RecyclerThumbSeekBar.this, this.KZU, (ImageView)this.viewRef.get(), this));
          AppMethodBeat.o(94418);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("RecyclerThumbSeekBar", "get bitmap error " + localException.getMessage());
        n.nNG.M(this.KZU);
        AppMethodBeat.o(94418);
        return;
      }
      n.nNG.M(this.KZU);
      AppMethodBeat.o(94418);
    }
  }
  
  final class c
    extends RecyclerView.a<RecyclerThumbSeekBar.e>
  {
    private RecyclerThumbSeekBar.d KZV;
    private int KZW;
    private int KZX;
    private View KZY;
    private View KZZ;
    
    private c()
    {
      AppMethodBeat.i(94419);
      this.KZV = new RecyclerThumbSeekBar.d(RecyclerThumbSeekBar.this);
      this.KZW = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      this.KZX = RecyclerThumbSeekBar.f(RecyclerThumbSeekBar.this);
      AppMethodBeat.o(94419);
    }
    
    public final void ab(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(94421);
      if (paramBoolean)
      {
        if (this.KZY != null) {
          this.KZY.setMinimumWidth(paramInt);
        }
        if (((LinearLayoutManager)RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).getLayoutManager()).Ju() == 0) {
          RecyclerThumbSeekBar.n(RecyclerThumbSeekBar.this).scrollBy(paramInt - this.KZW, 0);
        }
        this.KZW = paramInt;
        AppMethodBeat.o(94421);
        return;
      }
      this.KZX = paramInt;
      if (this.KZZ != null) {
        this.KZZ.setMinimumWidth(this.KZX);
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
    int KWj;
    MMHandler[] Laa;
    int Lab;
    private BlockingDeque<RecyclerThumbSeekBar.b> Lac;
    MMHandler handler;
    
    public d()
    {
      AppMethodBeat.i(94425);
      this.handler = new MMHandler();
      this.KWj = 4;
      this.Laa = new MMHandler[this.KWj];
      this.Lab = 0;
      this.Lac = new LinkedBlockingDeque();
      int i = 0;
      while (i < this.Laa.length)
      {
        this.Laa[i] = new MMHandler("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i)));
        i += 1;
      }
      this.Lab = 0;
      AppMethodBeat.o(94425);
    }
  }
  
  final class e
    extends RecyclerView.v
  {
    ImageView hIz;
    
    e(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(94426);
      if (paramInt == 0) {
        this.hIz = ((ImageView)((LinearLayout)paramView).getChildAt(0));
      }
      AppMethodBeat.o(94426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar
 * JD-Core Version:    0.7.0.1
 */