package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z;
import com.tencent.mm.api.z.a;
import com.tencent.mm.media.editor.view.TextColorSelector;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import d.a.e;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG;
  private long fNi;
  private final ChatFooterPanel fSY;
  private EmojiCaptureReporter oMm;
  private b.a oPE;
  private b oPF;
  private final ViewGroup oPG;
  private EmojiVideoPlayTextureView oPH;
  private EditorItemContainer oPI;
  private EditorChangeTextView oPJ;
  private View oPK;
  private View oPL;
  private View oPM;
  private View oPN;
  private final ImageView oPO;
  private final ImageView oPP;
  private final ImageView oPQ;
  private ImageView oPR;
  private ImageView oPS;
  private final Drawable oPT;
  private final Drawable oPU;
  private final Drawable oPV;
  private final Drawable oPW;
  private final Drawable oPX;
  private final Drawable oPY;
  private a<y> oPZ;
  private final c oQa;
  
  public CaptureEditorContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(714);
    AppMethodBeat.o(714);
  }
  
  public CaptureEditorContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(713);
    this.TAG = "MicroMsg.CaptureEditorContainer";
    this.oPF = new b();
    View.inflate(paramContext, 2131493770, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299359);
    k.g(paramAttributeSet, "findViewById(R.id.emoji_…e_video_play_view_layout)");
    this.oPG = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299293);
    k.g(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.oPI = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131297952);
    k.g(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.oPJ = ((EditorChangeTextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299303);
    k.g(paramAttributeSet, "findViewById(R.id.editor_type_root)");
    this.oPK = paramAttributeSet;
    paramAttributeSet = findViewById(2131299297);
    k.g(paramAttributeSet, "findViewById(R.id.editor_remove_background)");
    this.oPL = paramAttributeSet;
    paramAttributeSet = findViewById(2131299300);
    k.g(paramAttributeSet, "findViewById(R.id.editor_speed_up)");
    this.oPM = paramAttributeSet;
    paramAttributeSet = findViewById(2131299273);
    k.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.oPN = paramAttributeSet;
    paramAttributeSet = findViewById(2131299298);
    k.g(paramAttributeSet, "findViewById(R.id.editor_remove_background_icon)");
    this.oPO = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299301);
    k.g(paramAttributeSet, "findViewById(R.id.editor_speed_up_icon)");
    this.oPP = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299274);
    k.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji_icon)");
    this.oPQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305955);
    k.g(paramAttributeSet, "findViewById(R.id.to_capture)");
    this.oPR = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302291);
    k.g(paramAttributeSet, "findViewById(R.id.mix_video)");
    this.oPS = ((ImageView)paramAttributeSet);
    paramAttributeSet = am.i(paramContext, 2131690468, c.dK(this));
    k.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconSelColor())");
    this.oPT = paramAttributeSet;
    paramAttributeSet = am.i(paramContext, 2131690645, c.dL(this));
    k.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconNorColor())");
    this.oPU = paramAttributeSet;
    paramAttributeSet = am.i(paramContext, 2131690461, c.dK(this));
    k.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconSelColor())");
    this.oPV = paramAttributeSet;
    paramAttributeSet = am.i(paramContext, 2131690637, c.dL(this));
    k.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconNorColor())");
    this.oPW = paramAttributeSet;
    paramAttributeSet = am.i(paramContext, 2131690346, c.dK(this));
    k.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconSelColor())");
    this.oPX = paramAttributeSet;
    paramAttributeSet = am.i(paramContext, 2131690511, c.dL(this));
    k.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconNorColor())");
    this.oPY = paramAttributeSet;
    this.oPO.setImageDrawable(this.oPU);
    this.oPP.setImageDrawable(this.oPW);
    this.oPQ.setImageDrawable(this.oPY);
    this.oPR.setImageDrawable(am.i(paramContext, 2131690638, c.dL(this)));
    this.oPS.setImageDrawable(am.i(paramContext, 2131690391, c.dK(this)));
    this.oPL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(686);
        EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.oQb).fSw, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.oQb).scene);
        paramAnonymousView = CaptureEditorContainer.d(this.oQb);
        Object localObject = this.oQb.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).bXp();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.e(this.oQb);
          if (!CaptureEditorContainer.d(this.oQb).isSelected()) {
            break label115;
          }
        }
        label115:
        for (paramAnonymousView = CaptureEditorContainer.f(this.oQb);; paramAnonymousView = CaptureEditorContainer.g(this.oQb))
        {
          ((ImageView)localObject).setImageDrawable(paramAnonymousView);
          AppMethodBeat.o(686);
          return;
          bool = false;
          break;
        }
      }
    });
    this.oPM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(687);
        EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.oQb).fSw, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.oQb).scene);
        paramAnonymousView = CaptureEditorContainer.h(this.oQb);
        Object localObject = this.oQb.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).bXq();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.i(this.oQb);
          if (!CaptureEditorContainer.h(this.oQb).isSelected()) {
            break label115;
          }
        }
        label115:
        for (paramAnonymousView = CaptureEditorContainer.j(this.oQb);; paramAnonymousView = CaptureEditorContainer.k(this.oQb))
        {
          ((ImageView)localObject).setImageDrawable(paramAnonymousView);
          AppMethodBeat.o(687);
          return;
          bool = false;
          break;
        }
      }
    });
    this.oPN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(688);
        EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.oQb).fSw, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.oQb).scene);
        paramAnonymousView = this.oQb;
        if (!this.oQb.bXu()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.jP(bool);
          AppMethodBeat.o(688);
          return;
        }
      }
    });
    findViewById(2131299339).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(689);
        paramAnonymousView = this.oQb.getPresenter();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.IL();
          AppMethodBeat.o(689);
          return;
        }
        AppMethodBeat.o(689);
      }
    });
    findViewById(2131299338).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(690);
        CaptureEditorContainer.c(this.oQb).oJi = (System.currentTimeMillis() - CaptureEditorContainer.c(this.oQb).oJe);
        CaptureEditorContainer.c(this.oQb).bXn();
        EmojiCaptureReporter.AL(3);
        paramAnonymousView = this.oQb.getPresenter();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.bXr();
          AppMethodBeat.o(690);
          return;
        }
        AppMethodBeat.o(690);
      }
    });
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(691);
        if (this.oQb.bXu()) {
          this.oQb.jP(false);
        }
        AppMethodBeat.o(691);
      }
    });
    this.oPJ.setCallback((EditorChangeTextView.a)new EditorChangeTextView.a()
    {
      public final void j(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
      {
        AppMethodBeat.i(692);
        if (paramAnonymousCharSequence != null) {}
        for (paramAnonymousCharSequence = paramAnonymousCharSequence.toString();; paramAnonymousCharSequence = null)
        {
          Object localObject = paramAnonymousCharSequence;
          if (paramAnonymousCharSequence != null)
          {
            localObject = paramAnonymousCharSequence;
            if (paramAnonymousCharSequence.length() > 50)
            {
              localObject = paramAnonymousCharSequence.substring(0, 50);
              k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
          }
          paramAnonymousCharSequence = this.oQb.getPresenter();
          if (paramAnonymousCharSequence != null) {
            paramAnonymousCharSequence.m((String)localObject, paramAnonymousInt, true);
          }
          CaptureEditorContainer.l(this.oQb).setShow(false);
          AppMethodBeat.o(692);
          return;
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(693);
        b.a locala = this.oQb.getPresenter();
        if (locala != null) {
          locala.m(null, 0, false);
        }
        CaptureEditorContainer.l(this.oQb).setShow(false);
        AppMethodBeat.o(693);
      }
    });
    this.oPI.setStateChangeListener((EditorItemContainer.b)new EditorItemContainer.b()
    {
      public final void jT(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(694);
        if (paramAnonymousBoolean)
        {
          CaptureEditorContainer.m(this.oQb).setVisibility(8);
          AppMethodBeat.o(694);
          return;
        }
        CaptureEditorContainer.m(this.oQb).setVisibility(0);
        AppMethodBeat.o(694);
      }
    });
    paramContext = aa.bg(paramContext);
    k.g(paramContext, "SmileyPanelFactory.getSmileyPanel(context)");
    this.fSY = ((ChatFooterPanel)paramContext);
    ad.i(this.TAG, "initSmileyPanel " + this.fSY);
    this.fSY.setEntranceScene(ChatFooterPanel.BUW);
    this.fSY.setShowSmiley(false);
    this.fSY.setShowClose(true);
    this.fSY.setVisibility(8);
    this.fSY.onResume();
    paramContext = aa.Kf();
    k.g(paramContext, "callbackWrapper");
    paramContext.a((z.a)new a(this));
    this.fSY.setCallback((f)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, aa.bh(getContext()));
    paramContext.addRule(12);
    addView((View)this.fSY, (ViewGroup.LayoutParams)paramContext);
    this.fSY.setTranslationY(paramContext.height);
    this.oQa = new c(this);
    AppMethodBeat.o(713);
  }
  
  public final void a(b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, a<y> parama)
  {
    AppMethodBeat.i(702);
    k.h(paramb, "captureInfo");
    k.h(paramString, "videoPath");
    this.oPF = paramb;
    paramb = getContext();
    k.g(paramb, "context");
    this.oPH = new EmojiVideoPlayTextureView(paramb);
    this.oPG.addView((View)this.oPH);
    paramb = this.oPH;
    if (paramb != null) {
      paramb.setRemoveBgEnable(paramBoolean1);
    }
    paramb = this.oPH;
    if (paramb != null) {
      paramb.setRemoveBackground(paramBoolean2);
    }
    paramb = this.oPH;
    if (paramb != null) {
      paramb.setVideoCallback((h.a)this.oQa);
    }
    paramb = this.oPH;
    if (paramb != null) {
      paramb.setVideoPath(paramString);
    }
    paramb = this.oPH;
    if (paramb != null) {
      paramb.setAlpha(0.0F);
    }
    if (!paramBoolean1)
    {
      this.oPL.setEnabled(false);
      this.oPL.setSelected(false);
      this.oPO.setImageDrawable(this.oPU);
      this.oPL.setAlpha(0.3F);
      this.oPZ = parama;
      AppMethodBeat.o(702);
      return;
    }
    this.oPL.setEnabled(true);
    this.oPL.setAlpha(1.0F);
    this.oPL.setSelected(paramBoolean2);
    paramString = this.oPO;
    if (this.oPL.isSelected()) {}
    for (paramb = this.oPT;; paramb = this.oPU)
    {
      paramString.setImageDrawable(paramb);
      break;
    }
  }
  
  public final void a(boolean paramBoolean, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(707);
    if (paramBoolean)
    {
      this.oPJ.setVisibility(0);
      EditorChangeTextView localEditorChangeTextView = this.oPJ;
      localEditorChangeTextView.mdO.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.mdO.setSelection(paramCharSequence.length());
      }
      int i = e.k(c.bYw(), paramInt);
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
      localEditorChangeTextView.oQh.setSelected(paramInt);
      localEditorChangeTextView.oQi = c.bYw()[paramInt];
      localEditorChangeTextView.oQj = c.bYx()[paramInt];
      localEditorChangeTextView.mdO.setTextColor(localEditorChangeTextView.oQi);
      localEditorChangeTextView.oQo = false;
      AppMethodBeat.o(707);
      return;
    }
    this.oPJ.cancel();
    AppMethodBeat.o(707);
  }
  
  public final void bXs()
  {
    AppMethodBeat.i(703);
    Object localObject = this.oPH;
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    }
    localObject = this.oMm;
    if (localObject == null) {
      k.aPZ("reporter");
    }
    ((EmojiCaptureReporter)localObject).oJe = System.currentTimeMillis();
    AppMethodBeat.o(703);
  }
  
  public final boolean bXt()
  {
    AppMethodBeat.i(706);
    if (this.oPJ.getVisibility() == 0)
    {
      AppMethodBeat.o(706);
      return true;
    }
    AppMethodBeat.o(706);
    return false;
  }
  
  public final boolean bXu()
  {
    AppMethodBeat.i(708);
    if (this.fSY.getVisibility() == 0)
    {
      AppMethodBeat.o(708);
      return true;
    }
    AppMethodBeat.o(708);
    return false;
  }
  
  public final boolean bcB()
  {
    AppMethodBeat.i(705);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(705);
      return true;
    }
    AppMethodBeat.o(705);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(712);
    ad.i(this.TAG, "destroy " + this.fSY);
    this.fSY.destroy();
    AppMethodBeat.o(712);
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.oPI;
  }
  
  public final b.a getPresenter()
  {
    return this.oPE;
  }
  
  public final long getStartTick()
  {
    return this.fNi;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    return this.oPH;
  }
  
  public final void jP(boolean paramBoolean)
  {
    AppMethodBeat.i(709);
    float f = this.fSY.getLayoutParams().height;
    ImageView localImageView;
    if (paramBoolean)
    {
      this.oPN.setSelected(true);
      this.fSY.setVisibility(0);
      this.fSY.animate().translationY(0.0F).start();
      localImageView = this.oPQ;
      if (!this.oPN.isSelected()) {
        break label125;
      }
    }
    label125:
    for (Drawable localDrawable = this.oPX;; localDrawable = this.oPY)
    {
      localImageView.setImageDrawable(localDrawable);
      AppMethodBeat.o(709);
      return;
      this.oPN.setSelected(false);
      this.fSY.animate().translationY(f).withEndAction((Runnable)new b(this)).start();
      break;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(710);
    this.oPL.setSelected(false);
    this.oPM.setSelected(false);
    this.oPO.setImageDrawable(this.oPU);
    this.oPP.setImageDrawable(this.oPW);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.oPH;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.stop();
    }
    this.oPG.removeView((View)this.oPH);
    this.oPH = null;
    AppMethodBeat.o(710);
  }
  
  public final void setPresenter(b.a parama)
  {
    this.oPE = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(704);
    k.h(paramEmojiCaptureReporter, "reporter");
    this.oMm = paramEmojiCaptureReporter;
    this.oPJ.setReporter(paramEmojiCaptureReporter);
    AppMethodBeat.o(704);
  }
  
  public final void setStartTick(long paramLong)
  {
    this.fNi = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(711);
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.oPH;
    if (localEmojiVideoPlayTextureView != null)
    {
      localEmojiVideoPlayTextureView.setVisibility(paramInt);
      AppMethodBeat.o(711);
      return;
    }
    AppMethodBeat.o(711);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
  public static final class a
    implements z.a
  {
    public final void a(p paramp)
    {
      AppMethodBeat.i(695);
      k.h(paramp, "emojiInfo");
      ad.i(CaptureEditorContainer.a(this.oQb), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramp });
      b.a locala = this.oQb.getPresenter();
      if (locala != null) {
        locala.a(paramp, null);
      }
      onHide();
      AppMethodBeat.o(695);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(696);
      this.oQb.jP(false);
      AppMethodBeat.o(696);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(697);
      CaptureEditorContainer.b(this.oQb).setVisibility(8);
      AppMethodBeat.o(697);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
  public static final class c
    implements h.a
  {
    public final void dY(int paramInt1, int paramInt2) {}
    
    public final int eM(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(701);
      ad.i(CaptureEditorContainer.a(this.oQb), "onCompletion cost " + bt.aS(this.oQb.getStartTick()) + "ms");
      this.oQb.setStartTick(bt.GC());
      Object localObject = CaptureEditorContainer.n(this.oQb);
      if (localObject != null)
      {
        ((EmojiVideoPlayTextureView)localObject).oNK = true;
        localObject = ((EmojiVideoPlayTextureView)localObject).oNJ;
        if (localObject != null)
        {
          ((j)localObject).GI(0);
          AppMethodBeat.o(701);
          return;
        }
        AppMethodBeat.o(701);
        return;
      }
      AppMethodBeat.o(701);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void rq()
    {
      AppMethodBeat.i(700);
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.oQb);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setOnDrawCallback((a)new a(this));
      }
      this.oQb.setStartTick(bt.GC());
      localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.oQb);
      if (localEmojiVideoPlayTextureView != null)
      {
        localEmojiVideoPlayTextureView.start();
        AppMethodBeat.o(700);
        return;
      }
      AppMethodBeat.o(700);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<y>
    {
      a(CaptureEditorContainer.c paramc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer
 * JD-Core Version:    0.7.0.1
 */