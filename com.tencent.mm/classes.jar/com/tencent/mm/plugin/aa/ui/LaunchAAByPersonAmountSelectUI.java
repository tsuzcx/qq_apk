package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.b.c;
import com.tencent.mm.plugin.aa.model.b.c.a;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.z;
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
  private String dmU;
  private ap gIf;
  private HashMap<String, Double> iUh;
  private c iVV;
  private ListView iVW;
  private TextView iVX;
  private TextView iVY;
  private View iVZ;
  private TextView iWa;
  private boolean iWb;
  private Map<String, String> iWc;
  private a iWd;
  private double iWe;
  private long iWf;
  private int iWg;
  private boolean iWh;
  private boolean iWi;
  private Runnable iWj;
  private int scene;
  
  public LaunchAAByPersonAmountSelectUI()
  {
    AppMethodBeat.i(63606);
    this.iVV = ((c)aq(c.class));
    this.iWb = false;
    this.iWc = new HashMap();
    this.iWd = null;
    this.iWf = -1L;
    this.iWg = -1;
    this.iWi = false;
    this.gIf = new ap(Looper.getMainLooper());
    this.iWj = new Runnable()
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
  
  private void aRB()
  {
    AppMethodBeat.i(63608);
    try
    {
      this.iWe = 0.0D;
      this.iWh = false;
      if (this.iWc == null) {
        break label267;
      }
      Iterator localIterator = this.iWc.values().iterator();
      while (localIterator.hasNext())
      {
        double d = bt.getDouble((String)localIterator.next(), 0.0D);
        this.iWe += d;
        if ((this.iWf > 0L) && (d * 100.0D > this.iWf)) {
          this.iWh = true;
        }
      }
      if (this.iWd == null) {
        break label267;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(63608);
      return;
    }
    Object localObject2 = this.iWd;
    Object localObject1 = this.iWc;
    Object localObject3 = ((a)localObject2).dataList.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((b)((Iterator)localObject3).next()).iWt = "";
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject2 = ((a)localObject2).dataList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if (((Map)localObject1).containsKey(((b)localObject3).username)) {
          ((b)localObject3).iWt = ((String)((Map)localObject1).get(((b)localObject3).username));
        }
      }
    }
    label267:
    this.iVY.setText(getString(2131760641, new Object[] { Double.valueOf(this.iWe) }));
    if ((this.iWc != null) && (this.iWc.size() > 0)) {
      updateOptionMenuText(233, getString(2131755030, new Object[] { Integer.valueOf(this.iWc.size()) }));
    }
    while (this.iWh)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(13722, new Object[] { Integer.valueOf(7) });
      enableOptionMenu(233, false);
      localObject1 = getString(2131760660, new Object[] { Float.valueOf((float)this.iWf / 100.0F) });
      if (!bt.isNullOrNil((String)localObject1))
      {
        this.iWa.setText((CharSequence)localObject1);
        if (!this.iWa.isShown())
        {
          this.iWa.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
          this.iWa.setVisibility(0);
        }
      }
      AppMethodBeat.o(63608);
      return;
      updateOptionMenuText(233, getString(2131755835));
    }
    if ((this.iWc != null) && (this.iWc.size() > 0)) {
      enableOptionMenu(233, true);
    }
    for (;;)
    {
      if (this.iWa.isShown())
      {
        this.iWa.setText("");
        this.iWa.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
        this.iWa.setVisibility(8);
      }
      AppMethodBeat.o(63608);
      return;
      enableOptionMenu(233, false);
    }
  }
  
  private void aRC()
  {
    AppMethodBeat.i(63609);
    if (this.iWe > 0.0D)
    {
      this.iWb = true;
      this.iVX.setTextColor(getResources().getColor(2131100053));
      AppMethodBeat.o(63609);
      return;
    }
    this.iWb = false;
    this.iVX.setTextColor(getResources().getColor(2131100052));
    AppMethodBeat.o(63609);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494547;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63607);
    super.onCreate(paramBundle);
    setMMTitle(2131760642);
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
            if ((localDouble == null) || (bt.getDouble((String)LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).get(str), 0.0D) != localDouble.doubleValue())) {
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
            h.a(LaunchAAByPersonAmountSelectUI.this, LaunchAAByPersonAmountSelectUI.this.getString(2131755066), null, LaunchAAByPersonAmountSelectUI.this.getString(2131755070), LaunchAAByPersonAmountSelectUI.this.getString(2131755069), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    addTextOptionMenu(233, getString(2131755835), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63591);
        if ((LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this) > 0) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this)))
        {
          h.c(LaunchAAByPersonAmountSelectUI.this.getContext(), LaunchAAByPersonAmountSelectUI.this.getString(2131760646, new Object[] { Integer.valueOf(LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.g.yhR.f(13722, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(63591);
          return true;
        }
        LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
        com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
        AppMethodBeat.o(63591);
        return true;
      }
    }, null, s.b.JbS);
    this.iVW = ((ListView)findViewById(2131296662));
    this.iVX = ((TextView)findViewById(2131298347));
    this.iVY = ((TextView)findViewById(2131296663));
    this.iVY.setText(getString(2131760641, new Object[] { Float.valueOf(0.0F) }));
    this.iVZ = findViewById(2131305552);
    this.iWa = ((TextView)findViewById(2131296635));
    this.iVL = this.iVW;
    this.iVZ.setVisibility(8);
    this.iVX.setOnTouchListener(new LaunchAAByPersonAmountSelectUI.5(this));
    this.iVX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63596);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > 0)) {}
        try
        {
          paramAnonymousView = new d.a(LaunchAAByPersonAmountSelectUI.this);
          paramAnonymousView.afi(2131755022);
          paramAnonymousView.afl(2131755835).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63594);
              LaunchAAByPersonAmountSelectUI.n(LaunchAAByPersonAmountSelectUI.this);
              AppMethodBeat.o(63594);
            }
          });
          paramAnonymousView.afm(2131755691).d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63595);
              com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(10) });
              AppMethodBeat.o(63595);
            }
          });
          paramAnonymousView.fMb().show();
          com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(8) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63596);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ad.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
          }
        }
      }
    });
    this.iWb = true;
    this.iVW.setOnScrollListener(new LaunchAAByPersonAmountSelectUI.7(this));
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.dmU = getIntent().getStringExtra("chatroom");
    this.iWf = getIntent().getLongExtra("maxPerAmount", -1L);
    this.iWg = getIntent().getIntExtra("maxUserNumber", -1);
    ad.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, ", new Object[] { this.dmU, Long.valueOf(this.iWf) });
    this.iVV.bk(c.a.class);
    this.iVV.a(c.a.class, new com.tencent.mm.vending.app.a.b() {});
    AppMethodBeat.o(63607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63610);
    super.onDestroy();
    if (this.iWc != null) {
      this.iWc.clear();
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
        for (localb.iWt = LaunchAAByPersonAmountSelectUI.this.getString(2131755021, new Object[] { localObject.get(str) });; localb.iWt = "")
        {
          this.dataList.add(localb);
          break;
        }
      }
      AppMethodBeat.o(63600);
    }
    
    private LaunchAAByPersonAmountSelectUI.b ri(int paramInt)
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
      LaunchAAByPersonAmountSelectUI.b localb = ri(paramInt);
      View localView = paramView;
      if (localb != null)
      {
        localView = paramView;
        if (!bt.isNullOrNil(localb.username))
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = z.jO(LaunchAAByPersonAmountSelectUI.this).inflate(2131494546, paramViewGroup, false);
            paramView = new a((byte)0);
            paramView.iWp = ((LinearLayout)localView.findViewById(2131304239));
            paramView.fRd = ((ImageView)localView.findViewById(2131296996));
            paramView.hbU = ((TextView)localView.findViewById(2131306252));
            paramView.iWq = ((TextView)localView.findViewById(2131308016));
            paramView.iVS = ((WalletFormView)localView.findViewById(2131302444));
            paramView.iWr = ((TextView)localView.findViewById(2131301322));
            paramView.iWs = new LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this, localb.username);
            paramView.iVS.a(paramView.iWs);
            paramView.fRd.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63598);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                localb.bd(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
                paramView.iVS.d(LaunchAAByPersonAmountSelectUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(63598);
                return false;
              }
            });
            paramView.hbU.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63599);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                localb.bd(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
                paramView.iVS.d(LaunchAAByPersonAmountSelectUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(63599);
                return false;
              }
            });
            localView.setTag(paramView);
            LaunchAAByPersonAmountSelectUI.this.setEditFocusListener(paramView.iVS, 2, false, true);
          }
          paramView = (a)localView.getTag();
          if (!bt.isNullOrNil(localb.username))
          {
            paramView.iWs.username = localb.username;
            com.tencent.mm.pluginsdk.ui.a.b.c(paramView.fRd, localb.username);
            paramView.hbU.setText(k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.hbU.getTextSize()));
          }
          if ((localb.iWt != null) && (paramView.iVS.getText() != null) && (!localb.iWt.equals(paramView.iVS.getText().toLowerCase())))
          {
            paramViewGroup = paramView.iVS;
            LaunchAAByPersonAmountSelectUI.c localc = paramView.iWs;
            if (paramViewGroup.LAy != null) {
              paramViewGroup.LAy.removeTextChangedListener(localc);
            }
            paramView.iVS.setText(localb.iWt);
            paramView.iVS.a(paramView.iWs);
          }
          if (paramInt != 0) {
            break label714;
          }
          paramView.iWp.setBackgroundResource(2131232844);
          if (!am.aSQ(localb.username)) {
            break label755;
          }
          paramView.fRd.setAlpha(0.3F);
          paramView.hbU.setAlpha(0.3F);
          paramView.iWr.setAlpha(0.3F);
          paramView.iVS.setAlpha(0.15F);
          paramView.fRd.setAlpha(0.3F);
          paramView.fRd.setOnTouchListener(null);
          paramView.hbU.setAlpha(0.3F);
          paramView.hbU.setOnTouchListener(null);
          paramView.iWr.setAlpha(0.3F);
          paramView.iVS.setAlpha(0.15F);
          paramView.iVS.findViewById(2131306718).setFocusable(false);
          paramView.iVS.findViewById(2131306718).setFocusableInTouchMode(false);
          paramView.iVS.findViewById(2131306718).setClickable(false);
          paramViewGroup = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(localb.username));
          paramView.iWq.setVisibility(0);
          paramView.iWq.setText(paramViewGroup);
          paramView.iWq.setAlpha(0.3F);
          ad.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s,subName:%s", new Object[] { k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.hbU.getTextSize()).toString(), localb.username, paramViewGroup });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63603);
        return localView;
        label714:
        if (paramInt == this.dataList.size() - 1)
        {
          paramView.iWp.setBackgroundResource(2131232845);
          break;
        }
        paramView.iWp.setBackgroundResource(2131232843);
        break;
        label755:
        paramView.fRd.setAlpha(1.0F);
        paramView.hbU.setAlpha(1.0F);
        paramView.iWr.setAlpha(1.0F);
        paramView.iVS.setAlpha(1.0F);
        paramView.fRd.setAlpha(1.0F);
        paramView.fRd.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(198908);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            paramView.iVS.d(LaunchAAByPersonAmountSelectUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198908);
            return false;
          }
        });
        paramView.hbU.setAlpha(1.0F);
        paramView.hbU.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(198909);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            paramView.iVS.d(LaunchAAByPersonAmountSelectUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198909);
            return false;
          }
        });
        paramView.iWr.setAlpha(1.0F);
        paramView.iVS.setAlpha(1.0F);
        paramView.iVS.findViewById(2131306718).setFocusable(true);
        paramView.iVS.findViewById(2131306718).setFocusableInTouchMode(true);
        paramView.iVS.findViewById(2131306718).setClickable(true);
        paramView.iWq.setVisibility(4);
        ad.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s", new Object[] { k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.hbU.getTextSize()).toString(), localb.username });
      }
    }
    
    final class a
    {
      ImageView fRd;
      TextView hbU;
      WalletFormView iVS;
      LinearLayout iWp;
      TextView iWq;
      TextView iWr;
      LaunchAAByPersonAmountSelectUI.c iWs;
      
      private a() {}
    }
  }
  
  final class b
  {
    String iWt = null;
    String username = null;
    
    private b() {}
  }
  
  protected final class c
    implements TextWatcher
  {
    String username;
    
    public c(String paramString)
    {
      this.username = paramString;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(63605);
      try
      {
        if (paramEditable.toString().startsWith(".")) {
          paramEditable.insert(0, "0");
        }
        String str = paramEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 2)) {
          paramEditable.delete(i + 3, j);
        }
        int k = str.lastIndexOf(".");
        if ((k != i) && (k > 0) && (j > k)) {
          paramEditable.delete(k, j);
        }
      }
      catch (Exception localException)
      {
        label105:
        break label105;
      }
      if ((!bt.ai(paramEditable)) && (bt.getDouble(paramEditable.toString(), 0.0D) > 0.0D)) {
        LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).put(this.username, paramEditable.toString());
      }
      for (;;)
      {
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).removeCallbacks(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this));
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).postDelayed(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this), 50L);
        if (LaunchAAByPersonAmountSelectUI.o(LaunchAAByPersonAmountSelectUI.this)) {
          i.rf(3);
        }
        AppMethodBeat.o(63605);
        return;
        LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).remove(this.username);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI
 * JD-Core Version:    0.7.0.1
 */