package com.tencent.mm.plugin.game.ui;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.support.v7.app.ActionBar;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public abstract class GameCenterActivity
  extends GameBaseActivity
{
  protected int heA;
  protected View kXV;
  protected View kXW;
  protected int kXX = 0;
  protected String kXY = null;
  private dc kXZ;
  protected ActionBar mActionBar;
  
  private boolean bad()
  {
    return (!bk.bl(this.kXY)) && (this.kXY.equals("black"));
  }
  
  @TargetApi(21)
  private void setStatusBarColor(int paramInt)
  {
    if ((this.heA <= 0) || (d.gG(21))) {
      return;
    }
    getWindow().setStatusBarColor(0);
    ViewGroup.LayoutParams localLayoutParams;
    if (this.kXW == null)
    {
      this.kXW = new View(this);
      this.kXW.setId(g.e.game_action_btn);
      localLayoutParams = new ViewGroup.LayoutParams(-1, this.heA);
      ((ViewGroup)findViewById(16908290)).addView(this.kXW, localLayoutParams);
    }
    for (;;)
    {
      this.kXW.setBackgroundColor(paramInt);
      return;
      localLayoutParams = this.kXW.getLayoutParams();
      if (localLayoutParams.height != this.heA)
      {
        localLayoutParams.height = this.heA;
        this.kXW.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  @TargetApi(21)
  protected final void a(ViewGroup paramViewGroup, WindowInsets paramWindowInsets)
  {
    if (this.heA == paramWindowInsets.getSystemWindowInsetTop()) {}
    int j;
    boolean bool;
    do
    {
      do
      {
        return;
        this.heA = paramWindowInsets.getSystemWindowInsetTop();
        bac();
        Object localObject = paramViewGroup;
        if ((paramViewGroup instanceof SwipeBackLayout)) {
          localObject = paramViewGroup.getChildAt(0);
        }
        i = g.e.action_bar_container;
        if (i > 0)
        {
          paramViewGroup = ((View)localObject).findViewById(i);
          if (paramViewGroup != null)
          {
            localObject = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramWindowInsets.getSystemWindowInsetTop();
            paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramViewGroup.requestLayout();
          }
        }
        y.i("MicroMsg.GameCenterActivity", "setInitialStatusBarStyle");
      } while (!d.gF(21));
      if (this.kXX == 0) {
        break;
      }
      ta(this.kXX);
      if (bad())
      {
        y.i("MicroMsg.GameCenterActivity", "setBackBtnColorFilter");
        czn();
      }
      j = this.kXX;
      bool = bad();
      if ((Build.VERSION.SDK_INT >= 23) && (!h.zK()))
      {
        setStatusBarColor(j);
        paramViewGroup = getWindow();
        i = paramViewGroup.getDecorView().getSystemUiVisibility();
        if (bool) {
          i |= 0x2000;
        }
        for (;;)
        {
          paramViewGroup.getDecorView().setSystemUiVisibility(i);
          return;
          i &= 0xFFFFDFFF;
        }
      }
    } while (Build.VERSION.SDK_INT < 21);
    int i = j;
    if (bool) {
      i = ak.Cx(j);
    }
    setStatusBarColor(i);
    return;
    setStatusBarColor(an.n(getResources().getColor(g.b.statusbar_fg_color), this.mController.czv()));
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    if (!d.gF(21)) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = b.g(this, paramInt2);
    } while (localDrawable == null);
    if (bad()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      a(paramInt1, getString(g.i.app_more), localDrawable, paramOnMenuItemClickListener);
      return;
      localDrawable.clearColorFilter();
    }
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    if ((d.gF(21)) && (bad()))
    {
      a(paramInt, paramString, -16777216, paramOnMenuItemClickListener);
      return;
    }
    super.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  protected final void bac()
  {
    if (this.kXV == null) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kXV.getLayoutParams();
    int j = this.heA;
    if (this.mActionBar != null) {}
    for (int i = this.mActionBar.getHeight();; i = 0)
    {
      i += j;
      if (i == localMarginLayoutParams.topMargin) {
        break;
      }
      localMarginLayoutParams.topMargin = i;
      this.kXV.setLayoutParams(localMarginLayoutParams);
      return;
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 277	com/tencent/mm/plugin/game/ui/GameBaseActivity:onCreate	(Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: aload_0
    //   7: invokevirtual 281	com/tencent/mm/plugin/game/ui/GameCenterActivity:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   10: putfield 266	com/tencent/mm/plugin/game/ui/GameCenterActivity:mActionBar	Landroid/support/v7/app/ActionBar;
    //   13: aload_0
    //   14: invokestatic 287	com/tencent/mm/plugin/game/commlib/a:aYn	()Lcom/tencent/mm/plugin/game/d/dc;
    //   17: putfield 289	com/tencent/mm/plugin/game/ui/GameCenterActivity:kXZ	Lcom/tencent/mm/plugin/game/d/dc;
    //   20: aload_0
    //   21: getfield 289	com/tencent/mm/plugin/game/ui/GameCenterActivity:kXZ	Lcom/tencent/mm/plugin/game/d/dc;
    //   24: ifnull +28 -> 52
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 289	com/tencent/mm/plugin/game/ui/GameCenterActivity:kXZ	Lcom/tencent/mm/plugin/game/d/dc;
    //   32: getfield 294	com/tencent/mm/plugin/game/d/dc:color	Ljava/lang/String;
    //   35: invokestatic 300	com/tencent/mm/plugin/game/f/c:parseColor	(Ljava/lang/String;)I
    //   38: putfield 22	com/tencent/mm/plugin/game/ui/GameCenterActivity:kXX	I
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 289	com/tencent/mm/plugin/game/ui/GameCenterActivity:kXZ	Lcom/tencent/mm/plugin/game/d/dc;
    //   46: getfield 303	com/tencent/mm/plugin/game/d/dc:kQS	Ljava/lang/String;
    //   49: putfield 24	com/tencent/mm/plugin/game/ui/GameCenterActivity:kXY	Ljava/lang/String;
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 206	com/tencent/mm/ui/MMActivity:mController	Lcom/tencent/mm/ui/s;
    //   57: getfield 306	com/tencent/mm/ui/s:contentView	Landroid/view/View;
    //   60: putfield 264	com/tencent/mm/plugin/game/ui/GameCenterActivity:kXV	Landroid/view/View;
    //   63: aload_0
    //   64: getfield 264	com/tencent/mm/plugin/game/ui/GameCenterActivity:kXV	Landroid/view/View;
    //   67: ifnull +35 -> 102
    //   70: aload_0
    //   71: invokevirtual 119	com/tencent/mm/plugin/game/ui/GameCenterActivity:bac	()V
    //   74: aload_0
    //   75: invokevirtual 58	com/tencent/mm/plugin/game/ui/GameCenterActivity:getWindow	()Landroid/view/Window;
    //   78: invokevirtual 174	android/view/Window:getDecorView	()Landroid/view/View;
    //   81: checkcast 89	android/view/ViewGroup
    //   84: iconst_0
    //   85: invokevirtual 124	android/view/ViewGroup:getChildAt	(I)Landroid/view/View;
    //   88: checkcast 89	android/view/ViewGroup
    //   91: new 308	com/tencent/mm/plugin/game/ui/GameCenterActivity$1
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 311	com/tencent/mm/plugin/game/ui/GameCenterActivity$1:<init>	(Lcom/tencent/mm/plugin/game/ui/GameCenterActivity;)V
    //   99: invokevirtual 315	android/view/ViewGroup:addOnLayoutChangeListener	(Landroid/view/View$OnLayoutChangeListener;)V
    //   102: bipush 21
    //   104: invokestatic 149	com/tencent/mm/compatible/util/d:gF	(I)Z
    //   107: ifeq +58 -> 165
    //   110: aload_0
    //   111: invokevirtual 58	com/tencent/mm/plugin/game/ui/GameCenterActivity:getWindow	()Landroid/view/Window;
    //   114: invokevirtual 174	android/view/Window:getDecorView	()Landroid/view/View;
    //   117: checkcast 89	android/view/ViewGroup
    //   120: iconst_0
    //   121: invokevirtual 124	android/view/ViewGroup:getChildAt	(I)Landroid/view/View;
    //   124: checkcast 89	android/view/ViewGroup
    //   127: astore_1
    //   128: aload_1
    //   129: new 317	com/tencent/mm/plugin/game/ui/GameCenterActivity$2
    //   132: dup
    //   133: aload_0
    //   134: aload_1
    //   135: invokespecial 320	com/tencent/mm/plugin/game/ui/GameCenterActivity$2:<init>	(Lcom/tencent/mm/plugin/game/ui/GameCenterActivity;Landroid/view/ViewGroup;)V
    //   138: invokevirtual 324	android/view/ViewGroup:setOnApplyWindowInsetsListener	(Landroid/view/View$OnApplyWindowInsetsListener;)V
    //   141: return
    //   142: astore_1
    //   143: ldc 138
    //   145: ldc_w 326
    //   148: iconst_1
    //   149: anewarray 328	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload_1
    //   155: invokevirtual 332	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: aastore
    //   159: invokestatic 336	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: goto -60 -> 102
    //   165: aload_0
    //   166: invokevirtual 58	com/tencent/mm/plugin/game/ui/GameCenterActivity:getWindow	()Landroid/view/Window;
    //   169: invokevirtual 174	android/view/Window:getDecorView	()Landroid/view/View;
    //   172: checkcast 89	android/view/ViewGroup
    //   175: iconst_1
    //   176: invokevirtual 340	android/view/ViewGroup:setFitsSystemWindows	(Z)V
    //   179: return
    //   180: astore_1
    //   181: ldc 138
    //   183: ldc_w 342
    //   186: iconst_1
    //   187: anewarray 328	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: invokevirtual 332	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   196: aastore
    //   197: invokestatic 336	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	GameCenterActivity
    //   0	201	1	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   52	102	142	java/lang/Exception
    //   102	141	180	java/lang/Exception
    //   165	179	180	java/lang/Exception
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    supportRequestWindowFeature(5);
    supportRequestWindowFeature(9);
    setProgressBarIndeterminateVisibility(false);
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    y.i("MicroMsg.GameCenterActivity", "setBackBtn");
    super.setBackBtn(paramOnMenuItemClickListener, 0);
    if ((d.gF(21)) && (bad()))
    {
      y.i("MicroMsg.GameCenterActivity", "setBackBtn, setBackBtnColorFilter");
      czn();
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    y.i("MicroMsg.GameCenterActivity", "setBackBtn");
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((d.gF(21)) && (bad()))
    {
      y.i("MicroMsg.GameCenterActivity", "setBackBtn, setBackBtnColorFilter");
      czn();
    }
  }
  
  public final void setMMTitle(int paramInt)
  {
    super.setMMTitle(paramInt);
    if ((d.gF(21)) && (bad())) {
      oX(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */