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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter
  extends BasePanelKeybordLayout
{
  private MMActivity fNT;
  private Button gpu;
  ChatFooterPanel qdo;
  private int state;
  private c vNA;
  private ImageButton vNs;
  MMEditText vNt;
  boolean vNu;
  public boolean vNv;
  private boolean vNw;
  boolean vNx;
  private TextWatcher vNy;
  private a vNz;
  
  public LuckyMoneyWishFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65951);
    this.state = 0;
    this.vNu = false;
    this.vNv = false;
    this.vNw = true;
    this.vNx = true;
    this.vNy = new TextWatcher()
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
          if ((i != 0) && (LuckyMoneyWishFooter.this.vNx))
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, true);
            LuckyMoneyWishFooter.this.vNx = false;
          }
          if (i == 0)
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, false);
            LuckyMoneyWishFooter.this.vNx = true;
          }
          AppMethodBeat.o(65945);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.fNT = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.fNT, 2131494662, this);
    this.gpu = ((Button)paramContext.findViewById(2131301961));
    ol(false);
    this.vNs = ((ImageButton)paramContext.findViewById(2131301960));
    this.vNs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65946);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.c(LuckyMoneyWishFooter.this));
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
    this.vNt = ((MMEditText)paramContext.findViewById(2131301958));
    this.vNt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65947);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
    if (e.Fwh == null)
    {
      this.qdo = new d(this.fNT);
      AppMethodBeat.o(65951);
      return;
    }
    this.qdo = e.Fwh.eE(getContext());
    this.qdo.setEntranceScene(ChatFooterPanel.FkJ);
    this.qdo.setVisibility(8);
    ((LinearLayout)findViewById(2131304239)).addView(this.qdo, -1, 0);
    this.qdo.fft();
    this.qdo.onResume();
    this.qdo.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void apc()
      {
        AppMethodBeat.i(65948);
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(65948);
      }
      
      public final void apd() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(65949);
        try
        {
          LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).aZf(paramAnonymousString);
          AppMethodBeat.o(65949);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(65949);
        }
      }
      
      public final void dW(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(65951);
  }
  
  private void bFw()
  {
    AppMethodBeat.i(65954);
    this.qdo.onResume();
    this.qdo.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65944);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(0);
        AppMethodBeat.o(65944);
      }
    }, 200L);
    ViewGroup.LayoutParams localLayoutParams = this.qdo.getLayoutParams();
    if (((localLayoutParams != null) && (localLayoutParams.height <= 0)) || ((localLayoutParams != null) && (i.iP(getContext())) && (this.vNw)))
    {
      localLayoutParams.height = i.iN(getContext());
      this.qdo.setLayoutParams(localLayoutParams);
      this.vNw = false;
    }
    AppMethodBeat.o(65954);
  }
  
  private void dmH()
  {
    AppMethodBeat.i(65953);
    if (this.state == 0)
    {
      this.vNt.requestFocus();
      this.fNT.getWindow().setSoftInputMode(16);
      this.fNT.showVKB();
      this.qdo.postDelayed(new Runnable()
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
    this.vNt.requestFocus();
    this.fNT.getWindow().setSoftInputMode(32);
    this.fNT.hideVKB();
    bFw();
    AppMethodBeat.o(65953);
  }
  
  private void ol(boolean paramBoolean)
  {
    AppMethodBeat.i(65962);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772095);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772100);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if (this.gpu == null)
    {
      AppMethodBeat.o(65962);
      return;
    }
    if (paramBoolean)
    {
      if ((this.gpu.getVisibility() == 8) || (this.gpu.getVisibility() == 4))
      {
        AppMethodBeat.o(65962);
        return;
      }
      this.gpu.startAnimation(localAnimation2);
      this.gpu.setVisibility(8);
      AppMethodBeat.o(65962);
      return;
    }
    if ((this.gpu.getVisibility() == 0) || (this.gpu.getVisibility() == 0))
    {
      AppMethodBeat.o(65962);
      return;
    }
    this.gpu.startAnimation(localAnimation1);
    this.gpu.setVisibility(0);
    AppMethodBeat.o(65962);
  }
  
  public final void Hs(int paramInt)
  {
    AppMethodBeat.i(65960);
    super.Hs(paramInt);
    switch (paramInt)
    {
    default: 
      this.vNv = false;
      AppMethodBeat.o(65960);
      return;
    }
    this.vNv = true;
    AppMethodBeat.o(65960);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(65963);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.qdo);
    AppMethodBeat.o(65963);
    return localArrayList;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65958);
    this.vNt.setHint(paramString);
    AppMethodBeat.o(65958);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(65955);
    this.vNt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65955);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.vNu = paramBoolean;
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.vNz = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.vNA = paramc;
  }
  
  public void setOnWishSendImp(final b paramb)
  {
    AppMethodBeat.i(65959);
    this.gpu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65950);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramb.aqg(LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getText().toString());
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
    if (this.vNt != null)
    {
      this.vNt.setText("");
      this.vNt.aZf(paramString);
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
      if (this.qdo != null)
      {
        ae.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(bool)));
        if (bool) {
          break label118;
        }
        ae.d("MicroMsg.SnsCommentFooter", bu.fpN());
        this.qdo.setVisibility(8);
        this.vNs.setImageResource(2131690564);
        this.fNT.hideVKB();
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
      dmH();
      this.vNw = false;
    }
  }
  
  static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void aqg(String paramString);
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter
 * JD-Core Version:    0.7.0.1
 */