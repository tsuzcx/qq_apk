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
import android.view.View.OnClickListener;
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
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
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
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter
  extends BasePanelKeybordLayout
{
  private MMActivity gte;
  private Button han;
  ChatFooterPanel rum;
  private int state;
  private ImageButton ziQ;
  MMEditText ziR;
  boolean ziS;
  public boolean ziT;
  private boolean ziU;
  boolean ziV;
  private TextWatcher ziW;
  private a ziX;
  private c ziY;
  
  public LuckyMoneyWishFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65951);
    this.state = 0;
    this.ziS = false;
    this.ziT = false;
    this.ziU = true;
    this.ziV = true;
    this.ziW = new TextWatcher()
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
          if ((i != 0) && (LuckyMoneyWishFooter.this.ziV))
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, true);
            LuckyMoneyWishFooter.this.ziV = false;
          }
          if (i == 0)
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, false);
            LuckyMoneyWishFooter.this.ziV = true;
          }
          AppMethodBeat.o(65945);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.gte = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.gte, 2131495387, this);
    this.han = ((Button)paramContext.findViewById(2131304286));
    qT(false);
    this.ziQ = ((ImageButton)paramContext.findViewById(2131304285));
    this.ziQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65946);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.c(LuckyMoneyWishFooter.this));
        if (LuckyMoneyWishFooter.c(LuckyMoneyWishFooter.this) == 0)
        {
          LuckyMoneyWishFooter.this.setModeClick(true);
          LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(2131690793);
          LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 1);
          LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
        }
        for (;;)
        {
          LuckyMoneyWishFooter.f(LuckyMoneyWishFooter.this);
          a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65946);
          return;
          LuckyMoneyWishFooter.this.setModeClick(false);
          LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
          LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(2131690793);
          LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 0);
        }
      }
    });
    this.ziR = ((MMEditText)paramContext.findViewById(2131304283));
    this.ziR.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65947);
        LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(8);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).onPause();
        LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(2131690793);
        if (LuckyMoneyWishFooter.g(LuckyMoneyWishFooter.this) != null) {
          LuckyMoneyWishFooter.g(LuckyMoneyWishFooter.this);
        }
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 0);
        AppMethodBeat.o(65947);
        return false;
      }
    });
    if (e.Knc == null)
    {
      this.rum = new d(this.gte);
      AppMethodBeat.o(65951);
      return;
    }
    this.rum = e.Knc.eZ(getContext());
    this.rum.setEntranceScene(ChatFooterPanel.KbB);
    this.rum.setVisibility(8);
    ((LinearLayout)findViewById(2131307157)).addView(this.rum, -1, 0);
    this.rum.goD();
    this.rum.onResume();
    this.rum.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aHC()
      {
        AppMethodBeat.i(65948);
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(65948);
      }
      
      public final void aHD() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(65949);
        try
        {
          LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).bol(paramAnonymousString);
          AppMethodBeat.o(65949);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(65949);
        }
      }
      
      public final void eP(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(65951);
  }
  
  private void cbL()
  {
    AppMethodBeat.i(65954);
    this.rum.onResume();
    this.rum.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65944);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(0);
        AppMethodBeat.o(65944);
      }
    }, 200L);
    ViewGroup.LayoutParams localLayoutParams = this.rum.getLayoutParams();
    if (((localLayoutParams != null) && (localLayoutParams.height <= 0)) || ((localLayoutParams != null) && (i.isPortOrientation(getContext())) && (this.ziU)))
    {
      localLayoutParams.height = i.getValidPanelHeight(getContext());
      this.rum.setLayoutParams(localLayoutParams);
      this.ziU = false;
    }
    AppMethodBeat.o(65954);
  }
  
  private void egH()
  {
    AppMethodBeat.i(65953);
    if (this.state == 0)
    {
      this.ziR.requestFocus();
      this.gte.getWindow().setSoftInputMode(16);
      this.gte.showVKB();
      this.rum.postDelayed(new Runnable()
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
    this.ziR.requestFocus();
    this.gte.getWindow().setSoftInputMode(32);
    this.gte.hideVKB();
    cbL();
    AppMethodBeat.o(65953);
  }
  
  private void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(65962);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772119);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772124);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if (this.han == null)
    {
      AppMethodBeat.o(65962);
      return;
    }
    if (paramBoolean)
    {
      if ((this.han.getVisibility() == 8) || (this.han.getVisibility() == 4))
      {
        AppMethodBeat.o(65962);
        return;
      }
      this.han.startAnimation(localAnimation2);
      this.han.setVisibility(8);
      AppMethodBeat.o(65962);
      return;
    }
    if ((this.han.getVisibility() == 0) || (this.han.getVisibility() == 0))
    {
      AppMethodBeat.o(65962);
      return;
    }
    this.han.startAnimation(localAnimation1);
    this.han.setVisibility(0);
    AppMethodBeat.o(65962);
  }
  
  public final void Ns(int paramInt)
  {
    AppMethodBeat.i(65960);
    super.Ns(paramInt);
    switch (paramInt)
    {
    default: 
      this.ziT = false;
      AppMethodBeat.o(65960);
      return;
    }
    this.ziT = true;
    AppMethodBeat.o(65960);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(65963);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.rum);
    AppMethodBeat.o(65963);
    return localArrayList;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65958);
    this.ziR.setHint(paramString);
    AppMethodBeat.o(65958);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(65955);
    this.ziR.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65955);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.ziS = paramBoolean;
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.ziX = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.ziY = paramc;
  }
  
  public void setOnWishSendImp(final b paramb)
  {
    AppMethodBeat.i(65959);
    this.han.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65950);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramb.aDC(LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getText().toString());
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).setText("");
        a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65950);
      }
    });
    AppMethodBeat.o(65959);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(65957);
    if (this.ziR != null)
    {
      this.ziR.setText("");
      this.ziR.bol(paramString);
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
      if (this.rum != null)
      {
        Log.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(bool)));
        if (bool) {
          break label118;
        }
        Log.d("MicroMsg.SnsCommentFooter", Util.getStack());
        this.rum.setVisibility(8);
        this.ziQ.setImageResource(2131690793);
        this.gte.hideVKB();
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
      egH();
      this.ziU = false;
    }
  }
  
  static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void aDC(String paramString);
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter
 * JD-Core Version:    0.7.0.1
 */