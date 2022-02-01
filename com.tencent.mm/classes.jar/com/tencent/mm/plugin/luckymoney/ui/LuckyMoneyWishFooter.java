package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.k;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter
  extends BasePanelKeybordLayout
{
  private ImageButton KIF;
  MMEditText KIG;
  boolean KIH;
  public boolean KII;
  private boolean KIJ;
  boolean KIK;
  private TextWatcher KIL;
  private a KIM;
  private c KIN;
  private MMActivity lzt;
  private Button mkz;
  ChatFooterPanel moD;
  private int state;
  
  public LuckyMoneyWishFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65951);
    this.state = 0;
    this.KIH = false;
    this.KII = false;
    this.KIJ = true;
    this.KIK = true;
    this.KIL = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(65945);
        if (LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getText() == null)
        {
          AppMethodBeat.o(65945);
          return;
        }
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).requestFocus();
        if ((paramAnonymousEditable.length() > 0) && (paramAnonymousEditable.toString().trim().length() > 0)) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (LuckyMoneyWishFooter.this.KIK))
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, true);
            LuckyMoneyWishFooter.this.KIK = false;
          }
          if (i == 0)
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, false);
            LuckyMoneyWishFooter.this.KIK = true;
          }
          AppMethodBeat.o(65945);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.lzt = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.lzt, a.g.lucky_money_wish_footer, this);
    this.mkz = ((Button)paramContext.findViewById(a.f.lucky_money_wish_send_btn));
    yk(false);
    this.KIF = ((ImageButton)paramContext.findViewById(a.f.lucky_money_wish_mode_iv));
    this.KIF.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(284272);
        Log.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.c(LuckyMoneyWishFooter.this));
        if (LuckyMoneyWishFooter.c(LuckyMoneyWishFooter.this) == 0)
        {
          LuckyMoneyWishFooter.this.setModeClick(true);
          LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(a.h.icons_outlined_emoji);
          LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 1);
          LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
        }
        for (;;)
        {
          LuckyMoneyWishFooter.f(LuckyMoneyWishFooter.this);
          AppMethodBeat.o(284272);
          return;
          LuckyMoneyWishFooter.this.setModeClick(false);
          LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
          LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(a.h.icons_outlined_emoji);
          LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 0);
        }
      }
    });
    this.KIG = ((MMEditText)paramContext.findViewById(a.f.lucky_money_wish_content_et));
    this.KIG.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65947);
        LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(8);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).onPause();
        LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(a.h.icons_outlined_emoji);
        if (LuckyMoneyWishFooter.g(LuckyMoneyWishFooter.this) != null) {
          LuckyMoneyWishFooter.g(LuckyMoneyWishFooter.this);
        }
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 0);
        AppMethodBeat.o(65947);
        return false;
      }
    });
    if (e.Ykf == null)
    {
      this.moD = new d(this.lzt);
      AppMethodBeat.o(65951);
      return;
    }
    this.moD = e.Ykf.fZ(getContext());
    this.moD.setEntranceScene(ChatFooterPanel.XYl);
    this.moD.setVisibility(8);
    ((LinearLayout)findViewById(a.f.root)).addView(this.moD, -1, 0);
    this.moD.iKh();
    this.moD.onResume();
    this.moD.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aWL() {}
      
      public final void aWM()
      {
        AppMethodBeat.i(65948);
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(65948);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(65949);
        try
        {
          LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).bDt(paramAnonymousString);
          AppMethodBeat.o(65949);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(65949);
        }
      }
      
      public final void fp(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(65951);
  }
  
  private void fYX()
  {
    AppMethodBeat.i(65953);
    if (this.state == 0)
    {
      this.KIG.requestFocus();
      this.lzt.getWindow().setSoftInputMode(16);
      this.lzt.showVKB();
      this.moD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(65943);
          LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(4);
          AppMethodBeat.o(65943);
        }
      }, 200L);
      AppMethodBeat.o(65953);
      return;
    }
    this.KIG.requestFocus();
    this.lzt.getWindow().setSoftInputMode(32);
    this.lzt.hideVKB();
    fYY();
    AppMethodBeat.o(65953);
  }
  
  private void fYY()
  {
    AppMethodBeat.i(65954);
    this.moD.onResume();
    this.moD.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65944);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(0);
        AppMethodBeat.o(65944);
      }
    }, 200L);
    ViewGroup.LayoutParams localLayoutParams = this.moD.getLayoutParams();
    if (((localLayoutParams != null) && (localLayoutParams.height <= 0)) || ((localLayoutParams != null) && (j.isPortOrientation(getContext())) && (this.KIJ)))
    {
      localLayoutParams.height = j.getValidPanelHeight(getContext());
      this.moD.setLayoutParams(localLayoutParams);
      this.KIJ = false;
    }
    AppMethodBeat.o(65954);
  }
  
  private void yk(boolean paramBoolean)
  {
    AppMethodBeat.i(65962);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), a.a.pop_in);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), a.a.pop_out);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if (this.mkz == null)
    {
      AppMethodBeat.o(65962);
      return;
    }
    if (paramBoolean)
    {
      if ((this.mkz.getVisibility() == 8) || (this.mkz.getVisibility() == 4))
      {
        AppMethodBeat.o(65962);
        return;
      }
      this.mkz.startAnimation(localAnimation2);
      this.mkz.setVisibility(8);
      AppMethodBeat.o(65962);
      return;
    }
    if ((this.mkz.getVisibility() == 0) || (this.mkz.getVisibility() == 0))
    {
      AppMethodBeat.o(65962);
      return;
    }
    this.mkz.startAnimation(localAnimation1);
    this.mkz.setVisibility(0);
    AppMethodBeat.o(65962);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(65963);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.moD);
    AppMethodBeat.o(65963);
    return localArrayList;
  }
  
  public final void onKeyBoardStateChange(int paramInt)
  {
    AppMethodBeat.i(65960);
    super.onKeyBoardStateChange(paramInt);
    switch (paramInt)
    {
    default: 
      this.KII = false;
      AppMethodBeat.o(65960);
      return;
    }
    this.KII = true;
    AppMethodBeat.o(65960);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65958);
    this.KIG.setHint(paramString);
    AppMethodBeat.o(65958);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(65955);
    this.KIG.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65955);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.KIH = paramBoolean;
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.KIM = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.KIN = paramc;
  }
  
  public void setOnWishSendImp(final b paramb)
  {
    AppMethodBeat.i(65959);
    this.mkz.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(284297);
        paramb.aKJ(LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getText().toString());
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).setText("");
        AppMethodBeat.o(284297);
      }
    });
    AppMethodBeat.o(65959);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(65957);
    if (this.KIG != null)
    {
      this.KIG.setText("");
      this.KIG.bDt(paramString);
    }
    AppMethodBeat.o(65957);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(65952);
    this.state = 0;
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      if (this.moD != null)
      {
        Log.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(bool)));
        if (bool) {
          break label118;
        }
        Log.d("MicroMsg.SnsCommentFooter", Util.getStack());
        this.moD.setVisibility(8);
        this.KIF.setImageResource(a.h.icons_outlined_emoji);
        this.lzt.hideVKB();
        setModeClick(true);
        requestLayout();
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      AppMethodBeat.o(65952);
      return;
      bool = false;
      break;
      label118:
      fYX();
      this.KIJ = false;
    }
  }
  
  static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void aKJ(String paramString);
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter
 * JD-Core Version:    0.7.0.1
 */