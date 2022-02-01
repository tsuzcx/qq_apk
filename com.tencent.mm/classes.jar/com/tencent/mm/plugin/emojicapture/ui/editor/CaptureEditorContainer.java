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
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.r;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.h;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG;
  private long jID;
  private final ChatFooterPanel jPN;
  private ImageView kCv;
  private EmojiCaptureReporter uWp;
  private b.a uZD;
  private com.tencent.mm.plugin.emojicapture.model.a.b uZE;
  private final ViewGroup uZF;
  private EmojiVideoPlayTextureView uZG;
  private EditorItemContainer uZH;
  private EditorChangeTextView uZI;
  private View uZJ;
  private View uZK;
  private View uZL;
  private View uZM;
  private final ImageView uZN;
  private final ImageView uZO;
  private final ImageView uZP;
  private ImageView uZQ;
  private final Drawable uZR;
  private final Drawable uZS;
  private final Drawable uZT;
  private final Drawable uZU;
  private final Drawable uZV;
  private final Drawable uZW;
  private kotlin.g.a.a<x> uZX;
  private final c uZY;
  
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
    this.uZE = new com.tencent.mm.plugin.emojicapture.model.a.b();
    View.inflate(paramContext, a.g.uSI, (ViewGroup)this);
    paramAttributeSet = findViewById(a.f.uSc);
    p.j(paramAttributeSet, "findViewById(R.id.emoji_…e_video_play_view_layout)");
    this.uZF = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.editor_item_container);
    p.j(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.uZH = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.change_text_root);
    p.j(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.uZI = ((EditorChangeTextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uRH);
    p.j(paramAttributeSet, "findViewById(R.id.editor_type_root)");
    this.uZJ = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.uRD);
    p.j(paramAttributeSet, "findViewById(R.id.editor_remove_background)");
    this.uZK = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.uRF);
    p.j(paramAttributeSet, "findViewById(R.id.editor_speed_up)");
    this.uZL = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.editor_add_emoji);
    p.j(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.uZM = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.uRE);
    p.j(paramAttributeSet, "findViewById(R.id.editor_remove_background_icon)");
    this.uZN = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uRG);
    p.j(paramAttributeSet, "findViewById(R.id.editor_speed_up_icon)");
    this.uZO = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uRB);
    p.j(paramAttributeSet, "findViewById(R.id.editor_add_emoji_icon)");
    this.uZP = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uSw);
    p.j(paramAttributeSet, "findViewById(R.id.to_capture)");
    this.kCv = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uSf);
    p.j(paramAttributeSet, "findViewById(R.id.mix_video)");
    this.uZQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = au.o(paramContext, a.h.icons_filled_remove_bg, c.ef(this));
    p.j(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconSelColor())");
    this.uZR = paramAttributeSet;
    paramAttributeSet = au.o(paramContext, a.h.icons_outlined_remove_bg, c.eg(this));
    p.j(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconNorColor())");
    this.uZS = paramAttributeSet;
    paramAttributeSet = au.o(paramContext, a.h.icons_filled_play_quickly, c.ef(this));
    p.j(paramAttributeSet, "getColorDrawable(context…ickly, getIconSelColor())");
    this.uZT = paramAttributeSet;
    paramAttributeSet = au.o(paramContext, a.h.icons_outlined_play_quickly, c.eg(this));
    p.j(paramAttributeSet, "getColorDrawable(context…ickly, getIconNorColor())");
    this.uZU = paramAttributeSet;
    paramAttributeSet = au.o(paramContext, a.h.icons_filled_add_emoji, c.ef(this));
    p.j(paramAttributeSet, "getColorDrawable(context…emoji, getIconSelColor())");
    this.uZV = paramAttributeSet;
    paramAttributeSet = au.o(paramContext, a.h.icons_outlined_add_emoji, c.eg(this));
    p.j(paramAttributeSet, "getColorDrawable(context…emoji, getIconNorColor())");
    this.uZW = paramAttributeSet;
    this.uZN.setImageDrawable(this.uZS);
    this.uZO.setImageDrawable(this.uZU);
    this.uZP.setImageDrawable(this.uZW);
    this.kCv.setImageDrawable(au.o(paramContext, a.h.icons_outlined_previous, c.eg(this)));
    this.uZQ.setImageDrawable(au.o(paramContext, a.h.icons_filled_done, c.ef(this)));
    this.uZK.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(686);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.uZZ).jPf, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.uZZ).scene);
        paramAnonymousView = CaptureEditorContainer.d(this.uZZ);
        localObject = this.uZZ.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).cXg();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.e(this.uZZ);
          if (!CaptureEditorContainer.d(this.uZZ).isSelected()) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousView = CaptureEditorContainer.f(this.uZZ);; paramAnonymousView = CaptureEditorContainer.g(this.uZZ))
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
    this.uZL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(687);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.uZZ).jPf, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.uZZ).scene);
        paramAnonymousView = CaptureEditorContainer.h(this.uZZ);
        localObject = this.uZZ.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).cXh();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.i(this.uZZ);
          if (!CaptureEditorContainer.h(this.uZZ).isSelected()) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousView = CaptureEditorContainer.j(this.uZZ);; paramAnonymousView = CaptureEditorContainer.k(this.uZZ))
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
    this.uZM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.uZZ).jPf, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.uZZ).scene);
        paramAnonymousView = this.uZZ;
        if (!this.uZZ.cXl()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.mP(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(688);
          return;
        }
      }
    });
    findViewById(a.f.uRO).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(689);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.uZZ.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.YD();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(689);
      }
    });
    findViewById(a.f.uRN).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(690);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CaptureEditorContainer.c(this.uZZ).uTt = (System.currentTimeMillis() - CaptureEditorContainer.c(this.uZZ).uTp);
        CaptureEditorContainer.c(this.uZZ).cXe();
        EmojiCaptureReporter.JP(3);
        paramAnonymousView = this.uZZ.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.cXi();
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
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.uZZ.cXl()) {
          this.uZZ.mP(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(691);
      }
    });
    this.uZI.setCallback((EditorChangeTextView.a)new EditorChangeTextView.a()
    {
      public final void k(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
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
              p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
          }
          paramAnonymousCharSequence = this.uZZ.getPresenter();
          if (paramAnonymousCharSequence != null) {
            paramAnonymousCharSequence.r((String)localObject, paramAnonymousInt, true);
          }
          CaptureEditorContainer.l(this.uZZ).setShow(false);
          AppMethodBeat.o(692);
          return;
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(693);
        b.a locala = this.uZZ.getPresenter();
        if (locala != null) {
          locala.r(null, 0, false);
        }
        CaptureEditorContainer.l(this.uZZ).setShow(false);
        AppMethodBeat.o(693);
      }
    });
    this.uZH.setStateChangeListener((EditorItemContainer.b)new EditorItemContainer.b()
    {
      public final void mW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(694);
        if (paramAnonymousBoolean)
        {
          CaptureEditorContainer.m(this.uZZ).setVisibility(8);
          AppMethodBeat.o(694);
          return;
        }
        CaptureEditorContainer.m(this.uZZ).setVisibility(0);
        AppMethodBeat.o(694);
      }
    });
    paramContext = ad.bB(paramContext);
    p.j(paramContext, "SmileyPanelFactory.getSmileyPanel(context)");
    this.jPN = ((ChatFooterPanel)paramContext);
    Log.i(this.TAG, "initSmileyPanel " + this.jPN);
    this.jPN.setEntranceScene(ChatFooterPanel.Rcj);
    this.jPN.setShowSmiley(false);
    this.jPN.setShowClose(true);
    this.jPN.setVisibility(8);
    this.jPN.onResume();
    paramContext = ad.aaf();
    p.j(paramContext, "callbackWrapper");
    paramContext.a((ac.a)new a(this));
    this.jPN.setCallback((f)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, ad.bC(getContext()));
    paramContext.addRule(12);
    addView((View)this.jPN, (ViewGroup.LayoutParams)paramContext);
    this.jPN.setTranslationY(paramContext.height);
    this.uZY = new c(this);
    AppMethodBeat.o(713);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(702);
    p.k(paramb, "captureInfo");
    p.k(paramString, "videoPath");
    this.uZE = paramb;
    paramb = getContext();
    p.j(paramb, "context");
    this.uZG = new EmojiVideoPlayTextureView(paramb);
    this.uZF.addView((View)this.uZG);
    paramb = this.uZG;
    if (paramb != null) {
      paramb.setRemoveBgEnable(paramBoolean1);
    }
    paramb = this.uZG;
    if (paramb != null) {
      paramb.setRemoveBackground(paramBoolean2);
    }
    paramb = this.uZG;
    if (paramb != null) {
      paramb.setVideoCallback((k.a)this.uZY);
    }
    paramb = this.uZG;
    if (paramb != null) {
      paramb.setVideoPath(paramString);
    }
    paramb = this.uZG;
    if (paramb != null) {
      paramb.setAlpha(0.0F);
    }
    if (!paramBoolean1)
    {
      this.uZK.setEnabled(false);
      this.uZK.setSelected(false);
      this.uZN.setImageDrawable(this.uZS);
      this.uZK.setAlpha(0.3F);
      this.uZX = parama;
      AppMethodBeat.o(702);
      return;
    }
    this.uZK.setEnabled(true);
    this.uZK.setAlpha(1.0F);
    this.uZK.setSelected(paramBoolean2);
    paramString = this.uZN;
    if (this.uZK.isSelected()) {}
    for (paramb = this.uZR;; paramb = this.uZS)
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
      this.uZI.setVisibility(0);
      EditorChangeTextView localEditorChangeTextView = this.uZI;
      localEditorChangeTextView.rxC.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.rxC.setSelection(paramCharSequence.length());
      }
      int i = e.n(c.cYn(), paramInt);
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
      localEditorChangeTextView.vaf.setSelected(paramInt);
      localEditorChangeTextView.vag = c.cYn()[paramInt];
      localEditorChangeTextView.vah = c.cYo()[paramInt];
      localEditorChangeTextView.rxC.setTextColor(localEditorChangeTextView.vag);
      localEditorChangeTextView.van = false;
      if (d.qV(28))
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
    this.uZI.cancel();
    AppMethodBeat.o(707);
  }
  
  public final boolean bVd()
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
  
  public final void cXj()
  {
    AppMethodBeat.i(703);
    Object localObject = this.uZG;
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    }
    localObject = this.uWp;
    if (localObject == null) {
      p.bGy("reporter");
    }
    ((EmojiCaptureReporter)localObject).uTp = System.currentTimeMillis();
    AppMethodBeat.o(703);
  }
  
  public final boolean cXk()
  {
    AppMethodBeat.i(706);
    if (this.uZI.getVisibility() == 0)
    {
      AppMethodBeat.o(706);
      return true;
    }
    AppMethodBeat.o(706);
    return false;
  }
  
  public final boolean cXl()
  {
    AppMethodBeat.i(708);
    if (this.jPN.getVisibility() == 0)
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
    Log.i(this.TAG, "destroy " + this.jPN);
    this.jPN.destroy();
    AppMethodBeat.o(712);
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.uZH;
  }
  
  public final b.a getPresenter()
  {
    return this.uZD;
  }
  
  public final long getStartTick()
  {
    return this.jID;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    return this.uZG;
  }
  
  public final void mP(boolean paramBoolean)
  {
    AppMethodBeat.i(709);
    float f = this.jPN.getLayoutParams().height;
    ImageView localImageView;
    if (paramBoolean)
    {
      this.uZM.setSelected(true);
      this.jPN.setVisibility(0);
      this.jPN.animate().translationY(0.0F).start();
      localImageView = this.uZP;
      if (!this.uZM.isSelected()) {
        break label125;
      }
    }
    label125:
    for (Drawable localDrawable = this.uZV;; localDrawable = this.uZW)
    {
      localImageView.setImageDrawable(localDrawable);
      AppMethodBeat.o(709);
      return;
      this.uZM.setSelected(false);
      this.jPN.animate().translationY(f).withEndAction((Runnable)new b(this)).start();
      break;
    }
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(202012);
    if (paramWindowInsets != null) {
      findViewById(a.f.uSd).setPadding(0, paramWindowInsets.getSystemWindowInsetTop(), 0, 0);
    }
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    p.j(paramWindowInsets, "super.onApplyWindowInsets(insets)");
    AppMethodBeat.o(202012);
    return paramWindowInsets;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(710);
    this.uZK.setSelected(false);
    this.uZL.setSelected(false);
    this.uZN.setImageDrawable(this.uZS);
    this.uZO.setImageDrawable(this.uZU);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.uZG;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.stop();
    }
    this.uZF.removeView((View)this.uZG);
    this.uZG = null;
    AppMethodBeat.o(710);
  }
  
  public final void setPresenter(b.a parama)
  {
    this.uZD = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(704);
    p.k(paramEmojiCaptureReporter, "reporter");
    this.uWp = paramEmojiCaptureReporter;
    this.uZI.setReporter(paramEmojiCaptureReporter);
    AppMethodBeat.o(704);
  }
  
  public final void setStartTick(long paramLong)
  {
    this.jID = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(711);
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.uZG;
    if (localEmojiVideoPlayTextureView != null)
    {
      localEmojiVideoPlayTextureView.setVisibility(paramInt);
      AppMethodBeat.o(711);
      return;
    }
    AppMethodBeat.o(711);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
  public static final class a
    implements ac.a
  {
    public final void a(r paramr)
    {
      AppMethodBeat.i(695);
      p.k(paramr, "emojiInfo");
      Log.i(CaptureEditorContainer.a(this.uZZ), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramr });
      b.a locala = this.uZZ.getPresenter();
      if (locala != null) {
        locala.a(paramr, null);
      }
      onHide();
      AppMethodBeat.o(695);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(696);
      this.uZZ.mP(false);
      AppMethodBeat.o(696);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(697);
      CaptureEditorContainer.b(this.uZZ).setVisibility(8);
      AppMethodBeat.o(697);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
  public static final class c
    implements k.a
  {
    public final void eM(int paramInt1, int paramInt2) {}
    
    public final int fE(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(701);
      Log.i(CaptureEditorContainer.a(this.uZZ), "onCompletion cost " + Util.ticksToNow(this.uZZ.getStartTick()) + "ms");
      this.uZZ.setStartTick(Util.currentTicks());
      Object localObject = CaptureEditorContainer.n(this.uZZ);
      if (localObject != null)
      {
        ((EmojiVideoPlayTextureView)localObject).uXS = true;
        localObject = ((EmojiVideoPlayTextureView)localObject).uXR;
        if (localObject != null)
        {
          ((j)localObject).WQ(0);
          AppMethodBeat.o(701);
          return;
        }
        AppMethodBeat.o(701);
        return;
      }
      AppMethodBeat.o(701);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void qX()
    {
      AppMethodBeat.i(700);
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.uZZ);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setOnDrawCallback((kotlin.g.a.a)new a(this));
      }
      this.uZZ.setStartTick(Util.currentTicks());
      localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.uZZ);
      if (localEmojiVideoPlayTextureView != null)
      {
        localEmojiVideoPlayTextureView.start();
        AppMethodBeat.o(700);
        return;
      }
      AppMethodBeat.o(700);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
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