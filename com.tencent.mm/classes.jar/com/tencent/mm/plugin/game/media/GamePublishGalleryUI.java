package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class GamePublishGalleryUI
  extends MMActivity
{
  private ViewPager phA;
  private TextViewWithBottomLine sZY;
  private TextViewWithBottomLine sZZ;
  private TextView taa;
  private GameLocalGalleryView tab;
  private k tac;
  
  public final void cPv()
  {
    AppMethodBeat.i(41044);
    if ((a.cPg() == 0) && (this.phA.getCurrentItem() % 2 == 0)) {
      setCurrentItem(1, false);
    }
    AppMethodBeat.o(41044);
  }
  
  public int getLayoutId()
  {
    return 2131494317;
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
    if (this.tab != null)
    {
      localGameLocalGalleryView = this.tab;
      if (paramInt1 == GameLocalGalleryView.sZK)
      {
        if (paramInt2 == -1)
        {
          GameLocalGalleryView.cPq();
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
          if (paramInt1 == GameLocalGalleryView.sZL) {
            switch (paramInt2)
            {
            default: 
              i = 1;
              break;
            case -1: 
              GameLocalGalleryView.cPq();
              if (paramIntent != null) {
                break label399;
              }
              localObject = new Intent();
              ((Intent)localObject).putStringArrayListExtra("CropImage_OutputPath_List", localGameLocalGalleryView.sZN.cNv());
            }
          }
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.GameLocalMediaView", "onActivity Result ok");
      ((Activity)localGameLocalGalleryView.getContext()).setResult(-1, (Intent)localObject);
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label104;
      if (paramIntent == null) {
        break label104;
      }
      localObject = paramIntent.getStringArrayListExtra("preview_image_list");
      if ((localObject == null) || (localGameLocalGalleryView.sZN == null)) {
        break label104;
      }
      localGameLocalGalleryView.sZN.ad((ArrayList)localObject);
      break label104;
      ac.e("MicroMsg.GameLocalMediaView", "WTF!!!");
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label104;
      i = 0;
      break;
      if (this.tac != null)
      {
        localObject = this.tac;
        if (paramInt1 == (localObject.hashCode() & 0xFFFF))
        {
          if (paramInt2 == -1)
          {
            k.cPq();
            if (((k)localObject).tak != null)
            {
              if (paramIntent.hasExtra("key_game_video_appid")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).tak.appId);
              }
              if (paramIntent.hasExtra("key_game_video_appname")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).tak.appName);
              }
              paramIntent.putExtra("key_game_trans_info", ((k)localObject).tak.sVG);
            }
            ((Activity)((k)localObject).getContext()).setResult(-1, paramIntent);
            ((Activity)((k)localObject).getContext()).finish();
          }
          ((k)localObject).tak = null;
        }
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          AppMethodBeat.o(41042);
          return;
        }
      }
      AppMethodBeat.o(41042);
      return;
      label399:
      localObject = paramIntent;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(41038);
    super.onCreate(paramBundle);
    getController().q(this, getResources().getColor(2131101179));
    this.sZY = ((TextViewWithBottomLine)findViewById(2131300523));
    this.sZY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41034);
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(0, false);
        GamePublishGalleryUI.c(GamePublishGalleryUI.this).cPp();
        AppMethodBeat.o(41034);
      }
    });
    this.sZZ = ((TextViewWithBottomLine)findViewById(2131300505));
    this.sZZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41035);
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(1, false);
        AppMethodBeat.o(41035);
      }
    });
    this.sZY.setSelected(true);
    this.sZZ.setSelected(false);
    this.taa = ((TextView)findViewById(2131300452));
    this.taa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41036);
        GamePublishGalleryUI.this.setResult(0);
        GamePublishGalleryUI.this.finish();
        AppMethodBeat.o(41036);
      }
    });
    this.phA = ((ViewPager)findViewById(2131300566));
    ArrayList localArrayList = new ArrayList();
    int j = getIntent().getIntExtra("query_media_type", 3);
    GameGalleryFragment localGameGalleryFragment = new GameGalleryFragment();
    int k = a.cPg();
    if (j == 1)
    {
      localGameGalleryFragment.mView = new FrameLayout(this);
      localArrayList.add(localGameGalleryFragment);
      paramBundle = new GameGalleryFragment();
      this.tab = new GameLocalGalleryView(this);
      this.tab.setQueryType(j);
      this.tab.setSelectLimitCount(getIntent().getIntExtra("max_select_count", 9));
      paramBundle.mView = this.tab;
      localArrayList.add(paramBundle);
      paramBundle = new i(getSupportFragmentManager(), localArrayList);
      this.phA.setAdapter(paramBundle);
      this.phA.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            GamePublishGalleryUI.c(GamePublishGalleryUI.this).cPp();
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
      AppMethodBeat.o(41038);
      return;
    }
    if (k == 1) {
      i = 0;
    }
    for (;;)
    {
      label321:
      this.tac = new k(this);
      boolean bool = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
      this.tac.setIgnoreVideoPreview(bool);
      Object localObject = getIntent().getStringExtra("game_haowan_local_albums_info");
      paramBundle = new JSONArray();
      if (!bs.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        try
        {
          localObject = new JSONArray((String)localObject);
          paramBundle = (Bundle)localObject;
          this.tac.setLocalAlbumInfos(paramBundle);
          this.tac.setBackgroundColor(getResources().getColor(2131101179));
          localGameGalleryFragment.mView = this.tac;
        }
        catch (JSONException localJSONException) {}
        if (k != 2) {
          break label449;
        }
        i = 1;
        break label321;
      }
      label449:
      i = 0;
    }
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
    if ((paramInt % 2 == 0) && (this.tac != null))
    {
      this.tac.cPo();
      this.phA.setCurrentItem(paramInt);
      if (paramBoolean) {
        if (paramInt % 2 != 0) {
          break label86;
        }
      }
    }
    label86:
    for (paramInt = 8762;; paramInt = 8767)
    {
      com.tencent.mm.game.report.b.a.a(ai.getContext(), paramInt, 0, 2, com.tencent.mm.game.report.b.a.a(7, new HashMap()));
      AppMethodBeat.o(41043);
      return;
      this.tab.cPo();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GamePublishGalleryUI
 * JD-Core Version:    0.7.0.1
 */