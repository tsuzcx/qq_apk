package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.f.a.mh;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.b.e.b;
import com.tencent.mm.plugin.aa.model.b.e.c;
import com.tencent.mm.plugin.aa.model.b.e.d;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AALaunchItemParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AAOperationInfoParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.PfInfoParcel;
import com.tencent.mm.plugin.aa.model.l;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.u;
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
  implements com.tencent.mm.ui.tools.h
{
  private String chatroomName;
  private String imagePath;
  private String imageUrl;
  private int jSt;
  private com.tencent.mm.ui.tools.i jij;
  private int mLO;
  private Dialog mLP;
  private TextView mMc;
  private Dialog mMi;
  private boolean mNR;
  private String mNy;
  private WalletFormView mOA;
  private TextView mOB;
  private TextView mOC;
  private ViewGroup mOD;
  private ViewGroup mOE;
  private List<String> mOF;
  private ViewGroup mOG;
  private ViewGroup mOH;
  private ViewGroup mOI;
  private ViewGroup mOJ;
  private ViewGroup mOK;
  private TextView mOL;
  private TextView mOM;
  private ViewGroup mON;
  private Map<String, Double> mOO;
  private Map<String, LaunchAAByPersonNameAmountRow> mOP;
  private Button mOQ;
  private TextView mOR;
  private TextView mOS;
  private com.tencent.mm.plugin.aa.model.e mOT;
  private int mOU;
  private int mOV;
  private boolean mOW;
  private String mOX;
  private long mOY;
  private String mOZ;
  private com.tencent.mm.plugin.aa.model.b.e mOj;
  private int mOk;
  private boolean mOl;
  private MMEditText mOm;
  private TextView mOn;
  private TextView mOo;
  private TextView mOp;
  private LinearLayout mOq;
  private ImageView mOr;
  private RelativeLayout mOs;
  private LinearLayout mOt;
  private ImageView mOu;
  private TextView mOv;
  private ImageView mOw;
  private TextView mOx;
  private TextView mOy;
  private ViewGroup mOz;
  private NetSceneNewAAQueryPFInfo.PfInfoParcel mPa;
  private boolean mPb;
  private IListener<mh> mPc;
  private int mPd;
  private ScrollView mPe;
  private View mPf;
  private int mode;
  private int scene;
  private long timestamp;
  private Dialog tipDialog;
  
  public LaunchAAUI()
  {
    AppMethodBeat.i(63668);
    this.mOj = ((com.tencent.mm.plugin.aa.model.b.e)ap(com.tencent.mm.plugin.aa.model.b.e.class));
    this.mode = com.tencent.mm.plugin.aa.model.a.mIW;
    this.mOk = 4;
    this.chatroomName = null;
    this.mOl = false;
    this.mNR = false;
    this.mOF = new ArrayList();
    this.mOO = new HashMap();
    this.mOP = new HashMap();
    this.mOT = new com.tencent.mm.plugin.aa.model.e();
    this.mOU = 0;
    this.mOV = 0;
    this.mOW = false;
    this.timestamp = 0L;
    this.imageUrl = "";
    this.mPa = null;
    this.mPb = false;
    this.mLP = null;
    this.mPc = new LaunchAAUI.1(this);
    this.jSt = 0;
    this.mPd = 0;
    AppMethodBeat.o(63668);
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
    localHashMap.put(l.mJW, paramString2);
    localHashMap.put(l.mJX, Double.valueOf(100.0D * paramDouble));
    localHashMap.put(l.mKa, paramString1);
    localHashMap.put(l.mKd, Long.valueOf(this.timestamp));
    long l = com.tencent.mm.wallet_core.ui.g.a(com.tencent.mm.plugin.aa.model.i.cd(new StringBuilder().append(paramDouble).toString(), "100"), String.valueOf(paramInt), RoundingMode.CEILING);
    Log.d("MicroMsg.Aa.LaunchAAUI", "perAmount: %s", new Object[] { Long.valueOf(l) });
    if ((l <= 0L) || (l > com.tencent.mm.plugin.aa.model.e.bwp()))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "illegal avgAmount: %s", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(63684);
      return;
    }
    localHashMap.put(l.mJZ, Long.valueOf(l));
    localHashMap.put(l.mKe, paramString3);
    localHashMap.put(l.mKf, paramString4);
    if (!Util.isNullOrNil(this.imagePath))
    {
      paramString2 = com.tencent.mm.b.g.getMD5(this.imagePath);
      localHashMap.put(l.mKh, paramString2);
    }
    if (bwM()) {
      localHashMap.put(l.mKg, this.mNy);
    }
    localHashMap.put(l.mKc, paramList);
    this.mOj.mLn.d(this.mode, localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void cm(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(273790);
        Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        if (LaunchAAUI.I(LaunchAAUI.this) != null) {
          LaunchAAUI.I(LaunchAAUI.this).dismiss();
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
          com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(a.i.launch_aa_i_know), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(232103);
              Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
              AppMethodBeat.o(232103);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(273790);
          return;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ac)))
          {
            com.tencent.mm.plugin.aa.model.i.a(LaunchAAUI.this.getContext(), (ac)paramAnonymousObject);
          }
          else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
          {
            paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
            String str1 = paramAnonymousObject.wording;
            String str2 = paramAnonymousObject.oDJ;
            String str3 = paramAnonymousObject.oDK;
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
            locala.bBd(str1);
            locala.bBj(str3).c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(275996);
                com.tencent.mm.wallet_core.ui.g.p(LaunchAAUI.this.getContext(), paramAnonymousObject.tVu, false);
                AppMethodBeat.o(275996);
              }
            });
            locala.bBk(str2);
            locala.icu().show();
          }
          else
          {
            Toast.makeText(paramContext, a.i.launch_aa_failed, 1).show();
          }
        }
      }
    });
    AppMethodBeat.o(63684);
  }
  
  private void a(final Context paramContext, final String paramString1, String paramString2, String paramString3, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(63685);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.b.class)).ij(7, 5);
    com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.mOm.getText().toString();
        if (Util.isNullOrNil(str1))
        {
          str1 = getString(a.i.launch_aa_des_default_title);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator = this.mOO.keySet().iterator();
          long l1 = 0L;
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if ((!paramBoolean) || (paramList.contains(str2)))
            {
              double d = ((Double)this.mOO.get(str2)).doubleValue();
              m localm = new m();
              localm.gbJ = com.tencent.mm.wallet_core.ui.g.oA(String.valueOf(d), "100");
              localm.username = str2;
              localArrayList1.add(localm);
              long l2 = localm.gbJ;
              localArrayList2.add(localm.gbJ);
              l1 = l2 + l1;
            }
          }
          else
          {
            paramList = new m();
            paramList.username = z.bcZ();
            paramList.gbJ = l1;
            localHashMap.put(l.mJW, str1);
            localHashMap.put(l.mJX, Long.valueOf(l1));
            localHashMap.put(l.mKc, localArrayList1);
            localHashMap.put(l.mKa, paramString1);
            localHashMap.put(l.mKd, Long.valueOf(this.timestamp));
            localHashMap.put(l.mKe, paramString2);
            localHashMap.put(l.mKf, paramString3);
            if (!Util.isNullOrNil(this.imagePath))
            {
              paramString2 = com.tencent.mm.b.g.getMD5(this.imagePath);
              localHashMap.put(l.mKh, paramString2);
            }
            if (bwM()) {
              localHashMap.put(l.mKg, this.mNy);
            }
            this.mOj.mLo.A(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
            {
              public final void cm(final Object paramAnonymousObject)
              {
                AppMethodBeat.i(276639);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
                if (LaunchAAUI.I(LaunchAAUI.this) != null) {
                  LaunchAAUI.I(LaunchAAUI.this).dismiss();
                }
                if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
                  com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(a.i.launch_aa_i_know), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(201102);
                      Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                      AppMethodBeat.o(201102);
                    }
                  });
                }
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(10) });
                  AppMethodBeat.o(276639);
                  return;
                  if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ac)))
                  {
                    com.tencent.mm.plugin.aa.model.i.a(LaunchAAUI.this.getContext(), (ac)paramAnonymousObject);
                  }
                  else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
                  {
                    paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
                    String str1 = paramAnonymousObject.wording;
                    String str2 = paramAnonymousObject.oDJ;
                    String str3 = paramAnonymousObject.oDK;
                    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
                    locala.bBd(str1);
                    locala.bBj(str3).c(new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(212554);
                        com.tencent.mm.wallet_core.ui.g.p(LaunchAAUI.this.getContext(), paramAnonymousObject.tVu, false);
                        AppMethodBeat.o(212554);
                      }
                    });
                    locala.bBk(str2);
                    locala.icu().show();
                  }
                  else
                  {
                    Toast.makeText(paramContext, a.i.launch_aa_failed, 1).show();
                  }
                }
              }
            });
            com.tencent.mm.plugin.report.service.h.IzE.a(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.aa.model.i.aag(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, Util.listToString(localArrayList2, ",") });
            AppMethodBeat.o(63685);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPerson error: %s", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(63685);
        return;
      }
    }
  }
  
  private void a(final Context paramContext, final String paramString, final boolean paramBoolean, final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63682);
    yd(9);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.mIW)
    {
      if (Util.isNullOrNil(this.mOA.getText()))
      {
        AppMethodBeat.o(63682);
        return;
      }
      if ((this.mOF == null) || (this.mOF.size() == 0))
      {
        AppMethodBeat.o(63682);
        return;
      }
      bwX();
      com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
      if ((paramBoolean) && (paramArrayList == null)) {}
    }
    for (;;)
    {
      try
      {
        i = paramArrayList.size();
        final double d = Util.getDouble(this.mMc.getText().toString(), 0.0D) * i;
        String str2 = this.mOm.getText().toString();
        final String str1 = str2;
        if (Util.isNullOrNil(str2)) {
          str1 = getString(a.i.launch_aa_des_default_title);
        }
        if (i > 0)
        {
          if (this.mMi != null) {
            this.mMi.dismiss();
          }
          this.mMi = com.tencent.mm.wallet_core.ui.i.c(paramContext, false, null);
          if (!Util.isNullOrNil(this.imagePath)) {
            new com.tencent.mm.plugin.aa.model.d(this.imagePath, new com.tencent.mm.plugin.aa.model.d.a()
            {
              public final void bwm()
              {
                AppMethodBeat.i(277367);
                Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(274838);
                    if (LaunchAAUI.I(LaunchAAUI.this) != null) {
                      LaunchAAUI.I(LaunchAAUI.this).dismiss();
                    }
                    Toast.makeText(LaunchAAUI.24.this.val$context, a.i.launch_aa_failed, 1).show();
                    AppMethodBeat.o(274838);
                  }
                });
                AppMethodBeat.o(277367);
              }
              
              public final void ca(final String paramAnonymousString1, final String paramAnonymousString2)
              {
                AppMethodBeat.i(277366);
                Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(270137);
                    if (LaunchAAUI.24.this.mPn)
                    {
                      LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.24.this.val$context, LaunchAAUI.24.this.iXG, LaunchAAUI.24.this.mPo, LaunchAAUI.24.this.mPp, LaunchAAUI.24.this.mPq, LaunchAAUI.24.this.mPh, paramAnonymousString1, paramAnonymousString2);
                      AppMethodBeat.o(270137);
                      return;
                    }
                    LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.24.this.val$context, LaunchAAUI.24.this.iXG, LaunchAAUI.24.this.mPo, LaunchAAUI.24.this.mPp, LaunchAAUI.24.this.mPq, LaunchAAUI.F(LaunchAAUI.this), paramAnonymousString1, paramAnonymousString2);
                    AppMethodBeat.o(270137);
                  }
                });
                AppMethodBeat.o(277366);
              }
            }).bwl();
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13723, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.aa.model.i.aag(this.chatroomName), Integer.valueOf(i), Double.valueOf(100.0D * d), str1 });
          AppMethodBeat.o(63682);
          return;
          i = 0;
          continue;
          if (this.mOF == null) {
            break label598;
          }
          i = this.mOF.size();
          d = Util.getDouble(this.mOA.getText(), 0.0D);
          continue;
        }
        if (paramBoolean)
        {
          a(paramContext, paramString, i, str1, d, paramArrayList);
          continue;
        }
        a(paramContext, paramString, i, str1, d, this.mOF);
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[] { Integer.valueOf(this.mode), paramContext.getMessage() });
        AppMethodBeat.o(63682);
        return;
      }
      continue;
      bwX();
      if (this.mMi != null) {
        this.mMi.dismiss();
      }
      this.mMi = com.tencent.mm.wallet_core.ui.i.c(paramContext, false, null);
      if (!Util.isNullOrNil(this.imagePath))
      {
        if ((this.mLO == 2) && (aan(this.imagePath)) && (u.agG(bxd())))
        {
          Log.i("MicroMsg.Aa.LaunchAAUI", "set local imagePath :%s", new Object[] { bxd() });
          this.imagePath = bxd();
        }
        new com.tencent.mm.plugin.aa.model.d(this.imagePath, new com.tencent.mm.plugin.aa.model.d.a()
        {
          public final void bwm()
          {
            AppMethodBeat.i(268011);
            Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(63649);
                if (LaunchAAUI.I(LaunchAAUI.this) != null) {
                  LaunchAAUI.I(LaunchAAUI.this).dismiss();
                }
                Toast.makeText(LaunchAAUI.25.this.val$context, a.i.launch_aa_failed, 1).show();
                AppMethodBeat.o(63649);
              }
            });
            AppMethodBeat.o(268011);
          }
          
          public final void ca(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            AppMethodBeat.i(268010);
            Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(63648);
                if (u.agG(LaunchAAUI.this.bxd()))
                {
                  Log.i("MicroMsg.Aa.LaunchAAUI", " upload success , delete file");
                  u.deleteFile(LaunchAAUI.this.bxd());
                }
                if (LaunchAAUI.c(LaunchAAUI.this) == 4)
                {
                  LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.25.this.val$context, LaunchAAUI.25.this.iXG, paramAnonymousString1, paramAnonymousString2);
                  AppMethodBeat.o(63648);
                  return;
                }
                LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.25.this.val$context, LaunchAAUI.25.this.iXG, paramAnonymousString1, paramAnonymousString2, LaunchAAUI.25.this.mPn, LaunchAAUI.25.this.mPh);
                AppMethodBeat.o(63648);
              }
            });
            AppMethodBeat.o(268010);
          }
        }).bwl();
        AppMethodBeat.o(63682);
        return;
      }
      if (this.mOk == 4)
      {
        b(paramContext, paramString, "", "");
        AppMethodBeat.o(63682);
        return;
      }
      a(paramContext, paramString, "", "", paramBoolean, paramArrayList);
      AppMethodBeat.o(63682);
      return;
      label598:
      final int i = 0;
    }
  }
  
  private static boolean aQ(List<String> paramList)
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
    } while (!Util.isEqual((String)paramList.next(), z.bcZ()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(63694);
      return bool;
    }
  }
  
  private void aak(String paramString)
  {
    AppMethodBeat.i(63676);
    this.mOW = true;
    this.mOR.setVisibility(0);
    this.mOR.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.in_from_up));
    this.mOR.setText(paramString);
    AppMethodBeat.o(63676);
  }
  
  private void aal(final String paramString)
  {
    AppMethodBeat.i(63681);
    Log.i("MicroMsg.Aa.LaunchAAUI", "showLaunchComfirmDialog() from scene:%s", new Object[] { Integer.valueOf(this.scene) });
    String str = this.mOm.getText().toString();
    if (Util.isNullOrNil(str)) {
      str = getString(a.i.launch_aa_des_default_title);
    }
    for (;;)
    {
      ((j)com.tencent.mm.kernel.h.ae(j.class)).a(getController(), paramString, getString(a.i.aa_dialog_sub_title) + str, getString(a.i.aa_dialog_ok_text), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(189715);
          if (paramAnonymousBoolean)
          {
            Log.i("MicroMsg.Aa.LaunchAAUI", "click launchDialog confirm，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.b(LaunchAAUI.this)), Integer.valueOf(LaunchAAUI.c(LaunchAAUI.this)) });
            LaunchAAUI.b(LaunchAAUI.this, paramString);
            LaunchAAUI.this.yd(12);
            com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(4) });
            AppMethodBeat.o(189715);
            return;
          }
          Log.i("MicroMsg.Aa.LaunchAAUI", "click launchDialog cancel，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.b(LaunchAAUI.this)), Integer.valueOf(LaunchAAUI.c(LaunchAAUI.this)) });
          LaunchAAUI.this.yd(13);
          AppMethodBeat.o(189715);
        }
      });
      yd(11);
      com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(3) });
      AppMethodBeat.o(63681);
      return;
    }
  }
  
  public static boolean aam(String paramString)
  {
    AppMethodBeat.i(63693);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63693);
      return false;
    }
    boolean bool = aQ(com.tencent.mm.plugin.aa.model.i.aag(paramString));
    AppMethodBeat.o(63693);
    return bool;
  }
  
  private boolean aan(String paramString)
  {
    AppMethodBeat.i(266626);
    try
    {
      BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
      localOptions1.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(paramString, localOptions1);
      BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
      Log.i("MicroMsg.Aa.LaunchAAUI", "bitmap width： %s , height： %s", new Object[] { Integer.valueOf(localOptions1.outWidth), Integer.valueOf(localOptions1.outHeight) });
      if ((localOptions1.outWidth <= 4) || (localOptions1.outHeight <= 4))
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "dont handle：sizeOption.outWidth <= MIN_IMAGE_SIZE || sizeOption.outHeight <= MIN_IMAGE_SIZE");
        AppMethodBeat.o(266626);
        return false;
      }
      if (localOptions1.outWidth * localOptions1.outHeight < 5242880)
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "dont handle：sizeOption.outWidth * sizeOption.outHeight * 2 < MAX_BITMAP_SIZE");
        AppMethodBeat.o(266626);
        return false;
      }
      int i = localOptions1.outWidth * localOptions1.outHeight / 5242880;
      localOptions2.inSampleSize = i;
      Log.i("MicroMsg.Aa.LaunchAAUI", "need handle：bitmap too large sample:%s", new Object[] { Integer.valueOf(i) });
      paramString = BitmapUtil.rotate(BitmapUtil.decodeFile(paramString, localOptions2), Exif.fromFile(paramString).getOrientationInDegree());
      if (u.agG(bxd())) {
        u.deleteFile(bxd());
      }
      BitmapUtil.saveBitmapToImage(paramString, 80, Bitmap.CompressFormat.JPEG, bxd(), true);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "decode file to bitmap error! " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(266626);
    return true;
  }
  
  private void b(final Context paramContext, final String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(266618);
    Log.i("MicroMsg.Aa.LaunchAAUI", "launchAAByPersonCustomize");
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.b.class)).ij(7, 5);
    com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(2) });
    HashMap localHashMap = new HashMap();
    try
    {
      String str2 = this.mOm.getText().toString();
      String str1 = str2;
      if (Util.isNullOrNil(str2)) {
        str1 = getString(a.i.launch_aa_des_default_title);
      }
      localHashMap.put(l.mJW, str1);
      localHashMap.put(l.mKa, paramString1);
      localHashMap.put(l.mKd, Long.valueOf(this.timestamp));
      localHashMap.put(l.mKe, paramString2);
      localHashMap.put(l.mKf, paramString3);
      if (!Util.isNullOrNil(this.imagePath))
      {
        paramString2 = com.tencent.mm.b.g.getMD5(this.imagePath);
        localHashMap.put(l.mKh, paramString2);
      }
      if (bwM()) {
        localHashMap.put(l.mKg, this.mNy);
      }
      this.mOj.mLp.A(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
      {
        public final void cm(final Object paramAnonymousObject)
        {
          AppMethodBeat.i(268342);
          Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
          if (LaunchAAUI.I(LaunchAAUI.this) != null) {
            LaunchAAUI.I(LaunchAAUI.this).dismiss();
          }
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
            com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(a.i.launch_aa_i_know), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(277575);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                AppMethodBeat.o(277575);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(10) });
            AppMethodBeat.o(268342);
            return;
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ac)))
            {
              com.tencent.mm.plugin.aa.model.i.a(LaunchAAUI.this.getContext(), (ac)paramAnonymousObject);
            }
            else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
            {
              paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
              String str1 = paramAnonymousObject.wording;
              String str2 = paramAnonymousObject.oDJ;
              String str3 = paramAnonymousObject.oDK;
              com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
              locala.bBd(str1);
              locala.bBj(str3).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(266886);
                  com.tencent.mm.wallet_core.ui.g.p(LaunchAAUI.this.getContext(), paramAnonymousObject.tVu, false);
                  AppMethodBeat.o(266886);
                }
              });
              locala.bBk(str2);
              locala.icu().show();
            }
            else
            {
              Toast.makeText(paramContext, a.i.launch_aa_failed, 1).show();
            }
          }
        }
      });
      AppMethodBeat.o(266618);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPersonCustomize error: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(266618);
    }
  }
  
  private boolean bwM()
  {
    return this.scene == 6;
  }
  
  private boolean bwR()
  {
    return this.scene == 5;
  }
  
  private void bwS()
  {
    AppMethodBeat.i(266611);
    if (bwM()) {
      try
      {
        z(this.mPa.mKN);
        bwT();
        AppMethodBeat.o(266611);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "initPersonLaunchView error:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(266611);
  }
  
  private void bwT()
  {
    AppMethodBeat.i(63671);
    bxb();
    bwZ();
    bwY();
    AppMethodBeat.o(63671);
  }
  
  private void bwU()
  {
    AppMethodBeat.i(63674);
    String str;
    if (this.mode == com.tencent.mm.plugin.aa.model.a.mIX) {
      if (this.mOk == 4) {
        str = getString(a.i.launch_aa_select_aa_by_person_member_title);
      }
    }
    for (;;)
    {
      ar.a(this.mOx.getPaint(), 0.8F);
      this.mOx.setText(str);
      str = getString(a.i.launch_aa_select_accessibility_mode) + this.mOx.getText();
      this.mOx.setContentDescription(str);
      this.mOq.setContentDescription(str);
      this.mOq.setClickable(true);
      this.mOq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276106);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.Aa.LaunchAAUI", "click switch button");
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          LaunchAAUI.A(LaunchAAUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276106);
        }
      });
      this.mOq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(251002);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)LaunchAAUI.B(LaunchAAUI.this).getLayoutParams();
          localLayoutParams.width = (LaunchAAUI.C(LaunchAAUI.this).getWidth() + LaunchAAUI.D(LaunchAAUI.this).getWidth());
          localLayoutParams.height = LaunchAAUI.C(LaunchAAUI.this).getHeight();
          LaunchAAUI.B(LaunchAAUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(251002);
        }
      });
      AppMethodBeat.o(63674);
      return;
      str = getString(a.i.launch_aa_select_aa_by_person_lord_title);
      continue;
      str = getString(a.i.launch_aa_select_aa_by_money_title);
    }
  }
  
  private void bwV()
  {
    AppMethodBeat.i(266615);
    Log.i("MicroMsg.Aa.LaunchAAUI", "switchMode");
    this.mOl = false;
    if (this.mode == com.tencent.mm.plugin.aa.model.a.mIX) {
      if (this.mOk == 4)
      {
        this.mOG.setVisibility(8);
        this.mOM.setVisibility(0);
        this.mON.setVisibility(8);
        this.mOI.setVisibility(0);
        List localList = com.tencent.mm.plugin.aa.model.i.aag(this.chatroomName);
        this.mOM.setText(getString(a.i.launch_aa_by_person_select_tips, new Object[] { Integer.valueOf(localList.size()) }));
        this.mOp.setText(a.i.launch_aa_by_person_fill_in_select_member);
        this.mOD.setVisibility(8);
        this.mOE.setVisibility(8);
        this.mOn.setText(getString(a.i.launch_aa_by_person_total_amount_hint, new Object[] { Integer.valueOf(0) }));
        if ((this.mOO != null) && (this.mOO.size() > com.tencent.mm.plugin.aa.model.e.bwn()))
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(8) });
          this.mOl = true;
        }
        if (!this.mOl) {
          break label323;
        }
        aak(getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bwn()) }));
        label242:
        yd(5);
      }
    }
    for (;;)
    {
      hideTenpayKB();
      hideVKB();
      bwU();
      bwZ();
      bwY();
      f(this.mOJ, this.mOK);
      AppMethodBeat.o(266615);
      return;
      this.mOG.setVisibility(0);
      this.mOM.setVisibility(8);
      this.mON.setVisibility(0);
      this.mOI.setVisibility(8);
      break;
      label323:
      bwX();
      break label242;
      this.mode = com.tencent.mm.plugin.aa.model.a.mIW;
      this.mOD.setVisibility(0);
      this.mOE.setVisibility(0);
      this.mOG.setVisibility(8);
      this.mOI.setVisibility(8);
      this.mOM.setVisibility(8);
      this.mOn.setText(a.i.launch_aa_by_money_total_amount_hint);
      f(this.mOJ, this.mOK);
      this.mOl = false;
      if (this.mOF.size() > com.tencent.mm.plugin.aa.model.e.bwo())
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(8) });
        this.mOl = true;
      }
      bxa();
      yd(4);
    }
  }
  
  private void bwW()
  {
    AppMethodBeat.i(63675);
    this.mOA.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(269066);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 3))
        {
          WalletFormView.a(LaunchAAUI.E(LaunchAAUI.this).getContentEt(), str, i + 3, j);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((LaunchAAUI.F(LaunchAAUI.this) == null) || (LaunchAAUI.F(LaunchAAUI.this).size() <= 0)) {
            break label283;
          }
          d = d * 100.0D / LaunchAAUI.F(LaunchAAUI.this).size();
          LaunchAAUI.z(LaunchAAUI.this);
          if (d <= com.tencent.mm.plugin.aa.model.e.bwp()) {
            break label283;
          }
          LaunchAAUI.a(LaunchAAUI.this, true);
          com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          LaunchAAUI.e(LaunchAAUI.this);
          LaunchAAUI.G(LaunchAAUI.this);
          LaunchAAUI.H(LaunchAAUI.this);
          LaunchAAUI.this.yd(3);
          AppMethodBeat.o(269066);
          return;
          if (i > 6)
          {
            WalletFormView.a(LaunchAAUI.E(LaunchAAUI.this).getContentEt(), str, 6, i);
            break;
          }
          if ((i != -1) || (j <= 6)) {
            break;
          }
          WalletFormView.a(LaunchAAUI.E(LaunchAAUI.this).getContentEt(), str, 6, j);
          break;
          label283:
          LaunchAAUI.a(LaunchAAUI.this, false);
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    setEditFocusListener(this.mOA, 2, false, true);
    this.mOA.setmContentAbnormalMoneyCheck(true);
    Object localObject;
    if (bwM())
    {
      localObject = new ArrayList();
      Iterator localIterator = this.mOO.keySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((String)localIterator.next());
      }
      this.mOC.setText(getString(a.i.launch_aa_by_money_usernumber_wording, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      this.mOF = ((List)localObject);
    }
    for (;;)
    {
      this.mOD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(222746);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          LaunchAAUI.a(LaunchAAUI.this, this.iZw);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(222746);
        }
      });
      this.mOl = false;
      AppMethodBeat.o(63675);
      return;
      if (ab.Lj(this.chatroomName)) {
        if (!ab.PR(this.chatroomName)) {
          localObject = com.tencent.mm.plugin.aa.model.i.aag(this.chatroomName);
        }
      }
      for (;;)
      {
        this.mOF = ((List)localObject);
        if (this.mOF.size() <= com.tencent.mm.plugin.aa.model.e.bwo()) {
          break label299;
        }
        this.mOF.clear();
        this.mOC.setText(getString(a.i.paylist_aa_by_money_select_group_memeber));
        bwY();
        break;
        localObject = bxc();
        continue;
        Log.i("MicroMsg.Aa.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
        localObject = new ArrayList();
        ((List)localObject).add(z.bcZ());
        ((List)localObject).add(this.chatroomName);
      }
      label299:
      if (ab.Lj(this.chatroomName))
      {
        if (!ab.PR(this.chatroomName)) {
          this.mOC.setText(getString(a.i.launch_aa_by_money_all_group_member, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        } else {
          this.mOC.setText(getString(a.i.launch_aa_by_money_usernumber_wording, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        }
      }
      else {
        this.mOC.setText(getString(a.i.launch_aa_by_money_usernumber_wording, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      }
    }
  }
  
  private void bwX()
  {
    AppMethodBeat.i(63677);
    this.mOW = false;
    if (this.mOR.getVisibility() != 8)
    {
      this.mOR.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.out_to_up));
      this.mOR.setVisibility(8);
    }
    AppMethodBeat.o(63677);
  }
  
  private void bwY()
  {
    AppMethodBeat.i(63678);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.mIW)
    {
      if (Util.isNullOrNil(this.mOA.getText()))
      {
        gS(false);
        AppMethodBeat.o(63678);
        return;
      }
      if (this.mNR)
      {
        gS(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.mOF == null) || (this.mOF.size() == 0))
      {
        gS(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.mOF.size() > com.tencent.mm.plugin.aa.model.e.bwo()) || (this.mOl))
      {
        gS(false);
        AppMethodBeat.o(63678);
        return;
      }
      double d = com.tencent.mm.plugin.aa.model.i.a(this.mOA.getText(), this.mOF.size(), 5, 4);
      Log.d("MicroMsg.Aa.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.mOA.getText(), Integer.valueOf(this.mOF.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "less than 0.01");
        gS(false);
        AppMethodBeat.o(63678);
      }
    }
    else
    {
      if (this.mOk == 4)
      {
        gS(true);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.mOO == null) || (this.mOO.size() == 0))
      {
        gS(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.mOO.size() > com.tencent.mm.plugin.aa.model.e.bwo()) || (this.mOl))
      {
        gS(false);
        AppMethodBeat.o(63678);
        return;
      }
    }
    gS(true);
    AppMethodBeat.o(63678);
  }
  
  private void bwZ()
  {
    AppMethodBeat.i(63680);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.mIW)
    {
      if ((this.mOF != null) && (this.mOF.size() > 0))
      {
        d = com.tencent.mm.plugin.aa.model.i.a(this.mOA.getText(), this.mOF.size(), 2, 2);
        this.mMc.setText(getString(a.i.aa_amount_format, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.mOn.setText(a.i.launch_aa_by_money_total_amount_hint);
        this.mMc.setVisibility(0);
        this.mOo.setVisibility(0);
        this.mOn.setVisibility(0);
        AppMethodBeat.o(63680);
        return;
        this.mMc.setText(getString(a.i.aa_amount_zero));
      }
    }
    if (this.mOk == 4)
    {
      this.mMc.setVisibility(4);
      this.mOo.setVisibility(4);
      this.mOn.setVisibility(4);
      AppMethodBeat.o(63680);
      return;
    }
    if ((this.mOO == null) || (this.mOO.size() == 0))
    {
      this.mOn.setText(getString(a.i.launch_aa_by_person_total_amount_hint, new Object[] { Integer.valueOf(0) }));
      this.mMc.setText(getString(a.i.aa_amount_zero));
      this.mMc.setVisibility(0);
      this.mOo.setVisibility(0);
      this.mOn.setVisibility(0);
      AppMethodBeat.o(63680);
      return;
    }
    Iterator localIterator = this.mOO.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.mMc.setText(getString(a.i.aa_amount_format, new Object[] { Double.valueOf(d) }));
    this.mOn.setText(getString(a.i.launch_aa_by_person_total_amount_hint, new Object[] { Integer.valueOf(this.mOO.size()) }));
    this.mOJ.setVisibility(0);
    this.mMc.setVisibility(0);
    this.mOo.setVisibility(0);
    this.mOn.setVisibility(0);
    AppMethodBeat.o(63680);
  }
  
  private void bxa()
  {
    AppMethodBeat.i(63688);
    if ((this.mOl) && (!this.mOW))
    {
      if (this.mode == com.tencent.mm.plugin.aa.model.a.mIW)
      {
        aak(getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bwo()) }));
        AppMethodBeat.o(63688);
        return;
      }
      aak(getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bwn()) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((this.mNR) && (!this.mOW))
    {
      aak(getString(a.i.launch_aa_money_exceed_avg_amount_alert, new Object[] { Float.valueOf((float)com.tencent.mm.plugin.aa.model.e.bwp() / 100.0F) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((!this.mOl) && (!this.mNR)) {
      bwX();
    }
    AppMethodBeat.o(63688);
  }
  
  private void bxb()
  {
    AppMethodBeat.i(63689);
    int i;
    if ((this.mOO != null) && (this.mOO.size() > 0))
    {
      this.mOL.setText(getString(a.i.launch_aa_by_person_usernumber_wording, new Object[] { Integer.valueOf(this.mOO.size()) }));
      this.mOL.setTextColor(getResources().getColor(a.c.normal_text_color));
      i = (int)getResources().getDimension(a.d.aa_launch_content_left_right_margin);
      getResources().getDimension(a.d.aa_launch_by_person_header_margin_large);
      getResources().getDimension(a.d.aa_launch_by_person_header_margin_large_bottom);
      this.mON.setPadding(i, i, i, i);
      this.mON.setBackgroundResource(a.e.launch_aa_dark_round_corner_bg);
      this.mOH.setVisibility(0);
    }
    for (;;)
    {
      this.mOH.removeAllViews();
      this.mOP.clear();
      if ((this.mOO == null) || (this.mOO.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.mOO.keySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        double d = ((Double)this.mOO.get(str)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (i >= this.mOO.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        localLaunchAAByPersonNameAmountRow.a(str, this.chatroomName, d);
        this.mOH.addView(localLaunchAAByPersonNameAmountRow);
        this.mOP.put(str, localLaunchAAByPersonNameAmountRow);
        i += 1;
      }
      this.mOL.setText(a.i.launch_aa_by_person_usernumber_default_wording);
      this.mOL.setTextColor(getResources().getColor(a.c.aa_comm_hint_color));
      i = (int)getResources().getDimension(a.d.aa_launch_content_left_right_margin);
      this.mON.setPadding(i, i, i, i);
      this.mON.setBackgroundResource(a.e.launch_aa_white_round_corner_bg);
      this.mOH.setVisibility(8);
    }
    if (this.mNv != null)
    {
      this.mNv.requestLayout();
      f(this.mOJ, this.mOK);
    }
    this.mOV = 0;
    this.mOy.post(new Runnable()
    {
      public final void run() {}
    });
    AppMethodBeat.o(63689);
  }
  
  private List<String> bxc()
  {
    AppMethodBeat.i(266625);
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.aa.model.i.aag(this.chatroomName);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!as.bvK(str)) {
          localArrayList.add(str);
        }
      }
    }
    AppMethodBeat.o(266625);
    return localArrayList;
  }
  
  private void bxe()
  {
    AppMethodBeat.i(266630);
    if (bwM())
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "fromThirdParty(),user launch by person mode");
      this.mode = com.tencent.mm.plugin.aa.model.a.mIX;
      this.mOk = 5;
      AppMethodBeat.o(266630);
      return;
    }
    if (bwR())
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "fromOrderDetail(),user launch by money mode");
      this.mode = com.tencent.mm.plugin.aa.model.a.mIW;
      AppMethodBeat.o(266630);
      return;
    }
    int i = com.tencent.mm.plugin.aa.model.e.bwq();
    Log.i("MicroMsg.Aa.LaunchAAUI", "defaultMode is ：%s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 2: 
    default: 
      this.mode = com.tencent.mm.plugin.aa.model.a.mIW;
    }
    while ((!bxf()) && (this.mode == com.tencent.mm.plugin.aa.model.a.mIX))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "!isOpenAAPayCustomize() && mode == AAConstants.MODE_LAUNCH_BY_PERSON");
      this.mOk = 5;
      AppMethodBeat.o(266630);
      return;
      this.mode = com.tencent.mm.plugin.aa.model.a.mIX;
      this.mOk = 4;
      continue;
      this.mode = com.tencent.mm.plugin.aa.model.a.mIX;
      this.mOk = 5;
    }
    if ((this.mode == com.tencent.mm.plugin.aa.model.a.mIX) && (bwM()))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "mode == AAConstants.MODE_LAUNCH_BY_PERSON && fromThirdParty()");
      this.mOk = 5;
      AppMethodBeat.o(266630);
      return;
    }
    AppMethodBeat.o(266630);
  }
  
  private static boolean bxf()
  {
    AppMethodBeat.i(266632);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHj, false);
    Log.i("MicroMsg.Aa.LaunchAAUI", "aaPayCustomizeOpen switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(266632);
    return bool;
  }
  
  private void bxg()
  {
    AppMethodBeat.i(266637);
    int i = ax.au(getContext()).y;
    Object localObject = new int[2];
    this.mOz.getLocationOnScreen((int[])localObject);
    i -= localObject[1] + this.mOz.getHeight();
    int j = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
    localObject = (RelativeLayout.LayoutParams)this.mPf.getLayoutParams();
    if (com.tencent.mm.ci.a.fromDPToPix(getContext(), 5) + i < this.mPd + j)
    {
      int k = this.mPd;
      int m = com.tencent.mm.ci.a.fromDPToPix(getContext(), 10);
      ((RelativeLayout.LayoutParams)localObject).height = com.tencent.mm.ci.a.fromDPToPix(getContext(), 500);
      this.mPf.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mPf.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211083);
          LaunchAAUI.K(LaunchAAUI.this).smoothScrollBy(0, this.mPA);
          AppMethodBeat.o(211083);
        }
      }, 100L);
      AppMethodBeat.o(266637);
      return;
    }
    f(this.mOJ, this.mOK);
    AppMethodBeat.o(266637);
  }
  
  private void ce(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63673);
    this.mOS.setVisibility(0);
    this.mOS.setText(paramString1);
    this.mOS.setOnClickListener(new LaunchAAUI.17(this, paramString2));
    AppMethodBeat.o(63673);
  }
  
  private void f(final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(266635);
    this.mOH.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267992);
        int i = com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 48);
        int j = com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 64);
        int k = com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 96);
        if (LaunchAAUI.a(LaunchAAUI.this, paramView2))
        {
          localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
          localLayoutParams1.removeRule(12);
          localLayoutParams1.addRule(3, a.f.top_ll);
          localLayoutParams1.topMargin = i;
          paramView1.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(267992);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(3);
        localLayoutParams1.addRule(12);
        localLayoutParams1.bottomMargin = k;
        paramView1.setLayoutParams(localLayoutParams1);
        if (LaunchAAUI.g(paramView1, paramView2) >= i)
        {
          AppMethodBeat.o(267992);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(3);
        localLayoutParams2.addRule(12);
        localLayoutParams2.bottomMargin = j;
        paramView1.setLayoutParams(localLayoutParams2);
        if (LaunchAAUI.g(paramView1, paramView2) >= i)
        {
          AppMethodBeat.o(267992);
          return;
        }
        localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(12);
        localLayoutParams1.addRule(3, a.f.top_ll);
        localLayoutParams1.topMargin = i;
        paramView1.setLayoutParams(localLayoutParams1);
        AppMethodBeat.o(267992);
      }
    }, 100L);
    AppMethodBeat.o(266635);
  }
  
  private void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(63679);
    this.mOQ.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.mOn.setTextColor(getResources().getColor(a.c.FG_1));
      this.mMc.setTextColor(getResources().getColor(a.c.aa_launch_amount_disable_color));
      this.mOo.setTextColor(getResources().getColor(a.c.aa_launch_amount_disable_color));
      AppMethodBeat.o(63679);
      return;
    }
    this.mOn.setTextColor(getResources().getColor(a.c.FG_1));
    this.mMc.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.mOo.setTextColor(getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(63679);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(293264);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("aa_pay");
    AppMethodBeat.o(293264);
    return localMultiProcessMMKV;
  }
  
  private void y(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63672);
    Log.i("MicroMsg.Aa.LaunchAAUI", "go to contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("Select_block_List", z.bcZ());
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
      Log.i("MicroMsg.Aa.LaunchAAUI", "gotoSelectContactUI %s", new Object[] { ((StringBuilder)localObject).toString() });
      localIntent.putExtra("recent_remittance_contact_list", ((StringBuilder)localObject).toString());
    }
    if (this.mode == com.tencent.mm.plugin.aa.model.a.mIW)
    {
      paramArrayList = new StringBuilder();
      localObject = this.mOF.iterator();
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
      if (bwM()) {
        localIntent.putExtra("key_title", this.mOm.getText().toString());
      }
      com.tencent.mm.by.c.b(getContext(), "remittance", ".ui.SelectRemittanceContactUI", localIntent, 320);
      yd(10);
      AppMethodBeat.o(63672);
      return;
      paramArrayList = new StringBuilder();
      localObject = this.mOO.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.append((String)((Iterator)localObject).next()).append(",");
      }
      if (paramArrayList.length() - 1 >= 0) {
        paramArrayList.deleteCharAt(paramArrayList.length() - 1);
      }
      localIntent.putExtra("key_include_username_list", paramArrayList.toString());
    }
  }
  
  private void z(ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> paramArrayList)
  {
    AppMethodBeat.i(266620);
    this.mOO.clear();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        NetSceneNewAAQueryPFInfo.AALaunchItemParcel localAALaunchItemParcel = (NetSceneNewAAQueryPFInfo.AALaunchItemParcel)paramArrayList.next();
        this.mOO.put(localAALaunchItemParcel.username, Double.valueOf(localAALaunchItemParcel.gbJ / 100.0D));
      }
    }
    AppMethodBeat.o(266620);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(266636);
    if ((paramInt > 0) && (this.jSt <= 0))
    {
      this.mPd = paramInt;
      this.jSt = paramInt;
      bxg();
    }
    if ((paramInt <= 0) && (this.jSt > 0))
    {
      this.jSt = paramInt;
      this.mPf.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(272051);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)LaunchAAUI.J(LaunchAAUI.this).getLayoutParams();
          localLayoutParams.height = 0;
          LaunchAAUI.J(LaunchAAUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(272051);
        }
      }, 50L);
      this.mPf.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203427);
          LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.f(LaunchAAUI.this), LaunchAAUI.g(LaunchAAUI.this));
          AppMethodBeat.o(203427);
        }
      }, 100L);
    }
    AppMethodBeat.o(266636);
  }
  
  public final String bxd()
  {
    AppMethodBeat.i(266628);
    String str = new com.tencent.mm.vfs.q(getContext().getCacheDir() + "/aaTempPho", "aa_share_bitmap.jpg").bOF();
    AppMethodBeat.o(266628);
    return str;
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
      Log.e("MicroMsg.Aa.LaunchAAUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(63670);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.launch_aa_ui_new;
  }
  
  public boolean needExecuteBackListener()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63690);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Aa.LaunchAAUI", "onActivityResult requestCode:%s", new Object[] { Integer.valueOf(paramInt1) });
    label225:
    double d;
    if (paramInt1 == 233)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (this.mode == com.tencent.mm.plugin.aa.model.a.mIW)
        {
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.mOF.clear();
            this.mOF.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = com.tencent.mm.plugin.aa.model.i.aag(this.chatroomName);
          if ((paramIntent == null) || (this.mOF == null) || (this.mOF.size() != paramIntent.size()) || (!ab.Lj(this.chatroomName))) {
            break label319;
          }
          paramIntent = this.mOC;
          paramInt2 = a.i.launch_aa_by_money_all_group_member;
          if (this.mOF != null)
          {
            paramInt1 = this.mOF.size();
            paramIntent.setText(getString(paramInt2, new Object[] { Integer.valueOf(paramInt1) }));
          }
        }
        else
        {
          bwX();
          if ((this.mOF == null) || (this.mOF.size() <= com.tencent.mm.plugin.aa.model.e.bwo())) {
            break label373;
          }
          this.mOl = true;
          d = Util.getDouble(this.mOA.getText(), 0.0D);
          if ((this.mOF == null) || (d * 100.0D / this.mOF.size() <= com.tencent.mm.plugin.aa.model.e.bwp())) {
            break label381;
          }
          this.mNR = true;
          com.tencent.mm.plugin.report.service.h.IzE.a(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          bwY();
          bwZ();
          bxa();
          AppMethodBeat.o(63690);
          return;
          paramInt1 = 0;
          break;
          label319:
          paramIntent = this.mOC;
          paramInt2 = a.i.launch_aa_by_money_usernumber_wording;
          if (this.mOF != null) {}
          for (paramInt1 = this.mOF.size();; paramInt1 = 0)
          {
            paramIntent.setText(getString(paramInt2, new Object[] { Integer.valueOf(paramInt1) }));
            break;
          }
          label373:
          this.mOl = false;
          break label225;
          label381:
          this.mNR = false;
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
            this.mOO.clear();
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext())
              {
                localObject = ((String)paramIntent.next()).split(",");
                d = Util.getDouble(localObject[1], 0.0D);
                this.mOO.put(localObject[0], Double.valueOf(d));
              }
            }
            bwT();
          }
          catch (Exception paramIntent)
          {
            Log.e("MicroMsg.Aa.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[] { paramIntent.getMessage() });
            AppMethodBeat.o(63690);
            return;
          }
          AppMethodBeat.o(63690);
        }
      }
      else
      {
        if (paramInt1 == 300)
        {
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            localObject = paramIntent.getStringArrayListExtra("key_select_image_list");
            if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
              break label706;
            }
            paramIntent = com.tencent.mm.ui.tools.b.h(this, paramIntent, com.tencent.mm.plugin.image.d.bbW());
            if (Util.isNullOrNil(paramIntent)) {}
          }
          label706:
          for (this.imagePath = paramIntent;; this.imagePath = ((String)((ArrayList)localObject).get(0)))
          {
            if (!Util.isNullOrNil(this.imagePath))
            {
              this.mLO = 2;
              this.mOw.setVisibility(0);
              this.mOu.setVisibility(8);
              this.mOv.setVisibility(8);
              MMBitmapFactory.decodeFile(this.imagePath);
              this.mOw.post(new LaunchAAUI.33(this));
              yd(8);
            }
            Log.i("MicroMsg.Aa.LaunchAAUI", "SELECT_IMAGE_REQUEST_CODE imagePath:%s", new Object[] { this.imagePath });
            if (this.mOw.getVisibility() != 0) {
              break;
            }
            this.mOt.setClickable(false);
            AppMethodBeat.o(63690);
            return;
          }
          this.mOt.setClickable(true);
          AppMethodBeat.o(63690);
          return;
        }
        if (paramInt1 == 310)
        {
          if (paramInt2 == -1)
          {
            this.mLO = 2;
            this.imagePath = "";
            this.mOw.setVisibility(8);
            this.mOu.setVisibility(0);
            this.mOv.setVisibility(0);
            yd(7);
          }
          if (this.mOw.getVisibility() == 0)
          {
            this.mOt.setClickable(false);
            AppMethodBeat.o(63690);
            return;
          }
          this.mOt.setClickable(true);
        }
      }
    }
    AppMethodBeat.o(63690);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63669);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.Aa.LaunchAAUI", "LaunchAAUI onCreate");
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
    setMMTitle(a.i.launch_aa_title);
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    label251:
    int i;
    if (bwM())
    {
      this.mPa = ((NetSceneNewAAQueryPFInfo.PfInfoParcel)getIntent().getParcelableExtra("pfInfo"));
      this.mNy = getIntent().getStringExtra("pfOrderNo");
      if (this.mPa == null)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "pfInfoParcel is null!!!");
        finish();
        AppMethodBeat.o(63669);
        return;
      }
      this.mode = com.tencent.mm.plugin.aa.model.a.mIX;
      this.mOk = 5;
      this.mOY = this.mPa.gbJ;
      this.mOZ = this.mPa.remark;
      yd(1);
      if (!bwM()) {
        break label1591;
      }
      this.mOT = new com.tencent.mm.plugin.aa.model.e(this.mPa.mKR.mKM, this.mPa.mKR.mKL);
      if ((!Util.isNullOrNil(this.mOT.mJJ)) && (!Util.isNullOrNil(this.mOT.mJI))) {
        ce(this.mOT.mJJ, this.mOT.mJI);
      }
      this.chatroomName = getIntent().getStringExtra("chatroom_name");
      if (Util.isNullOrNil(this.chatroomName))
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "chatroomName is null!!!");
        this.chatroomName = "";
      }
      paramBundle = this.chatroomName;
      if (Util.isNullOrNil(paramBundle)) {
        break label1686;
      }
      if (!ab.Lj(paramBundle)) {
        break label1638;
      }
      label309:
      this.chatroomName = paramBundle;
      this.mNv = findViewById(a.f.root_container);
      this.mOx = ((TextView)findViewById(a.f.launch_aa_switch_mode));
      this.mOq = ((LinearLayout)findViewById(a.f.launch_aa_switch_ll));
      this.mOr = ((ImageView)findViewById(a.f.launch_aa_switch_mode_arrow));
      this.mOQ = ((Button)findViewById(a.f.launch_aa_button));
      this.mOR = ((TextView)findViewById(a.f.launch_aa_alert_tip_tv));
      this.mOS = ((TextView)findViewById(a.f.launch_aa_warn_tip_tv));
      this.mOm = ((MMEditText)findViewById(a.f.launch_aa_title_edit));
      this.mOn = ((TextView)findViewById(a.f.launch_aa_total_amount_hint));
      this.mMc = ((TextView)findViewById(a.f.launch_aa_amount));
      this.mOo = ((TextView)findViewById(a.f.launch_aa_amount_unit));
      this.mOs = ((RelativeLayout)findViewById(a.f.photo_container));
      this.mOt = ((LinearLayout)findViewById(a.f.photo_top_container));
      this.mOu = ((ImageView)findViewById(a.f.plus_iv));
      this.mOv = ((TextView)findViewById(a.f.plus_iv_tips));
      this.mOw = ((ImageView)findViewById(a.f.content_iv));
      this.mOp = ((TextView)findViewById(a.f.launch_by_person_fill_in_select));
      this.mOy = ((TextView)findViewById(a.f.aa_check_record));
      this.mOA = ((WalletFormView)findViewById(a.f.launch_aa_total_amount_edit_form));
      this.mOC = ((TextView)findViewById(a.f.launch_aa_by_money_user_select));
      this.mOB = ((TextView)findViewById(a.f.launch_aa_by_money_user_select_hint));
      this.mOD = ((ViewGroup)findViewById(a.f.launch_by_money_total_usernumber_content_layout));
      this.mOE = ((ViewGroup)findViewById(a.f.launch_by_money_total_amount_layout));
      this.mOL = ((TextView)findViewById(a.f.launch_aa_by_person_user_select));
      this.mOL.setText(a.i.launch_aa_by_person_usernumber_default_wording);
      this.mOL.setTextColor(getResources().getColor(a.c.FG_2));
      this.mOG = ((ViewGroup)findViewById(a.f.launch_by_person_user_layout));
      this.mOH = ((ViewGroup)findViewById(a.f.launch_by_person_user_list_layout));
      this.mON = ((ViewGroup)findViewById(a.f.launch_aa_by_person_select_header_layout));
      this.mOI = ((ViewGroup)findViewById(a.f.launch_by_person_fill_in_select_layout));
      this.mOJ = ((ViewGroup)findViewById(a.f.launch_aa_total_amount_layout));
      this.mOK = ((ViewGroup)findViewById(a.f.top_ll));
      this.mOM = ((TextView)findViewById(a.f.launch_by_person_fill_in_select_layout_tips));
      this.mOz = ((ViewGroup)findViewById(a.f.launch_aa_title_edit_layout));
      this.mPe = ((ScrollView)findViewById(a.f.root_scroll));
      this.mPf = findViewById(a.f.scroll_Interval);
      this.mNv.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(63659);
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          if (LaunchAAUI.a(LaunchAAUI.this).findFocus() != null)
          {
            LaunchAAUI.a(LaunchAAUI.this).setCursorVisible(false);
            LaunchAAUI.a(LaunchAAUI.this).clearFocus();
          }
          AppMethodBeat.o(63659);
          return false;
        }
      });
      bwV();
      bwU();
      bwS();
      this.mOQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63662);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.Aa.LaunchAAUI", "click launchButton，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.b(LaunchAAUI.this)), Integer.valueOf(LaunchAAUI.c(LaunchAAUI.this)) });
          LaunchAAUI.d(LaunchAAUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63662);
        }
      });
      this.mOy.setClickable(true);
      this.mOy.setOnTouchListener(new o());
      paramBundle = new SpannableString(getString(a.i.check_aa_record));
      paramBundle.setSpan(new a(new a.a()
      {
        public final void bwz()
        {
          AppMethodBeat.i(63663);
          Object localObject = new Intent(LaunchAAUI.this, AAQueryListUI.class);
          LaunchAAUI localLaunchAAUI = LaunchAAUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localLaunchAAUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLaunchAAUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localLaunchAAUI, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (LaunchAAUI.b(LaunchAAUI.this) == com.tencent.mm.plugin.aa.model.a.mIW)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            AppMethodBeat.o(63663);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
          AppMethodBeat.o(63663);
        }
      }), 0, paramBundle.length(), 18);
      this.mOy.setText(paramBundle);
      this.mOy.setVisibility(8);
      this.mOm.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63664);
          LaunchAAUI.e(LaunchAAUI.this);
          LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.f(LaunchAAUI.this), LaunchAAUI.g(LaunchAAUI.this));
          LaunchAAUI.this.yd(6);
          LaunchAAUI.h(LaunchAAUI.this);
          AppMethodBeat.o(63664);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.mOm.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(63665);
          LaunchAAUI.a(LaunchAAUI.this).setCursorVisible(true);
          if (LaunchAAUI.a((MMEditText)paramAnonymousView))
          {
            paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
            if (paramAnonymousMotionEvent.getAction() == 1) {
              paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(false);
            }
          }
          AppMethodBeat.o(63665);
          return false;
        }
      });
      this.mOm.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(229336);
          if (paramAnonymousView.isFocused())
          {
            LaunchAAUI.a(LaunchAAUI.this).setPadding(0, com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 12), 0, com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 16));
            LaunchAAUI.a(LaunchAAUI.this).setHint("");
            ((InputMethodManager)LaunchAAUI.this.getContext().getSystemService("input_method")).showSoftInput(LaunchAAUI.a(LaunchAAUI.this), 0);
            AppMethodBeat.o(229336);
            return;
          }
          if (LaunchAAUI.a(LaunchAAUI.this).getText().length() > 0)
          {
            LaunchAAUI.a(LaunchAAUI.this).setPadding(0, com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 12), 0, com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 16));
            AppMethodBeat.o(229336);
            return;
          }
          LaunchAAUI.a(LaunchAAUI.this).setPadding(0, com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 28), 0, com.tencent.mm.ci.a.fromDPToPix(LaunchAAUI.this.getContext(), 16));
          LaunchAAUI.a(LaunchAAUI.this).setHint(LaunchAAUI.this.getString(a.i.launch_aa_des_default_title));
          AppMethodBeat.o(229336);
        }
      });
      bwW();
      this.mON.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189431);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          LaunchAAUI.i(LaunchAAUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189431);
        }
      });
      if (!Util.isNullOrNil(this.mOZ))
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "default title: %s", new Object[] { this.mOZ });
        this.mOm.setText(this.mOZ);
        if (this.mOZ.length() <= 20) {
          break label1692;
        }
        i = 20;
        label1053:
        this.mOm.setSelection(i);
      }
      if (!bwM()) {
        break label1703;
      }
      paramBundle = String.format("%.2f", new Object[] { Double.valueOf(this.mOY / 100.0D) });
      this.mOA.setText(paramBundle);
      this.mOA.setSelection(paramBundle.length());
      label1113:
      bwY();
      View localView;
      if ((bwM()) && (MultiProcessMMKV.getMMKV("aa_pay").getBoolean("new_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        localView = getLayoutInflater().inflate(a.g.aa_new_guide_dialog, null);
        localView.findViewById(a.f.i_know_bt).setOnClickListener(new LaunchAAUI.5(this, paramBundle));
        paramBundle.ODT = new LaunchAAUI.6(this, paramBundle, localView);
        paramBundle.rn(true);
        paramBundle.eik();
      }
      if ((ab.PR(this.chatroomName)) && (MultiProcessMMKV.getMMKV("aa_pay").getBoolean("new_open_IM_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        localView = getLayoutInflater().inflate(a.g.aa_new_guide_dialog, null);
        ((TextView)localView.findViewById(a.f.aa_new_dialog_title)).setText(getString(a.i.launch_aa_open_im_guide_title));
        ((TextView)localView.findViewById(a.f.aa_new_dialog_content)).setText(getString(a.i.launch_aa_open_im_guide_content));
        localView.findViewById(a.f.i_know_bt).setOnClickListener(new LaunchAAUI.7(this, paramBundle));
        paramBundle.ODT = new LaunchAAUI.8(this, paramBundle, localView);
        paramBundle.rn(true);
        paramBundle.eik();
      }
      if (!bwM()) {
        break label1835;
      }
      this.mOs.setVisibility(0);
      this.mOs.setOnClickListener(new LaunchAAUI.9(this));
      this.mOw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(270913);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (LaunchAAUI.m(LaunchAAUI.this) == null) {
            LaunchAAUI.a(LaunchAAUI.this, com.tencent.mm.ui.base.h.a(LaunchAAUI.this, 3, a.j.LuckyMoneyNoAnimDialog, LaunchAAUI.this.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(269767);
                if ((LaunchAAUI.m(LaunchAAUI.this) != null) && (LaunchAAUI.m(LaunchAAUI.this).isShowing())) {
                  LaunchAAUI.m(LaunchAAUI.this).dismiss();
                }
                AppMethodBeat.o(269767);
              }
            }));
          }
          if (!Util.isNullOrNil(LaunchAAUI.n(LaunchAAUI.this))) {
            com.tencent.mm.ay.q.bmk().a(LaunchAAUI.n(LaunchAAUI.this), new r.a()
            {
              public final void a(String paramAnonymous2String1, Bitmap paramAnonymous2Bitmap, String paramAnonymous2String2)
              {
                AppMethodBeat.i(269611);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous2String1, paramAnonymous2String2 });
                if ((LaunchAAUI.m(LaunchAAUI.this) != null) && (LaunchAAUI.m(LaunchAAUI.this).isShowing())) {
                  LaunchAAUI.m(LaunchAAUI.this).dismiss();
                }
                if (paramAnonymous2Bitmap != null)
                {
                  paramAnonymous2String1 = new Intent();
                  paramAnonymous2String1.putExtra("use_scene", 1);
                  paramAnonymous2String1.putExtra("scene", LaunchAAUI.o(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("path", LaunchAAUI.p(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("url", LaunchAAUI.n(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("view_info", ViewAnimHelper.q(LaunchAAUI.q(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
                  com.tencent.mm.by.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous2String1, 310);
                  LaunchAAUI.this.yd(14);
                  AppMethodBeat.o(269611);
                  return;
                }
                Toast.makeText(LaunchAAUI.this, a.i.aa_list_load_img_fail, 1).show();
                AppMethodBeat.o(269611);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(270913);
            return;
            Log.i("MicroMsg.Aa.LaunchAAUI", "imageUrl == null");
            if ((LaunchAAUI.m(LaunchAAUI.this) != null) && (LaunchAAUI.m(LaunchAAUI.this).isShowing())) {
              LaunchAAUI.m(LaunchAAUI.this).dismiss();
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("use_scene", 1);
            LaunchAAUI.r(LaunchAAUI.this);
            paramAnonymousView.putExtra("scene", LaunchAAUI.o(LaunchAAUI.this));
            paramAnonymousView.putExtra("path", LaunchAAUI.p(LaunchAAUI.this));
            paramAnonymousView.putExtra("view_info", ViewAnimHelper.q(LaunchAAUI.q(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
            com.tencent.mm.by.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymousView, 310);
            LaunchAAUI.this.yd(14);
          }
        }
      });
      if ((this.mPa == null) || (Util.isNullOrNil(this.mPa.mKO))) {
        break label1796;
      }
      this.mLO = 1;
      this.imageUrl = this.mPa.mKO;
      this.mOw.setVisibility(0);
      this.mOu.setVisibility(8);
      this.mOv.setVisibility(8);
      com.tencent.mm.ay.q.bmk().a(this.mPa.mKO, this.mPa.mKQ, new r.a()
      {
        public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
        {
          boolean bool = false;
          AppMethodBeat.i(214239);
          if (paramAnonymousBitmap == null) {
            bool = true;
          }
          Log.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s bitmap==null:%s path:%s", new Object[] { paramAnonymousString1, Boolean.valueOf(bool), paramAnonymousString2 });
          LaunchAAUI.a(LaunchAAUI.this, paramAnonymousString2);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(273209);
              if (paramAnonymousBitmap != null)
              {
                LaunchAAUI.q(LaunchAAUI.this).setImageBitmap(paramAnonymousBitmap);
                AppMethodBeat.o(273209);
                return;
              }
              LaunchAAUI.r(LaunchAAUI.this);
              LaunchAAUI.q(LaunchAAUI.this).setVisibility(8);
              LaunchAAUI.s(LaunchAAUI.this).setVisibility(0);
              LaunchAAUI.t(LaunchAAUI.this).setVisibility(0);
              AppMethodBeat.o(273209);
            }
          });
          AppMethodBeat.o(214239);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      if ((bwM()) && (this.mPc != null)) {
        this.mPc.alive();
      }
      this.jij = new com.tencent.mm.ui.tools.i(getContext());
      this.jij.XSx = this;
      AppMethodBeat.o(63669);
      return;
      bxe();
      this.mOX = getIntent().getStringExtra("amount");
      this.mOZ = getIntent().getStringExtra("title");
      break;
      label1591:
      paramBundle = this.mOj.mLq;
      com.tencent.mm.vending.g.g.ieN().c(paramBundle).f(new com.tencent.mm.vending.c.a() {}).a(new LaunchAAUI.15(this));
      break label251;
      label1638:
      paramBundle = Util.stringsToList(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(z.bcZ());
        if (paramBundle.size() > 0)
        {
          paramBundle = (String)paramBundle.get(0);
          break label309;
        }
      }
      label1686:
      paramBundle = "";
      break label309;
      label1692:
      i = this.mOZ.length();
      break label1053;
      label1703:
      if (Util.isNullOrNil(this.mOX)) {
        break label1113;
      }
      Log.i("MicroMsg.Aa.LaunchAAUI", "default amount: %s", new Object[] { this.mOX });
      paramBundle = com.tencent.mm.wallet_core.ui.g.a(new StringBuilder().append(this.mOX).toString(), "100", 2, RoundingMode.HALF_UP);
      this.mOA.setText(paramBundle);
      this.mOA.setSelection(paramBundle.length());
      break label1113;
      label1796:
      this.mLO = 2;
      this.imagePath = "";
      this.mOw.setVisibility(8);
      this.mOu.setVisibility(0);
      this.mOv.setVisibility(0);
      continue;
      label1835:
      this.mOs.setVisibility(0);
      this.mOw.setVisibility(8);
      this.mOu.setVisibility(0);
      this.mOv.setVisibility(0);
      this.mOt.setOnClickListener(new LaunchAAUI.13(this));
      this.mOw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(275623);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("use_scene", 1);
          paramAnonymousView.putExtra("scene", LaunchAAUI.o(LaunchAAUI.this));
          paramAnonymousView.putExtra("path", LaunchAAUI.p(LaunchAAUI.this));
          paramAnonymousView.putExtra("url", LaunchAAUI.n(LaunchAAUI.this));
          paramAnonymousView.putExtra("view_info", ViewAnimHelper.q(LaunchAAUI.q(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
          com.tencent.mm.by.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymousView, 310);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(275623);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63687);
    super.onDestroy();
    if ((bwM()) && (this.mPc != null)) {
      this.mPc.dead();
    }
    AppMethodBeat.o(63687);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(266640);
    super.onPause();
    if (this.jij != null) {
      this.jij.close();
    }
    AppMethodBeat.o(266640);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(266639);
    super.onResume();
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(266639);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(63686);
    super.onStop();
    if (this.mOP != null) {
      this.mOP.clear();
    }
    AppMethodBeat.o(63686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(266638);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(266638);
  }
  
  public final void yd(int paramInt)
  {
    AppMethodBeat.i(63691);
    if (bwM()) {
      com.tencent.mm.plugin.aa.model.i.yd(paramInt);
    }
    AppMethodBeat.o(63691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */