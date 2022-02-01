package com.tencent.mm.plugin.aa.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;

public class AAImagPreviewUI
  extends MMActivity
{
  private View fOB;
  private String hym;
  private final int iUF = 1;
  private final int iUG = 2;
  private MMGestureGallery iUH;
  private a iUI;
  private int iUJ;
  private int iUK;
  private Dialog iUL = null;
  private AnimationLayout iUM;
  private boolean iUN = false;
  private ViewAnimHelper.ViewInfo iUO;
  private ImageView iUP;
  private String imagePath;
  
  private static void a(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63489);
    q.A(paramMultiTouchImageView, paramBitmap.getWidth(), paramBitmap.getHeight());
    int i = paramMultiTouchImageView.getWidth();
    int j = paramMultiTouchImageView.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
    float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
    ad.v("MicroMsg.PreviewHdHeadImg", "whDiv is " + f1 + " hwDiv is " + f2);
    if ((f2 >= 2.0F) && (paramBitmap.getHeight() >= 480))
    {
      f1 = paramBitmap.getWidth() / i;
      f2 = i / paramBitmap.getWidth();
      if (f1 > 1.0D)
      {
        localMatrix.postScale(f2, f2);
        paramBitmap.getHeight();
        localMatrix.postTranslate((i - f2 * paramBitmap.getWidth()) / 2.0F, 0.0F);
      }
    }
    for (;;)
    {
      paramMultiTouchImageView.setImageMatrix(localMatrix);
      paramMultiTouchImageView.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setMaxZoomDoubleTab(true);
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(63489);
      return;
      localMatrix.postScale(1.0F, 1.0F);
      localMatrix.postTranslate((i - paramBitmap.getWidth()) / 2, 0.0F);
      continue;
      if ((f1 < 2.0F) || (paramBitmap.getWidth() < 480)) {
        break;
      }
      f1 = paramBitmap.getHeight() / 480.0F;
      f2 = 480.0F / paramBitmap.getHeight();
      if (f1 > 1.0D)
      {
        localMatrix.postScale(f1, f2);
        localMatrix.postTranslate(0.0F, (j - 480) / 2);
      }
      else
      {
        localMatrix.postScale(1.0F, 1.0F);
        f1 = (j - paramBitmap.getHeight()) / 2;
        ad.d("MicroMsg.PreviewHdHeadImg", " offsety ".concat(String.valueOf(f1)));
        localMatrix.postTranslate(0.0F, f1);
      }
    }
    f1 = i / paramBitmap.getWidth();
    f2 = j / paramBitmap.getHeight();
    label373:
    float f3;
    if (f1 < f2)
    {
      f2 = paramBitmap.getWidth() / i;
      f3 = paramBitmap.getHeight() / j;
      if (f2 <= f3) {
        break label456;
      }
      label401:
      if (f2 <= 1.0D) {
        break label462;
      }
      localMatrix.postScale(f1, f1);
    }
    for (;;)
    {
      localMatrix.postTranslate((i - paramBitmap.getWidth() * f1) / 2.0F, (j - f1 * paramBitmap.getHeight()) / 2.0F);
      break;
      f1 = f2;
      break label373;
      label456:
      f2 = f3;
      break label401;
      label462:
      f1 = 1.0F;
    }
  }
  
  private void aRo()
  {
    AppMethodBeat.i(198901);
    if (this.iUN)
    {
      AppMethodBeat.o(198901);
      return;
    }
    this.iUN = true;
    ad.i("MicroMsg.PreviewHdHeadImg", "runExitAnimation");
    this.iUM.a(this.iUP, this.fOB, this.iUO, new Animator.AnimatorListener()new ValueAnimator.AnimatorUpdateListener
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(198900);
        AAImagPreviewUI.this.finish();
        AAImagPreviewUI.this.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(198900);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }, new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(198895);
        ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        AppMethodBeat.o(198895);
      }
    });
    AppMethodBeat.o(198901);
  }
  
  public void finish()
  {
    AppMethodBeat.i(63488);
    super.finish();
    aRo();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(63488);
  }
  
  public int getLayoutId()
  {
    return 2131492881;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63487);
    hideTitleView();
    fullScreenNoTitleBar(true);
    if (d.ly(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.iUM = ((AnimationLayout)findViewById(2131296674));
      this.fOB = findViewById(2131304241);
      this.iUP = ((ImageView)findViewById(2131300336));
      if (this.iUO == null) {
        this.iUO = ViewAnimHelper.o(this.iUP, getContext().getWindow().getDecorView());
      }
      this.iUH = ((MMGestureGallery)findViewById(2131300335));
      this.iUH.setVerticalFadingEdgeEnabled(false);
      this.iUH.setHorizontalFadingEdgeEnabled(false);
      this.iUH.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void aRp()
        {
          AppMethodBeat.i(63477);
          AAImagPreviewUI.this.finish();
          AppMethodBeat.o(63477);
        }
      });
      this.iUH.setLongClickOverListener(new MMGestureGallery.c()
      {
        public final void aRq()
        {
          AppMethodBeat.i(63480);
          e locale = new e(AAImagPreviewUI.this, 1, false);
          locale.KJy = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(63478);
              paramAnonymous2l.jI(1, 2131760662);
              if (AAImagPreviewUI.a(AAImagPreviewUI.this) == 1) {
                paramAnonymous2l.jI(2, 2131760653);
              }
              AppMethodBeat.o(63478);
            }
          };
          locale.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63479);
              ad.i("MicroMsg.PreviewHdHeadImg", "onMMMenuItemSelected %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(63479);
                return;
                AAImagPreviewUI.b(AAImagPreviewUI.this);
                AppMethodBeat.o(63479);
                return;
                AAImagPreviewUI.this.setResult(-1);
                AAImagPreviewUI.this.finish();
              }
            }
          };
          locale.cMW();
          AppMethodBeat.o(63480);
        }
      });
      this.iUI = new a((byte)0);
      this.iUH.setAdapter(this.iUI);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(63481);
          AAImagPreviewUI.this.finish();
          AppMethodBeat.o(63481);
          return true;
        }
      });
      if (!this.iUN)
      {
        this.iUN = true;
        ad.i("MicroMsg.PreviewHdHeadImg", "runEnterAnimation");
        this.iUM.b(this.iUP, this.fOB, this.iUO, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(198899);
            AAImagPreviewUI.f(AAImagPreviewUI.this);
            AppMethodBeat.o(198899);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(198898);
            AAImagPreviewUI.e(AAImagPreviewUI.this).setVisibility(0);
            AppMethodBeat.o(198898);
          }
        }, null);
      }
      AppMethodBeat.o(63487);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(198902);
    super.onBackPressed();
    aRo();
    AppMethodBeat.o(198902);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63486);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.iUJ = getIntent().getIntExtra("use_scene", 1);
    this.iUK = getIntent().getIntExtra("scene", 1);
    this.imagePath = getIntent().getStringExtra("path");
    this.hym = getIntent().getStringExtra("url");
    this.iUO = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("view_info"));
    initView();
    setResult(0);
    AppMethodBeat.o(63486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(63485);
      paramView = View.inflate(AAImagPreviewUI.this.getContext(), 2131492882, null);
      paramViewGroup = (MultiTouchImageView)paramView.findViewById(2131300914);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      AAImagPreviewUI.a(AAImagPreviewUI.this, paramViewGroup);
      AppMethodBeat.o(63485);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI
 * JD-Core Version:    0.7.0.1
 */