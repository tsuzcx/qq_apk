package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI
  extends MMActivity
{
  public static String EXTRA_SESSION_ID = "extra_session_id";
  public static String nxm = "gameDetailRankDataKey";
  private String appId;
  private ListView nxj;
  private GameRankHeadView nxk;
  private i nxl;
  
  public int getLayoutId()
  {
    return 2130969731;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111838);
    setMMTitle(com.tencent.mm.pluginsdk.model.app.g.t(getContext(), this.appId));
    setBackBtn(new GameDetailRankUI.2(this));
    AppMethodBeat.o(111838);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111835);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra(EXTRA_SESSION_ID);
    paramBundle = v.aae().oP(paramBundle);
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(111835);
      return;
    }
    paramBundle = (a)paramBundle.get(nxm);
    this.nxj = ((ListView)findViewById(2131824580));
    if ((!bo.isNullOrNil(paramBundle.nxo)) && (!bo.isNullOrNil(paramBundle.nxp)))
    {
      View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130969738, this.nxj, false);
      this.nxk = ((GameRankHeadView)localView.findViewById(2131824596));
      this.nxj.addHeaderView(localView);
      this.nxk.setData(paramBundle);
    }
    this.nxl = new i(this);
    this.nxl.Ld = 2130969732;
    this.nxj.setAdapter(this.nxl);
    this.appId = paramBundle.nxq.field_appId;
    if (bo.isNullOrNil(this.appId))
    {
      finish();
      AppMethodBeat.o(111835);
      return;
    }
    initView();
    com.tencent.mm.kernel.g.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111833);
        aa localaa = new aa(GameDetailRankUI.a(GameDetailRankUI.this));
        GameDetailRankUI.b(GameDetailRankUI.this).a(localaa);
        AppMethodBeat.o(111833);
      }
    });
    AppMethodBeat.o(111835);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111837);
    super.onDestroy();
    j.b(this.nxk.nxv);
    AppMethodBeat.o(111837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111836);
    super.onResume();
    AppMethodBeat.o(111836);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    public String nxo;
    public String nxp;
    c nxq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankUI
 * JD-Core Version:    0.7.0.1
 */