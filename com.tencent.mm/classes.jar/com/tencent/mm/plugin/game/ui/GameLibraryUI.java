package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.b.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private View drU;
  private Dialog jwv;
  private int kQh = 0;
  private int kQn = 0;
  private k kXC = new k();
  private ListView kXJ;
  private l kXK;
  private boolean kXL = false;
  private boolean kXM = true;
  private m.a kXP = new GameLibraryUI.3(this);
  private AbsListView.OnScrollListener kXQ = new GameLibraryUI.8(this);
  private boolean kYB = true;
  private boolean kyM = false;
  private GameLibraryCategoriesView lcA;
  private View lcB;
  private TextView lcC;
  private View lcD;
  private GameDropdownView lcE;
  private HashMap<Integer, String> lcF;
  private int lcG = 0;
  private View lcH;
  private Button lcI;
  private boolean lcJ = false;
  private int lcK = 990;
  private int lcL = 0;
  private View.OnClickListener lcM = new GameLibraryUI.5(this);
  private View.OnClickListener lcN = new GameLibraryUI.6(this);
  private GameDropdownView.a lcO = new GameLibraryUI.7(this);
  private GameBannerView lcz;
  
  private void bal()
  {
    Object localObject = com.tencent.mm.plugin.game.model.f.aYT();
    int i = this.kQn;
    int j = this.lcG;
    if (this.kQn == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new ar(i, (LinkedList)localObject, j, bool);
      g.Dk().a((m)localObject, 0);
      this.kXL = true;
      return;
    }
  }
  
  private void goBack()
  {
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bk.bl((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      startActivity((Intent)localObject);
    }
    finish();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return g.f.game_library;
  }
  
  protected final void initView()
  {
    setMMTitle(g.i.game_library);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GameLibraryUI.a(GameLibraryUI.this);
        return true;
      }
    });
    if (!bk.bl(com.tencent.mm.plugin.game.model.f.aZg())) {
      addIconOptionMenu(0, g.i.top_item_desc_search, g.h.actionbar_icon_dark_search, new GameLibraryUI.2(this));
    }
    this.kXJ = ((ListView)findViewById(g.e.game_library_list));
    this.kXJ.setOnItemClickListener(this.kXC);
    this.kXC.setSourceScene(this.kQh);
    this.kXJ.setOnScrollListener(this.kXQ);
    this.kXK = new l(this);
    this.kXK.setSourceScene(this.kQh);
    this.kXK.a(this.kXP);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mController.uMN.getSystemService("layout_inflater");
    Object localObject = localLayoutInflater.inflate(g.f.game_library_top_banner, this.kXJ, false);
    this.lcz = ((GameBannerView)((View)localObject).findViewById(g.e.game_library_top_banner));
    this.lcz.setSourceScene(this.kQh);
    this.kXJ.addHeaderView((View)localObject);
    this.lcL += 1;
    this.lcA = ((GameLibraryCategoriesView)localLayoutInflater.inflate(g.f.game_library_categories_head, this.kXJ, false));
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.lcA);
    this.kXJ.addHeaderView((View)localObject);
    this.lcL += 1;
    this.lcB = localLayoutInflater.inflate(g.f.game_library_new_head, this.kXJ, false);
    this.lcB.setOnClickListener(this.lcM);
    this.lcC = ((TextView)this.lcB.findViewById(g.e.game_library_new_game_more));
    this.lcD = localLayoutInflater.inflate(g.f.game_library_all_head, this.kXJ, false);
    this.lcD.setOnClickListener(null);
    this.lcE = ((GameDropdownView)this.lcD.findViewById(g.e.game_library_all_sort));
    this.lcE.setAnchorView(this.lcD);
    this.lcE.setOnSelectionChangedListener(this.lcO);
    this.drU = localLayoutInflater.inflate(g.f.game_list_footer_loading, this.kXJ, false);
    this.drU.setVisibility(8);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.drU);
    this.kXJ.addFooterView((View)localObject);
    this.lcH = localLayoutInflater.inflate(g.f.game_library_footer_more, this.kXJ, false);
    this.lcH.setVisibility(8);
    this.lcI = ((Button)this.lcH.findViewById(g.e.game_library_more_btn));
    this.lcI.setOnClickListener(this.lcN);
    this.kXJ.addFooterView(this.lcH);
    this.kXJ.setAdapter(this.kXK);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1) {
      y.e("MicroMsg.GameLibraryUI", "error request code");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.DK())
    {
      y.e("MicroMsg.GameLibraryUI", "account not ready");
      finish();
      return;
    }
    this.kQh = getIntent().getIntExtra("game_report_from_scene", 0);
    g.Dk().a(1218, this);
    initView();
    paramBundle = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYg().Ey("pb_library");
    if (paramBundle == null) {
      y.i("MicroMsg.GameLibraryUI", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.jwv = com.tencent.mm.plugin.game.f.c.dA(this);
        this.jwv.show();
      }
      bal();
      com.tencent.mm.plugin.game.e.b.a(this, 11, 1100, 0, 1, this.kQh, null);
      return;
      g.DS().O(new GameLibraryUI.4(this, paramBundle));
    }
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.GameLibraryUI", "onDestroy");
    super.onDestroy();
    g.Dk().b(1218, this);
    this.kXK.clear();
    if (this.lcz != null) {
      this.lcz.kXj.stopTimer();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.lcz != null)
    {
      GameBannerView localGameBannerView = this.lcz;
      if (localGameBannerView.kXj != null)
      {
        localGameBannerView.kXj.stopTimer();
        y.i("MicroMsg.GameBannerView", "Auto scroll stopped");
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!g.DK()) {
      y.e("MicroMsg.GameLibraryUI", "account not ready");
    }
    do
    {
      return;
      this.kXK.refresh();
      if ((!this.kYB) && (this.lcz != null))
      {
        GameBannerView localGameBannerView = this.lcz;
        if ((localGameBannerView.kXj != null) && (localGameBannerView.kXj.crl()) && (localGameBannerView.kXi.size() > 1))
        {
          localGameBannerView.kXj.S(5000L, 5000L);
          y.i("MicroMsg.GameBannerView", "Auto scroll restarted");
        }
      }
    } while (!this.kYB);
    this.kYB = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramm.getType())
      {
      }
    }
    do
    {
      return;
      paramString = ((ar)paramm).jvQ.ecF.ecN;
      g.DS().O(new GameLibraryUI.9(this, paramString));
      return;
      if (!a.eUS.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(g.i.game_list_get_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
    } while (this.jwv == null);
    this.jwv.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI
 * JD-Core Version:    0.7.0.1
 */