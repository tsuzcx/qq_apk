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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter
  extends BasePanelKeybordLayout
{
  private MMActivity fLP;
  private Button gmY;
  ChatFooterPanel pWJ;
  private int state;
  private ImageButton vBo;
  MMEditText vBp;
  boolean vBq;
  public boolean vBr;
  private boolean vBs;
  boolean vBt;
  private TextWatcher vBu;
  private a vBv;
  private c vBw;
  
  public LuckyMoneyWishFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65951);
    this.state = 0;
    this.vBq = false;
    this.vBr = false;
    this.vBs = true;
    this.vBt = true;
    this.vBu = new TextWatcher()
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
          if ((i != 0) && (LuckyMoneyWishFooter.this.vBt))
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, true);
            LuckyMoneyWishFooter.this.vBt = false;
          }
          if (i == 0)
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, false);
            LuckyMoneyWishFooter.this.vBt = true;
          }
          AppMethodBeat.o(65945);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.fLP = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.fLP, 2131494662, this);
    this.gmY = ((Button)paramContext.findViewById(2131301961));
    og(false);
    this.vBo = ((ImageButton)paramContext.findViewById(2131301960));
    this.vBo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65946);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.c(LuckyMoneyWishFooter.this));
        if (LuckyMoneyWishFooter.c(LuckyMoneyWishFooter.this) == 0)
        {
          LuckyMoneyWishFooter.this.setModeClick(true);
          LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(2131690564);
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
          LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(2131690564);
          LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 0);
        }
      }
    });
    this.vBp = ((MMEditText)paramContext.findViewById(2131301958));
    this.vBp.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65947);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(8);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).onPause();
        LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(2131690564);
        if (LuckyMoneyWishFooter.g(LuckyMoneyWishFooter.this) != null) {
          LuckyMoneyWishFooter.g(LuckyMoneyWishFooter.this);
        }
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 0);
        a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(65947);
        return false;
      }
    });
    if (e.FdJ == null)
    {
      this.pWJ = new d(this.fLP);
      AppMethodBeat.o(65951);
      return;
    }
    this.pWJ = e.FdJ.eA(getContext());
    this.pWJ.setEntranceScene(ChatFooterPanel.ESo);
    this.pWJ.setVisibility(8);
    ((LinearLayout)findViewById(2131304239)).addView(this.pWJ, -1, 0);
    this.pWJ.fbF();
    this.pWJ.onResume();
    this.pWJ.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aoO()
      {
        AppMethodBeat.i(65948);
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(65948);
      }
      
      public final void aoP() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(65949);
        try
        {
          LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).aXD(paramAnonymousString);
          AppMethodBeat.o(65949);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(65949);
        }
      }
      
      public final void dU(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(65951);
  }
  
  private void bEE()
  {
    AppMethodBeat.i(65954);
    this.pWJ.onResume();
    this.pWJ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65944);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(0);
        AppMethodBeat.o(65944);
      }
    }, 200L);
    ViewGroup.LayoutParams localLayoutParams = this.pWJ.getLayoutParams();
    if (((localLayoutParams != null) && (localLayoutParams.height <= 0)) || ((localLayoutParams != null) && (i.iK(getContext())) && (this.vBs)))
    {
      localLayoutParams.height = i.iI(getContext());
      this.pWJ.setLayoutParams(localLayoutParams);
      this.vBs = false;
    }
    AppMethodBeat.o(65954);
  }
  
  private void djI()
  {
    AppMethodBeat.i(65953);
    if (this.state == 0)
    {
      this.vBp.requestFocus();
      this.fLP.getWindow().setSoftInputMode(16);
      this.fLP.showVKB();
      this.pWJ.postDelayed(new Runnable()
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
    this.vBp.requestFocus();
    this.fLP.getWindow().setSoftInputMode(32);
    this.fLP.hideVKB();
    bEE();
    AppMethodBeat.o(65953);
  }
  
  private void og(boolean paramBoolean)
  {
    AppMethodBeat.i(65962);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772095);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772100);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if (this.gmY == null)
    {
      AppMethodBeat.o(65962);
      return;
    }
    if (paramBoolean)
    {
      if ((this.gmY.getVisibility() == 8) || (this.gmY.getVisibility() == 4))
      {
        AppMethodBeat.o(65962);
        return;
      }
      this.gmY.startAnimation(localAnimation2);
      this.gmY.setVisibility(8);
      AppMethodBeat.o(65962);
      return;
    }
    if ((this.gmY.getVisibility() == 0) || (this.gmY.getVisibility() == 0))
    {
      AppMethodBeat.o(65962);
      return;
    }
    this.gmY.startAnimation(localAnimation1);
    this.gmY.setVisibility(0);
    AppMethodBeat.o(65962);
  }
  
  public final void GV(int paramInt)
  {
    AppMethodBeat.i(65960);
    super.GV(paramInt);
    switch (paramInt)
    {
    default: 
      this.vBr = false;
      AppMethodBeat.o(65960);
      return;
    }
    this.vBr = true;
    AppMethodBeat.o(65960);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(65963);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.pWJ);
    AppMethodBeat.o(65963);
    return localArrayList;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65958);
    this.vBp.setHint(paramString);
    AppMethodBeat.o(65958);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(65955);
    this.vBp.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65955);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.vBq = paramBoolean;
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.vBv = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.vBw = paramc;
  }
  
  public void setOnWishSendImp(final b paramb)
  {
    AppMethodBeat.i(65959);
    this.gmY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65950);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramb.apb(LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getText().toString());
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
    if (this.vBp != null)
    {
      this.vBp.setText("");
      this.vBp.aXD(paramString);
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
      if (this.pWJ != null)
      {
        ad.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(bool)));
        if (bool) {
          break label118;
        }
        ad.d("MicroMsg.SnsCommentFooter", bt.flS());
        this.pWJ.setVisibility(8);
        this.vBo.setImageResource(2131690564);
        this.fLP.hideVKB();
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
      djI();
      this.vBs = false;
    }
  }
  
  static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void apb(String paramString);
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter
 * JD-Core Version:    0.7.0.1
 */