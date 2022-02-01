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
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG;
  private long gXF;
  private ImageView hNZ;
  private EmojiCaptureReporter rqJ;
  private b.a rtY;
  private com.tencent.mm.plugin.emojicapture.model.a.b rtZ;
  private final ViewGroup rua;
  private EmojiVideoPlayTextureView rub;
  private EditorItemContainer ruc;
  private EditorChangeTextView rud;
  private View rue;
  private View ruf;
  private View rug;
  private View ruh;
  private final ImageView rui;
  private final ImageView ruj;
  private final ImageView ruk;
  private ImageView rul;
  private final ChatFooterPanel rum;
  private final Drawable run;
  private final Drawable ruo;
  private final Drawable rup;
  private final Drawable ruq;
  private final Drawable rur;
  private final Drawable rus;
  private kotlin.g.a.a<x> rut;
  private final c ruu;
  
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
    this.rtZ = new com.tencent.mm.plugin.emojicapture.model.a.b();
    View.inflate(paramContext, 2131493919, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299971);
    p.g(paramAttributeSet, "findViewById(R.id.emoji_…e_video_play_view_layout)");
    this.rua = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299887);
    p.g(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.ruc = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131298286);
    p.g(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.rud = ((EditorChangeTextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299907);
    p.g(paramAttributeSet, "findViewById(R.id.editor_type_root)");
    this.rue = paramAttributeSet;
    paramAttributeSet = findViewById(2131299896);
    p.g(paramAttributeSet, "findViewById(R.id.editor_remove_background)");
    this.ruf = paramAttributeSet;
    paramAttributeSet = findViewById(2131299899);
    p.g(paramAttributeSet, "findViewById(R.id.editor_speed_up)");
    this.rug = paramAttributeSet;
    paramAttributeSet = findViewById(2131299859);
    p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.ruh = paramAttributeSet;
    paramAttributeSet = findViewById(2131299897);
    p.g(paramAttributeSet, "findViewById(R.id.editor_remove_background_icon)");
    this.rui = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299900);
    p.g(paramAttributeSet, "findViewById(R.id.editor_speed_up_icon)");
    this.ruj = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299860);
    p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji_icon)");
    this.ruk = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131309258);
    p.g(paramAttributeSet, "findViewById(R.id.to_capture)");
    this.hNZ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131304685);
    p.g(paramAttributeSet, "findViewById(R.id.mix_video)");
    this.rul = ((ImageView)paramAttributeSet);
    paramAttributeSet = ar.m(paramContext, 2131690659, c.dH(this));
    p.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconSelColor())");
    this.run = paramAttributeSet;
    paramAttributeSet = ar.m(paramContext, 2131690896, c.dI(this));
    p.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconNorColor())");
    this.ruo = paramAttributeSet;
    paramAttributeSet = ar.m(paramContext, 2131690649, c.dH(this));
    p.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconSelColor())");
    this.rup = paramAttributeSet;
    paramAttributeSet = ar.m(paramContext, 2131690886, c.dI(this));
    p.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconNorColor())");
    this.ruq = paramAttributeSet;
    paramAttributeSet = ar.m(paramContext, 2131690476, c.dH(this));
    p.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconSelColor())");
    this.rur = paramAttributeSet;
    paramAttributeSet = ar.m(paramContext, 2131690729, c.dI(this));
    p.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconNorColor())");
    this.rus = paramAttributeSet;
    this.rui.setImageDrawable(this.ruo);
    this.ruj.setImageDrawable(this.ruq);
    this.ruk.setImageDrawable(this.rus);
    this.hNZ.setImageDrawable(ar.m(paramContext, 2131690888, c.dI(this)));
    this.rul.setImageDrawable(ar.m(paramContext, 2131690537, c.dH(this)));
    this.ruf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(686);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.ruv).hdz, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.ruv).scene);
        paramAnonymousView = CaptureEditorContainer.d(this.ruv);
        localObject = this.ruv.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).cIx();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.e(this.ruv);
          if (!CaptureEditorContainer.d(this.ruv).isSelected()) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousView = CaptureEditorContainer.f(this.ruv);; paramAnonymousView = CaptureEditorContainer.g(this.ruv))
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
    this.rug.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(687);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.ruv).hdz, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.ruv).scene);
        paramAnonymousView = CaptureEditorContainer.h(this.ruv);
        localObject = this.ruv.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).cIy();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.i(this.ruv);
          if (!CaptureEditorContainer.h(this.ruv).isSelected()) {
            break label156;
          }
        }
        label156:
        for (paramAnonymousView = CaptureEditorContainer.j(this.ruv);; paramAnonymousView = CaptureEditorContainer.k(this.ruv))
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
    this.ruh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.ruv).hdz, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.ruv).scene);
        paramAnonymousView = this.ruv;
        if (!this.ruv.cIC()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.lE(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(688);
          return;
        }
      }
    });
    findViewById(2131299951).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(689);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.ruv.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.Ul();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(689);
      }
    });
    findViewById(2131299950).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(690);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CaptureEditorContainer.c(this.ruv).rnM = (System.currentTimeMillis() - CaptureEditorContainer.c(this.ruv).rnI);
        CaptureEditorContainer.c(this.ruv).cIv();
        EmojiCaptureReporter.Gi(3);
        paramAnonymousView = this.ruv.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.cIz();
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
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.ruv.cIC()) {
          this.ruv.lE(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(691);
      }
    });
    this.rud.setCallback((EditorChangeTextView.a)new EditorChangeTextView.a()
    {
      public final void i(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
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
              p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
          }
          paramAnonymousCharSequence = this.ruv.getPresenter();
          if (paramAnonymousCharSequence != null) {
            paramAnonymousCharSequence.n((String)localObject, paramAnonymousInt, true);
          }
          CaptureEditorContainer.l(this.ruv).setShow(false);
          AppMethodBeat.o(692);
          return;
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(693);
        b.a locala = this.ruv.getPresenter();
        if (locala != null) {
          locala.n(null, 0, false);
        }
        CaptureEditorContainer.l(this.ruv).setShow(false);
        AppMethodBeat.o(693);
      }
    });
    this.ruc.setStateChangeListener((EditorItemContainer.b)new EditorItemContainer.b()
    {
      public final void lL(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(694);
        if (paramAnonymousBoolean)
        {
          CaptureEditorContainer.m(this.ruv).setVisibility(8);
          AppMethodBeat.o(694);
          return;
        }
        CaptureEditorContainer.m(this.ruv).setVisibility(0);
        AppMethodBeat.o(694);
      }
    });
    paramContext = ad.bC(paramContext);
    p.g(paramContext, "SmileyPanelFactory.getSmileyPanel(context)");
    this.rum = ((ChatFooterPanel)paramContext);
    Log.i(this.TAG, "initSmileyPanel " + this.rum);
    this.rum.setEntranceScene(ChatFooterPanel.KbE);
    this.rum.setShowSmiley(false);
    this.rum.setShowClose(true);
    this.rum.setVisibility(8);
    this.rum.onResume();
    paramContext = ad.VK();
    p.g(paramContext, "callbackWrapper");
    paramContext.a((ac.a)new a(this));
    this.rum.setCallback((f)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, ad.bD(getContext()));
    paramContext.addRule(12);
    addView((View)this.rum, (ViewGroup.LayoutParams)paramContext);
    this.rum.setTranslationY(paramContext.height);
    this.ruu = new c(this);
    AppMethodBeat.o(713);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(702);
    p.h(paramb, "captureInfo");
    p.h(paramString, "videoPath");
    this.rtZ = paramb;
    paramb = getContext();
    p.g(paramb, "context");
    this.rub = new EmojiVideoPlayTextureView(paramb);
    this.rua.addView((View)this.rub);
    paramb = this.rub;
    if (paramb != null) {
      paramb.setRemoveBgEnable(paramBoolean1);
    }
    paramb = this.rub;
    if (paramb != null) {
      paramb.setRemoveBackground(paramBoolean2);
    }
    paramb = this.rub;
    if (paramb != null) {
      paramb.setVideoCallback((j.a)this.ruu);
    }
    paramb = this.rub;
    if (paramb != null) {
      paramb.setVideoPath(paramString);
    }
    paramb = this.rub;
    if (paramb != null) {
      paramb.setAlpha(0.0F);
    }
    if (!paramBoolean1)
    {
      this.ruf.setEnabled(false);
      this.ruf.setSelected(false);
      this.rui.setImageDrawable(this.ruo);
      this.ruf.setAlpha(0.3F);
      this.rut = parama;
      AppMethodBeat.o(702);
      return;
    }
    this.ruf.setEnabled(true);
    this.ruf.setAlpha(1.0F);
    this.ruf.setSelected(paramBoolean2);
    paramString = this.rui;
    if (this.ruf.isSelected()) {}
    for (paramb = this.run;; paramb = this.ruo)
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
      this.rud.setVisibility(0);
      EditorChangeTextView localEditorChangeTextView = this.rud;
      localEditorChangeTextView.ova.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.ova.setSelection(paramCharSequence.length());
      }
      int i = e.n(c.cJF(), paramInt);
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
      localEditorChangeTextView.ruB.setSelected(paramInt);
      localEditorChangeTextView.ruC = c.cJF()[paramInt];
      localEditorChangeTextView.ruD = c.cJG()[paramInt];
      localEditorChangeTextView.ova.setTextColor(localEditorChangeTextView.ruC);
      localEditorChangeTextView.ruI = false;
      if (d.oD(28))
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
    this.rud.cancel();
    AppMethodBeat.o(707);
  }
  
  public final boolean bJw()
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
  
  public final void cIA()
  {
    AppMethodBeat.i(703);
    Object localObject = this.rub;
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    }
    localObject = this.rqJ;
    if (localObject == null) {
      p.btv("reporter");
    }
    ((EmojiCaptureReporter)localObject).rnI = System.currentTimeMillis();
    AppMethodBeat.o(703);
  }
  
  public final boolean cIB()
  {
    AppMethodBeat.i(706);
    if (this.rud.getVisibility() == 0)
    {
      AppMethodBeat.o(706);
      return true;
    }
    AppMethodBeat.o(706);
    return false;
  }
  
  public final boolean cIC()
  {
    AppMethodBeat.i(708);
    if (this.rum.getVisibility() == 0)
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
    Log.i(this.TAG, "destroy " + this.rum);
    this.rum.destroy();
    AppMethodBeat.o(712);
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.ruc;
  }
  
  public final b.a getPresenter()
  {
    return this.rtY;
  }
  
  public final long getStartTick()
  {
    return this.gXF;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    return this.rub;
  }
  
  public final void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(709);
    float f = this.rum.getLayoutParams().height;
    ImageView localImageView;
    if (paramBoolean)
    {
      this.ruh.setSelected(true);
      this.rum.setVisibility(0);
      this.rum.animate().translationY(0.0F).start();
      localImageView = this.ruk;
      if (!this.ruh.isSelected()) {
        break label125;
      }
    }
    label125:
    for (Drawable localDrawable = this.rur;; localDrawable = this.rus)
    {
      localImageView.setImageDrawable(localDrawable);
      AppMethodBeat.o(709);
      return;
      this.ruh.setSelected(false);
      this.rum.animate().translationY(f).withEndAction((Runnable)new b(this)).start();
      break;
    }
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(256446);
    if (paramWindowInsets != null) {
      findViewById(2131299972).setPadding(0, paramWindowInsets.getSystemWindowInsetTop(), 0, 0);
    }
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    p.g(paramWindowInsets, "super.onApplyWindowInsets(insets)");
    AppMethodBeat.o(256446);
    return paramWindowInsets;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(710);
    this.ruf.setSelected(false);
    this.rug.setSelected(false);
    this.rui.setImageDrawable(this.ruo);
    this.ruj.setImageDrawable(this.ruq);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.rub;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.stop();
    }
    this.rua.removeView((View)this.rub);
    this.rub = null;
    AppMethodBeat.o(710);
  }
  
  public final void setPresenter(b.a parama)
  {
    this.rtY = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(704);
    p.h(paramEmojiCaptureReporter, "reporter");
    this.rqJ = paramEmojiCaptureReporter;
    this.rud.setReporter(paramEmojiCaptureReporter);
    AppMethodBeat.o(704);
  }
  
  public final void setStartTick(long paramLong)
  {
    this.gXF = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(711);
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.rub;
    if (localEmojiVideoPlayTextureView != null)
    {
      localEmojiVideoPlayTextureView.setVisibility(paramInt);
      AppMethodBeat.o(711);
      return;
    }
    AppMethodBeat.o(711);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
  public static final class a
    implements ac.a
  {
    public final void a(r paramr)
    {
      AppMethodBeat.i(695);
      p.h(paramr, "emojiInfo");
      Log.i(CaptureEditorContainer.a(this.ruv), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramr });
      b.a locala = this.ruv.getPresenter();
      if (locala != null) {
        locala.a(paramr, null);
      }
      onHide();
      AppMethodBeat.o(695);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(696);
      this.ruv.lE(false);
      AppMethodBeat.o(696);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(697);
      CaptureEditorContainer.b(this.ruv).setVisibility(8);
      AppMethodBeat.o(697);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
  public static final class c
    implements j.a
  {
    public final void eo(int paramInt1, int paramInt2) {}
    
    public final int fh(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(701);
      Log.i(CaptureEditorContainer.a(this.ruv), "onCompletion cost " + Util.ticksToNow(this.ruv.getStartTick()) + "ms");
      this.ruv.setStartTick(Util.currentTicks());
      Object localObject = CaptureEditorContainer.n(this.ruv);
      if (localObject != null)
      {
        ((EmojiVideoPlayTextureView)localObject).rsm = true;
        localObject = ((EmojiVideoPlayTextureView)localObject).rsl;
        if (localObject != null)
        {
          ((j)localObject).QC(0);
          AppMethodBeat.o(701);
          return;
        }
        AppMethodBeat.o(701);
        return;
      }
      AppMethodBeat.o(701);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void tf()
    {
      AppMethodBeat.i(700);
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.ruv);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setOnDrawCallback((kotlin.g.a.a)new a(this));
      }
      this.ruv.setStartTick(Util.currentTicks());
      localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.ruv);
      if (localEmojiVideoPlayTextureView != null)
      {
        localEmojiVideoPlayTextureView.start();
        AppMethodBeat.o(700);
        return;
      }
      AppMethodBeat.o(700);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer
 * JD-Core Version:    0.7.0.1
 */