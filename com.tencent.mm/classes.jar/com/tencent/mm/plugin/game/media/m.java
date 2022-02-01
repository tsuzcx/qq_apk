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
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class m
  extends FrameLayout
{
  private View GG;
  private View fVr;
  private int mRequestCode;
  private h uiX;
  private a uja;
  private boolean ujb;
  private l ujl;
  private ThreeDotsLoadingView ujm;
  private long ujn;
  
  public m(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(41087);
    this.ujb = true;
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
    com.tencent.mm.game.report.b.a.a(ak.getContext(), 8766, paramInt1, paramInt2, com.tencent.mm.game.report.b.a.b(6, (Map)localObject));
    AppMethodBeat.o(41095);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41094);
    daf();
    ae.i("MicroMsg.GameTabGalleryView", "setData, data is null : %b", new Object[] { Boolean.valueOf(bu.ht(paramLinkedList)) });
    if (!bu.ht(paramLinkedList))
    {
      daL();
      if (a.dax())
      {
        a.daw();
        ar.o(new Runnable()
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
      this.uiX.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41094);
      return;
      bmP();
    }
  }
  
  private void bmP()
  {
    AppMethodBeat.i(41091);
    this.GG.setVisibility(0);
    a(502, 1, null);
    AppMethodBeat.o(41091);
  }
  
  private void daL()
  {
    AppMethodBeat.i(41092);
    this.GG.setVisibility(8);
    AppMethodBeat.o(41092);
  }
  
  private void daf()
  {
    AppMethodBeat.i(41090);
    this.fVr.setVisibility(8);
    AppMethodBeat.o(41090);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41093);
    this.uja.b(new a.a()
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
                m.g(m.this).bvL();
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
    this.uja.destroy();
    AppMethodBeat.o(41088);
  }
  
  public final void setIgnoreVideoPreview(boolean paramBoolean)
  {
    this.ujb = paramBoolean;
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41089);
    this.uja = new a();
    a.a(this.uja);
    this.uja.x(paramJSONArray);
    this.uiX = new h(getContext(), 8766);
    this.uiX.setBackgroundColor(-1);
    this.uiX.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(195621);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(195621);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (m.a(m.this).Ic(paramAnonymousInt)) {
          m.b(m.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41076);
      }
    });
    this.uiX.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
    {
      public final void R(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41077);
        paramAnonymousView = m.a(m.this).Id(paramAnonymousInt);
        if ((paramAnonymousView.ucV) || (paramAnonymousView.ucW))
        {
          AppMethodBeat.o(41077);
          return;
        }
        if (m.c(m.this))
        {
          if (paramAnonymousView.dDV)
          {
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(m.this.getContext(), 6, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, m.d(m.this), null);
            AppMethodBeat.o(41077);
            return;
          }
          ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(m.this.getContext(), 6, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.ucY, m.d(m.this), null);
          AppMethodBeat.o(41077);
          return;
        }
        Intent localIntent = new Intent();
        f localf = new f();
        localf.udd = m.e(m.this).uhB;
        paramAnonymousInt = localf.udd.indexOf(paramAnonymousView);
        try
        {
          localIntent.putExtra("game_video_list", localf.toByteArray());
          localIntent.putExtra("game_video_list_current_index", paramAnonymousInt);
          localIntent.putExtra("game_video_has_next", m.e(m.this).hasNext());
          localIntent.putExtra("game_video_preview_source", p.a.ukp);
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
    this.ujl = new l(getContext());
    this.ujl.setPullDownEnabled(true);
    this.ujl.setNeedStay(true);
    this.ujl.setOnPullDownListener(new l.a()
    {
      public final void bvM()
      {
        AppMethodBeat.i(41079);
        m.a(m.this, System.currentTimeMillis());
        m.f(m.this).fQd();
        m.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41078);
            m.g(m.this).bvL();
            AppMethodBeat.o(41078);
          }
        }, 400L);
        AppMethodBeat.o(41079);
      }
      
      public final void daN()
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
        m.ai(localHashMap);
        m.f(m.this).fQe();
        AppMethodBeat.o(41080);
      }
    });
    paramJSONArray = LayoutInflater.from(getContext()).inflate(2131494239, this, false);
    this.ujm = ((ThreeDotsLoadingView)paramJSONArray.findViewById(2131300543));
    this.ujl.k(paramJSONArray, this.uiX);
    addView(this.ujl, -1, -1);
    this.GG = LayoutInflater.from(getContext()).inflate(2131494236, this, false);
    this.GG.setVisibility(8);
    addView(this.GG, -1, -1);
    this.fVr = LayoutInflater.from(getContext()).inflate(2131494238, this, false);
    this.fVr.setVisibility(8);
    addView(this.fVr, -1, -1);
    paramJSONArray = this.uja.dar();
    if (bu.ht(paramJSONArray))
    {
      this.fVr.setVisibility(0);
      ((ThreeDotsLoadingView)this.fVr.findViewById(2131300503)).fQd();
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
          m.g(m.this).daM();
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