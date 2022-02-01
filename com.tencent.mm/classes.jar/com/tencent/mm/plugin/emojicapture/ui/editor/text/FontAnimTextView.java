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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "fontPaths", "", "[Ljava/lang/String;", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "typefaceIndex", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createTextBitmap", "typeface", "getText", "getTextColor", "onSizeChanged", "", "w", "h", "oldw", "oldh", "pause", "refresh", "resume", "switchFont", "updateText", "color", "change", "", "stroke", "Companion", "plugin-emojicapture_release"})
public final class FontAnimTextView
  extends ImageView
{
  public static final FontAnimTextView.a qeH;
  private final Bitmap[] qeA;
  private c qeo;
  private String[] qeq;
  private Typeface[] qer;
  private int qes;
  private final Runnable qet;
  private final int qey;
  private int qez;
  private int strokeColor;
  private CharSequence text;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(818);
    qeH = new FontAnimTextView.a((byte)0);
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
    this.qet = ((Runnable)new b(this));
    this.textColor = -1;
    this.strokeColor = -1;
    if (paramContext == null) {
      p.gkB();
    }
    float f = paramContext.getResources().getDimension(2131166194);
    int i;
    if (com.tencent.mm.aq.b.aHF().aHI())
    {
      paramContext = d.pXB;
      if (d.a.ckK())
      {
        p.g(com.tencent.mm.aq.b.aHF(), "FontResLogic.getInstance()");
        paramContext = com.tencent.mm.aq.b.aHJ();
        p.g(paramContext, "FontResLogic.getInstance().fontPath");
        this.qeq = paramContext;
        paramContext = d.pXB;
        this.qeo = ((c)new b(this.qeq, (int)f));
        i = this.qeq.length;
        paramContext = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramContext[paramInt] = Typeface.createFromFile(this.qeq[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.qer = paramContext;; this.qer = new Typeface[] { null })
    {
      this.qey = this.qer.length;
      i = this.qey;
      paramContext = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramContext[paramInt] = null;
        paramInt += 1;
      }
      this.qeq = new String[] { "" };
      g.yxI.A(933L, 3L);
      this.qeo = ((c)new a());
    }
    this.qeA = paramContext;
    AppMethodBeat.o(817);
  }
  
  private final void clO()
  {
    AppMethodBeat.i(815);
    this.qez += 1;
    this.qez %= this.qey;
    Object localObject = this.qer[this.qes];
    this.qeo.adi(this.qeq[this.qes]);
    this.qes += 1;
    this.qes %= this.qer.length;
    if (this.qeA[this.qez] == null)
    {
      localObject = d((Typeface)localObject);
      this.qeA[this.qez] = localObject;
    }
    removeCallbacks(this.qet);
    postDelayed(this.qet, 100L);
    setImageBitmap(this.qeA[this.qez]);
    AppMethodBeat.o(815);
  }
  
  private final Bitmap d(Typeface paramTypeface)
  {
    AppMethodBeat.i(816);
    FontTextView localFontTextView = new FontTextView(getContext());
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    localFontTextView.setMaxWidth(i);
    localFontTextView.setTextDrawer(this.qeo);
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
    removeCallbacks(this.qet);
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
        e.O(this.qeA);
        this.qez = 0;
        this.qes = 0;
        clO();
        AppMethodBeat.o(814);
        return;
      }
    }
    removeCallbacks(this.qet);
    setImageBitmap(null);
    AppMethodBeat.o(814);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FontAnimTextView paramFontAnimTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(810);
      FontAnimTextView.a(this.qeI);
      AppMethodBeat.o(810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView
 * JD-Core Version:    0.7.0.1
 */