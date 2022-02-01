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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import d.a.e;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG;
  private long fQT;
  private final ChatFooterPanel fWT;
  private ImageView gyM;
  private EmojiCaptureReporter ppG;
  private b.a psQ;
  private b psR;
  private final ViewGroup psS;
  private EmojiVideoPlayTextureView psT;
  private EditorItemContainer psU;
  private EditorChangeTextView psV;
  private View psW;
  private View psX;
  private View psY;
  private View psZ;
  private final ImageView pta;
  private final ImageView ptb;
  private final ImageView ptc;
  private ImageView ptd;
  private final Drawable pte;
  private final Drawable ptf;
  private final Drawable ptg;
  private final Drawable pth;
  private final Drawable pti;
  private final Drawable ptj;
  private a<y> ptk;
  private final c ptl;
  
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
    this.psR = new b();
    View.inflate(paramContext, 2131493770, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299359);
    k.g(paramAttributeSet, "findViewById(R.id.emoji_…e_video_play_view_layout)");
    this.psS = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299293);
    k.g(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.psU = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131297952);
    k.g(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.psV = ((EditorChangeTextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299303);
    k.g(paramAttributeSet, "findViewById(R.id.editor_type_root)");
    this.psW = paramAttributeSet;
    paramAttributeSet = findViewById(2131299297);
    k.g(paramAttributeSet, "findViewById(R.id.editor_remove_background)");
    this.psX = paramAttributeSet;
    paramAttributeSet = findViewById(2131299300);
    k.g(paramAttributeSet, "findViewById(R.id.editor_speed_up)");
    this.psY = paramAttributeSet;
    paramAttributeSet = findViewById(2131299273);
    k.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.psZ = paramAttributeSet;
    paramAttributeSet = findViewById(2131299298);
    k.g(paramAttributeSet, "findViewById(R.id.editor_remove_background_icon)");
    this.pta = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299301);
    k.g(paramAttributeSet, "findViewById(R.id.editor_speed_up_icon)");
    this.ptb = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299274);
    k.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji_icon)");
    this.ptc = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305955);
    k.g(paramAttributeSet, "findViewById(R.id.to_capture)");
    this.gyM = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302291);
    k.g(paramAttributeSet, "findViewById(R.id.mix_video)");
    this.ptd = ((ImageView)paramAttributeSet);
    paramAttributeSet = am.k(paramContext, 2131690468, c.dM(this));
    k.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconSelColor())");
    this.pte = paramAttributeSet;
    paramAttributeSet = am.k(paramContext, 2131690645, c.dN(this));
    k.g(paramAttributeSet, "getColorDrawable(context…ve_bg, getIconNorColor())");
    this.ptf = paramAttributeSet;
    paramAttributeSet = am.k(paramContext, 2131690461, c.dM(this));
    k.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconSelColor())");
    this.ptg = paramAttributeSet;
    paramAttributeSet = am.k(paramContext, 2131690637, c.dN(this));
    k.g(paramAttributeSet, "getColorDrawable(context…ickly, getIconNorColor())");
    this.pth = paramAttributeSet;
    paramAttributeSet = am.k(paramContext, 2131690346, c.dM(this));
    k.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconSelColor())");
    this.pti = paramAttributeSet;
    paramAttributeSet = am.k(paramContext, 2131690511, c.dN(this));
    k.g(paramAttributeSet, "getColorDrawable(context…emoji, getIconNorColor())");
    this.ptj = paramAttributeSet;
    this.pta.setImageDrawable(this.ptf);
    this.ptb.setImageDrawable(this.pth);
    this.ptc.setImageDrawable(this.ptj);
    this.gyM.setImageDrawable(am.k(paramContext, 2131690638, c.dN(this)));
    this.ptd.setImageDrawable(am.k(paramContext, 2131690391, c.dM(this)));
    this.psX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(686);
        EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.ptm).fWr, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.ptm).scene);
        paramAnonymousView = CaptureEditorContainer.d(this.ptm);
        Object localObject = this.ptm.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).ceC();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.e(this.ptm);
          if (!CaptureEditorContainer.d(this.ptm).isSelected()) {
            break label115;
          }
        }
        label115:
        for (paramAnonymousView = CaptureEditorContainer.f(this.ptm);; paramAnonymousView = CaptureEditorContainer.g(this.ptm))
        {
          ((ImageView)localObject).setImageDrawable(paramAnonymousView);
          AppMethodBeat.o(686);
          return;
          bool = false;
          break;
        }
      }
    });
    this.psY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(687);
        EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.ptm).fWr, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.ptm).scene);
        paramAnonymousView = CaptureEditorContainer.h(this.ptm);
        Object localObject = this.ptm.getPresenter();
        boolean bool;
        if (localObject != null)
        {
          bool = ((b.a)localObject).ceD();
          paramAnonymousView.setSelected(bool);
          localObject = CaptureEditorContainer.i(this.ptm);
          if (!CaptureEditorContainer.h(this.ptm).isSelected()) {
            break label115;
          }
        }
        label115:
        for (paramAnonymousView = CaptureEditorContainer.j(this.ptm);; paramAnonymousView = CaptureEditorContainer.k(this.ptm))
        {
          ((ImageView)localObject).setImageDrawable(paramAnonymousView);
          AppMethodBeat.o(687);
          return;
          bool = false;
          break;
        }
      }
    });
    this.psZ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(688);
        EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.ptm).fWr, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.ptm).scene);
        paramAnonymousView = this.ptm;
        if (!this.ptm.ceH()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.ks(bool);
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
        paramAnonymousView = this.ptm.getPresenter();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.Iu();
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
        CaptureEditorContainer.c(this.ptm).pmI = (System.currentTimeMillis() - CaptureEditorContainer.c(this.ptm).pmE);
        CaptureEditorContainer.c(this.ptm).ceA();
        EmojiCaptureReporter.BD(3);
        paramAnonymousView = this.ptm.getPresenter();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.ceE();
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
        if (this.ptm.ceH()) {
          this.ptm.ks(false);
        }
        AppMethodBeat.o(691);
      }
    });
    this.psV.setCallback((EditorChangeTextView.a)new EditorChangeTextView.a()
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
          paramAnonymousCharSequence = this.ptm.getPresenter();
          if (paramAnonymousCharSequence != null) {
            paramAnonymousCharSequence.m((String)localObject, paramAnonymousInt, true);
          }
          CaptureEditorContainer.l(this.ptm).setShow(false);
          AppMethodBeat.o(692);
          return;
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(693);
        b.a locala = this.ptm.getPresenter();
        if (locala != null) {
          locala.m(null, 0, false);
        }
        CaptureEditorContainer.l(this.ptm).setShow(false);
        AppMethodBeat.o(693);
      }
    });
    this.psU.setStateChangeListener((EditorItemContainer.b)new EditorItemContainer.b()
    {
      public final void kx(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(694);
        if (paramAnonymousBoolean)
        {
          CaptureEditorContainer.m(this.ptm).setVisibility(8);
          AppMethodBeat.o(694);
          return;
        }
        CaptureEditorContainer.m(this.ptm).setVisibility(0);
        AppMethodBeat.o(694);
      }
    });
    paramContext = aa.bh(paramContext);
    k.g(paramContext, "SmileyPanelFactory.getSmileyPanel(context)");
    this.fWT = ((ChatFooterPanel)paramContext);
    ac.i(this.TAG, "initSmileyPanel " + this.fWT);
    this.fWT.setEntranceScene(ChatFooterPanel.Dnm);
    this.fWT.setShowSmiley(false);
    this.fWT.setShowClose(true);
    this.fWT.setVisibility(8);
    this.fWT.onResume();
    paramContext = aa.JP();
    k.g(paramContext, "callbackWrapper");
    paramContext.a((z.a)new a(this));
    this.fWT.setCallback((f)paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, aa.bi(getContext()));
    paramContext.addRule(12);
    addView((View)this.fWT, (ViewGroup.LayoutParams)paramContext);
    this.fWT.setTranslationY(paramContext.height);
    this.ptl = new c(this);
    AppMethodBeat.o(713);
  }
  
  public final void a(b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, a<y> parama)
  {
    AppMethodBeat.i(702);
    k.h(paramb, "captureInfo");
    k.h(paramString, "videoPath");
    this.psR = paramb;
    paramb = getContext();
    k.g(paramb, "context");
    this.psT = new EmojiVideoPlayTextureView(paramb);
    this.psS.addView((View)this.psT);
    paramb = this.psT;
    if (paramb != null) {
      paramb.setRemoveBgEnable(paramBoolean1);
    }
    paramb = this.psT;
    if (paramb != null) {
      paramb.setRemoveBackground(paramBoolean2);
    }
    paramb = this.psT;
    if (paramb != null) {
      paramb.setVideoCallback((h.a)this.ptl);
    }
    paramb = this.psT;
    if (paramb != null) {
      paramb.setVideoPath(paramString);
    }
    paramb = this.psT;
    if (paramb != null) {
      paramb.setAlpha(0.0F);
    }
    if (!paramBoolean1)
    {
      this.psX.setEnabled(false);
      this.psX.setSelected(false);
      this.pta.setImageDrawable(this.ptf);
      this.psX.setAlpha(0.3F);
      this.ptk = parama;
      AppMethodBeat.o(702);
      return;
    }
    this.psX.setEnabled(true);
    this.psX.setAlpha(1.0F);
    this.psX.setSelected(paramBoolean2);
    paramString = this.pta;
    if (this.psX.isSelected()) {}
    for (paramb = this.pte;; paramb = this.ptf)
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
      this.psV.setVisibility(0);
      EditorChangeTextView localEditorChangeTextView = this.psV;
      localEditorChangeTextView.mFN.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.mFN.setSelection(paramCharSequence.length());
      }
      int i = e.n(c.cfK(), paramInt);
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
      localEditorChangeTextView.ptu.setSelected(paramInt);
      localEditorChangeTextView.ptv = c.cfK()[paramInt];
      localEditorChangeTextView.ptw = c.cfL()[paramInt];
      localEditorChangeTextView.mFN.setTextColor(localEditorChangeTextView.ptv);
      localEditorChangeTextView.ptB = false;
      AppMethodBeat.o(707);
      return;
    }
    this.psV.cancel();
    AppMethodBeat.o(707);
  }
  
  public final boolean bjw()
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
  
  public final void ceF()
  {
    AppMethodBeat.i(703);
    Object localObject = this.psT;
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    }
    localObject = this.ppG;
    if (localObject == null) {
      k.aVY("reporter");
    }
    ((EmojiCaptureReporter)localObject).pmE = System.currentTimeMillis();
    AppMethodBeat.o(703);
  }
  
  public final boolean ceG()
  {
    AppMethodBeat.i(706);
    if (this.psV.getVisibility() == 0)
    {
      AppMethodBeat.o(706);
      return true;
    }
    AppMethodBeat.o(706);
    return false;
  }
  
  public final boolean ceH()
  {
    AppMethodBeat.i(708);
    if (this.fWT.getVisibility() == 0)
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
    ac.i(this.TAG, "destroy " + this.fWT);
    this.fWT.destroy();
    AppMethodBeat.o(712);
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.psU;
  }
  
  public final b.a getPresenter()
  {
    return this.psQ;
  }
  
  public final long getStartTick()
  {
    return this.fQT;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    return this.psT;
  }
  
  public final void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(709);
    float f = this.fWT.getLayoutParams().height;
    ImageView localImageView;
    if (paramBoolean)
    {
      this.psZ.setSelected(true);
      this.fWT.setVisibility(0);
      this.fWT.animate().translationY(0.0F).start();
      localImageView = this.ptc;
      if (!this.psZ.isSelected()) {
        break label125;
      }
    }
    label125:
    for (Drawable localDrawable = this.pti;; localDrawable = this.ptj)
    {
      localImageView.setImageDrawable(localDrawable);
      AppMethodBeat.o(709);
      return;
      this.psZ.setSelected(false);
      this.fWT.animate().translationY(f).withEndAction((Runnable)new b(this)).start();
      break;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(710);
    this.psX.setSelected(false);
    this.psY.setSelected(false);
    this.pta.setImageDrawable(this.ptf);
    this.ptb.setImageDrawable(this.pth);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.psT;
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.stop();
    }
    this.psS.removeView((View)this.psT);
    this.psT = null;
    AppMethodBeat.o(710);
  }
  
  public final void setPresenter(b.a parama)
  {
    this.psQ = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(704);
    k.h(paramEmojiCaptureReporter, "reporter");
    this.ppG = paramEmojiCaptureReporter;
    this.psV.setReporter(paramEmojiCaptureReporter);
    AppMethodBeat.o(704);
  }
  
  public final void setStartTick(long paramLong)
  {
    this.fQT = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(711);
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.psT;
    if (localEmojiVideoPlayTextureView != null)
    {
      localEmojiVideoPlayTextureView.setVisibility(paramInt);
      AppMethodBeat.o(711);
      return;
    }
    AppMethodBeat.o(711);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
  public static final class a
    implements z.a
  {
    public final void a(p paramp)
    {
      AppMethodBeat.i(695);
      k.h(paramp, "emojiInfo");
      ac.i(CaptureEditorContainer.a(this.ptm), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramp });
      b.a locala = this.ptm.getPresenter();
      if (locala != null) {
        locala.a(paramp, null);
      }
      onHide();
      AppMethodBeat.o(695);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(696);
      this.ptm.ks(false);
      AppMethodBeat.o(696);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(697);
      CaptureEditorContainer.b(this.ptm).setVisibility(8);
      AppMethodBeat.o(697);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
  public static final class c
    implements h.a
  {
    public final void dZ(int paramInt1, int paramInt2) {}
    
    public final int eP(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(701);
      ac.i(CaptureEditorContainer.a(this.ptm), "onCompletion cost " + bs.aO(this.ptm.getStartTick()) + "ms");
      this.ptm.setStartTick(bs.Gn());
      Object localObject = CaptureEditorContainer.n(this.ptm);
      if (localObject != null)
      {
        ((EmojiVideoPlayTextureView)localObject).pre = true;
        localObject = ((EmojiVideoPlayTextureView)localObject).prd;
        if (localObject != null)
        {
          ((j)localObject).IE(0);
          AppMethodBeat.o(701);
          return;
        }
        AppMethodBeat.o(701);
        return;
      }
      AppMethodBeat.o(701);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void rB()
    {
      AppMethodBeat.i(700);
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.ptm);
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setOnDrawCallback((a)new a(this));
      }
      this.ptm.setStartTick(bs.Gn());
      localEmojiVideoPlayTextureView = CaptureEditorContainer.n(this.ptm);
      if (localEmojiVideoPlayTextureView != null)
      {
        localEmojiVideoPlayTextureView.start();
        AppMethodBeat.o(700);
        return;
      }
      AppMethodBeat.o(700);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer
 * JD-Core Version:    0.7.0.1
 */