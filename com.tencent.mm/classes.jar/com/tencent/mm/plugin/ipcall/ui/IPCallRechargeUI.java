package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.e.f;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.dox;
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
  implements com.tencent.mm.al.g
{
  TextView kFd;
  private ap mHandler;
  private String[] oDA;
  private j.a oDP;
  private int oDw;
  ProgressDialog sFV;
  private String sIA;
  private String sIB;
  private boolean sIC;
  private int sID;
  private int sIE;
  private String sIF;
  private String sIG;
  private com.tencent.mm.plugin.ipcall.model.f.h sIH;
  private com.tencent.mm.plugin.ipcall.model.f.g sII;
  private com.tencent.mm.plugin.ipcall.model.f.j sIJ;
  RelativeLayout sIK;
  GridView sIL;
  ListView sIM;
  a sIN;
  Button sIO;
  f sIP;
  private String[] sIy;
  private String[] sIz;
  
  public IPCallRechargeUI()
  {
    AppMethodBeat.i(25888);
    this.sIC = false;
    this.oDw = -1;
    this.sIE = -1;
    this.sIH = new com.tencent.mm.plugin.ipcall.model.f.h();
    this.sII = new com.tencent.mm.plugin.ipcall.model.f.g();
    this.sIJ = new com.tencent.mm.plugin.ipcall.model.f.j();
    this.oDP = new j.a()
    {
      public final void M(ArrayList<p> paramAnonymousArrayList)
      {
        AppMethodBeat.i(25871);
        IPCallRechargeUI.a(IPCallRechargeUI.this).sDJ = bt.eGO();
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
        {
          IPCallRechargeUI.a(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          IPCallRechargeUI.b(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          p localp = (p)paramAnonymousArrayList.get(0);
          if (localp.BPd == 10232)
          {
            ad.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + paramAnonymousArrayList.size());
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            int i = 0;
            while (paramAnonymousArrayList.hasNext())
            {
              localp = (p)paramAnonymousArrayList.next();
              BigDecimal localBigDecimal = new BigDecimal(localp.BPc).divide(new BigDecimal(1000000));
              IPCallRechargeUI.b(IPCallRechargeUI.this)[i] = localBigDecimal.toString();
              IPCallRechargeUI.c(IPCallRechargeUI.this)[i] = localp.BPb;
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
            IPCallRechargeUI.this.cIk();
            AppMethodBeat.o(25871);
            return;
          }
          if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
            IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
          }
          IPCallRechargeUI.a(IPCallRechargeUI.this, localp.BPd);
          ad.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(IPCallRechargeUI.this));
          IPCallRechargeUI.this.cIk();
          AppMethodBeat.o(25871);
          return;
        }
        if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
          IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
        }
        ad.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
        IPCallRechargeUI.a(IPCallRechargeUI.this, 10236);
        IPCallRechargeUI.this.cIk();
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
        IPCallRechargeUI.this.sIM.setVisibility(0);
        IPCallRechargeUI.k(IPCallRechargeUI.this);
        AppMethodBeat.o(25873);
      }
    };
    AppMethodBeat.o(25888);
  }
  
  private void Ua(String paramString)
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
  
  private void ael(String paramString)
  {
    AppMethodBeat.i(25891);
    Object localObject = com.tencent.mm.plugin.ipcall.model.c.cGV().cGY();
    if (((List)localObject).size() == 0) {}
    for (localObject = a.aev(com.tencent.mm.plugin.ipcall.a.c.cIJ());; localObject = a.aev(((Integer)((List)localObject).get(0)).toString()))
    {
      this.sIP = new f((String)localObject, paramString);
      az.aeS().a(this.sIP, 0);
      AppMethodBeat.o(25891);
      return;
    }
  }
  
  private boolean aem(String paramString)
  {
    AppMethodBeat.i(25894);
    if ((com.tencent.mm.plugin.ipcall.a.c.cIK()) && (this.sIE >= 0))
    {
      Object localObject = this.sIN.getItem(this.sIE);
      if (((localObject instanceof dox)) && (!bt.isNullOrNil(((dox)localObject).EFm)))
      {
        localObject = ((dox)localObject).EFm;
        ad.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(localObject)));
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131760531), getString(2131760506), getString(2131755691), true, new IPCallRechargeUI.2(this, (String)localObject), null);
        AppMethodBeat.o(25894);
        return true;
      }
    }
    AppMethodBeat.o(25894);
    return false;
  }
  
  public final void cIk()
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
        this.sII.sDD = paramInt1;
        if (i != 3) {
          break label349;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 9L, 1L, true);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 11L, 1L, true);
        this.sII.sDD = 0L;
        this.sII.sDE = 2L;
        localObject = getString(2131760569);
        label234:
        this.sII.sDC = l;
        this.sII.sDl = bt.eGO();
        this.sII.finish();
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
              this.sII.sDD = j;
              break;
              label349:
              if (i != 1)
              {
                if ((paramInt2 == -1) && (j == 0))
                {
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 9L, 1L, true);
                  break label234;
                }
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 9L, 1L, true);
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 12L, 1L, true);
                  this.sII.sDD = 0L;
                  this.sII.sDE = 1L;
                }
              }
              break label234;
            }
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 6L, 1L, true);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 10L, 1L, true);
          Toast.makeText(this, 2131760532, 0).show();
          finish();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 100000002))
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 6L, 1L, true);
          Ua((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 109))
        {
          Ua((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 1))
        {
          paramIntent = getString(2131760530);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 8L, 1L, true);
          Toast.makeText(this, paramIntent, 0).show();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 113))
        {
          com.tencent.mm.ui.base.h.d(this, getString(2131760515), getString(2131760531), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(25881);
              IPCallRechargeUI.j(IPCallRechargeUI.this);
              AppMethodBeat.o(25881);
            }
          });
          AppMethodBeat.o(25892);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 7L, 1L, true);
        if (i == 3)
        {
          Ua((String)localObject);
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
          if (!aem(paramIntent)) {
            Toast.makeText(this, paramIntent, 0).show();
          }
        }
      }
      AppMethodBeat.o(25892);
      return;
      if (paramInt1 == 2002)
      {
        if ((this.sFV != null) && (this.sFV.isShowing())) {
          this.sFV.dismiss();
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
        this.sIJ.sDM = i;
        this.sIJ.sDK = 0L;
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
        this.sIJ.sDL = 0L;
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 15L, 1L, true);
        ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
        com.tencent.mm.ui.base.h.d(this, getString(2131760548), getString(2131760549), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25882);
            IPCallRechargeUI.this.finish();
            AppMethodBeat.o(25882);
          }
        });
      }
      for (;;)
      {
        this.sIJ.sDl = bt.eGO();
        this.sIJ.finish();
        AppMethodBeat.o(25892);
        return;
        label1010:
        this.sIJ.sDL = 3L;
        ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
        Toast.makeText(this, 2131760547, 0).show();
        continue;
        label1042:
        if (bool1)
        {
          this.sIJ.sDL = 1L;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 17L, 1L, true);
          localObject = getString(2131760547);
        }
        for (;;)
        {
          ad.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
          Toast.makeText(this, (CharSequence)localObject, 0).show();
          break;
          if (paramInt1 == 3)
          {
            this.sIJ.sDL = 2L;
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 16L, 1L, true);
          }
          else
          {
            this.sIJ.sDL = 2L;
          }
        }
        label1144:
        this.sIJ.sDL = 2L;
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
    az.aeS().a(929, this);
    setMMTitle(2131760475);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25875);
        IPCallRechargeUI.this.finish();
        AppMethodBeat.o(25875);
        return true;
      }
    });
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
    this.sIK = ((RelativeLayout)findViewById(2131301339));
    this.sIL = ((GridView)findViewById(2131303833));
    this.sIM = ((ListView)findViewById(2131303837));
    paramBundle = (ViewGroup)View.inflate(getContext(), 2131494522, null);
    this.sIM.addFooterView(paramBundle, null, false);
    this.sIN = new a(this);
    this.sIM.setAdapter(this.sIN);
    this.kFd = ((TextView)paramBundle.findViewById(2131305880));
    this.sIO = ((Button)findViewById(2131297671));
    paramBundle = getString(2131760481);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramBundle);
    localSpannable.setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25877);
        ((TextView)paramAnonymousView).setHighlightColor(IPCallRechargeUI.this.getResources().getColor(2131101053));
        Intent localIntent = new Intent();
        paramAnonymousView = IPCallRechargeUI.this.getString(2131760480) + "&usedcc=";
        Object localObject = com.tencent.mm.plugin.ipcall.model.c.cGV().cGY();
        int j;
        if (((List)localObject).size() > 0)
        {
          j = ((List)localObject).size();
          int i = j;
          if (j > 5) {
            i = 5;
          }
          j = 0;
          if (j < i)
          {
            String str = a.aev(((Integer)((List)localObject).get(j)).toString());
            if (bt.isNullOrNil(str)) {
              break label255;
            }
            paramAnonymousView = paramAnonymousView + str + "|";
          }
        }
        label255:
        for (;;)
        {
          j += 1;
          break;
          localObject = paramAnonymousView;
          if (paramAnonymousView.endsWith("|")) {}
          for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + a.aev(com.tencent.mm.plugin.ipcall.a.c.cIJ()))
          {
            localIntent.putExtra("rawUrl", (String)localObject);
            localIntent.putExtra("showShare", false);
            d.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(25877);
            return;
          }
        }
      }
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        AppMethodBeat.i(25878);
        paramAnonymousTextPaint.setColor(IPCallRechargeUI.this.getResources().getColor(2131100547));
        paramAnonymousTextPaint.setUnderlineText(false);
        AppMethodBeat.o(25878);
      }
    }, 0, paramBundle.length(), 33);
    this.kFd.setText(localSpannable);
    this.kFd.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = getContext();
    getString(2131755906);
    this.sFV = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131760457), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25879);
        try
        {
          if (IPCallRechargeUI.this.sIP != null) {
            az.aeS().a(IPCallRechargeUI.this.sIP);
          }
          IPCallRechargeUI.this.finish();
          AppMethodBeat.o(25879);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          ad.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
          AppMethodBeat.o(25879);
        }
      }
    });
    ael("");
    this.sIH.start();
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 4L, 1L, true);
    AppMethodBeat.o(25889);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25890);
    super.onDestroy();
    this.sIH.sDl = bt.eGO();
    this.sIH.finish();
    az.aeS().b(929, this);
    AppMethodBeat.o(25890);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(25895);
    ad.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof f))
    {
      paramString = this.sIH;
      paramString.sDH = bt.eGO();
      paramString.sDI = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramn).sCQ;
        this.sIN.cbP = paramString.CellList;
        this.sIN.sIT = paramString;
        this.sIN.notifyDataSetChanged();
        this.oDA = new String[paramString.CellList.size()];
        Iterator localIterator = paramString.CellList.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          dox localdox = (dox)localIterator.next();
          this.oDA[paramInt1] = localdox.ProductID;
          paramInt1 += 1;
        }
        this.sIF = paramString.DAn;
        this.sIG = paramString.DAo;
        this.sIA = paramString.DAi;
        this.sIB = paramString.DAm;
        this.sID = paramString.DAl;
        if (this.sIC)
        {
          this.sIz = new String[paramString.CellList.size()];
          paramInt1 = 0;
          while (paramInt1 < this.sIz.length)
          {
            this.sIz[paramInt1] = paramString.DAm;
            paramInt1 += 1;
          }
          this.sIy = new String[paramString.CellList.size()];
          paramInt1 = i;
          while (paramInt1 < this.sIy.length)
          {
            this.sIy[paramInt1] = IPCallDynamicTextView.aek(((dox)paramString.CellList.get(paramInt1)).DYr);
            paramInt1 += 1;
          }
        }
        if (((f)paramn).sCR)
        {
          ad.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
          if ((this.oDA != null) && (this.oDA.length > 0))
          {
            ad.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
            com.tencent.mm.pluginsdk.model.j.a(this, this.oDA, this.oDP);
          }
          AppMethodBeat.o(25895);
          return;
        }
        if ((this.sFV != null) && (this.sFV.isShowing())) {
          this.sFV.dismiss();
        }
        cIk();
        AppMethodBeat.o(25895);
        return;
      }
      if ((this.sFV != null) && (this.sFV.isShowing())) {
        this.sFV.dismiss();
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
    List<dox> cbP;
    private IPCallRechargeUI sIS;
    bcy sIT;
    
    public a(IPCallRechargeUI paramIPCallRechargeUI)
    {
      AppMethodBeat.i(25884);
      this.cbP = null;
      this.sIS = null;
      this.sIT = null;
      Assert.assertTrue(true);
      this.sIS = paramIPCallRechargeUI;
      AppMethodBeat.o(25884);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25885);
      if (this.cbP == null)
      {
        AppMethodBeat.o(25885);
        return 0;
      }
      int i = this.cbP.size();
      AppMethodBeat.o(25885);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25886);
      if (this.cbP != null)
      {
        Object localObject = this.cbP.get(paramInt);
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
        paramView = ((LayoutInflater)this.sIS.getSystemService("layout_inflater")).inflate(2131494523, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.sHY = ((TextView)paramView.findViewById(2131306102));
        paramViewGroup.sIV = ((TextView)paramView.findViewById(2131306101));
        paramViewGroup.sIW = ((TextView)paramView.findViewById(2131306100));
        paramViewGroup.sIX = ((TextView)paramView.findViewById(2131306099));
        paramViewGroup.sIY = ((Button)paramView.findViewById(2131297576));
        paramView.setTag(paramViewGroup);
      }
      dox localdox;
      for (;;)
      {
        localdox = (dox)getItem(paramInt);
        if (localdox != null) {
          break;
        }
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.sHY.setText(localdox.DYr);
      paramViewGroup.sIV.setText(localdox.EFj);
      paramViewGroup.sIW.setText(localdox.EFk);
      if (bt.isNullOrNil(localdox.EFk)) {
        paramViewGroup.sIW.setVisibility(8);
      }
      for (;;)
      {
        if (this.sIT != null) {
          paramViewGroup.sIX.setText(String.format(this.sIS.getString(2131760479), new Object[] { a.aet(this.sIT.DAi), String.valueOf(localdox.EFh) }));
        }
        paramViewGroup.sIY.setTag(Integer.valueOf(paramInt));
        paramViewGroup.sIY.setOnClickListener(new IPCallRechargeUI.a.1(this));
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup.sIW.setVisibility(0);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView sHY;
      TextView sIV;
      TextView sIW;
      TextView sIX;
      Button sIY;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI
 * JD-Core Version:    0.7.0.1
 */