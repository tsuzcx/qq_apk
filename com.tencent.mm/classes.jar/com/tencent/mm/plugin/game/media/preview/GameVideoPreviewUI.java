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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.media.GameVideoTagContainer;
import com.tencent.mm.plugin.game.media.a.a;
import com.tencent.mm.plugin.game.media.p.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private int dbL;
  private RecyclerView fTr;
  RecyclerView.m fuK;
  private TextView fwQ;
  private View gDe;
  private GameVideoTagContainer sZG;
  private a tbN;
  private View tbO;
  private View tbP;
  private View tbQ;
  private int tbR;
  private c tbS;
  private boolean tbT;
  private TextView titleTv;
  
  public GameVideoPreviewUI()
  {
    AppMethodBeat.i(41264);
    this.tbR = 0;
    this.dbL = 0;
    this.tbT = true;
    this.fuK = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41236);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(41236);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41235);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousInt = ((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).jW();
          ac.i("MicroMsg.Haowan.GameVideoPreviewUI", "scroll position:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameVideoPreviewUI.c(GameVideoPreviewUI.this, paramAnonymousInt);
          paramAnonymousRecyclerView = ((GameVideoPreviewUI.a)paramAnonymousRecyclerView.getAdapter()).Gm(paramAnonymousInt);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousRecyclerView);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, paramAnonymousInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(41235);
      }
    };
    AppMethodBeat.o(41264);
  }
  
  private GameVideoView Gr(int paramInt)
  {
    AppMethodBeat.i(41272);
    Object localObject = this.fTr.ci(paramInt);
    if ((localObject instanceof GameVideoPreviewUI.a.a))
    {
      localObject = ((GameVideoPreviewUI.a.a)localObject).tcf;
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
    localHashMap.put("videoid", parame.sVF);
    localHashMap.put("origtime", Long.valueOf(parame.duration));
    localHashMap.put("origsize", Long.valueOf(parame.size));
    AppMethodBeat.o(41273);
    return localHashMap;
  }
  
  private int cPI()
  {
    int i = this.tbR + 1;
    if (i > 100) {
      return 100;
    }
    return i;
  }
  
  private void exit()
  {
    AppMethodBeat.i(41266);
    com.tencent.mm.game.report.b.a.a(this, 8768, 0, 4, com.tencent.mm.game.report.b.a.a(this.dbL, null));
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
        e locale = this.tbN.Gm(this.tbR);
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
      paramIntent = Gr(this.tbR);
      if (paramIntent != null)
      {
        if (paramIntent.tcs != null) {
          paramIntent.tcs.dyo = true;
        }
        paramInt1 = this.tbR;
        paramIntent = this.fTr.ci(paramInt1);
        if (!(paramIntent instanceof GameVideoPreviewUI.a.a)) {
          break label163;
        }
      }
    }
    label163:
    for (paramIntent = ((GameVideoPreviewUI.a.a)paramIntent).tcg;; paramIntent = null)
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
    if (this.gDe.getVisibility() == 0)
    {
      this.gDe.setVisibility(8);
      this.tbS.cPO();
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
    d.nX(true);
    getWindow().setFormat(-3);
    this.context = this;
    this.titleTv = ((TextView)findViewById(2131305948));
    this.fwQ = ((TextView)findViewById(2131302666));
    this.sZG = ((GameVideoTagContainer)findViewById(2131306397));
    this.tbO = findViewById(2131298378);
    this.tbP = findViewById(2131304747);
    this.tbQ = findViewById(2131298556);
    this.gDe = findViewById(2131301514);
    this.tbS = new c(this.context, this.gDe);
    this.fTr = ((RecyclerView)findViewById(2131300565));
    paramBundle = new LinearLayoutManager();
    paramBundle.setOrientation(0);
    this.fTr.setLayoutManager(paramBundle);
    new ak().j(this.fTr);
    this.fTr.a(this.fuK);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("game_video_list");
    this.tbR = getIntent().getIntExtra("game_video_list_current_index", 0);
    paramBundle = new LinkedList();
    com.tencent.mm.plugin.game.b.b.f localf;
    if (!bs.cv(arrayOfByte)) {
      localf = new com.tencent.mm.plugin.game.b.b.f();
    }
    try
    {
      localf.parseFrom(arrayOfByte);
      label284:
      paramBundle.addAll(localf.sVH);
      this.fTr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(41234);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, new GameVideoPreviewUI.a(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this).setAdapter(GameVideoPreviewUI.b(GameVideoPreviewUI.this));
          GameVideoPreviewUI.b(GameVideoPreviewUI.this).cK(paramBundle);
          Object localObject = ((GameVideoPreviewUI.a)GameVideoPreviewUI.a(GameVideoPreviewUI.this).getAdapter()).Gm(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          GameVideoPreviewUI.a(GameVideoPreviewUI.this, (e)localObject);
          localObject = GameVideoPreviewUI.a(GameVideoPreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(GameVideoPreviewUI.c(GameVideoPreviewUI.this), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.lR(0)).intValue());
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
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Gm(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
          if (paramAnonymousView != null)
          {
            Bundle localBundle = GameVideoPreviewUI.b(GameVideoPreviewUI.this, GameVideoPreviewUI.c(GameVideoPreviewUI.this));
            if (i.eA(paramAnonymousView.videoPath))
            {
              ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(GameVideoPreviewUI.d(GameVideoPreviewUI.this), GameVideoPreviewUI.e(GameVideoPreviewUI.this), paramAnonymousView.appId, paramAnonymousView.videoPath, null, null, 19722, localBundle);
              AppMethodBeat.o(41238);
              return;
            }
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(GameVideoPreviewUI.d(GameVideoPreviewUI.this), GameVideoPreviewUI.e(GameVideoPreviewUI.this), paramAnonymousView.appId, null, paramAnonymousView.videoUrl, paramAnonymousView.sVC, 19722, localBundle);
          }
          AppMethodBeat.o(41238);
        }
      });
      this.tbO.setOnClickListener(new View.OnClickListener()
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
      this.tbP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41241);
          paramAnonymousView = GameVideoPreviewUI.b(GameVideoPreviewUI.this).Gm(GameVideoPreviewUI.c(GameVideoPreviewUI.this));
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
      if ((p.a)getIntent().getSerializableExtra("game_video_preview_source") == p.a.tbw)
      {
        this.dbL = 7;
        this.tbP.setVisibility(8);
        this.tbQ.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.game.report.b.a.a(this, 8768, 0, 1, com.tencent.mm.game.report.b.a.a(this.dbL, null));
        AppMethodBeat.o(41265);
        return;
        this.dbL = 6;
        this.tbP.setVisibility(0);
        this.tbQ.setVisibility(8);
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
    this.fTr.b(this.fuK);
    GameVideoView localGameVideoView = Gr(this.tbR);
    if (localGameVideoView != null) {
      localGameVideoView.onUIDestroy();
    }
    this.tbS.cPO();
    com.tencent.mm.plugin.game.f.c.bUw().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41245);
        GameVideoView.cPL();
        AppMethodBeat.o(41245);
      }
    });
    AppMethodBeat.o(41270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41268);
    super.onPause();
    GameVideoView localGameVideoView = Gr(this.tbR);
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
    GameVideoView localGameVideoView = Gr(this.tbR);
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
    private ArrayList<e> tbY;
    
    public a()
    {
      AppMethodBeat.i(41255);
      this.tbY = new ArrayList();
      AppMethodBeat.o(41255);
    }
    
    public final e Gm(int paramInt)
    {
      AppMethodBeat.i(41257);
      if ((paramInt < this.tbY.size()) && (paramInt >= 0))
      {
        e locale = (e)this.tbY.get(paramInt);
        AppMethodBeat.o(41257);
        return locale;
      }
      AppMethodBeat.o(41257);
      return null;
    }
    
    public final void cK(List paramList)
    {
      AppMethodBeat.i(41256);
      if (bs.gY(paramList))
      {
        AppMethodBeat.o(41256);
        return;
      }
      this.tbY.addAll(paramList);
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41246);
          GameVideoPreviewUI.a.this.arg.notifyChanged();
          AppMethodBeat.o(41246);
        }
      }, 1000L);
      AppMethodBeat.o(41256);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(210285);
      int i = this.tbY.size();
      AppMethodBeat.o(210285);
      return i;
    }
    
    public final class a
      extends RecyclerView.w
    {
      public ProgressBar kWd;
      public View oXq;
      public GameVideoView tcf;
      public ImageView tcg;
      public ImageView tch;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(41254);
        this.oXq = paramView;
        this.tcf = ((GameVideoView)paramView.findViewById(2131306410));
        this.tcf.setVideoFooterView(new b(GameVideoPreviewUI.d(GameVideoPreviewUI.this)));
        this.tcg = ((ImageView)paramView.findViewById(2131305797));
        this.tch = ((ImageView)paramView.findViewById(2131306324));
        this.kWd = ((ProgressBar)paramView.findViewById(2131306352));
        AppMethodBeat.o(41254);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */