package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView;
import com.tencent.mm.plugin.emojicapture.ui.editor.a;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "editorRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "emojiItemView", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "stickerInfo", "Lcom/tencent/mm/sticker/StickerPack;", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "getAttachEmoji", "getAttachEmojiMatrix", "Landroid/graphics/Matrix;", "getText", "", "getTextColor", "onRecordStart", "", "onRecordStop", "pause", "resume", "setImitateEmoji", "emojiInfo", "setStickerInfo", "showImitateEmoji", "showTextHint", "text", "colorString", "plugin-emojicapture_release"})
public final class CaptureDecoration
  extends ConstraintLayout
{
  private f pRi;
  public final EditorItemContainer pVH;
  public final FontAnimTextView pVI;
  private final CaptureStickerHint pVJ;
  private EmojiEditorItemView pVK;
  private EmojiInfo pVL;
  
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
    View.inflate(paramContext, 2131493755, (ViewGroup)this);
    paramContext = findViewById(2131299335);
    p.g(paramContext, "findViewById(R.id.emoji_…re_editor_item_container)");
    this.pVH = ((EditorItemContainer)paramContext);
    paramContext = findViewById(2131299358);
    p.g(paramContext, "findViewById(R.id.emoji_capture_text_hint)");
    this.pVI = ((FontAnimTextView)paramContext);
    paramContext = findViewById(2131299349);
    p.g(paramContext, "findViewById(R.id.emoji_capture_sticker_hint)");
    this.pVJ = ((CaptureStickerHint)paramContext);
    this.pVH.setDeleteEnalbe(false);
    AppMethodBeat.o(619);
  }
  
  public final EmojiInfo getAttachEmoji()
  {
    return this.pVL;
  }
  
  public final Matrix getAttachEmojiMatrix()
  {
    AppMethodBeat.i(617);
    Object localObject2 = ((Iterable)this.pVH.getAllItemViews()).iterator();
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
    Object localObject = this.pVI.getText();
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
    int i = this.pVI.getTextColor();
    if (i != 0) {}
    for (i = c.Cr(i);; i = -1)
    {
      AppMethodBeat.o(616);
      return i;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(618);
    this.pVH.resume();
    this.pVI.refresh();
    AppMethodBeat.o(618);
  }
  
  public final void setImitateEmoji(EmojiInfo paramEmojiInfo)
  {
    this.pVL = paramEmojiInfo;
  }
  
  public final void setStickerInfo(f paramf)
  {
    Object localObject3 = null;
    AppMethodBeat.i(614);
    Object localObject1;
    Object localObject2;
    label44:
    int i;
    if (this.pRi != null)
    {
      localObject1 = this.pRi;
      if (localObject1 == null) {
        break label357;
      }
      localObject1 = ((f)localObject1).pQo;
      if (paramf == null) {
        break label363;
      }
      localObject2 = paramf.pQo;
      if (!(p.i(localObject1, localObject2) ^ true)) {}
    }
    else
    {
      this.pRi = paramf;
      this.pVJ.setVisibility(8);
      this.pVH.setVisibility(8);
      this.pVI.setVisibility(8);
      this.pVI.pause();
      if (paramf != null)
      {
        if (((CharSequence)paramf.title).length() != 0) {
          break label369;
        }
        i = 1;
        label116:
        if (i == 0) {
          break label374;
        }
        this.pVI.e(null, -16777216, c.Cs(-16777216));
        this.pVJ.setStickerPack(paramf);
      }
    }
    if (this.pVL != null)
    {
      paramf = this.pVL;
      if (paramf != null)
      {
        this.pVH.setVisibility(0);
        if (this.pVK == null) {
          this.pVH.ah((Runnable)new a(paramf, this));
        }
      }
    }
    if (this.pRi == null)
    {
      label269:
      label408:
      label462:
      if (this.pVL != null)
      {
        if (b.w(this.pVL))
        {
          paramf = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
          p.g(paramf, "plugin(IPluginEmoji::class.java)");
          localObject1 = ((com.tencent.mm.plugin.emoji.b.d)paramf).getProvider();
          localObject2 = this.pVL;
          paramf = localObject3;
          if (localObject2 != null) {
            paramf = ((EmojiInfo)localObject2).Lb();
          }
          paramf = ((e)localObject1).abv(paramf);
          localObject1 = this.pVL;
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject1 = ((EmojiInfo)localObject1).field_attachTextColor;
          if ((localObject1 == null) || (n.aE((CharSequence)localObject1))) {
            break label492;
          }
          localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pQW;
        }
        label357:
        label363:
        label492:
        for (i = d.a.acl((String)localObject1);; i = -1)
        {
          int j = c.Cs(i);
          this.pVI.e((CharSequence)paramf, i, j);
          if (!bt.isNullOrNil(paramf)) {
            this.pVI.setVisibility(0);
          }
          AppMethodBeat.o(614);
          return;
          localObject1 = null;
          break;
          localObject2 = null;
          break label44;
          label369:
          i = 0;
          break label116;
          label374:
          localObject2 = paramf.titleColor;
          localObject1 = paramf.Imq;
          if (!n.aE((CharSequence)localObject2))
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pQW;
            i = d.a.acl((String)localObject2);
            if (n.aE((CharSequence)localObject1)) {
              break label462;
            }
            localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pQW;
          }
          for (j = d.a.acl((String)localObject1);; j = c.Cs(i))
          {
            this.pVI.setVisibility(0);
            this.pVI.e((CharSequence)paramf.title, i, j);
            break;
            i = -1;
            break label408;
          }
          paramf = this.pVL;
          if (paramf != null)
          {
            paramf = paramf.field_attachedText;
            break label269;
          }
          paramf = null;
          break label269;
        }
      }
      this.pVI.e(null, -16777216, c.Cs(-16777216));
      this.pVH.setVisibility(8);
    }
    AppMethodBeat.o(614);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration$showImitateEmoji$1$1"})
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
      localEmojiEditorItemView.setEmojiInfo(this.pVM);
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
          p.g(localObject1, "context");
          f1 = ((Context)localObject1).getResources().getDimension(2131166204);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration
 * JD-Core Version:    0.7.0.1
 */