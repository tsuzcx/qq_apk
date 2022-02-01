package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.h;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int IFc;
  private int IFh;
  private ListView INC;
  private l IND;
  private boolean INE;
  private boolean INF;
  private int ING;
  private String INH;
  private m.a INI;
  private AbsListView.OnScrollListener INJ;
  private k INv;
  private View lNf;
  private int mType;
  private Dialog ums;
  
  public GameCategoryUI()
  {
    AppMethodBeat.i(41918);
    this.INE = false;
    this.IFh = 0;
    this.INF = false;
    this.IFc = 0;
    this.INv = new k();
    this.INI = new m.a()
    {
      public final void XG(int paramAnonymousInt)
      {
        AppMethodBeat.i(41914);
        int i = GameCategoryUI.b(GameCategoryUI.this).getFirstVisiblePosition();
        int j = GameCategoryUI.b(GameCategoryUI.this).getLastVisiblePosition();
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j))
        {
          View localView = GameCategoryUI.b(GameCategoryUI.this).getChildAt(paramAnonymousInt - i);
          GameCategoryUI.c(GameCategoryUI.this).aA(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(41914);
      }
    };
    this.INJ = new AbsListView.OnScrollListener()
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
  
  private void fHq()
  {
    AppMethodBeat.i(41921);
    ar localar = new ar(this.IFh, this.mType, this.ING);
    com.tencent.mm.kernel.h.aZW().a(localar, 0);
    this.INE = true;
    AppMethodBeat.o(41921);
  }
  
  public int getLayoutId()
  {
    return h.f.HYz;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41923);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      Log.e("MicroMsg.GameCategoryUI", "error request code");
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
      if (Util.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.IND.aHd(str);
      AppMethodBeat.o(41923);
      return;
      if (Util.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.IND.aHc(str);
      this.IND.aHe(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41919);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("extra_type", 0);
    this.ING = getIntent().getIntExtra("extra_category_id", 0);
    this.INH = getIntent().getStringExtra("extra_category_name");
    this.IFc = getIntent().getIntExtra("game_report_from_scene", 0);
    com.tencent.mm.kernel.h.aZW().a(1220, this);
    setMMTitle(this.INH);
    setBackBtn(new GameCategoryUI.1(this));
    if (!Util.isNullOrNil(e.fGi())) {
      addIconOptionMenu(0, h.i.top_item_desc_search, h.h.actionbar_icon_dark_search, new GameCategoryUI.2(this));
    }
    this.INC = ((ListView)findViewById(h.e.HUd));
    this.INC.setOnItemClickListener(this.INv);
    this.INv.setSourceScene(this.IFc);
    this.INC.setOnScrollListener(this.INJ);
    this.IND = new l(this);
    this.IND.setSourceScene(this.IFc);
    this.IND.a(this.INI);
    this.lNf = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(h.f.HZP, this.INC, false);
    this.lNf.setVisibility(8);
    this.INC.addFooterView(this.lNf);
    this.INC.setAdapter(this.IND);
    this.ums = com.tencent.mm.plugin.game.d.c.hY(this);
    this.ums.show();
    fHq();
    AppMethodBeat.o(41919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41920);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(1220, this);
    this.IND.clear();
    AppMethodBeat.o(41920);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(41922);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(41922);
      return;
    }
    paramString = c.c.b(((ar)paramp).mtC.otC);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41917);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41916);
            GameCategoryUI localGameCategoryUI = GameCategoryUI.this;
            y localy = this.INM;
            if (GameCategoryUI.h(GameCategoryUI.this) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              GameCategoryUI.a(localGameCategoryUI, localy, bool);
              GameCategoryUI.i(GameCategoryUI.this);
              GameCategoryUI.f(GameCategoryUI.this).setVisibility(8);
              GameCategoryUI.j(GameCategoryUI.this);
              if (GameCategoryUI.k(GameCategoryUI.this) != null) {
                GameCategoryUI.k(GameCategoryUI.this).dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI
 * JD-Core Version:    0.7.0.1
 */