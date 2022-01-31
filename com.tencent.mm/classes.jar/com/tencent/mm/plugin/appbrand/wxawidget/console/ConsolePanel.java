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
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.wxawidget.a
{
  final List<LogInfo> hEd = new LinkedList();
  EditText hEj;
  Button[] hEk;
  Button hEl;
  Button hEm;
  a hEn;
  int hEo;
  String hEp;
  MRecyclerView hdY;
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize();
  }
  
  public ConsolePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize();
  }
  
  private void cn(int paramInt1, int paramInt2)
  {
    Button localButton = (Button)findViewById(paramInt2);
    localButton.setOnClickListener(new ConsolePanel.8(this));
    this.hEk[paramInt1] = localButton;
  }
  
  private void initialize()
  {
    LayoutInflater.from(getContext()).inflate(b.c.console_panel, this, true);
    this.hEj = ((EditText)findViewById(b.b.console_dt));
    this.hEj.clearFocus();
    this.hEk = new Button[5];
    cn(0, b.b.log_all_btn);
    cn(1, b.b.log_log_btn);
    cn(2, b.b.log_info_btn);
    cn(3, b.b.log_warn_btn);
    cn(4, b.b.log_error_btn);
    this.hEk[0].setSelected(true);
    this.hEo = 0;
    this.hEl = ((Button)findViewById(b.b.clear_log_btn));
    this.hEm = ((Button)findViewById(b.b.save_log_btn));
    this.hEm.setEnabled(false);
    this.hEl.setOnClickListener(new ConsolePanel.1(this));
    this.hEm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView) {}
    });
    this.hEj.addTextChangedListener(new ConsolePanel.3(this));
    this.hEj.setOnKeyListener(new ConsolePanel.4(this));
    this.hEj.setOnFocusChangeListener(new ConsolePanel.5(this));
    findViewById(b.b.do_filter_btn).setOnClickListener(new ConsolePanel.6(this));
    setOnTouchListener(new ConsolePanel.7(this));
    this.hdY = ((MRecyclerView)findViewById(b.b.log_rv));
    this.hEn = new a(getContext());
    MRecyclerView localMRecyclerView = this.hdY;
    getContext();
    localMRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.hdY.setItemAnimator(null);
    this.hdY.setAdapter(this.hEn);
  }
  
  private boolean xm(String paramString)
  {
    return (!bk.bl(this.hEp)) && ((paramString == null) || (!paramString.toLowerCase().contains(this.hEp.toLowerCase())));
  }
  
  public final void aF(List<LogInfo> paramList)
  {
    if (paramList == null) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramList.size())
      {
        LogInfo localLogInfo = (LogInfo)paramList.get(i);
        this.hEd.add(localLogInfo);
        if (((localLogInfo.level == this.hEo) || (this.hEo == 0)) && (!xm(localLogInfo.message))) {
          localLinkedList.add(localLogInfo);
        }
        i += 1;
      }
    } while (localLinkedList.isEmpty());
    com.tencent.mm.cg.a.m(new ConsolePanel.9(this, localLinkedList));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    View localView;
    if (paramMotionEvent.getAction() == 0)
    {
      localView = ((Activity)getContext()).getCurrentFocus();
      if ((localView == null) || (!(localView instanceof EditText))) {
        break label143;
      }
      int[] arrayOfInt = new int[2];
      int[] tmp39_37 = arrayOfInt;
      tmp39_37[0] = 0;
      int[] tmp43_39 = tmp39_37;
      tmp43_39[1] = 0;
      tmp43_39;
      localView.getLocationInWindow(arrayOfInt);
      i = arrayOfInt[0];
      int j = arrayOfInt[1];
      int k = localView.getHeight();
      int m = localView.getWidth();
      if ((paramMotionEvent.getX() > i) && (paramMotionEvent.getX() < m + i) && (paramMotionEvent.getY() > j) && (paramMotionEvent.getY() < k + j)) {
        break label143;
      }
    }
    label143:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        f.cy(localView);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel
 * JD-Core Version:    0.7.0.1
 */