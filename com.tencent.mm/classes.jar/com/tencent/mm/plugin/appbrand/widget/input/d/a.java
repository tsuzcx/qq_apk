package com.tencent.mm.plugin.appbrand.widget.input.d;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ba.b;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandInputNewSmileyPanel;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/input/panel/IKeyboardPanel;", "Lcom/tencent/mm/plugin/appbrand/widget/input/panel/IKeyboardPanelSizeHelper;", "context", "Landroid/content/Context;", "keyboardAppearance", "", "(Landroid/content/Context;Z)V", "appropriateHeightInPort", "", "getAppropriateHeightInPort", "()I", "mForcePanelHeight", "mSmileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "getForcedPanelHeight", "getPanelDefaultHeightInPort", "getPanelHeightInLandscape", "getPanelView", "Landroid/view/View;", "hideContentView", "", "clearBackgroundDrawable", "isRealHeightSettled", "obtainPanelBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "onDestroy", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "setForceHeight", "height", "setForcePanelHeight", "setOnEmoticonOperationListener", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/input/panel/OnEmoticonOperateListener;", "setOnTextOperationListener", "Lcom/tencent/mm/plugin/appbrand/widget/input/panel/OnTextOperationListener;", "showContentView", "showStoreEmoticon", "show", "supportSmileyInput", "this_isInLayout", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends FrameLayout
  implements b
{
  private static final a.a uKW;
  private final ChatFooterPanel uKY;
  private int uKZ;
  
  static
  {
    AppMethodBeat.i(324625);
    uKW = new a.a((byte)0);
    AppMethodBeat.o(324625);
  }
  
  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(324616);
    this.uKX = new c();
    this.uKY = ((ChatFooterPanel)new SmileyPanelImpl(paramContext, paramBoolean));
    paramContext = this.uKY;
    paramContext.setShowSmiley(true);
    paramContext.Jy(false);
    paramContext.Jz(false);
    paramContext.setShowStore(false);
    paramContext.setShowSend(false);
    paramContext.setShowClose(false);
    paramContext.setShowSearch(true);
    paramContext.onResume();
    addView((View)this.uKY, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    setClickable(true);
    AppMethodBeat.o(324616);
  }
  
  private final Drawable cSf()
  {
    AppMethodBeat.i(324622);
    TypedArray localTypedArray = this.uKY.getContext().obtainStyledAttributes(new int[] { ba.b.emojiPanelBackground });
    s.s(localTypedArray, "mSmileyPanel.context.obt…tr.emojiPanelBackground))");
    try
    {
      Drawable localDrawable = localTypedArray.getDrawable(0);
      return localDrawable;
    }
    finally
    {
      localTypedArray.recycle();
      AppMethodBeat.o(324622);
    }
  }
  
  private final int getAppropriateHeightInPort()
  {
    AppMethodBeat.i(324619);
    if (this.uKZ > 0)
    {
      i = this.uKZ;
      AppMethodBeat.o(324619);
      return i;
    }
    int i = getPanelDefaultHeightInPort();
    AppMethodBeat.o(324619);
    return i;
  }
  
  public final boolean Ew(int paramInt)
  {
    AppMethodBeat.i(324637);
    if ((paramInt > 0) && (this.uKZ != paramInt))
    {
      this.uKZ = paramInt;
      setForceHeight(paramInt);
      AppMethodBeat.o(324637);
      return true;
    }
    AppMethodBeat.o(324637);
    return false;
  }
  
  public final void cL(boolean paramBoolean)
  {
    AppMethodBeat.i(324655);
    this.uKY.setShowStore(paramBoolean);
    AppMethodBeat.o(324655);
  }
  
  public final boolean cRp()
  {
    AppMethodBeat.i(324643);
    Log.d("MicroMsg.AppBrandInputNewSmileyPanel", "[scrollUp] isRealHeightSettled, mForcePanelHeight:" + this.uKZ + ", height:" + getHeight() + ", measuredHeight:" + getMeasuredHeight());
    if ((this.uKZ > 0) && (this.uKZ == getMeasuredHeight()))
    {
      AppMethodBeat.o(324643);
      return true;
    }
    AppMethodBeat.o(324643);
    return false;
  }
  
  public final void cSc()
  {
    AppMethodBeat.i(324649);
    this.uKY.setVisibility(0);
    setBackground(null);
    AppMethodBeat.o(324649);
  }
  
  public final boolean cSd()
  {
    AppMethodBeat.i(324654);
    boolean bool = super.isInLayout();
    AppMethodBeat.o(324654);
    return bool;
  }
  
  public final boolean cSe()
  {
    return true;
  }
  
  public final int getForcedPanelHeight()
  {
    return this.uKZ;
  }
  
  public final int getPanelDefaultHeightInPort()
  {
    AppMethodBeat.i(324628);
    c localc = this.uKX;
    if (localc.uLe < 0) {
      localc.uLe = KeyBoardUtil.getValidPanelHeight(MMApplicationContext.getContext());
    }
    if (localc.uLe > 0)
    {
      i = localc.uLe;
      AppMethodBeat.o(324628);
      return i;
    }
    int[] arrayOfInt = localc.cSk();
    int i = Math.max(arrayOfInt[0], arrayOfInt[1]) / 2 - MMApplicationContext.getContext().getResources().getDimensionPixelSize(ba.d.ChattingFootEditMinHeigh);
    localc.uLe = i;
    AppMethodBeat.o(324628);
    return i;
  }
  
  public final int getPanelHeightInLandscape()
  {
    AppMethodBeat.i(324632);
    c localc = this.uKX;
    int[] arrayOfInt = localc.cSk();
    if ((localc.uKZ > 0) && (localc.uKZ < arrayOfInt[1]))
    {
      i = localc.uKZ;
      AppMethodBeat.o(324632);
      return i;
    }
    int i = Math.min(arrayOfInt[0], arrayOfInt[1]) / 2;
    int j = MMApplicationContext.getResources().getDimensionPixelSize(ba.d.ChattingFootEditMinHeigh);
    AppMethodBeat.o(324632);
    return i - j;
  }
  
  public final View getPanelView()
  {
    return (View)this;
  }
  
  public final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(324650);
    this.uKY.setVisibility(4);
    if (paramBoolean)
    {
      setBackground(null);
      AppMethodBeat.o(324650);
      return;
    }
    setBackground(cSf());
    AppMethodBeat.o(324650);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(324653);
    removeAllViews();
    AppMethodBeat.o(324653);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324644);
    if (!isShown())
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(324644);
      return;
    }
    if (!KeyBoardUtil.isPortOrientation(getContext())) {}
    for (paramInt2 = getPanelHeightInLandscape();; paramInt2 = getAppropriateHeightInPort())
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(324644);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(324652);
    this.uKY.onPause();
    AppMethodBeat.o(324652);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(324651);
    this.uKY.onResume();
    AppMethodBeat.o(324651);
  }
  
  public final void setForceHeight(int paramInt)
  {
    this.uKX.uKZ = paramInt;
  }
  
  public final void setOnEmoticonOperationListener(e parame)
  {
    AppMethodBeat.i(324656);
    this.uKY.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)new b(parame));
    AppMethodBeat.o(324656);
  }
  
  public final void setOnTextOperationListener(f paramf)
  {
    AppMethodBeat.i(324647);
    ChatFooterPanel localChatFooterPanel = this.uKY;
    if (paramf == null) {}
    for (paramf = null;; paramf = new c(paramf))
    {
      localChatFooterPanel.setOnTextOperationListener((ChatFooterPanel.a)paramf);
      AppMethodBeat.o(324647);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandInputNewSmileyPanel$setOnEmoticonOperationListener$1", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "isCustomSmileyEnable", "", "isDirectlyReturnEmojiInfoInSimilarUI", "isHideSosSearch", "isOpenCustomSmileyEnable", "onClearEditTextView", "", "onCustomEmojiSelected", "onHidePanel", "onSearchDialogShow", "isShow", "dialogHeight", "", "onSendAppMsgCustomEmoji", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onSendCustomEmoji", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(e parame) {}
    
    public final void cSg() {}
    
    public final void cSh() {}
    
    public final boolean cSi()
    {
      return false;
    }
    
    public final boolean cSj()
    {
      return true;
    }
    
    public final void o(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(324620);
      if (paramEmojiInfo == null)
      {
        AppMethodBeat.o(324620);
        return;
      }
      Object localObject1 = (d)h.az(d.class);
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject3 = paramEmojiInfo.field_groupId;
        Object localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        Object localObject5 = new StringBuilder("onSendCustomEmoji productId:").append(paramEmojiInfo.field_groupId).append(", md5:").append(paramEmojiInfo.getMd5()).append(", desc:").append(localObject1).append(", designerId:");
        Object localObject4 = paramEmojiInfo.field_designerID;
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
        Log.i("MicroMsg.AppBrandInputNewSmileyPanel", (String)localObject3);
        localObject4 = this.uLa;
        if (localObject4 != null)
        {
          localObject5 = paramEmojiInfo.getMd5();
          localObject3 = paramEmojiInfo.field_designerID;
          paramEmojiInfo = (EmojiInfo)localObject3;
          if (localObject3 == null) {
            paramEmojiInfo = "";
          }
          ((e)localObject4).a((String)localObject5, (String)localObject2, (String)localObject1, paramEmojiInfo);
        }
        AppMethodBeat.o(324620);
        return;
        localObject1 = ((d)localObject1).getProvider();
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((com.tencent.mm.pluginsdk.b.e)localObject1).aoi(paramEmojiInfo.getMd5());
        }
      }
    }
    
    public final void y(boolean paramBoolean, int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandInputNewSmileyPanel$setOnTextOperationListener$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ChatFooterPanel.a
  {
    c(f paramf) {}
    
    public final void aWL() {}
    
    public final void aWM()
    {
      AppMethodBeat.i(324621);
      this.uLb.aWM();
      AppMethodBeat.o(324621);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(324617);
      this.uLb.append(paramString);
      AppMethodBeat.o(324617);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.a
 * JD-Core Version:    0.7.0.1
 */