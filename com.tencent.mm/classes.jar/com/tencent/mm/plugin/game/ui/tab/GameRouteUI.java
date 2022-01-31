package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.game.d.al;>;

@com.tencent.mm.ui.base.a(19)
public class GameRouteUI
  extends GameCenterActivity
  implements f
{
  private int nok;
  
  /* Error */
  private static bg bHw()
  {
    // Byte code:
    //   0: ldc 42
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 44
    //   7: invokestatic 50	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   10: checkcast 44	com/tencent/mm/plugin/game/api/e
    //   13: invokeinterface 54 1 0
    //   18: ldc 56
    //   20: invokevirtual 62	com/tencent/mm/plugin/game/model/w:PN	(Ljava/lang/String;)[B
    //   23: astore_1
    //   24: aload_1
    //   25: invokestatic 68	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   28: ifeq +10 -> 38
    //   31: ldc 42
    //   33: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: new 70	com/tencent/mm/plugin/game/d/bg
    //   41: dup
    //   42: invokespecial 71	com/tencent/mm/plugin/game/d/bg:<init>	()V
    //   45: astore_0
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 75	com/tencent/mm/plugin/game/d/bg:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   51: pop
    //   52: ldc 42
    //   54: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void c(List<com.tencent.mm.plugin.game.d.al> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(112228);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(112228);
      return;
    }
    GameTabData localGameTabData = GameTabData.ca(paramList);
    if ((localGameTabData == null) || (bo.es(localGameTabData.getItemList())))
    {
      ab.e("MicroMsg.GameRouteUI", "game tab data is null");
      exit();
      AppMethodBeat.o(112228);
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
      if (!((GameTabData.TabItem)localObject1).noY) {
        break label250;
      }
      paramList = (List<com.tencent.mm.plugin.game.d.al>)localObject1;
      label115:
      com.tencent.mm.plugin.game.e.a.a(this, 18, ((GameTabData.TabItem)localObject1).cFj, ((GameTabData.TabItem)localObject1).npg, null, this.nok, com.tencent.mm.plugin.game.e.a.lR(((GameTabData.TabItem)localObject1).nml));
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
        ab.e("MicroMsg.GameRouteUI", "game tab entry item is null");
        exit();
        AppMethodBeat.o(112228);
        return;
      }
      localObject2 = getIntent().getExtras();
      paramList = (List<com.tencent.mm.plugin.game.d.al>)localObject2;
      if (localObject2 == null) {
        paramList = new Bundle();
      }
      paramList.putParcelable("tab_data", localGameTabData);
      getIntent().putExtras(paramList);
      GameTabWidget.a(this, (GameTabData.TabItem)localObject1, paramBoolean, true, true);
      AppMethodBeat.o(112228);
      return;
      break label115;
    }
  }
  
  private void exit()
  {
    AppMethodBeat.i(112227);
    if ((!isFinishing()) && (!isDestroyed()))
    {
      finish();
      overridePendingTransition(MMFragmentActivity.a.zbZ, MMFragmentActivity.a.zca);
    }
    AppMethodBeat.o(112227);
  }
  
  public final boolean bHf()
  {
    return false;
  }
  
  public final int bHg()
  {
    return 0;
  }
  
  public final int bHh()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2130969811;
  }
  
  public final int getScene()
  {
    return 0;
  }
  
  public void initView()
  {
    AppMethodBeat.i(112223);
    setBackBtn(new GameRouteUI.1(this));
    setMMTitle(2131300478);
    AppMethodBeat.o(112223);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = false;
    AppMethodBeat.i(112222);
    super.onCreate(paramBundle);
    initView();
    this.nok = getIntent().getIntExtra("game_report_from_scene", 0);
    paramBundle = bHw();
    if ((paramBundle != null) && (!bo.es(paramBundle.nrw)))
    {
      ab.i("MicroMsg.GameRouteUI", "use cache data");
      aj.updateData();
      boolean bool2 = getIntent().getBooleanExtra("switch_country_no_anim", false);
      getIntent().removeExtra("switch_country_no_anim");
      paramBundle = paramBundle.nrw;
      if (!bool2) {
        bool1 = true;
      }
      c(paramBundle, bool1);
      AppMethodBeat.o(112222);
      return;
    }
    g.Rc().a(2641, this);
    paramBundle = new aj();
    g.Rc().a(paramBundle, 0);
    AppMethodBeat.o(112222);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112224);
    g.Rc().b(2641, this);
    super.onDestroy();
    AppMethodBeat.o(112224);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(112226);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      exit();
      AppMethodBeat.o(112226);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(112226);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(112225);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data success");
      com.tencent.mm.sdk.platformtools.al.d(new GameRouteUI.2(this, ((aj)paramm).bGU()));
      AppMethodBeat.o(112225);
      return;
    }
    ab.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data fail");
    exit();
    AppMethodBeat.o(112225);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameRouteUI
 * JD-Core Version:    0.7.0.1
 */