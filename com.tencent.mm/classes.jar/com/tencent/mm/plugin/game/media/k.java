package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class k
  extends FrameLayout
{
  private View DR;
  private View fwo;
  private boolean rSb;
  private h rSo;
  private boolean rSp;
  private View rSq;
  private a rSr;
  private boolean rSs = true;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41056);
    cBH();
    if (!bt.gL(paramLinkedList))
    {
      cCl();
      if (this.rSp)
      {
        ad.d("MicroMsg.GameHaoWanGalleryView", "data not null, appid : %d", new Object[] { ((e)paramLinkedList.get(0)).appId });
        a.cBY();
      }
    }
    for (;;)
    {
      this.rSo.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41056);
      return;
      bbB();
      ((GamePublishGalleryUI)getContext()).cCk();
    }
  }
  
  private void bbB()
  {
    AppMethodBeat.i(41054);
    this.DR.setVisibility(0);
    e(502, null);
    AppMethodBeat.o(41054);
  }
  
  private void cBH()
  {
    AppMethodBeat.i(41053);
    this.fwo.setVisibility(8);
    AppMethodBeat.o(41053);
  }
  
  static void cCf()
  {
    AppMethodBeat.i(41058);
    a.En(1);
    AppMethodBeat.o(41058);
  }
  
  private void cCl()
  {
    AppMethodBeat.i(41055);
    this.DR.setVisibility(8);
    AppMethodBeat.o(41055);
  }
  
  private static void e(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(41059);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    com.tencent.mm.game.report.b.a.a(aj.getContext(), 8762, paramInt, 1, com.tencent.mm.game.report.b.a.a(7, (Map)localObject));
    AppMethodBeat.o(41059);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41057);
    System.currentTimeMillis();
    this.rSr.b(new a.a()
    {
      public final void b(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41049);
        if (((Activity)k.this.getContext()).isFinishing())
        {
          AppMethodBeat.o(41049);
          return;
        }
        k.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41048);
            k.a(k.this, paramAnonymousLinkedList, paramAnonymousBoolean);
            AppMethodBeat.o(41048);
          }
        });
        AppMethodBeat.o(41049);
      }
    });
    AppMethodBeat.o(41057);
  }
  
  public final void cCd()
  {
    AppMethodBeat.i(41051);
    if (!this.rSb) {
      e(0, new HashMap());
    }
    this.rSb = true;
    AppMethodBeat.o(41051);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41050);
    super.onDetachedFromWindow();
    this.rSr.destroy();
    AppMethodBeat.o(41050);
  }
  
  public final void setIgnoreVideoPreview(boolean paramBoolean)
  {
    this.rSs = paramBoolean;
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41052);
    this.rSr = new a();
    a.a(this.rSr);
    this.rSr.v(paramJSONArray);
    this.rSo = new h(getContext(), 8762);
    this.rSo.setBackgroundColor(getResources().getColor(2131101179));
    this.rSo.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(204995);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(204995);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41045);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (k.a(k.this).Ep(paramAnonymousInt)) {
          k.b(k.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41045);
      }
    });
    this.rSo.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
    {
      public final void Q(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41046);
        paramAnonymousView = k.a(k.this).Eq(paramAnonymousInt);
        if ((paramAnonymousView.rNJ) || (paramAnonymousView.rNK))
        {
          AppMethodBeat.o(41046);
          return;
        }
        if (k.c(k.this))
        {
          if (paramAnonymousView.dtp)
          {
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, k.this.hashCode() & 0xFFFF, null);
            AppMethodBeat.o(41046);
            return;
          }
          ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.rNM, k.this.hashCode() & 0xFFFF, null);
          AppMethodBeat.o(41046);
          return;
        }
        Intent localIntent = new Intent();
        com.tencent.mm.plugin.game.b.b.f localf = new com.tencent.mm.plugin.game.b.b.f();
        localf.rNQ = k.d(k.this).rQW;
        paramAnonymousInt = localf.rNQ.indexOf(paramAnonymousView);
        try
        {
          localIntent.putExtra("game_video_list", localf.toByteArray());
          localIntent.putExtra("game_video_list_current_index", paramAnonymousInt);
          localIntent.putExtra("game_video_has_next", k.d(k.this).hasNext());
          localIntent.putExtra("game_video_preview_source", p.a.rTE);
          d.b(k.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", localIntent, k.this.hashCode() & 0xFFFF);
          AppMethodBeat.o(41046);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          AppMethodBeat.o(41046);
        }
      }
    });
    addView(this.rSo, -1, -1);
    this.DR = LayoutInflater.from(getContext()).inflate(2131494236, this, false);
    this.DR.setVisibility(8);
    addView(this.DR, -1, -1);
    this.rSp = a.cBZ();
    ad.d("MicroMsg.GameHaoWanGalleryView", "first enter : %b", new Object[] { Boolean.valueOf(this.rSp) });
    if (this.rSp)
    {
      this.rSq = LayoutInflater.from(getContext()).inflate(2131494237, this.rSo, false);
      ((ImageView)this.rSq.findViewById(2131300464)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41047);
          k.e(k.this).setVisibility(8);
          AppMethodBeat.o(41047);
        }
      });
      paramJSONArray = this.rSo;
      View localView = this.rSq;
      paramJSONArray.rRD.rRI.add(localView);
      e(503, null);
    }
    this.fwo = LayoutInflater.from(getContext()).inflate(2131494238, this, false);
    this.fwo.setVisibility(8);
    addView(this.fwo, -1, -1);
    paramJSONArray = this.rSr.cBR();
    if (bt.gL(paramJSONArray)) {
      this.fwo.setVisibility(0);
    }
    for (;;)
    {
      getDataFromNet();
      AppMethodBeat.o(41052);
      return;
      b(paramJSONArray, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.k
 * JD-Core Version:    0.7.0.1
 */