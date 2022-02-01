package com.tencent.mm.plugin.aa.ui;

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
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.b.c.a;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LaunchAAByPersonAmountSelectUI
  extends BaseAAPresenterActivity
{
  private String hCy;
  private MMHandler mRi;
  private HashMap<String, Double> pHQ;
  private boolean pKA;
  private Runnable pKB;
  private com.tencent.mm.plugin.aa.model.b.c pKn;
  private ListView pKo;
  private TextView pKp;
  private TextView pKq;
  private View pKr;
  private TextView pKs;
  private boolean pKt;
  private Map<String, String> pKu;
  private a pKv;
  private double pKw;
  private long pKx;
  private int pKy;
  private boolean pKz;
  private int scene;
  
  public LaunchAAByPersonAmountSelectUI()
  {
    AppMethodBeat.i(63606);
    this.pKn = ((com.tencent.mm.plugin.aa.model.b.c)aM(com.tencent.mm.plugin.aa.model.b.c.class));
    this.pKt = false;
    this.pKu = new HashMap();
    this.pKv = null;
    this.pKx = -1L;
    this.pKy = -1;
    this.pKA = false;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.pKB = new Runnable()
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
  
  private void bVE()
  {
    AppMethodBeat.i(63608);
    try
    {
      this.pKw = 0.0D;
      this.pKz = false;
      if (this.pKu == null) {
        break label267;
      }
      Iterator localIterator = this.pKu.values().iterator();
      while (localIterator.hasNext())
      {
        double d = Util.getDouble((String)localIterator.next(), 0.0D);
        this.pKw += d;
        if ((this.pKx > 0L) && (d * 100.0D > this.pKx)) {
          this.pKz = true;
        }
      }
      if (this.pKv == null) {
        break label267;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(63608);
      return;
    }
    Object localObject2 = this.pKv;
    Object localObject1 = this.pKu;
    Object localObject3 = ((a)localObject2).dataList.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((b)((Iterator)localObject3).next()).pKL = "";
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject2 = ((a)localObject2).dataList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if (((Map)localObject1).containsKey(((b)localObject3).username)) {
          ((b)localObject3).pKL = ((String)((Map)localObject1).get(((b)localObject3).username));
        }
      }
    }
    label267:
    this.pKq.setText(getString(a.i.launch_aa_by_person_amount_select_summary, new Object[] { Double.valueOf(this.pKw) }));
    if ((this.pKu != null) && (this.pKu.size() > 0))
    {
      updateOptionMenuText(233, getString(a.i.aa_confirm_num, new Object[] { Integer.valueOf(this.pKu.size()) }));
      if (!this.pKz) {
        break label559;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(7) });
      enableOptionMenu(233, false);
      localObject1 = getString(a.i.launch_aa_money_exceed_avg_amount_alert, new Object[] { Float.valueOf((float)this.pKx / 100.0F) });
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.pKs.setText((CharSequence)localObject1);
        if (!this.pKs.isShown())
        {
          localObject1 = AnimationUtils.loadAnimation(this, a.a.in_from_up);
          ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(268512);
              LaunchAAByPersonAmountSelectUI.p(LaunchAAByPersonAmountSelectUI.this).sendAccessibilityEvent(128);
              AppMethodBeat.o(268512);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          this.pKs.startAnimation((Animation)localObject1);
          this.pKs.setVisibility(0);
          localObject1 = (RelativeLayout.LayoutParams)this.pKo.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 55);
          this.pKo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    label671:
    for (;;)
    {
      if (this.pKp.getRight() > this.pKq.getLeft()) {
        this.pKq.setMaxEms(this.pKq.length() / 2);
      }
      AppMethodBeat.o(63608);
      return;
      updateOptionMenuText(233, getString(a.i.app_ok));
      break;
      label559:
      if ((this.pKu != null) && (this.pKu.size() > 0)) {
        enableOptionMenu(233, true);
      }
      for (;;)
      {
        if (!this.pKs.isShown()) {
          break label671;
        }
        this.pKs.setText("");
        this.pKs.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
        this.pKs.setVisibility(8);
        localObject1 = (RelativeLayout.LayoutParams)this.pKo.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 0);
        this.pKo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        enableOptionMenu(233, false);
      }
    }
  }
  
  private void bVF()
  {
    AppMethodBeat.i(63609);
    if (this.pKw > 0.0D)
    {
      this.pKt = true;
      this.pKp.setTextColor(getResources().getColor(a.c.link_color));
      AppMethodBeat.o(63609);
      return;
    }
    this.pKt = false;
    bVG();
    AppMethodBeat.o(63609);
  }
  
  private void bVG()
  {
    AppMethodBeat.i(268518);
    if (!aw.isDarkMode())
    {
      this.pKp.setTextColor(Color.parseColor("#4c576B95"));
      AppMethodBeat.o(268518);
      return;
    }
    this.pKp.setTextColor(Color.parseColor("#4c7D90A9"));
    AppMethodBeat.o(268518);
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
            k.a(LaunchAAByPersonAmountSelectUI.this, LaunchAAByPersonAmountSelectUI.this.getString(a.i.aa_select_contact_back_confirm), null, LaunchAAByPersonAmountSelectUI.this.getString(a.i.aa_select_contact_save), LaunchAAByPersonAmountSelectUI.this.getString(a.i.aa_select_contact_not_save), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
          k.c(LaunchAAByPersonAmountSelectUI.this.getContext(), LaunchAAByPersonAmountSelectUI.this.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(LaunchAAByPersonAmountSelectUI.f(LaunchAAByPersonAmountSelectUI.this)) }), "", true);
          com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(63591);
          return true;
        }
        LaunchAAByPersonAmountSelectUI.e(LaunchAAByPersonAmountSelectUI.this);
        com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
        AppMethodBeat.o(63591);
        return true;
      }
    }, null, y.b.adEJ);
    this.pKo = ((ListView)findViewById(a.f.amount_select_list));
    this.pKp = ((TextView)findViewById(a.f.clear_amount));
    this.pKq = ((TextView)findViewById(a.f.amount_summary));
    this.pKq.setText(getString(a.i.launch_aa_by_person_amount_select_summary, new Object[] { Float.valueOf(0.0F) }));
    this.pKr = findViewById(a.f.summary_layout);
    this.pKs = ((TextView)findViewById(a.f.alert_tip_tv));
    this.pKd = this.pKo;
    this.pKr.setVisibility(8);
    aw.a(this.pKp.getPaint(), 0.8F);
    this.pKp.setOnTouchListener(new View.OnTouchListener()
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
    this.pKp.setOnClickListener(new LaunchAAByPersonAmountSelectUI.6(this));
    this.pKt = true;
    this.pKo.setOnScrollListener(new LaunchAAByPersonAmountSelectUI.7(this));
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    this.hCy = getIntent().getStringExtra("chatroom");
    this.pKx = getIntent().getLongExtra("maxPerAmount", -1L);
    this.pKy = getIntent().getIntExtra("maxUserNumber", -1);
    Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, ", new Object[] { this.hCy, Long.valueOf(this.pKx) });
    this.pKn.ct(c.a.class);
    this.pKn.a(c.a.class, new com.tencent.mm.vending.app.a.b() {});
    AppMethodBeat.o(63607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63610);
    super.onDestroy();
    if (this.pKu != null) {
      this.pKu.clear();
    }
    AppMethodBeat.o(63610);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(268589);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.aa.model.a.class);
    AppMethodBeat.o(268589);
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
        for (localb.pKL = LaunchAAByPersonAmountSelectUI.this.getString(a.i.aa_amount_format, new Object[] { localObject.get(str) });; localb.pKL = "")
        {
          this.dataList.add(localb);
          break;
        }
      }
      AppMethodBeat.o(63600);
    }
    
    private LaunchAAByPersonAmountSelectUI.b yl(int paramInt)
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
      LaunchAAByPersonAmountSelectUI.b localb = yl(paramInt);
      View localView = paramView;
      if (localb != null)
      {
        localView = paramView;
        if (!Util.isNullOrNil(localb.username))
        {
          localView = paramView;
          if (paramView == null)
          {
            localView = af.mU(LaunchAAByPersonAmountSelectUI.this).inflate(a.g.launch_aa_by_person_amount_select_row, paramViewGroup, false);
            paramView = new a((byte)0);
            paramView.pKH = ((LinearLayout)localView.findViewById(a.f.root));
            paramView.lKK = ((ImageView)localView.findViewById(a.f.avatar));
            paramView.nnW = ((TextView)localView.findViewById(a.f.username));
            paramView.pKI = ((TextView)localView.findViewById(a.f.subname));
            paramView.pKk = ((WalletFormView)localView.findViewById(a.f.money_edit));
            paramView.pKJ = ((TextView)localView.findViewById(a.f.launch_aa_by_person_money_unit));
            paramView.pKK = new LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this, localb.username, paramView.pKk);
            paramView.pKk.a(paramView.pKK);
            paramView.pKH.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63598);
                paramView.pKk.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63598);
                return false;
              }
            });
            paramView.lKK.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(63599);
                paramView.pKk.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(63599);
                return false;
              }
            });
            paramView.nnW.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(268562);
                paramView.pKk.d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.o(268562);
                return false;
              }
            });
            paramView.pKk.setAccessibilityDelegate(new com.tencent.mm.wallet_core.c()
            {
              public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
              {
                AppMethodBeat.i(268559);
                super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
                paramAnonymousAccessibilityNodeInfo.setClassName(EditText.class.getName());
                String str = paramView.pKk.getContentEt().getText().toString();
                paramAnonymousView = str;
                if (str.length() == 0) {
                  paramAnonymousView = "0";
                }
                paramAnonymousAccessibilityNodeInfo.setContentDescription(paramAnonymousView + LaunchAAByPersonAmountSelectUI.this.getString(a.i.launch_aa_by_person_money_edit_unit));
                AppMethodBeat.o(268559);
              }
            });
            paramView.pKk.getContentEt().setImportantForAccessibility(2);
            localView.setTag(paramView);
            LaunchAAByPersonAmountSelectUI.this.setEditFocusListener(paramView.pKk, 2, false, true);
          }
          paramView = (a)localView.getTag();
          if (!Util.isNullOrNil(localb.username))
          {
            paramView.pKK.username = localb.username;
            com.tencent.mm.pluginsdk.ui.a.b.g(paramView.lKK, localb.username);
            paramView.nnW.setText(p.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)com.tencent.mm.kernel.h.ax(b.class)).aV(localb.username, LaunchAAByPersonAmountSelectUI.s(LaunchAAByPersonAmountSelectUI.this)), paramView.nnW.getTextSize()));
          }
          if ((localb.pKL != null) && (paramView.pKk.getText() != null) && (!localb.pKL.equals(paramView.pKk.getText().toLowerCase())))
          {
            paramViewGroup = paramView.pKk;
            LaunchAAByPersonAmountSelectUI.c localc = paramView.pKK;
            if (paramViewGroup.agVJ != null) {
              paramViewGroup.agVJ.removeTextChangedListener(localc);
            }
            paramView.pKk.setText(localb.pKL);
            paramView.pKk.a(paramView.pKK);
          }
          if ((paramView.pKk == null) || (paramView.pKk.getText() == null) || (i.b(paramView.pKk.getText(), "100", RoundingMode.HALF_UP) <= LaunchAAByPersonAmountSelectUI.q(LaunchAAByPersonAmountSelectUI.this))) {
            break label825;
          }
          paramView.pKk.setContentTextColorRes(a.c.Red);
          if (paramInt != 0) {
            break label838;
          }
          paramView.pKH.setBackgroundResource(a.e.launch_aa_by_person_circle_bg_header);
          label540:
          if (!au.bwO(localb.username)) {
            break label879;
          }
          paramView.lKK.setAlpha(0.3F);
          paramView.nnW.setAlpha(0.3F);
          paramView.pKJ.setAlpha(0.3F);
          paramView.pKk.setAlpha(0.15F);
          paramView.lKK.setAlpha(0.3F);
          paramView.lKK.setOnTouchListener(null);
          paramView.nnW.setAlpha(0.3F);
          paramView.nnW.setOnTouchListener(null);
          paramView.pKJ.setAlpha(0.3F);
          paramView.pKk.setAlpha(0.15F);
          paramView.pKk.findViewById(a.f.wallet_content).setFocusable(false);
          paramView.pKk.findViewById(a.f.wallet_content).setFocusableInTouchMode(false);
          paramView.pKk.findViewById(a.f.wallet_content).setClickable(false);
          paramViewGroup = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(localb.username));
          paramView.pKI.setVisibility(0);
          paramView.pKI.setText(paramViewGroup);
          paramView.pKI.setAlpha(0.3F);
          Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s,subName:%s", new Object[] { p.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)com.tencent.mm.kernel.h.ax(b.class)).aV(localb.username, LaunchAAByPersonAmountSelectUI.s(LaunchAAByPersonAmountSelectUI.this)), paramView.nnW.getTextSize()).toString(), localb.username, paramViewGroup });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63603);
        return localView;
        label825:
        paramView.pKk.setContentTextColorRes(a.c.normal_text_color);
        break;
        label838:
        if (paramInt == this.dataList.size() - 1)
        {
          paramView.pKH.setBackgroundResource(a.e.launch_aa_by_person_circle_bg_tail);
          break label540;
        }
        paramView.pKH.setBackgroundResource(a.e.launch_aa_by_person_circle_bg);
        break label540;
        label879:
        paramView.lKK.setAlpha(1.0F);
        paramView.nnW.setAlpha(1.0F);
        paramView.pKJ.setAlpha(1.0F);
        paramView.pKk.setAlpha(1.0F);
        paramView.lKK.setAlpha(1.0F);
        paramView.lKK.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(268554);
            paramView.pKk.d(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(268554);
            return false;
          }
        });
        paramView.nnW.setAlpha(1.0F);
        paramView.nnW.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(268557);
            paramView.pKk.d(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(268557);
            return false;
          }
        });
        paramView.pKJ.setAlpha(1.0F);
        paramView.pKk.setAlpha(1.0F);
        paramView.pKk.findViewById(a.f.wallet_content).setFocusable(true);
        paramView.pKk.findViewById(a.f.wallet_content).setFocusableInTouchMode(true);
        paramView.pKk.findViewById(a.f.wallet_content).setClickable(true);
        paramView.pKI.setVisibility(4);
        Log.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "username：%s，data.username：%s", new Object[] { p.b(LaunchAAByPersonAmountSelectUI.this.getContext(), ((b)com.tencent.mm.kernel.h.ax(b.class)).aV(localb.username, LaunchAAByPersonAmountSelectUI.s(LaunchAAByPersonAmountSelectUI.this)), paramView.nnW.getTextSize()).toString(), localb.username });
      }
    }
    
    final class a
    {
      ImageView lKK;
      TextView nnW;
      LinearLayout pKH;
      TextView pKI;
      TextView pKJ;
      LaunchAAByPersonAmountSelectUI.c pKK;
      WalletFormView pKk;
      
      private a() {}
    }
  }
  
  final class b
  {
    String pKL = null;
    String username = null;
    
    private b() {}
  }
  
  protected final class c
    implements TextWatcher
  {
    private WalletFormView pKk;
    String username;
    
    public c(String paramString, WalletFormView paramWalletFormView)
    {
      this.username = paramString;
      this.pKk = paramWalletFormView;
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
        if ((this.pKk == null) || (i.b(this.pKk.getText(), "100", RoundingMode.HALF_UP) <= LaunchAAByPersonAmountSelectUI.q(LaunchAAByPersonAmountSelectUI.this))) {
          break label347;
        }
        this.pKk.setContentTextColorRes(a.c.Red);
      }
      for (;;)
      {
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).removeCallbacks(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this));
        LaunchAAByPersonAmountSelectUI.k(LaunchAAByPersonAmountSelectUI.this).postDelayed(LaunchAAByPersonAmountSelectUI.j(LaunchAAByPersonAmountSelectUI.this), 50L);
        if (LaunchAAByPersonAmountSelectUI.r(LaunchAAByPersonAmountSelectUI.this)) {
          j.yj(3);
        }
        AppMethodBeat.o(63605);
        return;
        LaunchAAByPersonAmountSelectUI.c(LaunchAAByPersonAmountSelectUI.this).remove(this.username);
        break;
        this.pKk.setContentTextColorRes(a.c.normal_text_color);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI
 * JD-Core Version:    0.7.0.1
 */