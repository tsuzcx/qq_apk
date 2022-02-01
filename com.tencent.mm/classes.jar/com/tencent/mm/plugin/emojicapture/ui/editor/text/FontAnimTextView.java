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
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.editor.FontTextView;
import com.tencent.mm.plugin.report.service.h;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "fontPaths", "", "[Ljava/lang/String;", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "typefaceIndex", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createTextBitmap", "typeface", "getText", "getTextColor", "onSizeChanged", "", "w", "h", "oldw", "oldh", "pause", "refresh", "resume", "switchFont", "updateText", "color", "change", "", "stroke", "Companion", "plugin-emojicapture_release"})
public final class FontAnimTextView
  extends ImageView
{
  public static final a vbj;
  private CharSequence LV;
  private int strokeColor;
  private int textColor;
  private c vaQ;
  private String[] vaS;
  private Typeface[] vaT;
  private int vaU;
  private final Runnable vaV;
  private final int vba;
  private int vbb;
  private final Bitmap[] vbc;
  
  static
  {
    AppMethodBeat.i(818);
    vbj = new a((byte)0);
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
    this.vaV = ((Runnable)new b(this));
    this.textColor = -1;
    this.strokeColor = -1;
    if (paramContext == null) {
      p.iCn();
    }
    float f = paramContext.getResources().getDimension(a.d.uRi);
    int i;
    if (com.tencent.mm.at.b.bkO().bkR())
    {
      paramContext = d.uUg;
      if (d.a.cXv())
      {
        p.j(com.tencent.mm.at.b.bkO(), "FontResLogic.getInstance()");
        paramContext = com.tencent.mm.at.b.bkS();
        p.j(paramContext, "FontResLogic.getInstance().fontPath");
        this.vaS = paramContext;
        paramContext = d.uUg;
        this.vaQ = ((c)new b(this.vaS, (int)f));
        i = this.vaS.length;
        paramContext = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramContext[paramInt] = Typeface.createFromFile(this.vaS[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.vaT = paramContext;; this.vaT = new Typeface[] { null })
    {
      this.vba = this.vaT.length;
      i = this.vba;
      paramContext = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramContext[paramInt] = null;
        paramInt += 1;
      }
      this.vaS = new String[] { "" };
      h.IzE.F(933L, 3L);
      this.vaQ = ((c)new a());
    }
    this.vbc = paramContext;
    AppMethodBeat.o(817);
  }
  
  private final void cYA()
  {
    AppMethodBeat.i(815);
    this.vbb += 1;
    this.vbb %= this.vba;
    Object localObject = this.vaT[this.vaU];
    this.vaQ.avq(this.vaS[this.vaU]);
    this.vaU += 1;
    this.vaU %= this.vaT.length;
    if (this.vbc[this.vbb] == null)
    {
      localObject = e((Typeface)localObject);
      this.vbc[this.vbb] = localObject;
    }
    removeCallbacks(this.vaV);
    postDelayed(this.vaV, 100L);
    setImageBitmap(this.vbc[this.vbb]);
    AppMethodBeat.o(815);
  }
  
  private final Bitmap e(Typeface paramTypeface)
  {
    AppMethodBeat.i(816);
    FontTextView localFontTextView = new FontTextView(getContext());
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    localFontTextView.setMaxWidth(i);
    localFontTextView.setTextDrawer(this.vaQ);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.LV, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    p.j(paramTypeface, "bitmap");
    AppMethodBeat.o(816);
    return paramTypeface;
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(814);
    CharSequence localCharSequence = this.LV;
    if (localCharSequence != null)
    {
      if (localCharSequence.length() > 0) {}
      for (int i = 1; i == 1; i = 0)
      {
        e.R(this.vbc);
        this.vbb = 0;
        this.vaU = 0;
        cYA();
        AppMethodBeat.o(814);
        return;
      }
    }
    removeCallbacks(this.vaV);
    setImageBitmap(null);
    AppMethodBeat.o(814);
  }
  
  public final void e(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(813);
    this.LV = paramCharSequence;
    this.textColor = paramInt1;
    this.strokeColor = paramInt2;
    bfU();
    AppMethodBeat.o(813);
  }
  
  public final CharSequence getText()
  {
    return this.LV;
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
      bfU();
    }
    AppMethodBeat.o(811);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(812);
    removeCallbacks(this.vaV);
    AppMethodBeat.o(812);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView$Companion;", "", "()V", "ANIM_INTERVAL", "", "TEXT_COLOR_INVALID", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FontAnimTextView paramFontAnimTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(810);
      FontAnimTextView.a(this.vbk);
      AppMethodBeat.o(810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView
 * JD-Core Version:    0.7.0.1
 */