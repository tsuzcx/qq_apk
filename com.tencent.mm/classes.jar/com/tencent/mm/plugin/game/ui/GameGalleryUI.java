package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameGalleryUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener
{
  private String appId = "";
  private MMDotView mfR;
  private ViewPager oEa;
  private int pOf = -1;
  private int sjf = 0;
  
  public int getLayoutId()
  {
    return 2131494310;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42151);
    super.onCreate(paramBundle);
    hideTitleView();
    this.oEa = ((ViewPager)findViewById(2131300450));
    this.mfR = ((MMDotView)findViewById(2131300454));
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
    this.pOf = getIntent().getIntExtra("REPORT_SCENE", -1);
    this.sjf = getIntent().getIntExtra("SOURCE_SCENE", 0);
    GameGalleryUI.a locala = new GameGalleryUI.a(this, paramBundle);
    this.oEa.setAdapter(locala);
    this.oEa.setOnPageChangeListener(this);
    this.oEa.setCurrentItem(i, false);
    this.mfR.setInvertedStyle(true);
    this.mfR.setDotCount(paramBundle.length);
    this.mfR.setSelectedDot(i);
    if (i == 0) {
      e.a(this, this.pOf, 1202, 1, 12, this.appId, this.sjf, null);
    }
    AppMethodBeat.o(42151);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(42152);
    this.mfR.setSelectedDot(paramInt);
    e.a(this, this.pOf, 1202, paramInt + 1, 12, this.appId, this.sjf, null);
    AppMethodBeat.o(42152);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI
 * JD-Core Version:    0.7.0.1
 */