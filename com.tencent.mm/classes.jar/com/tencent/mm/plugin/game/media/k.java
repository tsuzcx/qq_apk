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
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class k
  extends FrameLayout
{
  private View EP;
  private View fzV;
  private boolean sZR;
  private h tae;
  private boolean taf;
  private View tah;
  private a tai;
  private boolean taj = true;
  e tak;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41056);
    cOS();
    if (!bs.gY(paramLinkedList))
    {
      cPw();
      if (this.taf)
      {
        ac.d("MicroMsg.GameHaoWanGalleryView", "data not null, appid : %d", new Object[] { ((e)paramLinkedList.get(0)).appId });
        a.cPj();
      }
    }
    for (;;)
    {
      this.tae.b(paramLinkedList, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(41056);
      return;
      biu();
      ((GamePublishGalleryUI)getContext()).cPv();
    }
  }
  
  private void biu()
  {
    AppMethodBeat.i(41054);
    this.EP.setVisibility(0);
    f(502, null);
    AppMethodBeat.o(41054);
  }
  
  private void cOS()
  {
    AppMethodBeat.i(41053);
    this.fzV.setVisibility(8);
    AppMethodBeat.o(41053);
  }
  
  static void cPq()
  {
    AppMethodBeat.i(41058);
    a.Gj(1);
    AppMethodBeat.o(41058);
  }
  
  private void cPw()
  {
    AppMethodBeat.i(41055);
    this.EP.setVisibility(8);
    AppMethodBeat.o(41055);
  }
  
  private void eg(View paramView)
  {
    AppMethodBeat.i(199209);
    View localView = LayoutInflater.from(getContext()).inflate(2131496276, this, true);
    localView.findViewById(2131307468).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199206);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_game_haowan_text", true);
        ((Activity)k.this.getContext()).setResult(-1, paramAnonymousView);
        ((Activity)k.this.getContext()).finish();
        AppMethodBeat.o(199206);
      }
    });
    ((ViewGroup)localView.findViewById(2131307466)).addView(paramView, -1, -1);
    AppMethodBeat.o(199209);
  }
  
  private static void f(int paramInt, Map paramMap)
  {
    AppMethodBeat.i(41059);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    com.tencent.mm.game.report.b.a.a(ai.getContext(), 8762, paramInt, 1, com.tencent.mm.game.report.b.a.a(7, (Map)localObject));
    AppMethodBeat.o(41059);
  }
  
  private void getDataFromNet()
  {
    AppMethodBeat.i(41057);
    System.currentTimeMillis();
    this.tai.b(new a.a()
    {
      public final void b(final LinkedList<e> paramAnonymousLinkedList, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(199208);
        if (((Activity)k.this.getContext()).isFinishing())
        {
          AppMethodBeat.o(199208);
          return;
        }
        k.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199207);
            k.a(k.this, paramAnonymousLinkedList, paramAnonymousBoolean);
            AppMethodBeat.o(199207);
          }
        });
        AppMethodBeat.o(199208);
      }
    });
    AppMethodBeat.o(41057);
  }
  
  public final void cPo()
  {
    AppMethodBeat.i(41051);
    if (!this.sZR) {
      f(0, new HashMap());
    }
    this.sZR = true;
    AppMethodBeat.o(41051);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(41050);
    super.onDetachedFromWindow();
    this.tai.destroy();
    AppMethodBeat.o(41050);
  }
  
  public final void setIgnoreVideoPreview(boolean paramBoolean)
  {
    this.taj = paramBoolean;
  }
  
  public final void setLocalAlbumInfos(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(41052);
    this.tai = new a();
    a.a(this.tai);
    this.tai.v(paramJSONArray);
    this.tae = new h(getContext(), 8762);
    this.tae.setBackgroundColor(getResources().getColor(2131101179));
    this.tae.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(199205);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(199205);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41045);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (k.a(k.this).Gl(paramAnonymousInt)) {
          k.b(k.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41045);
      }
    });
    this.tae.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b()
    {
      public final void R(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41046);
        paramAnonymousView = k.a(k.this).Gm(paramAnonymousInt);
        if ((paramAnonymousView.sVz) || (paramAnonymousView.sVA))
        {
          AppMethodBeat.o(41046);
          return;
        }
        k.a(k.this, paramAnonymousView);
        if (k.c(k.this))
        {
          if (paramAnonymousView.dqZ)
          {
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, paramAnonymousView.videoUrl, null, null, k.this.hashCode() & 0xFFFF, null);
            AppMethodBeat.o(41046);
            return;
          }
          ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(k.this.getContext(), 7, paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.sVC, k.this.hashCode() & 0xFFFF, null);
          AppMethodBeat.o(41046);
          return;
        }
        Intent localIntent = new Intent();
        com.tencent.mm.plugin.game.b.b.f localf = new com.tencent.mm.plugin.game.b.b.f();
        localf.sVH = k.d(k.this).sYM;
        paramAnonymousInt = localf.sVH.indexOf(paramAnonymousView);
        try
        {
          localIntent.putExtra("game_video_list", localf.toByteArray());
          localIntent.putExtra("game_video_list_current_index", paramAnonymousInt);
          localIntent.putExtra("game_video_has_next", k.d(k.this).hasNext());
          localIntent.putExtra("game_video_preview_source", p.a.tbw);
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
    eg(this.tae);
    this.EP = LayoutInflater.from(getContext()).inflate(2131494236, this, false);
    this.EP.setVisibility(8);
    eg(this.EP);
    this.taf = a.cPk();
    ac.d("MicroMsg.GameHaoWanGalleryView", "first enter : %b", new Object[] { Boolean.valueOf(this.taf) });
    if (this.taf)
    {
      this.tah = LayoutInflater.from(getContext()).inflate(2131494237, this.tae, false);
      ((ImageView)this.tah.findViewById(2131300464)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41047);
          k.e(k.this).setVisibility(8);
          AppMethodBeat.o(41047);
        }
      });
      paramJSONArray = this.tae;
      View localView = this.tah;
      paramJSONArray.sZt.sZy.add(localView);
      f(503, null);
    }
    this.fzV = LayoutInflater.from(getContext()).inflate(2131494238, this, false);
    this.fzV.setVisibility(8);
    eg(this.fzV);
    paramJSONArray = this.tai.cPc();
    if (bs.gY(paramJSONArray)) {
      this.fzV.setVisibility(0);
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