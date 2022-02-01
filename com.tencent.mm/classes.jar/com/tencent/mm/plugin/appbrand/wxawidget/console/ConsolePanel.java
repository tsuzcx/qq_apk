package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.wxawidget.a
{
  MRecyclerView lCp;
  final List<LogInfo> mnG;
  EditText mnM;
  Button[] mnN;
  Button mnO;
  Button mnP;
  a mnQ;
  int mnR;
  String mnS;
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121630);
    this.mnG = new LinkedList();
    initialize();
    AppMethodBeat.o(121630);
  }
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121631);
    this.mnG = new LinkedList();
    initialize();
    AppMethodBeat.o(121631);
  }
  
  private boolean Ob(String paramString)
  {
    AppMethodBeat.i(121636);
    if ((!bt.isNullOrNil(this.mnS)) && ((paramString == null) || (!paramString.toLowerCase().contains(this.mnS.toLowerCase()))))
    {
      AppMethodBeat.o(121636);
      return true;
    }
    AppMethodBeat.o(121636);
    return false;
  }
  
  private void ew(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121634);
    Button localButton = (Button)findViewById(paramInt2);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121628);
        int i = 0;
        if (i < ConsolePanel.this.mnN.length)
        {
          Button localButton = ConsolePanel.this.mnN[i];
          if (localButton == paramAnonymousView) {}
          for (boolean bool = true;; bool = false)
          {
            localButton.setSelected(bool);
            if ((bool) && (ConsolePanel.this.mnR != i))
            {
              ConsolePanel.this.mnR = i;
              ConsolePanel.a(ConsolePanel.this);
            }
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(121628);
      }
    });
    this.mnN[paramInt1] = localButton;
    AppMethodBeat.o(121634);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(121632);
    LayoutInflater.from(getContext()).inflate(2131493597, this, true);
    this.mnM = ((EditText)findViewById(2131298580));
    this.mnM.clearFocus();
    this.mnN = new Button[5];
    ew(0, 2131301550);
    ew(1, 2131301553);
    ew(2, 2131301552);
    ew(3, 2131301556);
    ew(4, 2131301551);
    this.mnN[0].setSelected(true);
    this.mnR = 0;
    this.mnO = ((Button)findViewById(2131298349));
    this.mnP = ((Button)findViewById(2131304284));
    this.mnP.setEnabled(false);
    this.mnO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121622);
        ConsolePanel.this.mnG.clear();
        ConsolePanel.this.mnQ.mnG.clear();
        ConsolePanel.this.mnQ.aql.notifyChanged();
        AppMethodBeat.o(121622);
      }
    });
    this.mnP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121623);
        AppMethodBeat.o(121623);
      }
    });
    this.mnM.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.mnM.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(121624);
        if (paramAnonymousInt == 66)
        {
          ConsolePanel.this.mnS = ConsolePanel.this.mnM.getText().toString();
          ConsolePanel.a(ConsolePanel.this);
          f.dr(paramAnonymousView);
          AppMethodBeat.o(121624);
          return true;
        }
        AppMethodBeat.o(121624);
        return false;
      }
    });
    this.mnM.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121625);
        if (!paramAnonymousBoolean) {
          f.dr(paramAnonymousView);
        }
        AppMethodBeat.o(121625);
      }
    });
    findViewById(2131299173).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121626);
        ConsolePanel.this.mnS = ConsolePanel.this.mnM.getText().toString();
        ConsolePanel.a(ConsolePanel.this);
        AppMethodBeat.o(121626);
      }
    });
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(121627);
        f.dr(paramAnonymousView);
        AppMethodBeat.o(121627);
        return false;
      }
    });
    this.lCp = ((MRecyclerView)findViewById(2131301555));
    this.mnQ = new a(getContext());
    MRecyclerView localMRecyclerView = this.lCp;
    getContext();
    localMRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.lCp.setItemAnimator(null);
    this.lCp.setAdapter(this.mnQ);
    AppMethodBeat.o(121632);
  }
  
  public final void bI(List<LogInfo> paramList)
  {
    AppMethodBeat.i(121635);
    if (paramList == null)
    {
      AppMethodBeat.o(121635);
      return;
    }
    final LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      LogInfo localLogInfo = (LogInfo)paramList.get(i);
      this.mnG.add(localLogInfo);
      if (((localLogInfo.level == this.mnR) || (this.mnR == 0)) && (!Ob(localLogInfo.message))) {
        localLinkedList.add(localLogInfo);
      }
      i += 1;
    }
    if (!localLinkedList.isEmpty()) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121629);
          int i = ConsolePanel.this.mnQ.getItemCount();
          ConsolePanel.this.mnQ.mnG.addAll(localLinkedList);
          ConsolePanel.this.mnQ.aq(i, localLinkedList.size());
          if (((LinearLayoutManager)ConsolePanel.this.lCp.getLayoutManager()).jQ() == i - 1)
          {
            MRecyclerView localMRecyclerView = ConsolePanel.this.lCp;
            com.tencent.mm.hellhoundlib.b.a locala = c.a(ConsolePanel.this.mnQ.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localMRecyclerView, locala.adn(), "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localMRecyclerView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localMRecyclerView, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          }
          AppMethodBeat.o(121629);
        }
      });
    }
    AppMethodBeat.o(121635);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(121633);
    View localView;
    if (paramMotionEvent.getAction() == 0)
    {
      localView = ((Activity)getContext()).getCurrentFocus();
      if ((localView == null) || (!(localView instanceof EditText))) {
        break label159;
      }
      int[] arrayOfInt = new int[2];
      int[] tmp45_43 = arrayOfInt;
      tmp45_43[0] = 0;
      int[] tmp49_45 = tmp45_43;
      tmp49_45[1] = 0;
      tmp49_45;
      localView.getLocationInWindow(arrayOfInt);
      i = arrayOfInt[0];
      int j = arrayOfInt[1];
      int k = localView.getHeight();
      int m = localView.getWidth();
      if ((paramMotionEvent.getX() > i) && (paramMotionEvent.getX() < m + i) && (paramMotionEvent.getY() > j) && (paramMotionEvent.getY() < k + j)) {
        break label159;
      }
    }
    label159:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        f.dr(localView);
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(121633);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel
 * JD-Core Version:    0.7.0.1
 */