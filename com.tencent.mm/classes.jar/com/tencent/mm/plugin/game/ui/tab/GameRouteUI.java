package com.tencent.mm.plugin.game.ui.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.protobuf.ay;
import com.tencent.mm.plugin.game.protobuf.bs;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.game.protobuf.ay;>;

@com.tencent.mm.ui.base.a(19)
public class GameRouteUI
  extends GameCenterActivity
  implements com.tencent.mm.am.h
{
  private int IFc;
  
  private void exit()
  {
    AppMethodBeat.i(42425);
    if ((!isFinishing()) && (!isDestroyed()))
    {
      finish();
      overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
    }
    AppMethodBeat.o(42425);
  }
  
  /* Error */
  private static bs fHS()
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 71
    //   7: invokestatic 77	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   10: checkcast 71	com/tencent/mm/plugin/game/api/f
    //   13: invokeinterface 81 1 0
    //   18: ldc 83
    //   20: invokevirtual 89	com/tencent/mm/plugin/game/model/w:aFI	(Ljava/lang/String;)[B
    //   23: astore_1
    //   24: aload_1
    //   25: invokestatic 95	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   28: ifeq +10 -> 38
    //   31: ldc 69
    //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: new 97	com/tencent/mm/plugin/game/protobuf/bs
    //   41: dup
    //   42: invokespecial 98	com/tencent/mm/plugin/game/protobuf/bs:<init>	()V
    //   45: astore_0
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 102	com/tencent/mm/plugin/game/protobuf/bs:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   51: pop
    //   52: ldc 69
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
    //   45	13	0	localbs	bs
    //   59	1	0	localIOException1	java.io.IOException
    //   61	1	0	localObject	Object
    //   23	25	1	arrayOfByte	byte[]
    //   65	1	1	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   38	46	59	java/io/IOException
    //   46	52	65	java/io/IOException
  }
  
  private void u(List<ay> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(42426);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(42426);
      return;
    }
    GameTabData localGameTabData = GameTabData.is(paramList);
    if ((localGameTabData == null) || (Util.isNullOrNil(localGameTabData.aVf())))
    {
      Log.e("MicroMsg.GameRouteUI", "game tab data is null");
      exit();
      AppMethodBeat.o(42426);
      return;
    }
    Object localObject2 = localGameTabData.aVf();
    paramList = null;
    int i = 0;
    Object localObject1;
    if (i < ((List)localObject2).size())
    {
      localObject1 = (GameTabData.TabItem)((List)localObject2).get(i);
      if (localObject1 == null) {
        break label253;
      }
      if (!((GameTabData.TabItem)localObject1).IFM) {
        break label250;
      }
      paramList = (List<ay>)localObject1;
      label115:
      com.tencent.mm.plugin.game.c.a.b(this, 18, ((GameTabData.TabItem)localObject1).hYi, ((GameTabData.TabItem)localObject1).IFU, null, this.IFc, com.tencent.mm.plugin.game.c.a.EM(((GameTabData.TabItem)localObject1).ICw));
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
        Log.e("MicroMsg.GameRouteUI", "game tab entry item is null");
        exit();
        AppMethodBeat.o(42426);
        return;
      }
      localObject2 = getIntent().getExtras();
      paramList = (List<ay>)localObject2;
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
  
  public final boolean fHl()
  {
    return false;
  }
  
  public final int fHm()
  {
    return 0;
  }
  
  public final int fHn()
  {
    return 0;
  }
  
  public final String fHo()
  {
    return null;
  }
  
  public final String fHp()
  {
    return null;
  }
  
  public int getLayoutId()
  {
    return h.f.Iag;
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
    setMMTitle(h.i.Icp);
    AppMethodBeat.o(42421);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = false;
    AppMethodBeat.i(42420);
    super.onCreate(paramBundle);
    initView();
    this.IFc = getIntent().getIntExtra("game_report_from_scene", 0);
    paramBundle = fHS();
    if ((paramBundle != null) && (!Util.isNullOrNil(paramBundle.IIU)))
    {
      Log.i("MicroMsg.GameRouteUI", "use cache data");
      aj.dCn();
      boolean bool2 = getIntent().getBooleanExtra("switch_country_no_anim", false);
      getIntent().removeExtra("switch_country_no_anim");
      paramBundle = paramBundle.IIU;
      if (!bool2) {
        bool1 = true;
      }
      u(paramBundle, bool1);
      AppMethodBeat.o(42420);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(2641, this);
    paramBundle = new aj();
    com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    AppMethodBeat.o(42420);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42422);
    com.tencent.mm.kernel.h.aZW().b(2641, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(42423);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data success");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42419);
          aj.a(this.IFW);
          if ((this.IFW != null) && (!Util.isNullOrNil(this.IFW.IIU)))
          {
            GameRouteUI.a(GameRouteUI.this, this.IFW.IIU);
            AppMethodBeat.o(42419);
            return;
          }
          Log.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
          GameRouteUI.a(GameRouteUI.this);
          AppMethodBeat.o(42419);
        }
      });
      AppMethodBeat.o(42423);
      return;
    }
    Log.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data fail");
    exit();
    AppMethodBeat.o(42423);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameRouteUI
 * JD-Core Version:    0.7.0.1
 */