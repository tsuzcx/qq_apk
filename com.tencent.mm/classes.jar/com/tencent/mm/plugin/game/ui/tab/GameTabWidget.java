package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.StatusBar;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.LinkedHashMap;

public class GameTabWidget
  extends LinearLayout
{
  public static int rNk = 0;
  private a IXR;
  private Activity mActivity;
  
  public GameTabWidget(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(42473);
    ci(paramContext);
    AppMethodBeat.o(42473);
  }
  
  public GameTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42474);
    ci(paramContext);
    AppMethodBeat.o(42474);
  }
  
  public GameTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42475);
    ci(paramContext);
    AppMethodBeat.o(42475);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(42479);
    Object localObject;
    if (paramIntent.getComponent() == null)
    {
      localObject = "";
      Log.i("MicroMsg.GameTabWidget", "(%s isActivityExist):%b, hasAnimation:%b, forceFinish:%b, isNative:%b", new Object[] { localObject, Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean4) });
      if ((!paramBoolean3) && (!paramBoolean4)) {
        break label235;
      }
      localObject = "straight to jump";
      label76:
      Log.i("MicroMsg.GameTabWidget", (String)localObject);
      if ((!paramBoolean3) && (paramBoolean4)) {
        ToolsProcessIPCService.a(GameTabWidget.a.class, null);
      }
      if ((!paramBoolean3) && (!paramBoolean4)) {
        break label242;
      }
      rNk = 0;
      paramIntent.addFlags(131072);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/game/ui/tab/GameTabWidget", "turnPage", "(Landroid/app/Activity;Landroid/content/Intent;ZZZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/game/ui/tab/GameTabWidget", "turnPage", "(Landroid/app/Activity;Landroid/content/Intent;ZZZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      if ((paramBoolean2) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing())) {
        paramActivity.finish();
      }
      if (!paramBoolean1) {
        break label340;
      }
      paramActivity.overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
      AppMethodBeat.o(42479);
      return;
      localObject = paramIntent.getComponent().getClassName();
      break;
      label235:
      localObject = "jump to bridge";
      break label76;
      label242:
      localObject = new Intent(paramActivity, GameTabBridgeUI.class);
      ((Intent)localObject).putExtras(paramIntent.getExtras());
      ((Intent)localObject).putExtra("next_tab_component", paramIntent.getComponent());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/game/ui/tab/GameTabWidget", "turnPage", "(Landroid/app/Activity;Landroid/content/Intent;ZZZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/game/ui/tab/GameTabWidget", "turnPage", "(Landroid/app/Activity;Landroid/content/Intent;ZZZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    label340:
    int i = h.a.HSF;
    paramActivity.overridePendingTransition(i, i);
    AppMethodBeat.o(42479);
  }
  
  public static void a(Activity paramActivity, GameTabData.TabItem paramTabItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(42478);
    if ((paramActivity == null) || (paramTabItem == null))
    {
      AppMethodBeat.o(42478);
      return;
    }
    if (c.bb(paramActivity, paramTabItem.jumpUrl))
    {
      AppMethodBeat.o(42478);
      return;
    }
    Object localObject2 = paramActivity.getIntent().getStringExtra("tab_key");
    if (Util.nullAsNil(paramTabItem.IFL).equals(localObject2))
    {
      AppMethodBeat.o(42478);
      return;
    }
    Log.i("MicroMsg.GameTabWidget", "current_page:%s, next_page:%s, hasAnimation:%b", new Object[] { paramActivity.getClass().getSimpleName(), paramTabItem.IFS, Boolean.valueOf(paramBoolean1) });
    Intent localIntent = new Intent();
    localIntent.setClassName(paramActivity, paramTabItem.IFS);
    Object localObject1 = paramActivity.getIntent().getExtras();
    Bundle localBundle;
    boolean bool;
    if (localObject1 != null)
    {
      localIntent.putExtras((Bundle)localObject1);
      localBundle = new Bundle();
      localBundle.putString("tab_key", paramTabItem.IFL);
      localObject1 = (GameTabData)((Bundle)localObject1).getParcelable("tab_data");
      if (localObject1 == null) {
        break label678;
      }
      localObject2 = (GameTabData.TabItem)((GameTabData)localObject1).IFI.get(Util.nullAsNil((String)localObject2));
      if (localObject2 != null) {
        ((GameTabData.TabItem)localObject2).IFT = true;
      }
      localObject2 = (GameTabData.TabItem)((GameTabData)localObject1).IFI.get(paramTabItem.IFL);
      if (localObject2 == null) {
        break label672;
      }
      bool = ((GameTabData.TabItem)localObject2).IFT;
      label240:
      localBundle.putParcelable("tab_data", (Parcelable)localObject1);
    }
    for (;;)
    {
      if (!paramBoolean3) {
        g.a(paramActivity, 18, paramTabItem.hYi, paramTabItem.IFU, 2, null, paramActivity.getIntent().getIntExtra("game_report_from_scene", 0), com.tencent.mm.plugin.game.c.a.EM(paramTabItem.ICw));
      }
      if (!paramTabItem.IFN)
      {
        localBundle.putString("rawUrl", paramTabItem.jumpUrl);
        localBundle.putBoolean("KRightBtn", true);
        localBundle.putBoolean("isWebwx", true);
        localBundle.putBoolean("show_bottom", false);
        localBundle.putString("title", paramActivity.getString(h.i.Icp));
        localBundle.putBoolean("forceHideShare", true);
        localBundle.putBoolean("disable_swipe_back", true);
        localBundle.putBoolean("show_native_web_view", true);
        localBundle.putBoolean("disable_progress_bar", true);
        localBundle.putBoolean("disable_bounce_scroll", true);
        localBundle.putInt("screen_orientation", 1);
        localBundle.putString("KPublisherId", "game_center_entrance");
        localBundle.putInt("geta8key_scene", 32);
        if ((localObject1 != null) && (((GameTabData)localObject1).IFJ != null))
        {
          localBundle.putString("status_bar_style", ((GameTabData)localObject1).IFJ.IFK);
          localBundle.putInt("customize_status_bar_color", ((GameTabData)localObject1).IFJ.color);
        }
        localBundle.putBoolean("game_check_float", paramBoolean3);
        localObject1 = localBundle.getString("rawUrl");
        if (!Util.isNullOrNil((String)localObject1))
        {
          if (!paramBoolean3) {
            break label653;
          }
          paramBoolean3 = localIntent.getBooleanExtra("from_find_more_friend", false);
          int i = localIntent.getIntExtra("game_report_from_scene", 0);
          if (paramBoolean3)
          {
            ((e)h.ax(e.class)).fCg();
            localObject2 = r.fGq();
            localBundle.putString("rawUrl", m.a((String)localObject1, (o)localObject2, null, true));
            if (localObject2 != null)
            {
              ((o)localObject2).fGp();
              if (((o)localObject2).IDI.egT) {
                localBundle.putString("game_transparent_float_url", ((o)localObject2).IDI.url);
              }
              localBundle.putInt("game_sourceScene", i);
            }
          }
        }
      }
      for (;;)
      {
        localIntent.putExtras(localBundle);
        a(paramActivity, localIntent, paramBoolean1, paramBoolean2, bool, paramTabItem.IFN);
        AppMethodBeat.o(42478);
        return;
        localObject1 = new Bundle();
        break;
        label653:
        localBundle.remove("game_transparent_float_url");
        localBundle.remove("game_sourceScene");
      }
      label672:
      bool = false;
      break label240;
      label678:
      bool = false;
    }
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(42476);
    this.mActivity = ((Activity)paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundResource(h.b.HSO);
    setOrientation(0);
    AppMethodBeat.o(42476);
  }
  
  public void setAdapter(a parama)
  {
    AppMethodBeat.i(42477);
    this.IXR = parama;
    parama.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(42470);
        GameTabWidget.a(GameTabWidget.this);
        AppMethodBeat.o(42470);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(42469);
        GameTabWidget.a(GameTabWidget.this);
        AppMethodBeat.o(42469);
      }
    });
    parama.notifyDataSetChanged();
    AppMethodBeat.o(42477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWidget
 * JD-Core Version:    0.7.0.1
 */