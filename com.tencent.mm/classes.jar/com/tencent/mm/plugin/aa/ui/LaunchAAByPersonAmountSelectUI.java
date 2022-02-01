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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.aa.model.b.c;
import com.tencent.mm.plugin.aa.model.b.c.a;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  private String dby;
  private ao gox;
  private HashMap<String, Double> iAX;
  private c iCL;
  private ListView iCM;
  private TextView iCN;
  private TextView iCO;
  private View iCP;
  private TextView iCQ;
  private boolean iCR;
  private Map<String, String> iCS;
  private a iCT;
  private double iCU;
  private long iCV;
  private int iCW;
  private boolean iCX;
  private boolean iCY;
  private Runnable iCZ;
  private int scene;
  
  public LaunchAAByPersonAmountSelectUI()
  {
    AppMethodBeat.i(63606);
    this.iCL = ((c)aq(c.class));
    this.iCR = false;
    this.iCS = new HashMap();
    this.iCT = null;
    this.iCV = -1L;
    this.iCW = -1;
    this.iCY = false;
    this.gox = new ao(Looper.getMainLooper());
    this.iCZ = new Runnable()
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
  
  private void aOp()
  {
    AppMethodBeat.i(63608);
    try
    {
      this.iCU = 0.0D;
      this.iCX = false;
      if (this.iCS == null) {
        break label267;
      }
      Iterator localIterator = this.iCS.values().iterator();
      while (localIterator.hasNext())
      {
        double d = bs.getDouble((String)localIterator.next(), 0.0D);
        this.iCU += d;
        if ((this.iCV > 0L) && (d * 100.0D > this.iCV)) {
          this.iCX = true;
        }
      }
      if (this.iCT == null) {
        break label267;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(63608);
      return;
    }
    Object localObject2 = this.iCT;
    Object localObject1 = this.iCS;
    Object localObject3 = ((a)localObject2).dataList.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((b)((Iterator)localObject3).next()).iDj = "";
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject2 = ((a)localObject2).dataList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if (((Map)localObject1).containsKey(((b)localObject3).username)) {
          ((b)localObject3).iDj = ((String)((Map)localObject1).get(((b)localObject3).username));
        }
      }
    }
    label267:
    this.iCO.setText(getString(2131760641, new Object[] { Double.valueOf(this.iCU) }));
    if ((this.iCS != null) && (this.iCS.size() > 0)) {
      updateOptionMenuText(233, getString(2131755030, new Object[] { Integer.valueOf(this.iCS.size()) }));
    }
    while (this.iCX)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(13722, new Object[] { Integer.valueOf(7) });
      enableOptionMenu(233, false);
      localObject1 = getString(2131760660, new Object[] { Float.valueOf((float)this.iCV / 100.0F) });
      if (!bs.isNullOrNil((String)localObject1))
      {
        this.iCQ.setText((CharSequence)localObject1);
        if (!this.iCQ.isShown())
        {
          this.iCQ.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
          this.iCQ.setVisibility(0);
        }
      }
      AppMethodBeat.o(63608);
      return;
      updateOptionMenuText(233, getString(2131755835));
    }
    if ((this.iCS != null) && (this.iCS.size() > 0)) {
      enableOptionMenu(233, true);
    }
    for (;;)
    {
      if (this.iCQ.isShown())
      {
        this.iCQ.setText("");
        this.iCQ.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
        this.iCQ.setVisibility(8);
      }
      AppMethodBeat.o(63608);
      return;
      enableOptionMenu(233, false);
    }
  }
  
  private void aOq()
  {
    AppMethodBeat.i(63609);
    if (this.iCU > 0.0D)
    {
      this.iCR = true;
      this.iCN.setTextColor(getResources().getColor(2131100053));
      AppMethodBeat.o(63609);
      return;
    }
    this.iCR = false;
    this.iCN.setTextColor(getResources().getColor(2131100052));
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
            if ((localDouble == null) || (bs.getDouble((String)LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).get(str), 0.0D) != localDouble.doubleValue())) {
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
            com.tencent.mm.ui.base.h.a(LaunchAAByPersonAmountSelectUI.this, LaunchAAByPersonAmountSelectUI.this.getString(2131755066), null, LaunchAAByPersonAmountSelectUI.this.getString(2131755070), LaunchAAByPersonAmountSelectUI.this.getString(2131755069), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
          com.tencent.mm.ui.base.h.c(LaunchAAByPersonAmountSelectUI.this.getContext(), LaunchAAByPersonAmountSelectUI.this.getString(2131760646, new Object[] { Integer.valueOf(LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.h.wUl.f(13722, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(63591);
          return true;
        }
        LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
        com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
        AppMethodBeat.o(63591);
        return true;
      }
    }, null, s.b.Hom);
    this.iCM = ((ListView)findViewById(2131296662));
    this.iCN = ((TextView)findViewById(2131298347));
    this.iCO = ((TextView)findViewById(2131296663));
    this.iCO.setText(getString(2131760641, new Object[] { Float.valueOf(0.0F) }));
    this.iCP = findViewById(2131305552);
    this.iCQ = ((TextView)findViewById(2131296635));
    this.iCB = this.iCM;
    this.iCP.setVisibility(8);
    this.iCN.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(63593);
        if (!LaunchAAByPersonAmountSelectUI.l(LaunchAAByPersonAmountSelectUI.this))
        {
          AppMethodBeat.o(63593);
          return true;
        }
        if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 2)) {
          LaunchAAByPersonAmountSelectUI.m(LaunchAAByPersonAmountSelectUI.this).setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(2131100054));
        }
        for (;;)
        {
          AppMethodBeat.o(63593);
          return false;
          if (LaunchAAByPersonAmountSelectUI.l(LaunchAAByPersonAmountSelectUI.this)) {
            LaunchAAByPersonAmountSelectUI.m(LaunchAAByPersonAmountSelectUI.this).setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(2131100053));
          } else {
            LaunchAAByPersonAmountSelectUI.m(LaunchAAByPersonAmountSelectUI.this).setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(2131100052));
          }
        }
      }
    });
    this.iCN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63596);
        if ((LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > 0)) {}
        try
        {
          paramAnonymousView = new d.a(LaunchAAByPersonAmountSelectUI.this);
          paramAnonymousView.acJ(2131755022);
          paramAnonymousView.acM(2131755835).b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63594);
              LaunchAAByPersonAmountSelectUI.n(LaunchAAByPersonAmountSelectUI.this);
              AppMethodBeat.o(63594);
            }
          });
          paramAnonymousView.acN(2131755691).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63595);
              com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(10) });
              AppMethodBeat.o(63595);
            }
          });
          paramAnonymousView.fvp().show();
          com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(8) });
          AppMethodBeat.o(63596);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ac.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
          }
        }
      }
    });
    this.iCR = true;
    this.iCM.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(63597);
        if (paramAnonymousInt == 1) {
          LaunchAAByPersonAmountSelectUI.this.hideTenpayKB();
        }
        AppMethodBeat.o(63597);
      }
    });
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.dby = getIntent().getStringExtra("chatroom");
    this.iCV = getIntent().getLongExtra("maxPerAmount", -1L);
    this.iCW = getIntent().getIntExtra("maxUserNumber", -1);
    ac.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, ", new Object[] { this.dby, Long.valueOf(this.iCV) });
    this.iCL.bi(c.a.class);
    this.iCL.a(c.a.class, new com.tencent.mm.vending.app.a.b() {});
    AppMethodBeat.o(63607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63610);
    super.onDestroy();
    if (this.iCS != null) {
      this.iCS.clear();
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
        for (localb.iDj = LaunchAAByPersonAmountSelectUI.this.getString(2131755021, new Object[] { localObject.get(str) });; localb.iDj = "")
        {
          this.dataList.add(localb);
          break;
        }
      }
      AppMethodBeat.o(63600);
    }
    
    private LaunchAAByPersonAmountSelectUI.b qI(int paramInt)
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
      LaunchAAByPersonAmountSelectUI.b localb = qI(paramInt);
      View localView = paramView;
      if (localb != null)
      {
        localView = paramView;
        if (!bs.isNullOrNil(localb.username))
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = z.jD(LaunchAAByPersonAmountSelectUI.this).inflate(2131494546, paramViewGroup, false);
            paramView = new a((byte)0);
            paramView.iDf = ((LinearLayout)localView.findViewById(2131304239));
            paramView.fxQ = ((ImageView)localView.findViewById(2131296996));
            paramView.gIk = ((TextView)localView.findViewById(2131306252));
            paramView.iDg = ((TextView)localView.findViewById(2131308016));
            paramView.iCI = ((WalletFormView)localView.findViewById(2131302444));
            paramView.iDh = ((TextView)localView.findViewById(2131301322));
            paramView.iDi = new LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this, localb.username);
            paramView.iCI.a(paramView.iDi);
            paramView.fxQ.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63598);
                paramView.iCI.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63598);
                return false;
              }
            });
            paramView.gIk.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63599);
                paramView.iCI.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63599);
                return false;
              }
            });
            localView.setTag(paramView);
            LaunchAAByPersonAmountSelectUI.this.setEditFocusListener(paramView.iCI, 2, false, true);
          }
          paramView = (a)localView.getTag();
          if (!bs.isNullOrNil(localb.username))
          {
            paramView.iDi.username = localb.username;
            com.tencent.mm.pluginsdk.ui.a.b.c(paramView.fxQ, localb.username);
            paramView.gIk.setText(com.tencent.mm.pluginsdk.ui.span.k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)g.ab(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.gIk.getTextSize()));
          }
          if ((localb.iDj != null) && (paramView.iCI.getText() != null) && (!localb.iDj.equals(paramView.iCI.getText().toLowerCase())))
          {
            paramViewGroup = paramView.iCI;
            LaunchAAByPersonAmountSelectUI.c localc = paramView.iDi;
            if (paramViewGroup.JHv != null) {
              paramViewGroup.JHv.removeTextChangedListener(localc);
            }
            paramView.iCI.setText(localb.iDj);
            paramView.iCI.a(paramView.iDi);
          }
          if (paramInt != 0) {
            break label714;
          }
          paramView.iDf.setBackgroundResource(2131232844);
          if (!ai.aNc(localb.username)) {
            break label755;
          }
          paramView.fxQ.setAlpha(0.3F);
          paramView.gIk.setAlpha(0.3F);
          paramView.iDh.setAlpha(0.3F);
          paramView.iCI.setAlpha(0.15F);
          paramView.fxQ.setAlpha(0.3F);
          paramView.fxQ.setOnTouchListener(null);
          paramView.gIk.setAlpha(0.3F);
          paramView.gIk.setOnTouchListener(null);
          paramView.iDh.setAlpha(0.3F);
          paramView.iCI.setAlpha(0.15F);
          paramView.iCI.findViewById(2131306718).setFocusable(false);
          paramView.iCI.findViewById(2131306718).setFocusableInTouchMode(false);
          paramView.iCI.findViewById(2131306718).setClickable(false);
          paramViewGroup = a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localb.username));
          paramView.iDg.setVisibility(0);
          paramView.iDg.setText(paramViewGroup);
          paramView.iDg.setAlpha(0.3F);
          ac.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s,subName:%s", new Object[] { com.tencent.mm.pluginsdk.ui.span.k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)g.ab(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.gIk.getTextSize()).toString(), localb.username, paramViewGroup });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63603);
        return localView;
        label714:
        if (paramInt == this.dataList.size() - 1)
        {
          paramView.iDf.setBackgroundResource(2131232845);
          break;
        }
        paramView.iDf.setBackgroundResource(2131232843);
        break;
        label755:
        paramView.fxQ.setAlpha(1.0F);
        paramView.gIk.setAlpha(1.0F);
        paramView.iDh.setAlpha(1.0F);
        paramView.iCI.setAlpha(1.0F);
        paramView.fxQ.setAlpha(1.0F);
        paramView.fxQ.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(207004);
            paramView.iCI.d(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(207004);
            return false;
          }
        });
        paramView.gIk.setAlpha(1.0F);
        paramView.gIk.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(207005);
            paramView.iCI.d(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(207005);
            return false;
          }
        });
        paramView.iDh.setAlpha(1.0F);
        paramView.iCI.setAlpha(1.0F);
        paramView.iCI.findViewById(2131306718).setFocusable(true);
        paramView.iCI.findViewById(2131306718).setFocusableInTouchMode(true);
        paramView.iCI.findViewById(2131306718).setClickable(true);
        paramView.iDg.setVisibility(4);
        ac.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s", new Object[] { com.tencent.mm.pluginsdk.ui.span.k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)g.ab(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.gIk.getTextSize()).toString(), localb.username });
      }
    }
    
    final class a
    {
      ImageView fxQ;
      TextView gIk;
      WalletFormView iCI;
      LinearLayout iDf;
      TextView iDg;
      TextView iDh;
      LaunchAAByPersonAmountSelectUI.c iDi;
      
      private a() {}
    }
  }
  
  final class b
  {
    String iDj = null;
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
      if ((!bs.aj(paramEditable)) && (bs.getDouble(paramEditable.toString(), 0.0D) > 0.0D)) {
        LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).put(this.username, paramEditable.toString());
      }
      for (;;)
      {
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).removeCallbacks(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this));
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).postDelayed(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this), 50L);
        if (LaunchAAByPersonAmountSelectUI.o(LaunchAAByPersonAmountSelectUI.this)) {
          i.qF(3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI
 * JD-Core Version:    0.7.0.1
 */