package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameGalleryUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener
{
  private String appId = "";
  private MMDotView nio;
  private ViewPager pLc;
  private int rgD = -1;
  private int upv = 0;
  
  public int getLayoutId()
  {
    return 2131494310;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42151);
    super.onCreate(paramBundle);
    hideTitleView();
    this.pLc = ((ViewPager)findViewById(2131300450));
    this.nio = ((MMDotView)findViewById(2131300454));
    paramBundle = getIntent().getStringArrayExtra("URLS");
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(42151);
      return;
    }
    int j = getIntent().getIntExtra("CURRENT", 0);
    int i;
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
    this.rgD = getIntent().getIntExtra("REPORT_SCENE", -1);
    this.upv = getIntent().getIntExtra("SOURCE_SCENE", 0);
    GameGalleryUI.a locala = new GameGalleryUI.a(this, paramBundle);
    this.pLc.setAdapter(locala);
    this.pLc.setOnPageChangeListener(this);
    this.pLc.setCurrentItem(i, false);
    this.nio.setInvertedStyle(true);
    this.nio.setDotCount(paramBundle.length);
    this.nio.setSelectedDot(i);
    if (i == 0) {
      f.a(this, this.rgD, 1202, 1, 12, this.appId, this.upv, null);
    }
    AppMethodBeat.o(42151);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(42152);
    this.nio.setSelectedDot(paramInt);
    f.a(this, this.rgD, 1202, paramInt + 1, 12, this.appId, this.upv, null);
    AppMethodBeat.o(42152);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI
 * JD-Core Version:    0.7.0.1
 */