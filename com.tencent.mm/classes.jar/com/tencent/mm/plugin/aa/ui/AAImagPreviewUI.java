package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;

public class AAImagPreviewUI
  extends MMActivity
{
  private String gFC;
  private final int ibs = 1;
  private final int ibt = 2;
  private MMGestureGallery ibu;
  private AAImagPreviewUI.a ibv;
  private int ibw;
  private int ibx;
  private Dialog iby = null;
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
  
  public void finish()
  {
    AppMethodBeat.i(63488);
    super.finish();
    overridePendingTransition(0, 0);
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
    if (d.lf(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.ibu = ((MMGestureGallery)findViewById(2131300335));
      this.ibu.setVerticalFadingEdgeEnabled(false);
      this.ibu.setHorizontalFadingEdgeEnabled(false);
      this.ibu.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void aHo()
        {
          AppMethodBeat.i(63477);
          AAImagPreviewUI.this.finish();
          AppMethodBeat.o(63477);
        }
      });
      this.ibu.setLongClickOverListener(new MMGestureGallery.c()
      {
        public final void aHp()
        {
          AppMethodBeat.i(63480);
          e locale = new e(AAImagPreviewUI.this, 1, false);
          locale.HrX = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(63478);
              paramAnonymous2l.jj(1, 2131760662);
              if (AAImagPreviewUI.a(AAImagPreviewUI.this) == 1) {
                paramAnonymous2l.jj(2, 2131760653);
              }
              AppMethodBeat.o(63478);
            }
          };
          locale.HrY = new n.d()
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
          locale.csG();
          AppMethodBeat.o(63480);
        }
      });
      this.ibv = new AAImagPreviewUI.a(this, (byte)0);
      this.ibu.setAdapter(this.ibv);
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
      AppMethodBeat.o(63487);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63486);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.ibw = getIntent().getIntExtra("use_scene", 1);
    this.ibx = getIntent().getIntExtra("scene", 1);
    this.imagePath = getIntent().getStringExtra("path");
    this.gFC = getIntent().getStringExtra("url");
    initView();
    setResult(0);
    AppMethodBeat.o(63486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI
 * JD-Core Version:    0.7.0.1
 */