package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;

@a(19)
public class GameGalleryUI
  extends MMActivity
  implements ViewPager.e
{
  private String appId = "";
  private MMDotView hxP;
  private int jNi = -1;
  private ViewPager kB;
  private int lbK = 0;
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    this.hxP.setSelectedDot(paramInt);
    b.a(this, this.jNi, 1202, paramInt + 1, 12, this.appId, this.lbK, null);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  protected final int getLayoutId()
  {
    return g.f.game_gallery;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.kB = ((ViewPager)findViewById(g.e.game_gallery));
    this.hxP = ((MMDotView)findViewById(g.e.game_gallery_indicator));
    paramBundle = getIntent().getStringArrayExtra("URLS");
    if (paramBundle == null) {
      finish();
    }
    int i;
    do
    {
      return;
      int j = getIntent().getIntExtra("CURRENT", 0);
      if (j >= 0)
      {
        i = j;
        if (j < paramBundle.length) {}
      }
      else
      {
        i = 0;
      }
      this.appId = getIntent().getStringExtra("REPORT_APPID");
      this.jNi = getIntent().getIntExtra("REPORT_SCENE", -1);
      this.lbK = getIntent().getIntExtra("SOURCE_SCENE", 0);
      GameGalleryUI.a locala = new GameGalleryUI.a(this, paramBundle);
      this.kB.setAdapter(locala);
      this.kB.setOnPageChangeListener(this);
      this.kB.m(i, false);
      this.hxP.setInvertedStyle(true);
      this.hxP.setDotCount(paramBundle.length);
      this.hxP.setSelectedDot(i);
    } while (i != 0);
    b.a(this, this.jNi, 1202, 1, 12, this.appId, this.lbK, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI
 * JD-Core Version:    0.7.0.1
 */