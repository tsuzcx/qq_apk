package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.aa.a.c.c;
import com.tencent.mm.plugin.aa.a.c.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI
  extends BaseAAPresenterActivity
{
  private String bHQ;
  private ah dPi = new ah(Looper.getMainLooper());
  private double eYA;
  private long eYB = -1L;
  private int eYC = -1;
  private boolean eYD;
  private boolean eYE = false;
  private Runnable eYF = new LaunchAAByPersonAmountSelectUI.1(this);
  private c eYr = (c)C(c.class);
  private ListView eYs;
  private TextView eYt;
  private TextView eYu;
  private View eYv;
  private TextView eYw;
  private boolean eYx = false;
  private Map<String, String> eYy = new HashMap();
  private LaunchAAByPersonAmountSelectUI.a eYz = null;
  
  private void VI()
  {
    label257:
    label464:
    do
    {
      try
      {
        this.eYA = 0.0D;
        this.eYD = false;
        if (this.eYy == null) {
          break label257;
        }
        Iterator localIterator = this.eYy.values().iterator();
        while (localIterator.hasNext())
        {
          double d = bk.getDouble((String)localIterator.next(), 0.0D);
          this.eYA += d;
          if ((this.eYB > 0L) && (d * 100.0D > this.eYB)) {
            this.eYD = true;
          }
        }
        if (this.eYz == null) {
          break label257;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
        return;
      }
      Object localObject2 = this.eYz;
      Object localObject1 = this.eYy;
      Object localObject3 = ((LaunchAAByPersonAmountSelectUI.a)localObject2).dataList.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((LaunchAAByPersonAmountSelectUI.b)((Iterator)localObject3).next()).eYN = "";
      }
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject2 = ((LaunchAAByPersonAmountSelectUI.a)localObject2).dataList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (LaunchAAByPersonAmountSelectUI.b)((Iterator)localObject2).next();
          if (((Map)localObject1).containsKey(((LaunchAAByPersonAmountSelectUI.b)localObject3).username)) {
            ((LaunchAAByPersonAmountSelectUI.b)localObject3).eYN = ((String)((Map)localObject1).get(((LaunchAAByPersonAmountSelectUI.b)localObject3).username));
          }
        }
      }
      this.eYu.setText(getString(a.i.launch_aa_by_person_amount_select_summary, new Object[] { Double.valueOf(this.eYA) }));
      if ((this.eYy != null) && (this.eYy.size() > 0)) {
        updateOptionMenuText(233, getString(a.i.aa_confirm_num, new Object[] { Integer.valueOf(this.eYy.size()) }));
      }
      for (;;)
      {
        if (!this.eYD) {
          break label464;
        }
        h.nFQ.f(13722, new Object[] { Integer.valueOf(7) });
        enableOptionMenu(233, false);
        localObject1 = getString(a.i.launch_aa_money_exceed_avg_amount_alert, new Object[] { Float.valueOf((float)this.eYB / 100.0F) });
        if (bk.bl((String)localObject1)) {
          break;
        }
        this.eYw.setText((CharSequence)localObject1);
        if (this.eYw.isShown()) {
          break;
        }
        this.eYw.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
        this.eYw.setVisibility(0);
        return;
        updateOptionMenuText(233, getString(a.i.app_ok));
      }
      enableOptionMenu(233, true);
    } while (!this.eYw.isShown());
    this.eYw.setText("");
    this.eYw.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
    this.eYw.setVisibility(8);
  }
  
  private void VJ()
  {
    if (this.eYA > 0.0D)
    {
      this.eYx = true;
      this.eYt.setTextColor(getResources().getColor(a.c.btn_green_color_normal));
      return;
    }
    this.eYx = false;
    this.eYt.setTextColor(getResources().getColor(a.c.btn_green_color_disable));
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.launch_aa_by_person_amount_select_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.launch_aa_by_person_amount_select_title);
    setBackBtn(new LaunchAAByPersonAmountSelectUI.2(this));
    a(233, getString(a.i.app_ok), new LaunchAAByPersonAmountSelectUI.3(this), s.b.uNx);
    this.eYs = ((ListView)findViewById(a.f.amount_select_list));
    this.eYt = ((TextView)findViewById(a.f.clear_amount));
    this.eYu = ((TextView)findViewById(a.f.amount_summary));
    this.eYu.setText(getString(a.i.launch_aa_by_person_amount_select_summary, new Object[] { Float.valueOf(0.0F) }));
    this.eYv = findViewById(a.f.summary_layout);
    this.eYw = ((TextView)findViewById(a.f.alert_tip_tv));
    this.eYe = this.eYs;
    this.eYv.setVisibility(8);
    this.eYt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (!LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this)) {
          return true;
        }
        if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 2)) {
          LaunchAAByPersonAmountSelectUI.l(LaunchAAByPersonAmountSelectUI.this).setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(a.c.btn_green_color_pressed));
        }
        for (;;)
        {
          return false;
          if (LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this)) {
            LaunchAAByPersonAmountSelectUI.l(LaunchAAByPersonAmountSelectUI.this).setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(a.c.btn_green_color_normal));
          } else {
            LaunchAAByPersonAmountSelectUI.l(LaunchAAByPersonAmountSelectUI.this).setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(a.c.btn_green_color_disable));
          }
        }
      }
    });
    this.eYt.setOnClickListener(new LaunchAAByPersonAmountSelectUI.6(this));
    this.eYx = true;
    this.eYs.setOnScrollListener(new LaunchAAByPersonAmountSelectUI.7(this));
    this.bHQ = getIntent().getStringExtra("chatroom");
    this.eYB = getIntent().getLongExtra("maxPerAmount", -1L);
    this.eYC = getIntent().getIntExtra("maxUserNumber", -1);
    Object localObject = getIntent().getStringArrayListExtra("oldAmountData");
    y.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", new Object[] { this.bHQ, Long.valueOf(this.eYB), localObject });
    this.eYy = new HashMap();
    paramBundle = new HashMap();
    if (localObject != null) {
      try
      {
        if (((ArrayList)localObject).size() > 0)
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
            if ((arrayOfString != null) && (arrayOfString.length == 2))
            {
              double d = bk.getDouble(arrayOfString[1], 0.0D);
              paramBundle.put(arrayOfString[0], Double.valueOf(d));
              this.eYy.put(arrayOfString[0], getString(a.i.aa_amount_format, new Object[] { Double.valueOf(d) }));
            }
          }
        }
        this.eYr.ae(c.a.class);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", new Object[] { localException.getMessage() });
      }
    }
    this.eYr.a(c.a.class, new LaunchAAByPersonAmountSelectUI.4(this, paramBundle));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.eYy != null) {
      this.eYy.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI
 * JD-Core Version:    0.7.0.1
 */