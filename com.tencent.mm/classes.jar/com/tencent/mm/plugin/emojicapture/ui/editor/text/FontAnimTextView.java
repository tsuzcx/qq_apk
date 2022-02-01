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
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "fontPaths", "", "[Ljava/lang/String;", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "typefaceIndex", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createTextBitmap", "typeface", "getText", "getTextColor", "onSizeChanged", "", "w", "h", "oldw", "oldh", "pause", "refresh", "resume", "switchFont", "updateText", "color", "change", "", "stroke", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FontAnimTextView
  extends ImageView
{
  public static final FontAnimTextView.a ynf;
  private CharSequence bba;
  private int strokeColor;
  private int textColor;
  private c ymM;
  private String[] ymP;
  private Typeface[] ymQ;
  private int ymR;
  private final Runnable ymS;
  private final int ymX;
  private int ymY;
  private final Bitmap[] ymZ;
  
  static
  {
    AppMethodBeat.i(818);
    ynf = new FontAnimTextView.a((byte)0);
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
    this.ymS = new FontAnimTextView..ExternalSyntheticLambda0(this);
    this.textColor = -1;
    this.strokeColor = -1;
    s.checkNotNull(paramContext);
    float f = paramContext.getResources().getDimension(a.d.ydW);
    int i;
    if (com.tencent.mm.modelemoji.b.bII().bIK())
    {
      paramContext = d.ygM;
      if (d.a.dDL())
      {
        com.tencent.mm.modelemoji.b.bII();
        paramContext = com.tencent.mm.modelemoji.b.bIL();
        s.s(paramContext, "getInstance().fontPath");
        this.ymP = paramContext;
        paramContext = d.ygM;
        this.ymM = ((c)new b(this.ymP, (int)f));
        i = this.ymP.length;
        paramContext = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramContext[paramInt] = Typeface.createFromFile(this.ymP[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.ymQ = paramContext;; this.ymQ = new Typeface[] { null })
    {
      this.ymX = this.ymQ.length;
      i = this.ymX;
      paramContext = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramContext[paramInt] = null;
        paramInt += 1;
      }
      this.ymP = new String[] { "" };
      h.OAn.p(933L, 3L, 1L);
      this.ymM = ((c)new a());
    }
    this.ymZ = paramContext;
    AppMethodBeat.o(817);
  }
  
  private static final void a(FontAnimTextView paramFontAnimTextView)
  {
    AppMethodBeat.i(269533);
    s.u(paramFontAnimTextView, "this$0");
    paramFontAnimTextView.dER();
    AppMethodBeat.o(269533);
  }
  
  private final void dER()
  {
    AppMethodBeat.i(815);
    this.ymY += 1;
    this.ymY %= this.ymX;
    Object localObject = this.ymQ[this.ymR];
    this.ymM.apq(this.ymP[this.ymR]);
    this.ymR += 1;
    this.ymR %= this.ymQ.length;
    if (this.ymZ[this.ymY] == null)
    {
      localObject = h((Typeface)localObject);
      this.ymZ[this.ymY] = localObject;
    }
    removeCallbacks(this.ymS);
    postDelayed(this.ymS, 100L);
    setImageBitmap(this.ymZ[this.ymY]);
    AppMethodBeat.o(815);
  }
  
  private final Bitmap h(Typeface paramTypeface)
  {
    AppMethodBeat.i(816);
    FontTextView localFontTextView = new FontTextView(getContext());
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    localFontTextView.setMaxWidth(i);
    localFontTextView.setTextDrawer(this.ymM);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.b(this.bba, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    s.s(paramTypeface, "bitmap");
    AppMethodBeat.o(816);
    return paramTypeface;
  }
  
  public final void bDL()
  {
    int j = 1;
    AppMethodBeat.i(814);
    CharSequence localCharSequence = this.bba;
    if (localCharSequence != null) {
      if (localCharSequence.length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label73;
        }
      }
    }
    label73:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label78;
      }
      k.b(this.ymZ, null);
      this.ymY = 0;
      this.ymR = 0;
      dER();
      AppMethodBeat.o(814);
      return;
      i = 0;
      break;
    }
    label78:
    removeCallbacks(this.ymS);
    setImageBitmap(null);
    AppMethodBeat.o(814);
  }
  
  public final void c(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(813);
    this.bba = paramCharSequence;
    this.textColor = paramInt1;
    this.strokeColor = paramInt2;
    bDL();
    AppMethodBeat.o(813);
  }
  
  public final CharSequence getText()
  {
    return this.bba;
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
      bDL();
    }
    AppMethodBeat.o(811);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(812);
    removeCallbacks(this.ymS);
    AppMethodBeat.o(812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView
 * JD-Core Version:    0.7.0.1
 */