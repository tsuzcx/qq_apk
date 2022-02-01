package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.a.c.1;
import com.tencent.mm.plugin.ipcall.model.e.f;
import com.tencent.mm.plugin.ipcall.model.f.g;
import com.tencent.mm.plugin.ipcall.model.f.j;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.model.k.a;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.ewg;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
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
  TextView jVn;
  private MMHandler mHandler;
  private int rid;
  private String[] rih;
  private k.a riw;
  ProgressDialog yuB;
  private String[] yxd;
  private String[] yxe;
  private String yxf;
  private String yxg;
  private boolean yxh;
  private int yxi;
  private int yxj;
  private String yxk;
  private String yxl;
  private com.tencent.mm.plugin.ipcall.model.f.h yxm;
  private g yxn;
  private j yxo;
  RelativeLayout yxp;
  GridView yxq;
  ListView yxr;
  a yxs;
  Button yxt;
  f yxu;
  
  public IPCallRechargeUI()
  {
    AppMethodBeat.i(25888);
    this.yxh = false;
    this.rid = -1;
    this.yxj = -1;
    this.yxm = new com.tencent.mm.plugin.ipcall.model.f.h();
    this.yxn = new g();
    this.yxo = new j();
    this.riw = new k.a()
    {
      public final void Y(ArrayList<com.tencent.mm.pluginsdk.model.q> paramAnonymousArrayList)
      {
        AppMethodBeat.i(25871);
        IPCallRechargeUI.a(IPCallRechargeUI.this).ysr = Util.nowMilliSecond();
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
        {
          IPCallRechargeUI.a(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          IPCallRechargeUI.b(IPCallRechargeUI.this, new String[paramAnonymousArrayList.size()]);
          com.tencent.mm.pluginsdk.model.q localq = (com.tencent.mm.pluginsdk.model.q)paramAnonymousArrayList.get(0);
          if (localq.JVq == 10232)
          {
            Log.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + paramAnonymousArrayList.size());
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            int i = 0;
            while (paramAnonymousArrayList.hasNext())
            {
              localq = (com.tencent.mm.pluginsdk.model.q)paramAnonymousArrayList.next();
              BigDecimal localBigDecimal = new BigDecimal(localq.JVp).divide(new BigDecimal(1000000));
              IPCallRechargeUI.b(IPCallRechargeUI.this)[i] = localBigDecimal.toString();
              IPCallRechargeUI.c(IPCallRechargeUI.this)[i] = localq.JVo;
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
            IPCallRechargeUI.this.asq();
            AppMethodBeat.o(25871);
            return;
          }
          if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
            IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
          }
          IPCallRechargeUI.a(IPCallRechargeUI.this, localq.JVq);
          Log.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(IPCallRechargeUI.this));
          IPCallRechargeUI.this.asq();
          AppMethodBeat.o(25871);
          return;
        }
        if ((IPCallRechargeUI.f(IPCallRechargeUI.this) != null) && (IPCallRechargeUI.f(IPCallRechargeUI.this).isShowing())) {
          IPCallRechargeUI.f(IPCallRechargeUI.this).dismiss();
        }
        Log.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
        IPCallRechargeUI.a(IPCallRechargeUI.this, 10236);
        IPCallRechargeUI.this.asq();
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
        IPCallRechargeUI.this.yxr.setVisibility(0);
        IPCallRechargeUI.k(IPCallRechargeUI.this);
        AppMethodBeat.o(25873);
      }
    };
    AppMethodBeat.o(25888);
  }
  
  private void aCm(String paramString)
  {
    AppMethodBeat.i(25891);
    Object localObject = com.tencent.mm.plugin.ipcall.model.c.ead().eag();
    if (((List)localObject).size() == 0) {}
    for (localObject = com.tencent.mm.plugin.ipcall.a.a.aCw(com.tencent.mm.plugin.ipcall.a.c.ebO());; localObject = com.tencent.mm.plugin.ipcall.a.a.aCw(((Integer)((List)localObject).get(0)).toString()))
    {
      this.yxu = new f((String)localObject, paramString);
      bg.azz().a(this.yxu, 0);
      AppMethodBeat.o(25891);
      return;
    }
  }
  
  private boolean aCn(String paramString)
  {
    AppMethodBeat.i(25894);
    if ((com.tencent.mm.plugin.ipcall.a.c.ebP()) && (this.yxj >= 0))
    {
      Object localObject = this.yxs.getItem(this.yxj);
      if (((localObject instanceof ewg)) && (!Util.isNullOrNil(((ewg)localObject).Nud)))
      {
        localObject = ((ewg)localObject).Nud;
        Log.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(localObject)));
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131761976), getString(2131761951), getString(2131755761), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25872);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 3L, 1L, true);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", this.yxw);
            paramAnonymousDialogInterface.putExtra("showShare", false);
            com.tencent.mm.br.c.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            AppMethodBeat.o(25872);
          }
        }, null);
        AppMethodBeat.o(25894);
        return true;
      }
    }
    AppMethodBeat.o(25894);
    return false;
  }
  
  private void amQ(String paramString)
  {
    AppMethodBeat.i(25893);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131761976);
    }
    com.tencent.mm.ui.base.h.d(this, str, getString(2131761976), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25893);
  }
  
  public final void asq()
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
    return 2131495116;
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
      Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(j), localObject, Integer.valueOf(paramInt1), Integer.valueOf(i), String.valueOf(bool1) });
      if ((j == 6) && (paramInt1 != 0))
      {
        this.yxn.ysl = paramInt1;
        if (i != 3) {
          break label349;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 9L, 1L, true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 11L, 1L, true);
        this.yxn.ysl = 0L;
        this.yxn.ysm = 2L;
        localObject = getString(2131762014);
        label234:
        this.yxn.ysk = l;
        this.yxn.yrT = Util.nowMilliSecond();
        this.yxn.finish();
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
              this.yxn.ysl = j;
              break;
              label349:
              if (i != 1)
              {
                if ((paramInt2 == -1) && (j == 0))
                {
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 9L, 1L, true);
                  break label234;
                }
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 9L, 1L, true);
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 12L, 1L, true);
                  this.yxn.ysl = 0L;
                  this.yxn.ysm = 1L;
                }
              }
              break label234;
            }
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 6L, 1L, true);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 10L, 1L, true);
          Toast.makeText(this, 2131761977, 0).show();
          finish();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 100000002))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 6L, 1L, true);
          amQ((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 109))
        {
          amQ((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 1))
        {
          paramIntent = getString(2131761975);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 8L, 1L, true);
          Toast.makeText(this, paramIntent, 0).show();
          AppMethodBeat.o(25892);
          return;
        }
        if ((paramIntent != null) && (j == 113))
        {
          com.tencent.mm.ui.base.h.d(this, getString(2131761960), getString(2131761976), new DialogInterface.OnClickListener()
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
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 7L, 1L, true);
        if (i == 3)
        {
          amQ((String)localObject);
          AppMethodBeat.o(25892);
          return;
        }
        if ((j == 100000001) || (j == 6))
        {
          if (paramInt1 == 0)
          {
            Toast.makeText(this, getString(2131761899), 0).show();
            AppMethodBeat.o(25892);
            return;
          }
          paramIntent = getString(2131761901);
          if (!aCn(paramIntent)) {
            Toast.makeText(this, paramIntent, 0).show();
          }
        }
      }
      AppMethodBeat.o(25892);
      return;
      if (paramInt1 == 2002)
      {
        if ((this.yuB != null) && (this.yuB.isShowing())) {
          this.yuB.dismiss();
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
        this.yxo.ysu = i;
        this.yxo.yss = 0L;
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
        this.yxo.yst = 0L;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 15L, 1L, true);
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
        com.tencent.mm.ui.base.h.d(this, getString(2131761993), getString(2131761994), new DialogInterface.OnClickListener()
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
        this.yxo.yrT = Util.nowMilliSecond();
        this.yxo.finish();
        AppMethodBeat.o(25892);
        return;
        label1010:
        this.yxo.yst = 3L;
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
        Toast.makeText(this, 2131761992, 0).show();
        continue;
        label1042:
        if (bool1)
        {
          this.yxo.yst = 1L;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 17L, 1L, true);
          localObject = getString(2131761992);
        }
        for (;;)
        {
          Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
          Toast.makeText(this, (CharSequence)localObject, 0).show();
          break;
          if (paramInt1 == 3)
          {
            this.yxo.yst = 2L;
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 16L, 1L, true);
          }
          else
          {
            this.yxo.yst = 2L;
          }
        }
        label1144:
        this.yxo.yst = 2L;
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
        Toast.makeText(this, 2131761991, 0).show();
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
    bg.azz().a(929, this);
    setMMTitle(2131761920);
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
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25876);
        IPCallRechargeUI.h(IPCallRechargeUI.this);
        AppMethodBeat.o(25876);
        return true;
      }
    });
    this.yxp = ((RelativeLayout)findViewById(2131303060));
    this.yxq = ((GridView)findViewById(2131306640));
    this.yxr = ((ListView)findViewById(2131306644));
    paramBundle = (ViewGroup)View.inflate(getContext(), 2131495114, null);
    this.yxr.addFooterView(paramBundle, null, false);
    this.yxs = new a(this);
    this.yxr.setAdapter(this.yxs);
    this.jVn = ((TextView)paramBundle.findViewById(2131309163));
    this.yxt = ((Button)findViewById(2131297941));
    paramBundle = getString(2131761926);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramBundle);
    localSpannable.setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25877);
        ((TextView)paramAnonymousView).setHighlightColor(IPCallRechargeUI.this.getResources().getColor(2131101287));
        Intent localIntent = new Intent();
        paramAnonymousView = IPCallRechargeUI.this.getString(2131761925) + "&usedcc=";
        Object localObject = com.tencent.mm.plugin.ipcall.model.c.ead().eag();
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
            String str = com.tencent.mm.plugin.ipcall.a.a.aCw(((Integer)((List)localObject).get(j)).toString());
            if (Util.isNullOrNil(str)) {
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
          for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + com.tencent.mm.plugin.ipcall.a.a.aCw(com.tencent.mm.plugin.ipcall.a.c.ebO()))
          {
            localIntent.putExtra("rawUrl", (String)localObject);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.br.c.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(25877);
            return;
          }
        }
      }
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        AppMethodBeat.i(25878);
        paramAnonymousTextPaint.setColor(IPCallRechargeUI.this.getResources().getColor(2131100685));
        paramAnonymousTextPaint.setUnderlineText(false);
        AppMethodBeat.o(25878);
      }
    }, 0, paramBundle.length(), 33);
    this.jVn.setText(localSpannable);
    this.jVn.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = getContext();
    getString(2131755998);
    this.yuB = com.tencent.mm.ui.base.h.a(paramBundle, getString(2131761902), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25879);
        try
        {
          if (IPCallRechargeUI.this.yxu != null) {
            bg.azz().a(IPCallRechargeUI.this.yxu);
          }
          IPCallRechargeUI.this.finish();
          AppMethodBeat.o(25879);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          Log.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
          AppMethodBeat.o(25879);
        }
      }
    });
    aCm("");
    this.yxm.start();
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 4L, 1L, true);
    AppMethodBeat.o(25889);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25890);
    super.onDestroy();
    this.yxm.yrT = Util.nowMilliSecond();
    this.yxm.finish();
    bg.azz().b(929, this);
    AppMethodBeat.o(25890);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(25895);
    Log.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof f))
    {
      paramString = this.yxm;
      paramString.ysp = Util.nowMilliSecond();
      paramString.ysq = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramq).yry;
        this.yxs.cvc = paramString.CellList;
        this.yxs.yxy = paramString;
        this.yxs.notifyDataSetChanged();
        this.rih = new String[paramString.CellList.size()];
        Iterator localIterator = paramString.CellList.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          ewg localewg = (ewg)localIterator.next();
          this.rih[paramInt1] = localewg.ProductID;
          paramInt1 += 1;
        }
        this.yxk = paramString.Mdz;
        this.yxl = paramString.MdA;
        this.yxf = paramString.Mdu;
        this.yxg = paramString.Mdy;
        this.yxi = paramString.Mdx;
        if (this.yxh)
        {
          this.yxe = new String[paramString.CellList.size()];
          paramInt1 = 0;
          while (paramInt1 < this.yxe.length)
          {
            this.yxe[paramInt1] = paramString.Mdy;
            paramInt1 += 1;
          }
          this.yxd = new String[paramString.CellList.size()];
          paramInt1 = i;
          while (paramInt1 < this.yxd.length)
          {
            this.yxd[paramInt1] = IPCallDynamicTextView.aCl(((ewg)paramString.CellList.get(paramInt1)).MJz);
            paramInt1 += 1;
          }
        }
        if (((f)paramq).yrz)
        {
          Log.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
          if ((this.rih != null) && (this.rih.length > 0))
          {
            Log.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
            k.a(this, this.rih, this.riw);
          }
          AppMethodBeat.o(25895);
          return;
        }
        if ((this.yuB != null) && (this.yuB.isShowing())) {
          this.yuB.dismiss();
        }
        asq();
        AppMethodBeat.o(25895);
        return;
      }
      if ((this.yuB != null) && (this.yuB.isShowing())) {
        this.yuB.dismiss();
      }
      Toast.makeText(getContext(), getString(2131761899), 0).show();
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
    List<ewg> cvc;
    private IPCallRechargeUI yxx;
    bxz yxy;
    
    public a(IPCallRechargeUI paramIPCallRechargeUI)
    {
      AppMethodBeat.i(25884);
      this.cvc = null;
      this.yxx = null;
      this.yxy = null;
      Assert.assertTrue(true);
      this.yxx = paramIPCallRechargeUI;
      AppMethodBeat.o(25884);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25885);
      if (this.cvc == null)
      {
        AppMethodBeat.o(25885);
        return 0;
      }
      int i = this.cvc.size();
      AppMethodBeat.o(25885);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25886);
      if (this.cvc != null)
      {
        Object localObject = this.cvc.get(paramInt);
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
        paramView = ((LayoutInflater)this.yxx.getSystemService("layout_inflater")).inflate(2131495115, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.ywE = ((TextView)paramView.findViewById(2131309445));
        paramViewGroup.yxA = ((TextView)paramView.findViewById(2131309444));
        paramViewGroup.yxB = ((TextView)paramView.findViewById(2131309443));
        paramViewGroup.yxC = ((TextView)paramView.findViewById(2131309442));
        paramViewGroup.yxD = ((Button)paramView.findViewById(2131297815));
        paramView.setTag(paramViewGroup);
      }
      ewg localewg;
      for (;;)
      {
        localewg = (ewg)getItem(paramInt);
        if (localewg != null) {
          break;
        }
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.ywE.setText(localewg.MJz);
      paramViewGroup.yxA.setText(localewg.Nua);
      paramViewGroup.yxB.setText(localewg.Nub);
      if (Util.isNullOrNil(localewg.Nub)) {
        paramViewGroup.yxB.setVisibility(8);
      }
      for (;;)
      {
        if (this.yxy != null) {
          paramViewGroup.yxC.setText(String.format(this.yxx.getString(2131761924), new Object[] { com.tencent.mm.plugin.ipcall.a.a.aCu(this.yxy.Mdu), String.valueOf(localewg.NtY) }));
        }
        paramViewGroup.yxD.setTag(Integer.valueOf(paramInt));
        paramViewGroup.yxD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(25883);
            Object localObject = new b();
            ((b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
            localObject = IPCallRechargeUI.this;
            if (!ChannelUtil.isGPVersion())
            {
              localObject = new d.a((Context)localObject);
              ((d.a)localObject).aoS(2131761989);
              ((d.a)localObject).aoV(2131755874).c(new c.1());
              ((d.a)localObject).hbn().show();
            }
            for (int i = 1; i != 0; i = 0)
            {
              Log.i("MicroMsg.IPCallRechargeUI", "onClick recharged, non gp version!");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25883);
              return;
            }
            IPCallRechargeUI.b(IPCallRechargeUI.this, ((Integer)paramAnonymousView.getTag()).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25883);
          }
        });
        AppMethodBeat.o(25887);
        return paramView;
        paramViewGroup.yxB.setVisibility(0);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView ywE;
      TextView yxA;
      TextView yxB;
      TextView yxC;
      Button yxD;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI
 * JD-Core Version:    0.7.0.1
 */