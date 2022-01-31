package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.a.e;
import a.f.b.j;
import a.l;
import a.y;
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
import com.tencent.mm.api.t;
import com.tencent.mm.api.t.a;
import com.tencent.mm.api.u;
import com.tencent.mm.media.editor.view.TextColorSelector;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG;
  private long ewN;
  private final ChatFooterPanel eys;
  private EmojiCaptureReporter lsY;
  private b.a lyP;
  private com.tencent.mm.plugin.emojicapture.model.a.a lyQ;
  private final ViewGroup lyR;
  private EmojiVideoPlayTextureView lyS;
  private EditorItemContainer lyT;
  private EditorChangeTextView lyU;
  private View lyV;
  private View lyW;
  private View lyX;
  private View lyY;
  private final ImageView lyZ;
  private final ImageView lza;
  private final ImageView lzb;
  private ImageView lzc;
  private ImageView lzd;
  private final Drawable lze;
  private final Drawable lzf;
  private final Drawable lzg;
  private final Drawable lzh;
  private final Drawable lzi;
  private final Drawable lzj;
  private a.f.a.a<y> lzk;
  private final c lzl;
  
  public CaptureEditorContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(3052);
    AppMethodBeat.o(3052);
  }
  
  public CaptureEditorContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(3051);
    this.TAG = "MicroMsg.CaptureEditorContainer";
    this.lyQ = new com.tencent.mm.plugin.emojicapture.model.a.a();
    View.inflate(paramContext, 2130969369, (ViewGroup)this);
    paramAttributeSet = findViewById(2131823570);
    j.p(paramAttributeSet, "findViewById(R.id.emoji_…e_video_play_view_layout)");
    this.lyR = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131823571);
    j.p(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.lyT = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131823514);
    j.p(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.lyU = ((EditorChangeTextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823572);
    j.p(paramAttributeSet, "findViewById(R.id.editor_type_root)");
    this.lyV = paramAttributeSet;
    paramAttributeSet = findViewById(2131823573);
    j.p(paramAttributeSet, "findViewById(R.id.editor_remove_background)");
    this.lyW = paramAttributeSet;
    paramAttributeSet = findViewById(2131823576);
    j.p(paramAttributeSet, "findViewById(R.id.editor_speed_up)");
    this.lyX = paramAttributeSet;
    paramAttributeSet = findViewById(2131823579);
    j.p(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.lyY = paramAttributeSet;
    paramAttributeSet = findViewById(2131823574);
    j.p(paramAttributeSet, "findViewById(R.id.editor_remove_background_icon)");
    this.lyZ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823577);
    j.p(paramAttributeSet, "findViewById(R.id.editor_speed_up_icon)");
    this.lza = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823580);
    j.p(paramAttributeSet, "findViewById(R.id.editor_add_emoji_icon)");
    this.lzb = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823583);
    j.p(paramAttributeSet, "findViewById(R.id.to_capture)");
    this.lzc = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823585);
    j.p(paramAttributeSet, "findViewById(R.id.mix_video)");
    this.lzd = ((ImageView)paramAttributeSet);
    paramAttributeSet = aj.g(paramContext, 2131231472, com.tencent.mm.plugin.emojicapture.ui.a.dk(this));
    j.p(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconSelColor())");
    this.lze = paramAttributeSet;
    paramAttributeSet = aj.g(paramContext, 2131231532, com.tencent.mm.plugin.emojicapture.ui.a.dl(this));
    j.p(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconNorColor())");
    this.lzf = paramAttributeSet;
    paramAttributeSet = aj.g(paramContext, 2131231469, com.tencent.mm.plugin.emojicapture.ui.a.dk(this));
    j.p(paramAttributeSet, "getColorDrawable(context…ickly, getIconSelColor())");
    this.lzg = paramAttributeSet;
    paramAttributeSet = aj.g(paramContext, 2131231528, com.tencent.mm.plugin.emojicapture.ui.a.dl(this));
    j.p(paramAttributeSet, "getColorDrawable(context…ickly, getIconNorColor())");
    this.lzh = paramAttributeSet;
    paramAttributeSet = aj.g(paramContext, 2131231435, com.tencent.mm.plugin.emojicapture.ui.a.dk(this));
    j.p(paramAttributeSet, "getColorDrawable(context…emoji, getIconSelColor())");
    this.lzi = paramAttributeSet;
    paramAttributeSet = aj.g(paramContext, 2131231481, com.tencent.mm.plugin.emojicapture.ui.a.dl(this));
    j.p(paramAttributeSet, "getColorDrawable(context…emoji, getIconNorColor())");
    this.lzj = paramAttributeSet;
    this.lyZ.setImageDrawable(this.lzf);
    this.lza.setImageDrawable(this.lzh);
    this.lzb.setImageDrawable(this.lzj);
    this.lzc.setImageDrawable(aj.g(paramContext, 2131231529, com.tencent.mm.plugin.emojicapture.ui.a.dl(this)));
    this.lzd.setImageDrawable(aj.g(paramContext, 2131231454, com.tencent.mm.plugin.emojicapture.ui.a.dk(this)));
    this.lyW.setOnClickListener((View.OnClickListener)new CaptureEditorContainer.1(this));
    this.lyX.setOnClickListener((View.OnClickListener)new CaptureEditorContainer.2(this));
    this.lyY.setOnClickListener((View.OnClickListener)new CaptureEditorContainer.3(this));
    findViewById(2131823582).setOnClickListener((View.OnClickListener)new CaptureEditorContainer.4(this));
    findViewById(2131823584).setOnClickListener((View.OnClickListener)new CaptureEditorContainer.5(this));
    setOnClickListener((View.OnClickListener)new CaptureEditorContainer.6(this));
    this.lyU.setCallback((EditorChangeTextView.a)new CaptureEditorContainer.7(this));
    this.lyT.setStateChangeListener((EditorItemContainer.b)new CaptureEditorContainer.8(this));
    paramContext = u.aW(paramContext);
    j.p(paramContext, "SmileyPanelFactory.getmSmileyPanel(context)");
    this.eys = ((ChatFooterPanel)paramContext);
    ab.i(this.TAG, "initSmileyPanel " + this.eys);
    this.eys.setEntranceScene(ChatFooterPanel.vQp);
    this.eys.setBackgroundResource(2130838603);
    this.eys.AA();
    this.eys.bo(true);
    this.eys.j(true, true);
    this.eys.setVisibility(8);
    this.eys.onResume();
    paramContext = u.AF();
    j.p(paramContext, "callbackWrapper");
    paramContext.a((t.a)new CaptureEditorContainer.a(this));
    this.eys.setCallback((f)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 230));
    paramContext.addRule(12);
    addView((View)this.eys, (ViewGroup.LayoutParams)paramContext);
    this.eys.setTranslationY(paramContext.height);
    this.lzl = new c(this);
    AppMethodBeat.o(3051);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(3043);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(3043);
      return true;
    }
    AppMethodBeat.o(3043);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2, a.f.a.a<y> parama1)
  {
    AppMethodBeat.i(3040);
    j.q(parama, "captureInfo");
    j.q(paramString, "videoPath");
    this.lyQ = parama;
    parama = getContext();
    j.p(parama, "context");
    this.lyS = new EmojiVideoPlayTextureView(parama);
    this.lyR.addView((View)this.lyS);
    parama = this.lyS;
    if (parama != null) {
      parama.setRemoveBgEnable(paramBoolean1);
    }
    parama = this.lyS;
    if (parama != null) {
      parama.setVideoCallback((e.a)this.lzl);
    }
    parama = this.lyS;
    if (parama != null) {
      parama.setVideoPath(paramString);
    }
    parama = this.lyS;
    if (parama != null) {
      parama.setAlpha(0.0F);
    }
    if (!paramBoolean1)
    {
      this.lyW.setEnabled(false);
      this.lyW.setSelected(false);
      this.lyZ.setImageDrawable(this.lzf);
      this.lyW.setAlpha(0.3F);
      this.lzk = parama1;
      AppMethodBeat.o(3040);
      return;
    }
    this.lyW.setEnabled(true);
    this.lyW.setAlpha(1.0F);
    this.lyW.setSelected(paramBoolean2);
    paramString = this.lyZ;
    if (this.lyW.isSelected()) {}
    for (parama = this.lze;; parama = this.lzf)
    {
      paramString.setImageDrawable(parama);
      break;
    }
  }
  
  public final void a(boolean paramBoolean, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(3045);
    if (paramBoolean)
    {
      this.lyU.setVisibility(0);
      EditorChangeTextView localEditorChangeTextView = this.lyU;
      localEditorChangeTextView.jnZ.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.jnZ.setSelection(paramCharSequence.length());
      }
      int i = e.k(com.tencent.mm.plugin.emojicapture.ui.a.boT(), paramInt);
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
      localEditorChangeTextView.lzr.setSelected(paramInt);
      localEditorChangeTextView.lzs = com.tencent.mm.plugin.emojicapture.ui.a.boT()[paramInt];
      localEditorChangeTextView.lzt = com.tencent.mm.plugin.emojicapture.ui.a.boU()[paramInt];
      localEditorChangeTextView.jnZ.setTextColor(localEditorChangeTextView.lzs);
      localEditorChangeTextView.lzy = false;
      AppMethodBeat.o(3045);
      return;
    }
    this.lyU.cancel();
    AppMethodBeat.o(3045);
  }
  
  public final void bnD()
  {
    AppMethodBeat.i(3041);
    Object localObject = this.lyS;
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    }
    localObject = this.lsY;
    if (localObject == null) {
      j.ays("reporter");
    }
    ((EmojiCaptureReporter)localObject).lsL = System.currentTimeMillis();
    AppMethodBeat.o(3041);
  }
  
  public final boolean bnE()
  {
    AppMethodBeat.i(3044);
    if (this.lyU.getVisibility() == 0)
    {
      AppMethodBeat.o(3044);
      return true;
    }
    AppMethodBeat.o(3044);
    return false;
  }
  
  public final boolean bnF()
  {
    AppMethodBeat.i(3046);
    if (this.eys.getVisibility() == 0)
    {
      AppMethodBeat.o(3046);
      return true;
    }
    AppMethodBeat.o(3046);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(3050);
    ab.i(this.TAG, "destroy " + this.eys);
    this.eys.destroy();
    AppMethodBeat.o(3050);
  }
  
  public final void gT(boolean paramBoolean)
  {
    AppMethodBeat.i(3047);
    float f = this.eys.getLayoutParams().height;
    ImageView localImageView;
    if (paramBoolean)
    {
      this.lyY.setSelected(true);
      this.eys.setVisibility(0);
      this.eys.animate().translationY(0.0F).start();
      localImageView = this.lzb;
      if (!this.lyY.isSelected()) {
        break label125;
      }
    }
    label125:
    for (Drawable localDrawable = this.lzi;; localDrawable = this.lzj)
    {
      localImageView.setImageDrawable(localDrawable);
      AppMethodBeat.o(3047);
      return;
      this.lyY.setSelected(false);
      this.eys.animate().translationY(f).withEndAction((Runnable)new CaptureEditorContainer.b(this)).start();
      break;
    }
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.lyT;
  }
  
  public final b.a getPresenter()
  {
    return this.lyP;
  }
  
  public final long getStartTick()
  {
    return this.ewN;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    return this.lyS;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(3048);
    this.lyW.setSelected(false);
    this.lyX.setSelected(false);
    this.lyZ.setImageDrawable(this.lzf);
    this.lza.setImageDrawable(this.lzh);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.lyS;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.stop();
    }
    this.lyR.removeView((View)this.lyS);
    this.lyS = null;
    AppMethodBeat.o(3048);
  }
  
  public final void setPresenter(b.a parama)
  {
    this.lyP = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(3042);
    j.q(paramEmojiCaptureReporter, "reporter");
    this.lsY = paramEmojiCaptureReporter;
    this.lyU.setReporter(paramEmojiCaptureReporter);
    AppMethodBeat.o(3042);
  }
  
  public final void setStartTick(long paramLong)
  {
    this.ewN = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(3049);
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.lyS;
    if (localEmojiVideoPlayTextureView != null)
    {
      localEmojiVideoPlayTextureView.setVisibility(paramInt);
      AppMethodBeat.o(3049);
      return;
    }
    AppMethodBeat.o(3049);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
  public static final class c
    implements e.a
  {
    public final void Es()
    {
      AppMethodBeat.i(3039);
      ab.i(CaptureEditorContainer.a(this.lzm), "onCompletion cost " + bo.av(this.lzm.getStartTick()) + "ms");
      this.lzm.setStartTick(bo.yB());
      Object localObject = CaptureEditorContainer.n(this.lzm);
      if (localObject != null)
      {
        ((EmojiVideoPlayTextureView)localObject).lxx = true;
        localObject = ((EmojiVideoPlayTextureView)localObject).lxw;
        if (localObject != null)
        {
          ((i)localObject).zi(0);
          AppMethodBeat.o(3039);
          return;
        }
        AppMethodBeat.o(3039);
        return;
      }
      AppMethodBeat.o(3039);
    }
    
    public final int dP(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void dQ(int paramInt1, int paramInt2) {}
    
    public final void mG()
    {
      AppMethodBeat.i(3038);
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.lzm);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setOneTimeVideoTextureUpdateCallback((a.f.a.a)new CaptureEditorContainer.c.a(this));
      }
      this.lzm.setStartTick(bo.yB());
      localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.lzm);
      if (localEmojiVideoPlayTextureView != null)
      {
        localEmojiVideoPlayTextureView.start();
        AppMethodBeat.o(3038);
        return;
      }
      AppMethodBeat.o(3038);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer
 * JD-Core Version:    0.7.0.1
 */