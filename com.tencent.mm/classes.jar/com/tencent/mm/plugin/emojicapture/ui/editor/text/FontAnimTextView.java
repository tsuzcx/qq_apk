package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.editor.FontTextView;
import com.tencent.mm.plugin.report.service.g;
import d.a.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "fontPaths", "", "[Ljava/lang/String;", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "typefaceIndex", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createTextBitmap", "typeface", "getText", "getTextColor", "onSizeChanged", "", "w", "h", "oldw", "oldh", "pause", "refresh", "resume", "switchFont", "updateText", "color", "change", "", "stroke", "Companion", "plugin-emojicapture_release"})
public final class FontAnimTextView
  extends ImageView
{
  public static final FontAnimTextView.a pYc;
  private c pXJ;
  private String[] pXL;
  private Typeface[] pXM;
  private int pXN;
  private final Runnable pXO;
  private final int pXT;
  private int pXU;
  private final Bitmap[] pXV;
  private int strokeColor;
  private CharSequence text;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(818);
    pYc = new FontAnimTextView.a((byte)0);
    AppMethodBeat.o(818);
  }
  
  public FontAnimTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FontAnimTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(817);
    this.pXO = ((Runnable)new b(this));
    this.textColor = -1;
    this.strokeColor = -1;
    if (paramContext == null) {
      p.gfZ();
    }
    float f = paramContext.getResources().getDimension(2131166194);
    int i;
    if (com.tencent.mm.ar.b.aHo().aHr())
    {
      paramContext = d.pQW;
      if (d.a.cju())
      {
        p.g(com.tencent.mm.ar.b.aHo(), "FontResLogic.getInstance()");
        paramContext = com.tencent.mm.ar.b.aHs();
        p.g(paramContext, "FontResLogic.getInstance().fontPath");
        this.pXL = paramContext;
        paramContext = d.pQW;
        this.pXJ = ((c)new b(this.pXL, (int)f));
        i = this.pXL.length;
        paramContext = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramContext[paramInt] = Typeface.createFromFile(this.pXL[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.pXM = paramContext;; this.pXM = new Typeface[] { null })
    {
      this.pXT = this.pXM.length;
      i = this.pXT;
      paramContext = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramContext[paramInt] = null;
        paramInt += 1;
      }
      this.pXL = new String[] { "" };
      g.yhR.A(933L, 3L);
      this.pXJ = ((c)new a());
    }
    this.pXV = paramContext;
    AppMethodBeat.o(817);
  }
  
  private final void cky()
  {
    AppMethodBeat.i(815);
    this.pXU += 1;
    this.pXU %= this.pXT;
    Object localObject = this.pXM[this.pXN];
    this.pXJ.acr(this.pXL[this.pXN]);
    this.pXN += 1;
    this.pXN %= this.pXM.length;
    if (this.pXV[this.pXU] == null)
    {
      localObject = d((Typeface)localObject);
      this.pXV[this.pXU] = localObject;
    }
    removeCallbacks(this.pXO);
    postDelayed(this.pXO, 100L);
    setImageBitmap(this.pXV[this.pXU]);
    AppMethodBeat.o(815);
  }
  
  private final Bitmap d(Typeface paramTypeface)
  {
    AppMethodBeat.i(816);
    FontTextView localFontTextView = new FontTextView(getContext());
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    localFontTextView.setMaxWidth(i);
    localFontTextView.setTextDrawer(this.pXJ);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.text, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    p.g(paramTypeface, "bitmap");
    AppMethodBeat.o(816);
    return paramTypeface;
  }
  
  public final void e(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(813);
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.strokeColor = paramInt2;
    refresh();
    AppMethodBeat.o(813);
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextColor()
  {
    return this.textColor;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(811);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      refresh();
    }
    AppMethodBeat.o(811);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(812);
    removeCallbacks(this.pXO);
    AppMethodBeat.o(812);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(814);
    CharSequence localCharSequence = this.text;
    if (localCharSequence != null)
    {
      if (localCharSequence.length() > 0) {}
      for (int i = 1; i == 1; i = 0)
      {
        e.P(this.pXV);
        this.pXU = 0;
        this.pXN = 0;
        cky();
        AppMethodBeat.o(814);
        return;
      }
    }
    removeCallbacks(this.pXO);
    setImageBitmap(null);
    AppMethodBeat.o(814);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FontAnimTextView paramFontAnimTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(810);
      FontAnimTextView.a(this.pYd);
      AppMethodBeat.o(810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView
 * JD-Core Version:    0.7.0.1
 */