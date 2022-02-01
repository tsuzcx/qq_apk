package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class m
  extends FrameLayout
{
  private View DR;
  private View fwo;
  private int mRequestCode;
  private l rSB;
  private ThreeDotsLoadingView rSC;
  private long rSD;
  private h rSo;
  private a rSr;
  private boolean rSs;
  
  public m(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(41087);
    this.rSs = true;
    this.mRequestCode = paramInt;
    a(0, 1, null);
    AppMethodBeat.o(41087);
  }
  
  private static void a(int paramInt1, int paramInt2, Map paramMap)
  {
    AppMethodBeat.i(41095);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    com.tencent.mm.game.report.b.a.a(aj.getContext(), 8766, paramInt1, paramInt2, com.tencent.mm.game.report.b.a.a(6, (Map)localObject));
    AppMethodBeat.o(41095);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41094);
    cBH();
    ad.i("MicroMsg.GameTabGalleryView", "setData, data is null : %b", new Object[] { Boolean.valueOf(bt.gL(paramLinkedList)) });
    if (!bt.gL(paramLinkedList))
    {
      cCl();
      if (a.cBX())
      {
        a.cBW();
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41086);
            m.i(m.this);
            AppMethodBeat.o(41086);
          }
        }, 500L);
      }
    }
    for (;;)
    {
      this.rSo.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41094);
      return;
      bbB();
    }
  }
  
  private void bbB()
  {
    AppMethodBeat.i(41091);
    this.DR.setVisibility(0);
    a(502, 1, null);
    AppMethodBeat.o(41091);
  }
  
  private void cBH()
  {
    AppMethodBeat.i(41090);
    this.fwo.setVisibility(8);
    AppMethodBeat.o(41090);
  }
  
  private void cCl()
  {
    AppMethodBeat.i(41092);
    this.DR.setVisibility(8);
    AppMethodBeat.o(41092);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41093);
    this.rSr.b(new a.a()
    {
      public final void b(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
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
                m.g(m.this).bkk();
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
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41088);
    super.onDetachedFromWindow();
    this.rSr.destroy();
    AppMethodBeat.o(41088);
  }
  
  public final void setIgnoreVideoPreview(boolean paramBoolean)
  {
    this.rSs = paramBoolean;
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41089);
    this.rSr = new a();
    a.a(this.rSr);
    this.rSr.v(paramJSONArray);
    this.rSo = new h(getContext(), 8766);
    this.rSo.setBackgroundColor(-1);
    this.rSo.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(204996);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(204996);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (m.a(m.this).Ep(paramAnonymousInt)) {
          m.b(m.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41076);
      }
    });
    this.rSo.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
    {
      public final void Q(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41077);
        paramAnonymousView = m.a(m.this).Eq(paramAnonymousInt);
        if ((paramAnonymousView.rNJ) || (paramAnonymousView.rNK))
        {
          AppMethodBeat.o(41077);
          return;
        }
        if (m.c(m.this))
        {
          if (paramAnonymousView.dtp)
          {
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(m.this.getContext(), 6, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, m.d(m.this), null);
            AppMethodBeat.o(41077);
            return;
          }
          ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(m.this.getContext(), 6, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.rNM, m.d(m.this), null);
          AppMethodBeat.o(41077);
          return;
        }
        Intent localIntent = new Intent();
        com.tencent.mm.plugin.game.b.b.f localf = new com.tencent.mm.plugin.game.b.b.f();
        localf.rNQ = m.e(m.this).rQW;
        paramAnonymousInt = localf.rNQ.indexOf(paramAnonymousView);
        try
        {
          localIntent.putExtra("game_video_list", localf.toByteArray());
          localIntent.putExtra("game_video_list_current_index", paramAnonymousInt);
          localIntent.putExtra("game_video_has_next", m.e(m.this).hasNext());
          localIntent.putExtra("game_video_preview_source", p.a.rTF);
          d.b(m.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", localIntent, m.d(m.this));
          AppMethodBeat.o(41077);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          AppMethodBeat.o(41077);
        }
      }
    });
    this.rSB = new l(getContext());
    this.rSB.setPullDownEnabled(true);
    this.rSB.setNeedStay(true);
    this.rSB.setOnPullDownListener(new l.a()
    {
      public final void bkl()
      {
        AppMethodBeat.i(41079);
        m.a(m.this, System.currentTimeMillis());
        m.f(m.this).ffb();
        m.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41078);
            m.g(m.this).bkk();
            AppMethodBeat.o(41078);
          }
        }, 400L);
        AppMethodBeat.o(41079);
      }
      
      public final void cCn()
      {
        AppMethodBeat.i(41080);
        if (m.h(m.this) == 0L)
        {
          AppMethodBeat.o(41080);
          return;
        }
        long l1 = System.currentTimeMillis();
        long l2 = m.h(m.this);
        m.a(m.this, 0L);
        HashMap localHashMap = new HashMap();
        localHashMap.put("loading_time", Long.valueOf(l1 - l2));
        m.X(localHashMap);
        m.f(m.this).ffc();
        AppMethodBeat.o(41080);
      }
    });
    paramJSONArray = LayoutInflater.from(getContext()).inflate(2131494239, this, false);
    this.rSC = ((ThreeDotsLoadingView)paramJSONArray.findViewById(2131300543));
    this.rSB.j(paramJSONArray, this.rSo);
    addView(this.rSB, -1, -1);
    this.DR = LayoutInflater.from(getContext()).inflate(2131494236, this, false);
    this.DR.setVisibility(8);
    addView(this.DR, -1, -1);
    this.fwo = LayoutInflater.from(getContext()).inflate(2131494238, this, false);
    this.fwo.setVisibility(8);
    addView(this.fwo, -1, -1);
    paramJSONArray = this.rSr.cBR();
    if (bt.gL(paramJSONArray))
    {
      this.fwo.setVisibility(0);
      ((ThreeDotsLoadingView)this.fwo.findViewById(2131300503)).ffb();
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
          m.g(m.this).cCm();
          AppMethodBeat.o(41081);
        }
      }, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.m
 * JD-Core Version:    0.7.0.1
 */