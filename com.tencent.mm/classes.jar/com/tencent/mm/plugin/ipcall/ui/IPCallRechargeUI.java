package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.e.f;
import com.tencent.mm.plugin.ipcall.model.f.g;
import com.tencent.mm.plugin.ipcall.model.f.j;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.model.o.a;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.gde;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private g JOA;
  private j JOB;
  RelativeLayout JOC;
  GridView JOD;
  ListView JOE;
  a JOF;
  Button JOG;
  f JOH;
  private String[] JOq;
  private String[] JOr;
  private String JOs;
  private String JOt;
  private boolean JOu;
  private int JOv;
  private int JOw;
  private String JOx;
  private String JOy;
  private com.tencent.mm.plugin.ipcall.model.f.h JOz;
  private MMHandler mHandler;
  TextView pJi;
  private int xTM;
  private String[] xTQ;
  private o.a xUg;
  ProgressDialog xZJ;
  
  public IPCallRechargeUI()
  {
    AppMethodBeat.i(25888);
    this.JOu = false;
    this.xTM = -1;
    this.JOw = -1;
    this.JOz = new com.tencent.mm.plugin.ipcall.model.f.h();
    this.JOA = new g();
    this.JOB = new j();
    this.xUg = new o.a()
    {
      public final void ac(ArrayList<w> paramAnonymousArrayList)
      {
        AppMethodBeat.i(25871);
        IPCallRechargeUI.a(IPCallRechargeUI.this).JJD = Util.nowMilliSecond();
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
        {
          IPCallRechargeUI.a(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          IPCallRechargeUI.b(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          w localw = (w)paramAnonymousArrayList.get(0);
          if (localw.XRy == 10232)
          {
            Log.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + paramAnonymousArrayList.size());
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            int i = 0;
            while (paramAnonymousArrayList.hasNext())
            {
              localw = (w)paramAnonymousArrayList.next();
              BigDecimal localBigDecimal = new BigDecimal(localw.XRx).divide(new BigDecimal(1000000));
              IPCallRechargeUI.b(IPCallRechargeUI.this)[i] = localBigDecimal.toString();
              IPCallRechargeUI.c(IPCallRechargeUI.this)[i] = localw.XRw;
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
            IPCallRechargeUI.this.fSq();
            AppMethodBeat.o(25871);
            return;
          }
          if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
            IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
          }
          IPCallRechargeUI.a(IPCallRechargeUI.this, localw.XRy);
          Log.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(IPCallRechargeUI.this));
          IPCallRechargeUI.this.fSq();
          AppMethodBeat.o(25871);
          return;
        }
        if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
          IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
        }
        Log.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
        IPCallRechargeUI.a(IPCallRechargeUI.this, 10236);
        IPCallRechargeUI.this.fSq();
        AppMethodBeat.o(25871);
      }
    };
    this.mHandler = new IPCallRechargeUI.3(this);
    AppMethodBeat.o(25888);
  }
  
  private void aJn(String paramString)
  {
    AppMethodBeat.i(25891);
    Object localObject = com.tencent.mm.plugin.ipcall.model.c.fRb().fRe();
    if (((List)localObject).size() == 0) {}
    for (localObject = a.aJx(com.tencent.mm.plugin.ipcall.a.c.fSL());; localObject = a.aJx(((Integer)((List)localObject).get(0)).toString()))
    {
      this.JOH = new f((String)localObject, paramString);
      bh.aZW().a(this.JOH, 0);
      AppMethodBeat.o(25891);
      return;
    }
  }
  
  private boolean aJo(String paramString)
  {
    AppMethodBeat.i(25894);
    if ((com.tencent.mm.plugin.ipcall.a.c.fSM()) && (this.JOw >= 0))
    {
      Object localObject = this.JOF.getItem(this.JOw);
      if (((localObject instanceof gde)) && (!Util.isNullOrNil(((gde)localObject).acbm)))
      {
        localObject = ((gde)localObject).acbm;
        Log.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(localObject)));
        k.a(this, paramString, getString(R.l.gLs), getString(R.l.gLd), getString(R.l.app_cancel), true, new IPCallRechargeUI.2(this, (String)localObject), null);
        AppMethodBeat.o(25894);
        return true;
      }
    }
    AppMethodBeat.o(25894);
    return false;
  }
  
  private void aoJ(String paramString)
  {
    AppMethodBeat.i(25893);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(R.l.gLs);
    }
    k.d(this, str, getString(R.l.gLs), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25893);
  }
  
  public final void fSq()
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
    return R.i.gld;
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
        this.JOA.JJx = paramInt1;
        if (i != 3) {
          break label349;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 9L, 1L, true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 11L, 1L, true);
        this.JOA.JJx = 0L;
        this.JOA.JJy = 2L;
        localObject = getString(R.l.gLY);
        label234:
        this.JOA.JJw = l;
        this.JOA.JJf = Util.nowMilliSecond();
        this.JOA.finish();
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
              this.JOA.JJx = j;
              break;
              label349:
              if (i != 1)
              {
                if ((paramInt2 == -1) && (j == 0))
                {
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 9L, 1L, true);
                  break label234;
                }
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 9L, 1L, true);
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 12L, 1L, true);
                  this.JOA.JJx = 0L;
                  this.JOA.JJy = 1L;
                }
              }
              break label234;
            }
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 6L, 1L, true);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 10L, 1L, true);
          Toast.makeText(this, R.l.gLt, 0).show();
          finish();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 100000002))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 6L, 1L, true);
          aoJ((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 109))
        {
          aoJ((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 1))
        {
          paramIntent = getString(R.l.gLr);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 8L, 1L, true);
          Toast.makeText(this, paramIntent, 0).show();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 113))
        {
          k.d(this, getString(R.l.gLk), getString(R.l.gLs), new IPCallRechargeUI.10(this));
          AppMethodBeat.o(25892);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 7L, 1L, true);
        if (i == 3)
        {
          aoJ((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((j == 100000001) || (j == 6))
        {
          if (paramInt1 == 0)
          {
            Toast.makeText(this, getString(R.l.gKu), 0).show();
            AppMethodBeat.o(25892);
            return;
          }
          paramIntent = getString(R.l.gKw);
          if (!aJo(paramIntent)) {
            Toast.makeText(this, paramIntent, 0).show();
          }
        }
      }
      AppMethodBeat.o(25892);
      return;
      if (paramInt1 == 2002)
      {
        if ((this.xZJ != null) && (this.xZJ.isShowing())) {
          this.xZJ.dismiss();
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
        this.JOB.JJG = i;
        this.JOB.JJE = 0L;
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
        this.JOB.JJF = 0L;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 15L, 1L, true);
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
        k.d(this, getString(R.l.gLI), getString(R.l.gLJ), new IPCallRechargeUI.11(this));
      }
      for (;;)
      {
        this.JOB.JJf = Util.nowMilliSecond();
        this.JOB.finish();
        AppMethodBeat.o(25892);
        return;
        label1012:
        this.JOB.JJF = 3L;
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
        Toast.makeText(this, R.l.gLH, 0).show();
        continue;
        label1044:
        if (bool1)
        {
          this.JOB.JJF = 1L;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 17L, 1L, true);
          localObject = getString(R.l.gLH);
        }
        for (;;)
        {
          Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
          Toast.makeText(this, (CharSequence)localObject, 0).show();
          break;
          if (paramInt1 == 3)
          {
            this.JOB.JJF = 2L;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 16L, 1L, true);
          }
          else
          {
            this.JOB.JJF = 2L;
          }
        }
        label1146:
        this.JOB.JJF = 2L;
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
        Toast.makeText(this, R.l.gLG, 0).show();
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
    bh.aZW().a(929, this);
    setMMTitle(R.l.gKH);
    setBackBtn(new IPCallRechargeUI.5(this));
    addIconOptionMenu(0, R.k.icons_outlined_more, new IPCallRechargeUI.6(this));
    this.JOC = ((RelativeLayout)findViewById(R.h.layout));
    this.JOD = ((GridView)findViewById(R.h.fUm));
    this.JOE = ((ListView)findViewById(R.h.fUo));
    paramBundle = (ViewGroup)View.inflate(getContext(), R.i.glb, null);
    this.JOE.addFooterView(paramBundle, null, false);
    this.JOF = new a(this);
    this.JOE.setAdapter(this.JOF);
    this.pJi = ((TextView)paramBundle.findViewById(R.h.tip_tv));
    this.JOG = ((Button)findViewById(R.h.fvi));
    paramBundle = getString(R.l.gKM);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramBundle);
    localSpannable.setSpan(new IPCallRechargeUI.7(this), 0, paramBundle.length(), 33);
    this.pJi.setText(localSpannable);
    this.pJi.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = getContext();
    getString(R.l.app_tip);
    this.xZJ = k.a(paramBundle, getString(R.l.gKx), true, new IPCallRechargeUI.8(this));
    aJn("");
    this.JOz.start();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 4L, 1L, true);
    AppMethodBeat.o(25889);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25890);
    super.onDestroy();
    this.JOz.JJf = Util.nowMilliSecond();
    this.JOz.finish();
    bh.aZW().b(929, this);
    AppMethodBeat.o(25890);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 0;
    AppMethodBeat.i(25895);
    Log.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof f))
    {
      paramString = this.JOz;
      paramString.JJB = Util.nowMilliSecond();
      paramString.JJC = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramp).JIK;
        this.JOF.ell = paramString.aarE;
        this.JOF.JOL = paramString;
        this.JOF.notifyDataSetChanged();
        this.xTQ = new String[paramString.aarE.size()];
        Iterator localIterator = paramString.aarE.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          gde localgde = (gde)localIterator.next();
          this.xTQ[paramInt1] = localgde.ProductID;
          paramInt1 += 1;
        }
        this.JOx = paramString.aaBg;
        this.JOy = paramString.aaBh;
        this.JOs = paramString.aaBb;
        this.JOt = paramString.aaBf;
        this.JOv = paramString.aaBe;
        if (this.JOu)
        {
          this.JOr = new String[paramString.aarE.size()];
          paramInt1 = 0;
          while (paramInt1 < this.JOr.length)
          {
            this.JOr[paramInt1] = paramString.aaBf;
            paramInt1 += 1;
          }
          this.JOq = new String[paramString.aarE.size()];
          paramInt1 = i;
          while (paramInt1 < this.JOq.length)
          {
            this.JOq[paramInt1] = IPCallDynamicTextView.aJm(((gde)paramString.aarE.get(paramInt1)).ablY);
            paramInt1 += 1;
          }
        }
        if (((f)paramp).JIL)
        {
          Log.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
          if ((this.xTQ != null) && (this.xTQ.length > 0))
          {
            Log.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
            o.a(this, this.xTQ, this.xUg);
          }
          AppMethodBeat.o(25895);
          return;
        }
        if ((this.xZJ != null) && (this.xZJ.isShowing())) {
          this.xZJ.dismiss();
        }
        fSq();
        AppMethodBeat.o(25895);
        return;
      }
      if ((this.xZJ != null) && (this.xZJ.isShowing())) {
        this.xZJ.dismiss();
      }
      Toast.makeText(getContext(), getString(R.l.gKu), 0).show();
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
    private IPCallRechargeUI JOK;
    cvw JOL;
    List<gde> ell;
    
    public a(IPCallRechargeUI paramIPCallRechargeUI)
    {
      AppMethodBeat.i(25884);
      this.ell = null;
      this.JOK = null;
      this.JOL = null;
      Assert.assertTrue(true);
      this.JOK = paramIPCallRechargeUI;
      AppMethodBeat.o(25884);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25885);
      if (this.ell == null)
      {
        AppMethodBeat.o(25885);
        return 0;
      }
      int i = this.ell.size();
      AppMethodBeat.o(25885);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25886);
      if (this.ell != null)
      {
        Object localObject = this.ell.get(paramInt);
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
        paramView = ((LayoutInflater)this.JOK.getSystemService("layout_inflater")).inflate(R.i.glc, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.JNR = ((TextView)paramView.findViewById(R.h.gaJ));
        paramViewGroup.JON = ((TextView)paramView.findViewById(R.h.gaI));
        paramViewGroup.JOO = ((TextView)paramView.findViewById(R.h.gaH));
        paramViewGroup.JOP = ((TextView)paramView.findViewById(R.h.gaG));
        paramViewGroup.JOQ = ((Button)paramView.findViewById(R.h.fuU));
        paramView.setTag(paramViewGroup);
      }
      gde localgde;
      for (;;)
      {
        localgde = (gde)getItem(paramInt);
        if (localgde != null) {
          break;
        }
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.JNR.setText(localgde.ablY);
      paramViewGroup.JON.setText(localgde.acbj);
      paramViewGroup.JOO.setText(localgde.acbk);
      if (Util.isNullOrNil(localgde.acbk)) {
        paramViewGroup.JOO.setVisibility(8);
      }
      for (;;)
      {
        if (this.JOL != null) {
          paramViewGroup.JOP.setText(String.format(this.JOK.getString(R.l.gKK), new Object[] { a.aJv(this.JOL.aaBb), String.valueOf(localgde.acbh) }));
        }
        paramViewGroup.JOQ.setTag(Integer.valueOf(paramInt));
        paramViewGroup.JOQ.setOnClickListener(new IPCallRechargeUI.a.1(this));
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup.JOO.setVisibility(0);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView JNR;
      TextView JON;
      TextView JOO;
      TextView JOP;
      Button JOQ;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI
 * JD-Core Version:    0.7.0.1
 */