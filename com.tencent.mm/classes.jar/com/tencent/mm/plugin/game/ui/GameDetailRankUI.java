package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI
  extends MMActivity
{
  public static String EXTRA_SESSION_ID = "extra_session_id";
  public static String und = "gameDetailRankDataKey";
  private String appId;
  private ListView una;
  private GameRankHeadView unb;
  private i unc;
  
  public int getLayoutId()
  {
    return 2131494284;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42008);
    setMMTitle(h.r(getContext(), this.appId));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42004);
        GameDetailRankUI.this.finish();
        AppMethodBeat.o(42004);
        return true;
      }
    });
    AppMethodBeat.o(42008);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42005);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra(EXTRA_SESSION_ID);
    paramBundle = y.aBq().AG(paramBundle);
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(42005);
      return;
    }
    paramBundle = (a)paramBundle.get(und);
    this.una = ((ListView)findViewById(2131300420));
    if ((!bt.isNullOrNil(paramBundle.unf)) && (!bt.isNullOrNil(paramBundle.ung)))
    {
      View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494291, this.una, false);
      this.unb = ((GameRankHeadView)localView.findViewById(2131300540));
      this.una.addHeaderView(localView);
      this.unb.setData(paramBundle);
    }
    this.unc = new i(this);
    this.unc.UR = 2131494285;
    this.una.setAdapter(this.unc);
    this.appId = paramBundle.unh.field_appId;
    if (bt.isNullOrNil(this.appId))
    {
      finish();
      AppMethodBeat.o(42005);
      return;
    }
    initView();
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42003);
        aa localaa = new aa(GameDetailRankUI.a(GameDetailRankUI.this));
        GameDetailRankUI.b(GameDetailRankUI.this).a(localaa);
        AppMethodBeat.o(42003);
      }
    });
    AppMethodBeat.o(42005);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42007);
    super.onDestroy();
    k.b(this.unb.unm);
    AppMethodBeat.o(42007);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42006);
    super.onResume();
    AppMethodBeat.o(42006);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    public String unf;
    public String ung;
    c unh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankUI
 * JD-Core Version:    0.7.0.1
 */