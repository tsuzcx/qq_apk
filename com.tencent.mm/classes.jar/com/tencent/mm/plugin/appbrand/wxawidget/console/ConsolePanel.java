package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.wxawidget.a
{
  MRecyclerView iOL;
  a jxA;
  int jxB;
  String jxC;
  final List<LogInfo> jxq;
  EditText jxw;
  Button[] jxx;
  Button jxy;
  Button jxz;
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(11146);
    this.jxq = new LinkedList();
    initialize();
    AppMethodBeat.o(11146);
  }
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(11147);
    this.jxq = new LinkedList();
    initialize();
    AppMethodBeat.o(11147);
  }
  
  private boolean Ge(String paramString)
  {
    AppMethodBeat.i(11152);
    if ((!bo.isNullOrNil(this.jxC)) && ((paramString == null) || (!paramString.toLowerCase().contains(this.jxC.toLowerCase()))))
    {
      AppMethodBeat.o(11152);
      return true;
    }
    AppMethodBeat.o(11152);
    return false;
  }
  
  private void dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11150);
    Button localButton = (Button)findViewById(paramInt2);
    localButton.setOnClickListener(new ConsolePanel.8(this));
    this.jxx[paramInt1] = localButton;
    AppMethodBeat.o(11150);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(11148);
    LayoutInflater.from(getContext()).inflate(2130969212, this, true);
    this.jxw = ((EditText)findViewById(2131823023));
    this.jxw.clearFocus();
    this.jxx = new Button[5];
    dC(0, 2131823027);
    dC(1, 2131823028);
    dC(2, 2131823029);
    dC(3, 2131823030);
    dC(4, 2131823031);
    this.jxx[0].setSelected(true);
    this.jxB = 0;
    this.jxy = ((Button)findViewById(2131823025));
    this.jxz = ((Button)findViewById(2131823026));
    this.jxz.setEnabled(false);
    this.jxy.setOnClickListener(new ConsolePanel.1(this));
    this.jxz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView) {}
    });
    this.jxw.addTextChangedListener(new ConsolePanel.3(this));
    this.jxw.setOnKeyListener(new ConsolePanel.4(this));
    this.jxw.setOnFocusChangeListener(new ConsolePanel.5(this));
    findViewById(2131823024).setOnClickListener(new ConsolePanel.6(this));
    setOnTouchListener(new ConsolePanel.7(this));
    this.iOL = ((MRecyclerView)findViewById(2131823032));
    this.jxA = new a(getContext());
    MRecyclerView localMRecyclerView = this.iOL;
    getContext();
    localMRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.iOL.setItemAnimator(null);
    this.iOL.setAdapter(this.jxA);
    AppMethodBeat.o(11148);
  }
  
  public final void aP(List<LogInfo> paramList)
  {
    AppMethodBeat.i(11151);
    if (paramList == null)
    {
      AppMethodBeat.o(11151);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      LogInfo localLogInfo = (LogInfo)paramList.get(i);
      this.jxq.add(localLogInfo);
      if (((localLogInfo.level == this.jxB) || (this.jxB == 0)) && (!Ge(localLogInfo.message))) {
        localLinkedList.add(localLogInfo);
      }
      i += 1;
    }
    if (!localLinkedList.isEmpty()) {
      al.d(new ConsolePanel.9(this, localLinkedList));
    }
    AppMethodBeat.o(11151);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(11149);
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
        f.da(localView);
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(11149);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel
 * JD-Core Version:    0.7.0.1
 */