package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class k
  extends FrameLayout
{
  private View GQ;
  private View gAy;
  private boolean gOZ;
  private View jBN;
  private View pyo;
  private int xAD = 0;
  private boolean xBc = false;
  private boolean xBd = false;
  private h xBq;
  private boolean xBr;
  private View xBs;
  private a xBt;
  private boolean xBu = true;
  e xBv;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41056);
    dTO();
    if (!Util.isNullOrNil(paramLinkedList))
    {
      dUt();
      if (this.xBr)
      {
        Log.d("MicroMsg.GameHaoWanGalleryView", "data not null, appid : %d", new Object[] { ((e)paramLinkedList.get(0)).appId });
        a.dUg();
      }
    }
    for (;;)
    {
      this.xBq.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41056);
      return;
      bIo();
      ((GamePublishGalleryUI)getContext()).dUs();
    }
  }
  
  private void bIo()
  {
    AppMethodBeat.i(41054);
    this.GQ.setVisibility(0);
    h(502, null);
    AppMethodBeat.o(41054);
  }
  
  private void dTO()
  {
    AppMethodBeat.i(41053);
    this.gAy.setVisibility(8);
    AppMethodBeat.o(41053);
  }
  
  static void dUn()
  {
    AppMethodBeat.i(41058);
    a.Od(1);
    AppMethodBeat.o(41058);
  }
  
  private void dUt()
  {
    AppMethodBeat.i(41055);
    this.GQ.setVisibility(8);
    AppMethodBeat.o(41055);
  }
  
  private void em(View paramView)
  {
    AppMethodBeat.i(204125);
    ((ViewGroup)this.jBN.findViewById(2131301855)).addView(paramView, -1, -1);
    AppMethodBeat.o(204125);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41057);
    System.currentTimeMillis();
    this.xBt.b(new a.a()
    {
      public final void c(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(204123);
        if (((Activity)k.this.getContext()).isFinishing())
        {
          AppMethodBeat.o(204123);
          return;
        }
        k.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204122);
            k.a(k.this, paramAnonymousLinkedList, paramAnonymousBoolean);
            AppMethodBeat.o(204122);
          }
        });
        AppMethodBeat.o(204123);
      }
    });
    AppMethodBeat.o(41057);
  }
  
  private void h(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(41059);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8762, paramInt, 1, this.xAD, com.tencent.mm.game.report.b.a.c(7, (Map)localObject));
    AppMethodBeat.o(41059);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(204124);
    this.xBu = paramBoolean1;
    this.xBc = paramBoolean2;
    if ((this.xBc) && (this.pyo != null)) {
      this.pyo.setVisibility(8);
    }
    this.xBd = paramBoolean3;
    this.xAD = paramInt;
    AppMethodBeat.o(204124);
  }
  
  public final void dUl()
  {
    AppMethodBeat.i(41051);
    if (!this.gOZ) {
      h(0, new HashMap());
    }
    this.gOZ = true;
    AppMethodBeat.o(41051);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41050);
    super.onDetachedFromWindow();
    this.xBt.destroy();
    AppMethodBeat.o(41050);
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41052);
    this.xBt = new a();
    a.a(this.xBt);
    this.xBt.y(paramJSONArray);
    this.jBN = LayoutInflater.from(getContext()).inflate(2131494876, this, true);
    this.pyo = this.jBN.findViewById(2131301974);
    if (!this.xBc)
    {
      this.pyo.setVisibility(0);
      this.jBN.findViewById(2131302032).setOnClickListener(new k.4(this));
      this.xBq = new h(getContext(), 8762, this.xAD);
      this.xBq.setBackgroundColor(getResources().getColor(2131101424));
      this.xBq.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(41045);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          if (k.a(k.this).Of(paramAnonymousInt)) {
            k.b(k.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(41045);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(204120);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt1);
          localb.pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(204120);
        }
      });
      this.xBq.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
      {
        public final void Q(View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(41046);
          paramAnonymousView = k.a(k.this).Og(paramAnonymousInt);
          if ((paramAnonymousView.xuJ) || (paramAnonymousView.xuK))
          {
            AppMethodBeat.o(41046);
            return;
          }
          k.a(k.this, paramAnonymousView);
          if (k.c(k.this))
          {
            localObject = new Bundle();
            ((Bundle)localObject).putBoolean("game_straight_to_publish", k.d(k.this));
            if (paramAnonymousView.dLQ)
            {
              ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.g.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, k.this.hashCode() & 0xFFFF, (Bundle)localObject, k.e(k.this));
              AppMethodBeat.o(41046);
              return;
            }
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.g.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.xuM, k.this.hashCode() & 0xFFFF, (Bundle)localObject, k.e(k.this));
            AppMethodBeat.o(41046);
            return;
          }
          Object localObject = new Intent();
          f localf = new f();
          localf.xuQ = k.f(k.this).xzV;
          paramAnonymousInt = localf.xuQ.indexOf(paramAnonymousView);
          try
          {
            ((Intent)localObject).putExtra("game_video_list", localf.toByteArray());
            ((Intent)localObject).putExtra("game_video_list_current_index", paramAnonymousInt);
            ((Intent)localObject).putExtra("game_video_has_next", k.f(k.this).hasNext());
            ((Intent)localObject).putExtra("game_video_preview_source", p.a.xCH);
            ((Intent)localObject).putExtra("game_straight_to_publish", k.d(k.this));
            ((Intent)localObject).putExtra("game_haowan_source_scene_id", k.e(k.this));
            c.b(k.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", (Intent)localObject, k.this.hashCode() & 0xFFFF);
            AppMethodBeat.o(41046);
            return;
          }
          catch (IOException paramAnonymousView)
          {
            AppMethodBeat.o(41046);
          }
        }
      });
      em(this.xBq);
      this.GQ = LayoutInflater.from(getContext()).inflate(2131494797, this, false);
      this.GQ.setVisibility(8);
      em(this.GQ);
      this.xBr = a.dUh();
      Log.d("MicroMsg.GameHaoWanGalleryView", "first enter : %b", new Object[] { Boolean.valueOf(this.xBr) });
      if (this.xBr)
      {
        this.xBs = LayoutInflater.from(getContext()).inflate(2131494798, this.xBq, false);
        ((ImageView)this.xBs.findViewById(2131301987)).setOnClickListener(new k.3(this));
        paramJSONArray = this.xBq;
        View localView = this.xBs;
        paramJSONArray.xAE.xAJ.add(localView);
        h(503, null);
      }
      this.gAy = LayoutInflater.from(getContext()).inflate(2131494799, this, false);
      this.gAy.setVisibility(8);
      em(this.gAy);
      paramJSONArray = this.xBt.dTZ();
      if (!Util.isNullOrNil(paramJSONArray)) {
        break label403;
      }
      this.gAy.setVisibility(0);
    }
    for (;;)
    {
      getDataFromNet();
      AppMethodBeat.o(41052);
      return;
      this.pyo.setVisibility(8);
      break;
      label403:
      b(paramJSONArray, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.k
 * JD-Core Version:    0.7.0.1
 */