package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
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
  private View GQ;
  private View gAy;
  private int mRequestCode;
  private int xAD;
  private l xBE;
  private ThreeDotsLoadingView xBF;
  private long xBG;
  private h xBq;
  private a xBt;
  private boolean xBu;
  
  public m(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(41087);
    this.xBu = true;
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
    com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8766, paramInt1, paramInt2, this.xAD, com.tencent.mm.game.report.b.a.c(6, (Map)localObject));
    AppMethodBeat.o(41095);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41094);
    dTO();
    Log.i("MicroMsg.GameTabGalleryView", "setData, data is null : %b", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramLinkedList)) });
    if (!Util.isNullOrNil(paramLinkedList))
    {
      dUt();
      if (a.dUf())
      {
        a.dUe();
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
      this.xBq.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41094);
      return;
      bIo();
    }
  }
  
  private void bIo()
  {
    AppMethodBeat.i(41091);
    this.GQ.setVisibility(0);
    a(502, 1, null);
    AppMethodBeat.o(41091);
  }
  
  private void dTO()
  {
    AppMethodBeat.i(41090);
    this.gAy.setVisibility(8);
    AppMethodBeat.o(41090);
  }
  
  private void dUt()
  {
    AppMethodBeat.i(41092);
    this.GQ.setVisibility(8);
    AppMethodBeat.o(41092);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41093);
    this.xBt.b(new a.a()
    {
      public final void c(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41085);
        m.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41084);
            m.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41083);
                m.h(m.this).bRQ();
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
  
  public final void J(boolean paramBoolean, int paramInt)
  {
    this.xBu = paramBoolean;
    this.xAD = paramInt;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41088);
    super.onDetachedFromWindow();
    this.xBt.destroy();
    AppMethodBeat.o(41088);
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41089);
    this.xBt = new a();
    a.a(this.xBt);
    this.xBt.y(paramJSONArray);
    this.xBq = new h(getContext(), 8766, this.xAD);
    this.xBq.setBackgroundColor(-1);
    this.xBq.a(new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (m.a(m.this).Of(paramAnonymousInt)) {
          m.b(m.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41076);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(204131);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(204131);
      }
    });
    this.xBq.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
    {
      public final void Q(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41077);
        paramAnonymousView = m.a(m.this).Og(paramAnonymousInt);
        if ((paramAnonymousView.xuJ) || (paramAnonymousView.xuK))
        {
          AppMethodBeat.o(41077);
          return;
        }
        if (m.c(m.this))
        {
          if (paramAnonymousView.dLQ)
          {
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.g.class)).a(m.this.getContext(), 6, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, m.d(m.this), null, m.e(m.this));
            AppMethodBeat.o(41077);
            return;
          }
          ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.g.class)).a(m.this.getContext(), 6, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.xuM, m.d(m.this), null, m.e(m.this));
          AppMethodBeat.o(41077);
          return;
        }
        Intent localIntent = new Intent();
        f localf = new f();
        localf.xuQ = m.f(m.this).xzV;
        paramAnonymousInt = localf.xuQ.indexOf(paramAnonymousView);
        try
        {
          localIntent.putExtra("game_video_list", localf.toByteArray());
          localIntent.putExtra("game_video_list_current_index", paramAnonymousInt);
          localIntent.putExtra("game_video_has_next", m.f(m.this).hasNext());
          localIntent.putExtra("game_video_preview_source", p.a.xCI);
          localIntent.putExtra("game_haowan_source_scene_id", m.e(m.this));
          c.b(m.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", localIntent, m.d(m.this));
          AppMethodBeat.o(41077);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          AppMethodBeat.o(41077);
        }
      }
    });
    this.xBE = new l(getContext());
    this.xBE.setPullDownEnabled(true);
    this.xBE.setNeedStay(true);
    this.xBE.setOnPullDownListener(new l.a()
    {
      public final void bRR()
      {
        AppMethodBeat.i(41079);
        m.a(m.this, System.currentTimeMillis());
        m.g(m.this).gZh();
        m.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41078);
            m.h(m.this).bRQ();
            AppMethodBeat.o(41078);
          }
        }, 400L);
        AppMethodBeat.o(41079);
      }
      
      public final void dUv()
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
        m.g(m.this).gZi();
        AppMethodBeat.o(41080);
      }
    });
    paramJSONArray = LayoutInflater.from(getContext()).inflate(2131494800, this, false);
    this.xBF = ((ThreeDotsLoadingView)paramJSONArray.findViewById(2131302075));
    this.xBE.l(paramJSONArray, this.xBq);
    addView(this.xBE, -1, -1);
    this.GQ = LayoutInflater.from(getContext()).inflate(2131494797, this, false);
    this.GQ.setVisibility(8);
    addView(this.GQ, -1, -1);
    this.gAy = LayoutInflater.from(getContext()).inflate(2131494799, this, false);
    this.gAy.setVisibility(8);
    addView(this.gAy, -1, -1);
    paramJSONArray = this.xBt.dTZ();
    if (Util.isNullOrNil(paramJSONArray))
    {
      this.gAy.setVisibility(0);
      ((ThreeDotsLoadingView)this.gAy.findViewById(2131302028)).gZh();
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
          m.h(m.this).dUu();
          AppMethodBeat.o(41081);
        }
      }, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.m
 * JD-Core Version:    0.7.0.1
 */