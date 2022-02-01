package com.tencent.mm.plugin.emoji.ui;

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
import android.widget.TextView.BufferType;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.autogen.mmdata.rpt.bu;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.j.1;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pluginsdk.model.o.a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.protocal.protobuf.goi;
import com.tencent.mm.protocal.protobuf.goj;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.SmileySubGrid;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.am.h, MStorage.IOnStorageChange
{
  private static c xUe;
  private View bEx;
  private int boE;
  private int ebX;
  private Context mContext;
  private MMHandler mHandler;
  private int mNumColumns;
  private ProgressDialog pNH;
  private ProgressBar xGo;
  private String xNp;
  private com.tencent.mm.plugin.emoji.g.e xNs;
  private bw xNu;
  private String xOk;
  private String xOl;
  private String xOm;
  private aoi xQC;
  private String xQD;
  private int xQc;
  private IListener xQg;
  private String xSP;
  private int xSQ;
  private String xSR;
  private boolean xSS;
  private boolean xST;
  private int xSU;
  private m xSV;
  private com.tencent.mm.plugin.emoji.e.h xSW;
  private com.tencent.mm.plugin.emoji.e.p xSX;
  private a xSY;
  private goi xSZ;
  private View xTA;
  private TextView xTB;
  private Button xTC;
  private DonorsAvatarView xTD;
  private TextView xTE;
  private int xTF;
  private int xTG;
  private int xTH;
  private String xTI;
  private String xTJ;
  private boolean xTK;
  private int xTL;
  private int xTM;
  private String xTN;
  private String xTO;
  private String xTP;
  private String[] xTQ;
  private boolean xTR;
  private View xTS;
  private boolean xTT;
  private ciw xTU;
  private boolean xTV;
  private boolean xTW;
  private boolean xTX;
  private com.tencent.mm.ui.base.w xTY;
  private bu xTZ;
  private boolean xTa;
  private TextView xTb;
  private View xTc;
  private EmojiDetailScrollView xTd;
  private BannerEmojiView xTe;
  private TextView xTf;
  private MMAutoSizeTextView xTg;
  private TextView xTh;
  private TextView xTi;
  private TextView xTj;
  private EmojiDetailGridView xTk;
  private ImageView xTl;
  private View xTm;
  private TextView xTn;
  private TextView xTo;
  private View xTp;
  private int xTq;
  private View xTr;
  private ProgressBar xTs;
  private View xTt;
  private ImageView xTu;
  private TextView xTv;
  private View xTw;
  private View xTx;
  private TextView xTy;
  private TextView xTz;
  private View.OnClickListener xUa;
  private View.OnClickListener xUb;
  private View.OnClickListener xUc;
  private View.OnClickListener xUd;
  private com.tencent.mm.modelimage.loader.b.l xUf;
  private o.a xUg;
  
  static
  {
    AppMethodBeat.i(176199);
    xUe = new c((byte)0);
    AppMethodBeat.o(176199);
  }
  
  public EmojiStoreDetailUI()
  {
    AppMethodBeat.i(109009);
    this.xST = false;
    this.xSU = -1;
    this.xQC = new aoi();
    this.xQD = "";
    this.xSZ = null;
    this.xTI = "";
    this.xNp = "";
    this.xTM = -1;
    this.xTQ = new String[1];
    this.xTR = false;
    this.xTT = true;
    this.xTV = false;
    this.xTW = true;
    this.xTX = false;
    this.xQg = new IListener(com.tencent.mm.app.f.hfK) {};
    this.xUa = new EmojiStoreDetailUI.12(this);
    this.xUb = new EmojiStoreDetailUI.15(this);
    this.xUc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108994);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).Zul);
        if ((EmojiStoreDetailUI.b(EmojiStoreDetailUI.this) != null) && (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akks != null)) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akks.IGU);
        }
        ((Intent)localObject).putExtra("scene", EmojiStoreDetailUI.c(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("pageType", 1);
        ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(EmojiStoreDetailUI.this)), Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108994);
      }
    };
    this.xUd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108995);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_iconurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).IHo);
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).Zul);
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akks != null) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akks.IGU);
        }
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
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
        EmojiStoreDetailUI.this.dBM();
        AppMethodBeat.o(108996);
      }
    };
    this.xUf = new com.tencent.mm.modelimage.loader.b.l()
    {
      public final void iV(long paramAnonymousLong)
      {
        AppMethodBeat.i(176192);
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10930, EmojiStoreDetailUI.a(EmojiStoreDetailUI.this) + "," + paramAnonymousLong);
        AppMethodBeat.o(176192);
      }
    };
    this.xUg = new o.a()
    {
      public final void ac(ArrayList<com.tencent.mm.pluginsdk.model.w> paramAnonymousArrayList)
      {
        AppMethodBeat.i(176191);
        int i;
        if (paramAnonymousArrayList == null)
        {
          i = 0;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish] %s", new Object[] { Integer.valueOf(i) });
          EmojiStoreDetailUI.z(EmojiStoreDetailUI.this);
          if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
          {
            paramAnonymousArrayList = (com.tencent.mm.pluginsdk.model.w)paramAnonymousArrayList.get(0);
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", new Object[] { paramAnonymousArrayList });
            if (paramAnonymousArrayList.XRy != 10232) {
              break label175;
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 4);
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousArrayList.XRv);
            EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.XRw);
            paramAnonymousArrayList = new BigDecimal(paramAnonymousArrayList.XRx).divide(new BigDecimal(1000000));
            EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramAnonymousArrayList.toString());
          }
        }
        for (;;)
        {
          EmojiStoreDetailUI.this.Ks(1002);
          AppMethodBeat.o(176191);
          return;
          i = paramAnonymousArrayList.size();
          break;
          label175:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 10);
          EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.XRy);
        }
      }
    };
    AppMethodBeat.o(109009);
  }
  
  private void aNe()
  {
    AppMethodBeat.i(109036);
    if ((this.xTV) && ((this.xTU == null) || ((this.xTU.aart & 0x1) != 1)) && ((this.xQC == null) || (!com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akke, 1))) && (this.xTU != null) && (!TextUtils.isEmpty(this.xTU.aars)))
    {
      this.xTi.setText(this.xTU.aars);
      this.xTi.setTextColor(getContext().getResources().getColor(h.b.half_alpha_black));
      this.xTi.setBackgroundDrawable(null);
      this.xTi.setEnabled(false);
    }
    AppMethodBeat.o(109036);
  }
  
  private void aoJ(String paramString)
  {
    AppMethodBeat.i(109025);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(h.h.emoji_play_failed);
    }
    com.tencent.mm.ui.base.k.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109025);
  }
  
  private boolean dBE()
  {
    AppMethodBeat.i(270431);
    dzv localdzv = this.xQC.akku;
    if (localdzv == null)
    {
      Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "go2ActivityDetail: info is null");
      AppMethodBeat.o(270431);
      return false;
    }
    switch (localdzv.ZuN)
    {
    default: 
      if (Util.isNullOrNil(localdzv.ZuO))
      {
        AppMethodBeat.o(270431);
        return false;
      }
      break;
    case 1: 
      if (Util.isNullOrNil(localdzv.Zrd))
      {
        AppMethodBeat.o(270431);
        return false;
      }
      break;
    case 3: 
      if ((Util.isNullOrNil(localdzv.abfc)) || (Util.isNullOrNil(localdzv.abfd)))
      {
        AppMethodBeat.o(270431);
        return false;
      }
      break;
    case 2: 
      if (Util.isNullOrNil(localdzv.YRs))
      {
        AppMethodBeat.o(270431);
        return false;
      }
      break;
    }
    AppMethodBeat.o(270431);
    return true;
  }
  
  private void dBF()
  {
    AppMethodBeat.i(109021);
    this.bEx.setVisibility(0);
    this.xTc.setVisibility(8);
    this.xTd.setVisibility(8);
    this.xTb.setText(h.h.emoji_no_find);
    AppMethodBeat.o(109021);
  }
  
  private void dBG()
  {
    AppMethodBeat.i(109022);
    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.xQC == null) || (this.xQC.akke == 0))
    {
      this.bEx.setVisibility(0);
      this.xTc.setVisibility(8);
    }
    AppMethodBeat.o(109022);
  }
  
  private void dBH()
  {
    AppMethodBeat.i(109026);
    this.xSZ = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjA.bzk(this.xOk);
    AppMethodBeat.o(109026);
  }
  
  private void dBI()
  {
    AppMethodBeat.i(109027);
    if ((com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akke, 64)) && (com.tencent.mm.emoji.c.o.aUN()))
    {
      this.xSX = new com.tencent.mm.plugin.emoji.e.p(this.xOk, com.tencent.mm.plugin.emoji.e.p.xOO);
      com.tencent.mm.kernel.h.baD().mCm.a(this.xSX, 0);
    }
    AppMethodBeat.o(109027);
  }
  
  private boolean dBJ()
  {
    AppMethodBeat.i(109028);
    boolean bool = com.tencent.mm.plugin.emoji.g.c.dBJ();
    this.xTa = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.xSU = i;
      AppMethodBeat.o(109028);
      return bool;
    }
  }
  
  private void dBK()
  {
    AppMethodBeat.i(109029);
    if (!Util.isNullOrNil(this.xQC.Zul))
    {
      setMMTitle(this.xQC.Zul);
      this.xOl = this.xQC.Zul;
    }
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.xQC.akkk });
    this.xTc.setVisibility(0);
    this.bEx.setVisibility(8);
    oa(true);
    this.xTg.setText(this.xQC.Zul);
    this.xTh.setText(this.xQC.akki);
    this.xTj.setText(this.xQC.akka);
    if (com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akkd, 1)) {
      this.xTf.setVisibility(8);
    }
    for (;;)
    {
      dBO();
      dBP();
      aNe();
      dBQ();
      dBR();
      this.xTg.setMaxWidth(this.xTq - this.xTr.getWidth() - com.tencent.mm.cd.a.br(getContext(), h.c.NormalPadding) * 2 - this.xTf.getWidth() - com.tencent.mm.cd.a.br(getContext(), h.c.ListPadding) * 2);
      this.xTg.setVisibility(8);
      this.xTg.setVisibility(0);
      dBL();
      dBN();
      dBM();
      if ((com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akke, 128)) && (!Util.isNullOrNil(this.xQC.akkt))) {
        break;
      }
      this.xTx.setVisibility(8);
      AppMethodBeat.o(109029);
      return;
      this.xTf.setVisibility(0);
      this.xTf.setText(h.h.emoji_type_gif);
    }
    this.xTx.setVisibility(0);
    this.xTy.setText(this.xQC.akkt);
    this.xTZ = new bu();
    this.xTZ.ld(this.xOk);
    this.xTZ.iuA = this.xTH;
    if (!dBE())
    {
      this.xTZ.iuB = 0L;
      this.xTz.setText(h.h.emoji_detail_activity_end);
      this.xTz.setEnabled(false);
      AppMethodBeat.o(109029);
      return;
    }
    this.xTZ.iuB = 1L;
    String str = this.xQC.akku.aars;
    if (Util.isNullOrNil(str))
    {
      this.xTz.setText(h.h.emoji_detail_activity_more);
      AppMethodBeat.o(109029);
      return;
    }
    this.xTz.setText(str);
    AppMethodBeat.o(109029);
  }
  
  private void dBL()
  {
    AppMethodBeat.i(109031);
    if ((this.xQC.akks != null) && (this.xQC.akks.ZtX != 0) && (this.xTH != 6))
    {
      this.xTw.setVisibility(0);
      this.xTt.setVisibility(0);
      r.bKe().a(this.xQC.akks.ZuK, this.xTu, com.tencent.mm.plugin.emoji.mgr.e.gK(this.xOk, this.xQC.akks.ZuK));
      this.xTv.setText(this.xQC.akks.IGU);
      this.xTt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176185);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = new Intent();
          ((Intent)localObject).setClass(EmojiStoreDetailUI.this.getContext(), EmojiStoreV2DesignerUI.class);
          ((Intent)localObject).putExtra("uin", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akks.ZtX);
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akks.IGU);
          ((Intent)localObject).putExtra("headurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akks.ZuK);
          ((Intent)localObject).putExtra("rediret_url", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akkq);
          ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
          ((Intent)localObject).putExtra("extra_scence", 26);
          paramAnonymousView = EmojiStoreDetailUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176185);
        }
      });
      AppMethodBeat.o(109031);
      return;
    }
    this.xTw.setVisibility(8);
    this.xTt.setVisibility(8);
    AppMethodBeat.o(109031);
  }
  
  private void dBN()
  {
    AppMethodBeat.i(109033);
    if ((this.xQC.akke & 0x20) == 32)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)this.xTo.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.xTn.getLayoutParams();
      this.xTo.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.cd.a.br(getContext(), h.c.NormalPadding);
      this.xTo.setLayoutParams(localLayoutParams1);
      this.xTo.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.cd.a.br(getContext(), h.c.NormalPadding);
      this.xTn.setLayoutParams(localLayoutParams2);
      this.xTn.setGravity(5);
      AppMethodBeat.o(109033);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.xTn.getLayoutParams();
    localLayoutParams1.gravity = 17;
    this.xTn.setLayoutParams(localLayoutParams1);
    this.xTn.setGravity(17);
    this.xTo.setVisibility(8);
    AppMethodBeat.o(109033);
  }
  
  private void dBO()
  {
    AppMethodBeat.i(109034);
    int i;
    if (com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akkd, 8))
    {
      this.xTG = 0;
      Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.xQC.akke) });
      if ((!com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akke, 128)) || (!Util.isNullOrNil(this.xSP))) {
        break label202;
      }
      i = 1;
      label80:
      if ((!com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akke, 8)) || (!com.tencent.mm.plugin.emoji.a.a.e.Kj(this.xQC.akkd))) {
        break label207;
      }
      this.xSU = 8;
    }
    for (;;)
    {
      if (this.xTa) {
        this.xSU = 7;
      }
      AppMethodBeat.o(109034);
      return;
      if (com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akkd, 4))
      {
        this.xTG = 0;
        break;
      }
      if ((!this.xTK) && ((this.xQC.akkv == 0) || (TextUtils.isEmpty(this.xQC.akkc))))
      {
        this.xTG = 0;
        break;
      }
      this.xTG = 1;
      break;
      label202:
      i = 0;
      break label80;
      label207:
      if ((com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akke, 1)) || (com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akkd, 8))) {
        this.xSU = 3;
      } else if (i != 0) {
        this.xSU = 20;
      } else if (com.tencent.mm.plugin.emoji.a.a.e.Kj(this.xQC.akkd)) {
        this.xSU = 0;
      } else if ((!this.xTK) && (((this.xQC.akkw == 0) && (TextUtils.isEmpty(this.xQC.akkj))) || (this.xQC.akkj.equals("0")))) {
        this.xSU = 0;
      } else if (this.xTK)
      {
        if (TextUtils.isEmpty(this.xTN)) {
          this.xSU = this.xTL;
        } else {
          this.xSU = 4;
        }
      }
      else {
        this.xSU = 4;
      }
    }
  }
  
  private void dBP()
  {
    AppMethodBeat.i(109035);
    if (com.tencent.mm.plugin.emoji.g.c.apa(this.xOk)) {
      dBJ();
    }
    ob(false);
    switch (this.xSU)
    {
    case 1: 
    case 2: 
    case 9: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.xSU) });
    }
    for (;;)
    {
      aNe();
      AppMethodBeat.o(109035);
      return;
      this.xTs.setVisibility(8);
      this.xTi.setTextColor(getResources().getColorStateList(h.b.emoji_download_finish_color));
      this.xTi.setBackgroundResource(h.d.btn_solid_white);
      this.xTi.setText(h.h.emoji_store_expire);
      this.xTi.setEnabled(false);
      continue;
      this.xTs.setVisibility(8);
      this.xTi.setTextColor(getResources().getColorStateList(h.b.white_text_color_selector));
      this.xTi.setBackgroundResource(h.d.btn_solid_green);
      this.xTi.setText(h.h.emoji_store_download);
      this.xTi.setEnabled(true);
      continue;
      this.xTs.setVisibility(8);
      this.xTi.setTextColor(getResources().getColorStateList(h.b.white_text_color_selector));
      this.xTi.setBackgroundResource(h.d.btn_solid_green);
      this.xTi.setEnabled(true);
      if (this.xTK)
      {
        if (Util.isNullOrNil(this.xTN))
        {
          this.xTi.setText("");
        }
        else
        {
          this.xTi.setText(this.xTN);
          this.xTi.setContentDescription(String.format(MMApplicationContext.getString(h.h.emoji_price_unit), new Object[] { this.xTi.getText() }));
        }
      }
      else
      {
        if (!com.tencent.mm.plugin.emoji.g.b.KK(this.xQC.akke))
        {
          this.xTi.setText(this.xQC.akkc);
          this.xTi.setContentDescription(String.format(MMApplicationContext.getString(h.h.emoji_price_unit), new Object[] { this.xTi.getText() }));
        }
        for (;;)
        {
          this.xSU = 4;
          break;
          ob(true);
          this.xTi.setText(com.tencent.mm.plugin.emoji.g.b.c(this.mContext, this.xQC.akkv, getString(h.h.emoji_wecoin_price_button_woring_suffix)), TextView.BufferType.SPANNABLE);
          this.xTi.setContentDescription(String.format(MMApplicationContext.getString(h.h.emoji_wecoin_price_unit), new Object[] { Integer.valueOf(this.xQC.akkv) }));
        }
        this.xTs.setVisibility(8);
        this.xTi.setTextColor(getResources().getColorStateList(h.b.white_text_color_selector));
        this.xTi.setBackgroundResource(h.d.btn_solid_green);
        this.xTi.setText(h.h.emoji_store_download);
        this.xTi.setEnabled(true);
        continue;
        this.xTs.setVisibility(8);
        this.xTi.setEnabled(false);
        this.xTm.setVisibility(0);
        this.xTl.setVisibility(0);
        this.xTi.setVisibility(4);
        if (this.xSQ != 3)
        {
          continue;
          this.xTs.setVisibility(8);
          this.xTi.setVisibility(0);
          this.xTi.setEnabled(true);
          if (this.xTX)
          {
            this.xTi.setText(h.h.emoji_remove);
            this.xTi.setTextColor(getResources().getColorStateList(h.b.green_text_color_selector));
            this.xTi.setBackgroundResource(h.d.btn_solid_grey);
          }
          for (;;)
          {
            this.xTm.setVisibility(8);
            this.xGo.setProgress(0);
            this.xTl.setVisibility(4);
            if (this.xSQ == 3) {
              break;
            }
            break;
            ob(true);
            this.xTi.setTextColor(getResources().getColorStateList(h.b.white_text_color_selector));
            this.xTi.setText(h.h.emoji_store_deatail_used);
            this.xTi.setBackgroundResource(h.d.btn_solid_green);
          }
          this.xTs.setVisibility(8);
          this.xTi.setBackgroundResource(h.d.btn_solid_green);
          this.xTi.setText(h.h.emoji_store_download);
          this.xTi.setEnabled(true);
          this.xTs.setVisibility(0);
          this.xTi.setVisibility(0);
          this.xTi.setBackgroundResource(h.d.white_bigbtn_tips_normal);
          this.xTi.setText("");
          this.xTi.setEnabled(false);
          this.xTm.setVisibility(8);
          this.xGo.setProgress(0);
          this.xTl.setVisibility(4);
          continue;
          this.xTs.setVisibility(8);
          this.xTi.setVisibility(0);
          this.xTi.setBackgroundResource(h.d.btn_solid_green);
          this.xTi.setText(h.h.emoji_store_play);
          this.xTi.setEnabled(true);
          this.xTm.setVisibility(8);
          this.xGo.setProgress(0);
          this.xTl.setVisibility(4);
          continue;
          this.xTs.setVisibility(8);
          this.xTi.setTextColor(getResources().getColorStateList(h.b.emoji_download_finish_color));
          this.xTi.setBackgroundResource(h.d.btn_solid_white);
          this.xTi.setText(h.h.emoji_preview_activity_limit);
          this.xTi.setEnabled(false);
          continue;
          dBO();
          dBP();
        }
      }
    }
  }
  
  private void dBQ()
  {
    AppMethodBeat.i(109037);
    if ((!com.tencent.mm.plugin.emoji.g.c.apa(this.xOk)) && ((this.xQC.akkn == null) || (this.xQC.akkn.size() <= 0) || (((goj)this.xQC.akkn.get(0)).aklj == null))) {
      this.xTS.setVisibility(8);
    }
    for (;;)
    {
      this.xTk.setProductId(this.xOk);
      if (this.xSY != null) {
        this.xSY.notifyDataSetInvalidated();
      }
      AppMethodBeat.o(109037);
      return;
      this.xTS.setVisibility(0);
    }
  }
  
  private void dBR()
  {
    AppMethodBeat.i(109038);
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.xQC.akke });
    if ((this.xQC.akke & 0x10) == 16) {
      addIconOptionMenu(0, h.g.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
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
  
  private void dBS()
  {
    AppMethodBeat.i(109039);
    com.tencent.mm.ui.base.k.a(this, h.h.emoji_store_cancle_download_msg, 0, h.h.emoji_store_stop_download, h.h.emoji_store_continue_download, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176187);
        if (com.tencent.mm.plugin.emoji.g.c.apa(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this)))
        {
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
          com.tencent.mm.plugin.emoji.e.a.dAs().dAu();
          if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this)))
          {
            if (com.tencent.mm.modelcdntran.k.bHW().Nz(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this))) {
              break label264;
            }
            Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask failed. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(EmojiStoreDetailUI.this) });
          }
          label81:
          if ((!com.tencent.mm.plugin.emoji.a.a.e.gO(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akke, 1)) && (!com.tencent.mm.plugin.emoji.a.a.e.Kj(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).akkd))) {
            break label288;
          }
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 3);
        }
        for (;;)
        {
          com.tencent.mm.plugin.emoji.model.s.dAq().i(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.u(EmojiStoreDetailUI.this), 0, EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
          EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(8);
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(0);
          EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(4);
          EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(0);
          EmojiStoreDetailUI.v(EmojiStoreDetailUI.this);
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          paramAnonymousDialogInterface = new com.tencent.mm.plugin.emoji.e.s(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), 2);
          com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(176187);
          return;
          com.tencent.mm.kernel.h.baD().mCm.a(EmojiStoreDetailUI.s(EmojiStoreDetailUI.this));
          break;
          label264:
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(EmojiStoreDetailUI.this) });
          break label81;
          label288:
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
  
  private void dBT()
  {
    AppMethodBeat.i(109041);
    if (com.tencent.mm.plugin.emoji.g.c.apa(this.xOk))
    {
      com.tencent.mm.plugin.emoji.e.a.dAs();
      com.tencent.mm.plugin.emoji.e.a.dAt();
      AppMethodBeat.o(109041);
      return;
    }
    this.xSW = new com.tencent.mm.plugin.emoji.e.h(this.xOk, this.xOm, this.xOl, this.xSP);
    com.tencent.mm.kernel.h.baD().mCm.a(this.xSW, 0);
    switch (this.xQc)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11598, new Object[] { Integer.valueOf(1), this.xOk });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11598, new Object[] { Integer.valueOf(3), this.xOk });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11598, new Object[] { Integer.valueOf(2), this.xOk });
    }
  }
  
  private void oa(boolean paramBoolean)
  {
    AppMethodBeat.i(109030);
    Object localObject = null;
    String str;
    if (!Util.isNullOrNil(this.xQC.ZtY))
    {
      if (!paramBoolean) {
        break label104;
      }
      localObject = this.xOk;
      str = this.xQC.ZtY;
      com.tencent.mm.cd.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, xUe);; localObject = EmojiLogic.K((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.xTe != null)) {
        this.xTe.setImageFilePath(((EmojiInfo)localObject).kMn());
      }
      if (com.tencent.mm.plugin.emoji.g.c.apa(this.xOk)) {
        this.xTe.setImageResource(h.d.tuzi_banner);
      }
      AppMethodBeat.o(109030);
      return;
      label104:
      localObject = this.xOk;
      str = this.xQC.ZtY;
      com.tencent.mm.cd.a.getDensity(this.mContext);
    }
  }
  
  private void ob(boolean paramBoolean)
  {
    AppMethodBeat.i(270507);
    if (paramBoolean)
    {
      this.xTi.setMinimumWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 88));
      AppMethodBeat.o(270507);
      return;
    }
    this.xTi.setMinimumWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 80));
    AppMethodBeat.o(270507);
  }
  
  public final void Ks(int paramInt)
  {
    AppMethodBeat.i(109042);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
    AppMethodBeat.o(109042);
  }
  
  public final void dBM()
  {
    AppMethodBeat.i(109032);
    if ((com.tencent.mm.plugin.emoji.a.a.e.gO(this.xQC.akke, 64)) && (com.tencent.mm.emoji.c.o.aUN()))
    {
      if (this.xSZ != null)
      {
        this.xTA.setVisibility(0);
        this.xTC.setText(h.h.emoji_store_reward);
        this.xTB.setText(this.xSZ.aklh.ZuS);
        this.xTB.setLongClickable(false);
        if (this.xSZ.aarw > 0)
        {
          this.xTE.setVisibility(0);
          String str1 = String.valueOf(this.xSZ.aarw);
          String str2 = String.format(getString(h.h.emoji_store_reward_info), new Object[] { Integer.valueOf(this.xSZ.aarw) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(h.b.emotion_reward_link_color)), i, str1.length() + i, 33);
          }
          this.xTE.setText(localSpannableString);
        }
        while ((this.xSZ.aarx != null) && (this.xSZ.aarx.size() > 0))
        {
          this.xTD.setVisibility(0);
          this.xTD.d(this.xOk, this.xSZ.aarx);
          AppMethodBeat.o(109032);
          return;
          this.xTE.setVisibility(8);
        }
        this.xTD.setVisibility(8);
        AppMethodBeat.o(109032);
        return;
      }
      this.xTA.setVisibility(8);
      dBI();
      AppMethodBeat.o(109032);
      return;
    }
    this.xTA.setVisibility(8);
    AppMethodBeat.o(109032);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_store_detail;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109011);
    if (!Util.isNullOrNil(this.xOl)) {
      setMMTitle(this.xOl);
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
    this.ebX = com.tencent.mm.cd.a.br(this.mContext, h.c.emoji_detail_item_margin);
    this.xTF = getResources().getDimensionPixelSize(h.c.emoji_detail_item_image_size);
    this.xTF = com.tencent.mm.cd.a.br(this.mContext, h.c.emoji_detail_item_image_size);
    this.mNumColumns = 4;
    this.xTd = ((EmojiDetailScrollView)findViewById(h.e.scrollview));
    this.bEx = findViewById(h.e.empty);
    this.xTb = ((TextView)this.bEx.findViewById(h.e.empty_content));
    this.xTc = findViewById(h.e.emoji_store_detail);
    this.xTe = ((BannerEmojiView)findViewById(h.e.emoji_image));
    int i = this.xTe.getRight();
    int j = this.xTe.getLeft();
    int k = this.xTe.getPaddingRight();
    int m = this.xTe.getPaddingLeft();
    this.xTe.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.xTf = ((TextView)findViewById(h.e.emoji_tip));
    this.xTg = ((MMAutoSizeTextView)findViewById(h.e.emoji_title));
    this.xTh = ((TextView)findViewById(h.e.emoji_copyright));
    this.xTi = ((TextView)findViewById(h.e.emoji_type));
    this.xTj = ((TextView)findViewById(h.e.emoji_destrition));
    this.xTq = com.tencent.mm.cd.a.ms(getContext());
    this.xTr = findViewById(h.e.emoji_action);
    this.xTk = ((EmojiDetailGridView)findViewById(h.e.emoji_gridview));
    this.xSY = new a();
    if (com.tencent.mm.plugin.emoji.g.c.apa(this.xOk))
    {
      localObject = this.xSY;
      List localList = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.aoh(com.tencent.mm.plugin.emoji.g.c.dDt());
      if (localList != null)
      {
        ((a)localObject).mip.clear();
        ((a)localObject).mip.addAll(localList);
        ((a)localObject).notifyDataSetChanged();
      }
    }
    this.xTm = findViewById(h.e.emoji_progress);
    this.xGo = ((ProgressBar)findViewById(h.e.emoji_download_progress));
    this.xTl = ((ImageView)findViewById(h.e.emoji_close));
    this.xTl.setOnClickListener(this);
    this.xTm.setVisibility(8);
    this.xTl.setVisibility(8);
    this.xGo.setProgress(0);
    this.xTk.setAdapter(this.xSY);
    this.xTk.setColumnWidth(this.xTF);
    this.xTk.setNumColumns(this.mNumColumns);
    this.xTk.setHorizontalSpacing(this.ebX);
    this.xTk.setVerticalSpacing(this.ebX);
    this.xTk.setEmojiDetailScrollView(this.xTd);
    this.xTk.setFromDetail(true);
    this.xTk.setIsShowPopWin(true);
    this.xTk.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(176183);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView instanceof EmojiInfo))
        {
          paramAnonymousAdapterView = (EmojiInfo)paramAnonymousAdapterView;
          paramAnonymousView = new amn();
          com.tencent.mm.plugin.emoji.g.d.a(paramAnonymousAdapterView, paramAnonymousView);
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.OAn.b(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAnonymousAdapterView.field_md5, EmojiStoreDetailUI.d(EmojiStoreDetailUI.this), paramAnonymousAdapterView.field_designerID, paramAnonymousAdapterView.field_groupId, Integer.valueOf(26) });
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(176183);
      }
    });
    this.xTi.setOnClickListener(this);
    this.xTp = findViewById(h.e.sticker_declare_area);
    this.xTn = ((TextView)findViewById(h.e.emoji_service));
    this.xTo = ((TextView)findViewById(h.e.emoji_complaints));
    this.xTn.setOnClickListener(this.xUa);
    this.xTo.setOnClickListener(this.xUb);
    this.xTs = ((ProgressBar)findViewById(h.e.emoji_google_price_loading));
    Object localObject = this.xTs;
    if (this.xTK) {}
    for (i = 0;; i = 8)
    {
      ((ProgressBar)localObject).setVisibility(i);
      this.xTS = findViewById(h.e.emoji_long_touch_pre_tips);
      if (WeChatBrands.Business.Entries.MeStickerDeclare.banned()) {
        this.xTp.setVisibility(8);
      }
      this.xTw = findViewById(h.e.emoji_designer_line_2);
      this.xTt = findViewById(h.e.designer_bar_container);
      this.xTu = ((ImageView)findViewById(h.e.designer_icon));
      this.xTv = ((TextView)findViewById(h.e.designer_title));
      this.xTA = findViewById(h.e.emoji_reward);
      this.xTB = ((TextView)findViewById(h.e.reward_begword));
      this.xTC = ((Button)findViewById(h.e.reward_btn));
      this.xTE = ((TextView)findViewById(h.e.reward_info));
      this.xTD = ((DonorsAvatarView)findViewById(h.e.reward_avatar));
      this.xTC.setOnClickListener(this.xUc);
      this.xTE.setOnClickListener(this.xUd);
      this.xTx = findViewById(h.e.emoji_detail_activity_info);
      this.xTy = ((TextView)findViewById(h.e.emoji_detail_activity_title));
      this.xTz = ((TextView)findViewById(h.e.emoji_detail_activity_more));
      this.xTz.setOnClickListener(this);
      AppMethodBeat.o(109011);
      return;
    }
  }
  
  public final void k(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(109040);
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (!paramString1.equals(this.xOk)))
    {
      AppMethodBeat.o(109040);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.xTJ = paramString2;
    }
    if (paramInt1 == -1)
    {
      if (this.xSU != -1)
      {
        this.xSU = -1;
        Ks(1003);
        AppMethodBeat.o(109040);
      }
    }
    else
    {
      if (paramInt1 == 7)
      {
        this.xSU = 7;
        Ks(1003);
        AppMethodBeat.o(109040);
        return;
      }
      if (paramInt1 == 6)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.xOk)))
        {
          this.xSU = 6;
          this.boE = paramInt2;
          Ks(1004);
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
      this.xTR = false;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          localObject = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localObject != null) && (((ArrayList)localObject).contains(this.xOk)))
          {
            paramInt1 = 0;
            while (paramInt1 < ((ArrayList)localObject).size())
            {
              if (this.xOk.equals(((ArrayList)localObject).get(paramInt1))) {
                this.xOm = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.xQC.akke = 1;
            dBT();
            this.xSU = 6;
            com.tencent.mm.ui.base.k.cZ(this, str1);
            if (z.bBh())
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 4L, 1L, false);
              AppMethodBeat.o(109023);
              return;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 0L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          this.xSU = -1;
          dBP();
          aoJ(str1);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 100000002))
        {
          dBT();
          this.xSU = 6;
          this.xSY.notifyDataSetChanged();
          if (z.bBh())
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 7L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 3L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 1))
        {
          this.xSU = -1;
          dBP();
          if (z.bBh())
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 6L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 2L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        this.xSU = -1;
        dBP();
        aoJ(str1);
        if (z.bBh())
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 5L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 1L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      this.xSU = -1;
      dBP();
      if (z.bBh())
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 6L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 2L, 1L, false);
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
          str1 = this.xOk;
          localObject = this.xQC.Zul;
          String str2 = this.xQC.akka;
          String str3 = this.xQC.IHo;
          String str4 = this.xQC.akkq;
          paramInt1 = this.xQC.akke;
          String str5 = getResources().getString(h.h.app_emoji_share);
          str5 = str5 + (String)localObject;
          String str6 = getString(h.h.app_send);
          String str7 = getString(h.h.confirm_dialog_edittext_hint);
          ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.j.class)).a(this, paramIntent, str5, str6, str7, str3, new j.1(paramIntent, str1, (String)localObject, str2, str3, str4, paramInt1, this));
        }
        AppMethodBeat.o(109023);
      }
    }
    else if (paramInt1 == this.xNs.uaQ)
    {
      if (paramInt2 == -1)
      {
        Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
        if (IntentUtil.getBooleanExtra(getIntent(), "from_appbrand_ui", false)) {
          this.xNs.ydN = true;
        }
        this.xNs.a(paramIntent, this.xOk, this);
        com.tencent.mm.plugin.report.service.h.OAn.b(12069, new Object[] { Integer.valueOf(3), this.xOk });
        AppMethodBeat.o(109023);
      }
    }
    else if ((paramInt1 == 2004) && (paramInt2 == -1)) {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getContext().getString(h.h.app_sent));
    }
    AppMethodBeat.o(109023);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109019);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i = paramView.getId();
    if (i == h.e.emoji_type)
    {
      if (this.xSU == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if (this.xTX)
        {
          paramView = new com.tencent.mm.plugin.emoji.e.s(this.xOk, 2);
          com.tencent.mm.kernel.h.baD().mCm.a(paramView, 0);
          this.xTY = com.tencent.mm.ui.base.w.a(this, getString(h.h.loading), true, 0, null);
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(11076, "0, ");
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109019);
        return;
        if ((!Util.isNullOrNil(paramView)) && (this.xST))
        {
          this.xNs.a(paramView, this.xOk, this);
          break;
        }
        this.xNs.X(this);
        com.tencent.mm.plugin.report.service.h.OAn.b(12069, new Object[] { Integer.valueOf(2), this.xOk });
        break;
        switch (this.xSU)
        {
        case 1: 
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          Log.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.xSU) });
          break;
        case 4: 
          if (!this.xTR)
          {
            if (this.xTX)
            {
              paramView = com.tencent.mm.emoji.d.e.mmt;
              com.tencent.mm.emoji.d.e.rG(6);
            }
            if (com.tencent.mm.plugin.emoji.g.b.dDp())
            {
              com.tencent.mm.plugin.emoji.g.b.ay(getContext(), getString(h.h.emoji_wecoin_intercept_teen_mode_content));
              Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "Pay Intercept, TeenModeEnable, mProductId:%s, mData.WeCoinNum:%s", new Object[] { this.xOk, Integer.valueOf(this.xQC.akkw) });
            }
            else if (com.tencent.mm.plugin.emoji.g.b.KK(this.xQC.akke))
            {
              Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.WeCoinNum:%s", new Object[] { this.xOk, Integer.valueOf(this.xQC.akkw) });
              if (com.tencent.mm.plugin.emoji.g.b.dDq())
              {
                com.tencent.mm.plugin.emoji.g.b.dDr();
                com.tencent.mm.plugin.emoji.g.b.ga(getContext()).dDn();
              }
              else
              {
                com.tencent.mm.plugin.emoji.g.b.dDr();
                com.tencent.mm.plugin.emoji.g.b.c(getContext(), this.xOk, this.xQC.Zuw, this.xQC.akkw, this.xQC.Zul);
                com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.xTH), "", this.xOk, this.xTI, this.xNp });
                this.xTR = true;
              }
            }
            else
            {
              Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.xOk, this.xQC.akkc, this.xQC.Zuw });
              paramView = new Intent();
              paramView.putExtra("key_product_id", this.xOk);
              if (this.xTK)
              {
                paramView.putExtra("key_currency_type", this.xTO);
                paramView.putExtra("key_price", this.xTO + this.xTP);
              }
              for (;;)
              {
                com.tencent.mm.br.c.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
                break;
                paramView.putExtra("key_currency_type", this.xQC.Zuw);
                paramView.putExtra("key_price", this.xQC.akkj);
              }
            }
          }
          break;
        case 0: 
        case 3: 
          if (this.xTX)
          {
            paramView = com.tencent.mm.emoji.d.e.mmt;
            com.tencent.mm.emoji.d.e.rG(6);
          }
          dBT();
          this.xSU = 6;
          dBP();
          com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.xTH), "", this.xOk, this.xTI, this.xNp });
          if (this.xNu != null)
          {
            this.xNu.ipB = 4;
            this.xNu.bMH();
          }
          break;
        case 5: 
          this.xSU = 3;
          dBP();
          break;
        case 10: 
        case 12: 
          switch (this.xTM)
          {
          default: 
            paramView = getString(h.h.emoji_unknow);
          }
          for (;;)
          {
            com.tencent.mm.ui.base.k.c(this, paramView, null, true);
            break;
            paramView = getString(h.h.emoji_google_no_install);
            continue;
            paramView = getString(h.h.emoji_no_on_sale);
            continue;
            paramView = getString(h.h.emoji_timeout);
          }
        case 11: 
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
          break;
        case -1: 
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
        }
      }
    }
    if (i == h.e.emoji_download_progress)
    {
      dBS();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    if (i == h.e.emoji_close)
    {
      dBS();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    if (i == h.e.emoji_detail_activity_more)
    {
      if (this.xTZ != null) {
        this.xTZ.iuC = 1L;
      }
      localObject = this.xQC.akku;
      if (localObject == null) {
        Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "go2ActivityDetail: info is null");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109019);
        return;
        switch (((dzv)localObject).ZuN)
        {
        default: 
          paramView = ((dzv)localObject).ZuO;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "go2H5: %s", new Object[] { paramView });
          if (Util.isNullOrNil(paramView)) {
            Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "go2H5: h5 is empty");
          }
          break;
        case 1: 
          localObject = ((dzv)localObject).Zrd;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "go2Finder: %s", new Object[] { localObject });
          if (Util.isNullOrNil((String)localObject))
          {
            Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "go2Finder: username is empty");
          }
          else
          {
            paramView = new Intent();
            paramView.putExtra("finder_username", (String)localObject);
            boolean bool = ((String)localObject).equals(z.bAW());
            localObject = (cn)com.tencent.mm.kernel.h.az(cn.class);
            if (bool) {}
            for (i = 33;; i = 32)
            {
              ((cn)localObject).fillContextIdToIntent(14, 2, i, paramView);
              paramView.putExtra("KEY_FINDER_SELF_FLAG", bool);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(getContext(), paramView);
              break;
            }
          }
          break;
        case 3: 
          paramView = ((dzv)localObject).abfc;
          localObject = ((dzv)localObject).abfd;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "go2AppBrand: %s, %s", new Object[] { paramView, localObject });
          if (Util.isNullOrNil(paramView))
          {
            Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "go2AppBrand: username is empty");
          }
          else
          {
            com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
            localg.username = paramView;
            localg.scene = 1204;
            localg.qAF = ((String)localObject);
            ((t)com.tencent.mm.kernel.h.ax(t.class)).a(this, localg);
          }
          break;
        case 2: 
          paramView = ((dzv)localObject).YRs;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "go2BizProfile: %s", new Object[] { paramView });
          if (Util.isNullOrNil(paramView))
          {
            Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "go2BizProfile: username is empty");
          }
          else
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramView);
            ((Intent)localObject).putExtra("force_get_contact", true);
            ((Intent)localObject).putExtra("key_use_new_contact_profile", true);
            com.tencent.mm.br.c.b(this.mContext, "profile", ".ui.ContactInfoUI", (Intent)localObject);
            continue;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramView);
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          }
          break;
        }
      }
    }
    Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109019);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109010);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.h.baz())
    {
      finish();
      AppMethodBeat.o(109010);
      return;
    }
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "exit in teen mode");
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(this);
      finish();
      AppMethodBeat.o(109010);
      return;
    }
    this.xTK = z.bBh();
    this.xNs = new com.tencent.mm.plugin.emoji.g.e(2003);
    paramBundle = getIntent();
    this.xOk = getIntent().getStringExtra("extra_id");
    this.xQc = getIntent().getIntExtra("preceding_scence", -1);
    this.xOl = getIntent().getStringExtra("extra_name");
    this.xSQ = getIntent().getIntExtra("call_by", -1);
    this.xSP = getIntent().getStringExtra("ad_uxInfo");
    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "handleIntent produceId %s, adUxInfo %s", new Object[] { this.xOk, this.xSP });
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.xOk = EmojiLogic.aom((String)localObject);
      this.xQc = 0;
      this.xQc = 10;
      com.tencent.mm.plugin.report.service.h.OAn.b(10993, new Object[] { Integer.valueOf(3), this.xOk });
    }
    if (TextUtils.isEmpty(this.xOk))
    {
      Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.xQc == -1)
    {
      Log.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.xTT = paramBundle.getBooleanExtra("check_clickflag", true);
    this.xTJ = paramBundle.getStringExtra("cdn_client_id");
    this.xTH = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.xTX = paramBundle.getBooleanExtra("from_popup", false);
    this.xTI = paramBundle.getStringExtra("searchID");
    if (this.xTI == null) {
      this.xTI = "";
    }
    this.xNp = Util.nullAs(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.xQC.akki = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.xQC.ZtY = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.xQC.akka = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.xQC.akkc = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.xQC.akkd = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.xQC.akke = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.xQC.Zuw = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.xQC.akkj = ((String)localObject);
    }
    i = paramBundle.getIntExtra("extra_pack_wecoin_price", -1);
    if (i != -1) {
      this.xQC.akkv = i;
    }
    i = paramBundle.getIntExtra("extra_wecoin_price", -1);
    if (i != -1) {
      this.xQC.akkw = i;
    }
    if (this.xTK)
    {
      this.xTL = 11;
      com.tencent.mm.pluginsdk.model.o.a(this, this.xTQ, this.xUg);
    }
    this.xSS = paramBundle.getBooleanExtra("reward_tip", false);
    paramBundle = paramBundle.getStringExtra("action_report");
    if (!Util.isNullOrNil(paramBundle)) {
      this.xNu = new bw(paramBundle);
    }
    this.xTQ[0] = this.xOk;
    this.xQC.ProductID = this.xOk;
    this.xQC.Zul = this.xOl;
    this.xQC.akkp = this.xSR;
    this.xQC.akkj = "-1";
    this.xQC.crz = -1;
    this.mContext = this;
    xUe.eIW = new WeakReference(this);
    initView();
    if (!com.tencent.mm.plugin.emoji.g.c.apa(this.xOk)) {
      if (this.xQC == null)
      {
        this.xSV = new m(this.xOk, this.xQc);
        com.tencent.mm.kernel.h.baD().mCm.a(this.xSV, 0);
        if ((this.xSQ == -1) || (this.xSQ == 3))
        {
          this.xTc.setVisibility(8);
          this.bEx.setVisibility(8);
          getString(h.h.app_tip);
          this.pNH = com.tencent.mm.ui.base.k.a(this, getString(h.h.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(176184);
              com.tencent.mm.kernel.h.baD().mCm.a(EmojiStoreDetailUI.o(EmojiStoreDetailUI.this));
              EmojiStoreDetailUI.p(EmojiStoreDetailUI.this).setText(h.h.emoji_store_load_failed_network);
              EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
              AppMethodBeat.o(176184);
            }
          });
        }
        dBH();
        if (!this.xTT) {
          break label1196;
        }
        paramBundle = new com.tencent.mm.plugin.emoji.e.l(this.xOk);
        com.tencent.mm.kernel.h.baD().mCm.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      dBK();
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.add(this);
      this.xQg.alive();
      com.tencent.mm.kernel.h.baD().mCm.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      k(this.xOk, i, j, this.xTJ);
      this.xTW = true;
      com.tencent.mm.plugin.report.service.h.OAn.b(12740, new Object[] { Integer.valueOf(1), "", this.xOk, "", Integer.valueOf(this.xTH), Integer.valueOf(26) });
      if ((this.xSS) && (this.xTd != null)) {
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
      if ((!Util.isNullOrNil(this.xQD)) && (this.xQD.equalsIgnoreCase(LocaleUtil.getCurrentLanguage(this.mContext))))
      {
        this.xSV = new m(this.xOk, this.xQc, this.xQC.crz);
        break;
      }
      this.xSV = new m(this.xOk, this.xQc);
      break;
      label1196:
      this.xTV = true;
      this.xTU = EmojiLogic.dzM();
      continue;
      paramBundle = getContext();
      localObject = new aoi();
      ((aoi)localObject).ProductID = EmojiGroupInfo.aklD;
      ((aoi)localObject).Zul = paramBundle.getString(h.h.emoji_store_tuzi_title);
      ((aoi)localObject).akka = paramBundle.getString(h.h.emoji_store_tuzi_desc);
      ((aoi)localObject).akkb = paramBundle.getString(h.h.emoji_store_tuzi_auth);
      ((aoi)localObject).akkc = "";
      ((aoi)localObject).akkd = 0;
      ((aoi)localObject).akke = 1;
      ((aoi)localObject).ZtY = "";
      ((aoi)localObject).akkh = 0;
      ((aoi)localObject).akki = paramBundle.getString(h.h.emoji_store_tuzi_copyright);
      ((aoi)localObject).akkk = "";
      ((aoi)localObject).akkj = "";
      ((aoi)localObject).Zuw = "";
      ((aoi)localObject).akko = paramBundle.getString(h.h.emoji_store_tuzi_timelimitStr);
      this.xQC = ((aoi)localObject);
      this.xTV = true;
      this.xTU = EmojiLogic.dzM();
      dBJ();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109016);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.remove(this);
    this.xQg.dead();
    com.tencent.mm.kernel.h.baD().mCm.b(822, this);
    if (this.xTk != null) {
      this.xTk.jMM();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.xTZ != null)
    {
      this.xTZ.bMH();
      this.xTZ = null;
    }
    AppMethodBeat.o(109016);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(109024);
    Ks(1001);
    AppMethodBeat.o(109024);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109014);
    super.onPause();
    com.tencent.mm.kernel.h.baD().mCm.b(412, this);
    com.tencent.mm.kernel.h.baD().mCm.b(521, this);
    com.tencent.mm.kernel.h.baD().mCm.b(423, this);
    com.tencent.mm.kernel.h.baD().mCm.b(413, this);
    AppMethodBeat.o(109014);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109018);
    this.xSU = paramBundle.getInt("status");
    this.boE = paramBundle.getInt("progress");
    AppMethodBeat.o(109018);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109013);
    super.onResume();
    com.tencent.mm.kernel.h.baD().mCm.a(412, this);
    com.tencent.mm.kernel.h.baD().mCm.a(521, this);
    com.tencent.mm.kernel.h.baD().mCm.a(423, this);
    com.tencent.mm.kernel.h.baD().mCm.a(413, this);
    this.xTR = false;
    if (!this.xTW)
    {
      dBH();
      Ks(1007);
    }
    dBI();
    this.xTW = false;
    Ks(1001);
    AppMethodBeat.o(109013);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109017);
    paramBundle.putInt("status", this.xSU);
    paramBundle.putInt("progress", this.boE);
    AppMethodBeat.o(109017);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(109020);
    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109020);
      return;
      if ((paramp instanceof m))
      {
        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
        paramString = (m)paramp;
        if ((paramString != null) && (!Util.isNullOrNil(paramString.xOk)) && (paramString.xOk.equalsIgnoreCase(this.xOk)))
        {
          if (paramInt1 == 0)
          {
            if (paramInt2 == 0)
            {
              this.xQC = paramString.dAD();
              paramString = this.xSY;
              if ((this.xQC == null) || (paramString.xUh.xQC.akkn == null)) {}
              for (;;)
              {
                Ks(1002);
                AppMethodBeat.o(109020);
                return;
                paramString.mip.clear();
                paramp = paramString.xUh.xQC.akkn.iterator();
                while (paramp.hasNext())
                {
                  goj localgoj = (goj)paramp.next();
                  EmojiInfo localEmojiInfo = new EmojiInfo();
                  localEmojiInfo.field_md5 = localgoj.Md5;
                  localEmojiInfo.field_thumbUrl = localgoj.ThumbUrl;
                  localEmojiInfo.field_cdnUrl = localgoj.aklk;
                  localEmojiInfo.field_aeskey = localgoj.AesKey;
                  localEmojiInfo.field_encrypturl = localgoj.EncryptUrl;
                  localEmojiInfo.field_externUrl = localgoj.ExternUrl;
                  localEmojiInfo.field_externMd5 = localgoj.ExternMd5;
                  localEmojiInfo.field_activityid = localgoj.ActivityID;
                  localEmojiInfo.field_groupId = paramString.xUh.xOk;
                  localEmojiInfo.field_catalog = 84;
                  localEmojiInfo.field_reserved4 |= EmojiInfo.akmb;
                  paramString.mip.add(localEmojiInfo);
                }
                paramString.notifyDataSetChanged();
              }
            }
            if (paramInt2 == 1)
            {
              dBF();
              AppMethodBeat.o(109020);
              return;
            }
            this.xTb.setText(h.h.emoji_store_load_failed);
            dBG();
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 5)
          {
            if ((paramString != null) && (paramString.dAD() != null)) {
              this.xQC.akke = paramString.dAD().akke;
            }
            Ks(1002);
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 1)
          {
            dBF();
            AppMethodBeat.o(109020);
            return;
          }
          this.xTd.setVisibility(8);
          this.bEx.setVisibility(0);
          this.xTb.setText(h.h.emoji_store_load_failed_network);
          dBG();
          AppMethodBeat.o(109020);
          return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
        AppMethodBeat.o(109020);
        return;
        if ((paramp instanceof com.tencent.mm.plugin.emoji.e.h))
        {
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
          paramString = (com.tencent.mm.plugin.emoji.e.h)paramp;
          if ((paramString == this.xSW) && (!Util.isNullOrNil(paramString.xOk)) && (paramString.xOk.equalsIgnoreCase(this.xOk)))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.xTJ = paramString.oHX;
              this.xSU = 6;
              dBP();
              AppMethodBeat.o(109020);
              return;
            }
            this.xSU = -1;
            dBP();
            paramString = this.xOl;
            com.tencent.mm.ui.base.k.a(this, String.format(getString(h.h.emoji_store_download_failed_msg), new Object[] { paramString }), "", new DialogInterface.OnClickListener()new EmojiStoreDetailUI.10
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(176188);
                EmojiStoreDetailUI.y(EmojiStoreDetailUI.this);
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
          paramString = (com.tencent.mm.plugin.emoji.e.l)paramp;
          if ((paramString != null) && (!Util.isNullOrNil(paramString.xNX)) && (paramString.xNX.equalsIgnoreCase(this.xOk))) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.xTU = ((ciw)c.c.b(paramString.rr.otC));
              this.xTV = true;
              aNe();
            }
          }
          for (;;)
          {
            this.xTV = true;
            aNe();
            AppMethodBeat.o(109020);
            return;
            this.xTU = null;
            break;
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          }
          if ((paramp instanceof com.tencent.mm.plugin.emoji.e.p))
          {
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.xSZ = ((com.tencent.mm.plugin.emoji.e.p)paramp).dAH();
              Ks(1007);
              AppMethodBeat.o(109020);
              return;
              if (this.xTY != null)
              {
                this.xTY.dismiss();
                this.xTY = null;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.byT(((com.tencent.mm.plugin.emoji.e.s)paramp).xOk);
                this.xSU = 3;
                dBP();
                AppMethodBeat.o(109020);
                return;
              }
              com.tencent.mm.ui.base.k.b(getContext(), getContext().getString(a.j.emoji_top_failed), "", "", getContext().getString(a.j.app_i_known), null, null);
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(270664);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.emoji.b.b.class);
    AppMethodBeat.o(270664);
  }
  
  final class a
    extends BaseAdapter
    implements com.tencent.mm.view.a.a
  {
    final List<EmojiInfo> mip;
    
    public a()
    {
      AppMethodBeat.i(270745);
      this.mip = new ArrayList();
      AppMethodBeat.o(270745);
    }
    
    public final boolean dBU()
    {
      return true;
    }
    
    public final boolean dBV()
    {
      return false;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109000);
      int i = this.mip.size();
      AppMethodBeat.o(109000);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(109001);
      Object localObject = this.mip.get(paramInt);
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
        paramView = LayoutInflater.from(EmojiStoreDetailUI.w(EmojiStoreDetailUI.this)).inflate(h.f.emoji_store_detail_grid_item, null);
        paramViewGroup = new EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramView);
        paramView.setTag(paramViewGroup);
        if (!EmojiStoreDetailUI.x(EmojiStoreDetailUI.this).agKm) {
          break label177;
        }
        paramViewGroup.xUi.setBackgroundResource(h.d.smiley_item_bg2);
      }
      for (;;)
      {
        Object localObject1 = getItem(paramInt);
        if ((localObject1 instanceof EmojiInfo))
        {
          Object localObject2 = com.tencent.mm.emoji.b.e.mgl;
          localObject1 = (EmojiInfo)localObject1;
          localObject2 = paramViewGroup.xUi;
          kotlin.g.b.s.u(localObject1, "emojiInfo");
          kotlin.g.b.s.u(localObject2, "view");
          com.tencent.mm.emoji.b.e.a((EmojiInfo)localObject1, (ImageView)localObject2);
          paramViewGroup.xUi.setContentDescription(String.format(MMApplicationContext.getString(h.h.emoji_display_index), new Object[] { Integer.valueOf(paramInt + 1) }));
        }
        AppMethodBeat.o(109002);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.b)paramView.getTag();
        break;
        label177:
        paramViewGroup.xUi.setBackgroundDrawable(null);
      }
    }
  }
  
  final class b
  {
    SquareImageView xUi;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109008);
      this.xUi = ((SquareImageView)paramView.findViewById(h.e.detail_image));
      this.xUi.setScaleType(ImageView.ScaleType.FIT_CENTER);
      AppMethodBeat.o(109008);
    }
  }
  
  static final class c
    implements com.tencent.mm.modelimage.loader.b.k
  {
    WeakReference<EmojiStoreDetailUI> eIW;
    
    public final void onImageLoadComplete(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(176195);
      Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[] { paramString });
      if (this.eIW == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      paramString = (EmojiStoreDetailUI)this.eIW.get();
      if (paramString == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      if (paramBitmap != null) {
        paramString.Ks(1006);
      }
      AppMethodBeat.o(176195);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */