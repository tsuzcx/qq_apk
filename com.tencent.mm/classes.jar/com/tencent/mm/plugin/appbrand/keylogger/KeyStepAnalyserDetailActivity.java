package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.av;
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
  private static int mOI;
  private static SimpleDateFormat mOJ;
  private Class mOB;
  private String mOC;
  private View mOK;
  private View mOL;
  private LinearLayout mOM;
  private float mON;
  private float mOO;
  private float mOP;
  private float mOQ;
  private float mOR;
  private float mOS;
  private boolean mOT;
  private Map<String, c> mOU;
  private Map<String, Boolean> mOV;
  private ScaleGestureDetector.OnScaleGestureListener mOW;
  private ScaleGestureDetector mScaleGestureDetector;
  
  static
  {
    AppMethodBeat.i(221270);
    mOI = 3;
    mOJ = new SimpleDateFormat("HH:mm:ss");
    AppMethodBeat.o(221270);
  }
  
  public KeyStepAnalyserDetailActivity()
  {
    AppMethodBeat.i(221265);
    this.mOR = 1.0F;
    this.mOS = 1.0F;
    this.mOW = new ScaleGestureDetector.SimpleOnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        AppMethodBeat.i(221264);
        if (KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this) == null)
        {
          AppMethodBeat.o(221264);
          return true;
        }
        KeyStepAnalyserDetailActivity.e(KeyStepAnalyserDetailActivity.this, paramAnonymousScaleGestureDetector.getScaleFactor() * KeyStepAnalyserDetailActivity.j(KeyStepAnalyserDetailActivity.this));
        if ((KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this) > 5.0F) || (KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this) < 0.1F))
        {
          AppMethodBeat.o(221264);
          return true;
        }
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setTranslationX(KeyStepAnalyserDetailActivity.b(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setTranslationY(KeyStepAnalyserDetailActivity.d(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setPivotX(KeyStepAnalyserDetailActivity.e(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setPivotY(KeyStepAnalyserDetailActivity.f(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setScaleX(KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setScaleY(KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.f(KeyStepAnalyserDetailActivity.this, KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        AppMethodBeat.o(221264);
        return false;
      }
    };
    AppMethodBeat.o(221265);
  }
  
  private void bMN()
  {
    AppMethodBeat.i(221267);
    Object localObject1 = getIntent().getParcelableArrayListExtra("steps");
    Object localObject2 = new LinkedList((Collection)localObject1);
    Collections.sort((List)localObject2, new Comparator() {});
    this.mOV = new HashMap();
    int i = 0;
    while ((i < ((List)localObject2).size()) && (i <= mOI))
    {
      localObject3 = (IKeyStepAnalyser.StepLogInfo)((List)localObject2).get(i);
      if ((((IKeyStepAnalyser.StepLogInfo)localObject3).cCv > 0L) && (!((IKeyStepAnalyser.StepLogInfo)localObject3).bMX())) {
        this.mOV.put(((IKeyStepAnalyser.StepLogInfo)((List)localObject2).get(i)).mPw, Boolean.TRUE);
      }
      i += 1;
    }
    Object localObject3 = new HashMap();
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (IKeyStepAnalyser.StepLogInfo)((List)localObject1).get(i);
      ((Map)localObject3).put(((IKeyStepAnalyser.StepLogInfo)localObject2).mPw, localObject2);
      i += 1;
    }
    List localList = f.g(this.mOB, this.mOC);
    this.mOU = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    if (j < localList.size())
    {
      a locala = ((j)localList.get(j)).mPG;
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = (IKeyStepAnalyser.StepLogInfo)((Map)localObject3).get(locala.name());
      i = 0;
      if (localStepLogInfo == null)
      {
        if (locala.FI())
        {
          i = -2;
          label294:
          if (!Util.isNullOrNil(locala.bMW())) {
            break label378;
          }
        }
        label378:
        for (localObject1 = locala.name();; localObject1 = locala.bMW())
        {
          localObject1 = new SpannableString((CharSequence)localObject1);
          localObject1 = new c((SpannableString)localObject1, i);
          localArrayList.add(localObject1);
          this.mOU.put(locala.name(), localObject1);
          j += 1;
          break;
          i = -1;
          break label294;
        }
      }
      if (!localStepLogInfo.errMsg.equals("ok"))
      {
        if (locala.bMV()) {
          i = 1;
        }
      }
      else
      {
        label416:
        localObject2 = mOJ.format(Long.valueOf(localStepLogInfo.time));
        if (!Util.isNullOrNil(locala.bMW())) {
          break label625;
        }
      }
      label625:
      for (localObject1 = locala.name();; localObject1 = locala.bMW())
      {
        localObject2 = String.format("%s %s:%s %s", new Object[] { localObject2, localObject1, localStepLogInfo.errMsg, localStepLogInfo.mPy });
        int m = ((String)localObject2).length();
        int k = 0;
        localObject1 = localObject2;
        if (localStepLogInfo.cCv > 0L)
        {
          localObject1 = String.format(" cost:%d ms", new Object[] { Long.valueOf(localStepLogInfo.cCv) });
          k = ((String)localObject1).length();
          localObject1 = (String)localObject2 + (String)localObject1;
        }
        localObject1 = new SpannableString((CharSequence)localObject1);
        if (this.mOV.containsKey(localStepLogInfo.mPw)) {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-65536), m, k + m, 33);
        }
        break;
        i = 2;
        break label416;
      }
    }
    localObject1 = (VerticalStepView)findViewById(2131308413);
    ((VerticalStepView)localObject1).mPM = localArrayList;
    ((VerticalStepView)localObject1).mPL.setSteps(localArrayList);
    AppMethodBeat.o(221267);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(221268);
    if ((this.mScaleGestureDetector != null) && (this.mOK.getVisibility() == 0))
    {
      super.dispatchTouchEvent(paramMotionEvent);
      bool = this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(221268);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(221268);
    return bool;
  }
  
  protected final int getLayoutId()
  {
    return 2131492958;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(221266);
    super.onCreate(paramBundle);
    this.mOK = findViewById(2131299616);
    this.mOL = findViewById(2131309102);
    this.mOB = ((Class)getIntent().getSerializableExtra("key_process_class"));
    this.mOC = getIntent().getStringExtra("key_process_category");
    setTitle(getString(2131762046));
    TextView localTextView = (TextView)findViewById(2131302943);
    paramBundle = findViewById(2131299617);
    localTextView.setText(getIntent().getStringExtra("key_info"));
    int i = getResources().getDimensionPixelSize(2131165491);
    localTextView = (TextView)findViewById(2131302489);
    Object localObject4 = getString(2131762052) + " ";
    Object localObject2 = getString(2131762050) + " ";
    Object localObject1 = getString(2131762051) + " ";
    Object localObject3 = getString(2131762053);
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append((String)localObject4).append((String)localObject2).append((String)localObject1).append((String)localObject3);
    localObject3 = new SpannableString(((StringBuilder)localObject5).toString());
    localObject5 = android.support.v4.content.b.l(this, 2131235053);
    ((Drawable)localObject5).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject5, 0), 0, 1, 17);
    int j = ((String)localObject4).length() + 0;
    localObject4 = android.support.v4.content.b.l(this, 2131235052);
    ((Drawable)localObject4).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject4, 0), j, j + 1, 17);
    j += ((String)localObject2).length();
    localObject2 = android.support.v4.content.b.l(this, 2131235050);
    ((Drawable)localObject2).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject2, 0), j, j + 1, 17);
    j += ((String)localObject1).length();
    localObject1 = android.support.v4.content.b.l(this, 2131235054);
    ((Drawable)localObject1).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject1, 0), j, j + 1, 17);
    localTextView.setText((CharSequence)localObject3);
    paramBundle.setOnClickListener(new KeyStepAnalyserDetailActivity.1(this));
    bMN();
    AppMethodBeat.o(221266);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity
 * JD-Core Version:    0.7.0.1
 */