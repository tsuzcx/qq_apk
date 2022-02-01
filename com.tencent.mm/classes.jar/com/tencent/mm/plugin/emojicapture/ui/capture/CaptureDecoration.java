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
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.b;
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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "editorRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "emojiItemView", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "stickerInfo", "Lcom/tencent/mm/sticker/StickerPack;", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "validAreaView", "Landroid/view/View;", "getAttachEmoji", "getAttachEmojiMatrix", "Landroid/graphics/Matrix;", "getText", "", "getTextColor", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onRecordStart", "", "onRecordStop", "pause", "resume", "setImitateEmoji", "emojiInfo", "setStickerInfo", "showImitateEmoji", "showTextHint", "text", "colorString", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CaptureDecoration
  extends ConstraintLayout
{
  private f yhc;
  public final EditorItemContainer ykW;
  public final FontAnimTextView ykX;
  private final CaptureStickerHint ykY;
  private final View ykZ;
  private EmojiEditorItemView yla;
  private EmojiInfo ylb;
  
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
    paramContext = findViewById(a.f.yey);
    s.s(paramContext, "findViewById(R.id.emoji_…re_editor_item_container)");
    this.ykW = ((EditorItemContainer)paramContext);
    paramContext = findViewById(a.f.yeP);
    s.s(paramContext, "findViewById(R.id.emoji_capture_text_hint)");
    this.ykX = ((FontAnimTextView)paramContext);
    paramContext = findViewById(a.f.emoji_capture_sticker_hint);
    s.s(paramContext, "findViewById(R.id.emoji_capture_sticker_hint)");
    this.ykY = ((CaptureStickerHint)paramContext);
    paramContext = findViewById(a.f.yeD);
    s.s(paramContext, "findViewById(R.id.emoji_capture_editor_valid_area)");
    this.ykZ = paramContext;
    this.ykW.setDeleteEnalbe(false);
    AppMethodBeat.o(619);
  }
  
  private static final void a(CaptureDecoration paramCaptureDecoration, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(269580);
    s.u(paramCaptureDecoration, "this$0");
    s.u(paramEmojiInfo, "$it");
    if (paramCaptureDecoration.yla != null)
    {
      AppMethodBeat.o(269580);
      return;
    }
    RectF localRectF = paramCaptureDecoration.ykW.getValidRect();
    EmojiEditorItemView localEmojiEditorItemView = new EmojiEditorItemView(paramCaptureDecoration.getContext());
    localEmojiEditorItemView.setEmojiInfo(paramEmojiInfo);
    localEmojiEditorItemView.resume();
    paramCaptureDecoration.yla = localEmojiEditorItemView;
    EditorItemContainer.a(paramCaptureDecoration.ykW, (a)localEmojiEditorItemView);
    paramEmojiInfo = localEmojiEditorItemView.getDrawable();
    int i;
    int j;
    float f1;
    float f2;
    if (paramEmojiInfo != null)
    {
      i = paramEmojiInfo.getIntrinsicWidth();
      j = paramEmojiInfo.getIntrinsicHeight();
      f1 = localRectF.width();
      f2 = localRectF.height();
      if (i <= j) {
        break label274;
      }
      f1 /= 3.0F;
      f2 = j * f1 / i;
    }
    for (;;)
    {
      paramEmojiInfo = localEmojiEditorItemView.getTouchMatrix();
      float f3 = i;
      float f4 = j;
      float f5 = localRectF.right;
      float f6 = localRectF.bottom;
      float f7 = localRectF.right;
      float f8 = localRectF.bottom;
      paramEmojiInfo.setPolyToPoly(new float[] { 0.0F, 0.0F, f3, f4 }, 0, new float[] { f5 - f1, f6 - f2, f7, f8 }, 0, 2);
      f1 = paramCaptureDecoration.getContext().getResources().getDimension(a.d.yea);
      localEmojiEditorItemView.getTouchMatrix().postTranslate(-f1 / 2.0F, -f1 / 2.0F);
      AppMethodBeat.o(269580);
      return;
      label274:
      f2 /= 3.0F;
      f1 = i * f2 / j;
    }
  }
  
  public final EmojiInfo getAttachEmoji()
  {
    return this.ylb;
  }
  
  public final Matrix getAttachEmojiMatrix()
  {
    AppMethodBeat.i(617);
    Iterator localIterator = ((Iterable)this.ykW.getAllItemViews()).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((a)localObject instanceof EmojiEditorItemView))
      {
        if (!(localObject instanceof EmojiEditorItemView)) {
          break label91;
        }
        localObject = (EmojiEditorItemView)localObject;
        label60:
        if (localObject != null) {
          break label96;
        }
      }
    }
    label91:
    label96:
    for (Object localObject = null;; localObject = ((EmojiEditorItemView)localObject).getTouchMatrix())
    {
      if (localObject != null) {
        break label104;
      }
      localObject = new Matrix();
      AppMethodBeat.o(617);
      return localObject;
      localObject = null;
      break;
      localObject = null;
      break label60;
    }
    label104:
    AppMethodBeat.o(617);
    return localObject;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(615);
    Object localObject = this.ykX.getText();
    if (localObject == null)
    {
      AppMethodBeat.o(615);
      return null;
    }
    localObject = localObject.toString();
    AppMethodBeat.o(615);
    return localObject;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(616);
    int i = this.ykX.getTextColor();
    if (i != 0) {}
    for (i = b.KT(i);; i = -1)
    {
      AppMethodBeat.o(616);
      return i;
    }
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(269603);
    if (paramWindowInsets == null)
    {
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      s.s(paramWindowInsets, "super.onApplyWindowInsets(insets)");
      AppMethodBeat.o(269603);
      return paramWindowInsets;
    }
    Object localObject = this.ykZ.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {}
    for (localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = (getResources().getDimensionPixelSize(a.d.yee) + paramWindowInsets.getSystemWindowInsetTop());
        this.ykZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      s.s(paramWindowInsets, "super.onApplyWindowInsets(insets)");
      AppMethodBeat.o(269603);
      return paramWindowInsets;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(618);
    this.ykW.resume();
    this.ykX.bDL();
    AppMethodBeat.o(618);
  }
  
  public final void setImitateEmoji(EmojiInfo paramEmojiInfo)
  {
    this.ylb = paramEmojiInfo;
  }
  
  public final void setStickerInfo(f paramf)
  {
    Object localObject3 = null;
    AppMethodBeat.i(614);
    Object localObject1;
    Object localObject2;
    label37:
    int i;
    if (this.yhc != null)
    {
      localObject1 = this.yhc;
      if (localObject1 != null) {
        break label329;
      }
      localObject1 = null;
      if (paramf != null) {
        break label339;
      }
      localObject2 = null;
      if (s.p(localObject1, localObject2)) {}
    }
    else
    {
      this.yhc = paramf;
      this.ykY.setVisibility(8);
      this.ykW.setVisibility(8);
      this.ykX.setVisibility(8);
      this.ykX.pause();
      if (paramf != null)
      {
        if (((CharSequence)paramf.title).length() != 0) {
          break label348;
        }
        i = 1;
        label107:
        if (i == 0) {
          break label353;
        }
        this.ykX.c(null, -16777216, b.KU(-16777216));
        this.ykY.setStickerPack(paramf);
      }
    }
    if (this.ylb != null)
    {
      paramf = this.ylb;
      if (paramf != null)
      {
        this.ykW.setVisibility(0);
        if (this.yla == null) {
          this.ykW.ay(new CaptureDecoration..ExternalSyntheticLambda0(this, paramf));
        }
      }
    }
    if (this.yhc == null)
    {
      label387:
      label441:
      if (this.ylb != null)
      {
        if (com.tencent.mm.plugin.emoji.g.d.x(this.ylb))
        {
          localObject1 = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider();
          paramf = this.ylb;
          if (paramf == null)
          {
            paramf = localObject3;
            label235:
            paramf = ((e)localObject1).aoi(paramf);
            label244:
            localObject1 = this.ylb;
            s.checkNotNull(localObject1);
            localObject1 = ((EmojiInfo)localObject1).field_attachTextColor;
            if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {
              break label479;
            }
            localObject2 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
          }
        }
        label329:
        label339:
        label348:
        label479:
        for (i = d.a.apj((String)localObject1);; i = -1)
        {
          int j = b.KU(i);
          this.ykX.c((CharSequence)paramf, i, j);
          if (!Util.isNullOrNil(paramf)) {
            this.ykX.setVisibility(0);
          }
          AppMethodBeat.o(614);
          return;
          localObject1 = ((f)localObject1).ygo;
          break;
          localObject2 = paramf.ygo;
          break label37;
          i = 0;
          break label107;
          label353:
          localObject2 = paramf.nSx;
          localObject1 = paramf.acCv;
          if (!n.bp((CharSequence)localObject2))
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.ygM;
            i = d.a.apj((String)localObject2);
            if (n.bp((CharSequence)localObject1)) {
              break label441;
            }
            localObject2 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
          }
          for (j = d.a.apj((String)localObject1);; j = b.KU(i))
          {
            this.ykX.setVisibility(0);
            this.ykX.c((CharSequence)paramf.title, i, j);
            break;
            i = -1;
            break label387;
          }
          paramf = paramf.getMd5();
          break label235;
          paramf = this.ylb;
          if (paramf == null)
          {
            paramf = null;
            break label244;
          }
          paramf = paramf.field_attachedText;
          break label244;
        }
      }
      this.ykX.c(null, -16777216, b.KU(-16777216));
      this.ykW.setVisibility(8);
    }
    AppMethodBeat.o(614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration
 * JD-Core Version:    0.7.0.1
 */