package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
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
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nn;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.aa.model.b.e.b;
import com.tencent.mm.plugin.aa.model.b.e.c;
import com.tencent.mm.plugin.aa.model.b.e.d;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AALaunchItemParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AAOperationInfoParcel;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.PfInfoParcel;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
  private com.tencent.mm.ui.tools.i lKz;
  private int mode;
  private int msK;
  private TextView pIK;
  private Dialog pIQ;
  private int pIw;
  private Dialog pIx;
  private com.tencent.mm.plugin.aa.model.b.e pKR;
  private int pKS;
  private boolean pKT;
  private MMEditText pKU;
  private TextView pKV;
  private TextView pKW;
  private TextView pKX;
  private LinearLayout pKY;
  private ImageView pKZ;
  private String pKg;
  private boolean pKz;
  private int pLA;
  private int pLB;
  private boolean pLC;
  private String pLD;
  private long pLE;
  private String pLF;
  private NetSceneNewAAQueryPFInfo.PfInfoParcel pLG;
  private boolean pLH;
  private IListener<nn> pLI;
  private int pLJ;
  private ScrollView pLK;
  private View pLL;
  private WcPayBannerView pLM;
  private RelativeLayout pLa;
  private LinearLayout pLb;
  private ImageView pLc;
  private TextView pLd;
  private ImageView pLe;
  private TextView pLf;
  private ViewGroup pLg;
  private WalletFormView pLh;
  private TextView pLi;
  private TextView pLj;
  private ViewGroup pLk;
  private ViewGroup pLl;
  private List<String> pLm;
  private ViewGroup pLn;
  private ViewGroup pLo;
  private ViewGroup pLp;
  private ViewGroup pLq;
  private ViewGroup pLr;
  private TextView pLs;
  private TextView pLt;
  private ViewGroup pLu;
  private Map<String, Double> pLv;
  private Map<String, LaunchAAByPersonNameAmountRow> pLw;
  private Button pLx;
  private TextView pLy;
  private com.tencent.mm.plugin.aa.model.f pLz;
  private int scene;
  private long timestamp;
  private Dialog tipDialog;
  
  public LaunchAAUI()
  {
    AppMethodBeat.i(63668);
    this.pKR = ((com.tencent.mm.plugin.aa.model.b.e)aI(com.tencent.mm.plugin.aa.model.b.e.class));
    this.mode = com.tencent.mm.plugin.aa.model.b.pFF;
    this.pKS = 4;
    this.chatroomName = null;
    this.pKT = false;
    this.pKz = false;
    this.pLm = new ArrayList();
    this.pLv = new HashMap();
    this.pLw = new HashMap();
    this.pLz = new com.tencent.mm.plugin.aa.model.f();
    this.pLA = 0;
    this.pLB = 0;
    this.pLC = false;
    this.timestamp = 0L;
    this.imageUrl = "";
    this.pLG = null;
    this.pLH = false;
    this.pIx = null;
    this.pLI = new LaunchAAUI.1(this, com.tencent.mm.app.f.hfK);
    this.msK = 0;
    this.pLJ = 0;
    AppMethodBeat.o(63668);
  }
  
  private void B(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(63672);
    Log.i("MicroMsg.Aa.LaunchAAUI", "go to contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("Select_block_List", z.bAM());
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
    if (this.mode == com.tencent.mm.plugin.aa.model.b.pFF)
    {
      paramArrayList = new StringBuilder();
      localObject = this.pLm.iterator();
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
      if (bVC()) {
        localIntent.putExtra("key_title", this.pKU.getText().toString());
      }
      com.tencent.mm.br.c.b(getContext(), "remittance", ".ui.SelectRemittanceContactUI", localIntent, 320);
      yj(10);
      AppMethodBeat.o(63672);
      return;
      paramArrayList = new StringBuilder();
      localObject = this.pLv.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.append((String)((Iterator)localObject).next()).append(",");
      }
      if (paramArrayList.length() - 1 >= 0) {
        paramArrayList.deleteCharAt(paramArrayList.length() - 1);
      }
      localIntent.putExtra("key_include_username_list", paramArrayList.toString());
    }
  }
  
  private void C(ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> paramArrayList)
  {
    AppMethodBeat.i(268645);
    this.pLv.clear();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        NetSceneNewAAQueryPFInfo.AALaunchItemParcel localAALaunchItemParcel = (NetSceneNewAAQueryPFInfo.AALaunchItemParcel)paramArrayList.next();
        this.pLv.put(localAALaunchItemParcel.username, Double.valueOf(localAALaunchItemParcel.ihV / 100.0D));
      }
    }
    AppMethodBeat.o(268645);
  }
  
  private void SE(String paramString)
  {
    AppMethodBeat.i(63676);
    this.pLC = true;
    this.pLy.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(this, a.a.in_from_up);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(268447);
        LaunchAAUI.J(LaunchAAUI.this).sendAccessibilityEvent(128);
        AppMethodBeat.o(268447);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.pLy.startAnimation(localAnimation);
    this.pLy.setText(paramString);
    AppMethodBeat.o(63676);
  }
  
  private void SF(final String paramString)
  {
    AppMethodBeat.i(63681);
    Log.i("MicroMsg.Aa.LaunchAAUI", "showLaunchComfirmDialog() from scene:%s", new Object[] { Integer.valueOf(this.scene) });
    String str = this.pKU.getText().toString();
    if (Util.isNullOrNil(str)) {
      str = getString(a.i.launch_aa_des_default_title);
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.j.class)).a(getController(), paramString, getString(a.i.aa_dialog_sub_title) + str, getString(a.i.aa_dialog_ok_text), new y.a()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(268449);
          if (paramAnonymousBoolean)
          {
            Log.i("MicroMsg.Aa.LaunchAAUI", "click launchDialog confirm，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.e(LaunchAAUI.this)), Integer.valueOf(LaunchAAUI.f(LaunchAAUI.this)) });
            LaunchAAUI.b(LaunchAAUI.this, paramString);
            LaunchAAUI.this.yj(12);
            com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(4) });
            AppMethodBeat.o(268449);
            return;
          }
          Log.i("MicroMsg.Aa.LaunchAAUI", "click launchDialog cancel，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.e(LaunchAAUI.this)), Integer.valueOf(LaunchAAUI.f(LaunchAAUI.this)) });
          LaunchAAUI.this.yj(13);
          AppMethodBeat.o(268449);
        }
      });
      yj(11);
      com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(3) });
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
    boolean bool = cv(com.tencent.mm.plugin.aa.model.j.SA(paramString));
    AppMethodBeat.o(63693);
    return bool;
  }
  
  private boolean SH(String paramString)
  {
    AppMethodBeat.i(268658);
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
        AppMethodBeat.o(268658);
        return false;
      }
      if (localOptions1.outWidth * localOptions1.outHeight < 5242880)
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "dont handle：sizeOption.outWidth * sizeOption.outHeight * 2 < MAX_BITMAP_SIZE");
        AppMethodBeat.o(268658);
        return false;
      }
      int i = localOptions1.outWidth * localOptions1.outHeight / 5242880;
      localOptions2.inSampleSize = i;
      Log.i("MicroMsg.Aa.LaunchAAUI", "need handle：bitmap too large sample:%s", new Object[] { Integer.valueOf(i) });
      paramString = BitmapUtil.rotate(BitmapUtil.decodeFile(paramString, localOptions2), Exif.fromFile(paramString).getOrientationInDegree());
      if (y.ZC(bVS())) {
        y.deleteFile(bVS());
      }
      BitmapUtil.saveBitmapToImage(paramString, 80, Bitmap.CompressFormat.JPEG, bVS(), true);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "decode file to bitmap error! " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(268658);
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
    localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGE, paramString2);
    localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGF, Double.valueOf(100.0D * paramDouble));
    localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGI, paramString1);
    localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGL, Long.valueOf(this.timestamp));
    long l = com.tencent.mm.wallet_core.ui.i.a(com.tencent.mm.plugin.aa.model.j.cs(new StringBuilder().append(paramDouble).toString(), "100"), String.valueOf(paramInt), RoundingMode.CEILING);
    Log.d("MicroMsg.Aa.LaunchAAUI", "perAmount: %s", new Object[] { Long.valueOf(l) });
    if ((l <= 0L) || (l > com.tencent.mm.plugin.aa.model.f.bVh()))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "illegal avgAmount: %s", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(63684);
      return;
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGH, Long.valueOf(l));
    localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGM, paramString3);
    localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGN, paramString4);
    if (!Util.isNullOrNil(this.imagePath))
    {
      paramString2 = com.tencent.mm.b.g.getMD5(this.imagePath);
      localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGP, paramString2);
    }
    if (bVC()) {
      localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGO, this.pKg);
    }
    localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGK, paramList);
    this.pKR.pHU.c(this.mode, localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void onInterrupt(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(268454);
        Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        if (LaunchAAUI.K(LaunchAAUI.this) != null) {
          LaunchAAUI.K(LaunchAAUI.this).dismiss();
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
          com.tencent.mm.ui.base.k.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(a.i.launch_aa_i_know), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(268593);
              Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
              AppMethodBeat.o(268593);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(268454);
          return;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ac)))
          {
            com.tencent.mm.plugin.aa.model.j.a(LaunchAAUI.this.getContext(), (ac)paramAnonymousObject);
          }
          else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
          {
            paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
            String str1 = paramAnonymousObject.wording;
            String str2 = paramAnonymousObject.rGU;
            String str3 = paramAnonymousObject.right_button_wording;
            com.tencent.mm.ui.widget.a.e.a locala = new com.tencent.mm.ui.widget.a.e.a(paramContext);
            locala.bDw(str1);
            locala.bDC(str3).c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182447);
                com.tencent.mm.wallet_core.ui.i.p(LaunchAAUI.this.getContext(), paramAnonymousObject.wYO, false);
                AppMethodBeat.o(182447);
              }
            });
            locala.bDD(str2);
            locala.jHH().show();
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
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.b.class)).jO(7, 5);
    com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.pKU.getText().toString();
        if (Util.isNullOrNil(str1))
        {
          str1 = getString(a.i.launch_aa_des_default_title);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator = this.pLv.keySet().iterator();
          long l1 = 0L;
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if ((!paramBoolean) || (paramList.contains(str2)))
            {
              double d = ((Double)this.pLv.get(str2)).doubleValue();
              com.tencent.mm.protocal.protobuf.m localm = new com.tencent.mm.protocal.protobuf.m();
              localm.ihV = com.tencent.mm.wallet_core.ui.i.qy(String.valueOf(d), "100");
              localm.username = str2;
              localArrayList1.add(localm);
              long l2 = localm.ihV;
              localArrayList2.add(localm.ihV);
              l1 = l2 + l1;
            }
          }
          else
          {
            paramList = new com.tencent.mm.protocal.protobuf.m();
            paramList.username = z.bAM();
            paramList.ihV = l1;
            localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGE, str1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGF, Long.valueOf(l1));
            localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGK, localArrayList1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGI, paramString1);
            localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGL, Long.valueOf(this.timestamp));
            localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGM, paramString2);
            localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGN, paramString3);
            if (!Util.isNullOrNil(this.imagePath))
            {
              paramString2 = com.tencent.mm.b.g.getMD5(this.imagePath);
              localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGP, paramString2);
            }
            if (bVC()) {
              localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGO, this.pKg);
            }
            this.pKR.pHV.H(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
            {
              public final void onInterrupt(final Object paramAnonymousObject)
              {
                AppMethodBeat.i(268421);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
                if (LaunchAAUI.K(LaunchAAUI.this) != null) {
                  LaunchAAUI.K(LaunchAAUI.this).dismiss();
                }
                if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
                  com.tencent.mm.ui.base.k.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(a.i.launch_aa_i_know), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(268533);
                      Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                      AppMethodBeat.o(268533);
                    }
                  });
                }
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(10) });
                  AppMethodBeat.o(268421);
                  return;
                  if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ac)))
                  {
                    com.tencent.mm.plugin.aa.model.j.a(LaunchAAUI.this.getContext(), (ac)paramAnonymousObject);
                  }
                  else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
                  {
                    paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
                    String str1 = paramAnonymousObject.wording;
                    String str2 = paramAnonymousObject.rGU;
                    String str3 = paramAnonymousObject.right_button_wording;
                    com.tencent.mm.ui.widget.a.e.a locala = new com.tencent.mm.ui.widget.a.e.a(paramContext);
                    locala.bDw(str1);
                    locala.bDC(str3).c(new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(268534);
                        com.tencent.mm.wallet_core.ui.i.p(LaunchAAUI.this.getContext(), paramAnonymousObject.wYO, false);
                        AppMethodBeat.o(268534);
                      }
                    });
                    locala.bDD(str2);
                    locala.jHH().show();
                  }
                  else
                  {
                    Toast.makeText(paramContext, a.i.launch_aa_failed, 1).show();
                  }
                }
              }
            });
            com.tencent.mm.plugin.report.service.h.OAn.b(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.aa.model.j.SA(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, Util.listToString(localArrayList2, ",") });
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
    yj(9);
    if (this.mode == com.tencent.mm.plugin.aa.model.b.pFF)
    {
      if (Util.isNullOrNil(this.pLh.getText()))
      {
        AppMethodBeat.o(63682);
        return;
      }
      if ((this.pLm == null) || (this.pLm.size() == 0))
      {
        AppMethodBeat.o(63682);
        return;
      }
      bVM();
      com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
      if ((paramBoolean) && (paramArrayList == null)) {}
    }
    for (;;)
    {
      try
      {
        i = paramArrayList.size();
        final double d = Util.getDouble(this.pIK.getText().toString(), 0.0D) * i;
        String str2 = this.pKU.getText().toString();
        final String str1 = str2;
        if (Util.isNullOrNil(str2)) {
          str1 = getString(a.i.launch_aa_des_default_title);
        }
        if (i > 0)
        {
          if (this.pIQ != null) {
            this.pIQ.dismiss();
          }
          this.pIQ = com.tencent.mm.wallet_core.ui.l.c(paramContext, false, null);
          if (!Util.isNullOrNil(this.imagePath)) {
            new com.tencent.mm.plugin.aa.model.e(this.imagePath, new com.tencent.mm.plugin.aa.model.e.a()
            {
              public final void bVe()
              {
                AppMethodBeat.i(268456);
                Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(268613);
                    if (LaunchAAUI.K(LaunchAAUI.this) != null) {
                      LaunchAAUI.K(LaunchAAUI.this).dismiss();
                    }
                    Toast.makeText(LaunchAAUI.27.this.val$context, a.i.launch_aa_failed, 1).show();
                    AppMethodBeat.o(268613);
                  }
                });
                AppMethodBeat.o(268456);
              }
              
              public final void cp(final String paramAnonymousString1, final String paramAnonymousString2)
              {
                AppMethodBeat.i(268453);
                Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(268615);
                    if (LaunchAAUI.27.this.pLV)
                    {
                      LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.27.this.val$context, LaunchAAUI.27.this.lzC, LaunchAAUI.27.this.pLW, LaunchAAUI.27.this.pLX, LaunchAAUI.27.this.pLY, LaunchAAUI.27.this.pLO, paramAnonymousString1, paramAnonymousString2);
                      AppMethodBeat.o(268615);
                      return;
                    }
                    LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.27.this.val$context, LaunchAAUI.27.this.lzC, LaunchAAUI.27.this.pLW, LaunchAAUI.27.this.pLX, LaunchAAUI.27.this.pLY, LaunchAAUI.G(LaunchAAUI.this), paramAnonymousString1, paramAnonymousString2);
                    AppMethodBeat.o(268615);
                  }
                });
                AppMethodBeat.o(268453);
              }
            }).bFu();
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(13723, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.aa.model.j.SA(this.chatroomName), Integer.valueOf(i), Double.valueOf(100.0D * d), str1 });
          AppMethodBeat.o(63682);
          return;
          i = 0;
          continue;
          if (this.pLm == null) {
            break label602;
          }
          i = this.pLm.size();
          d = Util.getDouble(this.pLh.getText(), 0.0D);
          continue;
        }
        if (paramBoolean)
        {
          a(paramContext, paramString, i, str1, d, paramArrayList);
          continue;
        }
        a(paramContext, paramString, i, str1, d, this.pLm);
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[] { Integer.valueOf(this.mode), paramContext.getMessage() });
        AppMethodBeat.o(63682);
        return;
      }
      continue;
      bVM();
      if (this.pIQ != null) {
        this.pIQ.dismiss();
      }
      this.pIQ = com.tencent.mm.wallet_core.ui.l.c(paramContext, false, null);
      if (!Util.isNullOrNil(this.imagePath))
      {
        if ((this.pIw == 2) && (SH(this.imagePath)) && (y.ZC(bVS())))
        {
          Log.i("MicroMsg.Aa.LaunchAAUI", "set local imagePath :%s", new Object[] { bVS() });
          this.imagePath = bVS();
        }
        new com.tencent.mm.plugin.aa.model.e(this.imagePath, new com.tencent.mm.plugin.aa.model.e.a()
        {
          public final void bVe()
          {
            AppMethodBeat.i(268452);
            Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(268478);
                if (LaunchAAUI.K(LaunchAAUI.this) != null) {
                  LaunchAAUI.K(LaunchAAUI.this).dismiss();
                }
                Toast.makeText(LaunchAAUI.28.this.val$context, a.i.launch_aa_failed, 1).show();
                AppMethodBeat.o(268478);
              }
            });
            AppMethodBeat.o(268452);
          }
          
          public final void cp(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            AppMethodBeat.i(268448);
            Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(268483);
                if (y.ZC(LaunchAAUI.this.bVS()))
                {
                  Log.i("MicroMsg.Aa.LaunchAAUI", " upload success , delete file");
                  y.deleteFile(LaunchAAUI.this.bVS());
                }
                if (LaunchAAUI.f(LaunchAAUI.this) == 4)
                {
                  LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.28.this.val$context, LaunchAAUI.28.this.lzC, paramAnonymousString1, paramAnonymousString2);
                  AppMethodBeat.o(268483);
                  return;
                }
                LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.28.this.val$context, LaunchAAUI.28.this.lzC, paramAnonymousString1, paramAnonymousString2, LaunchAAUI.28.this.pLV, LaunchAAUI.28.this.pLO);
                AppMethodBeat.o(268483);
              }
            });
            AppMethodBeat.o(268448);
          }
        }).bFu();
        AppMethodBeat.o(63682);
        return;
      }
      if (this.pKS == 4)
      {
        c(paramContext, paramString, "", "");
        AppMethodBeat.o(63682);
        return;
      }
      a(paramContext, paramString, "", "", paramBoolean, paramArrayList);
      AppMethodBeat.o(63682);
      return;
      label602:
      final int i = 0;
    }
  }
  
  private void a(dus paramdus)
  {
    AppMethodBeat.i(268619);
    this.pLM.jPz();
    this.pLM.setBannerData(paramdus);
    AppMethodBeat.o(268619);
  }
  
  private boolean bVC()
  {
    return this.scene == 6;
  }
  
  private boolean bVH()
  {
    return this.scene == 5;
  }
  
  private void bVI()
  {
    AppMethodBeat.i(268603);
    if (bVC()) {
      try
      {
        C(this.pLG.pHv);
        bVJ();
        AppMethodBeat.o(268603);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "initPersonLaunchView error:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(268603);
  }
  
  private void bVJ()
  {
    AppMethodBeat.i(63671);
    bVQ();
    bVO();
    bVN();
    AppMethodBeat.o(63671);
  }
  
  private void bVK()
  {
    AppMethodBeat.i(63674);
    String str;
    if (this.mode == com.tencent.mm.plugin.aa.model.b.pFG) {
      if (this.pKS == 4) {
        str = getString(a.i.launch_aa_select_aa_by_person_member_title);
      }
    }
    for (;;)
    {
      aw.a(this.pLf.getPaint(), 0.8F);
      this.pLf.setText(str);
      str = getString(a.i.launch_aa_select_accessibility_mode) + this.pLf.getText();
      this.pKY.setContentDescription(str);
      this.pKY.setClickable(true);
      this.pKY.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(268434);
          Log.i("MicroMsg.Aa.LaunchAAUI", "click switch button");
          LaunchAAUI.this.hideTenpayKB();
          LaunchAAUI.this.hideVKB();
          LaunchAAUI.E(LaunchAAUI.this);
          AppMethodBeat.o(268434);
        }
      });
      this.pKY.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268435);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)LaunchAAUI.F(LaunchAAUI.this).getLayoutParams();
          View localView = LaunchAAUI.this.findViewById(a.f.launch_aa_switch_wrapper);
          localLayoutParams.leftMargin = (localView.getLeft() - 12);
          localLayoutParams.width = (localView.getWidth() + 24);
          localLayoutParams.topMargin = (localView.getTop() - 12);
          localLayoutParams.height = (localView.getHeight() + 24);
          LaunchAAUI.F(LaunchAAUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(268435);
        }
      });
      AppMethodBeat.o(63674);
      return;
      str = getString(a.i.launch_aa_select_aa_by_person_lord_title);
      continue;
      str = getString(a.i.launch_aa_select_aa_by_money_title);
    }
  }
  
  private void bVL()
  {
    AppMethodBeat.i(268624);
    Log.i("MicroMsg.Aa.LaunchAAUI", "switchMode");
    this.pKT = false;
    if (this.mode == com.tencent.mm.plugin.aa.model.b.pFG) {
      if (this.pKS == 4)
      {
        this.pLn.setVisibility(8);
        this.pLt.setVisibility(0);
        this.pLu.setVisibility(8);
        this.pLp.setVisibility(0);
        List localList = com.tencent.mm.plugin.aa.model.j.SA(this.chatroomName);
        this.pLt.setText(getString(a.i.launch_aa_by_person_select_tips, new Object[] { Integer.valueOf(localList.size()) }));
        this.pKX.setText(a.i.launch_aa_by_person_fill_in_select_member);
        this.pLk.setVisibility(8);
        this.pLl.setVisibility(8);
        this.pKV.setText(getString(a.i.launch_aa_by_person_total_amount_hint, new Object[] { Integer.valueOf(0) }));
        if ((this.pLv != null) && (this.pLv.size() > com.tencent.mm.plugin.aa.model.f.bVf()))
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(8) });
          this.pKT = true;
        }
        if (!this.pKT) {
          break label323;
        }
        SE(getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.f.bVf()) }));
        label242:
        yj(5);
      }
    }
    for (;;)
    {
      hideTenpayKB();
      hideVKB();
      bVK();
      bVO();
      bVN();
      f(this.pLq, this.pLr);
      AppMethodBeat.o(268624);
      return;
      this.pLn.setVisibility(0);
      this.pLt.setVisibility(8);
      this.pLu.setVisibility(0);
      this.pLp.setVisibility(8);
      break;
      label323:
      bVM();
      break label242;
      this.mode = com.tencent.mm.plugin.aa.model.b.pFF;
      this.pLk.setVisibility(0);
      this.pLl.setVisibility(0);
      this.pLn.setVisibility(8);
      this.pLp.setVisibility(8);
      this.pLt.setVisibility(8);
      this.pKV.setText(a.i.launch_aa_by_money_total_amount_hint);
      f(this.pLq, this.pLr);
      this.pKT = false;
      if (this.pLm.size() > com.tencent.mm.plugin.aa.model.f.bVg())
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(8) });
        this.pKT = true;
      }
      bVP();
      yj(4);
    }
  }
  
  private void bVM()
  {
    AppMethodBeat.i(63677);
    this.pLC = false;
    if (this.pLy.getVisibility() != 8)
    {
      this.pLy.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.pLy.setVisibility(8);
    }
    AppMethodBeat.o(63677);
  }
  
  private void bVN()
  {
    AppMethodBeat.i(63678);
    if (this.mode == com.tencent.mm.plugin.aa.model.b.pFF)
    {
      if (Util.isNullOrNil(this.pLh.getText()))
      {
        hI(false);
        AppMethodBeat.o(63678);
        return;
      }
      if (this.pKz)
      {
        hI(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.pLm == null) || (this.pLm.size() == 0))
      {
        hI(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.pLm.size() > com.tencent.mm.plugin.aa.model.f.bVg()) || (this.pKT))
      {
        hI(false);
        AppMethodBeat.o(63678);
        return;
      }
      double d = com.tencent.mm.plugin.aa.model.j.b(this.pLh.getText(), this.pLm.size(), 5, 4);
      Log.d("MicroMsg.Aa.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.pLh.getText(), Integer.valueOf(this.pLm.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        Log.i("MicroMsg.Aa.LaunchAAUI", "less than 0.01");
        hI(false);
        AppMethodBeat.o(63678);
      }
    }
    else
    {
      if (this.pKS == 4)
      {
        hI(true);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.pLv == null) || (this.pLv.size() == 0))
      {
        hI(false);
        AppMethodBeat.o(63678);
        return;
      }
      if ((this.pLv.size() > com.tencent.mm.plugin.aa.model.f.bVg()) || (this.pKT))
      {
        hI(false);
        AppMethodBeat.o(63678);
        return;
      }
    }
    hI(true);
    AppMethodBeat.o(63678);
  }
  
  private void bVO()
  {
    AppMethodBeat.i(63680);
    if (this.mode == com.tencent.mm.plugin.aa.model.b.pFF)
    {
      if ((this.pLm != null) && (this.pLm.size() > 0))
      {
        d = com.tencent.mm.plugin.aa.model.j.b(this.pLh.getText(), this.pLm.size(), 2, 2);
        this.pIK.setText(getString(a.i.aa_amount_format, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.pKV.setText(a.i.launch_aa_by_money_total_amount_hint);
        this.pIK.setVisibility(0);
        this.pKW.setVisibility(0);
        this.pKV.setVisibility(0);
        AppMethodBeat.o(63680);
        return;
        this.pIK.setText(getString(a.i.aa_amount_zero));
      }
    }
    if (this.pKS == 4)
    {
      this.pIK.setVisibility(4);
      this.pKW.setVisibility(4);
      this.pKV.setVisibility(4);
      AppMethodBeat.o(63680);
      return;
    }
    if ((this.pLv == null) || (this.pLv.size() == 0))
    {
      this.pKV.setText(getString(a.i.launch_aa_by_person_total_amount_hint, new Object[] { Integer.valueOf(0) }));
      this.pIK.setText(getString(a.i.aa_amount_zero));
      this.pIK.setVisibility(0);
      this.pKW.setVisibility(0);
      this.pKV.setVisibility(0);
      AppMethodBeat.o(63680);
      return;
    }
    Iterator localIterator = this.pLv.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.pIK.setText(getString(a.i.aa_amount_format, new Object[] { Double.valueOf(d) }));
    this.pKV.setText(getString(a.i.launch_aa_by_person_total_amount_hint, new Object[] { Integer.valueOf(this.pLv.size()) }));
    this.pLq.setVisibility(0);
    this.pIK.setVisibility(0);
    this.pKW.setVisibility(0);
    this.pKV.setVisibility(0);
    AppMethodBeat.o(63680);
  }
  
  private void bVP()
  {
    AppMethodBeat.i(63688);
    if ((this.pKT) && (!this.pLC))
    {
      if (this.mode == com.tencent.mm.plugin.aa.model.b.pFF)
      {
        SE(getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.f.bVg()) }));
        AppMethodBeat.o(63688);
        return;
      }
      SE(getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(com.tencent.mm.plugin.aa.model.f.bVf()) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((this.pKz) && (!this.pLC))
    {
      SE(getString(a.i.launch_aa_money_exceed_avg_amount_alert, new Object[] { Float.valueOf((float)com.tencent.mm.plugin.aa.model.f.bVh() / 100.0F) }));
      AppMethodBeat.o(63688);
      return;
    }
    if ((!this.pKT) && (!this.pKz)) {
      bVM();
    }
    AppMethodBeat.o(63688);
  }
  
  private void bVQ()
  {
    AppMethodBeat.i(63689);
    int i;
    if ((this.pLv != null) && (this.pLv.size() > 0))
    {
      this.pLs.setText(getString(a.i.launch_aa_by_person_usernumber_wording, new Object[] { Integer.valueOf(this.pLv.size()) }));
      this.pLs.setTextColor(getResources().getColor(a.c.normal_text_color));
      i = (int)getResources().getDimension(a.d.aa_launch_content_left_right_margin);
      getResources().getDimension(a.d.aa_launch_by_person_header_margin_large);
      getResources().getDimension(a.d.aa_launch_by_person_header_margin_large_bottom);
      this.pLu.setPadding(i, i, i, i);
      this.pLu.setBackgroundResource(a.e.launch_aa_dark_round_corner_bg);
      this.pLo.setVisibility(0);
    }
    for (;;)
    {
      this.pLo.removeAllViews();
      this.pLw.clear();
      if ((this.pLv == null) || (this.pLv.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.pLv.keySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        double d = ((Double)this.pLv.get(str)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (i >= this.pLv.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        localLaunchAAByPersonNameAmountRow.a(str, this.chatroomName, d);
        this.pLo.addView(localLaunchAAByPersonNameAmountRow);
        this.pLw.put(str, localLaunchAAByPersonNameAmountRow);
        i += 1;
      }
      this.pLs.setText(a.i.launch_aa_by_person_usernumber_default_wording);
      this.pLs.setTextColor(getResources().getColor(a.c.aa_comm_hint_color));
      i = (int)getResources().getDimension(a.d.aa_launch_content_left_right_margin);
      this.pLu.setPadding(i, i, i, i);
      this.pLu.setBackgroundResource(a.e.launch_aa_white_round_corner_bg);
      this.pLo.setVisibility(8);
    }
    if (this.pKd != null)
    {
      this.pKd.requestLayout();
      f(this.pLq, this.pLr);
    }
    this.pLB = 0;
    AppMethodBeat.o(63689);
  }
  
  private List<String> bVR()
  {
    AppMethodBeat.i(268653);
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.aa.model.j.SA(this.chatroomName);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!au.bwO(str)) {
          localArrayList.add(str);
        }
      }
    }
    AppMethodBeat.o(268653);
    return localArrayList;
  }
  
  private void bVT()
  {
    AppMethodBeat.i(268664);
    if (bVC())
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "fromThirdParty(),user launch by person mode");
      this.mode = com.tencent.mm.plugin.aa.model.b.pFG;
      this.pKS = 5;
      AppMethodBeat.o(268664);
      return;
    }
    if (bVH())
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "fromOrderDetail(),user launch by money mode");
      this.mode = com.tencent.mm.plugin.aa.model.b.pFF;
      AppMethodBeat.o(268664);
      return;
    }
    int i = com.tencent.mm.plugin.aa.model.f.bVi();
    Log.i("MicroMsg.Aa.LaunchAAUI", "defaultMode is ：%s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 2: 
    default: 
      this.mode = com.tencent.mm.plugin.aa.model.b.pFF;
    }
    while ((!bVU()) && (this.mode == com.tencent.mm.plugin.aa.model.b.pFG))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "!isOpenAAPayCustomize() && mode == AAConstants.MODE_LAUNCH_BY_PERSON");
      this.pKS = 5;
      AppMethodBeat.o(268664);
      return;
      this.mode = com.tencent.mm.plugin.aa.model.b.pFG;
      this.pKS = 4;
      continue;
      this.mode = com.tencent.mm.plugin.aa.model.b.pFG;
      this.pKS = 5;
    }
    if ((this.mode == com.tencent.mm.plugin.aa.model.b.pFG) && (bVC()))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "mode == AAConstants.MODE_LAUNCH_BY_PERSON && fromThirdParty()");
      this.pKS = 5;
      AppMethodBeat.o(268664);
      return;
    }
    AppMethodBeat.o(268664);
  }
  
  private static boolean bVU()
  {
    AppMethodBeat.i(268667);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXk, true);
    Log.i("MicroMsg.Aa.LaunchAAUI", "aaPayCustomizeOpen switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(268667);
    return bool;
  }
  
  private void bVV()
  {
    AppMethodBeat.i(268676);
    int i = bf.bf(getContext()).y;
    Object localObject = new int[2];
    this.pLg.getLocationOnScreen((int[])localObject);
    i -= localObject[1] + this.pLg.getHeight();
    int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
    localObject = (RelativeLayout.LayoutParams)this.pLL.getLayoutParams();
    if (com.tencent.mm.cd.a.fromDPToPix(getContext(), 5) + i < this.pLJ + j)
    {
      int k = this.pLJ;
      int m = com.tencent.mm.cd.a.fromDPToPix(getContext(), 10);
      ((RelativeLayout.LayoutParams)localObject).height = com.tencent.mm.cd.a.fromDPToPix(getContext(), 500);
      this.pLL.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.pLL.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268556);
          LaunchAAUI.M(LaunchAAUI.this).smoothScrollBy(0, this.pMi);
          AppMethodBeat.o(268556);
        }
      }, 100L);
      AppMethodBeat.o(268676);
      return;
    }
    f(this.pLq, this.pLr);
    AppMethodBeat.o(268676);
  }
  
  private void c(final Context paramContext, final String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(268642);
    Log.i("MicroMsg.Aa.LaunchAAUI", "launchAAByPersonCustomize");
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.b.class)).jO(7, 5);
    com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(2) });
    HashMap localHashMap = new HashMap();
    try
    {
      String str2 = this.pKU.getText().toString();
      String str1 = str2;
      if (Util.isNullOrNil(str2)) {
        str1 = getString(a.i.launch_aa_des_default_title);
      }
      localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGE, str1);
      localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGI, paramString1);
      localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGL, Long.valueOf(this.timestamp));
      localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGM, paramString2);
      localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGN, paramString3);
      if (!Util.isNullOrNil(this.imagePath))
      {
        paramString2 = com.tencent.mm.b.g.getMD5(this.imagePath);
        localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGP, paramString2);
      }
      if (bVC()) {
        localHashMap.put(com.tencent.mm.plugin.aa.model.m.pGO, this.pKg);
      }
      this.pKR.pHW.H(localHashMap).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
      {
        public final void onInterrupt(final Object paramAnonymousObject)
        {
          AppMethodBeat.i(268419);
          Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
          if (LaunchAAUI.K(LaunchAAUI.this) != null) {
            LaunchAAUI.K(LaunchAAUI.this).dismiss();
          }
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)) && (!paramAnonymousObject.toString().equalsIgnoreCase("ok"))) {
            com.tencent.mm.ui.base.k.a(paramContext, paramAnonymousObject.toString(), "", LaunchAAUI.this.getString(a.i.launch_aa_i_know), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(268514);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                AppMethodBeat.o(268514);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(10) });
            AppMethodBeat.o(268419);
            return;
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ac)))
            {
              com.tencent.mm.plugin.aa.model.j.a(LaunchAAUI.this.getContext(), (ac)paramAnonymousObject);
            }
            else if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
            {
              paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
              String str1 = paramAnonymousObject.wording;
              String str2 = paramAnonymousObject.rGU;
              String str3 = paramAnonymousObject.right_button_wording;
              com.tencent.mm.ui.widget.a.e.a locala = new com.tencent.mm.ui.widget.a.e.a(paramContext);
              locala.bDw(str1);
              locala.bDC(str3).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(268519);
                  com.tencent.mm.wallet_core.ui.i.p(LaunchAAUI.this.getContext(), paramAnonymousObject.wYO, false);
                  AppMethodBeat.o(268519);
                }
              });
              locala.bDD(str2);
              locala.jHH().show();
            }
            else
            {
              Toast.makeText(paramContext, a.i.launch_aa_failed, 1).show();
            }
          }
        }
      });
      AppMethodBeat.o(268642);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPersonCustomize error: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(268642);
    }
  }
  
  private static boolean cv(List<String> paramList)
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
    } while (!Util.isEqual((String)paramList.next(), z.bAM()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(63694);
      return bool;
    }
  }
  
  private void f(final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(268669);
    this.pLo.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268600);
        int i = com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 48);
        int j = com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 64);
        int k = com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 96);
        if (LaunchAAUI.a(LaunchAAUI.this, paramView2))
        {
          localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
          localLayoutParams1.removeRule(12);
          localLayoutParams1.addRule(3, a.f.top_ll);
          localLayoutParams1.topMargin = i;
          paramView1.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(268600);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(3);
        localLayoutParams1.addRule(12);
        localLayoutParams1.bottomMargin = k;
        paramView1.setLayoutParams(localLayoutParams1);
        if (LaunchAAUI.g(paramView1, paramView2) >= i)
        {
          AppMethodBeat.o(268600);
          return;
        }
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(3);
        localLayoutParams2.addRule(12);
        localLayoutParams2.bottomMargin = j;
        paramView1.setLayoutParams(localLayoutParams2);
        if (LaunchAAUI.g(paramView1, paramView2) >= i)
        {
          AppMethodBeat.o(268600);
          return;
        }
        localLayoutParams1 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
        localLayoutParams1.removeRule(12);
        localLayoutParams1.addRule(3, a.f.top_ll);
        localLayoutParams1.topMargin = i;
        paramView1.setLayoutParams(localLayoutParams1);
        AppMethodBeat.o(268600);
      }
    }, 100L);
    AppMethodBeat.o(268669);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(369743);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("aa_pay");
    AppMethodBeat.o(369743);
    return localMultiProcessMMKV;
  }
  
  private void hI(boolean paramBoolean)
  {
    AppMethodBeat.i(63679);
    this.pLx.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.pKV.setTextColor(getResources().getColor(a.c.FG_1));
      this.pIK.setTextColor(getResources().getColor(a.c.aa_launch_amount_disable_color));
      this.pKW.setTextColor(getResources().getColor(a.c.aa_launch_amount_disable_color));
      AppMethodBeat.o(63679);
      return;
    }
    this.pKV.setTextColor(getResources().getColor(a.c.FG_1));
    this.pIK.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.pKW.setTextColor(getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(63679);
  }
  
  public final String bVS()
  {
    AppMethodBeat.i(269000);
    String str = ah.v(new u(getContext().getCacheDir() + "/aaTempPho", "aa_share_bitmap.jpg").jKT());
    AppMethodBeat.o(269000);
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
        if (this.mode == com.tencent.mm.plugin.aa.model.b.pFF)
        {
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.pLm.clear();
            this.pLm.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = com.tencent.mm.plugin.aa.model.j.SA(this.chatroomName);
          if ((paramIntent == null) || (this.pLm == null) || (this.pLm.size() != paramIntent.size()) || (!au.bwE(this.chatroomName))) {
            break label319;
          }
          paramIntent = this.pLj;
          paramInt2 = a.i.launch_aa_by_money_all_group_member;
          if (this.pLm != null)
          {
            paramInt1 = this.pLm.size();
            paramIntent.setText(getString(paramInt2, new Object[] { Integer.valueOf(paramInt1) }));
          }
        }
        else
        {
          bVM();
          if ((this.pLm == null) || (this.pLm.size() <= com.tencent.mm.plugin.aa.model.f.bVg())) {
            break label373;
          }
          this.pKT = true;
          d = Util.getDouble(this.pLh.getText(), 0.0D);
          if ((this.pLm == null) || (d * 100.0D / this.pLm.size() <= com.tencent.mm.plugin.aa.model.f.bVh())) {
            break label381;
          }
          this.pKz = true;
          com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          bVN();
          bVO();
          bVP();
          AppMethodBeat.o(63690);
          return;
          paramInt1 = 0;
          break;
          label319:
          paramIntent = this.pLj;
          paramInt2 = a.i.launch_aa_by_money_usernumber_wording;
          if (this.pLm != null) {}
          for (paramInt1 = this.pLm.size();; paramInt1 = 0)
          {
            paramIntent.setText(getString(paramInt2, new Object[] { Integer.valueOf(paramInt1) }));
            break;
          }
          label373:
          this.pKT = false;
          break label225;
          label381:
          this.pKz = false;
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
            this.pLv.clear();
            if ((paramIntent != null) && (paramIntent.size() > 0))
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext())
              {
                localObject = ((String)paramIntent.next()).split(",");
                d = Util.getDouble(localObject[1], 0.0D);
                this.pLv.put(localObject[0], Double.valueOf(d));
              }
            }
            bVJ();
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
            paramIntent = com.tencent.mm.ui.tools.b.i(this, paramIntent, com.tencent.mm.plugin.image.d.bzL());
            if (Util.isNullOrNil(paramIntent)) {}
          }
          label706:
          for (this.imagePath = paramIntent;; this.imagePath = ((String)((ArrayList)localObject).get(0)))
          {
            if (!Util.isNullOrNil(this.imagePath))
            {
              this.pIw = 2;
              this.pLe.setVisibility(0);
              this.pLc.setVisibility(8);
              this.pLd.setVisibility(8);
              MMBitmapFactory.decodeFile(this.imagePath);
              this.pLe.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(268426);
                  Bitmap localBitmap = BitmapUtil.decodeFileWithSample(LaunchAAUI.t(LaunchAAUI.this), LaunchAAUI.u(LaunchAAUI.this).getWidth(), LaunchAAUI.u(LaunchAAUI.this).getHeight());
                  int i = Exif.fromFile(LaunchAAUI.t(LaunchAAUI.this)).getOrientationInDegree();
                  localBitmap = BitmapUtil.rotate(localBitmap, i);
                  Log.i("MicroMsg.Aa.LaunchAAUI", "exifPath : %s degree : %d", new Object[] { LaunchAAUI.t(LaunchAAUI.this), Integer.valueOf(i) });
                  LaunchAAUI.u(LaunchAAUI.this).setImageBitmap(localBitmap);
                  LaunchAAUI.u(LaunchAAUI.this).sendAccessibilityEvent(128);
                  AppMethodBeat.o(268426);
                }
              });
              yj(8);
            }
            Log.i("MicroMsg.Aa.LaunchAAUI", "SELECT_IMAGE_REQUEST_CODE imagePath:%s", new Object[] { this.imagePath });
            if (this.pLe.getVisibility() != 0) {
              break;
            }
            this.pLb.setClickable(false);
            AppMethodBeat.o(63690);
            return;
          }
          this.pLb.setClickable(true);
          AppMethodBeat.o(63690);
          return;
        }
        if (paramInt1 == 310)
        {
          if (paramInt2 == -1)
          {
            this.pIw = 2;
            this.imagePath = "";
            this.pLe.setVisibility(8);
            this.pLc.setVisibility(0);
            this.pLd.setVisibility(0);
            yj(7);
          }
          if (this.pLe.getVisibility() == 0)
          {
            this.pLb.setClickable(false);
            AppMethodBeat.o(63690);
            return;
          }
          this.pLb.setClickable(true);
        }
      }
    }
    AppMethodBeat.o(63690);
  }
  
  public void onCreate(final Bundle paramBundle)
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
    if (bVC())
    {
      this.pLG = ((NetSceneNewAAQueryPFInfo.PfInfoParcel)getIntent().getParcelableExtra("pfInfo"));
      this.pKg = getIntent().getStringExtra("pfOrderNo");
      if (this.pLG == null)
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "pfInfoParcel is null!!!");
        finish();
        AppMethodBeat.o(63669);
        return;
      }
      this.mode = com.tencent.mm.plugin.aa.model.b.pFG;
      this.pKS = 5;
      this.pLE = this.pLG.ihV;
      this.pLF = this.pLG.remark;
      yj(1);
      this.chatroomName = getIntent().getStringExtra("chatroom_name");
      if (Util.isNullOrNil(this.chatroomName))
      {
        Log.e("MicroMsg.Aa.LaunchAAUI", "chatroomName is null!!!");
        this.chatroomName = "";
      }
      paramBundle = this.chatroomName;
      if (Util.isNullOrNil(paramBundle)) {
        break label1106;
      }
      if (!au.bwE(paramBundle)) {
        break label1058;
      }
      label228:
      this.chatroomName = paramBundle;
      this.pKd = findViewById(a.f.root_container);
      this.pLf = ((TextView)findViewById(a.f.launch_aa_switch_mode));
      this.pKY = ((LinearLayout)findViewById(a.f.launch_aa_switch_ll));
      this.pKZ = ((ImageView)findViewById(a.f.launch_aa_switch_mode_arrow));
      this.pLx = ((Button)findViewById(a.f.launch_aa_button));
      this.pLy = ((TextView)findViewById(a.f.launch_aa_alert_tip_tv));
      this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
      this.pKU = ((MMEditText)findViewById(a.f.launch_aa_title_edit));
      this.pKV = ((TextView)findViewById(a.f.launch_aa_total_amount_hint));
      this.pIK = ((TextView)findViewById(a.f.launch_aa_amount));
      this.pKW = ((TextView)findViewById(a.f.launch_aa_amount_unit));
      this.pLa = ((RelativeLayout)findViewById(a.f.photo_container));
      this.pLb = ((LinearLayout)findViewById(a.f.photo_top_container));
      this.pLc = ((ImageView)findViewById(a.f.plus_iv));
      this.pLd = ((TextView)findViewById(a.f.plus_iv_tips));
      this.pLe = ((ImageView)findViewById(a.f.content_iv));
      this.pKX = ((TextView)findViewById(a.f.launch_by_person_fill_in_select));
      this.pLh = ((WalletFormView)findViewById(a.f.launch_aa_total_amount_edit_form));
      this.pLj = ((TextView)findViewById(a.f.launch_aa_by_money_user_select));
      this.pLi = ((TextView)findViewById(a.f.launch_aa_by_money_user_select_hint));
      this.pLk = ((ViewGroup)findViewById(a.f.launch_by_money_total_usernumber_content_layout));
      this.pLl = ((ViewGroup)findViewById(a.f.launch_by_money_total_amount_layout));
      this.pLs = ((TextView)findViewById(a.f.launch_aa_by_person_user_select));
      this.pLs.setText(a.i.launch_aa_by_person_usernumber_default_wording);
      this.pLs.setTextColor(getResources().getColor(a.c.FG_2));
      this.pLn = ((ViewGroup)findViewById(a.f.launch_by_person_user_layout));
      this.pLo = ((ViewGroup)findViewById(a.f.launch_by_person_user_list_layout));
      this.pLu = ((ViewGroup)findViewById(a.f.launch_aa_by_person_select_header_layout));
      this.pLp = ((ViewGroup)findViewById(a.f.launch_by_person_fill_in_select_layout));
      this.pLq = ((ViewGroup)findViewById(a.f.launch_aa_total_amount_layout));
      this.pLr = ((ViewGroup)findViewById(a.f.top_ll));
      this.pLt = ((TextView)findViewById(a.f.launch_by_person_fill_in_select_layout_tips));
      this.pLg = ((ViewGroup)findViewById(a.f.launch_aa_title_edit_layout));
      this.pLK = ((ScrollView)findViewById(a.f.root_scroll));
      this.pLL = findViewById(a.f.scroll_Interval);
      if (com.tencent.xweb.util.c.oY(getContext()).jls()) {
        break label1113;
      }
      this.pKd.setOnTouchListener(new View.OnTouchListener()
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
    }
    Object localObject;
    for (;;)
    {
      this.pLb.setAccessibilityDelegate(new com.tencent.mm.wallet_core.c()
      {
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          AppMethodBeat.i(268420);
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
          paramAnonymousAccessibilityNodeInfo.setClassName(Button.class.getName());
          paramAnonymousAccessibilityNodeInfo.setContentDescription(LaunchAAUI.this.getString(a.i.launch_aa_add_imag));
          if (!paramAnonymousView.isClickable()) {
            paramAnonymousView.setImportantForAccessibility(2);
          }
          AppMethodBeat.o(268420);
        }
      });
      findViewById(a.f.launch_aa_amount_ll).setAccessibilityDelegate(new com.tencent.mm.wallet_core.c()
      {
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          int j = 1;
          AppMethodBeat.i(268611);
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
          String str1 = LaunchAAUI.b(LaunchAAUI.this).getText().toString();
          String str2 = LaunchAAUI.c(LaunchAAUI.this).getText().toString();
          String str3 = LaunchAAUI.d(LaunchAAUI.this).getText().toString();
          paramAnonymousAccessibilityNodeInfo.setClassName(TextView.class.getName());
          paramAnonymousAccessibilityNodeInfo.setContentDescription(str1 + "," + str3 + str2);
          if ((LaunchAAUI.e(LaunchAAUI.this) == com.tencent.mm.plugin.aa.model.b.pFF) || (LaunchAAUI.f(LaunchAAUI.this) != 4))
          {
            i = 1;
            if (i == 0) {
              break label157;
            }
          }
          label157:
          for (int i = j;; i = 2)
          {
            paramAnonymousView.setImportantForAccessibility(i);
            AppMethodBeat.o(268611);
            return;
            i = 0;
            break;
          }
        }
      });
      this.pLl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268560);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          LaunchAAUI.g(LaunchAAUI.this).requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268560);
        }
      });
      findViewById(a.f.launch_aa_title_edit_wrapper_ll).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268563);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/LaunchAAUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          LaunchAAUI.a(LaunchAAUI.this).requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268563);
        }
      });
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.aa.model.a)com.tencent.mm.ui.component.k.d(getContext()).q(com.tencent.mm.plugin.aa.model.a.class)).setValue("LAUNCH_AA_TOTAL_MONEY_EDIT_FORM_VALUE_KEY", "0");
      this.pKW.setTextSize(48.0F);
      this.pIK.setTextSize(48.0F);
      bVL();
      bVK();
      bVI();
      this.pLx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(268549);
          Log.i("MicroMsg.Aa.LaunchAAUI", "click launchButton，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.e(LaunchAAUI.this)), Integer.valueOf(LaunchAAUI.f(LaunchAAUI.this)) });
          LaunchAAUI.h(LaunchAAUI.this);
          AppMethodBeat.o(268549);
        }
      });
      this.pKU.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(268553);
          LaunchAAUI.i(LaunchAAUI.this);
          LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.j(LaunchAAUI.this), LaunchAAUI.k(LaunchAAUI.this));
          LaunchAAUI.this.yj(6);
          LaunchAAUI.l(LaunchAAUI.this);
          AppMethodBeat.o(268553);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.pKU.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(268574);
          LaunchAAUI.a(LaunchAAUI.this).setCursorVisible(true);
          if (LaunchAAUI.a((MMEditText)paramAnonymousView))
          {
            paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
            if (paramAnonymousMotionEvent.getAction() == 1) {
              paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(false);
            }
          }
          AppMethodBeat.o(268574);
          return false;
        }
      });
      this.pKU.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(268595);
          if (paramAnonymousView.isFocused())
          {
            LaunchAAUI.a(LaunchAAUI.this).setPadding(0, com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 12), 0, com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 16));
            LaunchAAUI.a(LaunchAAUI.this).setHint("");
            ((InputMethodManager)LaunchAAUI.this.getContext().getSystemService("input_method")).showSoftInput(LaunchAAUI.a(LaunchAAUI.this), 0);
            AppMethodBeat.o(268595);
            return;
          }
          if (LaunchAAUI.a(LaunchAAUI.this).getText().length() > 0)
          {
            LaunchAAUI.a(LaunchAAUI.this).setPadding(0, com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 12), 0, com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 16));
            AppMethodBeat.o(268595);
            return;
          }
          LaunchAAUI.a(LaunchAAUI.this).setPadding(0, com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 28), 0, com.tencent.mm.cd.a.fromDPToPix(LaunchAAUI.this.getContext(), 16));
          LaunchAAUI.a(LaunchAAUI.this).setHint(LaunchAAUI.this.getString(a.i.launch_aa_des_default_title));
          AppMethodBeat.o(268595);
        }
      });
      this.pLh.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(268457);
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          String str = paramAnonymousEditable.toString();
          int i = str.indexOf(".");
          int j = str.length();
          if ((i >= 0) && (j - i > 3))
          {
            WalletFormView.a(LaunchAAUI.g(LaunchAAUI.this).getContentEt(), str, i + 3, j);
            double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
            if ((LaunchAAUI.G(LaunchAAUI.this) == null) || (LaunchAAUI.G(LaunchAAUI.this).size() <= 0)) {
              break label349;
            }
            d = d * 100.0D / LaunchAAUI.G(LaunchAAUI.this).size();
            LaunchAAUI.D(LaunchAAUI.this);
            if (d <= com.tencent.mm.plugin.aa.model.f.bVh()) {
              break label349;
            }
            LaunchAAUI.a(LaunchAAUI.this, true);
            com.tencent.mm.plugin.report.service.h.OAn.b(13722, new Object[] { Integer.valueOf(2) });
            label184:
            if (com.tencent.xweb.util.c.oY(LaunchAAUI.this.getContext()).jls())
            {
              if (str.length() != 0) {
                break label361;
              }
              LaunchAAUI.g(LaunchAAUI.this).getContentEt().setHint(LaunchAAUI.this.getString(a.i.launch_aa_by_person_money_select_hint));
            }
          }
          for (;;)
          {
            LaunchAAUI.g(LaunchAAUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(268463);
                String str = LaunchAAUI.g(LaunchAAUI.this).getContentEt().getText().toString();
                com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
                ((com.tencent.mm.plugin.aa.model.a)com.tencent.mm.ui.component.k.d(LaunchAAUI.this.getContext()).q(com.tencent.mm.plugin.aa.model.a.class)).setValue("LAUNCH_AA_TOTAL_MONEY_EDIT_FORM_VALUE_KEY", str);
                AppMethodBeat.o(268463);
              }
            });
            LaunchAAUI.i(LaunchAAUI.this);
            LaunchAAUI.H(LaunchAAUI.this);
            LaunchAAUI.I(LaunchAAUI.this);
            LaunchAAUI.this.yj(3);
            AppMethodBeat.o(268457);
            return;
            if (i > 6)
            {
              WalletFormView.a(LaunchAAUI.g(LaunchAAUI.this).getContentEt(), str, 6, i);
              break;
            }
            if ((i != -1) || (j <= 6)) {
              break;
            }
            WalletFormView.a(LaunchAAUI.g(LaunchAAUI.this).getContentEt(), str, 6, j);
            break;
            label349:
            LaunchAAUI.a(LaunchAAUI.this, false);
            break label184;
            label361:
            LaunchAAUI.g(LaunchAAUI.this).getContentEt().setHint(null);
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      setEditFocusListener(this.pLh, 2, false, true);
      this.pLh.setmContentAbnormalMoneyCheck(true);
      if (!bVC()) {
        break label1810;
      }
      paramBundle = new ArrayList();
      localObject = this.pLv.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBundle.add((String)((Iterator)localObject).next());
      }
      bVT();
      this.pLD = getIntent().getStringExtra("amount");
      this.pLF = getIntent().getStringExtra("title");
      break;
      label1058:
      paramBundle = Util.stringsToList(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(z.bAM());
        if (paramBundle.size() > 0)
        {
          paramBundle = (String)paramBundle.get(0);
          break label228;
        }
      }
      label1106:
      paramBundle = "";
      break label228;
      label1113:
      this.pKd.setFocusable(false);
      this.pKd.setFocusableInTouchMode(false);
    }
    this.pLj.setText(getString(a.i.launch_aa_by_money_usernumber_wording, new Object[] { Integer.valueOf(paramBundle.size()) }));
    this.pLm = paramBundle;
    this.pLk.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(268445);
        LaunchAAUI.this.hideTenpayKB();
        LaunchAAUI.this.hideVKB();
        LaunchAAUI.a(LaunchAAUI.this, paramBundle);
        AppMethodBeat.o(268445);
      }
    });
    this.pKT = false;
    this.pLu.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(268587);
        LaunchAAUI.m(LaunchAAUI.this);
        AppMethodBeat.o(268587);
      }
    });
    int i;
    if (!Util.isNullOrNil(this.pLF))
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "default title: %s", new Object[] { this.pLF });
      this.pKU.setText(this.pLF);
      if (this.pLF.length() > 20)
      {
        i = 20;
        label1259:
        this.pKU.setSelection(i);
      }
    }
    else
    {
      if (!bVC()) {
        break label2078;
      }
      paramBundle = String.format("%.2f", new Object[] { Double.valueOf(this.pLE / 100.0D) });
      this.pLh.setText(paramBundle);
      this.pLh.setSelection(paramBundle.length());
      label1319:
      bVN();
      if ((bVC()) && (MultiProcessMMKV.getMMKV("aa_pay").getBoolean("new_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.f(getContext(), 1, false);
        localObject = getLayoutInflater().inflate(a.g.aa_new_guide_dialog, null);
        ((View)localObject).findViewById(a.f.i_know_bt).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(268606);
            LaunchAAUI.getKV().edit().putBoolean("new_user_guide_show", false);
            paramBundle.cyW();
            LaunchAAUI.this.yj(2);
            AppMethodBeat.o(268606);
          }
        });
        paramBundle.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
          {
            AppMethodBeat.i(268599);
            paramAnonymouss.clear();
            paramBundle.setFooterView(null);
            paramBundle.setFooterView(this.pLR);
            AppMethodBeat.o(268599);
          }
        };
        paramBundle.uR(true);
        paramBundle.dDn();
      }
      if ((ab.IG(this.chatroomName)) && (MultiProcessMMKV.getMMKV("aa_pay").getBoolean("new_open_IM_user_guide_show", true)))
      {
        paramBundle = new com.tencent.mm.ui.widget.a.f(getContext(), 1, false);
        localObject = getLayoutInflater().inflate(a.g.aa_new_guide_dialog, null);
        ((TextView)((View)localObject).findViewById(a.f.aa_new_dialog_title)).setText(getString(a.i.launch_aa_open_im_guide_title));
        ((TextView)((View)localObject).findViewById(a.f.aa_new_dialog_content)).setText(getString(a.i.launch_aa_open_im_guide_content));
        ((View)localObject).findViewById(a.f.i_know_bt).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(268477);
            LaunchAAUI.getKV().edit().putBoolean("new_open_IM_user_guide_show", false);
            paramBundle.cyW();
            AppMethodBeat.o(268477);
          }
        });
        paramBundle.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
          {
            AppMethodBeat.i(268471);
            paramAnonymouss.clear();
            paramBundle.setFooterView(null);
            paramBundle.setFooterView(this.pLR);
            AppMethodBeat.o(268471);
          }
        };
        paramBundle.uR(true);
        paramBundle.dDn();
      }
      if (!bVC()) {
        break label2211;
      }
      this.pLa.setVisibility(0);
      this.pLa.setOnClickListener(new LaunchAAUI.13(this));
      this.pLe.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(268479);
          if (LaunchAAUI.q(LaunchAAUI.this) == null) {
            LaunchAAUI.a(LaunchAAUI.this, com.tencent.mm.ui.base.k.a(LaunchAAUI.this, 3, a.j.LuckyMoneyNoAnimDialog, LaunchAAUI.this.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(268539);
                if ((LaunchAAUI.q(LaunchAAUI.this) != null) && (LaunchAAUI.q(LaunchAAUI.this).isShowing())) {
                  LaunchAAUI.q(LaunchAAUI.this).dismiss();
                }
                AppMethodBeat.o(268539);
              }
            }));
          }
          if (!Util.isNullOrNil(LaunchAAUI.r(LaunchAAUI.this)))
          {
            r.bKd().a(LaunchAAUI.r(LaunchAAUI.this), new s.a()
            {
              public final void onLoadImageEnd(String paramAnonymous2String1, Bitmap paramAnonymous2Bitmap, String paramAnonymous2String2)
              {
                AppMethodBeat.i(268541);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous2String1, paramAnonymous2String2 });
                if ((LaunchAAUI.q(LaunchAAUI.this) != null) && (LaunchAAUI.q(LaunchAAUI.this).isShowing())) {
                  LaunchAAUI.q(LaunchAAUI.this).dismiss();
                }
                if (paramAnonymous2Bitmap != null)
                {
                  paramAnonymous2String1 = new Intent();
                  paramAnonymous2String1.putExtra("use_scene", 1);
                  paramAnonymous2String1.putExtra("scene", LaunchAAUI.s(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("path", LaunchAAUI.t(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("url", LaunchAAUI.r(LaunchAAUI.this));
                  paramAnonymous2String1.putExtra("view_info", ViewAnimHelper.z(LaunchAAUI.u(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
                  com.tencent.mm.br.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous2String1, 310);
                  LaunchAAUI.this.yj(14);
                  AppMethodBeat.o(268541);
                  return;
                }
                Toast.makeText(LaunchAAUI.this, a.i.aa_list_load_img_fail, 1).show();
                AppMethodBeat.o(268541);
              }
            });
            AppMethodBeat.o(268479);
            return;
          }
          Log.i("MicroMsg.Aa.LaunchAAUI", "imageUrl == null");
          if ((LaunchAAUI.q(LaunchAAUI.this) != null) && (LaunchAAUI.q(LaunchAAUI.this).isShowing())) {
            LaunchAAUI.q(LaunchAAUI.this).dismiss();
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("use_scene", 1);
          LaunchAAUI.v(LaunchAAUI.this);
          paramAnonymousView.putExtra("scene", LaunchAAUI.s(LaunchAAUI.this));
          paramAnonymousView.putExtra("path", LaunchAAUI.t(LaunchAAUI.this));
          paramAnonymousView.putExtra("view_info", ViewAnimHelper.z(LaunchAAUI.u(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
          com.tencent.mm.br.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymousView, 310);
          LaunchAAUI.this.yj(14);
          AppMethodBeat.o(268479);
        }
      });
      if ((this.pLG == null) || (Util.isNullOrNil(this.pLG.pic_url))) {
        break label2171;
      }
      this.pIw = 1;
      this.imageUrl = this.pLG.pic_url;
      this.pLe.setVisibility(0);
      this.pLc.setVisibility(8);
      this.pLd.setVisibility(8);
      r.bKd().a(this.pLG.pic_url, this.pLG.pHx, new s.a()
      {
        public final void onLoadImageEnd(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
        {
          boolean bool = false;
          AppMethodBeat.i(268475);
          if (paramAnonymousBitmap == null) {
            bool = true;
          }
          Log.i("MicroMsg.Aa.LaunchAAUI", "onLoadImageEnd() url:%s bitmap==null:%s path:%s", new Object[] { paramAnonymousString1, Boolean.valueOf(bool), paramAnonymousString2 });
          LaunchAAUI.a(LaunchAAUI.this, paramAnonymousString2);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(268441);
              if (paramAnonymousBitmap != null)
              {
                LaunchAAUI.u(LaunchAAUI.this).setImageBitmap(paramAnonymousBitmap);
                AppMethodBeat.o(268441);
                return;
              }
              LaunchAAUI.v(LaunchAAUI.this);
              LaunchAAUI.u(LaunchAAUI.this).setVisibility(8);
              LaunchAAUI.w(LaunchAAUI.this).setVisibility(0);
              LaunchAAUI.x(LaunchAAUI.this).setVisibility(0);
              AppMethodBeat.o(268441);
            }
          });
          AppMethodBeat.o(268475);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      if ((bVC()) && (this.pLI != null)) {
        this.pLI.alive();
      }
      this.lKz = new com.tencent.mm.ui.tools.i(getContext());
      this.lKz.afIL = this;
      if (!bVC()) {
        break label2277;
      }
      this.pLz = new com.tencent.mm.plugin.aa.model.f(this.pLG.pHy.pHu, this.pLG.pHy.pHt);
      a(this.pLG.pGr);
      AppMethodBeat.o(63669);
      return;
      label1810:
      if (au.bwE(this.chatroomName)) {
        if (!ab.IG(this.chatroomName)) {
          paramBundle = com.tencent.mm.plugin.aa.model.j.SA(this.chatroomName);
        }
      }
      for (;;)
      {
        this.pLm = paramBundle;
        if (this.pLm.size() <= com.tencent.mm.plugin.aa.model.f.bVg()) {
          break label1948;
        }
        this.pLm.clear();
        this.pLj.setText(getString(a.i.paylist_aa_by_money_select_group_memeber));
        bVN();
        break;
        paramBundle = bVR();
        continue;
        Log.i("MicroMsg.Aa.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
        paramBundle = new ArrayList();
        paramBundle.add(z.bAM());
        paramBundle.add(this.chatroomName);
      }
      label1948:
      if (au.bwE(this.chatroomName))
      {
        if (!ab.IG(this.chatroomName))
        {
          this.pLj.setText(getString(a.i.launch_aa_by_money_all_group_member, new Object[] { Integer.valueOf(paramBundle.size()) }));
          break;
        }
        this.pLj.setText(getString(a.i.launch_aa_by_money_usernumber_wording, new Object[] { Integer.valueOf(paramBundle.size()) }));
        break;
      }
      this.pLj.setText(getString(a.i.launch_aa_by_money_usernumber_wording, new Object[] { Integer.valueOf(paramBundle.size()) }));
      break;
      i = this.pLF.length();
      break label1259;
      label2078:
      if (Util.isNullOrNil(this.pLD)) {
        break label1319;
      }
      Log.i("MicroMsg.Aa.LaunchAAUI", "default amount: %s", new Object[] { this.pLD });
      paramBundle = com.tencent.mm.wallet_core.ui.i.a(new StringBuilder().append(this.pLD).toString(), "100", 2, RoundingMode.HALF_UP);
      this.pLh.setText(paramBundle);
      this.pLh.setSelection(paramBundle.length());
      break label1319;
      label2171:
      this.pIw = 2;
      this.imagePath = "";
      this.pLe.setVisibility(8);
      this.pLc.setVisibility(0);
      this.pLd.setVisibility(0);
      continue;
      label2211:
      this.pLa.setVisibility(0);
      this.pLe.setVisibility(8);
      this.pLc.setVisibility(0);
      this.pLd.setVisibility(0);
      this.pLb.setOnClickListener(new LaunchAAUI.16(this));
      this.pLe.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(268468);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("use_scene", 1);
          paramAnonymousView.putExtra("scene", LaunchAAUI.s(LaunchAAUI.this));
          paramAnonymousView.putExtra("path", LaunchAAUI.t(LaunchAAUI.this));
          paramAnonymousView.putExtra("url", LaunchAAUI.r(LaunchAAUI.this));
          paramAnonymousView.putExtra("view_info", ViewAnimHelper.z(LaunchAAUI.u(LaunchAAUI.this), LaunchAAUI.this.getContext().getWindow().getDecorView()));
          com.tencent.mm.br.c.b(LaunchAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymousView, 310);
          AppMethodBeat.o(268468);
        }
      });
    }
    label2277:
    paramBundle = this.pKR.pHX;
    com.tencent.mm.vending.g.g.jJU().c(paramBundle).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void onInterrupt(Object paramAnonymousObject)
      {
        AppMethodBeat.i(268466);
        Log.i("MicroMsg.Aa.LaunchAAUI", "fetch operation data failed");
        AppMethodBeat.o(268466);
      }
    });
    AppMethodBeat.o(63669);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63687);
    super.onDestroy();
    if ((bVC()) && (this.pLI != null)) {
      this.pLI.dead();
    }
    AppMethodBeat.o(63687);
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(269005);
    if ((paramInt > 0) && (this.msK <= 0))
    {
      this.pLJ = paramInt;
      this.msK = paramInt;
      bVV();
    }
    if ((paramInt <= 0) && (this.msK > 0))
    {
      this.msK = paramInt;
      this.pLL.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268620);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)LaunchAAUI.L(LaunchAAUI.this).getLayoutParams();
          localLayoutParams.height = 0;
          LaunchAAUI.L(LaunchAAUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(268620);
        }
      }, 50L);
      this.pLL.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268623);
          LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.j(LaunchAAUI.this), LaunchAAUI.k(LaunchAAUI.this));
          AppMethodBeat.o(268623);
        }
      }, 100L);
    }
    AppMethodBeat.o(269005);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(269014);
    super.onPause();
    if (this.lKz != null) {
      this.lKz.close();
    }
    AppMethodBeat.o(269014);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(269011);
    super.onResume();
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(269011);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(63686);
    super.onStop();
    if (this.pLw != null) {
      this.pLw.clear();
    }
    AppMethodBeat.o(63686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(269009);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(269009);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(268978);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.aa.model.a.class);
    AppMethodBeat.o(268978);
  }
  
  public final void yj(int paramInt)
  {
    AppMethodBeat.i(63691);
    if (bVC()) {
      com.tencent.mm.plugin.aa.model.j.yj(paramInt);
    }
    AppMethodBeat.o(63691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */