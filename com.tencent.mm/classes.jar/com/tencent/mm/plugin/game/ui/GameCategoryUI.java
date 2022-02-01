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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private View fzV;
  private int mType;
  private Dialog mjY;
  private int tfA;
  private int tfF;
  private k tnb;
  private ListView tni;
  private l tnj;
  private boolean tnk;
  private boolean tnl;
  private int tnm;
  private String tnn;
  private m.a tno;
  private AbsListView.OnScrollListener tnp;
  
  public GameCategoryUI()
  {
    AppMethodBeat.i(41918);
    this.tnk = false;
    this.tfF = 0;
    this.tnl = false;
    this.tfA = 0;
    this.tnb = new k();
    this.tno = new m.a()
    {
      public final void GA(int paramAnonymousInt)
      {
        AppMethodBeat.i(41914);
        int i = GameCategoryUI.b(GameCategoryUI.this).getFirstVisiblePosition();
        int j = GameCategoryUI.b(GameCategoryUI.this).getLastVisiblePosition();
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j))
        {
          View localView = GameCategoryUI.b(GameCategoryUI.this).getChildAt(paramAnonymousInt - i);
          GameCategoryUI.c(GameCategoryUI.this).ag(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(41914);
      }
    };
    this.tnp = new AbsListView.OnScrollListener()
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
  
  private void cRm()
  {
    AppMethodBeat.i(41921);
    ar localar = new ar(this.tfF, this.mType, this.tnm);
    com.tencent.mm.kernel.g.agi().a(localar, 0);
    this.tnk = true;
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
    ac.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      ac.e("MicroMsg.GameCategoryUI", "error request code");
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
      if (bs.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.tnj.ahI(str);
      AppMethodBeat.o(41923);
      return;
      if (bs.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.tnj.ahH(str);
      this.tnj.ahJ(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41919);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("extra_type", 0);
    this.tnm = getIntent().getIntExtra("extra_category_id", 0);
    this.tnn = getIntent().getStringExtra("extra_category_name");
    this.tfA = getIntent().getIntExtra("game_report_from_scene", 0);
    com.tencent.mm.kernel.g.agi().a(1220, this);
    setMMTitle(this.tnn);
    setBackBtn(new GameCategoryUI.1(this));
    if (!bs.isNullOrNil(e.cQj())) {
      addIconOptionMenu(0, 2131764452, 2131689494, new GameCategoryUI.2(this));
    }
    this.tni = ((ListView)findViewById(2131300355));
    this.tni.setOnItemClickListener(this.tnb);
    this.tnb.setSourceScene(this.tfA);
    this.tni.setOnScrollListener(this.tnp);
    this.tnj = new l(this);
    this.tnj.setSourceScene(this.tfA);
    this.tnj.a(this.tno);
    this.fzV = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494337, this.tni, false);
    this.fzV.setVisibility(8);
    this.tni.addFooterView(this.fzV);
    this.tni.setAdapter(this.tnj);
    this.mjY = c.fv(this);
    this.mjY.show();
    cRm();
    AppMethodBeat.o(41919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41920);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(1220, this);
    this.tnj.clear();
    AppMethodBeat.o(41920);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(41922);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(41922);
      return;
    }
    paramString = ((ar)paramn).fYA.hvs.hvw;
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41917);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41916);
            GameCategoryUI localGameCategoryUI = GameCategoryUI.this;
            y localy = this.tns;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI
 * JD-Core Version:    0.7.0.1
 */