package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
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
import com.tencent.mm.plugin.aa.model.b.c;
import com.tencent.mm.plugin.aa.model.b.c.a;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.y;
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
  private String dec;
  private ap gAC;
  private HashMap<String, Double> iaU;
  private c icD;
  private ListView icE;
  private TextView icF;
  private TextView icG;
  private View icH;
  private TextView icI;
  private boolean icJ;
  private Map<String, String> icK;
  private a icL;
  private double icM;
  private long icN;
  private int icO;
  private boolean icP;
  private boolean icQ;
  private Runnable icR;
  private int scene;
  
  public LaunchAAByPersonAmountSelectUI()
  {
    AppMethodBeat.i(63606);
    this.icD = ((c)aq(c.class));
    this.icJ = false;
    this.icK = new HashMap();
    this.icL = null;
    this.icN = -1L;
    this.icO = -1;
    this.icQ = false;
    this.gAC = new ap(Looper.getMainLooper());
    this.icR = new Runnable()
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
  
  private void aHA()
  {
    AppMethodBeat.i(63609);
    if (this.icM > 0.0D)
    {
      this.icJ = true;
      this.icF.setTextColor(getResources().getColor(2131100053));
      AppMethodBeat.o(63609);
      return;
    }
    this.icJ = false;
    this.icF.setTextColor(getResources().getColor(2131100052));
    AppMethodBeat.o(63609);
  }
  
  private void aHz()
  {
    AppMethodBeat.i(63608);
    try
    {
      this.icM = 0.0D;
      this.icP = false;
      if (this.icK == null) {
        break label267;
      }
      Iterator localIterator = this.icK.values().iterator();
      while (localIterator.hasNext())
      {
        double d = bt.getDouble((String)localIterator.next(), 0.0D);
        this.icM += d;
        if ((this.icN > 0L) && (d * 100.0D > this.icN)) {
          this.icP = true;
        }
      }
      if (this.icL == null) {
        break label267;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(63608);
      return;
    }
    Object localObject2 = this.icL;
    Object localObject1 = this.icK;
    Object localObject3 = ((a)localObject2).dataList.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((b)((Iterator)localObject3).next()).icZ = "";
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject2 = ((a)localObject2).dataList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if (((Map)localObject1).containsKey(((b)localObject3).username)) {
          ((b)localObject3).icZ = ((String)((Map)localObject1).get(((b)localObject3).username));
        }
      }
    }
    label267:
    this.icG.setText(getString(2131760641, new Object[] { Double.valueOf(this.icM) }));
    if ((this.icK != null) && (this.icK.size() > 0)) {
      updateOptionMenuText(233, getString(2131755030, new Object[] { Integer.valueOf(this.icK.size()) }));
    }
    while (this.icP)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(13722, new Object[] { Integer.valueOf(7) });
      enableOptionMenu(233, false);
      localObject1 = getString(2131760660, new Object[] { Float.valueOf((float)this.icN / 100.0F) });
      if (!bt.isNullOrNil((String)localObject1))
      {
        this.icI.setText((CharSequence)localObject1);
        if (!this.icI.isShown())
        {
          this.icI.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
          this.icI.setVisibility(0);
        }
      }
      AppMethodBeat.o(63608);
      return;
      updateOptionMenuText(233, getString(2131755835));
    }
    if ((this.icK != null) && (this.icK.size() > 0)) {
      enableOptionMenu(233, true);
    }
    for (;;)
    {
      if (this.icI.isShown())
      {
        this.icI.setText("");
        this.icI.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
        this.icI.setVisibility(8);
      }
      AppMethodBeat.o(63608);
      return;
      enableOptionMenu(233, false);
    }
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
          com.tencent.mm.plugin.report.service.h.vKh.f(13722, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(63591);
          return true;
        }
        LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
        com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
        AppMethodBeat.o(63591);
        return true;
      }
    }, null, r.b.FOB);
    this.icE = ((ListView)findViewById(2131296662));
    this.icF = ((TextView)findViewById(2131298347));
    this.icG = ((TextView)findViewById(2131296663));
    this.icG.setText(getString(2131760641, new Object[] { Float.valueOf(0.0F) }));
    this.icH = findViewById(2131305552);
    this.icI = ((TextView)findViewById(2131296635));
    this.ics = this.icE;
    this.icH.setVisibility(8);
    this.icF.setOnTouchListener(new View.OnTouchListener()
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
    this.icF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63596);
        if ((LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > 0)) {}
        try
        {
          paramAnonymousView = new d.a(LaunchAAByPersonAmountSelectUI.this);
          paramAnonymousView.aay(2131755022);
          paramAnonymousView.aaB(2131755835).b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63594);
              LaunchAAByPersonAmountSelectUI.n(LaunchAAByPersonAmountSelectUI.this);
              AppMethodBeat.o(63594);
            }
          });
          paramAnonymousView.aaC(2131755691).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63595);
              com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(10) });
              AppMethodBeat.o(63595);
            }
          });
          paramAnonymousView.fft().show();
          com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(8) });
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
    this.icJ = true;
    this.icE.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.dec = getIntent().getStringExtra("chatroom");
    this.icN = getIntent().getLongExtra("maxPerAmount", -1L);
    this.icO = getIntent().getIntExtra("maxUserNumber", -1);
    ad.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, ", new Object[] { this.dec, Long.valueOf(this.icN) });
    this.icD.bf(c.a.class);
    this.icD.a(c.a.class, new com.tencent.mm.vending.app.a.b() {});
    AppMethodBeat.o(63607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63610);
    super.onDestroy();
    if (this.icK != null) {
      this.icK.clear();
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
        for (localb.icZ = LaunchAAByPersonAmountSelectUI.this.getString(2131755021, new Object[] { localObject.get(str) });; localb.icZ = "")
        {
          this.dataList.add(localb);
          break;
        }
      }
      AppMethodBeat.o(63600);
    }
    
    private LaunchAAByPersonAmountSelectUI.b pV(int paramInt)
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
      LaunchAAByPersonAmountSelectUI.b localb = pV(paramInt);
      View localView = paramView;
      if (localb != null)
      {
        localView = paramView;
        if (!bt.isNullOrNil(localb.username))
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = y.js(LaunchAAByPersonAmountSelectUI.this).inflate(2131494546, paramViewGroup, false);
            paramView = new a((byte)0);
            paramView.icX = ((LinearLayout)localView.findViewById(2131304239));
            paramView.fuj = ((ImageView)localView.findViewById(2131296996));
            paramView.icz = ((TextView)localView.findViewById(2131306252));
            paramView.icA = ((WalletFormView)localView.findViewById(2131302444));
            paramView.icY = new LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this, localb.username);
            paramView.icA.a(paramView.icY);
            paramView.fuj.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63598);
                paramView.icA.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63598);
                return false;
              }
            });
            paramView.icz.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63599);
                paramView.icA.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63599);
                return false;
              }
            });
            localView.setTag(paramView);
            LaunchAAByPersonAmountSelectUI.this.setEditFocusListener(paramView.icA, 2, false, true);
          }
          paramView = (a)localView.getTag();
          if (!bt.isNullOrNil(localb.username))
          {
            paramView.icY.username = localb.username;
            com.tencent.mm.pluginsdk.ui.a.b.c(paramView.fuj, localb.username);
            paramView.icz.setText(k.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)g.ab(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this)), paramView.icz.getTextSize()));
          }
          if ((localb.icZ != null) && (paramView.icA.getText() != null) && (!localb.icZ.equals(paramView.icA.getText().toLowerCase())))
          {
            paramViewGroup = paramView.icA;
            LaunchAAByPersonAmountSelectUI.c localc = paramView.icY;
            if (paramViewGroup.IfT != null) {
              paramViewGroup.IfT.removeTextChangedListener(localc);
            }
            paramView.icA.setText(localb.icZ);
            paramView.icA.a(paramView.icY);
          }
          if (paramInt != 0) {
            break label410;
          }
          paramView.icX.setBackgroundResource(2131232844);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63603);
        return localView;
        label410:
        if (paramInt == this.dataList.size() - 1) {
          paramView.icX.setBackgroundResource(2131232845);
        } else {
          paramView.icX.setBackgroundResource(2131232843);
        }
      }
    }
    
    final class a
    {
      ImageView fuj;
      WalletFormView icA;
      LinearLayout icX;
      LaunchAAByPersonAmountSelectUI.c icY;
      TextView icz;
      
      private a() {}
    }
  }
  
  final class b
  {
    String icZ = null;
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
          i.pS(3);
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