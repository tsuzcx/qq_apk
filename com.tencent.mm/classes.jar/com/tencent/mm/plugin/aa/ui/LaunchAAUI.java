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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.g.a.la;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.wallet_core.ui.f;
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
  private String hBa;
  private int iXD;
  private Dialog iXE;
  private TextView iXQ;
  private Dialog iXW;
  private String iYH;
  private TextView iZA;
  private TextView iZB;
  private WalletFormView iZC;
  private TextView iZD;
  private TextView iZE;
  private ViewGroup iZF;
  private ViewGroup iZG;
  private List<String> iZH;
  private ViewGroup iZI;
  private ViewGroup iZJ;
  private TextView iZK;
  private ViewGroup iZL;
  private Map<String, Double> iZM;
  private Map<String, LaunchAAByPersonNameAmountRow> iZN;
  private Button iZO;
  private TextView iZP;
  private TextView iZQ;
  private com.tencent.mm.plugin.aa.model.e iZR;
  private int iZS;
  private int iZT;
  private boolean iZU;
  private String iZV;
  private long iZW;
  private String iZX;
  private NetSceneNewAAQueryPFInfo.PfInfoParcel iZY;
  private boolean iZZ;
  private boolean iZa;
  private com.tencent.mm.plugin.aa.model.b.e iZs;
  private boolean iZt;
  private MMEditText iZu;
  private TextView iZv;
  private TextView iZw;
  private RelativeLayout iZx;
  private ImageView iZy;
  private ImageView iZz;
  private String imagePath;
  private com.tencent.mm.sdk.b.c<la> jaa;
  private int mode;
  private int scene;
  private long timestamp;
  private Dialog tipDialog;
  
  public LaunchAAUI()
  {
    AppMethodBeat.i(63668);
    this.iZs = ((com.tencent.mm.plugin.aa.model.b.e)am(com.tencent.mm.plugin.aa.model.b.e.class));
    this.mode = com.tencent.mm.plugin.aa.model.a.iUP;
    this.chatroomName = null;
    this.iZt = false;
    this.iZa = false;
    this.iZH = new ArrayList();
    this.iZM = new HashMap();
    this.iZN = new HashMap();
    this.iZR = new com.tencent.mm.plugin.aa.model.e();
    this.iZS = 0;
    this.iZT = 0;
    this.iZU = false;
    this.timestamp = 0L;
    this.hBa = "";
    this.iZY = null;
    this.iZZ = false;
    this.iXE = null;
    this.jaa = new LaunchAAUI.1(this);
    AppMethodBeat.o(63668);
  }
  
  private void JG(String paramString)
  {
    AppMethodBeat.i(63676);
    this.iZU = true;
    this.iZP.setVisibility(0);
    this.iZP.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
    this.iZP.setText(paramString);
    AppMethodBeat.o(63676);
  }
  
  private void JH(final String paramString)
  {
    AppMethodBeat.i(63681);
    ae.i("MicroMsg.Aa.LaunchAAUI", "showLaunchComfirmDialog() from scene:%s", new Object[] { Integer.valueOf(this.scene) });
    String str = this.iZu.getText().toString();
    if (bu.isNullOrNil(str)) {
      str = getString(2131760652);
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.j.class)).a(getController(), paramString, getString(2131755032) + str, getString(2131755031), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(189760);
          if (paramAnonymousBoolean)
          {
            LaunchAAUI.b(LaunchAAUI.this, paramString);
            LaunchAAUI.this.ri(12);
            AppMethodBeat.o(189760);
            return;
          }
          LaunchAAUI.this.ri(13);
          AppMethodBeat.o(189760);
        }
      });
      ri(11);
      AppMethodBeat.o(63681);
      return;
    }
  }
  
  public static boolean JI(String paramString)
  {
    AppMethodBeat.i(63693);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63693);
      return false;
    }
    boolean bool = aJ(i.JC(paramString));
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
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVP, paramString2);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVQ, Double.valueOf(100.0D * paramDouble));
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVT, paramString1);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVW, Long.valueOf(this.timestamp));
    long l = f.a(i.bO(new StringBuilder().append(paramDouble).toString(), "100"), String.valueOf(paramInt), RoundingMode.CEILING);
    ae.d("MicroMsg.Aa.LaunchAAUI", "perAmount: %s", new Object[] { Long.valueOf(l) });
    if ((l <= 0L) || (l > com.tencent.mm.plugin.aa.model.e.aRD()))
    {
      ae.i("MicroMsg.Aa.LaunchAAUI", "illegal avgAmount: %s", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(63684);
      return;
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVS, Long.valueOf(l));
    if (aRY())
    {
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVX, paramString3);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVY, paramString4);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVZ, this.iYH);
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVV, paramList);
    this.iZs.iXe.d(this.mode, localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void ce(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(63658);
        ae.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        if (LaunchAAUI.v(LaunchAAUI.this) != null) {
          LaunchAAUI.v(LaunchAAUI.this).dismiss();
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
          com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131760658), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(182446);
              ae.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
              AppMethodBeat.o(182446);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(13722, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(63658);
          return;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof z)))
          {
            i.a(LaunchAAUI.this.getContext(), (z)paramAnonymousObject);
          }
          else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
          {
            paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
            String str1 = paramAnonymousObject.dyI;
            String str2 = paramAnonymousObject.kCZ;
            String str3 = paramAnonymousObject.kDa;
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
            locala.aZi(str1);
            locala.aZo(str3).c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182447);
                f.p(LaunchAAUI.this.getContext(), paramAnonymousObject.phk, false);
                AppMethodBeat.o(182447);
              }
            });
            locala.aZp(str2);
            locala.fQv().show();
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
    com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.iZu.getText().toString();
        if (bu.isNullOrNil(str1))
        {
          str1 = getString(2131760652);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator = this.iZM.keySet().iterator();
          long l1 = 0L;
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if ((!paramBoolean) || (paramList.contains(str2)))
            {
              double d = ((Double)this.iZM.get(str2)).doubleValue();
              com.tencent.mm.protocal.protobuf.j localj = new com.tencent.mm.protocal.protobuf.j();
              localj.dPq = f.mO(String.valueOf(d), "100");
              localj.username = str2;
              localArrayList1.add(localj);
              long l2 = localj.dPq;
              localArrayList2.add(localj.dPq);
              l1 = l2 + l1;
            }
          }
          else
          {
            paramList = new com.tencent.mm.protocal.protobuf.j();
            paramList.username = v.aAC();
            paramList.dPq = l1;
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVP, str1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVQ, Long.valueOf(l1));
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVV, localArrayList1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVT, paramString1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVW, Long.valueOf(this.timestamp));
            if (aRY())
            {
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVX, paramString2);
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVY, paramString3);
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.iVZ, this.iYH);
            }
            this.iZs.iXf.E(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
            {
              public final void ce(final Object paramAnonymousObject)
              {
                AppMethodBeat.i(189771);
                ae.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
                if (LaunchAAUI.v(LaunchAAUI.this) != null) {
                  LaunchAAUI.v(LaunchAAUI.this).dismiss();
                }
                if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
                  com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131760658), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(189769);
                      ae.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                      AppMethodBeat.o(189769);
                    }
                  });
                }
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.g.yxI.f(13722, new Object[] { Integer.valueOf(10) });
                  AppMethodBeat.o(189771);
                  return;
                  if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof z)))
                  {
                    i.a(LaunchAAUI.this.getContext(), (z)paramAnonymousObject);
                  }
                  else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
                  {
                    paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
                    String str1 = paramAnonymousObject.dyI;
                    String str2 = paramAnonymousObject.kCZ;
                    String str3 = paramAnonymousObject.kDa;
                    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
                    locala.aZi(str1);
                    locala.aZo(str3).c(new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(189770);
                        f.p(LaunchAAUI.this.getContext(), paramAnonymousObject.phk, false);
                        AppMethodBeat.o(189770);
                      }
                    });
                    locala.aZp(str2);
                    locala.fQv().show();
                  }
                  else
                  {
                    Toast.makeText(paramContext, 2131760656, 1).show();
                  }
                }
              }
            });
            com.tencent.mm.plugin.report.service.g.yxI.f(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(i.JC(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, bu.m(localArrayList2, ",") });
            AppMethodBeat.o(63685);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        ae.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPerson error: %s", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(63685);
        return;
      }
    }
  }
  
  private void a(Context paramContext, String paramString, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63682);
    ri(9);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iUP)
    {
      if (bu.isNullOrNil(this.iZC.getText()))
      {
        AppMethodBeat.o(63682);
        return;
      }
      if ((this.iZH == null) || (this.iZH.size() == 0))
      {
        AppMethodBeat.o(63682);
        return;
      }
      aSf();
      com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
      if ((paramBoolean) && (paramArrayList == null)) {}
    }
    for (;;)
    {
      try
      {
        i = paramArrayList.size();
        double d = bu.getDouble(this.iXQ.getText().toString(), 0.0D) * i;
        String str2 = this.iZu.getText().toString();
        String str1 = str2;
        if (bu.isNullOrNil(str2)) {
          str1 = getString(2131760652);
        }
        if (i > 0)
        {
          if (this.iXW != null) {
            this.iXW.dismiss();
          }
          this.iXW = com.tencent.mm.wallet_core.ui.h.c(paramContext, false, null);
          if ((aRY()) && (!bu.isNullOrNil(this.imagePath))) {
            new com.tencent.mm.plugin.aa.model.d(this.imagePath, new LaunchAAUI.20(this, paramBoolean, paramContext, paramString, i, str1, d, paramArrayList)).aRz();
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(13723, new Object[] { Integer.valueOf(1), i.JC(this.chatroomName), Integer.valueOf(i), Double.valueOf(100.0D * d), str1 });
          AppMethodBeat.o(63682);
          return;
          i = 0;
          continue;
          if (this.iZH == null) {
            break label529;
          }
          i = this.iZH.size();
          d = bu.getDouble(this.iZC.getText(), 0.0D);
          continue;
        }
        if (paramBoolean)
        {
          a(paramContext, paramString, i, str1, d, paramArrayList);
          continue;
        }
        a(paramContext, paramString, i, str1, d, this.iZH);
      }
      catch (Exception paramContext)
      {
        ae.e("MicroMsg.Aa.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[] { Integer.valueOf(this.mode), paramContext.getMessage() });
        AppMethodBeat.o(63682);
        return;
      }
      continue;
      aSf();
      if (this.iXW != null) {
        this.iXW.dismiss();
      }
      this.iXW = com.tencent.mm.wallet_core.ui.h.c(paramContext, false, null);
      if ((aRY()) && (!bu.isNullOrNil(this.imagePath)))
      {
        new com.tencent.mm.plugin.aa.model.d(this.imagePath, new LaunchAAUI.21(this, paramContext, paramString, paramBoolean, paramArrayList)).aRz();
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
    } while (!bu.lX((String)paramList.next(), v.aAC()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(63694);
      return bool;
    }
  }
  
  private boolean aRY()
  {
    return this.scene == 6;
  }
  
  private void aSc()
  {
    AppMethodBeat.i(63671);
    aSj();
    aSh();
    aSg();
    AppMethodBeat.o(63671);
  }
  
  private void aSd()
  {
    AppMethodBeat.i(63674);
    String str1;
    String str2;
    SpannableStringBuilder localSpannableStringBuilder;
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iUP)
    {
      str1 = getString(2131760636);
      str2 = getString(2131760637);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aRM()
        {
          AppMethodBeat.i(189756);
          LaunchAAUI.q(LaunchAAUI.this);
          AppMethodBeat.o(189756);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.iZA.setText(localSpannableStringBuilder);
      AppMethodBeat.o(63674);
      return;
    }
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iUQ)
    {
      str1 = getString(2131760647);
      str2 = getString(2131760648);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aRM()
        {
          AppMethodBeat.i(189757);
          LaunchAAUI.q(LaunchAAUI.this);
          AppMethodBeat.o(189757);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.iZA.setText(localSpannableStringBuilder);
    }
    AppMethodBeat.o(63674);
  }
  
  private void aSe()
  {
    AppMethodBeat.i(63675);
    this.iZC.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(189758);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 3))
        {
          WalletFormView.a(LaunchAAUI.r(LaunchAAUI.this).getContentEt(), str, i + 3, j);
          double d = bu.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((LaunchAAUI.s(LaunchAAUI.this) == null) || (LaunchAAUI.s(LaunchAAUI.this).size() <= 0)) {
            break label283;
          }
          d = d * 100.0D / LaunchAAUI.s(LaunchAAUI.this).size();
          LaunchAAUI.p(LaunchAAUI.this);
          if (d <= com.tencent.mm.plugin.aa.model.e.aRD()) {
            break label283;
          }
          LaunchAAUI.a(LaunchAAUI.this, true);
          com.tencent.mm.plugin.report.service.g.yxI.f(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          LaunchAAUI.d(LaunchAAUI.this);
          LaunchAAUI.t(LaunchAAUI.this);
          LaunchAAUI.u(LaunchAAUI.this);
          LaunchAAUI.this.ri(3);
          AppMethodBeat.o(189758);
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
    setEditFocusListener(this.iZC, 2, false, false);
    this.iZC.setmContentAbnormalMoneyCheck(true);
    Object localObject;
    if (aRY())
    {
      localObject = new ArrayList();
      Iterator localIterator = this.iZM.keySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((String)localIterator.next());
      }
      this.iZE.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      this.iZH = ((List)localObject);
    }
    for (;;)
    {
      this.iZE.setOnClickListener(new LaunchAAUI.18(this, (List)localObject));
      this.iZC.requestFocus();
      this.iZt = false;
      AppMethodBeat.o(63675);
      return;
      if (x.wb(this.chatroomName)) {
        if (!x.zW(this.chatroomName)) {
          localObject = i.JC(this.chatroomName);
        }
      }
      for (;;)
      {
        this.iZH = ((List)localObject);
        if (this.iZH.size() <= com.tencent.mm.plugin.aa.model.e.aRC()) {
          break label306;
        }
        this.iZH.clear();
        this.iZE.setText(getString(2131761843));
        aSg();
        break;
        localObject = aSk();
        continue;
        ae.i("MicroMsg.Aa.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
        localObject = new ArrayList();
        ((List)localObject).add(v.aAC());
        ((List)localObject).add(this.chatroomName);
      }
      label306:
      if (x.wb(this.chatroomName))
      {
        if (!x.zW(this.chatroomName)) {
          this.iZE.setText(getString(2131760634, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        } else {
          this.iZE.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        }
      }
      else {
        this.iZE.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      }
    }
  }
  
  private void aSf()
  {
    AppMethodBeat.i(63677);
    this.iZU = false;
    if (this.iZP.getVisibility() != 8)
    {
      this.iZP.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.iZP.setVisibility(8);
    }
    AppMethodBeat.o(63677);
  }
  
  private void aSg()
  {
    AppMethodBeat.i(63678);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iUP)
    {
      if (bu.isNullOrNil(this.iZC.getText()))
      {
        fn(false);
        AppMethodBeat.o(63678);
        return;
      }
      if (this.iZa)
      {
        fn(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iZH == null) || (this.iZH.size() == 0))
      {
        fn(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iZH.size() > com.tencent.mm.plugin.aa.model.e.aRC()) || (this.iZt))
      {
        fn(false);
        AppMethodBeat.o(63678);
        return;
      }
      double d = i.a(this.iZC.getText(), this.iZH.size(), 5, 4);
      ae.d("MicroMsg.Aa.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.iZC.getText(), Integer.valueOf(this.iZH.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        ae.i("MicroMsg.Aa.LaunchAAUI", "less than 0.01");
        fn(false);
        AppMethodBeat.o(63678);
      }
    }
    else
    {
      if ((this.iZM == null) || (this.iZM.size() == 0))
      {
        fn(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iZM.size() > com.tencent.mm.plugin.aa.model.e.aRC()) || (this.iZt))
      {
        fn(false);
        AppMethodBeat.o(63678);
        return;
      }
    }
    fn(true);
    AppMethodBeat.o(63678);
  }
  
  private void aSh()
  {
    AppMethodBeat.i(63680);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iUP)
    {
      if ((this.iZH != null) && (this.iZH.size() > 0))
      {
        d = i.a(this.iZC.getText(), this.iZH.size(), 2, 2);
        this.iXQ.setText(getString(2131755021, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.iZv.setText(2131760638);
        AppMethodBeat.o(63680);
        return;
        this.iXQ.setText(getString(2131755023));
      }
    }
    if ((this.iZM == null) || (this.iZM.size() == 0))
    {
      this.iZv.setText(getString(2131760649, new Object[] { Integer.valueOf(0) }));
      this.iXQ.setText(getString(2131755023));
      AppMethodBeat.o(63680);
      return;
    }
    Iterator localIterator = this.iZM.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.iXQ.setText(getString(2131755021, new Object[] { Double.valueOf(d) }));
    this.iZv.setText(getString(2131760649, new Object[] { Integer.valueOf(this.iZM.size()) }));
    AppMethodBeat.o(63680);
  }
  
  private void aSi()
  {
    AppMethodBeat.i(63688);
    if ((this.iZt) && (!this.iZU))
    {
      if (this.mode == com.tencent.mm.plugin.aa.model.a.iUP)
      {
        JG(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aRC()) }));
        AppMethodBeat.o(63688);
        return;
      }
      JG(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aRB()) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((this.iZa) && (!this.iZU))
    {
      JG(getString(2131760660, new Object[] { Float.valueOf((float)com.tencent.mm.plugin.aa.model.e.aRD() / 100.0F) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((!this.iZt) && (!this.iZa)) {
      aSf();
    }
    AppMethodBeat.o(63688);
  }
  
  private void aSj()
  {
    AppMethodBeat.i(63689);
    int i;
    if ((this.iZM != null) && (this.iZM.size() > 0))
    {
      this.iZK.setText(getString(2131760651, new Object[] { Integer.valueOf(this.iZM.size()) }));
      this.iZK.setTextColor(getResources().getColor(2131100711));
      i = (int)getResources().getDimension(2131165611);
      int j = (int)getResources().getDimension(2131165608);
      int k = (int)getResources().getDimension(2131165609);
      this.iZL.setPadding(i, j, i, k);
      this.iZL.setBackgroundResource(2131232847);
      this.iZJ.setVisibility(0);
    }
    for (;;)
    {
      this.iZJ.removeAllViews();
      this.iZN.clear();
      if ((this.iZM == null) || (this.iZM.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.iZM.keySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        double d = ((Double)this.iZM.get(str)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (i >= this.iZM.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        localLaunchAAByPersonNameAmountRow.a(str, this.chatroomName, d);
        this.iZJ.addView(localLaunchAAByPersonNameAmountRow);
        this.iZN.put(str, localLaunchAAByPersonNameAmountRow);
        i += 1;
      }
      this.iZK.setText(2131760650);
      this.iZK.setTextColor(getResources().getColor(2131099840));
      i = (int)getResources().getDimension(2131165611);
      this.iZL.setPadding(i, i, i, i);
      this.iZL.setBackgroundResource(2131232849);
      this.iZJ.setVisibility(8);
    }
    if (this.iYE != null) {
      this.iYE.requestLayout();
    }
    this.iZT = 0;
    this.iZB.post(new Runnable()
    {
      public final void run() {}
    });
    AppMethodBeat.o(63689);
  }
  
  private List<String> aSk()
  {
    AppMethodBeat.i(189774);
    ArrayList localArrayList = new ArrayList();
    Object localObject = i.JC(this.chatroomName);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!an.aUq(str)) {
          localArrayList.add(str);
        }
      }
    }
    AppMethodBeat.o(189774);
    return localArrayList;
  }
  
  private void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63673);
    this.iZQ.setVisibility(0);
    this.iZQ.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
    this.iZQ.setText(paramString1);
    this.iZQ.setOnClickListener(new LaunchAAUI.14(this, paramString2));
    AppMethodBeat.o(63673);
  }
  
  private void fn(boolean paramBoolean)
  {
    AppMethodBeat.i(63679);
    this.iZO.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.iZv.setTextColor(getResources().getColor(2131099841));
      this.iXQ.setTextColor(getResources().getColor(2131099841));
      this.iZw.setTextColor(getResources().getColor(2131099841));
      AppMethodBeat.o(63679);
      return;
    }
    this.iZv.setTextColor(getResources().getColor(2131100711));
    this.iXQ.setTextColor(getResources().getColor(2131100711));
    this.iZw.setTextColor(getResources().getColor(2131100711));
    AppMethodBeat.o(63679);
  }
  
  public static ay getKV()
  {
    AppMethodBeat.i(224229);
    ay localay = ay.aRW("aa_pay");
    AppMethodBeat.o(224229);
    return localay;
  }
  
  private void t(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63672);
    ae.i("MicroMsg.Aa.LaunchAAUI", "go to contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("Select_block_List", v.aAC());
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
      ae.i("MicroMsg.Aa.LaunchAAUI", "gotoSelectContactUI %s", new Object[] { ((StringBuilder)localObject).toString() });
      localIntent.putExtra("recent_remittance_contact_list", ((StringBuilder)localObject).toString());
    }
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iUP)
    {
      paramArrayList = new StringBuilder();
      localObject = this.iZH.iterator();
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
      if (aRY()) {
        localIntent.putExtra("key_title", this.iZu.getText().toString());
      }
      com.tencent.mm.br.d.b(getContext(), "remittance", ".ui.SelectRemittanceContactUI", localIntent, 320);
      ri(10);
      AppMethodBeat.o(63672);
      return;
      paramArrayList = new StringBuilder();
      localObject = this.iZM.keySet().iterator();
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
      ae.e("MicroMsg.Aa.LaunchAAUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    ae.i("MicroMsg.Aa.LaunchAAUI", "onActivityResult requestCode:%s", new Object[] { Integer.valueOf(paramInt1) });
    label222:
    double d;
    if (paramInt1 == 233)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (this.mode == com.tencent.mm.plugin.aa.model.a.iUP)
        {
          if (!bu.isNullOrNil(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.iZH.clear();
            this.iZH.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = i.JC(this.chatroomName);
          if ((paramIntent == null) || (this.iZH == null) || (this.iZH.size() != paramIntent.size()) || (!x.wb(this.chatroomName))) {
            break label316;
          }
          paramIntent = this.iZE;
          if (this.iZH != null)
          {
            paramInt1 = this.iZH.size();
            paramIntent.setText(getString(2131760634, new Object[] { Integer.valueOf(paramInt1) }));
          }
        }
        else
        {
          aSf();
          if ((this.iZH == null) || (this.iZH.size() <= com.tencent.mm.plugin.aa.model.e.aRC())) {
            break label368;
          }
          this.iZt = true;
          d = bu.getDouble(this.iZC.getText(), 0.0D);
          if ((this.iZH == null) || (d * 100.0D / this.iZH.size() <= com.tencent.mm.plugin.aa.model.e.aRD())) {
            break label376;
          }
          this.iZa = true;
          com.tencent.mm.plugin.report.service.g.yxI.f(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          aSg();
          aSh();
          aSi();
          AppMethodBeat.o(63690);
          return;
          paramInt1 = 0;
          break;
          label316:
          paramIntent = this.iZE;
          if (this.iZH != null) {}
          for (paramInt1 = this.iZH.size();; paramInt1 = 0)
          {
            paramIntent.setText(getString(2131760639, new Object[] { Integer.valueOf(paramInt1) }));
            break;
          }
          label368:
          this.iZt = false;
          break label222;
          label376:
          this.iZa = false;
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
            this.iZM.clear();
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext())
              {
                localObject = ((String)paramIntent.next()).split(",");
                d = bu.getDouble(localObject[1], 0.0D);
                this.iZM.put(localObject[0], Double.valueOf(d));
              }
            }
            aSc();
          }
          catch (Exception paramIntent)
          {
            ae.e("MicroMsg.Aa.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[] { paramIntent.getMessage() });
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
            paramIntent = com.tencent.mm.ui.tools.a.j(this, paramIntent, com.tencent.mm.plugin.image.d.azQ());
            if (bu.isNullOrNil(paramIntent)) {}
          }
          for (this.imagePath = paramIntent;; this.imagePath = ((String)((ArrayList)localObject).get(0)))
          {
            if (!bu.isNullOrNil(this.imagePath))
            {
              this.iXD = 2;
              this.iZz.setVisibility(0);
              this.iZy.setVisibility(8);
              this.iZz.post(new LaunchAAUI.34(this));
              ri(8);
            }
            ae.i("MicroMsg.Aa.LaunchAAUI", "SELECT_IMAGE_REQUEST_CODE imagePath:%s", new Object[] { this.imagePath });
            AppMethodBeat.o(63690);
            return;
          }
        }
      }
      else if ((paramInt1 == 310) && (paramInt2 == -1))
      {
        this.iXD = 2;
        this.imagePath = "";
        this.iZz.setVisibility(8);
        this.iZy.setVisibility(0);
        ri(7);
      }
    }
    AppMethodBeat.o(63690);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(63669);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.Aa.LaunchAAUI", "LaunchAAUI onCreate");
    setBackBtn(new LaunchAAUI.12(this));
    this.timestamp = (System.currentTimeMillis() / 1000L);
    setMMTitle(2131760665);
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    label244:
    int i;
    if (aRY())
    {
      this.iZY = ((NetSceneNewAAQueryPFInfo.PfInfoParcel)getIntent().getParcelableExtra("pfInfo"));
      this.iYH = getIntent().getStringExtra("pfOrderNo");
      if (this.iZY == null)
      {
        ae.e("MicroMsg.Aa.LaunchAAUI", "pfInfoParcel is null!!!");
        finish();
        AppMethodBeat.o(63669);
        return;
      }
      this.mode = com.tencent.mm.plugin.aa.model.a.iUQ;
      this.iZW = this.iZY.dPq;
      this.iZX = this.iZY.iWF;
      ri(1);
      if (!aRY()) {
        break label1578;
      }
      this.iZR = new com.tencent.mm.plugin.aa.model.e(this.iZY.iWI.iWB, this.iZY.iWI.iWA);
      if ((!bu.isNullOrNil(this.iZR.iVC)) && (!bu.isNullOrNil(this.iZR.iVB))) {
        bP(this.iZR.iVC, this.iZR.iVB);
      }
      this.chatroomName = getIntent().getStringExtra("chatroom_name");
      if (bu.isNullOrNil(this.chatroomName))
      {
        ae.e("MicroMsg.Aa.LaunchAAUI", "chatroomName is null!!!");
        this.chatroomName = "";
      }
      paramBundle = this.chatroomName;
      if (bu.isNullOrNil(paramBundle)) {
        break label1673;
      }
      if (!x.wb(paramBundle)) {
        break label1625;
      }
      label301:
      this.chatroomName = paramBundle;
      this.iYE = findViewById(2131304241);
      this.iZA = ((TextView)findViewById(2131301326));
      this.iZO = ((Button)findViewById(2131301318));
      this.iZP = ((TextView)findViewById(2131301315));
      this.iZQ = ((TextView)findViewById(2131301331));
      this.iZu = ((MMEditText)findViewById(2131301327));
      this.iZv = ((TextView)findViewById(2131301330));
      this.iXQ = ((TextView)findViewById(2131301316));
      this.iZw = ((TextView)findViewById(2131301317));
      this.iZx = ((RelativeLayout)findViewById(2131303242));
      this.iZy = ((ImageView)findViewById(2131303325));
      this.iZz = ((ImageView)findViewById(2131298760));
      this.iZB = ((TextView)findViewById(2131296289));
      this.iZC = ((WalletFormView)findViewById(2131301329));
      this.iZE = ((TextView)findViewById(2131301319));
      this.iZD = ((TextView)findViewById(2131301320));
      this.iZF = ((ViewGroup)findViewById(2131301334));
      this.iZG = ((ViewGroup)findViewById(2131301333));
      this.iZK = ((TextView)findViewById(2131301324));
      this.iZK.setText(2131760650);
      this.iZK.setTextColor(getResources().getColor(2131099840));
      this.iZI = ((ViewGroup)findViewById(2131301335));
      this.iZJ = ((ViewGroup)findViewById(2131301336));
      this.iZL = ((ViewGroup)findViewById(2131301323));
      this.iYE.setOnTouchListener(new LaunchAAUI.23(this));
      this.iZA.setClickable(true);
      this.iZA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      if (this.mode != com.tencent.mm.plugin.aa.model.a.iUP) {
        break label1679;
      }
      this.iZF.setVisibility(0);
      this.iZG.setVisibility(0);
      this.iZI.setVisibility(8);
      this.iZv.setText(2131760638);
      this.iZt = false;
      if (this.iZH.size() > com.tencent.mm.plugin.aa.model.e.aRC()) {
        this.iZt = true;
      }
      aSi();
      label750:
      aSd();
      Object localObject;
      if (aRY()) {
        try
        {
          paramBundle = this.iZY.iWD;
          this.iZM.clear();
          if ((paramBundle == null) || (paramBundle.size() <= 0)) {
            break label1808;
          }
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            localObject = (NetSceneNewAAQueryPFInfo.AALaunchItemParcel)paramBundle.next();
            this.iZM.put(((NetSceneNewAAQueryPFInfo.AALaunchItemParcel)localObject).username, Double.valueOf(((NetSceneNewAAQueryPFInfo.AALaunchItemParcel)localObject).dPq / 100.0D));
          }
          this.iZO.setOnClickListener(new LaunchAAUI.28(this));
        }
        catch (Exception paramBundle)
        {
          ae.e("MicroMsg.Aa.LaunchAAUI", "initPersonLaunchView error:%s %s", new Object[] { paramBundle.getClass().getSimpleName(), paramBundle.getMessage() });
        }
      }
      label872:
      this.iZB.setClickable(true);
      this.iZB.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
      paramBundle = new SpannableString(getString(2131757336));
      paramBundle.setSpan(new a(new LaunchAAUI.29(this)), 0, paramBundle.length(), 18);
      this.iZB.setText(paramBundle);
      this.iZB.setVisibility(8);
      this.iZu.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63664);
          LaunchAAUI.d(LaunchAAUI.this);
          LaunchAAUI.this.ri(6);
          AppMethodBeat.o(63664);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.iZu.setOnTouchListener(new LaunchAAUI.31(this));
      aSe();
      this.iZL.setOnClickListener(new LaunchAAUI.32(this));
      if (!bu.isNullOrNil(this.iZX))
      {
        ae.i("MicroMsg.Aa.LaunchAAUI", "default title: %s", new Object[] { this.iZX });
        this.iZu.setText(this.iZX);
        if (this.iZX.length() <= 20) {
          break label1815;
        }
        i = 20;
        label1071:
        this.iZu.setSelection(i);
      }
      if (!aRY()) {
        break label1826;
      }
      paramBundle = String.format("%.2f", new Object[] { Double.valueOf(this.iZW / 100.0D) });
      this.iZC.setText(paramBundle);
      this.iZC.setSelection(paramBundle.length());
      label1131:
      aSg();
      if ((aRY()) && (ay.aRW("aa_pay").getBoolean("new_user_guide_show", true)))
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            LaunchAAUI.getKV().edit().putBoolean("new_user_guide_show", false);
            paramBundle.bqD();
            LaunchAAUI.this.ri(2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63631);
          }
        });
        paramBundle.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(63632);
            paramAnonymousl.clear();
            paramBundle.setFooterView(null);
            paramBundle.setFooterView(this.jae);
            AppMethodBeat.o(63632);
          }
        };
        paramBundle.fQw();
        paramBundle.cPF();
      }
      if ((x.zW(this.chatroomName)) && (ay.aRW("aa_pay").getBoolean("new_open_IM_user_guide_show", true)))
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            LaunchAAUI.getKV().edit().putBoolean("new_open_IM_user_guide_show", false);
            paramBundle.bqD();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63633);
          }
        });
        paramBundle.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(189746);
            paramAnonymousl.clear();
            paramBundle.setFooterView(null);
            paramBundle.setFooterView(this.jae);
            AppMethodBeat.o(189746);
          }
        };
        paramBundle.fQw();
        paramBundle.cPF();
      }
      if (aRY())
      {
        this.iZx.setVisibility(0);
        this.iZx.setOnClickListener(new LaunchAAUI.8(this));
        this.iZz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(189750);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (LaunchAAUI.i(LaunchAAUI.this) == null) {
              LaunchAAUI.a(LaunchAAUI.this, com.tencent.mm.ui.base.h.a(LaunchAAUI.this, 3, 2131820985, LaunchAAUI.this.getString(2131760709), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(189748);
                  if ((LaunchAAUI.i(LaunchAAUI.this) != null) && (LaunchAAUI.i(LaunchAAUI.this).isShowing())) {
                    LaunchAAUI.i(LaunchAAUI.this).dismiss();
                  }
                  AppMethodBeat.o(189748);
                }
              }));
            }
            if (!bu.isNullOrNil(LaunchAAUI.j(LaunchAAUI.this))) {
              q.aJa().a(LaunchAAUI.j(LaunchAAUI.this), new r.a()
              {
                public final void a(String paramAnonymous2String1, Bitmap paramAnonymous2Bitmap, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(189749);
                  ae.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous2String1, paramAnonymous2String2 });
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
                    com.tencent.mm.br.d.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous2String1, 310);
                    LaunchAAUI.this.ri(14);
                    AppMethodBeat.o(189749);
                    return;
                  }
                  Toast.makeText(LaunchAAUI.this, 2131755038, 1).show();
                  AppMethodBeat.o(189749);
                }
              });
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(189750);
              return;
              ae.i("MicroMsg.Aa.LaunchAAUI", "imageUrl == null");
              if ((LaunchAAUI.i(LaunchAAUI.this) != null) && (LaunchAAUI.i(LaunchAAUI.this).isShowing())) {
                LaunchAAUI.i(LaunchAAUI.this).dismiss();
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("use_scene", 1);
              LaunchAAUI.n(LaunchAAUI.this);
              paramAnonymousView.putExtra("scene", LaunchAAUI.k(LaunchAAUI.this));
              paramAnonymousView.putExtra("path", LaunchAAUI.l(LaunchAAUI.this));
              paramAnonymousView.putExtra("view_info", ViewAnimHelper.o(LaunchAAUI.m(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
              com.tencent.mm.br.d.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymousView, 310);
              LaunchAAUI.this.ri(14);
            }
          }
        });
        if ((this.iZY == null) || (bu.isNullOrNil(this.iZY.iWE))) {
          break label1918;
        }
        this.iXD = 1;
        this.hBa = this.iZY.iWE;
        this.iZz.setVisibility(0);
        this.iZy.setVisibility(8);
        q.aJa().a(this.iZY.iWE, this.iZY.iWH, new r.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            boolean bool = false;
            AppMethodBeat.i(189752);
            if (paramAnonymousBitmap == null) {
              bool = true;
            }
            ae.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s bitmap==null:%s path:%s", new Object[] { paramAnonymousString1, Boolean.valueOf(bool), paramAnonymousString2 });
            LaunchAAUI.a(LaunchAAUI.this, paramAnonymousString2);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(189751);
                if (paramAnonymousBitmap != null)
                {
                  LaunchAAUI.m(LaunchAAUI.this).setImageBitmap(paramAnonymousBitmap);
                  AppMethodBeat.o(189751);
                  return;
                }
                LaunchAAUI.n(LaunchAAUI.this);
                LaunchAAUI.m(LaunchAAUI.this).setVisibility(8);
                LaunchAAUI.o(LaunchAAUI.this).setVisibility(0);
                AppMethodBeat.o(189751);
              }
            });
            AppMethodBeat.o(189752);
          }
        });
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      if ((aRY()) && (this.jaa != null)) {
        this.jaa.alive();
      }
      AppMethodBeat.o(63669);
      return;
      this.mode = com.tencent.mm.plugin.aa.model.a.iUP;
      this.iZV = getIntent().getStringExtra("amount");
      this.iZX = getIntent().getStringExtra("title");
      break;
      label1578:
      paramBundle = this.iZs.iXg;
      com.tencent.mm.vending.g.g.fSA().c(paramBundle).f(new com.tencent.mm.vending.c.a() {}).a(new LaunchAAUI.11(this));
      break label244;
      label1625:
      paramBundle = bu.U(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(v.aAC());
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
      if (this.mode != com.tencent.mm.plugin.aa.model.a.iUQ) {
        break label750;
      }
      this.iZF.setVisibility(8);
      this.iZG.setVisibility(8);
      this.iZI.setVisibility(0);
      this.iZv.setText(getString(2131760649, new Object[] { Integer.valueOf(0) }));
      if ((this.iZM != null) && (this.iZM.size() > com.tencent.mm.plugin.aa.model.e.aRB())) {
        this.iZt = true;
      }
      if (this.iZt)
      {
        JG(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aRB()) }));
        break label750;
      }
      aSf();
      break label750;
      label1808:
      aSc();
      break label872;
      label1815:
      i = this.iZX.length();
      break label1071;
      label1826:
      if (bu.isNullOrNil(this.iZV)) {
        break label1131;
      }
      ae.i("MicroMsg.Aa.LaunchAAUI", "default amount: %s", new Object[] { this.iZV });
      paramBundle = f.a(new StringBuilder().append(this.iZV).toString(), "100", 2, RoundingMode.HALF_UP);
      this.iZC.setText(paramBundle);
      this.iZC.setSelection(paramBundle.length());
      break label1131;
      label1918:
      this.iXD = 2;
      this.imagePath = "";
      this.iZz.setVisibility(8);
      this.iZy.setVisibility(0);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63687);
    super.onDestroy();
    if ((aRY()) && (this.jaa != null)) {
      this.jaa.dead();
    }
    AppMethodBeat.o(63687);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(63686);
    super.onStop();
    if (this.iZN != null) {
      this.iZN.clear();
    }
    AppMethodBeat.o(63686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void ri(int paramInt)
  {
    AppMethodBeat.i(63691);
    if (aRY()) {
      i.ri(paramInt);
    }
    AppMethodBeat.o(63691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */