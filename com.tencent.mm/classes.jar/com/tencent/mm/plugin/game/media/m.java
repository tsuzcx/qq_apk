package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.autogen.b.f;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class m
  extends FrameLayout
{
  private int IyH;
  private l IzJ;
  private ThreeDotsLoadingView IzK;
  private long IzL;
  private h Izv;
  private a Izy;
  private boolean Izz;
  private View bEx;
  private View lNf;
  private int mRequestCode;
  
  public m(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(41087);
    this.Izz = true;
    this.mRequestCode = paramInt;
    a(0, 1, null);
    AppMethodBeat.o(41087);
  }
  
  private void a(int paramInt1, int paramInt2, Map paramMap)
  {
    AppMethodBeat.i(41095);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8766, paramInt1, paramInt2, this.IyH, com.tencent.mm.game.report.b.a.a(6, (Map)localObject));
    AppMethodBeat.o(41095);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41094);
    fEC();
    Log.i("MicroMsg.GameTabGalleryView", "setData, data is null : %b", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramLinkedList)) });
    if (!Util.isNullOrNil(paramLinkedList))
    {
      fFw();
      if (a.fFj())
      {
        a.fFi();
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41086);
            m.j(m.this);
            AppMethodBeat.o(41086);
          }
        }, 500L);
      }
    }
    for (;;)
    {
      this.Izv.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41094);
      return;
      cul();
    }
  }
  
  private void cul()
  {
    AppMethodBeat.i(41091);
    this.bEx.setVisibility(0);
    a(502, 1, null);
    AppMethodBeat.o(41091);
  }
  
  private void fEC()
  {
    AppMethodBeat.i(41090);
    this.lNf.setVisibility(8);
    AppMethodBeat.o(41090);
  }
  
  private void fFw()
  {
    AppMethodBeat.i(41092);
    this.bEx.setVisibility(8);
    AppMethodBeat.o(41092);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41093);
    this.Izy.b(new a.a()
    {
      public final void d(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41085);
        m.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41084);
            if ((((Activity)m.this.getContext()).isFinishing()) || (((Activity)m.this.getContext()).isDestroyed()))
            {
              AppMethodBeat.o(41084);
              return;
            }
            m.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41083);
                m.h(m.this).cFq();
                AppMethodBeat.o(41083);
              }
            }, 100L);
            m.a(m.this, paramAnonymousLinkedList, paramAnonymousBoolean);
            AppMethodBeat.o(41084);
          }
        });
        AppMethodBeat.o(41085);
      }
    });
    AppMethodBeat.o(41093);
  }
  
  public final void W(boolean paramBoolean, int paramInt)
  {
    this.Izz = paramBoolean;
    this.IyH = paramInt;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41088);
    super.onDetachedFromWindow();
    this.Izy.destroy();
    AppMethodBeat.o(41088);
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41089);
    this.Izy = new a();
    a.a(this.Izy);
    this.Izy.B(paramJSONArray);
    this.Izv = new h(getContext(), 8766, this.IyH);
    this.Izv.setBackgroundColor(-1);
    this.Izv.a(new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(276826);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (m.a(m.this).Xs(paramAnonymousInt)) {
          m.b(m.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(276826);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(276827);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(276827);
      }
    });
    this.Izv.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
    {
      public final void onItemClick(View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(276830);
        paramAnonymousView = m.a(m.this).Xt(paramAnonymousInt);
        if ((paramAnonymousView.Idj) || (paramAnonymousView.Idk))
        {
          AppMethodBeat.o(276830);
          return;
        }
        if (m.c(m.this))
        {
          if (paramAnonymousView.hJv)
          {
            ((com.tencent.mm.plugin.game.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.h.class)).a(m.this.getContext(), 6, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, m.d(m.this), null, m.e(m.this));
            AppMethodBeat.o(276830);
            return;
          }
          ((com.tencent.mm.plugin.game.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.h.class)).a(m.this.getContext(), 6, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.Idm, m.d(m.this), null, m.e(m.this));
          AppMethodBeat.o(276830);
          return;
        }
        Intent localIntent = new Intent();
        f localf = new f();
        localf.Idq = m.f(m.this).Iya;
        paramAnonymousInt = localf.Idq.indexOf(paramAnonymousView);
        try
        {
          localIntent.putExtra("game_video_list", localf.toByteArray());
          localIntent.putExtra("game_video_list_current_index", paramAnonymousInt);
          localIntent.putExtra("game_video_has_next", m.f(m.this).hasNext());
          localIntent.putExtra("game_video_preview_source", q.a.IAS);
          localIntent.putExtra("game_haowan_source_scene_id", m.e(m.this));
          c.b(m.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", localIntent, m.d(m.this));
          AppMethodBeat.o(276830);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          AppMethodBeat.o(276830);
        }
      }
    });
    this.IzJ = new l(getContext());
    this.IzJ.setPullDownEnabled(true);
    this.IzJ.setNeedStay(true);
    this.IzJ.setOnPullDownListener(new l.a()
    {
      public final void cFr()
      {
        AppMethodBeat.i(41079);
        m.a(m.this, System.currentTimeMillis());
        m.g(m.this).jFe();
        m.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41078);
            m.h(m.this).cFq();
            AppMethodBeat.o(41078);
          }
        }, 400L);
        AppMethodBeat.o(41079);
      }
      
      public final void fFy()
      {
        AppMethodBeat.i(41080);
        if (m.i(m.this) == 0L)
        {
          AppMethodBeat.o(41080);
          return;
        }
        long l1 = System.currentTimeMillis();
        long l2 = m.i(m.this);
        m.a(m.this, 0L);
        HashMap localHashMap = new HashMap();
        localHashMap.put("loading_time", Long.valueOf(l1 - l2));
        m.a(m.this, localHashMap);
        m.g(m.this).jFf();
        AppMethodBeat.o(41080);
      }
    });
    paramJSONArray = LayoutInflater.from(getContext()).inflate(h.f.HYs, this, false);
    this.IzK = ((ThreeDotsLoadingView)paramJSONArray.findViewById(h.e.HWs));
    this.IzJ.h(paramJSONArray, this.Izv);
    addView(this.IzJ, -1, -1);
    this.bEx = LayoutInflater.from(getContext()).inflate(h.f.HYp, this, false);
    this.bEx.setVisibility(8);
    addView(this.bEx, -1, -1);
    this.lNf = LayoutInflater.from(getContext()).inflate(h.f.HYr, this, false);
    this.lNf.setVisibility(8);
    addView(this.lNf, -1, -1);
    paramJSONArray = this.Izy.fFd();
    if (Util.isNullOrNil(paramJSONArray))
    {
      this.lNf.setVisibility(0);
      ((ThreeDotsLoadingView)this.lNf.findViewById(h.e.HVX)).jFe();
    }
    for (;;)
    {
      getDataFromNet();
      AppMethodBeat.o(41089);
      return;
      b(paramJSONArray, false, true);
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41081);
          m.h(m.this).fFx();
          AppMethodBeat.o(41081);
        }
      }, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.m
 * JD-Core Version:    0.7.0.1
 */