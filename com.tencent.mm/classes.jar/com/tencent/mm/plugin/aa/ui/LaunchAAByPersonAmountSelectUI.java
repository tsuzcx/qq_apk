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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private String dnW;
  private aq gKO;
  private HashMap<String, Double> iXa;
  private c iYO;
  private ListView iYP;
  private TextView iYQ;
  private TextView iYR;
  private View iYS;
  private TextView iYT;
  private boolean iYU;
  private Map<String, String> iYV;
  private a iYW;
  private double iYX;
  private long iYY;
  private int iYZ;
  private boolean iZa;
  private boolean iZb;
  private Runnable iZc;
  private int scene;
  
  public LaunchAAByPersonAmountSelectUI()
  {
    AppMethodBeat.i(63606);
    this.iYO = ((c)aq(c.class));
    this.iYU = false;
    this.iYV = new HashMap();
    this.iYW = null;
    this.iYY = -1L;
    this.iYZ = -1;
    this.iZb = false;
    this.gKO = new aq(Looper.getMainLooper());
    this.iZc = new Runnable()
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
  
  private void aSa()
  {
    AppMethodBeat.i(63608);
    try
    {
      this.iYX = 0.0D;
      this.iZa = false;
      if (this.iYV == null) {
        break label267;
      }
      Iterator localIterator = this.iYV.values().iterator();
      while (localIterator.hasNext())
      {
        double d = bu.getDouble((String)localIterator.next(), 0.0D);
        this.iYX += d;
        if ((this.iYY > 0L) && (d * 100.0D > this.iYY)) {
          this.iZa = true;
        }
      }
      if (this.iYW == null) {
        break label267;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(63608);
      return;
    }
    Object localObject2 = this.iYW;
    Object localObject1 = this.iYV;
    Object localObject3 = ((a)localObject2).dataList.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((b)((Iterator)localObject3).next()).iZm = "";
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject2 = ((a)localObject2).dataList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if (((Map)localObject1).containsKey(((b)localObject3).username)) {
          ((b)localObject3).iZm = ((String)((Map)localObject1).get(((b)localObject3).username));
        }
      }
    }
    label267:
    this.iYR.setText(getString(2131760641, new Object[] { Double.valueOf(this.iYX) }));
    if ((this.iYV != null) && (this.iYV.size() > 0)) {
      updateOptionMenuText(233, getString(2131755030, new Object[] { Integer.valueOf(this.iYV.size()) }));
    }
    while (this.iZa)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(13722, new Object[] { Integer.valueOf(7) });
      enableOptionMenu(233, false);
      localObject1 = getString(2131760660, new Object[] { Float.valueOf((float)this.iYY / 100.0F) });
      if (!bu.isNullOrNil((String)localObject1))
      {
        this.iYT.setText((CharSequence)localObject1);
        if (!this.iYT.isShown())
        {
          this.iYT.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
          this.iYT.setVisibility(0);
        }
      }
      AppMethodBeat.o(63608);
      return;
      updateOptionMenuText(233, getString(2131755835));
    }
    if ((this.iYV != null) && (this.iYV.size() > 0)) {
      enableOptionMenu(233, true);
    }
    for (;;)
    {
      if (this.iYT.isShown())
      {
        this.iYT.setText("");
        this.iYT.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
        this.iYT.setVisibility(8);
      }
      AppMethodBeat.o(63608);
      return;
      enableOptionMenu(233, false);
    }
  }
  
  private void aSb()
  {
    AppMethodBeat.i(63609);
    if (this.iYX > 0.0D)
    {
      this.iYU = true;
      this.iYQ.setTextColor(getResources().getColor(2131100053));
      AppMethodBeat.o(63609);
      return;
    }
    this.iYU = false;
    this.iYQ.setTextColor(getResources().getColor(2131100052));
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
            if ((localDouble == null) || (bu.getDouble((String)LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).get(str), 0.0D) != localDouble.doubleValue())) {
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
          com.tencent.mm.plugin.report.service.g.yxI.f(13722, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(63591);
          return true;
        }
        LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
        com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
        AppMethodBeat.o(63591);
        return true;
      }
    }, null, s.b.JwA);
    this.iYP = ((ListView)findViewById(2131296662));
    this.iYQ = ((TextView)findViewById(2131298347));
    this.iYR = ((TextView)findViewById(2131296663));
    this.iYR.setText(getString(2131760641, new Object[] { Float.valueOf(0.0F) }));
    this.iYS = findViewById(2131305552);
    this.iYT = ((TextView)findViewById(2131296635));
    this.iYE = this.iYP;
    this.iYS.setVisibility(8);
    this.iYQ.setOnTouchListener(new LaunchAAByPersonAmountSelectUI.5(this));
    this.iYQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63596);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > 0)) {}
        try
        {
          paramAnonymousView = new d.a(LaunchAAByPersonAmountSelectUI.this);
          paramAnonymousView.afR(2131755022);
          paramAnonymousView.afU(2131755835).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63594);
              LaunchAAByPersonAmountSelectUI.n(LaunchAAByPersonAmountSelectUI.this);
              AppMethodBeat.o(63594);
            }
          });
          paramAnonymousView.afV(2131755691).d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63595);
              com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(10) });
              AppMethodBeat.o(63595);
            }
          });
          paramAnonymousView.fQv().show();
          com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(8) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63596);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ae.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
          }
        }
      }
    });
    this.iYU = true;
    this.iYP.setOnScrollListener(new LaunchAAByPersonAmountSelectUI.7(this));
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.dnW = getIntent().getStringExtra("chatroom");
    this.iYY = getIntent().getLongExtra("maxPerAmount", -1L);
    this.iYZ = getIntent().getIntExtra("maxUserNumber", -1);
    ae.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, ", new Object[] { this.dnW, Long.valueOf(this.iYY) });
    this.iYO.bk(c.a.class);
    this.iYO.a(c.a.class, new com.tencent.mm.vending.app.a.b() {});
    AppMethodBeat.o(63607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63610);
    super.onDestroy();
    if (this.iYV != null) {
      this.iYV.clear();
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
        for (localb.iZm = LaunchAAByPersonAmountSelectUI.this.getString(2131755021, new Object[] { localObject.get(str) });; localb.iZm = "")
        {
          this.dataList.add(localb);
          break;
        }
      }
      AppMethodBeat.o(63600);
    }
    
    private LaunchAAByPersonAmountSelectUI.b rl(int paramInt)
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
      LaunchAAByPersonAmountSelectUI.b localb = rl(paramInt);
      View localView = paramView;
      if (localb != null)
      {
        localView = paramView;
        if (!bu.isNullOrNil(localb.username))
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = z.jV(LaunchAAByPersonAmountSelectUI.this).inflate(2131494546, paramViewGroup, false);
            paramView = new a((byte)0);
            paramView.iZi = ((LinearLayout)localView.findViewById(2131304239));
            paramView.fTj = ((ImageView)localView.findViewById(2131296996));
            paramView.heI = ((TextView)localView.findViewById(2131306252));
            paramView.iZj = ((TextView)localView.findViewById(2131308016));
            paramView.iYL = ((WalletFormView)localView.findViewById(2131302444));
            paramView.iZk = ((TextView)localView.findViewById(2131301322));
            paramView.iZl = new LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this, localb.username);
            paramView.iYL.a(paramView.iZl);
            paramView.fTj.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63598);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                localb.bd(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
                paramView.iYL.d(LaunchAAByPersonAmountSelectUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(63598);
                return false;
              }
            });
            paramView.heI.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63599);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                localb.bd(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
                paramView.iYL.d(LaunchAAByPersonAmountSelectUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(63599);
                return false;
              }
            });
            localView.setTag(paramView);
            LaunchAAByPersonAmountSelectUI.this.setEditFocusListener(paramView.iYL, 2, false, true);
          }
          paramView = (a)localView.getTag();
          if (!bu.isNullOrNil(localb.username))
          {
            paramView.iZl.username = localb.username;
            com.tencent.mm.pluginsdk.ui.a.b.c(paramView.fTj, localb.username);
            paramView.heI.setText(k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.heI.getTextSize()));
          }
          if ((localb.iZm != null) && (paramView.iYL.getText() != null) && (!localb.iZm.equals(paramView.iYL.getText().toLowerCase())))
          {
            paramViewGroup = paramView.iYL;
            LaunchAAByPersonAmountSelectUI.c localc = paramView.iZl;
            if (paramViewGroup.LXo != null) {
              paramViewGroup.LXo.removeTextChangedListener(localc);
            }
            paramView.iYL.setText(localb.iZm);
            paramView.iYL.a(paramView.iZl);
          }
          if (paramInt != 0) {
            break label714;
          }
          paramView.iZi.setBackgroundResource(2131232844);
          if (!an.aUq(localb.username)) {
            break label755;
          }
          paramView.fTj.setAlpha(0.3F);
          paramView.heI.setAlpha(0.3F);
          paramView.iZk.setAlpha(0.3F);
          paramView.iYL.setAlpha(0.15F);
          paramView.fTj.setAlpha(0.3F);
          paramView.fTj.setOnTouchListener(null);
          paramView.heI.setAlpha(0.3F);
          paramView.heI.setOnTouchListener(null);
          paramView.iZk.setAlpha(0.3F);
          paramView.iYL.setAlpha(0.15F);
          paramView.iYL.findViewById(2131306718).setFocusable(false);
          paramView.iYL.findViewById(2131306718).setFocusableInTouchMode(false);
          paramView.iYL.findViewById(2131306718).setClickable(false);
          paramViewGroup = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(localb.username));
          paramView.iZj.setVisibility(0);
          paramView.iZj.setText(paramViewGroup);
          paramView.iZj.setAlpha(0.3F);
          ae.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s,subName:%s", new Object[] { k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.heI.getTextSize()).toString(), localb.username, paramViewGroup });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63603);
        return localView;
        label714:
        if (paramInt == this.dataList.size() - 1)
        {
          paramView.iZi.setBackgroundResource(2131232845);
          break;
        }
        paramView.iZi.setBackgroundResource(2131232843);
        break;
        label755:
        paramView.fTj.setAlpha(1.0F);
        paramView.heI.setAlpha(1.0F);
        paramView.iZk.setAlpha(1.0F);
        paramView.iYL.setAlpha(1.0F);
        paramView.fTj.setAlpha(1.0F);
        paramView.fTj.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(189742);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            paramView.iYL.d(LaunchAAByPersonAmountSelectUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(189742);
            return false;
          }
        });
        paramView.heI.setAlpha(1.0F);
        paramView.heI.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(189743);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            paramView.iYL.d(LaunchAAByPersonAmountSelectUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$AmountSelectListAdapter$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(189743);
            return false;
          }
        });
        paramView.iZk.setAlpha(1.0F);
        paramView.iYL.setAlpha(1.0F);
        paramView.iYL.findViewById(2131306718).setFocusable(true);
        paramView.iYL.findViewById(2131306718).setFocusableInTouchMode(true);
        paramView.iYL.findViewById(2131306718).setClickable(true);
        paramView.iZj.setVisibility(4);
        ae.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s", new Object[] { k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.heI.getTextSize()).toString(), localb.username });
      }
    }
    
    final class a
    {
      ImageView fTj;
      TextView heI;
      WalletFormView iYL;
      LinearLayout iZi;
      TextView iZj;
      TextView iZk;
      LaunchAAByPersonAmountSelectUI.c iZl;
      
      private a() {}
    }
  }
  
  final class b
  {
    String iZm = null;
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
      if ((!bu.ah(paramEditable)) && (bu.getDouble(paramEditable.toString(), 0.0D) > 0.0D)) {
        LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).put(this.username, paramEditable.toString());
      }
      for (;;)
      {
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).removeCallbacks(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this));
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).postDelayed(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this), 50L);
        if (LaunchAAByPersonAmountSelectUI.o(LaunchAAByPersonAmountSelectUI.this)) {
          i.ri(3);
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