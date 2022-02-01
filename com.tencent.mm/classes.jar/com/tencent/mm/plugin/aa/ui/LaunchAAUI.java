package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.r;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.aa.model.b.e.b;
import com.tencent.mm.plugin.aa.model.b.e.c;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AALaunchItemParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AAOperationInfoParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.PfInfoParcel;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LaunchAAUI
  extends BaseAAPresenterActivity
{
  private String chatroomName;
  private String hym;
  private int iUK;
  private Dialog iUL;
  private TextView iUX;
  private String iVO;
  private Dialog iVd;
  private boolean iWA;
  private MMEditText iWB;
  private TextView iWC;
  private TextView iWD;
  private RelativeLayout iWE;
  private ImageView iWF;
  private ImageView iWG;
  private TextView iWH;
  private TextView iWI;
  private WalletFormView iWJ;
  private TextView iWK;
  private TextView iWL;
  private ViewGroup iWM;
  private ViewGroup iWN;
  private List<String> iWO;
  private ViewGroup iWP;
  private ViewGroup iWQ;
  private TextView iWR;
  private ViewGroup iWS;
  private Map<String, Double> iWT;
  private Map<String, LaunchAAByPersonNameAmountRow> iWU;
  private Button iWV;
  private TextView iWW;
  private TextView iWX;
  private com.tencent.mm.plugin.aa.model.e iWY;
  private int iWZ;
  private boolean iWh;
  private com.tencent.mm.plugin.aa.model.b.e iWz;
  private int iXa;
  private boolean iXb;
  private String iXc;
  private long iXd;
  private String iXe;
  private NetSceneNewAAQueryPFInfo.PfInfoParcel iXf;
  private boolean iXg;
  private com.tencent.mm.sdk.b.c<kz> iXh;
  private String imagePath;
  private int mode;
  private int scene;
  private long timestamp;
  private Dialog tipDialog;
  
  public LaunchAAUI()
  {
    AppMethodBeat.i(63668);
    this.iWz = ((com.tencent.mm.plugin.aa.model.b.e)am(com.tencent.mm.plugin.aa.model.b.e.class));
    this.mode = com.tencent.mm.plugin.aa.model.a.iRW;
    this.chatroomName = null;
    this.iWA = false;
    this.iWh = false;
    this.iWO = new ArrayList();
    this.iWT = new HashMap();
    this.iWU = new HashMap();
    this.iWY = new com.tencent.mm.plugin.aa.model.e();
    this.iWZ = 0;
    this.iXa = 0;
    this.iXb = false;
    this.timestamp = 0L;
    this.hym = "";
    this.iXf = null;
    this.iXg = false;
    this.iUL = null;
    this.iXh = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(63668);
  }
  
  private void Jh(String paramString)
  {
    AppMethodBeat.i(63676);
    this.iXb = true;
    this.iWW.setVisibility(0);
    this.iWW.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
    this.iWW.setText(paramString);
    AppMethodBeat.o(63676);
  }
  
  private void Ji(final String paramString)
  {
    AppMethodBeat.i(63681);
    ad.i("MicroMsg.Aa.LaunchAAUI", "showLaunchComfirmDialog() from scene:%s", new Object[] { Integer.valueOf(this.scene) });
    String str = this.iWB.getText().toString();
    if (bt.isNullOrNil(str)) {
      str = getString(2131760652);
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.j.class)).a(getController(), paramString, getString(2131755032) + str, getString(2131755031), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(198926);
          if (paramAnonymousBoolean)
          {
            LaunchAAUI.b(LaunchAAUI.this, paramString);
            LaunchAAUI.this.rf(12);
            AppMethodBeat.o(198926);
            return;
          }
          LaunchAAUI.this.rf(13);
          AppMethodBeat.o(198926);
        }
      });
      rf(11);
      AppMethodBeat.o(63681);
      return;
    }
  }
  
  public static boolean Jj(String paramString)
  {
    AppMethodBeat.i(63693);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63693);
      return false;
    }
    boolean bool = aJ(i.Jd(paramString));
    AppMethodBeat.o(63693);
    return bool;
  }
  
  private void a(Context paramContext, String paramString1, int paramInt, String paramString2, double paramDouble, List<String> paramList)
  {
    AppMethodBeat.i(63683);
    a(paramContext, paramString1, paramInt, paramString2, paramDouble, paramList, "", "");
    AppMethodBeat.o(63683);
  }
  
  private void a(final Context paramContext, final String paramString1, int paramInt, String paramString2, double paramDouble, List<String> paramList, String paramString3, String paramString4)
  {
    AppMethodBeat.i(63684);
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iSW, paramString2);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iSX, Double.valueOf(100.0D * paramDouble));
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTa, paramString1);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTd, Long.valueOf(this.timestamp));
    long l = com.tencent.mm.wallet_core.ui.e.a(i.bO(new StringBuilder().append(paramDouble).toString(), "100"), String.valueOf(paramInt), RoundingMode.CEILING);
    ad.d("MicroMsg.Aa.LaunchAAUI", "perAmount: %s", new Object[] { Long.valueOf(l) });
    if ((l <= 0L) || (l > com.tencent.mm.plugin.aa.model.e.aRe()))
    {
      ad.i("MicroMsg.Aa.LaunchAAUI", "illegal avgAmount: %s", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(63684);
      return;
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iSZ, Long.valueOf(l));
    if (aRz())
    {
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTe, paramString3);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTf, paramString4);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTg, this.iVO);
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTc, paramList);
    this.iWz.iUl.c(this.mode, localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void ce(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(63658);
        ad.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        if (LaunchAAUI.v(LaunchAAUI.this) != null) {
          LaunchAAUI.v(LaunchAAUI.this).dismiss();
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
          h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131760658), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(182446);
              ad.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
              AppMethodBeat.o(182446);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(13722, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(63658);
          return;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof z)))
          {
            i.a(LaunchAAUI.this.getContext(), (z)paramAnonymousObject);
          }
          else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
          {
            paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
            String str1 = paramAnonymousObject.dxD;
            String str2 = paramAnonymousObject.kzK;
            String str3 = paramAnonymousObject.kzL;
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
            locala.aXG(str1);
            locala.aXM(str3).c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182447);
                com.tencent.mm.wallet_core.ui.e.o(LaunchAAUI.this.getContext(), paramAnonymousObject.paG, false);
                AppMethodBeat.o(182447);
              }
            });
            locala.aXN(str2);
            locala.fMb().show();
          }
          else
          {
            Toast.makeText(paramContext, 2131760656, 1).show();
          }
        }
      }
    });
    AppMethodBeat.o(63684);
  }
  
  private void a(final Context paramContext, final String paramString1, String paramString2, String paramString3, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(63685);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(7, 5);
    com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.iWB.getText().toString();
        if (bt.isNullOrNil(str1))
        {
          str1 = getString(2131760652);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator = this.iWT.keySet().iterator();
          long l1 = 0L;
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if ((!paramBoolean) || (paramList.contains(str2)))
            {
              double d = ((Double)this.iWT.get(str2)).doubleValue();
              com.tencent.mm.protocal.protobuf.j localj = new com.tencent.mm.protocal.protobuf.j();
              localj.dOa = com.tencent.mm.wallet_core.ui.e.mI(String.valueOf(d), "100");
              localj.username = str2;
              localArrayList1.add(localj);
              long l2 = localj.dOa;
              localArrayList2.add(localj.dOa);
              l1 = l2 + l1;
            }
          }
          else
          {
            paramList = new com.tencent.mm.protocal.protobuf.j();
            paramList.username = u.aAm();
            paramList.dOa = l1;
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iSW, str1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iSX, Long.valueOf(l1));
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTc, localArrayList1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTa, paramString1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTd, Long.valueOf(this.timestamp));
            if (aRz())
            {
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTe, paramString2);
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTf, paramString3);
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.iTg, this.iVO);
            }
            this.iWz.iUm.x(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
            {
              public final void ce(final Object paramAnonymousObject)
              {
                AppMethodBeat.i(198937);
                ad.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
                if (LaunchAAUI.v(LaunchAAUI.this) != null) {
                  LaunchAAUI.v(LaunchAAUI.this).dismiss();
                }
                if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
                  h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131760658), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(198935);
                      ad.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                      AppMethodBeat.o(198935);
                    }
                  });
                }
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.f(13722, new Object[] { Integer.valueOf(10) });
                  AppMethodBeat.o(198937);
                  return;
                  if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof z)))
                  {
                    i.a(LaunchAAUI.this.getContext(), (z)paramAnonymousObject);
                  }
                  else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
                  {
                    paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
                    String str1 = paramAnonymousObject.dxD;
                    String str2 = paramAnonymousObject.kzK;
                    String str3 = paramAnonymousObject.kzL;
                    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
                    locala.aXG(str1);
                    locala.aXM(str3).c(new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(198936);
                        com.tencent.mm.wallet_core.ui.e.o(LaunchAAUI.this.getContext(), paramAnonymousObject.paG, false);
                        AppMethodBeat.o(198936);
                      }
                    });
                    locala.aXN(str2);
                    locala.fMb().show();
                  }
                  else
                  {
                    Toast.makeText(paramContext, 2131760656, 1).show();
                  }
                }
              }
            });
            com.tencent.mm.plugin.report.service.g.yhR.f(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(i.Jd(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, bt.m(localArrayList2, ",") });
            AppMethodBeat.o(63685);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        ad.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPerson error: %s", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(63685);
        return;
      }
    }
  }
  
  private void a(Context paramContext, String paramString, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63682);
    rf(9);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iRW)
    {
      if (bt.isNullOrNil(this.iWJ.getText()))
      {
        AppMethodBeat.o(63682);
        return;
      }
      if ((this.iWO == null) || (this.iWO.size() == 0))
      {
        AppMethodBeat.o(63682);
        return;
      }
      aRG();
      com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
      if ((paramBoolean) && (paramArrayList == null)) {}
    }
    for (;;)
    {
      try
      {
        i = paramArrayList.size();
        double d = bt.getDouble(this.iUX.getText().toString(), 0.0D) * i;
        String str2 = this.iWB.getText().toString();
        String str1 = str2;
        if (bt.isNullOrNil(str2)) {
          str1 = getString(2131760652);
        }
        if (i > 0)
        {
          if (this.iVd != null) {
            this.iVd.dismiss();
          }
          this.iVd = com.tencent.mm.wallet_core.ui.g.c(paramContext, false, null);
          if ((aRz()) && (!bt.isNullOrNil(this.imagePath))) {
            new com.tencent.mm.plugin.aa.model.d(this.imagePath, new LaunchAAUI.20(this, paramBoolean, paramContext, paramString, i, str1, d, paramArrayList)).aRa();
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(13723, new Object[] { Integer.valueOf(1), i.Jd(this.chatroomName), Integer.valueOf(i), Double.valueOf(100.0D * d), str1 });
          AppMethodBeat.o(63682);
          return;
          i = 0;
          continue;
          if (this.iWO == null) {
            break label529;
          }
          i = this.iWO.size();
          d = bt.getDouble(this.iWJ.getText(), 0.0D);
          continue;
        }
        if (paramBoolean)
        {
          a(paramContext, paramString, i, str1, d, paramArrayList);
          continue;
        }
        a(paramContext, paramString, i, str1, d, this.iWO);
      }
      catch (Exception paramContext)
      {
        ad.e("MicroMsg.Aa.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[] { Integer.valueOf(this.mode), paramContext.getMessage() });
        AppMethodBeat.o(63682);
        return;
      }
      continue;
      aRG();
      if (this.iVd != null) {
        this.iVd.dismiss();
      }
      this.iVd = com.tencent.mm.wallet_core.ui.g.c(paramContext, false, null);
      if ((aRz()) && (!bt.isNullOrNil(this.imagePath)))
      {
        new com.tencent.mm.plugin.aa.model.d(this.imagePath, new LaunchAAUI.21(this, paramContext, paramString, paramBoolean, paramArrayList)).aRa();
        AppMethodBeat.o(63682);
        return;
      }
      a(paramContext, paramString, "", "", paramBoolean, paramArrayList);
      AppMethodBeat.o(63682);
      return;
      label529:
      int i = 0;
    }
  }
  
  private static boolean aJ(List<String> paramList)
  {
    AppMethodBeat.i(63694);
    if (paramList == null)
    {
      AppMethodBeat.o(63694);
      return false;
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (!bt.lQ((String)paramList.next(), u.aAm()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(63694);
      return bool;
    }
  }
  
  private void aRD()
  {
    AppMethodBeat.i(63671);
    aRK();
    aRI();
    aRH();
    AppMethodBeat.o(63671);
  }
  
  private void aRE()
  {
    AppMethodBeat.i(63674);
    String str1;
    String str2;
    SpannableStringBuilder localSpannableStringBuilder;
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iRW)
    {
      str1 = getString(2131760636);
      str2 = getString(2131760637);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aRn()
        {
          AppMethodBeat.i(198922);
          LaunchAAUI.q(LaunchAAUI.this);
          AppMethodBeat.o(198922);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.iWH.setText(localSpannableStringBuilder);
      AppMethodBeat.o(63674);
      return;
    }
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iRX)
    {
      str1 = getString(2131760647);
      str2 = getString(2131760648);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aRn()
        {
          AppMethodBeat.i(198923);
          LaunchAAUI.q(LaunchAAUI.this);
          AppMethodBeat.o(198923);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.iWH.setText(localSpannableStringBuilder);
    }
    AppMethodBeat.o(63674);
  }
  
  private void aRF()
  {
    AppMethodBeat.i(63675);
    this.iWJ.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(198924);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 3))
        {
          WalletFormView.a(LaunchAAUI.r(LaunchAAUI.this).getContentEt(), str, i + 3, j);
          double d = bt.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((LaunchAAUI.s(LaunchAAUI.this) == null) || (LaunchAAUI.s(LaunchAAUI.this).size() <= 0)) {
            break label283;
          }
          d = d * 100.0D / LaunchAAUI.s(LaunchAAUI.this).size();
          LaunchAAUI.p(LaunchAAUI.this);
          if (d <= com.tencent.mm.plugin.aa.model.e.aRe()) {
            break label283;
          }
          LaunchAAUI.a(LaunchAAUI.this, true);
          com.tencent.mm.plugin.report.service.g.yhR.f(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          LaunchAAUI.d(LaunchAAUI.this);
          LaunchAAUI.t(LaunchAAUI.this);
          LaunchAAUI.u(LaunchAAUI.this);
          LaunchAAUI.this.rf(3);
          AppMethodBeat.o(198924);
          return;
          if (i > 6)
          {
            WalletFormView.a(LaunchAAUI.r(LaunchAAUI.this).getContentEt(), str, 6, i);
            break;
          }
          if ((i != -1) || (j <= 6)) {
            break;
          }
          WalletFormView.a(LaunchAAUI.r(LaunchAAUI.this).getContentEt(), str, 6, j);
          break;
          label283:
          LaunchAAUI.a(LaunchAAUI.this, false);
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    setEditFocusListener(this.iWJ, 2, false, false);
    this.iWJ.setmContentAbnormalMoneyCheck(true);
    Object localObject;
    if (aRz())
    {
      localObject = new ArrayList();
      Iterator localIterator = this.iWT.keySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((String)localIterator.next());
      }
      this.iWL.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      this.iWO = ((List)localObject);
    }
    for (;;)
    {
      this.iWL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198925);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          LaunchAAUI.a(LaunchAAUI.this, this.fNV);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198925);
        }
      });
      this.iWJ.requestFocus();
      this.iWA = false;
      AppMethodBeat.o(63675);
      return;
      if (w.vF(this.chatroomName)) {
        if (!w.zm(this.chatroomName)) {
          localObject = i.Jd(this.chatroomName);
        }
      }
      for (;;)
      {
        this.iWO = ((List)localObject);
        if (this.iWO.size() <= com.tencent.mm.plugin.aa.model.e.aRd()) {
          break label306;
        }
        this.iWO.clear();
        this.iWL.setText(getString(2131761843));
        aRH();
        break;
        localObject = aRL();
        continue;
        ad.i("MicroMsg.Aa.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
        localObject = new ArrayList();
        ((List)localObject).add(u.aAm());
        ((List)localObject).add(this.chatroomName);
      }
      label306:
      if (w.vF(this.chatroomName))
      {
        if (!w.zm(this.chatroomName)) {
          this.iWL.setText(getString(2131760634, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        } else {
          this.iWL.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        }
      }
      else {
        this.iWL.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      }
    }
  }
  
  private void aRG()
  {
    AppMethodBeat.i(63677);
    this.iXb = false;
    if (this.iWW.getVisibility() != 8)
    {
      this.iWW.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.iWW.setVisibility(8);
    }
    AppMethodBeat.o(63677);
  }
  
  private void aRH()
  {
    AppMethodBeat.i(63678);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iRW)
    {
      if (bt.isNullOrNil(this.iWJ.getText()))
      {
        fm(false);
        AppMethodBeat.o(63678);
        return;
      }
      if (this.iWh)
      {
        fm(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iWO == null) || (this.iWO.size() == 0))
      {
        fm(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iWO.size() > com.tencent.mm.plugin.aa.model.e.aRd()) || (this.iWA))
      {
        fm(false);
        AppMethodBeat.o(63678);
        return;
      }
      double d = i.a(this.iWJ.getText(), this.iWO.size(), 5, 4);
      ad.d("MicroMsg.Aa.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.iWJ.getText(), Integer.valueOf(this.iWO.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        ad.i("MicroMsg.Aa.LaunchAAUI", "less than 0.01");
        fm(false);
        AppMethodBeat.o(63678);
      }
    }
    else
    {
      if ((this.iWT == null) || (this.iWT.size() == 0))
      {
        fm(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iWT.size() > com.tencent.mm.plugin.aa.model.e.aRd()) || (this.iWA))
      {
        fm(false);
        AppMethodBeat.o(63678);
        return;
      }
    }
    fm(true);
    AppMethodBeat.o(63678);
  }
  
  private void aRI()
  {
    AppMethodBeat.i(63680);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iRW)
    {
      if ((this.iWO != null) && (this.iWO.size() > 0))
      {
        d = i.a(this.iWJ.getText(), this.iWO.size(), 2, 2);
        this.iUX.setText(getString(2131755021, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.iWC.setText(2131760638);
        AppMethodBeat.o(63680);
        return;
        this.iUX.setText(getString(2131755023));
      }
    }
    if ((this.iWT == null) || (this.iWT.size() == 0))
    {
      this.iWC.setText(getString(2131760649, new Object[] { Integer.valueOf(0) }));
      this.iUX.setText(getString(2131755023));
      AppMethodBeat.o(63680);
      return;
    }
    Iterator localIterator = this.iWT.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.iUX.setText(getString(2131755021, new Object[] { Double.valueOf(d) }));
    this.iWC.setText(getString(2131760649, new Object[] { Integer.valueOf(this.iWT.size()) }));
    AppMethodBeat.o(63680);
  }
  
  private void aRJ()
  {
    AppMethodBeat.i(63688);
    if ((this.iWA) && (!this.iXb))
    {
      if (this.mode == com.tencent.mm.plugin.aa.model.a.iRW)
      {
        Jh(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aRd()) }));
        AppMethodBeat.o(63688);
        return;
      }
      Jh(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aRc()) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((this.iWh) && (!this.iXb))
    {
      Jh(getString(2131760660, new Object[] { Float.valueOf((float)com.tencent.mm.plugin.aa.model.e.aRe() / 100.0F) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((!this.iWA) && (!this.iWh)) {
      aRG();
    }
    AppMethodBeat.o(63688);
  }
  
  private void aRK()
  {
    AppMethodBeat.i(63689);
    int i;
    if ((this.iWT != null) && (this.iWT.size() > 0))
    {
      this.iWR.setText(getString(2131760651, new Object[] { Integer.valueOf(this.iWT.size()) }));
      this.iWR.setTextColor(getResources().getColor(2131100711));
      i = (int)getResources().getDimension(2131165611);
      int j = (int)getResources().getDimension(2131165608);
      int k = (int)getResources().getDimension(2131165609);
      this.iWS.setPadding(i, j, i, k);
      this.iWS.setBackgroundResource(2131232847);
      this.iWQ.setVisibility(0);
    }
    for (;;)
    {
      this.iWQ.removeAllViews();
      this.iWU.clear();
      if ((this.iWT == null) || (this.iWT.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.iWT.keySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        double d = ((Double)this.iWT.get(str)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (i >= this.iWT.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        localLaunchAAByPersonNameAmountRow.a(str, this.chatroomName, d);
        this.iWQ.addView(localLaunchAAByPersonNameAmountRow);
        this.iWU.put(str, localLaunchAAByPersonNameAmountRow);
        i += 1;
      }
      this.iWR.setText(2131760650);
      this.iWR.setTextColor(getResources().getColor(2131099840));
      i = (int)getResources().getDimension(2131165611);
      this.iWS.setPadding(i, i, i, i);
      this.iWS.setBackgroundResource(2131232849);
      this.iWQ.setVisibility(8);
    }
    if (this.iVL != null) {
      this.iVL.requestLayout();
    }
    this.iXa = 0;
    this.iWI.post(new Runnable()
    {
      public final void run() {}
    });
    AppMethodBeat.o(63689);
  }
  
  private List<String> aRL()
  {
    AppMethodBeat.i(198940);
    ArrayList localArrayList = new ArrayList();
    Object localObject = i.Jd(this.chatroomName);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!am.aSQ(str)) {
          localArrayList.add(str);
        }
      }
    }
    AppMethodBeat.o(198940);
    return localArrayList;
  }
  
  private boolean aRz()
  {
    return this.scene == 6;
  }
  
  private void bP(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(63673);
    this.iWX.setVisibility(0);
    this.iWX.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
    this.iWX.setText(paramString1);
    this.iWX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198921);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.wallet_core.ui.e.aW(LaunchAAUI.this.getContext(), paramString2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198921);
      }
    });
    AppMethodBeat.o(63673);
  }
  
  private void fm(boolean paramBoolean)
  {
    AppMethodBeat.i(63679);
    this.iWV.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.iWC.setTextColor(getResources().getColor(2131099841));
      this.iUX.setTextColor(getResources().getColor(2131099841));
      this.iWD.setTextColor(getResources().getColor(2131099841));
      AppMethodBeat.o(63679);
      return;
    }
    this.iWC.setTextColor(getResources().getColor(2131100711));
    this.iUX.setTextColor(getResources().getColor(2131100711));
    this.iWD.setTextColor(getResources().getColor(2131100711));
    AppMethodBeat.o(63679);
  }
  
  public static ax getKV()
  {
    AppMethodBeat.i(221329);
    ax localax = ax.aQz("aa_pay");
    AppMethodBeat.o(221329);
    return localax;
  }
  
  private void t(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63672);
    ad.i("MicroMsg.Aa.LaunchAAUI", "go to contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("Select_block_List", u.aAm());
    Object localObject;
    if (paramArrayList != null)
    {
      localObject = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((StringBuilder)localObject).append((String)paramArrayList.next()).append(",");
      }
      if (((StringBuilder)localObject).length() - 1 >= 0) {
        ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
      }
      ad.i("MicroMsg.Aa.LaunchAAUI", "gotoSelectContactUI %s", new Object[] { ((StringBuilder)localObject).toString() });
      localIntent.putExtra("recent_remittance_contact_list", ((StringBuilder)localObject).toString());
    }
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iRW)
    {
      paramArrayList = new StringBuilder();
      localObject = this.iWO.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.append((String)((Iterator)localObject).next()).append(",");
      }
      if (paramArrayList.length() - 1 >= 0) {
        paramArrayList.deleteCharAt(paramArrayList.length() - 1);
      }
      localIntent.putExtra("key_include_username_list", paramArrayList.toString());
    }
    for (;;)
    {
      if (aRz()) {
        localIntent.putExtra("key_title", this.iWB.getText().toString());
      }
      com.tencent.mm.bs.d.b(getContext(), "remittance", ".ui.SelectRemittanceContactUI", localIntent, 320);
      rf(10);
      AppMethodBeat.o(63672);
      return;
      paramArrayList = new StringBuilder();
      localObject = this.iWT.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.append((String)((Iterator)localObject).next()).append(",");
      }
      if (paramArrayList.length() - 1 >= 0) {
        paramArrayList.deleteCharAt(paramArrayList.length() - 1);
      }
      localIntent.putExtra("key_include_username_list", paramArrayList.toString());
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(63670);
    super.finish();
    try
    {
      hideVKB();
      AppMethodBeat.o(63670);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Aa.LaunchAAUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(63670);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494551;
  }
  
  public boolean needExecuteBackListener()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63690);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.Aa.LaunchAAUI", "onActivityResult requestCode:%s", new Object[] { Integer.valueOf(paramInt1) });
    label222:
    double d;
    if (paramInt1 == 233)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (this.mode == com.tencent.mm.plugin.aa.model.a.iRW)
        {
          if (!bt.isNullOrNil(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.iWO.clear();
            this.iWO.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = i.Jd(this.chatroomName);
          if ((paramIntent == null) || (this.iWO == null) || (this.iWO.size() != paramIntent.size()) || (!w.vF(this.chatroomName))) {
            break label316;
          }
          paramIntent = this.iWL;
          if (this.iWO != null)
          {
            paramInt1 = this.iWO.size();
            paramIntent.setText(getString(2131760634, new Object[] { Integer.valueOf(paramInt1) }));
          }
        }
        else
        {
          aRG();
          if ((this.iWO == null) || (this.iWO.size() <= com.tencent.mm.plugin.aa.model.e.aRd())) {
            break label368;
          }
          this.iWA = true;
          d = bt.getDouble(this.iWJ.getText(), 0.0D);
          if ((this.iWO == null) || (d * 100.0D / this.iWO.size() <= com.tencent.mm.plugin.aa.model.e.aRe())) {
            break label376;
          }
          this.iWh = true;
          com.tencent.mm.plugin.report.service.g.yhR.f(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          aRH();
          aRI();
          aRJ();
          AppMethodBeat.o(63690);
          return;
          paramInt1 = 0;
          break;
          label316:
          paramIntent = this.iWL;
          if (this.iWO != null) {}
          for (paramInt1 = this.iWO.size();; paramInt1 = 0)
          {
            paramIntent.setText(getString(2131760639, new Object[] { Integer.valueOf(paramInt1) }));
            break;
          }
          label368:
          this.iWA = false;
          break label222;
          label376:
          this.iWh = false;
        }
      }
    }
    else
    {
      Object localObject;
      if (paramInt1 == 236)
      {
        if (paramInt2 == -1)
        {
          try
          {
            paramIntent = paramIntent.getStringArrayListExtra("selectUI");
            this.iWT.clear();
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext())
              {
                localObject = ((String)paramIntent.next()).split(",");
                d = bt.getDouble(localObject[1], 0.0D);
                this.iWT.put(localObject[0], Double.valueOf(d));
              }
            }
            aRD();
          }
          catch (Exception paramIntent)
          {
            ad.e("MicroMsg.Aa.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[] { paramIntent.getMessage() });
            AppMethodBeat.o(63690);
            return;
          }
          AppMethodBeat.o(63690);
        }
      }
      else if (paramInt1 == 300)
      {
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject = paramIntent.getStringArrayListExtra("key_select_image_list");
          if ((localObject == null) || (((ArrayList)localObject).size() == 0))
          {
            paramIntent = com.tencent.mm.ui.tools.a.j(this, paramIntent, com.tencent.mm.plugin.image.d.azA());
            if (bt.isNullOrNil(paramIntent)) {}
          }
          for (this.imagePath = paramIntent;; this.imagePath = ((String)((ArrayList)localObject).get(0)))
          {
            if (!bt.isNullOrNil(this.imagePath))
            {
              this.iUK = 2;
              this.iWG.setVisibility(0);
              this.iWF.setVisibility(8);
              paramIntent = MMBitmapFactory.decodeFile(this.imagePath);
              this.iWG.setImageBitmap(paramIntent);
              rf(8);
            }
            ad.i("MicroMsg.Aa.LaunchAAUI", "SELECT_IMAGE_REQUEST_CODE imagePath:%s", new Object[] { this.imagePath });
            AppMethodBeat.o(63690);
            return;
          }
        }
      }
      else if ((paramInt1 == 310) && (paramInt2 == -1))
      {
        this.iUK = 2;
        this.imagePath = "";
        this.iWG.setVisibility(8);
        this.iWF.setVisibility(0);
        rf(7);
      }
    }
    AppMethodBeat.o(63690);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(63669);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.Aa.LaunchAAUI", "LaunchAAUI onCreate");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63642);
        LaunchAAUI.this.finish();
        AppMethodBeat.o(63642);
        return false;
      }
    });
    this.timestamp = (System.currentTimeMillis() / 1000L);
    setMMTitle(2131760665);
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    label244:
    int i;
    if (aRz())
    {
      this.iXf = ((NetSceneNewAAQueryPFInfo.PfInfoParcel)getIntent().getParcelableExtra("pfInfo"));
      this.iVO = getIntent().getStringExtra("pfOrderNo");
      if (this.iXf == null)
      {
        ad.e("MicroMsg.Aa.LaunchAAUI", "pfInfoParcel is null!!!");
        finish();
        AppMethodBeat.o(63669);
        return;
      }
      this.mode = com.tencent.mm.plugin.aa.model.a.iRX;
      this.iXd = this.iXf.dOa;
      this.iXe = this.iXf.iTM;
      rf(1);
      if (!aRz()) {
        break label1578;
      }
      this.iWY = new com.tencent.mm.plugin.aa.model.e(this.iXf.iTP.iTI, this.iXf.iTP.iTH);
      if ((!bt.isNullOrNil(this.iWY.iSJ)) && (!bt.isNullOrNil(this.iWY.iSI))) {
        bP(this.iWY.iSJ, this.iWY.iSI);
      }
      this.chatroomName = getIntent().getStringExtra("chatroom_name");
      if (bt.isNullOrNil(this.chatroomName))
      {
        ad.e("MicroMsg.Aa.LaunchAAUI", "chatroomName is null!!!");
        this.chatroomName = "";
      }
      paramBundle = this.chatroomName;
      if (bt.isNullOrNil(paramBundle)) {
        break label1673;
      }
      if (!w.vF(paramBundle)) {
        break label1625;
      }
      label301:
      this.chatroomName = paramBundle;
      this.iVL = findViewById(2131304241);
      this.iWH = ((TextView)findViewById(2131301326));
      this.iWV = ((Button)findViewById(2131301318));
      this.iWW = ((TextView)findViewById(2131301315));
      this.iWX = ((TextView)findViewById(2131301331));
      this.iWB = ((MMEditText)findViewById(2131301327));
      this.iWC = ((TextView)findViewById(2131301330));
      this.iUX = ((TextView)findViewById(2131301316));
      this.iWD = ((TextView)findViewById(2131301317));
      this.iWE = ((RelativeLayout)findViewById(2131303242));
      this.iWF = ((ImageView)findViewById(2131303325));
      this.iWG = ((ImageView)findViewById(2131298760));
      this.iWI = ((TextView)findViewById(2131296289));
      this.iWJ = ((WalletFormView)findViewById(2131301329));
      this.iWL = ((TextView)findViewById(2131301319));
      this.iWK = ((TextView)findViewById(2131301320));
      this.iWM = ((ViewGroup)findViewById(2131301334));
      this.iWN = ((ViewGroup)findViewById(2131301333));
      this.iWR = ((TextView)findViewById(2131301324));
      this.iWR.setText(2131760650);
      this.iWR.setTextColor(getResources().getColor(2131099840));
      this.iWP = ((ViewGroup)findViewById(2131301335));
      this.iWQ = ((ViewGroup)findViewById(2131301336));
      this.iWS = ((ViewGroup)findViewById(2131301323));
      this.iVL.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(63659);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          if (LaunchAAUI.a(LaunchAAUI.this).findFocus() != null) {
            LaunchAAUI.a(LaunchAAUI.this).setCursorVisible(false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(63659);
          return false;
        }
      });
      this.iWH.setClickable(true);
      this.iWH.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      if (this.mode != com.tencent.mm.plugin.aa.model.a.iRW) {
        break label1679;
      }
      this.iWM.setVisibility(0);
      this.iWN.setVisibility(0);
      this.iWP.setVisibility(8);
      this.iWC.setText(2131760638);
      this.iWA = false;
      if (this.iWO.size() > com.tencent.mm.plugin.aa.model.e.aRd()) {
        this.iWA = true;
      }
      aRJ();
      label750:
      aRE();
      Object localObject;
      if (aRz()) {
        try
        {
          paramBundle = this.iXf.iTK;
          this.iWT.clear();
          if ((paramBundle == null) || (paramBundle.size() <= 0)) {
            break label1808;
          }
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            localObject = (NetSceneNewAAQueryPFInfo.AALaunchItemParcel)paramBundle.next();
            this.iWT.put(((NetSceneNewAAQueryPFInfo.AALaunchItemParcel)localObject).username, Double.valueOf(((NetSceneNewAAQueryPFInfo.AALaunchItemParcel)localObject).dOa / 100.0D));
          }
          this.iWV.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(63662);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              LaunchAAUI.b(LaunchAAUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(63662);
            }
          });
        }
        catch (Exception paramBundle)
        {
          ad.e("MicroMsg.Aa.LaunchAAUI", "initPersonLaunchView error:%s %s", new Object[] { paramBundle.getClass().getSimpleName(), paramBundle.getMessage() });
        }
      }
      label872:
      this.iWI.setClickable(true);
      this.iWI.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
      paramBundle = new SpannableString(getString(2131757336));
      paramBundle.setSpan(new a(new a.a()
      {
        public final void aRn()
        {
          AppMethodBeat.i(63663);
          Object localObject = new Intent(LaunchAAUI.this, AAQueryListUI.class);
          LaunchAAUI localLaunchAAUI = LaunchAAUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLaunchAAUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (LaunchAAUI.c(LaunchAAUI.this) == com.tencent.mm.plugin.aa.model.a.iRW)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            AppMethodBeat.o(63663);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
          AppMethodBeat.o(63663);
        }
      }), 0, paramBundle.length(), 18);
      this.iWI.setText(paramBundle);
      this.iWI.setVisibility(8);
      this.iWB.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63664);
          LaunchAAUI.d(LaunchAAUI.this);
          LaunchAAUI.this.rf(6);
          AppMethodBeat.o(63664);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.iWB.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(63665);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          LaunchAAUI.a(LaunchAAUI.this).setCursorVisible(true);
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(63665);
          return false;
        }
      });
      aRF();
      this.iWS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63666);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          LaunchAAUI.e(LaunchAAUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63666);
        }
      });
      if (!bt.isNullOrNil(this.iXe))
      {
        ad.i("MicroMsg.Aa.LaunchAAUI", "default title: %s", new Object[] { this.iXe });
        this.iWB.setText(this.iXe);
        if (this.iXe.length() <= 20) {
          break label1815;
        }
        i = 20;
        label1071:
        this.iWB.setSelection(i);
      }
      if (!aRz()) {
        break label1826;
      }
      paramBundle = String.format("%.2f", new Object[] { Double.valueOf(this.iXd / 100.0D) });
      this.iWJ.setText(paramBundle);
      this.iWJ.setSelection(paramBundle.length());
      label1131:
      aRH();
      if ((aRz()) && (ax.aQz("aa_pay").getBoolean("new_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        localObject = getLayoutInflater().inflate(2131492884, null);
        ((View)localObject).findViewById(2131300870).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(63631);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            LaunchAAUI.getKV().edit().putBoolean("new_user_guide_show", false);
            paramBundle.bpT();
            LaunchAAUI.this.rf(2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63631);
          }
        });
        paramBundle.KJy = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(63632);
            paramAnonymousl.clear();
            paramBundle.setFooterView(null);
            paramBundle.setFooterView(this.iXl);
            AppMethodBeat.o(63632);
          }
        };
        paramBundle.fMc();
        paramBundle.cMW();
      }
      if ((w.zm(this.chatroomName)) && (ax.aQz("aa_pay").getBoolean("new_open_IM_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        localObject = getLayoutInflater().inflate(2131492884, null);
        ((TextView)((View)localObject).findViewById(2131307261)).setText(getString(2131766551));
        ((TextView)((View)localObject).findViewById(2131307260)).setText(getString(2131766550));
        ((View)localObject).findViewById(2131300870).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(63633);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            LaunchAAUI.getKV().edit().putBoolean("new_open_IM_user_guide_show", false);
            paramBundle.bpT();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63633);
          }
        });
        paramBundle.KJy = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(198912);
            paramAnonymousl.clear();
            paramBundle.setFooterView(null);
            paramBundle.setFooterView(this.iXl);
            AppMethodBeat.o(198912);
          }
        };
        paramBundle.fMc();
        paramBundle.cMW();
      }
      if (aRz())
      {
        this.iWE.setVisibility(0);
        this.iWE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198913);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.pluginsdk.ui.tools.q.aT(LaunchAAUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198913);
          }
        });
        this.iWG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198916);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (LaunchAAUI.i(LaunchAAUI.this) == null) {
              LaunchAAUI.a(LaunchAAUI.this, h.a(LaunchAAUI.this, 3, 2131820985, LaunchAAUI.this.getString(2131760709), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(198914);
                  if ((LaunchAAUI.i(LaunchAAUI.this) != null) && (LaunchAAUI.i(LaunchAAUI.this).isShowing())) {
                    LaunchAAUI.i(LaunchAAUI.this).dismiss();
                  }
                  AppMethodBeat.o(198914);
                }
              }));
            }
            com.tencent.mm.aw.q.aII().a(LaunchAAUI.j(LaunchAAUI.this), new r.a()
            {
              public final void a(String paramAnonymous2String1, Bitmap paramAnonymous2Bitmap, String paramAnonymous2String2)
              {
                AppMethodBeat.i(198915);
                ad.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous2String1, paramAnonymous2String2 });
                if ((LaunchAAUI.i(LaunchAAUI.this) != null) && (LaunchAAUI.i(LaunchAAUI.this).isShowing())) {
                  LaunchAAUI.i(LaunchAAUI.this).dismiss();
                }
                if (paramAnonymous2Bitmap != null)
                {
                  paramAnonymous2String1 = new Intent();
                  paramAnonymous2String1.putExtra("use_scene", 1);
                  paramAnonymous2String1.putExtra("scene", LaunchAAUI.k(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("path", LaunchAAUI.l(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("url", LaunchAAUI.j(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("view_info", ViewAnimHelper.o(LaunchAAUI.m(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
                  com.tencent.mm.bs.d.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous2String1, 310);
                  LaunchAAUI.this.rf(14);
                  AppMethodBeat.o(198915);
                  return;
                }
                Toast.makeText(LaunchAAUI.this, 2131755038, 1).show();
                AppMethodBeat.o(198915);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198916);
          }
        });
        if ((this.iXf == null) || (bt.isNullOrNil(this.iXf.iTL))) {
          break label1918;
        }
        this.iUK = 1;
        this.hym = this.iXf.iTL;
        this.iWG.setVisibility(0);
        this.iWF.setVisibility(8);
        com.tencent.mm.aw.q.aII().a(this.iXf.iTL, this.iXf.iTO, new r.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            boolean bool = false;
            AppMethodBeat.i(198918);
            if (paramAnonymousBitmap == null) {
              bool = true;
            }
            ad.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s bitmap==null:%s path:%s", new Object[] { paramAnonymousString1, Boolean.valueOf(bool), paramAnonymousString2 });
            LaunchAAUI.a(LaunchAAUI.this, paramAnonymousString2);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(198917);
                if (paramAnonymousBitmap != null)
                {
                  LaunchAAUI.m(LaunchAAUI.this).setImageBitmap(paramAnonymousBitmap);
                  AppMethodBeat.o(198917);
                  return;
                }
                LaunchAAUI.n(LaunchAAUI.this);
                LaunchAAUI.m(LaunchAAUI.this).setVisibility(8);
                LaunchAAUI.o(LaunchAAUI.this).setVisibility(0);
                AppMethodBeat.o(198917);
              }
            });
            AppMethodBeat.o(198918);
          }
        });
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      if ((aRz()) && (this.iXh != null)) {
        this.iXh.alive();
      }
      AppMethodBeat.o(63669);
      return;
      this.mode = com.tencent.mm.plugin.aa.model.a.iRW;
      this.iXc = getIntent().getStringExtra("amount");
      this.iXe = getIntent().getStringExtra("title");
      break;
      label1578:
      paramBundle = this.iWz.iUn;
      com.tencent.mm.vending.g.g.fOf().c(paramBundle).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
      {
        public final void ce(Object paramAnonymousObject)
        {
          AppMethodBeat.i(198919);
          ad.i("MicroMsg.Aa.LaunchAAUI", "fetch operation data failed");
          AppMethodBeat.o(198919);
        }
      });
      break label244;
      label1625:
      paramBundle = bt.U(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(u.aAm());
        if (paramBundle.size() > 0)
        {
          paramBundle = (String)paramBundle.get(0);
          break label301;
        }
      }
      label1673:
      paramBundle = "";
      break label301;
      label1679:
      if (this.mode != com.tencent.mm.plugin.aa.model.a.iRX) {
        break label750;
      }
      this.iWM.setVisibility(8);
      this.iWN.setVisibility(8);
      this.iWP.setVisibility(0);
      this.iWC.setText(getString(2131760649, new Object[] { Integer.valueOf(0) }));
      if ((this.iWT != null) && (this.iWT.size() > com.tencent.mm.plugin.aa.model.e.aRc())) {
        this.iWA = true;
      }
      if (this.iWA)
      {
        Jh(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aRc()) }));
        break label750;
      }
      aRG();
      break label750;
      label1808:
      aRD();
      break label872;
      label1815:
      i = this.iXe.length();
      break label1071;
      label1826:
      if (bt.isNullOrNil(this.iXc)) {
        break label1131;
      }
      ad.i("MicroMsg.Aa.LaunchAAUI", "default amount: %s", new Object[] { this.iXc });
      paramBundle = com.tencent.mm.wallet_core.ui.e.a(new StringBuilder().append(this.iXc).toString(), "100", 2, RoundingMode.HALF_UP);
      this.iWJ.setText(paramBundle);
      this.iWJ.setSelection(paramBundle.length());
      break label1131;
      label1918:
      this.iUK = 2;
      this.imagePath = "";
      this.iWG.setVisibility(8);
      this.iWF.setVisibility(0);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63687);
    super.onDestroy();
    if ((aRz()) && (this.iXh != null)) {
      this.iXh.dead();
    }
    AppMethodBeat.o(63687);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(63686);
    super.onStop();
    if (this.iWU != null) {
      this.iWU.clear();
    }
    AppMethodBeat.o(63686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(63691);
    if (aRz()) {
      i.rf(paramInt);
    }
    AppMethodBeat.o(63691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */