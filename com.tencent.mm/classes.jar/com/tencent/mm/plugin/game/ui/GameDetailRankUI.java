package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI
  extends MMActivity
{
  public static String IOZ = "extra_session_id";
  public static String IPa = "gameDetailRankDataKey";
  private ListView IOW;
  private GameRankHeadView IOX;
  private i IOY;
  private String appId;
  
  public int getLayoutId()
  {
    return h.f.HYZ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42008);
    setMMTitle(com.tencent.mm.pluginsdk.model.app.h.x(getContext(), this.appId));
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
    paramBundle = getIntent().getStringExtra(IOZ);
    paramBundle = ad.bCb().Jn(paramBundle);
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(42005);
      return;
    }
    paramBundle = (a)paramBundle.get(IPa);
    this.IOW = ((ListView)findViewById(h.e.HVd));
    if ((!Util.isNullOrNil(paramBundle.IPc)) && (!Util.isNullOrNil(paramBundle.IPd)))
    {
      View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(h.f.HZg, this.IOW, false);
      this.IOX = ((GameRankHeadView)localView.findViewById(h.e.HWq));
      this.IOW.addHeaderView(localView);
      this.IOX.setData(paramBundle);
    }
    this.IOY = new i(this);
    this.IOY.bxp = h.f.HZa;
    this.IOW.setAdapter(this.IOY);
    this.appId = paramBundle.IPe.field_appId;
    if (Util.isNullOrNil(this.appId))
    {
      finish();
      AppMethodBeat.o(42005);
      return;
    }
    initView();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
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
    k.b(this.IOX.IPj);
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
  
  public static class a
  {
    public String IPc;
    public String IPd;
    c IPe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankUI
 * JD-Core Version:    0.7.0.1
 */