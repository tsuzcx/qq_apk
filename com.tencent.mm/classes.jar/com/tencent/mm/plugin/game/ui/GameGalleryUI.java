package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.o;
import com.tencent.mm.game.report.e;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

@com.tencent.mm.ui.base.a(19)
public class GameGalleryUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener
{
  private String appId = "";
  private MMDotView mHQ;
  private ViewPager phA;
  private int qwN = -1;
  private int tqY = 0;
  
  public int getLayoutId()
  {
    return 2131494310;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42151);
    super.onCreate(paramBundle);
    hideTitleView();
    this.phA = ((ViewPager)findViewById(2131300450));
    this.mHQ = ((MMDotView)findViewById(2131300454));
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
    this.qwN = getIntent().getIntExtra("REPORT_SCENE", -1);
    this.tqY = getIntent().getIntExtra("SOURCE_SCENE", 0);
    a locala = new a(this, paramBundle);
    this.phA.setAdapter(locala);
    this.phA.setOnPageChangeListener(this);
    this.phA.setCurrentItem(i, false);
    this.mHQ.setInvertedStyle(true);
    this.mHQ.setDotCount(paramBundle.length);
    this.mHQ.setSelectedDot(i);
    if (i == 0) {
      e.a(this, this.qwN, 1202, 1, 12, this.appId, this.tqY, null);
    }
    AppMethodBeat.o(42151);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(42152);
    this.mHQ.setSelectedDot(paramInt);
    e.a(this, this.qwN, 1202, paramInt + 1, 12, this.appId, this.tqY, null);
    AppMethodBeat.o(42152);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends q
  {
    Context mContext;
    private String[] tqZ;
    private View[] tra;
    
    public a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(42148);
      this.tqZ = new String[0];
      this.mContext = paramContext;
      if (paramArrayOfString != null) {
        this.tqZ = paramArrayOfString;
      }
      this.tra = new View[this.tqZ.length];
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
      return this.tqZ.length;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(42149);
      Object localObject2 = this.tra[paramInt];
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = View.inflate(this.mContext, 2131494312, null);
        this.tra[paramInt] = localObject1;
        localObject2 = (ImageView)((View)localObject1).findViewById(2131300453);
        final ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131300455);
        localProgressBar.setVisibility(0);
        com.tencent.mm.av.a.a locala = o.aFB();
        String str = this.tqZ[paramInt];
        c.a locala1 = new c.a();
        locala1.hKw = true;
        locala.a(str, (ImageView)localObject2, locala1.aFT(), new h()
        {
          public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
          {
            return null;
          }
          
          public final void b(String paramAnonymousString, View paramAnonymousView) {}
          
          public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
          {
            AppMethodBeat.i(42146);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42145);
                GameGalleryUI.a.1.this.trb.setVisibility(8);
                AppMethodBeat.o(42145);
              }
            });
            AppMethodBeat.o(42146);
          }
        });
      }
      paramViewGroup.addView((View)localObject1);
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(42147);
          ((MMActivity)GameGalleryUI.a.this.mContext).finish();
          AppMethodBeat.o(42147);
        }
      });
      AppMethodBeat.o(42149);
      return localObject1;
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI
 * JD-Core Version:    0.7.0.1
 */