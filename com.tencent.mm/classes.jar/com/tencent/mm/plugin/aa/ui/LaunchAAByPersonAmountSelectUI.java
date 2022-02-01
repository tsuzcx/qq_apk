package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mm.plugin.aa.model.b.c;
import com.tencent.mm.plugin.aa.model.b.c.a;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.math.RoundingMode;
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
  private String fxT;
  private MMHandler knk;
  private HashMap<String, Double> mLj;
  private c mNF;
  private ListView mNG;
  private TextView mNH;
  private TextView mNI;
  private View mNJ;
  private TextView mNK;
  private boolean mNL;
  private Map<String, String> mNM;
  private a mNN;
  private double mNO;
  private long mNP;
  private int mNQ;
  private boolean mNR;
  private boolean mNS;
  private Runnable mNT;
  private int scene;
  
  public LaunchAAByPersonAmountSelectUI()
  {
    AppMethodBeat.i(63606);
    this.mNF = ((c)at(c.class));
    this.mNL = false;
    this.mNM = new HashMap();
    this.mNN = null;
    this.mNP = -1L;
    this.mNQ = -1;
    this.mNS = false;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.mNT = new Runnable()
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
  
  private void bwO()
  {
    AppMethodBeat.i(63608);
    try
    {
      this.mNO = 0.0D;
      this.mNR = false;
      if (this.mNM == null) {
        break label267;
      }
      Iterator localIterator = this.mNM.values().iterator();
      while (localIterator.hasNext())
      {
        double d = Util.getDouble((String)localIterator.next(), 0.0D);
        this.mNO += d;
        if ((this.mNP > 0L) && (d * 100.0D > this.mNP)) {
          this.mNR = true;
        }
      }
      if (this.mNN == null) {
        break label267;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(63608);
      return;
    }
    Object localObject2 = this.mNN;
    Object localObject1 = this.mNM;
    Object localObject3 = ((a)localObject2).dataList.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((b)((Iterator)localObject3).next()).mOd = "";
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject2 = ((a)localObject2).dataList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if (((Map)localObject1).containsKey(((b)localObject3).username)) {
          ((b)localObject3).mOd = ((String)((Map)localObject1).get(((b)localObject3).username));
        }
      }
    }
    label267:
    this.mNI.setText(getString(a.i.launch_aa_by_person_amount_select_summary, new Object[] { Double.valueOf(this.mNO) }));
    if ((this.mNM != null) && (this.mNM.size() > 0))
    {
      updateOptionMenuText(233, getString(a.i.aa_confirm_num, new Object[] { Integer.valueOf(this.mNM.size()) }));
      if (!this.mNR) {
        break label545;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(7) });
      enableOptionMenu(233, false);
      localObject1 = getString(a.i.launch_aa_money_exceed_avg_amount_alert, new Object[] { Float.valueOf((float)this.mNP / 100.0F) });
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.mNK.setText((CharSequence)localObject1);
        if (!this.mNK.isShown())
        {
          this.mNK.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
          this.mNK.setVisibility(0);
          localObject1 = (RelativeLayout.LayoutParams)this.mNG.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 55);
          this.mNG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    label657:
    for (;;)
    {
      if (this.mNH.getRight() > this.mNI.getLeft()) {
        this.mNI.setMaxEms(this.mNI.length() / 2);
      }
      AppMethodBeat.o(63608);
      return;
      updateOptionMenuText(233, getString(a.i.app_ok));
      break;
      label545:
      if ((this.mNM != null) && (this.mNM.size() > 0)) {
        enableOptionMenu(233, true);
      }
      for (;;)
      {
        if (!this.mNK.isShown()) {
          break label657;
        }
        this.mNK.setText("");
        this.mNK.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
        this.mNK.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.mNG.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 0);
        this.mNG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        enableOptionMenu(233, false);
      }
    }
  }
  
  private void bwP()
  {
    AppMethodBeat.i(63609);
    if (this.mNO > 0.0D)
    {
      this.mNL = true;
      this.mNH.setTextColor(getResources().getColor(a.c.link_color));
      AppMethodBeat.o(63609);
      return;
    }
    this.mNL = false;
    bwQ();
    AppMethodBeat.o(63609);
  }
  
  private void bwQ()
  {
    AppMethodBeat.i(270217);
    if (!ar.isDarkMode())
    {
      this.mNH.setTextColor(Color.parseColor("#4c576B95"));
      AppMethodBeat.o(270217);
      return;
    }
    this.mNH.setTextColor(Color.parseColor("#4c7D90A9"));
    AppMethodBeat.o(270217);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.launch_aa_by_person_amount_select_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63607);
    super.onCreate(paramBundle);
    setMMTitle(a.i.launch_aa_by_person_amount_select_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63590);
        if ((LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > 0))
        {
          if ((LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this) == null) || (LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this).size() != LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size())) {
            break label266;
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
            break label266;
          }
        }
        label266:
        for (int i = 0;; i = 1)
        {
          if (i != 0) {
            com.tencent.mm.ui.base.h.a(LaunchAAByPersonAmountSelectUI.this, LaunchAAByPersonAmountSelectUI.this.getString(a.i.aa_select_contact_back_confirm), null, LaunchAAByPersonAmountSelectUI.this.getString(a.i.aa_select_contact_save), LaunchAAByPersonAmountSelectUI.this.getString(a.i.aa_select_contact_not_save), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    addTextOptionMenu(233, getString(a.i.app_ok), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63591);
        if ((LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this) > 0) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this) != null) && (LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).size() > LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this)))
        {
          com.tencent.mm.ui.base.h.c(LaunchAAByPersonAmountSelectUI.this.getContext(), LaunchAAByPersonAmountSelectUI.this.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(63591);
          return true;
        }
        LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
        com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
        AppMethodBeat.o(63591);
        return true;
      }
    }, null, w.b.Wao);
    this.mNG = ((ListView)findViewById(a.f.amount_select_list));
    this.mNH = ((TextView)findViewById(a.f.clear_amount));
    this.mNI = ((TextView)findViewById(a.f.amount_summary));
    this.mNI.setText(getString(a.i.launch_aa_by_person_amount_select_summary, new Object[] { Float.valueOf(0.0F) }));
    this.mNJ = findViewById(a.f.summary_layout);
    this.mNK = ((TextView)findViewById(a.f.alert_tip_tv));
    this.mNv = this.mNG;
    this.mNJ.setVisibility(8);
    ar.a(this.mNH.getPaint(), 0.8F);
    this.mNH.setOnTouchListener(new View.OnTouchListener()
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
          LaunchAAByPersonAmountSelectUI.m(LaunchAAByPersonAmountSelectUI.this).setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(a.c.link_color));
        }
        for (;;)
        {
          AppMethodBeat.o(63593);
          return false;
          LaunchAAByPersonAmountSelectUI.n(LaunchAAByPersonAmountSelectUI.this);
        }
      }
    });
    this.mNH.setOnClickListener(new LaunchAAByPersonAmountSelectUI.6(this));
    this.mNL = true;
    this.mNG.setOnScrollListener(new LaunchAAByPersonAmountSelectUI.7(this));
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.fxT = getIntent().getStringExtra("chatroom");
    this.mNP = getIntent().getLongExtra("maxPerAmount", -1L);
    this.mNQ = getIntent().getIntExtra("maxUserNumber", -1);
    Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, ", new Object[] { this.fxT, Long.valueOf(this.mNP) });
    this.mNF.bG(c.a.class);
    this.mNF.a(c.a.class, new com.tencent.mm.vending.app.a.b() {});
    AppMethodBeat.o(63607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63610);
    super.onDestroy();
    if (this.mNM != null) {
      this.mNM.clear();
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
        for (localb.mOd = LaunchAAByPersonAmountSelectUI.this.getString(a.i.aa_amount_format, new Object[] { localObject.get(str) });; localb.mOd = "")
        {
          this.dataList.add(localb);
          break;
        }
      }
      AppMethodBeat.o(63600);
    }
    
    private LaunchAAByPersonAmountSelectUI.b yf(int paramInt)
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
      LaunchAAByPersonAmountSelectUI.b localb = yf(paramInt);
      View localView = paramView;
      if (localb != null)
      {
        localView = paramView;
        if (!Util.isNullOrNil(localb.username))
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = ad.kS(LaunchAAByPersonAmountSelectUI.this).inflate(a.g.launch_aa_by_person_amount_select_row, paramViewGroup, false);
            paramView = new a((byte)0);
            paramView.mNZ = ((LinearLayout)localView.findViewById(a.f.root));
            paramView.jiu = ((ImageView)localView.findViewById(a.f.avatar));
            paramView.kMa = ((TextView)localView.findViewById(a.f.username));
            paramView.mOa = ((TextView)localView.findViewById(a.f.subname));
            paramView.mNC = ((WalletFormView)localView.findViewById(a.f.money_edit));
            paramView.mOb = ((TextView)localView.findViewById(a.f.launch_aa_by_person_money_unit));
            paramView.mOc = new LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this, localb.username, paramView.mNC);
            paramView.mNC.a(paramView.mOc);
            paramView.mNZ.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63598);
                paramView.mNC.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63598);
                return false;
              }
            });
            paramView.jiu.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63599);
                paramView.mNC.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63599);
                return false;
              }
            });
            paramView.kMa.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(270552);
                paramView.mNC.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(270552);
                return false;
              }
            });
            localView.setTag(paramView);
            LaunchAAByPersonAmountSelectUI.this.setEditFocusListener(paramView.mNC, 2, false, true);
          }
          paramView = (a)localView.getTag();
          if (!Util.isNullOrNil(localb.username))
          {
            paramView.mOc.username = localb.username;
            com.tencent.mm.pluginsdk.ui.a.b.c(paramView.jiu, localb.username);
            paramView.kMa.setText(l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)com.tencent.mm.kernel.h.ae(b.class)).aL(localb.username, LaunchAAByPersonAmountSelectUI.r(LaunchAAByPersonAmountSelectUI.this)), paramView.kMa.getTextSize()));
          }
          if ((localb.mOd != null) && (paramView.mNC.getText() != null) && (!localb.mOd.equals(paramView.mNC.getText().toLowerCase())))
          {
            paramViewGroup = paramView.mNC;
            LaunchAAByPersonAmountSelectUI.c localc = paramView.mOc;
            if (paramViewGroup.YXE != null) {
              paramViewGroup.YXE.removeTextChangedListener(localc);
            }
            paramView.mNC.setText(localb.mOd);
            paramView.mNC.a(paramView.mOc);
          }
          if ((paramView.mNC == null) || (paramView.mNC.getText() == null) || (g.b(paramView.mNC.getText(), "100", RoundingMode.HALF_UP) <= LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this))) {
            break label796;
          }
          paramView.mNC.setContentTextColorRes(a.c.Red);
          if (paramInt != 0) {
            break label809;
          }
          paramView.mNZ.setBackgroundResource(a.e.launch_aa_by_person_circle_bg_header);
          label512:
          if (!as.bvK(localb.username)) {
            break label850;
          }
          paramView.jiu.setAlpha(0.3F);
          paramView.kMa.setAlpha(0.3F);
          paramView.mOb.setAlpha(0.3F);
          paramView.mNC.setAlpha(0.15F);
          paramView.jiu.setAlpha(0.3F);
          paramView.jiu.setOnTouchListener(null);
          paramView.kMa.setAlpha(0.3F);
          paramView.kMa.setOnTouchListener(null);
          paramView.mOb.setAlpha(0.3F);
          paramView.mNC.setAlpha(0.15F);
          paramView.mNC.findViewById(a.f.wallet_content).setFocusable(false);
          paramView.mNC.findViewById(a.f.wallet_content).setFocusableInTouchMode(false);
          paramView.mNC.findViewById(a.f.wallet_content).setClickable(false);
          paramViewGroup = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(localb.username));
          paramView.mOa.setVisibility(0);
          paramView.mOa.setText(paramViewGroup);
          paramView.mOa.setAlpha(0.3F);
          Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s,subName:%s", new Object[] { l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)com.tencent.mm.kernel.h.ae(b.class)).aL(localb.username, LaunchAAByPersonAmountSelectUI.r(LaunchAAByPersonAmountSelectUI.this)), paramView.kMa.getTextSize()).toString(), localb.username, paramViewGroup });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63603);
        return localView;
        label796:
        paramView.mNC.setContentTextColorRes(a.c.normal_text_color);
        break;
        label809:
        if (paramInt == this.dataList.size() - 1)
        {
          paramView.mNZ.setBackgroundResource(a.e.launch_aa_by_person_circle_bg_tail);
          break label512;
        }
        paramView.mNZ.setBackgroundResource(a.e.launch_aa_by_person_circle_bg);
        break label512;
        label850:
        paramView.jiu.setAlpha(1.0F);
        paramView.kMa.setAlpha(1.0F);
        paramView.mOb.setAlpha(1.0F);
        paramView.mNC.setAlpha(1.0F);
        paramView.jiu.setAlpha(1.0F);
        paramView.jiu.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(269017);
            paramView.mNC.d(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(269017);
            return false;
          }
        });
        paramView.kMa.setAlpha(1.0F);
        paramView.kMa.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(227923);
            paramView.mNC.d(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(227923);
            return false;
          }
        });
        paramView.mOb.setAlpha(1.0F);
        paramView.mNC.setAlpha(1.0F);
        paramView.mNC.findViewById(a.f.wallet_content).setFocusable(true);
        paramView.mNC.findViewById(a.f.wallet_content).setFocusableInTouchMode(true);
        paramView.mNC.findViewById(a.f.wallet_content).setClickable(true);
        paramView.mOa.setVisibility(4);
        Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s", new Object[] { l.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)com.tencent.mm.kernel.h.ae(b.class)).aL(localb.username, LaunchAAByPersonAmountSelectUI.r(LaunchAAByPersonAmountSelectUI.this)), paramView.kMa.getTextSize()).toString(), localb.username });
      }
    }
    
    final class a
    {
      ImageView jiu;
      TextView kMa;
      WalletFormView mNC;
      LinearLayout mNZ;
      TextView mOa;
      TextView mOb;
      LaunchAAByPersonAmountSelectUI.c mOc;
      
      private a() {}
    }
  }
  
  final class b
  {
    String mOd = null;
    String username = null;
    
    private b() {}
  }
  
  protected final class c
    implements TextWatcher
  {
    private WalletFormView mNC;
    String username;
    
    public c(String paramString, WalletFormView paramWalletFormView)
    {
      this.username = paramString;
      this.mNC = paramWalletFormView;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(63605);
      try
      {
        String str = paramEditable.toString();
        if ((str.startsWith("0")) && (str.charAt(1) != '0') && (str.charAt(1) != '.')) {
          paramEditable.delete(0, 1);
        }
        if (str.startsWith(".")) {
          paramEditable.insert(0, "0");
        }
        if ((str.startsWith("0")) && (str.charAt(1) == '0')) {
          paramEditable.delete(1, str.length());
        }
        str = paramEditable.toString();
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
        label184:
        label347:
        break label184;
      }
      if ((!Util.isNullOrNil(paramEditable)) && (Util.getDouble(paramEditable.toString(), 0.0D) > 0.0D))
      {
        LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).put(this.username, paramEditable.toString());
        if ((this.mNC == null) || (g.b(this.mNC.getText(), "100", RoundingMode.HALF_UP) <= LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this))) {
          break label347;
        }
        this.mNC.setContentTextColorRes(a.c.Red);
      }
      for (;;)
      {
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).removeCallbacks(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this));
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).postDelayed(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this), 50L);
        if (LaunchAAByPersonAmountSelectUI.q(LaunchAAByPersonAmountSelectUI.this)) {
          i.yd(3);
        }
        AppMethodBeat.o(63605);
        return;
        LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).remove(this.username);
        break;
        this.mNC.setContentTextColorRes(a.c.normal_text_color);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI
 * JD-Core Version:    0.7.0.1
 */