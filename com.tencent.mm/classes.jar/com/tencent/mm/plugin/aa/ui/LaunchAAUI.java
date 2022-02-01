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
import com.tencent.mm.av.o;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.a;
import com.tencent.mm.g.a.kq;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
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
  private String hgd;
  private int iBA;
  private Dialog iBB;
  private TextView iBN;
  private Dialog iBT;
  private String iCE;
  private boolean iCX;
  private TextView iDA;
  private TextView iDB;
  private ViewGroup iDC;
  private ViewGroup iDD;
  private List<String> iDE;
  private ViewGroup iDF;
  private ViewGroup iDG;
  private TextView iDH;
  private ViewGroup iDI;
  private Map<String, Double> iDJ;
  private Map<String, LaunchAAByPersonNameAmountRow> iDK;
  private Button iDL;
  private TextView iDM;
  private TextView iDN;
  private com.tencent.mm.plugin.aa.model.e iDO;
  private int iDP;
  private int iDQ;
  private boolean iDR;
  private String iDS;
  private long iDT;
  private String iDU;
  private NetSceneNewAAQueryPFInfo.PfInfoParcel iDV;
  private boolean iDW;
  private com.tencent.mm.sdk.b.c<kq> iDX;
  private com.tencent.mm.plugin.aa.model.b.e iDp;
  private boolean iDq;
  private MMEditText iDr;
  private TextView iDs;
  private TextView iDt;
  private RelativeLayout iDu;
  private ImageView iDv;
  private ImageView iDw;
  private TextView iDx;
  private TextView iDy;
  private WalletFormView iDz;
  private String imagePath;
  private int mode;
  private int scene;
  private long timestamp;
  private Dialog tipDialog;
  
  public LaunchAAUI()
  {
    AppMethodBeat.i(63668);
    this.iDp = ((com.tencent.mm.plugin.aa.model.b.e)am(com.tencent.mm.plugin.aa.model.b.e.class));
    this.mode = com.tencent.mm.plugin.aa.model.a.iyN;
    this.chatroomName = null;
    this.iDq = false;
    this.iCX = false;
    this.iDE = new ArrayList();
    this.iDJ = new HashMap();
    this.iDK = new HashMap();
    this.iDO = new com.tencent.mm.plugin.aa.model.e();
    this.iDP = 0;
    this.iDQ = 0;
    this.iDR = false;
    this.timestamp = 0L;
    this.hgd = "";
    this.iDV = null;
    this.iDW = false;
    this.iBB = null;
    this.iDX = new LaunchAAUI.1(this);
    AppMethodBeat.o(63668);
  }
  
  private void FS(String paramString)
  {
    AppMethodBeat.i(63676);
    this.iDR = true;
    this.iDM.setVisibility(0);
    this.iDM.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
    this.iDM.setText(paramString);
    AppMethodBeat.o(63676);
  }
  
  private void FT(final String paramString)
  {
    AppMethodBeat.i(63681);
    ac.i("MicroMsg.Aa.LaunchAAUI", "showLaunchComfirmDialog() from scene:%s", new Object[] { Integer.valueOf(this.scene) });
    String str = this.iDr.getText().toString();
    if (bs.isNullOrNil(str)) {
      str = getString(2131760652);
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.i.class)).a(getController(), paramString, getString(2131755032) + str, getString(2131755031), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(207022);
          if (paramAnonymousBoolean)
          {
            LaunchAAUI.b(LaunchAAUI.this, paramString);
            LaunchAAUI.this.qF(12);
            AppMethodBeat.o(207022);
            return;
          }
          LaunchAAUI.this.qF(13);
          AppMethodBeat.o(207022);
        }
      });
      qF(11);
      AppMethodBeat.o(63681);
      return;
    }
  }
  
  public static boolean FU(String paramString)
  {
    AppMethodBeat.i(63693);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63693);
      return false;
    }
    boolean bool = aI(com.tencent.mm.plugin.aa.model.i.FO(paramString));
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
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.izM, paramString2);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.izN, Double.valueOf(100.0D * paramDouble));
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.izQ, paramString1);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.izT, Long.valueOf(this.timestamp));
    long l = com.tencent.mm.wallet_core.ui.e.a(com.tencent.mm.plugin.aa.model.i.bM(new StringBuilder().append(paramDouble).toString(), "100"), String.valueOf(paramInt), RoundingMode.CEILING);
    ac.d("MicroMsg.Aa.LaunchAAUI", "perAmount: %s", new Object[] { Long.valueOf(l) });
    if ((l <= 0L) || (l > com.tencent.mm.plugin.aa.model.e.aNS()))
    {
      ac.i("MicroMsg.Aa.LaunchAAUI", "illegal avgAmount: %s", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(63684);
      return;
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.izP, Long.valueOf(l));
    if (aOn())
    {
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.izU, paramString3);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.izV, paramString4);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.izW, this.iCE);
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.izS, paramList);
    this.iDp.iBb.c(this.mode, localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void cc(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(63658);
        ac.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        if (LaunchAAUI.v(LaunchAAUI.this) != null) {
          LaunchAAUI.v(LaunchAAUI.this).dismiss();
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
          com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131760658), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(182446);
              ac.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
              AppMethodBeat.o(182446);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(13722, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(63658);
          return;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof z)))
          {
            com.tencent.mm.plugin.aa.model.i.a(LaunchAAUI.this.getContext(), (z)paramAnonymousObject);
          }
          else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
          {
            paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
            String str1 = paramAnonymousObject.dlQ;
            String str2 = paramAnonymousObject.unW;
            String str3 = paramAnonymousObject.unX;
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
            locala.aRI(str1);
            locala.aRO(str3).b(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182447);
                com.tencent.mm.wallet_core.ui.e.o(LaunchAAUI.this.getContext(), paramAnonymousObject.oxl, false);
                AppMethodBeat.o(182447);
              }
            });
            locala.aRP(str2);
            locala.fvp().show();
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
    ((b)com.tencent.mm.kernel.g.ab(b.class)).gm(7, 5);
    com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.iDr.getText().toString();
        if (bs.isNullOrNil(str1))
        {
          str1 = getString(2131760652);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator = this.iDJ.keySet().iterator();
          long l1 = 0L;
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if ((!paramBoolean) || (paramList.contains(str2)))
            {
              double d = ((Double)this.iDJ.get(str2)).doubleValue();
              com.tencent.mm.protocal.protobuf.j localj = new com.tencent.mm.protocal.protobuf.j();
              localj.dBN = com.tencent.mm.wallet_core.ui.e.mk(String.valueOf(d), "100");
              localj.username = str2;
              localArrayList1.add(localj);
              long l2 = localj.dBN;
              localArrayList2.add(localj.dBN);
              l1 = l2 + l1;
            }
          }
          else
          {
            paramList = new com.tencent.mm.protocal.protobuf.j();
            paramList.username = u.axw();
            paramList.dBN = l1;
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.izM, str1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.izN, Long.valueOf(l1));
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.izS, localArrayList1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.izQ, paramString1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.izT, Long.valueOf(this.timestamp));
            if (aOn())
            {
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.izU, paramString2);
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.izV, paramString3);
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.izW, this.iCE);
            }
            this.iDp.iBc.x(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
            {
              public final void cc(final Object paramAnonymousObject)
              {
                AppMethodBeat.i(207033);
                ac.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
                if (LaunchAAUI.v(LaunchAAUI.this) != null) {
                  LaunchAAUI.v(LaunchAAUI.this).dismiss();
                }
                if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
                  com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131760658), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(207031);
                      ac.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                      AppMethodBeat.o(207031);
                    }
                  });
                }
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.h.wUl.f(13722, new Object[] { Integer.valueOf(10) });
                  AppMethodBeat.o(207033);
                  return;
                  if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof z)))
                  {
                    com.tencent.mm.plugin.aa.model.i.a(LaunchAAUI.this.getContext(), (z)paramAnonymousObject);
                  }
                  else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
                  {
                    paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
                    String str1 = paramAnonymousObject.dlQ;
                    String str2 = paramAnonymousObject.unW;
                    String str3 = paramAnonymousObject.unX;
                    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
                    locala.aRI(str1);
                    locala.aRO(str3).b(new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(207032);
                        com.tencent.mm.wallet_core.ui.e.o(LaunchAAUI.this.getContext(), paramAnonymousObject.oxl, false);
                        AppMethodBeat.o(207032);
                      }
                    });
                    locala.aRP(str2);
                    locala.fvp().show();
                  }
                  else
                  {
                    Toast.makeText(paramContext, 2131760656, 1).show();
                  }
                }
              }
            });
            com.tencent.mm.plugin.report.service.h.wUl.f(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.aa.model.i.FO(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, bs.n(localArrayList2, ",") });
            AppMethodBeat.o(63685);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        ac.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPerson error: %s", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(63685);
        return;
      }
    }
  }
  
  private void a(final Context paramContext, final String paramString, final boolean paramBoolean, final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63682);
    qF(9);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iyN)
    {
      if (bs.isNullOrNil(this.iDz.getText()))
      {
        AppMethodBeat.o(63682);
        return;
      }
      if ((this.iDE == null) || (this.iDE.size() == 0))
      {
        AppMethodBeat.o(63682);
        return;
      }
      aOu();
      com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
      if ((paramBoolean) && (paramArrayList == null)) {}
    }
    for (;;)
    {
      try
      {
        i = paramArrayList.size();
        final double d = bs.getDouble(this.iBN.getText().toString(), 0.0D) * i;
        String str2 = this.iDr.getText().toString();
        final String str1 = str2;
        if (bs.isNullOrNil(str2)) {
          str1 = getString(2131760652);
        }
        if (i > 0)
        {
          if (this.iBT != null) {
            this.iBT.dismiss();
          }
          this.iBT = com.tencent.mm.wallet_core.ui.g.c(paramContext, false, null);
          if ((aOn()) && (!bs.isNullOrNil(this.imagePath))) {
            new com.tencent.mm.plugin.aa.model.d(this.imagePath, new com.tencent.mm.plugin.aa.model.d.a()
            {
              public final void aNP()
              {
                AppMethodBeat.i(207026);
                ac.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(207024);
                    if (LaunchAAUI.v(LaunchAAUI.this) != null) {
                      LaunchAAUI.v(LaunchAAUI.this).dismiss();
                    }
                    Toast.makeText(LaunchAAUI.20.this.val$context, 2131760656, 1).show();
                    AppMethodBeat.o(207024);
                  }
                });
                AppMethodBeat.o(207026);
              }
              
              public final void bJ(final String paramAnonymousString1, final String paramAnonymousString2)
              {
                AppMethodBeat.i(207025);
                ac.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(207023);
                    if (LaunchAAUI.20.this.iEf)
                    {
                      LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.20.this.val$context, LaunchAAUI.20.this.fur, LaunchAAUI.20.this.iEg, LaunchAAUI.20.this.iEh, LaunchAAUI.20.this.iEi, LaunchAAUI.20.this.iEa, paramAnonymousString1, paramAnonymousString2);
                      AppMethodBeat.o(207023);
                      return;
                    }
                    LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.20.this.val$context, LaunchAAUI.20.this.fur, LaunchAAUI.20.this.iEg, LaunchAAUI.20.this.iEh, LaunchAAUI.20.this.iEi, LaunchAAUI.s(LaunchAAUI.this), paramAnonymousString1, paramAnonymousString2);
                    AppMethodBeat.o(207023);
                  }
                });
                AppMethodBeat.o(207025);
              }
            }).aNO();
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(13723, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.aa.model.i.FO(this.chatroomName), Integer.valueOf(i), Double.valueOf(100.0D * d), str1 });
          AppMethodBeat.o(63682);
          return;
          i = 0;
          continue;
          if (this.iDE == null) {
            break label530;
          }
          i = this.iDE.size();
          d = bs.getDouble(this.iDz.getText(), 0.0D);
          continue;
        }
        if (paramBoolean)
        {
          a(paramContext, paramString, i, str1, d, paramArrayList);
          continue;
        }
        a(paramContext, paramString, i, str1, d, this.iDE);
      }
      catch (Exception paramContext)
      {
        ac.e("MicroMsg.Aa.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[] { Integer.valueOf(this.mode), paramContext.getMessage() });
        AppMethodBeat.o(63682);
        return;
      }
      continue;
      aOu();
      if (this.iBT != null) {
        this.iBT.dismiss();
      }
      this.iBT = com.tencent.mm.wallet_core.ui.g.c(paramContext, false, null);
      if ((aOn()) && (!bs.isNullOrNil(this.imagePath)))
      {
        new com.tencent.mm.plugin.aa.model.d(this.imagePath, new com.tencent.mm.plugin.aa.model.d.a()
        {
          public final void aNP()
          {
            AppMethodBeat.i(207030);
            ac.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(207028);
                if (LaunchAAUI.v(LaunchAAUI.this) != null) {
                  LaunchAAUI.v(LaunchAAUI.this).dismiss();
                }
                Toast.makeText(LaunchAAUI.21.this.val$context, 2131760656, 1).show();
                AppMethodBeat.o(207028);
              }
            });
            AppMethodBeat.o(207030);
          }
          
          public final void bJ(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            AppMethodBeat.i(207029);
            ac.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(207027);
                LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.21.this.val$context, LaunchAAUI.21.this.fur, paramAnonymousString1, paramAnonymousString2, LaunchAAUI.21.this.iEf, LaunchAAUI.21.this.iEa);
                AppMethodBeat.o(207027);
              }
            });
            AppMethodBeat.o(207029);
          }
        }).aNO();
        AppMethodBeat.o(63682);
        return;
      }
      a(paramContext, paramString, "", "", paramBoolean, paramArrayList);
      AppMethodBeat.o(63682);
      return;
      label530:
      final int i = 0;
    }
  }
  
  private static boolean aI(List<String> paramList)
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
    } while (!bs.lr((String)paramList.next(), u.axw()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(63694);
      return bool;
    }
  }
  
  private boolean aOn()
  {
    return this.scene == 6;
  }
  
  private void aOr()
  {
    AppMethodBeat.i(63671);
    aOy();
    aOw();
    aOv();
    AppMethodBeat.o(63671);
  }
  
  private void aOs()
  {
    AppMethodBeat.i(63674);
    String str1;
    String str2;
    SpannableStringBuilder localSpannableStringBuilder;
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iyN)
    {
      str1 = getString(2131760636);
      str2 = getString(2131760637);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aOb()
        {
          AppMethodBeat.i(207018);
          LaunchAAUI.q(LaunchAAUI.this);
          AppMethodBeat.o(207018);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.iDx.setText(localSpannableStringBuilder);
      AppMethodBeat.o(63674);
      return;
    }
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iyO)
    {
      str1 = getString(2131760647);
      str2 = getString(2131760648);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aOb()
        {
          AppMethodBeat.i(207019);
          LaunchAAUI.q(LaunchAAUI.this);
          AppMethodBeat.o(207019);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.iDx.setText(localSpannableStringBuilder);
    }
    AppMethodBeat.o(63674);
  }
  
  private void aOt()
  {
    AppMethodBeat.i(63675);
    this.iDz.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(207020);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 3))
        {
          WalletFormView.a(LaunchAAUI.r(LaunchAAUI.this).getContentEt(), str, i + 3, j);
          double d = bs.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((LaunchAAUI.s(LaunchAAUI.this) == null) || (LaunchAAUI.s(LaunchAAUI.this).size() <= 0)) {
            break label283;
          }
          d = d * 100.0D / LaunchAAUI.s(LaunchAAUI.this).size();
          LaunchAAUI.p(LaunchAAUI.this);
          if (d <= com.tencent.mm.plugin.aa.model.e.aNS()) {
            break label283;
          }
          LaunchAAUI.a(LaunchAAUI.this, true);
          com.tencent.mm.plugin.report.service.h.wUl.f(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          LaunchAAUI.d(LaunchAAUI.this);
          LaunchAAUI.t(LaunchAAUI.this);
          LaunchAAUI.u(LaunchAAUI.this);
          LaunchAAUI.this.qF(3);
          AppMethodBeat.o(207020);
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
    setEditFocusListener(this.iDz, 2, false, false);
    this.iDz.setmContentAbnormalMoneyCheck(true);
    Object localObject;
    if (aOn())
    {
      localObject = new ArrayList();
      Iterator localIterator = this.iDJ.keySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((String)localIterator.next());
      }
      this.iDB.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      this.iDE = ((List)localObject);
    }
    for (;;)
    {
      this.iDB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207021);
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          LaunchAAUI.a(LaunchAAUI.this, this.fuR);
          AppMethodBeat.o(207021);
        }
      });
      this.iDz.requestFocus();
      this.iDq = false;
      AppMethodBeat.o(63675);
      return;
      if (w.sQ(this.chatroomName)) {
        if (!w.wr(this.chatroomName)) {
          localObject = com.tencent.mm.plugin.aa.model.i.FO(this.chatroomName);
        }
      }
      for (;;)
      {
        this.iDE = ((List)localObject);
        if (this.iDE.size() <= com.tencent.mm.plugin.aa.model.e.aNR()) {
          break label307;
        }
        this.iDE.clear();
        this.iDB.setText(getString(2131761843));
        aOv();
        break;
        localObject = aOz();
        continue;
        ac.i("MicroMsg.Aa.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
        localObject = new ArrayList();
        ((List)localObject).add(u.axw());
        ((List)localObject).add(this.chatroomName);
      }
      label307:
      if (w.sQ(this.chatroomName))
      {
        if (!w.wr(this.chatroomName)) {
          this.iDB.setText(getString(2131760634, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        } else {
          this.iDB.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        }
      }
      else {
        this.iDB.setText(getString(2131760639, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      }
    }
  }
  
  private void aOu()
  {
    AppMethodBeat.i(63677);
    this.iDR = false;
    if (this.iDM.getVisibility() != 8)
    {
      this.iDM.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.iDM.setVisibility(8);
    }
    AppMethodBeat.o(63677);
  }
  
  private void aOv()
  {
    AppMethodBeat.i(63678);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iyN)
    {
      if (bs.isNullOrNil(this.iDz.getText()))
      {
        fi(false);
        AppMethodBeat.o(63678);
        return;
      }
      if (this.iCX)
      {
        fi(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iDE == null) || (this.iDE.size() == 0))
      {
        fi(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iDE.size() > com.tencent.mm.plugin.aa.model.e.aNR()) || (this.iDq))
      {
        fi(false);
        AppMethodBeat.o(63678);
        return;
      }
      double d = com.tencent.mm.plugin.aa.model.i.a(this.iDz.getText(), this.iDE.size(), 5, 4);
      ac.d("MicroMsg.Aa.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.iDz.getText(), Integer.valueOf(this.iDE.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        ac.i("MicroMsg.Aa.LaunchAAUI", "less than 0.01");
        fi(false);
        AppMethodBeat.o(63678);
      }
    }
    else
    {
      if ((this.iDJ == null) || (this.iDJ.size() == 0))
      {
        fi(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.iDJ.size() > com.tencent.mm.plugin.aa.model.e.aNR()) || (this.iDq))
      {
        fi(false);
        AppMethodBeat.o(63678);
        return;
      }
    }
    fi(true);
    AppMethodBeat.o(63678);
  }
  
  private void aOw()
  {
    AppMethodBeat.i(63680);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iyN)
    {
      if ((this.iDE != null) && (this.iDE.size() > 0))
      {
        d = com.tencent.mm.plugin.aa.model.i.a(this.iDz.getText(), this.iDE.size(), 2, 2);
        this.iBN.setText(getString(2131755021, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.iDs.setText(2131760638);
        AppMethodBeat.o(63680);
        return;
        this.iBN.setText(getString(2131755023));
      }
    }
    if ((this.iDJ == null) || (this.iDJ.size() == 0))
    {
      this.iDs.setText(getString(2131760649, new Object[] { Integer.valueOf(0) }));
      this.iBN.setText(getString(2131755023));
      AppMethodBeat.o(63680);
      return;
    }
    Iterator localIterator = this.iDJ.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.iBN.setText(getString(2131755021, new Object[] { Double.valueOf(d) }));
    this.iDs.setText(getString(2131760649, new Object[] { Integer.valueOf(this.iDJ.size()) }));
    AppMethodBeat.o(63680);
  }
  
  private void aOx()
  {
    AppMethodBeat.i(63688);
    if ((this.iDq) && (!this.iDR))
    {
      if (this.mode == com.tencent.mm.plugin.aa.model.a.iyN)
      {
        FS(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aNR()) }));
        AppMethodBeat.o(63688);
        return;
      }
      FS(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aNQ()) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((this.iCX) && (!this.iDR))
    {
      FS(getString(2131760660, new Object[] { Float.valueOf((float)com.tencent.mm.plugin.aa.model.e.aNS() / 100.0F) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((!this.iDq) && (!this.iCX)) {
      aOu();
    }
    AppMethodBeat.o(63688);
  }
  
  private void aOy()
  {
    AppMethodBeat.i(63689);
    int i;
    if ((this.iDJ != null) && (this.iDJ.size() > 0))
    {
      this.iDH.setText(getString(2131760651, new Object[] { Integer.valueOf(this.iDJ.size()) }));
      this.iDH.setTextColor(getResources().getColor(2131100711));
      i = (int)getResources().getDimension(2131165611);
      int j = (int)getResources().getDimension(2131165608);
      int k = (int)getResources().getDimension(2131165609);
      this.iDI.setPadding(i, j, i, k);
      this.iDI.setBackgroundResource(2131232847);
      this.iDG.setVisibility(0);
    }
    for (;;)
    {
      this.iDG.removeAllViews();
      this.iDK.clear();
      if ((this.iDJ == null) || (this.iDJ.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.iDJ.keySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        double d = ((Double)this.iDJ.get(str)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (i >= this.iDJ.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        localLaunchAAByPersonNameAmountRow.a(str, this.chatroomName, d);
        this.iDG.addView(localLaunchAAByPersonNameAmountRow);
        this.iDK.put(str, localLaunchAAByPersonNameAmountRow);
        i += 1;
      }
      this.iDH.setText(2131760650);
      this.iDH.setTextColor(getResources().getColor(2131099840));
      i = (int)getResources().getDimension(2131165611);
      this.iDI.setPadding(i, i, i, i);
      this.iDI.setBackgroundResource(2131232849);
      this.iDG.setVisibility(8);
    }
    if (this.iCB != null) {
      this.iCB.requestLayout();
    }
    this.iDQ = 0;
    this.iDy.post(new Runnable()
    {
      public final void run() {}
    });
    AppMethodBeat.o(63689);
  }
  
  private List<String> aOz()
  {
    AppMethodBeat.i(207036);
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.aa.model.i.FO(this.chatroomName);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!ai.aNc(str)) {
          localArrayList.add(str);
        }
      }
    }
    AppMethodBeat.o(207036);
    return localArrayList;
  }
  
  private void bN(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(63673);
    this.iDN.setVisibility(0);
    this.iDN.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
    this.iDN.setText(paramString1);
    this.iDN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207017);
        com.tencent.mm.wallet_core.ui.e.aT(LaunchAAUI.this.getContext(), paramString2);
        AppMethodBeat.o(207017);
      }
    });
    AppMethodBeat.o(63673);
  }
  
  private void fi(boolean paramBoolean)
  {
    AppMethodBeat.i(63679);
    this.iDL.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.iDs.setTextColor(getResources().getColor(2131099841));
      this.iBN.setTextColor(getResources().getColor(2131099841));
      this.iDt.setTextColor(getResources().getColor(2131099841));
      AppMethodBeat.o(63679);
      return;
    }
    this.iDs.setTextColor(getResources().getColor(2131100711));
    this.iBN.setTextColor(getResources().getColor(2131100711));
    this.iDt.setTextColor(getResources().getColor(2131100711));
    AppMethodBeat.o(63679);
  }
  
  public static aw getKV()
  {
    AppMethodBeat.i(210289);
    aw localaw = aw.aKT("aa_pay");
    AppMethodBeat.o(210289);
    return localaw;
  }
  
  private void t(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63672);
    ac.i("MicroMsg.Aa.LaunchAAUI", "go to contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("Select_block_List", u.axw());
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
      ac.i("MicroMsg.Aa.LaunchAAUI", "gotoSelectContactUI %s", new Object[] { ((StringBuilder)localObject).toString() });
      localIntent.putExtra("recent_remittance_contact_list", ((StringBuilder)localObject).toString());
    }
    if (this.mode == com.tencent.mm.plugin.aa.model.a.iyN)
    {
      paramArrayList = new StringBuilder();
      localObject = this.iDE.iterator();
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
      if (aOn()) {
        localIntent.putExtra("key_title", this.iDr.getText().toString());
      }
      com.tencent.mm.br.d.b(getContext(), "remittance", ".ui.SelectRemittanceContactUI", localIntent, 320);
      qF(10);
      AppMethodBeat.o(63672);
      return;
      paramArrayList = new StringBuilder();
      localObject = this.iDJ.keySet().iterator();
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
      ac.e("MicroMsg.Aa.LaunchAAUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    ac.i("MicroMsg.Aa.LaunchAAUI", "onActivityResult requestCode:%s", new Object[] { Integer.valueOf(paramInt1) });
    label223:
    double d;
    if (paramInt1 == 233)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (this.mode == com.tencent.mm.plugin.aa.model.a.iyN)
        {
          if (!bs.isNullOrNil(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.iDE.clear();
            this.iDE.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = com.tencent.mm.plugin.aa.model.i.FO(this.chatroomName);
          if ((paramIntent == null) || (this.iDE == null) || (this.iDE.size() != paramIntent.size()) || (!w.sQ(this.chatroomName))) {
            break label317;
          }
          paramIntent = this.iDB;
          if (this.iDE != null)
          {
            paramInt1 = this.iDE.size();
            paramIntent.setText(getString(2131760634, new Object[] { Integer.valueOf(paramInt1) }));
          }
        }
        else
        {
          aOu();
          if ((this.iDE == null) || (this.iDE.size() <= com.tencent.mm.plugin.aa.model.e.aNR())) {
            break label369;
          }
          this.iDq = true;
          d = bs.getDouble(this.iDz.getText(), 0.0D);
          if ((this.iDE == null) || (d * 100.0D / this.iDE.size() <= com.tencent.mm.plugin.aa.model.e.aNS())) {
            break label377;
          }
          this.iCX = true;
          com.tencent.mm.plugin.report.service.h.wUl.f(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          aOv();
          aOw();
          aOx();
          AppMethodBeat.o(63690);
          return;
          paramInt1 = 0;
          break;
          label317:
          paramIntent = this.iDB;
          if (this.iDE != null) {}
          for (paramInt1 = this.iDE.size();; paramInt1 = 0)
          {
            paramIntent.setText(getString(2131760639, new Object[] { Integer.valueOf(paramInt1) }));
            break;
          }
          label369:
          this.iDq = false;
          break label223;
          label377:
          this.iCX = false;
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
            this.iDJ.clear();
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext())
              {
                localObject = ((String)paramIntent.next()).split(",");
                d = bs.getDouble(localObject[1], 0.0D);
                this.iDJ.put(localObject[0], Double.valueOf(d));
              }
            }
            aOr();
          }
          catch (Exception paramIntent)
          {
            ac.e("MicroMsg.Aa.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[] { paramIntent.getMessage() });
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
            paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.awL());
            if (bs.isNullOrNil(paramIntent)) {}
          }
          for (this.imagePath = paramIntent;; this.imagePath = ((String)((ArrayList)localObject).get(0)))
          {
            if (!bs.isNullOrNil(this.imagePath))
            {
              this.iBA = 2;
              this.iDw.setVisibility(0);
              this.iDv.setVisibility(8);
              paramIntent = MMBitmapFactory.decodeFile(this.imagePath);
              this.iDw.setImageBitmap(paramIntent);
              qF(8);
            }
            ac.i("MicroMsg.Aa.LaunchAAUI", "SELECT_IMAGE_REQUEST_CODE imagePath:%s", new Object[] { this.imagePath });
            AppMethodBeat.o(63690);
            return;
          }
        }
      }
      else if ((paramInt1 == 310) && (paramInt2 == -1))
      {
        this.iBA = 2;
        this.imagePath = "";
        this.iDw.setVisibility(8);
        this.iDv.setVisibility(0);
        qF(7);
      }
    }
    AppMethodBeat.o(63690);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(63669);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.Aa.LaunchAAUI", "LaunchAAUI onCreate");
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
    label246:
    int i;
    if (aOn())
    {
      this.iDV = ((NetSceneNewAAQueryPFInfo.PfInfoParcel)getIntent().getParcelableExtra("pfInfo"));
      this.iCE = getIntent().getStringExtra("pfOrderNo");
      if (this.iDV == null)
      {
        ac.e("MicroMsg.Aa.LaunchAAUI", "pfInfoParcel is null!!!");
        finish();
        AppMethodBeat.o(63669);
        return;
      }
      this.mode = com.tencent.mm.plugin.aa.model.a.iyO;
      this.iDT = this.iDV.dBN;
      this.iDU = this.iDV.iAC;
      qF(1);
      if (!aOn()) {
        break label1583;
      }
      this.iDO = new com.tencent.mm.plugin.aa.model.e(this.iDV.iAF.iAy, this.iDV.iAF.iAx);
      if ((!bs.isNullOrNil(this.iDO.izA)) && (!bs.isNullOrNil(this.iDO.izz))) {
        bN(this.iDO.izA, this.iDO.izz);
      }
      this.chatroomName = getIntent().getStringExtra("chatroom_name");
      if (bs.isNullOrNil(this.chatroomName))
      {
        ac.e("MicroMsg.Aa.LaunchAAUI", "chatroomName is null!!!");
        this.chatroomName = "";
      }
      paramBundle = this.chatroomName;
      if (bs.isNullOrNil(paramBundle)) {
        break label1678;
      }
      if (!w.sQ(paramBundle)) {
        break label1630;
      }
      label304:
      this.chatroomName = paramBundle;
      this.iCB = findViewById(2131304241);
      this.iDx = ((TextView)findViewById(2131301326));
      this.iDL = ((Button)findViewById(2131301318));
      this.iDM = ((TextView)findViewById(2131301315));
      this.iDN = ((TextView)findViewById(2131301331));
      this.iDr = ((MMEditText)findViewById(2131301327));
      this.iDs = ((TextView)findViewById(2131301330));
      this.iBN = ((TextView)findViewById(2131301316));
      this.iDt = ((TextView)findViewById(2131301317));
      this.iDu = ((RelativeLayout)findViewById(2131303242));
      this.iDv = ((ImageView)findViewById(2131303325));
      this.iDw = ((ImageView)findViewById(2131298760));
      this.iDy = ((TextView)findViewById(2131296289));
      this.iDz = ((WalletFormView)findViewById(2131301329));
      this.iDB = ((TextView)findViewById(2131301319));
      this.iDA = ((TextView)findViewById(2131301320));
      this.iDC = ((ViewGroup)findViewById(2131301334));
      this.iDD = ((ViewGroup)findViewById(2131301333));
      this.iDH = ((TextView)findViewById(2131301324));
      this.iDH.setText(2131760650);
      this.iDH.setTextColor(getResources().getColor(2131099840));
      this.iDF = ((ViewGroup)findViewById(2131301335));
      this.iDG = ((ViewGroup)findViewById(2131301336));
      this.iDI = ((ViewGroup)findViewById(2131301323));
      this.iCB.setOnTouchListener(new View.OnTouchListener()
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
      this.iDx.setClickable(true);
      this.iDx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      if (this.mode != com.tencent.mm.plugin.aa.model.a.iyN) {
        break label1684;
      }
      this.iDC.setVisibility(0);
      this.iDD.setVisibility(0);
      this.iDF.setVisibility(8);
      this.iDs.setText(2131760638);
      this.iDq = false;
      if (this.iDE.size() > com.tencent.mm.plugin.aa.model.e.aNR()) {
        this.iDq = true;
      }
      aOx();
      label753:
      aOs();
      Object localObject;
      if (aOn()) {
        try
        {
          paramBundle = this.iDV.iAA;
          this.iDJ.clear();
          if ((paramBundle == null) || (paramBundle.size() <= 0)) {
            break label1813;
          }
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            localObject = (NetSceneNewAAQueryPFInfo.AALaunchItemParcel)paramBundle.next();
            this.iDJ.put(((NetSceneNewAAQueryPFInfo.AALaunchItemParcel)localObject).username, Double.valueOf(((NetSceneNewAAQueryPFInfo.AALaunchItemParcel)localObject).dBN / 100.0D));
          }
          this.iDL.setOnClickListener(new View.OnClickListener()
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
          ac.e("MicroMsg.Aa.LaunchAAUI", "initPersonLaunchView error:%s %s", new Object[] { paramBundle.getClass().getSimpleName(), paramBundle.getMessage() });
        }
      }
      label876:
      this.iDy.setClickable(true);
      this.iDy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
      paramBundle = new SpannableString(getString(2131757336));
      paramBundle.setSpan(new a(new a.a()
      {
        public final void aOb()
        {
          AppMethodBeat.i(63663);
          Object localObject = new Intent(LaunchAAUI.this, AAQueryListUI.class);
          LaunchAAUI localLaunchAAUI = LaunchAAUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLaunchAAUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (LaunchAAUI.c(LaunchAAUI.this) == com.tencent.mm.plugin.aa.model.a.iyN)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            AppMethodBeat.o(63663);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
          AppMethodBeat.o(63663);
        }
      }), 0, paramBundle.length(), 18);
      this.iDy.setText(paramBundle);
      this.iDy.setVisibility(8);
      this.iDr.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63664);
          LaunchAAUI.d(LaunchAAUI.this);
          LaunchAAUI.this.qF(6);
          AppMethodBeat.o(63664);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.iDr.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(63665);
          LaunchAAUI.a(LaunchAAUI.this).setCursorVisible(true);
          AppMethodBeat.o(63665);
          return false;
        }
      });
      aOt();
      this.iDI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63666);
          LaunchAAUI.e(LaunchAAUI.this);
          AppMethodBeat.o(63666);
        }
      });
      if (!bs.isNullOrNil(this.iDU))
      {
        ac.i("MicroMsg.Aa.LaunchAAUI", "default title: %s", new Object[] { this.iDU });
        this.iDr.setText(this.iDU);
        if (this.iDU.length() <= 20) {
          break label1820;
        }
        i = 20;
        label1076:
        this.iDr.setSelection(i);
      }
      if (!aOn()) {
        break label1831;
      }
      paramBundle = String.format("%.2f", new Object[] { Double.valueOf(this.iDT / 100.0D) });
      this.iDz.setText(paramBundle);
      this.iDz.setSelection(paramBundle.length());
      label1136:
      aOv();
      if ((aOn()) && (aw.aKT("aa_pay").getBoolean("new_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        localObject = getLayoutInflater().inflate(2131492884, null);
        ((View)localObject).findViewById(2131300870).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(63631);
            LaunchAAUI.getKV().edit().putBoolean("new_user_guide_show", false);
            paramBundle.bmi();
            LaunchAAUI.this.qF(2);
            AppMethodBeat.o(63631);
          }
        });
        paramBundle.ISu = new LaunchAAUI.5(this, paramBundle, (View)localObject);
        paramBundle.fvq();
        paramBundle.cED();
      }
      if ((w.wr(this.chatroomName)) && (aw.aKT("aa_pay").getBoolean("new_open_IM_user_guide_show", true)))
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
            LaunchAAUI.getKV().edit().putBoolean("new_open_IM_user_guide_show", false);
            paramBundle.bmi();
            AppMethodBeat.o(63633);
          }
        });
        paramBundle.ISu = new LaunchAAUI.7(this, paramBundle, (View)localObject);
        paramBundle.fvq();
        paramBundle.cED();
      }
      if (aOn())
      {
        this.iDu.setVisibility(0);
        this.iDu.setOnClickListener(new LaunchAAUI.8(this));
        this.iDw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(207012);
            if (LaunchAAUI.i(LaunchAAUI.this) == null) {
              LaunchAAUI.a(LaunchAAUI.this, com.tencent.mm.ui.base.h.a(LaunchAAUI.this, 3, 2131820985, LaunchAAUI.this.getString(2131760709), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(207010);
                  if ((LaunchAAUI.i(LaunchAAUI.this) != null) && (LaunchAAUI.i(LaunchAAUI.this).isShowing())) {
                    LaunchAAUI.i(LaunchAAUI.this).dismiss();
                  }
                  AppMethodBeat.o(207010);
                }
              }));
            }
            o.aFA().a(LaunchAAUI.j(LaunchAAUI.this), new p.a()
            {
              public final void a(String paramAnonymous2String1, Bitmap paramAnonymous2Bitmap, String paramAnonymous2String2)
              {
                AppMethodBeat.i(207011);
                ac.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous2String1, paramAnonymous2String2 });
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
                  paramAnonymous2String1.putExtra("view_info", ViewAnimHelper.n(LaunchAAUI.m(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
                  com.tencent.mm.br.d.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous2String1, 310);
                  LaunchAAUI.this.qF(14);
                  AppMethodBeat.o(207011);
                  return;
                }
                Toast.makeText(LaunchAAUI.this, 2131755038, 1).show();
                AppMethodBeat.o(207011);
              }
            });
            AppMethodBeat.o(207012);
          }
        });
        if ((this.iDV == null) || (bs.isNullOrNil(this.iDV.iAB))) {
          break label1923;
        }
        this.iBA = 1;
        this.hgd = this.iDV.iAB;
        this.iDw.setVisibility(0);
        this.iDv.setVisibility(8);
        o.aFA().a(this.iDV.iAB, this.iDV.iAE, new p.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            boolean bool = false;
            AppMethodBeat.i(207014);
            if (paramAnonymousBitmap == null) {
              bool = true;
            }
            ac.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s bitmap==null:%s path:%s", new Object[] { paramAnonymousString1, Boolean.valueOf(bool), paramAnonymousString2 });
            LaunchAAUI.a(LaunchAAUI.this, paramAnonymousString2);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(207013);
                if (paramAnonymousBitmap != null)
                {
                  LaunchAAUI.m(LaunchAAUI.this).setImageBitmap(paramAnonymousBitmap);
                  AppMethodBeat.o(207013);
                  return;
                }
                LaunchAAUI.n(LaunchAAUI.this);
                LaunchAAUI.m(LaunchAAUI.this).setVisibility(8);
                LaunchAAUI.o(LaunchAAUI.this).setVisibility(0);
                AppMethodBeat.o(207013);
              }
            });
            AppMethodBeat.o(207014);
          }
        });
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      if ((aOn()) && (this.iDX != null)) {
        this.iDX.alive();
      }
      AppMethodBeat.o(63669);
      return;
      this.mode = com.tencent.mm.plugin.aa.model.a.iyN;
      this.iDS = getIntent().getStringExtra("amount");
      this.iDU = getIntent().getStringExtra("title");
      break;
      label1583:
      paramBundle = this.iDp.iBd;
      com.tencent.mm.vending.g.g.fxs().c(paramBundle).f(new com.tencent.mm.vending.c.a() {}).a(new LaunchAAUI.11(this));
      break label246;
      label1630:
      paramBundle = bs.S(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(u.axw());
        if (paramBundle.size() > 0)
        {
          paramBundle = (String)paramBundle.get(0);
          break label304;
        }
      }
      label1678:
      paramBundle = "";
      break label304;
      label1684:
      if (this.mode != com.tencent.mm.plugin.aa.model.a.iyO) {
        break label753;
      }
      this.iDC.setVisibility(8);
      this.iDD.setVisibility(8);
      this.iDF.setVisibility(0);
      this.iDs.setText(getString(2131760649, new Object[] { Integer.valueOf(0) }));
      if ((this.iDJ != null) && (this.iDJ.size() > com.tencent.mm.plugin.aa.model.e.aNQ())) {
        this.iDq = true;
      }
      if (this.iDq)
      {
        FS(getString(2131760646, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.aNQ()) }));
        break label753;
      }
      aOu();
      break label753;
      label1813:
      aOr();
      break label876;
      label1820:
      i = this.iDU.length();
      break label1076;
      label1831:
      if (bs.isNullOrNil(this.iDS)) {
        break label1136;
      }
      ac.i("MicroMsg.Aa.LaunchAAUI", "default amount: %s", new Object[] { this.iDS });
      paramBundle = com.tencent.mm.wallet_core.ui.e.b(new StringBuilder().append(this.iDS).toString(), "100", RoundingMode.HALF_UP);
      this.iDz.setText(paramBundle);
      this.iDz.setSelection(paramBundle.length());
      break label1136;
      label1923:
      this.iBA = 2;
      this.imagePath = "";
      this.iDw.setVisibility(8);
      this.iDv.setVisibility(0);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63687);
    super.onDestroy();
    if ((aOn()) && (this.iDX != null)) {
      this.iDX.dead();
    }
    AppMethodBeat.o(63687);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(63686);
    super.onStop();
    if (this.iDK != null) {
      this.iDK.clear();
    }
    AppMethodBeat.o(63686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qF(int paramInt)
  {
    AppMethodBeat.i(63691);
    if (aOn()) {
      com.tencent.mm.plugin.aa.model.i.qF(paramInt);
    }
    AppMethodBeat.o(63691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */