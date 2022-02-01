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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.wxawidget.a
{
  final List<LogInfo> mPH;
  EditText mPN;
  Button[] mPO;
  Button mPP;
  Button mPQ;
  a mPR;
  int mPS;
  String mPT;
  MRecyclerView mek;
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121630);
    this.mPH = new LinkedList();
    initialize();
    AppMethodBeat.o(121630);
  }
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121631);
    this.mPH = new LinkedList();
    initialize();
    AppMethodBeat.o(121631);
  }
  
  private boolean Sk(String paramString)
  {
    AppMethodBeat.i(121636);
    if ((!bs.isNullOrNil(this.mPT)) && ((paramString == null) || (!paramString.toLowerCase().contains(this.mPT.toLowerCase()))))
    {
      AppMethodBeat.o(121636);
      return true;
    }
    AppMethodBeat.o(121636);
    return false;
  }
  
  private void ez(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121634);
    Button localButton = (Button)findViewById(paramInt2);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121628);
        int i = 0;
        if (i < ConsolePanel.this.mPO.length)
        {
          Button localButton = ConsolePanel.this.mPO[i];
          if (localButton == paramAnonymousView) {}
          for (boolean bool = true;; bool = false)
          {
            localButton.setSelected(bool);
            if ((bool) && (ConsolePanel.this.mPS != i))
            {
              ConsolePanel.this.mPS = i;
              ConsolePanel.a(ConsolePanel.this);
            }
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(121628);
      }
    });
    this.mPO[paramInt1] = localButton;
    AppMethodBeat.o(121634);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(121632);
    LayoutInflater.from(getContext()).inflate(2131493597, this, true);
    this.mPN = ((EditText)findViewById(2131298580));
    this.mPN.clearFocus();
    this.mPO = new Button[5];
    ez(0, 2131301550);
    ez(1, 2131301553);
    ez(2, 2131301552);
    ez(3, 2131301556);
    ez(4, 2131301551);
    this.mPO[0].setSelected(true);
    this.mPS = 0;
    this.mPP = ((Button)findViewById(2131298349));
    this.mPQ = ((Button)findViewById(2131304284));
    this.mPQ.setEnabled(false);
    this.mPP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121622);
        ConsolePanel.this.mPH.clear();
        ConsolePanel.this.mPR.mPH.clear();
        ConsolePanel.this.mPR.arg.notifyChanged();
        AppMethodBeat.o(121622);
      }
    });
    this.mPQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121623);
        AppMethodBeat.o(121623);
      }
    });
    this.mPN.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.mPN.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(121624);
        if (paramAnonymousInt == 66)
        {
          ConsolePanel.this.mPT = ConsolePanel.this.mPN.getText().toString();
          ConsolePanel.a(ConsolePanel.this);
          f.dt(paramAnonymousView);
          AppMethodBeat.o(121624);
          return true;
        }
        AppMethodBeat.o(121624);
        return false;
      }
    });
    this.mPN.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121625);
        if (!paramAnonymousBoolean) {
          f.dt(paramAnonymousView);
        }
        AppMethodBeat.o(121625);
      }
    });
    findViewById(2131299173).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121626);
        ConsolePanel.this.mPT = ConsolePanel.this.mPN.getText().toString();
        ConsolePanel.a(ConsolePanel.this);
        AppMethodBeat.o(121626);
      }
    });
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(121627);
        f.dt(paramAnonymousView);
        AppMethodBeat.o(121627);
        return false;
      }
    });
    this.mek = ((MRecyclerView)findViewById(2131301555));
    this.mPR = new a(getContext());
    MRecyclerView localMRecyclerView = this.mek;
    getContext();
    localMRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.mek.setItemAnimator(null);
    this.mek.setAdapter(this.mPR);
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
      this.mPH.add(localLogInfo);
      if (((localLogInfo.level == this.mPS) || (this.mPS == 0)) && (!Sk(localLogInfo.message))) {
        localLinkedList.add(localLogInfo);
      }
      i += 1;
    }
    if (!localLinkedList.isEmpty()) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121629);
          int i = ConsolePanel.this.mPR.getItemCount();
          ConsolePanel.this.mPR.mPH.addAll(localLinkedList);
          ConsolePanel.this.mPR.aq(i, localLinkedList.size());
          if (((LinearLayoutManager)ConsolePanel.this.mek.getLayoutManager()).jY() == i - 1)
          {
            MRecyclerView localMRecyclerView = ConsolePanel.this.mek;
            com.tencent.mm.hellhoundlib.b.a locala = c.a(ConsolePanel.this.mPR.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localMRecyclerView, locala.aeD(), "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localMRecyclerView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
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
        f.dt(localView);
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(121633);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel
 * JD-Core Version:    0.7.0.1
 */