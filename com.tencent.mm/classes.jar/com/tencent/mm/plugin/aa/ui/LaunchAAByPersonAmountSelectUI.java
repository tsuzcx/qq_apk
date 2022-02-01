package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.b.c;
import com.tencent.mm.plugin.aa.model.b.c.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LaunchAAByPersonAmountSelectUI
  extends BaseAAPresenterActivity
{
  private String dFl;
  private MMHandler hAk;
  private HashMap<String, Double> jTW;
  private Map<String, String> jWA;
  private a jWB;
  private double jWC;
  private long jWD;
  private int jWE;
  private boolean jWF;
  private boolean jWG;
  private Runnable jWH;
  private c jWt;
  private ListView jWu;
  private TextView jWv;
  private TextView jWw;
  private View jWx;
  private TextView jWy;
  private boolean jWz;
  private int scene;
  
  public LaunchAAByPersonAmountSelectUI()
  {
    AppMethodBeat.i(63606);
    this.jWt = ((c)au(c.class));
    this.jWz = false;
    this.jWA = new HashMap();
    this.jWB = null;
    this.jWD = -1L;
    this.jWE = -1;
    this.jWG = false;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.jWH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63587);
        LaunchAAByPersonAmountSelectUI.a(LaunchAAByPersonAmountSelectUI.this);
        LaunchAAByPersonAmountSelectUI.b(LaunchAAByPersonAmountSelectUI.this);
        AppMethodBeat.o(63587);
      }
    };
    AppMethodBeat.o(63606);
  }
  
  private void bmG()
  {
    AppMethodBeat.i(63608);
    try
    {
      this.jWC = 0.0D;
      this.jWF = false;
      if (this.jWA == null) {
        break label267;
      }
      Iterator localIterator = this.jWA.values().iterator();
      while (localIterator.hasNext())
      {
        double d = Util.getDouble((String)localIterator.next(), 0.0D);
        this.jWC += d;
        if ((this.jWD > 0L) && (d * 100.0D > this.jWD)) {
          this.jWF = true;
        }
      }
      if (this.jWB == null) {
        break label267;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(63608);
      return;
    }
    Object localObject2 = this.jWB;
    Object localObject1 = this.jWA;
    Object localObject3 = ((a)localObject2).dataList.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((b)((Iterator)localObject3).next()).jWR = "";
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject2 = ((a)localObject2).dataList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if (((Map)localObject1).containsKey(((b)localObject3).username)) {
          ((b)localObject3).jWR = ((String)((Map)localObject1).get(((b)localObject3).username));
        }
      }
    }
    label267:
    this.jWw.setText(getString(2131762156, new Object[] { Double.valueOf(this.jWC) }));
    if ((this.jWA != null) && (this.jWA.size() > 0))
    {
      updateOptionMenuText(233, getString(2131755034, new Object[] { Integer.valueOf(this.jWA.size()) }));
      if (!this.jWF) {
        break label544;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(7) });
      enableOptionMenu(233, false);
      localObject1 = getString(2131762183, new Object[] { Float.valueOf((float)this.jWD / 100.0F) });
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.jWy.setText((CharSequence)localObject1);
        if (!this.jWy.isShown())
        {
          this.jWy.startAnimation(AnimationUtils.loadAnimation(this, 2130772081));
          this.jWy.setVisibility(0);
          localObject1 = (RelativeLayout.LayoutParams)this.jWu.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 55);
          this.jWu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    label656:
    for (;;)
    {
      if (this.jWv.getRight() > this.jWw.getLeft()) {
        this.jWw.setMaxEms(this.jWw.length() / 2);
      }
      AppMethodBeat.o(63608);
      return;
      updateOptionMenuText(233, getString(2131755921));
      break;
      label544:
      if ((this.jWA != null) && (this.jWA.size() > 0)) {
        enableOptionMenu(233, true);
      }
      for (;;)
      {
        if (!this.jWy.isShown()) {
          break label656;
        }
        this.jWy.setText("");
        this.jWy.startAnimation(AnimationUtils.loadAnimation(this, 2130772110));
        this.jWy.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.jWu.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 0);
        this.jWu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        enableOptionMenu(233, false);
      }
    }
  }
  
  private void bmH()
  {
    AppMethodBeat.i(63609);
    if (this.jWC > 0.0D)
    {
      this.jWz = true;
      this.jWv.setTextColor(getResources().getColor(2131100685));
      AppMethodBeat.o(63609);
      return;
    }
    this.jWz = false;
    bmI();
    AppMethodBeat.o(63609);
  }
  
  private void bmI()
  {
    AppMethodBeat.i(213018);
    if (!ao.isDarkMode())
    {
      this.jWv.setTextColor(Color.parseColor("#4c576B95"));
      AppMethodBeat.o(213018);
      return;
    }
    this.jWv.setTextColor(Color.parseColor("#4c7D90A9"));
    AppMethodBeat.o(213018);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495156;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63607);
    super.onCreate(paramBundle);
    setMMTitle(2131762157);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63590);
        if ((LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > 0))
        {
          if ((LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this) == null) || (LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this).size() != LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size())) {
            break label263;
          }
          paramAnonymousMenuItem = LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).keySet().iterator();
          i = 0;
          while (paramAnonymousMenuItem.hasNext())
          {
            String str = (String)paramAnonymousMenuItem.next();
            Double localDouble = (Double)LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this).get(str);
            if ((localDouble == null) || (Util.getDouble((String)LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).get(str), 0.0D) != localDouble.doubleValue())) {
              break;
            }
            i += 1;
          }
          if (i != LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size()) {
            break label263;
          }
        }
        label263:
        for (int i = 0;; i = 1)
        {
          if (i != 0) {
            com.tencent.mm.ui.base.h.a(LaunchAAByPersonAmountSelectUI.this, LaunchAAByPersonAmountSelectUI.this.getString(2131755077), null, LaunchAAByPersonAmountSelectUI.this.getString(2131755081), LaunchAAByPersonAmountSelectUI.this.getString(2131755080), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63588);
                LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63588);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63589);
                LaunchAAByPersonAmountSelectUI.this.finish();
                AppMethodBeat.o(63589);
              }
            });
          }
          for (;;)
          {
            AppMethodBeat.o(63590);
            return true;
            LaunchAAByPersonAmountSelectUI.this.finish();
            continue;
            LaunchAAByPersonAmountSelectUI.this.finish();
          }
        }
      }
    });
    addTextOptionMenu(233, getString(2131755921), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63591);
        if ((LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this) > 0) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this)))
        {
          com.tencent.mm.ui.base.h.c(LaunchAAByPersonAmountSelectUI.this.getContext(), LaunchAAByPersonAmountSelectUI.this.getString(2131762164, new Object[] { Integer.valueOf(LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(63591);
          return true;
        }
        LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
        com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
        AppMethodBeat.o(63591);
        return true;
      }
    }, null, t.b.OGU);
    this.jWu = ((ListView)findViewById(2131296739));
    this.jWv = ((TextView)findViewById(2131298743));
    this.jWw = ((TextView)findViewById(2131296740));
    this.jWw.setText(getString(2131762156, new Object[] { Float.valueOf(0.0F) }));
    this.jWx = findViewById(2131308773);
    this.jWy = ((TextView)findViewById(2131296712));
    this.jWj = this.jWu;
    this.jWx.setVisibility(8);
    ao.a(this.jWv.getPaint(), 0.8F);
    this.jWv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(63593);
        if (!LaunchAAByPersonAmountSelectUI.l(LaunchAAByPersonAmountSelectUI.this))
        {
          AppMethodBeat.o(63593);
          return true;
        }
        if (LaunchAAByPersonAmountSelectUI.l(LaunchAAByPersonAmountSelectUI.this)) {
          LaunchAAByPersonAmountSelectUI.m(LaunchAAByPersonAmountSelectUI.this).setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(2131100685));
        }
        for (;;)
        {
          AppMethodBeat.o(63593);
          return false;
          LaunchAAByPersonAmountSelectUI.n(LaunchAAByPersonAmountSelectUI.this);
        }
      }
    });
    this.jWv.setOnClickListener(new LaunchAAByPersonAmountSelectUI.6(this));
    this.jWz = true;
    this.jWu.setOnScrollListener(new LaunchAAByPersonAmountSelectUI.7(this));
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.dFl = getIntent().getStringExtra("chatroom");
    this.jWD = getIntent().getLongExtra("maxPerAmount", -1L);
    this.jWE = getIntent().getIntExtra("maxUserNumber", -1);
    Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, ", new Object[] { this.dFl, Long.valueOf(this.jWD) });
    this.jWt.bk(c.a.class);
    this.jWt.a(c.a.class, new com.tencent.mm.vending.app.a.b() {});
    AppMethodBeat.o(63607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63610);
    super.onDestroy();
    if (this.jWA != null) {
      this.jWA.clear();
    }
    AppMethodBeat.o(63610);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    List<LaunchAAByPersonAmountSelectUI.b> dataList;
    
    public a(Map<String, Double> paramMap)
    {
      AppMethodBeat.i(63600);
      this.dataList = null;
      this.dataList = new ArrayList();
      paramMap = paramMap.iterator();
      if (paramMap.hasNext())
      {
        String str = (String)paramMap.next();
        LaunchAAByPersonAmountSelectUI.b localb = new LaunchAAByPersonAmountSelectUI.b(LaunchAAByPersonAmountSelectUI.this, (byte)0);
        localb.username = str;
        Object localObject;
        if ((localObject != null) && (localObject.containsKey(str))) {}
        for (localb.jWR = LaunchAAByPersonAmountSelectUI.this.getString(2131755022, new Object[] { localObject.get(str) });; localb.jWR = "")
        {
          this.dataList.add(localb);
          break;
        }
      }
      AppMethodBeat.o(63600);
    }
    
    private LaunchAAByPersonAmountSelectUI.b vb(int paramInt)
    {
      AppMethodBeat.i(63602);
      LaunchAAByPersonAmountSelectUI.b localb = (LaunchAAByPersonAmountSelectUI.b)this.dataList.get(paramInt);
      AppMethodBeat.o(63602);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(63601);
      int i = this.dataList.size();
      AppMethodBeat.o(63601);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(63603);
      LaunchAAByPersonAmountSelectUI.b localb = vb(paramInt);
      View localView = paramView;
      if (localb != null)
      {
        localView = paramView;
        if (!Util.isNullOrNil(localb.username))
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = aa.jQ(LaunchAAByPersonAmountSelectUI.this).inflate(2131495155, paramViewGroup, false);
            paramView = new a((byte)0);
            paramView.jWN = ((LinearLayout)localView.findViewById(2131307157));
            paramView.gyr = ((ImageView)localView.findViewById(2131297119));
            paramView.hXv = ((TextView)localView.findViewById(2131309651));
            paramView.jWO = ((TextView)localView.findViewById(2131308732));
            paramView.jWq = ((WalletFormView)localView.findViewById(2131304845));
            paramView.jWP = ((TextView)localView.findViewById(2131303022));
            paramView.jWQ = new LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this, localb.username);
            paramView.jWq.a(paramView.jWQ);
            paramView.jWN.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63598);
                paramView.jWq.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63598);
                return false;
              }
            });
            paramView.gyr.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63599);
                paramView.jWq.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63599);
                return false;
              }
            });
            paramView.hXv.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(213015);
                paramView.jWq.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(213015);
                return false;
              }
            });
            localView.setTag(paramView);
            LaunchAAByPersonAmountSelectUI.this.setEditFocusListener(paramView.jWq, 2, false, true);
          }
          paramView = (a)localView.getTag();
          if (!Util.isNullOrNil(localb.username))
          {
            paramView.jWQ.username = localb.username;
            com.tencent.mm.pluginsdk.ui.a.b.c(paramView.gyr, localb.username);
            paramView.hXv.setText(com.tencent.mm.pluginsdk.ui.span.l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)g.af(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.q(LaunchAAByPersonAmountSelectUI.this)), paramView.hXv.getTextSize()));
          }
          if ((localb.jWR != null) && (paramView.jWq.getText() != null) && (!localb.jWR.equals(paramView.jWq.getText().toLowerCase())))
          {
            paramViewGroup = paramView.jWq;
            LaunchAAByPersonAmountSelectUI.c localc = paramView.jWQ;
            if (paramViewGroup.Rwe != null) {
              paramViewGroup.Rwe.removeTextChangedListener(localc);
            }
            paramView.jWq.setText(localb.jWR);
            paramView.jWq.a(paramView.jWQ);
          }
          if (paramInt != 0) {
            break label730;
          }
          paramView.jWN.setBackgroundResource(2131233298);
          if (!as.bjp(localb.username)) {
            break label771;
          }
          paramView.gyr.setAlpha(0.3F);
          paramView.hXv.setAlpha(0.3F);
          paramView.jWP.setAlpha(0.3F);
          paramView.jWq.setAlpha(0.15F);
          paramView.gyr.setAlpha(0.3F);
          paramView.gyr.setOnTouchListener(null);
          paramView.hXv.setAlpha(0.3F);
          paramView.hXv.setOnTouchListener(null);
          paramView.jWP.setAlpha(0.3F);
          paramView.jWq.setAlpha(0.15F);
          paramView.jWq.findViewById(2131310180).setFocusable(false);
          paramView.jWq.findViewById(2131310180).setFocusableInTouchMode(false);
          paramView.jWq.findViewById(2131310180).setClickable(false);
          paramViewGroup = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localb.username));
          paramView.jWO.setVisibility(0);
          paramView.jWO.setText(paramViewGroup);
          paramView.jWO.setAlpha(0.3F);
          Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s,subName:%s", new Object[] { com.tencent.mm.pluginsdk.ui.span.l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)g.af(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.q(LaunchAAByPersonAmountSelectUI.this)), paramView.hXv.getTextSize()).toString(), localb.username, paramViewGroup });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63603);
        return localView;
        label730:
        if (paramInt == this.dataList.size() - 1)
        {
          paramView.jWN.setBackgroundResource(2131233299);
          break;
        }
        paramView.jWN.setBackgroundResource(2131233297);
        break;
        label771:
        paramView.gyr.setAlpha(1.0F);
        paramView.hXv.setAlpha(1.0F);
        paramView.jWP.setAlpha(1.0F);
        paramView.jWq.setAlpha(1.0F);
        paramView.gyr.setAlpha(1.0F);
        paramView.gyr.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(213016);
            paramView.jWq.d(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(213016);
            return false;
          }
        });
        paramView.hXv.setAlpha(1.0F);
        paramView.hXv.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(213017);
            paramView.jWq.d(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(213017);
            return false;
          }
        });
        paramView.jWP.setAlpha(1.0F);
        paramView.jWq.setAlpha(1.0F);
        paramView.jWq.findViewById(2131310180).setFocusable(true);
        paramView.jWq.findViewById(2131310180).setFocusableInTouchMode(true);
        paramView.jWq.findViewById(2131310180).setClickable(true);
        paramView.jWO.setVisibility(4);
        Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s", new Object[] { com.tencent.mm.pluginsdk.ui.span.l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)g.af(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.q(LaunchAAByPersonAmountSelectUI.this)), paramView.hXv.getTextSize()).toString(), localb.username });
      }
    }
    
    final class a
    {
      ImageView gyr;
      TextView hXv;
      LinearLayout jWN;
      TextView jWO;
      TextView jWP;
      LaunchAAByPersonAmountSelectUI.c jWQ;
      WalletFormView jWq;
      
      private a() {}
    }
  }
  
  final class b
  {
    String jWR = null;
    String username = null;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI
 * JD-Core Version:    0.7.0.1
 */