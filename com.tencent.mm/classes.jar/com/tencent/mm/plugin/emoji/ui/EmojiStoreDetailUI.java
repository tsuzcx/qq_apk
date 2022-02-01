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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.model.u;
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
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.SmileySubGrid;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.al.f, k.a
{
  private static d pKP;
  private View GG;
  private int Hx;
  private ProgressDialog iYL;
  private Context mContext;
  private ap mHandler;
  private int mNumColumns;
  private int mPadding;
  private ProgressBar pAH;
  private long pEL;
  private String pEM;
  private com.tencent.mm.plugin.emoji.h.c pEP;
  private com.tencent.mm.g.b.a.z pER;
  private String pFG;
  private String pFH;
  private String pFI;
  private EmotionDetail pHL;
  private String pHM;
  private int pHt;
  private com.tencent.mm.sdk.b.c pHx;
  private int pJH;
  private String pJI;
  private boolean pJJ;
  private boolean pJK;
  private int pJL;
  private com.tencent.mm.plugin.emoji.f.l pJM;
  private com.tencent.mm.plugin.emoji.f.g pJN;
  private com.tencent.mm.plugin.emoji.f.o pJO;
  private a pJP;
  private GetEmotionRewardResponse pJQ;
  private boolean pJR;
  private TextView pJS;
  private View pJT;
  private EmojiDetailScrollView pJU;
  private BannerEmojiView pJV;
  private TextView pJW;
  private MMAutoSizeTextView pJX;
  private TextView pJY;
  private TextView pJZ;
  private String pKA;
  private String pKB;
  private String[] pKC;
  private boolean pKD;
  private View pKE;
  private boolean pKF;
  private ban pKG;
  private boolean pKH;
  private boolean pKI;
  private boolean pKJ;
  private com.tencent.mm.ui.base.p pKK;
  private View.OnClickListener pKL;
  private View.OnClickListener pKM;
  private View.OnClickListener pKN;
  private View.OnClickListener pKO;
  private com.tencent.mm.aw.a.c.l pKQ;
  private j.a pKR;
  private TextView pKa;
  private EmojiDetailGridView pKb;
  private ImageView pKc;
  private View pKd;
  private TextView pKe;
  private TextView pKf;
  private int pKg;
  private View pKh;
  private ProgressBar pKi;
  private View pKj;
  private ImageView pKk;
  private TextView pKl;
  private View pKm;
  private View pKn;
  private TextView pKo;
  private Button pKp;
  private DonorsAvatarView pKq;
  private TextView pKr;
  private int pKs;
  private int pKt;
  private int pKu;
  private String pKv;
  private boolean pKw;
  private int pKx;
  private int pKy;
  private String pKz;
  
  static
  {
    AppMethodBeat.i(176199);
    pKP = new d((byte)0);
    AppMethodBeat.o(176199);
  }
  
  public EmojiStoreDetailUI()
  {
    AppMethodBeat.i(109009);
    this.pJK = false;
    this.pJL = -1;
    this.pHL = new EmotionDetail();
    this.pHM = "";
    this.pJQ = null;
    this.pEL = 0L;
    this.pEM = "";
    this.pKy = -1;
    this.pKC = new String[1];
    this.pKD = false;
    this.pKF = true;
    this.pKH = false;
    this.pKI = true;
    this.pKJ = false;
    this.pHx = new com.tencent.mm.sdk.b.c() {};
    this.pKL = new EmojiStoreDetailUI.12(this);
    this.pKM = new EmojiStoreDetailUI.15(this);
    this.pKN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108994);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = new Intent();
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yhR.f(12738, new Object[] { EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(EmojiStoreDetailUI.this)), Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108994);
      }
    };
    this.pKO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108995);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_iconurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).IconUrl);
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackName);
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner != null) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
        }
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        EmojiStoreDetailUI.this.cil();
        AppMethodBeat.o(108996);
      }
    };
    this.pKQ = new com.tencent.mm.aw.a.c.l()
    {
      public final void sj(long paramAnonymousLong)
      {
        AppMethodBeat.i(176192);
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10930, EmojiStoreDetailUI.a(EmojiStoreDetailUI.this) + "," + paramAnonymousLong);
        AppMethodBeat.o(176192);
      }
    };
    this.pKR = new j.a()
    {
      public final void R(ArrayList<com.tencent.mm.pluginsdk.model.p> paramAnonymousArrayList)
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
            if (paramAnonymousArrayList.EMb != 10232) {
              break label175;
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 4);
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousArrayList.ELY);
            EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.ELZ);
            paramAnonymousArrayList = new BigDecimal(paramAnonymousArrayList.EMa).divide(new BigDecimal(1000000));
            EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramAnonymousArrayList.toString());
          }
        }
        for (;;)
        {
          EmojiStoreDetailUI.this.Cd(1002);
          AppMethodBeat.o(176191);
          return;
          i = paramAnonymousArrayList.size();
          break;
          label175:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 10);
          EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.EMb);
        }
      }
    };
    AppMethodBeat.o(109009);
  }
  
  private void abS(String paramString)
  {
    AppMethodBeat.i(109025);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758285);
    }
    h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109025);
  }
  
  private void cie()
  {
    AppMethodBeat.i(109021);
    this.GG.setVisibility(0);
    this.pJT.setVisibility(8);
    this.pJU.setVisibility(8);
    this.pJS.setText(2131758269);
    AppMethodBeat.o(109021);
  }
  
  private void cif()
  {
    AppMethodBeat.i(109022);
    ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.pHL == null) || (this.pHL.PackFlag == 0))
    {
      this.GG.setVisibility(0);
      this.pJT.setVisibility(8);
    }
    AppMethodBeat.o(109022);
  }
  
  private void cig()
  {
    AppMethodBeat.i(109026);
    this.pJQ = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILs.aUU(this.pFG);
    AppMethodBeat.o(109026);
  }
  
  private void cih()
  {
    AppMethodBeat.i(109027);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackFlag, 64)) && (com.tencent.mm.emoji.a.m.aeT()))
    {
      this.pJO = new com.tencent.mm.plugin.emoji.f.o(this.pFG, com.tencent.mm.plugin.emoji.f.o.pGg);
      com.tencent.mm.kernel.g.ajB().gAO.a(this.pJO, 0);
    }
    AppMethodBeat.o(109027);
  }
  
  private boolean cii()
  {
    AppMethodBeat.i(109028);
    boolean bool = com.tencent.mm.plugin.emoji.h.a.cii();
    this.pJR = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.pJL = i;
      AppMethodBeat.o(109028);
      return bool;
    }
  }
  
  private void cij()
  {
    AppMethodBeat.i(109029);
    if (!bt.isNullOrNil(this.pHL.PackName))
    {
      setMMTitle(this.pHL.PackName);
      this.pFH = this.pHL.PackName;
    }
    ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.pHL.PanelUrl });
    this.pJT.setVisibility(0);
    this.GG.setVisibility(8);
    ks(true);
    this.pJX.setText(this.pHL.PackName);
    this.pJY.setText(this.pHL.PackCopyright);
    this.pKa.setText(this.pHL.PackDesc);
    if (com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackType, 1)) {
      this.pJW.setVisibility(8);
    }
    for (;;)
    {
      cin();
      cio();
      cip();
      ciq();
      cir();
      this.pJX.setMaxWidth(this.pKg - this.pKh.getWidth() - com.tencent.mm.cc.a.ax(getContext(), 2131165516) * 2 - this.pJW.getWidth() - com.tencent.mm.cc.a.ax(getContext(), 2131165489) * 2);
      this.pJX.setVisibility(8);
      this.pJX.setVisibility(0);
      cik();
      cim();
      cil();
      AppMethodBeat.o(109029);
      return;
      this.pJW.setVisibility(0);
      this.pJW.setText(2131758411);
    }
  }
  
  private void cik()
  {
    AppMethodBeat.i(109031);
    if ((this.pHL.PersonalDesigner != null) && (this.pHL.PersonalDesigner.DesignerUin != 0) && (this.pKu != 6))
    {
      this.pKm.setVisibility(0);
      this.pKj.setVisibility(0);
      com.tencent.mm.aw.q.aIJ().a(this.pHL.PersonalDesigner.HeadUrl, this.pKk, com.tencent.mm.plugin.emoji.e.e.fv(this.pFG, this.pHL.PersonalDesigner.HeadUrl));
      this.pKl.setText(this.pHL.PersonalDesigner.Name);
      this.pKj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176185);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = new Intent();
          ((Intent)localObject).setClass(EmojiStoreDetailUI.this.getContext(), EmojiStoreV2DesignerUI.class);
          ((Intent)localObject).putExtra("uin", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.DesignerUin);
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
          ((Intent)localObject).putExtra("headurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.HeadUrl);
          ((Intent)localObject).putExtra("rediret_url", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).OldRedirectUrl);
          ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
          ((Intent)localObject).putExtra("extra_scence", 26);
          paramAnonymousView = EmojiStoreDetailUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176185);
        }
      });
      AppMethodBeat.o(109031);
      return;
    }
    this.pKm.setVisibility(8);
    this.pKj.setVisibility(8);
    AppMethodBeat.o(109031);
  }
  
  private void cim()
  {
    AppMethodBeat.i(109033);
    if ((this.pHL.PackFlag & 0x20) == 32)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)this.pKf.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.pKe.getLayoutParams();
      this.pKf.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.cc.a.ax(getContext(), 2131165516);
      this.pKf.setLayoutParams(localLayoutParams1);
      this.pKf.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.cc.a.ax(getContext(), 2131165516);
      this.pKe.setLayoutParams(localLayoutParams2);
      this.pKe.setGravity(5);
      AppMethodBeat.o(109033);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.pKe.getLayoutParams();
    localLayoutParams1.gravity = 17;
    this.pKe.setLayoutParams(localLayoutParams1);
    this.pKe.setGravity(17);
    this.pKf.setVisibility(8);
    AppMethodBeat.o(109033);
  }
  
  private void cin()
  {
    AppMethodBeat.i(109034);
    if (com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackType, 8))
    {
      this.pKt = 0;
      ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.pHL.PackFlag) });
      if ((!com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackFlag, 8)) || (!com.tencent.mm.plugin.emoji.a.a.e.BY(this.pHL.PackType))) {
        break label164;
      }
      this.pJL = 8;
    }
    for (;;)
    {
      if (this.pJR) {
        this.pJL = 7;
      }
      AppMethodBeat.o(109034);
      return;
      if (com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackType, 4))
      {
        this.pKt = 0;
        break;
      }
      if ((!this.pKw) && (TextUtils.isEmpty(this.pHL.PackPrice)))
      {
        this.pKt = 0;
        break;
      }
      this.pKt = 1;
      break;
      label164:
      if ((com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackFlag, 1)) || (com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackType, 8))) {
        this.pJL = 3;
      } else if (com.tencent.mm.plugin.emoji.a.a.e.BY(this.pHL.PackType)) {
        this.pJL = 0;
      } else if ((!this.pKw) && ((TextUtils.isEmpty(this.pHL.PriceNum)) || (this.pHL.PriceNum.equals("0")))) {
        this.pJL = 0;
      } else if (this.pKw)
      {
        if (TextUtils.isEmpty(this.pKz)) {
          this.pJL = this.pKx;
        } else {
          this.pJL = 4;
        }
      }
      else {
        this.pJL = 4;
      }
    }
  }
  
  private void cio()
  {
    AppMethodBeat.i(109035);
    if (com.tencent.mm.plugin.emoji.h.a.ach(this.pFG)) {
      cii();
    }
    switch (this.pJL)
    {
    case 1: 
    case 2: 
    case 9: 
    default: 
      ad.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.pJL) });
    }
    for (;;)
    {
      cip();
      AppMethodBeat.o(109035);
      return;
      this.pKi.setVisibility(8);
      this.pJZ.setTextColor(getResources().getColorStateList(2131100272));
      this.pJZ.setBackgroundResource(2131231372);
      this.pJZ.setText(2131758322);
      this.pJZ.setEnabled(false);
      continue;
      this.pKi.setVisibility(8);
      this.pJZ.setTextColor(getResources().getColorStateList(2131101185));
      this.pJZ.setBackgroundResource(2131231365);
      this.pJZ.setText(2131758319);
      this.pJZ.setEnabled(true);
      continue;
      this.pKi.setVisibility(8);
      this.pJZ.setTextColor(getResources().getColorStateList(2131101185));
      this.pJZ.setBackgroundResource(2131231365);
      this.pJZ.setEnabled(true);
      if (this.pKw)
      {
        if (bt.isNullOrNil(this.pKz)) {
          this.pJZ.setText("");
        } else {
          this.pJZ.setText(this.pKz);
        }
      }
      else
      {
        this.pJZ.setText(this.pHL.PackPrice);
        this.pJL = 4;
        continue;
        this.pKi.setVisibility(8);
        this.pJZ.setTextColor(getResources().getColorStateList(2131101185));
        this.pJZ.setBackgroundResource(2131231365);
        this.pJZ.setText(2131758319);
        this.pJZ.setEnabled(true);
        continue;
        this.pKi.setVisibility(8);
        this.pJZ.setEnabled(false);
        this.pKd.setVisibility(0);
        this.pKc.setVisibility(0);
        this.pJZ.setVisibility(4);
        if (this.pJH != 3)
        {
          continue;
          this.pKi.setVisibility(8);
          this.pJZ.setVisibility(0);
          this.pJZ.setEnabled(true);
          if (this.pKJ)
          {
            this.pJZ.setText(2131758290);
            this.pJZ.setTextColor(getResources().getColorStateList(2131100467));
            this.pJZ.setBackgroundResource(2131231367);
          }
          for (;;)
          {
            this.pKd.setVisibility(8);
            this.pAH.setProgress(0);
            this.pKc.setVisibility(4);
            if (this.pJH == 3) {
              break;
            }
            break;
            this.pJZ.setTextColor(getResources().getColorStateList(2131101185));
            this.pJZ.setText(2131758388);
            this.pJZ.setBackgroundResource(2131231365);
          }
          this.pKi.setVisibility(8);
          this.pJZ.setBackgroundResource(2131231365);
          this.pJZ.setText(2131758319);
          this.pJZ.setEnabled(true);
          this.pKi.setVisibility(0);
          this.pJZ.setVisibility(0);
          this.pJZ.setBackgroundResource(2131234792);
          this.pJZ.setText("");
          this.pJZ.setEnabled(false);
          this.pKd.setVisibility(8);
          this.pAH.setProgress(0);
          this.pKc.setVisibility(4);
          continue;
          this.pKi.setVisibility(8);
          this.pJZ.setVisibility(0);
          this.pJZ.setBackgroundResource(2131231365);
          this.pJZ.setText(2131758343);
          this.pJZ.setEnabled(true);
          this.pKd.setVisibility(8);
          this.pAH.setProgress(0);
          this.pKc.setVisibility(4);
          continue;
          cin();
          cio();
        }
      }
    }
  }
  
  private void cip()
  {
    AppMethodBeat.i(109036);
    if ((this.pKH) && ((this.pKG == null) || ((this.pKG.GxE & 0x1) != 1)) && ((this.pHL == null) || (!com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackFlag, 1))) && (this.pKG != null) && (!TextUtils.isEmpty(this.pKG.GxD)))
    {
      this.pJZ.setText(this.pKG.GxD);
      this.pJZ.setTextColor(getContext().getResources().getColor(2131100482));
      this.pJZ.setBackgroundDrawable(null);
      this.pJZ.setEnabled(false);
    }
    AppMethodBeat.o(109036);
  }
  
  private void ciq()
  {
    AppMethodBeat.i(109037);
    if ((!com.tencent.mm.plugin.emoji.h.a.ach(this.pFG)) && ((this.pHL.ThumbExtList == null) || (this.pHL.ThumbExtList.size() <= 0) || (((PackThumbExt)this.pHL.ThumbExtList.get(0)).PreviewUrl == null))) {
      this.pKE.setVisibility(8);
    }
    for (;;)
    {
      this.pKb.setProductId(this.pFG);
      if (this.pJP != null) {
        this.pJP.notifyDataSetInvalidated();
      }
      AppMethodBeat.o(109037);
      return;
      this.pKE.setVisibility(0);
    }
  }
  
  private void cir()
  {
    AppMethodBeat.i(109038);
    ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.pHL.PackFlag });
    if ((this.pHL.PackFlag & 0x10) == 16) {
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
  
  private void cis()
  {
    AppMethodBeat.i(109039);
    h.a(this, 2131758311, 0, 2131758376, 2131758314, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176187);
        if (com.tencent.mm.plugin.emoji.h.a.ach(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this)))
        {
          ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
          com.tencent.mm.plugin.emoji.f.a.cgX().cgZ();
          if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this)))
          {
            com.tencent.mm.ao.f.aGI().EQ(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
            ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(EmojiStoreDetailUI.this) });
          }
          if ((!com.tencent.mm.plugin.emoji.a.a.e.fk(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackFlag, 1)) && (!com.tencent.mm.plugin.emoji.a.a.e.BY(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackType))) {
            break label262;
          }
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 3);
        }
        for (;;)
        {
          com.tencent.mm.plugin.emoji.model.k.cgV().h(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.u(EmojiStoreDetailUI.this), 0, EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
          EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(8);
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(0);
          EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(4);
          EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(0);
          EmojiStoreDetailUI.v(EmojiStoreDetailUI.this);
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          paramAnonymousDialogInterface = new com.tencent.mm.plugin.emoji.f.q(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), 2);
          com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(176187);
          return;
          com.tencent.mm.kernel.g.ajB().gAO.a(EmojiStoreDetailUI.s(EmojiStoreDetailUI.this));
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
  
  private void cit()
  {
    AppMethodBeat.i(109041);
    if (com.tencent.mm.plugin.emoji.h.a.ach(this.pFG))
    {
      com.tencent.mm.plugin.emoji.f.a.cgX();
      com.tencent.mm.plugin.emoji.f.a.cgY();
      AppMethodBeat.o(109041);
      return;
    }
    this.pJN = new com.tencent.mm.plugin.emoji.f.g(this.pFG, this.pFI, this.pFH);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pJN, 0);
    switch (this.pHt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(11598, new Object[] { Integer.valueOf(1), this.pFG });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(11598, new Object[] { Integer.valueOf(3), this.pFG });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(11598, new Object[] { Integer.valueOf(2), this.pFG });
    }
  }
  
  private void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(109030);
    Object localObject = null;
    String str;
    if (!bt.isNullOrNil(this.pHL.CoverUrl))
    {
      if (!paramBoolean) {
        break label104;
      }
      localObject = this.pFG;
      str = this.pHL.CoverUrl;
      com.tencent.mm.cc.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, pKP);; localObject = EmojiLogic.y((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.pJV != null)) {
        this.pJV.setImageFilePath(((EmojiInfo)localObject).gzQ());
      }
      if (com.tencent.mm.plugin.emoji.h.a.ach(this.pFG)) {
        this.pJV.setImageResource(2131234433);
      }
      AppMethodBeat.o(109030);
      return;
      label104:
      localObject = this.pFG;
      str = this.pHL.CoverUrl;
      com.tencent.mm.cc.a.getDensity(this.mContext);
    }
  }
  
  public final void Cd(int paramInt)
  {
    AppMethodBeat.i(109042);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
    AppMethodBeat.o(109042);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(109024);
    Cd(1001);
    AppMethodBeat.o(109024);
  }
  
  public final void cil()
  {
    AppMethodBeat.i(109032);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fk(this.pHL.PackFlag, 64)) && (com.tencent.mm.emoji.a.m.aeT()))
    {
      if (this.pJQ != null)
      {
        this.pKn.setVisibility(0);
        this.pKp.setText(2131758352);
        this.pKo.setText(this.pJQ.Reward.Gew);
        this.pKo.setLongClickable(false);
        if (this.pJQ.DonorNum > 0)
        {
          this.pKr.setVisibility(0);
          String str1 = String.valueOf(this.pJQ.DonorNum);
          String str2 = String.format(getString(2131758356), new Object[] { Integer.valueOf(this.pJQ.DonorNum) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131100286)), i, str1.length() + i, 33);
          }
          this.pKr.setText(localSpannableString);
        }
        while ((this.pJQ.Donors != null) && (this.pJQ.Donors.size() > 0))
        {
          this.pKq.setVisibility(0);
          this.pKq.d(this.pFG, this.pJQ.Donors);
          AppMethodBeat.o(109032);
          return;
          this.pKr.setVisibility(8);
        }
        this.pKq.setVisibility(8);
        AppMethodBeat.o(109032);
        return;
      }
      this.pKn.setVisibility(8);
      cih();
      AppMethodBeat.o(109032);
      return;
    }
    this.pKn.setVisibility(8);
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
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(109040);
    ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((bt.isNullOrNil(paramString1)) || (!paramString1.equals(this.pFG)))
    {
      AppMethodBeat.o(109040);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.pKv = paramString2;
    }
    if (paramInt1 == -1)
    {
      if (this.pJL != -1)
      {
        this.pJL = -1;
        Cd(1003);
        AppMethodBeat.o(109040);
      }
    }
    else
    {
      if (paramInt1 == 7)
      {
        this.pJL = 7;
        Cd(1003);
        AppMethodBeat.o(109040);
        return;
      }
      if (paramInt1 == 6)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.pFG)))
        {
          this.pJL = 6;
          this.Hx = paramInt2;
          Cd(1004);
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
    if (!bt.isNullOrNil(this.pFH)) {
      setMMTitle(this.pFH);
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
    this.mPadding = com.tencent.mm.cc.a.ax(this.mContext, 2131166211);
    this.pKs = getResources().getDimensionPixelSize(2131166210);
    this.pKs = com.tencent.mm.cc.a.ax(this.mContext, 2131166210);
    this.mNumColumns = 4;
    this.pJU = ((EmojiDetailScrollView)findViewById(2131304379));
    this.GG = findViewById(2131299457);
    this.pJS = ((TextView)this.GG.findViewById(2131299461));
    this.pJT = findViewById(2131299441);
    this.pJV = ((BannerEmojiView)findViewById(2131299378));
    int i = this.pJV.getRight();
    int j = this.pJV.getLeft();
    int k = this.pJV.getPaddingRight();
    int m = this.pJV.getPaddingLeft();
    this.pJV.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.pJW = ((TextView)findViewById(2131299451));
    this.pJX = ((MMAutoSizeTextView)findViewById(2131299452));
    this.pJY = ((TextView)findViewById(2131299362));
    this.pJZ = ((TextView)findViewById(2131299454));
    this.pKa = ((TextView)findViewById(2131299366));
    this.pKg = com.tencent.mm.cc.a.ip(getContext());
    this.pKh = findViewById(2131299330);
    this.pKb = ((EmojiDetailGridView)findViewById(2131299374));
    ProgressBar localProgressBar;
    if (com.tencent.mm.plugin.emoji.h.a.ach(this.pFG))
    {
      this.pJP = new b();
      this.pKd = findViewById(2131299429);
      this.pAH = ((ProgressBar)findViewById(2131299369));
      this.pKc = ((ImageView)findViewById(2131299360));
      this.pKc.setOnClickListener(this);
      this.pKd.setVisibility(8);
      this.pKc.setVisibility(8);
      this.pAH.setProgress(0);
      this.pKb.setAdapter(this.pJP);
      this.pKb.setColumnWidth(this.pKs);
      this.pKb.setNumColumns(this.mNumColumns);
      this.pKb.setHorizontalSpacing(this.mPadding);
      this.pKb.setVerticalSpacing(this.mPadding);
      this.pKb.setEmojiDetailScrollView(this.pJU);
      this.pKb.setFromDetail(true);
      this.pKb.setIsShowPopWin(true);
      this.pKb.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(176183);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView instanceof EmojiInfo))
          {
            paramAnonymousAdapterView = (EmojiInfo)paramAnonymousAdapterView;
            paramAnonymousView = new agb();
            if ((bt.isNullOrNil(paramAnonymousView.Md5)) || (paramAnonymousView.Md5.equals(paramAnonymousAdapterView.field_md5)))
            {
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_md5, paramAnonymousView.Md5);
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousView.Md5, "");
              paramAnonymousView.Url = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_cdnUrl, paramAnonymousView.Url);
              paramAnonymousView.ThumbUrl = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_thumbUrl, paramAnonymousView.ThumbUrl);
              paramAnonymousView.GdY = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_designerID, paramAnonymousView.GdY);
              paramAnonymousView.EncryptUrl = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_encrypturl, paramAnonymousView.EncryptUrl);
              paramAnonymousView.AesKey = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_aeskey, paramAnonymousView.AesKey);
              paramAnonymousView.ProductID = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_groupId, paramAnonymousView.ProductID);
              paramAnonymousView.ExternUrl = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_externUrl, paramAnonymousView.ExternUrl);
              paramAnonymousView.ExternMd5 = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_externMd5, paramAnonymousView.ExternMd5);
              paramAnonymousView.ActivityID = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_activityid, paramAnonymousView.ActivityID);
              paramAnonymousView.GdZ = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_attachedText, paramAnonymousView.GdZ);
              paramAnonymousView.Gea = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_attachTextColor, paramAnonymousView.Gea);
              paramAnonymousView.Geb = com.tencent.mm.plugin.emoji.h.b.fA(paramAnonymousAdapterView.field_lensId, paramAnonymousView.Geb);
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousView);
            com.tencent.mm.plugin.report.service.g.yhR.f(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAnonymousAdapterView.field_md5, Long.valueOf(EmojiStoreDetailUI.d(EmojiStoreDetailUI.this)), paramAnonymousAdapterView.field_designerID, paramAnonymousAdapterView.field_groupId, Integer.valueOf(26) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(176183);
        }
      });
      this.pJZ.setOnClickListener(this);
      this.pKe = ((TextView)findViewById(2131299433));
      this.pKf = ((TextView)findViewById(2131299361));
      this.pKe.setOnClickListener(this.pKL);
      this.pKf.setOnClickListener(this.pKM);
      this.pKi = ((ProgressBar)findViewById(2131299372));
      localProgressBar = this.pKi;
      if (!this.pKw) {
        break label767;
      }
    }
    label767:
    for (i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      this.pKE = findViewById(2131299386);
      this.pKm = findViewById(2131299365);
      this.pKj = findViewById(2131299016);
      this.pKk = ((ImageView)findViewById(2131299022));
      this.pKl = ((TextView)findViewById(2131299032));
      this.pKn = findViewById(2131299430);
      this.pKo = ((TextView)findViewById(2131304153));
      this.pKp = ((Button)findViewById(2131304154));
      this.pKr = ((TextView)findViewById(2131304158));
      this.pKq = ((DonorsAvatarView)findViewById(2131304152));
      this.pKp.setOnClickListener(this.pKN);
      this.pKr.setOnClickListener(this.pKO);
      AppMethodBeat.o(109011);
      return;
      this.pJP = new a();
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
      this.pKD = false;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localArrayList != null) && (localArrayList.contains(this.pFG)))
          {
            paramInt1 = 0;
            while (paramInt1 < localArrayList.size())
            {
              if (this.pFG.equals(localArrayList.get(paramInt1))) {
                this.pFI = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.pHL.PackFlag = 1;
            cit();
            this.pJL = 6;
            h.cl(this, str);
            if (u.aAA())
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 4L, 1L, false);
              AppMethodBeat.o(109023);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 0L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          this.pJL = -1;
          cio();
          abS(str);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 100000002))
        {
          cit();
          this.pJL = 6;
          this.pJP.notifyDataSetChanged();
          if (u.aAA())
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 7L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 3L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 1))
        {
          this.pJL = -1;
          cio();
          if (u.aAA())
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 6L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 2L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        this.pJL = -1;
        cio();
        abS(str);
        if (u.aAA())
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 5L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 1L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      this.pJL = -1;
      cio();
      if (u.aAA())
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 6L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 2L, 1L, false);
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
            com.tencent.mm.plugin.emoji.e.j.a(this, paramIntent, this.pFG, this.pHL.PackName, this.pHL.PackDesc, this.pHL.IconUrl, this.pHL.OldRedirectUrl, this.pHL.PackFlag);
          }
          AppMethodBeat.o(109023);
        }
      }
      else if (paramInt1 == this.pEP.mBI)
      {
        if (paramInt2 == -1)
        {
          ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
          com.tencent.mm.plugin.emoji.h.c.a(paramIntent, this.pFG, this);
          com.tencent.mm.plugin.report.service.g.yhR.f(12069, new Object[] { Integer.valueOf(3), this.pFG });
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
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    int i = paramView.getId();
    if (i == 2131299454)
    {
      if (this.pJL == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if (this.pKJ)
        {
          paramView = new com.tencent.mm.plugin.emoji.f.q(this.pFG, 2);
          com.tencent.mm.kernel.g.ajB().gAO.a(paramView, 0);
          this.pKK = com.tencent.mm.ui.base.p.a(this, getString(2131760706), true, 0, null);
          ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(11076, "0, ");
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109019);
        return;
        if ((!bt.isNullOrNil(paramView)) && (this.pJK))
        {
          com.tencent.mm.plugin.emoji.h.c.a(paramView, this.pFG, this);
          break;
        }
        this.pEP.O(this);
        com.tencent.mm.plugin.report.service.g.yhR.f(12069, new Object[] { Integer.valueOf(2), this.pFG });
        break;
        switch (this.pJL)
        {
        case 1: 
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          ad.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.pJL) });
          break;
        case 4: 
          if (!this.pKD)
          {
            if (this.pKJ)
            {
              paramView = com.tencent.mm.emoji.b.d.goG;
              com.tencent.mm.emoji.b.d.ma(6);
            }
            ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.pFG, this.pHL.PackPrice, this.pHL.PriceType });
            paramView = new Intent();
            paramView.putExtra("key_product_id", this.pFG);
            if (this.pKw)
            {
              paramView.putExtra("key_currency_type", this.pKA);
              paramView.putExtra("key_price", this.pKA + this.pKB);
            }
            for (;;)
            {
              com.tencent.mm.bs.d.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
              com.tencent.mm.plugin.report.service.g.yhR.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pKu), "", this.pFG, Long.valueOf(this.pEL), this.pEM });
              this.pKD = true;
              break;
              paramView.putExtra("key_currency_type", this.pHL.PriceType);
              paramView.putExtra("key_price", this.pHL.PriceNum);
            }
          }
          break;
        case 0: 
        case 3: 
          if (this.pKJ)
          {
            paramView = com.tencent.mm.emoji.b.d.goG;
            com.tencent.mm.emoji.b.d.ma(6);
          }
          cit();
          this.pJL = 6;
          cio();
          com.tencent.mm.plugin.report.service.g.yhR.f(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.pKu), "", this.pFG, Long.valueOf(this.pEL), this.pEM });
          if (this.pER != null)
          {
            this.pER.dUD = 4;
            this.pER.aLk();
          }
          break;
        case 5: 
          this.pJL = 3;
          cio();
          break;
        case 10: 
        case 12: 
          switch (this.pKy)
          {
          default: 
            paramView = getString(2131758412);
          }
          for (;;)
          {
            h.c(this, paramView, null, true);
            break;
            paramView = getString(2131758261);
            continue;
            paramView = getString(2131758270);
            continue;
            paramView = getString(2131758407);
          }
        case 11: 
          ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
          break;
        case -1: 
          ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
        }
      }
    }
    if (i == 2131299369)
    {
      cis();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    if (i == 2131299360)
    {
      cis();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    ad.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109019);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109010);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      finish();
      AppMethodBeat.o(109010);
      return;
    }
    this.pKw = u.aAA();
    this.pEP = new com.tencent.mm.plugin.emoji.h.c(2003);
    paramBundle = getIntent();
    this.pFG = getIntent().getStringExtra("extra_id");
    this.pHt = getIntent().getIntExtra("preceding_scence", -1);
    this.pFH = getIntent().getStringExtra("extra_name");
    this.pJH = getIntent().getIntExtra("call_by", -1);
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.pFG = EmojiLogic.abz((String)localObject);
      this.pHt = 0;
      this.pHt = 10;
      com.tencent.mm.plugin.report.service.g.yhR.f(10993, new Object[] { Integer.valueOf(3), this.pFG });
    }
    if (TextUtils.isEmpty(this.pFG))
    {
      ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.pHt == -1)
    {
      ad.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.pKF = paramBundle.getBooleanExtra("check_clickflag", true);
    this.pKv = paramBundle.getStringExtra("cdn_client_id");
    this.pKu = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.pKJ = paramBundle.getBooleanExtra("from_popup", false);
    this.pEL = paramBundle.getLongExtra("searchID", 0L);
    this.pEM = bt.bI(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pHL.PackCopyright = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pHL.CoverUrl = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pHL.PackDesc = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pHL.PackPrice = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.pHL.PackType = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.pHL.PackFlag = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pHL.PriceType = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pHL.PriceNum = ((String)localObject);
    }
    if (this.pKw)
    {
      this.pKx = 11;
      com.tencent.mm.pluginsdk.model.j.a(this, this.pKC, this.pKR);
    }
    this.pJJ = paramBundle.getBooleanExtra("reward_tip", false);
    paramBundle = paramBundle.getStringExtra("action_report");
    if (!bt.isNullOrNil(paramBundle)) {
      this.pER = new com.tencent.mm.g.b.a.z(paramBundle);
    }
    this.pKC[0] = this.pFG;
    this.pHL.ProductID = this.pFG;
    this.pHL.PackName = this.pFH;
    this.pHL.ShareDesc = this.pJI;
    this.pHL.PriceNum = "-1";
    this.pHL.Version = -1;
    this.mContext = this;
    pKP.cya = new WeakReference(this);
    initView();
    if (!com.tencent.mm.plugin.emoji.h.a.ach(this.pFG)) {
      if (this.pHL == null)
      {
        this.pJM = new com.tencent.mm.plugin.emoji.f.l(this.pFG, this.pHt);
        com.tencent.mm.kernel.g.ajB().gAO.a(this.pJM, 0);
        if ((this.pJH == -1) || (this.pJH == 3))
        {
          this.pJT.setVisibility(8);
          this.GG.setVisibility(8);
          getString(2131755906);
          this.iYL = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(176184);
              com.tencent.mm.kernel.g.ajB().gAO.a(EmojiStoreDetailUI.o(EmojiStoreDetailUI.this));
              EmojiStoreDetailUI.p(EmojiStoreDetailUI.this).setText(2131758331);
              EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
              AppMethodBeat.o(176184);
            }
          });
        }
        cig();
        if (!this.pKF) {
          break label1051;
        }
        paramBundle = new com.tencent.mm.plugin.emoji.f.k(this.pFG);
        com.tencent.mm.kernel.g.ajB().gAO.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      cij();
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo.add(this);
      com.tencent.mm.sdk.b.a.IbL.c(this.pHx);
      com.tencent.mm.kernel.g.ajB().gAO.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      i(this.pFG, i, j, this.pKv);
      this.pKI = true;
      com.tencent.mm.plugin.report.service.g.yhR.f(12740, new Object[] { Integer.valueOf(1), "", this.pFG, "", Integer.valueOf(this.pKu), Integer.valueOf(26) });
      if ((this.pJJ) && (this.pJU != null)) {
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
      if ((!bt.isNullOrNil(this.pHM)) && (this.pHM.equalsIgnoreCase(ac.iM(this.mContext))))
      {
        this.pJM = new com.tencent.mm.plugin.emoji.f.l(this.pFG, this.pHt, this.pHL.Version);
        break;
      }
      this.pJM = new com.tencent.mm.plugin.emoji.f.l(this.pFG, this.pHt);
      break;
      label1051:
      this.pKH = true;
      this.pKG = EmojiLogic.cgH();
      continue;
      paramBundle = getContext();
      localObject = new EmotionDetail();
      ((EmotionDetail)localObject).ProductID = EmojiGroupInfo.OeK;
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
      this.pHL = ((EmotionDetail)localObject);
      this.pKH = true;
      this.pKG = EmojiLogic.cgH();
      cii();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109016);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo.remove(this);
    com.tencent.mm.sdk.b.a.IbL.d(this.pHx);
    com.tencent.mm.kernel.g.ajB().gAO.b(822, this);
    if (this.pKb != null) {
      this.pKb.release();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(109016);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109014);
    super.onPause();
    com.tencent.mm.kernel.g.ajB().gAO.b(412, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(521, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(423, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(413, this);
    AppMethodBeat.o(109014);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109018);
    this.pJL = paramBundle.getInt("status");
    this.Hx = paramBundle.getInt("progress");
    AppMethodBeat.o(109018);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109013);
    super.onResume();
    com.tencent.mm.kernel.g.ajB().gAO.a(412, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(521, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(423, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(413, this);
    this.pKD = false;
    if (!this.pKI)
    {
      cig();
      Cd(1007);
    }
    cih();
    this.pKI = false;
    Cd(1001);
    AppMethodBeat.o(109013);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109017);
    paramBundle.putInt("status", this.pJL);
    paramBundle.putInt("progress", this.Hx);
    AppMethodBeat.o(109017);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109020);
    ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
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
        if ((paramString != null) && (!bt.isNullOrNil(paramString.pFG)) && (paramString.pFG.equalsIgnoreCase(this.pFG)))
        {
          if (paramInt1 == 0)
          {
            if (paramInt2 == 0)
            {
              this.pHL = paramString.chg();
              Cd(1002);
              AppMethodBeat.o(109020);
              return;
            }
            if (paramInt2 == 1)
            {
              cie();
              AppMethodBeat.o(109020);
              return;
            }
            this.pJS.setText(2131758330);
            cif();
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 5)
          {
            if ((paramString != null) && (paramString.chg() != null)) {
              this.pHL.PackFlag = paramString.chg().PackFlag;
            }
            Cd(1002);
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 1)
          {
            cie();
            AppMethodBeat.o(109020);
            return;
          }
          this.pJU.setVisibility(8);
          this.GG.setVisibility(0);
          this.pJS.setText(2131758331);
          cif();
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
          if ((paramString == this.pJN) && (!bt.isNullOrNil(paramString.pFG)) && (paramString.pFG.equalsIgnoreCase(this.pFG)))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.pKv = paramString.ibe;
              this.pJL = 6;
              cio();
              AppMethodBeat.o(109020);
              return;
            }
            this.pJL = -1;
            cio();
            paramString = this.pFH;
            h.a(this, String.format(getString(2131758320), new Object[] { paramString }), "", new DialogInterface.OnClickListener()new EmojiStoreDetailUI.10
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
          if ((paramString != null) && (!bt.isNullOrNil(paramString.pFt)) && (paramString.pFt.equalsIgnoreCase(this.pFG))) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.pKG = ((ban)paramString.rr.hNL.hNQ);
              this.pKH = true;
              cip();
            }
          }
          for (;;)
          {
            this.pKH = true;
            cip();
            AppMethodBeat.o(109020);
            return;
            this.pKG = null;
            break;
            ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          }
          if ((paramn instanceof com.tencent.mm.plugin.emoji.f.o))
          {
            ad.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.pJQ = ((com.tencent.mm.plugin.emoji.f.o)paramn).chl();
              Cd(1007);
              AppMethodBeat.o(109020);
              return;
              if (this.pKK != null)
              {
                this.pKK.dismiss();
                this.pKK = null;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo.aUD(((com.tencent.mm.plugin.emoji.f.q)paramn).pFG);
                this.pJL = 3;
                cio();
                AppMethodBeat.o(109020);
                return;
              }
              h.e(getContext(), getContext().getString(2131758409), "", "", getContext().getString(2131760315), null, null);
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
      localEmojiInfo.field_reserved4 |= EmojiInfo.Ofi;
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
        if (!EmojiStoreDetailUI.x(EmojiStoreDetailUI.this).LrW) {
          break label154;
        }
        paramViewGroup.pKU.setBackgroundResource(2131234073);
      }
      for (;;)
      {
        String str = "";
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList != null) {
          str = com.tencent.mm.platformtools.z.a((cwt)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList.get(paramInt));
        }
        com.tencent.mm.aw.q.aIJ().a(str, paramViewGroup.pKU, com.tencent.mm.plugin.emoji.e.e.fu(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), str));
        AppMethodBeat.o(109002);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
        label154:
        paramViewGroup.pKU.setBackgroundDrawable(null);
      }
    }
  }
  
  final class b
    extends EmojiStoreDetailUI.a
  {
    private ArrayList<EmojiInfo> pKT;
    
    public b()
    {
      super();
      AppMethodBeat.i(109003);
      this.pKT = new ArrayList();
      this.pKT = ((ArrayList)com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.abu(com.tencent.mm.plugin.emoji.h.a.ciZ()));
      AppMethodBeat.o(109003);
    }
    
    private EmojiInfo Cb(int paramInt)
    {
      AppMethodBeat.i(109005);
      if (this.pKT == null)
      {
        AppMethodBeat.o(109005);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.pKT.get(paramInt);
      AppMethodBeat.o(109005);
      return localEmojiInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109004);
      if (this.pKT == null)
      {
        AppMethodBeat.o(109004);
        return 0;
      }
      int i = this.pKT.size();
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
        paramViewGroup.pKU.setBackgroundResource(2131234073);
        localObject = Cb(paramInt);
        if (!bt.isNullOrNil(((EmojiInfo)localObject).getContent())) {
          break label129;
        }
      }
      label129:
      for (Object localObject = ((EmojiInfo)localObject).getName();; localObject = ((EmojiInfo)localObject).getContent())
      {
        localObject = localObject.split("\\.")[0];
        com.tencent.mm.aw.q.aIJ().a((String)localObject, paramViewGroup.pKU, com.tencent.mm.plugin.emoji.e.e.cgt());
        AppMethodBeat.o(109006);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    SquareImageView pKU;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109008);
      this.pKU = ((SquareImageView)paramView.findViewById(2131299047));
      this.pKU.setScaleType(ImageView.ScaleType.FIT_CENTER);
      AppMethodBeat.o(109008);
    }
  }
  
  static final class d
    implements com.tencent.mm.aw.a.c.k
  {
    WeakReference<EmojiStoreDetailUI> cya;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(176195);
      ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[] { paramString });
      if (this.cya == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      paramString = (EmojiStoreDetailUI)this.cya.get();
      if (paramString == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      if (paramBitmap != null) {
        paramString.Cd(1006);
      }
      AppMethodBeat.o(176195);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */