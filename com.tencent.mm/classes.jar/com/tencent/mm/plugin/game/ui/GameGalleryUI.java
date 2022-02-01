package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

@com.tencent.mm.ui.base.a(19)
public class GameGalleryUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener
{
  private int IRr = 0;
  private String appId = "";
  private MMDotView xUq;
  private ViewPager xUr;
  private int ybL = -1;
  
  public int getLayoutId()
  {
    return h.f.HVr;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42151);
    super.onCreate(paramBundle);
    hideTitleView();
    this.xUr = ((ViewPager)findViewById(h.e.HVr));
    this.xUq = ((MMDotView)findViewById(h.e.HVv));
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
    this.ybL = getIntent().getIntExtra("REPORT_SCENE", -1);
    this.IRr = getIntent().getIntExtra("SOURCE_SCENE", 0);
    a locala = new a(this, paramBundle);
    this.xUr.setAdapter(locala);
    this.xUr.setOnPageChangeListener(this);
    this.xUr.setCurrentItem(i, false);
    this.xUq.setInvertedStyle(true);
    this.xUq.setDotCount(paramBundle.length);
    this.xUq.setSelectedDot(i);
    if (i == 0) {
      g.a(this, this.ybL, 1202, 1, 12, this.appId, this.IRr, null);
    }
    AppMethodBeat.o(42151);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(42152);
    this.xUq.setSelectedDot(paramInt);
    g.a(this, this.ybL, 1202, paramInt + 1, 12, this.appId, this.IRr, null);
    AppMethodBeat.o(42152);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends androidx.viewpager.widget.a
  {
    private String[] IRs;
    private View[] IRt;
    private Context mContext;
    
    public a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(42148);
      this.IRs = new String[0];
      this.mContext = paramContext;
      if (paramArrayOfString != null) {
        this.IRs = paramArrayOfString;
      }
      this.IRt = new View[this.IRs.length];
      AppMethodBeat.o(42148);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(42150);
      paramViewGroup.removeView((View)paramObject);
      AppMethodBeat.o(42150);
    }
    
    public final int getCount()
    {
      return this.IRs.length;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(42149);
      Object localObject2 = this.IRt[paramInt];
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = View.inflate(this.mContext, h.f.game_gallery_item, null);
        this.IRt[paramInt] = localObject1;
        localObject2 = (ImageView)((View)localObject1).findViewById(h.e.HVu);
        final ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(h.e.HVw);
        localProgressBar.setVisibility(0);
        com.tencent.mm.modelimage.loader.a locala = r.bKe();
        String str = this.IRs[paramInt];
        c.a locala1 = new c.a();
        locala1.oKo = true;
        locala.a(str, (ImageView)localObject2, locala1.bKx(), new h()
        {
          public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
          {
            return null;
          }
          
          public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
          {
            AppMethodBeat.i(42146);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42145);
                GameGalleryUI.a.1.this.IRu.setVisibility(8);
                AppMethodBeat.o(42145);
              }
            });
            AppMethodBeat.o(42146);
          }
          
          public final void c(String paramAnonymousString, View paramAnonymousView) {}
        });
      }
      paramViewGroup.addView((View)localObject1);
      ((View)localObject1).setOnClickListener(new GameGalleryUI.a.2(this));
      AppMethodBeat.o(42149);
      return localObject1;
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI
 * JD-Core Version:    0.7.0.1
 */