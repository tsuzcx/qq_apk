package com.tencent.mm.plugin.appbrand.widget.input.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.au.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandInputNewSmileyPanel;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/input/panel/IKeyboardPanel;", "Lcom/tencent/mm/plugin/appbrand/widget/input/panel/IKeyboardPanelSizeHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appropriateHeightInPort", "", "getAppropriateHeightInPort", "()I", "mForcePanelHeight", "mSmileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "getForcedPanelHeight", "getPanelDefaultHeightInPort", "getPanelHeightInLandscape", "getPanelView", "Landroid/view/View;", "hideContentView", "", "clearBackgroundDrawable", "", "isRealHeightSettled", "obtainPanelBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "onDestroy", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "setForceHeight", "height", "setForcePanelHeight", "setOnEmoticonOperationListener", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/input/panel/OnEmoticonOperateListener;", "setOnTextOperationListener", "Lcom/tencent/mm/plugin/appbrand/widget/input/panel/OnTextOperationListener;", "showContentView", "showStoreEmoticon", "show", "supportSmileyInput", "this_isInLayout", "Companion", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class a
  extends FrameLayout
  implements b, f
{
  @Deprecated
  public static final a rzK;
  private final ChatFooterPanel rzI;
  private int rzJ;
  
  static
  {
    AppMethodBeat.i(273127);
    rzK = new a((byte)0);
    AppMethodBeat.o(273127);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(273126);
    this.Ejd = new g();
    this.rzI = ((ChatFooterPanel)new SmileyPanelImpl(paramContext, false));
    paramContext = this.rzI;
    paramContext.setShowSmiley(true);
    paramContext.hjn();
    paramContext.hjo();
    paramContext.setShowStore(false);
    paramContext.setShowSend(false);
    paramContext.setShowClose(false);
    paramContext.onResume();
    addView((View)this.rzI, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    setClickable(true);
    AppMethodBeat.o(273126);
  }
  
  private final Drawable cpC()
  {
    AppMethodBeat.i(273125);
    TypedArray localTypedArray = this.rzI.getContext().obtainStyledAttributes(new int[] { au.b.emojiPanelBackground });
    try
    {
      Drawable localDrawable = localTypedArray.getDrawable(0);
      return localDrawable;
    }
    finally
    {
      localTypedArray.recycle();
      AppMethodBeat.o(273125);
    }
  }
  
  private final int getAppropriateHeightInPort()
  {
    AppMethodBeat.i(293238);
    if (this.rzJ > 0)
    {
      i = this.rzJ;
      AppMethodBeat.o(293238);
      return i;
    }
    int i = getPanelDefaultHeightInPort();
    AppMethodBeat.o(293238);
    return i;
  }
  
  public final boolean DW(int paramInt)
  {
    AppMethodBeat.i(293237);
    if ((paramInt > 0) && (this.rzJ != paramInt))
    {
      this.rzJ = paramInt;
      if (this == null)
      {
        t localt = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.input.panel.IKeyboardPanelSizeHelper");
        AppMethodBeat.o(293237);
        throw localt;
      }
      ((f)this).setForceHeight(paramInt);
      AppMethodBeat.o(293237);
      return true;
    }
    AppMethodBeat.o(293237);
    return false;
  }
  
  public final void ce(boolean paramBoolean)
  {
    AppMethodBeat.i(273122);
    this.rzI.setShowStore(paramBoolean);
    AppMethodBeat.o(273122);
  }
  
  public final boolean coN()
  {
    AppMethodBeat.i(273112);
    Log.d("MicroMsg.AppBrandInputNewSmileyPanel", "[scrollUp] isRealHeightSettled, mForcePanelHeight:" + this.rzJ + ", height:" + getHeight() + ", measuredHeight:" + getMeasuredHeight());
    if ((this.rzJ > 0) && (this.rzJ == getMeasuredHeight()))
    {
      AppMethodBeat.o(273112);
      return true;
    }
    AppMethodBeat.o(273112);
    return false;
  }
  
  public final boolean cpA()
  {
    AppMethodBeat.i(273120);
    boolean bool = super.isInLayout();
    AppMethodBeat.o(273120);
    return bool;
  }
  
  public final boolean cpB()
  {
    return true;
  }
  
  public final void cpz()
  {
    AppMethodBeat.i(273115);
    this.rzI.setVisibility(0);
    setBackground(null);
    AppMethodBeat.o(273115);
  }
  
  public final int getForcedPanelHeight()
  {
    return this.rzJ;
  }
  
  public final int getPanelDefaultHeightInPort()
  {
    AppMethodBeat.i(293239);
    int i = this.Ejd.getPanelDefaultHeightInPort();
    AppMethodBeat.o(293239);
    return i;
  }
  
  public final int getPanelHeightInLandscape()
  {
    AppMethodBeat.i(293240);
    int i = this.Ejd.getPanelHeightInLandscape();
    AppMethodBeat.o(293240);
    return i;
  }
  
  public final View getPanelView()
  {
    return (View)this;
  }
  
  public final void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(273116);
    this.rzI.setVisibility(4);
    if (paramBoolean)
    {
      setBackground(null);
      AppMethodBeat.o(273116);
      return;
    }
    setBackground(cpC());
    AppMethodBeat.o(273116);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273119);
    removeAllViews();
    AppMethodBeat.o(273119);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(273113);
    if (!isShown())
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(273113);
      return;
    }
    if (!KeyBoardUtil.isPortOrientation(getContext())) {}
    for (paramInt2 = getPanelHeightInLandscape();; paramInt2 = getAppropriateHeightInPort())
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(273113);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(273118);
    this.rzI.onPause();
    AppMethodBeat.o(273118);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273117);
    this.rzI.onResume();
    AppMethodBeat.o(273117);
  }
  
  public final void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(293241);
    this.Ejd.setForceHeight(paramInt);
    AppMethodBeat.o(293241);
  }
  
  public final void setOnEmoticonOperationListener(d paramd)
  {
    AppMethodBeat.i(273123);
    this.rzI.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)new b(paramd));
    AppMethodBeat.o(273123);
  }
  
  public final void setOnTextOperationListener(e parame)
  {
    AppMethodBeat.i(273114);
    ChatFooterPanel localChatFooterPanel = this.rzI;
    if (parame == null) {}
    for (parame = null;; parame = new c(parame))
    {
      localChatFooterPanel.setOnTextOperationListener((ChatFooterPanel.a)parame);
      AppMethodBeat.o(273114);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandInputNewSmileyPanel$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandInputNewSmileyPanel$setOnEmoticonOperationListener$1", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "isCustomSmileyEnable", "", "isOpenCustomSmileyEnable", "onClearEditTextView", "", "onCustomEmojiSelected", "onHidePanel", "onSearchDialogShow", "isShow", "dialogHeight", "", "onSendAppMsgCustomEmoji", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onSendCustomEmoji", "plugin-appbrand-integration_release"})
  public static final class b
    implements j
  {
    b(d paramd) {}
    
    public final void A(boolean paramBoolean, int paramInt) {}
    
    public final void cpE() {}
    
    public final void cpF() {}
    
    public final void o(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(267792);
      if (paramEmojiInfo == null)
      {
        AppMethodBeat.o(267792);
        return;
      }
      Object localObject1 = (com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject1).getProvider();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((com.tencent.mm.pluginsdk.b.e)localObject1).auh(paramEmojiInfo.getMd5());; localObject1 = null)
      {
        a.cpD();
        Object localObject4 = new StringBuilder("onSendCustomEmoji productId:").append(paramEmojiInfo.aCt()).append(", md5:").append(paramEmojiInfo.getMd5()).append(", desc:").append((String)localObject1).append(", designerId:");
        Object localObject3 = paramEmojiInfo.field_designerID;
        Object localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        Log.i("MicroMsg.AppBrandInputNewSmileyPanel", (String)localObject2);
        localObject3 = this.rzL;
        if (localObject3 == null) {
          break;
        }
        localObject4 = paramEmojiInfo.getMd5();
        String str = paramEmojiInfo.aCt();
        localObject2 = paramEmojiInfo.field_designerID;
        paramEmojiInfo = (EmojiInfo)localObject2;
        if (localObject2 == null) {
          paramEmojiInfo = "";
        }
        ((d)localObject3).a((String)localObject4, str, (String)localObject1, paramEmojiInfo);
        AppMethodBeat.o(267792);
        return;
      }
      AppMethodBeat.o(267792);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandInputNewSmileyPanel$setOnTextOperationListener$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-appbrand-integration_release"})
  public static final class c
    implements ChatFooterPanel.a
  {
    c(e parame) {}
    
    public final void aDN() {}
    
    public final void aDO()
    {
      AppMethodBeat.i(276240);
      this.rzM.aDO();
      AppMethodBeat.o(276240);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(276239);
      this.rzM.append(paramString);
      AppMethodBeat.o(276239);
    }
    
    public final void eE(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.a
 * JD-Core Version:    0.7.0.1
 */