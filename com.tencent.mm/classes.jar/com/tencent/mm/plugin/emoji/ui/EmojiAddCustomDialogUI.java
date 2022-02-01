package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.cc.a.b;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.dg.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.tools.b.b.a;
import com.tencent.mm.vending.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiAddCustomDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.al.g
{
  private ProgressDialog ift;
  private String jya;
  private Context mContext;
  private int mScene;
  private boolean mYq;
  private String oBk;
  private EmojiInfo oBl;
  private boolean oBm;
  private com.tencent.mm.emoji.c.d oBn;
  private com.tencent.mm.ui.widget.a.d oBo;
  private com.tencent.mm.ui.widget.a.d oBp;
  private c<com.tencent.mm.vending.e.a> oBq;
  private Runnable oBr;
  
  public EmojiAddCustomDialogUI()
  {
    AppMethodBeat.i(108842);
    this.oBr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108829);
        EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(2131758389));
        AppMethodBeat.o(108829);
      }
    };
    AppMethodBeat.o(108842);
  }
  
  private void Ug(String paramString)
  {
    AppMethodBeat.i(108849);
    if (isFinishing())
    {
      AppMethodBeat.o(108849);
      return;
    }
    this.oBp = com.tencent.mm.ui.base.h.c(this, paramString, "", true);
    this.oBp.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(190103);
        EmojiAddCustomDialogUI.this.setResult(1);
        EmojiAddCustomDialogUI.this.finish();
        AppMethodBeat.o(190103);
      }
    });
    AppMethodBeat.o(108849);
  }
  
  private static void bVZ()
  {
    AppMethodBeat.i(108846);
    Object localObject = new dg();
    ((dg)localObject).dfp.type = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    if (!((dg)localObject).dfq.dfr)
    {
      localObject = k.getEmojiStorageMgr().Fzb.eNR();
      if (localObject != null)
      {
        Iterator localIterator = ((ctv)localObject).ElD.iterator();
        while (localIterator.hasNext())
        {
          ctw localctw = (ctw)localIterator.next();
          if (localctw.ProductID.equals(String.valueOf(EmojiGroupInfo.LBO))) {
            localctw.CEo = 0;
          }
        }
      }
      k.getEmojiStorageMgr().Fzb.a((ctv)localObject);
      com.tencent.mm.cc.a.eCL();
      localObject = com.tencent.mm.cc.a.EMi;
      a.b.aEG(String.valueOf(EmojiGroupInfo.LBO));
    }
    AppMethodBeat.o(108846);
  }
  
  private void bWa()
  {
    AppMethodBeat.i(108848);
    if (isFinishing())
    {
      AppMethodBeat.o(108848);
      return;
    }
    this.oBo = com.tencent.mm.ui.base.h.b(this.mContext, 2131758413, 2131755726, 2131758337, 2131755691, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(190113);
        Object localObject = new Intent();
        com.tencent.mm.plugin.report.service.h.vKh.f(11596, new Object[] { Integer.valueOf(3) });
        ((Intent)localObject).setClass(EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this), EmojiCustomUI.class);
        ((Intent)localObject).putExtra("key_emoji_panel_type", 0);
        paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(190113);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(108840);
        EmojiAddCustomDialogUI.this.setResult(3);
        EmojiAddCustomDialogUI.this.finish();
        AppMethodBeat.o(108840);
      }
    });
    if (this.oBo != null) {
      this.oBo.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(190114);
          EmojiAddCustomDialogUI.this.setResult(3);
          EmojiAddCustomDialogUI.this.finish();
          AppMethodBeat.o(190114);
        }
      });
    }
    AppMethodBeat.o(108848);
  }
  
  private void v(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108847);
    ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.JS());
    new com.tencent.mm.emoji.sync.a(0, localArrayList).auK().a(this.oBq).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(c.a<hn> paramAnonymousa)
      {
        AppMethodBeat.i(190108);
        int i = paramAnonymousa.errType;
        int j = paramAnonymousa.errCode;
        if (j == -434)
        {
          ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
          paramAnonymousa = i.fMT;
          i.jdMethod_do(true);
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgo, Boolean.TRUE);
          EmojiAddCustomDialogUI.this.bVS();
          EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
          com.tencent.mm.plugin.report.service.h.vKh.f(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.c(EmojiAddCustomDialogUI.this)), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).JS(), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_designerID, EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_size), EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_activityid });
        }
        for (;;)
        {
          paramAnonymousa = HPQ;
          AppMethodBeat.o(190108);
          return paramAnonymousa;
          if ((i == 0) && (j == 0))
          {
            ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
            paramAnonymousa = (hn)paramAnonymousa.gUK;
            if ((paramAnonymousa != null) && (paramAnonymousa.CCD != null) && (paramAnonymousa.CCD.size() > 0))
            {
              ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramAnonymousa.CCD.size()) });
              EmojiAddCustomDialogUI.f(EmojiAddCustomDialogUI.this);
            }
            else
            {
              EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this, null);
            }
          }
          else
          {
            EmojiAddCustomDialogUI.g(EmojiAddCustomDialogUI.this);
          }
        }
      }
    });
    AppMethodBeat.o(108847);
  }
  
  protected final void bVS()
  {
    AppMethodBeat.i(108850);
    aq.az(this.oBr);
    if ((this.ift != null) && (this.ift.isShowing())) {
      this.ift.dismiss();
    }
    AppMethodBeat.o(108850);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108843);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    this.mContext = this;
    this.oBq = new c();
    this.jya = getIntent().getStringExtra("extra_id");
    this.mScene = getIntent().getIntExtra("extra_scence", -1);
    this.oBk = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.oBk == null)) {
      this.oBk = u.aqG();
    }
    this.mYq = getIntent().getBooleanExtra("extra_move_to_top", true);
    this.oBm = getIntent().getBooleanExtra("key_is_selfie", false);
    if (bt.isNullOrNil(this.jya))
    {
      ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.oBl = k.getEmojiStorageMgr().FyY.aJx(this.jya);
    com.tencent.mm.kernel.g.afA().gcy.a(423, this);
    aq.n(this.oBr, 300L);
    Object localObject = this.mContext;
    paramBundle = this.oBl;
    if (localObject == null)
    {
      ad.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108843);
      return;
    }
    if (paramBundle == null)
    {
      ad.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108843);
      return;
    }
    localObject = i.fMT;
    if (i.getKV().getBoolean("custom_full", false))
    {
      ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      bVS();
      bWa();
      com.tencent.mm.plugin.report.service.h.vKh.f(10431, new Object[] { Integer.valueOf(this.mScene), this.oBl.JS(), this.oBl.field_designerID, this.oBl.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.oBl.field_size), this.oBk, this.oBl.field_activityid });
      AppMethodBeat.o(108843);
      return;
    }
    if ((paramBundle.field_catalog == EmojiInfo.LBW) || (bt.isNullOrNil(paramBundle.field_groupId)) || (bt.kU(paramBundle.field_groupId, "capture")) || ((!bt.isNullOrNil(paramBundle.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TE(paramBundle.field_groupId))))
    {
      v(paramBundle);
      AppMethodBeat.o(108843);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.emoji.f.g(paramBundle.field_groupId, (byte)0);
    com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
    AppMethodBeat.o(108843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108844);
    com.tencent.mm.kernel.g.afA().gcy.b(423, this);
    aq.az(this.oBr);
    super.onDestroy();
    this.oBq.dead();
    if (this.oBn != null) {
      this.oBn.fSC = null;
    }
    AppMethodBeat.o(108844);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(108845);
    if (paramn.getType() == 423)
    {
      if (!(paramn instanceof com.tencent.mm.plugin.emoji.f.g))
      {
        AppMethodBeat.o(108845);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
      if ((paramString != null) && (!bt.isNullOrNil(paramString.oyw)) && (this.oBl != null) && (!bt.isNullOrNil(this.oBl.field_groupId)) && (this.oBl.field_groupId.equalsIgnoreCase(paramString.oyw)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          v(this.oBl);
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 4)
        {
          bVS();
          if (this.mScene == 0)
          {
            paramString = this.oBl.field_groupId;
            if (!isFinishing())
            {
              this.oBp = com.tencent.mm.ui.base.h.c(this, getString(2131758208), "", true);
              this.oBp.b(2131755691, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(190104);
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(190104);
                }
              });
              this.oBp.a(2131758210, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(190105);
                  Object localObject = new Intent();
                  ((Intent)localObject).setClass(EmojiAddCustomDialogUI.this, EmojiStoreDetailUI.class);
                  ((Intent)localObject).putExtra("extra_id", paramString);
                  ((Intent)localObject).putExtra("preceding_scence", 20);
                  paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(190105);
                }
              });
            }
            AppMethodBeat.o(108845);
            return;
          }
          Ug(getString(2131758208));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 8)
        {
          bVS();
          Ug(getString(2131758207));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 9)
        {
          bVS();
          Ug(getString(2131758206));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == -2)
        {
          bVS();
          Ug(getString(2131758209));
          AppMethodBeat.o(108845);
          return;
        }
        bVS();
        Ug(getString(2131758205));
        AppMethodBeat.o(108845);
        return;
      }
      ad.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(108845);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI
 * JD-Core Version:    0.7.0.1
 */