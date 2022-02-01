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
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter
  extends BasePanelKeybordLayout
{
  private Button fTu;
  ChatFooterPanel fWT;
  private MMActivity iMV;
  private int state;
  private ImageButton uyL;
  MMEditText uyM;
  boolean uyN;
  public boolean uyO;
  private boolean uyP;
  boolean uyQ;
  private TextWatcher uyR;
  private a uyS;
  private c uyT;
  
  public LuckyMoneyWishFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65951);
    this.state = 0;
    this.uyN = false;
    this.uyO = false;
    this.uyP = true;
    this.uyQ = true;
    this.uyR = new TextWatcher()
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
          if ((i != 0) && (LuckyMoneyWishFooter.this.uyQ))
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, true);
            LuckyMoneyWishFooter.this.uyQ = false;
          }
          if (i == 0)
          {
            LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, false);
            LuckyMoneyWishFooter.this.uyQ = true;
          }
          AppMethodBeat.o(65945);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.iMV = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.iMV, 2131494662, this);
    this.fTu = ((Button)paramContext.findViewById(2131301961));
    nM(false);
    this.uyL = ((ImageButton)paramContext.findViewById(2131301960));
    this.uyL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65946);
        ac.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.c(LuckyMoneyWishFooter.this));
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
          AppMethodBeat.o(65946);
          return;
          LuckyMoneyWishFooter.this.setModeClick(false);
          LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
          LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(2131690564);
          LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 0);
        }
      }
    });
    this.uyM = ((MMEditText)paramContext.findViewById(2131301958));
    this.uyM.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65947);
        LuckyMoneyWishFooter.e(LuckyMoneyWishFooter.this);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(8);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).onPause();
        LuckyMoneyWishFooter.d(LuckyMoneyWishFooter.this).setImageResource(2131690564);
        if (LuckyMoneyWishFooter.g(LuckyMoneyWishFooter.this) != null) {
          LuckyMoneyWishFooter.g(LuckyMoneyWishFooter.this);
        }
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, 0);
        AppMethodBeat.o(65947);
        return false;
      }
    });
    if (e.DyA == null)
    {
      this.fWT = new d(this.iMV);
      AppMethodBeat.o(65951);
      return;
    }
    this.fWT = e.DyA.eA(getContext());
    this.fWT.setEntranceScene(ChatFooterPanel.Dnj);
    this.fWT.setVisibility(8);
    ((LinearLayout)findViewById(2131304239)).addView(this.fWT, -1, 0);
    this.fWT.eMH();
    this.fWT.onResume();
    this.fWT.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void amb()
      {
        AppMethodBeat.i(65948);
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(65948);
      }
      
      public final void amc() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(65949);
        try
        {
          LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).aRF(paramAnonymousString);
          AppMethodBeat.o(65949);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ac.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(65949);
        }
      }
      
      public final void dS(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(65951);
  }
  
  private void bAC()
  {
    AppMethodBeat.i(65954);
    this.fWT.onResume();
    this.fWT.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65944);
        LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this).setVisibility(0);
        AppMethodBeat.o(65944);
      }
    }, 200L);
    ViewGroup.LayoutParams localLayoutParams = this.fWT.getLayoutParams();
    if (((localLayoutParams != null) && (localLayoutParams.height <= 0)) || ((localLayoutParams != null) && (i.iA(getContext())) && (this.uyP)))
    {
      localLayoutParams.height = i.iy(getContext());
      this.fWT.setLayoutParams(localLayoutParams);
      this.uyP = false;
    }
    AppMethodBeat.o(65954);
  }
  
  private void dav()
  {
    AppMethodBeat.i(65953);
    if (this.state == 0)
    {
      this.uyM.requestFocus();
      this.iMV.getWindow().setSoftInputMode(16);
      this.iMV.showVKB();
      this.fWT.postDelayed(new Runnable()
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
    this.uyM.requestFocus();
    this.iMV.getWindow().setSoftInputMode(32);
    this.iMV.hideVKB();
    bAC();
    AppMethodBeat.o(65953);
  }
  
  private void nM(boolean paramBoolean)
  {
    AppMethodBeat.i(65962);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772095);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772100);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if (this.fTu == null)
    {
      AppMethodBeat.o(65962);
      return;
    }
    if (paramBoolean)
    {
      if ((this.fTu.getVisibility() == 8) || (this.fTu.getVisibility() == 4))
      {
        AppMethodBeat.o(65962);
        return;
      }
      this.fTu.startAnimation(localAnimation2);
      this.fTu.setVisibility(8);
      AppMethodBeat.o(65962);
      return;
    }
    if ((this.fTu.getVisibility() == 0) || (this.fTu.getVisibility() == 0))
    {
      AppMethodBeat.o(65962);
      return;
    }
    this.fTu.startAnimation(localAnimation1);
    this.fTu.setVisibility(0);
    AppMethodBeat.o(65962);
  }
  
  public final void FG(int paramInt)
  {
    AppMethodBeat.i(65960);
    super.FG(paramInt);
    switch (paramInt)
    {
    default: 
      this.uyO = false;
      AppMethodBeat.o(65960);
      return;
    }
    this.uyO = true;
    AppMethodBeat.o(65960);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(65963);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.fWT);
    AppMethodBeat.o(65963);
    return localArrayList;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(65958);
    this.uyM.setHint(paramString);
    AppMethodBeat.o(65958);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(65955);
    this.uyM.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(65955);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.uyN = paramBoolean;
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.uyS = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.uyT = paramc;
  }
  
  public void setOnWishSendImp(final b paramb)
  {
    AppMethodBeat.i(65959);
    this.fTu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65950);
        paramb.ako(LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).getText().toString());
        LuckyMoneyWishFooter.b(LuckyMoneyWishFooter.this).setText("");
        AppMethodBeat.o(65950);
      }
    });
    AppMethodBeat.o(65959);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(65957);
    if (this.uyM != null)
    {
      this.uyM.setText("");
      this.uyM.aRF(paramString);
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
      if (this.fWT != null)
      {
        ac.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(bool)));
        if (bool) {
          break label118;
        }
        ac.d("MicroMsg.SnsCommentFooter", bs.eWi());
        this.fWT.setVisibility(8);
        this.uyL.setImageResource(2131690564);
        this.iMV.hideVKB();
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
      dav();
      this.uyP = false;
    }
  }
  
  static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void ako(String paramString);
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter
 * JD-Core Version:    0.7.0.1
 */