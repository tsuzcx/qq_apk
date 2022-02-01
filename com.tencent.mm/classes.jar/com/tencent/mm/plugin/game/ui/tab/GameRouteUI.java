package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.game.d.an;>;

@com.tencent.mm.ui.base.a(19)
public class GameRouteUI
  extends GameCenterActivity
  implements com.tencent.mm.al.g
{
  private int rXI;
  
  /* Error */
  private static bg cEt()
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 48
    //   7: invokestatic 54	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   10: checkcast 48	com/tencent/mm/plugin/game/api/e
    //   13: invokeinterface 58 1 0
    //   18: ldc 60
    //   20: invokevirtual 66	com/tencent/mm/plugin/game/model/w:abW	(Ljava/lang/String;)[B
    //   23: astore_1
    //   24: aload_1
    //   25: invokestatic 72	com/tencent/mm/sdk/platformtools/bt:cw	([B)Z
    //   28: ifeq +10 -> 38
    //   31: ldc 46
    //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: new 74	com/tencent/mm/plugin/game/d/bg
    //   41: dup
    //   42: invokespecial 75	com/tencent/mm/plugin/game/d/bg:<init>	()V
    //   45: astore_0
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 79	com/tencent/mm/plugin/game/d/bg:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   51: pop
    //   52: ldc 46
    //   54: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_0
    //   62: goto -10 -> 52
    //   65: astore_1
    //   66: goto -14 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	13	0	localbg	bg
    //   59	1	0	localIOException1	java.io.IOException
    //   61	1	0	localObject	Object
    //   23	25	1	arrayOfByte	byte[]
    //   65	1	1	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   38	46	59	java/io/IOException
    //   46	52	65	java/io/IOException
  }
  
  private void d(List<an> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(42426);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(42426);
      return;
    }
    GameTabData localGameTabData = GameTabData.dQ(paramList);
    if ((localGameTabData == null) || (bt.gL(localGameTabData.getItemList())))
    {
      ad.e("MicroMsg.GameRouteUI", "game tab data is null");
      exit();
      AppMethodBeat.o(42426);
      return;
    }
    Object localObject2 = localGameTabData.getItemList();
    paramList = null;
    int i = 0;
    Object localObject1;
    if (i < ((List)localObject2).size())
    {
      localObject1 = (GameTabData.TabItem)((List)localObject2).get(i);
      if (localObject1 == null) {
        break label253;
      }
      if (!((GameTabData.TabItem)localObject1).rYt) {
        break label250;
      }
      paramList = (List<an>)localObject1;
      label115:
      com.tencent.mm.plugin.game.e.a.a(this, 18, ((GameTabData.TabItem)localObject1).dvS, ((GameTabData.TabItem)localObject1).rYB, null, this.rXI, com.tencent.mm.plugin.game.e.a.qh(((GameTabData.TabItem)localObject1).rVj));
    }
    label250:
    label253:
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
        ad.e("MicroMsg.GameRouteUI", "game tab entry item is null");
        exit();
        AppMethodBeat.o(42426);
        return;
      }
      localObject2 = getIntent().getExtras();
      paramList = (List<an>)localObject2;
      if (localObject2 == null) {
        paramList = new Bundle();
      }
      paramList.putParcelable("tab_data", localGameTabData);
      getIntent().putExtras(paramList);
      GameTabWidget.a(this, (GameTabData.TabItem)localObject1, paramBoolean, true, true);
      AppMethodBeat.o(42426);
      return;
      break label115;
    }
  }
  
  private void exit()
  {
    AppMethodBeat.i(42425);
    if ((!isFinishing()) && (!isDestroyed()))
    {
      finish();
      overridePendingTransition(MMFragmentActivity.a.lLH, MMFragmentActivity.a.lLI);
    }
    AppMethodBeat.o(42425);
  }
  
  public final boolean cDZ()
  {
    return false;
  }
  
  public final int cEa()
  {
    return 0;
  }
  
  public final int cEb()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131494376;
  }
  
  public final int getScene()
  {
    return 0;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42421);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42418);
        GameRouteUI.a(GameRouteUI.this);
        AppMethodBeat.o(42418);
        return true;
      }
    });
    setMMTitle(2131760012);
    AppMethodBeat.o(42421);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = false;
    AppMethodBeat.i(42420);
    super.onCreate(paramBundle);
    initView();
    this.rXI = getIntent().getIntExtra("game_report_from_scene", 0);
    paramBundle = cEt();
    if ((paramBundle != null) && (!bt.gL(paramBundle.saZ)))
    {
      ad.i("MicroMsg.GameRouteUI", "use cache data");
      aj.updateData();
      boolean bool2 = getIntent().getBooleanExtra("switch_country_no_anim", false);
      getIntent().removeExtra("switch_country_no_anim");
      paramBundle = paramBundle.saZ;
      if (!bool2) {
        bool1 = true;
      }
      d(paramBundle, bool1);
      AppMethodBeat.o(42420);
      return;
    }
    com.tencent.mm.kernel.g.aeS().a(2641, this);
    paramBundle = new aj();
    com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
    AppMethodBeat.o(42420);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42422);
    com.tencent.mm.kernel.g.aeS().b(2641, this);
    super.onDestroy();
    AppMethodBeat.o(42422);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42424);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      exit();
      AppMethodBeat.o(42424);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(42424);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(42423);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data success");
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42419);
          aj.a(this.rYD);
          if ((this.rYD != null) && (!bt.gL(this.rYD.saZ)))
          {
            GameRouteUI.a(GameRouteUI.this, this.rYD.saZ);
            AppMethodBeat.o(42419);
            return;
          }
          ad.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
          GameRouteUI.a(GameRouteUI.this);
          AppMethodBeat.o(42419);
        }
      });
      AppMethodBeat.o(42423);
      return;
    }
    ad.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data fail");
    exit();
    AppMethodBeat.o(42423);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameRouteUI
 * JD-Core Version:    0.7.0.1
 */