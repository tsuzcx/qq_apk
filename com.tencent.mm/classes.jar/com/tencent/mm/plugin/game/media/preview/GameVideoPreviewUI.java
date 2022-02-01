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
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.media.GameVideoTagContainer;
import com.tencent.mm.plugin.game.media.a.a;
import com.tencent.mm.plugin.game.media.p.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.i;
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
  private int dep;
  private RecyclerView fPw;
  RecyclerView.m frd;
  private TextView ftj;
  private View lZo;
  private GameVideoTagContainer rRQ;
  private a rTV;
  private View rTW;
  private View rTX;
  private View rTY;
  private int rTZ;
  private c rUa;
  private boolean rUb;
  private TextView titleTv;
  
  public GameVideoPreviewUI()
  {
    AppMethodBeat.i(41264);
    this.rTZ = 0;
    this.dep = 0;
    this.rUb = true;
    this.frd = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41236);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(41236);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41235);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousInt = ((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).jO();
          ad.i("MicroMsg.Haowan.GameVideoPreviewUI", "scroll position:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameVideoPreviewUI.c(GameVideoPreviewUI.this, paramAnonymousInt);
          paramAnonymousRecyclerView = ((GameVideoPreviewUI.a)paramAnonymousRecyclerView.getAdapter()).Eq(paramAnonymousInt);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousRecyclerView);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41235);
      }
    };
    AppMethodBeat.o(41264);
  }
  
  private GameVideoView Ev(int paramInt)
  {
    AppMethodBeat.i(41272);
    Object localObject = this.fPw.cj(paramInt);
    if ((localObject instanceof GameVideoPreviewUI.a.a))
    {
      localObject = ((GameVideoPreviewUI.a.a)localObject).rUn;
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
    localHashMap.put("videoid", parame.rNP);
    localHashMap.put("origtime", Long.valueOf(parame.duration));
    localHashMap.put("origsize", Long.valueOf(parame.size));
    AppMethodBeat.o(41273);
    return localHashMap;
  }
  
  private int cCx()
  {
    int i = this.rTZ + 1;
    if (i > 100) {
      return 100;
    }
    return i;
  }
  
  private void exit()
  {
    AppMethodBeat.i(41266);
    com.tencent.mm.game.report.b.a.a(this, 8768, 0, 4, com.tencent.mm.game.report.b.a.a(this.dep, null));
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
        e locale = this.rTV.Eq(this.rTZ);
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
      paramIntent = Ev(this.rTZ);
      if (paramIntent != null)
      {
        if (paramIntent.rUA != null) {
          paramIntent.rUA.dAC = true;
        }
        paramInt1 = this.rTZ;
        paramIntent = this.fPw.cj(paramInt1);
        if (!(paramIntent instanceof GameVideoPreviewUI.a.a)) {
          break label163;
        }
      }
    }
    label163:
    for (paramIntent = ((GameVideoPreviewUI.a.a)paramIntent).rUo;; paramIntent = null)
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
    if (this.lZo.getVisibility() == 0)
    {
      this.lZo.setVisibility(8);
      this.rUa.cCE();
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
    d.ne(true);
    getWindow().setFormat(-3);
    this.context = this;
    this.titleTv = ((TextView)findViewById(2131305948));
    this.ftj = ((TextView)findViewById(2131302666));
    this.rRQ = ((GameVideoTagContainer)findViewById(2131306397));
    this.rTW = findViewById(2131298378);
    this.rTX = findViewById(2131304747);
    this.rTY = findViewById(2131298556);
    this.lZo = findViewById(2131301514);
    this.rUa = new c(this.context, this.lZo);
    this.fPw = ((RecyclerView)findViewById(2131300565));
    paramBundle = new LinearLayoutManager();
    paramBundle.setOrientation(0);
    this.fPw.setLayoutManager(paramBundle);
    new ak().j(this.fPw);
    this.fPw.a(this.frd);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("game_video_list");
    this.rTZ = getIntent().getIntExtra("game_video_list_current_index", 0);
    paramBundle = new LinkedList();
    com.tencent.mm.plugin.game.b.b.f localf;
    if (!bt.cw(arrayOfByte)) {
      localf = new com.tencent.mm.plugin.game.b.b.f();
    }
    try
    {
      localf.parseFrom(arrayOfByte);
      label284:
      paramBundle.addAll(localf.rNQ);
      this.fPw.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(41234);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, new GameVideoPreviewUI.a(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).setAdapter(GameVideoPreviewUI.b(GameVideoPreviewUI.this));
          GameVideoPreviewUI.b(GameVideoPreviewUI.this).cI(paramBundle);
          Object localObject = ((GameVideoPreviewUI.a)GameVideoPreviewUI.a(GameVideoPreviewUI.this).getAdapter()).Eq(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, (e)localObject);
          localObject = GameVideoPreviewUI.a(GameVideoPreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(GameVideoPreviewUI.c(GameVideoPreviewUI.this), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.lS(0)).intValue());
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
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Eq(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null)
          {
            Bundle localBundle = GameVideoPreviewUI.b(GameVideoPreviewUI.this, GameVideoPreviewUI.c(GameVideoPreviewUI.this));
            if (i.eK(paramAnonymousView.videoPath))
            {
              ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(GameVideoPreviewUI.d(GameVideoPreviewUI.this), GameVideoPreviewUI.e(GameVideoPreviewUI.this), paramAnonymousView.appId, paramAnonymousView.videoPath, null, null, 19722, localBundle);
              AppMethodBeat.o(41238);
              return;
            }
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(GameVideoPreviewUI.d(GameVideoPreviewUI.this), GameVideoPreviewUI.e(GameVideoPreviewUI.this), paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.rNM, 19722, localBundle);
          }
          AppMethodBeat.o(41238);
        }
      });
      this.rTW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41240);
          com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.d(GameVideoPreviewUI.this), 8768, 0, 2, com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.e(GameVideoPreviewUI.this), null));
          paramAnonymousView = LayoutInflater.from(GameVideoPreviewUI.this.getContext()).inflate(2131494277, null, false);
          final android.support.design.widget.a locala = new android.support.design.widget.a(GameVideoPreviewUI.this.getContext());
          locala.setContentView(paramAnonymousView);
          ((Button)paramAnonymousView.findViewById(2131300483)).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(41239);
              locala.cancel();
              AppMethodBeat.o(41239);
            }
          });
          locala.show();
          AppMethodBeat.o(41240);
        }
      });
      this.rTX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41241);
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Eq(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null) {
            GameVideoPreviewUI.b(GameVideoPreviewUI.this, paramAnonymousView);
          }
          AppMethodBeat.o(41241);
        }
      });
      findViewById(2131300563).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41242);
          GameVideoPreviewUI.f(GameVideoPreviewUI.this);
          AppMethodBeat.o(41242);
        }
      });
      if ((p.a)getIntent().getSerializableExtra("game_video_preview_source") == p.a.rTE)
      {
        this.dep = 7;
        this.rTX.setVisibility(8);
        this.rTY.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.game.report.b.a.a(this, 8768, 0, 1, com.tencent.mm.game.report.b.a.a(this.dep, null));
        AppMethodBeat.o(41265);
        return;
        this.dep = 6;
        this.rTX.setVisibility(0);
        this.rTY.setVisibility(8);
      }
    }
    catch (IOException localIOException)
    {
      break label284;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41270);
    super.onDestroy();
    this.fPw.b(this.frd);
    GameVideoView localGameVideoView = Ev(this.rTZ);
    if (localGameVideoView != null) {
      localGameVideoView.onUIDestroy();
    }
    this.rUa.cCE();
    com.tencent.mm.plugin.game.f.c.bNl().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41245);
        GameVideoView.cCA();
        AppMethodBeat.o(41245);
      }
    });
    AppMethodBeat.o(41270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41268);
    super.onPause();
    GameVideoView localGameVideoView = Ev(this.rTZ);
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
    GameVideoView localGameVideoView = Ev(this.rTZ);
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
    private ArrayList<e> rUg;
    
    public a()
    {
      AppMethodBeat.i(41255);
      this.rUg = new ArrayList();
      AppMethodBeat.o(41255);
    }
    
    public final e Eq(int paramInt)
    {
      AppMethodBeat.i(41257);
      if ((paramInt < this.rUg.size()) && (paramInt >= 0))
      {
        e locale = (e)this.rUg.get(paramInt);
        AppMethodBeat.o(41257);
        return locale;
      }
      AppMethodBeat.o(41257);
      return null;
    }
    
    public final void cI(List paramList)
    {
      AppMethodBeat.i(41256);
      if (bt.gL(paramList))
      {
        AppMethodBeat.o(41256);
        return;
      }
      this.rUg.addAll(paramList);
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41246);
          GameVideoPreviewUI.a.this.aql.notifyChanged();
          AppMethodBeat.o(41246);
        }
      }, 1000L);
      AppMethodBeat.o(41256);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(204998);
      int i = this.rUg.size();
      AppMethodBeat.o(204998);
      return i;
    }
    
    public final class a
      extends RecyclerView.v
    {
      public ProgressBar kuP;
      public View otP;
      public GameVideoView rUn;
      public ImageView rUo;
      public ImageView rUp;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(41254);
        this.otP = paramView;
        this.rUn = ((GameVideoView)paramView.findViewById(2131306410));
        this.rUn.setVideoFooterView(new b(GameVideoPreviewUI.d(GameVideoPreviewUI.this)));
        this.rUo = ((ImageView)paramView.findViewById(2131305797));
        this.rUp = ((ImageView)paramView.findViewById(2131306324));
        this.kuP = ((ProgressBar)paramView.findViewById(2131306352));
        AppMethodBeat.o(41254);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */