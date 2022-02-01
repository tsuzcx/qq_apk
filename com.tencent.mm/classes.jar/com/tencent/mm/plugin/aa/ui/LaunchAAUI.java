package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.b.e.b;
import com.tencent.mm.plugin.aa.model.b.e.c;
import com.tencent.mm.plugin.aa.model.b.e.d;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AALaunchItemParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AAOperationInfoParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.PfInfoParcel;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
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
  private String imagePath;
  private String imageUrl;
  private int jUB;
  private Dialog jUC;
  private TextView jUP;
  private Dialog jUV;
  private boolean jWF;
  private com.tencent.mm.plugin.aa.model.b.e jWX;
  private int jWY;
  private boolean jWZ;
  private String jWm;
  private ViewGroup jXA;
  private Map<String, Double> jXB;
  private Map<String, LaunchAAByPersonNameAmountRow> jXC;
  private Button jXD;
  private TextView jXE;
  private TextView jXF;
  private com.tencent.mm.plugin.aa.model.e jXG;
  private int jXH;
  private int jXI;
  private boolean jXJ;
  private String jXK;
  private long jXL;
  private String jXM;
  private NetSceneNewAAQueryPFInfo.PfInfoParcel jXN;
  private boolean jXO;
  private IListener<lq> jXP;
  private MMEditText jXa;
  private TextView jXb;
  private TextView jXc;
  private TextView jXd;
  private LinearLayout jXe;
  private ImageView jXf;
  private RelativeLayout jXg;
  private LinearLayout jXh;
  private ImageView jXi;
  private TextView jXj;
  private ImageView jXk;
  private TextView jXl;
  private TextView jXm;
  private WalletFormView jXn;
  private TextView jXo;
  private TextView jXp;
  private ViewGroup jXq;
  private ViewGroup jXr;
  private List<String> jXs;
  private ViewGroup jXt;
  private ViewGroup jXu;
  private ViewGroup jXv;
  private ViewGroup jXw;
  private ViewGroup jXx;
  private TextView jXy;
  private TextView jXz;
  private int mode;
  private int scene;
  private long timestamp;
  private Dialog tipDialog;
  
  public LaunchAAUI()
  {
    AppMethodBeat.i(63668);
    this.jWX = ((com.tencent.mm.plugin.aa.model.b.e)aq(com.tencent.mm.plugin.aa.model.b.e.class));
    this.mode = com.tencent.mm.plugin.aa.model.a.jRJ;
    this.jWY = 4;
    this.chatroomName = null;
    this.jWZ = false;
    this.jWF = false;
    this.jXs = new ArrayList();
    this.jXB = new HashMap();
    this.jXC = new HashMap();
    this.jXG = new com.tencent.mm.plugin.aa.model.e();
    this.jXH = 0;
    this.jXI = 0;
    this.jXJ = false;
    this.timestamp = 0L;
    this.imageUrl = "";
    this.jXN = null;
    this.jXO = false;
    this.jUC = null;
    this.jXP = new LaunchAAUI.1(this);
    AppMethodBeat.o(63668);
  }
  
  private void SE(String paramString)
  {
    AppMethodBeat.i(63676);
    this.jXJ = true;
    this.jXE.setVisibility(0);
    this.jXE.startAnimation(AnimationUtils.loadAnimation(this, 2130772081));
    this.jXE.setText(paramString);
    AppMethodBeat.o(63676);
  }
  
  private void SF(String paramString)
  {
    AppMethodBeat.i(63681);
    Log.i("MicroMsg.Aa.LaunchAAUI", "showLaunchComfirmDialog() from scene:%s", new Object[] { Integer.valueOf(this.scene) });
    String str = this.jXa.getText().toString();
    if (Util.isNullOrNil(str)) {
      str = getString(2131762174);
    }
    for (;;)
    {
      ((j)com.tencent.mm.kernel.g.af(j.class)).a(getController(), paramString, getString(2131755036) + str, getString(2131755035), new LaunchAAUI.22(this, paramString));
      uZ(11);
      com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(3) });
      AppMethodBeat.o(63681);
      return;
    }
  }
  
  public static boolean SG(String paramString)
  {
    AppMethodBeat.i(63693);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63693);
      return false;
    }
    boolean bool = aS(i.SA(paramString));
    AppMethodBeat.o(63693);
    return bool;
  }
  
  private boolean SH(String paramString)
  {
    AppMethodBeat.i(213077);
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
        AppMethodBeat.o(213077);
        return false;
      }
      if (localOptions1.outWidth * localOptions1.outHeight < 5242880)
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "dont handle：sizeOption.outWidth * sizeOption.outHeight * 2 < MAX_BITMAP_SIZE");
        AppMethodBeat.o(213077);
        return false;
      }
      int i = localOptions1.outWidth * localOptions1.outHeight / 5242880;
      localOptions2.inSampleSize = i;
      Log.i("MicroMsg.Aa.LaunchAAUI", "need handle：bitmap too large sample:%s", new Object[] { Integer.valueOf(i) });
      paramString = BitmapUtil.rotate(BitmapUtil.decodeFile(paramString, localOptions2), Exif.fromFile(paramString).getOrientationInDegree());
      if (s.YS(bmV())) {
        s.deleteFile(bmV());
      }
      BitmapUtil.saveBitmapToImage(paramString, 80, Bitmap.CompressFormat.JPEG, bmV(), true);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "decode file to bitmap error! " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(213077);
    return true;
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
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSJ, paramString2);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSK, Double.valueOf(100.0D * paramDouble));
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSN, paramString1);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSQ, Long.valueOf(this.timestamp));
    long l = f.a(i.bX(new StringBuilder().append(paramDouble).toString(), "100"), String.valueOf(paramInt), RoundingMode.CEILING);
    Log.d("MicroMsg.Aa.LaunchAAUI", "perAmount: %s", new Object[] { Long.valueOf(l) });
    if ((l <= 0L) || (l > com.tencent.mm.plugin.aa.model.e.bmh()))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "illegal avgAmount: %s", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(63684);
      return;
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSM, Long.valueOf(l));
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSR, paramString3);
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSS, paramString4);
    if (bmE()) {
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.jST, this.jWm);
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSP, paramList);
    this.jWX.jUa.e(this.mode, localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void cn(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(213052);
        Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        if (LaunchAAUI.H(LaunchAAUI.this) != null) {
          LaunchAAUI.H(LaunchAAUI.this).dismiss();
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
          com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131762180), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(213050);
              Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
              AppMethodBeat.o(213050);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(213052);
          return;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.ab)))
          {
            i.a(LaunchAAUI.this.getContext(), (com.tencent.mm.protocal.protobuf.ab)paramAnonymousObject);
          }
          else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
          {
            paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
            String str1 = paramAnonymousObject.dQx;
            String str2 = paramAnonymousObject.lHA;
            String str3 = paramAnonymousObject.lHB;
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
            locala.boo(str1);
            locala.bou(str3).c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(213051);
                f.p(LaunchAAUI.this.getContext(), paramAnonymousObject.qwt, false);
                AppMethodBeat.o(213051);
              }
            });
            locala.bov(str2);
            locala.hbn().show();
          }
          else
          {
            Toast.makeText(paramContext, 2131762178, 1).show();
          }
        }
      }
    });
    AppMethodBeat.o(63684);
  }
  
  private void a(final Context paramContext, final String paramString1, String paramString2, String paramString3, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(63685);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(7, 5);
    com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.jXa.getText().toString();
        if (Util.isNullOrNil(str1))
        {
          str1 = getString(2131762174);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator = this.jXB.keySet().iterator();
          long l1 = 0L;
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if ((!paramBoolean) || (paramList.contains(str2)))
            {
              double d = ((Double)this.jXB.get(str2)).doubleValue();
              com.tencent.mm.protocal.protobuf.l locall = new com.tencent.mm.protocal.protobuf.l();
              locall.eht = f.nF(String.valueOf(d), "100");
              locall.username = str2;
              localArrayList1.add(locall);
              long l2 = locall.eht;
              localArrayList2.add(locall.eht);
              l1 = l2 + l1;
            }
          }
          else
          {
            paramList = new com.tencent.mm.protocal.protobuf.l();
            paramList.username = z.aTY();
            paramList.eht = l1;
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSJ, str1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSK, Long.valueOf(l1));
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSP, localArrayList1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSN, paramString1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSQ, Long.valueOf(this.timestamp));
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSR, paramString2);
            localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSS, paramString3);
            if (bmE()) {
              localHashMap.put(com.tencent.mm.plugin.aa.model.l.jST, this.jWm);
            }
            this.jWX.jUb.H(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
            {
              public final void cn(final Object paramAnonymousObject)
              {
                AppMethodBeat.i(213056);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
                if (LaunchAAUI.H(LaunchAAUI.this) != null) {
                  LaunchAAUI.H(LaunchAAUI.this).dismiss();
                }
                if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
                  com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131762180), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(213054);
                      Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                      AppMethodBeat.o(213054);
                    }
                  });
                }
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(10) });
                  AppMethodBeat.o(213056);
                  return;
                  if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.ab)))
                  {
                    i.a(LaunchAAUI.this.getContext(), (com.tencent.mm.protocal.protobuf.ab)paramAnonymousObject);
                  }
                  else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
                  {
                    paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
                    String str1 = paramAnonymousObject.dQx;
                    String str2 = paramAnonymousObject.lHA;
                    String str3 = paramAnonymousObject.lHB;
                    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
                    locala.boo(str1);
                    locala.bou(str3).c(new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(213055);
                        f.p(LaunchAAUI.this.getContext(), paramAnonymousObject.qwt, false);
                        AppMethodBeat.o(213055);
                      }
                    });
                    locala.bov(str2);
                    locala.hbn().show();
                  }
                  else
                  {
                    Toast.makeText(paramContext, 2131762178, 1).show();
                  }
                }
              }
            });
            com.tencent.mm.plugin.report.service.h.CyF.a(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(i.SA(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, Util.listToString(localArrayList2, ",") });
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
    uZ(9);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.jRJ)
    {
      if (Util.isNullOrNil(this.jXn.getText()))
      {
        AppMethodBeat.o(63682);
        return;
      }
      if ((this.jXs == null) || (this.jXs.size() == 0))
      {
        AppMethodBeat.o(63682);
        return;
      }
      bmP();
      com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
      if ((paramBoolean) && (paramArrayList == null)) {}
    }
    for (;;)
    {
      try
      {
        i = paramArrayList.size();
        final double d = Util.getDouble(this.jUP.getText().toString(), 0.0D) * i;
        String str2 = this.jXa.getText().toString();
        final String str1 = str2;
        if (Util.isNullOrNil(str2)) {
          str1 = getString(2131762174);
        }
        if (i > 0)
        {
          if (this.jUV != null) {
            this.jUV.dismiss();
          }
          this.jUV = com.tencent.mm.wallet_core.ui.h.c(paramContext, false, null);
          if (!Util.isNullOrNil(this.imagePath)) {
            new com.tencent.mm.plugin.aa.model.d(this.imagePath, new com.tencent.mm.plugin.aa.model.d.a()
            {
              public final void bU(final String paramAnonymousString1, final String paramAnonymousString2)
              {
                AppMethodBeat.i(213046);
                Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(213044);
                    if (LaunchAAUI.24.this.jXX)
                    {
                      LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.24.this.val$context, LaunchAAUI.24.this.gtu, LaunchAAUI.24.this.jXY, LaunchAAUI.24.this.jXZ, LaunchAAUI.24.this.jYa, LaunchAAUI.24.this.jXR, paramAnonymousString1, paramAnonymousString2);
                      AppMethodBeat.o(213044);
                      return;
                    }
                    LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.24.this.val$context, LaunchAAUI.24.this.gtu, LaunchAAUI.24.this.jXY, LaunchAAUI.24.this.jXZ, LaunchAAUI.24.this.jYa, LaunchAAUI.E(LaunchAAUI.this), paramAnonymousString1, paramAnonymousString2);
                    AppMethodBeat.o(213044);
                  }
                });
                AppMethodBeat.o(213046);
              }
              
              public final void bme()
              {
                AppMethodBeat.i(213047);
                Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(213045);
                    if (LaunchAAUI.H(LaunchAAUI.this) != null) {
                      LaunchAAUI.H(LaunchAAUI.this).dismiss();
                    }
                    Toast.makeText(LaunchAAUI.24.this.val$context, 2131762178, 1).show();
                    AppMethodBeat.o(213045);
                  }
                });
                AppMethodBeat.o(213047);
              }
            }).bmd();
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13723, new Object[] { Integer.valueOf(1), i.SA(this.chatroomName), Integer.valueOf(i), Double.valueOf(100.0D * d), str1 });
          AppMethodBeat.o(63682);
          return;
          i = 0;
          continue;
          if (this.jXs == null) {
            break label598;
          }
          i = this.jXs.size();
          d = Util.getDouble(this.jXn.getText(), 0.0D);
          continue;
        }
        if (paramBoolean)
        {
          a(paramContext, paramString, i, str1, d, paramArrayList);
          continue;
        }
        a(paramContext, paramString, i, str1, d, this.jXs);
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[] { Integer.valueOf(this.mode), paramContext.getMessage() });
        AppMethodBeat.o(63682);
        return;
      }
      continue;
      bmP();
      if (this.jUV != null) {
        this.jUV.dismiss();
      }
      this.jUV = com.tencent.mm.wallet_core.ui.h.c(paramContext, false, null);
      if (!Util.isNullOrNil(this.imagePath))
      {
        if ((this.jUB == 2) && (SH(this.imagePath)) && (s.YS(bmV())))
        {
          Log.i("MicroMsg.Aa.LaunchAAUI", "set local imagePath :%s", new Object[] { bmV() });
          this.imagePath = bmV();
        }
        new com.tencent.mm.plugin.aa.model.d(this.imagePath, new com.tencent.mm.plugin.aa.model.d.a()
        {
          public final void bU(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            AppMethodBeat.i(213048);
            Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(63648);
                if (s.YS(LaunchAAUI.this.bmV()))
                {
                  Log.i("MicroMsg.Aa.LaunchAAUI", " upload success , delete file");
                  s.deleteFile(LaunchAAUI.this.bmV());
                }
                if (LaunchAAUI.c(LaunchAAUI.this) == 4)
                {
                  LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.25.this.val$context, LaunchAAUI.25.this.gtu, paramAnonymousString1, paramAnonymousString2);
                  AppMethodBeat.o(63648);
                  return;
                }
                LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.25.this.val$context, LaunchAAUI.25.this.gtu, paramAnonymousString1, paramAnonymousString2, LaunchAAUI.25.this.jXX, LaunchAAUI.25.this.jXR);
                AppMethodBeat.o(63648);
              }
            });
            AppMethodBeat.o(213048);
          }
          
          public final void bme()
          {
            AppMethodBeat.i(213049);
            Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(63649);
                if (LaunchAAUI.H(LaunchAAUI.this) != null) {
                  LaunchAAUI.H(LaunchAAUI.this).dismiss();
                }
                Toast.makeText(LaunchAAUI.25.this.val$context, 2131762178, 1).show();
                AppMethodBeat.o(63649);
              }
            });
            AppMethodBeat.o(213049);
          }
        }).bmd();
        AppMethodBeat.o(63682);
        return;
      }
      if (this.jWY == 4)
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
  
  private static boolean aS(List<String> paramList)
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
    } while (!Util.isEqual((String)paramList.next(), z.aTY()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(63694);
      return bool;
    }
  }
  
  private void b(final Context paramContext, final String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213073);
    Log.i("MicroMsg.Aa.LaunchAAUI", "launchAAByPersonCustomize");
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(7, 5);
    com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(2) });
    HashMap localHashMap = new HashMap();
    try
    {
      String str2 = this.jXa.getText().toString();
      String str1 = str2;
      if (Util.isNullOrNil(str2)) {
        str1 = getString(2131762174);
      }
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSJ, str1);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSN, paramString1);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSQ, Long.valueOf(this.timestamp));
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSR, paramString2);
      localHashMap.put(com.tencent.mm.plugin.aa.model.l.jSS, paramString3);
      if (bmE()) {
        localHashMap.put(com.tencent.mm.plugin.aa.model.l.jST, this.jWm);
      }
      this.jWX.jUc.H(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
      {
        public final void cn(final Object paramAnonymousObject)
        {
          AppMethodBeat.i(213060);
          Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
          if (LaunchAAUI.H(LaunchAAUI.this) != null) {
            LaunchAAUI.H(LaunchAAUI.this).dismiss();
          }
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
            com.tencent.mm.ui.base.h.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(2131762180), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(213058);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                AppMethodBeat.o(213058);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(10) });
            AppMethodBeat.o(213060);
            return;
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.ab)))
            {
              i.a(LaunchAAUI.this.getContext(), (com.tencent.mm.protocal.protobuf.ab)paramAnonymousObject);
            }
            else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
            {
              paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
              String str1 = paramAnonymousObject.dQx;
              String str2 = paramAnonymousObject.lHA;
              String str3 = paramAnonymousObject.lHB;
              com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(paramContext);
              locala.boo(str1);
              locala.bou(str3).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(213059);
                  f.p(LaunchAAUI.this.getContext(), paramAnonymousObject.qwt, false);
                  AppMethodBeat.o(213059);
                }
              });
              locala.bov(str2);
              locala.hbn().show();
            }
            else
            {
              Toast.makeText(paramContext, 2131762178, 1).show();
            }
          }
        }
      });
      AppMethodBeat.o(213073);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPersonCustomize error: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(213073);
    }
  }
  
  private void bY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63673);
    this.jXF.setVisibility(0);
    this.jXF.setText(paramString1);
    this.jXF.setOnClickListener(new LaunchAAUI.17(this, paramString2));
    AppMethodBeat.o(63673);
  }
  
  private boolean bmE()
  {
    return this.scene == 6;
  }
  
  private boolean bmJ()
  {
    return this.scene == 5;
  }
  
  private void bmK()
  {
    AppMethodBeat.i(213071);
    if (bmE()) {
      try
      {
        y(this.jXN.jTA);
        bmL();
        AppMethodBeat.o(213071);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "initPersonLaunchView error:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(213071);
  }
  
  private void bmL()
  {
    AppMethodBeat.i(63671);
    bmT();
    bmR();
    bmQ();
    AppMethodBeat.o(63671);
  }
  
  private void bmM()
  {
    AppMethodBeat.i(63674);
    String str;
    if (this.mode == com.tencent.mm.plugin.aa.model.a.jRK) {
      if (this.jWY == 4) {
        str = getString(2131762190);
      }
    }
    for (;;)
    {
      ao.a(this.jXl.getPaint(), 0.8F);
      this.jXl.setText(str);
      this.jXe.setClickable(true);
      this.jXe.setOnClickListener(new LaunchAAUI.18(this));
      this.jXe.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213040);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)LaunchAAUI.A(LaunchAAUI.this).getLayoutParams();
          localLayoutParams.width = (LaunchAAUI.B(LaunchAAUI.this).getWidth() + LaunchAAUI.C(LaunchAAUI.this).getWidth());
          localLayoutParams.height = LaunchAAUI.B(LaunchAAUI.this).getHeight();
          LaunchAAUI.A(LaunchAAUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(213040);
        }
      });
      AppMethodBeat.o(63674);
      return;
      str = getString(2131762189);
      continue;
      str = getString(2131762188);
    }
  }
  
  private void bmN()
  {
    AppMethodBeat.i(213072);
    Log.i("MicroMsg.Aa.LaunchAAUI", "switchMode");
    this.jWZ = false;
    if (this.mode == com.tencent.mm.plugin.aa.model.a.jRK) {
      if (this.jWY == 4)
      {
        this.jXt.setVisibility(8);
        this.jXz.setVisibility(0);
        this.jXA.setVisibility(8);
        this.jXv.setVisibility(0);
        List localList = i.SA(this.chatroomName);
        this.jXz.setText(getString(2131762165, new Object[] { Integer.valueOf(localList.size()) }));
        this.jXd.setText(2131762159);
        this.jXq.setVisibility(8);
        this.jXr.setVisibility(8);
        this.jXb.setText(getString(2131762169, new Object[] { Integer.valueOf(0) }));
        if ((this.jXB != null) && (this.jXB.size() > com.tencent.mm.plugin.aa.model.e.bmf()))
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(8) });
          this.jWZ = true;
        }
        if (!this.jWZ) {
          break label323;
        }
        SE(getString(2131762164, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bmf()) }));
        label242:
        uZ(5);
      }
    }
    for (;;)
    {
      hideTenpayKB();
      hideVKB();
      bmM();
      bmR();
      bmQ();
      g(this.jXw, this.jXx);
      AppMethodBeat.o(213072);
      return;
      this.jXt.setVisibility(0);
      this.jXz.setVisibility(8);
      this.jXA.setVisibility(0);
      this.jXv.setVisibility(8);
      break;
      label323:
      bmP();
      break label242;
      this.mode = com.tencent.mm.plugin.aa.model.a.jRJ;
      this.jXq.setVisibility(0);
      this.jXr.setVisibility(0);
      this.jXt.setVisibility(8);
      this.jXv.setVisibility(8);
      this.jXz.setVisibility(8);
      this.jXb.setText(2131762152);
      g(this.jXw, this.jXx);
      this.jWZ = false;
      if (this.jXs.size() > com.tencent.mm.plugin.aa.model.e.bmg())
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(8) });
        this.jWZ = true;
      }
      bmS();
      uZ(4);
    }
  }
  
  private void bmO()
  {
    AppMethodBeat.i(63675);
    this.jXn.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(213041);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 3))
        {
          WalletFormView.a(LaunchAAUI.D(LaunchAAUI.this).getContentEt(), str, i + 3, j);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((LaunchAAUI.E(LaunchAAUI.this) == null) || (LaunchAAUI.E(LaunchAAUI.this).size() <= 0)) {
            break label283;
          }
          d = d * 100.0D / LaunchAAUI.E(LaunchAAUI.this).size();
          LaunchAAUI.y(LaunchAAUI.this);
          if (d <= com.tencent.mm.plugin.aa.model.e.bmh()) {
            break label283;
          }
          LaunchAAUI.a(LaunchAAUI.this, true);
          com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          LaunchAAUI.e(LaunchAAUI.this);
          LaunchAAUI.F(LaunchAAUI.this);
          LaunchAAUI.G(LaunchAAUI.this);
          LaunchAAUI.this.uZ(3);
          AppMethodBeat.o(213041);
          return;
          if (i > 6)
          {
            WalletFormView.a(LaunchAAUI.D(LaunchAAUI.this).getContentEt(), str, 6, i);
            break;
          }
          if ((i != -1) || (j <= 6)) {
            break;
          }
          WalletFormView.a(LaunchAAUI.D(LaunchAAUI.this).getContentEt(), str, 6, j);
          break;
          label283:
          LaunchAAUI.a(LaunchAAUI.this, false);
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    setEditFocusListener(this.jXn, 2, false, true);
    this.jXn.setmContentAbnormalMoneyCheck(true);
    Object localObject;
    if (bmE())
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jXB.keySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((String)localIterator.next());
      }
      this.jXp.setText(getString(2131762153, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      this.jXs = ((List)localObject);
    }
    for (;;)
    {
      this.jXq.setOnClickListener(new LaunchAAUI.21(this, (List)localObject));
      this.jWZ = false;
      AppMethodBeat.o(63675);
      return;
      if (com.tencent.mm.model.ab.Eq(this.chatroomName)) {
        if (!com.tencent.mm.model.ab.Iz(this.chatroomName)) {
          localObject = i.SA(this.chatroomName);
        }
      }
      for (;;)
      {
        this.jXs = ((List)localObject);
        if (this.jXs.size() <= com.tencent.mm.plugin.aa.model.e.bmg()) {
          break label299;
        }
        this.jXs.clear();
        this.jXp.setText(getString(2131763832));
        bmQ();
        break;
        localObject = bmU();
        continue;
        Log.i("MicroMsg.Aa.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
        localObject = new ArrayList();
        ((List)localObject).add(z.aTY());
        ((List)localObject).add(this.chatroomName);
      }
      label299:
      if (com.tencent.mm.model.ab.Eq(this.chatroomName))
      {
        if (!com.tencent.mm.model.ab.Iz(this.chatroomName)) {
          this.jXp.setText(getString(2131762147, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        } else {
          this.jXp.setText(getString(2131762153, new Object[] { Integer.valueOf(((List)localObject).size()) }));
        }
      }
      else {
        this.jXp.setText(getString(2131762153, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      }
    }
  }
  
  private void bmP()
  {
    AppMethodBeat.i(63677);
    this.jXJ = false;
    if (this.jXE.getVisibility() != 8)
    {
      this.jXE.startAnimation(AnimationUtils.loadAnimation(this, 2130772110));
      this.jXE.setVisibility(8);
    }
    AppMethodBeat.o(63677);
  }
  
  private void bmQ()
  {
    AppMethodBeat.i(63678);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.jRJ)
    {
      if (Util.isNullOrNil(this.jXn.getText()))
      {
        gg(false);
        AppMethodBeat.o(63678);
        return;
      }
      if (this.jWF)
      {
        gg(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.jXs == null) || (this.jXs.size() == 0))
      {
        gg(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.jXs.size() > com.tencent.mm.plugin.aa.model.e.bmg()) || (this.jWZ))
      {
        gg(false);
        AppMethodBeat.o(63678);
        return;
      }
      double d = i.a(this.jXn.getText(), this.jXs.size(), 5, 4);
      Log.d("MicroMsg.Aa.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.jXn.getText(), Integer.valueOf(this.jXs.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "less than 0.01");
        gg(false);
        AppMethodBeat.o(63678);
      }
    }
    else
    {
      if (this.jWY == 4)
      {
        gg(true);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.jXB == null) || (this.jXB.size() == 0))
      {
        gg(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.jXB.size() > com.tencent.mm.plugin.aa.model.e.bmg()) || (this.jWZ))
      {
        gg(false);
        AppMethodBeat.o(63678);
        return;
      }
    }
    gg(true);
    AppMethodBeat.o(63678);
  }
  
  private void bmR()
  {
    AppMethodBeat.i(63680);
    if (this.mode == com.tencent.mm.plugin.aa.model.a.jRJ)
    {
      if ((this.jXs != null) && (this.jXs.size() > 0))
      {
        d = i.a(this.jXn.getText(), this.jXs.size(), 2, 2);
        this.jUP.setText(getString(2131755022, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.jXb.setText(2131762152);
        this.jUP.setVisibility(0);
        this.jXc.setVisibility(0);
        this.jXb.setVisibility(0);
        AppMethodBeat.o(63680);
        return;
        this.jUP.setText(getString(2131755027));
      }
    }
    if (this.jWY == 4)
    {
      this.jUP.setVisibility(4);
      this.jXc.setVisibility(4);
      this.jXb.setVisibility(4);
      AppMethodBeat.o(63680);
      return;
    }
    if ((this.jXB == null) || (this.jXB.size() == 0))
    {
      this.jXb.setText(getString(2131762169, new Object[] { Integer.valueOf(0) }));
      this.jUP.setText(getString(2131755027));
      this.jUP.setVisibility(0);
      this.jXc.setVisibility(0);
      this.jXb.setVisibility(0);
      AppMethodBeat.o(63680);
      return;
    }
    Iterator localIterator = this.jXB.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.jUP.setText(getString(2131755022, new Object[] { Double.valueOf(d) }));
    this.jXb.setText(getString(2131762169, new Object[] { Integer.valueOf(this.jXB.size()) }));
    this.jXw.setVisibility(0);
    this.jUP.setVisibility(0);
    this.jXc.setVisibility(0);
    this.jXb.setVisibility(0);
    AppMethodBeat.o(63680);
  }
  
  private void bmS()
  {
    AppMethodBeat.i(63688);
    if ((this.jWZ) && (!this.jXJ))
    {
      if (this.mode == com.tencent.mm.plugin.aa.model.a.jRJ)
      {
        SE(getString(2131762164, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bmg()) }));
        AppMethodBeat.o(63688);
        return;
      }
      SE(getString(2131762164, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bmf()) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((this.jWF) && (!this.jXJ))
    {
      SE(getString(2131762183, new Object[] { Float.valueOf((float)com.tencent.mm.plugin.aa.model.e.bmh() / 100.0F) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((!this.jWZ) && (!this.jWF)) {
      bmP();
    }
    AppMethodBeat.o(63688);
  }
  
  private void bmT()
  {
    AppMethodBeat.i(63689);
    int i;
    if ((this.jXB != null) && (this.jXB.size() > 0))
    {
      this.jXy.setText(getString(2131762171, new Object[] { Integer.valueOf(this.jXB.size()) }));
      this.jXy.setTextColor(getResources().getColor(2131100904));
      i = (int)getResources().getDimension(2131165629);
      getResources().getDimension(2131165626);
      getResources().getDimension(2131165627);
      this.jXA.setPadding(i, i, i, i);
      this.jXA.setBackgroundResource(2131233301);
      this.jXu.setVisibility(0);
    }
    for (;;)
    {
      this.jXu.removeAllViews();
      this.jXC.clear();
      if ((this.jXB == null) || (this.jXB.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jXB.keySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        double d = ((Double)this.jXB.get(str)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (i >= this.jXB.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        localLaunchAAByPersonNameAmountRow.a(str, this.chatroomName, d);
        this.jXu.addView(localLaunchAAByPersonNameAmountRow);
        this.jXC.put(str, localLaunchAAByPersonNameAmountRow);
        i += 1;
      }
      this.jXy.setText(2131762170);
      this.jXy.setTextColor(getResources().getColor(2131099858));
      i = (int)getResources().getDimension(2131165629);
      this.jXA.setPadding(i, i, i, i);
      this.jXA.setBackgroundResource(2131233304);
      this.jXu.setVisibility(8);
    }
    if (this.jWj != null)
    {
      this.jWj.requestLayout();
      g(this.jXw, this.jXx);
    }
    this.jXI = 0;
    this.jXm.post(new Runnable()
    {
      public final void run() {}
    });
    AppMethodBeat.o(63689);
  }
  
  private List<String> bmU()
  {
    AppMethodBeat.i(213076);
    ArrayList localArrayList = new ArrayList();
    Object localObject = i.SA(this.chatroomName);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!as.bjp(str)) {
          localArrayList.add(str);
        }
      }
    }
    AppMethodBeat.o(213076);
    return localArrayList;
  }
  
  private void bmW()
  {
    AppMethodBeat.i(213079);
    if (bmE())
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "fromThirdParty(),user launch by person mode");
      this.mode = com.tencent.mm.plugin.aa.model.a.jRK;
      this.jWY = 5;
      AppMethodBeat.o(213079);
      return;
    }
    if (bmJ())
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "fromOrderDetail(),user launch by money mode");
      this.mode = com.tencent.mm.plugin.aa.model.a.jRJ;
      AppMethodBeat.o(213079);
      return;
    }
    int i = com.tencent.mm.plugin.aa.model.e.bmi();
    Log.i("MicroMsg.Aa.LaunchAAUI", "defaultMode is ：%s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 2: 
    default: 
      this.mode = com.tencent.mm.plugin.aa.model.a.jRJ;
    }
    while ((!bmX()) && (this.mode == com.tencent.mm.plugin.aa.model.a.jRK))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "!isOpenAAPayCustomize() && mode == AAConstants.MODE_LAUNCH_BY_PERSON");
      this.jWY = 5;
      AppMethodBeat.o(213079);
      return;
      this.mode = com.tencent.mm.plugin.aa.model.a.jRK;
      this.jWY = 4;
      continue;
      this.mode = com.tencent.mm.plugin.aa.model.a.jRK;
      this.jWY = 5;
    }
    if ((this.mode == com.tencent.mm.plugin.aa.model.a.jRK) && (bmE()))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "mode == AAConstants.MODE_LAUNCH_BY_PERSON && fromThirdParty()");
      this.jWY = 5;
      AppMethodBeat.o(213079);
      return;
    }
    AppMethodBeat.o(213079);
  }
  
  private static boolean bmX()
  {
    AppMethodBeat.i(213080);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saf, false);
    Log.i("MicroMsg.Aa.LaunchAAUI", "aaPayCustomizeOpen switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(213080);
    return bool;
  }
  
  private void g(final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(213081);
    this.jXu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213068);
        int i = com.tencent.mm.cb.a.fromDPToPix(LaunchAAUI.this.getContext(), 48);
        int j = com.tencent.mm.cb.a.fromDPToPix(LaunchAAUI.this.getContext(), 64);
        int k = com.tencent.mm.cb.a.fromDPToPix(LaunchAAUI.this.getContext(), 96);
        if (LaunchAAUI.a(LaunchAAUI.this, paramView2))
        {
          localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
          localLayoutParams1.removeRule(12);
          localLayoutParams1.addRule(3, 2131309323);
          localLayoutParams1.topMargin = i;
          paramView1.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(213068);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(3);
        localLayoutParams1.addRule(12);
        localLayoutParams1.bottomMargin = k;
        paramView1.setLayoutParams(localLayoutParams1);
        if (LaunchAAUI.h(paramView1, paramView2) >= i)
        {
          AppMethodBeat.o(213068);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(3);
        localLayoutParams2.addRule(12);
        localLayoutParams2.bottomMargin = j;
        paramView1.setLayoutParams(localLayoutParams2);
        if (LaunchAAUI.h(paramView1, paramView2) >= i)
        {
          AppMethodBeat.o(213068);
          return;
        }
        localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(12);
        localLayoutParams1.addRule(3, 2131309323);
        localLayoutParams1.topMargin = i;
        paramView1.setLayoutParams(localLayoutParams1);
        AppMethodBeat.o(213068);
      }
    }, 100L);
    AppMethodBeat.o(213081);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(258343);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("aa_pay");
    AppMethodBeat.o(258343);
    return localMultiProcessMMKV;
  }
  
  private void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(63679);
    this.jXD.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.jXb.setTextColor(getResources().getColor(2131099748));
      this.jUP.setTextColor(getResources().getColor(2131099859));
      this.jXc.setTextColor(getResources().getColor(2131099859));
      AppMethodBeat.o(63679);
      return;
    }
    this.jXb.setTextColor(getResources().getColor(2131099748));
    this.jUP.setTextColor(getResources().getColor(2131100904));
    this.jXc.setTextColor(getResources().getColor(2131100904));
    AppMethodBeat.o(63679);
  }
  
  private void x(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63672);
    Log.i("MicroMsg.Aa.LaunchAAUI", "go to contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("Select_block_List", z.aTY());
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
    if (this.mode == com.tencent.mm.plugin.aa.model.a.jRJ)
    {
      paramArrayList = new StringBuilder();
      localObject = this.jXs.iterator();
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
      if (bmE()) {
        localIntent.putExtra("key_title", this.jXa.getText().toString());
      }
      com.tencent.mm.br.c.b(getContext(), "remittance", ".ui.SelectRemittanceContactUI", localIntent, 320);
      uZ(10);
      AppMethodBeat.o(63672);
      return;
      paramArrayList = new StringBuilder();
      localObject = this.jXB.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.append((String)((Iterator)localObject).next()).append(",");
      }
      if (paramArrayList.length() - 1 >= 0) {
        paramArrayList.deleteCharAt(paramArrayList.length() - 1);
      }
      localIntent.putExtra("key_include_username_list", paramArrayList.toString());
    }
  }
  
  private void y(ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> paramArrayList)
  {
    AppMethodBeat.i(213074);
    this.jXB.clear();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        NetSceneNewAAQueryPFInfo.AALaunchItemParcel localAALaunchItemParcel = (NetSceneNewAAQueryPFInfo.AALaunchItemParcel)paramArrayList.next();
        this.jXB.put(localAALaunchItemParcel.username, Double.valueOf(localAALaunchItemParcel.eht / 100.0D));
      }
    }
    AppMethodBeat.o(213074);
  }
  
  public final String bmV()
  {
    AppMethodBeat.i(213078);
    String str = aa.z(new com.tencent.mm.vfs.o(getContext().getCacheDir() + "/aaTempPho", "aa_share_bitmap.jpg").her());
    AppMethodBeat.o(213078);
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
    return 2131495161;
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
    label223:
    double d;
    if (paramInt1 == 233)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (this.mode == com.tencent.mm.plugin.aa.model.a.jRJ)
        {
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.jXs.clear();
            this.jXs.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = i.SA(this.chatroomName);
          if ((paramIntent == null) || (this.jXs == null) || (this.jXs.size() != paramIntent.size()) || (!com.tencent.mm.model.ab.Eq(this.chatroomName))) {
            break label317;
          }
          paramIntent = this.jXp;
          if (this.jXs != null)
          {
            paramInt1 = this.jXs.size();
            paramIntent.setText(getString(2131762147, new Object[] { Integer.valueOf(paramInt1) }));
          }
        }
        else
        {
          bmP();
          if ((this.jXs == null) || (this.jXs.size() <= com.tencent.mm.plugin.aa.model.e.bmg())) {
            break label369;
          }
          this.jWZ = true;
          d = Util.getDouble(this.jXn.getText(), 0.0D);
          if ((this.jXs == null) || (d * 100.0D / this.jXs.size() <= com.tencent.mm.plugin.aa.model.e.bmh())) {
            break label377;
          }
          this.jWF = true;
          com.tencent.mm.plugin.report.service.h.CyF.a(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          bmQ();
          bmR();
          bmS();
          AppMethodBeat.o(63690);
          return;
          paramInt1 = 0;
          break;
          label317:
          paramIntent = this.jXp;
          if (this.jXs != null) {}
          for (paramInt1 = this.jXs.size();; paramInt1 = 0)
          {
            paramIntent.setText(getString(2131762153, new Object[] { Integer.valueOf(paramInt1) }));
            break;
          }
          label369:
          this.jWZ = false;
          break label223;
          label377:
          this.jWF = false;
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
            this.jXB.clear();
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext())
              {
                localObject = ((String)paramIntent.next()).split(",");
                d = Util.getDouble(localObject[1], 0.0D);
                this.jXB.put(localObject[0], Double.valueOf(d));
              }
            }
            bmL();
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
              break label702;
            }
            paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.aSY());
            if (Util.isNullOrNil(paramIntent)) {}
          }
          label702:
          for (this.imagePath = paramIntent;; this.imagePath = ((String)((ArrayList)localObject).get(0)))
          {
            if (!Util.isNullOrNil(this.imagePath))
            {
              this.jUB = 2;
              this.jXk.setVisibility(0);
              this.jXi.setVisibility(8);
              this.jXj.setVisibility(8);
              MMBitmapFactory.decodeFile(this.imagePath);
              this.jXk.post(new LaunchAAUI.33(this));
              uZ(8);
            }
            Log.i("MicroMsg.Aa.LaunchAAUI", "SELECT_IMAGE_REQUEST_CODE imagePath:%s", new Object[] { this.imagePath });
            if (this.jXk.getVisibility() != 0) {
              break;
            }
            this.jXh.setClickable(false);
            AppMethodBeat.o(63690);
            return;
          }
          this.jXh.setClickable(true);
          AppMethodBeat.o(63690);
          return;
        }
        if (paramInt1 == 310)
        {
          if (paramInt2 == -1)
          {
            this.jUB = 2;
            this.imagePath = "";
            this.jXk.setVisibility(8);
            this.jXi.setVisibility(0);
            this.jXj.setVisibility(0);
            uZ(7);
          }
          if (this.jXk.getVisibility() == 0)
          {
            this.jXh.setClickable(false);
            AppMethodBeat.o(63690);
            return;
          }
          this.jXh.setClickable(true);
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
    setBackBtn(new LaunchAAUI.12(this));
    this.timestamp = (System.currentTimeMillis() / 1000L);
    setMMTitle(2131762196);
    this.scene = getIntent().getIntExtra("enter_scene", 1);
    label251:
    int i;
    if (bmE())
    {
      this.jXN = ((NetSceneNewAAQueryPFInfo.PfInfoParcel)getIntent().getParcelableExtra("pfInfo"));
      this.jWm = getIntent().getStringExtra("pfOrderNo");
      if (this.jXN == null)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "pfInfoParcel is null!!!");
        finish();
        AppMethodBeat.o(63669);
        return;
      }
      this.mode = com.tencent.mm.plugin.aa.model.a.jRK;
      this.jWY = 5;
      this.jXL = this.jXN.eht;
      this.jXM = this.jXN.remark;
      uZ(1);
      if (!bmE()) {
        break label1529;
      }
      this.jXG = new com.tencent.mm.plugin.aa.model.e(this.jXN.jTE.jTy, this.jXN.jTE.jTx);
      if ((!Util.isNullOrNil(this.jXG.jSw)) && (!Util.isNullOrNil(this.jXG.jSv))) {
        bY(this.jXG.jSw, this.jXG.jSv);
      }
      this.chatroomName = getIntent().getStringExtra("chatroom_name");
      if (Util.isNullOrNil(this.chatroomName))
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "chatroomName is null!!!");
        this.chatroomName = "";
      }
      paramBundle = this.chatroomName;
      if (Util.isNullOrNil(paramBundle)) {
        break label1624;
      }
      if (!com.tencent.mm.model.ab.Eq(paramBundle)) {
        break label1576;
      }
      label309:
      this.chatroomName = paramBundle;
      this.jWj = findViewById(2131307160);
      this.jXl = ((TextView)findViewById(2131303035));
      this.jXe = ((LinearLayout)findViewById(2131303034));
      this.jXf = ((ImageView)findViewById(2131303036));
      this.jXD = ((Button)findViewById(2131303018));
      this.jXE = ((TextView)findViewById(2131303015));
      this.jXF = ((TextView)findViewById(2131303042));
      this.jXa = ((MMEditText)findViewById(2131303037));
      this.jXb = ((TextView)findViewById(2131303040));
      this.jUP = ((TextView)findViewById(2131303016));
      this.jXc = ((TextView)findViewById(2131303017));
      this.jXg = ((RelativeLayout)findViewById(2131305910));
      this.jXh = ((LinearLayout)findViewById(2131305920));
      this.jXi = ((ImageView)findViewById(2131305998));
      this.jXj = ((TextView)findViewById(2131305999));
      this.jXk = ((ImageView)findViewById(2131299204));
      this.jXd = ((TextView)findViewById(2131303046));
      this.jXm = ((TextView)findViewById(2131296290));
      this.jXn = ((WalletFormView)findViewById(2131303039));
      this.jXp = ((TextView)findViewById(2131303019));
      this.jXo = ((TextView)findViewById(2131303020));
      this.jXq = ((ViewGroup)findViewById(2131303045));
      this.jXr = ((ViewGroup)findViewById(2131303044));
      this.jXy = ((TextView)findViewById(2131303024));
      this.jXy.setText(2131762170);
      this.jXy.setTextColor(getResources().getColor(2131099749));
      this.jXt = ((ViewGroup)findViewById(2131303050));
      this.jXu = ((ViewGroup)findViewById(2131303051));
      this.jXA = ((ViewGroup)findViewById(2131303023));
      this.jXv = ((ViewGroup)findViewById(2131303048));
      this.jXw = ((ViewGroup)findViewById(2131303041));
      this.jXx = ((ViewGroup)findViewById(2131309323));
      this.jXz = ((TextView)findViewById(2131303049));
      this.jWj.setOnTouchListener(new LaunchAAUI.23(this));
      bmN();
      bmM();
      bmK();
      this.jXD.setOnClickListener(new LaunchAAUI.34(this));
      this.jXm.setClickable(true);
      this.jXm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
      paramBundle = new SpannableString(getString(2131757550));
      paramBundle.setSpan(new a(new LaunchAAUI.41(this)), 0, paramBundle.length(), 18);
      this.jXm.setText(paramBundle);
      this.jXm.setVisibility(8);
      this.jXa.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63664);
          LaunchAAUI.e(LaunchAAUI.this);
          LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.f(LaunchAAUI.this), LaunchAAUI.g(LaunchAAUI.this));
          LaunchAAUI.this.uZ(6);
          AppMethodBeat.o(63664);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.jXa.setOnTouchListener(new LaunchAAUI.43(this));
      this.jXa.setOnFocusChangeListener(new LaunchAAUI.44(this));
      bmO();
      this.jXA.setOnClickListener(new LaunchAAUI.45(this));
      if (!Util.isNullOrNil(this.jXM))
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "default title: %s", new Object[] { this.jXM });
        this.jXa.setText(this.jXM);
        if (this.jXM.length() <= 20) {
          break label1630;
        }
        i = 20;
        label1014:
        this.jXa.setSelection(i);
      }
      if (!bmE()) {
        break label1641;
      }
      paramBundle = String.format("%.2f", new Object[] { Double.valueOf(this.jXL / 100.0D) });
      this.jXn.setText(paramBundle);
      this.jXn.setSelection(paramBundle.length());
      label1074:
      bmQ();
      View localView;
      if ((bmE()) && (MultiProcessMMKV.getMMKV("aa_pay").getBoolean("new_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        localView = getLayoutInflater().inflate(2131492900, null);
        localView.findViewById(2131302464).setOnClickListener(new LaunchAAUI.5(this, paramBundle));
        paramBundle.HLX = new LaunchAAUI.6(this, paramBundle, localView);
        paramBundle.Dm(true);
        paramBundle.dGm();
      }
      if ((com.tencent.mm.model.ab.Iz(this.chatroomName)) && (MultiProcessMMKV.getMMKV("aa_pay").getBoolean("new_open_IM_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        localView = getLayoutInflater().inflate(2131492900, null);
        ((TextView)localView.findViewById(2131296293)).setText(getString(2131762186));
        ((TextView)localView.findViewById(2131296292)).setText(getString(2131762185));
        localView.findViewById(2131302464).setOnClickListener(new LaunchAAUI.7(this, paramBundle));
        paramBundle.HLX = new LaunchAAUI.8(this, paramBundle, localView);
        paramBundle.Dm(true);
        paramBundle.dGm();
      }
      if (!bmE()) {
        break label1773;
      }
      this.jXg.setVisibility(0);
      this.jXg.setOnClickListener(new LaunchAAUI.9(this));
      this.jXk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213031);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (LaunchAAUI.l(LaunchAAUI.this) == null) {
            LaunchAAUI.a(LaunchAAUI.this, com.tencent.mm.ui.base.h.a(LaunchAAUI.this, 3, 2131821007, LaunchAAUI.this.getString(2131762446), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(213029);
                if ((LaunchAAUI.l(LaunchAAUI.this) != null) && (LaunchAAUI.l(LaunchAAUI.this).isShowing())) {
                  LaunchAAUI.l(LaunchAAUI.this).dismiss();
                }
                AppMethodBeat.o(213029);
              }
            }));
          }
          if (!Util.isNullOrNil(LaunchAAUI.m(LaunchAAUI.this))) {
            q.bcU().a(LaunchAAUI.m(LaunchAAUI.this), new r.a()
            {
              public final void a(String paramAnonymous2String1, Bitmap paramAnonymous2Bitmap, String paramAnonymous2String2)
              {
                AppMethodBeat.i(213030);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous2String1, paramAnonymous2String2 });
                if ((LaunchAAUI.l(LaunchAAUI.this) != null) && (LaunchAAUI.l(LaunchAAUI.this).isShowing())) {
                  LaunchAAUI.l(LaunchAAUI.this).dismiss();
                }
                if (paramAnonymous2Bitmap != null)
                {
                  paramAnonymous2String1 = new Intent();
                  paramAnonymous2String1.putExtra("use_scene", 1);
                  paramAnonymous2String1.putExtra("scene", LaunchAAUI.n(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("path", LaunchAAUI.o(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("url", LaunchAAUI.m(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("view_info", ViewAnimHelper.q(LaunchAAUI.p(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
                  com.tencent.mm.br.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous2String1, 310);
                  LaunchAAUI.this.uZ(14);
                  AppMethodBeat.o(213030);
                  return;
                }
                Toast.makeText(LaunchAAUI.this, 2131755042, 1).show();
                AppMethodBeat.o(213030);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213031);
            return;
            Log.i("MicroMsg.Aa.LaunchAAUI", "imageUrl == null");
            if ((LaunchAAUI.l(LaunchAAUI.this) != null) && (LaunchAAUI.l(LaunchAAUI.this).isShowing())) {
              LaunchAAUI.l(LaunchAAUI.this).dismiss();
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("use_scene", 1);
            LaunchAAUI.q(LaunchAAUI.this);
            paramAnonymousView.putExtra("scene", LaunchAAUI.n(LaunchAAUI.this));
            paramAnonymousView.putExtra("path", LaunchAAUI.o(LaunchAAUI.this));
            paramAnonymousView.putExtra("view_info", ViewAnimHelper.q(LaunchAAUI.p(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
            com.tencent.mm.br.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymousView, 310);
            LaunchAAUI.this.uZ(14);
          }
        }
      });
      if ((this.jXN == null) || (Util.isNullOrNil(this.jXN.jTB))) {
        break label1734;
      }
      this.jUB = 1;
      this.imageUrl = this.jXN.jTB;
      this.jXk.setVisibility(0);
      this.jXi.setVisibility(8);
      this.jXj.setVisibility(8);
      q.bcU().a(this.jXN.jTB, this.jXN.jTD, new r.a()
      {
        public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
        {
          boolean bool = false;
          AppMethodBeat.i(213033);
          if (paramAnonymousBitmap == null) {
            bool = true;
          }
          Log.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s bitmap==null:%s path:%s", new Object[] { paramAnonymousString1, Boolean.valueOf(bool), paramAnonymousString2 });
          LaunchAAUI.a(LaunchAAUI.this, paramAnonymousString2);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213032);
              if (paramAnonymousBitmap != null)
              {
                LaunchAAUI.p(LaunchAAUI.this).setImageBitmap(paramAnonymousBitmap);
                AppMethodBeat.o(213032);
                return;
              }
              LaunchAAUI.q(LaunchAAUI.this);
              LaunchAAUI.p(LaunchAAUI.this).setVisibility(8);
              LaunchAAUI.r(LaunchAAUI.this).setVisibility(0);
              LaunchAAUI.s(LaunchAAUI.this).setVisibility(0);
              AppMethodBeat.o(213032);
            }
          });
          AppMethodBeat.o(213033);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      if ((bmE()) && (this.jXP != null)) {
        this.jXP.alive();
      }
      AppMethodBeat.o(63669);
      return;
      bmW();
      this.jXK = getIntent().getStringExtra("amount");
      this.jXM = getIntent().getStringExtra("title");
      break;
      label1529:
      paramBundle = this.jWX.jUd;
      com.tencent.mm.vending.g.g.hdG().c(paramBundle).f(new com.tencent.mm.vending.c.a() {}).a(new LaunchAAUI.15(this));
      break label251;
      label1576:
      paramBundle = Util.stringsToList(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(z.aTY());
        if (paramBundle.size() > 0)
        {
          paramBundle = (String)paramBundle.get(0);
          break label309;
        }
      }
      label1624:
      paramBundle = "";
      break label309;
      label1630:
      i = this.jXM.length();
      break label1014;
      label1641:
      if (Util.isNullOrNil(this.jXK)) {
        break label1074;
      }
      Log.i("MicroMsg.Aa.LaunchAAUI", "default amount: %s", new Object[] { this.jXK });
      paramBundle = f.a(new StringBuilder().append(this.jXK).toString(), "100", 2, RoundingMode.HALF_UP);
      this.jXn.setText(paramBundle);
      this.jXn.setSelection(paramBundle.length());
      break label1074;
      label1734:
      this.jUB = 2;
      this.imagePath = "";
      this.jXk.setVisibility(8);
      this.jXi.setVisibility(0);
      this.jXj.setVisibility(0);
      continue;
      label1773:
      this.jXg.setVisibility(0);
      this.jXk.setVisibility(8);
      this.jXi.setVisibility(0);
      this.jXj.setVisibility(0);
      this.jXh.setOnClickListener(new LaunchAAUI.13(this));
      this.jXk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213035);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("use_scene", 1);
          paramAnonymousView.putExtra("scene", LaunchAAUI.n(LaunchAAUI.this));
          paramAnonymousView.putExtra("path", LaunchAAUI.o(LaunchAAUI.this));
          paramAnonymousView.putExtra("url", LaunchAAUI.m(LaunchAAUI.this));
          paramAnonymousView.putExtra("view_info", ViewAnimHelper.q(LaunchAAUI.p(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
          com.tencent.mm.br.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymousView, 310);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213035);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63687);
    super.onDestroy();
    if ((bmE()) && (this.jXP != null)) {
      this.jXP.dead();
    }
    AppMethodBeat.o(63687);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(63686);
    super.onStop();
    if (this.jXC != null) {
      this.jXC.clear();
    }
    AppMethodBeat.o(63686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void uZ(int paramInt)
  {
    AppMethodBeat.i(63691);
    if (bmE()) {
      i.uZ(paramInt);
    }
    AppMethodBeat.o(63691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */