package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.du;
import com.tencent.mm.f.b.a.ba;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.e.j.1;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pluginsdk.model.m.a;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.view.SmileySubGrid;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, i, MStorage.IOnStorageChange
{
  private static c uLD;
  private int IB;
  private View Xd;
  private int clC;
  private Context mContext;
  private MMHandler mHandler;
  private int mNumColumns;
  private ProgressDialog mRa;
  private long uEM;
  private String uEN;
  private com.tencent.mm.plugin.emoji.i.c uEQ;
  private ba uES;
  private String uFI;
  private String uFJ;
  private String uFK;
  private IListener uHA;
  private akb uHP;
  private String uHQ;
  private int uHw;
  private com.tencent.mm.plugin.emoji.f.h uKA;
  private com.tencent.mm.plugin.emoji.f.p uKB;
  private a uKC;
  private buj uKD;
  private boolean uKE;
  private TextView uKF;
  private View uKG;
  private EmojiDetailScrollView uKH;
  private BannerEmojiView uKI;
  private TextView uKJ;
  private MMAutoSizeTextView uKK;
  private TextView uKL;
  private TextView uKM;
  private TextView uKN;
  private EmojiDetailGridView uKO;
  private ImageView uKP;
  private View uKQ;
  private TextView uKR;
  private TextView uKS;
  private View uKT;
  private int uKU;
  private View uKV;
  private ProgressBar uKW;
  private View uKX;
  private ImageView uKY;
  private TextView uKZ;
  private int uKu;
  private String uKv;
  private boolean uKw;
  private boolean uKx;
  private int uKy;
  private com.tencent.mm.plugin.emoji.f.m uKz;
  private View.OnClickListener uLA;
  private View.OnClickListener uLB;
  private View.OnClickListener uLC;
  private com.tencent.mm.ay.a.c.l uLE;
  private m.a uLF;
  private View uLa;
  private View uLb;
  private TextView uLc;
  private Button uLd;
  private DonorsAvatarView uLe;
  private TextView uLf;
  private int uLg;
  private int uLh;
  private int uLi;
  private String uLj;
  private boolean uLk;
  private int uLl;
  private int uLm;
  private String uLn;
  private String uLo;
  private String uLp;
  private String[] uLq;
  private boolean uLr;
  private View uLs;
  private boolean uLt;
  private bub uLu;
  private boolean uLv;
  private boolean uLw;
  private boolean uLx;
  private s uLy;
  private View.OnClickListener uLz;
  private ProgressBar uzL;
  
  static
  {
    AppMethodBeat.i(176199);
    uLD = new c((byte)0);
    AppMethodBeat.o(176199);
  }
  
  public EmojiStoreDetailUI()
  {
    AppMethodBeat.i(109009);
    this.uKx = false;
    this.uKy = -1;
    this.uHP = new akb();
    this.uHQ = "";
    this.uKD = null;
    this.uEM = 0L;
    this.uEN = "";
    this.uLm = -1;
    this.uLq = new String[1];
    this.uLr = false;
    this.uLt = true;
    this.uLv = false;
    this.uLw = true;
    this.uLx = false;
    this.uHA = new IListener() {};
    this.uLz = new EmojiStoreDetailUI.12(this);
    this.uLA = new EmojiStoreDetailUI.15(this);
    this.uLB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108994);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).Suv);
        if ((EmojiStoreDetailUI.b(EmojiStoreDetailUI.this) != null) && (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).VHL != null)) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).VHL.CMP);
        }
        ((Intent)localObject).putExtra("scene", EmojiStoreDetailUI.c(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("pageType", 1);
        ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.IzE.a(12738, new Object[] { EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(EmojiStoreDetailUI.this)), Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108994);
      }
    };
    this.uLC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108995);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_iconurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).CNj);
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).Suv);
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).VHL != null) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).VHL.CMP);
        }
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108995);
      }
    };
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108996);
        switch (paramAnonymousMessage.what)
        {
        default: 
          Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
          AppMethodBeat.o(108996);
          return;
        case 1001: 
          EmojiStoreDetailUI.e(EmojiStoreDetailUI.this);
          AppMethodBeat.o(108996);
          return;
        case 1002: 
          EmojiStoreDetailUI.f(EmojiStoreDetailUI.this);
          AppMethodBeat.o(108996);
          return;
        case 1003: 
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          AppMethodBeat.o(108996);
          return;
        case 1004: 
          if (EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).getVisibility() == 0)
          {
            EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(8);
            EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(0);
            EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(0);
          }
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(EmojiStoreDetailUI.k(EmojiStoreDetailUI.this));
          AppMethodBeat.o(108996);
          return;
        case 1005: 
          EmojiStoreDetailUI.m(EmojiStoreDetailUI.this).scrollTo(0, 0);
          AppMethodBeat.o(108996);
          return;
        case 1006: 
          EmojiStoreDetailUI.n(EmojiStoreDetailUI.this);
          AppMethodBeat.o(108996);
          return;
        }
        EmojiStoreDetailUI.this.cWj();
        AppMethodBeat.o(108996);
      }
    };
    this.uLE = new com.tencent.mm.ay.a.c.l()
    {
      public final void GK(long paramAnonymousLong)
      {
        AppMethodBeat.i(176192);
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10930, EmojiStoreDetailUI.a(EmojiStoreDetailUI.this) + "," + paramAnonymousLong);
        AppMethodBeat.o(176192);
      }
    };
    this.uLF = new m.a()
    {
      public final void Y(ArrayList<u> paramAnonymousArrayList)
      {
        AppMethodBeat.i(176191);
        int i;
        if (paramAnonymousArrayList == null)
        {
          i = 0;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish] %s", new Object[] { Integer.valueOf(i) });
          EmojiStoreDetailUI.B(EmojiStoreDetailUI.this);
          if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
          {
            paramAnonymousArrayList = (u)paramAnonymousArrayList.get(0);
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", new Object[] { paramAnonymousArrayList });
            if (paramAnonymousArrayList.QVB != 10232) {
              break label175;
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 4);
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousArrayList.QVy);
            EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.QVz);
            paramAnonymousArrayList = new BigDecimal(paramAnonymousArrayList.QVA).divide(new BigDecimal(1000000));
            EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramAnonymousArrayList.toString());
          }
        }
        for (;;)
        {
          EmojiStoreDetailUI.this.JH(1002);
          AppMethodBeat.o(176191);
          return;
          i = paramAnonymousArrayList.size();
          break;
          label175:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 10);
          EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.QVB);
        }
      }
    };
    AppMethodBeat.o(109009);
  }
  
  private void auK(String paramString)
  {
    AppMethodBeat.i(109025);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(i.h.emoji_play_failed);
    }
    com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109025);
  }
  
  private void cWc()
  {
    AppMethodBeat.i(109021);
    this.Xd.setVisibility(0);
    this.uKG.setVisibility(8);
    this.uKH.setVisibility(8);
    this.uKF.setText(i.h.emoji_no_find);
    AppMethodBeat.o(109021);
  }
  
  private void cWd()
  {
    AppMethodBeat.i(109022);
    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.uHP == null) || (this.uHP.TOG == 0))
    {
      this.Xd.setVisibility(0);
      this.uKG.setVisibility(8);
    }
    AppMethodBeat.o(109022);
  }
  
  private void cWe()
  {
    AppMethodBeat.i(109026);
    this.uKD = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFM.bxU(this.uFI);
    AppMethodBeat.o(109026);
  }
  
  private void cWf()
  {
    AppMethodBeat.i(109027);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.TOG, 64)) && (com.tencent.mm.emoji.b.o.aBQ()))
    {
      this.uKB = new com.tencent.mm.plugin.emoji.f.p(this.uFI, com.tencent.mm.plugin.emoji.f.p.uGk);
      com.tencent.mm.kernel.h.aHF().kcd.a(this.uKB, 0);
    }
    AppMethodBeat.o(109027);
  }
  
  private boolean cWg()
  {
    AppMethodBeat.i(109028);
    boolean bool = com.tencent.mm.plugin.emoji.i.a.cWg();
    this.uKE = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.uKy = i;
      AppMethodBeat.o(109028);
      return bool;
    }
  }
  
  private void cWh()
  {
    AppMethodBeat.i(109029);
    if (!Util.isNullOrNil(this.uHP.Suv))
    {
      setMMTitle(this.uHP.Suv);
      this.uFJ = this.uHP.Suv;
    }
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.uHP.VHD });
    this.uKG.setVisibility(0);
    this.Xd.setVisibility(8);
    mE(true);
    this.uKK.setText(this.uHP.Suv);
    this.uKL.setText(this.uHP.VHB);
    this.uKN.setText(this.uHP.Tev);
    if (com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.Tey, 1)) {
      this.uKJ.setVisibility(8);
    }
    for (;;)
    {
      cWl();
      cWm();
      cWn();
      cWo();
      cWp();
      this.uKK.setMaxWidth(this.uKU - this.uKV.getWidth() - com.tencent.mm.ci.a.aY(getContext(), i.c.NormalPadding) * 2 - this.uKJ.getWidth() - com.tencent.mm.ci.a.aY(getContext(), i.c.ListPadding) * 2);
      this.uKK.setVisibility(8);
      this.uKK.setVisibility(0);
      cWi();
      cWk();
      cWj();
      AppMethodBeat.o(109029);
      return;
      this.uKJ.setVisibility(0);
      this.uKJ.setText(i.h.emoji_type_gif);
    }
  }
  
  private void cWi()
  {
    AppMethodBeat.i(109031);
    if ((this.uHP.VHL != null) && (this.uHP.VHL.TdG != 0) && (this.uLi != 6))
    {
      this.uLa.setVisibility(0);
      this.uKX.setVisibility(0);
      com.tencent.mm.ay.q.bml().a(this.uHP.VHL.SuR, this.uKY, com.tencent.mm.plugin.emoji.e.e.ge(this.uFI, this.uHP.VHL.SuR));
      this.uKZ.setText(this.uHP.VHL.CMP);
      this.uKX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176185);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent();
          ((Intent)localObject).setClass(EmojiStoreDetailUI.this.getContext(), EmojiStoreV2DesignerUI.class);
          ((Intent)localObject).putExtra("uin", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).VHL.TdG);
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).VHL.CMP);
          ((Intent)localObject).putExtra("headurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).VHL.SuR);
          ((Intent)localObject).putExtra("rediret_url", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).VHJ);
          ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
          ((Intent)localObject).putExtra("extra_scence", 26);
          paramAnonymousView = EmojiStoreDetailUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176185);
        }
      });
      AppMethodBeat.o(109031);
      return;
    }
    this.uLa.setVisibility(8);
    this.uKX.setVisibility(8);
    AppMethodBeat.o(109031);
  }
  
  private void cWk()
  {
    AppMethodBeat.i(109033);
    if ((this.uHP.TOG & 0x20) == 32)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)this.uKS.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.uKR.getLayoutParams();
      this.uKS.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.ci.a.aY(getContext(), i.c.NormalPadding);
      this.uKS.setLayoutParams(localLayoutParams1);
      this.uKS.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.ci.a.aY(getContext(), i.c.NormalPadding);
      this.uKR.setLayoutParams(localLayoutParams2);
      this.uKR.setGravity(5);
      AppMethodBeat.o(109033);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.uKR.getLayoutParams();
    localLayoutParams1.gravity = 17;
    this.uKR.setLayoutParams(localLayoutParams1);
    this.uKR.setGravity(17);
    this.uKS.setVisibility(8);
    AppMethodBeat.o(109033);
  }
  
  private void cWl()
  {
    AppMethodBeat.i(109034);
    if (com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.Tey, 8))
    {
      this.uLh = 0;
      Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.uHP.TOG) });
      if ((!com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.TOG, 8)) || (!com.tencent.mm.plugin.emoji.a.a.e.JB(this.uHP.Tey))) {
        break label164;
      }
      this.uKy = 8;
    }
    for (;;)
    {
      if (this.uKE) {
        this.uKy = 7;
      }
      AppMethodBeat.o(109034);
      return;
      if (com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.Tey, 4))
      {
        this.uLh = 0;
        break;
      }
      if ((!this.uLk) && (TextUtils.isEmpty(this.uHP.Tex)))
      {
        this.uLh = 0;
        break;
      }
      this.uLh = 1;
      break;
      label164:
      if ((com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.TOG, 1)) || (com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.Tey, 8))) {
        this.uKy = 3;
      } else if (com.tencent.mm.plugin.emoji.a.a.e.JB(this.uHP.Tey)) {
        this.uKy = 0;
      } else if ((!this.uLk) && ((TextUtils.isEmpty(this.uHP.VHC)) || (this.uHP.VHC.equals("0")))) {
        this.uKy = 0;
      } else if (this.uLk)
      {
        if (TextUtils.isEmpty(this.uLn)) {
          this.uKy = this.uLl;
        } else {
          this.uKy = 4;
        }
      }
      else {
        this.uKy = 4;
      }
    }
  }
  
  private void cWm()
  {
    AppMethodBeat.i(109035);
    if (com.tencent.mm.plugin.emoji.i.a.ava(this.uFI)) {
      cWg();
    }
    switch (this.uKy)
    {
    case 1: 
    case 2: 
    case 9: 
    default: 
      Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.uKy) });
    }
    for (;;)
    {
      cWn();
      AppMethodBeat.o(109035);
      return;
      this.uKW.setVisibility(8);
      this.uKM.setTextColor(getResources().getColorStateList(i.b.emoji_download_finish_color));
      this.uKM.setBackgroundResource(i.d.btn_solid_white);
      this.uKM.setText(i.h.emoji_store_expire);
      this.uKM.setEnabled(false);
      continue;
      this.uKW.setVisibility(8);
      this.uKM.setTextColor(getResources().getColorStateList(i.b.white_text_color_selector));
      this.uKM.setBackgroundResource(i.d.btn_solid_green);
      this.uKM.setText(i.h.emoji_store_download);
      this.uKM.setEnabled(true);
      continue;
      this.uKW.setVisibility(8);
      this.uKM.setTextColor(getResources().getColorStateList(i.b.white_text_color_selector));
      this.uKM.setBackgroundResource(i.d.btn_solid_green);
      this.uKM.setEnabled(true);
      if (this.uLk)
      {
        if (Util.isNullOrNil(this.uLn)) {
          this.uKM.setText("");
        } else {
          this.uKM.setText(this.uLn);
        }
      }
      else
      {
        this.uKM.setText(this.uHP.Tex);
        this.uKy = 4;
        continue;
        this.uKW.setVisibility(8);
        this.uKM.setTextColor(getResources().getColorStateList(i.b.white_text_color_selector));
        this.uKM.setBackgroundResource(i.d.btn_solid_green);
        this.uKM.setText(i.h.emoji_store_download);
        this.uKM.setEnabled(true);
        continue;
        this.uKW.setVisibility(8);
        this.uKM.setEnabled(false);
        this.uKQ.setVisibility(0);
        this.uKP.setVisibility(0);
        this.uKM.setVisibility(4);
        if (this.uKu != 3)
        {
          continue;
          this.uKW.setVisibility(8);
          this.uKM.setVisibility(0);
          this.uKM.setEnabled(true);
          if (this.uLx)
          {
            this.uKM.setText(i.h.emoji_remove);
            this.uKM.setTextColor(getResources().getColorStateList(i.b.green_text_color_selector));
            this.uKM.setBackgroundResource(i.d.btn_solid_grey);
          }
          for (;;)
          {
            this.uKQ.setVisibility(8);
            this.uzL.setProgress(0);
            this.uKP.setVisibility(4);
            if (this.uKu == 3) {
              break;
            }
            break;
            this.uKM.setTextColor(getResources().getColorStateList(i.b.white_text_color_selector));
            this.uKM.setText(i.h.emoji_store_used_now);
            this.uKM.setBackgroundResource(i.d.btn_solid_green);
          }
          this.uKW.setVisibility(8);
          this.uKM.setBackgroundResource(i.d.btn_solid_green);
          this.uKM.setText(i.h.emoji_store_download);
          this.uKM.setEnabled(true);
          this.uKW.setVisibility(0);
          this.uKM.setVisibility(0);
          this.uKM.setBackgroundResource(i.d.white_bigbtn_tips_normal);
          this.uKM.setText("");
          this.uKM.setEnabled(false);
          this.uKQ.setVisibility(8);
          this.uzL.setProgress(0);
          this.uKP.setVisibility(4);
          continue;
          this.uKW.setVisibility(8);
          this.uKM.setVisibility(0);
          this.uKM.setBackgroundResource(i.d.btn_solid_green);
          this.uKM.setText(i.h.emoji_store_play);
          this.uKM.setEnabled(true);
          this.uKQ.setVisibility(8);
          this.uzL.setProgress(0);
          this.uKP.setVisibility(4);
          continue;
          cWl();
          cWm();
        }
      }
    }
  }
  
  private void cWn()
  {
    AppMethodBeat.i(109036);
    if ((this.uLv) && ((this.uLu == null) || ((this.uLu.Tee & 0x1) != 1)) && ((this.uHP == null) || (!com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.TOG, 1))) && (this.uLu != null) && (!TextUtils.isEmpty(this.uLu.Ted)))
    {
      this.uKM.setText(this.uLu.Ted);
      this.uKM.setTextColor(getContext().getResources().getColor(i.b.half_alpha_black));
      this.uKM.setBackgroundDrawable(null);
      this.uKM.setEnabled(false);
    }
    AppMethodBeat.o(109036);
  }
  
  private void cWo()
  {
    AppMethodBeat.i(109037);
    if ((!com.tencent.mm.plugin.emoji.i.a.ava(this.uFI)) && ((this.uHP.VHG == null) || (this.uHP.VHG.size() <= 0) || (((dhm)this.uHP.VHG.get(0)).WxE == null))) {
      this.uLs.setVisibility(8);
    }
    for (;;)
    {
      this.uKO.setProductId(this.uFI);
      if (this.uKC != null) {
        this.uKC.notifyDataSetInvalidated();
      }
      AppMethodBeat.o(109037);
      return;
      this.uLs.setVisibility(0);
    }
  }
  
  private void cWp()
  {
    AppMethodBeat.i(109038);
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.uHP.TOG });
    if ((this.uHP.TOG & 0x10) == 16) {
      addIconOptionMenu(0, i.g.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(176186);
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
          EmojiStoreDetailUI.r(EmojiStoreDetailUI.this);
          AppMethodBeat.o(176186);
          return true;
        }
      });
    }
    AppMethodBeat.o(109038);
  }
  
  private void cWq()
  {
    AppMethodBeat.i(109039);
    com.tencent.mm.ui.base.h.a(this, i.h.emoji_store_cancle_download_msg, 0, i.h.emoji_store_stop_download, i.h.emoji_store_continue_download, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176187);
        if (com.tencent.mm.plugin.emoji.i.a.ava(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this)))
        {
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
          com.tencent.mm.plugin.emoji.f.a.cUV().cUX();
          if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this)))
          {
            com.tencent.mm.aq.f.bkg().Vz(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(EmojiStoreDetailUI.this) });
          }
          if ((!com.tencent.mm.plugin.emoji.a.a.e.fX(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).TOG, 1)) && (!com.tencent.mm.plugin.emoji.a.a.e.JB(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).Tey))) {
            break label262;
          }
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 3);
        }
        for (;;)
        {
          com.tencent.mm.plugin.emoji.model.p.cUT().i(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.u(EmojiStoreDetailUI.this), 0, EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
          EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(8);
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(0);
          EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(4);
          EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(0);
          EmojiStoreDetailUI.v(EmojiStoreDetailUI.this);
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          paramAnonymousDialogInterface = new r(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), 2);
          com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(176187);
          return;
          com.tencent.mm.kernel.h.aHF().kcd.a(EmojiStoreDetailUI.s(EmojiStoreDetailUI.this));
          break;
          label262:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, -1);
        }
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(108987);
        AppMethodBeat.o(108987);
      }
    });
    AppMethodBeat.o(109039);
  }
  
  private void cWr()
  {
    AppMethodBeat.i(109041);
    if (com.tencent.mm.plugin.emoji.i.a.ava(this.uFI))
    {
      com.tencent.mm.plugin.emoji.f.a.cUV();
      com.tencent.mm.plugin.emoji.f.a.cUW();
      AppMethodBeat.o(109041);
      return;
    }
    this.uKA = new com.tencent.mm.plugin.emoji.f.h(this.uFI, this.uFK, this.uFJ);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uKA, 0);
    switch (this.uHw)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(11598, new Object[] { Integer.valueOf(1), this.uFI });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(11598, new Object[] { Integer.valueOf(3), this.uFI });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(11598, new Object[] { Integer.valueOf(2), this.uFI });
    }
  }
  
  private void mE(boolean paramBoolean)
  {
    AppMethodBeat.i(109030);
    Object localObject = null;
    String str;
    if (!Util.isNullOrNil(this.uHP.Ufx))
    {
      if (!paramBoolean) {
        break label104;
      }
      localObject = this.uFI;
      str = this.uHP.Ufx;
      com.tencent.mm.ci.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, uLD);; localObject = EmojiLogic.I((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.uKI != null)) {
        this.uKI.setImageFilePath(((EmojiInfo)localObject).ifh());
      }
      if (com.tencent.mm.plugin.emoji.i.a.ava(this.uFI)) {
        this.uKI.setImageResource(i.d.tuzi_banner);
      }
      AppMethodBeat.o(109030);
      return;
      label104:
      localObject = this.uFI;
      str = this.uHP.Ufx;
      com.tencent.mm.ci.a.getDensity(this.mContext);
    }
  }
  
  public final void JH(int paramInt)
  {
    AppMethodBeat.i(109042);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
    AppMethodBeat.o(109042);
  }
  
  public final void cWj()
  {
    AppMethodBeat.i(109032);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fX(this.uHP.TOG, 64)) && (com.tencent.mm.emoji.b.o.aBQ()))
    {
      if (this.uKD != null)
      {
        this.uLb.setVisibility(0);
        this.uLd.setText(i.h.emoji_store_reward);
        this.uLc.setText(this.uKD.VIh.Sva);
        this.uLc.setLongClickable(false);
        if (this.uKD.Teg > 0)
        {
          this.uLf.setVisibility(0);
          String str1 = String.valueOf(this.uKD.Teg);
          String str2 = String.format(getString(i.h.emoji_store_reward_info), new Object[] { Integer.valueOf(this.uKD.Teg) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(i.b.emotion_reward_link_color)), i, str1.length() + i, 33);
          }
          this.uLf.setText(localSpannableString);
        }
        while ((this.uKD.Teh != null) && (this.uKD.Teh.size() > 0))
        {
          this.uLe.setVisibility(0);
          this.uLe.d(this.uFI, this.uKD.Teh);
          AppMethodBeat.o(109032);
          return;
          this.uLf.setVisibility(8);
        }
        this.uLe.setVisibility(8);
        AppMethodBeat.o(109032);
        return;
      }
      this.uLb.setVisibility(8);
      cWf();
      AppMethodBeat.o(109032);
      return;
    }
    this.uLb.setVisibility(8);
    AppMethodBeat.o(109032);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return i.f.emoji_store_detail;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109011);
    if (!Util.isNullOrNil(this.uFJ)) {
      setMMTitle(this.uFJ);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(176194);
        EmojiStoreDetailUI.this.finish();
        AppMethodBeat.o(176194);
        return true;
      }
    });
    this.clC = com.tencent.mm.ci.a.aY(this.mContext, i.c.emoji_detail_item_margin);
    this.uLg = getResources().getDimensionPixelSize(i.c.emoji_detail_item_image_size);
    this.uLg = com.tencent.mm.ci.a.aY(this.mContext, i.c.emoji_detail_item_image_size);
    this.mNumColumns = 4;
    this.uKH = ((EmojiDetailScrollView)findViewById(i.e.scrollview));
    this.Xd = findViewById(i.e.empty);
    this.uKF = ((TextView)this.Xd.findViewById(i.e.empty_content));
    this.uKG = findViewById(i.e.emoji_store_detail);
    this.uKI = ((BannerEmojiView)findViewById(i.e.emoji_image));
    int i = this.uKI.getRight();
    int j = this.uKI.getLeft();
    int k = this.uKI.getPaddingRight();
    int m = this.uKI.getPaddingLeft();
    this.uKI.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.uKJ = ((TextView)findViewById(i.e.emoji_tip));
    this.uKK = ((MMAutoSizeTextView)findViewById(i.e.emoji_title));
    this.uKL = ((TextView)findViewById(i.e.emoji_copyright));
    this.uKM = ((TextView)findViewById(i.e.emoji_type));
    this.uKN = ((TextView)findViewById(i.e.emoji_destrition));
    this.uKU = com.tencent.mm.ci.a.kr(getContext());
    this.uKV = findViewById(i.e.emoji_action);
    this.uKO = ((EmojiDetailGridView)findViewById(i.e.emoji_gridview));
    this.uKC = new a();
    if (com.tencent.mm.plugin.emoji.i.a.ava(this.uFI))
    {
      localObject = this.uKC;
      List localList = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.aug(com.tencent.mm.plugin.emoji.i.a.cWZ());
      ((a)localObject).jIX.clear();
      ((a)localObject).jIX.addAll(localList);
      ((a)localObject).notifyDataSetChanged();
    }
    this.uKQ = findViewById(i.e.emoji_progress);
    this.uzL = ((ProgressBar)findViewById(i.e.emoji_download_progress));
    this.uKP = ((ImageView)findViewById(i.e.emoji_close));
    this.uKP.setOnClickListener(this);
    this.uKQ.setVisibility(8);
    this.uKP.setVisibility(8);
    this.uzL.setProgress(0);
    this.uKO.setAdapter(this.uKC);
    this.uKO.setColumnWidth(this.uLg);
    this.uKO.setNumColumns(this.mNumColumns);
    this.uKO.setHorizontalSpacing(this.clC);
    this.uKO.setVerticalSpacing(this.clC);
    this.uKO.setEmojiDetailScrollView(this.uKH);
    this.uKO.setFromDetail(true);
    this.uKO.setIsShowPopWin(true);
    this.uKO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(176183);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView instanceof EmojiInfo))
        {
          paramAnonymousAdapterView = (EmojiInfo)paramAnonymousAdapterView;
          paramAnonymousView = new aji();
          com.tencent.mm.plugin.emoji.i.b.a(paramAnonymousAdapterView, paramAnonymousView);
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.IzE.a(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAnonymousAdapterView.field_md5, Long.valueOf(EmojiStoreDetailUI.d(EmojiStoreDetailUI.this)), paramAnonymousAdapterView.field_designerID, paramAnonymousAdapterView.field_groupId, Integer.valueOf(26) });
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(176183);
      }
    });
    this.uKM.setOnClickListener(this);
    this.uKT = findViewById(i.e.sticker_declare_area);
    this.uKR = ((TextView)findViewById(i.e.emoji_service));
    this.uKS = ((TextView)findViewById(i.e.emoji_complaints));
    this.uKR.setOnClickListener(this.uLz);
    this.uKS.setOnClickListener(this.uLA);
    this.uKW = ((ProgressBar)findViewById(i.e.emoji_google_price_loading));
    Object localObject = this.uKW;
    if (this.uLk) {}
    for (i = 0;; i = 8)
    {
      ((ProgressBar)localObject).setVisibility(i);
      this.uLs = findViewById(i.e.emoji_long_touch_pre_tips);
      if (WeChatBrands.Business.Entries.MeStickerDeclare.banned()) {
        this.uKT.setVisibility(8);
      }
      this.uLa = findViewById(i.e.emoji_designer_line_2);
      this.uKX = findViewById(i.e.designer_bar_container);
      this.uKY = ((ImageView)findViewById(i.e.designer_icon));
      this.uKZ = ((TextView)findViewById(i.e.designer_title));
      this.uLb = findViewById(i.e.emoji_reward);
      this.uLc = ((TextView)findViewById(i.e.reward_begword));
      this.uLd = ((Button)findViewById(i.e.reward_btn));
      this.uLf = ((TextView)findViewById(i.e.reward_info));
      this.uLe = ((DonorsAvatarView)findViewById(i.e.reward_avatar));
      this.uLd.setOnClickListener(this.uLB);
      this.uLf.setOnClickListener(this.uLC);
      AppMethodBeat.o(109011);
      return;
    }
  }
  
  public final void k(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(109040);
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (!paramString1.equals(this.uFI)))
    {
      AppMethodBeat.o(109040);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.uLj = paramString2;
    }
    if (paramInt1 == -1)
    {
      if (this.uKy != -1)
      {
        this.uKy = -1;
        JH(1003);
        AppMethodBeat.o(109040);
      }
    }
    else
    {
      if (paramInt1 == 7)
      {
        this.uKy = 7;
        JH(1003);
        AppMethodBeat.o(109040);
        return;
      }
      if (paramInt1 == 6)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.uFI)))
        {
          this.uKy = 6;
          this.IB = paramInt2;
          JH(1004);
          AppMethodBeat.o(109040);
        }
      }
      else {
        Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
      }
    }
    AppMethodBeat.o(109040);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109023);
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1;
    Object localObject;
    if (paramInt1 == 2001)
    {
      str1 = "";
      paramInt1 = 0;
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
        Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(paramInt1)));
        str1 = paramIntent.getStringExtra("key_err_msg");
        Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str1)));
      }
      this.uLr = false;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          localObject = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localObject != null) && (((ArrayList)localObject).contains(this.uFI)))
          {
            paramInt1 = 0;
            while (paramInt1 < ((ArrayList)localObject).size())
            {
              if (this.uFI.equals(((ArrayList)localObject).get(paramInt1))) {
                this.uFK = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.uHP.TOG = 1;
            cWr();
            this.uKy = 6;
            com.tencent.mm.ui.base.h.cO(this, str1);
            if (z.bdp())
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 4L, 1L, false);
              AppMethodBeat.o(109023);
              return;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 0L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          this.uKy = -1;
          cWm();
          auK(str1);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 100000002))
        {
          cWr();
          this.uKy = 6;
          this.uKC.notifyDataSetChanged();
          if (z.bdp())
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 7L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 3L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 1))
        {
          this.uKy = -1;
          cWm();
          if (z.bdp())
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 6L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 2L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        this.uKy = -1;
        cWm();
        auK(str1);
        if (z.bdp())
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 5L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 1L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      this.uKy = -1;
      cWm();
      if (z.bdp())
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 6L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 2L, 1L, false);
      AppMethodBeat.o(109023);
      return;
    }
    if (paramInt1 == 2002)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (!Util.isNullOrNil(paramIntent))
        {
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(paramIntent)));
          str1 = this.uFI;
          localObject = this.uHP.Suv;
          String str2 = this.uHP.Tev;
          String str3 = this.uHP.CNj;
          String str4 = this.uHP.VHJ;
          paramInt1 = this.uHP.TOG;
          String str5 = getResources().getString(i.h.app_emoji_share);
          str5 = str5 + (String)localObject;
          String str6 = getString(i.h.app_send);
          String str7 = getString(i.h.confirm_dialog_edittext_hint);
          ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.j.class)).a(this, paramIntent, str5, str6, str7, str3, new j.1(paramIntent, str1, (String)localObject, str2, str3, str4, paramInt1, this));
        }
        AppMethodBeat.o(109023);
      }
    }
    else if (paramInt1 == this.uEQ.qVk)
    {
      if (paramInt2 == -1)
      {
        Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
        if (IntentUtil.getBooleanExtra(getIntent(), "from_appbrand_ui", false)) {
          this.uEQ.uQZ = true;
        }
        this.uEQ.a(paramIntent, this.uFI, this);
        com.tencent.mm.plugin.report.service.h.IzE.a(12069, new Object[] { Integer.valueOf(3), this.uFI });
        AppMethodBeat.o(109023);
      }
    }
    else if ((paramInt1 == 2004) && (paramInt2 == -1)) {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getContext().getString(i.h.app_sent));
    }
    AppMethodBeat.o(109023);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109019);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i = paramView.getId();
    if (i == i.e.emoji_type)
    {
      if (this.uKy == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if (this.uLx)
        {
          paramView = new r(this.uFI, 2);
          com.tencent.mm.kernel.h.aHF().kcd.a(paramView, 0);
          this.uLy = s.a(this, getString(i.h.loading), true, 0, null);
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(11076, "0, ");
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109019);
        return;
        if ((!Util.isNullOrNil(paramView)) && (this.uKx))
        {
          this.uEQ.a(paramView, this.uFI, this);
          break;
        }
        this.uEQ.O(this);
        com.tencent.mm.plugin.report.service.h.IzE.a(12069, new Object[] { Integer.valueOf(2), this.uFI });
        break;
        switch (this.uKy)
        {
        case 1: 
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          Log.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.uKy) });
          break;
        case 4: 
          if (!this.uLr)
          {
            if (this.uLx)
            {
              paramView = com.tencent.mm.emoji.c.e.jNv;
              com.tencent.mm.emoji.c.e.rE(6);
            }
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.uFI, this.uHP.Tex, this.uHP.SuH });
            paramView = new Intent();
            paramView.putExtra("key_product_id", this.uFI);
            if (this.uLk)
            {
              paramView.putExtra("key_currency_type", this.uLo);
              paramView.putExtra("key_price", this.uLo + this.uLp);
            }
            for (;;)
            {
              com.tencent.mm.by.c.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
              com.tencent.mm.plugin.report.service.h.IzE.a(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.uLi), "", this.uFI, Long.valueOf(this.uEM), this.uEN });
              this.uLr = true;
              break;
              paramView.putExtra("key_currency_type", this.uHP.SuH);
              paramView.putExtra("key_price", this.uHP.VHC);
            }
          }
          break;
        case 0: 
        case 3: 
          if (this.uLx)
          {
            paramView = com.tencent.mm.emoji.c.e.jNv;
            com.tencent.mm.emoji.c.e.rE(6);
          }
          cWr();
          this.uKy = 6;
          cWm();
          com.tencent.mm.plugin.report.service.h.IzE.a(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.uLi), "", this.uFI, Long.valueOf(this.uEM), this.uEN });
          if (this.uES != null)
          {
            this.uES.gly = 4;
            this.uES.bpa();
          }
          break;
        case 5: 
          this.uKy = 3;
          cWm();
          break;
        case 10: 
        case 12: 
          switch (this.uLm)
          {
          default: 
            paramView = getString(i.h.emoji_unknow);
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.c(this, paramView, null, true);
            break;
            paramView = getString(i.h.emoji_google_no_install);
            continue;
            paramView = getString(i.h.emoji_no_on_sale);
            continue;
            paramView = getString(i.h.emoji_timeout);
          }
        case 11: 
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
          break;
        case -1: 
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
        }
      }
    }
    if (i == i.e.emoji_download_progress)
    {
      cWq();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    if (i == i.e.emoji_close)
    {
      cWq();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109019);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109010);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      finish();
      AppMethodBeat.o(109010);
      return;
    }
    this.uLk = z.bdp();
    this.uEQ = new com.tencent.mm.plugin.emoji.i.c(2003);
    paramBundle = getIntent();
    this.uFI = getIntent().getStringExtra("extra_id");
    this.uHw = getIntent().getIntExtra("preceding_scence", -1);
    this.uFJ = getIntent().getStringExtra("extra_name");
    this.uKu = getIntent().getIntExtra("call_by", -1);
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.uFI = EmojiLogic.aul((String)localObject);
      this.uHw = 0;
      this.uHw = 10;
      com.tencent.mm.plugin.report.service.h.IzE.a(10993, new Object[] { Integer.valueOf(3), this.uFI });
    }
    if (TextUtils.isEmpty(this.uFI))
    {
      Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.uHw == -1)
    {
      Log.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.uLt = paramBundle.getBooleanExtra("check_clickflag", true);
    this.uLj = paramBundle.getStringExtra("cdn_client_id");
    this.uLi = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.uLx = paramBundle.getBooleanExtra("from_popup", false);
    this.uEM = paramBundle.getLongExtra("searchID", 0L);
    this.uEN = Util.nullAs(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.uHP.VHB = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.uHP.Ufx = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.uHP.Tev = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.uHP.Tex = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.uHP.Tey = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.uHP.TOG = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.uHP.SuH = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.uHP.VHC = ((String)localObject);
    }
    if (this.uLk)
    {
      this.uLl = 11;
      com.tencent.mm.pluginsdk.model.m.a(this, this.uLq, this.uLF);
    }
    this.uKw = paramBundle.getBooleanExtra("reward_tip", false);
    paramBundle = paramBundle.getStringExtra("action_report");
    if (!Util.isNullOrNil(paramBundle)) {
      this.uES = new ba(paramBundle);
    }
    this.uLq[0] = this.uFI;
    this.uHP.ProductID = this.uFI;
    this.uHP.Suv = this.uFJ;
    this.uHP.VHI = this.uKv;
    this.uHP.VHC = "-1";
    this.uHP.rWt = -1;
    this.mContext = this;
    uLD.cNB = new WeakReference(this);
    initView();
    if (!com.tencent.mm.plugin.emoji.i.a.ava(this.uFI)) {
      if (this.uHP == null)
      {
        this.uKz = new com.tencent.mm.plugin.emoji.f.m(this.uFI, this.uHw);
        com.tencent.mm.kernel.h.aHF().kcd.a(this.uKz, 0);
        if ((this.uKu == -1) || (this.uKu == 3))
        {
          this.uKG.setVisibility(8);
          this.Xd.setVisibility(8);
          getString(i.h.app_tip);
          this.mRa = com.tencent.mm.ui.base.h.a(this, getString(i.h.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(176184);
              com.tencent.mm.kernel.h.aHF().kcd.a(EmojiStoreDetailUI.o(EmojiStoreDetailUI.this));
              EmojiStoreDetailUI.p(EmojiStoreDetailUI.this).setText(i.h.emoji_store_load_failed_network);
              EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
              AppMethodBeat.o(176184);
            }
          });
        }
        cWe();
        if (!this.uLt) {
          break label1051;
        }
        paramBundle = new com.tencent.mm.plugin.emoji.f.l(this.uFI);
        com.tencent.mm.kernel.h.aHF().kcd.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      cWh();
      com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFI.add(this);
      EventCenter.instance.addListener(this.uHA);
      com.tencent.mm.kernel.h.aHF().kcd.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      k(this.uFI, i, j, this.uLj);
      this.uLw = true;
      com.tencent.mm.plugin.report.service.h.IzE.a(12740, new Object[] { Integer.valueOf(1), "", this.uFI, "", Integer.valueOf(this.uLi), Integer.valueOf(26) });
      if ((this.uKw) && (this.uKH != null)) {
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176193);
            EmojiStoreDetailUI.m(EmojiStoreDetailUI.this).fullScroll(130);
            AppMethodBeat.o(176193);
          }
        }, 0L);
      }
      AppMethodBeat.o(109010);
      return;
      if ((!Util.isNullOrNil(this.uHQ)) && (this.uHQ.equalsIgnoreCase(LocaleUtil.getCurrentLanguage(this.mContext))))
      {
        this.uKz = new com.tencent.mm.plugin.emoji.f.m(this.uFI, this.uHw, this.uHP.rWt);
        break;
      }
      this.uKz = new com.tencent.mm.plugin.emoji.f.m(this.uFI, this.uHw);
      break;
      label1051:
      this.uLv = true;
      this.uLu = EmojiLogic.cUF();
      continue;
      paramBundle = getContext();
      localObject = new akb();
      ((akb)localObject).ProductID = EmojiGroupInfo.YCu;
      ((akb)localObject).Suv = paramBundle.getString(i.h.emoji_store_tuzi_title);
      ((akb)localObject).Tev = paramBundle.getString(i.h.emoji_store_tuzi_desc);
      ((akb)localObject).Tew = paramBundle.getString(i.h.emoji_store_tuzi_auth);
      ((akb)localObject).Tex = "";
      ((akb)localObject).Tey = 0;
      ((akb)localObject).TOG = 1;
      ((akb)localObject).Ufx = "";
      ((akb)localObject).Vdr = 0;
      ((akb)localObject).VHB = paramBundle.getString(i.h.emoji_store_tuzi_copyright);
      ((akb)localObject).VHD = "";
      ((akb)localObject).VHC = "";
      ((akb)localObject).SuH = "";
      ((akb)localObject).VHH = paramBundle.getString(i.h.emoji_store_tuzi_timelimitStr);
      this.uHP = ((akb)localObject);
      this.uLv = true;
      this.uLu = EmojiLogic.cUF();
      cWg();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109016);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFI.remove(this);
    EventCenter.instance.removeListener(this.uHA);
    com.tencent.mm.kernel.h.aHF().kcd.b(822, this);
    if (this.uKO != null) {
      this.uKO.ihz();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(109016);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(109024);
    JH(1001);
    AppMethodBeat.o(109024);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109014);
    super.onPause();
    com.tencent.mm.kernel.h.aHF().kcd.b(412, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(521, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(423, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(413, this);
    AppMethodBeat.o(109014);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109018);
    this.uKy = paramBundle.getInt("status");
    this.IB = paramBundle.getInt("progress");
    AppMethodBeat.o(109018);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109013);
    super.onResume();
    com.tencent.mm.kernel.h.aHF().kcd.a(412, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(521, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(423, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(413, this);
    this.uLr = false;
    if (!this.uLw)
    {
      cWe();
      JH(1007);
    }
    cWf();
    this.uLw = false;
    JH(1001);
    AppMethodBeat.o(109013);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109017);
    paramBundle.putInt("status", this.uKy);
    paramBundle.putInt("progress", this.IB);
    AppMethodBeat.o(109017);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(109020);
    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109020);
      return;
      if ((paramq instanceof com.tencent.mm.plugin.emoji.f.m))
      {
        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
        paramString = (com.tencent.mm.plugin.emoji.f.m)paramq;
        if ((paramString != null) && (!Util.isNullOrNil(paramString.uFI)) && (paramString.uFI.equalsIgnoreCase(this.uFI)))
        {
          if (paramInt1 == 0)
          {
            if (paramInt2 == 0)
            {
              this.uHP = paramString.cVe();
              paramString = this.uKC;
              if ((this.uHP == null) || (paramString.uLG.uHP.VHG == null)) {}
              for (;;)
              {
                JH(1002);
                AppMethodBeat.o(109020);
                return;
                paramString.jIX.clear();
                paramq = paramString.uLG.uHP.VHG.iterator();
                while (paramq.hasNext())
                {
                  dhm localdhm = (dhm)paramq.next();
                  EmojiInfo localEmojiInfo = new EmojiInfo();
                  localEmojiInfo.field_md5 = localdhm.Md5;
                  localEmojiInfo.field_thumbUrl = localdhm.ThumbUrl;
                  localEmojiInfo.field_cdnUrl = localdhm.Xsf;
                  localEmojiInfo.field_aeskey = localdhm.AesKey;
                  localEmojiInfo.field_encrypturl = localdhm.EncryptUrl;
                  localEmojiInfo.field_externUrl = localdhm.ExternUrl;
                  localEmojiInfo.field_externMd5 = localdhm.ExternMd5;
                  localEmojiInfo.field_activityid = localdhm.ActivityID;
                  localEmojiInfo.field_groupId = paramString.uLG.uFI;
                  localEmojiInfo.field_catalog = 84;
                  localEmojiInfo.field_reserved4 |= EmojiInfo.ZuM;
                  paramString.jIX.add(localEmojiInfo);
                }
                paramString.notifyDataSetChanged();
              }
            }
            if (paramInt2 == 1)
            {
              cWc();
              AppMethodBeat.o(109020);
              return;
            }
            this.uKF.setText(i.h.emoji_store_load_failed);
            cWd();
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 5)
          {
            if ((paramString != null) && (paramString.cVe() != null)) {
              this.uHP.TOG = paramString.cVe().TOG;
            }
            JH(1002);
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 1)
          {
            cWc();
            AppMethodBeat.o(109020);
            return;
          }
          this.uKH.setVisibility(8);
          this.Xd.setVisibility(0);
          this.uKF.setText(i.h.emoji_store_load_failed_network);
          cWd();
          AppMethodBeat.o(109020);
          return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
        AppMethodBeat.o(109020);
        return;
        if ((paramq instanceof com.tencent.mm.plugin.emoji.f.h))
        {
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
          paramString = (com.tencent.mm.plugin.emoji.f.h)paramq;
          if ((paramString == this.uKA) && (!Util.isNullOrNil(paramString.uFI)) && (paramString.uFI.equalsIgnoreCase(this.uFI)))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.uLj = paramString.lPn;
              this.uKy = 6;
              cWm();
              AppMethodBeat.o(109020);
              return;
            }
            this.uKy = -1;
            cWm();
            paramString = this.uFJ;
            com.tencent.mm.ui.base.h.a(this, String.format(getString(i.h.emoji_store_download_failed_msg), new Object[] { paramString }), "", new DialogInterface.OnClickListener()new EmojiStoreDetailUI.10
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(176188);
                EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, new com.tencent.mm.plugin.emoji.f.h(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.y(EmojiStoreDetailUI.this), EmojiStoreDetailUI.z(EmojiStoreDetailUI.this)));
                EmojiStoreDetailUI.A(EmojiStoreDetailUI.this);
                EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 6);
                EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                AppMethodBeat.o(176188);
              }
            }, new EmojiStoreDetailUI.10(this));
            AppMethodBeat.o(109020);
            return;
          }
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          AppMethodBeat.o(109020);
          return;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
          paramString = (com.tencent.mm.plugin.emoji.f.l)paramq;
          if ((paramString != null) && (!Util.isNullOrNil(paramString.uFv)) && (paramString.uFv.equalsIgnoreCase(this.uFI))) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.uLu = ((bub)d.c.b(paramString.rr.lBS));
              this.uLv = true;
              cWn();
            }
          }
          for (;;)
          {
            this.uLv = true;
            cWn();
            AppMethodBeat.o(109020);
            return;
            this.uLu = null;
            break;
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          }
          if ((paramq instanceof com.tencent.mm.plugin.emoji.f.p))
          {
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.uKD = ((com.tencent.mm.plugin.emoji.f.p)paramq).cVi();
              JH(1007);
              AppMethodBeat.o(109020);
              return;
              if (this.uLy != null)
              {
                this.uLy.dismiss();
                this.uLy = null;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFI.bxC(((r)paramq).uFI);
                this.uKy = 3;
                cWm();
                AppMethodBeat.o(109020);
                return;
              }
              com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(a.j.emoji_top_failed), "", "", getContext().getString(a.j.app_i_known), null, null);
            }
          }
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(109012);
    super.onStart();
    AppMethodBeat.o(109012);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109015);
    super.onStop();
    AppMethodBeat.o(109015);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
    implements com.tencent.mm.view.a.a
  {
    final List<EmojiInfo> jIX;
    
    public a()
    {
      AppMethodBeat.i(257863);
      this.jIX = new ArrayList();
      AppMethodBeat.o(257863);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109000);
      int i = this.jIX.size();
      AppMethodBeat.o(109000);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(109001);
      Object localObject = this.jIX.get(paramInt);
      AppMethodBeat.o(109001);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(109002);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(EmojiStoreDetailUI.w(EmojiStoreDetailUI.this)).inflate(i.f.emoji_store_detail_grid_item, null);
        paramViewGroup = new EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramView);
        paramView.setTag(paramViewGroup);
        if (!EmojiStoreDetailUI.x(EmojiStoreDetailUI.this).YOA) {
          break label126;
        }
        paramViewGroup.uLH.setBackgroundResource(i.d.smiley_item_bg2);
      }
      for (;;)
      {
        Object localObject = getItem(paramInt);
        if ((localObject instanceof EmojiInfo))
        {
          com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.jGI;
          com.tencent.mm.emoji.loader.e.a((EmojiInfo)localObject, paramViewGroup.uLH);
        }
        AppMethodBeat.o(109002);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.b)paramView.getTag();
        break;
        label126:
        paramViewGroup.uLH.setBackgroundDrawable(null);
      }
    }
  }
  
  final class b
  {
    SquareImageView uLH;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109008);
      this.uLH = ((SquareImageView)paramView.findViewById(i.e.detail_image));
      this.uLH.setScaleType(ImageView.ScaleType.FIT_CENTER);
      AppMethodBeat.o(109008);
    }
  }
  
  static final class c
    implements com.tencent.mm.ay.a.c.k
  {
    WeakReference<EmojiStoreDetailUI> cNB;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(176195);
      Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[] { paramString });
      if (this.cNB == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      paramString = (EmojiStoreDetailUI)this.cNB.get();
      if (paramString == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      if (paramBitmap != null) {
        paramString.JH(1006);
      }
      AppMethodBeat.o(176195);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */