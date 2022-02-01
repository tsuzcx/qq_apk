package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.e.f;
import com.tencent.mm.plugin.ipcall.model.f.g;
import com.tencent.mm.plugin.ipcall.model.f.j;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.model.m.a;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.fgs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI
  extends MMActivity
  implements i
{
  ProgressDialog DUF;
  private String[] DXh;
  private String[] DXi;
  private String DXj;
  private String DXk;
  private boolean DXl;
  private int DXm;
  private int DXn;
  private String DXo;
  private String DXp;
  private com.tencent.mm.plugin.ipcall.model.f.h DXq;
  private g DXr;
  private j DXs;
  RelativeLayout DXt;
  GridView DXu;
  ListView DXv;
  a DXw;
  Button DXx;
  f DXy;
  private MMHandler mHandler;
  TextView mMA;
  private m.a uLF;
  private int uLm;
  private String[] uLq;
  
  public IPCallRechargeUI()
  {
    AppMethodBeat.i(25888);
    this.DXl = false;
    this.uLm = -1;
    this.DXn = -1;
    this.DXq = new com.tencent.mm.plugin.ipcall.model.f.h();
    this.DXr = new g();
    this.DXs = new j();
    this.uLF = new m.a()
    {
      public final void Y(ArrayList<u> paramAnonymousArrayList)
      {
        AppMethodBeat.i(25871);
        IPCallRechargeUI.a(IPCallRechargeUI.this).DSt = Util.nowMilliSecond();
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
        {
          IPCallRechargeUI.a(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          IPCallRechargeUI.b(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          u localu = (u)paramAnonymousArrayList.get(0);
          if (localu.QVB == 10232)
          {
            Log.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + paramAnonymousArrayList.size());
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            int i = 0;
            while (paramAnonymousArrayList.hasNext())
            {
              localu = (u)paramAnonymousArrayList.next();
              BigDecimal localBigDecimal = new BigDecimal(localu.QVA).divide(new BigDecimal(1000000));
              IPCallRechargeUI.b(IPCallRechargeUI.this)[i] = localBigDecimal.toString();
              IPCallRechargeUI.c(IPCallRechargeUI.this)[i] = localu.QVz;
              i += 1;
            }
            if ((IPCallRechargeUI.d(IPCallRechargeUI.this) > 0) && (IPCallRechargeUI.c(IPCallRechargeUI.this).length > 0))
            {
              paramAnonymousArrayList = IPCallRechargeUI.c(IPCallRechargeUI.this)[0];
              if ((!Util.isNullOrNil(paramAnonymousArrayList)) && (!paramAnonymousArrayList.equals(IPCallRechargeUI.e(IPCallRechargeUI.this))))
              {
                Log.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.e(IPCallRechargeUI.this) + ",google wallet currency:" + paramAnonymousArrayList);
                IPCallRechargeUI.a(IPCallRechargeUI.this, paramAnonymousArrayList);
                AppMethodBeat.o(25871);
                return;
              }
            }
            if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
              IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
            }
            IPCallRechargeUI.this.aze();
            AppMethodBeat.o(25871);
            return;
          }
          if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
            IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
          }
          IPCallRechargeUI.a(IPCallRechargeUI.this, localu.QVB);
          Log.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(IPCallRechargeUI.this));
          IPCallRechargeUI.this.aze();
          AppMethodBeat.o(25871);
          return;
        }
        if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
          IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
        }
        Log.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
        IPCallRechargeUI.a(IPCallRechargeUI.this, 10236);
        IPCallRechargeUI.this.aze();
        AppMethodBeat.o(25871);
      }
    };
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25873);
        switch (paramAnonymousMessage.what)
        {
        default: 
          Log.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
          AppMethodBeat.o(25873);
          return;
        }
        IPCallRechargeUI.this.DXv.setVisibility(0);
        IPCallRechargeUI.k(IPCallRechargeUI.this);
        AppMethodBeat.o(25873);
      }
    };
    AppMethodBeat.o(25888);
  }
  
  private void aMt(String paramString)
  {
    AppMethodBeat.i(25891);
    Object localObject = com.tencent.mm.plugin.ipcall.model.c.eJb().eJe();
    if (((List)localObject).size() == 0) {}
    for (localObject = a.aMD(com.tencent.mm.plugin.ipcall.a.c.eKM());; localObject = a.aMD(((Integer)((List)localObject).get(0)).toString()))
    {
      this.DXy = new f((String)localObject, paramString);
      bh.aGY().a(this.DXy, 0);
      AppMethodBeat.o(25891);
      return;
    }
  }
  
  private boolean aMu(String paramString)
  {
    AppMethodBeat.i(25894);
    if ((com.tencent.mm.plugin.ipcall.a.c.eKN()) && (this.DXn >= 0))
    {
      Object localObject = this.DXw.getItem(this.DXn);
      if (((localObject instanceof fgs)) && (!Util.isNullOrNil(((fgs)localObject).UHd)))
      {
        localObject = ((fgs)localObject).UHd;
        Log.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(localObject)));
        com.tencent.mm.ui.base.h.a(this, paramString, getString(R.l.eJL), getString(R.l.eJw), getString(R.l.app_cancel), true, new IPCallRechargeUI.2(this, (String)localObject), null);
        AppMethodBeat.o(25894);
        return true;
      }
    }
    AppMethodBeat.o(25894);
    return false;
  }
  
  private void auK(String paramString)
  {
    AppMethodBeat.i(25893);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(R.l.eJL);
    }
    com.tencent.mm.ui.base.h.d(this, str, getString(R.l.eJL), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25893);
  }
  
  public final void aze()
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
    return R.i.eii;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25892);
    Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    boolean bool1;
    int j;
    Object localObject;
    int i;
    if (paramInt1 == 2001)
    {
      bool1 = false;
      if (paramIntent == null) {
        break label1178;
      }
      j = paramIntent.getIntExtra("key_err_code", 0);
      localObject = paramIntent.getStringExtra("key_err_msg");
      long l = paramIntent.getLongExtra("key_launch_ts", 0L);
      paramInt1 = paramIntent.getIntExtra("key_gw_error_code", 0);
      i = paramIntent.getIntExtra("key_response_position", 0);
      if (j == 100000001) {
        bool1 = true;
      }
      Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(j), localObject, Integer.valueOf(paramInt1), Integer.valueOf(i), String.valueOf(bool1) });
      if ((j == 6) && (paramInt1 != 0))
      {
        this.DXr.DSn = paramInt1;
        if (i != 3) {
          break label349;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 9L, 1L, true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 11L, 1L, true);
        this.DXr.DSn = 0L;
        this.DXr.DSo = 2L;
        localObject = getString(R.l.eKr);
        label234:
        this.DXr.DSm = l;
        this.DXr.DRV = Util.nowMilliSecond();
        this.DXr.finish();
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
              Log.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[] { Util.nullAsNil((String)paramIntent.next()) });
              continue;
              this.DXr.DSn = j;
              break;
              label349:
              if (i != 1)
              {
                if ((paramInt2 == -1) && (j == 0))
                {
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 9L, 1L, true);
                  break label234;
                }
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 9L, 1L, true);
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 12L, 1L, true);
                  this.DXr.DSn = 0L;
                  this.DXr.DSo = 1L;
                }
              }
              break label234;
            }
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 6L, 1L, true);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 10L, 1L, true);
          Toast.makeText(this, R.l.eJM, 0).show();
          finish();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 100000002))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 6L, 1L, true);
          auK((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 109))
        {
          auK((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 1))
        {
          paramIntent = getString(R.l.eJK);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 8L, 1L, true);
          Toast.makeText(this, paramIntent, 0).show();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 113))
        {
          com.tencent.mm.ui.base.h.d(this, getString(R.l.eJD), getString(R.l.eJL), new IPCallRechargeUI.10(this));
          AppMethodBeat.o(25892);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 7L, 1L, true);
        if (i == 3)
        {
          auK((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((j == 100000001) || (j == 6))
        {
          if (paramInt1 == 0)
          {
            Toast.makeText(this, getString(R.l.eIN), 0).show();
            AppMethodBeat.o(25892);
            return;
          }
          paramIntent = getString(R.l.eIP);
          if (!aMu(paramIntent)) {
            Toast.makeText(this, paramIntent, 0).show();
          }
        }
      }
      AppMethodBeat.o(25892);
      return;
      if (paramInt1 == 2002)
      {
        if ((this.DUF != null) && (this.DUF.isShowing())) {
          this.DUF.dismiss();
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
          Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(i), localObject, Integer.valueOf(paramInt1), String.valueOf(bool1) });
        }
        this.DXs.DSw = i;
        this.DXs.DSu = 0L;
        if (paramInt2 != -1) {
          break label1146;
        }
        if ((paramIntent == null) || (i != 0)) {
          break label1044;
        }
        paramIntent = paramIntent.getStringArrayListExtra("key_response_product_ids");
        if ((paramIntent == null) || (paramIntent.size() <= 0)) {
          break label1012;
        }
        this.DXs.DSv = 0L;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 15L, 1L, true);
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
        com.tencent.mm.ui.base.h.d(this, getString(R.l.eKb), getString(R.l.eKc), new IPCallRechargeUI.11(this));
      }
      for (;;)
      {
        this.DXs.DRV = Util.nowMilliSecond();
        this.DXs.finish();
        AppMethodBeat.o(25892);
        return;
        label1012:
        this.DXs.DSv = 3L;
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
        Toast.makeText(this, R.l.eKa, 0).show();
        continue;
        label1044:
        if (bool1)
        {
          this.DXs.DSv = 1L;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 17L, 1L, true);
          localObject = getString(R.l.eKa);
        }
        for (;;)
        {
          Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
          Toast.makeText(this, (CharSequence)localObject, 0).show();
          break;
          if (paramInt1 == 3)
          {
            this.DXs.DSv = 2L;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 16L, 1L, true);
          }
          else
          {
            this.DXs.DSv = 2L;
          }
        }
        label1146:
        this.DXs.DSv = 2L;
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
        Toast.makeText(this, R.l.eJZ, 0).show();
      }
      label1178:
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
    bh.aGY().a(929, this);
    setMMTitle(R.l.eJa);
    setBackBtn(new IPCallRechargeUI.5(this));
    addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25876);
        IPCallRechargeUI.h(IPCallRechargeUI.this);
        AppMethodBeat.o(25876);
        return true;
      }
    });
    this.DXt = ((RelativeLayout)findViewById(R.h.layout));
    this.DXu = ((GridView)findViewById(R.h.dSm));
    this.DXv = ((ListView)findViewById(R.h.dSo));
    paramBundle = (ViewGroup)View.inflate(getContext(), R.i.eig, null);
    this.DXv.addFooterView(paramBundle, null, false);
    this.DXw = new a(this);
    this.DXv.setAdapter(this.DXw);
    this.mMA = ((TextView)paramBundle.findViewById(R.h.tip_tv));
    this.DXx = ((Button)findViewById(R.h.duQ));
    paramBundle = getString(R.l.eJf);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramBundle);
    localSpannable.setSpan(new IPCallRechargeUI.7(this), 0, paramBundle.length(), 33);
    this.mMA.setText(localSpannable);
    this.mMA.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = getContext();
    getString(R.l.app_tip);
    this.DUF = com.tencent.mm.ui.base.h.a(paramBundle, getString(R.l.eIQ), true, new IPCallRechargeUI.8(this));
    aMt("");
    this.DXq.start();
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 4L, 1L, true);
    AppMethodBeat.o(25889);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25890);
    super.onDestroy();
    this.DXq.DRV = Util.nowMilliSecond();
    this.DXq.finish();
    bh.aGY().b(929, this);
    AppMethodBeat.o(25890);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 0;
    AppMethodBeat.i(25895);
    Log.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof f))
    {
      paramString = this.DXq;
      paramString.DSr = Util.nowMilliSecond();
      paramString.DSs = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramq).DRA;
        this.DXw.ctq = paramString.Tep;
        this.DXw.DXC = paramString;
        this.DXw.notifyDataSetChanged();
        this.uLq = new String[paramString.Tep.size()];
        Iterator localIterator = paramString.Tep.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          fgs localfgs = (fgs)localIterator.next();
          this.uLq[paramInt1] = localfgs.ProductID;
          paramInt1 += 1;
        }
        this.DXo = paramString.Tna;
        this.DXp = paramString.Tnb;
        this.DXj = paramString.TmV;
        this.DXk = paramString.TmZ;
        this.DXm = paramString.TmY;
        if (this.DXl)
        {
          this.DXi = new String[paramString.Tep.size()];
          paramInt1 = 0;
          while (paramInt1 < this.DXi.length)
          {
            this.DXi[paramInt1] = paramString.TmZ;
            paramInt1 += 1;
          }
          this.DXh = new String[paramString.Tep.size()];
          paramInt1 = i;
          while (paramInt1 < this.DXh.length)
          {
            this.DXh[paramInt1] = IPCallDynamicTextView.aMs(((fgs)paramString.Tep.get(paramInt1)).TVo);
            paramInt1 += 1;
          }
        }
        if (((f)paramq).DRB)
        {
          Log.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
          if ((this.uLq != null) && (this.uLq.length > 0))
          {
            Log.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
            m.a(this, this.uLq, this.uLF);
          }
          AppMethodBeat.o(25895);
          return;
        }
        if ((this.DUF != null) && (this.DUF.isShowing())) {
          this.DUF.dismiss();
        }
        aze();
        AppMethodBeat.o(25895);
        return;
      }
      if ((this.DUF != null) && (this.DUF.isShowing())) {
        this.DUF.dismiss();
      }
      Toast.makeText(getContext(), getString(R.l.eIN), 0).show();
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
    private IPCallRechargeUI DXB;
    cft DXC;
    List<fgs> ctq;
    
    public a(IPCallRechargeUI paramIPCallRechargeUI)
    {
      AppMethodBeat.i(25884);
      this.ctq = null;
      this.DXB = null;
      this.DXC = null;
      Assert.assertTrue(true);
      this.DXB = paramIPCallRechargeUI;
      AppMethodBeat.o(25884);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25885);
      if (this.ctq == null)
      {
        AppMethodBeat.o(25885);
        return 0;
      }
      int i = this.ctq.size();
      AppMethodBeat.o(25885);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25886);
      if (this.ctq != null)
      {
        Object localObject = this.ctq.get(paramInt);
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
        paramView = ((LayoutInflater)this.DXB.getSystemService("layout_inflater")).inflate(R.i.eih, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.DWI = ((TextView)paramView.findViewById(R.h.dYd));
        paramViewGroup.DXE = ((TextView)paramView.findViewById(R.h.dYc));
        paramViewGroup.DXF = ((TextView)paramView.findViewById(R.h.dYb));
        paramViewGroup.DXG = ((TextView)paramView.findViewById(R.h.dYa));
        paramViewGroup.DXH = ((Button)paramView.findViewById(R.h.duC));
        paramView.setTag(paramViewGroup);
      }
      fgs localfgs;
      for (;;)
      {
        localfgs = (fgs)getItem(paramInt);
        if (localfgs != null) {
          break;
        }
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.DWI.setText(localfgs.TVo);
      paramViewGroup.DXE.setText(localfgs.UHa);
      paramViewGroup.DXF.setText(localfgs.UHb);
      if (Util.isNullOrNil(localfgs.UHb)) {
        paramViewGroup.DXF.setVisibility(8);
      }
      for (;;)
      {
        if (this.DXC != null) {
          paramViewGroup.DXG.setText(String.format(this.DXB.getString(R.l.eJd), new Object[] { a.aMB(this.DXC.TmV), String.valueOf(localfgs.UGY) }));
        }
        paramViewGroup.DXH.setTag(Integer.valueOf(paramInt));
        paramViewGroup.DXH.setOnClickListener(new IPCallRechargeUI.a.1(this));
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup.DXF.setVisibility(0);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView DWI;
      TextView DXE;
      TextView DXF;
      TextView DXG;
      Button DXH;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI
 * JD-Core Version:    0.7.0.1
 */