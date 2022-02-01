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
import android.content.res.Resources;
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
import com.tencent.mm.av.r.a;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;

public class AAImagPreviewUI
  extends MMActivity
{
  private View gvQ;
  private String imagePath;
  private String imageUrl;
  private int jUA;
  private int jUB;
  private Dialog jUC = null;
  private AnimationLayout jUD;
  private boolean jUE = false;
  private ViewAnimHelper.ViewInfo jUF;
  private ImageView jUG;
  private int jUH;
  private final int jUw = 1;
  private final int jUx = 2;
  private MMGestureGallery jUy;
  private a jUz;
  
  private static void a(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63489);
    ForceGpuUtil.decideLayerType(paramMultiTouchImageView, paramBitmap.getWidth(), paramBitmap.getHeight());
    int i = paramMultiTouchImageView.getWidth();
    int j = paramMultiTouchImageView.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
    float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
    Log.v("MicroMsg.PreviewHdHeadImg", "whDiv is " + f1 + " hwDiv is " + f2);
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
      paramMultiTouchImageView.cN(paramBitmap.getWidth(), paramBitmap.getHeight());
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
        Log.d("MicroMsg.PreviewHdHeadImg", " offsety ".concat(String.valueOf(f1)));
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
  
  private void bms()
  {
    AppMethodBeat.i(212959);
    if (this.jUE)
    {
      AppMethodBeat.o(212959);
      return;
    }
    this.jUE = true;
    Log.i("MicroMsg.PreviewHdHeadImg", "runExitAnimation");
    this.jUD.a(this.jUG, this.gvQ, this.jUF, new Animator.AnimatorListener()new ValueAnimator.AnimatorUpdateListener
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(212952);
        AAImagPreviewUI.this.finish();
        AAImagPreviewUI.this.overridePendingTransition(2130772188, 2130772189);
        AppMethodBeat.o(212952);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }, new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(212953);
        ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        AppMethodBeat.o(212953);
      }
    });
    AppMethodBeat.o(212959);
  }
  
  public void finish()
  {
    AppMethodBeat.i(63488);
    super.finish();
    bms();
    overridePendingTransition(2130772188, 2130772189);
    AppMethodBeat.o(63488);
  }
  
  public int getLayoutId()
  {
    return 2131492897;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63487);
    hideTitleView();
    fullScreenNoTitleBar(true);
    if (d.oD(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.jUD = ((AnimationLayout)findViewById(2131296763));
      this.gvQ = findViewById(2131307160);
      this.jUG = ((ImageView)findViewById(2131301854));
      if (this.jUF == null) {
        this.jUF = ViewAnimHelper.q(this.jUG, getContext().getWindow().getDecorView());
      }
      this.jUy = ((MMGestureGallery)findViewById(2131301853));
      this.jUy.setVerticalFadingEdgeEnabled(false);
      this.jUy.setHorizontalFadingEdgeEnabled(false);
      this.jUy.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void bmt()
        {
          AppMethodBeat.i(63477);
          AAImagPreviewUI.this.finish();
          AppMethodBeat.o(63477);
        }
      });
      this.jUy.setLongClickOverListener(new MMGestureGallery.c()
      {
        public final void bmu()
        {
          AppMethodBeat.i(63480);
          e locale = new e(AAImagPreviewUI.this, 1, false);
          locale.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(63478);
              paramAnonymous2m.kV(1, 2131762187);
              if (AAImagPreviewUI.a(AAImagPreviewUI.this) == 1) {
                paramAnonymous2m.a(2, AAImagPreviewUI.this.getContext().getResources().getColor(2131099818), AAImagPreviewUI.this.getString(2131762173));
              }
              AppMethodBeat.o(63478);
            }
          };
          locale.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63479);
              Log.i("MicroMsg.PreviewHdHeadImg", "onMMMenuItemSelected %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
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
          locale.dGm();
          AppMethodBeat.o(63480);
        }
      });
      this.jUz = new a((byte)0);
      this.jUy.setAdapter(this.jUz);
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
      if (!this.jUE)
      {
        this.jUE = true;
        Log.i("MicroMsg.PreviewHdHeadImg", "runEnterAnimation");
        this.jUD.b(this.jUG, this.gvQ, this.jUF, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(212958);
            AAImagPreviewUI.g(AAImagPreviewUI.this);
            AppMethodBeat.o(212958);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(212957);
            AAImagPreviewUI.f(AAImagPreviewUI.this).setVisibility(0);
            AppMethodBeat.o(212957);
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
    AppMethodBeat.i(212960);
    super.onBackPressed();
    bms();
    AppMethodBeat.o(212960);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63486);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772188, 2130772189);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.jUA = getIntent().getIntExtra("use_scene", 1);
    this.jUB = getIntent().getIntExtra("scene", 1);
    this.imagePath = getIntent().getStringExtra("path");
    this.imageUrl = getIntent().getStringExtra("url");
    this.jUF = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("view_info"));
    this.jUH = getIntent().getIntExtra("aa_type", 2);
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
      paramView = View.inflate(AAImagPreviewUI.this.getContext(), 2131492898, null);
      paramViewGroup = (MultiTouchImageView)paramView.findViewById(2131302526);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      AAImagPreviewUI.a(AAImagPreviewUI.this, paramViewGroup);
      AppMethodBeat.o(63485);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI
 * JD-Core Version:    0.7.0.1
 */