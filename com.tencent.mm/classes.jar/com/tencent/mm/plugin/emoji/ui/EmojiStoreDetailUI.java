package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.model.u;
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
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.view.SmileySubGrid;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.ak.g, k.a
{
  private static EmojiStoreDetailUI.d phn;
  private View EP;
  private int FG;
  private ProgressDialog iFC;
  private Context mContext;
  private ao mHandler;
  private int mNumColumns;
  private int mPadding;
  private ProgressBar oWX;
  private String pbW;
  private String pbX;
  private String pbY;
  private long pbb;
  private String pbc;
  private com.tencent.mm.plugin.emoji.h.c pbf;
  private w pbh;
  private int pdR;
  private com.tencent.mm.sdk.b.c pdV;
  private EmotionDetail pej;
  private String pek;
  private ImageView pgA;
  private View pgB;
  private TextView pgC;
  private TextView pgD;
  private int pgE;
  private View pgF;
  private ProgressBar pgG;
  private View pgH;
  private ImageView pgI;
  private TextView pgJ;
  private View pgK;
  private View pgL;
  private TextView pgM;
  private Button pgN;
  private DonorsAvatarView pgO;
  private TextView pgP;
  private int pgQ;
  private int pgR;
  private int pgS;
  private String pgT;
  private boolean pgU;
  private int pgV;
  private int pgW;
  private String pgX;
  private String pgY;
  private String pgZ;
  private int pgf;
  private String pgg;
  private boolean pgh;
  private boolean pgi;
  private int pgj;
  private com.tencent.mm.plugin.emoji.f.l pgk;
  private com.tencent.mm.plugin.emoji.f.g pgl;
  private com.tencent.mm.plugin.emoji.f.o pgm;
  private a pgn;
  private GetEmotionRewardResponse pgo;
  private boolean pgp;
  private TextView pgq;
  private View pgr;
  private EmojiDetailScrollView pgs;
  private BannerEmojiView pgt;
  private TextView pgu;
  private MMAutoSizeTextView pgv;
  private TextView pgw;
  private TextView pgx;
  private TextView pgy;
  private EmojiDetailGridView pgz;
  private String[] pha;
  private boolean phb;
  private View phc;
  private boolean phd;
  private awp phe;
  private boolean phf;
  private boolean phg;
  private boolean phh;
  private p phi;
  private View.OnClickListener phj;
  private View.OnClickListener phk;
  private View.OnClickListener phl;
  private View.OnClickListener phm;
  private com.tencent.mm.av.a.c.l pho;
  private j.a php;
  
  static
  {
    AppMethodBeat.i(176199);
    phn = new EmojiStoreDetailUI.d((byte)0);
    AppMethodBeat.o(176199);
  }
  
  public EmojiStoreDetailUI()
  {
    AppMethodBeat.i(109009);
    this.pgi = false;
    this.pgj = -1;
    this.pej = new EmotionDetail();
    this.pek = "";
    this.pgo = null;
    this.pbb = 0L;
    this.pbc = "";
    this.pgW = -1;
    this.pha = new String[1];
    this.phb = false;
    this.phd = true;
    this.phf = false;
    this.phg = true;
    this.phh = false;
    this.pdV = new com.tencent.mm.sdk.b.c() {};
    this.phj = new EmojiStoreDetailUI.12(this);
    this.phk = new EmojiStoreDetailUI.15(this);
    this.phl = new View.OnClickListener()
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.wUl.f(12738, new Object[] { EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(EmojiStoreDetailUI.this)), Integer.valueOf(0) });
        AppMethodBeat.o(108994);
      }
    };
    this.phm = new View.OnClickListener()
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108995);
      }
    };
    this.mHandler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108996);
        switch (paramAnonymousMessage.what)
        {
        default: 
          ac.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
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
        EmojiStoreDetailUI.this.cdI();
        AppMethodBeat.o(108996);
      }
    };
    this.pho = new EmojiStoreDetailUI.19(this);
    this.php = new EmojiStoreDetailUI.14(this);
    AppMethodBeat.o(109009);
  }
  
  private void Ym(String paramString)
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
  
  private void cdB()
  {
    AppMethodBeat.i(109021);
    this.EP.setVisibility(0);
    this.pgr.setVisibility(8);
    this.pgs.setVisibility(8);
    this.pgq.setText(2131758269);
    AppMethodBeat.o(109021);
  }
  
  private void cdC()
  {
    AppMethodBeat.i(109022);
    ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.pej == null) || (this.pej.PackFlag == 0))
    {
      this.EP.setVisibility(0);
      this.pgr.setVisibility(8);
    }
    AppMethodBeat.o(109022);
  }
  
  private void cdD()
  {
    AppMethodBeat.i(109026);
    this.pgo = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYe.aPd(this.pbW);
    AppMethodBeat.o(109026);
  }
  
  private void cdE()
  {
    AppMethodBeat.i(109027);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackFlag, 64)) && (com.tencent.mm.emoji.a.m.acp()))
    {
      this.pgm = new com.tencent.mm.plugin.emoji.f.o(this.pbW, com.tencent.mm.plugin.emoji.f.o.pcw);
      com.tencent.mm.kernel.g.agQ().ghe.a(this.pgm, 0);
    }
    AppMethodBeat.o(109027);
  }
  
  private boolean cdF()
  {
    AppMethodBeat.i(109028);
    boolean bool = com.tencent.mm.plugin.emoji.h.a.cdF();
    this.pgp = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.pgj = i;
      AppMethodBeat.o(109028);
      return bool;
    }
  }
  
  private void cdG()
  {
    AppMethodBeat.i(109029);
    if (!bs.isNullOrNil(this.pej.PackName))
    {
      setMMTitle(this.pej.PackName);
      this.pbX = this.pej.PackName;
    }
    ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.pej.PanelUrl });
    this.pgr.setVisibility(0);
    this.EP.setVisibility(8);
    kh(true);
    this.pgv.setText(this.pej.PackName);
    this.pgw.setText(this.pej.PackCopyright);
    this.pgy.setText(this.pej.PackDesc);
    if (com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackType, 1)) {
      this.pgu.setVisibility(8);
    }
    for (;;)
    {
      cdK();
      cdL();
      cdM();
      cdN();
      cdO();
      this.pgv.setMaxWidth(this.pgE - this.pgF.getWidth() - com.tencent.mm.cc.a.au(getContext(), 2131165516) * 2 - this.pgu.getWidth() - com.tencent.mm.cc.a.au(getContext(), 2131165489) * 2);
      this.pgv.setVisibility(8);
      this.pgv.setVisibility(0);
      cdH();
      cdJ();
      cdI();
      AppMethodBeat.o(109029);
      return;
      this.pgu.setVisibility(0);
      this.pgu.setText(2131758411);
    }
  }
  
  private void cdH()
  {
    AppMethodBeat.i(109031);
    if ((this.pej.PersonalDesigner != null) && (this.pej.PersonalDesigner.DesignerUin != 0) && (this.pgS != 6))
    {
      this.pgK.setVisibility(0);
      this.pgH.setVisibility(0);
      com.tencent.mm.av.o.aFB().a(this.pej.PersonalDesigner.HeadUrl, this.pgI, com.tencent.mm.plugin.emoji.e.e.fl(this.pbW, this.pej.PersonalDesigner.HeadUrl));
      this.pgJ.setText(this.pej.PersonalDesigner.Name);
      this.pgH.setOnClickListener(new View.OnClickListener()
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(176185);
        }
      });
      AppMethodBeat.o(109031);
      return;
    }
    this.pgK.setVisibility(8);
    this.pgH.setVisibility(8);
    AppMethodBeat.o(109031);
  }
  
  private void cdJ()
  {
    AppMethodBeat.i(109033);
    if ((this.pej.PackFlag & 0x20) == 32)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)this.pgD.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.pgC.getLayoutParams();
      this.pgD.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.cc.a.au(getContext(), 2131165516);
      this.pgD.setLayoutParams(localLayoutParams1);
      this.pgD.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.cc.a.au(getContext(), 2131165516);
      this.pgC.setLayoutParams(localLayoutParams2);
      this.pgC.setGravity(5);
      AppMethodBeat.o(109033);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.pgC.getLayoutParams();
    localLayoutParams1.gravity = 17;
    this.pgC.setLayoutParams(localLayoutParams1);
    this.pgC.setGravity(17);
    this.pgD.setVisibility(8);
    AppMethodBeat.o(109033);
  }
  
  private void cdK()
  {
    AppMethodBeat.i(109034);
    if (com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackType, 8))
    {
      this.pgR = 0;
      ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.pej.PackFlag) });
      if ((!com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackFlag, 8)) || (!com.tencent.mm.plugin.emoji.a.a.e.Bq(this.pej.PackType))) {
        break label164;
      }
      this.pgj = 8;
    }
    for (;;)
    {
      if (this.pgp) {
        this.pgj = 7;
      }
      AppMethodBeat.o(109034);
      return;
      if (com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackType, 4))
      {
        this.pgR = 0;
        break;
      }
      if ((!this.pgU) && (TextUtils.isEmpty(this.pej.PackPrice)))
      {
        this.pgR = 0;
        break;
      }
      this.pgR = 1;
      break;
      label164:
      if ((com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackFlag, 1)) || (com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackType, 8))) {
        this.pgj = 3;
      } else if (com.tencent.mm.plugin.emoji.a.a.e.Bq(this.pej.PackType)) {
        this.pgj = 0;
      } else if ((!this.pgU) && ((TextUtils.isEmpty(this.pej.PriceNum)) || (this.pej.PriceNum.equals("0")))) {
        this.pgj = 0;
      } else if (this.pgU)
      {
        if (TextUtils.isEmpty(this.pgX)) {
          this.pgj = this.pgV;
        } else {
          this.pgj = 4;
        }
      }
      else {
        this.pgj = 4;
      }
    }
  }
  
  private void cdL()
  {
    AppMethodBeat.i(109035);
    if (com.tencent.mm.plugin.emoji.h.a.YB(this.pbW)) {
      cdF();
    }
    switch (this.pgj)
    {
    case 1: 
    case 2: 
    case 9: 
    default: 
      ac.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.pgj) });
    }
    for (;;)
    {
      cdM();
      AppMethodBeat.o(109035);
      return;
      this.pgG.setVisibility(8);
      this.pgx.setTextColor(getResources().getColorStateList(2131100272));
      this.pgx.setBackgroundResource(2131231372);
      this.pgx.setText(2131758322);
      this.pgx.setEnabled(false);
      continue;
      this.pgG.setVisibility(8);
      this.pgx.setTextColor(getResources().getColorStateList(2131101185));
      this.pgx.setBackgroundResource(2131231365);
      this.pgx.setText(2131758319);
      this.pgx.setEnabled(true);
      continue;
      this.pgG.setVisibility(8);
      this.pgx.setTextColor(getResources().getColorStateList(2131101185));
      this.pgx.setBackgroundResource(2131231365);
      this.pgx.setEnabled(true);
      if (this.pgU)
      {
        if (bs.isNullOrNil(this.pgX)) {
          this.pgx.setText("");
        } else {
          this.pgx.setText(this.pgX);
        }
      }
      else
      {
        this.pgx.setText(this.pej.PackPrice);
        this.pgj = 4;
        continue;
        this.pgG.setVisibility(8);
        this.pgx.setTextColor(getResources().getColorStateList(2131101185));
        this.pgx.setBackgroundResource(2131231365);
        this.pgx.setText(2131758319);
        this.pgx.setEnabled(true);
        continue;
        this.pgG.setVisibility(8);
        this.pgx.setEnabled(false);
        this.pgB.setVisibility(0);
        this.pgA.setVisibility(0);
        this.pgx.setVisibility(4);
        if (this.pgf != 3)
        {
          continue;
          this.pgG.setVisibility(8);
          this.pgx.setVisibility(0);
          this.pgx.setEnabled(true);
          if (this.phh)
          {
            this.pgx.setText(2131758290);
            this.pgx.setTextColor(getResources().getColorStateList(2131100467));
            this.pgx.setBackgroundResource(2131231367);
          }
          for (;;)
          {
            this.pgB.setVisibility(8);
            this.oWX.setProgress(0);
            this.pgA.setVisibility(4);
            if (this.pgf == 3) {
              break;
            }
            break;
            this.pgx.setTextColor(getResources().getColorStateList(2131101185));
            this.pgx.setText(2131758388);
            this.pgx.setBackgroundResource(2131231365);
          }
          this.pgG.setVisibility(8);
          this.pgx.setBackgroundResource(2131231365);
          this.pgx.setText(2131758319);
          this.pgx.setEnabled(true);
          this.pgG.setVisibility(0);
          this.pgx.setVisibility(0);
          this.pgx.setBackgroundResource(2131234792);
          this.pgx.setText("");
          this.pgx.setEnabled(false);
          this.pgB.setVisibility(8);
          this.oWX.setProgress(0);
          this.pgA.setVisibility(4);
          continue;
          this.pgG.setVisibility(8);
          this.pgx.setVisibility(0);
          this.pgx.setBackgroundResource(2131231365);
          this.pgx.setText(2131758343);
          this.pgx.setEnabled(true);
          this.pgB.setVisibility(8);
          this.oWX.setProgress(0);
          this.pgA.setVisibility(4);
          continue;
          cdK();
          cdL();
        }
      }
    }
  }
  
  private void cdM()
  {
    AppMethodBeat.i(109036);
    if ((this.phf) && ((this.phe == null) || ((this.phe.EOA & 0x1) != 1)) && ((this.pej == null) || (!com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackFlag, 1))) && (this.phe != null) && (!TextUtils.isEmpty(this.phe.EOz)))
    {
      this.pgx.setText(this.phe.EOz);
      this.pgx.setTextColor(getContext().getResources().getColor(2131100482));
      this.pgx.setBackgroundDrawable(null);
      this.pgx.setEnabled(false);
    }
    AppMethodBeat.o(109036);
  }
  
  private void cdN()
  {
    AppMethodBeat.i(109037);
    if ((!com.tencent.mm.plugin.emoji.h.a.YB(this.pbW)) && ((this.pej.ThumbExtList == null) || (this.pej.ThumbExtList.size() <= 0) || (((PackThumbExt)this.pej.ThumbExtList.get(0)).PreviewUrl == null))) {
      this.phc.setVisibility(8);
    }
    for (;;)
    {
      this.pgz.setProductId(this.pbW);
      if (this.pgn != null) {
        this.pgn.notifyDataSetInvalidated();
      }
      AppMethodBeat.o(109037);
      return;
      this.phc.setVisibility(0);
    }
  }
  
  private void cdO()
  {
    AppMethodBeat.i(109038);
    ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.pej.PackFlag });
    if ((this.pej.PackFlag & 0x10) == 16) {
      addIconOptionMenu(0, 2131690655, new EmojiStoreDetailUI.6(this));
    }
    AppMethodBeat.o(109038);
  }
  
  private void cdP()
  {
    AppMethodBeat.i(109039);
    com.tencent.mm.ui.base.h.b(this, 2131758311, 0, 2131758376, 2131758314, new DialogInterface.OnClickListener()new EmojiStoreDetailUI.8
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176187);
        if (com.tencent.mm.plugin.emoji.h.a.YB(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this)))
        {
          ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
          com.tencent.mm.plugin.emoji.f.a.cct().ccv();
          if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this)))
          {
            com.tencent.mm.an.f.aDD().BR(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
            ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(EmojiStoreDetailUI.this) });
          }
          if ((!com.tencent.mm.plugin.emoji.a.a.e.fg(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackFlag, 1)) && (!com.tencent.mm.plugin.emoji.a.a.e.Bq(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackType))) {
            break label262;
          }
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 3);
        }
        for (;;)
        {
          com.tencent.mm.plugin.emoji.model.k.ccr().h(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.u(EmojiStoreDetailUI.this), 0, EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
          EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(8);
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(0);
          EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(4);
          EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(0);
          EmojiStoreDetailUI.v(EmojiStoreDetailUI.this);
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          paramAnonymousDialogInterface = new com.tencent.mm.plugin.emoji.f.q(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), 2);
          com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(176187);
          return;
          com.tencent.mm.kernel.g.agQ().ghe.a(EmojiStoreDetailUI.s(EmojiStoreDetailUI.this));
          break;
          label262:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, -1);
        }
      }
    }, new EmojiStoreDetailUI.8(this));
    AppMethodBeat.o(109039);
  }
  
  private void cdQ()
  {
    AppMethodBeat.i(109041);
    if (com.tencent.mm.plugin.emoji.h.a.YB(this.pbW))
    {
      com.tencent.mm.plugin.emoji.f.a.cct();
      com.tencent.mm.plugin.emoji.f.a.ccu();
      AppMethodBeat.o(109041);
      return;
    }
    this.pgl = new com.tencent.mm.plugin.emoji.f.g(this.pbW, this.pbY, this.pbX);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pgl, 0);
    switch (this.pdR)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.f(11598, new Object[] { Integer.valueOf(1), this.pbW });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.f(11598, new Object[] { Integer.valueOf(3), this.pbW });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.f(11598, new Object[] { Integer.valueOf(2), this.pbW });
    }
  }
  
  private void kh(boolean paramBoolean)
  {
    AppMethodBeat.i(109030);
    Object localObject = null;
    String str;
    if (!bs.isNullOrNil(this.pej.CoverUrl))
    {
      if (!paramBoolean) {
        break label104;
      }
      localObject = this.pbW;
      str = this.pej.CoverUrl;
      com.tencent.mm.cc.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, phn);; localObject = EmojiLogic.x((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.pgt != null)) {
        this.pgt.setImageFilePath(((EmojiInfo)localObject).ghd());
      }
      if (com.tencent.mm.plugin.emoji.h.a.YB(this.pbW)) {
        this.pgt.setImageResource(2131234433);
      }
      AppMethodBeat.o(109030);
      return;
      label104:
      localObject = this.pbW;
      str = this.pej.CoverUrl;
      com.tencent.mm.cc.a.getDensity(this.mContext);
    }
  }
  
  public final void Bv(int paramInt)
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
    Bv(1001);
    AppMethodBeat.o(109024);
  }
  
  public final void cdI()
  {
    AppMethodBeat.i(109032);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fg(this.pej.PackFlag, 64)) && (com.tencent.mm.emoji.a.m.acp()))
    {
      if (this.pgo != null)
      {
        this.pgL.setVisibility(0);
        this.pgN.setText(2131758352);
        this.pgM.setText(this.pgo.Reward.EwT);
        this.pgM.setLongClickable(false);
        if (this.pgo.DonorNum > 0)
        {
          this.pgP.setVisibility(0);
          String str1 = String.valueOf(this.pgo.DonorNum);
          String str2 = String.format(getString(2131758356), new Object[] { Integer.valueOf(this.pgo.DonorNum) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131100286)), i, str1.length() + i, 33);
          }
          this.pgP.setText(localSpannableString);
        }
        while ((this.pgo.Donors != null) && (this.pgo.Donors.size() > 0))
        {
          this.pgO.setVisibility(0);
          this.pgO.d(this.pbW, this.pgo.Donors);
          AppMethodBeat.o(109032);
          return;
          this.pgP.setVisibility(8);
        }
        this.pgO.setVisibility(8);
        AppMethodBeat.o(109032);
        return;
      }
      this.pgL.setVisibility(8);
      cdE();
      AppMethodBeat.o(109032);
      return;
    }
    this.pgL.setVisibility(8);
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
    ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((bs.isNullOrNil(paramString1)) || (!paramString1.equals(this.pbW)))
    {
      AppMethodBeat.o(109040);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.pgT = paramString2;
    }
    if (paramInt1 == -1)
    {
      if (this.pgj != -1)
      {
        this.pgj = -1;
        Bv(1003);
        AppMethodBeat.o(109040);
      }
    }
    else
    {
      if (paramInt1 == 7)
      {
        this.pgj = 7;
        Bv(1003);
        AppMethodBeat.o(109040);
        return;
      }
      if (paramInt1 == 6)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.pbW)))
        {
          this.pgj = 6;
          this.FG = paramInt2;
          Bv(1004);
          AppMethodBeat.o(109040);
        }
      }
      else {
        ac.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
      }
    }
    AppMethodBeat.o(109040);
  }
  
  public void initView()
  {
    AppMethodBeat.i(109011);
    if (!bs.isNullOrNil(this.pbX)) {
      setMMTitle(this.pbX);
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
    this.mPadding = com.tencent.mm.cc.a.au(this.mContext, 2131166211);
    this.pgQ = getResources().getDimensionPixelSize(2131166210);
    this.pgQ = com.tencent.mm.cc.a.au(this.mContext, 2131166210);
    this.mNumColumns = 4;
    this.pgs = ((EmojiDetailScrollView)findViewById(2131304379));
    this.EP = findViewById(2131299457);
    this.pgq = ((TextView)this.EP.findViewById(2131299461));
    this.pgr = findViewById(2131299441);
    this.pgt = ((BannerEmojiView)findViewById(2131299378));
    int i = this.pgt.getRight();
    int j = this.pgt.getLeft();
    int k = this.pgt.getPaddingRight();
    int m = this.pgt.getPaddingLeft();
    this.pgt.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.pgu = ((TextView)findViewById(2131299451));
    this.pgv = ((MMAutoSizeTextView)findViewById(2131299452));
    this.pgw = ((TextView)findViewById(2131299362));
    this.pgx = ((TextView)findViewById(2131299454));
    this.pgy = ((TextView)findViewById(2131299366));
    this.pgE = com.tencent.mm.cc.a.ig(getContext());
    this.pgF = findViewById(2131299330);
    this.pgz = ((EmojiDetailGridView)findViewById(2131299374));
    ProgressBar localProgressBar;
    if (com.tencent.mm.plugin.emoji.h.a.YB(this.pbW))
    {
      this.pgn = new b();
      this.pgB = findViewById(2131299429);
      this.oWX = ((ProgressBar)findViewById(2131299369));
      this.pgA = ((ImageView)findViewById(2131299360));
      this.pgA.setOnClickListener(this);
      this.pgB.setVisibility(8);
      this.pgA.setVisibility(8);
      this.oWX.setProgress(0);
      this.pgz.setAdapter(this.pgn);
      this.pgz.setColumnWidth(this.pgQ);
      this.pgz.setNumColumns(this.mNumColumns);
      this.pgz.setHorizontalSpacing(this.mPadding);
      this.pgz.setVerticalSpacing(this.mPadding);
      this.pgz.setEmojiDetailScrollView(this.pgs);
      this.pgz.setFromDetail(true);
      this.pgz.setIsShowPopWin(true);
      this.pgz.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(176183);
          paramAnonymousAdapterView = paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView instanceof EmojiInfo))
          {
            paramAnonymousAdapterView = (EmojiInfo)paramAnonymousAdapterView;
            paramAnonymousView = new ads();
            if ((bs.isNullOrNil(paramAnonymousView.Md5)) || (paramAnonymousView.Md5.equals(paramAnonymousAdapterView.field_md5)))
            {
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_md5, paramAnonymousView.Md5);
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousView.Md5, "");
              paramAnonymousView.Url = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_cdnUrl, paramAnonymousView.Url);
              paramAnonymousView.ThumbUrl = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_thumbUrl, paramAnonymousView.ThumbUrl);
              paramAnonymousView.Ewv = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_designerID, paramAnonymousView.Ewv);
              paramAnonymousView.EncryptUrl = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_encrypturl, paramAnonymousView.EncryptUrl);
              paramAnonymousView.AesKey = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_aeskey, paramAnonymousView.AesKey);
              paramAnonymousView.ProductID = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_groupId, paramAnonymousView.ProductID);
              paramAnonymousView.ExternUrl = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_externUrl, paramAnonymousView.ExternUrl);
              paramAnonymousView.ExternMd5 = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_externMd5, paramAnonymousView.ExternMd5);
              paramAnonymousView.ActivityID = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_activityid, paramAnonymousView.ActivityID);
              paramAnonymousView.Eww = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_attachedText, paramAnonymousView.Eww);
              paramAnonymousView.Ewx = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_attachTextColor, paramAnonymousView.Ewx);
              paramAnonymousView.Ewy = com.tencent.mm.plugin.emoji.h.b.fq(paramAnonymousAdapterView.field_lensId, paramAnonymousView.Ewy);
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.wUl.f(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAnonymousAdapterView.field_md5, Long.valueOf(EmojiStoreDetailUI.d(EmojiStoreDetailUI.this)), paramAnonymousAdapterView.field_designerID, paramAnonymousAdapterView.field_groupId, Integer.valueOf(26) });
          }
          AppMethodBeat.o(176183);
        }
      });
      this.pgx.setOnClickListener(this);
      this.pgC = ((TextView)findViewById(2131299433));
      this.pgD = ((TextView)findViewById(2131299361));
      this.pgC.setOnClickListener(this.phj);
      this.pgD.setOnClickListener(this.phk);
      this.pgG = ((ProgressBar)findViewById(2131299372));
      localProgressBar = this.pgG;
      if (!this.pgU) {
        break label767;
      }
    }
    label767:
    for (i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      this.phc = findViewById(2131299386);
      this.pgK = findViewById(2131299365);
      this.pgH = findViewById(2131299016);
      this.pgI = ((ImageView)findViewById(2131299022));
      this.pgJ = ((TextView)findViewById(2131299032));
      this.pgL = findViewById(2131299430);
      this.pgM = ((TextView)findViewById(2131304153));
      this.pgN = ((Button)findViewById(2131304154));
      this.pgP = ((TextView)findViewById(2131304158));
      this.pgO = ((DonorsAvatarView)findViewById(2131304152));
      this.pgN.setOnClickListener(this.phl);
      this.pgP.setOnClickListener(this.phm);
      AppMethodBeat.o(109011);
      return;
      this.pgn = new a();
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109023);
    ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str;
    if (paramInt1 == 2001)
    {
      str = "";
      if (paramIntent == null) {
        break label759;
      }
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      ac.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(paramInt1)));
      str = paramIntent.getStringExtra("key_err_msg");
      ac.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str)));
    }
    for (;;)
    {
      this.phb = false;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localArrayList != null) && (localArrayList.contains(this.pbW)))
          {
            paramInt1 = 0;
            while (paramInt1 < localArrayList.size())
            {
              if (this.pbW.equals(localArrayList.get(paramInt1))) {
                this.pbY = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.pej.PackFlag = 1;
            cdQ();
            this.pgj = 6;
            com.tencent.mm.ui.base.h.cg(this, str);
            if (u.axK())
            {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 4L, 1L, false);
              AppMethodBeat.o(109023);
              return;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 0L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          this.pgj = -1;
          cdL();
          Ym(str);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 100000002))
        {
          cdQ();
          this.pgj = 6;
          this.pgn.notifyDataSetChanged();
          if (u.axK())
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 7L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 3L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 1))
        {
          this.pgj = -1;
          cdL();
          if (u.axK())
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 6L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 2L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        this.pgj = -1;
        cdL();
        Ym(str);
        if (u.axK())
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 5L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 1L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      this.pgj = -1;
      cdL();
      if (u.axK())
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 6L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 2L, 1L, false);
      AppMethodBeat.o(109023);
      return;
      if (paramInt1 == 2002)
      {
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          if (!bs.isNullOrNil(paramIntent))
          {
            ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(paramIntent)));
            com.tencent.mm.plugin.emoji.e.j.a(this, paramIntent, this.pbW, this.pej.PackName, this.pej.PackDesc, this.pej.IconUrl, this.pej.OldRedirectUrl, this.pej.PackFlag);
          }
          AppMethodBeat.o(109023);
        }
      }
      else if (paramInt1 == this.pbf.mbA)
      {
        if (paramInt2 == -1)
        {
          ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
          com.tencent.mm.plugin.emoji.h.c.a(paramIntent, this.pbW, this);
          com.tencent.mm.plugin.report.service.h.wUl.f(12069, new Object[] { Integer.valueOf(3), this.pbW });
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
      if (this.pgj == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if (this.phh)
        {
          paramView = new com.tencent.mm.plugin.emoji.f.q(this.pbW, 2);
          com.tencent.mm.kernel.g.agQ().ghe.a(paramView, 0);
          this.phi = p.a(this, getString(2131760706), true, 0, null);
        }
        for (;;)
        {
          ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(11076, "0, ");
          AppMethodBeat.o(109019);
          return;
          if ((!bs.isNullOrNil(paramView)) && (this.pgi))
          {
            com.tencent.mm.plugin.emoji.h.c.a(paramView, this.pbW, this);
          }
          else
          {
            this.pbf.O(this);
            com.tencent.mm.plugin.report.service.h.wUl.f(12069, new Object[] { Integer.valueOf(2), this.pbW });
          }
        }
      }
      switch (this.pgj)
      {
      case 1: 
      case 2: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        ac.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.pgj) });
      case 4: 
      case 0: 
      case 3: 
        do
        {
          do
          {
            AppMethodBeat.o(109019);
            return;
          } while (this.phb);
          if (this.phh)
          {
            paramView = com.tencent.mm.emoji.b.d.fVd;
            com.tencent.mm.emoji.b.d.lA(6);
          }
          ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.pbW, this.pej.PackPrice, this.pej.PriceType });
          paramView = new Intent();
          paramView.putExtra("key_product_id", this.pbW);
          if (this.pgU)
          {
            paramView.putExtra("key_currency_type", this.pgY);
            paramView.putExtra("key_price", this.pgY + this.pgZ);
          }
          for (;;)
          {
            com.tencent.mm.br.d.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
            com.tencent.mm.plugin.report.service.h.wUl.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pgS), "", this.pbW, Long.valueOf(this.pbb), this.pbc });
            this.phb = true;
            AppMethodBeat.o(109019);
            return;
            paramView.putExtra("key_currency_type", this.pej.PriceType);
            paramView.putExtra("key_price", this.pej.PriceNum);
          }
          if (this.phh)
          {
            paramView = com.tencent.mm.emoji.b.d.fVd;
            com.tencent.mm.emoji.b.d.lA(6);
          }
          cdQ();
          this.pgj = 6;
          cdL();
          com.tencent.mm.plugin.report.service.h.wUl.f(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.pgS), "", this.pbW, Long.valueOf(this.pbb), this.pbc });
        } while (this.pbh == null);
        this.pbh.dHA = 4;
        this.pbh.aHZ();
        AppMethodBeat.o(109019);
        return;
      case 5: 
        this.pgj = 3;
        cdL();
        AppMethodBeat.o(109019);
        return;
      case 10: 
      case 12: 
        switch (this.pgW)
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
        ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
        AppMethodBeat.o(109019);
        return;
      }
      ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
      AppMethodBeat.o(109019);
      return;
    }
    if (i == 2131299369)
    {
      cdP();
      AppMethodBeat.o(109019);
      return;
    }
    if (i == 2131299360)
    {
      cdP();
      AppMethodBeat.o(109019);
      return;
    }
    ac.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
    AppMethodBeat.o(109019);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109010);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.agM())
    {
      finish();
      AppMethodBeat.o(109010);
      return;
    }
    this.pgU = u.axK();
    this.pbf = new com.tencent.mm.plugin.emoji.h.c(2003);
    paramBundle = getIntent();
    this.pbW = getIntent().getStringExtra("extra_id");
    this.pdR = getIntent().getIntExtra("preceding_scence", -1);
    this.pbX = getIntent().getStringExtra("extra_name");
    this.pgf = getIntent().getIntExtra("call_by", -1);
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.pbW = EmojiLogic.XT((String)localObject);
      this.pdR = 0;
      this.pdR = 10;
      com.tencent.mm.plugin.report.service.h.wUl.f(10993, new Object[] { Integer.valueOf(3), this.pbW });
    }
    if (TextUtils.isEmpty(this.pbW))
    {
      ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.pdR == -1)
    {
      ac.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.phd = paramBundle.getBooleanExtra("check_clickflag", true);
    this.pgT = paramBundle.getStringExtra("cdn_client_id");
    this.pgS = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.phh = paramBundle.getBooleanExtra("from_popup", false);
    this.pbb = paramBundle.getLongExtra("searchID", 0L);
    this.pbc = bs.bG(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pej.PackCopyright = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pej.CoverUrl = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pej.PackDesc = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pej.PackPrice = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.pej.PackType = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.pej.PackFlag = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pej.PriceType = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pej.PriceNum = ((String)localObject);
    }
    if (this.pgU)
    {
      this.pgV = 11;
      com.tencent.mm.pluginsdk.model.j.a(this, this.pha, this.php);
    }
    this.pgh = paramBundle.getBooleanExtra("reward_tip", false);
    paramBundle = paramBundle.getStringExtra("action_report");
    if (!bs.isNullOrNil(paramBundle)) {
      this.pbh = new w(paramBundle);
    }
    this.pha[0] = this.pbW;
    this.pej.ProductID = this.pbW;
    this.pej.PackName = this.pbX;
    this.pej.ShareDesc = this.pgg;
    this.pej.PriceNum = "-1";
    this.pej.Version = -1;
    this.mContext = this;
    phn.cnv = new WeakReference(this);
    initView();
    if (!com.tencent.mm.plugin.emoji.h.a.YB(this.pbW)) {
      if (this.pej == null)
      {
        this.pgk = new com.tencent.mm.plugin.emoji.f.l(this.pbW, this.pdR);
        com.tencent.mm.kernel.g.agQ().ghe.a(this.pgk, 0);
        if ((this.pgf == -1) || (this.pgf == 3))
        {
          this.pgr.setVisibility(8);
          this.EP.setVisibility(8);
          getString(2131755906);
          this.iFC = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(176184);
              com.tencent.mm.kernel.g.agQ().ghe.a(EmojiStoreDetailUI.o(EmojiStoreDetailUI.this));
              EmojiStoreDetailUI.p(EmojiStoreDetailUI.this).setText(2131758331);
              EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
              AppMethodBeat.o(176184);
            }
          });
        }
        cdD();
        if (!this.phd) {
          break label1051;
        }
        paramBundle = new com.tencent.mm.plugin.emoji.f.k(this.pbW);
        com.tencent.mm.kernel.g.agQ().ghe.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      cdG();
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa.add(this);
      com.tencent.mm.sdk.b.a.GpY.c(this.pdV);
      com.tencent.mm.kernel.g.agQ().ghe.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      i(this.pbW, i, j, this.pgT);
      this.phg = true;
      com.tencent.mm.plugin.report.service.h.wUl.f(12740, new Object[] { Integer.valueOf(1), "", this.pbW, "", Integer.valueOf(this.pgS), Integer.valueOf(26) });
      if ((this.pgh) && (this.pgs != null)) {
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
      if ((!bs.isNullOrNil(this.pek)) && (this.pek.equalsIgnoreCase(ab.iC(this.mContext))))
      {
        this.pgk = new com.tencent.mm.plugin.emoji.f.l(this.pbW, this.pdR, this.pej.Version);
        break;
      }
      this.pgk = new com.tencent.mm.plugin.emoji.f.l(this.pbW, this.pdR);
      break;
      label1051:
      this.phf = true;
      this.phe = EmojiLogic.ccd();
      continue;
      paramBundle = getContext();
      localObject = new EmotionDetail();
      ((EmotionDetail)localObject).ProductID = EmojiGroupInfo.Jsp;
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
      this.pej = ((EmotionDetail)localObject);
      this.phf = true;
      this.phe = EmojiLogic.ccd();
      cdF();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109016);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa.remove(this);
    com.tencent.mm.sdk.b.a.GpY.d(this.pdV);
    com.tencent.mm.kernel.g.agQ().ghe.b(822, this);
    if (this.pgz != null) {
      this.pgz.release();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(109016);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109014);
    super.onPause();
    com.tencent.mm.kernel.g.agQ().ghe.b(412, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(521, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(423, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(413, this);
    AppMethodBeat.o(109014);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109018);
    this.pgj = paramBundle.getInt("status");
    this.FG = paramBundle.getInt("progress");
    AppMethodBeat.o(109018);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109013);
    super.onResume();
    com.tencent.mm.kernel.g.agQ().ghe.a(412, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(521, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(423, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(413, this);
    this.phb = false;
    if (!this.phg)
    {
      cdD();
      Bv(1007);
    }
    cdE();
    this.phg = false;
    Bv(1001);
    AppMethodBeat.o(109013);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109017);
    paramBundle.putInt("status", this.pgj);
    paramBundle.putInt("progress", this.FG);
    AppMethodBeat.o(109017);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109020);
    ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
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
        ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
        paramString = (com.tencent.mm.plugin.emoji.f.l)paramn;
        if ((paramString != null) && (!bs.isNullOrNil(paramString.pbW)) && (paramString.pbW.equalsIgnoreCase(this.pbW)))
        {
          if (paramInt1 == 0)
          {
            if (paramInt2 == 0)
            {
              this.pej = paramString.ccC();
              Bv(1002);
              AppMethodBeat.o(109020);
              return;
            }
            if (paramInt2 == 1)
            {
              cdB();
              AppMethodBeat.o(109020);
              return;
            }
            this.pgq.setText(2131758330);
            cdC();
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 5)
          {
            if ((paramString != null) && (paramString.ccC() != null)) {
              this.pej.PackFlag = paramString.ccC().PackFlag;
            }
            Bv(1002);
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 1)
          {
            cdB();
            AppMethodBeat.o(109020);
            return;
          }
          this.pgs.setVisibility(8);
          this.EP.setVisibility(0);
          this.pgq.setText(2131758331);
          cdC();
          AppMethodBeat.o(109020);
          return;
        }
        ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
        AppMethodBeat.o(109020);
        return;
        if ((paramn instanceof com.tencent.mm.plugin.emoji.f.g))
        {
          ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
          paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
          if ((paramString == this.pgl) && (!bs.isNullOrNil(paramString.pbW)) && (paramString.pbW.equalsIgnoreCase(this.pbW)))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.pgT = paramString.hIq;
              this.pgj = 6;
              cdL();
              AppMethodBeat.o(109020);
              return;
            }
            this.pgj = -1;
            cdL();
            paramString = this.pbX;
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
          ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          AppMethodBeat.o(109020);
          return;
          ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
          paramString = (com.tencent.mm.plugin.emoji.f.k)paramn;
          if ((paramString != null) && (!bs.isNullOrNil(paramString.pbJ)) && (paramString.pbJ.equalsIgnoreCase(this.pbW))) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.phe = ((awp)paramString.rr.hvs.hvw);
              this.phf = true;
              cdM();
            }
          }
          for (;;)
          {
            this.phf = true;
            cdM();
            AppMethodBeat.o(109020);
            return;
            this.phe = null;
            break;
            ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          }
          if ((paramn instanceof com.tencent.mm.plugin.emoji.f.o))
          {
            ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.pgo = ((com.tencent.mm.plugin.emoji.f.o)paramn).ccH();
              Bv(1007);
              AppMethodBeat.o(109020);
              return;
              if (this.phi != null)
              {
                this.phi.dismiss();
                this.phi = null;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYa.aOM(((com.tencent.mm.plugin.emoji.f.q)paramn).pbW);
                this.pgj = 3;
                cdL();
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
      ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[] { Integer.valueOf(paramInt) });
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
      localEmojiInfo.field_reserved4 |= EmojiInfo.Kgm;
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
        if (!EmojiStoreDetailUI.x(EmojiStoreDetailUI.this).JyP) {
          break label154;
        }
        paramViewGroup.phs.setBackgroundResource(2131234073);
      }
      for (;;)
      {
        String str = "";
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList != null) {
          str = z.a((crm)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList.get(paramInt));
        }
        com.tencent.mm.av.o.aFB().a(str, paramViewGroup.phs, com.tencent.mm.plugin.emoji.e.e.fk(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), str));
        AppMethodBeat.o(109002);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
        label154:
        paramViewGroup.phs.setBackgroundDrawable(null);
      }
    }
  }
  
  final class b
    extends EmojiStoreDetailUI.a
  {
    private ArrayList<EmojiInfo> phr;
    
    public b()
    {
      super();
      AppMethodBeat.i(109003);
      this.phr = new ArrayList();
      this.phr = ((ArrayList)com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.XO(com.tencent.mm.plugin.emoji.h.a.cew()));
      AppMethodBeat.o(109003);
    }
    
    private EmojiInfo Bt(int paramInt)
    {
      AppMethodBeat.i(109005);
      if (this.phr == null)
      {
        AppMethodBeat.o(109005);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.phr.get(paramInt);
      AppMethodBeat.o(109005);
      return localEmojiInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109004);
      if (this.phr == null)
      {
        AppMethodBeat.o(109004);
        return 0;
      }
      int i = this.phr.size();
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
        paramViewGroup.phs.setBackgroundResource(2131234073);
        localObject = Bt(paramInt);
        if (!bs.isNullOrNil(((EmojiInfo)localObject).getContent())) {
          break label129;
        }
      }
      label129:
      for (Object localObject = ((EmojiInfo)localObject).getName();; localObject = ((EmojiInfo)localObject).getContent())
      {
        localObject = localObject.split("\\.")[0];
        com.tencent.mm.av.o.aFB().a((String)localObject, paramViewGroup.phs, com.tencent.mm.plugin.emoji.e.e.cbP());
        AppMethodBeat.o(109006);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    SquareImageView phs;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109008);
      this.phs = ((SquareImageView)paramView.findViewById(2131299047));
      this.phs.setScaleType(ImageView.ScaleType.FIT_CENTER);
      AppMethodBeat.o(109008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */