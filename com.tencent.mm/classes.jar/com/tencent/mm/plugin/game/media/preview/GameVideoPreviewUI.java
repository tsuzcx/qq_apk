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
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.ak;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.o;
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
  private int doj;
  RecyclerView.m fPN;
  private TextView fSj;
  private View gZB;
  private RecyclerView gpr;
  private TextView titleTv;
  private boolean uiK;
  private GameVideoTagContainer uix;
  private a ukF;
  private View ukG;
  private View ukH;
  private View ukI;
  private int ukJ;
  private c ukK;
  private boolean ukL;
  
  public GameVideoPreviewUI()
  {
    AppMethodBeat.i(41264);
    this.ukJ = 0;
    this.doj = 0;
    this.ukL = true;
    this.uiK = false;
    this.fPN = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41236);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(41236);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41235);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousInt = ((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).km();
          ae.i("MicroMsg.Haowan.GameVideoPreviewUI", "scroll position:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameVideoPreviewUI.c(GameVideoPreviewUI.this, paramAnonymousInt);
          paramAnonymousRecyclerView = ((GameVideoPreviewUI.a)paramAnonymousRecyclerView.getAdapter()).Id(paramAnonymousInt);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousRecyclerView);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41235);
      }
    };
    AppMethodBeat.o(41264);
  }
  
  private GameVideoView Ii(int paramInt)
  {
    AppMethodBeat.i(41272);
    Object localObject = this.gpr.ci(paramInt);
    if ((localObject instanceof GameVideoPreviewUI.a.a))
    {
      localObject = ((GameVideoPreviewUI.a.a)localObject).ukX;
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
    localHashMap.put("videoid", parame.udb);
    localHashMap.put("origtime", Long.valueOf(parame.duration));
    localHashMap.put("origsize", Long.valueOf(parame.size));
    AppMethodBeat.o(41273);
    return localHashMap;
  }
  
  private int daX()
  {
    int i = this.ukJ + 1;
    if (i > 100) {
      return 100;
    }
    return i;
  }
  
  private void exit()
  {
    AppMethodBeat.i(41266);
    com.tencent.mm.game.report.b.a.a(this, 8768, 0, 4, com.tencent.mm.game.report.b.a.b(this.doj, null));
    finish();
    AppMethodBeat.o(41266);
  }
  
  public int getLayoutId()
  {
    return 2131494400;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41271);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19722)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        e locale = this.ukF.Id(this.ukJ);
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
      paramIntent = Ii(this.ukJ);
      if (paramIntent != null)
      {
        if (paramIntent.ulk != null) {
          paramIntent.ulk.dLQ = true;
        }
        paramInt1 = this.ukJ;
        paramIntent = this.gpr.ci(paramInt1);
        if (!(paramIntent instanceof GameVideoPreviewUI.a.a)) {
          break label163;
        }
      }
    }
    label163:
    for (paramIntent = ((GameVideoPreviewUI.a.a)paramIntent).ukY;; paramIntent = null)
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
    if (this.gZB.getVisibility() == 0)
    {
      this.gZB.setVisibility(8);
      this.ukK.dbd();
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
    d.ow(true);
    getWindow().setFormat(-3);
    this.context = this;
    this.titleTv = ((TextView)findViewById(2131305948));
    this.fSj = ((TextView)findViewById(2131302666));
    this.uix = ((GameVideoTagContainer)findViewById(2131306397));
    this.ukG = findViewById(2131298378);
    this.ukH = findViewById(2131304747);
    this.ukI = findViewById(2131298556);
    this.gZB = findViewById(2131301514);
    this.ukK = new c(this.context, this.gZB);
    this.gpr = ((RecyclerView)findViewById(2131300565));
    paramBundle = new LinearLayoutManager();
    paramBundle.setOrientation(0);
    this.gpr.setLayoutManager(paramBundle);
    new ak().j(this.gpr);
    this.gpr.a(this.fPN);
    this.uiK = getIntent().getBooleanExtra("game_straight_to_publish", false);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("game_video_list");
    this.ukJ = getIntent().getIntExtra("game_video_list_current_index", 0);
    paramBundle = new LinkedList();
    com.tencent.mm.plugin.game.b.b.f localf;
    if (!bu.cF(arrayOfByte)) {
      localf = new com.tencent.mm.plugin.game.b.b.f();
    }
    try
    {
      localf.parseFrom(arrayOfByte);
      label299:
      paramBundle.addAll(localf.udd);
      this.gpr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(41234);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, new GameVideoPreviewUI.a(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).setAdapter(GameVideoPreviewUI.b(GameVideoPreviewUI.this));
          GameVideoPreviewUI.b(GameVideoPreviewUI.this).cO(paramBundle);
          Object localObject = ((GameVideoPreviewUI.a)GameVideoPreviewUI.a(GameVideoPreviewUI.this).getAdapter()).Id(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, (e)localObject);
          localObject = GameVideoPreviewUI.a(GameVideoPreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(GameVideoPreviewUI.c(GameVideoPreviewUI.this), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          AppMethodBeat.o(41234);
        }
      });
      findViewById(2131298556).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41238);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Id(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null)
          {
            localObject = GameVideoPreviewUI.b(GameVideoPreviewUI.this, GameVideoPreviewUI.c(GameVideoPreviewUI.this));
            ((Bundle)localObject).putBoolean("game_straight_to_publish", GameVideoPreviewUI.d(GameVideoPreviewUI.this));
            if (!o.fB(paramAnonymousView.videoPath)) {
              break label153;
            }
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(GameVideoPreviewUI.e(GameVideoPreviewUI.this), GameVideoPreviewUI.f(GameVideoPreviewUI.this), paramAnonymousView.appId, paramAnonymousView.videoPath, null, null, 19722, (Bundle)localObject);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41238);
            return;
            label153:
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(GameVideoPreviewUI.e(GameVideoPreviewUI.this), GameVideoPreviewUI.f(GameVideoPreviewUI.this), paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.ucY, 19722, (Bundle)localObject);
          }
        }
      });
      this.ukG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41240);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.e(GameVideoPreviewUI.this), 8768, 0, 2, com.tencent.mm.game.report.b.a.b(GameVideoPreviewUI.f(GameVideoPreviewUI.this), null));
          paramAnonymousView = LayoutInflater.from(GameVideoPreviewUI.this.getContext()).inflate(2131494277, null, false);
          localObject = new android.support.design.widget.a(GameVideoPreviewUI.this.getContext());
          ((android.support.design.widget.a)localObject).setContentView(paramAnonymousView);
          ((Button)paramAnonymousView.findViewById(2131300483)).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(41239);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              this.ujq.cancel();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(41239);
            }
          });
          ((android.support.design.widget.a)localObject).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(41240);
        }
      });
      this.ukH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41241);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Id(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null) {
            GameVideoPreviewUI.b(GameVideoPreviewUI.this, paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(41241);
        }
      });
      findViewById(2131300563).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41242);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          GameVideoPreviewUI.g(GameVideoPreviewUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(41242);
        }
      });
      if ((p.a)getIntent().getSerializableExtra("game_video_preview_source") == p.a.uko)
      {
        this.doj = 7;
        this.ukH.setVisibility(8);
        this.ukI.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.game.report.b.a.a(this, 8768, 0, 1, com.tencent.mm.game.report.b.a.b(this.doj, null));
        AppMethodBeat.o(41265);
        return;
        this.doj = 6;
        this.ukH.setVisibility(0);
        this.ukI.setVisibility(8);
      }
    }
    catch (IOException localIOException)
    {
      break label299;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41270);
    super.onDestroy();
    this.gpr.b(this.fPN);
    GameVideoView localGameVideoView = Ii(this.ukJ);
    if (localGameVideoView != null) {
      localGameVideoView.onUIDestroy();
    }
    this.ukK.dbd();
    com.tencent.mm.plugin.game.f.c.caq().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41245);
        GameVideoView.dba();
        AppMethodBeat.o(41245);
      }
    });
    AppMethodBeat.o(41270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41268);
    super.onPause();
    GameVideoView localGameVideoView = Ii(this.ukJ);
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
    GameVideoView localGameVideoView = Ii(this.ukJ);
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
    private ArrayList<e> ukQ;
    
    public a()
    {
      AppMethodBeat.i(41255);
      this.ukQ = new ArrayList();
      AppMethodBeat.o(41255);
    }
    
    public final e Id(int paramInt)
    {
      AppMethodBeat.i(41257);
      if ((paramInt < this.ukQ.size()) && (paramInt >= 0))
      {
        e locale = (e)this.ukQ.get(paramInt);
        AppMethodBeat.o(41257);
        return locale;
      }
      AppMethodBeat.o(41257);
      return null;
    }
    
    public final void cO(List paramList)
    {
      AppMethodBeat.i(41256);
      if (bu.ht(paramList))
      {
        AppMethodBeat.o(41256);
        return;
      }
      this.ukQ.addAll(paramList);
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41246);
          GameVideoPreviewUI.a.this.asY.notifyChanged();
          AppMethodBeat.o(41246);
        }
      }, 1000L);
      AppMethodBeat.o(41256);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(224258);
      int i = this.ukQ.size();
      AppMethodBeat.o(224258);
      return i;
    }
    
    public final class a
      extends RecyclerView.w
    {
      public ProgressBar lxB;
      public View pHE;
      public GameVideoView ukX;
      public ImageView ukY;
      public ImageView ukZ;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(41254);
        this.pHE = paramView;
        this.ukX = ((GameVideoView)paramView.findViewById(2131306410));
        this.ukX.setVideoFooterView(new b(GameVideoPreviewUI.e(GameVideoPreviewUI.this)));
        this.ukY = ((ImageView)paramView.findViewById(2131305797));
        this.ukZ = ((ImageView)paramView.findViewById(2131306324));
        this.lxB = ((ProgressBar)paramView.findViewById(2131306352));
        AppMethodBeat.o(41254);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */