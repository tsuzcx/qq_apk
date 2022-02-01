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
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI
  extends MMActivity
{
  public static String EXTRA_SESSION_ID = "extra_session_id";
  public static String xQy = "gameDetailRankDataKey";
  private String appId;
  private ListView xQv;
  private GameRankHeadView xQw;
  private i xQx;
  
  public int getLayoutId()
  {
    return 2131494846;
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
    paramBundle = ad.aVe().JW(paramBundle);
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(42005);
      return;
    }
    paramBundle = (a)paramBundle.get(xQy);
    this.xQv = ((ListView)findViewById(2131301943));
    if ((!Util.isNullOrNil(paramBundle.xQA)) && (!Util.isNullOrNil(paramBundle.xQB)))
    {
      View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494853, this.xQv, false);
      this.xQw = ((GameRankHeadView)localView.findViewById(2131302072));
      this.xQv.addHeaderView(localView);
      this.xQw.setData(paramBundle);
    }
    this.xQx = new i(this);
    this.xQx.Ve = 2131494847;
    this.xQv.setAdapter(this.xQx);
    this.appId = paramBundle.xQC.field_appId;
    if (Util.isNullOrNil(this.appId))
    {
      finish();
      AppMethodBeat.o(42005);
      return;
    }
    initView();
    g.aAk().postToWorker(new Runnable()
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
    k.b(this.xQw.xQH);
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
    public String xQA;
    public String xQB;
    c xQC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankUI
 * JD-Core Version:    0.7.0.1
 */