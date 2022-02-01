package com.tencent.mm.ab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.PhotoEditText;

public final class f
  extends c
{
  private static final int mAA;
  private static final int mAB;
  private static final float mAz;
  private static TextPaint xe;
  public SpannableString mAC;
  public String mAD = "";
  public int mBgColor = -65536;
  public int mColor = -1;
  
  static
  {
    AppMethodBeat.i(9275);
    mAz = MMApplicationContext.getResources().getDimension(a.c.edit_text_size);
    mAA = (int)MMApplicationContext.getResources().getDimension(a.c.line_padding_text);
    mAB = (int)MMApplicationContext.getResources().getDimension(a.c.padding_text);
    TextPaint localTextPaint = new TextPaint(1);
    xe = localTextPaint;
    localTextPaint.setStrokeCap(Paint.Cap.ROUND);
    xe.setStyle(Paint.Style.FILL);
    xe.setDither(true);
    xe.setTextSize(mAz);
    AppMethodBeat.o(9275);
  }
  
  public f(Context paramContext, Matrix paramMatrix, String paramString1, Rect paramRect, SpannableString paramSpannableString, int paramInt1, int paramInt2, String paramString2)
  {
    super(paramContext, paramMatrix, paramString1, paramRect);
    this.mColor = paramInt1;
    this.mAC = paramSpannableString;
    this.mBgColor = paramInt2;
    this.mAD = paramString2;
  }
  
  protected final Bitmap aYQ()
  {
    AppMethodBeat.i(9273);
    xe.setColor(this.mColor);
    if (this.mAC == null)
    {
      AppMethodBeat.o(9273);
      return null;
    }
    PhotoEditText localPhotoEditText = new PhotoEditText(this.mContext);
    int i = a.br(this.mContext, a.c.edit_text_padding);
    localPhotoEditText.setPadding(i, 0, i, 0);
    localPhotoEditText.setTextBackground(this.mBgColor);
    localPhotoEditText.setTextColor(this.mColor);
    localPhotoEditText.setTextSize(Math.round(mAz / this.mContext.getResources().getDisplayMetrics().density));
    localPhotoEditText.setText(p.b(this.mContext, this.mAC, mAz / 1.3F));
    localPhotoEditText.setSingleLine(false);
    if (!TextUtils.isEmpty(this.mAD)) {
      if (y.ZC(this.mAD)) {
        localPhotoEditText.setTypeface(Typeface.createFromFile(this.mAD));
      }
    }
    for (;;)
    {
      localPhotoEditText.setMaxWidth((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - this.mContext.getResources().getDimension(a.c.edit_text_padding) * 2.0F));
      if ((this.mBgColor == 0) && (this.mColor != -16777216)) {
        localPhotoEditText.setShadowLayer(a.fromDPToPix(localPhotoEditText.getContext(), 3), 0.0F, a.fromDPToPix(localPhotoEditText.getContext(), 1), -2147483648);
      }
      localPhotoEditText.measure(0, 0);
      Bitmap localBitmap = Bitmap.createBitmap(localPhotoEditText.getMeasuredWidth() - i, localPhotoEditText.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localPhotoEditText.getLayout().getPaint().setColor(this.mColor);
      localCanvas.save();
      localCanvas.translate(-0.5F * i, 0.0F);
      localPhotoEditText.draw(localCanvas);
      localCanvas.restore();
      localCanvas.save();
      localCanvas.translate(i * 0.5F, 0.0F);
      localPhotoEditText.getLayout().draw(localCanvas);
      localCanvas.restore();
      AppMethodBeat.o(9273);
      return localBitmap;
      localPhotoEditText.setTypeface(Typeface.DEFAULT);
      continue;
      localPhotoEditText.setTypeface(localPhotoEditText.getTypeface(), 1);
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9274);
    super.setSelected(paramBoolean);
    if (!paramBoolean) {
      this.mAj = false;
    }
    AppMethodBeat.o(9274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ab.f
 * JD-Core Version:    0.7.0.1
 */