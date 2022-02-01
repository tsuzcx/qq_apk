package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.autogen.b.f;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
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
  private int IyH = 0;
  e IzA;
  private boolean Izg;
  private boolean Izh = false;
  private boolean Izi = false;
  private h Izv;
  private boolean Izw;
  private View Izx;
  private a Izy;
  private boolean Izz = true;
  private View bEx;
  private View lNf;
  private View plc;
  private View vNn;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41056);
    fEC();
    if (!Util.isNullOrNil(paramLinkedList))
    {
      fFw();
      if (this.Izw)
      {
        Log.d("MicroMsg.GameHaoWanGalleryView", "data not null, appid : %d", new Object[] { ((e)paramLinkedList.get(0)).appId });
        a.fFk();
      }
    }
    for (;;)
    {
      this.Izv.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41056);
      return;
      cul();
      ((GamePublishGalleryUI)getContext()).fFv();
    }
  }
  
  private void cul()
  {
    AppMethodBeat.i(41054);
    this.bEx.setVisibility(0);
    f(502, null);
    AppMethodBeat.o(41054);
  }
  
  private void f(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(41059);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8762, paramInt, 1, this.IyH, com.tencent.mm.game.report.b.a.a(7, (Map)localObject));
    AppMethodBeat.o(41059);
  }
  
  private void fEC()
  {
    AppMethodBeat.i(41053);
    this.lNf.setVisibility(8);
    AppMethodBeat.o(41053);
  }
  
  static void fFq()
  {
    AppMethodBeat.i(41058);
    a.Xq(1);
    AppMethodBeat.o(41058);
  }
  
  private void fFw()
  {
    AppMethodBeat.i(41055);
    this.bEx.setVisibility(8);
    AppMethodBeat.o(41055);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41057);
    System.currentTimeMillis();
    this.Izy.b(new a.a()
    {
      public final void d(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(276818);
        k.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276842);
            if ((((Activity)k.this.getContext()).isFinishing()) || (((Activity)k.this.getContext()).isDestroyed()))
            {
              AppMethodBeat.o(276842);
              return;
            }
            k.a(k.this, paramAnonymousLinkedList, paramAnonymousBoolean);
            AppMethodBeat.o(276842);
          }
        });
        AppMethodBeat.o(276818);
      }
    });
    AppMethodBeat.o(41057);
  }
  
  private void hx(View paramView)
  {
    AppMethodBeat.i(276816);
    ((ViewGroup)this.plc.findViewById(h.e.HTS)).addView(paramView, -1, -1);
    AppMethodBeat.o(276816);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(276846);
    this.Izz = paramBoolean1;
    this.Izh = paramBoolean2;
    if ((this.Izh) && (this.vNn != null)) {
      this.vNn.setVisibility(8);
    }
    this.Izi = paramBoolean3;
    this.IyH = paramInt;
    AppMethodBeat.o(276846);
  }
  
  public final void fFo()
  {
    AppMethodBeat.i(41051);
    if (!this.Izg) {
      f(0, new HashMap());
    }
    this.Izg = true;
    AppMethodBeat.o(41051);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41050);
    super.onDetachedFromWindow();
    this.Izy.destroy();
    AppMethodBeat.o(41050);
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41052);
    this.Izy = new a();
    a.a(this.Izy);
    this.Izy.B(paramJSONArray);
    this.plc = LayoutInflater.from(getContext()).inflate(h.f.HZy, this, true);
    this.vNn = this.plc.findViewById(h.e.HVs);
    if (!this.Izh)
    {
      this.vNn.setVisibility(0);
      this.plc.findViewById(h.e.HWb).setOnClickListener(new k.4(this));
      this.Izv = new h(getContext(), 8762, this.IyH);
      this.Izv.setBackgroundColor(getResources().getColor(h.b.white));
      this.Izv.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(276820);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          if (k.a(k.this).Xs(paramAnonymousInt)) {
            k.b(k.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(276820);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(276822);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt1);
          localb.sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(276822);
        }
      });
      this.Izv.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
      {
        public final void onItemClick(View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(276824);
          paramAnonymousView = k.a(k.this).Xt(paramAnonymousInt);
          if ((paramAnonymousView.Idj) || (paramAnonymousView.Idk))
          {
            AppMethodBeat.o(276824);
            return;
          }
          k.a(k.this, paramAnonymousView);
          if (k.c(k.this))
          {
            localObject = new Bundle();
            ((Bundle)localObject).putBoolean("game_straight_to_publish", k.d(k.this));
            if (paramAnonymousView.hJv)
            {
              ((com.tencent.mm.plugin.game.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.h.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, k.this.hashCode() & 0xFFFF, (Bundle)localObject, k.e(k.this));
              AppMethodBeat.o(276824);
              return;
            }
            ((com.tencent.mm.plugin.game.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.h.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.Idm, k.this.hashCode() & 0xFFFF, (Bundle)localObject, k.e(k.this));
            AppMethodBeat.o(276824);
            return;
          }
          Object localObject = new Intent();
          f localf = new f();
          localf.Idq = k.f(k.this).Iya;
          paramAnonymousInt = localf.Idq.indexOf(paramAnonymousView);
          try
          {
            ((Intent)localObject).putExtra("game_video_list", localf.toByteArray());
            ((Intent)localObject).putExtra("game_video_list_current_index", paramAnonymousInt);
            ((Intent)localObject).putExtra("game_video_has_next", k.f(k.this).hasNext());
            ((Intent)localObject).putExtra("game_video_preview_source", q.a.IAR);
            ((Intent)localObject).putExtra("game_straight_to_publish", k.d(k.this));
            ((Intent)localObject).putExtra("game_haowan_source_scene_id", k.e(k.this));
            c.b(k.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", (Intent)localObject, k.this.hashCode() & 0xFFFF);
            AppMethodBeat.o(276824);
            return;
          }
          catch (IOException paramAnonymousView)
          {
            AppMethodBeat.o(276824);
          }
        }
      });
      hx(this.Izv);
      this.bEx = LayoutInflater.from(getContext()).inflate(h.f.HYp, this, false);
      this.bEx.setVisibility(8);
      hx(this.bEx);
      this.Izw = a.fFl();
      Log.d("MicroMsg.GameHaoWanGalleryView", "first enter : %b", new Object[] { Boolean.valueOf(this.Izw) });
      if (this.Izw)
      {
        this.Izx = LayoutInflater.from(getContext()).inflate(h.f.HYq, this.Izv, false);
        ((ImageView)this.Izx.findViewById(h.e.game_icon_tips_close)).setOnClickListener(new k.3(this));
        paramJSONArray = this.Izv;
        View localView = this.Izx;
        paramJSONArray.IyI.IyN.add(localView);
        f(503, null);
      }
      this.lNf = LayoutInflater.from(getContext()).inflate(h.f.HYr, this, false);
      this.lNf.setVisibility(8);
      hx(this.lNf);
      paramJSONArray = this.Izy.fFd();
      if (!Util.isNullOrNil(paramJSONArray)) {
        break label406;
      }
      this.lNf.setVisibility(0);
    }
    for (;;)
    {
      getDataFromNet();
      AppMethodBeat.o(41052);
      return;
      this.vNn.setVisibility(8);
      break;
      label406:
      b(paramJSONArray, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.k
 * JD-Core Version:    0.7.0.1
 */