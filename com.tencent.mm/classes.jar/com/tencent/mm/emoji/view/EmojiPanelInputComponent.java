package com.tencent.mm.emoji.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
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
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;

public class EmojiPanelInputComponent
  extends InputPanelLinearLayout
{
  private static final int moC;
  private Context context;
  private ChatFooterPanel moD;
  private com.tencent.mm.ui.widget.cedit.api.c moE;
  private ImageButton moF;
  private int moG;
  private int moH;
  private int moI;
  private boolean moJ;
  private a moK;
  
  static
  {
    AppMethodBeat.i(242519);
    moC = a.fromDPToPix(MMApplicationContext.getContext(), 50);
    AppMethodBeat.o(242519);
  }
  
  public EmojiPanelInputComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(242494);
    this.moE = null;
    this.moG = -1;
    this.moH = -1;
    this.moI = 0;
    this.moJ = true;
    this.context = paramContext;
    af.mU(this.context).inflate(a.h.emoji_panel_input_component, this);
    if (e.Ykf == null)
    {
      this.moD = new d(this.context);
      AppMethodBeat.o(242494);
      return;
    }
    this.moF = ((ImageButton)findViewById(a.g.mode_iv));
    this.moF.setOnClickListener(new EmojiPanelInputComponent.2(this));
    this.moD = e.Ykf.fZ(getContext());
    this.moD.setEntranceScene(ChatFooterPanel.XYl);
    this.moD.setVisibility(4);
    paramContext = (LinearLayout)findViewById(a.g.root);
    paramContext.setOnClickListener(null);
    this.moI = KeyBoardUtil.getValidPanelHeight(getContext());
    paramContext.addView(this.moD, -1, this.moI);
    this.moD.iKh();
    aWK();
    this.moD.onResume();
    this.moD.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aWL() {}
      
      public final void aWM()
      {
        AppMethodBeat.i(242514);
        EmojiPanelInputComponent.b(EmojiPanelInputComponent.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        EmojiPanelInputComponent.b(EmojiPanelInputComponent.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(242514);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(242517);
        try
        {
          EmojiPanelInputComponent.b(EmojiPanelInputComponent.this).bDt(paramAnonymousString);
          AppMethodBeat.o(242517);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.EmojiPanelInputComponent", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(242517);
        }
      }
      
      public final void fp(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(242494);
  }
  
  private void aWJ()
  {
    AppMethodBeat.i(242497);
    this.moD.onPause();
    if (KeyBoardUtil.isPortOrientation(getContext()))
    {
      getInputPanelHelper().be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(242492);
          EmojiPanelInputComponent.c(EmojiPanelInputComponent.this).setVisibility(4);
          AppMethodBeat.o(242492);
        }
      });
      AppMethodBeat.o(242497);
      return;
    }
    this.moD.setVisibility(4);
    AppMethodBeat.o(242497);
  }
  
  private void aWK()
  {
    AppMethodBeat.i(242507);
    setBottomPanelHeight(this.moI);
    AppMethodBeat.o(242507);
  }
  
  private void setBottomPanelHeight(int paramInt)
  {
    AppMethodBeat.i(242510);
    Log.i("MicroMsg.EmojiPanelInputComponent", "setBottomPanelHeight: %s", new Object[] { Integer.valueOf(paramInt) });
    ViewGroup.LayoutParams localLayoutParams = this.moD.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != paramInt))
    {
      localLayoutParams.height = paramInt;
      this.moD.requestLayout();
    }
    AppMethodBeat.o(242510);
  }
  
  public final void aWF()
  {
    AppMethodBeat.i(242521);
    setVisibility(0);
    this.moF.setImageResource(a.f.chatting_setmode_biaoqing_btn);
    this.moF.setTag("keyboard");
    AppMethodBeat.o(242521);
  }
  
  public final boolean aWG()
  {
    AppMethodBeat.i(242524);
    if ((aWH()) || (getVisibility() == 0))
    {
      AppMethodBeat.o(242524);
      return true;
    }
    AppMethodBeat.o(242524);
    return false;
  }
  
  public final boolean aWH()
  {
    AppMethodBeat.i(242525);
    if (this.moD.getVisibility() == 0)
    {
      AppMethodBeat.o(242525);
      return true;
    }
    AppMethodBeat.o(242525);
    return false;
  }
  
  public final void aWI()
  {
    AppMethodBeat.i(242526);
    aWJ();
    setVisibility(8);
    AppMethodBeat.o(242526);
  }
  
  public ChatFooterPanel getSmileyPanel()
  {
    return this.moD;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(242527);
    super.onConfigurationChanged(paramConfiguration);
    if (this.moD != null) {
      aWK();
    }
    AppMethodBeat.o(242527);
  }
  
  public void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(242530);
    Log.i("MicroMsg.EmojiPanelInputComponent", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.onInputPanelChange(paramBoolean, paramInt);
    if ((this.moI != paramInt) && (paramInt != 0))
    {
      this.moI = paramInt;
      setBottomPanelHeight(paramInt);
    }
    a locala;
    if (paramBoolean)
    {
      aWF();
      if (this.moK != null)
      {
        locala = this.moK;
        if (getVisibility() != 0) {
          break label148;
        }
      }
    }
    label148:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.onInputPanelChange(paramBoolean, moC + paramInt);
      AppMethodBeat.o(242530);
      return;
      if ("emoji".equals(this.moF.getTag()))
      {
        this.moF.setImageResource(a.f.chatting_setmode_keyboard_btn);
        break;
      }
      setVisibility(4);
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(242533);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.moG < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.moG)
    {
      this.moG = paramInt1;
      this.moH = paramInt4;
      AppMethodBeat.o(242533);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(242532);
    this.moK = null;
    if (this.moD != null)
    {
      this.moD.iKg();
      this.moD.destroy();
    }
    AppMethodBeat.o(242532);
  }
  
  public void setInputComponentListener(a parama)
  {
    this.moK = parama;
  }
  
  public void setMMEditText(com.tencent.mm.ui.widget.cedit.api.c paramc)
  {
    AppMethodBeat.i(242523);
    this.moE = paramc;
    paramc.a(new com.tencent.mm.ui.widget.cedit.api.c.a()
    {
      public final boolean rR(int paramAnonymousInt)
      {
        return false;
      }
    });
    AppMethodBeat.o(242523);
  }
  
  public void setSmileySendButtonEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(242529);
    if (this.moD != null) {
      this.moD.setSendButtonEnable(paramBoolean);
    }
    AppMethodBeat.o(242529);
  }
  
  public static abstract interface a
    extends com.tencent.mm.ui.widget.c.a
  {
    public abstract void hideVKB();
    
    public abstract void showVKB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.view.EmojiPanelInputComponent
 * JD-Core Version:    0.7.0.1
 */