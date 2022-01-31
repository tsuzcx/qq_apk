package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameGalleryUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener
{
  private String appId = "";
  private MMDotView jpZ;
  private ViewPager lz;
  private int mhr = -1;
  private int nzF = 0;
  
  public int getLayoutId()
  {
    return 2130969756;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111967);
    super.onCreate(paramBundle);
    hideTitleView();
    this.lz = ((ViewPager)findViewById(2131824637));
    this.jpZ = ((MMDotView)findViewById(2131824638));
    paramBundle = getIntent().getStringArrayExtra("URLS");
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(111967);
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
    this.mhr = getIntent().getIntExtra("REPORT_SCENE", -1);
    this.nzF = getIntent().getIntExtra("SOURCE_SCENE", 0);
    GameGalleryUI.a locala = new GameGalleryUI.a(this, paramBundle);
    this.lz.setAdapter(locala);
    this.lz.setOnPageChangeListener(this);
    this.lz.setCurrentItem(i, false);
    this.jpZ.setInvertedStyle(true);
    this.jpZ.setDotCount(paramBundle.length);
    this.jpZ.setSelectedDot(i);
    if (i == 0) {
      c.a(this, this.mhr, 1202, 1, 12, this.appId, this.nzF, null);
    }
    AppMethodBeat.o(111967);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111968);
    this.jpZ.setSelectedDot(paramInt);
    c.a(this, this.mhr, 1202, paramInt + 1, 12, this.appId, this.nzF, null);
    AppMethodBeat.o(111968);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI
 * JD-Core Version:    0.7.0.1
 */