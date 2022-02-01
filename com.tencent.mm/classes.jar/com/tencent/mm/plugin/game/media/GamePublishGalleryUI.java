package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class GamePublishGalleryUI
  extends MMActivity
{
  private int IyH;
  private TextViewWithBottomLine Izp;
  private TextViewWithBottomLine Izq;
  private TextView Izr;
  private GameLocalGalleryView Izs;
  private k Izt;
  private ViewPager xUr;
  
  private void init()
  {
    int j = 1;
    AppMethodBeat.i(276805);
    getController().s(this, getResources().getColor(h.b.white));
    this.Izp = ((TextViewWithBottomLine)findViewById(h.e.HWl));
    this.Izp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(0, false);
        GamePublishGalleryUI.c(GamePublishGalleryUI.this).fFp();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41034);
      }
    });
    this.Izq = ((TextViewWithBottomLine)findViewById(h.e.HVZ));
    this.Izq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(1, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41035);
      }
    });
    this.Izp.setSelected(true);
    this.Izq.setSelected(false);
    this.Izr = ((TextView)findViewById(h.e.HVt));
    this.Izr.setOnClickListener(new GamePublishGalleryUI.3(this));
    this.xUr = ((ViewPager)findViewById(h.e.HWJ));
    ArrayList localArrayList = new ArrayList();
    int k = getIntent().getIntExtra("query_media_type", 3);
    boolean bool1 = getIntent().getBooleanExtra("game_haowan_force_select", false);
    boolean bool2 = getIntent().getBooleanExtra("game_straight_to_publish", false);
    this.IyH = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    GameGalleryFragment localGameGalleryFragment = new GameGalleryFragment();
    int i = a.fFh();
    Object localObject1;
    if (k == 1)
    {
      localGameGalleryFragment.mView = new FrameLayout(this);
      i = j;
      localArrayList.add(localGameGalleryFragment);
      localObject1 = new GameGalleryFragment();
      this.Izs = new GameLocalGalleryView(this);
      this.Izs.d(bool1, bool2, this.IyH);
      this.Izs.setQueryType(k);
      this.Izs.setSelectLimitCount(getIntent().getIntExtra("max_select_count", 9));
      ((GameGalleryFragment)localObject1).mView = this.Izs;
      localArrayList.add(localObject1);
      localObject1 = new i(getSupportFragmentManager(), localArrayList);
      this.xUr.setAdapter((androidx.viewpager.widget.a)localObject1);
      this.xUr.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            GamePublishGalleryUI.c(GamePublishGalleryUI.this).fFp();
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
      AppMethodBeat.o(276805);
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
      label401:
      this.Izt = new k(this);
      boolean bool3 = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
      this.Izt.c(bool3, bool1, bool2, this.IyH);
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
            localObject2 = com.tencent.mm.plugin.game.commlib.a.fEa();
          }
          this.Izt.setLocalAlbumInfos((JSONArray)localObject2);
          this.Izt.setBackgroundColor(getResources().getColor(h.b.white));
          localGameGalleryFragment.mView = this.Izt;
        }
        catch (JSONException localJSONException) {}
        if (i != 2) {
          break label555;
        }
        i = 1;
        break label401;
      }
      label555:
      i = 0;
    }
  }
  
  public final void fFv()
  {
    AppMethodBeat.i(41044);
    if ((a.fFh() == 0) && (this.xUr.getCurrentItem() % 2 == 0)) {
      setCurrentItem(1, false);
    }
    AppMethodBeat.o(41044);
  }
  
  public int getLayoutId()
  {
    return h.f.HZB;
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
    label108:
    Object localObject;
    if (this.Izs != null)
    {
      localGameLocalGalleryView = this.Izs;
      if (paramInt1 == GameLocalGalleryView.IyZ)
      {
        if (paramInt2 == -1)
        {
          GameLocalGalleryView.fFq();
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
          if (paramInt1 == GameLocalGalleryView.Iza) {
            switch (paramInt2)
            {
            default: 
              i = 1;
              break;
            case -1: 
              GameLocalGalleryView.fFq();
              if (paramIntent != null) {
                break label417;
              }
              localObject = new Intent();
              ((Intent)localObject).putStringArrayListExtra("CropImage_OutputPath_List", localGameLocalGalleryView.Izc.fBk());
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
      break label108;
      if (paramIntent == null) {
        break label108;
      }
      localObject = paramIntent.getStringArrayListExtra("preview_image_list");
      if ((localObject == null) || (localGameLocalGalleryView.Izc == null)) {
        break label108;
      }
      localGameLocalGalleryView.Izc.aP((ArrayList)localObject);
      break label108;
      Log.e("MicroMsg.GameLocalMediaView", "WTF!!!");
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label108;
      i = 0;
      break;
      if (this.Izt != null)
      {
        localObject = this.Izt;
        if (paramInt1 == (localObject.hashCode() & 0xFFFF))
        {
          if (paramInt2 == -1)
          {
            k.fFq();
            if (((k)localObject).IzA != null)
            {
              if (paramIntent.hasExtra("key_game_video_appid")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).IzA.appId);
              }
              if (paramIntent.hasExtra("key_game_video_appname")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).IzA.appName);
              }
              paramIntent.putExtra("key_game_trans_info", ((k)localObject).IzA.Idp);
            }
            ((Activity)((k)localObject).getContext()).setResult(-1, paramIntent);
            ((Activity)((k)localObject).getContext()).finish();
          }
          ((k)localObject).IzA = null;
        }
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          AppMethodBeat.o(41042);
          return;
        }
      }
      AppMethodBeat.o(41042);
      return;
      label417:
      localObject = paramIntent;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41038);
    super.onCreate(paramBundle);
    getString(b.i.permission_tips_title);
    paramBundle = getString(h.i.IaY);
    if (com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, paramBundle)) {
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
  
  public void onDestroy()
  {
    AppMethodBeat.i(276815);
    super.onDestroy();
    if (this.Izs != null)
    {
      GameLocalGalleryView localGameLocalGalleryView = this.Izs;
      com.tencent.mm.plugin.gallery.model.e.fAn().b(localGameLocalGalleryView);
    }
    AppMethodBeat.o(276815);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41040);
    super.onPause();
    f.d(false, true, true);
    AppMethodBeat.o(41040);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(276823);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.GamePublishGalleryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(276823);
      return;
    }
    Log.i("MicroMsg.GamePublishGalleryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(276823);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(276823);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(h.i.IbI), getString(h.i.permission_tips_title), getString(h.i.jump_to_settings), getString(h.i.gallery_cancel), false, new GamePublishGalleryUI.5(this), new GamePublishGalleryUI.6(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41039);
    super.onResume();
    f.d(true, true, true);
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
    if ((paramInt % 2 == 0) && (this.Izt != null))
    {
      this.Izt.fFo();
      this.xUr.setCurrentItem(paramInt);
      if (paramBoolean) {
        if (paramInt % 2 != 0) {
          break label90;
        }
      }
    }
    label90:
    for (paramInt = 8762;; paramInt = 8767)
    {
      com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), paramInt, 0, 2, this.IyH, com.tencent.mm.game.report.b.a.a(7, new HashMap()));
      AppMethodBeat.o(41043);
      return;
      this.Izs.fFo();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GamePublishGalleryUI
 * JD-Core Version:    0.7.0.1
 */