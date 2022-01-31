package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI
  extends MMActivity
  implements f
{
  private View ejC;
  private Dialog iTk;
  private int mType;
  private int nok;
  private int nor;
  private k nvE;
  private ListView nvL;
  private l nvM;
  private boolean nvN;
  private boolean nvO;
  private int nvP;
  private String nvQ;
  private m.a nvR;
  private AbsListView.OnScrollListener nvS;
  
  public GameCategoryUI()
  {
    AppMethodBeat.i(111751);
    this.nvN = false;
    this.nor = 0;
    this.nvO = false;
    this.nok = 0;
    this.nvE = new k();
    this.nvR = new GameCategoryUI.3(this);
    this.nvS = new GameCategoryUI.4(this);
    AppMethodBeat.o(111751);
  }
  
  private void bHi()
  {
    AppMethodBeat.i(111754);
    ar localar = new ar(this.nor, this.mType, this.nvP);
    g.Rc().a(localar, 0);
    this.nvN = true;
    AppMethodBeat.o(111754);
  }
  
  public int getLayoutId()
  {
    return 2130969695;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(111756);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      ab.e("MicroMsg.GameCategoryUI", "error request code");
      AppMethodBeat.o(111756);
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
      AppMethodBeat.o(111756);
      return;
      if (bo.isNullOrNil(str))
      {
        AppMethodBeat.o(111756);
        return;
      }
      this.nvM.Qr(str);
      AppMethodBeat.o(111756);
      return;
      if (bo.isNullOrNil(str))
      {
        AppMethodBeat.o(111756);
        return;
      }
      this.nvM.Qq(str);
      this.nvM.Qs(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111752);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("extra_type", 0);
    this.nvP = getIntent().getIntExtra("extra_category_id", 0);
    this.nvQ = getIntent().getStringExtra("extra_category_name");
    this.nok = getIntent().getIntExtra("game_report_from_scene", 0);
    g.Rc().a(1220, this);
    setMMTitle(this.nvQ);
    setBackBtn(new GameCategoryUI.1(this));
    if (!bo.isNullOrNil(e.bGf())) {
      addIconOptionMenu(0, 2131304318, 2131230741, new GameCategoryUI.2(this));
    }
    this.nvL = ((ListView)findViewById(2131824432));
    this.nvL.setOnItemClickListener(this.nvE);
    this.nvE.setSourceScene(this.nok);
    this.nvL.setOnScrollListener(this.nvS);
    this.nvM = new l(this);
    this.nvM.setSourceScene(this.nok);
    this.nvM.a(this.nvR);
    this.ejC = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130969779, this.nvL, false);
    this.ejC.setVisibility(8);
    this.nvL.addFooterView(this.ejC);
    this.nvL.setAdapter(this.nvM);
    this.iTk = c.en(this);
    this.iTk.show();
    bHi();
    AppMethodBeat.o(111752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111753);
    super.onDestroy();
    g.Rc().b(1220, this);
    this.nvM.clear();
    AppMethodBeat.o(111753);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(111755);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(111755);
      return;
    }
    paramString = ((ar)paramm).lFp.fsW.fta;
    g.RO().ac(new GameCategoryUI.5(this, paramString));
    AppMethodBeat.o(111755);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI
 * JD-Core Version:    0.7.0.1
 */