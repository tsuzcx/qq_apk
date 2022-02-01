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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class GamePublishGalleryUI
  extends MMActivity
{
  private ViewPager oEa;
  private TextViewWithBottomLine rSi;
  private TextViewWithBottomLine rSj;
  private TextView rSk;
  private GameLocalGalleryView rSl;
  private k rSm;
  
  public final void cCk()
  {
    AppMethodBeat.i(41044);
    if ((a.cBV() == 0) && (this.oEa.getCurrentItem() % 2 == 0)) {
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
    if (this.rSl != null)
    {
      localGameLocalGalleryView = this.rSl;
      if (paramInt1 == GameLocalGalleryView.rRU)
      {
        if (paramInt2 == -1)
        {
          GameLocalGalleryView.cCf();
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
          if (paramInt1 == GameLocalGalleryView.rRV) {
            switch (paramInt2)
            {
            default: 
              i = 1;
              break;
            case -1: 
              GameLocalGalleryView.cCf();
              if (paramIntent != null) {
                break label322;
              }
              localObject = new Intent();
              ((Intent)localObject).putStringArrayListExtra("CropImage_OutputPath_List", localGameLocalGalleryView.rRX.cAm());
            }
          }
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.GameLocalMediaView", "onActivity Result ok");
      ((Activity)localGameLocalGalleryView.getContext()).setResult(-1, (Intent)localObject);
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label104;
      if (paramIntent == null) {
        break label104;
      }
      localObject = paramIntent.getStringArrayListExtra("preview_image_list");
      if ((localObject == null) || (localGameLocalGalleryView.rRX == null)) {
        break label104;
      }
      localGameLocalGalleryView.rRX.S((ArrayList)localObject);
      break label104;
      ad.e("MicroMsg.GameLocalMediaView", "WTF!!!");
      ((Activity)localGameLocalGalleryView.getContext()).finish();
      break label104;
      i = 0;
      break;
      if (this.rSm != null)
      {
        localObject = this.rSm;
        if (paramInt1 == (localObject.hashCode() & 0xFFFF)) {
          if (paramInt2 == -1)
          {
            k.cCf();
            ((Activity)((k)localObject).getContext()).setResult(-1, paramIntent);
            ((Activity)((k)localObject).getContext()).finish();
          }
        }
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          AppMethodBeat.o(41042);
          return;
        }
      }
      AppMethodBeat.o(41042);
      return;
      label322:
      localObject = paramIntent;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(41038);
    super.onCreate(paramBundle);
    getController().q(this, getResources().getColor(2131101179));
    this.rSi = ((TextViewWithBottomLine)findViewById(2131300523));
    this.rSi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41034);
        GamePublishGalleryUI.a(GamePublishGalleryUI.this).setSelected(true);
        GamePublishGalleryUI.b(GamePublishGalleryUI.this).setSelected(false);
        GamePublishGalleryUI.this.setCurrentItem(0, false);
        GamePublishGalleryUI.c(GamePublishGalleryUI.this).cCe();
        AppMethodBeat.o(41034);
      }
    });
    this.rSj = ((TextViewWithBottomLine)findViewById(2131300505));
    this.rSj.setOnClickListener(new View.OnClickListener()
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
    this.rSi.setSelected(true);
    this.rSj.setSelected(false);
    this.rSk = ((TextView)findViewById(2131300452));
    this.rSk.setOnClickListener(new GamePublishGalleryUI.3(this));
    this.oEa = ((ViewPager)findViewById(2131300566));
    ArrayList localArrayList = new ArrayList();
    int j = getIntent().getIntExtra("query_media_type", 3);
    GameGalleryFragment localGameGalleryFragment = new GameGalleryFragment();
    int k = a.cBV();
    if (j == 1)
    {
      localGameGalleryFragment.mView = new FrameLayout(this);
      localArrayList.add(localGameGalleryFragment);
      paramBundle = new GameGalleryFragment();
      this.rSl = new GameLocalGalleryView(this);
      this.rSl.setQueryType(j);
      this.rSl.setSelectLimitCount(getIntent().getIntExtra("max_select_count", 9));
      paramBundle.mView = this.rSl;
      localArrayList.add(paramBundle);
      paramBundle = new i(getSupportFragmentManager(), localArrayList);
      this.oEa.setAdapter(paramBundle);
      this.oEa.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            GamePublishGalleryUI.c(GamePublishGalleryUI.this).cCe();
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
      label320:
      this.rSm = new k(this);
      boolean bool = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
      this.rSm.setIgnoreVideoPreview(bool);
      Object localObject = getIntent().getStringExtra("game_haowan_local_albums_info");
      paramBundle = new JSONArray();
      if (!bt.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        try
        {
          localObject = new JSONArray((String)localObject);
          paramBundle = (Bundle)localObject;
          this.rSm.setLocalAlbumInfos(paramBundle);
          this.rSm.setBackgroundColor(getResources().getColor(2131101179));
          localGameGalleryFragment.mView = this.rSm;
        }
        catch (JSONException localJSONException) {}
        if (k != 2) {
          break label448;
        }
        i = 1;
        break label320;
      }
      label448:
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
    f.d(false, true, true);
    AppMethodBeat.o(41040);
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
    if ((paramInt % 2 == 0) && (this.rSm != null))
    {
      this.rSm.cCd();
      this.oEa.setCurrentItem(paramInt);
      if (paramBoolean) {
        if (paramInt % 2 != 0) {
          break label86;
        }
      }
    }
    label86:
    for (paramInt = 8762;; paramInt = 8767)
    {
      com.tencent.mm.game.report.b.a.a(aj.getContext(), paramInt, 0, 2, com.tencent.mm.game.report.b.a.a(7, new HashMap()));
      AppMethodBeat.o(41043);
      return;
      this.rSl.cCd();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GamePublishGalleryUI
 * JD-Core Version:    0.7.0.1
 */