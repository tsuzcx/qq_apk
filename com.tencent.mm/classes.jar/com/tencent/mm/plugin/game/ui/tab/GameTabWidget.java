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
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.StatusBar;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.LinkedHashMap;

public class GameTabWidget
  extends LinearLayout
{
  public static int lfZ = 0;
  private a lga;
  private Activity mActivity;
  
  public GameTabWidget(Context paramContext)
  {
    super(paramContext);
    ca(paramContext);
  }
  
  public GameTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ca(paramContext);
  }
  
  public GameTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ca(paramContext);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject;
    if (paramIntent.getComponent() == null)
    {
      localObject = "";
      y.i("MicroMsg.GameTabWidget", "(%s isActivityExist):%b, hasAnimation:%b, forceFinish:%b, isNative:%b", new Object[] { localObject, Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean4) });
      if ((!paramBoolean3) && (!paramBoolean4)) {
        break label171;
      }
      localObject = "straight to jump";
      label71:
      y.i("MicroMsg.GameTabWidget", (String)localObject);
      if ((!paramBoolean3) && (paramBoolean4)) {
        ToolsProcessIPCService.a(null, GameTabWidget.a.class, null);
      }
      if ((!paramBoolean3) && (!paramBoolean4)) {
        break label178;
      }
      lfZ = 0;
      paramIntent.addFlags(131072);
      paramActivity.startActivity(paramIntent);
    }
    for (;;)
    {
      if ((paramBoolean2) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing())) {
        paramActivity.finish();
      }
      if (!paramBoolean1) {
        break label221;
      }
      paramActivity.overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
      return;
      localObject = paramIntent.getComponent().getClassName();
      break;
      label171:
      localObject = "jump to bridge";
      break label71;
      label178:
      localObject = new Intent(paramActivity, GameTabBridgeUI.class);
      ((Intent)localObject).putExtras(paramIntent.getExtras());
      ((Intent)localObject).putExtra("next_tab_component", paramIntent.getComponent());
      paramActivity.startActivity((Intent)localObject);
    }
    label221:
    paramActivity.overridePendingTransition(g.a.in_no_slide, g.a.in_no_slide);
  }
  
  public static void a(Activity paramActivity, GameTabData.TabItem paramTabItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramActivity == null) || (paramTabItem == null)) {}
    Object localObject2;
    do
    {
      do
      {
        return;
      } while (c.ao(paramActivity, paramTabItem.jumpUrl));
      localObject2 = paramActivity.getIntent().getStringExtra("tab_key");
    } while (bk.pm(paramTabItem.kQT).equals(localObject2));
    y.i("MicroMsg.GameTabWidget", "current_page:%s, next_page:%s, hasAnimation:%b", new Object[] { paramActivity.getClass().getSimpleName(), paramTabItem.kRa, Boolean.valueOf(paramBoolean1) });
    Intent localIntent = new Intent();
    localIntent.setClassName(paramActivity, paramTabItem.kRa);
    Object localObject1 = paramActivity.getIntent().getExtras();
    Bundle localBundle;
    boolean bool;
    if (localObject1 != null)
    {
      localIntent.putExtras((Bundle)localObject1);
      localBundle = new Bundle();
      localBundle.putString("tab_key", paramTabItem.kQT);
      localObject1 = (GameTabData)((Bundle)localObject1).getParcelable("tab_data");
      if (localObject1 == null) {
        break label644;
      }
      localObject2 = (GameTabData.TabItem)((GameTabData)localObject1).kQQ.get(bk.pm((String)localObject2));
      if (localObject2 != null) {
        ((GameTabData.TabItem)localObject2).kRb = true;
      }
      localObject2 = (GameTabData.TabItem)((GameTabData)localObject1).kQQ.get(paramTabItem.kQT);
      if (localObject2 == null) {
        break label638;
      }
      bool = ((GameTabData.TabItem)localObject2).kRb;
      label218:
      localBundle.putParcelable("tab_data", (Parcelable)localObject1);
    }
    for (;;)
    {
      if (!paramBoolean3) {
        com.tencent.mm.plugin.game.e.b.a(paramActivity, 18, paramTabItem.bXn, paramTabItem.kRc, 2, null, paramActivity.getIntent().getIntExtra("game_report_from_scene", 0), com.tencent.mm.plugin.game.e.a.fy(paramTabItem.kOo));
      }
      if (!paramTabItem.kQV)
      {
        localBundle.putString("rawUrl", paramTabItem.jumpUrl);
        localBundle.putBoolean("KRightBtn", true);
        localBundle.putBoolean("isWebwx", true);
        localBundle.putBoolean("show_bottom", false);
        localBundle.putString("title", paramActivity.getString(g.i.game_wechat_game));
        localBundle.putBoolean("forceHideShare", true);
        localBundle.putBoolean("disable_swipe_back", true);
        localBundle.putBoolean("show_native_web_view", true);
        localBundle.putBoolean("disable_progress_bar", true);
        localBundle.putBoolean("disable_bounce_scroll", true);
        localBundle.putInt("screen_orientation", 1);
        localBundle.putString("KPublisherId", "game_center_entrance");
        localBundle.putInt("geta8key_scene", 32);
        if ((localObject1 != null) && (((GameTabData)localObject1).kQR != null))
        {
          localBundle.putString("status_bar_style", ((GameTabData)localObject1).kQR.kQS);
          localBundle.putInt("customize_status_bar_color", ((GameTabData)localObject1).kQR.color);
        }
        localBundle.putBoolean("game_check_float", paramBoolean3);
        localObject1 = localBundle.getString("rawUrl");
        if (!bk.bl((String)localObject1))
        {
          if (!paramBoolean3) {
            break label619;
          }
          paramBoolean3 = localIntent.getBooleanExtra("from_find_more_friend", false);
          int i = localIntent.getIntExtra("game_report_from_scene", 0);
          if (paramBoolean3)
          {
            ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
            localObject2 = r.aZp();
            localBundle.putString("rawUrl", m.a((String)localObject1, (o)localObject2));
            if (localObject2 != null)
            {
              ((o)localObject2).aZm();
              if (((o)localObject2).kPu.kPR) {
                localBundle.putString("game_transparent_float_url", ((o)localObject2).kPu.url);
              }
              localBundle.putInt("game_sourceScene", i);
            }
          }
        }
      }
      for (;;)
      {
        localIntent.putExtras(localBundle);
        a(paramActivity, localIntent, paramBoolean1, paramBoolean2, bool, paramTabItem.kQV);
        return;
        localObject1 = new Bundle();
        break;
        label619:
        localBundle.remove("game_transparent_float_url");
        localBundle.remove("game_sourceScene");
      }
      label638:
      bool = false;
      break label218;
      label644:
      bool = false;
    }
  }
  
  private void ca(Context paramContext)
  {
    this.mActivity = ((Activity)paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundResource(g.b.game_tab_bg);
    setOrientation(0);
  }
  
  public void setAdapter(a parama)
  {
    this.lga = parama;
    parama.registerDataSetObserver(new GameTabWidget.1(this));
    parama.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWidget
 * JD-Core Version:    0.7.0.1
 */