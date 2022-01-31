package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.f.b.j;
import a.l;
import a.l.m;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.plugin.emojicapture.ui.a;
import com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "clipRadius", "", "clipRect", "Landroid/graphics/RectF;", "emojiHint", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "firstSelect", "", "hideStickerHintRunnable", "Ljava/lang/Runnable;", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showStickerHintRunnable", "stickerHint", "Landroid/view/View;", "stickerHintIcon", "Landroid/widget/ImageView;", "stickerHintText", "Landroid/widget/TextView;", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getText", "", "getTextColor", "hideStickerHint", "onRecordStart", "onRecordStop", "pause", "resume", "setImitateEmoji", "emojiInfo", "setStickerInfo", "showImitateEmoji", "showStickerHint", "showTextHint", "text", "colorString", "plugin-emojicapture_release"})
public final class CaptureDecoration
  extends FrameLayout
{
  com.tencent.mm.plugin.emojicapture.model.a.b ltF;
  private final Path lwd;
  private EmojiInfo lyA;
  private boolean lyB;
  private final Runnable lyC;
  final Runnable lyD;
  private final RectF lyt;
  private final float lyu;
  public final BaseEmojiView lyv;
  public final TextEditorItemView lyw;
  final View lyx;
  final ImageView lyy;
  final TextView lyz;
  
  public CaptureDecoration(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(3000);
    AppMethodBeat.o(3000);
  }
  
  public CaptureDecoration(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(2999);
    this.lwd = new Path();
    this.lyt = new RectF();
    this.lyu = paramContext.getResources().getDimension(2131427333);
    this.lyB = true;
    this.lyC = ((Runnable)new CaptureDecoration.c(this));
    this.lyD = ((Runnable)new CaptureDecoration.b(this));
    View.inflate(paramContext, 2130969360, (ViewGroup)this);
    paramAttributeSet = findViewById(2131823551);
    j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_emoji_hint)");
    this.lyv = ((BaseEmojiView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823555);
    j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_text_hint)");
    this.lyw = ((TextEditorItemView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823552);
    j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_hint)");
    this.lyx = paramAttributeSet;
    paramAttributeSet = findViewById(2131823553);
    j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_hint_icon)");
    this.lyy = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823554);
    j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_hint_text)");
    this.lyz = ((TextView)paramAttributeSet);
    float f = paramContext.getResources().getDimension(2131427334);
    paramContext = new RectF(0.0F, 0.0F, f, f);
    this.lyw.a(paramContext, this.lyu);
    AppMethodBeat.o(2999);
  }
  
  private void bpc()
  {
    AppMethodBeat.i(2994);
    EmojiInfo localEmojiInfo = this.lyA;
    if (localEmojiInfo != null)
    {
      this.lyv.setVisibility(0);
      this.lyv.setEmojiInfo(localEmojiInfo);
      if (com.tencent.mm.plugin.emoji.h.b.x(localEmojiInfo))
      {
        localObject = g.G(d.class);
        j.p(localObject, "plugin(IPluginEmoji::class.java)");
      }
      for (Object localObject = ((d)localObject).getProvider().Kx(localEmojiInfo.Al());; localObject = localEmojiInfo.field_attachedText)
      {
        dR((String)localObject, localEmojiInfo.field_attachTextColor);
        AppMethodBeat.o(2994);
        return;
      }
    }
    AppMethodBeat.o(2994);
  }
  
  private void dR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2995);
    if (!bo.isNullOrNil(paramString1))
    {
      Object localObject = (CharSequence)paramString2;
      if ((localObject != null) && (!m.ap((CharSequence)localObject))) {
        break label79;
      }
      i = 1;
      if (i != 0) {
        break label84;
      }
      localObject = c.ltu;
    }
    label79:
    label84:
    for (int i = a.uM(c.a.Ln(paramString2));; i = -1)
    {
      this.lyw.a((CharSequence)paramString1, i, true);
      this.lyw.setVisibility(0);
      AppMethodBeat.o(2995);
      return;
      i = 0;
      break;
    }
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(2991);
    j.q(paramCanvas, "canvas");
    this.lyt.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    this.lwd.addRoundRect(this.lyt, this.lyu, this.lyu, Path.Direction.CW);
    paramCanvas.clipPath(this.lwd);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(2991);
  }
  
  public final String getText()
  {
    AppMethodBeat.i(2996);
    Object localObject = this.lyw.getText();
    if (localObject != null)
    {
      localObject = localObject.toString();
      AppMethodBeat.o(2996);
      return localObject;
    }
    AppMethodBeat.o(2996);
    return null;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(2997);
    int i = this.lyw.getTextColor();
    if (i != 0) {}
    for (i = a.uM(i);; i = -1)
    {
      AppMethodBeat.o(2997);
      return i;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(2998);
    this.lyv.resume();
    this.lyw.bpf();
    AppMethodBeat.o(2998);
  }
  
  public final void setImitateEmoji(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(2992);
    this.lyA = paramEmojiInfo;
    bpc();
    AppMethodBeat.o(2992);
  }
  
  public final void setStickerInfo(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(2993);
    String str;
    if ((j.e(this.ltF, paramb) ^ true))
    {
      this.ltF = paramb;
      this.lyx.setVisibility(8);
      this.lyv.setVisibility(8);
      this.lyw.setVisibility(8);
      this.lyw.a(null, -1, true);
      removeCallbacks(this.lyD);
      removeCallbacks(this.lyC);
      if (paramb != null)
      {
        str = paramb.title;
        if (this.lyA == null) {
          break label295;
        }
        Object localObject3 = paramb.lsW;
        localObject1 = this.lyA;
        if (localObject1 != null)
        {
          localObject1 = ((EmojiInfo)localObject1).field_lensId;
          if ((!j.e(localObject3, localObject1)) || (!this.lyB)) {
            break label295;
          }
          this.lyB = false;
          localObject3 = this.lyA;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((EmojiInfo)localObject3).field_attachedText;
          }
          if (bo.isNullOrNil((String)localObject1)) {
            break label295;
          }
          localObject1 = this.lyA;
          if (localObject1 != null)
          {
            str = ((EmojiInfo)localObject1).field_attachedText;
            localObject1 = str;
            if (str != null) {
              break label194;
            }
          }
        }
      }
    }
    label295:
    for (Object localObject1 = "";; localObject1 = str)
    {
      label194:
      dR((String)localObject1, paramb.fhT);
      int i;
      if ((!m.ap((CharSequence)paramb.kqb)) || (!paramb.ltK.isEmpty())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          postDelayed(this.lyC, 500L);
          AppMethodBeat.o(2993);
          return;
          localObject1 = null;
          break;
          i = 0;
          continue;
          if (this.lyA != null)
          {
            bpc();
            AppMethodBeat.o(2993);
            return;
          }
          this.lyv.setVisibility(8);
        }
      }
      AppMethodBeat.o(2993);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration
 * JD-Core Version:    0.7.0.1
 */