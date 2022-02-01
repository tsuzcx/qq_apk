package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.media.GameVideoTagContainer;
import com.tencent.mm.plugin.game.media.a.a;
import com.tencent.mm.plugin.game.media.q.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.vfs.y;
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
  private int Hpw;
  private a IBj;
  private View IBk;
  private View IBl;
  private View IBm;
  private c IBn;
  private boolean IBo;
  private int IyH;
  private GameVideoTagContainer IyV;
  private boolean Izi;
  private Context context;
  RecyclerView.l lBe;
  private TextView lDF;
  private RecyclerView mkw;
  private View njN;
  private int source;
  private TextView titleTv;
  
  public GameVideoPreviewUI()
  {
    AppMethodBeat.i(41264);
    this.Hpw = 0;
    this.source = 0;
    this.IBo = true;
    this.Izi = false;
    this.IyH = 0;
    this.lBe = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(276868);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousInt = ((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).Ju();
          Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "scroll position:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameVideoPreviewUI.c(GameVideoPreviewUI.this, paramAnonymousInt);
          paramAnonymousRecyclerView = ((GameVideoPreviewUI.a)paramAnonymousRecyclerView.getAdapter()).Xt(paramAnonymousInt);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousRecyclerView);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(276868);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(276869);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(276869);
      }
    };
    AppMethodBeat.o(41264);
  }
  
  private GameVideoView Xw(int paramInt)
  {
    AppMethodBeat.i(41272);
    Object localObject = this.mkw.fU(paramInt);
    if ((localObject instanceof GameVideoPreviewUI.a.a))
    {
      localObject = ((GameVideoPreviewUI.a.a)localObject).IBA;
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
    localHashMap.put("videoid", parame.Ido);
    localHashMap.put("origtime", Long.valueOf(parame.duration));
    localHashMap.put("origsize", Long.valueOf(parame.size));
    AppMethodBeat.o(41273);
    return localHashMap;
  }
  
  private void exit()
  {
    AppMethodBeat.i(41266);
    com.tencent.mm.game.report.b.a.a(this, 8768, 0, 4, this.IyH, com.tencent.mm.game.report.b.a.a(this.source, null));
    finish();
    AppMethodBeat.o(41266);
  }
  
  private int fFH()
  {
    int i = this.Hpw + 1;
    if (i > 100) {
      return 100;
    }
    return i;
  }
  
  public int getLayoutId()
  {
    return h.f.Iat;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41271);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19722)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        e locale = this.IBj.Xt(this.Hpw);
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
      paramIntent = Xw(this.Hpw);
      if (paramIntent != null)
      {
        if (paramIntent.IBN != null) {
          paramIntent.IBN.idO = true;
        }
        paramInt1 = this.Hpw;
        paramIntent = this.mkw.fU(paramInt1);
        if (!(paramIntent instanceof GameVideoPreviewUI.a.a)) {
          break label163;
        }
      }
    }
    label163:
    for (paramIntent = ((GameVideoPreviewUI.a.a)paramIntent).IBB;; paramIntent = null)
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
    if (this.njN.getVisibility() == 0)
    {
      this.njN.setVisibility(8);
      this.IBn.fFN();
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
    d.ys(true);
    getWindow().setFormat(-3);
    this.context = this;
    this.titleTv = ((TextView)findViewById(h.e.title_tv));
    this.lDF = ((TextView)findViewById(h.e.name_tv));
    this.IyV = ((GameVideoTagContainer)findViewById(h.e.HYk));
    this.IBk = findViewById(h.e.HTI);
    this.IBl = findViewById(h.e.HXJ);
    this.IBm = findViewById(h.e.confirm_btn);
    this.njN = findViewById(h.e.loading_view);
    this.IBn = new c(this.context, this.njN);
    this.mkw = ((RecyclerView)findViewById(h.e.HWI));
    paramBundle = new LinearLayoutManager();
    paramBundle.setOrientation(0);
    this.mkw.setLayoutManager(paramBundle);
    new t().a(this.mkw);
    this.mkw.a(this.lBe);
    this.Izi = getIntent().getBooleanExtra("game_straight_to_publish", false);
    this.IyH = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("game_video_list");
    this.Hpw = getIntent().getIntExtra("game_video_list_current_index", 0);
    paramBundle = new LinkedList();
    com.tencent.mm.plugin.game.autogen.b.f localf;
    if (!Util.isNullOrNil(arrayOfByte)) {
      localf = new com.tencent.mm.plugin.game.autogen.b.f();
    }
    try
    {
      localf.parseFrom(arrayOfByte);
      label314:
      paramBundle.addAll(localf.Idq);
      this.mkw.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(41234);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, new GameVideoPreviewUI.a(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).setAdapter(GameVideoPreviewUI.b(GameVideoPreviewUI.this));
          GameVideoPreviewUI.b(GameVideoPreviewUI.this).eX(paramBundle);
          Object localObject = ((GameVideoPreviewUI.a)GameVideoPreviewUI.a(GameVideoPreviewUI.this).getAdapter()).Xt(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, (e)localObject);
          localObject = GameVideoPreviewUI.a(GameVideoPreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(GameVideoPreviewUI.c(GameVideoPreviewUI.this), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          AppMethodBeat.o(41234);
        }
      });
      findViewById(h.e.confirm_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41238);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Xt(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null)
          {
            localObject = GameVideoPreviewUI.b(GameVideoPreviewUI.this, GameVideoPreviewUI.c(GameVideoPreviewUI.this));
            ((Bundle)localObject).putBoolean("game_straight_to_publish", GameVideoPreviewUI.d(GameVideoPreviewUI.this));
            if (!y.ZC(paramAnonymousView.videoPath)) {
              break label160;
            }
            ((com.tencent.mm.plugin.game.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.h.class)).a(GameVideoPreviewUI.e(GameVideoPreviewUI.this), GameVideoPreviewUI.f(GameVideoPreviewUI.this), paramAnonymousView.appId, paramAnonymousView.videoPath, null, null, 19722, (Bundle)localObject, GameVideoPreviewUI.g(GameVideoPreviewUI.this));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41238);
            return;
            label160:
            ((com.tencent.mm.plugin.game.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.h.class)).a(GameVideoPreviewUI.e(GameVideoPreviewUI.this), GameVideoPreviewUI.f(GameVideoPreviewUI.this), paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.Idm, 19722, (Bundle)localObject, GameVideoPreviewUI.g(GameVideoPreviewUI.this));
          }
        }
      });
      this.IBk.setOnClickListener(new GameVideoPreviewUI.5(this));
      this.IBl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41241);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Xt(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null) {
            GameVideoPreviewUI.b(GameVideoPreviewUI.this, paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(41241);
        }
      });
      findViewById(h.e.HWG).setOnClickListener(new GameVideoPreviewUI.7(this));
      if ((q.a)getIntent().getSerializableExtra("game_video_preview_source") == q.a.IAR)
      {
        this.source = 7;
        this.IBl.setVisibility(8);
        this.IBm.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.game.report.b.a.a(this, 8768, 0, 1, this.IyH, com.tencent.mm.game.report.b.a.a(this.source, null));
        AppMethodBeat.o(41265);
        return;
        this.source = 6;
        this.IBl.setVisibility(0);
        this.IBm.setVisibility(8);
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
    this.mkw.b(this.lBe);
    GameVideoView localGameVideoView = Xw(this.Hpw);
    if (localGameVideoView != null) {
      localGameVideoView.onUIDestroy();
    }
    this.IBn.fFN();
    com.tencent.mm.plugin.game.d.c.dqg().postToWorker(new GameVideoPreviewUI.11(this));
    AppMethodBeat.o(41270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41268);
    super.onPause();
    GameVideoView localGameVideoView = Xw(this.Hpw);
    if (localGameVideoView != null) {
      localGameVideoView.onUIPause();
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(41268);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41267);
    super.onResume();
    GameVideoView localGameVideoView = Xw(this.Hpw);
    if (localGameVideoView != null) {
      localGameVideoView.onUIResume();
    }
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
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
    private ArrayList<e> IBt;
    
    public a()
    {
      AppMethodBeat.i(41255);
      this.IBt = new ArrayList();
      AppMethodBeat.o(41255);
    }
    
    public final e Xt(int paramInt)
    {
      AppMethodBeat.i(41257);
      if ((paramInt < this.IBt.size()) && (paramInt >= 0))
      {
        e locale = (e)this.IBt.get(paramInt);
        AppMethodBeat.o(41257);
        return locale;
      }
      AppMethodBeat.o(41257);
      return null;
    }
    
    public final void eX(List paramList)
    {
      AppMethodBeat.i(41256);
      if (Util.isNullOrNil(paramList))
      {
        AppMethodBeat.o(41256);
        return;
      }
      this.IBt.addAll(paramList);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41246);
          GameVideoPreviewUI.a.this.bZE.notifyChanged();
          AppMethodBeat.o(41246);
        }
      }, 1000L);
      AppMethodBeat.o(41256);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(369756);
      int i = this.IBt.size();
      AppMethodBeat.o(369756);
      return i;
    }
    
    public final class a
      extends RecyclerView.v
    {
      public GameVideoView IBA;
      public ImageView IBB;
      public ImageView IBC;
      public ProgressBar sIX;
      public View xGH;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(41254);
        this.xGH = paramView;
        this.IBA = ((GameVideoView)paramView.findViewById(h.e.video_view));
        this.IBA.setVideoFooterView(new b(GameVideoPreviewUI.e(GameVideoPreviewUI.this)));
        this.IBB = ((ImageView)paramView.findViewById(h.e.thumb_img));
        this.IBC = ((ImageView)paramView.findViewById(h.e.HYe));
        this.sIX = ((ProgressBar)paramView.findViewById(h.e.video_loading));
        AppMethodBeat.o(41254);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */