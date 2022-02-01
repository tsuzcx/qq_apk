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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.u;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;

public class AAImagPreviewUI
  extends MMActivity
{
  private String imagePath;
  private String imageUrl;
  private View jac;
  private final int mLJ = 1;
  private final int mLK = 2;
  private MMGestureGallery mLL;
  private a mLM;
  private int mLN;
  private int mLO;
  private Dialog mLP = null;
  private AnimationLayout mLQ;
  private boolean mLR = false;
  private ViewAnimHelper.ViewInfo mLS;
  private ImageView mLT;
  private int mLU;
  
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
      paramMultiTouchImageView.di(paramBitmap.getWidth(), paramBitmap.getHeight());
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
  
  private void bwA()
  {
    AppMethodBeat.i(205360);
    if (this.mLR)
    {
      AppMethodBeat.o(205360);
      return;
    }
    this.mLR = true;
    Log.i("MicroMsg.PreviewHdHeadImg", "runExitAnimation");
    this.mLQ.a(this.mLT, this.jac, this.mLS, new Animator.AnimatorListener()new ValueAnimator.AnimatorUpdateListener
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(220502);
        AAImagPreviewUI.this.finish();
        AAImagPreviewUI.this.overridePendingTransition(a.a.toast_fade_in, a.a.toast_fade_out);
        AppMethodBeat.o(220502);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }, new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(272804);
        ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        AppMethodBeat.o(272804);
      }
    });
    AppMethodBeat.o(205360);
  }
  
  public void finish()
  {
    AppMethodBeat.i(63488);
    super.finish();
    bwA();
    overridePendingTransition(a.a.toast_fade_in, a.a.toast_fade_out);
    AppMethodBeat.o(63488);
  }
  
  public int getLayoutId()
  {
    return a.g.aa_image_view;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63487);
    hideTitleView();
    fullScreenNoTitleBar(true);
    if (d.qV(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.mLQ = ((AnimationLayout)findViewById(a.f.animation_layout));
      this.jac = findViewById(a.f.root_container);
      this.mLT = ((ImageView)findViewById(a.f.gallery_bg));
      if (this.mLS == null) {
        this.mLS = ViewAnimHelper.q(this.mLT, getContext().getWindow().getDecorView());
      }
      this.mLL = ((MMGestureGallery)findViewById(a.f.gallery));
      this.mLL.setVerticalFadingEdgeEnabled(false);
      this.mLL.setHorizontalFadingEdgeEnabled(false);
      this.mLL.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void bwB()
        {
          AppMethodBeat.i(63477);
          AAImagPreviewUI.this.finish();
          AppMethodBeat.o(63477);
        }
      });
      this.mLL.setLongClickOverListener(new MMGestureGallery.c()
      {
        public final void bwC()
        {
          AppMethodBeat.i(63480);
          e locale = new e(AAImagPreviewUI.this, 1, false);
          locale.ODT = new q.f()
          {
            public final void onCreateMMMenu(o paramAnonymous2o)
            {
              AppMethodBeat.i(63478);
              paramAnonymous2o.mn(1, a.i.launch_aa_save_imag);
              if (AAImagPreviewUI.a(AAImagPreviewUI.this) == 1) {
                paramAnonymous2o.a(2, AAImagPreviewUI.this.getContext().getResources().getColor(a.c.Red), AAImagPreviewUI.this.getString(a.i.launch_aa_delete_imag));
              }
              AppMethodBeat.o(63478);
            }
          };
          locale.ODU = new q.g()
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
          locale.eik();
          AppMethodBeat.o(63480);
        }
      });
      this.mLM = new a((byte)0);
      this.mLL.setAdapter(this.mLM);
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
      if (!this.mLR)
      {
        this.mLR = true;
        Log.i("MicroMsg.PreviewHdHeadImg", "runEnterAnimation");
        this.mLQ.b(this.mLT, this.jac, this.mLS, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(200872);
            AAImagPreviewUI.g(AAImagPreviewUI.this);
            AppMethodBeat.o(200872);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(200871);
            AAImagPreviewUI.f(AAImagPreviewUI.this).setVisibility(0);
            AppMethodBeat.o(200871);
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
    AppMethodBeat.i(205361);
    super.onBackPressed();
    bwA();
    AppMethodBeat.o(205361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63486);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    overridePendingTransition(a.a.toast_fade_in, a.a.toast_fade_out);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.mLN = getIntent().getIntExtra("use_scene", 1);
    this.mLO = getIntent().getIntExtra("scene", 1);
    this.imagePath = getIntent().getStringExtra("path");
    this.imageUrl = getIntent().getStringExtra("url");
    this.mLS = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("view_info"));
    this.mLU = getIntent().getIntExtra("aa_type", 2);
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
      paramView = View.inflate(AAImagPreviewUI.this.getContext(), a.g.aa_image_view_item, null);
      paramViewGroup = (MultiTouchImageView)paramView.findViewById(a.f.image);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      AAImagPreviewUI.a(AAImagPreviewUI.this, paramViewGroup);
      AppMethodBeat.o(63485);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI
 * JD-Core Version:    0.7.0.1
 */