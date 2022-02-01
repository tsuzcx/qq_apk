package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.q;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

@com.tencent.mm.ui.base.a(19)
public class GameGalleryUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener
{
  private int CXa = 0;
  private String appId = "";
  private MMDotView uLP;
  private ViewPager uLQ;
  private int wwk = -1;
  
  public int getLayoutId()
  {
    return g.f.Cjj;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42151);
    super.onCreate(paramBundle);
    hideTitleView();
    this.uLQ = ((ViewPager)findViewById(g.e.Cjj));
    this.uLP = ((MMDotView)findViewById(g.e.Cjn));
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
    this.wwk = getIntent().getIntExtra("REPORT_SCENE", -1);
    this.CXa = getIntent().getIntExtra("SOURCE_SCENE", 0);
    a locala = new a(this, paramBundle);
    this.uLQ.setAdapter(locala);
    this.uLQ.setOnPageChangeListener(this);
    this.uLQ.setCurrentItem(i, false);
    this.uLP.setInvertedStyle(true);
    this.uLP.setDotCount(paramBundle.length);
    this.uLP.setSelectedDot(i);
    if (i == 0) {
      g.a(this, this.wwk, 1202, 1, 12, this.appId, this.CXa, null);
    }
    AppMethodBeat.o(42151);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(42152);
    this.uLP.setSelectedDot(paramInt);
    g.a(this, this.wwk, 1202, paramInt + 1, 12, this.appId, this.CXa, null);
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
    private String[] CXb;
    private View[] CXc;
    private Context mContext;
    
    public a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(42148);
      this.CXb = new String[0];
      this.mContext = paramContext;
      if (paramArrayOfString != null) {
        this.CXb = paramArrayOfString;
      }
      this.CXc = new View[this.CXb.length];
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
      return this.CXb.length;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(42149);
      Object localObject2 = this.CXc[paramInt];
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = View.inflate(this.mContext, g.f.game_gallery_item, null);
        this.CXc[paramInt] = localObject1;
        localObject2 = (ImageView)((View)localObject1).findViewById(g.e.Cjm);
        final ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(g.e.Cjo);
        localProgressBar.setVisibility(0);
        com.tencent.mm.ay.a.a locala = q.bml();
        String str = this.CXb[paramInt];
        c.a locala1 = new c.a();
        locala1.lRC = true;
        locala.a(str, (ImageView)localObject2, locala1.bmL(), new h()
        {
          public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
          {
            return null;
          }
          
          public final void b(String paramAnonymousString, View paramAnonymousView) {}
          
          public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
          {
            AppMethodBeat.i(42146);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42145);
                GameGalleryUI.a.1.this.CXd.setVisibility(8);
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameGalleryUI$ImageAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ((MMActivity)GameGalleryUI.a.a(GameGalleryUI.a.this)).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameGalleryUI$ImageAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI
 * JD-Core Version:    0.7.0.1
 */