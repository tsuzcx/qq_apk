package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.as;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class GameCategoryUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private View drU;
  private Dialog hhG;
  private int kQh = 0;
  private int kQn = 0;
  private k kXC = new k();
  private ListView kXJ;
  private l kXK;
  private boolean kXL = false;
  private boolean kXM = false;
  private int kXN;
  private String kXO;
  private m.a kXP = new GameCategoryUI.3(this);
  private AbsListView.OnScrollListener kXQ = new GameCategoryUI.4(this);
  private int mType;
  
  private void bab()
  {
    as localas = new as(this.kQn, this.mType, this.kXN);
    g.Dk().a(localas, 0);
    this.kXL = true;
  }
  
  protected final int getLayoutId()
  {
    return g.f.game_category;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1) {
      y.e("MicroMsg.GameCategoryUI", "error request code");
    }
    String str;
    do
    {
      do
      {
        return;
        str = null;
        if (paramIntent != null) {
          str = paramIntent.getStringExtra("game_app_id");
        }
        switch (paramInt2)
        {
        default: 
          return;
        }
      } while (bk.bl(str));
      this.kXK.EY(str);
      this.kXK.Fa(str);
      return;
    } while (bk.bl(str));
    this.kXK.EZ(str);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("extra_type", 0);
    this.kXN = getIntent().getIntExtra("extra_category_id", 0);
    this.kXO = getIntent().getStringExtra("extra_category_name");
    this.kQh = getIntent().getIntExtra("game_report_from_scene", 0);
    g.Dk().a(1220, this);
    setMMTitle(this.kXO);
    setBackBtn(new GameCategoryUI.1(this));
    if (!bk.bl(com.tencent.mm.plugin.game.model.f.aZg())) {
      addIconOptionMenu(0, g.i.top_item_desc_search, g.h.actionbar_icon_dark_search, new GameCategoryUI.2(this));
    }
    this.kXJ = ((ListView)findViewById(g.e.game_category_list));
    this.kXJ.setOnItemClickListener(this.kXC);
    this.kXC.setSourceScene(this.kQh);
    this.kXJ.setOnScrollListener(this.kXQ);
    this.kXK = new l(this);
    this.kXK.setSourceScene(this.kQh);
    this.kXK.a(this.kXP);
    this.drU = ((LayoutInflater)this.mController.uMN.getSystemService("layout_inflater")).inflate(g.f.game_list_footer_loading, this.kXJ, false);
    this.drU.setVisibility(8);
    this.kXJ.addFooterView(this.drU);
    this.kXJ.setAdapter(this.kXK);
    this.hhG = c.dA(this);
    this.hhG.show();
    bab();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g.Dk().b(1220, this);
    this.kXK.clear();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    paramString = ((as)paramm).jvQ.ecF.ecN;
    g.DS().O(new GameCategoryUI.5(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI
 * JD-Core Version:    0.7.0.1
 */