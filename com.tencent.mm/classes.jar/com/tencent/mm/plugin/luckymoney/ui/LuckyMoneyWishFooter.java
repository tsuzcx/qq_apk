package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter
  extends BasePanelKeybordLayout
{
  private MMActivity bER;
  private ChatFooterPanel jpC;
  private ImageButton kEW;
  private MMEditText lXN;
  private Button lXO;
  boolean lXP = false;
  public boolean lXQ = false;
  private boolean lXR = true;
  boolean lXS = true;
  private TextWatcher lXT = new LuckyMoneyWishFooter.1(this);
  private LuckyMoneyWishFooter.a lXU;
  private LuckyMoneyWishFooter.c lXV;
  private int state = 0;
  
  public LuckyMoneyWishFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.bER, a.g.lucky_money_wish_footer, this);
    this.lXO = ((Button)paramContext.findViewById(a.f.lucky_money_wish_send_btn));
    ho(false);
    this.kEW = ((ImageButton)paramContext.findViewById(a.f.lucky_money_wish_mode_iv));
    this.kEW.setOnClickListener(new LuckyMoneyWishFooter.2(this));
    this.lXN = ((MMEditText)paramContext.findViewById(a.f.lucky_money_wish_content_et));
    this.lXN.setOnTouchListener(new LuckyMoneyWishFooter.3(this));
    if (e.sgr == null)
    {
      this.jpC = new d(this.bER);
      return;
    }
    this.jpC = e.sgr.cX(getContext());
    this.jpC.setEntranceScene(ChatFooterPanel.rZu);
    this.jpC.setVisibility(8);
    this.jpC.setBackgroundResource(a.e.bottombar_bg);
    ((LinearLayout)findViewById(a.f.root)).addView(this.jpC, -1, 0);
    this.jpC.sk();
    this.jpC.aN(false);
    this.jpC.setOnTextOperationListener(new LuckyMoneyWishFooter.4(this));
  }
  
  private void ash()
  {
    this.jpC.onResume();
    this.jpC.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.jpC.getLayoutParams();
    if (((localLayoutParams != null) && (localLayoutParams.height <= 0)) || ((localLayoutParams != null) && (j.fA(getContext())) && (this.lXR)))
    {
      localLayoutParams.height = j.fy(getContext());
      this.jpC.setLayoutParams(localLayoutParams);
      this.lXR = false;
    }
  }
  
  private void ho(boolean paramBoolean)
  {
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), a.a.pop_in);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), a.a.pop_out);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if (this.lXO == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.lXO.getVisibility() == 8) || (this.lXO.getVisibility() == 4));
      this.lXO.startAnimation(localAnimation2);
      this.lXO.setVisibility(8);
      return;
    } while ((this.lXO.getVisibility() == 0) || (this.lXO.getVisibility() == 0));
    this.lXO.startAnimation(localAnimation1);
    this.lXO.setVisibility(0);
  }
  
  public final boolean a(MMEditText.a parama)
  {
    if (this.lXN != null)
    {
      this.lXN.setBackListener(parama);
      return true;
    }
    return false;
  }
  
  public final void bgu()
  {
    if (this.jpC != null)
    {
      y.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.jpC.sj();
      this.jpC.destroy();
    }
  }
  
  protected List<View> getPanelView()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jpC);
    return localArrayList;
  }
  
  protected final void rD(int paramInt)
  {
    super.rD(paramInt);
    switch (paramInt)
    {
    default: 
      this.lXQ = false;
      return;
    }
    this.lXQ = true;
  }
  
  public void setHint(String paramString)
  {
    this.lXN.setHint(paramString);
  }
  
  public void setMaxLength(int paramInt)
  {
    this.lXN.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.lXP = paramBoolean;
  }
  
  public void setOnEditTouchListener(LuckyMoneyWishFooter.a parama)
  {
    this.lXU = parama;
  }
  
  public void setOnSmileyShowListener(LuckyMoneyWishFooter.c paramc)
  {
    this.lXV = paramc;
  }
  
  public void setOnWishSendImp(LuckyMoneyWishFooter.b paramb)
  {
    this.lXO.setOnClickListener(new LuckyMoneyWishFooter.5(this, paramb));
  }
  
  public void setText(String paramString)
  {
    if (this.lXN != null)
    {
      this.lXN.setText("");
      this.lXN.aex(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    this.state = 0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.jpC != null)
      {
        y.i("MicroMsg.SnsCommentFooter", "showState " + bool);
        if (bool) {
          break;
        }
        this.jpC.setVisibility(8);
        this.kEW.setImageResource(a.h.textfield_icon_emoji_normal);
        this.bER.XM();
        requestLayout();
      }
      super.setVisibility(paramInt);
      return;
    }
    if (this.state == 0)
    {
      this.bER.showVKB();
      this.lXN.requestFocus();
      this.jpC.setVisibility(8);
    }
    for (;;)
    {
      this.lXR = false;
      break;
      this.bER.XM();
      this.lXN.requestFocus();
      ash();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter
 * JD-Core Version:    0.7.0.1
 */