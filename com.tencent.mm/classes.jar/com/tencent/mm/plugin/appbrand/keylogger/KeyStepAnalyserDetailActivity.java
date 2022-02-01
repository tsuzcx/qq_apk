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
import android.view.View.OnClickListener;
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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.aq;
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
  private static int kEc;
  private static SimpleDateFormat kEd;
  private Class kDW;
  private View kEe;
  private View kEf;
  private LinearLayout kEg;
  private float kEh;
  private float kEi;
  private float kEj;
  private float kEk;
  private float kEl;
  private float kEm;
  private boolean kEn;
  private Map<String, c> kEo;
  private Map<String, Boolean> kEp;
  private ScaleGestureDetector.OnScaleGestureListener kEq;
  private ScaleGestureDetector mScaleGestureDetector;
  
  static
  {
    AppMethodBeat.i(194832);
    kEc = 3;
    kEd = new SimpleDateFormat("HH:mm:ss");
    AppMethodBeat.o(194832);
  }
  
  public KeyStepAnalyserDetailActivity()
  {
    AppMethodBeat.i(194827);
    this.kEl = 1.0F;
    this.kEm = 1.0F;
    this.kEq = new ScaleGestureDetector.SimpleOnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        AppMethodBeat.i(194826);
        if (KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this) == null)
        {
          AppMethodBeat.o(194826);
          return true;
        }
        KeyStepAnalyserDetailActivity.e(KeyStepAnalyserDetailActivity.this, paramAnonymousScaleGestureDetector.getScaleFactor() * KeyStepAnalyserDetailActivity.j(KeyStepAnalyserDetailActivity.this));
        if ((KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this) > 5.0F) || (KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this) < 0.1F))
        {
          AppMethodBeat.o(194826);
          return true;
        }
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setTranslationX(KeyStepAnalyserDetailActivity.b(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setTranslationY(KeyStepAnalyserDetailActivity.d(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setPivotX(KeyStepAnalyserDetailActivity.e(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setPivotY(KeyStepAnalyserDetailActivity.f(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setScaleX(KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.c(KeyStepAnalyserDetailActivity.this).setScaleY(KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        KeyStepAnalyserDetailActivity.f(KeyStepAnalyserDetailActivity.this, KeyStepAnalyserDetailActivity.g(KeyStepAnalyserDetailActivity.this));
        AppMethodBeat.o(194826);
        return false;
      }
    };
    AppMethodBeat.o(194827);
  }
  
  private void bfM()
  {
    AppMethodBeat.i(194829);
    Object localObject1 = getIntent().getParcelableArrayListExtra("steps");
    Object localObject2 = new LinkedList((Collection)localObject1);
    Collections.sort((List)localObject2, new Comparator() {});
    this.kEp = new HashMap();
    int i = 0;
    while ((i < ((List)localObject2).size()) && (i <= kEc))
    {
      localObject3 = (IKeyStepAnalyser.StepLogInfo)((List)localObject2).get(i);
      if ((((IKeyStepAnalyser.StepLogInfo)localObject3).cin > 0L) && (!((IKeyStepAnalyser.StepLogInfo)localObject3).bfX())) {
        this.kEp.put(((IKeyStepAnalyser.StepLogInfo)((List)localObject2).get(i)).kER, Boolean.TRUE);
      }
      i += 1;
    }
    Object localObject3 = new HashMap();
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (IKeyStepAnalyser.StepLogInfo)((List)localObject1).get(i);
      ((Map)localObject3).put(((IKeyStepAnalyser.StepLogInfo)localObject2).kER, localObject2);
      i += 1;
    }
    List localList = f.az(this.kDW);
    this.kEo = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    if (j < localList.size())
    {
      a locala = ((j)localList.get(j)).kFb;
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = (IKeyStepAnalyser.StepLogInfo)((Map)localObject3).get(locala.name());
      i = 0;
      if (localStepLogInfo == null)
      {
        if (locala.bfV())
        {
          i = -2;
          label290:
          if (!bt.isNullOrNil(locala.bfW())) {
            break label374;
          }
        }
        label374:
        for (localObject1 = locala.name();; localObject1 = locala.bfW())
        {
          localObject1 = new SpannableString((CharSequence)localObject1);
          localObject1 = new c((SpannableString)localObject1, i);
          localArrayList.add(localObject1);
          this.kEo.put(locala.name(), localObject1);
          j += 1;
          break;
          i = -1;
          break label290;
        }
      }
      if (!localStepLogInfo.errMsg.equals("ok"))
      {
        if (locala.bfU()) {
          i = 1;
        }
      }
      else
      {
        label412:
        localObject2 = kEd.format(Long.valueOf(localStepLogInfo.time));
        if (!bt.isNullOrNil(locala.bfW())) {
          break label621;
        }
      }
      label621:
      for (localObject1 = locala.name();; localObject1 = locala.bfW())
      {
        localObject2 = String.format("%s %s:%s %s", new Object[] { localObject2, localObject1, localStepLogInfo.errMsg, localStepLogInfo.kET });
        int m = ((String)localObject2).length();
        int k = 0;
        localObject1 = localObject2;
        if (localStepLogInfo.cin > 0L)
        {
          localObject1 = String.format(" cost:%d ms", new Object[] { Long.valueOf(localStepLogInfo.cin) });
          k = ((String)localObject1).length();
          localObject1 = (String)localObject2 + (String)localObject1;
        }
        localObject1 = new SpannableString((CharSequence)localObject1);
        if (this.kEp.containsKey(localStepLogInfo.kER)) {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-65536), m, k + m, 33);
        }
        break;
        i = 2;
        break label412;
      }
    }
    localObject1 = (VerticalStepView)findViewById(2131307250);
    ((VerticalStepView)localObject1).kFi = localArrayList;
    ((VerticalStepView)localObject1).kFh.setSteps(localArrayList);
    AppMethodBeat.o(194829);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(194830);
    if ((this.mScaleGestureDetector != null) && (this.kEe.getVisibility() == 0))
    {
      super.dispatchTouchEvent(paramMotionEvent);
      bool = this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(194830);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(194830);
    return bool;
  }
  
  protected final int getLayoutId()
  {
    return 2131496131;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194828);
    super.onCreate(paramBundle);
    this.kEe = findViewById(2131307184);
    this.kEf = findViewById(2131307254);
    this.kDW = ((Class)getIntent().getSerializableExtra("key_process_class"));
    setTitle(getString(2131765442));
    TextView localTextView = (TextView)findViewById(2131307209);
    paramBundle = findViewById(2131307185);
    localTextView.setText(getIntent().getStringExtra("key_info"));
    int i = getResources().getDimensionPixelSize(2131167025);
    localTextView = (TextView)findViewById(2131307200);
    Object localObject4 = getString(2131765448) + " ";
    Object localObject2 = getString(2131765446) + " ";
    Object localObject1 = getString(2131765447) + " ";
    Object localObject3 = getString(2131765449);
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append((String)localObject4).append((String)localObject2).append((String)localObject1).append((String)localObject3);
    localObject3 = new SpannableString(((StringBuilder)localObject5).toString());
    localObject5 = android.support.v4.content.b.l(this, 2131234846);
    ((Drawable)localObject5).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject5, 0), 0, 1, 17);
    int j = ((String)localObject4).length() + 0;
    localObject4 = android.support.v4.content.b.l(this, 2131234845);
    ((Drawable)localObject4).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject4, 0), j, j + 1, 17);
    j += ((String)localObject2).length();
    localObject2 = android.support.v4.content.b.l(this, 2131234843);
    ((Drawable)localObject2).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject2, 0), j, j + 1, 17);
    j += ((String)localObject1).length();
    localObject1 = android.support.v4.content.b.l(this, 2131234847);
    ((Drawable)localObject1).setBounds(0, 0, i, i);
    ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject1, 0), j, j + 1, 17);
    localTextView.setText((CharSequence)localObject3);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194823);
        KeyStepAnalyserDetailActivity.a(KeyStepAnalyserDetailActivity.this);
        AppMethodBeat.o(194823);
      }
    });
    bfM();
    AppMethodBeat.o(194828);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity
 * JD-Core Version:    0.7.0.1
 */