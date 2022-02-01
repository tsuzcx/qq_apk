package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class GamePublishGalleryUI
  extends MMActivity
{
  private ViewPager riH;
  private int xAD;
  private TextViewWithBottomLine xBk;
  private TextViewWithBottomLine xBl;
  private TextView xBm;
  private GameLocalGalleryView xBn;
  private k xBo;
  
  private void init()
  {
    int j = 1;
    AppMethodBeat.i(204118);
    getController().p(this, getResources().getColor(2131101424));
    this.xBk = ((TextViewWithBottomLine)findViewById(2131302050));
    this.xBk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(0, false);
        GamePublishGalleryUI.c(GamePublishGalleryUI.this).dUm();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41034);
      }
    });
    this.xBl = ((TextViewWithBottomLine)findViewById(2131302030));
    this.xBl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(1, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41035);
      }
    });
    this.xBk.setSelected(true);
    this.xBl.setSelected(false);
    this.xBm = ((TextView)findViewById(2131301975));
    this.xBm.setOnClickListener(new GamePublishGalleryUI.3(this));
    this.riH = ((ViewPager)findViewById(2131302098));
    ArrayList localArrayList = new ArrayList();
    int k = getIntent().getIntExtra("query_media_type", 3);
    boolean bool1 = getIntent().getBooleanExtra("game_haowan_force_select", false);
    boolean bool2 = getIntent().getBooleanExtra("game_straight_to_publish", false);
    this.xAD = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    GameGalleryFragment localGameGalleryFragment = new GameGalleryFragment();
    int i = a.dUd();
    Object localObject1;
    if (k == 1)
    {
      localGameGalleryFragment.mView = new FrameLayout(this);
      i = j;
      localArrayList.add(localGameGalleryFragment);
      localObject1 = new GameGalleryFragment();
      this.xBn = new GameLocalGalleryView(this);
      this.xBn.c(bool1, bool2, this.xAD);
      this.xBn.setQueryType(k);
      this.xBn.setSelectLimitCount(getIntent().getIntExtra("max_select_count", 9));
      ((GameGalleryFragment)localObject1).mView = this.xBn;
      localArrayList.add(localObject1);
      localObject1 = new i(getSupportFragmentManager(), localArrayList);
      this.riH.setAdapter((q)localObject1);
      this.riH.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(41037);
          if (paramAnonymousInt % 2 == 0)
          {
            GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(true);
            GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(false);
            GamePublishGalleryUI.c(GamePublishGalleryUI.this).dUm();
          }
          for (;;)
          {
            GamePublishGalleryUI.this.setCurrentItem(paramAnonymousInt, true);
            AppMethodBeat.o(41037);
            return;
            GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(true);
            GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(false);
          }
        }
      });
      setCurrentItem(i, false);
      AppMethodBeat.o(204118);
      return;
    }
    j = getIntent().getIntExtra("game_media_default_type", 0);
    if ((j == 1) || (j == 2)) {
      i = j;
    }
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      label396:
      this.xBo = new k(this);
      boolean bool3 = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
      this.xBo.c(bool3, bool1, bool2, this.xAD);
      Object localObject2 = getIntent().getStringExtra("game_haowan_local_albums_info");
      localObject1 = new JSONArray();
      if (!Util.isNullOrNil((String)localObject2)) {}
      for (;;)
      {
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (((JSONArray)localObject1).length() == 0) {
            localObject2 = com.tencent.mm.plugin.game.commlib.a.dTc();
          }
          this.xBo.setLocalAlbumInfos((JSONArray)localObject2);
          this.xBo.setBackgroundColor(getResources().getColor(2131101424));
          localGameGalleryFragment.mView = this.xBo;
        }
        catch (JSONException localJSONException) {}
        if (i != 2) {
          break label549;
        }
        i = 1;
        break label396;
      }
      label549:
      i = 0;
    }
  }
  
  public final void dUs()
  {
    AppMethodBeat.i(41044);
    if ((a.dUd() == 0) && (this.riH.getCurrentItem() % 2 == 0)) {
      setCurrentItem(1, false);
    }
    AppMethodBeat.o(41044);
  }
  
  public int getLayoutId()
  {
    return 2131494881;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41042);
    GameLocalGalleryView localGameLocalGalleryView;
    int i;
    label104:
    Object localObject;
    if (this.xBn != null)
    {
      localGameLocalGalleryView = this.xBn;
      if (paramInt1 == GameLocalGalleryView.xAV)
      {
        if (paramInt2 == -1)
        {
          GameLocalGalleryView.dUn();
          ((Activity)localGameLocalGalleryView.getContext()).setResult(-1, paramIntent);
          ((Activity)localGameLocalGalleryView.getContext()).finish();
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          AppMethodBeat.o(41042);
          return;
          if (paramInt1 == GameLocalGalleryView.xAW) {
            switch (paramInt2)
            {
            default: 
              i = 1;
              break;
            case -1: 
              GameLocalGalleryView.dUn();
              if (paramIntent != null) {
                break label411;
              }
              localObject = new Intent();
              ((Intent)localObject).putStringArrayListExtra("CropImage_OutputPath_List", localGameLocalGalleryView.xAY.dRL());
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.GameLocalMediaView", "onActivity Result ok");
      ((Activity)localGameLocalGalleryView.getContext()).setResult(-1, (Intent)localObject);
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label104;
      if (paramIntent == null) {
        break label104;
      }
      localObject = paramIntent.getStringArrayListExtra("preview_image_list");
      if ((localObject == null) || (localGameLocalGalleryView.xAY == null)) {
        break label104;
      }
      localGameLocalGalleryView.xAY.aq((ArrayList)localObject);
      break label104;
      Log.e("MicroMsg.GameLocalMediaView", "WTF!!!");
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label104;
      i = 0;
      break;
      if (this.xBo != null)
      {
        localObject = this.xBo;
        if (paramInt1 == (localObject.hashCode() & 0xFFFF))
        {
          if (paramInt2 == -1)
          {
            k.dUn();
            if (((k)localObject).xBv != null)
            {
              if (paramIntent.hasExtra("key_game_video_appid")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).xBv.appId);
              }
              if (paramIntent.hasExtra("key_game_video_appname")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).xBv.appName);
              }
              paramIntent.putExtra("key_game_trans_info", ((k)localObject).xBv.xuP);
            }
            ((Activity)((k)localObject).getContext()).setResult(-1, paramIntent);
            ((Activity)((k)localObject).getContext()).finish();
          }
          ((k)localObject).xBv = null;
        }
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          AppMethodBeat.o(41042);
          return;
        }
      }
      AppMethodBeat.o(41042);
      return;
      label411:
      localObject = paramIntent;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41038);
    super.onCreate(paramBundle);
    paramBundle = getString(2131763890);
    String str = getString(2131761221);
    if (com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, paramBundle, str)) {
      init();
    }
    AppMethodBeat.o(41038);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(41041);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    AppMethodBeat.o(41041);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41040);
    super.onPause();
    f.e(false, true, true);
    AppMethodBeat.o(41040);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(204119);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.GamePublishGalleryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(204119);
      return;
    }
    Log.i("MicroMsg.GamePublishGalleryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204119);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(204119);
        return;
      }
      h.a(this, getString(2131761322), getString(2131763890), getString(2131762043), getString(2131761084), false, new GamePublishGalleryUI.5(this), new GamePublishGalleryUI.6(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41039);
    super.onResume();
    f.e(true, true, true);
    AppMethodBeat.o(41039);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41043);
    if ((paramInt % 2 == 0) && (this.xBo != null))
    {
      this.xBo.dUl();
      this.riH.setCurrentItem(paramInt);
      if (paramBoolean) {
        if (paramInt % 2 != 0) {
          break label90;
        }
      }
    }
    label90:
    for (paramInt = 8762;; paramInt = 8767)
    {
      com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), paramInt, 0, 2, this.xAD, com.tencent.mm.game.report.b.a.c(7, new HashMap()));
      AppMethodBeat.o(41043);
      return;
      this.xBn.dUl();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GamePublishGalleryUI
 * JD-Core Version:    0.7.0.1
 */