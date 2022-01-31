package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.c.c;
import com.tencent.mm.plugin.aa.a.c.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI
  extends BaseAAPresenterActivity
{
  private String cpf;
  private ak faV;
  private c gqi;
  private ListView gqj;
  private TextView gqk;
  private TextView gql;
  private View gqm;
  private TextView gqn;
  private boolean gqo;
  private Map<String, String> gqp;
  private LaunchAAByPersonAmountSelectUI.a gqq;
  private double gqr;
  private long gqs;
  private int gqt;
  private boolean gqu;
  private boolean gqv;
  private Runnable gqw;
  
  public LaunchAAByPersonAmountSelectUI()
  {
    AppMethodBeat.i(40805);
    this.gqi = ((c)T(c.class));
    this.gqo = false;
    this.gqp = new HashMap();
    this.gqq = null;
    this.gqs = -1L;
    this.gqt = -1;
    this.gqv = false;
    this.faV = new ak(Looper.getMainLooper());
    this.gqw = new LaunchAAByPersonAmountSelectUI.1(this);
    AppMethodBeat.o(40805);
  }
  
  private void apf()
  {
    AppMethodBeat.i(40807);
    try
    {
      this.gqr = 0.0D;
      this.gqu = false;
      if (this.gqp == null) {
        break label267;
      }
      Iterator localIterator = this.gqp.values().iterator();
      while (localIterator.hasNext())
      {
        double d = bo.getDouble((String)localIterator.next(), 0.0D);
        this.gqr += d;
        if ((this.gqs > 0L) && (d * 100.0D > this.gqs)) {
          this.gqu = true;
        }
      }
      if (this.gqq == null) {
        break label267;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(40807);
      return;
    }
    Object localObject2 = this.gqq;
    Object localObject1 = this.gqp;
    Object localObject3 = ((LaunchAAByPersonAmountSelectUI.a)localObject2).dataList.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((LaunchAAByPersonAmountSelectUI.b)((Iterator)localObject3).next()).gqE = "";
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject2 = ((LaunchAAByPersonAmountSelectUI.a)localObject2).dataList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LaunchAAByPersonAmountSelectUI.b)((Iterator)localObject2).next();
        if (((Map)localObject1).containsKey(((LaunchAAByPersonAmountSelectUI.b)localObject3).username)) {
          ((LaunchAAByPersonAmountSelectUI.b)localObject3).gqE = ((String)((Map)localObject1).get(((LaunchAAByPersonAmountSelectUI.b)localObject3).username));
        }
      }
    }
    label267:
    this.gql.setText(getString(2131301032, new Object[] { Double.valueOf(this.gqr) }));
    if ((this.gqp != null) && (this.gqp.size() > 0)) {
      updateOptionMenuText(233, getString(2131296350, new Object[] { Integer.valueOf(this.gqp.size()) }));
    }
    while (this.gqu)
    {
      h.qsU.e(13722, new Object[] { Integer.valueOf(7) });
      enableOptionMenu(233, false);
      localObject1 = getString(2131301045, new Object[] { Float.valueOf((float)this.gqs / 100.0F) });
      if (!bo.isNullOrNil((String)localObject1))
      {
        this.gqn.setText((CharSequence)localObject1);
        if (!this.gqn.isShown())
        {
          this.gqn.startAnimation(AnimationUtils.loadAnimation(this, 2131034194));
          this.gqn.setVisibility(0);
        }
      }
      AppMethodBeat.o(40807);
      return;
      updateOptionMenuText(233, getString(2131297018));
    }
    enableOptionMenu(233, true);
    if (this.gqn.isShown())
    {
      this.gqn.setText("");
      this.gqn.startAnimation(AnimationUtils.loadAnimation(this, 2131034214));
      this.gqn.setVisibility(8);
    }
    AppMethodBeat.o(40807);
  }
  
  private void apg()
  {
    AppMethodBeat.i(40808);
    if (this.gqr > 0.0D)
    {
      this.gqo = true;
      this.gqk.setTextColor(getResources().getColor(2131689794));
      AppMethodBeat.o(40808);
      return;
    }
    this.gqo = false;
    this.gqk.setTextColor(getResources().getColor(2131689793));
    AppMethodBeat.o(40808);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969965;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40806);
    super.onCreate(paramBundle);
    setMMTitle(2131301033);
    setBackBtn(new LaunchAAByPersonAmountSelectUI.2(this));
    addTextOptionMenu(233, getString(2131297018), new LaunchAAByPersonAmountSelectUI.3(this), null, q.b.zby);
    this.gqj = ((ListView)findViewById(2131825368));
    this.gqk = ((TextView)findViewById(2131825370));
    this.gql = ((TextView)findViewById(2131825371));
    this.gql.setText(getString(2131301032, new Object[] { Float.valueOf(0.0F) }));
    this.gqm = findViewById(2131825369);
    this.gqn = ((TextView)findViewById(2131825372));
    this.gqb = this.gqj;
    this.gqm.setVisibility(8);
    this.gqk.setOnTouchListener(new LaunchAAByPersonAmountSelectUI.5(this));
    this.gqk.setOnClickListener(new LaunchAAByPersonAmountSelectUI.6(this));
    this.gqo = true;
    this.gqj.setOnScrollListener(new LaunchAAByPersonAmountSelectUI.7(this));
    this.cpf = getIntent().getStringExtra("chatroom");
    this.gqs = getIntent().getLongExtra("maxPerAmount", -1L);
    this.gqt = getIntent().getIntExtra("maxUserNumber", -1);
    Object localObject = getIntent().getStringArrayListExtra("oldAmountData");
    ab.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", new Object[] { this.cpf, Long.valueOf(this.gqs), localObject });
    this.gqp = new HashMap();
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
              double d = bo.getDouble(arrayOfString[1], 0.0D);
              paramBundle.put(arrayOfString[0], Double.valueOf(d));
              this.gqp.put(arrayOfString[0], getString(2131296341, new Object[] { Double.valueOf(d) }));
            }
          }
        }
        this.gqi.az(c.a.class);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", new Object[] { localException.getMessage() });
      }
    }
    this.gqi.a(c.a.class, new LaunchAAByPersonAmountSelectUI.4(this, paramBundle));
    AppMethodBeat.o(40806);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40809);
    super.onDestroy();
    if (this.gqp != null) {
      this.gqp.clear();
    }
    AppMethodBeat.o(40809);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI
 * JD-Core Version:    0.7.0.1
 */