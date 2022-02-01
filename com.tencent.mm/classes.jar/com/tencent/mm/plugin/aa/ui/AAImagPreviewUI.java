package com.tencent.mm.plugin.aa.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.aa.model.j;
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
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import com.tencent.mm.wallet_core.c;

public class AAImagPreviewUI
  extends MMActivity
{
  private String imagePath;
  private String imageUrl;
  private View lBX;
  private ViewAnimHelper.ViewInfo pIA;
  private ImageView pIB;
  private int pIC;
  private final int pIr = 1;
  private final int pIs = 2;
  private MMGestureGallery pIt;
  private a pIu;
  private int pIv;
  private int pIw;
  private Dialog pIx = null;
  private AnimationLayout pIy;
  private boolean pIz = false;
  
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
      paramMultiTouchImageView.dU(paramBitmap.getWidth(), paramBitmap.getHeight());
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
  
  private void bVs()
  {
    AppMethodBeat.i(268469);
    if (this.pIz)
    {
      AppMethodBeat.o(268469);
      return;
    }
    this.pIz = true;
    Log.i("MicroMsg.PreviewHdHeadImg", "runExitAnimation");
    this.pIy.a(this.pIB, this.lBX, this.pIA, new Animator.AnimatorListener()new ValueAnimator.AnimatorUpdateListener
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(268438);
        AAImagPreviewUI.this.finish();
        AAImagPreviewUI.this.overridePendingTransition(a.a.toast_fade_in, a.a.toast_fade_out);
        AppMethodBeat.o(268438);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }, new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(268432);
        ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        AppMethodBeat.o(268432);
      }
    });
    AppMethodBeat.o(268469);
  }
  
  public void finish()
  {
    AppMethodBeat.i(63488);
    super.finish();
    bVs();
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
    if (d.rb(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.pIy = ((AnimationLayout)findViewById(a.f.animation_layout));
      this.lBX = findViewById(a.f.root_container);
      this.pIB = ((ImageView)findViewById(a.f.gallery_bg));
      if (this.pIA == null) {
        this.pIA = ViewAnimHelper.z(this.pIB, getContext().getWindow().getDecorView());
      }
      this.pIt = ((MMGestureGallery)findViewById(a.f.gallery));
      this.pIt.setVerticalFadingEdgeEnabled(false);
      this.pIt.setHorizontalFadingEdgeEnabled(false);
      this.pIt.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void singleClickOver()
        {
          AppMethodBeat.i(63477);
          AAImagPreviewUI.this.finish();
          AppMethodBeat.o(63477);
        }
      });
      this.pIt.setLongClickOverListener(new MMGestureGallery.c()
      {
        public final void longClickOver()
        {
          AppMethodBeat.i(63480);
          f localf = new f(AAImagPreviewUI.this, 1, false);
          localf.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(63478);
              paramAnonymous2s.oh(1, a.i.launch_aa_save_imag);
              if (AAImagPreviewUI.a(AAImagPreviewUI.this) == 1) {
                paramAnonymous2s.a(2, AAImagPreviewUI.this.getContext().getResources().getColor(a.c.Red), AAImagPreviewUI.this.getString(a.i.launch_aa_delete_imag));
              }
              AppMethodBeat.o(63478);
            }
          };
          localf.GAC = new u.i()
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
          localf.dDn();
          AppMethodBeat.o(63480);
        }
      });
      this.pIu = new a((byte)0);
      this.pIt.setAdapter(this.pIu);
      this.pIt.setAccessibilityDelegate(new c()
      {
        public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          AppMethodBeat.i(268446);
          super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
          if (paramAnonymousAccessibilityEvent.getEventType() == 1) {
            AAImagPreviewUI.c(AAImagPreviewUI.this).getSingleClickOverListener().singleClickOver();
          }
          AppMethodBeat.o(268446);
        }
        
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          AppMethodBeat.i(268443);
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
          paramAnonymousAccessibilityNodeInfo.setClassName(Button.class.getName());
          paramAnonymousAccessibilityNodeInfo.setContentDescription(AAImagPreviewUI.this.getString(a.i.launch_aa_image_preview_close_accessibility));
          AppMethodBeat.o(268443);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(268442);
          AAImagPreviewUI.this.finish();
          AppMethodBeat.o(268442);
          return true;
        }
      });
      if (!this.pIz)
      {
        this.pIz = true;
        Log.i("MicroMsg.PreviewHdHeadImg", "runEnterAnimation");
        this.pIy.b(this.pIB, this.lBX, this.pIA, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(268439);
            AAImagPreviewUI.h(AAImagPreviewUI.this);
            AppMethodBeat.o(268439);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(268437);
            AAImagPreviewUI.g(AAImagPreviewUI.this).setVisibility(0);
            AppMethodBeat.o(268437);
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
    AppMethodBeat.i(268513);
    super.onBackPressed();
    bVs();
    AppMethodBeat.o(268513);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63486);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    overridePendingTransition(a.a.toast_fade_in, a.a.toast_fade_out);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.pIv = getIntent().getIntExtra("use_scene", 1);
    this.pIw = getIntent().getIntExtra("scene", 1);
    this.imagePath = getIntent().getStringExtra("path");
    this.imageUrl = getIntent().getStringExtra("url");
    this.pIA = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("view_info"));
    this.pIC = getIntent().getIntExtra("aa_type", 2);
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
      paramView.findViewById(a.f.image_ll).setImportantForAccessibility(2);
      AppMethodBeat.o(63485);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI
 * JD-Core Version:    0.7.0.1
 */