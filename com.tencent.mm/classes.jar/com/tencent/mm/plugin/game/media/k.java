package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.autogen.b.f;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
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
  private int CEE = 0;
  private boolean CFd = false;
  private boolean CFe = false;
  private h CFr;
  private boolean CFs;
  private View CFt;
  private a CFu;
  private boolean CFv = true;
  e CFw;
  private View Xd;
  private View jkB;
  private boolean jzt;
  private View mrI;
  private View sHR;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41056);
    ewK();
    if (!Util.isNullOrNil(paramLinkedList))
    {
      exA();
      if (this.CFs)
      {
        Log.d("MicroMsg.GameHaoWanGalleryView", "data not null, appid : %d", new Object[] { ((e)paramLinkedList.get(0)).appId });
        a.exn();
      }
    }
    for (;;)
    {
      this.CFr.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41056);
      return;
      bTY();
      ((GamePublishGalleryUI)getContext()).exz();
    }
  }
  
  private void bTY()
  {
    AppMethodBeat.i(41054);
    this.Xd.setVisibility(0);
    g(502, null);
    AppMethodBeat.o(41054);
  }
  
  private void eZ(View paramView)
  {
    AppMethodBeat.i(194108);
    ((ViewGroup)this.mrI.findViewById(g.e.ChK)).addView(paramView, -1, -1);
    AppMethodBeat.o(194108);
  }
  
  private void ewK()
  {
    AppMethodBeat.i(41053);
    this.jkB.setVisibility(8);
    AppMethodBeat.o(41053);
  }
  
  private void exA()
  {
    AppMethodBeat.i(41055);
    this.Xd.setVisibility(8);
    AppMethodBeat.o(41055);
  }
  
  static void exu()
  {
    AppMethodBeat.i(41058);
    a.Tw(1);
    AppMethodBeat.o(41058);
  }
  
  private void g(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(41059);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8762, paramInt, 1, this.CEE, com.tencent.mm.game.report.b.a.b(7, (Map)localObject));
    AppMethodBeat.o(41059);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41057);
    System.currentTimeMillis();
    this.CFu.b(new a.a()
    {
      public final void d(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(207137);
        k.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195949);
            if ((((Activity)k.this.getContext()).isFinishing()) || (((Activity)k.this.getContext()).isDestroyed()))
            {
              AppMethodBeat.o(195949);
              return;
            }
            k.a(k.this, paramAnonymousLinkedList, paramAnonymousBoolean);
            AppMethodBeat.o(195949);
          }
        });
        AppMethodBeat.o(207137);
      }
    });
    AppMethodBeat.o(41057);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(194106);
    this.CFv = paramBoolean1;
    this.CFd = paramBoolean2;
    if ((this.CFd) && (this.sHR != null)) {
      this.sHR.setVisibility(8);
    }
    this.CFe = paramBoolean3;
    this.CEE = paramInt;
    AppMethodBeat.o(194106);
  }
  
  public final void exs()
  {
    AppMethodBeat.i(41051);
    if (!this.jzt) {
      g(0, new HashMap());
    }
    this.jzt = true;
    AppMethodBeat.o(41051);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41050);
    super.onDetachedFromWindow();
    this.CFu.destroy();
    AppMethodBeat.o(41050);
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41052);
    this.CFu = new a();
    a.a(this.CFu);
    this.CFu.y(paramJSONArray);
    this.mrI = LayoutInflater.from(getContext()).inflate(g.f.Cnq, this, true);
    this.sHR = this.mrI.findViewById(g.e.Cjk);
    if (!this.CFd)
    {
      this.sHR.setVisibility(0);
      this.mrI.findViewById(g.e.CjT).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207474);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_game_haowan_text", true);
          ((Activity)k.this.getContext()).setResult(-1, paramAnonymousView);
          ((Activity)k.this.getContext()).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207474);
        }
      });
      this.CFr = new h(getContext(), 8762, this.CEE);
      this.CFr.setBackgroundColor(getResources().getColor(g.b.white));
      this.CFr.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(209406);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          if (k.a(k.this).Ty(paramAnonymousInt)) {
            k.b(k.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(209406);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(209407);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt1);
          localb.sg(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(209407);
        }
      });
      this.CFr.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
      {
        public final void S(View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(41046);
          paramAnonymousView = k.a(k.this).Tz(paramAnonymousInt);
          if ((paramAnonymousView.Crb) || (paramAnonymousView.Crc))
          {
            AppMethodBeat.o(41046);
            return;
          }
          k.a(k.this, paramAnonymousView);
          if (k.c(k.this))
          {
            localObject = new Bundle();
            ((Bundle)localObject).putBoolean("game_straight_to_publish", k.d(k.this));
            if (paramAnonymousView.fEF)
            {
              ((g)com.tencent.mm.kernel.h.ae(g.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, k.this.hashCode() & 0xFFFF, (Bundle)localObject, k.e(k.this));
              AppMethodBeat.o(41046);
              return;
            }
            ((g)com.tencent.mm.kernel.h.ae(g.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.Cre, k.this.hashCode() & 0xFFFF, (Bundle)localObject, k.e(k.this));
            AppMethodBeat.o(41046);
            return;
          }
          Object localObject = new Intent();
          f localf = new f();
          localf.Crj = k.f(k.this).CDW;
          paramAnonymousInt = localf.Crj.indexOf(paramAnonymousView);
          try
          {
            ((Intent)localObject).putExtra("game_video_list", localf.toByteArray());
            ((Intent)localObject).putExtra("game_video_list_current_index", paramAnonymousInt);
            ((Intent)localObject).putExtra("game_video_has_next", k.f(k.this).hasNext());
            ((Intent)localObject).putExtra("game_video_preview_source", p.a.CGH);
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
      eZ(this.CFr);
      this.Xd = LayoutInflater.from(getContext()).inflate(g.f.Cmh, this, false);
      this.Xd.setVisibility(8);
      eZ(this.Xd);
      this.CFs = a.exo();
      Log.d("MicroMsg.GameHaoWanGalleryView", "first enter : %b", new Object[] { Boolean.valueOf(this.CFs) });
      if (this.CFs)
      {
        this.CFt = LayoutInflater.from(getContext()).inflate(g.f.Cmi, this.CFr, false);
        ((ImageView)this.CFt.findViewById(g.e.game_icon_tips_close)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(41047);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            k.g(k.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41047);
          }
        });
        paramJSONArray = this.CFr;
        View localView = this.CFt;
        paramJSONArray.CEF.CEK.add(localView);
        g(503, null);
      }
      this.jkB = LayoutInflater.from(getContext()).inflate(g.f.Cmj, this, false);
      this.jkB.setVisibility(8);
      eZ(this.jkB);
      paramJSONArray = this.CFu.exg();
      if (!Util.isNullOrNil(paramJSONArray)) {
        break label406;
      }
      this.jkB.setVisibility(0);
    }
    for (;;)
    {
      getDataFromNet();
      AppMethodBeat.o(41052);
      return;
      this.sHR.setVisibility(8);
      break;
      label406:
      b(paramJSONArray, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.k
 * JD-Core Version:    0.7.0.1
 */