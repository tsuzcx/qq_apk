package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.e.g;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallRechargeUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  TextView kPB;
  private int lni;
  private String[] lnm;
  private h.a lnz;
  private ak mHandler;
  ProgressDialog nSa;
  private String[] nUE;
  private String[] nUF;
  private String nUG;
  private String nUH;
  private boolean nUI;
  private int nUJ;
  private int nUK;
  private String nUL;
  private String nUM;
  private com.tencent.mm.plugin.ipcall.a.e.h nUN;
  private g nUO;
  private j nUP;
  RelativeLayout nUQ;
  GridView nUR;
  ListView nUS;
  IPCallRechargeUI.a nUT;
  Button nUU;
  com.tencent.mm.plugin.ipcall.a.d.f nUV;
  
  public IPCallRechargeUI()
  {
    AppMethodBeat.i(22268);
    this.nUI = false;
    this.lni = -1;
    this.nUK = -1;
    this.nUN = new com.tencent.mm.plugin.ipcall.a.e.h();
    this.nUO = new g();
    this.nUP = new j();
    this.lnz = new IPCallRechargeUI.1(this);
    this.mHandler = new IPCallRechargeUI.3(this);
    AppMethodBeat.o(22268);
  }
  
  private void KT(String paramString)
  {
    AppMethodBeat.i(22273);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131300930);
    }
    com.tencent.mm.ui.base.h.a(this, str, getString(2131300930), new IPCallRechargeUI.12(this));
    AppMethodBeat.o(22273);
  }
  
  private void Rr(String paramString)
  {
    AppMethodBeat.i(22271);
    Object localObject = com.tencent.mm.plugin.ipcall.a.c.bIZ().bJc();
    if (((List)localObject).size() == 0) {}
    for (localObject = a.RB(com.tencent.mm.plugin.ipcall.b.c.bKM());; localObject = a.RB(((Integer)((List)localObject).get(0)).toString()))
    {
      this.nUV = new com.tencent.mm.plugin.ipcall.a.d.f((String)localObject, paramString);
      aw.Rc().a(this.nUV, 0);
      AppMethodBeat.o(22271);
      return;
    }
  }
  
  private boolean Rs(String paramString)
  {
    AppMethodBeat.i(22274);
    if ((com.tencent.mm.plugin.ipcall.b.c.bKN()) && (this.nUK >= 0))
    {
      Object localObject = this.nUT.getItem(this.nUK);
      if (((localObject instanceof cuw)) && (!bo.isNullOrNil(((cuw)localObject).ydF)))
      {
        localObject = ((cuw)localObject).ydF;
        ab.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(localObject)));
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131300930), getString(2131300905), getString(2131296888), true, new IPCallRechargeUI.2(this, (String)localObject), null);
        AppMethodBeat.o(22274);
        return true;
      }
    }
    AppMethodBeat.o(22274);
    return false;
  }
  
  public final void bKo()
  {
    AppMethodBeat.i(22276);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(1002);
    }
    AppMethodBeat.o(22276);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969946;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22272);
    ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(j), localObject, Integer.valueOf(paramInt1), Integer.valueOf(i), String.valueOf(bool1) });
      if ((j == 6) && (paramInt1 != 0))
      {
        this.nUO.nPI = paramInt1;
        if (i != 3) {
          break label349;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 9L, 1L, true);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 11L, 1L, true);
        this.nUO.nPI = 0L;
        this.nUO.nPJ = 2L;
        localObject = getString(2131300968);
        label234:
        this.nUO.nPH = l;
        this.nUO.nPq = bo.aoy();
        this.nUO.finish();
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
              ab.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[] { bo.nullAsNil((String)paramIntent.next()) });
              continue;
              this.nUO.nPI = j;
              break;
              label349:
              if (i != 1)
              {
                if ((paramInt2 == -1) && (j == 0))
                {
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 9L, 1L, true);
                  break label234;
                }
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 9L, 1L, true);
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 12L, 1L, true);
                  this.nUO.nPI = 0L;
                  this.nUO.nPJ = 1L;
                }
              }
              break label234;
            }
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 6L, 1L, true);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 10L, 1L, true);
          Toast.makeText(this, 2131300931, 0).show();
          finish();
          AppMethodBeat.o(22272);
          return;
        }
        if ((paramIntent != null) && (j == 100000002))
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 6L, 1L, true);
          KT((String)localObject);
          AppMethodBeat.o(22272);
          return;
        }
        if ((paramIntent != null) && (j == 109))
        {
          KT((String)localObject);
          AppMethodBeat.o(22272);
          return;
        }
        if ((paramIntent != null) && (j == 1))
        {
          paramIntent = getString(2131300929);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 8L, 1L, true);
          Toast.makeText(this, paramIntent, 0).show();
          AppMethodBeat.o(22272);
          return;
        }
        if ((paramIntent != null) && (j == 113))
        {
          com.tencent.mm.ui.base.h.a(this, getString(2131300914), getString(2131300930), new IPCallRechargeUI.10(this));
          AppMethodBeat.o(22272);
          return;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 7L, 1L, true);
        if (i == 3)
        {
          KT((String)localObject);
          AppMethodBeat.o(22272);
          return;
        }
        if ((j == 100000001) || (j == 6))
        {
          if (paramInt1 == 0)
          {
            Toast.makeText(this, getString(2131300853), 0).show();
            AppMethodBeat.o(22272);
            return;
          }
          paramIntent = getString(2131300855);
          if (!Rs(paramIntent)) {
            Toast.makeText(this, paramIntent, 0).show();
          }
        }
      }
      AppMethodBeat.o(22272);
      return;
      if (paramInt1 == 2002)
      {
        if ((this.nSa != null) && (this.nSa.isShowing())) {
          this.nSa.dismiss();
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
          ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(i), localObject, Integer.valueOf(paramInt1), String.valueOf(bool1) });
        }
        this.nUP.nPR = i;
        this.nUP.nPP = 0L;
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
        this.nUP.nPQ = 0L;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 15L, 1L, true);
        ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
        com.tencent.mm.ui.base.h.a(this, getString(2131300947), getString(2131300948), new IPCallRechargeUI.11(this));
      }
      for (;;)
      {
        this.nUP.nPq = bo.aoy();
        this.nUP.finish();
        AppMethodBeat.o(22272);
        return;
        label1010:
        this.nUP.nPQ = 3L;
        ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
        Toast.makeText(this, 2131300946, 0).show();
        continue;
        label1042:
        if (bool1)
        {
          this.nUP.nPQ = 1L;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 17L, 1L, true);
          localObject = getString(2131300946);
        }
        for (;;)
        {
          ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
          Toast.makeText(this, (CharSequence)localObject, 0).show();
          break;
          if (paramInt1 == 3)
          {
            this.nUP.nPQ = 2L;
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 16L, 1L, true);
          }
          else
          {
            this.nUP.nPQ = 2L;
          }
        }
        label1144:
        this.nUP.nPQ = 2L;
        ab.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
        Toast.makeText(this, 2131300945, 0).show();
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
    AppMethodBeat.i(22269);
    super.onCreate(paramBundle);
    aw.Rc().a(929, this);
    setMMTitle(2131300874);
    setBackBtn(new IPCallRechargeUI.5(this));
    addIconOptionMenu(0, 2130839668, new IPCallRechargeUI.6(this));
    this.nUQ = ((RelativeLayout)findViewById(2131824370));
    this.nUR = ((GridView)findViewById(2131825321));
    this.nUS = ((ListView)findViewById(2131825313));
    paramBundle = (ViewGroup)View.inflate(getContext(), 2130969944, null);
    this.nUS.addFooterView(paramBundle, null, false);
    this.nUT = new IPCallRechargeUI.a(this);
    this.nUS.setAdapter(this.nUT);
    this.kPB = ((TextView)paramBundle.findViewById(2131821071));
    this.nUU = ((Button)findViewById(2131825322));
    paramBundle = getString(2131300880);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramBundle);
    localSpannable.setSpan(new IPCallRechargeUI.7(this), 0, paramBundle.length(), 33);
    this.kPB.setText(localSpannable);
    this.kPB.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = getContext();
    getString(2131297087);
    this.nSa = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131300856), true, new IPCallRechargeUI.8(this));
    Rr("");
    this.nUN.start();
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 4L, 1L, true);
    AppMethodBeat.o(22269);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22270);
    super.onDestroy();
    this.nUN.nPq = bo.aoy();
    this.nUN.finish();
    aw.Rc().b(929, this);
    AppMethodBeat.o(22270);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(22275);
    ab.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.f))
    {
      paramString = this.nUN;
      paramString.nPM = bo.aoy();
      paramString.nPN = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.ipcall.a.d.f)paramm).nOV;
        this.nUT.nxh = paramString.CellList;
        this.nUT.nUZ = paramString;
        this.nUT.notifyDataSetChanged();
        this.lnm = new String[paramString.CellList.size()];
        Iterator localIterator = paramString.CellList.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          cuw localcuw = (cuw)localIterator.next();
          this.lnm[paramInt1] = localcuw.ProductID;
          paramInt1 += 1;
        }
        this.nUL = paramString.xhl;
        this.nUM = paramString.xhm;
        this.nUG = paramString.xhg;
        this.nUH = paramString.xhk;
        this.nUJ = paramString.xhj;
        if (this.nUI)
        {
          this.nUF = new String[paramString.CellList.size()];
          paramInt1 = 0;
          while (paramInt1 < this.nUF.length)
          {
            this.nUF[paramInt1] = paramString.xhk;
            paramInt1 += 1;
          }
          this.nUE = new String[paramString.CellList.size()];
          paramInt1 = i;
          while (paramInt1 < this.nUE.length)
          {
            this.nUE[paramInt1] = IPCallDynamicTextView.Rq(((cuw)paramString.CellList.get(paramInt1)).xBK);
            paramInt1 += 1;
          }
        }
        if (((com.tencent.mm.plugin.ipcall.a.d.f)paramm).nOW)
        {
          ab.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
          if ((this.lnm != null) && (this.lnm.length > 0))
          {
            ab.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
            com.tencent.mm.pluginsdk.model.h.a(this, this.lnm, this.lnz);
          }
          AppMethodBeat.o(22275);
          return;
        }
        if ((this.nSa != null) && (this.nSa.isShowing())) {
          this.nSa.dismiss();
        }
        bKo();
        AppMethodBeat.o(22275);
        return;
      }
      if ((this.nSa != null) && (this.nSa.isShowing())) {
        this.nSa.dismiss();
      }
      Toast.makeText(getContext(), getString(2131300853), 0).show();
      finish();
    }
    AppMethodBeat.o(22275);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI
 * JD-Core Version:    0.7.0.1
 */