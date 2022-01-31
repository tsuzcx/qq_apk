package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.b.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.plugin.emojicapture.a.b;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.d;
import com.tencent.mm.plugin.report.service.h;
import java.util.Arrays;

public final class TextEditorItemView
  extends View
  implements a
{
  private static final String[] jqH = { "WXxiari.ttf", "WXkatonglemiao.ttf" };
  public static final TextEditorItemView.a jqI = new TextEditorItemView.a((byte)0);
  private final String TAG = "MicroMsg.TextEditorItemView";
  private final int contentPadding;
  private final Layout.Alignment dNX = Layout.Alignment.ALIGN_CENTER;
  private TextPaint dOi = new TextPaint();
  private float fLH;
  private boolean hJP;
  private float jms;
  private float jqA;
  private boolean jqB;
  public boolean jqC;
  private final int jqD;
  private int jqE;
  private final Bitmap[] jqF;
  private com.tencent.mm.plugin.emojicapture.ui.editor.a.c jqG;
  private String jqm;
  private Typeface[] jqn;
  private int jqo;
  private final Runnable jqp = (Runnable)new TextEditorItemView.d(this);
  private final float jqq = 1.0F;
  private final float jqr;
  private final boolean jqs;
  private TextPaint jqt = new TextPaint();
  private Rect jqu = new Rect();
  private final Paint jqv = new Paint(1);
  private final Path jqw = new Path();
  private final RectF jqx = new RectF();
  private float jqy;
  private float jqz;
  private StaticLayout layout;
  private String[] rdd;
  private CharSequence text = (CharSequence)"";
  
  public TextEditorItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextEditorItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextEditorItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramContext == null) {
      g.cUk();
    }
    float f = paramContext.getResources().getDimension(a.b.editor_text_item_size);
    int i;
    if (com.tencent.mm.an.b.NC().NF())
    {
      g.j(com.tencent.mm.an.b.NC(), "FontResLogic.getInstance()");
      paramAttributeSet = com.tencent.mm.an.b.NG();
      g.j(paramAttributeSet, "FontResLogic.getInstance().fontPath");
      this.rdd = paramAttributeSet;
      paramAttributeSet = com.tencent.mm.plugin.emojicapture.model.c.jko;
      this.jqG = ((com.tencent.mm.plugin.emojicapture.ui.editor.a.c)new com.tencent.mm.plugin.emojicapture.ui.editor.a.b(this.rdd, (int)f));
      i = ((Object[])this.rdd).length;
      paramAttributeSet = new Typeface[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = Typeface.createFromFile(this.rdd[paramInt]);
        paramInt += 1;
      }
    }
    for (this.jqn = paramAttributeSet;; this.jqn = new Typeface[] { null })
    {
      this.jqD = ((Object[])this.jqn).length;
      i = this.jqD;
      paramAttributeSet = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      this.rdd = new String[] { "" };
      h.nFQ.fy(3L);
      this.jqG = ((com.tencent.mm.plugin.emojicapture.ui.editor.a.c)new com.tencent.mm.plugin.emojicapture.ui.editor.a.a());
    }
    this.jqF = paramAttributeSet;
    this.jqz = paramContext.getResources().getDimension(a.b.editor_text_line_height);
    this.jqA = paramContext.getResources().getDimension(a.b.editor_text_line_spacing);
    paramAttributeSet = paramContext.getResources().getString(a.f.capture_emoji_text_default);
    g.j(paramAttributeSet, "context.resources.getStr…pture_emoji_text_default)");
    this.jqm = paramAttributeSet;
    this.contentPadding = paramContext.getResources().getDimensionPixelSize(a.b.editor_text_item_padding);
    this.dOi.setAntiAlias(true);
    this.dOi.setTextSize(f);
    this.dOi.setTypeface(this.jqn[0]);
    this.jqt.setStrokeWidth(paramContext.getResources().getDimension(a.b.editor_text_stroke));
    this.jqt.setAntiAlias(true);
    this.jqt.setTextSize(this.dOi.getTextSize());
    this.jqt.setStyle(Paint.Style.STROKE);
    this.jqt.setTypeface(this.jqn[0]);
    this.layout = new StaticLayout(this.text, this.dOi, getWidth(), this.dNX, this.jqq, this.jqr, this.jqs);
    aKV();
    this.jms = getResources().getDimension(a.b.editor_text_item_frame_padding);
    this.jqv.setColor(-1);
    this.jqv.setStyle(Paint.Style.STROKE);
    this.jqv.setStrokeWidth(getResources().getDimension(a.b.editor_text_item_frame_stroke));
    setLayerType(1, null);
    f = this.jms + this.jqv.getStrokeWidth();
    setPadding(0, (int)f, 0, (int)f);
  }
  
  private final void a(Canvas paramCanvas, int paramInt, float paramFloat)
  {
    if ((paramInt < 0) || (paramInt >= this.layout.getLineCount())) {
      return;
    }
    float f = this.layout.getLineLeft(paramInt) + getPaddingLeft();
    paramFloat = this.layout.getLineBaseline(paramInt) + paramFloat + getPaddingTop();
    boolean bool;
    if (this.layout.getEllipsisCount(paramInt) > 0)
    {
      bool = true;
      if (!bool) {
        break label166;
      }
    }
    label166:
    for (int i = this.layout.getLineStart(paramInt) + this.layout.getEllipsisStart(paramInt);; i = this.layout.getLineEnd(paramInt))
    {
      if (this.hJP) {
        this.jqG.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.jqt, bool);
      }
      this.jqG.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.dOi, bool);
      return;
      bool = false;
      break;
    }
  }
  
  private final void aKV()
  {
    this.jqE += 1;
    this.jqE %= this.jqD;
    this.dOi.setTypeface(this.jqn[this.jqo]);
    this.jqt.setTypeface(this.jqn[this.jqo]);
    this.jqG.Bo(this.rdd[this.jqo]);
    this.jqo += 1;
    this.jqo %= ((Object[])this.jqn).length;
    invalidate();
    int i;
    int j;
    if (this.hJP)
    {
      Object localObject = this.jqF;
      if (localObject == null) {
        g.cUk();
      }
      localObject = (Object[])localObject;
      int k = localObject.length;
      i = 0;
      if (i >= k) {
        break label238;
      }
      if ((Bitmap)localObject[i] == null) {
        break label226;
      }
      j = 1;
      label157:
      if (j != 0) {
        break label231;
      }
      i = 0;
      label163:
      if (i != 0) {
        break label243;
      }
    }
    label226:
    label231:
    label238:
    label243:
    for (boolean bool = true;; bool = false)
    {
      setDrawingCacheEnabled(bool);
      if (this.jqF[this.jqE] == null) {
        post((Runnable)new TextEditorItemView.c(this));
      }
      removeCallbacks(this.jqp);
      postDelayed(this.jqp, 100L);
      return;
      j = 0;
      break label157;
      i += 1;
      break;
      i = 1;
      break label163;
    }
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    g.k(paramRectF, "bounds");
    this.fLH = paramRectF.width();
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
        break label154;
      }
      i = 1;
      if (i == 0) {
        break label160;
      }
      this.hJP = false;
      this.text = ((CharSequence)this.jqm);
      this.dOi.setColor(2147483647);
      float f = com.tencent.mm.cb.a.fromDPToPix(getContext(), 1);
      this.dOi.setShadowLayer(f, 0.0F, f, -16777216);
    }
    for (;;)
    {
      this.jqt.setColor(paramInt2);
      this.jqG.setText(this.text);
      this.jqB = true;
      paramCharSequence = this.jqF;
      if (paramCharSequence != null)
      {
        paramCharSequence = (Object[])paramCharSequence;
        paramInt1 = paramCharSequence.length;
        g.k(paramCharSequence, "$receiver");
        Arrays.fill(paramCharSequence, 0, paramInt1, null);
      }
      this.jqE = 0;
      this.jqo = 0;
      requestLayout();
      postInvalidate();
      return;
      label154:
      i = 0;
      break;
      label160:
      this.hJP = true;
      if (paramCharSequence == null) {
        g.cUk();
      }
      this.text = paramCharSequence;
      this.dOi.setColor(paramInt1);
      this.dOi.clearShadowLayer();
      removeCallbacks(this.jqp);
      postDelayed(this.jqp, 100L);
    }
  }
  
  public final com.tencent.mm.plugin.emojicapture.model.a.a aKU()
  {
    if (!this.hJP) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(getLeft() + this.jqu.left, getTop() + this.jqu.top);
    return (com.tencent.mm.plugin.emojicapture.model.a.a)new d(this.jqF, localMatrix);
  }
  
  public final CharSequence getText()
  {
    if (this.hJP) {
      return this.text;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.hJP) {
      return this.dOi.getColor();
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    g.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.jqC) {
      paramCanvas.drawPath(this.jqw, this.jqv);
    }
    paramCanvas.save();
    paramCanvas.translate(-this.jqy, 0.0F);
    a(paramCanvas, 0, 0.0F);
    a(paramCanvas, 1, this.jqA);
    paramCanvas.restore();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 > this.fLH) {
      paramInt1 = (int)this.fLH;
    }
    paramInt1 -= this.contentPadding * 2;
    StaticLayout localStaticLayout2 = this.layout;
    StaticLayout localStaticLayout1 = localStaticLayout2;
    if (this.jqB)
    {
      if (paramInt1 < 0) {
        localStaticLayout1 = localStaticLayout2;
      }
    }
    else
    {
      this.layout = localStaticLayout1;
      paramInt1 = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
      if (paramInt1 > this.jqz) {
        this.jqz = paramInt1;
      }
      if (this.layout.getLineCount() > 1) {
        break label539;
      }
    }
    label539:
    for (paramInt1 = (int)this.jqz;; paramInt1 = (int)(this.jqz * 2.0F + this.jqA))
    {
      paramInt1 += getPaddingBottom() + getPaddingTop();
      float f4 = this.layout.getLineLeft(0);
      float f5 = this.layout.getLineRight(0);
      paramInt2 = getPaddingBottom();
      int i = getPaddingTop();
      float f2 = f4;
      float f3 = f5;
      if (this.layout.getLineCount() > 1)
      {
        f1 = f4;
        if (f4 > this.layout.getLineLeft(1)) {
          f1 = this.layout.getLineLeft(1);
        }
        f2 = f1;
        f3 = f5;
        if (f5 < this.layout.getLineRight(1))
        {
          f3 = this.layout.getLineRight(1);
          f2 = f1;
        }
      }
      this.jqy = (f2 - this.contentPadding);
      int j = (int)(f3 - f2 + this.contentPadding * 2);
      float f1 = this.contentPadding;
      f4 = this.contentPadding;
      this.jqu.set((int)f4, i, (int)(f3 - f2 + f1), paramInt1 - paramInt2);
      this.jqu.inset((int)(-this.jqt.getStrokeWidth() / 2.0F), 0);
      if ((this.jqC) && (this.layout.getLineCount() > 0))
      {
        this.jqx.set(this.jqu);
        this.jqx.inset(-this.jms, -this.jms);
        this.jqw.reset();
        this.jqw.addRoundRect(this.jqx, this.jms, this.jms, Path.Direction.CW);
      }
      setMeasuredDimension(j, paramInt1);
      return;
      this.jqG.refresh();
      if (Build.VERSION.SDK_INT >= 23)
      {
        localStaticLayout1 = StaticLayout.Builder.obtain(this.text, 0, this.text.length(), this.dOi, paramInt1).setAlignment(this.dNX).setIncludePad(this.jqs).setMaxLines(2).setLineSpacing(this.jqr, this.jqq).setEllipsize(TextUtils.TruncateAt.END).build();
        g.j(localStaticLayout1, "StaticLayout.Builder.obt…                 .build()");
      }
      for (;;)
      {
        this.jqB = false;
        break;
        localStaticLayout1 = new StaticLayout(this.text, this.dOi, paramInt1, this.dNX, this.jqq, this.jqr, this.jqs);
      }
    }
  }
  
  public final void pause()
  {
    removeCallbacks(this.jqp);
  }
  
  public final void resume()
  {
    aKV();
  }
  
  public final void setEditing(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */