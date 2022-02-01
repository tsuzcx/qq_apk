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
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.aa.model.b.e.b;
import com.tencent.mm.plugin.aa.model.b.e.c;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AALaunchItemParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AAOperationInfoParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.PfInfoParcel;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMEditText;
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
  private String gFC;
  private TextView ibG;
  private Dialog ibM;
  private int ibx;
  private Dialog iby;
  private boolean icP;
  private String icv;
  private Map<String, Double> idA;
  private Map<String, LaunchAAByPersonNameAmountRow> idB;
  private Button idC;
  private TextView idD;
  private TextView idE;
  private com.tencent.mm.plugin.aa.model.e idF;
  private int idG;
  private int idH;
  private boolean idI;
  private String idJ;
  private long idK;
  private String idL;
  private NetSceneNewAAQueryPFInfo.PfInfoParcel idM;
  private boolean idN;
  private com.tencent.mm.sdk.b.c<ki> idO;
  private com.tencent.mm.plugin.aa.model.b.e idf;
  private boolean idg;
  private MMEditText idh;
  private TextView idi;
  private TextView idj;
  private RelativeLayout idk;
  private ImageView idl;
  private ImageView idm;
  private TextView idn;
  private TextView ido;
  private WalletFormView idp;
  private TextView idq;
  private TextView idr;
  private ViewGroup ids;
  private ViewGroup idt;
  private List<String> idu;
  private ViewGroup idv;
  private ViewGroup idw;
  private TextView idy;
  private ViewGroup idz;
  private String imagePath;
  private int mode;
  private int scene;
  private long timestamp;
  private Dialog tipDialog;
  
  public LaunchAAUI()
  {
    AppMethodBeat.i(63668);
    this.idf = ((com.tencent.mm.plugin.aa.model.b.e)am(com.tencent.mm.plugin.aa.model.b.e.class));
    this.mode = com.tencent.mm.plugin.aa.model.a.hYJ;
    this.chatroomName = null;
    this.idg = false;
    this.icP = false;
    this.idu = new ArrayList();
    this.idA = new HashMap();
    this.idB = new HashMap();
    this.idF = new com.tencent.mm.plugin.aa.model.e();
    this.idG = 0;
    this.idH = 0;
    this.idI = false;
    this.timestamp = 0L;
    this.gFC = "";
    this.idM = null;
    this.idN = false;
    this.iby = null;
    this.idO = new LaunchAAUI.1(this);
    AppMethodBeat.o(63668);
  }
  
  private void BP(String paramString)
  {
    AppMethodBeat.i(63676);
    this.idI = true;
    this.idD.setVisibility(0);
    this.idD.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
    this.idD.setText(paramString);
    AppMethodBeat.o(63676);
  }
  
  private void BQ(final String paramString)
  {
    AppMethodBeat.i(63681);
    ad.i("MicroMsg.Aa.LaunchAAUI", "showLaunchComfirmDialog() from scene:%s", new Object[] { Integer.valueOf(this.scene) });
    String str = this.idh.getText().toString();
    if (bt.isNullOrNil(str)) {
      str = getString(2131760652);
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.i.class)).a(getController(), paramString, getString(2131755032) + str, getString(2131755031), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(63647);
          if (paramAnonymousBoolean)
          {
            LaunchAAUI.b(LaunchAAUI.this, paramString);
            LaunchAAUI.this.pS(12);
            AppMethodBeat.o(63647);
            return;
          }
          LaunchAAUI.this.pS(13);
          AppMethodBeat.o(63647);
        }
      });
      pS(11);
      AppMethodBeat.o(63681);
      return;
    }
  }
  
  public static boolean BR(String paramString)
  {
    AppMethodBeat.i(63693);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63693);
      return false;
    }
    boolean bool = aK(com.tencent.mm.plugin.aa.model.i.BL(paramString));
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
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZI, paramString2);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZJ, Double.valueOf(100.0D * paramDouble));
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZM, paramString1);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZP, Long.valueOf(this.timestamp));
    long l = com.tencent.mm.wallet_core.ui.e.a(com.tencent.mm.plugin.aa.model.i.bE(new StringBuilder().append(paramDouble).toString(), "100"), String.valueOf(paramInt), RoundingMode.CEILING);
    ad.d("MicroMsg.Aa.LaunchAAUI", "perAmount: %s", new Object[] { Long.valueOf(l) });
    if ((l <= 0L) || (l > com.tencent.mm.plugin.aa.model.e.aHe()))
    {
      ad.i("MicroMsg.Aa.LaunchAAUI", "illegal avgAmount: %s", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(63684);
      return;
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZL, Long.valueOf(l));
    if (aHy())
    {
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZQ, paramString3);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZR, paramString4);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZS, this.icv);
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZO, paramList);
    this.idf.iaY.c(this.mode, localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void ce(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(63656);
        ad.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        if (LaunchAAUI.v(LaunchAAUI.this) != null) {
          LaunchAAUI.v(LaunchAAUI.this).dismiss();
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
          com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131760658), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(182444);
              ad.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
              AppMethodBeat.o(182444);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(13722, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(63656);
          return;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof z)))
          {
            com.tencent.mm.plugin.aa.model.i.a(LaunchAAUI.this.getContext(), (z)paramAnonymousObject);
          }
          else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
          {
            paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
            String str1 = paramAnonymousObject.doh;
            String str2 = paramAnonymousObject.tfH;
            String str3 = paramAnonymousObject.tfI;
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
            locala.aMg(str1);
            locala.aMm(str3).b(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182445);
                com.tencent.mm.wallet_core.ui.e.p(LaunchAAUI.this.getContext(), paramAnonymousObject.nTQ, false);
                AppMethodBeat.o(182445);
              }
            });
            locala.aMn(str2);
            locala.fft().show();
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
    ((b)com.tencent.mm.kernel.g.ab(b.class)).gf(7, 5);
    com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.idh.getText().toString();
        if (bt.isNullOrNil(str1))
        {
          str1 = getString(2131760652);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator = this.idA.keySet().iterator();
          long l1 = 0L;
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if ((!paramBoolean) || (paramList.contains(str2)))
            {
              double d = ((Double)this.idA.get(str2)).doubleValue();
              com.tencent.mm.protocal.protobuf.j localj = new com.tencent.mm.protocal.protobuf.j();
              localj.dEb = com.tencent.mm.wallet_core.ui.e.lN(String.valueOf(d), "100");
              localj.username = str2;
              localArrayList1.add(localj);
              long l2 = localj.dEb;
              localArrayList2.add(localj.dEb);
              l1 = l2 + l1;
            }
          }
          else
          {
            paramList = new com.tencent.mm.protocal.protobuf.j();
            paramList.username = u.aqG();
            paramList.dEb = l1;
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZI, str1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZJ, Long.valueOf(l1));
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZO, localArrayList1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZM, paramString1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZP, Long.valueOf(this.timestamp));
            if (aHy())
            {
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZQ, paramString2);
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZR, paramString3);
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.hZS, this.icv);
            }
            this.idf.iaZ.y(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
            {
              public final void ce(final Object paramAnonymousObject)
              {
                AppMethodBeat.i(63658);
                ad.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
                if (LaunchAAUI.v(LaunchAAUI.this) != null) {
                  LaunchAAUI.v(LaunchAAUI.this).dismiss();
                }
                if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
                  com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131760658), false, new DialogInterface.OnClickListener()
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
                  com.tencent.mm.plugin.report.service.h.vKh.f(13722, new Object[] { Integer.valueOf(10) });
                  AppMethodBeat.o(63658);
                  return;
                  if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof z)))
                  {
                    com.tencent.mm.plugin.aa.model.i.a(LaunchAAUI.this.getContext(), (z)paramAnonymousObject);
                  }
                  else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
                  {
                    paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
                    String str1 = paramAnonymousObject.doh;
                    String str2 = paramAnonymousObject.tfH;
                    String str3 = paramAnonymousObject.tfI;
                    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
                    locala.aMg(str1);
                    locala.aMm(str3).b(new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(182447);
                        com.tencent.mm.wallet_core.ui.e.p(LaunchAAUI.this.getContext(), paramAnonymousObject.nTQ, false);
                        AppMethodBeat.o(182447);
                      }
                    });
                    locala.aMn(str2);
                    locala.fft().show();
                  }
                  else
                  {
                    Toast.makeText(paramContext, 2131760656, 1).show();
                  }
                }
              }
            });
            com.tencent.mm.plugin.report.service.h.vKh.f(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.aa.model.i.BL(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, bt.n(localArrayList2, ",") });
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
    pS(9);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.hYJ)
    {
      if (bt.isNullOrNil(this.idp.getText()))
      {
        AppMethodBeat.o(63682);
        return;
      }
      if ((this.idu == null) || (this.idu.size() == 0))
      {
        AppMethodBeat.o(63682);
        return;
      }
      aHE();
      com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
      if ((paramBoolean) && (paramArrayList == null)) {}
    }
    for (;;)
    {
      try
      {
        i = paramArrayList.size();
        double d = bt.getDouble(this.ibG.getText().toString(), 0.0D) * i;
        String str2 = this.idh.getText().toString();
        String str1 = str2;
        if (bt.isNullOrNil(str2)) {
          str1 = getString(2131760652);
        }
        if (i > 0)
        {
          if (this.ibM != null) {
            this.ibM.dismiss();
          }
          this.ibM = com.tencent.mm.wallet_core.ui.g.c(paramContext, false, null);
          if ((aHy()) && (!bt.isNullOrNil(this.imagePath))) {
            new com.tencent.mm.plugin.aa.model.d(this.imagePath, new LaunchAAUI.18(this, paramBoolean, paramContext, paramString, i, str1, d, paramArrayList)).aHa();
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(13723, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.aa.model.i.BL(this.chatroomName), Integer.valueOf(i), Double.valueOf(100.0D * d), str1 });
          AppMethodBeat.o(63682);
          return;
          i = 0;
          continue;
          if (this.idu == null) {
            break label529;
          }
          i = this.idu.size();
          d = bt.getDouble(this.idp.getText(), 0.0D);
          continue;
        }
        if (paramBoolean)
        {
          a(paramContext, paramString, i, str1, d, paramArrayList);
          continue;
        }
        a(paramContext, paramString, i, str1, d, this.idu);
      }
      catch (Exception paramContext)
      {
        ad.e("MicroMsg.Aa.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[] { Integer.valueOf(this.mode), paramContext.getMessage() });
        AppMethodBeat.o(63682);
        return;
      }
      continue;
      aHE();
      if (this.ibM != null) {
        this.ibM.dismiss();
      }
      this.ibM = com.tencent.mm.wallet_core.ui.g.c(paramContext, false, null);
      if ((aHy()) && (!bt.isNullOrNil(this.imagePath)))
      {
        new com.tencent.mm.plugin.aa.model.d(this.imagePath, new LaunchAAUI.19(this, paramContext, paramString, paramBoolean, paramArrayList)).aHa();
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
  
  private void aHB()
  {
    AppMethodBeat.i(63671);
    aHI();
    aHG();
    aHF();
    AppMethodBeat.o(63671);
  }
  
  private void aHC()
  {
    AppMethodBeat.i(63674);
    String str1;
    String str2;
    SpannableStringBuilder localSpannableStringBuilder;
    if (this.mode == com.tencent.mm.plugin.aa.model.a.hYJ)
    {
      str1 = getString(2131760636);
      str2 = getString(2131760637);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aHn()
        {
          AppMethodBeat.i(63643);
          LaunchAAUI.q(LaunchAAUI.this);
          AppMethodBeat.o(63643);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.idn.setText(localSpannableStringBuilder);
      AppMethodBeat.o(63674);
      return;
    }
    if (this.mode == com.tencent.mm.plugin.aa.model.a.hYK)
    {
      str1 = getString(2131760647);
      str2 = getString(2131760648);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aHn()
        {
          AppMethodBeat.i(63644);
          LaunchAAUI.q(LaunchAAUI.this);
          AppMethodBeat.o(63644);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.idn.setText(localSpannableStringBuilder);
    }
    AppMethodBeat.o(63674);
  }
  
  private void aHD()
  {
    AppMethodBeat.i(63675);
    this.idp.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(63645);
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
          if (d <= com.tencent.mm.plugin.aa.model.e.aHe()) {
            break label283;
          }
          LaunchAAUI.a(LaunchAAUI.this, true);
          com.tencent.mm.plugin.report.service.h.vKh.f(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          LaunchAAUI.d(LaunchAAUI.this);
          LaunchAAUI.t(LaunchAAUI.this);
          LaunchAAUI.u(LaunchAAUI.this);
          LaunchAAUI.this.pS(3);
          AppMethodBeat.o(63645);
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
    setEditFocusListener(this.idp, 2, false, false);
    this.idp.setmContentAbnormalMoneyCheck(true);
    Object localObject;
    if (aHy())
    {
      localObject = new ArrayList();
      Iterator localIterator = this.idA.keySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((String)localIterator.next());
      }
      this.idr.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      this.idu = ((List)localObject);
    }
    for (;;)
    {
      this.idr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63646);
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          LaunchAAUI.a(LaunchAAUI.this, this.frk);
          AppMethodBeat.o(63646);
        }
      });
      this.idp.requestFocus();
      this.idg = false;
      AppMethodBeat.o(63675);
      return;
      if (w.pF(this.chatroomName)) {
        localObject = com.tencent.mm.plugin.aa.model.i.BL(this.chatroomName);
      }
      for (;;)
      {
        this.idu = ((List)localObject);
        if (this.idu.size() <= com.tencent.mm.plugin.aa.model.e.aHd()) {
          break label288;
        }
        this.idu.clear();
        this.idr.setText(getString(2131761843));
        aHF();
        break;
        ad.i("MicroMsg.Aa.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
        localObject = new ArrayList();
        ((List)localObject).add(u.aqG());
        ((List)localObject).add(this.chatroomName);
      }
      label288:
      if (w.pF(this.chatroomName)) {
        this.idr.setText(getString(2131760634, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      } else {
        this.idr.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      }
    }
  }
  
  private void aHE()
  {
    AppMethodBeat.i(63677);
    this.idI = false;
    if (this.idD.getVisibility() != 8)
    {
      this.idD.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.idD.setVisibility(8);
    }
    AppMethodBeat.o(63677);
  }
  
  private void aHF()
  {
    AppMethodBeat.i(63678);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.hYJ)
    {
      if (bt.isNullOrNil(this.idp.getText()))
      {
        eO(false);
        AppMethodBeat.o(63678);
        return;
      }
      if (this.icP)
      {
        eO(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.idu == null) || (this.idu.size() == 0))
      {
        eO(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.idu.size() > com.tencent.mm.plugin.aa.model.e.aHd()) || (this.idg))
      {
        eO(false);
        AppMethodBeat.o(63678);
        return;
      }
      double d = com.tencent.mm.plugin.aa.model.i.a(this.idp.getText(), this.idu.size(), 5, 4);
      ad.d("MicroMsg.Aa.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.idp.getText(), Integer.valueOf(this.idu.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        ad.i("MicroMsg.Aa.LaunchAAUI", "less than 0.01");
        eO(false);
        AppMethodBeat.o(63678);
      }
    }
    else
    {
      if ((this.idA == null) || (this.idA.size() == 0))
      {
        eO(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.idA.size() > com.tencent.mm.plugin.aa.model.e.aHd()) || (this.idg))
      {
        eO(false);
        AppMethodBeat.o(63678);
        return;
      }
    }
    eO(true);
    AppMethodBeat.o(63678);
  }
  
  private void aHG()
  {
    AppMethodBeat.i(63680);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.hYJ)
    {
      if ((this.idu != null) && (this.idu.size() > 0))
      {
        d = com.tencent.mm.plugin.aa.model.i.a(this.idp.getText(), this.idu.size(), 2, 2);
        this.ibG.setText(getString(2131755021, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.idi.setText(2131760638);
        AppMethodBeat.o(63680);
        return;
        this.ibG.setText(getString(2131755023));
      }
    }
    if ((this.idA == null) || (this.idA.size() == 0))
    {
      this.idi.setText(getString(2131760649, new Object[] { Integer.valueOf(0) }));
      this.ibG.setText(getString(2131755023));
      AppMethodBeat.o(63680);
      return;
    }
    Iterator localIterator = this.idA.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.ibG.setText(getString(2131755021, new Object[] { Double.valueOf(d) }));
    this.idi.setText(getString(2131760649, new Object[] { Integer.valueOf(this.idA.size()) }));
    AppMethodBeat.o(63680);
  }
  
  private void aHH()
  {
    AppMethodBeat.i(63688);
    if ((this.idg) && (!this.idI))
    {
      if (this.mode == com.tencent.mm.plugin.aa.model.a.hYJ)
      {
        BP(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aHd()) }));
        AppMethodBeat.o(63688);
        return;
      }
      BP(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aHc()) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((this.icP) && (!this.idI))
    {
      BP(getString(2131760660, new Object[] { Float.valueOf((float)com.tencent.mm.plugin.aa.model.e.aHe() / 100.0F) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((!this.idg) && (!this.icP)) {
      aHE();
    }
    AppMethodBeat.o(63688);
  }
  
  private void aHI()
  {
    AppMethodBeat.i(63689);
    int i;
    if ((this.idA != null) && (this.idA.size() > 0))
    {
      this.idy.setText(getString(2131760651, new Object[] { Integer.valueOf(this.idA.size()) }));
      this.idy.setTextColor(getResources().getColor(2131100711));
      i = (int)getResources().getDimension(2131165611);
      int j = (int)getResources().getDimension(2131165608);
      int k = (int)getResources().getDimension(2131165609);
      this.idz.setPadding(i, j, i, k);
      this.idz.setBackgroundResource(2131232847);
      this.idw.setVisibility(0);
    }
    for (;;)
    {
      this.idw.removeAllViews();
      this.idB.clear();
      if ((this.idA == null) || (this.idA.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.idA.keySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        double d = ((Double)this.idA.get(str)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (i >= this.idA.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        localLaunchAAByPersonNameAmountRow.a(str, this.chatroomName, d);
        this.idw.addView(localLaunchAAByPersonNameAmountRow);
        this.idB.put(str, localLaunchAAByPersonNameAmountRow);
        i += 1;
      }
      this.idy.setText(2131760650);
      this.idy.setTextColor(getResources().getColor(2131099840));
      i = (int)getResources().getDimension(2131165611);
      this.idz.setPadding(i, i, i, i);
      this.idz.setBackgroundResource(2131232849);
      this.idw.setVisibility(8);
    }
    if (this.ics != null) {
      this.ics.requestLayout();
    }
    this.idH = 0;
    this.ido.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63661);
        AppMethodBeat.o(63661);
      }
    });
    AppMethodBeat.o(63689);
  }
  
  private boolean aHy()
  {
    return this.scene == 6;
  }
  
  private static boolean aK(List<String> paramList)
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
    } while (!bt.kU((String)paramList.next(), u.aqG()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(63694);
      return bool;
    }
  }
  
  private void bF(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(63673);
    this.idE.setVisibility(0);
    this.idE.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
    this.idE.setText(paramString1);
    this.idE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63641);
        com.tencent.mm.wallet_core.ui.e.aS(LaunchAAUI.this.getContext(), paramString2);
        AppMethodBeat.o(63641);
      }
    });
    AppMethodBeat.o(63673);
  }
  
  private void eO(boolean paramBoolean)
  {
    AppMethodBeat.i(63679);
    this.idC.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.idi.setTextColor(getResources().getColor(2131099841));
      this.ibG.setTextColor(getResources().getColor(2131099841));
      this.idj.setTextColor(getResources().getColor(2131099841));
      AppMethodBeat.o(63679);
      return;
    }
    this.idi.setTextColor(getResources().getColor(2131100711));
    this.ibG.setTextColor(getResources().getColor(2131100711));
    this.idj.setTextColor(getResources().getColor(2131100711));
    AppMethodBeat.o(63679);
  }
  
  public static ax getKV()
  {
    AppMethodBeat.i(201262);
    ax localax = ax.aFC("aa_pay");
    AppMethodBeat.o(201262);
    return localax;
  }
  
  private void o(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63672);
    ad.i("MicroMsg.Aa.LaunchAAUI", "go to contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("Select_block_List", u.aqG());
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
    if (this.mode == com.tencent.mm.plugin.aa.model.a.hYJ)
    {
      paramArrayList = new StringBuilder();
      localObject = this.idu.iterator();
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
      if (aHy()) {
        localIntent.putExtra("key_title", this.idh.getText().toString());
      }
      com.tencent.mm.bs.d.b(getContext(), "remittance", ".ui.SelectRemittanceContactUI", localIntent, 320);
      pS(10);
      AppMethodBeat.o(63672);
      return;
      paramArrayList = new StringBuilder();
      localObject = this.idA.keySet().iterator();
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
        if (this.mode == com.tencent.mm.plugin.aa.model.a.hYJ)
        {
          if (!bt.isNullOrNil(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.idu.clear();
            this.idu.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = com.tencent.mm.plugin.aa.model.i.BL(this.chatroomName);
          if ((paramIntent == null) || (this.idu == null) || (this.idu.size() != paramIntent.size()) || (!w.pF(this.chatroomName))) {
            break label316;
          }
          paramIntent = this.idr;
          if (this.idu != null)
          {
            paramInt1 = this.idu.size();
            paramIntent.setText(getString(2131760634, new Object[] { Integer.valueOf(paramInt1) }));
          }
        }
        else
        {
          aHE();
          if ((this.idu == null) || (this.idu.size() <= com.tencent.mm.plugin.aa.model.e.aHd())) {
            break label368;
          }
          this.idg = true;
          d = bt.getDouble(this.idp.getText(), 0.0D);
          if ((this.idu == null) || (d * 100.0D / this.idu.size() <= com.tencent.mm.plugin.aa.model.e.aHe())) {
            break label376;
          }
          this.icP = true;
          com.tencent.mm.plugin.report.service.h.vKh.f(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          aHF();
          aHG();
          aHH();
          AppMethodBeat.o(63690);
          return;
          paramInt1 = 0;
          break;
          label316:
          paramIntent = this.idr;
          if (this.idu != null) {}
          for (paramInt1 = this.idu.size();; paramInt1 = 0)
          {
            paramIntent.setText(getString(2131760639, new Object[] { Integer.valueOf(paramInt1) }));
            break;
          }
          label368:
          this.idg = false;
          break label222;
          label376:
          this.icP = false;
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
            this.idA.clear();
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext())
              {
                localObject = ((String)paramIntent.next()).split(",");
                d = bt.getDouble(localObject[1], 0.0D);
                this.idA.put(localObject[0], Double.valueOf(d));
              }
            }
            aHB();
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
            paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.apW());
            if (bt.isNullOrNil(paramIntent)) {}
          }
          for (this.imagePath = paramIntent;; this.imagePath = ((String)((ArrayList)localObject).get(0)))
          {
            if (!bt.isNullOrNil(this.imagePath))
            {
              this.ibx = 2;
              this.idm.setVisibility(0);
              this.idl.setVisibility(8);
              paramIntent = MMBitmapFactory.decodeFile(this.imagePath);
              this.idm.setImageBitmap(paramIntent);
              pS(8);
            }
            ad.i("MicroMsg.Aa.LaunchAAUI", "SELECT_IMAGE_REQUEST_CODE imagePath:%s", new Object[] { this.imagePath });
            AppMethodBeat.o(63690);
            return;
          }
        }
      }
      else if ((paramInt1 == 310) && (paramInt2 == -1))
      {
        this.ibx = 2;
        this.imagePath = "";
        this.idm.setVisibility(8);
        this.idl.setVisibility(0);
        pS(7);
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
    if (aHy())
    {
      this.idM = ((NetSceneNewAAQueryPFInfo.PfInfoParcel)getIntent().getParcelableExtra("pfInfo"));
      this.icv = getIntent().getStringExtra("pfOrderNo");
      if (this.idM == null)
      {
        ad.e("MicroMsg.Aa.LaunchAAUI", "pfInfoParcel is null!!!");
        finish();
        AppMethodBeat.o(63669);
        return;
      }
      this.mode = com.tencent.mm.plugin.aa.model.a.hYK;
      this.idK = this.idM.dEb;
      this.idL = this.idM.iaz;
      pS(1);
      if (!aHy()) {
        break label1445;
      }
      this.idF = new com.tencent.mm.plugin.aa.model.e(this.idM.iaC.iav, this.idM.iaC.iau);
      if ((!bt.isNullOrNil(this.idF.hZw)) && (!bt.isNullOrNil(this.idF.hZv))) {
        bF(this.idF.hZw, this.idF.hZv);
      }
      this.chatroomName = getIntent().getStringExtra("chatroom_name");
      if (bt.isNullOrNil(this.chatroomName))
      {
        ad.e("MicroMsg.Aa.LaunchAAUI", "chatroomName is null!!!");
        this.chatroomName = "";
      }
      paramBundle = this.chatroomName;
      if (bt.isNullOrNil(paramBundle)) {
        break label1540;
      }
      if (!w.pF(paramBundle)) {
        break label1492;
      }
      label301:
      this.chatroomName = paramBundle;
      this.ics = findViewById(2131304241);
      this.idn = ((TextView)findViewById(2131301326));
      this.idC = ((Button)findViewById(2131301318));
      this.idD = ((TextView)findViewById(2131301315));
      this.idE = ((TextView)findViewById(2131301331));
      this.idh = ((MMEditText)findViewById(2131301327));
      this.idi = ((TextView)findViewById(2131301330));
      this.ibG = ((TextView)findViewById(2131301316));
      this.idj = ((TextView)findViewById(2131301317));
      this.idk = ((RelativeLayout)findViewById(2131303242));
      this.idl = ((ImageView)findViewById(2131303325));
      this.idm = ((ImageView)findViewById(2131298760));
      this.ido = ((TextView)findViewById(2131296289));
      this.idp = ((WalletFormView)findViewById(2131301329));
      this.idr = ((TextView)findViewById(2131301319));
      this.idq = ((TextView)findViewById(2131301320));
      this.ids = ((ViewGroup)findViewById(2131301334));
      this.idt = ((ViewGroup)findViewById(2131301333));
      this.idy = ((TextView)findViewById(2131301324));
      this.idy.setText(2131760650);
      this.idy.setTextColor(getResources().getColor(2131099840));
      this.idv = ((ViewGroup)findViewById(2131301335));
      this.idw = ((ViewGroup)findViewById(2131301336));
      this.idz = ((ViewGroup)findViewById(2131301323));
      this.ics.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(63659);
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          if (LaunchAAUI.a(LaunchAAUI.this).findFocus() != null) {
            LaunchAAUI.a(LaunchAAUI.this).setCursorVisible(false);
          }
          AppMethodBeat.o(63659);
          return false;
        }
      });
      this.idn.setClickable(true);
      this.idn.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      if (this.mode != com.tencent.mm.plugin.aa.model.a.hYJ) {
        break label1546;
      }
      this.ids.setVisibility(0);
      this.idt.setVisibility(0);
      this.idv.setVisibility(8);
      this.idi.setText(2131760638);
      this.idg = false;
      if (this.idu.size() > com.tencent.mm.plugin.aa.model.e.aHd()) {
        this.idg = true;
      }
      aHH();
      label750:
      aHC();
      Object localObject;
      if (aHy()) {
        try
        {
          paramBundle = this.idM.iax;
          this.idA.clear();
          if ((paramBundle == null) || (paramBundle.size() <= 0)) {
            break label1675;
          }
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            localObject = (NetSceneNewAAQueryPFInfo.AALaunchItemParcel)paramBundle.next();
            this.idA.put(((NetSceneNewAAQueryPFInfo.AALaunchItemParcel)localObject).username, Double.valueOf(((NetSceneNewAAQueryPFInfo.AALaunchItemParcel)localObject).dEb / 100.0D));
          }
          this.idC.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(63662);
              LaunchAAUI.b(LaunchAAUI.this);
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
      this.ido.setClickable(true);
      this.ido.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
      paramBundle = new SpannableString(getString(2131757336));
      paramBundle.setSpan(new a(new a.a()
      {
        public final void aHn()
        {
          AppMethodBeat.i(63663);
          Object localObject = new Intent(LaunchAAUI.this, AAQueryListUI.class);
          LaunchAAUI localLaunchAAUI = LaunchAAUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLaunchAAUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (LaunchAAUI.c(LaunchAAUI.this) == com.tencent.mm.plugin.aa.model.a.hYJ)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            AppMethodBeat.o(63663);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
          AppMethodBeat.o(63663);
        }
      }), 0, paramBundle.length(), 18);
      this.ido.setText(paramBundle);
      this.ido.setVisibility(8);
      this.idh.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63664);
          LaunchAAUI.d(LaunchAAUI.this);
          LaunchAAUI.this.pS(6);
          AppMethodBeat.o(63664);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.idh.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(63665);
          LaunchAAUI.a(LaunchAAUI.this).setCursorVisible(true);
          AppMethodBeat.o(63665);
          return false;
        }
      });
      aHD();
      this.idz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63666);
          LaunchAAUI.e(LaunchAAUI.this);
          AppMethodBeat.o(63666);
        }
      });
      if (!bt.isNullOrNil(this.idL))
      {
        ad.i("MicroMsg.Aa.LaunchAAUI", "default title: %s", new Object[] { this.idL });
        this.idh.setText(this.idL);
        if (this.idL.length() <= 20) {
          break label1682;
        }
        i = 20;
        label1071:
        this.idh.setSelection(i);
      }
      if (!aHy()) {
        break label1693;
      }
      paramBundle = String.format("%.2f", new Object[] { Double.valueOf(this.idK / 100.0D) });
      this.idp.setText(paramBundle);
      this.idp.setSelection(paramBundle.length());
      label1131:
      aHF();
      if ((aHy()) && (ax.aFC("aa_pay").getBoolean("new_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        localObject = getLayoutInflater().inflate(2131492884, null);
        ((View)localObject).findViewById(2131300870).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(63631);
            LaunchAAUI.getKV().edit().putBoolean("new_user_guide_show", false);
            paramBundle.bfo();
            LaunchAAUI.this.pS(2);
            AppMethodBeat.o(63631);
          }
        });
        paramBundle.HrX = new LaunchAAUI.5(this, paramBundle, (View)localObject);
        paramBundle.ffu();
        paramBundle.csG();
      }
      if (aHy())
      {
        this.idk.setVisibility(0);
        this.idk.setOnClickListener(new LaunchAAUI.6(this));
        this.idm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(63636);
            if (LaunchAAUI.i(LaunchAAUI.this) == null) {
              LaunchAAUI.a(LaunchAAUI.this, com.tencent.mm.ui.base.h.a(LaunchAAUI.this, 3, 2131820985, LaunchAAUI.this.getString(2131760709), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(63634);
                  if ((LaunchAAUI.i(LaunchAAUI.this) != null) && (LaunchAAUI.i(LaunchAAUI.this).isShowing())) {
                    LaunchAAUI.i(LaunchAAUI.this).dismiss();
                  }
                  AppMethodBeat.o(63634);
                }
              }));
            }
            o.ayI().a(LaunchAAUI.j(LaunchAAUI.this), new p.a()
            {
              public final void a(String paramAnonymous2String1, Bitmap paramAnonymous2Bitmap, String paramAnonymous2String2)
              {
                AppMethodBeat.i(63635);
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
                  com.tencent.mm.bs.d.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous2String1, 310);
                  LaunchAAUI.this.pS(14);
                  AppMethodBeat.o(63635);
                  return;
                }
                Toast.makeText(LaunchAAUI.this, 2131755038, 1).show();
                AppMethodBeat.o(63635);
              }
            });
            AppMethodBeat.o(63636);
          }
        });
        if ((this.idM == null) || (bt.isNullOrNil(this.idM.iay))) {
          break label1784;
        }
        this.ibx = 1;
        this.gFC = this.idM.iay;
        this.idm.setVisibility(0);
        this.idl.setVisibility(8);
        o.ayI().a(this.idM.iay, this.idM.iaB, new p.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            boolean bool = false;
            AppMethodBeat.i(63638);
            if (paramAnonymousBitmap == null) {
              bool = true;
            }
            ad.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s bitmap==null:%s path:%s", new Object[] { paramAnonymousString1, Boolean.valueOf(bool), paramAnonymousString2 });
            LaunchAAUI.a(LaunchAAUI.this, paramAnonymousString2);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(63637);
                if (paramAnonymousBitmap != null)
                {
                  LaunchAAUI.m(LaunchAAUI.this).setImageBitmap(paramAnonymousBitmap);
                  AppMethodBeat.o(63637);
                  return;
                }
                LaunchAAUI.n(LaunchAAUI.this);
                LaunchAAUI.m(LaunchAAUI.this).setVisibility(8);
                LaunchAAUI.o(LaunchAAUI.this).setVisibility(0);
                AppMethodBeat.o(63637);
              }
            });
            AppMethodBeat.o(63638);
          }
        });
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      if ((aHy()) && (this.idO != null)) {
        this.idO.alive();
      }
      AppMethodBeat.o(63669);
      return;
      this.mode = com.tencent.mm.plugin.aa.model.a.hYJ;
      this.idJ = getIntent().getStringExtra("amount");
      this.idL = getIntent().getStringExtra("title");
      break;
      label1445:
      paramBundle = this.idf.iba;
      com.tencent.mm.vending.g.g.fhq().c(paramBundle).f(new com.tencent.mm.vending.c.a() {}).a(new LaunchAAUI.9(this));
      break label244;
      label1492:
      paramBundle = bt.S(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(u.aqG());
        if (paramBundle.size() > 0)
        {
          paramBundle = (String)paramBundle.get(0);
          break label301;
        }
      }
      label1540:
      paramBundle = "";
      break label301;
      label1546:
      if (this.mode != com.tencent.mm.plugin.aa.model.a.hYK) {
        break label750;
      }
      this.ids.setVisibility(8);
      this.idt.setVisibility(8);
      this.idv.setVisibility(0);
      this.idi.setText(getString(2131760649, new Object[] { Integer.valueOf(0) }));
      if ((this.idA != null) && (this.idA.size() > com.tencent.mm.plugin.aa.model.e.aHc())) {
        this.idg = true;
      }
      if (this.idg)
      {
        BP(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aHc()) }));
        break label750;
      }
      aHE();
      break label750;
      label1675:
      aHB();
      break label872;
      label1682:
      i = this.idL.length();
      break label1071;
      label1693:
      if (bt.isNullOrNil(this.idJ)) {
        break label1131;
      }
      ad.i("MicroMsg.Aa.LaunchAAUI", "default amount: %s", new Object[] { this.idJ });
      paramBundle = com.tencent.mm.wallet_core.ui.e.b(new StringBuilder().append(this.idJ).toString(), "100", RoundingMode.HALF_UP);
      this.idp.setText(paramBundle);
      this.idp.setSelection(paramBundle.length());
      break label1131;
      label1784:
      this.ibx = 2;
      this.imagePath = "";
      this.idm.setVisibility(8);
      this.idl.setVisibility(0);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63687);
    super.onDestroy();
    if ((aHy()) && (this.idO != null)) {
      this.idO.dead();
    }
    AppMethodBeat.o(63687);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(63686);
    super.onStop();
    if (this.idB != null) {
      this.idB.clear();
    }
    AppMethodBeat.o(63686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pS(int paramInt)
  {
    AppMethodBeat.i(63691);
    if (aHy()) {
      com.tencent.mm.plugin.aa.model.i.pS(paramInt);
    }
    AppMethodBeat.o(63691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */