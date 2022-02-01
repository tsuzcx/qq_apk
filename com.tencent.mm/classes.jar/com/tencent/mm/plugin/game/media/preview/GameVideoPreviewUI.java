package com.tencent.mm.plugin.game.media.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ak;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.media.GameVideoTagContainer;
import com.tencent.mm.plugin.game.media.a.a;
import com.tencent.mm.plugin.game.media.p.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class GameVideoPreviewUI
  extends MMActivity
{
  private Context context;
  RecyclerView.l guX;
  private TextView gxs;
  private View hSw;
  private RecyclerView hak;
  private int source;
  private TextView titleTv;
  private int xAD;
  private GameVideoTagContainer xAR;
  private boolean xBd;
  private a xCY;
  private View xCZ;
  private View xDa;
  private View xDb;
  private int xDc;
  private c xDd;
  private boolean xDe;
  
  public GameVideoPreviewUI()
  {
    AppMethodBeat.i(41264);
    this.xDc = 0;
    this.source = 0;
    this.xDe = true;
    this.xBd = false;
    this.xAD = 0;
    this.guX = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41235);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousInt = ((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).ks();
          Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "scroll position:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameVideoPreviewUI.c(GameVideoPreviewUI.this, paramAnonymousInt);
          paramAnonymousRecyclerView = ((GameVideoPreviewUI.a)paramAnonymousRecyclerView.getAdapter()).Og(paramAnonymousInt);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousRecyclerView);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41235);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41236);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(41236);
      }
    };
    AppMethodBeat.o(41264);
  }
  
  private GameVideoView Oj(int paramInt)
  {
    AppMethodBeat.i(41272);
    Object localObject = this.hak.ch(paramInt);
    if ((localObject instanceof GameVideoPreviewUI.a.a))
    {
      localObject = ((GameVideoPreviewUI.a.a)localObject).xDq;
      AppMethodBeat.o(41272);
      return localObject;
    }
    AppMethodBeat.o(41272);
    return null;
  }
  
  private static Map a(e parame)
  {
    AppMethodBeat.i(41273);
    HashMap localHashMap = new HashMap();
    if (parame == null)
    {
      AppMethodBeat.o(41273);
      return localHashMap;
    }
    localHashMap.put("videoid", parame.psI);
    localHashMap.put("origtime", Long.valueOf(parame.duration));
    localHashMap.put("origsize", Long.valueOf(parame.size));
    AppMethodBeat.o(41273);
    return localHashMap;
  }
  
  private int dUE()
  {
    int i = this.xDc + 1;
    if (i > 100) {
      return 100;
    }
    return i;
  }
  
  private void exit()
  {
    AppMethodBeat.i(41266);
    com.tencent.mm.game.report.b.a.a(this, 8768, 0, 4, this.xAD, com.tencent.mm.game.report.b.a.c(this.source, null));
    finish();
    AppMethodBeat.o(41266);
  }
  
  public int getLayoutId()
  {
    return 2131494966;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41271);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19722)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        e locale = this.xCY.Og(this.xDc);
        if (locale != null)
        {
          paramIntent.putExtra("key_game_video_appid", locale.appId);
          paramIntent.putExtra("key_game_video_appname", locale.appName);
        }
        setResult(paramInt2, paramIntent);
        finish();
        AppMethodBeat.o(41271);
        return;
      }
      paramIntent = Oj(this.xDc);
      if (paramIntent != null)
      {
        if (paramIntent.xDC != null) {
          paramIntent.xDC.edF = true;
        }
        paramInt1 = this.xDc;
        paramIntent = this.hak.ch(paramInt1);
        if (!(paramIntent instanceof GameVideoPreviewUI.a.a)) {
          break label163;
        }
      }
    }
    label163:
    for (paramIntent = ((GameVideoPreviewUI.a.a)paramIntent).xDr;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.setVisibility(0);
      }
      AppMethodBeat.o(41271);
      return;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(41269);
    if (this.hSw.getVisibility() == 0)
    {
      this.hSw.setVisibility(8);
      this.xDd.dUK();
      AppMethodBeat.o(41269);
      return;
    }
    super.onBackPressed();
    exit();
    AppMethodBeat.o(41269);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(41265);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.rb(true);
    getWindow().setFormat(-3);
    this.context = this;
    this.titleTv = ((TextView)findViewById(2131309249));
    this.gxs = ((TextView)findViewById(2131305220));
    this.xAR = ((GameVideoTagContainer)findViewById(2131309828));
    this.xCZ = findViewById(2131298787);
    this.xDa = findViewById(2131307813);
    this.xDb = findViewById(2131298990);
    this.hSw = findViewById(2131303719);
    this.xDd = new c(this.context, this.hSw);
    this.hak = ((RecyclerView)findViewById(2131302097));
    paramBundle = new LinearLayoutManager();
    paramBundle.setOrientation(0);
    this.hak.setLayoutManager(paramBundle);
    new ak().f(this.hak);
    this.hak.a(this.guX);
    this.xBd = getIntent().getBooleanExtra("game_straight_to_publish", false);
    this.xAD = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("game_video_list");
    this.xDc = getIntent().getIntExtra("game_video_list_current_index", 0);
    paramBundle = new LinkedList();
    com.tencent.mm.plugin.game.b.b.f localf;
    if (!Util.isNullOrNil(arrayOfByte)) {
      localf = new com.tencent.mm.plugin.game.b.b.f();
    }
    try
    {
      localf.parseFrom(arrayOfByte);
      label314:
      paramBundle.addAll(localf.xuQ);
      this.hak.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(41234);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, new GameVideoPreviewUI.a(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).setAdapter(GameVideoPreviewUI.b(GameVideoPreviewUI.this));
          GameVideoPreviewUI.b(GameVideoPreviewUI.this).dd(paramBundle);
          Object localObject = ((GameVideoPreviewUI.a)GameVideoPreviewUI.a(GameVideoPreviewUI.this).getAdapter()).Og(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, (e)localObject);
          localObject = GameVideoPreviewUI.a(GameVideoPreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(GameVideoPreviewUI.c(GameVideoPreviewUI.this), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          AppMethodBeat.o(41234);
        }
      });
      findViewById(2131298990).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41238);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Og(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null)
          {
            localObject = GameVideoPreviewUI.b(GameVideoPreviewUI.this, GameVideoPreviewUI.c(GameVideoPreviewUI.this));
            ((Bundle)localObject).putBoolean("game_straight_to_publish", GameVideoPreviewUI.d(GameVideoPreviewUI.this));
            if (!s.YS(paramAnonymousView.videoPath)) {
              break label160;
            }
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.g.class)).a(GameVideoPreviewUI.e(GameVideoPreviewUI.this), GameVideoPreviewUI.f(GameVideoPreviewUI.this), paramAnonymousView.appId, paramAnonymousView.videoPath, null, null, 19722, (Bundle)localObject, GameVideoPreviewUI.g(GameVideoPreviewUI.this));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41238);
            return;
            label160:
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.g.class)).a(GameVideoPreviewUI.e(GameVideoPreviewUI.this), GameVideoPreviewUI.f(GameVideoPreviewUI.this), paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.xuM, 19722, (Bundle)localObject, GameVideoPreviewUI.g(GameVideoPreviewUI.this));
          }
        }
      });
      this.xCZ.setOnClickListener(new GameVideoPreviewUI.5(this));
      this.xDa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41241);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Og(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null) {
            GameVideoPreviewUI.b(GameVideoPreviewUI.this, paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(41241);
        }
      });
      findViewById(2131302095).setOnClickListener(new GameVideoPreviewUI.7(this));
      if ((p.a)getIntent().getSerializableExtra("game_video_preview_source") == p.a.xCH)
      {
        this.source = 7;
        this.xDa.setVisibility(8);
        this.xDb.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.game.report.b.a.a(this, 8768, 0, 1, this.xAD, com.tencent.mm.game.report.b.a.c(this.source, null));
        AppMethodBeat.o(41265);
        return;
        this.source = 6;
        this.xDa.setVisibility(0);
        this.xDb.setVisibility(8);
      }
    }
    catch (IOException localIOException)
    {
      break label314;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41270);
    super.onDestroy();
    this.hak.b(this.guX);
    GameVideoView localGameVideoView = Oj(this.xDc);
    if (localGameVideoView != null) {
      localGameVideoView.onUIDestroy();
    }
    this.xDd.dUK();
    com.tencent.mm.plugin.game.e.c.cyh().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41245);
        GameVideoView.dUH();
        AppMethodBeat.o(41245);
      }
    });
    AppMethodBeat.o(41270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41268);
    super.onPause();
    GameVideoView localGameVideoView = Oj(this.xDc);
    if (localGameVideoView != null) {
      localGameVideoView.onUIPause();
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(41268);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41267);
    super.onResume();
    GameVideoView localGameVideoView = Oj(this.xDc);
    if (localGameVideoView != null) {
      localGameVideoView.onUIResume();
    }
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(41267);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends RecyclerView.a<a>
  {
    private ArrayList<e> xDj;
    
    public a()
    {
      AppMethodBeat.i(41255);
      this.xDj = new ArrayList();
      AppMethodBeat.o(41255);
    }
    
    public final e Og(int paramInt)
    {
      AppMethodBeat.i(41257);
      if ((paramInt < this.xDj.size()) && (paramInt >= 0))
      {
        e locale = (e)this.xDj.get(paramInt);
        AppMethodBeat.o(41257);
        return locale;
      }
      AppMethodBeat.o(41257);
      return null;
    }
    
    public final void dd(List paramList)
    {
      AppMethodBeat.i(41256);
      if (Util.isNullOrNil(paramList))
      {
        AppMethodBeat.o(41256);
        return;
      }
      this.xDj.addAll(paramList);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41246);
          GameVideoPreviewUI.a.this.atj.notifyChanged();
          AppMethodBeat.o(41246);
        }
      }, 1000L);
      AppMethodBeat.o(41256);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(258687);
      int i = this.xDj.size();
      AppMethodBeat.o(258687);
      return i;
    }
    
    public final class a
      extends RecyclerView.v
    {
      public ProgressBar mEz;
      public View qXq;
      public GameVideoView xDq;
      public ImageView xDr;
      public ImageView xDs;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(41254);
        this.qXq = paramView;
        this.xDq = ((GameVideoView)paramView.findViewById(2131309841));
        this.xDq.setVideoFooterView(new b(GameVideoPreviewUI.e(GameVideoPreviewUI.this)));
        this.xDr = ((ImageView)paramView.findViewById(2131309072));
        this.xDs = ((ImageView)paramView.findViewById(2131309745));
        this.mEz = ((ProgressBar)paramView.findViewById(2131309778));
        AppMethodBeat.o(41254);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */