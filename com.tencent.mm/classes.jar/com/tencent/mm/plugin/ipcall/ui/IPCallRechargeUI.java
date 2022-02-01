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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.ebz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.mm.ak.f
{
  TextView lHT;
  private aq mHandler;
  private int pRd;
  private String[] pRh;
  private j.a pRw;
  ProgressDialog vcb;
  private String[] veE;
  private String[] veF;
  private String veG;
  private String veH;
  private boolean veI;
  private int veJ;
  private int veK;
  private String veL;
  private String veM;
  private com.tencent.mm.plugin.ipcall.model.f.h veN;
  private com.tencent.mm.plugin.ipcall.model.f.g veO;
  private com.tencent.mm.plugin.ipcall.model.f.j veP;
  RelativeLayout veQ;
  GridView veR;
  ListView veS;
  a veT;
  Button veU;
  com.tencent.mm.plugin.ipcall.model.e.f veV;
  
  public IPCallRechargeUI()
  {
    AppMethodBeat.i(25888);
    this.veI = false;
    this.pRd = -1;
    this.veK = -1;
    this.veN = new com.tencent.mm.plugin.ipcall.model.f.h();
    this.veO = new com.tencent.mm.plugin.ipcall.model.f.g();
    this.veP = new com.tencent.mm.plugin.ipcall.model.f.j();
    this.pRw = new j.a()
    {
      public final void R(ArrayList<p> paramAnonymousArrayList)
      {
        AppMethodBeat.i(25871);
        IPCallRechargeUI.a(IPCallRechargeUI.this).uZR = bu.fpO();
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
        {
          IPCallRechargeUI.a(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          IPCallRechargeUI.b(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          p localp = (p)paramAnonymousArrayList.get(0);
          if (localp.Fez == 10232)
          {
            ae.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + paramAnonymousArrayList.size());
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            int i = 0;
            while (paramAnonymousArrayList.hasNext())
            {
              localp = (p)paramAnonymousArrayList.next();
              BigDecimal localBigDecimal = new BigDecimal(localp.Fey).divide(new BigDecimal(1000000));
              IPCallRechargeUI.b(IPCallRechargeUI.this)[i] = localBigDecimal.toString();
              IPCallRechargeUI.c(IPCallRechargeUI.this)[i] = localp.Fex;
              i += 1;
            }
            if ((IPCallRechargeUI.d(IPCallRechargeUI.this) > 0) && (IPCallRechargeUI.c(IPCallRechargeUI.this).length > 0))
            {
              paramAnonymousArrayList = IPCallRechargeUI.c(IPCallRechargeUI.this)[0];
              if ((!bu.isNullOrNil(paramAnonymousArrayList)) && (!paramAnonymousArrayList.equals(IPCallRechargeUI.e(IPCallRechargeUI.this))))
              {
                ae.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.e(IPCallRechargeUI.this) + ",google wallet currency:" + paramAnonymousArrayList);
                IPCallRechargeUI.a(IPCallRechargeUI.this, paramAnonymousArrayList);
                AppMethodBeat.o(25871);
                return;
              }
            }
            if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
              IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
            }
            IPCallRechargeUI.this.dhy();
            AppMethodBeat.o(25871);
            return;
          }
          if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
            IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
          }
          IPCallRechargeUI.a(IPCallRechargeUI.this, localp.Fez);
          ae.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(IPCallRechargeUI.this));
          IPCallRechargeUI.this.dhy();
          AppMethodBeat.o(25871);
          return;
        }
        if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
          IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
        }
        ae.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
        IPCallRechargeUI.a(IPCallRechargeUI.this, 10236);
        IPCallRechargeUI.this.dhy();
        AppMethodBeat.o(25871);
      }
    };
    this.mHandler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25873);
        switch (paramAnonymousMessage.what)
        {
        default: 
          ae.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
          AppMethodBeat.o(25873);
          return;
        }
        IPCallRechargeUI.this.veS.setVisibility(0);
        IPCallRechargeUI.k(IPCallRechargeUI.this);
        AppMethodBeat.o(25873);
      }
    };
    AppMethodBeat.o(25888);
  }
  
  private void acJ(String paramString)
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
  
  private void aoS(String paramString)
  {
    AppMethodBeat.i(25891);
    Object localObject = com.tencent.mm.plugin.ipcall.model.c.dgj().dgm();
    if (((List)localObject).size() == 0) {}
    for (localObject = a.apc(com.tencent.mm.plugin.ipcall.a.c.dhX());; localObject = a.apc(((Integer)((List)localObject).get(0)).toString()))
    {
      this.veV = new com.tencent.mm.plugin.ipcall.model.e.f((String)localObject, paramString);
      bc.ajj().a(this.veV, 0);
      AppMethodBeat.o(25891);
      return;
    }
  }
  
  private boolean aoT(String paramString)
  {
    AppMethodBeat.i(25894);
    if ((com.tencent.mm.plugin.ipcall.a.c.dhY()) && (this.veK >= 0))
    {
      Object localObject = this.veT.getItem(this.veK);
      if (((localObject instanceof ebz)) && (!bu.isNullOrNil(((ebz)localObject).IhC)))
      {
        localObject = ((ebz)localObject).IhC;
        ae.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(localObject)));
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131760531), getString(2131760506), getString(2131755691), true, new IPCallRechargeUI.2(this, (String)localObject), null);
        AppMethodBeat.o(25894);
        return true;
      }
    }
    AppMethodBeat.o(25894);
    return false;
  }
  
  public final void dhy()
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
    ae.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ae.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(j), localObject, Integer.valueOf(paramInt1), Integer.valueOf(i), String.valueOf(bool1) });
      if ((j == 6) && (paramInt1 != 0))
      {
        this.veO.uZL = paramInt1;
        if (i != 3) {
          break label349;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 9L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 11L, 1L, true);
        this.veO.uZL = 0L;
        this.veO.uZM = 2L;
        localObject = getString(2131760569);
        label234:
        this.veO.uZK = l;
        this.veO.uZt = bu.fpO();
        this.veO.finish();
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
              ae.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[] { bu.nullAsNil((String)paramIntent.next()) });
              continue;
              this.veO.uZL = j;
              break;
              label349:
              if (i != 1)
              {
                if ((paramInt2 == -1) && (j == 0))
                {
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 9L, 1L, true);
                  break label234;
                }
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 9L, 1L, true);
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 12L, 1L, true);
                  this.veO.uZL = 0L;
                  this.veO.uZM = 1L;
                }
              }
              break label234;
            }
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 6L, 1L, true);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 10L, 1L, true);
          Toast.makeText(this, 2131760532, 0).show();
          finish();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 100000002))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 6L, 1L, true);
          acJ((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 109))
        {
          acJ((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 1))
        {
          paramIntent = getString(2131760530);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 8L, 1L, true);
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
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 7L, 1L, true);
        if (i == 3)
        {
          acJ((String)localObject);
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
          if (!aoT(paramIntent)) {
            Toast.makeText(this, paramIntent, 0).show();
          }
        }
      }
      AppMethodBeat.o(25892);
      return;
      if (paramInt1 == 2002)
      {
        if ((this.vcb != null) && (this.vcb.isShowing())) {
          this.vcb.dismiss();
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
          ae.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(i), localObject, Integer.valueOf(paramInt1), String.valueOf(bool1) });
        }
        this.veP.uZU = i;
        this.veP.uZS = 0L;
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
        this.veP.uZT = 0L;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 15L, 1L, true);
        ae.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
        com.tencent.mm.ui.base.h.d(this, getString(2131760548), getString(2131760549), new IPCallRechargeUI.11(this));
      }
      for (;;)
      {
        this.veP.uZt = bu.fpO();
        this.veP.finish();
        AppMethodBeat.o(25892);
        return;
        label1010:
        this.veP.uZT = 3L;
        ae.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
        Toast.makeText(this, 2131760547, 0).show();
        continue;
        label1042:
        if (bool1)
        {
          this.veP.uZT = 1L;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 17L, 1L, true);
          localObject = getString(2131760547);
        }
        for (;;)
        {
          ae.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
          Toast.makeText(this, (CharSequence)localObject, 0).show();
          break;
          if (paramInt1 == 3)
          {
            this.veP.uZT = 2L;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 16L, 1L, true);
          }
          else
          {
            this.veP.uZT = 2L;
          }
        }
        label1144:
        this.veP.uZT = 2L;
        ae.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
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
    bc.ajj().a(929, this);
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
    this.veQ = ((RelativeLayout)findViewById(2131301339));
    this.veR = ((GridView)findViewById(2131303833));
    this.veS = ((ListView)findViewById(2131303837));
    paramBundle = (ViewGroup)View.inflate(getContext(), 2131494522, null);
    this.veS.addFooterView(paramBundle, null, false);
    this.veT = new a(this);
    this.veS.setAdapter(this.veT);
    this.lHT = ((TextView)paramBundle.findViewById(2131305880));
    this.veU = ((Button)findViewById(2131297671));
    paramBundle = getString(2131760481);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramBundle);
    localSpannable.setSpan(new IPCallRechargeUI.7(this), 0, paramBundle.length(), 33);
    this.lHT.setText(localSpannable);
    this.lHT.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = getContext();
    getString(2131755906);
    this.vcb = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131760457), true, new IPCallRechargeUI.8(this));
    aoS("");
    this.veN.start();
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 4L, 1L, true);
    AppMethodBeat.o(25889);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25890);
    super.onDestroy();
    this.veN.uZt = bu.fpO();
    this.veN.finish();
    bc.ajj().b(929, this);
    AppMethodBeat.o(25890);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(25895);
    ae.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.f))
    {
      paramString = this.veN;
      paramString.uZP = bu.fpO();
      paramString.uZQ = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.ipcall.model.e.f)paramn).uYY;
        this.veT.cjg = paramString.CellList;
        this.veT.veZ = paramString;
        this.veT.notifyDataSetChanged();
        this.pRh = new String[paramString.CellList.size()];
        Iterator localIterator = paramString.CellList.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          ebz localebz = (ebz)localIterator.next();
          this.pRh[paramInt1] = localebz.ProductID;
          paramInt1 += 1;
        }
        this.veL = paramString.GYJ;
        this.veM = paramString.GYK;
        this.veG = paramString.GYE;
        this.veH = paramString.GYI;
        this.veJ = paramString.GYH;
        if (this.veI)
        {
          this.veF = new String[paramString.CellList.size()];
          paramInt1 = 0;
          while (paramInt1 < this.veF.length)
          {
            this.veF[paramInt1] = paramString.GYI;
            paramInt1 += 1;
          }
          this.veE = new String[paramString.CellList.size()];
          paramInt1 = i;
          while (paramInt1 < this.veE.length)
          {
            this.veE[paramInt1] = IPCallDynamicTextView.aoR(((ebz)paramString.CellList.get(paramInt1)).HyQ);
            paramInt1 += 1;
          }
        }
        if (((com.tencent.mm.plugin.ipcall.model.e.f)paramn).uYZ)
        {
          ae.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
          if ((this.pRh != null) && (this.pRh.length > 0))
          {
            ae.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
            com.tencent.mm.pluginsdk.model.j.a(this, this.pRh, this.pRw);
          }
          AppMethodBeat.o(25895);
          return;
        }
        if ((this.vcb != null) && (this.vcb.isShowing())) {
          this.vcb.dismiss();
        }
        dhy();
        AppMethodBeat.o(25895);
        return;
      }
      if ((this.vcb != null) && (this.vcb.isShowing())) {
        this.vcb.dismiss();
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
    List<ebz> cjg;
    private IPCallRechargeUI veY;
    blq veZ;
    
    public a(IPCallRechargeUI paramIPCallRechargeUI)
    {
      AppMethodBeat.i(25884);
      this.cjg = null;
      this.veY = null;
      this.veZ = null;
      Assert.assertTrue(true);
      this.veY = paramIPCallRechargeUI;
      AppMethodBeat.o(25884);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25885);
      if (this.cjg == null)
      {
        AppMethodBeat.o(25885);
        return 0;
      }
      int i = this.cjg.size();
      AppMethodBeat.o(25885);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25886);
      if (this.cjg != null)
      {
        Object localObject = this.cjg.get(paramInt);
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
        paramView = ((LayoutInflater)this.veY.getSystemService("layout_inflater")).inflate(2131494523, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.vee = ((TextView)paramView.findViewById(2131306102));
        paramViewGroup.vfb = ((TextView)paramView.findViewById(2131306101));
        paramViewGroup.vfc = ((TextView)paramView.findViewById(2131306100));
        paramViewGroup.vfd = ((TextView)paramView.findViewById(2131306099));
        paramViewGroup.vfe = ((Button)paramView.findViewById(2131297576));
        paramView.setTag(paramViewGroup);
      }
      ebz localebz;
      for (;;)
      {
        localebz = (ebz)getItem(paramInt);
        if (localebz != null) {
          break;
        }
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.vee.setText(localebz.HyQ);
      paramViewGroup.vfb.setText(localebz.Ihz);
      paramViewGroup.vfc.setText(localebz.IhA);
      if (bu.isNullOrNil(localebz.IhA)) {
        paramViewGroup.vfc.setVisibility(8);
      }
      for (;;)
      {
        if (this.veZ != null) {
          paramViewGroup.vfd.setText(String.format(this.veY.getString(2131760479), new Object[] { a.apa(this.veZ.GYE), String.valueOf(localebz.Ihx) }));
        }
        paramViewGroup.vfe.setTag(Integer.valueOf(paramInt));
        paramViewGroup.vfe.setOnClickListener(new IPCallRechargeUI.a.1(this));
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup.vfc.setVisibility(0);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView vee;
      TextView vfb;
      TextView vfc;
      TextView vfd;
      Button vfe;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI
 * JD-Core Version:    0.7.0.1
 */