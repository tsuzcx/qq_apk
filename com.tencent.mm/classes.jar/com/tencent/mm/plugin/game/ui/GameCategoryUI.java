package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private View fwo;
  private Dialog lIc;
  private int mType;
  private int rXI;
  private int rXN;
  private k sfi;
  private ListView sfp;
  private l sfq;
  private boolean sfr;
  private boolean sfs;
  private int sft;
  private String sfu;
  private m.a sfv;
  private AbsListView.OnScrollListener sfw;
  
  public GameCategoryUI()
  {
    AppMethodBeat.i(41918);
    this.sfr = false;
    this.rXN = 0;
    this.sfs = false;
    this.rXI = 0;
    this.sfi = new k();
    this.sfv = new m.a()
    {
      public final void EE(int paramAnonymousInt)
      {
        AppMethodBeat.i(41914);
        int i = GameCategoryUI.b(GameCategoryUI.this).getFirstVisiblePosition();
        int j = GameCategoryUI.b(GameCategoryUI.this).getLastVisiblePosition();
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j))
        {
          View localView = GameCategoryUI.b(GameCategoryUI.this).getChildAt(paramAnonymousInt - i);
          GameCategoryUI.c(GameCategoryUI.this).af(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(41914);
      }
    };
    this.sfw = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41915);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
        {
          if ((!GameCategoryUI.d(GameCategoryUI.this)) || (GameCategoryUI.e(GameCategoryUI.this)))
          {
            AppMethodBeat.o(41915);
            return;
          }
          GameCategoryUI.f(GameCategoryUI.this).setVisibility(0);
          GameCategoryUI.g(GameCategoryUI.this);
        }
        AppMethodBeat.o(41915);
      }
    };
    AppMethodBeat.o(41918);
  }
  
  private void cEc()
  {
    AppMethodBeat.i(41921);
    ar localar = new ar(this.rXN, this.mType, this.sft);
    com.tencent.mm.kernel.g.aeS().a(localar, 0);
    this.sfr = true;
    AppMethodBeat.o(41921);
  }
  
  public int getLayoutId()
  {
    return 2131494247;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41923);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      ad.e("MicroMsg.GameCategoryUI", "error request code");
      AppMethodBeat.o(41923);
      return;
    }
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("game_app_id");
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41923);
      return;
      if (bt.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.sfq.acQ(str);
      AppMethodBeat.o(41923);
      return;
      if (bt.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.sfq.acP(str);
      this.sfq.acR(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41919);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("extra_type", 0);
    this.sft = getIntent().getIntExtra("extra_category_id", 0);
    this.sfu = getIntent().getStringExtra("extra_category_name");
    this.rXI = getIntent().getIntExtra("game_report_from_scene", 0);
    com.tencent.mm.kernel.g.aeS().a(1220, this);
    setMMTitle(this.sfu);
    setBackBtn(new GameCategoryUI.1(this));
    if (!bt.isNullOrNil(e.cCZ())) {
      addIconOptionMenu(0, 2131764452, 2131689494, new GameCategoryUI.2(this));
    }
    this.sfp = ((ListView)findViewById(2131300355));
    this.sfp.setOnItemClickListener(this.sfi);
    this.sfi.setSourceScene(this.rXI);
    this.sfp.setOnScrollListener(this.sfw);
    this.sfq = new l(this);
    this.sfq.setSourceScene(this.rXI);
    this.sfq.a(this.sfv);
    this.fwo = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494337, this.sfp, false);
    this.fwo.setVisibility(8);
    this.sfp.addFooterView(this.fwo);
    this.sfp.setAdapter(this.sfq);
    this.lIc = c.fi(this);
    this.lIc.show();
    cEc();
    AppMethodBeat.o(41919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41920);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(1220, this);
    this.sfq.clear();
    AppMethodBeat.o(41920);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(41922);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(41922);
      return;
    }
    paramString = ((ar)paramn).fUF.gUT.gUX;
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41917);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41916);
            GameCategoryUI localGameCategoryUI = GameCategoryUI.this;
            y localy = this.sfz;
            if (GameCategoryUI.h(GameCategoryUI.this) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              GameCategoryUI.a(localGameCategoryUI, localy, bool);
              GameCategoryUI.i(GameCategoryUI.this);
              GameCategoryUI.f(GameCategoryUI.this).setVisibility(8);
              GameCategoryUI.a(GameCategoryUI.this, GameCategoryUI.h(GameCategoryUI.this) + 15);
              if (GameCategoryUI.j(GameCategoryUI.this) != null) {
                GameCategoryUI.j(GameCategoryUI.this).dismiss();
              }
              AppMethodBeat.o(41916);
              return;
            }
          }
        });
        AppMethodBeat.o(41917);
      }
    });
    AppMethodBeat.o(41922);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI
 * JD-Core Version:    0.7.0.1
 */