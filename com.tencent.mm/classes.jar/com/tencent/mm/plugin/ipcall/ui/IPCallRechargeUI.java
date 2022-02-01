package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  TextView lDu;
  private ap mHandler;
  private String[] pKC;
  private j.a pKR;
  private int pKy;
  ProgressDialog uQp;
  private String[] uSR;
  private String[] uSS;
  private String uST;
  private String uSU;
  private boolean uSV;
  private int uSW;
  private int uSX;
  private String uSY;
  private String uSZ;
  private com.tencent.mm.plugin.ipcall.model.f.h uTa;
  private com.tencent.mm.plugin.ipcall.model.f.g uTb;
  private com.tencent.mm.plugin.ipcall.model.f.j uTc;
  RelativeLayout uTd;
  GridView uTe;
  ListView uTf;
  a uTg;
  Button uTh;
  com.tencent.mm.plugin.ipcall.model.e.f uTi;
  
  public IPCallRechargeUI()
  {
    AppMethodBeat.i(25888);
    this.uSV = false;
    this.pKy = -1;
    this.uSX = -1;
    this.uTa = new com.tencent.mm.plugin.ipcall.model.f.h();
    this.uTb = new com.tencent.mm.plugin.ipcall.model.f.g();
    this.uTc = new com.tencent.mm.plugin.ipcall.model.f.j();
    this.pKR = new j.a()
    {
      public final void R(ArrayList<p> paramAnonymousArrayList)
      {
        AppMethodBeat.i(25871);
        IPCallRechargeUI.a(IPCallRechargeUI.this).uOe = bt.flT();
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
        {
          IPCallRechargeUI.a(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          IPCallRechargeUI.b(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          p localp = (p)paramAnonymousArrayList.get(0);
          if (localp.EMb == 10232)
          {
            ad.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + paramAnonymousArrayList.size());
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            int i = 0;
            while (paramAnonymousArrayList.hasNext())
            {
              localp = (p)paramAnonymousArrayList.next();
              BigDecimal localBigDecimal = new BigDecimal(localp.EMa).divide(new BigDecimal(1000000));
              IPCallRechargeUI.b(IPCallRechargeUI.this)[i] = localBigDecimal.toString();
              IPCallRechargeUI.c(IPCallRechargeUI.this)[i] = localp.ELZ;
              i += 1;
            }
            if ((IPCallRechargeUI.d(IPCallRechargeUI.this) > 0) && (IPCallRechargeUI.c(IPCallRechargeUI.this).length > 0))
            {
              paramAnonymousArrayList = IPCallRechargeUI.c(IPCallRechargeUI.this)[0];
              if ((!bt.isNullOrNil(paramAnonymousArrayList)) && (!paramAnonymousArrayList.equals(IPCallRechargeUI.e(IPCallRechargeUI.this))))
              {
                ad.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.e(IPCallRechargeUI.this) + ",google wallet currency:" + paramAnonymousArrayList);
                IPCallRechargeUI.a(IPCallRechargeUI.this, paramAnonymousArrayList);
                AppMethodBeat.o(25871);
                return;
              }
            }
            if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
              IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
            }
            IPCallRechargeUI.this.deG();
            AppMethodBeat.o(25871);
            return;
          }
          if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
            IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
          }
          IPCallRechargeUI.a(IPCallRechargeUI.this, localp.EMb);
          ad.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(IPCallRechargeUI.this));
          IPCallRechargeUI.this.deG();
          AppMethodBeat.o(25871);
          return;
        }
        if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
          IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
        }
        ad.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
        IPCallRechargeUI.a(IPCallRechargeUI.this, 10236);
        IPCallRechargeUI.this.deG();
        AppMethodBeat.o(25871);
      }
    };
    this.mHandler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25873);
        switch (paramAnonymousMessage.what)
        {
        default: 
          ad.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
          AppMethodBeat.o(25873);
          return;
        }
        IPCallRechargeUI.this.uTf.setVisibility(0);
        IPCallRechargeUI.k(IPCallRechargeUI.this);
        AppMethodBeat.o(25873);
      }
    };
    AppMethodBeat.o(25888);
  }
  
  private void abS(String paramString)
  {
    AppMethodBeat.i(25893);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131760531);
    }
    com.tencent.mm.ui.base.h.d(this, str, getString(2131760531), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25893);
  }
  
  private void anQ(String paramString)
  {
    AppMethodBeat.i(25891);
    Object localObject = com.tencent.mm.plugin.ipcall.model.c.ddr().ddu();
    if (((List)localObject).size() == 0) {}
    for (localObject = a.aoa(com.tencent.mm.plugin.ipcall.a.c.dff());; localObject = a.aoa(((Integer)((List)localObject).get(0)).toString()))
    {
      this.uTi = new com.tencent.mm.plugin.ipcall.model.e.f((String)localObject, paramString);
      ba.aiU().a(this.uTi, 0);
      AppMethodBeat.o(25891);
      return;
    }
  }
  
  private boolean anR(String paramString)
  {
    AppMethodBeat.i(25894);
    if ((com.tencent.mm.plugin.ipcall.a.c.dfg()) && (this.uSX >= 0))
    {
      Object localObject = this.uTg.getItem(this.uSX);
      if (((localObject instanceof eai)) && (!bt.isNullOrNil(((eai)localObject).HNv)))
      {
        localObject = ((eai)localObject).HNv;
        ad.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(localObject)));
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131760531), getString(2131760506), getString(2131755691), true, new IPCallRechargeUI.2(this, (String)localObject), null);
        AppMethodBeat.o(25894);
        return true;
      }
    }
    AppMethodBeat.o(25894);
    return false;
  }
  
  public final void deG()
  {
    AppMethodBeat.i(25896);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(1002);
    }
    AppMethodBeat.o(25896);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494524;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25892);
    ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    boolean bool1;
    int j;
    Object localObject;
    int i;
    if (paramInt1 == 2001)
    {
      bool1 = false;
      if (paramIntent == null) {
        break label1176;
      }
      j = paramIntent.getIntExtra("key_err_code", 0);
      localObject = paramIntent.getStringExtra("key_err_msg");
      long l = paramIntent.getLongExtra("key_launch_ts", 0L);
      paramInt1 = paramIntent.getIntExtra("key_gw_error_code", 0);
      i = paramIntent.getIntExtra("key_response_position", 0);
      if (j == 100000001) {
        bool1 = true;
      }
      ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(j), localObject, Integer.valueOf(paramInt1), Integer.valueOf(i), String.valueOf(bool1) });
      if ((j == 6) && (paramInt1 != 0))
      {
        this.uTb.uNY = paramInt1;
        if (i != 3) {
          break label349;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 9L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 11L, 1L, true);
        this.uTb.uNY = 0L;
        this.uTb.uNZ = 2L;
        localObject = getString(2131760569);
        label234:
        this.uTb.uNX = l;
        this.uTb.uNG = bt.flT();
        this.uTb.finish();
      }
    }
    for (;;)
    {
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (j == 0))
        {
          localObject = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent.getStringArrayListExtra("key_response_series_ids");
          paramIntent = ((ArrayList)localObject).iterator();
          for (;;)
          {
            if (paramIntent.hasNext())
            {
              ad.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[] { bt.nullAsNil((String)paramIntent.next()) });
              continue;
              this.uTb.uNY = j;
              break;
              label349:
              if (i != 1)
              {
                if ((paramInt2 == -1) && (j == 0))
                {
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 9L, 1L, true);
                  break label234;
                }
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 9L, 1L, true);
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 12L, 1L, true);
                  this.uTb.uNY = 0L;
                  this.uTb.uNZ = 1L;
                }
              }
              break label234;
            }
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 6L, 1L, true);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 10L, 1L, true);
          Toast.makeText(this, 2131760532, 0).show();
          finish();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 100000002))
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 6L, 1L, true);
          abS((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 109))
        {
          abS((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 1))
        {
          paramIntent = getString(2131760530);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 8L, 1L, true);
          Toast.makeText(this, paramIntent, 0).show();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 113))
        {
          com.tencent.mm.ui.base.h.d(this, getString(2131760515), getString(2131760531), new IPCallRechargeUI.10(this));
          AppMethodBeat.o(25892);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 7L, 1L, true);
        if (i == 3)
        {
          abS((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((j == 100000001) || (j == 6))
        {
          if (paramInt1 == 0)
          {
            Toast.makeText(this, getString(2131760454), 0).show();
            AppMethodBeat.o(25892);
            return;
          }
          paramIntent = getString(2131760456);
          if (!anR(paramIntent)) {
            Toast.makeText(this, paramIntent, 0).show();
          }
        }
      }
      AppMethodBeat.o(25892);
      return;
      if (paramInt1 == 2002)
      {
        if ((this.uQp != null) && (this.uQp.isShowing())) {
          this.uQp.dismiss();
        }
        localObject = "";
        i = 0;
        paramInt1 = 0;
        bool1 = false;
        boolean bool2 = false;
        if (paramIntent != null)
        {
          i = paramIntent.getIntExtra("key_err_code", 0);
          localObject = paramIntent.getStringExtra("key_err_msg");
          paramInt1 = paramIntent.getIntExtra("key_response_position", 0);
          bool1 = bool2;
          if (i == 100000001) {
            bool1 = true;
          }
          ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(i), localObject, Integer.valueOf(paramInt1), String.valueOf(bool1) });
        }
        this.uTc.uOh = i;
        this.uTc.uOf = 0L;
        if (paramInt2 != -1) {
          break label1144;
        }
        if ((paramIntent == null) || (i != 0)) {
          break label1042;
        }
        paramIntent = paramIntent.getStringArrayListExtra("key_response_product_ids");
        if ((paramIntent == null) || (paramIntent.size() <= 0)) {
          break label1010;
        }
        this.uTc.uOg = 0L;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 15L, 1L, true);
        ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
        com.tencent.mm.ui.base.h.d(this, getString(2131760548), getString(2131760549), new IPCallRechargeUI.11(this));
      }
      for (;;)
      {
        this.uTc.uNG = bt.flT();
        this.uTc.finish();
        AppMethodBeat.o(25892);
        return;
        label1010:
        this.uTc.uOg = 3L;
        ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
        Toast.makeText(this, 2131760547, 0).show();
        continue;
        label1042:
        if (bool1)
        {
          this.uTc.uOg = 1L;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 17L, 1L, true);
          localObject = getString(2131760547);
        }
        for (;;)
        {
          ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
          Toast.makeText(this, (CharSequence)localObject, 0).show();
          break;
          if (paramInt1 == 3)
          {
            this.uTc.uOg = 2L;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 16L, 1L, true);
          }
          else
          {
            this.uTc.uOg = 2L;
          }
        }
        label1144:
        this.uTc.uOg = 2L;
        ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
        Toast.makeText(this, 2131760546, 0).show();
      }
      label1176:
      paramInt1 = 0;
      i = 0;
      j = 0;
      localObject = "";
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25889);
    super.onCreate(paramBundle);
    ba.aiU().a(929, this);
    setMMTitle(2131760475);
    setBackBtn(new IPCallRechargeUI.5(this));
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25876);
        IPCallRechargeUI.h(IPCallRechargeUI.this);
        AppMethodBeat.o(25876);
        return true;
      }
    });
    this.uTd = ((RelativeLayout)findViewById(2131301339));
    this.uTe = ((GridView)findViewById(2131303833));
    this.uTf = ((ListView)findViewById(2131303837));
    paramBundle = (ViewGroup)View.inflate(getContext(), 2131494522, null);
    this.uTf.addFooterView(paramBundle, null, false);
    this.uTg = new a(this);
    this.uTf.setAdapter(this.uTg);
    this.lDu = ((TextView)paramBundle.findViewById(2131305880));
    this.uTh = ((Button)findViewById(2131297671));
    paramBundle = getString(2131760481);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramBundle);
    localSpannable.setSpan(new IPCallRechargeUI.7(this), 0, paramBundle.length(), 33);
    this.lDu.setText(localSpannable);
    this.lDu.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = getContext();
    getString(2131755906);
    this.uQp = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131760457), true, new IPCallRechargeUI.8(this));
    anQ("");
    this.uTa.start();
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 4L, 1L, true);
    AppMethodBeat.o(25889);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25890);
    super.onDestroy();
    this.uTa.uNG = bt.flT();
    this.uTa.finish();
    ba.aiU().b(929, this);
    AppMethodBeat.o(25890);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(25895);
    ad.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.f))
    {
      paramString = this.uTa;
      paramString.uOc = bt.flT();
      paramString.uOd = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.ipcall.model.e.f)paramn).uNl;
        this.uTg.cje = paramString.CellList;
        this.uTg.uTm = paramString;
        this.uTg.notifyDataSetChanged();
        this.pKC = new String[paramString.CellList.size()];
        Iterator localIterator = paramString.CellList.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          eai localeai = (eai)localIterator.next();
          this.pKC[paramInt1] = localeai.ProductID;
          paramInt1 += 1;
        }
        this.uSY = paramString.GFh;
        this.uSZ = paramString.GFi;
        this.uST = paramString.GFc;
        this.uSU = paramString.GFg;
        this.uSW = paramString.GFf;
        if (this.uSV)
        {
          this.uSS = new String[paramString.CellList.size()];
          paramInt1 = 0;
          while (paramInt1 < this.uSS.length)
          {
            this.uSS[paramInt1] = paramString.GFg;
            paramInt1 += 1;
          }
          this.uSR = new String[paramString.CellList.size()];
          paramInt1 = i;
          while (paramInt1 < this.uSR.length)
          {
            this.uSR[paramInt1] = IPCallDynamicTextView.anP(((eai)paramString.CellList.get(paramInt1)).Hfq);
            paramInt1 += 1;
          }
        }
        if (((com.tencent.mm.plugin.ipcall.model.e.f)paramn).uNm)
        {
          ad.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
          if ((this.pKC != null) && (this.pKC.length > 0))
          {
            ad.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
            com.tencent.mm.pluginsdk.model.j.a(this, this.pKC, this.pKR);
          }
          AppMethodBeat.o(25895);
          return;
        }
        if ((this.uQp != null) && (this.uQp.isShowing())) {
          this.uQp.dismiss();
        }
        deG();
        AppMethodBeat.o(25895);
        return;
      }
      if ((this.uQp != null) && (this.uQp.isShowing())) {
        this.uQp.dismiss();
      }
      Toast.makeText(getContext(), getString(2131760454), 0).show();
      finish();
    }
    AppMethodBeat.o(25895);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    List<eai> cje;
    private IPCallRechargeUI uTl;
    bky uTm;
    
    public a(IPCallRechargeUI paramIPCallRechargeUI)
    {
      AppMethodBeat.i(25884);
      this.cje = null;
      this.uTl = null;
      this.uTm = null;
      Assert.assertTrue(true);
      this.uTl = paramIPCallRechargeUI;
      AppMethodBeat.o(25884);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25885);
      if (this.cje == null)
      {
        AppMethodBeat.o(25885);
        return 0;
      }
      int i = this.cje.size();
      AppMethodBeat.o(25885);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25886);
      if (this.cje != null)
      {
        Object localObject = this.cje.get(paramInt);
        AppMethodBeat.o(25886);
        return localObject;
      }
      AppMethodBeat.o(25886);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25887);
      if (paramView == null)
      {
        paramView = ((LayoutInflater)this.uTl.getSystemService("layout_inflater")).inflate(2131494523, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.uSs = ((TextView)paramView.findViewById(2131306102));
        paramViewGroup.uTo = ((TextView)paramView.findViewById(2131306101));
        paramViewGroup.uTp = ((TextView)paramView.findViewById(2131306100));
        paramViewGroup.uTq = ((TextView)paramView.findViewById(2131306099));
        paramViewGroup.uTr = ((Button)paramView.findViewById(2131297576));
        paramView.setTag(paramViewGroup);
      }
      eai localeai;
      for (;;)
      {
        localeai = (eai)getItem(paramInt);
        if (localeai != null) {
          break;
        }
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.uSs.setText(localeai.Hfq);
      paramViewGroup.uTo.setText(localeai.HNs);
      paramViewGroup.uTp.setText(localeai.HNt);
      if (bt.isNullOrNil(localeai.HNt)) {
        paramViewGroup.uTp.setVisibility(8);
      }
      for (;;)
      {
        if (this.uTm != null) {
          paramViewGroup.uTq.setText(String.format(this.uTl.getString(2131760479), new Object[] { a.anY(this.uTm.GFc), String.valueOf(localeai.HNq) }));
        }
        paramViewGroup.uTr.setTag(Integer.valueOf(paramInt));
        paramViewGroup.uTr.setOnClickListener(new IPCallRechargeUI.a.1(this));
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup.uTp.setVisibility(0);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView uSs;
      TextView uTo;
      TextView uTp;
      TextView uTq;
      Button uTr;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI
 * JD-Core Version:    0.7.0.1
 */