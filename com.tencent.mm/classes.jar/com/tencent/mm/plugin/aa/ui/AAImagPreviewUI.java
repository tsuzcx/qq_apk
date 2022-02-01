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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.o;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;

public class AAImagPreviewUI
  extends MMActivity
{
  private View fQH;
  private String hBa;
  private MMGestureGallery iXA;
  private a iXB;
  private int iXC;
  private int iXD;
  private Dialog iXE = null;
  private AnimationLayout iXF;
  private boolean iXG = false;
  private ViewAnimHelper.ViewInfo iXH;
  private ImageView iXI;
  private final int iXy = 1;
  private final int iXz = 2;
  private String imagePath;
  
  private static void a(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63489);
    r.z(paramMultiTouchImageView, paramBitmap.getWidth(), paramBitmap.getHeight());
    int i = paramMultiTouchImageView.getWidth();
    int j = paramMultiTouchImageView.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
    float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
    ae.v("MicroMsg.PreviewHdHeadImg", "whDiv is " + f1 + " hwDiv is " + f2);
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
        ae.d("MicroMsg.PreviewHdHeadImg", " offsety ".concat(String.valueOf(f1)));
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
  
  private void aRN()
  {
    AppMethodBeat.i(189735);
    if (this.iXG)
    {
      AppMethodBeat.o(189735);
      return;
    }
    this.iXG = true;
    ae.i("MicroMsg.PreviewHdHeadImg", "runExitAnimation");
    this.iXF.a(this.iXI, this.fQH, this.iXH, new Animator.AnimatorListener()new AAImagPreviewUI.11
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(224224);
        AAImagPreviewUI.this.finish();
        AAImagPreviewUI.this.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(224224);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }, new AAImagPreviewUI.11(this));
    AppMethodBeat.o(189735);
  }
  
  public void finish()
  {
    AppMethodBeat.i(63488);
    super.finish();
    aRN();
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
    if (d.lA(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.iXF = ((AnimationLayout)findViewById(2131296674));
      this.fQH = findViewById(2131304241);
      this.iXI = ((ImageView)findViewById(2131300336));
      if (this.iXH == null) {
        this.iXH = ViewAnimHelper.o(this.iXI, getContext().getWindow().getDecorView());
      }
      this.iXA = ((MMGestureGallery)findViewById(2131300335));
      this.iXA.setVerticalFadingEdgeEnabled(false);
      this.iXA.setHorizontalFadingEdgeEnabled(false);
      this.iXA.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void aRO()
        {
          AppMethodBeat.i(63477);
          AAImagPreviewUI.this.finish();
          AppMethodBeat.o(63477);
        }
      });
      this.iXA.setLongClickOverListener(new MMGestureGallery.c()
      {
        public final void aRP()
        {
          AppMethodBeat.i(63480);
          e locale = new e(AAImagPreviewUI.this, 1, false);
          locale.LfS = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(63478);
              paramAnonymous2l.jM(1, 2131760662);
              if (AAImagPreviewUI.a(AAImagPreviewUI.this) == 1) {
                paramAnonymous2l.jM(2, 2131760653);
              }
              AppMethodBeat.o(63478);
            }
          };
          locale.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63479);
              ae.i("MicroMsg.PreviewHdHeadImg", "onMMMenuItemSelected %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
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
          locale.cPF();
          AppMethodBeat.o(63480);
        }
      });
      this.iXB = new a((byte)0);
      this.iXA.setAdapter(this.iXB);
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
      if (!this.iXG)
      {
        this.iXG = true;
        ae.i("MicroMsg.PreviewHdHeadImg", "runEnterAnimation");
        this.iXF.b(this.iXI, this.fQH, this.iXH, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(189734);
            AAImagPreviewUI.f(AAImagPreviewUI.this);
            AppMethodBeat.o(189734);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(224227);
            AAImagPreviewUI.e(AAImagPreviewUI.this).setVisibility(0);
            AppMethodBeat.o(224227);
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
    AppMethodBeat.i(189736);
    super.onBackPressed();
    aRN();
    AppMethodBeat.o(189736);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63486);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.iXC = getIntent().getIntExtra("use_scene", 1);
    this.iXD = getIntent().getIntExtra("scene", 1);
    this.imagePath = getIntent().getStringExtra("path");
    this.hBa = getIntent().getStringExtra("url");
    this.iXH = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("view_info"));
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