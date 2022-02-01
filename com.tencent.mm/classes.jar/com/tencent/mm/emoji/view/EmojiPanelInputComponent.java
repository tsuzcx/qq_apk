package com.tencent.mm.emoji.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;

public class EmojiPanelInputComponent
  extends InputPanelLinearLayout
{
  private static final int jPM;
  private Context context;
  private ChatFooterPanel jPN;
  private com.tencent.mm.ui.widget.cedit.api.c jPO;
  private ImageButton jPP;
  private int jPQ;
  private int jPR;
  private int jPS;
  private boolean jPT;
  private a jPU;
  
  static
  {
    AppMethodBeat.i(233390);
    jPM = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50);
    AppMethodBeat.o(233390);
  }
  
  public EmojiPanelInputComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(233343);
    this.jPO = null;
    this.jPQ = -1;
    this.jPR = -1;
    this.jPS = 0;
    this.jPT = true;
    this.context = paramContext;
    ad.kS(this.context).inflate(a.h.emoji_panel_input_component, this);
    if (e.RnO == null)
    {
      this.jPN = new d(this.context);
      AppMethodBeat.o(233343);
      return;
    }
    this.jPP = ((ImageButton)findViewById(a.g.mode_iv));
    this.jPP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232302);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/view/EmojiPanelInputComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        EmojiPanelInputComponent.a(EmojiPanelInputComponent.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/view/EmojiPanelInputComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232302);
      }
    });
    this.jPN = e.RnO.fd(getContext());
    this.jPN.setEntranceScene(ChatFooterPanel.Rcg);
    this.jPN.setVisibility(4);
    paramContext = (LinearLayout)findViewById(a.g.root);
    paramContext.setOnClickListener(null);
    this.jPS = KeyBoardUtil.getValidPanelHeight(getContext());
    paramContext.addView(this.jPN, -1, this.jPS);
    this.jPN.hjp();
    aDM();
    this.jPN.onResume();
    this.jPN.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aDN() {}
      
      public final void aDO()
      {
        AppMethodBeat.i(228997);
        EmojiPanelInputComponent.b(EmojiPanelInputComponent.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        EmojiPanelInputComponent.b(EmojiPanelInputComponent.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(228997);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(229000);
        try
        {
          EmojiPanelInputComponent.b(EmojiPanelInputComponent.this).bBa(paramAnonymousString);
          AppMethodBeat.o(229000);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.EmojiPanelInputComponent", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(229000);
        }
      }
      
      public final void eE(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(233343);
  }
  
  private void aDL()
  {
    AppMethodBeat.i(233365);
    this.jPN.onPause();
    if (KeyBoardUtil.isPortOrientation(getContext()))
    {
      getInputPanelHelper().aW(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230688);
          EmojiPanelInputComponent.c(EmojiPanelInputComponent.this).setVisibility(4);
          AppMethodBeat.o(230688);
        }
      });
      AppMethodBeat.o(233365);
      return;
    }
    this.jPN.setVisibility(4);
    AppMethodBeat.o(233365);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(233369);
    setBottomPanelHeight(this.jPS);
    AppMethodBeat.o(233369);
  }
  
  private void setBottomPanelHeight(int paramInt)
  {
    AppMethodBeat.i(233373);
    Log.i("MicroMsg.EmojiPanelInputComponent", "setBottomPanelHeight: %s", new Object[] { Integer.valueOf(paramInt) });
    ViewGroup.LayoutParams localLayoutParams = this.jPN.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != paramInt))
    {
      localLayoutParams.height = paramInt;
      this.jPN.requestLayout();
    }
    AppMethodBeat.o(233373);
  }
  
  public final void aDG()
  {
    AppMethodBeat.i(233345);
    setVisibility(0);
    this.jPP.setImageResource(a.f.chatting_setmode_biaoqing_btn);
    this.jPP.setTag("keyboard");
    AppMethodBeat.o(233345);
  }
  
  public final void aDH()
  {
    AppMethodBeat.i(233347);
    setVisibility(4);
    AppMethodBeat.o(233347);
  }
  
  public final boolean aDI()
  {
    AppMethodBeat.i(233352);
    if ((aDJ()) || (getVisibility() == 0))
    {
      AppMethodBeat.o(233352);
      return true;
    }
    AppMethodBeat.o(233352);
    return false;
  }
  
  public final boolean aDJ()
  {
    AppMethodBeat.i(233355);
    if (this.jPN.getVisibility() == 0)
    {
      AppMethodBeat.o(233355);
      return true;
    }
    AppMethodBeat.o(233355);
    return false;
  }
  
  public final void aDK()
  {
    AppMethodBeat.i(233358);
    aDL();
    setVisibility(8);
    AppMethodBeat.o(233358);
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(233367);
    Log.i("MicroMsg.EmojiPanelInputComponent", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.h(paramBoolean, paramInt);
    if ((this.jPS != paramInt) && (paramInt != 0))
    {
      this.jPS = paramInt;
      setBottomPanelHeight(paramInt);
    }
    a locala;
    if (paramBoolean)
    {
      aDG();
      if (this.jPU != null)
      {
        locala = this.jPU;
        if (getVisibility() != 0) {
          break label148;
        }
      }
    }
    label148:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.h(paramBoolean, jPM + paramInt);
      AppMethodBeat.o(233367);
      return;
      if ("emoji".equals(this.jPP.getTag()))
      {
        this.jPP.setImageResource(a.f.chatting_setmode_keyboard_btn);
        break;
      }
      setVisibility(4);
      break;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(233362);
    super.onConfigurationChanged(paramConfiguration);
    if (this.jPN != null) {
      aDM();
    }
    AppMethodBeat.o(233362);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(233379);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jPQ < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.jPQ)
    {
      this.jPQ = paramInt1;
      this.jPR = paramInt4;
      AppMethodBeat.o(233379);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(233375);
    this.jPU = null;
    if (this.jPN != null)
    {
      this.jPN.hjm();
      this.jPN.destroy();
    }
    AppMethodBeat.o(233375);
  }
  
  public void setInputComponentListener(a parama)
  {
    this.jPU = parama;
  }
  
  public void setMMEditText(com.tencent.mm.ui.widget.cedit.api.c paramc)
  {
    AppMethodBeat.i(233349);
    this.jPO = paramc;
    paramc.a(new com.tencent.mm.ui.widget.cedit.api.c.a()
    {
      public final boolean rQ(int paramAnonymousInt)
      {
        return false;
      }
    });
    AppMethodBeat.o(233349);
  }
  
  public void setSmileySendButtonEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(233363);
    if (this.jPN != null) {
      this.jPN.setSendButtonEnable(paramBoolean);
    }
    AppMethodBeat.o(233363);
  }
  
  public static abstract interface a
    extends com.tencent.mm.ui.widget.c.a
  {
    public abstract void hideVKB();
    
    public abstract void showVKB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.EmojiPanelInputComponent
 * JD-Core Version:    0.7.0.1
 */