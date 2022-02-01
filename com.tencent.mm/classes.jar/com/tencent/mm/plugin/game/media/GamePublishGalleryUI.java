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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class GamePublishGalleryUI
  extends MMActivity
{
  private ViewPager pRH;
  private TextViewWithBottomLine uiR;
  private TextViewWithBottomLine uiS;
  private TextView uiT;
  private GameLocalGalleryView uiU;
  private k uiV;
  
  public final void daK()
  {
    AppMethodBeat.i(41044);
    if ((a.dav() == 0) && (this.pRH.getCurrentItem() % 2 == 0)) {
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
    if (this.uiU != null)
    {
      localGameLocalGalleryView = this.uiU;
      if (paramInt1 == GameLocalGalleryView.uiB)
      {
        if (paramInt2 == -1)
        {
          GameLocalGalleryView.daF();
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
          if (paramInt1 == GameLocalGalleryView.uiC) {
            switch (paramInt2)
            {
            default: 
              i = 1;
              break;
            case -1: 
              GameLocalGalleryView.daF();
              if (paramIntent != null) {
                break label399;
              }
              localObject = new Intent();
              ((Intent)localObject).putStringArrayListExtra("CropImage_OutputPath_List", localGameLocalGalleryView.uiE.cYs());
            }
          }
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.GameLocalMediaView", "onActivity Result ok");
      ((Activity)localGameLocalGalleryView.getContext()).setResult(-1, (Intent)localObject);
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label104;
      if (paramIntent == null) {
        break label104;
      }
      localObject = paramIntent.getStringArrayListExtra("preview_image_list");
      if ((localObject == null) || (localGameLocalGalleryView.uiE == null)) {
        break label104;
      }
      localGameLocalGalleryView.uiE.ac((ArrayList)localObject);
      break label104;
      ae.e("MicroMsg.GameLocalMediaView", "WTF!!!");
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label104;
      i = 0;
      break;
      if (this.uiV != null)
      {
        localObject = this.uiV;
        if (paramInt1 == (localObject.hashCode() & 0xFFFF))
        {
          if (paramInt2 == -1)
          {
            k.daF();
            if (((k)localObject).ujc != null)
            {
              if (paramIntent.hasExtra("key_game_video_appid")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).ujc.appId);
              }
              if (paramIntent.hasExtra("key_game_video_appname")) {
                paramIntent.putExtra("key_game_video_appid", ((k)localObject).ujc.appName);
              }
              paramIntent.putExtra("key_game_trans_info", ((k)localObject).ujc.udc);
            }
            ((Activity)((k)localObject).getContext()).setResult(-1, paramIntent);
            ((Activity)((k)localObject).getContext()).finish();
          }
          ((k)localObject).ujc = null;
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
    int j = 1;
    AppMethodBeat.i(41038);
    super.onCreate(paramBundle);
    getController().q(this, getResources().getColor(2131101179));
    this.uiR = ((TextViewWithBottomLine)findViewById(2131300523));
    this.uiR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41034);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(0, false);
        GamePublishGalleryUI.c(GamePublishGalleryUI.this).daE();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41034);
      }
    });
    this.uiS = ((TextViewWithBottomLine)findViewById(2131300505));
    this.uiS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41035);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(1, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41035);
      }
    });
    this.uiR.setSelected(true);
    this.uiS.setSelected(false);
    this.uiT = ((TextView)findViewById(2131300452));
    this.uiT.setOnClickListener(new GamePublishGalleryUI.3(this));
    this.pRH = ((ViewPager)findViewById(2131300566));
    ArrayList localArrayList = new ArrayList();
    int k = getIntent().getIntExtra("query_media_type", 3);
    boolean bool1 = getIntent().getBooleanExtra("game_haowan_force_select", false);
    boolean bool2 = getIntent().getBooleanExtra("game_straight_to_publish", false);
    GameGalleryFragment localGameGalleryFragment = new GameGalleryFragment();
    int i = a.dav();
    Object localObject;
    if (k == 1)
    {
      localGameGalleryFragment.mView = new FrameLayout(this);
      i = j;
      localArrayList.add(localGameGalleryFragment);
      paramBundle = new GameGalleryFragment();
      this.uiU = new GameLocalGalleryView(this);
      localObject = this.uiU;
      ((GameLocalGalleryView)localObject).uiJ = bool1;
      if ((((GameLocalGalleryView)localObject).uiJ) && (((GameLocalGalleryView)localObject).uiF != null)) {
        ((GameLocalGalleryView)localObject).uiF.setVisibility(8);
      }
      ((GameLocalGalleryView)localObject).uiK = bool2;
      this.uiU.setQueryType(k);
      this.uiU.setSelectLimitCount(getIntent().getIntExtra("max_select_count", 9));
      paramBundle.mView = this.uiU;
      localArrayList.add(paramBundle);
      paramBundle = new i(getSupportFragmentManager(), localArrayList);
      this.pRH.setAdapter(paramBundle);
      this.pRH.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            GamePublishGalleryUI.c(GamePublishGalleryUI.this).daE();
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
    j = getIntent().getIntExtra("game_media_default_type", 0);
    if ((j == 1) || (j == 2)) {
      i = j;
    }
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      label419:
      this.uiV = new k(this);
      boolean bool3 = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
      paramBundle = this.uiV;
      paramBundle.ujb = bool3;
      paramBundle.uiJ = bool1;
      if ((paramBundle.uiJ) && (paramBundle.olQ != null)) {
        paramBundle.olQ.setVisibility(8);
      }
      paramBundle.uiK = bool2;
      localObject = getIntent().getStringExtra("game_haowan_local_albums_info");
      paramBundle = new JSONArray();
      if (!bu.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        try
        {
          localObject = new JSONArray((String)localObject);
          paramBundle = (Bundle)localObject;
          localObject = paramBundle;
          if (paramBundle.length() == 0) {
            localObject = com.tencent.mm.plugin.game.commlib.a.cZB();
          }
          this.uiV.setLocalAlbumInfos((JSONArray)localObject);
          this.uiV.setBackgroundColor(getResources().getColor(2131101179));
          localGameGalleryFragment.mView = this.uiV;
        }
        catch (JSONException localJSONException) {}
        if (i != 2) {
          break label599;
        }
        i = 1;
        break label419;
      }
      label599:
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
    if ((paramInt % 2 == 0) && (this.uiV != null))
    {
      this.uiV.daD();
      this.pRH.setCurrentItem(paramInt);
      if (paramBoolean) {
        if (paramInt % 2 != 0) {
          break label86;
        }
      }
    }
    label86:
    for (paramInt = 8762;; paramInt = 8767)
    {
      com.tencent.mm.game.report.b.a.a(ak.getContext(), paramInt, 0, 2, com.tencent.mm.game.report.b.a.b(7, new HashMap()));
      AppMethodBeat.o(41043);
      return;
      this.uiU.daD();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GamePublishGalleryUI
 * JD-Core Version:    0.7.0.1
 */