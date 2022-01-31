package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.plugin.game.d.bq;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankLikedUI
  extends MMActivity
{
  private static final String TAG;
  private Dialog iTk;
  private ListView nxe;
  private GameDetailRankLikedUI.a nxf;
  
  static
  {
    AppMethodBeat.i(111832);
    TAG = "MicroMsg" + GameDetailRankLikedUI.class.getSimpleName();
    AppMethodBeat.o(111832);
  }
  
  public int getLayoutId()
  {
    return 2130969735;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111831);
    setMMTitle(2131300350);
    setBackBtn(new GameDetailRankLikedUI.1(this));
    this.nxe = ((ListView)findViewById(2131824589));
    this.nxf = new GameDetailRankLikedUI.a(this);
    this.nxe.setAdapter(this.nxf);
    this.iTk = c.en(getContext());
    this.iTk.show();
    AppMethodBeat.o(111831);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111830);
    super.onCreate(paramBundle);
    initView();
    paramBundle = getIntent().getStringExtra("extra_appdi");
    if (bo.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(111830);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bp();
    ((b.a)localObject).fsY = new bq();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getuplist";
    ((b.a)localObject).funcId = 1331;
    localObject = ((b.a)localObject).ado();
    ((bp)((b)localObject).fsV.fta).npZ = paramBundle;
    w.a((b)localObject, new GameDetailRankLikedUI.2(this));
    AppMethodBeat.o(111830);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI
 * JD-Core Version:    0.7.0.1
 */