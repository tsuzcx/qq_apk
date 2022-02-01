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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import d.a.e;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG;
  private ImageView gVf;
  private long gmN;
  private EmojiCaptureReporter pZM;
  private b.a qda;
  private com.tencent.mm.plugin.emojicapture.model.a.b qdb;
  private final ViewGroup qdc;
  private EmojiVideoPlayTextureView qdd;
  private EditorItemContainer qde;
  private EditorChangeTextView qdf;
  private View qdg;
  private View qdh;
  private View qdi;
  private View qdj;
  private final ImageView qdk;
  private final ImageView qdl;
  private final ImageView qdm;
  private ImageView qdn;
  private final ChatFooterPanel qdo;
  private final Drawable qdp;
  private final Drawable qdq;
  private final Drawable qdr;
  private final Drawable qds;
  private final Drawable qdt;
  private final Drawable qdu;
  private d.g.a.a<d.z> qdv;
  private final c qdw;
  
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
    this.qdb = new com.tencent.mm.plugin.emojicapture.model.a.b();
    View.inflate(paramContext, 2131493770, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299359);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_…e_video_play_view_layout)");
    this.qdc = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299293);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.qde = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131297952);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.qdf = ((EditorChangeTextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299303);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_type_root)");
    this.qdg = paramAttributeSet;
    paramAttributeSet = findViewById(2131299297);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_remove_background)");
    this.qdh = paramAttributeSet;
    paramAttributeSet = findViewById(2131299300);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_speed_up)");
    this.qdi = paramAttributeSet;
    paramAttributeSet = findViewById(2131299273);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.qdj = paramAttributeSet;
    paramAttributeSet = findViewById(2131299298);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_remove_background_icon)");
    this.qdk = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299301);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_speed_up_icon)");
    this.qdl = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299274);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji_icon)");
    this.qdm = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305955);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.to_capture)");
    this.gVf = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302291);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.mix_video)");
    this.qdn = ((ImageView)paramAttributeSet);
    paramAttributeSet = ao.k(paramContext, 2131690468, c.dP(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconSelColor())");
    this.qdp = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690645, c.dQ(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconNorColor())");
    this.qdq = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690461, c.dP(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconSelColor())");
    this.qdr = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690637, c.dQ(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconNorColor())");
    this.qds = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690346, c.dP(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconSelColor())");
    this.qdt = paramAttributeSet;
    paramAttributeSet = ao.k(paramContext, 2131690511, c.dQ(this));
    d.g.b.p.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconNorColor())");
    this.qdu = paramAttributeSet;
    this.qdk.setImageDrawable(this.qdq);
    this.qdl.setImageDrawable(this.qds);
    this.qdm.setImageDrawable(this.qdu);
    this.gVf.setImageDrawable(ao.k(paramContext, 2131690638, c.dQ(this)));
    this.qdn.setImageDrawable(ao.k(paramContext, 2131690391, c.dP(this)));
    this.qdh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(686);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.qdx).gsp, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.qdx).scene);
        paramAnonymousView = CaptureEditorContainer.d(this.qdx);
        localObject = this.qdx.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).ckv();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.e(this.qdx);
          if (!CaptureEditorContainer.d(this.qdx).isSelected()) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousView = CaptureEditorContainer.f(this.qdx);; paramAnonymousView = CaptureEditorContainer.g(this.qdx))
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
    this.qdi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(687);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.qdx).gsp, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.qdx).scene);
        paramAnonymousView = CaptureEditorContainer.h(this.qdx);
        localObject = this.qdx.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).ckw();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.i(this.qdx);
          if (!CaptureEditorContainer.h(this.qdx).isSelected()) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousView = CaptureEditorContainer.j(this.qdx);; paramAnonymousView = CaptureEditorContainer.k(this.qdx))
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
    this.qdj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.qdx).gsp, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.qdx).scene);
        paramAnonymousView = this.qdx;
        if (!this.qdx.ckA()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.kC(bool);
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.qdx.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.Kc();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        CaptureEditorContainer.c(this.qdx).pWN = (System.currentTimeMillis() - CaptureEditorContainer.c(this.qdx).pWJ);
        CaptureEditorContainer.c(this.qdx).ckt();
        EmojiCaptureReporter.Cx(3);
        paramAnonymousView = this.qdx.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.ckx();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (this.qdx.ckA()) {
          this.qdx.kC(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(691);
      }
    });
    this.qdf.setCallback((EditorChangeTextView.a)new EditorChangeTextView.a()
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
          paramAnonymousCharSequence = this.qdx.getPresenter();
          if (paramAnonymousCharSequence != null) {
            paramAnonymousCharSequence.m((String)localObject, paramAnonymousInt, true);
          }
          CaptureEditorContainer.l(this.qdx).setShow(false);
          AppMethodBeat.o(692);
          return;
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(693);
        b.a locala = this.qdx.getPresenter();
        if (locala != null) {
          locala.m(null, 0, false);
        }
        CaptureEditorContainer.l(this.qdx).setShow(false);
        AppMethodBeat.o(693);
      }
    });
    this.qde.setStateChangeListener((EditorItemContainer.b)new EditorItemContainer.b()
    {
      public final void kJ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(694);
        if (paramAnonymousBoolean)
        {
          CaptureEditorContainer.m(this.qdx).setVisibility(8);
          AppMethodBeat.o(694);
          return;
        }
        CaptureEditorContainer.m(this.qdx).setVisibility(0);
        AppMethodBeat.o(694);
      }
    });
    paramContext = aa.bi(paramContext);
    d.g.b.p.g(paramContext, "SmileyPanelFactory.getSmileyPanel(context)");
    this.qdo = ((ChatFooterPanel)paramContext);
    ae.i(this.TAG, "initSmileyPanel " + this.qdo);
    this.qdo.setEntranceScene(ChatFooterPanel.FkM);
    this.qdo.setShowSmiley(false);
    this.qdo.setShowClose(true);
    this.qdo.setVisibility(8);
    this.qdo.onResume();
    paramContext = aa.Lw();
    d.g.b.p.g(paramContext, "callbackWrapper");
    paramContext.a((z.a)new a(this));
    this.qdo.setCallback((f)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, aa.bj(getContext()));
    paramContext.addRule(12);
    addView((View)this.qdo, (ViewGroup.LayoutParams)paramContext);
    this.qdo.setTranslationY(paramContext.height);
    this.qdw = new c(this);
    AppMethodBeat.o(713);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(702);
    d.g.b.p.h(paramb, "captureInfo");
    d.g.b.p.h(paramString, "videoPath");
    this.qdb = paramb;
    paramb = getContext();
    d.g.b.p.g(paramb, "context");
    this.qdd = new EmojiVideoPlayTextureView(paramb);
    this.qdc.addView((View)this.qdd);
    paramb = this.qdd;
    if (paramb != null) {
      paramb.setRemoveBgEnable(paramBoolean1);
    }
    paramb = this.qdd;
    if (paramb != null) {
      paramb.setRemoveBackground(paramBoolean2);
    }
    paramb = this.qdd;
    if (paramb != null) {
      paramb.setVideoCallback((h.a)this.qdw);
    }
    paramb = this.qdd;
    if (paramb != null) {
      paramb.setVideoPath(paramString);
    }
    paramb = this.qdd;
    if (paramb != null) {
      paramb.setAlpha(0.0F);
    }
    if (!paramBoolean1)
    {
      this.qdh.setEnabled(false);
      this.qdh.setSelected(false);
      this.qdk.setImageDrawable(this.qdq);
      this.qdh.setAlpha(0.3F);
      this.qdv = parama;
      AppMethodBeat.o(702);
      return;
    }
    this.qdh.setEnabled(true);
    this.qdh.setAlpha(1.0F);
    this.qdh.setSelected(paramBoolean2);
    paramString = this.qdk;
    if (this.qdh.isSelected()) {}
    for (paramb = this.qdp;; paramb = this.qdq)
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
      this.qdf.setVisibility(0);
      EditorChangeTextView localEditorChangeTextView = this.qdf;
      localEditorChangeTextView.nlt.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.nlt.setSelection(paramCharSequence.length());
      }
      int i = e.n(c.clD(), paramInt);
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
      localEditorChangeTextView.qdD.setSelected(paramInt);
      localEditorChangeTextView.qdE = c.clD()[paramInt];
      localEditorChangeTextView.qdF = c.clE()[paramInt];
      localEditorChangeTextView.nlt.setTextColor(localEditorChangeTextView.qdE);
      localEditorChangeTextView.qdK = false;
      if (d.lA(28))
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
    this.qdf.cancel();
    AppMethodBeat.o(707);
  }
  
  public final boolean bnS()
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
  
  public final boolean ckA()
  {
    AppMethodBeat.i(708);
    if (this.qdo.getVisibility() == 0)
    {
      AppMethodBeat.o(708);
      return true;
    }
    AppMethodBeat.o(708);
    return false;
  }
  
  public final void cky()
  {
    AppMethodBeat.i(703);
    Object localObject = this.qdd;
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    }
    localObject = this.pZM;
    if (localObject == null) {
      d.g.b.p.bdF("reporter");
    }
    ((EmojiCaptureReporter)localObject).pWJ = System.currentTimeMillis();
    AppMethodBeat.o(703);
  }
  
  public final boolean ckz()
  {
    AppMethodBeat.i(706);
    if (this.qdf.getVisibility() == 0)
    {
      AppMethodBeat.o(706);
      return true;
    }
    AppMethodBeat.o(706);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(712);
    ae.i(this.TAG, "destroy " + this.qdo);
    this.qdo.destroy();
    AppMethodBeat.o(712);
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.qde;
  }
  
  public final b.a getPresenter()
  {
    return this.qda;
  }
  
  public final long getStartTick()
  {
    return this.gmN;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    return this.qdd;
  }
  
  public final void kC(boolean paramBoolean)
  {
    AppMethodBeat.i(709);
    float f = this.qdo.getLayoutParams().height;
    ImageView localImageView;
    if (paramBoolean)
    {
      this.qdj.setSelected(true);
      this.qdo.setVisibility(0);
      this.qdo.animate().translationY(0.0F).start();
      localImageView = this.qdm;
      if (!this.qdj.isSelected()) {
        break label125;
      }
    }
    label125:
    for (Drawable localDrawable = this.qdt;; localDrawable = this.qdu)
    {
      localImageView.setImageDrawable(localDrawable);
      AppMethodBeat.o(709);
      return;
      this.qdj.setSelected(false);
      this.qdo.animate().translationY(f).withEndAction((Runnable)new b(this)).start();
      break;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(710);
    this.qdh.setSelected(false);
    this.qdi.setSelected(false);
    this.qdk.setImageDrawable(this.qdq);
    this.qdl.setImageDrawable(this.qds);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.qdd;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.stop();
    }
    this.qdc.removeView((View)this.qdd);
    this.qdd = null;
    AppMethodBeat.o(710);
  }
  
  public final void setPresenter(b.a parama)
  {
    this.qda = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(704);
    d.g.b.p.h(paramEmojiCaptureReporter, "reporter");
    this.pZM = paramEmojiCaptureReporter;
    this.qdf.setReporter(paramEmojiCaptureReporter);
    AppMethodBeat.o(704);
  }
  
  public final void setStartTick(long paramLong)
  {
    this.gmN = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(711);
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.qdd;
    if (localEmojiVideoPlayTextureView != null)
    {
      localEmojiVideoPlayTextureView.setVisibility(paramInt);
      AppMethodBeat.o(711);
      return;
    }
    AppMethodBeat.o(711);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
  public static final class a
    implements z.a
  {
    public final void a(com.tencent.mm.api.p paramp)
    {
      AppMethodBeat.i(695);
      d.g.b.p.h(paramp, "emojiInfo");
      ae.i(CaptureEditorContainer.a(this.qdx), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramp });
      b.a locala = this.qdx.getPresenter();
      if (locala != null) {
        locala.a(paramp, null);
      }
      onHide();
      AppMethodBeat.o(695);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(696);
      this.qdx.kC(false);
      AppMethodBeat.o(696);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(697);
      CaptureEditorContainer.b(this.qdx).setVisibility(8);
      AppMethodBeat.o(697);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
  public static final class c
    implements h.a
  {
    public final int eU(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void eb(int paramInt1, int paramInt2) {}
    
    public final void onCompletion()
    {
      AppMethodBeat.i(701);
      ae.i(CaptureEditorContainer.a(this.qdx), "onCompletion cost " + bu.aO(this.qdx.getStartTick()) + "ms");
      this.qdx.setStartTick(bu.HQ());
      Object localObject = CaptureEditorContainer.n(this.qdx);
      if (localObject != null)
      {
        ((EmojiVideoPlayTextureView)localObject).qbp = true;
        localObject = ((EmojiVideoPlayTextureView)localObject).qbo;
        if (localObject != null)
        {
          ((j)localObject).KB(0);
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
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.qdx);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setOnDrawCallback((d.g.a.a)new a(this));
      }
      this.qdx.setStartTick(bu.HQ());
      localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.qdx);
      if (localEmojiVideoPlayTextureView != null)
      {
        localEmojiVideoPlayTextureView.start();
        AppMethodBeat.o(700);
        return;
      }
      AppMethodBeat.o(700);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer
 * JD-Core Version:    0.7.0.1
 */