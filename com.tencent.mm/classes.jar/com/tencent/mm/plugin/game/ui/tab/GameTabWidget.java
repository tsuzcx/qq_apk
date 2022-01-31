package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.StatusBar;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.a;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.LinkedHashMap;

public class GameTabWidget
  extends LinearLayout
{
  public static int nDU = 0;
  private Activity mActivity;
  private a nDV;
  
  public GameTabWidget(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(112275);
    aA(paramContext);
    AppMethodBeat.o(112275);
  }
  
  public GameTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112276);
    aA(paramContext);
    AppMethodBeat.o(112276);
  }
  
  public GameTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112277);
    aA(paramContext);
    AppMethodBeat.o(112277);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(112281);
    Object localObject;
    if (paramIntent.getComponent() == null)
    {
      localObject = "";
      ab.i("MicroMsg.GameTabWidget", "(%s isActivityExist):%b, hasAnimation:%b, forceFinish:%b, isNative:%b", new Object[] { localObject, Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean4) });
      if ((!paramBoolean3) && (!paramBoolean4)) {
        break label181;
      }
      localObject = "straight to jump";
      label76:
      ab.i("MicroMsg.GameTabWidget", (String)localObject);
      if ((!paramBoolean3) && (paramBoolean4)) {
        ToolsProcessIPCService.a(null, GameTabWidget.a.class, null);
      }
      if ((!paramBoolean3) && (!paramBoolean4)) {
        break label188;
      }
      nDU = 0;
      paramIntent.addFlags(131072);
      paramActivity.startActivity(paramIntent);
    }
    for (;;)
    {
      if ((paramBoolean2) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing())) {
        paramActivity.finish();
      }
      if (!paramBoolean1) {
        break label231;
      }
      paramActivity.overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
      AppMethodBeat.o(112281);
      return;
      localObject = paramIntent.getComponent().getClassName();
      break;
      label181:
      localObject = "jump to bridge";
      break label76;
      label188:
      localObject = new Intent(paramActivity, GameTabBridgeUI.class);
      ((Intent)localObject).putExtras(paramIntent.getExtras());
      ((Intent)localObject).putExtra("next_tab_component", paramIntent.getComponent());
      paramActivity.startActivity((Intent)localObject);
    }
    label231:
    paramActivity.overridePendingTransition(2131034195, 2131034195);
    AppMethodBeat.o(112281);
  }
  
  public static void a(Activity paramActivity, GameTabData.TabItem paramTabItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(112280);
    if ((paramActivity == null) || (paramTabItem == null))
    {
      AppMethodBeat.o(112280);
      return;
    }
    if (com.tencent.mm.plugin.game.f.c.ay(paramActivity, paramTabItem.jumpUrl))
    {
      AppMethodBeat.o(112280);
      return;
    }
    Object localObject2 = paramActivity.getIntent().getStringExtra("tab_key");
    if (bo.nullAsNil(paramTabItem.noX).equals(localObject2))
    {
      AppMethodBeat.o(112280);
      return;
    }
    ab.i("MicroMsg.GameTabWidget", "current_page:%s, next_page:%s, hasAnimation:%b", new Object[] { paramActivity.getClass().getSimpleName(), paramTabItem.npe, Boolean.valueOf(paramBoolean1) });
    Intent localIntent = new Intent();
    localIntent.setClassName(paramActivity, paramTabItem.npe);
    Object localObject1 = paramActivity.getIntent().getExtras();
    Bundle localBundle;
    boolean bool;
    if (localObject1 != null)
    {
      localIntent.putExtras((Bundle)localObject1);
      localBundle = new Bundle();
      localBundle.putString("tab_key", paramTabItem.noX);
      localObject1 = (GameTabData)((Bundle)localObject1).getParcelable("tab_data");
      if (localObject1 == null) {
        break label703;
      }
      localObject2 = (GameTabData.TabItem)((GameTabData)localObject1).noU.get(bo.nullAsNil((String)localObject2));
      if (localObject2 != null) {
        ((GameTabData.TabItem)localObject2).npf = true;
      }
      localObject2 = (GameTabData.TabItem)((GameTabData)localObject1).noU.get(paramTabItem.noX);
      if (localObject2 == null) {
        break label697;
      }
      bool = ((GameTabData.TabItem)localObject2).npf;
      label240:
      localBundle.putParcelable("tab_data", (Parcelable)localObject1);
    }
    for (;;)
    {
      if (!paramBoolean3) {
        com.tencent.mm.game.report.c.a(paramActivity, 18, paramTabItem.cFj, paramTabItem.npg, 2, null, paramActivity.getIntent().getIntExtra("game_report_from_scene", 0), com.tencent.mm.plugin.game.e.a.lR(paramTabItem.nml));
      }
      if (!paramTabItem.noZ)
      {
        localBundle.putString("rawUrl", paramTabItem.jumpUrl);
        localBundle.putBoolean("KRightBtn", true);
        localBundle.putBoolean("isWebwx", true);
        localBundle.putBoolean("show_bottom", false);
        localBundle.putString("title", paramActivity.getString(2131300478));
        localBundle.putBoolean("forceHideShare", true);
        localBundle.putBoolean("disable_swipe_back", true);
        localBundle.putBoolean("show_native_web_view", true);
        localBundle.putBoolean("disable_progress_bar", true);
        localBundle.putBoolean("disable_bounce_scroll", true);
        localBundle.putInt("screen_orientation", 1);
        localBundle.putString("KPublisherId", "game_center_entrance");
        localBundle.putInt("geta8key_scene", 32);
        if ((localObject1 != null) && (((GameTabData)localObject1).noV != null))
        {
          localBundle.putString("status_bar_style", ((GameTabData)localObject1).noV.noW);
          localBundle.putInt("customize_status_bar_color", ((GameTabData)localObject1).noV.color);
        }
        localBundle.putBoolean("game_check_float", paramBoolean3);
        String str = localBundle.getString("rawUrl");
        if (!bo.isNullOrNil(str))
        {
          if (!paramBoolean3) {
            break label678;
          }
          paramBoolean3 = localIntent.getBooleanExtra("from_find_more_friend", false);
          int i = localIntent.getIntExtra("game_report_from_scene", 0);
          if (paramBoolean3)
          {
            ((d)g.E(d.class)).bER();
            localObject2 = q.bGp();
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              ((d)g.E(d.class)).bER();
              localObject1 = q.bGt();
            }
            localBundle.putString("rawUrl", l.a(str, (n)localObject1));
            if (localObject1 != null)
            {
              ((n)localObject1).bGm();
              if (((n)localObject1).nnq.nnQ) {
                localBundle.putString("game_transparent_float_url", ((n)localObject1).nnq.url);
              }
              localBundle.putInt("game_sourceScene", i);
            }
          }
        }
      }
      for (;;)
      {
        localIntent.putExtras(localBundle);
        a(paramActivity, localIntent, paramBoolean1, paramBoolean2, bool, paramTabItem.noZ);
        AppMethodBeat.o(112280);
        return;
        localObject1 = new Bundle();
        break;
        label678:
        localBundle.remove("game_transparent_float_url");
        localBundle.remove("game_sourceScene");
      }
      label697:
      bool = false;
      break label240;
      label703:
      bool = false;
    }
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(112278);
    this.mActivity = ((Activity)paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundResource(2131690105);
    setOrientation(0);
    AppMethodBeat.o(112278);
  }
  
  public void setAdapter(a parama)
  {
    AppMethodBeat.i(112279);
    this.nDV = parama;
    parama.registerDataSetObserver(new GameTabWidget.1(this));
    parama.notifyDataSetChanged();
    AppMethodBeat.o(112279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWidget
 * JD-Core Version:    0.7.0.1
 */