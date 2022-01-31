package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter
  extends BasePanelKeybordLayout
{
  private MMActivity cmc;
  private ChatFooterPanel eys;
  private ImageButton kjv;
  private MMEditText oxm;
  private Button oxn;
  boolean oxo;
  public boolean oxp;
  private boolean oxq;
  boolean oxr;
  private TextWatcher oxs;
  private LuckyMoneyWishFooter.a oxt;
  private LuckyMoneyWishFooter.c oxu;
  private int state;
  
  public LuckyMoneyWishFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(43055);
    this.state = 0;
    this.oxo = false;
    this.oxp = false;
    this.oxq = true;
    this.oxr = true;
    this.oxs = new LuckyMoneyWishFooter.3(this);
    this.cmc = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.cmc, 2130970048, this);
    this.oxn = ((Button)paramContext.findViewById(2131825840));
    jf(false);
    this.kjv = ((ImageButton)paramContext.findViewById(2131825839));
    this.kjv.setOnClickListener(new LuckyMoneyWishFooter.4(this));
    this.oxm = ((MMEditText)paramContext.findViewById(2131825838));
    this.oxm.setOnTouchListener(new LuckyMoneyWishFooter.5(this));
    if (e.vYI == null)
    {
      this.eys = new d(this.cmc);
      AppMethodBeat.o(43055);
      return;
    }
    this.eys = e.vYI.dK(getContext());
    this.eys.setEntranceScene(ChatFooterPanel.vQl);
    this.eys.setVisibility(8);
    this.eys.setBackgroundResource(2130838022);
    ((LinearLayout)findViewById(2131821003)).addView(this.eys, -1, 0);
    this.eys.Az();
    this.eys.bo(false);
    this.eys.onResume();
    this.eys.setOnTextOperationListener(new LuckyMoneyWishFooter.6(this));
    AppMethodBeat.o(43055);
  }
  
  private void aRl()
  {
    AppMethodBeat.i(43058);
    this.eys.onResume();
    this.eys.postDelayed(new LuckyMoneyWishFooter.2(this), 200L);
    ViewGroup.LayoutParams localLayoutParams = this.eys.getLayoutParams();
    if (((localLayoutParams != null) && (localLayoutParams.height <= 0)) || ((localLayoutParams != null) && (j.gN(getContext())) && (this.oxq)))
    {
      localLayoutParams.height = j.gL(getContext());
      this.eys.setLayoutParams(localLayoutParams);
      this.oxq = false;
    }
    AppMethodBeat.o(43058);
  }
  
  private void bOn()
  {
    AppMethodBeat.i(43057);
    if (this.state == 0)
    {
      this.oxm.requestFocus();
      this.cmc.getWindow().setSoftInputMode(16);
      this.cmc.showVKB();
      this.eys.postDelayed(new LuckyMoneyWishFooter.1(this), 200L);
      AppMethodBeat.o(43057);
      return;
    }
    this.oxm.requestFocus();
    this.cmc.getWindow().setSoftInputMode(32);
    this.cmc.hideVKB();
    aRl();
    AppMethodBeat.o(43057);
  }
  
  private void jf(boolean paramBoolean)
  {
    AppMethodBeat.i(43066);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2131034217);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2131034222);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if (this.oxn == null)
    {
      AppMethodBeat.o(43066);
      return;
    }
    if (paramBoolean)
    {
      if ((this.oxn.getVisibility() == 8) || (this.oxn.getVisibility() == 4))
      {
        AppMethodBeat.o(43066);
        return;
      }
      this.oxn.startAnimation(localAnimation2);
      this.oxn.setVisibility(8);
      AppMethodBeat.o(43066);
      return;
    }
    if ((this.oxn.getVisibility() == 0) || (this.oxn.getVisibility() == 0))
    {
      AppMethodBeat.o(43066);
      return;
    }
    this.oxn.startAnimation(localAnimation1);
    this.oxn.setVisibility(0);
    AppMethodBeat.o(43066);
  }
  
  public final boolean a(MMEditText.a parama)
  {
    AppMethodBeat.i(43060);
    if (this.oxm != null)
    {
      this.oxm.setBackListener(parama);
      AppMethodBeat.o(43060);
      return true;
    }
    AppMethodBeat.o(43060);
    return false;
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(43065);
    if (this.eys != null)
    {
      ab.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.eys.Ay();
      this.eys.destroy();
    }
    AppMethodBeat.o(43065);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(43067);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.eys);
    AppMethodBeat.o(43067);
    return localArrayList;
  }
  
  public final void sJ(int paramInt)
  {
    AppMethodBeat.i(43064);
    super.sJ(paramInt);
    switch (paramInt)
    {
    default: 
      this.oxp = false;
      AppMethodBeat.o(43064);
      return;
    }
    this.oxp = true;
    AppMethodBeat.o(43064);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(43062);
    this.oxm.setHint(paramString);
    AppMethodBeat.o(43062);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(43059);
    this.oxm.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(43059);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.oxo = paramBoolean;
  }
  
  public void setOnEditTouchListener(LuckyMoneyWishFooter.a parama)
  {
    this.oxt = parama;
  }
  
  public void setOnSmileyShowListener(LuckyMoneyWishFooter.c paramc)
  {
    this.oxu = paramc;
  }
  
  public void setOnWishSendImp(LuckyMoneyWishFooter.b paramb)
  {
    AppMethodBeat.i(43063);
    this.oxn.setOnClickListener(new LuckyMoneyWishFooter.7(this, paramb));
    AppMethodBeat.o(43063);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(43061);
    if (this.oxm != null)
    {
      this.oxm.setText("");
      this.oxm.avk(paramString);
    }
    AppMethodBeat.o(43061);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(43056);
    this.state = 0;
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      if (this.eys != null)
      {
        ab.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(bool)));
        if (bool) {
          break label118;
        }
        ab.d("MicroMsg.SnsCommentFooter", bo.dtY());
        this.eys.setVisibility(8);
        this.kjv.setImageResource(2131231506);
        this.cmc.hideVKB();
        setModeClick(true);
        requestLayout();
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      AppMethodBeat.o(43056);
      return;
      bool = false;
      break;
      label118:
      bOn();
      this.oxq = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter
 * JD-Core Version:    0.7.0.1
 */