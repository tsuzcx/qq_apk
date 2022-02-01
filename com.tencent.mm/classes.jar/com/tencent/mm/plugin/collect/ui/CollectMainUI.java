package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.acx.b;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.collect.model.d;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.f.a;
import com.tencent.mm.plugin.collect.model.l;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.protocal.protobuf.ejd;
import com.tencent.mm.protocal.protobuf.eje;
import com.tencent.mm.protocal.protobuf.fnk;
import com.tencent.mm.protocal.protobuf.rw;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(0)
public class CollectMainUI
  extends WalletPreferenceUI
  implements com.tencent.mm.am.h, d.a, ScreenShotUtil.ScreenShotCallback
{
  private static int xdu;
  private static int xea = -1;
  private static int xeb = -1;
  private static int xec = -1;
  private static int xed = -1;
  private Vibrator cqQ;
  private int igf;
  protected String mTrueName;
  private long owx;
  private com.tencent.mm.ui.base.preference.f pkD;
  private TextView tHK;
  private com.tencent.mm.ui.widget.a.f vlk;
  protected ScrollView xaT;
  private int xcM;
  private int xcN;
  private j xcO;
  private ImageView xcP;
  private TextView xcQ;
  private WalletTextView xcR;
  private TextView xcS;
  private TextView xcT;
  private TextView xcU;
  private RelativeLayout xcV;
  private ViewGroup xcW;
  private View xcX;
  private Dialog xcY;
  private View xcZ;
  private long xct;
  private int xdA;
  private String xdB;
  private String xdC;
  private String xdD;
  private String xdE;
  private String xdF;
  protected CdnImageView xdG;
  protected TextView xdH;
  protected TextView xdI;
  protected ImageView xdJ;
  protected ViewGroup xdK;
  protected View xdL;
  private boolean xdM;
  private int xdN;
  private dot xdO;
  private ejd xdP;
  private ejd xdQ;
  private ejd xdR;
  private LinearLayout xdS;
  private TextView xdT;
  private TextView xdU;
  private TextView xdV;
  private com.tencent.mm.bx.b xdW;
  private g.a xdX;
  private com.tencent.mm.ui.widget.a.f xdY;
  private r.a xdZ;
  private View xda;
  private boolean xdb;
  private View xdc;
  private ImageView xdd;
  private TextView xde;
  private TextView xdf;
  private TextView xdg;
  protected LinearLayout xdh;
  protected TextView xdi;
  private RelativeLayout xdj;
  private Bitmap xdk;
  protected String xdl;
  protected String xdm;
  private String xdn;
  private int xdo;
  private List<a> xdp;
  private double xdq;
  private String xdr;
  private String xds;
  protected boolean xdt;
  private View xdv;
  private b xdw;
  private SpannableStringBuilder xdx;
  private SpannableStringBuilder xdy;
  private com.tencent.mm.plugin.collect.model.f xdz;
  
  public CollectMainUI()
  {
    AppMethodBeat.i(64149);
    this.xcP = null;
    this.xcQ = null;
    this.xcR = null;
    this.xcS = null;
    this.xcT = null;
    this.xcU = null;
    this.xcV = null;
    this.xcX = null;
    this.tHK = null;
    this.pkD = null;
    this.xcY = null;
    this.xcZ = null;
    this.xda = null;
    this.xaT = null;
    this.xdb = false;
    this.xdc = null;
    this.xdk = null;
    this.xdl = null;
    this.mTrueName = null;
    this.xdm = null;
    this.xdn = null;
    this.xdp = new LinkedList();
    this.xdr = null;
    this.xds = null;
    this.xdt = false;
    this.xdw = new b((byte)0);
    this.xdA = 0;
    this.xdM = false;
    this.xdN = 0;
    this.xdZ = new r.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(64125);
        if ((paramAnonymousString == null) || (CollectMainUI.a(CollectMainUI.this) == null))
        {
          AppMethodBeat.o(64125);
          return;
        }
        if (paramAnonymousString.equals(CollectMainUI.a(CollectMainUI.this)))
        {
          Log.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { CollectMainUI.a(CollectMainUI.this), paramAnonymousString });
          CollectMainUI.this.dsv();
        }
        AppMethodBeat.o(64125);
      }
    };
    AppMethodBeat.o(64149);
  }
  
  private void Jp(int paramInt)
  {
    AppMethodBeat.i(293668);
    int i = dsD();
    Object localObject = dsE();
    String str = dsF();
    Log.i("MicroMsg.CollectMainUI", "doSceneSaveQrcodeNotify notifyType:%s，amount: %s,memo: %s,url: %s,mSaveNotifyInfo:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str, this.xdW });
    localObject = new l(paramInt, i, (String)localObject, str, this.xdW);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
    AppMethodBeat.o(293668);
  }
  
  private void a(final agp paramagp)
  {
    AppMethodBeat.i(293682);
    if (paramagp == null)
    {
      Log.i("MicroMsg.CollectMainUI", " coverInfo == null");
      AppMethodBeat.o(293682);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "showCoverUI");
    this.xdS.setVisibility(0);
    this.xdS.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView) {}
    });
    ViewGroup.LayoutParams localLayoutParams = this.xdS.getLayoutParams();
    localLayoutParams.height = this.xcZ.getHeight();
    this.xdS.setLayoutParams(localLayoutParams);
    this.xdT.setText(paramagp.wording);
    this.xdU.setText(paramagp.ZpM.wording);
    this.xdU.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(293590);
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramagp.ZpM);
        AppMethodBeat.o(293590);
      }
    });
    this.xdV.setText(paramagp.ZpN.wording);
    this.xdV.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(293591);
        CollectMainUI.d(CollectMainUI.this, 3);
        CollectMainUI.a(CollectMainUI.this, paramagp.ZpN);
        AppMethodBeat.o(293591);
      }
    });
    AppMethodBeat.o(293682);
  }
  
  private void a(cyw paramcyw)
  {
    AppMethodBeat.i(293677);
    if ((paramcyw == null) || ((this.xcO != null) && (this.xcO.isShowing())))
    {
      Log.i("MicroMsg.CollectMainUI", "mHalfBottomDialog != null || mHalfBottomDialog.isShowing() || halfPage == null ");
      AppMethodBeat.o(293677);
      return;
    }
    if ((this.vlk != null) && (this.vlk.isShowing()))
    {
      Log.i("MicroMsg.CollectMainUI", "mBottomSheet != null && mBottomSheet.isShowing()");
      AppMethodBeat.o(293677);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "showHalfDialog");
    Object localObject1 = paramcyw.aaDK;
    Object localObject2 = paramcyw.aaDL;
    this.xcM = 4;
    this.xcO = new j(getContext(), 1, 3);
    this.xcO.d(((eje)localObject1).wording, ((eje)localObject2).wording);
    this.xcO.a(new j.a()new j.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(293582);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.xeo);
        CollectMainUI.C(CollectMainUI.this).cyW();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(293582);
      }
    }, new j.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(293581);
        CollectMainUI.d(CollectMainUI.this, 1);
        CollectMainUI.a(CollectMainUI.this, this.xep);
        CollectMainUI.C(CollectMainUI.this).cyW();
        CollectMainUI.D(CollectMainUI.this);
        AppMethodBeat.o(293581);
      }
    });
    if (paramcyw.aaDJ.type == 2)
    {
      localObject1 = View.inflate(getContext(), a.g.collect_half_dialog_head_x, null);
      ((ImageView)((View)localObject1).findViewById(a.f.back_cion)).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(293585);
          CollectMainUI.C(CollectMainUI.this).cyW();
          CollectMainUI.D(CollectMainUI.this);
          AppMethodBeat.o(293585);
        }
      });
      localObject2 = (TextView)((View)localObject1).findViewById(a.f.collect_dialog_title);
      ((TextView)localObject2).setText(paramcyw.aaDJ.abNt);
      aw.a(((TextView)localObject2).getPaint(), 0.8F);
      this.xcO.setHeaderView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = View.inflate(getContext(), a.g.collect_half_dialog_content, null);
      ((TextView)((View)localObject1).findViewById(a.f.half_dialog_content)).setText(paramcyw.wording);
      this.xcO.setCustomView((View)localObject1);
      this.xcO.dDn();
      AppMethodBeat.o(293677);
      return;
      localObject1 = View.inflate(getContext(), a.g.collect_half_dialog_head_normal, null);
      localObject2 = (TextView)((View)localObject1).findViewById(a.f.half_dialog_title);
      ((TextView)localObject2).setText(paramcyw.aaDJ.abNt);
      aw.a(((TextView)localObject2).getPaint(), 0.8F);
      this.xcO.setHeaderView((View)localObject1);
    }
  }
  
  private void a(ejd paramejd)
  {
    AppMethodBeat.i(293672);
    if (paramejd == null)
    {
      Log.i("MicroMsg.CollectMainUI", "actionInfo is null");
      AppMethodBeat.o(293672);
      return;
    }
    Log.i("MicroMsg.CollectMainUI", "actionInfo.action_type：%s", new Object[] { Integer.valueOf(paramejd.wuj) });
    switch (paramejd.wuj)
    {
    default: 
      Log.i("MicroMsg.CollectMainUI", "unknow actionInfo.action_type");
      AppMethodBeat.o(293672);
      return;
    case 0: 
      AppMethodBeat.o(293672);
      return;
    case 1: 
      a(paramejd.abnT);
      AppMethodBeat.o(293672);
      return;
    case 2: 
      a(paramejd.abnU);
      AppMethodBeat.o(293672);
      return;
    }
    a(paramejd.abnV);
    AppMethodBeat.o(293672);
  }
  
  private void a(final ejd paramejd, final agp paramagp)
  {
    AppMethodBeat.i(293689);
    Log.i("MicroMsg.CollectMainUI", "doSaveQrCode");
    final int i;
    Object localObject;
    TextView localTextView1;
    LinearLayout localLinearLayout2;
    TextView localTextView4;
    if ((this.xdk != null) && (!this.xdk.isRecycled()))
    {
      i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.model.b.a(this, this.xdl, z.bAM(), this.xdA, this.xdD, i, this.xdZ, false, this.xdo, 0.0F, true);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.xdt)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.xdq * 100.0D)) });
          i = 0;
          if (!this.xdb)
          {
            this.xaT = ((ScrollView)((ViewStub)findViewById(a.f.collect_main_save_view_stub)).inflate());
            dsu();
            this.xdb = true;
            i = 250;
          }
          this.xaT.setVisibility(4);
          ((ImageView)this.xaT.findViewById(a.f.collect_main_save_ftf_pay_qrcode)).setImageBitmap(this.xdk);
          localTextView1 = (TextView)this.xaT.findViewById(a.f.collect_main_save_receiver_1);
          TextView localTextView2 = (TextView)this.xaT.findViewById(a.f.collect_main_save_receiver_2);
          final LinearLayout localLinearLayout1 = (LinearLayout)this.xaT.findViewById(a.f.collect_save_root_layout);
          localLinearLayout2 = (LinearLayout)this.xaT.findViewById(a.f.collect_main_save_fixed_ll);
          TextView localTextView3 = (TextView)this.xaT.findViewById(a.f.collect_main_save_fixed_currency);
          localTextView4 = (TextView)this.xaT.findViewById(a.f.collect_main_save_fixed_desc);
          TextView localTextView5 = (TextView)this.xaT.findViewById(a.f.collect_main_save_fixed_fee);
          String str1 = i.jo(i.getDisplayName(z.bAM()), 10);
          String str2 = getTrueName();
          localObject = str1;
          if (!Util.isNullOrNil(str2)) {
            localObject = str1 + getString(a.i.collect_main_save_bottom_tips2, new Object[] { str2 });
          }
          if (this.xdA != 1) {
            break label597;
          }
          if (Util.isNullOrNil(this.xdC)) {
            break label578;
          }
          localTextView1.setText(this.xdC);
          localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          label422:
          if (!this.xdt) {
            break label626;
          }
          if (Util.isNullOrNil(this.xds)) {
            break label616;
          }
          localTextView4.setText(this.xds);
          localTextView4.setVisibility(0);
          label454:
          localTextView3.setText(dst());
          localTextView5.setText(i.formatMoney2f(this.xdq));
          localLinearLayout2.setVisibility(0);
          label481:
          ExportFileUtil.a(this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(64116);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(293572);
                  Log.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(CollectMainUI.4.this.xef.getHeight()), Integer.valueOf(CollectMainUI.4.this.xef.getWidth()) });
                  Bitmap localBitmap = Bitmap.createBitmap(CollectMainUI.4.this.xef.getWidth(), CollectMainUI.4.this.xef.getHeight(), Bitmap.Config.ARGB_8888);
                  Object localObject = new Canvas(localBitmap);
                  CollectMainUI.4.this.xef.draw((Canvas)localObject);
                  try
                  {
                    localObject = com.tencent.mm.pluginsdk.ui.tools.t.getSysCameraDirPath() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                    BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
                    if (CollectMainUI.4.this.xeg)
                    {
                      Log.i("MicroMsg.CollectMainUI", "doSaveQrCode success ");
                      CollectMainUI.a(CollectMainUI.this, CollectMainUI.this.getContext(), CollectMainUI.this.getContext().getResources().getString(a.i.collect_material_guide_save_text_toast), a.h.icons_filled_done, CollectMainUI.4.this.xeh, CollectMainUI.4.this.xei);
                    }
                    com.tencent.mm.pluginsdk.ui.tools.t.refreshMediaScanner((String)localObject, CollectMainUI.this.getContext());
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      Log.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
                      Toast.makeText(CollectMainUI.this.getContext(), CollectMainUI.this.getString(a.i.collect_qrcode_save_failed), 1).show();
                    }
                  }
                  CollectMainUI.this.xaT.setVisibility(8);
                  AppMethodBeat.o(293572);
                }
              }, i);
              AppMethodBeat.o(64116);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64117);
              Toast.makeText(CollectMainUI.this.getContext(), CollectMainUI.this.getString(a.i.collect_qrcode_save_failed), 1).show();
              AppMethodBeat.o(64117);
            }
          });
          i = 1;
          label508:
          if (i == 0)
          {
            Log.w("MicroMsg.CollectMainUI", "save ftf pay qrcode fail");
            Toast.makeText(getContext(), getString(a.i.collect_qrcode_save_failed), 1).show();
          }
        }
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(293689);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11343, new Object[] { Integer.valueOf(0) });
      break;
      label578:
      localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
      break label422;
      label597:
      localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject, localTextView1.getTextSize()));
      break label422;
      label616:
      localTextView4.setVisibility(8);
      break label454;
      label626:
      localLinearLayout2.setVisibility(8);
      break label481;
      i = 0;
      break label508;
      Log.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
      Toast.makeText(getContext(), getString(a.i.collect_qrcode_save_failed), 1).show();
    }
  }
  
  private void a(final rw paramrw)
  {
    AppMethodBeat.i(293686);
    if (paramrw == null)
    {
      Log.i("MicroMsg.CollectMainUI", " bottomCell == null");
      AppMethodBeat.o(293686);
      return;
    }
    this.xcM = 3;
    this.vlk = new com.tencent.mm.ui.widget.a.f(getContext(), 1, true);
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 56));
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(getResources().getColor(a.c.FG_1));
    localTextView.setText(paramrw.YWI);
    this.vlk.af(localTextView, false);
    this.vlk.ageZ = true;
    this.vlk.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(293595);
        Iterator localIterator = paramrw.YWJ.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          eje localeje = (eje)localIterator.next();
          if ((localeje != null) && (localeje.wording != null))
          {
            paramAnonymouss.c(i, localeje.wording);
            i += 1;
          }
        }
        AppMethodBeat.o(293595);
      }
    };
    this.vlk.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(293592);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        paramAnonymousMenuItem = (eje)paramrw.YWJ.get(paramAnonymousInt);
        CollectMainUI.d(CollectMainUI.this, 2);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousMenuItem);
        AppMethodBeat.o(293592);
      }
    };
    this.vlk.dDn();
    AppMethodBeat.o(293686);
  }
  
  private static dok aY(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(64171);
    dok localdok = new dok();
    localdok.type = paramJSONObject.optInt("type", -1);
    localdok.url = paramJSONObject.optString("url", "");
    localdok.wording = paramJSONObject.optString("wording", "");
    localdok.aaVs = paramJSONObject.optString("waapp_username", "");
    localdok.aaVt = paramJSONObject.optString("waapp_path", "");
    AppMethodBeat.o(64171);
    return localdok;
  }
  
  private Bitmap dP(String paramString, int paramInt)
  {
    AppMethodBeat.i(64159);
    paramString = com.tencent.mm.plugin.collect.model.b.a(this, paramString, z.bAM(), this.xdA, this.xdD, this.xdZ, paramInt);
    AppMethodBeat.o(64159);
    return paramString;
  }
  
  private void dsA()
  {
    AppMethodBeat.i(64167);
    if (!Util.isNullOrNil(this.xdE))
    {
      this.xdi.setText(this.xdE);
      this.xdi.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(293648);
          if (!Util.isNullOrNil(CollectMainUI.u(CollectMainUI.this))) {
            i.p(MMApplicationContext.getContext(), CollectMainUI.u(CollectMainUI.this), true);
          }
          AppMethodBeat.o(293648);
        }
      });
      this.xdh.setVisibility(0);
      AppMethodBeat.o(64167);
      return;
    }
    this.xdh.setVisibility(8);
    AppMethodBeat.o(64167);
  }
  
  private static dok dsB()
  {
    AppMethodBeat.i(64169);
    try
    {
      com.tencent.mm.kernel.h.baF();
      dok localdok = aY(new JSONObject((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTx, "")));
      AppMethodBeat.o(64169);
      return localdok;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64169);
    }
    return null;
  }
  
  private static List<dok> dsC()
  {
    AppMethodBeat.i(64170);
    localArrayList = new ArrayList();
    try
    {
      com.tencent.mm.kernel.h.baF();
      Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTz, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(aY(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(64170);
    }
  }
  
  private int dsD()
  {
    AppMethodBeat.i(293661);
    if ((this.xcR.isShown()) && (!Util.isNullOrNil(this.xcR.getText())))
    {
      int i = Integer.parseInt(i.c(this.xcR.getText(), "100", 0, RoundingMode.HALF_UP).toString());
      AppMethodBeat.o(293661);
      return i;
    }
    AppMethodBeat.o(293661);
    return 0;
  }
  
  private String dsE()
  {
    AppMethodBeat.i(293665);
    if ((this.xcQ.isShown()) && (!Util.isNullOrNil(this.xcQ.getText())))
    {
      String str = this.xcQ.getText().toString();
      AppMethodBeat.o(293665);
      return str;
    }
    AppMethodBeat.o(293665);
    return "";
  }
  
  private String dsF()
  {
    AppMethodBeat.i(293667);
    if (this.xdt)
    {
      if (Util.isNullOrNil(this.xdn))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(293667);
        return "";
      }
      str = this.xdn;
      AppMethodBeat.o(293667);
      return str;
    }
    if (Util.isNullOrNil(this.xdl))
    {
      Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
      AppMethodBeat.o(293667);
      return "";
    }
    String str = this.xdl;
    AppMethodBeat.o(293667);
    return str;
  }
  
  private void dsx()
  {
    AppMethodBeat.i(64157);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64114);
        int i = com.tencent.mm.cd.a.fromDPToPix(CollectMainUI.this.getContext(), 37);
        ViewGroup.LayoutParams localLayoutParams = CollectMainUI.l(CollectMainUI.this).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = i;
          CollectMainUI.l(CollectMainUI.this).setLayoutParams(localLayoutParams);
          CollectMainUI.l(CollectMainUI.this).requestLayout();
        }
        AppMethodBeat.o(64114);
      }
    });
    AppMethodBeat.o(64157);
  }
  
  private void dsy()
  {
    AppMethodBeat.i(64158);
    double d;
    if ((this.xdp != null) && (this.xdp.size() > 0))
    {
      this.xcZ.setBackgroundResource(a.e.collect_header_top_corner);
      this.pkD.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.xdp.size())
      {
        a locala = (a)this.xdp.get(i);
        c localc;
        if (i == this.xdp.size() - 1)
        {
          localc = new c(this, a.g.collect_pay_info_bottom_corner_preference);
          label104:
          localc.setKey(String.valueOf(i));
          String str2 = locala.displayName;
          String str1 = str2;
          if (Util.isNullOrNil(str2))
          {
            str1 = str2;
            if (!Util.isNullOrNil(locala.username)) {
              str1 = i.getDisplayName(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.luk = locala.username;
          if (locala.status != 0) {
            break label221;
          }
          localc.aBk(a.i.collect_main_paying);
        }
        for (;;)
        {
          this.pkD.c(localc);
          i += 1;
          break;
          localc = new c(this);
          break label104;
          label221:
          if (locala.status == 1)
          {
            if (locala.isAnimated)
            {
              d += locala.wZe;
              localc.aS(i.e(locala.wZe, locala.hCH));
            }
            for (;;)
            {
              this.pkD.c(localc);
              break;
              localc.aBk(a.i.collect_main_pay_suc);
            }
          }
          if (locala.status == 2) {
            localc.aBk(a.i.collect_main_pay_cancel);
          }
        }
      }
      this.pkD.notifyDataSetChanged();
      this.xcT.setText(i.e(d, ((a)this.xdp.get(0)).hCH));
      this.xcT.setVisibility(0);
    }
    for (;;)
    {
      if ((this.xdp != null) && (this.xdp.size() > 0))
      {
        this.xdK.setBackgroundResource(a.e.collect_main_assist_bg);
        this.xcX.setVisibility(0);
        if ((d > 0.0D) && (this.xdp.size() > 0))
        {
          this.xdL.setVisibility(0);
          this.xda.setVisibility(0);
          AppMethodBeat.o(64158);
        }
      }
      else
      {
        this.xcT.setVisibility(8);
        this.xcX.setVisibility(8);
        this.xda.setVisibility(8);
      }
      AppMethodBeat.o(64158);
      return;
      d = 0.0D;
    }
  }
  
  private void dsz()
  {
    AppMethodBeat.i(64166);
    bi localbi = com.tencent.mm.plugin.wallet_core.model.k.iis();
    if (this.xdt) {}
    for (int i = 33;; i = 32)
    {
      if (localbi != null) {
        com.tencent.mm.plugin.report.service.h.OAn.b(13447, new Object[] { Integer.valueOf(i), localbi.YCJ, localbi.YCK, this.xdl, Double.valueOf(this.xdq), Long.valueOf(Util.nowSecond()), Long.valueOf(localbi.YCI), localbi.YCL, localbi.YCM });
      }
      AppMethodBeat.o(64166);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.collect.model.t paramt)
  {
    int k = 0;
    AppMethodBeat.i(64160);
    Log.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    int i;
    if (((this.igf != 1) && (this.igf != 0)) || ((paramt.msgType == 9) || ((this.igf == 8) && (paramt.msgType == 26))))
    {
      if (this.cqQ != null) {
        this.cqQ.vibrate(50L);
      }
      if (paramt.fZW < this.owx)
      {
        Log.d("MicroMsg.CollectMainUI", "Recieve but time out ");
        AppMethodBeat.o(64160);
        return;
      }
      i = 0;
      if (i >= this.xdp.size()) {
        break label510;
      }
      if ((paramt.status != 0) || (!Util.nullAsNil(paramt.username).equals(((a)this.xdp.get(i)).username)) || (((a)this.xdp.get(i)).status != 2)) {
        break label320;
      }
      this.xdp.remove(i);
      this.xdp.add(i, new a(paramt));
      i = 1;
    }
    for (;;)
    {
      label209:
      if (i == 0) {
        i = 0;
      }
      for (;;)
      {
        int j = k;
        Object localObject;
        if (i < this.xdp.size())
        {
          localObject = (com.tencent.mm.plugin.collect.model.t)this.xdp.get(i);
          if (paramt.fZW > ((com.tencent.mm.plugin.collect.model.t)localObject).fZW)
          {
            this.xdp.add(i, new a(paramt));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.xdp.add(new a(paramt));
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64115);
              CollectMainUI.m(CollectMainUI.this);
              CollectMainUI.n(CollectMainUI.this).dsL();
              CollectMainUI.i(CollectMainUI.this);
              AppMethodBeat.o(64115);
            }
          });
          AppMethodBeat.o(64160);
          return;
          label320:
          if (paramt.hAU.equals(((a)this.xdp.get(i)).hAU))
          {
            Log.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramt.hAU);
            if (((a)this.xdp.get(i)).status == 0)
            {
              ((a)this.xdp.get(i)).status = paramt.status;
              ((a)this.xdp.get(i)).wZe = paramt.wZe;
              ((a)this.xdp.get(i)).hCH = paramt.hCH;
              if (paramt.status == 1)
              {
                localObject = this.xdw;
                a locala = (a)this.xdp.get(i);
                ((b)localObject).xet.add(locala);
              }
            }
            i = 1;
            break label209;
          }
          i += 1;
          break;
        }
        i += 1;
      }
      label510:
      i = 0;
    }
  }
  
  public boolean d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    return false;
  }
  
  protected void dss()
  {
    AppMethodBeat.i(64168);
    if (com.tencent.mm.plugin.collect.model.f.wYd == null) {
      com.tencent.mm.plugin.collect.model.f.wYd = new com.tencent.mm.plugin.collect.model.f();
    }
    this.xdz = com.tencent.mm.plugin.collect.model.f.wYd;
    Object localObject = this.xdz;
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1588, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.plugin.collect.model.f localf = this.xdz;
    f.a local7 = new f.a()
    {
      public final void U(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        AppMethodBeat.i(293662);
        Log.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt) });
        CollectMainUI.v(CollectMainUI.this).setVisibility(0);
        CollectMainUI.this.xdl = paramAnonymousString1;
        CollectMainUI.a(CollectMainUI.this, paramAnonymousInt);
        CollectMainUI.this.mTrueName = paramAnonymousString2;
        paramAnonymousString1 = CollectMainUI.dsJ();
        paramAnonymousString2 = CollectMainUI.dsK();
        CollectMainUI.a(CollectMainUI.this, paramAnonymousString1);
        CollectMainUI.this.eY(paramAnonymousString2);
        if (CollectMainUI.w(CollectMainUI.this) == 1)
        {
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.h.baF();
          CollectMainUI.b(paramAnonymousString1, ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUk, Integer.valueOf(-1))).intValue());
          paramAnonymousString1 = CollectMainUI.this;
          com.tencent.mm.kernel.h.baF();
          CollectMainUI.a(paramAnonymousString1, (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUl, ""));
        }
        AppMethodBeat.o(293662);
      }
      
      public final void a(boolean paramAnonymousBoolean, xp paramAnonymousxp)
      {
        AppMethodBeat.i(293671);
        Object localObject;
        if (paramAnonymousxp == null)
        {
          localObject = "null";
          Log.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), localObject });
          if (!paramAnonymousBoolean) {
            break label499;
          }
          if ((paramAnonymousxp == null) || (paramAnonymousxp.hAV != 416)) {
            break label189;
          }
          if (paramAnonymousxp.Zgn != null) {
            break label184;
          }
        }
        label184:
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          Log.d("MicroMsg.CollectMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          CollectMainUI.v(CollectMainUI.this).setVisibility(4);
          CollectMainUI.a(CollectMainUI.this, true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
          ((Bundle)localObject).putString("realname_verify_process_jump_plugin", "collect");
          CollectMainUI localCollectMainUI = CollectMainUI.this;
          int i = paramAnonymousxp.hAV;
          paramAnonymousxp = paramAnonymousxp.Zgn;
          new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(293608);
              Log.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
              AppMethodBeat.o(293608);
            }
          };
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(localCollectMainUI, i, paramAnonymousxp, (Bundle)localObject, 1010);
          AppMethodBeat.o(293671);
          return;
          localObject = Integer.valueOf(paramAnonymousxp.hAV);
          break;
        }
        label189:
        CollectMainUI.this.dsw();
        CollectMainUI.v(CollectMainUI.this).setVisibility(0);
        CollectMainUI.a(CollectMainUI.this, false);
        CollectMainUI.this.xdl = paramAnonymousxp.url;
        CollectMainUI.a(CollectMainUI.this, ah.aGs(paramAnonymousxp.ZfZ));
        CollectMainUI.this.mTrueName = paramAnonymousxp.VBL;
        CollectMainUI.b(CollectMainUI.this, paramAnonymousxp.Okk);
        CollectMainUI.b(CollectMainUI.this, paramAnonymousxp.Oiv);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousxp.Okl);
        CollectMainUI.c(CollectMainUI.this, paramAnonymousxp.Zgk);
        CollectMainUI.d(CollectMainUI.this, paramAnonymousxp.pHt);
        CollectMainUI.e(CollectMainUI.this, paramAnonymousxp.pHu);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousxp.Zgh);
        CollectMainUI.this.eY(paramAnonymousxp.Zgg);
        CollectMainUI.c(CollectMainUI.this, paramAnonymousxp.Zgl);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousxp.Zgm);
        Log.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.x(CollectMainUI.this)) });
        CollectMainUI.c(CollectMainUI.this, paramAnonymousxp.Zgr);
        CollectMainUI.d(CollectMainUI.this, paramAnonymousxp.Zgs);
        CollectMainUI.e(CollectMainUI.this, paramAnonymousxp.Zgt);
        CollectMainUI.a(CollectMainUI.this, paramAnonymousxp.Zgu);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUk, Integer.valueOf(CollectMainUI.y(CollectMainUI.this)));
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUl, CollectMainUI.a(CollectMainUI.this));
        CollectMainUI.this.refreshView();
        label499:
        AppMethodBeat.o(293671);
      }
    };
    com.tencent.mm.kernel.h.baF();
    String str1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTu, "");
    com.tencent.mm.kernel.h.baF();
    String str2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTv, "");
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTw, Integer.valueOf(-1))).intValue();
    localObject = str1;
    if (Util.isNullOrNil(str1))
    {
      Log.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = u.iiC().ijo();
    }
    local7.U((String)localObject, str2, i);
    localObject = new com.tencent.mm.plugin.collect.model.k();
    localf.vcA.put(localObject, local7);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0);
    AppMethodBeat.o(64168);
  }
  
  protected String dst()
  {
    AppMethodBeat.i(64173);
    String str = i.bEK(this.xdr);
    AppMethodBeat.o(64173);
    return str;
  }
  
  protected void dsu() {}
  
  protected void dsv()
  {
    AppMethodBeat.i(64156);
    this.xcP.setImageBitmap(null);
    if (this.xdt)
    {
      if (Util.isNullOrNil(this.xdn))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.xdk = dP(this.xdn, this.xdo);
      if ((this.xdk == null) || (this.xdk.isRecycled())) {
        break label237;
      }
      this.xcP.setImageBitmap(this.xdk);
      label91:
      if (!this.xdt) {
        break label281;
      }
      this.xcR.setPrefix(dst());
      this.xcR.setText(i.formatMoney2f(this.xdq));
      this.xcR.setVisibility(0);
      if (Util.isNullOrNil(this.xds)) {
        break label269;
      }
      this.xcQ.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.xds, this.xcQ.getTextSize()));
      this.xcQ.setVisibility(0);
    }
    for (;;)
    {
      findViewById(a.f.collect_main_fixed_layout).setVisibility(0);
      AppMethodBeat.o(64156);
      return;
      if (Util.isNullOrNil(this.xdl))
      {
        Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        AppMethodBeat.o(64156);
        return;
      }
      this.xdk = dP(this.xdl, this.xdo);
      break;
      label237:
      Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + Util.nullAsNil(this.xdn));
      break label91;
      label269:
      this.xcQ.setVisibility(8);
    }
    label281:
    this.xcS.setVisibility(8);
    this.xcR.setVisibility(8);
    this.xcQ.setVisibility(8);
    findViewById(a.f.collect_main_fixed_layout).setVisibility(8);
    AppMethodBeat.o(64156);
  }
  
  protected final void dsw()
  {
    AppMethodBeat.i(293752);
    com.tencent.mm.kernel.h.baF();
    g.a locala;
    Resources localResources;
    int i;
    if (((String)com.tencent.mm.kernel.h.baE().ban().d(327731, "0")).equals("0"))
    {
      this.xdX = new g.a(getContext());
      this.xdX.bf(getResources().getString(a.i.collect_main_first_enter_tips_title));
      locala = this.xdX;
      localResources = getResources();
      if (!z.bBi()) {
        break label169;
      }
      i = a.i.collect_main_first_enter_tips_payu;
    }
    for (;;)
    {
      locala = locala.bDE(localResources.getString(i)).NF(true);
      locala.Xdm = true;
      locala.aEX(a.i.wallet_alert_btn_string).b(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }).show();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(327731, "1");
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().iZy();
      AppMethodBeat.o(293752);
      return;
      label169:
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXe, false)) {
        i = a.i.collect_main_first_enter_tips_new;
      } else {
        i = a.i.collect_main_first_enter_tips;
      }
    }
  }
  
  protected final void eY(final List<dok> paramList)
  {
    AppMethodBeat.i(64174);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        dok localdok = (dok)localIterator.next();
        if (localdok.type == 1) {
          com.tencent.mm.plugin.report.service.h.OAn.b(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localdok.wording, "", "", "", Integer.valueOf(1) });
        } else if (localdok.type == 2) {
          com.tencent.mm.plugin.report.service.h.OAn.b(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localdok.wording, "", "", localdok.url, Integer.valueOf(1) });
        } else if (localdok.type == 3) {
          com.tencent.mm.plugin.report.service.h.OAn.b(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localdok.wording, localdok.aaVs, localdok.aaVt, "", Integer.valueOf(1) });
        }
      }
    }
    this.xdj.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(293652);
        CollectMainUI.a(CollectMainUI.this, new com.tencent.mm.ui.widget.a.f(CollectMainUI.this.getContext(), 1, false));
        CollectMainUI.z(CollectMainUI.this).Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
          {
            AppMethodBeat.i(293631);
            com.tencent.mm.plugin.collect.app.a.dru();
            if (com.tencent.mm.plugin.collect.app.a.drw()) {
              paramAnonymous2s.add(0, 1, 0, a.i.collect_main_close_ring_tone);
            }
            while (CollectMainUI.9.this.pZG != null)
            {
              int i = 0;
              while (i < CollectMainUI.9.this.pZG.size())
              {
                dok localdok = (dok)CollectMainUI.9.this.pZG.get(i);
                if (!Util.isNullOrNil(localdok.wording)) {
                  paramAnonymous2s.add(0, i + 1 + 1, 0, localdok.wording);
                }
                i += 1;
              }
              paramAnonymous2s.add(0, 1, 0, a.i.collect_main_open_ring_tone);
            }
            AppMethodBeat.o(293631);
          }
        };
        CollectMainUI.z(CollectMainUI.this).GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(293639);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId() - 1 - 1;
              if (paramAnonymous2Int < 0)
              {
                Log.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                AppMethodBeat.o(293639);
                return;
              }
              break;
            case 1: 
              com.tencent.mm.plugin.collect.app.a.dru();
              if (com.tencent.mm.plugin.collect.app.a.drw())
              {
                CollectMainUI.A(CollectMainUI.this);
                Toast.makeText(CollectMainUI.this.getContext(), a.i.collect_main_close_ring_tone_tips, 1).show();
                com.tencent.mm.plugin.report.service.h.OAn.b(13944, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(293639);
                return;
              }
              CollectMainUI.B(CollectMainUI.this);
              Toast.makeText(CollectMainUI.this.getContext(), a.i.collect_main_open_ring_tone_tips, 1).show();
              com.tencent.mm.plugin.collect.model.voice.a.drL().nu(false);
              com.tencent.mm.plugin.report.service.h.OAn.b(13944, new Object[] { Integer.valueOf(7) });
              AppMethodBeat.o(293639);
              return;
            }
            paramAnonymous2MenuItem = (dok)CollectMainUI.9.this.pZG.get(paramAnonymous2Int);
            if (paramAnonymous2MenuItem.type == 1)
            {
              Log.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramAnonymous2MenuItem.url });
              com.tencent.mm.plugin.report.service.h.OAn.b(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramAnonymous2MenuItem.wording, "", "", "", Integer.valueOf(2) });
              AppMethodBeat.o(293639);
              return;
            }
            if (paramAnonymous2MenuItem.type == 2)
            {
              if (!Util.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                i.p(CollectMainUI.this.getContext(), paramAnonymous2MenuItem.url, false);
                com.tencent.mm.plugin.report.service.h.OAn.b(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramAnonymous2MenuItem.wording, "", "", paramAnonymous2MenuItem.url, Integer.valueOf(2) });
                AppMethodBeat.o(293639);
              }
            }
            else if (paramAnonymous2MenuItem.type == 3)
            {
              zp localzp = new zp();
              localzp.icM.userName = paramAnonymous2MenuItem.aaVs;
              localzp.icM.icO = Util.nullAs(paramAnonymous2MenuItem.aaVt, "");
              localzp.icM.scene = 1072;
              localzp.icM.icP = 0;
              localzp.publish();
              com.tencent.mm.plugin.report.service.h.OAn.b(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramAnonymous2MenuItem.wording, paramAnonymous2MenuItem.aaVs, paramAnonymous2MenuItem.aaVt, "", Integer.valueOf(2) });
            }
            AppMethodBeat.o(293639);
          }
        };
        CollectMainUI.z(CollectMainUI.this).dDn();
        AppMethodBeat.o(293652);
      }
    });
    AppMethodBeat.o(64174);
  }
  
  public void finish()
  {
    AppMethodBeat.i(64165);
    super.finish();
    overridePendingTransition(a.a.slide_left_in, a.a.slide_right_out);
    AppMethodBeat.o(64165);
  }
  
  public int getHeaderResourceId()
  {
    return a.g.collect_main_header;
  }
  
  public int getLayoutId()
  {
    return a.g.collect_main;
  }
  
  public int getResourceId()
  {
    return a.m.collect_main_preference;
  }
  
  protected String getTrueName()
  {
    AppMethodBeat.i(64172);
    if (Util.isNullOrNil(this.mTrueName))
    {
      this.mTrueName = u.iiC().getTrueName();
      this.mTrueName = i.bEN(this.mTrueName);
    }
    String str = this.mTrueName;
    AppMethodBeat.o(64172);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64153);
    setMMTitle(a.i.offline_collect_btn_text);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64130);
        CollectMainUI.this.finish();
        AppMethodBeat.o(64130);
        return true;
      }
    });
    this.pkD = getPreferenceScreen();
    this.xcV = ((RelativeLayout)findViewById(a.f.root));
    this.xcW = ((ViewGroup)findViewById(a.f.collect_root_layout));
    this.xcW.setBackgroundColor(getResources().getColor(a.c.UN_Yellow_BG_100));
    this.xcX = findViewById(a.f.collect_main_receive_area);
    this.xdL = findViewById(a.f.collect_main_receive_area_1);
    this.xcR = ((WalletTextView)findViewById(a.f.collect_main_fixed_fee));
    this.xcQ = ((TextView)findViewById(a.f.collect_main_fixed_desc));
    this.xcS = ((TextView)findViewById(a.f.collect_main_fixed_fee_currency));
    this.xcT = ((TextView)findViewById(a.f.collect_main_receice_amount));
    this.xdh = ((LinearLayout)findViewById(a.f.notice_ui));
    this.xdi = ((TextView)findViewById(a.f.banner_tips));
    this.xcZ = ((RelativeLayout)findViewById(a.f.collect_main_qrcode_area));
    this.xda = findViewById(a.f.collect_main_header_divider);
    this.xdv = LayoutInflater.from(this).inflate(a.g.collect_main_footer, null, false);
    this.xcU = ((TextView)findViewById(a.f.collect_main_save_qrcode));
    Object localObject = new SpannableStringBuilder(getString(a.i.collect_main_save_qrcode));
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(6, new s.a()
    {
      public final void eS(View paramAnonymousView)
      {
        AppMethodBeat.i(64132);
        CollectMainUI.a(CollectMainUI.this, CollectMainUI.b(CollectMainUI.this));
        CollectMainUI.c(CollectMainUI.this);
        if (CollectMainUI.b(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.OAn.b(20032, new Object[] { "wxface2face", "ClickQRCode", "", "", "", "", Integer.valueOf(2), Integer.valueOf(CollectMainUI.b(CollectMainUI.this).wuj), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(13944, new Object[] { Integer.valueOf(5) });
        AppMethodBeat.o(64132);
      }
    }, (byte)0), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.xcU.setText((CharSequence)localObject);
    this.xcU.setClickable(true);
    this.xcU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
    getListView().addFooterView(this.xdv, null, false);
    getListView().setFooterDividersEnabled(false);
    this.xcP = ((ImageView)findViewById(a.f.collect_main_ftf_pay_qrcode));
    this.tHK = ((TextView)findViewById(a.f.collect_main_tips));
    this.xdg = ((TextView)findViewById(a.f.collect_set_money_tv));
    this.xdg.setClickable(true);
    this.xdg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
    this.xdx = new SpannableStringBuilder(getString(a.i.collect_main_fixed));
    this.xdy = new SpannableStringBuilder(getString(a.i.collect_main_fixed_cancel));
    localObject = new com.tencent.mm.plugin.wallet_core.ui.s(6, new s.a()
    {
      public final void eS(View paramAnonymousView)
      {
        AppMethodBeat.i(64133);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(CollectMainUI.this.getContext(), CollectCreateQRCodeNewUI.class);
        paramAnonymousView.putExtra("key_currency_unit", CollectMainUI.this.xdm);
        CollectMainUI.this.startActivityForResult(paramAnonymousView, 4096);
        AppMethodBeat.o(64133);
      }
    }, (byte)0);
    com.tencent.mm.plugin.wallet_core.ui.s locals = new com.tencent.mm.plugin.wallet_core.ui.s(6, new s.a()
    {
      public final void eS(View paramAnonymousView)
      {
        AppMethodBeat.i(64134);
        CollectMainUI.this.xdt = false;
        CollectMainUI.this.dsv();
        CollectMainUI.h(CollectMainUI.this).setText(CollectMainUI.g(CollectMainUI.this));
        CollectMainUI.i(CollectMainUI.this);
        AppMethodBeat.o(64134);
      }
    }, (byte)0);
    this.xdx.setSpan(localObject, 0, this.xdx.length(), 18);
    this.xdy.setSpan(locals, 0, this.xdy.length(), 18);
    this.xdg.setText(this.xdx);
    this.xdj = ((RelativeLayout)findViewById(a.f.collect_menu_more_btn_layout));
    this.xcP.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(293577);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        CollectMainUI.b(CollectMainUI.this, CollectMainUI.j(CollectMainUI.this));
        if (CollectMainUI.j(CollectMainUI.this) != null) {
          com.tencent.mm.plugin.report.service.h.OAn.b(20032, new Object[] { "wxface2face", "LongClick", "", "", "", "", Integer.valueOf(3), Integer.valueOf(CollectMainUI.j(CollectMainUI.this).wuj), Integer.valueOf(0), CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this) });
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(293577);
        return true;
      }
    });
    this.xdc = findViewById(a.f.collect_main_receive_toast);
    this.xdd = ((ImageView)findViewById(a.f.collect_receive_toast_avatar));
    this.xde = ((TextView)findViewById(a.f.collect_receive_toast_name));
    this.xdf = ((TextView)findViewById(a.f.collect_receive_toast_fee));
    this.xdG = ((CdnImageView)findViewById(a.f.collect_assist_icon));
    this.xdH = ((TextView)findViewById(a.f.collect_assist_title));
    this.xdI = ((TextView)findViewById(a.f.collect_assist_wording));
    this.xdJ = ((ImageView)findViewById(a.f.collect_assist_red_dot));
    this.xdK = ((ViewGroup)findViewById(a.f.collect_assist_layout));
    this.xcZ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293576);
        int[] arrayOfInt = new int[2];
        CollectMainUI.k(CollectMainUI.this).getLocationInWindow(arrayOfInt);
        CollectMainUI.Jq(arrayOfInt[1]);
        AppMethodBeat.o(293576);
      }
    }, 300L);
    localObject = new acx();
    ((acx)localObject).igk.scene = "8";
    ((acx)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64141);
        if (!Util.isNullOrNil(this.xer.igl.igm))
        {
          i.a(null, (TextView)CollectMainUI.this.findViewById(a.f.banner_tips), this.xer.igl.igm, this.xer.igl.content, this.xer.igl.url);
          AppMethodBeat.o(64141);
          return;
        }
        Log.i("MicroMsg.CollectMainUI", "no bulletin data");
        AppMethodBeat.o(64141);
      }
    };
    ((acx)localObject).publish();
    this.xdS = ((LinearLayout)findViewById(a.f.collect_mask_cover_layout));
    this.xdT = ((TextView)findViewById(a.f.collect_mask_title));
    this.xdU = ((Button)findViewById(a.f.collect_mask_first_button));
    this.xdV = ((Button)findViewById(a.f.collect_mask_second_button));
    AppMethodBeat.o(64153);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64161);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(64161);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.xdn = paramIntent.getStringExtra("ftf_pay_url");
        this.xdo = paramIntent.getIntExtra("key_error_level", -1);
        this.xdq = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.xdr = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.xds = paramIntent.getStringExtra("ftf_fixed_desc");
        this.xdm = paramIntent.getStringExtra("key_currency_unit");
        this.xdg.setText(this.xdy);
      }
      for (this.xdt = true;; this.xdt = false)
      {
        refreshView();
        dsx();
        AppMethodBeat.o(64161);
        return;
      }
      this.xct = z.bAR();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64150);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    if (paramBundle.screenBrightness < 0.85F)
    {
      paramBundle.screenBrightness = 0.85F;
      getWindow().setAttributes(paramBundle);
    }
    setIsDarkActionbarBg(true);
    setNavigationbarColor(getResources().getColor(a.c.UN_Yellow_BG_100));
    setActionbarElementColor(getResources().getColor(a.c.White));
    hideActionbarLine();
    getContentView().setBackgroundColor(getResources().getColor(a.c.UN_Yellow_BG_100));
    com.tencent.mm.kernel.h.baF();
    this.igf = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
    this.xct = z.bAR();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    com.tencent.mm.plugin.report.service.h.OAn.b(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    com.tencent.mm.plugin.collect.app.a.dru();
    paramBundle = com.tencent.mm.plugin.collect.app.a.drv();
    if (!paramBundle.eNV.contains(this)) {
      paramBundle.eNV.add(this);
    }
    initView();
    dss();
    refreshView();
    this.cqQ = ((Vibrator)getSystemService("vibrator"));
    this.owx = Util.nowSecond();
    if (xea < 0)
    {
      paramBundle = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
      xea = paramBundle.widthPixels / 2 - BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 20.0F);
      xeb = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 60.0F);
      xec = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 40.0F);
      xed = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 70.0F);
    }
    dsx();
    ac.pu(16, 0);
    com.tencent.mm.kernel.h.aZW().a(3781, this);
    AppMethodBeat.o(64150);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64152);
    if (this.xcP != null) {
      this.xcP.setImageBitmap(null);
    }
    Object localObject = this.xdk;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      Log.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.xcY != null) {
      this.xcY.dismiss();
    }
    com.tencent.mm.plugin.collect.app.a.dru();
    com.tencent.mm.plugin.collect.app.a.drv().eNV.remove(this);
    this.cqQ.cancel();
    if (this.xdz != null)
    {
      localObject = this.xdz;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.model.f)localObject).vcA.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Log.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.model.f)localObject).vcA.clear();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(1588, (com.tencent.mm.am.h)localObject);
    }
    r.c(this.xdZ);
    com.tencent.mm.kernel.h.aZW().b(3781, this);
    super.onDestroy();
    AppMethodBeat.o(64152);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64163);
    super.onPause();
    ScreenShotUtil.setScreenShotCallback(this, null);
    AppMethodBeat.o(64163);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64162);
    super.onResume();
    ScreenShotUtil.setScreenShotCallback(this, this);
    AppMethodBeat.o(64162);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(293762);
    Log.i("MicroMsg.CollectMainUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof l)) {
      Log.i("MicroMsg.CollectMainUI", "scene is NetSceneF2fQrcodeSaveNotify");
    }
    AppMethodBeat.o(293762);
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(293757);
    Log.i("MicroMsg.CollectMainUI", "do screen shot");
    com.tencent.mm.plugin.report.service.h.OAn.b(13944, new Object[] { Integer.valueOf(9) });
    if (this.xdP != null) {
      com.tencent.mm.plugin.report.service.h.OAn.b(20032, new Object[] { "wxface2face", "ScreenShot", "", "", "", "", Integer.valueOf(1), Integer.valueOf(this.xdP.wuj), Integer.valueOf(0), dsF(), Integer.valueOf(dsD()), dsE() });
    }
    if (((this.xdY != null) && (this.xdY.isShowing())) || ((this.xdX != null) && (this.xdX.pRv != null) && (this.xdX.pRv.isShowing())))
    {
      Log.i("MicroMsg.CollectMainUI", "helper.isShowing() || isShowTips, do not showScreen Action");
      AppMethodBeat.o(293757);
      return;
    }
    a(this.xdP);
    Jp(1);
    AppMethodBeat.o(293757);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void refreshView()
  {
    AppMethodBeat.i(64155);
    if (Util.isNullOrNil(this.xdl))
    {
      Log.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
      AppMethodBeat.o(64155);
      return;
    }
    if (this.xdA == 1)
    {
      if (!Util.isNullOrNil(this.xdB)) {
        this.tHK.setText(this.xdB);
      }
      if (!Util.isNullOrNil(this.xdC))
      {
        TextView localTextView = (TextView)findViewById(a.f.collect_main_hk_tips);
        localTextView.setText(this.xdC);
        localTextView.setVisibility(0);
      }
    }
    dsv();
    dsy();
    dsz();
    dsA();
    AppMethodBeat.o(64155);
  }
  
  public final void setStatusColor()
  {
    AppMethodBeat.i(64151);
    setActionbarColor(getResources().getColor(a.c.UN_Yellow_BG_100));
    setActionbarElementColor(getResources().getColor(a.c.White));
    AppMethodBeat.o(64151);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(293751);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.collect.a.b.class);
    AppMethodBeat.o(293751);
  }
  
  final class a
    extends com.tencent.mm.plugin.collect.model.t
  {
    public boolean isAnimated = false;
    
    public a(com.tencent.mm.plugin.collect.model.t paramt)
    {
      this.username = paramt.username;
      this.hAU = paramt.hAU;
      this.wZe = paramt.wZe;
      this.fZW = paramt.fZW;
      this.scene = paramt.scene;
      this.status = paramt.status;
      this.displayName = paramt.displayName;
    }
  }
  
  final class b
  {
    boolean xes;
    LinkedList<CollectMainUI.a> xet;
    
    private b()
    {
      AppMethodBeat.i(64145);
      this.xet = new LinkedList();
      AppMethodBeat.o(64145);
    }
    
    private int Jr(int paramInt)
    {
      AppMethodBeat.i(64146);
      float f2 = 0.0F + CollectMainUI.k(CollectMainUI.this).getHeight() / 2;
      float f1 = f2;
      if (CollectMainUI.o(CollectMainUI.this).getVisibility() == 0) {
        f1 = f2 + CollectMainUI.o(CollectMainUI.this).getHeight();
      }
      f2 = CollectMainUI.dsH() * paramInt + CollectMainUI.dsH() / 2;
      int[] arrayOfInt = new int[2];
      CollectMainUI.k(CollectMainUI.this).getLocationInWindow(arrayOfInt);
      paramInt = (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.dsI()));
      AppMethodBeat.o(64146);
      return paramInt;
    }
    
    private void a(final CollectMainUI.a parama)
    {
      AppMethodBeat.i(64148);
      this.xes = true;
      CollectMainUI.m(CollectMainUI.this);
      CollectMainUI.p(CollectMainUI.this).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.k(CollectMainUI.this).getWidth(), CollectMainUI.k(CollectMainUI.this).getHeight() + com.tencent.mm.cd.a.fromDPToPix(CollectMainUI.this.getContext(), 8)));
      CollectMainUI.q(CollectMainUI.this).setText(com.tencent.mm.pluginsdk.ui.span.p.b(CollectMainUI.this.getContext(), parama.displayName, CollectMainUI.q(CollectMainUI.this).getTextSize()));
      a.b.g(CollectMainUI.r(CollectMainUI.this), parama.username);
      CollectMainUI.s(CollectMainUI.this).setText(i.e(parama.wZe, parama.hCH));
      CollectMainUI.p(CollectMainUI.this).setVisibility(0);
      final AnimationSet localAnimationSet = new AnimationSet(false);
      localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
      int j = 0;
      int i = 0;
      while (i < CollectMainUI.t(CollectMainUI.this).size())
      {
        if (((CollectMainUI.a)CollectMainUI.t(CollectMainUI.this).get(i)).hAU.equals(parama.hAU)) {
          j = i;
        }
        i += 1;
      }
      localAnimationSet.addAnimation(new TranslateAnimation(0.0F, CollectMainUI.dsG(), 0.0F, Jr(j)));
      localAnimationSet.setDuration(300L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64142);
          CollectMainUI.p(CollectMainUI.this).setVisibility(8);
          Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + parama.hAU);
          int i = 0;
          for (;;)
          {
            if (i < CollectMainUI.t(CollectMainUI.this).size())
            {
              if (((CollectMainUI.a)CollectMainUI.t(CollectMainUI.this).get(i)).hAU.equals(parama.hAU))
              {
                ((CollectMainUI.a)CollectMainUI.t(CollectMainUI.this).get(i)).isAnimated = true;
                Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + parama.hAU);
              }
            }
            else
            {
              CollectMainUI.m(CollectMainUI.this);
              CollectMainUI.b.this.xes = false;
              CollectMainUI.b.this.dsL();
              AppMethodBeat.o(64142);
              return;
            }
            i += 1;
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      parama = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      parama.setDuration(300L);
      parama.setInterpolator(new LinearInterpolator());
      parama.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64143);
          localAnimationSet.setStartOffset(1700L);
          CollectMainUI.p(CollectMainUI.this).startAnimation(localAnimationSet);
          AppMethodBeat.o(64143);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(64144);
          CollectMainUI.p(CollectMainUI.this).setVisibility(0);
          AppMethodBeat.o(64144);
        }
      });
      CollectMainUI.p(CollectMainUI.this).startAnimation(parama);
      AppMethodBeat.o(64148);
    }
    
    public final void dsL()
    {
      AppMethodBeat.i(64147);
      if (!this.xes)
      {
        if (!this.xet.isEmpty())
        {
          a((CollectMainUI.a)this.xet.poll());
          AppMethodBeat.o(64147);
        }
      }
      else {
        Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.xet.size());
      }
      AppMethodBeat.o(64147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */