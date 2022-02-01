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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.PackThumbExt;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.SmileySubGrid;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.al.g, k.a
{
  private static d oDN;
  private View DR;
  private int EI;
  private ProgressDialog ift;
  private Context mContext;
  private ap mHandler;
  private int mNumColumns;
  private int mPadding;
  private EmotionDetail oAJ;
  private String oAK;
  private int oAr;
  private com.tencent.mm.sdk.b.c oAv;
  private int oCF;
  private String oCG;
  private boolean oCH;
  private boolean oCI;
  private int oCJ;
  private com.tencent.mm.plugin.emoji.f.l oCK;
  private com.tencent.mm.plugin.emoji.f.g oCL;
  private com.tencent.mm.plugin.emoji.f.o oCM;
  private a oCN;
  private GetEmotionRewardResponse oCO;
  private boolean oCP;
  private TextView oCQ;
  private View oCR;
  private EmojiDetailScrollView oCS;
  private BannerEmojiView oCT;
  private TextView oCU;
  private MMAutoSizeTextView oCV;
  private TextView oCW;
  private TextView oCX;
  private TextView oCY;
  private EmojiDetailGridView oCZ;
  private String[] oDA;
  private boolean oDB;
  private View oDC;
  private boolean oDD;
  private atl oDE;
  private boolean oDF;
  private boolean oDG;
  private boolean oDH;
  private com.tencent.mm.ui.base.p oDI;
  private View.OnClickListener oDJ;
  private View.OnClickListener oDK;
  private View.OnClickListener oDL;
  private View.OnClickListener oDM;
  private com.tencent.mm.aw.a.c.l oDO;
  private j.a oDP;
  private ImageView oDa;
  private View oDb;
  private TextView oDc;
  private TextView oDd;
  private int oDe;
  private View oDf;
  private ProgressBar oDg;
  private View oDh;
  private ImageView oDi;
  private TextView oDj;
  private View oDk;
  private View oDl;
  private TextView oDm;
  private Button oDn;
  private DonorsAvatarView oDo;
  private TextView oDp;
  private int oDq;
  private int oDr;
  private int oDs;
  private String oDt;
  private boolean oDu;
  private int oDv;
  private int oDw;
  private String oDx;
  private String oDy;
  private String oDz;
  private ProgressBar otw;
  private long oxB;
  private String oxC;
  private com.tencent.mm.plugin.emoji.h.c oxF;
  private com.tencent.mm.g.b.a.u oxH;
  private String oyw;
  private String oyx;
  private String oyy;
  
  static
  {
    AppMethodBeat.i(176199);
    oDN = new d((byte)0);
    AppMethodBeat.o(176199);
  }
  
  public EmojiStoreDetailUI()
  {
    AppMethodBeat.i(109009);
    this.oCI = false;
    this.oCJ = -1;
    this.oAJ = new EmotionDetail();
    this.oAK = "";
    this.oCO = null;
    this.oxB = 0L;
    this.oxC = "";
    this.oDw = -1;
    this.oDA = new String[1];
    this.oDB = false;
    this.oDD = true;
    this.oDF = false;
    this.oDG = true;
    this.oDH = false;
    this.oAv = new com.tencent.mm.sdk.b.c() {};
    this.oDJ = new EmojiStoreDetailUI.12(this);
    this.oDK = new EmojiStoreDetailUI.15(this);
    this.oDL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108994);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackName);
        if ((EmojiStoreDetailUI.b(EmojiStoreDetailUI.this) != null) && (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner != null)) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
        }
        ((Intent)localObject).putExtra("scene", EmojiStoreDetailUI.c(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("pageType", 1);
        ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.vKh.f(12738, new Object[] { EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(EmojiStoreDetailUI.this)), Integer.valueOf(0) });
        AppMethodBeat.o(108994);
      }
    };
    this.oDM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108995);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_iconurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).IconUrl);
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackName);
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner != null) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
        }
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108995);
      }
    };
    this.mHandler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108996);
        switch (paramAnonymousMessage.what)
        {
        default: 
          ad.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
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
        EmojiStoreDetailUI.this.bWv();
        AppMethodBeat.o(108996);
      }
    };
    this.oDO = new com.tencent.mm.aw.a.c.l()
    {
      public final void mw(long paramAnonymousLong)
      {
        AppMethodBeat.i(176192);
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10930, EmojiStoreDetailUI.a(EmojiStoreDetailUI.this) + "," + paramAnonymousLong);
        AppMethodBeat.o(176192);
      }
    };
    this.oDP = new j.a()
    {
      public final void M(ArrayList<com.tencent.mm.pluginsdk.model.p> paramAnonymousArrayList)
      {
        AppMethodBeat.i(176191);
        int i;
        if (paramAnonymousArrayList == null)
        {
          i = 0;
          ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish] %s", new Object[] { Integer.valueOf(i) });
          EmojiStoreDetailUI.B(EmojiStoreDetailUI.this);
          if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
          {
            paramAnonymousArrayList = (com.tencent.mm.pluginsdk.model.p)paramAnonymousArrayList.get(0);
            ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", new Object[] { paramAnonymousArrayList });
            if (paramAnonymousArrayList.BPd != 10232) {
              break label175;
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 4);
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousArrayList.BPa);
            EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.BPb);
            paramAnonymousArrayList = new BigDecimal(paramAnonymousArrayList.BPc).divide(new BigDecimal(1000000));
            EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramAnonymousArrayList.toString());
          }
        }
        for (;;)
        {
          EmojiStoreDetailUI.this.AD(1002);
          AppMethodBeat.o(176191);
          return;
          i = paramAnonymousArrayList.size();
          break;
          label175:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 10);
          EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.BPd);
        }
      }
    };
    AppMethodBeat.o(109009);
  }
  
  private void Ua(String paramString)
  {
    AppMethodBeat.i(109025);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758285);
    }
    com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109025);
  }
  
  private void bWA()
  {
    AppMethodBeat.i(109037);
    if ((!com.tencent.mm.plugin.emoji.h.a.Up(this.oyw)) && ((this.oAJ.ThumbExtList == null) || (this.oAJ.ThumbExtList.size() <= 0) || (((PackThumbExt)this.oAJ.ThumbExtList.get(0)).PreviewUrl == null))) {
      this.oDC.setVisibility(8);
    }
    for (;;)
    {
      this.oCZ.setProductId(this.oyw);
      if (this.oCN != null) {
        this.oCN.notifyDataSetInvalidated();
      }
      AppMethodBeat.o(109037);
      return;
      this.oDC.setVisibility(0);
    }
  }
  
  private void bWB()
  {
    AppMethodBeat.i(109038);
    ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.oAJ.PackFlag });
    if ((this.oAJ.PackFlag & 0x10) == 16) {
      addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(176186);
          ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
          EmojiStoreDetailUI.r(EmojiStoreDetailUI.this);
          AppMethodBeat.o(176186);
          return true;
        }
      });
    }
    AppMethodBeat.o(109038);
  }
  
  private void bWC()
  {
    AppMethodBeat.i(109039);
    com.tencent.mm.ui.base.h.b(this, 2131758311, 0, 2131758376, 2131758314, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176187);
        if (com.tencent.mm.plugin.emoji.h.a.Up(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this)))
        {
          ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
          com.tencent.mm.plugin.emoji.f.a.bVg().bVi();
          if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this)))
          {
            com.tencent.mm.ao.f.awL().xL(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
            ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(EmojiStoreDetailUI.this) });
          }
          if ((!com.tencent.mm.plugin.emoji.a.a.e.fd(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackFlag, 1)) && (!com.tencent.mm.plugin.emoji.a.a.e.Ay(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackType))) {
            break label262;
          }
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 3);
        }
        for (;;)
        {
          com.tencent.mm.plugin.emoji.model.k.bVe().g(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.u(EmojiStoreDetailUI.this), 0, EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
          EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(8);
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(0);
          EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(4);
          EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(0);
          EmojiStoreDetailUI.v(EmojiStoreDetailUI.this);
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          paramAnonymousDialogInterface = new com.tencent.mm.plugin.emoji.f.q(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), 2);
          com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(176187);
          return;
          com.tencent.mm.kernel.g.afA().gcy.a(EmojiStoreDetailUI.s(EmojiStoreDetailUI.this));
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
  
  private void bWD()
  {
    AppMethodBeat.i(109041);
    if (com.tencent.mm.plugin.emoji.h.a.Up(this.oyw))
    {
      com.tencent.mm.plugin.emoji.f.a.bVg();
      com.tencent.mm.plugin.emoji.f.a.bVh();
      AppMethodBeat.o(109041);
      return;
    }
    this.oCL = new com.tencent.mm.plugin.emoji.f.g(this.oyw, this.oyy, this.oyx);
    com.tencent.mm.kernel.g.afA().gcy.a(this.oCL, 0);
    switch (this.oAr)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.f(11598, new Object[] { Integer.valueOf(1), this.oyw });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.f(11598, new Object[] { Integer.valueOf(3), this.oyw });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.f(11598, new Object[] { Integer.valueOf(2), this.oyw });
    }
  }
  
  private void bWo()
  {
    AppMethodBeat.i(109021);
    this.DR.setVisibility(0);
    this.oCR.setVisibility(8);
    this.oCS.setVisibility(8);
    this.oCQ.setText(2131758269);
    AppMethodBeat.o(109021);
  }
  
  private void bWp()
  {
    AppMethodBeat.i(109022);
    ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.oAJ == null) || (this.oAJ.PackFlag == 0))
    {
      this.DR.setVisibility(0);
      this.oCR.setVisibility(8);
    }
    AppMethodBeat.o(109022);
  }
  
  private void bWq()
  {
    AppMethodBeat.i(109026);
    this.oCO = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzd.aJF(this.oyw);
    AppMethodBeat.o(109026);
  }
  
  private void bWr()
  {
    AppMethodBeat.i(109027);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackFlag, 64)) && (com.tencent.mm.emoji.a.l.abq()))
    {
      this.oCM = new com.tencent.mm.plugin.emoji.f.o(this.oyw, com.tencent.mm.plugin.emoji.f.o.oyW);
      com.tencent.mm.kernel.g.afA().gcy.a(this.oCM, 0);
    }
    AppMethodBeat.o(109027);
  }
  
  private boolean bWs()
  {
    AppMethodBeat.i(109028);
    boolean bool = com.tencent.mm.plugin.emoji.h.a.bWs();
    this.oCP = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.oCJ = i;
      AppMethodBeat.o(109028);
      return bool;
    }
  }
  
  private void bWt()
  {
    AppMethodBeat.i(109029);
    if (!bt.isNullOrNil(this.oAJ.PackName))
    {
      setMMTitle(this.oAJ.PackName);
      this.oyx = this.oAJ.PackName;
    }
    ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.oAJ.PanelUrl });
    this.oCR.setVisibility(0);
    this.DR.setVisibility(8);
    jE(true);
    this.oCV.setText(this.oAJ.PackName);
    this.oCW.setText(this.oAJ.PackCopyright);
    this.oCY.setText(this.oAJ.PackDesc);
    if (com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackType, 1)) {
      this.oCU.setVisibility(8);
    }
    for (;;)
    {
      bWx();
      bWy();
      bWz();
      bWA();
      bWB();
      this.oCV.setMaxWidth(this.oDe - this.oDf.getWidth() - com.tencent.mm.cd.a.ao(getContext(), 2131165516) * 2 - this.oCU.getWidth() - com.tencent.mm.cd.a.ao(getContext(), 2131165489) * 2);
      this.oCV.setVisibility(8);
      this.oCV.setVisibility(0);
      bWu();
      bWw();
      bWv();
      AppMethodBeat.o(109029);
      return;
      this.oCU.setVisibility(0);
      this.oCU.setText(2131758411);
    }
  }
  
  private void bWu()
  {
    AppMethodBeat.i(109031);
    if ((this.oAJ.PersonalDesigner != null) && (this.oAJ.PersonalDesigner.DesignerUin != 0) && (this.oDs != 6))
    {
      this.oDk.setVisibility(0);
      this.oDh.setVisibility(0);
      com.tencent.mm.aw.o.ayJ().a(this.oAJ.PersonalDesigner.HeadUrl, this.oDi, com.tencent.mm.plugin.emoji.e.e.eY(this.oyw, this.oAJ.PersonalDesigner.HeadUrl));
      this.oDj.setText(this.oAJ.PersonalDesigner.Name);
      this.oDh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176185);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(EmojiStoreDetailUI.this.getContext(), EmojiStoreV2DesignerUI.class);
          ((Intent)localObject).putExtra("uin", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.DesignerUin);
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
          ((Intent)localObject).putExtra("headurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.HeadUrl);
          ((Intent)localObject).putExtra("rediret_url", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).OldRedirectUrl);
          ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
          ((Intent)localObject).putExtra("extra_scence", 26);
          paramAnonymousView = EmojiStoreDetailUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(176185);
        }
      });
      AppMethodBeat.o(109031);
      return;
    }
    this.oDk.setVisibility(8);
    this.oDh.setVisibility(8);
    AppMethodBeat.o(109031);
  }
  
  private void bWw()
  {
    AppMethodBeat.i(109033);
    if ((this.oAJ.PackFlag & 0x20) == 32)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)this.oDd.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.oDc.getLayoutParams();
      this.oDd.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.cd.a.ao(getContext(), 2131165516);
      this.oDd.setLayoutParams(localLayoutParams1);
      this.oDd.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.cd.a.ao(getContext(), 2131165516);
      this.oDc.setLayoutParams(localLayoutParams2);
      this.oDc.setGravity(5);
      AppMethodBeat.o(109033);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.oDc.getLayoutParams();
    localLayoutParams1.gravity = 17;
    this.oDc.setLayoutParams(localLayoutParams1);
    this.oDc.setGravity(17);
    this.oDd.setVisibility(8);
    AppMethodBeat.o(109033);
  }
  
  private void bWx()
  {
    AppMethodBeat.i(109034);
    if (com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackType, 8))
    {
      this.oDr = 0;
      ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.oAJ.PackFlag) });
      if ((!com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackFlag, 8)) || (!com.tencent.mm.plugin.emoji.a.a.e.Ay(this.oAJ.PackType))) {
        break label164;
      }
      this.oCJ = 8;
    }
    for (;;)
    {
      if (this.oCP) {
        this.oCJ = 7;
      }
      AppMethodBeat.o(109034);
      return;
      if (com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackType, 4))
      {
        this.oDr = 0;
        break;
      }
      if ((!this.oDu) && (TextUtils.isEmpty(this.oAJ.PackPrice)))
      {
        this.oDr = 0;
        break;
      }
      this.oDr = 1;
      break;
      label164:
      if ((com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackFlag, 1)) || (com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackType, 8))) {
        this.oCJ = 3;
      } else if (com.tencent.mm.plugin.emoji.a.a.e.Ay(this.oAJ.PackType)) {
        this.oCJ = 0;
      } else if ((!this.oDu) && ((TextUtils.isEmpty(this.oAJ.PriceNum)) || (this.oAJ.PriceNum.equals("0")))) {
        this.oCJ = 0;
      } else if (this.oDu)
      {
        if (TextUtils.isEmpty(this.oDx)) {
          this.oCJ = this.oDv;
        } else {
          this.oCJ = 4;
        }
      }
      else {
        this.oCJ = 4;
      }
    }
  }
  
  private void bWy()
  {
    AppMethodBeat.i(109035);
    if (com.tencent.mm.plugin.emoji.h.a.Up(this.oyw)) {
      bWs();
    }
    switch (this.oCJ)
    {
    case 1: 
    case 2: 
    case 9: 
    default: 
      ad.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.oCJ) });
    }
    for (;;)
    {
      bWz();
      AppMethodBeat.o(109035);
      return;
      this.oDg.setVisibility(8);
      this.oCX.setTextColor(getResources().getColorStateList(2131100272));
      this.oCX.setBackgroundResource(2131231372);
      this.oCX.setText(2131758322);
      this.oCX.setEnabled(false);
      continue;
      this.oDg.setVisibility(8);
      this.oCX.setTextColor(getResources().getColorStateList(2131101185));
      this.oCX.setBackgroundResource(2131231365);
      this.oCX.setText(2131758319);
      this.oCX.setEnabled(true);
      continue;
      this.oDg.setVisibility(8);
      this.oCX.setTextColor(getResources().getColorStateList(2131101185));
      this.oCX.setBackgroundResource(2131231365);
      this.oCX.setEnabled(true);
      if (this.oDu)
      {
        if (bt.isNullOrNil(this.oDx)) {
          this.oCX.setText("");
        } else {
          this.oCX.setText(this.oDx);
        }
      }
      else
      {
        this.oCX.setText(this.oAJ.PackPrice);
        this.oCJ = 4;
        continue;
        this.oDg.setVisibility(8);
        this.oCX.setTextColor(getResources().getColorStateList(2131101185));
        this.oCX.setBackgroundResource(2131231365);
        this.oCX.setText(2131758319);
        this.oCX.setEnabled(true);
        continue;
        this.oDg.setVisibility(8);
        this.oCX.setEnabled(false);
        this.oDb.setVisibility(0);
        this.oDa.setVisibility(0);
        this.oCX.setVisibility(4);
        if (this.oCF != 3)
        {
          continue;
          this.oDg.setVisibility(8);
          this.oCX.setVisibility(0);
          this.oCX.setEnabled(true);
          if (this.oDH)
          {
            this.oCX.setText(2131758290);
            this.oCX.setTextColor(getResources().getColorStateList(2131100467));
            this.oCX.setBackgroundResource(2131231367);
          }
          for (;;)
          {
            this.oDb.setVisibility(8);
            this.otw.setProgress(0);
            this.oDa.setVisibility(4);
            if (this.oCF == 3) {
              break;
            }
            break;
            this.oCX.setTextColor(getResources().getColorStateList(2131101185));
            this.oCX.setText(2131758388);
            this.oCX.setBackgroundResource(2131231365);
          }
          this.oDg.setVisibility(8);
          this.oCX.setBackgroundResource(2131231365);
          this.oCX.setText(2131758319);
          this.oCX.setEnabled(true);
          this.oDg.setVisibility(0);
          this.oCX.setVisibility(0);
          this.oCX.setBackgroundResource(2131234792);
          this.oCX.setText("");
          this.oCX.setEnabled(false);
          this.oDb.setVisibility(8);
          this.otw.setProgress(0);
          this.oDa.setVisibility(4);
          continue;
          this.oDg.setVisibility(8);
          this.oCX.setVisibility(0);
          this.oCX.setBackgroundResource(2131231365);
          this.oCX.setText(2131758343);
          this.oCX.setEnabled(true);
          this.oDb.setVisibility(8);
          this.otw.setProgress(0);
          this.oDa.setVisibility(4);
          continue;
          bWx();
          bWy();
        }
      }
    }
  }
  
  private void bWz()
  {
    AppMethodBeat.i(109036);
    if ((this.oDF) && ((this.oDE == null) || ((this.oDE.Dtw & 0x1) != 1)) && ((this.oAJ == null) || (!com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackFlag, 1))) && (this.oDE != null) && (!TextUtils.isEmpty(this.oDE.Dtv)))
    {
      this.oCX.setText(this.oDE.Dtv);
      this.oCX.setTextColor(getContext().getResources().getColor(2131100482));
      this.oCX.setBackgroundDrawable(null);
      this.oCX.setEnabled(false);
    }
    AppMethodBeat.o(109036);
  }
  
  private void jE(boolean paramBoolean)
  {
    AppMethodBeat.i(109030);
    Object localObject = null;
    String str;
    if (!bt.isNullOrNil(this.oAJ.CoverUrl))
    {
      if (!paramBoolean) {
        break label104;
      }
      localObject = this.oyw;
      str = this.oAJ.CoverUrl;
      com.tencent.mm.cd.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, oDN);; localObject = EmojiLogic.x((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.oCT != null)) {
        this.oCT.setImageFilePath(((EmojiInfo)localObject).gaa());
      }
      if (com.tencent.mm.plugin.emoji.h.a.Up(this.oyw)) {
        this.oCT.setImageResource(2131234433);
      }
      AppMethodBeat.o(109030);
      return;
      label104:
      localObject = this.oyw;
      str = this.oAJ.CoverUrl;
      com.tencent.mm.cd.a.getDensity(this.mContext);
    }
  }
  
  public final void AD(int paramInt)
  {
    AppMethodBeat.i(109042);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
    AppMethodBeat.o(109042);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(109024);
    AD(1001);
    AppMethodBeat.o(109024);
  }
  
  public final void bWv()
  {
    AppMethodBeat.i(109032);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fd(this.oAJ.PackFlag, 64)) && (com.tencent.mm.emoji.a.l.abq()))
    {
      if (this.oCO != null)
      {
        this.oDl.setVisibility(0);
        this.oDn.setText(2131758352);
        this.oDm.setText(this.oCO.Reward.DdN);
        this.oDm.setLongClickable(false);
        if (this.oCO.DonorNum > 0)
        {
          this.oDp.setVisibility(0);
          String str1 = String.valueOf(this.oCO.DonorNum);
          String str2 = String.format(getString(2131758356), new Object[] { Integer.valueOf(this.oCO.DonorNum) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131100286)), i, str1.length() + i, 33);
          }
          this.oDp.setText(localSpannableString);
        }
        while ((this.oCO.Donors != null) && (this.oCO.Donors.size() > 0))
        {
          this.oDo.setVisibility(0);
          this.oDo.d(this.oyw, this.oCO.Donors);
          AppMethodBeat.o(109032);
          return;
          this.oDp.setVisibility(8);
        }
        this.oDo.setVisibility(8);
        AppMethodBeat.o(109032);
        return;
      }
      this.oDl.setVisibility(8);
      bWr();
      AppMethodBeat.o(109032);
      return;
    }
    this.oDl.setVisibility(8);
    AppMethodBeat.o(109032);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493794;
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(109040);
    ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((bt.isNullOrNil(paramString1)) || (!paramString1.equals(this.oyw)))
    {
      AppMethodBeat.o(109040);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.oDt = paramString2;
    }
    if (paramInt1 == -1)
    {
      if (this.oCJ != -1)
      {
        this.oCJ = -1;
        AD(1003);
        AppMethodBeat.o(109040);
      }
    }
    else
    {
      if (paramInt1 == 7)
      {
        this.oCJ = 7;
        AD(1003);
        AppMethodBeat.o(109040);
        return;
      }
      if (paramInt1 == 6)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.oyw)))
        {
          this.oCJ = 6;
          this.EI = paramInt2;
          AD(1004);
          AppMethodBeat.o(109040);
        }
      }
      else {
        ad.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
      }
    }
    AppMethodBeat.o(109040);
  }
  
  public void initView()
  {
    AppMethodBeat.i(109011);
    if (!bt.isNullOrNil(this.oyx)) {
      setMMTitle(this.oyx);
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
    this.mPadding = com.tencent.mm.cd.a.ao(this.mContext, 2131166211);
    this.oDq = getResources().getDimensionPixelSize(2131166210);
    this.oDq = com.tencent.mm.cd.a.ao(this.mContext, 2131166210);
    this.mNumColumns = 4;
    this.oCS = ((EmojiDetailScrollView)findViewById(2131304379));
    this.DR = findViewById(2131299457);
    this.oCQ = ((TextView)this.DR.findViewById(2131299461));
    this.oCR = findViewById(2131299441);
    this.oCT = ((BannerEmojiView)findViewById(2131299378));
    int i = this.oCT.getRight();
    int j = this.oCT.getLeft();
    int k = this.oCT.getPaddingRight();
    int m = this.oCT.getPaddingLeft();
    this.oCT.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.oCU = ((TextView)findViewById(2131299451));
    this.oCV = ((MMAutoSizeTextView)findViewById(2131299452));
    this.oCW = ((TextView)findViewById(2131299362));
    this.oCX = ((TextView)findViewById(2131299454));
    this.oCY = ((TextView)findViewById(2131299366));
    this.oDe = com.tencent.mm.cd.a.hV(getContext());
    this.oDf = findViewById(2131299330);
    this.oCZ = ((EmojiDetailGridView)findViewById(2131299374));
    ProgressBar localProgressBar;
    if (com.tencent.mm.plugin.emoji.h.a.Up(this.oyw))
    {
      this.oCN = new b();
      this.oDb = findViewById(2131299429);
      this.otw = ((ProgressBar)findViewById(2131299369));
      this.oDa = ((ImageView)findViewById(2131299360));
      this.oDa.setOnClickListener(this);
      this.oDb.setVisibility(8);
      this.oDa.setVisibility(8);
      this.otw.setProgress(0);
      this.oCZ.setAdapter(this.oCN);
      this.oCZ.setColumnWidth(this.oDq);
      this.oCZ.setNumColumns(this.mNumColumns);
      this.oCZ.setHorizontalSpacing(this.mPadding);
      this.oCZ.setVerticalSpacing(this.mPadding);
      this.oCZ.setEmojiDetailScrollView(this.oCS);
      this.oCZ.setFromDetail(true);
      this.oCZ.setIsShowPopWin(true);
      this.oCZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(176183);
          paramAnonymousAdapterView = paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView instanceof EmojiInfo))
          {
            paramAnonymousAdapterView = (EmojiInfo)paramAnonymousAdapterView;
            paramAnonymousView = new act();
            if ((bt.isNullOrNil(paramAnonymousView.Md5)) || (paramAnonymousView.Md5.equals(paramAnonymousAdapterView.field_md5)))
            {
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_md5, paramAnonymousView.Md5);
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousView.Md5, "");
              paramAnonymousView.Url = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_cdnUrl, paramAnonymousView.Url);
              paramAnonymousView.ThumbUrl = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_thumbUrl, paramAnonymousView.ThumbUrl);
              paramAnonymousView.Ddp = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_designerID, paramAnonymousView.Ddp);
              paramAnonymousView.EncryptUrl = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_encrypturl, paramAnonymousView.EncryptUrl);
              paramAnonymousView.AesKey = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_aeskey, paramAnonymousView.AesKey);
              paramAnonymousView.ProductID = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_groupId, paramAnonymousView.ProductID);
              paramAnonymousView.ExternUrl = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_externUrl, paramAnonymousView.ExternUrl);
              paramAnonymousView.ExternMd5 = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_externMd5, paramAnonymousView.ExternMd5);
              paramAnonymousView.ActivityID = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_activityid, paramAnonymousView.ActivityID);
              paramAnonymousView.Ddq = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_attachedText, paramAnonymousView.Ddq);
              paramAnonymousView.Ddr = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_attachTextColor, paramAnonymousView.Ddr);
              paramAnonymousView.Dds = com.tencent.mm.plugin.emoji.h.b.fd(paramAnonymousAdapterView.field_lensId, paramAnonymousView.Dds);
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.vKh.f(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAnonymousAdapterView.field_md5, Long.valueOf(EmojiStoreDetailUI.d(EmojiStoreDetailUI.this)), paramAnonymousAdapterView.field_designerID, paramAnonymousAdapterView.field_groupId, Integer.valueOf(26) });
          }
          AppMethodBeat.o(176183);
        }
      });
      this.oCX.setOnClickListener(this);
      this.oDc = ((TextView)findViewById(2131299433));
      this.oDd = ((TextView)findViewById(2131299361));
      this.oDc.setOnClickListener(this.oDJ);
      this.oDd.setOnClickListener(this.oDK);
      this.oDg = ((ProgressBar)findViewById(2131299372));
      localProgressBar = this.oDg;
      if (!this.oDu) {
        break label767;
      }
    }
    label767:
    for (i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      this.oDC = findViewById(2131299386);
      this.oDk = findViewById(2131299365);
      this.oDh = findViewById(2131299016);
      this.oDi = ((ImageView)findViewById(2131299022));
      this.oDj = ((TextView)findViewById(2131299032));
      this.oDl = findViewById(2131299430);
      this.oDm = ((TextView)findViewById(2131304153));
      this.oDn = ((Button)findViewById(2131304154));
      this.oDp = ((TextView)findViewById(2131304158));
      this.oDo = ((DonorsAvatarView)findViewById(2131304152));
      this.oDn.setOnClickListener(this.oDL);
      this.oDp.setOnClickListener(this.oDM);
      AppMethodBeat.o(109011);
      return;
      this.oCN = new a();
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109023);
    ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str;
    if (paramInt1 == 2001)
    {
      str = "";
      if (paramIntent == null) {
        break label759;
      }
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      ad.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(paramInt1)));
      str = paramIntent.getStringExtra("key_err_msg");
      ad.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str)));
    }
    for (;;)
    {
      this.oDB = false;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localArrayList != null) && (localArrayList.contains(this.oyw)))
          {
            paramInt1 = 0;
            while (paramInt1 < localArrayList.size())
            {
              if (this.oyw.equals(localArrayList.get(paramInt1))) {
                this.oyy = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.oAJ.PackFlag = 1;
            bWD();
            this.oCJ = 6;
            com.tencent.mm.ui.base.h.cf(this, str);
            if (com.tencent.mm.model.u.aqU())
            {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 4L, 1L, false);
              AppMethodBeat.o(109023);
              return;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 0L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          this.oCJ = -1;
          bWy();
          Ua(str);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 100000002))
        {
          bWD();
          this.oCJ = 6;
          this.oCN.notifyDataSetChanged();
          if (com.tencent.mm.model.u.aqU())
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 7L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 3L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 1))
        {
          this.oCJ = -1;
          bWy();
          if (com.tencent.mm.model.u.aqU())
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 6L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 2L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        this.oCJ = -1;
        bWy();
        Ua(str);
        if (com.tencent.mm.model.u.aqU())
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 5L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 1L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      this.oCJ = -1;
      bWy();
      if (com.tencent.mm.model.u.aqU())
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 6L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 2L, 1L, false);
      AppMethodBeat.o(109023);
      return;
      if (paramInt1 == 2002)
      {
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          if (!bt.isNullOrNil(paramIntent))
          {
            ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(paramIntent)));
            com.tencent.mm.plugin.emoji.e.j.a(this, paramIntent, this.oyw, this.oAJ.PackName, this.oAJ.PackDesc, this.oAJ.IconUrl, this.oAJ.OldRedirectUrl, this.oAJ.PackFlag);
          }
          AppMethodBeat.o(109023);
        }
      }
      else if (paramInt1 == this.oxF.lzE)
      {
        if (paramInt2 == -1)
        {
          ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
          com.tencent.mm.plugin.emoji.h.c.a(paramIntent, this.oyw, this);
          com.tencent.mm.plugin.report.service.h.vKh.f(12069, new Object[] { Integer.valueOf(3), this.oyw });
          AppMethodBeat.o(109023);
        }
      }
      else if ((paramInt1 == 2004) && (paramInt2 == -1)) {
        com.tencent.mm.ui.widget.snackbar.b.n(this, getContext().getString(2131755887));
      }
      AppMethodBeat.o(109023);
      return;
      label759:
      paramInt1 = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109019);
    int i = paramView.getId();
    if (i == 2131299454)
    {
      if (this.oCJ == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if (this.oDH)
        {
          paramView = new com.tencent.mm.plugin.emoji.f.q(this.oyw, 2);
          com.tencent.mm.kernel.g.afA().gcy.a(paramView, 0);
          this.oDI = com.tencent.mm.ui.base.p.a(this, getString(2131760706), true, 0, null);
        }
        for (;;)
        {
          ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(11076, "0, ");
          AppMethodBeat.o(109019);
          return;
          if ((!bt.isNullOrNil(paramView)) && (this.oCI))
          {
            com.tencent.mm.plugin.emoji.h.c.a(paramView, this.oyw, this);
          }
          else
          {
            this.oxF.O(this);
            com.tencent.mm.plugin.report.service.h.vKh.f(12069, new Object[] { Integer.valueOf(2), this.oyw });
          }
        }
      }
      switch (this.oCJ)
      {
      case 1: 
      case 2: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        ad.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.oCJ) });
      case 4: 
      case 0: 
      case 3: 
        do
        {
          do
          {
            AppMethodBeat.o(109019);
            return;
          } while (this.oDB);
          if (this.oDH)
          {
            paramView = com.tencent.mm.emoji.b.d.fRi;
            com.tencent.mm.emoji.b.d.lI(6);
          }
          ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.oyw, this.oAJ.PackPrice, this.oAJ.PriceType });
          paramView = new Intent();
          paramView.putExtra("key_product_id", this.oyw);
          if (this.oDu)
          {
            paramView.putExtra("key_currency_type", this.oDy);
            paramView.putExtra("key_price", this.oDy + this.oDz);
          }
          for (;;)
          {
            com.tencent.mm.bs.d.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
            com.tencent.mm.plugin.report.service.h.vKh.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.oDs), "", this.oyw, Long.valueOf(this.oxB), this.oxC });
            this.oDB = true;
            AppMethodBeat.o(109019);
            return;
            paramView.putExtra("key_currency_type", this.oAJ.PriceType);
            paramView.putExtra("key_price", this.oAJ.PriceNum);
          }
          if (this.oDH)
          {
            paramView = com.tencent.mm.emoji.b.d.fRi;
            com.tencent.mm.emoji.b.d.lI(6);
          }
          bWD();
          this.oCJ = 6;
          bWy();
          com.tencent.mm.plugin.report.service.h.vKh.f(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.oDs), "", this.oyw, Long.valueOf(this.oxB), this.oxC });
        } while (this.oxH == null);
        this.oxH.dJy = 4;
        this.oxH.aBj();
        AppMethodBeat.o(109019);
        return;
      case 5: 
        this.oCJ = 3;
        bWy();
        AppMethodBeat.o(109019);
        return;
      case 10: 
      case 12: 
        switch (this.oDw)
        {
        default: 
          paramView = getString(2131758412);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.c(this, paramView, null, true);
          AppMethodBeat.o(109019);
          return;
          paramView = getString(2131758261);
          continue;
          paramView = getString(2131758270);
          continue;
          paramView = getString(2131758407);
        }
      case 11: 
        ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
        AppMethodBeat.o(109019);
        return;
      }
      ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
      AppMethodBeat.o(109019);
      return;
    }
    if (i == 2131299369)
    {
      bWC();
      AppMethodBeat.o(109019);
      return;
    }
    if (i == 2131299360)
    {
      bWC();
      AppMethodBeat.o(109019);
      return;
    }
    ad.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
    AppMethodBeat.o(109019);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109010);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.afw())
    {
      finish();
      AppMethodBeat.o(109010);
      return;
    }
    this.oDu = com.tencent.mm.model.u.aqU();
    this.oxF = new com.tencent.mm.plugin.emoji.h.c(2003);
    paramBundle = getIntent();
    this.oyw = getIntent().getStringExtra("extra_id");
    this.oAr = getIntent().getIntExtra("preceding_scence", -1);
    this.oyx = getIntent().getStringExtra("extra_name");
    this.oCF = getIntent().getIntExtra("call_by", -1);
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.oyw = EmojiLogic.TH((String)localObject);
      this.oAr = 0;
      this.oAr = 10;
      com.tencent.mm.plugin.report.service.h.vKh.f(10993, new Object[] { Integer.valueOf(3), this.oyw });
    }
    if (TextUtils.isEmpty(this.oyw))
    {
      ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.oAr == -1)
    {
      ad.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.oDD = paramBundle.getBooleanExtra("check_clickflag", true);
    this.oDt = paramBundle.getStringExtra("cdn_client_id");
    this.oDs = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.oDH = paramBundle.getBooleanExtra("from_popup", false);
    this.oxB = paramBundle.getLongExtra("searchID", 0L);
    this.oxC = bt.by(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.oAJ.PackCopyright = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.oAJ.CoverUrl = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.oAJ.PackDesc = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.oAJ.PackPrice = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.oAJ.PackType = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.oAJ.PackFlag = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.oAJ.PriceType = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.oAJ.PriceNum = ((String)localObject);
    }
    if (this.oDu)
    {
      this.oDv = 11;
      com.tencent.mm.pluginsdk.model.j.a(this, this.oDA, this.oDP);
    }
    this.oCH = paramBundle.getBooleanExtra("reward_tip", false);
    paramBundle = paramBundle.getStringExtra("action_report");
    if (!bt.isNullOrNil(paramBundle)) {
      this.oxH = new com.tencent.mm.g.b.a.u(paramBundle);
    }
    this.oDA[0] = this.oyw;
    this.oAJ.ProductID = this.oyw;
    this.oAJ.PackName = this.oyx;
    this.oAJ.ShareDesc = this.oCG;
    this.oAJ.PriceNum = "-1";
    this.oAJ.Version = -1;
    this.mContext = this;
    oDN.cqo = new WeakReference(this);
    initView();
    if (!com.tencent.mm.plugin.emoji.h.a.Up(this.oyw)) {
      if (this.oAJ == null)
      {
        this.oCK = new com.tencent.mm.plugin.emoji.f.l(this.oyw, this.oAr);
        com.tencent.mm.kernel.g.afA().gcy.a(this.oCK, 0);
        if ((this.oCF == -1) || (this.oCF == 3))
        {
          this.oCR.setVisibility(8);
          this.DR.setVisibility(8);
          getString(2131755906);
          this.ift = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(176184);
              com.tencent.mm.kernel.g.afA().gcy.a(EmojiStoreDetailUI.o(EmojiStoreDetailUI.this));
              EmojiStoreDetailUI.p(EmojiStoreDetailUI.this).setText(2131758331);
              EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
              AppMethodBeat.o(176184);
            }
          });
        }
        bWq();
        if (!this.oDD) {
          break label1051;
        }
        paramBundle = new com.tencent.mm.plugin.emoji.f.k(this.oyw);
        com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      bWt();
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.add(this);
      com.tencent.mm.sdk.b.a.ESL.c(this.oAv);
      com.tencent.mm.kernel.g.afA().gcy.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      h(this.oyw, i, j, this.oDt);
      this.oDG = true;
      com.tencent.mm.plugin.report.service.h.vKh.f(12740, new Object[] { Integer.valueOf(1), "", this.oyw, "", Integer.valueOf(this.oDs), Integer.valueOf(26) });
      if ((this.oCH) && (this.oCS != null)) {
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
      if ((!bt.isNullOrNil(this.oAK)) && (this.oAK.equalsIgnoreCase(ac.ir(this.mContext))))
      {
        this.oCK = new com.tencent.mm.plugin.emoji.f.l(this.oyw, this.oAr, this.oAJ.Version);
        break;
      }
      this.oCK = new com.tencent.mm.plugin.emoji.f.l(this.oyw, this.oAr);
      break;
      label1051:
      this.oDF = true;
      this.oDE = EmojiLogic.bUQ();
      continue;
      paramBundle = getContext();
      localObject = new EmotionDetail();
      ((EmotionDetail)localObject).ProductID = EmojiGroupInfo.LBN;
      ((EmotionDetail)localObject).PackName = paramBundle.getString(2131758385);
      ((EmotionDetail)localObject).PackDesc = paramBundle.getString(2131758383);
      ((EmotionDetail)localObject).PackAuthInfo = paramBundle.getString(2131758381);
      ((EmotionDetail)localObject).PackPrice = "";
      ((EmotionDetail)localObject).PackType = 0;
      ((EmotionDetail)localObject).PackFlag = 1;
      ((EmotionDetail)localObject).CoverUrl = "";
      ((EmotionDetail)localObject).PackExpire = 0;
      ((EmotionDetail)localObject).PackCopyright = paramBundle.getString(2131758382);
      ((EmotionDetail)localObject).PanelUrl = "";
      ((EmotionDetail)localObject).PriceNum = "";
      ((EmotionDetail)localObject).PriceType = "";
      ((EmotionDetail)localObject).TimeLimitStr = paramBundle.getString(2131758384);
      this.oAJ = ((EmotionDetail)localObject);
      this.oDF = true;
      this.oDE = EmojiLogic.bUQ();
      bWs();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109016);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.remove(this);
    com.tencent.mm.sdk.b.a.ESL.d(this.oAv);
    com.tencent.mm.kernel.g.afA().gcy.b(822, this);
    if (this.oCZ != null) {
      this.oCZ.release();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(109016);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109014);
    super.onPause();
    com.tencent.mm.kernel.g.afA().gcy.b(412, this);
    com.tencent.mm.kernel.g.afA().gcy.b(521, this);
    com.tencent.mm.kernel.g.afA().gcy.b(423, this);
    com.tencent.mm.kernel.g.afA().gcy.b(413, this);
    AppMethodBeat.o(109014);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109018);
    this.oCJ = paramBundle.getInt("status");
    this.EI = paramBundle.getInt("progress");
    AppMethodBeat.o(109018);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109013);
    super.onResume();
    com.tencent.mm.kernel.g.afA().gcy.a(412, this);
    com.tencent.mm.kernel.g.afA().gcy.a(521, this);
    com.tencent.mm.kernel.g.afA().gcy.a(423, this);
    com.tencent.mm.kernel.g.afA().gcy.a(413, this);
    this.oDB = false;
    if (!this.oDG)
    {
      bWq();
      AD(1007);
    }
    bWr();
    this.oDG = false;
    AD(1001);
    AppMethodBeat.o(109013);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109017);
    paramBundle.putInt("status", this.oCJ);
    paramBundle.putInt("progress", this.EI);
    AppMethodBeat.o(109017);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(109020);
    ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.ift != null) && (this.ift.isShowing())) {
      this.ift.dismiss();
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109020);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.emoji.f.l))
      {
        ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
        paramString = (com.tencent.mm.plugin.emoji.f.l)paramn;
        if ((paramString != null) && (!bt.isNullOrNil(paramString.oyw)) && (paramString.oyw.equalsIgnoreCase(this.oyw)))
        {
          if (paramInt1 == 0)
          {
            if (paramInt2 == 0)
            {
              this.oAJ = paramString.bVp();
              AD(1002);
              AppMethodBeat.o(109020);
              return;
            }
            if (paramInt2 == 1)
            {
              bWo();
              AppMethodBeat.o(109020);
              return;
            }
            this.oCQ.setText(2131758330);
            bWp();
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 5)
          {
            if ((paramString != null) && (paramString.bVp() != null)) {
              this.oAJ.PackFlag = paramString.bVp().PackFlag;
            }
            AD(1002);
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 1)
          {
            bWo();
            AppMethodBeat.o(109020);
            return;
          }
          this.oCS.setVisibility(8);
          this.DR.setVisibility(0);
          this.oCQ.setText(2131758331);
          bWp();
          AppMethodBeat.o(109020);
          return;
        }
        ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
        AppMethodBeat.o(109020);
        return;
        if ((paramn instanceof com.tencent.mm.plugin.emoji.f.g))
        {
          ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
          paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
          if ((paramString == this.oCL) && (!bt.isNullOrNil(paramString.oyw)) && (paramString.oyw.equalsIgnoreCase(this.oyw)))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.oDt = paramString.hhN;
              this.oCJ = 6;
              bWy();
              AppMethodBeat.o(109020);
              return;
            }
            this.oCJ = -1;
            bWy();
            paramString = this.oyx;
            com.tencent.mm.ui.base.h.a(this, String.format(getString(2131758320), new Object[] { paramString }), "", new DialogInterface.OnClickListener()new EmojiStoreDetailUI.10
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(176188);
                EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, new com.tencent.mm.plugin.emoji.f.g(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.y(EmojiStoreDetailUI.this), EmojiStoreDetailUI.z(EmojiStoreDetailUI.this)));
                EmojiStoreDetailUI.A(EmojiStoreDetailUI.this);
                EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 6);
                EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                AppMethodBeat.o(176188);
              }
            }, new EmojiStoreDetailUI.10(this));
            AppMethodBeat.o(109020);
            return;
          }
          ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          AppMethodBeat.o(109020);
          return;
          ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
          paramString = (com.tencent.mm.plugin.emoji.f.k)paramn;
          if ((paramString != null) && (!bt.isNullOrNil(paramString.oyj)) && (paramString.oyj.equalsIgnoreCase(this.oyw))) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.oDE = ((atl)paramString.rr.gUT.gUX);
              this.oDF = true;
              bWz();
            }
          }
          for (;;)
          {
            this.oDF = true;
            bWz();
            AppMethodBeat.o(109020);
            return;
            this.oDE = null;
            break;
            ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          }
          if ((paramn instanceof com.tencent.mm.plugin.emoji.f.o))
          {
            ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.oCO = ((com.tencent.mm.plugin.emoji.f.o)paramn).bVu();
              AD(1007);
              AppMethodBeat.o(109020);
              return;
              if (this.oDI != null)
              {
                this.oDI.dismiss();
                this.oDI = null;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.aJq(((com.tencent.mm.plugin.emoji.f.q)paramn).oyw);
                this.oCJ = 3;
                bWy();
                AppMethodBeat.o(109020);
                return;
              }
              com.tencent.mm.ui.base.h.d(getContext(), getContext().getString(2131758409), "", "", getContext().getString(2131760315), null, null);
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
  
  class a
    extends BaseAdapter
    implements com.tencent.mm.view.a.a
  {
    public a() {}
    
    public int getCount()
    {
      AppMethodBeat.i(109000);
      if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this) == null)
      {
        AppMethodBeat.o(109000);
        return 0;
      }
      int i = EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbCnt;
      AppMethodBeat.o(109000);
      return i;
    }
    
    public Object getItem(int paramInt)
    {
      AppMethodBeat.i(109001);
      if ((EmojiStoreDetailUI.b(EmojiStoreDetailUI.this) == null) || (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList == null) || (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList.size() <= 0) || (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList.get(paramInt) == null) || (((PackThumbExt)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList.get(paramInt)).PreviewUrl == null))
      {
        AppMethodBeat.o(109001);
        return null;
      }
      ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[] { Integer.valueOf(paramInt) });
      PackThumbExt localPackThumbExt = (PackThumbExt)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList.get(paramInt);
      EmojiInfo localEmojiInfo = new EmojiInfo();
      localEmojiInfo.field_md5 = localPackThumbExt.Md5;
      localEmojiInfo.field_thumbUrl = localPackThumbExt.ThumbUrl;
      localEmojiInfo.field_cdnUrl = localPackThumbExt.CDNUrl;
      localEmojiInfo.field_aeskey = localPackThumbExt.AesKey;
      localEmojiInfo.field_encrypturl = localPackThumbExt.EncryptUrl;
      localEmojiInfo.field_externUrl = localPackThumbExt.ExternUrl;
      localEmojiInfo.field_externMd5 = localPackThumbExt.ExternMd5;
      localEmojiInfo.field_activityid = localPackThumbExt.ActivityID;
      localEmojiInfo.field_groupId = EmojiStoreDetailUI.a(EmojiStoreDetailUI.this);
      localEmojiInfo.field_catalog = 84;
      localEmojiInfo.field_reserved4 |= EmojiInfo.LCl;
      AppMethodBeat.o(109001);
      return localEmojiInfo;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(109002);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(EmojiStoreDetailUI.w(EmojiStoreDetailUI.this)).inflate(2131493796, null);
        paramViewGroup = new EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramView);
        paramView.setTag(paramViewGroup);
        if (!EmojiStoreDetailUI.x(EmojiStoreDetailUI.this).HYb) {
          break label154;
        }
        paramViewGroup.oDS.setBackgroundResource(2131234073);
      }
      for (;;)
      {
        String str = "";
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList != null) {
          str = z.a((cmf)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList.get(paramInt));
        }
        com.tencent.mm.aw.o.ayJ().a(str, paramViewGroup.oDS, com.tencent.mm.plugin.emoji.e.e.eX(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), str));
        AppMethodBeat.o(109002);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
        label154:
        paramViewGroup.oDS.setBackgroundDrawable(null);
      }
    }
  }
  
  final class b
    extends EmojiStoreDetailUI.a
  {
    private ArrayList<EmojiInfo> oDR;
    
    public b()
    {
      super();
      AppMethodBeat.i(109003);
      this.oDR = new ArrayList();
      this.oDR = ((ArrayList)com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.TC(com.tencent.mm.plugin.emoji.h.a.bXj()));
      AppMethodBeat.o(109003);
    }
    
    private EmojiInfo AB(int paramInt)
    {
      AppMethodBeat.i(109005);
      if (this.oDR == null)
      {
        AppMethodBeat.o(109005);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.oDR.get(paramInt);
      AppMethodBeat.o(109005);
      return localEmojiInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109004);
      if (this.oDR == null)
      {
        AppMethodBeat.o(109004);
        return 0;
      }
      int i = this.oDR.size();
      AppMethodBeat.o(109004);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(109006);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(EmojiStoreDetailUI.w(EmojiStoreDetailUI.this)).inflate(2131493796, null);
        paramViewGroup = new EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramView);
        paramView.setTag(paramViewGroup);
        paramViewGroup.oDS.setBackgroundResource(2131234073);
        localObject = AB(paramInt);
        if (!bt.isNullOrNil(((EmojiInfo)localObject).getContent())) {
          break label129;
        }
      }
      label129:
      for (Object localObject = ((EmojiInfo)localObject).getName();; localObject = ((EmojiInfo)localObject).getContent())
      {
        localObject = localObject.split("\\.")[0];
        com.tencent.mm.aw.o.ayJ().a((String)localObject, paramViewGroup.oDS, com.tencent.mm.plugin.emoji.e.e.bUC());
        AppMethodBeat.o(109006);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    SquareImageView oDS;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109008);
      this.oDS = ((SquareImageView)paramView.findViewById(2131299047));
      this.oDS.setScaleType(ImageView.ScaleType.FIT_CENTER);
      AppMethodBeat.o(109008);
    }
  }
  
  static final class d
    implements com.tencent.mm.aw.a.c.k
  {
    WeakReference<EmojiStoreDetailUI> cqo;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(176195);
      ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[] { paramString });
      if (this.cqo == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      paramString = (EmojiStoreDetailUI)this.cqo.get();
      if (paramString == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      if (paramBitmap != null) {
        paramString.AD(1006);
      }
      AppMethodBeat.o(176195);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */