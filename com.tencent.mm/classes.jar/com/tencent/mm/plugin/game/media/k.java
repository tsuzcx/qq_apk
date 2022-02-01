package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
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
  private View GG;
  private View fTl;
  private boolean tXI;
  private h tXV;
  private boolean tXW;
  private View tXX;
  private a tXY;
  private boolean tXZ = true;
  e tYa;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41056);
    cXv();
    if (!bt.hj(paramLinkedList))
    {
      cYb();
      if (this.tXW)
      {
        ad.d("MicroMsg.GameHaoWanGalleryView", "data not null, appid : %d", new Object[] { ((e)paramLinkedList.get(0)).appId });
        a.cXO();
      }
    }
    for (;;)
    {
      this.tXV.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41056);
      return;
      bmg();
      ((GamePublishGalleryUI)getContext()).cYa();
    }
  }
  
  private void bmg()
  {
    AppMethodBeat.i(41054);
    this.GG.setVisibility(0);
    f(502, null);
    AppMethodBeat.o(41054);
  }
  
  static void cXV()
  {
    AppMethodBeat.i(41058);
    a.HD(1);
    AppMethodBeat.o(41058);
  }
  
  private void cXv()
  {
    AppMethodBeat.i(41053);
    this.fTl.setVisibility(8);
    AppMethodBeat.o(41053);
  }
  
  private void cYb()
  {
    AppMethodBeat.i(41055);
    this.GG.setVisibility(8);
    AppMethodBeat.o(41055);
  }
  
  private void eo(View paramView)
  {
    AppMethodBeat.i(206809);
    View localView = LayoutInflater.from(getContext()).inflate(2131496276, this, true);
    localView.findViewById(2131307468).setOnClickListener(new k.4(this));
    ((ViewGroup)localView.findViewById(2131307466)).addView(paramView, -1, -1);
    AppMethodBeat.o(206809);
  }
  
  private static void f(int paramInt, Map paramMap)
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
    this.tXY.b(new a.a()
    {
      public final void b(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(206808);
        if (((Activity)k.this.getContext()).isFinishing())
        {
          AppMethodBeat.o(206808);
          return;
        }
        k.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206807);
            k.a(k.this, paramAnonymousLinkedList, paramAnonymousBoolean);
            AppMethodBeat.o(206807);
          }
        });
        AppMethodBeat.o(206808);
      }
    });
    AppMethodBeat.o(41057);
  }
  
  public final void cXT()
  {
    AppMethodBeat.i(41051);
    if (!this.tXI) {
      f(0, new HashMap());
    }
    this.tXI = true;
    AppMethodBeat.o(41051);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41050);
    super.onDetachedFromWindow();
    this.tXY.destroy();
    AppMethodBeat.o(41050);
  }
  
  public final void setIgnoreVideoPreview(boolean paramBoolean)
  {
    this.tXZ = paramBoolean;
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41052);
    this.tXY = new a();
    a.a(this.tXY);
    this.tXY.w(paramJSONArray);
    this.tXV = new h(getContext(), 8762);
    this.tXV.setBackgroundColor(getResources().getColor(2131101179));
    this.tXV.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(206805);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(206805);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41045);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (k.a(k.this).HF(paramAnonymousInt)) {
          k.b(k.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41045);
      }
    });
    this.tXV.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
    {
      public final void R(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41046);
        paramAnonymousView = k.a(k.this).HG(paramAnonymousInt);
        if ((paramAnonymousView.tSe) || (paramAnonymousView.tSf))
        {
          AppMethodBeat.o(41046);
          return;
        }
        k.a(k.this, paramAnonymousView);
        if (k.c(k.this))
        {
          if (paramAnonymousView.dCQ)
          {
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, k.this.hashCode() & 0xFFFF, null);
            AppMethodBeat.o(41046);
            return;
          }
          ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.tSh, k.this.hashCode() & 0xFFFF, null);
          AppMethodBeat.o(41046);
          return;
        }
        Intent localIntent = new Intent();
        f localf = new f();
        localf.tSm = k.d(k.this).tWD;
        paramAnonymousInt = localf.tSm.indexOf(paramAnonymousView);
        try
        {
          localIntent.putExtra("game_video_list", localf.toByteArray());
          localIntent.putExtra("game_video_list_current_index", paramAnonymousInt);
          localIntent.putExtra("game_video_has_next", k.d(k.this).hasNext());
          localIntent.putExtra("game_video_preview_source", p.a.tZm);
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
    eo(this.tXV);
    this.GG = LayoutInflater.from(getContext()).inflate(2131494236, this, false);
    this.GG.setVisibility(8);
    eo(this.GG);
    this.tXW = a.cXP();
    ad.d("MicroMsg.GameHaoWanGalleryView", "first enter : %b", new Object[] { Boolean.valueOf(this.tXW) });
    if (this.tXW)
    {
      this.tXX = LayoutInflater.from(getContext()).inflate(2131494237, this.tXV, false);
      ((ImageView)this.tXX.findViewById(2131300464)).setOnClickListener(new k.3(this));
      paramJSONArray = this.tXV;
      View localView = this.tXX;
      paramJSONArray.tXk.tXp.add(localView);
      f(503, null);
    }
    this.fTl = LayoutInflater.from(getContext()).inflate(2131494238, this, false);
    this.fTl.setVisibility(8);
    eo(this.fTl);
    paramJSONArray = this.tXY.cXH();
    if (bt.hj(paramJSONArray)) {
      this.fTl.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.k
 * JD-Core Version:    0.7.0.1
 */