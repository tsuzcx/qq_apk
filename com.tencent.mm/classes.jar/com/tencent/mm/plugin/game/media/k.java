package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class k
  extends FrameLayout
{
  private View GG;
  private View fVr;
  private View iFK;
  View olQ;
  private boolean uiI;
  boolean uiJ = false;
  boolean uiK = false;
  private h uiX;
  private boolean uiY;
  private View uiZ;
  private a uja;
  boolean ujb = true;
  e ujc;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41056);
    daf();
    if (!bu.ht(paramLinkedList))
    {
      daL();
      if (this.uiY)
      {
        ae.d("MicroMsg.GameHaoWanGalleryView", "data not null, appid : %d", new Object[] { ((e)paramLinkedList.get(0)).appId });
        a.day();
      }
    }
    for (;;)
    {
      this.uiX.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41056);
      return;
      bmP();
      ((GamePublishGalleryUI)getContext()).daK();
    }
  }
  
  private void bmP()
  {
    AppMethodBeat.i(41054);
    this.GG.setVisibility(0);
    g(502, null);
    AppMethodBeat.o(41054);
  }
  
  static void daF()
  {
    AppMethodBeat.i(41058);
    a.Ia(1);
    AppMethodBeat.o(41058);
  }
  
  private void daL()
  {
    AppMethodBeat.i(41055);
    this.GG.setVisibility(8);
    AppMethodBeat.o(41055);
  }
  
  private void daf()
  {
    AppMethodBeat.i(41053);
    this.fVr.setVisibility(8);
    AppMethodBeat.o(41053);
  }
  
  private void eo(View paramView)
  {
    AppMethodBeat.i(195619);
    ((ViewGroup)this.iFK.findViewById(2131307466)).addView(paramView, -1, -1);
    AppMethodBeat.o(195619);
  }
  
  private static void g(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(41059);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    com.tencent.mm.game.report.b.a.a(ak.getContext(), 8762, paramInt, 1, com.tencent.mm.game.report.b.a.b(7, (Map)localObject));
    AppMethodBeat.o(41059);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41057);
    System.currentTimeMillis();
    this.uja.b(new a.a()
    {
      public final void b(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195618);
        if (((Activity)k.this.getContext()).isFinishing())
        {
          AppMethodBeat.o(195618);
          return;
        }
        k.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195617);
            k.a(k.this, paramAnonymousLinkedList, paramAnonymousBoolean);
            AppMethodBeat.o(195617);
          }
        });
        AppMethodBeat.o(195618);
      }
    });
    AppMethodBeat.o(41057);
  }
  
  public final void daD()
  {
    AppMethodBeat.i(41051);
    if (!this.uiI) {
      g(0, new HashMap());
    }
    this.uiI = true;
    AppMethodBeat.o(41051);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41050);
    super.onDetachedFromWindow();
    this.uja.destroy();
    AppMethodBeat.o(41050);
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41052);
    this.uja = new a();
    a.a(this.uja);
    this.uja.x(paramJSONArray);
    this.iFK = LayoutInflater.from(getContext()).inflate(2131496276, this, true);
    this.olQ = this.iFK.findViewById(2131300451);
    if (!this.uiJ)
    {
      this.olQ.setVisibility(0);
      this.iFK.findViewById(2131307468).setOnClickListener(new k.4(this));
      this.uiX = new h(getContext(), 8762);
      this.uiX.setBackgroundColor(getResources().getColor(2131101179));
      this.uiX.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(195615);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt1);
          localb.mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(195615);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(41045);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          if (k.a(k.this).Ic(paramAnonymousInt)) {
            k.b(k.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(41045);
        }
      });
      this.uiX.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
      {
        public final void R(View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(41046);
          paramAnonymousView = k.a(k.this).Id(paramAnonymousInt);
          if ((paramAnonymousView.ucV) || (paramAnonymousView.ucW))
          {
            AppMethodBeat.o(41046);
            return;
          }
          k.a(k.this, paramAnonymousView);
          if (k.c(k.this))
          {
            localObject = new Bundle();
            ((Bundle)localObject).putBoolean("game_straight_to_publish", k.d(k.this));
            if (paramAnonymousView.dDV)
            {
              ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, k.this.hashCode() & 0xFFFF, (Bundle)localObject);
              AppMethodBeat.o(41046);
              return;
            }
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.ucY, k.this.hashCode() & 0xFFFF, (Bundle)localObject);
            AppMethodBeat.o(41046);
            return;
          }
          Object localObject = new Intent();
          f localf = new f();
          localf.udd = k.e(k.this).uhB;
          paramAnonymousInt = localf.udd.indexOf(paramAnonymousView);
          try
          {
            ((Intent)localObject).putExtra("game_video_list", localf.toByteArray());
            ((Intent)localObject).putExtra("game_video_list_current_index", paramAnonymousInt);
            ((Intent)localObject).putExtra("game_video_has_next", k.e(k.this).hasNext());
            ((Intent)localObject).putExtra("game_video_preview_source", p.a.uko);
            ((Intent)localObject).putExtra("game_straight_to_publish", k.d(k.this));
            d.b(k.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", (Intent)localObject, k.this.hashCode() & 0xFFFF);
            AppMethodBeat.o(41046);
            return;
          }
          catch (IOException paramAnonymousView)
          {
            AppMethodBeat.o(41046);
          }
        }
      });
      eo(this.uiX);
      this.GG = LayoutInflater.from(getContext()).inflate(2131494236, this, false);
      this.GG.setVisibility(8);
      eo(this.GG);
      this.uiY = a.daz();
      ae.d("MicroMsg.GameHaoWanGalleryView", "first enter : %b", new Object[] { Boolean.valueOf(this.uiY) });
      if (this.uiY)
      {
        this.uiZ = LayoutInflater.from(getContext()).inflate(2131494237, this.uiX, false);
        ((ImageView)this.uiZ.findViewById(2131300464)).setOnClickListener(new k.3(this));
        paramJSONArray = this.uiX;
        View localView = this.uiZ;
        paramJSONArray.uij.uip.add(localView);
        g(503, null);
      }
      this.fVr = LayoutInflater.from(getContext()).inflate(2131494238, this, false);
      this.fVr.setVisibility(8);
      eo(this.fVr);
      paramJSONArray = this.uja.dar();
      if (!bu.ht(paramJSONArray)) {
        break label398;
      }
      this.fVr.setVisibility(0);
    }
    for (;;)
    {
      getDataFromNet();
      AppMethodBeat.o(41052);
      return;
      this.olQ.setVisibility(8);
      break;
      label398:
      b(paramJSONArray, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.k
 * JD-Core Version:    0.7.0.1
 */