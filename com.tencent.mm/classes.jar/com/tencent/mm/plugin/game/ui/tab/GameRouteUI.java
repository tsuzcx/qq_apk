package com.tencent.mm.plugin.game.ui.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.io.IOException;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.game.d.ak;>;

@com.tencent.mm.ui.base.a(19)
public class GameRouteUI
  extends GameCenterActivity
{
  private int kQh;
  
  private static bf baq()
  {
    byte[] arrayOfByte = ((c)g.r(c.class)).aYg().Ey("game_index4_tab_nav");
    if (bk.bE(arrayOfByte)) {
      return null;
    }
    try
    {
      bf localbf = new bf();
      try
      {
        localbf.aH(arrayOfByte);
        return localbf;
      }
      catch (IOException localIOException2)
      {
        return localbf;
      }
      return null;
    }
    catch (IOException localIOException1) {}
  }
  
  private void c(List<com.tencent.mm.plugin.game.d.ak> paramList, boolean paramBoolean)
  {
    if ((isFinishing()) || (isDestroyed())) {
      return;
    }
    GameTabData localGameTabData = GameTabData.bD(paramList);
    if ((localGameTabData == null) || (bk.dk(localGameTabData.getItemList())))
    {
      y.e("MicroMsg.GameRouteUI", "game tab data is null");
      exit();
      return;
    }
    Object localObject2 = localGameTabData.getItemList();
    int i = 0;
    paramList = null;
    Object localObject1;
    if (i < ((List)localObject2).size())
    {
      localObject1 = (GameTabData.TabItem)((List)localObject2).get(i);
      if (localObject1 == null) {
        break label228;
      }
      if (!((GameTabData.TabItem)localObject1).kQU) {
        break label225;
      }
      paramList = (List<com.tencent.mm.plugin.game.d.ak>)localObject1;
      label100:
      com.tencent.mm.plugin.game.e.a.a(this, 18, ((GameTabData.TabItem)localObject1).bXn, ((GameTabData.TabItem)localObject1).kRc, null, this.kQh, com.tencent.mm.plugin.game.e.a.fy(((GameTabData.TabItem)localObject1).kOo));
    }
    label225:
    label228:
    for (;;)
    {
      i += 1;
      break;
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = (GameTabData.TabItem)((List)localObject2).get(0);
      }
      if (localObject1 == null)
      {
        y.e("MicroMsg.GameRouteUI", "game tab entry item is null");
        exit();
        return;
      }
      localObject2 = getIntent().getExtras();
      paramList = (List<com.tencent.mm.plugin.game.d.ak>)localObject2;
      if (localObject2 == null) {
        paramList = new Bundle();
      }
      paramList.putParcelable("tab_data", localGameTabData);
      getIntent().putExtras(paramList);
      GameTabWidget.a(this, (GameTabData.TabItem)localObject1, paramBoolean, true, true);
      return;
      break label100;
    }
  }
  
  private void exit()
  {
    if ((!isFinishing()) && (!isDestroyed()))
    {
      finish();
      overridePendingTransition(MMFragmentActivity.a.uOg, MMFragmentActivity.a.uOh);
    }
  }
  
  protected final boolean aZX()
  {
    return false;
  }
  
  public final int aZY()
  {
    return 0;
  }
  
  public final int aZZ()
  {
    return 0;
  }
  
  public final int baa()
  {
    return 0;
  }
  
  protected final int getLayoutId()
  {
    return g.f.game_route_layout;
  }
  
  protected final void initView()
  {
    setBackBtn(new GameRouteUI.2(this));
    setMMTitle(g.i.game_wechat_game);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = false;
    super.onCreate(paramBundle);
    initView();
    this.kQh = getIntent().getIntExtra("game_report_from_scene", 0);
    paramBundle = baq();
    if ((paramBundle != null) && (!bk.dk(paramBundle.kTw)))
    {
      y.i("MicroMsg.GameRouteUI", "use cache data");
      com.tencent.mm.plugin.game.model.ak.a(null);
      boolean bool2 = getIntent().getBooleanExtra("switch_country_no_anim", false);
      getIntent().removeExtra("switch_country_no_anim");
      paramBundle = paramBundle.kTw;
      if (!bool2) {
        bool1 = true;
      }
      c(paramBundle, bool1);
      return;
    }
    com.tencent.mm.plugin.game.model.ak.a(new GameRouteUI.1(this));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      exit();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameRouteUI
 * JD-Core Version:    0.7.0.1
 */