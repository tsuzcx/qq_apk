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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.wxawidget.a
{
  MRecyclerView mJI;
  EditText nvF;
  Button[] nvG;
  Button nvH;
  Button nvI;
  a nvJ;
  int nvK;
  String nvL;
  final List<LogInfo> nvz;
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121630);
    this.nvz = new LinkedList();
    initialize();
    AppMethodBeat.o(121630);
  }
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121631);
    this.nvz = new LinkedList();
    initialize();
    AppMethodBeat.o(121631);
  }
  
  private boolean Wu(String paramString)
  {
    AppMethodBeat.i(121636);
    if ((!bu.isNullOrNil(this.nvL)) && ((paramString == null) || (!paramString.toLowerCase().contains(this.nvL.toLowerCase()))))
    {
      AppMethodBeat.o(121636);
      return true;
    }
    AppMethodBeat.o(121636);
    return false;
  }
  
  private void eC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121634);
    Button localButton = (Button)findViewById(paramInt2);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121628);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        int i = 0;
        if (i < ConsolePanel.this.nvG.length)
        {
          localObject = ConsolePanel.this.nvG[i];
          if (localObject == paramAnonymousView) {}
          for (boolean bool = true;; bool = false)
          {
            ((Button)localObject).setSelected(bool);
            if ((bool) && (ConsolePanel.this.nvK != i))
            {
              ConsolePanel.this.nvK = i;
              ConsolePanel.a(ConsolePanel.this);
            }
            i += 1;
            break;
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121628);
      }
    });
    this.nvG[paramInt1] = localButton;
    AppMethodBeat.o(121634);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(121632);
    LayoutInflater.from(getContext()).inflate(2131493597, this, true);
    this.nvF = ((EditText)findViewById(2131298580));
    this.nvF.clearFocus();
    this.nvG = new Button[5];
    eC(0, 2131301550);
    eC(1, 2131301553);
    eC(2, 2131301552);
    eC(3, 2131301556);
    eC(4, 2131301551);
    this.nvG[0].setSelected(true);
    this.nvK = 0;
    this.nvH = ((Button)findViewById(2131298349));
    this.nvI = ((Button)findViewById(2131304284));
    this.nvI.setEnabled(false);
    this.nvH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121622);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ConsolePanel.this.nvz.clear();
        ConsolePanel.this.nvJ.nvz.clear();
        ConsolePanel.this.nvJ.asY.notifyChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121622);
      }
    });
    this.nvI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121623);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121623);
      }
    });
    this.nvF.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.nvF.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(121624);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
        if (paramAnonymousInt == 66)
        {
          ConsolePanel.this.nvL = ConsolePanel.this.nvF.getText().toString();
          ConsolePanel.a(ConsolePanel.this);
          f.dv(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(121624);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(121624);
        return false;
      }
    });
    this.nvF.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121625);
        if (!paramAnonymousBoolean) {
          f.dv(paramAnonymousView);
        }
        AppMethodBeat.o(121625);
      }
    });
    findViewById(2131299173).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121626);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ConsolePanel.this.nvL = ConsolePanel.this.nvF.getText().toString();
        ConsolePanel.a(ConsolePanel.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121626);
      }
    });
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(121627);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        f.dv(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(121627);
        return false;
      }
    });
    this.mJI = ((MRecyclerView)findViewById(2131301555));
    this.nvJ = new a(getContext());
    MRecyclerView localMRecyclerView = this.mJI;
    getContext();
    localMRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.mJI.setItemAnimator(null);
    this.mJI.setAdapter(this.nvJ);
    AppMethodBeat.o(121632);
  }
  
  public final void bL(List<LogInfo> paramList)
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
      this.nvz.add(localLogInfo);
      if (((localLogInfo.level == this.nvK) || (this.nvK == 0)) && (!Wu(localLogInfo.message))) {
        localLinkedList.add(localLogInfo);
      }
      i += 1;
    }
    if (!localLinkedList.isEmpty()) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121629);
          int i = ConsolePanel.this.nvJ.getItemCount();
          ConsolePanel.this.nvJ.nvz.addAll(localLinkedList);
          ConsolePanel.this.nvJ.ar(i, localLinkedList.size());
          if (((LinearLayoutManager)ConsolePanel.this.mJI.getLayoutManager()).ko() == i - 1)
          {
            MRecyclerView localMRecyclerView = ConsolePanel.this.mJI;
            com.tencent.mm.hellhoundlib.b.a locala = c.a(ConsolePanel.this.nvJ.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localMRecyclerView, locala.ahE(), "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localMRecyclerView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
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
        f.dv(localView);
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(121633);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel
 * JD-Core Version:    0.7.0.1
 */