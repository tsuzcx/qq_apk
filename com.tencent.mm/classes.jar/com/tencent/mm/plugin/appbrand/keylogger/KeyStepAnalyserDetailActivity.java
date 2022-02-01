package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.a.c;
import com.tencent.luggage.a.d;
import com.tencent.luggage.a.e;
import com.tencent.luggage.a.f;
import com.tencent.luggage.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.b;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bg;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KeyStepAnalyserDetailActivity
  extends KeyStepBaseActivity
{
  private static int sUb;
  private static SimpleDateFormat sUc;
  private ScaleGestureDetector mScaleGestureDetector;
  private Class sTU;
  private String sTV;
  private View sUd;
  private View sUe;
  private LinearLayout sUf;
  private float sUg;
  private float sUh;
  private float sUi;
  private float sUj;
  private float sUk;
  private float sUl;
  private boolean sUm;
  private Map<String, c> sUn;
  private Map<String, Boolean> sUo;
  private ScaleGestureDetector.OnScaleGestureListener sUp;
  
  static
  {
    AppMethodBeat.i(319540);
    sUb = 3;
    sUc = new SimpleDateFormat("HH:mm:ss");
    AppMethodBeat.o(319540);
  }
  
  public KeyStepAnalyserDetailActivity()
  {
    AppMethodBeat.i(319449);
    this.sUk = 1.0F;
    this.sUl = 1.0F;
    this.sUp = new ScaleGestureDetector.SimpleOnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        AppMethodBeat.i(319455);
        if (KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this) == null)
        {
          AppMethodBeat.o(319455);
          return true;
        }
        KeyStepAnalyserDetailActivity.e(KeyStepAnalyserDetailActivity.this, paramAnonymousScaleGestureDetector.getScaleFactor() * KeyStepAnalyserDetailActivity.j(KeyStepAnalyserDetailActivity.this));
        if ((KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this) > 5.0F) || (KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this) < 0.1F))
        {
          AppMethodBeat.o(319455);
          return true;
        }
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setTranslationX(KeyStepAnalyserDetailActivity.b(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setTranslationY(KeyStepAnalyserDetailActivity.d(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setPivotX(KeyStepAnalyserDetailActivity.e(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setPivotY(KeyStepAnalyserDetailActivity.f(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setScaleX(KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setScaleY(KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.f(KeyStepAnalyserDetailActivity.this, KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        AppMethodBeat.o(319455);
        return false;
      }
    };
    AppMethodBeat.o(319449);
  }
  
  private void czq()
  {
    AppMethodBeat.i(319457);
    Object localObject1 = getIntent().getParcelableArrayListExtra("steps");
    Object localObject2 = new LinkedList((Collection)localObject1);
    Collections.sort((List)localObject2, new Comparator() {});
    this.sUo = new HashMap();
    int i = 0;
    while ((i < ((List)localObject2).size()) && (i <= sUb))
    {
      localObject3 = (IKeyStepAnalyser.StepLogInfo)((List)localObject2).get(i);
      if ((((IKeyStepAnalyser.StepLogInfo)localObject3).cost > 0L) && (!((IKeyStepAnalyser.StepLogInfo)localObject3).czA())) {
        this.sUo.put(((IKeyStepAnalyser.StepLogInfo)((List)localObject2).get(i)).sUP, Boolean.TRUE);
      }
      i += 1;
    }
    Object localObject3 = new HashMap();
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (IKeyStepAnalyser.StepLogInfo)((List)localObject1).get(i);
      ((Map)localObject3).put(((IKeyStepAnalyser.StepLogInfo)localObject2).sUP, localObject2);
      i += 1;
    }
    List localList = f.f(this.sTU, this.sTV);
    this.sUn = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    if (j < localList.size())
    {
      com.tencent.mm.plugin.appbrand.keylogger.base.a locala = ((j)localList.get(j)).sUZ;
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = (IKeyStepAnalyser.StepLogInfo)((Map)localObject3).get(locala.name());
      i = 0;
      if (localStepLogInfo == null)
      {
        if (locala.ahk())
        {
          i = -2;
          label294:
          if (!Util.isNullOrNil(locala.czz())) {
            break label378;
          }
        }
        label378:
        for (localObject1 = locala.name();; localObject1 = locala.czz())
        {
          localObject1 = new SpannableString((CharSequence)localObject1);
          localObject1 = new c((SpannableString)localObject1, i);
          localArrayList.add(localObject1);
          this.sUn.put(locala.name(), localObject1);
          j += 1;
          break;
          i = -1;
          break label294;
        }
      }
      if (!localStepLogInfo.errMsg.equals("ok"))
      {
        if (locala.czy()) {
          i = 1;
        }
      }
      else
      {
        label416:
        localObject2 = sUc.format(Long.valueOf(localStepLogInfo.time));
        if (!Util.isNullOrNil(locala.czz())) {
          break label625;
        }
      }
      label625:
      for (localObject1 = locala.name();; localObject1 = locala.czz())
      {
        localObject2 = String.format("%s %s:%s %s", new Object[] { localObject2, localObject1, localStepLogInfo.errMsg, localStepLogInfo.sUR });
        int m = ((String)localObject2).length();
        int k = 0;
        localObject1 = localObject2;
        if (localStepLogInfo.cost > 0L)
        {
          localObject1 = String.format(" cost:%d ms", new Object[] { Long.valueOf(localStepLogInfo.cost) });
          k = ((String)localObject1).length();
          localObject1 = (String)localObject2 + (String)localObject1;
        }
        localObject1 = new SpannableString((CharSequence)localObject1);
        if (this.sUo.containsKey(localStepLogInfo.sUP)) {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-65536), m, k + m, 33);
        }
        break;
        i = 2;
        break label416;
      }
    }
    localObject1 = (VerticalStepView)findViewById(a.e.stepView);
    ((VerticalStepView)localObject1).sVe = localArrayList;
    ((VerticalStepView)localObject1).sVd.setSteps(localArrayList);
    AppMethodBeat.o(319457);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(319558);
    if ((this.mScaleGestureDetector != null) && (this.sUd.getVisibility() == 0))
    {
      super.dispatchTouchEvent(paramMotionEvent);
      bool = this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(319558);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(319558);
    return bool;
  }
  
  protected final int getLayoutId()
  {
    return a.f.activity_key_step_analyser_detail;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(319550);
    super.onCreate(paramBundle);
    this.sUd = findViewById(a.e.diagram_container);
    this.sUe = findViewById(a.e.timeline_container);
    this.sTU = ((Class)getIntent().getSerializableExtra("key_process_class"));
    this.sTV = getIntent().getStringExtra("key_process_category");
    setTitle(getString(a.g.key_step_logger_analyser_detail_title));
    TextView localTextView = (TextView)findViewById(a.e.keyInfo);
    paramBundle = findViewById(a.e.diagram_switch);
    localTextView.setText(getIntent().getStringExtra("key_info"));
    int i = getResources().getDimensionPixelSize(a.c.KeyStepLoggerStateIconDescSize);
    localTextView = (TextView)findViewById(a.e.icon_desc);
    Object localObject4 = getString(a.g.key_step_logger_icon_ok) + " ";
    Object localObject2 = getString(a.g.key_step_logger_icon_error) + " ";
    Object localObject1 = getString(a.g.key_step_logger_icon_error_not_fatal) + " ";
    Object localObject3 = getString(a.g.key_step_logger_icon_optional);
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append((String)localObject4).append((String)localObject2).append((String)localObject1).append((String)localObject3);
    localObject3 = new SpannableString(((StringBuilder)localObject5).toString());
    localObject5 = androidx.core.content.a.m(this, a.d.step_ok);
    ((Drawable)localObject5).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject5, 0), 0, 1, 17);
    int j = ((String)localObject4).length() + 0;
    localObject4 = androidx.core.content.a.m(this, a.d.step_error);
    ((Drawable)localObject4).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject4, 0), j, j + 1, 17);
    j += ((String)localObject2).length();
    localObject2 = androidx.core.content.a.m(this, a.d.step_attention);
    ((Drawable)localObject2).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject2, 0), j, j + 1, 17);
    j += ((String)localObject1).length();
    localObject1 = androidx.core.content.a.m(this, a.d.step_optional);
    ((Drawable)localObject1).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject1, 0), j, j + 1, 17);
    localTextView.setText((CharSequence)localObject3);
    paramBundle.setOnClickListener(new KeyStepAnalyserDetailActivity.1(this));
    czq();
    AppMethodBeat.o(319550);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity
 * JD-Core Version:    0.7.0.1
 */