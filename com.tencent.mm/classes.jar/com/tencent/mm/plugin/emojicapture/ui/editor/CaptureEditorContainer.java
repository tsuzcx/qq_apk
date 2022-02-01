package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.ae;
import com.tencent.mm.api.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.h;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG;
  private final ChatFooterPanel moD;
  private long moe;
  private ImageView nfU;
  private EmojiCaptureReporter yiI;
  private b.a ylG;
  private com.tencent.mm.plugin.emojicapture.model.a.b ylH;
  private final ViewGroup ylI;
  private EmojiVideoPlayTextureView ylJ;
  private EditorItemContainer ylK;
  private EditorChangeTextView ylL;
  private View ylM;
  private View ylN;
  private View ylO;
  private View ylP;
  private final ImageView ylQ;
  private final ImageView ylR;
  private final ImageView ylS;
  private ImageView ylT;
  private final Drawable ylU;
  private final Drawable ylV;
  private final Drawable ylW;
  private final Drawable ylX;
  private final Drawable ylY;
  private final Drawable ylZ;
  private kotlin.g.a.a<ah> yma;
  private final b ymb;
  
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
    this.ylH = new com.tencent.mm.plugin.emojicapture.model.a.b();
    View.inflate(paramContext, a.g.yfw, (ViewGroup)this);
    paramAttributeSet = findViewById(a.f.yeQ);
    s.s(paramAttributeSet, "findViewById(R.id.emoji_…e_video_play_view_layout)");
    this.ylI = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.editor_item_container);
    s.s(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.ylK = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.change_text_root);
    s.s(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.ylL = ((EditorChangeTextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yev);
    s.s(paramAttributeSet, "findViewById(R.id.editor_type_root)");
    this.ylM = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.yer);
    s.s(paramAttributeSet, "findViewById(R.id.editor_remove_background)");
    this.ylN = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.yet);
    s.s(paramAttributeSet, "findViewById(R.id.editor_speed_up)");
    this.ylO = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.editor_add_emoji);
    s.s(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.ylP = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.yes);
    s.s(paramAttributeSet, "findViewById(R.id.editor_remove_background_icon)");
    this.ylQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeu);
    s.s(paramAttributeSet, "findViewById(R.id.editor_speed_up_icon)");
    this.ylR = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yep);
    s.s(paramAttributeSet, "findViewById(R.id.editor_add_emoji_icon)");
    this.ylS = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yfk);
    s.s(paramAttributeSet, "findViewById(R.id.to_capture)");
    this.nfU = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeT);
    s.s(paramAttributeSet, "findViewById(R.id.mix_video)");
    this.ylT = ((ImageView)paramAttributeSet);
    paramAttributeSet = bb.m(paramContext, a.h.icons_filled_remove_bg, com.tencent.mm.plugin.emojicapture.ui.b.eZ((View)this));
    s.s(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconSelColor())");
    this.ylU = paramAttributeSet;
    paramAttributeSet = bb.m(paramContext, a.h.icons_outlined_remove_bg, com.tencent.mm.plugin.emojicapture.ui.b.fa((View)this));
    s.s(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconNorColor())");
    this.ylV = paramAttributeSet;
    paramAttributeSet = bb.m(paramContext, a.h.icons_filled_play_quickly, com.tencent.mm.plugin.emojicapture.ui.b.eZ((View)this));
    s.s(paramAttributeSet, "getColorDrawable(context…ickly, getIconSelColor())");
    this.ylW = paramAttributeSet;
    paramAttributeSet = bb.m(paramContext, a.h.icons_outlined_play_quickly, com.tencent.mm.plugin.emojicapture.ui.b.fa((View)this));
    s.s(paramAttributeSet, "getColorDrawable(context…ickly, getIconNorColor())");
    this.ylX = paramAttributeSet;
    paramAttributeSet = bb.m(paramContext, a.h.icons_filled_add_emoji, com.tencent.mm.plugin.emojicapture.ui.b.eZ((View)this));
    s.s(paramAttributeSet, "getColorDrawable(context…emoji, getIconSelColor())");
    this.ylY = paramAttributeSet;
    paramAttributeSet = bb.m(paramContext, a.h.icons_outlined_add_emoji, com.tencent.mm.plugin.emojicapture.ui.b.fa((View)this));
    s.s(paramAttributeSet, "getColorDrawable(context…emoji, getIconNorColor())");
    this.ylZ = paramAttributeSet;
    this.ylQ.setImageDrawable(this.ylV);
    this.ylR.setImageDrawable(this.ylX);
    this.ylS.setImageDrawable(this.ylZ);
    this.nfU.setImageDrawable(bb.m(paramContext, a.h.icons_outlined_previous, com.tencent.mm.plugin.emojicapture.ui.b.fa((View)this)));
    this.ylT.setImageDrawable(bb.m(paramContext, a.h.icons_filled_done, com.tencent.mm.plugin.emojicapture.ui.b.eZ((View)this)));
    this.ylN.setOnClickListener(new CaptureEditorContainer..ExternalSyntheticLambda0(this));
    this.ylO.setOnClickListener(new CaptureEditorContainer..ExternalSyntheticLambda1(this));
    this.ylP.setOnClickListener(new CaptureEditorContainer..ExternalSyntheticLambda4(this));
    findViewById(a.f.yeC).setOnClickListener(new CaptureEditorContainer..ExternalSyntheticLambda3(this));
    findViewById(a.f.yeB).setOnClickListener(new CaptureEditorContainer..ExternalSyntheticLambda2(this));
    setOnClickListener(new CaptureEditorContainer..ExternalSyntheticLambda5(this));
    this.ylL.setCallback((EditorChangeTextView.a)new EditorChangeTextView.a()
    {
      public final void f(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
      {
        AppMethodBeat.i(692);
        if (paramAnonymousCharSequence == null) {}
        for (paramAnonymousCharSequence = null;; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
        {
          Object localObject = paramAnonymousCharSequence;
          if (paramAnonymousCharSequence != null)
          {
            localObject = paramAnonymousCharSequence;
            if (paramAnonymousCharSequence.length() > 50)
            {
              localObject = paramAnonymousCharSequence.substring(0, 50);
              s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
          }
          paramAnonymousCharSequence = this.ymc.getPresenter();
          if (paramAnonymousCharSequence != null) {
            paramAnonymousCharSequence.s((String)localObject, paramAnonymousInt, true);
          }
          CaptureEditorContainer.c(this.ymc).setShow(false);
          AppMethodBeat.o(692);
          return;
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(693);
        b.a locala = this.ymc.getPresenter();
        if (locala != null) {
          locala.s(null, 0, false);
        }
        CaptureEditorContainer.c(this.ymc).setShow(false);
        AppMethodBeat.o(693);
      }
    });
    this.ylK.setStateChangeListener((EditorItemContainer.b)new EditorItemContainer.b()
    {
      public final void iQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(694);
        if (paramAnonymousBoolean)
        {
          CaptureEditorContainer.d(this.ymc).setVisibility(8);
          AppMethodBeat.o(694);
          return;
        }
        CaptureEditorContainer.d(this.ymc).setVisibility(0);
        AppMethodBeat.o(694);
      }
    });
    paramContext = ae.co(paramContext);
    s.s(paramContext, "getSmileyPanel(context)");
    this.moD = ((ChatFooterPanel)paramContext);
    Log.i(this.TAG, s.X("initSmileyPanel ", this.moD));
    this.moD.setEntranceScene(ChatFooterPanel.XYo);
    this.moD.setShowSmiley(false);
    this.moD.setShowClose(true);
    this.moD.setVisibility(8);
    this.moD.onResume();
    paramContext = ae.aBJ();
    paramContext.hej = ((ad.a)new a(this));
    this.moD.setCallback((f)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, ae.cp(getContext()));
    paramContext.addRule(12);
    addView((View)this.moD, (ViewGroup.LayoutParams)paramContext);
    this.moD.setTranslationY(paramContext.height);
    this.ymb = new b(this);
    AppMethodBeat.o(713);
  }
  
  private static final void a(CaptureEditorContainer paramCaptureEditorContainer)
  {
    AppMethodBeat.i(269534);
    s.u(paramCaptureEditorContainer, "this$0");
    paramCaptureEditorContainer.moD.setVisibility(8);
    AppMethodBeat.o(269534);
  }
  
  private static final void a(CaptureEditorContainer paramCaptureEditorContainer, View paramView)
  {
    AppMethodBeat.i(269504);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCaptureEditorContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCaptureEditorContainer, "this$0");
    localObject = paramCaptureEditorContainer.yiI;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("reporter");
      paramView = null;
    }
    long l = paramView.mnX;
    localObject = paramCaptureEditorContainer.yiI;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("reporter");
      paramView = null;
    }
    EmojiCaptureReporter.a(10, l, 0L, 0L, 0L, 0L, 0, 0, paramView.scene);
    paramView = paramCaptureEditorContainer.ylN;
    localObject = paramCaptureEditorContainer.getPresenter();
    boolean bool;
    if (localObject == null)
    {
      bool = false;
      paramView.setSelected(bool);
      paramView = paramCaptureEditorContainer.ylQ;
      if (!paramCaptureEditorContainer.ylN.isSelected()) {
        break label221;
      }
    }
    label221:
    for (paramCaptureEditorContainer = paramCaptureEditorContainer.ylU;; paramCaptureEditorContainer = paramCaptureEditorContainer.ylV)
    {
      paramView.setImageDrawable(paramCaptureEditorContainer);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269504);
      return;
      bool = ((b.a)localObject).dDx();
      break;
    }
  }
  
  private static final void b(CaptureEditorContainer paramCaptureEditorContainer, View paramView)
  {
    AppMethodBeat.i(269509);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCaptureEditorContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCaptureEditorContainer, "this$0");
    localObject = paramCaptureEditorContainer.yiI;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("reporter");
      paramView = null;
    }
    long l = paramView.mnX;
    localObject = paramCaptureEditorContainer.yiI;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("reporter");
      paramView = null;
    }
    EmojiCaptureReporter.a(11, l, 0L, 0L, 0L, 0L, 0, 0, paramView.scene);
    paramView = paramCaptureEditorContainer.ylO;
    localObject = paramCaptureEditorContainer.getPresenter();
    boolean bool;
    if (localObject == null)
    {
      bool = false;
      paramView.setSelected(bool);
      paramView = paramCaptureEditorContainer.ylR;
      if (!paramCaptureEditorContainer.ylO.isSelected()) {
        break label221;
      }
    }
    label221:
    for (paramCaptureEditorContainer = paramCaptureEditorContainer.ylW;; paramCaptureEditorContainer = paramCaptureEditorContainer.ylX)
    {
      paramView.setImageDrawable(paramCaptureEditorContainer);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269509);
      return;
      bool = ((b.a)localObject).dDy();
      break;
    }
  }
  
  private static final void c(CaptureEditorContainer paramCaptureEditorContainer, View paramView)
  {
    AppMethodBeat.i(269514);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCaptureEditorContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCaptureEditorContainer, "this$0");
    localObject = paramCaptureEditorContainer.yiI;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("reporter");
      paramView = null;
    }
    long l = paramView.mnX;
    localObject = paramCaptureEditorContainer.yiI;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("reporter");
      paramView = null;
    }
    EmojiCaptureReporter.a(12, l, 0L, 0L, 0L, 0L, 0, 0, paramView.scene);
    if (!paramCaptureEditorContainer.dDC()) {}
    for (boolean bool = true;; bool = false)
    {
      paramCaptureEditorContainer.oo(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269514);
      return;
    }
  }
  
  private static final void d(CaptureEditorContainer paramCaptureEditorContainer, View paramView)
  {
    AppMethodBeat.i(269516);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCaptureEditorContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCaptureEditorContainer, "this$0");
    paramCaptureEditorContainer = paramCaptureEditorContainer.getPresenter();
    if (paramCaptureEditorContainer != null) {
      paramCaptureEditorContainer.aAx();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269516);
  }
  
  private static final void e(CaptureEditorContainer paramCaptureEditorContainer, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(269524);
    Object localObject1 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramCaptureEditorContainer);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    s.u(paramCaptureEditorContainer, "this$0");
    localObject1 = paramCaptureEditorContainer.yiI;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      s.bIx("reporter");
      paramView = null;
    }
    long l = System.currentTimeMillis();
    localObject3 = paramCaptureEditorContainer.yiI;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("reporter");
      localObject1 = null;
    }
    paramView.ygh = (l - ((EmojiCaptureReporter)localObject1).ygd);
    paramView = paramCaptureEditorContainer.yiI;
    if (paramView == null)
    {
      s.bIx("reporter");
      paramView = localObject2;
    }
    for (;;)
    {
      h.OAn.b(15982, new Object[] { Integer.valueOf(17), Long.valueOf(paramView.mnX), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramView.ygh), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramView.scene), paramView.ygo, Integer.valueOf(paramView.ygp), Integer.valueOf(0), Integer.valueOf(paramView.ygq), paramView.ygr, Integer.valueOf(paramView.ygs), Integer.valueOf(paramView.ygt) });
      EmojiCaptureReporter.KN(3);
      paramCaptureEditorContainer = paramCaptureEditorContainer.getPresenter();
      if (paramCaptureEditorContainer != null) {
        paramCaptureEditorContainer.dDz();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269524);
      return;
    }
  }
  
  private static final void f(CaptureEditorContainer paramCaptureEditorContainer, View paramView)
  {
    AppMethodBeat.i(269528);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCaptureEditorContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCaptureEditorContainer, "this$0");
    if (paramCaptureEditorContainer.dDC()) {
      paramCaptureEditorContainer.oo(false);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269528);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(702);
    s.u(paramb, "captureInfo");
    s.u(paramString, "videoPath");
    this.ylH = paramb;
    paramb = getContext();
    s.s(paramb, "context");
    this.ylJ = new EmojiVideoPlayTextureView(paramb);
    this.ylI.addView((View)this.ylJ);
    paramb = this.ylJ;
    if (paramb != null) {
      paramb.setRemoveBgEnable(paramBoolean1);
    }
    paramb = this.ylJ;
    if (paramb != null) {
      paramb.setRemoveBackground(paramBoolean2);
    }
    paramb = this.ylJ;
    if (paramb != null) {
      paramb.setVideoCallback((i.a)this.ymb);
    }
    paramb = this.ylJ;
    if (paramb != null) {
      paramb.setVideoPath(paramString);
    }
    paramb = this.ylJ;
    if (paramb != null) {
      paramb.setAlpha(0.0F);
    }
    if (!paramBoolean1)
    {
      this.ylN.setEnabled(false);
      this.ylN.setSelected(false);
      this.ylQ.setImageDrawable(this.ylV);
      this.ylN.setAlpha(0.3F);
      this.yma = parama;
      AppMethodBeat.o(702);
      return;
    }
    this.ylN.setEnabled(true);
    this.ylN.setAlpha(1.0F);
    this.ylN.setSelected(paramBoolean2);
    paramString = this.ylQ;
    if (this.ylN.isSelected()) {}
    for (paramb = this.ylU;; paramb = this.ylV)
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
      this.ylL.setVisibility(0);
      EditorChangeTextView localEditorChangeTextView = this.ylL;
      localEditorChangeTextView.uIG.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.uIG.setSelection(paramCharSequence.length());
      }
      int i = k.B(com.tencent.mm.plugin.emojicapture.ui.b.dEF(), paramInt);
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
      localEditorChangeTextView.ymg.setSelected(paramInt);
      localEditorChangeTextView.ymh = com.tencent.mm.plugin.emojicapture.ui.b.dEF()[paramInt];
      localEditorChangeTextView.ymi = com.tencent.mm.plugin.emojicapture.ui.b.dEG()[paramInt];
      localEditorChangeTextView.uIG.setTextColor(localEditorChangeTextView.ymh);
      localEditorChangeTextView.ymn = false;
      if (d.rb(28))
      {
        paramCharSequence = localEditorChangeTextView.getRootWindowInsets();
        if (paramCharSequence != null) {
          break label177;
        }
      }
      label177:
      for (paramCharSequence = null;; paramCharSequence = paramCharSequence.getDisplayCutout())
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
    this.ylL.cancel();
    AppMethodBeat.o(707);
  }
  
  public final boolean cvt()
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
  
  public final void dDA()
  {
    AppMethodBeat.i(703);
    Object localObject = this.ylJ;
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    }
    EmojiCaptureReporter localEmojiCaptureReporter = this.yiI;
    localObject = localEmojiCaptureReporter;
    if (localEmojiCaptureReporter == null)
    {
      s.bIx("reporter");
      localObject = null;
    }
    ((EmojiCaptureReporter)localObject).ygd = System.currentTimeMillis();
    AppMethodBeat.o(703);
  }
  
  public final boolean dDB()
  {
    AppMethodBeat.i(706);
    if (this.ylL.getVisibility() == 0)
    {
      AppMethodBeat.o(706);
      return true;
    }
    AppMethodBeat.o(706);
    return false;
  }
  
  public final boolean dDC()
  {
    AppMethodBeat.i(708);
    if (this.moD.getVisibility() == 0)
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
    Log.i(this.TAG, s.X("destroy ", this.moD));
    this.moD.destroy();
    AppMethodBeat.o(712);
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.ylK;
  }
  
  public final b.a getPresenter()
  {
    return this.ylG;
  }
  
  public final long getStartTick()
  {
    return this.moe;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    return this.ylJ;
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(269620);
    if (paramWindowInsets != null) {
      findViewById(a.f.yeR).setPadding(0, paramWindowInsets.getSystemWindowInsetTop(), 0, 0);
    }
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    s.s(paramWindowInsets, "super.onApplyWindowInsets(insets)");
    AppMethodBeat.o(269620);
    return paramWindowInsets;
  }
  
  public final void oo(boolean paramBoolean)
  {
    AppMethodBeat.i(709);
    float f = this.moD.getLayoutParams().height;
    ImageView localImageView;
    if (paramBoolean)
    {
      this.ylP.setSelected(true);
      this.moD.setVisibility(0);
      this.moD.animate().translationY(0.0F).start();
      localImageView = this.ylS;
      if (!this.ylP.isSelected()) {
        break label122;
      }
    }
    label122:
    for (Drawable localDrawable = this.ylY;; localDrawable = this.ylZ)
    {
      localImageView.setImageDrawable(localDrawable);
      AppMethodBeat.o(709);
      return;
      this.ylP.setSelected(false);
      this.moD.animate().translationY(f).withEndAction(new CaptureEditorContainer..ExternalSyntheticLambda6(this)).start();
      break;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(710);
    this.ylN.setSelected(false);
    this.ylO.setSelected(false);
    this.ylQ.setImageDrawable(this.ylV);
    this.ylR.setImageDrawable(this.ylX);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.ylJ;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.stop();
    }
    this.ylI.removeView((View)this.ylJ);
    this.ylJ = null;
    AppMethodBeat.o(710);
  }
  
  public final void setPresenter(b.a parama)
  {
    this.ylG = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(704);
    s.u(paramEmojiCaptureReporter, "reporter");
    this.yiI = paramEmojiCaptureReporter;
    this.ylL.setReporter(paramEmojiCaptureReporter);
    AppMethodBeat.o(704);
  }
  
  public final void setStartTick(long paramLong)
  {
    this.moe = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(711);
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.ylJ;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.setVisibility(paramInt);
    }
    AppMethodBeat.o(711);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ad.a
  {
    a(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void a(t paramt)
    {
      AppMethodBeat.i(695);
      s.u(paramt, "emojiInfo");
      Log.i(CaptureEditorContainer.b(this.ymc), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramt });
      b.a locala = this.ymc.getPresenter();
      if (locala != null) {
        locala.a(paramt, null);
      }
      onHide();
      AppMethodBeat.o(695);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(696);
      this.ymc.oo(false);
      AppMethodBeat.o(696);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.a
  {
    b(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void Qz()
    {
      AppMethodBeat.i(700);
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = CaptureEditorContainer.e(this.ymc);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setOnDrawCallback((kotlin.g.a.a)new a(this.ymc));
      }
      this.ymc.setStartTick(Util.currentTicks());
      localEmojiVideoPlayTextureView = CaptureEditorContainer.e(this.ymc);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.start();
      }
      AppMethodBeat.o(700);
    }
    
    public final void fG(int paramInt1, int paramInt2) {}
    
    public final int gw(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(701);
      Log.i(CaptureEditorContainer.b(this.ymc), "onCompletion cost " + Util.ticksToNow(this.ymc.getStartTick()) + "ms");
      this.ymc.setStartTick(Util.currentTicks());
      Object localObject = CaptureEditorContainer.e(this.ymc);
      if (localObject != null)
      {
        ((EmojiVideoPlayTextureView)localObject).ykg = true;
        localObject = ((EmojiVideoPlayTextureView)localObject).ykf;
        if (localObject != null) {
          ((j)localObject).aaS(0);
        }
      }
      AppMethodBeat.o(701);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(CaptureEditorContainer paramCaptureEditorContainer)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer
 * JD-Core Version:    0.7.0.1
 */