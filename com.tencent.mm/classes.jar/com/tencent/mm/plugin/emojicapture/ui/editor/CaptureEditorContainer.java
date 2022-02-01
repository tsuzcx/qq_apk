package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.z.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import d.a.e;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG;
  private ImageView gSx;
  private long gkt;
  private EmojiCaptureReporter pTh;
  private EditorChangeTextView pWA;
  private View pWB;
  private View pWC;
  private View pWD;
  private View pWE;
  private final ImageView pWF;
  private final ImageView pWG;
  private final ImageView pWH;
  private ImageView pWI;
  private final ChatFooterPanel pWJ;
  private final Drawable pWK;
  private final Drawable pWL;
  private final Drawable pWM;
  private final Drawable pWN;
  private final Drawable pWO;
  private final Drawable pWP;
  private d.g.a.a<d.z> pWQ;
  private final c pWR;
  private b.a pWv;
  private com.tencent.mm.plugin.emojicapture.model.a.b pWw;
  private final ViewGroup pWx;
  private EmojiVideoPlayTextureView pWy;
  private EditorItemContainer pWz;
  
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
    this.pWw = new com.tencent.mm.plugin.emojicapture.model.a.b();
    View.inflate(paramContext, 2131493770, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299359);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_…e_video_play_view_layout)");
    this.pWx = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299293);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.pWz = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131297952);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.pWA = ((EditorChangeTextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299303);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_type_root)");
    this.pWB = paramAttributeSet;
    paramAttributeSet = findViewById(2131299297);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_remove_background)");
    this.pWC = paramAttributeSet;
    paramAttributeSet = findViewById(2131299300);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_speed_up)");
    this.pWD = paramAttributeSet;
    paramAttributeSet = findViewById(2131299273);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.pWE = paramAttributeSet;
    paramAttributeSet = findViewById(2131299298);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_remove_background_icon)");
    this.pWF = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299301);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_speed_up_icon)");
    this.pWG = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299274);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji_icon)");
    this.pWH = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305955);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.to_capture)");
    this.gSx = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302291);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.mix_video)");
    this.pWI = ((ImageView)paramAttributeSet);
    paramAttributeSet = ao.k(paramContext, 2131690468, c.dP(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconSelColor())");
    this.pWK = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690645, c.dQ(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconNorColor())");
    this.pWL = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690461, c.dP(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconSelColor())");
    this.pWM = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690637, c.dQ(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconNorColor())");
    this.pWN = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690346, c.dP(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconSelColor())");
    this.pWO = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690511, c.dQ(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconNorColor())");
    this.pWP = paramAttributeSet;
    this.pWF.setImageDrawable(this.pWL);
    this.pWG.setImageDrawable(this.pWN);
    this.pWH.setImageDrawable(this.pWP);
    this.gSx.setImageDrawable(ao.k(paramContext, 2131690638, c.dQ(this)));
    this.pWI.setImageDrawable(ao.k(paramContext, 2131690391, c.dP(this)));
    this.pWC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(686);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.pWS).gpU, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.pWS).scene);
        paramAnonymousView = CaptureEditorContainer.d(this.pWS);
        localObject = this.pWS.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).cjf();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.e(this.pWS);
          if (!CaptureEditorContainer.d(this.pWS).isSelected()) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousView = CaptureEditorContainer.f(this.pWS);; paramAnonymousView = CaptureEditorContainer.g(this.pWS))
        {
          ((ImageView)localObject).setImageDrawable(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(686);
          return;
          bool = false;
          break;
        }
      }
    });
    this.pWD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(687);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.pWS).gpU, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.pWS).scene);
        paramAnonymousView = CaptureEditorContainer.h(this.pWS);
        localObject = this.pWS.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).cjg();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.i(this.pWS);
          if (!CaptureEditorContainer.h(this.pWS).isSelected()) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousView = CaptureEditorContainer.j(this.pWS);; paramAnonymousView = CaptureEditorContainer.k(this.pWS))
        {
          ((ImageView)localObject).setImageDrawable(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(687);
          return;
          bool = false;
          break;
        }
      }
    });
    this.pWE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.pWS).gpU, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.pWS).scene);
        paramAnonymousView = this.pWS;
        if (!this.pWS.cjk()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.kD(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.pWS.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.JU();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(689);
      }
    });
    findViewById(2131299338).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(690);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        CaptureEditorContainer.c(this.pWS).pQi = (System.currentTimeMillis() - CaptureEditorContainer.c(this.pWS).pQe);
        CaptureEditorContainer.c(this.pWS).cjd();
        EmojiCaptureReporter.Cl(3);
        paramAnonymousView = this.pWS.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.cjh();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(690);
      }
    });
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(691);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.pWS.cjk()) {
          this.pWS.kD(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(691);
      }
    });
    this.pWA.setCallback((EditorChangeTextView.a)new EditorChangeTextView.a()
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
              d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
          }
          paramAnonymousCharSequence = this.pWS.getPresenter();
          if (paramAnonymousCharSequence != null) {
            paramAnonymousCharSequence.m((String)localObject, paramAnonymousInt, true);
          }
          CaptureEditorContainer.l(this.pWS).setShow(false);
          AppMethodBeat.o(692);
          return;
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(693);
        b.a locala = this.pWS.getPresenter();
        if (locala != null) {
          locala.m(null, 0, false);
        }
        CaptureEditorContainer.l(this.pWS).setShow(false);
        AppMethodBeat.o(693);
      }
    });
    this.pWz.setStateChangeListener((EditorItemContainer.b)new EditorItemContainer.b()
    {
      public final void kI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(694);
        if (paramAnonymousBoolean)
        {
          CaptureEditorContainer.m(this.pWS).setVisibility(8);
          AppMethodBeat.o(694);
          return;
        }
        CaptureEditorContainer.m(this.pWS).setVisibility(0);
        AppMethodBeat.o(694);
      }
    });
    paramContext = aa.bh(paramContext);
    d.g.b.p.g(paramContext, "SmileyPanelFactory.getSmileyPanel(context)");
    this.pWJ = ((ChatFooterPanel)paramContext);
    ad.i(this.TAG, "initSmileyPanel " + this.pWJ);
    this.pWJ.setEntranceScene(ChatFooterPanel.ESr);
    this.pWJ.setShowSmiley(false);
    this.pWJ.setShowClose(true);
    this.pWJ.setVisibility(8);
    this.pWJ.onResume();
    paramContext = aa.Lo();
    d.g.b.p.g(paramContext, "callbackWrapper");
    paramContext.a((z.a)new a(this));
    this.pWJ.setCallback((f)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, aa.bi(getContext()));
    paramContext.addRule(12);
    addView((View)this.pWJ, (ViewGroup.LayoutParams)paramContext);
    this.pWJ.setTranslationY(paramContext.height);
    this.pWR = new c(this);
    AppMethodBeat.o(713);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(702);
    d.g.b.p.h(paramb, "captureInfo");
    d.g.b.p.h(paramString, "videoPath");
    this.pWw = paramb;
    paramb = getContext();
    d.g.b.p.g(paramb, "context");
    this.pWy = new EmojiVideoPlayTextureView(paramb);
    this.pWx.addView((View)this.pWy);
    paramb = this.pWy;
    if (paramb != null) {
      paramb.setRemoveBgEnable(paramBoolean1);
    }
    paramb = this.pWy;
    if (paramb != null) {
      paramb.setRemoveBackground(paramBoolean2);
    }
    paramb = this.pWy;
    if (paramb != null) {
      paramb.setVideoCallback((h.a)this.pWR);
    }
    paramb = this.pWy;
    if (paramb != null) {
      paramb.setVideoPath(paramString);
    }
    paramb = this.pWy;
    if (paramb != null) {
      paramb.setAlpha(0.0F);
    }
    if (!paramBoolean1)
    {
      this.pWC.setEnabled(false);
      this.pWC.setSelected(false);
      this.pWF.setImageDrawable(this.pWL);
      this.pWC.setAlpha(0.3F);
      this.pWQ = parama;
      AppMethodBeat.o(702);
      return;
    }
    this.pWC.setEnabled(true);
    this.pWC.setAlpha(1.0F);
    this.pWC.setSelected(paramBoolean2);
    paramString = this.pWF;
    if (this.pWC.isSelected()) {}
    for (paramb = this.pWK;; paramb = this.pWL)
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
      this.pWA.setVisibility(0);
      EditorChangeTextView localEditorChangeTextView = this.pWA;
      localEditorChangeTextView.ngl.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.ngl.setSelection(paramCharSequence.length());
      }
      int i = e.n(c.ckn(), paramInt);
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
      localEditorChangeTextView.pWY.setSelected(paramInt);
      localEditorChangeTextView.pWZ = c.ckn()[paramInt];
      localEditorChangeTextView.pXa = c.cko()[paramInt];
      localEditorChangeTextView.ngl.setTextColor(localEditorChangeTextView.pWZ);
      localEditorChangeTextView.pXf = false;
      if (d.ly(28))
      {
        paramCharSequence = localEditorChangeTextView.getRootWindowInsets();
        if (paramCharSequence == null) {
          break label180;
        }
      }
      label180:
      for (paramCharSequence = paramCharSequence.getDisplayCutout();; paramCharSequence = null)
      {
        if (paramCharSequence != null)
        {
          paramInt = paramCharSequence.getSafeInsetTop();
          if ((paramInt > 0) && (localEditorChangeTextView.getPaddingTop() != paramInt)) {
            localEditorChangeTextView.setPadding(0, paramInt, 0, 0);
          }
        }
        AppMethodBeat.o(707);
        return;
      }
    }
    this.pWA.cancel();
    AppMethodBeat.o(707);
  }
  
  public final boolean bni()
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
  
  public final void cji()
  {
    AppMethodBeat.i(703);
    Object localObject = this.pWy;
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    }
    localObject = this.pTh;
    if (localObject == null) {
      d.g.b.p.bcb("reporter");
    }
    ((EmojiCaptureReporter)localObject).pQe = System.currentTimeMillis();
    AppMethodBeat.o(703);
  }
  
  public final boolean cjj()
  {
    AppMethodBeat.i(706);
    if (this.pWA.getVisibility() == 0)
    {
      AppMethodBeat.o(706);
      return true;
    }
    AppMethodBeat.o(706);
    return false;
  }
  
  public final boolean cjk()
  {
    AppMethodBeat.i(708);
    if (this.pWJ.getVisibility() == 0)
    {
      AppMethodBeat.o(708);
      return true;
    }
    AppMethodBeat.o(708);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(712);
    ad.i(this.TAG, "destroy " + this.pWJ);
    this.pWJ.destroy();
    AppMethodBeat.o(712);
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.pWz;
  }
  
  public final b.a getPresenter()
  {
    return this.pWv;
  }
  
  public final long getStartTick()
  {
    return this.gkt;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    return this.pWy;
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(709);
    float f = this.pWJ.getLayoutParams().height;
    ImageView localImageView;
    if (paramBoolean)
    {
      this.pWE.setSelected(true);
      this.pWJ.setVisibility(0);
      this.pWJ.animate().translationY(0.0F).start();
      localImageView = this.pWH;
      if (!this.pWE.isSelected()) {
        break label125;
      }
    }
    label125:
    for (Drawable localDrawable = this.pWO;; localDrawable = this.pWP)
    {
      localImageView.setImageDrawable(localDrawable);
      AppMethodBeat.o(709);
      return;
      this.pWE.setSelected(false);
      this.pWJ.animate().translationY(f).withEndAction((Runnable)new b(this)).start();
      break;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(710);
    this.pWC.setSelected(false);
    this.pWD.setSelected(false);
    this.pWF.setImageDrawable(this.pWL);
    this.pWG.setImageDrawable(this.pWN);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pWy;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.stop();
    }
    this.pWx.removeView((View)this.pWy);
    this.pWy = null;
    AppMethodBeat.o(710);
  }
  
  public final void setPresenter(b.a parama)
  {
    this.pWv = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(704);
    d.g.b.p.h(paramEmojiCaptureReporter, "reporter");
    this.pTh = paramEmojiCaptureReporter;
    this.pWA.setReporter(paramEmojiCaptureReporter);
    AppMethodBeat.o(704);
  }
  
  public final void setStartTick(long paramLong)
  {
    this.gkt = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(711);
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pWy;
    if (localEmojiVideoPlayTextureView != null)
    {
      localEmojiVideoPlayTextureView.setVisibility(paramInt);
      AppMethodBeat.o(711);
      return;
    }
    AppMethodBeat.o(711);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
  public static final class a
    implements z.a
  {
    public final void a(com.tencent.mm.api.p paramp)
    {
      AppMethodBeat.i(695);
      d.g.b.p.h(paramp, "emojiInfo");
      ad.i(CaptureEditorContainer.a(this.pWS), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramp });
      b.a locala = this.pWS.getPresenter();
      if (locala != null) {
        locala.a(paramp, null);
      }
      onHide();
      AppMethodBeat.o(695);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(696);
      this.pWS.kD(false);
      AppMethodBeat.o(696);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(697);
      CaptureEditorContainer.b(this.pWS).setVisibility(8);
      AppMethodBeat.o(697);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
  public static final class c
    implements h.a
  {
    public final int eT(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void eb(int paramInt1, int paramInt2) {}
    
    public final void onCompletion()
    {
      AppMethodBeat.i(701);
      ad.i(CaptureEditorContainer.a(this.pWS), "onCompletion cost " + bt.aO(this.pWS.getStartTick()) + "ms");
      this.pWS.setStartTick(bt.HI());
      Object localObject = CaptureEditorContainer.n(this.pWS);
      if (localObject != null)
      {
        ((EmojiVideoPlayTextureView)localObject).pUK = true;
        localObject = ((EmojiVideoPlayTextureView)localObject).pUJ;
        if (localObject != null)
        {
          ((j)localObject).Kb(0);
          AppMethodBeat.o(701);
          return;
        }
        AppMethodBeat.o(701);
        return;
      }
      AppMethodBeat.o(701);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void ta()
    {
      AppMethodBeat.i(700);
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.pWS);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setOnDrawCallback((d.g.a.a)new a(this));
      }
      this.pWS.setStartTick(bt.HI());
      localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.pWS);
      if (localEmojiVideoPlayTextureView != null)
      {
        localEmojiVideoPlayTextureView.start();
        AppMethodBeat.o(700);
        return;
      }
      AppMethodBeat.o(700);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<d.z>
    {
      a(CaptureEditorContainer.c paramc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer
 * JD-Core Version:    0.7.0.1
 */