package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView;
import com.tencent.mm.plugin.emojicapture.ui.editor.a;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "editorRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "emojiItemView", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "stickerInfo", "Lcom/tencent/mm/sticker/StickerPack;", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "validAreaView", "Landroid/view/View;", "getAttachEmoji", "getAttachEmojiMatrix", "Landroid/graphics/Matrix;", "getText", "", "getTextColor", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onRecordStart", "", "onRecordStop", "pause", "resume", "setImitateEmoji", "emojiInfo", "setStickerInfo", "showImitateEmoji", "showTextHint", "text", "colorString", "plugin-emojicapture_release"})
public final class CaptureDecoration
  extends ConstraintLayout
{
  private f uUr;
  public final EditorItemContainer uYO;
  public final FontAnimTextView uYP;
  private final CaptureStickerHint uYQ;
  private final View uYR;
  private EmojiEditorItemView uYS;
  private EmojiInfo uYT;
  
  public CaptureDecoration(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(620);
    AppMethodBeat.o(620);
  }
  
  public CaptureDecoration(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(619);
    View.inflate(paramContext, a.g.emoji_capture_sticker_hint, (ViewGroup)this);
    paramContext = findViewById(a.f.uRK);
    p.j(paramContext, "findViewById(R.id.emoji_…re_editor_item_container)");
    this.uYO = ((EditorItemContainer)paramContext);
    paramContext = findViewById(a.f.uSb);
    p.j(paramContext, "findViewById(R.id.emoji_capture_text_hint)");
    this.uYP = ((FontAnimTextView)paramContext);
    paramContext = findViewById(a.f.emoji_capture_sticker_hint);
    p.j(paramContext, "findViewById(R.id.emoji_capture_sticker_hint)");
    this.uYQ = ((CaptureStickerHint)paramContext);
    paramContext = findViewById(a.f.uRP);
    p.j(paramContext, "findViewById(R.id.emoji_capture_editor_valid_area)");
    this.uYR = paramContext;
    this.uYO.setDeleteEnalbe(false);
    AppMethodBeat.o(619);
  }
  
  public final EmojiInfo getAttachEmoji()
  {
    return this.uYT;
  }
  
  public final Matrix getAttachEmojiMatrix()
  {
    AppMethodBeat.i(617);
    Object localObject2 = ((Iterable)this.uYO.getAllItemViews()).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((a)localObject1 instanceof EmojiEditorItemView))
      {
        if ((localObject1 instanceof EmojiEditorItemView)) {
          break label98;
        }
        localObject1 = null;
      }
    }
    label98:
    for (;;)
    {
      localObject1 = (EmojiEditorItemView)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((EmojiEditorItemView)localObject1).getTouchMatrix();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = new Matrix();
      }
      AppMethodBeat.o(617);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final String getText()
  {
    AppMethodBeat.i(615);
    Object localObject = this.uYP.getText();
    if (localObject != null)
    {
      localObject = localObject.toString();
      AppMethodBeat.o(615);
      return localObject;
    }
    AppMethodBeat.o(615);
    return null;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(616);
    int i = this.uYP.getTextColor();
    if (i != 0) {}
    for (i = c.JV(i);; i = -1)
    {
      AppMethodBeat.o(616);
      return i;
    }
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(203292);
    if (paramWindowInsets == null)
    {
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      p.j(paramWindowInsets, "super.onApplyWindowInsets(insets)");
      AppMethodBeat.o(203292);
      return paramWindowInsets;
    }
    ViewGroup.LayoutParams localLayoutParams = this.uYR.getLayoutParams();
    Object localObject = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      localObject = null;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (localObject != null)
    {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (getResources().getDimensionPixelSize(a.d.uRq) + paramWindowInsets.getSystemWindowInsetTop());
      this.uYR.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    p.j(paramWindowInsets, "super.onApplyWindowInsets(insets)");
    AppMethodBeat.o(203292);
    return paramWindowInsets;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(618);
    this.uYO.resume();
    this.uYP.bfU();
    AppMethodBeat.o(618);
  }
  
  public final void setImitateEmoji(EmojiInfo paramEmojiInfo)
  {
    this.uYT = paramEmojiInfo;
  }
  
  public final void setStickerInfo(f paramf)
  {
    Object localObject3 = null;
    AppMethodBeat.i(614);
    Object localObject1;
    Object localObject2;
    label44:
    int i;
    if (this.uUr != null)
    {
      localObject1 = this.uUr;
      if (localObject1 == null) {
        break label361;
      }
      localObject1 = ((f)localObject1).uTz;
      if (paramf == null) {
        break label367;
      }
      localObject2 = paramf.uTz;
      if (!(p.h(localObject1, localObject2) ^ true)) {}
    }
    else
    {
      this.uUr = paramf;
      this.uYQ.setVisibility(8);
      this.uYO.setVisibility(8);
      this.uYP.setVisibility(8);
      this.uYP.pause();
      if (paramf != null)
      {
        if (((CharSequence)paramf.title).length() != 0) {
          break label373;
        }
        i = 1;
        label116:
        if (i == 0) {
          break label378;
        }
        this.uYP.e(null, -16777216, c.JW(-16777216));
        this.uYQ.setStickerPack(paramf);
      }
    }
    if (this.uYT != null)
    {
      paramf = this.uYT;
      if (paramf != null)
      {
        this.uYO.setVisibility(0);
        if (this.uYS == null) {
          this.uYO.aq((Runnable)new a(paramf, this));
        }
      }
    }
    if (this.uUr == null)
    {
      label273:
      label412:
      label466:
      if (this.uYT != null)
      {
        if (b.x(this.uYT))
        {
          paramf = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
          p.j(paramf, "plugin(IPluginEmoji::class.java)");
          localObject1 = ((com.tencent.mm.plugin.emoji.b.d)paramf).getProvider();
          localObject2 = this.uYT;
          paramf = localObject3;
          if (localObject2 != null) {
            paramf = ((EmojiInfo)localObject2).getMd5();
          }
          paramf = ((e)localObject1).auh(paramf);
          localObject1 = this.uYT;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((EmojiInfo)localObject1).field_attachTextColor;
          if ((localObject1 == null) || (n.ba((CharSequence)localObject1))) {
            break label496;
          }
          localObject2 = com.tencent.mm.plugin.emojicapture.model.d.uUg;
        }
        label361:
        label367:
        label496:
        for (i = d.a.avj((String)localObject1);; i = -1)
        {
          int j = c.JW(i);
          this.uYP.e((CharSequence)paramf, i, j);
          if (!Util.isNullOrNil(paramf)) {
            this.uYP.setVisibility(0);
          }
          AppMethodBeat.o(614);
          return;
          localObject1 = null;
          break;
          localObject2 = null;
          break label44;
          label373:
          i = 0;
          break label116;
          label378:
          localObject2 = paramf.lnt;
          localObject1 = paramf.Vbb;
          if (!n.ba((CharSequence)localObject2))
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.uUg;
            i = d.a.avj((String)localObject2);
            if (n.ba((CharSequence)localObject1)) {
              break label466;
            }
            localObject2 = com.tencent.mm.plugin.emojicapture.model.d.uUg;
          }
          for (j = d.a.avj((String)localObject1);; j = c.JW(i))
          {
            this.uYP.setVisibility(0);
            this.uYP.e((CharSequence)paramf.title, i, j);
            break;
            i = -1;
            break label412;
          }
          paramf = this.uYT;
          if (paramf != null)
          {
            paramf = paramf.field_attachedText;
            break label273;
          }
          paramf = null;
          break label273;
        }
      }
      this.uYP.e(null, -16777216, c.JW(-16777216));
      this.uYO.setVisibility(8);
    }
    AppMethodBeat.o(614);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration$showImitateEmoji$1$1"})
  static final class a
    implements Runnable
  {
    a(EmojiInfo paramEmojiInfo, CaptureDecoration paramCaptureDecoration) {}
    
    public final void run()
    {
      AppMethodBeat.i(613);
      if (CaptureDecoration.a(jdField_this) != null)
      {
        AppMethodBeat.o(613);
        return;
      }
      Object localObject1 = CaptureDecoration.b(jdField_this).getValidRect();
      EmojiEditorItemView localEmojiEditorItemView = new EmojiEditorItemView(jdField_this.getContext());
      localEmojiEditorItemView.setEmojiInfo(this.uYU);
      localEmojiEditorItemView.resume();
      CaptureDecoration.a(jdField_this, localEmojiEditorItemView);
      EditorItemContainer.a(CaptureDecoration.b(jdField_this), (a)localEmojiEditorItemView);
      Object localObject2 = localEmojiEditorItemView.getDrawable();
      if (localObject2 != null)
      {
        int i = ((Drawable)localObject2).getIntrinsicWidth();
        int j = ((Drawable)localObject2).getIntrinsicHeight();
        float f1 = ((RectF)localObject1).width();
        float f2 = ((RectF)localObject1).height();
        if (i > j)
        {
          f1 /= 3.0F;
          f2 = j * f1 / i;
        }
        for (;;)
        {
          localObject2 = localEmojiEditorItemView.getTouchMatrix();
          float f3 = i;
          float f4 = j;
          float f5 = ((RectF)localObject1).right;
          float f6 = ((RectF)localObject1).bottom;
          float f7 = ((RectF)localObject1).right;
          float f8 = ((RectF)localObject1).bottom;
          ((Matrix)localObject2).setPolyToPoly(new float[] { 0.0F, 0.0F, f3, f4 }, 0, new float[] { f5 - f1, f6 - f2, f7, f8 }, 0, 2);
          localObject1 = jdField_this.getContext();
          p.j(localObject1, "context");
          f1 = ((Context)localObject1).getResources().getDimension(a.d.uRm);
          localEmojiEditorItemView.getTouchMatrix().postTranslate(-f1 / 2.0F, -f1 / 2.0F);
          AppMethodBeat.o(613);
          return;
          f2 /= 3.0F;
          f1 = i * f2 / j;
        }
      }
      AppMethodBeat.o(613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration
 * JD-Core Version:    0.7.0.1
 */