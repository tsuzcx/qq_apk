package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class GamePublishGalleryUI
  extends MMActivity
{
  private int CEE;
  private TextViewWithBottomLine CFl;
  private TextViewWithBottomLine CFm;
  private TextView CFn;
  private GameLocalGalleryView CFo;
  private k CFp;
  private ViewPager uLQ;
  
  private void init()
  {
    int j = 1;
    AppMethodBeat.i(200607);
    getController().q(this, getResources().getColor(g.b.white));
    this.CFl = ((TextViewWithBottomLine)findViewById(g.e.Ckd));
    this.CFl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(0, false);
        GamePublishGalleryUI.c(GamePublishGalleryUI.this).ext();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41034);
      }
    });
    this.CFm = ((TextViewWithBottomLine)findViewById(g.e.CjR));
    this.CFm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(1, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41035);
      }
    });
    this.CFl.setSelected(true);
    this.CFm.setSelected(false);
    this.CFn = ((TextView)findViewById(g.e.Cjl));
    this.CFn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        GamePublishGalleryUI.this.setResult(0);
        GamePublishGalleryUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41036);
      }
    });
    this.uLQ = ((ViewPager)findViewById(g.e.CkB));
    ArrayList localArrayList = new ArrayList();
    int k = getIntent().getIntExtra("query_media_type", 3);
    boolean bool1 = getIntent().getBooleanExtra("game_haowan_force_select", false);
    boolean bool2 = getIntent().getBooleanExtra("game_straight_to_publish", false);
    this.CEE = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    GameGalleryFragment localGameGalleryFragment = new GameGalleryFragment();
    int i = a.exk();
    Object localObject1;
    if (k == 1)
    {
      localGameGalleryFragment.mView = new FrameLayout(this);
      i = j;
      localArrayList.add(localGameGalleryFragment);
      localObject1 = new GameGalleryFragment();
      this.CFo = new GameLocalGalleryView(this);
      this.CFo.c(bool1, bool2, this.CEE);
      this.CFo.setQueryType(k);
      this.CFo.setSelectLimitCount(getIntent().getIntExtra("max_select_count", 9));
      ((GameGalleryFragment)localObject1).mView = this.CFo;
      localArrayList.add(localObject1);
      localObject1 = new i(getSupportFragmentManager(), localArrayList);
      this.uLQ.setAdapter((androidx.viewpager.widget.a)localObject1);
      this.uLQ.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            GamePublishGalleryUI.c(GamePublishGalleryUI.this).ext();
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
      AppMethodBeat.o(200607);
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
      this.CFp = new k(this);
      boolean bool3 = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
      this.CFp.c(bool3, bool1, bool2, this.CEE);
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
            localObject2 = com.tencent.mm.plugin.game.commlib.a.ewl();
          }
          this.CFp.setLocalAlbumInfos((JSONArray)localObject2);
          this.CFp.setBackgroundColor(getResources().getColor(g.b.white));
          localGameGalleryFragment.mView = this.CFp;
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
  
  public final void exz()
  {
    AppMethodBeat.i(41044);
    if ((a.exk() == 0) && (this.uLQ.getCurrentItem() % 2 == 0)) {
      setCurrentItem(1, false);
    }
    AppMethodBeat.o(41044);
  }
  
  public int getLayoutId()
  {
    return g.f.Cnt;
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
    if (this.CFo != null)
    {
      localGameLocalGalleryView = this.CFo;
      if (paramInt1 == GameLocalGalleryView.CEW)
      {
        if (paramInt2 == -1)
        {
          GameLocalGalleryView.exu();
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
          if (paramInt1 == GameLocalGalleryView.CEX) {
            switch (paramInt2)
            {
            default: 
              i = 1;
              break;
            case -1: 
              GameLocalGalleryView.exu();
              if (paramIntent != null) {
                break label417;
              }
              localObject = new Intent();
              ((Intent)localObject).putStringArrayListExtra("CropImage_OutputPath_List", localGameLocalGalleryView.CEZ.eun());
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
      if ((localObject == null) || (localGameLocalGalleryView.CEZ == null)) {
        break label108;
      }
      localGameLocalGalleryView.CEZ.aw((ArrayList)localObject);
      break label108;
      Log.e("MicroMsg.GameLocalMediaView", "WTF!!!");
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label108;
      i = 0;
      break;
      if (this.CFp != null)
      {
        localObject = this.CFp;
        if (paramInt1 == (localObject.hashCode() & 0xFFFF))
        {
          if (paramInt2 == -1)
          {
            k.exu();
            if (((k)localObject).CFw != null)
            {
              if (paramIntent.hasExtra("key_game_video_appid")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).CFw.appId);
              }
              if (paramIntent.hasExtra("key_game_video_appname")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).CFw.appName);
              }
              paramIntent.putExtra("key_game_trans_info", ((k)localObject).CFw.Cri);
            }
            ((Activity)((k)localObject).getContext()).setResult(-1, paramIntent);
            ((Activity)((k)localObject).getContext()).finish();
          }
          ((k)localObject).CFw = null;
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
    paramBundle = getString(b.i.permission_tips_title);
    String str = getString(g.i.CoQ);
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
  
  public void onDestroy()
  {
    AppMethodBeat.i(292938);
    super.onDestroy();
    GameLocalGalleryView localGameLocalGalleryView = this.CFo;
    com.tencent.mm.plugin.gallery.model.e.etl().b(localGameLocalGalleryView);
    AppMethodBeat.o(292938);
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
    AppMethodBeat.i(200628);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.GamePublishGalleryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(200628);
      return;
    }
    Log.i("MicroMsg.GamePublishGalleryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200628);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(200628);
        return;
      }
      h.a(this, getString(g.i.CpA), getString(g.i.permission_tips_title), getString(g.i.jump_to_settings), getString(g.i.gallery_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(200944);
          paramAnonymousDialogInterface = GamePublishGalleryUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          GamePublishGalleryUI.this.finish();
          AppMethodBeat.o(200944);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(197893);
          GamePublishGalleryUI.this.finish();
          AppMethodBeat.o(197893);
        }
      });
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
    if ((paramInt % 2 == 0) && (this.CFp != null))
    {
      this.CFp.exs();
      this.uLQ.setCurrentItem(paramInt);
      if (paramBoolean) {
        if (paramInt % 2 != 0) {
          break label90;
        }
      }
    }
    label90:
    for (paramInt = 8762;; paramInt = 8767)
    {
      com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), paramInt, 0, 2, this.CEE, com.tencent.mm.game.report.b.a.b(7, new HashMap()));
      AppMethodBeat.o(41043);
      return;
      this.CFo.exs();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GamePublishGalleryUI
 * JD-Core Version:    0.7.0.1
 */