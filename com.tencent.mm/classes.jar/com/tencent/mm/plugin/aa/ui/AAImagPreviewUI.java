package com.tencent.mm.plugin.aa.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.p.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.AnimationLayout.4;
import com.tencent.mm.view.AnimationLayout.5;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;

public class AAImagPreviewUI
  extends MMActivity
{
  private View fvu;
  private String hgd;
  private int iBA;
  private Dialog iBB = null;
  private AnimationLayout iBC;
  private boolean iBD = false;
  private ViewAnimHelper.ViewInfo iBE;
  private ImageView iBF;
  private final int iBv = 1;
  private final int iBw = 2;
  private MMGestureGallery iBx;
  private a iBy;
  private int iBz;
  private String imagePath;
  
  private static void a(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63489);
    p.z(paramMultiTouchImageView, paramBitmap.getWidth(), paramBitmap.getHeight());
    int i = paramMultiTouchImageView.getWidth();
    int j = paramMultiTouchImageView.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
    float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
    ac.v("MicroMsg.PreviewHdHeadImg", "whDiv is " + f1 + " hwDiv is " + f2);
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
      paramMultiTouchImageView.cF(paramBitmap.getWidth(), paramBitmap.getHeight());
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
        ac.d("MicroMsg.PreviewHdHeadImg", " offsety ".concat(String.valueOf(f1)));
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
  
  private void aOc()
  {
    AppMethodBeat.i(206997);
    if (this.iBD)
    {
      AppMethodBeat.o(206997);
      return;
    }
    this.iBD = true;
    ac.i("MicroMsg.PreviewHdHeadImg", "runExitAnimation");
    this.iBC.a(this.iBF, this.fvu, this.iBE, new AAImagPreviewUI.10(this), new AAImagPreviewUI.2(this));
    AppMethodBeat.o(206997);
  }
  
  public void finish()
  {
    AppMethodBeat.i(63488);
    super.finish();
    aOc();
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
    if (d.kZ(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    AnimationLayout localAnimationLayout;
    Object localObject;
    for (;;)
    {
      this.iBC = ((AnimationLayout)findViewById(2131296674));
      this.fvu = findViewById(2131304241);
      this.iBF = ((ImageView)findViewById(2131300336));
      if (this.iBE == null) {
        this.iBE = ViewAnimHelper.n(this.iBF, getContext().getWindow().getDecorView());
      }
      this.iBx = ((MMGestureGallery)findViewById(2131300335));
      this.iBx.setVerticalFadingEdgeEnabled(false);
      this.iBx.setHorizontalFadingEdgeEnabled(false);
      this.iBx.setSingleClickOverListener(new AAImagPreviewUI.1(this));
      this.iBx.setLongClickOverListener(new MMGestureGallery.c()
      {
        public final void aOe()
        {
          AppMethodBeat.i(63480);
          e locale = new e(AAImagPreviewUI.this, 1, false);
          locale.ISu = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(63478);
              paramAnonymous2l.jw(1, 2131760662);
              if (AAImagPreviewUI.a(AAImagPreviewUI.this) == 1) {
                paramAnonymous2l.jw(2, 2131760653);
              }
              AppMethodBeat.o(63478);
            }
          };
          locale.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63479);
              ac.i("MicroMsg.PreviewHdHeadImg", "onMMMenuItemSelected %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
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
          locale.cED();
          AppMethodBeat.o(63480);
        }
      });
      this.iBy = new a((byte)0);
      this.iBx.setAdapter(this.iBy);
      setBackBtn(new AAImagPreviewUI.4(this));
      if (this.iBD) {
        break label311;
      }
      this.iBD = true;
      ac.i("MicroMsg.PreviewHdHeadImg", "runEnterAnimation");
      localAnimationLayout = this.iBC;
      localObject = this.iBF;
      localObject = new AnimationLayout.4(localAnimationLayout, this.fvu, this.iBE, (View)localObject, new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(206995);
          AAImagPreviewUI.f(AAImagPreviewUI.this);
          AppMethodBeat.o(206995);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(206994);
          AAImagPreviewUI.e(AAImagPreviewUI.this).setVisibility(0);
          AppMethodBeat.o(206994);
        }
      });
      if ((localAnimationLayout.getMeasuredState() & 0xFF000000) <= 0) {
        break;
      }
      ((Runnable)localObject).run();
      AppMethodBeat.o(63487);
      return;
      getWindow().setFlags(1024, 1024);
    }
    localAnimationLayout.getViewTreeObserver().addOnPreDrawListener(new AnimationLayout.5(localAnimationLayout, (Runnable)localObject));
    label311:
    AppMethodBeat.o(63487);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(206998);
    super.onBackPressed();
    aOc();
    AppMethodBeat.o(206998);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63486);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.iBz = getIntent().getIntExtra("use_scene", 1);
    this.iBA = getIntent().getIntExtra("scene", 1);
    this.imagePath = getIntent().getStringExtra("path");
    this.hgd = getIntent().getStringExtra("url");
    this.iBE = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("view_info"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI
 * JD-Core Version:    0.7.0.1
 */